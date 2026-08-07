package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.crypto.entities.ClassificationShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.Classification
import com.icure.cardinal.sdk.model.DecryptedClassification
import com.icure.cardinal.sdk.model.EncryptedClassification
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface ClassificationBasicFlavourlessApi {
	/**
	 * Deletes a classification. If you don't have write access to the classification the method will fail.
	 * @param entityId id of the classification.
	 * @return the id and revision of the deleted classification.
	 */
	suspend fun deleteClassification(entityId: String): DocIdentifier

	/**
	 * Deletes many classifications. Ids that do not correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids of the classifications.
	 * @return the id and revision of the deleted classifications. If some entities could not be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteClassifications(entityIds: List<String>): List<DocIdentifier>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface ClassificationBasicFlavouredApi<E : Classification> {
	/**
	 * Create a new classification. The provided classification must have the encryption metadata initialized.
	 * @param entity a classification with initialized encryption metadata
	 * @return the created classification with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	suspend fun createClassification(entity: E): E

	/**
	 * Modifies a classification. You need to have write access to the entity.
	 * Flavoured method.
	 * @param entity a classification with update content
	 * @return the classification updated with the provided content and a new revision.
	 */
	suspend fun modifyClassification(entity: E): E

	/**
	 * Get a classification by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 * entity, corresponds to an entity that is not a classification, or corresponds to an entity for which you don't have
	 * read access.
	 * Flavoured method.
	 * @param entityId a classification id.
	 * @return the classification with id [entityId].
	 */
	suspend fun getClassification(entityId: String): E?

	/**
	 * Get multiple classifications by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 * an entity that is not a classification, or correspond to an entity for which you don't have read access.
	 * Flavoured method.
	 * @param entityIds a list of classifications ids
	 * @return all classifications that you can access with one of the provided ids.
	 */
	suspend fun getClassifications(entityIds: List<String>): List<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface ClassificationFlavouredApi<E : Classification> : ClassificationBasicFlavouredApi<E> {
	/**
	 * Share a classification with another data owner. The classification must already exist in the database for this method to
	 * succeed. If you want to share the classification before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 * @param delegateId the owner that will gain access to the classification
	 * @param classification the classification to share with [delegateId]
	 * @param options specifies how the classification will be shared. By default, all data available to the current user
	 * will be shared, and the delegate will have the same permissions as the current user on the classification. Refer
	 * to the documentation of [ClassificationShareOptions] for more information.
	 * @return the updated classification if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun shareWith(
		delegateId: String,
		classification: E,
		@DefaultValue("null")
		options: ClassificationShareOptions? = null
	): E

	/**
	 * Share a classification with multiple data owners. The classification must already exist in the database for this method to
	 * succeed. If you want to share the classification before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 * Throws an exception if the operation fails.
	 * @param classification the classification to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated classification.
	 */
	suspend fun shareWithMany(
		classification: E,
		delegates: Map<String, ClassificationShareOptions>
	): E

	@Deprecated("Use filter instead")
	suspend fun findClassificationsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		@DefaultValue("null")
		startDate: Long? = null,
		@DefaultValue("null")
		endDate: Long? = null,
		@DefaultValue("null")
		descending: Boolean? = null,
	): PaginatedListIterator<E>

	/**
	 * Get an iterator that iterates through all classifications matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterClassificationsBySorted] instead.
	 *
	 * @param filter a classification filter
	 * @return an iterator that iterates over all classifications matching the provided filter.
	 */
	suspend fun filterClassificationsBy(
		filter: FilterOptions<Classification>
	): PaginatedListIterator<E>

	/**
	 * Get an iterator that iterates through all classifications matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterClassificationsBy].
	 *
	 * @param filter a classification filter
	 * @return an iterator that iterates over all classifications matching the provided filter.
	 */
	suspend fun filterClassificationsBySorted(
		filter: SortableFilterOptions<Classification>
	): PaginatedListIterator<E>
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface ClassificationApi : ClassificationBasicFlavourlessApi, ClassificationFlavouredApi<DecryptedClassification> {
	/**
	 * Creates a new classification with initialized encryption metadata
	 * @param base a classification with initialized content and uninitialized encryption metadata. The result of this
	 * method takes the content from [base] if provided.
	 * @param patient the patient linked to the classification.
	 * @param user the current user, will be used for the auto-delegations if provided.
	 * @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 * permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 * @param secretId specifies which secret id of [patient] to use for the new classification
	 * @return a classification with initialized encryption metadata.
	 * @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	suspend fun withEncryptionMetadata(
		base: DecryptedClassification?,
		patient: Patient,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithHierarchy")
		secretId: SecretIdUseOption = SecretIdUseOption.UseAnySharedWithHierarchy,
		@DefaultValue("null")
		alternateRootDelegateId: String? = null,
	): DecryptedClassification

	/**
	 * Attempts to extract the encryption keys of a classification. If the user does not have access to any encryption key
	 * of the access log the method will return an empty set.
	 * Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 * versions of iCure where this was not a guarantee.
	 * @param classification a classification
	 * @return the encryption keys extracted from the provided classification.
	 */
	suspend fun getEncryptionKeysOf(classification: Classification): Set<HexString>

	/**
	 * Specifies if the current user has write access to a classification through delegations.
	 * Doesn't consider actual permissions on the server side: for example, if the data owner has access to all entities
	 * thanks to extended permission but has no delegation on the provided entity this method returns false. Similarly,
	 * if the SDK was initialized in hierarchical mode but the user is lacking the hierarchical permission on the server
	 * side this method will still return true if there is a delegation to the parent.
	 * @param classification a classification
	 * @return if the current user has write access to the provided classification
	 */
	suspend fun hasWriteAccess(classification: Classification): Boolean

	/**
	 * Attempts to extract the patient id linked to a classification.
	 * Note: classifications usually should be linked with only one patient, but this method returns a set for compatibility
	 * with older versions of iCure
	 * @param classification a classification
	 * @return the id of the patient linked to the classification, or empty if the current user can't access any patient id
	 * of the classification.
	 */
	suspend fun decryptPatientIdOf(classification: Classification): Set<String>

	/**
	 * Create metadata to allow other users to identify the anonymous delegates of a classification.
	 *
	 * When calling this method the SDK will use all the information available to the current user to try to identify
	 * any anonymous data-owners in the delegations of the provided classification. The SDK will be able to identify the
	 * anonymous data owners of the delegations only under the following conditions:
	 * - The other participant of the delegation is the current data owner
	 * - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 * current data owner
	 * - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 * After identifying the anonymous delegates in the classification the sdk will create the corresponding de-anonymization
	 * metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 * Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any Classification,
	 * not only in the provided instance.
	 *
	 * ## Example
	 *
	 * If you have a classification E, and you have shared it with patient P and healthcare party H, H will not
	 * be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 * H. From now on, for any classification that you have shared with P, H will be able to know that the classification was
	 * shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 * At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 * delegator-delegate pair, you will not be able to see if P has access to a classification that was created by H and
	 * shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 * @param entity a classification
	 * @param delegates a set of data owner ids
	 */
	suspend fun createDelegationDeAnonymizationMetadata(entity: Classification, delegates: Set<String>)

	/**
	 * Decrypts a classification, throwing an exception if it is not possible.
	 * @param classification a classification
	 * @return the decrypted classification
	 * @throws EntityEncryptionException if the classification could not be decrypted
	 */
	suspend fun decrypt(classification: EncryptedClassification): DecryptedClassification

	/**
	 * Tries to decrypt a classification, returns the input if it is not possible.
	 * @param classification an encrypted classification
	 * @return the decrypted classification if the decryption was successful or the input if it was not.
	 */
	suspend fun tryDecrypt(classification: EncryptedClassification): Classification

	/**
	 * Give access to the encrypted flavour of the api
	 */
	val encrypted: ClassificationFlavouredApi<EncryptedClassification>

	/**
	 * Gives access to the polymorphic flavour of the api
	 */
	val tryAndRecover: ClassificationFlavouredApi<Classification>

	/**
	 * Get the ids of all classifications matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchClassificationsBySorted] instead.
	 *
	 * @param filter a classification filter
	 * @return a list of classification ids
	 */
	suspend fun matchClassificationsBy(filter: FilterOptions<Classification>): List<String>

	/**
	 * Get the ids of all classifications matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchClassificationsBy].
	 *
	 * @param filter a classification filter
	 * @return a list of classification ids
	 */
	suspend fun matchClassificationsBySorted(filter: SortableFilterOptions<Classification>): List<String>
}

interface ClassificationBasicApi : ClassificationBasicFlavourlessApi, ClassificationBasicFlavouredApi<EncryptedClassification> {
	/**
	 * Get the ids of all classifications matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchClassificationsBySorted] instead.
	 *
	 * @param filter a classification filter
	 * @return a list of classification ids
	 */
	suspend fun matchClassificationsBy(filter: BaseFilterOptions<Classification>): List<String>

	/**
	 * Get the ids of all classifications matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchClassificationsBy].
	 *
	 * @param filter a classification filter
	 * @return a list of classification ids
	 */
	suspend fun matchClassificationsBySorted(filter: BaseSortableFilterOptions<Classification>): List<String>

	/**
	 * Get an iterator that iterates through all classifications matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterClassificationsBySorted] instead.
	 *
	 * @param filter a classification filter
	 * @return an iterator that iterates over all classifications matching the provided filter.
	 */
	suspend fun filterClassificationsBy(
		filter: BaseFilterOptions<Classification>
	): PaginatedListIterator<EncryptedClassification>

	/**
	 * Get an iterator that iterates through all classifications matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterClassificationsBy].
	 *
	 * @param filter a classification filter
	 * @return an iterator that iterates over all classifications matching the provided filter.
	 */
	suspend fun filterClassificationsBySorted(
		filter: BaseSortableFilterOptions<Classification>
	): PaginatedListIterator<EncryptedClassification>
}

