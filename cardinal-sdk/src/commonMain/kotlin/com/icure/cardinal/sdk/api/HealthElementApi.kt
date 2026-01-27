package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.crypto.entities.HealthElementShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.exceptions.RevisionConflictException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.DecryptedHealthElement
import com.icure.cardinal.sdk.model.EncryptedHealthElement
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
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
interface HealthElementBasicFlavourlessApi  {

	/**
	 * Deletes a healthElement. If you don't have write access to the healthElement the method will fail.
	 * @param entityId id of the healthElement.
	 * @param rev the latest known rev of the healthElement to delete
	 * @return the id and revision of the deleted healthElement.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun deleteHealthElementById(entityId: String, rev: String): StoredDocumentIdentifier

	/**
	 * Deletes many healthElements. Ids that do not correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids and revisions of the healthElements to delete.
	 * @return the id and revision of the deleted healthElements. If some entities could not be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteHealthElementsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier>

	/**
	 * Permanently deletes a healthElement.
	 * @param id id of the healthElement to purge
	 * @param rev latest revision of the healthElement
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun purgeHealthElementById(id: String, rev: String)

	/**
	 * Permanently deletes many healthElements.
	 * @param entityIds ids and revisions of the healthElements to delete
	 * @return the id and revision of the deleted healthElements. If some entities couldn't be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun purgeHealthElementsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier>

	/**
	 * Deletes a healthElement. If you don't have write access to the healthElement the method will fail.
	 * @param healthElement the healthElement to delete
	 * @return the id and revision of the deleted healthElement.
	 * @throws RevisionConflictException if the provided healthElement doesn't match the latest known revision
	 */
	suspend fun deleteHealthElement(healthElement: HealthElement): StoredDocumentIdentifier =
		deleteHealthElementById(healthElement.id, requireNotNull(healthElement.rev) { "Can't delete an healthElement that has no rev" })

	/**
	 * Deletes many healthElements. Ignores healthElement for which you don't have write access or that don't match the latest revision.
	 * @param healthElements the healthElements to delete
	 * @return the id and revision of the deleted healthElements. If some entities couldn't be deleted they will not be
	 * included in this list.
	 */
	suspend fun deleteHealthElements(healthElements: List<HealthElement>): List<StoredDocumentIdentifier> =
		deleteHealthElementsByIds(healthElements.map { healthElement ->
			healthElement.toStoredDocumentIdentifier()
		})

	/**
	 * Permanently deletes a healthElement.
	 * @param healthElement the healthElement to purge.
	 * @throws RevisionConflictException if the provided healthElement doesn't match the latest known revision
	 */
	suspend fun purgeHealthElement(healthElement: HealthElement) {
		purgeHealthElementById(healthElement.id, requireNotNull(healthElement.rev) { "Can't delete an healthElement that has no rev" })
	}

	/**
	 * Permanently deletes many healthElements.
	 * @param healthElements the healthElements to purge.
	 * @return the id and revision of the deleted healthElements. If some entities couldn't be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun purgeHealthElements(healthElements: List<HealthElement>): List<StoredDocumentIdentifier> =
		purgeHealthElementsByIds(healthElements.map { it.toStoredDocumentIdentifier() })
}

interface HealthElementBasicFlavourlessInGroupApi  {
	/**
	 * In-group version of [HealthElementBasicFlavourlessApi.deleteHealthElementById]
	 */
	suspend fun deleteHealthElementById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier>

	/**
	 * In-group version of [HealthElementBasicFlavourlessApi.deleteHealthElementsByIds]
	 */
	suspend fun deleteHealthElementsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>>

	/**
	 * In-group version of [HealthElementBasicFlavourlessApi.purgeHealthElementById]
	 */
	suspend fun purgeHealthElementById(entityId: GroupScoped<StoredDocumentIdentifier>)

	/**
	 * In-group version of [HealthElementBasicFlavourlessApi.purgeHealthElementsByIds]
	 */
	suspend fun purgeHealthElementsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>>

	/**
	 * In-group version of [HealthElementBasicFlavourlessApi.deleteHealthElement]
	 */
	suspend fun deleteHealthElement(healthElement: GroupScoped<HealthElement>): GroupScoped<StoredDocumentIdentifier> =
		deleteHealthElementById(healthElement.toStoredDocumentIdentifier())

