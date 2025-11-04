// auto-generated file
import {expectArray, expectString} from '../../../../internal/JsonDecodeUtils.mjs';
import {Launcher} from './Launcher.mjs';
import {State} from './State.mjs';


export class Action {

	launchers: Array<Launcher> | undefined = [];

	expression: string | undefined = undefined;

	states: Array<State> | undefined = [];

	constructor(partial: Partial<Action>) {
		if ('launchers' in partial) this.launchers = partial.launchers;
		if ('expression' in partial) this.expression = partial.expression;
		if ('states' in partial) this.states = partial.states;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.launchers != undefined) res['launchers'] = this.launchers.map((x0) => x0.toJSON() )
		if (this.expression != undefined) res['expression'] = this.expression
		if (this.states != undefined) res['states'] = this.states.map((x0) => x0.toJSON() )
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['Action']): Action {
		return new Action({
			launchers: expectArray(json.launchers, true, [...path, ".launchers"], (x0, p0) => Launcher.fromJSON(x0, p0)),
			expression: expectString(json.expression, true, [...path, ".expression"]),
			states: expectArray(json.states, true, [...path, ".states"], (x0, p0) => State.fromJSON(x0, p0)),
		})
	}

}
