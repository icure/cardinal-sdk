// auto-generated file

/**
 *
 *  Configuration for which secret id to use for linking to a owning entity (e.g. which secret id of patient to use
 *  when linking a contact to the patient)
 */
export type SecretIdUseOption = typeof SecretIdUseOption.UseAnyConfidential | typeof SecretIdUseOption.UseAllConfidential | typeof SecretIdUseOption.UseAnySharedWithParent | typeof SecretIdUseOption.UseAllSharedWithParent | SecretIdUseOption.Use | typeof SecretIdUseOption.UseNone;

export namespace SecretIdUseOption {

	export const UseAnyConfidential: {
		readonly $ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnyConfidential'
	} = {
		$ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnyConfidential'
	}

	export const UseAllConfidential: {
		readonly $ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAllConfidential'
	} = {
		$ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAllConfidential'
	}

	export const UseAnySharedWithParent: {
		readonly $ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent'
	} = {
		$ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent'
	}

	export const UseAllSharedWithParent: {
		readonly $ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAllSharedWithParent'
	} = {
		$ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAllSharedWithParent'
	}

	/**
	 *
	 *  Specify explicitly which secret ids to use. The secretIds can also be empty, in which case the value is
	 *  equivalent to [UseNone].
	 *  Note that the SDK will not check that the secret id you used is actually a secret id of the owning entity.
	 */
	export class Use {

		secretIds: Array<string>;

		readonly $ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.Use' = 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.Use';

		constructor(partial: Partial<Use> & Pick<Use, "secretIds">) {
			this.secretIds = partial.secretIds;
		}

	}

	export const UseNone: {
		readonly $ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseNone'
	} = {
		$ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseNone'
	}

}
