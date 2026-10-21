package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.requests.RequestedPermission
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.Serializable

/**
 * Specifies how a new delegation-based custom entity is linked to its owning entity.
 *
 * The owning entity can be of any type supporting encryption metadata, builtin or custom.
 * The link between the custom entity and its owner is made of two optional parts:
 * - a secret id of the owning entity, stored in the secret foreign keys of the new custom entity, controlled by
 * [secretId]. This allows finding the custom entity starting from the owning entity (e.g. like a HealthElement can be
 * found starting from a Patient).
 * - the id of the owning entity, encrypted and stored in the new custom entity, controlled by [includeOwningEntityId].
 * This allows to find the owning entity starting from the custom entity.
 *
 * At least one of the two parts must be used.
 *
 * @param T the type of the owning entity: `HasEncryptionMetadata` for apis working in the current group, or
 * `GroupScoped<HasEncryptionMetadata>` for in-group apis.
 * @param entity the owning entity.
 * @param entityType the type of the owning entity, needed to access its security metadata.
 * @param secretId specifies which secret ids of the owning entity to use for the link.
 * @param includeOwningEntityId if true the (encrypted) id of the owning entity is stored in the new custom entity.
 */
data class CustomEntityOwningEntity<out T : Any>(
	val entity: T,
	val entityType: EntityWithEncryptionMetadataTypeName,
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithHierarchy")
	val secretId: SecretIdUseOption = SecretIdUseOption.UseAnySharedWithHierarchy,
	@param:DefaultValue("true")
	val includeOwningEntityId: Boolean = true,
)

@OptIn(InternalIcureApi::class)
@Serializable
data class CustomEntityDelegateOptions(
	override val accessLevel: AccessLevel,
	override val shareEncryptionKey: Boolean = true,
	override val shareSecretId: Boolean = true,
	/**
	 * Specifies if the id of the entity owning the custom entity (if any) should be shared with the delegate
	 */
	override val shareOwningEntityId: Boolean = true,
) : DelegateOptions

@OptIn(InternalIcureApi::class)
@Serializable
data class CustomEntityShareOptions(
	@param:DefaultValue("com.icure.cardinal.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions: RequestedPermission = RequestedPermission.MaxWrite,
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	/**
	 * Specifies if the id of the entity owning the custom entity (if any) should be shared with the delegate
	 */
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareOwningEntityIds: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.AllAvailable()")
	override val shareSecretIds: SecretIdShareOptions = SecretIdShareOptions.AllAvailable(),
) : SimpleDelegateShareOptions

/**
 * Content and metadata of an attachment to set in a bulk attachments update.
 * @param utis uniform type identifiers for the attachment (https://en.wikipedia.org/wiki/Uniform_Type_Identifier).
 * @param attachment the attachment content.
 */
class CustomEntityAttachmentInput(
	val utis: List<String>,
	val attachment: ByteArray,
)
