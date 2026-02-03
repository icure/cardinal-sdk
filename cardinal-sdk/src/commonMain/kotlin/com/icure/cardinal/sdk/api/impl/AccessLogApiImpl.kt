package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.AccessLogApi
import com.icure.cardinal.sdk.api.AccessLogBasicApi
import com.icure.cardinal.sdk.api.AccessLogBasicFlavouredApi
import com.icure.cardinal.sdk.api.AccessLogBasicFlavouredInGroupApi
import com.icure.cardinal.sdk.api.AccessLogBasicFlavourlessApi
import com.icure.cardinal.sdk.api.AccessLogBasicFlavourlessInGroupApi
import com.icure.cardinal.sdk.api.AccessLogBasicInGroupApi
import com.icure.cardinal.sdk.api.AccessLogFlavouredApi
import com.icure.cardinal.sdk.api.AccessLogFlavouredInGroupApi
import com.icure.cardinal.sdk.api.AccessLogInGroupApi
import com.icure.cardinal.sdk.api.raw.RawAccessLogApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.entities.AccessLogShareOptions
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.OwningEntityDetails
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.exceptions.NotFoundException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.filters.mapAccessLogFilterOptions
import com.icure.cardinal.sdk.model.AccessLog
import com.icure.cardinal.sdk.model.DecryptedAccessLog
import com.icure.cardinal.sdk.model.EncryptedAccessLog
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.DelegationTag
import com.icure.cardinal.sdk.model.extensions.autoDelegationsFor
import com.icure.cardinal.sdk.model.extensions.dataOwnerId
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.options.EntitiesEncryptedFieldsManifests
import com.icure.cardinal.sdk.options.JsonPatcher
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.cardinal.sdk.utils.generation.JsMapAsObjectArray
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.utils.InternalIcureApi

@InternalIcureApi
private fun encryptedApiFlavour(
	config: BasicApiConfiguration
): FlavouredApi<EncryptedAccessLog, EncryptedAccessLog> = FlavouredApi.encrypted(
	config = config,
	encryptedSerializer = EncryptedAccessLog.serializer(),
	type = EntityWithEncryptionMetadataTypeName.AccessLog,
	manifest = EntitiesEncryptedFieldsManifests::accessLog
)

@InternalIcureApi
private fun decryptedApiFlavour(
	config: ApiConfiguration
): FlavouredApi<EncryptedAccessLog, DecryptedAccessLog> = FlavouredApi.decrypted(
	config = config,
	encryptedSerializer = EncryptedAccessLog.serializer(),
	decryptedSerializer = DecryptedAccessLog.serializer(),
	type = EntityWithEncryptionMetadataTypeName.AccessLog,
	manifest = EntitiesEncryptedFieldsManifests::accessLog,
	patchJson = JsonPatcher::patchAccessLog
)

@InternalIcureApi
private fun tryAndRecoverApiFlavour(
	config: ApiConfiguration
): FlavouredApi<EncryptedAccessLog, AccessLog> = FlavouredApi.tryAndRecover(
	config = config,
	encryptedSerializer = EncryptedAccessLog.serializer(),
	decryptedSerializer = DecryptedAccessLog.serializer(),
	type = EntityWithEncryptionMetadataTypeName.AccessLog,
	manifest = EntitiesEncryptedFieldsManifests::accessLog,
	patchJson = JsonPatcher::patchAccessLog
)

