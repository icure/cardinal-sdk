package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.crypto.BaseSecurityMetadataDecryptor
import com.icure.cardinal.sdk.crypto.EntityEncryptionService
import com.icure.cardinal.sdk.crypto.EntityValidationService
import com.icure.cardinal.sdk.crypto.IncrementalSecurityMetadataDecryptor
import com.icure.cardinal.sdk.crypto.JsonEncryptionService
import com.icure.cardinal.sdk.crypto.SecureDelegationsManager
import com.icure.cardinal.sdk.crypto.UserEncryptionKeysManager
import com.icure.cardinal.sdk.crypto.decrypt
import com.icure.cardinal.sdk.crypto.entities.BulkShareResult
import com.icure.cardinal.sdk.crypto.entities.DecryptedMetadataDetails
import com.icure.cardinal.sdk.crypto.entities.DelegateShareOptions
import com.icure.cardinal.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.cardinal.sdk.crypto.entities.EntityDataEncryptionResult
import com.icure.cardinal.sdk.crypto.entities.EntityEncryptionKeyDetails
import com.icure.cardinal.sdk.crypto.entities.EntityEncryptionMetadataInitialisationResult
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.FailedRequestDetails
import com.icure.cardinal.sdk.crypto.entities.HierarchicallyDecryptedMetadata
import com.icure.cardinal.sdk.crypto.entities.MinimalBulkShareResult
import com.icure.cardinal.sdk.crypto.entities.OwningEntityDetails
import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.crypto.entities.SecurityMetadataType
import com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.cardinal.sdk.crypto.entities.SimpleDelegateShareOptions
import com.icure.cardinal.sdk.crypto.entities.SimpleDelegateShareOptionsImpl
import com.icure.cardinal.sdk.crypto.entities.SimpleShareResult
import com.icure.cardinal.sdk.crypto.entities.resolve
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.cardinal.sdk.model.requests.EntityShareOrMetadataUpdateRequest
import com.icure.cardinal.sdk.model.requests.RequestedPermission
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.cardinal.sdk.utils.IllegalEntityException
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.ensure
import com.icure.cardinal.sdk.utils.generation.JsMapAsObjectArray
import com.icure.cardinal.sdk.utils.getLogger
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.utils.toHexString
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject

