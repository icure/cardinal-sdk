// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/address.dart';
import 'package:cardinal_sdk/model/embed/calendar_item_tag.dart';
import 'package:cardinal_sdk/model/embed/flow_item.dart';
import 'package:cardinal_sdk/model/embed/delegation.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/security_metadata.dart';
import 'package:cardinal_sdk/model/calendar_item.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';
import 'package:cardinal_sdk/model/base/has_encryption_metadata.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "calendar_item.freezed.dart";


sealed class CalendarItem implements StoredDocument, ICureDocument<String>, HasEncryptionMetadata, Encryptable {
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
	abstract final String? title;
	abstract final String? calendarItemTypeId;
	abstract final String? masterCalendarItemId;
	abstract final String? patientId;
	abstract final bool? important;
	abstract final bool? homeVisit;
	abstract final String? phoneNumber;
	abstract final String? placeId;
	Address? get address;
	abstract final String? addressText;
	abstract final int? startTime;
	abstract final int? endTime;
	@Deprecated('Ignored by availabilities algorithm, will be replaced by another more descriptive field') abstract final int? confirmationTime;
	@Deprecated('Ignored by availabilities algorithm, will be replaced by another more descriptive field') abstract final int? cancellationTimestamp;
	@Deprecated('Ignored by availabilities algorithm, will be replaced by another more descriptive field') abstract final String? confirmationId;
	@Deprecated('Ignored by availabilities algorithm, use appropriate startTime and endTime') abstract final int? duration;
	@Deprecated('Ignored by availabilities algorithm, use appropriate startTime and endTime') abstract final bool? allDay;
	abstract final String? details;
	abstract final bool? wasMigrated;
	abstract final String? agendaId;
	abstract final CodeStub? resourceGroup;
	abstract final CalendarItemAvailabilitiesAssignmentStrategy? availabilitiesAssignmentStrategy;
	abstract final String? hcpId;
	abstract final String? recurrenceId;
	Set<CalendarItemTag> get meetingTags;
	abstract final FlowItem? flowItem;
	@override abstract final Set<String> secretForeignKeys;
	@override abstract final Map<String, Set<Delegation>> cryptedForeignKeys;
	@override abstract final Map<String, Set<Delegation>> delegations;
	@override abstract final Map<String, Set<Delegation>> encryptionKeys;
	@override abstract final Base64String? encryptedSelf;
	@override abstract final SecurityMetadata? securityMetadata;

	static Map<String, dynamic> encode(CalendarItem value) {
		switch (value) {
			case DecryptedCalendarItem entity:
				Map<String, dynamic> entityJson = DecryptedCalendarItem.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedCalendarItem";
				return entityJson;
			case EncryptedCalendarItem entity:
				Map<String, dynamic> entityJson = EncryptedCalendarItem.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedCalendarItem";
				return entityJson;
		}
	}

	static CalendarItem fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.DecryptedCalendarItem":
				return DecryptedCalendarItem.fromJSON(data);
			case "com.icure.cardinal.sdk.model.EncryptedCalendarItem":
				return EncryptedCalendarItem.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

enum CalendarItemAvailabilitiesAssignmentStrategy {
	strict,
	loose;

	static String encode(CalendarItemAvailabilitiesAssignmentStrategy value) {
		switch (value) {
			case CalendarItemAvailabilitiesAssignmentStrategy.strict:
				return 'S';
			case CalendarItemAvailabilitiesAssignmentStrategy.loose:
				return 'L';
			}
	}


	static CalendarItemAvailabilitiesAssignmentStrategy fromJSON(String data) {
		switch (data) {
			case "S":
				return CalendarItemAvailabilitiesAssignmentStrategy.strict;
			case "L":
				return CalendarItemAvailabilitiesAssignmentStrategy.loose;
			default:
				throw ArgumentError('Invalid CalendarItemAvailabilitiesAssignmentStrategy entry value $data');
			}
	}

}

@freezed
abstract class DecryptedCalendarItem with _$DecryptedCalendarItem implements CalendarItem {
	const factory DecryptedCalendarItem({
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
		@Default(null) String? title,
		@Default(null) String? calendarItemTypeId,
		@Default(null) String? masterCalendarItemId,
		@Default(null) String? patientId,
		@Default(null) bool? important,
		@Default(null) bool? homeVisit,
		@Default(null) String? phoneNumber,
		@Default(null) String? placeId,
		@Default(null) DecryptedAddress? address,
		@Default(null) String? addressText,
		@Default(null) int? startTime,
		@Default(null) int? endTime,
		@Default(null) int? confirmationTime,
		@Default(null) int? cancellationTimestamp,
		@Default(null) String? confirmationId,
		@Default(null) int? duration,
		@Default(null) bool? allDay,
		@Default(null) String? details,
		@Default(null) bool? wasMigrated,
		@Default(null) String? agendaId,
		@Default(null) CodeStub? resourceGroup,
		@Default(null) CalendarItemAvailabilitiesAssignmentStrategy? availabilitiesAssignmentStrategy,
		@Default(null) String? hcpId,
		@Default(null) String? recurrenceId,
		@Default({}) Set<DecryptedCalendarItemTag> meetingTags,
		@Default(null) FlowItem? flowItem,
		@Default({}) Set<String> secretForeignKeys,
		@Default({}) Map<String, Set<Delegation>> cryptedForeignKeys,
		@Default({}) Map<String, Set<Delegation>> delegations,
		@Default({}) Map<String, Set<Delegation>> encryptionKeys,
		@Default(null) Base64String? encryptedSelf,
		@Default(null) SecurityMetadata? securityMetadata,
	}) = _DecryptedCalendarItem;


