// auto-generated file
package com.icure.cardinal.sdk.js.filters

import com.icure.cardinal.sdk.filters.ServiceFilters
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.base.IdentifierJs
import com.icure.cardinal.sdk.js.model.base.identifier_fromJs
import com.icure.cardinal.sdk.js.model.embed.ServiceJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.patient_fromJs
import com.icure.cardinal.sdk.js.utils.Record
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
import kotlin.collections.Map
import kotlin.collections.Set
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

	public fun byCodesAndValueDateForDataOwner(
		dataOwnerId: String,
		codeCodes: Record<String, Array<String>>,
		options: dynamic,
	): BaseFilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val codeCodesConverted: Map<String, Set<String>> = objectToMap(
			codeCodes,
			"codeCodes",
			{ x1: String ->
				x1
			},
			{ x1: Array<String> ->
				arrayToSet(
					x1,
					"x1",
					{ x2: String ->
						x2
					},
				)
			},
		)
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
		val result = ServiceFilters.byCodesAndValueDateForDataOwner(
			dataOwnerIdConverted,
			codeCodesConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byCodesAndValueDateForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		codeCodes: Record<String, Array<String>>,
		options: dynamic,
	): BaseFilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val codeCodesConverted: Map<String, Set<String>> = objectToMap(
			codeCodes,
			"codeCodes",
			{ x1: String ->
				x1
			},
			{ x1: Array<String> ->
				arrayToSet(
					x1,
					"x1",
					{ x2: String ->
						x2
					},
				)
			},
		)
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
		val result = ServiceFilters.byCodesAndValueDateForDataOwnerInGroup(
			dataOwnerConverted,
			codeCodesConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byCodesAndValueDateForSelf(codeCodes: Record<String, Array<String>>, options: dynamic):
			FilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val codeCodesConverted: Map<String, Set<String>> = objectToMap(
			codeCodes,
			"codeCodes",
			{ x1: String ->
				x1
			},
			{ x1: Array<String> ->
				arrayToSet(
					x1,
					"x1",
					{ x2: String ->
						x2
					},
				)
			},
		)
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
		val result = ServiceFilters.byCodesAndValueDateForSelf(
			codeCodesConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byCodePrefixAndValueDateForDataOwner(
		dataOwnerId: String,
		codeType: String,
		codeCodePrefix: String,
		options: dynamic,
	): BaseFilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val codeTypeConverted: String = codeType
		val codeCodePrefixConverted: String = codeCodePrefix
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
		val result = ServiceFilters.byCodePrefixAndValueDateForDataOwner(
			dataOwnerIdConverted,
			codeTypeConverted,
			codeCodePrefixConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byCodePrefixAndValueDateForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		codeType: String,
		codeCodePrefix: String,
		options: dynamic,
	): BaseFilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val codeTypeConverted: String = codeType
		val codeCodePrefixConverted: String = codeCodePrefix
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
		val result = ServiceFilters.byCodePrefixAndValueDateForDataOwnerInGroup(
			dataOwnerConverted,
			codeTypeConverted,
			codeCodePrefixConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byCodePrefixAndValueDateForSelf(
		codeType: String,
		codeCodePrefix: String,
		options: dynamic,
	): FilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val codeTypeConverted: String = codeType
		val codeCodePrefixConverted: String = codeCodePrefix
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
		val result = ServiceFilters.byCodePrefixAndValueDateForSelf(
			codeTypeConverted,
			codeCodePrefixConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byTagCodesAndValueDateForDataOwner(
		dataOwnerId: String,
		tagCodes: Record<String, Array<String>>,
		options: dynamic,
	): BaseFilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val tagCodesConverted: Map<String, Set<String>> = objectToMap(
			tagCodes,
			"tagCodes",
			{ x1: String ->
				x1
			},
			{ x1: Array<String> ->
				arrayToSet(
					x1,
					"x1",
					{ x2: String ->
						x2
					},
				)
			},
		)
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
		val result = ServiceFilters.byTagCodesAndValueDateForDataOwner(
			dataOwnerIdConverted,
			tagCodesConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byTagCodesAndValueDateForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		tagCodes: Record<String, Array<String>>,
		options: dynamic,
	): BaseFilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val tagCodesConverted: Map<String, Set<String>> = objectToMap(
			tagCodes,
			"tagCodes",
			{ x1: String ->
				x1
			},
			{ x1: Array<String> ->
				arrayToSet(
					x1,
					"x1",
					{ x2: String ->
						x2
					},
				)
			},
		)
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
		val result = ServiceFilters.byTagCodesAndValueDateForDataOwnerInGroup(
			dataOwnerConverted,
			tagCodesConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byTagCodesAndValueDateForSelf(tagCodes: Record<String, Array<String>>,
			options: dynamic): FilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val tagCodesConverted: Map<String, Set<String>> = objectToMap(
			tagCodes,
			"tagCodes",
			{ x1: String ->
				x1
			},
			{ x1: Array<String> ->
				arrayToSet(
					x1,
					"x1",
					{ x2: String ->
						x2
					},
				)
			},
		)
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
		val result = ServiceFilters.byTagCodesAndValueDateForSelf(
			tagCodesConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byTagPrefixAndValueDateForDataOwner(
		dataOwnerId: String,
		tagType: String,
		tagCodePrefix: String,
		options: dynamic,
	): BaseFilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val tagTypeConverted: String = tagType
		val tagCodePrefixConverted: String = tagCodePrefix
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
		val result = ServiceFilters.byTagPrefixAndValueDateForDataOwner(
			dataOwnerIdConverted,
			tagTypeConverted,
			tagCodePrefixConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byTagPrefixAndValueDateForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		tagType: String,
		tagCodePrefix: String,
		options: dynamic,
	): BaseFilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val tagTypeConverted: String = tagType
		val tagCodePrefixConverted: String = tagCodePrefix
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
		val result = ServiceFilters.byTagPrefixAndValueDateForDataOwnerInGroup(
			dataOwnerConverted,
			tagTypeConverted,
			tagCodePrefixConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byTagPrefixAndValueDateForSelf(
		tagType: String,
		tagCodePrefix: String,
		options: dynamic,
	): FilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val tagTypeConverted: String = tagType
		val tagCodePrefixConverted: String = tagCodePrefix
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
		val result = ServiceFilters.byTagPrefixAndValueDateForSelf(
			tagTypeConverted,
			tagCodePrefixConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byPatientsCodesAndValueDateForDataOwner(
		dataOwnerId: String,
		patients: Array<PatientJs>,
		codeCodes: Record<String, Array<String>>,
		options: dynamic,
	): FilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val codeCodesConverted: Map<String, Set<String>> = objectToMap(
			codeCodes,
			"codeCodes",
			{ x1: String ->
				x1
			},
			{ x1: Array<String> ->
				arrayToSet(
					x1,
					"x1",
					{ x2: String ->
						x2
					},
				)
			},
		)
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
		val result = ServiceFilters.byPatientsCodesAndValueDateForDataOwner(
			dataOwnerIdConverted,
			patientsConverted,
			codeCodesConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byPatientsCodesAndValueDateForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		patients: Array<PatientJs>,
		codeCodes: Record<String, Array<String>>,
		options: dynamic,
	): FilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val codeCodesConverted: Map<String, Set<String>> = objectToMap(
			codeCodes,
			"codeCodes",
			{ x1: String ->
				x1
			},
			{ x1: Array<String> ->
				arrayToSet(
					x1,
					"x1",
					{ x2: String ->
						x2
					},
				)
			},
		)
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
		val result = ServiceFilters.byPatientsCodesAndValueDateForDataOwnerInGroup(
			dataOwnerConverted,
			patientsConverted,
			codeCodesConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byPatientsCodesAndValueDateForSelf(
		patients: Array<PatientJs>,
		codeCodes: Record<String, Array<String>>,
		options: dynamic,
	): FilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val codeCodesConverted: Map<String, Set<String>> = objectToMap(
			codeCodes,
			"codeCodes",
			{ x1: String ->
				x1
			},
			{ x1: Array<String> ->
				arrayToSet(
					x1,
					"x1",
					{ x2: String ->
						x2
					},
				)
			},
		)
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
		val result = ServiceFilters.byPatientsCodesAndValueDateForSelf(
			patientsConverted,
			codeCodesConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byPatientSecretIdsCodesAndValueDateForDataOwner(
		dataOwnerId: String,
		secretIds: Array<String>,
		codeCodes: Record<String, Array<String>>,
		options: dynamic,
	): BaseFilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val codeCodesConverted: Map<String, Set<String>> = objectToMap(
			codeCodes,
			"codeCodes",
			{ x1: String ->
				x1
			},
			{ x1: Array<String> ->
				arrayToSet(
					x1,
					"x1",
					{ x2: String ->
						x2
					},
				)
			},
		)
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
		val result = ServiceFilters.byPatientSecretIdsCodesAndValueDateForDataOwner(
			dataOwnerIdConverted,
			secretIdsConverted,
			codeCodesConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byPatientSecretIdsCodesAndValueDateForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		secretIds: Array<String>,
		codeCodes: Record<String, Array<String>>,
		options: dynamic,
	): BaseFilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val codeCodesConverted: Map<String, Set<String>> = objectToMap(
			codeCodes,
			"codeCodes",
			{ x1: String ->
				x1
			},
			{ x1: Array<String> ->
				arrayToSet(
					x1,
					"x1",
					{ x2: String ->
						x2
					},
				)
			},
		)
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
		val result = ServiceFilters.byPatientSecretIdsCodesAndValueDateForDataOwnerInGroup(
			dataOwnerConverted,
			secretIdsConverted,
			codeCodesConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byPatientSecretIdsCodesAndValueDateForSelf(
		secretIds: Array<String>,
		codeCodes: Record<String, Array<String>>,
		options: dynamic,
	): FilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val codeCodesConverted: Map<String, Set<String>> = objectToMap(
			codeCodes,
			"codeCodes",
			{ x1: String ->
				x1
			},
			{ x1: Array<String> ->
				arrayToSet(
					x1,
					"x1",
					{ x2: String ->
						x2
					},
				)
			},
		)
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
		val result = ServiceFilters.byPatientSecretIdsCodesAndValueDateForSelf(
			secretIdsConverted,
			codeCodesConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byPatientsCodePrefixAndValueDateForDataOwner(
		dataOwnerId: String,
		patients: Array<PatientJs>,
		codeType: String,
		codeCodePrefix: String,
		options: dynamic,
	): FilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val codeTypeConverted: String = codeType
		val codeCodePrefixConverted: String = codeCodePrefix
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
		val result = ServiceFilters.byPatientsCodePrefixAndValueDateForDataOwner(
			dataOwnerIdConverted,
			patientsConverted,
			codeTypeConverted,
			codeCodePrefixConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byPatientsCodePrefixAndValueDateForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		patients: Array<PatientJs>,
		codeType: String,
		codeCodePrefix: String,
		options: dynamic,
	): FilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val codeTypeConverted: String = codeType
		val codeCodePrefixConverted: String = codeCodePrefix
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
		val result = ServiceFilters.byPatientsCodePrefixAndValueDateForDataOwnerInGroup(
			dataOwnerConverted,
			patientsConverted,
			codeTypeConverted,
			codeCodePrefixConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byPatientsCodePrefixAndValueDateForSelf(
		patients: Array<PatientJs>,
		codeType: String,
		codeCodePrefix: String,
		options: dynamic,
	): FilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val codeTypeConverted: String = codeType
		val codeCodePrefixConverted: String = codeCodePrefix
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
		val result = ServiceFilters.byPatientsCodePrefixAndValueDateForSelf(
			patientsConverted,
			codeTypeConverted,
			codeCodePrefixConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byPatientSecretIdsCodePrefixAndValueDateForDataOwner(
		dataOwnerId: String,
		secretIds: Array<String>,
		codeType: String,
		codeCodePrefix: String,
		options: dynamic,
	): BaseFilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val codeTypeConverted: String = codeType
		val codeCodePrefixConverted: String = codeCodePrefix
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
		val result = ServiceFilters.byPatientSecretIdsCodePrefixAndValueDateForDataOwner(
			dataOwnerIdConverted,
			secretIdsConverted,
			codeTypeConverted,
			codeCodePrefixConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byPatientSecretIdsCodePrefixAndValueDateForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		secretIds: Array<String>,
		codeType: String,
		codeCodePrefix: String,
		options: dynamic,
	): BaseFilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val codeTypeConverted: String = codeType
		val codeCodePrefixConverted: String = codeCodePrefix
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
		val result = ServiceFilters.byPatientSecretIdsCodePrefixAndValueDateForDataOwnerInGroup(
			dataOwnerConverted,
			secretIdsConverted,
			codeTypeConverted,
			codeCodePrefixConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byPatientSecretIdsCodePrefixAndValueDateForSelf(
		secretIds: Array<String>,
		codeType: String,
		codeCodePrefix: String,
		options: dynamic,
	): FilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val codeTypeConverted: String = codeType
		val codeCodePrefixConverted: String = codeCodePrefix
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
		val result = ServiceFilters.byPatientSecretIdsCodePrefixAndValueDateForSelf(
			secretIdsConverted,
			codeTypeConverted,
			codeCodePrefixConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byPatientsTagCodesAndValueDateForDataOwner(
		dataOwnerId: String,
		patients: Array<PatientJs>,
		tagCodes: Record<String, Array<String>>,
		options: dynamic,
	): FilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val tagCodesConverted: Map<String, Set<String>> = objectToMap(
			tagCodes,
			"tagCodes",
			{ x1: String ->
				x1
			},
			{ x1: Array<String> ->
				arrayToSet(
					x1,
					"x1",
					{ x2: String ->
						x2
					},
				)
			},
		)
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
		val result = ServiceFilters.byPatientsTagCodesAndValueDateForDataOwner(
			dataOwnerIdConverted,
			patientsConverted,
			tagCodesConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byPatientsTagCodesAndValueDateForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		patients: Array<PatientJs>,
		tagCodes: Record<String, Array<String>>,
		options: dynamic,
	): FilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val tagCodesConverted: Map<String, Set<String>> = objectToMap(
			tagCodes,
			"tagCodes",
			{ x1: String ->
				x1
			},
			{ x1: Array<String> ->
				arrayToSet(
					x1,
					"x1",
					{ x2: String ->
						x2
					},
				)
			},
		)
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
		val result = ServiceFilters.byPatientsTagCodesAndValueDateForDataOwnerInGroup(
			dataOwnerConverted,
			patientsConverted,
			tagCodesConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byPatientsTagCodesAndValueDateForSelf(
		patients: Array<PatientJs>,
		tagCodes: Record<String, Array<String>>,
		options: dynamic,
	): FilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val tagCodesConverted: Map<String, Set<String>> = objectToMap(
			tagCodes,
			"tagCodes",
			{ x1: String ->
				x1
			},
			{ x1: Array<String> ->
				arrayToSet(
					x1,
					"x1",
					{ x2: String ->
						x2
					},
				)
			},
		)
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
		val result = ServiceFilters.byPatientsTagCodesAndValueDateForSelf(
			patientsConverted,
			tagCodesConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byPatientSecretIdsTagCodesAndValueDateForDataOwner(
		dataOwnerId: String,
		secretIds: Array<String>,
		tagCodes: Record<String, Array<String>>,
		options: dynamic,
	): BaseFilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val tagCodesConverted: Map<String, Set<String>> = objectToMap(
			tagCodes,
			"tagCodes",
			{ x1: String ->
				x1
			},
			{ x1: Array<String> ->
				arrayToSet(
					x1,
					"x1",
					{ x2: String ->
						x2
					},
				)
			},
		)
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
		val result = ServiceFilters.byPatientSecretIdsTagCodesAndValueDateForDataOwner(
			dataOwnerIdConverted,
			secretIdsConverted,
			tagCodesConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byPatientSecretIdsTagCodesAndValueDateForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		secretIds: Array<String>,
		tagCodes: Record<String, Array<String>>,
		options: dynamic,
	): BaseFilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val tagCodesConverted: Map<String, Set<String>> = objectToMap(
			tagCodes,
			"tagCodes",
			{ x1: String ->
				x1
			},
			{ x1: Array<String> ->
				arrayToSet(
					x1,
					"x1",
					{ x2: String ->
						x2
					},
				)
			},
		)
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
		val result = ServiceFilters.byPatientSecretIdsTagCodesAndValueDateForDataOwnerInGroup(
			dataOwnerConverted,
			secretIdsConverted,
			tagCodesConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byPatientSecretIdsTagCodesAndValueDateForSelf(
		secretIds: Array<String>,
		tagCodes: Record<String, Array<String>>,
		options: dynamic,
	): FilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val tagCodesConverted: Map<String, Set<String>> = objectToMap(
			tagCodes,
			"tagCodes",
			{ x1: String ->
				x1
			},
			{ x1: Array<String> ->
				arrayToSet(
					x1,
					"x1",
					{ x2: String ->
						x2
					},
				)
			},
		)
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
		val result = ServiceFilters.byPatientSecretIdsTagCodesAndValueDateForSelf(
			secretIdsConverted,
			tagCodesConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byPatientsTagPrefixAndValueDateForDataOwner(
		dataOwnerId: String,
		patients: Array<PatientJs>,
		tagType: String,
		tagCodePrefix: String,
		options: dynamic,
	): FilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val tagTypeConverted: String = tagType
		val tagCodePrefixConverted: String = tagCodePrefix
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
		val result = ServiceFilters.byPatientsTagPrefixAndValueDateForDataOwner(
			dataOwnerIdConverted,
			patientsConverted,
			tagTypeConverted,
			tagCodePrefixConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byPatientsTagPrefixAndValueDateForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		patients: Array<PatientJs>,
		tagType: String,
		tagCodePrefix: String,
		options: dynamic,
	): FilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val tagTypeConverted: String = tagType
		val tagCodePrefixConverted: String = tagCodePrefix
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
		val result = ServiceFilters.byPatientsTagPrefixAndValueDateForDataOwnerInGroup(
			dataOwnerConverted,
			patientsConverted,
			tagTypeConverted,
			tagCodePrefixConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byPatientsTagPrefixAndValueDateForSelf(
		patients: Array<PatientJs>,
		tagType: String,
		tagCodePrefix: String,
		options: dynamic,
	): FilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val tagTypeConverted: String = tagType
		val tagCodePrefixConverted: String = tagCodePrefix
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
		val result = ServiceFilters.byPatientsTagPrefixAndValueDateForSelf(
			patientsConverted,
			tagTypeConverted,
			tagCodePrefixConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byPatientSecretIdsTagPrefixAndValueDateForDataOwner(
		dataOwnerId: String,
		secretIds: Array<String>,
		tagType: String,
		tagCodePrefix: String,
		options: dynamic,
	): BaseFilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val tagTypeConverted: String = tagType
		val tagCodePrefixConverted: String = tagCodePrefix
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
		val result = ServiceFilters.byPatientSecretIdsTagPrefixAndValueDateForDataOwner(
			dataOwnerIdConverted,
			secretIdsConverted,
			tagTypeConverted,
			tagCodePrefixConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byPatientSecretIdsTagPrefixAndValueDateForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroupJs,
		secretIds: Array<String>,
		tagType: String,
		tagCodePrefix: String,
		options: dynamic,
	): BaseFilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val tagTypeConverted: String = tagType
		val tagCodePrefixConverted: String = tagCodePrefix
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
		val result = ServiceFilters.byPatientSecretIdsTagPrefixAndValueDateForDataOwnerInGroup(
			dataOwnerConverted,
			secretIdsConverted,
			tagTypeConverted,
			tagCodePrefixConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byPatientSecretIdsTagPrefixAndValueDateForSelf(
		secretIds: Array<String>,
		tagType: String,
		tagCodePrefix: String,
		options: dynamic,
	): FilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val tagTypeConverted: String = tagType
		val tagCodePrefixConverted: String = tagCodePrefix
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
		val result = ServiceFilters.byPatientSecretIdsTagPrefixAndValueDateForSelf(
			secretIdsConverted,
			tagTypeConverted,
			tagCodePrefixConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return FilterOptionsJsImpl(result)
	}
}
