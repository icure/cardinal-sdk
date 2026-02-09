package com.icure.cardinal.sdk.serialization

import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.chain.FilterChain
import com.icure.cardinal.sdk.model.notification.Subscription
import com.icure.cardinal.sdk.model.notification.SubscriptionEventType
import com.icure.cardinal.sdk.model.specializations.AccessControlKeyHexString
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
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
class SubscriptionSerializer<O : Identifiable<String>>(
	abstractFilterSerializer: KSerializer<AbstractFilter<O>>
) : KSerializer<Subscription<O>> {

	private val filterChainSerializer = FilterChainSerializer(abstractFilterSerializer)

	override val descriptor: SerialDescriptor = buildClassSerialDescriptor("Subscription") {
		element<List<SubscriptionEventType>>("eventTypes")
		element<String>("entityClass")
		element("filter", filterChainSerializer.descriptor)
		element<List<AccessControlKeyHexString>?>("accessControlKeys")
		element<Boolean?>("useCardinalModelSerialization")
	}

	override fun deserialize(decoder: Decoder): Subscription<O> =
		decoder.decodeStructure(descriptor) {
			var eventTypes: List<SubscriptionEventType>? = null
			var entityClass: String? = null
			var filter: FilterChain<O>? = null
			var accessControlKeys: List<AccessControlKeyHexString>? = null
			var useCardinalModelSerialization: Boolean? = null
			while (true) {
				when (val index = decodeElementIndex(descriptor)) {
					0 -> eventTypes = decodeSerializableElement(descriptor, 0, ListSerializer(SubscriptionEventType.serializer()))
					1 -> entityClass = decodeStringElement(descriptor, 1)
					2 -> filter = decodeNullableSerializableElement(descriptor, 2, filterChainSerializer)
					3 -> accessControlKeys = decodeNullableSerializableElement(descriptor, 3, ListSerializer(AccessControlKeyHexString.serializer()))
					4 -> useCardinalModelSerialization = decodeNullableSerializableElement(descriptor, 4, Boolean.serializer())
					CompositeDecoder.DECODE_DONE -> break
					else -> error("Unexpected index: $index")
				}
			}
			Subscription(
				eventTypes = checkNotNull(eventTypes) { "Cannot deserialize a Subscription with a null eventTypes" },
				entityClass = checkNotNull(entityClass) { "Cannot deserialize a Subscription with a null entityClass" },
				filter = filter,
				accessControlKeys = accessControlKeys,
				useCardinalModelSerialization = useCardinalModelSerialization,
			)
		}

	override fun serialize(encoder: Encoder, value: Subscription<O>) = encoder.encodeStructure(descriptor) {
		encodeSerializableElement(descriptor, 0, ListSerializer(SubscriptionEventType.serializer()), value.eventTypes)
		encodeStringElement(descriptor, 1, value.entityClass)
		encodeNullableSerializableElement(descriptor, 2, filterChainSerializer, value.filter)
		encodeNullableSerializableElement(descriptor, 3, ListSerializer(AccessControlKeyHexString.serializer()), value.accessControlKeys)
		encodeNullableSerializableElement(descriptor, 4, Boolean.serializer(), value.useCardinalModelSerialization)
	}
}
