package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.DocumentBasicFlavouredInGroupApi
import com.icure.cardinal.sdk.api.DocumentBasicFlavourlessInGroupApi
import com.icure.cardinal.sdk.api.DocumentBasicInGroupApi
import com.icure.cardinal.sdk.api.DocumentBasicApi
import com.icure.cardinal.sdk.api.DocumentFlavouredInGroupApi
import com.icure.cardinal.sdk.api.DocumentInGroupApi
import com.icure.cardinal.sdk.api.DocumentApi
import com.icure.cardinal.sdk.api.DocumentBasicFlavouredApi
import com.icure.cardinal.sdk.api.DocumentBasicFlavourlessApi
import com.icure.cardinal.sdk.api.DocumentFlavouredApi
import com.icure.cardinal.sdk.api.raw.RawDocumentApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.entities.DocumentShareOptions
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.OwningEntityDetails
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.exceptions.NotFoundException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.filters.mapDocumentFilterOptions
import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.DecryptedDocument
import com.icure.cardinal.sdk.model.EncryptedDocument
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.Message
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
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.cardinal.sdk.utils.generation.JsMapAsObjectArray
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.utils.InternalIcureApi

@InternalIcureApi
private fun encryptedApiFlavour(
	config: BasicApiConfiguration
): FlavouredApi<EncryptedDocument, EncryptedDocument> = FlavouredApi.encrypted(
	config = config,
	encryptedSerializer = EncryptedDocument.serializer(),
	type = EntityWithEncryptionMetadataTypeName.Document,
	manifest = EntitiesEncryptedFieldsManifests::document
)

@InternalIcureApi
private fun decryptedApiFlavour(
	config: ApiConfiguration
): FlavouredApi<EncryptedDocument, DecryptedDocument> = FlavouredApi.decrypted(
	config = config,
	encryptedSerializer = EncryptedDocument.serializer(),
	decryptedSerializer = DecryptedDocument.serializer(),
	type = EntityWithEncryptionMetadataTypeName.Document,
	manifest = EntitiesEncryptedFieldsManifests::document,
	patchJson = JsonPatcher::patchDocument
)

@InternalIcureApi
private fun tryAndRecoverApiFlavour(
	config: ApiConfiguration
): FlavouredApi<EncryptedDocument, Document> = FlavouredApi.tryAndRecover(
	config = config,
	encryptedSerializer = EncryptedDocument.serializer(),
	decryptedSerializer = DecryptedDocument.serializer(),
	type = EntityWithEncryptionMetadataTypeName.Document,
	manifest = EntitiesEncryptedFieldsManifests::document,
	patchJson = JsonPatcher::patchDocument
)

