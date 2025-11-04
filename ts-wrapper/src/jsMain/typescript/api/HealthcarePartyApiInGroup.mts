// auto-generated file
import {BaseFilterOptions} from '../cardinal-sdk-ts.mjs';
import {HealthcareParty} from '../model/HealthcareParty.mjs';


export interface HealthcarePartyApiInGroup {

	matchHealthcarePartiesBy(groupId: string,
			filter: BaseFilterOptions<HealthcareParty>): Promise<Array<string>>;

}
