// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/access_log.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_use_option.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/model/entity_reference_in_group.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/stored_document_identifier.dart';
import 'package:cardinal_sdk/crypto/entities/access_log_share_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/group_scoped.dart';


class AccessLogPlatformApi {
	MethodChannel _methodChannel;
	AccessLogEncryptedPlatformApi encrypted;
	AccessLogTryAndRecoverPlatformApi tryAndRecover;
	AccessLogInGroupPlatformApi inGroup;
	AccessLogPlatformApi(
		this._methodChannel
		) : encrypted = AccessLogEncryptedPlatformApi(_methodChannel),
		tryAndRecover = AccessLogTryAndRecoverPlatformApi(_methodChannel),
		inGroup = AccessLogInGroupPlatformApi(_methodChannel);

	Future<DecryptedAccessLog> withEncryptionMetadata(String sdkId, DecryptedAccessLog? base, Patient patient, User? user, Map<String, AccessLevel> delegates, SecretIdUseOption secretId, String? alternateRootDelegateId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.withEncryptionMetadata',
			{
				"sdkId": sdkId,
				"base": jsonEncode(base == null ? null : DecryptedAccessLog.encode(base!)),
				"patient": jsonEncode(Patient.encode(patient)),
				"user": jsonEncode(user == null ? null : User.encode(user!)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, AccessLevel.encode(v0)))),
				"secretId": jsonEncode(SecretIdUseOption.encode(secretId)),
				"alternateRootDelegateId": jsonEncode(alternateRootDelegateId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method withEncryptionMetadata");
		final parsedResJson = jsonDecode(res);
		return DecryptedAccessLog.fromJSON(parsedResJson);
	}

