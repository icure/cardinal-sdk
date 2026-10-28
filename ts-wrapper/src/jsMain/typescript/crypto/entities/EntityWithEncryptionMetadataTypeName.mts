// auto-generated file

export type EntityWithEncryptionMetadataTypeName = EntityWithEncryptionMetadataTypeName.Custom;

export namespace EntityWithEncryptionMetadataTypeName {

	/**
	 *
	 *  Types of encryptable entities, to support segregation of secure delegation keys.
	 *  These types do not include stubs and metadata entities (such as SecureDelegationKeyMap) since they use the actual
	 *  type of the related entity, and does not include services as they use the type of Contact.
	 */
	export enum Builtin {
		Article = "Article",
		AccessLog = "AccessLog",
		CalendarItem = "CalendarItem",
		Classification = "Classification",
		ClassificationTemplate = "ClassificationTemplate",
		Contact = "Contact",
		Service = "Service",
		Document = "Document",
		Form = "Form",
		HealthElement = "HealthElement",
		Invoice = "Invoice",
		MaintenanceTask = "MaintenanceTask",
		Message = "Message",
		Patient = "Patient",
		Receipt = "Receipt",
		RelatedPerson = "RelatedPerson",
		Topic = "Topic"
	}

	export class Custom {

		entityTypeId: string;

		readonly $ktClass: 'com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName.Custom' = 'com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName.Custom';

		constructor(partial: Partial<Custom> & Pick<Custom, "entityTypeId">) {
			this.entityTypeId = partial.entityTypeId;
		}

	}

}
