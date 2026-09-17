// This file is auto-generated
@file:Suppress("ktlint:standard:max-line-length")

package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.ExtensionsEncryptors
import com.icure.cardinal.sdk.crypto.encryptor.encryptExtension
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.EncryptableFieldConfig
import com.icure.cardinal.sdk.model.DecryptedPropertyStub
import com.icure.cardinal.sdk.model.DecryptedRelatedPerson
import com.icure.cardinal.sdk.model.EncryptedPropertyStub
import com.icure.cardinal.sdk.model.EncryptedRelatedPerson
import com.icure.cardinal.sdk.model.embed.DecryptedAddress
import com.icure.cardinal.sdk.model.embed.EncryptedAddress
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.Lazy
import kotlin.String
import kotlin.Suppress

@InternalIcureApi
internal object RelatedPersonEncryptorFactory : EntityEncryptorFactory<EncryptedRelatedPerson, DecryptedRelatedPerson> {
	override val empty: EntityEncryptor<EncryptedRelatedPerson, DecryptedRelatedPerson> =
		object : EntityEncryptor<EncryptedRelatedPerson, DecryptedRelatedPerson> {
			override suspend fun encrypt(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				clearEntity: DecryptedRelatedPerson,
			): EncryptedRelatedPerson =
				EncryptedRelatedPerson(
					id = clearEntity.id,
					rev = clearEntity.rev,
					identifier = clearEntity.identifier,
					created = clearEntity.created,
					modified = clearEntity.modified,
					author = clearEntity.author,
					responsible = clearEntity.responsible,
					tags = clearEntity.tags,
					codes = clearEntity.codes,
					endOfLife = clearEntity.endOfLife,
					deletionDate = clearEntity.deletionDate,
					firstName = clearEntity.firstName,
					lastName = clearEntity.lastName,
					names = clearEntity.names,
					companyName = clearEntity.companyName,
					languages = clearEntity.languages,
					addresses =
						clearEntity.addresses.map { x0 ->
							AddressEncryptorFactory.empty.encrypt(encryptionKey, x0)
						},
					civility = clearEntity.civility,
					gender = clearEntity.gender,
					properties =
						clearEntity.properties.mapTo(mutableSetOf()) { x0 ->
							PropertyStubEncryptorFactory.empty.encrypt(encryptionKey, x0)
						},
					secretForeignKeys = clearEntity.secretForeignKeys,
					cryptedForeignKeys = clearEntity.cryptedForeignKeys,
					delegations = clearEntity.delegations,
					encryptionKeys = clearEntity.encryptionKeys,
					encryptedSelf = null,
					securityMetadata = clearEntity.securityMetadata,
					customisedModelVersion = clearEntity.customisedModelVersion,
					extensions = clearEntity.extensions,
				)
		}

	override fun create(
		entityManifestName: String,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<EncryptedRelatedPerson, DecryptedRelatedPerson> {
		val manifest = encryptorsFactoryContext.getManifest(entityManifestName)
		val extensionsEncryptor =
			manifest.currentExtensionsManifest?.let {
				encryptorsFactoryContext.getExtensionEncryptorsProvider(
					extensionsManifestName = it,
					encryptedClass = EncryptedRelatedPerson::class,
					decryptedClass = DecryptedRelatedPerson::class,
				)
			}
		return RelatedPersonEncryptor(
			identifier_e = "identifier" in manifest.fieldsToEncrypt,
			created_e = "created" in manifest.fieldsToEncrypt,
			modified_e = "modified" in manifest.fieldsToEncrypt,
			author_e = "author" in manifest.fieldsToEncrypt,
			responsible_e = "responsible" in manifest.fieldsToEncrypt,
			tags_e = "tags" in manifest.fieldsToEncrypt,
			codes_e = "codes" in manifest.fieldsToEncrypt,
			firstName_e = "firstName" in manifest.fieldsToEncrypt,
			lastName_e = "lastName" in manifest.fieldsToEncrypt,
			names_e = "names" in manifest.fieldsToEncrypt,
			companyName_e = "companyName" in manifest.fieldsToEncrypt,
			languages_e = "languages" in manifest.fieldsToEncrypt,
			addresses_e =
				if ("addresses" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["addresses"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorsFactoryContext.getEntityEncryptorsProvider(
								entityManifestName = it,
								encryptedClass = EncryptedAddress::class,
								decryptedClass = DecryptedAddress::class,
							),
						)
					} ?: EncryptableFieldConfig.None(AddressEncryptorFactory)
				},
			civility_e = "civility" in manifest.fieldsToEncrypt,
			gender_e = "gender" in manifest.fieldsToEncrypt,
			properties_e =
				if ("properties" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["properties"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorsFactoryContext.getEntityEncryptorsProvider(
								entityManifestName = it,
								encryptedClass = EncryptedPropertyStub::class,
								decryptedClass = DecryptedPropertyStub::class,
							),
						)
					} ?: EncryptableFieldConfig.None(PropertyStubEncryptorFactory)
				},
			extensionsEncryptor = extensionsEncryptor,
			encodingJson = encodingJson,
			cryptoService = cryptoService,
		)
	}
}

