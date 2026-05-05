# auto-generated file
import json
from typing import Optional
from cardinal_sdk.model import DecryptedAccessLog, Patient, User, AccessLevel, SecretIdUseOption, SecretIdUseOptionUseAnySharedWithParent, serialize_patient, serialize_secret_id_use_option, AccessLog, serialize_access_log, EntityReferenceInGroup, EncryptedAccessLog, deserialize_access_log, StoredDocumentIdentifier, AccessLogShareOptions, GroupScoped
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.model.specializations import HexString
from cardinal_sdk.filters.FilterOptions import FilterOptions, SortableFilterOptions
from cardinal_sdk.pagination.PaginatedListIterator import PaginatedListIterator


class AccessLogApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk
		self.encrypted = AccessLogApiEncrypted(self.cardinal_sdk)
		self.try_and_recover = AccessLogApiTryAndRecover(self.cardinal_sdk)
		self.in_group = AccessLogApiInGroup(self.cardinal_sdk)

	async def with_encryption_metadata_async(self, base: Optional[DecryptedAccessLog], patient: Patient, user: Optional[User] = None, delegates: dict[str, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent(), alternate_root_delegate_id: Optional[str] = None) -> DecryptedAccessLog:
		def do_decode(raw_result):
			return DecryptedAccessLog._deserialize(raw_result)
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient),
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": serialize_secret_id_use_option(secret_id),
			"alternateRootDelegateId": alternate_root_delegate_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.withEncryptionMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def with_encryption_metadata_blocking(self, base: Optional[DecryptedAccessLog], patient: Patient, user: Optional[User] = None, delegates: dict[str, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent(), alternate_root_delegate_id: Optional[str] = None) -> DecryptedAccessLog:
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient),
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": serialize_secret_id_use_option(secret_id),
			"alternateRootDelegateId": alternate_root_delegate_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.withEncryptionMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedAccessLog._deserialize(result_info.success)
			return return_value

	async def get_encryption_keys_of_async(self, access_log: AccessLog) -> set[HexString]:
		def do_decode(raw_result):
			return {x1 for x1 in raw_result}
		payload = {
			"accessLog": serialize_access_log(access_log),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.getEncryptionKeysOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_encryption_keys_of_blocking(self, access_log: AccessLog) -> set[HexString]:
		payload = {
			"accessLog": serialize_access_log(access_log),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.getEncryptionKeysOfBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = {x1 for x1 in result_info.success}
			return return_value

	async def has_write_access_async(self, access_log: AccessLog) -> bool:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"accessLog": serialize_access_log(access_log),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.hasWriteAccessAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def has_write_access_blocking(self, access_log: AccessLog) -> bool:
		payload = {
			"accessLog": serialize_access_log(access_log),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.hasWriteAccessBlocking(
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

	async def decrypt_patient_id_of_async(self, access_log: AccessLog) -> set[EntityReferenceInGroup]:
		def do_decode(raw_result):
			return {EntityReferenceInGroup._deserialize(x1) for x1 in raw_result}
		payload = {
			"accessLog": serialize_access_log(access_log),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.decryptPatientIdOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_patient_id_of_blocking(self, access_log: AccessLog) -> set[EntityReferenceInGroup]:
		payload = {
			"accessLog": serialize_access_log(access_log),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.decryptPatientIdOfBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = {EntityReferenceInGroup._deserialize(x1) for x1 in result_info.success}
			return return_value

	async def create_delegation_de_anonymization_metadata_async(self, entity: AccessLog, delegates: set[str]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"entity": serialize_access_log(entity),
			"delegates": [x0 for x0 in delegates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.createDelegationDeAnonymizationMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_delegation_de_anonymization_metadata_blocking(self, entity: AccessLog, delegates: set[str]) -> None:
		payload = {
			"entity": serialize_access_log(entity),
			"delegates": [x0 for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.createDelegationDeAnonymizationMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def decrypt_async(self, access_log: EncryptedAccessLog) -> DecryptedAccessLog:
		def do_decode(raw_result):
			return DecryptedAccessLog._deserialize(raw_result)
		payload = {
			"accessLog": access_log.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.decryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_blocking(self, access_log: EncryptedAccessLog) -> DecryptedAccessLog:
		payload = {
			"accessLog": access_log.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.decryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedAccessLog._deserialize(result_info.success)
			return return_value

	async def try_decrypt_async(self, access_log: EncryptedAccessLog) -> AccessLog:
		def do_decode(raw_result):
			return deserialize_access_log(raw_result)
		payload = {
			"accessLog": access_log.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryDecryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def try_decrypt_blocking(self, access_log: EncryptedAccessLog) -> AccessLog:
		payload = {
			"accessLog": access_log.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryDecryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_access_log(result_info.success)
			return return_value

	async def match_access_logs_by_async(self, filter: FilterOptions[AccessLog]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.matchAccessLogsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_access_logs_by_blocking(self, filter: FilterOptions[AccessLog]) -> list[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.matchAccessLogsByBlocking(
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

	async def match_access_logs_by_sorted_async(self, filter: SortableFilterOptions[AccessLog]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.matchAccessLogsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_access_logs_by_sorted_blocking(self, filter: SortableFilterOptions[AccessLog]) -> list[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.matchAccessLogsBySortedBlocking(
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

	async def delete_access_log_by_id_async(self, entity_id: str, rev: str) -> StoredDocumentIdentifier:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.deleteAccessLogByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_access_log_by_id_blocking(self, entity_id: str, rev: str) -> StoredDocumentIdentifier:
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.deleteAccessLogByIdBlocking(
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

	async def delete_access_logs_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.deleteAccessLogsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_access_logs_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.deleteAccessLogsByIdsBlocking(
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

	async def purge_access_log_by_id_async(self, id: str, rev: str) -> None:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.purgeAccessLogByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_access_log_by_id_blocking(self, id: str, rev: str) -> None:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.purgeAccessLogByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_access_logs_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.purgeAccessLogsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_access_logs_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.purgeAccessLogsByIdsBlocking(
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

	async def delete_access_log_async(self, access_log: AccessLog) -> StoredDocumentIdentifier:
		def do_decode(raw_result):
			return StoredDocumentIdentifier._deserialize(raw_result)
		payload = {
			"accessLog": serialize_access_log(access_log),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.deleteAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_access_log_blocking(self, access_log: AccessLog) -> StoredDocumentIdentifier:
		payload = {
			"accessLog": serialize_access_log(access_log),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.deleteAccessLogBlocking(
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

	async def delete_access_logs_async(self, access_logs: list[AccessLog]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"accessLogs": [serialize_access_log(x0) for x0 in access_logs],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.deleteAccessLogsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_access_logs_blocking(self, access_logs: list[AccessLog]) -> list[StoredDocumentIdentifier]:
		payload = {
			"accessLogs": [serialize_access_log(x0) for x0 in access_logs],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.deleteAccessLogsBlocking(
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

	async def purge_access_log_async(self, access_log: AccessLog) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"accessLog": serialize_access_log(access_log),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.purgeAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_access_log_blocking(self, access_log: AccessLog) -> None:
		payload = {
			"accessLog": serialize_access_log(access_log),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.purgeAccessLogBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_access_logs_async(self, access_logs: list[AccessLog]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"accessLogs": [serialize_access_log(x0) for x0 in access_logs],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.purgeAccessLogsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_access_logs_blocking(self, access_logs: list[AccessLog]) -> list[StoredDocumentIdentifier]:
		payload = {
			"accessLogs": [serialize_access_log(x0) for x0 in access_logs],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.purgeAccessLogsBlocking(
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

	async def share_with_async(self, delegate_id: str, access_log: DecryptedAccessLog, options: Optional[AccessLogShareOptions] = None) -> DecryptedAccessLog:
		def do_decode(raw_result):
			return DecryptedAccessLog._deserialize(raw_result)
		payload = {
			"delegateId": delegate_id,
			"accessLog": access_log.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, access_log: DecryptedAccessLog, options: Optional[AccessLogShareOptions] = None) -> DecryptedAccessLog:
		payload = {
			"delegateId": delegate_id,
			"accessLog": access_log.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedAccessLog._deserialize(result_info.success)
			return return_value

	async def share_with_many_async(self, access_log: DecryptedAccessLog, delegates: dict[str, AccessLogShareOptions]) -> DecryptedAccessLog:
		def do_decode(raw_result):
			return DecryptedAccessLog._deserialize(raw_result)
		payload = {
			"accessLog": access_log.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, access_log: DecryptedAccessLog, delegates: dict[str, AccessLogShareOptions]) -> DecryptedAccessLog:
		payload = {
			"accessLog": access_log.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedAccessLog._deserialize(result_info.success)
			return return_value

	async def filter_access_logs_by_async(self, filter: FilterOptions[AccessLog]) -> PaginatedListIterator[DecryptedAccessLog]:
		def do_decode(raw_result):
			return PaginatedListIterator[DecryptedAccessLog](
				producer = raw_result,
				deserializer = lambda x: DecryptedAccessLog._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.filterAccessLogsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_access_logs_by_blocking(self, filter: FilterOptions[AccessLog]) -> PaginatedListIterator[DecryptedAccessLog]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.filterAccessLogsByBlocking(
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
			return PaginatedListIterator[DecryptedAccessLog](
				producer = class_pointer,
				deserializer = lambda x: DecryptedAccessLog._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_access_logs_by_sorted_async(self, filter: SortableFilterOptions[AccessLog]) -> PaginatedListIterator[DecryptedAccessLog]:
		def do_decode(raw_result):
			return PaginatedListIterator[DecryptedAccessLog](
				producer = raw_result,
				deserializer = lambda x: DecryptedAccessLog._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.filterAccessLogsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_access_logs_by_sorted_blocking(self, filter: SortableFilterOptions[AccessLog]) -> PaginatedListIterator[DecryptedAccessLog]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.filterAccessLogsBySortedBlocking(
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
			return PaginatedListIterator[DecryptedAccessLog](
				producer = class_pointer,
				deserializer = lambda x: DecryptedAccessLog._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def create_access_log_async(self, entity: DecryptedAccessLog) -> DecryptedAccessLog:
		def do_decode(raw_result):
			return DecryptedAccessLog._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.createAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_access_log_blocking(self, entity: DecryptedAccessLog) -> DecryptedAccessLog:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.createAccessLogBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedAccessLog._deserialize(result_info.success)
			return return_value

	async def create_access_logs_async(self, entities: list[DecryptedAccessLog]) -> list[DecryptedAccessLog]:
		def do_decode(raw_result):
			return [DecryptedAccessLog._deserialize(x1) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.createAccessLogsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_access_logs_blocking(self, entities: list[DecryptedAccessLog]) -> list[DecryptedAccessLog]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.createAccessLogsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedAccessLog._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def undelete_access_log_by_id_async(self, id: str, rev: str) -> DecryptedAccessLog:
		def do_decode(raw_result):
			return DecryptedAccessLog._deserialize(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.undeleteAccessLogByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_access_log_by_id_blocking(self, id: str, rev: str) -> DecryptedAccessLog:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.undeleteAccessLogByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedAccessLog._deserialize(result_info.success)
			return return_value

	async def undelete_access_logs_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[DecryptedAccessLog]:
		def do_decode(raw_result):
			return [DecryptedAccessLog._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.undeleteAccessLogsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_access_logs_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[DecryptedAccessLog]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.undeleteAccessLogsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedAccessLog._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def undelete_access_log_async(self, access_log: AccessLog) -> DecryptedAccessLog:
		def do_decode(raw_result):
			return DecryptedAccessLog._deserialize(raw_result)
		payload = {
			"accessLog": serialize_access_log(access_log),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.undeleteAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_access_log_blocking(self, access_log: AccessLog) -> DecryptedAccessLog:
		payload = {
			"accessLog": serialize_access_log(access_log),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.undeleteAccessLogBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedAccessLog._deserialize(result_info.success)
			return return_value

	async def undelete_access_logs_async(self, access_logs: list[AccessLog]) -> list[DecryptedAccessLog]:
		def do_decode(raw_result):
			return [DecryptedAccessLog._deserialize(x1) for x1 in raw_result]
		payload = {
			"accessLogs": [serialize_access_log(x0) for x0 in access_logs],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.undeleteAccessLogsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_access_logs_blocking(self, access_logs: list[AccessLog]) -> list[DecryptedAccessLog]:
		payload = {
			"accessLogs": [serialize_access_log(x0) for x0 in access_logs],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.undeleteAccessLogsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedAccessLog._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def modify_access_log_async(self, entity: DecryptedAccessLog) -> DecryptedAccessLog:
		def do_decode(raw_result):
			return DecryptedAccessLog._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.modifyAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_access_log_blocking(self, entity: DecryptedAccessLog) -> DecryptedAccessLog:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.modifyAccessLogBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedAccessLog._deserialize(result_info.success)
			return return_value

	async def modify_access_logs_async(self, entities: list[DecryptedAccessLog]) -> list[DecryptedAccessLog]:
		def do_decode(raw_result):
			return [DecryptedAccessLog._deserialize(x1) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.modifyAccessLogsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_access_logs_blocking(self, entities: list[DecryptedAccessLog]) -> list[DecryptedAccessLog]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.modifyAccessLogsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedAccessLog._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_access_log_async(self, entity_id: str) -> Optional[DecryptedAccessLog]:
		def do_decode(raw_result):
			return DecryptedAccessLog._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.getAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_access_log_blocking(self, entity_id: str) -> Optional[DecryptedAccessLog]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.getAccessLogBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedAccessLog._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_access_logs_async(self, entity_ids: list[str]) -> list[DecryptedAccessLog]:
		def do_decode(raw_result):
			return [DecryptedAccessLog._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.getAccessLogsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_access_logs_blocking(self, entity_ids: list[str]) -> list[DecryptedAccessLog]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.getAccessLogsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedAccessLog._deserialize(x1) for x1 in result_info.success]
			return return_value


class AccessLogApiEncrypted:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate_id: str, access_log: EncryptedAccessLog, options: Optional[AccessLogShareOptions] = None) -> EncryptedAccessLog:
		def do_decode(raw_result):
			return EncryptedAccessLog._deserialize(raw_result)
		payload = {
			"delegateId": delegate_id,
			"accessLog": access_log.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, access_log: EncryptedAccessLog, options: Optional[AccessLogShareOptions] = None) -> EncryptedAccessLog:
		payload = {
			"delegateId": delegate_id,
			"accessLog": access_log.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedAccessLog._deserialize(result_info.success)
			return return_value

	async def share_with_many_async(self, access_log: EncryptedAccessLog, delegates: dict[str, AccessLogShareOptions]) -> EncryptedAccessLog:
		def do_decode(raw_result):
			return EncryptedAccessLog._deserialize(raw_result)
		payload = {
			"accessLog": access_log.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, access_log: EncryptedAccessLog, delegates: dict[str, AccessLogShareOptions]) -> EncryptedAccessLog:
		payload = {
			"accessLog": access_log.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedAccessLog._deserialize(result_info.success)
			return return_value

	async def filter_access_logs_by_async(self, filter: FilterOptions[AccessLog]) -> PaginatedListIterator[EncryptedAccessLog]:
		def do_decode(raw_result):
			return PaginatedListIterator[EncryptedAccessLog](
				producer = raw_result,
				deserializer = lambda x: EncryptedAccessLog._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.filterAccessLogsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_access_logs_by_blocking(self, filter: FilterOptions[AccessLog]) -> PaginatedListIterator[EncryptedAccessLog]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.filterAccessLogsByBlocking(
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
			return PaginatedListIterator[EncryptedAccessLog](
				producer = class_pointer,
				deserializer = lambda x: EncryptedAccessLog._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_access_logs_by_sorted_async(self, filter: SortableFilterOptions[AccessLog]) -> PaginatedListIterator[EncryptedAccessLog]:
		def do_decode(raw_result):
			return PaginatedListIterator[EncryptedAccessLog](
				producer = raw_result,
				deserializer = lambda x: EncryptedAccessLog._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.filterAccessLogsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_access_logs_by_sorted_blocking(self, filter: SortableFilterOptions[AccessLog]) -> PaginatedListIterator[EncryptedAccessLog]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.filterAccessLogsBySortedBlocking(
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
			return PaginatedListIterator[EncryptedAccessLog](
				producer = class_pointer,
				deserializer = lambda x: EncryptedAccessLog._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def create_access_log_async(self, entity: EncryptedAccessLog) -> EncryptedAccessLog:
		def do_decode(raw_result):
			return EncryptedAccessLog._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.createAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_access_log_blocking(self, entity: EncryptedAccessLog) -> EncryptedAccessLog:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.createAccessLogBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedAccessLog._deserialize(result_info.success)
			return return_value

	async def create_access_logs_async(self, entities: list[EncryptedAccessLog]) -> list[EncryptedAccessLog]:
		def do_decode(raw_result):
			return [EncryptedAccessLog._deserialize(x1) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.createAccessLogsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_access_logs_blocking(self, entities: list[EncryptedAccessLog]) -> list[EncryptedAccessLog]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.createAccessLogsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedAccessLog._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def undelete_access_log_by_id_async(self, id: str, rev: str) -> EncryptedAccessLog:
		def do_decode(raw_result):
			return EncryptedAccessLog._deserialize(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.undeleteAccessLogByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_access_log_by_id_blocking(self, id: str, rev: str) -> EncryptedAccessLog:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.undeleteAccessLogByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedAccessLog._deserialize(result_info.success)
			return return_value

	async def undelete_access_logs_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[EncryptedAccessLog]:
		def do_decode(raw_result):
			return [EncryptedAccessLog._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.undeleteAccessLogsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_access_logs_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[EncryptedAccessLog]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.undeleteAccessLogsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedAccessLog._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def undelete_access_log_async(self, access_log: AccessLog) -> EncryptedAccessLog:
		def do_decode(raw_result):
			return EncryptedAccessLog._deserialize(raw_result)
		payload = {
			"accessLog": serialize_access_log(access_log),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.undeleteAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_access_log_blocking(self, access_log: AccessLog) -> EncryptedAccessLog:
		payload = {
			"accessLog": serialize_access_log(access_log),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.undeleteAccessLogBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedAccessLog._deserialize(result_info.success)
			return return_value

	async def undelete_access_logs_async(self, access_logs: list[AccessLog]) -> list[EncryptedAccessLog]:
		def do_decode(raw_result):
			return [EncryptedAccessLog._deserialize(x1) for x1 in raw_result]
		payload = {
			"accessLogs": [serialize_access_log(x0) for x0 in access_logs],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.undeleteAccessLogsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_access_logs_blocking(self, access_logs: list[AccessLog]) -> list[EncryptedAccessLog]:
		payload = {
			"accessLogs": [serialize_access_log(x0) for x0 in access_logs],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.undeleteAccessLogsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedAccessLog._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def modify_access_log_async(self, entity: EncryptedAccessLog) -> EncryptedAccessLog:
		def do_decode(raw_result):
			return EncryptedAccessLog._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.modifyAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_access_log_blocking(self, entity: EncryptedAccessLog) -> EncryptedAccessLog:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.modifyAccessLogBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedAccessLog._deserialize(result_info.success)
			return return_value

	async def modify_access_logs_async(self, entities: list[EncryptedAccessLog]) -> list[EncryptedAccessLog]:
		def do_decode(raw_result):
			return [EncryptedAccessLog._deserialize(x1) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.modifyAccessLogsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_access_logs_blocking(self, entities: list[EncryptedAccessLog]) -> list[EncryptedAccessLog]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.modifyAccessLogsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedAccessLog._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_access_log_async(self, entity_id: str) -> Optional[EncryptedAccessLog]:
		def do_decode(raw_result):
			return EncryptedAccessLog._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.getAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_access_log_blocking(self, entity_id: str) -> Optional[EncryptedAccessLog]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.getAccessLogBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedAccessLog._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_access_logs_async(self, entity_ids: list[str]) -> list[EncryptedAccessLog]:
		def do_decode(raw_result):
			return [EncryptedAccessLog._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.getAccessLogsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_access_logs_blocking(self, entity_ids: list[str]) -> list[EncryptedAccessLog]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.getAccessLogsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedAccessLog._deserialize(x1) for x1 in result_info.success]
			return return_value


class AccessLogApiTryAndRecover:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate_id: str, access_log: AccessLog, options: Optional[AccessLogShareOptions] = None) -> AccessLog:
		def do_decode(raw_result):
			return deserialize_access_log(raw_result)
		payload = {
			"delegateId": delegate_id,
			"accessLog": serialize_access_log(access_log),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, access_log: AccessLog, options: Optional[AccessLogShareOptions] = None) -> AccessLog:
		payload = {
			"delegateId": delegate_id,
			"accessLog": serialize_access_log(access_log),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_access_log(result_info.success)
			return return_value

	async def share_with_many_async(self, access_log: AccessLog, delegates: dict[str, AccessLogShareOptions]) -> AccessLog:
		def do_decode(raw_result):
			return deserialize_access_log(raw_result)
		payload = {
			"accessLog": serialize_access_log(access_log),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, access_log: AccessLog, delegates: dict[str, AccessLogShareOptions]) -> AccessLog:
		payload = {
			"accessLog": serialize_access_log(access_log),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_access_log(result_info.success)
			return return_value

	async def filter_access_logs_by_async(self, filter: FilterOptions[AccessLog]) -> PaginatedListIterator[AccessLog]:
		def do_decode(raw_result):
			return PaginatedListIterator[AccessLog](
				producer = raw_result,
				deserializer = lambda x: deserialize_access_log(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.filterAccessLogsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_access_logs_by_blocking(self, filter: FilterOptions[AccessLog]) -> PaginatedListIterator[AccessLog]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.filterAccessLogsByBlocking(
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
			return PaginatedListIterator[AccessLog](
				producer = class_pointer,
				deserializer = lambda x: deserialize_access_log(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_access_logs_by_sorted_async(self, filter: SortableFilterOptions[AccessLog]) -> PaginatedListIterator[AccessLog]:
		def do_decode(raw_result):
			return PaginatedListIterator[AccessLog](
				producer = raw_result,
				deserializer = lambda x: deserialize_access_log(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.filterAccessLogsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_access_logs_by_sorted_blocking(self, filter: SortableFilterOptions[AccessLog]) -> PaginatedListIterator[AccessLog]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.filterAccessLogsBySortedBlocking(
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
			return PaginatedListIterator[AccessLog](
				producer = class_pointer,
				deserializer = lambda x: deserialize_access_log(x),
				executor = self.cardinal_sdk._executor
			)

	async def create_access_log_async(self, entity: AccessLog) -> AccessLog:
		def do_decode(raw_result):
			return deserialize_access_log(raw_result)
		payload = {
			"entity": serialize_access_log(entity),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.createAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_access_log_blocking(self, entity: AccessLog) -> AccessLog:
		payload = {
			"entity": serialize_access_log(entity),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.createAccessLogBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_access_log(result_info.success)
			return return_value

	async def create_access_logs_async(self, entities: list[AccessLog]) -> list[AccessLog]:
		def do_decode(raw_result):
			return [deserialize_access_log(x1) for x1 in raw_result]
		payload = {
			"entities": [serialize_access_log(x0) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.createAccessLogsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_access_logs_blocking(self, entities: list[AccessLog]) -> list[AccessLog]:
		payload = {
			"entities": [serialize_access_log(x0) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.createAccessLogsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_access_log(x1) for x1 in result_info.success]
			return return_value

	async def undelete_access_log_by_id_async(self, id: str, rev: str) -> AccessLog:
		def do_decode(raw_result):
			return deserialize_access_log(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.undeleteAccessLogByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_access_log_by_id_blocking(self, id: str, rev: str) -> AccessLog:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.undeleteAccessLogByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_access_log(result_info.success)
			return return_value

	async def undelete_access_logs_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[AccessLog]:
		def do_decode(raw_result):
			return [deserialize_access_log(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.undeleteAccessLogsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_access_logs_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[AccessLog]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.undeleteAccessLogsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_access_log(x1) for x1 in result_info.success]
			return return_value

	async def undelete_access_log_async(self, access_log: AccessLog) -> AccessLog:
		def do_decode(raw_result):
			return deserialize_access_log(raw_result)
		payload = {
			"accessLog": serialize_access_log(access_log),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.undeleteAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_access_log_blocking(self, access_log: AccessLog) -> AccessLog:
		payload = {
			"accessLog": serialize_access_log(access_log),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.undeleteAccessLogBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_access_log(result_info.success)
			return return_value

	async def undelete_access_logs_async(self, access_logs: list[AccessLog]) -> list[AccessLog]:
		def do_decode(raw_result):
			return [deserialize_access_log(x1) for x1 in raw_result]
		payload = {
			"accessLogs": [serialize_access_log(x0) for x0 in access_logs],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.undeleteAccessLogsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_access_logs_blocking(self, access_logs: list[AccessLog]) -> list[AccessLog]:
		payload = {
			"accessLogs": [serialize_access_log(x0) for x0 in access_logs],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.undeleteAccessLogsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_access_log(x1) for x1 in result_info.success]
			return return_value

	async def modify_access_log_async(self, entity: AccessLog) -> AccessLog:
		def do_decode(raw_result):
			return deserialize_access_log(raw_result)
		payload = {
			"entity": serialize_access_log(entity),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.modifyAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_access_log_blocking(self, entity: AccessLog) -> AccessLog:
		payload = {
			"entity": serialize_access_log(entity),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.modifyAccessLogBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_access_log(result_info.success)
			return return_value

	async def modify_access_logs_async(self, entities: list[AccessLog]) -> list[AccessLog]:
		def do_decode(raw_result):
			return [deserialize_access_log(x1) for x1 in raw_result]
		payload = {
			"entities": [serialize_access_log(x0) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.modifyAccessLogsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_access_logs_blocking(self, entities: list[AccessLog]) -> list[AccessLog]:
		payload = {
			"entities": [serialize_access_log(x0) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.modifyAccessLogsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_access_log(x1) for x1 in result_info.success]
			return return_value

	async def get_access_log_async(self, entity_id: str) -> Optional[AccessLog]:
		def do_decode(raw_result):
			return deserialize_access_log(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.getAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_access_log_blocking(self, entity_id: str) -> Optional[AccessLog]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.getAccessLogBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_access_log(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_access_logs_async(self, entity_ids: list[str]) -> list[AccessLog]:
		def do_decode(raw_result):
			return [deserialize_access_log(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.getAccessLogsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_access_logs_blocking(self, entity_ids: list[str]) -> list[AccessLog]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.getAccessLogsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_access_log(x1) for x1 in result_info.success]
			return return_value


class AccessLogApiInGroup:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk
		self.encrypted = AccessLogApiInGroupEncrypted(self.cardinal_sdk)
		self.try_and_recover = AccessLogApiInGroupTryAndRecover(self.cardinal_sdk)

	async def with_encryption_metadata_async(self, entity_group_id: str, base: Optional[DecryptedAccessLog], patient: GroupScoped[Patient], user: Optional[User] = None, delegates: dict[EntityReferenceInGroup, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent(), alternate_root_delegate_reference: Optional[EntityReferenceInGroup] = None) -> GroupScoped[DecryptedAccessLog]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedAccessLog._deserialize(x1))
		payload = {
			"entityGroupId": entity_group_id,
			"base": base.__serialize__() if base is not None else None,
			"patient": patient.__serialize__(lambda x0: serialize_patient(x0)),
			"user": user.__serialize__() if user is not None else None,
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
			"secretId": serialize_secret_id_use_option(secret_id),
			"alternateRootDelegateReference": alternate_root_delegate_reference.__serialize__() if alternate_root_delegate_reference is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.withEncryptionMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def with_encryption_metadata_blocking(self, entity_group_id: str, base: Optional[DecryptedAccessLog], patient: GroupScoped[Patient], user: Optional[User] = None, delegates: dict[EntityReferenceInGroup, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent(), alternate_root_delegate_reference: Optional[EntityReferenceInGroup] = None) -> GroupScoped[DecryptedAccessLog]:
		payload = {
			"entityGroupId": entity_group_id,
			"base": base.__serialize__() if base is not None else None,
			"patient": patient.__serialize__(lambda x0: serialize_patient(x0)),
			"user": user.__serialize__() if user is not None else None,
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
			"secretId": serialize_secret_id_use_option(secret_id),
			"alternateRootDelegateReference": alternate_root_delegate_reference.__serialize__() if alternate_root_delegate_reference is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.withEncryptionMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedAccessLog._deserialize(x1))
			return return_value

	async def get_encryption_keys_of_async(self, access_log: GroupScoped[AccessLog]) -> set[HexString]:
		def do_decode(raw_result):
			return {x1 for x1 in raw_result}
		payload = {
			"accessLog": access_log.__serialize__(lambda x0: serialize_access_log(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.getEncryptionKeysOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_encryption_keys_of_blocking(self, access_log: GroupScoped[AccessLog]) -> set[HexString]:
		payload = {
			"accessLog": access_log.__serialize__(lambda x0: serialize_access_log(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.getEncryptionKeysOfBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = {x1 for x1 in result_info.success}
			return return_value

	async def has_write_access_async(self, access_log: GroupScoped[AccessLog]) -> bool:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"accessLog": access_log.__serialize__(lambda x0: serialize_access_log(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.hasWriteAccessAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def has_write_access_blocking(self, access_log: GroupScoped[AccessLog]) -> bool:
		payload = {
			"accessLog": access_log.__serialize__(lambda x0: serialize_access_log(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.hasWriteAccessBlocking(
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

	async def decrypt_patient_id_of_async(self, access_log: GroupScoped[AccessLog]) -> set[EntityReferenceInGroup]:
		def do_decode(raw_result):
			return {EntityReferenceInGroup._deserialize(x1) for x1 in raw_result}
		payload = {
			"accessLog": access_log.__serialize__(lambda x0: serialize_access_log(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.decryptPatientIdOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_patient_id_of_blocking(self, access_log: GroupScoped[AccessLog]) -> set[EntityReferenceInGroup]:
		payload = {
			"accessLog": access_log.__serialize__(lambda x0: serialize_access_log(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.decryptPatientIdOfBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = {EntityReferenceInGroup._deserialize(x1) for x1 in result_info.success}
			return return_value

	async def create_delegation_de_anonymization_metadata_async(self, entity: GroupScoped[AccessLog], delegates: set[EntityReferenceInGroup]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_access_log(x0)),
			"delegates": [x0.__serialize__() for x0 in delegates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.createDelegationDeAnonymizationMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_delegation_de_anonymization_metadata_blocking(self, entity: GroupScoped[AccessLog], delegates: set[EntityReferenceInGroup]) -> None:
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_access_log(x0)),
			"delegates": [x0.__serialize__() for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.createDelegationDeAnonymizationMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def decrypt_async(self, access_logs: list[GroupScoped[EncryptedAccessLog]]) -> list[GroupScoped[DecryptedAccessLog]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: DecryptedAccessLog._deserialize(x2)) for x1 in raw_result]
		payload = {
			"accessLogs": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in access_logs],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.decryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_blocking(self, access_logs: list[GroupScoped[EncryptedAccessLog]]) -> list[GroupScoped[DecryptedAccessLog]]:
		payload = {
			"accessLogs": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in access_logs],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.decryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: DecryptedAccessLog._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def try_decrypt_async(self, access_logs: list[GroupScoped[EncryptedAccessLog]]) -> list[GroupScoped[AccessLog]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: deserialize_access_log(x2)) for x1 in raw_result]
		payload = {
			"accessLogs": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in access_logs],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.tryDecryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def try_decrypt_blocking(self, access_logs: list[GroupScoped[EncryptedAccessLog]]) -> list[GroupScoped[AccessLog]]:
		payload = {
			"accessLogs": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in access_logs],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.tryDecryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: deserialize_access_log(x2)) for x1 in result_info.success]
			return return_value

	async def match_access_logs_by_async(self, group_id: str, filter: FilterOptions[AccessLog]) -> list[str]:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.matchAccessLogsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_access_logs_by_blocking(self, group_id: str, filter: FilterOptions[AccessLog]) -> list[str]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.matchAccessLogsByBlocking(
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

	async def match_access_logs_by_sorted_async(self, group_id: str, filter: SortableFilterOptions[AccessLog]) -> list[str]:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.matchAccessLogsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_access_logs_by_sorted_blocking(self, group_id: str, filter: SortableFilterOptions[AccessLog]) -> list[str]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.matchAccessLogsBySortedBlocking(
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

	async def delete_access_log_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: StoredDocumentIdentifier._deserialize(x1))
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.deleteAccessLogByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_access_log_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[StoredDocumentIdentifier]:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.deleteAccessLogByIdBlocking(
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

	async def delete_access_logs_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.deleteAccessLogsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_access_logs_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.deleteAccessLogsByIdsBlocking(
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

	async def purge_access_log_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.purgeAccessLogByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_access_log_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> None:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.purgeAccessLogByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_access_logs_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.purgeAccessLogsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_access_logs_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.purgeAccessLogsByIdsBlocking(
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

	async def delete_access_log_async(self, access_log: GroupScoped[AccessLog]) -> GroupScoped[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: StoredDocumentIdentifier._deserialize(x1))
		payload = {
			"accessLog": access_log.__serialize__(lambda x0: serialize_access_log(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.deleteAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_access_log_blocking(self, access_log: GroupScoped[AccessLog]) -> GroupScoped[StoredDocumentIdentifier]:
		payload = {
			"accessLog": access_log.__serialize__(lambda x0: serialize_access_log(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.deleteAccessLogBlocking(
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

	async def delete_access_logs_async(self, access_logs: list[GroupScoped[AccessLog]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"accessLogs": [x0.__serialize__(lambda x1: serialize_access_log(x1)) for x0 in access_logs],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.deleteAccessLogsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_access_logs_blocking(self, access_logs: list[GroupScoped[AccessLog]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"accessLogs": [x0.__serialize__(lambda x1: serialize_access_log(x1)) for x0 in access_logs],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.deleteAccessLogsBlocking(
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

	async def purge_access_log_async(self, access_log: GroupScoped[AccessLog]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"accessLog": access_log.__serialize__(lambda x0: serialize_access_log(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.purgeAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_access_log_blocking(self, access_log: GroupScoped[AccessLog]) -> None:
		payload = {
			"accessLog": access_log.__serialize__(lambda x0: serialize_access_log(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.purgeAccessLogBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_access_logs_async(self, access_logs: list[GroupScoped[AccessLog]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"accessLogs": [x0.__serialize__(lambda x1: serialize_access_log(x1)) for x0 in access_logs],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.purgeAccessLogsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_access_logs_blocking(self, access_logs: list[GroupScoped[AccessLog]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"accessLogs": [x0.__serialize__(lambda x1: serialize_access_log(x1)) for x0 in access_logs],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.purgeAccessLogsBlocking(
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

	async def create_access_log_async(self, entity: GroupScoped[DecryptedAccessLog]) -> GroupScoped[DecryptedAccessLog]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedAccessLog._deserialize(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.createAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_access_log_blocking(self, entity: GroupScoped[DecryptedAccessLog]) -> GroupScoped[DecryptedAccessLog]:
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.createAccessLogBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedAccessLog._deserialize(x1))
			return return_value

	async def create_access_logs_async(self, entities: list[GroupScoped[DecryptedAccessLog]]) -> list[GroupScoped[DecryptedAccessLog]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: DecryptedAccessLog._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.createAccessLogsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_access_logs_blocking(self, entities: list[GroupScoped[DecryptedAccessLog]]) -> list[GroupScoped[DecryptedAccessLog]]:
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.createAccessLogsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: DecryptedAccessLog._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def undelete_access_log_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[DecryptedAccessLog]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedAccessLog._deserialize(x1))
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.undeleteAccessLogByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_access_log_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[DecryptedAccessLog]:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.undeleteAccessLogByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedAccessLog._deserialize(x1))
			return return_value

	async def undelete_access_logs_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[DecryptedAccessLog]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: DecryptedAccessLog._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.undeleteAccessLogsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_access_logs_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[DecryptedAccessLog]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.undeleteAccessLogsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: DecryptedAccessLog._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def undelete_access_log_async(self, access_log: GroupScoped[AccessLog]) -> GroupScoped[DecryptedAccessLog]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedAccessLog._deserialize(x1))
		payload = {
			"accessLog": access_log.__serialize__(lambda x0: serialize_access_log(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.undeleteAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_access_log_blocking(self, access_log: GroupScoped[AccessLog]) -> GroupScoped[DecryptedAccessLog]:
		payload = {
			"accessLog": access_log.__serialize__(lambda x0: serialize_access_log(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.undeleteAccessLogBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedAccessLog._deserialize(x1))
			return return_value

	async def undelete_access_logs_async(self, access_logs: list[GroupScoped[AccessLog]]) -> list[GroupScoped[DecryptedAccessLog]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: DecryptedAccessLog._deserialize(x2)) for x1 in raw_result]
		payload = {
			"accessLogs": [x0.__serialize__(lambda x1: serialize_access_log(x1)) for x0 in access_logs],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.undeleteAccessLogsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_access_logs_blocking(self, access_logs: list[GroupScoped[AccessLog]]) -> list[GroupScoped[DecryptedAccessLog]]:
		payload = {
			"accessLogs": [x0.__serialize__(lambda x1: serialize_access_log(x1)) for x0 in access_logs],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.undeleteAccessLogsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: DecryptedAccessLog._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def modify_access_log_async(self, entity: GroupScoped[DecryptedAccessLog]) -> GroupScoped[DecryptedAccessLog]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedAccessLog._deserialize(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.modifyAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_access_log_blocking(self, entity: GroupScoped[DecryptedAccessLog]) -> GroupScoped[DecryptedAccessLog]:
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.modifyAccessLogBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedAccessLog._deserialize(x1))
			return return_value

	async def modify_access_logs_async(self, entities: list[GroupScoped[DecryptedAccessLog]]) -> list[GroupScoped[DecryptedAccessLog]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: DecryptedAccessLog._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.modifyAccessLogsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_access_logs_blocking(self, entities: list[GroupScoped[DecryptedAccessLog]]) -> list[GroupScoped[DecryptedAccessLog]]:
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.modifyAccessLogsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: DecryptedAccessLog._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def get_access_log_async(self, group_id: str, entity_id: str) -> Optional[GroupScoped[DecryptedAccessLog]]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedAccessLog._deserialize(x1)) if raw_result is not None else None
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.getAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_access_log_blocking(self, group_id: str, entity_id: str) -> Optional[GroupScoped[DecryptedAccessLog]]:
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.getAccessLogBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedAccessLog._deserialize(x1)) if result_info.success is not None else None
			return return_value

	async def get_access_logs_async(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[DecryptedAccessLog]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: DecryptedAccessLog._deserialize(x2)) for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.getAccessLogsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_access_logs_blocking(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[DecryptedAccessLog]]:
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.getAccessLogsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: DecryptedAccessLog._deserialize(x2)) for x1 in result_info.success]
			return return_value


class AccessLogApiInGroupEncrypted:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate: EntityReferenceInGroup, access_log: GroupScoped[EncryptedAccessLog], options: Optional[AccessLogShareOptions] = None) -> GroupScoped[EncryptedAccessLog]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedAccessLog._deserialize(x1))
		payload = {
			"delegate": delegate.__serialize__(),
			"accessLog": access_log.__serialize__(lambda x0: x0.__serialize__()),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.encrypted.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate: EntityReferenceInGroup, access_log: GroupScoped[EncryptedAccessLog], options: Optional[AccessLogShareOptions] = None) -> GroupScoped[EncryptedAccessLog]:
		payload = {
			"delegate": delegate.__serialize__(),
			"accessLog": access_log.__serialize__(lambda x0: x0.__serialize__()),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.encrypted.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedAccessLog._deserialize(x1))
			return return_value

	async def share_with_many_async(self, access_log: GroupScoped[EncryptedAccessLog], delegates: dict[EntityReferenceInGroup, AccessLogShareOptions]) -> GroupScoped[EncryptedAccessLog]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedAccessLog._deserialize(x1))
		payload = {
			"accessLog": access_log.__serialize__(lambda x0: x0.__serialize__()),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.encrypted.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, access_log: GroupScoped[EncryptedAccessLog], delegates: dict[EntityReferenceInGroup, AccessLogShareOptions]) -> GroupScoped[EncryptedAccessLog]:
		payload = {
			"accessLog": access_log.__serialize__(lambda x0: x0.__serialize__()),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.encrypted.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedAccessLog._deserialize(x1))
			return return_value

	async def filter_access_logs_by_async(self, group_id: str, filter: FilterOptions[AccessLog]) -> PaginatedListIterator[GroupScoped[EncryptedAccessLog]]:
		def do_decode(raw_result):
			return PaginatedListIterator[GroupScoped[EncryptedAccessLog]](
				producer = raw_result,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: EncryptedAccessLog._deserialize(x1)),
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.encrypted.filterAccessLogsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_access_logs_by_blocking(self, group_id: str, filter: FilterOptions[AccessLog]) -> PaginatedListIterator[GroupScoped[EncryptedAccessLog]]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.encrypted.filterAccessLogsByBlocking(
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
			return PaginatedListIterator[GroupScoped[EncryptedAccessLog]](
				producer = class_pointer,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: EncryptedAccessLog._deserialize(x1)),
				executor = self.cardinal_sdk._executor
			)

	async def filter_access_logs_by_sorted_async(self, group_id: str, filter: SortableFilterOptions[AccessLog]) -> PaginatedListIterator[GroupScoped[EncryptedAccessLog]]:
		def do_decode(raw_result):
			return PaginatedListIterator[GroupScoped[EncryptedAccessLog]](
				producer = raw_result,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: EncryptedAccessLog._deserialize(x1)),
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.encrypted.filterAccessLogsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_access_logs_by_sorted_blocking(self, group_id: str, filter: SortableFilterOptions[AccessLog]) -> PaginatedListIterator[GroupScoped[EncryptedAccessLog]]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.encrypted.filterAccessLogsBySortedBlocking(
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
			return PaginatedListIterator[GroupScoped[EncryptedAccessLog]](
				producer = class_pointer,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: EncryptedAccessLog._deserialize(x1)),
				executor = self.cardinal_sdk._executor
			)

	async def create_access_log_async(self, entity: GroupScoped[EncryptedAccessLog]) -> GroupScoped[EncryptedAccessLog]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedAccessLog._deserialize(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.encrypted.createAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_access_log_blocking(self, entity: GroupScoped[EncryptedAccessLog]) -> GroupScoped[EncryptedAccessLog]:
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.encrypted.createAccessLogBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedAccessLog._deserialize(x1))
			return return_value

	async def create_access_logs_async(self, entities: list[GroupScoped[EncryptedAccessLog]]) -> list[GroupScoped[EncryptedAccessLog]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: EncryptedAccessLog._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.encrypted.createAccessLogsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_access_logs_blocking(self, entities: list[GroupScoped[EncryptedAccessLog]]) -> list[GroupScoped[EncryptedAccessLog]]:
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.encrypted.createAccessLogsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: EncryptedAccessLog._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def undelete_access_log_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[EncryptedAccessLog]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedAccessLog._deserialize(x1))
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.encrypted.undeleteAccessLogByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_access_log_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[EncryptedAccessLog]:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.encrypted.undeleteAccessLogByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedAccessLog._deserialize(x1))
			return return_value

	async def undelete_access_logs_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[EncryptedAccessLog]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: EncryptedAccessLog._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.encrypted.undeleteAccessLogsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_access_logs_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[EncryptedAccessLog]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.encrypted.undeleteAccessLogsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: EncryptedAccessLog._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def undelete_access_log_async(self, access_log: GroupScoped[AccessLog]) -> GroupScoped[EncryptedAccessLog]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedAccessLog._deserialize(x1))
		payload = {
			"accessLog": access_log.__serialize__(lambda x0: serialize_access_log(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.encrypted.undeleteAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_access_log_blocking(self, access_log: GroupScoped[AccessLog]) -> GroupScoped[EncryptedAccessLog]:
		payload = {
			"accessLog": access_log.__serialize__(lambda x0: serialize_access_log(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.encrypted.undeleteAccessLogBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedAccessLog._deserialize(x1))
			return return_value

	async def undelete_access_logs_async(self, access_logs: list[GroupScoped[AccessLog]]) -> list[GroupScoped[EncryptedAccessLog]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: EncryptedAccessLog._deserialize(x2)) for x1 in raw_result]
		payload = {
			"accessLogs": [x0.__serialize__(lambda x1: serialize_access_log(x1)) for x0 in access_logs],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.encrypted.undeleteAccessLogsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_access_logs_blocking(self, access_logs: list[GroupScoped[AccessLog]]) -> list[GroupScoped[EncryptedAccessLog]]:
		payload = {
			"accessLogs": [x0.__serialize__(lambda x1: serialize_access_log(x1)) for x0 in access_logs],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.encrypted.undeleteAccessLogsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: EncryptedAccessLog._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def modify_access_log_async(self, entity: GroupScoped[EncryptedAccessLog]) -> GroupScoped[EncryptedAccessLog]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedAccessLog._deserialize(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.encrypted.modifyAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_access_log_blocking(self, entity: GroupScoped[EncryptedAccessLog]) -> GroupScoped[EncryptedAccessLog]:
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.encrypted.modifyAccessLogBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedAccessLog._deserialize(x1))
			return return_value

	async def modify_access_logs_async(self, entities: list[GroupScoped[EncryptedAccessLog]]) -> list[GroupScoped[EncryptedAccessLog]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: EncryptedAccessLog._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.encrypted.modifyAccessLogsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_access_logs_blocking(self, entities: list[GroupScoped[EncryptedAccessLog]]) -> list[GroupScoped[EncryptedAccessLog]]:
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.encrypted.modifyAccessLogsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: EncryptedAccessLog._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def get_access_log_async(self, group_id: str, entity_id: str) -> Optional[GroupScoped[EncryptedAccessLog]]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedAccessLog._deserialize(x1)) if raw_result is not None else None
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.encrypted.getAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_access_log_blocking(self, group_id: str, entity_id: str) -> Optional[GroupScoped[EncryptedAccessLog]]:
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.encrypted.getAccessLogBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedAccessLog._deserialize(x1)) if result_info.success is not None else None
			return return_value

	async def get_access_logs_async(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[EncryptedAccessLog]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: EncryptedAccessLog._deserialize(x2)) for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.encrypted.getAccessLogsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_access_logs_blocking(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[EncryptedAccessLog]]:
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.encrypted.getAccessLogsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: EncryptedAccessLog._deserialize(x2)) for x1 in result_info.success]
			return return_value


class AccessLogApiInGroupTryAndRecover:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate: EntityReferenceInGroup, access_log: GroupScoped[AccessLog], options: Optional[AccessLogShareOptions] = None) -> GroupScoped[AccessLog]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_access_log(x1))
		payload = {
			"delegate": delegate.__serialize__(),
			"accessLog": access_log.__serialize__(lambda x0: serialize_access_log(x0)),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.tryAndRecover.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate: EntityReferenceInGroup, access_log: GroupScoped[AccessLog], options: Optional[AccessLogShareOptions] = None) -> GroupScoped[AccessLog]:
		payload = {
			"delegate": delegate.__serialize__(),
			"accessLog": access_log.__serialize__(lambda x0: serialize_access_log(x0)),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.tryAndRecover.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_access_log(x1))
			return return_value

	async def share_with_many_async(self, access_log: GroupScoped[AccessLog], delegates: dict[EntityReferenceInGroup, AccessLogShareOptions]) -> GroupScoped[AccessLog]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_access_log(x1))
		payload = {
			"accessLog": access_log.__serialize__(lambda x0: serialize_access_log(x0)),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.tryAndRecover.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, access_log: GroupScoped[AccessLog], delegates: dict[EntityReferenceInGroup, AccessLogShareOptions]) -> GroupScoped[AccessLog]:
		payload = {
			"accessLog": access_log.__serialize__(lambda x0: serialize_access_log(x0)),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.tryAndRecover.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_access_log(x1))
			return return_value

	async def filter_access_logs_by_async(self, group_id: str, filter: FilterOptions[AccessLog]) -> PaginatedListIterator[GroupScoped[AccessLog]]:
		def do_decode(raw_result):
			return PaginatedListIterator[GroupScoped[AccessLog]](
				producer = raw_result,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: deserialize_access_log(x1)),
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.tryAndRecover.filterAccessLogsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_access_logs_by_blocking(self, group_id: str, filter: FilterOptions[AccessLog]) -> PaginatedListIterator[GroupScoped[AccessLog]]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.tryAndRecover.filterAccessLogsByBlocking(
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
			return PaginatedListIterator[GroupScoped[AccessLog]](
				producer = class_pointer,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: deserialize_access_log(x1)),
				executor = self.cardinal_sdk._executor
			)

	async def filter_access_logs_by_sorted_async(self, group_id: str, filter: SortableFilterOptions[AccessLog]) -> PaginatedListIterator[GroupScoped[AccessLog]]:
		def do_decode(raw_result):
			return PaginatedListIterator[GroupScoped[AccessLog]](
				producer = raw_result,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: deserialize_access_log(x1)),
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.tryAndRecover.filterAccessLogsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_access_logs_by_sorted_blocking(self, group_id: str, filter: SortableFilterOptions[AccessLog]) -> PaginatedListIterator[GroupScoped[AccessLog]]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.tryAndRecover.filterAccessLogsBySortedBlocking(
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
			return PaginatedListIterator[GroupScoped[AccessLog]](
				producer = class_pointer,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: deserialize_access_log(x1)),
				executor = self.cardinal_sdk._executor
			)

	async def create_access_log_async(self, entity: GroupScoped[AccessLog]) -> GroupScoped[AccessLog]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_access_log(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_access_log(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.tryAndRecover.createAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_access_log_blocking(self, entity: GroupScoped[AccessLog]) -> GroupScoped[AccessLog]:
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_access_log(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.tryAndRecover.createAccessLogBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_access_log(x1))
			return return_value

	async def create_access_logs_async(self, entities: list[GroupScoped[AccessLog]]) -> list[GroupScoped[AccessLog]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: deserialize_access_log(x2)) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__(lambda x1: serialize_access_log(x1)) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.tryAndRecover.createAccessLogsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_access_logs_blocking(self, entities: list[GroupScoped[AccessLog]]) -> list[GroupScoped[AccessLog]]:
		payload = {
			"entities": [x0.__serialize__(lambda x1: serialize_access_log(x1)) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.tryAndRecover.createAccessLogsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: deserialize_access_log(x2)) for x1 in result_info.success]
			return return_value

	async def undelete_access_log_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[AccessLog]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_access_log(x1))
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.tryAndRecover.undeleteAccessLogByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_access_log_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[AccessLog]:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.tryAndRecover.undeleteAccessLogByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_access_log(x1))
			return return_value

	async def undelete_access_logs_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[AccessLog]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: deserialize_access_log(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.tryAndRecover.undeleteAccessLogsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_access_logs_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[AccessLog]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.tryAndRecover.undeleteAccessLogsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: deserialize_access_log(x2)) for x1 in result_info.success]
			return return_value

	async def undelete_access_log_async(self, access_log: GroupScoped[AccessLog]) -> GroupScoped[AccessLog]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_access_log(x1))
		payload = {
			"accessLog": access_log.__serialize__(lambda x0: serialize_access_log(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.tryAndRecover.undeleteAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_access_log_blocking(self, access_log: GroupScoped[AccessLog]) -> GroupScoped[AccessLog]:
		payload = {
			"accessLog": access_log.__serialize__(lambda x0: serialize_access_log(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.tryAndRecover.undeleteAccessLogBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_access_log(x1))
			return return_value

	async def undelete_access_logs_async(self, access_logs: list[GroupScoped[AccessLog]]) -> list[GroupScoped[AccessLog]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: deserialize_access_log(x2)) for x1 in raw_result]
		payload = {
			"accessLogs": [x0.__serialize__(lambda x1: serialize_access_log(x1)) for x0 in access_logs],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.tryAndRecover.undeleteAccessLogsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_access_logs_blocking(self, access_logs: list[GroupScoped[AccessLog]]) -> list[GroupScoped[AccessLog]]:
		payload = {
			"accessLogs": [x0.__serialize__(lambda x1: serialize_access_log(x1)) for x0 in access_logs],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.tryAndRecover.undeleteAccessLogsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: deserialize_access_log(x2)) for x1 in result_info.success]
			return return_value

	async def modify_access_log_async(self, entity: GroupScoped[AccessLog]) -> GroupScoped[AccessLog]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_access_log(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_access_log(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.tryAndRecover.modifyAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_access_log_blocking(self, entity: GroupScoped[AccessLog]) -> GroupScoped[AccessLog]:
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_access_log(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.tryAndRecover.modifyAccessLogBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_access_log(x1))
			return return_value

	async def modify_access_logs_async(self, entities: list[GroupScoped[AccessLog]]) -> list[GroupScoped[AccessLog]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: deserialize_access_log(x2)) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__(lambda x1: serialize_access_log(x1)) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.tryAndRecover.modifyAccessLogsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_access_logs_blocking(self, entities: list[GroupScoped[AccessLog]]) -> list[GroupScoped[AccessLog]]:
		payload = {
			"entities": [x0.__serialize__(lambda x1: serialize_access_log(x1)) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.tryAndRecover.modifyAccessLogsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: deserialize_access_log(x2)) for x1 in result_info.success]
			return return_value

	async def get_access_log_async(self, group_id: str, entity_id: str) -> Optional[GroupScoped[AccessLog]]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_access_log(x1)) if raw_result is not None else None
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.tryAndRecover.getAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_access_log_blocking(self, group_id: str, entity_id: str) -> Optional[GroupScoped[AccessLog]]:
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.tryAndRecover.getAccessLogBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_access_log(x1)) if result_info.success is not None else None
			return return_value

	async def get_access_logs_async(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[AccessLog]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: deserialize_access_log(x2)) for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.tryAndRecover.getAccessLogsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_access_logs_blocking(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[AccessLog]]:
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.inGroup.tryAndRecover.getAccessLogsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: deserialize_access_log(x2)) for x1 in result_info.success]
			return return_value
