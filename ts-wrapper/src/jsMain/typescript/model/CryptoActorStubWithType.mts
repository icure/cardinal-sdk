// auto-generated file
import {expectObject, expectStringEnum, extractEntry} from '../internal/JsonDecodeUtils.mjs';
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

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['CryptoActorStubWithType']): CryptoActorStubWithType {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new CryptoActorStubWithType({
			type: expectStringEnum(extractEntry(jCpy, 'type', true, path), false, [...path, ".type"], DataOwnerType, 'DataOwnerType'),
			stub: expectObject(extractEntry(jCpy, 'stub', true, path), false, ignoreUnknownKeys, [...path, ".stub"], CryptoActorStub.fromJSON),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object CryptoActorStubWithType at path ${path.join("")}: ${unused}`)}
		return res
	}

}
