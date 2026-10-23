package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.CustomEntityApi
import com.icure.cardinal.sdk.api.CustomEntityBasicApi
import com.icure.cardinal.sdk.api.CustomEntityBasicFlavouredApi
import com.icure.cardinal.sdk.api.CustomEntityBasicFlavouredInGroupApi
import com.icure.cardinal.sdk.api.CustomEntityBasicFlavourlessApi
import com.icure.cardinal.sdk.api.CustomEntityBasicFlavourlessInGroupApi
import com.icure.cardinal.sdk.api.CustomEntityBasicInGroupApi
import com.icure.cardinal.sdk.api.CustomEntityFlavouredApi
import com.icure.cardinal.sdk.api.CustomEntityFlavouredInGroupApi
import com.icure.cardinal.sdk.api.CustomEntityInGroupApi
import com.icure.cardinal.sdk.api.raw.RawCustomEntityApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptors
import com.icure.cardinal.sdk.crypto.entities.BulkShareByIdsResult
import com.icure.cardinal.sdk.crypto.entities.CustomEntityDelegateOptions
import com.icure.cardinal.sdk.crypto.entities.CustomEntityOwningEntity
import com.icure.cardinal.sdk.crypto.entities.CustomEntityShareOptions
import com.icure.cardinal.sdk.crypto.entities.DelegateOptions
import com.icure.cardinal.sdk.crypto.entities.EntityAccessInformation
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.OwningEntityDetails
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.crypto.entities.asIcureStub
import com.icure.cardinal.sdk.crypto.entities.toBulkShareByIdsResult
import com.icure.cardinal.sdk.exceptions.NotFoundException
import com.icure.cardinal.sdk.model.CustomEntityBase
import com.icure.cardinal.sdk.model.DecryptedCustomEntityBase
import com.icure.cardinal.sdk.model.EncryptedCustomEntityBase
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.DelegationTag
import com.icure.cardinal.sdk.model.extensions.autoDelegationsFor
import com.icure.cardinal.sdk.model.extensions.dataOwnerId
import com.icure.cardinal.sdk.model.extensions.toDefaultDelegateOptions
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.utils.UnavailableEncryptionKeyException
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.cardinal.sdk.utils.ensureNonNull
import com.icure.cardinal.sdk.utils.generation.JsMapAsObjectArray
import com.icure.utils.InternalIcureApi

@InternalIcureApi
private fun encryptedApiFlavour(
	config: BasicApiConfiguration,
): FlavouredApi<EncryptedCustomEntityBase, EncryptedCustomEntityBase> = FlavouredApi.encrypted(
	config = config,
)

@InternalIcureApi
private fun decryptedApiFlavour(
	config: ApiConfiguration,
	type: EntityWithEncryptionMetadataTypeName.Custom,
	encryptors: EntityEncryptors<EncryptedCustomEntityBase, DecryptedCustomEntityBase>,
): FlavouredApi<EncryptedCustomEntityBase, DecryptedCustomEntityBase> = FlavouredApi.decrypted(
	config = config,
	type = type,
	encryptors = encryptors,
	getRootModelVersion = EncryptedCustomEntityBase::customisedModelVersion,
)

@InternalIcureApi
private fun tryAndRecoverApiFlavour(
	config: ApiConfiguration,
	type: EntityWithEncryptionMetadataTypeName.Custom,
	encryptors: EntityEncryptors<EncryptedCustomEntityBase, DecryptedCustomEntityBase>,
): FlavouredApi<EncryptedCustomEntityBase, CustomEntityBase> = FlavouredApi.tryAndRecover(
	config = config,
	type = type,
	encryptors = encryptors,
	getRootModelVersion = EncryptedCustomEntityBase::customisedModelVersion,
)

