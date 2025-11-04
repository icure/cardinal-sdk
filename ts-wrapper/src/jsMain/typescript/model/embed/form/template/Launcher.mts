// auto-generated file
import {expectBoolean, expectString, expectStringEnum, requireEntry} from '../../../../internal/JsonDecodeUtils.mjs';
import {Trigger} from './Trigger.mjs';


export class Launcher {

	name: string;

	triggerer: Trigger;

	shouldPassValue: boolean = false;

	constructor(partial: Partial<Launcher> & Pick<Launcher, "name" | "triggerer">) {
		this.name = partial.name;
		this.triggerer = partial.triggerer;
		if ('shouldPassValue' in partial && partial.shouldPassValue !== undefined) this.shouldPassValue = partial.shouldPassValue;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['name'] = this.name
		res['triggerer'] = this.triggerer
		res['shouldPassValue'] = this.shouldPassValue
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['Launcher']): Launcher {
		return new Launcher({
			name: expectString(requireEntry(json.name, 'name', path), false, [...path, ".name"]),
			triggerer: expectStringEnum(requireEntry(json.triggerer, 'triggerer', path), false, [...path, ".triggerer"], Trigger, 'Trigger'),
			shouldPassValue: expectBoolean(json.shouldPassValue, false, [...path, ".shouldPassValue"]),
		})
	}

}
