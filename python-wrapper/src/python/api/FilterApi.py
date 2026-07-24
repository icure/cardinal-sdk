# auto-generated file
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model import FilterOptionGroupWithViews
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p


class FilterApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def get_filter_options_definitions_async(self) -> dict[str, list[FilterOptionGroupWithViews]]:
		def do_decode(raw_result):
			return dict(map(lambda kv1: (kv1[0], [FilterOptionGroupWithViews._deserialize(x2) for x2 in kv1[1]]), raw_result.items()))
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FilterApi.getFilterOptionsDefinitionsAsync,
			self.cardinal_sdk._native,
		)

	def get_filter_options_definitions_blocking(self) -> dict[str, list[FilterOptionGroupWithViews]]:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FilterApi.getFilterOptionsDefinitionsBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = dict(map(lambda kv1: (kv1[0], [FilterOptionGroupWithViews._deserialize(x2) for x2 in kv1[1]]), result_info.success.items()))
			return return_value
