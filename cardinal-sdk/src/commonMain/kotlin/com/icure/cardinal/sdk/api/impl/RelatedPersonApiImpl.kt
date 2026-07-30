package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.RelatedPersonApi
import com.icure.cardinal.sdk.api.RelatedPersonBasicApi
import com.icure.cardinal.sdk.api.RelatedPersonBasicFlavouredApi
import com.icure.cardinal.sdk.api.RelatedPersonBasicFlavouredInGroupApi
import com.icure.cardinal.sdk.api.RelatedPersonBasicFlavourlessApi
import com.icure.cardinal.sdk.api.RelatedPersonBasicFlavourlessInGroupApi
import com.icure.cardinal.sdk.api.RelatedPersonBasicInGroupApi
import com.icure.cardinal.sdk.api.RelatedPersonFlavouredApi
import com.icure.cardinal.sdk.api.RelatedPersonFlavouredInGroupApi
import com.icure.cardinal.sdk.api.RelatedPersonInGroupApi
import com.icure.cardinal.sdk.api.raw.RawRelatedPersonApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.entities.DelegateOptions
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.RelatedPersonDelegateOptions
import com.icure.cardinal.sdk.crypto.entities.RelatedPersonShareOptions
import com.icure.cardinal.sdk.exceptions.NotFoundException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.filters.mapRelatedPersonFilterOptions
import com.icure.cardinal.sdk.model.DecryptedRelatedPerson
import com.icure.cardinal.sdk.model.EncryptedRelatedPerson
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.RelatedPerson
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.DelegationTag
import com.icure.cardinal.sdk.model.extensions.autoDelegationsFor
import com.icure.cardinal.sdk.model.extensions.dataOwnerId
import com.icure.cardinal.sdk.model.extensions.toDefaultDelegateOptions
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.serialization.RelatedPersonAbstractFilterSerializer
import com.icure.cardinal.sdk.serialization.SubscriptionSerializer
import com.icure.cardinal.sdk.subscription.EntitySubscription
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import com.icure.cardinal.sdk.subscription.WebSocketSubscription
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.cardinal.sdk.utils.generation.JsMapAsObjectArray
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.utils.InternalIcureApi

@InternalIcureApi
private fun encryptedApiFlavour(
	config: BasicApiConfiguration
): FlavouredApi<EncryptedRelatedPerson, EncryptedRelatedPerson> = FlavouredApi.encrypted(
	config = config,
)

@InternalIcureApi
private fun decryptedApiFlavour(
	config: ApiConfiguration
): FlavouredApi<EncryptedRelatedPerson, DecryptedRelatedPerson> = FlavouredApi.decrypted(
	config = config,
	type = EntityWithEncryptionMetadataTypeName.RelatedPerson,
	encryptors = config.encryptors.relatedPerson,
	getRootModelVersion = EncryptedRelatedPerson::customisedModelVersion,
)

@InternalIcureApi
private fun tryAndRecoverApiFlavour(
	config: ApiConfiguration
): FlavouredApi<EncryptedRelatedPerson, RelatedPerson> = FlavouredApi.tryAndRecover(
	config = config,
	type = EntityWithEncryptionMetadataTypeName.RelatedPerson,
	encryptors = config.encryptors.relatedPerson,
	getRootModelVersion = EncryptedRelatedPerson::customisedModelVersion,
)

@OptIn(InternalIcureApi::class)
private suspend fun RawRelatedPersonApi.doMatchRelatedPersonsBy(
	config: BasicApiConfiguration,
	groupId: String?,
	filter: FilterOptions<RelatedPerson>
): List<String> =
	if (groupId == null) {
		matchRelatedPersonsBy(
			filter = mapRelatedPersonFilterOptions(
				filter,
				config,
				requestGroup = null
			)
		)
	} else {
		matchRelatedPersonsInGroupBy(
			filter = mapRelatedPersonFilterOptions(
				filter,
				config,
				requestGroup = groupId
			),
			groupId = groupId
		)
	}.successBody()

@OptIn(InternalIcureApi::class)
private suspend fun RawRelatedPersonApi.doMatchRelatedPersonsBySorted(
	config: BasicApiConfiguration,
	groupId: String?,
	filter: SortableFilterOptions<RelatedPerson>
): List<String> = doMatchRelatedPersonsBy(config = config, groupId = groupId, filter = filter)

