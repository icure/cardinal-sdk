// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {HealthcareParty} from '../model/HealthcareParty.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface HealthcarePartyInGroupApi {

	createHealthcareParty(healthcareParty: GroupScoped<HealthcareParty>): Promise<GroupScoped<HealthcareParty>>;

	createHealthcareParties(healthcareParties: Array<GroupScoped<HealthcareParty>>): Promise<Array<GroupScoped<HealthcareParty>>>;

	getHealthcareParty(groupId: string,
			healthcarePartyId: string): Promise<GroupScoped<HealthcareParty> | undefined>;

	getHealthcareParties(groupId: string,
			healthcarePartiesIds: Array<string>): Promise<Array<GroupScoped<HealthcareParty>>>;

	modifyHealthcareParty(healthcareParty: GroupScoped<HealthcareParty>): Promise<GroupScoped<HealthcareParty>>;

	modifyHealthcareParties(healthcareParties: Array<GroupScoped<HealthcareParty>>): Promise<Array<GroupScoped<HealthcareParty>>>;

	deleteHealthcarePartyById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteHealthcarePartyByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	deleteHealthcareParty(healthcareParty: GroupScoped<HealthcareParty>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteHealthcareParties(healthcareParties: Array<GroupScoped<HealthcareParty>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	undeleteHealthcarePartyById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<HealthcareParty>>;

	undeleteHealthcarePartyByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<HealthcareParty>>>;

	undeleteHealthcareParty(healthcareParty: GroupScoped<HealthcareParty>): Promise<GroupScoped<HealthcareParty>>;

	undeleteHealthcareParties(healthcareParties: Array<GroupScoped<HealthcareParty>>): Promise<Array<GroupScoped<HealthcareParty>>>;

	purgeHealthcarePartyById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	purgeHealthcarePartyByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeHealthcareParty(healthcareParty: GroupScoped<HealthcareParty>): Promise<void>;

	purgeHealthcareParties(healthcareParties: Array<GroupScoped<HealthcareParty>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	matchHealthcarePartiesBy(groupId: string,
			filter: BaseFilterOptions<HealthcareParty>): Promise<Array<string>>;

	matchHealthcarePartiesBySorted(groupId: string,
			filter: BaseSortableFilterOptions<HealthcareParty>): Promise<Array<string>>;

	filterHealthPartiesBy(groupId: string,
			filter: BaseFilterOptions<HealthcareParty>): Promise<PaginatedListIterator<GroupScoped<HealthcareParty>>>;

	filterHealthPartiesBySorted(groupId: string,
			filter: BaseSortableFilterOptions<HealthcareParty>): Promise<PaginatedListIterator<GroupScoped<HealthcareParty>>>;

}
