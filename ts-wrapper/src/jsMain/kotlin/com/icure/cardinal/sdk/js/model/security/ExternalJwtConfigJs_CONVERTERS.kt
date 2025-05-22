// auto-generated file
package com.icure.cardinal.sdk.js.model.security

import com.icure.cardinal.sdk.model.embed.AuthenticationClass
import com.icure.cardinal.sdk.model.security.ExternalJwtConfig
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun externalJwtConfig_toJs(obj: ExternalJwtConfig): ExternalJwtConfigJs {
	val validationMethod = externalJwtConfig_ValidationMethod_toJs(obj.validationMethod)
	val fieldSelector = externalJwtConfig_FieldSelector_toJs(obj.fieldSelector)
	val authenticationClass = obj.authenticationClass.name
	return ExternalJwtConfigJs(js("{" +
		"validationMethod:validationMethod," +
		"fieldSelector:fieldSelector," +
		"authenticationClass:authenticationClass" +
	"}"))
}

public fun externalJwtConfig_fromJs(obj: ExternalJwtConfigJs): ExternalJwtConfig {
	val validationMethod = externalJwtConfig_ValidationMethod_fromJs(obj.validationMethod)
	val fieldSelector = externalJwtConfig_FieldSelector_fromJs(obj.fieldSelector)
	val authenticationClass = AuthenticationClass.valueOf(obj.authenticationClass)
	return ExternalJwtConfig(
		validationMethod = validationMethod,
		fieldSelector = fieldSelector,
		authenticationClass = authenticationClass,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun externalJwtConfig_ValidationMethod_toJs(obj: ExternalJwtConfig.ValidationMethod):
		ExternalJwtConfigJs_ValidationMethodJs = when (obj) {
	is ExternalJwtConfig.ValidationMethod.PublicKey ->
			externalJwtConfig_ValidationMethod_PublicKey_toJs(obj)
	is ExternalJwtConfig.ValidationMethod.Oidc -> externalJwtConfig_ValidationMethod_Oidc_toJs(obj)
}

public fun externalJwtConfig_ValidationMethod_fromJs(obj: ExternalJwtConfigJs_ValidationMethodJs):
		ExternalJwtConfig.ValidationMethod = when {
	obj is ExternalJwtConfigJs_ValidationMethodJs_PublicKeyJs || obj.ktClass ==
			"com.icure.cardinal.sdk.model.security.ExternalJwtConfig.ValidationMethod.PublicKey" ->externalJwtConfig_ValidationMethod_PublicKey_fromJs(obj
			as com.icure.cardinal.sdk.js.model.security.ExternalJwtConfigJs_ValidationMethodJs_PublicKeyJs)
	obj is ExternalJwtConfigJs_ValidationMethodJs_OidcJs || obj.ktClass ==
			"com.icure.cardinal.sdk.model.security.ExternalJwtConfig.ValidationMethod.Oidc" ->externalJwtConfig_ValidationMethod_Oidc_fromJs(obj
			as com.icure.cardinal.sdk.js.model.security.ExternalJwtConfigJs_ValidationMethodJs_OidcJs)
	else -> throw
			IllegalArgumentException("""Unknown concrete implementation for com.icure.cardinal.sdk.model.security.ExternalJwtConfig.ValidationMethod: $obj""")
}

@Suppress("UNUSED_VARIABLE")
public fun externalJwtConfig_FieldSelector_toJs(obj: ExternalJwtConfig.FieldSelector):
		ExternalJwtConfigJs_FieldSelectorJs = when (obj) {
	is ExternalJwtConfig.FieldSelector.LocalId -> externalJwtConfig_FieldSelector_LocalId_toJs(obj)
	is ExternalJwtConfig.FieldSelector.Email -> externalJwtConfig_FieldSelector_Email_toJs(obj)
	is ExternalJwtConfig.FieldSelector.MobilePhone ->
			externalJwtConfig_FieldSelector_MobilePhone_toJs(obj)
	is ExternalJwtConfig.FieldSelector.Username -> externalJwtConfig_FieldSelector_Username_toJs(obj)
	is ExternalJwtConfig.FieldSelector.Identifier ->
			externalJwtConfig_FieldSelector_Identifier_toJs(obj)
}

public fun externalJwtConfig_FieldSelector_fromJs(obj: ExternalJwtConfigJs_FieldSelectorJs):
		ExternalJwtConfig.FieldSelector = when {
	obj is ExternalJwtConfigJs_FieldSelectorJs_LocalIdJs || obj.ktClass ==
			"com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.LocalId" ->externalJwtConfig_FieldSelector_LocalId_fromJs(obj
			as com.icure.cardinal.sdk.js.model.security.ExternalJwtConfigJs_FieldSelectorJs_LocalIdJs)
	obj is ExternalJwtConfigJs_FieldSelectorJs_EmailJs || obj.ktClass ==
			"com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Email" ->externalJwtConfig_FieldSelector_Email_fromJs(obj
			as com.icure.cardinal.sdk.js.model.security.ExternalJwtConfigJs_FieldSelectorJs_EmailJs)
	obj is ExternalJwtConfigJs_FieldSelectorJs_MobilePhoneJs || obj.ktClass ==
			"com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.MobilePhone" ->externalJwtConfig_FieldSelector_MobilePhone_fromJs(obj
			as com.icure.cardinal.sdk.js.model.security.ExternalJwtConfigJs_FieldSelectorJs_MobilePhoneJs)
	obj is ExternalJwtConfigJs_FieldSelectorJs_UsernameJs || obj.ktClass ==
			"com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Username" ->externalJwtConfig_FieldSelector_Username_fromJs(obj
			as com.icure.cardinal.sdk.js.model.security.ExternalJwtConfigJs_FieldSelectorJs_UsernameJs)
	obj is ExternalJwtConfigJs_FieldSelectorJs_IdentifierJs || obj.ktClass ==
			"com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Identifier" ->externalJwtConfig_FieldSelector_Identifier_fromJs(obj
			as com.icure.cardinal.sdk.js.model.security.ExternalJwtConfigJs_FieldSelectorJs_IdentifierJs)
	else -> throw
			IllegalArgumentException("""Unknown concrete implementation for com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector: $obj""")
}

@Suppress("UNUSED_VARIABLE")
public
		fun externalJwtConfig_ValidationMethod_PublicKey_toJs(obj: ExternalJwtConfig.ValidationMethod.PublicKey):
		ExternalJwtConfigJs_ValidationMethodJs_PublicKeyJs {
	val key = obj.key
	return ExternalJwtConfigJs_ValidationMethodJs_PublicKeyJs(js("{" +
		"key:key" +
	"}"))
}

public
		fun externalJwtConfig_ValidationMethod_PublicKey_fromJs(obj: ExternalJwtConfigJs_ValidationMethodJs_PublicKeyJs):
		ExternalJwtConfig.ValidationMethod.PublicKey {
	val key = obj.key
	return ExternalJwtConfig.ValidationMethod.PublicKey(
		key = key,
	)
}

@Suppress("UNUSED_VARIABLE")
public
		fun externalJwtConfig_ValidationMethod_Oidc_toJs(obj: ExternalJwtConfig.ValidationMethod.Oidc):
		ExternalJwtConfigJs_ValidationMethodJs_OidcJs {
	val issureLocation = obj.issureLocation
	return ExternalJwtConfigJs_ValidationMethodJs_OidcJs(js("{" +
		"issureLocation:issureLocation" +
	"}"))
}

public
		fun externalJwtConfig_ValidationMethod_Oidc_fromJs(obj: ExternalJwtConfigJs_ValidationMethodJs_OidcJs):
		ExternalJwtConfig.ValidationMethod.Oidc {
	val issureLocation = obj.issureLocation
	return ExternalJwtConfig.ValidationMethod.Oidc(
		issureLocation = issureLocation,
	)
}

@Suppress("UNUSED_VARIABLE")
public
		fun externalJwtConfig_FieldSelector_LocalId_toJs(obj: ExternalJwtConfig.FieldSelector.LocalId):
		ExternalJwtConfigJs_FieldSelectorJs_LocalIdJs {
	val fieldName = obj.fieldName
	return ExternalJwtConfigJs_FieldSelectorJs_LocalIdJs(js("{" +
		"fieldName:fieldName" +
	"}"))
}

public
		fun externalJwtConfig_FieldSelector_LocalId_fromJs(obj: ExternalJwtConfigJs_FieldSelectorJs_LocalIdJs):
		ExternalJwtConfig.FieldSelector.LocalId {
	val fieldName = obj.fieldName
	return ExternalJwtConfig.FieldSelector.LocalId(
		fieldName = fieldName,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun externalJwtConfig_FieldSelector_Email_toJs(obj: ExternalJwtConfig.FieldSelector.Email):
		ExternalJwtConfigJs_FieldSelectorJs_EmailJs {
	val fieldName = obj.fieldName
	return ExternalJwtConfigJs_FieldSelectorJs_EmailJs(js("{" +
		"fieldName:fieldName" +
	"}"))
}

public
		fun externalJwtConfig_FieldSelector_Email_fromJs(obj: ExternalJwtConfigJs_FieldSelectorJs_EmailJs):
		ExternalJwtConfig.FieldSelector.Email {
	val fieldName = obj.fieldName
	return ExternalJwtConfig.FieldSelector.Email(
		fieldName = fieldName,
	)
}

@Suppress("UNUSED_VARIABLE")
public
		fun externalJwtConfig_FieldSelector_MobilePhone_toJs(obj: ExternalJwtConfig.FieldSelector.MobilePhone):
		ExternalJwtConfigJs_FieldSelectorJs_MobilePhoneJs {
	val fieldName = obj.fieldName
	return ExternalJwtConfigJs_FieldSelectorJs_MobilePhoneJs(js("{" +
		"fieldName:fieldName" +
	"}"))
}

public
		fun externalJwtConfig_FieldSelector_MobilePhone_fromJs(obj: ExternalJwtConfigJs_FieldSelectorJs_MobilePhoneJs):
		ExternalJwtConfig.FieldSelector.MobilePhone {
	val fieldName = obj.fieldName
	return ExternalJwtConfig.FieldSelector.MobilePhone(
		fieldName = fieldName,
	)
}

@Suppress("UNUSED_VARIABLE")
public
		fun externalJwtConfig_FieldSelector_Username_toJs(obj: ExternalJwtConfig.FieldSelector.Username):
		ExternalJwtConfigJs_FieldSelectorJs_UsernameJs {
	val fieldName = obj.fieldName
	return ExternalJwtConfigJs_FieldSelectorJs_UsernameJs(js("{" +
		"fieldName:fieldName" +
	"}"))
}

public
		fun externalJwtConfig_FieldSelector_Username_fromJs(obj: ExternalJwtConfigJs_FieldSelectorJs_UsernameJs):
		ExternalJwtConfig.FieldSelector.Username {
	val fieldName = obj.fieldName
	return ExternalJwtConfig.FieldSelector.Username(
		fieldName = fieldName,
	)
}

@Suppress("UNUSED_VARIABLE")
public
		fun externalJwtConfig_FieldSelector_Identifier_toJs(obj: ExternalJwtConfig.FieldSelector.Identifier):
		ExternalJwtConfigJs_FieldSelectorJs_IdentifierJs {
	val identifierAssigner = obj.identifierAssigner
	val fieldName = obj.fieldName
	return ExternalJwtConfigJs_FieldSelectorJs_IdentifierJs(js("{" +
		"identifierAssigner:identifierAssigner," +
		"fieldName:fieldName" +
	"}"))
}

public
		fun externalJwtConfig_FieldSelector_Identifier_fromJs(obj: ExternalJwtConfigJs_FieldSelectorJs_IdentifierJs):
		ExternalJwtConfig.FieldSelector.Identifier {
	val identifierAssigner = obj.identifierAssigner
	val fieldName = obj.fieldName
	return ExternalJwtConfig.FieldSelector.Identifier(
		identifierAssigner = identifierAssigner,
		fieldName = fieldName,
	)
}