@InternalIcureApi
private abstract class AbstractAccessLogBasicFlavoured<E : AccessLog>(
	protected val rawApi: RawAccessLogApi,
	protected open val config: BasicApiConfiguration,
	protected val flavour: FlavouredApi<EncryptedAccessLog, E>
) : FlavouredApi<EncryptedAccessLog, E> by flavour {

	protected suspend fun doCreateAccessLog(groupId: String?, entity: E): E {
		requireIsValidForCreation(entity)
		val encrypted = validateAndMaybeEncrypt(groupId, entity)
		return (
			if (groupId == null) {
				rawApi.createAccessLog(encrypted)
			} else {
				rawApi.createAccessLogInGroup(groupId, encrypted)
			}
		).successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	protected suspend fun doCreateAccessLogs(groupId: String?, entities: List<E>): List<E> = skipRequestOnEmptyList(entities) { accessLogs ->
		val encrypted = validateAndMaybeEncrypt(entitiesGroupId = groupId, entities = accessLogs)
		if (groupId == null) {
			rawApi.createAccessLogs(encrypted)
		} else {
			rawApi.createAccessLogsInGroup(groupId, encrypted)
		}.successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	protected suspend fun doModifyAccessLog(groupId: String?, entity: E): E {
		requireIsValidForModification(entity)
		val encrypted = validateAndMaybeEncrypt(groupId, entity)
		return (
			if (groupId == null) rawApi.modifyAccessLog(encrypted)
			else rawApi.modifyAccessLogInGroup(groupId, encrypted)
		).successBodyOrThrowRevisionConflict().let {
			maybeDecrypt(groupId, it)
		}
	}

	protected suspend fun doModifyAccessLogs(groupId: String?, entities: List<E>): List<E> = skipRequestOnEmptyList(entities) { accessLogs ->
		val encrypted = validateAndMaybeEncrypt(groupId, accessLogs)
		return (
			if (groupId == null) rawApi.modifyAccessLogs(encrypted)
			else rawApi.modifyAccessLogsInGroup(groupId, encrypted)
		).successBodyOrThrowRevisionConflict().let {
			maybeDecrypt(groupId, it)
		}
	}

	protected suspend fun doGetAccessLog(groupId: String?, entityId: String): E? =
		(
			if (groupId == null)
				rawApi.getAccessLog(entityId)
			else
				rawApi.getAccessLogInGroup(groupId = groupId, accessLogId = entityId)
		).successBodyOrNull404()?.let {
			maybeDecrypt(groupId, it)
		}

	suspend fun doGetAccessLogs(groupId: String?, entityIds: List<String>): List<E> = skipRequestOnEmptyList(entityIds) { ids ->
		maybeDecrypt(
			groupId,
			if (groupId == null)
				rawApi.getAccessLogByIds(ListOfIds(ids)).successBody()
			else
				rawApi.getAccessLogsInGroup(groupId, ListOfIds(ids)).successBody()
		)
	}

}

@InternalIcureApi
private open class AbstractAccessLogBasicFlavouredApi<E : AccessLog>(
	rawApi: RawAccessLogApi,
	config: BasicApiConfiguration,
	flavour: FlavouredApi<EncryptedAccessLog, E>
): AccessLogBasicFlavouredApi<E>, AbstractAccessLogBasicFlavoured<E>(rawApi, config, flavour) {

	override suspend fun createAccessLog(entity: E): E =
		doCreateAccessLog(groupId = null, entity)

	override suspend fun createAccessLogs(entities: List<E>): List<E> {
		requireIsValidForCreation(entities)
		return doCreateAccessLogs(groupId = null, entities)
	}

	override suspend fun undeleteAccessLogById(id: String, rev: String): E =
		rawApi.undeleteAccessLog(id, rev).successBodyOrThrowRevisionConflict().let { maybeDecrypt(entitiesGroupId = null, entity = it) }

	override suspend fun undeleteAccessLogsByIds(entityIds: List<StoredDocumentIdentifier>): List<E> = skipRequestOnEmptyList(entityIds) { ids ->
		rawApi.undeleteAccessLogs(ListOfIdsAndRev(ids = ids)).successBody().let {
			maybeDecrypt(entitiesGroupId = null, entities = it)
		}
	}

	override suspend fun modifyAccessLog(entity: E): E = doModifyAccessLog(groupId = null, entity)

	override suspend fun modifyAccessLogs(entities: List<E>): List<E> {
		requireIsValidForModification(entities)
		return doModifyAccessLogs(groupId = null, entities)
	}

	override suspend fun getAccessLog(entityId: String): E? =
		doGetAccessLog(groupId = null, entityId)

	override suspend fun getAccessLogs(entityIds: List<String>): List<E> = doGetAccessLogs(groupId = null, entityIds)

}

@InternalIcureApi
private open class AbstractAccessLogBasicFlavouredInGroupApi<E : AccessLog>(
	rawApi: RawAccessLogApi,
	config: BasicApiConfiguration,
	flavour: FlavouredApi<EncryptedAccessLog, E>
): AccessLogBasicFlavouredInGroupApi<E>, AbstractAccessLogBasicFlavoured<E>(rawApi, config, flavour) {

	override suspend fun createAccessLog(entity: GroupScoped<E>): GroupScoped<E> =
		GroupScoped(doCreateAccessLog(entity.groupId, entity.entity), entity.groupId)

	override suspend fun createAccessLogs(entities: List<GroupScoped<E>>): List<GroupScoped<E>> {
		requireIsValidForCreationInGroup(entities)
		return entities.mapUniqueIdentifiablesChunkedByGroup { groupId, batch ->
			doCreateAccessLogs(groupId, batch)
		}
	}

	override suspend fun undeleteAccessLogById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<E> =
		rawApi.undeleteAccessLogInGroup(entityId.groupId, entityId.entity.id, entityId.entity.rev)
			.successBodyOrThrowRevisionConflict()
			.let { GroupScoped(entity = maybeDecrypt(entitiesGroupId = entityId.groupId, entity = it), groupId = entityId.groupId) }

	override suspend fun undeleteAccessLogsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<E>> =
		skipRequestOnEmptyList(entityIds) { ids ->
			ids.mapUniqueIdentifiablesChunkedByGroup { groupId, batch ->
				rawApi.undeleteAccessLogsInGroup(
					groupId = groupId,
					accessLogIdsAndRevs = ListOfIdsAndRev(ids = batch),
				).successBody().let {
					maybeDecrypt(entitiesGroupId = groupId, entities = it)
				}
			}
		}

	override suspend fun modifyAccessLog(entity: GroupScoped<E>): GroupScoped<E> =
		GroupScoped(
			doModifyAccessLog(entity.groupId, entity.entity),
			entity.groupId
		)

	override suspend fun modifyAccessLogs(entities: List<GroupScoped<E>>): List<GroupScoped<E>> {
		requireIsValidForModificationInGroup(entities)
		return entities.mapUniqueIdentifiablesChunkedByGroup { groupId, batch ->
			doModifyAccessLogs(groupId, batch)
		}
	}

	override suspend fun getAccessLogs(groupId: String, entityIds: List<String>): List<GroupScoped<E>> =
		doGetAccessLogs(groupId, entityIds).map { GroupScoped(it, groupId) }

	override suspend fun getAccessLog(groupId: String, entityId: String): GroupScoped<E>? =
		doGetAccessLog(groupId, entityId)?.let { GroupScoped(it, groupId) }
}

@InternalIcureApi
private abstract class AbstractAccessLogFlavoured<E : AccessLog>(
	rawApi: RawAccessLogApi,
	override val config: ApiConfiguration,
	flavour: FlavouredApi<EncryptedAccessLog, E>,
) : AbstractAccessLogBasicFlavoured<E>(rawApi, config, flavour) {

	protected suspend fun doShareWithMany(
		groupId: String?,
		accessLog: E,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, AccessLogShareOptions>
	): E =
		config.crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			groupId,
			accessLog,
			EntityWithEncryptionMetadataTypeName.AccessLog,
			delegates,
			true,
			{ doGetAccessLog(groupId = groupId, entityId = it) ?: throw NotFoundException("Access log $it not found") },
			{
				maybeDecrypt(
					groupId,
					if (groupId == null)
						rawApi.bulkShare(it).successBody()
					else
						rawApi.bulkShare(it, groupId).successBody()
				)
			}
		).updatedEntityOrThrow()

	protected suspend inline fun <T : Any> doFilterAccessLogsBy(
		groupId: String?,
		filter: FilterOptions<AccessLog>,
		crossinline mapEntity: (E) -> T
	): PaginatedListIterator<T> =
		IdsPageIterator(
			rawApi.matchAccessLogsBy(
				mapAccessLogFilterOptions(
					filter,
					config,
					groupId
				)
			).successBody(),
		) {
			doGetAccessLogs(groupId, it).map { accessLog -> mapEntity(accessLog) }
		}
}

@InternalIcureApi
private class AbstractAccessLogFlavouredApi<E : AccessLog>(
	rawApi: RawAccessLogApi,
	config: ApiConfiguration,
	flavour: FlavouredApi<EncryptedAccessLog, E>,
) : AbstractAccessLogFlavoured<E>(rawApi, config, flavour),
	AccessLogBasicFlavouredApi<E> by AbstractAccessLogBasicFlavouredApi(rawApi, config, flavour),
	AccessLogFlavouredApi<E> {

	override suspend fun shareWith(
		delegateId: String,
		accessLog: E,
		options: AccessLogShareOptions?,
	): E =
		shareWithMany(accessLog, mapOf(Pair(delegateId, options ?: AccessLogShareOptions())))

	override suspend fun shareWithMany(accessLog: E, delegates: Map<String, AccessLogShareOptions>): E =
		doShareWithMany(null, accessLog, delegates.keyAsLocalDataOwnerReferences())

	override suspend fun filterAccessLogsBySorted(filter: SortableFilterOptions<AccessLog>): PaginatedListIterator<E> =
		filterAccessLogsBy(filter)

	override suspend fun filterAccessLogsBy(filter: FilterOptions<AccessLog>): PaginatedListIterator<E> =
		doFilterAccessLogsBy(
			groupId = null,
			filter = filter,
		) { it }
}

@InternalIcureApi
private class AbstractAccessLogFlavouredInGroupApi<E : AccessLog>(
	rawApi: RawAccessLogApi,
	config: ApiConfiguration,
	flavour: FlavouredApi<EncryptedAccessLog, E>,
) : AbstractAccessLogFlavoured<E>(rawApi, config, flavour),
	AccessLogBasicFlavouredInGroupApi<E> by AbstractAccessLogBasicFlavouredInGroupApi(rawApi, config, flavour),
	AccessLogFlavouredInGroupApi<E> {

	override suspend fun shareWith(
		delegate: EntityReferenceInGroup,
		accessLog: GroupScoped<E>,
		options: AccessLogShareOptions?
	): GroupScoped<E> =
		shareWithMany(accessLog, mapOf(delegate to (options ?: AccessLogShareOptions())))

	override suspend fun shareWithMany(
		accessLog: GroupScoped<E>,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, AccessLogShareOptions>
	): GroupScoped<E> =
		GroupScoped(doShareWithMany(accessLog.groupId, accessLog.entity, delegates), accessLog.groupId)

	override suspend fun filterAccessLogsBySorted(
		groupId: String,
		filter: SortableFilterOptions<AccessLog>
	): PaginatedListIterator<GroupScoped<E>> =
		filterAccessLogsBy(groupId, filter)

	override suspend fun filterAccessLogsBy(
		groupId: String,
		filter: FilterOptions<AccessLog>
	): PaginatedListIterator<GroupScoped<E>> =
		doFilterAccessLogsBy(
			groupId,
			filter
		) { GroupScoped(it, groupId) }
}


@InternalIcureApi
private abstract class AbstractAccessLogBasicFlavourless(
	protected val rawApi: RawAccessLogApi
) {
	protected suspend fun doDeleteAccessLogById(groupId: String?, entityId: String, rev: String): StoredDocumentIdentifier =
		(
			if (groupId == null)
				rawApi.deleteAccessLog(entityId, rev)
			else
				rawApi.deleteAccessLogInGroup(groupId, entityId, rev)
		).successBodyOrThrowRevisionConflict().toStoredDocumentIdentifier()

	protected suspend fun doDeleteAccessLogsByIds(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.deleteAccessLogsWithRev(ListOfIdsAndRev(ids))
			} else {
				rawApi.deleteAccessLogsInGroup(groupId, ListOfIdsAndRev(ids))
			}.successBody().toStoredDocumentIdentifier()
		}

	protected suspend fun doPurgeAccessLogById(groupId: String?, entityId: String, rev: String) {
		(
			if (groupId == null)
				rawApi.purgeAccessLog(accessLogId = entityId, rev = rev)
			else
				rawApi.purgeAccessLogInGroup(groupId = groupId, accessLogId = entityId, rev = rev)
			).successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doPurgeAccessLogsByIds(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.purgeAccessLogs(ListOfIdsAndRev(ids))
			} else {
				rawApi.purgeAccessLogsInGroup(groupId, ListOfIdsAndRev(ids))
			}.successBody().toStoredDocumentIdentifier()
		}
}

