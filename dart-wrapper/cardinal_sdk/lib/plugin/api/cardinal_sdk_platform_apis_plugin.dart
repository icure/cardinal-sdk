// auto-generated file
import 'package:cardinal_sdk/plugin/api/keyword_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/device_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/access_log_basic_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/place_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/medical_location_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/time_table_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/document_basic_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/patient_basic_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/classification_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/calendar_item_basic_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/maintenance_task_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/form_basic_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/recovery_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/patient_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/maintenance_task_basic_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/tarification_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/contact_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/receipt_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/anonymous_agenda_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/healthcare_party_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/access_log_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/permission_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/code_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/front_end_migration_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/topic_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/document_template_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/health_element_basic_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/system_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/contact_basic_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/calendar_item_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/application_settings_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/crypto_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/receipt_basic_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/entity_reference_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/classification_basic_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/shamir_keys_manager_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/document_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/entity_template_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/auth_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/data_owner_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/user_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/role_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/anonymous_healthcare_party_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/message_basic_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/form_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/cardinal_maintenance_task_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/invoice_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/message_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/health_element_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/invoice_basic_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/calendar_item_type_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/topic_basic_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/insurance_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/agenda_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/group_platform_api.dart';


abstract class CardinalSdkPlatformApisPlugin {

	KeywordPlatformApi get keyword;

	DevicePlatformApi get device;

	AccessLogBasicPlatformApi get accessLogBasic;

	PlacePlatformApi get place;

	MedicalLocationPlatformApi get medicalLocation;

	TimeTablePlatformApi get timeTable;

	DocumentBasicPlatformApi get documentBasic;

	PatientBasicPlatformApi get patientBasic;

	ClassificationPlatformApi get classification;

	CalendarItemBasicPlatformApi get calendarItemBasic;

	MaintenanceTaskPlatformApi get maintenanceTask;

	FormBasicPlatformApi get formBasic;

	RecoveryPlatformApi get recovery;

	PatientPlatformApi get patient;

	MaintenanceTaskBasicPlatformApi get maintenanceTaskBasic;

	TarificationPlatformApi get tarification;

	ContactPlatformApi get contact;

	ReceiptPlatformApi get receipt;

	AnonymousAgendaPlatformApi get anonymousAgenda;

	HealthcarePartyPlatformApi get healthcareParty;

	AccessLogPlatformApi get accessLog;

	PermissionPlatformApi get permission;

	CodePlatformApi get code;

	FrontEndMigrationPlatformApi get frontEndMigration;

	TopicPlatformApi get topic;

	DocumentTemplatePlatformApi get documentTemplate;

	HealthElementBasicPlatformApi get healthElementBasic;

	SystemPlatformApi get system;

	ContactBasicPlatformApi get contactBasic;

	CalendarItemPlatformApi get calendarItem;

	ApplicationSettingsPlatformApi get applicationSettings;

	CryptoPlatformApi get crypto;

	ReceiptBasicPlatformApi get receiptBasic;

	EntityReferencePlatformApi get entityReference;

	ClassificationBasicPlatformApi get classificationBasic;

	ShamirKeysManagerPlatformApi get shamirKeysManager;

	DocumentPlatformApi get document;

	EntityTemplatePlatformApi get entityTemplate;

	AuthPlatformApi get auth;

	DataOwnerPlatformApi get dataOwner;

	UserPlatformApi get user;

	RolePlatformApi get role;

	AnonymousHealthcarePartyPlatformApi get anonymousHealthcareParty;

	MessageBasicPlatformApi get messageBasic;

	FormPlatformApi get form;

	CardinalMaintenanceTaskPlatformApi get cardinalMaintenanceTask;

	InvoicePlatformApi get invoice;

	MessagePlatformApi get message;

	HealthElementPlatformApi get healthElement;

	InvoiceBasicPlatformApi get invoiceBasic;

	CalendarItemTypePlatformApi get calendarItemType;

	TopicBasicPlatformApi get topicBasic;

	InsurancePlatformApi get insurance;

	AgendaPlatformApi get agenda;

	GroupPlatformApi get group;
}