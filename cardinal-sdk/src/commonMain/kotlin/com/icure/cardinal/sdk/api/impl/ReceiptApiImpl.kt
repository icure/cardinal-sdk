package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.ReceiptApi
import com.icure.cardinal.sdk.api.ReceiptBasicApi
import com.icure.cardinal.sdk.api.ReceiptBasicFlavouredApi
import com.icure.cardinal.sdk.api.ReceiptBasicFlavouredInGroupApi
import com.icure.cardinal.sdk.api.ReceiptBasicFlavourlessApi
import com.icure.cardinal.sdk.api.ReceiptBasicFlavourlessInGroupApi
import com.icure.cardinal.sdk.api.ReceiptBasicInGroupApi
import com.icure.cardinal.sdk.api.ReceiptFlavouredApi
import com.icure.cardinal.sdk.api.ReceiptFlavouredInGroupApi
import com.icure.cardinal.sdk.api.ReceiptInGroupApi
import com.icure.cardinal.sdk.api.raw.RawReceiptApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.OwningEntityDetails
import com.icure.cardinal.sdk.crypto.entities.ReceiptShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.exceptions.NotFoundException
import com.icure.cardinal.sdk.model.DecryptedReceipt
import com.icure.cardinal.sdk.model.EncryptedReceipt
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.Receipt
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
import com.icure.utils.InternalIcureApi

@InternalIcureApi
private fun encryptedApiFlavour(
	config: BasicApiConfiguration
): FlavouredApi<EncryptedReceipt, EncryptedReceipt> = FlavouredApi.encrypted(
	config = config,
	encryptedSerializer = EncryptedReceipt.serializer(),
	type = EntityWithEncryptionMetadataTypeName.Receipt,
	manifest = EntitiesEncryptedFieldsManifests::receipt
)

@InternalIcureApi
private fun decryptedApiFlavour(
	config: ApiConfiguration
): FlavouredApi<EncryptedReceipt, DecryptedReceipt> = FlavouredApi.decrypted(
	config = config,
	encryptedSerializer = EncryptedReceipt.serializer(),
	decryptedSerializer = DecryptedReceipt.serializer(),
	type = EntityWithEncryptionMetadataTypeName.Receipt,
	manifest = EntitiesEncryptedFieldsManifests::receipt,
	patchJson = JsonPatcher::patchReceipt
)

@InternalIcureApi
private fun tryAndRecoverApiFlavour(
	config: ApiConfiguration
): FlavouredApi<EncryptedReceipt, Receipt> = FlavouredApi.tryAndRecover(
	config = config,
	encryptedSerializer = EncryptedReceipt.serializer(),
	decryptedSerializer = DecryptedReceipt.serializer(),
	type = EntityWithEncryptionMetadataTypeName.Receipt,
	manifest = EntitiesEncryptedFieldsManifests::receipt,
	patchJson = JsonPatcher::patchReceipt
)