@InternalIcureApi
private class AbstractAccessLogBasicFlavourlessApi(rawApi: RawAccessLogApi) : AbstractAccessLogBasicFlavourless(rawApi), AccessLogBasicFlavourlessApi {

	override suspend fun deleteAccessLogById(entityId: String, rev: String): StoredDocumentIdentifier =
		doDeleteAccessLogById(groupId = null, entityId, rev)

	override suspend fun deleteAccessLogsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doDeleteAccessLogsByIds(groupId = null, entityIds)

	override suspend fun purgeAccessLogById(id: String, rev: String) {
		doPurgeAccessLogById(groupId = null, entityId = id, rev = rev)
	}

	override suspend fun purgeAccessLogsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doPurgeAccessLogsByIds(groupId = null, entityIds)
}

@InternalIcureApi
private class AccessLogBasicFlavourlessInGroupApiImpl(rawApi: RawAccessLogApi) : AbstractAccessLogBasicFlavourless(rawApi), AccessLogBasicFlavourlessInGroupApi {
	override suspend fun deleteAccessLogById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier> =
		GroupScoped(doDeleteAccessLogById(entityId.groupId, entityId.entity.id, entityId.entity.rev), entityId.groupId)

	override suspend fun deleteAccessLogsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, entities ->
			doDeleteAccessLogsByIds(groupId, entities)
		}

	override suspend fun purgeAccessLogById(entityId: GroupScoped<StoredDocumentIdentifier>) {
		doPurgeAccessLogById(groupId = entityId.groupId, entityId = entityId.entity.id, rev = entityId.entity.rev)
	}

	override suspend fun purgeAccessLogsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, batch ->
			doPurgeAccessLogsByIds(groupId, batch)
		}
}

