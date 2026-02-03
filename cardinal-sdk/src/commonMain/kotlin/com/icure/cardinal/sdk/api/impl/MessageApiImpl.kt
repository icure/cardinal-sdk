package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.MessageApi
import com.icure.cardinal.sdk.api.MessageBasicApi
import com.icure.cardinal.sdk.api.MessageBasicFlavouredApi
import com.icure.cardinal.sdk.api.MessageBasicFlavouredInGroupApi
import com.icure.cardinal.sdk.api.MessageBasicFlavourlessApi
import com.icure.cardinal.sdk.api.MessageBasicFlavourlessInGroupApi
import com.icure.cardinal.sdk.api.MessageBasicInGroupApi
import com.icure.cardinal.sdk.api.MessageFlavouredApi
import com.icure.cardinal.sdk.api.MessageFlavouredInGroupApi
import com.icure.cardinal.sdk.api.MessageInGroupApi
import com.icure.cardinal.sdk.api.raw.RawMessageApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.MessageShareOptions
import com.icure.cardinal.sdk.crypto.entities.OwningEntityDetails
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.exceptions.NotFoundException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.filters.mapMessageFilterOptions
import com.icure.cardinal.sdk.model.DecryptedMessage
import com.icure.cardinal.sdk.model.EncryptedMessage
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.MessagesReadStatusUpdate
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
import com.icure.cardinal.sdk.serialization.MessageAbstractFilterSerializer
import com.icure.cardinal.sdk.serialization.SubscriptionSerializer
import com.icure.cardinal.sdk.subscription.EntitySubscription
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import com.icure.cardinal.sdk.subscription.WebSocketSubscription
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.cardinal.sdk.utils.ensureNonNull
import com.icure.cardinal.sdk.utils.generation.JsMapAsObjectArray
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.utils.InternalIcureApi

@InternalIcureApi
private fun encryptedApiFlavour(
	config: BasicApiConfiguration
): FlavouredApi<EncryptedMessage, EncryptedMessage> = FlavouredApi.encrypted(
	config = config,
	encryptedSerializer = EncryptedMessage.serializer(),
	type = EntityWithEncryptionMetadataTypeName.Message,
	manifest = EntitiesEncryptedFieldsManifests::message
)

@InternalIcureApi
private fun decryptedApiFlavour(
	config: ApiConfiguration
): FlavouredApi<EncryptedMessage, DecryptedMessage> = FlavouredApi.decrypted(
	config = config,
	encryptedSerializer = EncryptedMessage.serializer(),
	decryptedSerializer = DecryptedMessage.serializer(),
	type = EntityWithEncryptionMetadataTypeName.Message,
	manifest = EntitiesEncryptedFieldsManifests::message,
	patchJson = JsonPatcher::patchMessage
)

@InternalIcureApi
private fun tryAndRecoverApiFlavour(
	config: ApiConfiguration
): FlavouredApi<EncryptedMessage, Message> = FlavouredApi.tryAndRecover(
	config = config,
	encryptedSerializer = EncryptedMessage.serializer(),
	decryptedSerializer = DecryptedMessage.serializer(),
	type = EntityWithEncryptionMetadataTypeName.Message,
	manifest = EntitiesEncryptedFieldsManifests::message,
	patchJson = JsonPatcher::patchMessage
)

@OptIn(InternalIcureApi::class)
private suspend fun RawMessageApi.doMatchMessagesBy(
	config: BasicApiConfiguration,
	groupId: String?,
	filter: FilterOptions<Message>
): List<String> =
	if (groupId == null) {
		matchMessagesBy(
			mapMessageFilterOptions(
				filter,
				config,
				requestGroup = null
			)
		)
	} else {
		matchMessagesBy(
			mapMessageFilterOptions(
				filter,
				config,
				requestGroup = null
			)
		)
	}.successBody()

@OptIn(InternalIcureApi::class)
private suspend fun RawMessageApi.doMatchMessagesBySorted(
	config: BasicApiConfiguration,
	groupId: String?,
	filter: SortableFilterOptions<Message>
): List<String> = doMatchMessagesBy(config = config, groupId = groupId, filter = filter)

