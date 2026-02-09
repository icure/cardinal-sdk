// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {DataOwnerRegistrationSuccess} from '../model/DataOwnerRegistrationSuccess.mjs';
import {HealthcareParty} from '../model/HealthcareParty.mjs';
import {PublicKey} from '../model/PublicKey.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';
import {HealthcarePartyInGroupApi} from './HealthcarePartyInGroupApi.mjs';


export interface HealthcarePartyApi {

	inGroup: HealthcarePartyInGroupApi;

	getHealthcareParty(healthcarePartyId: string): Promise<HealthcareParty | undefined>;

	getHealthcareParties(healthcarePartyIds: Array<string>): Promise<Array<HealthcareParty>>;

	createHealthcareParty(healthcareParty: HealthcareParty): Promise<HealthcareParty>;

	createHealthcareParties(healthcareParties: Array<HealthcareParty>): Promise<Array<HealthcareParty>>;

	modifyHealthcareParty(healthcareParty: HealthcareParty): Promise<HealthcareParty>;

	modifyHealthcareParties(healthcareParties: Array<HealthcareParty>): Promise<Array<HealthcareParty>>;

	getCurrentHealthcareParty(): Promise<HealthcareParty>;

	getPublicKey(healthcarePartyId: string): Promise<PublicKey>;

	matchHealthcarePartiesBy(filter: BaseFilterOptions<HealthcareParty>): Promise<Array<string>>;

	filterHealthPartiesBy(filter: BaseFilterOptions<HealthcareParty>): Promise<PaginatedListIterator<HealthcareParty>>;

	matchHealthcarePartiesBySorted(filter: BaseSortableFilterOptions<HealthcareParty>): Promise<Array<string>>;

	filterHealthPartiesBySorted(filter: BaseSortableFilterOptions<HealthcareParty>): Promise<PaginatedListIterator<HealthcareParty>>;

	registerPatient(groupId: string, hcp: HealthcareParty,
			options?: { parentHcPartyId?: string | undefined, token?: string | undefined, useShortToken?: boolean | undefined }): Promise<DataOwnerRegistrationSuccess>;

	deleteHealthcarePartyById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deleteHealthcarePartiesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgeHealthcarePartyById(id: string, rev: string): Promise<void>;

	purgeHealthcarePartiesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	undeleteHealthcarePartyById(id: string, rev: string): Promise<HealthcareParty>;

	undeleteHealthcarePartiesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<HealthcareParty>>;

	deleteHealthcareParty(healthcareParty: HealthcareParty): Promise<StoredDocumentIdentifier>;

	deleteHealthcareParties(healthcareParties: Array<HealthcareParty>): Promise<Array<StoredDocumentIdentifier>>;

	purgeHealthcareParty(healthcareParty: HealthcareParty): Promise<void>;

	purgeHealthcareParties(healthcareParties: Array<HealthcareParty>): Promise<Array<StoredDocumentIdentifier>>;

	undeleteHealthcareParty(healthcareParty: HealthcareParty): Promise<HealthcareParty>;

	undeleteHealthcareParties(healthcareParties: Array<HealthcareParty>): Promise<Array<HealthcareParty>>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: FilterOptions<HealthcareParty>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<HealthcareParty>>;

}
