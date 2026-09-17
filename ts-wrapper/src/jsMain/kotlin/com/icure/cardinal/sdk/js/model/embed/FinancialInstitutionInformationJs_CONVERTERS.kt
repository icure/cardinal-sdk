// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.specializations.base64String_fromJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_toJs
import com.icure.cardinal.sdk.model.embed.DecryptedFinancialInstitutionInformation
import com.icure.cardinal.sdk.model.embed.EncryptedFinancialInstitutionInformation
import com.icure.cardinal.sdk.model.embed.FinancialInstitutionInformation
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun financialInstitutionInformation_toJs(obj: DecryptedFinancialInstitutionInformation): DecryptedFinancialInstitutionInformationJs {
	val name = nullToUndefined(
		obj.name
	)
	val key = nullToUndefined(
		obj.key
	)
	val bankAccount = nullToUndefined(
		obj.bankAccount
	)
	val bic = nullToUndefined(
		obj.bic
	)
	val proxyBankAccount = nullToUndefined(
		obj.proxyBankAccount
	)
	val proxyBic = nullToUndefined(
		obj.proxyBic
	)
	val preferredFiiForPartners = setToArray(
		obj.preferredFiiForPartners,
		{ x1: String ->
			x1
		},
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	return DecryptedFinancialInstitutionInformationJs(js("{" +
		"name:name," +
		"key:key," +
		"bankAccount:bankAccount," +
		"bic:bic," +
		"proxyBankAccount:proxyBankAccount," +
		"proxyBic:proxyBic," +
		"preferredFiiForPartners:preferredFiiForPartners," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun financialInstitutionInformation_fromJs(obj: DecryptedFinancialInstitutionInformationJs): DecryptedFinancialInstitutionInformation {
	val name = undefinedToNull(obj.name)
	val key = undefinedToNull(obj.key)
	val bankAccount = undefinedToNull(obj.bankAccount)
	val bic = undefinedToNull(obj.bic)
	val proxyBankAccount = undefinedToNull(obj.proxyBankAccount)
	val proxyBic = undefinedToNull(obj.proxyBic)
	val preferredFiiForPartners = arrayToSet(
		obj.preferredFiiForPartners,
		"obj.preferredFiiForPartners",
		{ x1: String ->
			x1
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return DecryptedFinancialInstitutionInformation(
		name = name,
		key = key,
		bankAccount = bankAccount,
		bic = bic,
		proxyBankAccount = proxyBankAccount,
		proxyBic = proxyBic,
		preferredFiiForPartners = preferredFiiForPartners,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun financialInstitutionInformation_toJs(obj: EncryptedFinancialInstitutionInformation): EncryptedFinancialInstitutionInformationJs {
	val name = nullToUndefined(
		obj.name
	)
	val key = nullToUndefined(
		obj.key
	)
	val bankAccount = nullToUndefined(
		obj.bankAccount
	)
	val bic = nullToUndefined(
		obj.bic
	)
	val proxyBankAccount = nullToUndefined(
		obj.proxyBankAccount
	)
	val proxyBic = nullToUndefined(
		obj.proxyBic
	)
	val preferredFiiForPartners = setToArray(
		obj.preferredFiiForPartners,
		{ x1: String ->
			x1
		},
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	return EncryptedFinancialInstitutionInformationJs(js("{" +
		"name:name," +
		"key:key," +
		"bankAccount:bankAccount," +
		"bic:bic," +
		"proxyBankAccount:proxyBankAccount," +
		"proxyBic:proxyBic," +
		"preferredFiiForPartners:preferredFiiForPartners," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun financialInstitutionInformation_fromJs(obj: EncryptedFinancialInstitutionInformationJs): EncryptedFinancialInstitutionInformation {
	val name = undefinedToNull(obj.name)
	val key = undefinedToNull(obj.key)
	val bankAccount = undefinedToNull(obj.bankAccount)
	val bic = undefinedToNull(obj.bic)
	val proxyBankAccount = undefinedToNull(obj.proxyBankAccount)
	val proxyBic = undefinedToNull(obj.proxyBic)
	val preferredFiiForPartners = arrayToSet(
		obj.preferredFiiForPartners,
		"obj.preferredFiiForPartners",
		{ x1: String ->
			x1
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return EncryptedFinancialInstitutionInformation(
		name = name,
		key = key,
		bankAccount = bankAccount,
		bic = bic,
		proxyBankAccount = proxyBankAccount,
		proxyBic = proxyBic,
		preferredFiiForPartners = preferredFiiForPartners,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun financialInstitutionInformation_toJs(obj: FinancialInstitutionInformation): FinancialInstitutionInformationJs = when (obj) {
	is EncryptedFinancialInstitutionInformation -> financialInstitutionInformation_toJs(obj)
	is DecryptedFinancialInstitutionInformation -> financialInstitutionInformation_toJs(obj)
}

public fun financialInstitutionInformation_fromJs(obj: FinancialInstitutionInformationJs): FinancialInstitutionInformation = if (obj.isEncrypted) {
	financialInstitutionInformation_fromJs(obj as EncryptedFinancialInstitutionInformationJs)
} else {
	financialInstitutionInformation_fromJs(obj as DecryptedFinancialInstitutionInformationJs)
}
