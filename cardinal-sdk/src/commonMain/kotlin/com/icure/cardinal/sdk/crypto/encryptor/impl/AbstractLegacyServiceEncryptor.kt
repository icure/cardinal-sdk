package com.icure.cardinal.sdk.crypto.encryptor.impl

import com.icure.cardinal.sdk.model.embed.DecryptedContent
import com.icure.cardinal.sdk.model.embed.DecryptedService
import com.icure.cardinal.sdk.model.embed.EncryptedContent
import com.icure.cardinal.sdk.model.embed.EncryptedService
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlin.collections.component1
import kotlin.collections.component2

/**
 * Partial implementation of the service encryptor, which provides support for service content encryption using the
 * legacy logic for content encryption.
 */
@InternalIcureApi
internal abstract class AbstractLegacyServiceEncryptor(
	cryptoService: CryptoService,
) : AbstractEntityEncryptor<EncryptedService, DecryptedService>(cryptoService) {
	sealed interface ContentLegacyEncryptionResult {
		data object Full : ContentLegacyEncryptionResult
		data class Partial(val content: Map<String, EncryptedContent>) : ContentLegacyEncryptionResult
	}

	private fun DecryptedService.hasOnlyCompoundContent() =
		content.values.all {
			it.isCompound()
		}

	/**
	 * Should be implemented in as an AND of all the following conditions:
	 * - compoundValue is not null and not empty (!isNullOrEmpty())
	 * - for all other fields:
	 *   - If the field is a nullable-collection then it must be null or empty
	 *   - If the field is nullable-non-collection then it must be null
	 *   - All other potential cases are TBD (generator currently throws an exception)
	 */
	protected abstract fun DecryptedContent.isCompound(): Boolean

	/**
	 * Encrypts content using the legacy encryption style:
	 * - If all the values of the service content have non-null and non-empty values only for
	 *   [com.icure.cardinal.sdk.model.embed.Content.compoundValue] then the content is not encrypted in full, instead
	 *   the contained compound Services are encrypted using this same manifest.
	 *   This also means that the content's map keys will be unencrypted.
	 * - In all other cases the content map is encrypted in its entirety: the map keys and any compound service will be
	 *   completely hidden within the encrypted content.
	 *
	 * Returns [ContentLegacyEncryptionResult.Partial] if the content should be encrypted partially, therefore the value
	 * in the encrypted content should be mapped exactly to the returned [ContentLegacyEncryptionResult.Partial.content] map.
	 * Instead if the content should be encrypted in full returns [ContentLegacyEncryptionResult.Full]: this means the
	 * [com.icure.cardinal.sdk.model.embed.Service.content] field should be replaced by a empty map, while the real
	 * value should be included in the encryptedSelf content.
	 */
	protected suspend fun legacyEncryptContent(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		service: DecryptedService,
	): ContentLegacyEncryptionResult =
		if (service.hasOnlyCompoundContent()) {
			ContentLegacyEncryptionResult.Partial(
				service.content.mapValues { (_, content) ->
					EncryptedContent(
						compoundValue = content.compoundValue?.map { compoundService ->
							this.encrypt(
								encryptionKey,
								compoundService,
							)
						}
					)
				}
			)
		} else {
			ContentLegacyEncryptionResult.Full
		}
}
