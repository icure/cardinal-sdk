// auto-generated file


enum EntityWithEncryptionMetadataTypeName {
	article,
	accessLog,
	calendarItem,
	classification,
	classificationTemplate,
	contact,
	service,
	document,
	form,
	healthElement,
	invoice,
	maintenanceTask,
	message,
	patient,
	receipt,
	topic;

	static String encode(EntityWithEncryptionMetadataTypeName value) {
		switch (value) {
			case EntityWithEncryptionMetadataTypeName.article:
				return 'Article';
			case EntityWithEncryptionMetadataTypeName.accessLog:
				return 'AccessLog';
			case EntityWithEncryptionMetadataTypeName.calendarItem:
				return 'CalendarItem';
			case EntityWithEncryptionMetadataTypeName.classification:
				return 'Classification';
			case EntityWithEncryptionMetadataTypeName.classificationTemplate:
				return 'ClassificationTemplate';
			case EntityWithEncryptionMetadataTypeName.contact:
				return 'Contact';
			case EntityWithEncryptionMetadataTypeName.service:
				return 'Service';
			case EntityWithEncryptionMetadataTypeName.document:
				return 'Document';
			case EntityWithEncryptionMetadataTypeName.form:
				return 'Form';
			case EntityWithEncryptionMetadataTypeName.healthElement:
				return 'HealthElement';
			case EntityWithEncryptionMetadataTypeName.invoice:
				return 'Invoice';
			case EntityWithEncryptionMetadataTypeName.maintenanceTask:
				return 'MaintenanceTask';
			case EntityWithEncryptionMetadataTypeName.message:
				return 'Message';
			case EntityWithEncryptionMetadataTypeName.patient:
				return 'Patient';
			case EntityWithEncryptionMetadataTypeName.receipt:
				return 'Receipt';
			case EntityWithEncryptionMetadataTypeName.topic:
				return 'Topic';
			}
	}


	static EntityWithEncryptionMetadataTypeName fromJSON(String data) {
		switch (data) {
			case "Article":
				return EntityWithEncryptionMetadataTypeName.article;
			case "AccessLog":
				return EntityWithEncryptionMetadataTypeName.accessLog;
			case "CalendarItem":
				return EntityWithEncryptionMetadataTypeName.calendarItem;
			case "Classification":
				return EntityWithEncryptionMetadataTypeName.classification;
			case "ClassificationTemplate":
				return EntityWithEncryptionMetadataTypeName.classificationTemplate;
			case "Contact":
				return EntityWithEncryptionMetadataTypeName.contact;
			case "Service":
				return EntityWithEncryptionMetadataTypeName.service;
			case "Document":
				return EntityWithEncryptionMetadataTypeName.document;
			case "Form":
				return EntityWithEncryptionMetadataTypeName.form;
			case "HealthElement":
				return EntityWithEncryptionMetadataTypeName.healthElement;
			case "Invoice":
				return EntityWithEncryptionMetadataTypeName.invoice;
			case "MaintenanceTask":
				return EntityWithEncryptionMetadataTypeName.maintenanceTask;
			case "Message":
				return EntityWithEncryptionMetadataTypeName.message;
			case "Patient":
				return EntityWithEncryptionMetadataTypeName.patient;
			case "Receipt":
				return EntityWithEncryptionMetadataTypeName.receipt;
			case "Topic":
				return EntityWithEncryptionMetadataTypeName.topic;
			default:
				throw ArgumentError('Invalid EntityWithEncryptionMetadataTypeName entry value $data');
			}
	}

}