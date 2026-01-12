package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.crypto.entities.BulkShareResult
import com.icure.cardinal.sdk.crypto.entities.DelegateShareOptions
import com.icure.cardinal.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.cardinal.sdk.crypto.entities.EntityDataEncryptionResult
import com.icure.cardinal.sdk.crypto.entities.EntityEncryptionKeyDetails
import com.icure.cardinal.sdk.crypto.entities.EntityEncryptionMetadataInitialisationResult
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.HierarchicallyDecryptedMetadata
import com.icure.cardinal.sdk.crypto.entities.MinimalBulkShareResult
import com.icure.cardinal.sdk.crypto.entities.OwningEntityDetails
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.crypto.entities.SimpleDelegateShareOptions
import com.icure.cardinal.sdk.crypto.entities.SimpleShareResult
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.json.JsonElement

/**
 * Gives access to several functions to access encrypted entities metadata.
 *
 * The implementations must be thread safe, although it is possible that due to caching using two of these methods in
 * parallel could actually be more costly in terms of requests to the backend than using each method separately.
 */
@InternalIcureApi
interface EntityEncryptionService : EntityValidationService {
	// region metadata decryption
	/**
	 * Parse an entity reference string coming from group [sourceGroupId] (null for being current user group)
	 * Return a reference with null groupId if local
	 */
	fun parseReference(
		sourceGroupId: String?,
		reference: String
	): EntityReferenceInGroup

	/**
	 * Get the encryption keys of an entity that the provided data owner can access, potentially using the keys for his parent.
	 * There should only be one encryption key for each entity, but the method supports more to allow to deal with conflicts and merged duplicate data.
	 * @param entity an encrypted entity.
	 * @param dataOwnerId optionally a data owner part of the hierarchy for the current data owner, defaults to the current data owner.
	 * @return the encryption keys that the provided data owner can decrypt, deduplicated.
	 */
	suspend fun encryptionKeysOf(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
		dataOwnerId: String?,
	): Set<HexString>

	/**
	 * Get the encryption keys of an entity that the current data owner and his parents can access. The resulting array contains the keys for each data
	 * owner in the hierarchy which can be decrypted using only that data owner keys (excludes keys accessible through the parent keys). The order of
	 * the array is the same as in {@link IccDataOwnerXApi.getCurrentDataOwnerHierarchyIds}.
	 * Note that different data owners may have access to the same keys, but the keys extracted for each data owner are deduplicated.
	 * There should only be one encryption key for each entity, but the method supports more to allow to deal with conflicts and merged duplicate data.
	 * @param entity an encrypted entity.
	 * @return the encryption keys that each member of the current data owner hierarchy can decrypt using only his keys and not keys of his parents.
	 */
	suspend fun encryptionKeysForHcpHierarchyOf(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName
	): List<HierarchicallyDecryptedMetadata<HexString>>

	/**
	 * Get the secret ids (SFKs) of an entity that the provided data owner can access, potentially using the keys for his parent.
	 * @param entity an encrypted entity.
	 * @param dataOwnerId optionally a data owner part of the hierarchy for the current data owner, defaults to the current data owner.
	 * @return the secret ids (SFKs) that the provided data owner can decrypt, deduplicated (including keys decrypted from the hierarchy).
	 */
	suspend fun secretIdsOf(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
		dataOwnerId: String?,
	): Set<String>

	suspend fun secretIdsOf(
		entityGroupId: String?,
		entities: List<HasEncryptionMetadata>,
		entitiesType: EntityWithEncryptionMetadataTypeName,
		dataOwnerId: String?,
	): Map<String, Set<String>>

	suspend fun secretIdsWithDataOwnersInfo(
		entityGroupId: String?,
		entities: List<HasEncryptionMetadata>,
		entitiesType: EntityWithEncryptionMetadataTypeName
	): Map<String, Map<String, Set<EntityReferenceInGroup>>>

