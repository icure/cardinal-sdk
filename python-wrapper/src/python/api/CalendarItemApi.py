# auto-generated file
import json
from typing import Optional
from cardinal_sdk.model import DecryptedCalendarItem, Patient, User, AccessLevel, SecretIdUseOption, SecretIdUseOptionUseAnySharedWithParent, serialize_patient, serialize_secret_id_use_option, CalendarItem, serialize_calendar_item, EntityReferenceInGroup, EncryptedCalendarItem, deserialize_calendar_item, StoredDocumentIdentifier, CalendarItemShareOptions, SubscriptionEventType, EntitySubscriptionConfiguration, GroupScoped
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.model.specializations import HexString
from cardinal_sdk.filters.FilterOptions import FilterOptions, SortableFilterOptions
from cardinal_sdk.pagination.PaginatedListIterator import PaginatedListIterator
from cardinal_sdk.subscription.EntitySubscription import EntitySubscription


class CalendarItemApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk
		self.encrypted = CalendarItemApiEncrypted(self.cardinal_sdk)
		self.try_and_recover = CalendarItemApiTryAndRecover(self.cardinal_sdk)
		self.in_group = CalendarItemApiInGroup(self.cardinal_sdk)

	async def with_encryption_metadata_async(self, base: Optional[DecryptedCalendarItem], patient: Optional[Patient], user: Optional[User] = None, delegates: dict[str, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent(), alternate_root_delegate_id: Optional[str] = None) -> DecryptedCalendarItem:
		def do_decode(raw_result):
			return DecryptedCalendarItem._deserialize(raw_result)
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient) if patient is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": serialize_secret_id_use_option(secret_id),
			"alternateRootDelegateId": alternate_root_delegate_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.withEncryptionMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def with_encryption_metadata_blocking(self, base: Optional[DecryptedCalendarItem], patient: Optional[Patient], user: Optional[User] = None, delegates: dict[str, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent(), alternate_root_delegate_id: Optional[str] = None) -> DecryptedCalendarItem:
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient) if patient is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": serialize_secret_id_use_option(secret_id),
			"alternateRootDelegateId": alternate_root_delegate_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.withEncryptionMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedCalendarItem._deserialize(result_info.success)
			return return_value

	async def get_encryption_keys_of_async(self, calendar_item: CalendarItem) -> set[HexString]:
		def do_decode(raw_result):
			return {x1 for x1 in raw_result}
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.getEncryptionKeysOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_encryption_keys_of_blocking(self, calendar_item: CalendarItem) -> set[HexString]:
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.getEncryptionKeysOfBlocking(
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

	async def has_write_access_async(self, calendar_item: CalendarItem) -> bool:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.hasWriteAccessAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def has_write_access_blocking(self, calendar_item: CalendarItem) -> bool:
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.hasWriteAccessBlocking(
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

	async def decrypt_patient_id_of_async(self, calendar_item: CalendarItem) -> set[EntityReferenceInGroup]:
		def do_decode(raw_result):
			return {EntityReferenceInGroup._deserialize(x1) for x1 in raw_result}
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.decryptPatientIdOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_patient_id_of_blocking(self, calendar_item: CalendarItem) -> set[EntityReferenceInGroup]:
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.decryptPatientIdOfBlocking(
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

	async def create_delegation_de_anonymization_metadata_async(self, entity: CalendarItem, delegates: set[str]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"entity": serialize_calendar_item(entity),
			"delegates": [x0 for x0 in delegates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.createDelegationDeAnonymizationMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_delegation_de_anonymization_metadata_blocking(self, entity: CalendarItem, delegates: set[str]) -> None:
		payload = {
			"entity": serialize_calendar_item(entity),
			"delegates": [x0 for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.createDelegationDeAnonymizationMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def decrypt_async(self, calendar_items: list[EncryptedCalendarItem]) -> list[DecryptedCalendarItem]:
		def do_decode(raw_result):
			return [DecryptedCalendarItem._deserialize(x1) for x1 in raw_result]
		payload = {
			"calendarItems": [x0.__serialize__() for x0 in calendar_items],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.decryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_blocking(self, calendar_items: list[EncryptedCalendarItem]) -> list[DecryptedCalendarItem]:
		payload = {
			"calendarItems": [x0.__serialize__() for x0 in calendar_items],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.decryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedCalendarItem._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def try_decrypt_async(self, calendar_items: list[EncryptedCalendarItem]) -> list[CalendarItem]:
		def do_decode(raw_result):
			return [deserialize_calendar_item(x1) for x1 in raw_result]
		payload = {
			"calendarItems": [x0.__serialize__() for x0 in calendar_items],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.tryDecryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def try_decrypt_blocking(self, calendar_items: list[EncryptedCalendarItem]) -> list[CalendarItem]:
		payload = {
			"calendarItems": [x0.__serialize__() for x0 in calendar_items],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.tryDecryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_calendar_item(x1) for x1 in result_info.success]
			return return_value

	async def encrypt_or_validate_async(self, calendar_items: list[CalendarItem]) -> list[EncryptedCalendarItem]:
		def do_decode(raw_result):
			return [EncryptedCalendarItem._deserialize(x1) for x1 in raw_result]
		payload = {
			"calendarItems": [serialize_calendar_item(x0) for x0 in calendar_items],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.encryptOrValidateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def encrypt_or_validate_blocking(self, calendar_items: list[CalendarItem]) -> list[EncryptedCalendarItem]:
		payload = {
			"calendarItems": [serialize_calendar_item(x0) for x0 in calendar_items],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.encryptOrValidateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedCalendarItem._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def match_calendar_items_by_async(self, filter: FilterOptions[CalendarItem]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.matchCalendarItemsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_calendar_items_by_blocking(self, filter: FilterOptions[CalendarItem]) -> list[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.matchCalendarItemsByBlocking(
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

	async def match_calendar_items_by_sorted_async(self, filter: SortableFilterOptions[CalendarItem]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.matchCalendarItemsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_calendar_items_by_sorted_blocking(self, filter: SortableFilterOptions[CalendarItem]) -> list[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.matchCalendarItemsBySortedBlocking(
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

	async def delete_calendar_item_by_id_async(self, entity_id: str, rev: str) -> StoredDocumentIdentifier:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.deleteCalendarItemByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_calendar_item_by_id_blocking(self, entity_id: str, rev: str) -> StoredDocumentIdentifier:
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.deleteCalendarItemByIdBlocking(
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

	async def delete_calendar_items_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.deleteCalendarItemsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_calendar_items_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.deleteCalendarItemsByIdsBlocking(
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

	async def purge_calendar_item_by_id_async(self, id: str, rev: str) -> None:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.purgeCalendarItemByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_calendar_item_by_id_blocking(self, id: str, rev: str) -> None:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.purgeCalendarItemByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def delete_calendar_item_async(self, calendar_item: CalendarItem) -> StoredDocumentIdentifier:
		def do_decode(raw_result):
			return StoredDocumentIdentifier._deserialize(raw_result)
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.deleteCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_calendar_item_blocking(self, calendar_item: CalendarItem) -> StoredDocumentIdentifier:
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.deleteCalendarItemBlocking(
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

	async def delete_calendar_items_async(self, calendar_items: list[CalendarItem]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"calendarItems": [serialize_calendar_item(x0) for x0 in calendar_items],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.deleteCalendarItemsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_calendar_items_blocking(self, calendar_items: list[CalendarItem]) -> list[StoredDocumentIdentifier]:
		payload = {
			"calendarItems": [serialize_calendar_item(x0) for x0 in calendar_items],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.deleteCalendarItemsBlocking(
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

	async def purge_calendar_item_async(self, calendar_item: CalendarItem) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.purgeCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_calendar_item_blocking(self, calendar_item: CalendarItem) -> None:
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.purgeCalendarItemBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def share_with_async(self, delegate_id: str, calendar_item: DecryptedCalendarItem, options: Optional[CalendarItemShareOptions] = None) -> DecryptedCalendarItem:
		def do_decode(raw_result):
			return DecryptedCalendarItem._deserialize(raw_result)
		payload = {
			"delegateId": delegate_id,
			"calendarItem": calendar_item.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, calendar_item: DecryptedCalendarItem, options: Optional[CalendarItemShareOptions] = None) -> DecryptedCalendarItem:
		payload = {
			"delegateId": delegate_id,
			"calendarItem": calendar_item.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedCalendarItem._deserialize(result_info.success)
			return return_value

	async def share_with_many_async(self, calendar_item: DecryptedCalendarItem, delegates: dict[str, CalendarItemShareOptions]) -> DecryptedCalendarItem:
		def do_decode(raw_result):
			return DecryptedCalendarItem._deserialize(raw_result)
		payload = {
			"calendarItem": calendar_item.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, calendar_item: DecryptedCalendarItem, delegates: dict[str, CalendarItemShareOptions]) -> DecryptedCalendarItem:
		payload = {
			"calendarItem": calendar_item.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedCalendarItem._deserialize(result_info.success)
			return return_value

	async def link_to_patient_async(self, calendar_item: CalendarItem, patient: Patient, share_link_with_delegates: set[str]) -> DecryptedCalendarItem:
		def do_decode(raw_result):
			return DecryptedCalendarItem._deserialize(raw_result)
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
			"patient": serialize_patient(patient),
			"shareLinkWithDelegates": [x0 for x0 in share_link_with_delegates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.linkToPatientAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def link_to_patient_blocking(self, calendar_item: CalendarItem, patient: Patient, share_link_with_delegates: set[str]) -> DecryptedCalendarItem:
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
			"patient": serialize_patient(patient),
			"shareLinkWithDelegates": [x0 for x0 in share_link_with_delegates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.linkToPatientBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedCalendarItem._deserialize(result_info.success)
			return return_value

	async def filter_calendar_items_by_async(self, filter: FilterOptions[CalendarItem]) -> PaginatedListIterator[DecryptedCalendarItem]:
		def do_decode(raw_result):
			return PaginatedListIterator[DecryptedCalendarItem](
				producer = raw_result,
				deserializer = lambda x: DecryptedCalendarItem._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.filterCalendarItemsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_calendar_items_by_blocking(self, filter: FilterOptions[CalendarItem]) -> PaginatedListIterator[DecryptedCalendarItem]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.filterCalendarItemsByBlocking(
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
			return PaginatedListIterator[DecryptedCalendarItem](
				producer = class_pointer,
				deserializer = lambda x: DecryptedCalendarItem._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_calendar_items_by_sorted_async(self, filter: SortableFilterOptions[CalendarItem]) -> PaginatedListIterator[DecryptedCalendarItem]:
		def do_decode(raw_result):
			return PaginatedListIterator[DecryptedCalendarItem](
				producer = raw_result,
				deserializer = lambda x: DecryptedCalendarItem._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.filterCalendarItemsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_calendar_items_by_sorted_blocking(self, filter: SortableFilterOptions[CalendarItem]) -> PaginatedListIterator[DecryptedCalendarItem]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.filterCalendarItemsBySortedBlocking(
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
			return PaginatedListIterator[DecryptedCalendarItem](
				producer = class_pointer,
				deserializer = lambda x: DecryptedCalendarItem._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def create_calendar_item_async(self, entity: DecryptedCalendarItem) -> DecryptedCalendarItem:
		def do_decode(raw_result):
			return DecryptedCalendarItem._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.createCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_calendar_item_blocking(self, entity: DecryptedCalendarItem) -> DecryptedCalendarItem:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.createCalendarItemBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedCalendarItem._deserialize(result_info.success)
			return return_value

	async def undelete_calendar_item_by_id_async(self, id: str, rev: str) -> DecryptedCalendarItem:
		def do_decode(raw_result):
			return DecryptedCalendarItem._deserialize(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.undeleteCalendarItemByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_calendar_item_by_id_blocking(self, id: str, rev: str) -> DecryptedCalendarItem:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.undeleteCalendarItemByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedCalendarItem._deserialize(result_info.success)
			return return_value

	async def undelete_calendar_item_async(self, calendar_item: CalendarItem) -> DecryptedCalendarItem:
		def do_decode(raw_result):
			return DecryptedCalendarItem._deserialize(raw_result)
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.undeleteCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_calendar_item_blocking(self, calendar_item: CalendarItem) -> DecryptedCalendarItem:
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.undeleteCalendarItemBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedCalendarItem._deserialize(result_info.success)
			return return_value

	async def modify_calendar_item_async(self, entity: DecryptedCalendarItem) -> DecryptedCalendarItem:
		def do_decode(raw_result):
			return DecryptedCalendarItem._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.modifyCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_calendar_item_blocking(self, entity: DecryptedCalendarItem) -> DecryptedCalendarItem:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.modifyCalendarItemBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedCalendarItem._deserialize(result_info.success)
			return return_value

	async def get_calendar_item_async(self, entity_id: str) -> Optional[DecryptedCalendarItem]:
		def do_decode(raw_result):
			return DecryptedCalendarItem._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.getCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_calendar_item_blocking(self, entity_id: str) -> Optional[DecryptedCalendarItem]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.getCalendarItemBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedCalendarItem._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_calendar_items_async(self, entity_ids: list[str]) -> list[DecryptedCalendarItem]:
		def do_decode(raw_result):
			return [DecryptedCalendarItem._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.getCalendarItemsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_calendar_items_blocking(self, entity_ids: list[str]) -> list[DecryptedCalendarItem]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.getCalendarItemsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedCalendarItem._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def subscribe_to_events_async(self, events: set[SubscriptionEventType], filter: FilterOptions[CalendarItem], subscription_config: Optional[EntitySubscriptionConfiguration] = None) -> EntitySubscription[EncryptedCalendarItem]:
		def do_decode(raw_result):
			return EntitySubscription[EncryptedCalendarItem](
				producer = raw_result,
				deserializer = lambda x: EncryptedCalendarItem._deserialize(x),
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.subscribeToEventsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def subscribe_to_events_blocking(self, events: set[SubscriptionEventType], filter: FilterOptions[CalendarItem], subscription_config: Optional[EntitySubscriptionConfiguration] = None) -> EntitySubscription[EncryptedCalendarItem]:
		payload = {
			"events": [x0.__serialize__() for x0 in events],
			"filter": filter.__serialize__(),
			"subscriptionConfig": subscription_config.__serialize__() if subscription_config is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.subscribeToEventsBlocking(
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
			return EntitySubscription[EncryptedCalendarItem](
				producer = class_pointer,
				deserializer = lambda x: EncryptedCalendarItem._deserialize(x),
				executor = self.cardinal_sdk._executor
			)


class CalendarItemApiEncrypted:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate_id: str, calendar_item: EncryptedCalendarItem, options: Optional[CalendarItemShareOptions] = None) -> EncryptedCalendarItem:
		def do_decode(raw_result):
			return EncryptedCalendarItem._deserialize(raw_result)
		payload = {
			"delegateId": delegate_id,
			"calendarItem": calendar_item.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.encrypted.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, calendar_item: EncryptedCalendarItem, options: Optional[CalendarItemShareOptions] = None) -> EncryptedCalendarItem:
		payload = {
			"delegateId": delegate_id,
			"calendarItem": calendar_item.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.encrypted.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedCalendarItem._deserialize(result_info.success)
			return return_value

	async def share_with_many_async(self, calendar_item: EncryptedCalendarItem, delegates: dict[str, CalendarItemShareOptions]) -> EncryptedCalendarItem:
		def do_decode(raw_result):
			return EncryptedCalendarItem._deserialize(raw_result)
		payload = {
			"calendarItem": calendar_item.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.encrypted.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, calendar_item: EncryptedCalendarItem, delegates: dict[str, CalendarItemShareOptions]) -> EncryptedCalendarItem:
		payload = {
			"calendarItem": calendar_item.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.encrypted.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedCalendarItem._deserialize(result_info.success)
			return return_value

	async def link_to_patient_async(self, calendar_item: CalendarItem, patient: Patient, share_link_with_delegates: set[str]) -> EncryptedCalendarItem:
		def do_decode(raw_result):
			return EncryptedCalendarItem._deserialize(raw_result)
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
			"patient": serialize_patient(patient),
			"shareLinkWithDelegates": [x0 for x0 in share_link_with_delegates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.encrypted.linkToPatientAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def link_to_patient_blocking(self, calendar_item: CalendarItem, patient: Patient, share_link_with_delegates: set[str]) -> EncryptedCalendarItem:
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
			"patient": serialize_patient(patient),
			"shareLinkWithDelegates": [x0 for x0 in share_link_with_delegates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.encrypted.linkToPatientBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedCalendarItem._deserialize(result_info.success)
			return return_value

	async def filter_calendar_items_by_async(self, filter: FilterOptions[CalendarItem]) -> PaginatedListIterator[EncryptedCalendarItem]:
		def do_decode(raw_result):
			return PaginatedListIterator[EncryptedCalendarItem](
				producer = raw_result,
				deserializer = lambda x: EncryptedCalendarItem._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.encrypted.filterCalendarItemsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_calendar_items_by_blocking(self, filter: FilterOptions[CalendarItem]) -> PaginatedListIterator[EncryptedCalendarItem]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.encrypted.filterCalendarItemsByBlocking(
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
			return PaginatedListIterator[EncryptedCalendarItem](
				producer = class_pointer,
				deserializer = lambda x: EncryptedCalendarItem._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_calendar_items_by_sorted_async(self, filter: SortableFilterOptions[CalendarItem]) -> PaginatedListIterator[EncryptedCalendarItem]:
		def do_decode(raw_result):
			return PaginatedListIterator[EncryptedCalendarItem](
				producer = raw_result,
				deserializer = lambda x: EncryptedCalendarItem._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.encrypted.filterCalendarItemsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_calendar_items_by_sorted_blocking(self, filter: SortableFilterOptions[CalendarItem]) -> PaginatedListIterator[EncryptedCalendarItem]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.encrypted.filterCalendarItemsBySortedBlocking(
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
			return PaginatedListIterator[EncryptedCalendarItem](
				producer = class_pointer,
				deserializer = lambda x: EncryptedCalendarItem._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def create_calendar_item_async(self, entity: EncryptedCalendarItem) -> EncryptedCalendarItem:
		def do_decode(raw_result):
			return EncryptedCalendarItem._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.encrypted.createCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_calendar_item_blocking(self, entity: EncryptedCalendarItem) -> EncryptedCalendarItem:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.encrypted.createCalendarItemBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedCalendarItem._deserialize(result_info.success)
			return return_value

	async def undelete_calendar_item_by_id_async(self, id: str, rev: str) -> EncryptedCalendarItem:
		def do_decode(raw_result):
			return EncryptedCalendarItem._deserialize(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.encrypted.undeleteCalendarItemByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_calendar_item_by_id_blocking(self, id: str, rev: str) -> EncryptedCalendarItem:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.encrypted.undeleteCalendarItemByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedCalendarItem._deserialize(result_info.success)
			return return_value

	async def undelete_calendar_item_async(self, calendar_item: CalendarItem) -> EncryptedCalendarItem:
		def do_decode(raw_result):
			return EncryptedCalendarItem._deserialize(raw_result)
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.encrypted.undeleteCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_calendar_item_blocking(self, calendar_item: CalendarItem) -> EncryptedCalendarItem:
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.encrypted.undeleteCalendarItemBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedCalendarItem._deserialize(result_info.success)
			return return_value

	async def modify_calendar_item_async(self, entity: EncryptedCalendarItem) -> EncryptedCalendarItem:
		def do_decode(raw_result):
			return EncryptedCalendarItem._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.encrypted.modifyCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_calendar_item_blocking(self, entity: EncryptedCalendarItem) -> EncryptedCalendarItem:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.encrypted.modifyCalendarItemBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedCalendarItem._deserialize(result_info.success)
			return return_value

	async def get_calendar_item_async(self, entity_id: str) -> Optional[EncryptedCalendarItem]:
		def do_decode(raw_result):
			return EncryptedCalendarItem._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.encrypted.getCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_calendar_item_blocking(self, entity_id: str) -> Optional[EncryptedCalendarItem]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.encrypted.getCalendarItemBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedCalendarItem._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_calendar_items_async(self, entity_ids: list[str]) -> list[EncryptedCalendarItem]:
		def do_decode(raw_result):
			return [EncryptedCalendarItem._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.encrypted.getCalendarItemsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_calendar_items_blocking(self, entity_ids: list[str]) -> list[EncryptedCalendarItem]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.encrypted.getCalendarItemsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedCalendarItem._deserialize(x1) for x1 in result_info.success]
			return return_value


class CalendarItemApiTryAndRecover:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate_id: str, calendar_item: CalendarItem, options: Optional[CalendarItemShareOptions] = None) -> CalendarItem:
		def do_decode(raw_result):
			return deserialize_calendar_item(raw_result)
		payload = {
			"delegateId": delegate_id,
			"calendarItem": serialize_calendar_item(calendar_item),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.tryAndRecover.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, calendar_item: CalendarItem, options: Optional[CalendarItemShareOptions] = None) -> CalendarItem:
		payload = {
			"delegateId": delegate_id,
			"calendarItem": serialize_calendar_item(calendar_item),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.tryAndRecover.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_calendar_item(result_info.success)
			return return_value

	async def share_with_many_async(self, calendar_item: CalendarItem, delegates: dict[str, CalendarItemShareOptions]) -> CalendarItem:
		def do_decode(raw_result):
			return deserialize_calendar_item(raw_result)
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.tryAndRecover.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, calendar_item: CalendarItem, delegates: dict[str, CalendarItemShareOptions]) -> CalendarItem:
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.tryAndRecover.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_calendar_item(result_info.success)
			return return_value

	async def link_to_patient_async(self, calendar_item: CalendarItem, patient: Patient, share_link_with_delegates: set[str]) -> CalendarItem:
		def do_decode(raw_result):
			return deserialize_calendar_item(raw_result)
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
			"patient": serialize_patient(patient),
			"shareLinkWithDelegates": [x0 for x0 in share_link_with_delegates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.tryAndRecover.linkToPatientAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def link_to_patient_blocking(self, calendar_item: CalendarItem, patient: Patient, share_link_with_delegates: set[str]) -> CalendarItem:
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
			"patient": serialize_patient(patient),
			"shareLinkWithDelegates": [x0 for x0 in share_link_with_delegates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.tryAndRecover.linkToPatientBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_calendar_item(result_info.success)
			return return_value

	async def filter_calendar_items_by_async(self, filter: FilterOptions[CalendarItem]) -> PaginatedListIterator[CalendarItem]:
		def do_decode(raw_result):
			return PaginatedListIterator[CalendarItem](
				producer = raw_result,
				deserializer = lambda x: deserialize_calendar_item(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.tryAndRecover.filterCalendarItemsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_calendar_items_by_blocking(self, filter: FilterOptions[CalendarItem]) -> PaginatedListIterator[CalendarItem]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.tryAndRecover.filterCalendarItemsByBlocking(
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
			return PaginatedListIterator[CalendarItem](
				producer = class_pointer,
				deserializer = lambda x: deserialize_calendar_item(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_calendar_items_by_sorted_async(self, filter: SortableFilterOptions[CalendarItem]) -> PaginatedListIterator[CalendarItem]:
		def do_decode(raw_result):
			return PaginatedListIterator[CalendarItem](
				producer = raw_result,
				deserializer = lambda x: deserialize_calendar_item(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.tryAndRecover.filterCalendarItemsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_calendar_items_by_sorted_blocking(self, filter: SortableFilterOptions[CalendarItem]) -> PaginatedListIterator[CalendarItem]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.tryAndRecover.filterCalendarItemsBySortedBlocking(
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
			return PaginatedListIterator[CalendarItem](
				producer = class_pointer,
				deserializer = lambda x: deserialize_calendar_item(x),
				executor = self.cardinal_sdk._executor
			)

	async def create_calendar_item_async(self, entity: CalendarItem) -> CalendarItem:
		def do_decode(raw_result):
			return deserialize_calendar_item(raw_result)
		payload = {
			"entity": serialize_calendar_item(entity),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.tryAndRecover.createCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_calendar_item_blocking(self, entity: CalendarItem) -> CalendarItem:
		payload = {
			"entity": serialize_calendar_item(entity),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.tryAndRecover.createCalendarItemBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_calendar_item(result_info.success)
			return return_value

	async def undelete_calendar_item_by_id_async(self, id: str, rev: str) -> CalendarItem:
		def do_decode(raw_result):
			return deserialize_calendar_item(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.tryAndRecover.undeleteCalendarItemByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_calendar_item_by_id_blocking(self, id: str, rev: str) -> CalendarItem:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.tryAndRecover.undeleteCalendarItemByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_calendar_item(result_info.success)
			return return_value

	async def undelete_calendar_item_async(self, calendar_item: CalendarItem) -> CalendarItem:
		def do_decode(raw_result):
			return deserialize_calendar_item(raw_result)
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.tryAndRecover.undeleteCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_calendar_item_blocking(self, calendar_item: CalendarItem) -> CalendarItem:
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.tryAndRecover.undeleteCalendarItemBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_calendar_item(result_info.success)
			return return_value

	async def modify_calendar_item_async(self, entity: CalendarItem) -> CalendarItem:
		def do_decode(raw_result):
			return deserialize_calendar_item(raw_result)
		payload = {
			"entity": serialize_calendar_item(entity),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.tryAndRecover.modifyCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_calendar_item_blocking(self, entity: CalendarItem) -> CalendarItem:
		payload = {
			"entity": serialize_calendar_item(entity),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.tryAndRecover.modifyCalendarItemBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_calendar_item(result_info.success)
			return return_value

	async def get_calendar_item_async(self, entity_id: str) -> Optional[CalendarItem]:
		def do_decode(raw_result):
			return deserialize_calendar_item(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.tryAndRecover.getCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_calendar_item_blocking(self, entity_id: str) -> Optional[CalendarItem]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.tryAndRecover.getCalendarItemBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_calendar_item(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_calendar_items_async(self, entity_ids: list[str]) -> list[CalendarItem]:
		def do_decode(raw_result):
			return [deserialize_calendar_item(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.tryAndRecover.getCalendarItemsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_calendar_items_blocking(self, entity_ids: list[str]) -> list[CalendarItem]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.tryAndRecover.getCalendarItemsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_calendar_item(x1) for x1 in result_info.success]
			return return_value


class CalendarItemApiInGroup:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk
		self.encrypted = CalendarItemApiInGroupEncrypted(self.cardinal_sdk)
		self.try_and_recover = CalendarItemApiInGroupTryAndRecover(self.cardinal_sdk)

	async def with_encryption_metadata_async(self, entity_group_id: str, base: Optional[DecryptedCalendarItem], patient: Optional[GroupScoped[Patient]], user: Optional[User] = None, delegates: dict[EntityReferenceInGroup, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent(), alternate_root_delegate_reference: Optional[EntityReferenceInGroup] = None) -> GroupScoped[DecryptedCalendarItem]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedCalendarItem._deserialize(x1))
		payload = {
			"entityGroupId": entity_group_id,
			"base": base.__serialize__() if base is not None else None,
			"patient": patient.__serialize__(lambda x0: serialize_patient(x0)) if patient is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
			"secretId": serialize_secret_id_use_option(secret_id),
			"alternateRootDelegateReference": alternate_root_delegate_reference.__serialize__() if alternate_root_delegate_reference is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.withEncryptionMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def with_encryption_metadata_blocking(self, entity_group_id: str, base: Optional[DecryptedCalendarItem], patient: Optional[GroupScoped[Patient]], user: Optional[User] = None, delegates: dict[EntityReferenceInGroup, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent(), alternate_root_delegate_reference: Optional[EntityReferenceInGroup] = None) -> GroupScoped[DecryptedCalendarItem]:
		payload = {
			"entityGroupId": entity_group_id,
			"base": base.__serialize__() if base is not None else None,
			"patient": patient.__serialize__(lambda x0: serialize_patient(x0)) if patient is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
			"secretId": serialize_secret_id_use_option(secret_id),
			"alternateRootDelegateReference": alternate_root_delegate_reference.__serialize__() if alternate_root_delegate_reference is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.withEncryptionMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedCalendarItem._deserialize(x1))
			return return_value

	async def get_encryption_keys_of_async(self, calendar_item: GroupScoped[CalendarItem]) -> set[HexString]:
		def do_decode(raw_result):
			return {x1 for x1 in raw_result}
		payload = {
			"calendarItem": calendar_item.__serialize__(lambda x0: serialize_calendar_item(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.getEncryptionKeysOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_encryption_keys_of_blocking(self, calendar_item: GroupScoped[CalendarItem]) -> set[HexString]:
		payload = {
			"calendarItem": calendar_item.__serialize__(lambda x0: serialize_calendar_item(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.getEncryptionKeysOfBlocking(
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

	async def has_write_access_async(self, calendar_item: GroupScoped[CalendarItem]) -> bool:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"calendarItem": calendar_item.__serialize__(lambda x0: serialize_calendar_item(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.hasWriteAccessAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def has_write_access_blocking(self, calendar_item: GroupScoped[CalendarItem]) -> bool:
		payload = {
			"calendarItem": calendar_item.__serialize__(lambda x0: serialize_calendar_item(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.hasWriteAccessBlocking(
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

	async def decrypt_patient_id_of_async(self, calendar_item: GroupScoped[CalendarItem]) -> set[EntityReferenceInGroup]:
		def do_decode(raw_result):
			return {EntityReferenceInGroup._deserialize(x1) for x1 in raw_result}
		payload = {
			"calendarItem": calendar_item.__serialize__(lambda x0: serialize_calendar_item(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.decryptPatientIdOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_patient_id_of_blocking(self, calendar_item: GroupScoped[CalendarItem]) -> set[EntityReferenceInGroup]:
		payload = {
			"calendarItem": calendar_item.__serialize__(lambda x0: serialize_calendar_item(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.decryptPatientIdOfBlocking(
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

	async def create_delegation_de_anonymization_metadata_async(self, entity: GroupScoped[CalendarItem], delegates: set[EntityReferenceInGroup]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_calendar_item(x0)),
			"delegates": [x0.__serialize__() for x0 in delegates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.createDelegationDeAnonymizationMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_delegation_de_anonymization_metadata_blocking(self, entity: GroupScoped[CalendarItem], delegates: set[EntityReferenceInGroup]) -> None:
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_calendar_item(x0)),
			"delegates": [x0.__serialize__() for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.createDelegationDeAnonymizationMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def decrypt_async(self, calendar_items: list[GroupScoped[EncryptedCalendarItem]]) -> list[GroupScoped[DecryptedCalendarItem]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: DecryptedCalendarItem._deserialize(x2)) for x1 in raw_result]
		payload = {
			"calendarItems": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in calendar_items],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.decryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_blocking(self, calendar_items: list[GroupScoped[EncryptedCalendarItem]]) -> list[GroupScoped[DecryptedCalendarItem]]:
		payload = {
			"calendarItems": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in calendar_items],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.decryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: DecryptedCalendarItem._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def try_decrypt_async(self, calendar_items: list[GroupScoped[EncryptedCalendarItem]]) -> list[GroupScoped[CalendarItem]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: deserialize_calendar_item(x2)) for x1 in raw_result]
		payload = {
			"calendarItems": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in calendar_items],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.tryDecryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def try_decrypt_blocking(self, calendar_items: list[GroupScoped[EncryptedCalendarItem]]) -> list[GroupScoped[CalendarItem]]:
		payload = {
			"calendarItems": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in calendar_items],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.tryDecryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: deserialize_calendar_item(x2)) for x1 in result_info.success]
			return return_value

	async def encrypt_or_validate_async(self, calendar_items: list[GroupScoped[CalendarItem]]) -> list[GroupScoped[EncryptedCalendarItem]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: EncryptedCalendarItem._deserialize(x2)) for x1 in raw_result]
		payload = {
			"calendarItems": [x0.__serialize__(lambda x1: serialize_calendar_item(x1)) for x0 in calendar_items],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.encryptOrValidateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def encrypt_or_validate_blocking(self, calendar_items: list[GroupScoped[CalendarItem]]) -> list[GroupScoped[EncryptedCalendarItem]]:
		payload = {
			"calendarItems": [x0.__serialize__(lambda x1: serialize_calendar_item(x1)) for x0 in calendar_items],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.encryptOrValidateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: EncryptedCalendarItem._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def match_calendar_items_by_async(self, group_id: str, filter: FilterOptions[CalendarItem]) -> list[str]:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.matchCalendarItemsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_calendar_items_by_blocking(self, group_id: str, filter: FilterOptions[CalendarItem]) -> list[str]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.matchCalendarItemsByBlocking(
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

	async def match_calendar_items_by_sorted_async(self, group_id: str, filter: SortableFilterOptions[CalendarItem]) -> list[str]:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.matchCalendarItemsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_calendar_items_by_sorted_blocking(self, group_id: str, filter: SortableFilterOptions[CalendarItem]) -> list[str]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.matchCalendarItemsBySortedBlocking(
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

	async def delete_calendar_item_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: StoredDocumentIdentifier._deserialize(x1))
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.deleteCalendarItemByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_calendar_item_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[StoredDocumentIdentifier]:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.deleteCalendarItemByIdBlocking(
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

	async def delete_calendar_items_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.deleteCalendarItemsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_calendar_items_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.deleteCalendarItemsByIdsBlocking(
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

	async def delete_calendar_item_async(self, calendar_item: GroupScoped[CalendarItem]) -> GroupScoped[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: StoredDocumentIdentifier._deserialize(x1))
		payload = {
			"calendarItem": calendar_item.__serialize__(lambda x0: serialize_calendar_item(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.deleteCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_calendar_item_blocking(self, calendar_item: GroupScoped[CalendarItem]) -> GroupScoped[StoredDocumentIdentifier]:
		payload = {
			"calendarItem": calendar_item.__serialize__(lambda x0: serialize_calendar_item(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.deleteCalendarItemBlocking(
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

	async def delete_calendar_items_async(self, calendar_items: list[GroupScoped[CalendarItem]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"calendarItems": [x0.__serialize__(lambda x1: serialize_calendar_item(x1)) for x0 in calendar_items],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.deleteCalendarItemsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_calendar_items_blocking(self, calendar_items: list[GroupScoped[CalendarItem]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"calendarItems": [x0.__serialize__(lambda x1: serialize_calendar_item(x1)) for x0 in calendar_items],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.deleteCalendarItemsBlocking(
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

	async def share_with_async(self, delegate: EntityReferenceInGroup, calendar_item: GroupScoped[DecryptedCalendarItem], options: Optional[CalendarItemShareOptions] = None) -> GroupScoped[DecryptedCalendarItem]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedCalendarItem._deserialize(x1))
		payload = {
			"delegate": delegate.__serialize__(),
			"calendarItem": calendar_item.__serialize__(lambda x0: x0.__serialize__()),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate: EntityReferenceInGroup, calendar_item: GroupScoped[DecryptedCalendarItem], options: Optional[CalendarItemShareOptions] = None) -> GroupScoped[DecryptedCalendarItem]:
		payload = {
			"delegate": delegate.__serialize__(),
			"calendarItem": calendar_item.__serialize__(lambda x0: x0.__serialize__()),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedCalendarItem._deserialize(x1))
			return return_value

	async def share_with_many_async(self, calendar_item: GroupScoped[DecryptedCalendarItem], delegates: dict[EntityReferenceInGroup, CalendarItemShareOptions]) -> GroupScoped[DecryptedCalendarItem]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedCalendarItem._deserialize(x1))
		payload = {
			"calendarItem": calendar_item.__serialize__(lambda x0: x0.__serialize__()),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, calendar_item: GroupScoped[DecryptedCalendarItem], delegates: dict[EntityReferenceInGroup, CalendarItemShareOptions]) -> GroupScoped[DecryptedCalendarItem]:
		payload = {
			"calendarItem": calendar_item.__serialize__(lambda x0: x0.__serialize__()),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedCalendarItem._deserialize(x1))
			return return_value

	async def filter_calendar_items_by_async(self, group_id: str, filter: FilterOptions[CalendarItem]) -> PaginatedListIterator[GroupScoped[DecryptedCalendarItem]]:
		def do_decode(raw_result):
			return PaginatedListIterator[GroupScoped[DecryptedCalendarItem]](
				producer = raw_result,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: DecryptedCalendarItem._deserialize(x1)),
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.filterCalendarItemsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_calendar_items_by_blocking(self, group_id: str, filter: FilterOptions[CalendarItem]) -> PaginatedListIterator[GroupScoped[DecryptedCalendarItem]]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.filterCalendarItemsByBlocking(
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
			return PaginatedListIterator[GroupScoped[DecryptedCalendarItem]](
				producer = class_pointer,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: DecryptedCalendarItem._deserialize(x1)),
				executor = self.cardinal_sdk._executor
			)

	async def filter_calendar_items_by_sorted_async(self, group_id: str, filter: SortableFilterOptions[CalendarItem]) -> PaginatedListIterator[GroupScoped[DecryptedCalendarItem]]:
		def do_decode(raw_result):
			return PaginatedListIterator[GroupScoped[DecryptedCalendarItem]](
				producer = raw_result,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: DecryptedCalendarItem._deserialize(x1)),
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.filterCalendarItemsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_calendar_items_by_sorted_blocking(self, group_id: str, filter: SortableFilterOptions[CalendarItem]) -> PaginatedListIterator[GroupScoped[DecryptedCalendarItem]]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.filterCalendarItemsBySortedBlocking(
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
			return PaginatedListIterator[GroupScoped[DecryptedCalendarItem]](
				producer = class_pointer,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: DecryptedCalendarItem._deserialize(x1)),
				executor = self.cardinal_sdk._executor
			)

	async def create_calendar_item_async(self, entity: GroupScoped[DecryptedCalendarItem]) -> GroupScoped[DecryptedCalendarItem]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedCalendarItem._deserialize(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.createCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_calendar_item_blocking(self, entity: GroupScoped[DecryptedCalendarItem]) -> GroupScoped[DecryptedCalendarItem]:
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.createCalendarItemBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedCalendarItem._deserialize(x1))
			return return_value

	async def modify_calendar_item_async(self, entity: GroupScoped[DecryptedCalendarItem]) -> GroupScoped[DecryptedCalendarItem]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedCalendarItem._deserialize(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.modifyCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_calendar_item_blocking(self, entity: GroupScoped[DecryptedCalendarItem]) -> GroupScoped[DecryptedCalendarItem]:
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.modifyCalendarItemBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedCalendarItem._deserialize(x1))
			return return_value

	async def get_calendar_item_async(self, group_id: str, entity_id: str) -> Optional[GroupScoped[DecryptedCalendarItem]]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedCalendarItem._deserialize(x1)) if raw_result is not None else None
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.getCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_calendar_item_blocking(self, group_id: str, entity_id: str) -> Optional[GroupScoped[DecryptedCalendarItem]]:
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.getCalendarItemBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedCalendarItem._deserialize(x1)) if result_info.success is not None else None
			return return_value

	async def get_calendar_items_async(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[DecryptedCalendarItem]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: DecryptedCalendarItem._deserialize(x2)) for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.getCalendarItemsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_calendar_items_blocking(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[DecryptedCalendarItem]]:
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.getCalendarItemsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: DecryptedCalendarItem._deserialize(x2)) for x1 in result_info.success]
			return return_value


class CalendarItemApiInGroupEncrypted:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate: EntityReferenceInGroup, calendar_item: GroupScoped[EncryptedCalendarItem], options: Optional[CalendarItemShareOptions] = None) -> GroupScoped[EncryptedCalendarItem]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedCalendarItem._deserialize(x1))
		payload = {
			"delegate": delegate.__serialize__(),
			"calendarItem": calendar_item.__serialize__(lambda x0: x0.__serialize__()),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.encrypted.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate: EntityReferenceInGroup, calendar_item: GroupScoped[EncryptedCalendarItem], options: Optional[CalendarItemShareOptions] = None) -> GroupScoped[EncryptedCalendarItem]:
		payload = {
			"delegate": delegate.__serialize__(),
			"calendarItem": calendar_item.__serialize__(lambda x0: x0.__serialize__()),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.encrypted.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedCalendarItem._deserialize(x1))
			return return_value

	async def share_with_many_async(self, calendar_item: GroupScoped[EncryptedCalendarItem], delegates: dict[EntityReferenceInGroup, CalendarItemShareOptions]) -> GroupScoped[EncryptedCalendarItem]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedCalendarItem._deserialize(x1))
		payload = {
			"calendarItem": calendar_item.__serialize__(lambda x0: x0.__serialize__()),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.encrypted.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, calendar_item: GroupScoped[EncryptedCalendarItem], delegates: dict[EntityReferenceInGroup, CalendarItemShareOptions]) -> GroupScoped[EncryptedCalendarItem]:
		payload = {
			"calendarItem": calendar_item.__serialize__(lambda x0: x0.__serialize__()),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.encrypted.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedCalendarItem._deserialize(x1))
			return return_value

	async def filter_calendar_items_by_async(self, group_id: str, filter: FilterOptions[CalendarItem]) -> PaginatedListIterator[GroupScoped[EncryptedCalendarItem]]:
		def do_decode(raw_result):
			return PaginatedListIterator[GroupScoped[EncryptedCalendarItem]](
				producer = raw_result,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: EncryptedCalendarItem._deserialize(x1)),
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.encrypted.filterCalendarItemsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_calendar_items_by_blocking(self, group_id: str, filter: FilterOptions[CalendarItem]) -> PaginatedListIterator[GroupScoped[EncryptedCalendarItem]]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.encrypted.filterCalendarItemsByBlocking(
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
			return PaginatedListIterator[GroupScoped[EncryptedCalendarItem]](
				producer = class_pointer,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: EncryptedCalendarItem._deserialize(x1)),
				executor = self.cardinal_sdk._executor
			)

	async def filter_calendar_items_by_sorted_async(self, group_id: str, filter: SortableFilterOptions[CalendarItem]) -> PaginatedListIterator[GroupScoped[EncryptedCalendarItem]]:
		def do_decode(raw_result):
			return PaginatedListIterator[GroupScoped[EncryptedCalendarItem]](
				producer = raw_result,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: EncryptedCalendarItem._deserialize(x1)),
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.encrypted.filterCalendarItemsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_calendar_items_by_sorted_blocking(self, group_id: str, filter: SortableFilterOptions[CalendarItem]) -> PaginatedListIterator[GroupScoped[EncryptedCalendarItem]]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.encrypted.filterCalendarItemsBySortedBlocking(
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
			return PaginatedListIterator[GroupScoped[EncryptedCalendarItem]](
				producer = class_pointer,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: EncryptedCalendarItem._deserialize(x1)),
				executor = self.cardinal_sdk._executor
			)

	async def create_calendar_item_async(self, entity: GroupScoped[EncryptedCalendarItem]) -> GroupScoped[EncryptedCalendarItem]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedCalendarItem._deserialize(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.encrypted.createCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_calendar_item_blocking(self, entity: GroupScoped[EncryptedCalendarItem]) -> GroupScoped[EncryptedCalendarItem]:
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.encrypted.createCalendarItemBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedCalendarItem._deserialize(x1))
			return return_value

	async def modify_calendar_item_async(self, entity: GroupScoped[EncryptedCalendarItem]) -> GroupScoped[EncryptedCalendarItem]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedCalendarItem._deserialize(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.encrypted.modifyCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_calendar_item_blocking(self, entity: GroupScoped[EncryptedCalendarItem]) -> GroupScoped[EncryptedCalendarItem]:
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.encrypted.modifyCalendarItemBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedCalendarItem._deserialize(x1))
			return return_value

	async def get_calendar_item_async(self, group_id: str, entity_id: str) -> Optional[GroupScoped[EncryptedCalendarItem]]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedCalendarItem._deserialize(x1)) if raw_result is not None else None
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.encrypted.getCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_calendar_item_blocking(self, group_id: str, entity_id: str) -> Optional[GroupScoped[EncryptedCalendarItem]]:
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.encrypted.getCalendarItemBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedCalendarItem._deserialize(x1)) if result_info.success is not None else None
			return return_value

	async def get_calendar_items_async(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[EncryptedCalendarItem]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: EncryptedCalendarItem._deserialize(x2)) for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.encrypted.getCalendarItemsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_calendar_items_blocking(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[EncryptedCalendarItem]]:
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.encrypted.getCalendarItemsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: EncryptedCalendarItem._deserialize(x2)) for x1 in result_info.success]
			return return_value


class CalendarItemApiInGroupTryAndRecover:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate: EntityReferenceInGroup, calendar_item: GroupScoped[CalendarItem], options: Optional[CalendarItemShareOptions] = None) -> GroupScoped[CalendarItem]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_calendar_item(x1))
		payload = {
			"delegate": delegate.__serialize__(),
			"calendarItem": calendar_item.__serialize__(lambda x0: serialize_calendar_item(x0)),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.tryAndRecover.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate: EntityReferenceInGroup, calendar_item: GroupScoped[CalendarItem], options: Optional[CalendarItemShareOptions] = None) -> GroupScoped[CalendarItem]:
		payload = {
			"delegate": delegate.__serialize__(),
			"calendarItem": calendar_item.__serialize__(lambda x0: serialize_calendar_item(x0)),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.tryAndRecover.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_calendar_item(x1))
			return return_value

	async def share_with_many_async(self, calendar_item: GroupScoped[CalendarItem], delegates: dict[EntityReferenceInGroup, CalendarItemShareOptions]) -> GroupScoped[CalendarItem]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_calendar_item(x1))
		payload = {
			"calendarItem": calendar_item.__serialize__(lambda x0: serialize_calendar_item(x0)),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.tryAndRecover.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, calendar_item: GroupScoped[CalendarItem], delegates: dict[EntityReferenceInGroup, CalendarItemShareOptions]) -> GroupScoped[CalendarItem]:
		payload = {
			"calendarItem": calendar_item.__serialize__(lambda x0: serialize_calendar_item(x0)),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.tryAndRecover.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_calendar_item(x1))
			return return_value

	async def filter_calendar_items_by_async(self, group_id: str, filter: FilterOptions[CalendarItem]) -> PaginatedListIterator[GroupScoped[CalendarItem]]:
		def do_decode(raw_result):
			return PaginatedListIterator[GroupScoped[CalendarItem]](
				producer = raw_result,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: deserialize_calendar_item(x1)),
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.tryAndRecover.filterCalendarItemsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_calendar_items_by_blocking(self, group_id: str, filter: FilterOptions[CalendarItem]) -> PaginatedListIterator[GroupScoped[CalendarItem]]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.tryAndRecover.filterCalendarItemsByBlocking(
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
			return PaginatedListIterator[GroupScoped[CalendarItem]](
				producer = class_pointer,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: deserialize_calendar_item(x1)),
				executor = self.cardinal_sdk._executor
			)

	async def filter_calendar_items_by_sorted_async(self, group_id: str, filter: SortableFilterOptions[CalendarItem]) -> PaginatedListIterator[GroupScoped[CalendarItem]]:
		def do_decode(raw_result):
			return PaginatedListIterator[GroupScoped[CalendarItem]](
				producer = raw_result,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: deserialize_calendar_item(x1)),
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.tryAndRecover.filterCalendarItemsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_calendar_items_by_sorted_blocking(self, group_id: str, filter: SortableFilterOptions[CalendarItem]) -> PaginatedListIterator[GroupScoped[CalendarItem]]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.tryAndRecover.filterCalendarItemsBySortedBlocking(
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
			return PaginatedListIterator[GroupScoped[CalendarItem]](
				producer = class_pointer,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: deserialize_calendar_item(x1)),
				executor = self.cardinal_sdk._executor
			)

	async def create_calendar_item_async(self, entity: GroupScoped[CalendarItem]) -> GroupScoped[CalendarItem]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_calendar_item(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_calendar_item(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.tryAndRecover.createCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_calendar_item_blocking(self, entity: GroupScoped[CalendarItem]) -> GroupScoped[CalendarItem]:
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_calendar_item(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.tryAndRecover.createCalendarItemBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_calendar_item(x1))
			return return_value

	async def modify_calendar_item_async(self, entity: GroupScoped[CalendarItem]) -> GroupScoped[CalendarItem]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_calendar_item(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_calendar_item(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.tryAndRecover.modifyCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_calendar_item_blocking(self, entity: GroupScoped[CalendarItem]) -> GroupScoped[CalendarItem]:
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_calendar_item(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.tryAndRecover.modifyCalendarItemBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_calendar_item(x1))
			return return_value

	async def get_calendar_item_async(self, group_id: str, entity_id: str) -> Optional[GroupScoped[CalendarItem]]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_calendar_item(x1)) if raw_result is not None else None
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.tryAndRecover.getCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_calendar_item_blocking(self, group_id: str, entity_id: str) -> Optional[GroupScoped[CalendarItem]]:
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.tryAndRecover.getCalendarItemBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_calendar_item(x1)) if result_info.success is not None else None
			return return_value

	async def get_calendar_items_async(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[CalendarItem]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: deserialize_calendar_item(x2)) for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.tryAndRecover.getCalendarItemsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_calendar_items_blocking(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[CalendarItem]]:
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup.tryAndRecover.getCalendarItemsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: deserialize_calendar_item(x2)) for x1 in result_info.success]
			return return_value
