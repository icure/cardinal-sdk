// auto-generated file
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "role.freezed.dart";


@freezed
abstract class Role with _$Role implements StoredDocument {
	const factory Role({
		required String id,
		@Default(null) String? rev,
		@Default(null) int? deletionDate,
		@Default(null) String? name,
		@Default(null) int? inheritableUpTo,
		@Default({}) Set<String> permissions,
	}) = _Role;


	static Map<String, dynamic> encode(Role value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"deletionDate" : value.deletionDate,
			"name" : value.name,
			"inheritableUpTo" : value.inheritableUpTo,
			"permissions" : value.permissions.map((x0) => x0).toList()
		};
		return entityAsMap;
	}

	static Role fromJSON(Map<String, dynamic> data) {
		return Role(
			id: (data["id"] as String),
			inheritableUpTo: (data["inheritableUpTo"] as int?),
			rev: (data["rev"] as String?),
			deletionDate: (data["deletionDate"] as int?),
			name: (data["name"] as String?),
			permissions: (data["permissions"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
		);
	}
}