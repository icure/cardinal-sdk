// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/property_stub.dart';
import 'package:cardinal_sdk/model/embed/user_type.dart';
import 'package:cardinal_sdk/model/security/operation_token.dart';
import 'package:cardinal_sdk/model/security/external_jwt_config.dart';
import 'package:cardinal_sdk/model/embed/authentication_class.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/has_tags.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "group.freezed.dart";


@freezed
abstract class Group with _$Group implements StoredDocument, HasTags {
	const factory Group({
		required String id,
		@Default(null) String? rev,
		@Default(null) int? deletionDate,
		@Default({}) Set<CodeStub> tags,
		@Default({}) Set<CodeStub> publicTags,
		@Default(null) String? name,
		@Default(null) String? password,
		@Default(null) List<String>? servers,
		@Default(false) bool superAdmin,
		@Default({}) Set<DecryptedPropertyStub> properties,
		@Default({}) Map<UserType, Set<String>> defaultUserRoles,
		@Default({}) Map<String, OperationToken> operationTokens,
		@Default({}) Map<String, String> sharedEntities,
		@Default(null) String? minimumKrakenVersion,
		@Default({}) Map<String, ExternalJwtConfig> externalJwtConfig,
		required AuthenticationClass minimumAuthenticationClassForElevatedPrivileges,
		@Default(null) String? superGroup,
		@Default(null) String? projectId,
	}) = _Group;


	static Map<String, dynamic> encode(Group value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"deletionDate" : value.deletionDate,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"publicTags" : value.publicTags.map((x0) => CodeStub.encode(x0)).toList(),
			"name" : value.name,
			"password" : value.password,
			"servers" : value.servers?.map((x0) => x0).toList(),
			"superAdmin" : value.superAdmin,
			"properties" : value.properties.map((x0) => DecryptedPropertyStub.encode(x0)).toList(),
			"defaultUserRoles" : value.defaultUserRoles.map((k0, v0) => MapEntry(UserType.encode(k0), v0.map((x1) => x1).toList())),
			"operationTokens" : value.operationTokens.map((k0, v0) => MapEntry(k0, OperationToken.encode(v0))),
			"sharedEntities" : value.sharedEntities.map((k0, v0) => MapEntry(k0, v0)),
			"minimumKrakenVersion" : value.minimumKrakenVersion,
			"externalJwtConfig" : value.externalJwtConfig.map((k0, v0) => MapEntry(k0, ExternalJwtConfig.encode(v0))),
			"minimumAuthenticationClassForElevatedPrivileges" : AuthenticationClass.encode(value.minimumAuthenticationClassForElevatedPrivileges),
			"superGroup" : value.superGroup,
			"projectId" : value.projectId
		};
		return entityAsMap;
	}

	static Group fromJSON(Map<String, dynamic> data) {
		return Group(
			id: (data["id"] as String),
			minimumAuthenticationClassForElevatedPrivileges: AuthenticationClass.fromJSON(data["minimumAuthenticationClassForElevatedPrivileges"]),
			rev: (data["rev"] as String?),
			deletionDate: (data["deletionDate"] as int?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			publicTags: (data["publicTags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			name: (data["name"] as String?),
			password: (data["password"] as String?),
			servers: (data["servers"] as List<dynamic>?)?.map((x0) => (x0 as String) ).toList(),
			superAdmin: (data["superAdmin"] as bool),
			properties: (data["properties"] as List<dynamic>).map((x0) => DecryptedPropertyStub.fromJSON(x0) ).toSet(),
			defaultUserRoles: (data["defaultUserRoles"] as Map<String, dynamic>).map((k0, v0) => MapEntry(UserType.fromJSON(k0), (v0 as List<dynamic>).map((x1) => (x1 as String) ).toSet())),
			operationTokens: (data["operationTokens"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), OperationToken.fromJSON(v0))),
			sharedEntities: (data["sharedEntities"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			minimumKrakenVersion: (data["minimumKrakenVersion"] as String?),
			externalJwtConfig: (data["externalJwtConfig"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), ExternalJwtConfig.fromJSON(v0))),
			superGroup: (data["superGroup"] as String?),
			projectId: (data["projectId"] as String?),
		);
	}
}