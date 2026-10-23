package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.crypto.entities.BulkShareByIdsResult
import com.icure.cardinal.sdk.crypto.entities.CustomEntityDelegateOptions
import com.icure.cardinal.sdk.crypto.entities.CustomEntityOwningEntity
import com.icure.cardinal.sdk.crypto.entities.CustomEntityShareOptions
import com.icure.cardinal.sdk.crypto.entities.EntityAccessInformation
import com.icure.cardinal.sdk.exceptions.RevisionConflictException
import com.icure.cardinal.sdk.model.CustomEntityBase
import com.icure.cardinal.sdk.model.DecryptedCustomEntityBase
import com.icure.cardinal.sdk.model.EncryptedCustomEntityBase
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.cardinal.sdk.utils.generation.CustomEntityApiCategory.Attachments
import com.icure.cardinal.sdk.utils.generation.CustomEntityApiCategory.Crud
import com.icure.cardinal.sdk.utils.generation.CustomEntityApiCategory.Encryption
import com.icure.cardinal.sdk.utils.generation.CustomEntityApiMethod
import com.icure.cardinal.sdk.utils.generation.JsMapAsObjectArray

/*
 * Api for a single type of custom entity.
 *
 * Instances of these apis are bound to a specific custom entity type, which is provided when the api is instantiated
 * and automatically passed to the backend by the implementation: methods never take the custom entity type as a
 * parameter.
 *
 * These apis are not meant to be used directly: the customised SDK generator creates a typed wrapper for each custom
 * entity definition, exposing only the members whose [CustomEntityApiMethod] requirements are satisfied by the
 * definition.
 *
 * Custom entities that don't support encryption (e.g. with role-based access control) only use the
 * [CustomEntityBasicApi], for all users, and can be created directly with [CustomEntityBasicFlavouredApi.createEntity]
 * without initialising encryption metadata. The [CustomEntityApi] is used only for delegation-based custom entities.
 */

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface CustomEntityBasicFlavourlessApi {
	/**
	 * Deletes a custom entity. If you don't have write access to the custom entity the method will fail.
	 * @param entityId id of the custom entity.
	 * @param rev the latest known rev of the custom entity to delete
	 * @return the id and revision of the deleted custom entity.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun deleteEntityById(entityId: String, rev: String): StoredDocumentIdentifier

	/**
	 * Deletes many custom entities. Ids that don't correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids and revisions of the custom entities to delete.
	 * @return the id and revision of the deleted custom entities. If some entities couldn't be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun deleteEntitiesByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier>

	/**
	 * Permanently deletes a custom entity.
	 * @param id id of the custom entity to purge
	 * @param rev latest revision of the custom entity
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun purgeEntityById(id: String, rev: String)

	/**
	 * Permanently deletes many custom entities.
	 * @param entityIds ids and revisions of the custom entities to purge
	 * @return the id and revision of the purged custom entities. If some entities couldn't be purged (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun purgeEntitiesByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier>

	/**
	 * Deletes a custom entity. If you don't have write access to the custom entity the method will fail.
	 * @param entity the custom entity to delete
	 * @return the id and revision of the deleted custom entity.
	 * @throws RevisionConflictException if the provided custom entity doesn't match the latest known revision
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun deleteEntity(entity: CustomEntityBase): StoredDocumentIdentifier =
		deleteEntityById(entity.id, requireNotNull(entity.rev) { "Can't delete a custom entity that has no rev" })

	/**
	 * Deletes many custom entities. Ignores custom entities for which you don't have write access or that don't match
	 * the latest revision.
	 * @param entities the custom entities to delete
	 * @return the id and revision of the deleted custom entities. If some entities couldn't be deleted they will not be
	 * included in this list.
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun deleteEntities(entities: List<CustomEntityBase>): List<StoredDocumentIdentifier> =
		deleteEntitiesByIds(entities.map { it.toStoredDocumentIdentifier() })

	/**
	 * Permanently deletes a custom entity.
	 * @param entity the custom entity to purge.
	 * @throws RevisionConflictException if the provided custom entity doesn't match the latest known revision
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun purgeEntity(entity: CustomEntityBase) {
		purgeEntityById(entity.id, requireNotNull(entity.rev) { "Can't purge a custom entity that has no rev" })
	}

	/**
	 * Permanently deletes many custom entities.
	 * @param entities the custom entities to purge.
	 * @return the id and revision of the purged custom entities. If some entities couldn't be purged (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun purgeEntities(entities: List<CustomEntityBase>): List<StoredDocumentIdentifier> =
		purgeEntitiesByIds(entities.map { it.toStoredDocumentIdentifier() })

	/**
	 * Get the attachment at [key] from the custom entity with the provided id as raw bytes. This method will not
	 * perform any transformation on the attachment, and if the attachment was encrypted the returned data is encrypted.
	 * @param entityId a custom entity id
	 * @param key the key of the attachment to retrieve.
	 * @return the attachment at [key] of the custom entity with id [entityId], as stored in the backend.
	 */
	@CustomEntityApiMethod(Attachments)
	suspend fun getRawAttachment(entityId: String, key: String): ByteArray

	/**
	 * Get all data owners with access to the provided custom entity, attempting to identify any unknown anonymous data
	 * owners using delegations de-anonymization metadata.
	 * See [com.icure.cardinal.sdk.crypto.EntityAccessInformationProvider.getDataOwnersWithAccessTo] for the semantics of
	 * anonymous data owners and the behaviour of basic apis.
	 * @param entity a custom entity
	 * @return information on users with access to the provided custom entity
	 */
	@CustomEntityApiMethod(Encryption)
	suspend fun getDataOwnersWithAccessTo(entity: CustomEntityBase): EntityAccessInformation
}

