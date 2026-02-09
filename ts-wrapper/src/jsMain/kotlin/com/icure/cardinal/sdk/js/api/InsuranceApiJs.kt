// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.InsuranceJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("InsuranceApi")
public external interface InsuranceApiJs {
	public val inGroup: InsuranceInGroupApiJs

	public fun createInsurance(insurance: InsuranceJs): Promise<InsuranceJs>

	public fun createInsurances(insurances: Array<InsuranceJs>): Promise<Array<InsuranceJs>>

	public fun getInsurance(insuranceId: String): Promise<InsuranceJs?>

	public fun getInsurances(insurancesIds: Array<String>): Promise<Array<InsuranceJs>>

	public fun modifyInsurance(insurance: InsuranceJs): Promise<InsuranceJs>

	public fun modifyInsurances(insurances: Array<InsuranceJs>): Promise<Array<InsuranceJs>>

	public fun deleteInsuranceById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs>

	public fun deleteInsuranceByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun deleteInsurance(insurance: InsuranceJs): Promise<StoredDocumentIdentifierJs>

	public fun deleteInsurances(insurances: Array<InsuranceJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun undeleteInsuranceById(entityId: String, rev: String): Promise<InsuranceJs>

	public fun undeleteInsuranceByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<InsuranceJs>>

	public fun undeleteInsurance(insurance: InsuranceJs): Promise<InsuranceJs>

	public fun undeleteInsurances(insurances: Array<InsuranceJs>): Promise<Array<InsuranceJs>>

	public fun purgeInsuranceById(entityId: String, rev: String): Promise<Unit>

	public fun purgeInsuranceByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeInsurance(insurance: InsuranceJs): Promise<Unit>

	public fun purgeInsurances(insurances: Array<InsuranceJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun listInsurancesByCode(insuranceCode: String): Promise<Array<InsuranceJs>>

	public fun listInsurancesByName(insuranceName: String): Promise<Array<InsuranceJs>>
}
