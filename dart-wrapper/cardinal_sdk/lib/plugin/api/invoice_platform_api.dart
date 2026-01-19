// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/invoice.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_use_option.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/data/labelled_occurence.dart';
import 'package:cardinal_sdk/crypto/entities/invoice_share_options.dart';
import 'package:cardinal_sdk/model/embed/invoicing_code.dart';
import 'package:cardinal_sdk/model/embed/medium_type.dart';
import 'package:cardinal_sdk/model/embed/invoice_type.dart';


class InvoicePlatformApi {
	MethodChannel _methodChannel;
	InvoiceEncryptedPlatformApi encrypted;
	InvoiceTryAndRecoverPlatformApi tryAndRecover;
	InvoicePlatformApi(
		this._methodChannel
		) : encrypted = InvoiceEncryptedPlatformApi(_methodChannel),
		tryAndRecover = InvoiceTryAndRecoverPlatformApi(_methodChannel);

	Future<DecryptedInvoice> createInvoice(String sdkId, DecryptedInvoice entity, String? prefix) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.createInvoice',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedInvoice.encode(entity)),
				"prefix": jsonEncode(prefix),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createInvoice");
		final parsedResJson = jsonDecode(res);
		return DecryptedInvoice.fromJSON(parsedResJson);
	}

	Future<List<DecryptedInvoice>> createInvoices(String sdkId, List<DecryptedInvoice> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.createInvoices',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => DecryptedInvoice.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createInvoices");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedInvoice.fromJSON(x1) ).toList();
	}

	Future<DecryptedInvoice> withEncryptionMetadata(String sdkId, DecryptedInvoice? base, Patient? patient, User? user, Map<String, AccessLevel> delegates, SecretIdUseOption secretId, String? alternateRootDelegateId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.withEncryptionMetadata',
			{
				"sdkId": sdkId,
				"base": jsonEncode(base == null ? null : DecryptedInvoice.encode(base!)),
				"patient": jsonEncode(patient == null ? null : Patient.encode(patient!)),
				"user": jsonEncode(user == null ? null : User.encode(user!)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, AccessLevel.encode(v0)))),
				"secretId": jsonEncode(SecretIdUseOption.encode(secretId)),
				"alternateRootDelegateId": jsonEncode(alternateRootDelegateId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method withEncryptionMetadata");
		final parsedResJson = jsonDecode(res);
		return DecryptedInvoice.fromJSON(parsedResJson);
	}

	Future<Set<HexString>> getEncryptionKeysOf(String sdkId, Invoice invoice) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.getEncryptionKeysOf',
			{
				"sdkId": sdkId,
				"invoice": jsonEncode(Invoice.encode(invoice)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getEncryptionKeysOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as HexString) ).toSet();
	}

	Future<bool> hasWriteAccess(String sdkId, Invoice invoice) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.hasWriteAccess',
			{
				"sdkId": sdkId,
				"invoice": jsonEncode(Invoice.encode(invoice)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method hasWriteAccess");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as bool);
	}

	Future<Set<String>> decryptPatientIdOf(String sdkId, Invoice invoice) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.decryptPatientIdOf',
			{
				"sdkId": sdkId,
				"invoice": jsonEncode(Invoice.encode(invoice)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method decryptPatientIdOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toSet();
	}

	Future<void> createDelegationDeAnonymizationMetadata(String sdkId, Invoice entity, Set<String> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.createDelegationDeAnonymizationMetadata',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(Invoice.encode(entity)),
				"delegates": jsonEncode(delegates.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
	}

	Future<DecryptedInvoice> decrypt(String sdkId, EncryptedInvoice invoice) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.decrypt',
			{
				"sdkId": sdkId,
				"invoice": jsonEncode(EncryptedInvoice.encode(invoice)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method decrypt");
		final parsedResJson = jsonDecode(res);
		return DecryptedInvoice.fromJSON(parsedResJson);
	}

	Future<Invoice> tryDecrypt(String sdkId, EncryptedInvoice invoice) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.tryDecrypt',
			{
				"sdkId": sdkId,
				"invoice": jsonEncode(EncryptedInvoice.encode(invoice)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method tryDecrypt");
		final parsedResJson = jsonDecode(res);
		return Invoice.fromJSON(parsedResJson);
	}

	Future<DocIdentifier> deleteInvoice(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.deleteInvoice',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteInvoice");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<LabelledOccurence>> getTarificationsCodesOccurrences(String sdkId, int minOccurrence) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.getTarificationsCodesOccurrences',
			{
				"sdkId": sdkId,
				"minOccurrence": jsonEncode(minOccurrence),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getTarificationsCodesOccurrences");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => LabelledOccurence.fromJSON(x1) ).toList();
	}

	Future<DecryptedInvoice> shareWith(String sdkId, String delegateId, DecryptedInvoice invoice, InvoiceShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"invoice": jsonEncode(DecryptedInvoice.encode(invoice)),
				"options": jsonEncode(options == null ? null : InvoiceShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return DecryptedInvoice.fromJSON(parsedResJson);
	}

	Future<DecryptedInvoice> shareWithMany(String sdkId, DecryptedInvoice invoice, Map<String, InvoiceShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.shareWithMany',
			{
				"sdkId": sdkId,
				"invoice": jsonEncode(DecryptedInvoice.encode(invoice)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, InvoiceShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return DecryptedInvoice.fromJSON(parsedResJson);
	}

	Future<DecryptedInvoice> modifyInvoice(String sdkId, DecryptedInvoice entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.modifyInvoice',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedInvoice.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyInvoice");
		final parsedResJson = jsonDecode(res);
		return DecryptedInvoice.fromJSON(parsedResJson);
	}

	Future<List<DecryptedInvoice>> modifyInvoices(String sdkId, List<DecryptedInvoice> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.modifyInvoices',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => DecryptedInvoice.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyInvoices");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedInvoice.fromJSON(x1) ).toList();
	}

	Future<DecryptedInvoice?> getInvoice(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.getInvoice',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getInvoice");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : DecryptedInvoice.fromJSON(parsedResJson);
	}

	Future<List<DecryptedInvoice>> getInvoices(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.getInvoices',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getInvoices");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedInvoice.fromJSON(x1) ).toList();
	}

	Future<DecryptedInvoice> reassignInvoice(String sdkId, DecryptedInvoice invoice) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.reassignInvoice',
			{
				"sdkId": sdkId,
				"invoice": jsonEncode(DecryptedInvoice.encode(invoice)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method reassignInvoice");
		final parsedResJson = jsonDecode(res);
		return DecryptedInvoice.fromJSON(parsedResJson);
	}

	Future<DecryptedInvoice> mergeTo(String sdkId, String invoiceId, List<String> ids) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.mergeTo',
			{
				"sdkId": sdkId,
				"invoiceId": jsonEncode(invoiceId),
				"ids": jsonEncode(ids.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method mergeTo");
		final parsedResJson = jsonDecode(res);
		return DecryptedInvoice.fromJSON(parsedResJson);
	}

	Future<DecryptedInvoice> validate(String sdkId, String invoiceId, String scheme, String forcedValue) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.validate',
			{
				"sdkId": sdkId,
				"invoiceId": jsonEncode(invoiceId),
				"scheme": jsonEncode(scheme),
				"forcedValue": jsonEncode(forcedValue),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method validate");
		final parsedResJson = jsonDecode(res);
		return DecryptedInvoice.fromJSON(parsedResJson);
	}

	Future<List<DecryptedInvoice>> appendCodes(String sdkId, String userId, String type, String sentMediumType, String secretFKeys, String? insuranceId, String? invoiceId, int? gracePeriod, List<EncryptedInvoicingCode> invoicingCodes) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.appendCodes',
			{
				"sdkId": sdkId,
				"userId": jsonEncode(userId),
				"type": jsonEncode(type),
				"sentMediumType": jsonEncode(sentMediumType),
				"secretFKeys": jsonEncode(secretFKeys),
				"insuranceId": jsonEncode(insuranceId),
				"invoiceId": jsonEncode(invoiceId),
				"gracePeriod": jsonEncode(gracePeriod),
				"invoicingCodes": jsonEncode(invoicingCodes.map((x0) => EncryptedInvoicingCode.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method appendCodes");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedInvoice.fromJSON(x1) ).toList();
	}

	Future<List<DecryptedInvoice>> removeCodes(String sdkId, String userId, String serviceId, String secretFKeys, List<String> tarificationIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.removeCodes',
			{
				"sdkId": sdkId,
				"userId": jsonEncode(userId),
				"serviceId": jsonEncode(serviceId),
				"secretFKeys": jsonEncode(secretFKeys),
				"tarificationIds": jsonEncode(tarificationIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method removeCodes");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedInvoice.fromJSON(x1) ).toList();
	}

	Future<List<DecryptedInvoice>> listInvoicesByHcPartyAndGroupId(String sdkId, String hcPartyId, String groupId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.listInvoicesByHcPartyAndGroupId',
			{
				"sdkId": sdkId,
				"hcPartyId": jsonEncode(hcPartyId),
				"groupId": jsonEncode(groupId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listInvoicesByHcPartyAndGroupId");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedInvoice.fromJSON(x1) ).toList();
	}

	Future<List<DecryptedInvoice>> listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(String sdkId, String hcPartyId, MediumType sentMediumType, InvoiceType invoiceType, bool sent, int? from, int? to) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate',
			{
				"sdkId": sdkId,
				"hcPartyId": jsonEncode(hcPartyId),
				"sentMediumType": jsonEncode(MediumType.encode(sentMediumType)),
				"invoiceType": jsonEncode(InvoiceType.encode(invoiceType)),
				"sent": jsonEncode(sent),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedInvoice.fromJSON(x1) ).toList();
	}

	Future<List<DecryptedInvoice>> listInvoicesByContactIds(String sdkId, List<String> contactIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.listInvoicesByContactIds',
			{
				"sdkId": sdkId,
				"contactIds": jsonEncode(contactIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listInvoicesByContactIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedInvoice.fromJSON(x1) ).toList();
	}

	Future<List<DecryptedInvoice>> listInvoicesByRecipientsIds(String sdkId, List<String> recipientsIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.listInvoicesByRecipientsIds',
			{
				"sdkId": sdkId,
				"recipientsIds": jsonEncode(recipientsIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listInvoicesByRecipientsIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedInvoice.fromJSON(x1) ).toList();
	}

	Future<List<DecryptedInvoice>> listToInsurances(String sdkId, List<String> userIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.listToInsurances',
			{
				"sdkId": sdkId,
				"userIds": jsonEncode(userIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listToInsurances");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedInvoice.fromJSON(x1) ).toList();
	}

	Future<List<DecryptedInvoice>> listToInsurancesUnsent(String sdkId, List<String> userIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.listToInsurancesUnsent',
			{
				"sdkId": sdkId,
				"userIds": jsonEncode(userIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listToInsurancesUnsent");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedInvoice.fromJSON(x1) ).toList();
	}

	Future<List<DecryptedInvoice>> listToPatients(String sdkId, String hcPartyId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.listToPatients',
			{
				"sdkId": sdkId,
				"hcPartyId": jsonEncode(hcPartyId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listToPatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedInvoice.fromJSON(x1) ).toList();
	}

	Future<List<DecryptedInvoice>> listToPatientsUnsent(String sdkId, String? hcPartyId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.listToPatientsUnsent',
			{
				"sdkId": sdkId,
				"hcPartyId": jsonEncode(hcPartyId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listToPatientsUnsent");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedInvoice.fromJSON(x1) ).toList();
	}

	Future<List<DecryptedInvoice>> listInvoicesByIds(String sdkId, List<String> ids) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.listInvoicesByIds',
			{
				"sdkId": sdkId,
				"ids": jsonEncode(ids.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listInvoicesByIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedInvoice.fromJSON(x1) ).toList();
	}

	Future<List<DecryptedInvoice>> listInvoicesByHcpartySendingModeStatusDate(String sdkId, String hcPartyId, String sendingMode, String status, int from, int to) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.listInvoicesByHcpartySendingModeStatusDate',
			{
				"sdkId": sdkId,
				"hcPartyId": jsonEncode(hcPartyId),
				"sendingMode": jsonEncode(sendingMode),
				"status": jsonEncode(status),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listInvoicesByHcpartySendingModeStatusDate");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedInvoice.fromJSON(x1) ).toList();
	}
}

class InvoiceTryAndRecoverPlatformApi {
	MethodChannel _methodChannel;
	InvoiceTryAndRecoverPlatformApi(this._methodChannel);

	Future<Invoice> shareWith(String sdkId, String delegateId, Invoice invoice, InvoiceShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.tryAndRecover.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"invoice": jsonEncode(Invoice.encode(invoice)),
				"options": jsonEncode(options == null ? null : InvoiceShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return Invoice.fromJSON(parsedResJson);
	}

	Future<Invoice> shareWithMany(String sdkId, Invoice invoice, Map<String, InvoiceShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.tryAndRecover.shareWithMany',
			{
				"sdkId": sdkId,
				"invoice": jsonEncode(Invoice.encode(invoice)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, InvoiceShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return Invoice.fromJSON(parsedResJson);
	}

	Future<Invoice> modifyInvoice(String sdkId, Invoice entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.tryAndRecover.modifyInvoice',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(Invoice.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyInvoice");
		final parsedResJson = jsonDecode(res);
		return Invoice.fromJSON(parsedResJson);
	}

	Future<List<Invoice>> modifyInvoices(String sdkId, List<Invoice> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.tryAndRecover.modifyInvoices',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => Invoice.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyInvoices");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Invoice.fromJSON(x1) ).toList();
	}

	Future<Invoice?> getInvoice(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.tryAndRecover.getInvoice',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getInvoice");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : Invoice.fromJSON(parsedResJson);
	}

	Future<List<Invoice>> getInvoices(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.tryAndRecover.getInvoices',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getInvoices");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Invoice.fromJSON(x1) ).toList();
	}

	Future<Invoice> reassignInvoice(String sdkId, Invoice invoice) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.tryAndRecover.reassignInvoice',
			{
				"sdkId": sdkId,
				"invoice": jsonEncode(Invoice.encode(invoice)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method reassignInvoice");
		final parsedResJson = jsonDecode(res);
		return Invoice.fromJSON(parsedResJson);
	}

	Future<Invoice> mergeTo(String sdkId, String invoiceId, List<String> ids) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.tryAndRecover.mergeTo',
			{
				"sdkId": sdkId,
				"invoiceId": jsonEncode(invoiceId),
				"ids": jsonEncode(ids.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method mergeTo");
		final parsedResJson = jsonDecode(res);
		return Invoice.fromJSON(parsedResJson);
	}

	Future<Invoice> validate(String sdkId, String invoiceId, String scheme, String forcedValue) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.tryAndRecover.validate',
			{
				"sdkId": sdkId,
				"invoiceId": jsonEncode(invoiceId),
				"scheme": jsonEncode(scheme),
				"forcedValue": jsonEncode(forcedValue),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method validate");
		final parsedResJson = jsonDecode(res);
		return Invoice.fromJSON(parsedResJson);
	}

	Future<List<Invoice>> appendCodes(String sdkId, String userId, String type, String sentMediumType, String secretFKeys, String? insuranceId, String? invoiceId, int? gracePeriod, List<EncryptedInvoicingCode> invoicingCodes) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.tryAndRecover.appendCodes',
			{
				"sdkId": sdkId,
				"userId": jsonEncode(userId),
				"type": jsonEncode(type),
				"sentMediumType": jsonEncode(sentMediumType),
				"secretFKeys": jsonEncode(secretFKeys),
				"insuranceId": jsonEncode(insuranceId),
				"invoiceId": jsonEncode(invoiceId),
				"gracePeriod": jsonEncode(gracePeriod),
				"invoicingCodes": jsonEncode(invoicingCodes.map((x0) => EncryptedInvoicingCode.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method appendCodes");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Invoice.fromJSON(x1) ).toList();
	}

	Future<List<Invoice>> removeCodes(String sdkId, String userId, String serviceId, String secretFKeys, List<String> tarificationIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.tryAndRecover.removeCodes',
			{
				"sdkId": sdkId,
				"userId": jsonEncode(userId),
				"serviceId": jsonEncode(serviceId),
				"secretFKeys": jsonEncode(secretFKeys),
				"tarificationIds": jsonEncode(tarificationIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method removeCodes");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Invoice.fromJSON(x1) ).toList();
	}

	Future<List<Invoice>> listInvoicesByHcPartyAndGroupId(String sdkId, String hcPartyId, String groupId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.tryAndRecover.listInvoicesByHcPartyAndGroupId',
			{
				"sdkId": sdkId,
				"hcPartyId": jsonEncode(hcPartyId),
				"groupId": jsonEncode(groupId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listInvoicesByHcPartyAndGroupId");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Invoice.fromJSON(x1) ).toList();
	}

	Future<List<Invoice>> listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(String sdkId, String hcPartyId, MediumType sentMediumType, InvoiceType invoiceType, bool sent, int? from, int? to) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.tryAndRecover.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate',
			{
				"sdkId": sdkId,
				"hcPartyId": jsonEncode(hcPartyId),
				"sentMediumType": jsonEncode(MediumType.encode(sentMediumType)),
				"invoiceType": jsonEncode(InvoiceType.encode(invoiceType)),
				"sent": jsonEncode(sent),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Invoice.fromJSON(x1) ).toList();
	}

	Future<List<Invoice>> listInvoicesByContactIds(String sdkId, List<String> contactIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.tryAndRecover.listInvoicesByContactIds',
			{
				"sdkId": sdkId,
				"contactIds": jsonEncode(contactIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listInvoicesByContactIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Invoice.fromJSON(x1) ).toList();
	}

	Future<List<Invoice>> listInvoicesByRecipientsIds(String sdkId, List<String> recipientsIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.tryAndRecover.listInvoicesByRecipientsIds',
			{
				"sdkId": sdkId,
				"recipientsIds": jsonEncode(recipientsIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listInvoicesByRecipientsIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Invoice.fromJSON(x1) ).toList();
	}

	Future<List<Invoice>> listToInsurances(String sdkId, List<String> userIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.tryAndRecover.listToInsurances',
			{
				"sdkId": sdkId,
				"userIds": jsonEncode(userIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listToInsurances");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Invoice.fromJSON(x1) ).toList();
	}

	Future<List<Invoice>> listToInsurancesUnsent(String sdkId, List<String> userIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.tryAndRecover.listToInsurancesUnsent',
			{
				"sdkId": sdkId,
				"userIds": jsonEncode(userIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listToInsurancesUnsent");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Invoice.fromJSON(x1) ).toList();
	}

	Future<List<Invoice>> listToPatients(String sdkId, String hcPartyId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.tryAndRecover.listToPatients',
			{
				"sdkId": sdkId,
				"hcPartyId": jsonEncode(hcPartyId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listToPatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Invoice.fromJSON(x1) ).toList();
	}

	Future<List<Invoice>> listToPatientsUnsent(String sdkId, String? hcPartyId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.tryAndRecover.listToPatientsUnsent',
			{
				"sdkId": sdkId,
				"hcPartyId": jsonEncode(hcPartyId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listToPatientsUnsent");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Invoice.fromJSON(x1) ).toList();
	}

	Future<List<Invoice>> listInvoicesByIds(String sdkId, List<String> ids) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.tryAndRecover.listInvoicesByIds',
			{
				"sdkId": sdkId,
				"ids": jsonEncode(ids.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listInvoicesByIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Invoice.fromJSON(x1) ).toList();
	}

	Future<List<Invoice>> listInvoicesByHcpartySendingModeStatusDate(String sdkId, String hcPartyId, String sendingMode, String status, int from, int to) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.tryAndRecover.listInvoicesByHcpartySendingModeStatusDate',
			{
				"sdkId": sdkId,
				"hcPartyId": jsonEncode(hcPartyId),
				"sendingMode": jsonEncode(sendingMode),
				"status": jsonEncode(status),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listInvoicesByHcpartySendingModeStatusDate");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Invoice.fromJSON(x1) ).toList();
	}
}

class InvoiceEncryptedPlatformApi {
	MethodChannel _methodChannel;
	InvoiceEncryptedPlatformApi(this._methodChannel);

	Future<EncryptedInvoice> shareWith(String sdkId, String delegateId, EncryptedInvoice invoice, InvoiceShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.encrypted.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"invoice": jsonEncode(EncryptedInvoice.encode(invoice)),
				"options": jsonEncode(options == null ? null : InvoiceShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return EncryptedInvoice.fromJSON(parsedResJson);
	}

	Future<EncryptedInvoice> shareWithMany(String sdkId, EncryptedInvoice invoice, Map<String, InvoiceShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.encrypted.shareWithMany',
			{
				"sdkId": sdkId,
				"invoice": jsonEncode(EncryptedInvoice.encode(invoice)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, InvoiceShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return EncryptedInvoice.fromJSON(parsedResJson);
	}

	Future<EncryptedInvoice> modifyInvoice(String sdkId, EncryptedInvoice entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.encrypted.modifyInvoice',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedInvoice.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyInvoice");
		final parsedResJson = jsonDecode(res);
		return EncryptedInvoice.fromJSON(parsedResJson);
	}

	Future<List<EncryptedInvoice>> modifyInvoices(String sdkId, List<EncryptedInvoice> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.encrypted.modifyInvoices',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => EncryptedInvoice.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyInvoices");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedInvoice.fromJSON(x1) ).toList();
	}

	Future<EncryptedInvoice?> getInvoice(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.encrypted.getInvoice',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getInvoice");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : EncryptedInvoice.fromJSON(parsedResJson);
	}

	Future<List<EncryptedInvoice>> getInvoices(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.encrypted.getInvoices',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getInvoices");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedInvoice.fromJSON(x1) ).toList();
	}

	Future<EncryptedInvoice> reassignInvoice(String sdkId, EncryptedInvoice invoice) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.encrypted.reassignInvoice',
			{
				"sdkId": sdkId,
				"invoice": jsonEncode(EncryptedInvoice.encode(invoice)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method reassignInvoice");
		final parsedResJson = jsonDecode(res);
		return EncryptedInvoice.fromJSON(parsedResJson);
	}

	Future<EncryptedInvoice> mergeTo(String sdkId, String invoiceId, List<String> ids) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.encrypted.mergeTo',
			{
				"sdkId": sdkId,
				"invoiceId": jsonEncode(invoiceId),
				"ids": jsonEncode(ids.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method mergeTo");
		final parsedResJson = jsonDecode(res);
		return EncryptedInvoice.fromJSON(parsedResJson);
	}

	Future<EncryptedInvoice> validate(String sdkId, String invoiceId, String scheme, String forcedValue) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.encrypted.validate',
			{
				"sdkId": sdkId,
				"invoiceId": jsonEncode(invoiceId),
				"scheme": jsonEncode(scheme),
				"forcedValue": jsonEncode(forcedValue),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method validate");
		final parsedResJson = jsonDecode(res);
		return EncryptedInvoice.fromJSON(parsedResJson);
	}

	Future<List<EncryptedInvoice>> appendCodes(String sdkId, String userId, String type, String sentMediumType, String secretFKeys, String? insuranceId, String? invoiceId, int? gracePeriod, List<EncryptedInvoicingCode> invoicingCodes) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.encrypted.appendCodes',
			{
				"sdkId": sdkId,
				"userId": jsonEncode(userId),
				"type": jsonEncode(type),
				"sentMediumType": jsonEncode(sentMediumType),
				"secretFKeys": jsonEncode(secretFKeys),
				"insuranceId": jsonEncode(insuranceId),
				"invoiceId": jsonEncode(invoiceId),
				"gracePeriod": jsonEncode(gracePeriod),
				"invoicingCodes": jsonEncode(invoicingCodes.map((x0) => EncryptedInvoicingCode.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method appendCodes");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedInvoice.fromJSON(x1) ).toList();
	}

	Future<List<EncryptedInvoice>> removeCodes(String sdkId, String userId, String serviceId, String secretFKeys, List<String> tarificationIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.encrypted.removeCodes',
			{
				"sdkId": sdkId,
				"userId": jsonEncode(userId),
				"serviceId": jsonEncode(serviceId),
				"secretFKeys": jsonEncode(secretFKeys),
				"tarificationIds": jsonEncode(tarificationIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method removeCodes");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedInvoice.fromJSON(x1) ).toList();
	}

	Future<List<EncryptedInvoice>> listInvoicesByHcPartyAndGroupId(String sdkId, String hcPartyId, String groupId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.encrypted.listInvoicesByHcPartyAndGroupId',
			{
				"sdkId": sdkId,
				"hcPartyId": jsonEncode(hcPartyId),
				"groupId": jsonEncode(groupId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listInvoicesByHcPartyAndGroupId");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedInvoice.fromJSON(x1) ).toList();
	}

	Future<List<EncryptedInvoice>> listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(String sdkId, String hcPartyId, MediumType sentMediumType, InvoiceType invoiceType, bool sent, int? from, int? to) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.encrypted.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate',
			{
				"sdkId": sdkId,
				"hcPartyId": jsonEncode(hcPartyId),
				"sentMediumType": jsonEncode(MediumType.encode(sentMediumType)),
				"invoiceType": jsonEncode(InvoiceType.encode(invoiceType)),
				"sent": jsonEncode(sent),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedInvoice.fromJSON(x1) ).toList();
	}

	Future<List<EncryptedInvoice>> listInvoicesByContactIds(String sdkId, List<String> contactIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.encrypted.listInvoicesByContactIds',
			{
				"sdkId": sdkId,
				"contactIds": jsonEncode(contactIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listInvoicesByContactIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedInvoice.fromJSON(x1) ).toList();
	}

	Future<List<EncryptedInvoice>> listInvoicesByRecipientsIds(String sdkId, List<String> recipientsIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.encrypted.listInvoicesByRecipientsIds',
			{
				"sdkId": sdkId,
				"recipientsIds": jsonEncode(recipientsIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listInvoicesByRecipientsIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedInvoice.fromJSON(x1) ).toList();
	}

	Future<List<EncryptedInvoice>> listToInsurances(String sdkId, List<String> userIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.encrypted.listToInsurances',
			{
				"sdkId": sdkId,
				"userIds": jsonEncode(userIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listToInsurances");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedInvoice.fromJSON(x1) ).toList();
	}

	Future<List<EncryptedInvoice>> listToInsurancesUnsent(String sdkId, List<String> userIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.encrypted.listToInsurancesUnsent',
			{
				"sdkId": sdkId,
				"userIds": jsonEncode(userIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listToInsurancesUnsent");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedInvoice.fromJSON(x1) ).toList();
	}

	Future<List<EncryptedInvoice>> listToPatients(String sdkId, String hcPartyId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.encrypted.listToPatients',
			{
				"sdkId": sdkId,
				"hcPartyId": jsonEncode(hcPartyId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listToPatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedInvoice.fromJSON(x1) ).toList();
	}

	Future<List<EncryptedInvoice>> listToPatientsUnsent(String sdkId, String? hcPartyId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.encrypted.listToPatientsUnsent',
			{
				"sdkId": sdkId,
				"hcPartyId": jsonEncode(hcPartyId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listToPatientsUnsent");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedInvoice.fromJSON(x1) ).toList();
	}

	Future<List<EncryptedInvoice>> listInvoicesByIds(String sdkId, List<String> ids) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.encrypted.listInvoicesByIds',
			{
				"sdkId": sdkId,
				"ids": jsonEncode(ids.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listInvoicesByIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedInvoice.fromJSON(x1) ).toList();
	}

	Future<List<EncryptedInvoice>> listInvoicesByHcpartySendingModeStatusDate(String sdkId, String hcPartyId, String sendingMode, String status, int from, int to) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceApi.encrypted.listInvoicesByHcpartySendingModeStatusDate',
			{
				"sdkId": sdkId,
				"hcPartyId": jsonEncode(hcPartyId),
				"sendingMode": jsonEncode(sendingMode),
				"status": jsonEncode(status),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listInvoicesByHcpartySendingModeStatusDate");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedInvoice.fromJSON(x1) ).toList();
	}
}