interface CustomEntityBasicFlavourlessInGroupApi {
	/**
	 * In-group version of [CustomEntityBasicFlavourlessApi.deleteEntityById]
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun deleteEntityById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier>

	/**
	 * In-group version of [CustomEntityBasicFlavourlessApi.deleteEntitiesByIds]
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun deleteEntitiesByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>>

	/**
	 * In-group version of [CustomEntityBasicFlavourlessApi.purgeEntityById]
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun purgeEntityById(entityId: GroupScoped<StoredDocumentIdentifier>)

	/**
	 * In-group version of [CustomEntityBasicFlavourlessApi.purgeEntitiesByIds]
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun purgeEntitiesByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>>

	/**
	 * In-group version of [CustomEntityBasicFlavourlessApi.deleteEntity]
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun deleteEntity(entity: GroupScoped<CustomEntityBase>): GroupScoped<StoredDocumentIdentifier> =
		deleteEntityById(entity.toStoredDocumentIdentifier())

	/**
	 * In-group version of [CustomEntityBasicFlavourlessApi.deleteEntities]
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun deleteEntities(entities: List<GroupScoped<CustomEntityBase>>): List<GroupScoped<StoredDocumentIdentifier>> =
		deleteEntitiesByIds(entities.toStoredDocumentIdentifier())

	/**
	 * In-group version of [CustomEntityBasicFlavourlessApi.purgeEntity]
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun purgeEntity(entity: GroupScoped<CustomEntityBase>) {
		purgeEntityById(entity.toStoredDocumentIdentifier())
	}

	/**
	 * In-group version of [CustomEntityBasicFlavourlessApi.purgeEntities]
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun purgeEntities(entities: List<GroupScoped<CustomEntityBase>>): List<GroupScoped<StoredDocumentIdentifier>> =
		purgeEntitiesByIds(entities.toStoredDocumentIdentifier())

	/**
	 * In-group version of [CustomEntityBasicFlavourlessApi.getDataOwnersWithAccessTo].
	 */
	@CustomEntityApiMethod(Encryption)
	suspend fun getDataOwnersWithAccessTo(entity: GroupScoped<CustomEntityBase>): EntityAccessInformation
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface CustomEntityBasicFlavouredApi<E : CustomEntityBase> {
	/**
	 * Create a new custom entity.
	 * If the custom entity type is delegation-based the provided entity must have the encryption metadata initialized.
	 * @param entity the custom entity to create
	 * @return the created custom entity with updated revision.
	 * @throws IllegalArgumentException if the custom entity type is delegation-based and the encryption metadata of
	 * the input was not initialized.
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun createEntity(entity: E): E

	/**
	 * Create a batch of new custom entities.
	 * If the custom entity type is delegation-based all the provided entities must have the encryption metadata
	 * initialized.
	 * @param entities the custom entities to create
	 * @return the created custom entities with updated revision.
	 * @throws IllegalArgumentException if the custom entity type is delegation-based and the encryption metadata was
	 * not initialized in any of the entities.
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun createEntities(entities: List<E>): List<E>

	/**
	 * Restores a custom entity that was marked as deleted.
	 * @param id the id of the entity
	 * @param rev the latest revision of the entity.
	 * @return the restored entity.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun undeleteEntityById(id: String, rev: String): E

	/**
	 * Restores a batch of custom entities that were marked as deleted.
	 * @param entityIds the ids and the revisions of the custom entities to restore.
	 * @return the restored custom entities. If some entities couldn't be restored (because the user does not have
	 * access or the revision is not up-to-date), then those entities will not be restored and will not appear in this
	 * list.
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun undeleteEntitiesByIds(entityIds: List<StoredDocumentIdentifier>): List<E>

	/**
	 * Restores a custom entity that was marked as deleted.
	 * @param entity the custom entity to undelete
	 * @return the restored custom entity.
	 * @throws RevisionConflictException if the provided custom entity doesn't match the latest known revision
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun undeleteEntity(entity: CustomEntityBase): E =
		undeleteEntityById(entity.id, requireNotNull(entity.rev) { "Can't undelete a custom entity that has no rev" })

	/**
	 * Restores a batch of custom entities that were marked as deleted.
	 * @param entities the custom entities to restore.
	 * @return the restored custom entities. If some entities couldn't be restored (because the user does not have
	 * access or the revision is not up-to-date), then those entities will not be restored and will not appear in this
	 * list.
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun undeleteEntities(entities: List<CustomEntityBase>): List<E> =
		undeleteEntitiesByIds(entities.map { it.toStoredDocumentIdentifier() })

	/**
	 * Modifies a custom entity. You need to have write access to the entity. Note that you can't use this method to
	 * change the attachments and/or attachment metadata on the entity. You should use the attachment methods instead.
	 * Flavoured method.
	 * @param entity a custom entity with update content
	 * @return the custom entity updated with the provided content and a new revision.
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun modifyEntity(entity: E): E

	/**
	 * Modifies multiple custom entities. Ignores all custom entities for which you don't have write access.
	 * Flavoured method.
	 * @param entities custom entities with update content
	 * @return the updated custom entities with a new revision. If some entities couldn't be updated (because the user
	 * does not have access or the revision is not up-to-date), then those entities will not be updated and will not
	 * appear in this list.
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun modifyEntities(entities: List<E>): List<E>

	/**
	 * Get a custom entity by its id. You must have read access to the entity.
	 * Flavoured method.
	 * @param entityId a custom entity id.
	 * @return the custom entity with id [entityId], or null if the id does not correspond to any custom entity of
	 * this type.
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun getEntity(entityId: String): E?

	/**
	 * Get multiple custom entities by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 * an entity that is not a custom entity of this type, or correspond to an entity for which you don't have read
	 * access.
	 * Flavoured method.
	 * @param entityIds a list of custom entity ids
	 * @return all custom entities that you can access with one of the provided ids.
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun getEntities(entityIds: List<String>): List<E>

	/**
	 * Sets the attachment at the provided key for a custom entity without performing any transformation. Most
	 * notably the attachment will not be encrypted by this method.
	 * If there is already an attachment for the provided key on the entity it will be replaced.
	 * Flavoured method.
	 * @param entityId the id of the custom entity.
	 * @param rev the revision of the custom entity
	 * @param key a key to distinguish the attachment from other attachments of the entity.
	 * @param utis uniform type identifiers for the attachment (https://en.wikipedia.org/wiki/Uniform_Type_Identifier).
	 * If null and there is already an attachment at key for the entity the current utis will be reused, otherwise
	 * null will be considered as an empty list. In all other cases overwrites any existing value.
	 * @param attachment the attachment to set
	 * @param encrypted specifies if the attachment you provided is encrypted or not. This will only be used to
	 * have a more accurate representation of the type of attachment in the attachment storage servers; the custom
	 * entity won't be affected by this value.
	 * @return the updated custom entity
	 */
	@CustomEntityApiMethod(Attachments)
	suspend fun setRawAttachment(
		entityId: String,
		rev: String,
		key: String,
		utis: List<String>?,
		attachment: ByteArray,
		encrypted: Boolean,
	): E

	/**
	 * Deletes an attachment of a custom entity.
	 * Flavoured method.
	 * @param entityId the id of the custom entity
	 * @param rev the last known revision of the custom entity
	 * @param key key of the attachment to delete
	 * @return the updated custom entity
	 */
	@CustomEntityApiMethod(Attachments)
	suspend fun deleteAttachment(entityId: String, rev: String, key: String): E

}

interface CustomEntityBasicFlavouredInGroupApi<E : CustomEntityBase> {
	/**
	 * In-group version of [CustomEntityBasicFlavouredApi.createEntity]
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun createEntity(entity: GroupScoped<E>): GroupScoped<E>

	/**
	 * In-group version of [CustomEntityBasicFlavouredApi.createEntities]
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun createEntities(entities: List<GroupScoped<E>>): List<GroupScoped<E>>

	/**
	 * In-group version of [CustomEntityBasicFlavouredApi.undeleteEntityById]
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun undeleteEntityById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<E>

	/**
	 * In-group version of [CustomEntityBasicFlavouredApi.undeleteEntitiesByIds]
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun undeleteEntitiesByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<E>>

	/**
	 * In-group version of [CustomEntityBasicFlavouredApi.undeleteEntity]
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun undeleteEntity(entity: GroupScoped<CustomEntityBase>): GroupScoped<E> =
		undeleteEntityById(entity.toStoredDocumentIdentifier())

	/**
	 * In-group version of [CustomEntityBasicFlavouredApi.undeleteEntities]
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun undeleteEntities(entities: List<GroupScoped<CustomEntityBase>>): List<GroupScoped<E>> =
		undeleteEntitiesByIds(entities.toStoredDocumentIdentifier())

	/**
	 * In-group version of [CustomEntityBasicFlavouredApi.modifyEntity]
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun modifyEntity(entity: GroupScoped<E>): GroupScoped<E>

	/**
	 * In-group version of [CustomEntityBasicFlavouredApi.modifyEntities]
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun modifyEntities(entities: List<GroupScoped<E>>): List<GroupScoped<E>>

	/**
	 * In-group version of [CustomEntityBasicFlavouredApi.getEntity]
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun getEntity(groupId: String, entityId: String): GroupScoped<E>?

	/**
	 * In-group version of [CustomEntityBasicFlavouredApi.getEntities]
	 */
	@CustomEntityApiMethod(Crud)
	suspend fun getEntities(groupId: String, entityIds: List<String>): List<GroupScoped<E>>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface CustomEntityFlavouredApi<E : CustomEntityBase> : CustomEntityBasicFlavouredApi<E> {
	/**
	 * Share a custom entity with another data owner. The custom entity must already exist in the database for this
	 * method to succeed. If you want to share the custom entity before creation you should instead provide the
	 * delegates in the initialize encryption metadata method.
	 * Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 * @param delegateId the owner that will gain access to the custom entity
	 * @param entity the custom entity to share with [delegateId]
	 * @param options specifies how the custom entity will be shared. By default, all data available to the current
	 * user will be shared, and the delegate will have the same permissions as the current user on the custom entity.
	 * Refer to the documentation of [CustomEntityShareOptions] for more information.
	 * @return the updated custom entity.
	 */
	@CustomEntityApiMethod(Encryption)
	suspend fun shareWith(
		delegateId: String,
		entity: E,
		@DefaultValue("null")
		options: CustomEntityShareOptions? = null,
	): E

	/**
	 * Share a custom entity with multiple data owners. The custom entity must already exist in the database for this
	 * method to succeed. If you want to share the custom entity before creation you should instead provide the
	 * delegates in the initialize encryption metadata method.
	 * Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 * Throws an exception if the operation fails.
	 * @param entity the custom entity to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated custom entity.
	 */
	@CustomEntityApiMethod(Encryption)
	suspend fun shareWithMany(
		entity: E,
		delegates: Map<String, CustomEntityShareOptions>,
	): E
}

interface CustomEntityFlavouredInGroupApi<E : CustomEntityBase> : CustomEntityBasicFlavouredInGroupApi<E> {
	/**
	 * In-group version of [CustomEntityFlavouredApi.shareWith]
	 */
	@CustomEntityApiMethod(Encryption)
	suspend fun shareWith(
		delegate: EntityReferenceInGroup,
		entity: GroupScoped<E>,
		@DefaultValue("null")
		options: CustomEntityShareOptions? = null,
	): GroupScoped<E>

