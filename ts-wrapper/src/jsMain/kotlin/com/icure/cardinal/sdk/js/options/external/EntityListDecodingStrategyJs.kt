@file:JsQualifier("options.EntityListDecodingStrategy")
package com.icure.cardinal.sdk.js.options.external

@JsName("DiscardMalformed")
external interface EntityListDecodingStrategyDiscardMalformedJs : EntityListDecodingStrategyJs {
	val handler: (entity: MalformedEntityJs) -> Unit
}
