# auto-generated file
import json
from cardinal_sdk.model import CalendarItemType, StoredDocumentIdentifier, GroupScoped
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from typing import Optional


class CalendarItemTypeApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk
		self.in_group = CalendarItemTypeApiInGroup(self.cardinal_sdk)

	async def create_calendar_item_type_async(self, calendar_item_type: CalendarItemType) -> CalendarItemType:
		def do_decode(raw_result):
			return CalendarItemType._deserialize(raw_result)
		payload = {
			"calendarItemType": calendar_item_type.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.createCalendarItemTypeAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_calendar_item_type_blocking(self, calendar_item_type: CalendarItemType) -> CalendarItemType:
		payload = {
			"calendarItemType": calendar_item_type.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.createCalendarItemTypeBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = CalendarItemType._deserialize(result_info.success)
			return return_value

	async def create_calendar_item_types_async(self, calendar_item_types: list[CalendarItemType]) -> list[CalendarItemType]:
		def do_decode(raw_result):
			return [CalendarItemType._deserialize(x1) for x1 in raw_result]
		payload = {
			"calendarItemTypes": [x0.__serialize__() for x0 in calendar_item_types],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.createCalendarItemTypesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_calendar_item_types_blocking(self, calendar_item_types: list[CalendarItemType]) -> list[CalendarItemType]:
		payload = {
			"calendarItemTypes": [x0.__serialize__() for x0 in calendar_item_types],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.createCalendarItemTypesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [CalendarItemType._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_calendar_item_type_async(self, calendar_item_type_id: str) -> Optional[CalendarItemType]:
		def do_decode(raw_result):
			return CalendarItemType._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"calendarItemTypeId": calendar_item_type_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.getCalendarItemTypeAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_calendar_item_type_blocking(self, calendar_item_type_id: str) -> Optional[CalendarItemType]:
		payload = {
			"calendarItemTypeId": calendar_item_type_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.getCalendarItemTypeBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = CalendarItemType._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_calendar_item_types_async(self, calendar_item_types_ids: list[str]) -> list[CalendarItemType]:
		def do_decode(raw_result):
			return [CalendarItemType._deserialize(x1) for x1 in raw_result]
		payload = {
			"calendarItemTypesIds": [x0 for x0 in calendar_item_types_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.getCalendarItemTypesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_calendar_item_types_blocking(self, calendar_item_types_ids: list[str]) -> list[CalendarItemType]:
		payload = {
			"calendarItemTypesIds": [x0 for x0 in calendar_item_types_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.getCalendarItemTypesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [CalendarItemType._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def modify_calendar_item_type_async(self, calendar_item_type: CalendarItemType) -> CalendarItemType:
		def do_decode(raw_result):
			return CalendarItemType._deserialize(raw_result)
		payload = {
			"calendarItemType": calendar_item_type.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.modifyCalendarItemTypeAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_calendar_item_type_blocking(self, calendar_item_type: CalendarItemType) -> CalendarItemType:
		payload = {
			"calendarItemType": calendar_item_type.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.modifyCalendarItemTypeBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = CalendarItemType._deserialize(result_info.success)
			return return_value

	async def modify_calendar_item_types_async(self, calendar_item_types: list[CalendarItemType]) -> list[CalendarItemType]:
		def do_decode(raw_result):
			return [CalendarItemType._deserialize(x1) for x1 in raw_result]
		payload = {
			"calendarItemTypes": [x0.__serialize__() for x0 in calendar_item_types],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.modifyCalendarItemTypesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_calendar_item_types_blocking(self, calendar_item_types: list[CalendarItemType]) -> list[CalendarItemType]:
		payload = {
			"calendarItemTypes": [x0.__serialize__() for x0 in calendar_item_types],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.modifyCalendarItemTypesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [CalendarItemType._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def delete_calendar_item_type_by_id_async(self, entity_id: str, rev: str) -> StoredDocumentIdentifier:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.deleteCalendarItemTypeByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_calendar_item_type_by_id_blocking(self, entity_id: str, rev: str) -> StoredDocumentIdentifier:
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.deleteCalendarItemTypeByIdBlocking(
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

	async def delete_calendar_item_type_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.deleteCalendarItemTypeByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_calendar_item_type_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.deleteCalendarItemTypeByIdsBlocking(
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

	async def delete_calendar_item_type_async(self, calendar_item_type: CalendarItemType) -> StoredDocumentIdentifier:
		def do_decode(raw_result):
			return StoredDocumentIdentifier._deserialize(raw_result)
		payload = {
			"calendarItemType": calendar_item_type.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.deleteCalendarItemTypeAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_calendar_item_type_blocking(self, calendar_item_type: CalendarItemType) -> StoredDocumentIdentifier:
		payload = {
			"calendarItemType": calendar_item_type.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.deleteCalendarItemTypeBlocking(
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

	async def delete_calendar_item_types_async(self, calendar_item_types: list[CalendarItemType]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"calendarItemTypes": [x0.__serialize__() for x0 in calendar_item_types],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.deleteCalendarItemTypesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_calendar_item_types_blocking(self, calendar_item_types: list[CalendarItemType]) -> list[StoredDocumentIdentifier]:
		payload = {
			"calendarItemTypes": [x0.__serialize__() for x0 in calendar_item_types],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.deleteCalendarItemTypesBlocking(
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

	async def undelete_calendar_item_type_by_id_async(self, entity_id: str, rev: str) -> CalendarItemType:
		def do_decode(raw_result):
			return CalendarItemType._deserialize(raw_result)
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.undeleteCalendarItemTypeByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_calendar_item_type_by_id_blocking(self, entity_id: str, rev: str) -> CalendarItemType:
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.undeleteCalendarItemTypeByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = CalendarItemType._deserialize(result_info.success)
			return return_value

	async def undelete_calendar_item_type_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[CalendarItemType]:
		def do_decode(raw_result):
			return [CalendarItemType._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.undeleteCalendarItemTypeByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_calendar_item_type_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[CalendarItemType]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.undeleteCalendarItemTypeByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [CalendarItemType._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def undelete_calendar_item_type_async(self, calendar_item_type: CalendarItemType) -> CalendarItemType:
		def do_decode(raw_result):
			return CalendarItemType._deserialize(raw_result)
		payload = {
			"calendarItemType": calendar_item_type.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.undeleteCalendarItemTypeAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_calendar_item_type_blocking(self, calendar_item_type: CalendarItemType) -> CalendarItemType:
		payload = {
			"calendarItemType": calendar_item_type.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.undeleteCalendarItemTypeBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = CalendarItemType._deserialize(result_info.success)
			return return_value

	async def undelete_calendar_item_types_async(self, calendar_item_types: list[CalendarItemType]) -> list[CalendarItemType]:
		def do_decode(raw_result):
			return [CalendarItemType._deserialize(x1) for x1 in raw_result]
		payload = {
			"calendarItemTypes": [x0.__serialize__() for x0 in calendar_item_types],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.undeleteCalendarItemTypesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_calendar_item_types_blocking(self, calendar_item_types: list[CalendarItemType]) -> list[CalendarItemType]:
		payload = {
			"calendarItemTypes": [x0.__serialize__() for x0 in calendar_item_types],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.undeleteCalendarItemTypesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [CalendarItemType._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def purge_calendar_item_type_by_id_async(self, entity_id: str, rev: str) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.purgeCalendarItemTypeByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_calendar_item_type_by_id_blocking(self, entity_id: str, rev: str) -> None:
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.purgeCalendarItemTypeByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_calendar_item_type_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.purgeCalendarItemTypeByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_calendar_item_type_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.purgeCalendarItemTypeByIdsBlocking(
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

	async def purge_calendar_item_type_async(self, calendar_item_type: CalendarItemType) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"calendarItemType": calendar_item_type.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.purgeCalendarItemTypeAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_calendar_item_type_blocking(self, calendar_item_type: CalendarItemType) -> None:
		payload = {
			"calendarItemType": calendar_item_type.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.purgeCalendarItemTypeBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_calendar_item_types_async(self, calendar_item_types: list[CalendarItemType]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"calendarItemTypes": [x0.__serialize__() for x0 in calendar_item_types],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.purgeCalendarItemTypesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_calendar_item_types_blocking(self, calendar_item_types: list[CalendarItemType]) -> list[StoredDocumentIdentifier]:
		payload = {
			"calendarItemTypes": [x0.__serialize__() for x0 in calendar_item_types],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.purgeCalendarItemTypesBlocking(
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

	async def list_calendar_item_types_by_agenda_id_async(self, agenda_id: str) -> list[CalendarItemType]:
		def do_decode(raw_result):
			return [CalendarItemType._deserialize(x1) for x1 in raw_result]
		payload = {
			"agendaId": agenda_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.listCalendarItemTypesByAgendaIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_calendar_item_types_by_agenda_id_blocking(self, agenda_id: str) -> list[CalendarItemType]:
		payload = {
			"agendaId": agenda_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.listCalendarItemTypesByAgendaIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [CalendarItemType._deserialize(x1) for x1 in result_info.success]
			return return_value


class CalendarItemTypeApiInGroup:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def create_calendar_item_type_async(self, calendar_item_type: GroupScoped[CalendarItemType]) -> GroupScoped[CalendarItemType]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: CalendarItemType._deserialize(x1))
		payload = {
			"calendarItemType": calendar_item_type.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.createCalendarItemTypeAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_calendar_item_type_blocking(self, calendar_item_type: GroupScoped[CalendarItemType]) -> GroupScoped[CalendarItemType]:
		payload = {
			"calendarItemType": calendar_item_type.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.createCalendarItemTypeBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: CalendarItemType._deserialize(x1))
			return return_value

	async def create_calendar_item_types_async(self, calendar_item_types: list[GroupScoped[CalendarItemType]]) -> list[GroupScoped[CalendarItemType]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: CalendarItemType._deserialize(x2)) for x1 in raw_result]
		payload = {
			"calendarItemTypes": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in calendar_item_types],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.createCalendarItemTypesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_calendar_item_types_blocking(self, calendar_item_types: list[GroupScoped[CalendarItemType]]) -> list[GroupScoped[CalendarItemType]]:
		payload = {
			"calendarItemTypes": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in calendar_item_types],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.createCalendarItemTypesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: CalendarItemType._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def get_calendar_item_type_async(self, group_id: str, calendar_item_type_id: str) -> Optional[GroupScoped[CalendarItemType]]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: CalendarItemType._deserialize(x1)) if raw_result is not None else None
		payload = {
			"groupId": group_id,
			"calendarItemTypeId": calendar_item_type_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.getCalendarItemTypeAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_calendar_item_type_blocking(self, group_id: str, calendar_item_type_id: str) -> Optional[GroupScoped[CalendarItemType]]:
		payload = {
			"groupId": group_id,
			"calendarItemTypeId": calendar_item_type_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.getCalendarItemTypeBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: CalendarItemType._deserialize(x1)) if result_info.success is not None else None
			return return_value

	async def get_calendar_item_types_async(self, group_id: str, calendar_item_types_ids: list[str]) -> list[GroupScoped[CalendarItemType]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: CalendarItemType._deserialize(x2)) for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"calendarItemTypesIds": [x0 for x0 in calendar_item_types_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.getCalendarItemTypesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_calendar_item_types_blocking(self, group_id: str, calendar_item_types_ids: list[str]) -> list[GroupScoped[CalendarItemType]]:
		payload = {
			"groupId": group_id,
			"calendarItemTypesIds": [x0 for x0 in calendar_item_types_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.getCalendarItemTypesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: CalendarItemType._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def modify_calendar_item_type_async(self, calendar_item_type: GroupScoped[CalendarItemType]) -> GroupScoped[CalendarItemType]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: CalendarItemType._deserialize(x1))
		payload = {
			"calendarItemType": calendar_item_type.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.modifyCalendarItemTypeAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_calendar_item_type_blocking(self, calendar_item_type: GroupScoped[CalendarItemType]) -> GroupScoped[CalendarItemType]:
		payload = {
			"calendarItemType": calendar_item_type.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.modifyCalendarItemTypeBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: CalendarItemType._deserialize(x1))
			return return_value

	async def modify_calendar_item_types_async(self, calendar_item_types: list[GroupScoped[CalendarItemType]]) -> list[GroupScoped[CalendarItemType]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: CalendarItemType._deserialize(x2)) for x1 in raw_result]
		payload = {
			"calendarItemTypes": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in calendar_item_types],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.modifyCalendarItemTypesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_calendar_item_types_blocking(self, calendar_item_types: list[GroupScoped[CalendarItemType]]) -> list[GroupScoped[CalendarItemType]]:
		payload = {
			"calendarItemTypes": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in calendar_item_types],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.modifyCalendarItemTypesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: CalendarItemType._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def delete_calendar_item_type_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: StoredDocumentIdentifier._deserialize(x1))
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.deleteCalendarItemTypeByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_calendar_item_type_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[StoredDocumentIdentifier]:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.deleteCalendarItemTypeByIdBlocking(
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

	async def delete_calendar_item_type_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.deleteCalendarItemTypeByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_calendar_item_type_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.deleteCalendarItemTypeByIdsBlocking(
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

	async def delete_calendar_item_type_async(self, calendar_item_type: GroupScoped[CalendarItemType]) -> GroupScoped[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: StoredDocumentIdentifier._deserialize(x1))
		payload = {
			"calendarItemType": calendar_item_type.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.deleteCalendarItemTypeAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_calendar_item_type_blocking(self, calendar_item_type: GroupScoped[CalendarItemType]) -> GroupScoped[StoredDocumentIdentifier]:
		payload = {
			"calendarItemType": calendar_item_type.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.deleteCalendarItemTypeBlocking(
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

	async def delete_calendar_item_types_async(self, calendar_item_types: list[GroupScoped[CalendarItemType]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"calendarItemTypes": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in calendar_item_types],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.deleteCalendarItemTypesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_calendar_item_types_blocking(self, calendar_item_types: list[GroupScoped[CalendarItemType]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"calendarItemTypes": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in calendar_item_types],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.deleteCalendarItemTypesBlocking(
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

	async def undelete_calendar_item_type_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[CalendarItemType]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: CalendarItemType._deserialize(x1))
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.undeleteCalendarItemTypeByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_calendar_item_type_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[CalendarItemType]:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.undeleteCalendarItemTypeByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: CalendarItemType._deserialize(x1))
			return return_value

	async def undelete_calendar_item_type_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[CalendarItemType]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: CalendarItemType._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.undeleteCalendarItemTypeByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_calendar_item_type_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[CalendarItemType]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.undeleteCalendarItemTypeByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: CalendarItemType._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def undelete_calendar_item_type_async(self, calendar_item_type: GroupScoped[CalendarItemType]) -> GroupScoped[CalendarItemType]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: CalendarItemType._deserialize(x1))
		payload = {
			"calendarItemType": calendar_item_type.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.undeleteCalendarItemTypeAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_calendar_item_type_blocking(self, calendar_item_type: GroupScoped[CalendarItemType]) -> GroupScoped[CalendarItemType]:
		payload = {
			"calendarItemType": calendar_item_type.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.undeleteCalendarItemTypeBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: CalendarItemType._deserialize(x1))
			return return_value

	async def undelete_calendar_item_types_async(self, calendar_item_types: list[GroupScoped[CalendarItemType]]) -> list[GroupScoped[CalendarItemType]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: CalendarItemType._deserialize(x2)) for x1 in raw_result]
		payload = {
			"calendarItemTypes": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in calendar_item_types],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.undeleteCalendarItemTypesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_calendar_item_types_blocking(self, calendar_item_types: list[GroupScoped[CalendarItemType]]) -> list[GroupScoped[CalendarItemType]]:
		payload = {
			"calendarItemTypes": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in calendar_item_types],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.undeleteCalendarItemTypesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: CalendarItemType._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def purge_calendar_item_type_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.purgeCalendarItemTypeByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_calendar_item_type_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> None:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.purgeCalendarItemTypeByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_calendar_item_type_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.purgeCalendarItemTypeByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_calendar_item_type_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.purgeCalendarItemTypeByIdsBlocking(
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

	async def purge_calendar_item_type_async(self, calendar_item_type: GroupScoped[CalendarItemType]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"calendarItemType": calendar_item_type.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.purgeCalendarItemTypeAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_calendar_item_type_blocking(self, calendar_item_type: GroupScoped[CalendarItemType]) -> None:
		payload = {
			"calendarItemType": calendar_item_type.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.purgeCalendarItemTypeBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_calendar_item_types_async(self, calendar_item_types: list[GroupScoped[CalendarItemType]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"calendarItemTypes": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in calendar_item_types],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.purgeCalendarItemTypesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_calendar_item_types_blocking(self, calendar_item_types: list[GroupScoped[CalendarItemType]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"calendarItemTypes": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in calendar_item_types],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.inGroup.purgeCalendarItemTypesBlocking(
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