	/**
	 * In-group version of [HealthElementBasicFlavourlessApi.deleteHealthElements]
	 */
	suspend fun deleteHealthElements(healthElements: List<GroupScoped<HealthElement>>): List<GroupScoped<StoredDocumentIdentifier>> =
		deleteHealthElementsByIds(healthElements.toStoredDocumentIdentifier())

	/**
	 * In-group version of [HealthElementBasicFlavourlessApi.purgeHealthElement]
	 */
	suspend fun purgeHealthElement(healthElement: GroupScoped<HealthElement>) {
		purgeHealthElementById(healthElement.toStoredDocumentIdentifier())
	}

	/**
	 * In-group version of [HealthElementBasicFlavourlessApi.purgeHealthElements]
	 */
	suspend fun purgeHealthElements(healthElements: List<GroupScoped<HealthElement>>): List<GroupScoped<StoredDocumentIdentifier>> =
		purgeHealthElementsByIds(healthElements.map { it.toStoredDocumentIdentifier() })
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface HealthElementBasicFlavouredApi<E : HealthElement> {
	/**
	 * Create a new health element. The provided health element must have the encryption metadata initialized.
	 * @param entity a health element with initialized encryption metadata
	 * @return the created health element with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	suspend fun createHealthElement(entity: E): E

	/**
	 * Create multiple health elements. All the provided health elements must have the encryption metadata initialized, otherwise
	 * this method fails without doing anything.
	 * @param entities health elements with initialized encryption metadata
	 * @return the created health elements with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of any health element in the input was not initialized.
	 */
	suspend fun createHealthElements(entities: List<E>): List<E>

	/**
	 * Restores a healthElement that was marked as deleted.
	 * @param id the id of the entity
	 * @param rev the latest revision of the entity.
	 * @return the restored entity.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun undeleteHealthElementById(id: String, rev: String): E

	/**
	 * Restores a batch of healthElementIds that were marked as deleted.
	 * @param entityIds the ids and the revisions of the healthElementIds to restore.
	 * @return the restored healthElementIds. If some entities couldn't be restored (because the user does not have access or the revision is not
	 * up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	suspend fun undeleteHealthElementsByIds(entityIds: List<StoredDocumentIdentifier>): List<E>

	/**
	 * Restores a healthElement that was marked as deleted.
	 * @param healthElement the healthElement to undelete
	 * @return the restored healthElement.
	 * @throws RevisionConflictException if the provided healthElement doesn't match the latest known revision
	 */
	suspend fun undeleteHealthElement(healthElement: HealthElement): E =
		undeleteHealthElementById(healthElement.id, requireNotNull(healthElement.rev) { "Can't delete an healthElement that has no rev" })

	/**
	 * Restores a batch of healthElements that were marked as deleted.
	 * @param healthElements the healthElements to restore.
	 * @return the restored healthElements. If some entities couldn't be restored (because the user does not have access or the revision is not
	 * up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	suspend fun undeleteHealthElements(healthElements: List<HealthElement>): List<E> =
		undeleteHealthElementsByIds(healthElements.map { it.toStoredDocumentIdentifier() })

	/**
	 * Modifies a health element. You need to have write access to the entity.
	 * Flavoured method.
	 * @param entity a health element with update content
	 * @return the health element updated with the provided content and a new revision.
	 */
	suspend fun modifyHealthElement(entity: E): E

	/**
	 * Modifies multiple health elements. Ignores all health elements for which you don't have write access.
	 * Flavoured method.
	 * @param entities health elements with update content
	 * @return the updated health elements with a new revision.
	 */
	suspend fun modifyHealthElements(entities: List<E>): List<E>

	/**
	 * Get a health element by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 * entity, corresponds to an entity that is not a health element, or corresponds to an entity for which you don't have
	 * read access.
	 * Flavoured method.
	 * @param entityId a health element id.
	 * @return the health element with id [entityId].
	 */
	suspend fun getHealthElement(entityId: String): E?

	/**
	 * Get multiple health elements by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 * an entity that is not a health element, or correspond to an entity for which you don't have read access.
	 * Flavoured method.
	 * @param entityIds a list of health elements ids
	 * @return all health elements that you can access with one of the provided ids.
	 */
	suspend fun getHealthElements(entityIds: List<String>): List<E>
}

interface HealthElementBasicFlavouredInGroupApi<E : HealthElement> {
	/**
	 * In-group version of [HealthElementApi.createHealthElement]
	 */
	suspend fun createHealthElement(entity: GroupScoped<E>): GroupScoped<E>

