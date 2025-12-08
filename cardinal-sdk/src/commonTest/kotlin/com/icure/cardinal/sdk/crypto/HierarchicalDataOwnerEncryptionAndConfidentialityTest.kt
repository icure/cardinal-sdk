package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.model.DecryptedHealthElement
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.cardinal.sdk.utils.RequestStatusException
import com.icure.cardinal.sdk.utils.pagination.forEach
import com.icure.kryptom.crypto.defaultCryptoService
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

class HierarchicalDataOwnerEncryptionAndConfidentialityTest : StringSpec({
	val specJob = autoCancelJob()

	beforeSpec {
		initializeTestEnvironment()
	}

	"Child hcp should be able to share existing data he can access through parent".config(enabled = DEFAULT_ENABLED) {
		val parent = createHcpUser()
		val hcp = createHcpUser(parent)
		val sibling = createHcpUser(parent)
		val other = createHcpUser()
		val siblingApi = hcp.api(specJob)
		val note = "This will be encrypted"
		val patient = siblingApi.patient.createPatient(
			siblingApi.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = defaultCryptoService.strongRandom.randomUUID(),
					firstName = "John",
					lastName = "Doe",
					note = note
				),
				delegates = mapOf(parent.dataOwnerId to AccessLevel.Write)
			)
		).shouldNotBeNull()
		val hcpApi = hcp.api(specJob)
		val shared = hcpApi.patient.shareWith(
			other.dataOwnerId,
			hcpApi.patient.getPatient(patient.id).shouldNotBeNull()
		)
		val retrievedByOther = other.api(specJob).patient.getPatient(patient.id)
		retrievedByOther shouldBe shared
	}

	"Data shared with a parent hcp should be accessible to the parent and siblings, but not to the grandparent".config(enabled = DEFAULT_ENABLED) {
		val grandparent = createHcpUser()
		val parent = createHcpUser(grandparent)
		val hcp = createHcpUser(parent)
		val sibling = createHcpUser(parent)
		val hcpApi = hcp.api(specJob)
		val note = "This will be encrypted"
		val patient = hcpApi.patient.createPatient(
			hcpApi.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = defaultCryptoService.strongRandom.randomUUID(),
					firstName = "John",
					lastName = "Doe",
					note = note
				),
				delegates = mapOf(parent.dataOwnerId to AccessLevel.Write)
			)
		).shouldNotBeNull()
		parent.api(specJob).patient.getPatient(patient.id).shouldNotBeNull().note shouldBe note
		sibling.api(specJob).patient.getPatient(patient.id).shouldNotBeNull().note shouldBe note
		shouldThrow<RequestStatusException> {
			grandparent.api(specJob).patient.getPatient(patient.id)
		}.statusCode shouldBe 403
	}

	"Data shared using non confidential sfk should be findable by siblings. Data shared with confidential sfk should not.".config(enabled = DEFAULT_ENABLED) {
		val parent = createHcpUser()
		val hcp = createHcpUser(parent)
		val sibling = createHcpUser(parent)
		val hcpApi = hcp.api(specJob)
		val patient = hcpApi.patient.createPatient(
			hcpApi.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = defaultCryptoService.strongRandom.randomUUID(),
					firstName = "John",
					lastName = "Doe",
					note = "This will be encrypted"
				),
				delegates = mapOf(parent.dataOwnerId to AccessLevel.Write)
			)
		).shouldNotBeNull().let { hcpApi.patient.initializeConfidentialSecretId(it) }
		val confidentialSecretIds = hcpApi.patient.getConfidentialSecretIdsOf(patient)
		val allSecretIds = hcpApi.patient.getSecretIdsOf(patient).keys
		allSecretIds shouldHaveSize 2
		confidentialSecretIds shouldHaveSize 1
		allSecretIds shouldContain confidentialSecretIds.single()
		val nonConfidentialNote = "Encrypted - non confidential he"
		val nonConfidentialHe = hcpApi.healthElement.createHealthElement(
			hcpApi.healthElement.withEncryptionMetadata(
                DecryptedHealthElement(
                    id = defaultCryptoService.strongRandom.randomUUID(),
                    note = nonConfidentialNote
                ),
                patient,
                hcpApi.user.getCurrentUser(),
                mapOf(parent.dataOwnerId to AccessLevel.Write)
			)
		).shouldNotBeNull()
		val confidentialNote = "Encrypted - confidential he"
		val confidentialHe = hcpApi.healthElement.createHealthElement(
			hcpApi.healthElement.withEncryptionMetadata(
                DecryptedHealthElement(
                    id = defaultCryptoService.strongRandom.randomUUID(),
                    note = confidentialNote
                ),
                patient,
                hcpApi.user.getCurrentUser(),
                mapOf(parent.dataOwnerId to AccessLevel.Write),
                SecretIdUseOption.UseAnyConfidential
			)
		).shouldNotBeNull()

		suspend fun findHealthElementsFor(
			hcpIds: List<String>,
			api: CardinalSdk
		): List<DecryptedHealthElement> {
			val hes = mutableListOf<DecryptedHealthElement>()

			hcpIds.forEach { hcpId ->
				val iterator = api.healthElement.findHealthElementsByHcPartyPatient(hcpId, patient)
				iterator.forEach { element ->
					if (hes.all { it.id != element.id }) {
						hes.add(element)
					}
				}
			}

			return hes
		}



		findHealthElementsFor(listOf(hcp.dataOwnerId, parent.dataOwnerId), hcpApi).also { retrievedHes ->
			retrievedHes shouldHaveSize 2
			retrievedHes.map { it.id } shouldContainExactlyInAnyOrder listOf(nonConfidentialHe.id, confidentialHe.id)
			retrievedHes.single { it.id == nonConfidentialHe.id }.note shouldBe nonConfidentialNote
			retrievedHes.single { it.id == confidentialHe.id }.note shouldBe confidentialNote
		}
		listOf(
			Pair(parent.api(specJob), listOf(parent.dataOwnerId)),
			Pair(sibling.api(specJob), listOf(parent.dataOwnerId, sibling.dataOwnerId))
		).forEach { (relativeApi, ids) ->
			relativeApi.patient.getSecretIdsOf(patient).keys shouldBe (allSecretIds - confidentialSecretIds)
			findHealthElementsFor(ids, relativeApi).also { retrievedHes ->
				retrievedHes shouldHaveSize 1
				retrievedHes.single().id shouldBe nonConfidentialHe.id
				retrievedHes.single().note shouldBe nonConfidentialNote
			}
			// Entity was still shared, so it can still be retrieved by id (not a real use case, would not make sense to share an entity that is confidential)
			relativeApi.healthElement.getHealthElement(confidentialHe.id).shouldNotBeNull().note shouldBe confidentialNote
		}
	}
})
