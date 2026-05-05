# auto-generated file
import json
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model import Group, DatabaseInitialisation, GroupType, RegistrationInformation, RegistrationSuccess, Operation, UserType, RoleConfiguration, GroupDeletionReport, ListOfProperties, DesignDocument, IdWithRev, GroupDatabasesInfo, ReplicationInfo, DocIdentifier, ExternalJwtConfig, CodeStub
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from typing import Optional


class GroupApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def list_groups_async(self) -> list[Group]:
		def do_decode(raw_result):
			return [Group._deserialize(x1) for x1 in raw_result]
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.listGroupsAsync,
			self.cardinal_sdk._native,
		)

	def list_groups_blocking(self) -> list[Group]:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.listGroupsBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [Group._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_group_async(self, id: str) -> Group:
		def do_decode(raw_result):
			return Group._deserialize(raw_result)
		payload = {
			"id": id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.getGroupAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_group_blocking(self, id: str) -> Group:
		payload = {
			"id": id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.getGroupBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Group._deserialize(result_info.success)
			return return_value

	async def create_group_async(self, id: str, name: str, password: str, initialisation_data: DatabaseInitialisation, type: Optional[GroupType] = None, server: Optional[str] = None, q: Optional[int] = None, n: Optional[int] = None, super_group: Optional[str] = None, project_id: Optional[str] = None) -> Group:
		def do_decode(raw_result):
			return Group._deserialize(raw_result)
		payload = {
			"id": id,
			"name": name,
			"type": type.__serialize__() if type is not None else None,
			"password": password,
			"server": server,
			"q": q,
			"n": n,
			"superGroup": super_group,
			"projectId": project_id,
			"initialisationData": initialisation_data.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.createGroupAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_group_blocking(self, id: str, name: str, password: str, initialisation_data: DatabaseInitialisation, type: Optional[GroupType] = None, server: Optional[str] = None, q: Optional[int] = None, n: Optional[int] = None, super_group: Optional[str] = None, project_id: Optional[str] = None) -> Group:
		payload = {
			"id": id,
			"name": name,
			"type": type.__serialize__() if type is not None else None,
			"password": password,
			"server": server,
			"q": q,
			"n": n,
			"superGroup": super_group,
			"projectId": project_id,
			"initialisationData": initialisation_data.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.createGroupBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Group._deserialize(result_info.success)
			return return_value

	async def register_new_group_administrator_async(self, registration_information: RegistrationInformation, type: Optional[GroupType] = None) -> RegistrationSuccess:
		def do_decode(raw_result):
			return RegistrationSuccess._deserialize(raw_result)
		payload = {
			"type": type.__serialize__() if type is not None else None,
			"registrationInformation": registration_information.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.registerNewGroupAdministratorAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def register_new_group_administrator_blocking(self, registration_information: RegistrationInformation, type: Optional[GroupType] = None) -> RegistrationSuccess:
		payload = {
			"type": type.__serialize__() if type is not None else None,
			"registrationInformation": registration_information.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.registerNewGroupAdministratorBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = RegistrationSuccess._deserialize(result_info.success)
			return return_value

	async def list_apps_async(self) -> list[Group]:
		def do_decode(raw_result):
			return [Group._deserialize(x1) for x1 in raw_result]
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.listAppsAsync,
			self.cardinal_sdk._native,
		)

	def list_apps_blocking(self) -> list[Group]:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.listAppsBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [Group._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_name_of_group_parent_async(self, id: str) -> str:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"id": id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.getNameOfGroupParentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_name_of_group_parent_blocking(self, id: str) -> str:
		payload = {
			"id": id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.getNameOfGroupParentBlocking(
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

	async def modify_group_name_async(self, id: str, name: str) -> Group:
		def do_decode(raw_result):
			return Group._deserialize(raw_result)
		payload = {
			"id": id,
			"name": name,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.modifyGroupNameAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_group_name_blocking(self, id: str, name: str) -> Group:
		payload = {
			"id": id,
			"name": name,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.modifyGroupNameBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Group._deserialize(result_info.success)
			return return_value

	async def get_operation_token_async(self, operation: Operation, duration: Optional[int], description: Optional[str] = None) -> str:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"operation": operation.__serialize__(),
			"duration": duration,
			"description": description,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.getOperationTokenAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_operation_token_blocking(self, operation: Operation, duration: Optional[int], description: Optional[str] = None) -> str:
		payload = {
			"operation": operation.__serialize__(),
			"duration": duration,
			"description": description,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.getOperationTokenBlocking(
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

	async def delete_operation_token_async(self, token_id: str) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"tokenId": token_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.deleteOperationTokenAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_operation_token_blocking(self, token_id: str) -> None:
		payload = {
			"tokenId": token_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.deleteOperationTokenBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def set_default_roles_async(self, group_id: str, user_type: str, role_ids: list[str]) -> Group:
		def do_decode(raw_result):
			return Group._deserialize(raw_result)
		payload = {
			"groupId": group_id,
			"userType": user_type,
			"roleIds": [x0 for x0 in role_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.setDefaultRolesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def set_default_roles_blocking(self, group_id: str, user_type: str, role_ids: list[str]) -> Group:
		payload = {
			"groupId": group_id,
			"userType": user_type,
			"roleIds": [x0 for x0 in role_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.setDefaultRolesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Group._deserialize(result_info.success)
			return return_value

	async def get_default_roles_async(self, group_id: str) -> dict[UserType, list[RoleConfiguration]]:
		def do_decode(raw_result):
			return dict(map(lambda kv1: (UserType._deserialize(kv1[0]), [RoleConfiguration._deserialize(x2) for x2 in kv1[1]]), raw_result.items()))
		payload = {
			"groupId": group_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.getDefaultRolesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_default_roles_blocking(self, group_id: str) -> dict[UserType, list[RoleConfiguration]]:
		payload = {
			"groupId": group_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.getDefaultRolesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = dict(map(lambda kv1: (UserType._deserialize(kv1[0]), [RoleConfiguration._deserialize(x2) for x2 in kv1[1]]), result_info.success.items()))
			return return_value

	async def delete_group_async(self, id: str) -> Group:
		def do_decode(raw_result):
			return Group._deserialize(raw_result)
		payload = {
			"id": id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.deleteGroupAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_group_blocking(self, id: str) -> Group:
		payload = {
			"id": id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.deleteGroupBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Group._deserialize(result_info.success)
			return return_value

	async def change_super_group_async(self, child_group_id: str, operation_token: str) -> Group:
		def do_decode(raw_result):
			return Group._deserialize(raw_result)
		payload = {
			"childGroupId": child_group_id,
			"operationToken": operation_token,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.changeSuperGroupAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def change_super_group_blocking(self, child_group_id: str, operation_token: str) -> Group:
		payload = {
			"childGroupId": child_group_id,
			"operationToken": operation_token,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.changeSuperGroupBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Group._deserialize(result_info.success)
			return return_value

	async def hard_delete_group_async(self, id: str) -> list[GroupDeletionReport]:
		def do_decode(raw_result):
			return [GroupDeletionReport._deserialize(x1) for x1 in raw_result]
		payload = {
			"id": id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.hardDeleteGroupAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def hard_delete_group_blocking(self, id: str) -> list[GroupDeletionReport]:
		payload = {
			"id": id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.hardDeleteGroupBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupDeletionReport._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def modify_group_properties_async(self, id: str, properties: ListOfProperties) -> Group:
		def do_decode(raw_result):
			return Group._deserialize(raw_result)
		payload = {
			"id": id,
			"properties": properties.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.modifyGroupPropertiesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_group_properties_blocking(self, id: str, properties: ListOfProperties) -> Group:
		payload = {
			"id": id,
			"properties": properties.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.modifyGroupPropertiesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Group._deserialize(result_info.success)
			return return_value

	async def set_group_password_async(self, id: str, password: str) -> Group:
		def do_decode(raw_result):
			return Group._deserialize(raw_result)
		payload = {
			"id": id,
			"password": password,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.setGroupPasswordAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def set_group_password_blocking(self, id: str, password: str) -> Group:
		payload = {
			"id": id,
			"password": password,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.setGroupPasswordBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Group._deserialize(result_info.success)
			return return_value

	async def init_design_docs_async(self, id: str, warmup: Optional[bool], dry_run: Optional[bool], clazz: Optional[str] = None) -> list[DesignDocument]:
		def do_decode(raw_result):
			return [DesignDocument._deserialize(x1) for x1 in raw_result]
		payload = {
			"id": id,
			"clazz": clazz,
			"warmup": warmup,
			"dryRun": dry_run,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.initDesignDocsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def init_design_docs_blocking(self, id: str, warmup: Optional[bool], dry_run: Optional[bool], clazz: Optional[str] = None) -> list[DesignDocument]:
		payload = {
			"id": id,
			"clazz": clazz,
			"warmup": warmup,
			"dryRun": dry_run,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.initDesignDocsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DesignDocument._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def solve_conflicts_async(self, id: str, limit: Optional[int], warmup: Optional[bool]) -> list[IdWithRev]:
		def do_decode(raw_result):
			return [IdWithRev._deserialize(x1) for x1 in raw_result]
		payload = {
			"id": id,
			"limit": limit,
			"warmup": warmup,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.solveConflictsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def solve_conflicts_blocking(self, id: str, limit: Optional[int], warmup: Optional[bool]) -> list[IdWithRev]:
		payload = {
			"id": id,
			"limit": limit,
			"warmup": warmup,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.solveConflictsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [IdWithRev._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def reset_storage_async(self, id: str, databases: list[str], q: Optional[int] = None, n: Optional[int] = None) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"id": id,
			"q": q,
			"n": n,
			"databases": [x0 for x0 in databases],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.resetStorageAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def reset_storage_blocking(self, id: str, databases: list[str], q: Optional[int] = None, n: Optional[int] = None) -> None:
		payload = {
			"id": id,
			"q": q,
			"n": n,
			"databases": [x0 for x0 in databases],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.resetStorageBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def get_groups_storage_infos_async(self, groups: list[str]) -> list[GroupDatabasesInfo]:
		def do_decode(raw_result):
			return [GroupDatabasesInfo._deserialize(x1) for x1 in raw_result]
		payload = {
			"groups": [x0 for x0 in groups],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.getGroupsStorageInfosAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_groups_storage_infos_blocking(self, groups: list[str]) -> list[GroupDatabasesInfo]:
		payload = {
			"groups": [x0 for x0 in groups],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.getGroupsStorageInfosBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupDatabasesInfo._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_replication_info_async(self, id: str) -> ReplicationInfo:
		def do_decode(raw_result):
			return ReplicationInfo._deserialize(raw_result)
		payload = {
			"id": id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.getReplicationInfoAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_replication_info_blocking(self, id: str) -> ReplicationInfo:
		payload = {
			"id": id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.getReplicationInfoBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = ReplicationInfo._deserialize(result_info.success)
			return return_value

	async def get_hierarchy_async(self, id: str) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"id": id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.getHierarchyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_hierarchy_blocking(self, id: str) -> list[str]:
		payload = {
			"id": id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.getHierarchyBlocking(
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

	async def list_all_groups_ids_async(self) -> list[DocIdentifier]:
		def do_decode(raw_result):
			return [DocIdentifier._deserialize(x1) for x1 in raw_result]
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.listAllGroupsIdsAsync,
			self.cardinal_sdk._native,
		)

	def list_all_groups_ids_blocking(self) -> list[DocIdentifier]:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.listAllGroupsIdsBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DocIdentifier._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def create_or_update_external_jwt_config_async(self, group_id: str, key: str, config: ExternalJwtConfig) -> Group:
		def do_decode(raw_result):
			return Group._deserialize(raw_result)
		payload = {
			"groupId": group_id,
			"key": key,
			"config": config.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.createOrUpdateExternalJwtConfigAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_or_update_external_jwt_config_blocking(self, group_id: str, key: str, config: ExternalJwtConfig) -> Group:
		payload = {
			"groupId": group_id,
			"key": key,
			"config": config.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.createOrUpdateExternalJwtConfigBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Group._deserialize(result_info.success)
			return return_value

	async def remove_external_jwt_config_async(self, group_id: str, key: str) -> Group:
		def do_decode(raw_result):
			return Group._deserialize(raw_result)
		payload = {
			"groupId": group_id,
			"key": key,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.removeExternalJwtConfigAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def remove_external_jwt_config_blocking(self, group_id: str, key: str) -> Group:
		payload = {
			"groupId": group_id,
			"key": key,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.removeExternalJwtConfigBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Group._deserialize(result_info.success)
			return return_value

	async def get_operation_token_for_group_async(self, group_id: str, operation: Operation, duration: Optional[int], description: Optional[str]) -> str:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"groupId": group_id,
			"operation": operation.__serialize__(),
			"duration": duration,
			"description": description,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.getOperationTokenForGroupAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_operation_token_for_group_blocking(self, group_id: str, operation: Operation, duration: Optional[int], description: Optional[str]) -> str:
		payload = {
			"groupId": group_id,
			"operation": operation.__serialize__(),
			"duration": duration,
			"description": description,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.getOperationTokenForGroupBlocking(
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

	async def set_group_project_id_async(self, group_id: str, project_id: Optional[str], apply_to_subgroups: bool) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"groupId": group_id,
			"projectId": project_id,
			"applyToSubgroups": apply_to_subgroups,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.setGroupProjectIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def set_group_project_id_blocking(self, group_id: str, project_id: Optional[str], apply_to_subgroups: bool) -> None:
		payload = {
			"groupId": group_id,
			"projectId": project_id,
			"applyToSubgroups": apply_to_subgroups,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.setGroupProjectIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def modify_group_application_id_async(self, id: str, application_id: str) -> Group:
		def do_decode(raw_result):
			return Group._deserialize(raw_result)
		payload = {
			"id": id,
			"applicationId": application_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.modifyGroupApplicationIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_group_application_id_blocking(self, id: str, application_id: str) -> Group:
		payload = {
			"id": id,
			"applicationId": application_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.modifyGroupApplicationIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Group._deserialize(result_info.success)
			return return_value

	async def add_tag_to_group_async(self, id: str, rev: str, tag: CodeStub) -> Group:
		def do_decode(raw_result):
			return Group._deserialize(raw_result)
		payload = {
			"id": id,
			"rev": rev,
			"tag": tag.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.addTagToGroupAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def add_tag_to_group_blocking(self, id: str, rev: str, tag: CodeStub) -> Group:
		payload = {
			"id": id,
			"rev": rev,
			"tag": tag.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.addTagToGroupBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Group._deserialize(result_info.success)
			return return_value

	async def remove_tag_from_group_async(self, id: str, rev: str, tag_id: str) -> Group:
		def do_decode(raw_result):
			return Group._deserialize(raw_result)
		payload = {
			"id": id,
			"rev": rev,
			"tagId": tag_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.removeTagFromGroupAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def remove_tag_from_group_blocking(self, id: str, rev: str, tag_id: str) -> Group:
		payload = {
			"id": id,
			"rev": rev,
			"tagId": tag_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.GroupApi.removeTagFromGroupBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Group._deserialize(result_info.success)
			return return_value
