// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/group.dart';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/embed/group_type.dart';
import 'package:cardinal_sdk/model/database_initialisation.dart';
import 'package:cardinal_sdk/model/security/permission_type.dart';
import 'package:cardinal_sdk/model/registration_information.dart';
import 'package:cardinal_sdk/model/registration_success.dart';
import 'package:cardinal_sdk/model/security/operation.dart';
import 'package:cardinal_sdk/model/embed/user_type.dart';
import 'package:cardinal_sdk/model/embed/role_configuration.dart';
import 'package:cardinal_sdk/model/group_deletion_report.dart';
import 'package:cardinal_sdk/model/list_of_properties.dart';
import 'package:cardinal_sdk/model/couchdb/design_document.dart';
import 'package:cardinal_sdk/model/id_with_rev.dart';
import 'package:cardinal_sdk/model/couchdb/group_databases_info.dart';
import 'package:cardinal_sdk/model/replication_info.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/security/external_jwt_config.dart';
import 'package:cardinal_sdk/model/base/code_stub.dart';


class GroupPlatformApi {
	MethodChannel _methodChannel;
	GroupPlatformApi(this._methodChannel);

	Future<List<Group>> listGroups(String sdkId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupApi.listGroups',
			{
				"sdkId": sdkId,
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listGroups");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Group.fromJSON(x1) ).toList();
	}

	Future<Group> getGroup(String sdkId, String id) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupApi.getGroup',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getGroup");
		final parsedResJson = jsonDecode(res);
		return Group.fromJSON(parsedResJson);
	}

	Future<Group> createGroup(String sdkId, String id, String name, GroupType? type, String password, String? server, int? q, int? n, String? superGroup, String? projectId, DatabaseInitialisation initialisationData) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupApi.createGroup',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"name": jsonEncode(name),
				"type": jsonEncode(type == null ? null : GroupType.encode(type!)),
				"password": jsonEncode(password),
				"server": jsonEncode(server),
				"q": jsonEncode(q),
				"n": jsonEncode(n),
				"superGroup": jsonEncode(superGroup),
				"projectId": jsonEncode(projectId),
				"initialisationData": jsonEncode(DatabaseInitialisation.encode(initialisationData)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createGroup");
		final parsedResJson = jsonDecode(res);
		return Group.fromJSON(parsedResJson);
	}

	Future<RegistrationSuccess> registerNewGroupAdministrator(String sdkId, GroupType? type, PermissionType? role, RegistrationInformation registrationInformation) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupApi.registerNewGroupAdministrator',
			{
				"sdkId": sdkId,
				"type": jsonEncode(type == null ? null : GroupType.encode(type!)),
				"role": jsonEncode(role == null ? null : PermissionType.encode(role!)),
				"registrationInformation": jsonEncode(RegistrationInformation.encode(registrationInformation)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method registerNewGroupAdministrator");
		final parsedResJson = jsonDecode(res);
		return RegistrationSuccess.fromJSON(parsedResJson);
	}

	Future<List<Group>> listApps(String sdkId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupApi.listApps',
			{
				"sdkId": sdkId,
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listApps");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Group.fromJSON(x1) ).toList();
	}

	Future<String> getNameOfGroupParent(String sdkId, String id) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupApi.getNameOfGroupParent',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getNameOfGroupParent");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as String);
	}

	Future<Group> modifyGroupName(String sdkId, String id, String name) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupApi.modifyGroupName',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"name": jsonEncode(name),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyGroupName");
		final parsedResJson = jsonDecode(res);
		return Group.fromJSON(parsedResJson);
	}

	Future<String> getOperationToken(String sdkId, Operation operation, int? duration, String? description) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupApi.getOperationToken',
			{
				"sdkId": sdkId,
				"operation": jsonEncode(Operation.encode(operation)),
				"duration": jsonEncode(duration),
				"description": jsonEncode(description),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getOperationToken");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as String);
	}

