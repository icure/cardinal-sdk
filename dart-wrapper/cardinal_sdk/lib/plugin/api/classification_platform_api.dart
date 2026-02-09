// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/classification.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_use_option.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/crypto/entities/classification_share_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';


class ClassificationPlatformApi {
	MethodChannel _methodChannel;
	ClassificationEncryptedPlatformApi encrypted;
	ClassificationTryAndRecoverPlatformApi tryAndRecover;
	ClassificationPlatformApi(
		this._methodChannel
		) : encrypted = ClassificationEncryptedPlatformApi(_methodChannel),
		tryAndRecover = ClassificationTryAndRecoverPlatformApi(_methodChannel);

	Future<DecryptedClassification> withEncryptionMetadata(String sdkId, DecryptedClassification? base, Patient patient, User? user, Map<String, AccessLevel> delegates, SecretIdUseOption secretId, String? alternateRootDelegateId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.withEncryptionMetadata',
			{
				"sdkId": sdkId,
				"base": jsonEncode(base == null ? null : DecryptedClassification.encode(base!)),
				"patient": jsonEncode(Patient.encode(patient)),
				"user": jsonEncode(user == null ? null : User.encode(user!)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, AccessLevel.encode(v0)))),
				"secretId": jsonEncode(SecretIdUseOption.encode(secretId)),
				"alternateRootDelegateId": jsonEncode(alternateRootDelegateId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method withEncryptionMetadata");
		final parsedResJson = jsonDecode(res);
		return DecryptedClassification.fromJSON(parsedResJson);
	}

