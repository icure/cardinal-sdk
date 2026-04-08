package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawRecoveryDataApi
import com.icure.cardinal.sdk.crypto.RecoveryDataEncryption
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataRecoveryDetails
import com.icure.cardinal.sdk.crypto.entities.RecoveryDataKey
import com.icure.cardinal.sdk.crypto.entities.RecoveryDataUseFailureReason
import com.icure.cardinal.sdk.crypto.entities.RecoveryKeyOptions
import com.icure.cardinal.sdk.crypto.entities.RecoveryKeySize
import com.icure.cardinal.sdk.crypto.entities.RecoveryResult
import com.icure.cardinal.sdk.model.RecoveryData
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.utils.LongPollingUtils
import com.icure.cardinal.sdk.utils.base64Encode
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.cardinal.sdk.utils.decode
import com.icure.cardinal.sdk.utils.getLogger
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesService
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.kryptom.utils.toHexString
import com.icure.utils.InternalIcureApi
import io.ktor.utils.io.CancellationException
import io.ktor.utils.io.charsets.Charsets
import io.ktor.utils.io.core.toByteArray
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.time.Duration.Companion.seconds


// Keep name of parameters for compatibility with typescript SDK
@Serializable
private data class DelegateKeyPairInfo(
	val pair: KeyPair,
	val algorithm: ShaVersion
) {
	@Serializable
	data class KeyPair(
		val publicKey: Base64String,
		val privateKey: Base64String
	)

	@Serializable
	enum class ShaVersion {
		@SerialName("sha-1")
		SHA1,
		@SerialName("sha-256")
		SHA256
	}
}

private val log = getLogger("RecoveryDataEncryption")

