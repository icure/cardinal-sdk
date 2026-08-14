// auto-generated file
@file:JsQualifier("crypto.SecretIdUseOption")

package com.icure.cardinal.sdk.js.crypto.entities

import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("UseAnySharedWithHierarchy")
public external object SecretIdUseOptionJs_UseAnySharedWithHierarchyJs : SecretIdUseOptionJs {
	override val ktClass: String
}

@JsName("UseAllSharedWithHierarchy")
public external object SecretIdUseOptionJs_UseAllSharedWithHierarchyJs : SecretIdUseOptionJs {
	override val ktClass: String
}

@JsName("Use")
public external class SecretIdUseOptionJs_UseJs(
	partial: dynamic,
) : SecretIdUseOptionJs {
	public val secretIds: Array<String>

	override val ktClass: String
}

@JsName("UseNone")
public external object SecretIdUseOptionJs_UseNoneJs : SecretIdUseOptionJs {
	override val ktClass: String
}
