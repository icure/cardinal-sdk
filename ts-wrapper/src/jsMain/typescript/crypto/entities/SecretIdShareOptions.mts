// auto-generated file

/**
 *
 *  Configure how secret ids should be shared
 */
export type SecretIdShareOptions = SecretIdShareOptions.AllAvailable | SecretIdShareOptions.UseExactly;

export namespace SecretIdShareOptions {

	/**
	 *
	 *  Share all available secret ids
	 *  @param requireAtLeastOne if true the sharing will fail if the current user can't access any secret id of the entity
	 */
	export class AllAvailable {

		requireAtLeastOne: boolean = false;

		readonly $ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.AllAvailable' = 'com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.AllAvailable';

		constructor(partial: Partial<AllAvailable>) {
			if ('requireAtLeastOne' in partial && partial.requireAtLeastOne !== undefined) this.requireAtLeastOne = partial.requireAtLeastOne;
		}

	}

	/**
	 *
	 *  Share exactly the provided secret ids.
	 *  In case any of the provided secret ids is not known by the SDK (the current user can't extract that secret id
	 *  from the entity):
	 *  - If createUnknownSecretIds is false the sharing will fail
	 *  - If createUnknownSecretIds is true the method will ignore unknown entries, effectively creating new secret ids.
	 *  @param secretIds the secret ids that will be shared.
	 *  @param createUnknownSecretIds true if unknown secret ids can be used
	 */
	export class UseExactly {

		secretIds: Array<string>;

		createUnknownSecretIds: boolean;

		readonly $ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.UseExactly' = 'com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.UseExactly';

		constructor(partial: Partial<UseExactly> & Pick<UseExactly, "secretIds" | "createUnknownSecretIds">) {
			this.secretIds = partial.secretIds;
			this.createUnknownSecretIds = partial.createUnknownSecretIds;
		}

	}

}