	/**
	 * In-group version of [CustomEntityFlavouredApi.shareWithMany]
	 */
	@CustomEntityApiMethod(Encryption)
	suspend fun shareWithMany(
		entity: GroupScoped<E>,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, CustomEntityShareOptions>,
	): GroupScoped<E>
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface CustomEntityApi : CustomEntityBasicFlavourlessApi, CustomEntityFlavouredApi<DecryptedCustomEntityBase> {
	/**
	 * Give access to the encrypted flavour of the api
	 */
	@CustomEntityApiMethod(Encryption)
	val encrypted: CustomEntityFlavouredApi<EncryptedCustomEntityBase>

	/**
	 * Gives access to the polymorphic flavour of the api
	 */
	@CustomEntityApiMethod(Encryption)
	val tryAndRecover: CustomEntityFlavouredApi<CustomEntityBase>

	/**
	 * Gives access to methods of the api that allow to use entities or work with data owners in groups other than the
	 * current user's group.
	 * These methods aren't available when connected to a kraken-lite instance.
	 */
	@CustomEntityApiMethod(Crud)
	val inGroup: CustomEntityInGroupApi

	/**
	 * Creates a new custom entity with initialized encryption metadata.
	 * @param base a custom entity with initialized content and uninitialized encryption metadata. The result of this
	 * method takes the content from [base] if provided.
	 * @param owningEntity the entity owning the new custom entity, if any, and how the new custom entity should be
	 * linked to it. Refer to [CustomEntityOwningEntity] for details.
	 * @param user the current user, will be used for the auto-delegations if provided.
	 * @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 * permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 * @param alternateRootDelegateId if provided, the root delegation of the new entity will be created for this data
	 * owner instead of the current data owner.
	 * @return a custom entity with initialized encryption metadata.
	 * @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	@CustomEntityApiMethod(Encryption)
	suspend fun withEncryptionMetadata(
		base: DecryptedCustomEntityBase?,
		@DefaultValue("null")
		owningEntity: CustomEntityOwningEntity<HasEncryptionMetadata>? = null,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("null")
		alternateRootDelegateId: String? = null,
	): DecryptedCustomEntityBase

	/**
	 * Creates a new custom entity with initialized encryption metadata, specifying fine-grained options for each
	 * additional data owner that will have access to the entity.
	 * @param base a custom entity with initialized content and uninitialized encryption metadata. The result of this
	 * method takes the content from [base] if provided.
	 * @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 * permissions that the delegates will have on the entity and if they will have access to the secretIds,
	 * encryptionKeys, and/or owningEntityIds of the new entity.
	 * @param owningEntity the entity owning the new custom entity, if any, and how the new custom entity should be
	 * linked to it. Refer to [CustomEntityOwningEntity] for details.
	 * @param user the current user, will be used for the auto-delegations if provided.
	 * @param alternateRootDelegateId if provided, the root delegation of the new entity will be created for this data
	 * owner instead of the current data owner.
	 * @return a custom entity with initialized encryption metadata.
	 * @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	@CustomEntityApiMethod(Encryption)
	suspend fun withEncryptionMetadataAndDelegates(
		base: DecryptedCustomEntityBase?,
		delegates: Map<String, CustomEntityDelegateOptions>,
		@DefaultValue("null")
		owningEntity: CustomEntityOwningEntity<HasEncryptionMetadata>? = null,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("null")
		alternateRootDelegateId: String? = null,
	): DecryptedCustomEntityBase

	/**
	 * Attempts to extract the encryption keys of a custom entity. If the user does not have access to any encryption
	 * key of the custom entity the method will return an empty set.
	 * Note: entities now have only one encryption key, but this method returns a set for compatibility with other
	 * apis of the SDK.
	 * @param entity a custom entity
	 * @return the encryption keys extracted from the provided custom entity.
	 */
	@CustomEntityApiMethod(Encryption)
	suspend fun getEncryptionKeysOf(entity: CustomEntityBase): Set<HexString>

	/**
	 * Attempts to extract the secret ids of a custom entity. Secret ids are used to link other entities to this custom
	 * entity without revealing the id of the custom entity (e.g. similarly to how a HealthElement is linked to a
	 * Patient).
	 * @param entity a custom entity
	 * @return the secret ids of the custom entity that the current data owner (or members of its hierarchy) can
	 * access, associated to the data owners that shared each secret id with the current data owner hierarchy.
	 */
	@CustomEntityApiMethod(Encryption)
	suspend fun getSecretIdsOf(entity: CustomEntityBase): Map<String, Set<EntityReferenceInGroup>>

	/**
	 * Specifies if the current user has write access to a custom entity through delegations.
	 * Doesn't consider actual permissions on the server side: for example, if the data owner has access to all
	 * entities thanks to extended permission but has no delegation on the provided entity this method returns false.
	 * Similarly, if the SDK was initialized in hierarchical mode but the user is lacking the hierarchical permission on
	 * the server side this method will still return true if there is a delegation to the parent.
	 * @param entity a custom entity
	 * @return if the current user has write access to the provided custom entity
	 */
	@CustomEntityApiMethod(Encryption)
	suspend fun hasWriteAccess(entity: CustomEntityBase): Boolean

	/**
	 * Attempts to extract the id of the entity owning a custom entity.
	 * Note: custom entities have at most one owning entity, but this method returns a set for consistency with other
	 * apis of the SDK.
	 * @param entity a custom entity
	 * @return the id of the entity owning the custom entity, or empty if the custom entity has no owner or the current
	 * user can't access the owning entity id.
	 */
	@CustomEntityApiMethod(Encryption)
	suspend fun decryptOwningEntityIdsOf(entity: CustomEntityBase): Set<EntityReferenceInGroup>

	/**
	 * Create metadata to allow other users to identify the anonymous delegates of a custom entity.
	 *
	 * When calling this method the SDK will use all the information available to the current user to try to identify
	 * any anonymous data-owners in the delegations of the provided custom entity. The SDK will be able to identify
	 * the anonymous data owners of the delegations only under the following conditions:
	 * - The other participant of the delegation is the current data owner
	 * - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 * current data owner
	 * - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 * After identifying the anonymous delegates in the custom entity the sdk will create the corresponding
	 * de-anonymization metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 * Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any custom entity
	 * of the same type, not only in the provided instance.
	 *
	 * @param entity a custom entity
	 * @param delegates a set of data owner ids
	 */
	@CustomEntityApiMethod(Encryption)
	suspend fun createDelegationDeAnonymizationMetadata(entity: CustomEntityBase, delegates: Set<String>)

	/**
	 * Decrypts custom entities, throwing an exception if it is not possible.
	 * @param entities encrypted custom entities
	 * @return the decrypted custom entities
	 * @throws EntityEncryptionException if any of the provided custom entities couldn't be decrypted
	 */
	@CustomEntityApiMethod(Encryption)
	suspend fun decrypt(entities: List<EncryptedCustomEntityBase>): List<DecryptedCustomEntityBase>

	/**
	 * Tries to decrypt custom entities, returns the input if it is not possible.
	 * @param entities encrypted custom entities
	 * @return all the provided custom entities, each of them decrypted if possible or unchanged (still encrypted)
	 */
	@CustomEntityApiMethod(Encryption)
	suspend fun tryDecrypt(entities: List<EncryptedCustomEntityBase>): List<CustomEntityBase>

	/**
	 * Encrypts provided decrypted custom entities, and validates already encrypted custom entities.
	 * @param entities custom entities to encrypt and/or validate
	 * @return the encrypted and validated custom entities
	 * @throws EntityEncryptionException if any of the provided decrypted custom entities couldn't be encrypted (the
	 * current user can't access its encryption key or no key was initialized) or if the already encrypted custom
	 * entities don't respect the encryption manifest.
	 */
	@CustomEntityApiMethod(Encryption)
	suspend fun encryptOrValidate(entities: List<CustomEntityBase>): List<EncryptedCustomEntityBase>

	/**
	 * Share many already-existing custom entities with one or more delegates at once, retrieving them by id instead
	 * of requiring the caller to have them already loaded. This is more efficient than calling [shareWithMany] once
	 * per custom entity when you already know the ids of many custom entities to share and don't otherwise need
	 * their decrypted content.
	 *
	 * The same [delegates] options are applied identically to every found custom entity. Unlike [shareWithMany], if
	 * the share fails for some (custom entity, delegate) pairs this method reports the failure for those specific
	 * pairs in the returned result instead of throwing.
	 *
	 * @param entityIds ids of the custom entities to share. Ids that don't exist, or exist but for which the current
	 * user has no read access, are reported in [BulkShareByIdsResult.notFoundIds] and otherwise ignored.
	 * @param delegates the data owners which will gain access to each custom entity, and the options for sharing
	 * with each of them.
	 * @return details on the outcome of the operation, for each requested id.
	 */
	@CustomEntityApiMethod(Encryption)
	suspend fun shareEntitiesByIds(
		entityIds: List<String>,
		delegates: Map<String, CustomEntityShareOptions>,
	): BulkShareByIdsResult

	/**
	 * Retrieves and tries to decrypt the attachment at [key] of a custom entity.
	 * This method returns null if the user has no access to an encryption key of the custom entity that allows to
	 * correctly decrypt the attachment.
	 *
	 * In cases where there could be multiple encryption keys associated to the custom entity, you should also provide
	 * a validator for the decrypted attachment: if you do, after decrypting the result with the entity encryption key
	 * the sdk will also pass the decrypted result to the validator before considering the decryption as successful.
	 * This is because due to the nature of the AES-CBC encryption algorithm, it is impossible to know with 100%
	 * certainty if the data was decrypted correctly, therefore additional context is needed.
	 *
	 * @param entity a custom entity
	 * @param key the key of the attachment
	 * @param decryptedAttachmentValidator a function to verify if the attachment was decrypted correctly. Should be
	 * provided in cases where the custom entity may have multiple encryption keys.
	 * @return the decrypted attachment if it could be correctly decrypted using the keys available to the current
	 * user, null otherwise.
	 */
	@CustomEntityApiMethod(Attachments, Encryption)
	suspend fun getAndTryDecryptAttachment(
		entity: CustomEntityBase,
		key: String,
		@DefaultValue("null")
		decryptedAttachmentValidator: (suspend (attachment: ByteArray) -> Boolean)? = null,
	): ByteArray?

	/**
	 * Similar to [getAndTryDecryptAttachment] but throws an exception instead of returning null if the attachment
	 * could not be decrypted.
	 * @param entity a custom entity
	 * @param key the key of the attachment
	 * @param decryptedAttachmentValidator a function to verify if the attachment was decrypted correctly. Should be
	 * provided in cases where the custom entity may have multiple encryption keys.
	 * @return the decrypted attachment
	 * @throws EntityEncryptionException if the attachment could not be decrypted
	 */
	@CustomEntityApiMethod(Attachments, Encryption)
	suspend fun getAndDecryptAttachment(
		entity: CustomEntityBase,
		key: String,
		@DefaultValue("null")
		decryptedAttachmentValidator: (suspend (attachment: ByteArray) -> Boolean)? = null,
	): ByteArray

	/**
	 * Tries to decrypt an attachment of a custom entity, returning null if it is not possible. This method can be used
	 * to decrypt an already retrieved raw attachment.
	 *
	 * Refer to [getAndTryDecryptAttachment] for details on the [decryptedAttachmentValidator].
	 *
	 * @param entity a custom entity
	 * @param encryptedAttachment a raw attachment of the custom entity
	 * @param decryptedAttachmentValidator a function to verify if the attachment was decrypted correctly. Should be
	 * provided in cases where the custom entity may have multiple encryption keys.
	 * @return the decrypted attachment if it could be decrypted using the keys available to the current data owner,
	 * null otherwise.
	 */
	@CustomEntityApiMethod(Attachments, Encryption)
	suspend fun tryDecryptAttachment(
		entity: CustomEntityBase,
		encryptedAttachment: ByteArray,
		@DefaultValue("null")
		decryptedAttachmentValidator: (suspend (attachment: ByteArray) -> Boolean)? = null,
	): ByteArray?

	/**
	 * Encrypts the provided attachment using the key of the custom entity and then saves it to the backend at the
	 * provided key, overwriting the previous attachment at that key if any.
	 * @param entity a custom entity
	 * @param key a key to distinguish the attachment from other attachments of the entity.
	 * @param utis uniform type identifiers for the attachment (https://en.wikipedia.org/wiki/Uniform_Type_Identifier).
	 * If null and there is already an attachment at key for the entity the current utis will be reused, otherwise
	 * null will be considered as an empty list. In all other cases overwrites any existing value.
	 * @param attachment the clear attachment to encrypt and set
	 * @return the updated custom entity
	 * @throws EntityEncryptionException if the current user does not have access to any encryption key of the
	 * provided custom entity.
	 */
	@CustomEntityApiMethod(Attachments, Encryption)
	suspend fun encryptAndSetAttachment(
		entity: CustomEntityBase,
		key: String,
		utis: List<String>?,
		attachment: ByteArray,
	): DecryptedCustomEntityBase

}

interface CustomEntityInGroupApi : CustomEntityBasicFlavourlessInGroupApi, CustomEntityFlavouredInGroupApi<DecryptedCustomEntityBase> {
	/**
	 * Give access to the encrypted flavour of the api
	 */
	@CustomEntityApiMethod(Encryption)
	val encrypted: CustomEntityFlavouredInGroupApi<EncryptedCustomEntityBase>

