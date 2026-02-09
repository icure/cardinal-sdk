// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.intToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.base.codeStub_fromJs
import com.icure.cardinal.sdk.js.model.base.codeStub_toJs
import com.icure.cardinal.sdk.model.embed.Medication
import com.icure.cardinal.sdk.model.embed.RegimenItem
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun medication_toJs(obj: Medication): MedicationJs {
	val compoundPrescription = nullToUndefined(
		obj.compoundPrescription
	)
	val substanceProduct = nullToUndefined(
		obj.substanceProduct?.let { nonNull1 ->
			substanceproduct_toJs(nonNull1)
		}
	)
	val medicinalProduct = nullToUndefined(
		obj.medicinalProduct?.let { nonNull1 ->
			medicinalproduct_toJs(nonNull1)
		}
	)
	val numberOfPackages = nullToUndefined(
		intToNumber(obj.numberOfPackages)
	)
	val batch = nullToUndefined(
		obj.batch
	)
	val expirationDate = nullToUndefined(
		longToNumber(obj.expirationDate)
	)
	val instructionForPatient = nullToUndefined(
		obj.instructionForPatient
	)
	val instructionForReimbursement = nullToUndefined(
		obj.instructionForReimbursement
	)
	val commentForDelivery = nullToUndefined(
		obj.commentForDelivery
	)
	val drugRoute = nullToUndefined(
		obj.drugRoute
	)
	val temporality = nullToUndefined(
		obj.temporality
	)
	val frequency = nullToUndefined(
		obj.frequency?.let { nonNull1 ->
			codeStub_toJs(nonNull1)
		}
	)
	val reimbursementReason = nullToUndefined(
		obj.reimbursementReason?.let { nonNull1 ->
			codeStub_toJs(nonNull1)
		}
	)
	val substitutionAllowed = nullToUndefined(
		obj.substitutionAllowed
	)
	val beginMoment = nullToUndefined(
		longToNumber(obj.beginMoment)
	)
	val endMoment = nullToUndefined(
		longToNumber(obj.endMoment)
	)
	val deliveryMoment = nullToUndefined(
		longToNumber(obj.deliveryMoment)
	)
	val endExecutionMoment = nullToUndefined(
		longToNumber(obj.endExecutionMoment)
	)
	val duration = nullToUndefined(
		obj.duration?.let { nonNull1 ->
			duration_toJs(nonNull1)
		}
	)
	val renewal = nullToUndefined(
		obj.renewal?.let { nonNull1 ->
			renewal_toJs(nonNull1)
		}
	)
	val knownUsage = nullToUndefined(
		obj.knownUsage
	)
	val regimen = nullToUndefined(
		listToArray(
			obj.regimen,
			{ x1: RegimenItem ->
				regimenItem_toJs(x1)
			},
		)
	)
	val posology = nullToUndefined(
		obj.posology
	)
	val stockLocation = nullToUndefined(
		obj.stockLocation?.let { nonNull1 ->
			address_toJs(nonNull1)
		}
	)
	return MedicationJs(js("{" +
		"compoundPrescription:compoundPrescription," +
		"substanceProduct:substanceProduct," +
		"medicinalProduct:medicinalProduct," +
		"numberOfPackages:numberOfPackages," +
		"batch:batch," +
		"expirationDate:expirationDate," +
		"instructionForPatient:instructionForPatient," +
		"instructionForReimbursement:instructionForReimbursement," +
		"commentForDelivery:commentForDelivery," +
		"drugRoute:drugRoute," +
		"temporality:temporality," +
		"frequency:frequency," +
		"reimbursementReason:reimbursementReason," +
		"substitutionAllowed:substitutionAllowed," +
		"beginMoment:beginMoment," +
		"endMoment:endMoment," +
		"deliveryMoment:deliveryMoment," +
		"endExecutionMoment:endExecutionMoment," +
		"duration:duration," +
		"renewal:renewal," +
		"knownUsage:knownUsage," +
		"regimen:regimen," +
		"posology:posology," +
		"stockLocation:stockLocation" +
	"}"))
}

public fun medication_fromJs(obj: MedicationJs): Medication {
	val compoundPrescription = undefinedToNull(obj.compoundPrescription)
	val substanceProduct = obj.substanceProduct?.let { nonNull1 ->
		substanceproduct_fromJs(nonNull1)
	}
	val medicinalProduct = obj.medicinalProduct?.let { nonNull1 ->
		medicinalproduct_fromJs(nonNull1)
	}
	val numberOfPackages = numberToInt(obj.numberOfPackages, "obj.numberOfPackages")
	val batch = undefinedToNull(obj.batch)
	val expirationDate = numberToLong(obj.expirationDate, "obj.expirationDate")
	val instructionForPatient = undefinedToNull(obj.instructionForPatient)
	val instructionForReimbursement = undefinedToNull(obj.instructionForReimbursement)
	val commentForDelivery = undefinedToNull(obj.commentForDelivery)
	val drugRoute = undefinedToNull(obj.drugRoute)
	val temporality = undefinedToNull(obj.temporality)
	val frequency = obj.frequency?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val reimbursementReason = obj.reimbursementReason?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val substitutionAllowed = undefinedToNull(obj.substitutionAllowed)
	val beginMoment = numberToLong(obj.beginMoment, "obj.beginMoment")
	val endMoment = numberToLong(obj.endMoment, "obj.endMoment")
	val deliveryMoment = numberToLong(obj.deliveryMoment, "obj.deliveryMoment")
	val endExecutionMoment = numberToLong(obj.endExecutionMoment, "obj.endExecutionMoment")
	val duration = obj.duration?.let { nonNull1 ->
		duration_fromJs(nonNull1)
	}
	val renewal = obj.renewal?.let { nonNull1 ->
		renewal_fromJs(nonNull1)
	}
	val knownUsage = undefinedToNull(obj.knownUsage)
	val regimen = arrayToList(
		obj.regimen,
		"obj.regimen",
		{ x1: RegimenItemJs ->
			regimenItem_fromJs(x1)
		},
	)
	val posology = undefinedToNull(obj.posology)
	val stockLocation = obj.stockLocation?.let { nonNull1 ->
		address_fromJs(nonNull1)
	}
	return Medication(
		compoundPrescription = compoundPrescription,
		substanceProduct = substanceProduct,
		medicinalProduct = medicinalProduct,
		numberOfPackages = numberOfPackages,
		batch = batch,
		expirationDate = expirationDate,
		instructionForPatient = instructionForPatient,
		instructionForReimbursement = instructionForReimbursement,
		commentForDelivery = commentForDelivery,
		drugRoute = drugRoute,
		temporality = temporality,
		frequency = frequency,
		reimbursementReason = reimbursementReason,
		substitutionAllowed = substitutionAllowed,
		beginMoment = beginMoment,
		endMoment = endMoment,
		deliveryMoment = deliveryMoment,
		endExecutionMoment = endExecutionMoment,
		duration = duration,
		renewal = renewal,
		knownUsage = knownUsage,
		regimen = regimen,
		posology = posology,
		stockLocation = stockLocation,
	)
}