@InternalIcureApi
private abstract class AbstractCustomEntityBasicFlavouredApi<E : CustomEntityBase>(
	protected val rawApi: RawCustomEntityApi,
	protected open val config: BasicApiConfiguration,
	protected val flavour: FlavouredApi<EncryptedCustomEntityBase, E>,
) : FlavouredApi<EncryptedCustomEntityBase, E> by flavour {

	protected suspend fun doCreateEntity(groupId: String?, entity: E): E {
		requireIsValidForCreation(entity)
		val encrypted = validateAndMaybeEncrypt(groupId, entity)
		return if (groupId == null) {
			rawApi.createCustomEntity(entityDto = encrypted)
		} else {
			rawApi.createCustomEntityInGroup(groupId = groupId, entityDto = encrypted)
		}.successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	protected suspend fun doCreateEntities(groupId: String?, entities: List<E>): List<E> = skipRequestOnEmptyList(entities) { customEntities ->
		val encrypted = validateAndMaybeEncrypt(groupId, customEntities)
		if (groupId == null) {
			rawApi.createCustomEntities(entityDtos = encrypted)
		} else {
			rawApi.createCustomEntitiesInGroup(groupId = groupId, entityDtos = encrypted)
		}.successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	protected suspend fun doUndeleteEntity(groupId: String?, entityId: String, rev: String): E =
		if (groupId == null) {
			rawApi.undeleteCustomEntity(entityId = entityId, rev = rev)
		} else {
			rawApi.undeleteCustomEntityInGroup(groupId = groupId, entityId = entityId, rev = rev)
		}.successBodyOrThrowRevisionConflict().let { maybeDecrypt(groupId, it) }

	protected suspend fun doUndeleteEntities(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<E> = skipRequestOnEmptyList(entityIds) { ids ->
		if (groupId == null) {
			rawApi.undeleteCustomEntities(entityIds = ListOfIdsAndRev(ids))
		} else {
			rawApi.undeleteCustomEntitiesInGroup(groupId = groupId, entityIds = ListOfIdsAndRev(ids))
		}.successBody().let { maybeDecrypt(groupId, it) }
	}

	protected suspend fun doModifyEntity(groupId: String?, entity: E): E {
		requireIsValidForModification(entity)
		val encrypted = validateAndMaybeEncrypt(groupId, entity)
		return if (groupId == null) {
			rawApi.modifyCustomEntity(customEntityDto = encrypted)
		} else {
			rawApi.modifyCustomEntityInGroup(groupId = groupId, customEntityDto = encrypted)
		}.successBodyOrThrowRevisionConflict().let { maybeDecrypt(groupId, it) }
	}

	protected suspend fun doModifyEntities(groupId: String?, entities: List<E>): List<E> = skipRequestOnEmptyList(entities) { customEntities ->
		val encrypted = validateAndMaybeEncrypt(groupId, customEntities)
		if (groupId == null) {
			rawApi.modifyCustomEntities(customEntityDtos = encrypted)
		} else {
			rawApi.modifyCustomEntitiesInGroup(groupId = groupId, customEntityDtos = encrypted)
		}.successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	protected suspend fun doGetEntity(groupId: String?, entityId: String): E? =
		if (groupId == null) {
			rawApi.getCustomEntity(entityId = entityId)
		} else {
			rawApi.getCustomEntityInGroup(groupId = groupId, entityId = entityId)
		}.successBodyOrNull404()?.let { maybeDecrypt(groupId, it) }

	protected suspend fun doGetEntities(groupId: String?, entityIds: List<String>): List<E> = skipRequestOnEmptyList(entityIds) { ids ->
		if (groupId == null) {
			rawApi.getCustomEntities(entityIds = ListOfIds(ids))
		} else {
			rawApi.getCustomEntitiesInGroup(groupId = groupId, entityIds = ListOfIds(ids))
		}.successBody().let { maybeDecrypt(groupId, it) }
	}
}

@InternalIcureApi
private class CustomEntityBasicFlavouredApiImpl<E : CustomEntityBase>(
	rawApi: RawCustomEntityApi,
	config: BasicApiConfiguration,
	flavour: FlavouredApi<EncryptedCustomEntityBase, E>,
) : CustomEntityBasicFlavouredApi<E>, AbstractCustomEntityBasicFlavouredApi<E>(rawApi, config, flavour) {

	override suspend fun createEntity(entity: E): E = doCreateEntity(groupId = null, entity = entity)

	override suspend fun createEntities(entities: List<E>): List<E> {
		requireIsValidForCreation(entities)
		return doCreateEntities(groupId = null, entities = entities)
	}

	override suspend fun undeleteEntityById(id: String, rev: String): E = doUndeleteEntity(groupId = null, entityId = id, rev = rev)

	override suspend fun undeleteEntitiesByIds(entityIds: List<StoredDocumentIdentifier>): List<E> =
		doUndeleteEntities(groupId = null, entityIds = entityIds)

	override suspend fun modifyEntity(entity: E): E = doModifyEntity(groupId = null, entity = entity)

	override suspend fun modifyEntities(entities: List<E>): List<E> {
		requireIsValidForModification(entities)
		return doModifyEntities(groupId = null, entities = entities)
	}

	override suspend fun getEntity(entityId: String): E? = doGetEntity(groupId = null, entityId = entityId)

	override suspend fun getEntities(entityIds: List<String>): List<E> = doGetEntities(groupId = null, entityIds = entityIds)

	override suspend fun setRawAttachment(
		entityId: String,
		rev: String,
		key: String,
		utis: List<String>?,
		attachment: ByteArray,
		encrypted: Boolean,
	): E =
		rawApi.setAttachment(
			entityId = entityId,
			key = key,
			rev = rev,
			utis = utis,
			payload = attachment,
			lengthHeader = attachment.size.toLong(),
			encrypted = encrypted,
		).successBodyOrThrowRevisionConflict().let { maybeDecrypt(null, it) }

	override suspend fun deleteAttachment(entityId: String, rev: String, key: String): E =
		rawApi.deleteAttachment(
			entityId = entityId,
			key = key,
			rev = rev,
		).successBodyOrThrowRevisionConflict().let { maybeDecrypt(null, it) }
}

@InternalIcureApi
private class CustomEntityBasicFlavouredInGroupApiImpl<E : CustomEntityBase>(
	rawApi: RawCustomEntityApi,
	config: BasicApiConfiguration,
	flavour: FlavouredApi<EncryptedCustomEntityBase, E>,
) : CustomEntityBasicFlavouredInGroupApi<E>, AbstractCustomEntityBasicFlavouredApi<E>(rawApi, config, flavour) {

	override suspend fun createEntity(entity: GroupScoped<E>): GroupScoped<E> = groupScopedWith(entity) { groupId, it ->
		doCreateEntity(groupId = groupId, entity = it)
	}

	override suspend fun createEntities(entities: List<GroupScoped<E>>): List<GroupScoped<E>> {
		requireIsValidForCreationInGroup(entities)
		return entities.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doCreateEntities(groupId = groupId, entities = chunk)
		}
	}

	override suspend fun undeleteEntityById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<E> =
		groupScopedWith(entityId) { groupId, it ->
			doUndeleteEntity(groupId = groupId, entityId = it.id, rev = it.rev)
		}

	override suspend fun undeleteEntitiesByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<E>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doUndeleteEntities(groupId = groupId, entityIds = chunk)
		}

	override suspend fun modifyEntity(entity: GroupScoped<E>): GroupScoped<E> = groupScopedWith(entity) { groupId, it ->
		doModifyEntity(groupId = groupId, entity = it)
	}

	override suspend fun modifyEntities(entities: List<GroupScoped<E>>): List<GroupScoped<E>> {
		requireIsValidForModificationInGroup(entities)
		return entities.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doModifyEntities(groupId = groupId, entities = chunk)
		}
	}

	override suspend fun getEntity(groupId: String, entityId: String): GroupScoped<E>? = groupScopedIn(groupId) {
		doGetEntity(groupId = groupId, entityId = entityId)
	}

	override suspend fun getEntities(groupId: String, entityIds: List<String>): List<GroupScoped<E>> = groupScopedListIn(groupId) {
		doGetEntities(groupId = groupId, entityIds = entityIds)
	}
}

@InternalIcureApi
private abstract class AbstractCustomEntityFlavouredApi<E : CustomEntityBase>(
	rawApi: RawCustomEntityApi,
	override val config: ApiConfiguration,
	flavour: FlavouredApi<EncryptedCustomEntityBase, E>,
	protected val type: EntityWithEncryptionMetadataTypeName.Custom,
) : AbstractCustomEntityBasicFlavouredApi<E>(rawApi, config, flavour) {

	protected suspend fun doShareWithMany(
		entityGroupId: String?,
		entity: E,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, CustomEntityShareOptions>,
	): E =
		config.crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			entityGroupId,
			entity,
			type,
			delegates,
			true,
			{ doGetEntity(entityGroupId, it) ?: throw NotFoundException("Custom entity ${type.entityTypeId} $it not found") },
			{
				maybeDecrypt(
					entityGroupId,
					if (entityGroupId == null) {
						rawApi.bulkShare(request = it).successBody()
					} else {
						rawApi.bulkShareInGroup(groupId = entityGroupId, request = it).successBody()
					},
				)
			},
		).updatedEntityOrThrow()
}

