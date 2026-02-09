// auto-generated file
import 'package:cardinal_sdk/model/embed/authentication_class.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "external_jwt_config.freezed.dart";


@freezed
abstract class ExternalJwtConfig with _$ExternalJwtConfig {
	const factory ExternalJwtConfig({
		required ExternalJwtConfigValidationMethod validationMethod,
		required ExternalJwtConfigFieldSelector fieldSelector,
		@Default(AuthenticationClass.externalAuthentication) AuthenticationClass authenticationClass,
	}) = _ExternalJwtConfig;


	static Map<String, dynamic> encode(ExternalJwtConfig value) {
		Map<String, dynamic> entityAsMap = {
			"validationMethod" : ExternalJwtConfigValidationMethod.encode(value.validationMethod),
			"fieldSelector" : ExternalJwtConfigFieldSelector.encode(value.fieldSelector),
			"authenticationClass" : AuthenticationClass.encode(value.authenticationClass)
		};
		return entityAsMap;
	}

	static ExternalJwtConfig fromJSON(Map<String, dynamic> data) {
		return ExternalJwtConfig(
			validationMethod: ExternalJwtConfigValidationMethod.fromJSON(data["validationMethod"]),
			fieldSelector: ExternalJwtConfigFieldSelector.fromJSON(data["fieldSelector"]),
			authenticationClass: AuthenticationClass.fromJSON(data["authenticationClass"]),
		);
	}
}

sealed class ExternalJwtConfigValidationMethod {

	static Map<String, dynamic> encode(ExternalJwtConfigValidationMethod value) {
		switch (value) {
			case ExternalJwtConfigValidationMethodPublicKey entity:
				Map<String, dynamic> entityJson = ExternalJwtConfigValidationMethodPublicKey.encode(entity);
				entityJson["kotlinType"] = "PublicKey";
				return entityJson;
			case ExternalJwtConfigValidationMethodOidc entity:
				Map<String, dynamic> entityJson = ExternalJwtConfigValidationMethodOidc.encode(entity);
				entityJson["kotlinType"] = "Oidc";
				return entityJson;
		}
	}

	static ExternalJwtConfigValidationMethod fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "PublicKey":
				return ExternalJwtConfigValidationMethodPublicKey.fromJSON(data);
			case "Oidc":
				return ExternalJwtConfigValidationMethodOidc.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

@freezed
abstract class ExternalJwtConfigValidationMethodPublicKey with _$ExternalJwtConfigValidationMethodPublicKey implements ExternalJwtConfigValidationMethod {
	const factory ExternalJwtConfigValidationMethodPublicKey({
		required String key,
		@Default(null) String? signatureAlgorithm,
	}) = _ExternalJwtConfigValidationMethodPublicKey;


	static Map<String, dynamic> encode(ExternalJwtConfigValidationMethodPublicKey value) {
		Map<String, dynamic> entityAsMap = {
			"key" : value.key,
			"signatureAlgorithm" : value.signatureAlgorithm
		};
		return entityAsMap;
	}

	static ExternalJwtConfigValidationMethodPublicKey fromJSON(Map<String, dynamic> data) {
		return ExternalJwtConfigValidationMethodPublicKey(
			key: (data["key"] as String),
			signatureAlgorithm: (data["signatureAlgorithm"] as String?),
		);
	}
}

@freezed
abstract class ExternalJwtConfigValidationMethodOidc with _$ExternalJwtConfigValidationMethodOidc implements ExternalJwtConfigValidationMethod {
	const factory ExternalJwtConfigValidationMethodOidc({
		required String issureLocation,
	}) = _ExternalJwtConfigValidationMethodOidc;


	static Map<String, dynamic> encode(ExternalJwtConfigValidationMethodOidc value) {
		Map<String, dynamic> entityAsMap = {
			"issureLocation" : value.issureLocation
		};
		return entityAsMap;
	}

	static ExternalJwtConfigValidationMethodOidc fromJSON(Map<String, dynamic> data) {
		return ExternalJwtConfigValidationMethodOidc(
			issureLocation: (data["issureLocation"] as String)
		);
	}
}

sealed class ExternalJwtConfigFieldSelector {

	static Map<String, dynamic> encode(ExternalJwtConfigFieldSelector value) {
		switch (value) {
			case ExternalJwtConfigFieldSelectorLocalId entity:
				Map<String, dynamic> entityJson = ExternalJwtConfigFieldSelectorLocalId.encode(entity);
				entityJson["kotlinType"] = "LocalId";
				return entityJson;
			case ExternalJwtConfigFieldSelectorEmail entity:
				Map<String, dynamic> entityJson = ExternalJwtConfigFieldSelectorEmail.encode(entity);
				entityJson["kotlinType"] = "Email";
				return entityJson;
			case ExternalJwtConfigFieldSelectorMobilePhone entity:
				Map<String, dynamic> entityJson = ExternalJwtConfigFieldSelectorMobilePhone.encode(entity);
				entityJson["kotlinType"] = "MobilePhone";
				return entityJson;
			case ExternalJwtConfigFieldSelectorUsername entity:
				Map<String, dynamic> entityJson = ExternalJwtConfigFieldSelectorUsername.encode(entity);
				entityJson["kotlinType"] = "Username";
				return entityJson;
			case ExternalJwtConfigFieldSelectorIdentifier entity:
				Map<String, dynamic> entityJson = ExternalJwtConfigFieldSelectorIdentifier.encode(entity);
				entityJson["kotlinType"] = "Identifier";
				return entityJson;
		}
	}

