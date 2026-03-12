// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {EncryptedForm, Form} from '../model/Form.mjs';
import {FormTemplate} from '../model/FormTemplate.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface FormBasicInGroupApi {

	/**
	 *
	 *  In-group version of [FormBasicApi.matchFormsBy]
	 */
	matchFormsBy(groupId: string, filter: BaseFilterOptions<Form>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [FormBasicApi.matchFormsBySorted]
	 */
	matchFormsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Form>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [FormBasicApi.filterFormsBy]
	 */
	filterFormsBy(groupId: string,
			filter: BaseFilterOptions<Form>): Promise<PaginatedListIterator<GroupScoped<EncryptedForm>>>;

	/**
	 *
	 *  In-group version of [FormBasicApi.filterFormsBySorted]
	 */
	filterFormsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Form>): Promise<PaginatedListIterator<GroupScoped<EncryptedForm>>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavourlessApi.deleteFormById]
	 */
	deleteFormById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavourlessApi.deleteFormsByIds]
	 */
	deleteFormsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavourlessApi.purgeFormById]
	 */
	purgeFormById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	/**
	 *
	 *  In-group version of [FormBasicFlavourlessApi.purgeFormsByIds]
	 */
	purgeFormsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavourlessApi.deleteForm]
	 */
	deleteForm(form: GroupScoped<Form>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavourlessApi.deleteForms]
	 */
	deleteForms(forms: Array<GroupScoped<Form>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavourlessApi.purgeForm]
	 */
	purgeForm(form: GroupScoped<Form>): Promise<void>;

	/**
	 *
	 *  In-group version of [FormBasicFlavourlessApi.purgeForms]
	 */
	purgeForms(forms: Array<GroupScoped<Form>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	createFormTemplate(formTemplate: GroupScoped<FormTemplate>): Promise<GroupScoped<FormTemplate>>;

	createFormTemplates(formTemplates: Array<GroupScoped<FormTemplate>>): Promise<Array<GroupScoped<FormTemplate>>>;

	getFormTemplate(groupId: string,
			formTemplateId: string): Promise<GroupScoped<FormTemplate> | undefined>;

	getFormTemplates(groupId: string,
			formTemplatesIds: Array<string>): Promise<Array<GroupScoped<FormTemplate>>>;

	modifyFormTemplate(formTemplate: GroupScoped<FormTemplate>): Promise<GroupScoped<FormTemplate>>;

	modifyFormTemplates(formTemplates: Array<GroupScoped<FormTemplate>>): Promise<Array<GroupScoped<FormTemplate>>>;

	deleteFormTemplateById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteFormTemplateByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	deleteFormTemplate(formTemplate: GroupScoped<FormTemplate>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteFormTemplates(formTemplates: Array<GroupScoped<FormTemplate>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	undeleteFormTemplateById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<FormTemplate>>;

	undeleteFormTemplateByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<FormTemplate>>>;

	undeleteFormTemplate(formTemplate: GroupScoped<FormTemplate>): Promise<GroupScoped<FormTemplate>>;

	undeleteFormTemplates(formTemplates: Array<GroupScoped<FormTemplate>>): Promise<Array<GroupScoped<FormTemplate>>>;

	purgeFormTemplateById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	purgeFormTemplateByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeFormTemplate(formTemplate: GroupScoped<FormTemplate>): Promise<void>;

	purgeFormTemplates(formTemplates: Array<GroupScoped<FormTemplate>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	matchFormTemplateBy(groupId: string,
			filter: BaseFilterOptions<FormTemplate>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavouredApi.createForm].
	 */
	createForm(entity: GroupScoped<EncryptedForm>): Promise<GroupScoped<EncryptedForm>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavouredApi.createForms].
	 */
	createForms(entities: Array<GroupScoped<EncryptedForm>>): Promise<Array<GroupScoped<EncryptedForm>>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavouredApi.undeleteFormById]
	 */
	undeleteFormById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<EncryptedForm>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavouredApi.undeleteFormsByIds]
	 */
	undeleteFormsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<EncryptedForm>>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavouredApi.undeleteForm]
	 */
	undeleteForm(form: GroupScoped<Form>): Promise<GroupScoped<EncryptedForm>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavouredApi.undeleteForms]
	 */
	undeleteForms(forms: Array<GroupScoped<EncryptedForm>>): Promise<Array<GroupScoped<EncryptedForm>>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavouredApi.modifyForm]
	 */
	modifyForm(entity: GroupScoped<EncryptedForm>): Promise<GroupScoped<EncryptedForm>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavouredApi.modifyForms]
	 */
	modifyForms(entities: Array<GroupScoped<EncryptedForm>>): Promise<Array<GroupScoped<EncryptedForm>>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavouredApi.getForm]
	 */
	getForm(groupId: string, entityId: string): Promise<GroupScoped<EncryptedForm> | undefined>;

	/**
	 *
	 *  In-group version of [FormBasicFlavouredApi.getForms]
	 */
	getForms(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<EncryptedForm>>>;

}
