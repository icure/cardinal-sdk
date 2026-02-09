// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.EntityAccessInformationJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.DecryptedPatientJs
import com.icure.cardinal.sdk.js.model.EncryptedPatientJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToPatientShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("PatientInGroupApi")
public external interface PatientInGroupApiJs {
	public val encrypted: PatientFlavouredInGroupApiJs<EncryptedPatientJs>

	public val tryAndRecover: PatientFlavouredInGroupApiJs<PatientJs>

	public fun decrypt(patients: Array<GroupScopedJs<EncryptedPatientJs>>):
			Promise<Array<GroupScopedJs<DecryptedPatientJs>>>

	public fun tryDecrypt(patients: Array<GroupScopedJs<EncryptedPatientJs>>):
			Promise<Array<GroupScopedJs<PatientJs>>>

	public fun encryptOrValidate(patients: Array<GroupScopedJs<PatientJs>>):
			Promise<Array<GroupScopedJs<EncryptedPatientJs>>>

	public fun getSecretIdsOf(patient: GroupScopedJs<PatientJs>):
			Promise<Record<String, Array<EntityReferenceInGroupJs>>>

	public fun getEncryptionKeysOf(patient: GroupScopedJs<PatientJs>): Promise<Array<String>>

	public fun withEncryptionMetadata(
		entityGroupId: String,
		base: DecryptedPatientJs?,
		options: dynamic,
	): Promise<GroupScopedJs<DecryptedPatientJs>>

	public fun hasWriteAccess(patient: GroupScopedJs<DecryptedPatientJs>): Promise<Boolean>

	public fun createDelegationDeAnonymizationMetadata(entity: GroupScopedJs<DecryptedPatientJs>,
			delegates: Array<EntityReferenceInGroupJs>): Promise<Unit>

	public fun matchPatientsBy(groupId: String, filter: FilterOptionsJs<PatientJs>):
			Promise<Array<String>>

	public fun matchPatientsBySorted(groupId: String, filter: SortableFilterOptionsJs<PatientJs>):
			Promise<Array<String>>

	public fun deletePatientById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deletePatientsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgePatientById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit>

	public fun purgePatientsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun deletePatient(patient: GroupScopedJs<PatientJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deletePatients(patients: Array<GroupScopedJs<PatientJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgePatient(patient: GroupScopedJs<PatientJs>): Promise<Unit>

	public fun getDataOwnersWithAccessTo(patient: GroupScopedJs<PatientJs>):
			Promise<EntityAccessInformationJs>

	public fun shareWith(
		`delegate`: EntityReferenceInGroupJs,
		patient: GroupScopedJs<DecryptedPatientJs>,
		options: dynamic,
	): Promise<GroupScopedJs<DecryptedPatientJs>>

	public fun shareWithMany(patient: GroupScopedJs<DecryptedPatientJs>,
			delegates: Array<EntityReferenceInGroupToPatientShareOptionsMapObject_delegate_shareOptions>):
			Promise<GroupScopedJs<DecryptedPatientJs>>

	public fun initializeConfidentialSecretId(patient: GroupScopedJs<DecryptedPatientJs>):
			Promise<GroupScopedJs<DecryptedPatientJs>>

	public fun filterPatientsBy(groupId: String, filter: FilterOptionsJs<PatientJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedPatientJs>>>

	public fun filterPatientsBySorted(groupId: String, filter: SortableFilterOptionsJs<PatientJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedPatientJs>>>

	public fun createPatient(patient: GroupScopedJs<DecryptedPatientJs>):
			Promise<GroupScopedJs<DecryptedPatientJs>>

	public fun createPatients(patients: Array<GroupScopedJs<DecryptedPatientJs>>):
			Promise<Array<GroupScopedJs<DecryptedPatientJs>>>

	public fun undeletePatient(patient: GroupScopedJs<PatientJs>):
			Promise<GroupScopedJs<DecryptedPatientJs>>

	public fun undeletePatients(patients: Array<GroupScopedJs<PatientJs>>):
			Promise<Array<GroupScopedJs<DecryptedPatientJs>>>

	public fun modifyPatient(entity: GroupScopedJs<DecryptedPatientJs>):
			Promise<GroupScopedJs<DecryptedPatientJs>>

	public fun undeletePatientById(patientId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<DecryptedPatientJs>>

	public fun undeletePatientsByIds(patientIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<DecryptedPatientJs>>>

	public fun getPatient(groupId: String, entityId: String):
			Promise<GroupScopedJs<DecryptedPatientJs>?>

	public fun getPatientResolvingMerges(
		groupId: String,
		patientId: String,
		maxMergeDepth: Double?,
	): Promise<GroupScopedJs<DecryptedPatientJs>>

	public fun getPatients(groupId: String, patientIds: Array<String>):
			Promise<Array<GroupScopedJs<DecryptedPatientJs>>>

	public fun modifyPatients(patients: Array<GroupScopedJs<DecryptedPatientJs>>):
			Promise<Array<GroupScopedJs<DecryptedPatientJs>>>
}
