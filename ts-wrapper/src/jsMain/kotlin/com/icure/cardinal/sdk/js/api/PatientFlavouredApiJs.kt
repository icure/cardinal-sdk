// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.PatientShareOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("PatientFlavouredApi")
public external interface PatientFlavouredApiJs<E : PatientJs> {
	public fun shareWith(
		delegateId: String,
		patient: E,
		options: dynamic,
	): Promise<E>

	public fun shareWithMany(patient: E, delegates: Record<String, PatientShareOptionsJs>): Promise<E>

	public fun initializeConfidentialSecretId(patient: E): Promise<E>

	public fun filterPatientsBy(filter: FilterOptionsJs<PatientJs>):
			Promise<PaginatedListIteratorJs<E>>

	public fun filterPatientsBySorted(filter: SortableFilterOptionsJs<PatientJs>):
			Promise<PaginatedListIteratorJs<E>>

	public fun createPatient(patient: E): Promise<E>

	public fun createPatients(patients: Array<E>): Promise<Array<E>>

	public fun undeletePatient(patient: PatientJs): Promise<PatientJs>

	public fun undeletePatients(patients: Array<PatientJs>): Promise<Array<E>>

	public fun modifyPatient(entity: E): Promise<E>

	public fun undeletePatientById(id: String, rev: String): Promise<E>

	public fun undeletePatientsByIds(ids: Array<StoredDocumentIdentifierJs>): Promise<Array<E>>

	public fun getPatient(entityId: String): Promise<E?>

	public fun getPatientResolvingMerges(patientId: String, maxMergeDepth: Double?): Promise<E>

	public fun getPatients(patientIds: Array<String>): Promise<Array<E>>

	public fun modifyPatients(patients: Array<E>): Promise<Array<E>>

	public fun mergePatients(from: PatientJs, mergedInto: E): Promise<E>
}
