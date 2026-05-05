# auto-generated file
import json
from cardinal_sdk.model import Insurance, StoredDocumentIdentifier, GroupScoped
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from typing import Optional


class InsuranceApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk
		self.in_group = InsuranceApiInGroup(self.cardinal_sdk)

	async def create_insurance_async(self, insurance: Insurance) -> Insurance:
		def do_decode(raw_result):
			return Insurance._deserialize(raw_result)
		payload = {
			"insurance": insurance.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.createInsuranceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_insurance_blocking(self, insurance: Insurance) -> Insurance:
		payload = {
			"insurance": insurance.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.createInsuranceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Insurance._deserialize(result_info.success)
			return return_value

	async def create_insurances_async(self, insurances: list[Insurance]) -> list[Insurance]:
		def do_decode(raw_result):
			return [Insurance._deserialize(x1) for x1 in raw_result]
		payload = {
			"insurances": [x0.__serialize__() for x0 in insurances],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.createInsurancesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_insurances_blocking(self, insurances: list[Insurance]) -> list[Insurance]:
		payload = {
			"insurances": [x0.__serialize__() for x0 in insurances],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.createInsurancesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [Insurance._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_insurance_async(self, insurance_id: str) -> Optional[Insurance]:
		def do_decode(raw_result):
			return Insurance._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"insuranceId": insurance_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.getInsuranceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_insurance_blocking(self, insurance_id: str) -> Optional[Insurance]:
		payload = {
			"insuranceId": insurance_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.getInsuranceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Insurance._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_insurances_async(self, insurances_ids: list[str]) -> list[Insurance]:
		def do_decode(raw_result):
			return [Insurance._deserialize(x1) for x1 in raw_result]
		payload = {
			"insurancesIds": [x0 for x0 in insurances_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.getInsurancesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_insurances_blocking(self, insurances_ids: list[str]) -> list[Insurance]:
		payload = {
			"insurancesIds": [x0 for x0 in insurances_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.getInsurancesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [Insurance._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def modify_insurance_async(self, insurance: Insurance) -> Insurance:
		def do_decode(raw_result):
			return Insurance._deserialize(raw_result)
		payload = {
			"insurance": insurance.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.modifyInsuranceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_insurance_blocking(self, insurance: Insurance) -> Insurance:
		payload = {
			"insurance": insurance.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.modifyInsuranceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Insurance._deserialize(result_info.success)
			return return_value

	async def modify_insurances_async(self, insurances: list[Insurance]) -> list[Insurance]:
		def do_decode(raw_result):
			return [Insurance._deserialize(x1) for x1 in raw_result]
		payload = {
			"insurances": [x0.__serialize__() for x0 in insurances],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.modifyInsurancesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_insurances_blocking(self, insurances: list[Insurance]) -> list[Insurance]:
		payload = {
			"insurances": [x0.__serialize__() for x0 in insurances],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.modifyInsurancesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [Insurance._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def delete_insurance_by_id_async(self, entity_id: str, rev: str) -> StoredDocumentIdentifier:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.deleteInsuranceByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_insurance_by_id_blocking(self, entity_id: str, rev: str) -> StoredDocumentIdentifier:
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.deleteInsuranceByIdBlocking(
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

	async def delete_insurance_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.deleteInsuranceByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_insurance_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.deleteInsuranceByIdsBlocking(
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

	async def delete_insurance_async(self, insurance: Insurance) -> StoredDocumentIdentifier:
		def do_decode(raw_result):
			return StoredDocumentIdentifier._deserialize(raw_result)
		payload = {
			"insurance": insurance.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.deleteInsuranceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_insurance_blocking(self, insurance: Insurance) -> StoredDocumentIdentifier:
		payload = {
			"insurance": insurance.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.deleteInsuranceBlocking(
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

	async def delete_insurances_async(self, insurances: list[Insurance]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"insurances": [x0.__serialize__() for x0 in insurances],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.deleteInsurancesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_insurances_blocking(self, insurances: list[Insurance]) -> list[StoredDocumentIdentifier]:
		payload = {
			"insurances": [x0.__serialize__() for x0 in insurances],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.deleteInsurancesBlocking(
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

	async def undelete_insurance_by_id_async(self, entity_id: str, rev: str) -> Insurance:
		def do_decode(raw_result):
			return Insurance._deserialize(raw_result)
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.undeleteInsuranceByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_insurance_by_id_blocking(self, entity_id: str, rev: str) -> Insurance:
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.undeleteInsuranceByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Insurance._deserialize(result_info.success)
			return return_value

	async def undelete_insurance_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[Insurance]:
		def do_decode(raw_result):
			return [Insurance._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.undeleteInsuranceByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_insurance_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[Insurance]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.undeleteInsuranceByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [Insurance._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def undelete_insurance_async(self, insurance: Insurance) -> Insurance:
		def do_decode(raw_result):
			return Insurance._deserialize(raw_result)
		payload = {
			"insurance": insurance.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.undeleteInsuranceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_insurance_blocking(self, insurance: Insurance) -> Insurance:
		payload = {
			"insurance": insurance.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.undeleteInsuranceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Insurance._deserialize(result_info.success)
			return return_value

	async def undelete_insurances_async(self, insurances: list[Insurance]) -> list[Insurance]:
		def do_decode(raw_result):
			return [Insurance._deserialize(x1) for x1 in raw_result]
		payload = {
			"insurances": [x0.__serialize__() for x0 in insurances],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.undeleteInsurancesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_insurances_blocking(self, insurances: list[Insurance]) -> list[Insurance]:
		payload = {
			"insurances": [x0.__serialize__() for x0 in insurances],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.undeleteInsurancesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [Insurance._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def purge_insurance_by_id_async(self, entity_id: str, rev: str) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.purgeInsuranceByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_insurance_by_id_blocking(self, entity_id: str, rev: str) -> None:
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.purgeInsuranceByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_insurance_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.purgeInsuranceByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_insurance_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.purgeInsuranceByIdsBlocking(
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

	async def purge_insurance_async(self, insurance: Insurance) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"insurance": insurance.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.purgeInsuranceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_insurance_blocking(self, insurance: Insurance) -> None:
		payload = {
			"insurance": insurance.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.purgeInsuranceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_insurances_async(self, insurances: list[Insurance]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"insurances": [x0.__serialize__() for x0 in insurances],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.purgeInsurancesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_insurances_blocking(self, insurances: list[Insurance]) -> list[StoredDocumentIdentifier]:
		payload = {
			"insurances": [x0.__serialize__() for x0 in insurances],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.purgeInsurancesBlocking(
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

	async def list_insurances_by_code_async(self, insurance_code: str) -> list[Insurance]:
		def do_decode(raw_result):
			return [Insurance._deserialize(x1) for x1 in raw_result]
		payload = {
			"insuranceCode": insurance_code,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.listInsurancesByCodeAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_insurances_by_code_blocking(self, insurance_code: str) -> list[Insurance]:
		payload = {
			"insuranceCode": insurance_code,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.listInsurancesByCodeBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [Insurance._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_insurances_by_name_async(self, insurance_name: str) -> list[Insurance]:
		def do_decode(raw_result):
			return [Insurance._deserialize(x1) for x1 in raw_result]
		payload = {
			"insuranceName": insurance_name,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.listInsurancesByNameAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_insurances_by_name_blocking(self, insurance_name: str) -> list[Insurance]:
		payload = {
			"insuranceName": insurance_name,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.listInsurancesByNameBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [Insurance._deserialize(x1) for x1 in result_info.success]
			return return_value


class InsuranceApiInGroup:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def create_insurance_async(self, insurance: GroupScoped[Insurance]) -> GroupScoped[Insurance]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: Insurance._deserialize(x1))
		payload = {
			"insurance": insurance.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.createInsuranceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_insurance_blocking(self, insurance: GroupScoped[Insurance]) -> GroupScoped[Insurance]:
		payload = {
			"insurance": insurance.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.createInsuranceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: Insurance._deserialize(x1))
			return return_value

	async def create_insurances_async(self, insurances: list[GroupScoped[Insurance]]) -> list[GroupScoped[Insurance]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: Insurance._deserialize(x2)) for x1 in raw_result]
		payload = {
			"insurances": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in insurances],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.createInsurancesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_insurances_blocking(self, insurances: list[GroupScoped[Insurance]]) -> list[GroupScoped[Insurance]]:
		payload = {
			"insurances": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in insurances],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.createInsurancesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: Insurance._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def get_insurance_async(self, group_id: str, insurance_id: str) -> Optional[GroupScoped[Insurance]]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: Insurance._deserialize(x1)) if raw_result is not None else None
		payload = {
			"groupId": group_id,
			"insuranceId": insurance_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.getInsuranceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_insurance_blocking(self, group_id: str, insurance_id: str) -> Optional[GroupScoped[Insurance]]:
		payload = {
			"groupId": group_id,
			"insuranceId": insurance_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.getInsuranceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: Insurance._deserialize(x1)) if result_info.success is not None else None
			return return_value

	async def get_insurances_async(self, group_id: str, insurances_ids: list[str]) -> list[GroupScoped[Insurance]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: Insurance._deserialize(x2)) for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"insurancesIds": [x0 for x0 in insurances_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.getInsurancesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_insurances_blocking(self, group_id: str, insurances_ids: list[str]) -> list[GroupScoped[Insurance]]:
		payload = {
			"groupId": group_id,
			"insurancesIds": [x0 for x0 in insurances_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.getInsurancesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: Insurance._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def modify_insurance_async(self, insurance: GroupScoped[Insurance]) -> GroupScoped[Insurance]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: Insurance._deserialize(x1))
		payload = {
			"insurance": insurance.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.modifyInsuranceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_insurance_blocking(self, insurance: GroupScoped[Insurance]) -> GroupScoped[Insurance]:
		payload = {
			"insurance": insurance.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.modifyInsuranceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: Insurance._deserialize(x1))
			return return_value

	async def modify_insurances_async(self, insurances: list[GroupScoped[Insurance]]) -> list[GroupScoped[Insurance]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: Insurance._deserialize(x2)) for x1 in raw_result]
		payload = {
			"insurances": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in insurances],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.modifyInsurancesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_insurances_blocking(self, insurances: list[GroupScoped[Insurance]]) -> list[GroupScoped[Insurance]]:
		payload = {
			"insurances": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in insurances],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.modifyInsurancesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: Insurance._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def delete_insurance_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: StoredDocumentIdentifier._deserialize(x1))
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.deleteInsuranceByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_insurance_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[StoredDocumentIdentifier]:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.deleteInsuranceByIdBlocking(
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

	async def delete_insurance_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.deleteInsuranceByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_insurance_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.deleteInsuranceByIdsBlocking(
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

	async def delete_insurance_async(self, insurance: GroupScoped[Insurance]) -> GroupScoped[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: StoredDocumentIdentifier._deserialize(x1))
		payload = {
			"insurance": insurance.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.deleteInsuranceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_insurance_blocking(self, insurance: GroupScoped[Insurance]) -> GroupScoped[StoredDocumentIdentifier]:
		payload = {
			"insurance": insurance.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.deleteInsuranceBlocking(
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

	async def delete_insurances_async(self, insurances: list[GroupScoped[Insurance]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"insurances": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in insurances],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.deleteInsurancesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_insurances_blocking(self, insurances: list[GroupScoped[Insurance]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"insurances": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in insurances],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.deleteInsurancesBlocking(
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

	async def undelete_insurance_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[Insurance]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: Insurance._deserialize(x1))
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.undeleteInsuranceByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_insurance_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[Insurance]:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.undeleteInsuranceByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: Insurance._deserialize(x1))
			return return_value

	async def undelete_insurance_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[Insurance]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: Insurance._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.undeleteInsuranceByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_insurance_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[Insurance]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.undeleteInsuranceByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: Insurance._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def undelete_insurance_async(self, insurance: GroupScoped[Insurance]) -> GroupScoped[Insurance]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: Insurance._deserialize(x1))
		payload = {
			"insurance": insurance.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.undeleteInsuranceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_insurance_blocking(self, insurance: GroupScoped[Insurance]) -> GroupScoped[Insurance]:
		payload = {
			"insurance": insurance.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.undeleteInsuranceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: Insurance._deserialize(x1))
			return return_value

	async def undelete_insurances_async(self, insurances: list[GroupScoped[Insurance]]) -> list[GroupScoped[Insurance]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: Insurance._deserialize(x2)) for x1 in raw_result]
		payload = {
			"insurances": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in insurances],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.undeleteInsurancesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_insurances_blocking(self, insurances: list[GroupScoped[Insurance]]) -> list[GroupScoped[Insurance]]:
		payload = {
			"insurances": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in insurances],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.undeleteInsurancesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: Insurance._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def purge_insurance_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.purgeInsuranceByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_insurance_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> None:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.purgeInsuranceByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_insurance_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.purgeInsuranceByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_insurance_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.purgeInsuranceByIdsBlocking(
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

	async def purge_insurance_async(self, insurance: GroupScoped[Insurance]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"insurance": insurance.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.purgeInsuranceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_insurance_blocking(self, insurance: GroupScoped[Insurance]) -> None:
		payload = {
			"insurance": insurance.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.purgeInsuranceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_insurances_async(self, insurances: list[GroupScoped[Insurance]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"insurances": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in insurances],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.purgeInsurancesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_insurances_blocking(self, insurances: list[GroupScoped[Insurance]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"insurances": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in insurances],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup.purgeInsurancesBlocking(
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
