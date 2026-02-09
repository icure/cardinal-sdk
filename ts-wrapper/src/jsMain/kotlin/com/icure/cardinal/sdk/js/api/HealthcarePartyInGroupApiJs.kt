// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.HealthcarePartyJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("HealthcarePartyInGroupApi")
public external interface HealthcarePartyInGroupApiJs {
	public fun createHealthcareParty(healthcareParty: GroupScopedJs<HealthcarePartyJs>):
			Promise<GroupScopedJs<HealthcarePartyJs>>

	public fun createHealthcareParties(healthcareParties: Array<GroupScopedJs<HealthcarePartyJs>>):
			Promise<Array<GroupScopedJs<HealthcarePartyJs>>>

	public fun getHealthcareParty(groupId: String, healthcarePartyId: String):
			Promise<GroupScopedJs<HealthcarePartyJs>?>

	public fun getHealthcareParties(groupId: String, healthcarePartiesIds: Array<String>):
			Promise<Array<GroupScopedJs<HealthcarePartyJs>>>

	public fun modifyHealthcareParty(healthcareParty: GroupScopedJs<HealthcarePartyJs>):
			Promise<GroupScopedJs<HealthcarePartyJs>>

	public fun modifyHealthcareParties(healthcareParties: Array<GroupScopedJs<HealthcarePartyJs>>):
			Promise<Array<GroupScopedJs<HealthcarePartyJs>>>

	public fun deleteHealthcarePartyById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteHealthcarePartyByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun deleteHealthcareParty(healthcareParty: GroupScopedJs<HealthcarePartyJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteHealthcareParties(healthcareParties: Array<GroupScopedJs<HealthcarePartyJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun undeleteHealthcarePartyById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<HealthcarePartyJs>>

	public
			fun undeleteHealthcarePartyByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<HealthcarePartyJs>>>

	public fun undeleteHealthcareParty(healthcareParty: GroupScopedJs<HealthcarePartyJs>):
			Promise<GroupScopedJs<HealthcarePartyJs>>

	public fun undeleteHealthcareParties(healthcareParties: Array<GroupScopedJs<HealthcarePartyJs>>):
			Promise<Array<GroupScopedJs<HealthcarePartyJs>>>

	public fun purgeHealthcarePartyById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<Unit>

	public fun purgeHealthcarePartyByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeHealthcareParty(healthcareParty: GroupScopedJs<HealthcarePartyJs>): Promise<Unit>

	public fun purgeHealthcareParties(healthcareParties: Array<GroupScopedJs<HealthcarePartyJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun matchHealthcarePartiesBy(groupId: String,
			filter: BaseFilterOptionsJs<HealthcarePartyJs>): Promise<Array<String>>

	public fun matchHealthcarePartiesBySorted(groupId: String,
			filter: BaseSortableFilterOptionsJs<HealthcarePartyJs>): Promise<Array<String>>

	public fun filterHealthPartiesBy(groupId: String, filter: BaseFilterOptionsJs<HealthcarePartyJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<HealthcarePartyJs>>>

	public fun filterHealthPartiesBySorted(groupId: String,
			filter: BaseSortableFilterOptionsJs<HealthcarePartyJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<HealthcarePartyJs>>>
}
