# auto-generated file
import json
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.filters.FilterOptions import BaseFilterOptions, FilterOptions, BaseSortableFilterOptions
from cardinal_sdk.model import RelatedPerson, EntityReferenceInGroup, Identifier


class RelatedPersonFilters:

	@classmethod
	def all_related_persons_for_data_owner(cls, data_owner_id: str) -> BaseFilterOptions[RelatedPerson]:
		payload = {
			"dataOwnerId": data_owner_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.RelatedPersonFilters.allRelatedPersonsForDataOwner(
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
	def all_related_persons_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup) -> BaseFilterOptions[RelatedPerson]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.RelatedPersonFilters.allRelatedPersonsForDataOwnerInGroup(
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
	def all_related_persons_for_self(cls) -> FilterOptions[RelatedPerson]:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.RelatedPersonFilters.allRelatedPersonsForSelf(
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = FilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_identifiers_for_data_owner(cls, data_owner_id: str, identifiers: list[Identifier]) -> BaseFilterOptions[RelatedPerson]:
		payload = {
			"dataOwnerId": data_owner_id,
			"identifiers": [x0.__serialize__() for x0 in identifiers],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.RelatedPersonFilters.byIdentifiersForDataOwner(
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
	def by_identifiers_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, identifiers: list[Identifier]) -> BaseFilterOptions[RelatedPerson]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"identifiers": [x0.__serialize__() for x0 in identifiers],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.RelatedPersonFilters.byIdentifiersForDataOwnerInGroup(
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
	def by_identifiers_for_self(cls, identifiers: list[Identifier]) -> FilterOptions[RelatedPerson]:
		payload = {
			"identifiers": [x0.__serialize__() for x0 in identifiers],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.RelatedPersonFilters.byIdentifiersForSelf(
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
	def by_name_for_data_owner(cls, data_owner_id: str, name: str) -> BaseFilterOptions[RelatedPerson]:
		payload = {
			"dataOwnerId": data_owner_id,
			"name": name,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.RelatedPersonFilters.byNameForDataOwner(
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
	def by_name_for_data_owner_in_group(cls, data_owner: EntityReferenceInGroup, name: str) -> BaseFilterOptions[RelatedPerson]:
		payload = {
			"dataOwner": data_owner.__serialize__(),
			"name": name,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.RelatedPersonFilters.byNameForDataOwnerInGroup(
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
	def by_name_for_self(cls, name: str) -> FilterOptions[RelatedPerson]:
		payload = {
			"name": name,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.RelatedPersonFilters.byNameForSelf(
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
	def by_ids(cls, ids: list[str]) -> BaseSortableFilterOptions[RelatedPerson]:
		payload = {
			"ids": [x0 for x0 in ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.RelatedPersonFilters.byIds(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseSortableFilterOptions(result_info.success)
			return return_value
