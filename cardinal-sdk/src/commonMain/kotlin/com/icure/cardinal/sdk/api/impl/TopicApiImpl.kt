package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.TopicApi
import com.icure.cardinal.sdk.api.TopicBasicApi
import com.icure.cardinal.sdk.api.TopicBasicFlavouredApi
import com.icure.cardinal.sdk.api.TopicBasicFlavouredInGroupApi
import com.icure.cardinal.sdk.api.TopicBasicFlavourlessApi
import com.icure.cardinal.sdk.api.TopicBasicFlavourlessInGroupApi
import com.icure.cardinal.sdk.api.TopicBasicInGroupApi
import com.icure.cardinal.sdk.api.TopicFlavouredApi
import com.icure.cardinal.sdk.api.TopicFlavouredInGroupApi
import com.icure.cardinal.sdk.api.TopicInGroupApi
import com.icure.cardinal.sdk.api.raw.RawTopicApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.OwningEntityDetails
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.crypto.entities.TopicShareOptions
import com.icure.cardinal.sdk.exceptions.NotFoundException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.filters.mapTopicFilterOptions
import com.icure.cardinal.sdk.model.DecryptedTopic
import com.icure.cardinal.sdk.model.EncryptedTopic
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Topic
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.TopicRole
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.DelegationTag
import com.icure.cardinal.sdk.model.extensions.autoDelegationsFor
import com.icure.cardinal.sdk.model.extensions.dataOwnerId
import com.icure.cardinal.sdk.model.requests.topic.AddParticipant
import com.icure.cardinal.sdk.model.requests.topic.RemoveParticipant
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.options.EntitiesEncryptedFieldsManifests
import com.icure.cardinal.sdk.options.JsonPatcher
import com.icure.cardinal.sdk.serialization.SubscriptionSerializer
import com.icure.cardinal.sdk.serialization.TopicAbstractFilterSerializer
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
import kotlinx.serialization.json.decodeFromJsonElement

@InternalIcureApi
private fun encryptedApiFlavour(
	config: BasicApiConfiguration
): FlavouredApi<EncryptedTopic, EncryptedTopic> = FlavouredApi.encrypted(
	config = config,
	encryptedSerializer = EncryptedTopic.serializer(),
	type = EntityWithEncryptionMetadataTypeName.Topic,
	manifest = EntitiesEncryptedFieldsManifests::topic
)

@InternalIcureApi
private fun decryptedApiFlavour(
	config: ApiConfiguration
): FlavouredApi<EncryptedTopic, DecryptedTopic> = FlavouredApi.decrypted(
	config = config,
	encryptedSerializer = EncryptedTopic.serializer(),
	decryptedSerializer = DecryptedTopic.serializer(),
	type = EntityWithEncryptionMetadataTypeName.Topic,
	manifest = EntitiesEncryptedFieldsManifests::topic,
	patchJson = JsonPatcher::patchTopic
)

@InternalIcureApi
private fun tryAndRecoverApiFlavour(
	config: ApiConfiguration
): FlavouredApi<EncryptedTopic, Topic> = FlavouredApi.tryAndRecover(
	config = config,
	encryptedSerializer = EncryptedTopic.serializer(),
	decryptedSerializer = DecryptedTopic.serializer(),
	type = EntityWithEncryptionMetadataTypeName.Topic,
	manifest = EntitiesEncryptedFieldsManifests::topic,
	patchJson = JsonPatcher::patchTopic
)

@OptIn(InternalIcureApi::class)
private suspend fun RawTopicApi.doMatchTopicsBy(
	config: BasicApiConfiguration,
	groupId: String?,
	filter: FilterOptions<Topic>
): List<String> =
	if (groupId == null) {
		matchTopicsBy(
			mapTopicFilterOptions(
				filter,
				config,
				requestGroup = null
			)
		)
	} else {
		matchTopicsBy(
			mapTopicFilterOptions(
				filter,
				config,
				requestGroup = null
			)
		)
	}.successBody()

