// auto-generated file
package com.icure.cardinal.sdk.js.filters

import com.icure.cardinal.sdk.filters.MessageFilters
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInstant
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.MessageJs
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
import kotlin.collections.Set
import kotlin.js.JsExport
import kotlin.time.Instant

@JsExport
public object InternalMessageFiltersObj {
	public fun allMessagesForDataOwner(dataOwnerId: String): BaseFilterOptionsJs<MessageJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val result = MessageFilters.allMessagesForDataOwner(
			dataOwnerIdConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun allMessagesForSelf(): FilterOptionsJs<MessageJs> {
		val result = MessageFilters.allMessagesForSelf(
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byTransportGuidForDataOwner(dataOwnerId: String, transportGuid: String):
			BaseSortableFilterOptionsJs<MessageJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val transportGuidConverted: String = transportGuid
		val result = MessageFilters.byTransportGuidForDataOwner(
			dataOwnerIdConverted,
			transportGuidConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byTransportGuidForDataOwnerInGroup(dataOwner: EntityReferenceInGroupJs,
			transportGuid: String): BaseSortableFilterOptionsJs<MessageJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val transportGuidConverted: String = transportGuid
		val result = MessageFilters.byTransportGuidForDataOwnerInGroup(
			dataOwnerConverted,
			transportGuidConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byTransportGuidForSelf(transportGuid: String): SortableFilterOptionsJs<MessageJs> {
		val transportGuidConverted: String = transportGuid
		val result = MessageFilters.byTransportGuidForSelf(
			transportGuidConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun fromAddressForDataOwner(dataOwnerId: String, address: String):
			BaseFilterOptionsJs<MessageJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val addressConverted: String = address
		val result = MessageFilters.fromAddressForDataOwner(
			dataOwnerIdConverted,
			addressConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun fromAddressForDataOwnerInGroup(dataOwner: EntityReferenceInGroupJs, address: String):
			BaseFilterOptionsJs<MessageJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val addressConverted: String = address
		val result = MessageFilters.fromAddressForDataOwnerInGroup(
			dataOwnerConverted,
			addressConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun fromAddressForSelf(address: String): FilterOptionsJs<MessageJs> {
		val addressConverted: String = address
		val result = MessageFilters.fromAddressForSelf(
			addressConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byPatientsSentDateForDataOwner(
		dataOwnerId: String,
		patients: Array<PatientJs>,
		options: dynamic,
	): SortableFilterOptionsJs<MessageJs> {
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
		val result = MessageFilters.byPatientsSentDateForDataOwner(
			dataOwnerIdConverted,
			patientsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsSentDateForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		patients: Array<GroupScopedJs<PatientJs>>,
		options: dynamic,
	): SortableFilterOptionsJs<MessageJs> {
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
		val result = MessageFilters.byPatientsSentDateForDataOwnerInGroup(
			dataOwnerConverted,
			patientsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsSentDateForSelf(patients: Array<PatientJs>, options: dynamic):
			SortableFilterOptionsJs<MessageJs> {
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
		val result = MessageFilters.byPatientsSentDateForSelf(
			patientsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientSecretIdsSentDateForDataOwner(
		dataOwnerId: String,
		secretIds: Array<String>,
		options: dynamic,
	): BaseSortableFilterOptionsJs<MessageJs> {
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
		val result = MessageFilters.byPatientSecretIdsSentDateForDataOwner(
			dataOwnerIdConverted,
			secretIdsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byPatientSecretIdsSentDateForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		secretIds: Array<String>,
		options: dynamic,
	): BaseSortableFilterOptionsJs<MessageJs> {
		val _options = options ?: js("{}")
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
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
		val result = MessageFilters.byPatientSecretIdsSentDateForDataOwnerInGroup(
			dataOwnerConverted,
			secretIdsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byPatientSecretIdsSentDateForSelf(secretIds: Array<String>, options: dynamic):
			SortableFilterOptionsJs<MessageJs> {
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
		val result = MessageFilters.byPatientSecretIdsSentDateForSelf(
			secretIdsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun toAddressForDataOwner(dataOwnerId: String, address: String):
			BaseFilterOptionsJs<MessageJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val addressConverted: String = address
		val result = MessageFilters.toAddressForDataOwner(
			dataOwnerIdConverted,
			addressConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun toAddressForDataOwnerInGroup(dataOwner: EntityReferenceInGroupJs, address: String):
			BaseFilterOptionsJs<MessageJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val addressConverted: String = address
		val result = MessageFilters.toAddressForDataOwnerInGroup(
			dataOwnerConverted,
			addressConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun toAddressForSelf(address: String): FilterOptionsJs<MessageJs> {
		val addressConverted: String = address
		val result = MessageFilters.toAddressForSelf(
			addressConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byTransportGuidSentDateForDataOwner(
		dataOwnerId: String,
		transportGuid: String,
		from: Double?,
		to: Double?,
		options: dynamic,
	): BaseSortableFilterOptionsJs<MessageJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val transportGuidConverted: String = transportGuid
		val fromConverted: Instant? = numberToInstant(from, "from")
		val toConverted: Instant? = numberToInstant(to, "to")
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = MessageFilters.byTransportGuidSentDateForDataOwner(
			dataOwnerIdConverted,
			transportGuidConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byTransportGuidSentDateForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		transportGuid: String,
		from: Double?,
		to: Double?,
		options: dynamic,
	): BaseSortableFilterOptionsJs<MessageJs> {
		val _options = options ?: js("{}")
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val transportGuidConverted: String = transportGuid
		val fromConverted: Instant? = numberToInstant(from, "from")
		val toConverted: Instant? = numberToInstant(to, "to")
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = MessageFilters.byTransportGuidSentDateForDataOwnerInGroup(
			dataOwnerConverted,
			transportGuidConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byTransportGuidSentDateForSelf(
		transportGuid: String,
		from: Double?,
		to: Double?,
		options: dynamic,
	): SortableFilterOptionsJs<MessageJs> {
		val _options = options ?: js("{}")
		val transportGuidConverted: String = transportGuid
		val fromConverted: Instant? = numberToInstant(from, "from")
		val toConverted: Instant? = numberToInstant(to, "to")
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = MessageFilters.byTransportGuidSentDateForSelf(
			transportGuidConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun latestByTransportGuidForDataOwner(dataOwnerId: String, transportGuid: String):
			BaseFilterOptionsJs<MessageJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val transportGuidConverted: String = transportGuid
		val result = MessageFilters.latestByTransportGuidForDataOwner(
			dataOwnerIdConverted,
			transportGuidConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun latestByTransportGuidForDataOwnerInGroup(dataOwner: EntityReferenceInGroupJs,
			transportGuid: String): BaseFilterOptionsJs<MessageJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val transportGuidConverted: String = transportGuid
		val result = MessageFilters.latestByTransportGuidForDataOwnerInGroup(
			dataOwnerConverted,
			transportGuidConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun latestByTransportGuidForSelf(transportGuid: String): FilterOptionsJs<MessageJs> {
		val transportGuidConverted: String = transportGuid
		val result = MessageFilters.latestByTransportGuidForSelf(
			transportGuidConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byInvoiceIds(invoiceIds: Array<String>): BaseFilterOptionsJs<MessageJs> {
		val invoiceIdsConverted: Set<String> = arrayToSet(
			invoiceIds,
			"invoiceIds",
			{ x1: String ->
				x1
			},
		)
		val result = MessageFilters.byInvoiceIds(
			invoiceIdsConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byParentIds(parentIds: Array<String>): BaseFilterOptionsJs<MessageJs> {
		val parentIdsConverted: List<String> = arrayToList(
			parentIds,
			"parentIds",
			{ x1: String ->
				x1
			},
		)
		val result = MessageFilters.byParentIds(
			parentIdsConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun lifecycleBetweenForDataOwner(
		dataOwnerId: String,
		startTimestamp: Double?,
		endTimestamp: Double?,
		descending: Boolean,
	): BaseFilterOptionsJs<MessageJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val startTimestampConverted: Long? = numberToLong(startTimestamp, "startTimestamp")
		val endTimestampConverted: Long? = numberToLong(endTimestamp, "endTimestamp")
		val descendingConverted: Boolean = descending
		val result = MessageFilters.lifecycleBetweenForDataOwner(
			dataOwnerIdConverted,
			startTimestampConverted,
			endTimestampConverted,
			descendingConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun lifecycleBetweenForDataOwnerInGroupInGroup(
		dataOwner: EntityReferenceInGroupJs,
		startTimestamp: Double?,
		endTimestamp: Double?,
		descending: Boolean,
	): BaseFilterOptionsJs<MessageJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val startTimestampConverted: Long? = numberToLong(startTimestamp, "startTimestamp")
		val endTimestampConverted: Long? = numberToLong(endTimestamp, "endTimestamp")
		val descendingConverted: Boolean = descending
		val result = MessageFilters.lifecycleBetweenForDataOwnerInGroupInGroup(
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
	): FilterOptionsJs<MessageJs> {
		val startTimestampConverted: Long? = numberToLong(startTimestamp, "startTimestamp")
		val endTimestampConverted: Long? = numberToLong(endTimestamp, "endTimestamp")
		val descendingConverted: Boolean = descending
		val result = MessageFilters.lifecycleBetweenForSelf(
			startTimestampConverted,
			endTimestampConverted,
			descendingConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byCodeForDataOwner(
		dataOwnerId: String,
		codeType: String,
		options: dynamic,
	): BaseSortableFilterOptionsJs<MessageJs> {
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
		val result = MessageFilters.byCodeForDataOwner(
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
	): BaseSortableFilterOptionsJs<MessageJs> {
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
		val result = MessageFilters.byCodeForDataOwnerInGroup(
			dataOwnerConverted,
			codeTypeConverted,
			codeCodeConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byCodeForSelf(codeType: String, options: dynamic): SortableFilterOptionsJs<MessageJs> {
		val _options = options ?: js("{}")
		val codeTypeConverted: String = codeType
		val codeCodeConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"codeCode",
			null
		) { codeCode: String? ->
			undefinedToNull(codeCode)
		}
		val result = MessageFilters.byCodeForSelf(
			codeTypeConverted,
			codeCodeConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byTagForDataOwner(
		dataOwnerId: String,
		tagType: String,
		options: dynamic,
	): BaseSortableFilterOptionsJs<MessageJs> {
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
		val result = MessageFilters.byTagForDataOwner(
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
	): BaseSortableFilterOptionsJs<MessageJs> {
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
		val result = MessageFilters.byTagForDataOwnerInGroup(
			dataOwnerConverted,
			tagTypeConverted,
			tagCodeConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byTagForSelf(tagType: String, options: dynamic): SortableFilterOptionsJs<MessageJs> {
		val _options = options ?: js("{}")
		val tagTypeConverted: String = tagType
		val tagCodeConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"tagCode",
			null
		) { tagCode: String? ->
			undefinedToNull(tagCode)
		}
		val result = MessageFilters.byTagForSelf(
			tagTypeConverted,
			tagCodeConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}
}
