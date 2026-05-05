# auto-generated file
import json
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.filters.FilterOptions import BaseFilterOptions, FilterOptions, SortableFilterOptions, BaseSortableFilterOptions
from cardinal_sdk.model import Patient, EntityReferenceInGroup, Identifier, Gender
from typing import Optional


class PatientFilters:

	@classmethod
	def all_patients_for_data_owner(cls, data_owner_id: str) -> BaseFilterOptions[Patient]:
		payload = {
			"dataOwnerId": data_owner_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.allPatientsForDataOwner(
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
	def all_patients_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup) -> BaseFilterOptions[Patient]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.allPatientsForDataOwnerInGroup(
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
	def all_patients_for_self(cls) -> FilterOptions[Patient]:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.allPatientsForSelf(
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = FilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_ids(cls, ids: list[str]) -> SortableFilterOptions[Patient]:
		payload = {
			"ids": [x0 for x0 in ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.byIds(
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
	def by_identifiers_for_data_owner(cls, data_owner_id: str, identifiers: list[Identifier]) -> BaseSortableFilterOptions[Patient]:
		payload = {
			"dataOwnerId": data_owner_id,
			"identifiers": [x0.__serialize__() for x0 in identifiers],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.byIdentifiersForDataOwner(
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
	def by_identifiers_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, identifiers: list[Identifier]) -> BaseSortableFilterOptions[Patient]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"identifiers": [x0.__serialize__() for x0 in identifiers],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.byIdentifiersForDataOwnerInGroup(
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
	def by_ssins_for_data_owner(cls, data_owner_id: str, ssins: list[str]) -> BaseSortableFilterOptions[Patient]:
		payload = {
			"dataOwnerId": data_owner_id,
			"ssins": [x0 for x0 in ssins],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.bySsinsForDataOwner(
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
	def by_ssins_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, ssins: list[str]) -> BaseSortableFilterOptions[Patient]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"ssins": [x0 for x0 in ssins],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.bySsinsForDataOwnerInGroup(
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
	def by_date_of_birth_between_for_data_owner(cls, data_owner_id: str, from_date: int, to_date: int) -> BaseSortableFilterOptions[Patient]:
		payload = {
			"dataOwnerId": data_owner_id,
			"fromDate": from_date,
			"toDate": to_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.byDateOfBirthBetweenForDataOwner(
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
	def by_date_of_birth_between_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, from_date: int, to_date: int) -> BaseSortableFilterOptions[Patient]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"fromDate": from_date,
			"toDate": to_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.byDateOfBirthBetweenForDataOwnerInGroup(
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
	def by_fuzzy_name_for_data_owner(cls, data_owner_id: str, search_string: str) -> BaseFilterOptions[Patient]:
		payload = {
			"dataOwnerId": data_owner_id,
			"searchString": search_string,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.byFuzzyNameForDataOwner(
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
	def by_fuzzy_name_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, search_string: str) -> BaseFilterOptions[Patient]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"searchString": search_string,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.byFuzzyNameForDataOwnerInGroup(
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
	def by_gender_education_profession_for_data_owner(cls, data_owner_id: str, gender: Gender, education: Optional[str] = None, profession: Optional[str] = None) -> BaseSortableFilterOptions[Patient]:
		payload = {
			"dataOwnerId": data_owner_id,
			"gender": gender.__serialize__(),
			"education": education,
			"profession": profession,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.byGenderEducationProfessionForDataOwner(
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
	def by_gender_education_profession_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, gender: Gender, education: Optional[str] = None, profession: Optional[str] = None) -> BaseSortableFilterOptions[Patient]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"gender": gender.__serialize__(),
			"education": education,
			"profession": profession,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.byGenderEducationProfessionForDataOwnerInGroup(
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
	def by_active_for_data_owner(cls, data_owner_id: str, active: bool) -> BaseFilterOptions[Patient]:
		payload = {
			"dataOwnerId": data_owner_id,
			"active": active,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.byActiveForDataOwner(
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
	def by_active_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, active: bool) -> BaseFilterOptions[Patient]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"active": active,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.byActiveForDataOwnerInGroup(
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
	def by_telecom_for_data_owner(cls, data_owner_id: str, search_string: str) -> BaseSortableFilterOptions[Patient]:
		payload = {
			"dataOwnerId": data_owner_id,
			"searchString": search_string,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.byTelecomForDataOwner(
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
	def by_telecom_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, search_string: str) -> BaseSortableFilterOptions[Patient]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"searchString": search_string,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.byTelecomForDataOwnerInGroup(
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
	def by_address_postal_code_house_number_for_data_owner(cls, data_owner_id: str, search_string: str, postal_code: str, house_number: Optional[str] = None) -> BaseSortableFilterOptions[Patient]:
		payload = {
			"dataOwnerId": data_owner_id,
			"searchString": search_string,
			"postalCode": postal_code,
			"houseNumber": house_number,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.byAddressPostalCodeHouseNumberForDataOwner(
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
	def by_address_postal_code_house_number_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, search_string: str, postal_code: str, house_number: Optional[str] = None) -> BaseSortableFilterOptions[Patient]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"searchString": search_string,
			"postalCode": postal_code,
			"houseNumber": house_number,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.byAddressPostalCodeHouseNumberForDataOwnerInGroup(
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
	def by_address_for_data_owner(cls, data_owner_id: str, search_string: str) -> BaseSortableFilterOptions[Patient]:
		payload = {
			"dataOwnerId": data_owner_id,
			"searchString": search_string,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.byAddressForDataOwner(
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
	def by_address_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, search_string: str) -> BaseSortableFilterOptions[Patient]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"searchString": search_string,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.byAddressForDataOwnerInGroup(
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
	def by_identifiers_for_self(cls, identifiers: list[Identifier]) -> SortableFilterOptions[Patient]:
		payload = {
			"identifiers": [x0.__serialize__() for x0 in identifiers],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.byIdentifiersForSelf(
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
	def by_ssins_for_self(cls, ssins: list[str]) -> SortableFilterOptions[Patient]:
		payload = {
			"ssins": [x0 for x0 in ssins],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.bySsinsForSelf(
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
	def by_date_of_birth_between_for_self(cls, from_date: int, to_date: int) -> SortableFilterOptions[Patient]:
		payload = {
			"fromDate": from_date,
			"toDate": to_date,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.byDateOfBirthBetweenForSelf(
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
	def by_name_for_self(cls, search_string: str) -> FilterOptions[Patient]:
		payload = {
			"searchString": search_string,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.byNameForSelf(
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
	def by_gender_education_profession_for_self(cls, gender: Gender, education: Optional[str] = None, profession: Optional[str] = None) -> SortableFilterOptions[Patient]:
		payload = {
			"gender": gender.__serialize__(),
			"education": education,
			"profession": profession,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.byGenderEducationProfessionForSelf(
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
	def by_active_for_self(cls, active: bool) -> FilterOptions[Patient]:
		payload = {
			"active": active,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.byActiveForSelf(
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
	def by_telecom_for_self(cls, search_string: str) -> SortableFilterOptions[Patient]:
		payload = {
			"searchString": search_string,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.byTelecomForSelf(
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
	def by_address_postal_code_house_number_for_self(cls, search_string: str, postal_code: str, house_number: Optional[str] = None) -> SortableFilterOptions[Patient]:
		payload = {
			"searchString": search_string,
			"postalCode": postal_code,
			"houseNumber": house_number,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.byAddressPostalCodeHouseNumberForSelf(
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
	def by_address_for_self(cls, search_string: str) -> SortableFilterOptions[Patient]:
		payload = {
			"searchString": search_string,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.byAddressForSelf(
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
	def by_tag_for_self(cls, tag_type: str, tag_code: Optional[str]) -> FilterOptions[Patient]:
		payload = {
			"tagType": tag_type,
			"tagCode": tag_code,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.byTagForSelf(
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
	def by_tag_for_data_owner(cls, data_owner_id: str, tag_type: str, tag_code: Optional[str]) -> BaseFilterOptions[Patient]:
		payload = {
			"dataOwnerId": data_owner_id,
			"tagType": tag_type,
			"tagCode": tag_code,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.byTagForDataOwner(
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
	def by_tag_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, tag_type: str, tag_code: Optional[str]) -> BaseFilterOptions[Patient]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"tagType": tag_type,
			"tagCode": tag_code,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.PatientFilters.byTagForDataOwnerInGroup(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value
