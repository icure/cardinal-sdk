// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.ExtensionsEncryptors
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.customsdk.commons.model.CustomisedModelVersion
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.DecryptedPropertyStub
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.model.EncryptedPropertyStub
import com.icure.cardinal.sdk.model.embed.DecryptedAddress
import com.icure.cardinal.sdk.model.embed.DecryptedAnnotation
import com.icure.cardinal.sdk.model.embed.DecryptedFinancialInstitutionInformation
import com.icure.cardinal.sdk.model.embed.DecryptedInsurability
import com.icure.cardinal.sdk.model.embed.DecryptedMedicalHouseContract
import com.icure.cardinal.sdk.model.embed.DecryptedPartnership
import com.icure.cardinal.sdk.model.embed.DecryptedPatientHealthCareParty
import com.icure.cardinal.sdk.model.embed.EncryptedAddress
import com.icure.cardinal.sdk.model.embed.EncryptedAnnotation
import com.icure.cardinal.sdk.model.embed.EncryptedFinancialInstitutionInformation
import com.icure.cardinal.sdk.model.embed.EncryptedInsurability
import com.icure.cardinal.sdk.model.embed.EncryptedMedicalHouseContract
import com.icure.cardinal.sdk.model.embed.EncryptedPartnership
import com.icure.cardinal.sdk.model.embed.EncryptedPatientHealthCareParty
import com.icure.cardinal.sdk.options.DecryptedJsonStrictness
import com.icure.cardinal.sdk.utils.UnexpectedEncryptedContentException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.Lazy
import kotlin.String
import kotlin.UnsupportedOperationException
import kotlin.collections.Collection
import kotlin.collections.Map

