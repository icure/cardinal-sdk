package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.BooleanResponse
import com.icure.cardinal.sdk.model.Code
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator

interface CodeApi {

	val inGroup: CodeInGroupApi

	suspend fun createCode(code: Code): Code
	suspend fun createCodes(codes: List<Code>): List<Code>

	suspend fun getCode(codeId: String): Code?
	suspend fun getCodes(codeIds: List<String>): List<Code>

	suspend fun modifyCode(code: Code): Code
	suspend fun modifyCodes(codes: List<Code>): List<Code>

	suspend fun deleteCodeById(entityId: String, rev: String): StoredDocumentIdentifier
	suspend fun deleteCodeByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier>

	suspend fun deleteCode(code: Code): StoredDocumentIdentifier =
		deleteCodeById(entityId = code.id, rev = requireNotNull(code.rev) { "Can't delete a code that has no rev" })
	suspend fun deleteCodes(codes: List<Code>): List<StoredDocumentIdentifier> =
		deleteCodeByIds(codes.map { it.toStoredDocumentIdentifier() })

	suspend fun undeleteCodeById(entityId: String, rev: String): Code
	suspend fun undeleteCodeByIds(entityIds: List<StoredDocumentIdentifier>): List<Code>

	suspend fun undeleteCode(code: Code): Code =
		undeleteCodeById(entityId = code.id, rev = requireNotNull(code.rev) { "Can't undelete a code that has no rev" })
	suspend fun undeleteCodes(codes: List<Code>): List<Code> =
		undeleteCodeByIds(codes.map { it.toStoredDocumentIdentifier() })

	suspend fun purgeCodeById(entityId: String, rev: String)
	suspend fun purgeCodeByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier>

	suspend fun purgeCode(code: Code) {
		purgeCodeById(entityId = code.id, rev = requireNotNull(code.rev) { "Can't purge a code that has no rev" })
	}
	suspend fun purgeCodes(codes: List<Code>): List<StoredDocumentIdentifier> =
		purgeCodeByIds(codes.map { it.toStoredDocumentIdentifier() })

	suspend fun listCodeTypesBy(
		@DefaultValue("null")
		region: String? = null,
		@DefaultValue("null")
		type: String? = null
	): List<String>

	suspend fun listTagTypesBy(
		@DefaultValue("null")
		region: String? = null,
		@DefaultValue("null")
		type: String? = null
	): List<String>

	suspend fun isCodeValid(
		type: String,
		code: String,
		version: String?,
	): BooleanResponse

	suspend fun getCodeByRegionLanguageTypeLabel(
		region: String,
		label: String,
		type: String,
		languages: String?,
	): Code?

	suspend fun getCodeWithParts(
		type: String,
		code: String,
		version: String,
	): Code?

	suspend fun filterCodesBy(
		filter: BaseFilterOptions<Code>
	): PaginatedListIterator<Code>

	suspend fun filterCodesBySorted(
		filter: BaseSortableFilterOptions<Code>
	): PaginatedListIterator<Code>

	suspend fun matchCodesBy(filter: BaseFilterOptions<Code>): List<String>
	suspend fun matchCodesBySorted(filter: BaseSortableFilterOptions<Code>): List<String>

}

interface CodeInGroupApi {

	suspend fun createCode(code: GroupScoped<Code>): GroupScoped<Code>
	suspend fun createCodes(codes: List<GroupScoped<Code>>): List<GroupScoped<Code>>

	suspend fun getCode(groupId: String, codeId: String): GroupScoped<Code>?
	suspend fun getCodes(groupId: String, codesIds: List<String>): List<GroupScoped<Code>>

	suspend fun modifyCode(code: GroupScoped<Code>): GroupScoped<Code>
	suspend fun modifyCodes(codes: List<GroupScoped<Code>>): List<GroupScoped<Code>>

	suspend fun deleteCodeById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier>
	suspend fun deleteCodeByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>>

	suspend fun deleteCode(code: GroupScoped<Code>): GroupScoped<StoredDocumentIdentifier> =
		deleteCodeById(code.toStoredDocumentIdentifier())
	suspend fun deleteCodes(codes: List<GroupScoped<Code>>): List<GroupScoped<StoredDocumentIdentifier>> =
		deleteCodeByIds(codes.map { it.toStoredDocumentIdentifier() })

	suspend fun undeleteCodeById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<Code>
	suspend fun undeleteCodeByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<Code>>

	suspend fun undeleteCode(code: GroupScoped<Code>): GroupScoped<Code> =
		undeleteCodeById(code.toStoredDocumentIdentifier())
	suspend fun undeleteCodes(codes: List<GroupScoped<Code>>): List<GroupScoped<Code>> =
		undeleteCodeByIds(codes.map { it.toStoredDocumentIdentifier() })

	suspend fun purgeCodeById(entityId: GroupScoped<StoredDocumentIdentifier>)
	suspend fun purgeCodeByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>>

	suspend fun purgeCode(code: GroupScoped<Code>) {
		purgeCodeById(code.toStoredDocumentIdentifier())
	}
	suspend fun purgeCodes(codes: List<GroupScoped<Code>>): List<GroupScoped<StoredDocumentIdentifier>> =
		purgeCodeByIds(codes.map { it.toStoredDocumentIdentifier() })

	suspend fun filterCodesBy(
		groupId: String,
		filter: BaseFilterOptions<Code>
	): PaginatedListIterator<GroupScoped<Code>>

	suspend fun filterCodesBySorted(
		groupId: String,
		filter: BaseSortableFilterOptions<Code>
	): PaginatedListIterator<GroupScoped<Code>>

	suspend fun matchCodesBy(groupId: String, filter: BaseFilterOptions<Code>): List<String>
	suspend fun matchCodesBySorted(groupId: String, filter: BaseSortableFilterOptions<Code>): List<String>
}

