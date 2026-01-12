import 'dart:convert';

import 'package:cardinal_sdk/api/access_log_api.dart';
import 'package:cardinal_sdk/api/access_log_basic_api.dart';
import 'package:cardinal_sdk/api/agenda_api.dart';
import 'package:cardinal_sdk/api/application_settings_api.dart';
import 'package:cardinal_sdk/api/calendar_item_api.dart';
import 'package:cardinal_sdk/api/calendar_item_basic_api.dart';
import 'package:cardinal_sdk/api/cardinal_maintenance_task_api.dart';
import 'package:cardinal_sdk/api/classification_api.dart';
import 'package:cardinal_sdk/api/classification_basic_api.dart';
import 'package:cardinal_sdk/api/code_api.dart';
import 'package:cardinal_sdk/api/contact_api.dart';
import 'package:cardinal_sdk/api/contact_basic_api.dart';
import 'package:cardinal_sdk/api/crypto_api.dart';
import 'package:cardinal_sdk/api/data_owner_api.dart';
import 'package:cardinal_sdk/api/device_api.dart';
import 'package:cardinal_sdk/api/document_api.dart';
import 'package:cardinal_sdk/api/document_basic_api.dart';
import 'package:cardinal_sdk/api/document_template_api.dart';
import 'package:cardinal_sdk/api/entity_reference_api.dart';
import 'package:cardinal_sdk/api/entity_template_api.dart';
import 'package:cardinal_sdk/api/form_api.dart';
import 'package:cardinal_sdk/api/form_basic_api.dart';
import 'package:cardinal_sdk/api/front_end_migration_api.dart';
import 'package:cardinal_sdk/api/group_api.dart';
import 'package:cardinal_sdk/api/health_element_api.dart';
import 'package:cardinal_sdk/api/health_element_basic_api.dart';
import 'package:cardinal_sdk/api/healthcare_party_api.dart';
import 'package:cardinal_sdk/api/insurance_api.dart';
import 'package:cardinal_sdk/api/keyword_api.dart';
import 'package:cardinal_sdk/api/maintenance_task_api.dart';
import 'package:cardinal_sdk/api/maintenance_task_basic_api.dart';
import 'package:cardinal_sdk/api/medical_location_api.dart';
import 'package:cardinal_sdk/api/message_api.dart';
import 'package:cardinal_sdk/api/message_basic_api.dart';
import 'package:cardinal_sdk/api/patient_api.dart';
import 'package:cardinal_sdk/api/patient_basic_api.dart';
import 'package:cardinal_sdk/api/permission_api.dart';
import 'package:cardinal_sdk/api/place_api.dart';
import 'package:cardinal_sdk/api/recovery_api.dart';
import 'package:cardinal_sdk/api/role_api.dart';
import 'package:cardinal_sdk/api/system_api.dart';
import 'package:cardinal_sdk/api/tarification_api.dart';
import 'package:cardinal_sdk/api/time_table_api.dart';
import 'package:cardinal_sdk/api/topic_api.dart';
import 'package:cardinal_sdk/api/topic_basic_api.dart';
import 'package:cardinal_sdk/api/user_api.dart';
import 'package:cardinal_sdk/auth/authentication_method.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_initializers.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:flutter/services.dart';
import 'auth/authentication_process_telecom_type.dart';
import 'auth/authentication_process_template_parameters.dart';
import 'auth/captcha_options.dart';
import 'options/sdk_options.dart';
import 'options/storage_options.dart';

class AuthenticationWithProcessStep {
  static final Finalizer<String> _finalizer = Finalizer((resourceId) =>
      CardinalSdkPlatformInterface.instance.utils.releasePlatformResource(resourceId)
  );

  final String _instanceId;
  AuthenticationWithProcessStep._(this._instanceId);

  factory AuthenticationWithProcessStep._factory(String instanceId) {
    final authStep = AuthenticationWithProcessStep._(instanceId);
    _finalizer.attach(authStep, instanceId, detach: authStep);
    return authStep;
  }

  Future<CardinalSdk> completeAuthentication(String validationCode) async {
    return await CardinalSdkPlatformInterface.instance.initializers.completeAuthentication(_instanceId, validationCode);
  }
}

