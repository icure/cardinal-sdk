package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.crypto.entities.PatientShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions
import com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.requests.RequestedPermission
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.uuid
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.cardinal.sdk.utils.LOCAL_ENV_ONLY
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

/**
 * Validates the "nothing new to share, don't write anything" optimization in
 * `EntityEncryptionServiceImpl.prepareBulkShareRequests` (removeContentAlreadyKnownToDelegates /
 * bestKnownAccessLevelFor): sharing content with a delegate should be a genuine no-op (rev unchanged)
 * whenever the delegate already has both the content and at least the requested access level through
 * some other delegation the current actor can decrypt - and should NOT be a no-op if either of those two
 * conditions isn't actually known to be met.
 */
class SharingOptimizationTest : StringSpec({
	val specJob = autoCancelJob()

	beforeSpec {
		initializeTestEnvironment()
	}

	"sharing again with a parent that already has access through a sibling's delegation is a no-op".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val p = createHcpUser()
		val a = createHcpUser(p)
		val b = createHcpUser(p)
		val aApi = a.api(specJob)
		val bApi = b.api(specJob)

		val created = aApi.patient.createPatient(
			aApi.patient.withEncryptionMetadata(DecryptedPatient(id = uuid(), firstName = "John", lastName = "Doe"))
		)
		val secretIds = aApi.patient.getSecretIdsOf(created).keys
		val sharedWithP = aApi.patient.shareWith(
			p.dataOwnerId,
			created,
			PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(secretIds, false))
		)

		// B (A's sibling, holding P's key) tries to share the exact same thing with P again: B can
		// decrypt the existing A->P delegation (through P's key) and sees it already covers everything
		// requested, so nothing new is written.
		val reshared = bApi.patient.shareWith(
			p.dataOwnerId,
			sharedWithP,
			PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(secretIds, false))
		)
		reshared.rev shouldBe sharedWithP.rev
	}

	"sharing with a parent again through an unrelated third party who cannot see the existing delegation is not a no-op".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val p = createHcpUser()
		val a = createHcpUser(p)
		val x = createHcpUser()
		val aApi = a.api(specJob)
		val xApi = x.api(specJob)

		val created = aApi.patient.createPatient(
			aApi.patient.withEncryptionMetadata(DecryptedPatient(id = uuid(), firstName = "John", lastName = "Doe"))
		)
		val secretIds = aApi.patient.getSecretIdsOf(created).keys
		val sharedWithP = aApi.patient.shareWith(
			p.dataOwnerId,
			created,
			PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(secretIds, false))
		)
		val sharedWithX = aApi.patient.shareWith(
			x.dataOwnerId,
			sharedWithP,
			PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(secretIds, false))
		)

		// X has no way of knowing P already has access: it holds neither A's nor P's key, so it can't
		// decrypt the A->P delegation to check its content - its own attempt to share the same content
		// with P goes through unchanged.
		val xKnownSecretIds = xApi.patient.getSecretIdsOf(sharedWithX).keys
		val resharedByX = xApi.patient.shareWith(
			p.dataOwnerId,
			sharedWithX,
			PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(xKnownSecretIds, false))
		)
		resharedByX.rev shouldNotBe sharedWithX.rev
	}

	"sharing directly with a sibling is not a no-op even if the parent already has access to the same content".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val p = createHcpUser()
		val a = createHcpUser(p)
		val b = createHcpUser(p)
		val aApi = a.api(specJob)

		val created = aApi.patient.createPatient(
			aApi.patient.withEncryptionMetadata(DecryptedPatient(id = uuid(), firstName = "John", lastName = "Doe"))
		)
		val secretIds = aApi.patient.getSecretIdsOf(created).keys
		val sharedWithP = aApi.patient.shareWith(
			p.dataOwnerId,
			created,
			PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(secretIds, false))
		)

		// Even though B (A's sibling) could probably reach the same content through P, A has no way to
		// confirm that B actually has the necessary permission to do so - sharing directly with B always
		// goes through unchanged.
		val sharedWithB = aApi.patient.shareWith(
			b.dataOwnerId,
			sharedWithP,
			PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(secretIds, false))
		)
		sharedWithB.rev shouldNotBe sharedWithP.rev
	}

	"re-sharing the exact same content with the same delegate again is a no-op".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val a = createHcpUser()
		val x = createHcpUser()
		val aApi = a.api(specJob)

		val created = aApi.patient.createPatient(
			aApi.patient.withEncryptionMetadata(DecryptedPatient(id = uuid(), firstName = "John", lastName = "Doe"))
		)
		val secretIds = aApi.patient.getSecretIdsOf(created).keys
		val sharedWithX = aApi.patient.shareWith(
			x.dataOwnerId,
			created,
			PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(secretIds, false))
		)

		// A created the A->X delegation itself, so it can always decrypt it and see it already covers
		// everything requested.
		val resharedWithX = aApi.patient.shareWith(
			x.dataOwnerId,
			sharedWithX,
			PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(secretIds, false))
		)
		resharedWithX.rev shouldBe sharedWithX.rev
	}

	"sharing with a delegate that received access indirectly through someone else is not a no-op".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val a = createHcpUser()
		val x = createHcpUser()
		val y = createHcpUser()
		val aApi = a.api(specJob)
		val xApi = x.api(specJob)

		val created = aApi.patient.createPatient(
			aApi.patient.withEncryptionMetadata(DecryptedPatient(id = uuid(), firstName = "John", lastName = "Doe"))
		)
		val secretIds = aApi.patient.getSecretIdsOf(created).keys
		val sharedWithX = aApi.patient.shareWith(
			x.dataOwnerId,
			created,
			PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(secretIds, false))
		)
		val sharedWithY = xApi.patient.shareWith(
			y.dataOwnerId,
			sharedWithX,
			PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(secretIds, false))
		)

		// A has no visibility into the X->Y delegation (it holds neither X's nor Y's key), so it has no
		// way of knowing Y already has this content through X - sharing with Y directly goes through
		// unchanged.
		val resharedByA = aApi.patient.shareWith(
			y.dataOwnerId,
			sharedWithY,
			PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(secretIds, false))
		)
		resharedByA.rev shouldNotBe sharedWithY.rev
	}

	"sharing again with a higher requested permission creates a fresh delegation with the upgraded access level even if all the content was already known".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		// A and B are siblings under the same parent P. A shares read-only access to the patient with P,
		// and separately gives B its own (write-level) direct access. B - a different delegator than A,
		// so its own share creates a brand new (B->P) delegation rather than colliding with the existing
		// A->P one - can decrypt the existing A->P delegation through P's key, so it knows P already has
		// everything content-wise; it then shares the same content with P again, but requesting write
		// access this time. Since B itself has write access, it is allowed to grant it to P too, and since
		// there is nothing new to add content-wise, only the escalated permission is what actually changes.
		//
		// Note: this deliberately uses a different delegator (B) for the upgrade. A trying to upgrade its
		// own existing A->P delegation this same way hits a separate, deeper limitation: permissions can't
		// be changed on an already-existing delegation in place at all (yet), so a same-delegator re-share
		// requesting a higher permission is currently still a no-op regardless of this optimization.
		val p = createHcpUser()
		val a = createHcpUser(p)
		val b = createHcpUser(p)
		val aApi = a.api(specJob)
		val bApi = b.api(specJob)
		val pApi = p.api(specJob)

		val created = aApi.patient.createPatient(
			aApi.patient.withEncryptionMetadata(DecryptedPatient(id = uuid(), firstName = "John", lastName = "Doe"))
		)
		val secretIds = aApi.patient.getSecretIdsOf(created).keys
		val sharedWithP = aApi.patient.shareWith(
			p.dataOwnerId,
			created,
			PatientShareOptions(
				requestedPermissions = RequestedPermission.FullRead,
				shareSecretIds = SecretIdShareOptions.UseExactly(secretIds, false)
			)
		)
		pApi.patient.hasWriteAccess(sharedWithP) shouldBe false
		val sharedWithB = aApi.patient.shareWith(
			b.dataOwnerId,
			sharedWithP,
			PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(secretIds, false))
		)

		// Same content, but this time requesting write access: P already has everything content-wise
		// (reachable by B through the existing A->P delegation), but not yet the requested permission
		// level, so a new (B->P) delegation carrying the higher access level - with nothing re-shared,
		// since the content itself was already known - has to be created.
		val upgraded = bApi.patient.shareWith(
			p.dataOwnerId,
			sharedWithB,
			PatientShareOptions(
				requestedPermissions = RequestedPermission.FullWrite,
				shareSecretIds = SecretIdShareOptions.UseExactly(secretIds, false)
			)
		)
		upgraded.rev shouldNotBe sharedWithB.rev
		pApi.patient.hasWriteAccess(upgraded) shouldBe true
	}

	"sharing back with the original sharer through the same delegation is a no-op".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val a = createHcpUser()
		val b = createHcpUser()
		val aApi = a.api(specJob)
		val bApi = b.api(specJob)

		val created = aApi.patient.createPatient(
			aApi.patient.withEncryptionMetadata(DecryptedPatient(id = uuid(), firstName = "John", lastName = "Doe"))
		)
		val secretIds = aApi.patient.getSecretIdsOf(created).keys
		val sharedWithB = aApi.patient.shareWith(
			b.dataOwnerId,
			created,
			PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(secretIds, false))
		)

		// B, the delegate of the A->B delegation, already gives A (the delegator) access to the same
		// content just as much as it gives it to B itself - so B re-sharing that same content back with
		// A is recognized as already known too, not just the more obvious "A re-sharing with B".
		val bKnownSecretIds = bApi.patient.getSecretIdsOf(sharedWithB).keys
		val resharedWithA = bApi.patient.shareWith(
			a.dataOwnerId,
			sharedWithB,
			PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(bKnownSecretIds, false))
		)
		resharedWithA.rev shouldBe sharedWithB.rev
	}

	"re-requesting a higher permission from the same delegator on their own existing delegation fails loudly instead of silently keeping the old permission".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val a = createHcpUser()
		val x = createHcpUser()
		val aApi = a.api(specJob)
		val xApi = x.api(specJob)

		val created = aApi.patient.createPatient(
			aApi.patient.withEncryptionMetadata(DecryptedPatient(id = uuid(), firstName = "John", lastName = "Doe"))
		)
		val secretIds = aApi.patient.getSecretIdsOf(created).keys
		val sharedWithX = aApi.patient.shareWith(
			x.dataOwnerId,
			created,
			PatientShareOptions(
				requestedPermissions = RequestedPermission.FullRead,
				shareSecretIds = SecretIdShareOptions.UseExactly(secretIds, false)
			)
		)
		xApi.patient.hasWriteAccess(sharedWithX) shouldBe false

		// A itself (the same delegator as before) tries to upgrade its own A->X delegation from read to
		// write: unlike the previous test (where a *different* delegator performed the upgrade, creating
		// a brand new delegation), this collides with the existing A->X delegation - permissions can't be
		// changed on an already-existing delegation in place (yet), so this must fail loudly rather than
		// silently leave X with only read access.
		shouldThrow<UnsupportedOperationException> {
			aApi.patient.shareWith(
				x.dataOwnerId,
				sharedWithX,
				PatientShareOptions(
					requestedPermissions = RequestedPermission.FullWrite,
					shareSecretIds = SecretIdShareOptions.UseExactly(secretIds, false)
				)
			)
		}
	}

	"sharing partially-already-known content is not a no-op and updates the existing delegation instead of duplicating it".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val p = createHcpUser()
		val a = createHcpUser(p)
		val aApi = a.api(specJob)

		val created = aApi.patient.createPatient(
			aApi.patient.withEncryptionMetadata(DecryptedPatient(id = uuid(), firstName = "John", lastName = "Doe"))
		)
		val secretIds = aApi.patient.getSecretIdsOf(created).keys

		// Share only the secret id with P, deliberately not the encryption key.
		val sharedSecretIdOnly = aApi.patient.shareWith(
			p.dataOwnerId,
			created,
			PatientShareOptions(
				shareEncryptionKey = ShareMetadataBehaviour.Never,
				shareSecretIds = SecretIdShareOptions.UseExactly(secretIds, false)
			)
		)
		val delegationCountBefore = sharedSecretIdOnly.securityMetadata.shouldNotBeNull().secureDelegations.size
		val aToPBefore = sharedSecretIdOnly.securityMetadata.shouldNotBeNull().secureDelegations.values.single { it.delegate == p.dataOwnerId }
		aToPBefore.secretIds shouldHaveSize 1
		aToPBefore.encryptionKeys.shouldBeEmpty()

		// Sharing the same secret id again, but this time also the encryption key: the secret id is
		// already known to P so it must not be duplicated, but the encryption key is genuinely new - this
		// must not be a no-op, and must update the *same* existing delegation rather than create a new one.
		val sharedBoth = aApi.patient.shareWith(
			p.dataOwnerId,
			sharedSecretIdOnly,
			PatientShareOptions(
				shareEncryptionKey = ShareMetadataBehaviour.Required,
				shareSecretIds = SecretIdShareOptions.UseExactly(secretIds, false)
			)
		)
		sharedBoth.rev shouldNotBe sharedSecretIdOnly.rev
		sharedBoth.securityMetadata.shouldNotBeNull().secureDelegations.size shouldBe delegationCountBefore
		val aToPAfter = sharedBoth.securityMetadata.shouldNotBeNull().secureDelegations.values.single { it.delegate == p.dataOwnerId }
		aToPAfter.secretIds shouldHaveSize 1
		aToPAfter.encryptionKeys shouldHaveSize 1
	}

	"sharing the union of an already-known secret id and a newly added one results in exactly both, without duplicating the already-known one".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val p = createHcpUser()
		val a = createHcpUser(p)
		val aApi = a.api(specJob)

		val created = aApi.patient.createPatient(
			aApi.patient.withEncryptionMetadata(DecryptedPatient(id = uuid(), firstName = "John", lastName = "Doe"))
		)
		val originalSecretId = aApi.patient.getSecretIdsOf(created).keys.single()
		val sharedWithP = aApi.patient.shareWith(
			p.dataOwnerId,
			created,
			PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(setOf(originalSecretId), false))
		)
		sharedWithP.securityMetadata.shouldNotBeNull().secureDelegations.values.single { it.delegate == p.dataOwnerId }.secretIds shouldHaveSize 1

		// A creates a new secret id (never shared with P), then decides to share both the original and the
		// new secret id with P in a single call.
		val (withNewSecretId, newSecretId) = aApi.patient.createNewSecretId(sharedWithP)
		val allSecretIds = setOf(originalSecretId, newSecretId)

		val resharedWithBoth = aApi.patient.shareWith(
			p.dataOwnerId,
			withNewSecretId,
			PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(allSecretIds, false))
		)
		resharedWithBoth.rev shouldNotBe withNewSecretId.rev
		val aToPAfter = resharedWithBoth.securityMetadata.shouldNotBeNull().secureDelegations.values.single { it.delegate == p.dataOwnerId }
		aToPAfter.secretIds shouldHaveSize 2
		aApi.patient.getSecretIdsOf(resharedWithBoth).keys shouldBe allSecretIds
	}

	"sharing with a delegate that only needs the part of the content not already reachable through someone else creates a delegation containing just that part".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val p = createHcpUser()
		val a = createHcpUser(p)
		val b = createHcpUser(p)
		val aApi = a.api(specJob)
		val bApi = b.api(specJob)
		val pApi = p.api(specJob)

		val created = aApi.patient.createPatient(
			aApi.patient.withEncryptionMetadata(DecryptedPatient(id = uuid(), firstName = "John", lastName = "Doe"))
		)
		val secretIds = aApi.patient.getSecretIdsOf(created).keys

		// Share only the secret id with P.
		val sharedWithP = aApi.patient.shareWith(
			p.dataOwnerId,
			created,
			PatientShareOptions(
				shareEncryptionKey = ShareMetadataBehaviour.Never,
				shareSecretIds = SecretIdShareOptions.UseExactly(secretIds, false)
			)
		)
		// Share both the secret id and the encryption key with B.
		val sharedWithB = aApi.patient.shareWith(
			b.dataOwnerId,
			sharedWithP,
			PatientShareOptions(
				shareEncryptionKey = ShareMetadataBehaviour.Required,
				shareSecretIds = SecretIdShareOptions.UseExactly(secretIds, false)
			)
		)

		// B tries to share both the secret id and the encryption key with P: the secret id is already
		// reachable by P through the existing A->P delegation (which B can decrypt via P's key), but the
		// encryption key never was - the new B->P delegation only needs to carry the encryption key.
		val bKnownSecretIds = bApi.patient.getSecretIdsOf(sharedWithB).keys
		val resharedByB = bApi.patient.shareWith(
			p.dataOwnerId,
			sharedWithB,
			PatientShareOptions(
				shareEncryptionKey = ShareMetadataBehaviour.Required,
				shareSecretIds = SecretIdShareOptions.UseExactly(bKnownSecretIds, false)
			)
		)
		resharedByB.rev shouldNotBe sharedWithB.rev
		val bToP = resharedByB.securityMetadata.shouldNotBeNull().secureDelegations.values
			.single { it.delegate == p.dataOwnerId && it.delegator == b.dataOwnerId }
		bToP.secretIds.shouldBeEmpty()
		bToP.encryptionKeys shouldHaveSize 1
		pApi.patient.getEncryptionKeysOf(resharedByB) shouldHaveSize 1
	}

	"a MaxWrite request is a no-op if the current data owner can itself grant at most read access and the delegate already has read access".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val a = createHcpUser()
		val b = createHcpUser()
		val x = createHcpUser()
		val aApi = a.api(specJob)
		val bApi = b.api(specJob)

		val created = aApi.patient.createPatient(
			aApi.patient.withEncryptionMetadata(DecryptedPatient(id = uuid(), firstName = "John", lastName = "Doe"))
		)
		val secretIds = aApi.patient.getSecretIdsOf(created).keys

		// A only gives B read-only access.
		val sharedWithB = aApi.patient.shareWith(
			b.dataOwnerId,
			created,
			PatientShareOptions(
				requestedPermissions = RequestedPermission.FullRead,
				shareSecretIds = SecretIdShareOptions.UseExactly(secretIds, false)
			)
		)
		bApi.patient.hasWriteAccess(sharedWithB) shouldBe false

		// B, who itself only has read access, shares the same content with X, also at read level.
		val bKnownSecretIds = bApi.patient.getSecretIdsOf(sharedWithB).keys
		val sharedWithX = bApi.patient.shareWith(
			x.dataOwnerId,
			sharedWithB,
			PatientShareOptions(
				requestedPermissions = RequestedPermission.FullRead,
				shareSecretIds = SecretIdShareOptions.UseExactly(bKnownSecretIds, false)
			)
		)

		// B tries again, this time requesting MaxWrite: since B itself only has read access, MaxWrite
		// (which caps the grant at whatever the current data owner already has) can only ever grant read
		// too - and X already has read (from B's own earlier share), so there is genuinely nothing this
		// could add. Unlike the earlier "higher requested permission" test, this is not an upgrade
		// attempt at all, just a request that resolves to something already fully satisfied.
		val resharedWithMaxWrite = bApi.patient.shareWith(
			x.dataOwnerId,
			sharedWithX,
			PatientShareOptions(
				requestedPermissions = RequestedPermission.MaxWrite,
				shareSecretIds = SecretIdShareOptions.UseExactly(bKnownSecretIds, false)
			)
		)
		resharedWithMaxWrite.rev shouldBe sharedWithX.rev
	}

	"sharing read access with a delegate that a parent's own delegation already gave the same read access to is a no-op".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val a = createHcpUser()
		val b = createHcpUser(a)
		val x = createHcpUser()
		val aApi = a.api(specJob)
		val bApi = b.api(specJob)

		val created = aApi.patient.createPatient(
			aApi.patient.withEncryptionMetadata(DecryptedPatient(id = uuid(), firstName = "John", lastName = "Doe"))
		)
		val secretIds = aApi.patient.getSecretIdsOf(created).keys

		// A shares read-only access with its own child B.
		val sharedWithB = aApi.patient.shareWith(
			b.dataOwnerId,
			created,
			PatientShareOptions(
				requestedPermissions = RequestedPermission.FullRead,
				shareSecretIds = SecretIdShareOptions.UseExactly(secretIds, false)
			)
		)
		// A also shares read-only access with X directly (A->X - B is not a party to this delegation).
		val sharedWithX = aApi.patient.shareWith(
			x.dataOwnerId,
			sharedWithB,
			PatientShareOptions(
				requestedPermissions = RequestedPermission.FullRead,
				shareSecretIds = SecretIdShareOptions.UseExactly(secretIds, false)
			)
		)

		// B (A's child, holding A's key) can decrypt the existing A->X delegation and see that X already
		// has read access to this same content - so B's own attempt to share the same content with X, also
		// at read level, is a no-op, even though B was never a party to A->X itself.
		val bKnownSecretIds = bApi.patient.getSecretIdsOf(sharedWithX).keys
		val resharedByB = bApi.patient.shareWith(
			x.dataOwnerId,
			sharedWithX,
			PatientShareOptions(
				requestedPermissions = RequestedPermission.FullRead,
				shareSecretIds = SecretIdShareOptions.UseExactly(bKnownSecretIds, false)
			)
		)
		resharedByB.rev shouldBe sharedWithX.rev
	}
})
