package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.cardinal.sdk.utils.Serialization
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.maps.shouldHaveSize
import io.kotest.matchers.shouldBe

/**
 * The `content` of a [Service] is a `Map<String, DecryptedContent>` keyed by language/content key.
 * This payload comes from a real legacy medication and includes several keys on `medicationValue`
 * that the current [Medication] model no longer declares (`options`, `suspension`, `beginCondition`,
 * `endCondition`, `idOnSafes`, `safeIdName`, `timestampOnSafe`).
 */
private const val CONTENT_JSON = """{
	"documentId": {
		"documentId": "ab48a13d-97e6-4d7c-a2ad-a3f5e3417aab"
	},
	"format": {
		"stringValue": "A4"
	},
	"medication": {
		"medicationValue": {
			"beginCondition": null,
			"beginMoment": 20250422,
			"commentForDelivery": "",
			"drugRoute": "Voie orale",
			"duration": {
				"unit": {
					"code": "d",
					"type": "CD-TIMEUNIT"
				},
				"value": 7
			},
			"endCondition": null,
			"endExecutionMoment": 20250721,
			"endMoment": 20250429,
			"frequency": {
				"code": "D",
				"id": "CD-PERIODICITY|D|1",
				"type": "CD-PERIODICITY",
				"version": "1"
			},
			"idOnSafes": null,
			"instructionForPatient": "compr., prendre/avaler, durée: 7 jours",
			"instructionForReimbursement": null,
			"medicinalProduct": {
				"intendedcds": [
					{
						"code": "4423166",
						"type": "CD-DRUG-CNK"
					},
					{
						"code": "16279",
						"type": "CD-VMPGROUP"
					},
					{
						"code": "17343",
						"type": "CD-VMP"
					},
					{
						"code": "584595-07",
						"type": "CD-CTI-EXTENDED"
					},
					{
						"code": "M01AE01",
						"type": "CD-ATC"
					}
				],
				"intendedname": "Ibuprofen AB 400 mg compr. pellic. 100"
			},
			"numberOfPackages": 1,
			"options": {
				"administrationMode": {
					"stringValue": "Comprimé pelliculé"
				},
				"administrationModeCode": {
					"stringValue": "110"
				},
				"administrationModeCodeV1": {
					"stringValue": "00005"
				},
				"contentQuantity": {
					"numberValue": 100
				},
				"contentQuantityString": {
					"stringValue": "100"
				},
				"noMeal": {
					"booleanValue": true
				},
				"routeOfAdministrationCode": {
					"stringValue": "57"
				},
				"routeOfAdministrationCodeV1": {
					"stringValue": "00060"
				},
				"type": {
					"stringValue": "SPE"
				}
			},
			"posology": "",
			"regimen": [],
			"safeIdName": null,
			"substitutionAllowed": true,
			"suspension": [],
			"temporality": null,
			"timestampOnSafe": null
		}
	}
}"""

class ContentDeserializationTest : StringSpec({

	"Legacy medication content should deserialize to Map<String, DecryptedContent> with lenient JSON".config(enabled = DEFAULT_ENABLED) {
		val content: Map<String, DecryptedContent> =
			Serialization.lenientJson.decodeFromString(CONTENT_JSON)

		content shouldHaveSize 3
		content.keys shouldContainExactlyInAnyOrder setOf("documentId", "format", "medication")

		content.getValue("documentId") shouldBe DecryptedContent(
			documentId = "ab48a13d-97e6-4d7c-a2ad-a3f5e3417aab",
		)

		content.getValue("format") shouldBe DecryptedContent(stringValue = "A4")

		val medication = content.getValue("medication").medicationValue!!
		medication.beginMoment shouldBe 20250422L
		medication.endMoment shouldBe 20250429L
		medication.endExecutionMoment shouldBe 20250721L
		medication.commentForDelivery shouldBe ""
		medication.drugRoute shouldBe "Voie orale"
		medication.instructionForPatient shouldBe "compr., prendre/avaler, durée: 7 jours"
		medication.instructionForReimbursement shouldBe null
		medication.numberOfPackages shouldBe 1
		medication.posology shouldBe ""
		medication.substitutionAllowed shouldBe true
		medication.temporality shouldBe null
		medication.regimen shouldBe emptyList()

		medication.duration shouldBe Duration(
			value = 7.0,
			unit = CodeStub(code = "d", type = "CD-TIMEUNIT"),
		)

		medication.frequency shouldBe CodeStub(
			id = "CD-PERIODICITY|D|1",
			type = "CD-PERIODICITY",
			code = "D",
			version = "1",
		)

		medication.medicinalProduct!!.intendedname shouldBe "Ibuprofen AB 400 mg compr. pellic. 100"
		medication.medicinalProduct!!.intendedcds shouldContainExactly listOf(
			CodeStub(code = "4423166", type = "CD-DRUG-CNK"),
			CodeStub(code = "16279", type = "CD-VMPGROUP"),
			CodeStub(code = "17343", type = "CD-VMP"),
			CodeStub(code = "584595-07", type = "CD-CTI-EXTENDED"),
			CodeStub(code = "M01AE01", type = "CD-ATC"),
		)
	}

	// Documents the current behaviour: the strict (default) Json used for backend responses rejects
	// this payload because of the legacy `options`/`suspension`/... keys that are no longer modelled.
	"Strict JSON rejects legacy medication keys not present in the model".config(enabled = DEFAULT_ENABLED) {
		shouldThrowAny {
			Serialization.json.decodeFromString<Map<String, DecryptedContent>>(CONTENT_JSON)
		}
	}
})