@InternalIcureApi
private open class AbstractMessageBasicFlavouredApi<E : Message>(
	protected val rawApi: RawMessageApi,
	protected open val config: BasicApiConfiguration,
	protected val flavour: FlavouredApi<EncryptedMessage, E>
) : MessageBasicFlavouredApi<E>,
	MessageBasicFlavouredInGroupApi<E>,
	FlavouredApi<EncryptedMessage, E> by flavour {

	override suspend fun createMessage(entity: E): E = doCreateMessage(groupId = null, entity = entity)

	override suspend fun createMessage(entity: GroupScoped<E>): GroupScoped<E> = groupScopedWith(entity) { groupId, it ->
		doCreateMessage(groupId = groupId, entity = it)
	}

	private suspend fun doCreateMessage(groupId: String?, entity: E): E {
		requireIsValidForCreation(entity)
		val encrypted = validateAndMaybeEncrypt(groupId, entity)
		return if (groupId == null) {
			rawApi.createMessage(encrypted)
		} else {
			rawApi.createMessageInGroup(groupId, encrypted)
		}.successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	override suspend fun createMessages(entities: List<E>): List<E> {
		requireIsValidForCreation(entities)
		return doCreateMessages(groupId = null, entities = entities)
	}

	override suspend fun createMessages(entities: List<GroupScoped<E>>): List<GroupScoped<E>> {
		requireIsValidForCreationInGroup(entities)
		return entities.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doCreateMessages(groupId = groupId, entities = chunk)
		}
	}

	private suspend fun doCreateMessages(groupId: String?, entities: List<E>): List<E> = skipRequestOnEmptyList(entities) { messages ->
		val encrypted = validateAndMaybeEncrypt(groupId, messages)
		return if (groupId == null) {
			rawApi.createMessages(encrypted)
		} else {
			rawApi.createMessagesInGroup(groupId, encrypted)
		}.successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	override suspend fun createMessageInTopic(entity: E): E {
		requireIsValidForCreation(entity)
		val encrypted = validateAndMaybeEncrypt(null, entity)
		return rawApi.createMessageInTopic(encrypted).successBody().let {
			maybeDecrypt(null, it)
		}
	}

	override suspend fun undeleteMessageById(id: String, rev: String): E = doUndeleteMessage(groupId = null, entityId = id, rev = rev)

	override suspend fun undeleteMessageById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<E> =
		groupScopedWith(entityId) { groupId, it ->
			doUndeleteMessage(groupId = groupId, entityId = it.id, rev = it.rev)
		}

	private suspend fun doUndeleteMessage(groupId: String?, entityId: String, rev: String): E =
		if (groupId == null) {
			rawApi.undeleteMessage(entityId, rev)
		} else {
			rawApi.undeleteMessageInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict().let { maybeDecrypt(groupId, it) }

	override suspend fun undeleteMessagesByIds(entityIds: List<StoredDocumentIdentifier>): List<E> =
		doUndeleteMessages(groupId = null, entityIds = entityIds)

	override suspend fun undeleteMessagesByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<E>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doUndeleteMessages(groupId = groupId, entityIds = chunk)
		}

	private suspend fun doUndeleteMessages(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<E> = skipRequestOnEmptyList(entityIds) { ids ->
		if (groupId == null) {
			rawApi.undeleteMessages(ListOfIdsAndRev(ids))
		} else {
			rawApi.undeleteMessagesInGroup(groupId, ListOfIdsAndRev(ids))
		}.successBody().let { maybeDecrypt(groupId, it) }
	}

	override suspend fun modifyMessage(entity: E): E = doModifyMessage(groupId = null, entity = entity)

	override suspend fun modifyMessage(entity: GroupScoped<E>): GroupScoped<E> = groupScopedWith(entity) { groupId, it ->
		doModifyMessage(groupId = groupId, entity = it)
	}

	private suspend fun doModifyMessage(groupId: String?, entity: E): E {
		requireIsValidForModification(entity)
		val encrypted = validateAndMaybeEncrypt(groupId, entity)
		return if (groupId == null) {
			rawApi.modifyMessage(encrypted)
		} else {
			rawApi.modifyMessageInGroup(groupId, encrypted)
		}.successBodyOrThrowRevisionConflict().let { maybeDecrypt(groupId, it) }
	}

	override suspend fun modifyMessages(entities: List<E>): List<E> {
		requireIsValidForModification(entities)
		return doModifyMessages(groupId = null, entities = entities)
	}

	override suspend fun modifyMessages(entities: List<GroupScoped<E>>): List<GroupScoped<E>> {
		requireIsValidForModificationInGroup(entities)
		return entities.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doModifyMessages(groupId = groupId, entities = chunk)
		}
	}

	private suspend fun doModifyMessages(groupId: String?, entities: List<E>): List<E> = skipRequestOnEmptyList(entities) { messages ->
		val encrypted = validateAndMaybeEncrypt(groupId, messages)
		return if (groupId == null) {
			rawApi.modifyMessages(encrypted)
		} else {
			rawApi.modifyMessagesInGroup(groupId, encrypted)
		}.successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	override suspend fun getMessage(entityId: String): E? = doGetMessage(groupId = null, entityId = entityId)

	override suspend fun getMessage(groupId: String, entityId: String): GroupScoped<E>? = groupScopedIn(groupId) {
		doGetMessage(groupId = groupId, entityId = entityId)
	}

	protected suspend fun doGetMessage(groupId: String?, entityId: String): E? =
		if (groupId == null) {
			rawApi.getMessage(entityId)
		} else {
			rawApi.getMessageInGroup(groupId = groupId, messageId = entityId)
		}.successBodyOrNull404()?.let { maybeDecrypt(groupId, it) }

	override suspend fun getMessages(entityIds: List<String>): List<E> = doGetMessages(groupId = null, entityIds)

	override suspend fun getMessages(groupId: String, entityIds: List<String>): List<GroupScoped<E>> = groupScopedListIn(groupId) {
		doGetMessages(groupId = groupId, entityIds = entityIds)
	}

	suspend fun doGetMessages(groupId: String?, entityIds: List<String>) = skipRequestOnEmptyList(entityIds) { ids ->
		if (groupId == null) {
			rawApi.getMessages(ListOfIds(ids))
		} else {
			rawApi.getMessagesInGroup(groupId, ListOfIds(ids))
		}.successBody().let { maybeDecrypt(groupId, it) }
	}

	override suspend fun setMessagesReadStatus(
		entityIds: List<String>,
		time: Long?,
		readStatus: Boolean,
		userId: String?,
	) = rawApi.setMessagesReadStatus(MessagesReadStatusUpdate(entityIds, time, readStatus, userId)).successBody().let { maybeDecrypt(null, it) }
}

@InternalIcureApi
private class AbstractMessageFlavouredApi<E : Message>(
	rawApi: RawMessageApi,
	override val config: ApiConfiguration,
	flavour: FlavouredApi<EncryptedMessage, E>
) : AbstractMessageBasicFlavouredApi<E>(rawApi, config, flavour), MessageFlavouredApi<E>, MessageFlavouredInGroupApi<E> {
	override suspend fun shareWith(
		delegateId: String,
		message: E,
		options: MessageShareOptions?,
	): E =
		shareWithMany(message, mapOf(delegateId to (options ?: MessageShareOptions())))

	override suspend fun shareWithMany(message: E, delegates: Map<String, MessageShareOptions>): E =
		doShareWithMany(null, message, delegates.keyAsLocalDataOwnerReferences())

	override suspend fun shareWith(
		delegate: EntityReferenceInGroup,
		message: GroupScoped<E>,
		options: MessageShareOptions?
	): GroupScoped<E> =
		shareWithMany(message, mapOf(delegate to (options ?: MessageShareOptions())))

	override suspend fun shareWithMany(
		message: GroupScoped<E>,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, MessageShareOptions>
	): GroupScoped<E> =
		GroupScoped(
			doShareWithMany(
				message.groupId,
				message.entity,
				delegates
			),
			message.groupId
		)

	private suspend fun doShareWithMany(
		entityGroupId: String?,
		message: E,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, MessageShareOptions>
	): E =
		config.crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			entityGroupId,
			message,
			EntityWithEncryptionMetadataTypeName.Message,
			delegates,
			true,
			{ doGetMessage(entityGroupId, it) ?: throw NotFoundException("Message $it not found") },
			{
				maybeDecrypt(
					entityGroupId,
					if (entityGroupId == null)
						rawApi.bulkShare(it).successBody()
					else
						rawApi.bulkShare(it, entityGroupId).successBody()
				)
			}
		).updatedEntityOrThrow()

	override suspend fun filterMessagesBy(filter: FilterOptions<Message>): PaginatedListIterator<E> =
		IdsPageIterator(
			rawApi.doMatchMessagesBy(config = config, groupId = null, filter = filter),
			this::getMessages
		)

	override suspend fun filterMessagesBy(groupId: String, filter: FilterOptions<Message>): PaginatedListIterator<GroupScoped<E>> =
		IdsPageIterator(
			rawApi.doMatchMessagesBy(config = config, groupId = groupId, filter = filter)
		) { ids ->
			doGetMessages(groupId, ids).map { message ->
				GroupScoped(message, groupId)
			}
		}

	override suspend fun filterMessagesBySorted(filter: SortableFilterOptions<Message>): PaginatedListIterator<E> =
		filterMessagesBy(filter)

	override suspend fun filterMessagesBySorted(groupId: String, filter: SortableFilterOptions<Message>): PaginatedListIterator<GroupScoped<E>> =
		filterMessagesBy(groupId, filter)
}

@InternalIcureApi
private abstract class AbstractMessageBasicFlavourless(
	protected val rawApi: RawMessageApi
) {

	protected suspend fun doDeleteMessage(groupId: String?, entityId: String, rev: String): StoredDocumentIdentifier =
		if (groupId == null) {
			rawApi.deleteMessage(entityId, rev)
		} else {
			rawApi.deleteMessageInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict().toStoredDocumentIdentifier()

	protected suspend fun doDeleteMessages(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.deleteMessagesWithRev(ListOfIdsAndRev(ids))
			} else {
				rawApi.deleteMessagesInGroup(groupId, ListOfIdsAndRev(ids))
			}.successBody().toStoredDocumentIdentifier()
		}

	protected suspend fun doPurgeMessage(groupId: String?, entityId: String, rev: String) {
		if (groupId == null) {
			rawApi.purgeMessage(entityId, rev)
		} else {
			rawApi.purgeMessageInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doPurgeMessages(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.purgeMessages(ListOfIdsAndRev(ids))
			} else {
				rawApi.purgeMessagesInGroup(groupId, ListOfIdsAndRev(ids))
			}.successBody().toStoredDocumentIdentifier()
		}
}

@InternalIcureApi
private class MessageBasicFlavourlessApiImpl(rawApi: RawMessageApi) : AbstractMessageBasicFlavourless(rawApi), MessageBasicFlavourlessApi {

	override suspend fun deleteMessageById(entityId: String, rev: String): StoredDocumentIdentifier =
		doDeleteMessage(groupId = null, entityId, rev)

	override suspend fun deleteMessagesByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doDeleteMessages(groupId = null, entityIds)

	override suspend fun purgeMessageById(id: String, rev: String) {
		doPurgeMessage(groupId = null, entityId = id, rev = rev)
	}

	override suspend fun purgeMessagesByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doPurgeMessages(groupId = null, entityIds = entityIds)
}

@InternalIcureApi
private class MessageBasicFlavourlessInGroupApiImpl(rawApi: RawMessageApi) : AbstractMessageBasicFlavourless(rawApi), MessageBasicFlavourlessInGroupApi {
	override suspend fun deleteMessageById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier> =
		groupScopedWith(entityId) { groupId, it ->
			doDeleteMessage(groupId, it.id, it.rev)
		}

	override suspend fun deleteMessagesByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, entities ->
			doDeleteMessages(groupId, entities)
		}

	override suspend fun purgeMessageById(entityId: GroupScoped<StoredDocumentIdentifier>) {
		doPurgeMessage(groupId = entityId.groupId, entityId = entityId.entity.id, rev = entityId.entity.rev)
	}

	override suspend fun purgeMessagesByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, batch ->
			doPurgeMessages(groupId, batch)
		}
}

