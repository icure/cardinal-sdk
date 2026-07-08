// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
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
import com.icure.cardinal.sdk.js.model.specializations.base64String_fromJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_toJs
import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.embed.Annotation
import com.icure.cardinal.sdk.model.embed.DecryptedAnnotation
import com.icure.cardinal.sdk.model.embed.EncryptedAnnotation
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun annotation_toJs(obj: DecryptedAnnotation): DecryptedAnnotationJs {
	val id = obj.id
	val author = nullToUndefined(
		obj.author
	)
	val created = nullToUndefined(
		longToNumber(obj.created)
	)
	val modified = nullToUndefined(
		longToNumber(obj.modified)
	)
	val text = nullToUndefined(
		obj.text
	)
	val markdown = mapToObject(
		obj.markdown,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val location = nullToUndefined(
		obj.location
	)
	val confidential = nullToUndefined(
		obj.confidential
	)
	val tags = setToArray(
		obj.tags,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	return DecryptedAnnotationJs(js("{" +
		"id:id," +
		"author:author," +
		"created:created," +
		"modified:modified," +
		"text:text," +
		"markdown:markdown," +
		"location:location," +
		"confidential:confidential," +
		"tags:tags," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun annotation_fromJs(obj: DecryptedAnnotationJs): DecryptedAnnotation {
	val id = obj.id
	val author = undefinedToNull(obj.author)
	val created = numberToLong(obj.created, "obj.created")
	val modified = numberToLong(obj.modified, "obj.modified")
	val text = undefinedToNull(obj.text)
	val markdown = objectToMap(
		obj.markdown,
		"obj.markdown",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val location = undefinedToNull(obj.location)
	val confidential = undefinedToNull(obj.confidential)
	val tags = arrayToSet(
		obj.tags,
		"obj.tags",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return DecryptedAnnotation(
		id = id,
		author = author,
		created = created,
		modified = modified,
		text = text,
		markdown = markdown,
		location = location,
		confidential = confidential,
		tags = tags,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun annotation_toJs(obj: EncryptedAnnotation): EncryptedAnnotationJs {
	val id = obj.id
	val author = nullToUndefined(
		obj.author
	)
	val created = nullToUndefined(
		longToNumber(obj.created)
	)
	val modified = nullToUndefined(
		longToNumber(obj.modified)
	)
	val text = nullToUndefined(
		obj.text
	)
	val markdown = mapToObject(
		obj.markdown,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val location = nullToUndefined(
		obj.location
	)
	val confidential = nullToUndefined(
		obj.confidential
	)
	val tags = setToArray(
		obj.tags,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	return EncryptedAnnotationJs(js("{" +
		"id:id," +
		"author:author," +
		"created:created," +
		"modified:modified," +
		"text:text," +
		"markdown:markdown," +
		"location:location," +
		"confidential:confidential," +
		"tags:tags," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun annotation_fromJs(obj: EncryptedAnnotationJs): EncryptedAnnotation {
	val id = obj.id
	val author = undefinedToNull(obj.author)
	val created = numberToLong(obj.created, "obj.created")
	val modified = numberToLong(obj.modified, "obj.modified")
	val text = undefinedToNull(obj.text)
	val markdown = objectToMap(
		obj.markdown,
		"obj.markdown",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val location = undefinedToNull(obj.location)
	val confidential = undefinedToNull(obj.confidential)
	val tags = arrayToSet(
		obj.tags,
		"obj.tags",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return EncryptedAnnotation(
		id = id,
		author = author,
		created = created,
		modified = modified,
		text = text,
		markdown = markdown,
		location = location,
		confidential = confidential,
		tags = tags,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun annotation_toJs(obj: Annotation): AnnotationJs = when (obj) {
	is EncryptedAnnotation -> annotation_toJs(obj)
	is DecryptedAnnotation -> annotation_toJs(obj)
}

public fun annotation_fromJs(obj: AnnotationJs): Annotation = if (obj.isEncrypted) {
	annotation_fromJs(obj as EncryptedAnnotationJs)
} else {
	annotation_fromJs(obj as DecryptedAnnotationJs)
}
