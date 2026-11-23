package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.crypto.entities.DataOwnerExchangeKeys
import com.icure.cardinal.sdk.crypto.entities.DecryptionResult
import com.icure.cardinal.sdk.crypto.entities.RsaDecryptionKeysSet
import com.icure.cardinal.sdk.crypto.fake.FakeUserEncryptionKeysManager
import com.icure.cardinal.sdk.crypto.fake.NoDataOwnerApi
import com.icure.cardinal.sdk.crypto.impl.ExchangeKeysManagerImpl
import com.icure.cardinal.sdk.model.DataOwnerType
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.utils.InternalIcureApi
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.yield

private const val SELF_ID = "self"
private const val OTHER_ID = "other"

private class SimulatedLoadFailure(message: String) : Exception(message)

@OptIn(InternalIcureApi::class)
private class FakeBaseExchangeKeysManager(
	private val keyToReturn: AesKey<AesAlgorithm.CbcWithPkcs7Padding>
) : BaseExchangeKeysManager {
	/**
	 * If not null the next loads will suspend until this is completed.
	 */
	@kotlin.concurrent.Volatile
	var gate: CompletableDeferred<Unit>? = null

	@kotlin.concurrent.Volatile
	var shouldFail = true

	@kotlin.concurrent.Volatile
	var loadAttempts = 0
		private set

	private val encryptedKey = mapOf(AesExchangeKeyEncryptionKeypairIdentifier("fp") to HexString("abcd"))

	override suspend fun getAllExchangeKeysWith(dataOwnerId: String, otherOwnerTypes: Set<DataOwnerType>): DataOwnerExchangeKeys {
		val attempt = ++loadAttempts
		gate?.await()
		if (shouldFail) throw SimulatedLoadFailure("Simulated load failure #$attempt")
		return DataOwnerExchangeKeys(
			dataOwnerId = dataOwnerId,
			exchangeKeysByDataOwnerTo = mapOf(OTHER_ID to listOf(encryptedKey)),
			exchangeKeysToDataOwnerFrom = emptyMap()
		)
	}

	override suspend fun tryDecryptExchangeKeys(
		encryptedExchangeKeys: List<Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>,
		keyPairsByFingerprint: RsaDecryptionKeysSet
	): DecryptionResult<Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>, AesKey<AesAlgorithm.CbcWithPkcs7Padding>> =
		DecryptionResult(emptyList(), encryptedExchangeKeys.map { keyToReturn })

	override suspend fun giveAccessBackTo(
		otherDataOwner: String,
		newDataOwnerPublicKey: SpkiHexString,
		keyPairsByFingerprint: RsaDecryptionKeysSet
	) = TODO("Not needed")

	override suspend fun getEncryptedExchangeKeysFor(
		delegatorId: String,
		delegateId: String
	): List<Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> = TODO("Not needed")
}

@OptIn(InternalIcureApi::class)
class ExchangeKeysManagerUnitTests : StringSpec({
	suspend fun withManager(
		configureBase: (FakeBaseExchangeKeysManager) -> Unit,
		block: suspend (manager: ExchangeKeysManagerImpl, base: FakeBaseExchangeKeysManager, key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>) -> Unit
	) {
		val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
		try {
			val key = defaultCryptoService.aes.generateKey(AesAlgorithm.CbcWithPkcs7Padding)
			val base = FakeBaseExchangeKeysManager(key).also(configureBase)
			val manager = ExchangeKeysManagerImpl(
				dataOwnerApi = NoDataOwnerApi,
				base = base,
				userKeysManager = FakeUserEncryptionKeysManager(SELF_ID),
				sdkScope = scope,
			)
			block(manager, base, key)
		} finally {
			scope.cancel()
		}
	}

	"Failure of an in-progress load should be propagated to all requests waiting for it" {
		val gate = CompletableDeferred<Unit>()
		withManager({ it.gate = gate }) { manager, base, _ ->
			coroutineScope {
				val waiting = List(3) {
					async { runCatching { manager.getDecryptionExchangeKeysFor(SELF_ID, OTHER_ID) } }
				}
				while (base.loadAttempts == 0) yield()
				gate.complete(Unit)
				waiting.forEach { result ->
					val failure = result.await().exceptionOrNull()
					(failure is SimulatedLoadFailure) shouldBe true
					failure?.message shouldBe "Simulated load failure #1"
				}
			}
			base.loadAttempts shouldBe 1
		}
	}

	"A failed load should not be cached: the next request should immediately retry the load" {
		withManager({}) { manager, base, key ->
			shouldThrow<SimulatedLoadFailure> { manager.getDecryptionExchangeKeysFor(SELF_ID, OTHER_ID) }
			base.loadAttempts shouldBe 1
			shouldThrow<SimulatedLoadFailure> { manager.getDecryptionExchangeKeysFor(SELF_ID, OTHER_ID) }.message shouldBe "Simulated load failure #2"
			base.loadAttempts shouldBe 2
			base.shouldFail = false
			manager.getDecryptionExchangeKeysFor(SELF_ID, OTHER_ID) shouldBe listOf(key)
			base.loadAttempts shouldBe 3
			// Successful load is cached
			manager.getDecryptionExchangeKeysFor(SELF_ID, OTHER_ID) shouldBe listOf(key)
			base.loadAttempts shouldBe 3
		}
	}

	"Explicit cache reload request should force a new load" {
		withManager({ it.shouldFail = false }) { manager, base, key ->
			manager.getDecryptionExchangeKeysFor(SELF_ID, OTHER_ID) shouldBe listOf(key)
			base.loadAttempts shouldBe 1
			manager.requestCacheReload()
			manager.getDecryptionExchangeKeysFor(SELF_ID, OTHER_ID) shouldBe listOf(key)
			base.loadAttempts shouldBe 2
		}
	}
})
