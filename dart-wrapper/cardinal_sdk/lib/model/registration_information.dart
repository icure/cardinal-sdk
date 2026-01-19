// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "registration_information.freezed.dart";


@freezed
abstract class RegistrationInformation with _$RegistrationInformation {
	const factory RegistrationInformation({
		@Default(null) String? projectId,
		@Default(null) String? firstName,
		@Default(null) String? lastName,
		@Default(null) String? companyName,
		required String emailAddress,
		@Default(null) String? userOptions,
		@Default({}) Set<String> userRoles,
		@Default(null) String? minimumKrakenVersion,
		@Default(null) String? cluster,
	}) = _RegistrationInformation;


	static Map<String, dynamic> encode(RegistrationInformation value) {
		Map<String, dynamic> entityAsMap = {
			"projectId" : value.projectId,
			"firstName" : value.firstName,
			"lastName" : value.lastName,
			"companyName" : value.companyName,
			"emailAddress" : value.emailAddress,
			"userOptions" : value.userOptions,
			"userRoles" : value.userRoles.map((x0) => x0).toList(),
			"minimumKrakenVersion" : value.minimumKrakenVersion,
			"cluster" : value.cluster
		};
		return entityAsMap;
	}

	static RegistrationInformation fromJSON(Map<String, dynamic> data) {
		return RegistrationInformation(
			emailAddress: (data["emailAddress"] as String),
			projectId: (data["projectId"] as String?),
			firstName: (data["firstName"] as String?),
			lastName: (data["lastName"] as String?),
			companyName: (data["companyName"] as String?),
			userOptions: (data["userOptions"] as String?),
			userRoles: (data["userRoles"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			minimumKrakenVersion: (data["minimumKrakenVersion"] as String?),
			cluster: (data["cluster"] as String?),
		);
	}
}