@OptIn(InternalIcureApi::class)
private suspend fun RawTopicApi.doMatchTopicsBySorted(
	config: BasicApiConfiguration,
	groupId: String?,
	filter: SortableFilterOptions<Topic>
): List<String> = doMatchTopicsBy(config = config, groupId = groupId, filter = filter)

@InternalIcureApi
private abstract class AbstractTopicBasicFlavouredApi<E : Topic>(
	protected val rawApi: RawTopicApi,
	protected open val config: BasicApiConfiguration,
	protected val flavour: FlavouredApi<EncryptedTopic, E>
) : FlavouredApi<EncryptedTopic, E> by flavour {

	protected suspend fun doCreateTopic(groupId: String?, entity: E): E {
		requireIsValidForCreation(entity)
		val encrypted = validateAndMaybeEncrypt(groupId, entity)
		return if (groupId == null) {
			rawApi.createTopic(encrypted)
		} else {
			rawApi.createTopicInGroup(groupId, encrypted)
		}.successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	protected suspend fun doCreateTopics(groupId: String?, entities: List<E>): List<E> = skipRequestOnEmptyList(entities) { topics ->
		val encrypted = validateAndMaybeEncrypt(groupId, topics)
		return if (groupId == null) {
			rawApi.createTopics(encrypted)
		} else {
			rawApi.createTopicsInGroup(groupId, encrypted)
		}.successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	protected suspend fun doUndeleteTopic(groupId: String?, entityId: String, rev: String): E =
		if (groupId == null) {
			rawApi.undeleteTopic(entityId, rev)
		} else {
			rawApi.undeleteTopicInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict().let { maybeDecrypt(groupId, it) }

	protected suspend fun doUndeleteTopics(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<E> = skipRequestOnEmptyList(entityIds) { ids ->
		if (groupId == null) {
			rawApi.undeleteTopics(ListOfIdsAndRev(ids))
		} else {
			rawApi.undeleteTopicsInGroup(groupId, ListOfIdsAndRev(ids))
		}.successBody().let { maybeDecrypt(groupId, it) }
	}

	protected suspend fun doModifyTopic(groupId: String?, entity: E): E {
		requireIsValidForModification(entity)
		val encrypted = validateAndMaybeEncrypt(groupId, entity)
		return if (groupId == null) {
			rawApi.modifyTopic(encrypted)
		} else {
			rawApi.modifyTopicInGroup(groupId, encrypted)
		}.successBodyOrThrowRevisionConflict().let { maybeDecrypt(groupId, it) }
	}

	protected suspend fun doModifyTopics(groupId: String?, entities: List<E>): List<E> = skipRequestOnEmptyList(entities) { topics ->
		val encrypted = validateAndMaybeEncrypt(groupId, topics)
		return if (groupId == null) {
			rawApi.modifyTopics(encrypted)
		} else {
			rawApi.modifyTopicsInGroup(groupId, encrypted)
		}.successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	protected suspend fun doGetTopic(groupId: String?, entityId: String): E? =
		if (groupId == null) {
			rawApi.getTopic(entityId)
		} else {
			rawApi.getTopicInGroup(groupId, entityId)
		}.successBodyOrNull404()?.let { maybeDecrypt(groupId, it) }

	suspend fun doGetTopics(groupId: String?, entityIds: List<String>): List<E> = skipRequestOnEmptyList(entityIds) { ids ->
		if (groupId == null) {
			rawApi.getTopics(ListOfIds(ids))
		} else {
			rawApi.getTopicsInGroup(groupId, ListOfIds(ids))
		}.successBody().let { maybeDecrypt(groupId, it) }
	}

}

@InternalIcureApi
private class TopicBasicFlavouredApiImpl<E : Topic>(
	rawApi: RawTopicApi,
	config: BasicApiConfiguration,
	flavour: FlavouredApi<EncryptedTopic, E>
) : TopicBasicFlavouredApi<E>, AbstractTopicBasicFlavouredApi<E>(rawApi, config, flavour) {

	override suspend fun createTopic(entity: E): E = doCreateTopic(groupId = null, entity = entity)

	override suspend fun createTopics(entities: List<E>): List<E> {
		requireIsValidForCreation(entities)
		return doCreateTopics(groupId = null, entities = entities)
	}

	override suspend fun undeleteTopicById(id: String, rev: String): E = doUndeleteTopic(groupId = null, entityId = id, rev = rev)

	override suspend fun undeleteTopicsByIds(entityIds: List<StoredDocumentIdentifier>): List<E> =
		doUndeleteTopics(groupId = null, entityIds = entityIds)

	override suspend fun modifyTopic(entity: E): E = doModifyTopic(groupId = null, entity = entity)

	override suspend fun modifyTopics(entities: List<E>): List<E> {
		requireIsValidForModification(entities)
		return doModifyTopics(groupId = null, entities = entities)
	}

	override suspend fun getTopic(entityId: String): E? = doGetTopic(groupId = null, entityId = entityId)

	override suspend fun getTopics(entityIds: List<String>): List<E> = doGetTopics(groupId = null, entityIds = entityIds)

	override suspend fun addParticipant(entityId: String, dataOwnerId: String, topicRole: TopicRole): E =
		rawApi.addParticipant(entityId, AddParticipant(dataOwnerId, topicRole))
			.successBody().let { maybeDecrypt(entitiesGroupId = null, entity = it) }

	override suspend fun removeParticipant(entityId: String, dataOwnerId: String): E =
		rawApi.removeParticipant(entityId, RemoveParticipant(dataOwnerId))
			.successBody().let { maybeDecrypt(entitiesGroupId = null, entity = it) }
}

@InternalIcureApi
private class TopicBasicFlavouredInGroupApiImpl<E : Topic>(
	rawApi: RawTopicApi,
	config: BasicApiConfiguration,
	flavour: FlavouredApi<EncryptedTopic, E>
) : TopicBasicFlavouredInGroupApi<E>, AbstractTopicBasicFlavouredApi<E>(rawApi, config, flavour) {

	override suspend fun createTopic(entity: GroupScoped<E>): GroupScoped<E> = groupScopedWith(entity) { groupId, it ->
		doCreateTopic(groupId = groupId, entity = it)
	}

	override suspend fun createTopics(entities: List<GroupScoped<E>>): List<GroupScoped<E>> {
		requireIsValidForCreationInGroup(entities)
		return entities.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doCreateTopics(groupId = groupId, entities = chunk)
		}
	}

	override suspend fun undeleteTopicById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<E> =
		groupScopedWith(entityId) { groupId, it ->
			doUndeleteTopic(groupId = groupId, entityId = it.id, rev = it.rev)
		}

	override suspend fun undeleteTopicsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<E>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doUndeleteTopics(groupId = groupId, entityIds = chunk)
		}

	override suspend fun modifyTopic(entity: GroupScoped<E>): GroupScoped<E> = groupScopedWith(entity) { groupId, it ->
		doModifyTopic(groupId = groupId, entity = it)
	}

	override suspend fun modifyTopics(entities: List<GroupScoped<E>>): List<GroupScoped<E>> {
		requireIsValidForModificationInGroup(entities)
		return entities.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doModifyTopics(groupId = groupId, entities = chunk)
		}
	}

	override suspend fun getTopic(groupId: String, entityId: String): GroupScoped<E>? = groupScopedIn(groupId) {
		doGetTopic(groupId = groupId, entityId = entityId)
	}

	override suspend fun getTopics(groupId: String, entityIds: List<String>): List<GroupScoped<E>> =
		doGetTopics(groupId = groupId, entityIds = entityIds).map { GroupScoped(it, groupId) }
}

@InternalIcureApi
private abstract class AbstractTopicFlavouredApi<E : Topic>(
	rawApi: RawTopicApi,
	override val config: ApiConfiguration,
	flavour: FlavouredApi<EncryptedTopic, E>
) : AbstractTopicBasicFlavouredApi<E>(rawApi, config, flavour) {

	protected suspend fun doShareWithMany(
		entityGroupId: String?,
		topic: E,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, TopicShareOptions>
	): E  = config.crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
		entityGroupId = entityGroupId,
		entity = topic,
		entityType = EntityWithEncryptionMetadataTypeName.Topic,
		delegates,
		autoRetry = true,
		getUpdatedEntity = { doGetTopic(entityGroupId, it) ?: throw NotFoundException("Topic $it not found") },
		doRequestBulkShareOrUpdate = {
			maybeDecrypt(
				entityGroupId,
				if (entityGroupId == null)
					rawApi.bulkShare(it).successBody()
				else
					rawApi.bulkShare(it, entityGroupId).successBody()
			)
		}
	).updatedEntityOrThrow()

}

@InternalIcureApi
private class TopicFlavouredApiImpl<E : Topic>(
	rawApi: RawTopicApi,
	config: ApiConfiguration,
	flavour: FlavouredApi<EncryptedTopic, E>
) : AbstractTopicFlavouredApi<E>(rawApi, config, flavour),
	TopicBasicFlavouredApi<E> by TopicBasicFlavouredApiImpl(rawApi, config, flavour),
	TopicFlavouredApi<E> {

	override suspend fun shareWith(
		delegateId: String,
		topic: E,
		options: TopicShareOptions?,
	): E =
		shareWithMany(topic, mapOf(delegateId to (options ?: TopicShareOptions())))

	override suspend fun shareWithMany(topic: E, delegates: Map<String, TopicShareOptions>): E =
		doShareWithMany(
			null,
			topic,
			delegates.keyAsLocalDataOwnerReferences(),
		)

	override suspend fun filterTopicsBy(filter: FilterOptions<Topic>): PaginatedListIterator<E> =
		IdsPageIterator(
			rawApi.doMatchTopicsBy(config = config, groupId = null, filter = filter),
			this::getTopics
		)

	override suspend fun filterTopicsBySorted(filter: SortableFilterOptions<Topic>): PaginatedListIterator<E> =
		filterTopicsBy(filter)
}

@InternalIcureApi
private class TopicFlavouredInGroupApiImpl<E : Topic>(
	rawApi: RawTopicApi,
	config: ApiConfiguration,
	flavour: FlavouredApi<EncryptedTopic, E>
) : AbstractTopicFlavouredApi<E>(rawApi, config, flavour),
	TopicBasicFlavouredInGroupApi<E> by TopicBasicFlavouredInGroupApiImpl(rawApi, config, flavour),
	TopicFlavouredInGroupApi<E> {

	override suspend fun shareWith(
		delegate: EntityReferenceInGroup,
		topic: GroupScoped<E>,
		options: TopicShareOptions?
	): GroupScoped<E> = shareWithMany(topic, mapOf(delegate to (options ?: TopicShareOptions())))

	override suspend fun shareWithMany(
		topic: GroupScoped<E>,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, TopicShareOptions>
	): GroupScoped<E> = groupScopedWith(topic) { groupId, entity ->
		doShareWithMany(groupId, entity, delegates)
	}

	override suspend fun filterTopicsBy(groupId: String, filter: FilterOptions<Topic>): PaginatedListIterator<GroupScoped<E>> =
		IdsPageIterator(
			rawApi.doMatchTopicsBy(config = config, groupId = groupId, filter = filter),
		) { ids ->
			doGetTopics(groupId, ids).map { topic ->
				GroupScoped(topic, groupId)
			}
		}

	override suspend fun filterTopicsBySorted(groupId: String, filter: SortableFilterOptions<Topic>): PaginatedListIterator<GroupScoped<E>> =
		filterTopicsBy(groupId, filter)
}

@InternalIcureApi
private abstract class AbstractTopicBasicFlavourless(
	protected val rawApi: RawTopicApi
) {

	protected suspend fun doDeleteTopic(groupId: String?, entityId: String, rev: String): StoredDocumentIdentifier =
		if (groupId == null) {
			rawApi.deleteTopic(entityId, rev)
		} else {
			rawApi.deleteTopicInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict().toStoredDocumentIdentifier()

	protected suspend fun doDeleteTopics(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.deleteTopicsWithRev(ListOfIdsAndRev(ids))
			} else {
				rawApi.deleteTopicsInGroup(groupId, ListOfIdsAndRev(ids))
			}.successBody().toStoredDocumentIdentifier()
		}

	protected suspend fun doPurgeTopic(groupId: String?, entityId: String, rev: String) {
		if (groupId == null) {
			rawApi.purgeTopic(entityId, rev)
		} else {
			rawApi.purgeTopicInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doPurgeTopics(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.purgeTopics(ListOfIdsAndRev(ids))
			} else {
				rawApi.purgeTopicsInGroup(groupId, ListOfIdsAndRev(ids))
			}.successBody().toStoredDocumentIdentifier()
		}
}

@InternalIcureApi
private class TopicBasicFlavourlessApiImpl(rawApi: RawTopicApi) : AbstractTopicBasicFlavourless(rawApi), TopicBasicFlavourlessApi {

	override suspend fun deleteTopicById(entityId: String, rev: String): StoredDocumentIdentifier =
		doDeleteTopic(groupId = null, entityId, rev)

	override suspend fun deleteTopicsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doDeleteTopics(groupId = null, entityIds)

	override suspend fun purgeTopicById(id: String, rev: String) {
		doPurgeTopic(groupId = null, entityId = id, rev = rev)
	}

	override suspend fun purgeTopicsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doPurgeTopics(groupId = null, entityIds = entityIds)
}

@InternalIcureApi
private class TopicBasicFlavourlessInGroupApiImpl(rawApi: RawTopicApi) : AbstractTopicBasicFlavourless(rawApi), TopicBasicFlavourlessInGroupApi {
	override suspend fun deleteTopicById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier> =
		groupScopedWith(entityId) { groupId, it ->
			doDeleteTopic(groupId, it.id, it.rev)
		}

	override suspend fun deleteTopicsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, entities ->
			doDeleteTopics(groupId, entities)
		}

	override suspend fun purgeTopicById(entityId: GroupScoped<StoredDocumentIdentifier>) {
		doPurgeTopic(groupId = entityId.groupId, entityId = entityId.entity.id, rev = entityId.entity.rev)
	}

	override suspend fun purgeTopicsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, batch ->
			doPurgeTopics(groupId, batch)
		}
}

