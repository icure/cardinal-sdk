from dataclasses import dataclass, field
from typing import List, Optional
from cardinal_sdk.CryptoStrategies import CryptoStrategies
from cardinal_sdk.storage.StorageFacadeOptions import StorageOptions
from cardinal_sdk.options.JsonPatcher import JsonPatcher


@dataclass
class EncryptedFieldsConfiguration:
    access_log: List[str] = field(default_factory=lambda: [
        "detail",
        "objectId",
        "patientId"
    ])
    calendar_item: List[str] = field(default_factory=lambda: [
        "details",
        "title",
        "patientId",
        "phoneNumber",
        "address",
        "addressText",
        "meetingTags[].*",
        "flowItem"
    ])
    contact: List[str] = field(default_factory=lambda: [
        "descr",
        "notes[].markdown",
        "location",
        "encounterLocation",
        "participants",
    ])
    service: List[str] = field(default_factory=lambda: [
        "notes[].markdown",
        "comment",
    ])
    health_element: List[str] = field(default_factory=lambda: [
        "descr",
        "note",
        "notes[].markdown",
        "careTeam[].*",
        "episode[].name",
        "episode[].comment"
    ])
    maintenance_task: List[str] = field(default_factory=lambda: [
        "properties"
    ])
    patient: List[str] = field(default_factory=lambda: [
        "note",
        "notes[].markdown",
        "created",
        "modified",
        "companyName",
        "languages",
        "civility",
        "birthSex",
        "personalStatus",
        "nationality",
        "race",
        "ethnicity",
        "picture",
        "insurabilities[].*",
        "partnerships[].*",
        "patientHealthCareParties[].*",
        "financialInstitutionInformation[].*",
        "medicalHouseContracts[].*",
        "patientProfessions",
        "comment",
        "warning",
        "fatherBirthCountry",
        "birthCountry",
        "nativeCountry",
        "socialStatus",
        "mainSourceOfIncome",
        "schoolingInfos[].*",
        "employementInfos[].*",
    ])
    message: List[str] = field(default_factory=lambda: [
        "subject"
    ])
    topic: List[str] = field(default_factory=lambda: [
        "description",
        "linkedServices",
        "linkedHealthElements"
    ])
    document: List[str] = field(default_factory=lambda: [
        "medicalLocationId",
        "name"
    ])
    form: List[str] = field(default_factory=lambda: [
        "descr"
    ])
    receipt: List[str] = field(default_factory=lambda: [
        "references"
    ])
    classification: List[str] = field(default_factory=lambda: [
        "label"
    ])
    time_table: List[str] = field(default_factory=lambda: [])
    invoice: List[str] = field(default_factory=lambda: [
        "reason"
    ])


@dataclass
class SdkOptions:
    encrypted_fields: EncryptedFieldsConfiguration = field(default_factory=EncryptedFieldsConfiguration)
    use_hierarchical_data_owners: bool = False
    create_transfer_keys: bool = True
    key_storage: Optional[StorageOptions] = None
    crypto_strategies: Optional[CryptoStrategies] = None
    json_patcher: Optional[JsonPatcher] = None
    lenient_json: bool = False


def _serialize_encrypted_fields(fields: EncryptedFieldsConfiguration):
    return {
        'accessLog': fields.access_log,
        'calendarItem': fields.calendar_item,
        'contact': fields.contact,
        'service': fields.service,
        'healthElement': fields.health_element,
        'maintenanceTask': fields.maintenance_task,
        'patient': fields.patient,
        'message': fields.message,
        'topic': fields.topic,
        'document': fields.document,
        'form': fields.form,
        'receipt': fields.receipt,
        'classification': fields.classification,
        'timeTable': fields.time_table,
        'invoice': fields.invoice,
    }