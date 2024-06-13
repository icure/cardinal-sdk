package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.js.model.specializations.base64String_fromJs
import com.icure.sdk.js.model.specializations.base64String_toJs
import com.icure.sdk.model.embed.DecryptedPatientHealthCareParty
import com.icure.sdk.model.embed.EncryptedPatientHealthCareParty
import com.icure.sdk.model.embed.PatientHealthCareParty
import com.icure.sdk.model.embed.PatientHealthCarePartyType
import com.icure.sdk.model.embed.ReferralPeriod
import com.icure.sdk.model.embed.TelecomType
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun patientHealthCareParty_toJs(obj: DecryptedPatientHealthCareParty):
		DecryptedPatientHealthCarePartyJs {
	val type = nullToUndefined(
		obj.type?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val healthcarePartyId = nullToUndefined(
		obj.healthcarePartyId
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
	val referralPeriods = listToArray(
		obj.referralPeriods,
		{ x1: ReferralPeriod ->
			referralPeriod_toJs(x1)
		},
	)
	val referral = obj.referral
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	return DecryptedPatientHealthCarePartyJs(js("{" +
		"type:type," +
		"healthcarePartyId:healthcarePartyId," +
		"sendFormats:sendFormats," +
		"referralPeriods:referralPeriods," +
		"referral:referral," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun patientHealthCareParty_fromJs(obj: DecryptedPatientHealthCarePartyJs):
		DecryptedPatientHealthCareParty {
	val type = obj.type?.let { nonNull1 ->
		PatientHealthCarePartyType.valueOf(nonNull1)
	}
	val healthcarePartyId = undefinedToNull(obj.healthcarePartyId)
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
	val referralPeriods = arrayToList(
		obj.referralPeriods,
		"obj.referralPeriods",
		{ x1: ReferralPeriodJs ->
			referralPeriod_fromJs(x1)
		},
	)
	val referral = obj.referral
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return DecryptedPatientHealthCareParty(
		type = type,
		healthcarePartyId = healthcarePartyId,
		sendFormats = sendFormats,
		referralPeriods = referralPeriods,
		referral = referral,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun patientHealthCareParty_toJs(obj: EncryptedPatientHealthCareParty):
		EncryptedPatientHealthCarePartyJs {
	val type = nullToUndefined(
		obj.type?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val healthcarePartyId = nullToUndefined(
		obj.healthcarePartyId
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
	val referralPeriods = listToArray(
		obj.referralPeriods,
		{ x1: ReferralPeriod ->
			referralPeriod_toJs(x1)
		},
	)
	val referral = obj.referral
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	return EncryptedPatientHealthCarePartyJs(js("{" +
		"type:type," +
		"healthcarePartyId:healthcarePartyId," +
		"sendFormats:sendFormats," +
		"referralPeriods:referralPeriods," +
		"referral:referral," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun patientHealthCareParty_fromJs(obj: EncryptedPatientHealthCarePartyJs):
		EncryptedPatientHealthCareParty {
	val type = obj.type?.let { nonNull1 ->
		PatientHealthCarePartyType.valueOf(nonNull1)
	}
	val healthcarePartyId = undefinedToNull(obj.healthcarePartyId)
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
	val referralPeriods = arrayToList(
		obj.referralPeriods,
		"obj.referralPeriods",
		{ x1: ReferralPeriodJs ->
			referralPeriod_fromJs(x1)
		},
	)
	val referral = obj.referral
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return EncryptedPatientHealthCareParty(
		type = type,
		healthcarePartyId = healthcarePartyId,
		sendFormats = sendFormats,
		referralPeriods = referralPeriods,
		referral = referral,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun patientHealthCareParty_toJs(obj: PatientHealthCareParty): PatientHealthCarePartyJs = when
		(obj) {
	is EncryptedPatientHealthCareParty -> patientHealthCareParty_toJs(obj)
	is DecryptedPatientHealthCareParty -> patientHealthCareParty_toJs(obj)
}

public fun patientHealthCareParty_fromJs(obj: PatientHealthCarePartyJs): PatientHealthCareParty = if
		(obj.isEncrypted) {
	patientHealthCareParty_fromJs(obj as EncryptedPatientHealthCarePartyJs)
} else {
	patientHealthCareParty_fromJs(obj as DecryptedPatientHealthCarePartyJs)
}
