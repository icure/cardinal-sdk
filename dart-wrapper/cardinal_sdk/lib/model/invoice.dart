// auto-generated file
import 'package:cardinal_sdk/model/base/identifier.dart';
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/invoicing_code.dart';
import 'package:cardinal_sdk/model/embed/invoice_type.dart';
import 'package:cardinal_sdk/model/embed/medium_type.dart';
import 'package:cardinal_sdk/model/embed/invoice_intervention_type.dart';
import 'package:cardinal_sdk/model/embed/payment_type.dart';
import 'package:cardinal_sdk/model/embed/payment.dart';
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/embed/identity_document_reader.dart';
import 'package:cardinal_sdk/model/embed/delegation.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/security_metadata.dart';
import 'package:cardinal_sdk/model/invoice.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';
import 'package:cardinal_sdk/model/base/has_encryption_metadata.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "invoice.freezed.dart";


sealed class Invoice implements StoredDocument, ICureDocument<String>, HasEncryptionMetadata, Encryptable {
	@override abstract final String id;
	@override abstract final String? rev;
	abstract final List<Identifier> identifier;
	@override abstract final int? created;
	@override abstract final int? modified;
	@override abstract final String? author;
	@override abstract final String? responsible;
	@override abstract final String? medicalLocationId;
	@override abstract final Set<CodeStub> tags;
	@override abstract final Set<CodeStub> codes;
	@override abstract final int? endOfLife;
	@override abstract final int? deletionDate;
	abstract final int? invoiceDate;
	abstract final int? sentDate;
	abstract final int? printedDate;
	List<InvoicingCode> get invoicingCodes;
	abstract final Map<String, String> receipts;
	abstract final String? recipientType;
	abstract final String? recipientId;
	abstract final String? invoiceReference;
	abstract final String? decisionReference;
	abstract final String? thirdPartyReference;
	abstract final String? thirdPartyPaymentJustification;
	abstract final String? thirdPartyPaymentReason;
	abstract final String? reason;
	abstract final InvoiceType? invoiceType;
	abstract final MediumType? sentMediumType;
	abstract final InvoiceInterventionType? interventionType;
	abstract final String? groupId;
	abstract final PaymentType? paymentType;
	abstract final double? paid;
	abstract final List<Payment>? payments;
	abstract final String? gnotionNihii;
	abstract final String? gnotionSsin;
	abstract final String? gnotionLastName;
	abstract final String? gnotionFirstName;
	abstract final String? gnotionCdHcParty;
	@actualInt32 abstract final int? invoicePeriod;
	abstract final String? careProviderType;
	abstract final String? internshipNihii;
	abstract final String? internshipSsin;
	abstract final String? internshipLastName;
	abstract final String? internshipFirstName;
	abstract final String? internshipCdHcParty;
	abstract final String? internshipCbe;
	abstract final String? supervisorNihii;
	abstract final String? supervisorSsin;
	abstract final String? supervisorLastName;
	abstract final String? supervisorFirstName;
	abstract final String? supervisorCdHcParty;
	abstract final String? supervisorCbe;
	abstract final String? error;
	abstract final String? encounterLocationName;
	abstract final String? encounterLocationNihii;
	@actualInt32 abstract final int? encounterLocationNorm;
	@actualInt32 abstract final int? longDelayJustification;
	abstract final String? correctiveInvoiceId;
	abstract final String? correctedInvoiceId;
	abstract final bool? creditNote;
	abstract final String? creditNoteRelatedInvoiceId;
	abstract final IdentityDocumentReader? idDocument;
	abstract final int? admissionDate;
	abstract final String? locationNihii;
	@actualInt32 abstract final int? locationService;
	abstract final String? cancelReason;
	abstract final int? cancelDate;
	abstract final Map<String, String> options;
	@override abstract final Set<String> secretForeignKeys;
	@override abstract final Map<String, Set<Delegation>> cryptedForeignKeys;
	@override abstract final Map<String, Set<Delegation>> delegations;
	@override abstract final Map<String, Set<Delegation>> encryptionKeys;
	@override abstract final Base64String? encryptedSelf;
	@override abstract final SecurityMetadata? securityMetadata;