abstract interface class CardinalApis {
  ApplicationSettingsApi get applicationSettings;
  CodeApi get code;
  DeviceApi get device;
  DocumentTemplateApi get documentTemplate;
  EntityReferenceApi get entityReference;
  EntityTemplateApi get entityTemplate;
  FrontEndMigrationApi get frontEndMigration;
  GroupApi get group;
  HealthcarePartyApi get healthcareParty;
  SystemApi get system;
  InsuranceApi get insurance;
  KeywordApi get keyword;
  PermissionApi get permission;
  PlaceApi get place;
  RoleApi get role;
  TarificationApi get tarification;
  UserApi get user;
  MedicalLocationApi get medicalLocation;
  AgendaApi get agenda;
  AccessLogApi get accessLog;
  CalendarItemApi get calendarItem;
  ClassificationApi get classification;
  ContactApi get contact;
  DocumentApi get document;
  FormApi get form;
  HealthElementApi get healthElement;
  MaintenanceTaskApi get maintenanceTask;
  MessageApi get message;
  PatientApi get patient;
  TimeTableApi get timeTable;
  TopicApi get topic;
  CryptoApi get crypto;
  RecoveryApi get recovery;
  CardinalMaintenanceTaskApi get cardinalMaintenanceTask;
  DataOwnerApi get dataOwner;
}

class CardinalSdk extends CardinalApis {
  static final Finalizer<String> _finalizer = Finalizer((resourceId) =>
      CardinalSdkPlatformInterface.instance.utils.releasePlatformResource(resourceId)
  );

  final String _sdkId;
  late final AccessLogApi _accessLog;
  late final AgendaApi _agenda;
  late final ApplicationSettingsApi _applicationSettings;
  late final CalendarItemApi _calendarItem;
  late final CardinalMaintenanceTaskApi _cardinalMaintenanceTask;
  late final ClassificationApi _classification;
  late final CodeApi _code;
  late final ContactApi _contact;
  late final CryptoApi _crypto;
  late final DataOwnerApi _dataOwner;
  late final DeviceApi _device;
  late final DocumentApi _document;
  late final DocumentTemplateApi _documentTemplate;
  late final EntityReferenceApi _entityReference;
  late final EntityTemplateApi _entityTemplate;
  late final FormApi _form;
  late final FrontEndMigrationApi _frontEndMigration;
  late final GroupApi _group;
  late final HealthElementApi _healthElement;
  late final HealthcarePartyApi _healthcareParty;
  late final InsuranceApi _insurance;
  late final KeywordApi _keyword;
  late final MaintenanceTaskApi _maintenanceTask;
  late final MedicalLocationApi _medicalLocation;
  late final MessageApi _message;
  late final PatientApi _patient;
  late final PermissionApi _permission;
  late final PlaceApi _place;
  late final RoleApi _role;
  late final SystemApi _system;
  late final TarificationApi _tarification;
  late final TimeTableApi _timeTable;
  late final TopicApi _topic;
  late final UserApi _user;
  late final RecoveryApi _recovery;

  CardinalSdk._(
    this._sdkId
  ) : super() {
    _accessLog = AccessLogApi(_sdkId, this);
    _agenda = AgendaApi(_sdkId, this);
    _applicationSettings = ApplicationSettingsApi(_sdkId, this);
    _calendarItem = CalendarItemApi(_sdkId, this);
    _cardinalMaintenanceTask = CardinalMaintenanceTaskApi(_sdkId, this);
    _classification = ClassificationApi(_sdkId, this);
    _code = CodeApi(_sdkId, this);
    _contact = ContactApi(_sdkId, this);
    _crypto = CryptoApi(_sdkId, this);
    _dataOwner = DataOwnerApi(_sdkId, this);
    _device = DeviceApi(_sdkId, this);
    _document = DocumentApi(_sdkId, this);
    _documentTemplate = DocumentTemplateApi(_sdkId, this);
    _entityReference = EntityReferenceApi(_sdkId, this);
    _entityTemplate = EntityTemplateApi(_sdkId, this);
    _form = FormApi(_sdkId, this);
    _frontEndMigration = FrontEndMigrationApi(_sdkId, this);
    _group = GroupApi(_sdkId, this);
    _healthElement = HealthElementApi(_sdkId, this);
    _healthcareParty = HealthcarePartyApi(_sdkId, this);
    _insurance = InsuranceApi(_sdkId, this);
    _keyword = KeywordApi(_sdkId, this);
    _maintenanceTask = MaintenanceTaskApi(_sdkId, this);
    _medicalLocation = MedicalLocationApi(_sdkId, this);
    _message = MessageApi(_sdkId, this);
    _patient = PatientApi(_sdkId, this);
    _permission = PermissionApi(_sdkId, this);
    _place = PlaceApi(_sdkId, this);
    _role = RoleApi(_sdkId, this);
    _system = SystemApi(_sdkId, this);
    _tarification = TarificationApi(_sdkId, this);
    _timeTable = TimeTableApi(_sdkId, this);
    _topic = TopicApi(_sdkId, this);
    _user = UserApi(_sdkId, this);
    _recovery = RecoveryApi(_sdkId, this);
  }

