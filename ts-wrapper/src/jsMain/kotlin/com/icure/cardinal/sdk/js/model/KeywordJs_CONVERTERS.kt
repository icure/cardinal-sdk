// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.codeStub_fromJs
import com.icure.cardinal.sdk.js.model.base.codeStub_toJs
import com.icure.cardinal.sdk.js.model.embed.KeywordSubwordJs
import com.icure.cardinal.sdk.js.model.embed.keywordSubword_fromJs
import com.icure.cardinal.sdk.js.model.embed.keywordSubword_toJs
import com.icure.cardinal.sdk.model.Keyword
import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.embed.KeywordSubword
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun keyword_toJs(obj: Keyword): KeywordJs {
	val id = obj.id
	val rev = nullToUndefined(
		obj.rev
	)
	val created = nullToUndefined(
		longToNumber(obj.created)
	)
	val modified = nullToUndefined(
		longToNumber(obj.modified)
	)
	val author = nullToUndefined(
		obj.author
	)
	val responsible = nullToUndefined(
		obj.responsible
	)
	val tags = setToArray(
		obj.tags,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val codes = setToArray(
		obj.codes,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val endOfLife = nullToUndefined(
		longToNumber(obj.endOfLife)
	)
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
	)
	val value = nullToUndefined(
		obj.value
	)
	val subWords = setToArray(
		obj.subWords,
		{ x1: KeywordSubword ->
			keywordSubword_toJs(x1)
		},
	)
	val userId = nullToUndefined(
		obj.userId
	)
	return KeywordJs(js("{" +
		"id:id," +
		"rev:rev," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"tags:tags," +
		"codes:codes," +
		"endOfLife:endOfLife," +
		"deletionDate:deletionDate," +
		"value:value," +
		"subWords:subWords," +
		"userId:userId" +
	"}"))
}

public fun keyword_fromJs(obj: KeywordJs): Keyword {
	val id = obj.id
	val rev = undefinedToNull(obj.rev)
	val created = numberToLong(obj.created, "obj.created")
	val modified = numberToLong(obj.modified, "obj.modified")
	val author = undefinedToNull(obj.author)
	val responsible = undefinedToNull(obj.responsible)
	val tags = arrayToSet(
		obj.tags,
		"obj.tags",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val codes = arrayToSet(
		obj.codes,
		"obj.codes",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val endOfLife = numberToLong(obj.endOfLife, "obj.endOfLife")
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val value = undefinedToNull(obj.value)
	val subWords = arrayToSet(
		obj.subWords,
		"obj.subWords",
		{ x1: KeywordSubwordJs ->
			keywordSubword_fromJs(x1)
		},
	)
	val userId = undefinedToNull(obj.userId)
	return Keyword(
		id = id,
		rev = rev,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		tags = tags,
		codes = codes,
		endOfLife = endOfLife,
		deletionDate = deletionDate,
		value = value,
		subWords = subWords,
		userId = userId,
	)
}
