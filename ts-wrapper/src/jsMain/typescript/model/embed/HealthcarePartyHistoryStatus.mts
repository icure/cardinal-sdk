// auto-generated file
import {expectBoolean, expectNumber, expectString, expectStringEnum, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
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

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['HealthcarePartyHistoryStatus']): HealthcarePartyHistoryStatus {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new HealthcarePartyHistoryStatus({
			status: expectStringEnum(extractEntry(jCpy.status, 'status', true, path), false, [...path, ".status"], HealthcarePartyStatus, 'HealthcarePartyStatus'),
			specialisationCode: expectString(extractEntry(jCpy.specialisationCode, 'specialisationCode', true, path), false, [...path, ".specialisationCode"]),
			startDate: expectNumber(extractEntry(jCpy.startDate, 'startDate', true, path), false, true, [...path, ".startDate"]),
			active: expectBoolean(extractEntry(jCpy.active, 'active', true, path), false, [...path, ".active"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object HealthcarePartyHistoryStatus at path ${path.join("")}: ${unused}`)}
		return res
	}

}