	Future<Set<HexString>> getEncryptionKeysOf(String sdkId, AccessLog accessLog) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.getEncryptionKeysOf',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(AccessLog.encode(accessLog)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getEncryptionKeysOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as HexString) ).toSet();
	}

	Future<bool> hasWriteAccess(String sdkId, AccessLog accessLog) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.hasWriteAccess',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(AccessLog.encode(accessLog)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method hasWriteAccess");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as bool);
	}

	Future<Set<EntityReferenceInGroup>> decryptPatientIdOf(String sdkId, AccessLog accessLog) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.decryptPatientIdOf',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(AccessLog.encode(accessLog)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method decryptPatientIdOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EntityReferenceInGroup.fromJSON(x1) ).toSet();
	}

	Future<void> createDelegationDeAnonymizationMetadata(String sdkId, AccessLog entity, Set<String> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.createDelegationDeAnonymizationMetadata',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(AccessLog.encode(entity)),
				"delegates": jsonEncode(delegates.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
	}

	Future<DecryptedAccessLog> decrypt(String sdkId, EncryptedAccessLog accessLog) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.decrypt',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(EncryptedAccessLog.encode(accessLog)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method decrypt");
		final parsedResJson = jsonDecode(res);
		return DecryptedAccessLog.fromJSON(parsedResJson);
	}

	Future<AccessLog> tryDecrypt(String sdkId, EncryptedAccessLog accessLog) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.tryDecrypt',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(EncryptedAccessLog.encode(accessLog)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method tryDecrypt");
		final parsedResJson = jsonDecode(res);
		return AccessLog.fromJSON(parsedResJson);
	}

	Future<List<String>> matchAccessLogsBy(String sdkId, FilterOptions<AccessLog> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.matchAccessLogsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchAccessLogsBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchAccessLogsBySorted(String sdkId, SortableFilterOptions<AccessLog> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.matchAccessLogsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchAccessLogsBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<StoredDocumentIdentifier> deleteAccessLogById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.deleteAccessLogById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteAccessLogById");
		final parsedResJson = jsonDecode(res);
		return StoredDocumentIdentifier.fromJSON(parsedResJson);
	}

	Future<List<StoredDocumentIdentifier>> deleteAccessLogsByIds(String sdkId, List<StoredDocumentIdentifier> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.deleteAccessLogsByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => StoredDocumentIdentifier.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteAccessLogsByIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => StoredDocumentIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeAccessLogById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.purgeAccessLogById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
	}

	Future<StoredDocumentIdentifier> deleteAccessLog(String sdkId, AccessLog accessLog) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.deleteAccessLog',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(AccessLog.encode(accessLog)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteAccessLog");
		final parsedResJson = jsonDecode(res);
		return StoredDocumentIdentifier.fromJSON(parsedResJson);
	}

	Future<List<StoredDocumentIdentifier>> deleteAccessLogs(String sdkId, List<AccessLog> accessLogs) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.deleteAccessLogs',
			{
				"sdkId": sdkId,
				"accessLogs": jsonEncode(accessLogs.map((x0) => AccessLog.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteAccessLogs");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => StoredDocumentIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeAccessLog(String sdkId, AccessLog accessLog) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.purgeAccessLog',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(AccessLog.encode(accessLog)),
			}
		).catchError(convertPlatformException);
	}

	Future<DecryptedAccessLog> shareWith(String sdkId, String delegateId, DecryptedAccessLog accessLog, AccessLogShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"accessLog": jsonEncode(DecryptedAccessLog.encode(accessLog)),
				"options": jsonEncode(options == null ? null : AccessLogShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return DecryptedAccessLog.fromJSON(parsedResJson);
	}

	Future<DecryptedAccessLog> shareWithMany(String sdkId, DecryptedAccessLog accessLog, Map<String, AccessLogShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.shareWithMany',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(DecryptedAccessLog.encode(accessLog)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, AccessLogShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return DecryptedAccessLog.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<DecryptedAccessLog>> filterAccessLogsBy(String sdkId, FilterOptions<AccessLog> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.filterAccessLogsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterAccessLogsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedAccessLog.fromJSON(x0));
	}

	Future<PaginatedListIterator<DecryptedAccessLog>> filterAccessLogsBySorted(String sdkId, SortableFilterOptions<AccessLog> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.filterAccessLogsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterAccessLogsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedAccessLog.fromJSON(x0));
	}

	Future<DecryptedAccessLog> createAccessLog(String sdkId, DecryptedAccessLog entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.createAccessLog',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedAccessLog.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createAccessLog");
		final parsedResJson = jsonDecode(res);
		return DecryptedAccessLog.fromJSON(parsedResJson);
	}

	Future<DecryptedAccessLog> undeleteAccessLogById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.undeleteAccessLogById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteAccessLogById");
		final parsedResJson = jsonDecode(res);
		return DecryptedAccessLog.fromJSON(parsedResJson);
	}

	Future<DecryptedAccessLog> undeleteAccessLog(String sdkId, AccessLog accessLog) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.undeleteAccessLog',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(AccessLog.encode(accessLog)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteAccessLog");
		final parsedResJson = jsonDecode(res);
		return DecryptedAccessLog.fromJSON(parsedResJson);
	}

	Future<DecryptedAccessLog> modifyAccessLog(String sdkId, DecryptedAccessLog entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.modifyAccessLog',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedAccessLog.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyAccessLog");
		final parsedResJson = jsonDecode(res);
		return DecryptedAccessLog.fromJSON(parsedResJson);
	}

	Future<DecryptedAccessLog?> getAccessLog(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.getAccessLog',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getAccessLog");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : DecryptedAccessLog.fromJSON(parsedResJson);
	}

	Future<List<DecryptedAccessLog>> getAccessLogs(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.getAccessLogs',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getAccessLogs");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedAccessLog.fromJSON(x1) ).toList();
	}
}

class AccessLogTryAndRecoverPlatformApi {
	MethodChannel _methodChannel;
	AccessLogTryAndRecoverPlatformApi(this._methodChannel);

	Future<AccessLog> shareWith(String sdkId, String delegateId, AccessLog accessLog, AccessLogShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.tryAndRecover.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"accessLog": jsonEncode(AccessLog.encode(accessLog)),
				"options": jsonEncode(options == null ? null : AccessLogShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return AccessLog.fromJSON(parsedResJson);
	}

	Future<AccessLog> shareWithMany(String sdkId, AccessLog accessLog, Map<String, AccessLogShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.tryAndRecover.shareWithMany',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(AccessLog.encode(accessLog)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, AccessLogShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return AccessLog.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<AccessLog>> filterAccessLogsBy(String sdkId, FilterOptions<AccessLog> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.tryAndRecover.filterAccessLogsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterAccessLogsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => AccessLog.fromJSON(x0));
	}

	Future<PaginatedListIterator<AccessLog>> filterAccessLogsBySorted(String sdkId, SortableFilterOptions<AccessLog> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.tryAndRecover.filterAccessLogsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterAccessLogsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => AccessLog.fromJSON(x0));
	}

	Future<AccessLog> createAccessLog(String sdkId, AccessLog entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.tryAndRecover.createAccessLog',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(AccessLog.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createAccessLog");
		final parsedResJson = jsonDecode(res);
		return AccessLog.fromJSON(parsedResJson);
	}