@InternalIcureApi
private open class AbstractDocumentBasicFlavouredApi<E : Document>(
	protected val rawApi: RawDocumentApi,
	protected open val config: BasicApiConfiguration,
	protected val flavour: FlavouredApi<EncryptedDocument, E>
) : DocumentBasicFlavouredApi<E>,
	DocumentBasicFlavouredInGroupApi<E>,
	FlavouredApi<EncryptedDocument, E> by flavour {

	override suspend fun createDocument(entity: E): E = doCreateDocument(groupId = null, entity = entity)

	override suspend fun createDocument(entity: GroupScoped<E>): GroupScoped<E> = groupScopedWith(entity) { groupId, it ->
		doCreateDocument(groupId = groupId, entity = it)
	}

	private suspend fun doCreateDocument(groupId: String?, entity: E): E {
		requireIsValidForCreation(entity)
		val encrypted = validateAndMaybeEncrypt(groupId, entity)
		return if (groupId == null) {
			rawApi.createDocument(encrypted)
		} else {
			rawApi.createDocumentInGroup(groupId, encrypted)
		}.successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	override suspend fun createDocuments(entities: List<E>): List<E> {
		requireIsValidForCreation(entities)
		return doCreateDocuments(groupId = null, entities = entities)
	}

	override suspend fun createDocuments(entities: List<GroupScoped<E>>): List<GroupScoped<E>> {
		requireIsValidForCreationInGroup(entities)
		return entities.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doCreateDocuments(groupId = groupId, entities = chunk)
		}
	}

	private suspend fun doCreateDocuments(groupId: String?, entities: List<E>): List<E> = skipRequestOnEmptyList(entities) { documents ->
		val encrypted = validateAndMaybeEncrypt(groupId, documents)
		if (groupId == null) {
			rawApi.createDocuments(encrypted)
		} else {
			rawApi.createDocumentsInGroup(groupId, encrypted)
		}.successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	override suspend fun undeleteDocumentById(id: String, rev: String): E = doUndeleteDocument(groupId = null, entityId = id, rev = rev)

	override suspend fun undeleteDocumentById(entityId: GroupScoped<StoredDocumentIdentifier>) = groupScopedWith(entityId) { groupId, it ->
		doUndeleteDocument(groupId = groupId, entityId = it.id, rev = it.rev)
	}

	private suspend fun doUndeleteDocument(groupId: String?, entityId: String, rev: String): E =
		if (groupId == null) {
			rawApi.undeleteDocument(entityId, rev)
		} else {
			rawApi.undeleteDocumentInGroup(groupId = groupId, documentId = entityId, rev = rev)
		}.successBodyOrThrowRevisionConflict().let { maybeDecrypt(groupId, it) }

	override suspend fun undeleteDocumentsByIds(entityIds: List<StoredDocumentIdentifier>): List<E> =
		doUndeleteDocuments(groupId = null, entityIds = entityIds)

	override suspend fun undeleteDocumentsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<E>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doUndeleteDocuments(groupId = groupId, entityIds = chunk)
		}

	private suspend fun doUndeleteDocuments(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<E> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.undeleteDocuments(ListOfIdsAndRev(ids))
			} else {
				rawApi.undeleteDocumentsInGroup(groupId, ListOfIdsAndRev(ids))
			}.successBody().let { maybeDecrypt(entitiesGroupId = groupId, entities = it) }
		}

	override suspend fun modifyDocument(entity: E) = doModifyDocument(groupId = null, entity = entity)

	override suspend fun modifyDocument(entity: GroupScoped<E>): GroupScoped<E> = groupScopedWith(entity) { groupId, it ->
		doModifyDocument(groupId = groupId, entity = it)
	}

	private suspend fun doModifyDocument(groupId: String?, entity: E): E {
		requireIsValidForModification(entity)
		val encrypted = validateAndMaybeEncrypt(groupId, entity)
		return if (groupId == null) {
			rawApi.modifyDocument(encrypted)
		} else {
			rawApi.modifyDocumentInGroup(groupId, encrypted)
		}.successBodyOrThrowRevisionConflict().let {
			maybeDecrypt(groupId, it)
		}
	}

	override suspend fun modifyDocuments(entities: List<E>): List<E> {
		requireIsValidForModification(entities)
		return doModifyDocuments(groupId = null, entities = entities)
	}

	override suspend fun modifyDocuments(entities: List<GroupScoped<E>>): List<GroupScoped<E>> {
		requireIsValidForModificationInGroup(entities)
		return entities.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doModifyDocuments(groupId = groupId, entities = chunk)
		}
	}

	private suspend fun doModifyDocuments(groupId: String?, entities: List<E>): List<E> = skipRequestOnEmptyList(entities) { documents ->
		val encrypted = validateAndMaybeEncrypt(groupId, documents)
		return if (groupId == null) {
			rawApi.modifyDocuments(encrypted)
		} else {
			rawApi.modifyDocumentsInGroup(groupId, encrypted)
		}.successBodyOrThrowRevisionConflict().let {
			maybeDecrypt(groupId, it)
		}
	}

	override suspend fun getDocument(entityId: String) = doGetDocument(groupId = null, entityId = entityId)

	override suspend fun getDocument(groupId: String, entityId: String): GroupScoped<E>? = groupScopedIn(groupId) {
		doGetDocument(groupId = groupId, entityId = entityId)
	}

	protected suspend fun doGetDocument(groupId: String?, entityId: String): E? =
		if (groupId == null) {
			rawApi.getDocument(entityId)
		} else {
			rawApi.getDocumentInGroup(groupId = groupId, documentId = entityId)
		}.successBodyOrNull404()?.let {
			maybeDecrypt(groupId, it)
		}

	override suspend fun getDocuments(entityIds: List<String>) = doGetDocuments(groupId = null, entityIds = entityIds)

	override suspend fun getDocuments(groupId: String, entityIds: List<String>): List<GroupScoped<E>> = groupScopedListIn(groupId) {
		doGetDocuments(groupId = groupId, entityIds = entityIds)
	}

	suspend fun doGetDocuments(groupId: String?, entityIds: List<String>): List<E> = skipRequestOnEmptyList(entityIds) { ids ->
		if (groupId == null) {
			rawApi.getDocuments(ListOfIds(ids))
		} else {
			rawApi.getDocumentsInGroup(groupId, ListOfIds(ids))
		}.successBody().let { maybeDecrypt(groupId, it) }
	}

}

