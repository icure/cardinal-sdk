// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {ClassificationShareOptions} from '../crypto/entities/ClassificationShareOptions.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {Classification, DecryptedClassification, EncryptedClassification} from '../model/Classification.mjs';
import {Patient} from '../model/Patient.mjs';
import {User} from '../model/User.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {ClassificationFlavouredApi} from './ClassificationFlavouredApi.mjs';


export interface ClassificationApi {

	encrypted: ClassificationFlavouredApi<EncryptedClassification>;

	tryAndRecover: ClassificationFlavouredApi<Classification>;

	/**
	 *
	 *  Creates a new classification with initialized encryption metadata
	 *  @param base a classification with initialized content and uninitialized encryption metadata. The result of this
	 *  method takes the content from [base] if provided.
	 *  @param patient the patient linked to the classification.
	 *  @param user the current user, will be used for the auto-delegations if provided.
	 *  @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 *  permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 *  @param secretId specifies which secret id of [patient] to use for the new classification
	 *  @return a classification with initialized encryption metadata.
	 *  @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	withEncryptionMetadata(base: DecryptedClassification | undefined, patient: Patient,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption, alternateRootDelegateId?: string | undefined }): Promise<DecryptedClassification>;

	/**
	 *
	 *  Attempts to extract the encryption keys of a classification. If the user does not have access to any encryption key
	 *  of the access log the method will return an empty set.
	 *  Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 *  versions of iCure where this was not a guarantee.
	 *  @param classification a classification
	 *  @return the encryption keys extracted from the provided classification.
	 */
	getEncryptionKeysOf(classification: Classification): Promise<Array<HexString>>;

	/**
	 *
	 *  Specifies if the current user has write access to a classification through delegations.
	 *  Doesn't consider actual permissions on the server side: for example, if the data owner has access to all entities
	 *  thanks to extended permission but has no delegation on the provided entity this method returns false. Similarly,
	 *  if the SDK was initialized in hierarchical mode but the user is lacking the hierarchical permission on the server
	 *  side this method will still return true if there is a delegation to the parent.
	 *  @param classification a classification
	 *  @return if the current user has write access to the provided classification
	 */
	hasWriteAccess(classification: Classification): Promise<boolean>;

	/**
	 *
	 *  Attempts to extract the patient id linked to a classification.
	 *  Note: classifications usually should be linked with only one patient, but this method returns a set for compatibility
	 *  with older versions of iCure
	 *  @param classification a classification
	 *  @return the id of the patient linked to the classification, or empty if the current user can't access any patient id
	 *  of the classification.
	 */
	decryptPatientIdOf(classification: Classification): Promise<Array<string>>;

	/**
	 *
	 *  Create metadata to allow other users to identify the anonymous delegates of a classification.
	 *
	 *  When calling this method the SDK will use all the information available to the current user to try to identify
	 *  any anonymous data-owners in the delegations of the provided classification. The SDK will be able to identify the
	 *  anonymous data owners of the delegations only under the following conditions:
	 *  - The other participant of the delegation is the current data owner
	 *  - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 *  current data owner
	 *  - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 *  After identifying the anonymous delegates in the classification the sdk will create the corresponding de-anonymization
	 *  metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 *  Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any Classification,
	 *  not only in the provided instance.
	 *
	 *  ## Example
	 *
	 *  If you have a classification E, and you have shared it with patient P and healthcare party H, H will not
	 *  be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 *  H. From now on, for any classification that you have shared with P, H will be able to know that the classification was
	 *  shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 *  At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 *  delegator-delegate pair, you will not be able to see if P has access to a classification that was created by H and
	 *  shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 *  @param entity a classification
	 *  @param delegates a set of data owner ids
	 */
	createDelegationDeAnonymizationMetadata(entity: Classification,
			delegates: Array<string>): Promise<void>;

	/**
	 *
	 *  Decrypts a classification, throwing an exception if it is not possible.
	 *  @param classification a classification
	 *  @return the decrypted classification
	 *  @throws EntityEncryptionException if the classification could not be decrypted
	 */
	decrypt(classification: EncryptedClassification): Promise<DecryptedClassification>;

	/**
	 *
	 *  Tries to decrypt a classification, returns the input if it is not possible.
	 *  @param classification an encrypted classification
	 *  @return the decrypted classification if the decryption was successful or the input if it was not.
	 */
	tryDecrypt(classification: EncryptedClassification): Promise<Classification>;

