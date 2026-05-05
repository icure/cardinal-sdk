# auto-generated file
import json
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from typing import Optional
from cardinal_sdk.model import HealthcareParty, PublicKey, DataOwnerRegistrationSuccess, StoredDocumentIdentifier, SubscriptionEventType, EntitySubscriptionConfiguration, GroupScoped
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.filters.FilterOptions import BaseFilterOptions, BaseSortableFilterOptions, FilterOptions
from cardinal_sdk.pagination.PaginatedListIterator import PaginatedListIterator
from cardinal_sdk.subscription.EntitySubscription import EntitySubscription


class HealthcarePartyApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk
		self.in_group = HealthcarePartyApiInGroup(self.cardinal_sdk)

	async def get_healthcare_party_async(self, healthcare_party_id: str) -> Optional[HealthcareParty]:
		def do_decode(raw_result):
			return HealthcareParty._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"healthcarePartyId": healthcare_party_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.getHealthcarePartyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_healthcare_party_blocking(self, healthcare_party_id: str) -> Optional[HealthcareParty]:
		payload = {
			"healthcarePartyId": healthcare_party_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.getHealthcarePartyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = HealthcareParty._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_healthcare_parties_async(self, healthcare_party_ids: list[str]) -> list[HealthcareParty]:
		def do_decode(raw_result):
			return [HealthcareParty._deserialize(x1) for x1 in raw_result]
		payload = {
			"healthcarePartyIds": [x0 for x0 in healthcare_party_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.getHealthcarePartiesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_healthcare_parties_blocking(self, healthcare_party_ids: list[str]) -> list[HealthcareParty]:
		payload = {
			"healthcarePartyIds": [x0 for x0 in healthcare_party_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.getHealthcarePartiesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [HealthcareParty._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def create_healthcare_party_async(self, healthcare_party: HealthcareParty) -> HealthcareParty:
		def do_decode(raw_result):
			return HealthcareParty._deserialize(raw_result)
		payload = {
			"healthcareParty": healthcare_party.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.createHealthcarePartyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_healthcare_party_blocking(self, healthcare_party: HealthcareParty) -> HealthcareParty:
		payload = {
			"healthcareParty": healthcare_party.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.createHealthcarePartyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = HealthcareParty._deserialize(result_info.success)
			return return_value

	async def create_healthcare_parties_async(self, healthcare_parties: list[HealthcareParty]) -> list[HealthcareParty]:
		def do_decode(raw_result):
			return [HealthcareParty._deserialize(x1) for x1 in raw_result]
		payload = {
			"healthcareParties": [x0.__serialize__() for x0 in healthcare_parties],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.createHealthcarePartiesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_healthcare_parties_blocking(self, healthcare_parties: list[HealthcareParty]) -> list[HealthcareParty]:
		payload = {
			"healthcareParties": [x0.__serialize__() for x0 in healthcare_parties],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.createHealthcarePartiesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [HealthcareParty._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def modify_healthcare_party_async(self, healthcare_party: HealthcareParty) -> HealthcareParty:
		def do_decode(raw_result):
			return HealthcareParty._deserialize(raw_result)
		payload = {
			"healthcareParty": healthcare_party.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.modifyHealthcarePartyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_healthcare_party_blocking(self, healthcare_party: HealthcareParty) -> HealthcareParty:
		payload = {
			"healthcareParty": healthcare_party.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.modifyHealthcarePartyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = HealthcareParty._deserialize(result_info.success)
			return return_value

	async def modify_healthcare_parties_async(self, healthcare_parties: list[HealthcareParty]) -> list[HealthcareParty]:
		def do_decode(raw_result):
			return [HealthcareParty._deserialize(x1) for x1 in raw_result]
		payload = {
			"healthcareParties": [x0.__serialize__() for x0 in healthcare_parties],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.modifyHealthcarePartiesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_healthcare_parties_blocking(self, healthcare_parties: list[HealthcareParty]) -> list[HealthcareParty]:
		payload = {
			"healthcareParties": [x0.__serialize__() for x0 in healthcare_parties],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.modifyHealthcarePartiesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [HealthcareParty._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_current_healthcare_party_async(self) -> HealthcareParty:
		def do_decode(raw_result):
			return HealthcareParty._deserialize(raw_result)
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.getCurrentHealthcarePartyAsync,
			self.cardinal_sdk._native,
		)

	def get_current_healthcare_party_blocking(self) -> HealthcareParty:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.getCurrentHealthcarePartyBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = HealthcareParty._deserialize(result_info.success)
			return return_value

	async def get_public_key_async(self, healthcare_party_id: str) -> PublicKey:
		def do_decode(raw_result):
			return PublicKey._deserialize(raw_result)
		payload = {
			"healthcarePartyId": healthcare_party_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.getPublicKeyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_public_key_blocking(self, healthcare_party_id: str) -> PublicKey:
		payload = {
			"healthcarePartyId": healthcare_party_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.getPublicKeyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = PublicKey._deserialize(result_info.success)
			return return_value

	async def match_healthcare_parties_by_async(self, filter: BaseFilterOptions[HealthcareParty]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.matchHealthcarePartiesByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_healthcare_parties_by_blocking(self, filter: BaseFilterOptions[HealthcareParty]) -> list[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.matchHealthcarePartiesByBlocking(
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

	async def filter_health_parties_by_async(self, filter: BaseFilterOptions[HealthcareParty]) -> PaginatedListIterator[HealthcareParty]:
		def do_decode(raw_result):
			return PaginatedListIterator[HealthcareParty](
				producer = raw_result,
				deserializer = lambda x: HealthcareParty._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.filterHealthPartiesByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_health_parties_by_blocking(self, filter: BaseFilterOptions[HealthcareParty]) -> PaginatedListIterator[HealthcareParty]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.filterHealthPartiesByBlocking(
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
			return PaginatedListIterator[HealthcareParty](
				producer = class_pointer,
				deserializer = lambda x: HealthcareParty._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def match_healthcare_parties_by_sorted_async(self, filter: BaseSortableFilterOptions[HealthcareParty]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.matchHealthcarePartiesBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_healthcare_parties_by_sorted_blocking(self, filter: BaseSortableFilterOptions[HealthcareParty]) -> list[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.matchHealthcarePartiesBySortedBlocking(
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

	async def filter_health_parties_by_sorted_async(self, filter: BaseSortableFilterOptions[HealthcareParty]) -> PaginatedListIterator[HealthcareParty]:
		def do_decode(raw_result):
			return PaginatedListIterator[HealthcareParty](
				producer = raw_result,
				deserializer = lambda x: HealthcareParty._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.filterHealthPartiesBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_health_parties_by_sorted_blocking(self, filter: BaseSortableFilterOptions[HealthcareParty]) -> PaginatedListIterator[HealthcareParty]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.filterHealthPartiesBySortedBlocking(
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
			return PaginatedListIterator[HealthcareParty](
				producer = class_pointer,
				deserializer = lambda x: HealthcareParty._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def register_healthcare_party_async(self, group_id: str, hcp: HealthcareParty, parent_hc_party_id: Optional[str] = None, token: Optional[str] = None, use_short_token: Optional[bool] = None) -> DataOwnerRegistrationSuccess:
		def do_decode(raw_result):
			return DataOwnerRegistrationSuccess._deserialize(raw_result)
		payload = {
			"groupId": group_id,
			"parentHcPartyId": parent_hc_party_id,
			"token": token,
			"useShortToken": use_short_token,
			"hcp": hcp.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.registerHealthcarePartyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def register_healthcare_party_blocking(self, group_id: str, hcp: HealthcareParty, parent_hc_party_id: Optional[str] = None, token: Optional[str] = None, use_short_token: Optional[bool] = None) -> DataOwnerRegistrationSuccess:
		payload = {
			"groupId": group_id,
			"parentHcPartyId": parent_hc_party_id,
			"token": token,
			"useShortToken": use_short_token,
			"hcp": hcp.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.registerHealthcarePartyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DataOwnerRegistrationSuccess._deserialize(result_info.success)
			return return_value

	async def delete_healthcare_party_by_id_async(self, entity_id: str, rev: str) -> StoredDocumentIdentifier:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.deleteHealthcarePartyByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_healthcare_party_by_id_blocking(self, entity_id: str, rev: str) -> StoredDocumentIdentifier:
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.deleteHealthcarePartyByIdBlocking(
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

	async def delete_healthcare_parties_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.deleteHealthcarePartiesByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_healthcare_parties_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.deleteHealthcarePartiesByIdsBlocking(
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

	async def purge_healthcare_party_by_id_async(self, id: str, rev: str) -> None:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.purgeHealthcarePartyByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_healthcare_party_by_id_blocking(self, id: str, rev: str) -> None:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.purgeHealthcarePartyByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_healthcare_parties_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.purgeHealthcarePartiesByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_healthcare_parties_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.purgeHealthcarePartiesByIdsBlocking(
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

	async def undelete_healthcare_party_by_id_async(self, id: str, rev: str) -> HealthcareParty:
		def do_decode(raw_result):
			return HealthcareParty._deserialize(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.undeleteHealthcarePartyByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_healthcare_party_by_id_blocking(self, id: str, rev: str) -> HealthcareParty:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.undeleteHealthcarePartyByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = HealthcareParty._deserialize(result_info.success)
			return return_value

	async def undelete_healthcare_parties_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[HealthcareParty]:
		def do_decode(raw_result):
			return [HealthcareParty._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.undeleteHealthcarePartiesByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_healthcare_parties_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[HealthcareParty]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.undeleteHealthcarePartiesByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [HealthcareParty._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def delete_healthcare_party_async(self, healthcare_party: HealthcareParty) -> StoredDocumentIdentifier:
		def do_decode(raw_result):
			return StoredDocumentIdentifier._deserialize(raw_result)
		payload = {
			"healthcareParty": healthcare_party.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.deleteHealthcarePartyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_healthcare_party_blocking(self, healthcare_party: HealthcareParty) -> StoredDocumentIdentifier:
		payload = {
			"healthcareParty": healthcare_party.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.deleteHealthcarePartyBlocking(
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

	async def delete_healthcare_parties_async(self, healthcare_parties: list[HealthcareParty]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"healthcareParties": [x0.__serialize__() for x0 in healthcare_parties],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.deleteHealthcarePartiesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_healthcare_parties_blocking(self, healthcare_parties: list[HealthcareParty]) -> list[StoredDocumentIdentifier]:
		payload = {
			"healthcareParties": [x0.__serialize__() for x0 in healthcare_parties],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.deleteHealthcarePartiesBlocking(
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

	async def purge_healthcare_party_async(self, healthcare_party: HealthcareParty) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"healthcareParty": healthcare_party.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.purgeHealthcarePartyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_healthcare_party_blocking(self, healthcare_party: HealthcareParty) -> None:
		payload = {
			"healthcareParty": healthcare_party.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.purgeHealthcarePartyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_healthcare_parties_async(self, healthcare_parties: list[HealthcareParty]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"healthcareParties": [x0.__serialize__() for x0 in healthcare_parties],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.purgeHealthcarePartiesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_healthcare_parties_blocking(self, healthcare_parties: list[HealthcareParty]) -> list[StoredDocumentIdentifier]:
		payload = {
			"healthcareParties": [x0.__serialize__() for x0 in healthcare_parties],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.purgeHealthcarePartiesBlocking(
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

	async def undelete_healthcare_party_async(self, healthcare_party: HealthcareParty) -> HealthcareParty:
		def do_decode(raw_result):
			return HealthcareParty._deserialize(raw_result)
		payload = {
			"healthcareParty": healthcare_party.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.undeleteHealthcarePartyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_healthcare_party_blocking(self, healthcare_party: HealthcareParty) -> HealthcareParty:
		payload = {
			"healthcareParty": healthcare_party.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.undeleteHealthcarePartyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = HealthcareParty._deserialize(result_info.success)
			return return_value

	async def undelete_healthcare_parties_async(self, healthcare_parties: list[HealthcareParty]) -> list[HealthcareParty]:
		def do_decode(raw_result):
			return [HealthcareParty._deserialize(x1) for x1 in raw_result]
		payload = {
			"healthcareParties": [x0.__serialize__() for x0 in healthcare_parties],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.undeleteHealthcarePartiesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_healthcare_parties_blocking(self, healthcare_parties: list[HealthcareParty]) -> list[HealthcareParty]:
		payload = {
			"healthcareParties": [x0.__serialize__() for x0 in healthcare_parties],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.undeleteHealthcarePartiesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [HealthcareParty._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def subscribe_to_events_async(self, events: set[SubscriptionEventType], filter: FilterOptions[HealthcareParty], subscription_config: Optional[EntitySubscriptionConfiguration] = None) -> EntitySubscription[HealthcareParty]:
		def do_decode(raw_result):
			return EntitySubscription[HealthcareParty](
				producer = raw_result,
				deserializer = lambda x: HealthcareParty._deserialize(x),
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.subscribeToEventsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def subscribe_to_events_blocking(self, events: set[SubscriptionEventType], filter: FilterOptions[HealthcareParty], subscription_config: Optional[EntitySubscriptionConfiguration] = None) -> EntitySubscription[HealthcareParty]:
		payload = {
			"events": [x0.__serialize__() for x0 in events],
			"filter": filter.__serialize__(),
			"subscriptionConfig": subscription_config.__serialize__() if subscription_config is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.subscribeToEventsBlocking(
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
			return EntitySubscription[HealthcareParty](
				producer = class_pointer,
				deserializer = lambda x: HealthcareParty._deserialize(x),
				executor = self.cardinal_sdk._executor
			)


class HealthcarePartyApiInGroup:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def create_healthcare_party_async(self, healthcare_party: GroupScoped[HealthcareParty]) -> GroupScoped[HealthcareParty]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: HealthcareParty._deserialize(x1))
		payload = {
			"healthcareParty": healthcare_party.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.createHealthcarePartyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_healthcare_party_blocking(self, healthcare_party: GroupScoped[HealthcareParty]) -> GroupScoped[HealthcareParty]:
		payload = {
			"healthcareParty": healthcare_party.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.createHealthcarePartyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: HealthcareParty._deserialize(x1))
			return return_value

	async def create_healthcare_parties_async(self, healthcare_parties: list[GroupScoped[HealthcareParty]]) -> list[GroupScoped[HealthcareParty]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: HealthcareParty._deserialize(x2)) for x1 in raw_result]
		payload = {
			"healthcareParties": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in healthcare_parties],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.createHealthcarePartiesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_healthcare_parties_blocking(self, healthcare_parties: list[GroupScoped[HealthcareParty]]) -> list[GroupScoped[HealthcareParty]]:
		payload = {
			"healthcareParties": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in healthcare_parties],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.createHealthcarePartiesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: HealthcareParty._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def get_healthcare_party_async(self, group_id: str, healthcare_party_id: str) -> Optional[GroupScoped[HealthcareParty]]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: HealthcareParty._deserialize(x1)) if raw_result is not None else None
		payload = {
			"groupId": group_id,
			"healthcarePartyId": healthcare_party_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.getHealthcarePartyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_healthcare_party_blocking(self, group_id: str, healthcare_party_id: str) -> Optional[GroupScoped[HealthcareParty]]:
		payload = {
			"groupId": group_id,
			"healthcarePartyId": healthcare_party_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.getHealthcarePartyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: HealthcareParty._deserialize(x1)) if result_info.success is not None else None
			return return_value

	async def get_healthcare_parties_async(self, group_id: str, healthcare_parties_ids: list[str]) -> list[GroupScoped[HealthcareParty]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: HealthcareParty._deserialize(x2)) for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"healthcarePartiesIds": [x0 for x0 in healthcare_parties_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.getHealthcarePartiesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_healthcare_parties_blocking(self, group_id: str, healthcare_parties_ids: list[str]) -> list[GroupScoped[HealthcareParty]]:
		payload = {
			"groupId": group_id,
			"healthcarePartiesIds": [x0 for x0 in healthcare_parties_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.getHealthcarePartiesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: HealthcareParty._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def modify_healthcare_party_async(self, healthcare_party: GroupScoped[HealthcareParty]) -> GroupScoped[HealthcareParty]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: HealthcareParty._deserialize(x1))
		payload = {
			"healthcareParty": healthcare_party.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.modifyHealthcarePartyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_healthcare_party_blocking(self, healthcare_party: GroupScoped[HealthcareParty]) -> GroupScoped[HealthcareParty]:
		payload = {
			"healthcareParty": healthcare_party.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.modifyHealthcarePartyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: HealthcareParty._deserialize(x1))
			return return_value

	async def modify_healthcare_parties_async(self, healthcare_parties: list[GroupScoped[HealthcareParty]]) -> list[GroupScoped[HealthcareParty]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: HealthcareParty._deserialize(x2)) for x1 in raw_result]
		payload = {
			"healthcareParties": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in healthcare_parties],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.modifyHealthcarePartiesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_healthcare_parties_blocking(self, healthcare_parties: list[GroupScoped[HealthcareParty]]) -> list[GroupScoped[HealthcareParty]]:
		payload = {
			"healthcareParties": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in healthcare_parties],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.modifyHealthcarePartiesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: HealthcareParty._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def delete_healthcare_party_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: StoredDocumentIdentifier._deserialize(x1))
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.deleteHealthcarePartyByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_healthcare_party_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[StoredDocumentIdentifier]:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.deleteHealthcarePartyByIdBlocking(
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

	async def delete_healthcare_party_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.deleteHealthcarePartyByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_healthcare_party_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.deleteHealthcarePartyByIdsBlocking(
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

	async def delete_healthcare_party_async(self, healthcare_party: GroupScoped[HealthcareParty]) -> GroupScoped[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: StoredDocumentIdentifier._deserialize(x1))
		payload = {
			"healthcareParty": healthcare_party.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.deleteHealthcarePartyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_healthcare_party_blocking(self, healthcare_party: GroupScoped[HealthcareParty]) -> GroupScoped[StoredDocumentIdentifier]:
		payload = {
			"healthcareParty": healthcare_party.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.deleteHealthcarePartyBlocking(
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

	async def delete_healthcare_parties_async(self, healthcare_parties: list[GroupScoped[HealthcareParty]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"healthcareParties": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in healthcare_parties],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.deleteHealthcarePartiesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_healthcare_parties_blocking(self, healthcare_parties: list[GroupScoped[HealthcareParty]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"healthcareParties": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in healthcare_parties],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.deleteHealthcarePartiesBlocking(
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

	async def undelete_healthcare_party_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[HealthcareParty]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: HealthcareParty._deserialize(x1))
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.undeleteHealthcarePartyByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_healthcare_party_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[HealthcareParty]:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.undeleteHealthcarePartyByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: HealthcareParty._deserialize(x1))
			return return_value

	async def undelete_healthcare_party_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[HealthcareParty]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: HealthcareParty._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.undeleteHealthcarePartyByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_healthcare_party_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[HealthcareParty]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.undeleteHealthcarePartyByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: HealthcareParty._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def undelete_healthcare_party_async(self, healthcare_party: GroupScoped[HealthcareParty]) -> GroupScoped[HealthcareParty]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: HealthcareParty._deserialize(x1))
		payload = {
			"healthcareParty": healthcare_party.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.undeleteHealthcarePartyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_healthcare_party_blocking(self, healthcare_party: GroupScoped[HealthcareParty]) -> GroupScoped[HealthcareParty]:
		payload = {
			"healthcareParty": healthcare_party.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.undeleteHealthcarePartyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: HealthcareParty._deserialize(x1))
			return return_value

	async def undelete_healthcare_parties_async(self, healthcare_parties: list[GroupScoped[HealthcareParty]]) -> list[GroupScoped[HealthcareParty]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: HealthcareParty._deserialize(x2)) for x1 in raw_result]
		payload = {
			"healthcareParties": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in healthcare_parties],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.undeleteHealthcarePartiesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_healthcare_parties_blocking(self, healthcare_parties: list[GroupScoped[HealthcareParty]]) -> list[GroupScoped[HealthcareParty]]:
		payload = {
			"healthcareParties": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in healthcare_parties],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.undeleteHealthcarePartiesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: HealthcareParty._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def purge_healthcare_party_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.purgeHealthcarePartyByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_healthcare_party_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> None:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.purgeHealthcarePartyByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_healthcare_party_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.purgeHealthcarePartyByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_healthcare_party_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.purgeHealthcarePartyByIdsBlocking(
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

	async def purge_healthcare_party_async(self, healthcare_party: GroupScoped[HealthcareParty]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"healthcareParty": healthcare_party.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.purgeHealthcarePartyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_healthcare_party_blocking(self, healthcare_party: GroupScoped[HealthcareParty]) -> None:
		payload = {
			"healthcareParty": healthcare_party.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.purgeHealthcarePartyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_healthcare_parties_async(self, healthcare_parties: list[GroupScoped[HealthcareParty]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"healthcareParties": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in healthcare_parties],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.purgeHealthcarePartiesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_healthcare_parties_blocking(self, healthcare_parties: list[GroupScoped[HealthcareParty]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"healthcareParties": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in healthcare_parties],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.purgeHealthcarePartiesBlocking(
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

	async def match_healthcare_parties_by_async(self, group_id: str, filter: BaseFilterOptions[HealthcareParty]) -> list[str]:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.matchHealthcarePartiesByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_healthcare_parties_by_blocking(self, group_id: str, filter: BaseFilterOptions[HealthcareParty]) -> list[str]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.matchHealthcarePartiesByBlocking(
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

	async def match_healthcare_parties_by_sorted_async(self, group_id: str, filter: BaseSortableFilterOptions[HealthcareParty]) -> list[str]:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.matchHealthcarePartiesBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_healthcare_parties_by_sorted_blocking(self, group_id: str, filter: BaseSortableFilterOptions[HealthcareParty]) -> list[str]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.matchHealthcarePartiesBySortedBlocking(
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

	async def filter_health_parties_by_async(self, group_id: str, filter: BaseFilterOptions[HealthcareParty]) -> PaginatedListIterator[GroupScoped[HealthcareParty]]:
		def do_decode(raw_result):
			return PaginatedListIterator[GroupScoped[HealthcareParty]](
				producer = raw_result,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: HealthcareParty._deserialize(x1)),
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.filterHealthPartiesByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_health_parties_by_blocking(self, group_id: str, filter: BaseFilterOptions[HealthcareParty]) -> PaginatedListIterator[GroupScoped[HealthcareParty]]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.filterHealthPartiesByBlocking(
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
			return PaginatedListIterator[GroupScoped[HealthcareParty]](
				producer = class_pointer,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: HealthcareParty._deserialize(x1)),
				executor = self.cardinal_sdk._executor
			)

	async def filter_health_parties_by_sorted_async(self, group_id: str, filter: BaseSortableFilterOptions[HealthcareParty]) -> PaginatedListIterator[GroupScoped[HealthcareParty]]:
		def do_decode(raw_result):
			return PaginatedListIterator[GroupScoped[HealthcareParty]](
				producer = raw_result,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: HealthcareParty._deserialize(x1)),
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.filterHealthPartiesBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_health_parties_by_sorted_blocking(self, group_id: str, filter: BaseSortableFilterOptions[HealthcareParty]) -> PaginatedListIterator[GroupScoped[HealthcareParty]]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthcarePartyApi.inGroup.filterHealthPartiesBySortedBlocking(
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
			return PaginatedListIterator[GroupScoped[HealthcareParty]](
				producer = class_pointer,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: HealthcareParty._deserialize(x1)),
				executor = self.cardinal_sdk._executor
			)
