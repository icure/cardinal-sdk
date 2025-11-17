// auto-generated file
import {XRsaKeypair} from '../cardinal-sdk-ts.mjs';
import {RawDecryptedExchangeData} from '../crypto/entities/RawDecryptedExchangeData.mjs';
import {RecoveryDataKey} from '../crypto/entities/RecoveryDataKey.mjs';
import {RecoveryDataUseFailureReason} from '../crypto/entities/RecoveryDataUseFailureReason.mjs';
import {RecoveryKeyOptions} from '../crypto/entities/RecoveryKeyOptions.mjs';
import {RecoveryKeySize} from '../crypto/entities/RecoveryKeySize.mjs';
import {RecoveryResult} from '../crypto/entities/RecoveryResult.mjs';
import {CancellablePromise} from '../utils/CancellablePromise.mjs';


export interface RecoveryApi {

	createRecoveryInfoForAvailableKeyPairs(options?: { includeParentsKeys?: boolean, lifetimeSeconds?: number | undefined, recoveryKeyOptions?: RecoveryKeyOptions | undefined }): Promise<RecoveryDataKey>;

	recoverKeyPairs(recoveryKey: RecoveryDataKey,
			autoDelete: boolean): Promise<RecoveryResult<{ [ key: string ]: { [ key: string ]: XRsaKeypair } }>>;

	recoverKeyPairsWaitingForCreation(recoveryKey: RecoveryDataKey, autoDelete: boolean,
			waitSeconds: number): CancellablePromise<RecoveryResult<{ [ key: string ]: { [ key: string ]: XRsaKeypair } }>>;

	createExchangeDataRecoveryInfo(delegateId: string,
			options?: { lifetimeSeconds?: number | undefined, recoveryKeyOptions?: RecoveryKeyOptions | undefined, includeBiDirectional?: boolean, includeAsParent?: boolean }): Promise<RecoveryDataKey | undefined>;

	recoverExchangeData(recoveryKey: RecoveryDataKey): Promise<RecoveryDataUseFailureReason | undefined>;

	getRecoveryExchangeData(recoveryKey: RecoveryDataKey,
			autoDelete: boolean): Promise<RecoveryResult<Array<RawDecryptedExchangeData>>>;

	purgeRecoveryInfo(recoveryKey: RecoveryDataKey): Promise<void>;

	purgeAllRecoveryInfoFor(dataOwnerId: string): Promise<number>;

	purgeAllKeyPairRecoveryInfoFor(dataOwnerId: string): Promise<number>;

	purgeAllExchangeDataRecoveryInfoFor(dataOwnerId: string): Promise<number>;

	preGenerateRecoveryKey(keySize: RecoveryKeySize): Promise<RecoveryDataKey>;

}
