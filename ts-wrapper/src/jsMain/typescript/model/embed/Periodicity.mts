// auto-generated file
import {expectObject, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {CodeStub} from '../base/CodeStub.mjs';


/**
 *
 *  Represents a periodicity linking a code to its related periodicity code, used in medication regimens.
 *  /
 */
export class Periodicity {

	/**
	 *
	 *  The code associated with this periodicity.
	 */
	relatedCode: CodeStub | undefined = undefined;

	/**
	 *
	 *  The periodicity code defining the recurrence pattern.
	 */
	relatedPeriodicity: CodeStub | undefined = undefined;

	constructor(partial: Partial<Periodicity>) {
		if ('relatedCode' in partial) this.relatedCode = partial.relatedCode;
		if ('relatedPeriodicity' in partial) this.relatedPeriodicity = partial.relatedPeriodicity;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.relatedCode != undefined) res['relatedCode'] = this.relatedCode.toJSON()
		if (this.relatedPeriodicity != undefined) res['relatedPeriodicity'] = this.relatedPeriodicity.toJSON()
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Periodicity']): Periodicity {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new Periodicity({
			relatedCode: expectObject(extractEntry(jCpy, 'relatedCode', false, path), true, ignoreUnknownKeys, [...path, ".relatedCode"], CodeStub.fromJSON),
			relatedPeriodicity: expectObject(extractEntry(jCpy, 'relatedPeriodicity', false, path), true, ignoreUnknownKeys, [...path, ".relatedPeriodicity"], CodeStub.fromJSON),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Periodicity at path ${path.join("")}: ${unused}`)}
		return res
	}

}
