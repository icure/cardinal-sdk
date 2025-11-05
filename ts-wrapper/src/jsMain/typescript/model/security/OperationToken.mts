// auto-generated file
import {expectNumber, expectString, expectStringEnum, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {Operation} from './Operation.mjs';


export class OperationToken {

	tokenHash: string;

	creationTime: number;

	validity: number;

	operation: Operation;

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
