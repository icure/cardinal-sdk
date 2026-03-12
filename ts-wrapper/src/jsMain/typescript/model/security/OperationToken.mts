// auto-generated file
import {expectNumber, expectString, expectStringEnum, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {Operation} from './Operation.mjs';


/**
 *
 *  Represents a short-lived token that authorizes a single privileged operation (e.g. group
 *  transfer).
 *  The token is stored as a hash rather than in plain text.
 *  /
 */
export class OperationToken {

	/**
	 *
	 *  The hash of the operation token.
	 */
	tokenHash: string;

	/**
	 *
	 *  The epoch-millisecond timestamp at which the token was created.
	 */
	creationTime: number;

	/**
	 *
	 *  The duration in seconds for which the token remains valid after creation.
	 */
	validity: number;

	/**
	 *
	 *  The specific operation this token is intended to authorize.
	 */
	operation: Operation;

	/**
	 *
	 *  An optional human-readable description of the token's purpose.
	 */
	description: string | undefined = undefined;

	constructor(partial: Partial<OperationToken> & Pick<OperationToken, "tokenHash" | "creationTime" | "validity" | "operation">) {
		this.tokenHash = partial.tokenHash;
		this.creationTime = partial.creationTime;
		this.validity = partial.validity;
		this.operation = partial.operation;
		if ('description' in partial) this.description = partial.description;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['tokenHash'] = this.tokenHash
		res['creationTime'] = this.creationTime
		res['validity'] = this.validity
		res['operation'] = this.operation
		if (this.description != undefined) res['description'] = this.description
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['OperationToken']): OperationToken {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new OperationToken({
			tokenHash: expectString(extractEntry(jCpy, 'tokenHash', true, path), false, [...path, ".tokenHash"]),
			creationTime: expectNumber(extractEntry(jCpy, 'creationTime', true, path), false, true, [...path, ".creationTime"]),
			validity: expectNumber(extractEntry(jCpy, 'validity', true, path), false, true, [...path, ".validity"]),
			operation: expectStringEnum(extractEntry(jCpy, 'operation', true, path), false, [...path, ".operation"], Operation, 'Operation'),
			description: expectString(extractEntry(jCpy, 'description', false, path), true, [...path, ".description"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object OperationToken at path ${path.join("")}: ${unused}`)}
		return res
	}

}
