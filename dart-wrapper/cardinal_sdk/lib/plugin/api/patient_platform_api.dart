// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/model/entity_reference_in_group.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/crypto/entities/share_all_patient_data_options.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/stored_document_identifier.dart';
import 'package:cardinal_sdk/crypto/entities/entity_access_information.dart';
import 'package:cardinal_sdk/crypto/entities/patient_share_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';
import 'package:cardinal_sdk/model/group_scoped.dart';


class PatientPlatformApi {
	MethodChannel _methodChannel;
	PatientEncryptedPlatformApi encrypted;
	PatientTryAndRecoverPlatformApi tryAndRecover;
	PatientInGroupPlatformApi inGroup;
	PatientPlatformApi(
		this._methodChannel
		) : encrypted = PatientEncryptedPlatformApi(_methodChannel),
		tryAndRecover = PatientTryAndRecoverPlatformApi(_methodChannel),
		inGroup = PatientInGroupPlatformApi(_methodChannel);

	Future<List<DecryptedPatient>> decrypt(String sdkId, List<EncryptedPatient> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.decrypt',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => EncryptedPatient.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method decrypt");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedPatient.fromJSON(x1) ).toList();
	}

	Future<List<Patient>> tryDecrypt(String sdkId, List<EncryptedPatient> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryDecrypt',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => EncryptedPatient.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method tryDecrypt");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Patient.fromJSON(x1) ).toList();
	}

	Future<List<EncryptedPatient>> encryptOrValidate(String sdkId, List<Patient> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encryptOrValidate',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method encryptOrValidate");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedPatient.fromJSON(x1) ).toList();
	}

	Future<Map<String, Set<EntityReferenceInGroup>>> getSecretIdsOf(String sdkId, Patient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.getSecretIdsOf',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(Patient.encode(patient)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getSecretIdsOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as Map<String, dynamic>).map((k1, v1) => MapEntry((k1 as String), (v1 as List<dynamic>).map((x2) => EntityReferenceInGroup.fromJSON(x2) ).toSet()));
	}

	Future<Set<HexString>> getEncryptionKeysOf(String sdkId, Patient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.getEncryptionKeysOf',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(Patient.encode(patient)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getEncryptionKeysOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as HexString) ).toSet();
	}

	Future<DecryptedPatient> withEncryptionMetadata(String sdkId, DecryptedPatient? base, User? user, Map<String, AccessLevel> delegates, String? alternateRootDelegateId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.withEncryptionMetadata',
			{
				"sdkId": sdkId,
				"base": jsonEncode(base == null ? null : DecryptedPatient.encode(base!)),
				"user": jsonEncode(user == null ? null : User.encode(user!)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, AccessLevel.encode(v0)))),
				"alternateRootDelegateId": jsonEncode(alternateRootDelegateId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method withEncryptionMetadata");
		final parsedResJson = jsonDecode(res);
		return DecryptedPatient.fromJSON(parsedResJson);
	}

	Future<bool> hasWriteAccess(String sdkId, Patient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.hasWriteAccess',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(Patient.encode(patient)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method hasWriteAccess");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as bool);
	}

