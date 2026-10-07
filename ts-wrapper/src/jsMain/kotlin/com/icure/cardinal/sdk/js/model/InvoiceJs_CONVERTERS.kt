// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.intToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.IdentifierJs
import com.icure.cardinal.sdk.js.model.base.codeStub_fromJs
import com.icure.cardinal.sdk.js.model.base.codeStub_toJs
import com.icure.cardinal.sdk.js.model.base.identifier_fromJs
import com.icure.cardinal.sdk.js.model.base.identifier_toJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedInvoicingCodeJs
import com.icure.cardinal.sdk.js.model.embed.DelegationJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedInvoicingCodeJs
import com.icure.cardinal.sdk.js.model.embed.PaymentJs
import com.icure.cardinal.sdk.js.model.embed.delegation_fromJs
import com.icure.cardinal.sdk.js.model.embed.delegation_toJs
import com.icure.cardinal.sdk.js.model.embed.identityDocumentReader_fromJs
import com.icure.cardinal.sdk.js.model.embed.identityDocumentReader_toJs
import com.icure.cardinal.sdk.js.model.embed.invoicingCode_fromJs
import com.icure.cardinal.sdk.js.model.embed.invoicingCode_toJs
import com.icure.cardinal.sdk.js.model.embed.payment_fromJs
import com.icure.cardinal.sdk.js.model.embed.payment_toJs
import com.icure.cardinal.sdk.js.model.embed.securityMetadata_fromJs
import com.icure.cardinal.sdk.js.model.embed.securityMetadata_toJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_fromJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_toJs
import com.icure.cardinal.sdk.model.DecryptedInvoice
import com.icure.cardinal.sdk.model.EncryptedInvoice
import com.icure.cardinal.sdk.model.Invoice
import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.embed.DecryptedInvoicingCode
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.EncryptedInvoicingCode
import com.icure.cardinal.sdk.model.embed.InvoiceInterventionType
import com.icure.cardinal.sdk.model.embed.InvoiceType
import com.icure.cardinal.sdk.model.embed.MediumType
import com.icure.cardinal.sdk.model.embed.Payment
import com.icure.cardinal.sdk.model.embed.PaymentType
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Set

