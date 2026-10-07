// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMapNullsafe
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.embed.AgreementAppendix
import com.icure.cardinal.sdk.model.embed.ParagraphAgreement
import kotlin.Double
import kotlin.Long
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun paragraphAgreement_toJs(obj: ParagraphAgreement): ParagraphAgreementJs {
	val timestamp = nullToUndefined(
		longToNumber(obj.timestamp)
	)
	val paragraph = nullToUndefined(
		obj.paragraph
	)
	val accepted = nullToUndefined(
		obj.accepted
	)
	val inTreatment = nullToUndefined(
		obj.inTreatment
	)
	val canceled = nullToUndefined(
		obj.canceled
	)
	val careProviderReference = nullToUndefined(
		obj.careProviderReference
	)
	val decisionReference = nullToUndefined(
		obj.decisionReference
	)
	val start = nullToUndefined(
		longToNumber(obj.start)
	)
	val end = nullToUndefined(
		longToNumber(obj.end)
	)
	val cancelationDate = nullToUndefined(
		longToNumber(obj.cancelationDate)
	)
	val quantityValue = nullToUndefined(
		obj.quantityValue
	)
	val quantityUnit = nullToUndefined(
		obj.quantityUnit
	)
	val ioRequestReference = nullToUndefined(
		obj.ioRequestReference
	)
	val responseType = nullToUndefined(
		obj.responseType
	)
	val refusalJustification = nullToUndefined(
		mapToObject(
			obj.refusalJustification,
			{ x1: String ->
				x1
			},
			{ x1: String ->
				x1
			},
		)
	)
	val verses = nullToUndefined(
		setToArray(
			obj.verses,
			{ x1: Long ->
				longToNumber(x1)
			},
		)
	)
	val coverageType = nullToUndefined(
		obj.coverageType
	)
	val unitNumber = nullToUndefined(
		obj.unitNumber
	)
	val strength = nullToUndefined(
		obj.strength
	)
	val strengthUnit = nullToUndefined(
		obj.strengthUnit
	)
	val agreementAppendices = nullToUndefined(
		listToArray(
			obj.agreementAppendices,
			{ x1: AgreementAppendix ->
				agreementAppendix_toJs(x1)
			},
		)
	)
	val documentId = nullToUndefined(
		obj.documentId
	)
	return ParagraphAgreementJs(js("{" +
		"timestamp:timestamp," +
		"paragraph:paragraph," +
		"accepted:accepted," +
		"inTreatment:inTreatment," +
		"canceled:canceled," +
		"careProviderReference:careProviderReference," +
		"decisionReference:decisionReference," +
		"start:start," +
		"end:end," +
		"cancelationDate:cancelationDate," +
		"quantityValue:quantityValue," +
		"quantityUnit:quantityUnit," +
		"ioRequestReference:ioRequestReference," +
		"responseType:responseType," +
		"refusalJustification:refusalJustification," +
		"verses:verses," +
		"coverageType:coverageType," +
		"unitNumber:unitNumber," +
		"strength:strength," +
		"strengthUnit:strengthUnit," +
		"agreementAppendices:agreementAppendices," +
		"documentId:documentId" +
	"}"))
}

public fun paragraphAgreement_fromJs(obj: ParagraphAgreementJs): ParagraphAgreement {
	val timestamp = numberToLong(obj.timestamp, "obj.timestamp")
	val paragraph = undefinedToNull(obj.paragraph)
	val accepted = undefinedToNull(obj.accepted)
	val inTreatment = undefinedToNull(obj.inTreatment)
	val canceled = undefinedToNull(obj.canceled)
	val careProviderReference = undefinedToNull(obj.careProviderReference)
	val decisionReference = undefinedToNull(obj.decisionReference)
	val start = numberToLong(obj.start, "obj.start")
	val end = numberToLong(obj.end, "obj.end")
	val cancelationDate = numberToLong(obj.cancelationDate, "obj.cancelationDate")
	val quantityValue = undefinedToNull(obj.quantityValue)
	val quantityUnit = undefinedToNull(obj.quantityUnit)
	val ioRequestReference = undefinedToNull(obj.ioRequestReference)
	val responseType = undefinedToNull(obj.responseType)
	val refusalJustification = objectToMapNullsafe(
		obj.refusalJustification,
		"obj.refusalJustification",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val verses = arrayToSet(
		obj.verses,
		"obj.verses",
		{ x1: Double ->
			numberToLong(x1, "x1")
		},
	)
	val coverageType = undefinedToNull(obj.coverageType)
	val unitNumber = undefinedToNull(obj.unitNumber)
	val strength = undefinedToNull(obj.strength)
	val strengthUnit = undefinedToNull(obj.strengthUnit)
	val agreementAppendices = arrayToList(
		obj.agreementAppendices,
		"obj.agreementAppendices",
		{ x1: AgreementAppendixJs ->
			agreementAppendix_fromJs(x1)
		},
	)
	val documentId = undefinedToNull(obj.documentId)
	return ParagraphAgreement(
		timestamp = timestamp,
		paragraph = paragraph,
		accepted = accepted,
		inTreatment = inTreatment,
		canceled = canceled,
		careProviderReference = careProviderReference,
		decisionReference = decisionReference,
		start = start,
		end = end,
		cancelationDate = cancelationDate,
		quantityValue = quantityValue,
		quantityUnit = quantityUnit,
		ioRequestReference = ioRequestReference,
		responseType = responseType,
		refusalJustification = refusalJustification,
		verses = verses,
		coverageType = coverageType,
		unitNumber = unitNumber,
		strength = strength,
		strengthUnit = strengthUnit,
		agreementAppendices = agreementAppendices,
		documentId = documentId,
	)
}