@InternalIcureApi
private abstract class AbstractRelatedPersonBasicFlavouredApi<E : RelatedPerson>(
	protected val rawApi: RawRelatedPersonApi,
	protected open val config: BasicApiConfiguration,
	protected val flavour: FlavouredApi<EncryptedRelatedPerson, E>
) : FlavouredApi<EncryptedRelatedPerson, E> by flavour {

	protected suspend fun doCreateRelatedPerson(groupId: String?, entity: E): E {
		requireIsValidForCreation(entity)
		val encrypted = validateAndMaybeEncrypt(groupId, entity)
		return if (groupId == null) {
			rawApi.createRelatedPerson(c = encrypted)
		} else {
			rawApi.createRelatedPersonInGroup(groupId = groupId, relatedPersonDto = encrypted)
		}.successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	protected suspend fun doCreateRelatedPersons(groupId: String?, entities: List<E>): List<E> = skipRequestOnEmptyList(entities) { relatedPersons ->
		val encrypted = validateAndMaybeEncrypt(groupId, relatedPersons)
		return if (groupId == null) {
			rawApi.createRelatedPersons(relatedPersonDtos = encrypted)
		} else {
			rawApi.createRelatedPersonsInGroup(groupId = groupId, relatedPersonDtos = encrypted)
		}.successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	protected suspend fun doUndeleteRelatedPerson(groupId: String?, entityId: String, rev: String): E =
		if (groupId == null) {
			rawApi.undeleteRelatedPerson(relatedPersonId = entityId, rev = rev)
		} else {
			rawApi.undeleteRelatedPersonInGroup(groupId = groupId, relatedPersonId = entityId, rev = rev)
		}.successBodyOrThrowRevisionConflict().let { maybeDecrypt(groupId, it) }

	protected suspend fun doUndeleteRelatedPersons(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<E> = skipRequestOnEmptyList(entityIds) { ids ->
		if (groupId == null) {
			rawApi.undeleteRelatedPersons(relatedPersonIds = ListOfIdsAndRev(ids))
		} else {
			rawApi.undeleteRelatedPersonsInGroup(groupId = groupId, relatedPersonIds = ListOfIdsAndRev(ids))
		}.successBody().let { maybeDecrypt(groupId, it) }
	}

	protected suspend fun doModifyRelatedPerson(groupId: String?, entity: E): E {
		requireIsValidForModification(entity)
		val encrypted = validateAndMaybeEncrypt(groupId, entity)
		return if (groupId == null) {
			rawApi.modifyRelatedPerson(relatedPersonDto = encrypted)
		} else {
			rawApi.modifyRelatedPersonInGroup(groupId = groupId, relatedPersonDto = encrypted)
		}.successBodyOrThrowRevisionConflict().let { maybeDecrypt(groupId, it) }
	}

	protected suspend fun doModifyRelatedPersons(groupId: String?, entities: List<E>): List<E> = skipRequestOnEmptyList(entities) { relatedPersons ->
		val encrypted = validateAndMaybeEncrypt(groupId, relatedPersons)
		return if (groupId == null) {
			rawApi.modifyRelatedPersons(relatedPersonDtos = encrypted)
		} else {
			rawApi.modifyRelatedPersonsInGroup(groupId = groupId, relatedPersonDtos = encrypted)
		}.successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	protected suspend fun doGetRelatedPerson(groupId: String?, entityId: String): E? =
		if (groupId == null) {
			rawApi.getRelatedPerson(relatedPersonId = entityId)
		} else {
			rawApi.getRelatedPersonInGroup(groupId = groupId, relatedPersonId = entityId)
		}.successBodyOrNull404()?.let { maybeDecrypt(groupId, it) }

	suspend fun doGetRelatedPersons(groupId: String?, entityIds: List<String>) = skipRequestOnEmptyList(entityIds) { ids ->
		if (groupId == null) {
			rawApi.getRelatedPersons(relatedPersonIds = ListOfIds(ids))
		} else {
			rawApi.getRelatedPersonsInGroup(groupId = groupId, relatedPersonIds = ListOfIds(ids))
		}.successBody().let { maybeDecrypt(groupId, it) }
	}
}

@InternalIcureApi
private class RelatedPersonBasicFlavouredApiImpl<E : RelatedPerson>(
	rawApi: RawRelatedPersonApi,
	config: BasicApiConfiguration,
	flavour: FlavouredApi<EncryptedRelatedPerson, E>
) : RelatedPersonBasicFlavouredApi<E>, AbstractRelatedPersonBasicFlavouredApi<E>(rawApi, config, flavour) {

	override suspend fun createRelatedPerson(entity: E): E = doCreateRelatedPerson(groupId = null, entity = entity)

	override suspend fun createRelatedPersons(entities: List<E>): List<E> {
		requireIsValidForCreation(entities)
		return doCreateRelatedPersons(groupId = null, entities = entities)
	}

	override suspend fun undeleteRelatedPersonById(id: String, rev: String): E = doUndeleteRelatedPerson(groupId = null, entityId = id, rev = rev)

	override suspend fun undeleteRelatedPersonsByIds(entityIds: List<StoredDocumentIdentifier>): List<E> =
		doUndeleteRelatedPersons(groupId = null, entityIds = entityIds)

	override suspend fun modifyRelatedPerson(entity: E): E = doModifyRelatedPerson(groupId = null, entity = entity)

	override suspend fun modifyRelatedPersons(entities: List<E>): List<E> {
		requireIsValidForModification(entities)
		return doModifyRelatedPersons(groupId = null, entities = entities)
	}

	override suspend fun getRelatedPerson(entityId: String): E? = doGetRelatedPerson(groupId = null, entityId = entityId)

	override suspend fun getRelatedPersons(entityIds: List<String>): List<E> = doGetRelatedPersons(groupId = null, entityIds)
}

@InternalIcureApi
private class RelatedPersonBasicFlavouredInGroupApiImpl<E : RelatedPerson>(
	rawApi: RawRelatedPersonApi,
	config: BasicApiConfiguration,
	flavour: FlavouredApi<EncryptedRelatedPerson, E>
) : RelatedPersonBasicFlavouredInGroupApi<E>, AbstractRelatedPersonBasicFlavouredApi<E>(rawApi, config, flavour) {

	override suspend fun createRelatedPerson(entity: GroupScoped<E>): GroupScoped<E> = groupScopedWith(entity) { groupId, it ->
		doCreateRelatedPerson(groupId = groupId, entity = it)
	}

	override suspend fun createRelatedPersons(entities: List<GroupScoped<E>>): List<GroupScoped<E>> {
		requireIsValidForCreationInGroup(entities)
		return entities.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doCreateRelatedPersons(groupId = groupId, entities = chunk)
		}
	}

	override suspend fun undeleteRelatedPersonById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<E> =
		groupScopedWith(entityId) { groupId, it ->
			doUndeleteRelatedPerson(groupId = groupId, entityId = it.id, rev = it.rev)
		}

	override suspend fun undeleteRelatedPersonsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<E>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doUndeleteRelatedPersons(groupId = groupId, entityIds = chunk)
		}

	override suspend fun modifyRelatedPerson(entity: GroupScoped<E>): GroupScoped<E> = groupScopedWith(entity) { groupId, it ->
		doModifyRelatedPerson(groupId = groupId, entity = it)
	}

	override suspend fun modifyRelatedPersons(entities: List<GroupScoped<E>>): List<GroupScoped<E>> {
		requireIsValidForModificationInGroup(entities)
		return entities.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doModifyRelatedPersons(groupId = groupId, entities = chunk)
		}
	}

	override suspend fun getRelatedPerson(groupId: String, entityId: String): GroupScoped<E>? = groupScopedIn(groupId) {
		doGetRelatedPerson(groupId = groupId, entityId = entityId)
	}

	override suspend fun getRelatedPersons(groupId: String, entityIds: List<String>): List<GroupScoped<E>> = groupScopedListIn(groupId) {
		doGetRelatedPersons(groupId = groupId, entityIds = entityIds)
	}
}

@InternalIcureApi
private abstract class AbstractRelatedPersonFlavouredApi<E : RelatedPerson>(
	rawApi: RawRelatedPersonApi,
	override val config: ApiConfiguration,
	flavour: FlavouredApi<EncryptedRelatedPerson, E>
) : AbstractRelatedPersonBasicFlavouredApi<E>(rawApi, config, flavour) {

	protected suspend fun doShareWithMany(
		entityGroupId: String?,
		relatedPerson: E,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, RelatedPersonShareOptions>
	): E =
		config.crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			entityGroupId,
			relatedPerson,
			EntityWithEncryptionMetadataTypeName.RelatedPerson,
			delegates,
			true,
			{ doGetRelatedPerson(entityGroupId, it) ?: throw NotFoundException("RelatedPerson $it not found") },
			{
				maybeDecrypt(
					entityGroupId,
					if (entityGroupId == null)
						rawApi.bulkShare(request = it).successBody()
					else
						rawApi.bulkShare(request = it, groupId = entityGroupId).successBody()
				)
			}
		).updatedEntityOrThrow()
}

