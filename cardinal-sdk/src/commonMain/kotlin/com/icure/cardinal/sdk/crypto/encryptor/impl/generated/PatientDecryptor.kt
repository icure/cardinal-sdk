// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object PatientDecryptor : AbstractEntityDecryptor<EncryptedPatient, DecryptedPatient>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedPatient,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedPatient {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedPatient(
				id = encryptedEntity.id,
				identifier =
					decryptedContent["identifier"].let {
						if (it != null) {
							usedEncryptedContent += "identifier"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.identifier
						}
					},
				rev = encryptedEntity.rev,
				created =
					decryptedContent["created"].let {
						if (it != null) {
							usedEncryptedContent += "created"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.created
						}
					},
				modified =
					decryptedContent["modified"].let {
						if (it != null) {
							usedEncryptedContent += "modified"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.modified
						}
					},
				author =
					decryptedContent["author"].let {
						if (it != null) {
							usedEncryptedContent += "author"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.author
						}
					},
				responsible =
					decryptedContent["responsible"].let {
						if (it != null) {
							usedEncryptedContent += "responsible"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.responsible
						}
					},
				tags =
					decryptedContent["tags"].let {
						if (it != null) {
							usedEncryptedContent += "tags"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.tags
						}
					},
				codes =
					decryptedContent["codes"].let {
						if (it != null) {
							usedEncryptedContent += "codes"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.codes
						}
					},
				deletionDate = encryptedEntity.deletionDate,
				firstName =
					decryptedContent["firstName"].let {
						if (it != null) {
							usedEncryptedContent += "firstName"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.firstName
						}
					},
				lastName =
					decryptedContent["lastName"].let {
						if (it != null) {
							usedEncryptedContent += "lastName"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.lastName
						}
					},
				names =
					decryptedContent["names"].let {
						if (it != null) {
							usedEncryptedContent += "names"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.names
						}
					},
				companyName =
					decryptedContent["companyName"].let {
						if (it != null) {
							usedEncryptedContent += "companyName"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.companyName
						}
					},
				languages =
					decryptedContent["languages"].let {
						if (it != null) {
							usedEncryptedContent += "languages"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.languages
						}
					},
				addresses =
					decryptedContent["addresses"].let {
						if (it != null) {
							usedEncryptedContent += "addresses"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.addresses.map { x0 ->
								AddressDecryptor.decrypt(
									decryptionKeys = decryptionKeys,
									encryptedEntity = x0,
									patchDecryptedSelfJson = patchDecryptedSelfJson,
									ignoreUnknownDecryptedFields = ignoreUnknownDecryptedFields,
									encryptedContentDecoder = encryptedContentDecoder,
									cryptoService = cryptoService,
								)
							}
						}
					},
				civility =
					decryptedContent["civility"].let {
						if (it != null) {
							usedEncryptedContent += "civility"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.civility
						}
					},
				gender =
					decryptedContent["gender"].let {
						if (it != null) {
							usedEncryptedContent += "gender"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.gender
						}
					},
				birthSex =
					decryptedContent["birthSex"].let {
						if (it != null) {
							usedEncryptedContent += "birthSex"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.birthSex
						}
					},
				mergeToPatientId = encryptedEntity.mergeToPatientId,
				mergedIds = encryptedEntity.mergedIds,
				alias =
					decryptedContent["alias"].let {
						if (it != null) {
							usedEncryptedContent += "alias"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.alias
						}
					},
				active =
					decryptedContent["active"].let {
						if (it != null) {
							usedEncryptedContent += "active"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.active
						}
					},
				deactivationReason =
					decryptedContent["deactivationReason"].let {
						if (it != null) {
							usedEncryptedContent += "deactivationReason"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.deactivationReason
						}
					},
				deactivationDate =
					decryptedContent["deactivationDate"].let {
						if (it != null) {
							usedEncryptedContent += "deactivationDate"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.deactivationDate
						}
					},
				ssin =
					decryptedContent["ssin"].let {
						if (it != null) {
							usedEncryptedContent += "ssin"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.ssin
						}
					},
				maidenName =
					decryptedContent["maidenName"].let {
						if (it != null) {
							usedEncryptedContent += "maidenName"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.maidenName
						}
					},
				spouseName =
					decryptedContent["spouseName"].let {
						if (it != null) {
							usedEncryptedContent += "spouseName"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.spouseName
						}
					},
				partnerName =
					decryptedContent["partnerName"].let {
						if (it != null) {
							usedEncryptedContent += "partnerName"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.partnerName
						}
					},
				personalStatus =
					decryptedContent["personalStatus"].let {
						if (it != null) {
							usedEncryptedContent += "personalStatus"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.personalStatus
						}
					},
				dateOfBirth =
					decryptedContent["dateOfBirth"].let {
						if (it != null) {
							usedEncryptedContent += "dateOfBirth"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.dateOfBirth
						}
					},
				dateOfDeath =
					decryptedContent["dateOfDeath"].let {
						if (it != null) {
							usedEncryptedContent += "dateOfDeath"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.dateOfDeath
						}
					},
				timestampOfLatestEidReading =
					decryptedContent["timestampOfLatestEidReading"].let {
						if (it != null) {
							usedEncryptedContent += "timestampOfLatestEidReading"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.timestampOfLatestEidReading
						}
					},
				placeOfBirth =
					decryptedContent["placeOfBirth"].let {
						if (it != null) {
							usedEncryptedContent += "placeOfBirth"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.placeOfBirth
						}
					},
				placeOfDeath =
					decryptedContent["placeOfDeath"].let {
						if (it != null) {
							usedEncryptedContent += "placeOfDeath"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.placeOfDeath
						}
					},
				deceased =
					decryptedContent["deceased"].let {
						if (it != null) {
							usedEncryptedContent += "deceased"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.deceased
						}
					},
				education =
					decryptedContent["education"].let {
						if (it != null) {
							usedEncryptedContent += "education"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.education
						}
					},
				profession =
					decryptedContent["profession"].let {
						if (it != null) {
							usedEncryptedContent += "profession"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.profession
						}
					},
				notes =
					decryptedContent["notes"].let {
						if (it != null) {
							usedEncryptedContent += "notes"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.notes.map { x0 ->
								AnnotationDecryptor.decrypt(
									decryptionKeys = decryptionKeys,
									encryptedEntity = x0,
									patchDecryptedSelfJson = patchDecryptedSelfJson,
									ignoreUnknownDecryptedFields = ignoreUnknownDecryptedFields,
									encryptedContentDecoder = encryptedContentDecoder,
									cryptoService = cryptoService,
								)
							}
						}
					},
				note =
					decryptedContent["note"].let {
						if (it != null) {
							usedEncryptedContent += "note"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.note
						}
					},
				administrativeNote =
					decryptedContent["administrativeNote"].let {
						if (it != null) {
							usedEncryptedContent += "administrativeNote"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.administrativeNote
						}
					},
				nationality =
					decryptedContent["nationality"].let {
						if (it != null) {
							usedEncryptedContent += "nationality"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.nationality
						}
					},
				race =
					decryptedContent["race"].let {
						if (it != null) {
							usedEncryptedContent += "race"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.race
						}
					},
				ethnicity =
					decryptedContent["ethnicity"].let {
						if (it != null) {
							usedEncryptedContent += "ethnicity"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.ethnicity
						}
					},
				insurabilities =
					decryptedContent["insurabilities"].let {
						if (it != null) {
							usedEncryptedContent += "insurabilities"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.insurabilities.map { x0 ->
								InsurabilityDecryptor.decrypt(
									decryptionKeys = decryptionKeys,
									encryptedEntity = x0,
									patchDecryptedSelfJson = patchDecryptedSelfJson,
									ignoreUnknownDecryptedFields = ignoreUnknownDecryptedFields,
									encryptedContentDecoder = encryptedContentDecoder,
									cryptoService = cryptoService,
								)
							}
						}
					},
				partnerships =
					decryptedContent["partnerships"].let {
						if (it != null) {
							usedEncryptedContent += "partnerships"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.partnerships.map { x0 ->
								PartnershipDecryptor.decrypt(
									decryptionKeys = decryptionKeys,
									encryptedEntity = x0,
									patchDecryptedSelfJson = patchDecryptedSelfJson,
									ignoreUnknownDecryptedFields = ignoreUnknownDecryptedFields,
									encryptedContentDecoder = encryptedContentDecoder,
									cryptoService = cryptoService,
								)
							}
						}
					},
				patientHealthCareParties =
					decryptedContent["patientHealthCareParties"].let {
						if (it != null) {
							usedEncryptedContent += "patientHealthCareParties"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.patientHealthCareParties.map { x0 ->
								PatientHealthCarePartyDecryptor.decrypt(
									decryptionKeys = decryptionKeys,
									encryptedEntity = x0,
									patchDecryptedSelfJson = patchDecryptedSelfJson,
									ignoreUnknownDecryptedFields = ignoreUnknownDecryptedFields,
									encryptedContentDecoder = encryptedContentDecoder,
									cryptoService = cryptoService,
								)
							}
						}
					},
				financialInstitutionInformation =
					decryptedContent["financialInstitutionInformation"].let {
						if (it != null) {
							usedEncryptedContent += "financialInstitutionInformation"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.financialInstitutionInformation.map { x0 ->
								FinancialInstitutionInformationDecryptor.decrypt(
									decryptionKeys = decryptionKeys,
									encryptedEntity = x0,
									patchDecryptedSelfJson = patchDecryptedSelfJson,
									ignoreUnknownDecryptedFields = ignoreUnknownDecryptedFields,
									encryptedContentDecoder = encryptedContentDecoder,
									cryptoService = cryptoService,
								)
							}
						}
					},
				medicalHouseContracts =
					decryptedContent["medicalHouseContracts"].let {
						if (it != null) {
							usedEncryptedContent += "medicalHouseContracts"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.medicalHouseContracts.map { x0 ->
								MedicalHouseContractDecryptor.decrypt(
									decryptionKeys = decryptionKeys,
									encryptedEntity = x0,
									patchDecryptedSelfJson = patchDecryptedSelfJson,
									ignoreUnknownDecryptedFields = ignoreUnknownDecryptedFields,
									encryptedContentDecoder = encryptedContentDecoder,
									cryptoService = cryptoService,
								)
							}
						}
					},
				patientProfessions =
					decryptedContent["patientProfessions"].let {
						if (it != null) {
							usedEncryptedContent += "patientProfessions"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.patientProfessions
						}
					},
				parameters =
					decryptedContent["parameters"].let {
						if (it != null) {
							usedEncryptedContent += "parameters"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.parameters
						}
					},
				properties =
					decryptedContent["properties"].let {
						if (it != null) {
							usedEncryptedContent += "properties"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.properties.mapTo(mutableSetOf()) { x0 ->
								PropertyStubDecryptor.decrypt(
									decryptionKeys = decryptionKeys,
									encryptedEntity = x0,
									patchDecryptedSelfJson = patchDecryptedSelfJson,
									ignoreUnknownDecryptedFields = ignoreUnknownDecryptedFields,
									encryptedContentDecoder = encryptedContentDecoder,
									cryptoService = cryptoService,
								)
							}
						}
					},
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
				extensions = encryptedEntity.extensions,
				extensionsVersion = encryptedEntity.extensionsVersion,
			)
		if (!ignoreUnknownDecryptedFields && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The Patient encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
