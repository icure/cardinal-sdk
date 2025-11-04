// auto-generated file
import {expectArray} from '../internal/JsonDecodeUtils.mjs';
import {DecryptedPropertyStub} from './PropertyStub.mjs';


export class ListOfProperties {

	properties: Array<DecryptedPropertyStub> = [];

	constructor(partial: Partial<ListOfProperties>) {
		if ('properties' in partial && partial.properties !== undefined) this.properties = partial.properties;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['properties'] = this.properties.map((x0) => x0.toJSON() )
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['ListOfProperties']): ListOfProperties {
		return new ListOfProperties({
			properties: expectArray(json.properties, false, [...path, ".properties"], (x0, p0) => DecryptedPropertyStub.fromJSON(x0, p0)),
		})
	}

}