@InternalIcureApi
private class RelatedPersonFlavouredApiImpl<E : RelatedPerson>(
	rawApi: RawRelatedPersonApi,
	config: ApiConfiguration,
	flavour: FlavouredApi<EncryptedRelatedPerson, E>
) : AbstractRelatedPersonFlavouredApi<E>(rawApi, config, flavour),
	RelatedPersonBasicFlavouredApi<E> by RelatedPersonBasicFlavouredApiImpl(rawApi, config, flavour),
	RelatedPersonFlavouredApi<E> {

	override suspend fun shareWith(
		delegateId: String,
		relatedPerson: E,
		options: RelatedPersonShareOptions?,
	): E =
		shareWithMany(relatedPerson, mapOf(delegateId to (options ?: RelatedPersonShareOptions())))

	override suspend fun shareWithMany(relatedPerson: E, delegates: Map<String, RelatedPersonShareOptions>): E =
		doShareWithMany(null, relatedPerson, delegates.keyAsLocalDataOwnerReferences())

	override suspend fun filterRelatedPersonsBy(filter: FilterOptions<RelatedPerson>): PaginatedListIterator<E> =
		IdsPageIterator(
			rawApi.doMatchRelatedPersonsBy(config = config, groupId = null, filter = filter),
			this::getRelatedPersons
		)

	override suspend fun filterRelatedPersonsBySorted(filter: SortableFilterOptions<RelatedPerson>): PaginatedListIterator<E> =
		filterRelatedPersonsBy(filter)
}

