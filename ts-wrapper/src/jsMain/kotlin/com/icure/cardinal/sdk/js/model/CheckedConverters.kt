package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataStub
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.cardinal.sdk.js.crypto.entities.EntityWithTypeInfoJs
import com.icure.cardinal.sdk.js.model.embed.DelegationJs
import com.icure.cardinal.sdk.js.model.embed.delegation_fromJs
import com.icure.cardinal.sdk.js.model.embed.securityMetadata_fromJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.utils.ensure
import com.icure.cardinal.sdk.utils.isJsSafe
import com.icure.cardinal.sdk.utils.time.ZonedDateTime
import com.icure.utils.InternalIcureApi
import kotlin.time.Instant
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromDynamic
import kotlinx.serialization.json.encodeToDynamic
import kotlin.math.floor
import kotlin.time.Duration.Companion.milliseconds

/**
 * Contains functions to convert from standard Kotlin to JavaScript types in a "checked" way.
 * If the conversion could cause loss of information, an exception is thrown.
 */
@OptIn(InternalIcureApi::class)
object CheckedConverters {
	private const val MAX_SAFE_INTEGER_D = 9007199254740991.0
	private const val MIN_SAFE_INTEGER_D = -9007199254740991.0
	private const val MIN_INT_32_D = Int.MIN_VALUE.toDouble()
	private const val MAX_INT_32_D = Int.MAX_VALUE.toDouble()

	fun numberToLong(number: Double, description: String): Long {
		require(
			!number.isNaN()
				&& number.isFinite()
				&& floor(number) == number
		) {
			"$description should be a 64bits integer - got $number"
		}
		require (number in MIN_SAFE_INTEGER_D..MAX_SAFE_INTEGER_D) {
			"$description is outside of the safe integer range for javascript numbers, conversion may cause loss of precision - got $number"
		}
		return number.toLong()
	}

	fun tryNumberToLong(number: Double): Long? {
		if (number.isNaN() || !number.isFinite() || floor(number) != number) {
			return null
		}
		if (number in MIN_SAFE_INTEGER_D..MAX_SAFE_INTEGER_D) {
			return number.toLong()
		}
		return null
	}

	fun numberToLong(number: Double?, description: String): Long? = number?.let { numberToLong(it, description) }

	fun longToNumber(long: Long): Double {
		ensure(long.isJsSafe()) {
			"Number is not in safe integer range: $long"
		}
		return long.toDouble()
	}

	fun longToNumber(long: Long?): Double? = long?.let { longToNumber(it) }

	fun numberToInt(number: Double, description: String): Int {
		require(
			!number.isNaN()
				&& number.isFinite()
				&& floor(number) == number
		) {
			"$description should be a 32bits integer - got $number"
		}
		require (number in MIN_INT_32_D..MAX_INT_32_D) {
			"$description is outside of the safe integer range for javascript numbers, conversion may cause loss of precision - got $number"
		}
		return number.toInt()
	}

	fun numberToInt(number: Double?, description: String): Int? = number?.let { numberToInt(it, description) }

	fun intToNumber(int: Int): Double {
		return int.toDouble()
	}

	fun intToNumber(int: Int?): Int? = int

	fun numberToInstant(number: Double, description: String): Instant {
		return Instant.fromEpochMilliseconds(numberToLong(number, description))
	}

	fun numberToInstant(number: Double?, description: String): Instant? = number?.let { numberToInstant(it, description) }

	fun instantToNumber(instant: Instant): Double {
		return longToNumber(instant.toEpochMilliseconds())
	}

	fun instantToNumber(instant: Instant?): Double? = instant?.let { instantToNumber(it) }

	fun <K, V, V_JS> mapToObject(
		map: Map<K, V>,
		convertKey: (key: K) -> String,
		convertValue: (value: V) -> V_JS,
	): Record<String, V_JS> {
		val obj = js("{}")
		for ((key, value) in map) {
			obj[convertKey(key)] = convertValue(value)
		}
		return obj
	}

