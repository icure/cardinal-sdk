// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.intToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.specializations.base64String_fromJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_toJs
import com.icure.cardinal.sdk.model.embed.DecryptedInvoicingCode
import com.icure.cardinal.sdk.model.embed.EncryptedInvoicingCode
import com.icure.cardinal.sdk.model.embed.InvoicingCode
import com.icure.cardinal.sdk.model.embed.PaymentType
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun invoicingCode_toJs(obj: DecryptedInvoicingCode): DecryptedInvoicingCodeJs {
	val id = nullToUndefined(
		obj.id
	)
	val dateCode = nullToUndefined(
		longToNumber(obj.dateCode)
	)
	val logicalId = nullToUndefined(
		obj.logicalId
	)
	val label = nullToUndefined(
		obj.label
	)
	val userId = nullToUndefined(
		obj.userId
	)
	val contactId = nullToUndefined(
		obj.contactId
	)
	val serviceId = nullToUndefined(
		obj.serviceId
	)
	val tarificationId = nullToUndefined(
		obj.tarificationId
	)
	val code = nullToUndefined(
		obj.code
	)
	val paymentType = nullToUndefined(
		obj.paymentType?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val paid = nullToUndefined(
		obj.paid
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
	val amiIntervention = nullToUndefined(
		obj.amiIntervention
	)
	val doctorSupplement = nullToUndefined(
		obj.doctorSupplement
	)
	val conventionAmount = nullToUndefined(
		obj.conventionAmount
	)
	val vat = nullToUndefined(
		obj.vat
	)
	val error = nullToUndefined(
		obj.error
	)
	val contract = nullToUndefined(
		obj.contract
	)
	val contractDate = nullToUndefined(
		longToNumber(obj.contractDate)
	)
	val units = nullToUndefined(
		intToNumber(obj.units)
	)
	val side = nullToUndefined(
		intToNumber(obj.side)
	)
	val timeOfDay = nullToUndefined(
		intToNumber(obj.timeOfDay)
	)
	val eidReadingHour = nullToUndefined(
		intToNumber(obj.eidReadingHour)
	)
	val eidReadingValue = nullToUndefined(
		obj.eidReadingValue
	)
	val override3rdPayerCode = nullToUndefined(
		intToNumber(obj.override3rdPayerCode)
	)
	val override3rdPayerReason = nullToUndefined(
		obj.override3rdPayerReason
	)
	val transplantationCode = nullToUndefined(
		intToNumber(obj.transplantationCode)
	)
	val prescriberNorm = nullToUndefined(
		intToNumber(obj.prescriberNorm)
	)
	val productLabel = nullToUndefined(
		obj.productLabel
	)
	val percentNorm = nullToUndefined(
		intToNumber(obj.percentNorm)
	)
	val prescriberNihii = nullToUndefined(
		obj.prescriberNihii
	)
	val relatedCode = nullToUndefined(
		obj.relatedCode
	)
	val prescriptionDate = nullToUndefined(
		longToNumber(obj.prescriptionDate)
	)
	val derogationMaxNumber = nullToUndefined(
		intToNumber(obj.derogationMaxNumber)
	)
	val prescriberSsin = nullToUndefined(
		obj.prescriberSsin
	)
	val prescriberLastName = nullToUndefined(
		obj.prescriberLastName
	)
	val prescriberFirstName = nullToUndefined(
		obj.prescriberFirstName
	)
	val prescriberCdHcParty = nullToUndefined(
		obj.prescriberCdHcParty
	)
	val locationNihii = nullToUndefined(
		obj.locationNihii
	)
	val locationCdHcParty = nullToUndefined(
		obj.locationCdHcParty
	)
	val locationService = nullToUndefined(
		intToNumber(obj.locationService)
	)
	val admissionDate = nullToUndefined(
		longToNumber(obj.admissionDate)
	)
	val canceled = nullToUndefined(
		obj.canceled
	)
	val accepted = nullToUndefined(
		obj.accepted
	)
	val pending = nullToUndefined(
		obj.pending
	)
	val resent = nullToUndefined(
		obj.resent
	)
	val archived = nullToUndefined(
		obj.archived
	)
	val lost = nullToUndefined(
		obj.lost
	)
	val insuranceJustification = nullToUndefined(
		intToNumber(obj.insuranceJustification)
	)
	val cancelPatientInterventionReason = nullToUndefined(
		intToNumber(obj.cancelPatientInterventionReason)
	)
	val status = nullToUndefined(
		longToNumber(obj.status)
	)
	val codeLabel = nullToUndefined(
		obj.codeLabel
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
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	return DecryptedInvoicingCodeJs(js("{" +
		"id:id," +
		"dateCode:dateCode," +
		"logicalId:logicalId," +
		"label:label," +
		"userId:userId," +
		"contactId:contactId," +
		"serviceId:serviceId," +
		"tarificationId:tarificationId," +
		"code:code," +
		"paymentType:paymentType," +
		"paid:paid," +
		"totalAmount:totalAmount," +
		"reimbursement:reimbursement," +
		"patientIntervention:patientIntervention," +
		"amiIntervention:amiIntervention," +
		"doctorSupplement:doctorSupplement," +
		"conventionAmount:conventionAmount," +
		"vat:vat," +
		"error:error," +
		"contract:contract," +
		"contractDate:contractDate," +
		"units:units," +
		"side:side," +
		"timeOfDay:timeOfDay," +
		"eidReadingHour:eidReadingHour," +
		"eidReadingValue:eidReadingValue," +
		"override3rdPayerCode:override3rdPayerCode," +
		"override3rdPayerReason:override3rdPayerReason," +
		"transplantationCode:transplantationCode," +
		"prescriberNorm:prescriberNorm," +
		"productLabel:productLabel," +
		"percentNorm:percentNorm," +
		"prescriberNihii:prescriberNihii," +
		"relatedCode:relatedCode," +
		"prescriptionDate:prescriptionDate," +
		"derogationMaxNumber:derogationMaxNumber," +
		"prescriberSsin:prescriberSsin," +
		"prescriberLastName:prescriberLastName," +
		"prescriberFirstName:prescriberFirstName," +
		"prescriberCdHcParty:prescriberCdHcParty," +
		"locationNihii:locationNihii," +
		"locationCdHcParty:locationCdHcParty," +
		"locationService:locationService," +
		"admissionDate:admissionDate," +
		"canceled:canceled," +
		"accepted:accepted," +
		"pending:pending," +
		"resent:resent," +
		"archived:archived," +
		"lost:lost," +
		"insuranceJustification:insuranceJustification," +
		"cancelPatientInterventionReason:cancelPatientInterventionReason," +
		"status:status," +
		"codeLabel:codeLabel," +
		"options:options," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun invoicingCode_fromJs(obj: DecryptedInvoicingCodeJs): DecryptedInvoicingCode {
	val id = undefinedToNull(obj.id)
	val dateCode = numberToLong(obj.dateCode, "obj.dateCode")
	val logicalId = undefinedToNull(obj.logicalId)
	val label = undefinedToNull(obj.label)
	val userId = undefinedToNull(obj.userId)
	val contactId = undefinedToNull(obj.contactId)
	val serviceId = undefinedToNull(obj.serviceId)
	val tarificationId = undefinedToNull(obj.tarificationId)
	val code = undefinedToNull(obj.code)
	val paymentType = obj.paymentType?.let { nonNull1 ->
		PaymentType.valueOf(nonNull1)
	}
	val paid = undefinedToNull(obj.paid)
	val totalAmount = undefinedToNull(obj.totalAmount)
	val reimbursement = undefinedToNull(obj.reimbursement)
	val patientIntervention = undefinedToNull(obj.patientIntervention)
	val amiIntervention = undefinedToNull(obj.amiIntervention)
	val doctorSupplement = undefinedToNull(obj.doctorSupplement)
	val conventionAmount = undefinedToNull(obj.conventionAmount)
	val vat = undefinedToNull(obj.vat)
	val error = undefinedToNull(obj.error)
	val contract = undefinedToNull(obj.contract)
	val contractDate = numberToLong(obj.contractDate, "obj.contractDate")
	val units = numberToInt(obj.units, "obj.units")
	val side = numberToInt(obj.side, "obj.side")
	val timeOfDay = numberToInt(obj.timeOfDay, "obj.timeOfDay")
	val eidReadingHour = numberToInt(obj.eidReadingHour, "obj.eidReadingHour")
	val eidReadingValue = undefinedToNull(obj.eidReadingValue)
	val override3rdPayerCode = numberToInt(obj.override3rdPayerCode, "obj.override3rdPayerCode")
	val override3rdPayerReason = undefinedToNull(obj.override3rdPayerReason)
	val transplantationCode = numberToInt(obj.transplantationCode, "obj.transplantationCode")
	val prescriberNorm = numberToInt(obj.prescriberNorm, "obj.prescriberNorm")
	val productLabel = undefinedToNull(obj.productLabel)
	val percentNorm = numberToInt(obj.percentNorm, "obj.percentNorm")
	val prescriberNihii = undefinedToNull(obj.prescriberNihii)
	val relatedCode = undefinedToNull(obj.relatedCode)
	val prescriptionDate = numberToLong(obj.prescriptionDate, "obj.prescriptionDate")
	val derogationMaxNumber = numberToInt(obj.derogationMaxNumber, "obj.derogationMaxNumber")
	val prescriberSsin = undefinedToNull(obj.prescriberSsin)
	val prescriberLastName = undefinedToNull(obj.prescriberLastName)
	val prescriberFirstName = undefinedToNull(obj.prescriberFirstName)
	val prescriberCdHcParty = undefinedToNull(obj.prescriberCdHcParty)
	val locationNihii = undefinedToNull(obj.locationNihii)
	val locationCdHcParty = undefinedToNull(obj.locationCdHcParty)
	val locationService = numberToInt(obj.locationService, "obj.locationService")
	val admissionDate = numberToLong(obj.admissionDate, "obj.admissionDate")
	val canceled = undefinedToNull(obj.canceled)
	val accepted = undefinedToNull(obj.accepted)
	val pending = undefinedToNull(obj.pending)
	val resent = undefinedToNull(obj.resent)
	val archived = undefinedToNull(obj.archived)
	val lost = undefinedToNull(obj.lost)
	val insuranceJustification = numberToInt(obj.insuranceJustification, "obj.insuranceJustification")
	val cancelPatientInterventionReason = numberToInt(obj.cancelPatientInterventionReason,
			"obj.cancelPatientInterventionReason")
	val status = numberToLong(obj.status, "obj.status")
	val codeLabel = undefinedToNull(obj.codeLabel)
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
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return DecryptedInvoicingCode(
		id = id,
		dateCode = dateCode,
		logicalId = logicalId,
		label = label,
		userId = userId,
		contactId = contactId,
		serviceId = serviceId,
		tarificationId = tarificationId,
		code = code,
		paymentType = paymentType,
		paid = paid,
		totalAmount = totalAmount,
		reimbursement = reimbursement,
		patientIntervention = patientIntervention,
		amiIntervention = amiIntervention,
		doctorSupplement = doctorSupplement,
		conventionAmount = conventionAmount,
		vat = vat,
		error = error,
		contract = contract,
		contractDate = contractDate,
		units = units,
		side = side,
		timeOfDay = timeOfDay,
		eidReadingHour = eidReadingHour,
		eidReadingValue = eidReadingValue,
		override3rdPayerCode = override3rdPayerCode,
		override3rdPayerReason = override3rdPayerReason,
		transplantationCode = transplantationCode,
		prescriberNorm = prescriberNorm,
		productLabel = productLabel,
		percentNorm = percentNorm,
		prescriberNihii = prescriberNihii,
		relatedCode = relatedCode,
		prescriptionDate = prescriptionDate,
		derogationMaxNumber = derogationMaxNumber,
		prescriberSsin = prescriberSsin,
		prescriberLastName = prescriberLastName,
		prescriberFirstName = prescriberFirstName,
		prescriberCdHcParty = prescriberCdHcParty,
		locationNihii = locationNihii,
		locationCdHcParty = locationCdHcParty,
		locationService = locationService,
		admissionDate = admissionDate,
		canceled = canceled,
		accepted = accepted,
		pending = pending,
		resent = resent,
		archived = archived,
		lost = lost,
		insuranceJustification = insuranceJustification,
		cancelPatientInterventionReason = cancelPatientInterventionReason,
		status = status,
		codeLabel = codeLabel,
		options = options,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun invoicingCode_toJs(obj: EncryptedInvoicingCode): EncryptedInvoicingCodeJs {
	val id = nullToUndefined(
		obj.id
	)
	val dateCode = nullToUndefined(
		longToNumber(obj.dateCode)
	)
	val logicalId = nullToUndefined(
		obj.logicalId
	)
	val label = nullToUndefined(
		obj.label
	)
	val userId = nullToUndefined(
		obj.userId
	)
	val contactId = nullToUndefined(
		obj.contactId
	)
	val serviceId = nullToUndefined(
		obj.serviceId
	)
	val tarificationId = nullToUndefined(
		obj.tarificationId
	)
	val code = nullToUndefined(
		obj.code
	)
	val paymentType = nullToUndefined(
		obj.paymentType?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val paid = nullToUndefined(
		obj.paid
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
	val amiIntervention = nullToUndefined(
		obj.amiIntervention
	)
	val doctorSupplement = nullToUndefined(
		obj.doctorSupplement
	)
	val conventionAmount = nullToUndefined(
		obj.conventionAmount
	)
	val vat = nullToUndefined(
		obj.vat
	)
	val error = nullToUndefined(
		obj.error
	)
	val contract = nullToUndefined(
		obj.contract
	)
	val contractDate = nullToUndefined(
		longToNumber(obj.contractDate)
	)
	val units = nullToUndefined(
		intToNumber(obj.units)
	)
	val side = nullToUndefined(
		intToNumber(obj.side)
	)
	val timeOfDay = nullToUndefined(
		intToNumber(obj.timeOfDay)
	)
	val eidReadingHour = nullToUndefined(
		intToNumber(obj.eidReadingHour)
	)
	val eidReadingValue = nullToUndefined(
		obj.eidReadingValue
	)
	val override3rdPayerCode = nullToUndefined(
		intToNumber(obj.override3rdPayerCode)
	)
	val override3rdPayerReason = nullToUndefined(
		obj.override3rdPayerReason
	)
	val transplantationCode = nullToUndefined(
		intToNumber(obj.transplantationCode)
	)
	val prescriberNorm = nullToUndefined(
		intToNumber(obj.prescriberNorm)
	)
	val productLabel = nullToUndefined(
		obj.productLabel
	)
	val percentNorm = nullToUndefined(
		intToNumber(obj.percentNorm)
	)
	val prescriberNihii = nullToUndefined(
		obj.prescriberNihii
	)
	val relatedCode = nullToUndefined(
		obj.relatedCode
	)
	val prescriptionDate = nullToUndefined(
		longToNumber(obj.prescriptionDate)
	)
	val derogationMaxNumber = nullToUndefined(
		intToNumber(obj.derogationMaxNumber)
	)
	val prescriberSsin = nullToUndefined(
		obj.prescriberSsin
	)
	val prescriberLastName = nullToUndefined(
		obj.prescriberLastName
	)
	val prescriberFirstName = nullToUndefined(
		obj.prescriberFirstName
	)
	val prescriberCdHcParty = nullToUndefined(
		obj.prescriberCdHcParty
	)
	val locationNihii = nullToUndefined(
		obj.locationNihii
	)
	val locationCdHcParty = nullToUndefined(
		obj.locationCdHcParty
	)
	val locationService = nullToUndefined(
		intToNumber(obj.locationService)
	)
	val admissionDate = nullToUndefined(
		longToNumber(obj.admissionDate)
	)
	val canceled = nullToUndefined(
		obj.canceled
	)
	val accepted = nullToUndefined(
		obj.accepted
	)
	val pending = nullToUndefined(
		obj.pending
	)
	val resent = nullToUndefined(
		obj.resent
	)
	val archived = nullToUndefined(
		obj.archived
	)
	val lost = nullToUndefined(
		obj.lost
	)
	val insuranceJustification = nullToUndefined(
		intToNumber(obj.insuranceJustification)
	)
	val cancelPatientInterventionReason = nullToUndefined(
		intToNumber(obj.cancelPatientInterventionReason)
	)
	val status = nullToUndefined(
		longToNumber(obj.status)
	)
	val codeLabel = nullToUndefined(
		obj.codeLabel
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
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	return EncryptedInvoicingCodeJs(js("{" +
		"id:id," +
		"dateCode:dateCode," +
		"logicalId:logicalId," +
		"label:label," +
		"userId:userId," +
		"contactId:contactId," +
		"serviceId:serviceId," +
		"tarificationId:tarificationId," +
		"code:code," +
		"paymentType:paymentType," +
		"paid:paid," +
		"totalAmount:totalAmount," +
		"reimbursement:reimbursement," +
		"patientIntervention:patientIntervention," +
		"amiIntervention:amiIntervention," +
		"doctorSupplement:doctorSupplement," +
		"conventionAmount:conventionAmount," +
		"vat:vat," +
		"error:error," +
		"contract:contract," +
		"contractDate:contractDate," +
		"units:units," +
		"side:side," +
		"timeOfDay:timeOfDay," +
		"eidReadingHour:eidReadingHour," +
		"eidReadingValue:eidReadingValue," +
		"override3rdPayerCode:override3rdPayerCode," +
		"override3rdPayerReason:override3rdPayerReason," +
		"transplantationCode:transplantationCode," +
		"prescriberNorm:prescriberNorm," +
		"productLabel:productLabel," +
		"percentNorm:percentNorm," +
		"prescriberNihii:prescriberNihii," +
		"relatedCode:relatedCode," +
		"prescriptionDate:prescriptionDate," +
		"derogationMaxNumber:derogationMaxNumber," +
		"prescriberSsin:prescriberSsin," +
		"prescriberLastName:prescriberLastName," +
		"prescriberFirstName:prescriberFirstName," +
		"prescriberCdHcParty:prescriberCdHcParty," +
		"locationNihii:locationNihii," +
		"locationCdHcParty:locationCdHcParty," +
		"locationService:locationService," +
		"admissionDate:admissionDate," +
		"canceled:canceled," +
		"accepted:accepted," +
		"pending:pending," +
		"resent:resent," +
		"archived:archived," +
		"lost:lost," +
		"insuranceJustification:insuranceJustification," +
		"cancelPatientInterventionReason:cancelPatientInterventionReason," +
		"status:status," +
		"codeLabel:codeLabel," +
		"options:options," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun invoicingCode_fromJs(obj: EncryptedInvoicingCodeJs): EncryptedInvoicingCode {
	val id = undefinedToNull(obj.id)
	val dateCode = numberToLong(obj.dateCode, "obj.dateCode")
	val logicalId = undefinedToNull(obj.logicalId)
	val label = undefinedToNull(obj.label)
	val userId = undefinedToNull(obj.userId)
	val contactId = undefinedToNull(obj.contactId)
	val serviceId = undefinedToNull(obj.serviceId)
	val tarificationId = undefinedToNull(obj.tarificationId)
	val code = undefinedToNull(obj.code)
	val paymentType = obj.paymentType?.let { nonNull1 ->
		PaymentType.valueOf(nonNull1)
	}
	val paid = undefinedToNull(obj.paid)
	val totalAmount = undefinedToNull(obj.totalAmount)
	val reimbursement = undefinedToNull(obj.reimbursement)
	val patientIntervention = undefinedToNull(obj.patientIntervention)
	val amiIntervention = undefinedToNull(obj.amiIntervention)
	val doctorSupplement = undefinedToNull(obj.doctorSupplement)
	val conventionAmount = undefinedToNull(obj.conventionAmount)
	val vat = undefinedToNull(obj.vat)
	val error = undefinedToNull(obj.error)
	val contract = undefinedToNull(obj.contract)
	val contractDate = numberToLong(obj.contractDate, "obj.contractDate")
	val units = numberToInt(obj.units, "obj.units")
	val side = numberToInt(obj.side, "obj.side")
	val timeOfDay = numberToInt(obj.timeOfDay, "obj.timeOfDay")
	val eidReadingHour = numberToInt(obj.eidReadingHour, "obj.eidReadingHour")
	val eidReadingValue = undefinedToNull(obj.eidReadingValue)
	val override3rdPayerCode = numberToInt(obj.override3rdPayerCode, "obj.override3rdPayerCode")
	val override3rdPayerReason = undefinedToNull(obj.override3rdPayerReason)
	val transplantationCode = numberToInt(obj.transplantationCode, "obj.transplantationCode")
	val prescriberNorm = numberToInt(obj.prescriberNorm, "obj.prescriberNorm")
	val productLabel = undefinedToNull(obj.productLabel)
	val percentNorm = numberToInt(obj.percentNorm, "obj.percentNorm")
	val prescriberNihii = undefinedToNull(obj.prescriberNihii)
	val relatedCode = undefinedToNull(obj.relatedCode)
	val prescriptionDate = numberToLong(obj.prescriptionDate, "obj.prescriptionDate")
	val derogationMaxNumber = numberToInt(obj.derogationMaxNumber, "obj.derogationMaxNumber")
	val prescriberSsin = undefinedToNull(obj.prescriberSsin)
	val prescriberLastName = undefinedToNull(obj.prescriberLastName)
	val prescriberFirstName = undefinedToNull(obj.prescriberFirstName)
	val prescriberCdHcParty = undefinedToNull(obj.prescriberCdHcParty)
	val locationNihii = undefinedToNull(obj.locationNihii)
	val locationCdHcParty = undefinedToNull(obj.locationCdHcParty)
	val locationService = numberToInt(obj.locationService, "obj.locationService")
	val admissionDate = numberToLong(obj.admissionDate, "obj.admissionDate")
	val canceled = undefinedToNull(obj.canceled)
	val accepted = undefinedToNull(obj.accepted)
	val pending = undefinedToNull(obj.pending)
	val resent = undefinedToNull(obj.resent)
	val archived = undefinedToNull(obj.archived)
	val lost = undefinedToNull(obj.lost)
	val insuranceJustification = numberToInt(obj.insuranceJustification, "obj.insuranceJustification")
	val cancelPatientInterventionReason = numberToInt(obj.cancelPatientInterventionReason,
			"obj.cancelPatientInterventionReason")
	val status = numberToLong(obj.status, "obj.status")
	val codeLabel = undefinedToNull(obj.codeLabel)
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
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return EncryptedInvoicingCode(
		id = id,
		dateCode = dateCode,
		logicalId = logicalId,
		label = label,
		userId = userId,
		contactId = contactId,
		serviceId = serviceId,
		tarificationId = tarificationId,
		code = code,
		paymentType = paymentType,
		paid = paid,
		totalAmount = totalAmount,
		reimbursement = reimbursement,
		patientIntervention = patientIntervention,
		amiIntervention = amiIntervention,
		doctorSupplement = doctorSupplement,
		conventionAmount = conventionAmount,
		vat = vat,
		error = error,
		contract = contract,
		contractDate = contractDate,
		units = units,
		side = side,
		timeOfDay = timeOfDay,
		eidReadingHour = eidReadingHour,
		eidReadingValue = eidReadingValue,
		override3rdPayerCode = override3rdPayerCode,
		override3rdPayerReason = override3rdPayerReason,
		transplantationCode = transplantationCode,
		prescriberNorm = prescriberNorm,
		productLabel = productLabel,
		percentNorm = percentNorm,
		prescriberNihii = prescriberNihii,
		relatedCode = relatedCode,
		prescriptionDate = prescriptionDate,
		derogationMaxNumber = derogationMaxNumber,
		prescriberSsin = prescriberSsin,
		prescriberLastName = prescriberLastName,
		prescriberFirstName = prescriberFirstName,
		prescriberCdHcParty = prescriberCdHcParty,
		locationNihii = locationNihii,
		locationCdHcParty = locationCdHcParty,
		locationService = locationService,
		admissionDate = admissionDate,
		canceled = canceled,
		accepted = accepted,
		pending = pending,
		resent = resent,
		archived = archived,
		lost = lost,
		insuranceJustification = insuranceJustification,
		cancelPatientInterventionReason = cancelPatientInterventionReason,
		status = status,
		codeLabel = codeLabel,
		options = options,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun invoicingCode_toJs(obj: InvoicingCode): InvoicingCodeJs = when (obj) {
	is EncryptedInvoicingCode -> invoicingCode_toJs(obj)
	is DecryptedInvoicingCode -> invoicingCode_toJs(obj)
}

public fun invoicingCode_fromJs(obj: InvoicingCodeJs): InvoicingCode = if (obj.isEncrypted) {
	invoicingCode_fromJs(obj as EncryptedInvoicingCodeJs)
} else {
	invoicingCode_fromJs(obj as DecryptedInvoicingCodeJs)
}
