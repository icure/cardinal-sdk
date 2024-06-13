package com.icure.sdk.js.model

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.CheckedConverters.objectToMapNullsafe
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.base.CodeStubJs
import com.icure.sdk.js.model.base.IdentifierJs
import com.icure.sdk.js.model.base.codeStub_fromJs
import com.icure.sdk.js.model.base.codeStub_toJs
import com.icure.sdk.js.model.base.identifier_fromJs
import com.icure.sdk.js.model.base.identifier_toJs
import com.icure.sdk.js.model.embed.DecryptedAddressJs
import com.icure.sdk.js.model.embed.DecryptedFinancialInstitutionInformationJs
import com.icure.sdk.js.model.embed.DecryptedFlatRateTarificationJs
import com.icure.sdk.js.model.embed.HealthcarePartyHistoryStatusJs
import com.icure.sdk.js.model.embed.PersonNameJs
import com.icure.sdk.js.model.embed.address_fromJs
import com.icure.sdk.js.model.embed.address_toJs
import com.icure.sdk.js.model.embed.financialInstitutionInformation_fromJs
import com.icure.sdk.js.model.embed.financialInstitutionInformation_toJs
import com.icure.sdk.js.model.embed.flatRateTarification_fromJs
import com.icure.sdk.js.model.embed.flatRateTarification_toJs
import com.icure.sdk.js.model.embed.healthcarePartyHistoryStatus_fromJs
import com.icure.sdk.js.model.embed.healthcarePartyHistoryStatus_toJs
import com.icure.sdk.js.model.embed.personName_fromJs
import com.icure.sdk.js.model.embed.personName_toJs
import com.icure.sdk.js.model.specializations.aesExchangeKeyEncryptionKeypairIdentifier_fromJs
import com.icure.sdk.js.model.specializations.aesExchangeKeyEncryptionKeypairIdentifier_toJs
import com.icure.sdk.js.model.specializations.hexString_fromJs
import com.icure.sdk.js.model.specializations.hexString_toJs
import com.icure.sdk.js.model.specializations.spkiHexString_fromJs
import com.icure.sdk.js.model.specializations.spkiHexString_toJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.model.DecryptedPropertyStub
import com.icure.sdk.model.HealthcareParty
import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.embed.DecryptedAddress
import com.icure.sdk.model.embed.DecryptedFinancialInstitutionInformation
import com.icure.sdk.model.embed.DecryptedFlatRateTarification
import com.icure.sdk.model.embed.Gender
import com.icure.sdk.model.embed.HealthcarePartyHistoryStatus
import com.icure.sdk.model.embed.HealthcarePartyStatus
import com.icure.sdk.model.embed.PersonName
import com.icure.sdk.model.embed.TelecomType
import com.icure.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.model.specializations.SpkiHexString
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map

