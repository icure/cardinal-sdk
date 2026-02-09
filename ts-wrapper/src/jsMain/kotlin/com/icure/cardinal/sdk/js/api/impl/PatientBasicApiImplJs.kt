// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.PatientBasicApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.PatientBasicApiJs
import com.icure.cardinal.sdk.js.api.PatientBasicInGroupApiJs
import com.icure.cardinal.sdk.js.crypto.entities.EntityAccessInformationJs
import com.icure.cardinal.sdk.js.crypto.entities.entityAccessInformation_toJs
import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.EncryptedPatientJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
import com.icure.cardinal.sdk.js.model.patient_fromJs
import com.icure.cardinal.sdk.js.model.patient_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_toJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.cardinal.sdk.js.subscription.entitySubscription_toJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import kotlin.Array
import kotlin.Double
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Set
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class PatientBasicApiImplJs(
	private val patientBasicApi: PatientBasicApi,
) : PatientBasicApiJs {
	override val inGroup: PatientBasicInGroupApiJs = object : PatientBasicInGroupApiJs {
		override fun matchPatientsBy(groupId: String, filter: BaseFilterOptionsJs<PatientJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseFilterOptions<Patient> = baseFilterOptions_fromJs(filter)
			val result = patientBasicApi.inGroup.matchPatientsBy(
				groupIdConverted,
				filterConverted,
			)
			listToArray(
				result,
				{ x1: String ->
					x1
				},
			)
		}

		override fun matchPatientsBySorted(groupId: String,
				filter: BaseSortableFilterOptionsJs<PatientJs>): Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseSortableFilterOptions<Patient> =
					baseSortableFilterOptions_fromJs(filter)
			val result = patientBasicApi.inGroup.matchPatientsBySorted(
				groupIdConverted,
				filterConverted,
			)
			listToArray(
				result,
				{ x1: String ->
					x1
				},
			)
		}

		override fun filterPatientsBy(groupId: String, filter: BaseFilterOptionsJs<PatientJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedPatientJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseFilterOptions<Patient> = baseFilterOptions_fromJs(filter)
			val result = patientBasicApi.inGroup.filterPatientsBy(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<EncryptedPatient> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedPatient ->
							patient_toJs(x2)
						},
					)
				},
			)
		}

		override fun filterPatientsBySorted(groupId: String,
				filter: BaseSortableFilterOptionsJs<PatientJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedPatientJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseSortableFilterOptions<Patient> =
					baseSortableFilterOptions_fromJs(filter)
			val result = patientBasicApi.inGroup.filterPatientsBySorted(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<EncryptedPatient> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedPatient ->
							patient_toJs(x2)
						},
					)
				},
			)
		}

		override fun deletePatientById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = patientBasicApi.inGroup.deletePatientById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deletePatientsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val entityIdsConverted: List<GroupScoped<StoredDocumentIdentifier>> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: GroupScopedJs<StoredDocumentIdentifierJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: StoredDocumentIdentifierJs ->
							storedDocumentIdentifier_fromJs(x2)
						},
					)
				},
			)
			val result = patientBasicApi.inGroup.deletePatientsByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}

		override fun purgePatientById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit>
				= GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			patientBasicApi.inGroup.purgePatientById(
				entityIdConverted,
			)

		}

		override fun purgePatientsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val entityIdsConverted: List<GroupScoped<StoredDocumentIdentifier>> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: GroupScopedJs<StoredDocumentIdentifierJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: StoredDocumentIdentifierJs ->
							storedDocumentIdentifier_fromJs(x2)
						},
					)
				},
			)
			val result = patientBasicApi.inGroup.purgePatientsByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}

		override fun deletePatient(patient: GroupScopedJs<PatientJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val patientConverted: GroupScoped<Patient> = groupScoped_fromJs(
				patient,
				{ x1: PatientJs ->
					patient_fromJs(x1)
				},
			)
			val result = patientBasicApi.inGroup.deletePatient(
				patientConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deletePatients(patients: Array<GroupScopedJs<PatientJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
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
			val result = patientBasicApi.inGroup.deletePatients(
				patientsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}

		override fun purgePatient(patient: GroupScopedJs<PatientJs>): Promise<Unit> =
				GlobalScope.promise {
			val patientConverted: GroupScoped<Patient> = groupScoped_fromJs(
				patient,
				{ x1: PatientJs ->
					patient_fromJs(x1)
				},
			)
			patientBasicApi.inGroup.purgePatient(
				patientConverted,
			)

		}

		override fun getDataOwnersWithAccessTo(patient: GroupScopedJs<PatientJs>):
				Promise<EntityAccessInformationJs> = GlobalScope.promise {
			val patientConverted: GroupScoped<Patient> = groupScoped_fromJs(
				patient,
				{ x1: PatientJs ->
					patient_fromJs(x1)
				},
			)
			val result = patientBasicApi.inGroup.getDataOwnersWithAccessTo(
				patientConverted,
			)
			entityAccessInformation_toJs(result)
		}

		override fun createPatient(patient: GroupScopedJs<EncryptedPatientJs>):
				Promise<GroupScopedJs<EncryptedPatientJs>> = GlobalScope.promise {
			val patientConverted: GroupScoped<EncryptedPatient> = groupScoped_fromJs(
				patient,
				{ x1: EncryptedPatientJs ->
					patient_fromJs(x1)
				},
			)
			val result = patientBasicApi.inGroup.createPatient(
				patientConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedPatient ->
					patient_toJs(x1)
				},
			)
		}

		override fun createPatients(patients: Array<GroupScopedJs<EncryptedPatientJs>>):
				Promise<Array<GroupScopedJs<EncryptedPatientJs>>> = GlobalScope.promise {
			val patientsConverted: List<GroupScoped<EncryptedPatient>> = arrayToList(
				patients,
				"patients",
				{ x1: GroupScopedJs<EncryptedPatientJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedPatientJs ->
							patient_fromJs(x2)
						},
					)
				},
			)
			val result = patientBasicApi.inGroup.createPatients(
				patientsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedPatient> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedPatient ->
							patient_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeletePatient(patient: GroupScopedJs<PatientJs>):
				Promise<GroupScopedJs<EncryptedPatientJs>> = GlobalScope.promise {
			val patientConverted: GroupScoped<Patient> = groupScoped_fromJs(
				patient,
				{ x1: PatientJs ->
					patient_fromJs(x1)
				},
			)
			val result = patientBasicApi.inGroup.undeletePatient(
				patientConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedPatient ->
					patient_toJs(x1)
				},
			)
		}

		override fun undeletePatients(patients: Array<GroupScopedJs<PatientJs>>):
				Promise<Array<GroupScopedJs<EncryptedPatientJs>>> = GlobalScope.promise {
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
			val result = patientBasicApi.inGroup.undeletePatients(
				patientsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedPatient> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedPatient ->
							patient_toJs(x2)
						},
					)
				},
			)
		}

		override fun modifyPatient(entity: GroupScopedJs<EncryptedPatientJs>):
				Promise<GroupScopedJs<EncryptedPatientJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<EncryptedPatient> = groupScoped_fromJs(
				entity,
				{ x1: EncryptedPatientJs ->
					patient_fromJs(x1)
				},
			)
			val result = patientBasicApi.inGroup.modifyPatient(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedPatient ->
					patient_toJs(x1)
				},
			)
		}

		override fun undeletePatientById(patientId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<EncryptedPatientJs>> = GlobalScope.promise {
			val patientIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				patientId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = patientBasicApi.inGroup.undeletePatientById(
				patientIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedPatient ->
					patient_toJs(x1)
				},
			)
		}

		override fun undeletePatientsByIds(patientIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<EncryptedPatientJs>>> = GlobalScope.promise {
			val patientIdsConverted: List<GroupScoped<StoredDocumentIdentifier>> = arrayToList(
				patientIds,
				"patientIds",
				{ x1: GroupScopedJs<StoredDocumentIdentifierJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: StoredDocumentIdentifierJs ->
							storedDocumentIdentifier_fromJs(x2)
						},
					)
				},
			)
			val result = patientBasicApi.inGroup.undeletePatientsByIds(
				patientIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedPatient> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedPatient ->
							patient_toJs(x2)
						},
					)
				},
			)
		}

		override fun getPatient(groupId: String, entityId: String):
				Promise<GroupScopedJs<EncryptedPatientJs>?> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdConverted: String = entityId
			val result = patientBasicApi.inGroup.getPatient(
				groupIdConverted,
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: EncryptedPatient ->
							patient_toJs(x1)
						},
					)
				}
			)
		}

		override fun getPatientResolvingMerges(
			groupId: String,
			patientId: String,
			maxMergeDepth: Double?,
		): Promise<GroupScopedJs<EncryptedPatientJs>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val patientIdConverted: String = patientId
			val maxMergeDepthConverted: Int? = numberToInt(maxMergeDepth, "maxMergeDepth")
			val result = patientBasicApi.inGroup.getPatientResolvingMerges(
				groupIdConverted,
				patientIdConverted,
				maxMergeDepthConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedPatient ->
					patient_toJs(x1)
				},
			)
		}

		override fun getPatients(groupId: String, patientIds: Array<String>):
				Promise<Array<GroupScopedJs<EncryptedPatientJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val patientIdsConverted: List<String> = arrayToList(
				patientIds,
				"patientIds",
				{ x1: String ->
					x1
				},
			)
			val result = patientBasicApi.inGroup.getPatients(
				groupIdConverted,
				patientIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedPatient> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedPatient ->
							patient_toJs(x2)
						},
					)
				},
			)
		}

		override fun modifyPatients(patients: Array<GroupScopedJs<EncryptedPatientJs>>):
				Promise<Array<GroupScopedJs<EncryptedPatientJs>>> = GlobalScope.promise {
			val patientsConverted: List<GroupScoped<EncryptedPatient>> = arrayToList(
				patients,
				"patients",
				{ x1: GroupScopedJs<EncryptedPatientJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedPatientJs ->
							patient_fromJs(x2)
						},
					)
				},
			)
			val result = patientBasicApi.inGroup.modifyPatients(
				patientsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedPatient> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedPatient ->
							patient_toJs(x2)
						},
					)
				},
			)
		}
	}

	override fun matchPatientsBy(filter: BaseFilterOptionsJs<PatientJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Patient> = baseFilterOptions_fromJs(filter)
		val result = patientBasicApi.matchPatientsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchPatientsBySorted(filter: BaseSortableFilterOptionsJs<PatientJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Patient> = baseSortableFilterOptions_fromJs(filter)
		val result = patientBasicApi.matchPatientsBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun filterPatientsBy(filter: BaseFilterOptionsJs<PatientJs>):
			Promise<PaginatedListIteratorJs<EncryptedPatientJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Patient> = baseFilterOptions_fromJs(filter)
		val result = patientBasicApi.filterPatientsBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedPatient ->
				patient_toJs(x1)
			},
		)
	}

	override fun filterPatientsBySorted(filter: BaseSortableFilterOptionsJs<PatientJs>):
			Promise<PaginatedListIteratorJs<EncryptedPatientJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Patient> = baseSortableFilterOptions_fromJs(filter)
		val result = patientBasicApi.filterPatientsBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedPatient ->
				patient_toJs(x1)
			},
		)
	}

	override fun deletePatientById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs>
			= GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = patientBasicApi.deletePatientById(
			entityIdConverted,
			revConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deletePatientsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = patientBasicApi.deletePatientsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgePatientById(id: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		patientBasicApi.purgePatientById(
			idConverted,
			revConverted,
		)

	}

	override fun purgePatientsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = patientBasicApi.purgePatientsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun deletePatient(patient: PatientJs): Promise<StoredDocumentIdentifierJs> =
			GlobalScope.promise {
		val patientConverted: Patient = patient_fromJs(patient)
		val result = patientBasicApi.deletePatient(
			patientConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deletePatients(patients: Array<PatientJs>): Promise<Array<StoredDocumentIdentifierJs>>
			= GlobalScope.promise {
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val result = patientBasicApi.deletePatients(
			patientsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgePatient(patient: PatientJs): Promise<Unit> = GlobalScope.promise {
		val patientConverted: Patient = patient_fromJs(patient)
		patientBasicApi.purgePatient(
			patientConverted,
		)

	}

	override fun purgePatients(patients: Array<PatientJs>): Promise<Array<StoredDocumentIdentifierJs>>
			= GlobalScope.promise {
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val result = patientBasicApi.purgePatients(
			patientsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun getDataOwnersWithAccessTo(patient: PatientJs): Promise<EntityAccessInformationJs> =
			GlobalScope.promise {
		val patientConverted: Patient = patient_fromJs(patient)
		val result = patientBasicApi.getDataOwnersWithAccessTo(
			patientConverted,
		)
		entityAccessInformation_toJs(result)
	}

	override fun createPatient(patient: EncryptedPatientJs): Promise<EncryptedPatientJs> =
			GlobalScope.promise {
		val patientConverted: EncryptedPatient = patient_fromJs(patient)
		val result = patientBasicApi.createPatient(
			patientConverted,
		)
		patient_toJs(result)
	}

	override fun createPatients(patients: Array<EncryptedPatientJs>):
			Promise<Array<EncryptedPatientJs>> = GlobalScope.promise {
		val patientsConverted: List<EncryptedPatient> = arrayToList(
			patients,
			"patients",
			{ x1: EncryptedPatientJs ->
				patient_fromJs(x1)
			},
		)
		val result = patientBasicApi.createPatients(
			patientsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedPatient ->
				patient_toJs(x1)
			},
		)
	}

	override fun undeletePatient(patient: PatientJs): Promise<PatientJs> = GlobalScope.promise {
		val patientConverted: Patient = patient_fromJs(patient)
		val result = patientBasicApi.undeletePatient(
			patientConverted,
		)
		patient_toJs(result)
	}

	override fun undeletePatients(patients: Array<PatientJs>): Promise<Array<EncryptedPatientJs>> =
			GlobalScope.promise {
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val result = patientBasicApi.undeletePatients(
			patientsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedPatient ->
				patient_toJs(x1)
			},
		)
	}

	override fun modifyPatient(entity: EncryptedPatientJs): Promise<EncryptedPatientJs> =
			GlobalScope.promise {
		val entityConverted: EncryptedPatient = patient_fromJs(entity)
		val result = patientBasicApi.modifyPatient(
			entityConverted,
		)
		patient_toJs(result)
	}

	override fun undeletePatientById(id: String, rev: String): Promise<EncryptedPatientJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = patientBasicApi.undeletePatientById(
			idConverted,
			revConverted,
		)
		patient_toJs(result)
	}

	override fun undeletePatientsByIds(ids: Array<StoredDocumentIdentifierJs>):
			Promise<Array<EncryptedPatientJs>> = GlobalScope.promise {
		val idsConverted: List<StoredDocumentIdentifier> = arrayToList(
			ids,
			"ids",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = patientBasicApi.undeletePatientsByIds(
			idsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedPatient ->
				patient_toJs(x1)
			},
		)
	}

	override fun getPatient(entityId: String): Promise<EncryptedPatientJs?> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = patientBasicApi.getPatient(
			entityIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				patient_toJs(nonNull1)
			}
		)
	}

	override fun getPatientResolvingMerges(patientId: String, maxMergeDepth: Double?):
			Promise<EncryptedPatientJs> = GlobalScope.promise {
		val patientIdConverted: String = patientId
		val maxMergeDepthConverted: Int? = numberToInt(maxMergeDepth, "maxMergeDepth")
		val result = patientBasicApi.getPatientResolvingMerges(
			patientIdConverted,
			maxMergeDepthConverted,
		)
		patient_toJs(result)
	}

	override fun getPatients(patientIds: Array<String>): Promise<Array<EncryptedPatientJs>> =
			GlobalScope.promise {
		val patientIdsConverted: List<String> = arrayToList(
			patientIds,
			"patientIds",
			{ x1: String ->
				x1
			},
		)
		val result = patientBasicApi.getPatients(
			patientIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedPatient ->
				patient_toJs(x1)
			},
		)
	}

	override fun modifyPatients(patients: Array<EncryptedPatientJs>):
			Promise<Array<EncryptedPatientJs>> = GlobalScope.promise {
		val patientsConverted: List<EncryptedPatient> = arrayToList(
			patients,
			"patients",
			{ x1: EncryptedPatientJs ->
				patient_fromJs(x1)
			},
		)
		val result = patientBasicApi.modifyPatients(
			patientsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedPatient ->
				patient_toJs(x1)
			},
		)
	}

	override fun mergePatients(from: PatientJs, mergedInto: EncryptedPatientJs):
			Promise<EncryptedPatientJs> = GlobalScope.promise {
		val fromConverted: Patient = patient_fromJs(from)
		val mergedIntoConverted: EncryptedPatient = patient_fromJs(mergedInto)
		val result = patientBasicApi.mergePatients(
			fromConverted,
			mergedIntoConverted,
		)
		patient_toJs(result)
	}

	override fun subscribeToEvents(
		events: Array<String>,
		filter: BaseFilterOptionsJs<PatientJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedPatientJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val eventsConverted: Set<SubscriptionEventType> = arrayToSet(
				events,
				"events",
				{ x1: String ->
					SubscriptionEventType.valueOf(x1)
				},
			)
			val filterConverted: BaseFilterOptions<Patient> = baseFilterOptions_fromJs(filter)
			val subscriptionConfigConverted: EntitySubscriptionConfiguration? =
					convertingOptionOrDefaultNullable(
				_options,
				"subscriptionConfig",
				null
			) { subscriptionConfig: EntitySubscriptionConfigurationJs? ->
				subscriptionConfig?.let { nonNull1 ->
					entitySubscriptionConfiguration_fromJs(nonNull1)
				}
			}
			val result = patientBasicApi.subscribeToEvents(
				eventsConverted,
				filterConverted,
				subscriptionConfigConverted,
			)
			entitySubscription_toJs(
				result,
				{ x1: EncryptedPatient ->
					patient_toJs(x1)
				},
			)
		}
	}
}