	Future<AccessLog> undeleteAccessLogById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.tryAndRecover.undeleteAccessLogById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteAccessLogById");
		final parsedResJson = jsonDecode(res);
		return AccessLog.fromJSON(parsedResJson);
	}

	Future<AccessLog> undeleteAccessLog(String sdkId, AccessLog accessLog) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.tryAndRecover.undeleteAccessLog',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(AccessLog.encode(accessLog)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteAccessLog");
		final parsedResJson = jsonDecode(res);
		return AccessLog.fromJSON(parsedResJson);
	}

	Future<AccessLog> modifyAccessLog(String sdkId, AccessLog entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.tryAndRecover.modifyAccessLog',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(AccessLog.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyAccessLog");
		final parsedResJson = jsonDecode(res);
		return AccessLog.fromJSON(parsedResJson);
	}

	Future<AccessLog?> getAccessLog(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.tryAndRecover.getAccessLog',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getAccessLog");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : AccessLog.fromJSON(parsedResJson);
	}

	Future<List<AccessLog>> getAccessLogs(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.tryAndRecover.getAccessLogs',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getAccessLogs");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => AccessLog.fromJSON(x1) ).toList();
	}
}

class AccessLogEncryptedPlatformApi {
	MethodChannel _methodChannel;
	AccessLogEncryptedPlatformApi(this._methodChannel);

	Future<EncryptedAccessLog> shareWith(String sdkId, String delegateId, EncryptedAccessLog accessLog, AccessLogShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.encrypted.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"accessLog": jsonEncode(EncryptedAccessLog.encode(accessLog)),
				"options": jsonEncode(options == null ? null : AccessLogShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return EncryptedAccessLog.fromJSON(parsedResJson);
	}

	Future<EncryptedAccessLog> shareWithMany(String sdkId, EncryptedAccessLog accessLog, Map<String, AccessLogShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.encrypted.shareWithMany',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(EncryptedAccessLog.encode(accessLog)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, AccessLogShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return EncryptedAccessLog.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<EncryptedAccessLog>> filterAccessLogsBy(String sdkId, FilterOptions<AccessLog> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.encrypted.filterAccessLogsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterAccessLogsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedAccessLog.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedAccessLog>> filterAccessLogsBySorted(String sdkId, SortableFilterOptions<AccessLog> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.encrypted.filterAccessLogsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterAccessLogsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedAccessLog.fromJSON(x0));
	}

	Future<EncryptedAccessLog> createAccessLog(String sdkId, EncryptedAccessLog entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.encrypted.createAccessLog',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedAccessLog.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createAccessLog");
		final parsedResJson = jsonDecode(res);
		return EncryptedAccessLog.fromJSON(parsedResJson);
	}

	Future<EncryptedAccessLog> undeleteAccessLogById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.encrypted.undeleteAccessLogById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteAccessLogById");
		final parsedResJson = jsonDecode(res);
		return EncryptedAccessLog.fromJSON(parsedResJson);
	}

	Future<EncryptedAccessLog> undeleteAccessLog(String sdkId, AccessLog accessLog) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.encrypted.undeleteAccessLog',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(AccessLog.encode(accessLog)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteAccessLog");
		final parsedResJson = jsonDecode(res);
		return EncryptedAccessLog.fromJSON(parsedResJson);
	}

	Future<EncryptedAccessLog> modifyAccessLog(String sdkId, EncryptedAccessLog entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.encrypted.modifyAccessLog',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedAccessLog.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyAccessLog");
		final parsedResJson = jsonDecode(res);
		return EncryptedAccessLog.fromJSON(parsedResJson);
	}

	Future<EncryptedAccessLog?> getAccessLog(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.encrypted.getAccessLog',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getAccessLog");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : EncryptedAccessLog.fromJSON(parsedResJson);
	}

	Future<List<EncryptedAccessLog>> getAccessLogs(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.encrypted.getAccessLogs',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getAccessLogs");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedAccessLog.fromJSON(x1) ).toList();
	}
}

class AccessLogInGroupPlatformApi {
	MethodChannel _methodChannel;
	AccessLogInGroupEncryptedPlatformApi encrypted;
	AccessLogInGroupTryAndRecoverPlatformApi tryAndRecover;
	AccessLogInGroupPlatformApi(
		this._methodChannel
		) : encrypted = AccessLogInGroupEncryptedPlatformApi(_methodChannel),
		tryAndRecover = AccessLogInGroupTryAndRecoverPlatformApi(_methodChannel);