	/**
	 * Gives access to the polymorphic flavour of the api
	 */
	@CustomEntityApiMethod(Encryption)
	val tryAndRecover: CustomEntityFlavouredInGroupApi<CustomEntityBase>

	/**
	 * In-group version of [CustomEntityApi.withEncryptionMetadata]
	 */
	@CustomEntityApiMethod(Encryption)
	suspend fun withEncryptionMetadata(
		entityGroupId: String,
		base: DecryptedCustomEntityBase?,
		@DefaultValue("null")
		owningEntity: CustomEntityOwningEntity<GroupScoped<HasEncryptionMetadata>>? = null,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "accessLevel") Map<EntityReferenceInGroup, AccessLevel> = emptyMap(),
		@DefaultValue("null")
		alternateRootDelegateReference: EntityReferenceInGroup? = null,
	): GroupScoped<DecryptedCustomEntityBase>

	/**
	 * In-group version of [CustomEntityApi.withEncryptionMetadataAndDelegates]
	 */
	@CustomEntityApiMethod(Encryption)
	suspend fun withEncryptionMetadataAndDelegates(
		entityGroupId: String,
		base: DecryptedCustomEntityBase?,
		delegates: @JsMapAsObjectArray(
			keyEntryName = "delegate",
			valueEntryName = "delegateOptions",
		) Map<EntityReferenceInGroup, CustomEntityDelegateOptions>,
		@DefaultValue("null")
		owningEntity: CustomEntityOwningEntity<GroupScoped<HasEncryptionMetadata>>? = null,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("null")
		alternateRootDelegateReference: EntityReferenceInGroup? = null,
	): GroupScoped<DecryptedCustomEntityBase>