@InternalIcureApi
internal object PatientDecryptorFactory : EntityDecryptorFactory<EncryptedPatient, DecryptedPatient> {
	override fun create(
		entityManifestName: String?,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		cryptoService: CryptoService,
		encryptedContentDecoder: Json,
		unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
	): EntityDecryptor<EncryptedPatient, DecryptedPatient> {
		val manifest = entityManifestName?.let { encryptorsFactoryContext.getManifest(it) }
		val extensionsDecryptorsByVersion =
			manifest?.extensionsManifestsByModelVersion?.mapValues { (_, extensionsManifestName) ->
				encryptorsFactoryContext.getExtensionEncryptorsProvider(
					extensionsManifestName = extensionsManifestName,
					encryptedClass = EncryptedPatient::class,
					decryptedClass = DecryptedPatient::class,
				)
			} ?: emptyMap()
		val patchDecryptedSelfJson = entityManifestName?.let { encryptorsFactoryContext.getManifestDecryptedJsonPatcher(it) }
		val addressesDecryptor =
			manifest?.recursiveEncryption?.get("addresses")?.let { nestedManifestName ->
				val pairLazy =
					encryptorsFactoryContext.getEntityEncryptorsProvider(
						entityManifestName = nestedManifestName,
						encryptedClass = EncryptedAddress::class,
						decryptedClass = DecryptedAddress::class,
					)
				lazy { pairLazy.value.decryptor }
			} ?: encryptorsFactoryContext.getEmptyEntityDecryptorProvider(
				encryptedClass = EncryptedAddress::class,
				decryptedClass = DecryptedAddress::class,
			)
		val notesDecryptor =
			manifest?.recursiveEncryption?.get("notes")?.let { nestedManifestName ->
				val pairLazy =
					encryptorsFactoryContext.getEntityEncryptorsProvider(
						entityManifestName = nestedManifestName,
						encryptedClass = EncryptedAnnotation::class,
						decryptedClass = DecryptedAnnotation::class,
					)
				lazy { pairLazy.value.decryptor }
			} ?: encryptorsFactoryContext.getEmptyEntityDecryptorProvider(
				encryptedClass = EncryptedAnnotation::class,
				decryptedClass = DecryptedAnnotation::class,
			)
		val insurabilitiesDecryptor =
			manifest?.recursiveEncryption?.get("insurabilities")?.let { nestedManifestName ->
				val pairLazy =
					encryptorsFactoryContext.getEntityEncryptorsProvider(
						entityManifestName = nestedManifestName,
						encryptedClass = EncryptedInsurability::class,
						decryptedClass = DecryptedInsurability::class,
					)
				lazy { pairLazy.value.decryptor }
			} ?: encryptorsFactoryContext.getEmptyEntityDecryptorProvider(
				encryptedClass = EncryptedInsurability::class,
				decryptedClass = DecryptedInsurability::class,
			)
		val partnershipsDecryptor =
			manifest?.recursiveEncryption?.get("partnerships")?.let { nestedManifestName ->
				val pairLazy =
					encryptorsFactoryContext.getEntityEncryptorsProvider(
						entityManifestName = nestedManifestName,
						encryptedClass = EncryptedPartnership::class,
						decryptedClass = DecryptedPartnership::class,
					)
				lazy { pairLazy.value.decryptor }
			} ?: encryptorsFactoryContext.getEmptyEntityDecryptorProvider(
				encryptedClass = EncryptedPartnership::class,
				decryptedClass = DecryptedPartnership::class,
			)
		val patientHealthCarePartiesDecryptor =
			manifest?.recursiveEncryption?.get("patientHealthCareParties")?.let { nestedManifestName ->
				val pairLazy =
					encryptorsFactoryContext.getEntityEncryptorsProvider(
						entityManifestName = nestedManifestName,
						encryptedClass = EncryptedPatientHealthCareParty::class,
						decryptedClass = DecryptedPatientHealthCareParty::class,
					)
				lazy { pairLazy.value.decryptor }
			} ?: encryptorsFactoryContext.getEmptyEntityDecryptorProvider(
				encryptedClass = EncryptedPatientHealthCareParty::class,
				decryptedClass = DecryptedPatientHealthCareParty::class,
			)
		val financialInstitutionInformationDecryptor =
			manifest?.recursiveEncryption?.get("financialInstitutionInformation")?.let { nestedManifestName ->
				val pairLazy =
					encryptorsFactoryContext.getEntityEncryptorsProvider(
						entityManifestName = nestedManifestName,
						encryptedClass = EncryptedFinancialInstitutionInformation::class,
						decryptedClass = DecryptedFinancialInstitutionInformation::class,
					)
				lazy { pairLazy.value.decryptor }
			} ?: encryptorsFactoryContext.getEmptyEntityDecryptorProvider(
				encryptedClass = EncryptedFinancialInstitutionInformation::class,
				decryptedClass = DecryptedFinancialInstitutionInformation::class,
			)
		val medicalHouseContractsDecryptor =
			manifest?.recursiveEncryption?.get("medicalHouseContracts")?.let { nestedManifestName ->
				val pairLazy =
					encryptorsFactoryContext.getEntityEncryptorsProvider(
						entityManifestName = nestedManifestName,
						encryptedClass = EncryptedMedicalHouseContract::class,
						decryptedClass = DecryptedMedicalHouseContract::class,
					)
				lazy { pairLazy.value.decryptor }
			} ?: encryptorsFactoryContext.getEmptyEntityDecryptorProvider(
				encryptedClass = EncryptedMedicalHouseContract::class,
				decryptedClass = DecryptedMedicalHouseContract::class,
			)
		val propertiesDecryptor =
			manifest?.recursiveEncryption?.get("properties")?.let { nestedManifestName ->
				val pairLazy =
					encryptorsFactoryContext.getEntityEncryptorsProvider(
						entityManifestName = nestedManifestName,
						encryptedClass = EncryptedPropertyStub::class,
						decryptedClass = DecryptedPropertyStub::class,
					)
				lazy { pairLazy.value.decryptor }
			} ?: encryptorsFactoryContext.getEmptyEntityDecryptorProvider(
				encryptedClass = EncryptedPropertyStub::class,
				decryptedClass = DecryptedPropertyStub::class,
			)
		return PatientDecryptor(
			encryptedContentDecoder = encryptedContentDecoder,
			addressesDecryptor = addressesDecryptor,
			notesDecryptor = notesDecryptor,
			insurabilitiesDecryptor = insurabilitiesDecryptor,
			partnershipsDecryptor = partnershipsDecryptor,
			patientHealthCarePartiesDecryptor = patientHealthCarePartiesDecryptor,
			financialInstitutionInformationDecryptor = financialInstitutionInformationDecryptor,
			medicalHouseContractsDecryptor = medicalHouseContractsDecryptor,
			propertiesDecryptor = propertiesDecryptor,
			extensionsDecryptorsByVersion = extensionsDecryptorsByVersion,
			patchDecryptedSelfJson = patchDecryptedSelfJson,
			cryptoService = cryptoService,
			unversionedEntitiesDecryptedJsonStrictness = unversionedEntitiesDecryptedJsonStrictness,
		)
	}
}

