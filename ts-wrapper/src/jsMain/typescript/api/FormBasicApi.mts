// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {EncryptedForm, Form} from '../model/Form.mjs';
import {FormTemplate} from '../model/FormTemplate.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {FormBasicInGroupApi} from './FormBasicInGroupApi.mjs';


export interface FormBasicApi {

	inGroup: FormBasicInGroupApi;

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
	matchFormsBy(filter: BaseFilterOptions<Form>): Promise<Array<string>>;

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
	matchFormsBySorted(filter: BaseSortableFilterOptions<Form>): Promise<Array<string>>;

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
	filterFormsBy(filter: BaseFilterOptions<Form>): Promise<PaginatedListIterator<EncryptedForm>>;

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
	filterFormsBySorted(filter: BaseSortableFilterOptions<Form>): Promise<PaginatedListIterator<EncryptedForm>>;

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
	 *  Create a new form. The provided form must have the encryption metadata initialized.
	 *  @param entity a form with initialized encryption metadata
	 *  @return the created form with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createForm(entity: EncryptedForm): Promise<EncryptedForm>;

	/**
	 *
	 *  Create multiple forms. All the provided forms must have the encryption metadata initialized, otherwise
	 *  this method fails without doing anything.
	 *  @param entities forms with initialized encryption metadata
	 *  @return the created forms with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of any form in the input was not initialized.
	 */
	createForms(entities: Array<EncryptedForm>): Promise<Array<EncryptedForm>>;

	/**
	 *
	 *  Modifies a form. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a form with update content
	 *  @return the form updated with the provided content and a new revision.
	 */
	modifyForm(entity: EncryptedForm): Promise<EncryptedForm>;

	/**
	 *
	 *  Modifies multiple forms. Ignores all forms for which you don't have write access.
	 *  Flavoured method.
	 *  @param entities forms with update content
	 *  @return the updated forms with a new revision.
	 */
	modifyForms(entities: Array<EncryptedForm>): Promise<Array<EncryptedForm>>;

	/**
	 *
	 *  Restores a form that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteFormById(id: string, rev: string): Promise<EncryptedForm>;

	/**
	 *
	 *  Restores a batch of formIds that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the formIds to restore.
	 *  @return the restored formIds. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteFormsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<EncryptedForm>>;

	/**
	 *
	 *  Restores a form that was marked as deleted.
	 *  @param form the form to undelete
	 *  @return the restored form.
	 *  @throws RevisionConflictException if the provided form doesn't match the latest known revision
	 */
	undeleteForm(form: Form): Promise<EncryptedForm>;

	/**
	 *
	 *  Restores a batch of forms that were marked as deleted.
	 *  @param forms the forms to restore.
	 *  @return the restored forms. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteForms(forms: Array<Form>): Promise<Array<EncryptedForm>>;

	/**
	 *
	 *  Get a form by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a form, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId a form id.
	 *  @return the form with id [entityId].
	 */
	getForm(entityId: string): Promise<EncryptedForm | undefined>;

	/**
	 *
	 *  Get multiple forms by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a form, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of forms ids
	 *  @return all forms that you can access with one of the provided ids.
	 */
	getForms(entityIds: Array<string>): Promise<Array<EncryptedForm>>;

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
	getLatestFormByUniqueId(uniqueId: string): Promise<EncryptedForm>;

}
