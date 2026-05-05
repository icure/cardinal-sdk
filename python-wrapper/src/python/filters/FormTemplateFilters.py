# auto-generated file
import json
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.filters.FilterOptions import BaseFilterOptions
from cardinal_sdk.model import FormTemplate


class FormTemplateFilters:

	@classmethod
	def by_specialty_code(cls, specialty_code: str) -> BaseFilterOptions[FormTemplate]:
		payload = {
			"specialtyCode": specialty_code,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.FormTemplateFilters.bySpecialtyCode(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value