@InternalIcureApi
private class AbstractDocumentFlavouredApi<E : Document>(
	rawApi: RawDocumentApi,
	override val config: ApiConfiguration,
	flavour: FlavouredApi<EncryptedDocument, E>
) : AbstractDocumentBasicFlavouredApi<E>(rawApi, config, flavour),
	DocumentFlavouredApi<E>,
	DocumentFlavouredInGroupApi<E> {

	override suspend fun shareWith(
		delegateId: String,
		document: E,
		options: DocumentShareOptions?,
	): E =
		shareWithMany(document, mapOf(Pair(delegateId, options ?: DocumentShareOptions())))

	override suspend fun shareWith(
		delegate: EntityReferenceInGroup,
		document: GroupScoped<E>,
		options: DocumentShareOptions?
	): GroupScoped<E> = shareWithMany(document, mapOf(delegate to (options ?: DocumentShareOptions())))

	override suspend fun shareWithMany(document: E, delegates: Map<String, DocumentShareOptions>): E =
		doShareWithMany(groupId = null, document = document, delegates = delegates.keyAsLocalDataOwnerReferences())

	override suspend fun shareWithMany(
		document: GroupScoped<E>,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, DocumentShareOptions>
	): GroupScoped<E> = groupScopedWith(document) { groupId, entity ->
		doShareWithMany(groupId = groupId, document = entity, delegates = delegates)
	}

	private suspend fun doShareWithMany(
		groupId: String?,
		document: E,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, DocumentShareOptions>
	): E =
		config.crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			entityGroupId = groupId,
			entity = document,
			entityType = EntityWithEncryptionMetadataTypeName.Document,
			delegates = delegates,
			autoRetry = true,
			getUpdatedEntity = { doGetDocument(groupId, it) ?: throw NotFoundException("Document $it not found") },
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

	override suspend fun filterDocumentsBySorted(filter: SortableFilterOptions<Document>): PaginatedListIterator<E> =
		filterDocumentsBy(filter)

	override suspend fun filterDocumentsBy(filter: FilterOptions<Document>): PaginatedListIterator<E> =
		doFilterDocumentsBy(
			null,
			filter
		) { it }

	override suspend fun filterDocumentsBySorted(
		groupId: String,
		filter: SortableFilterOptions<Document>
	): PaginatedListIterator<GroupScoped<E>> =
		filterDocumentsBy(groupId, filter)

	override suspend fun filterDocumentsBy(
		groupId: String,
		filter: FilterOptions<Document>
	): PaginatedListIterator<GroupScoped<E>> =
		doFilterDocumentsBy(
			groupId,
			filter
		) { GroupScoped(it, groupId) }

	private suspend inline fun <T : Any> doFilterDocumentsBy(
		groupId: String?,
		filter: FilterOptions<Document>,
		crossinline mapEntity: (E) -> T
	): PaginatedListIterator<T> =
		IdsPageIterator(
			rawApi.matchDocumentsBy(
				mapDocumentFilterOptions(
					filter,
					config,
					groupId
				)
			).successBody(),
		) {
			doGetDocuments(groupId, it).map { document -> mapEntity(document) }
		}
}

