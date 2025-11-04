// auto-generated file
import {expectStringEnum, requireEntry} from '../internal/JsonDecodeUtils.mjs';
import {CryptoActorStub} from './CryptoActorStub.mjs';
import {DataOwnerType} from './DataOwnerType.mjs';


export class CryptoActorStubWithType {

	type: DataOwnerType;

	stub: CryptoActorStub;

	constructor(partial: Partial<CryptoActorStubWithType> & Pick<CryptoActorStubWithType, "type" | "stub">) {
		this.type = partial.type;
		this.stub = partial.stub;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['type'] = this.type
		res['stub'] = this.stub.toJSON()
		return res
	}

	static fromJSON(json: any,
			path: Array<string> = ['CryptoActorStubWithType']): CryptoActorStubWithType {
		return new CryptoActorStubWithType({
			type: expectStringEnum(requireEntry(json.type, 'type', path), false, [...path, ".type"], DataOwnerType, 'DataOwnerType'),
			stub: CryptoActorStub.fromJSON(requireEntry(json.stub, 'stub', path), [...path, ".stub"]),
		})
	}

}
