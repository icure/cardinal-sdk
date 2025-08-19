# auto-generated file
import json
import base64
from cardinal_sdk.model.RecoveryDataKey import RecoveryDataKey
from typing import Optional
from dataclasses import field
from typing import Any
from typing import Union
from cardinal_sdk.model.JsonElement import JsonElement
from dataclasses import dataclass
from cardinal_sdk.model.specializations import HexString
from cardinal_sdk.model.specializations import AesExchangeKeyEntryKeyString
from cardinal_sdk.model.specializations import AesExchangeKeyEncryptionKeypairIdentifier
from cardinal_sdk.model.specializations import SpkiHexString
from enum import Enum
from datetime import timedelta
from cardinal_sdk.model.serialization import serialize_timedelta
from cardinal_sdk.model.serialization import deserialize_timedelta
from cardinal_sdk.model.specializations import Base64String
from typing import cast
from collections.abc import Callable
from cardinal_sdk.model.SingletonMeta import SingletonMeta
from cardinal_sdk.model.specializations import SecureDelegationKeyString

@dataclass
class Keyword:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	value: Optional[str] = None
	sub_words: list['KeywordSubword'] = field(default_factory=list)
	user_id: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"value": self.value,
			"subWords": [x0.__serialize__() for x0 in self.sub_words],
			"userId": self.user_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Keyword':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			value=deserialized_dict.get("value"),
			sub_words=[KeywordSubword._deserialize(x0) for x0 in deserialized_dict["subWords"]],
			user_id=deserialized_dict.get("userId"),
		)

@dataclass
class DocIdentifier:
	id: Optional[str] = None
	rev: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DocIdentifier':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict.get("id"),
			rev=deserialized_dict.get("rev"),
		)

@dataclass
class Device:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	identifiers: list['Identifier'] = field(default_factory=list)
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	medical_location_id: Optional[str] = None
	external_id: Optional[str] = None
	name: Optional[str] = None
	type: Optional[str] = None
	brand: Optional[str] = None
	model: Optional[str] = None
	serial_number: Optional[str] = None
	parent_id: Optional[str] = None
	picture: Optional[bytearray] = None
	properties: list['DecryptedPropertyStub'] = field(default_factory=list)
	hc_party_keys: dict[str, list['HexString']] = field(default_factory=dict)
	aes_exchange_keys: dict['AesExchangeKeyEntryKeyString', dict[str, dict['AesExchangeKeyEncryptionKeypairIdentifier', 'HexString']]] = field(default_factory=dict)
	transfer_keys: dict['AesExchangeKeyEncryptionKeypairIdentifier', dict['AesExchangeKeyEncryptionKeypairIdentifier', 'HexString']] = field(default_factory=dict)
	private_key_shamir_partitions: dict[str, 'HexString'] = field(default_factory=dict)
	public_key: Optional['SpkiHexString'] = None
	public_keys_for_oaep_with_sha256: set['SpkiHexString'] = field(default_factory=set)
	crypto_actor_properties: Optional[list['DecryptedPropertyStub']] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"identifiers": [x0.__serialize__() for x0 in self.identifiers],
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"medicalLocationId": self.medical_location_id,
			"externalId": self.external_id,
			"name": self.name,
			"type": self.type,
			"brand": self.brand,
			"model": self.model,
			"serialNumber": self.serial_number,
			"parentId": self.parent_id,
			"picture": base64.b64encode(self.picture).decode('utf-8') if self.picture is not None else None,
			"properties": [x0.__serialize__() for x0 in self.properties],
			"hcPartyKeys": {k0: [x1 for x1 in v0] for k0, v0 in self.hc_party_keys.items()},
			"aesExchangeKeys": {k0: {k1: {k2: v2 for k2, v2 in v1.items()} for k1, v1 in v0.items()} for k0, v0 in self.aes_exchange_keys.items()},
			"transferKeys": {k0: {k1: v1 for k1, v1 in v0.items()} for k0, v0 in self.transfer_keys.items()},
			"privateKeyShamirPartitions": {k0: v0 for k0, v0 in self.private_key_shamir_partitions.items()},
			"publicKey": self.public_key,
			"publicKeysForOaepWithSha256": [x0 for x0 in self.public_keys_for_oaep_with_sha256],
			"cryptoActorProperties": [x0.__serialize__() for x0 in self.crypto_actor_properties] if self.crypto_actor_properties is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Device':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			deletion_date=deserialized_dict.get("deletionDate"),
			identifiers=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifiers"]],
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			external_id=deserialized_dict.get("externalId"),
			name=deserialized_dict.get("name"),
			type=deserialized_dict.get("type"),
			brand=deserialized_dict.get("brand"),
			model=deserialized_dict.get("model"),
			serial_number=deserialized_dict.get("serialNumber"),
			parent_id=deserialized_dict.get("parentId"),
			picture=bytearray(base64.b64decode(deserialized_dict.get("picture"))) if deserialized_dict.get("picture") is not None else None,
			properties=[DecryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict["properties"]],
			hc_party_keys=dict(map(lambda kv0: (kv0[0], [x1 for x1 in kv0[1]]), deserialized_dict["hcPartyKeys"].items())),
			aes_exchange_keys=dict(map(lambda kv0: (kv0[0], dict(map(lambda kv1: (kv1[0], dict(map(lambda kv2: (kv2[0], kv2[1]), kv1[1].items()))), kv0[1].items()))), deserialized_dict["aesExchangeKeys"].items())),
			transfer_keys=dict(map(lambda kv0: (kv0[0], dict(map(lambda kv1: (kv1[0], kv1[1]), kv0[1].items()))), deserialized_dict["transferKeys"].items())),
			private_key_shamir_partitions=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["privateKeyShamirPartitions"].items())),
			public_key=deserialized_dict.get("publicKey"),
			public_keys_for_oaep_with_sha256={x0 for x0 in deserialized_dict["publicKeysForOaepWithSha256"]},
			crypto_actor_properties=[DecryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict.get("cryptoActorProperties")] if deserialized_dict.get("cryptoActorProperties") is not None else None,
		)

@dataclass
class IdWithRev:
	id: str
	rev: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'IdWithRev':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
		)

@dataclass
class StoredDocumentIdentifier:
	id: str
	rev: str

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'StoredDocumentIdentifier':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict["rev"],
		)

class SubscriptionEventType(Enum):
	Create = "Create"
	Update = "Update"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'SubscriptionEventType':
		if data == "Create":
			return SubscriptionEventType.Create
		elif data == "Update":
			return SubscriptionEventType.Update
		else:
			raise Exception(f"{data} is not a valid value for SubscriptionEventType enum.")

@dataclass
class EntitySubscriptionConfiguration:
	channel_buffer_capacity: int = 100
	on_buffer_full: 'EntitySubscriptionConfigurationFullBufferBehaviour' = field(default_factory=lambda: EntitySubscriptionConfigurationFullBufferBehaviour.Close)
	reconnection_delay: timedelta = timedelta(seconds=2)
	retry_delay_exponent_factor: float = 2.0
	connection_max_retries: int = 5

	def __serialize__(self) -> Any:
		return {
			"channelBufferCapacity": self.channel_buffer_capacity,
			"onBufferFull": self.on_buffer_full.__serialize__(),
			"reconnectionDelay": serialize_timedelta(self.reconnection_delay),
			"retryDelayExponentFactor": self.retry_delay_exponent_factor,
			"connectionMaxRetries": self.connection_max_retries,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EntitySubscriptionConfiguration':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			channel_buffer_capacity=deserialized_dict["channelBufferCapacity"],
			on_buffer_full=EntitySubscriptionConfigurationFullBufferBehaviour._deserialize(deserialized_dict["onBufferFull"]),
			reconnection_delay=deserialize_timedelta(deserialized_dict["reconnectionDelay"]),
			retry_delay_exponent_factor=deserialized_dict["retryDelayExponentFactor"],
			connection_max_retries=deserialized_dict["connectionMaxRetries"],
		)

class EntitySubscriptionConfigurationFullBufferBehaviour(Enum):
	Close = "Close"
	DropOldest = "DropOldest"
	Ignore = "Ignore"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EntitySubscriptionConfigurationFullBufferBehaviour':
		if data == "Close":
			return EntitySubscriptionConfigurationFullBufferBehaviour.Close
		elif data == "DropOldest":
			return EntitySubscriptionConfigurationFullBufferBehaviour.DropOldest
		elif data == "Ignore":
			return EntitySubscriptionConfigurationFullBufferBehaviour.Ignore
		else:
			raise Exception(f"{data} is not a valid value for FullBufferBehaviour enum.")

@dataclass
class DecryptedAccessLog:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	object_id: Optional[str] = None
	access_type: Optional[str] = None
	user: Optional[str] = None
	detail: Optional[str] = None
	date: Optional[int] = None
	patient_id: Optional[str] = None
	secret_foreign_keys: set[str] = field(default_factory=set)
	crypted_foreign_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	delegations: dict[str, list['Delegation']] = field(default_factory=dict)
	encryption_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"objectId": self.object_id,
			"accessType": self.access_type,
			"user": self.user,
			"detail": self.detail,
			"date": self.date,
			"patientId": self.patient_id,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedAccessLog':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			object_id=deserialized_dict.get("objectId"),
			access_type=deserialized_dict.get("accessType"),
			user=deserialized_dict.get("user"),
			detail=deserialized_dict.get("detail"),
			date=deserialized_dict.get("date"),
			patient_id=deserialized_dict.get("patientId"),
			secret_foreign_keys={x0 for x0 in deserialized_dict["secretForeignKeys"]},
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

@dataclass
class EncryptedAccessLog:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	object_id: Optional[str] = None
	access_type: Optional[str] = None
	user: Optional[str] = None
	detail: Optional[str] = None
	date: Optional[int] = None
	patient_id: Optional[str] = None
	secret_foreign_keys: set[str] = field(default_factory=set)
	crypted_foreign_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	delegations: dict[str, list['Delegation']] = field(default_factory=dict)
	encryption_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"objectId": self.object_id,
			"accessType": self.access_type,
			"user": self.user,
			"detail": self.detail,
			"date": self.date,
			"patientId": self.patient_id,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedAccessLog':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			object_id=deserialized_dict.get("objectId"),
			access_type=deserialized_dict.get("accessType"),
			user=deserialized_dict.get("user"),
			detail=deserialized_dict.get("detail"),
			date=deserialized_dict.get("date"),
			patient_id=deserialized_dict.get("patientId"),
			secret_foreign_keys={x0 for x0 in deserialized_dict["secretForeignKeys"]},
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

type AccessLog = Union['DecryptedAccessLog', 'EncryptedAccessLog']

def serialize_access_log(access_log: AccessLog) -> Any:
	if isinstance(access_log, DecryptedAccessLog):
		serialized_entity = access_log.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.DecryptedAccessLog"})
		return serialized_entity
	elif isinstance(access_log, EncryptedAccessLog):
		serialized_entity = access_log.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.EncryptedAccessLog"})
		return serialized_entity
	else:
		raise Exception(f"{type(access_log)} is not a known subclass of AccessLog")

def deserialize_access_log(data: Union[str, dict[str, JsonElement]]) -> 'AccessLog':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.DecryptedAccessLog":
		return DecryptedAccessLog._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.EncryptedAccessLog":
		return EncryptedAccessLog._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of AccessLog")

@dataclass
class Place:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	name: Optional[str] = None
	address: Optional['DecryptedAddress'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"name": self.name,
			"address": self.address.__serialize__() if self.address is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Place':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			deletion_date=deserialized_dict.get("deletionDate"),
			name=deserialized_dict.get("name"),
			address=DecryptedAddress._deserialize(deserialized_dict.get("address")) if deserialized_dict.get("address") is not None else None,
		)

@dataclass
class MedicalLocation:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	name: Optional[str] = None
	description: Optional[str] = None
	responsible: Optional[str] = None
	guard_post: Optional[bool] = None
	cbe: Optional[str] = None
	bic: Optional[str] = None
	bank_account: Optional[str] = None
	nihii: Optional[str] = None
	ssin: Optional[str] = None
	address: Optional['DecryptedAddress'] = None
	agenda_ids: set[str] = field(default_factory=set)
	options: dict[str, str] = field(default_factory=dict)
	public_informations: dict[str, str] = field(default_factory=dict)

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"name": self.name,
			"description": self.description,
			"responsible": self.responsible,
			"guardPost": self.guard_post,
			"cbe": self.cbe,
			"bic": self.bic,
			"bankAccount": self.bank_account,
			"nihii": self.nihii,
			"ssin": self.ssin,
			"address": self.address.__serialize__() if self.address is not None else None,
			"agendaIds": [x0 for x0 in self.agenda_ids],
			"options": {k0: v0 for k0, v0 in self.options.items()},
			"publicInformations": {k0: v0 for k0, v0 in self.public_informations.items()},
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'MedicalLocation':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			deletion_date=deserialized_dict.get("deletionDate"),
			name=deserialized_dict.get("name"),
			description=deserialized_dict.get("description"),
			responsible=deserialized_dict.get("responsible"),
			guard_post=deserialized_dict.get("guardPost"),
			cbe=deserialized_dict.get("cbe"),
			bic=deserialized_dict.get("bic"),
			bank_account=deserialized_dict.get("bankAccount"),
			nihii=deserialized_dict.get("nihii"),
			ssin=deserialized_dict.get("ssin"),
			address=DecryptedAddress._deserialize(deserialized_dict.get("address")) if deserialized_dict.get("address") is not None else None,
			agenda_ids={x0 for x0 in deserialized_dict["agendaIds"]},
			options=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["options"].items())),
			public_informations=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["publicInformations"].items())),
		)

@dataclass
class ListOfIds:
	ids: list[str] = field(default_factory=list)

	def __serialize__(self) -> Any:
		return {
			"ids": [x0 for x0 in self.ids],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ListOfIds':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			ids=[x0 for x0 in deserialized_dict["ids"]],
		)

@dataclass
class TimeTable:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	name: Optional[str] = None
	agenda_id: Optional[str] = None
	start_time: Optional[int] = None
	end_time: Optional[int] = None
	items: list['TimeTableItem'] = field(default_factory=list)

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"name": self.name,
			"agendaId": self.agenda_id,
			"startTime": self.start_time,
			"endTime": self.end_time,
			"items": [x0.__serialize__() for x0 in self.items],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'TimeTable':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			name=deserialized_dict.get("name"),
			agenda_id=deserialized_dict.get("agendaId"),
			start_time=deserialized_dict.get("startTime"),
			end_time=deserialized_dict.get("endTime"),
			items=[TimeTableItem._deserialize(x0) for x0 in deserialized_dict["items"]],
		)

@dataclass
class EncryptedDocument:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	document_location: Optional['DocumentLocation'] = None
	document_type: Optional['DocumentType'] = None
	document_status: Optional['DocumentStatus'] = None
	external_uri: Optional[str] = None
	name: Optional[str] = None
	version: Optional[str] = None
	stored_icure_document_id: Optional[str] = None
	external_uuid: Optional[str] = None
	size: Optional[int] = None
	hash: Optional[str] = None
	opening_contact_id: Optional[str] = None
	attachment_id: Optional[str] = None
	object_store_reference: Optional[str] = None
	main_uti: Optional[str] = None
	other_utis: set[str] = field(default_factory=set)
	secondary_attachments: dict[str, 'DataAttachment'] = field(default_factory=dict)
	deleted_attachments: list['DeletedAttachment'] = field(default_factory=list)
	encrypted_attachment: Optional[bytearray] = None
	decrypted_attachment: Optional[bytearray] = None
	secret_foreign_keys: set[str] = field(default_factory=set)
	crypted_foreign_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	delegations: dict[str, list['Delegation']] = field(default_factory=dict)
	encryption_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"documentLocation": self.document_location.__serialize__() if self.document_location is not None else None,
			"documentType": self.document_type.__serialize__() if self.document_type is not None else None,
			"documentStatus": self.document_status.__serialize__() if self.document_status is not None else None,
			"externalUri": self.external_uri,
			"name": self.name,
			"version": self.version,
			"storedICureDocumentId": self.stored_icure_document_id,
			"externalUuid": self.external_uuid,
			"size": self.size,
			"hash": self.hash,
			"openingContactId": self.opening_contact_id,
			"attachmentId": self.attachment_id,
			"objectStoreReference": self.object_store_reference,
			"mainUti": self.main_uti,
			"otherUtis": [x0 for x0 in self.other_utis],
			"secondaryAttachments": {k0: v0.__serialize__() for k0, v0 in self.secondary_attachments.items()},
			"deletedAttachments": [x0.__serialize__() for x0 in self.deleted_attachments],
			"encryptedAttachment": base64.b64encode(self.encrypted_attachment).decode('utf-8') if self.encrypted_attachment is not None else None,
			"decryptedAttachment": base64.b64encode(self.decrypted_attachment).decode('utf-8') if self.decrypted_attachment is not None else None,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedDocument':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			document_location=DocumentLocation._deserialize(deserialized_dict.get("documentLocation")) if deserialized_dict.get("documentLocation") is not None else None,
			document_type=DocumentType._deserialize(deserialized_dict.get("documentType")) if deserialized_dict.get("documentType") is not None else None,
			document_status=DocumentStatus._deserialize(deserialized_dict.get("documentStatus")) if deserialized_dict.get("documentStatus") is not None else None,
			external_uri=deserialized_dict.get("externalUri"),
			name=deserialized_dict.get("name"),
			version=deserialized_dict.get("version"),
			stored_icure_document_id=deserialized_dict.get("storedICureDocumentId"),
			external_uuid=deserialized_dict.get("externalUuid"),
			size=deserialized_dict.get("size"),
			hash=deserialized_dict.get("hash"),
			opening_contact_id=deserialized_dict.get("openingContactId"),
			attachment_id=deserialized_dict.get("attachmentId"),
			object_store_reference=deserialized_dict.get("objectStoreReference"),
			main_uti=deserialized_dict.get("mainUti"),
			other_utis={x0 for x0 in deserialized_dict["otherUtis"]},
			secondary_attachments=dict(map(lambda kv0: (kv0[0], DataAttachment._deserialize(kv0[1])), deserialized_dict["secondaryAttachments"].items())),
			deleted_attachments=[DeletedAttachment._deserialize(x0) for x0 in deserialized_dict["deletedAttachments"]],
			encrypted_attachment=bytearray(base64.b64decode(deserialized_dict.get("encryptedAttachment"))) if deserialized_dict.get("encryptedAttachment") is not None else None,
			decrypted_attachment=bytearray(base64.b64decode(deserialized_dict.get("decryptedAttachment"))) if deserialized_dict.get("decryptedAttachment") is not None else None,
			secret_foreign_keys={x0 for x0 in deserialized_dict["secretForeignKeys"]},
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

@dataclass
class DecryptedDocument:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	document_location: Optional['DocumentLocation'] = None
	document_type: Optional['DocumentType'] = None
	document_status: Optional['DocumentStatus'] = None
	external_uri: Optional[str] = None
	name: Optional[str] = None
	version: Optional[str] = None
	stored_icure_document_id: Optional[str] = None
	external_uuid: Optional[str] = None
	size: Optional[int] = None
	hash: Optional[str] = None
	opening_contact_id: Optional[str] = None
	attachment_id: Optional[str] = None
	object_store_reference: Optional[str] = None
	main_uti: Optional[str] = None
	other_utis: set[str] = field(default_factory=set)
	secondary_attachments: dict[str, 'DataAttachment'] = field(default_factory=dict)
	deleted_attachments: list['DeletedAttachment'] = field(default_factory=list)
	encrypted_attachment: Optional[bytearray] = None
	decrypted_attachment: Optional[bytearray] = None
	secret_foreign_keys: set[str] = field(default_factory=set)
	crypted_foreign_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	delegations: dict[str, list['Delegation']] = field(default_factory=dict)
	encryption_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"documentLocation": self.document_location.__serialize__() if self.document_location is not None else None,
			"documentType": self.document_type.__serialize__() if self.document_type is not None else None,
			"documentStatus": self.document_status.__serialize__() if self.document_status is not None else None,
			"externalUri": self.external_uri,
			"name": self.name,
			"version": self.version,
			"storedICureDocumentId": self.stored_icure_document_id,
			"externalUuid": self.external_uuid,
			"size": self.size,
			"hash": self.hash,
			"openingContactId": self.opening_contact_id,
			"attachmentId": self.attachment_id,
			"objectStoreReference": self.object_store_reference,
			"mainUti": self.main_uti,
			"otherUtis": [x0 for x0 in self.other_utis],
			"secondaryAttachments": {k0: v0.__serialize__() for k0, v0 in self.secondary_attachments.items()},
			"deletedAttachments": [x0.__serialize__() for x0 in self.deleted_attachments],
			"encryptedAttachment": base64.b64encode(self.encrypted_attachment).decode('utf-8') if self.encrypted_attachment is not None else None,
			"decryptedAttachment": base64.b64encode(self.decrypted_attachment).decode('utf-8') if self.decrypted_attachment is not None else None,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedDocument':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			document_location=DocumentLocation._deserialize(deserialized_dict.get("documentLocation")) if deserialized_dict.get("documentLocation") is not None else None,
			document_type=DocumentType._deserialize(deserialized_dict.get("documentType")) if deserialized_dict.get("documentType") is not None else None,
			document_status=DocumentStatus._deserialize(deserialized_dict.get("documentStatus")) if deserialized_dict.get("documentStatus") is not None else None,
			external_uri=deserialized_dict.get("externalUri"),
			name=deserialized_dict.get("name"),
			version=deserialized_dict.get("version"),
			stored_icure_document_id=deserialized_dict.get("storedICureDocumentId"),
			external_uuid=deserialized_dict.get("externalUuid"),
			size=deserialized_dict.get("size"),
			hash=deserialized_dict.get("hash"),
			opening_contact_id=deserialized_dict.get("openingContactId"),
			attachment_id=deserialized_dict.get("attachmentId"),
			object_store_reference=deserialized_dict.get("objectStoreReference"),
			main_uti=deserialized_dict.get("mainUti"),
			other_utis={x0 for x0 in deserialized_dict["otherUtis"]},
			secondary_attachments=dict(map(lambda kv0: (kv0[0], DataAttachment._deserialize(kv0[1])), deserialized_dict["secondaryAttachments"].items())),
			deleted_attachments=[DeletedAttachment._deserialize(x0) for x0 in deserialized_dict["deletedAttachments"]],
			encrypted_attachment=bytearray(base64.b64decode(deserialized_dict.get("encryptedAttachment"))) if deserialized_dict.get("encryptedAttachment") is not None else None,
			decrypted_attachment=bytearray(base64.b64decode(deserialized_dict.get("decryptedAttachment"))) if deserialized_dict.get("decryptedAttachment") is not None else None,
			secret_foreign_keys={x0 for x0 in deserialized_dict["secretForeignKeys"]},
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

type Document = Union['EncryptedDocument', 'DecryptedDocument']

def serialize_document(document: Document) -> Any:
	if isinstance(document, EncryptedDocument):
		serialized_entity = document.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.EncryptedDocument"})
		return serialized_entity
	elif isinstance(document, DecryptedDocument):
		serialized_entity = document.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.DecryptedDocument"})
		return serialized_entity
	else:
		raise Exception(f"{type(document)} is not a known subclass of Document")

def deserialize_document(data: Union[str, dict[str, JsonElement]]) -> 'Document':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.EncryptedDocument":
		return EncryptedDocument._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.DecryptedDocument":
		return DecryptedDocument._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of Document")

@dataclass
class EncryptedPatient:
	id: str
	identifier: list['Identifier'] = field(default_factory=list)
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	first_name: Optional[str] = None
	last_name: Optional[str] = None
	names: list['PersonName'] = field(default_factory=list)
	company_name: Optional[str] = None
	languages: list[str] = field(default_factory=list)
	addresses: list['EncryptedAddress'] = field(default_factory=list)
	civility: Optional[str] = None
	gender: Optional['Gender'] = field(default_factory=lambda: Gender.Unknown)
	birth_sex: Optional['Gender'] = field(default_factory=lambda: Gender.Unknown)
	merge_to_patient_id: Optional[str] = None
	merged_ids: set[str] = field(default_factory=set)
	alias: Optional[str] = None
	active: bool = True
	deactivation_reason: 'DeactivationReason' = field(default_factory=lambda: DeactivationReason.Nothing)
	deactivation_date: Optional[int] = None
	ssin: Optional[str] = None
	maiden_name: Optional[str] = None
	spouse_name: Optional[str] = None
	partner_name: Optional[str] = None
	personal_status: Optional['PersonalStatus'] = field(default_factory=lambda: PersonalStatus.Unknown)
	date_of_birth: Optional[int] = None
	date_of_death: Optional[int] = None
	timestamp_of_latest_eid_reading: Optional[int] = None
	place_of_birth: Optional[str] = None
	place_of_death: Optional[str] = None
	deceased: Optional[bool] = None
	education: Optional[str] = None
	profession: Optional[str] = None
	notes: list['Annotation'] = field(default_factory=list)
	note: Optional[str] = None
	administrative_note: Optional[str] = None
	nationality: Optional[str] = None
	race: Optional[str] = None
	ethnicity: Optional[str] = None
	preferred_user_id: Optional[str] = None
	picture: Optional[bytearray] = None
	external_id: Optional[str] = None
	insurabilities: list['EncryptedInsurability'] = field(default_factory=list)
	partnerships: list['Partnership'] = field(default_factory=list)
	patient_health_care_parties: list['EncryptedPatientHealthCareParty'] = field(default_factory=list)
	financial_institution_information: list['EncryptedFinancialInstitutionInformation'] = field(default_factory=list)
	medical_house_contracts: list['EncryptedMedicalHouseContract'] = field(default_factory=list)
	patient_professions: list['CodeStub'] = field(default_factory=list)
	parameters: dict[str, list[str]] = field(default_factory=dict)
	properties: list['EncryptedPropertyStub'] = field(default_factory=list)
	hc_party_keys: dict[str, list['HexString']] = field(default_factory=dict)
	aes_exchange_keys: dict['AesExchangeKeyEntryKeyString', dict[str, dict['AesExchangeKeyEncryptionKeypairIdentifier', 'HexString']]] = field(default_factory=dict)
	transfer_keys: dict['AesExchangeKeyEncryptionKeypairIdentifier', dict['AesExchangeKeyEncryptionKeypairIdentifier', 'HexString']] = field(default_factory=dict)
	private_key_shamir_partitions: dict[str, 'HexString'] = field(default_factory=dict)
	public_key: Optional['SpkiHexString'] = None
	public_keys_for_oaep_with_sha256: set['SpkiHexString'] = field(default_factory=set)
	secret_foreign_keys: set[str] = field(default_factory=set)
	crypted_foreign_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	delegations: dict[str, list['Delegation']] = field(default_factory=dict)
	encryption_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None
	crypto_actor_properties: Optional[list['DecryptedPropertyStub']] = None
	medical_location_id: Optional[str] = None
	non_duplicate_ids: set[str] = field(default_factory=set)
	encrypted_administratives_documents: set[str] = field(default_factory=set)
	comment: Optional[str] = None
	warning: Optional[str] = None
	father_birth_country: Optional['CodeStub'] = None
	birth_country: Optional['CodeStub'] = None
	native_country: Optional['CodeStub'] = None
	social_status: Optional['CodeStub'] = None
	main_source_of_income: Optional['CodeStub'] = None
	schooling_infos: list['EncryptedSchoolingInfo'] = field(default_factory=list)
	employement_infos: list['EncryptedEmploymentInfo'] = field(default_factory=list)
	parent_id: None = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"identifier": [x0.__serialize__() for x0 in self.identifier],
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"firstName": self.first_name,
			"lastName": self.last_name,
			"names": [x0.__serialize__() for x0 in self.names],
			"companyName": self.company_name,
			"languages": [x0 for x0 in self.languages],
			"addresses": [x0.__serialize__() for x0 in self.addresses],
			"civility": self.civility,
			"gender": self.gender.__serialize__() if self.gender is not None else None,
			"birthSex": self.birth_sex.__serialize__() if self.birth_sex is not None else None,
			"mergeToPatientId": self.merge_to_patient_id,
			"mergedIds": [x0 for x0 in self.merged_ids],
			"alias": self.alias,
			"active": self.active,
			"deactivationReason": self.deactivation_reason.__serialize__(),
			"deactivationDate": self.deactivation_date,
			"ssin": self.ssin,
			"maidenName": self.maiden_name,
			"spouseName": self.spouse_name,
			"partnerName": self.partner_name,
			"personalStatus": self.personal_status.__serialize__() if self.personal_status is not None else None,
			"dateOfBirth": self.date_of_birth,
			"dateOfDeath": self.date_of_death,
			"timestampOfLatestEidReading": self.timestamp_of_latest_eid_reading,
			"placeOfBirth": self.place_of_birth,
			"placeOfDeath": self.place_of_death,
			"deceased": self.deceased,
			"education": self.education,
			"profession": self.profession,
			"notes": [x0.__serialize__() for x0 in self.notes],
			"note": self.note,
			"administrativeNote": self.administrative_note,
			"nationality": self.nationality,
			"race": self.race,
			"ethnicity": self.ethnicity,
			"preferredUserId": self.preferred_user_id,
			"picture": base64.b64encode(self.picture).decode('utf-8') if self.picture is not None else None,
			"externalId": self.external_id,
			"insurabilities": [x0.__serialize__() for x0 in self.insurabilities],
			"partnerships": [x0.__serialize__() for x0 in self.partnerships],
			"patientHealthCareParties": [x0.__serialize__() for x0 in self.patient_health_care_parties],
			"financialInstitutionInformation": [x0.__serialize__() for x0 in self.financial_institution_information],
			"medicalHouseContracts": [x0.__serialize__() for x0 in self.medical_house_contracts],
			"patientProfessions": [x0.__serialize__() for x0 in self.patient_professions],
			"parameters": {k0: [x1 for x1 in v0] for k0, v0 in self.parameters.items()},
			"properties": [x0.__serialize__() for x0 in self.properties],
			"hcPartyKeys": {k0: [x1 for x1 in v0] for k0, v0 in self.hc_party_keys.items()},
			"aesExchangeKeys": {k0: {k1: {k2: v2 for k2, v2 in v1.items()} for k1, v1 in v0.items()} for k0, v0 in self.aes_exchange_keys.items()},
			"transferKeys": {k0: {k1: v1 for k1, v1 in v0.items()} for k0, v0 in self.transfer_keys.items()},
			"privateKeyShamirPartitions": {k0: v0 for k0, v0 in self.private_key_shamir_partitions.items()},
			"publicKey": self.public_key,
			"publicKeysForOaepWithSha256": [x0 for x0 in self.public_keys_for_oaep_with_sha256],
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
			"cryptoActorProperties": [x0.__serialize__() for x0 in self.crypto_actor_properties] if self.crypto_actor_properties is not None else None,
			"medicalLocationId": self.medical_location_id,
			"nonDuplicateIds": [x0 for x0 in self.non_duplicate_ids],
			"encryptedAdministrativesDocuments": [x0 for x0 in self.encrypted_administratives_documents],
			"comment": self.comment,
			"warning": self.warning,
			"fatherBirthCountry": self.father_birth_country.__serialize__() if self.father_birth_country is not None else None,
			"birthCountry": self.birth_country.__serialize__() if self.birth_country is not None else None,
			"nativeCountry": self.native_country.__serialize__() if self.native_country is not None else None,
			"socialStatus": self.social_status.__serialize__() if self.social_status is not None else None,
			"mainSourceOfIncome": self.main_source_of_income.__serialize__() if self.main_source_of_income is not None else None,
			"schoolingInfos": [x0.__serialize__() for x0 in self.schooling_infos],
			"employementInfos": [x0.__serialize__() for x0 in self.employement_infos],
			"parentId": self.parent_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedPatient':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			identifier=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			first_name=deserialized_dict.get("firstName"),
			last_name=deserialized_dict.get("lastName"),
			names=[PersonName._deserialize(x0) for x0 in deserialized_dict["names"]],
			company_name=deserialized_dict.get("companyName"),
			languages=[x0 for x0 in deserialized_dict["languages"]],
			addresses=[EncryptedAddress._deserialize(x0) for x0 in deserialized_dict["addresses"]],
			civility=deserialized_dict.get("civility"),
			gender=Gender._deserialize(deserialized_dict.get("gender")) if deserialized_dict.get("gender") is not None else None,
			birth_sex=Gender._deserialize(deserialized_dict.get("birthSex")) if deserialized_dict.get("birthSex") is not None else None,
			merge_to_patient_id=deserialized_dict.get("mergeToPatientId"),
			merged_ids={x0 for x0 in deserialized_dict["mergedIds"]},
			alias=deserialized_dict.get("alias"),
			active=deserialized_dict["active"],
			deactivation_reason=DeactivationReason._deserialize(deserialized_dict["deactivationReason"]),
			deactivation_date=deserialized_dict.get("deactivationDate"),
			ssin=deserialized_dict.get("ssin"),
			maiden_name=deserialized_dict.get("maidenName"),
			spouse_name=deserialized_dict.get("spouseName"),
			partner_name=deserialized_dict.get("partnerName"),
			personal_status=PersonalStatus._deserialize(deserialized_dict.get("personalStatus")) if deserialized_dict.get("personalStatus") is not None else None,
			date_of_birth=deserialized_dict.get("dateOfBirth"),
			date_of_death=deserialized_dict.get("dateOfDeath"),
			timestamp_of_latest_eid_reading=deserialized_dict.get("timestampOfLatestEidReading"),
			place_of_birth=deserialized_dict.get("placeOfBirth"),
			place_of_death=deserialized_dict.get("placeOfDeath"),
			deceased=deserialized_dict.get("deceased"),
			education=deserialized_dict.get("education"),
			profession=deserialized_dict.get("profession"),
			notes=[Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
			note=deserialized_dict.get("note"),
			administrative_note=deserialized_dict.get("administrativeNote"),
			nationality=deserialized_dict.get("nationality"),
			race=deserialized_dict.get("race"),
			ethnicity=deserialized_dict.get("ethnicity"),
			preferred_user_id=deserialized_dict.get("preferredUserId"),
			picture=bytearray(base64.b64decode(deserialized_dict.get("picture"))) if deserialized_dict.get("picture") is not None else None,
			external_id=deserialized_dict.get("externalId"),
			insurabilities=[EncryptedInsurability._deserialize(x0) for x0 in deserialized_dict["insurabilities"]],
			partnerships=[Partnership._deserialize(x0) for x0 in deserialized_dict["partnerships"]],
			patient_health_care_parties=[EncryptedPatientHealthCareParty._deserialize(x0) for x0 in deserialized_dict["patientHealthCareParties"]],
			financial_institution_information=[EncryptedFinancialInstitutionInformation._deserialize(x0) for x0 in deserialized_dict["financialInstitutionInformation"]],
			medical_house_contracts=[EncryptedMedicalHouseContract._deserialize(x0) for x0 in deserialized_dict["medicalHouseContracts"]],
			patient_professions=[CodeStub._deserialize(x0) for x0 in deserialized_dict["patientProfessions"]],
			parameters=dict(map(lambda kv0: (kv0[0], [x1 for x1 in kv0[1]]), deserialized_dict["parameters"].items())),
			properties=[EncryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict["properties"]],
			hc_party_keys=dict(map(lambda kv0: (kv0[0], [x1 for x1 in kv0[1]]), deserialized_dict["hcPartyKeys"].items())),
			aes_exchange_keys=dict(map(lambda kv0: (kv0[0], dict(map(lambda kv1: (kv1[0], dict(map(lambda kv2: (kv2[0], kv2[1]), kv1[1].items()))), kv0[1].items()))), deserialized_dict["aesExchangeKeys"].items())),
			transfer_keys=dict(map(lambda kv0: (kv0[0], dict(map(lambda kv1: (kv1[0], kv1[1]), kv0[1].items()))), deserialized_dict["transferKeys"].items())),
			private_key_shamir_partitions=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["privateKeyShamirPartitions"].items())),
			public_key=deserialized_dict.get("publicKey"),
			public_keys_for_oaep_with_sha256={x0 for x0 in deserialized_dict["publicKeysForOaepWithSha256"]},
			secret_foreign_keys={x0 for x0 in deserialized_dict["secretForeignKeys"]},
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
			crypto_actor_properties=[DecryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict.get("cryptoActorProperties")] if deserialized_dict.get("cryptoActorProperties") is not None else None,
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			non_duplicate_ids={x0 for x0 in deserialized_dict["nonDuplicateIds"]},
			encrypted_administratives_documents={x0 for x0 in deserialized_dict["encryptedAdministrativesDocuments"]},
			comment=deserialized_dict.get("comment"),
			warning=deserialized_dict.get("warning"),
			father_birth_country=CodeStub._deserialize(deserialized_dict.get("fatherBirthCountry")) if deserialized_dict.get("fatherBirthCountry") is not None else None,
			birth_country=CodeStub._deserialize(deserialized_dict.get("birthCountry")) if deserialized_dict.get("birthCountry") is not None else None,
			native_country=CodeStub._deserialize(deserialized_dict.get("nativeCountry")) if deserialized_dict.get("nativeCountry") is not None else None,
			social_status=CodeStub._deserialize(deserialized_dict.get("socialStatus")) if deserialized_dict.get("socialStatus") is not None else None,
			main_source_of_income=CodeStub._deserialize(deserialized_dict.get("mainSourceOfIncome")) if deserialized_dict.get("mainSourceOfIncome") is not None else None,
			schooling_infos=[EncryptedSchoolingInfo._deserialize(x0) for x0 in deserialized_dict["schoolingInfos"]],
			employement_infos=[EncryptedEmploymentInfo._deserialize(x0) for x0 in deserialized_dict["employementInfos"]],
			parent_id=deserialized_dict["parentId"],
		)

@dataclass
class DecryptedPatient:
	id: str
	identifier: list['Identifier'] = field(default_factory=list)
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	first_name: Optional[str] = None
	last_name: Optional[str] = None
	names: list['PersonName'] = field(default_factory=list)
	company_name: Optional[str] = None
	languages: list[str] = field(default_factory=list)
	addresses: list['DecryptedAddress'] = field(default_factory=list)
	civility: Optional[str] = None
	gender: Optional['Gender'] = field(default_factory=lambda: Gender.Unknown)
	birth_sex: Optional['Gender'] = field(default_factory=lambda: Gender.Unknown)
	merge_to_patient_id: Optional[str] = None
	merged_ids: set[str] = field(default_factory=set)
	alias: Optional[str] = None
	active: bool = True
	deactivation_reason: 'DeactivationReason' = field(default_factory=lambda: DeactivationReason.Nothing)
	deactivation_date: Optional[int] = None
	ssin: Optional[str] = None
	maiden_name: Optional[str] = None
	spouse_name: Optional[str] = None
	partner_name: Optional[str] = None
	personal_status: Optional['PersonalStatus'] = field(default_factory=lambda: PersonalStatus.Unknown)
	date_of_birth: Optional[int] = None
	date_of_death: Optional[int] = None
	timestamp_of_latest_eid_reading: Optional[int] = None
	place_of_birth: Optional[str] = None
	place_of_death: Optional[str] = None
	deceased: Optional[bool] = None
	education: Optional[str] = None
	profession: Optional[str] = None
	notes: list['Annotation'] = field(default_factory=list)
	note: Optional[str] = None
	administrative_note: Optional[str] = None
	nationality: Optional[str] = None
	race: Optional[str] = None
	ethnicity: Optional[str] = None
	preferred_user_id: Optional[str] = None
	picture: Optional[bytearray] = None
	external_id: Optional[str] = None
	insurabilities: list['DecryptedInsurability'] = field(default_factory=list)
	partnerships: list['Partnership'] = field(default_factory=list)
	patient_health_care_parties: list['DecryptedPatientHealthCareParty'] = field(default_factory=list)
	financial_institution_information: list['DecryptedFinancialInstitutionInformation'] = field(default_factory=list)
	medical_house_contracts: list['DecryptedMedicalHouseContract'] = field(default_factory=list)
	patient_professions: list['CodeStub'] = field(default_factory=list)
	parameters: dict[str, list[str]] = field(default_factory=dict)
	properties: list['DecryptedPropertyStub'] = field(default_factory=list)
	hc_party_keys: dict[str, list['HexString']] = field(default_factory=dict)
	aes_exchange_keys: dict['AesExchangeKeyEntryKeyString', dict[str, dict['AesExchangeKeyEncryptionKeypairIdentifier', 'HexString']]] = field(default_factory=dict)
	transfer_keys: dict['AesExchangeKeyEncryptionKeypairIdentifier', dict['AesExchangeKeyEncryptionKeypairIdentifier', 'HexString']] = field(default_factory=dict)
	private_key_shamir_partitions: dict[str, 'HexString'] = field(default_factory=dict)
	public_key: Optional['SpkiHexString'] = None
	public_keys_for_oaep_with_sha256: set['SpkiHexString'] = field(default_factory=set)
	secret_foreign_keys: set[str] = field(default_factory=set)
	crypted_foreign_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	delegations: dict[str, list['Delegation']] = field(default_factory=dict)
	encryption_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None
	crypto_actor_properties: Optional[list['DecryptedPropertyStub']] = None
	medical_location_id: Optional[str] = None
	non_duplicate_ids: set[str] = field(default_factory=set)
	encrypted_administratives_documents: set[str] = field(default_factory=set)
	comment: Optional[str] = None
	warning: Optional[str] = None
	father_birth_country: Optional['CodeStub'] = None
	birth_country: Optional['CodeStub'] = None
	native_country: Optional['CodeStub'] = None
	social_status: Optional['CodeStub'] = None
	main_source_of_income: Optional['CodeStub'] = None
	schooling_infos: list['DecryptedSchoolingInfo'] = field(default_factory=list)
	employement_infos: list['DecryptedEmploymentInfo'] = field(default_factory=list)
	parent_id: None = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"identifier": [x0.__serialize__() for x0 in self.identifier],
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"firstName": self.first_name,
			"lastName": self.last_name,
			"names": [x0.__serialize__() for x0 in self.names],
			"companyName": self.company_name,
			"languages": [x0 for x0 in self.languages],
			"addresses": [x0.__serialize__() for x0 in self.addresses],
			"civility": self.civility,
			"gender": self.gender.__serialize__() if self.gender is not None else None,
			"birthSex": self.birth_sex.__serialize__() if self.birth_sex is not None else None,
			"mergeToPatientId": self.merge_to_patient_id,
			"mergedIds": [x0 for x0 in self.merged_ids],
			"alias": self.alias,
			"active": self.active,
			"deactivationReason": self.deactivation_reason.__serialize__(),
			"deactivationDate": self.deactivation_date,
			"ssin": self.ssin,
			"maidenName": self.maiden_name,
			"spouseName": self.spouse_name,
			"partnerName": self.partner_name,
			"personalStatus": self.personal_status.__serialize__() if self.personal_status is not None else None,
			"dateOfBirth": self.date_of_birth,
			"dateOfDeath": self.date_of_death,
			"timestampOfLatestEidReading": self.timestamp_of_latest_eid_reading,
			"placeOfBirth": self.place_of_birth,
			"placeOfDeath": self.place_of_death,
			"deceased": self.deceased,
			"education": self.education,
			"profession": self.profession,
			"notes": [x0.__serialize__() for x0 in self.notes],
			"note": self.note,
			"administrativeNote": self.administrative_note,
			"nationality": self.nationality,
			"race": self.race,
			"ethnicity": self.ethnicity,
			"preferredUserId": self.preferred_user_id,
			"picture": base64.b64encode(self.picture).decode('utf-8') if self.picture is not None else None,
			"externalId": self.external_id,
			"insurabilities": [x0.__serialize__() for x0 in self.insurabilities],
			"partnerships": [x0.__serialize__() for x0 in self.partnerships],
			"patientHealthCareParties": [x0.__serialize__() for x0 in self.patient_health_care_parties],
			"financialInstitutionInformation": [x0.__serialize__() for x0 in self.financial_institution_information],
			"medicalHouseContracts": [x0.__serialize__() for x0 in self.medical_house_contracts],
			"patientProfessions": [x0.__serialize__() for x0 in self.patient_professions],
			"parameters": {k0: [x1 for x1 in v0] for k0, v0 in self.parameters.items()},
			"properties": [x0.__serialize__() for x0 in self.properties],
			"hcPartyKeys": {k0: [x1 for x1 in v0] for k0, v0 in self.hc_party_keys.items()},
			"aesExchangeKeys": {k0: {k1: {k2: v2 for k2, v2 in v1.items()} for k1, v1 in v0.items()} for k0, v0 in self.aes_exchange_keys.items()},
			"transferKeys": {k0: {k1: v1 for k1, v1 in v0.items()} for k0, v0 in self.transfer_keys.items()},
			"privateKeyShamirPartitions": {k0: v0 for k0, v0 in self.private_key_shamir_partitions.items()},
			"publicKey": self.public_key,
			"publicKeysForOaepWithSha256": [x0 for x0 in self.public_keys_for_oaep_with_sha256],
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
			"cryptoActorProperties": [x0.__serialize__() for x0 in self.crypto_actor_properties] if self.crypto_actor_properties is not None else None,
			"medicalLocationId": self.medical_location_id,
			"nonDuplicateIds": [x0 for x0 in self.non_duplicate_ids],
			"encryptedAdministrativesDocuments": [x0 for x0 in self.encrypted_administratives_documents],
			"comment": self.comment,
			"warning": self.warning,
			"fatherBirthCountry": self.father_birth_country.__serialize__() if self.father_birth_country is not None else None,
			"birthCountry": self.birth_country.__serialize__() if self.birth_country is not None else None,
			"nativeCountry": self.native_country.__serialize__() if self.native_country is not None else None,
			"socialStatus": self.social_status.__serialize__() if self.social_status is not None else None,
			"mainSourceOfIncome": self.main_source_of_income.__serialize__() if self.main_source_of_income is not None else None,
			"schoolingInfos": [x0.__serialize__() for x0 in self.schooling_infos],
			"employementInfos": [x0.__serialize__() for x0 in self.employement_infos],
			"parentId": self.parent_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedPatient':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			identifier=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			first_name=deserialized_dict.get("firstName"),
			last_name=deserialized_dict.get("lastName"),
			names=[PersonName._deserialize(x0) for x0 in deserialized_dict["names"]],
			company_name=deserialized_dict.get("companyName"),
			languages=[x0 for x0 in deserialized_dict["languages"]],
			addresses=[DecryptedAddress._deserialize(x0) for x0 in deserialized_dict["addresses"]],
			civility=deserialized_dict.get("civility"),
			gender=Gender._deserialize(deserialized_dict.get("gender")) if deserialized_dict.get("gender") is not None else None,
			birth_sex=Gender._deserialize(deserialized_dict.get("birthSex")) if deserialized_dict.get("birthSex") is not None else None,
			merge_to_patient_id=deserialized_dict.get("mergeToPatientId"),
			merged_ids={x0 for x0 in deserialized_dict["mergedIds"]},
			alias=deserialized_dict.get("alias"),
			active=deserialized_dict["active"],
			deactivation_reason=DeactivationReason._deserialize(deserialized_dict["deactivationReason"]),
			deactivation_date=deserialized_dict.get("deactivationDate"),
			ssin=deserialized_dict.get("ssin"),
			maiden_name=deserialized_dict.get("maidenName"),
			spouse_name=deserialized_dict.get("spouseName"),
			partner_name=deserialized_dict.get("partnerName"),
			personal_status=PersonalStatus._deserialize(deserialized_dict.get("personalStatus")) if deserialized_dict.get("personalStatus") is not None else None,
			date_of_birth=deserialized_dict.get("dateOfBirth"),
			date_of_death=deserialized_dict.get("dateOfDeath"),
			timestamp_of_latest_eid_reading=deserialized_dict.get("timestampOfLatestEidReading"),
			place_of_birth=deserialized_dict.get("placeOfBirth"),
			place_of_death=deserialized_dict.get("placeOfDeath"),
			deceased=deserialized_dict.get("deceased"),
			education=deserialized_dict.get("education"),
			profession=deserialized_dict.get("profession"),
			notes=[Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
			note=deserialized_dict.get("note"),
			administrative_note=deserialized_dict.get("administrativeNote"),
			nationality=deserialized_dict.get("nationality"),
			race=deserialized_dict.get("race"),
			ethnicity=deserialized_dict.get("ethnicity"),
			preferred_user_id=deserialized_dict.get("preferredUserId"),
			picture=bytearray(base64.b64decode(deserialized_dict.get("picture"))) if deserialized_dict.get("picture") is not None else None,
			external_id=deserialized_dict.get("externalId"),
			insurabilities=[DecryptedInsurability._deserialize(x0) for x0 in deserialized_dict["insurabilities"]],
			partnerships=[Partnership._deserialize(x0) for x0 in deserialized_dict["partnerships"]],
			patient_health_care_parties=[DecryptedPatientHealthCareParty._deserialize(x0) for x0 in deserialized_dict["patientHealthCareParties"]],
			financial_institution_information=[DecryptedFinancialInstitutionInformation._deserialize(x0) for x0 in deserialized_dict["financialInstitutionInformation"]],
			medical_house_contracts=[DecryptedMedicalHouseContract._deserialize(x0) for x0 in deserialized_dict["medicalHouseContracts"]],
			patient_professions=[CodeStub._deserialize(x0) for x0 in deserialized_dict["patientProfessions"]],
			parameters=dict(map(lambda kv0: (kv0[0], [x1 for x1 in kv0[1]]), deserialized_dict["parameters"].items())),
			properties=[DecryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict["properties"]],
			hc_party_keys=dict(map(lambda kv0: (kv0[0], [x1 for x1 in kv0[1]]), deserialized_dict["hcPartyKeys"].items())),
			aes_exchange_keys=dict(map(lambda kv0: (kv0[0], dict(map(lambda kv1: (kv1[0], dict(map(lambda kv2: (kv2[0], kv2[1]), kv1[1].items()))), kv0[1].items()))), deserialized_dict["aesExchangeKeys"].items())),
			transfer_keys=dict(map(lambda kv0: (kv0[0], dict(map(lambda kv1: (kv1[0], kv1[1]), kv0[1].items()))), deserialized_dict["transferKeys"].items())),
			private_key_shamir_partitions=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["privateKeyShamirPartitions"].items())),
			public_key=deserialized_dict.get("publicKey"),
			public_keys_for_oaep_with_sha256={x0 for x0 in deserialized_dict["publicKeysForOaepWithSha256"]},
			secret_foreign_keys={x0 for x0 in deserialized_dict["secretForeignKeys"]},
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
			crypto_actor_properties=[DecryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict.get("cryptoActorProperties")] if deserialized_dict.get("cryptoActorProperties") is not None else None,
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			non_duplicate_ids={x0 for x0 in deserialized_dict["nonDuplicateIds"]},
			encrypted_administratives_documents={x0 for x0 in deserialized_dict["encryptedAdministrativesDocuments"]},
			comment=deserialized_dict.get("comment"),
			warning=deserialized_dict.get("warning"),
			father_birth_country=CodeStub._deserialize(deserialized_dict.get("fatherBirthCountry")) if deserialized_dict.get("fatherBirthCountry") is not None else None,
			birth_country=CodeStub._deserialize(deserialized_dict.get("birthCountry")) if deserialized_dict.get("birthCountry") is not None else None,
			native_country=CodeStub._deserialize(deserialized_dict.get("nativeCountry")) if deserialized_dict.get("nativeCountry") is not None else None,
			social_status=CodeStub._deserialize(deserialized_dict.get("socialStatus")) if deserialized_dict.get("socialStatus") is not None else None,
			main_source_of_income=CodeStub._deserialize(deserialized_dict.get("mainSourceOfIncome")) if deserialized_dict.get("mainSourceOfIncome") is not None else None,
			schooling_infos=[DecryptedSchoolingInfo._deserialize(x0) for x0 in deserialized_dict["schoolingInfos"]],
			employement_infos=[DecryptedEmploymentInfo._deserialize(x0) for x0 in deserialized_dict["employementInfos"]],
			parent_id=deserialized_dict["parentId"],
		)

type Patient = Union['EncryptedPatient', 'DecryptedPatient']

def serialize_patient(patient: Patient) -> Any:
	if isinstance(patient, EncryptedPatient):
		serialized_entity = patient.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.EncryptedPatient"})
		return serialized_entity
	elif isinstance(patient, DecryptedPatient):
		serialized_entity = patient.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.DecryptedPatient"})
		return serialized_entity
	else:
		raise Exception(f"{type(patient)} is not a known subclass of Patient")

def deserialize_patient(data: Union[str, dict[str, JsonElement]]) -> 'Patient':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.EncryptedPatient":
		return EncryptedPatient._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.DecryptedPatient":
		return DecryptedPatient._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of Patient")

@dataclass
class EntityAccessInformation:
	permissions_by_data_owner_id: dict['EntityReferenceInGroup', 'AccessLevel']
	has_unknown_anonymous_data_owners: bool

	def __serialize__(self) -> Any:
		return {
			"permissionsByDataOwnerId": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in self.permissions_by_data_owner_id.items()],
			"hasUnknownAnonymousDataOwners": self.has_unknown_anonymous_data_owners,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EntityAccessInformation':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			permissions_by_data_owner_id={ EntityReferenceInGroup._deserialize(x0["k"]): AccessLevel._deserialize(x0["v"]) for x0 in cast(list[dict[str, JsonElement]], deserialized_dict["permissionsByDataOwnerId"]) },
			has_unknown_anonymous_data_owners=deserialized_dict["hasUnknownAnonymousDataOwners"],
		)

@dataclass
class GroupScoped[E]:
	entity: E
	group_id: str

	def __serialize__(self, serialize_e: Callable[[E], Any]) -> Any:
		return {
			"entity": serialize_e(self.entity),
			"groupId": self.group_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]], deserialize_e: Callable[[dict[str, JsonElement]], E]) -> 'GroupScoped[E]':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			entity=deserialize_e(cast(dict, deserialized_dict["entity"])),
			group_id=deserialized_dict["groupId"],
		)

@dataclass
class EncryptedClassification:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	parent_id: Optional[str] = None
	label: str = ""
	template_id: Optional[str] = None
	secret_foreign_keys: set[str] = field(default_factory=set)
	crypted_foreign_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	delegations: dict[str, list['Delegation']] = field(default_factory=dict)
	encryption_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"parentId": self.parent_id,
			"label": self.label,
			"templateId": self.template_id,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedClassification':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			parent_id=deserialized_dict.get("parentId"),
			label=deserialized_dict["label"],
			template_id=deserialized_dict.get("templateId"),
			secret_foreign_keys={x0 for x0 in deserialized_dict["secretForeignKeys"]},
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

@dataclass
class DecryptedClassification:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	parent_id: Optional[str] = None
	label: str = ""
	template_id: Optional[str] = None
	secret_foreign_keys: set[str] = field(default_factory=set)
	crypted_foreign_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	delegations: dict[str, list['Delegation']] = field(default_factory=dict)
	encryption_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"parentId": self.parent_id,
			"label": self.label,
			"templateId": self.template_id,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedClassification':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			parent_id=deserialized_dict.get("parentId"),
			label=deserialized_dict["label"],
			template_id=deserialized_dict.get("templateId"),
			secret_foreign_keys={x0 for x0 in deserialized_dict["secretForeignKeys"]},
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

type Classification = Union['EncryptedClassification', 'DecryptedClassification']

def serialize_classification(classification: Classification) -> Any:
	if isinstance(classification, EncryptedClassification):
		serialized_entity = classification.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.EncryptedClassification"})
		return serialized_entity
	elif isinstance(classification, DecryptedClassification):
		serialized_entity = classification.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.DecryptedClassification"})
		return serialized_entity
	else:
		raise Exception(f"{type(classification)} is not a known subclass of Classification")

def deserialize_classification(data: Union[str, dict[str, JsonElement]]) -> 'Classification':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.EncryptedClassification":
		return EncryptedClassification._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.DecryptedClassification":
		return DecryptedClassification._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of Classification")

@dataclass
class User:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	created: Optional[int] = None
	identifier: list['Identifier'] = field(default_factory=list)
	name: Optional[str] = None
	properties: list['DecryptedPropertyStub'] = field(default_factory=list)
	permissions: list['Permission'] = field(default_factory=list)
	roles: set[str] = field(default_factory=set)
	type: Optional['UsersType'] = None
	status: Optional['UsersStatus'] = None
	login: Optional[str] = None
	password_hash: Optional[str] = None
	group_id: Optional[str] = None
	healthcare_party_id: Optional[str] = None
	patient_id: Optional[str] = None
	device_id: Optional[str] = None
	auto_delegations: dict['DelegationTag', set[str]] = field(default_factory=dict)
	created_date: Optional[int] = None
	terms_of_use_date: Optional[int] = None
	email: Optional[str] = None
	mobile_phone: Optional[str] = None
	application_tokens: dict[str, str] = field(default_factory=dict)
	authentication_tokens: dict[str, 'AuthenticationToken'] = field(default_factory=dict)
	system_metadata: Optional['UserSystemMetadata'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"created": self.created,
			"identifier": [x0.__serialize__() for x0 in self.identifier],
			"name": self.name,
			"properties": [x0.__serialize__() for x0 in self.properties],
			"permissions": [x0.__serialize__() for x0 in self.permissions],
			"roles": [x0 for x0 in self.roles],
			"type": self.type.__serialize__() if self.type is not None else None,
			"status": self.status.__serialize__() if self.status is not None else None,
			"login": self.login,
			"passwordHash": self.password_hash,
			"groupId": self.group_id,
			"healthcarePartyId": self.healthcare_party_id,
			"patientId": self.patient_id,
			"deviceId": self.device_id,
			"autoDelegations": {k0.__serialize__(): [x1 for x1 in v0] for k0, v0 in self.auto_delegations.items()},
			"createdDate": self.created_date,
			"termsOfUseDate": self.terms_of_use_date,
			"email": self.email,
			"mobilePhone": self.mobile_phone,
			"applicationTokens": {k0: v0 for k0, v0 in self.application_tokens.items()},
			"authenticationTokens": {k0: v0.__serialize__() for k0, v0 in self.authentication_tokens.items()},
			"systemMetadata": self.system_metadata.__serialize__() if self.system_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'User':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			deletion_date=deserialized_dict.get("deletionDate"),
			created=deserialized_dict.get("created"),
			identifier=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			name=deserialized_dict.get("name"),
			properties=[DecryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict["properties"]],
			permissions=[Permission._deserialize(x0) for x0 in deserialized_dict["permissions"]],
			roles={x0 for x0 in deserialized_dict["roles"]},
			type=UsersType._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
			status=UsersStatus._deserialize(deserialized_dict.get("status")) if deserialized_dict.get("status") is not None else None,
			login=deserialized_dict.get("login"),
			password_hash=deserialized_dict.get("passwordHash"),
			group_id=deserialized_dict.get("groupId"),
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			patient_id=deserialized_dict.get("patientId"),
			device_id=deserialized_dict.get("deviceId"),
			auto_delegations=dict(map(lambda kv0: (DelegationTag._deserialize(kv0[0]), {x1 for x1 in kv0[1]}), deserialized_dict["autoDelegations"].items())),
			created_date=deserialized_dict.get("createdDate"),
			terms_of_use_date=deserialized_dict.get("termsOfUseDate"),
			email=deserialized_dict.get("email"),
			mobile_phone=deserialized_dict.get("mobilePhone"),
			application_tokens=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["applicationTokens"].items())),
			authentication_tokens=dict(map(lambda kv0: (kv0[0], AuthenticationToken._deserialize(kv0[1])), deserialized_dict["authenticationTokens"].items())),
			system_metadata=UserSystemMetadata._deserialize(deserialized_dict.get("systemMetadata")) if deserialized_dict.get("systemMetadata") is not None else None,
		)

@dataclass
class UserSystemMetadata:
	roles: set[str]
	is_admin: bool
	inherits_roles: bool
	login_identifiers: list['LoginIdentifier'] = field(default_factory=list)

	def __serialize__(self) -> Any:
		return {
			"roles": [x0 for x0 in self.roles],
			"isAdmin": self.is_admin,
			"inheritsRoles": self.inherits_roles,
			"loginIdentifiers": [x0.__serialize__() for x0 in self.login_identifiers],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'UserSystemMetadata':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			roles={x0 for x0 in deserialized_dict["roles"]},
			is_admin=deserialized_dict["isAdmin"],
			inherits_roles=deserialized_dict["inheritsRoles"],
			login_identifiers=[LoginIdentifier._deserialize(x0) for x0 in deserialized_dict["loginIdentifiers"]],
		)

class AccessLevel(Enum):
	Read = "READ"
	Write = "WRITE"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'AccessLevel':
		if data == "READ":
			return AccessLevel.Read
		elif data == "WRITE":
			return AccessLevel.Write
		else:
			raise Exception(f"{data} is not a valid value for AccessLevel enum.")

class SecretIdUseOptionUseAnyConfidential(metaclass=SingletonMeta):

	def __serialize__(self) -> Any:
		return {}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'SecretIdUseOptionUseAnyConfidential':
		return cls()

class SecretIdUseOptionUseAllConfidential(metaclass=SingletonMeta):

	def __serialize__(self) -> Any:
		return {}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'SecretIdUseOptionUseAllConfidential':
		return cls()

class SecretIdUseOptionUseAnySharedWithParent(metaclass=SingletonMeta):

	def __serialize__(self) -> Any:
		return {}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'SecretIdUseOptionUseAnySharedWithParent':
		return cls()

class SecretIdUseOptionUseAllSharedWithParent(metaclass=SingletonMeta):

	def __serialize__(self) -> Any:
		return {}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'SecretIdUseOptionUseAllSharedWithParent':
		return cls()

@dataclass
class SecretIdUseOptionUse:
	secret_ids: set[str]

	def __serialize__(self) -> Any:
		return {
			"secretIds": [x0 for x0 in self.secret_ids],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'SecretIdUseOptionUse':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			secret_ids={x0 for x0 in deserialized_dict["secretIds"]},
		)

class SecretIdUseOptionUseNone(metaclass=SingletonMeta):

	def __serialize__(self) -> Any:
		return {}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'SecretIdUseOptionUseNone':
		return cls()

type SecretIdUseOption = Union['SecretIdUseOptionUseAnyConfidential', 'SecretIdUseOptionUseAllConfidential', 'SecretIdUseOptionUseAnySharedWithParent', 'SecretIdUseOptionUseAllSharedWithParent', 'SecretIdUseOptionUse', 'SecretIdUseOptionUseNone']

def serialize_secret_id_use_option(secret_id_use_option: SecretIdUseOption) -> Any:
	if isinstance(secret_id_use_option, SecretIdUseOptionUseAnyConfidential):
		serialized_entity = secret_id_use_option.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnyConfidential"})
		return serialized_entity
	elif isinstance(secret_id_use_option, SecretIdUseOptionUseAllConfidential):
		serialized_entity = secret_id_use_option.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAllConfidential"})
		return serialized_entity
	elif isinstance(secret_id_use_option, SecretIdUseOptionUseAnySharedWithParent):
		serialized_entity = secret_id_use_option.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent"})
		return serialized_entity
	elif isinstance(secret_id_use_option, SecretIdUseOptionUseAllSharedWithParent):
		serialized_entity = secret_id_use_option.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAllSharedWithParent"})
		return serialized_entity
	elif isinstance(secret_id_use_option, SecretIdUseOptionUse):
		serialized_entity = secret_id_use_option.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.Use"})
		return serialized_entity
	elif isinstance(secret_id_use_option, SecretIdUseOptionUseNone):
		serialized_entity = secret_id_use_option.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseNone"})
		return serialized_entity
	else:
		raise Exception(f"{type(secret_id_use_option)} is not a known subclass of SecretIdUseOption")

def deserialize_secret_id_use_option(data: Union[str, dict[str, JsonElement]]) -> 'SecretIdUseOption':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnyConfidential":
		return SecretIdUseOptionUseAnyConfidential._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAllConfidential":
		return SecretIdUseOptionUseAllConfidential._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent":
		return SecretIdUseOptionUseAnySharedWithParent._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAllSharedWithParent":
		return SecretIdUseOptionUseAllSharedWithParent._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.Use":
		return SecretIdUseOptionUse._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseNone":
		return SecretIdUseOptionUseNone._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of SecretIdUseOption")

@dataclass
class ClassificationShareOptions:
	requested_permissions: 'RequestedPermission' = field(default_factory=lambda: RequestedPermission.MaxWrite)
	share_encryption_key: 'ShareMetadataBehaviour' = field(default_factory=lambda: ShareMetadataBehaviour.IfAvailable)
	share_patient_id: 'ShareMetadataBehaviour' = field(default_factory=lambda: ShareMetadataBehaviour.IfAvailable)
	share_secret_ids: 'SecretIdShareOptions' = field(default_factory=lambda: SecretIdShareOptionsAllAvailable())

	def __serialize__(self) -> Any:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"sharePatientId": self.share_patient_id.__serialize__(),
			"shareSecretIds": serialize_secret_id_share_options(self.share_secret_ids),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ClassificationShareOptions':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions=RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key=ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_patient_id=ShareMetadataBehaviour._deserialize(deserialized_dict["sharePatientId"]),
			share_secret_ids=deserialize_secret_id_share_options(deserialized_dict["shareSecretIds"]),
		)

@dataclass
class DecryptedCalendarItem:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	title: Optional[str] = None
	calendar_item_type_id: Optional[str] = None
	master_calendar_item_id: Optional[str] = None
	patient_id: Optional[str] = None
	important: Optional[bool] = None
	home_visit: Optional[bool] = None
	phone_number: Optional[str] = None
	place_id: Optional[str] = None
	address: Optional['DecryptedAddress'] = None
	address_text: Optional[str] = None
	start_time: Optional[int] = None
	end_time: Optional[int] = None
	details: Optional[str] = None
	was_migrated: Optional[bool] = None
	agenda_id: Optional[str] = None
	resource_group: Optional['CodeStub'] = None
	availabilities_assignment_strategy: Optional['CalendarItemAvailabilitiesAssignmentStrategy'] = None
	hcp_id: Optional[str] = None
	recurrence_id: Optional[str] = None
	meeting_tags: list['DecryptedCalendarItemTag'] = field(default_factory=list)
	flow_item: Optional['FlowItem'] = None
	secret_foreign_keys: set[str] = field(default_factory=set)
	crypted_foreign_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	delegations: dict[str, list['Delegation']] = field(default_factory=dict)
	encryption_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"title": self.title,
			"calendarItemTypeId": self.calendar_item_type_id,
			"masterCalendarItemId": self.master_calendar_item_id,
			"patientId": self.patient_id,
			"important": self.important,
			"homeVisit": self.home_visit,
			"phoneNumber": self.phone_number,
			"placeId": self.place_id,
			"address": self.address.__serialize__() if self.address is not None else None,
			"addressText": self.address_text,
			"startTime": self.start_time,
			"endTime": self.end_time,
			"details": self.details,
			"wasMigrated": self.was_migrated,
			"agendaId": self.agenda_id,
			"resourceGroup": self.resource_group.__serialize__() if self.resource_group is not None else None,
			"availabilitiesAssignmentStrategy": self.availabilities_assignment_strategy.__serialize__() if self.availabilities_assignment_strategy is not None else None,
			"hcpId": self.hcp_id,
			"recurrenceId": self.recurrence_id,
			"meetingTags": [x0.__serialize__() for x0 in self.meeting_tags],
			"flowItem": self.flow_item.__serialize__() if self.flow_item is not None else None,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedCalendarItem':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			title=deserialized_dict.get("title"),
			calendar_item_type_id=deserialized_dict.get("calendarItemTypeId"),
			master_calendar_item_id=deserialized_dict.get("masterCalendarItemId"),
			patient_id=deserialized_dict.get("patientId"),
			important=deserialized_dict.get("important"),
			home_visit=deserialized_dict.get("homeVisit"),
			phone_number=deserialized_dict.get("phoneNumber"),
			place_id=deserialized_dict.get("placeId"),
			address=DecryptedAddress._deserialize(deserialized_dict.get("address")) if deserialized_dict.get("address") is not None else None,
			address_text=deserialized_dict.get("addressText"),
			start_time=deserialized_dict.get("startTime"),
			end_time=deserialized_dict.get("endTime"),
			details=deserialized_dict.get("details"),
			was_migrated=deserialized_dict.get("wasMigrated"),
			agenda_id=deserialized_dict.get("agendaId"),
			resource_group=CodeStub._deserialize(deserialized_dict.get("resourceGroup")) if deserialized_dict.get("resourceGroup") is not None else None,
			availabilities_assignment_strategy=CalendarItemAvailabilitiesAssignmentStrategy._deserialize(deserialized_dict.get("availabilitiesAssignmentStrategy")) if deserialized_dict.get("availabilitiesAssignmentStrategy") is not None else None,
			hcp_id=deserialized_dict.get("hcpId"),
			recurrence_id=deserialized_dict.get("recurrenceId"),
			meeting_tags=[DecryptedCalendarItemTag._deserialize(x0) for x0 in deserialized_dict["meetingTags"]],
			flow_item=FlowItem._deserialize(deserialized_dict.get("flowItem")) if deserialized_dict.get("flowItem") is not None else None,
			secret_foreign_keys={x0 for x0 in deserialized_dict["secretForeignKeys"]},
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

@dataclass
class EncryptedCalendarItem:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	title: Optional[str] = None
	calendar_item_type_id: Optional[str] = None
	master_calendar_item_id: Optional[str] = None
	patient_id: Optional[str] = None
	important: Optional[bool] = None
	home_visit: Optional[bool] = None
	phone_number: Optional[str] = None
	place_id: Optional[str] = None
	address: Optional['EncryptedAddress'] = None
	address_text: Optional[str] = None
	start_time: Optional[int] = None
	end_time: Optional[int] = None
	details: Optional[str] = None
	was_migrated: Optional[bool] = None
	agenda_id: Optional[str] = None
	resource_group: Optional['CodeStub'] = None
	availabilities_assignment_strategy: Optional['CalendarItemAvailabilitiesAssignmentStrategy'] = None
	hcp_id: Optional[str] = None
	recurrence_id: Optional[str] = None
	meeting_tags: list['EncryptedCalendarItemTag'] = field(default_factory=list)
	flow_item: Optional['FlowItem'] = None
	secret_foreign_keys: set[str] = field(default_factory=set)
	crypted_foreign_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	delegations: dict[str, list['Delegation']] = field(default_factory=dict)
	encryption_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"title": self.title,
			"calendarItemTypeId": self.calendar_item_type_id,
			"masterCalendarItemId": self.master_calendar_item_id,
			"patientId": self.patient_id,
			"important": self.important,
			"homeVisit": self.home_visit,
			"phoneNumber": self.phone_number,
			"placeId": self.place_id,
			"address": self.address.__serialize__() if self.address is not None else None,
			"addressText": self.address_text,
			"startTime": self.start_time,
			"endTime": self.end_time,
			"details": self.details,
			"wasMigrated": self.was_migrated,
			"agendaId": self.agenda_id,
			"resourceGroup": self.resource_group.__serialize__() if self.resource_group is not None else None,
			"availabilitiesAssignmentStrategy": self.availabilities_assignment_strategy.__serialize__() if self.availabilities_assignment_strategy is not None else None,
			"hcpId": self.hcp_id,
			"recurrenceId": self.recurrence_id,
			"meetingTags": [x0.__serialize__() for x0 in self.meeting_tags],
			"flowItem": self.flow_item.__serialize__() if self.flow_item is not None else None,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedCalendarItem':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			title=deserialized_dict.get("title"),
			calendar_item_type_id=deserialized_dict.get("calendarItemTypeId"),
			master_calendar_item_id=deserialized_dict.get("masterCalendarItemId"),
			patient_id=deserialized_dict.get("patientId"),
			important=deserialized_dict.get("important"),
			home_visit=deserialized_dict.get("homeVisit"),
			phone_number=deserialized_dict.get("phoneNumber"),
			place_id=deserialized_dict.get("placeId"),
			address=EncryptedAddress._deserialize(deserialized_dict.get("address")) if deserialized_dict.get("address") is not None else None,
			address_text=deserialized_dict.get("addressText"),
			start_time=deserialized_dict.get("startTime"),
			end_time=deserialized_dict.get("endTime"),
			details=deserialized_dict.get("details"),
			was_migrated=deserialized_dict.get("wasMigrated"),
			agenda_id=deserialized_dict.get("agendaId"),
			resource_group=CodeStub._deserialize(deserialized_dict.get("resourceGroup")) if deserialized_dict.get("resourceGroup") is not None else None,
			availabilities_assignment_strategy=CalendarItemAvailabilitiesAssignmentStrategy._deserialize(deserialized_dict.get("availabilitiesAssignmentStrategy")) if deserialized_dict.get("availabilitiesAssignmentStrategy") is not None else None,
			hcp_id=deserialized_dict.get("hcpId"),
			recurrence_id=deserialized_dict.get("recurrenceId"),
			meeting_tags=[EncryptedCalendarItemTag._deserialize(x0) for x0 in deserialized_dict["meetingTags"]],
			flow_item=FlowItem._deserialize(deserialized_dict.get("flowItem")) if deserialized_dict.get("flowItem") is not None else None,
			secret_foreign_keys={x0 for x0 in deserialized_dict["secretForeignKeys"]},
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

class CalendarItemAvailabilitiesAssignmentStrategy(Enum):
	Strict = "S"
	Loose = "L"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'CalendarItemAvailabilitiesAssignmentStrategy':
		if data == "S":
			return CalendarItemAvailabilitiesAssignmentStrategy.Strict
		elif data == "L":
			return CalendarItemAvailabilitiesAssignmentStrategy.Loose
		else:
			raise Exception(f"{data} is not a valid value for AvailabilitiesAssignmentStrategy enum.")

type CalendarItem = Union['DecryptedCalendarItem', 'EncryptedCalendarItem']

def serialize_calendar_item(calendar_item: CalendarItem) -> Any:
	if isinstance(calendar_item, DecryptedCalendarItem):
		serialized_entity = calendar_item.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.DecryptedCalendarItem"})
		return serialized_entity
	elif isinstance(calendar_item, EncryptedCalendarItem):
		serialized_entity = calendar_item.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.EncryptedCalendarItem"})
		return serialized_entity
	else:
		raise Exception(f"{type(calendar_item)} is not a known subclass of CalendarItem")

def deserialize_calendar_item(data: Union[str, dict[str, JsonElement]]) -> 'CalendarItem':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.DecryptedCalendarItem":
		return DecryptedCalendarItem._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.EncryptedCalendarItem":
		return EncryptedCalendarItem._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of CalendarItem")

@dataclass
class DecryptedMaintenanceTask:
	id: str
	rev: Optional[str] = None
	identifier: list['Identifier'] = field(default_factory=list)
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	task_type: Optional[str] = None
	properties: list['DecryptedPropertyStub'] = field(default_factory=list)
	status: 'TaskStatus' = field(default_factory=lambda: TaskStatus.Pending)
	secret_foreign_keys: set[str] = field(default_factory=set)
	crypted_foreign_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	delegations: dict[str, list['Delegation']] = field(default_factory=dict)
	encryption_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"identifier": [x0.__serialize__() for x0 in self.identifier],
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"taskType": self.task_type,
			"properties": [x0.__serialize__() for x0 in self.properties],
			"status": self.status.__serialize__(),
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedMaintenanceTask':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			identifier=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			task_type=deserialized_dict.get("taskType"),
			properties=[DecryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict["properties"]],
			status=TaskStatus._deserialize(deserialized_dict["status"]),
			secret_foreign_keys={x0 for x0 in deserialized_dict["secretForeignKeys"]},
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

@dataclass
class EncryptedMaintenanceTask:
	id: str
	rev: Optional[str] = None
	identifier: list['Identifier'] = field(default_factory=list)
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	task_type: Optional[str] = None
	properties: list['EncryptedPropertyStub'] = field(default_factory=list)
	status: 'TaskStatus' = field(default_factory=lambda: TaskStatus.Pending)
	secret_foreign_keys: set[str] = field(default_factory=set)
	crypted_foreign_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	delegations: dict[str, list['Delegation']] = field(default_factory=dict)
	encryption_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"identifier": [x0.__serialize__() for x0 in self.identifier],
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"taskType": self.task_type,
			"properties": [x0.__serialize__() for x0 in self.properties],
			"status": self.status.__serialize__(),
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedMaintenanceTask':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			identifier=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			task_type=deserialized_dict.get("taskType"),
			properties=[EncryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict["properties"]],
			status=TaskStatus._deserialize(deserialized_dict["status"]),
			secret_foreign_keys={x0 for x0 in deserialized_dict["secretForeignKeys"]},
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

type MaintenanceTask = Union['DecryptedMaintenanceTask', 'EncryptedMaintenanceTask']

def serialize_maintenance_task(maintenance_task: MaintenanceTask) -> Any:
	if isinstance(maintenance_task, DecryptedMaintenanceTask):
		serialized_entity = maintenance_task.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.DecryptedMaintenanceTask"})
		return serialized_entity
	elif isinstance(maintenance_task, EncryptedMaintenanceTask):
		serialized_entity = maintenance_task.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.EncryptedMaintenanceTask"})
		return serialized_entity
	else:
		raise Exception(f"{type(maintenance_task)} is not a known subclass of MaintenanceTask")

def deserialize_maintenance_task(data: Union[str, dict[str, JsonElement]]) -> 'MaintenanceTask':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.DecryptedMaintenanceTask":
		return DecryptedMaintenanceTask._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.EncryptedMaintenanceTask":
		return EncryptedMaintenanceTask._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of MaintenanceTask")

@dataclass
class MaintenanceTaskShareOptions:
	requested_permissions: 'RequestedPermission' = field(default_factory=lambda: RequestedPermission.MaxWrite)
	share_encryption_key: 'ShareMetadataBehaviour' = field(default_factory=lambda: ShareMetadataBehaviour.IfAvailable)
	share_secret_ids: 'SecretIdShareOptions' = field(default_factory=lambda: SecretIdShareOptionsAllAvailable())

	def __serialize__(self) -> Any:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"shareSecretIds": serialize_secret_id_share_options(self.share_secret_ids),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'MaintenanceTaskShareOptions':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions=RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key=ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_secret_ids=deserialize_secret_id_share_options(deserialized_dict["shareSecretIds"]),
		)

@dataclass
class EncryptedForm:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	opening_date: Optional[int] = None
	status: Optional[str] = None
	version: Optional[int] = None
	logical_uuid: Optional[str] = None
	descr: Optional[str] = None
	unique_id: Optional[str] = None
	form_template_id: Optional[str] = None
	contact_id: Optional[str] = None
	health_element_id: Optional[str] = None
	plan_of_action_id: Optional[str] = None
	parent: Optional[str] = None
	anchor_id: Optional[str] = None
	secret_foreign_keys: set[str] = field(default_factory=set)
	crypted_foreign_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	delegations: dict[str, list['Delegation']] = field(default_factory=dict)
	encryption_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"openingDate": self.opening_date,
			"status": self.status,
			"version": self.version,
			"logicalUuid": self.logical_uuid,
			"descr": self.descr,
			"uniqueId": self.unique_id,
			"formTemplateId": self.form_template_id,
			"contactId": self.contact_id,
			"healthElementId": self.health_element_id,
			"planOfActionId": self.plan_of_action_id,
			"parent": self.parent,
			"anchorId": self.anchor_id,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedForm':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			opening_date=deserialized_dict.get("openingDate"),
			status=deserialized_dict.get("status"),
			version=deserialized_dict.get("version"),
			logical_uuid=deserialized_dict.get("logicalUuid"),
			descr=deserialized_dict.get("descr"),
			unique_id=deserialized_dict.get("uniqueId"),
			form_template_id=deserialized_dict.get("formTemplateId"),
			contact_id=deserialized_dict.get("contactId"),
			health_element_id=deserialized_dict.get("healthElementId"),
			plan_of_action_id=deserialized_dict.get("planOfActionId"),
			parent=deserialized_dict.get("parent"),
			anchor_id=deserialized_dict.get("anchorId"),
			secret_foreign_keys={x0 for x0 in deserialized_dict["secretForeignKeys"]},
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

@dataclass
class DecryptedForm:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	opening_date: Optional[int] = None
	status: Optional[str] = None
	version: Optional[int] = None
	logical_uuid: Optional[str] = None
	descr: Optional[str] = None
	unique_id: Optional[str] = None
	form_template_id: Optional[str] = None
	contact_id: Optional[str] = None
	health_element_id: Optional[str] = None
	plan_of_action_id: Optional[str] = None
	parent: Optional[str] = None
	anchor_id: Optional[str] = None
	secret_foreign_keys: set[str] = field(default_factory=set)
	crypted_foreign_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	delegations: dict[str, list['Delegation']] = field(default_factory=dict)
	encryption_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"openingDate": self.opening_date,
			"status": self.status,
			"version": self.version,
			"logicalUuid": self.logical_uuid,
			"descr": self.descr,
			"uniqueId": self.unique_id,
			"formTemplateId": self.form_template_id,
			"contactId": self.contact_id,
			"healthElementId": self.health_element_id,
			"planOfActionId": self.plan_of_action_id,
			"parent": self.parent,
			"anchorId": self.anchor_id,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedForm':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			opening_date=deserialized_dict.get("openingDate"),
			status=deserialized_dict.get("status"),
			version=deserialized_dict.get("version"),
			logical_uuid=deserialized_dict.get("logicalUuid"),
			descr=deserialized_dict.get("descr"),
			unique_id=deserialized_dict.get("uniqueId"),
			form_template_id=deserialized_dict.get("formTemplateId"),
			contact_id=deserialized_dict.get("contactId"),
			health_element_id=deserialized_dict.get("healthElementId"),
			plan_of_action_id=deserialized_dict.get("planOfActionId"),
			parent=deserialized_dict.get("parent"),
			anchor_id=deserialized_dict.get("anchorId"),
			secret_foreign_keys={x0 for x0 in deserialized_dict["secretForeignKeys"]},
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

type Form = Union['EncryptedForm', 'DecryptedForm']

def serialize_form(form: Form) -> Any:
	if isinstance(form, EncryptedForm):
		serialized_entity = form.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.EncryptedForm"})
		return serialized_entity
	elif isinstance(form, DecryptedForm):
		serialized_entity = form.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.DecryptedForm"})
		return serialized_entity
	else:
		raise Exception(f"{type(form)} is not a known subclass of Form")

def deserialize_form(data: Union[str, dict[str, JsonElement]]) -> 'Form':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.EncryptedForm":
		return EncryptedForm._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.DecryptedForm":
		return DecryptedForm._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of Form")

@dataclass
class FormTemplate:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	template_layout: Optional['FormTemplateLayout'] = None
	raw_template_layout: Optional[bytearray] = None
	name: Optional[str] = None
	guid: Optional[str] = None
	group: Optional['DocumentGroup'] = None
	descr: Optional[str] = None
	disabled: Optional[str] = None
	specialty: Optional['CodeStub'] = None
	author: Optional[str] = None
	form_instance_preferred_location: Optional[str] = None
	keyboard_shortcut: Optional[str] = None
	short_report: Optional[str] = None
	medium_report: Optional[str] = None
	long_report: Optional[str] = None
	reports: set[str] = field(default_factory=set)
	tags: set['CodeStub'] = field(default_factory=set)
	layout_attachment_id: Optional[str] = None
	template_layout_attachment_id: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"templateLayout": self.template_layout.__serialize__() if self.template_layout is not None else None,
			"rawTemplateLayout": base64.b64encode(self.raw_template_layout).decode('utf-8') if self.raw_template_layout is not None else None,
			"name": self.name,
			"guid": self.guid,
			"group": self.group.__serialize__() if self.group is not None else None,
			"descr": self.descr,
			"disabled": self.disabled,
			"specialty": self.specialty.__serialize__() if self.specialty is not None else None,
			"author": self.author,
			"formInstancePreferredLocation": self.form_instance_preferred_location,
			"keyboardShortcut": self.keyboard_shortcut,
			"shortReport": self.short_report,
			"mediumReport": self.medium_report,
			"longReport": self.long_report,
			"reports": [x0 for x0 in self.reports],
			"tags": [x0.__serialize__() for x0 in self.tags],
			"layoutAttachmentId": self.layout_attachment_id,
			"templateLayoutAttachmentId": self.template_layout_attachment_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'FormTemplate':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			deletion_date=deserialized_dict.get("deletionDate"),
			template_layout=FormTemplateLayout._deserialize(deserialized_dict.get("templateLayout")) if deserialized_dict.get("templateLayout") is not None else None,
			raw_template_layout=bytearray(base64.b64decode(deserialized_dict.get("rawTemplateLayout"))) if deserialized_dict.get("rawTemplateLayout") is not None else None,
			name=deserialized_dict.get("name"),
			guid=deserialized_dict.get("guid"),
			group=DocumentGroup._deserialize(deserialized_dict.get("group")) if deserialized_dict.get("group") is not None else None,
			descr=deserialized_dict.get("descr"),
			disabled=deserialized_dict.get("disabled"),
			specialty=CodeStub._deserialize(deserialized_dict.get("specialty")) if deserialized_dict.get("specialty") is not None else None,
			author=deserialized_dict.get("author"),
			form_instance_preferred_location=deserialized_dict.get("formInstancePreferredLocation"),
			keyboard_shortcut=deserialized_dict.get("keyboardShortcut"),
			short_report=deserialized_dict.get("shortReport"),
			medium_report=deserialized_dict.get("mediumReport"),
			long_report=deserialized_dict.get("longReport"),
			reports={x0 for x0 in deserialized_dict["reports"]},
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			layout_attachment_id=deserialized_dict.get("layoutAttachmentId"),
			template_layout_attachment_id=deserialized_dict.get("templateLayoutAttachmentId"),
		)

class RecoveryKeySize(Enum):
	Bytes16 = "Bytes16"
	Bytes32 = "Bytes32"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'RecoveryKeySize':
		if data == "Bytes16":
			return RecoveryKeySize.Bytes16
		elif data == "Bytes32":
			return RecoveryKeySize.Bytes32
		else:
			raise Exception(f"{data} is not a valid value for RecoveryKeySize enum.")

@dataclass(frozen=True)
class EntityReferenceInGroup:
	entity_id: str
	group_id: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"entityId": self.entity_id,
			"groupId": self.group_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EntityReferenceInGroup':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			entity_id=deserialized_dict["entityId"],
			group_id=deserialized_dict.get("groupId"),
		)

class ShareAllPatientDataOptionsTag(Enum):
	All = "All"
	MedicalInformation = "MedicalInformation"
	FinancialInformation = "FinancialInformation"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ShareAllPatientDataOptionsTag':
		if data == "All":
			return ShareAllPatientDataOptionsTag.All
		elif data == "MedicalInformation":
			return ShareAllPatientDataOptionsTag.MedicalInformation
		elif data == "FinancialInformation":
			return ShareAllPatientDataOptionsTag.FinancialInformation
		else:
			raise Exception(f"{data} is not a valid value for Tag enum.")

class ShareAllPatientDataOptionsShareableEntity(Enum):
	CalendarItem = "CalendarItem"
	Contact = "Contact"
	Classification = "Classification"
	Document = "Document"
	Form = "Form"
	HealthElement = "HealthElement"
	Invoice = "Invoice"
	Patient = "Patient"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ShareAllPatientDataOptionsShareableEntity':
		if data == "CalendarItem":
			return ShareAllPatientDataOptionsShareableEntity.CalendarItem
		elif data == "Contact":
			return ShareAllPatientDataOptionsShareableEntity.Contact
		elif data == "Classification":
			return ShareAllPatientDataOptionsShareableEntity.Classification
		elif data == "Document":
			return ShareAllPatientDataOptionsShareableEntity.Document
		elif data == "Form":
			return ShareAllPatientDataOptionsShareableEntity.Form
		elif data == "HealthElement":
			return ShareAllPatientDataOptionsShareableEntity.HealthElement
		elif data == "Invoice":
			return ShareAllPatientDataOptionsShareableEntity.Invoice
		elif data == "Patient":
			return ShareAllPatientDataOptionsShareableEntity.Patient
		else:
			raise Exception(f"{data} is not a valid value for ShareableEntity enum.")

@dataclass
class ShareAllPatientDataOptionsEntityResult:
	modified: int
	success: Optional[bool] = None
	error: Optional['ShareAllPatientDataOptionsSharePatientDataError'] = None

	def __serialize__(self) -> Any:
		return {
			"success": self.success,
			"error": serialize_share_all_patient_data_options_share_patient_data_error(self.error) if self.error is not None else None,
			"modified": self.modified,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ShareAllPatientDataOptionsEntityResult':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			success=deserialized_dict.get("success"),
			error=deserialize_share_all_patient_data_options_share_patient_data_error(deserialized_dict.get("error")) if deserialized_dict.get("error") is not None else None,
			modified=deserialized_dict["modified"],
		)

@dataclass
class ShareAllPatientDataOptionsResult:
	patient: 'EncryptedPatient'
	statuses: dict['ShareAllPatientDataOptionsShareableEntity', 'ShareAllPatientDataOptionsEntityResult']

	def __serialize__(self) -> Any:
		return {
			"patient": self.patient.__serialize__(),
			"statuses": {k0.__serialize__(): v0.__serialize__() for k0, v0 in self.statuses.items()},
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ShareAllPatientDataOptionsResult':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			patient=EncryptedPatient._deserialize(deserialized_dict["patient"]),
			statuses=dict(map(lambda kv0: (ShareAllPatientDataOptionsShareableEntity._deserialize(kv0[0]), ShareAllPatientDataOptionsEntityResult._deserialize(kv0[1])), deserialized_dict["statuses"].items())),
		)

type ShareAllPatientDataOptionsSharePatientDataError = Union['ShareAllPatientDataOptionsBulkShareFailure', 'ShareAllPatientDataOptionsFailedRequest']

def serialize_share_all_patient_data_options_share_patient_data_error(share_all_patient_data_options_share_patient_data_error: ShareAllPatientDataOptionsSharePatientDataError) -> Any:
	if isinstance(share_all_patient_data_options_share_patient_data_error, ShareAllPatientDataOptionsBulkShareFailure):
		serialized_entity = share_all_patient_data_options_share_patient_data_error.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.crypto.entities.ShareAllPatientDataOptions.BulkShareFailure"})
		return serialized_entity
	elif isinstance(share_all_patient_data_options_share_patient_data_error, ShareAllPatientDataOptionsFailedRequest):
		serialized_entity = share_all_patient_data_options_share_patient_data_error.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.crypto.entities.ShareAllPatientDataOptions.FailedRequest"})
		return serialized_entity
	else:
		raise Exception(f"{type(share_all_patient_data_options_share_patient_data_error)} is not a known subclass of SharePatientDataError")

def deserialize_share_all_patient_data_options_share_patient_data_error(data: Union[str, dict[str, JsonElement]]) -> 'ShareAllPatientDataOptionsSharePatientDataError':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.crypto.entities.ShareAllPatientDataOptions.BulkShareFailure":
		return ShareAllPatientDataOptionsBulkShareFailure._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.crypto.entities.ShareAllPatientDataOptions.FailedRequest":
		return ShareAllPatientDataOptionsFailedRequest._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of SharePatientDataError")

@dataclass
class ShareAllPatientDataOptionsBulkShareFailure:
	errors: list['FailedRequestDetails']
	message: str

	def __serialize__(self) -> Any:
		return {
			"errors": [x0.__serialize__() for x0 in self.errors],
			"message": self.message,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ShareAllPatientDataOptionsBulkShareFailure':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			errors=[FailedRequestDetails._deserialize(x0) for x0 in deserialized_dict["errors"]],
			message=deserialized_dict["message"],
		)

@dataclass
class ShareAllPatientDataOptionsFailedRequest:
	description: str

	def __serialize__(self) -> Any:
		return {
			"description": self.description,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ShareAllPatientDataOptionsFailedRequest':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			description=deserialized_dict["description"],
		)

@dataclass
class PatientShareOptions:
	requested_permissions: 'RequestedPermission' = field(default_factory=lambda: RequestedPermission.MaxWrite)
	share_encryption_key: 'ShareMetadataBehaviour' = field(default_factory=lambda: ShareMetadataBehaviour.IfAvailable)
	share_secret_ids: 'SecretIdShareOptions' = field(default_factory=lambda: SecretIdShareOptionsAllAvailable())

	def __serialize__(self) -> Any:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"shareSecretIds": serialize_secret_id_share_options(self.share_secret_ids),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'PatientShareOptions':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions=RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key=ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_secret_ids=deserialize_secret_id_share_options(deserialized_dict["shareSecretIds"]),
		)

@dataclass
class Tarification:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	label: Optional[dict[str, str]] = None
	context: Optional[str] = None
	type: Optional[str] = None
	code: Optional[str] = None
	version: Optional[str] = None
	author: Optional[str] = None
	regions: set[str] = field(default_factory=set)
	periodicity: list['Periodicity'] = field(default_factory=list)
	level: Optional[int] = None
	links: list[str] = field(default_factory=list)
	qualified_links: dict['LinkQualification', list[str]] = field(default_factory=dict)
	flags: set['CodeFlag'] = field(default_factory=set)
	search_terms: dict[str, set[str]] = field(default_factory=dict)
	data: Optional[str] = None
	appendices: dict['AppendixType', str] = field(default_factory=dict)
	disabled: bool = False
	valorisations: list['DecryptedValorisation'] = field(default_factory=list)
	category: dict[str, str] = field(default_factory=dict)
	consultation_code: Optional[bool] = None
	has_related_code: Optional[bool] = None
	needs_prescriber: Optional[bool] = None
	related_codes: set[str] = field(default_factory=set)
	ngroup: Optional[str] = None
	letter_values: list['LetterValue'] = field(default_factory=list)

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"label": {k0: v0 for k0, v0 in self.label.items()} if self.label is not None else None,
			"context": self.context,
			"type": self.type,
			"code": self.code,
			"version": self.version,
			"author": self.author,
			"regions": [x0 for x0 in self.regions],
			"periodicity": [x0.__serialize__() for x0 in self.periodicity],
			"level": self.level,
			"links": [x0 for x0 in self.links],
			"qualifiedLinks": {k0.__serialize__(): [x1 for x1 in v0] for k0, v0 in self.qualified_links.items()},
			"flags": [x0.__serialize__() for x0 in self.flags],
			"searchTerms": {k0: [x1 for x1 in v0] for k0, v0 in self.search_terms.items()},
			"data": self.data,
			"appendices": {k0.__serialize__(): v0 for k0, v0 in self.appendices.items()},
			"disabled": self.disabled,
			"valorisations": [x0.__serialize__() for x0 in self.valorisations],
			"category": {k0: v0 for k0, v0 in self.category.items()},
			"consultationCode": self.consultation_code,
			"hasRelatedCode": self.has_related_code,
			"needsPrescriber": self.needs_prescriber,
			"relatedCodes": [x0 for x0 in self.related_codes],
			"ngroup": self.ngroup,
			"letterValues": [x0.__serialize__() for x0 in self.letter_values],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Tarification':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			deletion_date=deserialized_dict.get("deletionDate"),
			label=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("label").items())) if deserialized_dict.get("label") is not None else None,
			context=deserialized_dict.get("context"),
			type=deserialized_dict.get("type"),
			code=deserialized_dict.get("code"),
			version=deserialized_dict.get("version"),
			author=deserialized_dict.get("author"),
			regions={x0 for x0 in deserialized_dict["regions"]},
			periodicity=[Periodicity._deserialize(x0) for x0 in deserialized_dict["periodicity"]],
			level=deserialized_dict.get("level"),
			links=[x0 for x0 in deserialized_dict["links"]],
			qualified_links=dict(map(lambda kv0: (LinkQualification._deserialize(kv0[0]), [x1 for x1 in kv0[1]]), deserialized_dict["qualifiedLinks"].items())),
			flags={CodeFlag._deserialize(x0) for x0 in deserialized_dict["flags"]},
			search_terms=dict(map(lambda kv0: (kv0[0], {x1 for x1 in kv0[1]}), deserialized_dict["searchTerms"].items())),
			data=deserialized_dict.get("data"),
			appendices=dict(map(lambda kv0: (AppendixType._deserialize(kv0[0]), kv0[1]), deserialized_dict["appendices"].items())),
			disabled=deserialized_dict["disabled"],
			valorisations=[DecryptedValorisation._deserialize(x0) for x0 in deserialized_dict["valorisations"]],
			category=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["category"].items())),
			consultation_code=deserialized_dict.get("consultationCode"),
			has_related_code=deserialized_dict.get("hasRelatedCode"),
			needs_prescriber=deserialized_dict.get("needsPrescriber"),
			related_codes={x0 for x0 in deserialized_dict["relatedCodes"]},
			ngroup=deserialized_dict.get("ngroup"),
			letter_values=[LetterValue._deserialize(x0) for x0 in deserialized_dict["letterValues"]],
		)

@dataclass
class DecryptedContact:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	identifier: list['Identifier'] = field(default_factory=list)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	group_id: Optional[str] = None
	opening_date: Optional[int] = None
	closing_date: Optional[int] = None
	descr: Optional[str] = None
	location: Optional[str] = None
	external_id: Optional[str] = None
	encounter_type: Optional['CodeStub'] = None
	encounter_location: Optional['DecryptedAddress'] = None
	sub_contacts: list['DecryptedSubContact'] = field(default_factory=list)
	services: list['DecryptedService'] = field(default_factory=list)
	participants: dict['ParticipantType', str] = field(default_factory=dict)
	healthcare_party_id: Optional[str] = None
	modified_contact_id: Optional[str] = None
	secret_foreign_keys: set[str] = field(default_factory=set)
	crypted_foreign_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	delegations: dict[str, list['Delegation']] = field(default_factory=dict)
	encryption_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None
	notes: list['Annotation'] = field(default_factory=list)

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"identifier": [x0.__serialize__() for x0 in self.identifier],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"groupId": self.group_id,
			"openingDate": self.opening_date,
			"closingDate": self.closing_date,
			"descr": self.descr,
			"location": self.location,
			"externalId": self.external_id,
			"encounterType": self.encounter_type.__serialize__() if self.encounter_type is not None else None,
			"encounterLocation": self.encounter_location.__serialize__() if self.encounter_location is not None else None,
			"subContacts": [x0.__serialize__() for x0 in self.sub_contacts],
			"services": [x0.__serialize__() for x0 in self.services],
			"participants": {k0.__serialize__(): v0 for k0, v0 in self.participants.items()},
			"healthcarePartyId": self.healthcare_party_id,
			"modifiedContactId": self.modified_contact_id,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
			"notes": [x0.__serialize__() for x0 in self.notes],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedContact':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			identifier=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			group_id=deserialized_dict.get("groupId"),
			opening_date=deserialized_dict.get("openingDate"),
			closing_date=deserialized_dict.get("closingDate"),
			descr=deserialized_dict.get("descr"),
			location=deserialized_dict.get("location"),
			external_id=deserialized_dict.get("externalId"),
			encounter_type=CodeStub._deserialize(deserialized_dict.get("encounterType")) if deserialized_dict.get("encounterType") is not None else None,
			encounter_location=DecryptedAddress._deserialize(deserialized_dict.get("encounterLocation")) if deserialized_dict.get("encounterLocation") is not None else None,
			sub_contacts=[DecryptedSubContact._deserialize(x0) for x0 in deserialized_dict["subContacts"]],
			services=[DecryptedService._deserialize(x0) for x0 in deserialized_dict["services"]],
			participants=dict(map(lambda kv0: (ParticipantType._deserialize(kv0[0]), kv0[1]), deserialized_dict["participants"].items())),
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			modified_contact_id=deserialized_dict.get("modifiedContactId"),
			secret_foreign_keys={x0 for x0 in deserialized_dict["secretForeignKeys"]},
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
			notes=[Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
		)

@dataclass
class EncryptedContact:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	identifier: list['Identifier'] = field(default_factory=list)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	group_id: Optional[str] = None
	opening_date: Optional[int] = None
	closing_date: Optional[int] = None
	descr: Optional[str] = None
	location: Optional[str] = None
	external_id: Optional[str] = None
	encounter_type: Optional['CodeStub'] = None
	encounter_location: Optional['EncryptedAddress'] = None
	sub_contacts: list['EncryptedSubContact'] = field(default_factory=list)
	services: list['EncryptedService'] = field(default_factory=list)
	participants: dict['ParticipantType', str] = field(default_factory=dict)
	healthcare_party_id: Optional[str] = None
	modified_contact_id: Optional[str] = None
	secret_foreign_keys: set[str] = field(default_factory=set)
	crypted_foreign_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	delegations: dict[str, list['Delegation']] = field(default_factory=dict)
	encryption_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None
	notes: list['Annotation'] = field(default_factory=list)

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"identifier": [x0.__serialize__() for x0 in self.identifier],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"groupId": self.group_id,
			"openingDate": self.opening_date,
			"closingDate": self.closing_date,
			"descr": self.descr,
			"location": self.location,
			"externalId": self.external_id,
			"encounterType": self.encounter_type.__serialize__() if self.encounter_type is not None else None,
			"encounterLocation": self.encounter_location.__serialize__() if self.encounter_location is not None else None,
			"subContacts": [x0.__serialize__() for x0 in self.sub_contacts],
			"services": [x0.__serialize__() for x0 in self.services],
			"participants": {k0.__serialize__(): v0 for k0, v0 in self.participants.items()},
			"healthcarePartyId": self.healthcare_party_id,
			"modifiedContactId": self.modified_contact_id,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
			"notes": [x0.__serialize__() for x0 in self.notes],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedContact':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			identifier=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			group_id=deserialized_dict.get("groupId"),
			opening_date=deserialized_dict.get("openingDate"),
			closing_date=deserialized_dict.get("closingDate"),
			descr=deserialized_dict.get("descr"),
			location=deserialized_dict.get("location"),
			external_id=deserialized_dict.get("externalId"),
			encounter_type=CodeStub._deserialize(deserialized_dict.get("encounterType")) if deserialized_dict.get("encounterType") is not None else None,
			encounter_location=EncryptedAddress._deserialize(deserialized_dict.get("encounterLocation")) if deserialized_dict.get("encounterLocation") is not None else None,
			sub_contacts=[EncryptedSubContact._deserialize(x0) for x0 in deserialized_dict["subContacts"]],
			services=[EncryptedService._deserialize(x0) for x0 in deserialized_dict["services"]],
			participants=dict(map(lambda kv0: (ParticipantType._deserialize(kv0[0]), kv0[1]), deserialized_dict["participants"].items())),
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			modified_contact_id=deserialized_dict.get("modifiedContactId"),
			secret_foreign_keys={x0 for x0 in deserialized_dict["secretForeignKeys"]},
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
			notes=[Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
		)

type Contact = Union['DecryptedContact', 'EncryptedContact']

def serialize_contact(contact: Contact) -> Any:
	if isinstance(contact, DecryptedContact):
		serialized_entity = contact.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.DecryptedContact"})
		return serialized_entity
	elif isinstance(contact, EncryptedContact):
		serialized_entity = contact.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.EncryptedContact"})
		return serialized_entity
	else:
		raise Exception(f"{type(contact)} is not a known subclass of Contact")

def deserialize_contact(data: Union[str, dict[str, JsonElement]]) -> 'Contact':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.DecryptedContact":
		return DecryptedContact._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.EncryptedContact":
		return EncryptedContact._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of Contact")

@dataclass
class DecryptedService:
	id: str
	transaction_id: Optional[str] = None
	identifier: list['Identifier'] = field(default_factory=list)
	contact_id: Optional[str] = None
	sub_contact_ids: Optional[set[str]] = None
	plans_of_action_ids: Optional[set[str]] = None
	health_elements_ids: Optional[set[str]] = None
	form_ids: Optional[set[str]] = None
	secret_foreign_keys: Optional[set[str]] = field(default_factory=set)
	crypted_foreign_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	delegations: dict[str, list['Delegation']] = field(default_factory=dict)
	encryption_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	label: Optional[str] = None
	index: Optional[int] = None
	content: dict[str, 'DecryptedContent'] = field(default_factory=dict)
	encrypted_content: Optional[str] = None
	text_indexes: dict[str, str] = field(default_factory=dict)
	value_date: Optional[int] = None
	opening_date: Optional[int] = None
	closing_date: Optional[int] = None
	form_id: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	end_of_life: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	comment: Optional[str] = None
	status: Optional[int] = None
	invoicing_codes: set[str] = field(default_factory=set)
	notes: list['Annotation'] = field(default_factory=list)
	qualified_links: dict['LinkQualification', dict[str, str]] = field(default_factory=dict)
	codes: set['CodeStub'] = field(default_factory=set)
	tags: set['CodeStub'] = field(default_factory=set)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"transactionId": self.transaction_id,
			"identifier": [x0.__serialize__() for x0 in self.identifier],
			"contactId": self.contact_id,
			"subContactIds": [x0 for x0 in self.sub_contact_ids] if self.sub_contact_ids is not None else None,
			"plansOfActionIds": [x0 for x0 in self.plans_of_action_ids] if self.plans_of_action_ids is not None else None,
			"healthElementsIds": [x0 for x0 in self.health_elements_ids] if self.health_elements_ids is not None else None,
			"formIds": [x0 for x0 in self.form_ids] if self.form_ids is not None else None,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys] if self.secret_foreign_keys is not None else None,
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"label": self.label,
			"index": self.index,
			"content": {k0: v0.__serialize__() for k0, v0 in self.content.items()},
			"encryptedContent": self.encrypted_content,
			"textIndexes": {k0: v0 for k0, v0 in self.text_indexes.items()},
			"valueDate": self.value_date,
			"openingDate": self.opening_date,
			"closingDate": self.closing_date,
			"formId": self.form_id,
			"created": self.created,
			"modified": self.modified,
			"endOfLife": self.end_of_life,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"comment": self.comment,
			"status": self.status,
			"invoicingCodes": [x0 for x0 in self.invoicing_codes],
			"notes": [x0.__serialize__() for x0 in self.notes],
			"qualifiedLinks": {k0.__serialize__(): {k1: v1 for k1, v1 in v0.items()} for k0, v0 in self.qualified_links.items()},
			"codes": [x0.__serialize__() for x0 in self.codes],
			"tags": [x0.__serialize__() for x0 in self.tags],
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedService':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			transaction_id=deserialized_dict.get("transactionId"),
			identifier=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			contact_id=deserialized_dict.get("contactId"),
			sub_contact_ids={x0 for x0 in deserialized_dict.get("subContactIds")} if deserialized_dict.get("subContactIds") is not None else None,
			plans_of_action_ids={x0 for x0 in deserialized_dict.get("plansOfActionIds")} if deserialized_dict.get("plansOfActionIds") is not None else None,
			health_elements_ids={x0 for x0 in deserialized_dict.get("healthElementsIds")} if deserialized_dict.get("healthElementsIds") is not None else None,
			form_ids={x0 for x0 in deserialized_dict.get("formIds")} if deserialized_dict.get("formIds") is not None else None,
			secret_foreign_keys={x0 for x0 in deserialized_dict.get("secretForeignKeys")} if deserialized_dict.get("secretForeignKeys") is not None else None,
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			label=deserialized_dict.get("label"),
			index=deserialized_dict.get("index"),
			content=dict(map(lambda kv0: (kv0[0], DecryptedContent._deserialize(kv0[1])), deserialized_dict["content"].items())),
			encrypted_content=deserialized_dict.get("encryptedContent"),
			text_indexes=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["textIndexes"].items())),
			value_date=deserialized_dict.get("valueDate"),
			opening_date=deserialized_dict.get("openingDate"),
			closing_date=deserialized_dict.get("closingDate"),
			form_id=deserialized_dict.get("formId"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			end_of_life=deserialized_dict.get("endOfLife"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			comment=deserialized_dict.get("comment"),
			status=deserialized_dict.get("status"),
			invoicing_codes={x0 for x0 in deserialized_dict["invoicingCodes"]},
			notes=[Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
			qualified_links=dict(map(lambda kv0: (LinkQualification._deserialize(kv0[0]), dict(map(lambda kv1: (kv1[0], kv1[1]), kv0[1].items()))), deserialized_dict["qualifiedLinks"].items())),
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

@dataclass
class EncryptedService:
	id: str
	transaction_id: Optional[str] = None
	identifier: list['Identifier'] = field(default_factory=list)
	contact_id: Optional[str] = None
	sub_contact_ids: Optional[set[str]] = None
	plans_of_action_ids: Optional[set[str]] = None
	health_elements_ids: Optional[set[str]] = None
	form_ids: Optional[set[str]] = None
	secret_foreign_keys: Optional[set[str]] = field(default_factory=set)
	crypted_foreign_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	delegations: dict[str, list['Delegation']] = field(default_factory=dict)
	encryption_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	label: Optional[str] = None
	index: Optional[int] = None
	content: dict[str, 'EncryptedContent'] = field(default_factory=dict)
	encrypted_content: Optional[str] = None
	text_indexes: dict[str, str] = field(default_factory=dict)
	value_date: Optional[int] = None
	opening_date: Optional[int] = None
	closing_date: Optional[int] = None
	form_id: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	end_of_life: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	comment: Optional[str] = None
	status: Optional[int] = None
	invoicing_codes: set[str] = field(default_factory=set)
	notes: list['Annotation'] = field(default_factory=list)
	qualified_links: dict['LinkQualification', dict[str, str]] = field(default_factory=dict)
	codes: set['CodeStub'] = field(default_factory=set)
	tags: set['CodeStub'] = field(default_factory=set)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"transactionId": self.transaction_id,
			"identifier": [x0.__serialize__() for x0 in self.identifier],
			"contactId": self.contact_id,
			"subContactIds": [x0 for x0 in self.sub_contact_ids] if self.sub_contact_ids is not None else None,
			"plansOfActionIds": [x0 for x0 in self.plans_of_action_ids] if self.plans_of_action_ids is not None else None,
			"healthElementsIds": [x0 for x0 in self.health_elements_ids] if self.health_elements_ids is not None else None,
			"formIds": [x0 for x0 in self.form_ids] if self.form_ids is not None else None,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys] if self.secret_foreign_keys is not None else None,
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"label": self.label,
			"index": self.index,
			"content": {k0: v0.__serialize__() for k0, v0 in self.content.items()},
			"encryptedContent": self.encrypted_content,
			"textIndexes": {k0: v0 for k0, v0 in self.text_indexes.items()},
			"valueDate": self.value_date,
			"openingDate": self.opening_date,
			"closingDate": self.closing_date,
			"formId": self.form_id,
			"created": self.created,
			"modified": self.modified,
			"endOfLife": self.end_of_life,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"comment": self.comment,
			"status": self.status,
			"invoicingCodes": [x0 for x0 in self.invoicing_codes],
			"notes": [x0.__serialize__() for x0 in self.notes],
			"qualifiedLinks": {k0.__serialize__(): {k1: v1 for k1, v1 in v0.items()} for k0, v0 in self.qualified_links.items()},
			"codes": [x0.__serialize__() for x0 in self.codes],
			"tags": [x0.__serialize__() for x0 in self.tags],
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedService':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			transaction_id=deserialized_dict.get("transactionId"),
			identifier=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			contact_id=deserialized_dict.get("contactId"),
			sub_contact_ids={x0 for x0 in deserialized_dict.get("subContactIds")} if deserialized_dict.get("subContactIds") is not None else None,
			plans_of_action_ids={x0 for x0 in deserialized_dict.get("plansOfActionIds")} if deserialized_dict.get("plansOfActionIds") is not None else None,
			health_elements_ids={x0 for x0 in deserialized_dict.get("healthElementsIds")} if deserialized_dict.get("healthElementsIds") is not None else None,
			form_ids={x0 for x0 in deserialized_dict.get("formIds")} if deserialized_dict.get("formIds") is not None else None,
			secret_foreign_keys={x0 for x0 in deserialized_dict.get("secretForeignKeys")} if deserialized_dict.get("secretForeignKeys") is not None else None,
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			label=deserialized_dict.get("label"),
			index=deserialized_dict.get("index"),
			content=dict(map(lambda kv0: (kv0[0], EncryptedContent._deserialize(kv0[1])), deserialized_dict["content"].items())),
			encrypted_content=deserialized_dict.get("encryptedContent"),
			text_indexes=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["textIndexes"].items())),
			value_date=deserialized_dict.get("valueDate"),
			opening_date=deserialized_dict.get("openingDate"),
			closing_date=deserialized_dict.get("closingDate"),
			form_id=deserialized_dict.get("formId"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			end_of_life=deserialized_dict.get("endOfLife"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			comment=deserialized_dict.get("comment"),
			status=deserialized_dict.get("status"),
			invoicing_codes={x0 for x0 in deserialized_dict["invoicingCodes"]},
			notes=[Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
			qualified_links=dict(map(lambda kv0: (LinkQualification._deserialize(kv0[0]), dict(map(lambda kv1: (kv1[0], kv1[1]), kv0[1].items()))), deserialized_dict["qualifiedLinks"].items())),
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

type Service = Union['DecryptedService', 'EncryptedService']

def serialize_service(service: Service) -> Any:
	if isinstance(service, DecryptedService):
		serialized_entity = service.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.DecryptedService"})
		return serialized_entity
	elif isinstance(service, EncryptedService):
		serialized_entity = service.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.EncryptedService"})
		return serialized_entity
	else:
		raise Exception(f"{type(service)} is not a known subclass of Service")

def deserialize_service(data: Union[str, dict[str, JsonElement]]) -> 'Service':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.embed.DecryptedService":
		return DecryptedService._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.embed.EncryptedService":
		return EncryptedService._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of Service")

@dataclass
class LabelledOccurence:
	label: str
	occurence: int

	def __serialize__(self) -> Any:
		return {
			"label": self.label,
			"occurence": self.occurence,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'LabelledOccurence':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			label=deserialized_dict["label"],
			occurence=deserialized_dict["occurence"],
		)

@dataclass
class ContactShareOptions:
	requested_permissions: 'RequestedPermission' = field(default_factory=lambda: RequestedPermission.MaxWrite)
	share_encryption_key: 'ShareMetadataBehaviour' = field(default_factory=lambda: ShareMetadataBehaviour.IfAvailable)
	share_patient_id: 'ShareMetadataBehaviour' = field(default_factory=lambda: ShareMetadataBehaviour.IfAvailable)
	share_secret_ids: 'SecretIdShareOptions' = field(default_factory=lambda: SecretIdShareOptionsAllAvailable())

	def __serialize__(self) -> Any:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"sharePatientId": self.share_patient_id.__serialize__(),
			"shareSecretIds": serialize_secret_id_share_options(self.share_secret_ids),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ContactShareOptions':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions=RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key=ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_patient_id=ShareMetadataBehaviour._deserialize(deserialized_dict["sharePatientId"]),
			share_secret_ids=deserialize_secret_id_share_options(deserialized_dict["shareSecretIds"]),
		)

@dataclass
class DecryptedReceipt:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	attachment_ids: dict['ReceiptBlobType', str] = field(default_factory=dict)
	references: list[str] = field(default_factory=list)
	document_id: Optional[str] = None
	category: Optional[str] = None
	sub_category: Optional[str] = None
	secret_foreign_keys: set[str] = field(default_factory=set)
	crypted_foreign_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	delegations: dict[str, list['Delegation']] = field(default_factory=dict)
	encryption_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"attachmentIds": {k0.__serialize__(): v0 for k0, v0 in self.attachment_ids.items()},
			"references": [x0 for x0 in self.references],
			"documentId": self.document_id,
			"category": self.category,
			"subCategory": self.sub_category,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedReceipt':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			attachment_ids=dict(map(lambda kv0: (ReceiptBlobType._deserialize(kv0[0]), kv0[1]), deserialized_dict["attachmentIds"].items())),
			references=[x0 for x0 in deserialized_dict["references"]],
			document_id=deserialized_dict.get("documentId"),
			category=deserialized_dict.get("category"),
			sub_category=deserialized_dict.get("subCategory"),
			secret_foreign_keys={x0 for x0 in deserialized_dict["secretForeignKeys"]},
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

@dataclass
class EncryptedReceipt:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	attachment_ids: dict['ReceiptBlobType', str] = field(default_factory=dict)
	references: list[str] = field(default_factory=list)
	document_id: Optional[str] = None
	category: Optional[str] = None
	sub_category: Optional[str] = None
	secret_foreign_keys: set[str] = field(default_factory=set)
	crypted_foreign_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	delegations: dict[str, list['Delegation']] = field(default_factory=dict)
	encryption_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"attachmentIds": {k0.__serialize__(): v0 for k0, v0 in self.attachment_ids.items()},
			"references": [x0 for x0 in self.references],
			"documentId": self.document_id,
			"category": self.category,
			"subCategory": self.sub_category,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedReceipt':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			attachment_ids=dict(map(lambda kv0: (ReceiptBlobType._deserialize(kv0[0]), kv0[1]), deserialized_dict["attachmentIds"].items())),
			references=[x0 for x0 in deserialized_dict["references"]],
			document_id=deserialized_dict.get("documentId"),
			category=deserialized_dict.get("category"),
			sub_category=deserialized_dict.get("subCategory"),
			secret_foreign_keys={x0 for x0 in deserialized_dict["secretForeignKeys"]},
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

type Receipt = Union['DecryptedReceipt', 'EncryptedReceipt']

def serialize_receipt(receipt: Receipt) -> Any:
	if isinstance(receipt, DecryptedReceipt):
		serialized_entity = receipt.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.DecryptedReceipt"})
		return serialized_entity
	elif isinstance(receipt, EncryptedReceipt):
		serialized_entity = receipt.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.EncryptedReceipt"})
		return serialized_entity
	else:
		raise Exception(f"{type(receipt)} is not a known subclass of Receipt")

def deserialize_receipt(data: Union[str, dict[str, JsonElement]]) -> 'Receipt':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.DecryptedReceipt":
		return DecryptedReceipt._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.EncryptedReceipt":
		return EncryptedReceipt._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of Receipt")

@dataclass
class ReceiptShareOptions:
	requested_permissions: 'RequestedPermission' = field(default_factory=lambda: RequestedPermission.MaxWrite)
	share_encryption_key: 'ShareMetadataBehaviour' = field(default_factory=lambda: ShareMetadataBehaviour.IfAvailable)
	share_secret_ids: 'SecretIdShareOptions' = field(default_factory=lambda: SecretIdShareOptionsAllAvailable())

	def __serialize__(self) -> Any:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"shareSecretIds": serialize_secret_id_share_options(self.share_secret_ids),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ReceiptShareOptions':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions=RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key=ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_secret_ids=deserialize_secret_id_share_options(deserialized_dict["shareSecretIds"]),
		)

@dataclass
class HealthcareParty:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	deletion_date: Optional[int] = None
	identifier: list['Identifier'] = field(default_factory=list)
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	name: Optional[str] = None
	last_name: Optional[str] = None
	first_name: Optional[str] = None
	names: list['PersonName'] = field(default_factory=list)
	gender: Optional['Gender'] = None
	civility: Optional[str] = None
	company_name: Optional[str] = None
	speciality: Optional[str] = None
	bank_account: Optional[str] = None
	bic: Optional[str] = None
	proxy_bank_account: Optional[str] = None
	proxy_bic: Optional[str] = None
	invoice_header: Optional[str] = None
	cbe: Optional[str] = None
	ehp: Optional[str] = None
	user_id: Optional[str] = None
	parent_id: Optional[str] = None
	convention: Optional[int] = None
	nihii: Optional[str] = None
	nihii_spec_code: Optional[str] = None
	ssin: Optional[str] = None
	addresses: list['DecryptedAddress'] = field(default_factory=list)
	languages: list[str] = field(default_factory=list)
	picture: Optional[bytearray] = None
	statuses: set['HealthcarePartyStatus'] = field(default_factory=set)
	status_history: list['HealthcarePartyHistoryStatus'] = field(default_factory=list)
	speciality_codes: set['CodeStub'] = field(default_factory=set)
	send_formats: dict['TelecomType', str] = field(default_factory=dict)
	notes: Optional[str] = None
	financial_institution_information: list['DecryptedFinancialInstitutionInformation'] = field(default_factory=list)
	descr: Optional[dict[str, str]] = field(default_factory=dict)
	billing_type: Optional[str] = None
	type: Optional[str] = None
	contact_person: Optional[str] = None
	contact_person_hcp_id: Optional[str] = None
	supervisor_id: Optional[str] = None
	flat_rate_tarifications: list['DecryptedFlatRateTarification'] = field(default_factory=list)
	imported_data: dict[str, str] = field(default_factory=dict)
	properties: list['DecryptedPropertyStub'] = field(default_factory=list)
	public: bool = False
	crypto_actor_properties: Optional[list['DecryptedPropertyStub']] = None
	hc_party_keys: dict[str, list['HexString']] = field(default_factory=dict)
	aes_exchange_keys: dict['AesExchangeKeyEntryKeyString', dict[str, dict['AesExchangeKeyEncryptionKeypairIdentifier', 'HexString']]] = field(default_factory=dict)
	transfer_keys: dict['AesExchangeKeyEncryptionKeypairIdentifier', dict['AesExchangeKeyEncryptionKeypairIdentifier', 'HexString']] = field(default_factory=dict)
	private_key_shamir_partitions: dict[str, 'HexString'] = field(default_factory=dict)
	public_key: Optional['SpkiHexString'] = None
	public_keys_for_oaep_with_sha256: set['SpkiHexString'] = field(default_factory=set)

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"deletionDate": self.deletion_date,
			"identifier": [x0.__serialize__() for x0 in self.identifier],
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"name": self.name,
			"lastName": self.last_name,
			"firstName": self.first_name,
			"names": [x0.__serialize__() for x0 in self.names],
			"gender": self.gender.__serialize__() if self.gender is not None else None,
			"civility": self.civility,
			"companyName": self.company_name,
			"speciality": self.speciality,
			"bankAccount": self.bank_account,
			"bic": self.bic,
			"proxyBankAccount": self.proxy_bank_account,
			"proxyBic": self.proxy_bic,
			"invoiceHeader": self.invoice_header,
			"cbe": self.cbe,
			"ehp": self.ehp,
			"userId": self.user_id,
			"parentId": self.parent_id,
			"convention": self.convention,
			"nihii": self.nihii,
			"nihiiSpecCode": self.nihii_spec_code,
			"ssin": self.ssin,
			"addresses": [x0.__serialize__() for x0 in self.addresses],
			"languages": [x0 for x0 in self.languages],
			"picture": base64.b64encode(self.picture).decode('utf-8') if self.picture is not None else None,
			"statuses": [x0.__serialize__() for x0 in self.statuses],
			"statusHistory": [x0.__serialize__() for x0 in self.status_history],
			"specialityCodes": [x0.__serialize__() for x0 in self.speciality_codes],
			"sendFormats": {k0.__serialize__(): v0 for k0, v0 in self.send_formats.items()},
			"notes": self.notes,
			"financialInstitutionInformation": [x0.__serialize__() for x0 in self.financial_institution_information],
			"descr": {k0: v0 for k0, v0 in self.descr.items()} if self.descr is not None else None,
			"billingType": self.billing_type,
			"type": self.type,
			"contactPerson": self.contact_person,
			"contactPersonHcpId": self.contact_person_hcp_id,
			"supervisorId": self.supervisor_id,
			"flatRateTarifications": [x0.__serialize__() for x0 in self.flat_rate_tarifications],
			"importedData": {k0: v0 for k0, v0 in self.imported_data.items()},
			"properties": [x0.__serialize__() for x0 in self.properties],
			"public": self.public,
			"cryptoActorProperties": [x0.__serialize__() for x0 in self.crypto_actor_properties] if self.crypto_actor_properties is not None else None,
			"hcPartyKeys": {k0: [x1 for x1 in v0] for k0, v0 in self.hc_party_keys.items()},
			"aesExchangeKeys": {k0: {k1: {k2: v2 for k2, v2 in v1.items()} for k1, v1 in v0.items()} for k0, v0 in self.aes_exchange_keys.items()},
			"transferKeys": {k0: {k1: v1 for k1, v1 in v0.items()} for k0, v0 in self.transfer_keys.items()},
			"privateKeyShamirPartitions": {k0: v0 for k0, v0 in self.private_key_shamir_partitions.items()},
			"publicKey": self.public_key,
			"publicKeysForOaepWithSha256": [x0 for x0 in self.public_keys_for_oaep_with_sha256],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'HealthcareParty':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			deletion_date=deserialized_dict.get("deletionDate"),
			identifier=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			name=deserialized_dict.get("name"),
			last_name=deserialized_dict.get("lastName"),
			first_name=deserialized_dict.get("firstName"),
			names=[PersonName._deserialize(x0) for x0 in deserialized_dict["names"]],
			gender=Gender._deserialize(deserialized_dict.get("gender")) if deserialized_dict.get("gender") is not None else None,
			civility=deserialized_dict.get("civility"),
			company_name=deserialized_dict.get("companyName"),
			speciality=deserialized_dict.get("speciality"),
			bank_account=deserialized_dict.get("bankAccount"),
			bic=deserialized_dict.get("bic"),
			proxy_bank_account=deserialized_dict.get("proxyBankAccount"),
			proxy_bic=deserialized_dict.get("proxyBic"),
			invoice_header=deserialized_dict.get("invoiceHeader"),
			cbe=deserialized_dict.get("cbe"),
			ehp=deserialized_dict.get("ehp"),
			user_id=deserialized_dict.get("userId"),
			parent_id=deserialized_dict.get("parentId"),
			convention=deserialized_dict.get("convention"),
			nihii=deserialized_dict.get("nihii"),
			nihii_spec_code=deserialized_dict.get("nihiiSpecCode"),
			ssin=deserialized_dict.get("ssin"),
			addresses=[DecryptedAddress._deserialize(x0) for x0 in deserialized_dict["addresses"]],
			languages=[x0 for x0 in deserialized_dict["languages"]],
			picture=bytearray(base64.b64decode(deserialized_dict.get("picture"))) if deserialized_dict.get("picture") is not None else None,
			statuses={HealthcarePartyStatus._deserialize(x0) for x0 in deserialized_dict["statuses"]},
			status_history=[HealthcarePartyHistoryStatus._deserialize(x0) for x0 in deserialized_dict["statusHistory"]],
			speciality_codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["specialityCodes"]},
			send_formats=dict(map(lambda kv0: (TelecomType._deserialize(kv0[0]), kv0[1]), deserialized_dict["sendFormats"].items())),
			notes=deserialized_dict.get("notes"),
			financial_institution_information=[DecryptedFinancialInstitutionInformation._deserialize(x0) for x0 in deserialized_dict["financialInstitutionInformation"]],
			descr=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("descr").items())) if deserialized_dict.get("descr") is not None else None,
			billing_type=deserialized_dict.get("billingType"),
			type=deserialized_dict.get("type"),
			contact_person=deserialized_dict.get("contactPerson"),
			contact_person_hcp_id=deserialized_dict.get("contactPersonHcpId"),
			supervisor_id=deserialized_dict.get("supervisorId"),
			flat_rate_tarifications=[DecryptedFlatRateTarification._deserialize(x0) for x0 in deserialized_dict["flatRateTarifications"]],
			imported_data=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["importedData"].items())),
			properties=[DecryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict["properties"]],
			public=deserialized_dict["public"],
			crypto_actor_properties=[DecryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict.get("cryptoActorProperties")] if deserialized_dict.get("cryptoActorProperties") is not None else None,
			hc_party_keys=dict(map(lambda kv0: (kv0[0], [x1 for x1 in kv0[1]]), deserialized_dict["hcPartyKeys"].items())),
			aes_exchange_keys=dict(map(lambda kv0: (kv0[0], dict(map(lambda kv1: (kv1[0], dict(map(lambda kv2: (kv2[0], kv2[1]), kv1[1].items()))), kv0[1].items()))), deserialized_dict["aesExchangeKeys"].items())),
			transfer_keys=dict(map(lambda kv0: (kv0[0], dict(map(lambda kv1: (kv1[0], kv1[1]), kv0[1].items()))), deserialized_dict["transferKeys"].items())),
			private_key_shamir_partitions=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["privateKeyShamirPartitions"].items())),
			public_key=deserialized_dict.get("publicKey"),
			public_keys_for_oaep_with_sha256={x0 for x0 in deserialized_dict["publicKeysForOaepWithSha256"]},
		)

@dataclass
class PublicKey:
	hc_party_id: Optional[str] = None
	hex_string: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"hcPartyId": self.hc_party_id,
			"hexString": self.hex_string,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'PublicKey':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			hc_party_id=deserialized_dict.get("hcPartyId"),
			hex_string=deserialized_dict.get("hexString"),
		)

@dataclass
class DataOwnerRegistrationSuccess:
	user_login: str
	user_id: str
	token: str

	def __serialize__(self) -> Any:
		return {
			"userLogin": self.user_login,
			"userId": self.user_id,
			"token": self.token,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DataOwnerRegistrationSuccess':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			user_login=deserialized_dict["userLogin"],
			user_id=deserialized_dict["userId"],
			token=deserialized_dict["token"],
		)

@dataclass
class AccessLogShareOptions:
	requested_permissions: 'RequestedPermission' = field(default_factory=lambda: RequestedPermission.MaxWrite)
	share_encryption_key: 'ShareMetadataBehaviour' = field(default_factory=lambda: ShareMetadataBehaviour.IfAvailable)
	share_patient_id: 'ShareMetadataBehaviour' = field(default_factory=lambda: ShareMetadataBehaviour.IfAvailable)
	share_secret_ids: 'SecretIdShareOptions' = field(default_factory=lambda: SecretIdShareOptionsAllAvailable())

	def __serialize__(self) -> Any:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"sharePatientId": self.share_patient_id.__serialize__(),
			"shareSecretIds": serialize_secret_id_share_options(self.share_secret_ids),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'AccessLogShareOptions':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions=RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key=ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_patient_id=ShareMetadataBehaviour._deserialize(deserialized_dict["sharePatientId"]),
			share_secret_ids=deserialize_secret_id_share_options(deserialized_dict["shareSecretIds"]),
		)

@dataclass
class Permission:
	grants: list['PermissionItem'] = field(default_factory=list)
	revokes: list['PermissionItem'] = field(default_factory=list)

	def __serialize__(self) -> Any:
		return {
			"grants": [serialize_permission_item(x0) for x0 in self.grants],
			"revokes": [serialize_permission_item(x0) for x0 in self.revokes],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Permission':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			grants=[deserialize_permission_item(x0) for x0 in deserialized_dict["grants"]],
			revokes=[deserialize_permission_item(x0) for x0 in deserialized_dict["revokes"]],
		)

@dataclass
class Code:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	context: Optional[str] = None
	type: Optional[str] = None
	code: Optional[str] = None
	version: Optional[str] = None
	label: Optional[dict[str, str]] = None
	author: Optional[str] = None
	regions: set[str] = field(default_factory=set)
	periodicity: set['Periodicity'] = field(default_factory=set)
	level: Optional[int] = None
	links: set[str] = field(default_factory=set)
	qualified_links: dict[str, list[str]] = field(default_factory=dict)
	flags: set['CodeFlag'] = field(default_factory=set)
	search_terms: dict[str, set[str]] = field(default_factory=dict)
	data: Optional[str] = None
	appendices: dict['AppendixType', str] = field(default_factory=dict)
	disabled: bool = False

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"context": self.context,
			"type": self.type,
			"code": self.code,
			"version": self.version,
			"label": {k0: v0 for k0, v0 in self.label.items()} if self.label is not None else None,
			"author": self.author,
			"regions": [x0 for x0 in self.regions],
			"periodicity": [x0.__serialize__() for x0 in self.periodicity],
			"level": self.level,
			"links": [x0 for x0 in self.links],
			"qualifiedLinks": {k0: [x1 for x1 in v0] for k0, v0 in self.qualified_links.items()},
			"flags": [x0.__serialize__() for x0 in self.flags],
			"searchTerms": {k0: [x1 for x1 in v0] for k0, v0 in self.search_terms.items()},
			"data": self.data,
			"appendices": {k0.__serialize__(): v0 for k0, v0 in self.appendices.items()},
			"disabled": self.disabled,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Code':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			deletion_date=deserialized_dict.get("deletionDate"),
			context=deserialized_dict.get("context"),
			type=deserialized_dict.get("type"),
			code=deserialized_dict.get("code"),
			version=deserialized_dict.get("version"),
			label=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("label").items())) if deserialized_dict.get("label") is not None else None,
			author=deserialized_dict.get("author"),
			regions={x0 for x0 in deserialized_dict["regions"]},
			periodicity={Periodicity._deserialize(x0) for x0 in deserialized_dict["periodicity"]},
			level=deserialized_dict.get("level"),
			links={x0 for x0 in deserialized_dict["links"]},
			qualified_links=dict(map(lambda kv0: (kv0[0], [x1 for x1 in kv0[1]]), deserialized_dict["qualifiedLinks"].items())),
			flags={CodeFlag._deserialize(x0) for x0 in deserialized_dict["flags"]},
			search_terms=dict(map(lambda kv0: (kv0[0], {x1 for x1 in kv0[1]}), deserialized_dict["searchTerms"].items())),
			data=deserialized_dict.get("data"),
			appendices=dict(map(lambda kv0: (AppendixType._deserialize(kv0[0]), kv0[1]), deserialized_dict["appendices"].items())),
			disabled=deserialized_dict["disabled"],
		)

@dataclass
class BooleanResponse:
	response: bool

	def __serialize__(self) -> Any:
		return {
			"response": self.response,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'BooleanResponse':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			response=deserialized_dict["response"],
		)

@dataclass
class FrontEndMigration:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	name: Optional[str] = None
	start_date: Optional[int] = None
	end_date: Optional[int] = None
	status: Optional['FrontEndMigrationStatus'] = None
	logs: Optional[str] = None
	user_id: Optional[str] = None
	start_key: Optional[str] = None
	start_key_doc_id: Optional[str] = None
	process_count: Optional[int] = None
	properties: list['DecryptedPropertyStub'] = field(default_factory=list)

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"name": self.name,
			"startDate": self.start_date,
			"endDate": self.end_date,
			"status": self.status.__serialize__() if self.status is not None else None,
			"logs": self.logs,
			"userId": self.user_id,
			"startKey": self.start_key,
			"startKeyDocId": self.start_key_doc_id,
			"processCount": self.process_count,
			"properties": [x0.__serialize__() for x0 in self.properties],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'FrontEndMigration':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			deletion_date=deserialized_dict.get("deletionDate"),
			name=deserialized_dict.get("name"),
			start_date=deserialized_dict.get("startDate"),
			end_date=deserialized_dict.get("endDate"),
			status=FrontEndMigrationStatus._deserialize(deserialized_dict.get("status")) if deserialized_dict.get("status") is not None else None,
			logs=deserialized_dict.get("logs"),
			user_id=deserialized_dict.get("userId"),
			start_key=deserialized_dict.get("startKey"),
			start_key_doc_id=deserialized_dict.get("startKeyDocId"),
			process_count=deserialized_dict.get("processCount"),
			properties=[DecryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict["properties"]],
		)

@dataclass
class DecryptedTopic:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	health_element_id: Optional[str] = None
	contact_id: Optional[str] = None
	description: Optional[str] = None
	codes: set['CodeStub'] = field(default_factory=set)
	tags: set['CodeStub'] = field(default_factory=set)
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	active_participants: dict[str, 'TopicRole'] = field(default_factory=dict)
	security_metadata: Optional['SecurityMetadata'] = None
	secret_foreign_keys: set[str] = field(default_factory=set)
	crypted_foreign_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	delegations: dict[str, list['Delegation']] = field(default_factory=dict)
	encryption_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	linked_health_elements: set[str] = field(default_factory=set)
	linked_services: set[str] = field(default_factory=set)

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"healthElementId": self.health_element_id,
			"contactId": self.contact_id,
			"description": self.description,
			"codes": [x0.__serialize__() for x0 in self.codes],
			"tags": [x0.__serialize__() for x0 in self.tags],
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"activeParticipants": {k0: v0.__serialize__() for k0, v0 in self.active_participants.items()},
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"linkedHealthElements": [x0 for x0 in self.linked_health_elements],
			"linkedServices": [x0 for x0 in self.linked_services],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedTopic':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			health_element_id=deserialized_dict.get("healthElementId"),
			contact_id=deserialized_dict.get("contactId"),
			description=deserialized_dict.get("description"),
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			active_participants=dict(map(lambda kv0: (kv0[0], TopicRole._deserialize(kv0[1])), deserialized_dict["activeParticipants"].items())),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
			secret_foreign_keys={x0 for x0 in deserialized_dict["secretForeignKeys"]},
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			linked_health_elements={x0 for x0 in deserialized_dict["linkedHealthElements"]},
			linked_services={x0 for x0 in deserialized_dict["linkedServices"]},
		)

@dataclass
class EncryptedTopic:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	health_element_id: Optional[str] = None
	contact_id: Optional[str] = None
	description: Optional[str] = None
	codes: set['CodeStub'] = field(default_factory=set)
	tags: set['CodeStub'] = field(default_factory=set)
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	active_participants: dict[str, 'TopicRole'] = field(default_factory=dict)
	security_metadata: Optional['SecurityMetadata'] = None
	secret_foreign_keys: set[str] = field(default_factory=set)
	crypted_foreign_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	delegations: dict[str, list['Delegation']] = field(default_factory=dict)
	encryption_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	linked_health_elements: set[str] = field(default_factory=set)
	linked_services: set[str] = field(default_factory=set)

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"healthElementId": self.health_element_id,
			"contactId": self.contact_id,
			"description": self.description,
			"codes": [x0.__serialize__() for x0 in self.codes],
			"tags": [x0.__serialize__() for x0 in self.tags],
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"activeParticipants": {k0: v0.__serialize__() for k0, v0 in self.active_participants.items()},
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"linkedHealthElements": [x0 for x0 in self.linked_health_elements],
			"linkedServices": [x0 for x0 in self.linked_services],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedTopic':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			health_element_id=deserialized_dict.get("healthElementId"),
			contact_id=deserialized_dict.get("contactId"),
			description=deserialized_dict.get("description"),
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			active_participants=dict(map(lambda kv0: (kv0[0], TopicRole._deserialize(kv0[1])), deserialized_dict["activeParticipants"].items())),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
			secret_foreign_keys={x0 for x0 in deserialized_dict["secretForeignKeys"]},
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			linked_health_elements={x0 for x0 in deserialized_dict["linkedHealthElements"]},
			linked_services={x0 for x0 in deserialized_dict["linkedServices"]},
		)

type Topic = Union['DecryptedTopic', 'EncryptedTopic']

def serialize_topic(topic: Topic) -> Any:
	if isinstance(topic, DecryptedTopic):
		serialized_entity = topic.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.DecryptedTopic"})
		return serialized_entity
	elif isinstance(topic, EncryptedTopic):
		serialized_entity = topic.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.EncryptedTopic"})
		return serialized_entity
	else:
		raise Exception(f"{type(topic)} is not a known subclass of Topic")

def deserialize_topic(data: Union[str, dict[str, JsonElement]]) -> 'Topic':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.DecryptedTopic":
		return DecryptedTopic._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.EncryptedTopic":
		return EncryptedTopic._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of Topic")

@dataclass
class TopicShareOptions:
	requested_permissions: 'RequestedPermission' = field(default_factory=lambda: RequestedPermission.MaxWrite)
	share_encryption_key: 'ShareMetadataBehaviour' = field(default_factory=lambda: ShareMetadataBehaviour.IfAvailable)
	share_patient_id: 'ShareMetadataBehaviour' = field(default_factory=lambda: ShareMetadataBehaviour.IfAvailable)
	share_secret_ids: 'SecretIdShareOptions' = field(default_factory=lambda: SecretIdShareOptionsAllAvailable())

	def __serialize__(self) -> Any:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"sharePatientId": self.share_patient_id.__serialize__(),
			"shareSecretIds": serialize_secret_id_share_options(self.share_secret_ids),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'TopicShareOptions':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions=RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key=ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_patient_id=ShareMetadataBehaviour._deserialize(deserialized_dict["sharePatientId"]),
			share_secret_ids=deserialize_secret_id_share_options(deserialized_dict["shareSecretIds"]),
		)

class TopicRole(Enum):
	Participant = "PARTICIPANT"
	Admin = "ADMIN"
	Owner = "OWNER"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'TopicRole':
		if data == "PARTICIPANT":
			return TopicRole.Participant
		elif data == "ADMIN":
			return TopicRole.Admin
		elif data == "OWNER":
			return TopicRole.Owner
		else:
			raise Exception(f"{data} is not a valid value for TopicRole enum.")

@dataclass
class DocumentTemplate:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	attachment: Optional[bytearray] = None
	document_type: Optional['DocumentType'] = None
	main_uti: Optional[str] = None
	name: Optional[str] = None
	other_utis: set[str] = field(default_factory=set)
	attachment_id: Optional[str] = None
	version: Optional['ReportVersion'] = None
	owner: Optional[str] = None
	guid: Optional[str] = None
	group: Optional['DocumentGroup'] = None
	descr: Optional[str] = None
	disabled: Optional[str] = None
	specialty: Optional['CodeStub'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"attachment": base64.b64encode(self.attachment).decode('utf-8') if self.attachment is not None else None,
			"documentType": self.document_type.__serialize__() if self.document_type is not None else None,
			"mainUti": self.main_uti,
			"name": self.name,
			"otherUtis": [x0 for x0 in self.other_utis],
			"attachmentId": self.attachment_id,
			"version": self.version.__serialize__() if self.version is not None else None,
			"owner": self.owner,
			"guid": self.guid,
			"group": self.group.__serialize__() if self.group is not None else None,
			"descr": self.descr,
			"disabled": self.disabled,
			"specialty": self.specialty.__serialize__() if self.specialty is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DocumentTemplate':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			attachment=bytearray(base64.b64decode(deserialized_dict.get("attachment"))) if deserialized_dict.get("attachment") is not None else None,
			document_type=DocumentType._deserialize(deserialized_dict.get("documentType")) if deserialized_dict.get("documentType") is not None else None,
			main_uti=deserialized_dict.get("mainUti"),
			name=deserialized_dict.get("name"),
			other_utis={x0 for x0 in deserialized_dict["otherUtis"]},
			attachment_id=deserialized_dict.get("attachmentId"),
			version=ReportVersion._deserialize(deserialized_dict.get("version")) if deserialized_dict.get("version") is not None else None,
			owner=deserialized_dict.get("owner"),
			guid=deserialized_dict.get("guid"),
			group=DocumentGroup._deserialize(deserialized_dict.get("group")) if deserialized_dict.get("group") is not None else None,
			descr=deserialized_dict.get("descr"),
			disabled=deserialized_dict.get("disabled"),
			specialty=CodeStub._deserialize(deserialized_dict.get("specialty")) if deserialized_dict.get("specialty") is not None else None,
		)

@dataclass
class EncryptedHealthElement:
	id: str
	identifiers: list['Identifier'] = field(default_factory=list)
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	health_element_id: Optional[str] = None
	value_date: Optional[int] = None
	opening_date: Optional[int] = None
	closing_date: Optional[int] = None
	descr: Optional[str] = None
	note: Optional[str] = None
	notes: list['Annotation'] = field(default_factory=list)
	relevant: bool = True
	id_opening_contact: Optional[str] = None
	id_closing_contact: Optional[str] = None
	id_service: Optional[str] = None
	status: int = 0
	laterality: Optional['Laterality'] = None
	plans_of_action: list['EncryptedPlanOfAction'] = field(default_factory=list)
	episodes: list['EncryptedEpisode'] = field(default_factory=list)
	care_team: list['EncryptedCareTeamMember'] = field(default_factory=list)
	secret_foreign_keys: set[str] = field(default_factory=set)
	crypted_foreign_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	delegations: dict[str, list['Delegation']] = field(default_factory=dict)
	encryption_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"identifiers": [x0.__serialize__() for x0 in self.identifiers],
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"healthElementId": self.health_element_id,
			"valueDate": self.value_date,
			"openingDate": self.opening_date,
			"closingDate": self.closing_date,
			"descr": self.descr,
			"note": self.note,
			"notes": [x0.__serialize__() for x0 in self.notes],
			"relevant": self.relevant,
			"idOpeningContact": self.id_opening_contact,
			"idClosingContact": self.id_closing_contact,
			"idService": self.id_service,
			"status": self.status,
			"laterality": self.laterality.__serialize__() if self.laterality is not None else None,
			"plansOfAction": [x0.__serialize__() for x0 in self.plans_of_action],
			"episodes": [x0.__serialize__() for x0 in self.episodes],
			"careTeam": [x0.__serialize__() for x0 in self.care_team],
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedHealthElement':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			identifiers=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifiers"]],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			health_element_id=deserialized_dict.get("healthElementId"),
			value_date=deserialized_dict.get("valueDate"),
			opening_date=deserialized_dict.get("openingDate"),
			closing_date=deserialized_dict.get("closingDate"),
			descr=deserialized_dict.get("descr"),
			note=deserialized_dict.get("note"),
			notes=[Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
			relevant=deserialized_dict["relevant"],
			id_opening_contact=deserialized_dict.get("idOpeningContact"),
			id_closing_contact=deserialized_dict.get("idClosingContact"),
			id_service=deserialized_dict.get("idService"),
			status=deserialized_dict["status"],
			laterality=Laterality._deserialize(deserialized_dict.get("laterality")) if deserialized_dict.get("laterality") is not None else None,
			plans_of_action=[EncryptedPlanOfAction._deserialize(x0) for x0 in deserialized_dict["plansOfAction"]],
			episodes=[EncryptedEpisode._deserialize(x0) for x0 in deserialized_dict["episodes"]],
			care_team=[EncryptedCareTeamMember._deserialize(x0) for x0 in deserialized_dict["careTeam"]],
			secret_foreign_keys={x0 for x0 in deserialized_dict["secretForeignKeys"]},
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

@dataclass
class DecryptedHealthElement:
	id: str
	identifiers: list['Identifier'] = field(default_factory=list)
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	health_element_id: Optional[str] = None
	value_date: Optional[int] = None
	opening_date: Optional[int] = None
	closing_date: Optional[int] = None
	descr: Optional[str] = None
	note: Optional[str] = None
	notes: list['Annotation'] = field(default_factory=list)
	relevant: bool = True
	id_opening_contact: Optional[str] = None
	id_closing_contact: Optional[str] = None
	id_service: Optional[str] = None
	status: int = 0
	laterality: Optional['Laterality'] = None
	plans_of_action: list['DecryptedPlanOfAction'] = field(default_factory=list)
	episodes: list['DecryptedEpisode'] = field(default_factory=list)
	care_team: list['DecryptedCareTeamMember'] = field(default_factory=list)
	secret_foreign_keys: set[str] = field(default_factory=set)
	crypted_foreign_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	delegations: dict[str, list['Delegation']] = field(default_factory=dict)
	encryption_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"identifiers": [x0.__serialize__() for x0 in self.identifiers],
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"healthElementId": self.health_element_id,
			"valueDate": self.value_date,
			"openingDate": self.opening_date,
			"closingDate": self.closing_date,
			"descr": self.descr,
			"note": self.note,
			"notes": [x0.__serialize__() for x0 in self.notes],
			"relevant": self.relevant,
			"idOpeningContact": self.id_opening_contact,
			"idClosingContact": self.id_closing_contact,
			"idService": self.id_service,
			"status": self.status,
			"laterality": self.laterality.__serialize__() if self.laterality is not None else None,
			"plansOfAction": [x0.__serialize__() for x0 in self.plans_of_action],
			"episodes": [x0.__serialize__() for x0 in self.episodes],
			"careTeam": [x0.__serialize__() for x0 in self.care_team],
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedHealthElement':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			identifiers=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifiers"]],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			health_element_id=deserialized_dict.get("healthElementId"),
			value_date=deserialized_dict.get("valueDate"),
			opening_date=deserialized_dict.get("openingDate"),
			closing_date=deserialized_dict.get("closingDate"),
			descr=deserialized_dict.get("descr"),
			note=deserialized_dict.get("note"),
			notes=[Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
			relevant=deserialized_dict["relevant"],
			id_opening_contact=deserialized_dict.get("idOpeningContact"),
			id_closing_contact=deserialized_dict.get("idClosingContact"),
			id_service=deserialized_dict.get("idService"),
			status=deserialized_dict["status"],
			laterality=Laterality._deserialize(deserialized_dict.get("laterality")) if deserialized_dict.get("laterality") is not None else None,
			plans_of_action=[DecryptedPlanOfAction._deserialize(x0) for x0 in deserialized_dict["plansOfAction"]],
			episodes=[DecryptedEpisode._deserialize(x0) for x0 in deserialized_dict["episodes"]],
			care_team=[DecryptedCareTeamMember._deserialize(x0) for x0 in deserialized_dict["careTeam"]],
			secret_foreign_keys={x0 for x0 in deserialized_dict["secretForeignKeys"]},
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

type HealthElement = Union['EncryptedHealthElement', 'DecryptedHealthElement']

def serialize_health_element(health_element: HealthElement) -> Any:
	if isinstance(health_element, EncryptedHealthElement):
		serialized_entity = health_element.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.EncryptedHealthElement"})
		return serialized_entity
	elif isinstance(health_element, DecryptedHealthElement):
		serialized_entity = health_element.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.DecryptedHealthElement"})
		return serialized_entity
	else:
		raise Exception(f"{type(health_element)} is not a known subclass of HealthElement")

def deserialize_health_element(data: Union[str, dict[str, JsonElement]]) -> 'HealthElement':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.EncryptedHealthElement":
		return EncryptedHealthElement._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.DecryptedHealthElement":
		return DecryptedHealthElement._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of HealthElement")

@dataclass
class IndexingInfo:
	statuses: Optional[dict[str, int]] = None

	def __serialize__(self) -> Any:
		return {
			"statuses": {k0: v0 for k0, v0 in self.statuses.items()} if self.statuses is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'IndexingInfo':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			statuses=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("statuses").items())) if deserialized_dict.get("statuses") is not None else None,
		)

@dataclass
class ReplicationInfo:
	active: bool = False
	running: bool = False
	pending_from: Optional[int] = None
	pending_to: Optional[int] = None

	def __serialize__(self) -> Any:
		return {
			"active": self.active,
			"running": self.running,
			"pendingFrom": self.pending_from,
			"pendingTo": self.pending_to,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ReplicationInfo':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			active=deserialized_dict["active"],
			running=deserialized_dict["running"],
			pending_from=deserialized_dict.get("pendingFrom"),
			pending_to=deserialized_dict.get("pendingTo"),
		)

@dataclass
class ReplicatorDocument:
	id: str
	rev: Optional[str] = None
	source: Optional['Remote'] = None
	target: Optional['Remote'] = None
	owner: Optional[str] = None
	create_target: Optional[bool] = None
	continuous: Optional[bool] = None
	doc_ids: Optional[list[str]] = None
	replication_state: Optional[str] = None
	replication_state_time: Optional[str] = None
	replication_stats: Optional['ReplicationStats'] = None
	error_count: Optional[int] = None
	revs_info: Optional[list[dict[str, str]]] = None
	rev_history: Optional[dict[str, str]] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"source": self.source.__serialize__() if self.source is not None else None,
			"target": self.target.__serialize__() if self.target is not None else None,
			"owner": self.owner,
			"create_target": self.create_target,
			"continuous": self.continuous,
			"doc_ids": [x0 for x0 in self.doc_ids] if self.doc_ids is not None else None,
			"replicationState": self.replication_state,
			"replicationStateTime": self.replication_state_time,
			"replicationStats": self.replication_stats.__serialize__() if self.replication_stats is not None else None,
			"errorCount": self.error_count,
			"revsInfo": [{k1: v1 for k1, v1 in x0.items()} for x0 in self.revs_info] if self.revs_info is not None else None,
			"revHistory": {k0: v0 for k0, v0 in self.rev_history.items()} if self.rev_history is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ReplicatorDocument':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			source=Remote._deserialize(deserialized_dict.get("source")) if deserialized_dict.get("source") is not None else None,
			target=Remote._deserialize(deserialized_dict.get("target")) if deserialized_dict.get("target") is not None else None,
			owner=deserialized_dict.get("owner"),
			create_target=deserialized_dict.get("create_target"),
			continuous=deserialized_dict.get("continuous"),
			doc_ids=[x0 for x0 in deserialized_dict.get("doc_ids")] if deserialized_dict.get("doc_ids") is not None else None,
			replication_state=deserialized_dict.get("replicationState"),
			replication_state_time=deserialized_dict.get("replicationStateTime"),
			replication_stats=ReplicationStats._deserialize(deserialized_dict.get("replicationStats")) if deserialized_dict.get("replicationStats") is not None else None,
			error_count=deserialized_dict.get("errorCount"),
			revs_info=[dict(map(lambda kv1: (kv1[0], kv1[1]), x0.items())) for x0 in deserialized_dict.get("revsInfo")] if deserialized_dict.get("revsInfo") is not None else None,
			rev_history=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("revHistory").items())) if deserialized_dict.get("revHistory") is not None else None,
		)

@dataclass
class CalendarItemShareOptions:
	requested_permissions: 'RequestedPermission' = field(default_factory=lambda: RequestedPermission.MaxWrite)
	share_encryption_key: 'ShareMetadataBehaviour' = field(default_factory=lambda: ShareMetadataBehaviour.IfAvailable)
	share_patient_id: 'ShareMetadataBehaviour' = field(default_factory=lambda: ShareMetadataBehaviour.IfAvailable)
	share_secret_ids: 'SecretIdShareOptions' = field(default_factory=lambda: SecretIdShareOptionsAllAvailable())

	def __serialize__(self) -> Any:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"sharePatientId": self.share_patient_id.__serialize__(),
			"shareSecretIds": serialize_secret_id_share_options(self.share_secret_ids),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'CalendarItemShareOptions':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions=RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key=ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_patient_id=ShareMetadataBehaviour._deserialize(deserialized_dict["sharePatientId"]),
			share_secret_ids=deserialize_secret_id_share_options(deserialized_dict["shareSecretIds"]),
		)

@dataclass
class ApplicationSettings:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	settings: dict[str, str] = field(default_factory=dict)

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"settings": {k0: v0 for k0, v0 in self.settings.items()},
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ApplicationSettings':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			settings=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["settings"].items())),
		)

@dataclass
class RawDecryptedExchangeData:
	exchange_data_id: str
	exchange_key: bytearray
	access_control_secret: bytearray
	shared_signature_key: bytearray

	def __serialize__(self) -> Any:
		return {
			"exchangeDataId": self.exchange_data_id,
			"exchangeKey": base64.b64encode(self.exchange_key).decode('utf-8'),
			"accessControlSecret": base64.b64encode(self.access_control_secret).decode('utf-8'),
			"sharedSignatureKey": base64.b64encode(self.shared_signature_key).decode('utf-8'),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'RawDecryptedExchangeData':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			exchange_data_id=deserialized_dict["exchangeDataId"],
			exchange_key=bytearray(base64.b64decode(deserialized_dict["exchangeKey"])),
			access_control_secret=bytearray(base64.b64decode(deserialized_dict["accessControlSecret"])),
			shared_signature_key=bytearray(base64.b64decode(deserialized_dict["sharedSignatureKey"])),
		)

@dataclass
class ExchangeDataInjectionDetails:
	exchange_data_id: str
	access_control_secret: bytearray
	exchange_key: bytearray
	shared_signature_key: bytearray
	verified: bool

	def __serialize__(self) -> Any:
		return {
			"exchangeDataId": self.exchange_data_id,
			"accessControlSecret": base64.b64encode(self.access_control_secret).decode('utf-8'),
			"exchangeKey": base64.b64encode(self.exchange_key).decode('utf-8'),
			"sharedSignatureKey": base64.b64encode(self.shared_signature_key).decode('utf-8'),
			"verified": self.verified,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ExchangeDataInjectionDetails':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			exchange_data_id=deserialized_dict["exchangeDataId"],
			access_control_secret=bytearray(base64.b64decode(deserialized_dict["accessControlSecret"])),
			exchange_key=bytearray(base64.b64decode(deserialized_dict["exchangeKey"])),
			shared_signature_key=bytearray(base64.b64decode(deserialized_dict["sharedSignatureKey"])),
			verified=deserialized_dict["verified"],
		)

@dataclass
class EntityReference:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	doc_id: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"docId": self.doc_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EntityReference':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			deletion_date=deserialized_dict.get("deletionDate"),
			doc_id=deserialized_dict.get("docId"),
		)

@dataclass
class CryptoActorStub:
	id: str
	rev: str
	public_keys_for_oaep_with_sha256: set['SpkiHexString']
	hc_party_keys: dict[str, list['HexString']] = field(default_factory=dict)
	aes_exchange_keys: dict['AesExchangeKeyEntryKeyString', dict[str, dict['AesExchangeKeyEncryptionKeypairIdentifier', 'HexString']]] = field(default_factory=dict)
	transfer_keys: dict['AesExchangeKeyEncryptionKeypairIdentifier', dict['AesExchangeKeyEncryptionKeypairIdentifier', 'HexString']] = field(default_factory=dict)
	private_key_shamir_partitions: dict[str, 'HexString'] = field(default_factory=dict)
	public_key: Optional['SpkiHexString'] = None
	parent_id: Optional[str] = None
	crypto_actor_properties: Optional[list['DecryptedPropertyStub']] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"hcPartyKeys": {k0: [x1 for x1 in v0] for k0, v0 in self.hc_party_keys.items()},
			"aesExchangeKeys": {k0: {k1: {k2: v2 for k2, v2 in v1.items()} for k1, v1 in v0.items()} for k0, v0 in self.aes_exchange_keys.items()},
			"transferKeys": {k0: {k1: v1 for k1, v1 in v0.items()} for k0, v0 in self.transfer_keys.items()},
			"privateKeyShamirPartitions": {k0: v0 for k0, v0 in self.private_key_shamir_partitions.items()},
			"publicKey": self.public_key,
			"publicKeysForOaepWithSha256": [x0 for x0 in self.public_keys_for_oaep_with_sha256],
			"parentId": self.parent_id,
			"cryptoActorProperties": [x0.__serialize__() for x0 in self.crypto_actor_properties] if self.crypto_actor_properties is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'CryptoActorStub':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict["rev"],
			hc_party_keys=dict(map(lambda kv0: (kv0[0], [x1 for x1 in kv0[1]]), deserialized_dict["hcPartyKeys"].items())),
			aes_exchange_keys=dict(map(lambda kv0: (kv0[0], dict(map(lambda kv1: (kv1[0], dict(map(lambda kv2: (kv2[0], kv2[1]), kv1[1].items()))), kv0[1].items()))), deserialized_dict["aesExchangeKeys"].items())),
			transfer_keys=dict(map(lambda kv0: (kv0[0], dict(map(lambda kv1: (kv1[0], kv1[1]), kv0[1].items()))), deserialized_dict["transferKeys"].items())),
			private_key_shamir_partitions=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["privateKeyShamirPartitions"].items())),
			public_key=deserialized_dict.get("publicKey"),
			public_keys_for_oaep_with_sha256={x0 for x0 in deserialized_dict["publicKeysForOaepWithSha256"]},
			parent_id=deserialized_dict.get("parentId"),
			crypto_actor_properties=[DecryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict.get("cryptoActorProperties")] if deserialized_dict.get("cryptoActorProperties") is not None else None,
		)

type CryptoActor = Union['CryptoActorStub', 'EncryptedPatient', 'DecryptedPatient', 'Device', 'HealthcareParty']

def serialize_crypto_actor(crypto_actor: CryptoActor) -> Any:
	if isinstance(crypto_actor, CryptoActorStub):
		serialized_entity = crypto_actor.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.CryptoActorStub"})
		return serialized_entity
	elif isinstance(crypto_actor, EncryptedPatient):
		serialized_entity = crypto_actor.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.EncryptedPatient"})
		return serialized_entity
	elif isinstance(crypto_actor, DecryptedPatient):
		serialized_entity = crypto_actor.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.DecryptedPatient"})
		return serialized_entity
	elif isinstance(crypto_actor, Device):
		serialized_entity = crypto_actor.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.Device"})
		return serialized_entity
	elif isinstance(crypto_actor, HealthcareParty):
		serialized_entity = crypto_actor.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.HealthcareParty"})
		return serialized_entity
	else:
		raise Exception(f"{type(crypto_actor)} is not a known subclass of CryptoActor")

def deserialize_crypto_actor(data: Union[str, dict[str, JsonElement]]) -> 'CryptoActor':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.CryptoActorStub":
		return CryptoActorStub._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.EncryptedPatient":
		return EncryptedPatient._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.DecryptedPatient":
		return DecryptedPatient._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.Device":
		return Device._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.HealthcareParty":
		return HealthcareParty._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of CryptoActor")

@dataclass
class CryptoActorStubWithType:
	type: 'DataOwnerType'
	stub: 'CryptoActorStub'

	def __serialize__(self) -> Any:
		return {
			"type": self.type.__serialize__(),
			"stub": self.stub.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'CryptoActorStubWithType':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			type=DataOwnerType._deserialize(deserialized_dict["type"]),
			stub=CryptoActorStub._deserialize(deserialized_dict["stub"]),
		)

@dataclass
class ShamirUpdateRequest:
	notaries_ids: set[str]
	min_shares: int

	def __serialize__(self) -> Any:
		return {
			"notariesIds": [x0 for x0 in self.notaries_ids],
			"minShares": self.min_shares,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ShamirUpdateRequest':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			notaries_ids={x0 for x0 in deserialized_dict["notariesIds"]},
			min_shares=deserialized_dict["minShares"],
		)

@dataclass
class DecryptedMessage:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	from_address: Optional[str] = None
	from_healthcare_party_id: Optional[str] = None
	form_id: Optional[str] = None
	status: Optional[int] = None
	recipients_type: Optional[str] = None
	recipients: set[str] = field(default_factory=set)
	to_addresses: set[str] = field(default_factory=set)
	received: Optional[int] = None
	sent: Optional[int] = None
	metas: dict[str, str] = field(default_factory=dict)
	read_status: dict[str, 'MessageReadStatus'] = field(default_factory=dict)
	message_attachments: list['MessageAttachment'] = field(default_factory=list)
	transport_guid: Optional[str] = None
	remark: Optional[str] = None
	conversation_guid: Optional[str] = None
	subject: Optional[str] = None
	invoice_ids: set[str] = field(default_factory=set)
	parent_id: Optional[str] = None
	external_ref: Optional[str] = None
	unassigned_results: set[str] = field(default_factory=set)
	assigned_results: dict[str, str] = field(default_factory=dict)
	sender_references: dict[str, str] = field(default_factory=dict)
	secret_foreign_keys: set[str] = field(default_factory=set)
	crypted_foreign_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	delegations: dict[str, list['Delegation']] = field(default_factory=dict)
	encryption_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"fromAddress": self.from_address,
			"fromHealthcarePartyId": self.from_healthcare_party_id,
			"formId": self.form_id,
			"status": self.status,
			"recipientsType": self.recipients_type,
			"recipients": [x0 for x0 in self.recipients],
			"toAddresses": [x0 for x0 in self.to_addresses],
			"received": self.received,
			"sent": self.sent,
			"metas": {k0: v0 for k0, v0 in self.metas.items()},
			"readStatus": {k0: v0.__serialize__() for k0, v0 in self.read_status.items()},
			"messageAttachments": [x0.__serialize__() for x0 in self.message_attachments],
			"transportGuid": self.transport_guid,
			"remark": self.remark,
			"conversationGuid": self.conversation_guid,
			"subject": self.subject,
			"invoiceIds": [x0 for x0 in self.invoice_ids],
			"parentId": self.parent_id,
			"externalRef": self.external_ref,
			"unassignedResults": [x0 for x0 in self.unassigned_results],
			"assignedResults": {k0: v0 for k0, v0 in self.assigned_results.items()},
			"senderReferences": {k0: v0 for k0, v0 in self.sender_references.items()},
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedMessage':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			from_address=deserialized_dict.get("fromAddress"),
			from_healthcare_party_id=deserialized_dict.get("fromHealthcarePartyId"),
			form_id=deserialized_dict.get("formId"),
			status=deserialized_dict.get("status"),
			recipients_type=deserialized_dict.get("recipientsType"),
			recipients={x0 for x0 in deserialized_dict["recipients"]},
			to_addresses={x0 for x0 in deserialized_dict["toAddresses"]},
			received=deserialized_dict.get("received"),
			sent=deserialized_dict.get("sent"),
			metas=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["metas"].items())),
			read_status=dict(map(lambda kv0: (kv0[0], MessageReadStatus._deserialize(kv0[1])), deserialized_dict["readStatus"].items())),
			message_attachments=[MessageAttachment._deserialize(x0) for x0 in deserialized_dict["messageAttachments"]],
			transport_guid=deserialized_dict.get("transportGuid"),
			remark=deserialized_dict.get("remark"),
			conversation_guid=deserialized_dict.get("conversationGuid"),
			subject=deserialized_dict.get("subject"),
			invoice_ids={x0 for x0 in deserialized_dict["invoiceIds"]},
			parent_id=deserialized_dict.get("parentId"),
			external_ref=deserialized_dict.get("externalRef"),
			unassigned_results={x0 for x0 in deserialized_dict["unassignedResults"]},
			assigned_results=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["assignedResults"].items())),
			sender_references=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["senderReferences"].items())),
			secret_foreign_keys={x0 for x0 in deserialized_dict["secretForeignKeys"]},
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

@dataclass
class EncryptedMessage:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	from_address: Optional[str] = None
	from_healthcare_party_id: Optional[str] = None
	form_id: Optional[str] = None
	status: Optional[int] = None
	recipients_type: Optional[str] = None
	recipients: set[str] = field(default_factory=set)
	to_addresses: set[str] = field(default_factory=set)
	received: Optional[int] = None
	sent: Optional[int] = None
	metas: dict[str, str] = field(default_factory=dict)
	read_status: dict[str, 'MessageReadStatus'] = field(default_factory=dict)
	message_attachments: list['MessageAttachment'] = field(default_factory=list)
	transport_guid: Optional[str] = None
	remark: Optional[str] = None
	conversation_guid: Optional[str] = None
	subject: Optional[str] = None
	invoice_ids: set[str] = field(default_factory=set)
	parent_id: Optional[str] = None
	external_ref: Optional[str] = None
	unassigned_results: set[str] = field(default_factory=set)
	assigned_results: dict[str, str] = field(default_factory=dict)
	sender_references: dict[str, str] = field(default_factory=dict)
	secret_foreign_keys: set[str] = field(default_factory=set)
	crypted_foreign_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	delegations: dict[str, list['Delegation']] = field(default_factory=dict)
	encryption_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"fromAddress": self.from_address,
			"fromHealthcarePartyId": self.from_healthcare_party_id,
			"formId": self.form_id,
			"status": self.status,
			"recipientsType": self.recipients_type,
			"recipients": [x0 for x0 in self.recipients],
			"toAddresses": [x0 for x0 in self.to_addresses],
			"received": self.received,
			"sent": self.sent,
			"metas": {k0: v0 for k0, v0 in self.metas.items()},
			"readStatus": {k0: v0.__serialize__() for k0, v0 in self.read_status.items()},
			"messageAttachments": [x0.__serialize__() for x0 in self.message_attachments],
			"transportGuid": self.transport_guid,
			"remark": self.remark,
			"conversationGuid": self.conversation_guid,
			"subject": self.subject,
			"invoiceIds": [x0 for x0 in self.invoice_ids],
			"parentId": self.parent_id,
			"externalRef": self.external_ref,
			"unassignedResults": [x0 for x0 in self.unassigned_results],
			"assignedResults": {k0: v0 for k0, v0 in self.assigned_results.items()},
			"senderReferences": {k0: v0 for k0, v0 in self.sender_references.items()},
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedMessage':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			from_address=deserialized_dict.get("fromAddress"),
			from_healthcare_party_id=deserialized_dict.get("fromHealthcarePartyId"),
			form_id=deserialized_dict.get("formId"),
			status=deserialized_dict.get("status"),
			recipients_type=deserialized_dict.get("recipientsType"),
			recipients={x0 for x0 in deserialized_dict["recipients"]},
			to_addresses={x0 for x0 in deserialized_dict["toAddresses"]},
			received=deserialized_dict.get("received"),
			sent=deserialized_dict.get("sent"),
			metas=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["metas"].items())),
			read_status=dict(map(lambda kv0: (kv0[0], MessageReadStatus._deserialize(kv0[1])), deserialized_dict["readStatus"].items())),
			message_attachments=[MessageAttachment._deserialize(x0) for x0 in deserialized_dict["messageAttachments"]],
			transport_guid=deserialized_dict.get("transportGuid"),
			remark=deserialized_dict.get("remark"),
			conversation_guid=deserialized_dict.get("conversationGuid"),
			subject=deserialized_dict.get("subject"),
			invoice_ids={x0 for x0 in deserialized_dict["invoiceIds"]},
			parent_id=deserialized_dict.get("parentId"),
			external_ref=deserialized_dict.get("externalRef"),
			unassigned_results={x0 for x0 in deserialized_dict["unassignedResults"]},
			assigned_results=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["assignedResults"].items())),
			sender_references=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["senderReferences"].items())),
			secret_foreign_keys={x0 for x0 in deserialized_dict["secretForeignKeys"]},
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

type Message = Union['DecryptedMessage', 'EncryptedMessage']

def serialize_message(message: Message) -> Any:
	if isinstance(message, DecryptedMessage):
		serialized_entity = message.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.DecryptedMessage"})
		return serialized_entity
	elif isinstance(message, EncryptedMessage):
		serialized_entity = message.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.EncryptedMessage"})
		return serialized_entity
	else:
		raise Exception(f"{type(message)} is not a known subclass of Message")

def deserialize_message(data: Union[str, dict[str, JsonElement]]) -> 'Message':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.DecryptedMessage":
		return DecryptedMessage._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.EncryptedMessage":
		return EncryptedMessage._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of Message")

@dataclass
class DocumentShareOptions:
	requested_permissions: 'RequestedPermission' = field(default_factory=lambda: RequestedPermission.MaxWrite)
	share_encryption_key: 'ShareMetadataBehaviour' = field(default_factory=lambda: ShareMetadataBehaviour.IfAvailable)
	share_message_id: 'ShareMetadataBehaviour' = field(default_factory=lambda: ShareMetadataBehaviour.IfAvailable)
	share_secret_ids: 'SecretIdShareOptions' = field(default_factory=lambda: SecretIdShareOptionsAllAvailable())

	def __serialize__(self) -> Any:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"shareMessageId": self.share_message_id.__serialize__(),
			"shareSecretIds": serialize_secret_id_share_options(self.share_secret_ids),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DocumentShareOptions':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions=RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key=ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_message_id=ShareMetadataBehaviour._deserialize(deserialized_dict["shareMessageId"]),
			share_secret_ids=deserialize_secret_id_share_options(deserialized_dict["shareSecretIds"]),
		)

@dataclass
class EntityTemplate:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	user_id: Optional[str] = None
	descr: Optional[str] = None
	keywords: Optional[set[str]] = None
	entity_type: Optional[str] = None
	sub_type: Optional[str] = None
	default_template: Optional[bool] = None
	entity: list[JsonElement] = field(default_factory=list)

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"userId": self.user_id,
			"descr": self.descr,
			"keywords": [x0 for x0 in self.keywords] if self.keywords is not None else None,
			"entityType": self.entity_type,
			"subType": self.sub_type,
			"defaultTemplate": self.default_template,
			"entity": [x0 for x0 in self.entity],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EntityTemplate':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			deletion_date=deserialized_dict.get("deletionDate"),
			user_id=deserialized_dict.get("userId"),
			descr=deserialized_dict.get("descr"),
			keywords={x0 for x0 in deserialized_dict.get("keywords")} if deserialized_dict.get("keywords") is not None else None,
			entity_type=deserialized_dict.get("entityType"),
			sub_type=deserialized_dict.get("subType"),
			default_template=deserialized_dict.get("defaultTemplate"),
			entity=[x0 for x0 in deserialized_dict["entity"]],
		)

@dataclass
class DataOwnerWithTypeHcpDataOwner:
	data_owner: 'HealthcareParty'

	def __serialize__(self) -> Any:
		return {
			"dataOwner": self.data_owner.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DataOwnerWithTypeHcpDataOwner':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			data_owner=HealthcareParty._deserialize(deserialized_dict["dataOwner"]),
		)

@dataclass
class DataOwnerWithTypePatientDataOwner:
	data_owner: 'EncryptedPatient'

	def __serialize__(self) -> Any:
		return {
			"dataOwner": self.data_owner.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DataOwnerWithTypePatientDataOwner':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			data_owner=EncryptedPatient._deserialize(deserialized_dict["dataOwner"]),
		)

@dataclass
class DataOwnerWithTypeDeviceDataOwner:
	data_owner: 'Device'

	def __serialize__(self) -> Any:
		return {
			"dataOwner": self.data_owner.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DataOwnerWithTypeDeviceDataOwner':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			data_owner=Device._deserialize(deserialized_dict["dataOwner"]),
		)

type DataOwnerWithType = Union['DataOwnerWithTypeHcpDataOwner', 'DataOwnerWithTypePatientDataOwner', 'DataOwnerWithTypeDeviceDataOwner']

def serialize_data_owner_with_type(data_owner_with_type: DataOwnerWithType) -> Any:
	if isinstance(data_owner_with_type, DataOwnerWithTypeHcpDataOwner):
		serialized_entity = data_owner_with_type.__serialize__()
		serialized_entity.update({"kotlinType": "hcp"})
		return serialized_entity
	elif isinstance(data_owner_with_type, DataOwnerWithTypePatientDataOwner):
		serialized_entity = data_owner_with_type.__serialize__()
		serialized_entity.update({"kotlinType": "patient"})
		return serialized_entity
	elif isinstance(data_owner_with_type, DataOwnerWithTypeDeviceDataOwner):
		serialized_entity = data_owner_with_type.__serialize__()
		serialized_entity.update({"kotlinType": "device"})
		return serialized_entity
	else:
		raise Exception(f"{type(data_owner_with_type)} is not a known subclass of DataOwnerWithType")

def deserialize_data_owner_with_type(data: Union[str, dict[str, JsonElement]]) -> 'DataOwnerWithType':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "hcp":
		return DataOwnerWithTypeHcpDataOwner._deserialize(deserialized_dict)
	elif qualifier == "patient":
		return DataOwnerWithTypePatientDataOwner._deserialize(deserialized_dict)
	elif qualifier == "device":
		return DataOwnerWithTypeDeviceDataOwner._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of DataOwnerWithType")

class DataOwnerType(Enum):
	Hcp = "hcp"
	Device = "device"
	Patient = "patient"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DataOwnerType':
		if data == "hcp":
			return DataOwnerType.Hcp
		elif data == "device":
			return DataOwnerType.Device
		elif data == "patient":
			return DataOwnerType.Patient
		else:
			raise Exception(f"{data} is not a valid value for DataOwnerType enum.")

@dataclass
class EncryptedPropertyStub:
	id: Optional[str] = None
	type: Optional['PropertyTypeStub'] = None
	typed_value: Optional['EncryptedTypedValue'] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"type": self.type.__serialize__() if self.type is not None else None,
			"typedValue": self.typed_value.__serialize__() if self.typed_value is not None else None,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedPropertyStub':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict.get("id"),
			type=PropertyTypeStub._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
			typed_value=EncryptedTypedValue._deserialize(deserialized_dict.get("typedValue")) if deserialized_dict.get("typedValue") is not None else None,
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class DecryptedPropertyStub:
	id: Optional[str] = None
	type: Optional['PropertyTypeStub'] = None
	typed_value: Optional['DecryptedTypedValue'] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"type": self.type.__serialize__() if self.type is not None else None,
			"typedValue": self.typed_value.__serialize__() if self.typed_value is not None else None,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedPropertyStub':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict.get("id"),
			type=PropertyTypeStub._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
			typed_value=DecryptedTypedValue._deserialize(deserialized_dict.get("typedValue")) if deserialized_dict.get("typedValue") is not None else None,
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

type PropertyStub = Union['EncryptedPropertyStub', 'DecryptedPropertyStub']

def serialize_property_stub(property_stub: PropertyStub) -> Any:
	if isinstance(property_stub, EncryptedPropertyStub):
		serialized_entity = property_stub.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.EncryptedPropertyStub"})
		return serialized_entity
	elif isinstance(property_stub, DecryptedPropertyStub):
		serialized_entity = property_stub.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.DecryptedPropertyStub"})
		return serialized_entity
	else:
		raise Exception(f"{type(property_stub)} is not a known subclass of PropertyStub")

def deserialize_property_stub(data: Union[str, dict[str, JsonElement]]) -> 'PropertyStub':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.EncryptedPropertyStub":
		return EncryptedPropertyStub._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.DecryptedPropertyStub":
		return DecryptedPropertyStub._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of PropertyStub")

@dataclass
class UserGroup:
	group_id: Optional[str] = None
	group_name: Optional[str] = None
	groups_hierarchy: list['Group'] = field(default_factory=list)
	user_id: Optional[str] = None
	login: Optional[str] = None
	name: Optional[str] = None
	email: Optional[str] = None
	phone: Optional[str] = None
	patient_id: Optional[str] = None
	healthcare_party_id: Optional[str] = None
	device_id: Optional[str] = None
	name_of_parent_of_topmost_group_in_hierarchy: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"groupId": self.group_id,
			"groupName": self.group_name,
			"groupsHierarchy": [x0.__serialize__() for x0 in self.groups_hierarchy],
			"userId": self.user_id,
			"login": self.login,
			"name": self.name,
			"email": self.email,
			"phone": self.phone,
			"patientId": self.patient_id,
			"healthcarePartyId": self.healthcare_party_id,
			"deviceId": self.device_id,
			"nameOfParentOfTopmostGroupInHierarchy": self.name_of_parent_of_topmost_group_in_hierarchy,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'UserGroup':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			group_id=deserialized_dict.get("groupId"),
			group_name=deserialized_dict.get("groupName"),
			groups_hierarchy=[Group._deserialize(x0) for x0 in deserialized_dict["groupsHierarchy"]],
			user_id=deserialized_dict.get("userId"),
			login=deserialized_dict.get("login"),
			name=deserialized_dict.get("name"),
			email=deserialized_dict.get("email"),
			phone=deserialized_dict.get("phone"),
			patient_id=deserialized_dict.get("patientId"),
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			device_id=deserialized_dict.get("deviceId"),
			name_of_parent_of_topmost_group_in_hierarchy=deserialized_dict.get("nameOfParentOfTopmostGroupInHierarchy"),
		)

@dataclass
class TokenWithGroup:
	token: str
	group_id: str
	group_name: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"token": self.token,
			"groupId": self.group_id,
			"groupName": self.group_name,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'TokenWithGroup':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			token=deserialized_dict["token"],
			group_id=deserialized_dict["groupId"],
			group_name=deserialized_dict.get("groupName"),
		)

@dataclass
class Enable2faRequest:
	secret: str
	otp_length: int

	def __serialize__(self) -> Any:
		return {
			"secret": self.secret,
			"otpLength": self.otp_length,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Enable2faRequest':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			secret=deserialized_dict["secret"],
			otp_length=deserialized_dict["otpLength"],
		)

@dataclass
class LoginIdentifier:
	assigner: str
	value: str

	def __serialize__(self) -> Any:
		return {
			"assigner": self.assigner,
			"value": self.value,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'LoginIdentifier':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			assigner=deserialized_dict["assigner"],
			value=deserialized_dict["value"],
		)

@dataclass
class Role:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	name: Optional[str] = None
	permissions: set[str] = field(default_factory=set)

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"name": self.name,
			"permissions": [x0 for x0 in self.permissions],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Role':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			deletion_date=deserialized_dict.get("deletionDate"),
			name=deserialized_dict.get("name"),
			permissions={x0 for x0 in deserialized_dict["permissions"]},
		)

@dataclass
class FormShareOptions:
	requested_permissions: 'RequestedPermission' = field(default_factory=lambda: RequestedPermission.MaxWrite)
	share_encryption_key: 'ShareMetadataBehaviour' = field(default_factory=lambda: ShareMetadataBehaviour.IfAvailable)
	share_patient_id: 'ShareMetadataBehaviour' = field(default_factory=lambda: ShareMetadataBehaviour.IfAvailable)
	share_secret_ids: 'SecretIdShareOptions' = field(default_factory=lambda: SecretIdShareOptionsAllAvailable())

	def __serialize__(self) -> Any:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"sharePatientId": self.share_patient_id.__serialize__(),
			"shareSecretIds": serialize_secret_id_share_options(self.share_secret_ids),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'FormShareOptions':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions=RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key=ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_patient_id=ShareMetadataBehaviour._deserialize(deserialized_dict["sharePatientId"]),
			share_secret_ids=deserialize_secret_id_share_options(deserialized_dict["shareSecretIds"]),
		)

@dataclass
class DecryptedInvoice:
	id: str
	rev: Optional[str] = None
	identifier: list['Identifier'] = field(default_factory=list)
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	invoice_date: Optional[int] = None
	sent_date: Optional[int] = None
	printed_date: Optional[int] = None
	invoicing_codes: list['DecryptedInvoicingCode'] = field(default_factory=list)
	receipts: dict[str, str] = field(default_factory=dict)
	recipient_type: Optional[str] = None
	recipient_id: Optional[str] = None
	invoice_reference: Optional[str] = None
	decision_reference: Optional[str] = None
	third_party_reference: Optional[str] = None
	third_party_payment_justification: Optional[str] = None
	third_party_payment_reason: Optional[str] = None
	reason: Optional[str] = None
	invoice_type: Optional['InvoiceType'] = None
	sent_medium_type: Optional['MediumType'] = None
	intervention_type: Optional['InvoiceInterventionType'] = None
	group_id: Optional[str] = None
	payment_type: Optional['PaymentType'] = None
	paid: Optional[float] = None
	payments: Optional[list['Payment']] = None
	gnotion_nihii: Optional[str] = None
	gnotion_ssin: Optional[str] = None
	gnotion_last_name: Optional[str] = None
	gnotion_first_name: Optional[str] = None
	gnotion_cd_hc_party: Optional[str] = None
	invoice_period: Optional[int] = None
	care_provider_type: Optional[str] = None
	internship_nihii: Optional[str] = None
	internship_ssin: Optional[str] = None
	internship_last_name: Optional[str] = None
	internship_first_name: Optional[str] = None
	internship_cd_hc_party: Optional[str] = None
	internship_cbe: Optional[str] = None
	supervisor_nihii: Optional[str] = None
	supervisor_ssin: Optional[str] = None
	supervisor_last_name: Optional[str] = None
	supervisor_first_name: Optional[str] = None
	supervisor_cd_hc_party: Optional[str] = None
	supervisor_cbe: Optional[str] = None
	error: Optional[str] = None
	encounter_location_name: Optional[str] = None
	encounter_location_nihii: Optional[str] = None
	encounter_location_norm: Optional[int] = None
	long_delay_justification: Optional[int] = None
	corrective_invoice_id: Optional[str] = None
	corrected_invoice_id: Optional[str] = None
	credit_note: Optional[bool] = None
	credit_note_related_invoice_id: Optional[str] = None
	id_document: Optional['IdentityDocumentReader'] = None
	admission_date: Optional[int] = None
	location_nihii: Optional[str] = None
	location_service: Optional[int] = None
	cancel_reason: Optional[str] = None
	cancel_date: Optional[int] = None
	options: dict[str, str] = field(default_factory=dict)
	secret_foreign_keys: set[str] = field(default_factory=set)
	crypted_foreign_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	delegations: dict[str, list['Delegation']] = field(default_factory=dict)
	encryption_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"identifier": [x0.__serialize__() for x0 in self.identifier],
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"invoiceDate": self.invoice_date,
			"sentDate": self.sent_date,
			"printedDate": self.printed_date,
			"invoicingCodes": [x0.__serialize__() for x0 in self.invoicing_codes],
			"receipts": {k0: v0 for k0, v0 in self.receipts.items()},
			"recipientType": self.recipient_type,
			"recipientId": self.recipient_id,
			"invoiceReference": self.invoice_reference,
			"decisionReference": self.decision_reference,
			"thirdPartyReference": self.third_party_reference,
			"thirdPartyPaymentJustification": self.third_party_payment_justification,
			"thirdPartyPaymentReason": self.third_party_payment_reason,
			"reason": self.reason,
			"invoiceType": self.invoice_type.__serialize__() if self.invoice_type is not None else None,
			"sentMediumType": self.sent_medium_type.__serialize__() if self.sent_medium_type is not None else None,
			"interventionType": self.intervention_type.__serialize__() if self.intervention_type is not None else None,
			"groupId": self.group_id,
			"paymentType": self.payment_type.__serialize__() if self.payment_type is not None else None,
			"paid": self.paid,
			"payments": [x0.__serialize__() for x0 in self.payments] if self.payments is not None else None,
			"gnotionNihii": self.gnotion_nihii,
			"gnotionSsin": self.gnotion_ssin,
			"gnotionLastName": self.gnotion_last_name,
			"gnotionFirstName": self.gnotion_first_name,
			"gnotionCdHcParty": self.gnotion_cd_hc_party,
			"invoicePeriod": self.invoice_period,
			"careProviderType": self.care_provider_type,
			"internshipNihii": self.internship_nihii,
			"internshipSsin": self.internship_ssin,
			"internshipLastName": self.internship_last_name,
			"internshipFirstName": self.internship_first_name,
			"internshipCdHcParty": self.internship_cd_hc_party,
			"internshipCbe": self.internship_cbe,
			"supervisorNihii": self.supervisor_nihii,
			"supervisorSsin": self.supervisor_ssin,
			"supervisorLastName": self.supervisor_last_name,
			"supervisorFirstName": self.supervisor_first_name,
			"supervisorCdHcParty": self.supervisor_cd_hc_party,
			"supervisorCbe": self.supervisor_cbe,
			"error": self.error,
			"encounterLocationName": self.encounter_location_name,
			"encounterLocationNihii": self.encounter_location_nihii,
			"encounterLocationNorm": self.encounter_location_norm,
			"longDelayJustification": self.long_delay_justification,
			"correctiveInvoiceId": self.corrective_invoice_id,
			"correctedInvoiceId": self.corrected_invoice_id,
			"creditNote": self.credit_note,
			"creditNoteRelatedInvoiceId": self.credit_note_related_invoice_id,
			"idDocument": self.id_document.__serialize__() if self.id_document is not None else None,
			"admissionDate": self.admission_date,
			"locationNihii": self.location_nihii,
			"locationService": self.location_service,
			"cancelReason": self.cancel_reason,
			"cancelDate": self.cancel_date,
			"options": {k0: v0 for k0, v0 in self.options.items()},
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedInvoice':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			identifier=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			invoice_date=deserialized_dict.get("invoiceDate"),
			sent_date=deserialized_dict.get("sentDate"),
			printed_date=deserialized_dict.get("printedDate"),
			invoicing_codes=[DecryptedInvoicingCode._deserialize(x0) for x0 in deserialized_dict["invoicingCodes"]],
			receipts=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["receipts"].items())),
			recipient_type=deserialized_dict.get("recipientType"),
			recipient_id=deserialized_dict.get("recipientId"),
			invoice_reference=deserialized_dict.get("invoiceReference"),
			decision_reference=deserialized_dict.get("decisionReference"),
			third_party_reference=deserialized_dict.get("thirdPartyReference"),
			third_party_payment_justification=deserialized_dict.get("thirdPartyPaymentJustification"),
			third_party_payment_reason=deserialized_dict.get("thirdPartyPaymentReason"),
			reason=deserialized_dict.get("reason"),
			invoice_type=InvoiceType._deserialize(deserialized_dict.get("invoiceType")) if deserialized_dict.get("invoiceType") is not None else None,
			sent_medium_type=MediumType._deserialize(deserialized_dict.get("sentMediumType")) if deserialized_dict.get("sentMediumType") is not None else None,
			intervention_type=InvoiceInterventionType._deserialize(deserialized_dict.get("interventionType")) if deserialized_dict.get("interventionType") is not None else None,
			group_id=deserialized_dict.get("groupId"),
			payment_type=PaymentType._deserialize(deserialized_dict.get("paymentType")) if deserialized_dict.get("paymentType") is not None else None,
			paid=deserialized_dict.get("paid"),
			payments=[Payment._deserialize(x0) for x0 in deserialized_dict.get("payments")] if deserialized_dict.get("payments") is not None else None,
			gnotion_nihii=deserialized_dict.get("gnotionNihii"),
			gnotion_ssin=deserialized_dict.get("gnotionSsin"),
			gnotion_last_name=deserialized_dict.get("gnotionLastName"),
			gnotion_first_name=deserialized_dict.get("gnotionFirstName"),
			gnotion_cd_hc_party=deserialized_dict.get("gnotionCdHcParty"),
			invoice_period=deserialized_dict.get("invoicePeriod"),
			care_provider_type=deserialized_dict.get("careProviderType"),
			internship_nihii=deserialized_dict.get("internshipNihii"),
			internship_ssin=deserialized_dict.get("internshipSsin"),
			internship_last_name=deserialized_dict.get("internshipLastName"),
			internship_first_name=deserialized_dict.get("internshipFirstName"),
			internship_cd_hc_party=deserialized_dict.get("internshipCdHcParty"),
			internship_cbe=deserialized_dict.get("internshipCbe"),
			supervisor_nihii=deserialized_dict.get("supervisorNihii"),
			supervisor_ssin=deserialized_dict.get("supervisorSsin"),
			supervisor_last_name=deserialized_dict.get("supervisorLastName"),
			supervisor_first_name=deserialized_dict.get("supervisorFirstName"),
			supervisor_cd_hc_party=deserialized_dict.get("supervisorCdHcParty"),
			supervisor_cbe=deserialized_dict.get("supervisorCbe"),
			error=deserialized_dict.get("error"),
			encounter_location_name=deserialized_dict.get("encounterLocationName"),
			encounter_location_nihii=deserialized_dict.get("encounterLocationNihii"),
			encounter_location_norm=deserialized_dict.get("encounterLocationNorm"),
			long_delay_justification=deserialized_dict.get("longDelayJustification"),
			corrective_invoice_id=deserialized_dict.get("correctiveInvoiceId"),
			corrected_invoice_id=deserialized_dict.get("correctedInvoiceId"),
			credit_note=deserialized_dict.get("creditNote"),
			credit_note_related_invoice_id=deserialized_dict.get("creditNoteRelatedInvoiceId"),
			id_document=IdentityDocumentReader._deserialize(deserialized_dict.get("idDocument")) if deserialized_dict.get("idDocument") is not None else None,
			admission_date=deserialized_dict.get("admissionDate"),
			location_nihii=deserialized_dict.get("locationNihii"),
			location_service=deserialized_dict.get("locationService"),
			cancel_reason=deserialized_dict.get("cancelReason"),
			cancel_date=deserialized_dict.get("cancelDate"),
			options=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["options"].items())),
			secret_foreign_keys={x0 for x0 in deserialized_dict["secretForeignKeys"]},
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

@dataclass
class EncryptedInvoice:
	id: str
	rev: Optional[str] = None
	identifier: list['Identifier'] = field(default_factory=list)
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	invoice_date: Optional[int] = None
	sent_date: Optional[int] = None
	printed_date: Optional[int] = None
	invoicing_codes: list['EncryptedInvoicingCode'] = field(default_factory=list)
	receipts: dict[str, str] = field(default_factory=dict)
	recipient_type: Optional[str] = None
	recipient_id: Optional[str] = None
	invoice_reference: Optional[str] = None
	decision_reference: Optional[str] = None
	third_party_reference: Optional[str] = None
	third_party_payment_justification: Optional[str] = None
	third_party_payment_reason: Optional[str] = None
	reason: Optional[str] = None
	invoice_type: Optional['InvoiceType'] = None
	sent_medium_type: Optional['MediumType'] = None
	intervention_type: Optional['InvoiceInterventionType'] = None
	group_id: Optional[str] = None
	payment_type: Optional['PaymentType'] = None
	paid: Optional[float] = None
	payments: Optional[list['Payment']] = None
	gnotion_nihii: Optional[str] = None
	gnotion_ssin: Optional[str] = None
	gnotion_last_name: Optional[str] = None
	gnotion_first_name: Optional[str] = None
	gnotion_cd_hc_party: Optional[str] = None
	invoice_period: Optional[int] = None
	care_provider_type: Optional[str] = None
	internship_nihii: Optional[str] = None
	internship_ssin: Optional[str] = None
	internship_last_name: Optional[str] = None
	internship_first_name: Optional[str] = None
	internship_cd_hc_party: Optional[str] = None
	internship_cbe: Optional[str] = None
	supervisor_nihii: Optional[str] = None
	supervisor_ssin: Optional[str] = None
	supervisor_last_name: Optional[str] = None
	supervisor_first_name: Optional[str] = None
	supervisor_cd_hc_party: Optional[str] = None
	supervisor_cbe: Optional[str] = None
	error: Optional[str] = None
	encounter_location_name: Optional[str] = None
	encounter_location_nihii: Optional[str] = None
	encounter_location_norm: Optional[int] = None
	long_delay_justification: Optional[int] = None
	corrective_invoice_id: Optional[str] = None
	corrected_invoice_id: Optional[str] = None
	credit_note: Optional[bool] = None
	credit_note_related_invoice_id: Optional[str] = None
	id_document: Optional['IdentityDocumentReader'] = None
	admission_date: Optional[int] = None
	location_nihii: Optional[str] = None
	location_service: Optional[int] = None
	cancel_reason: Optional[str] = None
	cancel_date: Optional[int] = None
	options: dict[str, str] = field(default_factory=dict)
	secret_foreign_keys: set[str] = field(default_factory=set)
	crypted_foreign_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	delegations: dict[str, list['Delegation']] = field(default_factory=dict)
	encryption_keys: dict[str, list['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"identifier": [x0.__serialize__() for x0 in self.identifier],
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"invoiceDate": self.invoice_date,
			"sentDate": self.sent_date,
			"printedDate": self.printed_date,
			"invoicingCodes": [x0.__serialize__() for x0 in self.invoicing_codes],
			"receipts": {k0: v0 for k0, v0 in self.receipts.items()},
			"recipientType": self.recipient_type,
			"recipientId": self.recipient_id,
			"invoiceReference": self.invoice_reference,
			"decisionReference": self.decision_reference,
			"thirdPartyReference": self.third_party_reference,
			"thirdPartyPaymentJustification": self.third_party_payment_justification,
			"thirdPartyPaymentReason": self.third_party_payment_reason,
			"reason": self.reason,
			"invoiceType": self.invoice_type.__serialize__() if self.invoice_type is not None else None,
			"sentMediumType": self.sent_medium_type.__serialize__() if self.sent_medium_type is not None else None,
			"interventionType": self.intervention_type.__serialize__() if self.intervention_type is not None else None,
			"groupId": self.group_id,
			"paymentType": self.payment_type.__serialize__() if self.payment_type is not None else None,
			"paid": self.paid,
			"payments": [x0.__serialize__() for x0 in self.payments] if self.payments is not None else None,
			"gnotionNihii": self.gnotion_nihii,
			"gnotionSsin": self.gnotion_ssin,
			"gnotionLastName": self.gnotion_last_name,
			"gnotionFirstName": self.gnotion_first_name,
			"gnotionCdHcParty": self.gnotion_cd_hc_party,
			"invoicePeriod": self.invoice_period,
			"careProviderType": self.care_provider_type,
			"internshipNihii": self.internship_nihii,
			"internshipSsin": self.internship_ssin,
			"internshipLastName": self.internship_last_name,
			"internshipFirstName": self.internship_first_name,
			"internshipCdHcParty": self.internship_cd_hc_party,
			"internshipCbe": self.internship_cbe,
			"supervisorNihii": self.supervisor_nihii,
			"supervisorSsin": self.supervisor_ssin,
			"supervisorLastName": self.supervisor_last_name,
			"supervisorFirstName": self.supervisor_first_name,
			"supervisorCdHcParty": self.supervisor_cd_hc_party,
			"supervisorCbe": self.supervisor_cbe,
			"error": self.error,
			"encounterLocationName": self.encounter_location_name,
			"encounterLocationNihii": self.encounter_location_nihii,
			"encounterLocationNorm": self.encounter_location_norm,
			"longDelayJustification": self.long_delay_justification,
			"correctiveInvoiceId": self.corrective_invoice_id,
			"correctedInvoiceId": self.corrected_invoice_id,
			"creditNote": self.credit_note,
			"creditNoteRelatedInvoiceId": self.credit_note_related_invoice_id,
			"idDocument": self.id_document.__serialize__() if self.id_document is not None else None,
			"admissionDate": self.admission_date,
			"locationNihii": self.location_nihii,
			"locationService": self.location_service,
			"cancelReason": self.cancel_reason,
			"cancelDate": self.cancel_date,
			"options": {k0: v0 for k0, v0 in self.options.items()},
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedInvoice':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			identifier=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			invoice_date=deserialized_dict.get("invoiceDate"),
			sent_date=deserialized_dict.get("sentDate"),
			printed_date=deserialized_dict.get("printedDate"),
			invoicing_codes=[EncryptedInvoicingCode._deserialize(x0) for x0 in deserialized_dict["invoicingCodes"]],
			receipts=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["receipts"].items())),
			recipient_type=deserialized_dict.get("recipientType"),
			recipient_id=deserialized_dict.get("recipientId"),
			invoice_reference=deserialized_dict.get("invoiceReference"),
			decision_reference=deserialized_dict.get("decisionReference"),
			third_party_reference=deserialized_dict.get("thirdPartyReference"),
			third_party_payment_justification=deserialized_dict.get("thirdPartyPaymentJustification"),
			third_party_payment_reason=deserialized_dict.get("thirdPartyPaymentReason"),
			reason=deserialized_dict.get("reason"),
			invoice_type=InvoiceType._deserialize(deserialized_dict.get("invoiceType")) if deserialized_dict.get("invoiceType") is not None else None,
			sent_medium_type=MediumType._deserialize(deserialized_dict.get("sentMediumType")) if deserialized_dict.get("sentMediumType") is not None else None,
			intervention_type=InvoiceInterventionType._deserialize(deserialized_dict.get("interventionType")) if deserialized_dict.get("interventionType") is not None else None,
			group_id=deserialized_dict.get("groupId"),
			payment_type=PaymentType._deserialize(deserialized_dict.get("paymentType")) if deserialized_dict.get("paymentType") is not None else None,
			paid=deserialized_dict.get("paid"),
			payments=[Payment._deserialize(x0) for x0 in deserialized_dict.get("payments")] if deserialized_dict.get("payments") is not None else None,
			gnotion_nihii=deserialized_dict.get("gnotionNihii"),
			gnotion_ssin=deserialized_dict.get("gnotionSsin"),
			gnotion_last_name=deserialized_dict.get("gnotionLastName"),
			gnotion_first_name=deserialized_dict.get("gnotionFirstName"),
			gnotion_cd_hc_party=deserialized_dict.get("gnotionCdHcParty"),
			invoice_period=deserialized_dict.get("invoicePeriod"),
			care_provider_type=deserialized_dict.get("careProviderType"),
			internship_nihii=deserialized_dict.get("internshipNihii"),
			internship_ssin=deserialized_dict.get("internshipSsin"),
			internship_last_name=deserialized_dict.get("internshipLastName"),
			internship_first_name=deserialized_dict.get("internshipFirstName"),
			internship_cd_hc_party=deserialized_dict.get("internshipCdHcParty"),
			internship_cbe=deserialized_dict.get("internshipCbe"),
			supervisor_nihii=deserialized_dict.get("supervisorNihii"),
			supervisor_ssin=deserialized_dict.get("supervisorSsin"),
			supervisor_last_name=deserialized_dict.get("supervisorLastName"),
			supervisor_first_name=deserialized_dict.get("supervisorFirstName"),
			supervisor_cd_hc_party=deserialized_dict.get("supervisorCdHcParty"),
			supervisor_cbe=deserialized_dict.get("supervisorCbe"),
			error=deserialized_dict.get("error"),
			encounter_location_name=deserialized_dict.get("encounterLocationName"),
			encounter_location_nihii=deserialized_dict.get("encounterLocationNihii"),
			encounter_location_norm=deserialized_dict.get("encounterLocationNorm"),
			long_delay_justification=deserialized_dict.get("longDelayJustification"),
			corrective_invoice_id=deserialized_dict.get("correctiveInvoiceId"),
			corrected_invoice_id=deserialized_dict.get("correctedInvoiceId"),
			credit_note=deserialized_dict.get("creditNote"),
			credit_note_related_invoice_id=deserialized_dict.get("creditNoteRelatedInvoiceId"),
			id_document=IdentityDocumentReader._deserialize(deserialized_dict.get("idDocument")) if deserialized_dict.get("idDocument") is not None else None,
			admission_date=deserialized_dict.get("admissionDate"),
			location_nihii=deserialized_dict.get("locationNihii"),
			location_service=deserialized_dict.get("locationService"),
			cancel_reason=deserialized_dict.get("cancelReason"),
			cancel_date=deserialized_dict.get("cancelDate"),
			options=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["options"].items())),
			secret_foreign_keys={x0 for x0 in deserialized_dict["secretForeignKeys"]},
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

type Invoice = Union['DecryptedInvoice', 'EncryptedInvoice']

def serialize_invoice(invoice: Invoice) -> Any:
	if isinstance(invoice, DecryptedInvoice):
		serialized_entity = invoice.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.DecryptedInvoice"})
		return serialized_entity
	elif isinstance(invoice, EncryptedInvoice):
		serialized_entity = invoice.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.EncryptedInvoice"})
		return serialized_entity
	else:
		raise Exception(f"{type(invoice)} is not a known subclass of Invoice")

def deserialize_invoice(data: Union[str, dict[str, JsonElement]]) -> 'Invoice':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.DecryptedInvoice":
		return DecryptedInvoice._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.EncryptedInvoice":
		return EncryptedInvoice._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of Invoice")

@dataclass
class InvoiceShareOptions:
	requested_permissions: 'RequestedPermission' = field(default_factory=lambda: RequestedPermission.MaxWrite)
	share_encryption_key: 'ShareMetadataBehaviour' = field(default_factory=lambda: ShareMetadataBehaviour.IfAvailable)
	share_patient_id: 'ShareMetadataBehaviour' = field(default_factory=lambda: ShareMetadataBehaviour.IfAvailable)
	share_secret_ids: 'SecretIdShareOptions' = field(default_factory=lambda: SecretIdShareOptionsAllAvailable())

	def __serialize__(self) -> Any:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"sharePatientId": self.share_patient_id.__serialize__(),
			"shareSecretIds": serialize_secret_id_share_options(self.share_secret_ids),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'InvoiceShareOptions':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions=RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key=ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_patient_id=ShareMetadataBehaviour._deserialize(deserialized_dict["sharePatientId"]),
			share_secret_ids=deserialize_secret_id_share_options(deserialized_dict["shareSecretIds"]),
		)

@dataclass
class DecryptedInvoicingCode:
	id: Optional[str]
	date_code: Optional[int] = None
	logical_id: Optional[str] = None
	label: Optional[str] = None
	user_id: Optional[str] = None
	contact_id: Optional[str] = None
	service_id: Optional[str] = None
	tarification_id: Optional[str] = None
	code: Optional[str] = None
	payment_type: Optional['PaymentType'] = None
	paid: Optional[float] = None
	total_amount: Optional[float] = None
	reimbursement: Optional[float] = None
	patient_intervention: Optional[float] = None
	ami_intervention: Optional[float] = None
	doctor_supplement: Optional[float] = None
	convention_amount: Optional[float] = None
	vat: Optional[float] = None
	error: Optional[str] = None
	contract: Optional[str] = None
	contract_date: Optional[int] = None
	units: Optional[int] = None
	side: Optional[int] = None
	time_of_day: Optional[int] = None
	eid_reading_hour: Optional[int] = None
	eid_reading_value: Optional[str] = None
	override3rd_payer_code: Optional[int] = None
	override3rd_payer_reason: Optional[str] = None
	transplantation_code: Optional[int] = None
	prescriber_norm: Optional[int] = None
	product_label: Optional[str] = None
	percent_norm: Optional[int] = None
	prescriber_nihii: Optional[str] = None
	related_code: Optional[str] = None
	prescription_date: Optional[int] = None
	derogation_max_number: Optional[int] = None
	prescriber_ssin: Optional[str] = None
	prescriber_last_name: Optional[str] = None
	prescriber_first_name: Optional[str] = None
	prescriber_cd_hc_party: Optional[str] = None
	location_nihii: Optional[str] = None
	location_cd_hc_party: Optional[str] = None
	location_service: Optional[int] = None
	admission_date: Optional[int] = None
	canceled: Optional[bool] = None
	accepted: Optional[bool] = None
	pending: Optional[bool] = None
	resent: Optional[bool] = None
	archived: Optional[bool] = None
	lost: Optional[bool] = None
	insurance_justification: Optional[int] = None
	cancel_patient_intervention_reason: Optional[int] = None
	status: Optional[int] = None
	code_label: Optional[str] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"dateCode": self.date_code,
			"logicalId": self.logical_id,
			"label": self.label,
			"userId": self.user_id,
			"contactId": self.contact_id,
			"serviceId": self.service_id,
			"tarificationId": self.tarification_id,
			"code": self.code,
			"paymentType": self.payment_type.__serialize__() if self.payment_type is not None else None,
			"paid": self.paid,
			"totalAmount": self.total_amount,
			"reimbursement": self.reimbursement,
			"patientIntervention": self.patient_intervention,
			"amiIntervention": self.ami_intervention,
			"doctorSupplement": self.doctor_supplement,
			"conventionAmount": self.convention_amount,
			"vat": self.vat,
			"error": self.error,
			"contract": self.contract,
			"contractDate": self.contract_date,
			"units": self.units,
			"side": self.side,
			"timeOfDay": self.time_of_day,
			"eidReadingHour": self.eid_reading_hour,
			"eidReadingValue": self.eid_reading_value,
			"override3rdPayerCode": self.override3rd_payer_code,
			"override3rdPayerReason": self.override3rd_payer_reason,
			"transplantationCode": self.transplantation_code,
			"prescriberNorm": self.prescriber_norm,
			"productLabel": self.product_label,
			"percentNorm": self.percent_norm,
			"prescriberNihii": self.prescriber_nihii,
			"relatedCode": self.related_code,
			"prescriptionDate": self.prescription_date,
			"derogationMaxNumber": self.derogation_max_number,
			"prescriberSsin": self.prescriber_ssin,
			"prescriberLastName": self.prescriber_last_name,
			"prescriberFirstName": self.prescriber_first_name,
			"prescriberCdHcParty": self.prescriber_cd_hc_party,
			"locationNihii": self.location_nihii,
			"locationCdHcParty": self.location_cd_hc_party,
			"locationService": self.location_service,
			"admissionDate": self.admission_date,
			"canceled": self.canceled,
			"accepted": self.accepted,
			"pending": self.pending,
			"resent": self.resent,
			"archived": self.archived,
			"lost": self.lost,
			"insuranceJustification": self.insurance_justification,
			"cancelPatientInterventionReason": self.cancel_patient_intervention_reason,
			"status": self.status,
			"codeLabel": self.code_label,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedInvoicingCode':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict.get("id"),
			date_code=deserialized_dict.get("dateCode"),
			logical_id=deserialized_dict.get("logicalId"),
			label=deserialized_dict.get("label"),
			user_id=deserialized_dict.get("userId"),
			contact_id=deserialized_dict.get("contactId"),
			service_id=deserialized_dict.get("serviceId"),
			tarification_id=deserialized_dict.get("tarificationId"),
			code=deserialized_dict.get("code"),
			payment_type=PaymentType._deserialize(deserialized_dict.get("paymentType")) if deserialized_dict.get("paymentType") is not None else None,
			paid=deserialized_dict.get("paid"),
			total_amount=deserialized_dict.get("totalAmount"),
			reimbursement=deserialized_dict.get("reimbursement"),
			patient_intervention=deserialized_dict.get("patientIntervention"),
			ami_intervention=deserialized_dict.get("amiIntervention"),
			doctor_supplement=deserialized_dict.get("doctorSupplement"),
			convention_amount=deserialized_dict.get("conventionAmount"),
			vat=deserialized_dict.get("vat"),
			error=deserialized_dict.get("error"),
			contract=deserialized_dict.get("contract"),
			contract_date=deserialized_dict.get("contractDate"),
			units=deserialized_dict.get("units"),
			side=deserialized_dict.get("side"),
			time_of_day=deserialized_dict.get("timeOfDay"),
			eid_reading_hour=deserialized_dict.get("eidReadingHour"),
			eid_reading_value=deserialized_dict.get("eidReadingValue"),
			override3rd_payer_code=deserialized_dict.get("override3rdPayerCode"),
			override3rd_payer_reason=deserialized_dict.get("override3rdPayerReason"),
			transplantation_code=deserialized_dict.get("transplantationCode"),
			prescriber_norm=deserialized_dict.get("prescriberNorm"),
			product_label=deserialized_dict.get("productLabel"),
			percent_norm=deserialized_dict.get("percentNorm"),
			prescriber_nihii=deserialized_dict.get("prescriberNihii"),
			related_code=deserialized_dict.get("relatedCode"),
			prescription_date=deserialized_dict.get("prescriptionDate"),
			derogation_max_number=deserialized_dict.get("derogationMaxNumber"),
			prescriber_ssin=deserialized_dict.get("prescriberSsin"),
			prescriber_last_name=deserialized_dict.get("prescriberLastName"),
			prescriber_first_name=deserialized_dict.get("prescriberFirstName"),
			prescriber_cd_hc_party=deserialized_dict.get("prescriberCdHcParty"),
			location_nihii=deserialized_dict.get("locationNihii"),
			location_cd_hc_party=deserialized_dict.get("locationCdHcParty"),
			location_service=deserialized_dict.get("locationService"),
			admission_date=deserialized_dict.get("admissionDate"),
			canceled=deserialized_dict.get("canceled"),
			accepted=deserialized_dict.get("accepted"),
			pending=deserialized_dict.get("pending"),
			resent=deserialized_dict.get("resent"),
			archived=deserialized_dict.get("archived"),
			lost=deserialized_dict.get("lost"),
			insurance_justification=deserialized_dict.get("insuranceJustification"),
			cancel_patient_intervention_reason=deserialized_dict.get("cancelPatientInterventionReason"),
			status=deserialized_dict.get("status"),
			code_label=deserialized_dict.get("codeLabel"),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class EncryptedInvoicingCode:
	id: Optional[str]
	date_code: Optional[int] = None
	logical_id: Optional[str] = None
	label: Optional[str] = None
	user_id: Optional[str] = None
	contact_id: Optional[str] = None
	service_id: Optional[str] = None
	tarification_id: Optional[str] = None
	code: Optional[str] = None
	payment_type: Optional['PaymentType'] = None
	paid: Optional[float] = None
	total_amount: Optional[float] = None
	reimbursement: Optional[float] = None
	patient_intervention: Optional[float] = None
	ami_intervention: Optional[float] = None
	doctor_supplement: Optional[float] = None
	convention_amount: Optional[float] = None
	vat: Optional[float] = None
	error: Optional[str] = None
	contract: Optional[str] = None
	contract_date: Optional[int] = None
	units: Optional[int] = None
	side: Optional[int] = None
	time_of_day: Optional[int] = None
	eid_reading_hour: Optional[int] = None
	eid_reading_value: Optional[str] = None
	override3rd_payer_code: Optional[int] = None
	override3rd_payer_reason: Optional[str] = None
	transplantation_code: Optional[int] = None
	prescriber_norm: Optional[int] = None
	product_label: Optional[str] = None
	percent_norm: Optional[int] = None
	prescriber_nihii: Optional[str] = None
	related_code: Optional[str] = None
	prescription_date: Optional[int] = None
	derogation_max_number: Optional[int] = None
	prescriber_ssin: Optional[str] = None
	prescriber_last_name: Optional[str] = None
	prescriber_first_name: Optional[str] = None
	prescriber_cd_hc_party: Optional[str] = None
	location_nihii: Optional[str] = None
	location_cd_hc_party: Optional[str] = None
	location_service: Optional[int] = None
	admission_date: Optional[int] = None
	canceled: Optional[bool] = None
	accepted: Optional[bool] = None
	pending: Optional[bool] = None
	resent: Optional[bool] = None
	archived: Optional[bool] = None
	lost: Optional[bool] = None
	insurance_justification: Optional[int] = None
	cancel_patient_intervention_reason: Optional[int] = None
	status: Optional[int] = None
	code_label: Optional[str] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"dateCode": self.date_code,
			"logicalId": self.logical_id,
			"label": self.label,
			"userId": self.user_id,
			"contactId": self.contact_id,
			"serviceId": self.service_id,
			"tarificationId": self.tarification_id,
			"code": self.code,
			"paymentType": self.payment_type.__serialize__() if self.payment_type is not None else None,
			"paid": self.paid,
			"totalAmount": self.total_amount,
			"reimbursement": self.reimbursement,
			"patientIntervention": self.patient_intervention,
			"amiIntervention": self.ami_intervention,
			"doctorSupplement": self.doctor_supplement,
			"conventionAmount": self.convention_amount,
			"vat": self.vat,
			"error": self.error,
			"contract": self.contract,
			"contractDate": self.contract_date,
			"units": self.units,
			"side": self.side,
			"timeOfDay": self.time_of_day,
			"eidReadingHour": self.eid_reading_hour,
			"eidReadingValue": self.eid_reading_value,
			"override3rdPayerCode": self.override3rd_payer_code,
			"override3rdPayerReason": self.override3rd_payer_reason,
			"transplantationCode": self.transplantation_code,
			"prescriberNorm": self.prescriber_norm,
			"productLabel": self.product_label,
			"percentNorm": self.percent_norm,
			"prescriberNihii": self.prescriber_nihii,
			"relatedCode": self.related_code,
			"prescriptionDate": self.prescription_date,
			"derogationMaxNumber": self.derogation_max_number,
			"prescriberSsin": self.prescriber_ssin,
			"prescriberLastName": self.prescriber_last_name,
			"prescriberFirstName": self.prescriber_first_name,
			"prescriberCdHcParty": self.prescriber_cd_hc_party,
			"locationNihii": self.location_nihii,
			"locationCdHcParty": self.location_cd_hc_party,
			"locationService": self.location_service,
			"admissionDate": self.admission_date,
			"canceled": self.canceled,
			"accepted": self.accepted,
			"pending": self.pending,
			"resent": self.resent,
			"archived": self.archived,
			"lost": self.lost,
			"insuranceJustification": self.insurance_justification,
			"cancelPatientInterventionReason": self.cancel_patient_intervention_reason,
			"status": self.status,
			"codeLabel": self.code_label,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedInvoicingCode':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict.get("id"),
			date_code=deserialized_dict.get("dateCode"),
			logical_id=deserialized_dict.get("logicalId"),
			label=deserialized_dict.get("label"),
			user_id=deserialized_dict.get("userId"),
			contact_id=deserialized_dict.get("contactId"),
			service_id=deserialized_dict.get("serviceId"),
			tarification_id=deserialized_dict.get("tarificationId"),
			code=deserialized_dict.get("code"),
			payment_type=PaymentType._deserialize(deserialized_dict.get("paymentType")) if deserialized_dict.get("paymentType") is not None else None,
			paid=deserialized_dict.get("paid"),
			total_amount=deserialized_dict.get("totalAmount"),
			reimbursement=deserialized_dict.get("reimbursement"),
			patient_intervention=deserialized_dict.get("patientIntervention"),
			ami_intervention=deserialized_dict.get("amiIntervention"),
			doctor_supplement=deserialized_dict.get("doctorSupplement"),
			convention_amount=deserialized_dict.get("conventionAmount"),
			vat=deserialized_dict.get("vat"),
			error=deserialized_dict.get("error"),
			contract=deserialized_dict.get("contract"),
			contract_date=deserialized_dict.get("contractDate"),
			units=deserialized_dict.get("units"),
			side=deserialized_dict.get("side"),
			time_of_day=deserialized_dict.get("timeOfDay"),
			eid_reading_hour=deserialized_dict.get("eidReadingHour"),
			eid_reading_value=deserialized_dict.get("eidReadingValue"),
			override3rd_payer_code=deserialized_dict.get("override3rdPayerCode"),
			override3rd_payer_reason=deserialized_dict.get("override3rdPayerReason"),
			transplantation_code=deserialized_dict.get("transplantationCode"),
			prescriber_norm=deserialized_dict.get("prescriberNorm"),
			product_label=deserialized_dict.get("productLabel"),
			percent_norm=deserialized_dict.get("percentNorm"),
			prescriber_nihii=deserialized_dict.get("prescriberNihii"),
			related_code=deserialized_dict.get("relatedCode"),
			prescription_date=deserialized_dict.get("prescriptionDate"),
			derogation_max_number=deserialized_dict.get("derogationMaxNumber"),
			prescriber_ssin=deserialized_dict.get("prescriberSsin"),
			prescriber_last_name=deserialized_dict.get("prescriberLastName"),
			prescriber_first_name=deserialized_dict.get("prescriberFirstName"),
			prescriber_cd_hc_party=deserialized_dict.get("prescriberCdHcParty"),
			location_nihii=deserialized_dict.get("locationNihii"),
			location_cd_hc_party=deserialized_dict.get("locationCdHcParty"),
			location_service=deserialized_dict.get("locationService"),
			admission_date=deserialized_dict.get("admissionDate"),
			canceled=deserialized_dict.get("canceled"),
			accepted=deserialized_dict.get("accepted"),
			pending=deserialized_dict.get("pending"),
			resent=deserialized_dict.get("resent"),
			archived=deserialized_dict.get("archived"),
			lost=deserialized_dict.get("lost"),
			insurance_justification=deserialized_dict.get("insuranceJustification"),
			cancel_patient_intervention_reason=deserialized_dict.get("cancelPatientInterventionReason"),
			status=deserialized_dict.get("status"),
			code_label=deserialized_dict.get("codeLabel"),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

type InvoicingCode = Union['DecryptedInvoicingCode', 'EncryptedInvoicingCode']

def serialize_invoicing_code(invoicing_code: InvoicingCode) -> Any:
	if isinstance(invoicing_code, DecryptedInvoicingCode):
		serialized_entity = invoicing_code.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.DecryptedInvoicingCode"})
		return serialized_entity
	elif isinstance(invoicing_code, EncryptedInvoicingCode):
		serialized_entity = invoicing_code.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.EncryptedInvoicingCode"})
		return serialized_entity
	else:
		raise Exception(f"{type(invoicing_code)} is not a known subclass of InvoicingCode")

def deserialize_invoicing_code(data: Union[str, dict[str, JsonElement]]) -> 'InvoicingCode':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.embed.DecryptedInvoicingCode":
		return DecryptedInvoicingCode._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.embed.EncryptedInvoicingCode":
		return EncryptedInvoicingCode._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of InvoicingCode")

class MediumType(Enum):
	Cdrom = "cdrom"
	Eattest = "eattest"
	Efact = "efact"
	Email = "email"
	Mediprima = "mediprima"
	Paper = "paper"
	Stat = "stat"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'MediumType':
		if data == "cdrom":
			return MediumType.Cdrom
		elif data == "eattest":
			return MediumType.Eattest
		elif data == "efact":
			return MediumType.Efact
		elif data == "email":
			return MediumType.Email
		elif data == "mediprima":
			return MediumType.Mediprima
		elif data == "paper":
			return MediumType.Paper
		elif data == "stat":
			return MediumType.Stat
		else:
			raise Exception(f"{data} is not a valid value for MediumType enum.")

class InvoiceType(Enum):
	Patient = "patient"
	Mutualfund = "mutualfund"
	Payingagency = "payingagency"
	Insurance = "insurance"
	Efact = "efact"
	Other = "other"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'InvoiceType':
		if data == "patient":
			return InvoiceType.Patient
		elif data == "mutualfund":
			return InvoiceType.Mutualfund
		elif data == "payingagency":
			return InvoiceType.Payingagency
		elif data == "insurance":
			return InvoiceType.Insurance
		elif data == "efact":
			return InvoiceType.Efact
		elif data == "other":
			return InvoiceType.Other
		else:
			raise Exception(f"{data} is not a valid value for InvoiceType enum.")

@dataclass
class MessageShareOptions:
	requested_permissions: 'RequestedPermission' = field(default_factory=lambda: RequestedPermission.MaxWrite)
	share_encryption_key: 'ShareMetadataBehaviour' = field(default_factory=lambda: ShareMetadataBehaviour.IfAvailable)
	share_patient_id: 'ShareMetadataBehaviour' = field(default_factory=lambda: ShareMetadataBehaviour.IfAvailable)
	share_secret_ids: 'SecretIdShareOptions' = field(default_factory=lambda: SecretIdShareOptionsAllAvailable())

	def __serialize__(self) -> Any:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"sharePatientId": self.share_patient_id.__serialize__(),
			"shareSecretIds": serialize_secret_id_share_options(self.share_secret_ids),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'MessageShareOptions':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions=RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key=ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_patient_id=ShareMetadataBehaviour._deserialize(deserialized_dict["sharePatientId"]),
			share_secret_ids=deserialize_secret_id_share_options(deserialized_dict["shareSecretIds"]),
		)

@dataclass
class HealthElementShareOptions:
	requested_permissions: 'RequestedPermission' = field(default_factory=lambda: RequestedPermission.MaxWrite)
	share_encryption_key: 'ShareMetadataBehaviour' = field(default_factory=lambda: ShareMetadataBehaviour.IfAvailable)
	share_patient_id: 'ShareMetadataBehaviour' = field(default_factory=lambda: ShareMetadataBehaviour.IfAvailable)
	share_secret_ids: 'SecretIdShareOptions' = field(default_factory=lambda: SecretIdShareOptionsAllAvailable())

	def __serialize__(self) -> Any:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"sharePatientId": self.share_patient_id.__serialize__(),
			"shareSecretIds": serialize_secret_id_share_options(self.share_secret_ids),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'HealthElementShareOptions':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions=RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key=ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_patient_id=ShareMetadataBehaviour._deserialize(deserialized_dict["sharePatientId"]),
			share_secret_ids=deserialize_secret_id_share_options(deserialized_dict["shareSecretIds"]),
		)

@dataclass
class CalendarItemType:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	healthcare_party_id: Optional[str] = None
	agenda_id: Optional[str] = None
	default_calendar_item_type: bool = False
	name: Optional[str] = None
	color: Optional[str] = None
	duration: int = 0
	external_ref: Optional[str] = None
	mikrono_id: Optional[str] = None
	doc_ids: set[str] = field(default_factory=set)
	other_infos: dict[str, str] = field(default_factory=dict)
	subject_by_language: dict[str, str] = field(default_factory=dict)

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"healthcarePartyId": self.healthcare_party_id,
			"agendaId": self.agenda_id,
			"defaultCalendarItemType": self.default_calendar_item_type,
			"name": self.name,
			"color": self.color,
			"duration": self.duration,
			"externalRef": self.external_ref,
			"mikronoId": self.mikrono_id,
			"docIds": [x0 for x0 in self.doc_ids],
			"otherInfos": {k0: v0 for k0, v0 in self.other_infos.items()},
			"subjectByLanguage": {k0: v0 for k0, v0 in self.subject_by_language.items()},
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'CalendarItemType':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			deletion_date=deserialized_dict.get("deletionDate"),
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			agenda_id=deserialized_dict.get("agendaId"),
			default_calendar_item_type=deserialized_dict["defaultCalendarItemType"],
			name=deserialized_dict.get("name"),
			color=deserialized_dict.get("color"),
			duration=deserialized_dict["duration"],
			external_ref=deserialized_dict.get("externalRef"),
			mikrono_id=deserialized_dict.get("mikronoId"),
			doc_ids={x0 for x0 in deserialized_dict["docIds"]},
			other_infos=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["otherInfos"].items())),
			subject_by_language=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["subjectByLanguage"].items())),
		)

@dataclass
class Insurance:
	id: str
	address: 'DecryptedAddress'
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	name: dict[str, str] = field(default_factory=dict)
	private_insurance: bool = False
	hospitalisation_insurance: bool = False
	ambulatory_insurance: bool = False
	code: Optional[str] = None
	agreement_number: Optional[str] = None
	parent: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"name": {k0: v0 for k0, v0 in self.name.items()},
			"privateInsurance": self.private_insurance,
			"hospitalisationInsurance": self.hospitalisation_insurance,
			"ambulatoryInsurance": self.ambulatory_insurance,
			"code": self.code,
			"agreementNumber": self.agreement_number,
			"parent": self.parent,
			"address": self.address.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Insurance':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			deletion_date=deserialized_dict.get("deletionDate"),
			name=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["name"].items())),
			private_insurance=deserialized_dict["privateInsurance"],
			hospitalisation_insurance=deserialized_dict["hospitalisationInsurance"],
			ambulatory_insurance=deserialized_dict["ambulatoryInsurance"],
			code=deserialized_dict.get("code"),
			agreement_number=deserialized_dict.get("agreementNumber"),
			parent=deserialized_dict.get("parent"),
			address=DecryptedAddress._deserialize(deserialized_dict["address"]),
		)

@dataclass
class Agenda:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	day_split_hour: Optional[int] = None
	unpublished: bool = False
	name: Optional[str] = None
	user_id: Optional[str] = None
	zone_id: Optional[str] = None
	lock_calendar_items_before_in_minutes: Optional[int] = None
	user_rights: dict[str, 'UserAccessLevel'] = field(default_factory=dict)
	slotting_algorithm: Optional['AgendaSlottingAlgorithm'] = None
	properties: list['DecryptedPropertyStub'] = field(default_factory=list)
	schedules: list['ResourceGroupAllocationSchedule'] = field(default_factory=list)

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"daySplitHour": self.day_split_hour,
			"unpublished": self.unpublished,
			"name": self.name,
			"userId": self.user_id,
			"zoneId": self.zone_id,
			"lockCalendarItemsBeforeInMinutes": self.lock_calendar_items_before_in_minutes,
			"userRights": {k0: v0.__serialize__() for k0, v0 in self.user_rights.items()},
			"slottingAlgorithm": serialize_agenda_slotting_algorithm(self.slotting_algorithm) if self.slotting_algorithm is not None else None,
			"properties": [x0.__serialize__() for x0 in self.properties],
			"schedules": [x0.__serialize__() for x0 in self.schedules],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Agenda':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			day_split_hour=deserialized_dict.get("daySplitHour"),
			unpublished=deserialized_dict["unpublished"],
			name=deserialized_dict.get("name"),
			user_id=deserialized_dict.get("userId"),
			zone_id=deserialized_dict.get("zoneId"),
			lock_calendar_items_before_in_minutes=deserialized_dict.get("lockCalendarItemsBeforeInMinutes"),
			user_rights=dict(map(lambda kv0: (kv0[0], UserAccessLevel._deserialize(kv0[1])), deserialized_dict["userRights"].items())),
			slotting_algorithm=deserialize_agenda_slotting_algorithm(deserialized_dict.get("slottingAlgorithm")) if deserialized_dict.get("slottingAlgorithm") is not None else None,
			properties=[DecryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict["properties"]],
			schedules=[ResourceGroupAllocationSchedule._deserialize(x0) for x0 in deserialized_dict["schedules"]],
		)

@dataclass
class Group:
	id: str
	minimum_authentication_class_for_elevated_privileges: 'AuthenticationClass'
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	tags: set['CodeStub'] = field(default_factory=set)
	public_tags: set['CodeStub'] = field(default_factory=set)
	name: Optional[str] = None
	password: Optional[str] = None
	servers: Optional[list[str]] = None
	super_admin: bool = False
	properties: list['DecryptedPropertyStub'] = field(default_factory=list)
	default_user_roles: dict['UserType', set[str]] = field(default_factory=dict)
	operation_tokens: dict[str, 'OperationToken'] = field(default_factory=dict)
	shared_entities: dict[str, str] = field(default_factory=dict)
	minimum_kraken_version: Optional[str] = None
	external_jwt_config: dict[str, 'ExternalJwtConfig'] = field(default_factory=dict)
	super_group: Optional[str] = None
	application_id: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"publicTags": [x0.__serialize__() for x0 in self.public_tags],
			"name": self.name,
			"password": self.password,
			"servers": [x0 for x0 in self.servers] if self.servers is not None else None,
			"superAdmin": self.super_admin,
			"properties": [x0.__serialize__() for x0 in self.properties],
			"defaultUserRoles": {k0.__serialize__(): [x1 for x1 in v0] for k0, v0 in self.default_user_roles.items()},
			"operationTokens": {k0: v0.__serialize__() for k0, v0 in self.operation_tokens.items()},
			"sharedEntities": {k0: v0 for k0, v0 in self.shared_entities.items()},
			"minimumKrakenVersion": self.minimum_kraken_version,
			"externalJwtConfig": {k0: v0.__serialize__() for k0, v0 in self.external_jwt_config.items()},
			"minimumAuthenticationClassForElevatedPrivileges": self.minimum_authentication_class_for_elevated_privileges.__serialize__(),
			"superGroup": self.super_group,
			"applicationId": self.application_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Group':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			deletion_date=deserialized_dict.get("deletionDate"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			public_tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["publicTags"]},
			name=deserialized_dict.get("name"),
			password=deserialized_dict.get("password"),
			servers=[x0 for x0 in deserialized_dict.get("servers")] if deserialized_dict.get("servers") is not None else None,
			super_admin=deserialized_dict["superAdmin"],
			properties=[DecryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict["properties"]],
			default_user_roles=dict(map(lambda kv0: (UserType._deserialize(kv0[0]), {x1 for x1 in kv0[1]}), deserialized_dict["defaultUserRoles"].items())),
			operation_tokens=dict(map(lambda kv0: (kv0[0], OperationToken._deserialize(kv0[1])), deserialized_dict["operationTokens"].items())),
			shared_entities=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["sharedEntities"].items())),
			minimum_kraken_version=deserialized_dict.get("minimumKrakenVersion"),
			external_jwt_config=dict(map(lambda kv0: (kv0[0], ExternalJwtConfig._deserialize(kv0[1])), deserialized_dict["externalJwtConfig"].items())),
			minimum_authentication_class_for_elevated_privileges=AuthenticationClass._deserialize(deserialized_dict["minimumAuthenticationClassForElevatedPrivileges"]),
			super_group=deserialized_dict.get("superGroup"),
			application_id=deserialized_dict.get("applicationId"),
		)

class GroupType(Enum):
	Root = "root"
	App = "app"
	Database = "database"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'GroupType':
		if data == "root":
			return GroupType.Root
		elif data == "app":
			return GroupType.App
		elif data == "database":
			return GroupType.Database
		else:
			raise Exception(f"{data} is not a valid value for GroupType enum.")

@dataclass
class DatabaseInitialisation:
	users: Optional[list['User']] = field(default_factory=list)
	healthcare_parties: Optional[list['HealthcareParty']] = field(default_factory=list)
	replication: Optional['Replication'] = None
	minimum_kraken_version: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"users": [x0.__serialize__() for x0 in self.users] if self.users is not None else None,
			"healthcareParties": [x0.__serialize__() for x0 in self.healthcare_parties] if self.healthcare_parties is not None else None,
			"replication": self.replication.__serialize__() if self.replication is not None else None,
			"minimumKrakenVersion": self.minimum_kraken_version,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DatabaseInitialisation':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			users=[User._deserialize(x0) for x0 in deserialized_dict.get("users")] if deserialized_dict.get("users") is not None else None,
			healthcare_parties=[HealthcareParty._deserialize(x0) for x0 in deserialized_dict.get("healthcareParties")] if deserialized_dict.get("healthcareParties") is not None else None,
			replication=Replication._deserialize(deserialized_dict.get("replication")) if deserialized_dict.get("replication") is not None else None,
			minimum_kraken_version=deserialized_dict.get("minimumKrakenVersion"),
		)

@dataclass
class RegistrationSuccess:
	group_id: str
	user_id: str
	token: str

	def __serialize__(self) -> Any:
		return {
			"groupId": self.group_id,
			"userId": self.user_id,
			"token": self.token,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'RegistrationSuccess':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			group_id=deserialized_dict["groupId"],
			user_id=deserialized_dict["userId"],
			token=deserialized_dict["token"],
		)

class PermissionType(Enum):
	Authenticate = "AUTHENTICATE"
	Hcp = "HCP"
	Physician = "PHYSICIAN"
	Admin = "ADMIN"
	PatientView = "PATIENT_VIEW"
	PatientCreate = "PATIENT_CREATE"
	PatientChangeDelete = "PATIENT_CHANGE_DELETE"
	MedicalDataView = "MEDICAL_DATA_VIEW"
	MedicalDataCreate = "MEDICAL_DATA_CREATE"
	MedicalChangeDelete = "MEDICAL_CHANGE_DELETE"
	FinancialDataView = "FINANCIAL_DATA_VIEW"
	FinancialDataCreate = "FINANCIAL_DATA_CREATE"
	FinancialChangeDelete = "FINANCIAL_CHANGE_DELETE"
	LegacyDataView = "LEGACY_DATA_VIEW"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'PermissionType':
		if data == "AUTHENTICATE":
			return PermissionType.Authenticate
		elif data == "HCP":
			return PermissionType.Hcp
		elif data == "PHYSICIAN":
			return PermissionType.Physician
		elif data == "ADMIN":
			return PermissionType.Admin
		elif data == "PATIENT_VIEW":
			return PermissionType.PatientView
		elif data == "PATIENT_CREATE":
			return PermissionType.PatientCreate
		elif data == "PATIENT_CHANGE_DELETE":
			return PermissionType.PatientChangeDelete
		elif data == "MEDICAL_DATA_VIEW":
			return PermissionType.MedicalDataView
		elif data == "MEDICAL_DATA_CREATE":
			return PermissionType.MedicalDataCreate
		elif data == "MEDICAL_CHANGE_DELETE":
			return PermissionType.MedicalChangeDelete
		elif data == "FINANCIAL_DATA_VIEW":
			return PermissionType.FinancialDataView
		elif data == "FINANCIAL_DATA_CREATE":
			return PermissionType.FinancialDataCreate
		elif data == "FINANCIAL_CHANGE_DELETE":
			return PermissionType.FinancialChangeDelete
		elif data == "LEGACY_DATA_VIEW":
			return PermissionType.LegacyDataView
		else:
			raise Exception(f"{data} is not a valid value for PermissionType enum.")

@dataclass
class RegistrationInformation:
	email_address: str
	first_name: Optional[str] = None
	last_name: Optional[str] = None
	company_name: Optional[str] = None
	user_options: Optional[str] = None
	user_roles: set[str] = field(default_factory=set)
	minimum_kraken_version: Optional[str] = None
	cluster: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"firstName": self.first_name,
			"lastName": self.last_name,
			"companyName": self.company_name,
			"emailAddress": self.email_address,
			"userOptions": self.user_options,
			"userRoles": [x0 for x0 in self.user_roles],
			"minimumKrakenVersion": self.minimum_kraken_version,
			"cluster": self.cluster,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'RegistrationInformation':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			first_name=deserialized_dict.get("firstName"),
			last_name=deserialized_dict.get("lastName"),
			company_name=deserialized_dict.get("companyName"),
			email_address=deserialized_dict["emailAddress"],
			user_options=deserialized_dict.get("userOptions"),
			user_roles={x0 for x0 in deserialized_dict["userRoles"]},
			minimum_kraken_version=deserialized_dict.get("minimumKrakenVersion"),
			cluster=deserialized_dict.get("cluster"),
		)

class Operation(Enum):
	TransferGroup = "TRANSFER_GROUP"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Operation':
		if data == "TRANSFER_GROUP":
			return Operation.TransferGroup
		else:
			raise Exception(f"{data} is not a valid value for Operation enum.")

class UserType(Enum):
	Hcp = "HCP"
	Patient = "PATIENT"
	Device = "DEVICE"
	User = "USER"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'UserType':
		if data == "HCP":
			return UserType.Hcp
		elif data == "PATIENT":
			return UserType.Patient
		elif data == "DEVICE":
			return UserType.Device
		elif data == "USER":
			return UserType.User
		else:
			raise Exception(f"{data} is not a valid value for UserType enum.")

@dataclass
class RoleConfiguration:
	source: 'RoleConfigurationSource'
	roles: set[str] = field(default_factory=set)

	def __serialize__(self) -> Any:
		return {
			"source": self.source.__serialize__(),
			"roles": [x0 for x0 in self.roles],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'RoleConfiguration':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			source=RoleConfigurationSource._deserialize(deserialized_dict["source"]),
			roles={x0 for x0 in deserialized_dict["roles"]},
		)

class RoleConfigurationSource(Enum):
	Configuration = "CONFIGURATION"
	Inherited = "INHERITED"
	Default = "DEFAULT"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'RoleConfigurationSource':
		if data == "CONFIGURATION":
			return RoleConfigurationSource.Configuration
		elif data == "INHERITED":
			return RoleConfigurationSource.Inherited
		elif data == "DEFAULT":
			return RoleConfigurationSource.Default
		else:
			raise Exception(f"{data} is not a valid value for Source enum.")

@dataclass
class GroupDeletionReport:
	type: str
	id: str
	server: str

	def __serialize__(self) -> Any:
		return {
			"type": self.type,
			"id": self.id,
			"server": self.server,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'GroupDeletionReport':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			type=deserialized_dict["type"],
			id=deserialized_dict["id"],
			server=deserialized_dict["server"],
		)

@dataclass
class ListOfProperties:
	properties: list['DecryptedPropertyStub'] = field(default_factory=list)

	def __serialize__(self) -> Any:
		return {
			"properties": [x0.__serialize__() for x0 in self.properties],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ListOfProperties':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			properties=[DecryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict["properties"]],
		)

@dataclass
class DesignDocument:
	id: str
	rev: Optional[str] = None
	rev_history: dict[str, str] = field(default_factory=dict)
	language: Optional[str] = None
	views: dict[str, 'View'] = field(default_factory=dict)
	lists: dict[str, str] = field(default_factory=dict)
	shows: dict[str, str] = field(default_factory=dict)
	update_handlers: Optional[dict[str, str]] = None
	filters: dict[str, str] = field(default_factory=dict)

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"revHistory": {k0: v0 for k0, v0 in self.rev_history.items()},
			"language": self.language,
			"views": {k0: v0.__serialize__() for k0, v0 in self.views.items()},
			"lists": {k0: v0 for k0, v0 in self.lists.items()},
			"shows": {k0: v0 for k0, v0 in self.shows.items()},
			"updateHandlers": {k0: v0 for k0, v0 in self.update_handlers.items()} if self.update_handlers is not None else None,
			"filters": {k0: v0 for k0, v0 in self.filters.items()},
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DesignDocument':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			rev_history=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["revHistory"].items())),
			language=deserialized_dict.get("language"),
			views=dict(map(lambda kv0: (kv0[0], View._deserialize(kv0[1])), deserialized_dict["views"].items())),
			lists=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["lists"].items())),
			shows=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["shows"].items())),
			update_handlers=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("updateHandlers").items())) if deserialized_dict.get("updateHandlers") is not None else None,
			filters=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["filters"].items())),
		)

@dataclass
class GroupDatabasesInfo:
	group_id: str
	databases_info: list['DatabaseInfo']
	gcp_storage_size: int

	def __serialize__(self) -> Any:
		return {
			"groupId": self.group_id,
			"databasesInfo": [x0.__serialize__() for x0 in self.databases_info],
			"gcpStorageSize": self.gcp_storage_size,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'GroupDatabasesInfo':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			group_id=deserialized_dict["groupId"],
			databases_info=[DatabaseInfo._deserialize(x0) for x0 in deserialized_dict["databasesInfo"]],
			gcp_storage_size=deserialized_dict["gcpStorageSize"],
		)

@dataclass
class ExternalJwtConfig:
	validation_method: 'ExternalJwtConfigValidationMethod'
	field_selector: 'ExternalJwtConfigFieldSelector'
	authentication_class: 'AuthenticationClass' = field(default_factory=lambda: AuthenticationClass.ExternalAuthentication)

	def __serialize__(self) -> Any:
		return {
			"validationMethod": serialize_external_jwt_config_validation_method(self.validation_method),
			"fieldSelector": serialize_external_jwt_config_field_selector(self.field_selector),
			"authenticationClass": self.authentication_class.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ExternalJwtConfig':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			validation_method=deserialize_external_jwt_config_validation_method(deserialized_dict["validationMethod"]),
			field_selector=deserialize_external_jwt_config_field_selector(deserialized_dict["fieldSelector"]),
			authentication_class=AuthenticationClass._deserialize(deserialized_dict["authenticationClass"]),
		)

@dataclass
class ExternalJwtConfigValidationMethodPublicKey:
	key: str

	def __serialize__(self) -> Any:
		return {
			"key": self.key,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ExternalJwtConfigValidationMethodPublicKey':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			key=deserialized_dict["key"],
		)

@dataclass
class ExternalJwtConfigValidationMethodOidc:
	issure_location: str

	def __serialize__(self) -> Any:
		return {
			"issureLocation": self.issure_location,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ExternalJwtConfigValidationMethodOidc':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			issure_location=deserialized_dict["issureLocation"],
		)

type ExternalJwtConfigValidationMethod = Union['ExternalJwtConfigValidationMethodPublicKey', 'ExternalJwtConfigValidationMethodOidc']

def serialize_external_jwt_config_validation_method(external_jwt_config_validation_method: ExternalJwtConfigValidationMethod) -> Any:
	if isinstance(external_jwt_config_validation_method, ExternalJwtConfigValidationMethodPublicKey):
		serialized_entity = external_jwt_config_validation_method.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.security.ExternalJwtConfig.ValidationMethod.PublicKey"})
		return serialized_entity
	elif isinstance(external_jwt_config_validation_method, ExternalJwtConfigValidationMethodOidc):
		serialized_entity = external_jwt_config_validation_method.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.security.ExternalJwtConfig.ValidationMethod.Oidc"})
		return serialized_entity
	else:
		raise Exception(f"{type(external_jwt_config_validation_method)} is not a known subclass of ValidationMethod")

def deserialize_external_jwt_config_validation_method(data: Union[str, dict[str, JsonElement]]) -> 'ExternalJwtConfigValidationMethod':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.security.ExternalJwtConfig.ValidationMethod.PublicKey":
		return ExternalJwtConfigValidationMethodPublicKey._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.security.ExternalJwtConfig.ValidationMethod.Oidc":
		return ExternalJwtConfigValidationMethodOidc._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of ValidationMethod")

@dataclass
class ExternalJwtConfigFieldSelectorLocalId:
	field_name: str

	def __serialize__(self) -> Any:
		return {
			"fieldName": self.field_name,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ExternalJwtConfigFieldSelectorLocalId':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			field_name=deserialized_dict["fieldName"],
		)

@dataclass
class ExternalJwtConfigFieldSelectorEmail:
	field_name: str

	def __serialize__(self) -> Any:
		return {
			"fieldName": self.field_name,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ExternalJwtConfigFieldSelectorEmail':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			field_name=deserialized_dict["fieldName"],
		)

@dataclass
class ExternalJwtConfigFieldSelectorMobilePhone:
	field_name: str

	def __serialize__(self) -> Any:
		return {
			"fieldName": self.field_name,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ExternalJwtConfigFieldSelectorMobilePhone':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			field_name=deserialized_dict["fieldName"],
		)

@dataclass
class ExternalJwtConfigFieldSelectorUsername:
	field_name: str

	def __serialize__(self) -> Any:
		return {
			"fieldName": self.field_name,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ExternalJwtConfigFieldSelectorUsername':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			field_name=deserialized_dict["fieldName"],
		)

@dataclass
class ExternalJwtConfigFieldSelectorIdentifier:
	identifier_assigner: str
	field_name: str

	def __serialize__(self) -> Any:
		return {
			"identifierAssigner": self.identifier_assigner,
			"fieldName": self.field_name,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ExternalJwtConfigFieldSelectorIdentifier':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			identifier_assigner=deserialized_dict["identifierAssigner"],
			field_name=deserialized_dict["fieldName"],
		)

type ExternalJwtConfigFieldSelector = Union['ExternalJwtConfigFieldSelectorLocalId', 'ExternalJwtConfigFieldSelectorEmail', 'ExternalJwtConfigFieldSelectorMobilePhone', 'ExternalJwtConfigFieldSelectorUsername', 'ExternalJwtConfigFieldSelectorIdentifier']

def serialize_external_jwt_config_field_selector(external_jwt_config_field_selector: ExternalJwtConfigFieldSelector) -> Any:
	if isinstance(external_jwt_config_field_selector, ExternalJwtConfigFieldSelectorLocalId):
		serialized_entity = external_jwt_config_field_selector.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.LocalId"})
		return serialized_entity
	elif isinstance(external_jwt_config_field_selector, ExternalJwtConfigFieldSelectorEmail):
		serialized_entity = external_jwt_config_field_selector.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Email"})
		return serialized_entity
	elif isinstance(external_jwt_config_field_selector, ExternalJwtConfigFieldSelectorMobilePhone):
		serialized_entity = external_jwt_config_field_selector.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.MobilePhone"})
		return serialized_entity
	elif isinstance(external_jwt_config_field_selector, ExternalJwtConfigFieldSelectorUsername):
		serialized_entity = external_jwt_config_field_selector.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Username"})
		return serialized_entity
	elif isinstance(external_jwt_config_field_selector, ExternalJwtConfigFieldSelectorIdentifier):
		serialized_entity = external_jwt_config_field_selector.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Identifier"})
		return serialized_entity
	else:
		raise Exception(f"{type(external_jwt_config_field_selector)} is not a known subclass of FieldSelector")

def deserialize_external_jwt_config_field_selector(data: Union[str, dict[str, JsonElement]]) -> 'ExternalJwtConfigFieldSelector':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.LocalId":
		return ExternalJwtConfigFieldSelectorLocalId._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Email":
		return ExternalJwtConfigFieldSelectorEmail._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.MobilePhone":
		return ExternalJwtConfigFieldSelectorMobilePhone._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Username":
		return ExternalJwtConfigFieldSelectorUsername._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Identifier":
		return ExternalJwtConfigFieldSelectorIdentifier._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of FieldSelector")

class EntitySubscriptionCloseReason(Enum):
	ChannelFull = "ChannelFull"
	ConnectionLost = "ConnectionLost"
	IntentionallyClosed = "IntentionallyClosed"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EntitySubscriptionCloseReason':
		if data == "ChannelFull":
			return EntitySubscriptionCloseReason.ChannelFull
		elif data == "ConnectionLost":
			return EntitySubscriptionCloseReason.ConnectionLost
		elif data == "IntentionallyClosed":
			return EntitySubscriptionCloseReason.IntentionallyClosed
		else:
			raise Exception(f"{data} is not a valid value for EntitySubscriptionCloseReason enum.")

@dataclass(frozen=True)
class CodeStub:
	id: Optional[str] = None
	context: Optional[str] = None
	type: Optional[str] = None
	code: Optional[str] = None
	version: Optional[str] = None
	context_label: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"context": self.context,
			"type": self.type,
			"code": self.code,
			"version": self.version,
			"contextLabel": self.context_label,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'CodeStub':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict.get("id"),
			context=deserialized_dict.get("context"),
			type=deserialized_dict.get("type"),
			code=deserialized_dict.get("code"),
			version=deserialized_dict.get("version"),
			context_label=deserialized_dict.get("contextLabel"),
		)

@dataclass
class KeywordSubword:
	value: Optional[str] = None
	sub_words: Optional[list['KeywordSubword']] = None

	def __serialize__(self) -> Any:
		return {
			"value": self.value,
			"subWords": [x0.__serialize__() for x0 in self.sub_words] if self.sub_words is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'KeywordSubword':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			value=deserialized_dict.get("value"),
			sub_words=[KeywordSubword._deserialize(x0) for x0 in deserialized_dict.get("subWords")] if deserialized_dict.get("subWords") is not None else None,
		)

@dataclass
class Identifier:
	id: Optional[str] = None
	assigner: Optional[str] = None
	start: Optional[str] = None
	end: Optional[str] = None
	system: Optional[str] = None
	type: Optional['CodeStub'] = None
	use: Optional[str] = None
	value: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"assigner": self.assigner,
			"start": self.start,
			"end": self.end,
			"system": self.system,
			"type": self.type.__serialize__() if self.type is not None else None,
			"use": self.use,
			"value": self.value,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Identifier':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict.get("id"),
			assigner=deserialized_dict.get("assigner"),
			start=deserialized_dict.get("start"),
			end=deserialized_dict.get("end"),
			system=deserialized_dict.get("system"),
			type=CodeStub._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
			use=deserialized_dict.get("use"),
			value=deserialized_dict.get("value"),
		)

@dataclass
class Delegation:
	owner: Optional[str] = None
	delegated_to: Optional[str] = None
	key: Optional['HexString'] = None
	tags: list[str] = field(default_factory=list)

	def __serialize__(self) -> Any:
		return {
			"owner": self.owner,
			"delegatedTo": self.delegated_to,
			"key": self.key,
			"tags": [x0 for x0 in self.tags],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Delegation':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			owner=deserialized_dict.get("owner"),
			delegated_to=deserialized_dict.get("delegatedTo"),
			key=deserialized_dict.get("key"),
			tags=[x0 for x0 in deserialized_dict["tags"]],
		)

@dataclass
class SecurityMetadata:
	secure_delegations: dict['SecureDelegationKeyString', 'SecureDelegation']

	def __serialize__(self) -> Any:
		return {
			"secureDelegations": {k0: v0.__serialize__() for k0, v0 in self.secure_delegations.items()},
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'SecurityMetadata':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			secure_delegations=dict(map(lambda kv0: (kv0[0], SecureDelegation._deserialize(kv0[1])), deserialized_dict["secureDelegations"].items())),
		)

@dataclass
class EncryptedAddress:
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	identifier: list['Identifier'] = field(default_factory=list)
	address_type: Optional['AddressType'] = None
	descr: Optional[str] = None
	street: Optional[str] = None
	house_number: Optional[str] = None
	postbox_number: Optional[str] = None
	postal_code: Optional[str] = None
	city: Optional[str] = None
	state: Optional[str] = None
	country: Optional[str] = None
	note: Optional[str] = None
	notes: list['Annotation'] = field(default_factory=list)
	telecoms: list['EncryptedTelecom'] = field(default_factory=list)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"identifier": [x0.__serialize__() for x0 in self.identifier],
			"addressType": self.address_type.__serialize__() if self.address_type is not None else None,
			"descr": self.descr,
			"street": self.street,
			"houseNumber": self.house_number,
			"postboxNumber": self.postbox_number,
			"postalCode": self.postal_code,
			"city": self.city,
			"state": self.state,
			"country": self.country,
			"note": self.note,
			"notes": [x0.__serialize__() for x0 in self.notes],
			"telecoms": [x0.__serialize__() for x0 in self.telecoms],
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedAddress':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			identifier=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			address_type=AddressType._deserialize(deserialized_dict.get("addressType")) if deserialized_dict.get("addressType") is not None else None,
			descr=deserialized_dict.get("descr"),
			street=deserialized_dict.get("street"),
			house_number=deserialized_dict.get("houseNumber"),
			postbox_number=deserialized_dict.get("postboxNumber"),
			postal_code=deserialized_dict.get("postalCode"),
			city=deserialized_dict.get("city"),
			state=deserialized_dict.get("state"),
			country=deserialized_dict.get("country"),
			note=deserialized_dict.get("note"),
			notes=[Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
			telecoms=[EncryptedTelecom._deserialize(x0) for x0 in deserialized_dict["telecoms"]],
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class DecryptedAddress:
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	identifier: list['Identifier'] = field(default_factory=list)
	address_type: Optional['AddressType'] = None
	descr: Optional[str] = None
	street: Optional[str] = None
	house_number: Optional[str] = None
	postbox_number: Optional[str] = None
	postal_code: Optional[str] = None
	city: Optional[str] = None
	state: Optional[str] = None
	country: Optional[str] = None
	note: Optional[str] = None
	notes: list['Annotation'] = field(default_factory=list)
	telecoms: list['DecryptedTelecom'] = field(default_factory=list)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"identifier": [x0.__serialize__() for x0 in self.identifier],
			"addressType": self.address_type.__serialize__() if self.address_type is not None else None,
			"descr": self.descr,
			"street": self.street,
			"houseNumber": self.house_number,
			"postboxNumber": self.postbox_number,
			"postalCode": self.postal_code,
			"city": self.city,
			"state": self.state,
			"country": self.country,
			"note": self.note,
			"notes": [x0.__serialize__() for x0 in self.notes],
			"telecoms": [x0.__serialize__() for x0 in self.telecoms],
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedAddress':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			identifier=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			address_type=AddressType._deserialize(deserialized_dict.get("addressType")) if deserialized_dict.get("addressType") is not None else None,
			descr=deserialized_dict.get("descr"),
			street=deserialized_dict.get("street"),
			house_number=deserialized_dict.get("houseNumber"),
			postbox_number=deserialized_dict.get("postboxNumber"),
			postal_code=deserialized_dict.get("postalCode"),
			city=deserialized_dict.get("city"),
			state=deserialized_dict.get("state"),
			country=deserialized_dict.get("country"),
			note=deserialized_dict.get("note"),
			notes=[Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
			telecoms=[DecryptedTelecom._deserialize(x0) for x0 in deserialized_dict["telecoms"]],
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

type Address = Union['EncryptedAddress', 'DecryptedAddress']

def serialize_address(address: Address) -> Any:
	if isinstance(address, EncryptedAddress):
		serialized_entity = address.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.EncryptedAddress"})
		return serialized_entity
	elif isinstance(address, DecryptedAddress):
		serialized_entity = address.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.DecryptedAddress"})
		return serialized_entity
	else:
		raise Exception(f"{type(address)} is not a known subclass of Address")

def deserialize_address(data: Union[str, dict[str, JsonElement]]) -> 'Address':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.embed.EncryptedAddress":
		return EncryptedAddress._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.embed.DecryptedAddress":
		return DecryptedAddress._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of Address")

@dataclass
class TimeTableItem:
	rrule_start_date: Optional[int] = None
	rrule: Optional[str] = None
	not_before_in_minutes: Optional[int] = None
	not_after_in_minutes: Optional[int] = None
	zone_id: Optional[str] = None
	hours: list['TimeTableHour'] = field(default_factory=list)
	calendar_item_type_id: Optional[str] = None
	home_visit: bool = False
	place_id: Optional[str] = None
	public_time_table_item: bool = False
	accepts_new_patient: bool = True
	unavailable: bool = False
	reserving_rights: set[str] = field(default_factory=set)

	def __serialize__(self) -> Any:
		return {
			"rruleStartDate": self.rrule_start_date,
			"rrule": self.rrule,
			"notBeforeInMinutes": self.not_before_in_minutes,
			"notAfterInMinutes": self.not_after_in_minutes,
			"zoneId": self.zone_id,
			"hours": [x0.__serialize__() for x0 in self.hours],
			"calendarItemTypeId": self.calendar_item_type_id,
			"homeVisit": self.home_visit,
			"placeId": self.place_id,
			"publicTimeTableItem": self.public_time_table_item,
			"acceptsNewPatient": self.accepts_new_patient,
			"unavailable": self.unavailable,
			"reservingRights": [x0 for x0 in self.reserving_rights],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'TimeTableItem':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			rrule_start_date=deserialized_dict.get("rruleStartDate"),
			rrule=deserialized_dict.get("rrule"),
			not_before_in_minutes=deserialized_dict.get("notBeforeInMinutes"),
			not_after_in_minutes=deserialized_dict.get("notAfterInMinutes"),
			zone_id=deserialized_dict.get("zoneId"),
			hours=[TimeTableHour._deserialize(x0) for x0 in deserialized_dict["hours"]],
			calendar_item_type_id=deserialized_dict.get("calendarItemTypeId"),
			home_visit=deserialized_dict["homeVisit"],
			place_id=deserialized_dict.get("placeId"),
			public_time_table_item=deserialized_dict["publicTimeTableItem"],
			accepts_new_patient=deserialized_dict["acceptsNewPatient"],
			unavailable=deserialized_dict["unavailable"],
			reserving_rights={x0 for x0 in deserialized_dict["reservingRights"]},
		)

class DocumentLocation(Enum):
	Annex = "annex"
	Body = "body"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DocumentLocation':
		if data == "annex":
			return DocumentLocation.Annex
		elif data == "body":
			return DocumentLocation.Body
		else:
			raise Exception(f"{data} is not a valid value for DocumentLocation enum.")

class DocumentType(Enum):
	Admission = "admission"
	Alert = "alert"
	BvtSample = "bvt_sample"
	Clinicalpath = "clinicalpath"
	Clinicalsummary = "clinicalsummary"
	Contactreport = "contactreport"
	Quote = "quote"
	Invoice = "invoice"
	Death = "death"
	Discharge = "discharge"
	Dischargereport = "dischargereport"
	EbirthBabyMedicalform = "ebirth_baby_medicalform"
	EbirthBabyNotification = "ebirth_baby_notification"
	EbirthMotherMedicalform = "ebirth_mother_medicalform"
	EbirthMotherNotification = "ebirth_mother_notification"
	EcareSafeConsultation = "ecare_safe_consultation"
	Epidemiology = "epidemiology"
	Intervention = "intervention"
	Labrequest = "labrequest"
	Labresult = "labresult"
	Medicaladvisoragreement = "medicaladvisoragreement"
	Medicationschemeelement = "medicationschemeelement"
	Note = "note"
	Notification = "notification"
	Pharmaceuticalprescription = "pharmaceuticalprescription"
	Prescription = "prescription"
	Productdelivery = "productdelivery"
	Quickdischargereport = "quickdischargereport"
	Radiationexposuremonitoring = "radiationexposuremonitoring"
	Referral = "referral"
	Report = "report"
	Request = "request"
	Result = "result"
	Sumehr = "sumehr"
	Telemonitoring = "telemonitoring"
	Template = "template"
	TemplateAdmin = "template_admin"
	Treatmentsuspension = "treatmentsuspension"
	Vaccination = "vaccination"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DocumentType':
		if data == "admission":
			return DocumentType.Admission
		elif data == "alert":
			return DocumentType.Alert
		elif data == "bvt_sample":
			return DocumentType.BvtSample
		elif data == "clinicalpath":
			return DocumentType.Clinicalpath
		elif data == "clinicalsummary":
			return DocumentType.Clinicalsummary
		elif data == "contactreport":
			return DocumentType.Contactreport
		elif data == "quote":
			return DocumentType.Quote
		elif data == "invoice":
			return DocumentType.Invoice
		elif data == "death":
			return DocumentType.Death
		elif data == "discharge":
			return DocumentType.Discharge
		elif data == "dischargereport":
			return DocumentType.Dischargereport
		elif data == "ebirth_baby_medicalform":
			return DocumentType.EbirthBabyMedicalform
		elif data == "ebirth_baby_notification":
			return DocumentType.EbirthBabyNotification
		elif data == "ebirth_mother_medicalform":
			return DocumentType.EbirthMotherMedicalform
		elif data == "ebirth_mother_notification":
			return DocumentType.EbirthMotherNotification
		elif data == "ecare_safe_consultation":
			return DocumentType.EcareSafeConsultation
		elif data == "epidemiology":
			return DocumentType.Epidemiology
		elif data == "intervention":
			return DocumentType.Intervention
		elif data == "labrequest":
			return DocumentType.Labrequest
		elif data == "labresult":
			return DocumentType.Labresult
		elif data == "medicaladvisoragreement":
			return DocumentType.Medicaladvisoragreement
		elif data == "medicationschemeelement":
			return DocumentType.Medicationschemeelement
		elif data == "note":
			return DocumentType.Note
		elif data == "notification":
			return DocumentType.Notification
		elif data == "pharmaceuticalprescription":
			return DocumentType.Pharmaceuticalprescription
		elif data == "prescription":
			return DocumentType.Prescription
		elif data == "productdelivery":
			return DocumentType.Productdelivery
		elif data == "quickdischargereport":
			return DocumentType.Quickdischargereport
		elif data == "radiationexposuremonitoring":
			return DocumentType.Radiationexposuremonitoring
		elif data == "referral":
			return DocumentType.Referral
		elif data == "report":
			return DocumentType.Report
		elif data == "request":
			return DocumentType.Request
		elif data == "result":
			return DocumentType.Result
		elif data == "sumehr":
			return DocumentType.Sumehr
		elif data == "telemonitoring":
			return DocumentType.Telemonitoring
		elif data == "template":
			return DocumentType.Template
		elif data == "template_admin":
			return DocumentType.TemplateAdmin
		elif data == "treatmentsuspension":
			return DocumentType.Treatmentsuspension
		elif data == "vaccination":
			return DocumentType.Vaccination
		else:
			raise Exception(f"{data} is not a valid value for DocumentType enum.")

class DocumentStatus(Enum):
	Draft = "draft"
	Finalized = "finalized"
	PendingReview = "pending_review"
	Reviewed = "reviewed"
	PendingSignature = "pending_signature"
	Signed = "signed"
	Canceled = "canceled"
	Sent = "sent"
	Delivered = "delivered"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DocumentStatus':
		if data == "draft":
			return DocumentStatus.Draft
		elif data == "finalized":
			return DocumentStatus.Finalized
		elif data == "pending_review":
			return DocumentStatus.PendingReview
		elif data == "reviewed":
			return DocumentStatus.Reviewed
		elif data == "pending_signature":
			return DocumentStatus.PendingSignature
		elif data == "signed":
			return DocumentStatus.Signed
		elif data == "canceled":
			return DocumentStatus.Canceled
		elif data == "sent":
			return DocumentStatus.Sent
		elif data == "delivered":
			return DocumentStatus.Delivered
		else:
			raise Exception(f"{data} is not a valid value for DocumentStatus enum.")

@dataclass
class DataAttachment:
	couch_db_attachment_id: Optional[str] = None
	object_store_attachment_id: Optional[str] = None
	utis: list[str] = field(default_factory=list)

	def __serialize__(self) -> Any:
		return {
			"couchDbAttachmentId": self.couch_db_attachment_id,
			"objectStoreAttachmentId": self.object_store_attachment_id,
			"utis": [x0 for x0 in self.utis],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DataAttachment':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			couch_db_attachment_id=deserialized_dict.get("couchDbAttachmentId"),
			object_store_attachment_id=deserialized_dict.get("objectStoreAttachmentId"),
			utis=[x0 for x0 in deserialized_dict["utis"]],
		)

@dataclass
class DeletedAttachment:
	couch_db_attachment_id: Optional[str] = None
	object_store_attachment_id: Optional[str] = None
	key: Optional[str] = None
	deletion_time: Optional[int] = None

	def __serialize__(self) -> Any:
		return {
			"couchDbAttachmentId": self.couch_db_attachment_id,
			"objectStoreAttachmentId": self.object_store_attachment_id,
			"key": self.key,
			"deletionTime": self.deletion_time,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DeletedAttachment':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			couch_db_attachment_id=deserialized_dict.get("couchDbAttachmentId"),
			object_store_attachment_id=deserialized_dict.get("objectStoreAttachmentId"),
			key=deserialized_dict.get("key"),
			deletion_time=deserialized_dict.get("deletionTime"),
		)

@dataclass
class PersonName:
	last_name: Optional[str] = None
	first_names: list[str] = field(default_factory=list)
	start: Optional[int] = None
	end: Optional[int] = None
	prefix: list[str] = field(default_factory=list)
	suffix: list[str] = field(default_factory=list)
	text: Optional[str] = None
	use: Optional['PersonNameUse'] = None

	def __serialize__(self) -> Any:
		return {
			"lastName": self.last_name,
			"firstNames": [x0 for x0 in self.first_names],
			"start": self.start,
			"end": self.end,
			"prefix": [x0 for x0 in self.prefix],
			"suffix": [x0 for x0 in self.suffix],
			"text": self.text,
			"use": self.use.__serialize__() if self.use is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'PersonName':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			last_name=deserialized_dict.get("lastName"),
			first_names=[x0 for x0 in deserialized_dict["firstNames"]],
			start=deserialized_dict.get("start"),
			end=deserialized_dict.get("end"),
			prefix=[x0 for x0 in deserialized_dict["prefix"]],
			suffix=[x0 for x0 in deserialized_dict["suffix"]],
			text=deserialized_dict.get("text"),
			use=PersonNameUse._deserialize(deserialized_dict.get("use")) if deserialized_dict.get("use") is not None else None,
		)

class Gender(Enum):
	Male = "male"
	Female = "female"
	Indeterminate = "indeterminate"
	Changed = "changed"
	ChangedToMale = "changedToMale"
	ChangedToFemale = "changedToFemale"
	Unknown = "unknown"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Gender':
		if data == "male":
			return Gender.Male
		elif data == "female":
			return Gender.Female
		elif data == "indeterminate":
			return Gender.Indeterminate
		elif data == "changed":
			return Gender.Changed
		elif data == "changedToMale":
			return Gender.ChangedToMale
		elif data == "changedToFemale":
			return Gender.ChangedToFemale
		elif data == "unknown":
			return Gender.Unknown
		else:
			raise Exception(f"{data} is not a valid value for Gender enum.")

class DeactivationReason(Enum):
	Deceased = "deceased"
	Moved = "moved"
	OtherDoctor = "other_doctor"
	Retired = "retired"
	NoContact = "no_contact"
	Unknown = "unknown"
	Nothing = "none"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DeactivationReason':
		if data == "deceased":
			return DeactivationReason.Deceased
		elif data == "moved":
			return DeactivationReason.Moved
		elif data == "other_doctor":
			return DeactivationReason.OtherDoctor
		elif data == "retired":
			return DeactivationReason.Retired
		elif data == "no_contact":
			return DeactivationReason.NoContact
		elif data == "unknown":
			return DeactivationReason.Unknown
		elif data == "none":
			return DeactivationReason.Nothing
		else:
			raise Exception(f"{data} is not a valid value for DeactivationReason enum.")

class PersonalStatus(Enum):
	Single = "single"
	InCouple = "in_couple"
	Married = "married"
	Separated = "separated"
	Divorced = "divorced"
	Divorcing = "divorcing"
	Widowed = "widowed"
	Widower = "widower"
	Complicated = "complicated"
	Unknown = "unknown"
	Contract = "contract"
	Other = "other"
	Annulled = "annulled"
	Polygamous = "polygamous"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'PersonalStatus':
		if data == "single":
			return PersonalStatus.Single
		elif data == "in_couple":
			return PersonalStatus.InCouple
		elif data == "married":
			return PersonalStatus.Married
		elif data == "separated":
			return PersonalStatus.Separated
		elif data == "divorced":
			return PersonalStatus.Divorced
		elif data == "divorcing":
			return PersonalStatus.Divorcing
		elif data == "widowed":
			return PersonalStatus.Widowed
		elif data == "widower":
			return PersonalStatus.Widower
		elif data == "complicated":
			return PersonalStatus.Complicated
		elif data == "unknown":
			return PersonalStatus.Unknown
		elif data == "contract":
			return PersonalStatus.Contract
		elif data == "other":
			return PersonalStatus.Other
		elif data == "annulled":
			return PersonalStatus.Annulled
		elif data == "polygamous":
			return PersonalStatus.Polygamous
		else:
			raise Exception(f"{data} is not a valid value for PersonalStatus enum.")

@dataclass
class Annotation:
	id: str
	author: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	text: Optional[str] = None
	markdown: dict[str, str] = field(default_factory=dict)
	location: Optional[str] = None
	confidential: Optional[bool] = None
	tags: set['CodeStub'] = field(default_factory=set)
	encrypted_self: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"author": self.author,
			"created": self.created,
			"modified": self.modified,
			"text": self.text,
			"markdown": {k0: v0 for k0, v0 in self.markdown.items()},
			"location": self.location,
			"confidential": self.confidential,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Annotation':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			author=deserialized_dict.get("author"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			text=deserialized_dict.get("text"),
			markdown=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["markdown"].items())),
			location=deserialized_dict.get("location"),
			confidential=deserialized_dict.get("confidential"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class DecryptedInsurability:
	parameters: dict[str, str] = field(default_factory=dict)
	hospitalisation: Optional[bool] = None
	ambulatory: Optional[bool] = None
	dental: Optional[bool] = None
	identification_number: Optional[str] = None
	insurance_id: Optional[str] = None
	start_date: Optional[int] = None
	end_date: Optional[int] = None
	titulary_id: Optional[str] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"parameters": {k0: v0 for k0, v0 in self.parameters.items()},
			"hospitalisation": self.hospitalisation,
			"ambulatory": self.ambulatory,
			"dental": self.dental,
			"identificationNumber": self.identification_number,
			"insuranceId": self.insurance_id,
			"startDate": self.start_date,
			"endDate": self.end_date,
			"titularyId": self.titulary_id,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedInsurability':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			parameters=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["parameters"].items())),
			hospitalisation=deserialized_dict.get("hospitalisation"),
			ambulatory=deserialized_dict.get("ambulatory"),
			dental=deserialized_dict.get("dental"),
			identification_number=deserialized_dict.get("identificationNumber"),
			insurance_id=deserialized_dict.get("insuranceId"),
			start_date=deserialized_dict.get("startDate"),
			end_date=deserialized_dict.get("endDate"),
			titulary_id=deserialized_dict.get("titularyId"),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class EncryptedInsurability:
	parameters: dict[str, str] = field(default_factory=dict)
	hospitalisation: Optional[bool] = None
	ambulatory: Optional[bool] = None
	dental: Optional[bool] = None
	identification_number: Optional[str] = None
	insurance_id: Optional[str] = None
	start_date: Optional[int] = None
	end_date: Optional[int] = None
	titulary_id: Optional[str] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"parameters": {k0: v0 for k0, v0 in self.parameters.items()},
			"hospitalisation": self.hospitalisation,
			"ambulatory": self.ambulatory,
			"dental": self.dental,
			"identificationNumber": self.identification_number,
			"insuranceId": self.insurance_id,
			"startDate": self.start_date,
			"endDate": self.end_date,
			"titularyId": self.titulary_id,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedInsurability':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			parameters=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["parameters"].items())),
			hospitalisation=deserialized_dict.get("hospitalisation"),
			ambulatory=deserialized_dict.get("ambulatory"),
			dental=deserialized_dict.get("dental"),
			identification_number=deserialized_dict.get("identificationNumber"),
			insurance_id=deserialized_dict.get("insuranceId"),
			start_date=deserialized_dict.get("startDate"),
			end_date=deserialized_dict.get("endDate"),
			titulary_id=deserialized_dict.get("titularyId"),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

type Insurability = Union['DecryptedInsurability', 'EncryptedInsurability']

def serialize_insurability(insurability: Insurability) -> Any:
	if isinstance(insurability, DecryptedInsurability):
		serialized_entity = insurability.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.DecryptedInsurability"})
		return serialized_entity
	elif isinstance(insurability, EncryptedInsurability):
		serialized_entity = insurability.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.EncryptedInsurability"})
		return serialized_entity
	else:
		raise Exception(f"{type(insurability)} is not a known subclass of Insurability")

def deserialize_insurability(data: Union[str, dict[str, JsonElement]]) -> 'Insurability':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.embed.DecryptedInsurability":
		return DecryptedInsurability._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.embed.EncryptedInsurability":
		return EncryptedInsurability._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of Insurability")

@dataclass
class Partnership:
	type: Optional['PartnershipType'] = None
	status: Optional['PartnershipStatus'] = None
	partner_id: Optional[str] = None
	me_to_other_relationship_description: Optional[str] = None
	other_to_me_relationship_description: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"type": self.type.__serialize__() if self.type is not None else None,
			"status": self.status.__serialize__() if self.status is not None else None,
			"partnerId": self.partner_id,
			"meToOtherRelationshipDescription": self.me_to_other_relationship_description,
			"otherToMeRelationshipDescription": self.other_to_me_relationship_description,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Partnership':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			type=PartnershipType._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
			status=PartnershipStatus._deserialize(deserialized_dict.get("status")) if deserialized_dict.get("status") is not None else None,
			partner_id=deserialized_dict.get("partnerId"),
			me_to_other_relationship_description=deserialized_dict.get("meToOtherRelationshipDescription"),
			other_to_me_relationship_description=deserialized_dict.get("otherToMeRelationshipDescription"),
		)

@dataclass
class EncryptedPatientHealthCareParty:
	type: Optional['PatientHealthCarePartyType'] = None
	healthcare_party_id: Optional[str] = None
	send_formats: dict['TelecomType', str] = field(default_factory=dict)
	referral_periods: list['ReferralPeriod'] = field(default_factory=list)
	referral: bool = False
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"type": self.type.__serialize__() if self.type is not None else None,
			"healthcarePartyId": self.healthcare_party_id,
			"sendFormats": {k0.__serialize__(): v0 for k0, v0 in self.send_formats.items()},
			"referralPeriods": [x0.__serialize__() for x0 in self.referral_periods],
			"referral": self.referral,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedPatientHealthCareParty':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			type=PatientHealthCarePartyType._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			send_formats=dict(map(lambda kv0: (TelecomType._deserialize(kv0[0]), kv0[1]), deserialized_dict["sendFormats"].items())),
			referral_periods=[ReferralPeriod._deserialize(x0) for x0 in deserialized_dict["referralPeriods"]],
			referral=deserialized_dict["referral"],
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class DecryptedPatientHealthCareParty:
	type: Optional['PatientHealthCarePartyType'] = None
	healthcare_party_id: Optional[str] = None
	send_formats: dict['TelecomType', str] = field(default_factory=dict)
	referral_periods: list['ReferralPeriod'] = field(default_factory=list)
	referral: bool = False
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"type": self.type.__serialize__() if self.type is not None else None,
			"healthcarePartyId": self.healthcare_party_id,
			"sendFormats": {k0.__serialize__(): v0 for k0, v0 in self.send_formats.items()},
			"referralPeriods": [x0.__serialize__() for x0 in self.referral_periods],
			"referral": self.referral,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedPatientHealthCareParty':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			type=PatientHealthCarePartyType._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			send_formats=dict(map(lambda kv0: (TelecomType._deserialize(kv0[0]), kv0[1]), deserialized_dict["sendFormats"].items())),
			referral_periods=[ReferralPeriod._deserialize(x0) for x0 in deserialized_dict["referralPeriods"]],
			referral=deserialized_dict["referral"],
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

type PatientHealthCareParty = Union['EncryptedPatientHealthCareParty', 'DecryptedPatientHealthCareParty']

def serialize_patient_health_care_party(patient_health_care_party: PatientHealthCareParty) -> Any:
	if isinstance(patient_health_care_party, EncryptedPatientHealthCareParty):
		serialized_entity = patient_health_care_party.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.EncryptedPatientHealthCareParty"})
		return serialized_entity
	elif isinstance(patient_health_care_party, DecryptedPatientHealthCareParty):
		serialized_entity = patient_health_care_party.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.DecryptedPatientHealthCareParty"})
		return serialized_entity
	else:
		raise Exception(f"{type(patient_health_care_party)} is not a known subclass of PatientHealthCareParty")

def deserialize_patient_health_care_party(data: Union[str, dict[str, JsonElement]]) -> 'PatientHealthCareParty':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.embed.EncryptedPatientHealthCareParty":
		return EncryptedPatientHealthCareParty._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.embed.DecryptedPatientHealthCareParty":
		return DecryptedPatientHealthCareParty._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of PatientHealthCareParty")

@dataclass
class EncryptedFinancialInstitutionInformation:
	name: Optional[str] = None
	key: Optional[str] = None
	bank_account: Optional[str] = None
	bic: Optional[str] = None
	proxy_bank_account: Optional[str] = None
	proxy_bic: Optional[str] = None
	preferred_fii_for_partners: set[str] = field(default_factory=set)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"name": self.name,
			"key": self.key,
			"bankAccount": self.bank_account,
			"bic": self.bic,
			"proxyBankAccount": self.proxy_bank_account,
			"proxyBic": self.proxy_bic,
			"preferredFiiForPartners": [x0 for x0 in self.preferred_fii_for_partners],
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedFinancialInstitutionInformation':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			name=deserialized_dict.get("name"),
			key=deserialized_dict.get("key"),
			bank_account=deserialized_dict.get("bankAccount"),
			bic=deserialized_dict.get("bic"),
			proxy_bank_account=deserialized_dict.get("proxyBankAccount"),
			proxy_bic=deserialized_dict.get("proxyBic"),
			preferred_fii_for_partners={x0 for x0 in deserialized_dict["preferredFiiForPartners"]},
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class DecryptedFinancialInstitutionInformation:
	name: Optional[str] = None
	key: Optional[str] = None
	bank_account: Optional[str] = None
	bic: Optional[str] = None
	proxy_bank_account: Optional[str] = None
	proxy_bic: Optional[str] = None
	preferred_fii_for_partners: set[str] = field(default_factory=set)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"name": self.name,
			"key": self.key,
			"bankAccount": self.bank_account,
			"bic": self.bic,
			"proxyBankAccount": self.proxy_bank_account,
			"proxyBic": self.proxy_bic,
			"preferredFiiForPartners": [x0 for x0 in self.preferred_fii_for_partners],
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedFinancialInstitutionInformation':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			name=deserialized_dict.get("name"),
			key=deserialized_dict.get("key"),
			bank_account=deserialized_dict.get("bankAccount"),
			bic=deserialized_dict.get("bic"),
			proxy_bank_account=deserialized_dict.get("proxyBankAccount"),
			proxy_bic=deserialized_dict.get("proxyBic"),
			preferred_fii_for_partners={x0 for x0 in deserialized_dict["preferredFiiForPartners"]},
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

type FinancialInstitutionInformation = Union['EncryptedFinancialInstitutionInformation', 'DecryptedFinancialInstitutionInformation']

def serialize_financial_institution_information(financial_institution_information: FinancialInstitutionInformation) -> Any:
	if isinstance(financial_institution_information, EncryptedFinancialInstitutionInformation):
		serialized_entity = financial_institution_information.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.EncryptedFinancialInstitutionInformation"})
		return serialized_entity
	elif isinstance(financial_institution_information, DecryptedFinancialInstitutionInformation):
		serialized_entity = financial_institution_information.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.DecryptedFinancialInstitutionInformation"})
		return serialized_entity
	else:
		raise Exception(f"{type(financial_institution_information)} is not a known subclass of FinancialInstitutionInformation")

def deserialize_financial_institution_information(data: Union[str, dict[str, JsonElement]]) -> 'FinancialInstitutionInformation':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.embed.EncryptedFinancialInstitutionInformation":
		return EncryptedFinancialInstitutionInformation._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.embed.DecryptedFinancialInstitutionInformation":
		return DecryptedFinancialInstitutionInformation._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of FinancialInstitutionInformation")

@dataclass
class DecryptedMedicalHouseContract:
	contract_id: Optional[str] = None
	valid_from: Optional[int] = None
	valid_to: Optional[int] = None
	mm_nihii: Optional[str] = None
	hcp_id: Optional[str] = None
	change_type: Optional['ContractChangeType'] = None
	parent_contract_id: Optional[str] = None
	changed_by: Optional[str] = None
	start_of_contract: Optional[int] = None
	start_of_coverage: Optional[int] = None
	end_of_contract: Optional[int] = None
	end_of_coverage: Optional[int] = None
	kine: bool = False
	gp: bool = False
	ptd: bool = False
	nurse: bool = False
	no_kine: bool = False
	no_gp: bool = False
	no_nurse: bool = False
	unsubscription_reason_id: Optional[int] = None
	ptd_start: Optional[int] = None
	ptd_end: Optional[int] = None
	ptd_last_invoiced: Optional[int] = None
	start_of_suspension: Optional[int] = None
	end_of_suspension: Optional[int] = None
	suspension_reason: Optional['SuspensionReason'] = None
	suspension_source: Optional[str] = None
	forced_suspension: bool = False
	signature_type: Optional['MhcSignatureType'] = None
	status: Optional[int] = None
	options: dict[str, str] = field(default_factory=dict)
	receipts: dict[str, str] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"contractId": self.contract_id,
			"validFrom": self.valid_from,
			"validTo": self.valid_to,
			"mmNihii": self.mm_nihii,
			"hcpId": self.hcp_id,
			"changeType": self.change_type.__serialize__() if self.change_type is not None else None,
			"parentContractId": self.parent_contract_id,
			"changedBy": self.changed_by,
			"startOfContract": self.start_of_contract,
			"startOfCoverage": self.start_of_coverage,
			"endOfContract": self.end_of_contract,
			"endOfCoverage": self.end_of_coverage,
			"kine": self.kine,
			"gp": self.gp,
			"ptd": self.ptd,
			"nurse": self.nurse,
			"noKine": self.no_kine,
			"noGp": self.no_gp,
			"noNurse": self.no_nurse,
			"unsubscriptionReasonId": self.unsubscription_reason_id,
			"ptdStart": self.ptd_start,
			"ptdEnd": self.ptd_end,
			"ptdLastInvoiced": self.ptd_last_invoiced,
			"startOfSuspension": self.start_of_suspension,
			"endOfSuspension": self.end_of_suspension,
			"suspensionReason": self.suspension_reason.__serialize__() if self.suspension_reason is not None else None,
			"suspensionSource": self.suspension_source,
			"forcedSuspension": self.forced_suspension,
			"signatureType": self.signature_type.__serialize__() if self.signature_type is not None else None,
			"status": self.status,
			"options": {k0: v0 for k0, v0 in self.options.items()},
			"receipts": {k0: v0 for k0, v0 in self.receipts.items()},
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedMedicalHouseContract':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			contract_id=deserialized_dict.get("contractId"),
			valid_from=deserialized_dict.get("validFrom"),
			valid_to=deserialized_dict.get("validTo"),
			mm_nihii=deserialized_dict.get("mmNihii"),
			hcp_id=deserialized_dict.get("hcpId"),
			change_type=ContractChangeType._deserialize(deserialized_dict.get("changeType")) if deserialized_dict.get("changeType") is not None else None,
			parent_contract_id=deserialized_dict.get("parentContractId"),
			changed_by=deserialized_dict.get("changedBy"),
			start_of_contract=deserialized_dict.get("startOfContract"),
			start_of_coverage=deserialized_dict.get("startOfCoverage"),
			end_of_contract=deserialized_dict.get("endOfContract"),
			end_of_coverage=deserialized_dict.get("endOfCoverage"),
			kine=deserialized_dict["kine"],
			gp=deserialized_dict["gp"],
			ptd=deserialized_dict["ptd"],
			nurse=deserialized_dict["nurse"],
			no_kine=deserialized_dict["noKine"],
			no_gp=deserialized_dict["noGp"],
			no_nurse=deserialized_dict["noNurse"],
			unsubscription_reason_id=deserialized_dict.get("unsubscriptionReasonId"),
			ptd_start=deserialized_dict.get("ptdStart"),
			ptd_end=deserialized_dict.get("ptdEnd"),
			ptd_last_invoiced=deserialized_dict.get("ptdLastInvoiced"),
			start_of_suspension=deserialized_dict.get("startOfSuspension"),
			end_of_suspension=deserialized_dict.get("endOfSuspension"),
			suspension_reason=SuspensionReason._deserialize(deserialized_dict.get("suspensionReason")) if deserialized_dict.get("suspensionReason") is not None else None,
			suspension_source=deserialized_dict.get("suspensionSource"),
			forced_suspension=deserialized_dict["forcedSuspension"],
			signature_type=MhcSignatureType._deserialize(deserialized_dict.get("signatureType")) if deserialized_dict.get("signatureType") is not None else None,
			status=deserialized_dict.get("status"),
			options=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["options"].items())),
			receipts=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["receipts"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class EncryptedMedicalHouseContract:
	contract_id: Optional[str] = None
	valid_from: Optional[int] = None
	valid_to: Optional[int] = None
	mm_nihii: Optional[str] = None
	hcp_id: Optional[str] = None
	change_type: Optional['ContractChangeType'] = None
	parent_contract_id: Optional[str] = None
	changed_by: Optional[str] = None
	start_of_contract: Optional[int] = None
	start_of_coverage: Optional[int] = None
	end_of_contract: Optional[int] = None
	end_of_coverage: Optional[int] = None
	kine: bool = False
	gp: bool = False
	ptd: bool = False
	nurse: bool = False
	no_kine: bool = False
	no_gp: bool = False
	no_nurse: bool = False
	unsubscription_reason_id: Optional[int] = None
	ptd_start: Optional[int] = None
	ptd_end: Optional[int] = None
	ptd_last_invoiced: Optional[int] = None
	start_of_suspension: Optional[int] = None
	end_of_suspension: Optional[int] = None
	suspension_reason: Optional['SuspensionReason'] = None
	suspension_source: Optional[str] = None
	forced_suspension: bool = False
	signature_type: Optional['MhcSignatureType'] = None
	status: Optional[int] = None
	options: dict[str, str] = field(default_factory=dict)
	receipts: dict[str, str] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"contractId": self.contract_id,
			"validFrom": self.valid_from,
			"validTo": self.valid_to,
			"mmNihii": self.mm_nihii,
			"hcpId": self.hcp_id,
			"changeType": self.change_type.__serialize__() if self.change_type is not None else None,
			"parentContractId": self.parent_contract_id,
			"changedBy": self.changed_by,
			"startOfContract": self.start_of_contract,
			"startOfCoverage": self.start_of_coverage,
			"endOfContract": self.end_of_contract,
			"endOfCoverage": self.end_of_coverage,
			"kine": self.kine,
			"gp": self.gp,
			"ptd": self.ptd,
			"nurse": self.nurse,
			"noKine": self.no_kine,
			"noGp": self.no_gp,
			"noNurse": self.no_nurse,
			"unsubscriptionReasonId": self.unsubscription_reason_id,
			"ptdStart": self.ptd_start,
			"ptdEnd": self.ptd_end,
			"ptdLastInvoiced": self.ptd_last_invoiced,
			"startOfSuspension": self.start_of_suspension,
			"endOfSuspension": self.end_of_suspension,
			"suspensionReason": self.suspension_reason.__serialize__() if self.suspension_reason is not None else None,
			"suspensionSource": self.suspension_source,
			"forcedSuspension": self.forced_suspension,
			"signatureType": self.signature_type.__serialize__() if self.signature_type is not None else None,
			"status": self.status,
			"options": {k0: v0 for k0, v0 in self.options.items()},
			"receipts": {k0: v0 for k0, v0 in self.receipts.items()},
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedMedicalHouseContract':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			contract_id=deserialized_dict.get("contractId"),
			valid_from=deserialized_dict.get("validFrom"),
			valid_to=deserialized_dict.get("validTo"),
			mm_nihii=deserialized_dict.get("mmNihii"),
			hcp_id=deserialized_dict.get("hcpId"),
			change_type=ContractChangeType._deserialize(deserialized_dict.get("changeType")) if deserialized_dict.get("changeType") is not None else None,
			parent_contract_id=deserialized_dict.get("parentContractId"),
			changed_by=deserialized_dict.get("changedBy"),
			start_of_contract=deserialized_dict.get("startOfContract"),
			start_of_coverage=deserialized_dict.get("startOfCoverage"),
			end_of_contract=deserialized_dict.get("endOfContract"),
			end_of_coverage=deserialized_dict.get("endOfCoverage"),
			kine=deserialized_dict["kine"],
			gp=deserialized_dict["gp"],
			ptd=deserialized_dict["ptd"],
			nurse=deserialized_dict["nurse"],
			no_kine=deserialized_dict["noKine"],
			no_gp=deserialized_dict["noGp"],
			no_nurse=deserialized_dict["noNurse"],
			unsubscription_reason_id=deserialized_dict.get("unsubscriptionReasonId"),
			ptd_start=deserialized_dict.get("ptdStart"),
			ptd_end=deserialized_dict.get("ptdEnd"),
			ptd_last_invoiced=deserialized_dict.get("ptdLastInvoiced"),
			start_of_suspension=deserialized_dict.get("startOfSuspension"),
			end_of_suspension=deserialized_dict.get("endOfSuspension"),
			suspension_reason=SuspensionReason._deserialize(deserialized_dict.get("suspensionReason")) if deserialized_dict.get("suspensionReason") is not None else None,
			suspension_source=deserialized_dict.get("suspensionSource"),
			forced_suspension=deserialized_dict["forcedSuspension"],
			signature_type=MhcSignatureType._deserialize(deserialized_dict.get("signatureType")) if deserialized_dict.get("signatureType") is not None else None,
			status=deserialized_dict.get("status"),
			options=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["options"].items())),
			receipts=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["receipts"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

type MedicalHouseContract = Union['DecryptedMedicalHouseContract', 'EncryptedMedicalHouseContract']

def serialize_medical_house_contract(medical_house_contract: MedicalHouseContract) -> Any:
	if isinstance(medical_house_contract, DecryptedMedicalHouseContract):
		serialized_entity = medical_house_contract.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.DecryptedMedicalHouseContract"})
		return serialized_entity
	elif isinstance(medical_house_contract, EncryptedMedicalHouseContract):
		serialized_entity = medical_house_contract.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.EncryptedMedicalHouseContract"})
		return serialized_entity
	else:
		raise Exception(f"{type(medical_house_contract)} is not a known subclass of MedicalHouseContract")

def deserialize_medical_house_contract(data: Union[str, dict[str, JsonElement]]) -> 'MedicalHouseContract':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.embed.DecryptedMedicalHouseContract":
		return DecryptedMedicalHouseContract._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.embed.EncryptedMedicalHouseContract":
		return EncryptedMedicalHouseContract._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of MedicalHouseContract")

@dataclass
class EncryptedSchoolingInfo:
	encrypted_self: Optional['Base64String']
	start_date: Optional[int] = None
	end_date: Optional[int] = None
	school: Optional[str] = None
	type_of_education: Optional['CodeStub'] = None

	def __serialize__(self) -> Any:
		return {
			"startDate": self.start_date,
			"endDate": self.end_date,
			"school": self.school,
			"typeOfEducation": self.type_of_education.__serialize__() if self.type_of_education is not None else None,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedSchoolingInfo':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			start_date=deserialized_dict.get("startDate"),
			end_date=deserialized_dict.get("endDate"),
			school=deserialized_dict.get("school"),
			type_of_education=CodeStub._deserialize(deserialized_dict.get("typeOfEducation")) if deserialized_dict.get("typeOfEducation") is not None else None,
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class DecryptedSchoolingInfo:
	encrypted_self: Optional['Base64String']
	start_date: Optional[int] = None
	end_date: Optional[int] = None
	school: Optional[str] = None
	type_of_education: Optional['CodeStub'] = None

	def __serialize__(self) -> Any:
		return {
			"startDate": self.start_date,
			"endDate": self.end_date,
			"school": self.school,
			"typeOfEducation": self.type_of_education.__serialize__() if self.type_of_education is not None else None,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedSchoolingInfo':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			start_date=deserialized_dict.get("startDate"),
			end_date=deserialized_dict.get("endDate"),
			school=deserialized_dict.get("school"),
			type_of_education=CodeStub._deserialize(deserialized_dict.get("typeOfEducation")) if deserialized_dict.get("typeOfEducation") is not None else None,
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

type SchoolingInfo = Union['EncryptedSchoolingInfo', 'DecryptedSchoolingInfo']

def serialize_schooling_info(schooling_info: SchoolingInfo) -> Any:
	if isinstance(schooling_info, EncryptedSchoolingInfo):
		serialized_entity = schooling_info.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.EncryptedSchoolingInfo"})
		return serialized_entity
	elif isinstance(schooling_info, DecryptedSchoolingInfo):
		serialized_entity = schooling_info.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.DecryptedSchoolingInfo"})
		return serialized_entity
	else:
		raise Exception(f"{type(schooling_info)} is not a known subclass of SchoolingInfo")

def deserialize_schooling_info(data: Union[str, dict[str, JsonElement]]) -> 'SchoolingInfo':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.embed.EncryptedSchoolingInfo":
		return EncryptedSchoolingInfo._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.embed.DecryptedSchoolingInfo":
		return DecryptedSchoolingInfo._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of SchoolingInfo")

@dataclass
class DecryptedEmploymentInfo:
	encrypted_self: Optional['Base64String']
	start_date: Optional[int] = None
	end_date: Optional[int] = None
	profession_type: Optional['CodeStub'] = None
	employer: Optional['Employer'] = None

	def __serialize__(self) -> Any:
		return {
			"startDate": self.start_date,
			"endDate": self.end_date,
			"professionType": self.profession_type.__serialize__() if self.profession_type is not None else None,
			"employer": self.employer.__serialize__() if self.employer is not None else None,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedEmploymentInfo':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			start_date=deserialized_dict.get("startDate"),
			end_date=deserialized_dict.get("endDate"),
			profession_type=CodeStub._deserialize(deserialized_dict.get("professionType")) if deserialized_dict.get("professionType") is not None else None,
			employer=Employer._deserialize(deserialized_dict.get("employer")) if deserialized_dict.get("employer") is not None else None,
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class EncryptedEmploymentInfo:
	encrypted_self: Optional['Base64String']
	start_date: Optional[int] = None
	end_date: Optional[int] = None
	profession_type: Optional['CodeStub'] = None
	employer: Optional['Employer'] = None

	def __serialize__(self) -> Any:
		return {
			"startDate": self.start_date,
			"endDate": self.end_date,
			"professionType": self.profession_type.__serialize__() if self.profession_type is not None else None,
			"employer": self.employer.__serialize__() if self.employer is not None else None,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedEmploymentInfo':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			start_date=deserialized_dict.get("startDate"),
			end_date=deserialized_dict.get("endDate"),
			profession_type=CodeStub._deserialize(deserialized_dict.get("professionType")) if deserialized_dict.get("professionType") is not None else None,
			employer=Employer._deserialize(deserialized_dict.get("employer")) if deserialized_dict.get("employer") is not None else None,
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

type EmploymentInfo = Union['DecryptedEmploymentInfo', 'EncryptedEmploymentInfo']

def serialize_employment_info(employment_info: EmploymentInfo) -> Any:
	if isinstance(employment_info, DecryptedEmploymentInfo):
		serialized_entity = employment_info.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.DecryptedEmploymentInfo"})
		return serialized_entity
	elif isinstance(employment_info, EncryptedEmploymentInfo):
		serialized_entity = employment_info.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.EncryptedEmploymentInfo"})
		return serialized_entity
	else:
		raise Exception(f"{type(employment_info)} is not a known subclass of EmploymentInfo")

def deserialize_employment_info(data: Union[str, dict[str, JsonElement]]) -> 'EmploymentInfo':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.embed.DecryptedEmploymentInfo":
		return DecryptedEmploymentInfo._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.embed.EncryptedEmploymentInfo":
		return EncryptedEmploymentInfo._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of EmploymentInfo")

class UsersType(Enum):
	Database = "database"
	Ldap = "ldap"
	Token = "token"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'UsersType':
		if data == "database":
			return UsersType.Database
		elif data == "ldap":
			return UsersType.Ldap
		elif data == "token":
			return UsersType.Token
		else:
			raise Exception(f"{data} is not a valid value for UsersType enum.")

class UsersStatus(Enum):
	Active = "ACTIVE"
	Disabled = "DISABLED"
	Registering = "REGISTERING"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'UsersStatus':
		if data == "ACTIVE":
			return UsersStatus.Active
		elif data == "DISABLED":
			return UsersStatus.Disabled
		elif data == "REGISTERING":
			return UsersStatus.Registering
		else:
			raise Exception(f"{data} is not a valid value for UsersStatus enum.")

class DelegationTag(Enum):
	All = "all"
	AdministrativeData = "administrativeData"
	AnonymousMedicalInformation = "anonymousMedicalInformation"
	GeneralInformation = "generalInformation"
	FinancialInformation = "financialInformation"
	MedicalInformation = "medicalInformation"
	SensitiveInformation = "sensitiveInformation"
	ConfidentialInformation = "confidentialInformation"
	CdItemRisk = "cdItemRisk"
	CdItemFamilyRisk = "cdItemFamilyRisk"
	CdItemHealthcareelement = "cdItemHealthcareelement"
	CdItemHealthcareapproach = "cdItemHealthcareapproach"
	CdItemAllergy = "cdItemAllergy"
	CdItemDiagnosis = "cdItemDiagnosis"
	CdItemLab = "cdItemLab"
	CdItemResult = "cdItemResult"
	CdItemParameter = "cdItemParameter"
	CdItemMedication = "cdItemMedication"
	CdItemTreatment = "cdItemTreatment"
	CdItemVaccine = "cdItemVaccine"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DelegationTag':
		if data == "all":
			return DelegationTag.All
		elif data == "administrativeData":
			return DelegationTag.AdministrativeData
		elif data == "anonymousMedicalInformation":
			return DelegationTag.AnonymousMedicalInformation
		elif data == "generalInformation":
			return DelegationTag.GeneralInformation
		elif data == "financialInformation":
			return DelegationTag.FinancialInformation
		elif data == "medicalInformation":
			return DelegationTag.MedicalInformation
		elif data == "sensitiveInformation":
			return DelegationTag.SensitiveInformation
		elif data == "confidentialInformation":
			return DelegationTag.ConfidentialInformation
		elif data == "cdItemRisk":
			return DelegationTag.CdItemRisk
		elif data == "cdItemFamilyRisk":
			return DelegationTag.CdItemFamilyRisk
		elif data == "cdItemHealthcareelement":
			return DelegationTag.CdItemHealthcareelement
		elif data == "cdItemHealthcareapproach":
			return DelegationTag.CdItemHealthcareapproach
		elif data == "cdItemAllergy":
			return DelegationTag.CdItemAllergy
		elif data == "cdItemDiagnosis":
			return DelegationTag.CdItemDiagnosis
		elif data == "cdItemLab":
			return DelegationTag.CdItemLab
		elif data == "cdItemResult":
			return DelegationTag.CdItemResult
		elif data == "cdItemParameter":
			return DelegationTag.CdItemParameter
		elif data == "cdItemMedication":
			return DelegationTag.CdItemMedication
		elif data == "cdItemTreatment":
			return DelegationTag.CdItemTreatment
		elif data == "cdItemVaccine":
			return DelegationTag.CdItemVaccine
		else:
			raise Exception(f"{data} is not a valid value for DelegationTag enum.")

@dataclass
class AuthenticationToken:
	creation_time: int
	validity: int
	token: Optional[str] = None
	deletion_date: Optional[int] = None

	def __serialize__(self) -> Any:
		return {
			"token": self.token,
			"creationTime": self.creation_time,
			"validity": self.validity,
			"deletionDate": self.deletion_date,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'AuthenticationToken':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			token=deserialized_dict.get("token"),
			creation_time=deserialized_dict["creationTime"],
			validity=deserialized_dict["validity"],
			deletion_date=deserialized_dict.get("deletionDate"),
		)

class RequestedPermission(Enum):
	MaxRead = "MAX_READ"
	FullRead = "FULL_READ"
	MaxWrite = "MAX_WRITE"
	FullWrite = "FULL_WRITE"
	Root = "ROOT"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'RequestedPermission':
		if data == "MAX_READ":
			return RequestedPermission.MaxRead
		elif data == "FULL_READ":
			return RequestedPermission.FullRead
		elif data == "MAX_WRITE":
			return RequestedPermission.MaxWrite
		elif data == "FULL_WRITE":
			return RequestedPermission.FullWrite
		elif data == "ROOT":
			return RequestedPermission.Root
		else:
			raise Exception(f"{data} is not a valid value for RequestedPermission enum.")

class ShareMetadataBehaviour(Enum):
	Required = "REQUIRED"
	IfAvailable = "IF_AVAILABLE"
	Never = "NEVER"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ShareMetadataBehaviour':
		if data == "REQUIRED":
			return ShareMetadataBehaviour.Required
		elif data == "IF_AVAILABLE":
			return ShareMetadataBehaviour.IfAvailable
		elif data == "NEVER":
			return ShareMetadataBehaviour.Never
		else:
			raise Exception(f"{data} is not a valid value for ShareMetadataBehaviour enum.")

@dataclass
class SecretIdShareOptionsAllAvailable:
	require_at_least_one: bool = False

	def __serialize__(self) -> Any:
		return {
			"requireAtLeastOne": self.require_at_least_one,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'SecretIdShareOptionsAllAvailable':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			require_at_least_one=deserialized_dict["requireAtLeastOne"],
		)

@dataclass
class SecretIdShareOptionsUseExactly:
	secret_ids: set[str]
	create_unknown_secret_ids: bool

	def __serialize__(self) -> Any:
		return {
			"secretIds": [x0 for x0 in self.secret_ids],
			"createUnknownSecretIds": self.create_unknown_secret_ids,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'SecretIdShareOptionsUseExactly':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			secret_ids={x0 for x0 in deserialized_dict["secretIds"]},
			create_unknown_secret_ids=deserialized_dict["createUnknownSecretIds"],
		)

type SecretIdShareOptions = Union['SecretIdShareOptionsAllAvailable', 'SecretIdShareOptionsUseExactly']

def serialize_secret_id_share_options(secret_id_share_options: SecretIdShareOptions) -> Any:
	if isinstance(secret_id_share_options, SecretIdShareOptionsAllAvailable):
		serialized_entity = secret_id_share_options.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.AllAvailable"})
		return serialized_entity
	elif isinstance(secret_id_share_options, SecretIdShareOptionsUseExactly):
		serialized_entity = secret_id_share_options.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.UseExactly"})
		return serialized_entity
	else:
		raise Exception(f"{type(secret_id_share_options)} is not a known subclass of SecretIdShareOptions")

def deserialize_secret_id_share_options(data: Union[str, dict[str, JsonElement]]) -> 'SecretIdShareOptions':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.AllAvailable":
		return SecretIdShareOptionsAllAvailable._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.UseExactly":
		return SecretIdShareOptionsUseExactly._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of SecretIdShareOptions")

@dataclass
class EncryptedCalendarItemTag:
	encrypted_self: Optional['Base64String']
	code: Optional[str] = None
	date: Optional[int] = None
	user_id: Optional[str] = None
	user_name: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"code": self.code,
			"date": self.date,
			"userId": self.user_id,
			"userName": self.user_name,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedCalendarItemTag':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			code=deserialized_dict.get("code"),
			date=deserialized_dict.get("date"),
			user_id=deserialized_dict.get("userId"),
			user_name=deserialized_dict.get("userName"),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class DecryptedCalendarItemTag:
	encrypted_self: Optional['Base64String']
	code: Optional[str] = None
	date: Optional[int] = None
	user_id: Optional[str] = None
	user_name: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"code": self.code,
			"date": self.date,
			"userId": self.user_id,
			"userName": self.user_name,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedCalendarItemTag':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			code=deserialized_dict.get("code"),
			date=deserialized_dict.get("date"),
			user_id=deserialized_dict.get("userId"),
			user_name=deserialized_dict.get("userName"),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

type CalendarItemTag = Union['EncryptedCalendarItemTag', 'DecryptedCalendarItemTag']

def serialize_calendar_item_tag(calendar_item_tag: CalendarItemTag) -> Any:
	if isinstance(calendar_item_tag, EncryptedCalendarItemTag):
		serialized_entity = calendar_item_tag.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.EncryptedCalendarItemTag"})
		return serialized_entity
	elif isinstance(calendar_item_tag, DecryptedCalendarItemTag):
		serialized_entity = calendar_item_tag.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.DecryptedCalendarItemTag"})
		return serialized_entity
	else:
		raise Exception(f"{type(calendar_item_tag)} is not a known subclass of CalendarItemTag")

def deserialize_calendar_item_tag(data: Union[str, dict[str, JsonElement]]) -> 'CalendarItemTag':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.embed.EncryptedCalendarItemTag":
		return EncryptedCalendarItemTag._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.embed.DecryptedCalendarItemTag":
		return DecryptedCalendarItemTag._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of CalendarItemTag")

@dataclass
class FlowItem:
	id: Optional[str] = None
	title: Optional[str] = None
	comment: Optional[str] = None
	reception_date: Optional[int] = None
	processing_date: Optional[int] = None
	processer: Optional[str] = None
	cancellation_date: Optional[int] = None
	canceller: Optional[str] = None
	cancellation_reason: Optional[str] = None
	cancellation_note: Optional[str] = None
	status: Optional[str] = None
	home_visit: Optional[bool] = None
	municipality: Optional[str] = None
	town: Optional[str] = None
	zip_code: Optional[str] = None
	street: Optional[str] = None
	building: Optional[str] = None
	building_number: Optional[str] = None
	doorbell_name: Optional[str] = None
	floor: Optional[str] = None
	letter_box: Optional[str] = None
	notes_ops: Optional[str] = None
	notes_contact: Optional[str] = None
	latitude: Optional[str] = None
	longitude: Optional[str] = None
	type: Optional[str] = None
	emergency: Optional[bool] = None
	phone_number: Optional[str] = None
	patient_id: Optional[str] = None
	patient_last_name: Optional[str] = None
	patient_first_name: Optional[str] = None
	description: Optional[str] = None
	intervention_code: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"title": self.title,
			"comment": self.comment,
			"receptionDate": self.reception_date,
			"processingDate": self.processing_date,
			"processer": self.processer,
			"cancellationDate": self.cancellation_date,
			"canceller": self.canceller,
			"cancellationReason": self.cancellation_reason,
			"cancellationNote": self.cancellation_note,
			"status": self.status,
			"homeVisit": self.home_visit,
			"municipality": self.municipality,
			"town": self.town,
			"zipCode": self.zip_code,
			"street": self.street,
			"building": self.building,
			"buildingNumber": self.building_number,
			"doorbellName": self.doorbell_name,
			"floor": self.floor,
			"letterBox": self.letter_box,
			"notesOps": self.notes_ops,
			"notesContact": self.notes_contact,
			"latitude": self.latitude,
			"longitude": self.longitude,
			"type": self.type,
			"emergency": self.emergency,
			"phoneNumber": self.phone_number,
			"patientId": self.patient_id,
			"patientLastName": self.patient_last_name,
			"patientFirstName": self.patient_first_name,
			"description": self.description,
			"interventionCode": self.intervention_code,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'FlowItem':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict.get("id"),
			title=deserialized_dict.get("title"),
			comment=deserialized_dict.get("comment"),
			reception_date=deserialized_dict.get("receptionDate"),
			processing_date=deserialized_dict.get("processingDate"),
			processer=deserialized_dict.get("processer"),
			cancellation_date=deserialized_dict.get("cancellationDate"),
			canceller=deserialized_dict.get("canceller"),
			cancellation_reason=deserialized_dict.get("cancellationReason"),
			cancellation_note=deserialized_dict.get("cancellationNote"),
			status=deserialized_dict.get("status"),
			home_visit=deserialized_dict.get("homeVisit"),
			municipality=deserialized_dict.get("municipality"),
			town=deserialized_dict.get("town"),
			zip_code=deserialized_dict.get("zipCode"),
			street=deserialized_dict.get("street"),
			building=deserialized_dict.get("building"),
			building_number=deserialized_dict.get("buildingNumber"),
			doorbell_name=deserialized_dict.get("doorbellName"),
			floor=deserialized_dict.get("floor"),
			letter_box=deserialized_dict.get("letterBox"),
			notes_ops=deserialized_dict.get("notesOps"),
			notes_contact=deserialized_dict.get("notesContact"),
			latitude=deserialized_dict.get("latitude"),
			longitude=deserialized_dict.get("longitude"),
			type=deserialized_dict.get("type"),
			emergency=deserialized_dict.get("emergency"),
			phone_number=deserialized_dict.get("phoneNumber"),
			patient_id=deserialized_dict.get("patientId"),
			patient_last_name=deserialized_dict.get("patientLastName"),
			patient_first_name=deserialized_dict.get("patientFirstName"),
			description=deserialized_dict.get("description"),
			intervention_code=deserialized_dict.get("interventionCode"),
		)

class TaskStatus(Enum):
	Pending = "pending"
	Ongoing = "ongoing"
	Cancelled = "cancelled"
	Completed = "completed"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'TaskStatus':
		if data == "pending":
			return TaskStatus.Pending
		elif data == "ongoing":
			return TaskStatus.Ongoing
		elif data == "cancelled":
			return TaskStatus.Cancelled
		elif data == "completed":
			return TaskStatus.Completed
		else:
			raise Exception(f"{data} is not a valid value for TaskStatus enum.")

@dataclass
class FormTemplateLayout:
	form: str
	actions: list['Action'] = field(default_factory=list)
	sections: list['Section'] = field(default_factory=list)
	description: Optional[str] = None
	keywords: Optional[list[str]] = None

	def __serialize__(self) -> Any:
		return {
			"form": self.form,
			"actions": [x0.__serialize__() for x0 in self.actions],
			"sections": [x0.__serialize__() for x0 in self.sections],
			"description": self.description,
			"keywords": [x0 for x0 in self.keywords] if self.keywords is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'FormTemplateLayout':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			form=deserialized_dict["form"],
			actions=[Action._deserialize(x0) for x0 in deserialized_dict["actions"]],
			sections=[Section._deserialize(x0) for x0 in deserialized_dict["sections"]],
			description=deserialized_dict.get("description"),
			keywords=[x0 for x0 in deserialized_dict.get("keywords")] if deserialized_dict.get("keywords") is not None else None,
		)

@dataclass
class DocumentGroup:
	guid: Optional[str] = None
	name: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"guid": self.guid,
			"name": self.name,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DocumentGroup':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			guid=deserialized_dict.get("guid"),
			name=deserialized_dict.get("name"),
		)

@dataclass
class FailedRequestDetails:
	entity_id: str
	delegate_reference: 'EntityReferenceInGroup'
	updated_for_migration: bool
	code: Optional[int]
	reason: Optional[str]
	request: Optional['DelegateShareOptions']
	should_retry: bool

	def __serialize__(self) -> Any:
		return {
			"entityId": self.entity_id,
			"delegateReference": self.delegate_reference.__serialize__(),
			"updatedForMigration": self.updated_for_migration,
			"code": self.code,
			"reason": self.reason,
			"request": self.request.__serialize__() if self.request is not None else None,
			"shouldRetry": self.should_retry,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'FailedRequestDetails':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			entity_id=deserialized_dict["entityId"],
			delegate_reference=EntityReferenceInGroup._deserialize(deserialized_dict["delegateReference"]),
			updated_for_migration=deserialized_dict["updatedForMigration"],
			code=deserialized_dict.get("code"),
			reason=deserialized_dict.get("reason"),
			request=DelegateShareOptions._deserialize(deserialized_dict.get("request")) if deserialized_dict.get("request") is not None else None,
			should_retry=deserialized_dict["shouldRetry"],
		)

@dataclass(frozen=True)
class Periodicity:
	related_code: Optional['CodeStub'] = None
	related_periodicity: Optional['CodeStub'] = None

	def __serialize__(self) -> Any:
		return {
			"relatedCode": self.related_code.__serialize__() if self.related_code is not None else None,
			"relatedPeriodicity": self.related_periodicity.__serialize__() if self.related_periodicity is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Periodicity':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			related_code=CodeStub._deserialize(deserialized_dict.get("relatedCode")) if deserialized_dict.get("relatedCode") is not None else None,
			related_periodicity=CodeStub._deserialize(deserialized_dict.get("relatedPeriodicity")) if deserialized_dict.get("relatedPeriodicity") is not None else None,
		)

class LinkQualification(Enum):
	Exact = "exact"
	Narrower = "narrower"
	Broader = "broader"
	Approximate = "approximate"
	Sequence = "sequence"
	Parent = "parent"
	Child = "child"
	RelatedCode = "relatedCode"
	LinkedPackage = "linkedPackage"
	RelatedService = "relatedService"
	InResponseTo = "inResponseTo"
	Replaces = "replaces"
	Transforms = "transforms"
	TransformsAndReplaces = "transformsAndReplaces"
	AppendsTo = "appendsTo"
	BasedOn = "basedOn"
	DerivedFrom = "derivedFrom"
	Device = "device"
	Focus = "focus"
	HasMember = "hasMember"
	Performer = "performer"
	Specimen = "specimen"
	ResultInterpreter = "resultInterpreter"
	Request = "request"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'LinkQualification':
		if data == "exact":
			return LinkQualification.Exact
		elif data == "narrower":
			return LinkQualification.Narrower
		elif data == "broader":
			return LinkQualification.Broader
		elif data == "approximate":
			return LinkQualification.Approximate
		elif data == "sequence":
			return LinkQualification.Sequence
		elif data == "parent":
			return LinkQualification.Parent
		elif data == "child":
			return LinkQualification.Child
		elif data == "relatedCode":
			return LinkQualification.RelatedCode
		elif data == "linkedPackage":
			return LinkQualification.LinkedPackage
		elif data == "relatedService":
			return LinkQualification.RelatedService
		elif data == "inResponseTo":
			return LinkQualification.InResponseTo
		elif data == "replaces":
			return LinkQualification.Replaces
		elif data == "transforms":
			return LinkQualification.Transforms
		elif data == "transformsAndReplaces":
			return LinkQualification.TransformsAndReplaces
		elif data == "appendsTo":
			return LinkQualification.AppendsTo
		elif data == "basedOn":
			return LinkQualification.BasedOn
		elif data == "derivedFrom":
			return LinkQualification.DerivedFrom
		elif data == "device":
			return LinkQualification.Device
		elif data == "focus":
			return LinkQualification.Focus
		elif data == "hasMember":
			return LinkQualification.HasMember
		elif data == "performer":
			return LinkQualification.Performer
		elif data == "specimen":
			return LinkQualification.Specimen
		elif data == "resultInterpreter":
			return LinkQualification.ResultInterpreter
		elif data == "request":
			return LinkQualification.Request
		else:
			raise Exception(f"{data} is not a valid value for LinkQualification enum.")

class CodeFlag(Enum):
	MaleOnly = "male_only"
	FemaleOnly = "female_only"
	Deptkinesitherapy = "deptkinesitherapy"
	Deptnursing = "deptnursing"
	Deptgeneralpractice = "deptgeneralpractice"
	Deptsocialworker = "deptsocialworker"
	Deptpsychology = "deptpsychology"
	Deptadministrative = "deptadministrative"
	Deptdietetics = "deptdietetics"
	Deptspeechtherapy = "deptspeechtherapy"
	Deptdentistry = "deptdentistry"
	Deptoccupationaltherapy = "deptoccupationaltherapy"
	Depthealthcare = "depthealthcare"
	Deptgynecology = "deptgynecology"
	Deptpediatry = "deptpediatry"
	Deptalgology = "deptalgology"
	Deptanatomopathology = "deptanatomopathology"
	Deptanesthesiology = "deptanesthesiology"
	Deptbacteriology = "deptbacteriology"
	Deptcardiacsurgery = "deptcardiacsurgery"
	Deptcardiology = "deptcardiology"
	Deptchildandadolescentpsychiatry = "deptchildandadolescentpsychiatry"
	Deptdermatology = "deptdermatology"
	Deptdiabetology = "deptdiabetology"
	Deptemergency = "deptemergency"
	Deptendocrinology = "deptendocrinology"
	Deptgastroenterology = "deptgastroenterology"
	Deptgenetics = "deptgenetics"
	Deptgeriatry = "deptgeriatry"
	Depthandsurgery = "depthandsurgery"
	Depthematology = "depthematology"
	Deptinfectiousdisease = "deptinfectiousdisease"
	Deptintensivecare = "deptintensivecare"
	Deptlaboratory = "deptlaboratory"
	Deptmajorburns = "deptmajorburns"
	Deptmaxillofacialsurgery = "deptmaxillofacialsurgery"
	Deptmedicine = "deptmedicine"
	Deptmolecularbiology = "deptmolecularbiology"
	Deptneonatalogy = "deptneonatalogy"
	Deptnephrology = "deptnephrology"
	Deptneurology = "deptneurology"
	Deptneurosurgery = "deptneurosurgery"
	Deptnte = "deptnte"
	Deptnuclear = "deptnuclear"
	Deptnutritiondietetics = "deptnutritiondietetics"
	Deptobstetrics = "deptobstetrics"
	Deptoncology = "deptoncology"
	Deptophtalmology = "deptophtalmology"
	Deptorthopedy = "deptorthopedy"
	Deptpalliativecare = "deptpalliativecare"
	Deptpediatricintensivecare = "deptpediatricintensivecare"
	Deptpediatricsurgery = "deptpediatricsurgery"
	Deptpharmacy = "deptpharmacy"
	Deptphysicalmedecine = "deptphysicalmedecine"
	Deptphysiotherapy = "deptphysiotherapy"
	Deptplasticandreparatorysurgery = "deptplasticandreparatorysurgery"
	Deptpneumology = "deptpneumology"
	Deptpodiatry = "deptpodiatry"
	Deptpsychiatry = "deptpsychiatry"
	Deptradiology = "deptradiology"
	Deptradiotherapy = "deptradiotherapy"
	Deptrevalidation = "deptrevalidation"
	Deptrheumatology = "deptrheumatology"
	Deptrhumatology = "deptrhumatology"
	Deptsenology = "deptsenology"
	Deptsocialservice = "deptsocialservice"
	Deptsportsmedecine = "deptsportsmedecine"
	Deptstomatology = "deptstomatology"
	Deptsurgery = "deptsurgery"
	Deptthoracicsurgery = "deptthoracicsurgery"
	Depttoxicology = "depttoxicology"
	Depttropicalmedecine = "depttropicalmedecine"
	Depturology = "depturology"
	Deptvascularsurgery = "deptvascularsurgery"
	Deptvisceraldigestiveabdominalsurgery = "deptvisceraldigestiveabdominalsurgery"
	Depttransplantsurgery = "depttransplantsurgery"
	Deptpercutaneous = "deptpercutaneous"
	Deptchildbirth = "deptchildbirth"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'CodeFlag':
		if data == "male_only":
			return CodeFlag.MaleOnly
		elif data == "female_only":
			return CodeFlag.FemaleOnly
		elif data == "deptkinesitherapy":
			return CodeFlag.Deptkinesitherapy
		elif data == "deptnursing":
			return CodeFlag.Deptnursing
		elif data == "deptgeneralpractice":
			return CodeFlag.Deptgeneralpractice
		elif data == "deptsocialworker":
			return CodeFlag.Deptsocialworker
		elif data == "deptpsychology":
			return CodeFlag.Deptpsychology
		elif data == "deptadministrative":
			return CodeFlag.Deptadministrative
		elif data == "deptdietetics":
			return CodeFlag.Deptdietetics
		elif data == "deptspeechtherapy":
			return CodeFlag.Deptspeechtherapy
		elif data == "deptdentistry":
			return CodeFlag.Deptdentistry
		elif data == "deptoccupationaltherapy":
			return CodeFlag.Deptoccupationaltherapy
		elif data == "depthealthcare":
			return CodeFlag.Depthealthcare
		elif data == "deptgynecology":
			return CodeFlag.Deptgynecology
		elif data == "deptpediatry":
			return CodeFlag.Deptpediatry
		elif data == "deptalgology":
			return CodeFlag.Deptalgology
		elif data == "deptanatomopathology":
			return CodeFlag.Deptanatomopathology
		elif data == "deptanesthesiology":
			return CodeFlag.Deptanesthesiology
		elif data == "deptbacteriology":
			return CodeFlag.Deptbacteriology
		elif data == "deptcardiacsurgery":
			return CodeFlag.Deptcardiacsurgery
		elif data == "deptcardiology":
			return CodeFlag.Deptcardiology
		elif data == "deptchildandadolescentpsychiatry":
			return CodeFlag.Deptchildandadolescentpsychiatry
		elif data == "deptdermatology":
			return CodeFlag.Deptdermatology
		elif data == "deptdiabetology":
			return CodeFlag.Deptdiabetology
		elif data == "deptemergency":
			return CodeFlag.Deptemergency
		elif data == "deptendocrinology":
			return CodeFlag.Deptendocrinology
		elif data == "deptgastroenterology":
			return CodeFlag.Deptgastroenterology
		elif data == "deptgenetics":
			return CodeFlag.Deptgenetics
		elif data == "deptgeriatry":
			return CodeFlag.Deptgeriatry
		elif data == "depthandsurgery":
			return CodeFlag.Depthandsurgery
		elif data == "depthematology":
			return CodeFlag.Depthematology
		elif data == "deptinfectiousdisease":
			return CodeFlag.Deptinfectiousdisease
		elif data == "deptintensivecare":
			return CodeFlag.Deptintensivecare
		elif data == "deptlaboratory":
			return CodeFlag.Deptlaboratory
		elif data == "deptmajorburns":
			return CodeFlag.Deptmajorburns
		elif data == "deptmaxillofacialsurgery":
			return CodeFlag.Deptmaxillofacialsurgery
		elif data == "deptmedicine":
			return CodeFlag.Deptmedicine
		elif data == "deptmolecularbiology":
			return CodeFlag.Deptmolecularbiology
		elif data == "deptneonatalogy":
			return CodeFlag.Deptneonatalogy
		elif data == "deptnephrology":
			return CodeFlag.Deptnephrology
		elif data == "deptneurology":
			return CodeFlag.Deptneurology
		elif data == "deptneurosurgery":
			return CodeFlag.Deptneurosurgery
		elif data == "deptnte":
			return CodeFlag.Deptnte
		elif data == "deptnuclear":
			return CodeFlag.Deptnuclear
		elif data == "deptnutritiondietetics":
			return CodeFlag.Deptnutritiondietetics
		elif data == "deptobstetrics":
			return CodeFlag.Deptobstetrics
		elif data == "deptoncology":
			return CodeFlag.Deptoncology
		elif data == "deptophtalmology":
			return CodeFlag.Deptophtalmology
		elif data == "deptorthopedy":
			return CodeFlag.Deptorthopedy
		elif data == "deptpalliativecare":
			return CodeFlag.Deptpalliativecare
		elif data == "deptpediatricintensivecare":
			return CodeFlag.Deptpediatricintensivecare
		elif data == "deptpediatricsurgery":
			return CodeFlag.Deptpediatricsurgery
		elif data == "deptpharmacy":
			return CodeFlag.Deptpharmacy
		elif data == "deptphysicalmedecine":
			return CodeFlag.Deptphysicalmedecine
		elif data == "deptphysiotherapy":
			return CodeFlag.Deptphysiotherapy
		elif data == "deptplasticandreparatorysurgery":
			return CodeFlag.Deptplasticandreparatorysurgery
		elif data == "deptpneumology":
			return CodeFlag.Deptpneumology
		elif data == "deptpodiatry":
			return CodeFlag.Deptpodiatry
		elif data == "deptpsychiatry":
			return CodeFlag.Deptpsychiatry
		elif data == "deptradiology":
			return CodeFlag.Deptradiology
		elif data == "deptradiotherapy":
			return CodeFlag.Deptradiotherapy
		elif data == "deptrevalidation":
			return CodeFlag.Deptrevalidation
		elif data == "deptrheumatology":
			return CodeFlag.Deptrheumatology
		elif data == "deptrhumatology":
			return CodeFlag.Deptrhumatology
		elif data == "deptsenology":
			return CodeFlag.Deptsenology
		elif data == "deptsocialservice":
			return CodeFlag.Deptsocialservice
		elif data == "deptsportsmedecine":
			return CodeFlag.Deptsportsmedecine
		elif data == "deptstomatology":
			return CodeFlag.Deptstomatology
		elif data == "deptsurgery":
			return CodeFlag.Deptsurgery
		elif data == "deptthoracicsurgery":
			return CodeFlag.Deptthoracicsurgery
		elif data == "depttoxicology":
			return CodeFlag.Depttoxicology
		elif data == "depttropicalmedecine":
			return CodeFlag.Depttropicalmedecine
		elif data == "depturology":
			return CodeFlag.Depturology
		elif data == "deptvascularsurgery":
			return CodeFlag.Deptvascularsurgery
		elif data == "deptvisceraldigestiveabdominalsurgery":
			return CodeFlag.Deptvisceraldigestiveabdominalsurgery
		elif data == "depttransplantsurgery":
			return CodeFlag.Depttransplantsurgery
		elif data == "deptpercutaneous":
			return CodeFlag.Deptpercutaneous
		elif data == "deptchildbirth":
			return CodeFlag.Deptchildbirth
		else:
			raise Exception(f"{data} is not a valid value for CodeFlag enum.")

class AppendixType(Enum):
	ExternalLink = "externalLink"
	Video = "video"
	Description = "description"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'AppendixType':
		if data == "externalLink":
			return AppendixType.ExternalLink
		elif data == "video":
			return AppendixType.Video
		elif data == "description":
			return AppendixType.Description
		else:
			raise Exception(f"{data} is not a valid value for AppendixType enum.")

@dataclass
class EncryptedValorisation:
	start_of_validity: Optional[int] = None
	end_of_validity: Optional[int] = None
	predicate: Optional[str] = None
	reference: Optional[list[int]] = None
	total_amount: Optional[float] = None
	reimbursement: Optional[float] = None
	patient_intervention: Optional[float] = None
	doctor_supplement: Optional[float] = None
	vat: Optional[float] = None
	label: Optional[dict[str, str]] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"startOfValidity": self.start_of_validity,
			"endOfValidity": self.end_of_validity,
			"predicate": self.predicate,
			"reference": [x0 for x0 in self.reference] if self.reference is not None else None,
			"totalAmount": self.total_amount,
			"reimbursement": self.reimbursement,
			"patientIntervention": self.patient_intervention,
			"doctorSupplement": self.doctor_supplement,
			"vat": self.vat,
			"label": {k0: v0 for k0, v0 in self.label.items()} if self.label is not None else None,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedValorisation':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			start_of_validity=deserialized_dict.get("startOfValidity"),
			end_of_validity=deserialized_dict.get("endOfValidity"),
			predicate=deserialized_dict.get("predicate"),
			reference=[x0 for x0 in deserialized_dict.get("reference")] if deserialized_dict.get("reference") is not None else None,
			total_amount=deserialized_dict.get("totalAmount"),
			reimbursement=deserialized_dict.get("reimbursement"),
			patient_intervention=deserialized_dict.get("patientIntervention"),
			doctor_supplement=deserialized_dict.get("doctorSupplement"),
			vat=deserialized_dict.get("vat"),
			label=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("label").items())) if deserialized_dict.get("label") is not None else None,
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class DecryptedValorisation:
	start_of_validity: Optional[int] = None
	end_of_validity: Optional[int] = None
	predicate: Optional[str] = None
	reference: Optional[list[int]] = None
	total_amount: Optional[float] = None
	reimbursement: Optional[float] = None
	patient_intervention: Optional[float] = None
	doctor_supplement: Optional[float] = None
	vat: Optional[float] = None
	label: Optional[dict[str, str]] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"startOfValidity": self.start_of_validity,
			"endOfValidity": self.end_of_validity,
			"predicate": self.predicate,
			"reference": [x0 for x0 in self.reference] if self.reference is not None else None,
			"totalAmount": self.total_amount,
			"reimbursement": self.reimbursement,
			"patientIntervention": self.patient_intervention,
			"doctorSupplement": self.doctor_supplement,
			"vat": self.vat,
			"label": {k0: v0 for k0, v0 in self.label.items()} if self.label is not None else None,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedValorisation':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			start_of_validity=deserialized_dict.get("startOfValidity"),
			end_of_validity=deserialized_dict.get("endOfValidity"),
			predicate=deserialized_dict.get("predicate"),
			reference=[x0 for x0 in deserialized_dict.get("reference")] if deserialized_dict.get("reference") is not None else None,
			total_amount=deserialized_dict.get("totalAmount"),
			reimbursement=deserialized_dict.get("reimbursement"),
			patient_intervention=deserialized_dict.get("patientIntervention"),
			doctor_supplement=deserialized_dict.get("doctorSupplement"),
			vat=deserialized_dict.get("vat"),
			label=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("label").items())) if deserialized_dict.get("label") is not None else None,
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

type Valorisation = Union['EncryptedValorisation', 'DecryptedValorisation']

def serialize_valorisation(valorisation: Valorisation) -> Any:
	if isinstance(valorisation, EncryptedValorisation):
		serialized_entity = valorisation.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.EncryptedValorisation"})
		return serialized_entity
	elif isinstance(valorisation, DecryptedValorisation):
		serialized_entity = valorisation.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.DecryptedValorisation"})
		return serialized_entity
	else:
		raise Exception(f"{type(valorisation)} is not a known subclass of Valorisation")

def deserialize_valorisation(data: Union[str, dict[str, JsonElement]]) -> 'Valorisation':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.embed.EncryptedValorisation":
		return EncryptedValorisation._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.embed.DecryptedValorisation":
		return DecryptedValorisation._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of Valorisation")

@dataclass
class LetterValue:
	letter: Optional[str] = None
	index: Optional[str] = None
	coefficient: Optional[float] = None
	value: Optional[float] = None

	def __serialize__(self) -> Any:
		return {
			"letter": self.letter,
			"index": self.index,
			"coefficient": self.coefficient,
			"value": self.value,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'LetterValue':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			letter=deserialized_dict.get("letter"),
			index=deserialized_dict.get("index"),
			coefficient=deserialized_dict.get("coefficient"),
			value=deserialized_dict.get("value"),
		)

@dataclass
class EncryptedSubContact:
	id: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	descr: Optional[str] = None
	protocol: Optional[str] = None
	status: Optional[int] = None
	form_id: Optional[str] = None
	plan_of_action_id: Optional[str] = None
	health_element_id: Optional[str] = None
	classification_id: Optional[str] = None
	services: list['ServiceLink'] = field(default_factory=list)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"descr": self.descr,
			"protocol": self.protocol,
			"status": self.status,
			"formId": self.form_id,
			"planOfActionId": self.plan_of_action_id,
			"healthElementId": self.health_element_id,
			"classificationId": self.classification_id,
			"services": [x0.__serialize__() for x0 in self.services],
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedSubContact':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict.get("id"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			descr=deserialized_dict.get("descr"),
			protocol=deserialized_dict.get("protocol"),
			status=deserialized_dict.get("status"),
			form_id=deserialized_dict.get("formId"),
			plan_of_action_id=deserialized_dict.get("planOfActionId"),
			health_element_id=deserialized_dict.get("healthElementId"),
			classification_id=deserialized_dict.get("classificationId"),
			services=[ServiceLink._deserialize(x0) for x0 in deserialized_dict["services"]],
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class DecryptedSubContact:
	id: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	descr: Optional[str] = None
	protocol: Optional[str] = None
	status: Optional[int] = None
	form_id: Optional[str] = None
	plan_of_action_id: Optional[str] = None
	health_element_id: Optional[str] = None
	classification_id: Optional[str] = None
	services: list['ServiceLink'] = field(default_factory=list)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"descr": self.descr,
			"protocol": self.protocol,
			"status": self.status,
			"formId": self.form_id,
			"planOfActionId": self.plan_of_action_id,
			"healthElementId": self.health_element_id,
			"classificationId": self.classification_id,
			"services": [x0.__serialize__() for x0 in self.services],
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedSubContact':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict.get("id"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			descr=deserialized_dict.get("descr"),
			protocol=deserialized_dict.get("protocol"),
			status=deserialized_dict.get("status"),
			form_id=deserialized_dict.get("formId"),
			plan_of_action_id=deserialized_dict.get("planOfActionId"),
			health_element_id=deserialized_dict.get("healthElementId"),
			classification_id=deserialized_dict.get("classificationId"),
			services=[ServiceLink._deserialize(x0) for x0 in deserialized_dict["services"]],
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

type SubContact = Union['EncryptedSubContact', 'DecryptedSubContact']

def serialize_sub_contact(sub_contact: SubContact) -> Any:
	if isinstance(sub_contact, EncryptedSubContact):
		serialized_entity = sub_contact.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.EncryptedSubContact"})
		return serialized_entity
	elif isinstance(sub_contact, DecryptedSubContact):
		serialized_entity = sub_contact.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.DecryptedSubContact"})
		return serialized_entity
	else:
		raise Exception(f"{type(sub_contact)} is not a known subclass of SubContact")

def deserialize_sub_contact(data: Union[str, dict[str, JsonElement]]) -> 'SubContact':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.embed.EncryptedSubContact":
		return EncryptedSubContact._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.embed.DecryptedSubContact":
		return DecryptedSubContact._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of SubContact")

class ParticipantType(Enum):
	Admitter = "admitter"
	Attender = "attender"
	CallbackContact = "callback"
	Consultant = "consultant"
	Discharger = "discharger"
	Escort = "escort"
	Referrer = "referrer"
	SecondaryPerformer = "secondaryPerformer"
	PrimaryPerformer = "primaryPerformer"
	Participation = "participation"
	Translator = "translator"
	Emergency = "emergency"
	Location = "location"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ParticipantType':
		if data == "admitter":
			return ParticipantType.Admitter
		elif data == "attender":
			return ParticipantType.Attender
		elif data == "callback":
			return ParticipantType.CallbackContact
		elif data == "consultant":
			return ParticipantType.Consultant
		elif data == "discharger":
			return ParticipantType.Discharger
		elif data == "escort":
			return ParticipantType.Escort
		elif data == "referrer":
			return ParticipantType.Referrer
		elif data == "secondaryPerformer":
			return ParticipantType.SecondaryPerformer
		elif data == "primaryPerformer":
			return ParticipantType.PrimaryPerformer
		elif data == "participation":
			return ParticipantType.Participation
		elif data == "translator":
			return ParticipantType.Translator
		elif data == "emergency":
			return ParticipantType.Emergency
		elif data == "location":
			return ParticipantType.Location
		else:
			raise Exception(f"{data} is not a valid value for ParticipantType enum.")

@dataclass
class EncryptedContent:
	string_value: Optional[str] = None
	number_value: Optional[float] = None
	boolean_value: Optional[bool] = None
	instant_value: Optional[int] = None
	fuzzy_date_value: Optional[int] = None
	binary_value: Optional[bytearray] = None
	document_id: Optional[str] = None
	measure_value: Optional['Measure'] = None
	medication_value: Optional['Medication'] = None
	time_series: Optional['TimeSeries'] = None
	compound_value: Optional[list['EncryptedService']] = None
	ratio: Optional[list['Measure']] = None
	range: Optional[list['Measure']] = None

	def __serialize__(self) -> Any:
		return {
			"stringValue": self.string_value,
			"numberValue": self.number_value,
			"booleanValue": self.boolean_value,
			"instantValue": self.instant_value,
			"fuzzyDateValue": self.fuzzy_date_value,
			"binaryValue": base64.b64encode(self.binary_value).decode('utf-8') if self.binary_value is not None else None,
			"documentId": self.document_id,
			"measureValue": self.measure_value.__serialize__() if self.measure_value is not None else None,
			"medicationValue": self.medication_value.__serialize__() if self.medication_value is not None else None,
			"timeSeries": self.time_series.__serialize__() if self.time_series is not None else None,
			"compoundValue": [x0.__serialize__() for x0 in self.compound_value] if self.compound_value is not None else None,
			"ratio": [x0.__serialize__() for x0 in self.ratio] if self.ratio is not None else None,
			"range": [x0.__serialize__() for x0 in self.range] if self.range is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedContent':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			string_value=deserialized_dict.get("stringValue"),
			number_value=deserialized_dict.get("numberValue"),
			boolean_value=deserialized_dict.get("booleanValue"),
			instant_value=deserialized_dict.get("instantValue"),
			fuzzy_date_value=deserialized_dict.get("fuzzyDateValue"),
			binary_value=bytearray(base64.b64decode(deserialized_dict.get("binaryValue"))) if deserialized_dict.get("binaryValue") is not None else None,
			document_id=deserialized_dict.get("documentId"),
			measure_value=Measure._deserialize(deserialized_dict.get("measureValue")) if deserialized_dict.get("measureValue") is not None else None,
			medication_value=Medication._deserialize(deserialized_dict.get("medicationValue")) if deserialized_dict.get("medicationValue") is not None else None,
			time_series=TimeSeries._deserialize(deserialized_dict.get("timeSeries")) if deserialized_dict.get("timeSeries") is not None else None,
			compound_value=[EncryptedService._deserialize(x0) for x0 in deserialized_dict.get("compoundValue")] if deserialized_dict.get("compoundValue") is not None else None,
			ratio=[Measure._deserialize(x0) for x0 in deserialized_dict.get("ratio")] if deserialized_dict.get("ratio") is not None else None,
			range=[Measure._deserialize(x0) for x0 in deserialized_dict.get("range")] if deserialized_dict.get("range") is not None else None,
		)

@dataclass
class DecryptedContent:
	string_value: Optional[str] = None
	number_value: Optional[float] = None
	boolean_value: Optional[bool] = None
	instant_value: Optional[int] = None
	fuzzy_date_value: Optional[int] = None
	binary_value: Optional[bytearray] = None
	document_id: Optional[str] = None
	measure_value: Optional['Measure'] = None
	medication_value: Optional['Medication'] = None
	time_series: Optional['TimeSeries'] = None
	compound_value: Optional[list['DecryptedService']] = None
	ratio: Optional[list['Measure']] = None
	range: Optional[list['Measure']] = None

	def __serialize__(self) -> Any:
		return {
			"stringValue": self.string_value,
			"numberValue": self.number_value,
			"booleanValue": self.boolean_value,
			"instantValue": self.instant_value,
			"fuzzyDateValue": self.fuzzy_date_value,
			"binaryValue": base64.b64encode(self.binary_value).decode('utf-8') if self.binary_value is not None else None,
			"documentId": self.document_id,
			"measureValue": self.measure_value.__serialize__() if self.measure_value is not None else None,
			"medicationValue": self.medication_value.__serialize__() if self.medication_value is not None else None,
			"timeSeries": self.time_series.__serialize__() if self.time_series is not None else None,
			"compoundValue": [x0.__serialize__() for x0 in self.compound_value] if self.compound_value is not None else None,
			"ratio": [x0.__serialize__() for x0 in self.ratio] if self.ratio is not None else None,
			"range": [x0.__serialize__() for x0 in self.range] if self.range is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedContent':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			string_value=deserialized_dict.get("stringValue"),
			number_value=deserialized_dict.get("numberValue"),
			boolean_value=deserialized_dict.get("booleanValue"),
			instant_value=deserialized_dict.get("instantValue"),
			fuzzy_date_value=deserialized_dict.get("fuzzyDateValue"),
			binary_value=bytearray(base64.b64decode(deserialized_dict.get("binaryValue"))) if deserialized_dict.get("binaryValue") is not None else None,
			document_id=deserialized_dict.get("documentId"),
			measure_value=Measure._deserialize(deserialized_dict.get("measureValue")) if deserialized_dict.get("measureValue") is not None else None,
			medication_value=Medication._deserialize(deserialized_dict.get("medicationValue")) if deserialized_dict.get("medicationValue") is not None else None,
			time_series=TimeSeries._deserialize(deserialized_dict.get("timeSeries")) if deserialized_dict.get("timeSeries") is not None else None,
			compound_value=[DecryptedService._deserialize(x0) for x0 in deserialized_dict.get("compoundValue")] if deserialized_dict.get("compoundValue") is not None else None,
			ratio=[Measure._deserialize(x0) for x0 in deserialized_dict.get("ratio")] if deserialized_dict.get("ratio") is not None else None,
			range=[Measure._deserialize(x0) for x0 in deserialized_dict.get("range")] if deserialized_dict.get("range") is not None else None,
		)

type Content = Union['EncryptedContent', 'DecryptedContent']

def serialize_content(content: Content) -> Any:
	if isinstance(content, EncryptedContent):
		serialized_entity = content.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.EncryptedContent"})
		return serialized_entity
	elif isinstance(content, DecryptedContent):
		serialized_entity = content.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.DecryptedContent"})
		return serialized_entity
	else:
		raise Exception(f"{type(content)} is not a known subclass of Content")

def deserialize_content(data: Union[str, dict[str, JsonElement]]) -> 'Content':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.embed.EncryptedContent":
		return EncryptedContent._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.embed.DecryptedContent":
		return DecryptedContent._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of Content")

class ReceiptBlobType(Enum):
	Xades = "xades"
	KmehrRequest = "kmehrRequest"
	KmehrResponse = "kmehrResponse"
	SoapRequest = "soapRequest"
	SoapResponse = "soapResponse"
	SoapConversation = "soapConversation"
	Tack = "tack"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ReceiptBlobType':
		if data == "xades":
			return ReceiptBlobType.Xades
		elif data == "kmehrRequest":
			return ReceiptBlobType.KmehrRequest
		elif data == "kmehrResponse":
			return ReceiptBlobType.KmehrResponse
		elif data == "soapRequest":
			return ReceiptBlobType.SoapRequest
		elif data == "soapResponse":
			return ReceiptBlobType.SoapResponse
		elif data == "soapConversation":
			return ReceiptBlobType.SoapConversation
		elif data == "tack":
			return ReceiptBlobType.Tack
		else:
			raise Exception(f"{data} is not a valid value for ReceiptBlobType enum.")

class HealthcarePartyStatus(Enum):
	Trainee = "trainee"
	Withconvention = "withconvention"
	Accreditated = "accreditated"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'HealthcarePartyStatus':
		if data == "trainee":
			return HealthcarePartyStatus.Trainee
		elif data == "withconvention":
			return HealthcarePartyStatus.Withconvention
		elif data == "accreditated":
			return HealthcarePartyStatus.Accreditated
		else:
			raise Exception(f"{data} is not a valid value for HealthcarePartyStatus enum.")

@dataclass
class HealthcarePartyHistoryStatus:
	status: 'HealthcarePartyStatus'
	specialisation_code: str
	start_date: int
	active: bool

	def __serialize__(self) -> Any:
		return {
			"status": self.status.__serialize__(),
			"specialisationCode": self.specialisation_code,
			"startDate": self.start_date,
			"active": self.active,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'HealthcarePartyHistoryStatus':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			status=HealthcarePartyStatus._deserialize(deserialized_dict["status"]),
			specialisation_code=deserialized_dict["specialisationCode"],
			start_date=deserialized_dict["startDate"],
			active=deserialized_dict["active"],
		)

class TelecomType(Enum):
	Mobile = "mobile"
	Phone = "phone"
	Email = "email"
	Fax = "fax"
	Skype = "skype"
	Im = "im"
	Medibridge = "medibridge"
	Ehealthbox = "ehealthbox"
	Apicrypt = "apicrypt"
	Web = "web"
	Print = "print"
	Disk = "disk"
	Other = "other"
	Pager = "pager"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'TelecomType':
		if data == "mobile":
			return TelecomType.Mobile
		elif data == "phone":
			return TelecomType.Phone
		elif data == "email":
			return TelecomType.Email
		elif data == "fax":
			return TelecomType.Fax
		elif data == "skype":
			return TelecomType.Skype
		elif data == "im":
			return TelecomType.Im
		elif data == "medibridge":
			return TelecomType.Medibridge
		elif data == "ehealthbox":
			return TelecomType.Ehealthbox
		elif data == "apicrypt":
			return TelecomType.Apicrypt
		elif data == "web":
			return TelecomType.Web
		elif data == "print":
			return TelecomType.Print
		elif data == "disk":
			return TelecomType.Disk
		elif data == "other":
			return TelecomType.Other
		elif data == "pager":
			return TelecomType.Pager
		else:
			raise Exception(f"{data} is not a valid value for TelecomType enum.")

@dataclass
class EncryptedFlatRateTarification:
	code: Optional[str] = None
	flat_rate_type: Optional['FlatRateType'] = None
	label: Optional[dict[str, str]] = None
	valorisations: list['EncryptedValorisation'] = field(default_factory=list)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"code": self.code,
			"flatRateType": self.flat_rate_type.__serialize__() if self.flat_rate_type is not None else None,
			"label": {k0: v0 for k0, v0 in self.label.items()} if self.label is not None else None,
			"valorisations": [x0.__serialize__() for x0 in self.valorisations],
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedFlatRateTarification':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			code=deserialized_dict.get("code"),
			flat_rate_type=FlatRateType._deserialize(deserialized_dict.get("flatRateType")) if deserialized_dict.get("flatRateType") is not None else None,
			label=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("label").items())) if deserialized_dict.get("label") is not None else None,
			valorisations=[EncryptedValorisation._deserialize(x0) for x0 in deserialized_dict["valorisations"]],
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class DecryptedFlatRateTarification:
	code: Optional[str] = None
	flat_rate_type: Optional['FlatRateType'] = None
	label: Optional[dict[str, str]] = None
	valorisations: list['DecryptedValorisation'] = field(default_factory=list)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"code": self.code,
			"flatRateType": self.flat_rate_type.__serialize__() if self.flat_rate_type is not None else None,
			"label": {k0: v0 for k0, v0 in self.label.items()} if self.label is not None else None,
			"valorisations": [x0.__serialize__() for x0 in self.valorisations],
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedFlatRateTarification':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			code=deserialized_dict.get("code"),
			flat_rate_type=FlatRateType._deserialize(deserialized_dict.get("flatRateType")) if deserialized_dict.get("flatRateType") is not None else None,
			label=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("label").items())) if deserialized_dict.get("label") is not None else None,
			valorisations=[DecryptedValorisation._deserialize(x0) for x0 in deserialized_dict["valorisations"]],
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

type FlatRateTarification = Union['EncryptedFlatRateTarification', 'DecryptedFlatRateTarification']

def serialize_flat_rate_tarification(flat_rate_tarification: FlatRateTarification) -> Any:
	if isinstance(flat_rate_tarification, EncryptedFlatRateTarification):
		serialized_entity = flat_rate_tarification.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.EncryptedFlatRateTarification"})
		return serialized_entity
	elif isinstance(flat_rate_tarification, DecryptedFlatRateTarification):
		serialized_entity = flat_rate_tarification.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.DecryptedFlatRateTarification"})
		return serialized_entity
	else:
		raise Exception(f"{type(flat_rate_tarification)} is not a known subclass of FlatRateTarification")

def deserialize_flat_rate_tarification(data: Union[str, dict[str, JsonElement]]) -> 'FlatRateTarification':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.embed.EncryptedFlatRateTarification":
		return EncryptedFlatRateTarification._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.embed.DecryptedFlatRateTarification":
		return DecryptedFlatRateTarification._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of FlatRateTarification")

@dataclass
class AlwaysPermissionItem:
	type: 'PermissionType'

	def __serialize__(self) -> Any:
		return {
			"type": self.type.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'AlwaysPermissionItem':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			type=PermissionType._deserialize(deserialized_dict["type"]),
		)

type PermissionItem = Union['AlwaysPermissionItem']

def serialize_permission_item(permission_item: PermissionItem) -> Any:
	if isinstance(permission_item, AlwaysPermissionItem):
		serialized_entity = permission_item.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.security.AlwaysPermissionItem"})
		return serialized_entity
	else:
		raise Exception(f"{type(permission_item)} is not a known subclass of PermissionItem")

def deserialize_permission_item(data: Union[str, dict[str, JsonElement]]) -> 'PermissionItem':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.security.AlwaysPermissionItem":
		return AlwaysPermissionItem._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of PermissionItem")

class FrontEndMigrationStatus(Enum):
	Started = "STARTED"
	Paused = "PAUSED"
	Error = "ERROR"
	Success = "SUCCESS"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'FrontEndMigrationStatus':
		if data == "STARTED":
			return FrontEndMigrationStatus.Started
		elif data == "PAUSED":
			return FrontEndMigrationStatus.Paused
		elif data == "ERROR":
			return FrontEndMigrationStatus.Error
		elif data == "SUCCESS":
			return FrontEndMigrationStatus.Success
		else:
			raise Exception(f"{data} is not a valid value for FrontEndMigrationStatus enum.")

class ReportVersion(Enum):
	V1_0_0 = "V1_0_0"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ReportVersion':
		if data == "V1_0_0":
			return ReportVersion.V1_0_0
		else:
			raise Exception(f"{data} is not a valid value for ReportVersion enum.")

class Laterality(Enum):
	Left = "left"
	Right = "right"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Laterality':
		if data == "left":
			return Laterality.Left
		elif data == "right":
			return Laterality.Right
		else:
			raise Exception(f"{data} is not a valid value for Laterality enum.")

@dataclass
class EncryptedPlanOfAction:
	id: str
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	prescriber_id: Optional[str] = None
	value_date: Optional[int] = None
	opening_date: Optional[int] = None
	closing_date: Optional[int] = None
	deadline_date: Optional[int] = None
	name: Optional[str] = None
	descr: Optional[str] = None
	note: Optional[str] = None
	id_opening_contact: Optional[str] = None
	id_closing_contact: Optional[str] = None
	status: int = 0
	document_ids: set[str] = field(default_factory=set)
	number_of_cares: Optional[int] = None
	care_team_memberships: list[Optional['EncryptedCareTeamMembership']] = field(default_factory=list)
	relevant: bool = True
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"prescriberId": self.prescriber_id,
			"valueDate": self.value_date,
			"openingDate": self.opening_date,
			"closingDate": self.closing_date,
			"deadlineDate": self.deadline_date,
			"name": self.name,
			"descr": self.descr,
			"note": self.note,
			"idOpeningContact": self.id_opening_contact,
			"idClosingContact": self.id_closing_contact,
			"status": self.status,
			"documentIds": [x0 for x0 in self.document_ids],
			"numberOfCares": self.number_of_cares,
			"careTeamMemberships": [x0.__serialize__() if x0 is not None else None for x0 in self.care_team_memberships],
			"relevant": self.relevant,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedPlanOfAction':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			prescriber_id=deserialized_dict.get("prescriberId"),
			value_date=deserialized_dict.get("valueDate"),
			opening_date=deserialized_dict.get("openingDate"),
			closing_date=deserialized_dict.get("closingDate"),
			deadline_date=deserialized_dict.get("deadlineDate"),
			name=deserialized_dict.get("name"),
			descr=deserialized_dict.get("descr"),
			note=deserialized_dict.get("note"),
			id_opening_contact=deserialized_dict.get("idOpeningContact"),
			id_closing_contact=deserialized_dict.get("idClosingContact"),
			status=deserialized_dict["status"],
			document_ids={x0 for x0 in deserialized_dict["documentIds"]},
			number_of_cares=deserialized_dict.get("numberOfCares"),
			care_team_memberships=[EncryptedCareTeamMembership._deserialize(x0) if x0 is not None else None for x0 in deserialized_dict["careTeamMemberships"]],
			relevant=deserialized_dict["relevant"],
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class DecryptedPlanOfAction:
	id: str
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	end_of_life: Optional[int] = None
	prescriber_id: Optional[str] = None
	value_date: Optional[int] = None
	opening_date: Optional[int] = None
	closing_date: Optional[int] = None
	deadline_date: Optional[int] = None
	name: Optional[str] = None
	descr: Optional[str] = None
	note: Optional[str] = None
	id_opening_contact: Optional[str] = None
	id_closing_contact: Optional[str] = None
	status: int = 0
	document_ids: set[str] = field(default_factory=set)
	number_of_cares: Optional[int] = None
	care_team_memberships: list[Optional['DecryptedCareTeamMembership']] = field(default_factory=list)
	relevant: bool = True
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"prescriberId": self.prescriber_id,
			"valueDate": self.value_date,
			"openingDate": self.opening_date,
			"closingDate": self.closing_date,
			"deadlineDate": self.deadline_date,
			"name": self.name,
			"descr": self.descr,
			"note": self.note,
			"idOpeningContact": self.id_opening_contact,
			"idClosingContact": self.id_closing_contact,
			"status": self.status,
			"documentIds": [x0 for x0 in self.document_ids],
			"numberOfCares": self.number_of_cares,
			"careTeamMemberships": [x0.__serialize__() if x0 is not None else None for x0 in self.care_team_memberships],
			"relevant": self.relevant,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedPlanOfAction':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			end_of_life=deserialized_dict.get("endOfLife"),
			prescriber_id=deserialized_dict.get("prescriberId"),
			value_date=deserialized_dict.get("valueDate"),
			opening_date=deserialized_dict.get("openingDate"),
			closing_date=deserialized_dict.get("closingDate"),
			deadline_date=deserialized_dict.get("deadlineDate"),
			name=deserialized_dict.get("name"),
			descr=deserialized_dict.get("descr"),
			note=deserialized_dict.get("note"),
			id_opening_contact=deserialized_dict.get("idOpeningContact"),
			id_closing_contact=deserialized_dict.get("idClosingContact"),
			status=deserialized_dict["status"],
			document_ids={x0 for x0 in deserialized_dict["documentIds"]},
			number_of_cares=deserialized_dict.get("numberOfCares"),
			care_team_memberships=[DecryptedCareTeamMembership._deserialize(x0) if x0 is not None else None for x0 in deserialized_dict["careTeamMemberships"]],
			relevant=deserialized_dict["relevant"],
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

type PlanOfAction = Union['EncryptedPlanOfAction', 'DecryptedPlanOfAction']

def serialize_plan_of_action(plan_of_action: PlanOfAction) -> Any:
	if isinstance(plan_of_action, EncryptedPlanOfAction):
		serialized_entity = plan_of_action.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.EncryptedPlanOfAction"})
		return serialized_entity
	elif isinstance(plan_of_action, DecryptedPlanOfAction):
		serialized_entity = plan_of_action.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.DecryptedPlanOfAction"})
		return serialized_entity
	else:
		raise Exception(f"{type(plan_of_action)} is not a known subclass of PlanOfAction")

def deserialize_plan_of_action(data: Union[str, dict[str, JsonElement]]) -> 'PlanOfAction':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.embed.EncryptedPlanOfAction":
		return EncryptedPlanOfAction._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.embed.DecryptedPlanOfAction":
		return DecryptedPlanOfAction._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of PlanOfAction")

@dataclass
class DecryptedEpisode:
	id: str
	name: Optional[str] = None
	comment: Optional[str] = None
	start_date: Optional[int] = None
	end_date: Optional[int] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"name": self.name,
			"comment": self.comment,
			"startDate": self.start_date,
			"endDate": self.end_date,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedEpisode':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			name=deserialized_dict.get("name"),
			comment=deserialized_dict.get("comment"),
			start_date=deserialized_dict.get("startDate"),
			end_date=deserialized_dict.get("endDate"),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class EncryptedEpisode:
	id: str
	name: Optional[str] = None
	comment: Optional[str] = None
	start_date: Optional[int] = None
	end_date: Optional[int] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"name": self.name,
			"comment": self.comment,
			"startDate": self.start_date,
			"endDate": self.end_date,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedEpisode':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			name=deserialized_dict.get("name"),
			comment=deserialized_dict.get("comment"),
			start_date=deserialized_dict.get("startDate"),
			end_date=deserialized_dict.get("endDate"),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

type Episode = Union['DecryptedEpisode', 'EncryptedEpisode']

def serialize_episode(episode: Episode) -> Any:
	if isinstance(episode, DecryptedEpisode):
		serialized_entity = episode.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.DecryptedEpisode"})
		return serialized_entity
	elif isinstance(episode, EncryptedEpisode):
		serialized_entity = episode.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.EncryptedEpisode"})
		return serialized_entity
	else:
		raise Exception(f"{type(episode)} is not a known subclass of Episode")

def deserialize_episode(data: Union[str, dict[str, JsonElement]]) -> 'Episode':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.embed.DecryptedEpisode":
		return DecryptedEpisode._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.embed.EncryptedEpisode":
		return EncryptedEpisode._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of Episode")

@dataclass
class EncryptedCareTeamMember:
	id: str
	care_team_member_type: Optional['CareTeamMemberType'] = None
	healthcare_party_id: Optional[str] = None
	quality: Optional['CodeStub'] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"careTeamMemberType": self.care_team_member_type.__serialize__() if self.care_team_member_type is not None else None,
			"healthcarePartyId": self.healthcare_party_id,
			"quality": self.quality.__serialize__() if self.quality is not None else None,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedCareTeamMember':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			care_team_member_type=CareTeamMemberType._deserialize(deserialized_dict.get("careTeamMemberType")) if deserialized_dict.get("careTeamMemberType") is not None else None,
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			quality=CodeStub._deserialize(deserialized_dict.get("quality")) if deserialized_dict.get("quality") is not None else None,
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class DecryptedCareTeamMember:
	id: str
	care_team_member_type: Optional['CareTeamMemberType'] = None
	healthcare_party_id: Optional[str] = None
	quality: Optional['CodeStub'] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"careTeamMemberType": self.care_team_member_type.__serialize__() if self.care_team_member_type is not None else None,
			"healthcarePartyId": self.healthcare_party_id,
			"quality": self.quality.__serialize__() if self.quality is not None else None,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedCareTeamMember':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			care_team_member_type=CareTeamMemberType._deserialize(deserialized_dict.get("careTeamMemberType")) if deserialized_dict.get("careTeamMemberType") is not None else None,
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			quality=CodeStub._deserialize(deserialized_dict.get("quality")) if deserialized_dict.get("quality") is not None else None,
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

type CareTeamMember = Union['EncryptedCareTeamMember', 'DecryptedCareTeamMember']

def serialize_care_team_member(care_team_member: CareTeamMember) -> Any:
	if isinstance(care_team_member, EncryptedCareTeamMember):
		serialized_entity = care_team_member.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.EncryptedCareTeamMember"})
		return serialized_entity
	elif isinstance(care_team_member, DecryptedCareTeamMember):
		serialized_entity = care_team_member.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.DecryptedCareTeamMember"})
		return serialized_entity
	else:
		raise Exception(f"{type(care_team_member)} is not a known subclass of CareTeamMember")

def deserialize_care_team_member(data: Union[str, dict[str, JsonElement]]) -> 'CareTeamMember':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.embed.EncryptedCareTeamMember":
		return EncryptedCareTeamMember._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.embed.DecryptedCareTeamMember":
		return DecryptedCareTeamMember._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of CareTeamMember")

@dataclass
class Remote:
	url: str
	auth: Optional['RemoteAuthentication'] = None

	def __serialize__(self) -> Any:
		return {
			"url": self.url,
			"auth": self.auth.__serialize__() if self.auth is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Remote':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			url=deserialized_dict["url"],
			auth=RemoteAuthentication._deserialize(deserialized_dict.get("auth")) if deserialized_dict.get("auth") is not None else None,
		)

@dataclass
class ReplicationStats:
	revisions_checked: Optional[int] = None
	missing_revisions_found: Optional[int] = None
	docs_read: Optional[int] = None
	docs_written: Optional[int] = None
	changes_pending: Optional[int] = None
	doc_write_failures: Optional[int] = None
	checkpointed_source_seq: Optional[str] = None
	start_time: Optional[str] = None
	error: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"revisionsChecked": self.revisions_checked,
			"missingRevisionsFound": self.missing_revisions_found,
			"docsRead": self.docs_read,
			"docsWritten": self.docs_written,
			"changesPending": self.changes_pending,
			"docWriteFailures": self.doc_write_failures,
			"checkpointedSourceSeq": self.checkpointed_source_seq,
			"startTime": self.start_time,
			"error": self.error,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ReplicationStats':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			revisions_checked=deserialized_dict.get("revisionsChecked"),
			missing_revisions_found=deserialized_dict.get("missingRevisionsFound"),
			docs_read=deserialized_dict.get("docsRead"),
			docs_written=deserialized_dict.get("docsWritten"),
			changes_pending=deserialized_dict.get("changesPending"),
			doc_write_failures=deserialized_dict.get("docWriteFailures"),
			checkpointed_source_seq=deserialized_dict.get("checkpointedSourceSeq"),
			start_time=deserialized_dict.get("startTime"),
			error=deserialized_dict.get("error"),
		)

@dataclass
class MessageReadStatus:
	time: Optional[int] = None
	read: bool = False

	def __serialize__(self) -> Any:
		return {
			"time": self.time,
			"read": self.read,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'MessageReadStatus':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			time=deserialized_dict.get("time"),
			read=deserialized_dict["read"],
		)

@dataclass
class MessageAttachment:
	type: Optional['DocumentLocation'] = None
	ids: list[str] = field(default_factory=list)

	def __serialize__(self) -> Any:
		return {
			"type": self.type.__serialize__() if self.type is not None else None,
			"ids": [x0 for x0 in self.ids],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'MessageAttachment':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			type=DocumentLocation._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
			ids=[x0 for x0 in deserialized_dict["ids"]],
		)

@dataclass
class PropertyTypeStub:
	identifier: Optional[str] = None
	type: Optional['TypedValuesType'] = None

	def __serialize__(self) -> Any:
		return {
			"identifier": self.identifier,
			"type": self.type.__serialize__() if self.type is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'PropertyTypeStub':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			identifier=deserialized_dict.get("identifier"),
			type=TypedValuesType._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
		)

@dataclass
class DecryptedTypedValue:
	type: Optional['TypedValuesType'] = None
	boolean_value: Optional[bool] = None
	integer_value: Optional[int] = None
	double_value: Optional[float] = None
	string_value: Optional[str] = None
	date_value: Optional[int] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"type": self.type.__serialize__() if self.type is not None else None,
			"booleanValue": self.boolean_value,
			"integerValue": self.integer_value,
			"doubleValue": self.double_value,
			"stringValue": self.string_value,
			"dateValue": self.date_value,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedTypedValue':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			type=TypedValuesType._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
			boolean_value=deserialized_dict.get("booleanValue"),
			integer_value=deserialized_dict.get("integerValue"),
			double_value=deserialized_dict.get("doubleValue"),
			string_value=deserialized_dict.get("stringValue"),
			date_value=deserialized_dict.get("dateValue"),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class EncryptedTypedValue:
	type: Optional['TypedValuesType'] = None
	boolean_value: Optional[bool] = None
	integer_value: Optional[int] = None
	double_value: Optional[float] = None
	string_value: Optional[str] = None
	date_value: Optional[int] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"type": self.type.__serialize__() if self.type is not None else None,
			"booleanValue": self.boolean_value,
			"integerValue": self.integer_value,
			"doubleValue": self.double_value,
			"stringValue": self.string_value,
			"dateValue": self.date_value,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedTypedValue':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			type=TypedValuesType._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
			boolean_value=deserialized_dict.get("booleanValue"),
			integer_value=deserialized_dict.get("integerValue"),
			double_value=deserialized_dict.get("doubleValue"),
			string_value=deserialized_dict.get("stringValue"),
			date_value=deserialized_dict.get("dateValue"),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

type TypedValue = Union['DecryptedTypedValue', 'EncryptedTypedValue']

def serialize_typed_value(typed_value: TypedValue) -> Any:
	if isinstance(typed_value, DecryptedTypedValue):
		serialized_entity = typed_value.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.DecryptedTypedValue"})
		return serialized_entity
	elif isinstance(typed_value, EncryptedTypedValue):
		serialized_entity = typed_value.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.EncryptedTypedValue"})
		return serialized_entity
	else:
		raise Exception(f"{type(typed_value)} is not a known subclass of TypedValue")

def deserialize_typed_value(data: Union[str, dict[str, JsonElement]]) -> 'TypedValue':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.embed.DecryptedTypedValue":
		return DecryptedTypedValue._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.embed.EncryptedTypedValue":
		return EncryptedTypedValue._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of TypedValue")

class InvoiceInterventionType(Enum):
	Total = "total"
	Userfees = "userfees"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'InvoiceInterventionType':
		if data == "total":
			return InvoiceInterventionType.Total
		elif data == "userfees":
			return InvoiceInterventionType.Userfees
		else:
			raise Exception(f"{data} is not a valid value for InvoiceInterventionType enum.")

class PaymentType(Enum):
	Cash = "cash"
	Wired = "wired"
	Insurance = "insurance"
	Creditcard = "creditcard"
	Debitcard = "debitcard"
	Paypal = "paypal"
	Bitcoin = "bitcoin"
	Other = "other"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'PaymentType':
		if data == "cash":
			return PaymentType.Cash
		elif data == "wired":
			return PaymentType.Wired
		elif data == "insurance":
			return PaymentType.Insurance
		elif data == "creditcard":
			return PaymentType.Creditcard
		elif data == "debitcard":
			return PaymentType.Debitcard
		elif data == "paypal":
			return PaymentType.Paypal
		elif data == "bitcoin":
			return PaymentType.Bitcoin
		elif data == "other":
			return PaymentType.Other
		else:
			raise Exception(f"{data} is not a valid value for PaymentType enum.")

@dataclass
class Payment:
	payment_date: int = 0
	payment_type: Optional['PaymentType'] = None
	paid: Optional[float] = None

	def __serialize__(self) -> Any:
		return {
			"paymentDate": self.payment_date,
			"paymentType": self.payment_type.__serialize__() if self.payment_type is not None else None,
			"paid": self.paid,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Payment':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			payment_date=deserialized_dict["paymentDate"],
			payment_type=PaymentType._deserialize(deserialized_dict.get("paymentType")) if deserialized_dict.get("paymentType") is not None else None,
			paid=deserialized_dict.get("paid"),
		)

@dataclass
class IdentityDocumentReader:
	justificatif_document_number: Optional[str] = None
	support_serial_number: Optional[str] = None
	time_reading_eid_document: Optional[int] = None
	eid_document_support_type: int = 0
	reason_manual_encoding: int = 0
	reason_using_vignette: int = 0

	def __serialize__(self) -> Any:
		return {
			"justificatifDocumentNumber": self.justificatif_document_number,
			"supportSerialNumber": self.support_serial_number,
			"timeReadingEIdDocument": self.time_reading_eid_document,
			"eidDocumentSupportType": self.eid_document_support_type,
			"reasonManualEncoding": self.reason_manual_encoding,
			"reasonUsingVignette": self.reason_using_vignette,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'IdentityDocumentReader':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			justificatif_document_number=deserialized_dict.get("justificatifDocumentNumber"),
			support_serial_number=deserialized_dict.get("supportSerialNumber"),
			time_reading_eid_document=deserialized_dict.get("timeReadingEIdDocument"),
			eid_document_support_type=deserialized_dict["eidDocumentSupportType"],
			reason_manual_encoding=deserialized_dict["reasonManualEncoding"],
			reason_using_vignette=deserialized_dict["reasonUsingVignette"],
		)

class UserAccessLevel(Enum):
	Admin = "Admin"
	Read = "Read"
	Write = "Write"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'UserAccessLevel':
		if data == "Admin":
			return UserAccessLevel.Admin
		elif data == "Read":
			return UserAccessLevel.Read
		elif data == "Write":
			return UserAccessLevel.Write
		else:
			raise Exception(f"{data} is not a valid value for UserAccessLevel enum.")

@dataclass
class AgendaSlottingAlgorithmFixedIntervals:
	interval_minutes: int

	def __serialize__(self) -> Any:
		return {
			"intervalMinutes": self.interval_minutes,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'AgendaSlottingAlgorithmFixedIntervals':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			interval_minutes=deserialized_dict["intervalMinutes"],
		)

type AgendaSlottingAlgorithm = Union['AgendaSlottingAlgorithmFixedIntervals']

def serialize_agenda_slotting_algorithm(agenda_slotting_algorithm: AgendaSlottingAlgorithm) -> Any:
	if isinstance(agenda_slotting_algorithm, AgendaSlottingAlgorithmFixedIntervals):
		serialized_entity = agenda_slotting_algorithm.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.AgendaSlottingAlgorithm.FixedIntervals"})
		return serialized_entity
	else:
		raise Exception(f"{type(agenda_slotting_algorithm)} is not a known subclass of AgendaSlottingAlgorithm")

def deserialize_agenda_slotting_algorithm(data: Union[str, dict[str, JsonElement]]) -> 'AgendaSlottingAlgorithm':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.embed.AgendaSlottingAlgorithm.FixedIntervals":
		return AgendaSlottingAlgorithmFixedIntervals._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of AgendaSlottingAlgorithm")

@dataclass
class ResourceGroupAllocationSchedule:
	resource_group: Optional['CodeStub'] = None
	tags: set['CodeStub'] = field(default_factory=set)
	codes: set['CodeStub'] = field(default_factory=set)
	name: Optional[str] = None
	start_date_time: Optional[int] = None
	end_date_time: Optional[int] = None
	items: list['EmbeddedTimeTableItem'] = field(default_factory=list)

	def __serialize__(self) -> Any:
		return {
			"resourceGroup": self.resource_group.__serialize__() if self.resource_group is not None else None,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"name": self.name,
			"startDateTime": self.start_date_time,
			"endDateTime": self.end_date_time,
			"items": [x0.__serialize__() for x0 in self.items],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ResourceGroupAllocationSchedule':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			resource_group=CodeStub._deserialize(deserialized_dict.get("resourceGroup")) if deserialized_dict.get("resourceGroup") is not None else None,
			tags={CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]},
			codes={CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]},
			name=deserialized_dict.get("name"),
			start_date_time=deserialized_dict.get("startDateTime"),
			end_date_time=deserialized_dict.get("endDateTime"),
			items=[EmbeddedTimeTableItem._deserialize(x0) for x0 in deserialized_dict["items"]],
		)

@dataclass
class OperationToken:
	token_hash: str
	creation_time: int
	validity: int
	operation: 'Operation'
	description: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"tokenHash": self.token_hash,
			"creationTime": self.creation_time,
			"validity": self.validity,
			"operation": self.operation.__serialize__(),
			"description": self.description,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'OperationToken':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			token_hash=deserialized_dict["tokenHash"],
			creation_time=deserialized_dict["creationTime"],
			validity=deserialized_dict["validity"],
			operation=Operation._deserialize(deserialized_dict["operation"]),
			description=deserialized_dict.get("description"),
		)

class AuthenticationClass(Enum):
	DigitalId = "DIGITAL_ID"
	TwoFactorAuthentication = "TWO_FACTOR_AUTHENTICATION"
	ShortLivedToken = "SHORT_LIVED_TOKEN"
	ExternalAuthentication = "EXTERNAL_AUTHENTICATION"
	Password = "PASSWORD"
	LongLivedToken = "LONG_LIVED_TOKEN"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'AuthenticationClass':
		if data == "DIGITAL_ID":
			return AuthenticationClass.DigitalId
		elif data == "TWO_FACTOR_AUTHENTICATION":
			return AuthenticationClass.TwoFactorAuthentication
		elif data == "SHORT_LIVED_TOKEN":
			return AuthenticationClass.ShortLivedToken
		elif data == "EXTERNAL_AUTHENTICATION":
			return AuthenticationClass.ExternalAuthentication
		elif data == "PASSWORD":
			return AuthenticationClass.Password
		elif data == "LONG_LIVED_TOKEN":
			return AuthenticationClass.LongLivedToken
		else:
			raise Exception(f"{data} is not a valid value for AuthenticationClass enum.")

@dataclass
class Replication:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	name: Optional[str] = None
	context: Optional[str] = None
	database_synchronizations: list['DatabaseSynchronization'] = field(default_factory=list)

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"name": self.name,
			"context": self.context,
			"databaseSynchronizations": [x0.__serialize__() for x0 in self.database_synchronizations],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Replication':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			deletion_date=deserialized_dict.get("deletionDate"),
			name=deserialized_dict.get("name"),
			context=deserialized_dict.get("context"),
			database_synchronizations=[DatabaseSynchronization._deserialize(x0) for x0 in deserialized_dict["databaseSynchronizations"]],
		)

@dataclass
class View:
	map: str
	reduce: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"map": self.map,
			"reduce": self.reduce,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'View':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			map=deserialized_dict["map"],
			reduce=deserialized_dict.get("reduce"),
		)

@dataclass
class DatabaseInfo:
	id: str
	update_seq: Optional[str] = None
	file_size: Optional[int] = None
	external_size: Optional[int] = None
	active_size: Optional[int] = None
	docs: Optional[int] = None
	q: Optional[int] = None
	n: Optional[int] = None
	w: Optional[int] = None
	r: Optional[int] = None

	def __serialize__(self) -> Any:
		return {
			"id": self.id,
			"updateSeq": self.update_seq,
			"fileSize": self.file_size,
			"externalSize": self.external_size,
			"activeSize": self.active_size,
			"docs": self.docs,
			"q": self.q,
			"n": self.n,
			"w": self.w,
			"r": self.r,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DatabaseInfo':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			update_seq=deserialized_dict.get("updateSeq"),
			file_size=deserialized_dict.get("fileSize"),
			external_size=deserialized_dict.get("externalSize"),
			active_size=deserialized_dict.get("activeSize"),
			docs=deserialized_dict.get("docs"),
			q=deserialized_dict.get("q"),
			n=deserialized_dict.get("n"),
			w=deserialized_dict.get("w"),
			r=deserialized_dict.get("r"),
		)

@dataclass
class SecureDelegation:
	permissions: 'AccessLevel'
	delegator: Optional[str] = None
	delegate: Optional[str] = None
	secret_ids: set['Base64String'] = field(default_factory=set)
	encryption_keys: set['Base64String'] = field(default_factory=set)
	owning_entity_ids: set['Base64String'] = field(default_factory=set)
	parent_delegations: set['SecureDelegationKeyString'] = field(default_factory=set)
	exchange_data_id: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"delegator": self.delegator,
			"delegate": self.delegate,
			"secretIds": [x0 for x0 in self.secret_ids],
			"encryptionKeys": [x0 for x0 in self.encryption_keys],
			"owningEntityIds": [x0 for x0 in self.owning_entity_ids],
			"parentDelegations": [x0 for x0 in self.parent_delegations],
			"exchangeDataId": self.exchange_data_id,
			"permissions": self.permissions.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'SecureDelegation':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			delegator=deserialized_dict.get("delegator"),
			delegate=deserialized_dict.get("delegate"),
			secret_ids={x0 for x0 in deserialized_dict["secretIds"]},
			encryption_keys={x0 for x0 in deserialized_dict["encryptionKeys"]},
			owning_entity_ids={x0 for x0 in deserialized_dict["owningEntityIds"]},
			parent_delegations={x0 for x0 in deserialized_dict["parentDelegations"]},
			exchange_data_id=deserialized_dict.get("exchangeDataId"),
			permissions=AccessLevel._deserialize(deserialized_dict["permissions"]),
		)

class AddressType(Enum):
	Home = "home"
	Work = "work"
	Vacation = "vacation"
	Hospital = "hospital"
	Clinic = "clinic"
	Hq = "hq"
	Other = "other"
	Temporary = "temporary"
	Postal = "postal"
	Diplomatic = "diplomatic"
	Reference = "reference"
	Careaddress = "careaddress"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'AddressType':
		if data == "home":
			return AddressType.Home
		elif data == "work":
			return AddressType.Work
		elif data == "vacation":
			return AddressType.Vacation
		elif data == "hospital":
			return AddressType.Hospital
		elif data == "clinic":
			return AddressType.Clinic
		elif data == "hq":
			return AddressType.Hq
		elif data == "other":
			return AddressType.Other
		elif data == "temporary":
			return AddressType.Temporary
		elif data == "postal":
			return AddressType.Postal
		elif data == "diplomatic":
			return AddressType.Diplomatic
		elif data == "reference":
			return AddressType.Reference
		elif data == "careaddress":
			return AddressType.Careaddress
		else:
			raise Exception(f"{data} is not a valid value for AddressType enum.")

@dataclass
class EncryptedTelecom:
	telecom_type: Optional['TelecomType'] = None
	telecom_number: Optional[str] = None
	telecom_description: Optional[str] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"telecomType": self.telecom_type.__serialize__() if self.telecom_type is not None else None,
			"telecomNumber": self.telecom_number,
			"telecomDescription": self.telecom_description,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedTelecom':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			telecom_type=TelecomType._deserialize(deserialized_dict.get("telecomType")) if deserialized_dict.get("telecomType") is not None else None,
			telecom_number=deserialized_dict.get("telecomNumber"),
			telecom_description=deserialized_dict.get("telecomDescription"),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class DecryptedTelecom:
	telecom_type: Optional['TelecomType'] = None
	telecom_number: Optional[str] = None
	telecom_description: Optional[str] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"telecomType": self.telecom_type.__serialize__() if self.telecom_type is not None else None,
			"telecomNumber": self.telecom_number,
			"telecomDescription": self.telecom_description,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedTelecom':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			telecom_type=TelecomType._deserialize(deserialized_dict.get("telecomType")) if deserialized_dict.get("telecomType") is not None else None,
			telecom_number=deserialized_dict.get("telecomNumber"),
			telecom_description=deserialized_dict.get("telecomDescription"),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

type Telecom = Union['EncryptedTelecom', 'DecryptedTelecom']

def serialize_telecom(telecom: Telecom) -> Any:
	if isinstance(telecom, EncryptedTelecom):
		serialized_entity = telecom.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.EncryptedTelecom"})
		return serialized_entity
	elif isinstance(telecom, DecryptedTelecom):
		serialized_entity = telecom.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.DecryptedTelecom"})
		return serialized_entity
	else:
		raise Exception(f"{type(telecom)} is not a known subclass of Telecom")

def deserialize_telecom(data: Union[str, dict[str, JsonElement]]) -> 'Telecom':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.embed.EncryptedTelecom":
		return EncryptedTelecom._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.embed.DecryptedTelecom":
		return DecryptedTelecom._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of Telecom")

@dataclass
class TimeTableHour:
	start_hour: Optional[int] = None
	end_hour: Optional[int] = None

	def __serialize__(self) -> Any:
		return {
			"startHour": self.start_hour,
			"endHour": self.end_hour,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'TimeTableHour':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			start_hour=deserialized_dict.get("startHour"),
			end_hour=deserialized_dict.get("endHour"),
		)

class PersonNameUse(Enum):
	Usual = "usual"
	Official = "official"
	Temp = "temp"
	Nickname = "nickname"
	Anonymous = "anonymous"
	Maiden = "maiden"
	Old = "old"
	Other = "other"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'PersonNameUse':
		if data == "usual":
			return PersonNameUse.Usual
		elif data == "official":
			return PersonNameUse.Official
		elif data == "temp":
			return PersonNameUse.Temp
		elif data == "nickname":
			return PersonNameUse.Nickname
		elif data == "anonymous":
			return PersonNameUse.Anonymous
		elif data == "maiden":
			return PersonNameUse.Maiden
		elif data == "old":
			return PersonNameUse.Old
		elif data == "other":
			return PersonNameUse.Other
		else:
			raise Exception(f"{data} is not a valid value for PersonNameUse enum.")

class PartnershipType(Enum):
	PrimaryContact = "primary_contact"
	PrimaryContactFor = "primary_contact_for"
	Family = "family"
	Friend = "friend"
	Counselor = "counselor"
	Contact = "contact"
	Brother = "brother"
	Brotherinlaw = "brotherinlaw"
	Child = "child"
	Daughter = "daughter"
	Employer = "employer"
	Father = "father"
	Grandchild = "grandchild"
	Grandparent = "grandparent"
	Husband = "husband"
	Lawyer = "lawyer"
	Mother = "mother"
	Neighbour = "neighbour"
	Notary = "notary"
	Partner = "partner"
	Sister = "sister"
	Sisterinlaw = "sisterinlaw"
	Son = "son"
	Spouse = "spouse"
	Stepdaughter = "stepdaughter"
	Stepfather = "stepfather"
	Stepmother = "stepmother"
	Stepson = "stepson"
	Tutor = "tutor"
	Cohabiting = "cohabiting"
	RegisteredPartner = "registered_partner"
	NextOfKin = "next_of_kin"
	FederalAgency = "federal_agency"
	InsuranceCompany = "insurance_company"
	StateAgency = "state_agency"
	Unknown = "unknown"
	Seealso = "seealso"
	Refer = "refer"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'PartnershipType':
		if data == "primary_contact":
			return PartnershipType.PrimaryContact
		elif data == "primary_contact_for":
			return PartnershipType.PrimaryContactFor
		elif data == "family":
			return PartnershipType.Family
		elif data == "friend":
			return PartnershipType.Friend
		elif data == "counselor":
			return PartnershipType.Counselor
		elif data == "contact":
			return PartnershipType.Contact
		elif data == "brother":
			return PartnershipType.Brother
		elif data == "brotherinlaw":
			return PartnershipType.Brotherinlaw
		elif data == "child":
			return PartnershipType.Child
		elif data == "daughter":
			return PartnershipType.Daughter
		elif data == "employer":
			return PartnershipType.Employer
		elif data == "father":
			return PartnershipType.Father
		elif data == "grandchild":
			return PartnershipType.Grandchild
		elif data == "grandparent":
			return PartnershipType.Grandparent
		elif data == "husband":
			return PartnershipType.Husband
		elif data == "lawyer":
			return PartnershipType.Lawyer
		elif data == "mother":
			return PartnershipType.Mother
		elif data == "neighbour":
			return PartnershipType.Neighbour
		elif data == "notary":
			return PartnershipType.Notary
		elif data == "partner":
			return PartnershipType.Partner
		elif data == "sister":
			return PartnershipType.Sister
		elif data == "sisterinlaw":
			return PartnershipType.Sisterinlaw
		elif data == "son":
			return PartnershipType.Son
		elif data == "spouse":
			return PartnershipType.Spouse
		elif data == "stepdaughter":
			return PartnershipType.Stepdaughter
		elif data == "stepfather":
			return PartnershipType.Stepfather
		elif data == "stepmother":
			return PartnershipType.Stepmother
		elif data == "stepson":
			return PartnershipType.Stepson
		elif data == "tutor":
			return PartnershipType.Tutor
		elif data == "cohabiting":
			return PartnershipType.Cohabiting
		elif data == "registered_partner":
			return PartnershipType.RegisteredPartner
		elif data == "next_of_kin":
			return PartnershipType.NextOfKin
		elif data == "federal_agency":
			return PartnershipType.FederalAgency
		elif data == "insurance_company":
			return PartnershipType.InsuranceCompany
		elif data == "state_agency":
			return PartnershipType.StateAgency
		elif data == "unknown":
			return PartnershipType.Unknown
		elif data == "seealso":
			return PartnershipType.Seealso
		elif data == "refer":
			return PartnershipType.Refer
		else:
			raise Exception(f"{data} is not a valid value for PartnershipType enum.")

class PartnershipStatus(Enum):
	Active = "active"
	Complicated = "complicated"
	Past = "past"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'PartnershipStatus':
		if data == "active":
			return PartnershipStatus.Active
		elif data == "complicated":
			return PartnershipStatus.Complicated
		elif data == "past":
			return PartnershipStatus.Past
		else:
			raise Exception(f"{data} is not a valid value for PartnershipStatus enum.")

class PatientHealthCarePartyType(Enum):
	Doctor = "doctor"
	Referral = "referral"
	Medicalhouse = "medicalhouse"
	Retirementhome = "retirementhome"
	Hospital = "hospital"
	Other = "other"
	Referringphysician = "referringphysician"
	Managingorganization = "managingorganization"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'PatientHealthCarePartyType':
		if data == "doctor":
			return PatientHealthCarePartyType.Doctor
		elif data == "referral":
			return PatientHealthCarePartyType.Referral
		elif data == "medicalhouse":
			return PatientHealthCarePartyType.Medicalhouse
		elif data == "retirementhome":
			return PatientHealthCarePartyType.Retirementhome
		elif data == "hospital":
			return PatientHealthCarePartyType.Hospital
		elif data == "other":
			return PatientHealthCarePartyType.Other
		elif data == "referringphysician":
			return PatientHealthCarePartyType.Referringphysician
		elif data == "managingorganization":
			return PatientHealthCarePartyType.Managingorganization
		else:
			raise Exception(f"{data} is not a valid value for PatientHealthCarePartyType enum.")

@dataclass
class ReferralPeriod:
	start_date: Optional[int] = None
	end_date: Optional[int] = None
	comment: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"startDate": self.start_date,
			"endDate": self.end_date,
			"comment": self.comment,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ReferralPeriod':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			start_date=deserialized_dict.get("startDate"),
			end_date=deserialized_dict.get("endDate"),
			comment=deserialized_dict.get("comment"),
		)

class ContractChangeType(Enum):
	InscriptionStart = "inscriptionStart"
	InscriptionEnd = "inscriptionEnd"
	Suspension = "suspension"
	CoverageChange = "coverageChange"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ContractChangeType':
		if data == "inscriptionStart":
			return ContractChangeType.InscriptionStart
		elif data == "inscriptionEnd":
			return ContractChangeType.InscriptionEnd
		elif data == "suspension":
			return ContractChangeType.Suspension
		elif data == "coverageChange":
			return ContractChangeType.CoverageChange
		else:
			raise Exception(f"{data} is not a valid value for ContractChangeType enum.")

class SuspensionReason(Enum):
	NotInsured = "notInsured"
	NoReasonGiven = "noReasonGiven"
	IsHospitalized = "isHospitalized"
	OutsideOfCountry = "outsideOfCountry"
	ChangeOfMutuality = "changeOfMutuality"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'SuspensionReason':
		if data == "notInsured":
			return SuspensionReason.NotInsured
		elif data == "noReasonGiven":
			return SuspensionReason.NoReasonGiven
		elif data == "isHospitalized":
			return SuspensionReason.IsHospitalized
		elif data == "outsideOfCountry":
			return SuspensionReason.OutsideOfCountry
		elif data == "changeOfMutuality":
			return SuspensionReason.ChangeOfMutuality
		else:
			raise Exception(f"{data} is not a valid value for SuspensionReason enum.")

class MhcSignatureType(Enum):
	HolderEid = "holderEid"
	HolderPaper = "holderPaper"
	LegalrepresentativeEid = "legalrepresentativeEid"
	LegalrepresentativePaper = "legalrepresentativePaper"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'MhcSignatureType':
		if data == "holderEid":
			return MhcSignatureType.HolderEid
		elif data == "holderPaper":
			return MhcSignatureType.HolderPaper
		elif data == "legalrepresentativeEid":
			return MhcSignatureType.LegalrepresentativeEid
		elif data == "legalrepresentativePaper":
			return MhcSignatureType.LegalrepresentativePaper
		else:
			raise Exception(f"{data} is not a valid value for MhcSignatureType enum.")

@dataclass
class Employer:
	name: Optional[str] = None
	addresse: Optional['DecryptedAddress'] = None

	def __serialize__(self) -> Any:
		return {
			"name": self.name,
			"addresse": self.addresse.__serialize__() if self.addresse is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Employer':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			name=deserialized_dict.get("name"),
			addresse=DecryptedAddress._deserialize(deserialized_dict.get("addresse")) if deserialized_dict.get("addresse") is not None else None,
		)

@dataclass
class Action:
	launchers: Optional[list['Launcher']] = field(default_factory=list)
	expression: Optional[str] = None
	states: Optional[list['State']] = field(default_factory=list)

	def __serialize__(self) -> Any:
		return {
			"launchers": [x0.__serialize__() for x0 in self.launchers] if self.launchers is not None else None,
			"expression": self.expression,
			"states": [x0.__serialize__() for x0 in self.states] if self.states is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Action':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			launchers=[Launcher._deserialize(x0) for x0 in deserialized_dict.get("launchers")] if deserialized_dict.get("launchers") is not None else None,
			expression=deserialized_dict.get("expression"),
			states=[State._deserialize(x0) for x0 in deserialized_dict.get("states")] if deserialized_dict.get("states") is not None else None,
		)

@dataclass
class Section:
	section: str
	fields: list['StructureElement']
	description: Optional[str] = None
	keywords: Optional[list[str]] = None

	def __serialize__(self) -> Any:
		return {
			"section": self.section,
			"fields": [serialize_structure_element(x0) for x0 in self.fields],
			"description": self.description,
			"keywords": [x0 for x0 in self.keywords] if self.keywords is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Section':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			section=deserialized_dict["section"],
			fields=[deserialize_structure_element(x0) for x0 in deserialized_dict["fields"]],
			description=deserialized_dict.get("description"),
			keywords=[x0 for x0 in deserialized_dict.get("keywords")] if deserialized_dict.get("keywords") is not None else None,
		)

@dataclass
class DelegateShareOptions:
	share_secret_ids: set[str]
	share_encryption_keys: set['HexString']
	share_owning_entity_ids: set[str]
	requested_permissions: 'RequestedPermission'

	def __serialize__(self) -> Any:
		return {
			"shareSecretIds": [x0 for x0 in self.share_secret_ids],
			"shareEncryptionKeys": [x0 for x0 in self.share_encryption_keys],
			"shareOwningEntityIds": [x0 for x0 in self.share_owning_entity_ids],
			"requestedPermissions": self.requested_permissions.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DelegateShareOptions':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			share_secret_ids={x0 for x0 in deserialized_dict["shareSecretIds"]},
			share_encryption_keys={x0 for x0 in deserialized_dict["shareEncryptionKeys"]},
			share_owning_entity_ids={x0 for x0 in deserialized_dict["shareOwningEntityIds"]},
			requested_permissions=RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
		)

@dataclass
class ServiceLink:
	service_id: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"serviceId": self.service_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ServiceLink':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			service_id=deserialized_dict.get("serviceId"),
		)

@dataclass
class Measure:
	value: Optional[float] = None
	ref: Optional[float] = None
	severity: Optional[int] = None
	severity_code: Optional[str] = None
	evolution: Optional[int] = None
	unit: Optional[str] = None
	unit_codes: Optional[set['CodeStub']] = None
	comment: Optional[str] = None
	comparator: Optional[str] = None
	sign: Optional[str] = None
	reference_ranges: list['ReferenceRange'] = field(default_factory=list)
	value_with_precision: Optional['ValueWithPrecision'] = None

	def __serialize__(self) -> Any:
		return {
			"value": self.value,
			"ref": self.ref,
			"severity": self.severity,
			"severityCode": self.severity_code,
			"evolution": self.evolution,
			"unit": self.unit,
			"unitCodes": [x0.__serialize__() for x0 in self.unit_codes] if self.unit_codes is not None else None,
			"comment": self.comment,
			"comparator": self.comparator,
			"sign": self.sign,
			"referenceRanges": [x0.__serialize__() for x0 in self.reference_ranges],
			"valueWithPrecision": self.value_with_precision.__serialize__() if self.value_with_precision is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Measure':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			value=deserialized_dict.get("value"),
			ref=deserialized_dict.get("ref"),
			severity=deserialized_dict.get("severity"),
			severity_code=deserialized_dict.get("severityCode"),
			evolution=deserialized_dict.get("evolution"),
			unit=deserialized_dict.get("unit"),
			unit_codes={CodeStub._deserialize(x0) for x0 in deserialized_dict.get("unitCodes")} if deserialized_dict.get("unitCodes") is not None else None,
			comment=deserialized_dict.get("comment"),
			comparator=deserialized_dict.get("comparator"),
			sign=deserialized_dict.get("sign"),
			reference_ranges=[ReferenceRange._deserialize(x0) for x0 in deserialized_dict["referenceRanges"]],
			value_with_precision=ValueWithPrecision._deserialize(deserialized_dict.get("valueWithPrecision")) if deserialized_dict.get("valueWithPrecision") is not None else None,
		)

@dataclass
class Medication:
	compound_prescription: Optional[str] = None
	substance_product: Optional['Substanceproduct'] = None
	medicinal_product: Optional['Medicinalproduct'] = None
	number_of_packages: Optional[int] = None
	batch: Optional[str] = None
	expiration_date: Optional[int] = None
	instruction_for_patient: Optional[str] = None
	instruction_for_reimbursement: Optional[str] = None
	comment_for_delivery: Optional[str] = None
	drug_route: Optional[str] = None
	temporality: Optional[str] = None
	frequency: Optional['CodeStub'] = None
	reimbursement_reason: Optional['CodeStub'] = None
	substitution_allowed: Optional[bool] = None
	begin_moment: Optional[int] = None
	end_moment: Optional[int] = None
	delivery_moment: Optional[int] = None
	end_execution_moment: Optional[int] = None
	duration: Optional['Duration'] = None
	renewal: Optional['Renewal'] = None
	known_usage: Optional[bool] = None
	regimen: Optional[list['RegimenItem']] = None
	posology: Optional[str] = None
	agreements: Optional[dict[str, 'ParagraphAgreement']] = None
	medication_scheme_id_on_safe: Optional[str] = None
	medication_scheme_safe_version: Optional[int] = None
	medication_scheme_time_stamp_on_safe: Optional[int] = None
	medication_scheme_document_id: Optional[str] = None
	safe_id_name: Optional[str] = None
	id_on_safes: Optional[str] = None
	timestamp_on_safe: Optional[int] = None
	change_validated: Optional[bool] = None
	new_safe_medication: Optional[bool] = None
	medication_use: Optional[str] = None
	begin_condition: Optional[str] = None
	end_condition: Optional[str] = None
	origin: Optional[str] = None
	medication_changed: Optional[bool] = None
	posology_changed: Optional[bool] = None
	suspension: Optional[list['Suspension']] = None
	prescription_rid: Optional[str] = None
	status: Optional[int] = None

	def __serialize__(self) -> Any:
		return {
			"compoundPrescription": self.compound_prescription,
			"substanceProduct": self.substance_product.__serialize__() if self.substance_product is not None else None,
			"medicinalProduct": self.medicinal_product.__serialize__() if self.medicinal_product is not None else None,
			"numberOfPackages": self.number_of_packages,
			"batch": self.batch,
			"expirationDate": self.expiration_date,
			"instructionForPatient": self.instruction_for_patient,
			"instructionForReimbursement": self.instruction_for_reimbursement,
			"commentForDelivery": self.comment_for_delivery,
			"drugRoute": self.drug_route,
			"temporality": self.temporality,
			"frequency": self.frequency.__serialize__() if self.frequency is not None else None,
			"reimbursementReason": self.reimbursement_reason.__serialize__() if self.reimbursement_reason is not None else None,
			"substitutionAllowed": self.substitution_allowed,
			"beginMoment": self.begin_moment,
			"endMoment": self.end_moment,
			"deliveryMoment": self.delivery_moment,
			"endExecutionMoment": self.end_execution_moment,
			"duration": self.duration.__serialize__() if self.duration is not None else None,
			"renewal": self.renewal.__serialize__() if self.renewal is not None else None,
			"knownUsage": self.known_usage,
			"regimen": [x0.__serialize__() for x0 in self.regimen] if self.regimen is not None else None,
			"posology": self.posology,
			"agreements": {k0: v0.__serialize__() for k0, v0 in self.agreements.items()} if self.agreements is not None else None,
			"medicationSchemeIdOnSafe": self.medication_scheme_id_on_safe,
			"medicationSchemeSafeVersion": self.medication_scheme_safe_version,
			"medicationSchemeTimeStampOnSafe": self.medication_scheme_time_stamp_on_safe,
			"medicationSchemeDocumentId": self.medication_scheme_document_id,
			"safeIdName": self.safe_id_name,
			"idOnSafes": self.id_on_safes,
			"timestampOnSafe": self.timestamp_on_safe,
			"changeValidated": self.change_validated,
			"newSafeMedication": self.new_safe_medication,
			"medicationUse": self.medication_use,
			"beginCondition": self.begin_condition,
			"endCondition": self.end_condition,
			"origin": self.origin,
			"medicationChanged": self.medication_changed,
			"posologyChanged": self.posology_changed,
			"suspension": [x0.__serialize__() for x0 in self.suspension] if self.suspension is not None else None,
			"prescriptionRID": self.prescription_rid,
			"status": self.status,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Medication':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			compound_prescription=deserialized_dict.get("compoundPrescription"),
			substance_product=Substanceproduct._deserialize(deserialized_dict.get("substanceProduct")) if deserialized_dict.get("substanceProduct") is not None else None,
			medicinal_product=Medicinalproduct._deserialize(deserialized_dict.get("medicinalProduct")) if deserialized_dict.get("medicinalProduct") is not None else None,
			number_of_packages=deserialized_dict.get("numberOfPackages"),
			batch=deserialized_dict.get("batch"),
			expiration_date=deserialized_dict.get("expirationDate"),
			instruction_for_patient=deserialized_dict.get("instructionForPatient"),
			instruction_for_reimbursement=deserialized_dict.get("instructionForReimbursement"),
			comment_for_delivery=deserialized_dict.get("commentForDelivery"),
			drug_route=deserialized_dict.get("drugRoute"),
			temporality=deserialized_dict.get("temporality"),
			frequency=CodeStub._deserialize(deserialized_dict.get("frequency")) if deserialized_dict.get("frequency") is not None else None,
			reimbursement_reason=CodeStub._deserialize(deserialized_dict.get("reimbursementReason")) if deserialized_dict.get("reimbursementReason") is not None else None,
			substitution_allowed=deserialized_dict.get("substitutionAllowed"),
			begin_moment=deserialized_dict.get("beginMoment"),
			end_moment=deserialized_dict.get("endMoment"),
			delivery_moment=deserialized_dict.get("deliveryMoment"),
			end_execution_moment=deserialized_dict.get("endExecutionMoment"),
			duration=Duration._deserialize(deserialized_dict.get("duration")) if deserialized_dict.get("duration") is not None else None,
			renewal=Renewal._deserialize(deserialized_dict.get("renewal")) if deserialized_dict.get("renewal") is not None else None,
			known_usage=deserialized_dict.get("knownUsage"),
			regimen=[RegimenItem._deserialize(x0) for x0 in deserialized_dict.get("regimen")] if deserialized_dict.get("regimen") is not None else None,
			posology=deserialized_dict.get("posology"),
			agreements=dict(map(lambda kv0: (kv0[0], ParagraphAgreement._deserialize(kv0[1])), deserialized_dict.get("agreements").items())) if deserialized_dict.get("agreements") is not None else None,
			medication_scheme_id_on_safe=deserialized_dict.get("medicationSchemeIdOnSafe"),
			medication_scheme_safe_version=deserialized_dict.get("medicationSchemeSafeVersion"),
			medication_scheme_time_stamp_on_safe=deserialized_dict.get("medicationSchemeTimeStampOnSafe"),
			medication_scheme_document_id=deserialized_dict.get("medicationSchemeDocumentId"),
			safe_id_name=deserialized_dict.get("safeIdName"),
			id_on_safes=deserialized_dict.get("idOnSafes"),
			timestamp_on_safe=deserialized_dict.get("timestampOnSafe"),
			change_validated=deserialized_dict.get("changeValidated"),
			new_safe_medication=deserialized_dict.get("newSafeMedication"),
			medication_use=deserialized_dict.get("medicationUse"),
			begin_condition=deserialized_dict.get("beginCondition"),
			end_condition=deserialized_dict.get("endCondition"),
			origin=deserialized_dict.get("origin"),
			medication_changed=deserialized_dict.get("medicationChanged"),
			posology_changed=deserialized_dict.get("posologyChanged"),
			suspension=[Suspension._deserialize(x0) for x0 in deserialized_dict.get("suspension")] if deserialized_dict.get("suspension") is not None else None,
			prescription_rid=deserialized_dict.get("prescriptionRID"),
			status=deserialized_dict.get("status"),
		)

@dataclass
class TimeSeries:
	fields: list[str] = field(default_factory=list)
	samples: list[list[float]] = field(default_factory=list)
	min: list[float] = field(default_factory=list)
	max: list[float] = field(default_factory=list)
	mean: list[float] = field(default_factory=list)
	median: list[float] = field(default_factory=list)
	variance: list[float] = field(default_factory=list)

	def __serialize__(self) -> Any:
		return {
			"fields": [x0 for x0 in self.fields],
			"samples": [[x1 for x1 in x0] for x0 in self.samples],
			"min": [x0 for x0 in self.min],
			"max": [x0 for x0 in self.max],
			"mean": [x0 for x0 in self.mean],
			"median": [x0 for x0 in self.median],
			"variance": [x0 for x0 in self.variance],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'TimeSeries':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			fields=[x0 for x0 in deserialized_dict["fields"]],
			samples=[[x1 for x1 in x0] for x0 in deserialized_dict["samples"]],
			min=[x0 for x0 in deserialized_dict["min"]],
			max=[x0 for x0 in deserialized_dict["max"]],
			mean=[x0 for x0 in deserialized_dict["mean"]],
			median=[x0 for x0 in deserialized_dict["median"]],
			variance=[x0 for x0 in deserialized_dict["variance"]],
		)

class FlatRateType(Enum):
	Physician = "physician"
	Physiotherapist = "physiotherapist"
	Nurse = "nurse"
	Ptd = "ptd"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'FlatRateType':
		if data == "physician":
			return FlatRateType.Physician
		elif data == "physiotherapist":
			return FlatRateType.Physiotherapist
		elif data == "nurse":
			return FlatRateType.Nurse
		elif data == "ptd":
			return FlatRateType.Ptd
		else:
			raise Exception(f"{data} is not a valid value for FlatRateType enum.")

@dataclass
class AlwaysPredicate:

	def __serialize__(self) -> Any:
		return {
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'AlwaysPredicate':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
		)

@dataclass
class DecryptedCareTeamMembership:
	start_date: Optional[int] = None
	end_date: Optional[int] = None
	care_team_member_id: Optional[str] = None
	membership_type: Optional['MembershipType'] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"startDate": self.start_date,
			"endDate": self.end_date,
			"careTeamMemberId": self.care_team_member_id,
			"membershipType": self.membership_type.__serialize__() if self.membership_type is not None else None,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DecryptedCareTeamMembership':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			start_date=deserialized_dict.get("startDate"),
			end_date=deserialized_dict.get("endDate"),
			care_team_member_id=deserialized_dict.get("careTeamMemberId"),
			membership_type=MembershipType._deserialize(deserialized_dict.get("membershipType")) if deserialized_dict.get("membershipType") is not None else None,
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class EncryptedCareTeamMembership:
	start_date: Optional[int] = None
	end_date: Optional[int] = None
	care_team_member_id: Optional[str] = None
	membership_type: Optional['MembershipType'] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> Any:
		return {
			"startDate": self.start_date,
			"endDate": self.end_date,
			"careTeamMemberId": self.care_team_member_id,
			"membershipType": self.membership_type.__serialize__() if self.membership_type is not None else None,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EncryptedCareTeamMembership':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			start_date=deserialized_dict.get("startDate"),
			end_date=deserialized_dict.get("endDate"),
			care_team_member_id=deserialized_dict.get("careTeamMemberId"),
			membership_type=MembershipType._deserialize(deserialized_dict.get("membershipType")) if deserialized_dict.get("membershipType") is not None else None,
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

type CareTeamMembership = Union['DecryptedCareTeamMembership', 'EncryptedCareTeamMembership']

def serialize_care_team_membership(care_team_membership: CareTeamMembership) -> Any:
	if isinstance(care_team_membership, DecryptedCareTeamMembership):
		serialized_entity = care_team_membership.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.DecryptedCareTeamMembership"})
		return serialized_entity
	elif isinstance(care_team_membership, EncryptedCareTeamMembership):
		serialized_entity = care_team_membership.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.EncryptedCareTeamMembership"})
		return serialized_entity
	else:
		raise Exception(f"{type(care_team_membership)} is not a known subclass of CareTeamMembership")

def deserialize_care_team_membership(data: Union[str, dict[str, JsonElement]]) -> 'CareTeamMembership':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.embed.DecryptedCareTeamMembership":
		return DecryptedCareTeamMembership._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.embed.EncryptedCareTeamMembership":
		return EncryptedCareTeamMembership._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of CareTeamMembership")

class CareTeamMemberType(Enum):
	Physician = "physician"
	Specialist = "specialist"
	Other = "other"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'CareTeamMemberType':
		if data == "physician":
			return CareTeamMemberType.Physician
		elif data == "specialist":
			return CareTeamMemberType.Specialist
		elif data == "other":
			return CareTeamMemberType.Other
		else:
			raise Exception(f"{data} is not a valid value for CareTeamMemberType enum.")

@dataclass
class RemoteAuthentication:
	basic: Optional['Basic'] = None

	def __serialize__(self) -> Any:
		return {
			"basic": self.basic.__serialize__() if self.basic is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'RemoteAuthentication':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			basic=Basic._deserialize(deserialized_dict.get("basic")) if deserialized_dict.get("basic") is not None else None,
		)

class TypedValuesType(Enum):
	Boolean = "BOOLEAN"
	Integer = "INTEGER"
	Double = "DOUBLE"
	String = "STRING"
	Date = "DATE"
	Clob = "CLOB"
	Json = "JSON"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'TypedValuesType':
		if data == "BOOLEAN":
			return TypedValuesType.Boolean
		elif data == "INTEGER":
			return TypedValuesType.Integer
		elif data == "DOUBLE":
			return TypedValuesType.Double
		elif data == "STRING":
			return TypedValuesType.String
		elif data == "DATE":
			return TypedValuesType.Date
		elif data == "CLOB":
			return TypedValuesType.Clob
		elif data == "JSON":
			return TypedValuesType.Json
		else:
			raise Exception(f"{data} is not a valid value for TypedValuesType enum.")

@dataclass
class EmbeddedTimeTableItem:
	rrule: str
	hours: list['EmbeddedTimeTableHour']
	calendar_item_types_ids: set[str]
	rrule_start_date: Optional[int] = None
	not_before_in_minutes: Optional[int] = None
	not_after_in_minutes: Optional[int] = None
	availabilities: int = 1
	reserving_rights: set[str] = field(default_factory=set)
	public: bool = False

	def __serialize__(self) -> Any:
		return {
			"rrule": self.rrule,
			"rruleStartDate": self.rrule_start_date,
			"notBeforeInMinutes": self.not_before_in_minutes,
			"notAfterInMinutes": self.not_after_in_minutes,
			"hours": [x0.__serialize__() for x0 in self.hours],
			"calendarItemTypesIds": [x0 for x0 in self.calendar_item_types_ids],
			"availabilities": self.availabilities,
			"reservingRights": [x0 for x0 in self.reserving_rights],
			"public": self.public,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EmbeddedTimeTableItem':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			rrule=deserialized_dict["rrule"],
			rrule_start_date=deserialized_dict.get("rruleStartDate"),
			not_before_in_minutes=deserialized_dict.get("notBeforeInMinutes"),
			not_after_in_minutes=deserialized_dict.get("notAfterInMinutes"),
			hours=[EmbeddedTimeTableHour._deserialize(x0) for x0 in deserialized_dict["hours"]],
			calendar_item_types_ids={x0 for x0 in deserialized_dict["calendarItemTypesIds"]},
			availabilities=deserialized_dict["availabilities"],
			reserving_rights={x0 for x0 in deserialized_dict["reservingRights"]},
			public=deserialized_dict["public"],
		)

@dataclass
class DatabaseSynchronization:
	source: Optional[str] = None
	target: Optional[str] = None
	filter: Optional[str] = None
	local_target: Optional['DatabaseSynchronizationTarget'] = None

	def __serialize__(self) -> Any:
		return {
			"source": self.source,
			"target": self.target,
			"filter": self.filter,
			"localTarget": self.local_target.__serialize__() if self.local_target is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DatabaseSynchronization':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			source=deserialized_dict.get("source"),
			target=deserialized_dict.get("target"),
			filter=deserialized_dict.get("filter"),
			local_target=DatabaseSynchronizationTarget._deserialize(deserialized_dict.get("localTarget")) if deserialized_dict.get("localTarget") is not None else None,
		)

class DatabaseSynchronizationTarget(Enum):
	Base = "base"
	Healthdata = "healthdata"
	Patient = "patient"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DatabaseSynchronizationTarget':
		if data == "base":
			return DatabaseSynchronizationTarget.Base
		elif data == "healthdata":
			return DatabaseSynchronizationTarget.Healthdata
		elif data == "patient":
			return DatabaseSynchronizationTarget.Patient
		else:
			raise Exception(f"{data} is not a valid value for Target enum.")

@dataclass
class Launcher:
	name: str
	triggerer: 'Trigger'
	should_pass_value: bool = False

	def __serialize__(self) -> Any:
		return {
			"name": self.name,
			"triggerer": self.triggerer.__serialize__(),
			"shouldPassValue": self.should_pass_value,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Launcher':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			name=deserialized_dict["name"],
			triggerer=Trigger._deserialize(deserialized_dict["triggerer"]),
			should_pass_value=deserialized_dict["shouldPassValue"],
		)

@dataclass
class State:
	name: str
	state_to_update: 'StateToUpdate'
	can_launch_launcher: bool = False

	def __serialize__(self) -> Any:
		return {
			"name": self.name,
			"stateToUpdate": self.state_to_update.__serialize__(),
			"canLaunchLauncher": self.can_launch_launcher,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'State':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			name=deserialized_dict["name"],
			state_to_update=StateToUpdate._deserialize(deserialized_dict["stateToUpdate"]),
			can_launch_launcher=deserialized_dict["canLaunchLauncher"],
		)

@dataclass
class DropdownField:
	field: str
	short_label: Optional[str] = None
	rows: Optional[int] = None
	columns: Optional[int] = None
	grows: Optional[bool] = None
	multiline: Optional[bool] = None
	schema: Optional[str] = None
	tags: Optional[list[str]] = None
	codifications: Optional[list[str]] = None
	options: Optional[dict[str, str]] = None
	labels: Optional[dict[str, str]] = None
	value: Optional[str] = None
	unit: Optional[str] = None
	required: Optional[bool] = None
	hide_condition: Optional[str] = None
	now: Optional[bool] = None
	translate: Optional[bool] = None

	def __serialize__(self) -> Any:
		return {
			"field": self.field,
			"shortLabel": self.short_label,
			"rows": self.rows,
			"columns": self.columns,
			"grows": self.grows,
			"multiline": self.multiline,
			"schema": self.schema,
			"tags": [x0 for x0 in self.tags] if self.tags is not None else None,
			"codifications": [x0 for x0 in self.codifications] if self.codifications is not None else None,
			"options": {k0: v0 for k0, v0 in self.options.items()} if self.options is not None else None,
			"labels": {k0: v0 for k0, v0 in self.labels.items()} if self.labels is not None else None,
			"value": self.value,
			"unit": self.unit,
			"required": self.required,
			"hideCondition": self.hide_condition,
			"now": self.now,
			"translate": self.translate,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DropdownField':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			field=deserialized_dict["field"],
			short_label=deserialized_dict.get("shortLabel"),
			rows=deserialized_dict.get("rows"),
			columns=deserialized_dict.get("columns"),
			grows=deserialized_dict.get("grows"),
			multiline=deserialized_dict.get("multiline"),
			schema=deserialized_dict.get("schema"),
			tags=[x0 for x0 in deserialized_dict.get("tags")] if deserialized_dict.get("tags") is not None else None,
			codifications=[x0 for x0 in deserialized_dict.get("codifications")] if deserialized_dict.get("codifications") is not None else None,
			options=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("options").items())) if deserialized_dict.get("options") is not None else None,
			labels=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("labels").items())) if deserialized_dict.get("labels") is not None else None,
			value=deserialized_dict.get("value"),
			unit=deserialized_dict.get("unit"),
			required=deserialized_dict.get("required"),
			hide_condition=deserialized_dict.get("hideCondition"),
			now=deserialized_dict.get("now"),
			translate=deserialized_dict.get("translate"),
		)

@dataclass
class RadioButton:
	field: str
	short_label: Optional[str] = None
	rows: Optional[int] = None
	columns: Optional[int] = None
	grows: Optional[bool] = None
	multiline: Optional[bool] = None
	schema: Optional[str] = None
	tags: Optional[list[str]] = None
	codifications: Optional[list[str]] = None
	options: Optional[dict[str, str]] = None
	labels: Optional[dict[str, str]] = None
	value: Optional[str] = None
	unit: Optional[str] = None
	required: Optional[bool] = None
	hide_condition: Optional[str] = None
	now: Optional[bool] = None
	translate: Optional[bool] = None

	def __serialize__(self) -> Any:
		return {
			"field": self.field,
			"shortLabel": self.short_label,
			"rows": self.rows,
			"columns": self.columns,
			"grows": self.grows,
			"multiline": self.multiline,
			"schema": self.schema,
			"tags": [x0 for x0 in self.tags] if self.tags is not None else None,
			"codifications": [x0 for x0 in self.codifications] if self.codifications is not None else None,
			"options": {k0: v0 for k0, v0 in self.options.items()} if self.options is not None else None,
			"labels": {k0: v0 for k0, v0 in self.labels.items()} if self.labels is not None else None,
			"value": self.value,
			"unit": self.unit,
			"required": self.required,
			"hideCondition": self.hide_condition,
			"now": self.now,
			"translate": self.translate,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'RadioButton':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			field=deserialized_dict["field"],
			short_label=deserialized_dict.get("shortLabel"),
			rows=deserialized_dict.get("rows"),
			columns=deserialized_dict.get("columns"),
			grows=deserialized_dict.get("grows"),
			multiline=deserialized_dict.get("multiline"),
			schema=deserialized_dict.get("schema"),
			tags=[x0 for x0 in deserialized_dict.get("tags")] if deserialized_dict.get("tags") is not None else None,
			codifications=[x0 for x0 in deserialized_dict.get("codifications")] if deserialized_dict.get("codifications") is not None else None,
			options=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("options").items())) if deserialized_dict.get("options") is not None else None,
			labels=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("labels").items())) if deserialized_dict.get("labels") is not None else None,
			value=deserialized_dict.get("value"),
			unit=deserialized_dict.get("unit"),
			required=deserialized_dict.get("required"),
			hide_condition=deserialized_dict.get("hideCondition"),
			now=deserialized_dict.get("now"),
			translate=deserialized_dict.get("translate"),
		)

@dataclass
class DatePicker:
	field: str
	short_label: Optional[str] = None
	rows: Optional[int] = None
	columns: Optional[int] = None
	grows: Optional[bool] = None
	multiline: Optional[bool] = None
	schema: Optional[str] = None
	tags: Optional[list[str]] = None
	codifications: Optional[list[str]] = None
	options: Optional[dict[str, str]] = None
	labels: Optional[dict[str, str]] = None
	value: Optional[str] = None
	unit: Optional[str] = None
	required: Optional[bool] = None
	hide_condition: Optional[str] = None
	now: Optional[bool] = None
	translate: Optional[bool] = None

	def __serialize__(self) -> Any:
		return {
			"field": self.field,
			"shortLabel": self.short_label,
			"rows": self.rows,
			"columns": self.columns,
			"grows": self.grows,
			"multiline": self.multiline,
			"schema": self.schema,
			"tags": [x0 for x0 in self.tags] if self.tags is not None else None,
			"codifications": [x0 for x0 in self.codifications] if self.codifications is not None else None,
			"options": {k0: v0 for k0, v0 in self.options.items()} if self.options is not None else None,
			"labels": {k0: v0 for k0, v0 in self.labels.items()} if self.labels is not None else None,
			"value": self.value,
			"unit": self.unit,
			"required": self.required,
			"hideCondition": self.hide_condition,
			"now": self.now,
			"translate": self.translate,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DatePicker':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			field=deserialized_dict["field"],
			short_label=deserialized_dict.get("shortLabel"),
			rows=deserialized_dict.get("rows"),
			columns=deserialized_dict.get("columns"),
			grows=deserialized_dict.get("grows"),
			multiline=deserialized_dict.get("multiline"),
			schema=deserialized_dict.get("schema"),
			tags=[x0 for x0 in deserialized_dict.get("tags")] if deserialized_dict.get("tags") is not None else None,
			codifications=[x0 for x0 in deserialized_dict.get("codifications")] if deserialized_dict.get("codifications") is not None else None,
			options=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("options").items())) if deserialized_dict.get("options") is not None else None,
			labels=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("labels").items())) if deserialized_dict.get("labels") is not None else None,
			value=deserialized_dict.get("value"),
			unit=deserialized_dict.get("unit"),
			required=deserialized_dict.get("required"),
			hide_condition=deserialized_dict.get("hideCondition"),
			now=deserialized_dict.get("now"),
			translate=deserialized_dict.get("translate"),
		)

@dataclass
class TimePicker:
	field: str
	short_label: Optional[str] = None
	rows: Optional[int] = None
	columns: Optional[int] = None
	grows: Optional[bool] = None
	multiline: Optional[bool] = None
	schema: Optional[str] = None
	tags: Optional[list[str]] = None
	codifications: Optional[list[str]] = None
	options: Optional[dict[str, str]] = None
	labels: Optional[dict[str, str]] = None
	value: Optional[str] = None
	unit: Optional[str] = None
	required: Optional[bool] = None
	hide_condition: Optional[str] = None
	now: Optional[bool] = None
	translate: Optional[bool] = None

	def __serialize__(self) -> Any:
		return {
			"field": self.field,
			"shortLabel": self.short_label,
			"rows": self.rows,
			"columns": self.columns,
			"grows": self.grows,
			"multiline": self.multiline,
			"schema": self.schema,
			"tags": [x0 for x0 in self.tags] if self.tags is not None else None,
			"codifications": [x0 for x0 in self.codifications] if self.codifications is not None else None,
			"options": {k0: v0 for k0, v0 in self.options.items()} if self.options is not None else None,
			"labels": {k0: v0 for k0, v0 in self.labels.items()} if self.labels is not None else None,
			"value": self.value,
			"unit": self.unit,
			"required": self.required,
			"hideCondition": self.hide_condition,
			"now": self.now,
			"translate": self.translate,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'TimePicker':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			field=deserialized_dict["field"],
			short_label=deserialized_dict.get("shortLabel"),
			rows=deserialized_dict.get("rows"),
			columns=deserialized_dict.get("columns"),
			grows=deserialized_dict.get("grows"),
			multiline=deserialized_dict.get("multiline"),
			schema=deserialized_dict.get("schema"),
			tags=[x0 for x0 in deserialized_dict.get("tags")] if deserialized_dict.get("tags") is not None else None,
			codifications=[x0 for x0 in deserialized_dict.get("codifications")] if deserialized_dict.get("codifications") is not None else None,
			options=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("options").items())) if deserialized_dict.get("options") is not None else None,
			labels=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("labels").items())) if deserialized_dict.get("labels") is not None else None,
			value=deserialized_dict.get("value"),
			unit=deserialized_dict.get("unit"),
			required=deserialized_dict.get("required"),
			hide_condition=deserialized_dict.get("hideCondition"),
			now=deserialized_dict.get("now"),
			translate=deserialized_dict.get("translate"),
		)

@dataclass
class DateTimePicker:
	field: str
	short_label: Optional[str] = None
	rows: Optional[int] = None
	columns: Optional[int] = None
	grows: Optional[bool] = None
	multiline: Optional[bool] = None
	schema: Optional[str] = None
	tags: Optional[list[str]] = None
	codifications: Optional[list[str]] = None
	options: Optional[dict[str, str]] = None
	labels: Optional[dict[str, str]] = None
	value: Optional[str] = None
	unit: Optional[str] = None
	required: Optional[bool] = None
	hide_condition: Optional[str] = None
	now: Optional[bool] = None
	translate: Optional[bool] = None

	def __serialize__(self) -> Any:
		return {
			"field": self.field,
			"shortLabel": self.short_label,
			"rows": self.rows,
			"columns": self.columns,
			"grows": self.grows,
			"multiline": self.multiline,
			"schema": self.schema,
			"tags": [x0 for x0 in self.tags] if self.tags is not None else None,
			"codifications": [x0 for x0 in self.codifications] if self.codifications is not None else None,
			"options": {k0: v0 for k0, v0 in self.options.items()} if self.options is not None else None,
			"labels": {k0: v0 for k0, v0 in self.labels.items()} if self.labels is not None else None,
			"value": self.value,
			"unit": self.unit,
			"required": self.required,
			"hideCondition": self.hide_condition,
			"now": self.now,
			"translate": self.translate,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'DateTimePicker':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			field=deserialized_dict["field"],
			short_label=deserialized_dict.get("shortLabel"),
			rows=deserialized_dict.get("rows"),
			columns=deserialized_dict.get("columns"),
			grows=deserialized_dict.get("grows"),
			multiline=deserialized_dict.get("multiline"),
			schema=deserialized_dict.get("schema"),
			tags=[x0 for x0 in deserialized_dict.get("tags")] if deserialized_dict.get("tags") is not None else None,
			codifications=[x0 for x0 in deserialized_dict.get("codifications")] if deserialized_dict.get("codifications") is not None else None,
			options=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("options").items())) if deserialized_dict.get("options") is not None else None,
			labels=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("labels").items())) if deserialized_dict.get("labels") is not None else None,
			value=deserialized_dict.get("value"),
			unit=deserialized_dict.get("unit"),
			required=deserialized_dict.get("required"),
			hide_condition=deserialized_dict.get("hideCondition"),
			now=deserialized_dict.get("now"),
			translate=deserialized_dict.get("translate"),
		)

@dataclass
class NumberField:
	field: str
	short_label: Optional[str] = None
	rows: Optional[int] = None
	columns: Optional[int] = None
	grows: Optional[bool] = None
	multiline: Optional[bool] = None
	schema: Optional[str] = None
	tags: Optional[list[str]] = None
	codifications: Optional[list[str]] = None
	options: Optional[dict[str, str]] = None
	labels: Optional[dict[str, str]] = None
	value: Optional[str] = None
	unit: Optional[str] = None
	required: Optional[bool] = None
	hide_condition: Optional[str] = None
	now: Optional[bool] = None
	translate: Optional[bool] = None

	def __serialize__(self) -> Any:
		return {
			"field": self.field,
			"shortLabel": self.short_label,
			"rows": self.rows,
			"columns": self.columns,
			"grows": self.grows,
			"multiline": self.multiline,
			"schema": self.schema,
			"tags": [x0 for x0 in self.tags] if self.tags is not None else None,
			"codifications": [x0 for x0 in self.codifications] if self.codifications is not None else None,
			"options": {k0: v0 for k0, v0 in self.options.items()} if self.options is not None else None,
			"labels": {k0: v0 for k0, v0 in self.labels.items()} if self.labels is not None else None,
			"value": self.value,
			"unit": self.unit,
			"required": self.required,
			"hideCondition": self.hide_condition,
			"now": self.now,
			"translate": self.translate,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'NumberField':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			field=deserialized_dict["field"],
			short_label=deserialized_dict.get("shortLabel"),
			rows=deserialized_dict.get("rows"),
			columns=deserialized_dict.get("columns"),
			grows=deserialized_dict.get("grows"),
			multiline=deserialized_dict.get("multiline"),
			schema=deserialized_dict.get("schema"),
			tags=[x0 for x0 in deserialized_dict.get("tags")] if deserialized_dict.get("tags") is not None else None,
			codifications=[x0 for x0 in deserialized_dict.get("codifications")] if deserialized_dict.get("codifications") is not None else None,
			options=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("options").items())) if deserialized_dict.get("options") is not None else None,
			labels=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("labels").items())) if deserialized_dict.get("labels") is not None else None,
			value=deserialized_dict.get("value"),
			unit=deserialized_dict.get("unit"),
			required=deserialized_dict.get("required"),
			hide_condition=deserialized_dict.get("hideCondition"),
			now=deserialized_dict.get("now"),
			translate=deserialized_dict.get("translate"),
		)

@dataclass
class TextField:
	field: str
	short_label: Optional[str] = None
	rows: Optional[int] = None
	columns: Optional[int] = None
	grows: Optional[bool] = None
	multiline: Optional[bool] = None
	schema: Optional[str] = None
	tags: Optional[list[str]] = None
	codifications: Optional[list[str]] = None
	options: Optional[dict[str, str]] = None
	labels: Optional[dict[str, str]] = None
	value: Optional[str] = None
	unit: Optional[str] = None
	required: Optional[bool] = None
	hide_condition: Optional[str] = None
	now: Optional[bool] = None
	translate: Optional[bool] = None

	def __serialize__(self) -> Any:
		return {
			"field": self.field,
			"shortLabel": self.short_label,
			"rows": self.rows,
			"columns": self.columns,
			"grows": self.grows,
			"multiline": self.multiline,
			"schema": self.schema,
			"tags": [x0 for x0 in self.tags] if self.tags is not None else None,
			"codifications": [x0 for x0 in self.codifications] if self.codifications is not None else None,
			"options": {k0: v0 for k0, v0 in self.options.items()} if self.options is not None else None,
			"labels": {k0: v0 for k0, v0 in self.labels.items()} if self.labels is not None else None,
			"value": self.value,
			"unit": self.unit,
			"required": self.required,
			"hideCondition": self.hide_condition,
			"now": self.now,
			"translate": self.translate,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'TextField':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			field=deserialized_dict["field"],
			short_label=deserialized_dict.get("shortLabel"),
			rows=deserialized_dict.get("rows"),
			columns=deserialized_dict.get("columns"),
			grows=deserialized_dict.get("grows"),
			multiline=deserialized_dict.get("multiline"),
			schema=deserialized_dict.get("schema"),
			tags=[x0 for x0 in deserialized_dict.get("tags")] if deserialized_dict.get("tags") is not None else None,
			codifications=[x0 for x0 in deserialized_dict.get("codifications")] if deserialized_dict.get("codifications") is not None else None,
			options=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("options").items())) if deserialized_dict.get("options") is not None else None,
			labels=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("labels").items())) if deserialized_dict.get("labels") is not None else None,
			value=deserialized_dict.get("value"),
			unit=deserialized_dict.get("unit"),
			required=deserialized_dict.get("required"),
			hide_condition=deserialized_dict.get("hideCondition"),
			now=deserialized_dict.get("now"),
			translate=deserialized_dict.get("translate"),
		)

@dataclass
class CheckBox:
	field: str
	short_label: Optional[str] = None
	rows: Optional[int] = None
	columns: Optional[int] = None
	grows: Optional[bool] = None
	multiline: Optional[bool] = None
	schema: Optional[str] = None
	tags: Optional[list[str]] = None
	codifications: Optional[list[str]] = None
	options: Optional[dict[str, str]] = None
	labels: Optional[dict[str, str]] = None
	value: Optional[str] = None
	unit: Optional[str] = None
	required: Optional[bool] = None
	hide_condition: Optional[str] = None
	now: Optional[bool] = None
	translate: Optional[bool] = None

	def __serialize__(self) -> Any:
		return {
			"field": self.field,
			"shortLabel": self.short_label,
			"rows": self.rows,
			"columns": self.columns,
			"grows": self.grows,
			"multiline": self.multiline,
			"schema": self.schema,
			"tags": [x0 for x0 in self.tags] if self.tags is not None else None,
			"codifications": [x0 for x0 in self.codifications] if self.codifications is not None else None,
			"options": {k0: v0 for k0, v0 in self.options.items()} if self.options is not None else None,
			"labels": {k0: v0 for k0, v0 in self.labels.items()} if self.labels is not None else None,
			"value": self.value,
			"unit": self.unit,
			"required": self.required,
			"hideCondition": self.hide_condition,
			"now": self.now,
			"translate": self.translate,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'CheckBox':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			field=deserialized_dict["field"],
			short_label=deserialized_dict.get("shortLabel"),
			rows=deserialized_dict.get("rows"),
			columns=deserialized_dict.get("columns"),
			grows=deserialized_dict.get("grows"),
			multiline=deserialized_dict.get("multiline"),
			schema=deserialized_dict.get("schema"),
			tags=[x0 for x0 in deserialized_dict.get("tags")] if deserialized_dict.get("tags") is not None else None,
			codifications=[x0 for x0 in deserialized_dict.get("codifications")] if deserialized_dict.get("codifications") is not None else None,
			options=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("options").items())) if deserialized_dict.get("options") is not None else None,
			labels=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("labels").items())) if deserialized_dict.get("labels") is not None else None,
			value=deserialized_dict.get("value"),
			unit=deserialized_dict.get("unit"),
			required=deserialized_dict.get("required"),
			hide_condition=deserialized_dict.get("hideCondition"),
			now=deserialized_dict.get("now"),
			translate=deserialized_dict.get("translate"),
		)

@dataclass
class MultipleChoice:
	field: str
	short_label: Optional[str] = None
	rows: Optional[int] = None
	columns: Optional[int] = None
	grows: Optional[bool] = None
	multiline: Optional[bool] = None
	schema: Optional[str] = None
	tags: Optional[list[str]] = None
	codifications: Optional[list[str]] = None
	options: Optional[dict[str, str]] = None
	labels: Optional[dict[str, str]] = None
	value: Optional[str] = None
	unit: Optional[str] = None
	required: Optional[bool] = None
	hide_condition: Optional[str] = None
	now: Optional[bool] = None
	translate: Optional[bool] = None

	def __serialize__(self) -> Any:
		return {
			"field": self.field,
			"shortLabel": self.short_label,
			"rows": self.rows,
			"columns": self.columns,
			"grows": self.grows,
			"multiline": self.multiline,
			"schema": self.schema,
			"tags": [x0 for x0 in self.tags] if self.tags is not None else None,
			"codifications": [x0 for x0 in self.codifications] if self.codifications is not None else None,
			"options": {k0: v0 for k0, v0 in self.options.items()} if self.options is not None else None,
			"labels": {k0: v0 for k0, v0 in self.labels.items()} if self.labels is not None else None,
			"value": self.value,
			"unit": self.unit,
			"required": self.required,
			"hideCondition": self.hide_condition,
			"now": self.now,
			"translate": self.translate,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'MultipleChoice':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			field=deserialized_dict["field"],
			short_label=deserialized_dict.get("shortLabel"),
			rows=deserialized_dict.get("rows"),
			columns=deserialized_dict.get("columns"),
			grows=deserialized_dict.get("grows"),
			multiline=deserialized_dict.get("multiline"),
			schema=deserialized_dict.get("schema"),
			tags=[x0 for x0 in deserialized_dict.get("tags")] if deserialized_dict.get("tags") is not None else None,
			codifications=[x0 for x0 in deserialized_dict.get("codifications")] if deserialized_dict.get("codifications") is not None else None,
			options=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("options").items())) if deserialized_dict.get("options") is not None else None,
			labels=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("labels").items())) if deserialized_dict.get("labels") is not None else None,
			value=deserialized_dict.get("value"),
			unit=deserialized_dict.get("unit"),
			required=deserialized_dict.get("required"),
			hide_condition=deserialized_dict.get("hideCondition"),
			now=deserialized_dict.get("now"),
			translate=deserialized_dict.get("translate"),
		)

@dataclass
class MeasureField:
	field: str
	short_label: Optional[str] = None
	rows: Optional[int] = None
	columns: Optional[int] = None
	grows: Optional[bool] = None
	multiline: Optional[bool] = None
	schema: Optional[str] = None
	tags: Optional[list[str]] = None
	codifications: Optional[list[str]] = None
	options: Optional[dict[str, str]] = None
	labels: Optional[dict[str, str]] = None
	value: Optional[str] = None
	unit: Optional[str] = None
	required: Optional[bool] = None
	hide_condition: Optional[str] = None
	now: Optional[bool] = None
	translate: Optional[bool] = None

	def __serialize__(self) -> Any:
		return {
			"field": self.field,
			"shortLabel": self.short_label,
			"rows": self.rows,
			"columns": self.columns,
			"grows": self.grows,
			"multiline": self.multiline,
			"schema": self.schema,
			"tags": [x0 for x0 in self.tags] if self.tags is not None else None,
			"codifications": [x0 for x0 in self.codifications] if self.codifications is not None else None,
			"options": {k0: v0 for k0, v0 in self.options.items()} if self.options is not None else None,
			"labels": {k0: v0 for k0, v0 in self.labels.items()} if self.labels is not None else None,
			"value": self.value,
			"unit": self.unit,
			"required": self.required,
			"hideCondition": self.hide_condition,
			"now": self.now,
			"translate": self.translate,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'MeasureField':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			field=deserialized_dict["field"],
			short_label=deserialized_dict.get("shortLabel"),
			rows=deserialized_dict.get("rows"),
			columns=deserialized_dict.get("columns"),
			grows=deserialized_dict.get("grows"),
			multiline=deserialized_dict.get("multiline"),
			schema=deserialized_dict.get("schema"),
			tags=[x0 for x0 in deserialized_dict.get("tags")] if deserialized_dict.get("tags") is not None else None,
			codifications=[x0 for x0 in deserialized_dict.get("codifications")] if deserialized_dict.get("codifications") is not None else None,
			options=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("options").items())) if deserialized_dict.get("options") is not None else None,
			labels=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("labels").items())) if deserialized_dict.get("labels") is not None else None,
			value=deserialized_dict.get("value"),
			unit=deserialized_dict.get("unit"),
			required=deserialized_dict.get("required"),
			hide_condition=deserialized_dict.get("hideCondition"),
			now=deserialized_dict.get("now"),
			translate=deserialized_dict.get("translate"),
		)

@dataclass
class FieldsGroup:
	group: str
	fields: Optional[list['StructureElement']] = None

	def __serialize__(self) -> Any:
		return {
			"group": self.group,
			"fields": [serialize_structure_element(x0) for x0 in self.fields] if self.fields is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'FieldsGroup':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			group=deserialized_dict["group"],
			fields=[deserialize_structure_element(x0) for x0 in deserialized_dict.get("fields")] if deserialized_dict.get("fields") is not None else None,
		)

type StructureElement = Union['DropdownField', 'RadioButton', 'DatePicker', 'TimePicker', 'DateTimePicker', 'NumberField', 'TextField', 'CheckBox', 'MultipleChoice', 'MeasureField', 'FieldsGroup']

def serialize_structure_element(structure_element: StructureElement) -> Any:
	if isinstance(structure_element, DropdownField):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.form.template.DropdownField"})
		return serialized_entity
	elif isinstance(structure_element, RadioButton):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.form.template.RadioButton"})
		return serialized_entity
	elif isinstance(structure_element, DatePicker):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.form.template.DatePicker"})
		return serialized_entity
	elif isinstance(structure_element, TimePicker):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.form.template.TimePicker"})
		return serialized_entity
	elif isinstance(structure_element, DateTimePicker):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.form.template.DateTimePicker"})
		return serialized_entity
	elif isinstance(structure_element, NumberField):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.form.template.NumberField"})
		return serialized_entity
	elif isinstance(structure_element, TextField):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.form.template.TextField"})
		return serialized_entity
	elif isinstance(structure_element, CheckBox):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.form.template.CheckBox"})
		return serialized_entity
	elif isinstance(structure_element, MultipleChoice):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.form.template.MultipleChoice"})
		return serialized_entity
	elif isinstance(structure_element, MeasureField):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.form.template.MeasureField"})
		return serialized_entity
	elif isinstance(structure_element, FieldsGroup):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"kotlinType": "com.icure.cardinal.sdk.model.embed.form.template.FieldsGroup"})
		return serialized_entity
	else:
		raise Exception(f"{type(structure_element)} is not a known subclass of StructureElement")

def deserialize_structure_element(data: Union[str, dict[str, JsonElement]]) -> 'StructureElement':
	deserialized_dict: dict[str, JsonElement]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("kotlinType")
	if qualifier is None:
		raise Exception("Missing qualifier: kotlinType")
	if qualifier == "com.icure.cardinal.sdk.model.embed.form.template.DropdownField":
		return DropdownField._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.embed.form.template.RadioButton":
		return RadioButton._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.embed.form.template.DatePicker":
		return DatePicker._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.embed.form.template.TimePicker":
		return TimePicker._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.embed.form.template.DateTimePicker":
		return DateTimePicker._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.embed.form.template.NumberField":
		return NumberField._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.embed.form.template.TextField":
		return TextField._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.embed.form.template.CheckBox":
		return CheckBox._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.embed.form.template.MultipleChoice":
		return MultipleChoice._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.embed.form.template.MeasureField":
		return MeasureField._deserialize(deserialized_dict)
	elif qualifier == "com.icure.cardinal.sdk.model.embed.form.template.FieldsGroup":
		return FieldsGroup._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of StructureElement")

@dataclass
class ReferenceRange:
	low: Optional[float] = None
	high: Optional[float] = None
	string_value: Optional[str] = None
	tags: list['CodeStub'] = field(default_factory=list)
	codes: list['CodeStub'] = field(default_factory=list)
	notes: list['Annotation'] = field(default_factory=list)
	age: Optional['Range'] = None

	def __serialize__(self) -> Any:
		return {
			"low": self.low,
			"high": self.high,
			"stringValue": self.string_value,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"notes": [x0.__serialize__() for x0 in self.notes],
			"age": self.age.__serialize__() if self.age is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ReferenceRange':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			low=deserialized_dict.get("low"),
			high=deserialized_dict.get("high"),
			string_value=deserialized_dict.get("stringValue"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			notes=[Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
			age=Range._deserialize(deserialized_dict.get("age")) if deserialized_dict.get("age") is not None else None,
		)

@dataclass
class ValueWithPrecision:
	value: int
	precision: int

	def __serialize__(self) -> Any:
		return {
			"value": self.value,
			"precision": self.precision,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ValueWithPrecision':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			value=deserialized_dict["value"],
			precision=deserialized_dict["precision"],
		)

@dataclass
class Substanceproduct:
	intendedcds: list['CodeStub'] = field(default_factory=list)
	deliveredcds: list['CodeStub'] = field(default_factory=list)
	intendedname: Optional[str] = None
	deliveredname: Optional[str] = None
	product_id: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"intendedcds": [x0.__serialize__() for x0 in self.intendedcds],
			"deliveredcds": [x0.__serialize__() for x0 in self.deliveredcds],
			"intendedname": self.intendedname,
			"deliveredname": self.deliveredname,
			"productId": self.product_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Substanceproduct':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			intendedcds=[CodeStub._deserialize(x0) for x0 in deserialized_dict["intendedcds"]],
			deliveredcds=[CodeStub._deserialize(x0) for x0 in deserialized_dict["deliveredcds"]],
			intendedname=deserialized_dict.get("intendedname"),
			deliveredname=deserialized_dict.get("deliveredname"),
			product_id=deserialized_dict.get("productId"),
		)

@dataclass
class Medicinalproduct:
	intendedcds: list['CodeStub'] = field(default_factory=list)
	deliveredcds: list['CodeStub'] = field(default_factory=list)
	intendedname: Optional[str] = None
	deliveredname: Optional[str] = None
	product_id: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"intendedcds": [x0.__serialize__() for x0 in self.intendedcds],
			"deliveredcds": [x0.__serialize__() for x0 in self.deliveredcds],
			"intendedname": self.intendedname,
			"deliveredname": self.deliveredname,
			"productId": self.product_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Medicinalproduct':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			intendedcds=[CodeStub._deserialize(x0) for x0 in deserialized_dict["intendedcds"]],
			deliveredcds=[CodeStub._deserialize(x0) for x0 in deserialized_dict["deliveredcds"]],
			intendedname=deserialized_dict.get("intendedname"),
			deliveredname=deserialized_dict.get("deliveredname"),
			product_id=deserialized_dict.get("productId"),
		)

@dataclass
class Duration:
	value: Optional[float] = None
	unit: Optional['CodeStub'] = None

	def __serialize__(self) -> Any:
		return {
			"value": self.value,
			"unit": self.unit.__serialize__() if self.unit is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Duration':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			value=deserialized_dict.get("value"),
			unit=CodeStub._deserialize(deserialized_dict.get("unit")) if deserialized_dict.get("unit") is not None else None,
		)

@dataclass
class Renewal:
	decimal: Optional[int] = None
	duration: Optional['Duration'] = None

	def __serialize__(self) -> Any:
		return {
			"decimal": self.decimal,
			"duration": self.duration.__serialize__() if self.duration is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Renewal':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			decimal=deserialized_dict.get("decimal"),
			duration=Duration._deserialize(deserialized_dict.get("duration")) if deserialized_dict.get("duration") is not None else None,
		)

@dataclass
class RegimenItem:
	date: Optional[int] = None
	day_number: Optional[int] = None
	weekday: Optional['Weekday'] = None
	day_period: Optional['CodeStub'] = None
	time_of_day: Optional[int] = None
	administrated_quantity: Optional['AdministrationQuantity'] = None

	def __serialize__(self) -> Any:
		return {
			"date": self.date,
			"dayNumber": self.day_number,
			"weekday": self.weekday.__serialize__() if self.weekday is not None else None,
			"dayPeriod": self.day_period.__serialize__() if self.day_period is not None else None,
			"timeOfDay": self.time_of_day,
			"administratedQuantity": self.administrated_quantity.__serialize__() if self.administrated_quantity is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'RegimenItem':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			date=deserialized_dict.get("date"),
			day_number=deserialized_dict.get("dayNumber"),
			weekday=Weekday._deserialize(deserialized_dict.get("weekday")) if deserialized_dict.get("weekday") is not None else None,
			day_period=CodeStub._deserialize(deserialized_dict.get("dayPeriod")) if deserialized_dict.get("dayPeriod") is not None else None,
			time_of_day=deserialized_dict.get("timeOfDay"),
			administrated_quantity=AdministrationQuantity._deserialize(deserialized_dict.get("administratedQuantity")) if deserialized_dict.get("administratedQuantity") is not None else None,
		)

@dataclass
class ParagraphAgreement:
	timestamp: Optional[int] = None
	paragraph: Optional[str] = None
	accepted: Optional[bool] = None
	in_treatment: Optional[bool] = None
	canceled: Optional[bool] = None
	care_provider_reference: Optional[str] = None
	decision_reference: Optional[str] = None
	start: Optional[int] = None
	end: Optional[int] = None
	cancelation_date: Optional[int] = None
	quantity_value: Optional[float] = None
	quantity_unit: Optional[str] = None
	io_request_reference: Optional[str] = None
	response_type: Optional[str] = None
	refusal_justification: Optional[dict[str, str]] = None
	verses: Optional[set[int]] = None
	coverage_type: Optional[str] = None
	unit_number: Optional[float] = None
	strength: Optional[float] = None
	strength_unit: Optional[str] = None
	agreement_appendices: Optional[list['AgreementAppendix']] = None
	document_id: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"timestamp": self.timestamp,
			"paragraph": self.paragraph,
			"accepted": self.accepted,
			"inTreatment": self.in_treatment,
			"canceled": self.canceled,
			"careProviderReference": self.care_provider_reference,
			"decisionReference": self.decision_reference,
			"start": self.start,
			"end": self.end,
			"cancelationDate": self.cancelation_date,
			"quantityValue": self.quantity_value,
			"quantityUnit": self.quantity_unit,
			"ioRequestReference": self.io_request_reference,
			"responseType": self.response_type,
			"refusalJustification": {k0: v0 for k0, v0 in self.refusal_justification.items()} if self.refusal_justification is not None else None,
			"verses": [x0 for x0 in self.verses] if self.verses is not None else None,
			"coverageType": self.coverage_type,
			"unitNumber": self.unit_number,
			"strength": self.strength,
			"strengthUnit": self.strength_unit,
			"agreementAppendices": [x0.__serialize__() for x0 in self.agreement_appendices] if self.agreement_appendices is not None else None,
			"documentId": self.document_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'ParagraphAgreement':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			timestamp=deserialized_dict.get("timestamp"),
			paragraph=deserialized_dict.get("paragraph"),
			accepted=deserialized_dict.get("accepted"),
			in_treatment=deserialized_dict.get("inTreatment"),
			canceled=deserialized_dict.get("canceled"),
			care_provider_reference=deserialized_dict.get("careProviderReference"),
			decision_reference=deserialized_dict.get("decisionReference"),
			start=deserialized_dict.get("start"),
			end=deserialized_dict.get("end"),
			cancelation_date=deserialized_dict.get("cancelationDate"),
			quantity_value=deserialized_dict.get("quantityValue"),
			quantity_unit=deserialized_dict.get("quantityUnit"),
			io_request_reference=deserialized_dict.get("ioRequestReference"),
			response_type=deserialized_dict.get("responseType"),
			refusal_justification=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("refusalJustification").items())) if deserialized_dict.get("refusalJustification") is not None else None,
			verses={x0 for x0 in deserialized_dict.get("verses")} if deserialized_dict.get("verses") is not None else None,
			coverage_type=deserialized_dict.get("coverageType"),
			unit_number=deserialized_dict.get("unitNumber"),
			strength=deserialized_dict.get("strength"),
			strength_unit=deserialized_dict.get("strengthUnit"),
			agreement_appendices=[AgreementAppendix._deserialize(x0) for x0 in deserialized_dict.get("agreementAppendices")] if deserialized_dict.get("agreementAppendices") is not None else None,
			document_id=deserialized_dict.get("documentId"),
		)

@dataclass
class Suspension:
	begin_moment: Optional[int] = None
	end_moment: Optional[int] = None
	suspension_reason: Optional[str] = None
	lifecycle: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"beginMoment": self.begin_moment,
			"endMoment": self.end_moment,
			"suspensionReason": self.suspension_reason,
			"lifecycle": self.lifecycle,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Suspension':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			begin_moment=deserialized_dict.get("beginMoment"),
			end_moment=deserialized_dict.get("endMoment"),
			suspension_reason=deserialized_dict.get("suspensionReason"),
			lifecycle=deserialized_dict.get("lifecycle"),
		)

class MembershipType(Enum):
	Doctor = "doctor"
	Mutuality = "mutuality"
	Patient = "patient"
	Specialist = "specialist"
	Other = "other"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'MembershipType':
		if data == "doctor":
			return MembershipType.Doctor
		elif data == "mutuality":
			return MembershipType.Mutuality
		elif data == "patient":
			return MembershipType.Patient
		elif data == "specialist":
			return MembershipType.Specialist
		elif data == "other":
			return MembershipType.Other
		else:
			raise Exception(f"{data} is not a valid value for MembershipType enum.")

@dataclass
class Basic:
	username: str
	password: str

	def __serialize__(self) -> Any:
		return {
			"username": self.username,
			"password": self.password,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Basic':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			username=deserialized_dict["username"],
			password=deserialized_dict["password"],
		)

@dataclass
class EmbeddedTimeTableHour:
	start_hour: int
	end_hour: int

	def __serialize__(self) -> Any:
		return {
			"startHour": self.start_hour,
			"endHour": self.end_hour,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'EmbeddedTimeTableHour':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			start_hour=deserialized_dict["startHour"],
			end_hour=deserialized_dict["endHour"],
		)

class Trigger(Enum):
	Init = "INIT"
	Change = "CHANGE"
	Click = "CLICK"
	Visible = "VISIBLE"
	Error = "ERROR"
	Valid = "VALID"
	Event = "EVENT"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Trigger':
		if data == "INIT":
			return Trigger.Init
		elif data == "CHANGE":
			return Trigger.Change
		elif data == "CLICK":
			return Trigger.Click
		elif data == "VISIBLE":
			return Trigger.Visible
		elif data == "ERROR":
			return Trigger.Error
		elif data == "VALID":
			return Trigger.Valid
		elif data == "EVENT":
			return Trigger.Event
		else:
			raise Exception(f"{data} is not a valid value for Trigger enum.")

class StateToUpdate(Enum):
	Value = "VALUE"
	Visible = "VISIBLE"
	Readonly = "READONLY"
	Clazz = "CLAZZ"
	Required = "REQUIRED"

	def __serialize__(self) -> Any:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'StateToUpdate':
		if data == "VALUE":
			return StateToUpdate.Value
		elif data == "VISIBLE":
			return StateToUpdate.Visible
		elif data == "READONLY":
			return StateToUpdate.Readonly
		elif data == "CLAZZ":
			return StateToUpdate.Clazz
		elif data == "REQUIRED":
			return StateToUpdate.Required
		else:
			raise Exception(f"{data} is not a valid value for StateToUpdate enum.")

@dataclass
class Range:
	low: Optional[float] = None
	high: Optional[float] = None

	def __serialize__(self) -> Any:
		return {
			"low": self.low,
			"high": self.high,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Range':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			low=deserialized_dict.get("low"),
			high=deserialized_dict.get("high"),
		)

@dataclass
class Weekday:
	weekday: Optional['CodeStub'] = None
	week_number: Optional[int] = None

	def __serialize__(self) -> Any:
		return {
			"weekday": self.weekday.__serialize__() if self.weekday is not None else None,
			"weekNumber": self.week_number,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'Weekday':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			weekday=CodeStub._deserialize(deserialized_dict.get("weekday")) if deserialized_dict.get("weekday") is not None else None,
			week_number=deserialized_dict.get("weekNumber"),
		)

@dataclass
class AdministrationQuantity:
	quantity: Optional[float] = None
	administration_unit: Optional['CodeStub'] = None
	unit: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"quantity": self.quantity,
			"administrationUnit": self.administration_unit.__serialize__() if self.administration_unit is not None else None,
			"unit": self.unit,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'AdministrationQuantity':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			quantity=deserialized_dict.get("quantity"),
			administration_unit=CodeStub._deserialize(deserialized_dict.get("administrationUnit")) if deserialized_dict.get("administrationUnit") is not None else None,
			unit=deserialized_dict.get("unit"),
		)

@dataclass
class AgreementAppendix:
	doc_seq: Optional[int] = None
	verse_seq: Optional[int] = None
	document_id: Optional[str] = None
	path: Optional[str] = None

	def __serialize__(self) -> Any:
		return {
			"docSeq": self.doc_seq,
			"verseSeq": self.verse_seq,
			"documentId": self.document_id,
			"path": self.path,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, dict[str, JsonElement]]) -> 'AgreementAppendix':
		deserialized_dict: dict[str, JsonElement]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			doc_seq=deserialized_dict.get("docSeq"),
			verse_seq=deserialized_dict.get("verseSeq"),
			document_id=deserialized_dict.get("documentId"),
			path=deserialized_dict.get("path"),
		)
