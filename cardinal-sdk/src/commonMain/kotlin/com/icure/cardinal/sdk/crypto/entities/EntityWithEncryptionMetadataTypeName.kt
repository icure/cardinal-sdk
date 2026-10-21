package com.icure.cardinal.sdk.crypto.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed interface EntityWithEncryptionMetadataTypeName {
	/**
	 * Uniquely identifies the entity type, it is included as a "salt" in the secure delegation key, to segregate the
	 * secure delegation key spaces of different entity types.
	 * We must never change these values since it could break the secure delegation key derivation, making some data
	 * inaccessible to anonymous users.
	 */
	val id: String

	/**
	 * Types of encryptable entities, to support segregation of secure delegation keys.
	 * These types do not include stubs and metadata entities (such as SecureDelegationKeyMap) since they use the actual
	 * type of the related entity, and does not include services as they use the type of Contact.
	 */
	@Serializable
	@SerialName("Builtin")
	enum class Builtin(
		override val id: String
	) : EntityWithEncryptionMetadataTypeName {
		Article("Article"),
		AccessLog("AccessLog"),
		CalendarItem("CalendarItem"),
		Classification("Classification"),
		ClassificationTemplate("ClassificationTemplate"),
		Contact("Contact"),
		Service("Service"),
		Document("Document"),
		Form("Form"),
		HealthElement("HealthElement"),
		Invoice("Invoice"),
		MaintenanceTask("MaintenanceTask"),
		Message("Message"),
		Patient("Patient"),
		Receipt("Receipt"),
		RelatedPerson("RelatedPerson"),
		Topic("Topic")
	}

	@Serializable
	@SerialName("Custom")
	data class Custom(
		val entityTypeId: String,
	) : EntityWithEncryptionMetadataTypeName {
		override val id: String = "custom:$entityTypeId"
	}
}
