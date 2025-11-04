// auto-generated file
import {expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


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

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['ServiceLink']): ServiceLink {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new ServiceLink({
			serviceId: expectString(extractEntry(jCpy.serviceId, 'serviceId', false, path), true, [...path, ".serviceId"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object ServiceLink at path ${path.join("")}: ${unused}`)}
		return res
	}

}
