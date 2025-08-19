# auto-generated file
import json
from typing import Optional
from cardinal_sdk.model import DecryptedMaintenanceTask, User, AccessLevel, MaintenanceTask, serialize_maintenance_task, EncryptedMaintenanceTask, deserialize_maintenance_task, DocIdentifier, StoredDocumentIdentifier, MaintenanceTaskShareOptions, SubscriptionEventType, EntitySubscriptionConfiguration
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.model.specializations import HexString
from cardinal_sdk.filters.FilterOptions import FilterOptions, SortableFilterOptions
from cardinal_sdk.pagination.PaginatedListIterator import PaginatedListIterator
from cardinal_sdk.subscription.EntitySubscription import EntitySubscription


class MaintenanceTaskApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk
		self.encrypted = MaintenanceTaskApiEncrypted(self.cardinal_sdk)
		self.try_and_recover = MaintenanceTaskApiTryAndRecover(self.cardinal_sdk)

	async def with_encryption_metadata_async(self, maintenance_task: Optional[DecryptedMaintenanceTask], user: Optional[User] = None, delegates: dict[str, AccessLevel] = {}, alternate_root_delegate_id: Optional[str] = None) -> DecryptedMaintenanceTask:
		def do_decode(raw_result):
			return DecryptedMaintenanceTask._deserialize(raw_result)
		payload = {
			"maintenanceTask": maintenance_task.__serialize__() if maintenance_task is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"alternateRootDelegateId": alternate_root_delegate_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.withEncryptionMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def with_encryption_metadata_blocking(self, maintenance_task: Optional[DecryptedMaintenanceTask], user: Optional[User] = None, delegates: dict[str, AccessLevel] = {}, alternate_root_delegate_id: Optional[str] = None) -> DecryptedMaintenanceTask:
		payload = {
			"maintenanceTask": maintenance_task.__serialize__() if maintenance_task is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"alternateRootDelegateId": alternate_root_delegate_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.withEncryptionMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedMaintenanceTask._deserialize(result_info.success)
			return return_value

	async def get_encryption_keys_of_async(self, maintenance_task: MaintenanceTask) -> set[HexString]:
		def do_decode(raw_result):
			return {x1 for x1 in raw_result}
		payload = {
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.getEncryptionKeysOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_encryption_keys_of_blocking(self, maintenance_task: MaintenanceTask) -> set[HexString]:
		payload = {
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.getEncryptionKeysOfBlocking(
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

	async def has_write_access_async(self, maintenance_task: MaintenanceTask) -> bool:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.hasWriteAccessAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def has_write_access_blocking(self, maintenance_task: MaintenanceTask) -> bool:
		payload = {
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.hasWriteAccessBlocking(
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

	async def decrypt_patient_id_of_async(self, maintenance_task: MaintenanceTask) -> set[str]:
		def do_decode(raw_result):
			return {x1 for x1 in raw_result}
		payload = {
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.decryptPatientIdOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_patient_id_of_blocking(self, maintenance_task: MaintenanceTask) -> set[str]:
		payload = {
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.decryptPatientIdOfBlocking(
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

	async def create_delegation_de_anonymization_metadata_async(self, entity: MaintenanceTask, delegates: set[str]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"entity": serialize_maintenance_task(entity),
			"delegates": [x0 for x0 in delegates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.createDelegationDeAnonymizationMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_delegation_de_anonymization_metadata_blocking(self, entity: MaintenanceTask, delegates: set[str]) -> None:
		payload = {
			"entity": serialize_maintenance_task(entity),
			"delegates": [x0 for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.createDelegationDeAnonymizationMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def decrypt_async(self, maintenance_task: EncryptedMaintenanceTask) -> DecryptedMaintenanceTask:
		def do_decode(raw_result):
			return DecryptedMaintenanceTask._deserialize(raw_result)
		payload = {
			"maintenanceTask": maintenance_task.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.decryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_blocking(self, maintenance_task: EncryptedMaintenanceTask) -> DecryptedMaintenanceTask:
		payload = {
			"maintenanceTask": maintenance_task.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.decryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedMaintenanceTask._deserialize(result_info.success)
			return return_value

	async def try_decrypt_async(self, maintenance_task: EncryptedMaintenanceTask) -> MaintenanceTask:
		def do_decode(raw_result):
			return deserialize_maintenance_task(raw_result)
		payload = {
			"maintenanceTask": maintenance_task.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.tryDecryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def try_decrypt_blocking(self, maintenance_task: EncryptedMaintenanceTask) -> MaintenanceTask:
		payload = {
			"maintenanceTask": maintenance_task.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.tryDecryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_maintenance_task(result_info.success)
			return return_value

	async def match_maintenance_tasks_by_async(self, filter: FilterOptions[MaintenanceTask]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.matchMaintenanceTasksByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_maintenance_tasks_by_blocking(self, filter: FilterOptions[MaintenanceTask]) -> list[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.matchMaintenanceTasksByBlocking(
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

	async def match_maintenance_tasks_by_sorted_async(self, filter: SortableFilterOptions[MaintenanceTask]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.matchMaintenanceTasksBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_maintenance_tasks_by_sorted_blocking(self, filter: SortableFilterOptions[MaintenanceTask]) -> list[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.matchMaintenanceTasksBySortedBlocking(
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

	async def delete_maintenance_task_by_id_async(self, entity_id: str, rev: str) -> DocIdentifier:
		def do_decode(raw_result):
			return DocIdentifier._deserialize(raw_result)
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.deleteMaintenanceTaskByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_maintenance_task_by_id_blocking(self, entity_id: str, rev: str) -> DocIdentifier:
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.deleteMaintenanceTaskByIdBlocking(
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

	async def delete_maintenance_tasks_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[DocIdentifier]:
		def do_decode(raw_result):
			return [DocIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.deleteMaintenanceTasksByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_maintenance_tasks_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[DocIdentifier]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.deleteMaintenanceTasksByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DocIdentifier._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def purge_maintenance_task_by_id_async(self, id: str, rev: str) -> None:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.purgeMaintenanceTaskByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_maintenance_task_by_id_blocking(self, id: str, rev: str) -> None:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.purgeMaintenanceTaskByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def delete_maintenance_task_async(self, maintenance_task: MaintenanceTask) -> DocIdentifier:
		def do_decode(raw_result):
			return DocIdentifier._deserialize(raw_result)
		payload = {
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.deleteMaintenanceTaskAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_maintenance_task_blocking(self, maintenance_task: MaintenanceTask) -> DocIdentifier:
		payload = {
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.deleteMaintenanceTaskBlocking(
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

	async def delete_maintenance_tasks_async(self, maintenance_tasks: list[MaintenanceTask]) -> list[DocIdentifier]:
		def do_decode(raw_result):
			return [DocIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"maintenanceTasks": [serialize_maintenance_task(x0) for x0 in maintenance_tasks],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.deleteMaintenanceTasksAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_maintenance_tasks_blocking(self, maintenance_tasks: list[MaintenanceTask]) -> list[DocIdentifier]:
		payload = {
			"maintenanceTasks": [serialize_maintenance_task(x0) for x0 in maintenance_tasks],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.deleteMaintenanceTasksBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DocIdentifier._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def purge_maintenance_task_async(self, maintenance_task: MaintenanceTask) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.purgeMaintenanceTaskAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_maintenance_task_blocking(self, maintenance_task: MaintenanceTask) -> None:
		payload = {
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.purgeMaintenanceTaskBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def share_with_async(self, delegate_id: str, maintenance_task: DecryptedMaintenanceTask, options: Optional[MaintenanceTaskShareOptions] = None) -> DecryptedMaintenanceTask:
		def do_decode(raw_result):
			return DecryptedMaintenanceTask._deserialize(raw_result)
		payload = {
			"delegateId": delegate_id,
			"maintenanceTask": maintenance_task.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, maintenance_task: DecryptedMaintenanceTask, options: Optional[MaintenanceTaskShareOptions] = None) -> DecryptedMaintenanceTask:
		payload = {
			"delegateId": delegate_id,
			"maintenanceTask": maintenance_task.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedMaintenanceTask._deserialize(result_info.success)
			return return_value

	async def share_with_many_async(self, maintenance_task: DecryptedMaintenanceTask, delegates: dict[str, MaintenanceTaskShareOptions]) -> DecryptedMaintenanceTask:
		def do_decode(raw_result):
			return DecryptedMaintenanceTask._deserialize(raw_result)
		payload = {
			"maintenanceTask": maintenance_task.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, maintenance_task: DecryptedMaintenanceTask, delegates: dict[str, MaintenanceTaskShareOptions]) -> DecryptedMaintenanceTask:
		payload = {
			"maintenanceTask": maintenance_task.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedMaintenanceTask._deserialize(result_info.success)
			return return_value

	async def filter_maintenance_tasks_by_async(self, filter: FilterOptions[MaintenanceTask]) -> PaginatedListIterator[DecryptedMaintenanceTask]:
		def do_decode(raw_result):
			return PaginatedListIterator[DecryptedMaintenanceTask](
				producer = raw_result,
				deserializer = lambda x: DecryptedMaintenanceTask._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.filterMaintenanceTasksByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_maintenance_tasks_by_blocking(self, filter: FilterOptions[MaintenanceTask]) -> PaginatedListIterator[DecryptedMaintenanceTask]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.filterMaintenanceTasksByBlocking(
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
			return PaginatedListIterator[DecryptedMaintenanceTask](
				producer = class_pointer,
				deserializer = lambda x: DecryptedMaintenanceTask._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_maintenance_tasks_by_sorted_async(self, filter: SortableFilterOptions[MaintenanceTask]) -> PaginatedListIterator[DecryptedMaintenanceTask]:
		def do_decode(raw_result):
			return PaginatedListIterator[DecryptedMaintenanceTask](
				producer = raw_result,
				deserializer = lambda x: DecryptedMaintenanceTask._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.filterMaintenanceTasksBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_maintenance_tasks_by_sorted_blocking(self, filter: SortableFilterOptions[MaintenanceTask]) -> PaginatedListIterator[DecryptedMaintenanceTask]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.filterMaintenanceTasksBySortedBlocking(
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
			return PaginatedListIterator[DecryptedMaintenanceTask](
				producer = class_pointer,
				deserializer = lambda x: DecryptedMaintenanceTask._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def create_maintenance_task_async(self, entity: DecryptedMaintenanceTask) -> DecryptedMaintenanceTask:
		def do_decode(raw_result):
			return DecryptedMaintenanceTask._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.createMaintenanceTaskAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_maintenance_task_blocking(self, entity: DecryptedMaintenanceTask) -> DecryptedMaintenanceTask:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.createMaintenanceTaskBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedMaintenanceTask._deserialize(result_info.success)
			return return_value

	async def undelete_maintenance_task_async(self, maintenance_task: MaintenanceTask) -> MaintenanceTask:
		def do_decode(raw_result):
			return deserialize_maintenance_task(raw_result)
		payload = {
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.undeleteMaintenanceTaskAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_maintenance_task_blocking(self, maintenance_task: MaintenanceTask) -> MaintenanceTask:
		payload = {
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.undeleteMaintenanceTaskBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_maintenance_task(result_info.success)
			return return_value

	async def undelete_maintenance_task_by_id_async(self, id: str, rev: str) -> DecryptedMaintenanceTask:
		def do_decode(raw_result):
			return DecryptedMaintenanceTask._deserialize(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.undeleteMaintenanceTaskByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_maintenance_task_by_id_blocking(self, id: str, rev: str) -> DecryptedMaintenanceTask:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.undeleteMaintenanceTaskByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedMaintenanceTask._deserialize(result_info.success)
			return return_value

	async def modify_maintenance_task_async(self, entity: DecryptedMaintenanceTask) -> DecryptedMaintenanceTask:
		def do_decode(raw_result):
			return DecryptedMaintenanceTask._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.modifyMaintenanceTaskAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_maintenance_task_blocking(self, entity: DecryptedMaintenanceTask) -> DecryptedMaintenanceTask:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.modifyMaintenanceTaskBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedMaintenanceTask._deserialize(result_info.success)
			return return_value

	async def get_maintenance_task_async(self, entity_id: str) -> Optional[DecryptedMaintenanceTask]:
		def do_decode(raw_result):
			return DecryptedMaintenanceTask._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.getMaintenanceTaskAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_maintenance_task_blocking(self, entity_id: str) -> Optional[DecryptedMaintenanceTask]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.getMaintenanceTaskBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedMaintenanceTask._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_maintenance_tasks_async(self, entity_ids: list[str]) -> list[DecryptedMaintenanceTask]:
		def do_decode(raw_result):
			return [DecryptedMaintenanceTask._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.getMaintenanceTasksAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_maintenance_tasks_blocking(self, entity_ids: list[str]) -> list[DecryptedMaintenanceTask]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.getMaintenanceTasksBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedMaintenanceTask._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def subscribe_to_events_async(self, events: set[SubscriptionEventType], filter: FilterOptions[MaintenanceTask], subscription_config: Optional[EntitySubscriptionConfiguration] = None) -> EntitySubscription[EncryptedMaintenanceTask]:
		def do_decode(raw_result):
			return EntitySubscription[EncryptedMaintenanceTask](
				producer = raw_result,
				deserializer = lambda x: EncryptedMaintenanceTask._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"events": [x0.__serialize__() for x0 in events],
			"filter": filter.__serialize__(),
			"subscriptionConfig": subscription_config.__serialize__() if subscription_config is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.subscribeToEventsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def subscribe_to_events_blocking(self, events: set[SubscriptionEventType], filter: FilterOptions[MaintenanceTask], subscription_config: Optional[EntitySubscriptionConfiguration] = None) -> EntitySubscription[EncryptedMaintenanceTask]:
		payload = {
			"events": [x0.__serialize__() for x0 in events],
			"filter": filter.__serialize__(),
			"subscriptionConfig": subscription_config.__serialize__() if subscription_config is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.subscribeToEventsBlocking(
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
			return EntitySubscription[EncryptedMaintenanceTask](
				producer = class_pointer,
				deserializer = lambda x: EncryptedMaintenanceTask._deserialize(x),
				executor = self.cardinal_sdk._executor
			)


class MaintenanceTaskApiEncrypted:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate_id: str, maintenance_task: EncryptedMaintenanceTask, options: Optional[MaintenanceTaskShareOptions] = None) -> EncryptedMaintenanceTask:
		def do_decode(raw_result):
			return EncryptedMaintenanceTask._deserialize(raw_result)
		payload = {
			"delegateId": delegate_id,
			"maintenanceTask": maintenance_task.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.encrypted.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, maintenance_task: EncryptedMaintenanceTask, options: Optional[MaintenanceTaskShareOptions] = None) -> EncryptedMaintenanceTask:
		payload = {
			"delegateId": delegate_id,
			"maintenanceTask": maintenance_task.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.encrypted.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedMaintenanceTask._deserialize(result_info.success)
			return return_value

	async def share_with_many_async(self, maintenance_task: EncryptedMaintenanceTask, delegates: dict[str, MaintenanceTaskShareOptions]) -> EncryptedMaintenanceTask:
		def do_decode(raw_result):
			return EncryptedMaintenanceTask._deserialize(raw_result)
		payload = {
			"maintenanceTask": maintenance_task.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.encrypted.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, maintenance_task: EncryptedMaintenanceTask, delegates: dict[str, MaintenanceTaskShareOptions]) -> EncryptedMaintenanceTask:
		payload = {
			"maintenanceTask": maintenance_task.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.encrypted.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedMaintenanceTask._deserialize(result_info.success)
			return return_value

	async def filter_maintenance_tasks_by_async(self, filter: FilterOptions[MaintenanceTask]) -> PaginatedListIterator[EncryptedMaintenanceTask]:
		def do_decode(raw_result):
			return PaginatedListIterator[EncryptedMaintenanceTask](
				producer = raw_result,
				deserializer = lambda x: EncryptedMaintenanceTask._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.encrypted.filterMaintenanceTasksByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_maintenance_tasks_by_blocking(self, filter: FilterOptions[MaintenanceTask]) -> PaginatedListIterator[EncryptedMaintenanceTask]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.encrypted.filterMaintenanceTasksByBlocking(
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
			return PaginatedListIterator[EncryptedMaintenanceTask](
				producer = class_pointer,
				deserializer = lambda x: EncryptedMaintenanceTask._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_maintenance_tasks_by_sorted_async(self, filter: SortableFilterOptions[MaintenanceTask]) -> PaginatedListIterator[EncryptedMaintenanceTask]:
		def do_decode(raw_result):
			return PaginatedListIterator[EncryptedMaintenanceTask](
				producer = raw_result,
				deserializer = lambda x: EncryptedMaintenanceTask._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.encrypted.filterMaintenanceTasksBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_maintenance_tasks_by_sorted_blocking(self, filter: SortableFilterOptions[MaintenanceTask]) -> PaginatedListIterator[EncryptedMaintenanceTask]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.encrypted.filterMaintenanceTasksBySortedBlocking(
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
			return PaginatedListIterator[EncryptedMaintenanceTask](
				producer = class_pointer,
				deserializer = lambda x: EncryptedMaintenanceTask._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def create_maintenance_task_async(self, entity: EncryptedMaintenanceTask) -> EncryptedMaintenanceTask:
		def do_decode(raw_result):
			return EncryptedMaintenanceTask._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.encrypted.createMaintenanceTaskAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_maintenance_task_blocking(self, entity: EncryptedMaintenanceTask) -> EncryptedMaintenanceTask:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.encrypted.createMaintenanceTaskBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedMaintenanceTask._deserialize(result_info.success)
			return return_value

	async def undelete_maintenance_task_async(self, maintenance_task: MaintenanceTask) -> MaintenanceTask:
		def do_decode(raw_result):
			return deserialize_maintenance_task(raw_result)
		payload = {
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.encrypted.undeleteMaintenanceTaskAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_maintenance_task_blocking(self, maintenance_task: MaintenanceTask) -> MaintenanceTask:
		payload = {
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.encrypted.undeleteMaintenanceTaskBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_maintenance_task(result_info.success)
			return return_value

	async def undelete_maintenance_task_by_id_async(self, id: str, rev: str) -> EncryptedMaintenanceTask:
		def do_decode(raw_result):
			return EncryptedMaintenanceTask._deserialize(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.encrypted.undeleteMaintenanceTaskByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_maintenance_task_by_id_blocking(self, id: str, rev: str) -> EncryptedMaintenanceTask:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.encrypted.undeleteMaintenanceTaskByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedMaintenanceTask._deserialize(result_info.success)
			return return_value

	async def modify_maintenance_task_async(self, entity: EncryptedMaintenanceTask) -> EncryptedMaintenanceTask:
		def do_decode(raw_result):
			return EncryptedMaintenanceTask._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.encrypted.modifyMaintenanceTaskAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_maintenance_task_blocking(self, entity: EncryptedMaintenanceTask) -> EncryptedMaintenanceTask:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.encrypted.modifyMaintenanceTaskBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedMaintenanceTask._deserialize(result_info.success)
			return return_value

	async def get_maintenance_task_async(self, entity_id: str) -> Optional[EncryptedMaintenanceTask]:
		def do_decode(raw_result):
			return EncryptedMaintenanceTask._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.encrypted.getMaintenanceTaskAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_maintenance_task_blocking(self, entity_id: str) -> Optional[EncryptedMaintenanceTask]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.encrypted.getMaintenanceTaskBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedMaintenanceTask._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_maintenance_tasks_async(self, entity_ids: list[str]) -> list[EncryptedMaintenanceTask]:
		def do_decode(raw_result):
			return [EncryptedMaintenanceTask._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.encrypted.getMaintenanceTasksAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_maintenance_tasks_blocking(self, entity_ids: list[str]) -> list[EncryptedMaintenanceTask]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.encrypted.getMaintenanceTasksBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedMaintenanceTask._deserialize(x1) for x1 in result_info.success]
			return return_value


class MaintenanceTaskApiTryAndRecover:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate_id: str, maintenance_task: MaintenanceTask, options: Optional[MaintenanceTaskShareOptions] = None) -> MaintenanceTask:
		def do_decode(raw_result):
			return deserialize_maintenance_task(raw_result)
		payload = {
			"delegateId": delegate_id,
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.tryAndRecover.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, maintenance_task: MaintenanceTask, options: Optional[MaintenanceTaskShareOptions] = None) -> MaintenanceTask:
		payload = {
			"delegateId": delegate_id,
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.tryAndRecover.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_maintenance_task(result_info.success)
			return return_value

	async def share_with_many_async(self, maintenance_task: MaintenanceTask, delegates: dict[str, MaintenanceTaskShareOptions]) -> MaintenanceTask:
		def do_decode(raw_result):
			return deserialize_maintenance_task(raw_result)
		payload = {
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.tryAndRecover.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, maintenance_task: MaintenanceTask, delegates: dict[str, MaintenanceTaskShareOptions]) -> MaintenanceTask:
		payload = {
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.tryAndRecover.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_maintenance_task(result_info.success)
			return return_value

	async def filter_maintenance_tasks_by_async(self, filter: FilterOptions[MaintenanceTask]) -> PaginatedListIterator[MaintenanceTask]:
		def do_decode(raw_result):
			return PaginatedListIterator[MaintenanceTask](
				producer = raw_result,
				deserializer = lambda x: deserialize_maintenance_task(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.tryAndRecover.filterMaintenanceTasksByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_maintenance_tasks_by_blocking(self, filter: FilterOptions[MaintenanceTask]) -> PaginatedListIterator[MaintenanceTask]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.tryAndRecover.filterMaintenanceTasksByBlocking(
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
			return PaginatedListIterator[MaintenanceTask](
				producer = class_pointer,
				deserializer = lambda x: deserialize_maintenance_task(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_maintenance_tasks_by_sorted_async(self, filter: SortableFilterOptions[MaintenanceTask]) -> PaginatedListIterator[MaintenanceTask]:
		def do_decode(raw_result):
			return PaginatedListIterator[MaintenanceTask](
				producer = raw_result,
				deserializer = lambda x: deserialize_maintenance_task(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.tryAndRecover.filterMaintenanceTasksBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_maintenance_tasks_by_sorted_blocking(self, filter: SortableFilterOptions[MaintenanceTask]) -> PaginatedListIterator[MaintenanceTask]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.tryAndRecover.filterMaintenanceTasksBySortedBlocking(
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
			return PaginatedListIterator[MaintenanceTask](
				producer = class_pointer,
				deserializer = lambda x: deserialize_maintenance_task(x),
				executor = self.cardinal_sdk._executor
			)

	async def create_maintenance_task_async(self, entity: MaintenanceTask) -> MaintenanceTask:
		def do_decode(raw_result):
			return deserialize_maintenance_task(raw_result)
		payload = {
			"entity": serialize_maintenance_task(entity),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.tryAndRecover.createMaintenanceTaskAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_maintenance_task_blocking(self, entity: MaintenanceTask) -> MaintenanceTask:
		payload = {
			"entity": serialize_maintenance_task(entity),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.tryAndRecover.createMaintenanceTaskBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_maintenance_task(result_info.success)
			return return_value

	async def undelete_maintenance_task_async(self, maintenance_task: MaintenanceTask) -> MaintenanceTask:
		def do_decode(raw_result):
			return deserialize_maintenance_task(raw_result)
		payload = {
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.tryAndRecover.undeleteMaintenanceTaskAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_maintenance_task_blocking(self, maintenance_task: MaintenanceTask) -> MaintenanceTask:
		payload = {
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.tryAndRecover.undeleteMaintenanceTaskBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_maintenance_task(result_info.success)
			return return_value

	async def undelete_maintenance_task_by_id_async(self, id: str, rev: str) -> MaintenanceTask:
		def do_decode(raw_result):
			return deserialize_maintenance_task(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.tryAndRecover.undeleteMaintenanceTaskByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_maintenance_task_by_id_blocking(self, id: str, rev: str) -> MaintenanceTask:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.tryAndRecover.undeleteMaintenanceTaskByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_maintenance_task(result_info.success)
			return return_value

	async def modify_maintenance_task_async(self, entity: MaintenanceTask) -> MaintenanceTask:
		def do_decode(raw_result):
			return deserialize_maintenance_task(raw_result)
		payload = {
			"entity": serialize_maintenance_task(entity),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.tryAndRecover.modifyMaintenanceTaskAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_maintenance_task_blocking(self, entity: MaintenanceTask) -> MaintenanceTask:
		payload = {
			"entity": serialize_maintenance_task(entity),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.tryAndRecover.modifyMaintenanceTaskBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_maintenance_task(result_info.success)
			return return_value

	async def get_maintenance_task_async(self, entity_id: str) -> Optional[MaintenanceTask]:
		def do_decode(raw_result):
			return deserialize_maintenance_task(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.tryAndRecover.getMaintenanceTaskAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_maintenance_task_blocking(self, entity_id: str) -> Optional[MaintenanceTask]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.tryAndRecover.getMaintenanceTaskBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_maintenance_task(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_maintenance_tasks_async(self, entity_ids: list[str]) -> list[MaintenanceTask]:
		def do_decode(raw_result):
			return [deserialize_maintenance_task(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.tryAndRecover.getMaintenanceTasksAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_maintenance_tasks_blocking(self, entity_ids: list[str]) -> list[MaintenanceTask]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskApi.tryAndRecover.getMaintenanceTasksBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_maintenance_task(x1) for x1 in result_info.success]
			return return_value
