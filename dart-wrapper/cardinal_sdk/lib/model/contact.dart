// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/base/identifier.dart';
import 'package:cardinal_sdk/model/embed/address.dart';
import 'package:cardinal_sdk/model/embed/sub_contact.dart';
import 'package:cardinal_sdk/model/embed/service.dart';
import 'package:cardinal_sdk/model/base/participant_type.dart';
import 'package:cardinal_sdk/model/embed/contact_participant.dart';
import 'package:cardinal_sdk/model/embed/delegation.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/security_metadata.dart';
import 'package:cardinal_sdk/model/embed/annotation.dart';
import 'package:cardinal_sdk/model/contact.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';
import 'package:cardinal_sdk/model/base/has_encryption_metadata.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "contact.freezed.dart";


sealed class Contact implements StoredDocument, ICureDocument<String>, HasEncryptionMetadata, Encryptable {
	@override abstract final String id;
	@override abstract final String? rev;
	@override abstract final int? created;
	@override abstract final int? modified;
	@override abstract final String? author;
	@override abstract final String? responsible;
	@override abstract final String? medicalLocationId;
	@override abstract final Set<CodeStub> tags;
	@override abstract final Set<CodeStub> codes;
	abstract final List<Identifier> identifier;
	@override abstract final int? endOfLife;
	@override abstract final int? deletionDate;
	abstract final String? groupId;
	abstract final int? openingDate;
	abstract final int? closingDate;
	abstract final String? descr;
	abstract final String? location;
	abstract final String? externalId;
	abstract final CodeStub? encounterType;
	Address? get encounterLocation;
	Set<SubContact> get subContacts;
	Set<Service> get services;
	@Deprecated('Use participantList') abstract final Map<ParticipantType, String> participants;
	abstract final List<ContactParticipant> participantList;
	abstract final String? healthcarePartyId;
	abstract final String? modifiedContactId;
	@override abstract final Set<String> secretForeignKeys;
	@override abstract final Map<String, Set<Delegation>> cryptedForeignKeys;
	@override abstract final Map<String, Set<Delegation>> delegations;
	@override abstract final Map<String, Set<Delegation>> encryptionKeys;
	@override abstract final Base64String? encryptedSelf;
	@override abstract final SecurityMetadata? securityMetadata;
	abstract final List<Annotation> notes;

	static Map<String, dynamic> encode(Contact value) {
		switch (value) {
			case DecryptedContact entity:
				Map<String, dynamic> entityJson = DecryptedContact.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedContact";
				return entityJson;
			case EncryptedContact entity:
				Map<String, dynamic> entityJson = EncryptedContact.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedContact";
				return entityJson;
		}
	}

	static Contact fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.DecryptedContact":
				return DecryptedContact.fromJSON(data);
			case "com.icure.cardinal.sdk.model.EncryptedContact":
				return EncryptedContact.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

@freezed
abstract class DecryptedContact with _$DecryptedContact implements Contact {
	const factory DecryptedContact({
		required String id,
		@Default(null) String? rev,
		@Default(null) int? created,
		@Default(null) int? modified,
		@Default(null) String? author,
		@Default(null) String? responsible,
		@Default(null) String? medicalLocationId,
		@Default({}) Set<CodeStub> tags,
		@Default({}) Set<CodeStub> codes,
		@Default([]) List<Identifier> identifier,
		@Default(null) int? endOfLife,
		@Default(null) int? deletionDate,
		@Default(null) String? groupId,
		@Default(null) int? openingDate,
		@Default(null) int? closingDate,
		@Default(null) String? descr,
		@Default(null) String? location,
		@Default(null) String? externalId,
		@Default(null) CodeStub? encounterType,
		@Default(null) DecryptedAddress? encounterLocation,
		@Default({}) Set<DecryptedSubContact> subContacts,
		@Default({}) Set<DecryptedService> services,
		@Default({}) Map<ParticipantType, String> participants,
		@Default([]) List<ContactParticipant> participantList,
		@Default(null) String? healthcarePartyId,
		@Default(null) String? modifiedContactId,
		@Default({}) Set<String> secretForeignKeys,
		@Default({}) Map<String, Set<Delegation>> cryptedForeignKeys,
		@Default({}) Map<String, Set<Delegation>> delegations,
		@Default({}) Map<String, Set<Delegation>> encryptionKeys,
		@Default(null) Base64String? encryptedSelf,
		@Default(null) SecurityMetadata? securityMetadata,
		@Default([]) List<Annotation> notes,
	}) = _DecryptedContact;


