// auto-generated file
import {expectBoolean, expectString, expectStringEnum, extractEntry} from '../../../../internal/JsonDecodeUtils.mjs';
import {StateToUpdate} from './StateToUpdate.mjs';


export class State {

	name: string;

	stateToUpdate: StateToUpdate;

	canLaunchLauncher: boolean = false;

	constructor(partial: Partial<State> & Pick<State, "name" | "stateToUpdate">) {
		this.name = partial.name;
		this.stateToUpdate = partial.stateToUpdate;
		if ('canLaunchLauncher' in partial && partial.canLaunchLauncher !== undefined) this.canLaunchLauncher = partial.canLaunchLauncher;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['name'] = this.name
		res['stateToUpdate'] = this.stateToUpdate
		res['canLaunchLauncher'] = this.canLaunchLauncher
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['State']): State {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new State({
			name: expectString(extractEntry(jCpy.name, 'name', true, path), false, [...path, ".name"]),
			stateToUpdate: expectStringEnum(extractEntry(jCpy.stateToUpdate, 'stateToUpdate', true, path), false, [...path, ".stateToUpdate"], StateToUpdate, 'StateToUpdate'),
			canLaunchLauncher: expectBoolean(extractEntry(jCpy.canLaunchLauncher, 'canLaunchLauncher', false, path), false, [...path, ".canLaunchLauncher"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object State at path ${path.join("")}: ${unused}`)}
		return res
	}

}
