// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.model.DataOwnerRegistrationSuccessJs
import com.icure.cardinal.sdk.js.model.HealthcarePartyJs
import com.icure.cardinal.sdk.js.model.PublicKeyJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
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
	public val inGroup: HealthcarePartyInGroupApiJs

	public fun getHealthcareParty(healthcarePartyId: String): Promise<HealthcarePartyJs?>

	public fun getHealthcareParties(healthcarePartyIds: Array<String>):
			Promise<Array<HealthcarePartyJs>>

	public fun createHealthcareParty(healthcareParty: HealthcarePartyJs): Promise<HealthcarePartyJs>

	public fun createHealthcareParties(healthcareParties: Array<HealthcarePartyJs>):
			Promise<Array<HealthcarePartyJs>>

	public fun modifyHealthcareParty(healthcareParty: HealthcarePartyJs): Promise<HealthcarePartyJs>

	public fun modifyHealthcareParties(healthcareParties: Array<HealthcarePartyJs>):
			Promise<Array<HealthcarePartyJs>>

	public fun getCurrentHealthcareParty(): Promise<HealthcarePartyJs>

	public fun getPublicKey(healthcarePartyId: String): Promise<PublicKeyJs>

	public fun matchHealthcarePartiesBy(filter: BaseFilterOptionsJs<HealthcarePartyJs>):
			Promise<Array<String>>

	public fun filterHealthPartiesBy(filter: BaseFilterOptionsJs<HealthcarePartyJs>):
			Promise<PaginatedListIteratorJs<HealthcarePartyJs>>

	public fun matchHealthcarePartiesBySorted(filter: BaseSortableFilterOptionsJs<HealthcarePartyJs>):
			Promise<Array<String>>

	public fun filterHealthPartiesBySorted(filter: BaseSortableFilterOptionsJs<HealthcarePartyJs>):
			Promise<PaginatedListIteratorJs<HealthcarePartyJs>>

	public fun registerPatient(
		groupId: String,
		hcp: HealthcarePartyJs,
		options: dynamic,
	): Promise<DataOwnerRegistrationSuccessJs>

	public fun deleteHealthcarePartyById(entityId: String, rev: String):
			Promise<StoredDocumentIdentifierJs>

	public fun deleteHealthcarePartiesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeHealthcarePartyById(id: String, rev: String): Promise<Unit>

	public fun purgeHealthcarePartiesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun undeleteHealthcarePartyById(id: String, rev: String): Promise<HealthcarePartyJs>

	public fun undeleteHealthcarePartiesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<HealthcarePartyJs>>

	public fun deleteHealthcareParty(healthcareParty: HealthcarePartyJs):
			Promise<StoredDocumentIdentifierJs>

	public fun deleteHealthcareParties(healthcareParties: Array<HealthcarePartyJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeHealthcareParty(healthcareParty: HealthcarePartyJs): Promise<Unit>

	public fun purgeHealthcareParties(healthcareParties: Array<HealthcarePartyJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun undeleteHealthcareParty(healthcareParty: HealthcarePartyJs): Promise<HealthcarePartyJs>

	public fun undeleteHealthcareParties(healthcareParties: Array<HealthcarePartyJs>):
			Promise<Array<HealthcarePartyJs>>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<HealthcarePartyJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<HealthcarePartyJs>>
}