@InternalIcureApi
internal fun initAccessLogApi(
	rawApi: RawAccessLogApi,
	config: ApiConfiguration
): AccessLogApi = AccessLogApiImpl(
		rawApi,
		config,
		encryptedApiFlavour(config),
		decryptedApiFlavour(config),
		tryAndRecoverApiFlavour(config)
	)

@InternalIcureApi
private class AccessLogApiImpl(
	private val rawApi: RawAccessLogApi,
	private val config: ApiConfiguration,
	private val encryptedFlavour: FlavouredApi<EncryptedAccessLog, EncryptedAccessLog>,
	private val decryptedFlavour: FlavouredApi<EncryptedAccessLog, DecryptedAccessLog>,
	private val tryAndRecoverFlavour: FlavouredApi<EncryptedAccessLog, AccessLog>
) : AccessLogApi,
	AccessLogBasicFlavourlessApi by AbstractAccessLogBasicFlavourlessApi(rawApi),
	AccessLogFlavouredApi<DecryptedAccessLog> by AbstractAccessLogFlavouredApi(rawApi, config, decryptedFlavour) {

	override val encrypted: AccessLogFlavouredApi<EncryptedAccessLog> = AbstractAccessLogFlavouredApi(rawApi, config, encryptedFlavour)

	override val tryAndRecover: AccessLogFlavouredApi<AccessLog> = AbstractAccessLogFlavouredApi(rawApi, config, tryAndRecoverFlavour)

	override val inGroup: AccessLogInGroupApi = object : AccessLogInGroupApi,
		AccessLogBasicFlavourlessInGroupApi by AccessLogBasicFlavourlessInGroupApiImpl(rawApi),
		AccessLogFlavouredInGroupApi<DecryptedAccessLog> by AbstractAccessLogFlavouredInGroupApi(rawApi, config, decryptedFlavour) {
		override val encrypted: AccessLogFlavouredInGroupApi<EncryptedAccessLog> =
			AbstractAccessLogFlavouredInGroupApi(rawApi, config, encryptedFlavour)

		override val tryAndRecover: AccessLogFlavouredInGroupApi<AccessLog> =
			AbstractAccessLogFlavouredInGroupApi(rawApi, config, tryAndRecoverFlavour)

		override suspend fun decrypt(accessLogs: List<GroupScoped<EncryptedAccessLog>>): List<GroupScoped<DecryptedAccessLog>> =
			accessLogs.mapExactlyChunkedByGroup { groupId, entities ->
				decryptedFlavour.maybeDecrypt(groupId, entities)
			}

		override suspend fun tryDecrypt(accessLogs: List<GroupScoped<EncryptedAccessLog>>): List<GroupScoped<AccessLog>> =
			accessLogs.mapExactlyChunkedByGroup { groupId, entities ->
				tryAndRecoverFlavour.maybeDecrypt(groupId, entities)
			}

		override suspend fun withEncryptionMetadata(
			entityGroupId: String,
			base: DecryptedAccessLog?,
			patient: GroupScoped<Patient>,
			user: User?,
			delegates: @JsMapAsObjectArray(
				keyEntryName = "delegate",
				valueEntryName = "accessLevel"
			) Map<EntityReferenceInGroup, AccessLevel>,
			secretId: SecretIdUseOption,
			alternateRootDelegateReference: EntityReferenceInGroup?
		): GroupScoped<DecryptedAccessLog> =
			GroupScoped(
				doWithEncryptionMetadata(
					entityGroupId,
					base,
					patient.let { Pair(it.entity, it.groupId) },
					user,
					delegates,
					secretId,
					alternateRootDelegateReference
				),
				entityGroupId
			)

		override suspend fun decryptPatientIdOf(accessLog: GroupScoped<AccessLog>): Set<EntityReferenceInGroup> =
			doDecryptPatientIdOf(accessLog.groupId, accessLog.entity).mapNullGroupTo(accessLog.groupId)

		override suspend fun createDelegationDeAnonymizationMetadata(
			entity: GroupScoped<AccessLog>,
			delegates: Set<EntityReferenceInGroup>
		) = doCreateDelegationDeAnonymizationMetadata(entity.groupId, entity.entity, delegates)

		override suspend fun getEncryptionKeysOf(accessLog: GroupScoped<AccessLog>): Set<HexString> =
			doGetEncryptionKeysOf(accessLog.groupId, accessLog.entity)

		override suspend fun hasWriteAccess(accessLog: GroupScoped<AccessLog>): Boolean =
			doHasWriteAccess(accessLog.groupId, accessLog.entity)

		override suspend fun matchAccessLogsBy(groupId: String, filter: FilterOptions<AccessLog>): List<String> =
			doMatchAccessLogsBy(groupId, filter)

		override suspend fun matchAccessLogsBySorted(
			groupId: String,
			filter: SortableFilterOptions<AccessLog>
		): List<String> = doMatchAccessLogsBySorted(groupId, filter)
	}

	private val crypto get() = config.crypto

	override suspend fun getEncryptionKeysOf(accessLog: AccessLog): Set<HexString> = doGetEncryptionKeysOf(null, accessLog)

	private suspend fun doGetEncryptionKeysOf(groupId: String?, accessLog: AccessLog): Set<HexString> =
		crypto.entity.encryptionKeysOf(groupId, accessLog, EntityWithEncryptionMetadataTypeName.AccessLog, null)

	override suspend fun hasWriteAccess(accessLog: AccessLog): Boolean = doHasWriteAccess(null, accessLog)

	private suspend fun doHasWriteAccess(groupId: String?, accessLog: AccessLog): Boolean =
		crypto.entity.hasWriteAccess(groupId, accessLog, EntityWithEncryptionMetadataTypeName.AccessLog)

	override suspend fun decryptPatientIdOf(accessLog: AccessLog) = doDecryptPatientIdOf(null, accessLog)

	private suspend fun doDecryptPatientIdOf(groupId: String?, accessLog: AccessLog): Set<EntityReferenceInGroup> =
		crypto.entity.owningEntityIdsOf(
			groupId,
			accessLog,
			EntityWithEncryptionMetadataTypeName.AccessLog,
			null
		).mapTo(mutableSetOf()) {
			crypto.entity.parseReference(groupId, it)
		}

	override suspend fun createDelegationDeAnonymizationMetadata(entity: AccessLog, delegates: Set<String>) {
		doCreateDelegationDeAnonymizationMetadata(null, entity, delegates.asLocalDataOwnerReferences())
	}

	private suspend fun doCreateDelegationDeAnonymizationMetadata(
		entityGroupId: String?,
		entity: AccessLog,
		delegates: Set<EntityReferenceInGroup>
	) {
		crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(entityGroupId, entity, EntityWithEncryptionMetadataTypeName.AccessLog, delegates)
	}

	override suspend fun withEncryptionMetadata(
		base: DecryptedAccessLog?,
		patient: Patient,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdUseOption,
		alternateRootDelegateId: String?,
	): DecryptedAccessLog =
		doWithEncryptionMetadata(
			null,
			base,
			Pair(patient, null),
			user,
			delegates.keyAsLocalDataOwnerReferences(),
			secretId,
			alternateRootDelegateId?.let { EntityReferenceInGroup(it, null) }
		)

	private suspend fun doWithEncryptionMetadata(
		entityGroupId: String?,
		base: DecryptedAccessLog?,
		patientInGroup: Pair<Patient, String?>,
		user: User?,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "accessLevel") Map<EntityReferenceInGroup, AccessLevel>,
		secretId: SecretIdUseOption,
		alternateRootDataOwnerReference: EntityReferenceInGroup?
	): DecryptedAccessLog =
		crypto.entity.entityWithInitializedEncryptedMetadata(
			entityGroupId = entityGroupId,
			entity = (base ?: DecryptedAccessLog(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			),
			entityType = EntityWithEncryptionMetadataTypeName.AccessLog,
			owningEntityDetails = patientInGroup.let { (patient, patientGroup) ->
				OwningEntityDetails(
					patientGroup,
					patient.id,
					crypto.entity.resolveSecretIdOption(
						entityGroupId,
						patient,
						EntityWithEncryptionMetadataTypeName.Patient,
						secretId
					)
				)
			},
			initializeEncryptionKey = true,
			autoDelegations = delegates + user?.autoDelegationsFor(DelegationTag.AdministrativeData).orEmpty().keyAsLocalDataOwnerReferences(),
			alternateRootDataOwnerReference = alternateRootDataOwnerReference,
		).updatedEntity

	override suspend fun decrypt(accessLog: EncryptedAccessLog): DecryptedAccessLog =
		decryptedFlavour.maybeDecrypt(null, accessLog)

	override suspend fun tryDecrypt(accessLog: EncryptedAccessLog): AccessLog =
		tryAndRecoverFlavour.maybeDecrypt(null, accessLog)

	override suspend fun matchAccessLogsBy(filter: FilterOptions<AccessLog>): List<String> =
		doMatchAccessLogsBy(null, filter)

	override suspend fun matchAccessLogsBySorted(filter: SortableFilterOptions<AccessLog>): List<String> =
		matchAccessLogsBy(filter)

	private suspend fun doMatchAccessLogsBySorted(
		groupId: String?,
		filter: SortableFilterOptions<AccessLog>
	): List<String> = doMatchAccessLogsBy(groupId, filter)

	private suspend fun doMatchAccessLogsBy(groupId: String?, filter: FilterOptions<AccessLog>): List<String> =
		if (groupId == null) {
			rawApi.matchAccessLogsBy(
				mapAccessLogFilterOptions(
					filter,
					config,
					groupId
				)
			).successBody()
		} else {
			rawApi.matchAccessLogsInGroupBy(
				groupId = groupId,
				filter = mapAccessLogFilterOptions(
					filter,
					config,
					groupId
				)
			).successBody()
		}
}

