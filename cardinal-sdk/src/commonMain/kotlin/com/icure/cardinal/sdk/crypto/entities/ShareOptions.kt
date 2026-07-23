package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.model.requests.RequestedPermission
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.Serializable

@InternalIcureApi
interface SimpleDelegateShareOptions {
	/**
	 * The secret ids you want to share with the delegate.
	 */
	val shareSecretIds: SecretIdShareOptions
	/**
	 * Specifies if the encryption key of the entity should be shared (giving access to the encrypted information)
	 */
	val shareEncryptionKey: ShareMetadataBehaviour
	/**
	 * Specifies if the id of the "owning" entity should be shared. The type of the owning entity and exact meaning of
	 * the relationship between the "owning" entity and the entity being shared depends on the shared entity type.
	 */
	val shareOwningEntityIds: ShareMetadataBehaviour
	/**
	 * Specifies the permissions that the delegate will have on the shared entity.
	 * - FullWrite: the delegate will get write access to the full entity. If the delegator is not allowed to give
	 *   write access, the sharing will fail
	 * - MaxWrite: the delegate will get the highest permissions that the current user can grant. In the current version
	 *   of the SDK this means that if the delegator can grant full write access, the delegate will have full write
	 *   access, otherwise the delegate will have full read access.
	 * - FullRead: gives the delegate full read access to the entity, failing if the delegator can't grant read to
	 *   the full entity. In the current version of the SDK this can never fail as long as the delegator has access to
	 *   the entity.
	 * - MaxRead: gives the delegate as much read access to the entity as the delegator can give. In the current version
	 *   of the SDK as long this is equivalent to FullRead.
	 * - Root: for internal use only
	 */
	val requestedPermissions: RequestedPermission
}

@InternalIcureApi
internal data class SimpleDelegateShareOptionsImpl(
	override val shareSecretIds: SecretIdShareOptions,
	override val shareEncryptionKey: ShareMetadataBehaviour,
	override val shareOwningEntityIds: ShareMetadataBehaviour,
	override val requestedPermissions: RequestedPermission
) : SimpleDelegateShareOptions

@OptIn(InternalIcureApi::class)
@Serializable
data class AccessLogShareOptions(
	@param:DefaultValue("com.icure.cardinal.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions: RequestedPermission = RequestedPermission.MaxWrite,
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	/**
	 * Specifies if the id of the patient linked to the access log should be shared with the delegate
	 */
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	val sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.AllAvailable()")
	override val shareSecretIds: SecretIdShareOptions = SecretIdShareOptions.AllAvailable(),
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
}

@OptIn(InternalIcureApi::class)
@Serializable
data class CalendarItemShareOptions(
	@param:DefaultValue("com.icure.cardinal.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions: RequestedPermission = RequestedPermission.MaxWrite,
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	/**
	 * Specifies if the id of the patient linked to the calendar item should be shared with the delegate
	 */
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	val sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.AllAvailable()")
	override val shareSecretIds: SecretIdShareOptions = SecretIdShareOptions.AllAvailable(),
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
}

@OptIn(InternalIcureApi::class)
@Serializable
data class ClassificationShareOptions(
	@param:DefaultValue("com.icure.cardinal.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions: RequestedPermission = RequestedPermission.MaxWrite,
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	/**
	 * Specifies if the id of the patient linked to the classification should be shared with the delegate
	 */
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	val sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.AllAvailable()")
	override val shareSecretIds: SecretIdShareOptions = SecretIdShareOptions.AllAvailable(),
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
}

@OptIn(InternalIcureApi::class)
@Serializable
data class ContactShareOptions(
	@param:DefaultValue("com.icure.cardinal.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	/**
	 * Specifies if the id of the patient linked to the contact should be shared with the delegate
	 */
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	val sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.AllAvailable()")
	override val shareSecretIds: SecretIdShareOptions = SecretIdShareOptions.AllAvailable(),
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
}

@OptIn(InternalIcureApi::class)
@Serializable
data class DocumentShareOptions(
	@param:DefaultValue("com.icure.cardinal.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	/**
	 * Specifies if the id of the message linked to the document (if any) should be shared with the delegate
	 */
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	val shareMessageId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.AllAvailable()")
	override val shareSecretIds: SecretIdShareOptions = SecretIdShareOptions.AllAvailable(),
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = shareMessageId
}

@OptIn(InternalIcureApi::class)
@Serializable
data class FormShareOptions(
	@param:DefaultValue("com.icure.cardinal.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	/**
	 * Specifies if the id of the patient linked to the form should be shared with the delegate
	 */
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	val sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.AllAvailable()")
	override val shareSecretIds: SecretIdShareOptions = SecretIdShareOptions.AllAvailable(),
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
}

@OptIn(InternalIcureApi::class)
@Serializable
data class HealthElementShareOptions(
	@param:DefaultValue("com.icure.cardinal.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	/**
	 * Specifies if the id of the patient linked to the health element should be shared with the delegate
	 */
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	val sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.AllAvailable()")
	override val shareSecretIds: SecretIdShareOptions = SecretIdShareOptions.AllAvailable(),
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
}

@OptIn(InternalIcureApi::class)
@Serializable
data class InvoiceShareOptions(
	@param:DefaultValue("com.icure.cardinal.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	/**
	 * Specifies if the id of the patient linked to the invoice should be shared with the delegate
	 */
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	val sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.AllAvailable()")
	override val shareSecretIds: SecretIdShareOptions = SecretIdShareOptions.AllAvailable(),
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
}

@OptIn(InternalIcureApi::class)
@Serializable
data class MaintenanceTaskShareOptions(
	@param:DefaultValue("com.icure.cardinal.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.AllAvailable()")
	override val shareSecretIds: SecretIdShareOptions = SecretIdShareOptions.AllAvailable(),
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = ShareMetadataBehaviour.Never
}

@OptIn(InternalIcureApi::class)
@Serializable
data class MessageShareOptions(
	@param:DefaultValue("com.icure.cardinal.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	/**
	 * Specifies if the id of the patient linked to the message should be shared with the delegate
	 */
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	val sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.AllAvailable()")
	override val shareSecretIds: SecretIdShareOptions = SecretIdShareOptions.AllAvailable(),
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
}

@OptIn(InternalIcureApi::class)
@Serializable
data class PatientShareOptions(
	@param:DefaultValue("com.icure.cardinal.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.AllAvailable()")
	override val shareSecretIds: SecretIdShareOptions = SecretIdShareOptions.AllAvailable(),
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = ShareMetadataBehaviour.Never
}

@OptIn(InternalIcureApi::class)
@Serializable
data class ReceiptShareOptions(
	@param:DefaultValue("com.icure.cardinal.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.AllAvailable()")
	override val shareSecretIds: SecretIdShareOptions = SecretIdShareOptions.AllAvailable(),
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = ShareMetadataBehaviour.Never
}

@OptIn(InternalIcureApi::class)
@Serializable
data class TimeTableShareOptions(
	@param:DefaultValue("com.icure.cardinal.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.AllAvailable()")
	override val shareSecretIds: SecretIdShareOptions = SecretIdShareOptions.AllAvailable(),
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = ShareMetadataBehaviour.Never
}

@OptIn(InternalIcureApi::class)
@Serializable
data class TopicShareOptions(
	@param:DefaultValue("com.icure.cardinal.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	/**
	 * Specifies if the id of the patient linked to the topic should be shared with the delegate
	 */
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	val sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	@param:DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.AllAvailable()")
	override val shareSecretIds: SecretIdShareOptions = SecretIdShareOptions.AllAvailable(),
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
}
