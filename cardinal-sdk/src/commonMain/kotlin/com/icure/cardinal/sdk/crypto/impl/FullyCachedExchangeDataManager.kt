package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.crypto.BaseExchangeDataManager
import com.icure.cardinal.sdk.crypto.CryptoStrategies
import com.icure.cardinal.sdk.crypto.UserEncryptionKeysManager
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataWithPotentiallyDecryptedContent
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataWithUnencryptedContent
import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.crypto.entities.UndecryptableExchangeData
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import com.icure.cardinal.sdk.model.specializations.encodeAsAccessControlHeaders
import com.icure.cardinal.sdk.utils.ensureNonNull
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.job
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.concurrent.Volatile

@InternalIcureApi
class FullyCachedExchangeDataManager(
	base: BaseExchangeDataManager,
	userEncryptionKeys: UserEncryptionKeysManager,
	cryptoStrategies: CryptoStrategies,
	dataOwnerApi: DataOwnerApi,
	cryptoService: CryptoService,
	sdkScope: CoroutineScope,
	sdkBoundGroup: SdkBoundGroup?,
) : AbstractExchangeDataManager(
	base = base,
	userEncryptionKeys = userEncryptionKeys,
	cryptoStrategies = cryptoStrategies,
	dataOwnerApi = dataOwnerApi,
	cryptoService = cryptoService,
	sdkScope = sdkScope,
	sdkBoundGroup = sdkBoundGroup,
) {
	override fun createManagerForGroup(groupId: String?): AbstractExchangeDataManagerInGroup =
		FullyCachedExchangeDataManagerInGroup(
			base = base,
			userEncryptionKeys = userEncryptionKeys,
			cryptoStrategies = cryptoStrategies,
			dataOwnerApi = dataOwnerApi,
			cryptoService = cryptoService,
			sdkBoundGroup = sdkBoundGroup,
			sdkScope = sdkScope,
			requestGroup = groupId,
		)
}

