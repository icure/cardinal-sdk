// auto-generated file
import {expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


/**
 *
 *
 *   A link from a crypto actor to a data owner that represents a group it belongs to. The type of
 *  the link is not
 *   declared here: it is intrinsic to the linked data owner itself, see
 *  [CryptoActorDto.groupLinkType].
 */
export class DataOwnerGroupLink {

	/**
	 *
	 *  The id of the data owner representing the group.
	 */
	dataOwnerId: string;

	constructor(partial: Partial<DataOwnerGroupLink> & Pick<DataOwnerGroupLink, "dataOwnerId">) {
		this.dataOwnerId = partial.dataOwnerId;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['dataOwnerId'] = this.dataOwnerId
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DataOwnerGroupLink']): DataOwnerGroupLink {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new DataOwnerGroupLink({
			dataOwnerId: expectString(extractEntry(jCpy, 'dataOwnerId', true, path), false, [...path, ".dataOwnerId"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DataOwnerGroupLink at path ${path.join("")}: ${unused}`)}
		return res
	}

}
