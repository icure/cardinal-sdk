# auto-generated file
import json
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.model.specializations import KeypairFingerprintV1String, Pkcs8Bytes
from cardinal_sdk.model import RawDecryptedExchangeData, ExchangeDataInjectionDetails, EntityReferenceInGroup
from typing import Optional


class CryptoApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk
		self.in_group = CryptoApiInGroup(self.cardinal_sdk)

	async def force_reload_async(self) -> None:
		def do_decode(raw_result):
			return raw_result
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CryptoApi.forceReloadAsync,
			self.cardinal_sdk._native,
		)

	def force_reload_blocking(self) -> None:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CryptoApi.forceReloadBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def current_data_owner_keys_async(self, filter_trusted_keys: bool = True) -> dict[str, dict[KeypairFingerprintV1String, Pkcs8Bytes]]:
		def do_decode(raw_result):
			return dict(map(lambda kv1: (kv1[0], dict(map(lambda kv2: (kv2[0], kv2[1]), kv1[1].items()))), raw_result.items()))
		payload = {
			"filterTrustedKeys": filter_trusted_keys,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CryptoApi.currentDataOwnerKeysAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def current_data_owner_keys_blocking(self, filter_trusted_keys: bool = True) -> dict[str, dict[KeypairFingerprintV1String, Pkcs8Bytes]]:
		payload = {
			"filterTrustedKeys": filter_trusted_keys,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CryptoApi.currentDataOwnerKeysBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = dict(map(lambda kv1: (kv1[0], dict(map(lambda kv2: (kv2[0], kv2[1]), kv1[1].items()))), result_info.success.items()))
			return return_value

	async def keyless_create_exchange_data_to_async(self, delegate: str) -> RawDecryptedExchangeData:
		def do_decode(raw_result):
			return RawDecryptedExchangeData._deserialize(raw_result)
		payload = {
			"delegate": delegate,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CryptoApi.keylessCreateExchangeDataToAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def keyless_create_exchange_data_to_blocking(self, delegate: str) -> RawDecryptedExchangeData:
		payload = {
			"delegate": delegate,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CryptoApi.keylessCreateExchangeDataToBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = RawDecryptedExchangeData._deserialize(result_info.success)
			return return_value

	async def inject_exchange_data_async(self, group_id: Optional[str], details: list[ExchangeDataInjectionDetails], re_encrypt_with_own_keys: bool) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"groupId": group_id,
			"details": [x0.__serialize__() for x0 in details],
			"reEncryptWithOwnKeys": re_encrypt_with_own_keys,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CryptoApi.injectExchangeDataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def inject_exchange_data_blocking(self, group_id: Optional[str], details: list[ExchangeDataInjectionDetails], re_encrypt_with_own_keys: bool) -> None:
		payload = {
			"groupId": group_id,
			"details": [x0.__serialize__() for x0 in details],
			"reEncryptWithOwnKeys": re_encrypt_with_own_keys,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CryptoApi.injectExchangeDataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)


class CryptoApiInGroup:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def keyless_create_exchange_data_to_async(self, group_id: Optional[str], delegate: EntityReferenceInGroup) -> RawDecryptedExchangeData:
		def do_decode(raw_result):
			return RawDecryptedExchangeData._deserialize(raw_result)
		payload = {
			"groupId": group_id,
			"delegate": delegate.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CryptoApi.inGroup.keylessCreateExchangeDataToAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def keyless_create_exchange_data_to_blocking(self, group_id: Optional[str], delegate: EntityReferenceInGroup) -> RawDecryptedExchangeData:
		payload = {
			"groupId": group_id,
			"delegate": delegate.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CryptoApi.inGroup.keylessCreateExchangeDataToBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = RawDecryptedExchangeData._deserialize(result_info.success)
			return return_value