	Future<GroupScoped<DecryptedAccessLog>> withEncryptionMetadata(String sdkId, String entityGroupId, DecryptedAccessLog? base, GroupScoped<Patient> patient, User? user, Map<EntityReferenceInGroup, AccessLevel> delegates, SecretIdUseOption secretId, EntityReferenceInGroup? alternateRootDelegateReference) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.withEncryptionMetadata',
			{
				"sdkId": sdkId,
				"entityGroupId": jsonEncode(entityGroupId),
				"base": jsonEncode(base == null ? null : DecryptedAccessLog.encode(base!)),
				"patient": jsonEncode(GroupScoped.encode(
					patient,
					(x0) {
						return Patient.encode(x0);
					},
				)),
				"user": jsonEncode(user == null ? null : User.encode(user!)),
				"delegates": jsonEncode(delegates.entries.map((x0) => {
					"k": EntityReferenceInGroup.encode(x0.key),
					"v": AccessLevel.encode(x0.value),
				}).toList()),
				"secretId": jsonEncode(SecretIdUseOption.encode(secretId)),
				"alternateRootDelegateReference": jsonEncode(alternateRootDelegateReference == null ? null : EntityReferenceInGroup.encode(alternateRootDelegateReference!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method withEncryptionMetadata");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return DecryptedAccessLog.fromJSON(x1);
			},
		);
	}

	Future<Set<HexString>> getEncryptionKeysOf(String sdkId, GroupScoped<AccessLog> accessLog) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.getEncryptionKeysOf',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(GroupScoped.encode(
					accessLog,
					(x0) {
						return AccessLog.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getEncryptionKeysOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as HexString) ).toSet();
	}

	Future<bool> hasWriteAccess(String sdkId, GroupScoped<AccessLog> accessLog) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.hasWriteAccess',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(GroupScoped.encode(
					accessLog,
					(x0) {
						return AccessLog.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method hasWriteAccess");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as bool);
	}

	Future<Set<EntityReferenceInGroup>> decryptPatientIdOf(String sdkId, GroupScoped<AccessLog> accessLog) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.decryptPatientIdOf',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(GroupScoped.encode(
					accessLog,
					(x0) {
						return AccessLog.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method decryptPatientIdOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EntityReferenceInGroup.fromJSON(x1) ).toSet();
	}

	Future<void> createDelegationDeAnonymizationMetadata(String sdkId, GroupScoped<AccessLog> entity, Set<EntityReferenceInGroup> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.createDelegationDeAnonymizationMetadata',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(GroupScoped.encode(
					entity,
					(x0) {
						return AccessLog.encode(x0);
					},
				)),
				"delegates": jsonEncode(delegates.map((x0) => EntityReferenceInGroup.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
	}

	Future<List<GroupScoped<DecryptedAccessLog>>> decrypt(String sdkId, List<GroupScoped<EncryptedAccessLog>> accessLogs) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.decrypt',
			{
				"sdkId": sdkId,
				"accessLogs": jsonEncode(accessLogs.map((x0) => GroupScoped.encode(
					x0,
					(x1) {
						return EncryptedAccessLog.encode(x1);
					},
				)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method decrypt");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return DecryptedAccessLog.fromJSON(x2);
			},
		) ).toList();
	}

	Future<List<GroupScoped<AccessLog>>> tryDecrypt(String sdkId, List<GroupScoped<EncryptedAccessLog>> accessLogs) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.tryDecrypt',
			{
				"sdkId": sdkId,
				"accessLogs": jsonEncode(accessLogs.map((x0) => GroupScoped.encode(
					x0,
					(x1) {
						return EncryptedAccessLog.encode(x1);
					},
				)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method tryDecrypt");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return AccessLog.fromJSON(x2);
			},
		) ).toList();
	}

	Future<List<String>> matchAccessLogsBy(String sdkId, String groupId, FilterOptions<AccessLog> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.matchAccessLogsBy',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchAccessLogsBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchAccessLogsBySorted(String sdkId, String groupId, SortableFilterOptions<AccessLog> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.matchAccessLogsBySorted',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchAccessLogsBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<GroupScoped<StoredDocumentIdentifier>> deleteAccessLogById(String sdkId, GroupScoped<StoredDocumentIdentifier> entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.deleteAccessLogById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(GroupScoped.encode(
					entityId,
					(x0) {
						return StoredDocumentIdentifier.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteAccessLogById");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return StoredDocumentIdentifier.fromJSON(x1);
			},
		);
	}

	Future<List<GroupScoped<StoredDocumentIdentifier>>> deleteAccessLogsByIds(String sdkId, List<GroupScoped<StoredDocumentIdentifier>> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.deleteAccessLogsByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => GroupScoped.encode(
					x0,
					(x1) {
						return StoredDocumentIdentifier.encode(x1);
					},
				)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteAccessLogsByIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return StoredDocumentIdentifier.fromJSON(x2);
			},
		) ).toList();
	}

	Future<GroupScoped<StoredDocumentIdentifier>> deleteAccessLog(String sdkId, GroupScoped<AccessLog> accessLog) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.deleteAccessLog',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(GroupScoped.encode(
					accessLog,
					(x0) {
						return AccessLog.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteAccessLog");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return StoredDocumentIdentifier.fromJSON(x1);
			},
		);
	}

	Future<List<GroupScoped<StoredDocumentIdentifier>>> deleteAccessLogs(String sdkId, List<GroupScoped<AccessLog>> accessLogs) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.deleteAccessLogs',
			{
				"sdkId": sdkId,
				"accessLogs": jsonEncode(accessLogs.map((x0) => GroupScoped.encode(
					x0,
					(x1) {
						return AccessLog.encode(x1);
					},
				)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteAccessLogs");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return StoredDocumentIdentifier.fromJSON(x2);
			},
		) ).toList();
	}

	Future<GroupScoped<DecryptedAccessLog>> createAccessLog(String sdkId, GroupScoped<DecryptedAccessLog> entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.createAccessLog',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(GroupScoped.encode(
					entity,
					(x0) {
						return DecryptedAccessLog.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createAccessLog");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return DecryptedAccessLog.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<DecryptedAccessLog>> modifyAccessLog(String sdkId, GroupScoped<DecryptedAccessLog> entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.modifyAccessLog',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(GroupScoped.encode(
					entity,
					(x0) {
						return DecryptedAccessLog.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyAccessLog");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return DecryptedAccessLog.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<DecryptedAccessLog>?> getAccessLog(String sdkId, String groupId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.getAccessLog',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getAccessLog");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return DecryptedAccessLog.fromJSON(x1);
			},
		);
	}

	Future<List<GroupScoped<DecryptedAccessLog>>> getAccessLogs(String sdkId, String groupId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.getAccessLogs',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getAccessLogs");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return DecryptedAccessLog.fromJSON(x2);
			},
		) ).toList();
	}
}

