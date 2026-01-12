import json
from cardinal_sdk.kotlin_types import symbols
from typing import Optional, Union, Dict, Any, Tuple
from ctypes import c_char_p, cast
from concurrent.futures import Executor
from cardinal_sdk.authentication.AuthenticationMethod import AuthenticationMethod, _serialize_authentication_method
from cardinal_sdk.storage.StorageFacadeOptions import StorageOptions, _serialize_storage_options, CustomStorageFacade, _CustomStorageFacadeBridge
from cardinal_sdk.options.SdkOptions import SdkOptions, _serialize_encrypted_fields
from cardinal_sdk.options.JsonPatcher import _JsonPatcherBridge
from cardinal_sdk.api import DataOwnerApi, AccessLogApi, CalendarItemApi, ClassificationApi, ContactApi, \
    DocumentApi, FormApi, HealthElementApi, InvoiceApi, MaintenanceTaskApi, MessageApi, PatientApi, ReceiptApi, \
    TimeTableApi, TopicApi, ApplicationSettingsApi, CodeApi, CryptoApi, DeviceApi, DocumentTemplateApi, \
    EntityReferenceApi, EntityTemplateApi, FrontEndMigrationApi, GroupApi, HealthcarePartyApi, SystemApi, InsuranceApi, \
    KeywordApi, PermissionApi, PlaceApi, RecoveryApi, RoleApi, TarificationApi, UserApi
from cardinal_sdk.CryptoStrategies import _CryptoStrategiesBridge

