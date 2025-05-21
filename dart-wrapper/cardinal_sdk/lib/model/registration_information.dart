// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "registration_information.freezed.dart";


@freezed
abstract class RegistrationInformation with _$RegistrationInformation {
	const factory RegistrationInformation({
		required String firstName,
		required String lastName,
		required String emailAddress,
		@Default(null) String? userOptions,
		@Default({}) Set<String> userRoles,
		@Default(null) String? minimumKrakenVersion,
	}) = _RegistrationInformation;


	static Map<String, dynamic> encode(RegistrationInformation value) {
		Map<String, dynamic> entityAsMap = {
			"firstName" : value.firstName,
			"lastName" : value.lastName,
			"emailAddress" : value.emailAddress,
			"userOptions" : value.userOptions,
			"userRoles" : value.userRoles.map((x0) => x0).toList(),
			"minimumKrakenVersion" : value.minimumKrakenVersion
		};
		return entityAsMap;
	}

	static RegistrationInformation fromJSON(Map<String, dynamic> data) {
		return RegistrationInformation(
			firstName: (data["firstName"] as String),
			lastName: (data["lastName"] as String),
			emailAddress: (data["emailAddress"] as String),
			userOptions: (data["userOptions"] as String?),
			userRoles: (data["userRoles"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			minimumKrakenVersion: (data["minimumKrakenVersion"] as String?),
		);
	}
}