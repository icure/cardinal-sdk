// auto-generated file
import {CryptoActorStub} from '../CryptoActorStub.mjs';
import {Device} from '../Device.mjs';
import {HealthcareParty} from '../HealthcareParty.mjs';
import {DecryptedPatient, EncryptedPatient} from '../Patient.mjs';
import {DecryptedPropertyStub} from '../PropertyStub.mjs';
import {HexString} from '../specializations/HexString.mjs';
import {SpkiHexString} from '../specializations/SpkiHexString.mjs';
import {Versionable} from './Versionable.mjs';


export interface CryptoActor extends Versionable<string> {

	hcPartyKeys: { [ key: string ]: Array<HexString> };

	aesExchangeKeys: { [ key: string ]: { [ key: string ]: { [ key: string ]: HexString } } };

	transferKeys: { [ key: string ]: { [ key: string ]: HexString } };

	privateKeyShamirPartitions: { [ key: string ]: HexString };

	publicKey: SpkiHexString | undefined;

	publicKeysForOaepWithSha256: Array<SpkiHexString>;

	parentId: string | undefined;

	cryptoActorProperties: Array<DecryptedPropertyStub> | undefined;

	readonly $ktClass: string;

}

export namespace CryptoActor {

	export function fromJSON(json: any, path: Array<string> = ['CryptoActor']): CryptoActor {
		switch ((json as CryptoActor).$ktClass) {
			case 'com.icure.cardinal.sdk.model.CryptoActorStub': return CryptoActorStub.fromJSON(json)
			case 'com.icure.cardinal.sdk.model.EncryptedPatient': return EncryptedPatient.fromJSON(json)
			case 'com.icure.cardinal.sdk.model.DecryptedPatient': return DecryptedPatient.fromJSON(json)
			case 'com.icure.cardinal.sdk.model.Device': return Device.fromJSON(json)
			case 'com.icure.cardinal.sdk.model.HealthcareParty': return HealthcareParty.fromJSON(json)
			default: throw new Error('Unexpected discriminator for CryptoActor: ' + json.$ktClass)
		}
	}

}
