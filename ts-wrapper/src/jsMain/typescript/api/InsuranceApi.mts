// auto-generated file
import {Insurance} from '../model/Insurance.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';


export interface InsuranceApi {

	getInsurance(insuranceId: string): Promise<Insurance | undefined>;

	getInsurances(insuranceIds: Array<string>): Promise<Array<Insurance>>;

	createInsurance(insurance: Insurance): Promise<Insurance>;

	deleteInsurance(insuranceId: string): Promise<DocIdentifier>;

	getAllInsurances(options?: { startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<Insurance>>;

	listInsurancesByCode(insuranceCode: string): Promise<Array<Insurance>>;

	listInsurancesByName(insuranceName: string): Promise<Array<Insurance>>;

	modifyInsurance(insurance: Insurance): Promise<Insurance>;

	createInsurancesInGroup(groupId: string,
			insuranceBatch: Array<Insurance>): Promise<Array<Insurance>>;

	getInsurancesInGroup(groupId: string, insuranceIds: Array<string>): Promise<Array<Insurance>>;

	modifyInsurancesInGroup(groupId: string,
			insuranceBatch: Array<Insurance>): Promise<Array<Insurance>>;

}
