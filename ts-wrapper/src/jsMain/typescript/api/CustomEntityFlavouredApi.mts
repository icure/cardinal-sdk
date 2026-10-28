// auto-generated file
import {CustomEntityShareOptions} from '../crypto/entities/CustomEntityShareOptions.mjs';
import {CustomEntityBase} from '../model/CustomEntityBase.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface CustomEntityFlavouredApi<E extends CustomEntityBase> {

	/**
	 *
	 *  Share a custom entity with another data owner. The custom entity must already exist in the database for this
	 *  method to succeed. If you want to share the custom entity before creation you should instead provide the
	 *  delegates in the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  @param delegateId the owner that will gain access to the custom entity
	 *  @param entity the custom entity to share with [delegateId]
	 *  @param options specifies how the custom entity will be shared. By default, all data available to the current
	 *  user will be shared, and the delegate will have the same permissions as the current user on the custom entity.
	 *  Refer to the documentation of [CustomEntityShareOptions] for more information.
	 *  @return the updated custom entity.
	 */
	shareWith(delegateId: string, entity: E,
			options?: { options?: CustomEntityShareOptions | undefined }): Promise<E>;

	/**
	 *
	 *  Share a custom entity with multiple data owners. The custom entity must already exist in the database for this
	 *  method to succeed. If you want to share the custom entity before creation you should instead provide the
	 *  delegates in the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  Throws an exception if the operation fails.
	 *  @param entity the custom entity to share
	 *  @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 *  each of them.
	 *  @return the updated custom entity.
	 */
	shareWithMany(entity: E, delegates: { [ key: string ]: CustomEntityShareOptions }): Promise<E>;

	/**
	 *
	 *  Create a new custom entity.
	 *  If the custom entity type is delegation-based the provided entity must have the encryption metadata initialized.
	 *  @param entity the custom entity to create
	 *  @return the created custom entity with updated revision.
	 *  @throws IllegalArgumentException if the custom entity type is delegation-based and the encryption metadata of
	 *  the input was not initialized.
	 */
	createEntity(entity: E): Promise<E>;

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
	createEntities(entities: Array<E>): Promise<Array<E>>;

	/**
	 *
	 *  Restores a custom entity that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteEntityById(id: string, rev: string): Promise<E>;

	/**
	 *
	 *  Restores a batch of custom entities that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the custom entities to restore.
	 *  @return the restored custom entities. If some entities couldn't be restored (because the user does not have
	 *  access or the revision is not up-to-date), then those entities will not be restored and will not appear in this
	 *  list.
	 */
	undeleteEntitiesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<E>>;

	/**
	 *
	 *  Restores a custom entity that was marked as deleted.
	 *  @param entity the custom entity to undelete
	 *  @return the restored custom entity.
	 *  @throws RevisionConflictException if the provided custom entity doesn't match the latest known revision
	 */
	undeleteEntity(entity: CustomEntityBase): Promise<E>;

	/**
	 *
	 *  Restores a batch of custom entities that were marked as deleted.
	 *  @param entities the custom entities to restore.
	 *  @return the restored custom entities. If some entities couldn't be restored (because the user does not have
	 *  access or the revision is not up-to-date), then those entities will not be restored and will not appear in this
	 *  list.
	 */
	undeleteEntities(entities: Array<CustomEntityBase>): Promise<Array<E>>;

	/**
	 *
	 *  Modifies a custom entity. You need to have write access to the entity. Note that you can't use this method to
	 *  change the attachments and/or attachment metadata on the entity. You should use the attachment methods instead.
	 *  Flavoured method.
	 *  @param entity a custom entity with update content
	 *  @return the custom entity updated with the provided content and a new revision.
	 */
	modifyEntity(entity: E): Promise<E>;

	/**
	 *
	 *  Modifies multiple custom entities. Ignores all custom entities for which you don't have write access.
	 *  Flavoured method.
	 *  @param entities custom entities with update content
	 *  @return the updated custom entities with a new revision. If some entities couldn't be updated (because the user
	 *  does not have access or the revision is not up-to-date), then those entities will not be updated and will not
	 *  appear in this list.
	 */
	modifyEntities(entities: Array<E>): Promise<Array<E>>;

	/**
	 *
	 *  Get a custom entity by its id. You must have read access to the entity.
	 *  Flavoured method.
	 *  @param entityId a custom entity id.
	 *  @return the custom entity with id [entityId], or null if the id does not correspond to any custom entity of
	 *  this type.
	 */
	getEntity(entityId: string): Promise<E | undefined>;

	/**
	 *
	 *  Get multiple custom entities by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a custom entity of this type, or correspond to an entity for which you don't have read
	 *  access.
	 *  Flavoured method.
	 *  @param entityIds a list of custom entity ids
	 *  @return all custom entities that you can access with one of the provided ids.
	 */
	getEntities(entityIds: Array<string>): Promise<Array<E>>;

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
	): Promise<E>;

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
	): Promise<E>;

	/**
	 *
	 *  Deletes an attachment of a custom entity.
	 *  Flavoured method.
	 *  @param entityId the id of the custom entity
	 *  @param rev the last known revision of the custom entity
	 *  @param key key of the attachment to delete
	 *  @return the updated custom entity
	 */
	deleteAttachment(entityId: string, rev: string, key: string): Promise<E>;

}
