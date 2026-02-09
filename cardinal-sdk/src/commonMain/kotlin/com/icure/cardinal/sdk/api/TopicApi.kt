package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.crypto.entities.TopicShareOptions
import com.icure.cardinal.sdk.exceptions.RevisionConflictException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.DecryptedTopic
import com.icure.cardinal.sdk.model.EncryptedTopic
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Topic
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.TopicRole
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.cardinal.sdk.subscription.Subscribable
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.cardinal.sdk.utils.generation.JsMapAsObjectArray
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface TopicBasicFlavourlessApi {

	/**
	 * Deletes a topic. If you don't have write access to the topic the method will fail.
	 * @param entityId id of the topic.
	 * @param rev the latest known rev of the topic to delete
	 * @return the id and revision of the deleted topic.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun deleteTopicById(entityId: String, rev: String): StoredDocumentIdentifier

	/**
	 * Deletes many topics. Ids that do not correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids and revisions of the topics to delete.
	 * @return the id and revision of the deleted topics. If some entities could not be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteTopicsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier>

	/**
	 * Permanently deletes a topic.
	 * @param id id of the topic to purge
	 * @param rev latest revision of the topic
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun purgeTopicById(id: String, rev: String)

	/**
	 * Permanently deletes many topics.
	 * @param entityIds ids and revisions of the topics to delete
	 * @return the id and revision of the deleted topics. If some entities couldn't be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun purgeTopicsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier>

	/**
	 * Deletes a topic. If you don't have write access to the topic the method will fail.
	 * @param topic the topic to delete
	 * @return the id and revision of the deleted topic.
	 * @throws RevisionConflictException if the provided topic doesn't match the latest known revision
	 */
	suspend fun deleteTopic(topic: Topic): StoredDocumentIdentifier =
		deleteTopicById(topic.id, requireNotNull(topic.rev) { "Can't delete a topic that has no rev" })

	/**
	 * Deletes many topics. Ignores topic for which you don't have write access or that don't match the latest revision.
	 * @param topics the topics to delete
	 * @return the id and revision of the deleted topics. If some entities couldn't be deleted they will not be
	 * included in this list.
	 */
	suspend fun deleteTopics(topics: List<Topic>): List<StoredDocumentIdentifier> =
		deleteTopicsByIds(topics.map { it.toStoredDocumentIdentifier() })

	/**
	 * Permanently deletes a topic.
	 * @param topic the topic to purge.
	 * @throws RevisionConflictException if the provided topic doesn't match the latest known revision
	 */
	suspend fun purgeTopic(topic: Topic) {
		purgeTopicById(topic.id, requireNotNull(topic.rev) { "Can't delete a topic that has no rev" })
	}

	/**
	 * Permanently deletes many topics.
	 * @param topics the topics to purge.
	 * @return the id and revision of the deleted topics. If some entities couldn't be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun purgeTopics(topics: List<Topic>): List<StoredDocumentIdentifier> =
		purgeTopicsByIds(topics.map { it.toStoredDocumentIdentifier() })
}

interface TopicBasicFlavourlessInGroupApi {
	/**
	 * In-group version of [TopicBasicFlavourlessApi.deleteTopicById]
	 */
	suspend fun deleteTopicById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier>

	/**
	 * In-group version of [TopicBasicFlavourlessApi.deleteTopicsByIds]
	 */
	suspend fun deleteTopicsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>>

	/**
	 * In-group version of [TopicBasicFlavourlessApi.purgeTopicById]
	 */
	suspend fun purgeTopicById(entityId: GroupScoped<StoredDocumentIdentifier>)

	/**
	 * In-group version of [TopicBasicFlavourlessApi.purgeTopicsByIds]
	 */
	suspend fun purgeTopicsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>>

	/**
	 * In-group version of [TopicBasicFlavourlessApi.deleteTopic]
	 */
	suspend fun deleteTopic(topic: GroupScoped<Topic>): GroupScoped<StoredDocumentIdentifier> =
		deleteTopicById(topic.toStoredDocumentIdentifier())

	/**
	 * In-group version of [TopicBasicFlavourlessApi.deleteTopics]
	 */
	suspend fun deleteTopics(topics: List<GroupScoped<Topic>>): List<GroupScoped<StoredDocumentIdentifier>> =
		deleteTopicsByIds(topics.toStoredDocumentIdentifier())

	/**
	 * In-group version of [TopicBasicFlavourlessApi.purgeTopic]
	 */
	suspend fun purgeTopic(topic: GroupScoped<Topic>) {
		purgeTopicById(topic.toStoredDocumentIdentifier())
	}

	/**
	 * In-group version of [TopicBasicFlavourlessApi.purgeTopics]
	 */
	suspend fun purgeTopics(topics: List<GroupScoped<Topic>>): List<GroupScoped<StoredDocumentIdentifier>> =
		purgeTopicsByIds(topics.map { it.toStoredDocumentIdentifier() })
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface TopicBasicFlavouredApi<E : Topic> {
	/**
	 * Create a new topic. The provided topic must have the encryption metadata initialized.
	 * @param entity a topic with initialized encryption metadata
	 * @return the created topic with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	suspend fun createTopic(entity: E): E

	/**
	 * Create multiple topics. All the provided topics must have the encryption metadata initialized, otherwise
	 * this method fails without doing anything.
	 * @param entities topics with initialized encryption metadata
	 * @return the created topics with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of any topic in the input was not initialized.
	 */
	suspend fun createTopics(entities: List<E>): List<E>

	/**
	 * Restores a topic that was marked as deleted.
	 * @param id the id of the entity
	 * @param rev the latest revision of the entity.
	 * @return the restored entity.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun undeleteTopicById(id: String, rev: String): E

	/**
	 * Restores a batch of topics that were marked as deleted.
	 * @param entityIds the ids and the revisions of the topics to restore.
	 * @return the restored topics. If some entities couldn't be restored (because the user does not have access or the revision is not
	 * up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	suspend fun undeleteTopicsByIds(entityIds: List<StoredDocumentIdentifier>): List<E>

	/**
	 * Restores a topic that was marked as deleted.
	 * @param topic the topic to undelete
	 * @return the restored topic.
	 * @throws RevisionConflictException if the provided topic doesn't match the latest known revision
	 */
	suspend fun undeleteTopic(topic: Topic): E =
		undeleteTopicById(topic.id, requireNotNull(topic.rev) { "Can't delete a topic that has no rev" })

	/**
	 * Restores a batch of topics that were marked as deleted.
	 * @param topics the topics to restore.
	 * @return the restored topics. If some entities couldn't be restored (because the user does not have access or the revision is not
	 * up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	suspend fun undeleteTopics(topics: List<Topic>): List<E> =
		undeleteTopicsByIds(topics.map { it.toStoredDocumentIdentifier() })

	/**
	 * Modifies a topic. You need to have write access to the entity.
	 * Flavoured method.
	 * @param entity a topic with update content
	 * @return the topic updated with the provided content and a new revision.
	 */
	suspend fun modifyTopic(entity: E): E

	/**
	 * Modifies multiple topics. Ignores all topics for which you don't have write access.
	 * Flavoured method.
	 * @param entities topics with update content
	 * @return the updated topics with a new revision.
	 */
	suspend fun modifyTopics(entities: List<E>): List<E>

	/**
	 * Get a topic by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 * entity, corresponds to an entity that is not a topic, or corresponds to an entity for which you don't have
	 * read access.
	 * Flavoured method.
	 * @param entityId a topic id.
	 * @return the topic with id [entityId].
	 */
	suspend fun getTopic(entityId: String): E?

	/**
	 * Get multiple topics by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 * an entity that is not a topic, or correspond to an entity for which you don't have read access.
	 * Flavoured method.
	 * @param entityIds a list of topics ids
	 * @return all topics that you can access with one of the provided ids.
	 */
	suspend fun getTopics(entityIds: List<String>): List<E>

	/**
	 * Add a participant to the topic. The participant will be able to create messages associated to the topic.
	 * Any user with a [TopicRole.Admin] on the can use this method, even if they don't have direct write access
	 * to it through delegations.
	 * @param entityId id of the topic
	 * @param dataOwnerId id of the new participant
	 * @param topicRole the role that the participant will have in the topic
	 * @return the updated topic
	 */
	suspend fun addParticipant(entityId: String, dataOwnerId: String, topicRole: TopicRole): E

	/**
	 * Removes a participant from a topic. The participant will not be able anymore to search for messages of that topic.
	 * Any user with a [TopicRole.Admin] on the can use this method, even if they don't have direct write access
	 * to it through delegations.
	 * @param entityId id of the topic
	 * @param dataOwnerId id of the participant to remove
	 * @return the updated topic
	 */
	suspend fun removeParticipant(entityId: String, dataOwnerId: String): E
}

interface TopicBasicFlavouredInGroupApi<E : Topic> {
	/**
	 * In-group version of [TopicBasicFlavouredApi.createTopic]
	 */
	suspend fun createTopic(entity: GroupScoped<E>): GroupScoped<E>

	/**
	 * In-group version of [TopicBasicFlavouredApi.createTopics]
	 */
	suspend fun createTopics(entities: List<GroupScoped<E>>): List<GroupScoped<E>>

	/**
	 * In-group version of [TopicBasicFlavouredApi.undeleteTopicById]
	 */
	suspend fun undeleteTopicById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<E>

	/**
	 * In-group version of [TopicBasicFlavouredApi.undeleteTopicsByIds]
	 */
	suspend fun undeleteTopicsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<E>>

	/**
	 * In-group version of [TopicBasicFlavouredApi.undeleteTopic]
	 */
	suspend fun undeleteTopic(topic: GroupScoped<Topic>): GroupScoped<E> =
		undeleteTopicById(topic.toStoredDocumentIdentifier())

	/**
	 * In-group version of [TopicBasicFlavouredApi.undeleteTopics]
	 */
	suspend fun undeleteTopics(topics: List<GroupScoped<E>>): List<GroupScoped<E>> =
		undeleteTopicsByIds(topics.map { it.toStoredDocumentIdentifier() })

	/**
	 * In-group version of [TopicBasicFlavouredApi.modifyTopic]
	 */
	suspend fun modifyTopic(entity: GroupScoped<E>): GroupScoped<E>

	/**
	 * In-group version of [TopicBasicFlavouredApi.modifyTopics]
	 */
	suspend fun modifyTopics(entities: List<GroupScoped<E>>): List<GroupScoped<E>>

	/**
	 * In-group version of [TopicBasicFlavouredApi.getTopic]
	 */
	suspend fun getTopic(groupId: String, entityId: String): GroupScoped<E>?

	/**
	 * In-group version of [TopicBasicFlavouredApi.getTopics]
	 */
	suspend fun getTopics(groupId: String, entityIds: List<String>): List<GroupScoped<E>>

}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface TopicFlavouredApi<E : Topic> : TopicBasicFlavouredApi<E> {
	/**
	 * Share a topic with another data owner. The topic must already exist in the database for this method to
	 * succeed. If you want to share the topic before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 * @param delegateId the owner that will gain access to the topic
	 * @param topic the topic to share with [delegateId]
	 * @param options specifies how the topic will be shared. By default, all data available to the current user
	 * will be shared, and the delegate will have the same permissions as the current user on the topic. Refer
	 * to the documentation of [TopicShareOptions] for more information.
	 * @return the updated topic if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun shareWith(
		delegateId: String,
		topic: E,
		@DefaultValue("null")
		options: TopicShareOptions? = null
	): E

	/**
	 * Share a topic with multiple data owners. The topic must already exist in the database for this method to
	 * succeed. If you want to share the topic before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 * Throws an exception if the operation fails.
	 * @param topic the topic to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated topic.
	 */
	suspend fun shareWithMany(
		topic: E,
		delegates: Map<String, TopicShareOptions>
	): E

	/**
	 * Get an iterator that iterates through all topics matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterTopicsBySorted] instead.
	 *
	 * @param filter a topic filter
	 * @return an iterator that iterates over all topics matching the provided filter.
	 */
	suspend fun filterTopicsBy(
		filter: FilterOptions<Topic>
	): PaginatedListIterator<E>

	/**
	 * Get an iterator that iterates through all topics matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterTopicsBy].
	 *
	 * @param filter a topic filter
	 * @return an iterator that iterates over all topics matching the provided filter.
	 */
	suspend fun filterTopicsBySorted(
		filter: SortableFilterOptions<Topic>
	): PaginatedListIterator<E>
}

interface TopicFlavouredInGroupApi<E : Topic> : TopicBasicFlavouredInGroupApi<E> {
	/**
	 * In-group version of [TopicFlavouredApi.shareWith]
	 */
	suspend fun shareWith(
		delegate: EntityReferenceInGroup,
		topic: GroupScoped<E>,
		@DefaultValue("null")
		options: TopicShareOptions? = null
	): GroupScoped<E>

	/**
	 * In-group version of [TopicFlavouredApi.shareWithMany]
	 */
	suspend fun shareWithMany(
		topic: GroupScoped<E>,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, TopicShareOptions>
	): GroupScoped<E>

	/**
	 * In-group version of [TopicFlavouredApi.filterTopicsBy]
	 */
	suspend fun filterTopicsBy(
		groupId: String,
		filter: FilterOptions<Topic>
	): PaginatedListIterator<GroupScoped<E>>

	/**
	 * In-group version of [TopicFlavouredApi.filterTopicsBySorted]
	 */
	suspend fun filterTopicsBySorted(
		groupId: String,
		filter: SortableFilterOptions<Topic>
	): PaginatedListIterator<GroupScoped<E>>
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface TopicApi : TopicBasicFlavourlessApi, TopicFlavouredApi<DecryptedTopic>, Subscribable<Topic, EncryptedTopic, FilterOptions<Topic>> {
	/**
	 * Creates a new topic with initialized encryption metadata
	 * @param base a topic with initialized content and uninitialized encryption metadata. The result of this
	 * method takes the content from [base] if provided.
	 * @param patient the patient linked to the topic.
	 * @param user the current user, will be used for the auto-delegations if provided.
	 * @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 * permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 * @param secretId specifies which secret id of [patient] to use for the new topic
	 * @return a topic with initialized encryption metadata.
	 * @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	suspend fun withEncryptionMetadata(
		base: DecryptedTopic?,
		patient: Patient?,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent")
		secretId: SecretIdUseOption = SecretIdUseOption.UseAnySharedWithParent,
		@DefaultValue("null")
		alternateRootDelegateId: String? = null,
	): DecryptedTopic

	/**
	 * Attempts to extract the encryption keys of a topic. If the user does not have access to any encryption key
	 * of the access log the method will return an empty set.
	 * Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 * versions of iCure where this was not a guarantee.
	 * @param topic a topic
	 * @return the encryption keys extracted from the provided topic.
	 */
	suspend fun getEncryptionKeysOf(topic: Topic): Set<HexString>

	/**
	 * Specifies if the current user has write access to a topic through delegations.
	 * Doesn't consider actual permissions on the server side: for example, if the data owner has access to all entities
	 * thanks to extended permission but has no delegation on the provided entity this method returns false. Similarly,
	 * if the SDK was initialized in hierarchical mode but the user is lacking the hierarchical permission on the server
	 * side this method will still return true if there is a delegation to the parent.
	 * @param topic a topic
	 * @return if the current user has write access to the provided topic
	 */
	suspend fun hasWriteAccess(topic: Topic): Boolean

	/**
	 * Attempts to extract the patient id linked to a topic.
	 * Note: topics usually should be linked with only one patient, but this method returns a set for compatibility
	 * with older versions of iCure
	 * @param topic a topic
	 * @return the id of the patient linked to the topic, or empty if the current user can't access any patient id
	 * of the topic.
	 */
	suspend fun decryptPatientIdOf(topic: Topic): Set<EntityReferenceInGroup>

	/**
	 * Create metadata to allow other users to identify the anonymous delegates of a topic.
	 *
	 * When calling this method the SDK will use all the information available to the current user to try to identify
	 * any anonymous data-owners in the delegations of the provided topic. The SDK will be able to identify the
	 * anonymous data owners of the delegations only under the following conditions:
	 * - The other participant of the delegation is the current data owner
	 * - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 * current data owner
	 * - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 * After identifying the anonymous delegates in the topic the sdk will create the corresponding de-anonymization
	 * metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 * Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any Topic,
	 * not only in the provided instance.
	 *
	 * ## Example
	 *
	 * If you have a topic E, and you have shared it with patient P and healthcare party H, H will not
	 * be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 * H. From now on, for any topic that you have shared with P, H will be able to know that the topic was
	 * shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 * At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 * delegator-delegate pair, you will not be able to see if P has access to a topic that was created by H and
	 * shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 * @param entity a topic
	 * @param delegates a set of data owner ids
	 */
	suspend fun createDelegationDeAnonymizationMetadata(entity: Topic, delegates: Set<String>)

	/**
	 * Decrypts a topic, throwing an exception if it is not possible.
	 * @param topic a topic
	 * @return the decrypted topic
	 * @throws EntityEncryptionException if the topic could not be decrypted
	 */
	suspend fun decrypt(topic: EncryptedTopic): DecryptedTopic

	/**
	 * Tries to decrypt a topic, returns the input if it is not possible.
	 * @param topic an encrypted topic
	 * @return the decrypted topic if the decryption was successful or the input if it was not.
	 */
	suspend fun tryDecrypt(topic: EncryptedTopic): Topic

	/**
	 * Give access to the encrypted flavour of the api
	 */
	val encrypted: TopicFlavouredApi<EncryptedTopic>

	/**
	 * Gives access to the polymorphic flavour of the api
	 */
	val tryAndRecover: TopicFlavouredApi<Topic>

	/**
	 * Gives access to methods of the api that allow to use entities or work with data owners in groups other than the
	 * current user's group.
	 */
	val inGroup: TopicInGroupApi

	/**
	 * Get the ids of all topics matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchTopicsBySorted] instead.
	 *
	 * @param filter a topic filter
	 * @return a list of topic ids
	 */
	suspend fun matchTopicsBy(filter: FilterOptions<Topic>): List<String>

	/**
	 * Get the ids of all topics matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchTopicsBy].
	 *
	 * @param filter a topic filter
	 * @return a list of topic ids
	 */
	suspend fun matchTopicsBySorted(filter: SortableFilterOptions<Topic>): List<String>
}

interface TopicInGroupApi : TopicBasicFlavourlessInGroupApi, TopicFlavouredInGroupApi<DecryptedTopic> {
	/**
	 * In-group version of [TopicApi.withEncryptionMetadata]
	 */
	suspend fun withEncryptionMetadata(
		groupId: String,
		base: DecryptedTopic?,
		patient: GroupScoped<Patient>?,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent")
		secretId: SecretIdUseOption = SecretIdUseOption.UseAnySharedWithParent,
		@DefaultValue("null")
		alternateRootDelegateId: String? = null,
	): GroupScoped<DecryptedTopic>

	/**
	 * In-group version of [TopicApi.getEncryptionKeysOf]
	 */
	suspend fun getEncryptionKeysOf(topic: GroupScoped<Topic>): Set<HexString>

	/**
	 * In-group version of [TopicApi.hasWriteAccess]
	 */
	suspend fun hasWriteAccess(topic: GroupScoped<Topic>): Boolean

	/**
	 * In-group version of [TopicApi.decryptPatientIdOf]
	 */
	suspend fun decryptPatientIdOf(topic: GroupScoped<Topic>): Set<EntityReferenceInGroup>

	/**
	 * In-group version of [TopicApi.createDelegationDeAnonymizationMetadata]
	 */
	suspend fun createDelegationDeAnonymizationMetadata(entity: GroupScoped<Topic>, delegates: Set<EntityReferenceInGroup>)

	/**
	 * In-group version of [TopicApi.decrypt]
	 */
	suspend fun decrypt(topics: List<GroupScoped<EncryptedTopic>>): List<GroupScoped<DecryptedTopic>>

	/**
	 * In-group version of [TopicApi.tryDecrypt]
	 */
	suspend fun tryDecrypt(topics: List<GroupScoped<EncryptedTopic>>): List<GroupScoped<Topic>>

	/**
	 * In-group version of [TopicApi.matchTopicsBy]
	 */
	suspend fun matchTopicsBy(groupId: String, filter: FilterOptions<Topic>): List<String>

	/**
	 * In-group version of [TopicApi.matchTopicsBySorted]
	 */
	suspend fun matchTopicsBySorted(groupId: String, filter: SortableFilterOptions<Topic>): List<String>

	val encrypted: TopicFlavouredInGroupApi<EncryptedTopic>
	val tryAndRecover: TopicFlavouredInGroupApi<Topic>
}

interface TopicBasicApi : TopicBasicFlavourlessApi, TopicBasicFlavouredApi<EncryptedTopic>, Subscribable<Topic, EncryptedTopic, BaseFilterOptions<Topic>> {
	/**
	 * Gives access to methods of the api that allow to use entities or work with data owners in groups other than the
	 * current user's group.
	 */
	val inGroup: TopicBasicInGroupApi

	/**
	 * Get the ids of all topics matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchTopicsBySorted] instead.
	 *
	 * @param filter a topic filter
	 * @return a list of topic ids
	 */
	suspend fun matchTopicsBy(filter: BaseFilterOptions<Topic>): List<String>

	/**
	 * Get the ids of all topics matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchTopicsBy].
	 *
	 * @param filter a topic filter
	 * @return a list of topic ids
	 */
	suspend fun matchTopicsBySorted(filter: BaseSortableFilterOptions<Topic>): List<String>

	/**
	 * Get an iterator that iterates through all topics matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterTopicsBySorted] instead.
	 *
	 * @param filter a topic filter
	 * @return an iterator that iterates over all topics matching the provided filter.
	 */
	suspend fun filterTopicsBy(
		filter: BaseFilterOptions<Topic>
	): PaginatedListIterator<EncryptedTopic>

	/**
	 * Get an iterator that iterates through all topics matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterTopicsBy].
	 *
	 * @param filter a topic filter
	 * @return an iterator that iterates over all topics matching the provided filter.
	 */
	suspend fun filterTopicsBySorted(
		filter: BaseSortableFilterOptions<Topic>
	): PaginatedListIterator<EncryptedTopic>
}

interface TopicBasicInGroupApi : TopicBasicFlavourlessInGroupApi, TopicBasicFlavouredInGroupApi<EncryptedTopic> {
	/**
	 * In-group version of [TopicBasicApi.matchTopicsBy]
	 */
	suspend fun matchTopicsBy(groupId: String, filter: BaseFilterOptions<Topic>): List<String>

	/**
	 * In-group version of [TopicBasicApi.matchTopicsBySorted]
	 */
	suspend fun matchTopicsBySorted(groupId: String, filter: BaseSortableFilterOptions<Topic>): List<String>

	/**
	 * In-group version of [TopicBasicApi.filterTopicsBy]
	 */
	suspend fun filterTopicsBy(
		groupId: String,
		filter: BaseFilterOptions<Topic>
	): PaginatedListIterator<GroupScoped<EncryptedTopic>>

	/**
	 * In-group version of [TopicBasicApi.filterTopicsBySorted]
	 */
	suspend fun filterTopicsBySorted(
		groupId: String,
		filter: BaseSortableFilterOptions<Topic>
	): PaginatedListIterator<GroupScoped<EncryptedTopic>>
}

