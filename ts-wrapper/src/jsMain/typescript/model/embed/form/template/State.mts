// auto-generated file
import {expectBoolean, expectString, expectStringEnum, requireEntry} from '../../../../internal/JsonDecodeUtils.mjs';
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

	static fromJSON(json: any, path: Array<string> = ['State']): State {
		return new State({
			name: expectString(requireEntry(json.name, 'name', path), false, [...path, ".name"]),
			stateToUpdate: expectStringEnum(requireEntry(json.stateToUpdate, 'stateToUpdate', path), false, [...path, ".stateToUpdate"], StateToUpdate, 'StateToUpdate'),
			canLaunchLauncher: expectBoolean(json.canLaunchLauncher, false, [...path, ".canLaunchLauncher"]),
		})
	}

}
