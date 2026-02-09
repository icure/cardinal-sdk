// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.CodeJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("CodeInGroupApi")
public external interface CodeInGroupApiJs {
	public fun createCode(code: GroupScopedJs<CodeJs>): Promise<GroupScopedJs<CodeJs>>

	public fun createCodes(codes: Array<GroupScopedJs<CodeJs>>): Promise<Array<GroupScopedJs<CodeJs>>>

	public fun getCode(groupId: String, codeId: String): Promise<GroupScopedJs<CodeJs>?>

	public fun getCodes(groupId: String, codesIds: Array<String>):
			Promise<Array<GroupScopedJs<CodeJs>>>

	public fun modifyCode(code: GroupScopedJs<CodeJs>): Promise<GroupScopedJs<CodeJs>>

	public fun modifyCodes(codes: Array<GroupScopedJs<CodeJs>>): Promise<Array<GroupScopedJs<CodeJs>>>

	public fun deleteCodeById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteCodeByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun deleteCode(code: GroupScopedJs<CodeJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteCodes(codes: Array<GroupScopedJs<CodeJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun undeleteCodeById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<CodeJs>>

	public fun undeleteCodeByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<CodeJs>>>

	public fun undeleteCode(code: GroupScopedJs<CodeJs>): Promise<GroupScopedJs<CodeJs>>

	public fun undeleteCodes(codes: Array<GroupScopedJs<CodeJs>>):
			Promise<Array<GroupScopedJs<CodeJs>>>

	public fun purgeCodeById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit>

	public fun purgeCodeByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeCode(code: GroupScopedJs<CodeJs>): Promise<Unit>

	public fun purgeCodes(codes: Array<GroupScopedJs<CodeJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun filterCodesBy(groupId: String, filter: BaseFilterOptionsJs<CodeJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<CodeJs>>>

	public fun filterCodesBySorted(groupId: String, filter: BaseSortableFilterOptionsJs<CodeJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<CodeJs>>>

	public fun matchCodesBy(groupId: String, filter: BaseFilterOptionsJs<CodeJs>):
			Promise<Array<String>>

	public fun matchCodesBySorted(groupId: String, filter: BaseSortableFilterOptionsJs<CodeJs>):
			Promise<Array<String>>
}
