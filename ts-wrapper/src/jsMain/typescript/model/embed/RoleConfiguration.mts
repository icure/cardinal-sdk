// auto-generated file
import {expectArray, expectString, expectStringEnum, requireEntry} from '../../internal/JsonDecodeUtils.mjs';


export class RoleConfiguration {

	source: RoleConfiguration.Source;

	roles: Array<string> = [];

	constructor(partial: Partial<RoleConfiguration> & Pick<RoleConfiguration, "source">) {
		this.source = partial.source;
		if ('roles' in partial && partial.roles !== undefined) this.roles = partial.roles;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['source'] = this.source
		res['roles'] = this.roles.map((x0) => x0 )
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['RoleConfiguration']): RoleConfiguration {
		return new RoleConfiguration({
			source: expectStringEnum(requireEntry(json.source, 'source', path), false, [...path, ".source"], RoleConfiguration.Source, 'RoleConfiguration.Source'),
			roles: expectArray(json.roles, false, [...path, ".roles"], (x0, p0) => expectString(x0, false, p0)),
		})
	}

}

export namespace RoleConfiguration {

	export enum Source {
		Configuration = "Configuration",
		Inherited = "Inherited",
		Default = "Default"
	}

}
