// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/delegation.dart';
import 'package:cardinal_sdk/model/embed/security_metadata.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/application_settings.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';
import 'package:cardinal_sdk/model/base/has_encryption_metadata.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "application_settings.freezed.dart";


sealed class ApplicationSettings implements StoredDocument, ICureDocument<String>, HasEncryptionMetadata, Encryptable {
	@override abstract final String id;
	@override abstract final String? rev;
	@override abstract final int? created;
	@override abstract final int? modified;
	@override abstract final String? author;
	@override abstract final String? responsible;
	@override abstract final String? medicalLocationId;
	@override abstract final Set<CodeStub> tags;
	@override abstract final Set<CodeStub> codes;
	@override abstract final int? endOfLife;
	@override abstract final int? deletionDate;
	abstract final Map<String, String> settings;
	abstract final Map<String, String> encryptedSettings;
	@override abstract final Set<String> secretForeignKeys;
	@override abstract final Map<String, Set<Delegation>> cryptedForeignKeys;
	@override abstract final Map<String, Set<Delegation>> delegations;
	@override abstract final Map<String, Set<Delegation>> encryptionKeys;
	@override abstract final SecurityMetadata? securityMetadata;
	@override abstract final Base64String? encryptedSelf;

	static Map<String, dynamic> encode(ApplicationSettings value) {
		switch (value) {
			case DecryptedApplicationSettings entity:
				Map<String, dynamic> entityJson = DecryptedApplicationSettings.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedApplicationSettings";
				return entityJson;
			case EncryptedApplicationSettings entity:
				Map<String, dynamic> entityJson = EncryptedApplicationSettings.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedApplicationSettings";
				return entityJson;
		}
	}

	static ApplicationSettings fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.DecryptedApplicationSettings":
				return DecryptedApplicationSettings.fromJSON(data);
			case "com.icure.cardinal.sdk.model.EncryptedApplicationSettings":
				return EncryptedApplicationSettings.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

@freezed
abstract class DecryptedApplicationSettings with _$DecryptedApplicationSettings implements ApplicationSettings {
	const factory DecryptedApplicationSettings({
		required String id,
		@Default(null) String? rev,
		@Default(null) int? created,
		@Default(null) int? modified,
		@Default(null) String? author,
		@Default(null) String? responsible,
		@Default(null) String? medicalLocationId,
		@Default({}) Set<CodeStub> tags,
		@Default({}) Set<CodeStub> codes,
		@Default(null) int? endOfLife,
		@Default(null) int? deletionDate,
		@Default({}) Map<String, String> settings,
		@Default({}) Map<String, String> encryptedSettings,
		@Default({}) Set<String> secretForeignKeys,
		@Default({}) Map<String, Set<Delegation>> cryptedForeignKeys,
		@Default({}) Map<String, Set<Delegation>> delegations,
		@Default({}) Map<String, Set<Delegation>> encryptionKeys,
		@Default(null) SecurityMetadata? securityMetadata,
		@Default(null) Base64String? encryptedSelf,
	}) = _DecryptedApplicationSettings;


	static Map<String, dynamic> encode(DecryptedApplicationSettings value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"settings" : value.settings.map((k0, v0) => MapEntry(k0, v0)),
			"encryptedSettings" : value.encryptedSettings.map((k0, v0) => MapEntry(k0, v0)),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static DecryptedApplicationSettings fromJSON(Map<String, dynamic> data) {
		return DecryptedApplicationSettings(
			id: (data["id"] as String),
			rev: (data["rev"] as String?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			medicalLocationId: (data["medicalLocationId"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			endOfLife: (data["endOfLife"] as int?),
			deletionDate: (data["deletionDate"] as int?),
			settings: (data["settings"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			encryptedSettings: (data["encryptedSettings"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
		);
	}
}

@freezed
abstract class EncryptedApplicationSettings with _$EncryptedApplicationSettings implements ApplicationSettings {
	const factory EncryptedApplicationSettings({
		required String id,
		@Default(null) String? rev,
		@Default(null) int? created,
		@Default(null) int? modified,
		@Default(null) String? author,
		@Default(null) String? responsible,
		@Default(null) String? medicalLocationId,
		@Default({}) Set<CodeStub> tags,
		@Default({}) Set<CodeStub> codes,
		@Default(null) int? endOfLife,
		@Default(null) int? deletionDate,
		@Default({}) Map<String, String> settings,
		@Default({}) Map<String, String> encryptedSettings,
		@Default({}) Set<String> secretForeignKeys,
		@Default({}) Map<String, Set<Delegation>> cryptedForeignKeys,
		@Default({}) Map<String, Set<Delegation>> delegations,
		@Default({}) Map<String, Set<Delegation>> encryptionKeys,
		@Default(null) SecurityMetadata? securityMetadata,
		@Default(null) Base64String? encryptedSelf,
	}) = _EncryptedApplicationSettings;


	static Map<String, dynamic> encode(EncryptedApplicationSettings value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"settings" : value.settings.map((k0, v0) => MapEntry(k0, v0)),
			"encryptedSettings" : value.encryptedSettings.map((k0, v0) => MapEntry(k0, v0)),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static EncryptedApplicationSettings fromJSON(Map<String, dynamic> data) {
		return EncryptedApplicationSettings(
			id: (data["id"] as String),
			rev: (data["rev"] as String?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			medicalLocationId: (data["medicalLocationId"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			endOfLife: (data["endOfLife"] as int?),
			deletionDate: (data["deletionDate"] as int?),
			settings: (data["settings"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			encryptedSettings: (data["encryptedSettings"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
		);
	}
}