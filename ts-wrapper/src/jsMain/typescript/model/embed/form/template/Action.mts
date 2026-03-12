// auto-generated file
import {expectArray, expectObject, expectString, extractEntry} from '../../../../internal/JsonDecodeUtils.mjs';
import {Launcher} from './Launcher.mjs';
import {State} from './State.mjs';


/**
 *
 *  Represents an action in a form template, combining launchers, a conditional expression, and
 *  target states.
 *  /
 */
export class Action {

	/**
	 *
	 *  The list of launchers that can trigger this action.
	 */
	launchers: Array<Launcher> | undefined = [];

	/**
	 *
	 *  A conditional expression that determines when this action is executed.
	 */
	expression: string | undefined = undefined;

	/**
	 *
	 *  The list of states to apply when this action is triggered.
	 */
	states: Array<State> | undefined = [];

	constructor(partial: Partial<Action>) {
		if ('launchers' in partial) this.launchers = partial.launchers;
		if ('expression' in partial) this.expression = partial.expression;
		if ('states' in partial) this.states = partial.states;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.launchers != undefined) res['launchers'] = this.launchers.map((x0) => x0.toJSON() )
		if (this.expression != undefined) res['expression'] = this.expression
		if (this.states != undefined) res['states'] = this.states.map((x0) => x0.toJSON() )
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Action']): Action {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new Action({
			launchers: expectArray(extractEntry(jCpy, 'launchers', false, path), true, [...path, ".launchers"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Launcher.fromJSON)),
			expression: expectString(extractEntry(jCpy, 'expression', false, path), true, [...path, ".expression"]),
			states: expectArray(extractEntry(jCpy, 'states', false, path), true, [...path, ".states"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, State.fromJSON)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Action at path ${path.join("")}: ${unused}`)}
		return res
	}

}