  factory CardinalSdk.internal(String sdkId) {
    final sdk = CardinalSdk._(sdkId);
    _finalizer.attach(sdk, sdkId, detach: sdk);
    return sdk;
  }

  static Future<AuthenticationWithProcessStep> initializeWithProcess(
      String? projectId,
      String baseUrl,
      String messageGatewayUrl,
      String externalServicesSpecId,
      String processId,
      AuthenticationProcessTelecomType userTelecomType,
      String userTelecom,
      CaptchaOptions captcha,
      StorageOptions storageOptions,
      {
        AuthenticationProcessTemplateParameters authenticationProcessTemplateParameters = const AuthenticationProcessTemplateParameters(),
        SdkOptions options = const SdkOptions()
      }
  ) {
    return CardinalSdkPlatformInterface.instance.initializers.initializeWithProcess(
        projectId,
        baseUrl,
        messageGatewayUrl,
        externalServicesSpecId,
        processId,
        userTelecomType,
        userTelecom,
        captcha,
        storageOptions,
        authenticationProcessTemplateParameters,
        options
    );
  }

  static Future<CardinalSdk> initialize(
      String? projectId,
      String baseUrl,
      AuthenticationMethod authenticationMethod,
      StorageOptions storageOptions,
      {SdkOptions options = const SdkOptions()}
  ) {
    return CardinalSdkPlatformInterface.instance.initializers.initialize(
        projectId,
        baseUrl,
        authenticationMethod,
        storageOptions,
        options
    );
  }

  @override
  AccessLogApi get accessLog => _accessLog;
  @override
  AgendaApi get agenda => _agenda;
  @override
  ApplicationSettingsApi get applicationSettings => _applicationSettings;
  @override
  CalendarItemApi get calendarItem => _calendarItem;
  @override
  CardinalMaintenanceTaskApi get cardinalMaintenanceTask => _cardinalMaintenanceTask;
  @override
  ClassificationApi get classification => _classification;
  @override
  CodeApi get code => _code;
  @override
  ContactApi get contact => _contact;
  @override
  CryptoApi get crypto => _crypto;
  @override
  DataOwnerApi get dataOwner => _dataOwner;
  @override
  DeviceApi get device => _device;
  @override
  DocumentApi get document => _document;
  @override
  DocumentTemplateApi get documentTemplate => _documentTemplate;
  @override
  EntityReferenceApi get entityReference => _entityReference;
  @override
  EntityTemplateApi get entityTemplate => _entityTemplate;
  @override
  FormApi get form => _form;
  @override
  FrontEndMigrationApi get frontEndMigration => _frontEndMigration;
  @override
  GroupApi get group => _group;
  @override
  HealthElementApi get healthElement => _healthElement;
  @override
  HealthcarePartyApi get healthcareParty => _healthcareParty;
  @override
  InsuranceApi get insurance => _insurance;
  @override
  KeywordApi get keyword => _keyword;
  @override
  MaintenanceTaskApi get maintenanceTask => _maintenanceTask;
  @override
  MedicalLocationApi get medicalLocation => _medicalLocation;
  @override
  MessageApi get message => _message;
  @override
  PatientApi get patient => _patient;
  @override
  PermissionApi get permission => _permission;
  @override
  PlaceApi get place => _place;
  @override
  RoleApi get role => _role;
  @override
  SystemApi get system => _system;
  @override
  TarificationApi get tarification => _tarification;
  @override
  TimeTableApi get timeTable => _timeTable;
  @override
  TopicApi get topic => _topic;
  @override
  UserApi get user => _user;
  @override
  RecoveryApi get recovery => _recovery;