@OptIn(InternalIcureApi::class)
class RecoveryDataEncryptionImpl(
	private val primitives: CryptoService,
	defaultRawApiConfig: RawApiConfig,
	createRawApi: (RawApiConfig) -> RawRecoveryDataApi
) : RecoveryDataEncryption {

	override val raw = createRawApi(defaultRawApiConfig)
	private val rawForLongPolling = if (defaultRawApiConfig.requestTimeout?.let { it.inWholeSeconds >= MAX_WAIT_DURATION_S + REQUEST_TIMEOUT_MARGIN_S } != false) {
		raw
	} else {
		createRawApi(defaultRawApiConfig.copy(requestTimeout = (MAX_WAIT_DURATION_S + REQUEST_TIMEOUT_MARGIN_S).seconds))
	}

	override suspend fun recoveryKeyToId(recoveryKey: RecoveryDataKey): String =
		primitives.digest.sha256(recoveryKey.asRawBytes()).toHexString()

	override suspend fun createAndSaveKeyPairsRecoveryDataFor(
		recipient: String,
		keyPairs: Map<String, List<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>>,
		lifetimeSeconds: Int?,
		recoveryKeyOptions: RecoveryKeyOptions?
	): RecoveryDataKey {
		val content: Map<String, List<DelegateKeyPairInfo>> = keyPairs.mapValues { (_, delegateKeypairs) ->
			delegateKeypairs.map { keypair ->
				DelegateKeyPairInfo(
					pair = DelegateKeyPairInfo.KeyPair(
						publicKey = primitives.rsa.exportPublicKeySpki(keypair.public).base64Encode(),
						privateKey = primitives.rsa.exportPrivateKeyPkcs8(keypair.private).base64Encode()
					),
					algorithm = when (keypair.algorithm) {
						RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256 -> DelegateKeyPairInfo.ShaVersion.SHA256
						RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1 -> DelegateKeyPairInfo.ShaVersion.SHA1
					}
				)
			}
		}
		return createRecoveryData(recipient, RecoveryData.Type.KeypairRecovery, lifetimeSeconds, Json.encodeToJsonElement(content), recoveryKeyOptions)
	}

	override suspend fun getAndDecryptKeyPairsRecoveryData(
		recoveryKey: RecoveryDataKey,
		autoDelete: Boolean
	): RecoveryResult<Map<String, Map<SpkiHexString, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>>> =
		doGetAndDecryptKeyPairsRecoveryData(recoveryKey, autoDelete, null)

	override suspend fun waitAndDecryptKeyPairsRecoveryData(
		recoveryKey: RecoveryDataKey,
		autoDelete: Boolean,
		waitSeconds: Int
	): RecoveryResult<Map<String, Map<SpkiHexString, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>>> =
		doGetAndDecryptKeyPairsRecoveryData(recoveryKey, autoDelete, waitSeconds)

	private suspend fun doGetAndDecryptKeyPairsRecoveryData(
		recoveryKey: RecoveryDataKey,
		autoDelete: Boolean,
		waitingSeconds: Int?
	) = getRecoveryDataAndDecrypt(recoveryKey, RecoveryData.Type.KeypairRecovery, waitingSeconds) {
		val decoded: Map<String, List<DelegateKeyPairInfo>> = Json.decodeFromJsonElement(it)
		decoded.mapValues { (_, delegateKeypairs) ->
			delegateKeypairs.map { delegateKeyPairInfo ->
				val algorithm = when (delegateKeyPairInfo.algorithm) {
					DelegateKeyPairInfo.ShaVersion.SHA256 -> RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256
					DelegateKeyPairInfo.ShaVersion.SHA1 -> RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1
				}
				val declaredSpki = delegateKeyPairInfo.pair.publicKey.decode()
				val keypair = primitives.rsa.loadKeyPairPkcs8(algorithm, delegateKeyPairInfo.pair.privateKey.decode())
				val obtainedSpki = primitives.rsa.exportPublicKeySpki(keypair.public).toList()
				if (declaredSpki.toList() != obtainedSpki) throw SerializationException(
					"Deserialized public key does not match the private key."
				)
				SpkiHexString(declaredSpki.toHexString()) to keypair
			}.toMap()
		}
	}.also {
		if (autoDelete && it.isSuccess) kotlin.runCatching {
			raw.deleteRecoveryData(recoveryKeyToId(recoveryKey))
		}.onFailure { e ->
			if (e !is CancellationException) log.w { "Failed to auto-delete recovery data after successful recovery, id=${recoveryKeyToId(recoveryKey)}" }
		}
	}

	override suspend fun createAndSaveExchangeDataRecoveryData(
		recipient: String,
		exchangeDataInfo: List<ExchangeDataRecoveryDetails>,
		lifetimeSeconds: Int?,
		recoveryKeyOptions: RecoveryKeyOptions?
	): RecoveryDataKey =
		createRecoveryData(
			recipient,
			RecoveryData.Type.ExchangeKeyRecovery,
			lifetimeSeconds,
			Json.encodeToJsonElement(exchangeDataInfo),
			recoveryKeyOptions
		)

	override suspend fun getAndDecryptExchangeDataRecoveryData(
		recoveryKey: RecoveryDataKey
	): RecoveryResult<List<ExchangeDataRecoveryDetails>> =
		getRecoveryDataAndDecrypt(recoveryKey, RecoveryData.Type.ExchangeKeyRecovery, null) {
			Json.decodeFromJsonElement(it)
		}

	private suspend fun createRecoveryData(
		recipient: String,
		type: RecoveryData.Type,
		lifetimeSeconds: Int?,
		content: JsonElement,
		recoveryKeyOptions: RecoveryKeyOptions?
	): RecoveryDataKey {
		val recoveryKeyAes = when (val options = recoveryKeyOptions ?: RecoveryKeyOptions.Generate(recoveryKeySize = RecoveryKeySize.Bytes32)) {
			is RecoveryKeyOptions.Generate -> primitives.aes.generateKey(
				AesAlgorithm.CbcWithPkcs7Padding,
				when (options.recoveryKeySize) {
					RecoveryKeySize.Bytes16 -> AesService.KeySize.Aes128
					RecoveryKeySize.Bytes32 -> AesService.KeySize.Aes256
				}
			)
			is RecoveryKeyOptions.Use -> primitives.aes.loadKey(
				AesAlgorithm.CbcWithPkcs7Padding,
				options.key.asRawBytes()
			)
		}
		val recoveryKey = RecoveryDataKey.fromRawBytes(primitives.aes.exportKey(recoveryKeyAes))
		val id = recoveryKeyToId(recoveryKey)
		val encryptedSelf =
			primitives.aes.encrypt(
				content.toString().toByteArray(Charsets.UTF_8),
				recoveryKeyAes
			).base64Encode()
		val expirationInstant = lifetimeSeconds?.let { currentEpochMs() + it * 1000L }
		val data = RecoveryData(
			id = id,
			encryptedSelf = encryptedSelf,
			expirationInstant = expirationInstant,
			recipient = recipient,
			type = type
		)
		val createResult = raw.createRecoveryData(data)
		if (createResult.status.value == 409 && recoveryKeyOptions is RecoveryKeyOptions.Use) throw IllegalArgumentException(
			"Invalid RecoveryKeyOptions.Use value; key is already in use"
		)
		createResult.successBody() // ensure successful
		return recoveryKey
	}

	private suspend fun <T: Any> getRecoveryDataAndDecrypt(
		recoveryKey: RecoveryDataKey,
		expectedType: RecoveryData.Type,
		waitingSeconds: Int?,
		decode: suspend (JsonElement) -> T
	): RecoveryResult<T> {
		val id = recoveryKeyToId(recoveryKey)
		val getResult =
			if (waitingSeconds == null)
				raw.getRecoveryData(id)
			else
				LongPollingUtils.doLongPoll(
					LongPollingUtils.splitForRequestsDuration(waitingSeconds, MAX_WAIT_DURATION_S),
					request = { rawForLongPolling.getRecoveryDataWaiting(id, it) },
					shouldRetry = { it.status.value == 404 }
				)
		return when (getResult.status.value) {
			404 -> RecoveryResult.Failure(RecoveryDataUseFailureReason.Missing)
			403 -> RecoveryResult.Failure(RecoveryDataUseFailureReason.Unauthorized)
			else -> getResult.successBody().let {
				if (it.type != expectedType) {
					RecoveryResult.Failure(RecoveryDataUseFailureReason.InvalidType)
				} else {
					// Can fail with exception isntead of "RecoveryResult.Failure" if the recovery key does not match
					// what was used to encrypt the content but is accceptable since the recovery data id is obtained
					// from the encryption key that should have been used
					val decrypted =
						primitives.aes.decrypt(it.encryptedSelf.decode(), recoveryKey.loadAesKey(primitives))
					val decryptedUtf8 = decrypted.decodeToString()
					try {
						RecoveryResult.Success(decode(Json.parseToJsonElement(decryptedUtf8)))
					} catch (e: SerializationException) {
						RecoveryResult.Failure(RecoveryDataUseFailureReason.InvalidContent)
					}
				}
			}
		}
	}

	override suspend fun generateNewKey(size: RecoveryKeySize): RecoveryDataKey =
		RecoveryDataKey.fromRawBytes(
			primitives.strongRandom.randomBytes(
				when (size) {
					RecoveryKeySize.Bytes16 -> 16
					RecoveryKeySize.Bytes32 -> 32
				}
			)
		)

	companion object {
		// As configured on backend
		private const val MAX_WAIT_DURATION_S = 30

		private const val REQUEST_TIMEOUT_MARGIN_S = 5
	}
}