package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.crypto.BaseExchangeDataManager
import com.icure.cardinal.sdk.crypto.CryptoStrategies
import com.icure.cardinal.sdk.crypto.UserEncryptionKeysManager
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataWithPotentiallyDecryptedContent
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataWithUnencryptedContent
import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.crypto.entities.UndecryptableExchangeData
import com.icure.cardinal.sdk.crypto.entities.UnencryptedExchangeDataContent
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.ExchangeData
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import com.icure.cardinal.sdk.utils.LruCache
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.job
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

@InternalIcureApi
class CachedLruExchangeDataManager(
	base: BaseExchangeDataManager,
	userEncryptionKeys: UserEncryptionKeysManager,
	cryptoStrategies: CryptoStrategies,
	dataOwnerApi: DataOwnerApi,
	cryptoService: CryptoService,
	sdkScope: CoroutineScope,
	sdkBoundGroup: SdkBoundGroup?
) : AbstractExchangeDataManager(
	base,
	userEncryptionKeys,
	cryptoStrategies,
	dataOwnerApi,
	cryptoService,
	sdkScope,
	sdkBoundGroup
) {
	override fun createManagerForGroup(groupId: String?): AbstractExchangeDataManagerInGroup =
		CachedLruExchangeDataManagerInGroup(
			base = base,
			userEncryptionKeys = userEncryptionKeys,
			cryptoStrategies = cryptoStrategies,
			dataOwnerApi = dataOwnerApi,
			cryptoService = cryptoService,
			sdkBoundGroup = sdkBoundGroup,
			sdkScope = sdkScope,
			requestGroup = groupId,
			maxCacheSize = 500
		)
}

