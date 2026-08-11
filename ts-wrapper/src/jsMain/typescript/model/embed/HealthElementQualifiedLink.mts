// auto-generated file
import {expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


/**
 *
 *  A directed, qualified link from one healthcare element to another. Links should be created in a
 *  single direction:
 *  the reverse link can be found through a view.
 *  /
 */
export class HealthElementQualifiedLink {

	/**
	 *
	 *  The qualification of the link. Free string; using the names of LinkQualification entries is
	 *  encouraged but not enforced.
	 */
	type: string;

	/**
	 *
	 *  A caller-chosen correlation id that groups related links across entities.
	 */
	associationId: string | undefined = undefined;

	/**
	 *
	 *  The id of the linked healthcare element.
	 */
	healthElementId: string;

	constructor(partial: Partial<HealthElementQualifiedLink> & Pick<HealthElementQualifiedLink, "type" | "healthElementId">) {
		this.type = partial.type;
		if ('associationId' in partial) this.associationId = partial.associationId;
		this.healthElementId = partial.healthElementId;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['type'] = this.type
		if (this.associationId != undefined) res['associationId'] = this.associationId
		res['healthElementId'] = this.healthElementId
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['HealthElementQualifiedLink']): HealthElementQualifiedLink {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new HealthElementQualifiedLink({
			type: expectString(extractEntry(jCpy, 'type', true, path), false, [...path, ".type"]),
			associationId: expectString(extractEntry(jCpy, 'associationId', false, path), true, [...path, ".associationId"]),
			healthElementId: expectString(extractEntry(jCpy, 'healthElementId', true, path), false, [...path, ".healthElementId"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object HealthElementQualifiedLink at path ${path.join("")}: ${unused}`)}
		return res
	}

}
