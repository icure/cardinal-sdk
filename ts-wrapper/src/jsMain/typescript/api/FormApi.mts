// auto-generated file
import {BaseFilterOptions, FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {FormShareOptions} from '../crypto/entities/FormShareOptions.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {DecryptedForm, EncryptedForm, Form} from '../model/Form.mjs';
import {FormTemplate} from '../model/FormTemplate.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {FormFlavouredApi} from './FormFlavouredApi.mjs';
import {FormInGroupApi} from './FormInGroupApi.mjs';


export interface FormApi {

	encrypted: FormFlavouredApi<EncryptedForm>;

	tryAndRecover: FormFlavouredApi<Form>;

	inGroup: FormInGroupApi;

	/**
	 *
	 *  Creates a new form with initialized encryption metadata
	 *  @param base a form with initialized content and uninitialized encryption metadata. The result of this
	 *  method takes the content from [base] if provided.
	 *  @param patient the patient linked to the form.
	 *  @param user the current user, will be used for the auto-delegations if provided.
	 *  @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 *  permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 *  @param secretId specifies which secret id of [patient] to use for the new form
	 *  @return a form with initialized encryption metadata.
	 *  @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	withEncryptionMetadata(base: DecryptedForm | undefined, patient: Patient,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption, alternateRootDelegateId?: string | undefined }): Promise<DecryptedForm>;

	/**
	 *
	 *  Attempts to extract the encryption keys of a form. If the user does not have access to any encryption key
	 *  of the access log the method will return an empty set.
	 *  Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 *  versions of iCure where this was not a guarantee.
	 *  @param form a form
	 *  @return the encryption keys extracted from the provided form.
	 */
	getEncryptionKeysOf(form: Form): Promise<Array<HexString>>;

	/**
	 *
	 *  Specifies if the current user has write access to a form through delegations.
	 *  Doesn't consider actual permissions on the server side: for example, if the data owner has access to all entities
	 *  thanks to extended permission but has no delegation on the provided entity this method returns false. Similarly,
	 *  if the SDK was initialized in hierarchical mode but the user is lacking the hierarchical permission on the server
	 *  side this method will still return true if there is a delegation to the parent.
	 *  @param form a form
	 *  @return if the current user has write access to the provided form
	 */
	hasWriteAccess(form: Form): Promise<boolean>;

	/**
	 *
	 *  Attempts to extract the patient id linked to a form.
	 *  Note: forms usually should be linked with only one patient, but this method returns a set for compatibility
	 *  with older versions of iCure
	 *  @param form a form
	 *  @return the id of the patient linked to the form, or empty if the current user can't access any patient id
	 *  of the form.
	 */
	decryptPatientIdOf(form: Form): Promise<Array<EntityReferenceInGroup>>;

	/**
	 *
	 *  Create metadata to allow other users to identify the anonymous delegates of a form.
	 *
	 *  When calling this method the SDK will use all the information available to the current user to try to identify
	 *  any anonymous data-owners in the delegations of the provided form. The SDK will be able to identify the
	 *  anonymous data owners of the delegations only under the following conditions:
	 *  - The other participant of the delegation is the current data owner
	 *  - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 *  current data owner
	 *  - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 *  After identifying the anonymous delegates in the form the sdk will create the corresponding de-anonymization
	 *  metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 *  Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any Form,
	 *  not only in the provided instance.
	 *
	 *  ## Example
	 *
	 *  If you have a form E, and you have shared it with patient P and healthcare party H, H will not
	 *  be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 *  H. From now on, for any form that you have shared with P, H will be able to know that the form was
	 *  shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 *  At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 *  delegator-delegate pair, you will not be able to see if P has access to a form that was created by H and
	 *  shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 *  @param entity a form
	 *  @param delegates a set of data owner ids
	 */
	createDelegationDeAnonymizationMetadata(entity: Form, delegates: Array<string>): Promise<void>;

	/**
	 *
	 *  Decrypts a form, throwing an exception if it is not possible.
	 *  @param form a form
	 *  @return the decrypted form
	 *  @throws EntityEncryptionException if the form could not be decrypted
	 */
	decrypt(form: EncryptedForm): Promise<DecryptedForm>;

	/**
	 *
	 *  Tries to decrypt a form, returns the input if it is not possible.
	 *  @param form an encrypted form
	 *  @return the decrypted form if the decryption was successful or the input if it was not.
	 */
	tryDecrypt(form: EncryptedForm): Promise<Form>;

	/**
	 *
	 *  Get the ids of all forms matching the provided filter.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [matchFormsBySorted] instead.
	 *
	 *  @param filter a form filter
	 *  @return a list of form ids
	 */
	matchFormsBy(filter: FilterOptions<Form>): Promise<Array<string>>;

	/**
	 *
	 *  Get the ids of all forms matching the provided filter.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [matchFormsBy].
	 *
	 *  @param filter a form filter
	 *  @return a list of form ids
	 */
	matchFormsBySorted(filter: SortableFilterOptions<Form>): Promise<Array<string>>;

	/**
	 *
	 *  Deletes a form. If you don't have write access to the form the method will fail.
	 *  @param entityId id of the form.
	 *  @param rev the latest known rev of the form to delete
	 *  @return the id and revision of the deleted form.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	deleteFormById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many forms. Ids that do not correspond to an entity, or that correspond to an entity for which
	 *  you don't have write access will be ignored.
	 *  @param entityIds ids and revisions of the forms to delete.
	 *  @return the id and revision of the deleted forms. If some entities could not be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	deleteFormsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a form.
	 *  @param id id of the form to purge
	 *  @param rev latest revision of the form
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	purgeFormById(id: string, rev: string): Promise<void>;

	/**
	 *
	 *  Permanently deletes many forms.
	 *  @param entityIds ids and revisions of the forms to delete
	 *  @return the id and revision of the deleted forms. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeFormsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Deletes a form. If you don't have write access to the form the method will fail.
	 *  @param form the form to delete
	 *  @return the id and revision of the deleted form.
	 *  @throws RevisionConflictException if the provided form doesn't match the latest known revision
	 */
	deleteForm(form: Form): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many forms. Ignores form for which you don't have write access or that don't match the latest revision.
	 *  @param forms the forms to delete
	 *  @return the id and revision of the deleted forms. If some entities couldn't be deleted they will not be
	 *  included in this list.
	 */
	deleteForms(forms: Array<Form>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a form.
	 *  @param form the form to purge.
	 *  @throws RevisionConflictException if the provided form doesn't match the latest known revision
	 */
	purgeForm(form: Form): Promise<void>;

	/**
	 *
	 *  Permanently deletes many forms.
	 *  @param forms the forms to purge.
	 *  @return the id and revision of the deleted forms. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeForms(forms: Array<Form>): Promise<Array<StoredDocumentIdentifier>>;

	getFormTemplate(formTemplateId: string,
			options?: { raw?: boolean | undefined }): Promise<FormTemplate>;

	getFormTemplates(formTemplateIds: Array<string>): Promise<Array<FormTemplate>>;

	createFormTemplate(formTemplate: FormTemplate): Promise<FormTemplate>;

	createFormTemplates(formTemplates: Array<FormTemplate>): Promise<Array<FormTemplate>>;

	modifyFormTemplate(formTemplate: FormTemplate): Promise<FormTemplate>;

	modifyFormTemplates(formTemplates: Array<FormTemplate>): Promise<Array<FormTemplate>>;

	deleteFormTemplateById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deleteFormTemplatesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	deleteFormTemplate(formTemplate: FormTemplate): Promise<StoredDocumentIdentifier>;

	deleteFormTemplates(formTemplates: Array<FormTemplate>): Promise<Array<StoredDocumentIdentifier>>;

	undeleteFormTemplateById(id: string, rev: string): Promise<FormTemplate>;

	undeleteFormTemplatesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<FormTemplate>>;

	undeleteFormTemplate(formTemplate: FormTemplate): Promise<FormTemplate>;

	undeleteFormTemplates(formTemplates: Array<FormTemplate>): Promise<Array<FormTemplate>>;

	purgeFormTemplateById(id: string, rev: string): Promise<void>;

	purgeFormTemplatesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgeFormTemplate(formTemplate: FormTemplate): Promise<void>;

	purgeFormTemplates(formTemplates: Array<FormTemplate>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Sets the attachment to the form template.
	 */
	setTemplateAttachment(formTemplateId: string, payload: Int8Array): Promise<string>;

	matchFormTemplateBy(filter: BaseFilterOptions<FormTemplate>): Promise<Array<string>>;

	/**
	 *
	 *  Share a form with another data owner. The form must already exist in the database for this method to
	 *  succeed. If you want to share the form before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  @param delegateId the owner that will gain access to the form
	 *  @param form the form to share with [delegateId]
	 *  @param options specifies how the form will be shared. By default, all data available to the current user
	 *  will be shared, and the delegate will have the same permissions as the current user on the form. Refer
	 *  to the documentation of [FormShareOptions] for more information.
	 *  @return the updated form if the sharing was successful, or details on the errors if the sharing failed.
	 */
	shareWith(delegateId: string, form: DecryptedForm,
			options?: { options?: FormShareOptions | undefined }): Promise<DecryptedForm>;

	/**
	 *
	 *  Share a form with multiple data owners. The form must already exist in the database for this method to
	 *  succeed. If you want to share the form before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  Throws an exception if the operation fails.
	 *  @param form the form to share
	 *  @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 *  each of them.
	 *  @return the updated form.
	 */
	shareWithMany(form: DecryptedForm,
			delegates: { [ key: string ]: FormShareOptions }): Promise<DecryptedForm>;

	/**
	 *
	 *  Get an iterator that iterates through all forms matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [filterFormsBySorted] instead.
	 *
	 *  @param filter a form filter
	 *  @return an iterator that iterates over all forms matching the provided filter.
	 */
	filterFormsBy(filter: FilterOptions<Form>): Promise<PaginatedListIterator<DecryptedForm>>;

	/**
	 *
	 *  Get an iterator that iterates through all forms matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [filterFormsBy].
	 *
	 *  @param filter a form filter
	 *  @return an iterator that iterates over all forms matching the provided filter.
	 */
	filterFormsBySorted(filter: SortableFilterOptions<Form>): Promise<PaginatedListIterator<DecryptedForm>>;

	/**
	 *
	 *  Create a new form. The provided form must have the encryption metadata initialized.
	 *  @param entity a form with initialized encryption metadata
	 *  @return the created form with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createForm(entity: DecryptedForm): Promise<DecryptedForm>;

	/**
	 *
	 *  Create multiple forms. All the provided forms must have the encryption metadata initialized, otherwise
	 *  this method fails without doing anything.
	 *  @param entities forms with initialized encryption metadata
	 *  @return the created forms with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of any form in the input was not initialized.
	 */
	createForms(entities: Array<DecryptedForm>): Promise<Array<DecryptedForm>>;

	/**
	 *
	 *  Modifies a form. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a form with update content
	 *  @return the form updated with the provided content and a new revision.
	 */
	modifyForm(entity: DecryptedForm): Promise<DecryptedForm>;

	/**
	 *
	 *  Modifies multiple forms. Ignores all forms for which you don't have write access.
	 *  Flavoured method.
	 *  @param entities forms with update content
	 *  @return the updated forms with a new revision.
	 */
	modifyForms(entities: Array<DecryptedForm>): Promise<Array<DecryptedForm>>;

	/**
	 *
	 *  Restores a form that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteFormById(id: string, rev: string): Promise<DecryptedForm>;

	/**
	 *
	 *  Restores a batch of formIds that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the formIds to restore.
	 *  @return the restored formIds. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteFormsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<DecryptedForm>>;

	/**
	 *
	 *  Restores a form that was marked as deleted.
	 *  @param form the form to undelete
	 *  @return the restored form.
	 *  @throws RevisionConflictException if the provided form doesn't match the latest known revision
	 */
	undeleteForm(form: Form): Promise<DecryptedForm>;

	/**
	 *
	 *  Restores a batch of forms that were marked as deleted.
	 *  @param forms the forms to restore.
	 *  @return the restored forms. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteForms(forms: Array<Form>): Promise<Array<DecryptedForm>>;

	/**
	 *
	 *  Get a form by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a form, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId a form id.
	 *  @return the form with id [entityId].
	 */
	getForm(entityId: string): Promise<DecryptedForm | undefined>;

	/**
	 *
	 *  Get multiple forms by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a form, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of forms ids
	 *  @return all forms that you can access with one of the provided ids.
	 */
	getForms(entityIds: Array<string>): Promise<Array<DecryptedForm>>;

	/**
	 *
	 *  Get the latest form according to the [Form.created] field with the provided [Form.uniqueId].
	 *  If there are multiple forms with the provided unique id that have the same value for created (which also
	 *  matches the latest) the behaviour of this method is undefined. If you think this situation may happen in your
	 *  application you should not use this method and instead use filters to get all forms with the provided id.
	 *  Flavoured method.
	 *  @param uniqueId a form unique id
	 *  @return the latest form with the provided unique id.
	 */
	getLatestFormByUniqueId(uniqueId: string): Promise<DecryptedForm>;

}
