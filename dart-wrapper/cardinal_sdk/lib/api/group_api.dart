// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/group.dart';
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


class GroupApi {
	final String _sdkId;
	final Object _dartSdk;
	GroupApi(
		this._sdkId,
		this._dartSdk
		);

	Future<List<Group>> listGroups() async {
		return await CardinalSdkPlatformInterface.instance.apis.group.listGroups(
			_sdkId,
		);
	}

	Future<Group> getGroup(String id) async {
		return await CardinalSdkPlatformInterface.instance.apis.group.getGroup(
			_sdkId,
			id,
		);
	}

	Future<Group> createGroup(String id, String name, String password, DatabaseInitialisation initialisationData, { GroupType? type, String? server, int? q, int? n, String? superGroup, String? projectId }) async {
		return await CardinalSdkPlatformInterface.instance.apis.group.createGroup(
			_sdkId,
			id,
			name,
			type,
			password,
			server,
			q,
			n,
			superGroup,
			projectId,
			initialisationData,
		);
	}

	Future<RegistrationSuccess> registerNewGroupAdministrator(RegistrationInformation registrationInformation, { GroupType? type, PermissionType? role }) async {
		return await CardinalSdkPlatformInterface.instance.apis.group.registerNewGroupAdministrator(
			_sdkId,
			type,
			role,
			registrationInformation,
		);
	}

	Future<List<Group>> listApps() async {
		return await CardinalSdkPlatformInterface.instance.apis.group.listApps(
			_sdkId,
		);
	}

	Future<String> getNameOfGroupParent(String id) async {
		return await CardinalSdkPlatformInterface.instance.apis.group.getNameOfGroupParent(
			_sdkId,
			id,
		);
	}

	Future<Group> modifyGroupName(String id, String name) async {
		return await CardinalSdkPlatformInterface.instance.apis.group.modifyGroupName(
			_sdkId,
			id,
			name,
		);
	}

	Future<String> getOperationToken(Operation operation, int? duration, { String? description }) async {
		return await CardinalSdkPlatformInterface.instance.apis.group.getOperationToken(
			_sdkId,
			operation,
			duration,
			description,
		);
	}

	Future<void> deleteOperationToken(String tokenId) async {
		return await CardinalSdkPlatformInterface.instance.apis.group.deleteOperationToken(
			_sdkId,
			tokenId,
		);
	}

	Future<Group> setDefaultRoles(String groupId, String userType, List<String> roleIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.group.setDefaultRoles(
			_sdkId,
			groupId,
			userType,
			roleIds,
		);
	}

	Future<Map<UserType, List<RoleConfiguration>>> getDefaultRoles(String groupId) async {
		return await CardinalSdkPlatformInterface.instance.apis.group.getDefaultRoles(
			_sdkId,
			groupId,
		);
	}

	Future<Group> deleteGroup(String id) async {
		return await CardinalSdkPlatformInterface.instance.apis.group.deleteGroup(
			_sdkId,
			id,
		);
	}

	Future<Group> changeSuperGroup(String childGroupId, String operationToken) async {
		return await CardinalSdkPlatformInterface.instance.apis.group.changeSuperGroup(
			_sdkId,
			childGroupId,
			operationToken,
		);
	}

	Future<List<GroupDeletionReport>> hardDeleteGroup(String id) async {
		return await CardinalSdkPlatformInterface.instance.apis.group.hardDeleteGroup(
			_sdkId,
			id,
		);
	}

	Future<Group> modifyGroupProperties(String id, ListOfProperties properties) async {
		return await CardinalSdkPlatformInterface.instance.apis.group.modifyGroupProperties(
			_sdkId,
			id,
			properties,
		);
	}

	Future<Group> setGroupPassword(String id, String password) async {
		return await CardinalSdkPlatformInterface.instance.apis.group.setGroupPassword(
			_sdkId,
			id,
			password,
		);
	}

	Future<List<DesignDocument>> initDesignDocs(String id, bool? warmup, bool? dryRun, { String? clazz }) async {
		return await CardinalSdkPlatformInterface.instance.apis.group.initDesignDocs(
			_sdkId,
			id,
			clazz,
			warmup,
			dryRun,
		);
	}

	Future<List<IdWithRev>> solveConflicts(String id, int? limit, bool? warmup) async {
		return await CardinalSdkPlatformInterface.instance.apis.group.solveConflicts(
			_sdkId,
			id,
			limit,
			warmup,
		);
	}

	Future<void> resetStorage(String id, List<String> databases, { int? q, int? n }) async {
		return await CardinalSdkPlatformInterface.instance.apis.group.resetStorage(
			_sdkId,
			id,
			q,
			n,
			databases,
		);
	}

	Future<List<GroupDatabasesInfo>> getGroupsStorageInfos(List<String> groups) async {
		return await CardinalSdkPlatformInterface.instance.apis.group.getGroupsStorageInfos(
			_sdkId,
			groups,
		);
	}

	Future<ReplicationInfo> getReplicationInfo(String id) async {
		return await CardinalSdkPlatformInterface.instance.apis.group.getReplicationInfo(
			_sdkId,
			id,
		);
	}

	Future<List<String>> getHierarchy(String id) async {
		return await CardinalSdkPlatformInterface.instance.apis.group.getHierarchy(
			_sdkId,
			id,
		);
	}

	Future<List<DocIdentifier>> listAllGroupsIds() async {
		return await CardinalSdkPlatformInterface.instance.apis.group.listAllGroupsIds(
			_sdkId,
		);
	}

	Future<Group> createOrUpdateExternalJwtConfig(String groupId, String key, ExternalJwtConfig config) async {
		return await CardinalSdkPlatformInterface.instance.apis.group.createOrUpdateExternalJwtConfig(
			_sdkId,
			groupId,
			key,
			config,
		);
	}

	Future<Group> removeExternalJwtConfig(String groupId, String key) async {
		return await CardinalSdkPlatformInterface.instance.apis.group.removeExternalJwtConfig(
			_sdkId,
			groupId,
			key,
		);
	}

	Future<String> getOperationTokenForGroup(String groupId, Operation operation, int? duration, String? description) async {
		return await CardinalSdkPlatformInterface.instance.apis.group.getOperationTokenForGroup(
			_sdkId,
			groupId,
			operation,
			duration,
			description,
		);
	}

	Future<void> setGroupProjectId(String groupId, String? projectId, bool applyToSubgroups) async {
		return await CardinalSdkPlatformInterface.instance.apis.group.setGroupProjectId(
			_sdkId,
			groupId,
			projectId,
			applyToSubgroups,
		);
	}

	Future<Group> modifyGroupApplicationId(String id, String applicationId) async {
		return await CardinalSdkPlatformInterface.instance.apis.group.modifyGroupApplicationId(
			_sdkId,
			id,
			applicationId,
		);
	}

	Future<Group> addTagToGroup(String id, String rev, CodeStub tag) async {
		return await CardinalSdkPlatformInterface.instance.apis.group.addTagToGroup(
			_sdkId,
			id,
			rev,
			tag,
		);
	}

	Future<Group> removeTagFromGroup(String id, String rev, String tagId) async {
		return await CardinalSdkPlatformInterface.instance.apis.group.removeTagFromGroup(
			_sdkId,
			id,
			rev,
			tagId,
		);
	}
}