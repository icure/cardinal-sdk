// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.CheckedConverters.dynamicToJsonObjectNullsafe
import com.icure.cardinal.sdk.js.model.CheckedConverters.intToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.jsonToDynamic
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.embed.address_fromJs
import com.icure.cardinal.sdk.js.model.embed.address_toJs
import com.icure.cardinal.sdk.model.Place
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun place_toJs(obj: Place): PlaceJs {
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
	val address = nullToUndefined(
		obj.address?.let { nonNull1 ->
			address_toJs(nonNull1)
		}
	)
	val extensions = nullToUndefined(
		jsonToDynamic(obj.extensions)
	)
	val extensionsVersion = nullToUndefined(
		intToNumber(obj.extensionsVersion)
	)
	return PlaceJs(js("{" +
		"id:id," +
		"rev:rev," +
		"deletionDate:deletionDate," +
		"name:name," +
		"address:address," +
		"extensions:extensions," +
		"extensionsVersion:extensionsVersion" +
	"}"))
}

public fun place_fromJs(obj: PlaceJs): Place {
	val id = obj.id
	val rev = undefinedToNull(obj.rev)
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val name = undefinedToNull(obj.name)
	val address = obj.address?.let { nonNull1 ->
		address_fromJs(nonNull1)
	}
	val extensions = dynamicToJsonObjectNullsafe(obj.extensions, "obj.extensions")
	val extensionsVersion = numberToInt(obj.extensionsVersion, "obj.extensionsVersion")
	return Place(
		id = id,
		rev = rev,
		deletionDate = deletionDate,
		name = name,
		address = address,
		extensions = extensions,
		extensionsVersion = extensionsVersion,
	)
}