	static Map<String, dynamic> encode(DecryptedCalendarItem value) {
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
			"title" : value.title,
			"calendarItemTypeId" : value.calendarItemTypeId,
			"masterCalendarItemId" : value.masterCalendarItemId,
			"patientId" : value.patientId,
			"important" : value.important,
			"homeVisit" : value.homeVisit,
			"phoneNumber" : value.phoneNumber,
			"placeId" : value.placeId,
			"address" : value.address == null ? null : DecryptedAddress.encode(value.address!),
			"addressText" : value.addressText,
			"startTime" : value.startTime,
			"endTime" : value.endTime,
			"confirmationTime" : value.confirmationTime,
			"cancellationTimestamp" : value.cancellationTimestamp,
			"confirmationId" : value.confirmationId,
			"duration" : value.duration,
			"allDay" : value.allDay,
			"details" : value.details,
			"wasMigrated" : value.wasMigrated,
			"agendaId" : value.agendaId,
			"resourceGroup" : value.resourceGroup == null ? null : CodeStub.encode(value.resourceGroup!),
			"availabilitiesAssignmentStrategy" : value.availabilitiesAssignmentStrategy == null ? null : CalendarItemAvailabilitiesAssignmentStrategy.encode(value.availabilitiesAssignmentStrategy!),
			"hcpId" : value.hcpId,
			"recurrenceId" : value.recurrenceId,
			"meetingTags" : value.meetingTags.map((x0) => DecryptedCalendarItemTag.encode(x0)).toList(),
			"flowItem" : value.flowItem == null ? null : FlowItem.encode(value.flowItem!),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}

	static DecryptedCalendarItem fromJSON(Map<String, dynamic> data) {
		return DecryptedCalendarItem(
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
			title: (data["title"] as String?),
			calendarItemTypeId: (data["calendarItemTypeId"] as String?),
			masterCalendarItemId: (data["masterCalendarItemId"] as String?),
			patientId: (data["patientId"] as String?),
			important: (data["important"] as bool?),
			homeVisit: (data["homeVisit"] as bool?),
			phoneNumber: (data["phoneNumber"] as String?),
			placeId: (data["placeId"] as String?),
			address: data["address"] == null ? null : DecryptedAddress.fromJSON(data["address"]),
			addressText: (data["addressText"] as String?),
			startTime: (data["startTime"] as int?),
			endTime: (data["endTime"] as int?),
			confirmationTime: (data["confirmationTime"] as int?),
			cancellationTimestamp: (data["cancellationTimestamp"] as int?),
			confirmationId: (data["confirmationId"] as String?),
			duration: (data["duration"] as int?),
			allDay: (data["allDay"] as bool?),
			details: (data["details"] as String?),
			wasMigrated: (data["wasMigrated"] as bool?),
			agendaId: (data["agendaId"] as String?),
			resourceGroup: data["resourceGroup"] == null ? null : CodeStub.fromJSON(data["resourceGroup"]),
			availabilitiesAssignmentStrategy: data["availabilitiesAssignmentStrategy"] == null ? null : CalendarItemAvailabilitiesAssignmentStrategy.fromJSON(data["availabilitiesAssignmentStrategy"]),
			hcpId: (data["hcpId"] as String?),
			recurrenceId: (data["recurrenceId"] as String?),
			meetingTags: (data["meetingTags"] as List<dynamic>).map((x0) => DecryptedCalendarItemTag.fromJSON(x0) ).toSet(),
			flowItem: data["flowItem"] == null ? null : FlowItem.fromJSON(data["flowItem"]),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}
}

@freezed
abstract class EncryptedCalendarItem with _$EncryptedCalendarItem implements CalendarItem {
	const factory EncryptedCalendarItem({
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
		@Default(null) String? title,
		@Default(null) String? calendarItemTypeId,
		@Default(null) String? masterCalendarItemId,
		@Default(null) String? patientId,
		@Default(null) bool? important,
		@Default(null) bool? homeVisit,
		@Default(null) String? phoneNumber,
		@Default(null) String? placeId,
		@Default(null) EncryptedAddress? address,
		@Default(null) String? addressText,
		@Default(null) int? startTime,
		@Default(null) int? endTime,
		@Default(null) int? confirmationTime,
		@Default(null) int? cancellationTimestamp,
		@Default(null) String? confirmationId,
		@Default(null) int? duration,
		@Default(null) bool? allDay,
		@Default(null) String? details,
		@Default(null) bool? wasMigrated,
		@Default(null) String? agendaId,
		@Default(null) CodeStub? resourceGroup,
		@Default(null) CalendarItemAvailabilitiesAssignmentStrategy? availabilitiesAssignmentStrategy,
		@Default(null) String? hcpId,
		@Default(null) String? recurrenceId,
		@Default({}) Set<EncryptedCalendarItemTag> meetingTags,
		@Default(null) FlowItem? flowItem,
		@Default({}) Set<String> secretForeignKeys,
		@Default({}) Map<String, Set<Delegation>> cryptedForeignKeys,
		@Default({}) Map<String, Set<Delegation>> delegations,
		@Default({}) Map<String, Set<Delegation>> encryptionKeys,
		@Default(null) Base64String? encryptedSelf,
		@Default(null) SecurityMetadata? securityMetadata,
	}) = _EncryptedCalendarItem;