	Future<void> createDelegationDeAnonymizationMetadata(String sdkId, Patient entity, Set<String> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.createDelegationDeAnonymizationMetadata',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(Patient.encode(entity)),
				"delegates": jsonEncode(delegates.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
	}

	Future<ShareAllPatientDataOptionsResult> shareAllDataOfPatient(String sdkId, String patientId, Map<String, Set<ShareAllPatientDataOptionsTag>> delegatesWithShareType) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.shareAllDataOfPatient',
			{
				"sdkId": sdkId,
				"patientId": jsonEncode(patientId),
				"delegatesWithShareType": jsonEncode(delegatesWithShareType.map((k0, v0) => MapEntry(k0, v0.map((x1) => ShareAllPatientDataOptionsTag.encode(x1)).toList()))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareAllDataOfPatient");
		final parsedResJson = jsonDecode(res);
		return ShareAllPatientDataOptionsResult.fromJSON(parsedResJson);
	}

	Future<Set<String>> getConfidentialSecretIdsOf(String sdkId, Patient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.getConfidentialSecretIdsOf',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(Patient.encode(patient)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getConfidentialSecretIdsOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toSet();
	}

	Future<bool> forceInitializeExchangeDataToNewlyInvitedPatient(String sdkId, String patientId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.forceInitializeExchangeDataToNewlyInvitedPatient',
			{
				"sdkId": sdkId,
				"patientId": jsonEncode(patientId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method forceInitializeExchangeDataToNewlyInvitedPatient");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as bool);
	}

	Future<List<String>> matchPatientsBy(String sdkId, FilterOptions<Patient> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.matchPatientsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchPatientsBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchPatientsBySorted(String sdkId, SortableFilterOptions<Patient> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.matchPatientsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchPatientsBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<EncryptedPatient> ensureEncryptionMetadataForSelfIsInitialized(String sdkId, Map<String, AccessLevel> sharingWith, bool ignoreIfEncryptionMetadataExists, String? alternateRootDelegateId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.ensureEncryptionMetadataForSelfIsInitialized',
			{
				"sdkId": sdkId,
				"sharingWith": jsonEncode(sharingWith.map((k0, v0) => MapEntry(k0, AccessLevel.encode(v0)))),
				"ignoreIfEncryptionMetadataExists": jsonEncode(ignoreIfEncryptionMetadataExists),
				"alternateRootDelegateId": jsonEncode(alternateRootDelegateId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method ensureEncryptionMetadataForSelfIsInitialized");
		final parsedResJson = jsonDecode(res);
		return EncryptedPatient.fromJSON(parsedResJson);
	}

	Future<StoredDocumentIdentifier> deletePatientById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.deletePatientById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deletePatientById");
		final parsedResJson = jsonDecode(res);
		return StoredDocumentIdentifier.fromJSON(parsedResJson);
	}

	Future<List<StoredDocumentIdentifier>> deletePatientsByIds(String sdkId, List<StoredDocumentIdentifier> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.deletePatientsByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => StoredDocumentIdentifier.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deletePatientsByIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => StoredDocumentIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgePatientById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.purgePatientById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
	}

	Future<StoredDocumentIdentifier> deletePatient(String sdkId, Patient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.deletePatient',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(Patient.encode(patient)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deletePatient");
		final parsedResJson = jsonDecode(res);
		return StoredDocumentIdentifier.fromJSON(parsedResJson);
	}

	Future<List<StoredDocumentIdentifier>> deletePatients(String sdkId, List<Patient> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.deletePatients',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deletePatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => StoredDocumentIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgePatient(String sdkId, Patient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.purgePatient',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(Patient.encode(patient)),
			}
		).catchError(convertPlatformException);
	}

	Future<EntityAccessInformation> getDataOwnersWithAccessTo(String sdkId, Patient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.getDataOwnersWithAccessTo',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(Patient.encode(patient)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getDataOwnersWithAccessTo");
		final parsedResJson = jsonDecode(res);
		return EntityAccessInformation.fromJSON(parsedResJson);
	}

	Future<DecryptedPatient> shareWith(String sdkId, String delegateId, DecryptedPatient patient, PatientShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"patient": jsonEncode(DecryptedPatient.encode(patient)),
				"options": jsonEncode(options == null ? null : PatientShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return DecryptedPatient.fromJSON(parsedResJson);
	}

	Future<DecryptedPatient> shareWithMany(String sdkId, DecryptedPatient patient, Map<String, PatientShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.shareWithMany',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(DecryptedPatient.encode(patient)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, PatientShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return DecryptedPatient.fromJSON(parsedResJson);
	}

	Future<DecryptedPatient> initializeConfidentialSecretId(String sdkId, DecryptedPatient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.initializeConfidentialSecretId',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(DecryptedPatient.encode(patient)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method initializeConfidentialSecretId");
		final parsedResJson = jsonDecode(res);
		return DecryptedPatient.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<DecryptedPatient>> filterPatientsBy(String sdkId, FilterOptions<Patient> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.filterPatientsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterPatientsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedPatient.fromJSON(x0));
	}

	Future<PaginatedListIterator<DecryptedPatient>> filterPatientsBySorted(String sdkId, SortableFilterOptions<Patient> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.filterPatientsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterPatientsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedPatient.fromJSON(x0));
	}

	Future<DecryptedPatient> createPatient(String sdkId, DecryptedPatient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.createPatient',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(DecryptedPatient.encode(patient)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createPatient");
		final parsedResJson = jsonDecode(res);
		return DecryptedPatient.fromJSON(parsedResJson);
	}

	Future<List<StoredDocumentIdentifier>> createPatientsMinimal(String sdkId, List<DecryptedPatient> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.createPatientsMinimal',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => DecryptedPatient.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createPatientsMinimal");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => StoredDocumentIdentifier.fromJSON(x1) ).toList();
	}

	Future<List<DecryptedPatient>> createPatients(String sdkId, List<DecryptedPatient> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.createPatients',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => DecryptedPatient.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createPatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedPatient.fromJSON(x1) ).toList();
	}

	Future<Patient> undeletePatient(String sdkId, Patient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.undeletePatient',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(Patient.encode(patient)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeletePatient");
		final parsedResJson = jsonDecode(res);
		return Patient.fromJSON(parsedResJson);
	}

	Future<DecryptedPatient> modifyPatient(String sdkId, DecryptedPatient entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.modifyPatient',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedPatient.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyPatient");
		final parsedResJson = jsonDecode(res);
		return DecryptedPatient.fromJSON(parsedResJson);
	}

	Future<DecryptedPatient> undeletePatientById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.undeletePatientById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeletePatientById");
		final parsedResJson = jsonDecode(res);
		return DecryptedPatient.fromJSON(parsedResJson);
	}

	Future<List<DecryptedPatient>> undeletePatients(String sdkId, List<StoredDocumentIdentifier> ids) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.undeletePatients',
			{
				"sdkId": sdkId,
				"ids": jsonEncode(ids.map((x0) => StoredDocumentIdentifier.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeletePatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedPatient.fromJSON(x1) ).toList();
	}

	Future<DecryptedPatient?> getPatient(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.getPatient',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getPatient");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : DecryptedPatient.fromJSON(parsedResJson);
	}

	Future<DecryptedPatient> getPatientResolvingMerges(String sdkId, String patientId, int? maxMergeDepth) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.getPatientResolvingMerges',
			{
				"sdkId": sdkId,
				"patientId": jsonEncode(patientId),
				"maxMergeDepth": jsonEncode(maxMergeDepth),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getPatientResolvingMerges");
		final parsedResJson = jsonDecode(res);
		return DecryptedPatient.fromJSON(parsedResJson);
	}

	Future<List<DecryptedPatient>> getPatients(String sdkId, List<String> patientIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.getPatients',
			{
				"sdkId": sdkId,
				"patientIds": jsonEncode(patientIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getPatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedPatient.fromJSON(x1) ).toList();
	}

	Future<List<StoredDocumentIdentifier>> modifyPatientsMinimal(String sdkId, List<DecryptedPatient> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.modifyPatientsMinimal',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => DecryptedPatient.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyPatientsMinimal");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => StoredDocumentIdentifier.fromJSON(x1) ).toList();
	}

	Future<List<DecryptedPatient>> modifyPatients(String sdkId, List<DecryptedPatient> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.modifyPatients',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => DecryptedPatient.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyPatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedPatient.fromJSON(x1) ).toList();
	}

	Future<DecryptedPatient> mergePatients(String sdkId, Patient from, DecryptedPatient mergedInto) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.mergePatients',
			{
				"sdkId": sdkId,
				"from": jsonEncode(Patient.encode(from)),
				"mergedInto": jsonEncode(DecryptedPatient.encode(mergedInto)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method mergePatients");
		final parsedResJson = jsonDecode(res);
		return DecryptedPatient.fromJSON(parsedResJson);
	}

	Future<EntitySubscription<EncryptedPatient>> subscribeToEvents(String sdkId, Set<SubscriptionEventType> events, FilterOptions<Patient> filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.subscribeToEvents',
			{
				"sdkId": sdkId,
				"events": jsonEncode(events.map((x0) => SubscriptionEventType.encode(x0)).toList()),
				"filter": jsonEncode(FilterOptions.encode(filter)),
				"subscriptionConfig": jsonEncode(subscriptionConfig == null ? null : EntitySubscriptionConfiguration.encode(subscriptionConfig!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method subscribeToEvents");
		final parsedResJson = jsonDecode(res);
		return EntitySubscription(parsedResJson, (x0) => EncryptedPatient.fromJSON(x0));
	}
}

class PatientTryAndRecoverPlatformApi {
	MethodChannel _methodChannel;
	PatientTryAndRecoverPlatformApi(this._methodChannel);

	Future<Patient> shareWith(String sdkId, String delegateId, Patient patient, PatientShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"patient": jsonEncode(Patient.encode(patient)),
				"options": jsonEncode(options == null ? null : PatientShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return Patient.fromJSON(parsedResJson);
	}

	Future<Patient> shareWithMany(String sdkId, Patient patient, Map<String, PatientShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.shareWithMany',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(Patient.encode(patient)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, PatientShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return Patient.fromJSON(parsedResJson);
	}

	Future<Patient> initializeConfidentialSecretId(String sdkId, Patient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.initializeConfidentialSecretId',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(Patient.encode(patient)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method initializeConfidentialSecretId");
		final parsedResJson = jsonDecode(res);
		return Patient.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<Patient>> filterPatientsBy(String sdkId, FilterOptions<Patient> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.filterPatientsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterPatientsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => Patient.fromJSON(x0));
	}

	Future<PaginatedListIterator<Patient>> filterPatientsBySorted(String sdkId, SortableFilterOptions<Patient> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.filterPatientsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterPatientsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => Patient.fromJSON(x0));
	}

	Future<Patient> createPatient(String sdkId, Patient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.createPatient',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(Patient.encode(patient)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createPatient");
		final parsedResJson = jsonDecode(res);
		return Patient.fromJSON(parsedResJson);
	}

	Future<List<StoredDocumentIdentifier>> createPatientsMinimal(String sdkId, List<Patient> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.createPatientsMinimal',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createPatientsMinimal");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => StoredDocumentIdentifier.fromJSON(x1) ).toList();
	}

	Future<List<Patient>> createPatients(String sdkId, List<Patient> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.createPatients',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createPatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Patient.fromJSON(x1) ).toList();
	}

	Future<Patient> undeletePatient(String sdkId, Patient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.undeletePatient',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(Patient.encode(patient)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeletePatient");
		final parsedResJson = jsonDecode(res);
		return Patient.fromJSON(parsedResJson);
	}

	Future<Patient> modifyPatient(String sdkId, Patient entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.modifyPatient',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(Patient.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyPatient");
		final parsedResJson = jsonDecode(res);
		return Patient.fromJSON(parsedResJson);
	}

	Future<Patient> undeletePatientById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.undeletePatientById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeletePatientById");
		final parsedResJson = jsonDecode(res);
		return Patient.fromJSON(parsedResJson);
	}

	Future<List<Patient>> undeletePatients(String sdkId, List<StoredDocumentIdentifier> ids) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.undeletePatients',
			{
				"sdkId": sdkId,
				"ids": jsonEncode(ids.map((x0) => StoredDocumentIdentifier.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeletePatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Patient.fromJSON(x1) ).toList();
	}

	Future<Patient?> getPatient(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.getPatient',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getPatient");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : Patient.fromJSON(parsedResJson);
	}

	Future<Patient> getPatientResolvingMerges(String sdkId, String patientId, int? maxMergeDepth) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.getPatientResolvingMerges',
			{
				"sdkId": sdkId,
				"patientId": jsonEncode(patientId),
				"maxMergeDepth": jsonEncode(maxMergeDepth),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getPatientResolvingMerges");
		final parsedResJson = jsonDecode(res);
		return Patient.fromJSON(parsedResJson);
	}

	Future<List<Patient>> getPatients(String sdkId, List<String> patientIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.getPatients',
			{
				"sdkId": sdkId,
				"patientIds": jsonEncode(patientIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getPatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Patient.fromJSON(x1) ).toList();
	}

	Future<List<StoredDocumentIdentifier>> modifyPatientsMinimal(String sdkId, List<Patient> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.modifyPatientsMinimal',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyPatientsMinimal");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => StoredDocumentIdentifier.fromJSON(x1) ).toList();
	}

	Future<List<Patient>> modifyPatients(String sdkId, List<Patient> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.modifyPatients',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyPatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Patient.fromJSON(x1) ).toList();
	}

	Future<Patient> mergePatients(String sdkId, Patient from, Patient mergedInto) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.mergePatients',
			{
				"sdkId": sdkId,
				"from": jsonEncode(Patient.encode(from)),
				"mergedInto": jsonEncode(Patient.encode(mergedInto)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method mergePatients");
		final parsedResJson = jsonDecode(res);
		return Patient.fromJSON(parsedResJson);
	}
}

class PatientEncryptedPlatformApi {
	MethodChannel _methodChannel;
	PatientEncryptedPlatformApi(this._methodChannel);

	Future<EncryptedPatient> shareWith(String sdkId, String delegateId, EncryptedPatient patient, PatientShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"patient": jsonEncode(EncryptedPatient.encode(patient)),
				"options": jsonEncode(options == null ? null : PatientShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return EncryptedPatient.fromJSON(parsedResJson);
	}

	Future<EncryptedPatient> shareWithMany(String sdkId, EncryptedPatient patient, Map<String, PatientShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.shareWithMany',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(EncryptedPatient.encode(patient)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, PatientShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return EncryptedPatient.fromJSON(parsedResJson);
	}

	Future<EncryptedPatient> initializeConfidentialSecretId(String sdkId, EncryptedPatient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.initializeConfidentialSecretId',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(EncryptedPatient.encode(patient)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method initializeConfidentialSecretId");
		final parsedResJson = jsonDecode(res);
		return EncryptedPatient.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<EncryptedPatient>> filterPatientsBy(String sdkId, FilterOptions<Patient> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.filterPatientsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterPatientsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedPatient.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedPatient>> filterPatientsBySorted(String sdkId, SortableFilterOptions<Patient> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.filterPatientsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterPatientsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedPatient.fromJSON(x0));
	}

	Future<EncryptedPatient> createPatient(String sdkId, EncryptedPatient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.createPatient',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(EncryptedPatient.encode(patient)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createPatient");
		final parsedResJson = jsonDecode(res);
		return EncryptedPatient.fromJSON(parsedResJson);
	}

	Future<List<StoredDocumentIdentifier>> createPatientsMinimal(String sdkId, List<EncryptedPatient> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.createPatientsMinimal',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => EncryptedPatient.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createPatientsMinimal");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => StoredDocumentIdentifier.fromJSON(x1) ).toList();
	}

	Future<List<EncryptedPatient>> createPatients(String sdkId, List<EncryptedPatient> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.createPatients',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => EncryptedPatient.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createPatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedPatient.fromJSON(x1) ).toList();
	}

	Future<Patient> undeletePatient(String sdkId, Patient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.undeletePatient',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(Patient.encode(patient)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeletePatient");
		final parsedResJson = jsonDecode(res);
		return Patient.fromJSON(parsedResJson);
	}

	Future<EncryptedPatient> modifyPatient(String sdkId, EncryptedPatient entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.modifyPatient',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedPatient.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyPatient");
		final parsedResJson = jsonDecode(res);
		return EncryptedPatient.fromJSON(parsedResJson);
	}

	Future<EncryptedPatient> undeletePatientById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.undeletePatientById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeletePatientById");
		final parsedResJson = jsonDecode(res);
		return EncryptedPatient.fromJSON(parsedResJson);
	}

	Future<List<EncryptedPatient>> undeletePatients(String sdkId, List<StoredDocumentIdentifier> ids) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.undeletePatients',
			{
				"sdkId": sdkId,
				"ids": jsonEncode(ids.map((x0) => StoredDocumentIdentifier.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeletePatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedPatient.fromJSON(x1) ).toList();
	}

	Future<EncryptedPatient?> getPatient(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.getPatient',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getPatient");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : EncryptedPatient.fromJSON(parsedResJson);
	}

	Future<EncryptedPatient> getPatientResolvingMerges(String sdkId, String patientId, int? maxMergeDepth) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.getPatientResolvingMerges',
			{
				"sdkId": sdkId,
				"patientId": jsonEncode(patientId),
				"maxMergeDepth": jsonEncode(maxMergeDepth),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getPatientResolvingMerges");
		final parsedResJson = jsonDecode(res);
		return EncryptedPatient.fromJSON(parsedResJson);
	}

	Future<List<EncryptedPatient>> getPatients(String sdkId, List<String> patientIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.getPatients',
			{
				"sdkId": sdkId,
				"patientIds": jsonEncode(patientIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getPatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedPatient.fromJSON(x1) ).toList();
	}

	Future<List<StoredDocumentIdentifier>> modifyPatientsMinimal(String sdkId, List<EncryptedPatient> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.modifyPatientsMinimal',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => EncryptedPatient.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyPatientsMinimal");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => StoredDocumentIdentifier.fromJSON(x1) ).toList();
	}

	Future<List<EncryptedPatient>> modifyPatients(String sdkId, List<EncryptedPatient> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.modifyPatients',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => EncryptedPatient.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyPatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedPatient.fromJSON(x1) ).toList();
	}

	Future<EncryptedPatient> mergePatients(String sdkId, Patient from, EncryptedPatient mergedInto) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.mergePatients',
			{
				"sdkId": sdkId,
				"from": jsonEncode(Patient.encode(from)),
				"mergedInto": jsonEncode(EncryptedPatient.encode(mergedInto)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method mergePatients");
		final parsedResJson = jsonDecode(res);
		return EncryptedPatient.fromJSON(parsedResJson);
	}
}

class PatientInGroupPlatformApi {
	MethodChannel _methodChannel;
	PatientInGroupEncryptedPlatformApi encrypted;
	PatientInGroupTryAndRecoverPlatformApi tryAndRecover;
	PatientInGroupPlatformApi(
		this._methodChannel
		) : encrypted = PatientInGroupEncryptedPlatformApi(_methodChannel),
		tryAndRecover = PatientInGroupTryAndRecoverPlatformApi(_methodChannel);

	Future<List<GroupScoped<DecryptedPatient>>> decrypt(String sdkId, List<GroupScoped<EncryptedPatient>> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.decrypt',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => GroupScoped.encode(
					x0,
					(x1) {
						return EncryptedPatient.encode(x1);
					},
				)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method decrypt");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return DecryptedPatient.fromJSON(x2);
			},
		) ).toList();
	}

	Future<List<GroupScoped<Patient>>> tryDecrypt(String sdkId, List<GroupScoped<EncryptedPatient>> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.tryDecrypt',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => GroupScoped.encode(
					x0,
					(x1) {
						return EncryptedPatient.encode(x1);
					},
				)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method tryDecrypt");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return Patient.fromJSON(x2);
			},
		) ).toList();
	}

	Future<List<GroupScoped<EncryptedPatient>>> encryptOrValidate(String sdkId, List<GroupScoped<Patient>> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.encryptOrValidate',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => GroupScoped.encode(
					x0,
					(x1) {
						return Patient.encode(x1);
					},
				)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method encryptOrValidate");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return EncryptedPatient.fromJSON(x2);
			},
		) ).toList();
	}

	Future<Map<String, Set<EntityReferenceInGroup>>> getSecretIdsOf(String sdkId, GroupScoped<Patient> patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.getSecretIdsOf',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(GroupScoped.encode(
					patient,
					(x0) {
						return Patient.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getSecretIdsOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as Map<String, dynamic>).map((k1, v1) => MapEntry((k1 as String), (v1 as List<dynamic>).map((x2) => EntityReferenceInGroup.fromJSON(x2) ).toSet()));
	}

	Future<Set<HexString>> getEncryptionKeysOf(String sdkId, GroupScoped<Patient> patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.getEncryptionKeysOf',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(GroupScoped.encode(
					patient,
					(x0) {
						return Patient.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getEncryptionKeysOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as HexString) ).toSet();
	}

	Future<GroupScoped<DecryptedPatient>> withEncryptionMetadata(String sdkId, String entityGroupId, DecryptedPatient? base, User? user, Map<EntityReferenceInGroup, AccessLevel> delegates, EntityReferenceInGroup? alternateRootDelegateReference) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.withEncryptionMetadata',
			{
				"sdkId": sdkId,
				"entityGroupId": jsonEncode(entityGroupId),
				"base": jsonEncode(base == null ? null : DecryptedPatient.encode(base!)),
				"user": jsonEncode(user == null ? null : User.encode(user!)),
				"delegates": jsonEncode(delegates.entries.map((x0) => {
					"k": EntityReferenceInGroup.encode(x0.key),
					"v": AccessLevel.encode(x0.value),
				}).toList()),
				"alternateRootDelegateReference": jsonEncode(alternateRootDelegateReference == null ? null : EntityReferenceInGroup.encode(alternateRootDelegateReference!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method withEncryptionMetadata");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return DecryptedPatient.fromJSON(x1);
			},
		);
	}

	Future<bool> hasWriteAccess(String sdkId, GroupScoped<DecryptedPatient> patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.hasWriteAccess',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(GroupScoped.encode(
					patient,
					(x0) {
						return DecryptedPatient.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method hasWriteAccess");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as bool);
	}

	Future<void> createDelegationDeAnonymizationMetadata(String sdkId, GroupScoped<DecryptedPatient> entity, Set<EntityReferenceInGroup> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.createDelegationDeAnonymizationMetadata',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(GroupScoped.encode(
					entity,
					(x0) {
						return DecryptedPatient.encode(x0);
					},
				)),
				"delegates": jsonEncode(delegates.map((x0) => EntityReferenceInGroup.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
	}

	Future<List<String>> matchPatientsBy(String sdkId, String groupId, FilterOptions<Patient> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.matchPatientsBy',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchPatientsBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchPatientsBySorted(String sdkId, String groupId, SortableFilterOptions<Patient> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.matchPatientsBySorted',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchPatientsBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<EntityAccessInformation> getDataOwnersWithAccessTo(String sdkId, GroupScoped<Patient> patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.getDataOwnersWithAccessTo',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(GroupScoped.encode(
					patient,
					(x0) {
						return Patient.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getDataOwnersWithAccessTo");
		final parsedResJson = jsonDecode(res);
		return EntityAccessInformation.fromJSON(parsedResJson);
	}

	Future<GroupScoped<DecryptedPatient>> shareWith(String sdkId, EntityReferenceInGroup delegate, GroupScoped<DecryptedPatient> patient, PatientShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.shareWith',
			{
				"sdkId": sdkId,
				"delegate": jsonEncode(EntityReferenceInGroup.encode(delegate)),
				"patient": jsonEncode(GroupScoped.encode(
					patient,
					(x0) {
						return DecryptedPatient.encode(x0);
					},
				)),
				"options": jsonEncode(options == null ? null : PatientShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return DecryptedPatient.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<DecryptedPatient>> shareWithMany(String sdkId, GroupScoped<DecryptedPatient> patient, Map<EntityReferenceInGroup, PatientShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.shareWithMany',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(GroupScoped.encode(
					patient,
					(x0) {
						return DecryptedPatient.encode(x0);
					},
				)),
				"delegates": jsonEncode(delegates.entries.map((x0) => {
					"k": EntityReferenceInGroup.encode(x0.key),
					"v": PatientShareOptions.encode(x0.value),
				}).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return DecryptedPatient.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<DecryptedPatient>> initializeConfidentialSecretId(String sdkId, GroupScoped<DecryptedPatient> patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.initializeConfidentialSecretId',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(GroupScoped.encode(
					patient,
					(x0) {
						return DecryptedPatient.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method initializeConfidentialSecretId");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return DecryptedPatient.fromJSON(x1);
			},
		);
	}

	Future<PaginatedListIterator<GroupScoped<DecryptedPatient>>> filterPatientsBy(String sdkId, String groupId, FilterOptions<Patient> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.filterPatientsBy',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterPatientsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => GroupScoped.fromJSON(
			x0,
			(x1) {
				return DecryptedPatient.fromJSON(x1);
			},
		));
	}

	Future<PaginatedListIterator<GroupScoped<DecryptedPatient>>> filterPatientsBySorted(String sdkId, String groupId, SortableFilterOptions<Patient> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.filterPatientsBySorted',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterPatientsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => GroupScoped.fromJSON(
			x0,
			(x1) {
				return DecryptedPatient.fromJSON(x1);
			},
		));
	}

	Future<GroupScoped<DecryptedPatient>> createPatient(String sdkId, GroupScoped<DecryptedPatient> patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.createPatient',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(GroupScoped.encode(
					patient,
					(x0) {
						return DecryptedPatient.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createPatient");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return DecryptedPatient.fromJSON(x1);
			},
		);
	}

	Future<List<GroupScoped<StoredDocumentIdentifier>>> createPatientsMinimal(String sdkId, List<GroupScoped<DecryptedPatient>> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.createPatientsMinimal',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => GroupScoped.encode(
					x0,
					(x1) {
						return DecryptedPatient.encode(x1);
					},
				)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createPatientsMinimal");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return StoredDocumentIdentifier.fromJSON(x2);
			},
		) ).toList();
	}

	Future<List<GroupScoped<DecryptedPatient>>> createPatients(String sdkId, List<GroupScoped<DecryptedPatient>> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.createPatients',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => GroupScoped.encode(
					x0,
					(x1) {
						return DecryptedPatient.encode(x1);
					},
				)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createPatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return DecryptedPatient.fromJSON(x2);
			},
		) ).toList();
	}

	Future<GroupScoped<DecryptedPatient>?> getPatient(String sdkId, String groupId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.getPatient',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getPatient");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return DecryptedPatient.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<DecryptedPatient>> getPatientResolvingMerges(String sdkId, String groupId, String patientId, int? maxMergeDepth) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.getPatientResolvingMerges',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"patientId": jsonEncode(patientId),
				"maxMergeDepth": jsonEncode(maxMergeDepth),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getPatientResolvingMerges");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return DecryptedPatient.fromJSON(x1);
			},
		);
	}

	Future<List<GroupScoped<DecryptedPatient>>> getPatients(String sdkId, String groupId, List<String> patientIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.getPatients',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"patientIds": jsonEncode(patientIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getPatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return DecryptedPatient.fromJSON(x2);
			},
		) ).toList();
	}

	Future<List<GroupScoped<StoredDocumentIdentifier>>> modifyPatientsMinimal(String sdkId, List<GroupScoped<DecryptedPatient>> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.modifyPatientsMinimal',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => GroupScoped.encode(
					x0,
					(x1) {
						return DecryptedPatient.encode(x1);
					},
				)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyPatientsMinimal");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return StoredDocumentIdentifier.fromJSON(x2);
			},
		) ).toList();
	}

	Future<List<GroupScoped<DecryptedPatient>>> modifyPatients(String sdkId, List<GroupScoped<DecryptedPatient>> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.modifyPatients',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => GroupScoped.encode(
					x0,
					(x1) {
						return DecryptedPatient.encode(x1);
					},
				)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyPatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return DecryptedPatient.fromJSON(x2);
			},
		) ).toList();
	}
}

