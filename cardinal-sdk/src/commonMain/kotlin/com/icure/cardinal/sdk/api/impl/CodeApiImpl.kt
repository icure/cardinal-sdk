package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.CodeApi
import com.icure.cardinal.sdk.api.raw.RawCodeApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.mapCodeFilterOptions
import com.icure.cardinal.sdk.model.BooleanResponse
import com.icure.cardinal.sdk.model.Code
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.cardinal.sdk.utils.pagination.encodeStartKey
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.JsonElement

@InternalIcureApi
internal class CodeApiImpl(
	private val rawApi: RawCodeApi,
) : CodeApi {
	@Deprecated("Find methods with are deprecated", replaceWith = ReplaceWith("filterCodesBy(filter)"))
	override suspend fun findCodesByLabel(
		region: String?,
		types: String,
		language: String,
		label: String,
		version: String?,
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<Code> = rawApi.findCodesByLabel(region, types, language, label, version, startKey.encodeStartKey(), startDocumentId, limit).successBody()

	@Deprecated("Find methods with are deprecated", replaceWith = ReplaceWith("filterCodesBy(filter)"))
	override suspend fun findCodesByType(
		region: String,
		type: String?,
		code: String?,
		version: String?,
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<Code> = rawApi.findCodesByType(region, type, code, version, startKey.encodeStartKey(), startDocumentId, limit).successBody()

	@Deprecated("Find methods with are deprecated", replaceWith = ReplaceWith("filterCodesBy(filter)"))
	override suspend fun findCodesByLink(
		linkType: String,
		linkedId: String?,
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<Code> = rawApi.findCodesByLink(linkType, linkedId, startKey.encodeStartKey(), startDocumentId, limit).successBody()

	override suspend fun listCodesByRegionTypeCodeVersion(
		region: String,
		type: String?,
		code: String?,
		version: String?,
	): List<Code> = rawApi.listCodesByRegionTypeCodeVersion(region, type, code, version).successBody()

	override suspend fun listCodeTypesBy(region: String?, type: String?): List<String> = rawApi.listCodeTypesBy(region, type).successBody()

	override suspend fun listTagTypesBy(region: String?, type: String?): List<String> = rawApi.listTagTypesBy(region, type).successBody()

	override suspend fun createCode(c: Code): Code = rawApi.createCode(c).successBody()

	override suspend fun createCodes(codeBatch: List<Code>): List<Code> = rawApi.createCodes(codeBatch).successBody()

	override suspend fun isCodeValid(
		type: String,
		code: String,
		version: String?,
	): BooleanResponse = rawApi.isCodeValid(type, code, version).successBody()

	override suspend fun getCodeByRegionLanguageTypeLabel(
		region: String,
		label: String,
		type: String,
		languages: String?,
	): Code? = rawApi.getCodeByRegionLanguageTypeLabelOr404(region, label, type, languages).successBodyOrNull404()

	override suspend fun getCodes(codeIds: List<String>): List<Code> = rawApi.getCodes(
		ListOfIds(codeIds)
	).successBody()

	override suspend fun getCode(codeId: String): Code? = rawApi.getCode(codeId).successBodyOrNull404()

	override suspend fun getCodeWithParts(
		type: String,
		code: String,
		version: String,
	): Code? = rawApi.getCodeWithParts(type, code, version).successBodyOrNull404()

	override suspend fun modifyCode(codeDto: Code): Code = rawApi.modifyCode(codeDto).successBodyOrThrowRevisionConflict()

	override suspend fun modifyCodes(codeBatch: List<Code>): List<Code> = rawApi.modifyCodes(codeBatch).successBody()

	override suspend fun filterCodesBy(filter: BaseFilterOptions<Code>): PaginatedListIterator<Code> =
		IdsPageIterator(matchCodesBy(filter), this::getCodes)

	override suspend fun filterCodesBySorted(filter: BaseSortableFilterOptions<Code>): PaginatedListIterator<Code> =
		IdsPageIterator(matchCodesBySorted(filter), this::getCodes)

	override suspend fun matchCodesBy(filter: BaseFilterOptions<Code>): List<String> =
		rawApi.matchCodesBy(mapCodeFilterOptions(filter)).successBody()

	override suspend fun matchCodesBySorted(filter: BaseSortableFilterOptions<Code>): List<String> =
		matchCodesBy(filter)

	override suspend fun importCodes(codeType: String): Unit = rawApi.importCodes(codeType).successBody()

	override suspend fun createCodes(groupId: String, codeBatch: List<Code>): List<Code> = rawApi.createCodesInGroup(groupId, codeBatch).successBody()

	override suspend fun getCodes(groupId: String, codeIds: List<String>): List<Code> = rawApi.getCodes(groupId,
		ListOfIds(ids = codeIds)
	).successBody()

	override suspend fun modifyCodes(groupId: String, codeBatch: List<Code>): List<Code> = rawApi.modifyCodesInGroup(groupId, codeBatch).successBody()
}
