// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.codeStub_fromJs
import com.icure.cardinal.sdk.js.model.base.codeStub_toJs
import com.icure.cardinal.sdk.js.model.security.ExternalJwtConfigJs
import com.icure.cardinal.sdk.js.model.security.OperationTokenJs
import com.icure.cardinal.sdk.js.model.security.externalJwtConfig_fromJs
import com.icure.cardinal.sdk.js.model.security.externalJwtConfig_toJs
import com.icure.cardinal.sdk.js.model.security.operationToken_fromJs
import com.icure.cardinal.sdk.js.model.security.operationToken_toJs
import com.icure.cardinal.sdk.model.DecryptedPropertyStub
import com.icure.cardinal.sdk.model.Group
import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.embed.AuthenticationClass
import com.icure.cardinal.sdk.model.embed.UserType
import com.icure.cardinal.sdk.model.security.ExternalJwtConfig
import com.icure.cardinal.sdk.model.security.OperationToken
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Set

@Suppress("UNUSED_VARIABLE")
public fun group_toJs(obj: Group): GroupJs {
	val id = obj.id
	val rev = nullToUndefined(
		obj.rev
	)
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
	)
	val tags = setToArray(
		obj.tags,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val publicTags = setToArray(
		obj.publicTags,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val name = nullToUndefined(
		obj.name
	)
	val password = nullToUndefined(
		obj.password
	)
	val servers = nullToUndefined(
		listToArray(
			obj.servers,
			{ x1: String ->
				x1
			},
		)
	)
	val superAdmin = obj.superAdmin
	val properties = setToArray(
		obj.properties,
		{ x1: DecryptedPropertyStub ->
			propertyStub_toJs(x1)
		},
	)
	val defaultUserRoles = mapToObject(
		obj.defaultUserRoles,
		{ x1: UserType ->
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
	val operationTokens = mapToObject(
		obj.operationTokens,
		{ x1: String ->
			x1
		},
		{ x1: OperationToken ->
			operationToken_toJs(x1)
		},
	)
	val sharedEntities = mapToObject(
		obj.sharedEntities,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val minimumKrakenVersion = nullToUndefined(
		obj.minimumKrakenVersion
	)
	val externalJwtConfig = mapToObject(
		obj.externalJwtConfig,
		{ x1: String ->
			x1
		},
		{ x1: ExternalJwtConfig ->
			externalJwtConfig_toJs(x1)
		},
	)
	val minimumAuthenticationClassForElevatedPrivileges =
			obj.minimumAuthenticationClassForElevatedPrivileges.name
	val superGroup = nullToUndefined(
		obj.superGroup
	)
	val projectId = nullToUndefined(
		obj.projectId
	)
	return GroupJs(js("{" +
		"id:id," +
		"rev:rev," +
		"deletionDate:deletionDate," +
		"tags:tags," +
		"publicTags:publicTags," +
		"name:name," +
		"password:password," +
		"servers:servers," +
		"superAdmin:superAdmin," +
		"properties:properties," +
		"defaultUserRoles:defaultUserRoles," +
		"operationTokens:operationTokens," +
		"sharedEntities:sharedEntities," +
		"minimumKrakenVersion:minimumKrakenVersion," +
		"externalJwtConfig:externalJwtConfig," +
		"minimumAuthenticationClassForElevatedPrivileges:minimumAuthenticationClassForElevatedPrivileges," +
		"superGroup:superGroup," +
		"projectId:projectId" +
	"}"))
}

public fun group_fromJs(obj: GroupJs): Group {
	val id = obj.id
	val rev = undefinedToNull(obj.rev)
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val tags = arrayToSet(
		obj.tags,
		"obj.tags",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val publicTags = arrayToSet(
		obj.publicTags,
		"obj.publicTags",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val name = undefinedToNull(obj.name)
	val password = undefinedToNull(obj.password)
	val servers = arrayToList(
		obj.servers,
		"obj.servers",
		{ x1: String ->
			x1
		},
	)
	val superAdmin = obj.superAdmin
	val properties = arrayToSet(
		obj.properties,
		"obj.properties",
		{ x1: DecryptedPropertyStubJs ->
			propertyStub_fromJs(x1)
		},
	)
	val defaultUserRoles = objectToMap(
		obj.defaultUserRoles,
		"obj.defaultUserRoles",
		{ x1: String ->
			UserType.valueOf(x1)
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
	val operationTokens = objectToMap(
		obj.operationTokens,
		"obj.operationTokens",
		{ x1: String ->
			x1
		},
		{ x1: OperationTokenJs ->
			operationToken_fromJs(x1)
		},
	)
	val sharedEntities = objectToMap(
		obj.sharedEntities,
		"obj.sharedEntities",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val minimumKrakenVersion = undefinedToNull(obj.minimumKrakenVersion)
	val externalJwtConfig = objectToMap(
		obj.externalJwtConfig,
		"obj.externalJwtConfig",
		{ x1: String ->
			x1
		},
		{ x1: ExternalJwtConfigJs ->
			externalJwtConfig_fromJs(x1)
		},
	)
	val minimumAuthenticationClassForElevatedPrivileges =
			AuthenticationClass.valueOf(obj.minimumAuthenticationClassForElevatedPrivileges)
	val superGroup = undefinedToNull(obj.superGroup)
	val projectId = undefinedToNull(obj.projectId)
	return Group(
		id = id,
		rev = rev,
		deletionDate = deletionDate,
		tags = tags,
		publicTags = publicTags,
		name = name,
		password = password,
		servers = servers,
		superAdmin = superAdmin,
		properties = properties,
		defaultUserRoles = defaultUserRoles,
		operationTokens = operationTokens,
		sharedEntities = sharedEntities,
		minimumKrakenVersion = minimumKrakenVersion,
		externalJwtConfig = externalJwtConfig,
		minimumAuthenticationClassForElevatedPrivileges = minimumAuthenticationClassForElevatedPrivileges,
		superGroup = superGroup,
		projectId = projectId,
	)
}
