// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {FormShareOptions} from '../crypto/entities/FormShareOptions.mjs';
import {Form} from '../model/Form.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface FormFlavouredApi<E extends Form> {

	shareWith(delegateId: string, form: E,
			options?: { options?: FormShareOptions | undefined }): Promise<E>;

	shareWithMany(form: E, delegates: { [ key: string ]: FormShareOptions }): Promise<E>;

	filterFormsBy(filter: FilterOptions<Form>): Promise<PaginatedListIterator<E>>;

	filterFormsBySorted(filter: SortableFilterOptions<Form>): Promise<PaginatedListIterator<E>>;

	createForm(entity: E): Promise<E>;

	createForms(entities: Array<E>): Promise<Array<E>>;

	modifyForm(entity: E): Promise<E>;

	modifyForms(entities: Array<E>): Promise<Array<E>>;

	undeleteFormById(id: string, rev: string): Promise<E>;

	undeleteFormsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<E>>;

	undeleteForm(form: Form): Promise<E>;

	undeleteForms(forms: Array<Form>): Promise<Array<E>>;

	getForm(entityId: string): Promise<E | undefined>;

	getForms(entityIds: Array<string>): Promise<Array<E>>;

	getLatestFormByUniqueId(uniqueId: string): Promise<E>;

}
