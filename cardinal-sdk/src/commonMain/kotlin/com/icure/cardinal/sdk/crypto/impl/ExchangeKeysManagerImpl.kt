package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.crypto.BaseExchangeKeysManager
import com.icure.cardinal.sdk.crypto.ExchangeKeysManager
import com.icure.cardinal.sdk.crypto.UserEncryptionKeysManager
import com.icure.cardinal.sdk.model.DataOwnerType
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.concurrent.Volatile

@InternalIcureApi
class ExchangeKeysManagerImpl(
	private val dataOwnerApi: DataOwnerApi,
	override val base: BaseExchangeKeysManager,
	private val userKeysManager: UserEncryptionKeysManager,
	private val sdkScope: CoroutineScope
) : ExchangeKeysManager {
	// Could switch to atomic reference once not experimental
	@Volatile // delegator -> delegate -> lazy key decryption job
	private var cache: Deferred<Map<String, Map<String, Deferred<List<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>>>>> =
		sdkScope.async {
			doLoadCache()
		}
	private val errorReloadMutex = Mutex() // Used to prevent multiple reload triggered at the same time if the last cache deferred failed


	override suspend fun getDecryptionExchangeKeysFor(delegatorId: String, delegateId: String): List<AesKey<AesAlgorithm.CbcWithPkcs7Padding>> =
		getCachedValue()[delegatorId]?.get(delegateId)?.await().orEmpty()

	@OptIn(ExperimentalCoroutinesApi::class)
	private suspend fun getCachedValue(): Map<String, Map<String, Deferred<List<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>>>> {
		val currCache = cache
		return if (currCache.isCompleted) {
			if (currCache.getCompletionExceptionOrNull() != null) {
				errorReloadMutex.withLock {
					if (cache === currCache) { // only start job if no one else started it yet.
						cache = sdkScope.async(start = CoroutineStart.LAZY) { doLoadCache() }
					}
				}
				cache.await() // Important to await outside the lock. In case someone concurrently updated the cache we are going to use the deferred they created, to minimize proliferation
			} else currCache.getCompleted()
		} else currCache.await()
	}

	override fun requestCacheReload() {
		// No need to do this in mutex
		// The mutex is only used to prevent parallel request to trigger too many reloads, but in this case we're
		// forcing reload
		// By making this lazy if it is called multiple times in a short period, and there is no request that would use
		// the cache we will not start too many requests in parallel, and at the same time we will not cancel any
		// loading of caches that are already in use.
		cache = sdkScope.async(start = CoroutineStart.LAZY) {
			doLoadCache()
		}
	}

	private suspend fun doLoadCache(): Map<String, Map<String, Deferred<List<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>>>> = coroutineScope {
		val dataOwnerTypes = DataOwnerType.entries.toSet()
		val encryptedKeysDataByHierarchyMember = userKeysManager.delegatorActorHierarchy().map {
			async { base.getAllExchangeKeysWith(it, dataOwnerTypes) }
		}.awaitAll()
		val encryptedData = mutableMapOf<String, MutableMap<String, MutableList<Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>>()
		encryptedKeysDataByHierarchyMember.forEach { info ->
			info.exchangeKeysByDataOwnerTo.forEach { (delegate, encryptedEntries) ->
				encryptedData
					.getOrPut(info.dataOwnerId) { mutableMapOf() }
					.getOrPut(delegate) { mutableListOf() }
					.addAll(encryptedEntries)
			}
			info.exchangeKeysToDataOwnerFrom.forEach { (delegator, encryptedEntries) ->
				encryptedData
					.getOrPut(delegator) { mutableMapOf() }
					.getOrPut(info.dataOwnerId) { mutableListOf() }
					.addAll(encryptedEntries)
			}
		}
		val keys = userKeysManager.getAllDecryptionKeys()
		encryptedData.mapValues { (_, keysByDelegate) ->
			keysByDelegate.mapValues { (_, encryptedKeys) ->
				// Note: if this fails the deferred will always stay failed unless a reload is requested, but this can
				// only fail if canceled (any web requests are already done, this is only doing decryption and bad
				// decryptions are mapped in the result rather than throwing exceptions.
				// The contract of the SDK specifies that if the SDK scope is canceled then it can't be used anymore, so
				// it is ok.
				sdkScope.async(start = CoroutineStart.LAZY) {
					base.tryDecryptExchangeKeys(
						encryptedKeys,
						keys
					).successfulDecryptions
				}
			}
		}
	}
}