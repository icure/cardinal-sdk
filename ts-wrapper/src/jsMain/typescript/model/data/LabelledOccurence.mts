// auto-generated file
import {expectNumber, expectString, requireEntry} from '../../internal/JsonDecodeUtils.mjs';


export class LabelledOccurence {

	label: string;

	occurence: number;

	constructor(partial: Partial<LabelledOccurence> & Pick<LabelledOccurence, "label" | "occurence">) {
		this.label = partial.label;
		this.occurence = partial.occurence;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['label'] = this.label
		res['occurence'] = this.occurence
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['LabelledOccurence']): LabelledOccurence {
		return new LabelledOccurence({
			label: expectString(requireEntry(json.label, 'label', path), false, [...path, ".label"]),
			occurence: expectNumber(requireEntry(json.occurence, 'occurence', path), false, true, [...path, ".occurence"]),
		})
	}

}
