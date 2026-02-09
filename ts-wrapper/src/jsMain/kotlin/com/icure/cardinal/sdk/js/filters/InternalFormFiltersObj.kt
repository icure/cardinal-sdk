// auto-generated file
package com.icure.cardinal.sdk.js.filters

import com.icure.cardinal.sdk.filters.FormFilters
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.FormJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.patient_fromJs
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Patient
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.js.JsExport

@JsExport
public object InternalFormFiltersObj {
	public fun byParentIdForDataOwner(dataOwnerId: String, parentId: String):
			BaseFilterOptionsJs<FormJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val parentIdConverted: String = parentId
		val result = FormFilters.byParentIdForDataOwner(
			dataOwnerIdConverted,
			parentIdConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byParentIdForDataOwnerInGroup(dataOwner: EntityReferenceInGroupJs, parentId: String):
			BaseFilterOptionsJs<FormJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val parentIdConverted: String = parentId
		val result = FormFilters.byParentIdForDataOwnerInGroup(
			dataOwnerConverted,
			parentIdConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byParentIdForSelf(parentId: String): FilterOptionsJs<FormJs> {
		val parentIdConverted: String = parentId
		val result = FormFilters.byParentIdForSelf(
			parentIdConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byPatientsOpeningDateForDataOwner(
		dataOwnerId: String,
		patients: Array<PatientJs>,
		options: dynamic,
	): SortableFilterOptionsJs<FormJs> {
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
		val result = FormFilters.byPatientsOpeningDateForDataOwner(
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
	): SortableFilterOptionsJs<FormJs> {
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
		val result = FormFilters.byPatientsOpeningDateForDataOwnerInGroup(
			dataOwnerConverted,
			patientsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsOpeningDateForSelf(patients: Array<PatientJs>, options: dynamic):
			SortableFilterOptionsJs<FormJs> {
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
		val result = FormFilters.byPatientsOpeningDateForSelf(
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
	): BaseSortableFilterOptionsJs<FormJs> {
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
		val result = FormFilters.byPatientSecretIdsOpeningDateForDataOwner(
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
	): BaseSortableFilterOptionsJs<FormJs> {
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
		val result = FormFilters.byPatientSecretIdsOpeningDateForDataOwnerInGroup(
			dataOwnerConverted,
			secretIdsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byPatientSecretIdsOpeningDateForSelf(secretIds: Array<String>, options: dynamic):
			SortableFilterOptionsJs<FormJs> {
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
		val result = FormFilters.byPatientSecretIdsOpeningDateForSelf(
			secretIdsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byUniqueId(uniqueId: String, options: dynamic): BaseSortableFilterOptionsJs<FormJs> {
		val _options = options ?: js("{}")
		val uniqueIdConverted: String = uniqueId
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = FormFilters.byUniqueId(
			uniqueIdConverted,
			descendingConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}
}