	static ExternalJwtConfigFieldSelector fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "LocalId":
				return ExternalJwtConfigFieldSelectorLocalId.fromJSON(data);
			case "Email":
				return ExternalJwtConfigFieldSelectorEmail.fromJSON(data);
			case "MobilePhone":
				return ExternalJwtConfigFieldSelectorMobilePhone.fromJSON(data);
			case "Username":
				return ExternalJwtConfigFieldSelectorUsername.fromJSON(data);
			case "Identifier":
				return ExternalJwtConfigFieldSelectorIdentifier.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

@freezed
abstract class ExternalJwtConfigFieldSelectorLocalId with _$ExternalJwtConfigFieldSelectorLocalId implements ExternalJwtConfigFieldSelector {
	const factory ExternalJwtConfigFieldSelectorLocalId({
		required String fieldName,
	}) = _ExternalJwtConfigFieldSelectorLocalId;


	static Map<String, dynamic> encode(ExternalJwtConfigFieldSelectorLocalId value) {
		Map<String, dynamic> entityAsMap = {
			"fieldName" : value.fieldName
		};
		return entityAsMap;
	}

	static ExternalJwtConfigFieldSelectorLocalId fromJSON(Map<String, dynamic> data) {
		return ExternalJwtConfigFieldSelectorLocalId(
			fieldName: (data["fieldName"] as String)
		);
	}
}

@freezed
abstract class ExternalJwtConfigFieldSelectorEmail with _$ExternalJwtConfigFieldSelectorEmail implements ExternalJwtConfigFieldSelector {
	const factory ExternalJwtConfigFieldSelectorEmail({
		required String fieldName,
	}) = _ExternalJwtConfigFieldSelectorEmail;


	static Map<String, dynamic> encode(ExternalJwtConfigFieldSelectorEmail value) {
		Map<String, dynamic> entityAsMap = {
			"fieldName" : value.fieldName
		};
		return entityAsMap;
	}

	static ExternalJwtConfigFieldSelectorEmail fromJSON(Map<String, dynamic> data) {
		return ExternalJwtConfigFieldSelectorEmail(
			fieldName: (data["fieldName"] as String)
		);
	}
}

@freezed
abstract class ExternalJwtConfigFieldSelectorMobilePhone with _$ExternalJwtConfigFieldSelectorMobilePhone implements ExternalJwtConfigFieldSelector {
	const factory ExternalJwtConfigFieldSelectorMobilePhone({
		required String fieldName,
	}) = _ExternalJwtConfigFieldSelectorMobilePhone;


	static Map<String, dynamic> encode(ExternalJwtConfigFieldSelectorMobilePhone value) {
		Map<String, dynamic> entityAsMap = {
			"fieldName" : value.fieldName
		};
		return entityAsMap;
	}

	static ExternalJwtConfigFieldSelectorMobilePhone fromJSON(Map<String, dynamic> data) {
		return ExternalJwtConfigFieldSelectorMobilePhone(
			fieldName: (data["fieldName"] as String)
		);
	}
}

@freezed
abstract class ExternalJwtConfigFieldSelectorUsername with _$ExternalJwtConfigFieldSelectorUsername implements ExternalJwtConfigFieldSelector {
	const factory ExternalJwtConfigFieldSelectorUsername({
		required String fieldName,
	}) = _ExternalJwtConfigFieldSelectorUsername;


	static Map<String, dynamic> encode(ExternalJwtConfigFieldSelectorUsername value) {
		Map<String, dynamic> entityAsMap = {
			"fieldName" : value.fieldName
		};
		return entityAsMap;
	}

	static ExternalJwtConfigFieldSelectorUsername fromJSON(Map<String, dynamic> data) {
		return ExternalJwtConfigFieldSelectorUsername(
			fieldName: (data["fieldName"] as String)
		);
	}
}

@freezed
abstract class ExternalJwtConfigFieldSelectorIdentifier with _$ExternalJwtConfigFieldSelectorIdentifier implements ExternalJwtConfigFieldSelector {
	const factory ExternalJwtConfigFieldSelectorIdentifier({
		required String identifierAssigner,
		required String fieldName,
	}) = _ExternalJwtConfigFieldSelectorIdentifier;


	static Map<String, dynamic> encode(ExternalJwtConfigFieldSelectorIdentifier value) {
		Map<String, dynamic> entityAsMap = {
			"identifierAssigner" : value.identifierAssigner,
			"fieldName" : value.fieldName
		};
		return entityAsMap;
	}

	static ExternalJwtConfigFieldSelectorIdentifier fromJSON(Map<String, dynamic> data) {
		return ExternalJwtConfigFieldSelectorIdentifier(
			identifierAssigner: (data["identifierAssigner"] as String),
			fieldName: (data["fieldName"] as String)
		);
	}
}