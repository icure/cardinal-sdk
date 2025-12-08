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
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
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
private open class AbstractAccessLogBasicFlavouredApi<E : AccessLog>(
	protected val rawApi: RawAccessLogApi,
	protected open val config: BasicApiConfiguration,
	protected val flavour: FlavouredApi<EncryptedAccessLog, E>
) : AccessLogBasicFlavouredApi<E>,
	AccessLogBasicFlavouredInGroupApi<E>,
	FlavouredApi<EncryptedAccessLog, E> by flavour {

	override suspend fun createAccessLog(entity: E): E =
		doCreateAccessLog(null, entity)

	override suspend fun createAccessLog(entity: GroupScoped<E>): GroupScoped<E> =
		GroupScoped(doCreateAccessLog(entity.groupId, entity.entity), entity.groupId)

	private suspend fun doCreateAccessLog(groupId: String?, entity: E): E {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialized. Make sure to use the `withEncryptionMetadata` method." }
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

	override suspend fun undeleteAccessLogById(id: String, rev: String): E =
		rawApi.undeleteAccessLog(id, rev).successBodyOrThrowRevisionConflict().let { maybeDecrypt(null, it) }

	override suspend fun modifyAccessLog(entity: E): E = doModifyAccessLog(null, entity)

	override suspend fun modifyAccessLog(entity: GroupScoped<E>): GroupScoped<E> =
		GroupScoped(
			doModifyAccessLog(entity.groupId, entity.entity),
			entity.groupId
		)

	private suspend fun doModifyAccessLog(groupId: String?, entity: E): E =
		validateAndMaybeEncrypt(groupId, entity).let {
			if (groupId == null)
				rawApi.modifyAccessLog(it)
			else
				rawApi.modifyAccessLogInGroup(groupId, it)
		}.successBodyOrThrowRevisionConflict().let {
			maybeDecrypt(groupId, it)
		}

	override suspend fun getAccessLog(entityId: String): E? =
		doGetAccessLog(null, entityId)

	override suspend fun getAccessLog(groupId: String, entityId: String): GroupScoped<E>? =
		doGetAccessLog(groupId, entityId)?.let { GroupScoped(it, groupId) }

	protected suspend fun doGetAccessLog(groupId: String?, entityId: String): E? =
		(
			if (groupId == null)
				rawApi.getAccessLog(entityId)
			else
				rawApi.getAccessLogInGroup(groupId = groupId, accessLogId = entityId)
		).successBodyOrNull404()?.let {
			maybeDecrypt(groupId, it)
		}


	override suspend fun getAccessLogs(entityIds: List<String>): List<E> =
		doGetAccessLogs(null, entityIds)

	override suspend fun getAccessLogs(groupId: String, entityIds: List<String>): List<GroupScoped<E>> =
		doGetAccessLogs(groupId, entityIds).map { GroupScoped(it, groupId) }

	suspend fun doGetAccessLogs(groupId: String?, entityIds: List<String>): List<E> =
		maybeDecrypt(
			groupId,
			if (groupId == null)
				rawApi.getAccessLogByIds(ListOfIds(entityIds)).successBody()
			else
				rawApi.getAccessLogsInGroup(groupId, ListOfIds(entityIds)).successBody()
		)


	@Deprecated("Use filter instead")
	override suspend fun findAccessLogsBy(
		fromEpoch: Long?,
		toEpoch: Long?,
		startKey: Long?,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E> =
		maybeDecrypt(rawApi.findAccessLogsBy(fromEpoch, toEpoch, startKey, startDocumentId, limit).successBody())

	@Deprecated("Use filter instead")
	override suspend fun findAccessLogsByUserAfterDate(
		userId: String,
		accessType: String?,
		startDate: Long?,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		descending: Boolean?,
	): PaginatedList<E> =
		maybeDecrypt(rawApi.findAccessLogsByUserAfterDate(userId, accessType, startDate, startKey, startDocumentId, limit, descending).successBody())

	@Deprecated("Use filter instead")
	override suspend fun findAccessLogsInGroup(
		groupId: String,
		fromEpoch: Long?,
		toEpoch: Long?,
		startKey: Long?,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E> =
		maybeDecrypt(rawApi.findAccessLogsInGroup(groupId, fromEpoch, toEpoch, startKey, startDocumentId, limit).successBody())
}

@InternalIcureApi
private open class AbstractAccessLogFlavouredApi<E : AccessLog>(
	rawApi: RawAccessLogApi,
	override val config: ApiConfiguration,
	flavour: FlavouredApi<EncryptedAccessLog, E>,
) : AbstractAccessLogBasicFlavouredApi<E>(rawApi, config, flavour),
	AccessLogFlavouredApi<E>,
	AccessLogFlavouredInGroupApi<E> {

	override suspend fun shareWith(
		delegateId: String,
		accessLog: E,
		options: AccessLogShareOptions?,
	): E =
		shareWithMany(accessLog, mapOf(Pair(delegateId, options ?: AccessLogShareOptions())))

	override suspend fun shareWith(
		delegate: EntityReferenceInGroup,
		accessLog: GroupScoped<E>,
		options: AccessLogShareOptions?
	): GroupScoped<E> =
		shareWithMany(accessLog, mapOf(delegate to (options ?: AccessLogShareOptions())))

	override suspend fun shareWithMany(accessLog: E, delegates: Map<String, AccessLogShareOptions>): E =
		doShareWithMany(null, accessLog, delegates.keyAsLocalDataOwnerReferences())

	override suspend fun shareWithMany(
		accessLog: GroupScoped<E>,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, AccessLogShareOptions>
	): GroupScoped<E> =
		GroupScoped(doShareWithMany(accessLog.groupId, accessLog.entity, delegates), accessLog.groupId)

	private suspend fun doShareWithMany(
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
			{ getAccessLog(it) ?: throw NotFoundException("Access log $it not found") },
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

	@Deprecated("Use filter instead")
	override suspend fun findAccessLogsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?,
	): PaginatedListIterator<E> = IdsPageIterator(
		rawApi.listAccessLogIdsByDataOwnerPatientDate(
			dataOwnerId = hcPartyId,
			startDate = startDate,
			endDate = endDate,
			descending = descending,
			secretPatientKeys = ListOfIds(
				config.crypto.entity.secretIdsOf(
					null,
					patient,
					EntityWithEncryptionMetadataTypeName.Patient,
					null
				).toList()
			)
		).successBody()
	) { ids ->
		maybeDecrypt(rawApi.getAccessLogByIds(ListOfIds(ids)).successBody())
	}

	override suspend fun filterAccessLogsBySorted(filter: SortableFilterOptions<AccessLog>): PaginatedListIterator<E> =
		filterAccessLogsBy(filter)

	override suspend fun filterAccessLogsBy(filter: FilterOptions<AccessLog>): PaginatedListIterator<E> =
		doFilterAccessLogsBy(
			groupId = null,
			filter = filter,
		) { it }

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

	private suspend inline fun <T : Any> doFilterAccessLogsBy(
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
		(
			if (groupId == null)
				rawApi.deleteAccessLogsWithRev(ListOfIdsAndRev(entityIds))
			else
				rawApi.deleteAccessLogsInGroup(groupId, ListOfIdsAndRev(entityIds))
		).successBody().toStoredDocumentIdentifier()
}

@InternalIcureApi
private class AbstractAccessLogBasicFlavourlessApi(rawApi: RawAccessLogApi) : AbstractAccessLogBasicFlavourless(rawApi), AccessLogBasicFlavourlessApi {
	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deleteAccessLogUnsafe(entityId: String): DocIdentifier =
		rawApi.deleteAccessLog(entityId).successBodyOrThrowRevisionConflict()

	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deleteAccessLogsUnsafe(entityIds: List<String>): List<DocIdentifier> =
		rawApi.deleteAccessLogs(ListOfIds(entityIds)).successBody()

	override suspend fun deleteAccessLogById(entityId: String, rev: String): StoredDocumentIdentifier =
		doDeleteAccessLogById(null, entityId, rev)

	override suspend fun deleteAccessLogsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doDeleteAccessLogsByIds(null, entityIds)

	override suspend fun purgeAccessLogById(id: String, rev: String) {
		rawApi.purgeAccessLog(id, rev).successBodyOrThrowRevisionConflict()
	}
}

@InternalIcureApi
private class AccessLogBasicFlavourlessInGroupApiImpl(rawApi: RawAccessLogApi) : AbstractAccessLogBasicFlavourless(rawApi), AccessLogBasicFlavourlessInGroupApi {
	override suspend fun deleteAccessLogById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier> =
		GroupScoped(doDeleteAccessLogById(entityId.groupId, entityId.entity.id, entityId.entity.rev), entityId.groupId)

	override suspend fun deleteAccessLogsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, entities ->
			doDeleteAccessLogsByIds(groupId, entities)
		}
}

@InternalIcureApi
internal fun initAccessLogApi(
	rawApi: RawAccessLogApi,
	config: ApiConfiguration
): AccessLogApi {
	val decryptedFlavour = decryptedApiFlavour(config)
	val encryptedFlavour = encryptedApiFlavour(config)
	val tryAndRecoverFlavour = tryAndRecoverApiFlavour(config)
	val decryptedApi = AbstractAccessLogFlavouredApi(rawApi, config, decryptedFlavour)
	val encryptedApi = AbstractAccessLogFlavouredApi(rawApi, config, encryptedFlavour)
	val tryAndRecoverApi = AbstractAccessLogFlavouredApi(rawApi, config, tryAndRecoverFlavour)
	return AccessLogApiImpl(
		rawApi,
		config,
		encryptedApi,
		decryptedApi,
		tryAndRecoverApi
	)
}

@InternalIcureApi
private class AccessLogApiImpl(
	private val rawApi: RawAccessLogApi,
	private val config: ApiConfiguration,
	private val encryptedFlavour: AbstractAccessLogFlavouredApi<EncryptedAccessLog>,
	private val decryptedFlavour: AbstractAccessLogFlavouredApi<DecryptedAccessLog>,
	private val tryAndRecoverFlavour: AbstractAccessLogFlavouredApi<AccessLog>
) : AccessLogApi,
	AccessLogBasicFlavourlessApi by AbstractAccessLogBasicFlavourlessApi(rawApi),
	AccessLogFlavouredApi<DecryptedAccessLog> by decryptedFlavour {

	override val encrypted: AccessLogFlavouredApi<EncryptedAccessLog> = encryptedFlavour

	override val tryAndRecover: AccessLogFlavouredApi<AccessLog> = tryAndRecoverFlavour

	override val inGroup: AccessLogInGroupApi = object : AccessLogInGroupApi,
		AccessLogBasicFlavourlessInGroupApi by AccessLogBasicFlavourlessInGroupApiImpl(rawApi),
		AccessLogFlavouredInGroupApi<DecryptedAccessLog> by decryptedFlavour {
		override val encrypted: AccessLogFlavouredInGroupApi<EncryptedAccessLog> = encryptedFlavour
		override val tryAndRecover: AccessLogFlavouredInGroupApi<AccessLog> = tryAndRecoverFlavour

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
	AbstractAccessLogBasicFlavouredApi(rawApi, config, encryptedApiFlavour(config))
)

@InternalIcureApi
private class AccessLogBasicApiImpl(
	private val rawApi: RawAccessLogApi,
	private val config: BasicApiConfiguration,
	private val encryptedFlavour: AbstractAccessLogBasicFlavouredApi<EncryptedAccessLog>,
) : AccessLogBasicApi,
	AccessLogBasicFlavouredApi<EncryptedAccessLog> by encryptedFlavour,
	AccessLogBasicFlavourlessApi by AbstractAccessLogBasicFlavourlessApi(rawApi) {

	override val inGroup: AccessLogBasicInGroupApi = object : AccessLogBasicInGroupApi,
		AccessLogBasicFlavourlessInGroupApi by AccessLogBasicFlavourlessInGroupApiImpl(rawApi),
		AccessLogBasicFlavouredInGroupApi<EncryptedAccessLog> by encryptedFlavour {

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
			doFilterAccessLogsBy(groupId, filter) { GroupScoped(it, groupId) }

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

	private suspend inline fun <T : Any> doFilterAccessLogsBy(
		groupId: String?,
		filter: BaseFilterOptions<AccessLog>,
		crossinline mapEntity: (EncryptedAccessLog) -> T
	): PaginatedListIterator<T> =
		IdsPageIterator(
			doMatchAccessLogsBy(groupId, filter),
		) {
			encryptedFlavour.doGetAccessLogs(groupId, it).map { calendarItem -> mapEntity(calendarItem) }
		}

	override suspend fun filterAccessLogsBy(filter: BaseFilterOptions<AccessLog>): PaginatedListIterator<EncryptedAccessLog> =
		doFilterAccessLogsBy(null, filter) { it }

	override suspend fun filterAccessLogsBySorted(filter: BaseSortableFilterOptions<AccessLog>): PaginatedListIterator<EncryptedAccessLog> =
		filterAccessLogsBy(filter)
}