@InternalIcureApi
private class CustomEntityFlavouredApiImpl<E : CustomEntityBase>(
	rawApi: RawCustomEntityApi,
	config: ApiConfiguration,
	flavour: FlavouredApi<EncryptedCustomEntityBase, E>,
	type: EntityWithEncryptionMetadataTypeName.Custom,
) : AbstractCustomEntityFlavouredApi<E>(rawApi, config, flavour, type),
	CustomEntityBasicFlavouredApi<E> by CustomEntityBasicFlavouredApiImpl(rawApi, config, flavour),
	CustomEntityFlavouredApi<E> {

	override suspend fun shareWith(
		delegateId: String,
		entity: E,
		options: CustomEntityShareOptions?,
	): E =
		shareWithMany(entity, mapOf(delegateId to (options ?: CustomEntityShareOptions())))

	override suspend fun shareWithMany(entity: E, delegates: Map<String, CustomEntityShareOptions>): E =
		doShareWithMany(null, entity, delegates.keyAsLocalDataOwnerReferences())
}

@InternalIcureApi
private class CustomEntityFlavouredInGroupApiImpl<E : CustomEntityBase>(
	rawApi: RawCustomEntityApi,
	config: ApiConfiguration,
	flavour: FlavouredApi<EncryptedCustomEntityBase, E>,
	type: EntityWithEncryptionMetadataTypeName.Custom,
) : AbstractCustomEntityFlavouredApi<E>(rawApi, config, flavour, type),
	CustomEntityBasicFlavouredInGroupApi<E> by CustomEntityBasicFlavouredInGroupApiImpl(rawApi, config, flavour),
	CustomEntityFlavouredInGroupApi<E> {

	override suspend fun shareWith(
		delegate: EntityReferenceInGroup,
		entity: GroupScoped<E>,
		options: CustomEntityShareOptions?,
	): GroupScoped<E> =
		shareWithMany(entity, mapOf(delegate to (options ?: CustomEntityShareOptions())))

	override suspend fun shareWithMany(
		entity: GroupScoped<E>,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, CustomEntityShareOptions>,
	): GroupScoped<E> =
		GroupScoped(
			doShareWithMany(
				entity.groupId,
				entity.entity,
				delegates,
			),
			entity.groupId,
		)
}

