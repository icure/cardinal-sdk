// auto-generated file
import {expectArray, expectString} from '../../internal/JsonDecodeUtils.mjs';
import {CodeStub} from '../base/CodeStub.mjs';


export class Medicinalproduct {

	intendedcds: Array<CodeStub> = [];

	deliveredcds: Array<CodeStub> = [];

	intendedname: string | undefined = undefined;

	deliveredname: string | undefined = undefined;

	productId: string | undefined = undefined;

	constructor(partial: Partial<Medicinalproduct>) {
		if ('intendedcds' in partial && partial.intendedcds !== undefined) this.intendedcds = partial.intendedcds;
		if ('deliveredcds' in partial && partial.deliveredcds !== undefined) this.deliveredcds = partial.deliveredcds;
		if ('intendedname' in partial) this.intendedname = partial.intendedname;
		if ('deliveredname' in partial) this.deliveredname = partial.deliveredname;
		if ('productId' in partial) this.productId = partial.productId;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['intendedcds'] = this.intendedcds.map((x0) => x0.toJSON() )
		res['deliveredcds'] = this.deliveredcds.map((x0) => x0.toJSON() )
		if (this.intendedname != undefined) res['intendedname'] = this.intendedname
		if (this.deliveredname != undefined) res['deliveredname'] = this.deliveredname
		if (this.productId != undefined) res['productId'] = this.productId
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['Medicinalproduct']): Medicinalproduct {
		return new Medicinalproduct({
			intendedcds: expectArray(json.intendedcds, false, [...path, ".intendedcds"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			deliveredcds: expectArray(json.deliveredcds, false, [...path, ".deliveredcds"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			intendedname: expectString(json.intendedname, true, [...path, ".intendedname"]),
			deliveredname: expectString(json.deliveredname, true, [...path, ".deliveredname"]),
			productId: expectString(json.productId, true, [...path, ".productId"]),
		})
	}

}