  Future<CardinalSdk> switchGroup(String groupId) async {
    return await CardinalSdkPlatformInterface.instance.initializers.switchGroup(_sdkId, groupId);
  }
}

abstract interface class CardinalBaseApis {
  ApplicationSettingsApi get applicationSettings;
  CodeApi get code;
  DeviceApi get device;
  DocumentTemplateApi get documentTemplate;
  EntityReferenceApi get entityReference;
  EntityTemplateApi get entityTemplate;
  FrontEndMigrationApi get frontEndMigration;
  GroupApi get group;
  HealthcarePartyApi get healthcareParty;
  SystemApi get system;
  InsuranceApi get insurance;
  KeywordApi get keyword;
  PermissionApi get permission;
  PlaceApi get place;
  RoleApi get role;
  TarificationApi get tarification;
  UserApi get user;
  MedicalLocationApi get medicalLocation;
  AgendaApi get agenda;
  AccessLogBasicApi get accessLog;
  CalendarItemBasicApi get calendarItem;
  ClassificationBasicApi get classification;
  ContactBasicApi get contact;
  DocumentBasicApi get document;
  FormBasicApi get form;
  HealthElementBasicApi get healthElement;
  MaintenanceTaskBasicApi get maintenanceTask;
  MessageBasicApi get message;
  PatientBasicApi get patient;
  TimeTableApi get timeTable;
  TopicBasicApi get topic;
}

class CardinalBaseSdk extends CardinalBaseApis {
  static final Finalizer<String> _finalizer = Finalizer((resourceId) =>
      CardinalSdkPlatformInterface.instance.utils.releasePlatformResource(resourceId)
  );

  final String _sdkId;
  late final ApplicationSettingsApi _applicationSettings;
  late final CodeApi _code;
  late final DeviceApi _device;
  late final DocumentTemplateApi _documentTemplate;
  late final EntityReferenceApi _entityReference;
  late final EntityTemplateApi _entityTemplate;
  late final FrontEndMigrationApi _frontEndMigration;
  late final GroupApi _group;
  late final HealthcarePartyApi _healthcareParty;
  late final SystemApi _system;
  late final InsuranceApi _insurance;
  late final KeywordApi _keyword;
  late final PermissionApi _permission;
  late final PlaceApi _place;
  late final RoleApi _role;
  late final TarificationApi _tarification;
  late final UserApi _user;
  late final MedicalLocationApi _medicalLocation;
  late final AgendaApi _agenda;
  late final AccessLogBasicApi _accessLog;
  late final CalendarItemBasicApi _calendarItem;
  late final ClassificationBasicApi _classification;
  late final ContactBasicApi _contact;
  late final DocumentBasicApi _document;
  late final FormBasicApi _form;
  late final HealthElementBasicApi _healthElement;
  late final MaintenanceTaskBasicApi _maintenanceTask;
  late final MessageBasicApi _message;
  late final PatientBasicApi _patient;
  late final TimeTableApi _timeTable;
  late final TopicBasicApi _topic;

  CardinalBaseSdk._(
    this._sdkId
  ) {
    _applicationSettings = ApplicationSettingsApi(_sdkId, this);
    _code = CodeApi(_sdkId, this);
    _device = DeviceApi(_sdkId, this);
    _documentTemplate = DocumentTemplateApi(_sdkId, this);
    _entityReference = EntityReferenceApi(_sdkId, this);
    _entityTemplate = EntityTemplateApi(_sdkId, this);
    _frontEndMigration = FrontEndMigrationApi(_sdkId, this);
    _group = GroupApi(_sdkId, this);
    _healthcareParty = HealthcarePartyApi(_sdkId, this);
    _system = SystemApi(_sdkId, this);
    _insurance = InsuranceApi(_sdkId, this);
    _keyword = KeywordApi(_sdkId, this);
    _permission = PermissionApi(_sdkId, this);
    _place = PlaceApi(_sdkId, this);
    _role = RoleApi(_sdkId, this);
    _tarification = TarificationApi(_sdkId, this);
    _user = UserApi(_sdkId, this);
    _medicalLocation = MedicalLocationApi(_sdkId, this);
    _agenda = AgendaApi(_sdkId, this);
    _accessLog = AccessLogBasicApi(_sdkId, this);
    _calendarItem = CalendarItemBasicApi(_sdkId, this);
    _classification = ClassificationBasicApi(_sdkId, this);
    _contact = ContactBasicApi(_sdkId, this);
    _document = DocumentBasicApi(_sdkId, this);
    _form = FormBasicApi(_sdkId, this);
    _healthElement = HealthElementBasicApi(_sdkId, this);
    _maintenanceTask = MaintenanceTaskBasicApi(_sdkId, this);
    _message = MessageBasicApi(_sdkId, this);
    _patient = PatientBasicApi(_sdkId, this);
    _timeTable = TimeTableApi(_sdkId, this);
    _topic = TopicBasicApi(_sdkId, this);
  }

