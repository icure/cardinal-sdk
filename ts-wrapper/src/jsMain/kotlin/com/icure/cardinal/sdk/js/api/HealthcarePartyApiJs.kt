// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.model.DataOwnerRegistrationSuccessJs
import com.icure.cardinal.sdk.js.model.HealthcarePartyJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.PublicKeyJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("HealthcarePartyApi")
public external interface HealthcarePartyApiJs {
	public val inGroup: HealthcarePartyApiInGroupJs

	public fun deleteHealthcarePartyUnsafe(entityId: String): Promise<DocIdentifierJs>

	public fun deleteHealthcarePartiesUnsafe(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun getHealthcareParty(healthcarePartyId: String): Promise<HealthcarePartyJs?>

	public fun createHealthcareParty(p: HealthcarePartyJs): Promise<HealthcarePartyJs>

	public fun modifyHealthcarePartyInGroup(groupId: String, healthcareParty: HealthcarePartyJs):
			Promise<HealthcarePartyJs>

	public fun createHealthcarePartyInGroup(groupId: String, healthcareParty: HealthcarePartyJs):
			Promise<HealthcarePartyJs>

	public fun getCurrentHealthcareParty(): Promise<HealthcarePartyJs>

	public fun findHealthcarePartiesBy(options: dynamic): Promise<PaginatedListJs<HealthcarePartyJs>>

	public fun findHealthcarePartiesByName(options: dynamic):
			Promise<PaginatedListJs<HealthcarePartyJs>>

	public fun findHealthcarePartiesBySsinOrNihii(searchValue: String, options: dynamic):
			Promise<PaginatedListJs<HealthcarePartyJs>>

	public fun listHealthcarePartiesByName(name: String): Promise<Array<HealthcarePartyJs>>

	public fun findHealthcarePartiesBySpecialityAndPostCode(
		type: String,
		spec: String,
		firstCode: String,
		lastCode: String,
		options: dynamic,
	): Promise<PaginatedListJs<HealthcarePartyJs>>

	public fun getHealthcareParties(healthcarePartyIds: Array<String>):
			Promise<Array<HealthcarePartyJs>>

	public fun listHealthcarePartiesByParentId(parentId: String): Promise<Array<HealthcarePartyJs>>

	public fun getPublicKey(healthcarePartyId: String): Promise<PublicKeyJs>

	public fun modifyHealthcareParty(healthcareParty: HealthcarePartyJs): Promise<HealthcarePartyJs>

	public fun matchHealthcarePartiesBy(filter: BaseFilterOptionsJs<HealthcarePartyJs>):
			Promise<Array<String>>

	public fun filterHealthPartiesBy(filter: BaseFilterOptionsJs<HealthcarePartyJs>):
			Promise<PaginatedListIteratorJs<HealthcarePartyJs>>

	public fun matchHealthcarePartiesBySorted(filter: BaseSortableFilterOptionsJs<HealthcarePartyJs>):
			Promise<Array<String>>

	public fun filterHealthPartiesBySorted(filter: BaseSortableFilterOptionsJs<HealthcarePartyJs>):
			Promise<PaginatedListIteratorJs<HealthcarePartyJs>>

	public fun getHealthcarePartiesInGroup(groupId: String, options: dynamic):
			Promise<Array<HealthcarePartyJs>>

	public fun registerPatient(
		groupId: String,
		hcp: HealthcarePartyJs,
		options: dynamic,
	): Promise<DataOwnerRegistrationSuccessJs>

	public fun deleteHealthcarePartyById(entityId: String, rev: String): Promise<DocIdentifierJs>

	public fun deleteHealthcarePartiesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DocIdentifierJs>>

	public fun deleteHealthcarePartyInGroupById(
		groupId: String,
		entityId: String,
		rev: String,
	): Promise<DocIdentifierJs>

	public fun deleteHealthcarePartiesInGroupByIds(groupId: String,
			entityIds: Array<StoredDocumentIdentifierJs>): Promise<Array<DocIdentifierJs>>

	public fun purgeHealthcarePartyById(id: String, rev: String): Promise<Unit>

	public fun undeleteHealthcarePartyById(id: String, rev: String): Promise<HealthcarePartyJs>

	public fun deleteHealthcareParty(healthcareParty: HealthcarePartyJs): Promise<DocIdentifierJs>

	public fun deleteHealthcareParties(healthcareParties: Array<HealthcarePartyJs>):
			Promise<Array<DocIdentifierJs>>

	public fun purgeHealthcareParty(healthcareParty: HealthcarePartyJs): Promise<Unit>

	public fun undeleteHealthcareParty(healthcareParty: HealthcarePartyJs): Promise<HealthcarePartyJs>

	public fun deleteHealthcarePartyInGroup(groupId: String, hcp: HealthcarePartyJs):
			Promise<DocIdentifierJs>

	public fun deleteHealthcarePartiesInGroup(groupId: String,
			healthcareParties: Array<HealthcarePartyJs>): Promise<Array<DocIdentifierJs>>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<HealthcarePartyJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<HealthcarePartyJs>>
}
