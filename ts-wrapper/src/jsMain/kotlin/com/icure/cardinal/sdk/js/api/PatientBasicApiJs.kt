// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.EntityAccessInformationJs
import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.EncryptedPatientJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("PatientBasicApi")
public external interface PatientBasicApiJs {
	public val inGroup: PatientBasicInGroupApiJs

	public fun matchPatientsBy(filter: BaseFilterOptionsJs<PatientJs>): Promise<Array<String>>

	public fun matchPatientsBySorted(filter: BaseSortableFilterOptionsJs<PatientJs>):
			Promise<Array<String>>

	public fun filterPatientsBy(filter: BaseFilterOptionsJs<PatientJs>):
			Promise<PaginatedListIteratorJs<EncryptedPatientJs>>

	public fun filterPatientsBySorted(filter: BaseSortableFilterOptionsJs<PatientJs>):
			Promise<PaginatedListIteratorJs<EncryptedPatientJs>>

	public fun deletePatientUnsafe(entityId: String): Promise<StoredDocumentIdentifierJs>

	public fun deletePatientsUnsafe(entityIds: Array<String>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun deletePatientById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs>

	public fun deletePatientsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgePatientById(id: String, rev: String): Promise<Unit>

	public fun deletePatient(patient: PatientJs): Promise<StoredDocumentIdentifierJs>

	public fun deletePatients(patients: Array<PatientJs>): Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgePatient(patient: PatientJs): Promise<Unit>

	public fun getDataOwnersWithAccessTo(patient: PatientJs): Promise<EntityAccessInformationJs>

	public fun countOfPatients(hcPartyId: String): Promise<Double>

	public fun createPatient(patient: EncryptedPatientJs): Promise<EncryptedPatientJs>

	public fun createPatientsMinimal(patients: Array<EncryptedPatientJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun createPatients(patients: Array<EncryptedPatientJs>): Promise<Array<EncryptedPatientJs>>

	public fun undeletePatient(patient: PatientJs): Promise<PatientJs>

	public fun modifyPatient(entity: EncryptedPatientJs): Promise<EncryptedPatientJs>

	public fun undeletePatientById(id: String, rev: String): Promise<EncryptedPatientJs>

	public fun undeletePatients(ids: Array<StoredDocumentIdentifierJs>):
			Promise<Array<EncryptedPatientJs>>

	public fun getPatient(entityId: String): Promise<EncryptedPatientJs?>

	public fun getPatientResolvingMerges(patientId: String, maxMergeDepth: Double?):
			Promise<EncryptedPatientJs>

	public fun findPatientsByNameBirthSsinAuto(filterValue: String, options: dynamic):
			Promise<PaginatedListJs<EncryptedPatientJs>>

	public fun listPatientsOfHcParty(hcPartyId: String, options: dynamic):
			Promise<PaginatedListJs<EncryptedPatientJs>>

	public fun listOfMergesAfter(date: Double): Promise<Array<EncryptedPatientJs>>

	public fun findPatientsModifiedAfter(date: Double, options: dynamic):
			Promise<PaginatedListJs<EncryptedPatientJs>>

	public fun listPatientsByHcParty(hcPartyId: String, options: dynamic):
			Promise<PaginatedListJs<EncryptedPatientJs>>

	public fun findPatientsByHealthcareParty(options: dynamic):
			Promise<PaginatedListJs<EncryptedPatientJs>>

	public fun findPatientsIdsByHealthcareParty(hcPartyId: String, options: dynamic):
			Promise<PaginatedListJs<String>>

	public fun getPatientByExternalId(externalId: String): Promise<EncryptedPatientJs>

	public fun fuzzySearch(
		firstName: String,
		lastName: String,
		options: dynamic,
	): Promise<Array<EncryptedPatientJs>>

	public fun findDeletedPatients(startDate: Double, options: dynamic):
			Promise<PaginatedListJs<EncryptedPatientJs>>

	public fun listDeletedPatientsByName(options: dynamic): Promise<Array<EncryptedPatientJs>>

	public fun getPatients(patientIds: Array<String>): Promise<Array<EncryptedPatientJs>>

	public fun getPatientByHealthcarePartyAndIdentifier(
		hcPartyId: String,
		id: String,
		options: dynamic,
	): Promise<EncryptedPatientJs>

	public fun modifyPatientsMinimal(patients: Array<EncryptedPatientJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun modifyPatients(patients: Array<EncryptedPatientJs>): Promise<Array<EncryptedPatientJs>>

	public fun findDuplicatesBySsin(hcPartyId: String, options: dynamic):
			Promise<PaginatedListJs<EncryptedPatientJs>>

	public fun findDuplicatesByName(hcPartyId: String, options: dynamic):
			Promise<PaginatedListJs<EncryptedPatientJs>>

	public fun mergePatients(from: PatientJs, mergedInto: EncryptedPatientJs):
			Promise<EncryptedPatientJs>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: BaseFilterOptionsJs<PatientJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedPatientJs>>
}