	/**
	 * Get the secret ids (SFKs) of an entity that the current data owner and his parents can access. The resulting array contains the ids for each data
	 * owner in the hierarchy which can be decrypted using only that data owner keys (excludes ids accessible through the parent keys). The order of
	 * the array is the same as in {@link IccDataOwnerXApi.getCurrentDataOwnerHierarchyIds}.
	 * Note that different data owners may have access to the same secret ids, but the secret ids extracted for each data owner are deduplicated.
	 * @param entity an encrypted entity.
	 * @return the secret ids that each member of the current data owner hierarchy can decrypt using only his keys and not keys of his parents.
	 */
	suspend fun secretIdsForHcpHierarchyOf(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName
	): List<HierarchicallyDecryptedMetadata<String>>

	/**
	 * Get the decrypted owning entity ids (formerly CFKs) for the provided entity that can be decrypted using the private keys of the current data
	 * owner and his parents. The owning entity id would be, for example, the id of a patient for contact and healthcare elements, or the id of a
	 * message for documents.
	 * There should only be one owning entity id for each entity, but the method supports more to allow to deal with conflicts and merged duplicate
	 * data.
	 * @param entity an encrypted entity.
	 * @param dataOwnerId optionally a data owner part of the hierarchy for the current data owner, defaults to the current data owner.
	 * @return the owning entity ids (CFKs) that the provided data owner can decrypt, deduplicated.
	 */
	suspend fun owningEntityIdsOf(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
		dataOwnerId: String?,
	): Set<String>

	/**
	 * Get the decrypted owning entity ids (formerly CFKs) for the provided entity that can be decrypted using the private keys of the current data
	 * owner and his parents. The owning entity id would be, for example, the id of a patient for contact and healthcare elements, or the id of a
	 * message for documents.
	 * The resulting array contains the ids for each data owner in the hierarchy which can be decrypted using only that data owner keys (excludes ids
	 * accessible through the parent keys). The order of the array is the same as in {@link IccDataOwnerXApi.getCurrentDataOwnerHierarchyIds}.
	 * Note that different data owners may have access to the same owning entity ids, but the owning entity ids extracted for each data owner are
	 * deduplicated in case they could be accessed through different delegations.
	 * There should only be one owning entity id for each entity, but the method supports more to allow to deal with conflicts and merged duplicate
	 * data.
	 * @param entity an encrypted entity.
	 * @return the owning entity ids that each member of the current data owner hierarchy can decrypt using only his keys and not keys of his parents.
	 */
	suspend fun owningEntityIdsForHcpHierarchyOf(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName
	): List<HierarchicallyDecryptedMetadata<String>>

	/**
	 * Get if the current data owner has write access to the content of the entity.
	 * @param entity an entity
	 * @return if the current data owner (or one of his parents) has write access to the content of the entity.
	 */
	suspend fun hasWriteAccess(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName
	): Boolean

	/**
	 * @param entity an entity
	 * @return if the entity has no encryption metadata and can be safely initialized.
	 */
	fun hasEmptyEncryptionMetadata(
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName
	): Boolean
	// endregion