@InternalIcureApi
private class CachedLruExchangeDataManagerInGroup(
	base: BaseExchangeDataManager,
	userEncryptionKeys: UserEncryptionKeysManager,
	cryptoStrategies: CryptoStrategies,
	dataOwnerApi: DataOwnerApi,
	cryptoService: CryptoService,
	sdkBoundGroup: SdkBoundGroup?,
	sdkScope: CoroutineScope,
	requestGroup: String?,
	private val maxCacheSize: Int
) : AbstractExchangeDataManagerInGroup(
	base = base,
	userEncryptionKeys = userEncryptionKeys,
	cryptoStrategies = cryptoStrategies,
	dataOwnerApi = dataOwnerApi,
	cryptoService = cryptoService,
	sdkBoundGroup = sdkBoundGroup,
	requestGroup = requestGroup
) {
	// TODO test that even with small cache everything works fine.

	/*
	 * If baseScope is canceled, this scope is also canceled, but this can be canceled independently of base scope (has
	 * baseScope job as parent, and baseScope has SupervisorJob)
	 * A job failing shouldn't cause all other jobs to fail. (SupervisorJob)
	 * Limited parallelism 1 needed by implementation of cache to ensure consistency.
	 */
	private val cacheRequestsScope = CoroutineScope(
		Dispatchers.Default.limitedParallelism(1) + SupervisorJob(sdkScope.coroutineContext.job)
	)
	/*
	 * Note: currently keeps in cache also failed jobs, in future should maybe evict failed jobs as soon as they fail.
	 */
	private val exchangeDataByIdCache: LruCache<String, Deferred<CachedExchangeDataDetails?>> =
		LruCache(maxCacheSize.coerceAtLeast(1)) // If cache is not at least 1 stuff is going to behave weird
	private val delegateToVerifiedExchangeDataId =
		mutableMapOf<String, Deferred<String>>()
	private val secureDelegationKeysToExchangeDataId =
		mutableMapOf<SecureDelegationKeyString, String>()

	/*
	 * If the cache mutex becomes a bottleneck in services we can try to instead have the cache read be free of lock,
	 * and the updates to used time be added to a queue that will be processed by a separate thread. This thread would
	 * also be the only one that starts requests in case data is not available.
	 */
	private val cacheMutex = Mutex()

	@OptIn(ExperimentalCoroutinesApi::class)
	private fun cacheMainInfoJobMustHaveLock(
		id: String,
		job: Deferred<CachedExchangeDataDetails?>
	) {
		exchangeDataByIdCache.set(id, job)
		if (exchangeDataByIdCache.size > maxCacheSize) {
			exchangeDataByIdCache.evictOldest()?.takeIf {
				/*
				 * If not completed, then no need to get rid of additional caches; it wasn't added yet, and won't be
				 * added by the evicted job thanks to usage of mutex + limited parallelism
				 */
				it.isCompleted
			}?.getCompleted()?.also { toEvict ->
				// Get rid of additional caches
				if (toEvict.decryptedDetails?.secureDelegationKeys?.isNotEmpty() == true) {
					secureDelegationKeysToExchangeDataId -= toEvict.decryptedDetails.secureDelegationKeys
				}
				val entryForDelegate = delegateToVerifiedExchangeDataId[toEvict.exchangeData.id]
				// If entryForDelegate points to the exchange data to evict, it will be completed
				if (entryForDelegate?.isCompleted == true && entryForDelegate.getCompleted() == toEvict.exchangeData.id) {
					@Suppress("DeferredResultUnused") // If we got here it is already completed or canceled.
					delegateToVerifiedExchangeDataId.remove(toEvict.exchangeData.delegate)
				}
			}
		}
	}

	// Must cache exchangeDataByIdCache separately
	private fun cacheAdditionalInfoMustHaveLock(
		toCache: CachedExchangeDataDetails
	) {
		// Check no one has evicted this entry before the cache additional info method has been called, else don't cache
		// additional info
		if (exchangeDataByIdCache.get(toCache.exchangeData.id) != null) {
			exchangeDataByIdCache.set(toCache.exchangeData.id, CompletableDeferred(toCache))
			if (toCache.decryptedDetails?.verified == true && delegateToVerifiedExchangeDataId[toCache.exchangeData.id]?.isCompleted != true) {
				delegateToVerifiedExchangeDataId[toCache.exchangeData.id] = CompletableDeferred(toCache.exchangeData.id)
			}
			if (toCache.decryptedDetails?.secureDelegationKeys?.isNotEmpty() == true) secureDelegationKeysToExchangeDataId.putAll(
				toCache.decryptedDetails.secureDelegationKeys.map { it to toCache.exchangeData.id }
			)
		}
	}

	@OptIn(ExperimentalCoroutinesApi::class)
	override suspend fun getOrCreateEncryptionDataTo(
		delegateReference: EntityReferenceInGroup,
		allowCreationWithoutDelegateKey: Boolean,
		allowCreationWithoutDelegatorKey: Boolean
	): ExchangeDataWithUnencryptedContent {
		// Using reference string as normalization
		val delegateReferenceString = delegateReference.asReferenceStringInGroup(requestGroup, sdkBoundGroup)
		val retrieved = cacheMutex.withLock {
			val verifiedExchangeDataIdDeferred = delegateToVerifiedExchangeDataId[delegateReferenceString]
			if (verifiedExchangeDataIdDeferred != null && (!verifiedExchangeDataIdDeferred.isCompleted || verifiedExchangeDataIdDeferred.getCompletionExceptionOrNull() == null)) {
				Pair(verifiedExchangeDataIdDeferred, null)
			} else {
				val job = cacheRequestsScope.async {
					val verifiedData = base.getExchangeDataByDelegatorDelegatePair(
						requestGroup,
						EntityReferenceInGroup(userEncryptionKeys.delegatorActorId(), null),
						delegateReference
					).firstNotNullOfOrNull { exchangeData ->
						this@async.ensureActive()
						decryptData(exchangeData)?.takeIf {
							it.second
						}?.let {
							Pair(exchangeData, it)
						}
						// Don't cache data that is going to be unused, could actually evict interesting entries
					} ?: createNewExchangeData(
						delegateReference = delegateReference,
						newDataId = null,
						allowCreationWithoutDelegateKey = allowCreationWithoutDelegateKey,
						allowCreationWithoutDelegatorKey = allowCreationWithoutDelegatorKey
					).let {
						Pair(it.exchangeData, Pair(it.unencryptedContent, true))
					}
					// Minimize expensive operations in lock: calculate hashes here
					val toCache = prepareCachedDetails(verifiedData.first, verifiedData.second)
					cacheMutex.withLock {
						cacheMainInfoJobMustHaveLock(verifiedData.first.id, CompletableDeferred(toCache))
						cacheAdditionalInfoMustHaveLock(toCache)
						Pair(
							verifiedData.first.id ,
							ExchangeDataWithUnencryptedContent(
								verifiedData.first,
								verifiedData.second.first
							)
						)
					}
				}
				delegateToVerifiedExchangeDataId[delegateReferenceString] = cacheRequestsScope.async {
					job.await().first
				}
				Pair(null, job)
			}
		}
		return if (retrieved.first != null) {
			val id = retrieved.first!!.await()
			val cachedDetails = doGetDecryptionDataByIds(setOf(id), true).getValue(id)!!
			cachedDetails.decryptedDetails?.takeIf { it.verified }?.let {
				ExchangeDataWithUnencryptedContent(
					cachedDetails.exchangeData,
					it.decryptedContent
				)
			} ?: throw AssertionError("Exchange data with id $id should be decrypted and verified")
		} else {
			retrieved.second!!.await().second
		}
	}

	override suspend fun getCachedDecryptionDataKeyByAccessControlHash(
		hashes: Set<SecureDelegationKeyString>
	): Map<SecureDelegationKeyString, ExchangeDataWithUnencryptedContent> {
		val allCachedValues = cacheMutex.withLock {
			hashes.mapNotNull { h ->
				secureDelegationKeysToExchangeDataId[h]?.let {
					exchangeDataByIdCache.get(it)
				}?.let {
					h to it
				}
			}
		}
		return allCachedValues.associate { (h, data) ->
			// If cached by hash data has already completed successfully and decrypted
			h to data.await()!!.let {
				ExchangeDataWithUnencryptedContent(it.exchangeData, it.decryptedDetails!!.decryptedContent)
			}
		}
	}

	override suspend fun getDecryptionDataByIds(
		ids: Set<String>,
		waitOrRetrieveUncached: Boolean
	): Map<String, ExchangeDataWithPotentiallyDecryptedContent> =
		doGetDecryptionDataByIds(ids, waitOrRetrieveUncached).mapNotNull { (k, v) ->
			v?.let {
				val decrypted = it.decryptedDetails?.decryptedContent
				if (decrypted != null) {
					k to ExchangeDataWithUnencryptedContent(
						it.exchangeData,
						decrypted
					)
				} else {
					k to UndecryptableExchangeData(it.exchangeData)
				}
			}
		}.toMap()

	@OptIn(ExperimentalCoroutinesApi::class)
	private suspend fun doGetDecryptionDataByIds(
		ids: Set<String>,
		waitOrRetrieveUncached: Boolean
	): Map<String, CachedExchangeDataDetails?> = cacheMutex.withLock {
		val cached = ids.mapNotNull { id ->
			exchangeDataByIdCache.get(id)?.let { result ->
				if (result.isCompleted && result.getCompletionExceptionOrNull() != null) {
					// Ignore cached and already failed jobs, and remove them from cache.
					exchangeDataByIdCache.remove(id)
					null
				} else Pair(id, result)
			}
		}.toMap()
		if (waitOrRetrieveUncached) {
			val idsToRetrieve = ids - cached.keys
			val retrieved = if (idsToRetrieve.isNotEmpty()) {
				val job = cacheRequestsScope.async {
					val retrieveAndDecryptedExchangeData = base.getExchangeDataByIds(
						requestGroup,
						idsToRetrieve
					).associate { exchangeData ->
						exchangeData.id to prepareCachedDetails(
							exchangeData,
							decryptData(exchangeData)
						)
					}
					cacheMutex.withLock {
						retrieveAndDecryptedExchangeData.values.forEach { cacheAdditionalInfoMustHaveLock(it) }
					}
					retrieveAndDecryptedExchangeData
				}
				val asIndividualJobs = idsToRetrieve.associateWith {
					cacheRequestsScope.async { job.await()[it] }
				}
				asIndividualJobs.forEach {
					cacheMainInfoJobMustHaveLock(it.key, it.value)
				}
				asIndividualJobs
			} else emptyMap()
			cached + retrieved
		} else {
			cached.filterValues { it.isCompleted }
		}
	}.mapValues { it.value.await() }

	private suspend fun prepareCachedDetails(
		exchangeData: ExchangeData,
		decryptedInfo: Pair<UnencryptedExchangeDataContent, Boolean>?
	) = CachedExchangeDataDetails(
		exchangeData,
		decryptedInfo?.let {
			CachedDecryptedDetails(
				it.first,
				it.second,
				it.first.accessControlSecret.allAccessControlKeys(cryptoService).mapTo(
					mutableSetOf()
				) { k -> k.toSecureDelegationKeyString(cryptoService) }
			)
		}
	)

	override suspend fun getEncodedAccessControlKeysValue(entityType: EntityWithEncryptionMetadataTypeName): List<Base64String>? =
		null

	override suspend fun cacheInjectedExchangeData(exchangeDataDetails: List<Pair<ExchangeDataWithUnencryptedContent, Boolean>>) {
		TODO("Not yet implemented")
	}

	override fun dispose() =
		cacheRequestsScope.cancel()
}