	static Map<String, dynamic> encode(Invoice value) {
		switch (value) {
			case DecryptedInvoice entity:
				Map<String, dynamic> entityJson = DecryptedInvoice.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedInvoice";
				return entityJson;
			case EncryptedInvoice entity:
				Map<String, dynamic> entityJson = EncryptedInvoice.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedInvoice";
				return entityJson;
		}
	}

	static Invoice fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.DecryptedInvoice":
				return DecryptedInvoice.fromJSON(data);
			case "com.icure.cardinal.sdk.model.EncryptedInvoice":
				return EncryptedInvoice.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

@freezed
abstract class DecryptedInvoice with _$DecryptedInvoice implements Invoice {
	const factory DecryptedInvoice({
		required String id,
		@Default(null) String? rev,
		@Default([]) List<Identifier> identifier,
		@Default(null) int? created,
		@Default(null) int? modified,
		@Default(null) String? author,
		@Default(null) String? responsible,
		@Default(null) String? medicalLocationId,
		@Default({}) Set<CodeStub> tags,
		@Default({}) Set<CodeStub> codes,
		@Default(null) int? endOfLife,
		@Default(null) int? deletionDate,
		@Default(null) int? invoiceDate,
		@Default(null) int? sentDate,
		@Default(null) int? printedDate,
		@Default([]) List<DecryptedInvoicingCode> invoicingCodes,
		@Default({}) Map<String, String> receipts,
		@Default(null) String? recipientType,
		@Default(null) String? recipientId,
		@Default(null) String? invoiceReference,
		@Default(null) String? decisionReference,
		@Default(null) String? thirdPartyReference,
		@Default(null) String? thirdPartyPaymentJustification,
		@Default(null) String? thirdPartyPaymentReason,
		@Default(null) String? reason,
		@Default(null) InvoiceType? invoiceType,
		@Default(null) MediumType? sentMediumType,
		@Default(null) InvoiceInterventionType? interventionType,
		@Default(null) String? groupId,
		@Default(null) PaymentType? paymentType,
		@Default(null) double? paid,
		@Default(null) List<Payment>? payments,
		@Default(null) String? gnotionNihii,
		@Default(null) String? gnotionSsin,
		@Default(null) String? gnotionLastName,
		@Default(null) String? gnotionFirstName,
		@Default(null) String? gnotionCdHcParty,
		@Default(null) int? invoicePeriod,
		@Default(null) String? careProviderType,
		@Default(null) String? internshipNihii,
		@Default(null) String? internshipSsin,
		@Default(null) String? internshipLastName,
		@Default(null) String? internshipFirstName,
		@Default(null) String? internshipCdHcParty,
		@Default(null) String? internshipCbe,
		@Default(null) String? supervisorNihii,
		@Default(null) String? supervisorSsin,
		@Default(null) String? supervisorLastName,
		@Default(null) String? supervisorFirstName,
		@Default(null) String? supervisorCdHcParty,
		@Default(null) String? supervisorCbe,
		@Default(null) String? error,
		@Default(null) String? encounterLocationName,
		@Default(null) String? encounterLocationNihii,
		@Default(null) int? encounterLocationNorm,
		@Default(null) int? longDelayJustification,
		@Default(null) String? correctiveInvoiceId,
		@Default(null) String? correctedInvoiceId,
		@Default(null) bool? creditNote,
		@Default(null) String? creditNoteRelatedInvoiceId,
		@Default(null) IdentityDocumentReader? idDocument,
		@Default(null) int? admissionDate,
		@Default(null) String? locationNihii,
		@Default(null) int? locationService,
		@Default(null) String? cancelReason,
		@Default(null) int? cancelDate,
		@Default({}) Map<String, String> options,
		@Default({}) Set<String> secretForeignKeys,
		@Default({}) Map<String, Set<Delegation>> cryptedForeignKeys,
		@Default({}) Map<String, Set<Delegation>> delegations,
		@Default({}) Map<String, Set<Delegation>> encryptionKeys,
		@Default(null) Base64String? encryptedSelf,
		@Default(null) SecurityMetadata? securityMetadata,
	}) = _DecryptedInvoice;