	// region metadata initialisation and share
	/**
	 * Initializes encryption metadata for an entity. This includes the encrypted secret id, owning entity id, encryption key for the entity, and
	 * the clear text secret foreign key of the parent entity.
	 * This method returns a modified copy of the entity and DOES NOT SAVE the entity to the cloud/DB: you will have to save the entity manually.
	 * @param entity entity which requires encryption metadata initialisation.
	 * @param owningEntityDetails details of the owning entity, if any (e.g. patient id for Contact/HealtchareElement, message id for Document, ...).
	 * @param owningEntitySecretId secret id of the parent entity, to use in the secret foreign keys for the provided entity, if any.
	 * @param initializeEncryptionKey if false this method will not initialize an encryption key for the entity. Use only for entities which use
	 * delegations for access control but don't actually have any encrypted content.
	 * @param initializeSecretId if false this method will not initialize any secret id, use it for entities which can not be 'owning entities' (e.g.
	 * HealthElement).
	 * @param autoDelegations automatically shares the metadata with the provided data owners, with the provided access level.
	 * @throws if the entity already has non-empty values for encryption metadata.
	 * @return an updated copy of the entity.
	 */
	suspend fun <T : HasEncryptionMetadata> entityWithInitializedEncryptedMetadata(
		entityGroupId: String?,
		entity: T,
		entityType: EntityWithEncryptionMetadataTypeName,
		owningEntityDetails: OwningEntityDetails?,
		initializeEncryptionKey: Boolean,
		autoDelegations: Map<EntityReferenceInGroup, AccessLevel>,
		alternateRootDataOwnerReference: EntityReferenceInGroup? = null,
	): EntityEncryptionMetadataInitialisationResult<T>

	/**
	 * Updates encryption metadata for an entity in order to share it with a delegate or in order to add additional encrypted metadata for an existing
	 * delegate.
	 * The first time this method is used for a specific delegate it will give access to all unencrypted content of the entity to the delegate data
	 * owner. Additionally, this method also allows to share new or existing secret ids (shareSecretId), encryption keys (shareEncryptionKeys) and
	 * owning entity ids (shareOwningEntityIds) for the entity.
	 * You can use methods like {@link secretIdsOf}, {@link secretIdsForHcpHierarchyOf}, {@link encryptionKeysOf}, ... to retrieve the data you want to
	 * share. In most cases you may want to share everything related to the entity, but note that if you use confidential delegations for patients you
	 * may want to avoid sharing the confidential secret ids of the current user with other hcps.
	 * This updates the entity in the cloud/DB (the updated entities in the returned promise are already saved in the DB). NOTE: this method can only
	 * be used with entities which already exist in the cloud (the entities must have been saved).
	 * @param entitiesType type of entities to update
	 * @param entitiesUpdates share/update requests for each entity. An array of objects containing:
	 * - The entity to share/update (or at least its encrypted metadata)
	 * - The data to share/update for each delegate. An object associating to each delegate id the data to share/update for that delegate, and the
	 * permissions requested for the delegate (ignored if the request will only update already existing shared metadata).
	 * @param doRequestBulkShareOrUpdate perform the request to share or update an entity encrypted metadata on the cloud API (and save to DB).
	 * @throws if there are duplicate entities in the requested updates or if not all the entities have the same type.
	 * @return a promise which will be completed with an object containing:
	 * - the updated entities, only for entities were at least one update was successful
	 * - information on the individual requests failed, containing the id of the entity, id of the delegate that the request was for, the content,
	 * an error code mirroring an http status code, and a human-friendly description of the error (but not necessarily end-user friendly).
	 */
	suspend fun <T : HasEncryptionMetadata> bulkShareOrUpdateEncryptedEntityMetadata(
		entityGroupId: String?,
		entitiesUpdates: List<Pair<T, Map<EntityReferenceInGroup, DelegateShareOptions>>>,
		entitiesType: EntityWithEncryptionMetadataTypeName,
		autoRetry: Boolean,
		getUpdatedEntity: suspend (String) -> T,
		doRequestBulkShareOrUpdate: suspend (request: BulkShareOrUpdateMetadataParams) -> List<EntityBulkShareResult<out T>>
	): BulkShareResult<T>

	suspend fun bulkShareOrUpdateEncryptedEntityMetadataNoEntities(
		entitiesUpdates: List<Pair<HasEncryptionMetadata, Map<String, DelegateShareOptions>>>,
		entitiesType: EntityWithEncryptionMetadataTypeName,
		autoRetry: Boolean,
		getUpdatedEntity: suspend (String) -> HasEncryptionMetadata,
		doRequestBulkShareOrUpdate: suspend (request: BulkShareOrUpdateMetadataParams) -> List<EntityBulkShareResult<Nothing>>
	): MinimalBulkShareResult