	Future<void> deleteOperationToken(String sdkId, String tokenId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupApi.deleteOperationToken',
			{
				"sdkId": sdkId,
				"tokenId": jsonEncode(tokenId),
			}
		).catchError(convertPlatformException);
	}

	Future<Group> setDefaultRoles(String sdkId, String groupId, String userType, List<String> roleIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupApi.setDefaultRoles',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"userType": jsonEncode(userType),
				"roleIds": jsonEncode(roleIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method setDefaultRoles");
		final parsedResJson = jsonDecode(res);
		return Group.fromJSON(parsedResJson);
	}

	Future<Map<UserType, List<RoleConfiguration>>> getDefaultRoles(String sdkId, String groupId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupApi.getDefaultRoles',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getDefaultRoles");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as Map<String, dynamic>).map((k1, v1) => MapEntry(UserType.fromJSON(k1), (v1 as List<dynamic>).map((x2) => RoleConfiguration.fromJSON(x2) ).toList()));
	}

	Future<Group> deleteGroup(String sdkId, String id) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupApi.deleteGroup',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteGroup");
		final parsedResJson = jsonDecode(res);
		return Group.fromJSON(parsedResJson);
	}

	Future<Group> changeSuperGroup(String sdkId, String childGroupId, String operationToken) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupApi.changeSuperGroup',
			{
				"sdkId": sdkId,
				"childGroupId": jsonEncode(childGroupId),
				"operationToken": jsonEncode(operationToken),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method changeSuperGroup");
		final parsedResJson = jsonDecode(res);
		return Group.fromJSON(parsedResJson);
	}

	Future<List<GroupDeletionReport>> hardDeleteGroup(String sdkId, String id) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupApi.hardDeleteGroup',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method hardDeleteGroup");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupDeletionReport.fromJSON(x1) ).toList();
	}

	Future<Group> modifyGroupProperties(String sdkId, String id, ListOfProperties properties) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupApi.modifyGroupProperties',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"properties": jsonEncode(ListOfProperties.encode(properties)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyGroupProperties");
		final parsedResJson = jsonDecode(res);
		return Group.fromJSON(parsedResJson);
	}

	Future<Group> setGroupPassword(String sdkId, String id, String password) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupApi.setGroupPassword',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"password": jsonEncode(password),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method setGroupPassword");
		final parsedResJson = jsonDecode(res);
		return Group.fromJSON(parsedResJson);
	}

	Future<List<DesignDocument>> initDesignDocs(String sdkId, String id, String? clazz, bool? warmup, bool? dryRun) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupApi.initDesignDocs',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"clazz": jsonEncode(clazz),
				"warmup": jsonEncode(warmup),
				"dryRun": jsonEncode(dryRun),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method initDesignDocs");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DesignDocument.fromJSON(x1) ).toList();
	}

	Future<List<IdWithRev>> solveConflicts(String sdkId, String id, int? limit, bool? warmup) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupApi.solveConflicts',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"limit": jsonEncode(limit),
				"warmup": jsonEncode(warmup),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method solveConflicts");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => IdWithRev.fromJSON(x1) ).toList();
	}

	Future<void> resetStorage(String sdkId, String id, int? q, int? n, List<String> databases) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupApi.resetStorage',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"q": jsonEncode(q),
				"n": jsonEncode(n),
				"databases": jsonEncode(databases.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
	}

	Future<List<GroupDatabasesInfo>> getGroupsStorageInfos(String sdkId, List<String> groups) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupApi.getGroupsStorageInfos',
			{
				"sdkId": sdkId,
				"groups": jsonEncode(groups.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getGroupsStorageInfos");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupDatabasesInfo.fromJSON(x1) ).toList();
	}

	Future<ReplicationInfo> getReplicationInfo(String sdkId, String id) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupApi.getReplicationInfo',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getReplicationInfo");
		final parsedResJson = jsonDecode(res);
		return ReplicationInfo.fromJSON(parsedResJson);
	}

	Future<List<String>> getHierarchy(String sdkId, String id) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupApi.getHierarchy',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getHierarchy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<DocIdentifier>> listAllGroupsIds(String sdkId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupApi.listAllGroupsIds',
			{
				"sdkId": sdkId,
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listAllGroupsIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<Group> createOrUpdateExternalJwtConfig(String sdkId, String groupId, String key, ExternalJwtConfig config) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupApi.createOrUpdateExternalJwtConfig',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"key": jsonEncode(key),
				"config": jsonEncode(ExternalJwtConfig.encode(config)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createOrUpdateExternalJwtConfig");
		final parsedResJson = jsonDecode(res);
		return Group.fromJSON(parsedResJson);
	}

	Future<Group> removeExternalJwtConfig(String sdkId, String groupId, String key) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupApi.removeExternalJwtConfig',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"key": jsonEncode(key),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method removeExternalJwtConfig");
		final parsedResJson = jsonDecode(res);
		return Group.fromJSON(parsedResJson);
	}

	Future<String> getOperationTokenForGroup(String sdkId, String groupId, Operation operation, int? duration, String? description) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupApi.getOperationTokenForGroup',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"operation": jsonEncode(Operation.encode(operation)),
				"duration": jsonEncode(duration),
				"description": jsonEncode(description),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getOperationTokenForGroup");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as String);
	}

	Future<void> setGroupProjectId(String sdkId, String groupId, String? projectId, bool applyToSubgroups) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupApi.setGroupProjectId',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"projectId": jsonEncode(projectId),
				"applyToSubgroups": jsonEncode(applyToSubgroups),
			}
		).catchError(convertPlatformException);
	}

	Future<Group> modifyGroupApplicationId(String sdkId, String id, String applicationId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupApi.modifyGroupApplicationId',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"applicationId": jsonEncode(applicationId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyGroupApplicationId");
		final parsedResJson = jsonDecode(res);
		return Group.fromJSON(parsedResJson);
	}

	Future<Group> addTagToGroup(String sdkId, String id, String rev, CodeStub tag) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupApi.addTagToGroup',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
				"tag": jsonEncode(CodeStub.encode(tag)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method addTagToGroup");
		final parsedResJson = jsonDecode(res);
		return Group.fromJSON(parsedResJson);
	}

	Future<Group> removeTagFromGroup(String sdkId, String id, String rev, String tagId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'GroupApi.removeTagFromGroup',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
				"tagId": jsonEncode(tagId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method removeTagFromGroup");
		final parsedResJson = jsonDecode(res);
		return Group.fromJSON(parsedResJson);
	}
}