class PatientInGroupEncryptedPlatformApi {
	MethodChannel _methodChannel;
	PatientInGroupEncryptedPlatformApi(this._methodChannel);

	Future<GroupScoped<EncryptedPatient>> shareWith(String sdkId, EntityReferenceInGroup delegate, GroupScoped<EncryptedPatient> patient, PatientShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.encrypted.shareWith',
			{
				"sdkId": sdkId,
				"delegate": jsonEncode(EntityReferenceInGroup.encode(delegate)),
				"patient": jsonEncode(GroupScoped.encode(
					patient,
					(x0) {
						return EncryptedPatient.encode(x0);
					},
				)),
				"options": jsonEncode(options == null ? null : PatientShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return EncryptedPatient.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<EncryptedPatient>> shareWithMany(String sdkId, GroupScoped<EncryptedPatient> patient, Map<EntityReferenceInGroup, PatientShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.encrypted.shareWithMany',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(GroupScoped.encode(
					patient,
					(x0) {
						return EncryptedPatient.encode(x0);
					},
				)),
				"delegates": jsonEncode(delegates.entries.map((x0) => {
					"k": EntityReferenceInGroup.encode(x0.key),
					"v": PatientShareOptions.encode(x0.value),
				}).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return EncryptedPatient.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<EncryptedPatient>> initializeConfidentialSecretId(String sdkId, GroupScoped<EncryptedPatient> patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.encrypted.initializeConfidentialSecretId',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(GroupScoped.encode(
					patient,
					(x0) {
						return EncryptedPatient.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method initializeConfidentialSecretId");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return EncryptedPatient.fromJSON(x1);
			},
		);
	}

	Future<PaginatedListIterator<GroupScoped<EncryptedPatient>>> filterPatientsBy(String sdkId, String groupId, FilterOptions<Patient> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.encrypted.filterPatientsBy',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterPatientsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => GroupScoped.fromJSON(
			x0,
			(x1) {
				return EncryptedPatient.fromJSON(x1);
			},
		));
	}

