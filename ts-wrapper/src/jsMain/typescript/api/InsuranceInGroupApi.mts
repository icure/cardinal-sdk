// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {Insurance} from '../model/Insurance.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface InsuranceInGroupApi {

	createInsurance(insurance: GroupScoped<Insurance>): Promise<GroupScoped<Insurance>>;

	createInsurances(insurances: Array<GroupScoped<Insurance>>): Promise<Array<GroupScoped<Insurance>>>;

	getInsurance(groupId: string, insuranceId: string): Promise<GroupScoped<Insurance> | undefined>;

	getInsurances(groupId: string,
			insurancesIds: Array<string>): Promise<Array<GroupScoped<Insurance>>>;

	modifyInsurance(insurance: GroupScoped<Insurance>): Promise<GroupScoped<Insurance>>;

	modifyInsurances(insurances: Array<GroupScoped<Insurance>>): Promise<Array<GroupScoped<Insurance>>>;

	deleteInsuranceById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteInsuranceByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	deleteInsurance(insurance: GroupScoped<Insurance>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteInsurances(insurances: Array<GroupScoped<Insurance>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	undeleteInsuranceById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<Insurance>>;

	undeleteInsuranceByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<Insurance>>>;

	undeleteInsurance(insurance: GroupScoped<Insurance>): Promise<GroupScoped<Insurance>>;

	undeleteInsurances(insurances: Array<GroupScoped<Insurance>>): Promise<Array<GroupScoped<Insurance>>>;

	purgeInsuranceById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	purgeInsuranceByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeInsurance(insurance: GroupScoped<Insurance>): Promise<void>;

	purgeInsurances(insurances: Array<GroupScoped<Insurance>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	matchInsurancesBy(groupId: string, filter: BaseFilterOptions<Insurance>): Promise<Array<string>>;

	matchInsurancesBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Insurance>): Promise<Array<string>>;

	filterInsurancesBy(groupId: string,
			filter: BaseFilterOptions<Insurance>): Promise<PaginatedListIterator<GroupScoped<Insurance>>>;

	filterInsurancesBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Insurance>): Promise<PaginatedListIterator<GroupScoped<Insurance>>>;

}
