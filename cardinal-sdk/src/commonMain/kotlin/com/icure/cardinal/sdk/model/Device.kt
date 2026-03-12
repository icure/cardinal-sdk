// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.CryptoActor
import com.icure.cardinal.sdk.model.base.DataOwner
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.base.Named
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEntryKeyString
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import com.icure.cardinal.sdk.serialization.ByteArraySerializer
import kotlin.ByteArray

/**
 * Represents a device that sends medical data. This is a root-level entity stored in the
 * icure-device CouchDB database.
 * A device can act as a data owner and crypto actor for secure data exchange.
 * /
 */
@Serializable
data class Device(
	/**
	 * The Id of the device. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String,
	/**
	 * The revision of the device in the database, used for conflict management / optimistic locking.
	 */
	override val rev: String? = null,
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The device's identifiers used for client-side identification.
	 */
	@param:DefaultValue("emptyList()")
	public val identifiers: List<Identifier> = emptyList(),
	/**
	 * The timestamp (unix epoch in ms) of creation of this entity.
	 */
	override val created: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) of the latest modification of this entity.
	 */
	override val modified: Long? = null,
	/**
	 * The id of the User that created this device.
	 */
	override val author: String? = null,
	/**
	 * The id of the data owner that is responsible for this device.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the device as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular device.
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	/**
	 * The name of the device.
	 */
	override val name: String? = null,
	/**
	 * The type of the device (e.g., smartphone, medical device sort).
	 */
	public val type: String? = null,
	/**
	 * The brand of the device (e.g., Samsung, Apple, Philips).
	 */
	public val brand: String? = null,
	/**
	 * The model of the device (e.g., Galaxy S10).
	 */
	public val model: String? = null,
	/**
	 * The serial number of the device.
	 */
	public val serialNumber: String? = null,
	/**
	 * The id of the parent of the user representing the device.
	 */
	override val parentId: String? = null,
	/**
	 * Typed properties related to the device (e.g., version, specific device information).
	 */
	@param:DefaultValue("emptySet()")
	override val properties: Set<DecryptedPropertyStub> = emptySet(),
	/**
	 * The exchange keys with other healthcare parties, encrypted using public keys.
	 */
	@param:DefaultValue("emptyMap()")
	override val hcPartyKeys: Map<String, List<HexString>> = emptyMap(),
	/**
	 * Extra AES exchange keys, usually keys that were lost access to at some point.
	 */
	@param:DefaultValue("emptyMap()")
	override val aesExchangeKeys: Map<AesExchangeKeyEntryKeyString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> =
		emptyMap(),
	/**
	 * Private keys encrypted with public keys for key transfer.
	 */
	@param:DefaultValue("emptyMap()")
	override val transferKeys: Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> =
		emptyMap(),
	/**
	 * Shamir partitions of this device's RSA private keys, encrypted with notary public keys.
	 */
	@param:DefaultValue("emptyMap()")
	override val privateKeyShamirPartitions: Map<String, HexString> = emptyMap(),
	/**
	 * The public RSA key of this device.
	 */
	override val publicKey: SpkiHexString? = null,
	/**
	 * The public keys of this device generated using OAEP with SHA-256.
	 */
	@param:DefaultValue("emptySet()")
	override val publicKeysForOaepWithSha256: Set<SpkiHexString> = emptySet(),
	/**
	 * Properties specific to the crypto actor role of this device.
	 */
	override val cryptoActorProperties: Set<DecryptedPropertyStub> = emptySet(),
) : StoredDocument, ICureDocument<String>, Named, CryptoActor, DataOwner {
	// region Device-Device
	companion object {
		const val KRAKEN_QUALIFIED_NAME = "org.taktik.icure.entities.Device"
	}
	// endregion
}
