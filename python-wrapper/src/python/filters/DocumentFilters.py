# auto-generated file
import json
from cardinal_sdk.model import Patient, serialize_patient, Document, Message, serialize_message, DocumentType
from typing import Optional
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.filters.FilterOptions import SortableFilterOptions, BaseSortableFilterOptions, FilterOptions


class DocumentFilters:

	@classmethod
	def by_patients_created_for_data_owner(cls, data_owner_id: str, patients: list[Patient], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> SortableFilterOptions[Document]:
		payload = {
			"dataOwnerId": data_owner_id,
			"patients": [serialize_patient(x0) for x0 in patients],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.DocumentFilters.byPatientsCreatedForDataOwner(
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
	def by_messages_created_for_data_owner(cls, data_owner_id: str, messages: list[Message], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> SortableFilterOptions[Document]:
		payload = {
			"dataOwnerId": data_owner_id,
			"messages": [serialize_message(x0) for x0 in messages],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.DocumentFilters.byMessagesCreatedForDataOwner(
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
	def by_patients_created_for_self(cls, patients: list[Patient], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> SortableFilterOptions[Document]:
		payload = {
			"patients": [serialize_patient(x0) for x0 in patients],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.DocumentFilters.byPatientsCreatedForSelf(
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
	def by_messages_created_for_self(cls, messages: list[Message], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> SortableFilterOptions[Document]:
		payload = {
			"messages": [serialize_message(x0) for x0 in messages],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.DocumentFilters.byMessagesCreatedForSelf(
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
	def by_owning_entity_secret_ids_created_for_data_owner(cls, data_owner_id: str, secret_ids: list[str], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> BaseSortableFilterOptions[Document]:
		payload = {
			"dataOwnerId": data_owner_id,
			"secretIds": [x0 for x0 in secret_ids],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.DocumentFilters.byOwningEntitySecretIdsCreatedForDataOwner(
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
	def by_owning_entity_secret_ids_created_for_self(cls, secret_ids: list[str], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> SortableFilterOptions[Document]:
		payload = {
			"secretIds": [x0 for x0 in secret_ids],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.DocumentFilters.byOwningEntitySecretIdsCreatedForSelf(
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
	def by_patients_and_type_for_data_owner(cls, data_owner_id: str, document_type: DocumentType, patients: list[Patient]) -> FilterOptions[Document]:
		payload = {
			"dataOwnerId": data_owner_id,
			"documentType": document_type.__serialize__(),
			"patients": [serialize_patient(x0) for x0 in patients],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.DocumentFilters.byPatientsAndTypeForDataOwner(
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
	def by_messages_and_type_for_data_owner(cls, data_owner_id: str, document_type: DocumentType, messages: list[Message]) -> FilterOptions[Document]:
		payload = {
			"dataOwnerId": data_owner_id,
			"documentType": document_type.__serialize__(),
			"messages": [serialize_message(x0) for x0 in messages],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.DocumentFilters.byMessagesAndTypeForDataOwner(
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
	def by_patients_and_type_for_self(cls, document_type: DocumentType, patients: list[Patient]) -> FilterOptions[Document]:
		payload = {
			"documentType": document_type.__serialize__(),
			"patients": [serialize_patient(x0) for x0 in patients],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.DocumentFilters.byPatientsAndTypeForSelf(
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
	def by_messages_and_type_for_self(cls, document_type: DocumentType, messages: list[Message]) -> FilterOptions[Document]:
		payload = {
			"documentType": document_type.__serialize__(),
			"messages": [serialize_message(x0) for x0 in messages],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.DocumentFilters.byMessagesAndTypeForSelf(
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
	def by_owning_entity_secret_ids_and_type_for_data_owner(cls, data_owner_id: str, document_type: DocumentType, secret_ids: list[str]) -> FilterOptions[Document]:
		payload = {
			"dataOwnerId": data_owner_id,
			"documentType": document_type.__serialize__(),
			"secretIds": [x0 for x0 in secret_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.DocumentFilters.byOwningEntitySecretIdsAndTypeForDataOwner(
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
	def by_owning_entity_secret_ids_and_type_for_self(cls, document_type: DocumentType, secret_ids: list[str]) -> FilterOptions[Document]:
		payload = {
			"documentType": document_type.__serialize__(),
			"secretIds": [x0 for x0 in secret_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.DocumentFilters.byOwningEntitySecretIdsAndTypeForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = FilterOptions(result_info.success)
			return return_value
