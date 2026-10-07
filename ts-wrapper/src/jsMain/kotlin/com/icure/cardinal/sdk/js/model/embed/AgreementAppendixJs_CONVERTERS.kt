// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.intToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.embed.AgreementAppendix
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun agreementAppendix_toJs(obj: AgreementAppendix): AgreementAppendixJs {
	val docSeq = nullToUndefined(
		intToNumber(obj.docSeq)
	)
	val verseSeq = nullToUndefined(
		intToNumber(obj.verseSeq)
	)
	val documentId = nullToUndefined(
		obj.documentId
	)
	val path = nullToUndefined(
		obj.path
	)
	return AgreementAppendixJs(js("{" +
		"docSeq:docSeq," +
		"verseSeq:verseSeq," +
		"documentId:documentId," +
		"path:path" +
	"}"))
}

public fun agreementAppendix_fromJs(obj: AgreementAppendixJs): AgreementAppendix {
	val docSeq = numberToInt(obj.docSeq, "obj.docSeq")
	val verseSeq = numberToInt(obj.verseSeq, "obj.verseSeq")
	val documentId = undefinedToNull(obj.documentId)
	val path = undefinedToNull(obj.path)
	return AgreementAppendix(
		docSeq = docSeq,
		verseSeq = verseSeq,
		documentId = documentId,
		path = path,
	)
}