	fun <K, V, V_JS> mapToObject(
		map: Map<K, V>?,
		convertKey: (key: K) -> String,
		convertValue: (value: V) -> V_JS,
	): Record<String, V_JS>? = map?.let { mapToObject(it, convertKey, convertValue) }

	fun <K, V, V_JS> objectToMap(
		obj: Record<String, V_JS>,
		description: String,
		convertKey: (value: String) -> K,
		convertValue: (value: V_JS) -> V,
	): Map<K, V> {
		val map = mutableMapOf<K, V>()
		val entries = js("Object.entries(obj)") as Array<Array<dynamic>>
		for (keyValue in entries) {
			val value = keyValue[1]
			if (value !== undefined) {
				map[convertKey(keyValue[0] as String)] = convertValue(value)
			}
		}
		return map
	}

	fun <K, V> objectToMapNullsafe(
		obj: dynamic,
		description: String,
		convertKey: (value: String) -> K,
		convertValue: (value: dynamic) -> V,
	): Map<K, V>? = if (obj == null) null else objectToMap(obj, description, convertKey, convertValue) // Can't use let on dynamic

	fun <KT, JS> arrayToList(
		array: Array<JS>,
		description: String,
		convertValue: (value: JS) -> KT,
	): List<KT> {
		return array.map { convertValue(it) }
	}

	fun <KT, JS> arrayToList(
		array: Array<JS>?,
		description: String,
		convertValue: (value: JS) -> KT,
	): List<KT>? = array?.let { arrayToList(it, description, convertValue) }

	fun <KT, JS> listToArray(
		list: List<KT>,
		convertValue: (value: KT) -> JS,
	): Array<JS> {
		return list.map { convertValue(it) }.toTypedArray()
	}

	fun <KT, JS> listToArray(
		list: List<KT>?,
		convertValue: (value: KT) -> JS,
	): Array<JS>? = list?.let { listToArray(it, convertValue) }

	fun <KT, JS> arrayToSet(
		array: Array<JS>,
		description: String,
		convertValue: (value: JS) -> KT,
	): Set<KT> {
		return array.mapTo(mutableSetOf()) { convertValue(it) }.also {
			require(it.size == array.size) {
				"$description will be converted to a set but contains duplicate values"
			}
		}
	}

	fun <KT, JS> arrayToSet(
		array: Array<JS>?,
		description: String,
		convertValue: (value: JS) -> KT,
	): Set<KT>? = array?.let { arrayToSet(it, description, convertValue) }

	fun <KT, JS> setToArray(
		set: Set<KT>,
		convertValue: (value: KT) -> JS,
	): Array<JS> {
		return set.map { convertValue(it) }.toTypedArray()
	}

	fun <KT, JS> setToArray(
		set: Set<KT>?,
		convertValue: (value: KT) -> JS,
	): Array<JS>? = set?.let { setToArray(it, convertValue) }

	fun zonedDateTimeToString(
		zonedDateTime: ZonedDateTime,
	): String {
		return zonedDateTime.toIso8601AndZoneString()
	}

	fun zonedDateTimeToString(
		zonedDateTime: ZonedDateTime?,
	): String? = zonedDateTime?.let { zonedDateTimeToString(it) }

	fun stringToZonedDateTime(
		string: String,
		description: String
	): ZonedDateTime {
		return try {
			ZonedDateTime.fromIso8601AndZoneString(string)
		} catch (e: Exception) {
			throw IllegalArgumentException("Invalid zoned date time $string @ $description", e)
		}
	}

	fun stringToZonedDateTime(
		string: String?,
		description: String
	): ZonedDateTime? = string?.let { stringToZonedDateTime(it, description) }

	@OptIn(ExperimentalSerializationApi::class)
	fun dynamicToJson(obj: dynamic, description: String): JsonElement =
		try {
			Json.decodeFromDynamic<JsonElement>(obj)
		} catch (e: Exception) {
			throw IllegalArgumentException("Invalid JSON object @ $description", e)
		}

	fun dynamicToJsonNullsafe(obj: dynamic, description: String): JsonElement? =
		// Note: can't use let on dynamic
		if (obj != null) dynamicToJson(obj, description) else null

