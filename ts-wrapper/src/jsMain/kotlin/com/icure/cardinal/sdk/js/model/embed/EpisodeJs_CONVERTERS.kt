// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.dynamicToJsonObjectNullsafe
import com.icure.cardinal.sdk.js.model.CheckedConverters.jsonToDynamic
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.specializations.base64String_fromJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_toJs
import com.icure.cardinal.sdk.model.embed.DecryptedEpisode
import com.icure.cardinal.sdk.model.embed.EncryptedEpisode
import com.icure.cardinal.sdk.model.embed.Episode
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun episode_toJs(obj: DecryptedEpisode): DecryptedEpisodeJs {
	val id = obj.id
	val name = nullToUndefined(
		obj.name
	)
	val comment = nullToUndefined(
		obj.comment
	)
	val startDate = nullToUndefined(
		longToNumber(obj.startDate)
	)
	val endDate = nullToUndefined(
		longToNumber(obj.endDate)
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	val extensions = nullToUndefined(
		jsonToDynamic(obj.extensions)
	)
	return DecryptedEpisodeJs(js("{" +
		"id:id," +
		"name:name," +
		"comment:comment," +
		"startDate:startDate," +
		"endDate:endDate," +
		"encryptedSelf:encryptedSelf," +
		"extensions:extensions" +
	"}"))
}

public fun episode_fromJs(obj: DecryptedEpisodeJs): DecryptedEpisode {
	val id = obj.id
	val name = undefinedToNull(obj.name)
	val comment = undefinedToNull(obj.comment)
	val startDate = numberToLong(obj.startDate, "obj.startDate")
	val endDate = numberToLong(obj.endDate, "obj.endDate")
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	val extensions = dynamicToJsonObjectNullsafe(obj.extensions, "obj.extensions")
	return DecryptedEpisode(
		id = id,
		name = name,
		comment = comment,
		startDate = startDate,
		endDate = endDate,
		encryptedSelf = encryptedSelf,
		extensions = extensions,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun episode_toJs(obj: EncryptedEpisode): EncryptedEpisodeJs {
	val id = obj.id
	val name = nullToUndefined(
		obj.name
	)
	val comment = nullToUndefined(
		obj.comment
	)
	val startDate = nullToUndefined(
		longToNumber(obj.startDate)
	)
	val endDate = nullToUndefined(
		longToNumber(obj.endDate)
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	val extensions = nullToUndefined(
		jsonToDynamic(obj.extensions)
	)
	return EncryptedEpisodeJs(js("{" +
		"id:id," +
		"name:name," +
		"comment:comment," +
		"startDate:startDate," +
		"endDate:endDate," +
		"encryptedSelf:encryptedSelf," +
		"extensions:extensions" +
	"}"))
}

public fun episode_fromJs(obj: EncryptedEpisodeJs): EncryptedEpisode {
	val id = obj.id
	val name = undefinedToNull(obj.name)
	val comment = undefinedToNull(obj.comment)
	val startDate = numberToLong(obj.startDate, "obj.startDate")
	val endDate = numberToLong(obj.endDate, "obj.endDate")
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	val extensions = dynamicToJsonObjectNullsafe(obj.extensions, "obj.extensions")
	return EncryptedEpisode(
		id = id,
		name = name,
		comment = comment,
		startDate = startDate,
		endDate = endDate,
		encryptedSelf = encryptedSelf,
		extensions = extensions,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun episode_toJs(obj: Episode): EpisodeJs = when (obj) {
	is EncryptedEpisode -> episode_toJs(obj)
	is DecryptedEpisode -> episode_toJs(obj)
}

public fun episode_fromJs(obj: EpisodeJs): Episode = if (obj.isEncrypted) {
	episode_fromJs(obj as EncryptedEpisodeJs)
} else {
	episode_fromJs(obj as DecryptedEpisodeJs)
}
