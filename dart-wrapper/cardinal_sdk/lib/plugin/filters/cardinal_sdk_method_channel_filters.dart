// auto-generated file
import 'package:flutter/services.dart';
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
import 'package:cardinal_sdk/plugin/filters/cardinal_sdk_platform_filters_plugin.dart';


class CardinalSdkMethodChannelFilters extends CardinalSdkPlatformFiltersPlugin {
	static const MethodChannel _methodChannel = const MethodChannel("com.icure.cardinal.sdk/filters");
	FormPlatformFilters _form = FormPlatformFilters(_methodChannel);
	@override FormPlatformFilters get form => _form;
	AccessLogPlatformFilters _accessLog = AccessLogPlatformFilters(_methodChannel);
	@override AccessLogPlatformFilters get accessLog => _accessLog;
	ContactPlatformFilters _contact = ContactPlatformFilters(_methodChannel);
	@override ContactPlatformFilters get contact => _contact;
	PatientPlatformFilters _patient = PatientPlatformFilters(_methodChannel);
	@override PatientPlatformFilters get patient => _patient;
	DevicePlatformFilters _device = DevicePlatformFilters(_methodChannel);
	@override DevicePlatformFilters get device => _device;
	UserPlatformFilters _user = UserPlatformFilters(_methodChannel);
	@override UserPlatformFilters get user => _user;
	ClassificationPlatformFilters _classification = ClassificationPlatformFilters(_methodChannel);
	@override ClassificationPlatformFilters get classification => _classification;
	CodePlatformFilters _code = CodePlatformFilters(_methodChannel);
	@override CodePlatformFilters get code => _code;
	GroupPlatformFilters _group = GroupPlatformFilters(_methodChannel);
	@override GroupPlatformFilters get group => _group;
	TopicPlatformFilters _topic = TopicPlatformFilters(_methodChannel);
	@override TopicPlatformFilters get topic => _topic;
	HealthcarePartyPlatformFilters _healthcareParty = HealthcarePartyPlatformFilters(_methodChannel);
	@override HealthcarePartyPlatformFilters get healthcareParty => _healthcareParty;
	CalendarItemPlatformFilters _calendarItem = CalendarItemPlatformFilters(_methodChannel);
	@override CalendarItemPlatformFilters get calendarItem => _calendarItem;
	DocumentPlatformFilters _document = DocumentPlatformFilters(_methodChannel);
	@override DocumentPlatformFilters get document => _document;
	MaintenanceTaskPlatformFilters _maintenanceTask = MaintenanceTaskPlatformFilters(_methodChannel);
	@override MaintenanceTaskPlatformFilters get maintenanceTask => _maintenanceTask;
	ServicePlatformFilters _service = ServicePlatformFilters(_methodChannel);
	@override ServicePlatformFilters get service => _service;
	MessagePlatformFilters _message = MessagePlatformFilters(_methodChannel);
	@override MessagePlatformFilters get message => _message;
	AgendaPlatformFilters _agenda = AgendaPlatformFilters(_methodChannel);
	@override AgendaPlatformFilters get agenda => _agenda;
	HealthElementPlatformFilters _healthElement = HealthElementPlatformFilters(_methodChannel);
	@override HealthElementPlatformFilters get healthElement => _healthElement;
	PlatformMetaFilters _metaFilters = PlatformMetaFilters(_methodChannel);
	@override PlatformMetaFilters get metaFilters => _metaFilters;
}