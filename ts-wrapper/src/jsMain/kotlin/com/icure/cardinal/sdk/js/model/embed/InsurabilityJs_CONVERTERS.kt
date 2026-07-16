// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.dynamicToJsonObjectNullsafe
import com.icure.cardinal.sdk.js.model.CheckedConverters.jsonToDynamic
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.specializations.base64String_fromJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_toJs
import com.icure.cardinal.sdk.model.embed.DecryptedInsurability
import com.icure.cardinal.sdk.model.embed.EncryptedInsurability
import com.icure.cardinal.sdk.model.embed.Insurability
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun insurability_toJs(obj: DecryptedInsurability): DecryptedInsurabilityJs {
	val parameters = mapToObject(
		obj.parameters,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val hospitalisation = nullToUndefined(
		obj.hospitalisation
	)
	val ambulatory = nullToUndefined(
		obj.ambulatory
	)
	val dental = nullToUndefined(
		obj.dental
	)
	val identificationNumber = nullToUndefined(
		obj.identificationNumber
	)
	val insuranceId = nullToUndefined(
		obj.insuranceId
	)
	val startDate = nullToUndefined(
		longToNumber(obj.startDate)
	)
	val endDate = nullToUndefined(
		longToNumber(obj.endDate)
	)
	val titularyId = nullToUndefined(
		obj.titularyId
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	val extensions = nullToUndefined(
		jsonToDynamic(obj.extensions)
	)
	return DecryptedInsurabilityJs(js("{" +
		"parameters:parameters," +
		"hospitalisation:hospitalisation," +
		"ambulatory:ambulatory," +
		"dental:dental," +
		"identificationNumber:identificationNumber," +
		"insuranceId:insuranceId," +
		"startDate:startDate," +
		"endDate:endDate," +
		"titularyId:titularyId," +
		"encryptedSelf:encryptedSelf," +
		"extensions:extensions" +
	"}"))
}

public fun insurability_fromJs(obj: DecryptedInsurabilityJs): DecryptedInsurability {
	val parameters = objectToMap(
		obj.parameters,
		"obj.parameters",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val hospitalisation = undefinedToNull(obj.hospitalisation)
	val ambulatory = undefinedToNull(obj.ambulatory)
	val dental = undefinedToNull(obj.dental)
	val identificationNumber = undefinedToNull(obj.identificationNumber)
	val insuranceId = undefinedToNull(obj.insuranceId)
	val startDate = numberToLong(obj.startDate, "obj.startDate")
	val endDate = numberToLong(obj.endDate, "obj.endDate")
	val titularyId = undefinedToNull(obj.titularyId)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	val extensions = dynamicToJsonObjectNullsafe(obj.extensions, "obj.extensions")
	return DecryptedInsurability(
		parameters = parameters,
		hospitalisation = hospitalisation,
		ambulatory = ambulatory,
		dental = dental,
		identificationNumber = identificationNumber,
		insuranceId = insuranceId,
		startDate = startDate,
		endDate = endDate,
		titularyId = titularyId,
		encryptedSelf = encryptedSelf,
		extensions = extensions,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun insurability_toJs(obj: EncryptedInsurability): EncryptedInsurabilityJs {
	val parameters = mapToObject(
		obj.parameters,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val hospitalisation = nullToUndefined(
		obj.hospitalisation
	)
	val ambulatory = nullToUndefined(
		obj.ambulatory
	)
	val dental = nullToUndefined(
		obj.dental
	)
	val identificationNumber = nullToUndefined(
		obj.identificationNumber
	)
	val insuranceId = nullToUndefined(
		obj.insuranceId
	)
	val startDate = nullToUndefined(
		longToNumber(obj.startDate)
	)
	val endDate = nullToUndefined(
		longToNumber(obj.endDate)
	)
	val titularyId = nullToUndefined(
		obj.titularyId
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	val extensions = nullToUndefined(
		jsonToDynamic(obj.extensions)
	)
	return EncryptedInsurabilityJs(js("{" +
		"parameters:parameters," +
		"hospitalisation:hospitalisation," +
		"ambulatory:ambulatory," +
		"dental:dental," +
		"identificationNumber:identificationNumber," +
		"insuranceId:insuranceId," +
		"startDate:startDate," +
		"endDate:endDate," +
		"titularyId:titularyId," +
		"encryptedSelf:encryptedSelf," +
		"extensions:extensions" +
	"}"))
}

public fun insurability_fromJs(obj: EncryptedInsurabilityJs): EncryptedInsurability {
	val parameters = objectToMap(
		obj.parameters,
		"obj.parameters",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val hospitalisation = undefinedToNull(obj.hospitalisation)
	val ambulatory = undefinedToNull(obj.ambulatory)
	val dental = undefinedToNull(obj.dental)
	val identificationNumber = undefinedToNull(obj.identificationNumber)
	val insuranceId = undefinedToNull(obj.insuranceId)
	val startDate = numberToLong(obj.startDate, "obj.startDate")
	val endDate = numberToLong(obj.endDate, "obj.endDate")
	val titularyId = undefinedToNull(obj.titularyId)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	val extensions = dynamicToJsonObjectNullsafe(obj.extensions, "obj.extensions")
	return EncryptedInsurability(
		parameters = parameters,
		hospitalisation = hospitalisation,
		ambulatory = ambulatory,
		dental = dental,
		identificationNumber = identificationNumber,
		insuranceId = insuranceId,
		startDate = startDate,
		endDate = endDate,
		titularyId = titularyId,
		encryptedSelf = encryptedSelf,
		extensions = extensions,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun insurability_toJs(obj: Insurability): InsurabilityJs = when (obj) {
	is EncryptedInsurability -> insurability_toJs(obj)
	is DecryptedInsurability -> insurability_toJs(obj)
}

public fun insurability_fromJs(obj: InsurabilityJs): Insurability = if (obj.isEncrypted) {
	insurability_fromJs(obj as EncryptedInsurabilityJs)
} else {
	insurability_fromJs(obj as DecryptedInsurabilityJs)
}
