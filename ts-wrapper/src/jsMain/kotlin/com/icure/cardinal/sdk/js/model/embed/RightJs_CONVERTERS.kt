// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.embed.Right
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun right_toJs(obj: Right): RightJs {
	val userId = nullToUndefined(
		obj.userId
	)
	val read = obj.read
	val write = obj.write
	val administration = obj.administration
	return RightJs(js("{" +
		"userId:userId," +
		"read:read," +
		"write:write," +
		"administration:administration" +
	"}"))
}

public fun right_fromJs(obj: RightJs): Right {
	val userId = undefinedToNull(obj.userId)
	val read = obj.read
	val write = obj.write
	val administration = obj.administration
	return Right(
		userId = userId,
		read = read,
		write = write,
		administration = administration,
	)
}