@Suppress("UNUSED_VARIABLE")
public fun healthcareParty_toJs(obj: HealthcareParty): HealthcarePartyJs {
	val id = obj.id
	val rev = obj.rev ?: undefined
	val created = longToNumber(obj.created) ?: undefined
	val modified = longToNumber(obj.modified) ?: undefined
	val deletionDate = longToNumber(obj.deletionDate) ?: undefined
	val identifier = listToArray(
		obj.identifier,
		{ x1: Identifier ->
			identifier_toJs(x1)
		},
	)
	val tags = setToArray(
		obj.tags,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val codes = setToArray(
		obj.codes,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val name = obj.name ?: undefined
	val lastName = obj.lastName ?: undefined
	val firstName = obj.firstName ?: undefined
	val names = listToArray(
		obj.names,
		{ x1: PersonName ->
			personName_toJs(x1)
		},
	)
	val gender = obj.gender?.let { nonNull1 ->
		nonNull1.name
	} ?: undefined
	val civility = obj.civility ?: undefined
	val companyName = obj.companyName ?: undefined
	val speciality = obj.speciality ?: undefined
	val bankAccount = obj.bankAccount ?: undefined
	val bic = obj.bic ?: undefined
	val proxyBankAccount = obj.proxyBankAccount ?: undefined
	val proxyBic = obj.proxyBic ?: undefined
	val invoiceHeader = obj.invoiceHeader ?: undefined
	val cbe = obj.cbe ?: undefined
	val ehp = obj.ehp ?: undefined
	val userId = obj.userId ?: undefined
	val parentId = obj.parentId ?: undefined
	val convention = intToNumber(obj.convention) ?: undefined
	val nihii = obj.nihii ?: undefined
	val nihiiSpecCode = obj.nihiiSpecCode ?: undefined
	val ssin = obj.ssin ?: undefined
	val addresses = listToArray(
		obj.addresses,
		{ x1: DecryptedAddress ->
			address_toJs(x1)
		},
	)
	val languages = listToArray(
		obj.languages,
		{ x1: String ->
			x1
		},
	)
	val picture = obj.picture ?: undefined
	val statuses = setToArray(
		obj.statuses,
		{ x1: HealthcarePartyStatus ->
			x1.name
		},
	)
	val statusHistory = listToArray(
		obj.statusHistory,
		{ x1: HealthcarePartyHistoryStatus ->
			healthcarePartyHistoryStatus_toJs(x1)
		},
	)
	val specialityCodes = setToArray(
		obj.specialityCodes,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val sendFormats = mapToObject(
		obj.sendFormats,
		{ x1: TelecomType ->
			x1.name
		},
		{ x1: String ->
			x1
		},
	)
	val notes = obj.notes ?: undefined
	val financialInstitutionInformation = listToArray(
		obj.financialInstitutionInformation,
		{ x1: DecryptedFinancialInstitutionInformation ->
			financialInstitutionInformation_toJs(x1)
		},
	)
	val descr = mapToObject(
		obj.descr,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	) ?: undefined
	val billingType = obj.billingType ?: undefined
	val type = obj.type ?: undefined
	val contactPerson = obj.contactPerson ?: undefined
	val contactPersonHcpId = obj.contactPersonHcpId ?: undefined
	val supervisorId = obj.supervisorId ?: undefined
	val flatRateTarifications = listToArray(
		obj.flatRateTarifications,
		{ x1: DecryptedFlatRateTarification ->
			flatRateTarification_toJs(x1)
		},
	)
	val importedData = mapToObject(
		obj.importedData,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val options = mapToObject(
		obj.options,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val properties = setToArray(
		obj.properties,
		{ x1: DecryptedPropertyStub ->
			propertyStub_toJs(x1)
		},
	)
	val hcPartyKeys = mapToObject(
		obj.hcPartyKeys,
		{ x1: String ->
			x1
		},
		{ x1: List<HexString> ->
			listToArray(
				x1,
				{ x2: HexString ->
					hexString_toJs(x2)
				},
			)
		},
	)
	val aesExchangeKeys = mapToObject(
		obj.aesExchangeKeys,
		{ x1: SpkiHexString ->
			spkiHexString_toJs(x1)
		},
		{ x1: Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> ->
			mapToObject(
				x1,
				{ x2: String ->
					x2
				},
				{ x2: Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString> ->
					mapToObject(
						x2,
						{ x3: AesExchangeKeyEncryptionKeypairIdentifier ->
							aesExchangeKeyEncryptionKeypairIdentifier_toJs(x3)
						},
						{ x3: HexString ->
							hexString_toJs(x3)
						},
					)
				},
			)
		},
	)
	val transferKeys = mapToObject(
		obj.transferKeys,
		{ x1: AesExchangeKeyEncryptionKeypairIdentifier ->
			aesExchangeKeyEncryptionKeypairIdentifier_toJs(x1)
		},
		{ x1: Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString> ->
			mapToObject(
				x1,
				{ x2: AesExchangeKeyEncryptionKeypairIdentifier ->
					aesExchangeKeyEncryptionKeypairIdentifier_toJs(x2)
				},
				{ x2: HexString ->
					hexString_toJs(x2)
				},
			)
		},
	)
	val privateKeyShamirPartitions = mapToObject(
		obj.privateKeyShamirPartitions,
		{ x1: String ->
			x1
		},
		{ x1: HexString ->
			hexString_toJs(x1)
		},
	)
	val publicKey = obj.publicKey?.let { nonNull1 ->
		spkiHexString_toJs(nonNull1)
	} ?: undefined
	val publicKeysForOaepWithSha256 = setToArray(
		obj.publicKeysForOaepWithSha256,
		{ x1: SpkiHexString ->
			spkiHexString_toJs(x1)
		},
	)
	return HealthcarePartyJs(js("{" +
		"id:id," +
		"rev:rev," +
		"created:created," +
		"modified:modified," +
		"deletionDate:deletionDate," +
		"identifier:identifier," +
		"tags:tags," +
		"codes:codes," +
		"name:name," +
		"lastName:lastName," +
		"firstName:firstName," +
		"names:names," +
		"gender:gender," +
		"civility:civility," +
		"companyName:companyName," +
		"speciality:speciality," +
		"bankAccount:bankAccount," +
		"bic:bic," +
		"proxyBankAccount:proxyBankAccount," +
		"proxyBic:proxyBic," +
		"invoiceHeader:invoiceHeader," +
		"cbe:cbe," +
		"ehp:ehp," +
		"userId:userId," +
		"parentId:parentId," +
		"convention:convention," +
		"nihii:nihii," +
		"nihiiSpecCode:nihiiSpecCode," +
		"ssin:ssin," +
		"addresses:addresses," +
		"languages:languages," +
		"picture:picture," +
		"statuses:statuses," +
		"statusHistory:statusHistory," +
		"specialityCodes:specialityCodes," +
		"sendFormats:sendFormats," +
		"notes:notes," +
		"financialInstitutionInformation:financialInstitutionInformation," +
		"descr:descr," +
		"billingType:billingType," +
		"type:type," +
		"contactPerson:contactPerson," +
		"contactPersonHcpId:contactPersonHcpId," +
		"supervisorId:supervisorId," +
		"flatRateTarifications:flatRateTarifications," +
		"importedData:importedData," +
		"options:options," +
		"properties:properties," +
		"hcPartyKeys:hcPartyKeys," +
		"aesExchangeKeys:aesExchangeKeys," +
		"transferKeys:transferKeys," +
		"privateKeyShamirPartitions:privateKeyShamirPartitions," +
		"publicKey:publicKey," +
		"publicKeysForOaepWithSha256:publicKeysForOaepWithSha256" +
	"}"))
}

public fun healthcareParty_fromJs(obj: HealthcarePartyJs): HealthcareParty {
	val id = obj.id
	val rev = obj.rev
	val created = numberToLong(obj.created, "obj.created")
	val modified = numberToLong(obj.modified, "obj.modified")
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val identifier = arrayToList(
		obj.identifier,
		"obj.identifier",
		{ x1: IdentifierJs ->
			identifier_fromJs(x1)
		},
	)
	val tags = arrayToSet(
		obj.tags,
		"obj.tags",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val codes = arrayToSet(
		obj.codes,
		"obj.codes",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val name = obj.name
	val lastName = obj.lastName
	val firstName = obj.firstName
	val names = arrayToList(
		obj.names,
		"obj.names",
		{ x1: PersonNameJs ->
			personName_fromJs(x1)
		},
	)
	val gender = obj.gender?.let { nonNull1 ->
		Gender.valueOf(nonNull1)
	}
	val civility = obj.civility
	val companyName = obj.companyName
	val speciality = obj.speciality
	val bankAccount = obj.bankAccount
	val bic = obj.bic
	val proxyBankAccount = obj.proxyBankAccount
	val proxyBic = obj.proxyBic
	val invoiceHeader = obj.invoiceHeader
	val cbe = obj.cbe
	val ehp = obj.ehp
	val userId = obj.userId
	val parentId = obj.parentId
	val convention = numberToInt(obj.convention, "obj.convention")
	val nihii = obj.nihii
	val nihiiSpecCode = obj.nihiiSpecCode
	val ssin = obj.ssin
	val addresses = arrayToList(
		obj.addresses,
		"obj.addresses",
		{ x1: DecryptedAddressJs ->
			address_fromJs(x1)
		},
	)
	val languages = arrayToList(
		obj.languages,
		"obj.languages",
		{ x1: String ->
			x1
		},
	)
	val picture = obj.picture
	val statuses = arrayToSet(
		obj.statuses,
		"obj.statuses",
		{ x1: String ->
			HealthcarePartyStatus.valueOf(x1)
		},
	)
	val statusHistory = arrayToList(
		obj.statusHistory,
		"obj.statusHistory",
		{ x1: HealthcarePartyHistoryStatusJs ->
			healthcarePartyHistoryStatus_fromJs(x1)
		},
	)
	val specialityCodes = arrayToSet(
		obj.specialityCodes,
		"obj.specialityCodes",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val sendFormats = objectToMap(
		obj.sendFormats,
		"obj.sendFormats",
		{ x1: String ->
			TelecomType.valueOf(x1)
		},
		{ x1: String ->
			x1
		},
	)
	val notes = obj.notes
	val financialInstitutionInformation = arrayToList(
		obj.financialInstitutionInformation,
		"obj.financialInstitutionInformation",
		{ x1: DecryptedFinancialInstitutionInformationJs ->
			financialInstitutionInformation_fromJs(x1)
		},
	)
	val descr = objectToMapNullsafe(
		obj.descr,
		"obj.descr",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val billingType = obj.billingType
	val type = obj.type
	val contactPerson = obj.contactPerson
	val contactPersonHcpId = obj.contactPersonHcpId
	val supervisorId = obj.supervisorId
	val flatRateTarifications = arrayToList(
		obj.flatRateTarifications,
		"obj.flatRateTarifications",
		{ x1: DecryptedFlatRateTarificationJs ->
			flatRateTarification_fromJs(x1)
		},
	)
	val importedData = objectToMap(
		obj.importedData,
		"obj.importedData",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val options = objectToMap(
		obj.options,
		"obj.options",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val properties = arrayToSet(
		obj.properties,
		"obj.properties",
		{ x1: DecryptedPropertyStubJs ->
			propertyStub_fromJs(x1)
		},
	)
	val hcPartyKeys = objectToMap(
		obj.hcPartyKeys,
		"obj.hcPartyKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<String> ->
			arrayToList(
				x1,
				"x1",
				{ x2: String ->
					hexString_fromJs(x2)
				},
			)
		},
	)
	val aesExchangeKeys = objectToMap(
		obj.aesExchangeKeys,
		"obj.aesExchangeKeys",
		{ x1: String ->
			spkiHexString_fromJs(x1)
		},
		{ x1: Record<String, Record<String, String>> ->
			objectToMap(
				x1,
				"x1",
				{ x2: String ->
					x2
				},
				{ x2: Record<String, String> ->
					objectToMap(
						x2,
						"x2",
						{ x3: String ->
							aesExchangeKeyEncryptionKeypairIdentifier_fromJs(x3)
						},
						{ x3: String ->
							hexString_fromJs(x3)
						},
					)
				},
			)
		},
	)
	val transferKeys = objectToMap(
		obj.transferKeys,
		"obj.transferKeys",
		{ x1: String ->
			aesExchangeKeyEncryptionKeypairIdentifier_fromJs(x1)
		},
		{ x1: Record<String, String> ->
			objectToMap(
				x1,
				"x1",
				{ x2: String ->
					aesExchangeKeyEncryptionKeypairIdentifier_fromJs(x2)
				},
				{ x2: String ->
					hexString_fromJs(x2)
				},
			)
		},
	)
	val privateKeyShamirPartitions = objectToMap(
		obj.privateKeyShamirPartitions,
		"obj.privateKeyShamirPartitions",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			hexString_fromJs(x1)
		},
	)
	val publicKey = obj.publicKey?.let { nonNull1 ->
		spkiHexString_fromJs(nonNull1)
	}
	val publicKeysForOaepWithSha256 = arrayToSet(
		obj.publicKeysForOaepWithSha256,
		"obj.publicKeysForOaepWithSha256",
		{ x1: String ->
			spkiHexString_fromJs(x1)
		},
	)
	return HealthcareParty(
		id = id,
		rev = rev,
		created = created,
		modified = modified,
		deletionDate = deletionDate,
		identifier = identifier,
		tags = tags,
		codes = codes,
		name = name,
		lastName = lastName,
		firstName = firstName,
		names = names,
		gender = gender,
		civility = civility,
		companyName = companyName,
		speciality = speciality,
		bankAccount = bankAccount,
		bic = bic,
		proxyBankAccount = proxyBankAccount,
		proxyBic = proxyBic,
		invoiceHeader = invoiceHeader,
		cbe = cbe,
		ehp = ehp,
		userId = userId,
		parentId = parentId,
		convention = convention,
		nihii = nihii,
		nihiiSpecCode = nihiiSpecCode,
		ssin = ssin,
		addresses = addresses,
		languages = languages,
		picture = picture,
		statuses = statuses,
		statusHistory = statusHistory,
		specialityCodes = specialityCodes,
		sendFormats = sendFormats,
		notes = notes,
		financialInstitutionInformation = financialInstitutionInformation,
		descr = descr,
		billingType = billingType,
		type = type,
		contactPerson = contactPerson,
		contactPersonHcpId = contactPersonHcpId,
		supervisorId = supervisorId,
		flatRateTarifications = flatRateTarifications,
		importedData = importedData,
		options = options,
		properties = properties,
		hcPartyKeys = hcPartyKeys,
		aesExchangeKeys = aesExchangeKeys,
		transferKeys = transferKeys,
		privateKeyShamirPartitions = privateKeyShamirPartitions,
		publicKey = publicKey,
		publicKeysForOaepWithSha256 = publicKeysForOaepWithSha256,
	)
}