	Future<PaginatedListIterator<GroupScoped<EncryptedPatient>>> filterPatientsBySorted(String sdkId, String groupId, SortableFilterOptions<Patient> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.encrypted.filterPatientsBySorted',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterPatientsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => GroupScoped.fromJSON(
			x0,
			(x1) {
				return EncryptedPatient.fromJSON(x1);
			},
		));
	}

	Future<GroupScoped<EncryptedPatient>> createPatient(String sdkId, GroupScoped<EncryptedPatient> patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.encrypted.createPatient',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(GroupScoped.encode(
					patient,
					(x0) {
						return EncryptedPatient.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createPatient");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return EncryptedPatient.fromJSON(x1);
			},
		);
	}

	Future<List<GroupScoped<StoredDocumentIdentifier>>> createPatientsMinimal(String sdkId, List<GroupScoped<EncryptedPatient>> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.encrypted.createPatientsMinimal',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => GroupScoped.encode(
					x0,
					(x1) {
						return EncryptedPatient.encode(x1);
					},
				)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createPatientsMinimal");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return StoredDocumentIdentifier.fromJSON(x2);
			},
		) ).toList();
	}

	Future<List<GroupScoped<EncryptedPatient>>> createPatients(String sdkId, List<GroupScoped<EncryptedPatient>> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.encrypted.createPatients',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => GroupScoped.encode(
					x0,
					(x1) {
						return EncryptedPatient.encode(x1);
					},
				)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createPatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return EncryptedPatient.fromJSON(x2);
			},
		) ).toList();
	}

	Future<GroupScoped<EncryptedPatient>?> getPatient(String sdkId, String groupId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.encrypted.getPatient',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getPatient");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return EncryptedPatient.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<EncryptedPatient>> getPatientResolvingMerges(String sdkId, String groupId, String patientId, int? maxMergeDepth) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.encrypted.getPatientResolvingMerges',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"patientId": jsonEncode(patientId),
				"maxMergeDepth": jsonEncode(maxMergeDepth),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getPatientResolvingMerges");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return EncryptedPatient.fromJSON(x1);
			},
		);
	}

	Future<List<GroupScoped<EncryptedPatient>>> getPatients(String sdkId, String groupId, List<String> patientIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.encrypted.getPatients',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"patientIds": jsonEncode(patientIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getPatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return EncryptedPatient.fromJSON(x2);
			},
		) ).toList();
	}

	Future<List<GroupScoped<StoredDocumentIdentifier>>> modifyPatientsMinimal(String sdkId, List<GroupScoped<EncryptedPatient>> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.encrypted.modifyPatientsMinimal',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => GroupScoped.encode(
					x0,
					(x1) {
						return EncryptedPatient.encode(x1);
					},
				)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyPatientsMinimal");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return StoredDocumentIdentifier.fromJSON(x2);
			},
		) ).toList();
	}

	Future<List<GroupScoped<EncryptedPatient>>> modifyPatients(String sdkId, List<GroupScoped<EncryptedPatient>> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.encrypted.modifyPatients',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => GroupScoped.encode(
					x0,
					(x1) {
						return EncryptedPatient.encode(x1);
					},
				)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyPatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return EncryptedPatient.fromJSON(x2);
			},
		) ).toList();
	}
}

