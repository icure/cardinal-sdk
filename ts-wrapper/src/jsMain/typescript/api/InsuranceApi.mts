// auto-generated file
import {Insurance} from '../model/Insurance.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {InsuranceInGroupApi} from './InsuranceInGroupApi.mjs';


export interface InsuranceApi {

	inGroup: InsuranceInGroupApi;

	createInsurance(insurance: Insurance): Promise<Insurance>;

	createInsurances(insurances: Array<Insurance>): Promise<Array<Insurance>>;

	getInsurance(insuranceId: string): Promise<Insurance | undefined>;

	getInsurances(insurancesIds: Array<string>): Promise<Array<Insurance>>;

	modifyInsurance(insurance: Insurance): Promise<Insurance>;

	modifyInsurances(insurances: Array<Insurance>): Promise<Array<Insurance>>;

	deleteInsuranceById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deleteInsuranceByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	deleteInsurance(insurance: Insurance): Promise<StoredDocumentIdentifier>;

	deleteInsurances(insurances: Array<Insurance>): Promise<Array<StoredDocumentIdentifier>>;

	undeleteInsuranceById(entityId: string, rev: string): Promise<Insurance>;

	undeleteInsuranceByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<Insurance>>;

	undeleteInsurance(insurance: Insurance): Promise<Insurance>;

	undeleteInsurances(insurances: Array<Insurance>): Promise<Array<Insurance>>;

	purgeInsuranceById(entityId: string, rev: string): Promise<void>;

	purgeInsuranceByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgeInsurance(insurance: Insurance): Promise<void>;

	purgeInsurances(insurances: Array<Insurance>): Promise<Array<StoredDocumentIdentifier>>;

	listInsurancesByCode(insuranceCode: string): Promise<Array<Insurance>>;

	listInsurancesByName(insuranceName: string): Promise<Array<Insurance>>;

}