	Future<Set<HexString>> getEncryptionKeysOf(String sdkId, Classification classification) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.getEncryptionKeysOf',
			{
				"sdkId": sdkId,
				"classification": jsonEncode(Classification.encode(classification)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getEncryptionKeysOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as HexString) ).toSet();
	}

	Future<bool> hasWriteAccess(String sdkId, Classification classification) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.hasWriteAccess',
			{
				"sdkId": sdkId,
				"classification": jsonEncode(Classification.encode(classification)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method hasWriteAccess");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as bool);
	}

	Future<Set<String>> decryptPatientIdOf(String sdkId, Classification classification) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.decryptPatientIdOf',
			{
				"sdkId": sdkId,
				"classification": jsonEncode(Classification.encode(classification)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method decryptPatientIdOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toSet();
	}

	Future<void> createDelegationDeAnonymizationMetadata(String sdkId, Classification entity, Set<String> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.createDelegationDeAnonymizationMetadata',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(Classification.encode(entity)),
				"delegates": jsonEncode(delegates.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
	}

	Future<DecryptedClassification> decrypt(String sdkId, EncryptedClassification classification) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.decrypt',
			{
				"sdkId": sdkId,
				"classification": jsonEncode(EncryptedClassification.encode(classification)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method decrypt");
		final parsedResJson = jsonDecode(res);
		return DecryptedClassification.fromJSON(parsedResJson);
	}

	Future<Classification> tryDecrypt(String sdkId, EncryptedClassification classification) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.tryDecrypt',
			{
				"sdkId": sdkId,
				"classification": jsonEncode(EncryptedClassification.encode(classification)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method tryDecrypt");
		final parsedResJson = jsonDecode(res);
		return Classification.fromJSON(parsedResJson);
	}

	Future<List<String>> matchClassificationsBy(String sdkId, FilterOptions<Classification> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.matchClassificationsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchClassificationsBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchClassificationsBySorted(String sdkId, SortableFilterOptions<Classification> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.matchClassificationsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchClassificationsBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<DocIdentifier> deleteClassification(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.deleteClassification',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteClassification");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteClassifications(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.deleteClassifications',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteClassifications");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<DecryptedClassification> shareWith(String sdkId, String delegateId, DecryptedClassification classification, ClassificationShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"classification": jsonEncode(DecryptedClassification.encode(classification)),
				"options": jsonEncode(options == null ? null : ClassificationShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return DecryptedClassification.fromJSON(parsedResJson);
	}

	Future<DecryptedClassification> shareWithMany(String sdkId, DecryptedClassification classification, Map<String, ClassificationShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.shareWithMany',
			{
				"sdkId": sdkId,
				"classification": jsonEncode(DecryptedClassification.encode(classification)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, ClassificationShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return DecryptedClassification.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<DecryptedClassification>> filterClassificationsBy(String sdkId, FilterOptions<Classification> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.filterClassificationsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterClassificationsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedClassification.fromJSON(x0));
	}

	Future<PaginatedListIterator<DecryptedClassification>> filterClassificationsBySorted(String sdkId, SortableFilterOptions<Classification> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.filterClassificationsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterClassificationsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedClassification.fromJSON(x0));
	}

	Future<DecryptedClassification> createClassification(String sdkId, DecryptedClassification entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.createClassification',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedClassification.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createClassification");
		final parsedResJson = jsonDecode(res);
		return DecryptedClassification.fromJSON(parsedResJson);
	}

	Future<DecryptedClassification> modifyClassification(String sdkId, DecryptedClassification entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.modifyClassification',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedClassification.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyClassification");
		final parsedResJson = jsonDecode(res);
		return DecryptedClassification.fromJSON(parsedResJson);
	}

	Future<DecryptedClassification?> getClassification(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.getClassification',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getClassification");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : DecryptedClassification.fromJSON(parsedResJson);
	}

	Future<List<DecryptedClassification>> getClassifications(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.getClassifications',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getClassifications");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedClassification.fromJSON(x1) ).toList();
	}
}

class ClassificationTryAndRecoverPlatformApi {
	MethodChannel _methodChannel;
	ClassificationTryAndRecoverPlatformApi(this._methodChannel);

	Future<Classification> shareWith(String sdkId, String delegateId, Classification classification, ClassificationShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.tryAndRecover.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"classification": jsonEncode(Classification.encode(classification)),
				"options": jsonEncode(options == null ? null : ClassificationShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return Classification.fromJSON(parsedResJson);
	}

	Future<Classification> shareWithMany(String sdkId, Classification classification, Map<String, ClassificationShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.tryAndRecover.shareWithMany',
			{
				"sdkId": sdkId,
				"classification": jsonEncode(Classification.encode(classification)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, ClassificationShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return Classification.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<Classification>> filterClassificationsBy(String sdkId, FilterOptions<Classification> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.tryAndRecover.filterClassificationsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterClassificationsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => Classification.fromJSON(x0));
	}

	Future<PaginatedListIterator<Classification>> filterClassificationsBySorted(String sdkId, SortableFilterOptions<Classification> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.tryAndRecover.filterClassificationsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterClassificationsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => Classification.fromJSON(x0));
	}

	Future<Classification> createClassification(String sdkId, Classification entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.tryAndRecover.createClassification',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(Classification.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createClassification");
		final parsedResJson = jsonDecode(res);
		return Classification.fromJSON(parsedResJson);
	}

	Future<Classification> modifyClassification(String sdkId, Classification entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.tryAndRecover.modifyClassification',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(Classification.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyClassification");
		final parsedResJson = jsonDecode(res);
		return Classification.fromJSON(parsedResJson);
	}

	Future<Classification?> getClassification(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.tryAndRecover.getClassification',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getClassification");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : Classification.fromJSON(parsedResJson);
	}

	Future<List<Classification>> getClassifications(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.tryAndRecover.getClassifications',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getClassifications");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Classification.fromJSON(x1) ).toList();
	}
}

class ClassificationEncryptedPlatformApi {
	MethodChannel _methodChannel;
	ClassificationEncryptedPlatformApi(this._methodChannel);

	Future<EncryptedClassification> shareWith(String sdkId, String delegateId, EncryptedClassification classification, ClassificationShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.encrypted.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"classification": jsonEncode(EncryptedClassification.encode(classification)),
				"options": jsonEncode(options == null ? null : ClassificationShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return EncryptedClassification.fromJSON(parsedResJson);
	}

	Future<EncryptedClassification> shareWithMany(String sdkId, EncryptedClassification classification, Map<String, ClassificationShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.encrypted.shareWithMany',
			{
				"sdkId": sdkId,
				"classification": jsonEncode(EncryptedClassification.encode(classification)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, ClassificationShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return EncryptedClassification.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<EncryptedClassification>> filterClassificationsBy(String sdkId, FilterOptions<Classification> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.encrypted.filterClassificationsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterClassificationsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedClassification.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedClassification>> filterClassificationsBySorted(String sdkId, SortableFilterOptions<Classification> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.encrypted.filterClassificationsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterClassificationsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedClassification.fromJSON(x0));
	}

	Future<EncryptedClassification> createClassification(String sdkId, EncryptedClassification entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.encrypted.createClassification',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedClassification.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createClassification");
		final parsedResJson = jsonDecode(res);
		return EncryptedClassification.fromJSON(parsedResJson);
	}

	Future<EncryptedClassification> modifyClassification(String sdkId, EncryptedClassification entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.encrypted.modifyClassification',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedClassification.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyClassification");
		final parsedResJson = jsonDecode(res);
		return EncryptedClassification.fromJSON(parsedResJson);
	}

	Future<EncryptedClassification?> getClassification(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.encrypted.getClassification',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getClassification");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : EncryptedClassification.fromJSON(parsedResJson);
	}

	Future<List<EncryptedClassification>> getClassifications(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationApi.encrypted.getClassifications',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getClassifications");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedClassification.fromJSON(x1) ).toList();
	}
}