package com.icure.cardinal.sdk.serialization

import kotlinx.datetime.Instant
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object InstantSerializer : KSerializer<Instant> {

	override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Instant", PrimitiveKind.LONG)

	override fun deserialize(decoder: Decoder): Instant {
		decoder.decodeLong().let { return getInstant(it) }
	}

	override fun serialize(encoder: Encoder, value: Instant) {
		encoder.encodeLong(getLong(value))
	}

	private fun getInstant(value: Long): Instant {
		return Instant.fromEpochMilliseconds(value)
	}

	private fun getLong(value: Instant): Long {
		return value.toEpochMilliseconds()
	}
}