package com.icure.cardinal.sdk.crypto.encryptor

data class EncryptorOptions(
	/**
	 * If true enforces the use of the legacy way of encrypting the service content:
	 * - If all the values of the service content have non-null and non-empty values only for
	 *   [com.icure.cardinal.sdk.model.embed.Content.compoundValue] then the content is not encrypted in full, instead
	 *   the contained compound Services are encrypted using this same manifest.
	 *   This also means that the content's map keys will be unencrypted.
	 * - In all other cases the content map is encrypted in its entirety: the map keys and any compound service will be
	 *   completely hidden within the encrypted content.
	 *
	 * If true it is not possible to customize how a service content is encrypted and any attempt to configure it in the
	 * service manifest will raise an exception.
	 */
	val useLegacyServiceContentEncryption: Boolean,
	/**
	 * If true the content of encrypted self in entities will be serialized using the legacy field names rather than
	 * the cardinal SDK names (for example [com.icure.cardinal.sdk.model.embed.InvoicingCode.pricingId] will be
	 * serialized as "tarificationId" instead of "pricingId").
	 *
	 * This is required to ensure that the legacy iCure typescript SDK can correctly deserialize the entities.
	 */
	val serializeEncryptedSelfUsingLegacyNames: Boolean,
)
