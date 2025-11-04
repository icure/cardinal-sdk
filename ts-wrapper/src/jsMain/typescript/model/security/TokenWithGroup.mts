// auto-generated file
import {expectString, requireEntry} from '../../internal/JsonDecodeUtils.mjs';


export class TokenWithGroup {

	token: string;

	groupId: string;

	groupName: string | undefined = undefined;

	constructor(partial: Partial<TokenWithGroup> & Pick<TokenWithGroup, "token" | "groupId">) {
		this.token = partial.token;
		this.groupId = partial.groupId;
		if ('groupName' in partial) this.groupName = partial.groupName;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['token'] = this.token
		res['groupId'] = this.groupId
		if (this.groupName != undefined) res['groupName'] = this.groupName
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['TokenWithGroup']): TokenWithGroup {
		return new TokenWithGroup({
			token: expectString(requireEntry(json.token, 'token', path), false, [...path, ".token"]),
			groupId: expectString(requireEntry(json.groupId, 'groupId', path), false, [...path, ".groupId"]),
			groupName: expectString(json.groupName, true, [...path, ".groupName"]),
		})
	}

}
