# auto-generated file
import json
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.filters.FilterOptions import BaseFilterOptions, FilterOptions, BaseSortableFilterOptions, SortableFilterOptions
from cardinal_sdk.model import Service, EntityReferenceInGroup, Identifier, Patient, serialize_patient, LinkQualification
from typing import Optional


class ServiceFilters:

	@classmethod
	def all_services_for_data_owner(cls, data_owner_id: str) -> BaseFilterOptions[Service]:
		payload = {
			"dataOwnerId": data_owner_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.allServicesForDataOwner(
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
	def all_services_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup) -> BaseFilterOptions[Service]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.allServicesForDataOwnerInGroup(
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
	def all_services_for_self(cls) -> FilterOptions[Service]:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.allServicesForSelf(
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = FilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_identifiers_for_data_owner(cls, data_owner_id: str, identifiers: list[Identifier]) -> BaseSortableFilterOptions[Service]:
		payload = {
			"dataOwnerId": data_owner_id,
			"identifiers": [x0.__serialize__() for x0 in identifiers],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byIdentifiersForDataOwner(
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
	def by_identifiers_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, identifiers: list[Identifier]) -> BaseSortableFilterOptions[Service]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"identifiers": [x0.__serialize__() for x0 in identifiers],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byIdentifiersForDataOwnerInGroup(
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
	def by_code_and_value_date_for_data_owner(cls, data_owner_id: str, code_type: str, code_code: Optional[str] = None, start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> BaseSortableFilterOptions[Service]:
		payload = {
			"dataOwnerId": data_owner_id,
			"codeType": code_type,
			"codeCode": code_code,
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byCodeAndValueDateForDataOwner(
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
	def by_code_and_value_date_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, code_type: str, code_code: Optional[str] = None, start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> BaseSortableFilterOptions[Service]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"codeType": code_type,
			"codeCode": code_code,
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byCodeAndValueDateForDataOwnerInGroup(
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
	def by_tag_and_value_date_for_data_owner(cls, data_owner_id: str, tag_type: str, tag_code: Optional[str] = None, start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> BaseSortableFilterOptions[Service]:
		payload = {
			"dataOwnerId": data_owner_id,
			"tagType": tag_type,
			"tagCode": tag_code,
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byTagAndValueDateForDataOwner(
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
	def by_tag_and_value_date_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, tag_type: str, tag_code: Optional[str] = None, start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> BaseSortableFilterOptions[Service]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"tagType": tag_type,
			"tagCode": tag_code,
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byTagAndValueDateForDataOwnerInGroup(
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
	def by_patients_for_data_owner(cls, data_owner_id: str, patients: list[Patient]) -> SortableFilterOptions[Service]:
		payload = {
			"dataOwnerId": data_owner_id,
			"patients": [serialize_patient(x0) for x0 in patients],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientsForDataOwner(
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
	def by_patients_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, patients: list[Patient]) -> SortableFilterOptions[Service]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"patients": [serialize_patient(x0) for x0 in patients],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientsForDataOwnerInGroup(
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
	def by_patients_secret_ids_for_data_owner(cls, data_owner_id: str, secret_ids: list[str]) -> BaseSortableFilterOptions[Service]:
		payload = {
			"dataOwnerId": data_owner_id,
			"secretIds": [x0 for x0 in secret_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientsSecretIdsForDataOwner(
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
	def by_patients_secret_ids_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, secret_ids: list[str]) -> BaseSortableFilterOptions[Service]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"secretIds": [x0 for x0 in secret_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientsSecretIdsForDataOwnerInGroup(
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
	def by_health_element_id_from_sub_contact_for_data_owner(cls, data_owner_id: str, health_element_ids: list[str]) -> BaseSortableFilterOptions[Service]:
		payload = {
			"dataOwnerId": data_owner_id,
			"healthElementIds": [x0 for x0 in health_element_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byHealthElementIdFromSubContactForDataOwner(
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
	def by_health_element_id_from_sub_contact_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, health_element_ids: list[str]) -> BaseSortableFilterOptions[Service]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"healthElementIds": [x0 for x0 in health_element_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byHealthElementIdFromSubContactForDataOwnerInGroup(
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
	def by_identifiers_for_self(cls, identifiers: list[Identifier]) -> SortableFilterOptions[Service]:
		payload = {
			"identifiers": [x0.__serialize__() for x0 in identifiers],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byIdentifiersForSelf(
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
	def by_code_and_value_date_for_self(cls, code_type: str, code_code: Optional[str] = None, start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> SortableFilterOptions[Service]:
		payload = {
			"codeType": code_type,
			"codeCode": code_code,
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byCodeAndValueDateForSelf(
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
	def by_tag_and_value_date_for_self(cls, tag_type: str, tag_code: Optional[str] = None, start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> SortableFilterOptions[Service]:
		payload = {
			"tagType": tag_type,
			"tagCode": tag_code,
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byTagAndValueDateForSelf(
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
	def by_patients_for_self(cls, patients: list[Patient]) -> SortableFilterOptions[Service]:
		payload = {
			"patients": [serialize_patient(x0) for x0 in patients],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientsForSelf(
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
	def by_patients_secret_ids_for_self(cls, secret_ids: list[str]) -> SortableFilterOptions[Service]:
		payload = {
			"secretIds": [x0 for x0 in secret_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientsSecretIdsForSelf(
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
	def by_health_element_id_from_sub_contact_for_self(cls, health_element_ids: list[str]) -> SortableFilterOptions[Service]:
		payload = {
			"healthElementIds": [x0 for x0 in health_element_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byHealthElementIdFromSubContactForSelf(
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
	def by_ids(cls, ids: list[str]) -> BaseSortableFilterOptions[Service]:
		payload = {
			"ids": [x0 for x0 in ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byIds(
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
	def by_association_id(cls, association_id: str) -> BaseFilterOptions[Service]:
		payload = {
			"associationId": association_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byAssociationId(
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
	def by_qualified_link(cls, link_values: list[str], link_qualification: Optional[LinkQualification] = None) -> BaseFilterOptions[Service]:
		payload = {
			"linkValues": [x0 for x0 in link_values],
			"linkQualification": link_qualification.__serialize__() if link_qualification is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byQualifiedLink(
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
	def by_patients_date_for_data_owner(cls, data_owner_id: str, patients: list[Patient], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> SortableFilterOptions[Service]:
		payload = {
			"dataOwnerId": data_owner_id,
			"patients": [serialize_patient(x0) for x0 in patients],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientsDateForDataOwner(
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
	def by_patients_date_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, patients: list[Patient], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> SortableFilterOptions[Service]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"patients": [serialize_patient(x0) for x0 in patients],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientsDateForDataOwnerInGroup(
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
	def by_patients_date_for_self(cls, patients: list[Patient], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> SortableFilterOptions[Service]:
		payload = {
			"patients": [serialize_patient(x0) for x0 in patients],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientsDateForSelf(
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
	def by_patient_secret_ids_date_for_data_owner(cls, data_owner_id: str, secret_ids: list[str], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> BaseSortableFilterOptions[Service]:
		payload = {
			"dataOwnerId": data_owner_id,
			"secretIds": [x0 for x0 in secret_ids],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientSecretIdsDateForDataOwner(
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
	def by_patient_secret_ids_date_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, secret_ids: list[str], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> BaseSortableFilterOptions[Service]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"secretIds": [x0 for x0 in secret_ids],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientSecretIdsDateForDataOwnerInGroup(
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
	def by_patient_secret_ids_date_for_self(cls, secret_ids: list[str], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> SortableFilterOptions[Service]:
		payload = {
			"secretIds": [x0 for x0 in secret_ids],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientSecretIdsDateForSelf(
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
	def by_codes_and_value_date_for_data_owner(cls, data_owner_id: str, code_codes: dict[str, set[str]], start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> BaseFilterOptions[Service]:
		payload = {
			"dataOwnerId": data_owner_id,
			"codeCodes": {k0: [x1 for x1 in v0] for k0, v0 in code_codes.items()},
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byCodesAndValueDateForDataOwner(
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
	def by_codes_and_value_date_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, code_codes: dict[str, set[str]], start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> BaseFilterOptions[Service]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"codeCodes": {k0: [x1 for x1 in v0] for k0, v0 in code_codes.items()},
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byCodesAndValueDateForDataOwnerInGroup(
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
	def by_codes_and_value_date_for_self(cls, code_codes: dict[str, set[str]], start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> FilterOptions[Service]:
		payload = {
			"codeCodes": {k0: [x1 for x1 in v0] for k0, v0 in code_codes.items()},
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byCodesAndValueDateForSelf(
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
	def by_code_prefix_and_value_date_for_data_owner(cls, data_owner_id: str, code_type: str, code_code_prefix: str, start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> BaseFilterOptions[Service]:
		payload = {
			"dataOwnerId": data_owner_id,
			"codeType": code_type,
			"codeCodePrefix": code_code_prefix,
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byCodePrefixAndValueDateForDataOwner(
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
	def by_code_prefix_and_value_date_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, code_type: str, code_code_prefix: str, start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> BaseFilterOptions[Service]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"codeType": code_type,
			"codeCodePrefix": code_code_prefix,
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byCodePrefixAndValueDateForDataOwnerInGroup(
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
	def by_code_prefix_and_value_date_for_self(cls, code_type: str, code_code_prefix: str, start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> FilterOptions[Service]:
		payload = {
			"codeType": code_type,
			"codeCodePrefix": code_code_prefix,
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byCodePrefixAndValueDateForSelf(
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
	def by_tag_codes_and_value_date_for_data_owner(cls, data_owner_id: str, tag_codes: dict[str, set[str]], start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> BaseFilterOptions[Service]:
		payload = {
			"dataOwnerId": data_owner_id,
			"tagCodes": {k0: [x1 for x1 in v0] for k0, v0 in tag_codes.items()},
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byTagCodesAndValueDateForDataOwner(
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
	def by_tag_codes_and_value_date_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, tag_codes: dict[str, set[str]], start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> BaseFilterOptions[Service]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"tagCodes": {k0: [x1 for x1 in v0] for k0, v0 in tag_codes.items()},
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byTagCodesAndValueDateForDataOwnerInGroup(
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
	def by_tag_codes_and_value_date_for_self(cls, tag_codes: dict[str, set[str]], start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> FilterOptions[Service]:
		payload = {
			"tagCodes": {k0: [x1 for x1 in v0] for k0, v0 in tag_codes.items()},
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byTagCodesAndValueDateForSelf(
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
	def by_tag_prefix_and_value_date_for_data_owner(cls, data_owner_id: str, tag_type: str, tag_code_prefix: str, start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> BaseFilterOptions[Service]:
		payload = {
			"dataOwnerId": data_owner_id,
			"tagType": tag_type,
			"tagCodePrefix": tag_code_prefix,
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byTagPrefixAndValueDateForDataOwner(
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
	def by_tag_prefix_and_value_date_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, tag_type: str, tag_code_prefix: str, start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> BaseFilterOptions[Service]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"tagType": tag_type,
			"tagCodePrefix": tag_code_prefix,
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byTagPrefixAndValueDateForDataOwnerInGroup(
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
	def by_tag_prefix_and_value_date_for_self(cls, tag_type: str, tag_code_prefix: str, start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> FilterOptions[Service]:
		payload = {
			"tagType": tag_type,
			"tagCodePrefix": tag_code_prefix,
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byTagPrefixAndValueDateForSelf(
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
	def by_patients_codes_and_value_date_for_data_owner(cls, data_owner_id: str, patients: list[Patient], code_codes: dict[str, set[str]], start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> FilterOptions[Service]:
		payload = {
			"dataOwnerId": data_owner_id,
			"patients": [serialize_patient(x0) for x0 in patients],
			"codeCodes": {k0: [x1 for x1 in v0] for k0, v0 in code_codes.items()},
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientsCodesAndValueDateForDataOwner(
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
	def by_patients_codes_and_value_date_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, patients: list[Patient], code_codes: dict[str, set[str]], start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> FilterOptions[Service]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"patients": [serialize_patient(x0) for x0 in patients],
			"codeCodes": {k0: [x1 for x1 in v0] for k0, v0 in code_codes.items()},
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientsCodesAndValueDateForDataOwnerInGroup(
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
	def by_patients_codes_and_value_date_for_self(cls, patients: list[Patient], code_codes: dict[str, set[str]], start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> FilterOptions[Service]:
		payload = {
			"patients": [serialize_patient(x0) for x0 in patients],
			"codeCodes": {k0: [x1 for x1 in v0] for k0, v0 in code_codes.items()},
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientsCodesAndValueDateForSelf(
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
	def by_patient_secret_ids_codes_and_value_date_for_data_owner(cls, data_owner_id: str, secret_ids: list[str], code_codes: dict[str, set[str]], start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> BaseFilterOptions[Service]:
		payload = {
			"dataOwnerId": data_owner_id,
			"secretIds": [x0 for x0 in secret_ids],
			"codeCodes": {k0: [x1 for x1 in v0] for k0, v0 in code_codes.items()},
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientSecretIdsCodesAndValueDateForDataOwner(
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
	def by_patient_secret_ids_codes_and_value_date_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, secret_ids: list[str], code_codes: dict[str, set[str]], start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> BaseFilterOptions[Service]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"secretIds": [x0 for x0 in secret_ids],
			"codeCodes": {k0: [x1 for x1 in v0] for k0, v0 in code_codes.items()},
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientSecretIdsCodesAndValueDateForDataOwnerInGroup(
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
	def by_patient_secret_ids_codes_and_value_date_for_self(cls, secret_ids: list[str], code_codes: dict[str, set[str]], start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> FilterOptions[Service]:
		payload = {
			"secretIds": [x0 for x0 in secret_ids],
			"codeCodes": {k0: [x1 for x1 in v0] for k0, v0 in code_codes.items()},
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientSecretIdsCodesAndValueDateForSelf(
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
	def by_patients_code_prefix_and_value_date_for_data_owner(cls, data_owner_id: str, patients: list[Patient], code_type: str, code_code_prefix: str, start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> FilterOptions[Service]:
		payload = {
			"dataOwnerId": data_owner_id,
			"patients": [serialize_patient(x0) for x0 in patients],
			"codeType": code_type,
			"codeCodePrefix": code_code_prefix,
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientsCodePrefixAndValueDateForDataOwner(
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
	def by_patients_code_prefix_and_value_date_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, patients: list[Patient], code_type: str, code_code_prefix: str, start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> FilterOptions[Service]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"patients": [serialize_patient(x0) for x0 in patients],
			"codeType": code_type,
			"codeCodePrefix": code_code_prefix,
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientsCodePrefixAndValueDateForDataOwnerInGroup(
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
	def by_patients_code_prefix_and_value_date_for_self(cls, patients: list[Patient], code_type: str, code_code_prefix: str, start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> FilterOptions[Service]:
		payload = {
			"patients": [serialize_patient(x0) for x0 in patients],
			"codeType": code_type,
			"codeCodePrefix": code_code_prefix,
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientsCodePrefixAndValueDateForSelf(
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
	def by_patient_secret_ids_code_prefix_and_value_date_for_data_owner(cls, data_owner_id: str, secret_ids: list[str], code_type: str, code_code_prefix: str, start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> BaseFilterOptions[Service]:
		payload = {
			"dataOwnerId": data_owner_id,
			"secretIds": [x0 for x0 in secret_ids],
			"codeType": code_type,
			"codeCodePrefix": code_code_prefix,
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientSecretIdsCodePrefixAndValueDateForDataOwner(
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
	def by_patient_secret_ids_code_prefix_and_value_date_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, secret_ids: list[str], code_type: str, code_code_prefix: str, start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> BaseFilterOptions[Service]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"secretIds": [x0 for x0 in secret_ids],
			"codeType": code_type,
			"codeCodePrefix": code_code_prefix,
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientSecretIdsCodePrefixAndValueDateForDataOwnerInGroup(
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
	def by_patient_secret_ids_code_prefix_and_value_date_for_self(cls, secret_ids: list[str], code_type: str, code_code_prefix: str, start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> FilterOptions[Service]:
		payload = {
			"secretIds": [x0 for x0 in secret_ids],
			"codeType": code_type,
			"codeCodePrefix": code_code_prefix,
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientSecretIdsCodePrefixAndValueDateForSelf(
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
	def by_patients_tag_codes_and_value_date_for_data_owner(cls, data_owner_id: str, patients: list[Patient], tag_codes: dict[str, set[str]], start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> FilterOptions[Service]:
		payload = {
			"dataOwnerId": data_owner_id,
			"patients": [serialize_patient(x0) for x0 in patients],
			"tagCodes": {k0: [x1 for x1 in v0] for k0, v0 in tag_codes.items()},
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientsTagCodesAndValueDateForDataOwner(
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
	def by_patients_tag_codes_and_value_date_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, patients: list[Patient], tag_codes: dict[str, set[str]], start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> FilterOptions[Service]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"patients": [serialize_patient(x0) for x0 in patients],
			"tagCodes": {k0: [x1 for x1 in v0] for k0, v0 in tag_codes.items()},
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientsTagCodesAndValueDateForDataOwnerInGroup(
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
	def by_patients_tag_codes_and_value_date_for_self(cls, patients: list[Patient], tag_codes: dict[str, set[str]], start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> FilterOptions[Service]:
		payload = {
			"patients": [serialize_patient(x0) for x0 in patients],
			"tagCodes": {k0: [x1 for x1 in v0] for k0, v0 in tag_codes.items()},
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientsTagCodesAndValueDateForSelf(
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
	def by_patient_secret_ids_tag_codes_and_value_date_for_data_owner(cls, data_owner_id: str, secret_ids: list[str], tag_codes: dict[str, set[str]], start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> BaseFilterOptions[Service]:
		payload = {
			"dataOwnerId": data_owner_id,
			"secretIds": [x0 for x0 in secret_ids],
			"tagCodes": {k0: [x1 for x1 in v0] for k0, v0 in tag_codes.items()},
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientSecretIdsTagCodesAndValueDateForDataOwner(
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
	def by_patient_secret_ids_tag_codes_and_value_date_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, secret_ids: list[str], tag_codes: dict[str, set[str]], start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> BaseFilterOptions[Service]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"secretIds": [x0 for x0 in secret_ids],
			"tagCodes": {k0: [x1 for x1 in v0] for k0, v0 in tag_codes.items()},
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientSecretIdsTagCodesAndValueDateForDataOwnerInGroup(
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
	def by_patient_secret_ids_tag_codes_and_value_date_for_self(cls, secret_ids: list[str], tag_codes: dict[str, set[str]], start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> FilterOptions[Service]:
		payload = {
			"secretIds": [x0 for x0 in secret_ids],
			"tagCodes": {k0: [x1 for x1 in v0] for k0, v0 in tag_codes.items()},
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientSecretIdsTagCodesAndValueDateForSelf(
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
	def by_patients_tag_prefix_and_value_date_for_data_owner(cls, data_owner_id: str, patients: list[Patient], tag_type: str, tag_code_prefix: str, start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> FilterOptions[Service]:
		payload = {
			"dataOwnerId": data_owner_id,
			"patients": [serialize_patient(x0) for x0 in patients],
			"tagType": tag_type,
			"tagCodePrefix": tag_code_prefix,
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientsTagPrefixAndValueDateForDataOwner(
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
	def by_patients_tag_prefix_and_value_date_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, patients: list[Patient], tag_type: str, tag_code_prefix: str, start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> FilterOptions[Service]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"patients": [serialize_patient(x0) for x0 in patients],
			"tagType": tag_type,
			"tagCodePrefix": tag_code_prefix,
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientsTagPrefixAndValueDateForDataOwnerInGroup(
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
	def by_patients_tag_prefix_and_value_date_for_self(cls, patients: list[Patient], tag_type: str, tag_code_prefix: str, start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> FilterOptions[Service]:
		payload = {
			"patients": [serialize_patient(x0) for x0 in patients],
			"tagType": tag_type,
			"tagCodePrefix": tag_code_prefix,
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientsTagPrefixAndValueDateForSelf(
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
	def by_patient_secret_ids_tag_prefix_and_value_date_for_data_owner(cls, data_owner_id: str, secret_ids: list[str], tag_type: str, tag_code_prefix: str, start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> BaseFilterOptions[Service]:
		payload = {
			"dataOwnerId": data_owner_id,
			"secretIds": [x0 for x0 in secret_ids],
			"tagType": tag_type,
			"tagCodePrefix": tag_code_prefix,
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientSecretIdsTagPrefixAndValueDateForDataOwner(
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
	def by_patient_secret_ids_tag_prefix_and_value_date_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, secret_ids: list[str], tag_type: str, tag_code_prefix: str, start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> BaseFilterOptions[Service]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"secretIds": [x0 for x0 in secret_ids],
			"tagType": tag_type,
			"tagCodePrefix": tag_code_prefix,
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientSecretIdsTagPrefixAndValueDateForDataOwnerInGroup(
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
	def by_patient_secret_ids_tag_prefix_and_value_date_for_self(cls, secret_ids: list[str], tag_type: str, tag_code_prefix: str, start_of_service_value_date: Optional[int] = None, end_of_service_value_date: Optional[int] = None) -> FilterOptions[Service]:
		payload = {
			"secretIds": [x0 for x0 in secret_ids],
			"tagType": tag_type,
			"tagCodePrefix": tag_code_prefix,
			"startOfServiceValueDate": start_of_service_value_date,
			"endOfServiceValueDate": end_of_service_value_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.ServiceFilters.byPatientSecretIdsTagPrefixAndValueDateForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = FilterOptions(result_info.success)
			return return_value
