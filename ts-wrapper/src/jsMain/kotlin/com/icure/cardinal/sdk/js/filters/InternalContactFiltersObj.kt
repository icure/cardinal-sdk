// auto-generated file
package com.icure.cardinal.sdk.js.filters

import com.icure.cardinal.sdk.filters.ContactFilters
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.ContactJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.base.IdentifierJs
import com.icure.cardinal.sdk.js.model.base.identifier_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.patient_fromJs
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.base.Identifier
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set
import kotlin.js.JsExport

@JsExport
public object InternalContactFiltersObj {
	public fun allContactsForDataOwner(dataOwnerId: String): BaseFilterOptionsJs<ContactJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val result = ContactFilters.allContactsForDataOwner(
			dataOwnerIdConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun allContactsForDataOwnerInGroup(dataOwner: EntityReferenceInGroupJs):
			BaseFilterOptionsJs<ContactJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val result = ContactFilters.allContactsForDataOwnerInGroup(
			dataOwnerConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun allContactsForSelf(): FilterOptionsJs<ContactJs> {
		val result = ContactFilters.allContactsForSelf(
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byFormIdsForDataOwner(dataOwnerId: String, formIds: Array<String>):
			BaseFilterOptionsJs<ContactJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val formIdsConverted: Set<String> = arrayToSet(
			formIds,
			"formIds",
			{ x1: String ->
				x1
			},
		)
		val result = ContactFilters.byFormIdsForDataOwner(
			dataOwnerIdConverted,
			formIdsConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byFormIdsForDataOwnerInGroup(dataOwner: EntityReferenceInGroupJs,
			formIds: Array<String>): BaseFilterOptionsJs<ContactJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val formIdsConverted: Set<String> = arrayToSet(
			formIds,
			"formIds",
			{ x1: String ->
				x1
			},
		)
		val result = ContactFilters.byFormIdsForDataOwnerInGroup(
			dataOwnerConverted,
			formIdsConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byFormIdsForSelf(formIds: Array<String>): FilterOptionsJs<ContactJs> {
		val formIdsConverted: Set<String> = arrayToSet(
			formIds,
			"formIds",
			{ x1: String ->
				x1
			},
		)
		val result = ContactFilters.byFormIdsForSelf(
			formIdsConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byPatientsOpeningDateForDataOwner(
		dataOwnerId: String,
		patients: Array<PatientJs>,
		options: dynamic,
	): SortableFilterOptionsJs<ContactJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val fromConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"from",
			null
		) { from: Double? ->
			numberToLong(from, "from")
		}
		val toConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"to",
			null
		) { to: Double? ->
			numberToLong(to, "to")
		}
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = ContactFilters.byPatientsOpeningDateForDataOwner(
			dataOwnerIdConverted,
			patientsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsOpeningDateForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		patients: Array<GroupScopedJs<PatientJs>>,
		options: dynamic,
	): SortableFilterOptionsJs<ContactJs> {
		val _options = options ?: js("{}")
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val patientsConverted: List<GroupScoped<Patient>> = arrayToList(
			patients,
			"patients",
			{ x1: GroupScopedJs<PatientJs> ->
				groupScoped_fromJs(
					x1,
					{ x2: PatientJs ->
						patient_fromJs(x2)
					},
				)
			},
		)
		val fromConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"from",
			null
		) { from: Double? ->
			numberToLong(from, "from")
		}
		val toConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"to",
			null
		) { to: Double? ->
			numberToLong(to, "to")
		}
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = ContactFilters.byPatientsOpeningDateForDataOwnerInGroup(
			dataOwnerConverted,
			patientsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsOpeningDateForSelf(patients: Array<PatientJs>, options: dynamic):
			SortableFilterOptionsJs<ContactJs> {
		val _options = options ?: js("{}")
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val fromConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"from",
			null
		) { from: Double? ->
			numberToLong(from, "from")
		}
		val toConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"to",
			null
		) { to: Double? ->
			numberToLong(to, "to")
		}
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = ContactFilters.byPatientsOpeningDateForSelf(
			patientsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientSecretIdsOpeningDateForDataOwner(
		dataOwnerId: String,
		secretIds: Array<String>,
		options: dynamic,
	): BaseSortableFilterOptionsJs<ContactJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val fromConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"from",
			null
		) { from: Double? ->
			numberToLong(from, "from")
		}
		val toConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"to",
			null
		) { to: Double? ->
			numberToLong(to, "to")
		}
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = ContactFilters.byPatientSecretIdsOpeningDateForDataOwner(
			dataOwnerIdConverted,
			secretIdsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byPatientSecretIdsOpeningDateForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		secretIds: Array<String>,
		options: dynamic,
	): BaseSortableFilterOptionsJs<ContactJs> {
		val _options = options ?: js("{}")
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val fromConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"from",
			null
		) { from: Double? ->
			numberToLong(from, "from")
		}
		val toConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"to",
			null
		) { to: Double? ->
			numberToLong(to, "to")
		}
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = ContactFilters.byPatientSecretIdsOpeningDateForDataOwnerInGroup(
			dataOwnerConverted,
			secretIdsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byPatientSecretIdsOpeningDateForSelf(secretIds: Array<String>, options: dynamic):
			SortableFilterOptionsJs<ContactJs> {
		val _options = options ?: js("{}")
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val fromConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"from",
			null
		) { from: Double? ->
			numberToLong(from, "from")
		}
		val toConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"to",
			null
		) { to: Double? ->
			numberToLong(to, "to")
		}
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = ContactFilters.byPatientSecretIdsOpeningDateForSelf(
			secretIdsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byIdentifiersForSelf(identifiers: Array<IdentifierJs>):
			SortableFilterOptionsJs<ContactJs> {
		val identifiersConverted: List<Identifier> = arrayToList(
			identifiers,
			"identifiers",
			{ x1: IdentifierJs ->
				identifier_fromJs(x1)
			},
		)
		val result = ContactFilters.byIdentifiersForSelf(
			identifiersConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byIdentifiersForDataOwner(dataOwnerId: String, identifiers: Array<IdentifierJs>):
			BaseSortableFilterOptionsJs<ContactJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val identifiersConverted: List<Identifier> = arrayToList(
			identifiers,
			"identifiers",
			{ x1: IdentifierJs ->
				identifier_fromJs(x1)
			},
		)
		val result = ContactFilters.byIdentifiersForDataOwner(
			dataOwnerIdConverted,
			identifiersConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byIdentifiersForDataOwnerInGroup(dataOwner: EntityReferenceInGroupJs,
			identifiers: Array<IdentifierJs>): BaseSortableFilterOptionsJs<ContactJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val identifiersConverted: List<Identifier> = arrayToList(
			identifiers,
			"identifiers",
			{ x1: IdentifierJs ->
				identifier_fromJs(x1)
			},
		)
		val result = ContactFilters.byIdentifiersForDataOwnerInGroup(
			dataOwnerConverted,
			identifiersConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byCodeAndOpeningDateForDataOwner(
		dataOwnerId: String,
		codeType: String,
		options: dynamic,
	): BaseSortableFilterOptionsJs<ContactJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val codeTypeConverted: String = codeType
		val codeCodeConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"codeCode",
			null
		) { codeCode: String? ->
			undefinedToNull(codeCode)
		}
		val startOfContactOpeningDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"startOfContactOpeningDate",
			null
		) { startOfContactOpeningDate: Double? ->
			numberToLong(startOfContactOpeningDate, "startOfContactOpeningDate")
		}
		val endOfContactOpeningDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"endOfContactOpeningDate",
			null
		) { endOfContactOpeningDate: Double? ->
			numberToLong(endOfContactOpeningDate, "endOfContactOpeningDate")
		}
		val result = ContactFilters.byCodeAndOpeningDateForDataOwner(
			dataOwnerIdConverted,
			codeTypeConverted,
			codeCodeConverted,
			startOfContactOpeningDateConverted,
			endOfContactOpeningDateConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byCodeAndOpeningDateForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		codeType: String,
		options: dynamic,
	): BaseSortableFilterOptionsJs<ContactJs> {
		val _options = options ?: js("{}")
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val codeTypeConverted: String = codeType
		val codeCodeConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"codeCode",
			null
		) { codeCode: String? ->
			undefinedToNull(codeCode)
		}
		val startOfContactOpeningDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"startOfContactOpeningDate",
			null
		) { startOfContactOpeningDate: Double? ->
			numberToLong(startOfContactOpeningDate, "startOfContactOpeningDate")
		}
		val endOfContactOpeningDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"endOfContactOpeningDate",
			null
		) { endOfContactOpeningDate: Double? ->
			numberToLong(endOfContactOpeningDate, "endOfContactOpeningDate")
		}
		val result = ContactFilters.byCodeAndOpeningDateForDataOwnerInGroup(
			dataOwnerConverted,
			codeTypeConverted,
			codeCodeConverted,
			startOfContactOpeningDateConverted,
			endOfContactOpeningDateConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byCodeAndOpeningDateForSelf(codeType: String, options: dynamic):
			SortableFilterOptionsJs<ContactJs> {
		val _options = options ?: js("{}")
		val codeTypeConverted: String = codeType
		val codeCodeConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"codeCode",
			null
		) { codeCode: String? ->
			undefinedToNull(codeCode)
		}
		val startOfContactOpeningDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"startOfContactOpeningDate",
			null
		) { startOfContactOpeningDate: Double? ->
			numberToLong(startOfContactOpeningDate, "startOfContactOpeningDate")
		}
		val endOfContactOpeningDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"endOfContactOpeningDate",
			null
		) { endOfContactOpeningDate: Double? ->
			numberToLong(endOfContactOpeningDate, "endOfContactOpeningDate")
		}
		val result = ContactFilters.byCodeAndOpeningDateForSelf(
			codeTypeConverted,
			codeCodeConverted,
			startOfContactOpeningDateConverted,
			endOfContactOpeningDateConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byTagAndOpeningDateForDataOwner(
		dataOwnerId: String,
		tagType: String,
		options: dynamic,
	): BaseSortableFilterOptionsJs<ContactJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val tagTypeConverted: String = tagType
		val tagCodeConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"tagCode",
			null
		) { tagCode: String? ->
			undefinedToNull(tagCode)
		}
		val startOfContactOpeningDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"startOfContactOpeningDate",
			null
		) { startOfContactOpeningDate: Double? ->
			numberToLong(startOfContactOpeningDate, "startOfContactOpeningDate")
		}
		val endOfContactOpeningDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"endOfContactOpeningDate",
			null
		) { endOfContactOpeningDate: Double? ->
			numberToLong(endOfContactOpeningDate, "endOfContactOpeningDate")
		}
		val result = ContactFilters.byTagAndOpeningDateForDataOwner(
			dataOwnerIdConverted,
			tagTypeConverted,
			tagCodeConverted,
			startOfContactOpeningDateConverted,
			endOfContactOpeningDateConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byTagAndOpeningDateForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		tagType: String,
		options: dynamic,
	): BaseSortableFilterOptionsJs<ContactJs> {
		val _options = options ?: js("{}")
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val tagTypeConverted: String = tagType
		val tagCodeConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"tagCode",
			null
		) { tagCode: String? ->
			undefinedToNull(tagCode)
		}
		val startOfContactOpeningDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"startOfContactOpeningDate",
			null
		) { startOfContactOpeningDate: Double? ->
			numberToLong(startOfContactOpeningDate, "startOfContactOpeningDate")
		}
		val endOfContactOpeningDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"endOfContactOpeningDate",
			null
		) { endOfContactOpeningDate: Double? ->
			numberToLong(endOfContactOpeningDate, "endOfContactOpeningDate")
		}
		val result = ContactFilters.byTagAndOpeningDateForDataOwnerInGroup(
			dataOwnerConverted,
			tagTypeConverted,
			tagCodeConverted,
			startOfContactOpeningDateConverted,
			endOfContactOpeningDateConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byOpeningDateForDataOwner(dataOwnerId: String, options: dynamic):
			BaseSortableFilterOptionsJs<ContactJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val startDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"startDate",
			null
		) { startDate: Double? ->
			numberToLong(startDate, "startDate")
		}
		val endDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"endDate",
			null
		) { endDate: Double? ->
			numberToLong(endDate, "endDate")
		}
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = ContactFilters.byOpeningDateForDataOwner(
			dataOwnerIdConverted,
			startDateConverted,
			endDateConverted,
			descendingConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byOpeningDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroupJs, options: dynamic):
			BaseSortableFilterOptionsJs<ContactJs> {
		val _options = options ?: js("{}")
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val startDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"startDate",
			null
		) { startDate: Double? ->
			numberToLong(startDate, "startDate")
		}
		val endDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"endDate",
			null
		) { endDate: Double? ->
			numberToLong(endDate, "endDate")
		}
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = ContactFilters.byOpeningDateForDataOwnerInGroup(
			dataOwnerConverted,
			startDateConverted,
			endDateConverted,
			descendingConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byOpeningDateForSelf(options: dynamic): SortableFilterOptionsJs<ContactJs> {
		val _options = options ?: js("{}")
		val startDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"startDate",
			null
		) { startDate: Double? ->
			numberToLong(startDate, "startDate")
		}
		val endDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"endDate",
			null
		) { endDate: Double? ->
			numberToLong(endDate, "endDate")
		}
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = ContactFilters.byOpeningDateForSelf(
			startDateConverted,
			endDateConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byServiceTagForSelf(tagType: String, options: dynamic): FilterOptionsJs<ContactJs> {
		val _options = options ?: js("{}")
		val tagTypeConverted: String = tagType
		val tagCodeConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"tagCode",
			null
		) { tagCode: String? ->
			undefinedToNull(tagCode)
		}
		val result = ContactFilters.byServiceTagForSelf(
			tagTypeConverted,
			tagCodeConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byServiceTagForDataOwner(
		dataOwnerId: String,
		tagType: String,
		options: dynamic,
	): BaseFilterOptionsJs<ContactJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val tagTypeConverted: String = tagType
		val tagCodeConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"tagCode",
			null
		) { tagCode: String? ->
			undefinedToNull(tagCode)
		}
		val result = ContactFilters.byServiceTagForDataOwner(
			dataOwnerIdConverted,
			tagTypeConverted,
			tagCodeConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byServiceTagForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		tagType: String,
		options: dynamic,
	): BaseFilterOptionsJs<ContactJs> {
		val _options = options ?: js("{}")
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val tagTypeConverted: String = tagType
		val tagCodeConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"tagCode",
			null
		) { tagCode: String? ->
			undefinedToNull(tagCode)
		}
		val result = ContactFilters.byServiceTagForDataOwnerInGroup(
			dataOwnerConverted,
			tagTypeConverted,
			tagCodeConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byServiceCodeForSelf(codeType: String, options: dynamic): FilterOptionsJs<ContactJs> {
		val _options = options ?: js("{}")
		val codeTypeConverted: String = codeType
		val codeCodeConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"codeCode",
			null
		) { codeCode: String? ->
			undefinedToNull(codeCode)
		}
		val result = ContactFilters.byServiceCodeForSelf(
			codeTypeConverted,
			codeCodeConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byServiceCodeForDataOwner(
		dataOwnerId: String,
		codeType: String,
		options: dynamic,
	): BaseFilterOptionsJs<ContactJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val codeTypeConverted: String = codeType
		val codeCodeConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"codeCode",
			null
		) { codeCode: String? ->
			undefinedToNull(codeCode)
		}
		val result = ContactFilters.byServiceCodeForDataOwner(
			dataOwnerIdConverted,
			codeTypeConverted,
			codeCodeConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byServiceCodeForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		codeType: String,
		options: dynamic,
	): BaseFilterOptionsJs<ContactJs> {
		val _options = options ?: js("{}")
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val codeTypeConverted: String = codeType
		val codeCodeConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"codeCode",
			null
		) { codeCode: String? ->
			undefinedToNull(codeCode)
		}
		val result = ContactFilters.byServiceCodeForDataOwnerInGroup(
			dataOwnerConverted,
			codeTypeConverted,
			codeCodeConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byTagAndOpeningDateForSelf(tagType: String, options: dynamic):
			SortableFilterOptionsJs<ContactJs> {
		val _options = options ?: js("{}")
		val tagTypeConverted: String = tagType
		val tagCodeConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"tagCode",
			null
		) { tagCode: String? ->
			undefinedToNull(tagCode)
		}
		val startOfContactOpeningDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"startOfContactOpeningDate",
			null
		) { startOfContactOpeningDate: Double? ->
			numberToLong(startOfContactOpeningDate, "startOfContactOpeningDate")
		}
		val endOfContactOpeningDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"endOfContactOpeningDate",
			null
		) { endOfContactOpeningDate: Double? ->
			numberToLong(endOfContactOpeningDate, "endOfContactOpeningDate")
		}
		val result = ContactFilters.byTagAndOpeningDateForSelf(
			tagTypeConverted,
			tagCodeConverted,
			startOfContactOpeningDateConverted,
			endOfContactOpeningDateConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsForDataOwner(dataOwnerId: String, patients: Array<PatientJs>):
			SortableFilterOptionsJs<ContactJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val result = ContactFilters.byPatientsForDataOwner(
			dataOwnerIdConverted,
			patientsConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsForDataOwnerInGroup(dataOwner: EntityReferenceInGroupJs,
			patients: Array<GroupScopedJs<PatientJs>>): SortableFilterOptionsJs<ContactJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val patientsConverted: List<GroupScoped<Patient>> = arrayToList(
			patients,
			"patients",
			{ x1: GroupScopedJs<PatientJs> ->
				groupScoped_fromJs(
					x1,
					{ x2: PatientJs ->
						patient_fromJs(x2)
					},
				)
			},
		)
		val result = ContactFilters.byPatientsForDataOwnerInGroup(
			dataOwnerConverted,
			patientsConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsForSelf(patients: Array<PatientJs>): SortableFilterOptionsJs<ContactJs> {
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val result = ContactFilters.byPatientsForSelf(
			patientsConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsSecretIdsForDataOwner(dataOwnerId: String, secretIds: Array<String>):
			BaseSortableFilterOptionsJs<ContactJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val result = ContactFilters.byPatientsSecretIdsForDataOwner(
			dataOwnerIdConverted,
			secretIdsConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsSecretIdsForDataOwnerInGroup(dataOwner: EntityReferenceInGroupJs,
			secretIds: Array<String>): BaseSortableFilterOptionsJs<ContactJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val result = ContactFilters.byPatientsSecretIdsForDataOwnerInGroup(
			dataOwnerConverted,
			secretIdsConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsSecretIdsForSelf(secretIds: Array<String>):
			SortableFilterOptionsJs<ContactJs> {
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val result = ContactFilters.byPatientsSecretIdsForSelf(
			secretIdsConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byServiceIds(serviceIds: Array<String>): BaseSortableFilterOptionsJs<ContactJs> {
		val serviceIdsConverted: List<String> = arrayToList(
			serviceIds,
			"serviceIds",
			{ x1: String ->
				x1
			},
		)
		val result = ContactFilters.byServiceIds(
			serviceIdsConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}
}