@InternalIcureApi
internal fun initMessageApi(
	rawApi: RawMessageApi,
	config: ApiConfiguration
): MessageApi {
	val decryptedFlavour = decryptedApiFlavour(config)
	val encryptedFlavour = encryptedApiFlavour(config)
	val tryAndRecoverFlavour = tryAndRecoverApiFlavour(config)
	val decryptedApi = AbstractMessageFlavouredApi(rawApi, config, decryptedFlavour)
	val encryptedApi = AbstractMessageFlavouredApi(rawApi, config, encryptedFlavour)
	val tryAndRecoverApi = AbstractMessageFlavouredApi(rawApi, config, tryAndRecoverFlavour)
	return MessageApiImpl(
		rawApi,
		config,
		encryptedApi,
		decryptedApi,
		tryAndRecoverApi
	)
}

@InternalIcureApi
private class MessageApiImpl(
	private val rawApi: RawMessageApi,
	private val config: ApiConfiguration,
	private val encryptedFlavour: AbstractMessageFlavouredApi<EncryptedMessage>,
	private val decryptedFlavour: AbstractMessageFlavouredApi<DecryptedMessage>,
	private val tryAndRecoverFlavour: AbstractMessageFlavouredApi<Message>,
) : MessageApi,
	MessageFlavouredApi<DecryptedMessage> by decryptedFlavour,
	MessageBasicFlavourlessApi by MessageBasicFlavourlessApiImpl(rawApi) {

	override val encrypted: MessageFlavouredApi<EncryptedMessage> = encryptedFlavour
	override val tryAndRecover: MessageFlavouredApi<Message> = tryAndRecoverFlavour

	override val inGroup: MessageInGroupApi = object : MessageInGroupApi,
		MessageFlavouredInGroupApi<DecryptedMessage> by decryptedFlavour,
		MessageBasicFlavourlessInGroupApi by MessageBasicFlavourlessInGroupApiImpl(rawApi) {
		override val encrypted: MessageFlavouredInGroupApi<EncryptedMessage> = encryptedFlavour
		override val tryAndRecover: MessageFlavouredInGroupApi<Message> = tryAndRecoverFlavour

		override suspend fun matchMessagesBy(groupId: String, filter: FilterOptions<Message>): List<String> =
			rawApi.doMatchMessagesBy(config = config, groupId = groupId, filter = filter)

		override suspend fun matchMessagesBySorted(groupId: String, filter: SortableFilterOptions<Message>): List<String> =
			rawApi.doMatchMessagesBySorted(config = config, groupId = groupId, filter = filter)

		override suspend fun decrypt(messages: List<GroupScoped<EncryptedMessage>>): List<GroupScoped<DecryptedMessage>> =
			messages.mapExactlyChunkedByGroup { groupId, entities ->
				decryptedFlavour.maybeDecrypt(groupId, entities)
			}

		override suspend fun tryDecrypt(messages: List<GroupScoped<EncryptedMessage>>): List<GroupScoped<Message>> =
			messages.mapExactlyChunkedByGroup { groupId, entities ->
				tryAndRecoverFlavour.maybeDecrypt(groupId, entities)
			}

		override suspend fun withEncryptionMetadata(
			entityGroupId: String,
			base: DecryptedMessage?,
			patient: GroupScoped<Patient>?,
			user: User?,
			delegates: @JsMapAsObjectArray(
				keyEntryName = "delegate",
				valueEntryName = "accessLevel"
			) Map<EntityReferenceInGroup, AccessLevel>,
			secretId: SecretIdUseOption,
			alternateRootDelegateReference: EntityReferenceInGroup?
		): GroupScoped<DecryptedMessage> =
			GroupScoped(
				doWithEncryptionMetadata(
					entityGroupId,
					base,
					patient?.let { it.entity to it.groupId },
					user,
					delegates,
					secretId,
					alternateRootDelegateReference
				),
				entityGroupId
			)

		override suspend fun getEncryptionKeysOf(message: GroupScoped<Message>): Set<HexString> =
			doGetEncryptionKeysOf(message.groupId, message.entity)

		override suspend fun hasWriteAccess(message: GroupScoped<Message>): Boolean =
			doHasWriteAccess(message.groupId, message.entity)

		override suspend fun decryptPatientIdOf(message: GroupScoped<Message>): Set<EntityReferenceInGroup> =
			doDecryptPatientIdOf(message.groupId, message.entity).mapNullGroupTo(message.groupId)

		override suspend fun createDelegationDeAnonymizationMetadata(
			entity: GroupScoped<Message>,
			delegates: Set<EntityReferenceInGroup>
		) =
			doCreateDelegationDeAnonymizationMetadata(entity.groupId, entity.entity, delegates)
	}

	override suspend fun withEncryptionMetadata(
		base: DecryptedMessage?,
		patient: Patient?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdUseOption,
		alternateRootDelegateId: String?
	): DecryptedMessage =
		doWithEncryptionMetadata(
			null,
			base,
			patient?.let { it to null },
			user,
			delegates.keyAsLocalDataOwnerReferences(),
			secretId,
			alternateRootDelegateId?.let { EntityReferenceInGroup(it, null) }
		)

	private suspend fun doWithEncryptionMetadata(
		entityGroupId: String?,
		base: DecryptedMessage?,
		patient: Pair<Patient, String?>?,
		user: User?,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "accessLevel") Map<EntityReferenceInGroup, AccessLevel>,
		secretId: SecretIdUseOption,
		alternateRootDataOwnerReference: EntityReferenceInGroup?,
	): DecryptedMessage =
		config.crypto.entity.entityWithInitializedEncryptedMetadata(
			entityGroupId,
			(base ?: DecryptedMessage(config.crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			),
			EntityWithEncryptionMetadataTypeName.Message,
			owningEntityDetails = patient?.let { (patient, patientGroup) ->
				OwningEntityDetails(
					patientGroup,
					patient.id,
					config.crypto.entity.resolveSecretIdOption(
						entityGroupId,
						patient,
						EntityWithEncryptionMetadataTypeName.Patient,
						secretId
					)
				)
			},
			initializeEncryptionKey = true,
			autoDelegations = delegates + user?.autoDelegationsFor(DelegationTag.MedicalInformation)
				.orEmpty().keyAsLocalDataOwnerReferences(),
			alternateRootDataOwnerReference = alternateRootDataOwnerReference,
		).updatedEntity

	override suspend fun getEncryptionKeysOf(message: Message): Set<HexString> =
		doGetEncryptionKeysOf(null, message)

	private suspend fun doGetEncryptionKeysOf(groupId: String?, message: Message): Set<HexString> =
		config.crypto.entity.encryptionKeysOf(
			groupId,
			message,
			EntityWithEncryptionMetadataTypeName.Message,
			null
		)

	override suspend fun hasWriteAccess(message: Message): Boolean =
		doHasWriteAccess(null, message)

	private suspend fun doHasWriteAccess(groupId: String?, message: Message): Boolean =
		config.crypto.entity.hasWriteAccess(groupId, message, EntityWithEncryptionMetadataTypeName.Message)

	override suspend fun decryptPatientIdOf(message: Message): Set<EntityReferenceInGroup> =
		doDecryptPatientIdOf(null, message)

	private suspend fun doDecryptPatientIdOf(groupId: String?, message: Message): Set<EntityReferenceInGroup> =
		config.crypto.entity.owningEntityIdsOf(
			groupId,
			message,
			EntityWithEncryptionMetadataTypeName.Message,
			null
		).mapTo(mutableSetOf()) { config.crypto.entity.parseReference(groupId, it) }

	override suspend fun createDelegationDeAnonymizationMetadata(entity: Message, delegates: Set<String>) =
		doCreateDelegationDeAnonymizationMetadata(groupId = null, entity, delegates.asLocalDataOwnerReferences())

	private suspend fun doCreateDelegationDeAnonymizationMetadata(groupId: String?, entity: Message, delegates: Set<EntityReferenceInGroup>) {
		config.crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(
			groupId,
			entity,
			EntityWithEncryptionMetadataTypeName.Message,
			delegates
		)
	}

	override suspend fun matchMessagesBy(filter: FilterOptions<Message>) =
		rawApi.doMatchMessagesBy(config = config, groupId = null, filter = filter)

	override suspend fun matchMessagesBySorted(filter: SortableFilterOptions<Message>): List<String> =
		rawApi.doMatchMessagesBySorted(config = config, groupId = null, filter = filter)

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: FilterOptions<Message>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedMessage> {
		return WebSocketSubscription.initialize(
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
			entitySerializer = EncryptedMessage.serializer(),
			events = events,
			filter = mapMessageFilterOptions(
				filter,
				config,
				requestGroup = null
			),
			qualifiedName = Message.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(MessageAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}

	override suspend fun decrypt(messages: List<EncryptedMessage>): List<DecryptedMessage> =
		decryptedFlavour.maybeDecrypt(null, messages)

	override suspend fun decrypt(message: EncryptedMessage): DecryptedMessage =
		decrypt(listOf(message)).single()

	override suspend fun tryDecrypt(messages: List<EncryptedMessage>): List<Message> =
		tryAndRecoverFlavour.maybeDecrypt(null, messages)

	override suspend fun tryDecrypt(message: EncryptedMessage): Message =
		tryDecrypt(listOf(message)).single()

	override suspend fun encryptOrValidate(messages: List<Message>): List<EncryptedMessage> =
		tryAndRecoverFlavour.validateAndMaybeEncrypt(null, messages)

	override suspend fun getSecretIdsOf(message: Message): Map<String, Set<EntityReferenceInGroup>> =
		doGetSecretIdsOf(null, message)

	private suspend fun doGetSecretIdsOf(groupId: String?, message: Message): Map<String, Set<EntityReferenceInGroup>> =
		ensureNonNull(config.crypto.entity.secretIdsWithDataOwnersInfo(groupId, listOf(message), EntityWithEncryptionMetadataTypeName.Patient).values.singleOrNull()) {
			"Method secretIdsWithDataOwnersInfo should have returned single item for single message"
		}
}

@InternalIcureApi
internal fun initMessageBasicApi(
	rawApi: RawMessageApi,
	config: BasicApiConfiguration
): MessageBasicApi = MessageBasicApiImpl(
	rawApi,
	config,
	AbstractMessageBasicFlavouredApi(rawApi, config, encryptedApiFlavour(config))
)

@InternalIcureApi
private class MessageBasicApiImpl(
	private val rawApi: RawMessageApi,
	private val config: BasicApiConfiguration,
	private val encryptedFlavour: AbstractMessageBasicFlavouredApi<EncryptedMessage>,
) : MessageBasicApi,
	MessageBasicFlavouredApi<EncryptedMessage> by encryptedFlavour,
	MessageBasicFlavourlessApi by MessageBasicFlavourlessApiImpl(rawApi) {
	override val inGroup: MessageBasicInGroupApi = object : MessageBasicInGroupApi,
		MessageBasicFlavouredInGroupApi<EncryptedMessage> by encryptedFlavour,
		MessageBasicFlavourlessInGroupApi by MessageBasicFlavourlessInGroupApiImpl(rawApi) {

		override suspend fun matchMessagesBy(groupId: String, filter: BaseFilterOptions<Message>): List<String> =
			rawApi.doMatchMessagesBy(config = config, groupId = groupId, filter = filter)

		override suspend fun matchMessagesBySorted(groupId: String, filter: BaseSortableFilterOptions<Message>): List<String> =
			rawApi.doMatchMessagesBySorted(config = config, groupId = groupId, filter = filter)

		override suspend fun filterMessagesBy(groupId: String, filter: BaseFilterOptions<Message>): PaginatedListIterator<GroupScoped<EncryptedMessage>> =
			IdsPageIterator(matchMessagesBy(groupId, filter)) { ids ->
				encryptedFlavour.doGetMessages(groupId, ids).map { GroupScoped(it, groupId) }
			}

		override suspend fun filterMessagesBySorted(groupId: String, filter: BaseSortableFilterOptions<Message>): PaginatedListIterator<GroupScoped<EncryptedMessage>> =
			filterMessagesBy(groupId, filter)
	}

	override suspend fun matchMessagesBy(filter: BaseFilterOptions<Message>): List<String> =
		rawApi.doMatchMessagesBy(config = config, groupId = null, filter = filter)

	override suspend fun matchMessagesBySorted(filter: BaseSortableFilterOptions<Message>): List<String> =
		rawApi.doMatchMessagesBy(config = config, groupId = null, filter = filter)

	override suspend fun filterMessagesBy(filter: BaseFilterOptions<Message>): PaginatedListIterator<EncryptedMessage> =
		IdsPageIterator(matchMessagesBy(filter), this::getMessages)

	override suspend fun filterMessagesBySorted(filter: BaseSortableFilterOptions<Message>): PaginatedListIterator<EncryptedMessage> =
		filterMessagesBy(filter)

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: BaseFilterOptions<Message>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedMessage> {
		return WebSocketSubscription.initialize(
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
			entitySerializer = EncryptedMessage.serializer(),
			events = events,
			filter = mapMessageFilterOptions(filter, config, null),
			qualifiedName = Message.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(MessageAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}
}
