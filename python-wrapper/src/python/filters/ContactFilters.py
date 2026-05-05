# auto-generated file
import json
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.filters.FilterOptions import BaseFilterOptions, FilterOptions, SortableFilterOptions, BaseSortableFilterOptions
from cardinal_sdk.model import Contact, EntityReferenceInGroup, Patient, serialize_patient, GroupScoped, Identifier
from typing import Optional


class ContactFilters:

	@classmethod
	def all_contacts_for_data_owner(cls, data_owner_id: str) -> BaseFilterOptions[Contact]:
		payload = {
			"dataOwnerId": data_owner_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.allContactsForDataOwner(
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
	def all_contacts_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup) -> BaseFilterOptions[Contact]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.allContactsForDataOwnerInGroup(
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
	def all_contacts_for_self(cls) -> FilterOptions[Contact]:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.allContactsForSelf(
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = FilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_form_ids_for_data_owner(cls, data_owner_id: str, form_ids: set[str]) -> BaseFilterOptions[Contact]:
		payload = {
			"dataOwnerId": data_owner_id,
			"formIds": [x0 for x0 in form_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byFormIdsForDataOwner(
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
	def by_form_ids_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, form_ids: set[str]) -> BaseFilterOptions[Contact]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"formIds": [x0 for x0 in form_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byFormIdsForDataOwnerInGroup(
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
	def by_form_ids_for_self(cls, form_ids: set[str]) -> FilterOptions[Contact]:
		payload = {
			"formIds": [x0 for x0 in form_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byFormIdsForSelf(
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
	def by_patients_opening_date_for_data_owner(cls, data_owner_id: str, patients: list[Patient], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> SortableFilterOptions[Contact]:
		payload = {
			"dataOwnerId": data_owner_id,
			"patients": [serialize_patient(x0) for x0 in patients],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byPatientsOpeningDateForDataOwner(
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
	def by_patients_opening_date_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, patients: list[GroupScoped[Patient]], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> SortableFilterOptions[Contact]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"patients": [x0.__serialize__(lambda x1: serialize_patient(x1)) for x0 in patients],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byPatientsOpeningDateForDataOwnerInGroup(
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
	def by_patients_opening_date_for_self(cls, patients: list[Patient], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> SortableFilterOptions[Contact]:
		payload = {
			"patients": [serialize_patient(x0) for x0 in patients],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byPatientsOpeningDateForSelf(
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
	def by_patient_secret_ids_opening_date_for_data_owner(cls, data_owner_id: str, secret_ids: list[str], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> BaseSortableFilterOptions[Contact]:
		payload = {
			"dataOwnerId": data_owner_id,
			"secretIds": [x0 for x0 in secret_ids],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byPatientSecretIdsOpeningDateForDataOwner(
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
	def by_patient_secret_ids_opening_date_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, secret_ids: list[str], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> BaseSortableFilterOptions[Contact]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"secretIds": [x0 for x0 in secret_ids],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byPatientSecretIdsOpeningDateForDataOwnerInGroup(
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
	def by_patient_secret_ids_opening_date_for_self(cls, secret_ids: list[str], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> SortableFilterOptions[Contact]:
		payload = {
			"secretIds": [x0 for x0 in secret_ids],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byPatientSecretIdsOpeningDateForSelf(
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
	def by_identifiers_for_self(cls, identifiers: list[Identifier]) -> SortableFilterOptions[Contact]:
		payload = {
			"identifiers": [x0.__serialize__() for x0 in identifiers],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byIdentifiersForSelf(
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
	def by_identifiers_for_data_owner(cls, data_owner_id: str, identifiers: list[Identifier]) -> BaseSortableFilterOptions[Contact]:
		payload = {
			"dataOwnerId": data_owner_id,
			"identifiers": [x0.__serialize__() for x0 in identifiers],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byIdentifiersForDataOwner(
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
	def by_identifiers_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, identifiers: list[Identifier]) -> BaseSortableFilterOptions[Contact]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"identifiers": [x0.__serialize__() for x0 in identifiers],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byIdentifiersForDataOwnerInGroup(
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
	def by_code_and_opening_date_for_data_owner(cls, data_owner_id: str, code_type: str, code_code: Optional[str] = None, start_of_contact_opening_date: Optional[int] = None, end_of_contact_opening_date: Optional[int] = None) -> BaseSortableFilterOptions[Contact]:
		payload = {
			"dataOwnerId": data_owner_id,
			"codeType": code_type,
			"codeCode": code_code,
			"startOfContactOpeningDate": start_of_contact_opening_date,
			"endOfContactOpeningDate": end_of_contact_opening_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byCodeAndOpeningDateForDataOwner(
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
	def by_code_and_opening_date_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, code_type: str, code_code: Optional[str] = None, start_of_contact_opening_date: Optional[int] = None, end_of_contact_opening_date: Optional[int] = None) -> BaseSortableFilterOptions[Contact]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"codeType": code_type,
			"codeCode": code_code,
			"startOfContactOpeningDate": start_of_contact_opening_date,
			"endOfContactOpeningDate": end_of_contact_opening_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byCodeAndOpeningDateForDataOwnerInGroup(
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
	def by_code_and_opening_date_for_self(cls, code_type: str, code_code: Optional[str] = None, start_of_contact_opening_date: Optional[int] = None, end_of_contact_opening_date: Optional[int] = None) -> SortableFilterOptions[Contact]:
		payload = {
			"codeType": code_type,
			"codeCode": code_code,
			"startOfContactOpeningDate": start_of_contact_opening_date,
			"endOfContactOpeningDate": end_of_contact_opening_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byCodeAndOpeningDateForSelf(
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
	def by_tag_and_opening_date_for_data_owner(cls, data_owner_id: str, tag_type: str, tag_code: Optional[str] = None, start_of_contact_opening_date: Optional[int] = None, end_of_contact_opening_date: Optional[int] = None) -> BaseSortableFilterOptions[Contact]:
		payload = {
			"dataOwnerId": data_owner_id,
			"tagType": tag_type,
			"tagCode": tag_code,
			"startOfContactOpeningDate": start_of_contact_opening_date,
			"endOfContactOpeningDate": end_of_contact_opening_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byTagAndOpeningDateForDataOwner(
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
	def by_tag_and_opening_date_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, tag_type: str, tag_code: Optional[str] = None, start_of_contact_opening_date: Optional[int] = None, end_of_contact_opening_date: Optional[int] = None) -> BaseSortableFilterOptions[Contact]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"tagType": tag_type,
			"tagCode": tag_code,
			"startOfContactOpeningDate": start_of_contact_opening_date,
			"endOfContactOpeningDate": end_of_contact_opening_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byTagAndOpeningDateForDataOwnerInGroup(
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
	def by_opening_date_for_data_owner(cls, data_owner_id: str, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: bool = False) -> BaseSortableFilterOptions[Contact]:
		payload = {
			"dataOwnerId": data_owner_id,
			"startDate": start_date,
			"endDate": end_date,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byOpeningDateForDataOwner(
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
	def by_opening_date_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: bool = False) -> BaseSortableFilterOptions[Contact]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"startDate": start_date,
			"endDate": end_date,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byOpeningDateForDataOwnerInGroup(
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
	def by_opening_date_for_self(cls, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: bool = False) -> SortableFilterOptions[Contact]:
		payload = {
			"startDate": start_date,
			"endDate": end_date,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byOpeningDateForSelf(
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
	def by_service_tag_for_self(cls, tag_type: str, tag_code: Optional[str] = None) -> FilterOptions[Contact]:
		payload = {
			"tagType": tag_type,
			"tagCode": tag_code,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byServiceTagForSelf(
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
	def by_service_tag_for_data_owner(cls, data_owner_id: str, tag_type: str, tag_code: Optional[str] = None) -> BaseFilterOptions[Contact]:
		payload = {
			"dataOwnerId": data_owner_id,
			"tagType": tag_type,
			"tagCode": tag_code,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byServiceTagForDataOwner(
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
	def by_service_tag_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, tag_type: str, tag_code: Optional[str] = None) -> BaseFilterOptions[Contact]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"tagType": tag_type,
			"tagCode": tag_code,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byServiceTagForDataOwnerInGroup(
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
	def by_service_code_for_self(cls, code_type: str, code_code: Optional[str] = None) -> FilterOptions[Contact]:
		payload = {
			"codeType": code_type,
			"codeCode": code_code,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byServiceCodeForSelf(
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
	def by_service_code_for_data_owner(cls, data_owner_id: str, code_type: str, code_code: Optional[str] = None) -> BaseFilterOptions[Contact]:
		payload = {
			"dataOwnerId": data_owner_id,
			"codeType": code_type,
			"codeCode": code_code,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byServiceCodeForDataOwner(
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
	def by_service_code_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, code_type: str, code_code: Optional[str] = None) -> BaseFilterOptions[Contact]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"codeType": code_type,
			"codeCode": code_code,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byServiceCodeForDataOwnerInGroup(
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
	def by_tag_and_opening_date_for_self(cls, tag_type: str, tag_code: Optional[str] = None, start_of_contact_opening_date: Optional[int] = None, end_of_contact_opening_date: Optional[int] = None) -> SortableFilterOptions[Contact]:
		payload = {
			"tagType": tag_type,
			"tagCode": tag_code,
			"startOfContactOpeningDate": start_of_contact_opening_date,
			"endOfContactOpeningDate": end_of_contact_opening_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byTagAndOpeningDateForSelf(
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
	def by_patients_for_data_owner(cls, data_owner_id: str, patients: list[Patient]) -> SortableFilterOptions[Contact]:
		payload = {
			"dataOwnerId": data_owner_id,
			"patients": [serialize_patient(x0) for x0 in patients],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byPatientsForDataOwner(
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
	def by_patients_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, patients: list[GroupScoped[Patient]]) -> SortableFilterOptions[Contact]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"patients": [x0.__serialize__(lambda x1: serialize_patient(x1)) for x0 in patients],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byPatientsForDataOwnerInGroup(
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
	def by_patients_for_self(cls, patients: list[Patient]) -> SortableFilterOptions[Contact]:
		payload = {
			"patients": [serialize_patient(x0) for x0 in patients],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byPatientsForSelf(
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
	def by_patients_secret_ids_for_data_owner(cls, data_owner_id: str, secret_ids: list[str]) -> BaseSortableFilterOptions[Contact]:
		payload = {
			"dataOwnerId": data_owner_id,
			"secretIds": [x0 for x0 in secret_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byPatientsSecretIdsForDataOwner(
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
	def by_patients_secret_ids_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, secret_ids: list[str]) -> BaseSortableFilterOptions[Contact]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"secretIds": [x0 for x0 in secret_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byPatientsSecretIdsForDataOwnerInGroup(
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
	def by_patients_secret_ids_for_self(cls, secret_ids: list[str]) -> SortableFilterOptions[Contact]:
		payload = {
			"secretIds": [x0 for x0 in secret_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byPatientsSecretIdsForSelf(
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
	def by_service_ids(cls, service_ids: list[str]) -> BaseSortableFilterOptions[Contact]:
		payload = {
			"serviceIds": [x0 for x0 in service_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ContactFilters.byServiceIds(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseSortableFilterOptions(result_info.success)
			return return_value
