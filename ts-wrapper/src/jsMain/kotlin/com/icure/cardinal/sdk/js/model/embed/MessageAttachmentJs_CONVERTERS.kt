// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.model.embed.DocumentLocation
import com.icure.cardinal.sdk.model.embed.MessageAttachment
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun messageAttachment_toJs(obj: MessageAttachment): MessageAttachmentJs {
	val type = nullToUndefined(
		obj.type?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val ids = listToArray(
		obj.ids,
		{ x1: String ->
			x1
		},
	)
	return MessageAttachmentJs(js("{" +
		"type:type," +
		"ids:ids" +
	"}"))
}

public fun messageAttachment_fromJs(obj: MessageAttachmentJs): MessageAttachment {
	val type = obj.type?.let { nonNull1 ->
		DocumentLocation.valueOf(nonNull1)
	}
	val ids = arrayToList(
		obj.ids,
		"obj.ids",
		{ x1: String ->
			x1
		},
	)
	return MessageAttachment(
		type = type,
		ids = ids,
	)
}