	static Map<String, dynamic> encode(DecryptedInvoice value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"identifier" : value.identifier.map((x0) => Identifier.encode(x0)).toList(),
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"invoiceDate" : value.invoiceDate,
			"sentDate" : value.sentDate,
			"printedDate" : value.printedDate,
			"invoicingCodes" : value.invoicingCodes.map((x0) => DecryptedInvoicingCode.encode(x0)).toList(),
			"receipts" : value.receipts.map((k0, v0) => MapEntry(k0, v0)),
			"recipientType" : value.recipientType,
			"recipientId" : value.recipientId,
			"invoiceReference" : value.invoiceReference,
			"decisionReference" : value.decisionReference,
			"thirdPartyReference" : value.thirdPartyReference,
			"thirdPartyPaymentJustification" : value.thirdPartyPaymentJustification,
			"thirdPartyPaymentReason" : value.thirdPartyPaymentReason,
			"reason" : value.reason,
			"invoiceType" : value.invoiceType == null ? null : InvoiceType.encode(value.invoiceType!),
			"sentMediumType" : value.sentMediumType == null ? null : MediumType.encode(value.sentMediumType!),
			"interventionType" : value.interventionType == null ? null : InvoiceInterventionType.encode(value.interventionType!),
			"groupId" : value.groupId,
			"paymentType" : value.paymentType == null ? null : PaymentType.encode(value.paymentType!),
			"paid" : value.paid,
			"payments" : value.payments?.map((x0) => Payment.encode(x0)).toList(),
			"gnotionNihii" : value.gnotionNihii,
			"gnotionSsin" : value.gnotionSsin,
			"gnotionLastName" : value.gnotionLastName,
			"gnotionFirstName" : value.gnotionFirstName,
			"gnotionCdHcParty" : value.gnotionCdHcParty,
			"invoicePeriod" : value.invoicePeriod,
			"careProviderType" : value.careProviderType,
			"internshipNihii" : value.internshipNihii,
			"internshipSsin" : value.internshipSsin,
			"internshipLastName" : value.internshipLastName,
			"internshipFirstName" : value.internshipFirstName,
			"internshipCdHcParty" : value.internshipCdHcParty,
			"internshipCbe" : value.internshipCbe,
			"supervisorNihii" : value.supervisorNihii,
			"supervisorSsin" : value.supervisorSsin,
			"supervisorLastName" : value.supervisorLastName,
			"supervisorFirstName" : value.supervisorFirstName,
			"supervisorCdHcParty" : value.supervisorCdHcParty,
			"supervisorCbe" : value.supervisorCbe,
			"error" : value.error,
			"encounterLocationName" : value.encounterLocationName,
			"encounterLocationNihii" : value.encounterLocationNihii,
			"encounterLocationNorm" : value.encounterLocationNorm,
			"longDelayJustification" : value.longDelayJustification,
			"correctiveInvoiceId" : value.correctiveInvoiceId,
			"correctedInvoiceId" : value.correctedInvoiceId,
			"creditNote" : value.creditNote,
			"creditNoteRelatedInvoiceId" : value.creditNoteRelatedInvoiceId,
			"idDocument" : value.idDocument == null ? null : IdentityDocumentReader.encode(value.idDocument!),
			"admissionDate" : value.admissionDate,
			"locationNihii" : value.locationNihii,
			"locationService" : value.locationService,
			"cancelReason" : value.cancelReason,
			"cancelDate" : value.cancelDate,
			"options" : value.options.map((k0, v0) => MapEntry(k0, v0)),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}

