# auto-generated file
import json
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model import User, EncryptedPropertyStub, UserGroup, Enable2faRequest, StoredDocumentIdentifier, SubscriptionEventType, EntitySubscriptionConfiguration, GroupScoped, TokenWithGroup, LoginIdentifier
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from typing import Optional
from cardinal_sdk.filters.FilterOptions import BaseFilterOptions, BaseSortableFilterOptions, FilterOptions
from cardinal_sdk.pagination.PaginatedListIterator import PaginatedListIterator
from cardinal_sdk.subscription.EntitySubscription import EntitySubscription


class UserApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk
		self.in_group = UserApiInGroup(self.cardinal_sdk)

	async def get_current_user_async(self) -> User:
		def do_decode(raw_result):
			return User._deserialize(raw_result)
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getCurrentUserAsync,
			self.cardinal_sdk._native,
		)

	def get_current_user_blocking(self) -> User:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getCurrentUserBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success)
			return return_value

	async def create_user_async(self, user: User) -> User:
		def do_decode(raw_result):
			return User._deserialize(raw_result)
		payload = {
			"user": user.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.createUserAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_user_blocking(self, user: User) -> User:
		payload = {
			"user": user.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.createUserBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success)
			return return_value

	async def create_users_async(self, users: list[User]) -> list[User]:
		def do_decode(raw_result):
			return [User._deserialize(x1) for x1 in raw_result]
		payload = {
			"users": [x0.__serialize__() for x0 in users],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.createUsersAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_users_blocking(self, users: list[User]) -> list[User]:
		payload = {
			"users": [x0.__serialize__() for x0 in users],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.createUsersBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [User._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_user_async(self, user_id: str) -> Optional[User]:
		def do_decode(raw_result):
			return User._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"userId": user_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getUserAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_user_blocking(self, user_id: str) -> Optional[User]:
		payload = {
			"userId": user_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getUserBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_users_async(self, user_ids: list[str]) -> list[User]:
		def do_decode(raw_result):
			return [User._deserialize(x1) for x1 in raw_result]
		payload = {
			"userIds": [x0 for x0 in user_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getUsersAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_users_blocking(self, user_ids: list[str]) -> list[User]:
		payload = {
			"userIds": [x0 for x0 in user_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getUsersBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [User._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def modify_user_async(self, user: User) -> User:
		def do_decode(raw_result):
			return User._deserialize(raw_result)
		payload = {
			"user": user.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.modifyUserAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_user_blocking(self, user: User) -> User:
		payload = {
			"user": user.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.modifyUserBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success)
			return return_value

	async def modify_users_async(self, users: list[User]) -> list[User]:
		def do_decode(raw_result):
			return [User._deserialize(x1) for x1 in raw_result]
		payload = {
			"users": [x0.__serialize__() for x0 in users],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.modifyUsersAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_users_blocking(self, users: list[User]) -> list[User]:
		payload = {
			"users": [x0.__serialize__() for x0 in users],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.modifyUsersBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [User._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_user_by_email_async(self, email: str) -> Optional[User]:
		def do_decode(raw_result):
			return User._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"email": email,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getUserByEmailAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_user_by_email_blocking(self, email: str) -> Optional[User]:
		payload = {
			"email": email,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getUserByEmailBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_user_by_phone_number_async(self, phone_number: str) -> Optional[User]:
		def do_decode(raw_result):
			return User._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"phoneNumber": phone_number,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getUserByPhoneNumberAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_user_by_phone_number_blocking(self, phone_number: str) -> Optional[User]:
		payload = {
			"phoneNumber": phone_number,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getUserByPhoneNumberBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def find_by_hcparty_id_async(self, id: str) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"id": id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.findByHcpartyIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def find_by_hcparty_id_blocking(self, id: str) -> list[str]:
		payload = {
			"id": id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.findByHcpartyIdBlocking(
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

	async def find_by_patient_id_async(self, id: str) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"id": id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.findByPatientIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def find_by_patient_id_blocking(self, id: str) -> list[str]:
		payload = {
			"id": id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.findByPatientIdBlocking(
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

	async def assign_healthcare_party_async(self, healthcare_party_id: str) -> User:
		def do_decode(raw_result):
			return User._deserialize(raw_result)
		payload = {
			"healthcarePartyId": healthcare_party_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.assignHealthcarePartyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def assign_healthcare_party_blocking(self, healthcare_party_id: str) -> User:
		payload = {
			"healthcarePartyId": healthcare_party_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.assignHealthcarePartyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success)
			return return_value

	async def modify_properties_async(self, user_id: str, properties: Optional[list[EncryptedPropertyStub]]) -> User:
		def do_decode(raw_result):
			return User._deserialize(raw_result)
		payload = {
			"userId": user_id,
			"properties": [x0.__serialize__() for x0 in properties] if properties is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.modifyPropertiesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_properties_blocking(self, user_id: str, properties: Optional[list[EncryptedPropertyStub]]) -> User:
		payload = {
			"userId": user_id,
			"properties": [x0.__serialize__() for x0 in properties] if properties is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.modifyPropertiesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success)
			return return_value

	async def get_token_async(self, user_id: str, key: str, token_validity: Optional[int] = None, token: Optional[str] = None) -> str:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"userId": user_id,
			"key": key,
			"tokenValidity": token_validity,
			"token": token,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getTokenAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_token_blocking(self, user_id: str, key: str, token_validity: Optional[int] = None, token: Optional[str] = None) -> str:
		payload = {
			"userId": user_id,
			"key": key,
			"tokenValidity": token_validity,
			"token": token,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getTokenBlocking(
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

	async def filter_users_by_async(self, filter: BaseFilterOptions[User]) -> PaginatedListIterator[User]:
		def do_decode(raw_result):
			return PaginatedListIterator[User](
				producer = raw_result,
				deserializer = lambda x: User._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.filterUsersByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_users_by_blocking(self, filter: BaseFilterOptions[User]) -> PaginatedListIterator[User]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.filterUsersByBlocking(
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
			return PaginatedListIterator[User](
				producer = class_pointer,
				deserializer = lambda x: User._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def match_users_by_async(self, filter: BaseFilterOptions[User]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.matchUsersByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_users_by_blocking(self, filter: BaseFilterOptions[User]) -> list[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.matchUsersByBlocking(
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

	async def filter_users_by_sorted_async(self, filter: BaseSortableFilterOptions[User]) -> PaginatedListIterator[User]:
		def do_decode(raw_result):
			return PaginatedListIterator[User](
				producer = raw_result,
				deserializer = lambda x: User._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.filterUsersBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_users_by_sorted_blocking(self, filter: BaseSortableFilterOptions[User]) -> PaginatedListIterator[User]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.filterUsersBySortedBlocking(
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
			return PaginatedListIterator[User](
				producer = class_pointer,
				deserializer = lambda x: User._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def match_users_by_sorted_async(self, filter: BaseSortableFilterOptions[User]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.matchUsersBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_users_by_sorted_blocking(self, filter: BaseSortableFilterOptions[User]) -> list[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.matchUsersBySortedBlocking(
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

	async def get_matching_users_async(self) -> list[UserGroup]:
		def do_decode(raw_result):
			return [UserGroup._deserialize(x1) for x1 in raw_result]
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getMatchingUsersAsync,
			self.cardinal_sdk._native,
		)

	def get_matching_users_blocking(self) -> list[UserGroup]:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getMatchingUsersBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [UserGroup._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def set_user_roles_async(self, user_id: str, roles_ids: list[str]) -> User:
		def do_decode(raw_result):
			return User._deserialize(raw_result)
		payload = {
			"userId": user_id,
			"rolesIds": [x0 for x0 in roles_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.setUserRolesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def set_user_roles_blocking(self, user_id: str, roles_ids: list[str]) -> User:
		payload = {
			"userId": user_id,
			"rolesIds": [x0 for x0 in roles_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.setUserRolesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success)
			return return_value

	async def reset_user_roles_async(self, user_id: str) -> User:
		def do_decode(raw_result):
			return User._deserialize(raw_result)
		payload = {
			"userId": user_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.resetUserRolesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def reset_user_roles_blocking(self, user_id: str) -> User:
		payload = {
			"userId": user_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.resetUserRolesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success)
			return return_value

	async def enable2fa_for_user_async(self, user_id: str, request: Enable2faRequest) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"userId": user_id,
			"request": request.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.enable2faForUserAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def enable2fa_for_user_blocking(self, user_id: str, request: Enable2faRequest) -> None:
		payload = {
			"userId": user_id,
			"request": request.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.enable2faForUserBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def disable2fa_for_user_async(self, user_id: str) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"userId": user_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.disable2faForUserAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def disable2fa_for_user_blocking(self, user_id: str) -> None:
		payload = {
			"userId": user_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.disable2faForUserBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def create_admin_user_async(self, user: User) -> User:
		def do_decode(raw_result):
			return User._deserialize(raw_result)
		payload = {
			"user": user.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.createAdminUserAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_admin_user_blocking(self, user: User) -> User:
		payload = {
			"user": user.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.createAdminUserBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success)
			return return_value

	async def modify_user_password_async(self, user_id: str, new_password: str) -> User:
		def do_decode(raw_result):
			return User._deserialize(raw_result)
		payload = {
			"userId": user_id,
			"newPassword": new_password,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.modifyUserPasswordAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_user_password_blocking(self, user_id: str, new_password: str) -> User:
		payload = {
			"userId": user_id,
			"newPassword": new_password,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.modifyUserPasswordBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success)
			return return_value

	async def modify_user_email_async(self, user_id: str, new_email: str, previous_email: Optional[str]) -> User:
		def do_decode(raw_result):
			return User._deserialize(raw_result)
		payload = {
			"userId": user_id,
			"newEmail": new_email,
			"previousEmail": previous_email,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.modifyUserEmailAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_user_email_blocking(self, user_id: str, new_email: str, previous_email: Optional[str]) -> User:
		payload = {
			"userId": user_id,
			"newEmail": new_email,
			"previousEmail": previous_email,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.modifyUserEmailBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success)
			return return_value

	async def modify_user_mobile_phone_async(self, user_id: str, new_mobile_phone: str, previous_mobile_phone: Optional[str]) -> User:
		def do_decode(raw_result):
			return User._deserialize(raw_result)
		payload = {
			"userId": user_id,
			"newMobilePhone": new_mobile_phone,
			"previousMobilePhone": previous_mobile_phone,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.modifyUserMobilePhoneAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_user_mobile_phone_blocking(self, user_id: str, new_mobile_phone: str, previous_mobile_phone: Optional[str]) -> User:
		payload = {
			"userId": user_id,
			"newMobilePhone": new_mobile_phone,
			"previousMobilePhone": previous_mobile_phone,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.modifyUserMobilePhoneBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success)
			return return_value

	async def delete_user_by_id_async(self, entity_id: str, rev: str) -> StoredDocumentIdentifier:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.deleteUserByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_user_by_id_blocking(self, entity_id: str, rev: str) -> StoredDocumentIdentifier:
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.deleteUserByIdBlocking(
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

	async def delete_users_by_ids_async(self, user_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"userIds": [x0.__serialize__() for x0 in user_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.deleteUsersByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_users_by_ids_blocking(self, user_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		payload = {
			"userIds": [x0.__serialize__() for x0 in user_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.deleteUsersByIdsBlocking(
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

	async def purge_user_by_id_async(self, id: str, rev: str) -> None:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.purgeUserByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_user_by_id_blocking(self, id: str, rev: str) -> None:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.purgeUserByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_users_by_ids_async(self, user_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"userIds": [x0.__serialize__() for x0 in user_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.purgeUsersByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_users_by_ids_blocking(self, user_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		payload = {
			"userIds": [x0.__serialize__() for x0 in user_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.purgeUsersByIdsBlocking(
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

	async def undelete_user_by_id_async(self, id: str, rev: str) -> User:
		def do_decode(raw_result):
			return User._deserialize(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.undeleteUserByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_user_by_id_blocking(self, id: str, rev: str) -> User:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.undeleteUserByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success)
			return return_value

	async def undelete_users_by_ids_async(self, user_ids: list[StoredDocumentIdentifier]) -> list[User]:
		def do_decode(raw_result):
			return [User._deserialize(x1) for x1 in raw_result]
		payload = {
			"userIds": [x0.__serialize__() for x0 in user_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.undeleteUsersByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_users_by_ids_blocking(self, user_ids: list[StoredDocumentIdentifier]) -> list[User]:
		payload = {
			"userIds": [x0.__serialize__() for x0 in user_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.undeleteUsersByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [User._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def delete_user_async(self, user: User) -> StoredDocumentIdentifier:
		def do_decode(raw_result):
			return StoredDocumentIdentifier._deserialize(raw_result)
		payload = {
			"user": user.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.deleteUserAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_user_blocking(self, user: User) -> StoredDocumentIdentifier:
		payload = {
			"user": user.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.deleteUserBlocking(
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

	async def delete_users_async(self, users: list[User]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"users": [x0.__serialize__() for x0 in users],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.deleteUsersAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_users_blocking(self, users: list[User]) -> list[StoredDocumentIdentifier]:
		payload = {
			"users": [x0.__serialize__() for x0 in users],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.deleteUsersBlocking(
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

	async def purge_user_async(self, user: User) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"user": user.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.purgeUserAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_user_blocking(self, user: User) -> None:
		payload = {
			"user": user.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.purgeUserBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_users_async(self, users: list[User]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"users": [x0.__serialize__() for x0 in users],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.purgeUsersAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_users_blocking(self, users: list[User]) -> list[StoredDocumentIdentifier]:
		payload = {
			"users": [x0.__serialize__() for x0 in users],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.purgeUsersBlocking(
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

	async def undelete_user_async(self, user: User) -> User:
		def do_decode(raw_result):
			return User._deserialize(raw_result)
		payload = {
			"user": user.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.undeleteUserAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_user_blocking(self, user: User) -> User:
		payload = {
			"user": user.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.undeleteUserBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success)
			return return_value

	async def undelete_users_async(self, users: list[User]) -> list[User]:
		def do_decode(raw_result):
			return [User._deserialize(x1) for x1 in raw_result]
		payload = {
			"users": [x0.__serialize__() for x0 in users],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.undeleteUsersAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_users_blocking(self, users: list[User]) -> list[User]:
		payload = {
			"users": [x0.__serialize__() for x0 in users],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.undeleteUsersBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [User._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def set_external_jwt_auth_by_identifiers_for_current_user_async(self, external_jwt_config_id: str, external_authentication_token: str) -> bool:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"externalJwtConfigId": external_jwt_config_id,
			"externalAuthenticationToken": external_authentication_token,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.setExternalJwtAuthByIdentifiersForCurrentUserAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def set_external_jwt_auth_by_identifiers_for_current_user_blocking(self, external_jwt_config_id: str, external_authentication_token: str) -> bool:
		payload = {
			"externalJwtConfigId": external_jwt_config_id,
			"externalAuthenticationToken": external_authentication_token,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.setExternalJwtAuthByIdentifiersForCurrentUserBlocking(
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

	async def subscribe_to_events_async(self, events: set[SubscriptionEventType], filter: FilterOptions[User], subscription_config: Optional[EntitySubscriptionConfiguration] = None) -> EntitySubscription[User]:
		def do_decode(raw_result):
			return EntitySubscription[User](
				producer = raw_result,
				deserializer = lambda x: User._deserialize(x),
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.subscribeToEventsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def subscribe_to_events_blocking(self, events: set[SubscriptionEventType], filter: FilterOptions[User], subscription_config: Optional[EntitySubscriptionConfiguration] = None) -> EntitySubscription[User]:
		payload = {
			"events": [x0.__serialize__() for x0 in events],
			"filter": filter.__serialize__(),
			"subscriptionConfig": subscription_config.__serialize__() if subscription_config is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.subscribeToEventsBlocking(
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
			return EntitySubscription[User](
				producer = class_pointer,
				deserializer = lambda x: User._deserialize(x),
				executor = self.cardinal_sdk._executor
			)


class UserApiInGroup:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def create_user_async(self, user: GroupScoped[User]) -> GroupScoped[User]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: User._deserialize(x1))
		payload = {
			"user": user.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.createUserAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_user_blocking(self, user: GroupScoped[User]) -> GroupScoped[User]:
		payload = {
			"user": user.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.createUserBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: User._deserialize(x1))
			return return_value

	async def create_users_async(self, users: list[GroupScoped[User]]) -> list[GroupScoped[User]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: User._deserialize(x2)) for x1 in raw_result]
		payload = {
			"users": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in users],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.createUsersAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_users_blocking(self, users: list[GroupScoped[User]]) -> list[GroupScoped[User]]:
		payload = {
			"users": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in users],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.createUsersBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: User._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def get_user_async(self, group_id: str, user_id: str) -> Optional[GroupScoped[User]]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: User._deserialize(x1)) if raw_result is not None else None
		payload = {
			"groupId": group_id,
			"userId": user_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.getUserAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_user_blocking(self, group_id: str, user_id: str) -> Optional[GroupScoped[User]]:
		payload = {
			"groupId": group_id,
			"userId": user_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.getUserBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: User._deserialize(x1)) if result_info.success is not None else None
			return return_value

	async def get_users_async(self, group_id: str, user_ids: list[str]) -> list[GroupScoped[User]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: User._deserialize(x2)) for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"userIds": [x0 for x0 in user_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.getUsersAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_users_blocking(self, group_id: str, user_ids: list[str]) -> list[GroupScoped[User]]:
		payload = {
			"groupId": group_id,
			"userIds": [x0 for x0 in user_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.getUsersBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: User._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def modify_user_async(self, user: GroupScoped[User]) -> GroupScoped[User]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: User._deserialize(x1))
		payload = {
			"user": user.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.modifyUserAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_user_blocking(self, user: GroupScoped[User]) -> GroupScoped[User]:
		payload = {
			"user": user.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.modifyUserBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: User._deserialize(x1))
			return return_value

	async def modify_users_async(self, users: list[GroupScoped[User]]) -> list[GroupScoped[User]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: User._deserialize(x2)) for x1 in raw_result]
		payload = {
			"users": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in users],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.modifyUsersAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_users_blocking(self, users: list[GroupScoped[User]]) -> list[GroupScoped[User]]:
		payload = {
			"users": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in users],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.modifyUsersBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: User._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def delete_user_by_id_async(self, user_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: StoredDocumentIdentifier._deserialize(x1))
		payload = {
			"userId": user_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.deleteUserByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_user_by_id_blocking(self, user_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[StoredDocumentIdentifier]:
		payload = {
			"userId": user_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.deleteUserByIdBlocking(
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

	async def delete_users_by_ids_async(self, user_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"userIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in user_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.deleteUsersByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_users_by_ids_blocking(self, user_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"userIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in user_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.deleteUsersByIdsBlocking(
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

	async def delete_user_async(self, user: GroupScoped[User]) -> GroupScoped[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: StoredDocumentIdentifier._deserialize(x1))
		payload = {
			"user": user.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.deleteUserAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_user_blocking(self, user: GroupScoped[User]) -> GroupScoped[StoredDocumentIdentifier]:
		payload = {
			"user": user.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.deleteUserBlocking(
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

	async def delete_users_async(self, users: list[GroupScoped[User]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"users": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in users],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.deleteUsersAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_users_blocking(self, users: list[GroupScoped[User]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"users": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in users],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.deleteUsersBlocking(
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

	async def purge_user_by_id_async(self, user_id: GroupScoped[StoredDocumentIdentifier]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"userId": user_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.purgeUserByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_user_by_id_blocking(self, user_id: GroupScoped[StoredDocumentIdentifier]) -> None:
		payload = {
			"userId": user_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.purgeUserByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_users_by_ids_async(self, user_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"userIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in user_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.purgeUsersByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_users_by_ids_blocking(self, user_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"userIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in user_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.purgeUsersByIdsBlocking(
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

	async def purge_user_async(self, user: GroupScoped[User]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"user": user.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.purgeUserAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_user_blocking(self, user: GroupScoped[User]) -> None:
		payload = {
			"user": user.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.purgeUserBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_users_async(self, user_ids: list[GroupScoped[User]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"userIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in user_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.purgeUsersAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_users_blocking(self, user_ids: list[GroupScoped[User]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"userIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in user_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.purgeUsersBlocking(
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

	async def undelete_user_by_id_async(self, user_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[User]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: User._deserialize(x1))
		payload = {
			"userId": user_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.undeleteUserByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_user_by_id_blocking(self, user_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[User]:
		payload = {
			"userId": user_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.undeleteUserByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: User._deserialize(x1))
			return return_value

	async def undelete_users_by_ids_async(self, user_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[User]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: User._deserialize(x2)) for x1 in raw_result]
		payload = {
			"userIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in user_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.undeleteUsersByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_users_by_ids_blocking(self, user_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[User]]:
		payload = {
			"userIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in user_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.undeleteUsersByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: User._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def undelete_user_async(self, user: GroupScoped[User]) -> GroupScoped[User]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: User._deserialize(x1))
		payload = {
			"user": user.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.undeleteUserAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_user_blocking(self, user: GroupScoped[User]) -> GroupScoped[User]:
		payload = {
			"user": user.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.undeleteUserBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: User._deserialize(x1))
			return return_value

	async def undelete_users_async(self, users: list[GroupScoped[User]]) -> list[GroupScoped[User]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: User._deserialize(x2)) for x1 in raw_result]
		payload = {
			"users": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in users],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.undeleteUsersAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_users_blocking(self, users: list[GroupScoped[User]]) -> list[GroupScoped[User]]:
		payload = {
			"users": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in users],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.undeleteUsersBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: User._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def filter_users_by_async(self, group_id: str, filter: BaseFilterOptions[User]) -> PaginatedListIterator[GroupScoped[User]]:
		def do_decode(raw_result):
			return PaginatedListIterator[GroupScoped[User]](
				producer = raw_result,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: User._deserialize(x1)),
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.filterUsersByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_users_by_blocking(self, group_id: str, filter: BaseFilterOptions[User]) -> PaginatedListIterator[GroupScoped[User]]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.filterUsersByBlocking(
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
			return PaginatedListIterator[GroupScoped[User]](
				producer = class_pointer,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: User._deserialize(x1)),
				executor = self.cardinal_sdk._executor
			)

	async def match_users_by_async(self, group_id: str, filter: BaseFilterOptions[User]) -> list[str]:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.matchUsersByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_users_by_blocking(self, group_id: str, filter: BaseFilterOptions[User]) -> list[str]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.matchUsersByBlocking(
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

	async def filter_users_by_sorted_async(self, group_id: str, filter: BaseSortableFilterOptions[User]) -> PaginatedListIterator[GroupScoped[User]]:
		def do_decode(raw_result):
			return PaginatedListIterator[GroupScoped[User]](
				producer = raw_result,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: User._deserialize(x1)),
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.filterUsersBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_users_by_sorted_blocking(self, group_id: str, filter: BaseSortableFilterOptions[User]) -> PaginatedListIterator[GroupScoped[User]]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.filterUsersBySortedBlocking(
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
			return PaginatedListIterator[GroupScoped[User]](
				producer = class_pointer,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: User._deserialize(x1)),
				executor = self.cardinal_sdk._executor
			)

	async def match_users_by_sorted_async(self, group_id: str, filter: BaseSortableFilterOptions[User]) -> list[str]:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.matchUsersBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_users_by_sorted_blocking(self, group_id: str, filter: BaseSortableFilterOptions[User]) -> list[str]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.matchUsersBySortedBlocking(
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

	async def set_user_roles_async(self, user: GroupScoped[User], roles_ids: list[str]) -> GroupScoped[User]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: User._deserialize(x1))
		payload = {
			"user": user.__serialize__(lambda x0: x0.__serialize__()),
			"rolesIds": [x0 for x0 in roles_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.setUserRolesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def set_user_roles_blocking(self, user: GroupScoped[User], roles_ids: list[str]) -> GroupScoped[User]:
		payload = {
			"user": user.__serialize__(lambda x0: x0.__serialize__()),
			"rolesIds": [x0 for x0 in roles_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.setUserRolesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: User._deserialize(x1))
			return return_value

	async def reset_user_roles_async(self, user: GroupScoped[User]) -> GroupScoped[User]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: User._deserialize(x1))
		payload = {
			"user": user.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.resetUserRolesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def reset_user_roles_blocking(self, user: GroupScoped[User]) -> GroupScoped[User]:
		payload = {
			"user": user.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.resetUserRolesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: User._deserialize(x1))
			return return_value

	async def get_token_async(self, user_identifier: str, group_id: str, key: str, token: Optional[str] = None, token_validity: Optional[int] = None) -> str:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"userIdentifier": user_identifier,
			"groupId": group_id,
			"key": key,
			"token": token,
			"tokenValidity": token_validity,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.getTokenAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_token_blocking(self, user_identifier: str, group_id: str, key: str, token: Optional[str] = None, token_validity: Optional[int] = None) -> str:
		payload = {
			"userIdentifier": user_identifier,
			"groupId": group_id,
			"key": key,
			"token": token,
			"tokenValidity": token_validity,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.getTokenBlocking(
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

	async def get_token_in_all_groups_async(self, user_identifier: str, key: str, token: Optional[str] = None, token_validity: Optional[int] = None) -> list[TokenWithGroup]:
		def do_decode(raw_result):
			return [TokenWithGroup._deserialize(x1) for x1 in raw_result]
		payload = {
			"userIdentifier": user_identifier,
			"key": key,
			"token": token,
			"tokenValidity": token_validity,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.getTokenInAllGroupsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_token_in_all_groups_blocking(self, user_identifier: str, key: str, token: Optional[str] = None, token_validity: Optional[int] = None) -> list[TokenWithGroup]:
		payload = {
			"userIdentifier": user_identifier,
			"key": key,
			"token": token,
			"tokenValidity": token_validity,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.getTokenInAllGroupsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [TokenWithGroup._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def enable2fa_for_user_async(self, user: GroupScoped[User], request: Enable2faRequest) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"user": user.__serialize__(lambda x0: x0.__serialize__()),
			"request": request.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.enable2faForUserAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def enable2fa_for_user_blocking(self, user: GroupScoped[User], request: Enable2faRequest) -> None:
		payload = {
			"user": user.__serialize__(lambda x0: x0.__serialize__()),
			"request": request.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.enable2faForUserBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def disable2fa_for_user_async(self, user: GroupScoped[User]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"user": user.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.disable2faForUserAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def disable2fa_for_user_blocking(self, user: GroupScoped[User]) -> None:
		payload = {
			"user": user.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.disable2faForUserBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def create_admin_user_async(self, user: GroupScoped[User]) -> GroupScoped[User]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: User._deserialize(x1))
		payload = {
			"user": user.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.createAdminUserAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_admin_user_blocking(self, user: GroupScoped[User]) -> GroupScoped[User]:
		payload = {
			"user": user.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.createAdminUserBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: User._deserialize(x1))
			return return_value

	async def modify_user_password_async(self, group_id: str, user_id: str, new_password: str) -> GroupScoped[User]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: User._deserialize(x1))
		payload = {
			"groupId": group_id,
			"userId": user_id,
			"newPassword": new_password,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.modifyUserPasswordAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_user_password_blocking(self, group_id: str, user_id: str, new_password: str) -> GroupScoped[User]:
		payload = {
			"groupId": group_id,
			"userId": user_id,
			"newPassword": new_password,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.modifyUserPasswordBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: User._deserialize(x1))
			return return_value

	async def modify_user_email_async(self, group_id: str, user_id: str, new_email: str, previous_email: Optional[str]) -> GroupScoped[User]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: User._deserialize(x1))
		payload = {
			"groupId": group_id,
			"userId": user_id,
			"newEmail": new_email,
			"previousEmail": previous_email,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.modifyUserEmailAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_user_email_blocking(self, group_id: str, user_id: str, new_email: str, previous_email: Optional[str]) -> GroupScoped[User]:
		payload = {
			"groupId": group_id,
			"userId": user_id,
			"newEmail": new_email,
			"previousEmail": previous_email,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.modifyUserEmailBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: User._deserialize(x1))
			return return_value

	async def modify_user_mobile_phone_async(self, group_id: str, user_id: str, new_mobile_phone: str, previous_mobile_phone: Optional[str]) -> GroupScoped[User]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: User._deserialize(x1))
		payload = {
			"groupId": group_id,
			"userId": user_id,
			"newMobilePhone": new_mobile_phone,
			"previousMobilePhone": previous_mobile_phone,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.modifyUserMobilePhoneAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_user_mobile_phone_blocking(self, group_id: str, user_id: str, new_mobile_phone: str, previous_mobile_phone: Optional[str]) -> GroupScoped[User]:
		payload = {
			"groupId": group_id,
			"userId": user_id,
			"newMobilePhone": new_mobile_phone,
			"previousMobilePhone": previous_mobile_phone,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.modifyUserMobilePhoneBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: User._deserialize(x1))
			return return_value

	async def set_user_inherits_permissions_async(self, user: GroupScoped[User], value: bool) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"user": user.__serialize__(lambda x0: x0.__serialize__()),
			"value": value,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.setUserInheritsPermissionsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def set_user_inherits_permissions_blocking(self, user: GroupScoped[User], value: bool) -> None:
		payload = {
			"user": user.__serialize__(lambda x0: x0.__serialize__()),
			"value": value,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.setUserInheritsPermissionsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def set_login_identifiers_async(self, user: GroupScoped[User], identifier: LoginIdentifier, replace_existing: bool) -> bool:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"user": user.__serialize__(lambda x0: x0.__serialize__()),
			"identifier": identifier.__serialize__(),
			"replaceExisting": replace_existing,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.setLoginIdentifiersAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def set_login_identifiers_blocking(self, user: GroupScoped[User], identifier: LoginIdentifier, replace_existing: bool) -> bool:
		payload = {
			"user": user.__serialize__(lambda x0: x0.__serialize__()),
			"identifier": identifier.__serialize__(),
			"replaceExisting": replace_existing,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.inGroup.setLoginIdentifiersBlocking(
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