@InternalIcureApi
private abstract class AbstractCustomEntityBasicFlavourless(
	protected val rawApi: RawCustomEntityApi,
	protected val config: BasicApiConfiguration,
	protected val type: EntityWithEncryptionMetadataTypeName.Custom,
) {

	protected suspend fun doDeleteEntity(groupId: String?, entityId: String, rev: String): StoredDocumentIdentifier =
		if (groupId == null) {
			rawApi.deleteCustomEntity(entityId = entityId, rev = rev)
		} else {
			rawApi.deleteCustomEntityInGroup(groupId = groupId, entityId = entityId, rev = rev)
		}.successBodyOrThrowRevisionConflict().toStoredDocumentIdentifier()

	protected suspend fun doDeleteEntities(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.deleteCustomEntities(entityIds = ListOfIdsAndRev(ids))
			} else {
				rawApi.deleteCustomEntitiesInGroup(groupId = groupId, entityIds = ListOfIdsAndRev(ids))
			}.successBody().toStoredDocumentIdentifier()
		}

	protected suspend fun doPurgeEntity(groupId: String?, entityId: String, rev: String) {
		if (groupId == null) {
			rawApi.purgeCustomEntity(entityId = entityId, rev = rev)
		} else {
			rawApi.purgeCustomEntityInGroup(groupId = groupId, entityId = entityId, rev = rev)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doPurgeEntities(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.purgeCustomEntities(entityIds = ListOfIdsAndRev(ids))
			} else {
				rawApi.purgeCustomEntitiesInGroup(groupId = groupId, entityIds = ListOfIdsAndRev(ids))
			}.successBody().toStoredDocumentIdentifier()
		}

	protected suspend fun doGetDataOwnersWithAccessTo(groupId: String?, entity: CustomEntityBase): EntityAccessInformation =
		config.crypto.entityAccessInformationProvider.getDataOwnersWithAccessTo(
			groupId,
			entity,
			type,
		)
}

@InternalIcureApi
private class CustomEntityBasicFlavourlessApiImpl(
	rawApi: RawCustomEntityApi,
	config: BasicApiConfiguration,
	type: EntityWithEncryptionMetadataTypeName.Custom,
) : AbstractCustomEntityBasicFlavourless(rawApi, config, type), CustomEntityBasicFlavourlessApi {

	override suspend fun deleteEntityById(entityId: String, rev: String): StoredDocumentIdentifier =
		doDeleteEntity(groupId = null, entityId = entityId, rev = rev)

	override suspend fun deleteEntitiesByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doDeleteEntities(groupId = null, entityIds = entityIds)

	override suspend fun purgeEntityById(id: String, rev: String) {
		doPurgeEntity(groupId = null, entityId = id, rev = rev)
	}

	override suspend fun purgeEntitiesByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doPurgeEntities(groupId = null, entityIds = entityIds)

	override suspend fun getRawAttachment(entityId: String, key: String): ByteArray =
		rawApi.getAttachment(entityId = entityId, key = key).successBody()

	override suspend fun getDataOwnersWithAccessTo(entity: CustomEntityBase): EntityAccessInformation =
		doGetDataOwnersWithAccessTo(groupId = null, entity = entity)
}