@Suppress("UNUSED_VARIABLE")
public fun invoice_toJs(obj: DecryptedInvoice): DecryptedInvoiceJs {
	val id = obj.id
	val rev = nullToUndefined(
		obj.rev
	)
	val identifier = listToArray(
		obj.identifier,
		{ x1: Identifier ->
			identifier_toJs(x1)
		},
	)
	val created = nullToUndefined(
		longToNumber(obj.created)
	)
	val modified = nullToUndefined(
		longToNumber(obj.modified)
	)
	val author = nullToUndefined(
		obj.author
	)
	val responsible = nullToUndefined(
		obj.responsible
	)
	val medicalLocationId = nullToUndefined(
		obj.medicalLocationId
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
	val endOfLife = nullToUndefined(
		longToNumber(obj.endOfLife)
	)
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
	)
	val invoiceDate = nullToUndefined(
		longToNumber(obj.invoiceDate)
	)
	val sentDate = nullToUndefined(
		longToNumber(obj.sentDate)
	)
	val printedDate = nullToUndefined(
		longToNumber(obj.printedDate)
	)
	val invoicingCodes = listToArray(
		obj.invoicingCodes,
		{ x1: DecryptedInvoicingCode ->
			invoicingCode_toJs(x1)
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
	val recipientType = nullToUndefined(
		obj.recipientType
	)
	val recipientId = nullToUndefined(
		obj.recipientId
	)
	val invoiceReference = nullToUndefined(
		obj.invoiceReference
	)
	val decisionReference = nullToUndefined(
		obj.decisionReference
	)
	val thirdPartyReference = nullToUndefined(
		obj.thirdPartyReference
	)
	val thirdPartyPaymentJustification = nullToUndefined(
		obj.thirdPartyPaymentJustification
	)
	val thirdPartyPaymentReason = nullToUndefined(
		obj.thirdPartyPaymentReason
	)
	val reason = nullToUndefined(
		obj.reason
	)
	val invoiceType = nullToUndefined(
		obj.invoiceType?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val sentMediumType = nullToUndefined(
		obj.sentMediumType?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val interventionType = nullToUndefined(
		obj.interventionType?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val groupId = nullToUndefined(
		obj.groupId
	)
	val paymentType = nullToUndefined(
		obj.paymentType?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val paid = nullToUndefined(
		obj.paid
	)
	val payments = nullToUndefined(
		listToArray(
			obj.payments,
			{ x1: Payment ->
				payment_toJs(x1)
			},
		)
	)
	val gnotionNihii = nullToUndefined(
		obj.gnotionNihii
	)
	val gnotionSsin = nullToUndefined(
		obj.gnotionSsin
	)
	val gnotionLastName = nullToUndefined(
		obj.gnotionLastName
	)
	val gnotionFirstName = nullToUndefined(
		obj.gnotionFirstName
	)
	val gnotionCdHcParty = nullToUndefined(
		obj.gnotionCdHcParty
	)
	val invoicePeriod = nullToUndefined(
		intToNumber(obj.invoicePeriod)
	)
	val careProviderType = nullToUndefined(
		obj.careProviderType
	)
	val internshipNihii = nullToUndefined(
		obj.internshipNihii
	)
	val internshipSsin = nullToUndefined(
		obj.internshipSsin
	)
	val internshipLastName = nullToUndefined(
		obj.internshipLastName
	)
	val internshipFirstName = nullToUndefined(
		obj.internshipFirstName
	)
	val internshipCdHcParty = nullToUndefined(
		obj.internshipCdHcParty
	)
	val internshipCbe = nullToUndefined(
		obj.internshipCbe
	)
	val supervisorNihii = nullToUndefined(
		obj.supervisorNihii
	)
	val supervisorSsin = nullToUndefined(
		obj.supervisorSsin
	)
	val supervisorLastName = nullToUndefined(
		obj.supervisorLastName
	)
	val supervisorFirstName = nullToUndefined(
		obj.supervisorFirstName
	)
	val supervisorCdHcParty = nullToUndefined(
		obj.supervisorCdHcParty
	)
	val supervisorCbe = nullToUndefined(
		obj.supervisorCbe
	)
	val error = nullToUndefined(
		obj.error
	)
	val encounterLocationName = nullToUndefined(
		obj.encounterLocationName
	)
	val encounterLocationNihii = nullToUndefined(
		obj.encounterLocationNihii
	)
	val encounterLocationNorm = nullToUndefined(
		intToNumber(obj.encounterLocationNorm)
	)
	val longDelayJustification = nullToUndefined(
		intToNumber(obj.longDelayJustification)
	)
	val correctiveInvoiceId = nullToUndefined(
		obj.correctiveInvoiceId
	)
	val correctedInvoiceId = nullToUndefined(
		obj.correctedInvoiceId
	)
	val creditNote = nullToUndefined(
		obj.creditNote
	)
	val creditNoteRelatedInvoiceId = nullToUndefined(
		obj.creditNoteRelatedInvoiceId
	)
	val idDocument = nullToUndefined(
		obj.idDocument?.let { nonNull1 ->
			identityDocumentReader_toJs(nonNull1)
		}
	)
	val admissionDate = nullToUndefined(
		longToNumber(obj.admissionDate)
	)
	val locationNihii = nullToUndefined(
		obj.locationNihii
	)
	val locationService = nullToUndefined(
		intToNumber(obj.locationService)
	)
	val cancelReason = nullToUndefined(
		obj.cancelReason
	)
	val cancelDate = nullToUndefined(
		longToNumber(obj.cancelDate)
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
	val secretForeignKeys = setToArray(
		obj.secretForeignKeys,
		{ x1: String ->
			x1
		},
	)
	val cryptedForeignKeys = mapToObject(
		obj.cryptedForeignKeys,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val delegations = mapToObject(
		obj.delegations,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val encryptionKeys = mapToObject(
		obj.encryptionKeys,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	val securityMetadata = nullToUndefined(
		obj.securityMetadata?.let { nonNull1 ->
			securityMetadata_toJs(nonNull1)
		}
	)
	return DecryptedInvoiceJs(js("{" +
		"id:id," +
		"rev:rev," +
		"identifier:identifier," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"medicalLocationId:medicalLocationId," +
		"tags:tags," +
		"codes:codes," +
		"endOfLife:endOfLife," +
		"deletionDate:deletionDate," +
		"invoiceDate:invoiceDate," +
		"sentDate:sentDate," +
		"printedDate:printedDate," +
		"invoicingCodes:invoicingCodes," +
		"receipts:receipts," +
		"recipientType:recipientType," +
		"recipientId:recipientId," +
		"invoiceReference:invoiceReference," +
		"decisionReference:decisionReference," +
		"thirdPartyReference:thirdPartyReference," +
		"thirdPartyPaymentJustification:thirdPartyPaymentJustification," +
		"thirdPartyPaymentReason:thirdPartyPaymentReason," +
		"reason:reason," +
		"invoiceType:invoiceType," +
		"sentMediumType:sentMediumType," +
		"interventionType:interventionType," +
		"groupId:groupId," +
		"paymentType:paymentType," +
		"paid:paid," +
		"payments:payments," +
		"gnotionNihii:gnotionNihii," +
		"gnotionSsin:gnotionSsin," +
		"gnotionLastName:gnotionLastName," +
		"gnotionFirstName:gnotionFirstName," +
		"gnotionCdHcParty:gnotionCdHcParty," +
		"invoicePeriod:invoicePeriod," +
		"careProviderType:careProviderType," +
		"internshipNihii:internshipNihii," +
		"internshipSsin:internshipSsin," +
		"internshipLastName:internshipLastName," +
		"internshipFirstName:internshipFirstName," +
		"internshipCdHcParty:internshipCdHcParty," +
		"internshipCbe:internshipCbe," +
		"supervisorNihii:supervisorNihii," +
		"supervisorSsin:supervisorSsin," +
		"supervisorLastName:supervisorLastName," +
		"supervisorFirstName:supervisorFirstName," +
		"supervisorCdHcParty:supervisorCdHcParty," +
		"supervisorCbe:supervisorCbe," +
		"error:error," +
		"encounterLocationName:encounterLocationName," +
		"encounterLocationNihii:encounterLocationNihii," +
		"encounterLocationNorm:encounterLocationNorm," +
		"longDelayJustification:longDelayJustification," +
		"correctiveInvoiceId:correctiveInvoiceId," +
		"correctedInvoiceId:correctedInvoiceId," +
		"creditNote:creditNote," +
		"creditNoteRelatedInvoiceId:creditNoteRelatedInvoiceId," +
		"idDocument:idDocument," +
		"admissionDate:admissionDate," +
		"locationNihii:locationNihii," +
		"locationService:locationService," +
		"cancelReason:cancelReason," +
		"cancelDate:cancelDate," +
		"options:options," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata" +
	"}"))
}

public fun invoice_fromJs(obj: DecryptedInvoiceJs): DecryptedInvoice {
	val id = obj.id
	val rev = undefinedToNull(obj.rev)
	val identifier = arrayToList(
		obj.identifier,
		"obj.identifier",
		{ x1: IdentifierJs ->
			identifier_fromJs(x1)
		},
	)
	val created = numberToLong(obj.created, "obj.created")
	val modified = numberToLong(obj.modified, "obj.modified")
	val author = undefinedToNull(obj.author)
	val responsible = undefinedToNull(obj.responsible)
	val medicalLocationId = undefinedToNull(obj.medicalLocationId)
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
	val endOfLife = numberToLong(obj.endOfLife, "obj.endOfLife")
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val invoiceDate = numberToLong(obj.invoiceDate, "obj.invoiceDate")
	val sentDate = numberToLong(obj.sentDate, "obj.sentDate")
	val printedDate = numberToLong(obj.printedDate, "obj.printedDate")
	val invoicingCodes = arrayToList(
		obj.invoicingCodes,
		"obj.invoicingCodes",
		{ x1: DecryptedInvoicingCodeJs ->
			invoicingCode_fromJs(x1)
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
	val recipientType = undefinedToNull(obj.recipientType)
	val recipientId = undefinedToNull(obj.recipientId)
	val invoiceReference = undefinedToNull(obj.invoiceReference)
	val decisionReference = undefinedToNull(obj.decisionReference)
	val thirdPartyReference = undefinedToNull(obj.thirdPartyReference)
	val thirdPartyPaymentJustification = undefinedToNull(obj.thirdPartyPaymentJustification)
	val thirdPartyPaymentReason = undefinedToNull(obj.thirdPartyPaymentReason)
	val reason = undefinedToNull(obj.reason)
	val invoiceType = obj.invoiceType?.let { nonNull1 ->
		InvoiceType.valueOf(nonNull1)
	}
	val sentMediumType = obj.sentMediumType?.let { nonNull1 ->
		MediumType.valueOf(nonNull1)
	}
	val interventionType = obj.interventionType?.let { nonNull1 ->
		InvoiceInterventionType.valueOf(nonNull1)
	}
	val groupId = undefinedToNull(obj.groupId)
	val paymentType = obj.paymentType?.let { nonNull1 ->
		PaymentType.valueOf(nonNull1)
	}
	val paid = undefinedToNull(obj.paid)
	val payments = arrayToList(
		obj.payments,
		"obj.payments",
		{ x1: PaymentJs ->
			payment_fromJs(x1)
		},
	)
	val gnotionNihii = undefinedToNull(obj.gnotionNihii)
	val gnotionSsin = undefinedToNull(obj.gnotionSsin)
	val gnotionLastName = undefinedToNull(obj.gnotionLastName)
	val gnotionFirstName = undefinedToNull(obj.gnotionFirstName)
	val gnotionCdHcParty = undefinedToNull(obj.gnotionCdHcParty)
	val invoicePeriod = numberToInt(obj.invoicePeriod, "obj.invoicePeriod")
	val careProviderType = undefinedToNull(obj.careProviderType)
	val internshipNihii = undefinedToNull(obj.internshipNihii)
	val internshipSsin = undefinedToNull(obj.internshipSsin)
	val internshipLastName = undefinedToNull(obj.internshipLastName)
	val internshipFirstName = undefinedToNull(obj.internshipFirstName)
	val internshipCdHcParty = undefinedToNull(obj.internshipCdHcParty)
	val internshipCbe = undefinedToNull(obj.internshipCbe)
	val supervisorNihii = undefinedToNull(obj.supervisorNihii)
	val supervisorSsin = undefinedToNull(obj.supervisorSsin)
	val supervisorLastName = undefinedToNull(obj.supervisorLastName)
	val supervisorFirstName = undefinedToNull(obj.supervisorFirstName)
	val supervisorCdHcParty = undefinedToNull(obj.supervisorCdHcParty)
	val supervisorCbe = undefinedToNull(obj.supervisorCbe)
	val error = undefinedToNull(obj.error)
	val encounterLocationName = undefinedToNull(obj.encounterLocationName)
	val encounterLocationNihii = undefinedToNull(obj.encounterLocationNihii)
	val encounterLocationNorm = numberToInt(obj.encounterLocationNorm, "obj.encounterLocationNorm")
	val longDelayJustification = numberToInt(obj.longDelayJustification, "obj.longDelayJustification")
	val correctiveInvoiceId = undefinedToNull(obj.correctiveInvoiceId)
	val correctedInvoiceId = undefinedToNull(obj.correctedInvoiceId)
	val creditNote = undefinedToNull(obj.creditNote)
	val creditNoteRelatedInvoiceId = undefinedToNull(obj.creditNoteRelatedInvoiceId)
	val idDocument = obj.idDocument?.let { nonNull1 ->
		identityDocumentReader_fromJs(nonNull1)
	}
	val admissionDate = numberToLong(obj.admissionDate, "obj.admissionDate")
	val locationNihii = undefinedToNull(obj.locationNihii)
	val locationService = numberToInt(obj.locationService, "obj.locationService")
	val cancelReason = undefinedToNull(obj.cancelReason)
	val cancelDate = numberToLong(obj.cancelDate, "obj.cancelDate")
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
	val secretForeignKeys = arrayToSet(
		obj.secretForeignKeys,
		"obj.secretForeignKeys",
		{ x1: String ->
			x1
		},
	)
	val cryptedForeignKeys = objectToMap(
		obj.cryptedForeignKeys,
		"obj.cryptedForeignKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val delegations = objectToMap(
		obj.delegations,
		"obj.delegations",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val encryptionKeys = objectToMap(
		obj.encryptionKeys,
		"obj.encryptionKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_fromJs(nonNull1)
	}
	return DecryptedInvoice(
		id = id,
		rev = rev,
		identifier = identifier,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		medicalLocationId = medicalLocationId,
		tags = tags,
		codes = codes,
		endOfLife = endOfLife,
		deletionDate = deletionDate,
		invoiceDate = invoiceDate,
		sentDate = sentDate,
		printedDate = printedDate,
		invoicingCodes = invoicingCodes,
		receipts = receipts,
		recipientType = recipientType,
		recipientId = recipientId,
		invoiceReference = invoiceReference,
		decisionReference = decisionReference,
		thirdPartyReference = thirdPartyReference,
		thirdPartyPaymentJustification = thirdPartyPaymentJustification,
		thirdPartyPaymentReason = thirdPartyPaymentReason,
		reason = reason,
		invoiceType = invoiceType,
		sentMediumType = sentMediumType,
		interventionType = interventionType,
		groupId = groupId,
		paymentType = paymentType,
		paid = paid,
		payments = payments,
		gnotionNihii = gnotionNihii,
		gnotionSsin = gnotionSsin,
		gnotionLastName = gnotionLastName,
		gnotionFirstName = gnotionFirstName,
		gnotionCdHcParty = gnotionCdHcParty,
		invoicePeriod = invoicePeriod,
		careProviderType = careProviderType,
		internshipNihii = internshipNihii,
		internshipSsin = internshipSsin,
		internshipLastName = internshipLastName,
		internshipFirstName = internshipFirstName,
		internshipCdHcParty = internshipCdHcParty,
		internshipCbe = internshipCbe,
		supervisorNihii = supervisorNihii,
		supervisorSsin = supervisorSsin,
		supervisorLastName = supervisorLastName,
		supervisorFirstName = supervisorFirstName,
		supervisorCdHcParty = supervisorCdHcParty,
		supervisorCbe = supervisorCbe,
		error = error,
		encounterLocationName = encounterLocationName,
		encounterLocationNihii = encounterLocationNihii,
		encounterLocationNorm = encounterLocationNorm,
		longDelayJustification = longDelayJustification,
		correctiveInvoiceId = correctiveInvoiceId,
		correctedInvoiceId = correctedInvoiceId,
		creditNote = creditNote,
		creditNoteRelatedInvoiceId = creditNoteRelatedInvoiceId,
		idDocument = idDocument,
		admissionDate = admissionDate,
		locationNihii = locationNihii,
		locationService = locationService,
		cancelReason = cancelReason,
		cancelDate = cancelDate,
		options = options,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun invoice_toJs(obj: EncryptedInvoice): EncryptedInvoiceJs {
	val id = obj.id
	val rev = nullToUndefined(
		obj.rev
	)
	val identifier = listToArray(
		obj.identifier,
		{ x1: Identifier ->
			identifier_toJs(x1)
		},
	)
	val created = nullToUndefined(
		longToNumber(obj.created)
	)
	val modified = nullToUndefined(
		longToNumber(obj.modified)
	)
	val author = nullToUndefined(
		obj.author
	)
	val responsible = nullToUndefined(
		obj.responsible
	)
	val medicalLocationId = nullToUndefined(
		obj.medicalLocationId
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
	val endOfLife = nullToUndefined(
		longToNumber(obj.endOfLife)
	)
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
	)
	val invoiceDate = nullToUndefined(
		longToNumber(obj.invoiceDate)
	)
	val sentDate = nullToUndefined(
		longToNumber(obj.sentDate)
	)
	val printedDate = nullToUndefined(
		longToNumber(obj.printedDate)
	)
	val invoicingCodes = listToArray(
		obj.invoicingCodes,
		{ x1: EncryptedInvoicingCode ->
			invoicingCode_toJs(x1)
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
	val recipientType = nullToUndefined(
		obj.recipientType
	)
	val recipientId = nullToUndefined(
		obj.recipientId
	)
	val invoiceReference = nullToUndefined(
		obj.invoiceReference
	)
	val decisionReference = nullToUndefined(
		obj.decisionReference
	)
	val thirdPartyReference = nullToUndefined(
		obj.thirdPartyReference
	)
	val thirdPartyPaymentJustification = nullToUndefined(
		obj.thirdPartyPaymentJustification
	)
	val thirdPartyPaymentReason = nullToUndefined(
		obj.thirdPartyPaymentReason
	)
	val reason = nullToUndefined(
		obj.reason
	)
	val invoiceType = nullToUndefined(
		obj.invoiceType?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val sentMediumType = nullToUndefined(
		obj.sentMediumType?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val interventionType = nullToUndefined(
		obj.interventionType?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val groupId = nullToUndefined(
		obj.groupId
	)
	val paymentType = nullToUndefined(
		obj.paymentType?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val paid = nullToUndefined(
		obj.paid
	)
	val payments = nullToUndefined(
		listToArray(
			obj.payments,
			{ x1: Payment ->
				payment_toJs(x1)
			},
		)
	)
	val gnotionNihii = nullToUndefined(
		obj.gnotionNihii
	)
	val gnotionSsin = nullToUndefined(
		obj.gnotionSsin
	)
	val gnotionLastName = nullToUndefined(
		obj.gnotionLastName
	)
	val gnotionFirstName = nullToUndefined(
		obj.gnotionFirstName
	)
	val gnotionCdHcParty = nullToUndefined(
		obj.gnotionCdHcParty
	)
	val invoicePeriod = nullToUndefined(
		intToNumber(obj.invoicePeriod)
	)
	val careProviderType = nullToUndefined(
		obj.careProviderType
	)
	val internshipNihii = nullToUndefined(
		obj.internshipNihii
	)
	val internshipSsin = nullToUndefined(
		obj.internshipSsin
	)
	val internshipLastName = nullToUndefined(
		obj.internshipLastName
	)
	val internshipFirstName = nullToUndefined(
		obj.internshipFirstName
	)
	val internshipCdHcParty = nullToUndefined(
		obj.internshipCdHcParty
	)
	val internshipCbe = nullToUndefined(
		obj.internshipCbe
	)
	val supervisorNihii = nullToUndefined(
		obj.supervisorNihii
	)
	val supervisorSsin = nullToUndefined(
		obj.supervisorSsin
	)
	val supervisorLastName = nullToUndefined(
		obj.supervisorLastName
	)
	val supervisorFirstName = nullToUndefined(
		obj.supervisorFirstName
	)
	val supervisorCdHcParty = nullToUndefined(
		obj.supervisorCdHcParty
	)
	val supervisorCbe = nullToUndefined(
		obj.supervisorCbe
	)
	val error = nullToUndefined(
		obj.error
	)
	val encounterLocationName = nullToUndefined(
		obj.encounterLocationName
	)
	val encounterLocationNihii = nullToUndefined(
		obj.encounterLocationNihii
	)
	val encounterLocationNorm = nullToUndefined(
		intToNumber(obj.encounterLocationNorm)
	)
	val longDelayJustification = nullToUndefined(
		intToNumber(obj.longDelayJustification)
	)
	val correctiveInvoiceId = nullToUndefined(
		obj.correctiveInvoiceId
	)
	val correctedInvoiceId = nullToUndefined(
		obj.correctedInvoiceId
	)
	val creditNote = nullToUndefined(
		obj.creditNote
	)
	val creditNoteRelatedInvoiceId = nullToUndefined(
		obj.creditNoteRelatedInvoiceId
	)
	val idDocument = nullToUndefined(
		obj.idDocument?.let { nonNull1 ->
			identityDocumentReader_toJs(nonNull1)
		}
	)
	val admissionDate = nullToUndefined(
		longToNumber(obj.admissionDate)
	)
	val locationNihii = nullToUndefined(
		obj.locationNihii
	)
	val locationService = nullToUndefined(
		intToNumber(obj.locationService)
	)
	val cancelReason = nullToUndefined(
		obj.cancelReason
	)
	val cancelDate = nullToUndefined(
		longToNumber(obj.cancelDate)
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
	val secretForeignKeys = setToArray(
		obj.secretForeignKeys,
		{ x1: String ->
			x1
		},
	)
	val cryptedForeignKeys = mapToObject(
		obj.cryptedForeignKeys,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val delegations = mapToObject(
		obj.delegations,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val encryptionKeys = mapToObject(
		obj.encryptionKeys,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	val securityMetadata = nullToUndefined(
		obj.securityMetadata?.let { nonNull1 ->
			securityMetadata_toJs(nonNull1)
		}
	)
	return EncryptedInvoiceJs(js("{" +
		"id:id," +
		"rev:rev," +
		"identifier:identifier," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"medicalLocationId:medicalLocationId," +
		"tags:tags," +
		"codes:codes," +
		"endOfLife:endOfLife," +
		"deletionDate:deletionDate," +
		"invoiceDate:invoiceDate," +
		"sentDate:sentDate," +
		"printedDate:printedDate," +
		"invoicingCodes:invoicingCodes," +
		"receipts:receipts," +
		"recipientType:recipientType," +
		"recipientId:recipientId," +
		"invoiceReference:invoiceReference," +
		"decisionReference:decisionReference," +
		"thirdPartyReference:thirdPartyReference," +
		"thirdPartyPaymentJustification:thirdPartyPaymentJustification," +
		"thirdPartyPaymentReason:thirdPartyPaymentReason," +
		"reason:reason," +
		"invoiceType:invoiceType," +
		"sentMediumType:sentMediumType," +
		"interventionType:interventionType," +
		"groupId:groupId," +
		"paymentType:paymentType," +
		"paid:paid," +
		"payments:payments," +
		"gnotionNihii:gnotionNihii," +
		"gnotionSsin:gnotionSsin," +
		"gnotionLastName:gnotionLastName," +
		"gnotionFirstName:gnotionFirstName," +
		"gnotionCdHcParty:gnotionCdHcParty," +
		"invoicePeriod:invoicePeriod," +
		"careProviderType:careProviderType," +
		"internshipNihii:internshipNihii," +
		"internshipSsin:internshipSsin," +
		"internshipLastName:internshipLastName," +
		"internshipFirstName:internshipFirstName," +
		"internshipCdHcParty:internshipCdHcParty," +
		"internshipCbe:internshipCbe," +
		"supervisorNihii:supervisorNihii," +
		"supervisorSsin:supervisorSsin," +
		"supervisorLastName:supervisorLastName," +
		"supervisorFirstName:supervisorFirstName," +
		"supervisorCdHcParty:supervisorCdHcParty," +
		"supervisorCbe:supervisorCbe," +
		"error:error," +
		"encounterLocationName:encounterLocationName," +
		"encounterLocationNihii:encounterLocationNihii," +
		"encounterLocationNorm:encounterLocationNorm," +
		"longDelayJustification:longDelayJustification," +
		"correctiveInvoiceId:correctiveInvoiceId," +
		"correctedInvoiceId:correctedInvoiceId," +
		"creditNote:creditNote," +
		"creditNoteRelatedInvoiceId:creditNoteRelatedInvoiceId," +
		"idDocument:idDocument," +
		"admissionDate:admissionDate," +
		"locationNihii:locationNihii," +
		"locationService:locationService," +
		"cancelReason:cancelReason," +
		"cancelDate:cancelDate," +
		"options:options," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata" +
	"}"))
}

public fun invoice_fromJs(obj: EncryptedInvoiceJs): EncryptedInvoice {
	val id = obj.id
	val rev = undefinedToNull(obj.rev)
	val identifier = arrayToList(
		obj.identifier,
		"obj.identifier",
		{ x1: IdentifierJs ->
			identifier_fromJs(x1)
		},
	)
	val created = numberToLong(obj.created, "obj.created")
	val modified = numberToLong(obj.modified, "obj.modified")
	val author = undefinedToNull(obj.author)
	val responsible = undefinedToNull(obj.responsible)
	val medicalLocationId = undefinedToNull(obj.medicalLocationId)
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
	val endOfLife = numberToLong(obj.endOfLife, "obj.endOfLife")
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val invoiceDate = numberToLong(obj.invoiceDate, "obj.invoiceDate")
	val sentDate = numberToLong(obj.sentDate, "obj.sentDate")
	val printedDate = numberToLong(obj.printedDate, "obj.printedDate")
	val invoicingCodes = arrayToList(
		obj.invoicingCodes,
		"obj.invoicingCodes",
		{ x1: EncryptedInvoicingCodeJs ->
			invoicingCode_fromJs(x1)
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
	val recipientType = undefinedToNull(obj.recipientType)
	val recipientId = undefinedToNull(obj.recipientId)
	val invoiceReference = undefinedToNull(obj.invoiceReference)
	val decisionReference = undefinedToNull(obj.decisionReference)
	val thirdPartyReference = undefinedToNull(obj.thirdPartyReference)
	val thirdPartyPaymentJustification = undefinedToNull(obj.thirdPartyPaymentJustification)
	val thirdPartyPaymentReason = undefinedToNull(obj.thirdPartyPaymentReason)
	val reason = undefinedToNull(obj.reason)
	val invoiceType = obj.invoiceType?.let { nonNull1 ->
		InvoiceType.valueOf(nonNull1)
	}
	val sentMediumType = obj.sentMediumType?.let { nonNull1 ->
		MediumType.valueOf(nonNull1)
	}
	val interventionType = obj.interventionType?.let { nonNull1 ->
		InvoiceInterventionType.valueOf(nonNull1)
	}
	val groupId = undefinedToNull(obj.groupId)
	val paymentType = obj.paymentType?.let { nonNull1 ->
		PaymentType.valueOf(nonNull1)
	}
	val paid = undefinedToNull(obj.paid)
	val payments = arrayToList(
		obj.payments,
		"obj.payments",
		{ x1: PaymentJs ->
			payment_fromJs(x1)
		},
	)
	val gnotionNihii = undefinedToNull(obj.gnotionNihii)
	val gnotionSsin = undefinedToNull(obj.gnotionSsin)
	val gnotionLastName = undefinedToNull(obj.gnotionLastName)
	val gnotionFirstName = undefinedToNull(obj.gnotionFirstName)
	val gnotionCdHcParty = undefinedToNull(obj.gnotionCdHcParty)
	val invoicePeriod = numberToInt(obj.invoicePeriod, "obj.invoicePeriod")
	val careProviderType = undefinedToNull(obj.careProviderType)
	val internshipNihii = undefinedToNull(obj.internshipNihii)
	val internshipSsin = undefinedToNull(obj.internshipSsin)
	val internshipLastName = undefinedToNull(obj.internshipLastName)
	val internshipFirstName = undefinedToNull(obj.internshipFirstName)
	val internshipCdHcParty = undefinedToNull(obj.internshipCdHcParty)
	val internshipCbe = undefinedToNull(obj.internshipCbe)
	val supervisorNihii = undefinedToNull(obj.supervisorNihii)
	val supervisorSsin = undefinedToNull(obj.supervisorSsin)
	val supervisorLastName = undefinedToNull(obj.supervisorLastName)
	val supervisorFirstName = undefinedToNull(obj.supervisorFirstName)
	val supervisorCdHcParty = undefinedToNull(obj.supervisorCdHcParty)
	val supervisorCbe = undefinedToNull(obj.supervisorCbe)
	val error = undefinedToNull(obj.error)
	val encounterLocationName = undefinedToNull(obj.encounterLocationName)
	val encounterLocationNihii = undefinedToNull(obj.encounterLocationNihii)
	val encounterLocationNorm = numberToInt(obj.encounterLocationNorm, "obj.encounterLocationNorm")
	val longDelayJustification = numberToInt(obj.longDelayJustification, "obj.longDelayJustification")
	val correctiveInvoiceId = undefinedToNull(obj.correctiveInvoiceId)
	val correctedInvoiceId = undefinedToNull(obj.correctedInvoiceId)
	val creditNote = undefinedToNull(obj.creditNote)
	val creditNoteRelatedInvoiceId = undefinedToNull(obj.creditNoteRelatedInvoiceId)
	val idDocument = obj.idDocument?.let { nonNull1 ->
		identityDocumentReader_fromJs(nonNull1)
	}
	val admissionDate = numberToLong(obj.admissionDate, "obj.admissionDate")
	val locationNihii = undefinedToNull(obj.locationNihii)
	val locationService = numberToInt(obj.locationService, "obj.locationService")
	val cancelReason = undefinedToNull(obj.cancelReason)
	val cancelDate = numberToLong(obj.cancelDate, "obj.cancelDate")
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
	val secretForeignKeys = arrayToSet(
		obj.secretForeignKeys,
		"obj.secretForeignKeys",
		{ x1: String ->
			x1
		},
	)
	val cryptedForeignKeys = objectToMap(
		obj.cryptedForeignKeys,
		"obj.cryptedForeignKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val delegations = objectToMap(
		obj.delegations,
		"obj.delegations",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val encryptionKeys = objectToMap(
		obj.encryptionKeys,
		"obj.encryptionKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_fromJs(nonNull1)
	}
	return EncryptedInvoice(
		id = id,
		rev = rev,
		identifier = identifier,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		medicalLocationId = medicalLocationId,
		tags = tags,
		codes = codes,
		endOfLife = endOfLife,
		deletionDate = deletionDate,
		invoiceDate = invoiceDate,
		sentDate = sentDate,
		printedDate = printedDate,
		invoicingCodes = invoicingCodes,
		receipts = receipts,
		recipientType = recipientType,
		recipientId = recipientId,
		invoiceReference = invoiceReference,
		decisionReference = decisionReference,
		thirdPartyReference = thirdPartyReference,
		thirdPartyPaymentJustification = thirdPartyPaymentJustification,
		thirdPartyPaymentReason = thirdPartyPaymentReason,
		reason = reason,
		invoiceType = invoiceType,
		sentMediumType = sentMediumType,
		interventionType = interventionType,
		groupId = groupId,
		paymentType = paymentType,
		paid = paid,
		payments = payments,
		gnotionNihii = gnotionNihii,
		gnotionSsin = gnotionSsin,
		gnotionLastName = gnotionLastName,
		gnotionFirstName = gnotionFirstName,
		gnotionCdHcParty = gnotionCdHcParty,
		invoicePeriod = invoicePeriod,
		careProviderType = careProviderType,
		internshipNihii = internshipNihii,
		internshipSsin = internshipSsin,
		internshipLastName = internshipLastName,
		internshipFirstName = internshipFirstName,
		internshipCdHcParty = internshipCdHcParty,
		internshipCbe = internshipCbe,
		supervisorNihii = supervisorNihii,
		supervisorSsin = supervisorSsin,
		supervisorLastName = supervisorLastName,
		supervisorFirstName = supervisorFirstName,
		supervisorCdHcParty = supervisorCdHcParty,
		supervisorCbe = supervisorCbe,
		error = error,
		encounterLocationName = encounterLocationName,
		encounterLocationNihii = encounterLocationNihii,
		encounterLocationNorm = encounterLocationNorm,
		longDelayJustification = longDelayJustification,
		correctiveInvoiceId = correctiveInvoiceId,
		correctedInvoiceId = correctedInvoiceId,
		creditNote = creditNote,
		creditNoteRelatedInvoiceId = creditNoteRelatedInvoiceId,
		idDocument = idDocument,
		admissionDate = admissionDate,
		locationNihii = locationNihii,
		locationService = locationService,
		cancelReason = cancelReason,
		cancelDate = cancelDate,
		options = options,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun invoice_toJs(obj: Invoice): InvoiceJs = when (obj) {
	is EncryptedInvoice -> invoice_toJs(obj)
	is DecryptedInvoice -> invoice_toJs(obj)
}

public fun invoice_fromJs(obj: InvoiceJs): Invoice = if (obj.isEncrypted) {
	invoice_fromJs(obj as EncryptedInvoiceJs)
} else {
	invoice_fromJs(obj as DecryptedInvoiceJs)
}