@InternalIcureApi
private class RelatedPersonFlavouredInGroupApiImpl<E : RelatedPerson>(
	rawApi: RawRelatedPersonApi,
	config: ApiConfiguration,
	flavour: FlavouredApi<EncryptedRelatedPerson, E>
) : AbstractRelatedPersonFlavouredApi<E>(rawApi, config, flavour),
	RelatedPersonBasicFlavouredInGroupApi<E> by RelatedPersonBasicFlavouredInGroupApiImpl(rawApi, config, flavour),
	RelatedPersonFlavouredInGroupApi<E> {

	override suspend fun shareWith(
		delegate: EntityReferenceInGroup,
		relatedPerson: GroupScoped<E>,
		options: RelatedPersonShareOptions?
	): GroupScoped<E> =
		shareWithMany(relatedPerson, mapOf(delegate to (options ?: RelatedPersonShareOptions())))

	override suspend fun shareWithMany(
		relatedPerson: GroupScoped<E>,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, RelatedPersonShareOptions>
	): GroupScoped<E> =
		GroupScoped(
			doShareWithMany(
				relatedPerson.groupId,
				relatedPerson.entity,
				delegates
			),
			relatedPerson.groupId
		)

	override suspend fun filterRelatedPersonsBy(groupId: String, filter: FilterOptions<RelatedPerson>): PaginatedListIterator<GroupScoped<E>> =
		IdsPageIterator(
			rawApi.doMatchRelatedPersonsBy(config = config, groupId = groupId, filter = filter)
		) { ids ->
			doGetRelatedPersons(groupId, ids).map { relatedPerson ->
				GroupScoped(relatedPerson, groupId)
			}
		}

	override suspend fun filterRelatedPersonsBySorted(groupId: String, filter: SortableFilterOptions<RelatedPerson>): PaginatedListIterator<GroupScoped<E>> =
		filterRelatedPersonsBy(groupId, filter)
}

@InternalIcureApi
private abstract class AbstractRelatedPersonBasicFlavourless(
	protected val rawApi: RawRelatedPersonApi
) {

	protected suspend fun doDeleteRelatedPerson(groupId: String?, entityId: String, rev: String): StoredDocumentIdentifier =
		if (groupId == null) {
			rawApi.deleteRelatedPerson(relatedPersonId = entityId, rev = rev)
		} else {
			rawApi.deleteRelatedPersonInGroup(groupId = groupId, relatedPersonId = entityId, rev = rev)
		}.successBodyOrThrowRevisionConflict().toStoredDocumentIdentifier()

	protected suspend fun doDeleteRelatedPersons(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.deleteRelatedPersonsWithRev(relatedPersonIds = ListOfIdsAndRev(ids))
			} else {
				rawApi.deleteRelatedPersonsInGroup(groupId = groupId, relatedPersonIds = ListOfIdsAndRev(ids))
			}.successBody().toStoredDocumentIdentifier()
		}

	protected suspend fun doPurgeRelatedPerson(groupId: String?, entityId: String, rev: String) {
		if (groupId == null) {
			rawApi.purgeRelatedPerson(relatedPersonId = entityId, rev = rev)
		} else {
			rawApi.purgeRelatedPersonInGroup(groupId = groupId, relatedPersonId = entityId, rev = rev)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doPurgeRelatedPersons(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.purgeRelatedPersons(relatedPersonIds = ListOfIdsAndRev(ids))
			} else {
				rawApi.purgeRelatedPersonsInGroup(groupId = groupId, relatedPersonIds = ListOfIdsAndRev(ids))
			}.successBody().toStoredDocumentIdentifier()
		}
}