	static DecryptedInvoice fromJSON(Map<String, dynamic> data) {
		return DecryptedInvoice(
			id: (data["id"] as String),
			invoicePeriod: (data["invoicePeriod"] as int?),
			encounterLocationNorm: (data["encounterLocationNorm"] as int?),
			longDelayJustification: (data["longDelayJustification"] as int?),
			locationService: (data["locationService"] as int?),
			rev: (data["rev"] as String?),
			identifier: (data["identifier"] as List<dynamic>).map((x0) => Identifier.fromJSON(x0) ).toList(),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			medicalLocationId: (data["medicalLocationId"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			endOfLife: (data["endOfLife"] as int?),
			deletionDate: (data["deletionDate"] as int?),
			invoiceDate: (data["invoiceDate"] as int?),
			sentDate: (data["sentDate"] as int?),
			printedDate: (data["printedDate"] as int?),
			invoicingCodes: (data["invoicingCodes"] as List<dynamic>).map((x0) => DecryptedInvoicingCode.fromJSON(x0) ).toList(),
			receipts: (data["receipts"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			recipientType: (data["recipientType"] as String?),
			recipientId: (data["recipientId"] as String?),
			invoiceReference: (data["invoiceReference"] as String?),
			decisionReference: (data["decisionReference"] as String?),
			thirdPartyReference: (data["thirdPartyReference"] as String?),
			thirdPartyPaymentJustification: (data["thirdPartyPaymentJustification"] as String?),
			thirdPartyPaymentReason: (data["thirdPartyPaymentReason"] as String?),
			reason: (data["reason"] as String?),
			invoiceType: data["invoiceType"] == null ? null : InvoiceType.fromJSON(data["invoiceType"]),
			sentMediumType: data["sentMediumType"] == null ? null : MediumType.fromJSON(data["sentMediumType"]),
			interventionType: data["interventionType"] == null ? null : InvoiceInterventionType.fromJSON(data["interventionType"]),
			groupId: (data["groupId"] as String?),
			paymentType: data["paymentType"] == null ? null : PaymentType.fromJSON(data["paymentType"]),
			paid: (data["paid"] as num?)?.toDouble(),
			payments: (data["payments"] as List<dynamic>?)?.map((x0) => Payment.fromJSON(x0) ).toList(),
			gnotionNihii: (data["gnotionNihii"] as String?),
			gnotionSsin: (data["gnotionSsin"] as String?),
			gnotionLastName: (data["gnotionLastName"] as String?),
			gnotionFirstName: (data["gnotionFirstName"] as String?),
			gnotionCdHcParty: (data["gnotionCdHcParty"] as String?),
			careProviderType: (data["careProviderType"] as String?),
			internshipNihii: (data["internshipNihii"] as String?),
			internshipSsin: (data["internshipSsin"] as String?),
			internshipLastName: (data["internshipLastName"] as String?),
			internshipFirstName: (data["internshipFirstName"] as String?),
			internshipCdHcParty: (data["internshipCdHcParty"] as String?),
			internshipCbe: (data["internshipCbe"] as String?),
			supervisorNihii: (data["supervisorNihii"] as String?),
			supervisorSsin: (data["supervisorSsin"] as String?),
			supervisorLastName: (data["supervisorLastName"] as String?),
			supervisorFirstName: (data["supervisorFirstName"] as String?),
			supervisorCdHcParty: (data["supervisorCdHcParty"] as String?),
			supervisorCbe: (data["supervisorCbe"] as String?),
			error: (data["error"] as String?),
			encounterLocationName: (data["encounterLocationName"] as String?),
			encounterLocationNihii: (data["encounterLocationNihii"] as String?),
			correctiveInvoiceId: (data["correctiveInvoiceId"] as String?),
			correctedInvoiceId: (data["correctedInvoiceId"] as String?),
			creditNote: (data["creditNote"] as bool?),
			creditNoteRelatedInvoiceId: (data["creditNoteRelatedInvoiceId"] as String?),
			idDocument: data["idDocument"] == null ? null : IdentityDocumentReader.fromJSON(data["idDocument"]),
			admissionDate: (data["admissionDate"] as int?),
			locationNihii: (data["locationNihii"] as String?),
			cancelReason: (data["cancelReason"] as String?),
			cancelDate: (data["cancelDate"] as int?),
			options: (data["options"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}
}

@freezed
abstract class EncryptedInvoice with _$EncryptedInvoice implements Invoice {
	const factory EncryptedInvoice({
		required String id,
		@Default(null) String? rev,
		@Default([]) List<Identifier> identifier,
		@Default(null) int? created,
		@Default(null) int? modified,
		@Default(null) String? author,
		@Default(null) String? responsible,
		@Default(null) String? medicalLocationId,
		@Default({}) Set<CodeStub> tags,
		@Default({}) Set<CodeStub> codes,
		@Default(null) int? endOfLife,
		@Default(null) int? deletionDate,
		@Default(null) int? invoiceDate,
		@Default(null) int? sentDate,
		@Default(null) int? printedDate,
		@Default([]) List<EncryptedInvoicingCode> invoicingCodes,
		@Default({}) Map<String, String> receipts,
		@Default(null) String? recipientType,
		@Default(null) String? recipientId,
		@Default(null) String? invoiceReference,
		@Default(null) String? decisionReference,
		@Default(null) String? thirdPartyReference,
		@Default(null) String? thirdPartyPaymentJustification,
		@Default(null) String? thirdPartyPaymentReason,
		@Default(null) String? reason,
		@Default(null) InvoiceType? invoiceType,
		@Default(null) MediumType? sentMediumType,
		@Default(null) InvoiceInterventionType? interventionType,
		@Default(null) String? groupId,
		@Default(null) PaymentType? paymentType,
		@Default(null) double? paid,
		@Default(null) List<Payment>? payments,
		@Default(null) String? gnotionNihii,
		@Default(null) String? gnotionSsin,
		@Default(null) String? gnotionLastName,
		@Default(null) String? gnotionFirstName,
		@Default(null) String? gnotionCdHcParty,
		@Default(null) int? invoicePeriod,
		@Default(null) String? careProviderType,
		@Default(null) String? internshipNihii,
		@Default(null) String? internshipSsin,
		@Default(null) String? internshipLastName,
		@Default(null) String? internshipFirstName,
		@Default(null) String? internshipCdHcParty,
		@Default(null) String? internshipCbe,
		@Default(null) String? supervisorNihii,
		@Default(null) String? supervisorSsin,
		@Default(null) String? supervisorLastName,
		@Default(null) String? supervisorFirstName,
		@Default(null) String? supervisorCdHcParty,
		@Default(null) String? supervisorCbe,
		@Default(null) String? error,
		@Default(null) String? encounterLocationName,
		@Default(null) String? encounterLocationNihii,
		@Default(null) int? encounterLocationNorm,
		@Default(null) int? longDelayJustification,
		@Default(null) String? correctiveInvoiceId,
		@Default(null) String? correctedInvoiceId,
		@Default(null) bool? creditNote,
		@Default(null) String? creditNoteRelatedInvoiceId,
		@Default(null) IdentityDocumentReader? idDocument,
		@Default(null) int? admissionDate,
		@Default(null) String? locationNihii,
		@Default(null) int? locationService,
		@Default(null) String? cancelReason,
		@Default(null) int? cancelDate,
		@Default({}) Map<String, String> options,
		@Default({}) Set<String> secretForeignKeys,
		@Default({}) Map<String, Set<Delegation>> cryptedForeignKeys,
		@Default({}) Map<String, Set<Delegation>> delegations,
		@Default({}) Map<String, Set<Delegation>> encryptionKeys,
		@Default(null) Base64String? encryptedSelf,
		@Default(null) SecurityMetadata? securityMetadata,
	}) = _EncryptedInvoice;


	static Map<String, dynamic> encode(EncryptedInvoice value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"identifier" : value.identifier.map((x0) => Identifier.encode(x0)).toList(),
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"invoiceDate" : value.invoiceDate,
			"sentDate" : value.sentDate,
			"printedDate" : value.printedDate,
			"invoicingCodes" : value.invoicingCodes.map((x0) => EncryptedInvoicingCode.encode(x0)).toList(),
			"receipts" : value.receipts.map((k0, v0) => MapEntry(k0, v0)),
			"recipientType" : value.recipientType,
			"recipientId" : value.recipientId,
			"invoiceReference" : value.invoiceReference,
			"decisionReference" : value.decisionReference,
			"thirdPartyReference" : value.thirdPartyReference,
			"thirdPartyPaymentJustification" : value.thirdPartyPaymentJustification,
			"thirdPartyPaymentReason" : value.thirdPartyPaymentReason,
			"reason" : value.reason,
			"invoiceType" : value.invoiceType == null ? null : InvoiceType.encode(value.invoiceType!),
			"sentMediumType" : value.sentMediumType == null ? null : MediumType.encode(value.sentMediumType!),
			"interventionType" : value.interventionType == null ? null : InvoiceInterventionType.encode(value.interventionType!),
			"groupId" : value.groupId,
			"paymentType" : value.paymentType == null ? null : PaymentType.encode(value.paymentType!),
			"paid" : value.paid,
			"payments" : value.payments?.map((x0) => Payment.encode(x0)).toList(),
			"gnotionNihii" : value.gnotionNihii,
			"gnotionSsin" : value.gnotionSsin,
			"gnotionLastName" : value.gnotionLastName,
			"gnotionFirstName" : value.gnotionFirstName,
			"gnotionCdHcParty" : value.gnotionCdHcParty,
			"invoicePeriod" : value.invoicePeriod,
			"careProviderType" : value.careProviderType,
			"internshipNihii" : value.internshipNihii,
			"internshipSsin" : value.internshipSsin,
			"internshipLastName" : value.internshipLastName,
			"internshipFirstName" : value.internshipFirstName,
			"internshipCdHcParty" : value.internshipCdHcParty,
			"internshipCbe" : value.internshipCbe,
			"supervisorNihii" : value.supervisorNihii,
			"supervisorSsin" : value.supervisorSsin,
			"supervisorLastName" : value.supervisorLastName,
			"supervisorFirstName" : value.supervisorFirstName,
			"supervisorCdHcParty" : value.supervisorCdHcParty,
			"supervisorCbe" : value.supervisorCbe,
			"error" : value.error,
			"encounterLocationName" : value.encounterLocationName,
			"encounterLocationNihii" : value.encounterLocationNihii,
			"encounterLocationNorm" : value.encounterLocationNorm,
			"longDelayJustification" : value.longDelayJustification,
			"correctiveInvoiceId" : value.correctiveInvoiceId,
			"correctedInvoiceId" : value.correctedInvoiceId,
			"creditNote" : value.creditNote,
			"creditNoteRelatedInvoiceId" : value.creditNoteRelatedInvoiceId,
			"idDocument" : value.idDocument == null ? null : IdentityDocumentReader.encode(value.idDocument!),
			"admissionDate" : value.admissionDate,
			"locationNihii" : value.locationNihii,
			"locationService" : value.locationService,
			"cancelReason" : value.cancelReason,
			"cancelDate" : value.cancelDate,
			"options" : value.options.map((k0, v0) => MapEntry(k0, v0)),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}

	static EncryptedInvoice fromJSON(Map<String, dynamic> data) {
		return EncryptedInvoice(
			id: (data["id"] as String),
			invoicePeriod: (data["invoicePeriod"] as int?),
			encounterLocationNorm: (data["encounterLocationNorm"] as int?),
			longDelayJustification: (data["longDelayJustification"] as int?),
			locationService: (data["locationService"] as int?),
			rev: (data["rev"] as String?),
			identifier: (data["identifier"] as List<dynamic>).map((x0) => Identifier.fromJSON(x0) ).toList(),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			medicalLocationId: (data["medicalLocationId"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			endOfLife: (data["endOfLife"] as int?),
			deletionDate: (data["deletionDate"] as int?),
			invoiceDate: (data["invoiceDate"] as int?),
			sentDate: (data["sentDate"] as int?),
			printedDate: (data["printedDate"] as int?),
			invoicingCodes: (data["invoicingCodes"] as List<dynamic>).map((x0) => EncryptedInvoicingCode.fromJSON(x0) ).toList(),
			receipts: (data["receipts"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			recipientType: (data["recipientType"] as String?),
			recipientId: (data["recipientId"] as String?),
			invoiceReference: (data["invoiceReference"] as String?),
			decisionReference: (data["decisionReference"] as String?),
			thirdPartyReference: (data["thirdPartyReference"] as String?),
			thirdPartyPaymentJustification: (data["thirdPartyPaymentJustification"] as String?),
			thirdPartyPaymentReason: (data["thirdPartyPaymentReason"] as String?),
			reason: (data["reason"] as String?),
			invoiceType: data["invoiceType"] == null ? null : InvoiceType.fromJSON(data["invoiceType"]),
			sentMediumType: data["sentMediumType"] == null ? null : MediumType.fromJSON(data["sentMediumType"]),
			interventionType: data["interventionType"] == null ? null : InvoiceInterventionType.fromJSON(data["interventionType"]),
			groupId: (data["groupId"] as String?),
			paymentType: data["paymentType"] == null ? null : PaymentType.fromJSON(data["paymentType"]),
			paid: (data["paid"] as num?)?.toDouble(),
			payments: (data["payments"] as List<dynamic>?)?.map((x0) => Payment.fromJSON(x0) ).toList(),
			gnotionNihii: (data["gnotionNihii"] as String?),
			gnotionSsin: (data["gnotionSsin"] as String?),
			gnotionLastName: (data["gnotionLastName"] as String?),
			gnotionFirstName: (data["gnotionFirstName"] as String?),
			gnotionCdHcParty: (data["gnotionCdHcParty"] as String?),
			careProviderType: (data["careProviderType"] as String?),
			internshipNihii: (data["internshipNihii"] as String?),
			internshipSsin: (data["internshipSsin"] as String?),
			internshipLastName: (data["internshipLastName"] as String?),
			internshipFirstName: (data["internshipFirstName"] as String?),
			internshipCdHcParty: (data["internshipCdHcParty"] as String?),
			internshipCbe: (data["internshipCbe"] as String?),
			supervisorNihii: (data["supervisorNihii"] as String?),
			supervisorSsin: (data["supervisorSsin"] as String?),
			supervisorLastName: (data["supervisorLastName"] as String?),
			supervisorFirstName: (data["supervisorFirstName"] as String?),
			supervisorCdHcParty: (data["supervisorCdHcParty"] as String?),
			supervisorCbe: (data["supervisorCbe"] as String?),
			error: (data["error"] as String?),
			encounterLocationName: (data["encounterLocationName"] as String?),
			encounterLocationNihii: (data["encounterLocationNihii"] as String?),
			correctiveInvoiceId: (data["correctiveInvoiceId"] as String?),
			correctedInvoiceId: (data["correctedInvoiceId"] as String?),
			creditNote: (data["creditNote"] as bool?),
			creditNoteRelatedInvoiceId: (data["creditNoteRelatedInvoiceId"] as String?),
			idDocument: data["idDocument"] == null ? null : IdentityDocumentReader.fromJSON(data["idDocument"]),
			admissionDate: (data["admissionDate"] as int?),
			locationNihii: (data["locationNihii"] as String?),
			cancelReason: (data["cancelReason"] as String?),
			cancelDate: (data["cancelDate"] as int?),
			options: (data["options"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}
}