	/**
	 * In-group version of [HealthElementApi.createHealthElements]
	 */
	suspend fun createHealthElements(entities: List<GroupScoped<E>>): List<GroupScoped<E>>

	/**
	 * In-group version of [HealthElementBasicFlavouredApi.undeleteHealthElementById]
	 */
	suspend fun undeleteHealthElementById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<E>

	/**
	 * In-group version of [HealthElementBasicFlavouredApi.undeleteHealthElementsByIds]
	 */
	suspend fun undeleteHealthElementsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<E>>

	/**
	 * In-group version of [HealthElementBasicFlavouredApi.undeleteHealthElement]
	 */
	suspend fun undeleteHealthElement(healthElement: GroupScoped<HealthElement>): GroupScoped<E> =
		undeleteHealthElementById(healthElement.toStoredDocumentIdentifier())

	/**
	 * In-group version of [HealthElementBasicFlavouredApi.undeleteHealthElements]
	 */
	suspend fun undeleteHealthElements(healthElements: List<GroupScoped<E>>): List<GroupScoped<E>> =
		undeleteHealthElementsByIds(healthElements.map { it.toStoredDocumentIdentifier() })

	/**
	 * In-group version of [HealthElementBasicFlavouredApi.modifyHealthElement]
	 */
	suspend fun modifyHealthElement(entity: GroupScoped<E>): GroupScoped<E>

	/**
	 * In-group version of [HealthElementBasicFlavouredApi.modifyHealthElements]
	 */
	suspend fun modifyHealthElements(entities: List<GroupScoped<E>>): List<GroupScoped<E>>

	/**
	 * In-group version of [HealthElementBasicFlavouredApi.getHealthElement]
	 */
	suspend fun getHealthElement(groupId: String, entityId: String): GroupScoped<E>?

	/**
	 * In-group version of [HealthElementBasicFlavouredApi.getHealthElements]
	 */
	suspend fun getHealthElements(groupId: String, entityIds: List<String>): List<GroupScoped<E>>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface HealthElementFlavouredApi<E : HealthElement> : HealthElementBasicFlavouredApi<E> {
	/**
	 * Share a health element with another data owner. The health element must already exist in the database for this method to
	 * succeed. If you want to share the health element before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 * @param delegateId the owner that will gain access to the health element
	 * @param healthElement the health element to share with [delegateId]
	 * @param options specifies how the health element will be shared. By default, all data available to the current user
	 * will be shared, and the delegate will have the same permissions as the current user on the health element. Refer
	 * to the documentation of [HealthElementShareOptions] for more information.
	 * @return the updated health element if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun shareWith(
		delegateId: String,
		healthElement: E,
		@DefaultValue("null")
		options: HealthElementShareOptions? = null
	): E

	/**
	 * Share a health element with multiple data owners. The health element must already exist in the database for this method to
	 * succeed. If you want to share the health element before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 * Throws an exception if the operation fails.
	 * @param healthElement the health element to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated health element.
	 */
	suspend fun shareWithMany(
		healthElement: E,
		delegates: Map<String, HealthElementShareOptions>
	): E

	/**
	 * Get an iterator that iterates through all health elements matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterHealthElementsBySorted] instead.
	 *
	 * @param filter a health element filter
	 * @return an iterator that iterates over all health elements matching the provided filter.
	 */
	suspend fun filterHealthElementsBy(
		filter: FilterOptions<HealthElement>
	): PaginatedListIterator<E>

	/**
	 * Get an iterator that iterates through all health elements matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterHealthElementsBy].
	 *
	 * @param filter a health element filter
	 * @return an iterator that iterates over all health elements matching the provided filter.
	 */
	suspend fun filterHealthElementsBySorted(
		filter: SortableFilterOptions<HealthElement>
	): PaginatedListIterator<E>
}

interface HealthElementFlavouredInGroupApi<E : HealthElement> : HealthElementBasicFlavouredInGroupApi<E> {
	/**
	 * In-group version of [HealthElementFlavouredApi.shareWith]
	 */
	suspend fun shareWith(
		delegate: EntityReferenceInGroup,
		healthElement: GroupScoped<E>,
		@DefaultValue("null")
		options: HealthElementShareOptions? = null
	): GroupScoped<E>

