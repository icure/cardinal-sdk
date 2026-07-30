package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.model.DecryptedCalendarItem
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.uuid
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.shouldBe

class CalendarItemLinkToPatientTest : StringSpec({
	val specJob = autoCancelJob()

	beforeSpec {
		initializeTestEnvironment()
	}

	suspend fun createPatientWithApi(api: CardinalSdk): DecryptedPatient =
		api.patient.createPatient(
			api.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = uuid(),
					firstName = "John",
					lastName = "Doe",
				)
			)
		)

	"Should be able to link a calendar item without a linked patient to a patient".config(enabled = DEFAULT_ENABLED) {
		val api = createHcpUser().api(specJob)
		val patient = createPatientWithApi(api)
		val calendarItem = api.calendarItem.createCalendarItem(
			api.calendarItem.withEncryptionMetadata(
				DecryptedCalendarItem(
					id = uuid(),
					title = "Unlinked calendar item",
				),
				patient = null,
			)
		)
		calendarItem.secretForeignKeys.shouldBeEmpty()
		val linked = api.calendarItem.linkToPatient(calendarItem, patient, emptySet())
		linked.secretForeignKeys shouldBe api.patient.getSecretIdsOf(patient).keys
		api.calendarItem.decryptPatientIdOf(linked) shouldBe setOf(EntityReferenceInGroup(patient.id, null))
	}

	"Linking a calendar item that is already linked to a patient should fail".config(enabled = DEFAULT_ENABLED) {
		val api = createHcpUser().api(specJob)
		val patient = createPatientWithApi(api)
		val calendarItem = api.calendarItem.createCalendarItem(
			api.calendarItem.withEncryptionMetadata(
				DecryptedCalendarItem(
					id = uuid(),
					title = "Linked calendar item",
				),
				patient,
			)
		)
		shouldThrow<IllegalArgumentException> {
			api.calendarItem.linkToPatient(calendarItem, patient, emptySet())
		}
	}
})