	/**
	 *
	 *  Get the ids of all classifications matching the provided filter.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [matchClassificationsBySorted] instead.
	 *
	 *  @param filter a classification filter
	 *  @return a list of classification ids
	 */
	matchClassificationsBy(filter: FilterOptions<Classification>): Promise<Array<string>>;

	/**
	 *
	 *  Get the ids of all classifications matching the provided filter.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [matchClassificationsBy].
	 *
	 *  @param filter a classification filter
	 *  @return a list of classification ids
	 */
	matchClassificationsBySorted(filter: SortableFilterOptions<Classification>): Promise<Array<string>>;

	/**
	 *
	 *  Deletes a classification. If you don't have write access to the classification the method will fail.
	 *  @param entityId id of the classification.
	 *  @return the id and revision of the deleted classification.
	 */
	deleteClassification(entityId: string): Promise<DocIdentifier>;

	/**
	 *
	 *  Deletes many classifications. Ids that do not correspond to an entity, or that correspond to an entity for which
	 *  you don't have write access will be ignored.
	 *  @param entityIds ids of the classifications.
	 *  @return the id and revision of the deleted classifications. If some entities could not be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	deleteClassifications(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	/**
	 *
	 *  Share a classification with another data owner. The classification must already exist in the database for this method to
	 *  succeed. If you want to share the classification before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  @param delegateId the owner that will gain access to the classification
	 *  @param classification the classification to share with [delegateId]
	 *  @param options specifies how the classification will be shared. By default, all data available to the current user
	 *  will be shared, and the delegate will have the same permissions as the current user on the classification. Refer
	 *  to the documentation of [ClassificationShareOptions] for more information.
	 *  @return the updated classification if the sharing was successful, or details on the errors if the sharing failed.
	 */
	shareWith(delegateId: string, classification: DecryptedClassification,
			options?: { options?: ClassificationShareOptions | undefined }): Promise<DecryptedClassification>;

	/**
	 *
	 *  Share a classification with multiple data owners. The classification must already exist in the database for this method to
	 *  succeed. If you want to share the classification before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  Throws an exception if the operation fails.
	 *  @param classification the classification to share
	 *  @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 *  each of them.
	 *  @return the updated classification.
	 */
	shareWithMany(classification: DecryptedClassification,
			delegates: { [ key: string ]: ClassificationShareOptions }): Promise<DecryptedClassification>;

	findClassificationsByHcPartyPatient(hcPartyId: string, patient: Patient,
			options?: { startDate?: number | undefined, endDate?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedListIterator<DecryptedClassification>>;

	/**
	 *
	 *  Get an iterator that iterates through all classifications matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [filterClassificationsBySorted] instead.
	 *
	 *  @param filter a classification filter
	 *  @return an iterator that iterates over all classifications matching the provided filter.
	 */
	filterClassificationsBy(filter: FilterOptions<Classification>): Promise<PaginatedListIterator<DecryptedClassification>>;

	/**
	 *
	 *  Get an iterator that iterates through all classifications matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [filterClassificationsBy].
	 *
	 *  @param filter a classification filter
	 *  @return an iterator that iterates over all classifications matching the provided filter.
	 */
	filterClassificationsBySorted(filter: SortableFilterOptions<Classification>): Promise<PaginatedListIterator<DecryptedClassification>>;

	/**
	 *
	 *  Create a new classification. The provided classification must have the encryption metadata initialized.
	 *  @param entity a classification with initialized encryption metadata
	 *  @return the created classification with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createClassification(entity: DecryptedClassification): Promise<DecryptedClassification>;

	/**
	 *
	 *  Modifies a classification. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a classification with update content
	 *  @return the classification updated with the provided content and a new revision.
	 */
	modifyClassification(entity: DecryptedClassification): Promise<DecryptedClassification>;

	/**
	 *
	 *  Get a classification by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a classification, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId a classification id.
	 *  @return the classification with id [entityId].
	 */
	getClassification(entityId: string): Promise<DecryptedClassification | undefined>;

	/**
	 *
	 *  Get multiple classifications by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a classification, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of classifications ids
	 *  @return all classifications that you can access with one of the provided ids.
	 */
	getClassifications(entityIds: Array<string>): Promise<Array<DecryptedClassification>>;

}
