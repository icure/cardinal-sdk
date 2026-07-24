# auto-generated file
import json
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.filters.FilterOptions import BaseFilterOptions, BaseSortableFilterOptions
from cardinal_sdk.model import Insurance, Identifier
from typing import Optional


class InsuranceFilters:

	@classmethod
	def all(cls) -> BaseFilterOptions[Insurance]:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.InsuranceFilters.all(
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_identifiers(cls, identifiers: list[Identifier]) -> BaseFilterOptions[Insurance]:
		payload = {
			"identifiers": [x0.__serialize__() for x0 in identifiers],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.InsuranceFilters.byIdentifiers(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_code(cls, code_type: str, code_code: Optional[str] = None) -> BaseSortableFilterOptions[Insurance]:
		payload = {
			"codeType": code_type,
			"codeCode": code_code,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.InsuranceFilters.byCode(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseSortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_tag(cls, tag_type: str, tag_code: Optional[str] = None) -> BaseSortableFilterOptions[Insurance]:
		payload = {
			"tagType": tag_type,
			"tagCode": tag_code,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.InsuranceFilters.byTag(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseSortableFilterOptions(result_info.success)
			return return_value