@InternalIcureApi
private class CustomEntityBasicFlavourlessInGroupApiImpl(
	rawApi: RawCustomEntityApi,
	config: BasicApiConfiguration,
	type: EntityWithEncryptionMetadataTypeName.Custom,
) : AbstractCustomEntityBasicFlavourless(rawApi, config, type), CustomEntityBasicFlavourlessInGroupApi {

	override suspend fun deleteEntityById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier> =
		groupScopedWith(entityId) { groupId, it ->
			doDeleteEntity(groupId, it.id, it.rev)
		}

	override suspend fun deleteEntitiesByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, entities ->
			doDeleteEntities(groupId, entities)
		}

	override suspend fun purgeEntityById(entityId: GroupScoped<StoredDocumentIdentifier>) {
		doPurgeEntity(groupId = entityId.groupId, entityId = entityId.entity.id, rev = entityId.entity.rev)
	}

	override suspend fun purgeEntitiesByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, batch ->
			doPurgeEntities(groupId, batch)
		}

	override suspend fun getDataOwnersWithAccessTo(entity: GroupScoped<CustomEntityBase>): EntityAccessInformation =
		doGetDataOwnersWithAccessTo(groupId = entity.groupId, entity = entity.entity)
}

/**
 * Creates the api for a delegation-based custom entity type.
 * @param rawApi raw api bound to the custom entity type.
 * @param entityTypeId the identifier of the custom entity type.
 * @throws IllegalArgumentException if the custom entity type has no encryptors configured.
 */
@InternalIcureApi
internal fun initCustomEntityApi(
	rawApi: RawCustomEntityApi,
	config: ApiConfiguration,
	entityTypeId: String,
): CustomEntityApi {
	val type = EntityWithEncryptionMetadataTypeName.Custom(entityTypeId)
	val encryptors = requireNotNull(config.encryptors.customEntities[entityTypeId]) {
		"Custom entity type $entityTypeId is not encryptable: no encryption manifest is defined for it"
	}
	return CustomEntityApiImpl(
		rawApi = rawApi,
		config = config,
		type = type,
		encryptedFlavour = encryptedApiFlavour(config),
		decryptedFlavour = decryptedApiFlavour(config, type, encryptors),
		tryAndRecoverFlavour = tryAndRecoverApiFlavour(config, type, encryptors),
	)
}

