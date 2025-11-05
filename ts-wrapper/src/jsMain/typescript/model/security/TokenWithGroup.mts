// auto-generated file
import {expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


export class TokenWithGroup {

	token: string;

	groupId: string;

	groupName: string | undefined = undefined;

	constructor(partial: Partial<TokenWithGroup> & Pick<TokenWithGroup, "token" | "groupId">) {
		this.token = partial.token;
		this.groupId = partial.groupId;
		if ('groupName' in partial) this.groupName = partial.groupName;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['token'] = this.token
		res['groupId'] = this.groupId
		if (this.groupName != undefined) res['groupName'] = this.groupName
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['TokenWithGroup']): TokenWithGroup {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new TokenWithGroup({
			token: expectString(extractEntry(jCpy, 'token', true, path), false, [...path, ".token"]),
			groupId: expectString(extractEntry(jCpy, 'groupId', true, path), false, [...path, ".groupId"]),
			groupName: expectString(extractEntry(jCpy, 'groupName', false, path), true, [...path, ".groupName"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object TokenWithGroup at path ${path.join("")}: ${unused}`)}
		return res
	}

}