@InternalIcureApi
private abstract class AbstractReceiptBasicFlavouredApi<E : Receipt>(
	protected val rawApi: RawReceiptApi,
	protected open val config: BasicApiConfiguration,
	protected val flavour: FlavouredApi<EncryptedReceipt, E>
) : FlavouredApi<EncryptedReceipt, E> by flavour {

	protected suspend fun doCreateReceipt(groupId: String?, entity: E): E {
		requireIsValidForCreation(entity)
		val encrypted = validateAndMaybeEncrypt(groupId, entity)
		return if (groupId == null) {
			rawApi.createReceipt(encrypted)
		} else {
			rawApi.createReceiptInGroup(groupId, encrypted)
		}.successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	protected suspend fun doCreateReceipts(groupId: String?, entities: List<E>): List<E> = skipRequestOnEmptyList(entities) { receipts ->
		val encrypted = validateAndMaybeEncrypt(groupId, receipts)
		return if (groupId == null) {
			rawApi.createReceipts(encrypted)
		} else {
			rawApi.createReceiptsInGroup(groupId, encrypted)
		}.successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	protected suspend fun doUndeleteReceipt(groupId: String?, entityId: String, rev: String): E =
		if (groupId == null) {
			rawApi.undeleteReceipt(entityId, rev)
		} else {
			rawApi.undeleteReceiptInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict().let { maybeDecrypt(groupId, it) }

	protected suspend fun doUndeleteReceipts(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<E> = skipRequestOnEmptyList(entityIds) { ids ->
		if (groupId == null) {
			rawApi.undeleteReceipts(ListOfIdsAndRev(ids))
		} else {
			rawApi.undeleteReceiptsInGroup(groupId, ListOfIdsAndRev(ids))
		}.successBody().let { maybeDecrypt(groupId, it) }
	}

	protected suspend fun doModifyReceipt(groupId: String?, entity: E): E {
		requireIsValidForModification(entity)
		val encrypted = validateAndMaybeEncrypt(groupId, entity)
		return if (groupId == null) {
			rawApi.modifyReceipt(encrypted)
		} else {
			rawApi.modifyReceiptInGroup(groupId, encrypted)
		}.successBodyOrThrowRevisionConflict().let { maybeDecrypt(groupId, it) }
	}

	protected suspend fun doModifyReceipts(groupId: String?, entities: List<E>): List<E> = skipRequestOnEmptyList(entities) { receipts ->
		val encrypted = validateAndMaybeEncrypt(groupId, receipts)
		return if (groupId == null) {
			rawApi.modifyReceipts(encrypted)
		} else {
			rawApi.modifyReceiptsInGroup(groupId, encrypted)
		}.successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	protected suspend fun doGetReceipt(groupId: String?, entityId: String): E? =
		if (groupId == null) {
			rawApi.getReceipt(entityId)
		} else {
			rawApi.getReceiptInGroup(groupId, entityId)
		}.successBodyOrNull404()?.let { maybeDecrypt(groupId, it) }

	protected suspend fun doGetReceipts(groupId: String?, entityIds: List<String>): List<E> = skipRequestOnEmptyList(entityIds) { ids ->
		if (groupId == null) {
			rawApi.getReceipts(ListOfIds(ids))
		} else {
			rawApi.getReceiptsInGroup(groupId, ListOfIds(ids))
		}.successBody().let { maybeDecrypt(groupId, it) }
	}
}

@InternalIcureApi
private class ReceiptBasicFlavouredApiImpl<E : Receipt>(
	rawApi: RawReceiptApi,
	config: BasicApiConfiguration,
	flavour: FlavouredApi<EncryptedReceipt, E>
) : ReceiptBasicFlavouredApi<E>, AbstractReceiptBasicFlavouredApi<E>(rawApi, config, flavour) {

	override suspend fun createReceipt(entity: E): E = doCreateReceipt(groupId = null, entity = entity)

	override suspend fun createReceipts(entities: List<E>): List<E> {
		requireIsValidForCreation(entities)
		return doCreateReceipts(groupId = null, entities = entities)
	}

	override suspend fun undeleteReceiptById(id: String, rev: String): E = doUndeleteReceipt(groupId = null, entityId = id, rev = rev)

	override suspend fun undeleteReceiptsByIds(entityIds: List<StoredDocumentIdentifier>): List<E> =
		doUndeleteReceipts(groupId = null, entityIds = entityIds)

	override suspend fun modifyReceipt(entity: E): E = doModifyReceipt(groupId = null, entity = entity)

	override suspend fun modifyReceipts(entities: List<E>): List<E> {
		requireIsValidForModification(entities)
		return doModifyReceipts(groupId = null, entities = entities)
	}

	override suspend fun getReceipt(entityId: String): E? = doGetReceipt(groupId = null, entityId = entityId)

	override suspend fun getReceipts(entityIds: List<String>): List<E> = doGetReceipts(groupId = null, entityIds = entityIds)

	override suspend fun listByReference(reference: String): List<E> =
		rawApi.listByReference(reference).successBody().let { maybeDecrypt(null, it) }
}

@InternalIcureApi
private class ReceiptBasicFlavouredInGroupApiImpl<E : Receipt>(
	rawApi: RawReceiptApi,
	config: BasicApiConfiguration,
	flavour: FlavouredApi<EncryptedReceipt, E>
) : ReceiptBasicFlavouredInGroupApi<E>, AbstractReceiptBasicFlavouredApi<E>(rawApi, config, flavour) {

	override suspend fun createReceipt(entity: GroupScoped<E>): GroupScoped<E> = groupScopedWith(entity) { groupId, it ->
		doCreateReceipt(groupId = groupId, entity = it)
	}

	override suspend fun createReceipts(entities: List<GroupScoped<E>>): List<GroupScoped<E>> {
		requireIsValidForCreationInGroup(entities)
		return entities.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doCreateReceipts(groupId = groupId, entities = chunk)
		}
	}

	override suspend fun undeleteReceiptById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<E> =
		groupScopedWith(entityId) { groupId, it ->
			doUndeleteReceipt(groupId = groupId, entityId = it.id, rev = it.rev)
		}

	override suspend fun undeleteReceiptsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<E>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doUndeleteReceipts(groupId = groupId, entityIds = chunk)
		}

	override suspend fun modifyReceipt(entity: GroupScoped<E>): GroupScoped<E> = groupScopedWith(entity) { groupId, it ->
		doModifyReceipt(groupId = groupId, entity = it)
	}

	override suspend fun modifyReceipts(entities: List<GroupScoped<E>>): List<GroupScoped<E>> {
		requireIsValidForModificationInGroup(entities)
		return entities.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doModifyReceipts(groupId = groupId, entities = chunk)
		}
	}

	override suspend fun getReceipt(groupId: String, entityId: String): GroupScoped<E>? = groupScopedIn(groupId) {
		doGetReceipt(groupId = groupId, entityId = entityId)
	}

	override suspend fun getReceipts(groupId: String, entityIds: List<String>): List<GroupScoped<E>> =
		doGetReceipts(groupId = groupId, entityIds = entityIds).map { GroupScoped(it, groupId) }
}

@InternalIcureApi
private abstract class AbstractReceiptFlavouredApi<E : Receipt>(
	rawApi: RawReceiptApi,
	override val config: ApiConfiguration,
	flavour: FlavouredApi<EncryptedReceipt, E>,
) : AbstractReceiptBasicFlavouredApi<E>(rawApi, config, flavour) {

	protected suspend fun doShareWithMany(
		entityGroupId: String?,
		receipt: E,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, ReceiptShareOptions>
	): E = config.crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			entityGroupId = entityGroupId,
			entity = receipt,
			entityType = EntityWithEncryptionMetadataTypeName.Receipt,
			delegates = delegates,
			autoRetry = true,
			getUpdatedEntity = { doGetReceipt(entityGroupId, it) ?: throw NotFoundException("Receipt $it not found") },
			{
				maybeDecrypt(
					entitiesGroupId = entityGroupId,
					shareResults = if (entityGroupId == null)
						rawApi.bulkShare(it).successBody()
					else
						rawApi.bulkShare(it, entityGroupId).successBody()
				)
			}
		).updatedEntityOrThrow()
}

@InternalIcureApi
private class ReceiptFlavouredApiImpl<E : Receipt>(
	rawApi: RawReceiptApi,
	config: ApiConfiguration,
	flavour: FlavouredApi<EncryptedReceipt, E>,
) : AbstractReceiptFlavouredApi<E>(rawApi, config, flavour),
	ReceiptBasicFlavouredApi<E> by ReceiptBasicFlavouredApiImpl(rawApi, config, flavour),
	ReceiptFlavouredApi<E> {

	override suspend fun shareWith(
		delegateId: String,
		receipt: E,
		options: ReceiptShareOptions?,
	): E =
		shareWithMany(receipt, mapOf(delegateId to (options ?: ReceiptShareOptions())))

	override suspend fun shareWithMany(receipt: E, delegates: Map<String, ReceiptShareOptions>): E =
		doShareWithMany(
			null,
			receipt,
			delegates.mapKeys { EntityReferenceInGroup(it.key, null) }
		)
}

@InternalIcureApi
private class ReceiptFlavouredInGroupApiImpl<E : Receipt>(
	rawApi: RawReceiptApi,
	config: ApiConfiguration,
	flavour: FlavouredApi<EncryptedReceipt, E>,
) : AbstractReceiptFlavouredApi<E>(rawApi, config, flavour),
	ReceiptBasicFlavouredInGroupApi<E> by ReceiptBasicFlavouredInGroupApiImpl(rawApi, config, flavour),
	ReceiptFlavouredInGroupApi<E> {

	override suspend fun shareWith(
		delegate: EntityReferenceInGroup,
		receipt: GroupScoped<E>,
		options: ReceiptShareOptions?
	): GroupScoped<E> = shareWithMany(receipt, mapOf(delegate to (options ?: ReceiptShareOptions())))

	override suspend fun shareWithMany(
		receipt: GroupScoped<E>,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, ReceiptShareOptions>
	): GroupScoped<E> = GroupScoped(
		groupId = receipt.groupId,
		entity = doShareWithMany(
			receipt.groupId,
			receipt.entity,
			delegates
		)
	)
}

@InternalIcureApi
private abstract class AbstractReceiptBasicFlavourless(
	protected val rawApi: RawReceiptApi
) {

	protected suspend fun doDeleteReceipt(groupId: String?, entityId: String, rev: String): StoredDocumentIdentifier =
		if (groupId == null) {
			rawApi.deleteReceipt(entityId, rev)
		} else {
			rawApi.deleteReceiptInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict().toStoredDocumentIdentifier()

	protected suspend fun doDeleteReceipts(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.deleteReceiptsWithRev(ListOfIdsAndRev(ids))
			} else {
				rawApi.deleteReceiptsInGroup(groupId, ListOfIdsAndRev(ids))
			}.successBody().toStoredDocumentIdentifier()
		}

	protected suspend fun doPurgeReceipt(groupId: String?, entityId: String, rev: String) {
		if (groupId == null) {
			rawApi.purgeReceipt(entityId, rev)
		} else {
			rawApi.purgeReceiptInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doPurgeReceipts(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.purgeReceipts(ListOfIdsAndRev(ids))
			} else {
				rawApi.purgeReceiptsInGroup(groupId, ListOfIdsAndRev(ids))
			}.successBody().toStoredDocumentIdentifier()
		}

	suspend fun getRawReceiptAttachment(receiptId: String, attachmentId: String): ByteArray =
		rawApi.getReceiptAttachment(receiptId, attachmentId).successBody()

	suspend fun setRawReceiptAttachment(receiptId: String, rev: String, blobType: String, attachment: ByteArray): EncryptedReceipt =
		rawApi.setReceiptAttachment(receiptId, rev, blobType, attachment).successBody()
}

@InternalIcureApi
private class ReceiptBasicFlavourlessApiImpl(rawApi: RawReceiptApi) : AbstractReceiptBasicFlavourless(rawApi), ReceiptBasicFlavourlessApi {

	override suspend fun deleteReceiptById(entityId: String, rev: String): StoredDocumentIdentifier =
		doDeleteReceipt(groupId = null, entityId, rev)

	override suspend fun deleteReceiptsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doDeleteReceipts(groupId = null, entityIds)

	override suspend fun purgeReceiptById(id: String, rev: String) {
		doPurgeReceipt(groupId = null, entityId = id, rev = rev)
	}

	override suspend fun purgeReceiptsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doPurgeReceipts(groupId = null, entityIds = entityIds)
}

@InternalIcureApi
private class ReceiptBasicFlavourlessInGroupApiImpl(rawApi: RawReceiptApi) : AbstractReceiptBasicFlavourless(rawApi), ReceiptBasicFlavourlessInGroupApi {
	override suspend fun deleteReceiptById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier> =
		groupScopedWith(entityId) { groupId, it ->
			doDeleteReceipt(groupId, it.id, it.rev)
		}

	override suspend fun deleteReceiptsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, entities ->
			doDeleteReceipts(groupId, entities)
		}

	override suspend fun purgeReceiptById(entityId: GroupScoped<StoredDocumentIdentifier>) {
		doPurgeReceipt(groupId = entityId.groupId, entityId = entityId.entity.id, rev = entityId.entity.rev)
	}

	override suspend fun purgeReceiptsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, batch ->
			doPurgeReceipts(groupId, batch)
		}
}

