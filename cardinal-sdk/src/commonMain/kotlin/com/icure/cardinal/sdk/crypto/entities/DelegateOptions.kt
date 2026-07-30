package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.Serializable

@InternalIcureApi
interface DelegateOptions {
	val accessLevel: AccessLevel
	val shareEncryptionKey: Boolean
	val shareSecretId: Boolean
	val shareOwningEntityId: Boolean
}

@OptIn(InternalIcureApi::class)
@Serializable
data class AccessLogDelegateOptions(
	override val accessLevel: AccessLevel,
	override val shareEncryptionKey: Boolean = true,
	override val shareSecretId: Boolean = true,
	/**
	 * Specifies if the id of the patient linked to the access log should be shared with the delegate
	 */
	val sharePatientId: Boolean = true,
) : DelegateOptions {

	override val shareOwningEntityId get() = sharePatientId
}

@OptIn(InternalIcureApi::class)
@Serializable
data class CalendarItemDelegateOptions(
	override val accessLevel: AccessLevel,
	override val shareEncryptionKey: Boolean = true,
	override val shareSecretId: Boolean = true,
	/**
	 * Specifies if the id of the patient linked to the calendar item should be shared with the delegate
	 */
	val sharePatientId: Boolean = true,
) : DelegateOptions {

	override val shareOwningEntityId get() = sharePatientId
}

@OptIn(InternalIcureApi::class)
@Serializable
data class ContactDelegateOptions(
	override val accessLevel: AccessLevel,
	override val shareEncryptionKey: Boolean = true,
	override val shareSecretId: Boolean = true,
	/**
	 * Specifies if the id of the patient linked to the contact should be shared with the delegate
	 */
	val sharePatientId: Boolean = true,
) : DelegateOptions {

	override val shareOwningEntityId get() = sharePatientId
}

@OptIn(InternalIcureApi::class)
@Serializable
data class DocumentDelegateOptions(
	override val accessLevel: AccessLevel,
	override val shareEncryptionKey: Boolean = true,
	override val shareSecretId: Boolean = true,
	/**
	 * Specifies if the id of the message linked to the document (if any) should be shared with the delegate
	 */
	val shareMessageId: Boolean = true,
) : DelegateOptions {

	override val shareOwningEntityId get() = shareMessageId
}

@OptIn(InternalIcureApi::class)
@Serializable
data class FormDelegateOptions(
	override val accessLevel: AccessLevel,
	override val shareEncryptionKey: Boolean = true,
	override val shareSecretId: Boolean = true,
	/**
	 * Specifies if the id of the patient linked to the form should be shared with the delegate
	 */
	val sharePatientId: Boolean = true,
) : DelegateOptions {

	override val shareOwningEntityId get() = sharePatientId
}

@OptIn(InternalIcureApi::class)
@Serializable
data class HealthElementDelegateOptions(
	override val accessLevel: AccessLevel,
	override val shareEncryptionKey: Boolean = true,
	override val shareSecretId: Boolean = true,
	/**
	 * Specifies if the id of the patient linked to the health element should be shared with the delegate
	 */
	val sharePatientId: Boolean = true,
) : DelegateOptions {

	override val shareOwningEntityId get() = sharePatientId
}

@OptIn(InternalIcureApi::class)
@Serializable
data class InvoiceDelegateOptions(
	override val accessLevel: AccessLevel,
	override val shareEncryptionKey: Boolean = true,
	override val shareSecretId: Boolean = true,
	/**
	 * Specifies if the id of the patient linked to the invoice should be shared with the delegate
	 */
	val sharePatientId: Boolean = true,
) : DelegateOptions {

	override val shareOwningEntityId get() = sharePatientId
}

@OptIn(InternalIcureApi::class)
@Serializable
data class MessageDelegateOptions(
	override val accessLevel: AccessLevel,
	override val shareEncryptionKey: Boolean = true,
	override val shareSecretId: Boolean = true,
	/**
	 * Specifies if the id of the patient linked to the message should be shared with the delegate
	 */
	val sharePatientId: Boolean = true,
) : DelegateOptions {

	override val shareOwningEntityId get() = sharePatientId
}

@OptIn(InternalIcureApi::class)
@Serializable
data class PatientDelegateOptions(
	override val accessLevel: AccessLevel,
	override val shareEncryptionKey: Boolean = true,
	override val shareSecretId: Boolean = true,
) : DelegateOptions {

	override val shareOwningEntityId get() = false
}

@OptIn(InternalIcureApi::class)
@Serializable
data class RelatedPersonDelegateOptions(
	override val accessLevel: AccessLevel,
	override val shareEncryptionKey: Boolean = true,
	override val shareSecretId: Boolean = true,
) : DelegateOptions {

	override val shareOwningEntityId get() = false
}

@OptIn(InternalIcureApi::class)
@Serializable
data class ReceiptDelegateOptions(
	override val accessLevel: AccessLevel,
	override val shareEncryptionKey: Boolean = true,
	override val shareSecretId: Boolean = true,
) : DelegateOptions {

	override val shareOwningEntityId get() = false
}

@OptIn(InternalIcureApi::class)
@Serializable
data class TopicDelegateOptions(
	override val accessLevel: AccessLevel,
	override val shareEncryptionKey: Boolean = true,
	override val shareSecretId: Boolean = true,
	/**
	 * Specifies if the id of the patient linked to the topic should be shared with the delegate
	 */
	val sharePatientId: Boolean = true,
) : DelegateOptions {

	override val shareOwningEntityId get() = sharePatientId
}
