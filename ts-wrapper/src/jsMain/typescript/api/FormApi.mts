// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
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

	withEncryptionMetadata(base: DecryptedForm | undefined, patient: Patient,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption, alternateRootDelegateId?: string | undefined }): Promise<DecryptedForm>;

	getEncryptionKeysOf(form: Form): Promise<Array<HexString>>;

	hasWriteAccess(form: Form): Promise<boolean>;

	decryptPatientIdOf(form: Form): Promise<Array<EntityReferenceInGroup>>;

	createDelegationDeAnonymizationMetadata(entity: Form, delegates: Array<string>): Promise<void>;

	decrypt(form: EncryptedForm): Promise<DecryptedForm>;

	tryDecrypt(form: EncryptedForm): Promise<Form>;

	matchFormsBy(filter: FilterOptions<Form>): Promise<Array<string>>;

	matchFormsBySorted(filter: SortableFilterOptions<Form>): Promise<Array<string>>;

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

	shareWith(delegateId: string, form: DecryptedForm,
			options?: { options?: FormShareOptions | undefined }): Promise<DecryptedForm>;

	shareWithMany(form: DecryptedForm,
			delegates: { [ key: string ]: FormShareOptions }): Promise<DecryptedForm>;

	filterFormsBy(filter: FilterOptions<Form>): Promise<PaginatedListIterator<DecryptedForm>>;

	filterFormsBySorted(filter: SortableFilterOptions<Form>): Promise<PaginatedListIterator<DecryptedForm>>;

	createForm(entity: DecryptedForm): Promise<DecryptedForm>;

	createForms(entities: Array<DecryptedForm>): Promise<Array<DecryptedForm>>;

	modifyForm(entity: DecryptedForm): Promise<DecryptedForm>;

	modifyForms(entities: Array<DecryptedForm>): Promise<Array<DecryptedForm>>;

	undeleteFormById(id: string, rev: string): Promise<DecryptedForm>;

	undeleteFormsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<DecryptedForm>>;

	undeleteForm(form: Form): Promise<DecryptedForm>;

	undeleteForms(forms: Array<Form>): Promise<Array<DecryptedForm>>;

	getForm(entityId: string): Promise<DecryptedForm | undefined>;

	getForms(entityIds: Array<string>): Promise<Array<DecryptedForm>>;

	getLatestFormByUniqueId(uniqueId: string): Promise<DecryptedForm>;

}