	@OptIn(ExperimentalSerializationApi::class)
	fun jsonToDynamic(obj: JsonElement): dynamic =
		Json.encodeToDynamic<JsonElement>(obj)

	fun jsonToDynamic(obj: JsonElement?): dynamic =
		obj?.let { jsonToDynamic(it) }

	fun anyEntityWithTypeInfoToKt(obj: EntityWithTypeInfoJs<*>): EntityWithTypeInfo<*> =
		EntityWithTypeInfo(
			EntityWithEncryptionMetadataStub(
				obj.entity.id,
				obj.entity.rev,
				arrayToSet(
					obj.entity.secretForeignKeys,
					"entity.secretForeignKeys"
				) { it },
				objectToMap(
					obj.entity.cryptedForeignKeys,
					"entity.cryptedForeignKeys",
					{ it },
					{
						arrayToSet(it, "entity.cryptedForeignKeys value") { d: DelegationJs ->
							delegation_fromJs(d)
						}
					}
				),
				objectToMap(
					obj.entity.delegations,
					"entity.delegations",
					{ it },
					{
						arrayToSet(it, "entity.delegations value") { d: DelegationJs ->
							delegation_fromJs(d)
						}
					}
				),
				objectToMap(
					obj.entity.encryptionKeys,
					"entity.encryptionKeys",
					{ it },
					{
						arrayToSet(it, "entity.encryptionKeys value") { d: DelegationJs ->
							delegation_fromJs(d)
						}
					}
				),
				obj.entity.securityMetadata?.let { securityMetadata_fromJs(it) }
			),
			EntityWithEncryptionMetadataTypeName.valueOf(obj.type)
		)

	fun durationToNumber(duration: kotlin.time.Duration): Double {
		return longToNumber(duration.inWholeMilliseconds)
	}

	fun numberToDuration(number: Double, description: String): kotlin.time.Duration {
		return numberToLong(number, description).milliseconds
	}

	/**
	 * Returns [obj] if it is neither null nor undefined, otherwise returns undefined.
	 * Allows us to keep consistency with the typescript data model, where we use T | undefined for nullable types (no
	 * null).
	 */
	fun <T : Any> nullToUndefined(obj: T?): T? =
		obj ?: undefined

	/**
	 * Returns [obj] if it is neither null nor undefined, otherwise returns undefined.
	 * Allows us to make sure that we have no ugly surprises with undefined values on kotlin side. Currently the only
	 * ugly surprise we are aware of is related to json serialization.
	 *
	 * ```kotlin
	 *	val json = Json {
	 * 		encodeDefaults = false
	 * 		explicitNulls = true
	 * 	}
	 * 	@Serializable data class Foo(
	 * 		val nullDefault: String? = null,
	 * 		val nonNullDefault: String? = "bar"
	 * 	)
	 * 	println(json.encodeToString(Foo(null, "bar")))
	 * 	// {} - good
	 * 	println(json.encodeToString(Foo("bar", null)))
	 * 	// {"nullDefault":"bar","nonNullDefault":null} - good
	 * 	println(json.encodeToString(Foo("bar", undefined)))
	 * 	// {"nullDefault":"bar"} - BAD
	 * ```
	 */
	@Suppress("USELESS_ELVIS_RIGHT_IS_NULL") // This is a lie when using kotlin js
	fun <T : Any> undefinedToNull(obj: T?): T? =
		obj ?: null

	/**
	 * Converter from js for kotlin maps where the key is not a valid object key and have been annotated with
	 * JsMapAsObjectArray.
	 * The non-common part of the converter to js is trivial and is inlined in the synthetic converters.
	 */
	fun <O, K, V> objectArrayToMap(
		objectArray: Array<O>,
		extractKey: (O) -> K,
		extractValue: (O) -> V,
	): Map<K, V> =
		objectArray.groupBy {
			extractKey(it)
		}.mapValues {
			require(it.value.size == 1) {
				"Duplicate values for ArrayWithUniqueKeys: ${it.key}"
			}
			extractValue(it.value.single())
		}
}
