// auto-generated file
import {expectObject, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {Device} from './Device.mjs';
import {HealthcareParty} from './HealthcareParty.mjs';
import {EncryptedPatient} from './Patient.mjs';


export type DataOwnerWithType = DataOwnerWithType.HcpDataOwner | DataOwnerWithType.PatientDataOwner | DataOwnerWithType.DeviceDataOwner;

export namespace DataOwnerWithType {

	export class HcpDataOwner {

		dataOwner: HealthcareParty;

		readonly $ktClass: 'com.icure.cardinal.sdk.model.DataOwnerWithType.HcpDataOwner' = 'com.icure.cardinal.sdk.model.DataOwnerWithType.HcpDataOwner';

		constructor(partial: Partial<HcpDataOwner> & Pick<HcpDataOwner, "dataOwner">) {
			this.dataOwner = partial.dataOwner;
		}

		toJSON(): any {
			const res: { [k: string]: any } = {}
			res['dataOwner'] = this.dataOwner.toJSON()
			return res
		}

		static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
				path: Array<string> = ['HcpDataOwner']): HcpDataOwner {
			if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
			const jCpy = { ...json }
			const res = new HcpDataOwner({
				dataOwner: expectObject(extractEntry(jCpy.dataOwner, 'dataOwner', true, path), false, ignoreUnknownKeys, [...path, ".dataOwner"], HealthcareParty.fromJSON),
			})
			if (!ignoreUnknownKeys) {
				const unused = Object.keys(jCpy)
				if (unused.length > 0) throw new Error(`Unexpected key(s) for json object HcpDataOwner at path ${path.join("")}: ${unused}`)}
			return res
		}

	}

	export class PatientDataOwner {

		dataOwner: EncryptedPatient;

		readonly $ktClass: 'com.icure.cardinal.sdk.model.DataOwnerWithType.PatientDataOwner' = 'com.icure.cardinal.sdk.model.DataOwnerWithType.PatientDataOwner';

		constructor(partial: Partial<PatientDataOwner> & Pick<PatientDataOwner, "dataOwner">) {
			this.dataOwner = partial.dataOwner;
		}

		toJSON(): any {
			const res: { [k: string]: any } = {}
			res['dataOwner'] = this.dataOwner.toJSON()
			return res
		}

		static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
				path: Array<string> = ['PatientDataOwner']): PatientDataOwner {
			if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
			const jCpy = { ...json }
			const res = new PatientDataOwner({
				dataOwner: expectObject(extractEntry(jCpy.dataOwner, 'dataOwner', true, path), false, ignoreUnknownKeys, [...path, ".dataOwner"], EncryptedPatient.fromJSON),
			})
			if (!ignoreUnknownKeys) {
				const unused = Object.keys(jCpy)
				if (unused.length > 0) throw new Error(`Unexpected key(s) for json object PatientDataOwner at path ${path.join("")}: ${unused}`)}
			return res
		}

	}

	export class DeviceDataOwner {

		dataOwner: Device;

		readonly $ktClass: 'com.icure.cardinal.sdk.model.DataOwnerWithType.DeviceDataOwner' = 'com.icure.cardinal.sdk.model.DataOwnerWithType.DeviceDataOwner';

		constructor(partial: Partial<DeviceDataOwner> & Pick<DeviceDataOwner, "dataOwner">) {
			this.dataOwner = partial.dataOwner;
		}

		toJSON(): any {
			const res: { [k: string]: any } = {}
			res['dataOwner'] = this.dataOwner.toJSON()
			return res
		}

		static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
				path: Array<string> = ['DeviceDataOwner']): DeviceDataOwner {
			if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
			const jCpy = { ...json }
			const res = new DeviceDataOwner({
				dataOwner: expectObject(extractEntry(jCpy.dataOwner, 'dataOwner', true, path), false, ignoreUnknownKeys, [...path, ".dataOwner"], Device.fromJSON),
			})
			if (!ignoreUnknownKeys) {
				const unused = Object.keys(jCpy)
				if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DeviceDataOwner at path ${path.join("")}: ${unused}`)}
			return res
		}

	}

	export function fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DataOwnerWithType']): DataOwnerWithType {
		switch ((json as DataOwnerWithType).$ktClass) {
			case 'com.icure.cardinal.sdk.model.DataOwnerWithType.HcpDataOwner': return HcpDataOwner.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.DataOwnerWithType.PatientDataOwner': return PatientDataOwner.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.DataOwnerWithType.DeviceDataOwner': return DeviceDataOwner.fromJSON(json, ignoreUnknownKeys)
			default: throw new Error('Unexpected discriminator for DataOwnerWithType: ' + json.$ktClass)
		}
	}

}
