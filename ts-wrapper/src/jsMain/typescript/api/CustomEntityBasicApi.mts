// auto-generated file
import {EntityAccessInformation} from '../crypto/entities/EntityAccessInformation.mjs';
import {CustomEntityBase, EncryptedCustomEntityBase} from '../model/CustomEntityBase.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {CustomEntityBasicInGroupApi} from './CustomEntityBasicInGroupApi.mjs';


export interface CustomEntityBasicApi {

	inGroup: CustomEntityBasicInGroupApi;

	/**
	 *
	 *  Deletes a custom entity. If you don't have write access to the custom entity the method will fail.
	 *  @param entityId id of the custom entity.
	 *  @param rev the latest known rev of the custom entity to delete
	 *  @return the id and revision of the deleted custom entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	deleteEntityById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many custom entities. Ids that don't correspond to an entity, or that correspond to an entity for which
	 *  you don't have write access will be ignored.
	 *  @param entityIds ids and revisions of the custom entities to delete.
	 *  @return the id and revision of the deleted custom entities. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	deleteEntitiesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a custom entity.
	 *  @param id id of the custom entity to purge
	 *  @param rev latest revision of the custom entity
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	purgeEntityById(id: string, rev: string): Promise<void>;

	/**
	 *
	 *  Permanently deletes many custom entities.
	 *  @param entityIds ids and revisions of the custom entities to purge
	 *  @return the id and revision of the purged custom entities. If some entities couldn't be purged (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeEntitiesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Deletes a custom entity. If you don't have write access to the custom entity the method will fail.
	 *  @param entity the custom entity to delete
	 *  @return the id and revision of the deleted custom entity.
	 *  @throws RevisionConflictException if the provided custom entity doesn't match the latest known revision
	 */
	deleteEntity(entity: CustomEntityBase): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many custom entities. Ignores custom entities for which you don't have write access or that don't match
	 *  the latest revision.
	 *  @param entities the custom entities to delete
	 *  @return the id and revision of the deleted custom entities. If some entities couldn't be deleted they will not be
	 *  included in this list.
	 */
	deleteEntities(entities: Array<CustomEntityBase>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a custom entity.
	 *  @param entity the custom entity to purge.
	 *  @throws RevisionConflictException if the provided custom entity doesn't match the latest known revision
	 */
	purgeEntity(entity: CustomEntityBase): Promise<void>;

	/**
	 *
	 *  Permanently deletes many custom entities.
	 *  @param entities the custom entities to purge.
	 *  @return the id and revision of the purged custom entities. If some entities couldn't be purged (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeEntities(entities: Array<CustomEntityBase>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Get the attachment at [key] from the custom entity with the provided id as raw bytes. This method will not
	 *  perform any transformation on the attachment, and if the attachment was encrypted the returned data is encrypted.
	 *  @param entityId a custom entity id
	 *  @param key the key of the attachment to retrieve.
	 *  @return the attachment at [key] of the custom entity with id [entityId], as stored in the backend.
	 */
	getRawAttachment(entityId: string, key: string): Promise<Int8Array>;

	/**
	 *
	 *  Get the attachment at [key] from the custom entity with the provided id.
	 *  Only for custom entities that don't support encryption: their attachments are never encrypted.
	 *  @param entityId a custom entity id
	 *  @param key the key of the attachment to retrieve.
	 *  @return the attachment at [key] of the custom entity with id [entityId].
	 */
	getAttachment(entityId: string, key: string): Promise<Int8Array>;

	/**
	 *
	 *  Get all data owners with access to the provided custom entity, attempting to identify any unknown anonymous data
	 *  owners using delegations de-anonymization metadata.
	 *  See [com.icure.cardinal.sdk.crypto.EntityAccessInformationProvider.getDataOwnersWithAccessTo] for the semantics of
	 *  anonymous data owners and the behaviour of basic apis.
	 *  @param entity a custom entity
	 *  @return information on users with access to the provided custom entity
	 */
	getDataOwnersWithAccessTo(entity: CustomEntityBase): Promise<EntityAccessInformation>;

	/**
	 *
	 *  Create a new custom entity.
	 *  If the custom entity type is delegation-based the provided entity must have the encryption metadata initialized.
	 *  @param entity the custom entity to create
	 *  @return the created custom entity with updated revision.
	 *  @throws IllegalArgumentException if the custom entity type is delegation-based and the encryption metadata of
	 *  the input was not initialized.
	 */
	createEntity(entity: EncryptedCustomEntityBase): Promise<EncryptedCustomEntityBase>;

	/**
	 *
	 *  Create a batch of new custom entities.
	 *  If the custom entity type is delegation-based all the provided entities must have the encryption metadata
	 *  initialized.
	 *  @param entities the custom entities to create
	 *  @return the created custom entities with updated revision.
	 *  @throws IllegalArgumentException if the custom entity type is delegation-based and the encryption metadata was
	 *  not initialized in any of the entities.
	 */
	createEntities(entities: Array<EncryptedCustomEntityBase>): Promise<Array<EncryptedCustomEntityBase>>;

	/**
	 *
	 *  Restores a custom entity that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteEntityById(id: string, rev: string): Promise<EncryptedCustomEntityBase>;

	/**
	 *
	 *  Restores a batch of custom entities that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the custom entities to restore.
	 *  @return the restored custom entities. If some entities couldn't be restored (because the user does not have
	 *  access or the revision is not up-to-date), then those entities will not be restored and will not appear in this
	 *  list.
	 */
	undeleteEntitiesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<EncryptedCustomEntityBase>>;

	/**
	 *
	 *  Restores a custom entity that was marked as deleted.
	 *  @param entity the custom entity to undelete
	 *  @return the restored custom entity.
	 *  @throws RevisionConflictException if the provided custom entity doesn't match the latest known revision
	 */
	undeleteEntity(entity: CustomEntityBase): Promise<EncryptedCustomEntityBase>;

	/**
	 *
	 *  Restores a batch of custom entities that were marked as deleted.
	 *  @param entities the custom entities to restore.
	 *  @return the restored custom entities. If some entities couldn't be restored (because the user does not have
	 *  access or the revision is not up-to-date), then those entities will not be restored and will not appear in this
	 *  list.
	 */
	undeleteEntities(entities: Array<CustomEntityBase>): Promise<Array<EncryptedCustomEntityBase>>;

	/**
	 *
	 *  Modifies a custom entity. You need to have write access to the entity. Note that you can't use this method to
	 *  change the attachments and/or attachment metadata on the entity. You should use the attachment methods instead.
	 *  Flavoured method.
	 *  @param entity a custom entity with update content
	 *  @return the custom entity updated with the provided content and a new revision.
	 */
	modifyEntity(entity: EncryptedCustomEntityBase): Promise<EncryptedCustomEntityBase>;

	/**
	 *
	 *  Modifies multiple custom entities. Ignores all custom entities for which you don't have write access.
	 *  Flavoured method.
	 *  @param entities custom entities with update content
	 *  @return the updated custom entities with a new revision. If some entities couldn't be updated (because the user
	 *  does not have access or the revision is not up-to-date), then those entities will not be updated and will not
	 *  appear in this list.
	 */
	modifyEntities(entities: Array<EncryptedCustomEntityBase>): Promise<Array<EncryptedCustomEntityBase>>;

	/**
	 *
	 *  Get a custom entity by its id. You must have read access to the entity.
	 *  Flavoured method.
	 *  @param entityId a custom entity id.
	 *  @return the custom entity with id [entityId], or null if the id does not correspond to any custom entity of
	 *  this type.
	 */
	getEntity(entityId: string): Promise<EncryptedCustomEntityBase | undefined>;

	/**
	 *
	 *  Get multiple custom entities by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a custom entity of this type, or correspond to an entity for which you don't have read
	 *  access.
	 *  Flavoured method.
	 *  @param entityIds a list of custom entity ids
	 *  @return all custom entities that you can access with one of the provided ids.
	 */
	getEntities(entityIds: Array<string>): Promise<Array<EncryptedCustomEntityBase>>;

	/**
	 *
	 *  Sets the attachment at the provided key for a custom entity without performing any transformation. Most
	 *  notably the attachment will not be encrypted by this method.
	 *  If there is already an attachment for the provided key on the entity it will be replaced.
	 *  Flavoured method.
	 *  @param entityId the id of the custom entity.
	 *  @param rev the revision of the custom entity
	 *  @param key a key to distinguish the attachment from other attachments of the entity.
	 *  @param utis uniform type identifiers for the attachment (https://en.wikipedia.org/wiki/Uniform_Type_Identifier).
	 *  If null and there is already an attachment at key for the entity the current utis will be reused, otherwise
	 *  null will be considered as an empty list. In all other cases overwrites any existing value.
	 *  @param attachment the attachment to set
	 *  @param encrypted specifies if the attachment you provided is encrypted or not. This will only be used to
	 *  have a more accurate representation of the type of attachment in the attachment storage servers; the custom
	 *  entity won't be affected by this value.
	 *  @return the updated custom entity
	 */
	setRawAttachment(
			entityId: string,
			rev: string,
			key: string,
			utis: Array<string> | undefined,
			attachment: Int8Array,
			encrypted: boolean
	): Promise<EncryptedCustomEntityBase>;

	/**
	 *
	 *  Sets the attachment at the provided key for a custom entity.
	 *  Only for custom entities that don't support encryption: their attachments are never encrypted.
	 *  If there is already an attachment for the provided key on the entity it will be replaced.
	 *  @param entityId the id of the custom entity.
	 *  @param rev the revision of the custom entity
	 *  @param key a key to distinguish the attachment from other attachments of the entity.
	 *  @param utis uniform type identifiers for the attachment (https://en.wikipedia.org/wiki/Uniform_Type_Identifier).
	 *  If null and there is already an attachment at key for the entity the current utis will be reused, otherwise
	 *  null will be considered as an empty list. In all other cases overwrites any existing value.
	 *  @param attachment the attachment to set
	 *  @return the updated custom entity
	 */
	setAttachment(
			entityId: string,
			rev: string,
			key: string,
			utis: Array<string> | undefined,
			attachment: Int8Array
	): Promise<EncryptedCustomEntityBase>;

	/**
	 *
	 *  Deletes an attachment of a custom entity.
	 *  Flavoured method.
	 *  @param entityId the id of the custom entity
	 *  @param rev the last known revision of the custom entity
	 *  @param key key of the attachment to delete
	 *  @return the updated custom entity
	 */
	deleteAttachment(entityId: string, rev: string, key: string): Promise<EncryptedCustomEntityBase>;

}