@InternalIcureApi
internal fun initAccessLogBasicApi(
	rawApi: RawAccessLogApi,
	config: BasicApiConfiguration
): AccessLogBasicApi = AccessLogBasicApiImpl(
	rawApi,
	config,
	encryptedApiFlavour(config)
)

@InternalIcureApi
private class AccessLogBasicApiImpl(
	private val rawApi: RawAccessLogApi,
	private val config: BasicApiConfiguration,
	private val encryptedFlavour: FlavouredApi<EncryptedAccessLog, EncryptedAccessLog>,
) : AccessLogBasicApi,
	AccessLogBasicFlavouredApi<EncryptedAccessLog> by AbstractAccessLogBasicFlavouredApi(rawApi, config, encryptedFlavour),
	AccessLogBasicFlavourlessApi by AbstractAccessLogBasicFlavourlessApi(rawApi) {

	override val inGroup: AccessLogBasicInGroupApi = object : AccessLogBasicInGroupApi,
		AccessLogBasicFlavourlessInGroupApi by AccessLogBasicFlavourlessInGroupApiImpl(rawApi),
		AccessLogBasicFlavouredInGroupApi<EncryptedAccessLog> by AbstractAccessLogBasicFlavouredInGroupApi(rawApi, config, encryptedFlavour) {

		override suspend fun matchAccessLogsBy(
			groupId: String,
			filter: BaseFilterOptions<AccessLog>
		): List<String> = doMatchAccessLogsBy(groupId, filter)

		override suspend fun matchAccessLogsBySorted(
			groupId: String,
			filter: BaseSortableFilterOptions<AccessLog>
		): List<String> =
			matchAccessLogsBy(groupId, filter)

		override suspend fun filterAccessLogsBy(
			groupId: String,
			filter: BaseFilterOptions<AccessLog>
		): PaginatedListIterator<GroupScoped<EncryptedAccessLog>> =
			IdsPageIterator(
				doMatchAccessLogsBy(groupId, filter),
			) { getAccessLogs(groupId, it) }

		override suspend fun filterAccessLogsBySorted(
			groupId: String,
			filter: BaseSortableFilterOptions<AccessLog>
		): PaginatedListIterator<GroupScoped<EncryptedAccessLog>> =
			filterAccessLogsBy(groupId, filter)
	}

	private suspend fun doMatchAccessLogsBy(groupId: String?, filter: BaseFilterOptions<AccessLog>): List<String> =
		if (groupId == null) {
			rawApi.matchAccessLogsBy(
				mapAccessLogFilterOptions(
					filter,
					config,
					groupId
				)
			).successBody()
		} else {
			rawApi.matchAccessLogsInGroupBy(
				groupId = groupId,
				filter = mapAccessLogFilterOptions(
					filter,
					config,
					groupId
				)
			).successBody()
		}

	override suspend fun matchAccessLogsBy(filter: BaseFilterOptions<AccessLog>): List<String> = doMatchAccessLogsBy(null, filter)

	override suspend fun matchAccessLogsBySorted(filter: BaseSortableFilterOptions<AccessLog>): List<String> = matchAccessLogsBy(filter)

	override suspend fun filterAccessLogsBy(filter: BaseFilterOptions<AccessLog>): PaginatedListIterator<EncryptedAccessLog> =
		IdsPageIterator(
			doMatchAccessLogsBy(groupId = null, filter),
		) { getAccessLogs(it) }

	override suspend fun filterAccessLogsBySorted(filter: BaseSortableFilterOptions<AccessLog>): PaginatedListIterator<EncryptedAccessLog> =
		filterAccessLogsBy(filter)
}
