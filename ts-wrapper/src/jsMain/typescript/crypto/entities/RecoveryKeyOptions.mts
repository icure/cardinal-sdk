// auto-generated file
import {RecoveryDataKey} from './RecoveryDataKey.mjs';
import {RecoveryKeySize} from './RecoveryKeySize.mjs';


/**
 *
 *  Allows to configure which recovery key to use when creating recovery data.
 */
export type RecoveryKeyOptions = RecoveryKeyOptions.Generate | RecoveryKeyOptions.Use;

export namespace RecoveryKeyOptions {

	/**
	 *
	 *  Generate a new key for the recovery data. This is the default behavior, and should be used in most cases.
	 *  @param recoveryKeySize specifies the size of the recovery key to generate
	 */
	export class Generate {

		recoveryKeySize: RecoveryKeySize;

		readonly $ktClass: 'com.icure.cardinal.sdk.crypto.entities.RecoveryKeyOptions.Generate' = 'com.icure.cardinal.sdk.crypto.entities.RecoveryKeyOptions.Generate';

		constructor(partial: Partial<Generate> & Pick<Generate, "recoveryKeySize">) {
			this.recoveryKeySize = partial.recoveryKeySize;
		}

	}

	/**
	 *
	 *  Specifies to use a pre-created recovery key.
	 */
	export class Use {

		key: RecoveryDataKey;

		readonly $ktClass: 'com.icure.cardinal.sdk.crypto.entities.RecoveryKeyOptions.Use' = 'com.icure.cardinal.sdk.crypto.entities.RecoveryKeyOptions.Use';

		constructor(partial: Partial<Use> & Pick<Use, "key">) {
			this.key = partial.key;
		}

	}

}