@InternalIcureApi
private class CustomEntityApiImpl(
	private val rawApi: RawCustomEntityApi,
	private val config: ApiConfiguration,
	private val type: EntityWithEncryptionMetadataTypeName.Custom,
	encryptedFlavour: FlavouredApi<EncryptedCustomEntityBase, EncryptedCustomEntityBase>,
	private val decryptedFlavour: FlavouredApi<EncryptedCustomEntityBase, DecryptedCustomEntityBase>,
	private val tryAndRecoverFlavour: FlavouredApi<EncryptedCustomEntityBase, CustomEntityBase>,
) : CustomEntityApi,
	CustomEntityFlavouredApi<DecryptedCustomEntityBase> by CustomEntityFlavouredApiImpl(rawApi, config, decryptedFlavour, type),
	CustomEntityBasicFlavourlessApi by CustomEntityBasicFlavourlessApiImpl(rawApi, config, type) {

	private val crypto get() = config.crypto

	override val encrypted: CustomEntityFlavouredApi<EncryptedCustomEntityBase> =
		CustomEntityFlavouredApiImpl(rawApi, config, encryptedFlavour, type)
	override val tryAndRecover: CustomEntityFlavouredApi<CustomEntityBase> =
		CustomEntityFlavouredApiImpl(rawApi, config, tryAndRecoverFlavour, type)

	override val inGroup: CustomEntityInGroupApi = object : CustomEntityInGroupApi,
		CustomEntityFlavouredInGroupApi<DecryptedCustomEntityBase> by CustomEntityFlavouredInGroupApiImpl(rawApi, config, decryptedFlavour, type),
		CustomEntityBasicFlavourlessInGroupApi by CustomEntityBasicFlavourlessInGroupApiImpl(rawApi, config, type) {
		override val encrypted: CustomEntityFlavouredInGroupApi<EncryptedCustomEntityBase> =
			CustomEntityFlavouredInGroupApiImpl(rawApi, config, encryptedFlavour, type)
		override val tryAndRecover: CustomEntityFlavouredInGroupApi<CustomEntityBase> =
			CustomEntityFlavouredInGroupApiImpl(rawApi, config, tryAndRecoverFlavour, type)

		override suspend fun withEncryptionMetadata(
			entityGroupId: String,
			base: DecryptedCustomEntityBase?,
			owningEntity: CustomEntityOwningEntity<GroupScoped<HasEncryptionMetadata>>?,
			user: User?,
			delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "accessLevel") Map<EntityReferenceInGroup, AccessLevel>,
			alternateRootDelegateReference: EntityReferenceInGroup?,
		): GroupScoped<DecryptedCustomEntityBase> =
			GroupScoped(
				doWithEncryptionMetadataAndDelegates(
					entityGroupId = entityGroupId,
					base = base,
					owningEntity = owningEntity?.inGroup(),
					user = user,
					delegates = delegates.mapValues { it.value.toDefaultDelegateOptions() },
					alternateRootDataOwnerReference = alternateRootDelegateReference,
				),
				entityGroupId,
			)

		override suspend fun withEncryptionMetadataAndDelegates(
			entityGroupId: String,
			base: DecryptedCustomEntityBase?,
			delegates: @JsMapAsObjectArray(
				keyEntryName = "delegate",
				valueEntryName = "delegateOptions",
			) Map<EntityReferenceInGroup, CustomEntityDelegateOptions>,
			owningEntity: CustomEntityOwningEntity<GroupScoped<HasEncryptionMetadata>>?,
			user: User?,
			alternateRootDelegateReference: EntityReferenceInGroup?,
		): GroupScoped<DecryptedCustomEntityBase> =
			GroupScoped(
				doWithEncryptionMetadataAndDelegates(
					entityGroupId = entityGroupId,
					base = base,
					owningEntity = owningEntity?.inGroup(),
					user = user,
					delegates = delegates,
					alternateRootDataOwnerReference = alternateRootDelegateReference,
				),
				entityGroupId,
			)

		override suspend fun getEncryptionKeysOf(entity: GroupScoped<CustomEntityBase>): Set<HexString> =
			doGetEncryptionKeysOf(entity.groupId, entity.entity)

		override suspend fun getSecretIdsOf(entity: GroupScoped<CustomEntityBase>): Map<String, Set<EntityReferenceInGroup>> =
			doGetSecretIdsOf(entity.groupId, entity.entity)

		override suspend fun hasWriteAccess(entity: GroupScoped<CustomEntityBase>): Boolean =
			doHasWriteAccess(entity.groupId, entity.entity)

		override suspend fun decryptOwningEntityIdsOf(entity: GroupScoped<CustomEntityBase>): Set<EntityReferenceInGroup> =
			doDecryptOwningEntityIdsOf(entity.groupId, entity.entity).withExplicitBoundGroup(config)

		override suspend fun createDelegationDeAnonymizationMetadata(
			entity: GroupScoped<CustomEntityBase>,
			delegates: Set<EntityReferenceInGroup>,
		) =
			doCreateDelegationDeAnonymizationMetadata(entity.groupId, entity.entity, delegates)

		override suspend fun decrypt(entities: List<GroupScoped<EncryptedCustomEntityBase>>): List<GroupScoped<DecryptedCustomEntityBase>> =
			entities.mapExactlyChunkedByGroup { groupId, chunk ->
				decryptedFlavour.maybeDecrypt(groupId, chunk)
			}

		override suspend fun tryDecrypt(entities: List<GroupScoped<EncryptedCustomEntityBase>>): List<GroupScoped<CustomEntityBase>> =
			entities.mapExactlyChunkedByGroup { groupId, chunk ->
				tryAndRecoverFlavour.maybeDecrypt(groupId, chunk)
			}

		override suspend fun encryptOrValidate(entities: List<GroupScoped<CustomEntityBase>>): List<GroupScoped<EncryptedCustomEntityBase>> =
			entities.mapExactlyChunkedByGroup { groupId, chunk ->
				tryAndRecoverFlavour.validateAndMaybeEncrypt(groupId, chunk)
			}
	}

	override suspend fun withEncryptionMetadata(
		base: DecryptedCustomEntityBase?,
		owningEntity: CustomEntityOwningEntity<HasEncryptionMetadata>?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		alternateRootDelegateId: String?,
	): DecryptedCustomEntityBase =
		doWithEncryptionMetadataAndDelegates(
			entityGroupId = null,
			base = base,
			owningEntity = owningEntity?.inCurrentGroup(),
			user = user,
			delegates = delegates.mapValues { it.value.toDefaultDelegateOptions() }.keyAsLocalDataOwnerReferences(),
			alternateRootDataOwnerReference = alternateRootDelegateId?.let { EntityReferenceInGroup(it, null) },
		)

	override suspend fun withEncryptionMetadataAndDelegates(
		base: DecryptedCustomEntityBase?,
		delegates: Map<String, CustomEntityDelegateOptions>,
		owningEntity: CustomEntityOwningEntity<HasEncryptionMetadata>?,
		user: User?,
		alternateRootDelegateId: String?,
	): DecryptedCustomEntityBase =
		doWithEncryptionMetadataAndDelegates(
			entityGroupId = null,
			base = base,
			owningEntity = owningEntity?.inCurrentGroup(),
			user = user,
			delegates = delegates.keyAsLocalDataOwnerReferences(),
			alternateRootDataOwnerReference = alternateRootDelegateId?.let { EntityReferenceInGroup(it, null) },
		)

	/**
	 * Owning entity with the group it belongs to (null for the current group).
	 */
	private class OwningEntityInGroup(
		val entity: HasEncryptionMetadata,
		val groupId: String?,
		val entityType: EntityWithEncryptionMetadataTypeName,
		val secretId: SecretIdUseOption,
	)

	private fun CustomEntityOwningEntity<HasEncryptionMetadata>.inCurrentGroup() =
		OwningEntityInGroup(entity, null, entityType, secretId)

	private fun CustomEntityOwningEntity<GroupScoped<HasEncryptionMetadata>>.inGroup() =
		OwningEntityInGroup(entity.entity, entity.groupId, entityType, secretId)

	private suspend fun OwningEntityInGroup.toOwningEntityDetails(): OwningEntityDetails =
		OwningEntityDetails(
			groupId = groupId,
			id = entity.id,
			secretIds = crypto.entity.resolveSecretIdOption(groupId, entity, entityType, secretId),
		)

	private suspend fun doWithEncryptionMetadataAndDelegates(
		entityGroupId: String?,
		base: DecryptedCustomEntityBase?,
		owningEntity: OwningEntityInGroup?,
		user: User?,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "delegateOptions") Map<EntityReferenceInGroup, DelegateOptions>,
		alternateRootDataOwnerReference: EntityReferenceInGroup?,
	): DecryptedCustomEntityBase =
		crypto.entity.entityWithInitializedEncryptedMetadata(
			entityGroupId,
			(base ?: DecryptedCustomEntityBase(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			),
			type,
			owningEntityDetails = owningEntity?.toOwningEntityDetails(),
			initializeEncryptionKey = true,
			autoDelegations = delegates + user?.autoDelegationsFor(DelegationTag.MedicalInformation)
				.orEmpty().keyAsLocalDataOwnerReferences(),
			alternateRootDataOwnerReference = alternateRootDataOwnerReference,
		).updatedEntity

	override suspend fun getEncryptionKeysOf(entity: CustomEntityBase): Set<HexString> =
		doGetEncryptionKeysOf(null, entity)

	private suspend fun doGetEncryptionKeysOf(groupId: String?, entity: CustomEntityBase): Set<HexString> =
		crypto.entity.encryptionKeysOf(groupId, entity, type, null)

	override suspend fun getSecretIdsOf(entity: CustomEntityBase): Map<String, Set<EntityReferenceInGroup>> =
		doGetSecretIdsOf(null, entity)

	private suspend fun doGetSecretIdsOf(groupId: String?, entity: CustomEntityBase): Map<String, Set<EntityReferenceInGroup>> =
		ensureNonNull(crypto.entity.secretIdsWithDataOwnersInfo(groupId, listOf(entity), type).values.singleOrNull()) {
			"Method secretIdsWithDataOwnersInfo should have returned single item for single custom entity"
		}

	override suspend fun hasWriteAccess(entity: CustomEntityBase): Boolean =
		doHasWriteAccess(null, entity)

	private suspend fun doHasWriteAccess(groupId: String?, entity: CustomEntityBase): Boolean =
		crypto.entity.hasWriteAccess(groupId, entity, type)

	override suspend fun decryptOwningEntityIdsOf(entity: CustomEntityBase): Set<EntityReferenceInGroup> =
		doDecryptOwningEntityIdsOf(null, entity)

	private suspend fun doDecryptOwningEntityIdsOf(groupId: String?, entity: CustomEntityBase): Set<EntityReferenceInGroup> =
		crypto.entity.owningEntityIdsOf(groupId, entity, type, null).mapTo(mutableSetOf()) {
			crypto.entity.parseReference(groupId, it)
		}

	override suspend fun createDelegationDeAnonymizationMetadata(entity: CustomEntityBase, delegates: Set<String>) =
		doCreateDelegationDeAnonymizationMetadata(null, entity, delegates.asLocalDataOwnerReferences())

	private suspend fun doCreateDelegationDeAnonymizationMetadata(
		groupId: String?,
		entity: CustomEntityBase,
		delegates: Set<EntityReferenceInGroup>,
	) {
		crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(groupId, entity, type, delegates)
	}

	override suspend fun decrypt(entities: List<EncryptedCustomEntityBase>): List<DecryptedCustomEntityBase> =
		decryptedFlavour.maybeDecrypt(null, entities)

	override suspend fun tryDecrypt(entities: List<EncryptedCustomEntityBase>): List<CustomEntityBase> =
		tryAndRecoverFlavour.maybeDecrypt(null, entities)

	override suspend fun encryptOrValidate(entities: List<CustomEntityBase>): List<EncryptedCustomEntityBase> =
		tryAndRecoverFlavour.validateAndMaybeEncrypt(null, entities)

	override suspend fun shareEntitiesByIds(
		entityIds: List<String>,
		delegates: Map<String, CustomEntityShareOptions>,
	): BulkShareByIdsResult {
		val distinctIds = entityIds.toSet()
		if (distinctIds.isEmpty() || delegates.isEmpty()) {
			return BulkShareByIdsResult(emptySet(), emptyMap(), emptyMap(), emptyList())
		}
		val normalizedDelegates = delegates.mapKeys { EntityReferenceInGroup(it.key) }
		val stubs = rawApi.findCustomEntitiesDelegationsStubsByIds(entityIds = ListOfIds(distinctIds.toList())).successBody()
		val result = crypto.entity.simpleBulkShareOrUpdateEncryptedEntityMetadataNoEntities(
			entities = stubs,
			entitiesType = type,
			delegates = normalizedDelegates,
			autoRetry = true,
			getUpdatedEntity = { rawApi.getCustomEntity(entityId = it).successBody().asIcureStub() },
			doRequestBulkShareOrUpdate = { params -> rawApi.bulkShareMinimal(request = params).successBody() },
		)
		return result.toBulkShareByIdsResult(distinctIds, stubs.mapTo(mutableSetOf()) { it.id }, normalizedDelegates.keys)
	}

	override suspend fun getAndTryDecryptAttachment(
		entity: CustomEntityBase,
		key: String,
		decryptedAttachmentValidator: (suspend (attachment: ByteArray) -> Boolean)?,
	): ByteArray? =
		tryDecryptAttachment(entity, getRawAttachment(entity.id, key), decryptedAttachmentValidator)

	override suspend fun getAndDecryptAttachment(
		entity: CustomEntityBase,
		key: String,
		decryptedAttachmentValidator: (suspend (attachment: ByteArray) -> Boolean)?,
	): ByteArray =
		crypto.entity.decryptAttachmentOf(
			entityGroupId = null,
			entity = entity,
			entityType = type,
			content = getRawAttachment(entity.id, key),
			validator = decryptedAttachmentValidator,
		)

	override suspend fun tryDecryptAttachment(
		entity: CustomEntityBase,
		encryptedAttachment: ByteArray,
		decryptedAttachmentValidator: (suspend (attachment: ByteArray) -> Boolean)?,
	): ByteArray? =
		crypto.entity.tryDecryptAttachmentOf(null, entity, type, encryptedAttachment, decryptedAttachmentValidator)

	override suspend fun encryptAndSetAttachment(
		entity: CustomEntityBase,
		key: String,
		utis: List<String>?,
		attachment: ByteArray,
	): DecryptedCustomEntityBase {
		val aesKey = crypto.entity.tryDecryptAndImportAnyEncryptionKey(null, listOf(entity), type)[entity.id]?.key
			?: throw UnavailableEncryptionKeyException("Cannot extract encryption key from custom entity ${type.entityTypeId} ${entity.id}")
		val payload = crypto.primitives.aes.encrypt(attachment, aesKey)
		return setRawAttachment(
			entityId = entity.id,
			rev = requireNotNull(entity.rev) { "Custom entity must have a revision set before setting an attachment" },
			key = key,
			utis = utis,
			attachment = payload,
			encrypted = true,
		)
	}
}

