// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToPatientShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("PatientFlavouredInGroupApi")
public external interface PatientFlavouredInGroupApiJs<E : PatientJs> {
	public fun shareWith(
		`delegate`: EntityReferenceInGroupJs,
		patient: GroupScopedJs<E>,
		options: dynamic,
	): Promise<GroupScopedJs<E>>

	public fun shareWithMany(patient: GroupScopedJs<E>,
			delegates: Array<EntityReferenceInGroupToPatientShareOptionsMapObject_delegate_shareOptions>):
			Promise<GroupScopedJs<E>>

	public fun initializeConfidentialSecretId(patient: GroupScopedJs<E>): Promise<GroupScopedJs<E>>

	public fun filterPatientsBy(groupId: String, filter: FilterOptionsJs<PatientJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<E>>>

	public fun filterPatientsBySorted(groupId: String, filter: SortableFilterOptionsJs<PatientJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<E>>>

	public fun createPatient(patient: GroupScopedJs<E>): Promise<GroupScopedJs<E>>

	public fun createPatients(patients: Array<GroupScopedJs<E>>): Promise<Array<GroupScopedJs<E>>>

	public fun undeletePatient(patient: GroupScopedJs<PatientJs>): Promise<GroupScopedJs<E>>

	public fun undeletePatients(patients: Array<GroupScopedJs<PatientJs>>):
			Promise<Array<GroupScopedJs<E>>>

	public fun modifyPatient(entity: GroupScopedJs<E>): Promise<GroupScopedJs<E>>

	public fun undeletePatientById(patientId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<E>>

	public fun undeletePatientsByIds(patientIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<E>>>

	public fun getPatient(groupId: String, entityId: String): Promise<GroupScopedJs<E>?>

	public fun getPatientResolvingMerges(
		groupId: String,
		patientId: String,
		maxMergeDepth: Double?,
	): Promise<GroupScopedJs<E>>

	public fun getPatients(groupId: String, patientIds: Array<String>):
			Promise<Array<GroupScopedJs<E>>>

	public fun modifyPatients(patients: Array<GroupScopedJs<E>>): Promise<Array<GroupScopedJs<E>>>
}
