# auto-generated file
import json
from cardinal_sdk.filters.FilterOptions import BaseFilterOptions, BaseSortableFilterOptions
from cardinal_sdk.model import RelatedPerson, EncryptedRelatedPerson, StoredDocumentIdentifier, serialize_related_person, GroupScoped
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.pagination.PaginatedListIterator import PaginatedListIterator
from typing import Optional


class RelatedPersonBasicApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk
		self.in_group = RelatedPersonBasicApiInGroup(self.cardinal_sdk)

	async def match_related_persons_by_async(self, filter: BaseFilterOptions[RelatedPerson]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.matchRelatedPersonsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_related_persons_by_blocking(self, filter: BaseFilterOptions[RelatedPerson]) -> list[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.matchRelatedPersonsByBlocking(
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

	async def match_related_persons_by_sorted_async(self, filter: BaseSortableFilterOptions[RelatedPerson]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.matchRelatedPersonsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_related_persons_by_sorted_blocking(self, filter: BaseSortableFilterOptions[RelatedPerson]) -> list[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.matchRelatedPersonsBySortedBlocking(
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

	async def filter_related_persons_by_async(self, filter: BaseFilterOptions[RelatedPerson]) -> PaginatedListIterator[EncryptedRelatedPerson]:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.filterRelatedPersonsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_related_persons_by_blocking(self, filter: BaseFilterOptions[RelatedPerson]) -> PaginatedListIterator[EncryptedRelatedPerson]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.filterRelatedPersonsByBlocking(
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

	async def filter_related_persons_by_sorted_async(self, filter: BaseSortableFilterOptions[RelatedPerson]) -> PaginatedListIterator[EncryptedRelatedPerson]:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.filterRelatedPersonsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_related_persons_by_sorted_blocking(self, filter: BaseSortableFilterOptions[RelatedPerson]) -> PaginatedListIterator[EncryptedRelatedPerson]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.filterRelatedPersonsBySortedBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.deleteRelatedPersonByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_related_person_by_id_blocking(self, entity_id: str, rev: str) -> StoredDocumentIdentifier:
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.deleteRelatedPersonByIdBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.deleteRelatedPersonsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_related_persons_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.deleteRelatedPersonsByIdsBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.purgeRelatedPersonByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_related_person_by_id_blocking(self, id: str, rev: str) -> None:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.purgeRelatedPersonByIdBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.purgeRelatedPersonsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_related_persons_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.purgeRelatedPersonsByIdsBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.deleteRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_related_person_blocking(self, related_person: RelatedPerson) -> StoredDocumentIdentifier:
		payload = {
			"relatedPerson": serialize_related_person(related_person),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.deleteRelatedPersonBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.deleteRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_related_persons_blocking(self, related_persons: list[RelatedPerson]) -> list[StoredDocumentIdentifier]:
		payload = {
			"relatedPersons": [serialize_related_person(x0) for x0 in related_persons],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.deleteRelatedPersonsBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.purgeRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_related_person_blocking(self, related_person: RelatedPerson) -> None:
		payload = {
			"relatedPerson": serialize_related_person(related_person),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.purgeRelatedPersonBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.purgeRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_related_persons_blocking(self, related_persons: list[RelatedPerson]) -> list[StoredDocumentIdentifier]:
		payload = {
			"relatedPersons": [serialize_related_person(x0) for x0 in related_persons],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.purgeRelatedPersonsBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.createRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_related_person_blocking(self, entity: EncryptedRelatedPerson) -> EncryptedRelatedPerson:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.createRelatedPersonBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.createRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_related_persons_blocking(self, entities: list[EncryptedRelatedPerson]) -> list[EncryptedRelatedPerson]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.createRelatedPersonsBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.undeleteRelatedPersonByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_person_by_id_blocking(self, id: str, rev: str) -> EncryptedRelatedPerson:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.undeleteRelatedPersonByIdBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.undeleteRelatedPersonsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_persons_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[EncryptedRelatedPerson]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.undeleteRelatedPersonsByIdsBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.undeleteRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_person_blocking(self, related_person: RelatedPerson) -> EncryptedRelatedPerson:
		payload = {
			"relatedPerson": serialize_related_person(related_person),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.undeleteRelatedPersonBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.undeleteRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_persons_blocking(self, related_persons: list[RelatedPerson]) -> list[EncryptedRelatedPerson]:
		payload = {
			"relatedPersons": [serialize_related_person(x0) for x0 in related_persons],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.undeleteRelatedPersonsBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.modifyRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_related_person_blocking(self, entity: EncryptedRelatedPerson) -> EncryptedRelatedPerson:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.modifyRelatedPersonBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.modifyRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_related_persons_blocking(self, entities: list[EncryptedRelatedPerson]) -> list[EncryptedRelatedPerson]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.modifyRelatedPersonsBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.getRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_related_person_blocking(self, entity_id: str) -> Optional[EncryptedRelatedPerson]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.getRelatedPersonBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.getRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_related_persons_blocking(self, entity_ids: list[str]) -> list[EncryptedRelatedPerson]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.getRelatedPersonsBlocking(
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


class RelatedPersonBasicApiInGroup:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def match_related_persons_by_async(self, group_id: str, filter: BaseFilterOptions[RelatedPerson]) -> list[str]:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.matchRelatedPersonsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_related_persons_by_blocking(self, group_id: str, filter: BaseFilterOptions[RelatedPerson]) -> list[str]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.matchRelatedPersonsByBlocking(
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

	async def match_related_persons_by_sorted_async(self, group_id: str, filter: BaseSortableFilterOptions[RelatedPerson]) -> list[str]:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.matchRelatedPersonsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_related_persons_by_sorted_blocking(self, group_id: str, filter: BaseSortableFilterOptions[RelatedPerson]) -> list[str]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.matchRelatedPersonsBySortedBlocking(
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

	async def filter_related_persons_by_async(self, group_id: str, filter: BaseFilterOptions[RelatedPerson]) -> PaginatedListIterator[GroupScoped[EncryptedRelatedPerson]]:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.filterRelatedPersonsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_related_persons_by_blocking(self, group_id: str, filter: BaseFilterOptions[RelatedPerson]) -> PaginatedListIterator[GroupScoped[EncryptedRelatedPerson]]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.filterRelatedPersonsByBlocking(
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

	async def filter_related_persons_by_sorted_async(self, group_id: str, filter: BaseSortableFilterOptions[RelatedPerson]) -> PaginatedListIterator[GroupScoped[EncryptedRelatedPerson]]:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.filterRelatedPersonsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_related_persons_by_sorted_blocking(self, group_id: str, filter: BaseSortableFilterOptions[RelatedPerson]) -> PaginatedListIterator[GroupScoped[EncryptedRelatedPerson]]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.filterRelatedPersonsBySortedBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.deleteRelatedPersonByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_related_person_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[StoredDocumentIdentifier]:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.deleteRelatedPersonByIdBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.deleteRelatedPersonsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_related_persons_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.deleteRelatedPersonsByIdsBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.purgeRelatedPersonByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_related_person_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> None:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.purgeRelatedPersonByIdBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.purgeRelatedPersonsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_related_persons_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.purgeRelatedPersonsByIdsBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.deleteRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_related_person_blocking(self, related_person: GroupScoped[RelatedPerson]) -> GroupScoped[StoredDocumentIdentifier]:
		payload = {
			"relatedPerson": related_person.__serialize__(lambda x0: serialize_related_person(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.deleteRelatedPersonBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.deleteRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_related_persons_blocking(self, related_persons: list[GroupScoped[RelatedPerson]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"relatedPersons": [x0.__serialize__(lambda x1: serialize_related_person(x1)) for x0 in related_persons],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.deleteRelatedPersonsBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.purgeRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_related_person_blocking(self, related_person: GroupScoped[RelatedPerson]) -> None:
		payload = {
			"relatedPerson": related_person.__serialize__(lambda x0: serialize_related_person(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.purgeRelatedPersonBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.purgeRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_related_persons_blocking(self, related_persons: list[GroupScoped[RelatedPerson]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"relatedPersons": [x0.__serialize__(lambda x1: serialize_related_person(x1)) for x0 in related_persons],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.purgeRelatedPersonsBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.createRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_related_person_blocking(self, entity: GroupScoped[EncryptedRelatedPerson]) -> GroupScoped[EncryptedRelatedPerson]:
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.createRelatedPersonBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.createRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_related_persons_blocking(self, entities: list[GroupScoped[EncryptedRelatedPerson]]) -> list[GroupScoped[EncryptedRelatedPerson]]:
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.createRelatedPersonsBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.undeleteRelatedPersonByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_person_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[EncryptedRelatedPerson]:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.undeleteRelatedPersonByIdBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.undeleteRelatedPersonsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_persons_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[EncryptedRelatedPerson]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.undeleteRelatedPersonsByIdsBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.undeleteRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_person_blocking(self, related_person: GroupScoped[RelatedPerson]) -> GroupScoped[EncryptedRelatedPerson]:
		payload = {
			"relatedPerson": related_person.__serialize__(lambda x0: serialize_related_person(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.undeleteRelatedPersonBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.undeleteRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_related_persons_blocking(self, related_persons: list[GroupScoped[EncryptedRelatedPerson]]) -> list[GroupScoped[EncryptedRelatedPerson]]:
		payload = {
			"relatedPersons": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in related_persons],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.undeleteRelatedPersonsBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.modifyRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_related_person_blocking(self, entity: GroupScoped[EncryptedRelatedPerson]) -> GroupScoped[EncryptedRelatedPerson]:
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.modifyRelatedPersonBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.modifyRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_related_persons_blocking(self, entities: list[GroupScoped[EncryptedRelatedPerson]]) -> list[GroupScoped[EncryptedRelatedPerson]]:
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.modifyRelatedPersonsBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.getRelatedPersonAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_related_person_blocking(self, group_id: str, entity_id: str) -> Optional[GroupScoped[EncryptedRelatedPerson]]:
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.getRelatedPersonBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.getRelatedPersonsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_related_persons_blocking(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[EncryptedRelatedPerson]]:
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RelatedPersonBasicApi.inGroup.getRelatedPersonsBlocking(
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