class CardinalSdk:
    __health_element: Optional[HealthElementApi] = None
    __dataOwner: Optional[DataOwnerApi] = None
    __accessLog: Optional[AccessLogApi] = None
    __calendarItem: Optional[CalendarItemApi] = None
    __classification: Optional[ClassificationApi] = None
    __contact: Optional[ContactApi] = None
    __document: Optional[DocumentApi] = None
    __form: Optional[FormApi] = None
    __invoice: Optional[InvoiceApi] = None
    __maintenanceTask: Optional[MaintenanceTaskApi] = None
    __message: Optional[MessageApi] = None
    __patient: Optional[PatientApi] = None
    __receipt: Optional[ReceiptApi] = None
    __timeTable: Optional[TimeTableApi] = None
    __topic: Optional[TopicApi] = None
    __applicationSettings: Optional[ApplicationSettingsApi] = None
    __code: Optional[CodeApi] = None
    __crypto: Optional[CryptoApi] = None
    __device: Optional[DeviceApi] = None
    __documentTemplate: Optional[DocumentTemplateApi] = None
    __entityReference: Optional[EntityReferenceApi] = None
    __entityTemplate: Optional[EntityTemplateApi] = None
    __frontEndMigration: Optional[FrontEndMigrationApi] = None
    __group: Optional[GroupApi] = None
    __healthcareParty: Optional[HealthcarePartyApi] = None
    __system: Optional[SystemApi] = None
    __insurance: Optional[InsuranceApi] = None
    __keyword: Optional[KeywordApi] = None
    __permission: Optional[PermissionApi] = None
    __place: Optional[PlaceApi] = None
    __recovery: Optional[RecoveryApi] = None
    __role: Optional[RoleApi] = None
    __tarification: Optional[TarificationApi] = None
    __user: Optional[UserApi] = None

    def __init__(
        self,
        project_id: Optional[str],
        baseurl: str,
        authentication_method: AuthenticationMethod,
        storage_facade: StorageOptions,
        options: SdkOptions = SdkOptions(),
        executor: Optional[Executor] = None
    ):
        storage_info = _serialize_storage_options(storage_facade)
        key_storage_info: Tuple[Optional[dict[str, any]], Optional[CustomStorageFacade]] = (
            _serialize_storage_options(options.key_storage)) if options.key_storage is not None else (None, None)

        data_params = {
            'projectId': project_id,
            'baseUrl': baseurl,
            'authenticationMethod': _serialize_authentication_method(authentication_method),
            'storageFacade': storage_info[0],
            'encryptedFields': _serialize_encrypted_fields(options.encrypted_fields),
            'useHierarchicalDataOwners': options.use_hierarchical_data_owners,
            'createTransferKeys': options.create_transfer_keys,
            'keyStorage': key_storage_info[0],
            'lenientJson': options.lenient_json,
        }

        # need to keep a reference to avoid GC
        self.__crypto_strategies_bridge = _CryptoStrategiesBridge(options.crypto_strategies) if options.crypto_strategies is not None else None
        self.__storage_bridge = _CustomStorageFacadeBridge(storage_info[1]) if storage_info[1] is not None else None
        if key_storage_info[1] == storage_info[1]:
            self.__key_storage_bridge = self.__storage_bridge
        elif key_storage_info[1] is not None:
            self.__key_storage_bridge =  _CustomStorageFacadeBridge(key_storage_info[1])
        else:
            self.__key_storage_bridge = None
        self.__json_patcher_bridge = _JsonPatcherBridge(options.json_patcher) if options.json_patcher is not None else None


        sdk_initialization_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.initializeSdk(
            json.dumps(data_params).encode('utf-8'),
            self.__crypto_strategies_bridge.get_kt() if self.__crypto_strategies_bridge is not None else None,
            self.__storage_bridge.get_kt() if self.__storage_bridge is not None else None,
            self.__key_storage_bridge.get_kt() if self.__key_storage_bridge is not None else None,
            self.__json_patcher_bridge.get_kt() if self.__json_patcher_bridge is not None else None,
        )
        failure = symbols.kotlin.root.com.icure.cardinal.sdk.py.SdkInitializationResult.get_failure(sdk_initialization_result)
        if failure is not None:
            symbols.DisposeStablePointer(sdk_initialization_result.pinned)
            trace = cast(failure, c_char_p).value.decode('utf-8')
            symbols.DisposeString(failure)
            raise Exception(trace)
        self._native = symbols.kotlin.root.com.icure.cardinal.sdk.py.SdkInitializationResult.get_success(sdk_initialization_result)
        symbols.DisposeStablePointer(sdk_initialization_result.pinned)
        self._executor = executor

    def __del__(self):
        if self.__dict__.get("_native") is not None:
            symbols.DisposeStablePointer(self._native.pinned)
            symbols.kotlin.root.com.icure.cardinal.sdk.py.closeSdk(self._native)

    @property
    def health_element(self):
        if self.__health_element is None:
            self.__health_element = HealthElementApi(self)
        return self.__health_element

    @property
    def data_owner(self):
        if self.__dataOwner is None:
            self.__dataOwner = DataOwnerApi(self)
        return self.__dataOwner

    @property
    def access_log(self):
        if self.__accessLog is None:
            self.__accessLog = AccessLogApi(self)
        return self.__accessLog

    @property
    def calendar_item(self):
        if self.__calendarItem is None:
            self.__calendarItem = CalendarItemApi(self)
        return self.__calendarItem

    @property
    def classification(self):
        if self.__classification is None:
            self.__classification = ClassificationApi(self)
        return self.__classification

    @property
    def contact(self):
        if self.__contact is None:
            self.__contact = ContactApi(self)
        return self.__contact

    @property
    def document(self):
        if self.__document is None:
            self.__document = DocumentApi(self)
        return self.__document

    @property
    def form(self):
        if self.__form is None:
            self.__form = FormApi(self)
        return self.__form

    @property
    def invoice(self):
        if self.__invoice is None:
            self.__invoice = InvoiceApi(self)
        return self.__invoice

    @property
    def maintenance_task(self):
        if self.__maintenanceTask is None:
            self.__maintenanceTask = MaintenanceTaskApi(self)
        return self.__maintenanceTask

    @property
    def message(self):
        if self.__message is None:
            self.__message = MessageApi(self)
        return self.__message

    @property
    def patient(self):
        if self.__patient is None:
            self.__patient = PatientApi(self)
        return self.__patient

    @property
    def receipt(self):
        if self.__receipt is None:
            self.__receipt = ReceiptApi(self)
        return self.__receipt

    @property
    def time_table(self):
        if self.__timeTable is None:
            self.__timeTable = TimeTableApi(self)
        return self.__timeTable

    @property
    def topic(self):
        if self.__topic is None:
            self.__topic = TopicApi(self)
        return self.__topic

    @property
    def application_settings(self):
        if self.__applicationSettings is None:
            self.__applicationSettings = ApplicationSettingsApi(self)
        return self.__applicationSettings

    @property
    def code(self):
        if self.__code is None:
            self.__code = CodeApi(self)
        return self.__code

    @property
    def crypto(self):
        if self.__crypto is None:
            self.__crypto = CryptoApi(self)
        return self.__crypto

    @property
    def device(self):
        if self.__device is None:
            self.__device = DeviceApi(self)
        return self.__device

    @property
    def document_template(self):
        if self.__documentTemplate is None:
            self.__documentTemplate = DocumentTemplateApi(self)
        return self.__documentTemplate

    @property
    def entity_reference(self):
        if self.__entityReference is None:
            self.__entityReference = EntityReferenceApi(self)
        return self.__entityReference

    @property
    def entity_template(self):
        if self.__entityTemplate is None:
            self.__entityTemplate = EntityTemplateApi(self)
        return self.__entityTemplate

    @property
    def front_end_migration(self):
        if self.__frontEndMigration is None:
            self.__frontEndMigration = FrontEndMigrationApi(self)
        return self.__frontEndMigration

    @property
    def group(self):
        if self.__group is None:
            self.__group = GroupApi(self)
        return self.__group

    @property
    def healthcare_party(self):
        if self.__healthcareParty is None:
            self.__healthcareParty = HealthcarePartyApi(self)
        return self.__healthcareParty

    @property
    def system(self):
        if self.__system is None:
            self.__system = SystemApi(self)
        return self.__system

    @property
    def insurance(self):
        if self.__insurance is None:
            self.__insurance = InsuranceApi(self)
        return self.__insurance

    @property
    def keyword(self):
        if self.__keyword is None:
            self.__keyword = KeywordApi(self)
        return self.__keyword

    @property
    def permission(self):
        if self.__permission is None:
            self.__permission = PermissionApi(self)
        return self.__permission

    @property
    def place(self):
        if self.__place is None:
            self.__place = PlaceApi(self)
        return self.__place

    @property
    def recovery(self):
        if self.__recovery is None:
            self.__recovery = RecoveryApi(self)
        return self.__recovery

    @property
    def role(self):
        if self.__role is None:
            self.__role = RoleApi(self)
        return self.__role

    @property
    def tarification(self):
        if self.__tarification is None:
            self.__tarification = TarificationApi(self)
        return self.__tarification

    @property
    def user(self):
        if self.__user is None:
            self.__user = UserApi(self)
        return self.__user
