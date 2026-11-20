// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.Group
import com.icure.cardinal.sdk.model.UserGroup
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun userGroup_toJs(obj: UserGroup): UserGroupJs {
	val groupId = nullToUndefined(
		obj.groupId
	)
	val groupName = nullToUndefined(
		obj.groupName
	)
	val groupsHierarchy = listToArray(
		obj.groupsHierarchy,
		{ x1: Group ->
			group_toJs(x1)
		},
	)
	val userId = nullToUndefined(
		obj.userId
	)
	val login = nullToUndefined(
		obj.login
	)
	val name = nullToUndefined(
		obj.name
	)
	val email = nullToUndefined(
		obj.email
	)
	val phone = nullToUndefined(
		obj.phone
	)
	val patientId = nullToUndefined(
		obj.patientId
	)
	val healthcarePartyId = nullToUndefined(
		obj.healthcarePartyId
	)
	val deviceId = nullToUndefined(
		obj.deviceId
	)
	val nameOfParentOfTopmostGroupInHierarchy = nullToUndefined(
		obj.nameOfParentOfTopmostGroupInHierarchy
	)
	return UserGroupJs(js("{" +
		"groupId:groupId," +
		"groupName:groupName," +
		"groupsHierarchy:groupsHierarchy," +
		"userId:userId," +
		"login:login," +
		"name:name," +
		"email:email," +
		"phone:phone," +
		"patientId:patientId," +
		"healthcarePartyId:healthcarePartyId," +
		"deviceId:deviceId," +
		"nameOfParentOfTopmostGroupInHierarchy:nameOfParentOfTopmostGroupInHierarchy" +
	"}"))
}

public fun userGroup_fromJs(obj: UserGroupJs): UserGroup {
	val groupId = undefinedToNull(obj.groupId)
	val groupName = undefinedToNull(obj.groupName)
	val groupsHierarchy = arrayToList(
		obj.groupsHierarchy,
		"obj.groupsHierarchy",
		{ x1: GroupJs ->
			group_fromJs(x1)
		},
	)
	val userId = undefinedToNull(obj.userId)
	val login = undefinedToNull(obj.login)
	val name = undefinedToNull(obj.name)
	val email = undefinedToNull(obj.email)
	val phone = undefinedToNull(obj.phone)
	val patientId = undefinedToNull(obj.patientId)
	val healthcarePartyId = undefinedToNull(obj.healthcarePartyId)
	val deviceId = undefinedToNull(obj.deviceId)
	val nameOfParentOfTopmostGroupInHierarchy = undefinedToNull(obj.nameOfParentOfTopmostGroupInHierarchy)
	return UserGroup(
		groupId = groupId,
		groupName = groupName,
		groupsHierarchy = groupsHierarchy,
		userId = userId,
		login = login,
		name = name,
		email = email,
		phone = phone,
		patientId = patientId,
		healthcarePartyId = healthcarePartyId,
		deviceId = deviceId,
		nameOfParentOfTopmostGroupInHierarchy = nameOfParentOfTopmostGroupInHierarchy,
	)
}
