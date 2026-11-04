package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.model.requests.RequestedPermission
import kotlinx.serialization.Serializable

/**
 * Whether the secret ids carried by a share request were chosen by the caller or by the sdk.
 */
@Serializable
enum class SharedSecretIdsSource {
	/**
	 * The caller let the sdk share all the secret ids of the entity it could access
	 * (see [SecretIdShareOptions.AllAvailable]).
	 */
	AllAvailable,

	/**
	 * The caller provided the exact secret ids to share (see [SecretIdShareOptions.UseExactly]).
	 */
	ExplicitValues
}

/**
 * A non-sensitive summary of a share request the sdk built out of the share options provided by the caller: what was
 * asked for each kind of metadata and how much of it the request was carrying, but never the metadata itself -
 * sharing a secret id or an encryption key means putting the actual value in the request, and those values must not
 * end up in an error object that callers routinely log.
 *
 * The counts are those of the resolved request, before the sdk dropped from it whatever the delegate can already
 * access anyway (see [FailedRequestDetails.RequestRejected.requestSummary] for when you get one of these).
 */
@Serializable
data class ShareRequestSummary(
	/**
	 * The permissions that were requested for the delegate.
	 */
	val requestedPermissions: RequestedPermission,
	/**
	 * Where the secret ids of the request came from.
	 */
	val secretIdsSource: SharedSecretIdsSource,
	/**
	 * How many secret ids the request was carrying.
	 */
	val sharedSecretIdsCount: Int,
	/**
	 * The behaviour that was requested for the encryption key.
	 */
	val encryptionKeysBehaviour: ShareMetadataBehaviour,
	/**
	 * How many encryption keys the request was carrying.
	 */
	val sharedEncryptionKeysCount: Int,
	/**
	 * The behaviour that was requested for the owning entity ids.
	 */
	val owningEntityIdsBehaviour: ShareMetadataBehaviour,
	/**
	 * How many owning entity ids the request was carrying.
	 */
	val sharedOwningEntityIdsCount: Int
)
