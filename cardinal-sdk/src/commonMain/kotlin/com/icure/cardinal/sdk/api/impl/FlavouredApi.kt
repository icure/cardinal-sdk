package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.crypto.EntityEncryptionService
import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.utils.InternalIcureApi

internal interface FlavouredApi<EncryptedEntity : HasEncryptionMetadata, FlavouredEntity : HasEncryptionMetadata> {
	/**
	 * Entities that are decrypted will be encrypted: fails if it is not possible to encrypt any of the provided
	 * entities (can happen only if there is a badly initialized new entity, or if the entities come from another
	 * instance of SDK, so not possible unless there is a programming error).
	 * This is the case for both the decrypted and tryAndRecover flavours (there is no recovery if an entity can't be
	 * encrypted, since it can only happen through programming errors).
	 *
	 * For entities that are already encrypted older versions of cardinal were checking that the encrypted entity
	 * did actually respect the manifest, but starting from version 3.0 this validation is not performed anymore,
	 * and encrypted entities are returned directly.
	 *
	 * # Legacy validation of already encrypted entities: why removed
	 *
	 * The goal of validation of already encrypted entities was to detect programming errors while still allowing users
	 * to modify entities for which they have no encryption key.
	 *
	 * For example, if the encryption manifest declares that a Patient's note should be encrypted, in an
	 * EncryptedPatient the note should always be null; a user can still update non-encrypted fields such as the
	 * firstName of a patient, but attempting to set a note would cause an exception.
	 *
	 * One big problem with this verification is that it is hard to change safely the manifest: if in the past the
	 * manifest did not require Patient note to be encrypted, but now it does, then the SDK might retrieve an
	 * EncryptedPatient model that has a note field, and the user would not be able to modify it without first deleting
	 * the note.
	 *
	 * With the introduction of customized SDK, instead, this verification is enforced by the design of the data model
	 * itself: if the customized Patient model declares that note should be encrypted, then the EncryptedPatient m
	 * odel will not have a definition for note.
	 *
	 * Changes of the encryption manifest will be handled through the standard customized entity migration system.
	 */
	suspend fun validateAndMaybeEncrypt(entitiesGroupId: String?, entities: List<FlavouredEntity>): List<EncryptedEntity>

	/**
	 * For encrypted flavour returns the [entities] as is, unchanged.
	 *
	 * Otherwise attempts to decrypt the entities, and if not possible (key not accessible to current instance of SDK or
	 * encrypted content is invalid):
	 * - For decrypted flavour fails with exception
	 * - For tryAndRecover flavour returns the entities that could not be decrypted as is (encrypted).
	 */
	suspend fun maybeDecrypt(entitiesGroupId: String?, entities: List<EncryptedEntity>): List<FlavouredEntity>

	companion object {
		@InternalIcureApi
		fun <EncryptedEntity, DecryptedEntity> decrypted(
			config: ApiConfiguration,
			encryptor: EntityEncryptor<EncryptedEntity, DecryptedEntity>,
			decryptor: EntityDecryptor<EncryptedEntity, DecryptedEntity>,
			type: EntityWithEncryptionMetadataTypeName,
		) where EncryptedEntity: HasEncryptionMetadata,
				DecryptedEntity: HasEncryptionMetadata,
				EncryptedEntity: Encryptable,
				DecryptedEntity: Encryptable = object : FlavouredApi<EncryptedEntity, DecryptedEntity> {
			override suspend fun validateAndMaybeEncrypt(
				entitiesGroupId: String?,
				entities: List<DecryptedEntity>
			): List<EncryptedEntity> {
				entities.forEach {
					require(it.securityMetadata != null) {
						"Entity must have security metadata initialized. Make sure to use the `withEncryptionMetadata` method before creating new entities."
					}
				}
				return config.crypto.entity.encryptEntities(
					entitiesGroupId,
					entities,
					type,
					encryptor,
				)
			}

			override suspend fun maybeDecrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedEntity>
			): List<DecryptedEntity> =
				config.crypto.entity.decryptEntities(
					entitiesGroupId,
					entities,
					type,
					decryptor,
				)
		}

		@InternalIcureApi
		fun <EncryptedEntity> encrypted(
			config: BasicApiConfiguration,
		) where EncryptedEntity: HasEncryptionMetadata,
				EncryptedEntity: Encryptable = object : FlavouredApi<EncryptedEntity, EncryptedEntity> {
			override suspend fun validateAndMaybeEncrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedEntity>
			): List<EncryptedEntity> =
				config.crypto.validationService.validateEncryptedEntities(entities)

