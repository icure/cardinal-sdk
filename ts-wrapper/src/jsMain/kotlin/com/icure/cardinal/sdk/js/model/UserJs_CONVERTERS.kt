// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.instantToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInstant
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.base.IdentifierJs
import com.icure.cardinal.sdk.js.model.base.identifier_fromJs
import com.icure.cardinal.sdk.js.model.base.identifier_toJs
import com.icure.cardinal.sdk.js.model.security.AuthenticationTokenJs
import com.icure.cardinal.sdk.js.model.security.LoginIdentifierJs
import com.icure.cardinal.sdk.js.model.security.PermissionJs
import com.icure.cardinal.sdk.js.model.security.authenticationToken_fromJs
import com.icure.cardinal.sdk.js.model.security.authenticationToken_toJs
import com.icure.cardinal.sdk.js.model.security.loginIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.security.loginIdentifier_toJs
import com.icure.cardinal.sdk.js.model.security.permission_fromJs
import com.icure.cardinal.sdk.js.model.security.permission_toJs
import com.icure.cardinal.sdk.model.DecryptedPropertyStub
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.embed.DelegationTag
import com.icure.cardinal.sdk.model.enums.UsersStatus
import com.icure.cardinal.sdk.model.security.AuthenticationToken
import com.icure.cardinal.sdk.model.security.LoginIdentifier
import com.icure.cardinal.sdk.model.security.Permission
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Set

@Suppress("UNUSED_VARIABLE")
public fun user_toJs(obj: User): UserJs {
	val id = obj.id
	val rev = nullToUndefined(
		obj.rev
	)
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
	)
	val created = nullToUndefined(
		longToNumber(obj.created)
	)
	val identifier = listToArray(
		obj.identifier,
		{ x1: Identifier ->
			identifier_toJs(x1)
		},
	)
	val name = nullToUndefined(
		obj.name
	)
	val properties = setToArray(
		obj.properties,
		{ x1: DecryptedPropertyStub ->
			propertyStub_toJs(x1)
		},
	)
	val permissions = setToArray(
		obj.permissions,
		{ x1: Permission ->
			permission_toJs(x1)
		},
	)
	val roles = setToArray(
		obj.roles,
		{ x1: String ->
			x1
		},
	)
	val status = nullToUndefined(
		obj.status?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val login = nullToUndefined(
		obj.login
	)
	val passwordHash = nullToUndefined(
		obj.passwordHash
	)
	val groupId = nullToUndefined(
		obj.groupId
	)
	val healthcarePartyId = nullToUndefined(
		obj.healthcarePartyId
	)
	val patientId = nullToUndefined(
		obj.patientId
	)
	val deviceId = nullToUndefined(
		obj.deviceId
	)
	val autoDelegations = mapToObject(
		obj.autoDelegations,
		{ x1: DelegationTag ->
			x1.name
		},
		{ x1: Set<String> ->
			setToArray(
				x1,
				{ x2: String ->
					x2
				},
			)
		},
	)
	val termsOfUseDate = nullToUndefined(
		instantToNumber(obj.termsOfUseDate)
	)
	val email = nullToUndefined(
		obj.email
	)
	val mobilePhone = nullToUndefined(
		obj.mobilePhone
	)
	val authenticationTokens = mapToObject(
		obj.authenticationTokens,
		{ x1: String ->
			x1
		},
		{ x1: AuthenticationToken ->
			authenticationToken_toJs(x1)
		},
	)
	val systemMetadata = nullToUndefined(
		obj.systemMetadata?.let { nonNull1 ->
			user_SystemMetadata_toJs(nonNull1)
		}
	)
	return UserJs(js("{" +
		"id:id," +
		"rev:rev," +
		"deletionDate:deletionDate," +
		"created:created," +
		"identifier:identifier," +
		"name:name," +
		"properties:properties," +
		"permissions:permissions," +
		"roles:roles," +
		"status:status," +
		"login:login," +
		"passwordHash:passwordHash," +
		"groupId:groupId," +
		"healthcarePartyId:healthcarePartyId," +
		"patientId:patientId," +
		"deviceId:deviceId," +
		"autoDelegations:autoDelegations," +
		"termsOfUseDate:termsOfUseDate," +
		"email:email," +
		"mobilePhone:mobilePhone," +
		"authenticationTokens:authenticationTokens," +
		"systemMetadata:systemMetadata" +
	"}"))
}

