// auto-generated file
import {FormTemplate} from '../model/FormTemplate.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface FormTemplateApi {

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

}
