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
import com.icure.cardinal.sdk.model.embed.ContractChangeType
import com.icure.cardinal.sdk.model.embed.DecryptedMedicalHouseContract
import com.icure.cardinal.sdk.model.embed.EncryptedMedicalHouseContract
import com.icure.cardinal.sdk.model.embed.MedicalHouseContract
import com.icure.cardinal.sdk.model.embed.MhcSignatureType
import com.icure.cardinal.sdk.model.embed.SuspensionReason
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun medicalHouseContract_toJs(obj: DecryptedMedicalHouseContract): DecryptedMedicalHouseContractJs {
	val contractId = nullToUndefined(
		obj.contractId
	)
	val validFrom = nullToUndefined(
		longToNumber(obj.validFrom)
	)
	val validTo = nullToUndefined(
		longToNumber(obj.validTo)
	)
	val mmNihii = nullToUndefined(
		obj.mmNihii
	)
	val hcpId = nullToUndefined(
		obj.hcpId
	)
	val changeType = nullToUndefined(
		obj.changeType?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val parentContractId = nullToUndefined(
		obj.parentContractId
	)
	val changedBy = nullToUndefined(
		obj.changedBy
	)
	val startOfContract = nullToUndefined(
		longToNumber(obj.startOfContract)
	)
	val startOfCoverage = nullToUndefined(
		longToNumber(obj.startOfCoverage)
	)
	val endOfContract = nullToUndefined(
		longToNumber(obj.endOfContract)
	)
	val endOfCoverage = nullToUndefined(
		longToNumber(obj.endOfCoverage)
	)
	val kine = obj.kine
	val gp = obj.gp
	val ptd = obj.ptd
	val nurse = obj.nurse
	val noKine = obj.noKine
	val noGp = obj.noGp
	val noNurse = obj.noNurse
	val unsubscriptionReasonId = nullToUndefined(
		intToNumber(obj.unsubscriptionReasonId)
	)
	val ptdStart = nullToUndefined(
		longToNumber(obj.ptdStart)
	)
	val ptdEnd = nullToUndefined(
		longToNumber(obj.ptdEnd)
	)
	val ptdLastInvoiced = nullToUndefined(
		longToNumber(obj.ptdLastInvoiced)
	)
	val startOfSuspension = nullToUndefined(
		longToNumber(obj.startOfSuspension)
	)
	val endOfSuspension = nullToUndefined(
		longToNumber(obj.endOfSuspension)
	)
	val suspensionReason = nullToUndefined(
		obj.suspensionReason?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val suspensionSource = nullToUndefined(
		obj.suspensionSource
	)
	val forcedSuspension = obj.forcedSuspension
	val signatureType = nullToUndefined(
		obj.signatureType?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val status = nullToUndefined(
		intToNumber(obj.status)
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
	val receipts = mapToObject(
		obj.receipts,
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
	return DecryptedMedicalHouseContractJs(js("{" +
		"contractId:contractId," +
		"validFrom:validFrom," +
		"validTo:validTo," +
		"mmNihii:mmNihii," +
		"hcpId:hcpId," +
		"changeType:changeType," +
		"parentContractId:parentContractId," +
		"changedBy:changedBy," +
		"startOfContract:startOfContract," +
		"startOfCoverage:startOfCoverage," +
		"endOfContract:endOfContract," +
		"endOfCoverage:endOfCoverage," +
		"kine:kine," +
		"gp:gp," +
		"ptd:ptd," +
		"nurse:nurse," +
		"noKine:noKine," +
		"noGp:noGp," +
		"noNurse:noNurse," +
		"unsubscriptionReasonId:unsubscriptionReasonId," +
		"ptdStart:ptdStart," +
		"ptdEnd:ptdEnd," +
		"ptdLastInvoiced:ptdLastInvoiced," +
		"startOfSuspension:startOfSuspension," +
		"endOfSuspension:endOfSuspension," +
		"suspensionReason:suspensionReason," +
		"suspensionSource:suspensionSource," +
		"forcedSuspension:forcedSuspension," +
		"signatureType:signatureType," +
		"status:status," +
		"options:options," +
		"receipts:receipts," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun medicalHouseContract_fromJs(obj: DecryptedMedicalHouseContractJs): DecryptedMedicalHouseContract {
	val contractId = undefinedToNull(obj.contractId)
	val validFrom = numberToLong(obj.validFrom, "obj.validFrom")
	val validTo = numberToLong(obj.validTo, "obj.validTo")
	val mmNihii = undefinedToNull(obj.mmNihii)
	val hcpId = undefinedToNull(obj.hcpId)
	val changeType = obj.changeType?.let { nonNull1 ->
		ContractChangeType.valueOf(nonNull1)
	}
	val parentContractId = undefinedToNull(obj.parentContractId)
	val changedBy = undefinedToNull(obj.changedBy)
	val startOfContract = numberToLong(obj.startOfContract, "obj.startOfContract")
	val startOfCoverage = numberToLong(obj.startOfCoverage, "obj.startOfCoverage")
	val endOfContract = numberToLong(obj.endOfContract, "obj.endOfContract")
	val endOfCoverage = numberToLong(obj.endOfCoverage, "obj.endOfCoverage")
	val kine = obj.kine
	val gp = obj.gp
	val ptd = obj.ptd
	val nurse = obj.nurse
	val noKine = obj.noKine
	val noGp = obj.noGp
	val noNurse = obj.noNurse
	val unsubscriptionReasonId = numberToInt(obj.unsubscriptionReasonId, "obj.unsubscriptionReasonId")
	val ptdStart = numberToLong(obj.ptdStart, "obj.ptdStart")
	val ptdEnd = numberToLong(obj.ptdEnd, "obj.ptdEnd")
	val ptdLastInvoiced = numberToLong(obj.ptdLastInvoiced, "obj.ptdLastInvoiced")
	val startOfSuspension = numberToLong(obj.startOfSuspension, "obj.startOfSuspension")
	val endOfSuspension = numberToLong(obj.endOfSuspension, "obj.endOfSuspension")
	val suspensionReason = obj.suspensionReason?.let { nonNull1 ->
		SuspensionReason.valueOf(nonNull1)
	}
	val suspensionSource = undefinedToNull(obj.suspensionSource)
	val forcedSuspension = obj.forcedSuspension
	val signatureType = obj.signatureType?.let { nonNull1 ->
		MhcSignatureType.valueOf(nonNull1)
	}
	val status = numberToInt(obj.status, "obj.status")
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
	val receipts = objectToMap(
		obj.receipts,
		"obj.receipts",
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
	return DecryptedMedicalHouseContract(
		contractId = contractId,
		validFrom = validFrom,
		validTo = validTo,
		mmNihii = mmNihii,
		hcpId = hcpId,
		changeType = changeType,
		parentContractId = parentContractId,
		changedBy = changedBy,
		startOfContract = startOfContract,
		startOfCoverage = startOfCoverage,
		endOfContract = endOfContract,
		endOfCoverage = endOfCoverage,
		kine = kine,
		gp = gp,
		ptd = ptd,
		nurse = nurse,
		noKine = noKine,
		noGp = noGp,
		noNurse = noNurse,
		unsubscriptionReasonId = unsubscriptionReasonId,
		ptdStart = ptdStart,
		ptdEnd = ptdEnd,
		ptdLastInvoiced = ptdLastInvoiced,
		startOfSuspension = startOfSuspension,
		endOfSuspension = endOfSuspension,
		suspensionReason = suspensionReason,
		suspensionSource = suspensionSource,
		forcedSuspension = forcedSuspension,
		signatureType = signatureType,
		status = status,
		options = options,
		receipts = receipts,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun medicalHouseContract_toJs(obj: EncryptedMedicalHouseContract): EncryptedMedicalHouseContractJs {
	val contractId = nullToUndefined(
		obj.contractId
	)
	val validFrom = nullToUndefined(
		longToNumber(obj.validFrom)
	)
	val validTo = nullToUndefined(
		longToNumber(obj.validTo)
	)
	val mmNihii = nullToUndefined(
		obj.mmNihii
	)
	val hcpId = nullToUndefined(
		obj.hcpId
	)
	val changeType = nullToUndefined(
		obj.changeType?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val parentContractId = nullToUndefined(
		obj.parentContractId
	)
	val changedBy = nullToUndefined(
		obj.changedBy
	)
	val startOfContract = nullToUndefined(
		longToNumber(obj.startOfContract)
	)
	val startOfCoverage = nullToUndefined(
		longToNumber(obj.startOfCoverage)
	)
	val endOfContract = nullToUndefined(
		longToNumber(obj.endOfContract)
	)
	val endOfCoverage = nullToUndefined(
		longToNumber(obj.endOfCoverage)
	)
	val kine = obj.kine
	val gp = obj.gp
	val ptd = obj.ptd
	val nurse = obj.nurse
	val noKine = obj.noKine
	val noGp = obj.noGp
	val noNurse = obj.noNurse
	val unsubscriptionReasonId = nullToUndefined(
		intToNumber(obj.unsubscriptionReasonId)
	)
	val ptdStart = nullToUndefined(
		longToNumber(obj.ptdStart)
	)
	val ptdEnd = nullToUndefined(
		longToNumber(obj.ptdEnd)
	)
	val ptdLastInvoiced = nullToUndefined(
		longToNumber(obj.ptdLastInvoiced)
	)
	val startOfSuspension = nullToUndefined(
		longToNumber(obj.startOfSuspension)
	)
	val endOfSuspension = nullToUndefined(
		longToNumber(obj.endOfSuspension)
	)
	val suspensionReason = nullToUndefined(
		obj.suspensionReason?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val suspensionSource = nullToUndefined(
		obj.suspensionSource
	)
	val forcedSuspension = obj.forcedSuspension
	val signatureType = nullToUndefined(
		obj.signatureType?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val status = nullToUndefined(
		intToNumber(obj.status)
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
	val receipts = mapToObject(
		obj.receipts,
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
	return EncryptedMedicalHouseContractJs(js("{" +
		"contractId:contractId," +
		"validFrom:validFrom," +
		"validTo:validTo," +
		"mmNihii:mmNihii," +
		"hcpId:hcpId," +
		"changeType:changeType," +
		"parentContractId:parentContractId," +
		"changedBy:changedBy," +
		"startOfContract:startOfContract," +
		"startOfCoverage:startOfCoverage," +
		"endOfContract:endOfContract," +
		"endOfCoverage:endOfCoverage," +
		"kine:kine," +
		"gp:gp," +
		"ptd:ptd," +
		"nurse:nurse," +
		"noKine:noKine," +
		"noGp:noGp," +
		"noNurse:noNurse," +
		"unsubscriptionReasonId:unsubscriptionReasonId," +
		"ptdStart:ptdStart," +
		"ptdEnd:ptdEnd," +
		"ptdLastInvoiced:ptdLastInvoiced," +
		"startOfSuspension:startOfSuspension," +
		"endOfSuspension:endOfSuspension," +
		"suspensionReason:suspensionReason," +
		"suspensionSource:suspensionSource," +
		"forcedSuspension:forcedSuspension," +
		"signatureType:signatureType," +
		"status:status," +
		"options:options," +
		"receipts:receipts," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun medicalHouseContract_fromJs(obj: EncryptedMedicalHouseContractJs): EncryptedMedicalHouseContract {
	val contractId = undefinedToNull(obj.contractId)
	val validFrom = numberToLong(obj.validFrom, "obj.validFrom")
	val validTo = numberToLong(obj.validTo, "obj.validTo")
	val mmNihii = undefinedToNull(obj.mmNihii)
	val hcpId = undefinedToNull(obj.hcpId)
	val changeType = obj.changeType?.let { nonNull1 ->
		ContractChangeType.valueOf(nonNull1)
	}
	val parentContractId = undefinedToNull(obj.parentContractId)
	val changedBy = undefinedToNull(obj.changedBy)
	val startOfContract = numberToLong(obj.startOfContract, "obj.startOfContract")
	val startOfCoverage = numberToLong(obj.startOfCoverage, "obj.startOfCoverage")
	val endOfContract = numberToLong(obj.endOfContract, "obj.endOfContract")
	val endOfCoverage = numberToLong(obj.endOfCoverage, "obj.endOfCoverage")
	val kine = obj.kine
	val gp = obj.gp
	val ptd = obj.ptd
	val nurse = obj.nurse
	val noKine = obj.noKine
	val noGp = obj.noGp
	val noNurse = obj.noNurse
	val unsubscriptionReasonId = numberToInt(obj.unsubscriptionReasonId, "obj.unsubscriptionReasonId")
	val ptdStart = numberToLong(obj.ptdStart, "obj.ptdStart")
	val ptdEnd = numberToLong(obj.ptdEnd, "obj.ptdEnd")
	val ptdLastInvoiced = numberToLong(obj.ptdLastInvoiced, "obj.ptdLastInvoiced")
	val startOfSuspension = numberToLong(obj.startOfSuspension, "obj.startOfSuspension")
	val endOfSuspension = numberToLong(obj.endOfSuspension, "obj.endOfSuspension")
	val suspensionReason = obj.suspensionReason?.let { nonNull1 ->
		SuspensionReason.valueOf(nonNull1)
	}
	val suspensionSource = undefinedToNull(obj.suspensionSource)
	val forcedSuspension = obj.forcedSuspension
	val signatureType = obj.signatureType?.let { nonNull1 ->
		MhcSignatureType.valueOf(nonNull1)
	}
	val status = numberToInt(obj.status, "obj.status")
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
	val receipts = objectToMap(
		obj.receipts,
		"obj.receipts",
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
	return EncryptedMedicalHouseContract(
		contractId = contractId,
		validFrom = validFrom,
		validTo = validTo,
		mmNihii = mmNihii,
		hcpId = hcpId,
		changeType = changeType,
		parentContractId = parentContractId,
		changedBy = changedBy,
		startOfContract = startOfContract,
		startOfCoverage = startOfCoverage,
		endOfContract = endOfContract,
		endOfCoverage = endOfCoverage,
		kine = kine,
		gp = gp,
		ptd = ptd,
		nurse = nurse,
		noKine = noKine,
		noGp = noGp,
		noNurse = noNurse,
		unsubscriptionReasonId = unsubscriptionReasonId,
		ptdStart = ptdStart,
		ptdEnd = ptdEnd,
		ptdLastInvoiced = ptdLastInvoiced,
		startOfSuspension = startOfSuspension,
		endOfSuspension = endOfSuspension,
		suspensionReason = suspensionReason,
		suspensionSource = suspensionSource,
		forcedSuspension = forcedSuspension,
		signatureType = signatureType,
		status = status,
		options = options,
		receipts = receipts,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun medicalHouseContract_toJs(obj: MedicalHouseContract): MedicalHouseContractJs = when (obj) {
	is EncryptedMedicalHouseContract -> medicalHouseContract_toJs(obj)
	is DecryptedMedicalHouseContract -> medicalHouseContract_toJs(obj)
}

public fun medicalHouseContract_fromJs(obj: MedicalHouseContractJs): MedicalHouseContract = if (obj.isEncrypted) {
	medicalHouseContract_fromJs(obj as EncryptedMedicalHouseContractJs)
} else {
	medicalHouseContract_fromJs(obj as DecryptedMedicalHouseContractJs)
}
