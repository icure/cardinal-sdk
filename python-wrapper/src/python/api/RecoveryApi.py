# auto-generated file
import json
from typing import Optional
from cardinal_sdk.model import RecoveryKeyOptions, serialize_recovery_key_options, RecoveryDataKey, RecoveryKeySize
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p


class RecoveryApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def create_recovery_info_for_available_parent_key_pairs_async(self, parent_id: str, include_ancestor_keys: bool = False, lifetime_seconds: Optional[int] = None, recovery_key_options: Optional[RecoveryKeyOptions] = None) -> RecoveryDataKey:
		def do_decode(raw_result):
			return RecoveryDataKey._deserialize(raw_result)
		payload = {
			"parentId": parent_id,
			"includeAncestorKeys": include_ancestor_keys,
			"lifetimeSeconds": lifetime_seconds,
			"recoveryKeyOptions": serialize_recovery_key_options(recovery_key_options) if recovery_key_options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RecoveryApi.createRecoveryInfoForAvailableParentKeyPairsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_recovery_info_for_available_parent_key_pairs_blocking(self, parent_id: str, include_ancestor_keys: bool = False, lifetime_seconds: Optional[int] = None, recovery_key_options: Optional[RecoveryKeyOptions] = None) -> RecoveryDataKey:
		payload = {
			"parentId": parent_id,
			"includeAncestorKeys": include_ancestor_keys,
			"lifetimeSeconds": lifetime_seconds,
			"recoveryKeyOptions": serialize_recovery_key_options(recovery_key_options) if recovery_key_options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RecoveryApi.createRecoveryInfoForAvailableParentKeyPairsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = RecoveryDataKey._deserialize(result_info.success)
			return return_value

	async def purge_recovery_info_async(self, recovery_key: RecoveryDataKey) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"recoveryKey": recovery_key.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RecoveryApi.purgeRecoveryInfoAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_recovery_info_blocking(self, recovery_key: RecoveryDataKey) -> None:
		payload = {
			"recoveryKey": recovery_key.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RecoveryApi.purgeRecoveryInfoBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_all_recovery_info_for_async(self, data_owner_id: str) -> int:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"dataOwnerId": data_owner_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RecoveryApi.purgeAllRecoveryInfoForAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_all_recovery_info_for_blocking(self, data_owner_id: str) -> int:
		payload = {
			"dataOwnerId": data_owner_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RecoveryApi.purgeAllRecoveryInfoForBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

	async def purge_all_key_pair_recovery_info_for_async(self, data_owner_id: str) -> int:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"dataOwnerId": data_owner_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RecoveryApi.purgeAllKeyPairRecoveryInfoForAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_all_key_pair_recovery_info_for_blocking(self, data_owner_id: str) -> int:
		payload = {
			"dataOwnerId": data_owner_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RecoveryApi.purgeAllKeyPairRecoveryInfoForBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

	async def purge_all_exchange_data_recovery_info_for_async(self, data_owner_id: str) -> int:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"dataOwnerId": data_owner_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RecoveryApi.purgeAllExchangeDataRecoveryInfoForAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_all_exchange_data_recovery_info_for_blocking(self, data_owner_id: str) -> int:
		payload = {
			"dataOwnerId": data_owner_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RecoveryApi.purgeAllExchangeDataRecoveryInfoForBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

	async def pre_generate_recovery_key_async(self, key_size: RecoveryKeySize) -> RecoveryDataKey:
		def do_decode(raw_result):
			return RecoveryDataKey._deserialize(raw_result)
		payload = {
			"keySize": key_size.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RecoveryApi.preGenerateRecoveryKeyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def pre_generate_recovery_key_blocking(self, key_size: RecoveryKeySize) -> RecoveryDataKey:
		payload = {
			"keySize": key_size.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RecoveryApi.preGenerateRecoveryKeyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = RecoveryDataKey._deserialize(result_info.success)
			return return_value
