package com.icure.cardinal.sdk.model

import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaService
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.kryptom.utils.toHexString
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV2String
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.cardinal.sdk.utils.Serialization
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.encodeToJsonElement

data class KeyInfo(
	val spkiHex: String,
	val fingerprintV1: String,
	val fingerprintV2: String
)

val keys = listOf(
	KeyInfo(
		spkiHex = "30820122300d06092a864886f70d01010105000382010f003082010a028201010087e2a724c8a872c86470a5b1704961b7" +
			"cc1f67fd8e5a2e6fd4ed698789bbebfd14a957c7f2a8ad9e77aa0f877e013b884c1aec42696473da13eb18af30f84871a81f9841" +
			"291417415176cc11eda0b27c634cccc6683132a14658cab73f0b8b65adbbdfcc8fb9a930ede97a653c0caf2ef2e36c2b647b714d" +
			"3b02cf93c18f6a0b6bc344096e6cfc20df5a43b073846b5b12daeddbdc1cd1718bf4d0ba059051b25794c89cb2b79cb7331b875f" +
			"208ecf3e635e6a7528c4bc3abf4368682756a84cd38ea37f1ed5e73cce36454b5b1b7c37154b84491b0c5f5d6ed98b4ee3152e79" +
			"ce4c1d241bebf55f499c22ec4051764dcae325f9bfe245e8d56f327f9f4b11150203010001",
		fingerprintV1 = "e245e8d56f327f9f4b11150203010001",
		fingerprintV2 = "e245e8d56f327f9f4b1115"
	),
	KeyInfo(
		spkiHex = "30820222300d06092a864886f70d01010105000382020f003082020a0282020100b5078b54b053127528a148588bc71efc" +
			"f2369b307fb541d42f4014d18765e8c55c67ac5c5161e0b6926a3efb28c372a8253569a8ca1f47f764656a2ea7b0870043afe164" +
			"43d88c1d3424094a683a60d46ce3e000d65a2e406c64ab2011689809315e65f6f1d13ab0234377ddfd8e35a7cb17e816184aa667" +
			"04063d414dcd3aa7be3fac0640779140e097b74f5e67760fbba5412180f69fc9a5a90b4386e2fe9734a423e8f53eee99d026d5b1" +
			"30f41ee7bff9ee61d4b8d20cb8bdb1d9110be680c2d73c97a46a7367d4087c778f346b73ac244d0ed524b9938a1a086c2b1e11f5" +
			"1d13bb6f7fd476c0b7ea25441701b4357c6ad94389e64e5c181d7ff63bd814943842d7c559c353d5d5f995d07e1c639b4ff33f84" +
			"7217cc793d9a7fbdf49b7a4aa27236c08463e2bebab41a639161ab57772a21b0d1b5e4ee20301b5d8f483bd71c3ed016d2a2be87" +
			"620224e859313259b59cff1c2afdce6591cee90b0dda43accfead76595931a41061b4e08beee4c50df05a13255d9fd05e64105af" +
			"58699278dd109e00262211f8c53556c862bb61bd928e8e764108175f0265b9132219a8fca21ed1b2792b81c60cf8494f51b09dd7" +
			"34c8dd381a298a494414fd32f92e25711a110f4aedadfe38bcf1962a08cc2e3054a1db6b215aa36fa58acea5bcfc4493c7a9207e" +
			"9bfd06fac83cc893621799ac805c55718d8c18ab6a4fb001fecf51730203010001",
		fingerprintV1 = "8c18ab6a4fb001fecf51730203010001",
		fingerprintV2 = "8c18ab6a4fb001fecf5173"
	)
)


class StringSpecializationTest : StringSpec({
	"Spki hex string should be serialized as a simple string".config(enabled = DEFAULT_ENABLED) {
		keys.forEach {
			Serialization.json.encodeToJsonElement(SpkiHexString(it.spkiHex)).shouldBeStringPrimitive()
		}
	}

	"Spki hex string should be deserializable from a simple string".config(enabled = DEFAULT_ENABLED) {
		keys.forEach {
			Serialization.json.decodeFromString<SpkiHexString>("\"${it.spkiHex}\"") shouldBe SpkiHexString(it.spkiHex)
		}
	}

	"Spki hex string fingerprints should match expected".config(enabled = DEFAULT_ENABLED) {
		keys.forEach {
			val spki = SpkiHexString(it.spkiHex)
			spki.fingerprintV1().s shouldBe it.fingerprintV1
			spki.fingerprintV2().s shouldBe it.fingerprintV2
			KeypairFingerprintV2String.fromV1(spki.fingerprintV1()).s shouldBe it.fingerprintV2
			KeypairFingerprintV1String.fromV2(spki.fingerprintV2()).s shouldBe it.fingerprintV1
		}
	}

	"KeypairFingerprintV1String should be serialized as a simple string".config(enabled = DEFAULT_ENABLED) {
		keys.forEach {
			Serialization.json.encodeToJsonElement(KeypairFingerprintV1String(it.fingerprintV1)).shouldBeStringPrimitive()
		}
	}

	"KeypairFingerprintV1String should be deserializable from a simple string".config(enabled = DEFAULT_ENABLED) {
		keys.forEach {
			Serialization.json.decodeFromString<KeypairFingerprintV1String>("\"${it.fingerprintV1}\"") shouldBe KeypairFingerprintV1String(it.fingerprintV1)
		}
	}

	"KeypairFingerprintV2String should be serialized as a simple string".config(enabled = DEFAULT_ENABLED) {
		keys.forEach {
			Serialization.json.encodeToJsonElement(KeypairFingerprintV2String(it.fingerprintV2)).shouldBeStringPrimitive()
		}
	}

	"KeypairFingerprintV2String should be deserializable from a simple string".config(enabled = DEFAULT_ENABLED) {
		keys.forEach {
			Serialization.json.decodeFromString<KeypairFingerprintV2String>("\"${it.fingerprintV2}\"") shouldBe KeypairFingerprintV2String(it.fingerprintV2)
		}
	}

	"Generated keys should match expected formats".config(enabled = DEFAULT_ENABLED) {
		listOf(
			RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256,
			RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1,
			RsaAlgorithm.RsaSignatureAlgorithm.PssWithSha256
		).forEach { algorithm ->
			RsaService.KeySize.entries.forEach { keySize ->
				val generated = defaultCryptoService.rsa.generateKeyPair(algorithm, keySize)
				val exported = defaultCryptoService.rsa.exportPublicKeySpki(generated.public).toHexString()
				// Just to check that initialisation works
				SpkiHexString(exported).shouldBeInstanceOf<SpkiHexString>()
				SpkiHexString(exported).fingerprintV1().shouldBeInstanceOf<KeypairFingerprintV1String>()
				SpkiHexString(exported).fingerprintV2().shouldBeInstanceOf<KeypairFingerprintV2String>()
			}
		}
	}
})

fun JsonElement.shouldBeStringPrimitive() {
	this.shouldBeInstanceOf<JsonPrimitive>()
	this.isString shouldBe true
}