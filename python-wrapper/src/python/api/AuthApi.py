# auto-generated file
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p


class AuthApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def get_bearer_token_async(self) -> str:
		def do_decode(raw_result):
			return raw_result
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AuthApi.getBearerTokenAsync,
			self.cardinal_sdk._native,
		)

	def get_bearer_token_blocking(self) -> str:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AuthApi.getBearerTokenBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

	async def get_refresh_token_async(self) -> str:
		def do_decode(raw_result):
			return raw_result
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AuthApi.getRefreshTokenAsync,
			self.cardinal_sdk._native,
		)

	def get_refresh_token_blocking(self) -> str:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AuthApi.getRefreshTokenBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = result_info.success
			return return_value
