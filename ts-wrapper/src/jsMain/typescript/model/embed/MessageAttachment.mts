// auto-generated file
import {expectArray, expectString, expectStringEnum} from '../../internal/JsonDecodeUtils.mjs';
import {DocumentLocation} from './DocumentLocation.mjs';


export class MessageAttachment {

	type: DocumentLocation | undefined = undefined;

	ids: Array<string> = [];

	constructor(partial: Partial<MessageAttachment>) {
		if ('type' in partial) this.type = partial.type;
		if ('ids' in partial && partial.ids !== undefined) this.ids = partial.ids;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.type != undefined) res['type'] = this.type
		res['ids'] = this.ids.map((x0) => x0 )
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['MessageAttachment']): MessageAttachment {
		return new MessageAttachment({
			type: expectStringEnum(json.type, true, [...path, ".type"], DocumentLocation, 'DocumentLocation'),
			ids: expectArray(json.ids, false, [...path, ".ids"], (x0, p0) => expectString(x0, false, p0)),
		})
	}

}
