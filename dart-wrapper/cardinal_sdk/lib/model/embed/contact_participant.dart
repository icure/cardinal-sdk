// auto-generated file
import 'package:cardinal_sdk/model/base/participant_type.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "contact_participant.freezed.dart";


@freezed
abstract class ContactParticipant with _$ContactParticipant {
	const factory ContactParticipant({
		required ParticipantType type,
		required String hcpId,
	}) = _ContactParticipant;


	static Map<String, dynamic> encode(ContactParticipant value) {
		Map<String, dynamic> entityAsMap = {
			"type" : ParticipantType.encode(value.type),
			"hcpId" : value.hcpId
		};
		return entityAsMap;
	}

	static ContactParticipant fromJSON(Map<String, dynamic> data) {
		return ContactParticipant(
			type: ParticipantType.fromJSON(data["type"]),
			hcpId: (data["hcpId"] as String)
		);
	}
}