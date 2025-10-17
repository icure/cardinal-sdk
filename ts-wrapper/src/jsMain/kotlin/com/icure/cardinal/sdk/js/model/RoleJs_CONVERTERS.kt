// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.intToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.Role
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun role_toJs(obj: Role): RoleJs {
	val id = obj.id
	val rev = nullToUndefined(
		obj.rev
	)
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
	)
	val name = nullToUndefined(
		obj.name
	)
	val inheritableUpTo = nullToUndefined(
		intToNumber(obj.inheritableUpTo)
	)
	val permissions = setToArray(
		obj.permissions,
		{ x1: String ->
			x1
		},
	)
	return RoleJs(js("{" +
		"id:id," +
		"rev:rev," +
		"deletionDate:deletionDate," +
		"name:name," +
		"inheritableUpTo:inheritableUpTo," +
		"permissions:permissions" +
	"}"))
}

public fun role_fromJs(obj: RoleJs): Role {
	val id = obj.id
	val rev = undefinedToNull(obj.rev)
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val name = undefinedToNull(obj.name)
	val inheritableUpTo = numberToInt(obj.inheritableUpTo, "obj.inheritableUpTo")
	val permissions = arrayToSet(
		obj.permissions,
		"obj.permissions",
		{ x1: String ->
			x1
		},
	)
	return Role(
		id = id,
		rev = rev,
		deletionDate = deletionDate,
		name = name,
		inheritableUpTo = inheritableUpTo,
		permissions = permissions,
	)
}
