// auto-generated file
import {expectNumber, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


/**
 *
 *  Data transfer object representing a labelled occurrence count, typically used for aggregation
 *  results.
 *  /
 */
export class LabelledOccurence {

	/**
	 *
	 *  The label identifying what is being counted.
	 */
	label: string;

	/**
	 *
	 *  The number of occurrences for this label.
	 */
	occurence: number;

	constructor(partial: Partial<LabelledOccurence> & Pick<LabelledOccurence, "label" | "occurence">) {
		this.label = partial.label;
		this.occurence = partial.occurence;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['label'] = this.label
		res['occurence'] = this.occurence
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['LabelledOccurence']): LabelledOccurence {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new LabelledOccurence({
			label: expectString(extractEntry(jCpy, 'label', true, path), false, [...path, ".label"]),
			occurence: expectNumber(extractEntry(jCpy, 'occurence', true, path), false, true, [...path, ".occurence"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object LabelledOccurence at path ${path.join("")}: ${unused}`)}
		return res
	}

}
