package com.icure.cardinal.sdk.customsdk.commons.model

import com.icure.cardinal.sdk.model.dao.KeyComponent
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.boolean
import kotlinx.serialization.json.double
import kotlinx.serialization.json.int
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.long

/**
 * Carries information about each view, that are used for validation.
 *
 * @param dataOwnerInfo null if the view is not by data owner. Otherwise, carries the type of data owner used by the view and the index of
 * the data owner id (or delegation key in the case of anonymous data owners) in the view key.
 * @param patientInfo if the view key also includes patient secret ids, the index of the key where the secret id resides.
 * @param linkedViews a list of pairs where the first element is the name of another view for the same entity and the value is the type of
 * link that associates the two views. (e.g. this is used when the user wants a view by any data owner that is split under the hood into
 * a view for explicit data owners and a view for anonymous data owners)-
 * @param keyConverter a list of [KeyComponentConverter] to parse the JsonElement key received as next page cursor in a request.
 * @param valueConverter defines the structure of the value (no value, scalar value or object value) with the converters to parse each field
 * from JsonElement to [KeyComponent].
 * @param keyFieldsComparatorOrder for the views that need front-end sorting, contains the fields of the value that are relevant for sorting
 * in the order in which they should be compared.
 */
@Serializable
data class ViewManifest(
	val dataOwnerInfo: DataOwnerInfo?,
	val patientInfo: PatientInfo?,
	val linkedViews: List<Pair<String, LinkType>>,
	val keyConverter: List<KeyComponentConverter>,
	val valueConverter: ValueConverter,
	val keyFieldsComparatorOrder: List<String>
) {

	init {
		val valueFields = when (valueConverter) {
			ValueConverter.Null -> emptySet()
			is ValueConverter.Scalar -> setOf(SINGLE_VALUE_KEY)
			is ValueConverter.Object -> valueConverter.converters.keys
		}
		val unknownFields = keyFieldsComparatorOrder.filter { it !in valueFields }
		require(unknownFields.isEmpty()) { "Sort fields $unknownFields are not part of the view value (available: $valueFields)" }
	}

	companion object {
		const val SINGLE_VALUE_KEY = "scalar_value"
	}

	/**
	 * Parses a view key (e.g. the start key of the next page cursor) using [keyConverter].
	 */
	fun parseKey(key: JsonElement): List<KeyComponent> {
		require(key is JsonArray) { "Key must be an array." }
		require(key.size == keyConverter.size) { "Invalid key size: ${key.size}, expected ${keyConverter.size}" }
		return key.mapIndexed { index, element -> keyConverter[index].convert(element) }
	}

	@Serializable
	enum class ViewDataOwnerType { Explicit, Anonymous }

	@Serializable
	enum class LinkType {
		ComplementingExplicitDataOwnerView,
		ComplementingAnonymousDataOwnerView,
	}

	@Serializable
	data class DataOwnerInfo(
		val keyIndex: Int,
		val dataOwnerType: ViewDataOwnerType
	)

	@Serializable
	data class PatientInfo(
		val keyIndex: Int,
	)

	@Serializable
	sealed interface ValueConverter {
		/**
		 * Parses the value of a view row. A scalar value is stored under [SINGLE_VALUE_KEY].
		 */
		fun convert(value: JsonElement): Map<String, KeyComponent>

		@Serializable
		data object Null : ValueConverter {
			override fun convert(value: JsonElement): Map<String, KeyComponent> = emptyMap()
		}
		@Serializable
		data class Scalar(val converter: KeyComponentConverter) : ValueConverter {
			override fun convert(value: JsonElement): Map<String, KeyComponent> = mapOf(SINGLE_VALUE_KEY to converter.convert(value))
		}
		@Serializable
		data class Object(val converters: Map<String, KeyComponentConverter>): ValueConverter {
			override fun convert(value: JsonElement): Map<String, KeyComponent> {
				require(value is JsonObject) { "Value for this view must be an object" }
				return converters.mapValues { (key, converter) -> converter.convert(value.getValue(key)) }
			}
		}
	}
}

@Serializable
sealed interface KeyComponentConverter {
	fun convert(element: JsonElement): KeyComponent

	@Serializable
	data object IntKeyComponentConverter : KeyComponentConverter {
		override fun convert(element: JsonElement): KeyComponent =
			KeyComponent.IntKeyComponent(element.primitiveOrNull()?.int)
	}
	@Serializable
	data object LongKeyComponentConverter : KeyComponentConverter {
		override fun convert(element: JsonElement): KeyComponent =
			KeyComponent.LongKeyComponent(element.primitiveOrNull()?.long)
	}
	@Serializable
	data object DoubleKeyComponentConverter : KeyComponentConverter {
		override fun convert(element: JsonElement): KeyComponent =
			KeyComponent.DoubleKeyComponent(element.primitiveOrNull()?.double)
	}
	@Serializable
	data object BooleanKeyComponentConverter : KeyComponentConverter {
		override fun convert(element: JsonElement): KeyComponent =
			KeyComponent.BooleanKeyComponent(element.primitiveOrNull()?.boolean)
	}
	@Serializable
	data object StringKeyComponentConverter : KeyComponentConverter {
		override fun convert(element: JsonElement): KeyComponent =
			KeyComponent.StringKeyComponent(element.primitiveOrNull()?.content)
	}
}

/**
 * JSON null is converted to a key component with a null value rather than parsed (e.g. [JsonPrimitive.content] would return "null").
 */
private fun JsonElement.primitiveOrNull(): JsonPrimitive? = if (this is JsonNull) null else jsonPrimitive
