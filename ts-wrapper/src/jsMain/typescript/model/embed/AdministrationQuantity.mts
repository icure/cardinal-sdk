// auto-generated file
import {expectNumber, expectObject, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {CodeStub} from '../base/CodeStub.mjs';


export class AdministrationQuantity {

	quantity: number | undefined = undefined;

	administrationUnit: CodeStub | undefined = undefined;

	unit: string | undefined = undefined;

	constructor(partial: Partial<AdministrationQuantity>) {
		if ('quantity' in partial) this.quantity = partial.quantity;
		if ('administrationUnit' in partial) this.administrationUnit = partial.administrationUnit;
		if ('unit' in partial) this.unit = partial.unit;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.quantity != undefined) res['quantity'] = this.quantity
		if (this.administrationUnit != undefined) res['administrationUnit'] = this.administrationUnit.toJSON()
		if (this.unit != undefined) res['unit'] = this.unit
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['AdministrationQuantity']): AdministrationQuantity {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new AdministrationQuantity({
			quantity: expectNumber(extractEntry(jCpy, 'quantity', false, path), true, false, [...path, ".quantity"]),
			administrationUnit: expectObject(extractEntry(jCpy, 'administrationUnit', false, path), true, ignoreUnknownKeys, [...path, ".administrationUnit"], CodeStub.fromJSON),
			unit: expectString(extractEntry(jCpy, 'unit', false, path), true, [...path, ".unit"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object AdministrationQuantity at path ${path.join("")}: ${unused}`)}
		return res
	}

}