			override suspend fun maybeDecrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedEntity>
			): List<EncryptedEntity> =
				entities
		}

		@InternalIcureApi
		inline fun <Base, reified EncryptedEntity : Base, reified DecryptedEntity : Base> tryAndRecover(
			config: ApiConfiguration,
			encryptor: EntityEncryptor<EncryptedEntity, DecryptedEntity>,
			decryptor: EntityDecryptor<EncryptedEntity, DecryptedEntity>,
			type: EntityWithEncryptionMetadataTypeName,
		) where Base: HasEncryptionMetadata, Base: Encryptable = object : FlavouredApi<EncryptedEntity, Base> {
			override suspend fun validateAndMaybeEncrypt(
				entitiesGroupId: String?,
				entities: List<Base>
			): List<EncryptedEntity> =
				config.crypto.entity.validateOrEncryptEntities(
					entitiesGroupId = entitiesGroupId,
					entities = entities,
					entitiesType = type,
					encryptor = encryptor,
				)

			override suspend fun maybeDecrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedEntity>,
			): List<Base> =
				config.crypto.entity.tryDecryptEntities(
					entitiesGroupId,
					entities,
					type,
					decryptor,
				)
		}
	}
}

internal suspend inline fun <EncryptedEntity : HasEncryptionMetadata, FlavouredEntity : HasEncryptionMetadata> FlavouredApi<EncryptedEntity, FlavouredEntity>.validateAndMaybeEncrypt(entitiesGroupId: String?, entity: FlavouredEntity): EncryptedEntity =
	validateAndMaybeEncrypt(entitiesGroupId, listOf(entity)).single()
internal suspend inline fun <EncryptedEntity : HasEncryptionMetadata, FlavouredEntity : HasEncryptionMetadata> FlavouredApi<EncryptedEntity, FlavouredEntity>.maybeDecrypt(entitiesGroupId: String?, entity: EncryptedEntity): FlavouredEntity =
	maybeDecrypt(entitiesGroupId, listOf(entity)).single()
internal suspend inline fun <EncryptedEntity : HasEncryptionMetadata, FlavouredEntity : HasEncryptionMetadata> FlavouredApi<EncryptedEntity, FlavouredEntity>.validateAndMaybeEncrypt(entities: List<FlavouredEntity>): List<EncryptedEntity> =
	validateAndMaybeEncrypt(null, entities)
internal suspend inline fun <EncryptedEntity : HasEncryptionMetadata, FlavouredEntity : HasEncryptionMetadata> FlavouredApi<EncryptedEntity, FlavouredEntity>.maybeDecrypt(entities: List<EncryptedEntity>): List<FlavouredEntity> =
	maybeDecrypt(null, entities)
internal suspend inline fun <EncryptedEntity : HasEncryptionMetadata, FlavouredEntity : HasEncryptionMetadata> FlavouredApi<EncryptedEntity, FlavouredEntity>.maybeDecrypt(paginatedList: PaginatedList<EncryptedEntity>): PaginatedList<FlavouredEntity> =
	PaginatedList(maybeDecrypt(null, paginatedList.rows), paginatedList.nextKeyPair)
internal suspend inline fun <EncryptedEntity : HasEncryptionMetadata, FlavouredEntity : HasEncryptionMetadata> FlavouredApi<EncryptedEntity, FlavouredEntity>.maybeDecrypt(entitiesGroupId: String?, shareResults: List<EntityBulkShareResult<EncryptedEntity>>): List<EntityBulkShareResult<FlavouredEntity>> {
	val decryptedById = maybeDecrypt(entitiesGroupId, shareResults.mapNotNull { it.updatedEntity }).associateBy { it.id }
	return shareResults.map { shareResult ->
		shareResult.map { decryptedById.getValue(it.id) }
	}
}

@InternalIcureApi
internal suspend inline fun <Base, reified EncryptedEntity : Base, reified DecryptedEntity : Base> EntityEncryptionService.validateOrEncryptEntities(
	entitiesGroupId: String?,
	entities: List<Base>,
	entitiesType: EntityWithEncryptionMetadataTypeName,
	encryptor: EntityEncryptor<EncryptedEntity, DecryptedEntity>,
): List<EncryptedEntity> where Base : HasEncryptionMetadata, Base : Encryptable =
	validateOrEncryptEntities<Base, EncryptedEntity, DecryptedEntity>(
		entities = entities,
		doEncrypt = { decryptedEntities ->
			decryptedEntities.forEach {
				require(it.securityMetadata != null) {
					"Entity must have security metadata initialized. Make sure to use the `withEncryptionMetadata` method before creating new entities."
				}
			}
			encryptEntities(
				entitiesGroupId,
				decryptedEntities,
				entitiesType,
				encryptor,
			)
		},
		doValidate = {
			validateEncryptedEntities(
				it,
			)
		}
	)

@InternalIcureApi
internal inline fun <Base, reified EncryptedEntity : Base, reified DecryptedEntity : Base> validateOrEncryptEntities(
	entities: List<Base>,
	// Should fail if any can't be encrypted
	doEncrypt: (List<DecryptedEntity>) -> List<EncryptedEntity>,
	// Should fail if any is not properly encrypted
	doValidate: (List<EncryptedEntity>) -> Unit
): List<EncryptedEntity> where Base : HasEncryptionMetadata, Base : Encryptable {
	val encryptedById = doEncrypt(entities.filterIsInstance<DecryptedEntity>()).associateBy { it.id }
	doValidate(entities.filterIsInstance<EncryptedEntity>())
	return entities.map { encryptedById[it.id] ?: it as EncryptedEntity }
}