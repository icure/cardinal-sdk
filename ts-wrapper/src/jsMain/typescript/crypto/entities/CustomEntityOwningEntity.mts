// auto-generated file
import {EntityWithEncryptionMetadataTypeName} from './EntityWithEncryptionMetadataTypeName.mjs';
import {SecretIdUseOption} from './SecretIdUseOption.mjs';


/**
 *
 *  Specifies how a new delegation-based custom entity is linked to its owning entity.
 *
 *  The owning entity can be of any type supporting encryption metadata, builtin or custom.
 *  The link between the custom entity and its owner is made of:
 *  - the id of the owning entity (including its group, if different from the group of the new custom entity), always
 *  stored encrypted in the new custom entity. This allows finding the owning entity starting from the custom entity.
 *  - optionally, secret ids of the owning entity, stored in the secret foreign keys of the new custom entity, controlled
 *  by [secretId]. This allows finding the custom entity starting from the owning entity (e.g. like a HealthElement can
 *  be found starting from a Patient). Use [SecretIdUseOption.UseNone] if the current user can't access any secret id of
 *  the owning entity.
 *
 *  @param T the type of the owning entity: `HasEncryptionMetadata` for apis working in the current group, or
 *  `GroupScoped<HasEncryptionMetadata>` for in-group apis.
 *  @param entity the owning entity.
 *  @param entityType the type of the owning entity, needed to access its security metadata.
 *  @param secretId specifies which secret ids of the owning entity to use for the link.
 */
export class CustomEntityOwningEntity<T> {

	entity: T;

	entityType: EntityWithEncryptionMetadataTypeName;

	secretId: SecretIdUseOption = SecretIdUseOption.UseAnySharedWithHierarchy;

	constructor(partial: Partial<CustomEntityOwningEntity<T>> & Pick<CustomEntityOwningEntity<T>, "entity" | "entityType">) {
		this.entity = partial.entity;
		this.entityType = partial.entityType;
		if ('secretId' in partial && partial.secretId !== undefined) this.secretId = partial.secretId;
	}

}
