# auto-generated file
import json
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.model import Role
from typing import Optional


class RoleApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def get_permissions_async(self) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RoleApi.getPermissionsAsync,
			self.cardinal_sdk._native,
		)

	def get_permissions_blocking(self) -> list[str]:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RoleApi.getPermissionsBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def get_all_roles_async(self) -> list[Role]:
		def do_decode(raw_result):
			return [Role._deserialize(x1) for x1 in raw_result]
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RoleApi.getAllRolesAsync,
			self.cardinal_sdk._native,
		)

	def get_all_roles_blocking(self) -> list[Role]:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RoleApi.getAllRolesBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [Role._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_all_roles_in_group_async(self, group_id: str) -> list[Role]:
		def do_decode(raw_result):
			return [Role._deserialize(x1) for x1 in raw_result]
		payload = {
			"groupId": group_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RoleApi.getAllRolesInGroupAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_all_roles_in_group_blocking(self, group_id: str) -> list[Role]:
		payload = {
			"groupId": group_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RoleApi.getAllRolesInGroupBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [Role._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_role_async(self, role_id: str) -> Optional[Role]:
		def do_decode(raw_result):
			return Role._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"roleId": role_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RoleApi.getRoleAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_role_blocking(self, role_id: str) -> Optional[Role]:
		payload = {
			"roleId": role_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RoleApi.getRoleBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Role._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_roles_async(self, roles_ids: list[str]) -> list[Role]:
		def do_decode(raw_result):
			return [Role._deserialize(x1) for x1 in raw_result]
		payload = {
			"rolesIds": [x0 for x0 in roles_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RoleApi.getRolesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_roles_blocking(self, roles_ids: list[str]) -> list[Role]:
		payload = {
			"rolesIds": [x0 for x0 in roles_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RoleApi.getRolesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [Role._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def create_role_async(self, name: str, permissions: set[str], inherits_up_to: Optional[int] = None) -> Role:
		def do_decode(raw_result):
			return Role._deserialize(raw_result)
		payload = {
			"name": name,
			"permissions": [x0 for x0 in permissions],
			"inheritsUpTo": inherits_up_to,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RoleApi.createRoleAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_role_blocking(self, name: str, permissions: set[str], inherits_up_to: Optional[int] = None) -> Role:
		payload = {
			"name": name,
			"permissions": [x0 for x0 in permissions],
			"inheritsUpTo": inherits_up_to,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RoleApi.createRoleBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Role._deserialize(result_info.success)
			return return_value

	async def create_role_in_group_async(self, group_id: str, name: str, permissions: set[str], inherits_up_to: Optional[int] = None) -> Role:
		def do_decode(raw_result):
			return Role._deserialize(raw_result)
		payload = {
			"groupId": group_id,
			"name": name,
			"permissions": [x0 for x0 in permissions],
			"inheritsUpTo": inherits_up_to,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RoleApi.createRoleInGroupAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_role_in_group_blocking(self, group_id: str, name: str, permissions: set[str], inherits_up_to: Optional[int] = None) -> Role:
		payload = {
			"groupId": group_id,
			"name": name,
			"permissions": [x0 for x0 in permissions],
			"inheritsUpTo": inherits_up_to,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RoleApi.createRoleInGroupBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Role._deserialize(result_info.success)
			return return_value

	async def modify_role_permissions_async(self, role_id: str, permissions: set[str]) -> Role:
		def do_decode(raw_result):
			return Role._deserialize(raw_result)
		payload = {
			"roleId": role_id,
			"permissions": [x0 for x0 in permissions],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RoleApi.modifyRolePermissionsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_role_permissions_blocking(self, role_id: str, permissions: set[str]) -> Role:
		payload = {
			"roleId": role_id,
			"permissions": [x0 for x0 in permissions],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RoleApi.modifyRolePermissionsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Role._deserialize(result_info.success)
			return return_value

	async def purge_role_async(self, role_id: str, rev: str) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"roleId": role_id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RoleApi.purgeRoleAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_role_blocking(self, role_id: str, rev: str) -> None:
		payload = {
			"roleId": role_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RoleApi.purgeRoleBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