class AccessLogInGroupEncryptedPlatformApi {
	MethodChannel _methodChannel;
	AccessLogInGroupEncryptedPlatformApi(this._methodChannel);

	Future<GroupScoped<EncryptedAccessLog>> shareWith(String sdkId, EntityReferenceInGroup delegate, GroupScoped<EncryptedAccessLog> accessLog, AccessLogShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.encrypted.shareWith',
			{
				"sdkId": sdkId,
				"delegate": jsonEncode(EntityReferenceInGroup.encode(delegate)),
				"accessLog": jsonEncode(GroupScoped.encode(
					accessLog,
					(x0) {
						return EncryptedAccessLog.encode(x0);
					},
				)),
				"options": jsonEncode(options == null ? null : AccessLogShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return EncryptedAccessLog.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<EncryptedAccessLog>> shareWithMany(String sdkId, GroupScoped<EncryptedAccessLog> accessLog, Map<EntityReferenceInGroup, AccessLogShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.encrypted.shareWithMany',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(GroupScoped.encode(
					accessLog,
					(x0) {
						return EncryptedAccessLog.encode(x0);
					},
				)),
				"delegates": jsonEncode(delegates.entries.map((x0) => {
					"k": EntityReferenceInGroup.encode(x0.key),
					"v": AccessLogShareOptions.encode(x0.value),
				}).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return EncryptedAccessLog.fromJSON(x1);
			},
		);
	}

