// auto-generated file
import {expectBoolean, expectNumber, expectString, expectStringEnum, requireEntry} from '../../internal/JsonDecodeUtils.mjs';
import {HealthcarePartyStatus} from './HealthcarePartyStatus.mjs';


export class HealthcarePartyHistoryStatus {

	status: HealthcarePartyStatus;

	specialisationCode: string;

	startDate: number;

	active: boolean;

	constructor(partial: Partial<HealthcarePartyHistoryStatus> & Pick<HealthcarePartyHistoryStatus, "status" | "specialisationCode" | "startDate" | "active">) {
		this.status = partial.status;
		this.specialisationCode = partial.specialisationCode;
		this.startDate = partial.startDate;
		this.active = partial.active;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['status'] = this.status
		res['specialisationCode'] = this.specialisationCode
		res['startDate'] = this.startDate
		res['active'] = this.active
		return res
	}

	static fromJSON(json: any,
			path: Array<string> = ['HealthcarePartyHistoryStatus']): HealthcarePartyHistoryStatus {
		return new HealthcarePartyHistoryStatus({
			status: expectStringEnum(requireEntry(json.status, 'status', path), false, [...path, ".status"], HealthcarePartyStatus, 'HealthcarePartyStatus'),
			specialisationCode: expectString(requireEntry(json.specialisationCode, 'specialisationCode', path), false, [...path, ".specialisationCode"]),
			startDate: expectNumber(requireEntry(json.startDate, 'startDate', path), false, true, [...path, ".startDate"]),
			active: expectBoolean(requireEntry(json.active, 'active', path), false, [...path, ".active"]),
		})
	}

}
