// auto-generated file
import {requireEntry} from '../internal/JsonDecodeUtils.mjs';
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

		static fromJSON(json: any, path: Array<string> = ['HcpDataOwner']): HcpDataOwner {
			return new HcpDataOwner({
				dataOwner: HealthcareParty.fromJSON(requireEntry(json.dataOwner, 'dataOwner', path), [...path, ".dataOwner"]),
			})
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

		static fromJSON(json: any, path: Array<string> = ['PatientDataOwner']): PatientDataOwner {
			return new PatientDataOwner({
				dataOwner: EncryptedPatient.fromJSON(requireEntry(json.dataOwner, 'dataOwner', path), [...path, ".dataOwner"]),
			})
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

		static fromJSON(json: any, path: Array<string> = ['DeviceDataOwner']): DeviceDataOwner {
			return new DeviceDataOwner({
				dataOwner: Device.fromJSON(requireEntry(json.dataOwner, 'dataOwner', path), [...path, ".dataOwner"]),
			})
		}

	}

}