	/**
	 * In-group version of [HealthElementFlavouredApi.shareWithMany]
	 */
	suspend fun shareWithMany(
		healthElement: GroupScoped<E>,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, HealthElementShareOptions>
	): GroupScoped<E>

	/**
	 * In-group version of [HealthElementFlavouredApi.filterHealthElementsBy]
	 */
	suspend fun filterHealthElementsBy(groupId: String, filter: FilterOptions<HealthElement>): PaginatedListIterator<GroupScoped<E>>

	/**
	 * In-group version of [HealthElementFlavouredApi.filterHealthElementsBySorted]
	 */
	suspend fun filterHealthElementsBySorted(groupId: String, filter: SortableFilterOptions<HealthElement>): PaginatedListIterator<GroupScoped<E>>
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface HealthElementApi : HealthElementBasicFlavourlessApi, HealthElementFlavouredApi<DecryptedHealthElement>, Subscribable<HealthElement, EncryptedHealthElement, FilterOptions<HealthElement>> {
	/**
	 * Give access to the encrypted flavour of the api
	 */
	val encrypted: HealthElementFlavouredApi<EncryptedHealthElement>

	/**
	 * Gives access to the polymorphic flavour of the api
	 */
	val tryAndRecover: HealthElementFlavouredApi<HealthElement>

	/**
	 * Gives access to methods of the api that allow to use entities or work with data owners in groups other than the
	 * current user's group.
	 * These methods aren't available when connected to a kraken-lite instance.
	 */
	val inGroup: HealthElementInGroupApi

	/**
	 * Creates a new health element with initialized encryption metadata
	 * @param base a health element with initialized content and uninitialized encryption metadata. The result of this
	 * method takes the content from [base] if provided.
	 * @param patient the patient linked to the health element.
	 * @param user the current user, will be used for the auto-delegations if provided.
	 * @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 * permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 * @param secretId specifies which secret id of [patient] to use for the new health element
	 * @return a health element with initialized encryption metadata.
	 * @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	suspend fun withEncryptionMetadata(
		base: DecryptedHealthElement?,
		patient: Patient,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent")
		secretId: SecretIdUseOption = SecretIdUseOption.UseAnySharedWithParent,
		@DefaultValue("null")
		alternateRootDelegateId: String? = null,
	): DecryptedHealthElement

	/**
	 * Attempts to extract the encryption keys of a health element. If the user does not have access to any encryption key
	 * of the access log the method will return an empty set.
	 * Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 * versions of iCure where this was not a guarantee.
	 * @param healthElement a health element
	 * @return the encryption keys extracted from the provided health element.
	 */
	suspend fun getEncryptionKeysOf(healthElement: HealthElement): Set<HexString>

	/**
	 * Specifies if the current user has write access to a health element through delegations.
	 * Doesn't consider actual permissions on the server side: for example, if the data owner has access to all entities
	 * thanks to extended permission but has no delegation on the provided entity this method returns false. Similarly,
	 * if the SDK was initialized in hierarchical mode but the user is lacking the hierarchical permission on the server
	 * side this method will still return true if there is a delegation to the parent.
	 * @param healthElement a health element
	 * @return if the current user has write access to the provided health element
	 */
	suspend fun hasWriteAccess(healthElement: HealthElement): Boolean

	/**
	 * Attempts to extract the patient id linked to a health element.
	 * Note: health elements usually should be linked with only one patient, but this method returns a set for compatibility
	 * with older versions of iCure
	 * @param healthElement a health element
	 * @return the id of the patient linked to the health element, or empty if the current user can't access any patient id
	 * of the health element.
	 */
	suspend fun decryptPatientIdOf(healthElement: HealthElement): Set<EntityReferenceInGroup>

	/**
	 * Create metadata to allow other users to identify the anonymous delegates of a health element.
	 *
	 * When calling this method the SDK will use all the information available to the current user to try to identify
	 * any anonymous data-owners in the delegations of the provided health element. The SDK will be able to identify the
	 * anonymous data owners of the delegations only under the following conditions:
	 * - The other participant of the delegation is the current data owner
	 * - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 * current data owner
	 * - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 * After identifying the anonymous delegates in the health element the sdk will create the corresponding de-anonymization
	 * metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 * Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any HealthElement,
	 * not only in the provided instance.
	 *
	 * ## Example
	 *
	 * If you have a health element E, and you have shared it with patient P and healthcare party H, H will not
	 * be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 * H. From now on, for any health element that you have shared with P, H will be able to know that the health element was
	 * shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 * At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 * delegator-delegate pair, you will not be able to see if P has access to a health element that was created by H and
	 * shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 * @param entity a health element
	 * @param delegates a set of data owner ids
	 */
	suspend fun createDelegationDeAnonymizationMetadata(entity: HealthElement, delegates: Set<String>)
	/**
	 * Decrypts HealthElements, throwing an exception if it is not possible.
	 * @param healthElements encrypted HealthElements
	 * @return the decrypted HealthElements
	 * @throws EntityEncryptionException if any of the provided HealthElements couldn't be decrypted
	 */
	suspend fun decrypt(healthElements: List<EncryptedHealthElement>): List<DecryptedHealthElement>

	/**
	 * Tries to decrypt a HealthElement, returns the input if it is not possible.
	 * @param healthElements encrypted HealthElements
	 * @return all the provided HealthElements, each of them decrypted if possible or unchanged (still encrypted)
	 */
	suspend fun tryDecrypt(healthElements: List<EncryptedHealthElement>): List<HealthElement>

	/**
	 * Encrypts provided decrypted HealthElements, and validates already encrypted HealthElements.
	 * @param healthElements HealthElements to encrypt and/or validate
	 * @return the encrypted and validates HealthElements
	 * @throws EntityEncryptionException if any of the provided decrypted HealthElements couldn't be encrypted (the current
	 * user can't access its encryption key or no key was initialized) or if the already encrypted HealthElements don't
	 * respect the manifest.
	 */
	suspend fun encryptOrValidate(healthElements: List<HealthElement>): List<EncryptedHealthElement>

	/**
	 * Get the ids of all health elements matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchHealthElementsBySorted] instead.
	 *
	 * @param filter a health element filter
	 * @return a list of health element ids
	 */
	suspend fun matchHealthElementsBy(filter: FilterOptions<HealthElement>): List<String>

	/**
	 * Get the ids of all health elements matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchHealthElementsBy].
	 *
	 * @param filter a health element filter
	 * @return a list of health element ids
	 */
	suspend fun matchHealthElementsBySorted(filter: SortableFilterOptions<HealthElement>): List<String>
}

interface HealthElementInGroupApi : HealthElementBasicFlavourlessInGroupApi, HealthElementFlavouredInGroupApi<DecryptedHealthElement> { // TODO subscribable
	/**
	 * Give access to the encrypted flavour of the api
	 */
	val encrypted: HealthElementFlavouredInGroupApi<EncryptedHealthElement>

