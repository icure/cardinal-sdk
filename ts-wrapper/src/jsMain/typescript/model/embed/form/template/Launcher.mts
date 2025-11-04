// auto-generated file
import {expectBoolean, expectString, expectStringEnum, extractEntry} from '../../../../internal/JsonDecodeUtils.mjs';
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

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Launcher']): Launcher {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new Launcher({
			name: expectString(extractEntry(jCpy.name, 'name', true, path), false, [...path, ".name"]),
			triggerer: expectStringEnum(extractEntry(jCpy.triggerer, 'triggerer', true, path), false, [...path, ".triggerer"], Trigger, 'Trigger'),
			shouldPassValue: expectBoolean(extractEntry(jCpy.shouldPassValue, 'shouldPassValue', false, path), false, [...path, ".shouldPassValue"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Launcher at path ${path.join("")}: ${unused}`)}
		return res
	}

}
