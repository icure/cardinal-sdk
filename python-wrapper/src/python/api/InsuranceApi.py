# auto-generated file
import json
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from typing import Optional
from cardinal_sdk.model import Insurance, DocIdentifier
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p


class InsuranceApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

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

	async def get_insurances_async(self, insurance_ids: list[str]) -> list[Insurance]:
		def do_decode(raw_result):
			return [Insurance._deserialize(x1) for x1 in raw_result]
		payload = {
			"insuranceIds": [x0 for x0 in insurance_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.getInsurancesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_insurances_blocking(self, insurance_ids: list[str]) -> list[Insurance]:
		payload = {
			"insuranceIds": [x0 for x0 in insurance_ids],
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

	async def delete_insurance_async(self, insurance_id: str) -> DocIdentifier:
		def do_decode(raw_result):
			return DocIdentifier._deserialize(raw_result)
		payload = {
			"insuranceId": insurance_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.deleteInsuranceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_insurance_blocking(self, insurance_id: str) -> DocIdentifier:
		payload = {
			"insuranceId": insurance_id,
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
			return_value = DocIdentifier._deserialize(result_info.success)
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

	async def create_insurances_in_group_async(self, group_id: str, insurance_batch: list[Insurance]) -> list[Insurance]:
		def do_decode(raw_result):
			return [Insurance._deserialize(x1) for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"insuranceBatch": [x0.__serialize__() for x0 in insurance_batch],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.createInsurancesInGroupAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_insurances_in_group_blocking(self, group_id: str, insurance_batch: list[Insurance]) -> list[Insurance]:
		payload = {
			"groupId": group_id,
			"insuranceBatch": [x0.__serialize__() for x0 in insurance_batch],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.createInsurancesInGroupBlocking(
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

	async def get_insurances_in_group_async(self, group_id: str, insurance_ids: str) -> list[Insurance]:
		def do_decode(raw_result):
			return [Insurance._deserialize(x1) for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"insuranceIds": insurance_ids,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.getInsurancesInGroupAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_insurances_in_group_blocking(self, group_id: str, insurance_ids: str) -> list[Insurance]:
		payload = {
			"groupId": group_id,
			"insuranceIds": insurance_ids,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.getInsurancesInGroupBlocking(
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

	async def modify_insurances_in_group_async(self, group_id: str, insurance_batch: list[Insurance]) -> list[Insurance]:
		def do_decode(raw_result):
			return [Insurance._deserialize(x1) for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"insuranceBatch": [x0.__serialize__() for x0 in insurance_batch],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.modifyInsurancesInGroupAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_insurances_in_group_blocking(self, group_id: str, insurance_batch: list[Insurance]) -> list[Insurance]:
		payload = {
			"groupId": group_id,
			"insuranceBatch": [x0.__serialize__() for x0 in insurance_batch],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InsuranceApi.modifyInsurancesInGroupBlocking(
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
