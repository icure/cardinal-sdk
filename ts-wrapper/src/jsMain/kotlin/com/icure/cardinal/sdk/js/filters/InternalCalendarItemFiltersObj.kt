// auto-generated file
package com.icure.cardinal.sdk.js.filters

import com.icure.cardinal.sdk.filters.CalendarItemFilters
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.model.CalendarItemJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
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
public object InternalCalendarItemFiltersObj {
	public fun byPatientsStartTimeForDataOwner(
		dataOwnerId: String,
		patients: Array<PatientJs>,
		options: dynamic,
	): SortableFilterOptionsJs<CalendarItemJs> {
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
		val result = CalendarItemFilters.byPatientsStartTimeForDataOwner(
			dataOwnerIdConverted,
			patientsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsStartTimeForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		patients: Array<GroupScopedJs<PatientJs>>,
		options: dynamic,
	): SortableFilterOptionsJs<CalendarItemJs> {
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
		val result = CalendarItemFilters.byPatientsStartTimeForDataOwnerInGroup(
			dataOwnerConverted,
			patientsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsStartTimeForSelf(patients: Array<PatientJs>, options: dynamic): SortableFilterOptionsJs<CalendarItemJs> {
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
		val result = CalendarItemFilters.byPatientsStartTimeForSelf(
			patientsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientSecretIdsStartTimeForDataOwner(
		dataOwnerId: String,
		secretIds: Array<String>,
		options: dynamic,
	): BaseSortableFilterOptionsJs<CalendarItemJs> {
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
		val result = CalendarItemFilters.byPatientSecretIdsStartTimeForDataOwner(
			dataOwnerIdConverted,
			secretIdsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byPatientSecretIdsStartTimeForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		secretIds: Array<String>,
		options: dynamic,
	): BaseSortableFilterOptionsJs<CalendarItemJs> {
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
		val result = CalendarItemFilters.byPatientSecretIdsStartTimeForDataOwnerInGroup(
			dataOwnerConverted,
			secretIdsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byPatientSecretIdsStartTimeForSelf(secretIds: Array<String>, options: dynamic): SortableFilterOptionsJs<CalendarItemJs> {
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
		val result = CalendarItemFilters.byPatientSecretIdsStartTimeForSelf(
			secretIdsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPeriodAndAgenda(
		agendaId: String,
		from: Double,
		to: Double,
		options: dynamic,
	): BaseSortableFilterOptionsJs<CalendarItemJs> {
		val _options = options ?: js("{}")
		val agendaIdConverted: String = agendaId
		val fromConverted: Long = numberToLong(from, "from")
		val toConverted: Long = numberToLong(to, "to")
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = CalendarItemFilters.byPeriodAndAgenda(
			agendaIdConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byPeriodForDataOwner(
		dataOwnerId: String,
		from: Double,
		to: Double,
	): BaseFilterOptionsJs<CalendarItemJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val fromConverted: Long = numberToLong(from, "from")
		val toConverted: Long = numberToLong(to, "to")
		val result = CalendarItemFilters.byPeriodForDataOwner(
			dataOwnerIdConverted,
			fromConverted,
			toConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byPeriodForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		from: Double,
		to: Double,
	): BaseFilterOptionsJs<CalendarItemJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val fromConverted: Long = numberToLong(from, "from")
		val toConverted: Long = numberToLong(to, "to")
		val result = CalendarItemFilters.byPeriodForDataOwnerInGroup(
			dataOwnerConverted,
			fromConverted,
			toConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byPeriodForSelf(from: Double, to: Double): FilterOptionsJs<CalendarItemJs> {
		val fromConverted: Long = numberToLong(from, "from")
		val toConverted: Long = numberToLong(to, "to")
		val result = CalendarItemFilters.byPeriodForSelf(
			fromConverted,
			toConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byRecurrenceId(recurrenceId: String): FilterOptionsJs<CalendarItemJs> {
		val recurrenceIdConverted: String = recurrenceId
		val result = CalendarItemFilters.byRecurrenceId(
			recurrenceIdConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun lifecycleBetweenForDataOwner(
		dataOwnerId: String,
		startTimestamp: Double?,
		endTimestamp: Double?,
		descending: Boolean,
	): BaseFilterOptionsJs<CalendarItemJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val startTimestampConverted: Long? = numberToLong(startTimestamp, "startTimestamp")
		val endTimestampConverted: Long? = numberToLong(endTimestamp, "endTimestamp")
		val descendingConverted: Boolean = descending
		val result = CalendarItemFilters.lifecycleBetweenForDataOwner(
			dataOwnerIdConverted,
			startTimestampConverted,
			endTimestampConverted,
			descendingConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun lifecycleBetweenForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		startTimestamp: Double?,
		endTimestamp: Double?,
		descending: Boolean,
	): BaseFilterOptionsJs<CalendarItemJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val startTimestampConverted: Long? = numberToLong(startTimestamp, "startTimestamp")
		val endTimestampConverted: Long? = numberToLong(endTimestamp, "endTimestamp")
		val descendingConverted: Boolean = descending
		val result = CalendarItemFilters.lifecycleBetweenForDataOwnerInGroup(
			dataOwnerConverted,
			startTimestampConverted,
			endTimestampConverted,
			descendingConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun lifecycleBetweenForSelf(
		startTimestamp: Double?,
		endTimestamp: Double?,
		descending: Boolean,
	): FilterOptionsJs<CalendarItemJs> {
		val startTimestampConverted: Long? = numberToLong(startTimestamp, "startTimestamp")
		val endTimestampConverted: Long? = numberToLong(endTimestamp, "endTimestamp")
		val descendingConverted: Boolean = descending
		val result = CalendarItemFilters.lifecycleBetweenForSelf(
			startTimestampConverted,
			endTimestampConverted,
			descendingConverted,
		)
		return FilterOptionsJsImpl(result)
	}
}