	/**
	 * Gives access to the polymorphic flavour of the api
	 */
	val tryAndRecover: HealthElementFlavouredInGroupApi<HealthElement>

	/**
	 * In-group version of [HealthElementApi.withEncryptionMetadata]
	 */
	suspend fun withEncryptionMetadata(
		entityGroupId: String,
		base: DecryptedHealthElement?,
		patient: GroupScoped<Patient>,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "accessLevel") Map<EntityReferenceInGroup, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent")
		secretId: SecretIdUseOption = SecretIdUseOption.UseAnySharedWithParent,
		@DefaultValue("null")
		alternateRootDelegateReference: EntityReferenceInGroup? = null,
	): GroupScoped<DecryptedHealthElement>

	/**
	 * In-group version of [HealthElementApi.getEncryptionKeysOf]
	 */
	suspend fun getEncryptionKeysOf(healthElement: GroupScoped<HealthElement>): Set<HexString>

	/**
	 * In-group version of [HealthElementApi.hasWriteAccess]
	 */
	suspend fun hasWriteAccess(healthElement: GroupScoped<HealthElement>): Boolean

	/**
	 * In-group version of [HealthElementApi.decryptPatientIdOf]
	 */
	suspend fun decryptPatientIdOf(healthElement: GroupScoped<HealthElement>): Set<EntityReferenceInGroup>

	/**
	 * In-group version of [HealthElementApi.createDelegationDeAnonymizationMetadata]
	 */
	suspend fun createDelegationDeAnonymizationMetadata(entity: GroupScoped<HealthElement>, delegates: Set<EntityReferenceInGroup>)