	/**
	 * Simplified version of {@link bulkShareOrUpdateEncryptedEntityMetadata} for a single entity and with automatic retrieval of the encryption keys
	 * and owning entity ids if requested. NOTE: this method can only be used with entities which already exist in the cloud (the entity must have
	 * been saved).
	 * @param entity an entity.
	 * @param unusedSecretIds specifies if the entity should not actually use secret ids but may have some if it was created using older iCure sdk
	 * versions. If true the method expects `shareSecretIds` options to always be undefined and will always share any available secret ids. If false
	 * it expects `shareSecretIds` options to always be defined and will only share the secret ids specified in the options.
	 * @param delegates associates the id of data owners which will be granted access to the entity, to the following sharing options:
	 * - shareEncryptionKeys specifies if the encryption keys of the entity should be shared. Defaults to
	 * {@link ShareMetadataBehaviour.IF_AVAILABLE}.
	 * - shareOwningEntityIds specifies if the owning entity ids of the entity should be shared. Defaults to
	 * {@link ShareMetadataBehaviour.IF_AVAILABLE}.
	 * - shareSecretIds specifies which secret ids of the entity should be shared. Should be defined only if {@link unusedSecretIds} is false.
	 * - requestedPermissions requested permissions for the delegate. Defaults to {@link RequestedPermissionEnum.MAX_WRITE}.
	 * @param doRequestBulkShareOrUpdate perform the request to share or update an entity encrypted metadata on the cloud API (and save to DB).
	 * @return a promise which will be completed with the result of the operation
	 * @throws if shareEncryptionKeys or shareOwningEntityIds is {@link ShareMetadataBehaviour.REQUIRED} and the current data owner can't access any
	 * value for the required metadata.
	 */
	suspend fun <T : HasEncryptionMetadata> simpleShareOrUpdateEncryptedEntityMetadata(
		entityGroupId: String?,
		entity: T,
		entityType: EntityWithEncryptionMetadataTypeName,
		delegates: Map<EntityReferenceInGroup, SimpleDelegateShareOptions>,
		autoRetry: Boolean,
		getUpdatedEntity: suspend (String) -> T,
		doRequestBulkShareOrUpdate: suspend (request: BulkShareOrUpdateMetadataParams) -> List<EntityBulkShareResult<out T>>
	): SimpleShareResult<T>
	// endregion

	// region content encryption and decryption
	/**
	 * Encrypts data using a key of the entity that the provided data owner can access (current data owner by default). If the provided data owner can
	 * access multiple encryption keys of the entity there is no guarantee on which key will be used.
	 * Note: you should not use this method to encrypt the `encryptedSelf` of iCure entities, since that will be automatically handled by the extended
	 * apis. You should use this method only to encrypt additional data, such as document attachments.
	 * @param entity an entity.
	 * @param type type of the entity.
	 * @param content data of the entity which you want to encrypt.
	 * @param saveEntity a function which saves the entity to the cloud/DB. Used only if a new encryption key needed to be initialized for the entity.
	 * @return the encrypted data and, if a new encryption key was initialized for the entity, the updated entity.
	 * @throws if the provided data owner can't access any encryption keys for the entity.
	 */
	suspend fun <T : HasEncryptionMetadata> encryptAttachmentOf(
		entityGroupId: String?,
		entity: T,
		entityType: EntityWithEncryptionMetadataTypeName,
		content: ByteArray,
		saveEntity: suspend (entity: T) -> T,
	): EntityDataEncryptionResult<T>

