// auto-generated file
package com.icure.cardinal.sdk.js.model.base

import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.base.CodeStub
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun codeStub_toJs(obj: CodeStub): CodeStubJs {
	val id = nullToUndefined(
		obj.id
	)
	val context = nullToUndefined(
		obj.context
	)
	val type = nullToUndefined(
		obj.type
	)
	val code = nullToUndefined(
		obj.code
	)
	val version = nullToUndefined(
		obj.version
	)
	val contextLabel = nullToUndefined(
		obj.contextLabel
	)
	return CodeStubJs(js("{" +
		"id:id," +
		"context:context," +
		"type:type," +
		"code:code," +
		"version:version," +
		"contextLabel:contextLabel" +
	"}"))
}

public fun codeStub_fromJs(obj: CodeStubJs): CodeStub {
	val id = undefinedToNull(obj.id)
	val context = undefinedToNull(obj.context)
	val type = undefinedToNull(obj.type)
	val code = undefinedToNull(obj.code)
	val version = undefinedToNull(obj.version)
	val contextLabel = undefinedToNull(obj.contextLabel)
	return CodeStub(
		id = id,
		context = context,
		type = type,
		code = code,
		version = version,
		contextLabel = contextLabel,
	)
}