@InternalIcureApi
private abstract class AbstractDocumentBasicFlavourless(
	protected val rawApi: RawDocumentApi
) {

	protected suspend fun doDeleteDocument(groupId: String?, entityId: String, rev: String): StoredDocumentIdentifier =
		if (groupId == null) {
			rawApi.deleteDocument(entityId, rev)
		} else {
			rawApi.deleteDocumentInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict().toStoredDocumentIdentifier()

	protected suspend fun doDeleteDocuments(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.deleteDocumentsWithRev(ListOfIdsAndRev(ids))
			} else {
				rawApi.deleteDocumentsInGroup(groupId, ListOfIdsAndRev(ids))
			}.successBody().toStoredDocumentIdentifier()
		}

	protected suspend fun doPurgeDocument(groupId: String?, entityId: String, rev: String) {
		if (groupId == null) {
			rawApi.purgeDocument(entityId, rev)
		} else {
			rawApi.purgeDocumentInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doPurgeDocuments(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.purgeDocuments(ListOfIdsAndRev(ids))
			} else {
				rawApi.purgeDocumentsInGroup(groupId, ListOfIdsAndRev(ids))
			}.successBody().toStoredDocumentIdentifier()
		}
}

@InternalIcureApi
private class DocumentBasicFlavourlessApiImpl(rawApi: RawDocumentApi) : AbstractDocumentBasicFlavourless(rawApi), DocumentBasicFlavourlessApi {

	override suspend fun deleteDocumentById(entityId: String, rev: String): StoredDocumentIdentifier =
		doDeleteDocument(groupId = null, entityId = entityId, rev = rev)

	override suspend fun deleteDocumentsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doDeleteDocuments(groupId = null, entityIds = entityIds)

	override suspend fun purgeDocumentById(id: String, rev: String) {
		doPurgeDocument(groupId = null, entityId = id, rev = rev)
	}

	override suspend fun purgeDocumentsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doPurgeDocuments(groupId = null, entityIds = entityIds)

	override suspend fun getRawMainAttachment(documentId: String) =
		rawApi.getMainAttachment(documentId).successBody()

	override suspend fun getRawSecondaryAttachment(documentId: String, key: String) =
		rawApi.getSecondaryAttachment(documentId, key).successBody()

	override suspend fun setRawMainAttachment(
		documentId: String,
		rev: String,
		utis: List<String>?,
		attachment: ByteArray,
		encrypted: Boolean,
	) =
		rawApi.setDocumentAttachment(documentId, rev, utis, attachment, attachment.size.toLong(), encrypted).successBody()

	override suspend fun setRawSecondaryAttachment(
		documentId: String,
		key: String,
		rev: String,
		utis: List<String>?,
		attachment: ByteArray,
		encrypted: Boolean,
	) =
		rawApi.setSecondaryAttachment(documentId, key, rev, utis, attachment, attachment.size.toLong(), encrypted).successBody()

	override suspend fun deleteMainAttachment(entityId: String, rev: String) =
		rawApi.deleteAttachment(entityId, rev).successBody()

	override suspend fun deleteSecondaryAttachment(documentId: String, key: String, rev: String) =
		rawApi.deleteSecondaryAttachment(documentId, key, rev).successBody()
}

@InternalIcureApi
private class DocumentBasicFlavourlessInGroupApiImpl(rawApi: RawDocumentApi) : AbstractDocumentBasicFlavourless(rawApi), DocumentBasicFlavourlessInGroupApi {
	override suspend fun deleteDocumentById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier> =
		groupScopedWith(entityId) { groupId, it ->
			doDeleteDocument(groupId = groupId, entityId = it.id, rev = it.rev)
		}

	override suspend fun deleteDocumentsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, entities ->
			doDeleteDocuments(groupId, entities)
		}

	override suspend fun purgeDocumentById(entityId: GroupScoped<StoredDocumentIdentifier>) {
		doPurgeDocument(groupId = entityId.groupId, entityId = entityId.entity.id, rev = entityId.entity.rev)
	}

	override suspend fun purgeDocumentsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, batch ->
			doPurgeDocuments(groupId, batch)
		}
}

@InternalIcureApi
internal fun initDocumentApi(
	rawApi: RawDocumentApi,
	config: ApiConfiguration
): DocumentApi {
	val decryptedFlavour = decryptedApiFlavour(config)
	val encryptedFlavour = encryptedApiFlavour(config)
	val tryAndRecoverFlavour = tryAndRecoverApiFlavour(config)
	val decryptedApi = AbstractDocumentFlavouredApi(rawApi, config, decryptedFlavour)
	val encryptedApi = AbstractDocumentFlavouredApi(rawApi, config, encryptedFlavour)
	val tryAndRecoverApi = AbstractDocumentFlavouredApi(rawApi, config, tryAndRecoverFlavour)
	return DocumentApiImpl(
		rawApi,
		config,
		encryptedApi,
		decryptedApi,
		tryAndRecoverApi
	)
}