  factory CardinalBaseSdk.internal(String sdkId) {
    final sdk = CardinalBaseSdk._(sdkId);
    _finalizer.attach(sdk, sdkId, detach: sdk);
    return sdk;
  }

  static Future<CardinalBaseSdk> initialize(
      String? projectId,
      String baseUrl,
      AuthenticationMethod authenticationMethod,
      {BasicSdkOptions options = const BasicSdkOptions()}
      ) {
    return CardinalSdkPlatformInterface.instance.initializers.initializeBase(
        projectId,
        baseUrl,
        authenticationMethod,
        options
    );
  }

  @override
  ApplicationSettingsApi get applicationSettings => _applicationSettings;
  @override
  CodeApi get code => _code;
  @override
  DeviceApi get device => _device;
  @override
  DocumentTemplateApi get documentTemplate => _documentTemplate;
  @override
  EntityReferenceApi get entityReference => _entityReference;
  @override
  EntityTemplateApi get entityTemplate => _entityTemplate;
  @override
  FrontEndMigrationApi get frontEndMigration => _frontEndMigration;
  @override
  GroupApi get group => _group;
  @override
  HealthcarePartyApi get healthcareParty => _healthcareParty;
  @override
  SystemApi get system => _system;
  @override
  InsuranceApi get insurance => _insurance;
  @override
  KeywordApi get keyword => _keyword;
  @override
  PermissionApi get permission => _permission;
  @override
  PlaceApi get place => _place;
  @override
  RoleApi get role => _role;
  @override
  TarificationApi get tarification => _tarification;
  @override
  UserApi get user => _user;
  @override
  MedicalLocationApi get medicalLocation => _medicalLocation;
  @override
  AgendaApi get agenda => _agenda;
  @override
  AccessLogBasicApi get accessLog => _accessLog;
  @override
  CalendarItemBasicApi get calendarItem => _calendarItem;
  @override
  ClassificationBasicApi get classification => _classification;
  @override
  ContactBasicApi get contact => _contact;
  @override
  DocumentBasicApi get document => _document;
  @override
  FormBasicApi get form => _form;
  @override
  HealthElementBasicApi get healthElement => _healthElement;
  @override
  MaintenanceTaskBasicApi get maintenanceTask => _maintenanceTask;
  @override
  MessageBasicApi get message => _message;
  @override
  PatientBasicApi get patient => _patient;
  @override
  TimeTableApi get timeTable => _timeTable;
  @override
  TopicBasicApi get topic => _topic;

  Future<CardinalBaseSdk> switchGroup(String groupId) async {
    return await CardinalSdkPlatformInterface.instance.initializers.baseSwitchGroup(_sdkId, groupId);
  }
}

class CardinalSdkMethodChannelInitializers extends CardinalSdkInitializersPlugin {
  static const MethodChannel _methodChannel = MethodChannel("com.icure.cardinal.sdk/initializers");