@InternalIcureApi
private class FullyCachedExchangeDataManagerInGroup(
	base: BaseExchangeDataManager,
	userEncryptionKeys: UserEncryptionKeysManager,
	cryptoStrategies: CryptoStrategies,
	dataOwnerApi: DataOwnerApi,
	cryptoService: CryptoService,
	sdkBoundGroup: SdkBoundGroup?,
	sdkScope: CoroutineScope,
	requestGroup: String?,
) : AbstractExchangeDataManagerInGroup(
	base = base,
	userEncryptionKeys = userEncryptionKeys,
	cryptoStrategies = cryptoStrategies,
	dataOwnerApi = dataOwnerApi,
	cryptoService = cryptoService,
	sdkBoundGroup = sdkBoundGroup,
	requestGroup = requestGroup,
) {
	private class Caches(
		val dataById: Map<String, CachedExchangeDataDetails>,
		val dataByDelegationKey: Map<SecureDelegationKeyString, CachedExchangeDataDetails>,
		val verifiedDataByDelegateId: Map<String, CachedExchangeDataDetails>,
		val entityTypeToAccessControlKeysValue: Map<EntityWithEncryptionMetadataTypeName, List<Base64String>>,
	) {
		fun getEncryptionDataTo(delegateReferenceString: String): ExchangeDataWithUnencryptedContent? =
			verifiedDataByDelegateId[delegateReferenceString]?.let { data ->
				ExchangeDataWithUnencryptedContent(
					data.exchangeData,
					ensureNonNull(data.decryptedDetails) {
						"Decrypted details of cached verified data can't be null"
					}.decryptedContent,
				)
			}
	}

	private val cacheUpdateAndNewDataCreationScope = CoroutineScope(Dispatchers.Default + SupervisorJob(sdkScope.coroutineContext.job))

	@Volatile
	private var caches: Deferred<Caches> = cacheUpdateAndNewDataCreationScope.async { getAllKeysInfo() }
	private val creationJobs = mutableMapOf<String, Deferred<ExchangeDataWithUnencryptedContent>>()

	// No need to keep two different mutexes for creation job and reload of caches in case of error.
	// If caches is successful once then it can never become failed.
	// If caches is failed or incomplete then we don't start any creation job until it completes successfully
	private val creationAndCachesErrorReloadMutex = Mutex()

	@OptIn(ExperimentalCoroutinesApi::class)
	private suspend fun getCachesAndAwaited(): Pair<Deferred<Caches>, Caches> { // promise to contained value
		val currCache = caches
		return if (currCache.isCompleted) {
			if (currCache.getCompletionExceptionOrNull() != null) {
				// If cache failed with an exception we have to reload
				creationAndCachesErrorReloadMutex.withLock {
					if (caches === currCache) { // Only start job if no one else started it yet.
						cacheUpdateAndNewDataCreationScope.async { getAllKeysInfo() }.also { caches = it }
					} else caches// Else wait on the job the others have just started. Ok to fail if that fails.
				}.let { Pair(it, it.await()) } // Important to await outside the lock
			} else Pair(currCache, currCache.getCompleted())
		} else Pair(currCache, currCache.await())
	}

	override suspend fun getOrCreateEncryptionDataTo(
		delegateReference: EntityReferenceInGroup,
		allowCreationWithoutDelegateKey: Boolean,
		allowCreationWithoutDelegatorKey: Boolean,
	): ExchangeDataWithUnencryptedContent {
		val delegateReferenceString = delegateReference.asReferenceStringInGroup(requestGroup, sdkBoundGroup)
		val (currCachesDeferred, awaitedCaches) = getCachesAndAwaited()
		return awaitedCaches.getEncryptionDataTo(delegateReferenceString)
			?: awaitOrStartExchangeDataCreationJob(
				checkedCachesDeferred = currCachesDeferred,
				delegateReference = delegateReference,
				delegateReferenceString = delegateReferenceString,
				allowCreationWithoutDelegateKey = allowCreationWithoutDelegateKey,
				allowCreationWithoutDelegatorKey = allowCreationWithoutDelegatorKey
			)
	}

	private suspend fun awaitOrStartExchangeDataCreationJob(
		checkedCachesDeferred: Deferred<Caches>,
		delegateReference: EntityReferenceInGroup,
		delegateReferenceString: String,
		allowCreationWithoutDelegateKey: Boolean,
		allowCreationWithoutDelegatorKey: Boolean,
		): ExchangeDataWithUnencryptedContent {
		val (shouldRetryIfFailure, creationJob) = creationAndCachesErrorReloadMutex.withLock {
			val existingJob = creationJobs[delegateReferenceString]
			when {
				existingJob == null -> Pair(
					false,
					startCreationJob(checkedCachesDeferred, delegateReference, delegateReferenceString, allowCreationWithoutDelegateKey, allowCreationWithoutDelegatorKey).also {
						creationJobs[delegateReferenceString] = it
					},
				)

				existingJob.isCompleted -> Pair(true, existingJob)
				else -> Pair(false, existingJob)
			}
		}
		return if (shouldRetryIfFailure) {
			try {
				creationJob.await()
			} catch (_: Throwable) {
				creationAndCachesErrorReloadMutex.withLock {
					val updatedExistingJob = creationJobs[delegateReferenceString]
					// If updated existing job became null it should mean someone will have updated the caches with the new encryption-to data
					// We will start a very short-lived job that will just get the value from the updated caches without creating anything new
					if (updatedExistingJob == null || updatedExistingJob === creationJob) { // only start job if no one else started it yet.
						startCreationJob(
							checkedCachesDeferred = checkedCachesDeferred,
							delegateReference = delegateReference,
							delegateReferenceString = delegateReferenceString,
							allowCreationWithoutDelegateKey = allowCreationWithoutDelegateKey,
							allowCreationWithoutDelegatorKey = allowCreationWithoutDelegatorKey
						).also {
							creationJobs[delegateReferenceString] = it
						}
					} else updatedExistingJob // Else wait on the job the others have just started. Ok to fail if that fails.
				}.await()
			}
		} else {
			creationJob.await()
		}
	}

	private fun startCreationJob(
		checkedCachesDeferred: Deferred<Caches>,
		delegateReference: EntityReferenceInGroup,
		delegateReferenceString: String,
		allowCreationWithoutDelegateKey: Boolean,
		allowCreationWithoutDelegatorKey: Boolean,
		) = cacheUpdateAndNewDataCreationScope.async {
		// It could be possible that the caches have been updated between the last time we tried and the
		// time we got the lock.
		// In case they changed we need to check again.
		caches.takeIf { it !== checkedCachesDeferred }?.await()?.getEncryptionDataTo(delegateReferenceString)?.also {
			creationAndCachesErrorReloadMutex.withLock {
				@Suppress("DeferredResultUnused")
				creationJobs.remove(delegateReferenceString)
			}
		} ?: doCreateAndCacheEncryptionDataTo(
			delegateReference = delegateReference,
			delegateReferenceString = delegateReferenceString,
			allowCreationWithoutDelegateKey = allowCreationWithoutDelegateKey,
			allowCreationWithoutDelegatorKey = allowCreationWithoutDelegatorKey,
		)
	}

	private suspend fun doCreateAndCacheEncryptionDataTo(
		delegateReference: EntityReferenceInGroup,
		delegateReferenceString: String,
		allowCreationWithoutDelegateKey: Boolean,
		allowCreationWithoutDelegatorKey: Boolean,
	): ExchangeDataWithUnencryptedContent = createNewExchangeData(
		delegateReference,
		null,
		allowCreationWithoutDelegateKey,
		allowCreationWithoutDelegatorKey,
	).also { created ->
		creationAndCachesErrorReloadMutex.withLock {
			val prevCaches = caches
			caches = cacheUpdateAndNewDataCreationScope.async {
				val awaitedPrevCaches = prevCaches.await()
				val secureDelegationKeys = created.unencryptedContent.accessControlSecret
					.allAccessControlKeys(cryptoService)
					.mapTo(mutableSetOf()) { it.toSecureDelegationKeyString(cryptoService) }
				val cachedDetails = CachedExchangeDataDetails(
					created.exchangeData,
					CachedDecryptedDetails(
						created.unencryptedContent,
						true,
						secureDelegationKeys,
					),
				)
				cachesFrom(
					dataById = awaitedPrevCaches.dataById + (created.exchangeData.id to cachedDetails),
					verifiedDataByDelegateId = awaitedPrevCaches.verifiedDataByDelegateId + (delegateReferenceString to cachedDetails),
					dataByDelegationKey = awaitedPrevCaches.dataByDelegationKey + secureDelegationKeys.associateWith { cachedDetails },
				)
			}
			@Suppress("DeferredResultUnused")
			creationJobs.remove(delegateReferenceString)
		}
	}

	override suspend fun getCachedDecryptionDataKeyByAccessControlHash(
		hashes: Set<SecureDelegationKeyString>,
	): Map<SecureDelegationKeyString, ExchangeDataWithUnencryptedContent> =
		caches.await().let {
			hashes.mapNotNull { hash ->
				it.dataByDelegationKey[hash]?.let { data ->
					hash to ExchangeDataWithUnencryptedContent(
						data.exchangeData,
						ensureNonNull(data.decryptedDetails) {
							"Decrypted details of data cached by hash can't be null"
						}.decryptedContent,
					)
				}
			}.toMap()
		}

	override suspend fun getDecryptionDataByIds(
		ids: Set<String>,
		waitOrRetrieveUncached: Boolean,
	): Map<String, ExchangeDataWithPotentiallyDecryptedContent> =
		caches.await().let {
			ids.mapNotNull { id ->
				it.dataById[id]?.let { data ->
					if (data.decryptedDetails != null) {
						id to ExchangeDataWithUnencryptedContent(
							data.exchangeData,
							data.decryptedDetails.decryptedContent,
						)
					} else {
						id to UndecryptableExchangeData(data.exchangeData)
					}
				}
			}.toMap()
		}

	override suspend fun getEncodedAccessControlKeysValue(entityType: EntityWithEncryptionMetadataTypeName): List<Base64String> =
		caches.await().let { it.entityTypeToAccessControlKeysValue.getValue(entityType) }

	override suspend fun cacheInjectedExchangeData(exchangeDataDetails: List<Pair<ExchangeDataWithUnencryptedContent, Boolean>>) {
		val exchangeDataDetailsMap = exchangeDataDetails.associate { (data, isVerified) ->
			val secureDelegationKeys = data.unencryptedContent.accessControlSecret.allAccessControlKeys(cryptoService)
				.map { it.toSecureDelegationKeyString(cryptoService) }.toSet()

			data.exchangeData.id to CachedExchangeDataDetails(
				data.exchangeData,
				CachedDecryptedDetails(
					data.unencryptedContent, isVerified,
					secureDelegationKeys,
				),
			)
		}

		creationAndCachesErrorReloadMutex.withLock {
			val currCaches = caches
			cacheUpdateAndNewDataCreationScope.async {
				println("Updating caches with injected exchange data: ${exchangeDataDetailsMap.keys}")
				val awaited = currCaches.await()
				cachesFrom(
					dataById = awaited.dataById + exchangeDataDetailsMap,
					dataByDelegationKey = awaited.dataByDelegationKey + exchangeDataDetailsMap.values
						.flatMap { it.decryptedDetails?.secureDelegationKeys?.map { k -> k to it } ?: emptyList() }
						.associate { it },
					verifiedDataByDelegateId = awaited.verifiedDataByDelegateId + exchangeDataDetailsMap.values.filter {
						it.decryptedDetails?.verified == true &&
							it.exchangeData.delegator == userEncryptionKeys.delegatorActorReferenceString()
						}
						.associateBy { it.exchangeData.delegate },
				)
			}.also { caches = it }
		}.await()
	}

	override fun dispose() {
		cacheUpdateAndNewDataCreationScope.cancel()
	}

	private suspend fun getAllKeysInfo(): Caches {
		val cacheById = mutableMapOf<String, CachedExchangeDataDetails>()
		val cacheByHash = mutableMapOf<SecureDelegationKeyString, CachedExchangeDataDetails>()
		val cacheByDelegateId = mutableMapOf<String, CachedExchangeDataDetails>()
		base.getAllExchangeDataForDataOwner(userEncryptionKeys.delegatorActorId(), requestGroup).forEach { exchangeData ->
			val decryptedInfo = decryptData(exchangeData)
			if (decryptedInfo != null) {
				val secureDelegationKeys = decryptedInfo.first.accessControlSecret
					.allAccessControlKeys(cryptoService)
					.mapTo(mutableSetOf()) { it.toSecureDelegationKeyString(cryptoService) }
				val cachedDetails = CachedExchangeDataDetails(
					exchangeData,
					CachedDecryptedDetails(
						decryptedInfo.first,
						decryptedInfo.second,
						secureDelegationKeys,
					),
				)
				cacheById[exchangeData.id] = cachedDetails
				secureDelegationKeys.forEach {
					cacheByHash[it] = cachedDetails
				}
				if (decryptedInfo.second && exchangeData.delegator == userEncryptionKeys.delegatorActorReferenceString()) {
					cacheByDelegateId[exchangeData.delegate] = cachedDetails
				}
			} else {
				cacheById[exchangeData.id] = CachedExchangeDataDetails(exchangeData, null)
			}
		}
		return cachesFrom(cacheById, cacheByHash, cacheByDelegateId)
	}

	private suspend fun cachesFrom(
		dataById: Map<String, CachedExchangeDataDetails>,
		dataByDelegationKey: Map<SecureDelegationKeyString, CachedExchangeDataDetails>,
		verifiedDataByDelegateId: Map<String, CachedExchangeDataDetails>,
	) = Caches(
		dataById,
		dataByDelegationKey,
		verifiedDataByDelegateId,
		dataById.values.mapNotNull { it.decryptedDetails?.decryptedContent?.accessControlSecret }.let { allAccessControlSecrets ->
			EntityWithEncryptionMetadataTypeName.entries.associateWith {
				allAccessControlSecrets.map { s -> s.toAccessControlKeyStringFor(it, cryptoService) }.encodeAsAccessControlHeaders()
			}
		},
	)

	private fun UserEncryptionKeysManager.delegatorActorReferenceString() =
		EntityReferenceInGroup(
			entityId = delegatorActorId(),
			groupId = null,
		).asReferenceStringInGroup(
			requestGroup,
			sdkBoundGroup,
		)
}