@InternalIcureApi
private class DocumentApiImpl(
	private val rawApi: RawDocumentApi,
	private val config: ApiConfiguration,
	private val encryptedFlavour: AbstractDocumentFlavouredApi<EncryptedDocument>,
	private val decryptedFlavour: AbstractDocumentFlavouredApi<DecryptedDocument>,
	private val tryAndRecoverFlavour: AbstractDocumentFlavouredApi<Document>
) : DocumentApi,
	DocumentBasicFlavourlessApi by DocumentBasicFlavourlessApiImpl(rawApi),
	DocumentFlavouredApi<DecryptedDocument> by decryptedFlavour {
	override val encrypted: DocumentFlavouredApi<EncryptedDocument> = encryptedFlavour

	override val tryAndRecover: DocumentFlavouredApi<Document> = tryAndRecoverFlavour

	private val crypto get() = config.crypto

	override val inGroup: DocumentInGroupApi = object : DocumentInGroupApi,
		DocumentBasicFlavourlessInGroupApi by DocumentBasicFlavourlessInGroupApiImpl(rawApi),
		DocumentFlavouredInGroupApi<DecryptedDocument> by decryptedFlavour {
		override val encrypted: DocumentFlavouredInGroupApi<EncryptedDocument> = encryptedFlavour
		override val tryAndRecover: DocumentFlavouredInGroupApi<Document> = tryAndRecoverFlavour

		override suspend fun withEncryptionMetadataLinkedToMessage(
			entityGroupId: String,
			base: DecryptedDocument?,
			message: GroupScoped<Message>,
			user: User?,
			delegates: Map<String, AccessLevel>,
			secretId: SecretIdUseOption,
			alternateRootDelegateId: String?,
		): GroupScoped<DecryptedDocument> = GroupScoped(
			doWithEncryptionMetadata(
				base,
				user,
				delegates,
				alternateRootDelegateId,
				OwningEntityDetails(
					entityGroupId,
					message.entity.id,
					crypto.entity.resolveSecretIdOption(entityGroupId, message.entity, EntityWithEncryptionMetadataTypeName.Message, secretId)
				)
			),
			entityGroupId,
		)

		override suspend fun withEncryptionMetadataLinkedToPatient(
			entityGroupId: String,
			base: DecryptedDocument?,
			patient: GroupScoped<Patient>,
			user: User?,
			delegates: Map<String, AccessLevel>,
			secretId: SecretIdUseOption,
			alternateRootDelegateId: String?,
		): GroupScoped<DecryptedDocument> = GroupScoped(
			doWithEncryptionMetadata(
				base,
				user,
				delegates,
				alternateRootDelegateId,
				OwningEntityDetails(
					entityGroupId,
					patient.entity.id,
					crypto.entity.resolveSecretIdOption(entityGroupId, patient.entity, EntityWithEncryptionMetadataTypeName.Patient, secretId)
				)
			),
			entityGroupId,
		)

		override suspend fun withEncryptionMetadataUnlinked(
			entityGroupId: String,
			base: DecryptedDocument?,
			user: User?,
			delegates: Map<String, AccessLevel>,
			alternateRootDelegateId: String?,
		): GroupScoped<DecryptedDocument> = GroupScoped(
			doWithEncryptionMetadata(
				base,
				user,
				delegates,
				alternateRootDelegateId,
				null
			),
			entityGroupId,
		)

		override suspend fun decrypt(documents: List<GroupScoped<EncryptedDocument>>): List<GroupScoped<DecryptedDocument>> =
			documents.mapExactlyChunkedByGroup { groupId, entities ->
				decryptedFlavour.maybeDecrypt(groupId, entities)
			}

		override suspend fun tryDecrypt(documents: List<GroupScoped<EncryptedDocument>>): List<GroupScoped<Document>> =
			documents.mapExactlyChunkedByGroup { groupId, entities ->
				tryAndRecoverFlavour.maybeDecrypt(groupId, entities)
			}

		override suspend fun createDelegationDeAnonymizationMetadata(
			entity: GroupScoped<Document>,
			delegates: Set<EntityReferenceInGroup>
		) = doCreateDelegationDeAnonymizationMetadata(entity.groupId, entity.entity, delegates)

		override suspend fun getEncryptionKeysOf(document: GroupScoped<Document>): Set<HexString> =
			doGetEncryptionKeysOf(document.groupId, document.entity)

		override suspend fun hasWriteAccess(document: GroupScoped<Document>): Boolean =
			doHasWriteAccess(document.groupId, document.entity)

		override suspend fun decryptOwningEntityIdsOf(document: GroupScoped<Document>): Set<EntityReferenceInGroup> =
			doDecryptOwningEntityIdsOf(document.groupId, document.entity)

		override suspend fun matchDocumentsBy(groupId: String, filter: FilterOptions<Document>): List<String> =
			doMatchDocumentsBy(groupId, filter)

		override suspend fun matchDocumentsBySorted(
			groupId: String,
			filter: SortableFilterOptions<Document>
		): List<String> = doMatchDocumentsBySorted(groupId, filter)
	}

	override suspend fun withEncryptionMetadataLinkedToPatient(
		base: DecryptedDocument?,
		patient: Patient,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdUseOption,
		alternateRootDelegateId: String?
	): DecryptedDocument =
		doWithEncryptionMetadata(
			base,
			user,
			delegates,
			alternateRootDelegateId,
			OwningEntityDetails(
				null,
				patient.id,
				crypto.entity.resolveSecretIdOption(null, patient, EntityWithEncryptionMetadataTypeName.Patient, secretId)
			)
		)

	override suspend fun withEncryptionMetadataLinkedToMessage(
		base: DecryptedDocument?,
		message: Message,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdUseOption,
		alternateRootDelegateId: String?
	): DecryptedDocument =
		doWithEncryptionMetadata(
			base,
			user,
			delegates,
			alternateRootDelegateId,
			OwningEntityDetails(
				null,
				message.id,
				crypto.entity.resolveSecretIdOption(null, message, EntityWithEncryptionMetadataTypeName.Message, secretId)
			)
		)

	override suspend fun withEncryptionMetadataUnlinked(
		base: DecryptedDocument?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		alternateRootDelegateId: String?
	): DecryptedDocument =
		doWithEncryptionMetadata(base, user, delegates, alternateRootDelegateId, null)

	private suspend fun doWithEncryptionMetadata(
		base: DecryptedDocument?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		alternateRootDelegateId: String?,
		owningEntityDetails: OwningEntityDetails?,
	) =
		crypto.entity.entityWithInitializedEncryptedMetadata(
			entityGroupId = null,
			entity = (base ?: DecryptedDocument(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			),
			entityType = EntityWithEncryptionMetadataTypeName.Document,
			owningEntityDetails = owningEntityDetails,
			initializeEncryptionKey = true,
			autoDelegations = (delegates + user?.autoDelegationsFor(DelegationTag.MedicalInformation).orEmpty()).keyAsLocalDataOwnerReferences(),
			alternateRootDataOwnerReference = alternateRootDelegateId?.let { EntityReferenceInGroup(it, null) },
		).updatedEntity


	override suspend fun getAndTryDecryptMainAttachment(
		document: Document,
		decryptedAttachmentValidator: (suspend (document: ByteArray) -> Boolean)?
	): ByteArray? = getRawMainAttachment(document.id).let {
			crypto.entity.tryDecryptAttachmentOf(null, document, EntityWithEncryptionMetadataTypeName.Document, it, decryptedAttachmentValidator)
		}

	override suspend fun getAndDecryptMainAttachment(
		document: Document,
		decryptedAttachmentValidator: (suspend (document: ByteArray) -> Boolean)?
	) =
		rawApi.getMainAttachment(document.id).successBody().let {
			crypto.entity.decryptAttachmentOf(null, document, EntityWithEncryptionMetadataTypeName.Document, it, decryptedAttachmentValidator)
		}

	override suspend fun encryptAndSetMainAttachment(document: Document, utis: List<String>?, attachment: ByteArray): EncryptedDocument {
		val aesKey = crypto.entity.tryDecryptAndImportAnyEncryptionKey(null, listOf(document), EntityWithEncryptionMetadataTypeName.Document)[document.id]?.key
			?: throw EntityEncryptionException("Cannot extract encryption key from document")
		val payload = crypto.primitives.aes.encrypt(attachment, aesKey)
		return rawApi.setDocumentAttachment(
			document.id,
			document.rev ?: throw IllegalArgumentException("Document must have a revision set before setting the attachment"),
			utis,
			payload,
			attachment.size.toLong(),
			true,
		).successBody()
	}

	override suspend fun getAndDecryptSecondaryAttachment(
		document: Document,
		key: String,
		decryptedAttachmentValidator: (suspend (document: ByteArray) -> Boolean)?
	) =
		rawApi.getSecondaryAttachment(document.id, key).successBody().let {
			crypto.entity.decryptAttachmentOf(null, document, EntityWithEncryptionMetadataTypeName.Document, it, decryptedAttachmentValidator)
		}

	override suspend fun encryptAndSetSecondaryAttachment(
		document: Document,
		key: String,
		utis: List<String>?,
		attachment: ByteArray,
	): EncryptedDocument {
		val aesKey = crypto.entity.tryDecryptAndImportAnyEncryptionKey(null, listOf(document), EntityWithEncryptionMetadataTypeName.Document)[document.id]?.key
			?: throw EntityEncryptionException("Cannot extract encryption key from document")
		val payload = crypto.primitives.aes.encrypt(attachment, aesKey)
		return rawApi.setSecondaryAttachment(
			document.id,
			key,
			document.rev ?: throw IllegalArgumentException("Document must have a revision set before setting the attachment"),
			utis,
			payload,
			attachment.size.toLong(),
			true,
		).successBody()
	}

	override suspend fun getEncryptionKeysOf(document: Document): Set<HexString> = doGetEncryptionKeysOf(groupId = null, document = document)

	private suspend fun doGetEncryptionKeysOf(groupId: String?, document: Document): Set<HexString> =
		crypto.entity.encryptionKeysOf(groupId, document, EntityWithEncryptionMetadataTypeName.Document, null)

	override suspend fun hasWriteAccess(document: Document): Boolean = doHasWriteAccess(groupId = null, document = document)

	private suspend fun doHasWriteAccess(groupId: String?, document: Document): Boolean =
		crypto.entity.hasWriteAccess(groupId, document, EntityWithEncryptionMetadataTypeName.Document)

	override suspend fun decryptOwningEntityIdsOf(document: Document): Set<EntityReferenceInGroup> =
		doDecryptOwningEntityIdsOf(groupId = null, document = document)

	private suspend fun doDecryptOwningEntityIdsOf(groupId: String?, document: Document): Set<EntityReferenceInGroup> =
		crypto.entity.owningEntityIdsOf(
			entityGroupId = groupId,
			entity = document,
			entityType = EntityWithEncryptionMetadataTypeName.Document,
			dataOwnerId = null
		).mapTo(mutableSetOf()) {
			crypto.entity.parseReference(groupId, it)
		}

	override suspend fun createDelegationDeAnonymizationMetadata(entity: Document, delegates: Set<String>) {
		doCreateDelegationDeAnonymizationMetadata(entityGroupId = null, entity = entity, delegates = delegates.asLocalDataOwnerReferences())
	}

	private suspend fun doCreateDelegationDeAnonymizationMetadata(
		entityGroupId: String?,
		entity: Document,
		delegates: Set<EntityReferenceInGroup>
	) {
		crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(entityGroupId, entity, EntityWithEncryptionMetadataTypeName.Document, delegates)
	}

	override suspend fun decrypt(document: EncryptedDocument): DecryptedDocument =
		decryptedFlavour.maybeDecrypt(listOf(document)).single()

	override suspend fun tryDecrypt(document: EncryptedDocument): Document =
		tryAndRecoverFlavour.maybeDecrypt(listOf(document)).single()

	override suspend fun tryDecryptAttachment(
		document: Document,
		encryptedAttachment: ByteArray,
		decryptedAttachmentValidator: (suspend (document: ByteArray) -> Boolean)?
	): ByteArray? =
		crypto.entity.tryDecryptAttachmentOf(null, document, EntityWithEncryptionMetadataTypeName.Document, encryptedAttachment, decryptedAttachmentValidator)

	override suspend fun matchDocumentsBy(filter: FilterOptions<Document>): List<String> =
		doMatchDocumentsBy(groupId = null, filter = filter)

	override suspend fun matchDocumentsBySorted(filter: SortableFilterOptions<Document>): List<String> =
		doMatchDocumentsBySorted(groupId = null, filter = filter)

	private suspend fun doMatchDocumentsBy(groupId: String?, filter: FilterOptions<Document>): List<String> =
		if (groupId == null) {
			rawApi.matchDocumentsBy(
				mapDocumentFilterOptions(
					filter,
					config,
					groupId
				)
			).successBody()
		} else {
			rawApi.matchDocumentsInGroupBy(
				groupId = groupId,
				filter = mapDocumentFilterOptions(
					filter,
					config,
					groupId
				)
			).successBody()
		}

	private suspend fun doMatchDocumentsBySorted(groupId: String?, filter: FilterOptions<Document>): List<String> =
		doMatchDocumentsBy(groupId, filter)
}

@InternalIcureApi
internal fun initDocumentBasicApi(
	rawApi: RawDocumentApi,
	config: BasicApiConfiguration
): DocumentBasicApi = DocumentBasicApiImpl(
	rawApi,
	config,
	AbstractDocumentBasicFlavouredApi(rawApi, config, encryptedApiFlavour(config))
)

@InternalIcureApi
private class DocumentBasicApiImpl(
	private val rawApi: RawDocumentApi,
	private val config: BasicApiConfiguration,
	private val encryptedFlavour: AbstractDocumentBasicFlavouredApi<EncryptedDocument>
) : DocumentBasicApi,
	DocumentBasicFlavouredApi<EncryptedDocument> by encryptedFlavour,
	DocumentBasicFlavourlessApi by DocumentBasicFlavourlessApiImpl(rawApi) {

	override val inGroup: DocumentBasicInGroupApi = object : DocumentBasicInGroupApi,
		DocumentBasicFlavourlessInGroupApi by DocumentBasicFlavourlessInGroupApiImpl(rawApi),
		DocumentBasicFlavouredInGroupApi<EncryptedDocument> by encryptedFlavour {

		override suspend fun matchDocumentsBy(
			groupId: String,
			filter: BaseFilterOptions<Document>
		): List<String> = doMatchDocumentsBy(groupId, filter)

		override suspend fun matchDocumentsBySorted(
			groupId: String,
			filter: BaseSortableFilterOptions<Document>
		): List<String> =
			matchDocumentsBy(groupId, filter)

		override suspend fun filterDocumentsBy(
			groupId: String,
			filter: BaseFilterOptions<Document>
		): PaginatedListIterator<GroupScoped<EncryptedDocument>> =
			doFilterDocumentsBy(groupId, filter) { GroupScoped(it, groupId) }

		override suspend fun filterDocumentsBySorted(
			groupId: String,
			filter: BaseSortableFilterOptions<Document>
		): PaginatedListIterator<GroupScoped<EncryptedDocument>> =
			filterDocumentsBy(groupId, filter)
	}

	override suspend fun matchDocumentsBy(filter: BaseFilterOptions<Document>): List<String> =
		doMatchDocumentsBy(groupId = null, filter = filter)

	override suspend fun matchDocumentsBySorted(filter: BaseSortableFilterOptions<Document>): List<String> =
		matchDocumentsBy(filter)

	override suspend fun filterDocumentsBy(filter: BaseFilterOptions<Document>): PaginatedListIterator<EncryptedDocument> =
		doFilterDocumentsBy(groupId = null, filter = filter) { it }

	override suspend fun filterDocumentsBySorted(filter: BaseSortableFilterOptions<Document>): PaginatedListIterator<EncryptedDocument> =
		doFilterDocumentsBy(groupId = null, filter = filter) { it }

	private suspend fun doMatchDocumentsBy(groupId: String?, filter: BaseFilterOptions<Document>): List<String> =
		if (groupId == null) {
			rawApi.matchDocumentsBy(
				mapDocumentFilterOptions(
					filter,
					config,
					groupId
				)
			).successBody()
		} else {
			rawApi.matchDocumentsInGroupBy(
				groupId = groupId,
				filter = mapDocumentFilterOptions(
					filter,
					config,
					groupId
				)
			).successBody()
		}

	private suspend inline fun <T : Any> doFilterDocumentsBy(
		groupId: String?,
		filter: BaseFilterOptions<Document>,
		crossinline mapEntity: (EncryptedDocument) -> T
	): PaginatedListIterator<T> =
		IdsPageIterator(
			doMatchDocumentsBy(groupId, filter),
		) {
			encryptedFlavour.doGetDocuments(groupId, it).map { calendarItem -> mapEntity(calendarItem) }
		}
}
