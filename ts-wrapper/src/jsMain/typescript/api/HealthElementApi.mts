// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {HealthElementShareOptions} from '../crypto/entities/HealthElementShareOptions.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {DecryptedHealthElement, EncryptedHealthElement, HealthElement} from '../model/HealthElement.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';
import {HealthElementFlavouredApi} from './HealthElementFlavouredApi.mjs';
import {HealthElementInGroupApi} from './HealthElementInGroupApi.mjs';


export interface HealthElementApi {

	encrypted: HealthElementFlavouredApi<EncryptedHealthElement>;

	tryAndRecover: HealthElementFlavouredApi<HealthElement>;

	inGroup: HealthElementInGroupApi;

	withEncryptionMetadata(base: DecryptedHealthElement | undefined, patient: Patient,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption, alternateRootDelegateId?: string | undefined }): Promise<DecryptedHealthElement>;

	getEncryptionKeysOf(healthElement: HealthElement): Promise<Array<HexString>>;

	hasWriteAccess(healthElement: HealthElement): Promise<boolean>;

	decryptPatientIdOf(healthElement: HealthElement): Promise<Array<EntityReferenceInGroup>>;

	createDelegationDeAnonymizationMetadata(entity: HealthElement,
			delegates: Array<string>): Promise<void>;

	decrypt(healthElements: Array<EncryptedHealthElement>): Promise<Array<DecryptedHealthElement>>;

	tryDecrypt(healthElements: Array<EncryptedHealthElement>): Promise<Array<HealthElement>>;

	encryptOrValidate(healthElements: Array<HealthElement>): Promise<Array<EncryptedHealthElement>>;

	matchHealthElementsBy(filter: FilterOptions<HealthElement>): Promise<Array<string>>;

	matchHealthElementsBySorted(filter: SortableFilterOptions<HealthElement>): Promise<Array<string>>;

	deleteHealthElementById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deleteHealthElementsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgeHealthElementById(id: string, rev: string): Promise<void>;

	purgeHealthElementsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	deleteHealthElement(healthElement: HealthElement): Promise<StoredDocumentIdentifier>;

	deleteHealthElements(healthElements: Array<HealthElement>): Promise<Array<StoredDocumentIdentifier>>;

	purgeHealthElement(healthElement: HealthElement): Promise<void>;

	purgeHealthElements(healthElements: Array<HealthElement>): Promise<Array<StoredDocumentIdentifier>>;

	shareWith(delegateId: string, healthElement: DecryptedHealthElement,
			options?: { options?: HealthElementShareOptions | undefined }): Promise<DecryptedHealthElement>;

	shareWithMany(healthElement: DecryptedHealthElement,
			delegates: { [ key: string ]: HealthElementShareOptions }): Promise<DecryptedHealthElement>;

	filterHealthElementsBy(filter: FilterOptions<HealthElement>): Promise<PaginatedListIterator<DecryptedHealthElement>>;

	filterHealthElementsBySorted(filter: SortableFilterOptions<HealthElement>): Promise<PaginatedListIterator<DecryptedHealthElement>>;

	createHealthElement(entity: DecryptedHealthElement): Promise<DecryptedHealthElement>;

	createHealthElements(entities: Array<DecryptedHealthElement>): Promise<Array<DecryptedHealthElement>>;

	undeleteHealthElementById(id: string, rev: string): Promise<DecryptedHealthElement>;

	undeleteHealthElementsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<DecryptedHealthElement>>;

	undeleteHealthElement(healthElement: HealthElement): Promise<DecryptedHealthElement>;

	undeleteHealthElements(healthElements: Array<HealthElement>): Promise<Array<DecryptedHealthElement>>;

	modifyHealthElement(entity: DecryptedHealthElement): Promise<DecryptedHealthElement>;

	modifyHealthElements(entities: Array<DecryptedHealthElement>): Promise<Array<DecryptedHealthElement>>;

	getHealthElement(entityId: string): Promise<DecryptedHealthElement | undefined>;

	getHealthElements(entityIds: Array<string>): Promise<Array<DecryptedHealthElement>>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: FilterOptions<HealthElement>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedHealthElement>>;

}
