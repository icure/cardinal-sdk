// auto-generated file
package com.icure.cardinal.sdk.js.filters

import com.icure.cardinal.sdk.filters.AccessLogFilters
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.model.AccessLogJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInstant
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.patient_fromJs
import com.icure.cardinal.sdk.model.Patient
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.collections.List
import kotlin.js.JsExport
import kotlin.time.Instant

@JsExport
public object InternalAccessLogFiltersObj {
	public fun byPatientsDateForDataOwner(
		dataOwnerId: String,
		patients: Array<PatientJs>,
		options: dynamic,
	): SortableFilterOptionsJs<AccessLogJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val fromConverted: Instant? = convertingOptionOrDefaultNullable(
			_options,
			"from",
			null
		) { from: Double? ->
			numberToInstant(from, "from")
		}
		val toConverted: Instant? = convertingOptionOrDefaultNullable(
			_options,
			"to",
			null
		) { to: Double? ->
			numberToInstant(to, "to")
		}
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = AccessLogFilters.byPatientsDateForDataOwner(
			dataOwnerIdConverted,
			patientsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsDateForSelf(patients: Array<PatientJs>, options: dynamic):
			SortableFilterOptionsJs<AccessLogJs> {
		val _options = options ?: js("{}")
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val fromConverted: Instant? = convertingOptionOrDefaultNullable(
			_options,
			"from",
			null
		) { from: Double? ->
			numberToInstant(from, "from")
		}
		val toConverted: Instant? = convertingOptionOrDefaultNullable(
			_options,
			"to",
			null
		) { to: Double? ->
			numberToInstant(to, "to")
		}
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = AccessLogFilters.byPatientsDateForSelf(
			patientsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientSecretIdsDateForDataOwner(
		dataOwnerId: String,
		secretIds: Array<String>,
		options: dynamic,
	): BaseSortableFilterOptionsJs<AccessLogJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val fromConverted: Instant? = convertingOptionOrDefaultNullable(
			_options,
			"from",
			null
		) { from: Double? ->
			numberToInstant(from, "from")
		}
		val toConverted: Instant? = convertingOptionOrDefaultNullable(
			_options,
			"to",
			null
		) { to: Double? ->
			numberToInstant(to, "to")
		}
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = AccessLogFilters.byPatientSecretIdsDateForDataOwner(
			dataOwnerIdConverted,
			secretIdsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byPatientSecretIdsDateForSelf(secretIds: Array<String>, options: dynamic):
			SortableFilterOptionsJs<AccessLogJs> {
		val _options = options ?: js("{}")
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val fromConverted: Instant? = convertingOptionOrDefaultNullable(
			_options,
			"from",
			null
		) { from: Double? ->
			numberToInstant(from, "from")
		}
		val toConverted: Instant? = convertingOptionOrDefaultNullable(
			_options,
			"to",
			null
		) { to: Double? ->
			numberToInstant(to, "to")
		}
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = AccessLogFilters.byPatientSecretIdsDateForSelf(
			secretIdsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byDate(options: dynamic): BaseSortableFilterOptionsJs<AccessLogJs> {
		val _options = options ?: js("{}")
		val fromConverted: Instant? = convertingOptionOrDefaultNullable(
			_options,
			"from",
			null
		) { from: Double? ->
			numberToInstant(from, "from")
		}
		val toConverted: Instant? = convertingOptionOrDefaultNullable(
			_options,
			"to",
			null
		) { to: Double? ->
			numberToInstant(to, "to")
		}
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = AccessLogFilters.byDate(
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byUserTypeDate(userId: String, options: dynamic):
			BaseSortableFilterOptionsJs<AccessLogJs> {
		val _options = options ?: js("{}")
		val userIdConverted: String = userId
		val accessTypeConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"accessType",
			null
		) { accessType: String? ->
			undefinedToNull(accessType)
		}
		val fromConverted: Instant? = convertingOptionOrDefaultNullable(
			_options,
			"from",
			null
		) { from: Double? ->
			numberToInstant(from, "from")
		}
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = AccessLogFilters.byUserTypeDate(
			userIdConverted,
			accessTypeConverted,
			fromConverted,
			descendingConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}
}