@InternalIcureApi
private class RelatedPersonBasicFlavourlessApiImpl(rawApi: RawRelatedPersonApi) : AbstractRelatedPersonBasicFlavourless(rawApi), RelatedPersonBasicFlavourlessApi {

	override suspend fun deleteRelatedPersonById(entityId: String, rev: String): StoredDocumentIdentifier =
		doDeleteRelatedPerson(groupId = null, entityId, rev)

	override suspend fun deleteRelatedPersonsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doDeleteRelatedPersons(groupId = null, entityIds)

	override suspend fun purgeRelatedPersonById(id: String, rev: String) {
		doPurgeRelatedPerson(groupId = null, entityId = id, rev = rev)
	}

	override suspend fun purgeRelatedPersonsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doPurgeRelatedPersons(groupId = null, entityIds = entityIds)
}

@InternalIcureApi
private class RelatedPersonBasicFlavourlessInGroupApiImpl(rawApi: RawRelatedPersonApi) : AbstractRelatedPersonBasicFlavourless(rawApi), RelatedPersonBasicFlavourlessInGroupApi {
	override suspend fun deleteRelatedPersonById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier> =
		groupScopedWith(entityId) { groupId, it ->
			doDeleteRelatedPerson(groupId, it.id, it.rev)
		}

	override suspend fun deleteRelatedPersonsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, entities ->
			doDeleteRelatedPersons(groupId, entities)
		}

	override suspend fun purgeRelatedPersonById(entityId: GroupScoped<StoredDocumentIdentifier>) {
		doPurgeRelatedPerson(groupId = entityId.groupId, entityId = entityId.entity.id, rev = entityId.entity.rev)
	}

	override suspend fun purgeRelatedPersonsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, batch ->
			doPurgeRelatedPersons(groupId, batch)
		}
}

@InternalIcureApi
internal fun initRelatedPersonApi(
	rawApi: RawRelatedPersonApi,
	config: ApiConfiguration
): RelatedPersonApi {
	val decryptedFlavour = decryptedApiFlavour(config)
	val encryptedFlavour = encryptedApiFlavour(config)
	val tryAndRecoverFlavour = tryAndRecoverApiFlavour(config)
	return RelatedPersonApiImpl(
		rawApi,
		config,
		encryptedFlavour,
		decryptedFlavour,
		tryAndRecoverFlavour
	)
}

