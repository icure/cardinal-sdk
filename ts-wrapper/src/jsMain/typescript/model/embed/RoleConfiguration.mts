// auto-generated file
import {expectArray, expectString, expectStringEnum, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


export class RoleConfiguration {

	source: RoleConfiguration.Source;

	roles: Array<string> = [];

	constructor(partial: Partial<RoleConfiguration> & Pick<RoleConfiguration, "source">) {
		this.source = partial.source;
		if ('roles' in partial && partial.roles !== undefined) this.roles = partial.roles;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['source'] = this.source
		res['roles'] = this.roles.map((x0) => x0 )
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['RoleConfiguration']): RoleConfiguration {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new RoleConfiguration({
			source: expectStringEnum(extractEntry(jCpy, 'source', true, path), false, [...path, ".source"], RoleConfiguration.Source, 'RoleConfiguration.Source'),
			roles: expectArray(extractEntry(jCpy, 'roles', false, path), false, [...path, ".roles"], (x0, p0) => expectString(x0, false, p0)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object RoleConfiguration at path ${path.join("")}: ${unused}`)}
		return res
	}

}

export namespace RoleConfiguration {

	export enum Source {
		Configuration = "Configuration",
		Inherited = "Inherited",
		Default = "Default"
	}

}
