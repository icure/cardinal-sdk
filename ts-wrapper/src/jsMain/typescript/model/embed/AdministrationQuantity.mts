// auto-generated file
import {expectNumber, expectString} from '../../internal/JsonDecodeUtils.mjs';
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

	static fromJSON(json: any,
			path: Array<string> = ['AdministrationQuantity']): AdministrationQuantity {
		return new AdministrationQuantity({
			quantity: expectNumber(json.quantity, true, false, [...path, ".quantity"]),
			administrationUnit: CodeStub.fromJSON(json.administrationUnit, [...path, ".administrationUnit"]),
			unit: expectString(json.unit, true, [...path, ".unit"]),
		})
	}

}
