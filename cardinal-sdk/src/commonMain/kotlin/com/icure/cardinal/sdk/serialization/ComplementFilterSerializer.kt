package com.icure.cardinal.sdk.serialization

import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.ComplementFilter
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

@OptIn(ExperimentalSerializationApi::class)
internal class ComplementFilterSerializer<O : Identifiable<String>>(
	private val abstractFilterSerializer: KSerializer<AbstractFilter<O>>
): KSerializer<ComplementFilter<O>> {

	override val descriptor: SerialDescriptor = buildClassSerialDescriptor("ComplementFilter") {
		element("superSet", abstractFilterSerializer.descriptor)
		element("subSet", abstractFilterSerializer.descriptor)
		element<String?>("desc")
	}

	override fun deserialize(decoder: Decoder): ComplementFilter<O> =
		decoder.decodeStructure(descriptor) {
			var superSet: AbstractFilter<O>? = null
			var subSet: AbstractFilter<O>? = null
			var desc: String? = null
			while (true) {
				when (val index = decodeElementIndex(descriptor)) {
					0 -> superSet = decodeSerializableElement(descriptor, 0, abstractFilterSerializer)
					1 -> subSet = decodeSerializableElement(descriptor, 1, abstractFilterSerializer)
					2 -> desc = decodeNullableSerializableElement(descriptor, 2, String.serializer())
					CompositeDecoder.DECODE_DONE -> break
					else -> error("Unexpected index: $index")
				}
			}
			ComplementFilter(
				superSet = checkNotNull(superSet) { "Cannot deserialize a ComplementFilter with a null superSet" },
				subSet = checkNotNull(subSet) { "Cannot deserialize a ComplementFilter with a null subSet" },
				desc = desc,
			)
		}

	override fun serialize(encoder: Encoder, value: ComplementFilter<O>) = encoder.encodeStructure(descriptor) {
		encodeSerializableElement(descriptor, 0, abstractFilterSerializer, value.superSet)
		encodeSerializableElement(descriptor, 1, abstractFilterSerializer, value.subSet)
		encodeNullableSerializableElement(descriptor, 2, String.serializer(), value.desc)
	}
}
