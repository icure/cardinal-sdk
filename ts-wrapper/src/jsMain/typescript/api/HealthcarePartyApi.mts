// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {DataOwnerRegistrationSuccess} from '../model/DataOwnerRegistrationSuccess.mjs';
import {HealthcareParty} from '../model/HealthcareParty.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {PublicKey} from '../model/PublicKey.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';
import {HealthcarePartyApiInGroup} from './HealthcarePartyApiInGroup.mjs';


export interface HealthcarePartyApi {

	inGroup: HealthcarePartyApiInGroup;

	deleteHealthcarePartyUnsafe(entityId: string): Promise<DocIdentifier>;

	deleteHealthcarePartiesUnsafe(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	getHealthcareParty(healthcarePartyId: string): Promise<HealthcareParty | undefined>;

	createHealthcareParty(p: HealthcareParty): Promise<HealthcareParty>;

	modifyHealthcarePartyInGroup(groupId: string,
			healthcareParty: HealthcareParty): Promise<HealthcareParty>;

	createHealthcarePartyInGroup(groupId: string,
			healthcareParty: HealthcareParty): Promise<HealthcareParty>;

	getCurrentHealthcareParty(): Promise<HealthcareParty>;

	findHealthcarePartiesBy(options?: { startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, desc?: boolean | undefined }): Promise<PaginatedList<HealthcareParty>>;

	findHealthcarePartiesByName(options?: { name?: string | undefined, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, desc?: boolean | undefined }): Promise<PaginatedList<HealthcareParty>>;

	findHealthcarePartiesBySsinOrNihii(searchValue: string,
			options?: { startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, desc?: boolean }): Promise<PaginatedList<HealthcareParty>>;

	listHealthcarePartiesByName(name: string): Promise<Array<HealthcareParty>>;

	findHealthcarePartiesBySpecialityAndPostCode(
			type: string,
			spec: string,
			firstCode: string,
			lastCode: string,
			options?: { startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined }
	): Promise<PaginatedList<HealthcareParty>>;

	getHealthcareParties(healthcarePartyIds: Array<string>): Promise<Array<HealthcareParty>>;

	listHealthcarePartiesByParentId(parentId: string): Promise<Array<HealthcareParty>>;

	getPublicKey(healthcarePartyId: string): Promise<PublicKey>;

	modifyHealthcareParty(healthcareParty: HealthcareParty): Promise<HealthcareParty>;

	matchHealthcarePartiesBy(filter: BaseFilterOptions<HealthcareParty>): Promise<Array<string>>;

	filterHealthPartiesBy(filter: BaseFilterOptions<HealthcareParty>): Promise<PaginatedListIterator<HealthcareParty>>;

	matchHealthcarePartiesBySorted(filter: BaseSortableFilterOptions<HealthcareParty>): Promise<Array<string>>;

	filterHealthPartiesBySorted(filter: BaseSortableFilterOptions<HealthcareParty>): Promise<PaginatedListIterator<HealthcareParty>>;

	getHealthcarePartiesInGroup(groupId: string,
			options?: { healthcarePartyIds?: Array<string> | undefined }): Promise<Array<HealthcareParty>>;

	registerPatient(groupId: string, hcp: HealthcareParty,
			options?: { parentHcPartyId?: string | undefined, token?: string | undefined, useShortToken?: boolean | undefined }): Promise<DataOwnerRegistrationSuccess>;

	deleteHealthcarePartyById(entityId: string, rev: string): Promise<DocIdentifier>;

	deleteHealthcarePartiesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<DocIdentifier>>;

	deleteHealthcarePartyInGroupById(groupId: string, entityId: string,
			rev: string): Promise<DocIdentifier>;

	deleteHealthcarePartiesInGroupByIds(groupId: string,
			entityIds: Array<StoredDocumentIdentifier>): Promise<Array<DocIdentifier>>;

	purgeHealthcarePartyById(id: string, rev: string): Promise<void>;

	undeleteHealthcarePartyById(id: string, rev: string): Promise<HealthcareParty>;

	deleteHealthcareParty(healthcareParty: HealthcareParty): Promise<DocIdentifier>;

	deleteHealthcareParties(healthcareParties: Array<HealthcareParty>): Promise<Array<DocIdentifier>>;

	purgeHealthcareParty(healthcareParty: HealthcareParty): Promise<void>;

	undeleteHealthcareParty(healthcareParty: HealthcareParty): Promise<HealthcareParty>;

	deleteHealthcarePartyInGroup(groupId: string, hcp: HealthcareParty): Promise<DocIdentifier>;

	deleteHealthcarePartiesInGroup(groupId: string,
			healthcareParties: Array<HealthcareParty>): Promise<Array<DocIdentifier>>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: FilterOptions<HealthcareParty>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<HealthcareParty>>;

}
