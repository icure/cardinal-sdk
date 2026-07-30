# auto-generated file
import json
from typing import Optional
from cardinal_sdk.model import DecryptedRelatedPerson, User, AccessLevel, RelatedPersonDelegateOptions, RelatedPerson, serialize_related_person, EncryptedRelatedPerson, deserialize_related_person, StoredDocumentIdentifier, RelatedPersonShareOptions, SubscriptionEventType, EntitySubscriptionConfiguration, EntityReferenceInGroup, GroupScoped
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.model.specializations import HexString
from cardinal_sdk.filters.FilterOptions import FilterOptions, SortableFilterOptions
from cardinal_sdk.pagination.PaginatedListIterator import PaginatedListIterator
from cardinal_sdk.subscription.EntitySubscription import EntitySubscription


class RelatedPersonApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk
		self.encrypted = RelatedPersonApiEncrypted(self.cardinal_sdk)
		self.try_and_recover = RelatedPersonApiTryAndRecover(self.cardinal_sdk)
		self.in_group = RelatedPersonApiInGroup(self.cardinal_sdk)

	async def with_encryption_metadata_async(self, base: Optional[DecryptedRelatedPerson], user: Optional[User] = None, delegates: dict[str, AccessLevel] = {}, alternate_root_delegate_id: Optional[str] = None) -> DecryptedRelatedPerson:
		def do_decode(raw_result):
			return DecryptedRelatedPerson._deserialize(raw_result)
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"alternateRootDelegateId": alternate_root_delegate_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.withEncryptionMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def with_encryption_metadata_blocking(self, base: Optional[DecryptedRelatedPerson], user: Optional[User] = None, delegates: dict[str, AccessLevel] = {}, alternate_root_delegate_id: Optional[str] = None) -> DecryptedRelatedPerson:
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"alternateRootDelegateId": alternate_root_delegate_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.withEncryptionMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedRelatedPerson._deserialize(result_info.success)
			return return_value

	async def with_encryption_metadata_and_delegates_async(self, base: Optional[DecryptedRelatedPerson], delegates: dict[str, RelatedPersonDelegateOptions], user: Optional[User] = None, alternate_root_delegate_id: Optional[str] = None) -> DecryptedRelatedPerson:
		def do_decode(raw_result):
			return DecryptedRelatedPerson._deserialize(raw_result)
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"user": user.__serialize__() if user is not None else None,
			"alternateRootDelegateId": alternate_root_delegate_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.withEncryptionMetadataAndDelegatesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def with_encryption_metadata_and_delegates_blocking(self, base: Optional[DecryptedRelatedPerson], delegates: dict[str, RelatedPersonDelegateOptions], user: Optional[User] = None, alternate_root_delegate_id: Optional[str] = None) -> DecryptedRelatedPerson:
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"user": user.__serialize__() if user is not None else None,
			"alternateRootDelegateId": alternate_root_delegate_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.withEncryptionMetadataAndDelegatesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedRelatedPerson._deserialize(result_info.success)
			return return_value

	async def get_encryption_keys_of_async(self, related_person: RelatedPerson) -> set[HexString]:
		def do_decode(raw_result):
			return {x1 for x1 in raw_result}
		payload = {
			"relatedPerson": serialize_related_person(related_person),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.getEncryptionKeysOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_encryption_keys_of_blocking(self, related_person: RelatedPerson) -> set[HexString]:
		payload = {
			"relatedPerson": serialize_related_person(related_person),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.getEncryptionKeysOfBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = {x1 for x1 in result_info.success}
			return return_value

	async def has_write_access_async(self, related_person: RelatedPerson) -> bool:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"relatedPerson": serialize_related_person(related_person),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.hasWriteAccessAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def has_write_access_blocking(self, related_person: RelatedPerson) -> bool:
		payload = {
			"relatedPerson": serialize_related_person(related_person),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.hasWriteAccessBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

	async def get_secret_ids_of_async(self, related_person: RelatedPerson) -> set[str]:
		def do_decode(raw_result):
			return {x1 for x1 in raw_result}
		payload = {
			"relatedPerson": serialize_related_person(related_person),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.getSecretIdsOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_secret_ids_of_blocking(self, related_person: RelatedPerson) -> set[str]:
		payload = {
			"relatedPerson": serialize_related_person(related_person),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.getSecretIdsOfBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = {x1 for x1 in result_info.success}
			return return_value

	async def create_delegation_de_anonymization_metadata_async(self, entity: RelatedPerson, delegates: set[str]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"entity": serialize_related_person(entity),
			"delegates": [x0 for x0 in delegates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.createDelegationDeAnonymizationMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_delegation_de_anonymization_metadata_blocking(self, entity: RelatedPerson, delegates: set[str]) -> None:
		payload = {
			"entity": serialize_related_person(entity),
			"delegates": [x0 for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.createDelegationDeAnonymizationMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def decrypt_async(self, related_persons: list[EncryptedRelatedPerson]) -> list[DecryptedRelatedPerson]:
		def do_decode(raw_result):
			return [DecryptedRelatedPerson._deserialize(x1) for x1 in raw_result]
		payload = {
			"relatedPersons": [x0.__serialize__() for x0 in related_persons],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.decryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_blocking(self, related_persons: list[EncryptedRelatedPerson]) -> list[DecryptedRelatedPerson]:
		payload = {
			"relatedPersons": [x0.__serialize__() for x0 in related_persons],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.decryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedRelatedPerson._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def try_decrypt_async(self, related_persons: list[EncryptedRelatedPerson]) -> list[RelatedPerson]:
		def do_decode(raw_result):
			return [deserialize_related_person(x1) for x1 in raw_result]
		payload = {
			"relatedPersons": [x0.__serialize__() for x0 in related_persons],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.tryDecryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def try_decrypt_blocking(self, related_persons: list[EncryptedRelatedPerson]) -> list[RelatedPerson]:
		payload = {
			"relatedPersons": [x0.__serialize__() for x0 in related_persons],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.tryDecryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_related_person(x1) for x1 in result_info.success]
			return return_value

	async def encrypt_or_validate_async(self, related_persons: list[RelatedPerson]) -> list[EncryptedRelatedPerson]:
		def do_decode(raw_result):
			return [EncryptedRelatedPerson._deserialize(x1) for x1 in raw_result]
		payload = {
			"relatedPersons": [serialize_related_person(x0) for x0 in related_persons],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.encryptOrValidateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def encrypt_or_validate_blocking(self, related_persons: list[RelatedPerson]) -> list[EncryptedRelatedPerson]:
		payload = {
			"relatedPersons": [serialize_related_person(x0) for x0 in related_persons],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.encryptOrValidateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedRelatedPerson._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def match_related_persons_by_async(self, filter: FilterOptions[RelatedPerson]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.matchRelatedPersonsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_related_persons_by_blocking(self, filter: FilterOptions[RelatedPerson]) -> list[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.matchRelatedPersonsByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def match_related_persons_by_sorted_async(self, filter: SortableFilterOptions[RelatedPerson]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.matchRelatedPersonsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_related_persons_by_sorted_blocking(self, filter: SortableFilterOptions[RelatedPerson]) -> list[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.matchRelatedPersonsBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def delete_related_person_by_id_async(self, entity_id: str, rev: str) -> StoredDocumentIdentifier:
		def do_decode(raw_result):
			return StoredDocumentIdentifier._deserialize(raw_result)
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.deleteRelatedPersonByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_related_person_by_id_blocking(self, entity_id: str, rev: str) -> StoredDocumentIdentifier:
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.deleteRelatedPersonByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = StoredDocumentIdentifier._deserialize(result_info.success)
			return return_value

	async def delete_related_persons_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.deleteRelatedPersonsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_related_persons_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.deleteRelatedPersonsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [StoredDocumentIdentifier._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def purge_related_person_by_id_async(self, id: str, rev: str) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.purgeRelatedPersonByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_related_person_by_id_blocking(self, id: str, rev: str) -> None:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.purgeRelatedPersonByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_related_persons_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.purgeRelatedPersonsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_related_persons_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.purgeRelatedPersonsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [StoredDocumentIdentifier._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def delete_related_person_async(self, related_person: RelatedPerson) -> StoredDocumentIdentifier:
		def do_decode(raw_result):
			return StoredDocumentIdentifier._deserialize(raw_result)
		payload = {
			"relatedPerson": serialize_related_person(related_person),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.deleteRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_related_person_blocking(self, related_person: RelatedPerson) -> StoredDocumentIdentifier:
		payload = {
			"relatedPerson": serialize_related_person(related_person),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.deleteRelatedPersonBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = StoredDocumentIdentifier._deserialize(result_info.success)
			return return_value

	async def delete_related_persons_async(self, related_persons: list[RelatedPerson]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"relatedPersons": [serialize_related_person(x0) for x0 in related_persons],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.deleteRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_related_persons_blocking(self, related_persons: list[RelatedPerson]) -> list[StoredDocumentIdentifier]:
		payload = {
			"relatedPersons": [serialize_related_person(x0) for x0 in related_persons],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.deleteRelatedPersonsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [StoredDocumentIdentifier._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def purge_related_person_async(self, related_person: RelatedPerson) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"relatedPerson": serialize_related_person(related_person),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.purgeRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_related_person_blocking(self, related_person: RelatedPerson) -> None:
		payload = {
			"relatedPerson": serialize_related_person(related_person),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.purgeRelatedPersonBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_related_persons_async(self, related_persons: list[RelatedPerson]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"relatedPersons": [serialize_related_person(x0) for x0 in related_persons],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.purgeRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_related_persons_blocking(self, related_persons: list[RelatedPerson]) -> list[StoredDocumentIdentifier]:
		payload = {
			"relatedPersons": [serialize_related_person(x0) for x0 in related_persons],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.purgeRelatedPersonsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [StoredDocumentIdentifier._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def share_with_async(self, delegate_id: str, related_person: DecryptedRelatedPerson, options: Optional[RelatedPersonShareOptions] = None) -> DecryptedRelatedPerson:
		def do_decode(raw_result):
			return DecryptedRelatedPerson._deserialize(raw_result)
		payload = {
			"delegateId": delegate_id,
			"relatedPerson": related_person.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, related_person: DecryptedRelatedPerson, options: Optional[RelatedPersonShareOptions] = None) -> DecryptedRelatedPerson:
		payload = {
			"delegateId": delegate_id,
			"relatedPerson": related_person.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedRelatedPerson._deserialize(result_info.success)
			return return_value

	async def share_with_many_async(self, related_person: DecryptedRelatedPerson, delegates: dict[str, RelatedPersonShareOptions]) -> DecryptedRelatedPerson:
		def do_decode(raw_result):
			return DecryptedRelatedPerson._deserialize(raw_result)
		payload = {
			"relatedPerson": related_person.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, related_person: DecryptedRelatedPerson, delegates: dict[str, RelatedPersonShareOptions]) -> DecryptedRelatedPerson:
		payload = {
			"relatedPerson": related_person.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedRelatedPerson._deserialize(result_info.success)
			return return_value

	async def filter_related_persons_by_async(self, filter: FilterOptions[RelatedPerson]) -> PaginatedListIterator[DecryptedRelatedPerson]:
		def do_decode(raw_result):
			return PaginatedListIterator[DecryptedRelatedPerson](
				producer = raw_result,
				deserializer = lambda x: DecryptedRelatedPerson._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.filterRelatedPersonsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_related_persons_by_blocking(self, filter: FilterOptions[RelatedPerson]) -> PaginatedListIterator[DecryptedRelatedPerson]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.filterRelatedPersonsByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[DecryptedRelatedPerson](
				producer = class_pointer,
				deserializer = lambda x: DecryptedRelatedPerson._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_related_persons_by_sorted_async(self, filter: SortableFilterOptions[RelatedPerson]) -> PaginatedListIterator[DecryptedRelatedPerson]:
		def do_decode(raw_result):
			return PaginatedListIterator[DecryptedRelatedPerson](
				producer = raw_result,
				deserializer = lambda x: DecryptedRelatedPerson._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.filterRelatedPersonsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_related_persons_by_sorted_blocking(self, filter: SortableFilterOptions[RelatedPerson]) -> PaginatedListIterator[DecryptedRelatedPerson]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.filterRelatedPersonsBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[DecryptedRelatedPerson](
				producer = class_pointer,
				deserializer = lambda x: DecryptedRelatedPerson._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def create_related_person_async(self, entity: DecryptedRelatedPerson) -> DecryptedRelatedPerson:
		def do_decode(raw_result):
			return DecryptedRelatedPerson._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.createRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_related_person_blocking(self, entity: DecryptedRelatedPerson) -> DecryptedRelatedPerson:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.createRelatedPersonBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedRelatedPerson._deserialize(result_info.success)
			return return_value

	async def create_related_persons_async(self, entities: list[DecryptedRelatedPerson]) -> list[DecryptedRelatedPerson]:
		def do_decode(raw_result):
			return [DecryptedRelatedPerson._deserialize(x1) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.createRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_related_persons_blocking(self, entities: list[DecryptedRelatedPerson]) -> list[DecryptedRelatedPerson]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.createRelatedPersonsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedRelatedPerson._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def undelete_related_person_by_id_async(self, id: str, rev: str) -> DecryptedRelatedPerson:
		def do_decode(raw_result):
			return DecryptedRelatedPerson._deserialize(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.undeleteRelatedPersonByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_person_by_id_blocking(self, id: str, rev: str) -> DecryptedRelatedPerson:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.undeleteRelatedPersonByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedRelatedPerson._deserialize(result_info.success)
			return return_value

	async def undelete_related_persons_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[DecryptedRelatedPerson]:
		def do_decode(raw_result):
			return [DecryptedRelatedPerson._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.undeleteRelatedPersonsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_persons_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[DecryptedRelatedPerson]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.undeleteRelatedPersonsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedRelatedPerson._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def undelete_related_person_async(self, related_person: RelatedPerson) -> DecryptedRelatedPerson:
		def do_decode(raw_result):
			return DecryptedRelatedPerson._deserialize(raw_result)
		payload = {
			"relatedPerson": serialize_related_person(related_person),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.undeleteRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_person_blocking(self, related_person: RelatedPerson) -> DecryptedRelatedPerson:
		payload = {
			"relatedPerson": serialize_related_person(related_person),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.undeleteRelatedPersonBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedRelatedPerson._deserialize(result_info.success)
			return return_value

	async def undelete_related_persons_async(self, related_persons: list[RelatedPerson]) -> list[DecryptedRelatedPerson]:
		def do_decode(raw_result):
			return [DecryptedRelatedPerson._deserialize(x1) for x1 in raw_result]
		payload = {
			"relatedPersons": [serialize_related_person(x0) for x0 in related_persons],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.undeleteRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_persons_blocking(self, related_persons: list[RelatedPerson]) -> list[DecryptedRelatedPerson]:
		payload = {
			"relatedPersons": [serialize_related_person(x0) for x0 in related_persons],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.undeleteRelatedPersonsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedRelatedPerson._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def modify_related_person_async(self, entity: DecryptedRelatedPerson) -> DecryptedRelatedPerson:
		def do_decode(raw_result):
			return DecryptedRelatedPerson._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.modifyRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_related_person_blocking(self, entity: DecryptedRelatedPerson) -> DecryptedRelatedPerson:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.modifyRelatedPersonBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedRelatedPerson._deserialize(result_info.success)
			return return_value

	async def modify_related_persons_async(self, entities: list[DecryptedRelatedPerson]) -> list[DecryptedRelatedPerson]:
		def do_decode(raw_result):
			return [DecryptedRelatedPerson._deserialize(x1) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.modifyRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_related_persons_blocking(self, entities: list[DecryptedRelatedPerson]) -> list[DecryptedRelatedPerson]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.modifyRelatedPersonsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedRelatedPerson._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_related_person_async(self, entity_id: str) -> Optional[DecryptedRelatedPerson]:
		def do_decode(raw_result):
			return DecryptedRelatedPerson._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.getRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_related_person_blocking(self, entity_id: str) -> Optional[DecryptedRelatedPerson]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.getRelatedPersonBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedRelatedPerson._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_related_persons_async(self, entity_ids: list[str]) -> list[DecryptedRelatedPerson]:
		def do_decode(raw_result):
			return [DecryptedRelatedPerson._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.getRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_related_persons_blocking(self, entity_ids: list[str]) -> list[DecryptedRelatedPerson]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.getRelatedPersonsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedRelatedPerson._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def subscribe_to_events_async(self, events: set[SubscriptionEventType], filter: FilterOptions[RelatedPerson], subscription_config: Optional[EntitySubscriptionConfiguration] = None) -> EntitySubscription[EncryptedRelatedPerson]:
		def do_decode(raw_result):
			return EntitySubscription[EncryptedRelatedPerson](
				producer = raw_result,
				deserializer = lambda x: EncryptedRelatedPerson._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"events": [x0.__serialize__() for x0 in events],
			"filter": filter.__serialize__(),
			"subscriptionConfig": subscription_config.__serialize__() if subscription_config is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.subscribeToEventsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def subscribe_to_events_blocking(self, events: set[SubscriptionEventType], filter: FilterOptions[RelatedPerson], subscription_config: Optional[EntitySubscriptionConfiguration] = None) -> EntitySubscription[EncryptedRelatedPerson]:
		payload = {
			"events": [x0.__serialize__() for x0 in events],
			"filter": filter.__serialize__(),
			"subscriptionConfig": subscription_config.__serialize__() if subscription_config is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.subscribeToEventsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return EntitySubscription[EncryptedRelatedPerson](
				producer = class_pointer,
				deserializer = lambda x: EncryptedRelatedPerson._deserialize(x),
				executor = self.cardinal_sdk._executor
			)


class RelatedPersonApiEncrypted:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate_id: str, related_person: EncryptedRelatedPerson, options: Optional[RelatedPersonShareOptions] = None) -> EncryptedRelatedPerson:
		def do_decode(raw_result):
			return EncryptedRelatedPerson._deserialize(raw_result)
		payload = {
			"delegateId": delegate_id,
			"relatedPerson": related_person.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.encrypted.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, related_person: EncryptedRelatedPerson, options: Optional[RelatedPersonShareOptions] = None) -> EncryptedRelatedPerson:
		payload = {
			"delegateId": delegate_id,
			"relatedPerson": related_person.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.encrypted.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedRelatedPerson._deserialize(result_info.success)
			return return_value

	async def share_with_many_async(self, related_person: EncryptedRelatedPerson, delegates: dict[str, RelatedPersonShareOptions]) -> EncryptedRelatedPerson:
		def do_decode(raw_result):
			return EncryptedRelatedPerson._deserialize(raw_result)
		payload = {
			"relatedPerson": related_person.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.encrypted.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, related_person: EncryptedRelatedPerson, delegates: dict[str, RelatedPersonShareOptions]) -> EncryptedRelatedPerson:
		payload = {
			"relatedPerson": related_person.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.encrypted.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedRelatedPerson._deserialize(result_info.success)
			return return_value

	async def filter_related_persons_by_async(self, filter: FilterOptions[RelatedPerson]) -> PaginatedListIterator[EncryptedRelatedPerson]:
		def do_decode(raw_result):
			return PaginatedListIterator[EncryptedRelatedPerson](
				producer = raw_result,
				deserializer = lambda x: EncryptedRelatedPerson._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.encrypted.filterRelatedPersonsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_related_persons_by_blocking(self, filter: FilterOptions[RelatedPerson]) -> PaginatedListIterator[EncryptedRelatedPerson]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.encrypted.filterRelatedPersonsByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[EncryptedRelatedPerson](
				producer = class_pointer,
				deserializer = lambda x: EncryptedRelatedPerson._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_related_persons_by_sorted_async(self, filter: SortableFilterOptions[RelatedPerson]) -> PaginatedListIterator[EncryptedRelatedPerson]:
		def do_decode(raw_result):
			return PaginatedListIterator[EncryptedRelatedPerson](
				producer = raw_result,
				deserializer = lambda x: EncryptedRelatedPerson._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.encrypted.filterRelatedPersonsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_related_persons_by_sorted_blocking(self, filter: SortableFilterOptions[RelatedPerson]) -> PaginatedListIterator[EncryptedRelatedPerson]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.encrypted.filterRelatedPersonsBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[EncryptedRelatedPerson](
				producer = class_pointer,
				deserializer = lambda x: EncryptedRelatedPerson._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def create_related_person_async(self, entity: EncryptedRelatedPerson) -> EncryptedRelatedPerson:
		def do_decode(raw_result):
			return EncryptedRelatedPerson._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.encrypted.createRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_related_person_blocking(self, entity: EncryptedRelatedPerson) -> EncryptedRelatedPerson:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.encrypted.createRelatedPersonBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedRelatedPerson._deserialize(result_info.success)
			return return_value

	async def create_related_persons_async(self, entities: list[EncryptedRelatedPerson]) -> list[EncryptedRelatedPerson]:
		def do_decode(raw_result):
			return [EncryptedRelatedPerson._deserialize(x1) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.encrypted.createRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_related_persons_blocking(self, entities: list[EncryptedRelatedPerson]) -> list[EncryptedRelatedPerson]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.encrypted.createRelatedPersonsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedRelatedPerson._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def undelete_related_person_by_id_async(self, id: str, rev: str) -> EncryptedRelatedPerson:
		def do_decode(raw_result):
			return EncryptedRelatedPerson._deserialize(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.encrypted.undeleteRelatedPersonByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_person_by_id_blocking(self, id: str, rev: str) -> EncryptedRelatedPerson:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.encrypted.undeleteRelatedPersonByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedRelatedPerson._deserialize(result_info.success)
			return return_value

	async def undelete_related_persons_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[EncryptedRelatedPerson]:
		def do_decode(raw_result):
			return [EncryptedRelatedPerson._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.encrypted.undeleteRelatedPersonsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_persons_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[EncryptedRelatedPerson]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.encrypted.undeleteRelatedPersonsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedRelatedPerson._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def undelete_related_person_async(self, related_person: RelatedPerson) -> EncryptedRelatedPerson:
		def do_decode(raw_result):
			return EncryptedRelatedPerson._deserialize(raw_result)
		payload = {
			"relatedPerson": serialize_related_person(related_person),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.encrypted.undeleteRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_person_blocking(self, related_person: RelatedPerson) -> EncryptedRelatedPerson:
		payload = {
			"relatedPerson": serialize_related_person(related_person),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.encrypted.undeleteRelatedPersonBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedRelatedPerson._deserialize(result_info.success)
			return return_value

	async def undelete_related_persons_async(self, related_persons: list[RelatedPerson]) -> list[EncryptedRelatedPerson]:
		def do_decode(raw_result):
			return [EncryptedRelatedPerson._deserialize(x1) for x1 in raw_result]
		payload = {
			"relatedPersons": [serialize_related_person(x0) for x0 in related_persons],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.encrypted.undeleteRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_persons_blocking(self, related_persons: list[RelatedPerson]) -> list[EncryptedRelatedPerson]:
		payload = {
			"relatedPersons": [serialize_related_person(x0) for x0 in related_persons],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.encrypted.undeleteRelatedPersonsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedRelatedPerson._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def modify_related_person_async(self, entity: EncryptedRelatedPerson) -> EncryptedRelatedPerson:
		def do_decode(raw_result):
			return EncryptedRelatedPerson._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.encrypted.modifyRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_related_person_blocking(self, entity: EncryptedRelatedPerson) -> EncryptedRelatedPerson:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.encrypted.modifyRelatedPersonBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedRelatedPerson._deserialize(result_info.success)
			return return_value

	async def modify_related_persons_async(self, entities: list[EncryptedRelatedPerson]) -> list[EncryptedRelatedPerson]:
		def do_decode(raw_result):
			return [EncryptedRelatedPerson._deserialize(x1) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.encrypted.modifyRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_related_persons_blocking(self, entities: list[EncryptedRelatedPerson]) -> list[EncryptedRelatedPerson]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.encrypted.modifyRelatedPersonsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedRelatedPerson._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_related_person_async(self, entity_id: str) -> Optional[EncryptedRelatedPerson]:
		def do_decode(raw_result):
			return EncryptedRelatedPerson._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.encrypted.getRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_related_person_blocking(self, entity_id: str) -> Optional[EncryptedRelatedPerson]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.encrypted.getRelatedPersonBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedRelatedPerson._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_related_persons_async(self, entity_ids: list[str]) -> list[EncryptedRelatedPerson]:
		def do_decode(raw_result):
			return [EncryptedRelatedPerson._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.encrypted.getRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_related_persons_blocking(self, entity_ids: list[str]) -> list[EncryptedRelatedPerson]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.encrypted.getRelatedPersonsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedRelatedPerson._deserialize(x1) for x1 in result_info.success]
			return return_value


class RelatedPersonApiTryAndRecover:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate_id: str, related_person: RelatedPerson, options: Optional[RelatedPersonShareOptions] = None) -> RelatedPerson:
		def do_decode(raw_result):
			return deserialize_related_person(raw_result)
		payload = {
			"delegateId": delegate_id,
			"relatedPerson": serialize_related_person(related_person),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.tryAndRecover.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, related_person: RelatedPerson, options: Optional[RelatedPersonShareOptions] = None) -> RelatedPerson:
		payload = {
			"delegateId": delegate_id,
			"relatedPerson": serialize_related_person(related_person),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.tryAndRecover.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_related_person(result_info.success)
			return return_value

	async def share_with_many_async(self, related_person: RelatedPerson, delegates: dict[str, RelatedPersonShareOptions]) -> RelatedPerson:
		def do_decode(raw_result):
			return deserialize_related_person(raw_result)
		payload = {
			"relatedPerson": serialize_related_person(related_person),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.tryAndRecover.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, related_person: RelatedPerson, delegates: dict[str, RelatedPersonShareOptions]) -> RelatedPerson:
		payload = {
			"relatedPerson": serialize_related_person(related_person),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.tryAndRecover.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_related_person(result_info.success)
			return return_value

	async def filter_related_persons_by_async(self, filter: FilterOptions[RelatedPerson]) -> PaginatedListIterator[RelatedPerson]:
		def do_decode(raw_result):
			return PaginatedListIterator[RelatedPerson](
				producer = raw_result,
				deserializer = lambda x: deserialize_related_person(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.tryAndRecover.filterRelatedPersonsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_related_persons_by_blocking(self, filter: FilterOptions[RelatedPerson]) -> PaginatedListIterator[RelatedPerson]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.tryAndRecover.filterRelatedPersonsByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[RelatedPerson](
				producer = class_pointer,
				deserializer = lambda x: deserialize_related_person(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_related_persons_by_sorted_async(self, filter: SortableFilterOptions[RelatedPerson]) -> PaginatedListIterator[RelatedPerson]:
		def do_decode(raw_result):
			return PaginatedListIterator[RelatedPerson](
				producer = raw_result,
				deserializer = lambda x: deserialize_related_person(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.tryAndRecover.filterRelatedPersonsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_related_persons_by_sorted_blocking(self, filter: SortableFilterOptions[RelatedPerson]) -> PaginatedListIterator[RelatedPerson]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.tryAndRecover.filterRelatedPersonsBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[RelatedPerson](
				producer = class_pointer,
				deserializer = lambda x: deserialize_related_person(x),
				executor = self.cardinal_sdk._executor
			)

	async def create_related_person_async(self, entity: RelatedPerson) -> RelatedPerson:
		def do_decode(raw_result):
			return deserialize_related_person(raw_result)
		payload = {
			"entity": serialize_related_person(entity),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.tryAndRecover.createRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_related_person_blocking(self, entity: RelatedPerson) -> RelatedPerson:
		payload = {
			"entity": serialize_related_person(entity),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.tryAndRecover.createRelatedPersonBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_related_person(result_info.success)
			return return_value

	async def create_related_persons_async(self, entities: list[RelatedPerson]) -> list[RelatedPerson]:
		def do_decode(raw_result):
			return [deserialize_related_person(x1) for x1 in raw_result]
		payload = {
			"entities": [serialize_related_person(x0) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.tryAndRecover.createRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_related_persons_blocking(self, entities: list[RelatedPerson]) -> list[RelatedPerson]:
		payload = {
			"entities": [serialize_related_person(x0) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.tryAndRecover.createRelatedPersonsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_related_person(x1) for x1 in result_info.success]
			return return_value

	async def undelete_related_person_by_id_async(self, id: str, rev: str) -> RelatedPerson:
		def do_decode(raw_result):
			return deserialize_related_person(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.tryAndRecover.undeleteRelatedPersonByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_person_by_id_blocking(self, id: str, rev: str) -> RelatedPerson:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.tryAndRecover.undeleteRelatedPersonByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_related_person(result_info.success)
			return return_value

	async def undelete_related_persons_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[RelatedPerson]:
		def do_decode(raw_result):
			return [deserialize_related_person(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.tryAndRecover.undeleteRelatedPersonsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_persons_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[RelatedPerson]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.tryAndRecover.undeleteRelatedPersonsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_related_person(x1) for x1 in result_info.success]
			return return_value

	async def undelete_related_person_async(self, related_person: RelatedPerson) -> RelatedPerson:
		def do_decode(raw_result):
			return deserialize_related_person(raw_result)
		payload = {
			"relatedPerson": serialize_related_person(related_person),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.tryAndRecover.undeleteRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_person_blocking(self, related_person: RelatedPerson) -> RelatedPerson:
		payload = {
			"relatedPerson": serialize_related_person(related_person),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.tryAndRecover.undeleteRelatedPersonBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_related_person(result_info.success)
			return return_value

	async def undelete_related_persons_async(self, related_persons: list[RelatedPerson]) -> list[RelatedPerson]:
		def do_decode(raw_result):
			return [deserialize_related_person(x1) for x1 in raw_result]
		payload = {
			"relatedPersons": [serialize_related_person(x0) for x0 in related_persons],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.tryAndRecover.undeleteRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_persons_blocking(self, related_persons: list[RelatedPerson]) -> list[RelatedPerson]:
		payload = {
			"relatedPersons": [serialize_related_person(x0) for x0 in related_persons],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.tryAndRecover.undeleteRelatedPersonsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_related_person(x1) for x1 in result_info.success]
			return return_value

	async def modify_related_person_async(self, entity: RelatedPerson) -> RelatedPerson:
		def do_decode(raw_result):
			return deserialize_related_person(raw_result)
		payload = {
			"entity": serialize_related_person(entity),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.tryAndRecover.modifyRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_related_person_blocking(self, entity: RelatedPerson) -> RelatedPerson:
		payload = {
			"entity": serialize_related_person(entity),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.tryAndRecover.modifyRelatedPersonBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_related_person(result_info.success)
			return return_value

	async def modify_related_persons_async(self, entities: list[RelatedPerson]) -> list[RelatedPerson]:
		def do_decode(raw_result):
			return [deserialize_related_person(x1) for x1 in raw_result]
		payload = {
			"entities": [serialize_related_person(x0) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.tryAndRecover.modifyRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_related_persons_blocking(self, entities: list[RelatedPerson]) -> list[RelatedPerson]:
		payload = {
			"entities": [serialize_related_person(x0) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.tryAndRecover.modifyRelatedPersonsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_related_person(x1) for x1 in result_info.success]
			return return_value

	async def get_related_person_async(self, entity_id: str) -> Optional[RelatedPerson]:
		def do_decode(raw_result):
			return deserialize_related_person(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.tryAndRecover.getRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_related_person_blocking(self, entity_id: str) -> Optional[RelatedPerson]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.tryAndRecover.getRelatedPersonBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_related_person(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_related_persons_async(self, entity_ids: list[str]) -> list[RelatedPerson]:
		def do_decode(raw_result):
			return [deserialize_related_person(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.tryAndRecover.getRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_related_persons_blocking(self, entity_ids: list[str]) -> list[RelatedPerson]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.tryAndRecover.getRelatedPersonsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_related_person(x1) for x1 in result_info.success]
			return return_value


class RelatedPersonApiInGroup:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk
		self.encrypted = RelatedPersonApiInGroupEncrypted(self.cardinal_sdk)
		self.try_and_recover = RelatedPersonApiInGroupTryAndRecover(self.cardinal_sdk)

	async def with_encryption_metadata_async(self, entity_group_id: str, base: Optional[DecryptedRelatedPerson], user: Optional[User] = None, delegates: dict[EntityReferenceInGroup, AccessLevel] = {}, alternate_root_delegate_reference: Optional[EntityReferenceInGroup] = None) -> GroupScoped[DecryptedRelatedPerson]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedRelatedPerson._deserialize(x1))
		payload = {
			"entityGroupId": entity_group_id,
			"base": base.__serialize__() if base is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
			"alternateRootDelegateReference": alternate_root_delegate_reference.__serialize__() if alternate_root_delegate_reference is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.withEncryptionMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def with_encryption_metadata_blocking(self, entity_group_id: str, base: Optional[DecryptedRelatedPerson], user: Optional[User] = None, delegates: dict[EntityReferenceInGroup, AccessLevel] = {}, alternate_root_delegate_reference: Optional[EntityReferenceInGroup] = None) -> GroupScoped[DecryptedRelatedPerson]:
		payload = {
			"entityGroupId": entity_group_id,
			"base": base.__serialize__() if base is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
			"alternateRootDelegateReference": alternate_root_delegate_reference.__serialize__() if alternate_root_delegate_reference is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.withEncryptionMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedRelatedPerson._deserialize(x1))
			return return_value

	async def with_encryption_metadata_and_delegates_async(self, entity_group_id: str, base: Optional[DecryptedRelatedPerson], delegates: dict[EntityReferenceInGroup, RelatedPersonDelegateOptions], user: Optional[User] = None, alternate_root_delegate_reference: Optional[EntityReferenceInGroup] = None) -> GroupScoped[DecryptedRelatedPerson]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedRelatedPerson._deserialize(x1))
		payload = {
			"entityGroupId": entity_group_id,
			"base": base.__serialize__() if base is not None else None,
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
			"user": user.__serialize__() if user is not None else None,
			"alternateRootDelegateReference": alternate_root_delegate_reference.__serialize__() if alternate_root_delegate_reference is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.withEncryptionMetadataAndDelegatesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def with_encryption_metadata_and_delegates_blocking(self, entity_group_id: str, base: Optional[DecryptedRelatedPerson], delegates: dict[EntityReferenceInGroup, RelatedPersonDelegateOptions], user: Optional[User] = None, alternate_root_delegate_reference: Optional[EntityReferenceInGroup] = None) -> GroupScoped[DecryptedRelatedPerson]:
		payload = {
			"entityGroupId": entity_group_id,
			"base": base.__serialize__() if base is not None else None,
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
			"user": user.__serialize__() if user is not None else None,
			"alternateRootDelegateReference": alternate_root_delegate_reference.__serialize__() if alternate_root_delegate_reference is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.withEncryptionMetadataAndDelegatesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedRelatedPerson._deserialize(x1))
			return return_value

	async def get_encryption_keys_of_async(self, related_person: GroupScoped[RelatedPerson]) -> set[HexString]:
		def do_decode(raw_result):
			return {x1 for x1 in raw_result}
		payload = {
			"relatedPerson": related_person.__serialize__(lambda x0: serialize_related_person(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.getEncryptionKeysOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_encryption_keys_of_blocking(self, related_person: GroupScoped[RelatedPerson]) -> set[HexString]:
		payload = {
			"relatedPerson": related_person.__serialize__(lambda x0: serialize_related_person(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.getEncryptionKeysOfBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = {x1 for x1 in result_info.success}
			return return_value

	async def has_write_access_async(self, related_person: GroupScoped[RelatedPerson]) -> bool:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"relatedPerson": related_person.__serialize__(lambda x0: serialize_related_person(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.hasWriteAccessAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def has_write_access_blocking(self, related_person: GroupScoped[RelatedPerson]) -> bool:
		payload = {
			"relatedPerson": related_person.__serialize__(lambda x0: serialize_related_person(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.hasWriteAccessBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

	async def get_secret_ids_of_async(self, related_person: GroupScoped[RelatedPerson]) -> set[str]:
		def do_decode(raw_result):
			return {x1 for x1 in raw_result}
		payload = {
			"relatedPerson": related_person.__serialize__(lambda x0: serialize_related_person(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.getSecretIdsOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_secret_ids_of_blocking(self, related_person: GroupScoped[RelatedPerson]) -> set[str]:
		payload = {
			"relatedPerson": related_person.__serialize__(lambda x0: serialize_related_person(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.getSecretIdsOfBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = {x1 for x1 in result_info.success}
			return return_value

	async def create_delegation_de_anonymization_metadata_async(self, entity: GroupScoped[RelatedPerson], delegates: set[EntityReferenceInGroup]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_related_person(x0)),
			"delegates": [x0.__serialize__() for x0 in delegates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.createDelegationDeAnonymizationMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_delegation_de_anonymization_metadata_blocking(self, entity: GroupScoped[RelatedPerson], delegates: set[EntityReferenceInGroup]) -> None:
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_related_person(x0)),
			"delegates": [x0.__serialize__() for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.createDelegationDeAnonymizationMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def decrypt_async(self, related_persons: list[GroupScoped[EncryptedRelatedPerson]]) -> list[GroupScoped[DecryptedRelatedPerson]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: DecryptedRelatedPerson._deserialize(x2)) for x1 in raw_result]
		payload = {
			"relatedPersons": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in related_persons],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.decryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_blocking(self, related_persons: list[GroupScoped[EncryptedRelatedPerson]]) -> list[GroupScoped[DecryptedRelatedPerson]]:
		payload = {
			"relatedPersons": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in related_persons],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.decryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: DecryptedRelatedPerson._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def try_decrypt_async(self, related_persons: list[GroupScoped[EncryptedRelatedPerson]]) -> list[GroupScoped[RelatedPerson]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: deserialize_related_person(x2)) for x1 in raw_result]
		payload = {
			"relatedPersons": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in related_persons],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.tryDecryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def try_decrypt_blocking(self, related_persons: list[GroupScoped[EncryptedRelatedPerson]]) -> list[GroupScoped[RelatedPerson]]:
		payload = {
			"relatedPersons": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in related_persons],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.tryDecryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: deserialize_related_person(x2)) for x1 in result_info.success]
			return return_value

	async def encrypt_or_validate_async(self, related_persons: list[GroupScoped[RelatedPerson]]) -> list[GroupScoped[EncryptedRelatedPerson]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: EncryptedRelatedPerson._deserialize(x2)) for x1 in raw_result]
		payload = {
			"relatedPersons": [x0.__serialize__(lambda x1: serialize_related_person(x1)) for x0 in related_persons],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.encryptOrValidateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def encrypt_or_validate_blocking(self, related_persons: list[GroupScoped[RelatedPerson]]) -> list[GroupScoped[EncryptedRelatedPerson]]:
		payload = {
			"relatedPersons": [x0.__serialize__(lambda x1: serialize_related_person(x1)) for x0 in related_persons],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.encryptOrValidateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: EncryptedRelatedPerson._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def match_related_persons_by_async(self, group_id: str, filter: FilterOptions[RelatedPerson]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.matchRelatedPersonsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_related_persons_by_blocking(self, group_id: str, filter: FilterOptions[RelatedPerson]) -> list[str]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.matchRelatedPersonsByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def match_related_persons_by_sorted_async(self, group_id: str, filter: SortableFilterOptions[RelatedPerson]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.matchRelatedPersonsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_related_persons_by_sorted_blocking(self, group_id: str, filter: SortableFilterOptions[RelatedPerson]) -> list[str]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.matchRelatedPersonsBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def delete_related_person_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: StoredDocumentIdentifier._deserialize(x1))
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.deleteRelatedPersonByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_related_person_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[StoredDocumentIdentifier]:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.deleteRelatedPersonByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: StoredDocumentIdentifier._deserialize(x1))
			return return_value

	async def delete_related_persons_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.deleteRelatedPersonsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_related_persons_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.deleteRelatedPersonsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def purge_related_person_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.purgeRelatedPersonByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_related_person_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> None:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.purgeRelatedPersonByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_related_persons_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.purgeRelatedPersonsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_related_persons_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.purgeRelatedPersonsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def delete_related_person_async(self, related_person: GroupScoped[RelatedPerson]) -> GroupScoped[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: StoredDocumentIdentifier._deserialize(x1))
		payload = {
			"relatedPerson": related_person.__serialize__(lambda x0: serialize_related_person(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.deleteRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_related_person_blocking(self, related_person: GroupScoped[RelatedPerson]) -> GroupScoped[StoredDocumentIdentifier]:
		payload = {
			"relatedPerson": related_person.__serialize__(lambda x0: serialize_related_person(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.deleteRelatedPersonBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: StoredDocumentIdentifier._deserialize(x1))
			return return_value

	async def delete_related_persons_async(self, related_persons: list[GroupScoped[RelatedPerson]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"relatedPersons": [x0.__serialize__(lambda x1: serialize_related_person(x1)) for x0 in related_persons],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.deleteRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_related_persons_blocking(self, related_persons: list[GroupScoped[RelatedPerson]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"relatedPersons": [x0.__serialize__(lambda x1: serialize_related_person(x1)) for x0 in related_persons],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.deleteRelatedPersonsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def purge_related_person_async(self, related_person: GroupScoped[RelatedPerson]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"relatedPerson": related_person.__serialize__(lambda x0: serialize_related_person(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.purgeRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_related_person_blocking(self, related_person: GroupScoped[RelatedPerson]) -> None:
		payload = {
			"relatedPerson": related_person.__serialize__(lambda x0: serialize_related_person(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.purgeRelatedPersonBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_related_persons_async(self, related_persons: list[GroupScoped[RelatedPerson]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"relatedPersons": [x0.__serialize__(lambda x1: serialize_related_person(x1)) for x0 in related_persons],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.purgeRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_related_persons_blocking(self, related_persons: list[GroupScoped[RelatedPerson]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"relatedPersons": [x0.__serialize__(lambda x1: serialize_related_person(x1)) for x0 in related_persons],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.purgeRelatedPersonsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def share_with_async(self, delegate: EntityReferenceInGroup, related_person: GroupScoped[DecryptedRelatedPerson], options: Optional[RelatedPersonShareOptions] = None) -> GroupScoped[DecryptedRelatedPerson]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedRelatedPerson._deserialize(x1))
		payload = {
			"delegate": delegate.__serialize__(),
			"relatedPerson": related_person.__serialize__(lambda x0: x0.__serialize__()),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate: EntityReferenceInGroup, related_person: GroupScoped[DecryptedRelatedPerson], options: Optional[RelatedPersonShareOptions] = None) -> GroupScoped[DecryptedRelatedPerson]:
		payload = {
			"delegate": delegate.__serialize__(),
			"relatedPerson": related_person.__serialize__(lambda x0: x0.__serialize__()),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedRelatedPerson._deserialize(x1))
			return return_value

	async def share_with_many_async(self, related_person: GroupScoped[DecryptedRelatedPerson], delegates: dict[EntityReferenceInGroup, RelatedPersonShareOptions]) -> GroupScoped[DecryptedRelatedPerson]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedRelatedPerson._deserialize(x1))
		payload = {
			"relatedPerson": related_person.__serialize__(lambda x0: x0.__serialize__()),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, related_person: GroupScoped[DecryptedRelatedPerson], delegates: dict[EntityReferenceInGroup, RelatedPersonShareOptions]) -> GroupScoped[DecryptedRelatedPerson]:
		payload = {
			"relatedPerson": related_person.__serialize__(lambda x0: x0.__serialize__()),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedRelatedPerson._deserialize(x1))
			return return_value

	async def filter_related_persons_by_async(self, group_id: str, filter: FilterOptions[RelatedPerson]) -> PaginatedListIterator[GroupScoped[DecryptedRelatedPerson]]:
		def do_decode(raw_result):
			return PaginatedListIterator[GroupScoped[DecryptedRelatedPerson]](
				producer = raw_result,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: DecryptedRelatedPerson._deserialize(x1)),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.filterRelatedPersonsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_related_persons_by_blocking(self, group_id: str, filter: FilterOptions[RelatedPerson]) -> PaginatedListIterator[GroupScoped[DecryptedRelatedPerson]]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.filterRelatedPersonsByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[GroupScoped[DecryptedRelatedPerson]](
				producer = class_pointer,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: DecryptedRelatedPerson._deserialize(x1)),
				executor = self.cardinal_sdk._executor
			)

	async def filter_related_persons_by_sorted_async(self, group_id: str, filter: SortableFilterOptions[RelatedPerson]) -> PaginatedListIterator[GroupScoped[DecryptedRelatedPerson]]:
		def do_decode(raw_result):
			return PaginatedListIterator[GroupScoped[DecryptedRelatedPerson]](
				producer = raw_result,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: DecryptedRelatedPerson._deserialize(x1)),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.filterRelatedPersonsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_related_persons_by_sorted_blocking(self, group_id: str, filter: SortableFilterOptions[RelatedPerson]) -> PaginatedListIterator[GroupScoped[DecryptedRelatedPerson]]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.filterRelatedPersonsBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[GroupScoped[DecryptedRelatedPerson]](
				producer = class_pointer,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: DecryptedRelatedPerson._deserialize(x1)),
				executor = self.cardinal_sdk._executor
			)

	async def create_related_person_async(self, entity: GroupScoped[DecryptedRelatedPerson]) -> GroupScoped[DecryptedRelatedPerson]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedRelatedPerson._deserialize(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.createRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_related_person_blocking(self, entity: GroupScoped[DecryptedRelatedPerson]) -> GroupScoped[DecryptedRelatedPerson]:
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.createRelatedPersonBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedRelatedPerson._deserialize(x1))
			return return_value

	async def create_related_persons_async(self, entities: list[GroupScoped[DecryptedRelatedPerson]]) -> list[GroupScoped[DecryptedRelatedPerson]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: DecryptedRelatedPerson._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.createRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_related_persons_blocking(self, entities: list[GroupScoped[DecryptedRelatedPerson]]) -> list[GroupScoped[DecryptedRelatedPerson]]:
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.createRelatedPersonsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: DecryptedRelatedPerson._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def undelete_related_person_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[DecryptedRelatedPerson]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedRelatedPerson._deserialize(x1))
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.undeleteRelatedPersonByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_person_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[DecryptedRelatedPerson]:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.undeleteRelatedPersonByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedRelatedPerson._deserialize(x1))
			return return_value

	async def undelete_related_persons_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[DecryptedRelatedPerson]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: DecryptedRelatedPerson._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.undeleteRelatedPersonsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_persons_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[DecryptedRelatedPerson]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.undeleteRelatedPersonsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: DecryptedRelatedPerson._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def undelete_related_person_async(self, related_person: GroupScoped[RelatedPerson]) -> GroupScoped[DecryptedRelatedPerson]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedRelatedPerson._deserialize(x1))
		payload = {
			"relatedPerson": related_person.__serialize__(lambda x0: serialize_related_person(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.undeleteRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_person_blocking(self, related_person: GroupScoped[RelatedPerson]) -> GroupScoped[DecryptedRelatedPerson]:
		payload = {
			"relatedPerson": related_person.__serialize__(lambda x0: serialize_related_person(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.undeleteRelatedPersonBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedRelatedPerson._deserialize(x1))
			return return_value

	async def undelete_related_persons_async(self, related_persons: list[GroupScoped[DecryptedRelatedPerson]]) -> list[GroupScoped[DecryptedRelatedPerson]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: DecryptedRelatedPerson._deserialize(x2)) for x1 in raw_result]
		payload = {
			"relatedPersons": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in related_persons],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.undeleteRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_persons_blocking(self, related_persons: list[GroupScoped[DecryptedRelatedPerson]]) -> list[GroupScoped[DecryptedRelatedPerson]]:
		payload = {
			"relatedPersons": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in related_persons],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.undeleteRelatedPersonsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: DecryptedRelatedPerson._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def modify_related_person_async(self, entity: GroupScoped[DecryptedRelatedPerson]) -> GroupScoped[DecryptedRelatedPerson]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedRelatedPerson._deserialize(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.modifyRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_related_person_blocking(self, entity: GroupScoped[DecryptedRelatedPerson]) -> GroupScoped[DecryptedRelatedPerson]:
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.modifyRelatedPersonBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedRelatedPerson._deserialize(x1))
			return return_value

	async def modify_related_persons_async(self, entities: list[GroupScoped[DecryptedRelatedPerson]]) -> list[GroupScoped[DecryptedRelatedPerson]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: DecryptedRelatedPerson._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.modifyRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_related_persons_blocking(self, entities: list[GroupScoped[DecryptedRelatedPerson]]) -> list[GroupScoped[DecryptedRelatedPerson]]:
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.modifyRelatedPersonsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: DecryptedRelatedPerson._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def get_related_person_async(self, group_id: str, entity_id: str) -> Optional[GroupScoped[DecryptedRelatedPerson]]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedRelatedPerson._deserialize(x1)) if raw_result is not None else None
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.getRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_related_person_blocking(self, group_id: str, entity_id: str) -> Optional[GroupScoped[DecryptedRelatedPerson]]:
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.getRelatedPersonBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedRelatedPerson._deserialize(x1)) if result_info.success is not None else None
			return return_value

	async def get_related_persons_async(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[DecryptedRelatedPerson]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: DecryptedRelatedPerson._deserialize(x2)) for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.getRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_related_persons_blocking(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[DecryptedRelatedPerson]]:
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.getRelatedPersonsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: DecryptedRelatedPerson._deserialize(x2)) for x1 in result_info.success]
			return return_value


class RelatedPersonApiInGroupEncrypted:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate: EntityReferenceInGroup, related_person: GroupScoped[EncryptedRelatedPerson], options: Optional[RelatedPersonShareOptions] = None) -> GroupScoped[EncryptedRelatedPerson]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedRelatedPerson._deserialize(x1))
		payload = {
			"delegate": delegate.__serialize__(),
			"relatedPerson": related_person.__serialize__(lambda x0: x0.__serialize__()),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.encrypted.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate: EntityReferenceInGroup, related_person: GroupScoped[EncryptedRelatedPerson], options: Optional[RelatedPersonShareOptions] = None) -> GroupScoped[EncryptedRelatedPerson]:
		payload = {
			"delegate": delegate.__serialize__(),
			"relatedPerson": related_person.__serialize__(lambda x0: x0.__serialize__()),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.encrypted.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedRelatedPerson._deserialize(x1))
			return return_value

	async def share_with_many_async(self, related_person: GroupScoped[EncryptedRelatedPerson], delegates: dict[EntityReferenceInGroup, RelatedPersonShareOptions]) -> GroupScoped[EncryptedRelatedPerson]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedRelatedPerson._deserialize(x1))
		payload = {
			"relatedPerson": related_person.__serialize__(lambda x0: x0.__serialize__()),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.encrypted.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, related_person: GroupScoped[EncryptedRelatedPerson], delegates: dict[EntityReferenceInGroup, RelatedPersonShareOptions]) -> GroupScoped[EncryptedRelatedPerson]:
		payload = {
			"relatedPerson": related_person.__serialize__(lambda x0: x0.__serialize__()),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.encrypted.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedRelatedPerson._deserialize(x1))
			return return_value

	async def filter_related_persons_by_async(self, group_id: str, filter: FilterOptions[RelatedPerson]) -> PaginatedListIterator[GroupScoped[EncryptedRelatedPerson]]:
		def do_decode(raw_result):
			return PaginatedListIterator[GroupScoped[EncryptedRelatedPerson]](
				producer = raw_result,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: EncryptedRelatedPerson._deserialize(x1)),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.encrypted.filterRelatedPersonsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_related_persons_by_blocking(self, group_id: str, filter: FilterOptions[RelatedPerson]) -> PaginatedListIterator[GroupScoped[EncryptedRelatedPerson]]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.encrypted.filterRelatedPersonsByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[GroupScoped[EncryptedRelatedPerson]](
				producer = class_pointer,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: EncryptedRelatedPerson._deserialize(x1)),
				executor = self.cardinal_sdk._executor
			)

	async def filter_related_persons_by_sorted_async(self, group_id: str, filter: SortableFilterOptions[RelatedPerson]) -> PaginatedListIterator[GroupScoped[EncryptedRelatedPerson]]:
		def do_decode(raw_result):
			return PaginatedListIterator[GroupScoped[EncryptedRelatedPerson]](
				producer = raw_result,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: EncryptedRelatedPerson._deserialize(x1)),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.encrypted.filterRelatedPersonsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_related_persons_by_sorted_blocking(self, group_id: str, filter: SortableFilterOptions[RelatedPerson]) -> PaginatedListIterator[GroupScoped[EncryptedRelatedPerson]]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.encrypted.filterRelatedPersonsBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[GroupScoped[EncryptedRelatedPerson]](
				producer = class_pointer,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: EncryptedRelatedPerson._deserialize(x1)),
				executor = self.cardinal_sdk._executor
			)

	async def create_related_person_async(self, entity: GroupScoped[EncryptedRelatedPerson]) -> GroupScoped[EncryptedRelatedPerson]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedRelatedPerson._deserialize(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.encrypted.createRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_related_person_blocking(self, entity: GroupScoped[EncryptedRelatedPerson]) -> GroupScoped[EncryptedRelatedPerson]:
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.encrypted.createRelatedPersonBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedRelatedPerson._deserialize(x1))
			return return_value

	async def create_related_persons_async(self, entities: list[GroupScoped[EncryptedRelatedPerson]]) -> list[GroupScoped[EncryptedRelatedPerson]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: EncryptedRelatedPerson._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.encrypted.createRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_related_persons_blocking(self, entities: list[GroupScoped[EncryptedRelatedPerson]]) -> list[GroupScoped[EncryptedRelatedPerson]]:
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.encrypted.createRelatedPersonsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: EncryptedRelatedPerson._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def undelete_related_person_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[EncryptedRelatedPerson]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedRelatedPerson._deserialize(x1))
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.encrypted.undeleteRelatedPersonByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_person_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[EncryptedRelatedPerson]:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.encrypted.undeleteRelatedPersonByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedRelatedPerson._deserialize(x1))
			return return_value

	async def undelete_related_persons_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[EncryptedRelatedPerson]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: EncryptedRelatedPerson._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.encrypted.undeleteRelatedPersonsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_persons_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[EncryptedRelatedPerson]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.encrypted.undeleteRelatedPersonsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: EncryptedRelatedPerson._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def undelete_related_person_async(self, related_person: GroupScoped[RelatedPerson]) -> GroupScoped[EncryptedRelatedPerson]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedRelatedPerson._deserialize(x1))
		payload = {
			"relatedPerson": related_person.__serialize__(lambda x0: serialize_related_person(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.encrypted.undeleteRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_person_blocking(self, related_person: GroupScoped[RelatedPerson]) -> GroupScoped[EncryptedRelatedPerson]:
		payload = {
			"relatedPerson": related_person.__serialize__(lambda x0: serialize_related_person(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.encrypted.undeleteRelatedPersonBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedRelatedPerson._deserialize(x1))
			return return_value

	async def undelete_related_persons_async(self, related_persons: list[GroupScoped[EncryptedRelatedPerson]]) -> list[GroupScoped[EncryptedRelatedPerson]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: EncryptedRelatedPerson._deserialize(x2)) for x1 in raw_result]
		payload = {
			"relatedPersons": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in related_persons],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.encrypted.undeleteRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_persons_blocking(self, related_persons: list[GroupScoped[EncryptedRelatedPerson]]) -> list[GroupScoped[EncryptedRelatedPerson]]:
		payload = {
			"relatedPersons": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in related_persons],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.encrypted.undeleteRelatedPersonsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: EncryptedRelatedPerson._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def modify_related_person_async(self, entity: GroupScoped[EncryptedRelatedPerson]) -> GroupScoped[EncryptedRelatedPerson]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedRelatedPerson._deserialize(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.encrypted.modifyRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_related_person_blocking(self, entity: GroupScoped[EncryptedRelatedPerson]) -> GroupScoped[EncryptedRelatedPerson]:
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.encrypted.modifyRelatedPersonBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedRelatedPerson._deserialize(x1))
			return return_value

	async def modify_related_persons_async(self, entities: list[GroupScoped[EncryptedRelatedPerson]]) -> list[GroupScoped[EncryptedRelatedPerson]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: EncryptedRelatedPerson._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.encrypted.modifyRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_related_persons_blocking(self, entities: list[GroupScoped[EncryptedRelatedPerson]]) -> list[GroupScoped[EncryptedRelatedPerson]]:
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.encrypted.modifyRelatedPersonsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: EncryptedRelatedPerson._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def get_related_person_async(self, group_id: str, entity_id: str) -> Optional[GroupScoped[EncryptedRelatedPerson]]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedRelatedPerson._deserialize(x1)) if raw_result is not None else None
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.encrypted.getRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_related_person_blocking(self, group_id: str, entity_id: str) -> Optional[GroupScoped[EncryptedRelatedPerson]]:
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.encrypted.getRelatedPersonBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedRelatedPerson._deserialize(x1)) if result_info.success is not None else None
			return return_value

	async def get_related_persons_async(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[EncryptedRelatedPerson]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: EncryptedRelatedPerson._deserialize(x2)) for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.encrypted.getRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_related_persons_blocking(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[EncryptedRelatedPerson]]:
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.encrypted.getRelatedPersonsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: EncryptedRelatedPerson._deserialize(x2)) for x1 in result_info.success]
			return return_value


class RelatedPersonApiInGroupTryAndRecover:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate: EntityReferenceInGroup, related_person: GroupScoped[RelatedPerson], options: Optional[RelatedPersonShareOptions] = None) -> GroupScoped[RelatedPerson]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_related_person(x1))
		payload = {
			"delegate": delegate.__serialize__(),
			"relatedPerson": related_person.__serialize__(lambda x0: serialize_related_person(x0)),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.tryAndRecover.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate: EntityReferenceInGroup, related_person: GroupScoped[RelatedPerson], options: Optional[RelatedPersonShareOptions] = None) -> GroupScoped[RelatedPerson]:
		payload = {
			"delegate": delegate.__serialize__(),
			"relatedPerson": related_person.__serialize__(lambda x0: serialize_related_person(x0)),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.tryAndRecover.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_related_person(x1))
			return return_value

	async def share_with_many_async(self, related_person: GroupScoped[RelatedPerson], delegates: dict[EntityReferenceInGroup, RelatedPersonShareOptions]) -> GroupScoped[RelatedPerson]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_related_person(x1))
		payload = {
			"relatedPerson": related_person.__serialize__(lambda x0: serialize_related_person(x0)),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.tryAndRecover.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, related_person: GroupScoped[RelatedPerson], delegates: dict[EntityReferenceInGroup, RelatedPersonShareOptions]) -> GroupScoped[RelatedPerson]:
		payload = {
			"relatedPerson": related_person.__serialize__(lambda x0: serialize_related_person(x0)),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.tryAndRecover.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_related_person(x1))
			return return_value

	async def filter_related_persons_by_async(self, group_id: str, filter: FilterOptions[RelatedPerson]) -> PaginatedListIterator[GroupScoped[RelatedPerson]]:
		def do_decode(raw_result):
			return PaginatedListIterator[GroupScoped[RelatedPerson]](
				producer = raw_result,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: deserialize_related_person(x1)),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.tryAndRecover.filterRelatedPersonsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_related_persons_by_blocking(self, group_id: str, filter: FilterOptions[RelatedPerson]) -> PaginatedListIterator[GroupScoped[RelatedPerson]]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.tryAndRecover.filterRelatedPersonsByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[GroupScoped[RelatedPerson]](
				producer = class_pointer,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: deserialize_related_person(x1)),
				executor = self.cardinal_sdk._executor
			)

	async def filter_related_persons_by_sorted_async(self, group_id: str, filter: SortableFilterOptions[RelatedPerson]) -> PaginatedListIterator[GroupScoped[RelatedPerson]]:
		def do_decode(raw_result):
			return PaginatedListIterator[GroupScoped[RelatedPerson]](
				producer = raw_result,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: deserialize_related_person(x1)),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.tryAndRecover.filterRelatedPersonsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_related_persons_by_sorted_blocking(self, group_id: str, filter: SortableFilterOptions[RelatedPerson]) -> PaginatedListIterator[GroupScoped[RelatedPerson]]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.tryAndRecover.filterRelatedPersonsBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[GroupScoped[RelatedPerson]](
				producer = class_pointer,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: deserialize_related_person(x1)),
				executor = self.cardinal_sdk._executor
			)

	async def create_related_person_async(self, entity: GroupScoped[RelatedPerson]) -> GroupScoped[RelatedPerson]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_related_person(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_related_person(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.tryAndRecover.createRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_related_person_blocking(self, entity: GroupScoped[RelatedPerson]) -> GroupScoped[RelatedPerson]:
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_related_person(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.tryAndRecover.createRelatedPersonBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_related_person(x1))
			return return_value

	async def create_related_persons_async(self, entities: list[GroupScoped[RelatedPerson]]) -> list[GroupScoped[RelatedPerson]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: deserialize_related_person(x2)) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__(lambda x1: serialize_related_person(x1)) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.tryAndRecover.createRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_related_persons_blocking(self, entities: list[GroupScoped[RelatedPerson]]) -> list[GroupScoped[RelatedPerson]]:
		payload = {
			"entities": [x0.__serialize__(lambda x1: serialize_related_person(x1)) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.tryAndRecover.createRelatedPersonsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: deserialize_related_person(x2)) for x1 in result_info.success]
			return return_value

	async def undelete_related_person_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[RelatedPerson]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_related_person(x1))
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.tryAndRecover.undeleteRelatedPersonByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_person_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[RelatedPerson]:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.tryAndRecover.undeleteRelatedPersonByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_related_person(x1))
			return return_value

	async def undelete_related_persons_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[RelatedPerson]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: deserialize_related_person(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.tryAndRecover.undeleteRelatedPersonsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_persons_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[RelatedPerson]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.tryAndRecover.undeleteRelatedPersonsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: deserialize_related_person(x2)) for x1 in result_info.success]
			return return_value

	async def undelete_related_person_async(self, related_person: GroupScoped[RelatedPerson]) -> GroupScoped[RelatedPerson]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_related_person(x1))
		payload = {
			"relatedPerson": related_person.__serialize__(lambda x0: serialize_related_person(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.tryAndRecover.undeleteRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_person_blocking(self, related_person: GroupScoped[RelatedPerson]) -> GroupScoped[RelatedPerson]:
		payload = {
			"relatedPerson": related_person.__serialize__(lambda x0: serialize_related_person(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.tryAndRecover.undeleteRelatedPersonBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_related_person(x1))
			return return_value

	async def undelete_related_persons_async(self, related_persons: list[GroupScoped[RelatedPerson]]) -> list[GroupScoped[RelatedPerson]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: deserialize_related_person(x2)) for x1 in raw_result]
		payload = {
			"relatedPersons": [x0.__serialize__(lambda x1: serialize_related_person(x1)) for x0 in related_persons],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.tryAndRecover.undeleteRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_persons_blocking(self, related_persons: list[GroupScoped[RelatedPerson]]) -> list[GroupScoped[RelatedPerson]]:
		payload = {
			"relatedPersons": [x0.__serialize__(lambda x1: serialize_related_person(x1)) for x0 in related_persons],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.tryAndRecover.undeleteRelatedPersonsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: deserialize_related_person(x2)) for x1 in result_info.success]
			return return_value

	async def modify_related_person_async(self, entity: GroupScoped[RelatedPerson]) -> GroupScoped[RelatedPerson]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_related_person(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_related_person(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.tryAndRecover.modifyRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_related_person_blocking(self, entity: GroupScoped[RelatedPerson]) -> GroupScoped[RelatedPerson]:
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_related_person(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.tryAndRecover.modifyRelatedPersonBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_related_person(x1))
			return return_value

	async def modify_related_persons_async(self, entities: list[GroupScoped[RelatedPerson]]) -> list[GroupScoped[RelatedPerson]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: deserialize_related_person(x2)) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__(lambda x1: serialize_related_person(x1)) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.tryAndRecover.modifyRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_related_persons_blocking(self, entities: list[GroupScoped[RelatedPerson]]) -> list[GroupScoped[RelatedPerson]]:
		payload = {
			"entities": [x0.__serialize__(lambda x1: serialize_related_person(x1)) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.tryAndRecover.modifyRelatedPersonsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: deserialize_related_person(x2)) for x1 in result_info.success]
			return return_value

	async def get_related_person_async(self, group_id: str, entity_id: str) -> Optional[GroupScoped[RelatedPerson]]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_related_person(x1)) if raw_result is not None else None
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.tryAndRecover.getRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_related_person_blocking(self, group_id: str, entity_id: str) -> Optional[GroupScoped[RelatedPerson]]:
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.tryAndRecover.getRelatedPersonBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_related_person(x1)) if result_info.success is not None else None
			return return_value

	async def get_related_persons_async(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[RelatedPerson]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: deserialize_related_person(x2)) for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.tryAndRecover.getRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_related_persons_blocking(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[RelatedPerson]]:
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup.tryAndRecover.getRelatedPersonsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: deserialize_related_person(x2)) for x1 in result_info.success]
			return return_value
