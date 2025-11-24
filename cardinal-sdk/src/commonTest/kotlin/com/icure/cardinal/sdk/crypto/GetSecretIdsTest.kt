package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.crypto.entities.PatientShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.uuid
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.maps.shouldContainKey
import io.kotest.matchers.maps.shouldHaveSize
import io.kotest.matchers.shouldBe

class GetSecretIdsTest : StringSpec({
	val job = autoCancelJob()

	"Get secret ids method should provide the data owners that are known to have access to each available secret id".config(enabled = DEFAULT_ENABLED) {
		val parent = createHcpUser()
		val child1 = createHcpUser(parent)
		val child2 = createHcpUser(parent)
		val other = createHcpUser()
		val child1Api = child1.api(job)
		var patient = child1Api.patient.createPatient(
			child1Api.patient.withEncryptionMetadata(DecryptedPatient(id = uuid(), firstName = "John", lastName = "Doe"))
		)
		val secretIdSharedWithParent = uuid()
		patient = child1Api.patient.shareWith(
			parent.dataOwnerId,
			patient,
			PatientShareOptions(
				shareSecretIds = SecretIdShareOptions.UseExactly(setOf(secretIdSharedWithParent), true)
			)
		)
		val secretIdSharedWithOther = uuid()
		patient = child1Api.patient.shareWith(
			other.dataOwnerId,
			patient,
			PatientShareOptions(
				shareSecretIds = SecretIdShareOptions.UseExactly(setOf(secretIdSharedWithOther), true)
			)
		)
		child1Api.patient.getSecretIdsOf(patient).also { secretIdsInfo ->
			secretIdsInfo shouldHaveSize 3
			secretIdsInfo shouldContainKey secretIdSharedWithOther
			secretIdsInfo shouldContainKey secretIdSharedWithParent
			secretIdsInfo.entries.single { it.key != secretIdSharedWithOther && it.key != secretIdSharedWithParent }.value shouldBe setOf(
				EntityReferenceInGroup(child1.dataOwnerId, null)
			)
			secretIdsInfo.getValue(secretIdSharedWithParent) shouldBe setOf(
				EntityReferenceInGroup(child1.dataOwnerId, null),
				EntityReferenceInGroup(parent.dataOwnerId, null)
			)
			secretIdsInfo.getValue(secretIdSharedWithOther) shouldBe setOf(
				EntityReferenceInGroup(child1.dataOwnerId, null),
				EntityReferenceInGroup(other.dataOwnerId, null)
			)
		}
		child2.api(job).patient.getSecretIdsOf(patient).also { secretIdsInfo ->
			secretIdsInfo shouldHaveSize 1
			secretIdsInfo shouldContainKey secretIdSharedWithParent
			secretIdsInfo.values.single() shouldBe setOf(
				EntityReferenceInGroup(child1.dataOwnerId, null),
				EntityReferenceInGroup(parent.dataOwnerId, null)
			)
		}
		other.api(job).patient.getSecretIdsOf(patient).also { secretIdsInfo ->
			secretIdsInfo shouldHaveSize 1
			secretIdsInfo shouldContainKey secretIdSharedWithOther
			secretIdsInfo.values.single() shouldBe setOf(
				EntityReferenceInGroup(child1.dataOwnerId, null),
				EntityReferenceInGroup(other.dataOwnerId, null)
			)
		}
	}
})