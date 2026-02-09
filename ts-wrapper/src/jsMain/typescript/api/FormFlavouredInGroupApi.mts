// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {FormShareOptions} from '../crypto/entities/FormShareOptions.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {Form} from '../model/Form.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';


export interface FormFlavouredInGroupApi<E extends Form> {

	shareWith(delegate: EntityReferenceInGroup, form: GroupScoped<E>,
			options?: { options?: FormShareOptions | undefined }): Promise<GroupScoped<E>>;

	shareWithMany(form: GroupScoped<E>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: FormShareOptions }, 'delegate'>): Promise<GroupScoped<E>>;

	filterFormsBy(groupId: string,
			filter: FilterOptions<Form>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	filterFormsBySorted(groupId: string,
			filter: SortableFilterOptions<Form>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	createForm(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	createForms(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	undeleteFormById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<E>>;

	undeleteFormsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<E>>>;

	undeleteForm(form: GroupScoped<Form>): Promise<GroupScoped<E>>;

	undeleteForms(forms: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	modifyForm(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	modifyForms(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	getForm(groupId: string, entityId: string): Promise<GroupScoped<E> | undefined>;

	getForms(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<E>>>;

}
