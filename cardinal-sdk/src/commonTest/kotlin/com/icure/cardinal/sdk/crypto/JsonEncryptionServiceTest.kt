package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.cardinal.sdk.crypto.impl.JsonEncryptionServiceImpl
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.utils.InternalIcureApi
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.string.shouldContain
import io.ktor.utils.io.charsets.Charsets
import io.ktor.utils.io.core.toByteArray
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject

@OptIn(InternalIcureApi::class)
class JsonEncryptionServiceTest : StringSpec({
	val jsonEncryptionService = JsonEncryptionServiceImpl(defaultCryptoService)

	fun stripEncryptedSelf(json: JsonElement): JsonElement = when (json) {
		is JsonArray -> JsonArray(json.map { stripEncryptedSelf(it) })
		is JsonObject -> JsonObject((json - "encryptedSelf").mapValues { stripEncryptedSelf(it.value) })
		else -> json
	}

	"Encrypted fields parsing should create the appropriate structure".config(enabled = DEFAULT_ENABLED) {
		val fields = setOf(
			"field1",
			"field2",
			"nestedField.field3",
			"nestedField.field4",
			"arrayField[].field5",
			"arrayField[].field6",
			"arrayField[].nestedField.field7",
			"arrayField2[]." + Json.encodeToString(setOf(
				"field8",
				"mapField.*.field9",
				"nestedField.${Json.encodeToString(setOf("field10", "field11"))}",
				"nestedField.field12"
			)),
			"mapField.*.field13",
			"mapField.*.field14",
		)
		val parsedFields = JsonEncryptionService.parseEncryptedFields(fields, "Test.")
		fun checkParsedFields(
			manifest: EncryptedFieldsManifest,
			expectedPath: String,
			expectedTopLevelFields: Set<String>,
			expectedNestedFields: Map<String, (subkeys: EncryptedFieldsManifest) -> Unit> = emptyMap(),
			expectedArrayFields: Map<String, (subkeys: EncryptedFieldsManifest) -> Unit> = emptyMap(),
			expectedMapFields: Map<String, (subkeys: EncryptedFieldsManifest) -> Unit> = emptyMap()
		) {
			manifest.path shouldBe expectedPath
			manifest.topLevelFields shouldBe expectedTopLevelFields
			manifest.nestedObjectsKeys.keys shouldBe expectedNestedFields.keys
			manifest.arraysValuesKeys.keys shouldBe expectedArrayFields.keys
			manifest.mapsValuesKeys.keys shouldBe expectedMapFields.keys
			expectedNestedFields.forEach { (k, v) ->
				v(manifest.nestedObjectsKeys.getValue(k))
			}
			expectedMapFields.forEach { (k, v) ->
				v(manifest.mapsValuesKeys.getValue(k))
			}
			expectedArrayFields.forEach { (k, v) ->
				v(manifest.arraysValuesKeys.getValue(k))
			}
		}
		checkParsedFields(
			parsedFields,
			"Test.",
			setOf("field1", "field2"),
			expectedNestedFields = mapOf(
				"nestedField" to {
					checkParsedFields(
						it,
						"Test.nestedField.",
						setOf("field3", "field4"),
					)
				}
			),
			expectedArrayFields = mapOf(
				"arrayField" to {
					checkParsedFields(
						it,
						"Test.arrayField[].",
						setOf("field5", "field6"),
						expectedNestedFields = mapOf(
							"nestedField" to {
								checkParsedFields(
									it,
									"Test.arrayField[].nestedField.",
									setOf("field7"),
								)
							}
						),
					)
				},
				"arrayField2" to {
					checkParsedFields(
						it,
						"Test.arrayField2[].",
						setOf("field8"),
						expectedNestedFields = mapOf(
							"nestedField" to {
								checkParsedFields(
									it,
									"Test.arrayField2[].nestedField.",
									setOf("field10", "field11", "field12"),
								)
							}
						),
						expectedMapFields = mapOf(
							"mapField" to {
								checkParsedFields(
									it,
									"Test.arrayField2[].mapField.*.",
									setOf("field9"),
								)
							}
						)
					)
				}
			),
			expectedMapFields = mapOf(
				"mapField" to {
					checkParsedFields(
						it,
						"Test.mapField.*.",
						setOf("field13", "field14"),
					)
				}
			)
		)
	}

	"Encrypted fields parsing should fail in case of any field being invalid".config(enabled = DEFAULT_ENABLED) {
		val sampleValidFields = setOf(
			"field1",
			"nestedField.field3",
			"arrayField[].nestedField.field7",
			"arrayField2[].${Json.encodeToString(setOf("field8", "mapField.*.field9"))}",
			"mapField.*.field13",
		)
		val invalidFields = listOf(
			"a.1b" to null,
			"a.[].b" to null,
			"a[].*.b" to null, // Not supported but maybe in future
			"a[].b.{}" to null,
			"a[].b.${Json.encodeToString(JsonArray(listOf(JsonPrimitive("c"), JsonPrimitive(0))))}" to null,
			"a.*.b.${Json.encodeToString(setOf("c", "\\"))}" to "a.*.b.\\",
			"a[].b.${Json.encodeToString(setOf("c", "1notAField"))}" to "a[].b.1notAField",
			"a.b." + Json.encodeToString(setOf("c", "d.*." + Json.encodeToString(setOf("e", "f[]." + Json.encodeToString(setOf("g", "1notAField")))))) to "a.b.d.*.f[].1notAField"
		)
		for ((field, expectedErrorMessageInfo) in invalidFields) {
			shouldThrow<IllegalArgumentException> {
				JsonEncryptionService.parseEncryptedFields(sampleValidFields + field, "Test.")
			}.message shouldContain "Test." + (expectedErrorMessageInfo ?: field)
		}
	}

	val sampleObj = JsonObject(mapOf(
		"field1" to JsonPrimitive("nonEncryptedValue1A"),
		"field2" to JsonPrimitive("nonEncryptedValue2A"),
		"field3" to JsonPrimitive("encryptedValue3A"),
		"field4" to JsonPrimitive("encryptedValue4A"),
		"nestedData" to JsonObject(mapOf(
			"field1" to JsonPrimitive("nonEncryptedValue1B"),
			"field2" to JsonPrimitive("encryptedValue2B"),
			"field3" to JsonPrimitive("nonEncryptedValue3B"),
			"field4" to JsonPrimitive("encryptedValue4B"),
		)),
		"arrayData" to JsonArray(listOf(
			JsonObject(mapOf(
				"field1" to JsonPrimitive("nonEncryptedValue1C"),
				"field2" to JsonPrimitive("encryptedValue2C"),
				"field3" to JsonPrimitive("encryptedValue3C"),
				"field4" to JsonPrimitive("nonEncryptedValue4C"),
				"nestedData" to JsonObject(mapOf(
					"field1" to JsonPrimitive("encryptedValue1D"),
					"field2" to JsonPrimitive("encryptedValue2D"),
					"field3" to JsonPrimitive("nonEncryptedValue3D"),
					"field4" to JsonPrimitive("nonEncryptedValue4D"),
				)),
				"arrayData" to JsonArray(listOf(
					JsonObject(mapOf(
						"field1" to JsonPrimitive("encryptedValue1E"),
						"field2" to JsonPrimitive("nonEncryptedValue2E"),
						"field3" to JsonPrimitive("nonEncryptedValue3E"),
						"field4" to JsonPrimitive("encryptedValue4E"),
						"arrayData" to JsonArray(listOf(
							JsonNull,
							JsonObject(mapOf(
								"a" to JsonPrimitive(1), // encrypted
								"b" to JsonPrimitive(2), // encrypted
								"x" to JsonPrimitive(3),
								"y" to JsonPrimitive(4),
							)),
						)),
					)),
					JsonObject(mapOf(
						"field1" to JsonPrimitive("encryptedValue1F"),
						"field2" to JsonPrimitive("nonEncryptedValue2F"),
						"field3" to JsonPrimitive("nonEncryptedValue3F"),
						"field4" to JsonPrimitive("encryptedValue4F"),
						"nestedData" to JsonObject(mapOf(
							"a" to JsonPrimitive(1),
							"b" to JsonPrimitive(2),
							"x" to JsonPrimitive(3), // encrypted
							"y" to JsonPrimitive(4), // encrypted
						)),
						// No array data: by convention we usually considered undefined array as empty, but in future this may change. The crypt/decrypt must
						// handle this properly
					)),
				)),
			)),
			JsonNull, // Should be left as null
			JsonObject(mapOf(
				"field1" to JsonPrimitive("nonEncryptedValue1G"),
				"field2" to JsonPrimitive("encryptedValue2G"),
				"field3" to JsonPrimitive("encryptedValue3G"),
				"field4" to JsonPrimitive("nonEncryptedValue4G"),
				"nestedData" to JsonObject(mapOf(
					"field1" to JsonPrimitive("encryptedValue1H"),
					"field2" to JsonPrimitive("encryptedValue2H"),
					"field3" to JsonPrimitive("nonEncryptedValue3H"),
					"field4" to JsonPrimitive("nonEncryptedValue4H"),
				)),
				"arrayData" to JsonArray(emptyList()),
			)),
		)),
		"arrayData2" to JsonArray(listOf(
			JsonObject(mapOf(
				"field1" to JsonPrimitive("encryptedValue1I"),
				"field2" to JsonPrimitive("nonEncryptedValue2I"),
				"field3" to JsonPrimitive("nonEncryptedValue3I"),
				"field4" to JsonPrimitive("encryptedValue4I"),
			)),
			JsonObject(mapOf(
				"field1" to JsonPrimitive("encryptedValue1J"),
				"field2" to JsonPrimitive("nonEncryptedValue2J"),
				"field3" to JsonPrimitive("nonEncryptedValue3J"),
				"field4" to JsonPrimitive("encryptedValue4J"),
			)),
		)),
		"mapData" to JsonObject(mapOf(
			"a" to JsonObject(mapOf(
				"field2" to JsonPrimitive("encryptedValue2K"),
				"field4" to JsonPrimitive("nonEncryptedValue4K"),
			)),
			"b" to JsonObject(mapOf(
				"field1" to JsonPrimitive("nonEncryptedValue1L"),
				"field3" to JsonPrimitive("encryptedValue3L"),
			)),
			"c" to JsonObject(mapOf(
				"field1" to JsonPrimitive("nonEncryptedValue1M"),
				"field2" to JsonPrimitive("encryptedValue2M"),
				"field3" to JsonPrimitive("encryptedValue3M"),
				"field4" to JsonPrimitive("nonEncryptedValue4M"),
			)),
			"d" to JsonObject(mapOf(
				"field1" to JsonPrimitive("nonEncryptedValue1N"),
				"field4" to JsonPrimitive("nonEncryptedValue4N"),
				// If the encrypted fields are all optional and missing the encrypted self should still be set (from {})
			)),
		))
	))

	val sampleObjEncryptionKeys = setOf(
		"field3",
		"field4",
		"nestedData.field2",
		"nestedData.field4",
		"arrayData[]." + Json.encodeToString(setOf(
			"field2",
			"field3",
			"nestedData.field1",
			"nestedData.field2",
			"arrayData[]." + Json.encodeToString(setOf("field1", "field4", "nestedData.x", "nestedData.y", "arrayData[].a", "arrayData[].b")),
		)),
		"arrayData2[].field1",
		"arrayData2[].field4",
		"mapData.*.field2",
		"mapData.*.field3",
	)

	"encrypted object should delete encrypted fields and set encryptedSelf".config(enabled = DEFAULT_ENABLED) {
		val encryptedSelf = "VGVzdA=="
		val expectedEncrypted = JsonObject(mapOf(
			"field1" to JsonPrimitive("nonEncryptedValue1A"),
			"field2" to JsonPrimitive("nonEncryptedValue2A"),
			"encryptedSelf" to JsonPrimitive(encryptedSelf),
			"nestedData" to JsonObject(mapOf(
				"field1" to JsonPrimitive("nonEncryptedValue1B"),
				"field3" to JsonPrimitive("nonEncryptedValue3B"),
				"encryptedSelf" to JsonPrimitive(encryptedSelf),
			)),
			"arrayData" to JsonArray(listOf(
				JsonObject(mapOf(
					"field1" to JsonPrimitive("nonEncryptedValue1C"),
					"field4" to JsonPrimitive("nonEncryptedValue4C"),
					"encryptedSelf" to JsonPrimitive(encryptedSelf),
					"nestedData" to JsonObject(mapOf(
						"field3" to JsonPrimitive("nonEncryptedValue3D"),
						"field4" to JsonPrimitive("nonEncryptedValue4D"),
						"encryptedSelf" to JsonPrimitive(encryptedSelf),
					)),
					"arrayData" to JsonArray(listOf(
						JsonObject(mapOf(
							"field2" to JsonPrimitive("nonEncryptedValue2E"),
							"field3" to JsonPrimitive("nonEncryptedValue3E"),
							"encryptedSelf" to JsonPrimitive(encryptedSelf),
							"arrayData" to JsonArray(listOf(
								JsonNull,
								JsonObject(mapOf(
									"x" to JsonPrimitive(3),
									"y" to JsonPrimitive(4),
									"encryptedSelf" to JsonPrimitive(encryptedSelf),
								)),
							)),
						)),
						JsonObject(mapOf(
							"field2" to JsonPrimitive("nonEncryptedValue2F"),
							"field3" to JsonPrimitive("nonEncryptedValue3F"),
							"encryptedSelf" to JsonPrimitive(encryptedSelf),
							"nestedData" to JsonObject(mapOf(
								"a" to JsonPrimitive(1),
								"b" to JsonPrimitive(2),
								"encryptedSelf" to JsonPrimitive(encryptedSelf),
							)),
						)),
					)),
				)),
				JsonNull,
				JsonObject(mapOf(
					"field1" to JsonPrimitive("nonEncryptedValue1G"),
					"field4" to JsonPrimitive("nonEncryptedValue4G"),
					"encryptedSelf" to JsonPrimitive(encryptedSelf),
					"nestedData" to JsonObject(mapOf(
						"field3" to JsonPrimitive("nonEncryptedValue3H"),
						"field4" to JsonPrimitive("nonEncryptedValue4H"),
						"encryptedSelf" to JsonPrimitive(encryptedSelf),
					)),
					"arrayData" to JsonArray(emptyList()),
				)),
			)),
			"arrayData2" to JsonArray(listOf(
				JsonObject(mapOf(
					"field2" to JsonPrimitive("nonEncryptedValue2I"),
					"field3" to JsonPrimitive("nonEncryptedValue3I"),
					"encryptedSelf" to JsonPrimitive(encryptedSelf),
				)),
				JsonObject(mapOf(
					"field2" to JsonPrimitive("nonEncryptedValue2J"),
					"field3" to JsonPrimitive("nonEncryptedValue3J"),
					"encryptedSelf" to JsonPrimitive(encryptedSelf),
				)),
			)),
			"mapData" to JsonObject(mapOf(
				"a" to JsonObject(mapOf(
					"field4" to JsonPrimitive("nonEncryptedValue4K"),
					"encryptedSelf" to JsonPrimitive(encryptedSelf),
				)),
				"b" to JsonObject(mapOf(
					"field1" to JsonPrimitive("nonEncryptedValue1L"),
					"encryptedSelf" to JsonPrimitive(encryptedSelf),
				)),
				"c" to JsonObject(mapOf(
					"field1" to JsonPrimitive("nonEncryptedValue1M"),
					"field4" to JsonPrimitive("nonEncryptedValue4M"),
					"encryptedSelf" to JsonPrimitive(encryptedSelf),
				)),
				"d" to JsonObject(mapOf(
					"field1" to JsonPrimitive("nonEncryptedValue1N"),
					"field4" to JsonPrimitive("nonEncryptedValue4N"),
					"encryptedSelf" to JsonPrimitive(encryptedSelf),
				)),
			))
		))
		val encryptedObj = jsonEncryptionService.encrypt(
			sampleObj,
			JsonEncryptionService.parseEncryptedFields(sampleObjEncryptionKeys, "Test."),
			{ "Test".toByteArray(Charsets.UTF_8) },
			{ "Test".toByteArray(Charsets.UTF_8) },
		)
		encryptedObj shouldBe expectedEncrypted
	}

	"Encrypted then decrypted object should equal the original (excluding for the addition of encrypted self".config(enabled = DEFAULT_ENABLED) {
		val key = defaultCryptoService.aes.generateKey(AesAlgorithm.CbcWithPkcs7Padding)
		val encryptedObj = jsonEncryptionService.encrypt(
			key,
			sampleObj,
			JsonEncryptionService.parseEncryptedFields(sampleObjEncryptionKeys, "Test."),
		)
		val decryptedObj = jsonEncryptionService.decrypt(listOf(key), encryptedObj)
		stripEncryptedSelf(decryptedObj) shouldBe sampleObj
	}
	
	"Encrypt should fail if the fields type does not match the expected type from manifest".config(enabled = DEFAULT_ENABLED) {
		val cases: List<Triple<EncryptedFieldsManifest, JsonObject, String>> = listOf(
			Triple(
				JsonEncryptionService.parseEncryptedFields(setOf("shouldBeObject.nestedShouldBeObject.field1"), "Test."),
				JsonObject(mapOf("shouldBeObject" to JsonObject(mapOf("nestedShouldBeObject" to JsonPrimitive("not an object"))))),
				"shouldBeObject.nestedShouldBeObject",
			),
			Triple(
				JsonEncryptionService.parseEncryptedFields(setOf("shouldBeObject.nestedShouldBeObject.field1"), "Test."),
				JsonObject(mapOf("shouldBeObject" to JsonPrimitive("not an object"))),
				"shouldBeObject",
			),
			Triple(
				JsonEncryptionService.parseEncryptedFields(setOf("shouldBeObject.nestedShouldBeObject.field1"), "Test."),
				JsonObject(mapOf("shouldBeObject" to JsonArray(listOf(JsonPrimitive("Something"))))),
				"shouldBeObject"
			),
			Triple(
				JsonEncryptionService.parseEncryptedFields(setOf("shouldBeMap.*.field1"), "Test."),
				JsonObject(mapOf("shouldBeMap" to JsonObject(mapOf("key1" to JsonObject(mapOf("field1" to JsonPrimitive("something"))), "key2" to JsonPrimitive("not an object"))))),
				"shouldBeMap.key2"
			),
			Triple(
				JsonEncryptionService.parseEncryptedFields(setOf("shouldBeMap.*.field1"), "Test."),
				JsonObject(mapOf("shouldBeMap" to JsonArray(emptyList()))),
				"shouldBeMap"
			),
			Triple(
				JsonEncryptionService.parseEncryptedFields(setOf("shouldBeMap.*.field1"), "Test."),
				JsonObject(mapOf("shouldBeMap" to JsonPrimitive("not a map"))),
				"shouldBeMap"
			),
			Triple(
				JsonEncryptionService.parseEncryptedFields(setOf("shouldBeArray[].field1"), "Test."),
				JsonObject(mapOf("shouldBeArray" to JsonObject(mapOf("0" to JsonObject(mapOf("field1" to JsonPrimitive("fake array"))), "1" to JsonObject(mapOf("field1" to JsonPrimitive("wow"))))))),
				"shouldBeArray"
			),
			Triple(
				JsonEncryptionService.parseEncryptedFields(setOf("shouldBeArray[].field1"), "Test."),
				JsonObject(mapOf("shouldBeArray" to JsonArray(listOf(JsonObject(mapOf("field1" to JsonPrimitive("this is ok"))), JsonPrimitive("this is not ok"))))),
				"shouldBeArray[1]"
			),
		)
		cases.forEach { (manifest, obj, brokenField) ->
			println("X - $brokenField")
			shouldThrow<IllegalArgumentException> {
				jsonEncryptionService.encrypt(
					defaultCryptoService.aes.generateKey(AesAlgorithm.CbcWithPkcs7Padding),
					obj,
					manifest,
				)
			}.message shouldContain brokenField
		}
	}

	"If the content of encrypted self in an object is the same as the updated content it should be reused".config(enabled = DEFAULT_ENABLED) {
		val key = defaultCryptoService.aes.generateKey(AesAlgorithm.CbcWithPkcs7Padding)
		val manifest = JsonEncryptionService.parseEncryptedFields(setOf("encryptThis"), "Test.")
		val obj = JsonObject(mapOf(
			"encryptThis" to JsonPrimitive("encryptThisValue"),
			"leaveThis" to JsonPrimitive("leaveThisValue"),
		))
		val encryptedObj = jsonEncryptionService.encrypt(key, obj, manifest)
		val decryptedObj = jsonEncryptionService.decrypt(listOf(key), encryptedObj)
		val reEncryptedObj = jsonEncryptionService.encrypt(key, decryptedObj, manifest)
		val reEncryptedObjWithDifferentClearData = jsonEncryptionService.encrypt(
			key,
			JsonObject(decryptedObj + ("leaveThis" to JsonPrimitive("differentClearValue"))),
			manifest
		)
		encryptedObj shouldBe reEncryptedObj
		reEncryptedObjWithDifferentClearData["encryptedSelf"].shouldNotBeNull() shouldBe encryptedObj["encryptedSelf"]
		val reEncryptedObjWithDifferentEncryptedData = jsonEncryptionService.encrypt(
			key,
			JsonObject(decryptedObj + ("encryptThis" to JsonPrimitive("differentEncryptedValue"))),
			manifest
		)
		reEncryptedObjWithDifferentEncryptedData["encryptedSelf"].shouldNotBeNull() shouldNotBe encryptedObj["encryptedSelf"]
		reEncryptedObjWithDifferentEncryptedData["leaveThis"].shouldNotBeNull() shouldBe decryptedObj["leaveThis"]
	}

	"Wildcard encryption: should encrypt all fields of the entity".config(enabled = DEFAULT_ENABLED) {
		val key = defaultCryptoService.aes.generateKey(AesAlgorithm.CbcWithPkcs7Padding)
		val manifest = JsonEncryptionService.parseEncryptedFields(
			setOf(
				"encryptPartially[].a",
				"encryptFully[].*"
			),
			"Test."
		)
		val obj = JsonObject(mapOf(
			"encryptPartially" to JsonArray(listOf(
				JsonObject(mapOf(
					"a" to JsonPrimitive(1),
					"b" to JsonPrimitive(2),
				)),
				JsonObject(mapOf(
					"a" to JsonPrimitive(1),
					"c" to JsonPrimitive(3),
				))
			)),
			"encryptFully" to JsonArray(listOf(
				JsonObject(mapOf(
					"a" to JsonPrimitive(1),
					"b" to JsonPrimitive(2),
				)),
				JsonObject(mapOf(
					"a" to JsonPrimitive(1),
					"c" to JsonPrimitive(3),
				))
			))
		))
		val encrypted = jsonEncryptionService.encrypt(key, obj, manifest)
		encrypted.keys shouldBe setOf("encryptPartially", "encryptFully", "encryptedSelf")
		encrypted.getValue("encryptPartially").jsonArray.let { array ->
			array[0].jsonObject.keys shouldBe setOf("b", "encryptedSelf")
			array[1].jsonObject.keys shouldBe setOf("c", "encryptedSelf")
		}
		encrypted.getValue("encryptFully").jsonArray.let { array ->
			array.forEach { it.jsonObject.keys shouldBe setOf("encryptedSelf") }
		}
	}

	"Wildcard encryption: should reuse encrypted self when same".config(enabled = DEFAULT_ENABLED) {
		val key = defaultCryptoService.aes.generateKey(AesAlgorithm.CbcWithPkcs7Padding)
		val manifest = JsonEncryptionService.parseEncryptedFields(
			setOf(
				"encryptFully[].*"
			),
			"Test."
		)
		val obj1 = JsonObject(mapOf(
			"encryptFully" to JsonArray(listOf(
				JsonObject(mapOf(
					"a" to JsonPrimitive(1),
					"b" to JsonPrimitive(2),
				)),
				JsonObject(mapOf(
					"a" to JsonPrimitive(1),
					"c" to JsonPrimitive(3),
				))
			))
		))
		val encrypted1 = jsonEncryptionService.encrypt(key, obj1, manifest)
		val obj2 = JsonObject(mapOf(
			"encryptFully" to JsonArray(listOf(
				JsonObject(mapOf(
					"a" to JsonPrimitive(1),
					"b" to JsonPrimitive(2),
					"encryptedSelf" to encrypted1.getValue("encryptFully").jsonArray[0].jsonObject.getValue("encryptedSelf")
				)),
				JsonObject(mapOf(
					"a" to JsonPrimitive(1),
					"c" to JsonPrimitive(4), // changed
					"encryptedSelf" to encrypted1.getValue("encryptFully").jsonArray[1].jsonObject.getValue("encryptedSelf")
				))
			))
		))
		val encrypted2 = jsonEncryptionService.encrypt(key, obj2, manifest)
		val array1 = encrypted1.getValue("encryptFully").jsonArray
		val array2 = encrypted2.getValue("encryptFully").jsonArray
		array1[0] shouldBe array2[0]
		array1[1].jsonObject.keys shouldBe setOf("encryptedSelf")
		array2[1].jsonObject.keys shouldBe setOf("encryptedSelf")
		array1[1] shouldNotBe array2[1]
	}

	"Decrypt should be able to decrypt pieces that were encrypted with different keys".config(enabled = DEFAULT_ENABLED) {
		repeat(2000) {
			// Repeat test many times to have a high chance of decrypt with only 1 key give at least once a false
			// decryption success (AES-CBC has ~1/256 chances to seem successful even with wrong key if the structure
			// of the output is not known)
			val manifest = JsonEncryptionService.parseEncryptedFields(
				setOf("a"),
				"Test."
			)
			val key1 = defaultCryptoService.aes.generateKey(AesAlgorithm.CbcWithPkcs7Padding)
			val key2 = defaultCryptoService.aes.generateKey(AesAlgorithm.CbcWithPkcs7Padding)
			val obj1 = JsonObject(mapOf("a" to JsonPrimitive(1), "b" to JsonPrimitive(2)))
			val obj2 = JsonObject(mapOf("a" to JsonPrimitive(3), "c" to JsonPrimitive(4)))
			val encrypted = JsonObject(
				mapOf(
					"obj1" to jsonEncryptionService.encrypt(key1, obj1, manifest),
					"obj2" to jsonEncryptionService.encrypt(key2, obj2, manifest),
				)
			)
			shouldThrow<EntityEncryptionException> { jsonEncryptionService.decrypt(listOf(key1), encrypted) }
			shouldThrow<EntityEncryptionException> { jsonEncryptionService.decrypt(listOf(key2), encrypted) }
			stripEncryptedSelf(jsonEncryptionService.decrypt(listOf(key1, key2), encrypted)) shouldBe JsonObject(
				mapOf(
					"obj1" to obj1,
					"obj2" to obj2
				)
			)
		}
	}
})