	/**
	 * Decrypts data using a key of the entity that the provided data owner can access (current data owner by default). If the provided data owner can
	 * access multiple encryption keys each of them will be tried for decryption until one of them gives a result that is valid according to the
	 * provided validator.
	 * Note: you should not use this method to decrypt the `encryptedSelf` of iCure entities, since that will be automatically handled by the extended
	 * apis. You should use this method only to decrypt additional data, such as document attachments.
	 * @param entity an entity.
	 * @param content data of the entity which you want to decrypt.
	 * @param validator a function which verifies the correctness of decrypted content: helps to identify decryption with the wrong key without relying
	 * solely on padding.
	 * @return the decrypted data or null if the provided data owner cannot access any encryption key for the entity or if no key could be found
	 * which provided valid decrypted content according to the validator.
	 */
	suspend fun tryDecryptAttachmentOf(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
		content: ByteArray,
		validator: (suspend (decryptedData: ByteArray) -> Boolean)?,
	): ByteArray?

	/**
	 * Decrypts data using a key of the entity that the provided data owner can access (current data owner by default). If the provided data owner can
	 * access multiple encryption keys each of them will be tried for decryption until one of them gives a result that is valid according to the
	 * provided validator.
	 * Note: you should not use this method to decrypt the `encryptedSelf` of iCure entities, since that will be automatically handled by the extended
	 * apis. You should use this method only to decrypt additional data, such as document attachments.
	 * @param entity an entity.
	 * @param content data of the entity which you want to decrypt.
	 * @param validator a function which verifies the correctness of decrypted content: helps to identify decryption with the wrong key without relying
	 * solely on padding.
	 * @return the decrypted data.
	 * @throws EntityEncryptionException if the provided data owner can't access any encryption keys for the entity, or if no key could be found which
	 * provided valid decrypted content according to the validator.
	 */
	suspend fun decryptAttachmentOf(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
		content: ByteArray,
		validator: (suspend (decryptedData: ByteArray) -> Boolean)?,
	): ByteArray

	/**
	 * Decrypts an encrypted entity, if any entity couldn't be decrypted it is returned as is.
	 */
	suspend fun <B, E : B, D : B> tryDecryptEntities(
		entityGroupId: String?,
		encryptedEntities: List<E>,
		entityType: EntityWithEncryptionMetadataTypeName,
		encryptedEntitySerializer: SerializationStrategy<E>,
		constructor: (json: JsonElement) -> D,
	): List<B> where B : HasEncryptionMetadata, B : Encryptable


	/**
	 * Decrypts an encrypted entity, if any entity couldn't be decrypted this method throws [EntityEncryptionException].
	 */
	suspend fun <E, D> decryptEntities(
		entityGroupId: String?,
		encryptedEntities: List<E>,
		entityType: EntityWithEncryptionMetadataTypeName,
		encryptedEntitySerializer: SerializationStrategy<E>,
		constructor: (json: JsonElement) -> D,
	): List<D> where E : HasEncryptionMetadata, E : Encryptable, D : HasEncryptionMetadata, D : Encryptable

	/**
	 * Encrypts the content of an entity according to the provided manifest. The encryption key will be extracted from
	 * the metadata of the unencrypted entity.
	 * @throws EntityEncryptionException if no encryption key could be extracted from any of the unencrypted entity.
	 */
	suspend fun <E, D> encryptEntities(
		entityGroupId: String?,
		unencryptedEntities: List<D>,
		entityType: EntityWithEncryptionMetadataTypeName,
		unencryptedEntitySerializer: SerializationStrategy<D>,
		fieldsToEncrypt: EncryptedFieldsManifest,
		constructor: (json: JsonElement) -> E,
	): List<E> where E : HasEncryptionMetadata, E : Encryptable, D : HasEncryptionMetadata, D : Encryptable

	/**
	 * For each entity returns the first encryption key which could be properly decrypted from the entity using the
	 * current data owner.
	 * Entities for which no key could be decrypted are excluded from the resulting map.
	 */
	suspend fun tryDecryptAndImportAnyEncryptionKey(
		entityGroupId: String?,
		entities: List<HasEncryptionMetadata>,
		entitiesType: EntityWithEncryptionMetadataTypeName
	): Map<String, EntityEncryptionKeyDetails>

