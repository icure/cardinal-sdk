// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.Code
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Set

@Suppress("UNUSED_VARIABLE")
public fun code_toJs(obj: Code): CodeJs {
	val id = obj.id
	val rev = nullToUndefined(
		obj.rev
	)
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
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
	val label = mapToObject(
		obj.label,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val author = nullToUndefined(
		obj.author
	)
	val regions = setToArray(
		obj.regions,
		{ x1: String ->
			x1
		},
	)
	val links = setToArray(
		obj.links,
		{ x1: String ->
			x1
		},
	)
	val qualifiedLinks = mapToObject(
		obj.qualifiedLinks,
		{ x1: String ->
			x1
		},
		{ x1: List<String> ->
			listToArray(
				x1,
				{ x2: String ->
					x2
				},
			)
		},
	)
	val searchTerms = mapToObject(
		obj.searchTerms,
		{ x1: String ->
			x1
		},
		{ x1: Set<String> ->
			setToArray(
				x1,
				{ x2: String ->
					x2
				},
			)
		},
	)
	val disabled = obj.disabled
	return CodeJs(js("{" +
		"id:id," +
		"rev:rev," +
		"deletionDate:deletionDate," +
		"context:context," +
		"type:type," +
		"code:code," +
		"version:version," +
		"label:label," +
		"author:author," +
		"regions:regions," +
		"links:links," +
		"qualifiedLinks:qualifiedLinks," +
		"searchTerms:searchTerms," +
		"disabled:disabled" +
	"}"))
}

public fun code_fromJs(obj: CodeJs): Code {
	val id = obj.id
	val rev = undefinedToNull(obj.rev)
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val context = undefinedToNull(obj.context)
	val type = undefinedToNull(obj.type)
	val code = undefinedToNull(obj.code)
	val version = undefinedToNull(obj.version)
	val label = objectToMap(
		obj.label,
		"obj.label",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val author = undefinedToNull(obj.author)
	val regions = arrayToSet(
		obj.regions,
		"obj.regions",
		{ x1: String ->
			x1
		},
	)
	val links = arrayToSet(
		obj.links,
		"obj.links",
		{ x1: String ->
			x1
		},
	)
	val qualifiedLinks = objectToMap(
		obj.qualifiedLinks,
		"obj.qualifiedLinks",
		{ x1: String ->
			x1
		},
		{ x1: Array<String> ->
			arrayToList(
				x1,
				"x1",
				{ x2: String ->
					x2
				},
			)
		},
	)
	val searchTerms = objectToMap(
		obj.searchTerms,
		"obj.searchTerms",
		{ x1: String ->
			x1
		},
		{ x1: Array<String> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: String ->
					x2
				},
			)
		},
	)
	val disabled = obj.disabled
	return Code(
		id = id,
		rev = rev,
		deletionDate = deletionDate,
		context = context,
		type = type,
		code = code,
		version = version,
		label = label,
		author = author,
		regions = regions,
		links = links,
		qualifiedLinks = qualifiedLinks,
		searchTerms = searchTerms,
		disabled = disabled,
	)
}
