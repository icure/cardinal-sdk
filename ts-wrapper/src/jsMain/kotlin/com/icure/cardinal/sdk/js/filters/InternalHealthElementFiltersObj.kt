// auto-generated file
package com.icure.cardinal.sdk.js.filters

import com.icure.cardinal.sdk.filters.HealthElementFilters
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.HealthElementJs
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
import kotlin.js.JsExport

@JsExport
public object InternalHealthElementFiltersObj {
	public fun allHealthElementsForDataOwner(dataOwnerId: String):
			BaseFilterOptionsJs<HealthElementJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val result = HealthElementFilters.allHealthElementsForDataOwner(
			dataOwnerIdConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun allHealthElementsForDataOwnerInGroup(dataOwner: EntityReferenceInGroupJs):
			BaseFilterOptionsJs<HealthElementJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val result = HealthElementFilters.allHealthElementsForDataOwnerInGroup(
			dataOwnerConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun allHealthElementsForSelf(): FilterOptionsJs<HealthElementJs> {
		val result = HealthElementFilters.allHealthElementsForSelf(
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byIdentifiersForDataOwner(dataOwnerId: String, identifiers: Array<IdentifierJs>):
			BaseSortableFilterOptionsJs<HealthElementJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val identifiersConverted: List<Identifier> = arrayToList(
			identifiers,
			"identifiers",
			{ x1: IdentifierJs ->
				identifier_fromJs(x1)
			},
		)
		val result = HealthElementFilters.byIdentifiersForDataOwner(
			dataOwnerIdConverted,
			identifiersConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byIdentifiersForDataOwnerInGroup(dataOwner: EntityReferenceInGroupJs,
			identifiers: Array<IdentifierJs>): BaseSortableFilterOptionsJs<HealthElementJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val identifiersConverted: List<Identifier> = arrayToList(
			identifiers,
			"identifiers",
			{ x1: IdentifierJs ->
				identifier_fromJs(x1)
			},
		)
		val result = HealthElementFilters.byIdentifiersForDataOwnerInGroup(
			dataOwnerConverted,
			identifiersConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byIdentifiersForSelf(identifiers: Array<IdentifierJs>):
			SortableFilterOptionsJs<HealthElementJs> {
		val identifiersConverted: List<Identifier> = arrayToList(
			identifiers,
			"identifiers",
			{ x1: IdentifierJs ->
				identifier_fromJs(x1)
			},
		)
		val result = HealthElementFilters.byIdentifiersForSelf(
			identifiersConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byCodeForDataOwner(
		dataOwnerId: String,
		codeType: String,
		options: dynamic,
	): BaseSortableFilterOptionsJs<HealthElementJs> {
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
		val result = HealthElementFilters.byCodeForDataOwner(
			dataOwnerIdConverted,
			codeTypeConverted,
			codeCodeConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byCodeForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		codeType: String,
		options: dynamic,
	): BaseSortableFilterOptionsJs<HealthElementJs> {
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
		val result = HealthElementFilters.byCodeForDataOwnerInGroup(
			dataOwnerConverted,
			codeTypeConverted,
			codeCodeConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byCodeForSelf(codeType: String, options: dynamic):
			SortableFilterOptionsJs<HealthElementJs> {
		val _options = options ?: js("{}")
		val codeTypeConverted: String = codeType
		val codeCodeConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"codeCode",
			null
		) { codeCode: String? ->
			undefinedToNull(codeCode)
		}
		val result = HealthElementFilters.byCodeForSelf(
			codeTypeConverted,
			codeCodeConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byTagForDataOwner(
		dataOwnerId: String,
		tagType: String,
		options: dynamic,
	): BaseSortableFilterOptionsJs<HealthElementJs> {
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
		val result = HealthElementFilters.byTagForDataOwner(
			dataOwnerIdConverted,
			tagTypeConverted,
			tagCodeConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byTagForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		tagType: String,
		options: dynamic,
	): BaseSortableFilterOptionsJs<HealthElementJs> {
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
		val result = HealthElementFilters.byTagForDataOwnerInGroup(
			dataOwnerConverted,
			tagTypeConverted,
			tagCodeConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byTagForSelf(tagType: String, options: dynamic):
			SortableFilterOptionsJs<HealthElementJs> {
		val _options = options ?: js("{}")
		val tagTypeConverted: String = tagType
		val tagCodeConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"tagCode",
			null
		) { tagCode: String? ->
			undefinedToNull(tagCode)
		}
		val result = HealthElementFilters.byTagForSelf(
			tagTypeConverted,
			tagCodeConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsForDataOwner(dataOwnerId: String, patients: Array<PatientJs>):
			SortableFilterOptionsJs<HealthElementJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val result = HealthElementFilters.byPatientsForDataOwner(
			dataOwnerIdConverted,
			patientsConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsForDataOwnerInGroup(dataOwner: EntityReferenceInGroupJs,
			patients: Array<GroupScopedJs<PatientJs>>): SortableFilterOptionsJs<HealthElementJs> {
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
		val result = HealthElementFilters.byPatientsForDataOwnerInGroup(
			dataOwnerConverted,
			patientsConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsForSelf(patients: Array<PatientJs>):
			SortableFilterOptionsJs<HealthElementJs> {
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val result = HealthElementFilters.byPatientsForSelf(
			patientsConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsSecretIdsForDataOwner(dataOwnerId: String, secretIds: Array<String>):
			BaseSortableFilterOptionsJs<HealthElementJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val result = HealthElementFilters.byPatientsSecretIdsForDataOwner(
			dataOwnerIdConverted,
			secretIdsConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsSecretIdsForDataOwnerInGroup(dataOwner: EntityReferenceInGroupJs,
			secretIds: Array<String>): BaseSortableFilterOptionsJs<HealthElementJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val result = HealthElementFilters.byPatientsSecretIdsForDataOwnerInGroup(
			dataOwnerConverted,
			secretIdsConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsSecretIdsForSelf(secretIds: Array<String>):
			SortableFilterOptionsJs<HealthElementJs> {
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val result = HealthElementFilters.byPatientsSecretIdsForSelf(
			secretIdsConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byIds(ids: Array<String>): BaseSortableFilterOptionsJs<HealthElementJs> {
		val idsConverted: List<String> = arrayToList(
			ids,
			"ids",
			{ x1: String ->
				x1
			},
		)
		val result = HealthElementFilters.byIds(
			idsConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsOpeningDateForDataOwner(
		dataOwnerId: String,
		patients: Array<PatientJs>,
		options: dynamic,
	): SortableFilterOptionsJs<HealthElementJs> {
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
		val result = HealthElementFilters.byPatientsOpeningDateForDataOwner(
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
	): SortableFilterOptionsJs<HealthElementJs> {
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
		val result = HealthElementFilters.byPatientsOpeningDateForDataOwnerInGroup(
			dataOwnerConverted,
			patientsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsOpeningDateForSelf(patients: Array<PatientJs>, options: dynamic):
			SortableFilterOptionsJs<HealthElementJs> {
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
		val result = HealthElementFilters.byPatientsOpeningDateForSelf(
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
	): BaseSortableFilterOptionsJs<HealthElementJs> {
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
		val result = HealthElementFilters.byPatientSecretIdsOpeningDateForDataOwner(
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
	): BaseSortableFilterOptionsJs<HealthElementJs> {
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
		val result = HealthElementFilters.byPatientSecretIdsOpeningDateForDataOwnerInGroup(
			dataOwnerConverted,
			secretIdsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byPatientSecretIdsOpeningDateForSelf(secretIds: Array<String>, options: dynamic):
			SortableFilterOptionsJs<HealthElementJs> {
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
		val result = HealthElementFilters.byPatientSecretIdsOpeningDateForSelf(
			secretIdsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}
}