	/**
	 * Returns all encryption keys which could be properly decrypted from the entity using the current data owner. The keys returned by this method
	 * should not be used for encryption of the entity, but only for decryption.
	 * This is because this for data from pre-2018 users this method may return also keys from old formats of entities which are not safe anymore for
	 * encryption.
	 */
	suspend fun decryptAndImportAllDecryptionKeys(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
	): List<EntityEncryptionKeyDetails>

	/**
	 * Verifies if the entity has valid encryption keys (regardless of whether the current data owner has access to them or not). If not this method
	 * will throw an error, otherwise it will return undefined. For pre-2018 users there are some cases where the data may have been encrypted with a
	 * key not safe for encryption anymore, in which case this method will return the entity with a new and safe encryption key.
	 * After this method is called, if it returns an entity it should also be re-encrypted (using the new key) and saved to the cloud.
	 */
	suspend fun <T : HasEncryptionMetadata> ensureEncryptionKeysInitialized(
		entityGroupId: String?,
		entity: T,
		entityType: EntityWithEncryptionMetadataTypeName
	): T?
	// endregion

	// region confidential sfks

	/**
	 * Ensures that the current data owner has access to a confidential secret id for the provided entity: this is an id that is known to the data owner
	 * but is not known by any of his parents. If there is currently no confidential secret id for this entity the method returns a copy of the entity
	 * with a new confidential secret id for the current data owner (the entity in the database won't be updated), else this method returns undefined.
	 * New confidential secret ids will have an appropriate tag, but existing confidential secret ids may not necessarily have it.
	 * @param entity an entity which needs to have a confidential secret id for the current data owner
	 * @param entityType the type of the entity
	 * @param doRequestBulkShareOrUpdate perform the request to share or update an entity encrypted metadata on the cloud API (and save to DB).
	 * @return undefined if the entity already had a confidential secret id for the current user, or the updated AND SAVED entity with the new
	 * confidential secret id.
	 */
	suspend fun <T : HasEncryptionMetadata> initializeConfidentialSecretId(
		entityGroupId: String?,
		entity: T,
		entityType: EntityWithEncryptionMetadataTypeName,
		getUpdatedEntity: suspend (String) -> T,
		doRequestBulkShareOrUpdate: suspend (request: BulkShareOrUpdateMetadataParams) -> List<EntityBulkShareResult<out T>>,
	): T?

	/**
	 * Get all existing confidential secret ids of the provided entity for [dataOwnerId] (delegator data owner if null).
	 * A confidential secret id is a secret id known by the data owner but not known by any of his parents: note however
	 * that children will know confidential secret ids.
	 * @param entity an entity for which you want to retrieve the confidential secret id.
	 * @param dataOwnerId (current data owner by default) a data owner for which you want to get a confidential secret id.
	 * @return the confidential secret ids for the data owner (may be empty).
	 */
	suspend fun getConfidentialSecretIdsOf(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
		dataOwnerId: String?,
	): Set<String>

	/**
	 * Gets all secret ids known by the topmost parent of the current data owner hierarchy (or all secret ids known by
	 * the current data owner if he is not part of any data owner hierarchy).
	 * @param entity an entity.
	 * @return all secret ids known by the topmost parent of the current data owner hierarchy, may be empty.
	 */
	suspend fun getSecretIdsSharedWithParentsOf(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
	): Set<String>

	/**
	 * Get the secret ids for [entity] that match the provided [secretIdUseOption]. Note that if [secretIdUseOption] is
	 * [SecretIdUseOption.Use] the secret id won't be validated.
	 * @throws IllegalArgumentException if there is no valid secret id matching the requested option
	 * @return a set of secret ids to use for the entity. Never empty.
	 */
	suspend fun resolveSecretIdOption(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
		secretIdUseOption: SecretIdUseOption,
	): Set<String>
	// endregion
}
