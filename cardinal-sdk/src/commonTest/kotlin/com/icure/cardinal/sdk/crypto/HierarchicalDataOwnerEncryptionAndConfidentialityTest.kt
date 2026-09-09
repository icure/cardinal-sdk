package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.crypto.entities.PatientShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.filters.HealthElementFilters
import com.icure.cardinal.sdk.model.DecryptedHealthElement
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.cardinal.sdk.utils.LOCAL_ENV_ONLY
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

/**
 * Finds the health elements linked to [patient] that are reachable through [api], searching once for each id in
 * [hcpIds] (which must all be part of [api]'s own hierarchy, be it the current data owner itself or one of its
 * ancestors) and merging the results, deduplicated by id.
 */
private suspend fun findHealthElementsFor(
	api: CardinalSdk,
	patient: Patient,
	hcpIds: List<String>
): List<DecryptedHealthElement> {
	val hes = mutableListOf<DecryptedHealthElement>()
	hcpIds.forEach { hcpId ->
		val iterator = api.healthElement.filterHealthElementsBy(
			HealthElementFilters.byPatientsForDataOwner(hcpId, listOf(patient))
		)
		iterator.forEach { element ->
			if (hes.all { it.id != element.id }) {
				hes.add(element)
			}
		}
	}
	return hes
}

