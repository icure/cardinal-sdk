package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.utils.InternalIcureApi
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

/**
 * References stored in an entity are relative to the group of the entity, while the parsed references are relative to
 * the group of the sdk (null group if the referenced entity is in the group of the sdk).
 *
 * Uses the same scenario as InterGroupOwningEntityReferenceTest: a patient in group1, contacts of the patient in group1
 * and group2, an sdk of a user of group1 and an sdk of a user of group2.
 */
@OptIn(InternalIcureApi::class)
class EntityReferenceInGroupTest : StringSpec({
	val group1 = "group1"
	val group2 = "group2"
	val sdkGroup1 = SdkBoundGroup(group1)
	val sdkGroup2 = SdkBoundGroup(group2)
	val patientId = "patient"
	val patientReference = EntityReferenceInGroup(patientId, group1)

	"Reference to an entity in the same group as the referencing entity is stored without group" {
		patientReference.asReferenceStringInGroup(group1, sdkGroup2) shouldBe patientId
		EntityReferenceInGroup(patientId, null).asReferenceStringInGroup(null, sdkGroup1) shouldBe patientId
	}

	"Reference to an entity in a different group than the referencing entity is stored with group" {
		patientReference.asReferenceStringInGroup(group2, sdkGroup2) shouldBe "$group1/$patientId"
		patientReference.asReferenceStringInGroup(null, sdkGroup2) shouldBe "$group1/$patientId"
	}

	"Reference stored in an entity of group1 to an entity of group1" {
		// Sdk of group1
		EntityReferenceInGroup.parse(patientId, null, sdkGroup1) shouldBe EntityReferenceInGroup(patientId, null)
		EntityReferenceInGroup.parse(patientId, group1, sdkGroup1) shouldBe EntityReferenceInGroup(patientId, null)
		// Sdk of group2
		EntityReferenceInGroup.parse(patientId, group1, sdkGroup2) shouldBe EntityReferenceInGroup(patientId, group1)
	}

	"Reference stored in an entity of group2 to an entity of group1" {
		// Sdk of group1
		EntityReferenceInGroup.parse("$group1/$patientId", group2, sdkGroup1) shouldBe EntityReferenceInGroup(patientId, null)
		// Sdk of group2
		EntityReferenceInGroup.parse("$group1/$patientId", null, sdkGroup2) shouldBe EntityReferenceInGroup(patientId, group1)
		EntityReferenceInGroup.parse("$group1/$patientId", group2, sdkGroup2) shouldBe EntityReferenceInGroup(patientId, group1)
	}

	"Stored references can be parsed back to the original reference" {
		listOf(null, group1, group2).forEach { entityGroup ->
			listOf(sdkGroup1, sdkGroup2).forEach { sdkGroup ->
				val stored = patientReference.asReferenceStringInGroup(entityGroup, sdkGroup)
				EntityReferenceInGroup.parse(stored, entityGroup, sdkGroup).normalized(sdkGroup) shouldBe
					patientReference.normalized(sdkGroup)
			}
		}
	}
})
