# auto-generated file
import json
from cardinal_sdk.filters.FilterOptions import BaseFilterOptions, BaseSortableFilterOptions, FilterOptions
from cardinal_sdk.model import CalendarItem, EncryptedCalendarItem, StoredDocumentIdentifier, serialize_calendar_item, SubscriptionEventType, EntitySubscriptionConfiguration, GroupScoped
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.pagination.PaginatedListIterator import PaginatedListIterator
from typing import Optional
from cardinal_sdk.subscription.EntitySubscription import EntitySubscription


class CalendarItemBasicApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk
		self.in_group = CalendarItemBasicApiInGroup(self.cardinal_sdk)

	async def match_calendar_items_by_async(self, filter: BaseFilterOptions[CalendarItem]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.matchCalendarItemsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_calendar_items_by_blocking(self, filter: BaseFilterOptions[CalendarItem]) -> list[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.matchCalendarItemsByBlocking(
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

	async def match_calendar_items_by_sorted_async(self, filter: BaseSortableFilterOptions[CalendarItem]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.matchCalendarItemsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_calendar_items_by_sorted_blocking(self, filter: BaseSortableFilterOptions[CalendarItem]) -> list[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.matchCalendarItemsBySortedBlocking(
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

	async def filter_calendar_items_by_async(self, filter: BaseFilterOptions[CalendarItem]) -> PaginatedListIterator[EncryptedCalendarItem]:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.filterCalendarItemsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_calendar_items_by_blocking(self, filter: BaseFilterOptions[CalendarItem]) -> PaginatedListIterator[EncryptedCalendarItem]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.filterCalendarItemsByBlocking(
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

	async def filter_calendar_items_by_sorted_async(self, filter: BaseSortableFilterOptions[CalendarItem]) -> PaginatedListIterator[EncryptedCalendarItem]:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.filterCalendarItemsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_calendar_items_by_sorted_blocking(self, filter: BaseSortableFilterOptions[CalendarItem]) -> PaginatedListIterator[EncryptedCalendarItem]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.filterCalendarItemsBySortedBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.deleteCalendarItemByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_calendar_item_by_id_blocking(self, entity_id: str, rev: str) -> StoredDocumentIdentifier:
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.deleteCalendarItemByIdBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.deleteCalendarItemsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_calendar_items_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.deleteCalendarItemsByIdsBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.purgeCalendarItemByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_calendar_item_by_id_blocking(self, id: str, rev: str) -> None:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.purgeCalendarItemByIdBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.deleteCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_calendar_item_blocking(self, calendar_item: CalendarItem) -> StoredDocumentIdentifier:
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.deleteCalendarItemBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.deleteCalendarItemsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_calendar_items_blocking(self, calendar_items: list[CalendarItem]) -> list[StoredDocumentIdentifier]:
		payload = {
			"calendarItems": [serialize_calendar_item(x0) for x0 in calendar_items],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.deleteCalendarItemsBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.purgeCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_calendar_item_blocking(self, calendar_item: CalendarItem) -> None:
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.purgeCalendarItemBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.createCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_calendar_item_blocking(self, entity: EncryptedCalendarItem) -> EncryptedCalendarItem:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.createCalendarItemBlocking(
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

	async def book_calendar_item_checking_availability_async(self, entity: EncryptedCalendarItem) -> EncryptedCalendarItem:
		def do_decode(raw_result):
			return EncryptedCalendarItem._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.bookCalendarItemCheckingAvailabilityAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def book_calendar_item_checking_availability_blocking(self, entity: EncryptedCalendarItem) -> EncryptedCalendarItem:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.bookCalendarItemCheckingAvailabilityBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.undeleteCalendarItemByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_calendar_item_by_id_blocking(self, id: str, rev: str) -> EncryptedCalendarItem:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.undeleteCalendarItemByIdBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.undeleteCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_calendar_item_blocking(self, calendar_item: CalendarItem) -> EncryptedCalendarItem:
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.undeleteCalendarItemBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.modifyCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_calendar_item_blocking(self, entity: EncryptedCalendarItem) -> EncryptedCalendarItem:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.modifyCalendarItemBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.getCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_calendar_item_blocking(self, entity_id: str) -> Optional[EncryptedCalendarItem]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.getCalendarItemBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.getCalendarItemsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_calendar_items_blocking(self, entity_ids: list[str]) -> list[EncryptedCalendarItem]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.getCalendarItemsBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.subscribeToEventsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def subscribe_to_events_blocking(self, events: set[SubscriptionEventType], filter: FilterOptions[CalendarItem], subscription_config: Optional[EntitySubscriptionConfiguration] = None) -> EntitySubscription[EncryptedCalendarItem]:
		payload = {
			"events": [x0.__serialize__() for x0 in events],
			"filter": filter.__serialize__(),
			"subscriptionConfig": subscription_config.__serialize__() if subscription_config is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.subscribeToEventsBlocking(
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


class CalendarItemBasicApiInGroup:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def match_calendar_items_by_async(self, group_id: str, filter: BaseFilterOptions[CalendarItem]) -> list[str]:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.inGroup.matchCalendarItemsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_calendar_items_by_blocking(self, group_id: str, filter: BaseFilterOptions[CalendarItem]) -> list[str]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.inGroup.matchCalendarItemsByBlocking(
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

	async def match_calendar_items_by_sorted_async(self, group_id: str, filter: BaseSortableFilterOptions[CalendarItem]) -> list[str]:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.inGroup.matchCalendarItemsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_calendar_items_by_sorted_blocking(self, group_id: str, filter: BaseSortableFilterOptions[CalendarItem]) -> list[str]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.inGroup.matchCalendarItemsBySortedBlocking(
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

	async def filter_calendar_items_by_async(self, group_id: str, filter: BaseFilterOptions[CalendarItem]) -> PaginatedListIterator[GroupScoped[EncryptedCalendarItem]]:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.inGroup.filterCalendarItemsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_calendar_items_by_blocking(self, group_id: str, filter: BaseFilterOptions[CalendarItem]) -> PaginatedListIterator[GroupScoped[EncryptedCalendarItem]]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.inGroup.filterCalendarItemsByBlocking(
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

	async def filter_calendar_items_by_sorted_async(self, group_id: str, filter: BaseSortableFilterOptions[CalendarItem]) -> PaginatedListIterator[GroupScoped[EncryptedCalendarItem]]:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.inGroup.filterCalendarItemsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_calendar_items_by_sorted_blocking(self, group_id: str, filter: BaseSortableFilterOptions[CalendarItem]) -> PaginatedListIterator[GroupScoped[EncryptedCalendarItem]]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.inGroup.filterCalendarItemsBySortedBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.inGroup.deleteCalendarItemByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_calendar_item_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[StoredDocumentIdentifier]:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.inGroup.deleteCalendarItemByIdBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.inGroup.deleteCalendarItemsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_calendar_items_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.inGroup.deleteCalendarItemsByIdsBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.inGroup.deleteCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_calendar_item_blocking(self, calendar_item: GroupScoped[CalendarItem]) -> GroupScoped[StoredDocumentIdentifier]:
		payload = {
			"calendarItem": calendar_item.__serialize__(lambda x0: serialize_calendar_item(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.inGroup.deleteCalendarItemBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.inGroup.deleteCalendarItemsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_calendar_items_blocking(self, calendar_items: list[GroupScoped[CalendarItem]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"calendarItems": [x0.__serialize__(lambda x1: serialize_calendar_item(x1)) for x0 in calendar_items],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.inGroup.deleteCalendarItemsBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.inGroup.createCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_calendar_item_blocking(self, entity: GroupScoped[EncryptedCalendarItem]) -> GroupScoped[EncryptedCalendarItem]:
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.inGroup.createCalendarItemBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.inGroup.modifyCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_calendar_item_blocking(self, entity: GroupScoped[EncryptedCalendarItem]) -> GroupScoped[EncryptedCalendarItem]:
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.inGroup.modifyCalendarItemBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.inGroup.getCalendarItemAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_calendar_item_blocking(self, group_id: str, entity_id: str) -> Optional[GroupScoped[EncryptedCalendarItem]]:
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.inGroup.getCalendarItemBlocking(
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.inGroup.getCalendarItemsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_calendar_items_blocking(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[EncryptedCalendarItem]]:
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.inGroup.getCalendarItemsBlocking(
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