@InternalIcureApi
internal fun initTopicApi(
	rawApi: RawTopicApi,
	config: ApiConfiguration
): TopicApi {
	val decryptedFlavour = decryptedApiFlavour(config)
	val encryptedFlavour = encryptedApiFlavour(config)
	val tryAndRecoverFlavour = tryAndRecoverApiFlavour(config)
	return TopicApiImpl(
		rawApi,
		config,
		encryptedFlavour,
		decryptedFlavour,
		tryAndRecoverFlavour
	)
}

@InternalIcureApi
private class TopicApiImpl(
	private val rawApi: RawTopicApi,
	private val config: ApiConfiguration,
	private val encryptedFlavour: FlavouredApi<EncryptedTopic, EncryptedTopic>,
	private val decryptedFlavour: FlavouredApi<EncryptedTopic, DecryptedTopic>,
	private val tryAndRecoverFlavour: FlavouredApi<EncryptedTopic, Topic>,
) : TopicApi,
	TopicFlavouredApi<DecryptedTopic> by TopicFlavouredApiImpl(rawApi, config, decryptedFlavour),
	TopicBasicFlavourlessApi by TopicBasicFlavourlessApiImpl(rawApi) {
	override val encrypted: TopicFlavouredApi<EncryptedTopic> = TopicFlavouredApiImpl(rawApi, config, encryptedFlavour)
	override val tryAndRecover: TopicFlavouredApi<Topic> = TopicFlavouredApiImpl(rawApi, config, tryAndRecoverFlavour)
	override val inGroup: TopicInGroupApi = object : TopicInGroupApi,
		TopicFlavouredInGroupApi<DecryptedTopic> by TopicFlavouredInGroupApiImpl(rawApi, config, decryptedFlavour),
		TopicBasicFlavourlessInGroupApi by TopicBasicFlavourlessInGroupApiImpl(rawApi) {

		override val encrypted: TopicFlavouredInGroupApi<EncryptedTopic> = TopicFlavouredInGroupApiImpl(rawApi, config, encryptedFlavour)
		override val tryAndRecover: TopicFlavouredInGroupApi<Topic> = TopicFlavouredInGroupApiImpl(rawApi, config, tryAndRecoverFlavour)

		override suspend fun withEncryptionMetadata(
			groupId: String,
			base: DecryptedTopic?,
			patient: GroupScoped<Patient>?,
			user: User?,
			delegates: Map<String, AccessLevel>,
			secretId: SecretIdUseOption,
			alternateRootDelegateId: String?
		): GroupScoped<DecryptedTopic> =
			GroupScoped(
				doWithEncryptionMetadata(
					groupId = groupId,
					base = base,
					patient = patient?.entity,
					patientGroupId = patient?.groupId,
					user = user,
					delegates = delegates,
					secretId = secretId,
					alternateRootDelegateId = alternateRootDelegateId
				),
				groupId
			)

		override suspend fun getEncryptionKeysOf(topic: GroupScoped<Topic>): Set<HexString> =
			doGetEncryptionKeysOf(groupId = topic.groupId, entity = topic.entity)

		override suspend fun hasWriteAccess(topic: GroupScoped<Topic>): Boolean  =
			doHasWriteAccess(groupId = topic.groupId, entity = topic.entity)

		override suspend fun decryptPatientIdOf(topic: GroupScoped<Topic>): Set<EntityReferenceInGroup> =
			doDecryptPatientIdOf(groupId = topic.groupId, topic = topic.entity)

		override suspend fun createDelegationDeAnonymizationMetadata(
			entity: GroupScoped<Topic>,
			delegates: Set<EntityReferenceInGroup>,
		) {
			doCreateDelegationDeAnonymizationMetadata(groupId = entity.groupId, entity = entity.entity, delegates = delegates)
		}

		override suspend fun decrypt(topics: List<GroupScoped<EncryptedTopic>>): List<GroupScoped<DecryptedTopic>> =
			topics.mapExactlyChunkedByGroup { groupId, entities ->
				decryptedFlavour.maybeDecrypt(groupId, entities)
			}

		override suspend fun tryDecrypt(topics: List<GroupScoped<EncryptedTopic>>): List<GroupScoped<Topic>> =
			topics.mapExactlyChunkedByGroup { groupId, entities ->
				tryAndRecoverFlavour.maybeDecrypt(groupId, entities)
			}

		override suspend fun matchTopicsBy(groupId: String, filter: FilterOptions<Topic>): List<String> =
			rawApi.doMatchTopicsBy(config = config, groupId = groupId, filter = filter)

		override suspend fun matchTopicsBySorted(groupId: String, filter: SortableFilterOptions<Topic>): List<String> =
			rawApi.doMatchTopicsBySorted(config = config, groupId = groupId, filter = filter)
	}

	override suspend fun withEncryptionMetadata(
		base: DecryptedTopic?,
		patient: Patient?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdUseOption,
		alternateRootDelegateId: String?
	): DecryptedTopic =
		doWithEncryptionMetadata(
			groupId = null,
			base = base,
			patient = patient,
			patientGroupId = null,
			user = user,
			delegates = delegates,
			secretId = secretId,
			alternateRootDelegateId = alternateRootDelegateId
		)

	private suspend fun doWithEncryptionMetadata(
		groupId: String?,
		base: DecryptedTopic?,
		patient: Patient?,
		patientGroupId: String?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdUseOption,
		alternateRootDelegateId: String?
	): DecryptedTopic =
		config.crypto.entity.entityWithInitializedEncryptedMetadata(
			groupId,
			(base ?: DecryptedTopic(config.crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			),
			EntityWithEncryptionMetadataTypeName.Topic,
			patient?.let {
				OwningEntityDetails(
					patientGroupId,
					it.id,
					config.crypto.entity.resolveSecretIdOption(
						patientGroupId,
						it,
						EntityWithEncryptionMetadataTypeName.Patient,
						secretId
					)
				)
			},
			initializeEncryptionKey = true,
			autoDelegations = (delegates + user?.autoDelegationsFor(DelegationTag.MedicalInformation)
				.orEmpty()).keyAsLocalDataOwnerReferences(),
			alternateRootDataOwnerReference = alternateRootDelegateId?.let { EntityReferenceInGroup(it, groupId) },
		).updatedEntity

	override suspend fun getEncryptionKeysOf(topic: Topic): Set<HexString> =
		doGetEncryptionKeysOf(groupId = null, entity = topic)

	private suspend fun doGetEncryptionKeysOf(groupId: String?, entity: Topic): Set<HexString> =
		config.crypto.entity.encryptionKeysOf(groupId, entity, EntityWithEncryptionMetadataTypeName.Topic, null)

	override suspend fun hasWriteAccess(topic: Topic): Boolean =
		doHasWriteAccess(groupId = null, entity = topic)

	private suspend fun doHasWriteAccess(groupId: String?, entity: Topic): Boolean =
		config.crypto.entity.hasWriteAccess(groupId, entity, EntityWithEncryptionMetadataTypeName.Topic)

	override suspend fun decryptPatientIdOf(topic: Topic): Set<EntityReferenceInGroup> =
		doDecryptPatientIdOf(groupId = null, topic = topic)

	private suspend fun doDecryptPatientIdOf(groupId: String?, topic: Topic): Set<EntityReferenceInGroup> =
		config.crypto.entity.owningEntityIdsOf(
			entityGroupId = groupId,
			entity = topic,
			entityType = EntityWithEncryptionMetadataTypeName.Topic,
			dataOwnerId = null
		).mapTo(mutableSetOf()) { config.crypto.entity.parseReference(groupId, it) }


	override suspend fun createDelegationDeAnonymizationMetadata(entity: Topic, delegates: Set<String>) {
		doCreateDelegationDeAnonymizationMetadata(groupId = null, entity = entity, delegates = delegates.asLocalDataOwnerReferences())
	}

	private suspend fun doCreateDelegationDeAnonymizationMetadata(groupId: String?, entity: Topic, delegates: Set<EntityReferenceInGroup>) {
		config.crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(
			groupId,
			entity,
			EntityWithEncryptionMetadataTypeName.Topic,
			delegates
		)
	}

	override suspend fun decrypt(topic: EncryptedTopic): DecryptedTopic =
		config.crypto.entity.decryptEntities(
			null,
			listOf(topic),
			EntityWithEncryptionMetadataTypeName.Topic,
			EncryptedTopic.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedTopic>(config.jsonPatcher.patchTopic(it)) }.single()

	override suspend fun tryDecrypt(topic: EncryptedTopic): Topic =
		config.crypto.entity.tryDecryptEntities(
			null,
			listOf(topic),
			EntityWithEncryptionMetadataTypeName.Topic,
			EncryptedTopic.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedTopic>(config.jsonPatcher.patchTopic(it)) }.single()

	override suspend fun matchTopicsBy(filter: FilterOptions<Topic>): List<String> =
		rawApi.doMatchTopicsBy(config = config, groupId = null, filter = filter)

	override suspend fun matchTopicsBySorted(filter: SortableFilterOptions<Topic>): List<String> =
		rawApi.doMatchTopicsBySorted(config = config, groupId = null, filter = filter)

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: FilterOptions<Topic>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedTopic> {
		return WebSocketSubscription.initialize(
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
			entitySerializer = EncryptedTopic.serializer(),
			events = events,
			filter = mapTopicFilterOptions(
				filter,
				config,
				requestGroup = null
			),
			qualifiedName = Topic.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(TopicAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}
}

@InternalIcureApi
internal fun initTopicBasicApi(
	rawApi: RawTopicApi,
	config: BasicApiConfiguration
): TopicBasicApi = TopicBasicApiImpl(
	rawApi,
	config,
	encryptedApiFlavour(config)
)

@InternalIcureApi
private class TopicBasicApiImpl(
	private val rawApi: RawTopicApi,
	private val config: BasicApiConfiguration,
	private val encryptedFlavour: FlavouredApi<EncryptedTopic, EncryptedTopic>,
) : TopicBasicApi,
	TopicBasicFlavouredApi<EncryptedTopic> by TopicBasicFlavouredApiImpl(rawApi, config, encryptedFlavour),
	TopicBasicFlavourlessApi by TopicBasicFlavourlessApiImpl(rawApi) {
	override val inGroup: TopicBasicInGroupApi = object : TopicBasicInGroupApi,
		TopicBasicFlavouredInGroupApi<EncryptedTopic> by TopicBasicFlavouredInGroupApiImpl(rawApi, config, encryptedFlavour),
		TopicBasicFlavourlessInGroupApi by TopicBasicFlavourlessInGroupApiImpl(rawApi) {

		override suspend fun matchTopicsBy(groupId: String, filter: BaseFilterOptions<Topic>): List<String> =
			rawApi.doMatchTopicsBy(config = config, groupId = groupId, filter = filter)

		override suspend fun matchTopicsBySorted(groupId: String, filter: BaseSortableFilterOptions<Topic>): List<String> =
			rawApi.doMatchTopicsBySorted(config = config, groupId = groupId, filter = filter)

		override suspend fun filterTopicsBy(groupId: String, filter: BaseFilterOptions<Topic>): PaginatedListIterator<GroupScoped<EncryptedTopic>> =
			IdsPageIterator(
				matchTopicsBy(groupId, filter)
			) { ids -> getTopics(groupId, ids) }

		override suspend fun filterTopicsBySorted(groupId: String, filter: BaseSortableFilterOptions<Topic>): PaginatedListIterator<GroupScoped<EncryptedTopic>> =
			filterTopicsBy(groupId, filter)
	}

	override suspend fun matchTopicsBy(filter: BaseFilterOptions<Topic>): List<String> =
		rawApi.doMatchTopicsBy(config = config, groupId = null, filter = filter)

	override suspend fun matchTopicsBySorted(filter: BaseSortableFilterOptions<Topic>): List<String> =
		rawApi.doMatchTopicsBySorted(config = config, groupId = null, filter = filter)

	override suspend fun filterTopicsBy(filter: BaseFilterOptions<Topic>): PaginatedListIterator<EncryptedTopic> =
		IdsPageIterator(
			matchTopicsBy(filter),
			this::getTopics
		)

	override suspend fun filterTopicsBySorted(filter: BaseSortableFilterOptions<Topic>): PaginatedListIterator<EncryptedTopic> =
		filterTopicsBy(filter)

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: BaseFilterOptions<Topic>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedTopic> {
		return WebSocketSubscription.initialize(
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
			entitySerializer = EncryptedTopic.serializer(),
			events = events,
			filter = mapTopicFilterOptions(filter, config, null),
			qualifiedName = Topic.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(TopicAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}
}
