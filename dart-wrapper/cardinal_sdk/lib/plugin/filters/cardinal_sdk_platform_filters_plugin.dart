// auto-generated file
import 'package:cardinal_sdk/plugin/filters/form_platform_filters.dart';
import 'package:cardinal_sdk/plugin/filters/access_log_platform_filters.dart';
import 'package:cardinal_sdk/plugin/filters/contact_platform_filters.dart';
import 'package:cardinal_sdk/plugin/filters/patient_platform_filters.dart';
import 'package:cardinal_sdk/plugin/filters/device_platform_filters.dart';
import 'package:cardinal_sdk/plugin/filters/user_platform_filters.dart';
import 'package:cardinal_sdk/plugin/filters/classification_platform_filters.dart';
import 'package:cardinal_sdk/plugin/filters/code_platform_filters.dart';
import 'package:cardinal_sdk/plugin/filters/group_platform_filters.dart';
import 'package:cardinal_sdk/plugin/filters/topic_platform_filters.dart';
import 'package:cardinal_sdk/plugin/filters/healthcare_party_platform_filters.dart';
import 'package:cardinal_sdk/plugin/filters/calendar_item_platform_filters.dart';
import 'package:cardinal_sdk/plugin/filters/document_platform_filters.dart';

import 'package:cardinal_sdk/plugin/filters/maintenance_task_platform_filters.dart';
import 'package:cardinal_sdk/plugin/filters/service_platform_filters.dart';

import 'package:cardinal_sdk/plugin/filters/message_platform_filters.dart';
import 'package:cardinal_sdk/plugin/filters/agenda_platform_filters.dart';
import 'package:cardinal_sdk/plugin/filters/health_element_platform_filters.dart';
import 'package:cardinal_sdk/plugin/filters/platform_meta_filters.dart';


abstract class CardinalSdkPlatformFiltersPlugin {

	FormPlatformFilters get form;

	AccessLogPlatformFilters get accessLog;

	ContactPlatformFilters get contact;

	PatientPlatformFilters get patient;

	DevicePlatformFilters get device;

	UserPlatformFilters get user;

	ClassificationPlatformFilters get classification;

	CodePlatformFilters get code;

	GroupPlatformFilters get group;

	TopicPlatformFilters get topic;

	HealthcarePartyPlatformFilters get healthcareParty;

	CalendarItemPlatformFilters get calendarItem;

	DocumentPlatformFilters get document;

	MaintenanceTaskPlatformFilters get maintenanceTask;

	ServicePlatformFilters get service;

	MessagePlatformFilters get message;

	AgendaPlatformFilters get agenda;

	HealthElementPlatformFilters get healthElement;

	PlatformMetaFilters get metaFilters;
}