	static Map<String, dynamic> encode(EncryptedCalendarItem value) {
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
			"title" : value.title,
			"calendarItemTypeId" : value.calendarItemTypeId,
			"masterCalendarItemId" : value.masterCalendarItemId,
			"patientId" : value.patientId,
			"important" : value.important,
			"homeVisit" : value.homeVisit,
			"phoneNumber" : value.phoneNumber,
			"placeId" : value.placeId,
			"address" : value.address == null ? null : EncryptedAddress.encode(value.address!),
			"addressText" : value.addressText,
			"startTime" : value.startTime,
			"endTime" : value.endTime,
			"confirmationTime" : value.confirmationTime,
			"cancellationTimestamp" : value.cancellationTimestamp,
			"confirmationId" : value.confirmationId,
			"duration" : value.duration,
			"allDay" : value.allDay,
			"details" : value.details,
			"wasMigrated" : value.wasMigrated,
			"agendaId" : value.agendaId,
			"resourceGroup" : value.resourceGroup == null ? null : CodeStub.encode(value.resourceGroup!),
			"availabilitiesAssignmentStrategy" : value.availabilitiesAssignmentStrategy == null ? null : CalendarItemAvailabilitiesAssignmentStrategy.encode(value.availabilitiesAssignmentStrategy!),
			"hcpId" : value.hcpId,
			"recurrenceId" : value.recurrenceId,
			"meetingTags" : value.meetingTags.map((x0) => EncryptedCalendarItemTag.encode(x0)).toList(),
			"flowItem" : value.flowItem == null ? null : FlowItem.encode(value.flowItem!),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}

	static EncryptedCalendarItem fromJSON(Map<String, dynamic> data) {
		return EncryptedCalendarItem(
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
			title: (data["title"] as String?),
			calendarItemTypeId: (data["calendarItemTypeId"] as String?),
			masterCalendarItemId: (data["masterCalendarItemId"] as String?),
			patientId: (data["patientId"] as String?),
			important: (data["important"] as bool?),
			homeVisit: (data["homeVisit"] as bool?),
			phoneNumber: (data["phoneNumber"] as String?),
			placeId: (data["placeId"] as String?),
			address: data["address"] == null ? null : EncryptedAddress.fromJSON(data["address"]),
			addressText: (data["addressText"] as String?),
			startTime: (data["startTime"] as int?),
			endTime: (data["endTime"] as int?),
			confirmationTime: (data["confirmationTime"] as int?),
			cancellationTimestamp: (data["cancellationTimestamp"] as int?),
			confirmationId: (data["confirmationId"] as String?),
			duration: (data["duration"] as int?),
			allDay: (data["allDay"] as bool?),
			details: (data["details"] as String?),
			wasMigrated: (data["wasMigrated"] as bool?),
			agendaId: (data["agendaId"] as String?),
			resourceGroup: data["resourceGroup"] == null ? null : CodeStub.fromJSON(data["resourceGroup"]),
			availabilitiesAssignmentStrategy: data["availabilitiesAssignmentStrategy"] == null ? null : CalendarItemAvailabilitiesAssignmentStrategy.fromJSON(data["availabilitiesAssignmentStrategy"]),
			hcpId: (data["hcpId"] as String?),
			recurrenceId: (data["recurrenceId"] as String?),
			meetingTags: (data["meetingTags"] as List<dynamic>).map((x0) => EncryptedCalendarItemTag.fromJSON(x0) ).toSet(),
			flowItem: data["flowItem"] == null ? null : FlowItem.fromJSON(data["flowItem"]),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}
}