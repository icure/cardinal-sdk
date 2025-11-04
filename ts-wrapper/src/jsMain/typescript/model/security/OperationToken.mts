// auto-generated file
import {expectNumber, expectString, expectStringEnum, requireEntry} from '../../internal/JsonDecodeUtils.mjs';
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

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['tokenHash'] = this.tokenHash
		res['creationTime'] = this.creationTime
		res['validity'] = this.validity
		res['operation'] = this.operation
		if (this.description != undefined) res['description'] = this.description
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['OperationToken']): OperationToken {
		return new OperationToken({
			tokenHash: expectString(requireEntry(json.tokenHash, 'tokenHash', path), false, [...path, ".tokenHash"]),
			creationTime: expectNumber(requireEntry(json.creationTime, 'creationTime', path), false, true, [...path, ".creationTime"]),
			validity: expectNumber(requireEntry(json.validity, 'validity', path), false, true, [...path, ".validity"]),
			operation: expectStringEnum(requireEntry(json.operation, 'operation', path), false, [...path, ".operation"], Operation, 'Operation'),
			description: expectString(json.description, true, [...path, ".description"]),
		})
	}

}