	/**
	 * In-group version of [CustomEntityApi.getEncryptionKeysOf]
	 */
	@CustomEntityApiMethod(Encryption)
	suspend fun getEncryptionKeysOf(entity: GroupScoped<CustomEntityBase>): Set<HexString>

	/**
	 * In-group version of [CustomEntityApi.getSecretIdsOf]
	 */
	@CustomEntityApiMethod(Encryption)
	suspend fun getSecretIdsOf(entity: GroupScoped<CustomEntityBase>): Map<String, Set<EntityReferenceInGroup>>

	/**
	 * In-group version of [CustomEntityApi.hasWriteAccess]
	 */
	@CustomEntityApiMethod(Encryption)
	suspend fun hasWriteAccess(entity: GroupScoped<CustomEntityBase>): Boolean

	/**
	 * In-group version of [CustomEntityApi.decryptOwningEntityIdsOf]
	 */
	@CustomEntityApiMethod(Encryption)
	suspend fun decryptOwningEntityIdsOf(entity: GroupScoped<CustomEntityBase>): Set<EntityReferenceInGroup>

	/**
	 * In-group version of [CustomEntityApi.createDelegationDeAnonymizationMetadata]
	 */
	@CustomEntityApiMethod(Encryption)
	suspend fun createDelegationDeAnonymizationMetadata(entity: GroupScoped<CustomEntityBase>, delegates: Set<EntityReferenceInGroup>)

