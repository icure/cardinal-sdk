package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.utils.InternalIcureApi

/**
 * Validation of entities, can be used also if the current user is not a data owner.
 */
@InternalIcureApi
interface EntityValidationService {
	/**
	 * Can be used also if the current user is not a data owner or does not have access to any encryption keys
	 * of the entity.
	 *
	 * Before cardinal 3.0 this method was performing strong validation on the provided entity, checking that none of
	 * them exposes any field which should be encrypted according to the provided manifest.
	 * Currently this method does nothing (returns input without validating), but is kept as a placeholder in case
	 * future versions of cardinal require additional validation of encrypted entities.
	 *
	 * @throws EntityEncryptionException if any of the provided entities does not pass validaiton
	 * @return [encryptedEntities] unmodified if it is valid (throws exception if not).
	 */
	suspend fun <E> validateEncryptedEntities(
		encryptedEntities: List<E>,
	): List<E> where E : Encryptable, E : HasEncryptionMetadata
}
