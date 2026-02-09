// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.InsuranceJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("InsuranceInGroupApi")
public external interface InsuranceInGroupApiJs {
	public fun createInsurance(insurance: GroupScopedJs<InsuranceJs>):
			Promise<GroupScopedJs<InsuranceJs>>

	public fun createInsurances(insurances: Array<GroupScopedJs<InsuranceJs>>):
			Promise<Array<GroupScopedJs<InsuranceJs>>>

	public fun getInsurance(groupId: String, insuranceId: String): Promise<GroupScopedJs<InsuranceJs>?>

	public fun getInsurances(groupId: String, insurancesIds: Array<String>):
			Promise<Array<GroupScopedJs<InsuranceJs>>>

	public fun modifyInsurance(insurance: GroupScopedJs<InsuranceJs>):
			Promise<GroupScopedJs<InsuranceJs>>

	public fun modifyInsurances(insurances: Array<GroupScopedJs<InsuranceJs>>):
			Promise<Array<GroupScopedJs<InsuranceJs>>>

	public fun deleteInsuranceById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteInsuranceByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun deleteInsurance(insurance: GroupScopedJs<InsuranceJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteInsurances(insurances: Array<GroupScopedJs<InsuranceJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun undeleteInsuranceById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<InsuranceJs>>

	public fun undeleteInsuranceByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<InsuranceJs>>>

	public fun undeleteInsurance(insurance: GroupScopedJs<InsuranceJs>):
			Promise<GroupScopedJs<InsuranceJs>>

	public fun undeleteInsurances(insurances: Array<GroupScopedJs<InsuranceJs>>):
			Promise<Array<GroupScopedJs<InsuranceJs>>>

	public fun purgeInsuranceById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit>

	public fun purgeInsuranceByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeInsurance(insurance: GroupScopedJs<InsuranceJs>): Promise<Unit>

	public fun purgeInsurances(insurances: Array<GroupScopedJs<InsuranceJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>
}
