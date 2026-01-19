// auto-generated file
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/access_log.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/stored_document_identifier.dart';
import 'package:cardinal_sdk/model/group_scoped.dart';


class AccessLogBasicApi {
	final String _sdkId;
	final Object _dartSdk;
	final AccessLogBasicInGroupApi inGroup;
	AccessLogBasicApi(
		this._sdkId,
		this._dartSdk
		) : inGroup = AccessLogBasicInGroupApi(_sdkId, _dartSdk);

	Future<List<String>> matchAccessLogsBy(BaseFilterOptions<AccessLog> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.matchAccessLogsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchAccessLogsBySorted(BaseSortableFilterOptions<AccessLog> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.matchAccessLogsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedAccessLog>> filterAccessLogsBy(BaseFilterOptions<AccessLog> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.filterAccessLogsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedAccessLog>> filterAccessLogsBySorted(BaseSortableFilterOptions<AccessLog> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.filterAccessLogsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<StoredDocumentIdentifier> deleteAccessLogById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.deleteAccessLogById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<StoredDocumentIdentifier>> deleteAccessLogsByIds(List<StoredDocumentIdentifier> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.deleteAccessLogsByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeAccessLogById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.purgeAccessLogById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<StoredDocumentIdentifier> deleteAccessLog(AccessLog accessLog) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.deleteAccessLog(
			_sdkId,
			accessLog,
		);
	}

	Future<List<StoredDocumentIdentifier>> deleteAccessLogs(List<AccessLog> accessLogs) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.deleteAccessLogs(
			_sdkId,
			accessLogs,
		);
	}

	Future<void> purgeAccessLog(AccessLog accessLog) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.purgeAccessLog(
			_sdkId,
			accessLog,
		);
	}

	Future<EncryptedAccessLog> createAccessLog(EncryptedAccessLog entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.createAccessLog(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedAccessLog> undeleteAccessLogById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.undeleteAccessLogById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedAccessLog> undeleteAccessLog(AccessLog accessLog) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.undeleteAccessLog(
			_sdkId,
			accessLog,
		);
	}

	Future<EncryptedAccessLog> modifyAccessLog(EncryptedAccessLog entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.modifyAccessLog(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedAccessLog?> getAccessLog(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.getAccessLog(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedAccessLog>> getAccessLogs(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.getAccessLogs(
			_sdkId,
			entityIds,
		);
	}
}

class AccessLogBasicInGroupApi {
	final String _sdkId;
	final Object _dartSdk;
	AccessLogBasicInGroupApi(
		this._sdkId,
		this._dartSdk
		);

	Future<List<String>> matchAccessLogsBy(String groupId, BaseFilterOptions<AccessLog> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.inGroup.matchAccessLogsBy(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<List<String>> matchAccessLogsBySorted(String groupId, BaseSortableFilterOptions<AccessLog> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.inGroup.matchAccessLogsBySorted(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<PaginatedListIterator<GroupScoped<EncryptedAccessLog>>> filterAccessLogsBy(String groupId, BaseFilterOptions<AccessLog> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.inGroup.filterAccessLogsBy(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<PaginatedListIterator<GroupScoped<EncryptedAccessLog>>> filterAccessLogsBySorted(String groupId, BaseSortableFilterOptions<AccessLog> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.inGroup.filterAccessLogsBySorted(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<GroupScoped<StoredDocumentIdentifier>> deleteAccessLogById(GroupScoped<StoredDocumentIdentifier> entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.inGroup.deleteAccessLogById(
			_sdkId,
			entityId,
		);
	}

	Future<List<GroupScoped<StoredDocumentIdentifier>>> deleteAccessLogsByIds(List<GroupScoped<StoredDocumentIdentifier>> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.inGroup.deleteAccessLogsByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<GroupScoped<StoredDocumentIdentifier>> deleteAccessLog(GroupScoped<AccessLog> accessLog) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.inGroup.deleteAccessLog(
			_sdkId,
			accessLog,
		);
	}

	Future<List<GroupScoped<StoredDocumentIdentifier>>> deleteAccessLogs(List<GroupScoped<AccessLog>> accessLogs) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.inGroup.deleteAccessLogs(
			_sdkId,
			accessLogs,
		);
	}

	Future<GroupScoped<EncryptedAccessLog>> createAccessLog(GroupScoped<EncryptedAccessLog> entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.inGroup.createAccessLog(
			_sdkId,
			entity,
		);
	}

	Future<GroupScoped<EncryptedAccessLog>> modifyAccessLog(GroupScoped<EncryptedAccessLog> entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.inGroup.modifyAccessLog(
			_sdkId,
			entity,
		);
	}

	Future<GroupScoped<EncryptedAccessLog>?> getAccessLog(String groupId, String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.inGroup.getAccessLog(
			_sdkId,
			groupId,
			entityId,
		);
	}

	Future<List<GroupScoped<EncryptedAccessLog>>> getAccessLogs(String groupId, List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.accessLogBasic.inGroup.getAccessLogs(
			_sdkId,
			groupId,
			entityIds,
		);
	}
}