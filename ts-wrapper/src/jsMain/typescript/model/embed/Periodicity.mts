// auto-generated file
import {CodeStub} from '../base/CodeStub.mjs';


export class Periodicity {

	relatedCode: CodeStub | undefined = undefined;

	relatedPeriodicity: CodeStub | undefined = undefined;

	constructor(partial: Partial<Periodicity>) {
		if ('relatedCode' in partial) this.relatedCode = partial.relatedCode;
		if ('relatedPeriodicity' in partial) this.relatedPeriodicity = partial.relatedPeriodicity;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.relatedCode != undefined) res['relatedCode'] = this.relatedCode.toJSON()
		if (this.relatedPeriodicity != undefined) res['relatedPeriodicity'] = this.relatedPeriodicity.toJSON()
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['Periodicity']): Periodicity {
		return new Periodicity({
			relatedCode: CodeStub.fromJSON(json.relatedCode, [...path, ".relatedCode"]),
			relatedPeriodicity: CodeStub.fromJSON(json.relatedPeriodicity, [...path, ".relatedPeriodicity"]),
		})
	}

}
