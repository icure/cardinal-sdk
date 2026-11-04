// auto-generated file

export class SecretIdCreationResult<E> {

	updatedEntity: E;

	newSecretId: string;

	constructor(partial: Partial<SecretIdCreationResult<E>> & Pick<SecretIdCreationResult<E>, "updatedEntity" | "newSecretId">) {
		this.updatedEntity = partial.updatedEntity;
		this.newSecretId = partial.newSecretId;
	}

}
