// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.DecryptedJsonStrictness
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.collections.Collection

@InternalIcureApi
internal object PatientDecryptor : AbstractEntityDecryptor<EncryptedPatient, DecryptedPatient>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedPatient,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		decryptedJsonStrictness: DecryptedJsonStrictness,
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
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["identifier"]?.also { usedEncryptedContent += "identifier" },
						encryptedEntity.identifier,
						decryptedJsonStrictness,
					),
				rev = encryptedEntity.rev,
				created =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["created"]?.also { usedEncryptedContent += "created" },
						encryptedEntity.created,
						decryptedJsonStrictness,
					),
				modified =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["modified"]?.also { usedEncryptedContent += "modified" },
						encryptedEntity.modified,
						decryptedJsonStrictness,
					),
				author =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["author"]?.also { usedEncryptedContent += "author" },
						encryptedEntity.author,
						decryptedJsonStrictness,
					),
				responsible =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["responsible"]?.also { usedEncryptedContent += "responsible" },
						encryptedEntity.responsible,
						decryptedJsonStrictness,
					),
				tags =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["tags"]?.also { usedEncryptedContent += "tags" },
						encryptedEntity.tags,
						decryptedJsonStrictness,
					),
				codes =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["codes"]?.also { usedEncryptedContent += "codes" },
						encryptedEntity.codes,
						decryptedJsonStrictness,
					),
				deletionDate = encryptedEntity.deletionDate,
				firstName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["firstName"]?.also { usedEncryptedContent += "firstName" },
						encryptedEntity.firstName,
						decryptedJsonStrictness,
					),
				lastName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["lastName"]?.also { usedEncryptedContent += "lastName" },
						encryptedEntity.lastName,
						decryptedJsonStrictness,
					),
				names =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["names"]?.also { usedEncryptedContent += "names" },
						encryptedEntity.names,
						decryptedJsonStrictness,
					),
				companyName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["companyName"]?.also { usedEncryptedContent += "companyName" },
						encryptedEntity.companyName,
						decryptedJsonStrictness,
					),
				languages =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["languages"]?.also { usedEncryptedContent += "languages" },
						encryptedEntity.languages,
						decryptedJsonStrictness,
					),
				addresses =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["addresses"]?.also { usedEncryptedContent += "addresses" },
						encryptedEntity.addresses.map { x0 ->
							AddressDecryptor.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								patchDecryptedSelfJson = patchDecryptedSelfJson,
								decryptedJsonStrictness = decryptedJsonStrictness,
								encryptedContentDecoder = encryptedContentDecoder,
								cryptoService = cryptoService,
							)
						},
						decryptedJsonStrictness,
					),
				civility =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["civility"]?.also { usedEncryptedContent += "civility" },
						encryptedEntity.civility,
						decryptedJsonStrictness,
					),
				gender =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["gender"]?.also { usedEncryptedContent += "gender" },
						encryptedEntity.gender,
						decryptedJsonStrictness,
					),
				birthSex =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["birthSex"]?.also { usedEncryptedContent += "birthSex" },
						encryptedEntity.birthSex,
						decryptedJsonStrictness,
					),
				mergeToPatientId = encryptedEntity.mergeToPatientId,
				mergedIds = encryptedEntity.mergedIds,
				alias =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["alias"]?.also { usedEncryptedContent += "alias" },
						encryptedEntity.alias,
						decryptedJsonStrictness,
					),
				active =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["active"]?.also { usedEncryptedContent += "active" },
						encryptedEntity.active,
						decryptedJsonStrictness,
					),
				deactivationReason =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["deactivationReason"]?.also { usedEncryptedContent += "deactivationReason" },
						encryptedEntity.deactivationReason,
						decryptedJsonStrictness,
					),
				deactivationDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["deactivationDate"]?.also { usedEncryptedContent += "deactivationDate" },
						encryptedEntity.deactivationDate,
						decryptedJsonStrictness,
					),
				ssin =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["ssin"]?.also { usedEncryptedContent += "ssin" },
						encryptedEntity.ssin,
						decryptedJsonStrictness,
					),
				maidenName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["maidenName"]?.also { usedEncryptedContent += "maidenName" },
						encryptedEntity.maidenName,
						decryptedJsonStrictness,
					),
				spouseName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["spouseName"]?.also { usedEncryptedContent += "spouseName" },
						encryptedEntity.spouseName,
						decryptedJsonStrictness,
					),
				partnerName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["partnerName"]?.also { usedEncryptedContent += "partnerName" },
						encryptedEntity.partnerName,
						decryptedJsonStrictness,
					),
				personalStatus =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["personalStatus"]?.also { usedEncryptedContent += "personalStatus" },
						encryptedEntity.personalStatus,
						decryptedJsonStrictness,
					),
				dateOfBirth =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["dateOfBirth"]?.also { usedEncryptedContent += "dateOfBirth" },
						encryptedEntity.dateOfBirth,
						decryptedJsonStrictness,
					),
				dateOfDeath =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["dateOfDeath"]?.also { usedEncryptedContent += "dateOfDeath" },
						encryptedEntity.dateOfDeath,
						decryptedJsonStrictness,
					),
				timestampOfLatestEidReading =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["timestampOfLatestEidReading"]?.also { usedEncryptedContent += "timestampOfLatestEidReading" },
						encryptedEntity.timestampOfLatestEidReading,
						decryptedJsonStrictness,
					),
				placeOfBirth =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["placeOfBirth"]?.also { usedEncryptedContent += "placeOfBirth" },
						encryptedEntity.placeOfBirth,
						decryptedJsonStrictness,
					),
				placeOfDeath =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["placeOfDeath"]?.also { usedEncryptedContent += "placeOfDeath" },
						encryptedEntity.placeOfDeath,
						decryptedJsonStrictness,
					),
				deceased =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["deceased"]?.also { usedEncryptedContent += "deceased" },
						encryptedEntity.deceased,
						decryptedJsonStrictness,
					),
				education =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["education"]?.also { usedEncryptedContent += "education" },
						encryptedEntity.education,
						decryptedJsonStrictness,
					),
				profession =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["profession"]?.also { usedEncryptedContent += "profession" },
						encryptedEntity.profession,
						decryptedJsonStrictness,
					),
				notes =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["notes"]?.also { usedEncryptedContent += "notes" },
						encryptedEntity.notes.map { x0 ->
							AnnotationDecryptor.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								patchDecryptedSelfJson = patchDecryptedSelfJson,
								decryptedJsonStrictness = decryptedJsonStrictness,
								encryptedContentDecoder = encryptedContentDecoder,
								cryptoService = cryptoService,
							)
						},
						decryptedJsonStrictness,
					),
				note =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["note"]?.also { usedEncryptedContent += "note" },
						encryptedEntity.note,
						decryptedJsonStrictness,
					),
				administrativeNote =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["administrativeNote"]?.also { usedEncryptedContent += "administrativeNote" },
						encryptedEntity.administrativeNote,
						decryptedJsonStrictness,
					),
				nationality =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["nationality"]?.also { usedEncryptedContent += "nationality" },
						encryptedEntity.nationality,
						decryptedJsonStrictness,
					),
				race =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["race"]?.also { usedEncryptedContent += "race" },
						encryptedEntity.race,
						decryptedJsonStrictness,
					),
				ethnicity =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["ethnicity"]?.also { usedEncryptedContent += "ethnicity" },
						encryptedEntity.ethnicity,
						decryptedJsonStrictness,
					),
				insurabilities =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["insurabilities"]?.also { usedEncryptedContent += "insurabilities" },
						encryptedEntity.insurabilities.map { x0 ->
							InsurabilityDecryptor.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								patchDecryptedSelfJson = patchDecryptedSelfJson,
								decryptedJsonStrictness = decryptedJsonStrictness,
								encryptedContentDecoder = encryptedContentDecoder,
								cryptoService = cryptoService,
							)
						},
						decryptedJsonStrictness,
					),
				partnerships =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["partnerships"]?.also { usedEncryptedContent += "partnerships" },
						encryptedEntity.partnerships.map { x0 ->
							PartnershipDecryptor.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								patchDecryptedSelfJson = patchDecryptedSelfJson,
								decryptedJsonStrictness = decryptedJsonStrictness,
								encryptedContentDecoder = encryptedContentDecoder,
								cryptoService = cryptoService,
							)
						},
						decryptedJsonStrictness,
					),
				patientHealthCareParties =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["patientHealthCareParties"]?.also { usedEncryptedContent += "patientHealthCareParties" },
						encryptedEntity.patientHealthCareParties.map { x0 ->
							PatientHealthCarePartyDecryptor.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								patchDecryptedSelfJson = patchDecryptedSelfJson,
								decryptedJsonStrictness = decryptedJsonStrictness,
								encryptedContentDecoder = encryptedContentDecoder,
								cryptoService = cryptoService,
							)
						},
						decryptedJsonStrictness,
					),
				financialInstitutionInformation =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["financialInstitutionInformation"]?.also { usedEncryptedContent += "financialInstitutionInformation" },
						encryptedEntity.financialInstitutionInformation.map { x0 ->
							FinancialInstitutionInformationDecryptor.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								patchDecryptedSelfJson = patchDecryptedSelfJson,
								decryptedJsonStrictness = decryptedJsonStrictness,
								encryptedContentDecoder = encryptedContentDecoder,
								cryptoService = cryptoService,
							)
						},
						decryptedJsonStrictness,
					),
				medicalHouseContracts =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["medicalHouseContracts"]?.also { usedEncryptedContent += "medicalHouseContracts" },
						encryptedEntity.medicalHouseContracts.map { x0 ->
							MedicalHouseContractDecryptor.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								patchDecryptedSelfJson = patchDecryptedSelfJson,
								decryptedJsonStrictness = decryptedJsonStrictness,
								encryptedContentDecoder = encryptedContentDecoder,
								cryptoService = cryptoService,
							)
						},
						decryptedJsonStrictness,
					),
				patientProfessions =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["patientProfessions"]?.also { usedEncryptedContent += "patientProfessions" },
						encryptedEntity.patientProfessions,
						decryptedJsonStrictness,
					),
				parameters =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["parameters"]?.also { usedEncryptedContent += "parameters" },
						encryptedEntity.parameters,
						decryptedJsonStrictness,
					),
				properties =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["properties"]?.also { usedEncryptedContent += "properties" },
						encryptedEntity.properties.mapTo(mutableSetOf()) { x0 ->
							PropertyStubDecryptor.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								patchDecryptedSelfJson = patchDecryptedSelfJson,
								decryptedJsonStrictness = decryptedJsonStrictness,
								encryptedContentDecoder = encryptedContentDecoder,
								cryptoService = cryptoService,
							)
						},
						decryptedJsonStrictness,
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
				extensions = encryptedEntity.extensions,
				extensionsVersion = encryptedEntity.extensionsVersion,
			)
		if (decryptedJsonStrictness == DecryptedJsonStrictness.Strict && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The Patient encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
