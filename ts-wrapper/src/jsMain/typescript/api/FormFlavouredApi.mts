// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {FormShareOptions} from '../crypto/entities/FormShareOptions.mjs';
import {Form} from '../model/Form.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface FormFlavouredApi<E extends Form> {

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
	shareWith(delegateId: string, form: E,
			options?: { options?: FormShareOptions | undefined }): Promise<E>;

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
	shareWithMany(form: E, delegates: { [ key: string ]: FormShareOptions }): Promise<E>;

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
	filterFormsBy(filter: FilterOptions<Form>): Promise<PaginatedListIterator<E>>;

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
	filterFormsBySorted(filter: SortableFilterOptions<Form>): Promise<PaginatedListIterator<E>>;

	/**
	 *
	 *  Create a new form. The provided form must have the encryption metadata initialized.
	 *  @param entity a form with initialized encryption metadata
	 *  @return the created form with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createForm(entity: E): Promise<E>;

	/**
	 *
	 *  Create multiple forms. All the provided forms must have the encryption metadata initialized, otherwise
	 *  this method fails without doing anything.
	 *  @param entities forms with initialized encryption metadata
	 *  @return the created forms with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of any form in the input was not initialized.
	 */
	createForms(entities: Array<E>): Promise<Array<E>>;

	/**
	 *
	 *  Modifies a form. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a form with update content
	 *  @return the form updated with the provided content and a new revision.
	 */
	modifyForm(entity: E): Promise<E>;

	/**
	 *
	 *  Modifies multiple forms. Ignores all forms for which you don't have write access.
	 *  Flavoured method.
	 *  @param entities forms with update content
	 *  @return the updated forms with a new revision.
	 */
	modifyForms(entities: Array<E>): Promise<Array<E>>;

	/**
	 *
	 *  Restores a form that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteFormById(id: string, rev: string): Promise<E>;

	/**
	 *
	 *  Restores a batch of formIds that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the formIds to restore.
	 *  @return the restored formIds. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteFormsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<E>>;

	/**
	 *
	 *  Restores a form that was marked as deleted.
	 *  @param form the form to undelete
	 *  @return the restored form.
	 *  @throws RevisionConflictException if the provided form doesn't match the latest known revision
	 */
	undeleteForm(form: Form): Promise<E>;

	/**
	 *
	 *  Restores a batch of forms that were marked as deleted.
	 *  @param forms the forms to restore.
	 *  @return the restored forms. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteForms(forms: Array<Form>): Promise<Array<E>>;

	/**
	 *
	 *  Get a form by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a form, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId a form id.
	 *  @return the form with id [entityId].
	 */
	getForm(entityId: string): Promise<E | undefined>;

	/**
	 *
	 *  Get multiple forms by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a form, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of forms ids
	 *  @return all forms that you can access with one of the provided ids.
	 */
	getForms(entityIds: Array<string>): Promise<Array<E>>;

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
	getLatestFormByUniqueId(uniqueId: string): Promise<E>;

}
