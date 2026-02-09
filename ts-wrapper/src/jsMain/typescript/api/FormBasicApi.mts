// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {EncryptedForm, Form} from '../model/Form.mjs';
import {FormTemplate} from '../model/FormTemplate.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {FormBasicInGroupApi} from './FormBasicInGroupApi.mjs';


export interface FormBasicApi {

	inGroup: FormBasicInGroupApi;

	matchFormsBy(filter: BaseFilterOptions<Form>): Promise<Array<string>>;

	matchFormsBySorted(filter: BaseSortableFilterOptions<Form>): Promise<Array<string>>;

	filterFormsBy(filter: BaseFilterOptions<Form>): Promise<PaginatedListIterator<EncryptedForm>>;

	filterFormsBySorted(filter: BaseSortableFilterOptions<Form>): Promise<PaginatedListIterator<EncryptedForm>>;

	deleteFormById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deleteFormsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgeFormById(id: string, rev: string): Promise<void>;

	purgeFormsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	deleteForm(form: Form): Promise<StoredDocumentIdentifier>;

	deleteForms(forms: Array<Form>): Promise<Array<StoredDocumentIdentifier>>;

	purgeForm(form: Form): Promise<void>;

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

	setTemplateAttachment(formTemplateId: string, payload: Int8Array): Promise<string>;

	createForm(entity: EncryptedForm): Promise<EncryptedForm>;

	createForms(entities: Array<EncryptedForm>): Promise<Array<EncryptedForm>>;

	modifyForm(entity: EncryptedForm): Promise<EncryptedForm>;

	modifyForms(entities: Array<EncryptedForm>): Promise<Array<EncryptedForm>>;

	undeleteFormById(id: string, rev: string): Promise<EncryptedForm>;

	undeleteFormsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<EncryptedForm>>;

	undeleteForm(form: Form): Promise<EncryptedForm>;

	undeleteForms(forms: Array<Form>): Promise<Array<EncryptedForm>>;

	getForm(entityId: string): Promise<EncryptedForm | undefined>;

	getForms(entityIds: Array<string>): Promise<Array<EncryptedForm>>;

	getLatestFormByUniqueId(uniqueId: string): Promise<EncryptedForm>;

}