	/**
	 * In-group version of [HealthElementApi.decrypt]
	 */
	suspend fun decrypt(healthElements: List<GroupScoped<EncryptedHealthElement>>): List<GroupScoped<DecryptedHealthElement>>

	/**
	 * In-group version of [HealthElementApi.tryDecrypt]
	 */
	suspend fun tryDecrypt(healthElements: List<GroupScoped<EncryptedHealthElement>>): List<GroupScoped<HealthElement>>

	/**
	 * In-group version of [HealthElementApi.encryptOrValidate]
	 */
	suspend fun encryptOrValidate(healthElements: List<GroupScoped<HealthElement>>): List<GroupScoped<EncryptedHealthElement>>

	/**
	 * In-group version of [HealthElementApi.matchHealthElementsBy]
	 */
	suspend fun matchHealthElementsBy(groupId: String, filter: FilterOptions<HealthElement>): List<String>

	/**
	 * In-group version of [HealthElementApi.matchHealthElementsBySorted]
	 */
	suspend fun matchHealthElementsBySorted(groupId: String, filter: SortableFilterOptions<HealthElement>): List<String>
}

interface HealthElementBasicApi : HealthElementBasicFlavourlessApi, HealthElementBasicFlavouredApi<EncryptedHealthElement>, Subscribable<HealthElement, EncryptedHealthElement, BaseFilterOptions<HealthElement>> {
	/**
	 * Gives access to methods of the api that allow to use entities or work with data owners in groups other than the
	 * current user's group.
	 * These methods aren't available when connected to a kraken-lite instance.
	 */
	val inGroup: HealthElementBasicInGroupApi

	/**
	 * Get the ids of all health elements matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchHealthElementsBySorted] instead.
	 *
	 * @param filter a health element filter
	 * @return a list of health element ids
	 */
	suspend fun matchHealthElementsBy(filter: BaseFilterOptions<HealthElement>): List<String>

	/**
	 * Get the ids of all health elements matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchHealthElementsBy].
	 *
	 * @param filter a health element filter
	 * @return a list of health element ids
	 */
	suspend fun matchHealthElementsBySorted(filter: BaseSortableFilterOptions<HealthElement>): List<String>

	/**
	 * Get an iterator that iterates through all health elements matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterHealthElementsBySorted] instead.
	 *
	 * @param filter a health element filter
	 * @return an iterator that iterates over all health elements matching the provided filter.
	 */
	suspend fun filterHealthElementsBy(
		filter: BaseFilterOptions<HealthElement>
	): PaginatedListIterator<EncryptedHealthElement>

	/**
	 * Get an iterator that iterates through all health elements matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterHealthElementsBy].
	 *
	 * @param filter a health element filter
	 * @return an iterator that iterates over all health elements matching the provided filter.
	 */
	suspend fun filterHealthElementsBySorted(
		filter: BaseSortableFilterOptions<HealthElement>
	): PaginatedListIterator<EncryptedHealthElement>
}

interface HealthElementBasicInGroupApi : HealthElementBasicFlavourlessInGroupApi, HealthElementBasicFlavouredInGroupApi<EncryptedHealthElement> { // TODO subscribable
	/**
	 * In-group version of [HealthElementApi.matchHealthElementsBy]
	 */
	suspend fun matchHealthElementsBy(groupId: String, filter: BaseFilterOptions<HealthElement>): List<String>

	/**
	 * In-group version of [HealthElementApi.matchHealthElementsBySorted]
	 */
	suspend fun matchHealthElementsBySorted(groupId: String, filter: BaseSortableFilterOptions<HealthElement>): List<String>

	/**
	 * In-group version of [HealthElementApi.filterHealthElementsBy]
	 */
	suspend fun filterHealthElementsBy(groupId: String, filter: BaseFilterOptions<HealthElement>): PaginatedListIterator<GroupScoped<EncryptedHealthElement>>

	/**
	 * In-group version of [HealthElementApi.filterHealthElementsBySorted]
	 */
	suspend fun filterHealthElementsBySorted(groupId: String, filter: BaseSortableFilterOptions<HealthElement>): PaginatedListIterator<GroupScoped<EncryptedHealthElement>>
}