	/**
	 * In-group version of [CustomEntityApi.decrypt]
	 */
	@CustomEntityApiMethod(Encryption)
	suspend fun decrypt(entities: List<GroupScoped<EncryptedCustomEntityBase>>): List<GroupScoped<DecryptedCustomEntityBase>>

	/**
	 * In-group version of [CustomEntityApi.tryDecrypt]
	 */
	@CustomEntityApiMethod(Encryption)
	suspend fun tryDecrypt(entities: List<GroupScoped<EncryptedCustomEntityBase>>): List<GroupScoped<CustomEntityBase>>

	/**
	 * In-group version of [CustomEntityApi.encryptOrValidate]
	 */
	@CustomEntityApiMethod(Encryption)
	suspend fun encryptOrValidate(entities: List<GroupScoped<CustomEntityBase>>): List<GroupScoped<EncryptedCustomEntityBase>>
}

/* Api for users that are not data owners: custom entities are never decrypted or encrypted */
interface CustomEntityBasicApi : CustomEntityBasicFlavourlessApi, CustomEntityBasicFlavouredApi<EncryptedCustomEntityBase> {
	/**
	 * Gives access to methods of the api that allow to use entities in groups other than the current user's group.
	 * These methods aren't available when connected to a kraken-lite instance.
	 */
	@CustomEntityApiMethod(Crud)
	val inGroup: CustomEntityBasicInGroupApi
}

interface CustomEntityBasicInGroupApi : CustomEntityBasicFlavourlessInGroupApi, CustomEntityBasicFlavouredInGroupApi<EncryptedCustomEntityBase>
