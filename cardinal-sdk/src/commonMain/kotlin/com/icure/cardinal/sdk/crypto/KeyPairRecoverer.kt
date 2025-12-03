package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.crypto.entities.CardinalKeyInfo
import com.icure.cardinal.sdk.crypto.entities.RecoveryDataKey
import com.icure.cardinal.sdk.crypto.entities.RecoveryDataUseFailureReason
import com.icure.cardinal.sdk.crypto.entities.RecoveryResult
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair

/**
 * Allows to recover user keypairs using builtin recovery mechanisms.
 * This includes recovery methods that require some input from your application (e.g. a recovery key created from a different device).
 */
interface KeyPairRecoverer {
	/**
	 * Recover a keypair using a recovery key created in the past using the {@link IccRecoveryXApi.createRecoveryInfoForAvailableKeyPairs} method.
	 * @param recoveryKey the result of a past call to {@link IccRecoveryXApi.createRecoveryInfoForAvailableKeyPairs}.
	 * @param autoDelete if true, the recovery data will be deleted from the server after it could be used successfully.
	 * This will prevent the recovery key from being used again.
	 * @return a recovery result, which, if successful, contains a map dataOwnerId -> publicKeySpki -> keyPair, where:
	 * - The `dataOwnerId` keys are the ids of the data owner which created the recovery data and his parents, if the recovery data contains also the
	 *   parents keys
	 * - The `publicKeySpki` keys are all recovered public key pairs for the data owner, in hex-encoded spki format (full, no fingerprint). Usually
	 *   these are all the keys if the recovery data was created after the latest key for the user.
	 * - The `keyPair` is the imported privateKey + publicKey.
	 */
	suspend fun recoverWithRecoveryKey(
		recoveryKey: RecoveryDataKey,
		autoDelete: Boolean,
	): RecoveryResult<Map<String, Map<SpkiHexString, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>>>

	/*TODO
	 * cancellable api for other languages: the user interface could provide a way for the end user to cancel the
	 * recovery request before the end of the wait time. In those cases it would be best if the app also cancels the
	 * corresponding call.
	 */
	/**
	 * Equivalent to [recoverWithRecoveryKey] except that if there is no recovery data for the provided key it waits for
	 * up to [waitSeconds] seconds for it to be created.
	 * If the data wasn't created within the provided time frame this method will return a [RecoveryResult.Failure]
	 * result with [RecoveryDataUseFailureReason.Missing] at the end of the waiting period.
	 */
	suspend fun waitForRecoveryKey(
		recoveryKey: RecoveryDataKey,
		autoDelete: Boolean,
		waitSeconds: Int
	): RecoveryResult<Map<String, Map<SpkiHexString, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>>>

	/**
	 * Try to recover keypairs of a data owner user using other recovered keypairs, through transfer keys or shamir
	 * shares.
	 * This method uses the provided [recoveredKeys] together with keys already accessible to the SDK to try to recover
	 * additional keypairs of the provided [dataOwner] using transfer keys or shamir secret shares.
	 */
	suspend fun recoverWithEncryptionKeys(
		dataOwner: DataOwnerWithType,
		recoveredKeys: Collection<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>
	): Map<SpkiHexString, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>
}