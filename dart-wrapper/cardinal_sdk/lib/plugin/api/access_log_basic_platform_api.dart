// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/access_log.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/stored_document_identifier.dart';
import 'package:cardinal_sdk/model/group_scoped.dart';


class AccessLogBasicPlatformApi {
	MethodChannel _methodChannel;
	AccessLogBasicInGroupPlatformApi inGroup;
	AccessLogBasicPlatformApi(
		this._methodChannel
		) : inGroup = AccessLogBasicInGroupPlatformApi(_methodChannel);

	Future<List<String>> matchAccessLogsBy(String sdkId, BaseFilterOptions<AccessLog> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogBasicApi.matchAccessLogsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchAccessLogsBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchAccessLogsBySorted(String sdkId, BaseSortableFilterOptions<AccessLog> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogBasicApi.matchAccessLogsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchAccessLogsBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<PaginatedListIterator<EncryptedAccessLog>> filterAccessLogsBy(String sdkId, BaseFilterOptions<AccessLog> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogBasicApi.filterAccessLogsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterAccessLogsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedAccessLog.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedAccessLog>> filterAccessLogsBySorted(String sdkId, BaseSortableFilterOptions<AccessLog> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogBasicApi.filterAccessLogsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterAccessLogsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedAccessLog.fromJSON(x0));
	}

	Future<StoredDocumentIdentifier> deleteAccessLogById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogBasicApi.deleteAccessLogById',
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
			'AccessLogBasicApi.deleteAccessLogsByIds',
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
			'AccessLogBasicApi.purgeAccessLogById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
	}

	Future<StoredDocumentIdentifier> deleteAccessLog(String sdkId, AccessLog accessLog) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogBasicApi.deleteAccessLog',
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
			'AccessLogBasicApi.deleteAccessLogs',
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
			'AccessLogBasicApi.purgeAccessLog',
			{
				"sdkId": sdkId,
				"accessLog": jsonEncode(AccessLog.encode(accessLog)),
			}
		).catchError(convertPlatformException);
	}

	Future<EncryptedAccessLog> createAccessLog(String sdkId, EncryptedAccessLog entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogBasicApi.createAccessLog',
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
			'AccessLogBasicApi.undeleteAccessLogById',
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
			'AccessLogBasicApi.undeleteAccessLog',
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
			'AccessLogBasicApi.modifyAccessLog',
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
			'AccessLogBasicApi.getAccessLog',
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
			'AccessLogBasicApi.getAccessLogs',
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

class AccessLogBasicInGroupPlatformApi {
	MethodChannel _methodChannel;
	AccessLogBasicInGroupPlatformApi(this._methodChannel);

	Future<List<String>> matchAccessLogsBy(String sdkId, String groupId, BaseFilterOptions<AccessLog> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogBasicApi.inGroup.matchAccessLogsBy',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchAccessLogsBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchAccessLogsBySorted(String sdkId, String groupId, BaseSortableFilterOptions<AccessLog> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogBasicApi.inGroup.matchAccessLogsBySorted',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchAccessLogsBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<PaginatedListIterator<GroupScoped<EncryptedAccessLog>>> filterAccessLogsBy(String sdkId, String groupId, BaseFilterOptions<AccessLog> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogBasicApi.inGroup.filterAccessLogsBy',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
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

	Future<PaginatedListIterator<GroupScoped<EncryptedAccessLog>>> filterAccessLogsBySorted(String sdkId, String groupId, BaseSortableFilterOptions<AccessLog> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogBasicApi.inGroup.filterAccessLogsBySorted',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
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

	Future<GroupScoped<StoredDocumentIdentifier>> deleteAccessLogById(String sdkId, GroupScoped<StoredDocumentIdentifier> entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogBasicApi.inGroup.deleteAccessLogById',
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
			'AccessLogBasicApi.inGroup.deleteAccessLogsByIds',
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
			'AccessLogBasicApi.inGroup.deleteAccessLog',
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
			'AccessLogBasicApi.inGroup.deleteAccessLogs',
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

	Future<GroupScoped<EncryptedAccessLog>> createAccessLog(String sdkId, GroupScoped<EncryptedAccessLog> entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogBasicApi.inGroup.createAccessLog',
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
			'AccessLogBasicApi.inGroup.modifyAccessLog',
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
			'AccessLogBasicApi.inGroup.getAccessLog',
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
			'AccessLogBasicApi.inGroup.getAccessLogs',
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