public fun user_fromJs(obj: UserJs): User {
	val id = obj.id
	val rev = undefinedToNull(obj.rev)
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val created = numberToLong(obj.created, "obj.created")
	val identifier = arrayToList(
		obj.identifier,
		"obj.identifier",
		{ x1: IdentifierJs ->
			identifier_fromJs(x1)
		},
	)
	val name = undefinedToNull(obj.name)
	val properties = arrayToSet(
		obj.properties,
		"obj.properties",
		{ x1: DecryptedPropertyStubJs ->
			propertyStub_fromJs(x1)
		},
	)
	val permissions = arrayToSet(
		obj.permissions,
		"obj.permissions",
		{ x1: PermissionJs ->
			permission_fromJs(x1)
		},
	)
	val roles = arrayToSet(
		obj.roles,
		"obj.roles",
		{ x1: String ->
			x1
		},
	)
	val status = obj.status?.let { nonNull1 ->
		UsersStatus.valueOf(nonNull1)
	}
	val login = undefinedToNull(obj.login)
	val passwordHash = undefinedToNull(obj.passwordHash)
	val groupId = undefinedToNull(obj.groupId)
	val healthcarePartyId = undefinedToNull(obj.healthcarePartyId)
	val patientId = undefinedToNull(obj.patientId)
	val deviceId = undefinedToNull(obj.deviceId)
	val autoDelegations = objectToMap(
		obj.autoDelegations,
		"obj.autoDelegations",
		{ x1: String ->
			DelegationTag.valueOf(x1)
		},
		{ x1: Array<String> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: String ->
					x2
				},
			)
		},
	)
	val termsOfUseDate = numberToInstant(obj.termsOfUseDate, "obj.termsOfUseDate")
	val email = undefinedToNull(obj.email)
	val mobilePhone = undefinedToNull(obj.mobilePhone)
	val authenticationTokens = objectToMap(
		obj.authenticationTokens,
		"obj.authenticationTokens",
		{ x1: String ->
			x1
		},
		{ x1: AuthenticationTokenJs ->
			authenticationToken_fromJs(x1)
		},
	)
	val systemMetadata = obj.systemMetadata?.let { nonNull1 ->
		user_SystemMetadata_fromJs(nonNull1)
	}
	return User(
		id = id,
		rev = rev,
		deletionDate = deletionDate,
		created = created,
		identifier = identifier,
		name = name,
		properties = properties,
		permissions = permissions,
		roles = roles,
		status = status,
		login = login,
		passwordHash = passwordHash,
		groupId = groupId,
		healthcarePartyId = healthcarePartyId,
		patientId = patientId,
		deviceId = deviceId,
		autoDelegations = autoDelegations,
		termsOfUseDate = termsOfUseDate,
		email = email,
		mobilePhone = mobilePhone,
		authenticationTokens = authenticationTokens,
		systemMetadata = systemMetadata,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun user_SystemMetadata_toJs(obj: User.SystemMetadata): UserJs_SystemMetadataJs {
	val roles = setToArray(
		obj.roles,
		{ x1: String ->
			x1
		},
	)
	val isAdmin = obj.isAdmin
	val inheritsRoles = obj.inheritsRoles
	val loginIdentifiers = listToArray(
		obj.loginIdentifiers,
		{ x1: LoginIdentifier ->
			loginIdentifier_toJs(x1)
		},
	)
	return UserJs_SystemMetadataJs(js("{" +
		"roles:roles," +
		"isAdmin:isAdmin," +
		"inheritsRoles:inheritsRoles," +
		"loginIdentifiers:loginIdentifiers" +
	"}"))
}

public fun user_SystemMetadata_fromJs(obj: UserJs_SystemMetadataJs): User.SystemMetadata {
	val roles = arrayToSet(
		obj.roles,
		"obj.roles",
		{ x1: String ->
			x1
		},
	)
	val isAdmin = obj.isAdmin
	val inheritsRoles = obj.inheritsRoles
	val loginIdentifiers = arrayToList(
		obj.loginIdentifiers,
		"obj.loginIdentifiers",
		{ x1: LoginIdentifierJs ->
			loginIdentifier_fromJs(x1)
		},
	)
	return User.SystemMetadata(
		roles = roles,
		isAdmin = isAdmin,
		inheritsRoles = inheritsRoles,
		loginIdentifiers = loginIdentifiers,
	)
}