@InternalIcureApi
private class RelatedPersonEncryptor(
	private val identifier_e: Boolean,
	private val created_e: Boolean,
	private val modified_e: Boolean,
	private val author_e: Boolean,
	private val responsible_e: Boolean,
	private val tags_e: Boolean,
	private val codes_e: Boolean,
	private val firstName_e: Boolean,
	private val lastName_e: Boolean,
	private val names_e: Boolean,
	private val companyName_e: Boolean,
	private val languages_e: Boolean,
	private val addresses_e: EncryptableFieldConfig<EncryptedAddress, DecryptedAddress>,
	private val civility_e: Boolean,
	private val gender_e: Boolean,
	private val properties_e: EncryptableFieldConfig<EncryptedPropertyStub, DecryptedPropertyStub>,
	private val extensionsEncryptor: Lazy<ExtensionsEncryptors>?,
	private val encodingJson: Json,
	cryptoService: CryptoService,
) : AbstractEntityEncryptor<EncryptedRelatedPerson, DecryptedRelatedPerson>(cryptoService) {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedRelatedPerson,
	): EncryptedRelatedPerson {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (identifier_e && clearEntity.identifier.isNotEmpty()) {
			dataToEncrypt["identifier"] =
				encodingJson.encodeToJsonElement(
					clearEntity.identifier,
				)
		}
		if (created_e && clearEntity.created != null) dataToEncrypt["created"] = encodingJson.encodeToJsonElement(clearEntity.created)
		if (modified_e && clearEntity.modified != null) dataToEncrypt["modified"] = encodingJson.encodeToJsonElement(clearEntity.modified)
		if (author_e && clearEntity.author != null) dataToEncrypt["author"] = encodingJson.encodeToJsonElement(clearEntity.author)
		if (responsible_e && clearEntity.responsible != null) {
			dataToEncrypt["responsible"] =
				encodingJson.encodeToJsonElement(
					clearEntity.responsible,
				)
		}
		if (tags_e && clearEntity.tags.isNotEmpty()) dataToEncrypt["tags"] = encodingJson.encodeToJsonElement(clearEntity.tags)
		if (codes_e && clearEntity.codes.isNotEmpty()) dataToEncrypt["codes"] = encodingJson.encodeToJsonElement(clearEntity.codes)
		if (firstName_e && clearEntity.firstName != null) dataToEncrypt["firstName"] = encodingJson.encodeToJsonElement(clearEntity.firstName)
		if (lastName_e && clearEntity.lastName != null) dataToEncrypt["lastName"] = encodingJson.encodeToJsonElement(clearEntity.lastName)
		if (names_e && clearEntity.names.isNotEmpty()) dataToEncrypt["names"] = encodingJson.encodeToJsonElement(clearEntity.names)
		if (companyName_e && clearEntity.companyName != null) {
			dataToEncrypt["companyName"] =
				encodingJson.encodeToJsonElement(
					clearEntity.companyName,
				)
		}
		if (languages_e && clearEntity.languages.isNotEmpty()) {
			dataToEncrypt["languages"] =
				encodingJson.encodeToJsonElement(
					clearEntity.languages,
				)
		}
		if (addresses_e.fullEncryption && clearEntity.addresses.isNotEmpty()) {
			dataToEncrypt["addresses"] =
				encodingJson.encodeToJsonElement(
					clearEntity.addresses,
				)
		}
		if (civility_e && clearEntity.civility != null) dataToEncrypt["civility"] = encodingJson.encodeToJsonElement(clearEntity.civility)
		if (gender_e && clearEntity.gender != null) dataToEncrypt["gender"] = encodingJson.encodeToJsonElement(clearEntity.gender)
		if (properties_e.fullEncryption && clearEntity.properties.isNotEmpty()) {
			dataToEncrypt["properties"] =
				encodingJson.encodeToJsonElement(
					clearEntity.properties,
				)
		}
		return EncryptedRelatedPerson(
			id = clearEntity.id,
			rev = clearEntity.rev,
			identifier = if (identifier_e) emptyList() else clearEntity.identifier,
			created = if (created_e) null else clearEntity.created,
			modified = if (modified_e) null else clearEntity.modified,
			author = if (author_e) null else clearEntity.author,
			responsible = if (responsible_e) null else clearEntity.responsible,
			tags = if (tags_e) emptySet() else clearEntity.tags,
			codes = if (codes_e) emptySet() else clearEntity.codes,
			endOfLife = clearEntity.endOfLife,
			deletionDate = clearEntity.deletionDate,
			firstName = if (firstName_e) null else clearEntity.firstName,
			lastName = if (lastName_e) null else clearEntity.lastName,
			names = if (names_e) emptyList() else clearEntity.names,
			companyName = if (companyName_e) null else clearEntity.companyName,
			languages = if (languages_e) emptyList() else clearEntity.languages,
			addresses =
				addresses_e.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.addresses.map { x0 ->
							encryptor.encrypt(encryptionKey, x0)
						}
					}
				},
			civility = if (civility_e) null else clearEntity.civility,
			gender = if (gender_e) null else clearEntity.gender,
			properties =
				properties_e.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptySet()
					} else {
						clearEntity.properties.mapTo(mutableSetOf()) { x0 ->
							encryptor.encrypt(encryptionKey, x0)
						}
					}
				},
			secretForeignKeys = clearEntity.secretForeignKeys,
			cryptedForeignKeys = clearEntity.cryptedForeignKeys,
			delegations = clearEntity.delegations,
			encryptionKeys = clearEntity.encryptionKeys,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt)),
			securityMetadata = clearEntity.securityMetadata,
			customisedModelVersion = clearEntity.customisedModelVersion,
			extensions = extensionsEncryptor?.value?.encryptExtension(encryptionKey, clearEntity.extensions) ?: clearEntity.extensions,
		)
	}
}
