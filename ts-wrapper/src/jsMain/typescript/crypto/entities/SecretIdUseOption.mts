// auto-generated file

/**
 *
 *  Configuration for which secret id to use for linking to a owning entity (e.g. which secret id of patient to use
 *  when linking a contact to the patient)
 */
export type SecretIdUseOption = typeof SecretIdUseOption.UseAnySharedWithHierarchy | typeof SecretIdUseOption.UseAllSharedWithHierarchy | SecretIdUseOption.Use | typeof SecretIdUseOption.UseNone;

export namespace SecretIdUseOption {

	export const UseAnySharedWithHierarchy: {
		readonly $ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithHierarchy'
	} = {
		$ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithHierarchy'
	}

	export const UseAllSharedWithHierarchy: {
		readonly $ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAllSharedWithHierarchy'
	} = {
		$ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAllSharedWithHierarchy'
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