	static Map<String, dynamic> encode(DecryptedContact value) {
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
			"identifier" : value.identifier.map((x0) => Identifier.encode(x0)).toList(),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"groupId" : value.groupId,
			"openingDate" : value.openingDate,
			"closingDate" : value.closingDate,
			"descr" : value.descr,
			"location" : value.location,
			"externalId" : value.externalId,
			"encounterType" : value.encounterType == null ? null : CodeStub.encode(value.encounterType!),
			"encounterLocation" : value.encounterLocation == null ? null : DecryptedAddress.encode(value.encounterLocation!),
			"subContacts" : value.subContacts.map((x0) => DecryptedSubContact.encode(x0)).toList(),
			"services" : value.services.map((x0) => DecryptedService.encode(x0)).toList(),
			"participants" : value.participants.map((k0, v0) => MapEntry(ParticipantType.encode(k0), v0)),
			"participantList" : value.participantList.map((x0) => ContactParticipant.encode(x0)).toList(),
			"healthcarePartyId" : value.healthcarePartyId,
			"modifiedContactId" : value.modifiedContactId,
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!),
			"notes" : value.notes.map((x0) => Annotation.encode(x0)).toList()
		};
		return entityAsMap;
	}

	static DecryptedContact fromJSON(Map<String, dynamic> data) {
		return DecryptedContact(
			id: (data["id"] as String),
			rev: (data["rev"] as String?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			medicalLocationId: (data["medicalLocationId"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			identifier: (data["identifier"] as List<dynamic>).map((x0) => Identifier.fromJSON(x0) ).toList(),
			endOfLife: (data["endOfLife"] as int?),
			deletionDate: (data["deletionDate"] as int?),
			groupId: (data["groupId"] as String?),
			openingDate: (data["openingDate"] as int?),
			closingDate: (data["closingDate"] as int?),
			descr: (data["descr"] as String?),
			location: (data["location"] as String?),
			externalId: (data["externalId"] as String?),
			encounterType: data["encounterType"] == null ? null : CodeStub.fromJSON(data["encounterType"]),
			encounterLocation: data["encounterLocation"] == null ? null : DecryptedAddress.fromJSON(data["encounterLocation"]),
			subContacts: (data["subContacts"] as List<dynamic>).map((x0) => DecryptedSubContact.fromJSON(x0) ).toSet(),
			services: (data["services"] as List<dynamic>).map((x0) => DecryptedService.fromJSON(x0) ).toSet(),
			participants: (data["participants"] as Map<String, dynamic>).map((k0, v0) => MapEntry(ParticipantType.fromJSON(k0), (v0 as String))),
			participantList: (data["participantList"] as List<dynamic>).map((x0) => ContactParticipant.fromJSON(x0) ).toList(),
			healthcarePartyId: (data["healthcarePartyId"] as String?),
			modifiedContactId: (data["modifiedContactId"] as String?),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
			notes: (data["notes"] as List<dynamic>).map((x0) => Annotation.fromJSON(x0) ).toList(),
		);
	}
}

@freezed
abstract class EncryptedContact with _$EncryptedContact implements Contact {
	const factory EncryptedContact({
		required String id,
		@Default(null) String? rev,
		@Default(null) int? created,
		@Default(null) int? modified,
		@Default(null) String? author,
		@Default(null) String? responsible,
		@Default(null) String? medicalLocationId,
		@Default({}) Set<CodeStub> tags,
		@Default({}) Set<CodeStub> codes,
		@Default([]) List<Identifier> identifier,
		@Default(null) int? endOfLife,
		@Default(null) int? deletionDate,
		@Default(null) String? groupId,
		@Default(null) int? openingDate,
		@Default(null) int? closingDate,
		@Default(null) String? descr,
		@Default(null) String? location,
		@Default(null) String? externalId,
		@Default(null) CodeStub? encounterType,
		@Default(null) EncryptedAddress? encounterLocation,
		@Default({}) Set<EncryptedSubContact> subContacts,
		@Default({}) Set<EncryptedService> services,
		@Default({}) Map<ParticipantType, String> participants,
		@Default([]) List<ContactParticipant> participantList,
		@Default(null) String? healthcarePartyId,
		@Default(null) String? modifiedContactId,
		@Default({}) Set<String> secretForeignKeys,
		@Default({}) Map<String, Set<Delegation>> cryptedForeignKeys,
		@Default({}) Map<String, Set<Delegation>> delegations,
		@Default({}) Map<String, Set<Delegation>> encryptionKeys,
		@Default(null) Base64String? encryptedSelf,
		@Default(null) SecurityMetadata? securityMetadata,
		@Default([]) List<Annotation> notes,
	}) = _EncryptedContact;


	static Map<String, dynamic> encode(EncryptedContact value) {
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
			"identifier" : value.identifier.map((x0) => Identifier.encode(x0)).toList(),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"groupId" : value.groupId,
			"openingDate" : value.openingDate,
			"closingDate" : value.closingDate,
			"descr" : value.descr,
			"location" : value.location,
			"externalId" : value.externalId,
			"encounterType" : value.encounterType == null ? null : CodeStub.encode(value.encounterType!),
			"encounterLocation" : value.encounterLocation == null ? null : EncryptedAddress.encode(value.encounterLocation!),
			"subContacts" : value.subContacts.map((x0) => EncryptedSubContact.encode(x0)).toList(),
			"services" : value.services.map((x0) => EncryptedService.encode(x0)).toList(),
			"participants" : value.participants.map((k0, v0) => MapEntry(ParticipantType.encode(k0), v0)),
			"participantList" : value.participantList.map((x0) => ContactParticipant.encode(x0)).toList(),
			"healthcarePartyId" : value.healthcarePartyId,
			"modifiedContactId" : value.modifiedContactId,
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!),
			"notes" : value.notes.map((x0) => Annotation.encode(x0)).toList()
		};
		return entityAsMap;
	}

	static EncryptedContact fromJSON(Map<String, dynamic> data) {
		return EncryptedContact(
			id: (data["id"] as String),
			rev: (data["rev"] as String?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			medicalLocationId: (data["medicalLocationId"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			identifier: (data["identifier"] as List<dynamic>).map((x0) => Identifier.fromJSON(x0) ).toList(),
			endOfLife: (data["endOfLife"] as int?),
			deletionDate: (data["deletionDate"] as int?),
			groupId: (data["groupId"] as String?),
			openingDate: (data["openingDate"] as int?),
			closingDate: (data["closingDate"] as int?),
			descr: (data["descr"] as String?),
			location: (data["location"] as String?),
			externalId: (data["externalId"] as String?),
			encounterType: data["encounterType"] == null ? null : CodeStub.fromJSON(data["encounterType"]),
			encounterLocation: data["encounterLocation"] == null ? null : EncryptedAddress.fromJSON(data["encounterLocation"]),
			subContacts: (data["subContacts"] as List<dynamic>).map((x0) => EncryptedSubContact.fromJSON(x0) ).toSet(),
			services: (data["services"] as List<dynamic>).map((x0) => EncryptedService.fromJSON(x0) ).toSet(),
			participants: (data["participants"] as Map<String, dynamic>).map((k0, v0) => MapEntry(ParticipantType.fromJSON(k0), (v0 as String))),
			participantList: (data["participantList"] as List<dynamic>).map((x0) => ContactParticipant.fromJSON(x0) ).toList(),
			healthcarePartyId: (data["healthcarePartyId"] as String?),
			modifiedContactId: (data["modifiedContactId"] as String?),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
			notes: (data["notes"] as List<dynamic>).map((x0) => Annotation.fromJSON(x0) ).toList(),
		);
	}
}