class HierarchicalDataOwnerEncryptionAndConfidentialityTest : StringSpec({
	val specJob = autoCancelJob()

	beforeSpec {
		initializeTestEnvironment()
	}

	"Child hcp should be able to share existing data he can access through parent".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val parent = createHcpUser()
		val hcp = createHcpUser(parent)
		val sibling = createHcpUser(parent)
		val other = createHcpUser()
		val siblingApi = sibling.api(specJob)
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

	"Data shared with a parent hcp should be accessible to the parent and siblings, but not to the grandparent".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
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

	"Data shared using non confidential sfk should be findable by siblings. Data shared with confidential sfk should not.".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val parent = createHcpUser()
		val hcp = createHcpUser(parent)
		val sibling = createHcpUser(parent)
		val hcpApi = hcp.api(specJob)
		val (patient, confidentialSecretId) = hcpApi.patient.createPatient(
			hcpApi.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = defaultCryptoService.strongRandom.randomUUID(),
					firstName = "John",
					lastName = "Doe",
					note = "This will be encrypted"
				),
				delegates = mapOf(parent.dataOwnerId to AccessLevel.Write)
			)
		).shouldNotBeNull().let { hcpApi.patient.createNewSecretId(it) }
		val allSecretIds = hcpApi.patient.getSecretIdsOf(patient).keys
		allSecretIds shouldHaveSize 2
		allSecretIds shouldContain confidentialSecretId
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
				SecretIdUseOption.Use(setOf(confidentialSecretId))
			)
		).shouldNotBeNull()

		findHealthElementsFor(hcpApi, patient, listOf(hcp.dataOwnerId, parent.dataOwnerId)).also { retrievedHes ->
			retrievedHes shouldHaveSize 2
			retrievedHes.map { it.id } shouldContainExactlyInAnyOrder listOf(nonConfidentialHe.id, confidentialHe.id)
			retrievedHes.single { it.id == nonConfidentialHe.id }.note shouldBe nonConfidentialNote
			retrievedHes.single { it.id == confidentialHe.id }.note shouldBe confidentialNote
		}
		listOf(
			Pair(parent.api(specJob), listOf(parent.dataOwnerId)),
			Pair(sibling.api(specJob), listOf(parent.dataOwnerId, sibling.dataOwnerId))
		).forEach { (relativeApi, ids) ->
			relativeApi.patient.getSecretIdsOf(patient).keys shouldBe (allSecretIds - confidentialSecretId)
			findHealthElementsFor(relativeApi, patient, ids).also { retrievedHes ->
				retrievedHes shouldHaveSize 1
				retrievedHes.single().id shouldBe nonConfidentialHe.id
				retrievedHes.single().note shouldBe nonConfidentialNote
			}
			// Entity was still shared, so it can still be retrieved by id (not a real use case, would not make sense to share an entity that is confidential)
			relativeApi.healthElement.getHealthElement(confidentialHe.id).shouldNotBeNull().note shouldBe confidentialNote
		}
	}

	"In a hierarchy with two parents, data shared with only one parent is discoverable only through that parent (and its own descendants), not through the other".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val px = createHcpUser()
		val py = createHcpUser()
		val a = createHcpUser(parents = listOf(px, py))
		val x = createHcpUser(px)
		val y = createHcpUser(py)
		val aApi = a.api(specJob)

		val patient = aApi.patient.createPatient(
			aApi.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = defaultCryptoService.strongRandom.randomUUID(),
					firstName = "John",
					lastName = "Doe"
				),
				// The secret id generated at creation is shared with PX, but not with PY.
				delegates = mapOf(px.dataOwnerId to AccessLevel.Write)
			)
		).shouldNotBeNull()
		val secretIdForPx = aApi.patient.getSecretIdsOf(patient).keys.single()

		// A second secret id, shared with PY only. `shareSecretIds` must be specified explicitly: the default for
		// `shareWith` (`SecretIdShareOptions.AllAvailable`) would also re-share `secretIdForPx` with PY.
		val (patientWithSecondSecretId, secretIdForPy) = aApi.patient.createNewSecretId(patient)
		val fullyShared = aApi.patient.shareWith(
			py.dataOwnerId,
			patientWithSecondSecretId,
			PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(setOf(secretIdForPy), false))
		)

		// Both health elements are shared with PX and PY directly, so either could decrypt either one: what
		// differs is which secret id links each health element to the patient, and thus which of PX/PY (and
		// their own descendants) can find it through a patient-based search.
		val noteForPxSide = "Linked using the secret id known only to PX"
		val heForPxSide = aApi.healthElement.createHealthElement(
			aApi.healthElement.withEncryptionMetadata(
				DecryptedHealthElement(id = defaultCryptoService.strongRandom.randomUUID(), note = noteForPxSide),
				fullyShared,
				null,
				mapOf(px.dataOwnerId to AccessLevel.Write, py.dataOwnerId to AccessLevel.Write),
				SecretIdUseOption.Use(setOf(secretIdForPx))
			)
		).shouldNotBeNull()
		val noteForPySide = "Linked using the secret id known only to PY"
		val heForPySide = aApi.healthElement.createHealthElement(
			aApi.healthElement.withEncryptionMetadata(
				DecryptedHealthElement(id = defaultCryptoService.strongRandom.randomUUID(), note = noteForPySide),
				fullyShared,
				null,
				mapOf(px.dataOwnerId to AccessLevel.Write, py.dataOwnerId to AccessLevel.Write),
				SecretIdUseOption.Use(setOf(secretIdForPy))
			)
		).shouldNotBeNull()

		findHealthElementsFor(px.api(specJob), fullyShared, listOf(px.dataOwnerId)).map { it.id } shouldBe listOf(heForPxSide.id)
		findHealthElementsFor(x.api(specJob), fullyShared, listOf(px.dataOwnerId)).map { it.id } shouldBe listOf(heForPxSide.id)
		findHealthElementsFor(py.api(specJob), fullyShared, listOf(py.dataOwnerId)).map { it.id } shouldBe listOf(heForPySide.id)
		findHealthElementsFor(y.api(specJob), fullyShared, listOf(py.dataOwnerId)).map { it.id } shouldBe listOf(heForPySide.id)
	}

	"Data created by a child and shared with its own parent is readable by another child that has the same data owner among its (possibly several) parents".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val px = createHcpUser()
		val py = createHcpUser()
		val a = createHcpUser(parents = listOf(px, py))
		val x = createHcpUser(px)
		val y = createHcpUser(py)
		val xApi = x.api(specJob)
		val yApi = y.api(specJob)
		val aApi = a.api(specJob)

		val noteFromX = "Created by X, shared with PX"
		val patientFromX = xApi.patient.createPatient(
			xApi.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = defaultCryptoService.strongRandom.randomUUID(),
					firstName = "John",
					lastName = "Doe",
					note = noteFromX
				),
				delegates = mapOf(px.dataOwnerId to AccessLevel.Write)
			)
		).shouldNotBeNull()
		val noteFromY = "Created by Y, shared with PY"
		val patientFromY = yApi.patient.createPatient(
			yApi.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = defaultCryptoService.strongRandom.randomUUID(),
					firstName = "Jane",
					lastName = "Doe",
					note = noteFromY
				),
				delegates = mapOf(py.dataOwnerId to AccessLevel.Write)
			)
		).shouldNotBeNull()

		// A holds both PX's and PY's keys, so it can reach data shared with either one, regardless of which of its
		// (several) parents actually received the delegation.
		aApi.patient.getPatient(patientFromX.id).shouldNotBeNull().note shouldBe noteFromX
		aApi.patient.getPatient(patientFromY.id).shouldNotBeNull().note shouldBe noteFromY
		// PY, on the other hand, has no visibility into what was only shared with PX, and vice versa.
		shouldThrow<RequestStatusException> {
			py.api(specJob).patient.getPatient(patientFromX.id)
		}.statusCode shouldBe 403
		shouldThrow<RequestStatusException> {
			px.api(specJob).patient.getPatient(patientFromY.id)
		}.statusCode shouldBe 403
	}

	"When using the default (shared-with-hierarchy) SecretIdUseOption, a secret id must be known to every parent, not just one, or the linking fails".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val px = createHcpUser()
		val py = createHcpUser()
		val a = createHcpUser(parents = listOf(px, py))
		val aApi = a.api(specJob)

		val patient = aApi.patient.createPatient(
			aApi.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = defaultCryptoService.strongRandom.randomUUID(),
					firstName = "John",
					lastName = "Doe"
				),
				delegates = mapOf(px.dataOwnerId to AccessLevel.Write)
			)
		).shouldNotBeNull()

		// The only known secret id is shared with PX but not PY: the default option - which requires a secret id
		// shared with every leaf ancestor of A's hierarchy, i.e. both PX and PY - can't find anything valid to use.
		shouldThrow<IllegalArgumentException> {
			aApi.healthElement.withEncryptionMetadata(
				DecryptedHealthElement(id = defaultCryptoService.strongRandom.randomUUID(), note = "should not be created"),
				patient,
				null,
				mapOf(px.dataOwnerId to AccessLevel.Write, py.dataOwnerId to AccessLevel.Write)
				// secretId left at its default: SecretIdUseOption.UseAnySharedWithHierarchy
			)
		}

		// Sharing that same secret id with PY too makes it satisfy "shared with the entire hierarchy": the
		// default option now finds it and succeeds.
		val secretId = aApi.patient.getSecretIdsOf(patient).keys.single()
		val fullyShared = aApi.patient.shareWith(
			py.dataOwnerId,
			patient,
			PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(setOf(secretId), false))
		)
		aApi.healthElement.createHealthElement(
			aApi.healthElement.withEncryptionMetadata(
				DecryptedHealthElement(id = defaultCryptoService.strongRandom.randomUUID(), note = "should be created"),
				fullyShared,
				null,
				mapOf(px.dataOwnerId to AccessLevel.Write, py.dataOwnerId to AccessLevel.Write)
			)
		).shouldNotBeNull()
	}

	"The default SecretIdUseOption picks a secret id valid for the entire hierarchy even when a more recent, not fully shared, secret id also exists".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val px = createHcpUser()
		val py = createHcpUser()
		val a = createHcpUser(parents = listOf(px, py))
		val x = createHcpUser(px)
		val y = createHcpUser(py)
		val aApi = a.api(specJob)

		val patient = aApi.patient.createPatient(
			aApi.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = defaultCryptoService.strongRandom.randomUUID(),
					firstName = "John",
					lastName = "Doe"
				),
				// The secret id generated at creation is shared with both parents right away.
				delegates = mapOf(px.dataOwnerId to AccessLevel.Write, py.dataOwnerId to AccessLevel.Write)
			)
		).shouldNotBeNull()

		// A second secret id, known only to A and (after an explicit share) PX: on its own this one would not
		// satisfy the "shared with the entire hierarchy" requirement.
		val (patientWithSecondSecretId, pxOnlySecretId) = aApi.patient.createNewSecretId(patient)
		val updatedPatient = aApi.patient.shareWith(
			px.dataOwnerId,
			patientWithSecondSecretId,
			PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(setOf(pxOnlySecretId), false))
		)

		val he = aApi.healthElement.createHealthElement(
			aApi.healthElement.withEncryptionMetadata(
				DecryptedHealthElement(id = defaultCryptoService.strongRandom.randomUUID(), note = "linked using the default option"),
				updatedPatient,
				null,
				mapOf(px.dataOwnerId to AccessLevel.Write, py.dataOwnerId to AccessLevel.Write)
				// secretId left at its default: SecretIdUseOption.UseAnySharedWithHierarchy
			)
		).shouldNotBeNull()

		// Whichever secret id the SDK actually picked, it must be the one shared with the entire hierarchy: only
		// that one is also known to PY (and Y), so the health element must be findable from either side.
		findHealthElementsFor(px.api(specJob), updatedPatient, listOf(px.dataOwnerId)).map { it.id } shouldBe listOf(he.id)
		findHealthElementsFor(x.api(specJob), updatedPatient, listOf(px.dataOwnerId)).map { it.id } shouldBe listOf(he.id)
		findHealthElementsFor(py.api(specJob), updatedPatient, listOf(py.dataOwnerId)).map { it.id } shouldBe listOf(he.id)
		findHealthElementsFor(y.api(specJob), updatedPatient, listOf(py.dataOwnerId)).map { it.id } shouldBe listOf(he.id)
	}

	"In a longer, unbalanced hierarchy the default SecretIdUseOption checks against the topmost ancestors, not the intermediate ones".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		// G0, G1: the two topmost ancestors (no parents of their own) - the leaves of the hierarchy rooted on Child.
		// M1: a single-parent child of G1.
		// G2: a single-parent child of G0, one level further from Child than G1 is.
		// M2: a child of both G1 and G2 - so G1 is reachable from Child through two different paths of different
		// length (directly, and through the longer M2->G2->G0 branch), while G0 is only reachable the long way.
		// Child: a child of both M1 and M2, the data owner the hierarchy is rooted on.
		val g0 = createHcpUser()
		val g1 = createHcpUser()
		val g2 = createHcpUser(g0)
		val m1 = createHcpUser(g1)
		val m2 = createHcpUser(parents = listOf(g1, g2))
		val child = createHcpUser(parents = listOf(m1, m2))
		val childApi = child.api(specJob)

		val patient = childApi.patient.createPatient(
			childApi.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = defaultCryptoService.strongRandom.randomUUID(),
					firstName = "John",
					lastName = "Doe"
				),
				delegates = mapOf(m1.dataOwnerId to AccessLevel.Write, m2.dataOwnerId to AccessLevel.Write)
			)
		).shouldNotBeNull()

		// The only known secret id is shared with the intermediate parents M1 and M2, but not with the topmost
		// ancestors G0 and G1: the default option still finds nothing valid to use.
		shouldThrow<IllegalArgumentException> {
			childApi.healthElement.withEncryptionMetadata(
				DecryptedHealthElement(id = defaultCryptoService.strongRandom.randomUUID(), note = "should not be created"),
				patient,
				null,
				mapOf(m1.dataOwnerId to AccessLevel.Write, m2.dataOwnerId to AccessLevel.Write)
			)
		}

		// Sharing the same secret id with both topmost ancestors satisfies the default option, even though one is
		// one level further away than the other. G1 is reachable through both the M1 and the M2 branch, but it
		// only needs to be shared with once.
		val secretId = childApi.patient.getSecretIdsOf(patient).keys.single()
		val fullyShared = childApi.patient.shareWith(
			g1.dataOwnerId,
			patient,
			PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(setOf(secretId), false))
		).let {
			childApi.patient.shareWith(
				g0.dataOwnerId,
				it,
				PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(setOf(secretId), false))
			)
		}
		childApi.healthElement.createHealthElement(
			childApi.healthElement.withEncryptionMetadata(
				DecryptedHealthElement(id = defaultCryptoService.strongRandom.randomUUID(), note = "should be created"),
				fullyShared,
				null,
				mapOf(m1.dataOwnerId to AccessLevel.Write, m2.dataOwnerId to AccessLevel.Write)
			)
		).shouldNotBeNull()
	}

	"In a longer hierarchy, access shared with one intermediate branch does not leak into an unrelated sibling branch, but does reach a common descendant".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		// M1 and M2 are two unrelated intermediate data owners (each could stand for its own sub-hierarchy).
		// M1SiblingA and m1SiblingB are two leaf children of M1 only; m2Child is a leaf child of M2 only; commonChild
		// is a leaf child of both M1 and M2. M1/M2 are never real actors themselves - as with every other test in
		// this file, the data is created and shared by an actual leaf data owner, not by an ancestor: an ancestor
		// creating data would trivially have implicit creator access to all of its own descendants, which would
		// defeat the point of this test.
		val m1 = createHcpUser()
		val m2 = createHcpUser()
		val m1SiblingA = createHcpUser(m1)
		val m1SiblingB = createHcpUser(m1)
		val m2Child = createHcpUser(m2)
		val commonChild = createHcpUser(parents = listOf(m1, m2))

		val m1SiblingAApi = m1SiblingA.api(specJob)
		val note = "shared only with M1"
		val patient = m1SiblingAApi.patient.createPatient(
			m1SiblingAApi.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = defaultCryptoService.strongRandom.randomUUID(),
					firstName = "John",
					lastName = "Doe",
					note = note
				),
				delegates = mapOf(m1.dataOwnerId to AccessLevel.Write)
			)
		).shouldNotBeNull()

		// M1SiblingB is an unrelated child of M1 (a sibling of the creator), so it can access the data only through
		// M1's own delegation - the same relationship already covered by "shared with a parent is accessible to
		// siblings" above, but here M1 is an intermediate node rather than a root.
		m1SiblingB.api(specJob).patient.getPatient(patient.id).shouldNotBeNull().note shouldBe note
		// commonChild is a descendant of M1 (one of its two parents), so it also inherits M1's access.
		commonChild.api(specJob).patient.getPatient(patient.id).shouldNotBeNull().note shouldBe note
		// M2Child is not a descendant of M1 at all - it's an unrelated child of M2 - so sharing with M1 alone never
		// reaches it.
		shouldThrow<RequestStatusException> {
			m2Child.api(specJob).patient.getPatient(patient.id)
		}.statusCode shouldBe 403
	}
})