@InternalIcureApi
private class PatientDecryptor(
	private val encryptedContentDecoder: Json,
	private val addressesDecryptor: Lazy<EntityDecryptor<EncryptedAddress, DecryptedAddress>>,
	private val notesDecryptor: Lazy<EntityDecryptor<EncryptedAnnotation, DecryptedAnnotation>>,
	private val insurabilitiesDecryptor: Lazy<EntityDecryptor<EncryptedInsurability, DecryptedInsurability>>,
	private val partnershipsDecryptor: Lazy<EntityDecryptor<EncryptedPartnership, DecryptedPartnership>>,
	private val patientHealthCarePartiesDecryptor: Lazy<EntityDecryptor<EncryptedPatientHealthCareParty, DecryptedPatientHealthCareParty>>,
	private val financialInstitutionInformationDecryptor:
		Lazy<EntityDecryptor<EncryptedFinancialInstitutionInformation, DecryptedFinancialInstitutionInformation>>,
	private val medicalHouseContractsDecryptor: Lazy<EntityDecryptor<EncryptedMedicalHouseContract, DecryptedMedicalHouseContract>>,
	private val propertiesDecryptor: Lazy<EntityDecryptor<EncryptedPropertyStub, DecryptedPropertyStub>>,
	private val extensionsDecryptorsByVersion: Map<CustomisedModelVersion, Lazy<ExtensionsEncryptors>>,
	patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
	cryptoService: CryptoService,
	unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
) : AbstractEntityDecryptor<EncryptedPatient, DecryptedPatient>(
		patchDecryptedSelfJson,
		cryptoService,
		unversionedEntitiesDecryptedJsonStrictness,
	) {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedPatient,
		customisedModelVersion: CustomisedModelVersion?,
	): DecryptedPatient {
		val extensions =
			if (customisedModelVersion != null) {
				val extensionsDecryptor =
					(
						extensionsDecryptorsByVersion[customisedModelVersion] ?: throw UnsupportedOperationException(
							"This instance of the SDK is not capable of handling Patient entities of version $customisedModelVersion.",
						)
					).value
				encryptedEntity.extensions?.let { extensionsDecryptor.decryptExtension(decryptionKeys, it) }
			} else {
				encryptedEntity.extensions
			}
		val entityCustomisedModelVersion = customisedModelVersion?.typeVersion
		val decryptedContent = decryptAndPatchContent(decryptionKeys, encryptedEntity)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedPatient(
				id = encryptedEntity.id,
				identifier =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["identifier"]?.also { usedEncryptedContent += "identifier" },
						encryptedEntity.identifier,
						entityCustomisedModelVersion,
					),
				rev = encryptedEntity.rev,
				created =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["created"]?.also { usedEncryptedContent += "created" },
						encryptedEntity.created,
						entityCustomisedModelVersion,
					),
				modified =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["modified"]?.also { usedEncryptedContent += "modified" },
						encryptedEntity.modified,
						entityCustomisedModelVersion,
					),
				author =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["author"]?.also { usedEncryptedContent += "author" },
						encryptedEntity.author,
						entityCustomisedModelVersion,
					),
				responsible =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["responsible"]?.also { usedEncryptedContent += "responsible" },
						encryptedEntity.responsible,
						entityCustomisedModelVersion,
					),
				tags =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["tags"]?.also { usedEncryptedContent += "tags" },
						encryptedEntity.tags,
						entityCustomisedModelVersion,
					),
				codes =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["codes"]?.also { usedEncryptedContent += "codes" },
						encryptedEntity.codes,
						entityCustomisedModelVersion,
					),
				deletionDate = encryptedEntity.deletionDate,
				firstName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["firstName"]?.also { usedEncryptedContent += "firstName" },
						encryptedEntity.firstName,
						entityCustomisedModelVersion,
					),
				lastName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["lastName"]?.also { usedEncryptedContent += "lastName" },
						encryptedEntity.lastName,
						entityCustomisedModelVersion,
					),
				names =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["names"]?.also { usedEncryptedContent += "names" },
						encryptedEntity.names,
						entityCustomisedModelVersion,
					),
				companyName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["companyName"]?.also { usedEncryptedContent += "companyName" },
						encryptedEntity.companyName,
						entityCustomisedModelVersion,
					),
				languages =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["languages"]?.also { usedEncryptedContent += "languages" },
						encryptedEntity.languages,
						entityCustomisedModelVersion,
					),
				addresses =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["addresses"]?.also { usedEncryptedContent += "addresses" },
						encryptedEntity.addresses.map { x0 ->
							addressesDecryptor.value.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								customisedModelVersion = customisedModelVersion,
							)
						},
						entityCustomisedModelVersion,
					),
				civility =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["civility"]?.also { usedEncryptedContent += "civility" },
						encryptedEntity.civility,
						entityCustomisedModelVersion,
					),
				gender =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["gender"]?.also { usedEncryptedContent += "gender" },
						encryptedEntity.gender,
						entityCustomisedModelVersion,
					),
				birthSex =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["birthSex"]?.also { usedEncryptedContent += "birthSex" },
						encryptedEntity.birthSex,
						entityCustomisedModelVersion,
					),
				mergeToPatientId = encryptedEntity.mergeToPatientId,
				mergedIds = encryptedEntity.mergedIds,
				alias =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["alias"]?.also { usedEncryptedContent += "alias" },
						encryptedEntity.alias,
						entityCustomisedModelVersion,
					),
				active =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["active"]?.also { usedEncryptedContent += "active" },
						encryptedEntity.active,
						entityCustomisedModelVersion,
					),
				deactivationReason =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["deactivationReason"]?.also { usedEncryptedContent += "deactivationReason" },
						encryptedEntity.deactivationReason,
						entityCustomisedModelVersion,
					),
				deactivationDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["deactivationDate"]?.also { usedEncryptedContent += "deactivationDate" },
						encryptedEntity.deactivationDate,
						entityCustomisedModelVersion,
					),
				ssin =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["ssin"]?.also { usedEncryptedContent += "ssin" },
						encryptedEntity.ssin,
						entityCustomisedModelVersion,
					),
				maidenName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["maidenName"]?.also { usedEncryptedContent += "maidenName" },
						encryptedEntity.maidenName,
						entityCustomisedModelVersion,
					),
				spouseName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["spouseName"]?.also { usedEncryptedContent += "spouseName" },
						encryptedEntity.spouseName,
						entityCustomisedModelVersion,
					),
				partnerName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["partnerName"]?.also { usedEncryptedContent += "partnerName" },
						encryptedEntity.partnerName,
						entityCustomisedModelVersion,
					),
				personalStatus =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["personalStatus"]?.also { usedEncryptedContent += "personalStatus" },
						encryptedEntity.personalStatus,
						entityCustomisedModelVersion,
					),
				dateOfBirth =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["dateOfBirth"]?.also { usedEncryptedContent += "dateOfBirth" },
						encryptedEntity.dateOfBirth,
						entityCustomisedModelVersion,
					),
				dateOfDeath =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["dateOfDeath"]?.also { usedEncryptedContent += "dateOfDeath" },
						encryptedEntity.dateOfDeath,
						entityCustomisedModelVersion,
					),
				timestampOfLatestEidReading =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["timestampOfLatestEidReading"]?.also { usedEncryptedContent += "timestampOfLatestEidReading" },
						encryptedEntity.timestampOfLatestEidReading,
						entityCustomisedModelVersion,
					),
				placeOfBirth =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["placeOfBirth"]?.also { usedEncryptedContent += "placeOfBirth" },
						encryptedEntity.placeOfBirth,
						entityCustomisedModelVersion,
					),
				placeOfDeath =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["placeOfDeath"]?.also { usedEncryptedContent += "placeOfDeath" },
						encryptedEntity.placeOfDeath,
						entityCustomisedModelVersion,
					),
				deceased =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["deceased"]?.also { usedEncryptedContent += "deceased" },
						encryptedEntity.deceased,
						entityCustomisedModelVersion,
					),
				education =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["education"]?.also { usedEncryptedContent += "education" },
						encryptedEntity.education,
						entityCustomisedModelVersion,
					),
				profession =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["profession"]?.also { usedEncryptedContent += "profession" },
						encryptedEntity.profession,
						entityCustomisedModelVersion,
					),
				notes =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["notes"]?.also { usedEncryptedContent += "notes" },
						encryptedEntity.notes.map { x0 ->
							notesDecryptor.value.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								customisedModelVersion = customisedModelVersion,
							)
						},
						entityCustomisedModelVersion,
					),
				note =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["note"]?.also { usedEncryptedContent += "note" },
						encryptedEntity.note,
						entityCustomisedModelVersion,
					),
				administrativeNote =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["administrativeNote"]?.also { usedEncryptedContent += "administrativeNote" },
						encryptedEntity.administrativeNote,
						entityCustomisedModelVersion,
					),
				nationality =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["nationality"]?.also { usedEncryptedContent += "nationality" },
						encryptedEntity.nationality,
						entityCustomisedModelVersion,
					),
				race =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["race"]?.also { usedEncryptedContent += "race" },
						encryptedEntity.race,
						entityCustomisedModelVersion,
					),
				ethnicity =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["ethnicity"]?.also { usedEncryptedContent += "ethnicity" },
						encryptedEntity.ethnicity,
						entityCustomisedModelVersion,
					),
				insurabilities =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["insurabilities"]?.also { usedEncryptedContent += "insurabilities" },
						encryptedEntity.insurabilities.map { x0 ->
							insurabilitiesDecryptor.value.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								customisedModelVersion = customisedModelVersion,
							)
						},
						entityCustomisedModelVersion,
					),
				partnerships =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["partnerships"]?.also { usedEncryptedContent += "partnerships" },
						encryptedEntity.partnerships.map { x0 ->
							partnershipsDecryptor.value.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								customisedModelVersion = customisedModelVersion,
							)
						},
						entityCustomisedModelVersion,
					),
				patientHealthCareParties =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["patientHealthCareParties"]?.also { usedEncryptedContent += "patientHealthCareParties" },
						encryptedEntity.patientHealthCareParties.map { x0 ->
							patientHealthCarePartiesDecryptor.value.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								customisedModelVersion = customisedModelVersion,
							)
						},
						entityCustomisedModelVersion,
					),
				financialInstitutionInformation =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["financialInstitutionInformation"]?.also { usedEncryptedContent += "financialInstitutionInformation" },
						encryptedEntity.financialInstitutionInformation.map { x0 ->
							financialInstitutionInformationDecryptor.value.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								customisedModelVersion = customisedModelVersion,
							)
						},
						entityCustomisedModelVersion,
					),
				medicalHouseContracts =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["medicalHouseContracts"]?.also { usedEncryptedContent += "medicalHouseContracts" },
						encryptedEntity.medicalHouseContracts.map { x0 ->
							medicalHouseContractsDecryptor.value.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								customisedModelVersion = customisedModelVersion,
							)
						},
						entityCustomisedModelVersion,
					),
				patientProfessions =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["patientProfessions"]?.also { usedEncryptedContent += "patientProfessions" },
						encryptedEntity.patientProfessions,
						entityCustomisedModelVersion,
					),
				parameters =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["parameters"]?.also { usedEncryptedContent += "parameters" },
						encryptedEntity.parameters,
						entityCustomisedModelVersion,
					),
				properties =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["properties"]?.also { usedEncryptedContent += "properties" },
						encryptedEntity.properties.mapTo(mutableSetOf()) { x0 ->
							propertiesDecryptor.value.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								customisedModelVersion = customisedModelVersion,
							)
						},
						entityCustomisedModelVersion,
					),
				hcPartyKeys = encryptedEntity.hcPartyKeys,
				aesExchangeKeys = encryptedEntity.aesExchangeKeys,
				transferKeys = encryptedEntity.transferKeys,
				privateKeyShamirPartitions = encryptedEntity.privateKeyShamirPartitions,
				publicKey = encryptedEntity.publicKey,
				publicKeysForOaepWithSha256 = encryptedEntity.publicKeysForOaepWithSha256,
				secretForeignKeys = encryptedEntity.secretForeignKeys,
				cryptedForeignKeys = encryptedEntity.cryptedForeignKeys,
				delegations = encryptedEntity.delegations,
				encryptionKeys = encryptedEntity.encryptionKeys,
				encryptedSelf = encryptedEntity.encryptedSelf,
				securityMetadata = encryptedEntity.securityMetadata,
				cryptoActorProperties = encryptedEntity.cryptoActorProperties,
				parentId = encryptedEntity.parentId,
				extensions = extensions,
				extensionsVersion = encryptedEntity.extensionsVersion,
			)
		if (entityCustomisedModelVersion == null &&
			unversionedEntitiesDecryptedJsonStrictness == DecryptedJsonStrictness.Strict &&
			decryptedContent.size != usedEncryptedContent.size
		) {
			throw UnexpectedEncryptedContentException(
				"The Patient encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