@InternalIcureApi
internal fun initReceiptApi(
	rawApi: RawReceiptApi,
	config: ApiConfiguration
): ReceiptApi {
	val decryptedFlavour = decryptedApiFlavour(config)
	val encryptedFlavour = encryptedApiFlavour(config)
	val tryAndRecoverFlavour = tryAndRecoverApiFlavour(config)
	return ReceiptApiImpl(
		rawApi,
		config,
		encryptedFlavour,
		decryptedFlavour,
		tryAndRecoverFlavour
	)
}

@InternalIcureApi
private class ReceiptApiImpl(
	private val rawApi: RawReceiptApi,
	private val config: ApiConfiguration,
	private val encryptedFlavour: FlavouredApi<EncryptedReceipt, EncryptedReceipt>,
	private val decryptedFlavour: FlavouredApi<EncryptedReceipt, DecryptedReceipt>,
	private val tryAndRecoverFlavour: FlavouredApi<EncryptedReceipt, Receipt>,
) : ReceiptApi,
	ReceiptFlavouredApi<DecryptedReceipt> by ReceiptFlavouredApiImpl(rawApi, config, decryptedFlavour),
	ReceiptBasicFlavourlessApi by ReceiptBasicFlavourlessApiImpl(rawApi) {
	override val encrypted: ReceiptFlavouredApi<EncryptedReceipt> = ReceiptFlavouredApiImpl(rawApi, config, encryptedFlavour)
	override val tryAndRecover: ReceiptFlavouredApi<Receipt> = ReceiptFlavouredApiImpl(rawApi, config, tryAndRecoverFlavour)
	override val inGroup: ReceiptInGroupApi = object : ReceiptInGroupApi,
		ReceiptFlavouredInGroupApi<DecryptedReceipt> by ReceiptFlavouredInGroupApiImpl(rawApi, config, decryptedFlavour),
		ReceiptBasicFlavourlessInGroupApi by ReceiptBasicFlavourlessInGroupApiImpl(rawApi) {

		override val encrypted: ReceiptFlavouredInGroupApi<EncryptedReceipt> =
			ReceiptFlavouredInGroupApiImpl(rawApi, config, encryptedFlavour)
		override val tryAndRecover: ReceiptFlavouredInGroupApi<Receipt> =
			ReceiptFlavouredInGroupApiImpl(rawApi, config, tryAndRecoverFlavour)

		override suspend fun withEncryptionMetadata(
			groupId: String,
			base: DecryptedReceipt?,
			patient: GroupScoped<Patient>?,
			user: User?,
			delegates: Map<String, AccessLevel>,
			secretId: SecretIdUseOption,
			alternateRootDelegateId: String?
		): GroupScoped<DecryptedReceipt> =
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

		override suspend fun getEncryptionKeysOf(receipt: GroupScoped<Receipt>): Set<HexString> =
			doGetEncryptionKeysOf(groupId = receipt.groupId, receipt = receipt.entity)

		override suspend fun hasWriteAccess(receipt: GroupScoped<Receipt>): Boolean =
			doHasWriteAccess(groupId = receipt.groupId, receipt = receipt.entity)

		override suspend fun decryptPatientIdOf(receipt: GroupScoped<Receipt>): Set<EntityReferenceInGroup> =
			doDecryptPatientIdOf(groupId = receipt.groupId, receipt = receipt.entity)

		override suspend fun createDelegationDeAnonymizationMetadata(
			entity: GroupScoped<Receipt>,
			delegates: Set<EntityReferenceInGroup>,
		) {
			doCreateDelegationDeAnonymizationMetadata(groupId = entity.groupId, entity = entity.entity, delegates = delegates)
		}

		override suspend fun decrypt(receipts: List<GroupScoped<EncryptedReceipt>>): List<GroupScoped<DecryptedReceipt>> =
			receipts.mapExactlyChunkedByGroup { groupId, entities ->
				decryptedFlavour.maybeDecrypt(groupId, entities)
			}

		override suspend fun tryDecrypt(receipts: List<GroupScoped<EncryptedReceipt>>): List<GroupScoped<Receipt>> =
			receipts.mapExactlyChunkedByGroup { groupId, entities ->
				tryAndRecoverFlavour.maybeDecrypt(groupId, entities)
			}

	}

	override suspend fun withEncryptionMetadata(
		base: DecryptedReceipt?,
		patient: Patient?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdUseOption,
		alternateRootDelegateId: String?
	): DecryptedReceipt =
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
		base: DecryptedReceipt?,
		patient: Patient?,
		patientGroupId: String?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdUseOption,
		alternateRootDelegateId: String?
	): DecryptedReceipt =
		config.crypto.entity.entityWithInitializedEncryptedMetadata(
			groupId,
			(base ?: DecryptedReceipt(config.crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			),
			EntityWithEncryptionMetadataTypeName.Receipt,
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

	override suspend fun getAndDecryptReceiptAttachment(receipt: Receipt, attachmentId: String) =
		rawApi.getReceiptAttachment(receipt.id, attachmentId).successBody().let {
			val aesKey = config.crypto.entity.tryDecryptAndImportAnyEncryptionKey(
				null,
				listOf(receipt),
				EntityWithEncryptionMetadataTypeName.Receipt
			)[receipt.id]?.key
				?: throw EntityEncryptionException("Cannot extract decryption key from Receipt(\"${receipt.id}\")")
			config.crypto.primitives.aes.decrypt(it, aesKey)
		}

	override suspend fun getEncryptionKeysOf(receipt: Receipt): Set<HexString> = doGetEncryptionKeysOf(groupId = null, receipt = receipt)

	private suspend fun doGetEncryptionKeysOf(groupId: String?, receipt: Receipt): Set<HexString> =
		config.crypto.entity.encryptionKeysOf(groupId, receipt, EntityWithEncryptionMetadataTypeName.Receipt, null)

	override suspend fun hasWriteAccess(receipt: Receipt): Boolean = doHasWriteAccess(groupId = null, receipt = receipt)

	private suspend fun doHasWriteAccess(groupId: String?, receipt: Receipt): Boolean =
		config.crypto.entity.hasWriteAccess(groupId, receipt, EntityWithEncryptionMetadataTypeName.Receipt)

	override suspend fun decryptPatientIdOf(receipt: Receipt): Set<EntityReferenceInGroup> =
		doDecryptPatientIdOf(groupId = null, receipt = receipt)

	private suspend fun doDecryptPatientIdOf(groupId: String?, receipt: Receipt): Set<EntityReferenceInGroup> =
		config.crypto.entity.owningEntityIdsOf(
			groupId,
			receipt,
			EntityWithEncryptionMetadataTypeName.Receipt,
			null
		).mapTo(mutableSetOf()) { config.crypto.entity.parseReference(groupId, it) }

	override suspend fun createDelegationDeAnonymizationMetadata(entity: Receipt, delegates: Set<String>) {
		doCreateDelegationDeAnonymizationMetadata(groupId = null, entity, delegates.asLocalDataOwnerReferences())
	}

	private suspend fun doCreateDelegationDeAnonymizationMetadata(groupId: String?, entity: Receipt, delegates: Set<EntityReferenceInGroup>) {
		config.crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(
			groupId,
			entity,
			EntityWithEncryptionMetadataTypeName.Receipt,
			delegates
		)
	}

	override suspend fun logReceipt(user: User, docId: String, refs: List<String>, blobType: String, blob: ByteArray): Receipt {
		val newReceipt = withEncryptionMetadata(
			base = DecryptedReceipt(
				id = config.crypto.primitives.strongRandom.randomUUID(),
				documentId = docId,
				references = refs
			),
			user = user,
			patient = null,
			alternateRootDelegateId = null
		).let { createReceipt(it) }
		checkNotNull(newReceipt.rev) {
			"Receipt creation failed"
		}
		return if(blob.isNotEmpty()) {
			setRawReceiptAttachment(newReceipt.id, newReceipt.rev, blobType, blob)
		} else {
			newReceipt
		}
	}

	override suspend fun encryptAndSetReceiptAttachment(receipt: Receipt, blobType: String, attachment: ByteArray): EncryptedReceipt {
		val aesKey = config.crypto.entity.tryDecryptAndImportAnyEncryptionKey(
			null,
			listOf(receipt),
			EntityWithEncryptionMetadataTypeName.Receipt
		)[receipt.id]?.key
			?: throw EntityEncryptionException("Cannot extract encryption key from receipt")
		val payload = config.crypto.primitives.aes.encrypt(attachment, aesKey)
		return rawApi.setReceiptAttachment(
			receipt.id,
			receipt.rev ?: throw IllegalArgumentException("Receipt must have a revision set before setting the attachment"),
			blobType,
			payload,
		).successBody()
	}

	override suspend fun decrypt(receipt: EncryptedReceipt): DecryptedReceipt =
		decryptedFlavour.maybeDecrypt(null, receipt)

	override suspend fun tryDecrypt(receipt: EncryptedReceipt): Receipt =
		tryAndRecoverFlavour.maybeDecrypt(null, receipt)
}

@InternalIcureApi
internal fun initReceiptBasicApi(
	rawApi: RawReceiptApi,
	config: BasicApiConfiguration
): ReceiptBasicApi = ReceiptBasicApiImpl(
	rawApi,
	config,
	encryptedApiFlavour(config)
)

@InternalIcureApi
private class ReceiptBasicApiImpl(
	private val rawApi: RawReceiptApi,
	private val config: BasicApiConfiguration,
	private val encryptedFlavour: FlavouredApi<EncryptedReceipt, EncryptedReceipt>,
) : ReceiptBasicApi,
	ReceiptBasicFlavouredApi<EncryptedReceipt> by ReceiptBasicFlavouredApiImpl(rawApi, config, encryptedFlavour),
	ReceiptBasicFlavourlessApi by ReceiptBasicFlavourlessApiImpl(rawApi) {
	override val inGroup: ReceiptBasicInGroupApi = object : ReceiptBasicInGroupApi,
		ReceiptBasicFlavouredInGroupApi<EncryptedReceipt> by ReceiptBasicFlavouredInGroupApiImpl(rawApi, config, encryptedFlavour),
		ReceiptBasicFlavourlessInGroupApi by ReceiptBasicFlavourlessInGroupApiImpl(rawApi) {}
}