class PatientInGroupTryAndRecoverPlatformApi {
	MethodChannel _methodChannel;
	PatientInGroupTryAndRecoverPlatformApi(this._methodChannel);

	Future<GroupScoped<Patient>> shareWith(String sdkId, EntityReferenceInGroup delegate, GroupScoped<Patient> patient, PatientShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.tryAndRecover.shareWith',
			{
				"sdkId": sdkId,
				"delegate": jsonEncode(EntityReferenceInGroup.encode(delegate)),
				"patient": jsonEncode(GroupScoped.encode(
					patient,
					(x0) {
						return Patient.encode(x0);
					},
				)),
				"options": jsonEncode(options == null ? null : PatientShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return Patient.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<Patient>> shareWithMany(String sdkId, GroupScoped<Patient> patient, Map<EntityReferenceInGroup, PatientShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.tryAndRecover.shareWithMany',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(GroupScoped.encode(
					patient,
					(x0) {
						return Patient.encode(x0);
					},
				)),
				"delegates": jsonEncode(delegates.entries.map((x0) => {
					"k": EntityReferenceInGroup.encode(x0.key),
					"v": PatientShareOptions.encode(x0.value),
				}).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return Patient.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<Patient>> initializeConfidentialSecretId(String sdkId, GroupScoped<Patient> patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.tryAndRecover.initializeConfidentialSecretId',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(GroupScoped.encode(
					patient,
					(x0) {
						return Patient.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method initializeConfidentialSecretId");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return Patient.fromJSON(x1);
			},
		);
	}

	Future<PaginatedListIterator<GroupScoped<Patient>>> filterPatientsBy(String sdkId, String groupId, FilterOptions<Patient> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.tryAndRecover.filterPatientsBy',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterPatientsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => GroupScoped.fromJSON(
			x0,
			(x1) {
				return Patient.fromJSON(x1);
			},
		));
	}

