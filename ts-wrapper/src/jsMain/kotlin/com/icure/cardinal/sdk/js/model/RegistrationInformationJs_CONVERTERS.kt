// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.RegistrationInformation
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun registrationInformation_toJs(obj: RegistrationInformation): RegistrationInformationJs {
	val projectId = nullToUndefined(
		obj.projectId
	)
	val firstName = nullToUndefined(
		obj.firstName
	)
	val lastName = nullToUndefined(
		obj.lastName
	)
	val companyName = nullToUndefined(
		obj.companyName
	)
	val emailAddress = obj.emailAddress
	val userOptions = nullToUndefined(
		obj.userOptions
	)
	val userRoles = setToArray(
		obj.userRoles,
		{ x1: String ->
			x1
		},
	)
	val minimumKrakenVersion = nullToUndefined(
		obj.minimumKrakenVersion
	)
	val cluster = nullToUndefined(
		obj.cluster
	)
	return RegistrationInformationJs(js("{" +
		"projectId:projectId," +
		"firstName:firstName," +
		"lastName:lastName," +
		"companyName:companyName," +
		"emailAddress:emailAddress," +
		"userOptions:userOptions," +
		"userRoles:userRoles," +
		"minimumKrakenVersion:minimumKrakenVersion," +
		"cluster:cluster" +
	"}"))
}

public fun registrationInformation_fromJs(obj: RegistrationInformationJs): RegistrationInformation {
	val projectId = undefinedToNull(obj.projectId)
	val firstName = undefinedToNull(obj.firstName)
	val lastName = undefinedToNull(obj.lastName)
	val companyName = undefinedToNull(obj.companyName)
	val emailAddress = obj.emailAddress
	val userOptions = undefinedToNull(obj.userOptions)
	val userRoles = arrayToSet(
		obj.userRoles,
		"obj.userRoles",
		{ x1: String ->
			x1
		},
	)
	val minimumKrakenVersion = undefinedToNull(obj.minimumKrakenVersion)
	val cluster = undefinedToNull(obj.cluster)
	return RegistrationInformation(
		projectId = projectId,
		firstName = firstName,
		lastName = lastName,
		companyName = companyName,
		emailAddress = emailAddress,
		userOptions = userOptions,
		userRoles = userRoles,
		minimumKrakenVersion = minimumKrakenVersion,
		cluster = cluster,
	)
}
