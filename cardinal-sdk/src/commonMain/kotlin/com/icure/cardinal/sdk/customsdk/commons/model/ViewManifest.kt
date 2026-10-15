package com.icure.cardinal.sdk.customsdk.commons.model

import com.icure.cardinal.sdk.model.dao.KeyComponent
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
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

	companion object {
		const val SINGLE_VALUE_KEY = "scalar_value"
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
		@Serializable
		data object Null : ValueConverter
		@Serializable
		data class Scalar(val converter: KeyComponentConverter) : ValueConverter
		@Serializable
		data class Object(val converters: Map<String, KeyComponentConverter>): ValueConverter
	}
}

@Serializable
sealed interface KeyComponentConverter {
	fun convert(element: JsonElement): KeyComponent

	@Serializable
	data object IntKeyComponentConverter : KeyComponentConverter {
		override fun convert(element: JsonElement): KeyComponent =
			KeyComponent.IntKeyComponent(element.jsonPrimitive.int)
	}
	@Serializable
	data object LongKeyComponentConverter : KeyComponentConverter {
		override fun convert(element: JsonElement): KeyComponent =
			KeyComponent.LongKeyComponent(element.jsonPrimitive.long)
	}
	@Serializable
	data object DoubleKeyComponentConverter : KeyComponentConverter {
		override fun convert(element: JsonElement): KeyComponent =
			KeyComponent.DoubleKeyComponent(element.jsonPrimitive.double)
	}
	@Serializable
	data object BooleanKeyComponentConverter : KeyComponentConverter {
		override fun convert(element: JsonElement): KeyComponent =
			KeyComponent.BooleanKeyComponent(element.jsonPrimitive.boolean)
	}
	@Serializable
	data object StringKeyComponentConverter : KeyComponentConverter {
		override fun convert(element: JsonElement): KeyComponent =
			KeyComponent.StringKeyComponent(element.jsonPrimitive.content)
	}
}
