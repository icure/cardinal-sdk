// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {EncryptedForm, Form} from '../model/Form.mjs';
import {FormTemplate} from '../model/FormTemplate.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface FormBasicInGroupApi {

	matchFormsBy(groupId: string, filter: BaseFilterOptions<Form>): Promise<Array<string>>;

	matchFormsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Form>): Promise<Array<string>>;

	filterFormsBy(groupId: string,
			filter: BaseFilterOptions<Form>): Promise<PaginatedListIterator<GroupScoped<EncryptedForm>>>;

	filterFormsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Form>): Promise<PaginatedListIterator<GroupScoped<EncryptedForm>>>;

	deleteFormById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteFormsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeFormById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	purgeFormsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	deleteForm(form: GroupScoped<Form>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteForms(forms: Array<GroupScoped<Form>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeForm(form: GroupScoped<Form>): Promise<void>;

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

	createForm(entity: GroupScoped<EncryptedForm>): Promise<GroupScoped<EncryptedForm>>;

	createForms(entities: Array<GroupScoped<EncryptedForm>>): Promise<Array<GroupScoped<EncryptedForm>>>;

	undeleteFormById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<EncryptedForm>>;

	undeleteFormsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<EncryptedForm>>>;

	undeleteForm(form: GroupScoped<Form>): Promise<GroupScoped<EncryptedForm>>;

	undeleteForms(forms: Array<GroupScoped<EncryptedForm>>): Promise<Array<GroupScoped<EncryptedForm>>>;

	modifyForm(entity: GroupScoped<EncryptedForm>): Promise<GroupScoped<EncryptedForm>>;

	modifyForms(entities: Array<GroupScoped<EncryptedForm>>): Promise<Array<GroupScoped<EncryptedForm>>>;

	getForm(groupId: string, entityId: string): Promise<GroupScoped<EncryptedForm> | undefined>;

	getForms(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<EncryptedForm>>>;

}
