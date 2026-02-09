// auto-generated file
package com.icure.cardinal.sdk.js.filters

import com.icure.cardinal.sdk.filters.PatientFilters
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.base.IdentifierJs
import com.icure.cardinal.sdk.js.model.base.identifier_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.embed.Gender
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.js.JsExport

@JsExport
public object InternalPatientFiltersObj {
	public fun allPatientsForDataOwner(dataOwnerId: String): BaseFilterOptionsJs<PatientJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val result = PatientFilters.allPatientsForDataOwner(
			dataOwnerIdConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun allPatientsForDataOwnerInGroup(dataOwner: EntityReferenceInGroupJs):
			BaseFilterOptionsJs<PatientJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val result = PatientFilters.allPatientsForDataOwnerInGroup(
			dataOwnerConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun allPatientsForSelf(): FilterOptionsJs<PatientJs> {
		val result = PatientFilters.allPatientsForSelf(
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byIds(ids: Array<String>): SortableFilterOptionsJs<PatientJs> {
		val idsConverted: List<String> = arrayToList(
			ids,
			"ids",
			{ x1: String ->
				x1
			},
		)
		val result = PatientFilters.byIds(
			idsConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byIdentifiersForDataOwner(dataOwnerId: String, identifiers: Array<IdentifierJs>):
			BaseSortableFilterOptionsJs<PatientJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val identifiersConverted: List<Identifier> = arrayToList(
			identifiers,
			"identifiers",
			{ x1: IdentifierJs ->
				identifier_fromJs(x1)
			},
		)
		val result = PatientFilters.byIdentifiersForDataOwner(
			dataOwnerIdConverted,
			identifiersConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byIdentifiersForDataOwnerInGroup(dataOwner: EntityReferenceInGroupJs,
			identifiers: Array<IdentifierJs>): BaseSortableFilterOptionsJs<PatientJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val identifiersConverted: List<Identifier> = arrayToList(
			identifiers,
			"identifiers",
			{ x1: IdentifierJs ->
				identifier_fromJs(x1)
			},
		)
		val result = PatientFilters.byIdentifiersForDataOwnerInGroup(
			dataOwnerConverted,
			identifiersConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun bySsinsForDataOwner(dataOwnerId: String, ssins: Array<String>):
			BaseSortableFilterOptionsJs<PatientJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val ssinsConverted: List<String> = arrayToList(
			ssins,
			"ssins",
			{ x1: String ->
				x1
			},
		)
		val result = PatientFilters.bySsinsForDataOwner(
			dataOwnerIdConverted,
			ssinsConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun bySsinsForDataOwnerInGroup(dataOwner: EntityReferenceInGroupJs, ssins: Array<String>):
			BaseSortableFilterOptionsJs<PatientJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val ssinsConverted: List<String> = arrayToList(
			ssins,
			"ssins",
			{ x1: String ->
				x1
			},
		)
		val result = PatientFilters.bySsinsForDataOwnerInGroup(
			dataOwnerConverted,
			ssinsConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byDateOfBirthBetweenForDataOwner(
		dataOwnerId: String,
		fromDate: Double,
		toDate: Double,
	): BaseSortableFilterOptionsJs<PatientJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val fromDateConverted: Int = numberToInt(fromDate, "fromDate")
		val toDateConverted: Int = numberToInt(toDate, "toDate")
		val result = PatientFilters.byDateOfBirthBetweenForDataOwner(
			dataOwnerIdConverted,
			fromDateConverted,
			toDateConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byDateOfBirthBetweenForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		fromDate: Double,
		toDate: Double,
	): BaseSortableFilterOptionsJs<PatientJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val fromDateConverted: Int = numberToInt(fromDate, "fromDate")
		val toDateConverted: Int = numberToInt(toDate, "toDate")
		val result = PatientFilters.byDateOfBirthBetweenForDataOwnerInGroup(
			dataOwnerConverted,
			fromDateConverted,
			toDateConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byFuzzyNameForDataOwner(dataOwnerId: String, searchString: String):
			BaseFilterOptionsJs<PatientJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val searchStringConverted: String = searchString
		val result = PatientFilters.byFuzzyNameForDataOwner(
			dataOwnerIdConverted,
			searchStringConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byFuzzyNameForDataOwnerInGroup(dataOwner: EntityReferenceInGroupJs,
			searchString: String): BaseFilterOptionsJs<PatientJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val searchStringConverted: String = searchString
		val result = PatientFilters.byFuzzyNameForDataOwnerInGroup(
			dataOwnerConverted,
			searchStringConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byGenderEducationProfessionForDataOwner(
		dataOwnerId: String,
		gender: String,
		options: dynamic,
	): BaseSortableFilterOptionsJs<PatientJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val genderConverted: Gender = Gender.valueOf(gender)
		val educationConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"education",
			null
		) { education: String? ->
			undefinedToNull(education)
		}
		val professionConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"profession",
			null
		) { profession: String? ->
			undefinedToNull(profession)
		}
		val result = PatientFilters.byGenderEducationProfessionForDataOwner(
			dataOwnerIdConverted,
			genderConverted,
			educationConverted,
			professionConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byGenderEducationProfessionForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		gender: String,
		options: dynamic,
	): BaseSortableFilterOptionsJs<PatientJs> {
		val _options = options ?: js("{}")
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val genderConverted: Gender = Gender.valueOf(gender)
		val educationConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"education",
			null
		) { education: String? ->
			undefinedToNull(education)
		}
		val professionConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"profession",
			null
		) { profession: String? ->
			undefinedToNull(profession)
		}
		val result = PatientFilters.byGenderEducationProfessionForDataOwnerInGroup(
			dataOwnerConverted,
			genderConverted,
			educationConverted,
			professionConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byActiveForDataOwner(dataOwnerId: String, active: Boolean):
			BaseFilterOptionsJs<PatientJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val activeConverted: Boolean = active
		val result = PatientFilters.byActiveForDataOwner(
			dataOwnerIdConverted,
			activeConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byActiveForDataOwnerInGroup(dataOwner: EntityReferenceInGroupJs, active: Boolean):
			BaseFilterOptionsJs<PatientJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val activeConverted: Boolean = active
		val result = PatientFilters.byActiveForDataOwnerInGroup(
			dataOwnerConverted,
			activeConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byTelecomForDataOwner(dataOwnerId: String, searchString: String):
			BaseSortableFilterOptionsJs<PatientJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val searchStringConverted: String = searchString
		val result = PatientFilters.byTelecomForDataOwner(
			dataOwnerIdConverted,
			searchStringConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byTelecomForDataOwnerInGroup(dataOwner: EntityReferenceInGroupJs, searchString: String):
			BaseSortableFilterOptionsJs<PatientJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val searchStringConverted: String = searchString
		val result = PatientFilters.byTelecomForDataOwnerInGroup(
			dataOwnerConverted,
			searchStringConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byAddressPostalCodeHouseNumberForDataOwner(
		dataOwnerId: String,
		searchString: String,
		postalCode: String,
		options: dynamic,
	): BaseSortableFilterOptionsJs<PatientJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val searchStringConverted: String = searchString
		val postalCodeConverted: String = postalCode
		val houseNumberConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"houseNumber",
			null
		) { houseNumber: String? ->
			undefinedToNull(houseNumber)
		}
		val result = PatientFilters.byAddressPostalCodeHouseNumberForDataOwner(
			dataOwnerIdConverted,
			searchStringConverted,
			postalCodeConverted,
			houseNumberConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byAddressPostalCodeHouseNumberForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		searchString: String,
		postalCode: String,
		options: dynamic,
	): BaseSortableFilterOptionsJs<PatientJs> {
		val _options = options ?: js("{}")
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val searchStringConverted: String = searchString
		val postalCodeConverted: String = postalCode
		val houseNumberConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"houseNumber",
			null
		) { houseNumber: String? ->
			undefinedToNull(houseNumber)
		}
		val result = PatientFilters.byAddressPostalCodeHouseNumberForDataOwnerInGroup(
			dataOwnerConverted,
			searchStringConverted,
			postalCodeConverted,
			houseNumberConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byAddressForDataOwner(dataOwnerId: String, searchString: String):
			BaseSortableFilterOptionsJs<PatientJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val searchStringConverted: String = searchString
		val result = PatientFilters.byAddressForDataOwner(
			dataOwnerIdConverted,
			searchStringConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byAddressForDataOwnerInGroup(dataOwner: EntityReferenceInGroupJs, searchString: String):
			BaseSortableFilterOptionsJs<PatientJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val searchStringConverted: String = searchString
		val result = PatientFilters.byAddressForDataOwnerInGroup(
			dataOwnerConverted,
			searchStringConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byIdentifiersForSelf(identifiers: Array<IdentifierJs>):
			SortableFilterOptionsJs<PatientJs> {
		val identifiersConverted: List<Identifier> = arrayToList(
			identifiers,
			"identifiers",
			{ x1: IdentifierJs ->
				identifier_fromJs(x1)
			},
		)
		val result = PatientFilters.byIdentifiersForSelf(
			identifiersConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun bySsinsForSelf(ssins: Array<String>): SortableFilterOptionsJs<PatientJs> {
		val ssinsConverted: List<String> = arrayToList(
			ssins,
			"ssins",
			{ x1: String ->
				x1
			},
		)
		val result = PatientFilters.bySsinsForSelf(
			ssinsConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byDateOfBirthBetweenForSelf(fromDate: Double, toDate: Double):
			SortableFilterOptionsJs<PatientJs> {
		val fromDateConverted: Int = numberToInt(fromDate, "fromDate")
		val toDateConverted: Int = numberToInt(toDate, "toDate")
		val result = PatientFilters.byDateOfBirthBetweenForSelf(
			fromDateConverted,
			toDateConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byNameForSelf(searchString: String): FilterOptionsJs<PatientJs> {
		val searchStringConverted: String = searchString
		val result = PatientFilters.byNameForSelf(
			searchStringConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byGenderEducationProfessionForSelf(gender: String, options: dynamic):
			SortableFilterOptionsJs<PatientJs> {
		val _options = options ?: js("{}")
		val genderConverted: Gender = Gender.valueOf(gender)
		val educationConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"education",
			null
		) { education: String? ->
			undefinedToNull(education)
		}
		val professionConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"profession",
			null
		) { profession: String? ->
			undefinedToNull(profession)
		}
		val result = PatientFilters.byGenderEducationProfessionForSelf(
			genderConverted,
			educationConverted,
			professionConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byActiveForSelf(active: Boolean): FilterOptionsJs<PatientJs> {
		val activeConverted: Boolean = active
		val result = PatientFilters.byActiveForSelf(
			activeConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byTelecomForSelf(searchString: String): SortableFilterOptionsJs<PatientJs> {
		val searchStringConverted: String = searchString
		val result = PatientFilters.byTelecomForSelf(
			searchStringConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byAddressPostalCodeHouseNumberForSelf(
		searchString: String,
		postalCode: String,
		options: dynamic,
	): SortableFilterOptionsJs<PatientJs> {
		val _options = options ?: js("{}")
		val searchStringConverted: String = searchString
		val postalCodeConverted: String = postalCode
		val houseNumberConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"houseNumber",
			null
		) { houseNumber: String? ->
			undefinedToNull(houseNumber)
		}
		val result = PatientFilters.byAddressPostalCodeHouseNumberForSelf(
			searchStringConverted,
			postalCodeConverted,
			houseNumberConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byAddressForSelf(searchString: String): SortableFilterOptionsJs<PatientJs> {
		val searchStringConverted: String = searchString
		val result = PatientFilters.byAddressForSelf(
			searchStringConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byTagForSelf(tagType: String, tagCode: String?): FilterOptionsJs<PatientJs> {
		val tagTypeConverted: String = tagType
		val tagCodeConverted: String? = undefinedToNull(tagCode)
		val result = PatientFilters.byTagForSelf(
			tagTypeConverted,
			tagCodeConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byTagForDataOwner(
		dataOwnerId: String,
		tagType: String,
		tagCode: String?,
	): BaseFilterOptionsJs<PatientJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val tagTypeConverted: String = tagType
		val tagCodeConverted: String? = undefinedToNull(tagCode)
		val result = PatientFilters.byTagForDataOwner(
			dataOwnerIdConverted,
			tagTypeConverted,
			tagCodeConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byTagForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		tagType: String,
		tagCode: String?,
	): BaseFilterOptionsJs<PatientJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val tagTypeConverted: String = tagType
		val tagCodeConverted: String? = undefinedToNull(tagCode)
		val result = PatientFilters.byTagForDataOwnerInGroup(
			dataOwnerConverted,
			tagTypeConverted,
			tagCodeConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}
}