	Future<PaginatedListIterator<GroupScoped<EncryptedAccessLog>>> filterAccessLogsBy(String sdkId, String groupId, FilterOptions<AccessLog> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.encrypted.filterAccessLogsBy',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterAccessLogsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => GroupScoped.fromJSON(
			x0,
			(x1) {
				return EncryptedAccessLog.fromJSON(x1);
			},
		));
	}

	Future<PaginatedListIterator<GroupScoped<EncryptedAccessLog>>> filterAccessLogsBySorted(String sdkId, String groupId, SortableFilterOptions<AccessLog> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.encrypted.filterAccessLogsBySorted',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterAccessLogsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => GroupScoped.fromJSON(
			x0,
			(x1) {
				return EncryptedAccessLog.fromJSON(x1);
			},
		));
	}

	Future<GroupScoped<EncryptedAccessLog>> createAccessLog(String sdkId, GroupScoped<EncryptedAccessLog> entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.encrypted.createAccessLog',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(GroupScoped.encode(
					entity,
					(x0) {
						return EncryptedAccessLog.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createAccessLog");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return EncryptedAccessLog.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<EncryptedAccessLog>> modifyAccessLog(String sdkId, GroupScoped<EncryptedAccessLog> entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.encrypted.modifyAccessLog',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(GroupScoped.encode(
					entity,
					(x0) {
						return EncryptedAccessLog.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyAccessLog");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return EncryptedAccessLog.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<EncryptedAccessLog>?> getAccessLog(String sdkId, String groupId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.encrypted.getAccessLog',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getAccessLog");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return EncryptedAccessLog.fromJSON(x1);
			},
		);
	}

	Future<List<GroupScoped<EncryptedAccessLog>>> getAccessLogs(String sdkId, String groupId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.encrypted.getAccessLogs',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getAccessLogs");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return EncryptedAccessLog.fromJSON(x2);
			},
		) ).toList();
	}
}

class AccessLogInGroupTryAndRecoverPlatformApi {
	MethodChannel _methodChannel;
	AccessLogInGroupTryAndRecoverPlatformApi(this._methodChannel);

	Future<GroupScoped<AccessLog>> shareWith(String sdkId, EntityReferenceInGroup delegate, GroupScoped<AccessLog> accessLog, AccessLogShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.tryAndRecover.shareWith',
			{
				"sdkId": sdkId,
				"delegate": jsonEncode(EntityReferenceInGroup.encode(delegate)),
				"accessLog": jsonEncode(GroupScoped.encode(
					accessLog,
					(x0) {
						return AccessLog.encode(x0);
					},
				)),
				"options": jsonEncode(options == null ? null : AccessLogShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return AccessLog.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<AccessLog>> shareWithMany(String sdkId, GroupScoped<AccessLog> accessLog, Map<EntityReferenceInGroup, AccessLogShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.tryAndRecover.shareWithMany',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(GroupScoped.encode(
					accessLog,
					(x0) {
						return AccessLog.encode(x0);
					},
				)),
				"delegates": jsonEncode(delegates.entries.map((x0) => {
					"k": EntityReferenceInGroup.encode(x0.key),
					"v": AccessLogShareOptions.encode(x0.value),
				}).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return AccessLog.fromJSON(x1);
			},
		);
	}

	Future<PaginatedListIterator<GroupScoped<AccessLog>>> filterAccessLogsBy(String sdkId, String groupId, FilterOptions<AccessLog> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.tryAndRecover.filterAccessLogsBy',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterAccessLogsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => GroupScoped.fromJSON(
			x0,
			(x1) {
				return AccessLog.fromJSON(x1);
			},
		));
	}

	Future<PaginatedListIterator<GroupScoped<AccessLog>>> filterAccessLogsBySorted(String sdkId, String groupId, SortableFilterOptions<AccessLog> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.tryAndRecover.filterAccessLogsBySorted',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterAccessLogsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => GroupScoped.fromJSON(
			x0,
			(x1) {
				return AccessLog.fromJSON(x1);
			},
		));
	}

	Future<GroupScoped<AccessLog>> createAccessLog(String sdkId, GroupScoped<AccessLog> entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.tryAndRecover.createAccessLog',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(GroupScoped.encode(
					entity,
					(x0) {
						return AccessLog.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createAccessLog");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return AccessLog.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<AccessLog>> modifyAccessLog(String sdkId, GroupScoped<AccessLog> entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.tryAndRecover.modifyAccessLog',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(GroupScoped.encode(
					entity,
					(x0) {
						return AccessLog.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyAccessLog");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return AccessLog.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<AccessLog>?> getAccessLog(String sdkId, String groupId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.tryAndRecover.getAccessLog',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getAccessLog");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return AccessLog.fromJSON(x1);
			},
		);
	}

	Future<List<GroupScoped<AccessLog>>> getAccessLogs(String sdkId, String groupId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogApi.inGroup.tryAndRecover.getAccessLogs',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getAccessLogs");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return AccessLog.fromJSON(x2);
			},
		) ).toList();
	}
}