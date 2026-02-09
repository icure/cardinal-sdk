// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {FormShareOptions} from '../crypto/entities/FormShareOptions.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {DecryptedForm, EncryptedForm, Form} from '../model/Form.mjs';
import {FormTemplate} from '../model/FormTemplate.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';
import {FormFlavouredInGroupApi} from './FormFlavouredInGroupApi.mjs';


export interface FormInGroupApi {

	encrypted: FormFlavouredInGroupApi<EncryptedForm>;

	tryAndRecover: FormFlavouredInGroupApi<Form>;

	withEncryptionMetadata(entityGroupId: string, base: DecryptedForm | undefined,
			patient: GroupScoped<Patient> | undefined,
			options?: { user?: User | undefined, delegates?: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, accessLevel: AccessLevel }, 'delegate'>, secretId?: SecretIdUseOption, alternateRootDelegateReference?: EntityReferenceInGroup | undefined }): Promise<GroupScoped<DecryptedForm>>;

	getEncryptionKeysOf(form: GroupScoped<Form>): Promise<Array<HexString>>;

	hasWriteAccess(form: GroupScoped<Form>): Promise<boolean>;

	decryptPatientIdOf(form: GroupScoped<Form>): Promise<Array<EntityReferenceInGroup>>;

	createDelegationDeAnonymizationMetadata(entity: GroupScoped<Form>,
			delegates: Array<EntityReferenceInGroup>): Promise<void>;

	decrypt(forms: Array<GroupScoped<EncryptedForm>>): Promise<Array<GroupScoped<DecryptedForm>>>;

	tryDecrypt(forms: Array<GroupScoped<EncryptedForm>>): Promise<Array<GroupScoped<Form>>>;

	matchFormsBy(groupId: string, filter: FilterOptions<Form>): Promise<Array<string>>;

	matchFormsBySorted(groupId: string, filter: SortableFilterOptions<Form>): Promise<Array<string>>;

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

	shareWith(delegate: EntityReferenceInGroup, form: GroupScoped<DecryptedForm>,
			options?: { options?: FormShareOptions | undefined }): Promise<GroupScoped<DecryptedForm>>;

	shareWithMany(form: GroupScoped<DecryptedForm>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: FormShareOptions }, 'delegate'>): Promise<GroupScoped<DecryptedForm>>;

	filterFormsBy(groupId: string,
			filter: FilterOptions<Form>): Promise<PaginatedListIterator<GroupScoped<DecryptedForm>>>;

	filterFormsBySorted(groupId: string,
			filter: SortableFilterOptions<Form>): Promise<PaginatedListIterator<GroupScoped<DecryptedForm>>>;

	createForm(entity: GroupScoped<DecryptedForm>): Promise<GroupScoped<DecryptedForm>>;

	createForms(entities: Array<GroupScoped<DecryptedForm>>): Promise<Array<GroupScoped<DecryptedForm>>>;

	undeleteFormById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<DecryptedForm>>;

	undeleteFormsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<DecryptedForm>>>;

	undeleteForm(form: GroupScoped<Form>): Promise<GroupScoped<DecryptedForm>>;

	undeleteForms(forms: Array<GroupScoped<DecryptedForm>>): Promise<Array<GroupScoped<DecryptedForm>>>;

	modifyForm(entity: GroupScoped<DecryptedForm>): Promise<GroupScoped<DecryptedForm>>;

	modifyForms(entities: Array<GroupScoped<DecryptedForm>>): Promise<Array<GroupScoped<DecryptedForm>>>;

	getForm(groupId: string, entityId: string): Promise<GroupScoped<DecryptedForm> | undefined>;

	getForms(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<DecryptedForm>>>;

}
