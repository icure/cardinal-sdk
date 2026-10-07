// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.intToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMapNullsafe
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.specializations.base64String_fromJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_toJs
import com.icure.cardinal.sdk.model.embed.DecryptedValorisation
import com.icure.cardinal.sdk.model.embed.EncryptedValorisation
import com.icure.cardinal.sdk.model.embed.Valorisation
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun valorisation_toJs(obj: DecryptedValorisation): DecryptedValorisationJs {
	val startOfValidity = nullToUndefined(
		longToNumber(obj.startOfValidity)
	)
	val endOfValidity = nullToUndefined(
		longToNumber(obj.endOfValidity)
	)
	val predicate = nullToUndefined(
		obj.predicate
	)
	val reference = nullToUndefined(
		listToArray(
			obj.reference,
			{ x1: Int ->
				intToNumber(x1)
			},
		)
	)
	val totalAmount = nullToUndefined(
		obj.totalAmount
	)
	val reimbursement = nullToUndefined(
		obj.reimbursement
	)
	val patientIntervention = nullToUndefined(
		obj.patientIntervention
	)
	val doctorSupplement = nullToUndefined(
		obj.doctorSupplement
	)
	val vat = nullToUndefined(
		obj.vat
	)
	val label = nullToUndefined(
		mapToObject(
			obj.label,
			{ x1: String ->
				x1
			},
			{ x1: String ->
				x1
			},
		)
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	return DecryptedValorisationJs(js("{" +
		"startOfValidity:startOfValidity," +
		"endOfValidity:endOfValidity," +
		"predicate:predicate," +
		"reference:reference," +
		"totalAmount:totalAmount," +
		"reimbursement:reimbursement," +
		"patientIntervention:patientIntervention," +
		"doctorSupplement:doctorSupplement," +
		"vat:vat," +
		"label:label," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun valorisation_fromJs(obj: DecryptedValorisationJs): DecryptedValorisation {
	val startOfValidity = numberToLong(obj.startOfValidity, "obj.startOfValidity")
	val endOfValidity = numberToLong(obj.endOfValidity, "obj.endOfValidity")
	val predicate = undefinedToNull(obj.predicate)
	val reference = arrayToList(
		obj.reference,
		"obj.reference",
		{ x1: Double ->
			numberToInt(x1, "x1")
		},
	)
	val totalAmount = undefinedToNull(obj.totalAmount)
	val reimbursement = undefinedToNull(obj.reimbursement)
	val patientIntervention = undefinedToNull(obj.patientIntervention)
	val doctorSupplement = undefinedToNull(obj.doctorSupplement)
	val vat = undefinedToNull(obj.vat)
	val label = objectToMapNullsafe(
		obj.label,
		"obj.label",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return DecryptedValorisation(
		startOfValidity = startOfValidity,
		endOfValidity = endOfValidity,
		predicate = predicate,
		reference = reference,
		totalAmount = totalAmount,
		reimbursement = reimbursement,
		patientIntervention = patientIntervention,
		doctorSupplement = doctorSupplement,
		vat = vat,
		label = label,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun valorisation_toJs(obj: EncryptedValorisation): EncryptedValorisationJs {
	val startOfValidity = nullToUndefined(
		longToNumber(obj.startOfValidity)
	)
	val endOfValidity = nullToUndefined(
		longToNumber(obj.endOfValidity)
	)
	val predicate = nullToUndefined(
		obj.predicate
	)
	val reference = nullToUndefined(
		listToArray(
			obj.reference,
			{ x1: Int ->
				intToNumber(x1)
			},
		)
	)
	val totalAmount = nullToUndefined(
		obj.totalAmount
	)
	val reimbursement = nullToUndefined(
		obj.reimbursement
	)
	val patientIntervention = nullToUndefined(
		obj.patientIntervention
	)
	val doctorSupplement = nullToUndefined(
		obj.doctorSupplement
	)
	val vat = nullToUndefined(
		obj.vat
	)
	val label = nullToUndefined(
		mapToObject(
			obj.label,
			{ x1: String ->
				x1
			},
			{ x1: String ->
				x1
			},
		)
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	return EncryptedValorisationJs(js("{" +
		"startOfValidity:startOfValidity," +
		"endOfValidity:endOfValidity," +
		"predicate:predicate," +
		"reference:reference," +
		"totalAmount:totalAmount," +
		"reimbursement:reimbursement," +
		"patientIntervention:patientIntervention," +
		"doctorSupplement:doctorSupplement," +
		"vat:vat," +
		"label:label," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun valorisation_fromJs(obj: EncryptedValorisationJs): EncryptedValorisation {
	val startOfValidity = numberToLong(obj.startOfValidity, "obj.startOfValidity")
	val endOfValidity = numberToLong(obj.endOfValidity, "obj.endOfValidity")
	val predicate = undefinedToNull(obj.predicate)
	val reference = arrayToList(
		obj.reference,
		"obj.reference",
		{ x1: Double ->
			numberToInt(x1, "x1")
		},
	)
	val totalAmount = undefinedToNull(obj.totalAmount)
	val reimbursement = undefinedToNull(obj.reimbursement)
	val patientIntervention = undefinedToNull(obj.patientIntervention)
	val doctorSupplement = undefinedToNull(obj.doctorSupplement)
	val vat = undefinedToNull(obj.vat)
	val label = objectToMapNullsafe(
		obj.label,
		"obj.label",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return EncryptedValorisation(
		startOfValidity = startOfValidity,
		endOfValidity = endOfValidity,
		predicate = predicate,
		reference = reference,
		totalAmount = totalAmount,
		reimbursement = reimbursement,
		patientIntervention = patientIntervention,
		doctorSupplement = doctorSupplement,
		vat = vat,
		label = label,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun valorisation_toJs(obj: Valorisation): ValorisationJs = when (obj) {
	is EncryptedValorisation -> valorisation_toJs(obj)
	is DecryptedValorisation -> valorisation_toJs(obj)
}

public fun valorisation_fromJs(obj: ValorisationJs): Valorisation = if (obj.isEncrypted) {
	valorisation_fromJs(obj as EncryptedValorisationJs)
} else {
	valorisation_fromJs(obj as DecryptedValorisationJs)
}
