// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.BooleanResponseJs
import com.icure.cardinal.sdk.js.model.CodeJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("CodeApi")
public external interface CodeApiJs {
	public val inGroup: CodeInGroupApiJs

	public fun createCode(code: CodeJs): Promise<CodeJs>

	public fun createCodes(codes: Array<CodeJs>): Promise<Array<CodeJs>>

	public fun getCode(codeId: String): Promise<CodeJs?>

	public fun getCodes(codeIds: Array<String>): Promise<Array<CodeJs>>

	public fun modifyCode(code: CodeJs): Promise<CodeJs>

	public fun modifyCodes(codes: Array<CodeJs>): Promise<Array<CodeJs>>

	public fun deleteCodeById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs>

	public fun deleteCodeByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun deleteCode(code: CodeJs): Promise<StoredDocumentIdentifierJs>

	public fun deleteCodes(codes: Array<CodeJs>): Promise<Array<StoredDocumentIdentifierJs>>

	public fun undeleteCodeById(entityId: String, rev: String): Promise<CodeJs>

	public fun undeleteCodeByIds(entityIds: Array<StoredDocumentIdentifierJs>): Promise<Array<CodeJs>>

	public fun undeleteCode(code: CodeJs): Promise<CodeJs>

	public fun undeleteCodes(codes: Array<CodeJs>): Promise<Array<CodeJs>>

	public fun purgeCodeById(entityId: String, rev: String): Promise<Unit>

	public fun purgeCodeByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeCode(code: CodeJs): Promise<Unit>

	public fun purgeCodes(codes: Array<CodeJs>): Promise<Array<StoredDocumentIdentifierJs>>

	public fun listCodeTypesBy(options: dynamic): Promise<Array<String>>

	public fun listTagTypesBy(options: dynamic): Promise<Array<String>>

	public fun isCodeValid(
		type: String,
		code: String,
		version: String?,
	): Promise<BooleanResponseJs>

	public fun getCodeByRegionLanguageTypeLabel(
		region: String,
		label: String,
		type: String,
		languages: String?,
	): Promise<CodeJs?>

	public fun getCodeWithParts(
		type: String,
		code: String,
		version: String,
	): Promise<CodeJs?>

	public fun filterCodesBy(filter: BaseFilterOptionsJs<CodeJs>):
			Promise<PaginatedListIteratorJs<CodeJs>>

	public fun filterCodesBySorted(filter: BaseSortableFilterOptionsJs<CodeJs>):
			Promise<PaginatedListIteratorJs<CodeJs>>

	public fun matchCodesBy(filter: BaseFilterOptionsJs<CodeJs>): Promise<Array<String>>

	public fun matchCodesBySorted(filter: BaseSortableFilterOptionsJs<CodeJs>): Promise<Array<String>>
}