/**
 * Creates the api for a custom entity type for users that are not data owners, or for a custom entity type that is not
 * encryptable.
 * @param rawApi raw api bound to the custom entity type.
 * @param entityTypeId the identifier of the custom entity type.
 */
@InternalIcureApi
internal fun initCustomEntityBasicApi(
	rawApi: RawCustomEntityApi,
	config: BasicApiConfiguration,
	entityTypeId: String,
): CustomEntityBasicApi = CustomEntityBasicApiImpl(
	rawApi,
	config,
	EntityWithEncryptionMetadataTypeName.Custom(entityTypeId),
	encryptedApiFlavour(config),
)

@InternalIcureApi
private class CustomEntityBasicApiImpl(
	private val rawApi: RawCustomEntityApi,
	private val config: BasicApiConfiguration,
	private val type: EntityWithEncryptionMetadataTypeName.Custom,
	private val encryptedFlavour: FlavouredApi<EncryptedCustomEntityBase, EncryptedCustomEntityBase>,
) : CustomEntityBasicApi,
	CustomEntityBasicFlavouredApi<EncryptedCustomEntityBase> by CustomEntityBasicFlavouredApiImpl(rawApi, config, encryptedFlavour),
	CustomEntityBasicFlavourlessApi by CustomEntityBasicFlavourlessApiImpl(rawApi, config, type) {
	override val inGroup: CustomEntityBasicInGroupApi = object : CustomEntityBasicInGroupApi,
		CustomEntityBasicFlavouredInGroupApi<EncryptedCustomEntityBase> by CustomEntityBasicFlavouredInGroupApiImpl(rawApi, config, encryptedFlavour),
		CustomEntityBasicFlavourlessInGroupApi by CustomEntityBasicFlavourlessInGroupApiImpl(rawApi, config, type) {}
}
