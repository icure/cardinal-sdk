// auto-generated file
import {BaseFilterOptions, FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
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

	/**
	 *
	 *  In-group version of [FormApi.withEncryptionMetadata]
	 */
	withEncryptionMetadata(entityGroupId: string, base: DecryptedForm | undefined,
			patient: GroupScoped<Patient> | undefined,
			options?: { user?: User | undefined, delegates?: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, accessLevel: AccessLevel }, 'delegate'>, secretId?: SecretIdUseOption, alternateRootDelegateReference?: EntityReferenceInGroup | undefined }): Promise<GroupScoped<DecryptedForm>>;

	/**
	 *
	 *  In-group version of [FormApi.getEncryptionKeysOf]
	 */
	getEncryptionKeysOf(form: GroupScoped<Form>): Promise<Array<HexString>>;

	/**
	 *
	 *  In-group version of [FormApi.hasWriteAccess]
	 */
	hasWriteAccess(form: GroupScoped<Form>): Promise<boolean>;

	/**
	 *
	 *  In-group version of [FormApi.decryptPatientIdOf]
	 */
	decryptPatientIdOf(form: GroupScoped<Form>): Promise<Array<EntityReferenceInGroup>>;

	/**
	 *
	 *  In-group version of [FormApi.createDelegationDeAnonymizationMetadata]
	 */
	createDelegationDeAnonymizationMetadata(entity: GroupScoped<Form>,
			delegates: Array<EntityReferenceInGroup>): Promise<void>;

	/**
	 *
	 *  In-group version of [FormApi.decrypt]
	 */
	decrypt(forms: Array<GroupScoped<EncryptedForm>>): Promise<Array<GroupScoped<DecryptedForm>>>;

	/**
	 *
	 *  In-group version of [FormApi.tryDecrypt]
	 */
	tryDecrypt(forms: Array<GroupScoped<EncryptedForm>>): Promise<Array<GroupScoped<Form>>>;

	/**
	 *
	 *  In-group version of [FormApi.matchFormsBy]
	 */
	matchFormsBy(groupId: string, filter: FilterOptions<Form>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [FormApi.matchFormsBySorted]
	 */
	matchFormsBySorted(groupId: string, filter: SortableFilterOptions<Form>): Promise<Array<string>>;

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
	 *  In-group version of [FormFlavouredApi.shareWith]
	 */
	shareWith(delegate: EntityReferenceInGroup, form: GroupScoped<DecryptedForm>,
			options?: { options?: FormShareOptions | undefined }): Promise<GroupScoped<DecryptedForm>>;

	/**
	 *
	 *  In-group version of [FormFlavouredApi.shareWithMany]
	 */
	shareWithMany(form: GroupScoped<DecryptedForm>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: FormShareOptions }, 'delegate'>): Promise<GroupScoped<DecryptedForm>>;

	/**
	 *
	 *  In-group version of [FormFlavouredApi.filterFormsBy]
	 */
	filterFormsBy(groupId: string,
			filter: FilterOptions<Form>): Promise<PaginatedListIterator<GroupScoped<DecryptedForm>>>;

	/**
	 *
	 *  In-group version of [FormFlavouredApi.filterFormsBySorted]
	 */
	filterFormsBySorted(groupId: string,
			filter: SortableFilterOptions<Form>): Promise<PaginatedListIterator<GroupScoped<DecryptedForm>>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavouredApi.createForm].
	 */
	createForm(entity: GroupScoped<DecryptedForm>): Promise<GroupScoped<DecryptedForm>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavouredApi.createForms].
	 */
	createForms(entities: Array<GroupScoped<DecryptedForm>>): Promise<Array<GroupScoped<DecryptedForm>>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavouredApi.undeleteFormById]
	 */
	undeleteFormById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<DecryptedForm>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavouredApi.undeleteFormsByIds]
	 */
	undeleteFormsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<DecryptedForm>>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavouredApi.undeleteForm]
	 */
	undeleteForm(form: GroupScoped<Form>): Promise<GroupScoped<DecryptedForm>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavouredApi.undeleteForms]
	 */
	undeleteForms(forms: Array<GroupScoped<DecryptedForm>>): Promise<Array<GroupScoped<DecryptedForm>>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavouredApi.modifyForm]
	 */
	modifyForm(entity: GroupScoped<DecryptedForm>): Promise<GroupScoped<DecryptedForm>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavouredApi.modifyForms]
	 */
	modifyForms(entities: Array<GroupScoped<DecryptedForm>>): Promise<Array<GroupScoped<DecryptedForm>>>;

	/**
	 *
	 *  In-group version of [FormBasicFlavouredApi.getForm]
	 */
	getForm(groupId: string, entityId: string): Promise<GroupScoped<DecryptedForm> | undefined>;

	/**
	 *
	 *  In-group version of [FormBasicFlavouredApi.getForms]
	 */
	getForms(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<DecryptedForm>>>;

}
