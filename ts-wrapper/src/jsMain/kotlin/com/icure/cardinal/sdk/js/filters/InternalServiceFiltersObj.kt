// auto-generated file
package com.icure.cardinal.sdk.js.filters

import com.icure.cardinal.sdk.filters.ServiceFilters
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.base.IdentifierJs
import com.icure.cardinal.sdk.js.model.base.identifier_fromJs
import com.icure.cardinal.sdk.js.model.embed.ServiceJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.patient_fromJs
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.base.LinkQualification
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.js.JsExport

@JsExport
public object InternalServiceFiltersObj {
	public fun allServicesForDataOwner(dataOwnerId: String): BaseFilterOptionsJs<ServiceJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val result = ServiceFilters.allServicesForDataOwner(
			dataOwnerIdConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun allServicesForDataOwnerInGroup(dataOwner: EntityReferenceInGroupJs):
			BaseFilterOptionsJs<ServiceJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val result = ServiceFilters.allServicesForDataOwnerInGroup(
			dataOwnerConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun allServicesForSelf(): FilterOptionsJs<ServiceJs> {
		val result = ServiceFilters.allServicesForSelf(
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byIdentifiersForDataOwner(dataOwnerId: String, identifiers: Array<IdentifierJs>):
			BaseSortableFilterOptionsJs<ServiceJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val identifiersConverted: List<Identifier> = arrayToList(
			identifiers,
			"identifiers",
			{ x1: IdentifierJs ->
				identifier_fromJs(x1)
			},
		)
		val result = ServiceFilters.byIdentifiersForDataOwner(
			dataOwnerIdConverted,
			identifiersConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byIdentifiersForDataOwnerInGroup(dataOwner: EntityReferenceInGroupJs,
			identifiers: Array<IdentifierJs>): BaseSortableFilterOptionsJs<ServiceJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val identifiersConverted: List<Identifier> = arrayToList(
			identifiers,
			"identifiers",
			{ x1: IdentifierJs ->
				identifier_fromJs(x1)
			},
		)
		val result = ServiceFilters.byIdentifiersForDataOwnerInGroup(
			dataOwnerConverted,
			identifiersConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byCodeAndValueDateForDataOwner(
		dataOwnerId: String,
		codeType: String,
		options: dynamic,
	): BaseSortableFilterOptionsJs<ServiceJs> {
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
		val startOfServiceValueDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"startOfServiceValueDate",
			null
		) { startOfServiceValueDate: Double? ->
			numberToLong(startOfServiceValueDate, "startOfServiceValueDate")
		}
		val endOfServiceValueDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"endOfServiceValueDate",
			null
		) { endOfServiceValueDate: Double? ->
			numberToLong(endOfServiceValueDate, "endOfServiceValueDate")
		}
		val result = ServiceFilters.byCodeAndValueDateForDataOwner(
			dataOwnerIdConverted,
			codeTypeConverted,
			codeCodeConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byCodeAndValueDateForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		codeType: String,
		options: dynamic,
	): BaseSortableFilterOptionsJs<ServiceJs> {
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
		val startOfServiceValueDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"startOfServiceValueDate",
			null
		) { startOfServiceValueDate: Double? ->
			numberToLong(startOfServiceValueDate, "startOfServiceValueDate")
		}
		val endOfServiceValueDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"endOfServiceValueDate",
			null
		) { endOfServiceValueDate: Double? ->
			numberToLong(endOfServiceValueDate, "endOfServiceValueDate")
		}
		val result = ServiceFilters.byCodeAndValueDateForDataOwnerInGroup(
			dataOwnerConverted,
			codeTypeConverted,
			codeCodeConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byTagAndValueDateForDataOwner(
		dataOwnerId: String,
		tagType: String,
		options: dynamic,
	): BaseSortableFilterOptionsJs<ServiceJs> {
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
		val startOfServiceValueDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"startOfServiceValueDate",
			null
		) { startOfServiceValueDate: Double? ->
			numberToLong(startOfServiceValueDate, "startOfServiceValueDate")
		}
		val endOfServiceValueDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"endOfServiceValueDate",
			null
		) { endOfServiceValueDate: Double? ->
			numberToLong(endOfServiceValueDate, "endOfServiceValueDate")
		}
		val result = ServiceFilters.byTagAndValueDateForDataOwner(
			dataOwnerIdConverted,
			tagTypeConverted,
			tagCodeConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byTagAndValueDateForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		tagType: String,
		options: dynamic,
	): BaseSortableFilterOptionsJs<ServiceJs> {
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
		val startOfServiceValueDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"startOfServiceValueDate",
			null
		) { startOfServiceValueDate: Double? ->
			numberToLong(startOfServiceValueDate, "startOfServiceValueDate")
		}
		val endOfServiceValueDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"endOfServiceValueDate",
			null
		) { endOfServiceValueDate: Double? ->
			numberToLong(endOfServiceValueDate, "endOfServiceValueDate")
		}
		val result = ServiceFilters.byTagAndValueDateForDataOwnerInGroup(
			dataOwnerConverted,
			tagTypeConverted,
			tagCodeConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsForDataOwner(dataOwnerId: String, patients: Array<PatientJs>):
			SortableFilterOptionsJs<ServiceJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val result = ServiceFilters.byPatientsForDataOwner(
			dataOwnerIdConverted,
			patientsConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsForDataOwnerInGroup(dataOwner: EntityReferenceInGroupJs,
			patients: Array<PatientJs>): SortableFilterOptionsJs<ServiceJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val result = ServiceFilters.byPatientsForDataOwnerInGroup(
			dataOwnerConverted,
			patientsConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsSecretIdsForDataOwner(dataOwnerId: String, secretIds: Array<String>):
			BaseSortableFilterOptionsJs<ServiceJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val result = ServiceFilters.byPatientsSecretIdsForDataOwner(
			dataOwnerIdConverted,
			secretIdsConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsSecretIdsForDataOwnerInGroup(dataOwner: EntityReferenceInGroupJs,
			secretIds: Array<String>): BaseSortableFilterOptionsJs<ServiceJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val result = ServiceFilters.byPatientsSecretIdsForDataOwnerInGroup(
			dataOwnerConverted,
			secretIdsConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byHealthElementIdFromSubContactForDataOwner(dataOwnerId: String,
			healthElementIds: Array<String>): BaseSortableFilterOptionsJs<ServiceJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val healthElementIdsConverted: List<String> = arrayToList(
			healthElementIds,
			"healthElementIds",
			{ x1: String ->
				x1
			},
		)
		val result = ServiceFilters.byHealthElementIdFromSubContactForDataOwner(
			dataOwnerIdConverted,
			healthElementIdsConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byHealthElementIdFromSubContactForDataOwnerInGroup(dataOwner: EntityReferenceInGroupJs,
			healthElementIds: Array<String>): BaseSortableFilterOptionsJs<ServiceJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val healthElementIdsConverted: List<String> = arrayToList(
			healthElementIds,
			"healthElementIds",
			{ x1: String ->
				x1
			},
		)
		val result = ServiceFilters.byHealthElementIdFromSubContactForDataOwnerInGroup(
			dataOwnerConverted,
			healthElementIdsConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byIdentifiersForSelf(identifiers: Array<IdentifierJs>):
			SortableFilterOptionsJs<ServiceJs> {
		val identifiersConverted: List<Identifier> = arrayToList(
			identifiers,
			"identifiers",
			{ x1: IdentifierJs ->
				identifier_fromJs(x1)
			},
		)
		val result = ServiceFilters.byIdentifiersForSelf(
			identifiersConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byCodeAndValueDateForSelf(codeType: String, options: dynamic):
			SortableFilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val codeTypeConverted: String = codeType
		val codeCodeConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"codeCode",
			null
		) { codeCode: String? ->
			undefinedToNull(codeCode)
		}
		val startOfServiceValueDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"startOfServiceValueDate",
			null
		) { startOfServiceValueDate: Double? ->
			numberToLong(startOfServiceValueDate, "startOfServiceValueDate")
		}
		val endOfServiceValueDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"endOfServiceValueDate",
			null
		) { endOfServiceValueDate: Double? ->
			numberToLong(endOfServiceValueDate, "endOfServiceValueDate")
		}
		val result = ServiceFilters.byCodeAndValueDateForSelf(
			codeTypeConverted,
			codeCodeConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byTagAndValueDateForSelf(tagType: String, options: dynamic):
			SortableFilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val tagTypeConverted: String = tagType
		val tagCodeConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"tagCode",
			null
		) { tagCode: String? ->
			undefinedToNull(tagCode)
		}
		val startOfServiceValueDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"startOfServiceValueDate",
			null
		) { startOfServiceValueDate: Double? ->
			numberToLong(startOfServiceValueDate, "startOfServiceValueDate")
		}
		val endOfServiceValueDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"endOfServiceValueDate",
			null
		) { endOfServiceValueDate: Double? ->
			numberToLong(endOfServiceValueDate, "endOfServiceValueDate")
		}
		val result = ServiceFilters.byTagAndValueDateForSelf(
			tagTypeConverted,
			tagCodeConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsForSelf(patients: Array<PatientJs>): SortableFilterOptionsJs<ServiceJs> {
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val result = ServiceFilters.byPatientsForSelf(
			patientsConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsSecretIdsForSelf(secretIds: Array<String>):
			SortableFilterOptionsJs<ServiceJs> {
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val result = ServiceFilters.byPatientsSecretIdsForSelf(
			secretIdsConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byHealthElementIdFromSubContactForSelf(healthElementIds: Array<String>):
			SortableFilterOptionsJs<ServiceJs> {
		val healthElementIdsConverted: List<String> = arrayToList(
			healthElementIds,
			"healthElementIds",
			{ x1: String ->
				x1
			},
		)
		val result = ServiceFilters.byHealthElementIdFromSubContactForSelf(
			healthElementIdsConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byIds(ids: Array<String>): BaseSortableFilterOptionsJs<ServiceJs> {
		val idsConverted: List<String> = arrayToList(
			ids,
			"ids",
			{ x1: String ->
				x1
			},
		)
		val result = ServiceFilters.byIds(
			idsConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byAssociationId(associationId: String): BaseFilterOptionsJs<ServiceJs> {
		val associationIdConverted: String = associationId
		val result = ServiceFilters.byAssociationId(
			associationIdConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byQualifiedLink(linkValues: Array<String>, options: dynamic):
			BaseFilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val linkValuesConverted: List<String> = arrayToList(
			linkValues,
			"linkValues",
			{ x1: String ->
				x1
			},
		)
		val linkQualificationConverted: LinkQualification? = convertingOptionOrDefaultNullable(
			_options,
			"linkQualification",
			null
		) { linkQualification: String? ->
			linkQualification?.let { nonNull1 ->
				LinkQualification.valueOf(nonNull1)
			}
		}
		val result = ServiceFilters.byQualifiedLink(
			linkValuesConverted,
			linkQualificationConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byPatientsDateForDataOwner(
		dataOwnerId: String,
		patients: Array<PatientJs>,
		options: dynamic,
	): SortableFilterOptionsJs<ServiceJs> {
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
		val result = ServiceFilters.byPatientsDateForDataOwner(
			dataOwnerIdConverted,
			patientsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsDateForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		patients: Array<PatientJs>,
		options: dynamic,
	): SortableFilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
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
		val result = ServiceFilters.byPatientsDateForDataOwnerInGroup(
			dataOwnerConverted,
			patientsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsDateForSelf(patients: Array<PatientJs>, options: dynamic):
			SortableFilterOptionsJs<ServiceJs> {
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
		val result = ServiceFilters.byPatientsDateForSelf(
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
	): BaseSortableFilterOptionsJs<ServiceJs> {
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
		val result = ServiceFilters.byPatientSecretIdsDateForDataOwner(
			dataOwnerIdConverted,
			secretIdsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byPatientSecretIdsDateForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		secretIds: Array<String>,
		options: dynamic,
	): BaseSortableFilterOptionsJs<ServiceJs> {
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
		val result = ServiceFilters.byPatientSecretIdsDateForDataOwnerInGroup(
			dataOwnerConverted,
			secretIdsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byPatientSecretIdsDateForSelf(secretIds: Array<String>, options: dynamic):
			SortableFilterOptionsJs<ServiceJs> {
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
		val result = ServiceFilters.byPatientSecretIdsDateForSelf(
			secretIdsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}
}
