// auto-generated file
import {expectString} from '../../internal/JsonDecodeUtils.mjs';


export class ServiceLink {

	serviceId: string | undefined = undefined;

	constructor(partial: Partial<ServiceLink>) {
		if ('serviceId' in partial) this.serviceId = partial.serviceId;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.serviceId != undefined) res['serviceId'] = this.serviceId
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['ServiceLink']): ServiceLink {
		return new ServiceLink({
			serviceId: expectString(json.serviceId, true, [...path, ".serviceId"]),
		})
	}

}