  @override
  Future<AuthenticationWithProcessStep> initializeWithProcess(
      String? projectId,
      String baseUrl,
      String messageGatewayUrl,
      String externalServicesSpecId,
      String processId,
      AuthenticationProcessTelecomType userTelecomType,
      String userTelecom,
      CaptchaOptions captcha,
      StorageOptions storageOptions,
      AuthenticationProcessTemplateParameters authenticationProcessTemplateParameters,
      SdkOptions options
  ) async {
    final res = await _methodChannel.invokeMethod<String>(
        "initializeWithAuthProcess",
        {
          "projectId": jsonEncode(projectId),
          "baseUrl": jsonEncode(baseUrl),
          "messageGatewayUrl": jsonEncode(messageGatewayUrl),
          "externalServicesSpecId": jsonEncode(externalServicesSpecId),
          "processId": jsonEncode(processId),
          "userTelecomType": jsonEncode(AuthenticationProcessTelecomType.encode(userTelecomType)),
          "userTelecom": jsonEncode(userTelecom),
          "captchaOptions": jsonEncode(CaptchaOptions.encode(captcha)),
          "storageOptions": jsonEncode(StorageOptions.encode(storageOptions)),
          "authenticationProcessTemplateParameters": jsonEncode(AuthenticationProcessTemplateParameters.encode(authenticationProcessTemplateParameters)),
          "options": jsonEncode(SdkOptions.encode(options))
        }
    ).catchError(convertPlatformException);
    if (res == null) throw AssertionError("received null result from platform method initializeWithProcess");
    final parsedResJson = jsonDecode(res);
    return AuthenticationWithProcessStep._factory(parsedResJson as String);
  }

  @override
  Future<CardinalSdk> completeAuthentication(String authenticationStepId, String validationCode) async {
    final res = await _methodChannel.invokeMethod<String>(
        "completeAuthentication",
        {
          "authenticationStepId": authenticationStepId,
          "validationCode": jsonEncode(validationCode)
        }
    ).catchError(convertPlatformException);
    if (res == null) throw AssertionError("received null result from platform method completeAuthentication");
    final parsedResJson = jsonDecode(res);
    return CardinalSdk.internal(parsedResJson as String);
  }

  @override
  Future<CardinalSdk> initialize(
      String? projectId,
      String baseUrl,
      AuthenticationMethod authenticationMethod,
      StorageOptions storageOptions,
      SdkOptions options
  ) async {
    final res = await _methodChannel.invokeMethod<String>(
        "initialize",
        {
          "projectId": jsonEncode(projectId),
          "baseUrl": jsonEncode(baseUrl),
          "authenticationMethod": jsonEncode(AuthenticationMethod.encode(authenticationMethod)),
          "storageOptions": jsonEncode(StorageOptions.encode(storageOptions)),
          "options": jsonEncode(SdkOptions.encode(options))
        }
    ).catchError(convertPlatformException);
    if (res == null) throw AssertionError("received null result from platform method initialize");
    final parsedResJson = jsonDecode(res);
    return CardinalSdk.internal(parsedResJson as String);
  }

  @override
  Future<CardinalBaseSdk> initializeBase(
    String? projectId,
    String baseUrl,
    AuthenticationMethod authenticationMethod,
    BasicSdkOptions options
  ) async {
    final res = await _methodChannel.invokeMethod<String>(
        "initializeBase",
        {
          "projectId": jsonEncode(projectId),
          "baseUrl": jsonEncode(baseUrl),
          "authenticationMethod": jsonEncode(AuthenticationMethod.encode(authenticationMethod)),
          "options": jsonEncode(BasicSdkOptions.encode(options))
        }
    ).catchError(convertPlatformException);
    if (res == null) throw AssertionError("received null result from platform method initializeBase");
    final parsedResJson = jsonDecode(res);
    return CardinalBaseSdk.internal(parsedResJson as String);
  }

  @override
  Future<CardinalSdk> switchGroup(String sdkId, String groupId) async {
    final res = await _methodChannel.invokeMethod<String>(
        "switchGroup",
        {
          "sdkId": sdkId,
          "groupId": groupId
        }
    ).catchError(convertPlatformException);
    if (res == null) throw AssertionError("received null result from platform method switchGroup");
    final parsedResJson = jsonDecode(res);
    return CardinalSdk.internal(parsedResJson as String);
  }

  @override
  Future<CardinalBaseSdk> baseSwitchGroup(String sdkId, String groupId) async {
    final res = await _methodChannel.invokeMethod<String>(
        "baseSwitchGroup",
        {
          "sdkId": sdkId,
          "groupId": groupId
        }
    ).catchError(convertPlatformException);
    if (res == null) throw AssertionError("received null result from platform method baseSwitchGroup");
    final parsedResJson = jsonDecode(res);
    return CardinalBaseSdk.internal(parsedResJson as String);
  }
}