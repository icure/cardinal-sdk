# auto-generated file
import json
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model import EncryptedApplicationSettings
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p


class ApplicationSettingsApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def get_application_settings_async(self) -> list[EncryptedApplicationSettings]:
		def do_decode(raw_result):
			return [EncryptedApplicationSettings._deserialize(x1) for x1 in raw_result]
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ApplicationSettingsApi.getApplicationSettingsAsync,
			self.cardinal_sdk._native,
		)

	def get_application_settings_blocking(self) -> list[EncryptedApplicationSettings]:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ApplicationSettingsApi.getApplicationSettingsBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedApplicationSettings._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def create_application_settings_async(self, application_settings: EncryptedApplicationSettings) -> EncryptedApplicationSettings:
		def do_decode(raw_result):
			return EncryptedApplicationSettings._deserialize(raw_result)
		payload = {
			"applicationSettings": application_settings.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ApplicationSettingsApi.createApplicationSettingsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_application_settings_blocking(self, application_settings: EncryptedApplicationSettings) -> EncryptedApplicationSettings:
		payload = {
			"applicationSettings": application_settings.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ApplicationSettingsApi.createApplicationSettingsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedApplicationSettings._deserialize(result_info.success)
			return return_value

	async def update_application_settings_async(self, application_settings: EncryptedApplicationSettings) -> EncryptedApplicationSettings:
		def do_decode(raw_result):
			return EncryptedApplicationSettings._deserialize(raw_result)
		payload = {
			"applicationSettings": application_settings.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ApplicationSettingsApi.updateApplicationSettingsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def update_application_settings_blocking(self, application_settings: EncryptedApplicationSettings) -> EncryptedApplicationSettings:
		payload = {
			"applicationSettings": application_settings.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ApplicationSettingsApi.updateApplicationSettingsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedApplicationSettings._deserialize(result_info.success)
			return return_value