@InternalIcureApi
private class RelatedPersonApiImpl(
	private val rawApi: RawRelatedPersonApi,
	private val config: ApiConfiguration,
	private val encryptedFlavour: FlavouredApi<EncryptedRelatedPerson, EncryptedRelatedPerson>,
	private val decryptedFlavour: FlavouredApi<EncryptedRelatedPerson, DecryptedRelatedPerson>,
	private val tryAndRecoverFlavour: FlavouredApi<EncryptedRelatedPerson, RelatedPerson>,
) : RelatedPersonApi,
	RelatedPersonFlavouredApi<DecryptedRelatedPerson> by RelatedPersonFlavouredApiImpl(rawApi, config, decryptedFlavour),
	RelatedPersonBasicFlavourlessApi by RelatedPersonBasicFlavourlessApiImpl(rawApi) {

	override val encrypted: RelatedPersonFlavouredApi<EncryptedRelatedPerson> = RelatedPersonFlavouredApiImpl(rawApi, config, encryptedFlavour)
	override val tryAndRecover: RelatedPersonFlavouredApi<RelatedPerson> = RelatedPersonFlavouredApiImpl(rawApi, config, tryAndRecoverFlavour)

	override val inGroup: RelatedPersonInGroupApi = object : RelatedPersonInGroupApi,
		RelatedPersonFlavouredInGroupApi<DecryptedRelatedPerson> by RelatedPersonFlavouredInGroupApiImpl(rawApi, config, decryptedFlavour),
		RelatedPersonBasicFlavourlessInGroupApi by RelatedPersonBasicFlavourlessInGroupApiImpl(rawApi) {
		override val encrypted: RelatedPersonFlavouredInGroupApi<EncryptedRelatedPerson> =
			RelatedPersonFlavouredInGroupApiImpl(rawApi, config, encryptedFlavour)
		override val tryAndRecover: RelatedPersonFlavouredInGroupApi<RelatedPerson> =
			RelatedPersonFlavouredInGroupApiImpl(rawApi, config, tryAndRecoverFlavour)

		override suspend fun matchRelatedPersonsBy(groupId: String, filter: FilterOptions<RelatedPerson>): List<String> =
			rawApi.doMatchRelatedPersonsBy(config = config, groupId = groupId, filter = filter)

		override suspend fun matchRelatedPersonsBySorted(groupId: String, filter: SortableFilterOptions<RelatedPerson>): List<String> =
			rawApi.doMatchRelatedPersonsBySorted(config = config, groupId = groupId, filter = filter)

		override suspend fun decrypt(relatedPersons: List<GroupScoped<EncryptedRelatedPerson>>): List<GroupScoped<DecryptedRelatedPerson>> =
			relatedPersons.mapExactlyChunkedByGroup { groupId, entities ->
				decryptedFlavour.maybeDecrypt(groupId, entities)
			}

		override suspend fun tryDecrypt(relatedPersons: List<GroupScoped<EncryptedRelatedPerson>>): List<GroupScoped<RelatedPerson>> =
			relatedPersons.mapExactlyChunkedByGroup { groupId, entities ->
				tryAndRecoverFlavour.maybeDecrypt(groupId, entities)
			}

		override suspend fun encryptOrValidate(relatedPersons: List<GroupScoped<RelatedPerson>>): List<GroupScoped<EncryptedRelatedPerson>> =
			relatedPersons.mapExactlyChunkedByGroup { groupId, entities ->
				tryAndRecoverFlavour.validateAndMaybeEncrypt(groupId, entities)
			}

		override suspend fun withEncryptionMetadata(
			entityGroupId: String,
			base: DecryptedRelatedPerson?,
			user: User?,
			delegates: @JsMapAsObjectArray(
				keyEntryName = "delegate",
				valueEntryName = "accessLevel"
			) Map<EntityReferenceInGroup, AccessLevel>,
			alternateRootDelegateReference: EntityReferenceInGroup?
		): GroupScoped<DecryptedRelatedPerson> =
			GroupScoped(
				doWithEncryptionMetadata(
					entityGroupId = entityGroupId,
					base = base,
					user = user,
					delegates = delegates,
					alternateRootDataOwnerReference = alternateRootDelegateReference
				),
				entityGroupId
			)

		override suspend fun withEncryptionMetadataAndDelegates(
			entityGroupId: String,
			base: DecryptedRelatedPerson?,
			delegates: @JsMapAsObjectArray(
				keyEntryName = "delegate",
				valueEntryName = "delegateOptions"
			) Map<EntityReferenceInGroup, RelatedPersonDelegateOptions>,
			user: User?,
			alternateRootDelegateReference: EntityReferenceInGroup?
		): GroupScoped<DecryptedRelatedPerson> =
			GroupScoped(
				doWithEncryptionMetadataAndDelegates(
					entityGroupId = entityGroupId,
					base = base,
					user = user,
					delegates = delegates,
					alternateRootDataOwnerReference = alternateRootDelegateReference
				),
				entityGroupId
			)

		override suspend fun getEncryptionKeysOf(relatedPerson: GroupScoped<RelatedPerson>): Set<HexString> =
			doGetEncryptionKeysOf(relatedPerson.groupId, relatedPerson.entity)

		override suspend fun hasWriteAccess(relatedPerson: GroupScoped<RelatedPerson>): Boolean =
			doHasWriteAccess(relatedPerson.groupId, relatedPerson.entity)

		override suspend fun getSecretIdsOf(relatedPerson: GroupScoped<RelatedPerson>): Set<String> =
			doGetSecretIdsOf(relatedPerson.groupId, relatedPerson.entity)

		override suspend fun createDelegationDeAnonymizationMetadata(
			entity: GroupScoped<RelatedPerson>,
			delegates: Set<EntityReferenceInGroup>
		) =
			doCreateDelegationDeAnonymizationMetadata(entity.groupId, entity.entity, delegates)
	}

	override suspend fun withEncryptionMetadata(
		base: DecryptedRelatedPerson?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		alternateRootDelegateId: String?
	): DecryptedRelatedPerson =
		doWithEncryptionMetadata(
			entityGroupId = null,
			base = base,
			user = user,
			delegates = delegates.keyAsLocalDataOwnerReferences(),
			alternateRootDataOwnerReference = alternateRootDelegateId?.let { EntityReferenceInGroup(it, null) }
		)

	override suspend fun withEncryptionMetadataAndDelegates(
		base: DecryptedRelatedPerson?,
		delegates: Map<String, RelatedPersonDelegateOptions>,
		user: User?,
		alternateRootDelegateId: String?
	): DecryptedRelatedPerson =
		doWithEncryptionMetadataAndDelegates(
			entityGroupId = null,
			base = base,
			user = user,
			delegates = delegates.keyAsLocalDataOwnerReferences(),
			alternateRootDataOwnerReference = alternateRootDelegateId?.let { EntityReferenceInGroup(it, null) }
		)

	private suspend fun doWithEncryptionMetadata(
		entityGroupId: String?,
		base: DecryptedRelatedPerson?,
		user: User?,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "accessLevel") Map<EntityReferenceInGroup, AccessLevel>,
		alternateRootDataOwnerReference: EntityReferenceInGroup?,
	): DecryptedRelatedPerson =
		doWithEncryptionMetadataAndDelegates(
			entityGroupId = entityGroupId,
			base = base,
			user = user,
			delegates = delegates.mapValues { it.value.toDefaultDelegateOptions() },
			alternateRootDataOwnerReference = alternateRootDataOwnerReference,
		)

	private suspend fun doWithEncryptionMetadataAndDelegates(
		entityGroupId: String?,
		base: DecryptedRelatedPerson?,
		user: User?,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "delegateOptions") Map<EntityReferenceInGroup, DelegateOptions>,
		alternateRootDataOwnerReference: EntityReferenceInGroup?,
	): DecryptedRelatedPerson =
		config.crypto.entity.entityWithInitializedEncryptedMetadata(
			entityGroupId,
			(base ?: DecryptedRelatedPerson(config.crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			),
			EntityWithEncryptionMetadataTypeName.RelatedPerson,
			owningEntityDetails = null,
			initializeEncryptionKey = true,
			autoDelegations = delegates + user?.autoDelegationsFor(DelegationTag.AdministrativeData)
				.orEmpty().keyAsLocalDataOwnerReferences(),
			alternateRootDataOwnerReference = alternateRootDataOwnerReference,
		).updatedEntity

	override suspend fun getEncryptionKeysOf(relatedPerson: RelatedPerson): Set<HexString> =
		doGetEncryptionKeysOf(null, relatedPerson)

	private suspend fun doGetEncryptionKeysOf(groupId: String?, relatedPerson: RelatedPerson): Set<HexString> =
		config.crypto.entity.encryptionKeysOf(
			groupId,
			relatedPerson,
			EntityWithEncryptionMetadataTypeName.RelatedPerson,
			null
		)

	override suspend fun hasWriteAccess(relatedPerson: RelatedPerson): Boolean =
		doHasWriteAccess(null, relatedPerson)

	private suspend fun doHasWriteAccess(groupId: String?, relatedPerson: RelatedPerson): Boolean =
		config.crypto.entity.hasWriteAccess(groupId, relatedPerson, EntityWithEncryptionMetadataTypeName.RelatedPerson)

	override suspend fun getSecretIdsOf(relatedPerson: RelatedPerson): Set<String> =
		doGetSecretIdsOf(null, relatedPerson)

	private suspend fun doGetSecretIdsOf(groupId: String?, relatedPerson: RelatedPerson): Set<String> =
		config.crypto.entity.secretIdsOf(
			groupId,
			relatedPerson,
			EntityWithEncryptionMetadataTypeName.RelatedPerson,
			null
		)

	override suspend fun createDelegationDeAnonymizationMetadata(entity: RelatedPerson, delegates: Set<String>) =
		doCreateDelegationDeAnonymizationMetadata(groupId = null, entity, delegates.asLocalDataOwnerReferences())

	private suspend fun doCreateDelegationDeAnonymizationMetadata(groupId: String?, entity: RelatedPerson, delegates: Set<EntityReferenceInGroup>) {
		config.crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(
			groupId,
			entity,
			EntityWithEncryptionMetadataTypeName.RelatedPerson,
			delegates
		)
	}

	override suspend fun matchRelatedPersonsBy(filter: FilterOptions<RelatedPerson>) =
		rawApi.doMatchRelatedPersonsBy(config = config, groupId = null, filter = filter)

	override suspend fun matchRelatedPersonsBySorted(filter: SortableFilterOptions<RelatedPerson>): List<String> =
		rawApi.doMatchRelatedPersonsBySorted(config = config, groupId = null, filter = filter)

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: FilterOptions<RelatedPerson>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedRelatedPerson> {
		return WebSocketSubscription.initialize(
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
			entitySerializer = EncryptedRelatedPerson.serializer(),
			events = events,
			filter = mapRelatedPersonFilterOptions(
				filter,
				config,
				requestGroup = null
			),
			qualifiedName = RelatedPerson.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(RelatedPersonAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}

	override suspend fun decrypt(relatedPersons: List<EncryptedRelatedPerson>): List<DecryptedRelatedPerson> =
		decryptedFlavour.maybeDecrypt(null, relatedPersons)

	override suspend fun tryDecrypt(relatedPersons: List<EncryptedRelatedPerson>): List<RelatedPerson> =
		tryAndRecoverFlavour.maybeDecrypt(null, relatedPersons)

	override suspend fun encryptOrValidate(relatedPersons: List<RelatedPerson>): List<EncryptedRelatedPerson> =
		tryAndRecoverFlavour.validateAndMaybeEncrypt(null, relatedPersons)
}


@InternalIcureApi
internal fun initRelatedPersonBasicApi(
	rawApi: RawRelatedPersonApi,
	config: BasicApiConfiguration
): RelatedPersonBasicApi = RelatedPersonBasicApiImpl(
	rawApi,
	config,
	encryptedApiFlavour(config)
)

@InternalIcureApi
private class RelatedPersonBasicApiImpl(
	private val rawApi: RawRelatedPersonApi,
	private val config: BasicApiConfiguration,
	private val encryptedFlavour: FlavouredApi<EncryptedRelatedPerson, EncryptedRelatedPerson>,
) : RelatedPersonBasicApi,
	RelatedPersonBasicFlavouredApi<EncryptedRelatedPerson> by RelatedPersonBasicFlavouredApiImpl(rawApi, config, encryptedFlavour),
	RelatedPersonBasicFlavourlessApi by RelatedPersonBasicFlavourlessApiImpl(rawApi) {
	override val inGroup: RelatedPersonBasicInGroupApi = object : RelatedPersonBasicInGroupApi,
		RelatedPersonBasicFlavouredInGroupApi<EncryptedRelatedPerson> by RelatedPersonBasicFlavouredInGroupApiImpl(rawApi, config, encryptedFlavour),
		RelatedPersonBasicFlavourlessInGroupApi by RelatedPersonBasicFlavourlessInGroupApiImpl(rawApi) {

		override suspend fun matchRelatedPersonsBy(groupId: String, filter: BaseFilterOptions<RelatedPerson>): List<String> =
			rawApi.doMatchRelatedPersonsBy(config = config, groupId = groupId, filter = filter)

		override suspend fun matchRelatedPersonsBySorted(groupId: String, filter: BaseSortableFilterOptions<RelatedPerson>): List<String> =
			rawApi.doMatchRelatedPersonsBySorted(config = config, groupId = groupId, filter = filter)

		override suspend fun filterRelatedPersonsBy(groupId: String, filter: BaseFilterOptions<RelatedPerson>): PaginatedListIterator<GroupScoped<EncryptedRelatedPerson>> =
			IdsPageIterator(matchRelatedPersonsBy(groupId, filter)) { ids ->
				getRelatedPersons(groupId, ids)
			}

		override suspend fun filterRelatedPersonsBySorted(groupId: String, filter: BaseSortableFilterOptions<RelatedPerson>): PaginatedListIterator<GroupScoped<EncryptedRelatedPerson>> =
			filterRelatedPersonsBy(groupId, filter)
	}

	override suspend fun matchRelatedPersonsBy(filter: BaseFilterOptions<RelatedPerson>): List<String> =
		rawApi.doMatchRelatedPersonsBy(config = config, groupId = null, filter = filter)

	override suspend fun matchRelatedPersonsBySorted(filter: BaseSortableFilterOptions<RelatedPerson>): List<String> =
		rawApi.doMatchRelatedPersonsBySorted(config = config, groupId = null, filter = filter)

	override suspend fun filterRelatedPersonsBy(filter: BaseFilterOptions<RelatedPerson>): PaginatedListIterator<EncryptedRelatedPerson> =
		IdsPageIterator(matchRelatedPersonsBy(filter), this::getRelatedPersons)

	override suspend fun filterRelatedPersonsBySorted(filter: BaseSortableFilterOptions<RelatedPerson>): PaginatedListIterator<EncryptedRelatedPerson> =
		filterRelatedPersonsBy(filter)

}