	Future<PaginatedListIterator<GroupScoped<Patient>>> filterPatientsBySorted(String sdkId, String groupId, SortableFilterOptions<Patient> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.tryAndRecover.filterPatientsBySorted',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterPatientsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => GroupScoped.fromJSON(
			x0,
			(x1) {
				return Patient.fromJSON(x1);
			},
		));
	}

	Future<GroupScoped<Patient>> createPatient(String sdkId, GroupScoped<Patient> patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.tryAndRecover.createPatient',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(GroupScoped.encode(
					patient,
					(x0) {
						return Patient.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createPatient");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return Patient.fromJSON(x1);
			},
		);
	}

	Future<List<GroupScoped<StoredDocumentIdentifier>>> createPatientsMinimal(String sdkId, List<GroupScoped<Patient>> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.tryAndRecover.createPatientsMinimal',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => GroupScoped.encode(
					x0,
					(x1) {
						return Patient.encode(x1);
					},
				)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createPatientsMinimal");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return StoredDocumentIdentifier.fromJSON(x2);
			},
		) ).toList();
	}

	Future<List<GroupScoped<Patient>>> createPatients(String sdkId, List<GroupScoped<Patient>> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.tryAndRecover.createPatients',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => GroupScoped.encode(
					x0,
					(x1) {
						return Patient.encode(x1);
					},
				)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createPatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return Patient.fromJSON(x2);
			},
		) ).toList();
	}

	Future<GroupScoped<Patient>?> getPatient(String sdkId, String groupId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.tryAndRecover.getPatient',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getPatient");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return Patient.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<Patient>> getPatientResolvingMerges(String sdkId, String groupId, String patientId, int? maxMergeDepth) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.tryAndRecover.getPatientResolvingMerges',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"patientId": jsonEncode(patientId),
				"maxMergeDepth": jsonEncode(maxMergeDepth),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getPatientResolvingMerges");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return Patient.fromJSON(x1);
			},
		);
	}

	Future<List<GroupScoped<Patient>>> getPatients(String sdkId, String groupId, List<String> patientIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.tryAndRecover.getPatients',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"patientIds": jsonEncode(patientIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getPatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return Patient.fromJSON(x2);
			},
		) ).toList();
	}

	Future<List<GroupScoped<StoredDocumentIdentifier>>> modifyPatientsMinimal(String sdkId, List<GroupScoped<Patient>> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.tryAndRecover.modifyPatientsMinimal',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => GroupScoped.encode(
					x0,
					(x1) {
						return Patient.encode(x1);
					},
				)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyPatientsMinimal");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return StoredDocumentIdentifier.fromJSON(x2);
			},
		) ).toList();
	}

	Future<List<GroupScoped<Patient>>> modifyPatients(String sdkId, List<GroupScoped<Patient>> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.inGroup.tryAndRecover.modifyPatients',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => GroupScoped.encode(
					x0,
					(x1) {
						return Patient.encode(x1);
					},
				)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyPatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return Patient.fromJSON(x2);
			},
		) ).toList();
	}
}