@InternalIcureApi
class EntityEncryptionServiceImpl(
	private val secureDelegationsManager: SecureDelegationsManager,
	private val baseSecurityMetadataDecryptor: BaseSecurityMetadataDecryptor,
	private val incrementalSecurityMetadataDecryptor: IncrementalSecurityMetadataDecryptor,
	private val dataOwnerApi: DataOwnerApi,
	private val cryptoService: CryptoService,
	private val jsonEncryptionService: JsonEncryptionService,
	private val autoCreateEncryptionKeyForExistingLegacyData: Boolean,
	private val userEncryptionKeysManager: UserEncryptionKeysManager,
	private val boundGroup: SdkBoundGroup?
) : EntityEncryptionService, EntityValidationService by EntityValidationServiceImpl(jsonEncryptionService) {
	/*
	 * TODO should add bulk init encryption metadata?
	 */
	/*
	 * TODO various bulk share methods don't use the bulk decrypt methods, should switch
	 */

	companion object {
		private val log = getLogger("EntityEncryptionService")
	}

	override fun parseReference(sourceGroupId: String?, reference: String): EntityReferenceInGroup =
		EntityReferenceInGroup.parse(
			reference,
			sourceGroupId,
			boundGroup
		)

	override suspend fun encryptionKeysOf(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
		dataOwnerId: String?
	): Set<HexString> =
		decryptAllSecurityMetadata(
			entityGroupId,
			entity,
			entityType,
			dataOwnerId,
			SecurityMetadataType.EncryptionKey
		)

	override suspend fun secretIdsOf(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
		dataOwnerId: String?
	): Set<String> =
		decryptAllSecurityMetadata(
			entityGroupId,
			entity,
			entityType,
			dataOwnerId,
			SecurityMetadataType.SecretId
		)

	override suspend fun owningEntityIdsOf(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
		dataOwnerId: String?
	): Set<String> =
		decryptAllSecurityMetadata(
			entityGroupId,
			entity,
			entityType,
			dataOwnerId,
			SecurityMetadataType.OwningEntityId
		)

	private suspend fun <T : Any> decryptAllSecurityMetadata(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
		dataOwnerId: String?,
		securityMetadataType: SecurityMetadataType<T>
	): Set<T> =
		baseSecurityMetadataDecryptor.decryptAll(
			entityGroupId,
			listOf(entity),
			entityType,
			dataOwnersForDecryption(dataOwnerId).toSet(),
			securityMetadataType
		).values.single().mapTo(mutableSetOf()) {
			it.value
		}

	override suspend fun secretIdsOf(
		entityGroupId: String?,
		entities: List<HasEncryptionMetadata>,
		entitiesType: EntityWithEncryptionMetadataTypeName,
		dataOwnerId: String?
	): Map<String, Set<String>> =
		baseSecurityMetadataDecryptor.decryptAll(
			entityGroupId,
			entities,
			entitiesType,
			dataOwnersForDecryption(dataOwnerId).toSet(),
			SecurityMetadataType.SecretId
		).mapValues { (_, v) -> v.mapTo(mutableSetOf()) { it.value } }

	override suspend fun secretIdsWithDataOwnersInfo(
		entityGroupId: String?,
		entities: List<HasEncryptionMetadata>,
		entitiesType: EntityWithEncryptionMetadataTypeName
	): Map<String, Map<String, Set<EntityReferenceInGroup>>> =
		baseSecurityMetadataDecryptor.decryptAll(
			entityGroupId,
			entities,
			entitiesType,
			dataOwnersForDecryption(null).toSet(),
			SecurityMetadataType.SecretId
		).mapValues { (_, v) ->
			v.groupingBy {
				it.value
			}.aggregate { key, accumulator, element, _ ->
				if (accumulator != null)
					accumulator + element.dataOwnersWithAccess
				else
					element.dataOwnersWithAccess
			}
		}

	override suspend fun encryptionKeysForHcpHierarchyOf(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName
	): List<HierarchicallyDecryptedMetadata<HexString>> =
		decryptSecurityMetadataForHierarchy(entityGroupId, entity, entityType, SecurityMetadataType.EncryptionKey)

	override suspend fun secretIdsForHcpHierarchyOf(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName
	): List<HierarchicallyDecryptedMetadata<String>> =
		decryptSecurityMetadataForHierarchy(entityGroupId, entity, entityType, SecurityMetadataType.SecretId)

	override suspend fun owningEntityIdsForHcpHierarchyOf(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName
	): List<HierarchicallyDecryptedMetadata<String>> =
		decryptSecurityMetadataForHierarchy(entityGroupId, entity, entityType, SecurityMetadataType.OwningEntityId)

	private suspend fun <T : Any> decryptSecurityMetadataForHierarchy(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
		securityMetadataType: SecurityMetadataType<T>
	): List<HierarchicallyDecryptedMetadata<T>> {
		val hierarchyIds = dataOwnersForDecryption(null)
		val allDecryptedData = baseSecurityMetadataDecryptor.decryptAll(
			entityGroupId,
			listOf(entity),
			entityType,
			hierarchyIds.toSet(),
			securityMetadataType
		).values.single()
		return hierarchyIds.map { currDataOwner ->
			val currentDataOwnerReference = EntityReferenceInGroup(currDataOwner, null)
			HierarchicallyDecryptedMetadata(
				allDecryptedData
					.filter { currentDataOwnerReference in it.dataOwnersWithAccess }
					.map { it.value }
					.toSet(),
				currDataOwner
			)
		}
	}

	override suspend fun hasWriteAccess(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName
	): Boolean =
		baseSecurityMetadataDecryptor.getEntityAccessLevel(
			entityGroupId,
			entity,
			entityType,
			dataOwnersForDecryption(null).toSet()
		) == AccessLevel.Write

	override fun hasEmptyEncryptionMetadata(
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName
	): Boolean =
		hasEmptyEncryptionMetadata(entity, throwIfNonEmpty = false)

	private fun hasEmptyEncryptionMetadata(
		entity: HasEncryptionMetadata,
		throwIfNonEmpty: Boolean
	): Boolean {
		if (entity.securityMetadata != null) {
			if (throwIfNonEmpty) {
				throw IllegalArgumentException("Entity already has initialized security metadata")
			}
			return false
		}
		if (entity.secretForeignKeys.isNotEmpty()) {
			if (throwIfNonEmpty) {
				throw IllegalArgumentException("Entity already has initialized secret foreign keys")
			}
			return false
		}
		if (entity.delegations.isNotEmpty() || entity.cryptedForeignKeys.isNotEmpty() || entity.encryptionKeys.isNotEmpty()) {
			if (throwIfNonEmpty) {
				throw IllegalArgumentException("Entity already has initialized legacy security metadata")
			}
			return false
		}
		return true
	}

	override suspend fun <E, D> encryptEntities(
		entityGroupId: String?,
		unencryptedEntities: List<D>,
		entityType: EntityWithEncryptionMetadataTypeName,
		unencryptedEntitySerializer: SerializationStrategy<D>,
		fieldsToEncrypt: EncryptedFieldsManifest,
		constructor: (json: JsonElement) -> E
	): List<E> where E : HasEncryptionMetadata, D : HasEncryptionMetadata, E : Encryptable, D : Encryptable {
		val updatedEntities = unencryptedEntities.map { e ->
			ensureEncryptionKeysInitialized(
				entityGroupId,
				e,
				entityType
			) ?: e
		}
		val keyInfo = tryDecryptAndImportAnyEncryptionKey(entityGroupId, updatedEntities, entityType)
		if (updatedEntities.any { !keyInfo.containsKey(it.id) }) throw EntityEncryptionException(
			"Entities ${updatedEntities.map { it.id }} of type ${entityType.id} have no encryption keys, and can't be encrypted; entity may have not been initialized properly."
		)
		return updatedEntities.map {
			val plainJson = Serialization.json.encodeToJsonElement(unencryptedEntitySerializer, it).jsonObject
			val encryptedJson = jsonEncryptionService.encrypt(keyInfo.getValue(it.id).key, plainJson, fieldsToEncrypt)
			constructor(encryptedJson)
		}
	}

	private suspend fun <E, D> doDecryptEntities(
		entityGroupId: String?,
		encryptedEntities: List<E>,
		entityType: EntityWithEncryptionMetadataTypeName,
		encryptedEntitySerializer: SerializationStrategy<E>,
		constructor: (json: JsonElement) -> D
	): Map<String, Result<D>> where D : HasEncryptionMetadata, E : HasEncryptionMetadata, E : Encryptable, D : Encryptable =
		incrementalSecurityMetadataDecryptor.doManyIncrementallyDecryptingKeys(
			entityGroupId,
			encryptedEntities,
			entityType
		) { entity, _, keys ->
			kotlin.runCatching {
				val encryptedJson = Serialization.json.encodeToJsonElement(encryptedEntitySerializer, entity).jsonObject
				val decrypted = jsonEncryptionService.decrypt(
					keys,
					encryptedJson,
					"${entityType.id}(\"${entity.id}\")"
				)
				constructor(decrypted)
			}
		}

	override suspend fun <B, E : B, D : B> tryDecryptEntities(
		entityGroupId: String?,
		encryptedEntities: List<E>,
		entityType: EntityWithEncryptionMetadataTypeName,
		encryptedEntitySerializer: SerializationStrategy<E>,
		constructor: (json: JsonElement) -> D
	): List<B> where B : HasEncryptionMetadata, B : Encryptable {
		val decrypted = doDecryptEntities(entityGroupId, encryptedEntities, entityType, encryptedEntitySerializer, constructor)
		return encryptedEntities.map { decrypted[it.id]?.getOrNull() ?: it }
	}
	override suspend fun <E, D> decryptEntities(
		entityGroupId: String?,
		encryptedEntities: List<E>,
		entityType: EntityWithEncryptionMetadataTypeName,
		encryptedEntitySerializer: SerializationStrategy<E>,
		constructor: (json: JsonElement) -> D
	): List<D> where D : HasEncryptionMetadata, E : HasEncryptionMetadata, E : Encryptable, D : Encryptable {
		val decrypted = doDecryptEntities(entityGroupId, encryptedEntities, entityType, encryptedEntitySerializer, constructor)
		return encryptedEntities.map {
			(decrypted[it.id] ?: throw EntityEncryptionException("Couldn't decrypt any encryption key for ${entityType.id}(\"${it.id}\")")).getOrThrow()
		}
	}

	override suspend fun <T : HasEncryptionMetadata> encryptAttachmentOf(
		entityGroupId: String?,
		entity: T,
		entityType: EntityWithEncryptionMetadataTypeName,
		content: ByteArray,
		saveEntity: suspend (entity: T) -> T
	): EntityDataEncryptionResult<T> {
		val updatedEntity = ensureEncryptionKeysInitialized(
			entityGroupId,
			entity,
			entityType
		)?.let { saveEntity(it) }
		val encryptionKey = tryDecryptAndImportAnyEncryptionKey(
			entityGroupId,
			listOf(updatedEntity ?: entity),
			entityType
		)[entity.id]?.key
			?: throw IllegalArgumentException("Could not decrypt any encryption key for ${entityType.id}(\"${entity.id}\")")
		return EntityDataEncryptionResult(
			updatedEntity,
			cryptoService.aes.encrypt(content, encryptionKey),
		)
	}

	private suspend fun doDecryptAttachmentOf(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
		content: ByteArray,
		validator: (suspend (decryptedData: ByteArray) -> Boolean)?
	) =
		incrementalSecurityMetadataDecryptor.doIncrementallyDecryptingKeys(
			entityGroupId,
			entity,
			entityType
		) { _, _, keys ->
			keys.firstNotNullOfOrNull { key ->
				kotlin.runCatching {
					cryptoService.aes.decrypt(content, key.key).takeIf { validator == null || validator(it) }
				}.getOrNull()
			}?.let { Result.success(it) } ?: Result.failure(EntityEncryptionException(
				"No valid key found for the decryption of attachment of ${entityType.id}(\"${entity.id}\")"
			))
		}

	override suspend fun tryDecryptAttachmentOf(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
		content: ByteArray,
		validator: (suspend (decryptedData: ByteArray) -> Boolean)?
	): ByteArray? =
		doDecryptAttachmentOf(entityGroupId, entity, entityType, content, validator)?.getOrNull()

	override suspend fun decryptAttachmentOf(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
		content: ByteArray,
		validator: (suspend (decryptedData: ByteArray) -> Boolean)?
	): ByteArray = (
		doDecryptAttachmentOf(entityGroupId, entity, entityType, content, validator) ?: throw EntityEncryptionException(
			"No encryption key found for ${entityType.id}(\"${entity.id}\")"
		)
	).getOrThrow()

	override suspend fun tryDecryptAndImportAnyEncryptionKey(
		entityGroupId: String?,
		entities: List<HasEncryptionMetadata>,
		entitiesType: EntityWithEncryptionMetadataTypeName
	): Map<String, EntityEncryptionKeyDetails> =
		incrementalSecurityMetadataDecryptor.doManyIncrementallyDecryptingKeys(
			entityGroupId,
			entities,
			entitiesType,
		) { _, _, keys ->
			Result.success(keys.first())
		}.mapValues {
			it.value.getOrThrow()
		}

	override suspend fun decryptAndImportAllDecryptionKeys(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
	): List<EntityEncryptionKeyDetails> =
		encryptionKeysOf(entityGroupId = entityGroupId, entity = entity, entityType = entityType, dataOwnerId = null).mapNotNull {
			kotlin.runCatching {
				EntityEncryptionKeyDetails(cryptoService.aes.loadKey(AesAlgorithm.CbcWithPkcs7Padding, it.decodedBytes()), it)
			}.getOrNull()
		}

	override suspend fun <T : HasEncryptionMetadata> entityWithInitializedEncryptedMetadata(
        entityGroupId: String?,
        entity: T,
        entityType: EntityWithEncryptionMetadataTypeName,
        owningEntityDetails: OwningEntityDetails?,
        initializeEncryptionKey: Boolean,
        autoDelegations: Map<EntityReferenceInGroup, AccessLevel>,
        alternateRootDataOwnerReference: EntityReferenceInGroup?
    ): EntityEncryptionMetadataInitialisationResult<T> {
		hasEmptyEncryptionMetadata(entity, throwIfNonEmpty = true)
		val normalizedAutoDelegations = autoDelegations.mapKeys { it.key.normalized(boundGroup) }
		val newRawKey = if (initializeEncryptionKey)
			HexString(cryptoService.aes.exportKey(cryptoService.aes.generateKey(AesAlgorithm.CbcWithPkcs7Padding)).toHexString())
		else
			null
		val newSecretId = cryptoService.strongRandom.randomUUID()
		val entityWitSecurityMetadata = secureDelegationsManager.entityWithInitializedEncryptedMetadata(
			entityGroupId = entityGroupId,
			entity = entity,
			entityType = entityType,
			secretIds = setOf(newSecretId),
			owningEntityIds = setOfNotNull(
				owningEntityDetails?.let {
					EntityReferenceInGroup(it.id, it.groupId).asReferenceStringInGroup(
						entityGroupId,
						boundGroup
					)
				}
			),
			owningEntitySecretIds = owningEntityDetails?.secretIds.orEmpty(),
			encryptionKeys = setOfNotNull(newRawKey),
			autoDelegations = normalizedAutoDelegations,
			alternateRootDataOwnerReference = alternateRootDataOwnerReference,
		)
		return EntityEncryptionMetadataInitialisationResult(
			updatedEntity = entityWitSecurityMetadata,
			secretId = newSecretId,
			rawEncryptionKey = newRawKey
		)
	}

	override suspend fun <T : HasEncryptionMetadata> bulkShareOrUpdateEncryptedEntityMetadata(
		entityGroupId: String?,
		entitiesUpdates: List<Pair<T, Map<EntityReferenceInGroup, DelegateShareOptions>>>,
		entitiesType: EntityWithEncryptionMetadataTypeName,
		autoRetry: Boolean,
		getUpdatedEntity: suspend (String) -> T,
		doRequestBulkShareOrUpdate: suspend (request: BulkShareOrUpdateMetadataParams) -> List<EntityBulkShareResult<out T>>
	): BulkShareResult<T> {
		val normalizedEntitiesUpdates = entitiesUpdates.map { (e, rs) -> e to rs.mapKeys { it.key.normalized(boundGroup) } }
		val requestDetails = prepareBulkShareRequests(entityGroupId, normalizedEntitiesUpdates, entitiesType)
		val shareResult = doRequestBulkShareOrUpdate(
			BulkShareOrUpdateMetadataParams(
				requestDetails.requestsByEntityId.mapValues { (_, details) ->
					BulkShareOrUpdateMetadataParams.EntityRequestInformation(
						details.requests.mapValues { it.value.request },
						details.potentialParentDelegations
					)
				}
			)
		)
		val updatedEntities = shareResult.mapNotNull { it.updatedEntity }
		val updateErrors = shareResult.flatMap { result ->
			makeFailedRequestDetails(result.entityId, result.rejectedRequests, requestDetails)
		}
		if (autoRetry && updateErrors.isNotEmpty()) {
			val updateErrorsByEntityId = updateErrors.groupBy { it.entityId }
			val updatedEntitiesId = updatedEntities.map { it.id }.toSet()
			val toRetryEntitiesId = updateErrorsByEntityId.filter { (k, v) ->
				v.all { it.shouldRetry } && k !in requestDetails.unmodifiedEntityIds && k !in updatedEntitiesId
			}.keys
			if (toRetryEntitiesId.isNotEmpty()) {
				val updatedRequests = normalizedEntitiesUpdates.mapNotNull { (entity, request) ->
					if (entity.id in toRetryEntitiesId) {
						val updatedEntity = getUpdatedEntity(entity.id)
						if (updatedEntity.rev != entity.rev) {
							Pair(updatedEntity, request)
						} else null
					} else null
				}
				if (updatedRequests.isNotEmpty()) {
					val newResults = bulkShareOrUpdateEncryptedEntityMetadata(
						entityGroupId,
						updatedRequests,
						entitiesType,
						autoRetry,
						getUpdatedEntity,
						doRequestBulkShareOrUpdate
					)
					return BulkShareResult(
						updatedEntities = newResults.updatedEntities + updatedEntities.filter { it.id !in toRetryEntitiesId },
						unmodifiedEntitiesIds = newResults.unmodifiedEntitiesIds + requestDetails.unmodifiedEntityIds,
						updateErrors = newResults.updateErrors + updateErrors.filter { it.entityId !in toRetryEntitiesId }
					)
				}
			}
		}
		return BulkShareResult(updatedEntities, requestDetails.unmodifiedEntityIds, updateErrors)
	}

	override suspend fun bulkShareOrUpdateEncryptedEntityMetadataNoEntities(
		entitiesUpdates: List<Pair<HasEncryptionMetadata, Map<String, DelegateShareOptions>>>,
		entitiesType: EntityWithEncryptionMetadataTypeName,
		autoRetry: Boolean,
		getUpdatedEntity: suspend (String) -> HasEncryptionMetadata,
		doRequestBulkShareOrUpdate: suspend (request: BulkShareOrUpdateMetadataParams) -> List<EntityBulkShareResult<Nothing>>
	): MinimalBulkShareResult {
		val requestDetails = prepareBulkShareRequests(
			null,
			entitiesUpdates.map { (entity, updates) ->
				Pair(entity, updates.mapKeys { EntityReferenceInGroup(it.key, null) })
			},
			entitiesType
		)
		val shareResult = doRequestBulkShareOrUpdate(
			BulkShareOrUpdateMetadataParams(
				requestDetails.requestsByEntityId.mapValues { (_, details) ->
					BulkShareOrUpdateMetadataParams.EntityRequestInformation(
						details.requests.mapValues { it.value.request },
						details.potentialParentDelegations
					)
				}
			)
		)
		val updateErrors = shareResult.flatMap { result ->
			makeFailedRequestDetails(result.entityId, result.rejectedRequests, requestDetails)
		}
		val failedRequestsMinimalDetails = updateErrors.mapTo(mutableSetOf()) {
			MinimalBulkShareResult.MinimalRequestDetails(delegateId = it.delegateReference.entityId, entityId = it.entityId)
		}
		val successfulUpdates =  requestDetails.requestsByEntityId.flatMapTo(mutableSetOf()) { (entityId, request) ->
			request.requests.values.mapNotNull { delegateRequest ->
				MinimalBulkShareResult.MinimalRequestDetails(delegateId = delegateRequest.delegateReference.entityId, entityId = entityId).takeIf {
					!failedRequestsMinimalDetails.contains(it)
				}
			}
		}
		if (autoRetry && updateErrors.isNotEmpty()) {
			val updateErrorsByEntityId = updateErrors.groupBy { it.entityId }
			val toRetryEntitiesId = updateErrorsByEntityId.filter { (k, v) ->
				v.all { it.shouldRetry } && k !in requestDetails.unmodifiedEntityIds && successfulUpdates.none { it.entityId == k }
			}.keys
			if (toRetryEntitiesId.isNotEmpty()) {
				val updatedRequests = entitiesUpdates.mapNotNull { (entity, request) ->
					if (entity.id in toRetryEntitiesId) {
						val updatedEntity = getUpdatedEntity(entity.id)
						if (updatedEntity.rev != entity.rev) {
							Pair(updatedEntity, request)
						} else null
					} else null
				}
				if (updatedRequests.isNotEmpty()) {
					val newResults = bulkShareOrUpdateEncryptedEntityMetadataNoEntities(
						updatedRequests,
						entitiesType,
						autoRetry,
						getUpdatedEntity,
						doRequestBulkShareOrUpdate
					)
					return MinimalBulkShareResult(
						successfulUpdates = newResults.successfulUpdates + successfulUpdates.filter { it.entityId !in toRetryEntitiesId },
						unmodifiedEntitiesIds = newResults.unmodifiedEntitiesIds + requestDetails.unmodifiedEntityIds,
						updateErrors = newResults.updateErrors + updateErrors.filter { it.entityId !in toRetryEntitiesId }
					)
				}
			}
		}
		return MinimalBulkShareResult(successfulUpdates, requestDetails.unmodifiedEntityIds, updateErrors)
	}

	override tailrec suspend fun <T : HasEncryptionMetadata> simpleShareOrUpdateEncryptedEntityMetadata(
		entityGroupId: String?,
		entity: T,
		entityType: EntityWithEncryptionMetadataTypeName,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, SimpleDelegateShareOptions>,
		autoRetry: Boolean,
		getUpdatedEntity: suspend (String) -> T,
		doRequestBulkShareOrUpdate: suspend (request: BulkShareOrUpdateMetadataParams) -> List<EntityBulkShareResult<out T>>
	): SimpleShareResult<T> {
		val normalizedDelegates = delegates.mapKeys { it.key.normalized(boundGroup) }
		val availableEncryptionKeys = encryptionKeysOf(entityGroupId, entity, entityType, null)
		val availableOwningEntityIds = owningEntityIdsOf(entityGroupId, entity, entityType, null)
		val availableSecretIds = secretIdsOf(entityGroupId, entity, entityType, null)
		val extendedDelegateOptions = normalizedDelegates.mapValues { (_, simpleShareOptions) ->
			if (availableEncryptionKeys.isEmpty() && simpleShareOptions.shareEncryptionKey == ShareMetadataBehaviour.Required) {
				throw IllegalArgumentException("The current data owner can't access any encryption key in ${entityType.id}(\"${entity.id}\"), but sharing is required.")
			}
			if (availableOwningEntityIds.isEmpty() && simpleShareOptions.shareOwningEntityIds == ShareMetadataBehaviour.Required) {
				throw IllegalArgumentException("The current data owner can't access any owning entity id in ${entityType.id}(\"${entity.id}\"), but sharing is required.")
			}
			DelegateShareOptions(
				shareSecretIds = simpleShareOptions.shareSecretIds.resolve(availableSecretIds, entity, entityType),
				shareEncryptionKeys = if (simpleShareOptions.shareEncryptionKey == ShareMetadataBehaviour.Never) emptySet() else availableEncryptionKeys,
				shareOwningEntityIds = if (simpleShareOptions.shareOwningEntityIds == ShareMetadataBehaviour.Never) emptySet() else availableOwningEntityIds,
				requestedPermissions = simpleShareOptions.requestedPermissions
			)
		}
		val shareResult = bulkShareOrUpdateEncryptedEntityMetadata(
			entityGroupId,
			listOf(entity to extendedDelegateOptions),
			entityType,
			false,
			getUpdatedEntity,
			doRequestBulkShareOrUpdate
		)
		if (shareResult.unmodifiedEntitiesIds.contains(entity.id)) {
			return SimpleShareResult.Success(entity)
		}
		if (shareResult.updateErrors.isEmpty() && shareResult.updatedEntities.size == 1) {
			return SimpleShareResult.Success(shareResult.updatedEntities.first())
		}
		val errorsOfRequestedDelegates = shareResult.updateErrors.filter { normalizedDelegates.containsKey(it.delegateReference) }
		if (errorsOfRequestedDelegates.isEmpty() && shareResult.updatedEntities.size == 1) {
			log.w { "There was an internal error with the migration of encrypted metadata: ${shareResult.updateErrors}" }
			return SimpleShareResult.Success(shareResult.updatedEntities.first())
		}
		if (autoRetry && shareResult.updateErrors.all { it.shouldRetry }) {
			val updatedEntity = getUpdatedEntity(entity.id)
			if (updatedEntity.rev != entity.rev) {
				return simpleShareOrUpdateEncryptedEntityMetadata(
					entityGroupId,
					updatedEntity,
					entityType,
					normalizedDelegates,
					autoRetry,
					getUpdatedEntity,
					doRequestBulkShareOrUpdate
				)
			}
		}
		return SimpleShareResult.Failure(shareResult.updateErrors)
	}

	private fun makeFailedRequestDetails(
		entityId: String,
		shareResultRejectedRequests: Map<String, EntityBulkShareResult.RejectedShareOrMetadataUpdateRequest>,
		requestDetails: BulkShareRequestsDetails
	) =
		shareResultRejectedRequests.map { (rejectedRequestId, error) ->
			val originalRequestDetails = requestDetails.requestsByEntityId.getValue(entityId).requests.getValue(rejectedRequestId)
			FailedRequestDetails(
				delegateReference = originalRequestDetails.delegateReference,
				entityId = entityId,
				request = originalRequestDetails.options,
				updatedForMigration = originalRequestDetails.updatedForMigration,
				code = error.code,
				reason = error.reason,
				shouldRetry = error.shouldRetry
			)
		}


	private data class BulkShareRequestsDetails(
		// Entities that haven't been modified because no request was made. Doesn't include entities not modified due to errors.
		val unmodifiedEntityIds: Set<String>,
		val requestsByEntityId: Map<String, EntityShareRequestDetails>
	)
	private data class EntityShareRequestDetails(
		val requests: Map<String, DelegateShareRequestDetails>, // requestId (unique for the entity) -> request for a delegate
		val potentialParentDelegations: Set<SecureDelegationKeyString>
	)
	private data class DelegateShareRequestDetails(
		val delegateReference: EntityReferenceInGroup,
		val options: DelegateShareOptions?,
		val updatedForMigration: Boolean,
		val request: EntityShareOrMetadataUpdateRequest
	)

	private suspend fun prepareBulkShareRequests(
		entityGroupId: String?,
		entitiesUpdates: List<Pair<HasEncryptionMetadata, Map<EntityReferenceInGroup, DelegateShareOptions>>>,
		entitiesType: EntityWithEncryptionMetadataTypeName
	): BulkShareRequestsDetails {
		require (entitiesUpdates.distinctBy { it.first.id }.size == entitiesUpdates.size) {
			"Duplicate requests: the same entity id is present more than once in the input"
		}
		require (entitiesUpdates.all { it.first.rev != null }) {
			"Only existing entities can be shared"
		}
		val hierarchySet = dataOwnersForDecryption(null).toSet()
		val hierarchyReferenceSet = hierarchySet.map { EntityReferenceInGroup(it, null) }.toSet()
		val requestsByEntityId = mutableMapOf<String, EntityShareRequestDetails>()
		val unmodifiedEntityIds = mutableSetOf<String>()
		entitiesUpdates.forEach { (entity, optionsForDelegates) ->
			val migrationRequests = prepareMigrationRequestsIfNeeded(
				entityGroupId,
				entity,
				entitiesType,
				optionsForDelegates,
				hierarchySet
			)
			val otherRequests = optionsForDelegates.mapNotNull { (delegate, options) ->
				(
					if (!migrationRequests.containsKey(delegate)) {
						secureDelegationsManager.makeShareOrUpdateRequestParams(
							entityGroupId = entityGroupId,
							entity = entity,
							entityType = entitiesType,
							delegate = delegate,
							shareSecretIds = options.shareSecretIds,
							shareEncryptionKeys = options.shareEncryptionKeys,
							shareOwningEntityIds = options.shareOwningEntityIds,
							newDelegationPermissions = options.requestedPermissions
						)
					} else null
				)?.let { delegate to it }
			}
			val allRequests = migrationRequests.map {
				DelegateShareRequestDetails(it.key, optionsForDelegates[it.key], true, it.value)
			} + otherRequests.map {
				DelegateShareRequestDetails(it.first, optionsForDelegates[it.first], false, it.second)
			}
			if (allRequests.isNotEmpty()) {
				val potentialParentDelegations = baseSecurityMetadataDecryptor.getSecureDelegationMemberDetails(
					entityGroupId,
					entity,
					entitiesType
				).mapNotNullTo(
					mutableSetOf()
				) { (delegationKey, delegationInfo) ->
					if (delegationInfo.delegate in hierarchyReferenceSet || delegationInfo.delegator in hierarchyReferenceSet)
						delegationKey
					else
						null
				}
				requestsByEntityId[entity.id] = EntityShareRequestDetails(
					allRequests.mapIndexed { index, it ->
						// Even though the delegate id could be a valid request id it could leak some secret information if it is a patient id.
						index.toString() to it
					}.toMap(),
					potentialParentDelegations
				)
			} else unmodifiedEntityIds.add(entity.id)
		}
		return BulkShareRequestsDetails(unmodifiedEntityIds, requestsByEntityId)
	}

	private suspend fun prepareMigrationRequestsIfNeeded(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
		optionsForDelegates: Map<EntityReferenceInGroup, DelegateShareOptions>,
		hierarchy: Set<String>
	): Map<EntityReferenceInGroup, EntityShareOrMetadataUpdateRequest> {
		val legacySecretIds = baseSecurityMetadataDecryptor.decryptAllLegacyDelegations(
			entityGroupId,
			listOf(entity),
			entityType,
			hierarchy,
			SecurityMetadataType.SecretId
		).values.single()
		val legacyOwningEntityIds = baseSecurityMetadataDecryptor.decryptAllLegacyDelegations(
			entityGroupId,
			listOf(entity),
			entityType,
			hierarchy,
			SecurityMetadataType.OwningEntityId
		).values.single()
		val legacyEncryptionKeys = baseSecurityMetadataDecryptor.decryptAllLegacyDelegations(
			entityGroupId,
			listOf(entity),
			entityType,
			hierarchy,
			SecurityMetadataType.EncryptionKey
		).values.single()
		return hierarchy.map { EntityReferenceInGroup(it, null) }.mapNotNull { currMember ->
			makeMigrationRequestForMemberOfHierarchy(
				entityGroupId = entityGroupId,
				entity = entity,
				entityType = entityType,
				currMember = currMember,
				userRequest = optionsForDelegates[currMember],
				legacySecretIds = legacySecretIds,
				legacyOwningEntityIds = legacyOwningEntityIds,
				legacyEncryptionKeys = legacyEncryptionKeys
			)?.let { currMember to it }
		}.toMap()
	}

	private suspend fun makeMigrationRequestForMemberOfHierarchy(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
		currMember: EntityReferenceInGroup,
		userRequest: DelegateShareOptions?,
		legacySecretIds: List<DecryptedMetadataDetails<String>>,
		legacyOwningEntityIds: List<DecryptedMetadataDetails<String>>,
		legacyEncryptionKeys: List<DecryptedMetadataDetails<HexString>>
	): EntityShareOrMetadataUpdateRequest? {
		val resolvedEntityGroup = boundGroup.resolve(entityGroupId)
		val selfId = dataOwnerApi.getCurrentDataOwnerId()
		val subHierarchy = dataOwnersForDecryption(currMember.entityId)
		val subHierarchySet = subHierarchy.toSet()
		val hasLegacyOrImplicitAccess = baseSecurityMetadataDecryptor.getEntityLegacyDelegationAccessLevel(
				entityGroupId,
				entity,
				entityType,
				subHierarchySet
			) != null || (selfId == entity.id && currMember.entityId == selfId && resolvedEntityGroup == null)
		if (!hasLegacyOrImplicitAccess) return null
		val mustCreateRootDelegation =
			currMember.entityId == selfId && baseSecurityMetadataDecryptor.getEntitySecureDelegationsAccessLevel(
				entityGroupId,
				entity,
				entityType,
				subHierarchySet
			) != AccessLevel.Write
		val subHierarchyReferenceSet = subHierarchySet.mapTo(mutableSetOf()) { EntityReferenceInGroup(it, null) }
		val delegateLegacySecretIds = legacySecretIds.valuesAvailableToDataOwners(subHierarchyReferenceSet)
		val delegateLegacyOwningEntityIds = legacyOwningEntityIds.valuesAvailableToDataOwners(subHierarchyReferenceSet)
		val delegateLegacyEncryptionKeys = legacyEncryptionKeys.valuesAvailableToDataOwners(subHierarchyReferenceSet)
		val missingLegacySecretIds =
			if (delegateLegacySecretIds.isEmpty())
				delegateLegacySecretIds
			else
				(delegateLegacySecretIds - baseSecurityMetadataDecryptor.decryptAllSecureDelegations(
					entityGroupId,
					listOf(entity),
					entityType,
					subHierarchySet,
					SecurityMetadataType.SecretId
				).getValue(entity.id).map { it.value }.toSet())
		val missingLegacyOwningEntityIds =
			if (delegateLegacyOwningEntityIds.isEmpty())
				delegateLegacyOwningEntityIds
			else
				(delegateLegacyOwningEntityIds - baseSecurityMetadataDecryptor.decryptAllSecureDelegations(
					entityGroupId,
					listOf(entity),
					entityType,
					subHierarchySet,
					SecurityMetadataType.OwningEntityId
				).getValue(entity.id).map { it.value }.toSet())
		val missingLegacyEncryptionKeys =
			if (delegateLegacyEncryptionKeys.isEmpty())
				delegateLegacyEncryptionKeys
			else
				(delegateLegacyEncryptionKeys - baseSecurityMetadataDecryptor.decryptAllSecureDelegations(
					entityGroupId,
					listOf(entity),
					entityType,
					subHierarchySet,
					SecurityMetadataType.EncryptionKey
				).getValue(entity.id).map { it.value }.toSet())
		return if (missingLegacySecretIds.isNotEmpty() || missingLegacyOwningEntityIds.isNotEmpty() || missingLegacyEncryptionKeys.isNotEmpty() || mustCreateRootDelegation) {
			secureDelegationsManager.makeShareOrUpdateRequestParams(
				entityGroupId,
				entity,
				entityType,
				currMember,
				missingLegacySecretIds + (userRequest?.shareSecretIds ?: emptySet()),
				missingLegacyEncryptionKeys + (userRequest?.shareEncryptionKeys ?: emptySet()),
				missingLegacyOwningEntityIds + (userRequest?.shareOwningEntityIds ?: emptySet()),
				if (mustCreateRootDelegation)
					RequestedPermission.Root
				else
					RequestedPermission.FullWrite // Legacy permission if present is always write
			)
		} else null
	}

	override suspend fun <T : HasEncryptionMetadata> ensureEncryptionKeysInitialized(
		entityGroupId: String?,
		entity: T,
		entityType: EntityWithEncryptionMetadataTypeName
	): T? {
		if (baseSecurityMetadataDecryptor.hasAnyEncryptionKeys(entity)) {
			return null
		}
		require(entity.rev != null) {
			"A new ${entityType.id} does not have encryption keys initialized: make sure the entity was created using the `newInstance` method from the appropriate api before trying to save it."
		}
		if (autoCreateEncryptionKeyForExistingLegacyData && entity.delegations.isNotEmpty()) {
			require(boundGroup.resolve(entityGroupId) == null) {
				"${entityType.id}(\"${entity.id}\") uses delegations as encryption keys, but SDK instance can't create required new key as the entity exist in a different group"
			}
			/*
			 * Handle rare pre-2018 cases where entities was using delegation key (-> secretId) as encryption key.
			 *
			 * If entity was using delegations as legacy encryption keys we will essentially revoke the access to the encrypted data for all other data
			 * owners. This however should not be a problem as this form of legacy entities should not exist anymore, and it should be present only in the
			 * databases of hcps without collaborators.
			 */
			val newKey = cryptoService.aes.generateKey(AesAlgorithm.CbcWithPkcs7Padding)
			return secureDelegationsManager.entityWithInitializedEncryptedMetadata(
				entityGroupId = null,
				entity = entity,
				entityType = entityType,
				secretIds = emptySet(), // Will still be available through legacy delegations
				owningEntityIds = emptySet(), // Will still be available through legacy delegations
				owningEntitySecretIds = entity.secretForeignKeys,
				encryptionKeys = setOf(HexString(cryptoService.aes.exportKey(newKey).toHexString())),
				autoDelegations = emptyMap(),
			)
		} else throw IllegalEntityException(
			"Existing ${entityType.id}(\"${entity.id}\") does not have any recognised encryption metadata available, but encryption keys are required to perform an operation."
		)
	}

	override suspend fun <T : HasEncryptionMetadata> initializeConfidentialSecretId(
		entityGroupId: String?,
		entity: T,
		entityType: EntityWithEncryptionMetadataTypeName,
		getUpdatedEntity: suspend (String) -> T,
		doRequestBulkShareOrUpdate: suspend (request: BulkShareOrUpdateMetadataParams) -> List<EntityBulkShareResult<out T>>
	): T? {
		if (entity.rev == null) {
			throw IllegalArgumentException("Entity must be an existing entity to initialize a confidential secret id")
		}
		if (getConfidentialSecretIdsOf(entityGroupId, entity, entityType, null).isNotEmpty()) return null
		return simpleShareOrUpdateEncryptedEntityMetadata(
			entityGroupId,
			entity,
			entityType,
			mapOf(EntityReferenceInGroup(userEncryptionKeysManager.delegatorActorId(), null) to SimpleDelegateShareOptionsImpl(
				shareSecretIds = SecretIdShareOptions.UseExactly(
					secretIds = setOf(cryptoService.strongRandom.randomUUID()),
					createUnknownSecretIds = true
				),
				shareEncryptionKey = ShareMetadataBehaviour.Never,
				shareOwningEntityIds = ShareMetadataBehaviour.Never,
				requestedPermissions = RequestedPermission.MaxWrite
			)
			),
			true,
			getUpdatedEntity,
			doRequestBulkShareOrUpdate
		).updatedEntityOrThrow()
	}

	override suspend fun getConfidentialSecretIdsOf(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
		dataOwnerId: String?
	): Set<String> {
		val secretIdsInfo = secretIdsForHcpHierarchyOf(entityGroupId, entity, entityType)
		val targetDataOwner = dataOwnerId ?: userEncryptionKeysManager.delegatorActorId()
		val parents = secretIdsInfo.takeWhile { it.ownerId != targetDataOwner }
		require(parents.size < secretIdsInfo.size) {
			"Target data owner $targetDataOwner is not in the hierarchy of the logged data owner"
		}
		val res = secretIdsInfo[parents.size].extracted.toMutableSet()
		parents.forEach { res -= it.extracted }
		return res
	}

	override suspend fun getSecretIdsSharedWithParentsOf(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
	): Set<String> =
		secretIdsForHcpHierarchyOf(entityGroupId, entity, entityType).first().extracted


	override suspend fun resolveSecretIdOption(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
		secretIdUseOption: SecretIdUseOption
	): Set<String> =
		when (secretIdUseOption) {
			is SecretIdUseOption.Use -> secretIdUseOption.secretIds
			SecretIdUseOption.UseAnyConfidential -> getConfidentialSecretIdsOf(
				entityGroupId = entityGroupId,
				entity = entity,
				entityType = entityType,
				dataOwnerId = null
			).also {
				require(it.isNotEmpty()) {
					"No valid secret id found for option $secretIdUseOption"
				}
			}.let { setOf(it.first()) }
			SecretIdUseOption.UseAllConfidential -> getConfidentialSecretIdsOf(
				entityGroupId = entityGroupId,
				entity = entity,
				entityType = entityType,
				dataOwnerId = null
			).also {
				require(it.isNotEmpty()) {
					"No valid secret id found for option $secretIdUseOption"
				}
			}
			SecretIdUseOption.UseAnySharedWithParent -> getSecretIdsSharedWithParentsOf(
				entityGroupId = entityGroupId,
				entityType = entityType,
				entity = entity
			).also {
				require(it.isNotEmpty()) {
					"No valid secret id found for option $secretIdUseOption"
				}
			}.let { setOf(it.first()) }
			SecretIdUseOption.UseAllSharedWithParent -> getSecretIdsSharedWithParentsOf(
				entityGroupId = entityGroupId,
				entityType = entityType,
				entity = entity
			).also {
				require(it.isNotEmpty()) {
					"No valid secret id found for option $secretIdUseOption"
				}
			}
			SecretIdUseOption.UseNone -> emptySet()
		}

	private fun <T : Any> Iterable<DecryptedMetadataDetails<T>>.valuesAvailableToDataOwners(dataOwners: Set<EntityReferenceInGroup>): Set<T> =
		mapNotNullTo(mutableSetOf()) { decryptedDataDetails -> if (dataOwners.any { it in decryptedDataDetails.dataOwnersWithAccess }) decryptedDataDetails.value else null }

	private suspend fun SecretIdShareOptions.resolve(
		entitySecretIds: Set<String>,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName
	) = when (this) {
		is SecretIdShareOptions.AllAvailable -> entitySecretIds.also {
			require (!requireAtLeastOne || it.isNotEmpty()) {
				"No secret id could be extracted by the current user for ${entityType.id}(\"${entity.id}\")"
			}
		}
		is SecretIdShareOptions.UseExactly ->
			secretIds.also {
				if (!createUnknownSecretIds) {
					require (entitySecretIds.containsAll(secretIds)) {
						"Unknown secret ids for ${entityType.id}(\"${entity.id}\") and `createUnknownSecretIds` is false: ${
							secretIds - entitySecretIds
						}"
					}
				}
			}
	}

	private fun dataOwnersForDecryption(startingFrom: String?) =
		userEncryptionKeysManager.delegatorActorHierarchy(startingFrom)
}
