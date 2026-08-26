package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.crypto.entities.BulkShareByIdsResult
import com.icure.cardinal.sdk.crypto.entities.ContactShareOptions
import com.icure.cardinal.sdk.crypto.entities.FailedRequestDetails
import com.icure.cardinal.sdk.crypto.entities.HealthElementShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions
import com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.cardinal.sdk.model.DecryptedContact
import com.icure.cardinal.sdk.model.DecryptedHealthElement
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.requests.RequestedPermission
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.uuid
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.cardinal.sdk.utils.LOCAL_ENV_ONLY
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import io.kotest.matchers.types.shouldBeInstanceOf

/**
 * Covers `shareHealthElementsByIds`/`shareContactsByIds`, the bulk share-by-id methods that replaced
 * `PatientApi.shareAllDataOfPatient`: sharing many already-existing entities at once by id (fetching only
 * lightweight stubs server-side), with a detailed per-id/per-delegate outcome instead of an all-or-nothing
 * exception.
 */
class BulkShareByIdsTest : StringSpec({
	val specJob = autoCancelJob()

	beforeSpec {
		initializeTestEnvironment()
	}

	"sharing many health elements by id shares each of them with the delegate".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val a = createHcpUser()
		val delegate = createHcpUser()
		val aApi = a.api(specJob)
		val delegateApi = delegate.api(specJob)

		val patient = aApi.patient.createPatient(
			aApi.patient.withEncryptionMetadata(DecryptedPatient(id = uuid()))
		)
		val user = aApi.user.getCurrentUser()
		// `descr` is encrypted by default: asserting on it after the delegate reads the health element back proves
		// the delegate can actually decrypt the content, not merely that it was granted access to fetch it.
		val healthElements = (1..3).map {
			aApi.healthElement.createHealthElement(
				aApi.healthElement.withEncryptionMetadata(
					base = DecryptedHealthElement(id = uuid(), descr = uuid()),
					patient = patient,
					user = user
				)
			)
		}

		val result = aApi.healthElement.shareHealthElementsByIds(
			healthElements.map { it.id },
			mapOf(delegate.dataOwnerId to HealthElementShareOptions())
		)

		result.notFoundIds.shouldBeEmpty()
		result.shareErrors.shouldBeEmpty()
		result.successfulDelegateIdsByEntityId shouldBe healthElements.associate { it.id to setOf(delegate.dataOwnerId) }

		healthElements.forEach { he ->
			delegateApi.healthElement.getHealthElement(he.id).shouldNotBeNull().descr shouldBe he.descr
		}
	}

	"an id that doesn't exist is reported as not found without preventing the other ids from being shared".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val a = createHcpUser()
		val delegate = createHcpUser()
		val aApi = a.api(specJob)
		val delegateApi = delegate.api(specJob)

		val patient = aApi.patient.createPatient(
			aApi.patient.withEncryptionMetadata(DecryptedPatient(id = uuid()))
		)
		val user = aApi.user.getCurrentUser()
		// `descr` is encrypted by default: checking it after the delegate reads the health element back proves
		// genuine decryption, not just successful retrieval.
		val he = aApi.healthElement.createHealthElement(
			aApi.healthElement.withEncryptionMetadata(
				base = DecryptedHealthElement(id = uuid(), descr = uuid()),
				patient = patient,
				user = user
			)
		)
		val nonExistentId = uuid()

		val result = aApi.healthElement.shareHealthElementsByIds(
			listOf(he.id, nonExistentId),
			mapOf(delegate.dataOwnerId to HealthElementShareOptions())
		)

		result.notFoundIds shouldBe setOf(nonExistentId)
		result.shareErrors.shouldBeEmpty()
		result.successfulDelegateIdsByEntityId shouldBe mapOf(he.id to setOf(delegate.dataOwnerId))

		delegateApi.healthElement.getHealthElement(he.id).shouldNotBeNull().descr shouldBe he.descr
		delegateApi.healthElement.getHealthElement(nonExistentId).shouldBeNull()
	}

	"an empty id list or an empty delegates map is a no-op that makes no backend calls".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val a = createHcpUser()
		val delegate = createHcpUser()
		val aApi = a.api(specJob)

		val patient = aApi.patient.createPatient(
			aApi.patient.withEncryptionMetadata(DecryptedPatient(id = uuid()))
		)
		val he = aApi.healthElement.createHealthElement(
			aApi.healthElement.withEncryptionMetadata(
				base = DecryptedHealthElement(id = uuid()),
				patient = patient,
				user = aApi.user.getCurrentUser()
			)
		)

		val emptyIdsResult = aApi.healthElement.shareHealthElementsByIds(
			emptyList(),
			mapOf(delegate.dataOwnerId to HealthElementShareOptions())
		)
		emptyIdsResult shouldBe BulkShareByIdsResult(emptySet(), emptyMap(), emptyMap(), emptyList())

		val emptyDelegatesResult = aApi.healthElement.shareHealthElementsByIds(
			listOf(he.id),
			emptyMap()
		)
		emptyDelegatesResult shouldBe BulkShareByIdsResult(emptySet(), emptyMap(), emptyMap(), emptyList())
	}

	"sharing many contacts by id shares each of them with the delegate".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val a = createHcpUser()
		val delegate = createHcpUser()
		val aApi = a.api(specJob)
		val delegateApi = delegate.api(specJob)

		val patient = aApi.patient.createPatient(
			aApi.patient.withEncryptionMetadata(DecryptedPatient(id = uuid()))
		)
		val user = aApi.user.getCurrentUser()
		// `descr` is encrypted by default: asserting on it after the delegate reads the contact back proves the
		// delegate can actually decrypt the content, not merely that it was granted access to fetch it.
		val contacts = (1..3).map {
			aApi.contact.createContact(
				aApi.contact.withEncryptionMetadata(
					base = DecryptedContact(id = uuid(), descr = uuid()),
					patient = patient,
					user = user
				)
			)
		}

		val result = aApi.contact.shareContactsByIds(
			contacts.map { it.id },
			mapOf(delegate.dataOwnerId to ContactShareOptions())
		)

		result.notFoundIds.shouldBeEmpty()
		result.shareErrors.shouldBeEmpty()
		result.successfulDelegateIdsByEntityId shouldBe contacts.associate { it.id to setOf(delegate.dataOwnerId) }

		contacts.forEach { contact ->
			delegateApi.contact.getContact(contact.id).shouldNotBeNull().descr shouldBe contact.descr
		}
	}

	"a Required encryption key succeeds only for the health element where the current user actually has the key".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val a = createHcpUser()
		val b = createHcpUser()
		val c = createHcpUser()
		val aApi = a.api(specJob)
		val bApi = b.api(specJob)

		val patient = aApi.patient.createPatient(aApi.patient.withEncryptionMetadata(DecryptedPatient(id = uuid())))
		val user = aApi.user.getCurrentUser()
		val heFull = aApi.healthElement.createHealthElement(
			aApi.healthElement.withEncryptionMetadata(base = DecryptedHealthElement(id = uuid()), patient = patient, user = user)
		)
		val hePartial = aApi.healthElement.createHealthElement(
			aApi.healthElement.withEncryptionMetadata(base = DecryptedHealthElement(id = uuid()), patient = patient, user = user)
		)
		// B gets everything for heFull, but no encryption key at all for hePartial.
		aApi.healthElement.shareWith(b.dataOwnerId, heFull, HealthElementShareOptions())
		aApi.healthElement.shareWith(b.dataOwnerId, hePartial, HealthElementShareOptions(shareEncryptionKey = ShareMetadataBehaviour.Never))

		val result = bApi.healthElement.shareHealthElementsByIds(
			listOf(heFull.id, hePartial.id),
			mapOf(c.dataOwnerId to HealthElementShareOptions(shareEncryptionKey = ShareMetadataBehaviour.Required))
		)

		result.notFoundIds.shouldBeEmpty()
		result.successfulDelegateIdsByEntityId shouldBe mapOf(heFull.id to setOf(c.dataOwnerId))
		result.shareErrors shouldHaveSize 1
		// A resolution error is deterministic and never reaches the server.
		val error = result.shareErrors.single().shouldBeInstanceOf<FailedRequestDetails.ResolutionFailed>()
		error.entityId shouldBe hePartial.id
		error.delegateReference.entityId shouldBe c.dataOwnerId
		error.reason.shouldNotBeNull() shouldContain "encryption key"
	}

	"AllAvailable(requireAtLeastOne = true) secret ids succeeds only for the health element where a secret id is available".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val a = createHcpUser()
		val b = createHcpUser()
		val c = createHcpUser()
		val aApi = a.api(specJob)
		val bApi = b.api(specJob)

		val patient = aApi.patient.createPatient(aApi.patient.withEncryptionMetadata(DecryptedPatient(id = uuid())))
		val user = aApi.user.getCurrentUser()
		val heFull = aApi.healthElement.createHealthElement(
			aApi.healthElement.withEncryptionMetadata(base = DecryptedHealthElement(id = uuid()), patient = patient, user = user)
		)
		val hePartial = aApi.healthElement.createHealthElement(
			aApi.healthElement.withEncryptionMetadata(base = DecryptedHealthElement(id = uuid()), patient = patient, user = user)
		)
		// B gets everything for heFull, but no secret id at all for hePartial.
		aApi.healthElement.shareWith(b.dataOwnerId, heFull, HealthElementShareOptions())
		aApi.healthElement.shareWith(
			b.dataOwnerId,
			hePartial,
			HealthElementShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), createUnknownSecretIds = false))
		)

		val result = bApi.healthElement.shareHealthElementsByIds(
			listOf(heFull.id, hePartial.id),
			mapOf(c.dataOwnerId to HealthElementShareOptions(shareSecretIds = SecretIdShareOptions.AllAvailable(requireAtLeastOne = true)))
		)

		result.notFoundIds.shouldBeEmpty()
		result.successfulDelegateIdsByEntityId shouldBe mapOf(heFull.id to setOf(c.dataOwnerId))
		result.shareErrors shouldHaveSize 1
		val error = result.shareErrors.single().shouldBeInstanceOf<FailedRequestDetails.ResolutionFailed>()
		error.entityId shouldBe hePartial.id
		error.delegateReference.entityId shouldBe c.dataOwnerId
		error.reason.shouldNotBeNull() shouldContain "secret id"
	}

	"a Required owning entity id succeeds only for the health element where the patient id was actually shared".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val a = createHcpUser()
		val b = createHcpUser()
		val c = createHcpUser()
		val aApi = a.api(specJob)
		val bApi = b.api(specJob)

		val patient = aApi.patient.createPatient(aApi.patient.withEncryptionMetadata(DecryptedPatient(id = uuid())))
		val user = aApi.user.getCurrentUser()
		val heFull = aApi.healthElement.createHealthElement(
			aApi.healthElement.withEncryptionMetadata(base = DecryptedHealthElement(id = uuid()), patient = patient, user = user)
		)
		val hePartial = aApi.healthElement.createHealthElement(
			aApi.healthElement.withEncryptionMetadata(base = DecryptedHealthElement(id = uuid()), patient = patient, user = user)
		)
		// B gets everything for heFull, but the patient id is never shared for hePartial.
		aApi.healthElement.shareWith(b.dataOwnerId, heFull, HealthElementShareOptions())
		aApi.healthElement.shareWith(b.dataOwnerId, hePartial, HealthElementShareOptions(sharePatientId = ShareMetadataBehaviour.Never))

		val result = bApi.healthElement.shareHealthElementsByIds(
			listOf(heFull.id, hePartial.id),
			mapOf(c.dataOwnerId to HealthElementShareOptions(sharePatientId = ShareMetadataBehaviour.Required))
		)

		result.notFoundIds.shouldBeEmpty()
		result.successfulDelegateIdsByEntityId shouldBe mapOf(heFull.id to setOf(c.dataOwnerId))
		result.shareErrors shouldHaveSize 1
		val error = result.shareErrors.single().shouldBeInstanceOf<FailedRequestDetails.ResolutionFailed>()
		error.entityId shouldBe hePartial.id
		error.delegateReference.entityId shouldBe c.dataOwnerId
		error.reason.shouldNotBeNull() shouldContain "owning entity id"
	}

	"requesting FullWrite succeeds only for the health element where the current user itself has write access".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val a = createHcpUser()
		val b = createHcpUser()
		val c = createHcpUser()
		val aApi = a.api(specJob)
		val bApi = b.api(specJob)

		val patient = aApi.patient.createPatient(aApi.patient.withEncryptionMetadata(DecryptedPatient(id = uuid())))
		val user = aApi.user.getCurrentUser()
		val heWrite = aApi.healthElement.createHealthElement(
			aApi.healthElement.withEncryptionMetadata(base = DecryptedHealthElement(id = uuid()), patient = patient, user = user)
		)
		val heRead = aApi.healthElement.createHealthElement(
			aApi.healthElement.withEncryptionMetadata(base = DecryptedHealthElement(id = uuid()), patient = patient, user = user)
		)
		// B gets write access to heWrite, but only read access to heRead.
		aApi.healthElement.shareWith(b.dataOwnerId, heWrite, HealthElementShareOptions(requestedPermissions = RequestedPermission.FullWrite))
		aApi.healthElement.shareWith(b.dataOwnerId, heRead, HealthElementShareOptions(requestedPermissions = RequestedPermission.FullRead))
		bApi.healthElement.hasWriteAccess(bApi.healthElement.getHealthElement(heWrite.id).shouldNotBeNull()) shouldBe true
		bApi.healthElement.hasWriteAccess(bApi.healthElement.getHealthElement(heRead.id).shouldNotBeNull()) shouldBe false

		// B, who itself only has read access to heRead, can't grant C write access to it - but it can for heWrite.
		val result = bApi.healthElement.shareHealthElementsByIds(
			listOf(heWrite.id, heRead.id),
			mapOf(c.dataOwnerId to HealthElementShareOptions(requestedPermissions = RequestedPermission.FullWrite))
		)

		result.notFoundIds.shouldBeEmpty()
		result.successfulDelegateIdsByEntityId shouldBe mapOf(heWrite.id to setOf(c.dataOwnerId))
		result.shareErrors shouldHaveSize 1
		// Unlike the local resolution errors above, this request was actually sent to and rejected by the server.
		val error = result.shareErrors.single().shouldBeInstanceOf<FailedRequestDetails.RequestRejected>()
		error.entityId shouldBe heRead.id
		error.delegateReference.entityId shouldBe c.dataOwnerId
	}

	"when one delegate already has everything and another needs a genuine update, only the latter is a fresh share while the former is reported as unmodified".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val a = createHcpUser()
		val d1 = createHcpUser()
		val d2 = createHcpUser()
		val aApi = a.api(specJob)

		val patient = aApi.patient.createPatient(aApi.patient.withEncryptionMetadata(DecryptedPatient(id = uuid())))
		val he = aApi.healthElement.createHealthElement(
			aApi.healthElement.withEncryptionMetadata(base = DecryptedHealthElement(id = uuid()), patient = patient, user = aApi.user.getCurrentUser())
		)
		// D1 already has everything shared beforehand; D2 has never seen this health element.
		aApi.healthElement.shareWith(d1.dataOwnerId, he, HealthElementShareOptions())

		// A single call targeting both delegates at once for the same entity: D1's request has nothing left to add
		// (already fully satisfied) while D2's is a genuinely new share.
		val result = aApi.healthElement.shareHealthElementsByIds(
			listOf(he.id),
			mapOf(
				d1.dataOwnerId to HealthElementShareOptions(),
				d2.dataOwnerId to HealthElementShareOptions()
			)
		)

		result.notFoundIds.shouldBeEmpty()
		result.shareErrors.shouldBeEmpty()
		// Both pairs are accounted for, in different buckets - neither silently disappears.
		result.successfulDelegateIdsByEntityId shouldBe mapOf(he.id to setOf(d2.dataOwnerId))
		result.unmodifiedDelegateIdsByEntityId shouldBe mapOf(he.id to setOf(d1.dataOwnerId))
	}
})
