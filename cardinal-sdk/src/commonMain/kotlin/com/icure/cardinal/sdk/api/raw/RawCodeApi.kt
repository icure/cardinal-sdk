package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.BooleanResponse
import com.icure.cardinal.sdk.model.Code
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.chain.FilterChain
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawCodeApi {
	// region common endpoints

	suspend fun findCodesByLabel(
		region: String?,
		types: String,
		language: String,
		label: String,
		version: String? = null,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<Code>>

	suspend fun findCodesByType(
		region: String,
		type: String? = null,
		code: String? = null,
		version: String? = null,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<Code>>

	suspend fun findCodesByLink(
		linkType: String,
		linkedId: String? = null,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<Code>>

	suspend fun listCodesByRegionTypeCodeVersion(
		region: String,
		type: String? = null,
		code: String? = null,
		version: String? = null,
	): HttpResponse<List<Code>>

	suspend fun listCodeTypesBy(
		region: String? = null,
		type: String? = null,
	): HttpResponse<List<String>>

	suspend fun listTagTypesBy(
		region: String? = null,
		type: String? = null,
	): HttpResponse<List<String>>

	suspend fun createCode(c: Code): HttpResponse<Code>

	suspend fun createCodes(codeBatch: List<Code>): HttpResponse<List<Code>>

	suspend fun isCodeValid(
		type: String,
		code: String,
		version: String?,
	): HttpResponse<BooleanResponse>

	suspend fun getCodeByRegionLanguageTypeLabelOr404(
		region: String,
		label: String,
		type: String,
		languages: String?,
	): HttpResponse<Code>

	suspend fun getCodes(codeIds: ListOfIds): HttpResponse<List<Code>>

	suspend fun getCode(codeId: String): HttpResponse<Code>

	suspend fun getCodeWithParts(
		type: String,
		code: String,
		version: String,
	): HttpResponse<Code>

	suspend fun modifyCode(codeDto: Code): HttpResponse<Code>

	suspend fun modifyCodes(codeBatch: List<Code>): HttpResponse<List<Code>>

	suspend fun filterCodesBy(
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		skip: Int? = null,
		sort: String? = null,
		desc: Boolean? = null,
		filterChain: FilterChain<Code>,
	): HttpResponse<PaginatedList<Code>>

	suspend fun matchCodesBy(filter: AbstractFilter<Code>): HttpResponse<List<String>>

	suspend fun importCodes(codeType: String): HttpResponse<Unit>

	suspend fun deleteCode(
		codeId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun deleteCodes(codeIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun undeleteCode(
		codeId: String,
		rev: String,
	): HttpResponse<Code>

	suspend fun undeleteCodes(codeIds: ListOfIdsAndRev): HttpResponse<List<Code>>

	suspend fun purgeCode(
		codeId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun purgeCodes(codeIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>
	// endregion

	// region cloud endpoints

	suspend fun createCodeInGroup(
		groupId: String,
		c: Code,
	): HttpResponse<Code>

	suspend fun createCodesInGroup(
		groupId: String,
		codeBatch: List<Code>,
	): HttpResponse<List<Code>>

	suspend fun getCodeInGroup(
		groupId: String,
		codeId: String,
	): HttpResponse<Code>

	suspend fun getCodesInGroup(
		groupId: String,
		codeIds: ListOfIds,
	): HttpResponse<List<Code>>

	suspend fun modifyCodeInGroup(
		groupId: String,
		code: Code,
	): HttpResponse<Code>

	suspend fun modifyCodesInGroup(
		groupId: String,
		codeBatch: List<Code>,
	): HttpResponse<List<Code>>

	suspend fun matchCodesBy(
		groupId: String,
		filter: AbstractFilter<Code>,
	): HttpResponse<List<String>>

	suspend fun deleteCodeInGroup(
		groupId: String,
		codeId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun deleteCodesInGroup(
		groupId: String,
		codeIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun undeleteCodeInGroup(
		groupId: String,
		codeId: String,
		rev: String,
	): HttpResponse<Code>

	suspend fun undeleteCodesInGroup(
		groupId: String,
		codeIds: ListOfIdsAndRev,
	): HttpResponse<List<Code>>

	suspend fun purgeCodeInGroup(
		groupId: String,
		codeId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun purgeCodesInGroup(
		groupId: String,
		codeIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>
	// endregion
}
