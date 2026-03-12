// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {FormShareOptions} from '../crypto/entities/FormShareOptions.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {Form} from '../model/Form.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';


export interface FormFlavouredInGroupApi<E extends Form> {

	/**
	 *
	 *  In-group version of [FormFlavouredApi.shareWith]
	 */
	shareWith(delegate: EntityReferenceInGroup, form: GroupScoped<E>,
			options?: { options?: FormShareOptions | undefined }): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [FormFlavouredApi.shareWithMany]
	 */
	shareWithMany(form: GroupScoped<E>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: FormShareOptions }, 'delegate'>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [FormFlavouredApi.filterFormsBy]
	 */
	filterFormsBy(groupId: string,
			filter: FilterOptions<Form>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [FormFlavouredApi.filterFormsBySorted]
	 */
	filterFormsBySorted(groupId: string,
			filter: SortableFilterOptions<Form>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavouredApi.createForm].
	 */
	createForm(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavouredApi.createForms].
	 */
	createForms(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavouredApi.undeleteFormById]
	 */
	undeleteFormById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavouredApi.undeleteFormsByIds]
	 */
	undeleteFormsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavouredApi.undeleteForm]
	 */
	undeleteForm(form: GroupScoped<Form>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavouredApi.undeleteForms]
	 */
	undeleteForms(forms: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavouredApi.modifyForm]
	 */
	modifyForm(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavouredApi.modifyForms]
	 */
	modifyForms(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavouredApi.getForm]
	 */
	getForm(groupId: string, entityId: string): Promise<GroupScoped<E> | undefined>;

	/**
	 *
	 *  In-group version of [FormBasicFlavouredApi.getForms]
	 */
	getForms(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<E>>>;

}
