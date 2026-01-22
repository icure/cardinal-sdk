package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.CodeApi
import com.icure.cardinal.sdk.api.CodeInGroupApi
import com.icure.cardinal.sdk.api.raw.RawCodeApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.mapCodeFilterOptions
import com.icure.cardinal.sdk.model.BooleanResponse
import com.icure.cardinal.sdk.model.Code
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.utils.InternalIcureApi

@OptIn(InternalIcureApi::class)
internal abstract class AbstractCodeApi(
	protected val rawApi: RawCodeApi,
	private val config: BasicApiConfiguration
) {

	protected suspend fun doCreateCode(groupId: String?, entity: Code): Code {
		basicRequireIsValidForCreation(entity)
		return if (groupId == null) {
			rawApi.createCode(entity)
		} else {
			rawApi.createCodeInGroup(groupId, entity)
		}.successBody()
	}

	protected suspend fun doCreateCodes(groupId: String?, entities: List<Code>): List<Code> =
		skipRequestOnNullList(entities) { calendarItemTypes ->
			if (groupId == null) {
				rawApi.createCodes(calendarItemTypes)
			} else {
				rawApi.createCodesInGroup(groupId, calendarItemTypes)
			}.successBody()
		}

	protected suspend fun doGetCode(groupId: String?, entityId: String): Code? =
		if (groupId == null) {
			rawApi.getCode(entityId)
		} else {
			rawApi.getCodeInGroup(groupId, entityId)
		}.successBodyOrNull()

	protected suspend fun doGetCodes(groupId: String?, entityIds: List<String>): List<Code> =
		skipRequestOnNullList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.getCodes(ListOfIds(ids))
			} else {
				rawApi.getCodesInGroup(groupId, ListOfIds(ids))
			}.successBody()
		}

	protected suspend fun doModifyCode(groupId: String?, entity: Code): Code {
		requireIsValidForModification(entity)
		return if (groupId == null) {
			rawApi.modifyCode(entity)
		} else {
			rawApi.modifyCodeInGroup(groupId, entity)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doModifyCodes(groupId: String?, entities: List<Code>): List<Code> =
		skipRequestOnNullList(entities) { calendarItemTypes ->
			if (groupId == null) {
				rawApi.modifyCodes(calendarItemTypes)
			} else {
				rawApi.modifyCodesInGroup(groupId, calendarItemTypes)
			}.successBody()
		}

	protected suspend fun doDeleteCode(groupId: String?, entityId: String, rev: String): StoredDocumentIdentifier =
		if (groupId == null) {
			rawApi.deleteCode(entityId, rev)
		} else {
			rawApi.deleteCodeInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict().toStoredDocumentIdentifier()

	protected suspend fun doDeleteCodes(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnNullList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.deleteCodes(ListOfIdsAndRev(ids))
			} else {
				rawApi.deleteCodesInGroup(groupId = groupId, ListOfIdsAndRev(ids))
			}.successBody().map { it.toStoredDocumentIdentifier() }
		}

	protected suspend fun doUndeleteCode(groupId: String?, entityId: String, rev: String): Code =
		if (groupId == null) {
			rawApi.undeleteCode(entityId, rev)
		} else {
			rawApi.undeleteCodeInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict()

	protected suspend fun doUndeleteCodes(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<Code> =
		skipRequestOnNullList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.undeleteCodes(ListOfIdsAndRev(ids))
			} else {
				rawApi.undeleteCodesInGroup(groupId = groupId, ListOfIdsAndRev(ids))
			}.successBody()
		}

	protected suspend fun doPurgeCode(groupId: String?, entityId: String, rev: String) {
		if (groupId == null) {
			rawApi.purgeCode(entityId, rev)
		} else {
			rawApi.purgeCodeInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doPurgeCodes(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnNullList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.purgeCodes(ListOfIdsAndRev(ids))
			} else {
				rawApi.purgeCodesInGroup(groupId = groupId, ListOfIdsAndRev(ids))
			}.successBody().map { it.toStoredDocumentIdentifier() }
		}

	protected suspend fun doMatchCodesBy(groupId: String?, filter: BaseFilterOptions<Code>): List<String> =
		if (groupId == null) {
			rawApi.matchCodesBy(mapCodeFilterOptions(filter, config))
		} else {
			rawApi.matchCodesBy(groupId = groupId, filter = mapCodeFilterOptions(filter, config, groupId))
		}.successBody()
}


@InternalIcureApi
internal class CodeApiImpl(
	rawApi: RawCodeApi,
	config: BasicApiConfiguration
) : CodeApi, AbstractCodeApi(rawApi, config) {

	override val inGroup = CodeInGroupApiImpl(rawApi, config)

	override suspend fun listCodeTypesBy(region: String?, type: String?): List<String> = rawApi.listCodeTypesBy(region, type).successBody()

	override suspend fun listTagTypesBy(region: String?, type: String?): List<String> = rawApi.listTagTypesBy(region, type).successBody()

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

	override suspend fun getCodeWithParts(
		type: String,
		code: String,
		version: String,
	): Code? = rawApi.getCodeWithParts(type, code, version).successBodyOrNull404()

	override suspend fun createCode(code: Code): Code = doCreateCode(groupId = null, code)

	override suspend fun createCodes(codes: List<Code>): List<Code> {
		basicRequireIsValidForCreation(codes)
		return doCreateCodes(groupId = null, codes)
	}

	override suspend fun getCodes(codeIds: List<String>): List<Code> = doGetCodes(groupId = null, entityIds = codeIds)

	override suspend fun getCode(codeId: String): Code? = doGetCode(groupId = null, entityId = codeId)

	override suspend fun modifyCode(code: Code): Code = doModifyCode(groupId = null, code)

	override suspend fun modifyCodes(codes: List<Code>): List<Code> {
		requireIsValidForModification(codes)
		return doModifyCodes(groupId = null, codes)
	}

	override suspend fun deleteCodeById(
		entityId: String,
		rev: String,
	): StoredDocumentIdentifier = doDeleteCode(groupId = null, entityId = entityId, rev = rev)

	override suspend fun deleteCodeByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doDeleteCodes(groupId = null, entityIds = entityIds)

	override suspend fun undeleteCodeById(entityId: String, rev: String): Code =
		doUndeleteCode(groupId = null, entityId = entityId, rev = rev)

	override suspend fun undeleteCodeByIds(entityIds: List<StoredDocumentIdentifier>): List<Code> =
		doUndeleteCodes(groupId = null, entityIds = entityIds)

	override suspend fun purgeCodeById(entityId: String, rev: String) {
		doPurgeCode(groupId = null, entityId = entityId, rev = rev)
	}

	override suspend fun purgeCodeByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doPurgeCodes(groupId = null, entityIds = entityIds)

	override suspend fun filterCodesBy(filter: BaseFilterOptions<Code>): PaginatedListIterator<Code> =
		IdsPageIterator(matchCodesBy(filter), this::getCodes)

	override suspend fun filterCodesBySorted(filter: BaseSortableFilterOptions<Code>): PaginatedListIterator<Code> =
		IdsPageIterator(matchCodesBySorted(filter), this::getCodes)

	override suspend fun matchCodesBy(filter: BaseFilterOptions<Code>): List<String> =
		doMatchCodesBy(groupId = null, filter)

	override suspend fun matchCodesBySorted(filter: BaseSortableFilterOptions<Code>): List<String> =
		matchCodesBy(filter)

}

@InternalIcureApi
internal class CodeInGroupApiImpl(
	rawApi: RawCodeApi,
	config: BasicApiConfiguration
) : CodeInGroupApi, AbstractCodeApi(rawApi, config) {

	override suspend fun createCode(code: GroupScoped<Code>): GroupScoped<Code> =
		groupScopedWith(code) { groupId, entity -> doCreateCode(groupId, entity) }

	override suspend fun createCodes(codes: List<GroupScoped<Code>>): List<GroupScoped<Code>> {
		basicRequireIsValidForCreation(codes)
		return codes.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doCreateCodes(groupId, chunk)
		}
	}

	override suspend fun getCode(
		groupId: String,
		codeId: String,
	): GroupScoped<Code>? = groupScopedIn(groupId) { doGetCode(groupId, codeId) }

	override suspend fun getCodes(
		groupId: String,
		codesIds: List<String>,
	): List<GroupScoped<Code>> = groupScopedListIn(groupId) { doGetCodes(groupId, codesIds) }

	override suspend fun modifyCode(code: GroupScoped<Code>): GroupScoped<Code> =
		groupScopedWith(code) { groupId, entity -> doModifyCode(groupId, entity) }

	override suspend fun modifyCodes(codes: List<GroupScoped<Code>>): List<GroupScoped<Code>> {
		requireIsValidForModification(codes)
		return codes.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doModifyCodes(groupId, chunk)
		}
	}

	override suspend fun deleteCodeById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier> =
		groupScopedWith(entityId) { groupId, id -> doDeleteCode(groupId = groupId, entityId = id.id, rev = id.rev) }

	override suspend fun deleteCodeByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doDeleteCodes(groupId = groupId, entityIds = chunk)
		}

	override suspend fun undeleteCodeById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<Code> =
		groupScopedWith(entityId) { groupId, entity -> doUndeleteCode(groupId = groupId, entityId = entity.id, rev = entity.rev) }

	override suspend fun undeleteCodeByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<Code>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doUndeleteCodes(groupId = groupId, entityIds = chunk)
		}

	override suspend fun purgeCodeById(entityId: GroupScoped<StoredDocumentIdentifier>) {
		doPurgeCode(groupId = entityId.groupId, entityId = entityId.entity.id, rev = entityId.entity.rev)
	}

	override suspend fun purgeCodeByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doPurgeCodes(groupId = groupId, entityIds = chunk)
		}

	override suspend fun filterCodesBy(
		groupId: String,
		filter: BaseFilterOptions<Code>,
	): PaginatedListIterator<GroupScoped<Code>> = IdsPageIterator(matchCodesBy(groupId, filter)) { ids -> getCodes(groupId, ids) }

	override suspend fun filterCodesBySorted(
		groupId: String,
		filter: BaseSortableFilterOptions<Code>,
	): PaginatedListIterator<GroupScoped<Code>> =
		IdsPageIterator(matchCodesBySorted(groupId, filter)) { ids -> getCodes(groupId, ids) }

	override suspend fun matchCodesBy(
		groupId: String,
		filter: BaseFilterOptions<Code>,
	): List<String> = doMatchCodesBy(groupId, filter)

	override suspend fun matchCodesBySorted(
		groupId: String,
		filter: BaseSortableFilterOptions<Code>,
	): List<String> = matchCodesBy(groupId, filter)

}
