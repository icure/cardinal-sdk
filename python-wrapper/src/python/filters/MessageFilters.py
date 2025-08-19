# auto-generated file
import json
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.filters.FilterOptions import BaseFilterOptions, FilterOptions, BaseSortableFilterOptions, SortableFilterOptions
from cardinal_sdk.model import Message, Patient, serialize_patient, EntityReferenceInGroup
from typing import Optional


class MessageFilters:

	@classmethod
	def all_messages_for_data_owner(cls, data_owner_id: str) -> BaseFilterOptions[Message]:
		payload = {
			"dataOwnerId": data_owner_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.MessageFilters.allMessagesForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def all_messages_for_self(cls) -> FilterOptions[Message]:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.MessageFilters.allMessagesForSelf(
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = FilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_transport_guid_for_data_owner(cls, data_owner_id: str, transport_guid: str) -> BaseSortableFilterOptions[Message]:
		payload = {
			"dataOwnerId": data_owner_id,
			"transportGuid": transport_guid,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.MessageFilters.byTransportGuidForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseSortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_transport_guid_for_self(cls, transport_guid: str) -> SortableFilterOptions[Message]:
		payload = {
			"transportGuid": transport_guid,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.MessageFilters.byTransportGuidForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = SortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def from_address_for_data_owner(cls, data_owner_id: str, address: str) -> BaseFilterOptions[Message]:
		payload = {
			"dataOwnerId": data_owner_id,
			"address": address,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.MessageFilters.fromAddressForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def from_address_for_self(cls, address: str) -> FilterOptions[Message]:
		payload = {
			"address": address,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.MessageFilters.fromAddressForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = FilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_patients_sent_date_for_data_owner(cls, data_owner_id: str, patients: list[Patient], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> SortableFilterOptions[Message]:
		payload = {
			"dataOwnerId": data_owner_id,
			"patients": [serialize_patient(x0) for x0 in patients],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.MessageFilters.byPatientsSentDateForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = SortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_patients_sent_date_for_self(cls, patients: list[Patient], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> SortableFilterOptions[Message]:
		payload = {
			"patients": [serialize_patient(x0) for x0 in patients],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.MessageFilters.byPatientsSentDateForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = SortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_patient_secret_ids_sent_date_for_data_owner(cls, data_owner_id: str, secret_ids: list[str], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> BaseSortableFilterOptions[Message]:
		payload = {
			"dataOwnerId": data_owner_id,
			"secretIds": [x0 for x0 in secret_ids],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.MessageFilters.byPatientSecretIdsSentDateForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseSortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_patient_secret_ids_sent_date_for_self(cls, secret_ids: list[str], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> SortableFilterOptions[Message]:
		payload = {
			"secretIds": [x0 for x0 in secret_ids],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.MessageFilters.byPatientSecretIdsSentDateForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = SortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def to_address_for_data_owner(cls, data_owner_id: str, address: str) -> BaseFilterOptions[Message]:
		payload = {
			"dataOwnerId": data_owner_id,
			"address": address,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.MessageFilters.toAddressForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def to_address_for_self(cls, address: str) -> FilterOptions[Message]:
		payload = {
			"address": address,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.MessageFilters.toAddressForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = FilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_transport_guid_sent_date_for_data_owner(cls, data_owner_id: str, transport_guid: str, from_: Optional[int], to: Optional[int], descending: bool = False) -> BaseSortableFilterOptions[Message]:
		payload = {
			"dataOwnerId": data_owner_id,
			"transportGuid": transport_guid,
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.MessageFilters.byTransportGuidSentDateForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseSortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_transport_guid_sent_date_for_self(cls, transport_guid: str, from_: Optional[int], to: Optional[int], descending: bool = False) -> SortableFilterOptions[Message]:
		payload = {
			"transportGuid": transport_guid,
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.MessageFilters.byTransportGuidSentDateForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = SortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def latest_by_transport_guid_for_data_owner(cls, data_owner_id: str, transport_guid: str) -> BaseFilterOptions[Message]:
		payload = {
			"dataOwnerId": data_owner_id,
			"transportGuid": transport_guid,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.MessageFilters.latestByTransportGuidForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def latest_by_transport_guid_for_self(cls, transport_guid: str) -> FilterOptions[Message]:
		payload = {
			"transportGuid": transport_guid,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.MessageFilters.latestByTransportGuidForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = FilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_invoice_ids(cls, invoice_ids: set[str]) -> BaseFilterOptions[Message]:
		payload = {
			"invoiceIds": [x0 for x0 in invoice_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.MessageFilters.byInvoiceIds(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_parent_ids(cls, parent_ids: list[str]) -> BaseFilterOptions[Message]:
		payload = {
			"parentIds": [x0 for x0 in parent_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.MessageFilters.byParentIds(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def lifecycle_between_for_data_owner(cls, data_owner_id: str, start_timestamp: Optional[int], end_timestamp: Optional[int], descending: bool) -> BaseFilterOptions[Message]:
		payload = {
			"dataOwnerId": data_owner_id,
			"startTimestamp": start_timestamp,
			"endTimestamp": end_timestamp,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.MessageFilters.lifecycleBetweenForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def lifecycle_between_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, start_timestamp: Optional[int], end_timestamp: Optional[int], descending: bool) -> BaseFilterOptions[Message]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"startTimestamp": start_timestamp,
			"endTimestamp": end_timestamp,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.MessageFilters.lifecycleBetweenForDataOwnerInGroup(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def lifecycle_between_for_self(cls, start_timestamp: Optional[int], end_timestamp: Optional[int], descending: bool) -> FilterOptions[Message]:
		payload = {
			"startTimestamp": start_timestamp,
			"endTimestamp": end_timestamp,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.MessageFilters.lifecycleBetweenForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = FilterOptions(result_info.success)
			return return_value
