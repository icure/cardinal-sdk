@file:OptIn(InternalIcureApi::class)

package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.api.raw.impl.RawHealthcarePartyApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawPatientApiImpl
import com.icure.cardinal.sdk.crypto.entities.PatientShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEntryKeyString
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.test.DataOwnerDetails
import com.icure.cardinal.sdk.test.DefaultRawApiConfig
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.baseUrl
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.shouldBeNextRevOf
import com.icure.cardinal.sdk.test.testGroupAdminAuth
import com.icure.cardinal.sdk.test.uuid
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.cardinal.sdk.utils.LOCAL_ENV_ONLY
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.PublicRsaKey
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.kryptom.utils.toHexString
import com.icure.utils.InternalIcureApi
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

/**
 * Legacy (v7-native) AES exchange keys for a single data owner, shared with a single parent. Unlike
 * the typescript sdk, which can generate genuine v7 fixtures by literally running the old sdk version,
 * cardinal-sdk was built on top of the v8 (secureDelegations) crypto scheme and never had a v7-shaped
 * writer: it can only decode this legacy shape (see BaseExchangeKeysManagerImpl and
 * BaseSecurityMetadataDecryptorImpl.tryDecryptLegacyDelegation), never produce it. This builds fixtures
 * that satisfy that decoder by calling the same underlying primitives (rsa/aes encrypt) in reverse,
 * so that fresh keys/ids can be used on every run instead of baking a single set of hex constants in.
 */
private class LegacyExchangeKeys(
	val hcpAesExchangeKeys: Map<AesExchangeKeyEntryKeyString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>,
	val selfExchangeKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
	val toParentExchangeKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>
)

private suspend fun rsaEncryptExchangeKey(
	exchangeKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
	publicKey: PublicRsaKey<RsaAlgorithm.RsaEncryptionAlgorithm>
): HexString = HexString(
	defaultCryptoService.rsa.encrypt(defaultCryptoService.aes.exportKey(exchangeKey), publicKey).toHexString()
)

// The legacy Delegation.key format is aes(iv || "<entityId>:<value>", exchangeKey), verified against
// tryDecryptLegacyDelegation's decode side.
private suspend fun legacyDelegationValue(
	entityId: String,
	value: String,
	exchangeKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>
): HexString = HexString(
	defaultCryptoService.aes.encrypt("$entityId:$value".encodeToByteArray(), exchangeKey).toHexString()
)

private suspend fun createLegacyExchangeKeys(
	ownerKeypair: RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>,
	ownerId: String,
	parentKeypair: RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>,
	parentId: String
): LegacyExchangeKeys {
	val crypto = defaultCryptoService
	val ownerSpkiHex = crypto.rsa.exportPublicKeySpki(ownerKeypair.public).toHexString()
	val ownerFingerprint = AesExchangeKeyEncryptionKeypairIdentifier(SpkiHexString(ownerSpkiHex).fingerprintV1().s)
	val parentSpkiHex = crypto.rsa.exportPublicKeySpki(parentKeypair.public).toHexString()
	val parentFingerprint = AesExchangeKeyEncryptionKeypairIdentifier(SpkiHexString(parentSpkiHex).fingerprintV1().s)
	val selfExchangeKey = crypto.aes.generateKey(AesAlgorithm.CbcWithPkcs7Padding)
	val toParentExchangeKey = crypto.aes.generateKey(AesAlgorithm.CbcWithPkcs7Padding)
	return LegacyExchangeKeys(
		hcpAesExchangeKeys = mapOf(
			AesExchangeKeyEntryKeyString(ownerSpkiHex) to mapOf(
				ownerId to mapOf(ownerFingerprint to rsaEncryptExchangeKey(selfExchangeKey, ownerKeypair.public)),
				parentId to mapOf(
					ownerFingerprint to rsaEncryptExchangeKey(toParentExchangeKey, ownerKeypair.public),
					parentFingerprint to rsaEncryptExchangeKey(toParentExchangeKey, parentKeypair.public)
				)
			)
		),
		selfExchangeKey = selfExchangeKey,
		toParentExchangeKey = toParentExchangeKey
	)
}

/**
 * Creates a healthcare party with legacy (OaepWithSha1, single `publicKey`) encryption metadata, as a
 * child of [parent], with the aesExchangeKeys it needs to create legacy-shaped delegations for itself
 * and for [parent] - the "v7 SDK" precondition of the CSM-814 suite.
 */
private suspend fun createLegacyHcpUser(parent: DataOwnerDetails): Pair<DataOwnerDetails, LegacyExchangeKeys> {
	val owner = createHcpUser(parent, useLegacyKey = true)
	val exchangeKeys = createLegacyExchangeKeys(
		ownerKeypair = owner.keypair!!,
		ownerId = owner.dataOwnerId,
		parentKeypair = parent.keypair!!,
		parentId = parent.dataOwnerId
	)
	val hcpRawApi = RawHealthcarePartyApiImpl(baseUrl, testGroupAdminAuth(), DefaultRawApiConfig)
	val current = hcpRawApi.getHealthcareParty(owner.dataOwnerId).successBody()
	hcpRawApi.modifyHealthcareParty(current.copy(aesExchangeKeys = exchangeKeys.hcpAesExchangeKeys)).successBody()
	return owner to exchangeKeys
}

/** Inserts a legacy (v7-native, already shared with [parentId]) patient directly through the raw api,
 * bypassing withEncryptionMetadata entirely - cardinal-sdk itself can never produce this shape. */
private suspend fun createLegacyPatientSharedWithParent(
	owner: DataOwnerDetails,
	exchangeKeys: LegacyExchangeKeys,
	parentId: String,
	firstName: String
): EncryptedPatient {
	val patientId = uuid()
	val secretId = uuid()
	val encryptionKeyHex = uuid().replace("-", "")
	val patient = EncryptedPatient(
		id = patientId,
		firstName = firstName,
		lastName = "Doe",
		delegations = mapOf(
			owner.dataOwnerId to setOf(
				Delegation(owner.dataOwnerId, owner.dataOwnerId, legacyDelegationValue(patientId, secretId, exchangeKeys.selfExchangeKey))
			),
			parentId to setOf(
				Delegation(owner.dataOwnerId, parentId, legacyDelegationValue(patientId, secretId, exchangeKeys.toParentExchangeKey))
			)
		),
		encryptionKeys = mapOf(
			owner.dataOwnerId to setOf(
				Delegation(owner.dataOwnerId, owner.dataOwnerId, legacyDelegationValue(patientId, encryptionKeyHex, exchangeKeys.selfExchangeKey))
			),
			parentId to setOf(
				Delegation(owner.dataOwnerId, parentId, legacyDelegationValue(patientId, encryptionKeyHex, exchangeKeys.toParentExchangeKey))
			)
		)
	)
	return RawPatientApiImpl(baseUrl, testGroupAdminAuth(), null, DefaultRawApiConfig).createPatient(patient).successBody()
}

/** Creates a patient the normal (v8) way and immediately shares it with [parentId]. Returned in its
 * encrypted flavour so it can be handled uniformly with legacy-created patients in the same test. */
private suspend fun createV8PatientSharedWithParent(ownerApi: CardinalSdk, parentId: String, firstName: String): EncryptedPatient {
	val created = ownerApi.patient.createPatient(
		ownerApi.patient.withEncryptionMetadata(
			DecryptedPatient(id = uuid(), firstName = firstName, lastName = "Doe"),
			delegates = mapOf(parentId to AccessLevel.Write)
		)
	)
	return ownerApi.patient.encrypted.getPatient(created.id).shouldNotBeNull()
}

class PatientMergingTests : StringSpec({
	val specJob = autoCancelJob()

	beforeSpec {
		initializeTestEnvironment()
	}

	"A user should be able to share a just created patient secret id".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val grand = createHcpUser()
		val parent = createHcpUser(grand)
		val child = createHcpUser(parent)
		// Direct child of grand (not of parent): a sibling of parent, not of child, that only holds
		// grand's key locally - it can only see what child auto-shared up to grand.
		val child2 = createHcpUser(grand)
		val childApi = child.api(specJob)
		val child2Api = child2.api(specJob)

		val pat = childApi.patient.createPatient(
			childApi.patient.withEncryptionMetadata(
				DecryptedPatient(id = uuid(), firstName = "John", lastName = "Doe"),
				user = childApi.user.getCurrentUser()
			)
		)
		val initialSecretIds = childApi.patient.getSecretIdsOf(pat).keys
		initialSecretIds shouldBe setOf(initialSecretIds.single())
		child2Api.patient.getSecretIdsOf(pat).keys shouldBe initialSecretIds

		val newSecretId = uuid()
		val allSecretIds = initialSecretIds + newSecretId
		val shared = childApi.patient.shareWith(
			grand.dataOwnerId,
			pat,
			PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(allSecretIds, true))
		)

		childApi.patient.getSecretIdsOf(shared).keys shouldBe allSecretIds
		child2Api.patient.getSecretIdsOf(shared).keys shouldBe allSecretIds
	}

	"A user should be able to share the secret id of a just created patient and add a new secret id to a legacy patient created by an old sdk version, in the same operation".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		// P, the shared parent of A and B, and the delegate the legacy patient is already shared with.
		val p = createHcpUser()
		val (a, aExchangeKeys) = createLegacyHcpUser(p)
		val legacyPatient = createLegacyPatientSharedWithParent(a, aExchangeKeys, p.dataOwnerId, "John")

		// B, a sibling of A under the same parent P. B has no direct access to the patient, but holds
		// P's key locally (a shared workstation), so it can decrypt anything shared with P, both before
		// and after the new secret id is added.
		val b = createHcpUser(p)
		val aApi = a.api(specJob)
		val bApi = b.api(specJob)

		val initialSecretIds = aApi.patient.getSecretIdsOf(legacyPatient).keys
		initialSecretIds shouldBe setOf(initialSecretIds.single())
		bApi.patient.getSecretIdsOf(legacyPatient).keys shouldBe initialSecretIds

		val newSecretId = uuid()
		val allSecretIds = initialSecretIds + newSecretId
		val shared = aApi.patient.encrypted.shareWith(
			p.dataOwnerId,
			legacyPatient,
			PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(allSecretIds, true))
		)

		aApi.patient.getSecretIdsOf(shared).keys shouldBe allSecretIds
		p.api(specJob).patient.getSecretIdsOf(shared).keys shouldBe allSecretIds
		bApi.patient.getSecretIdsOf(shared).keys shouldBe allSecretIds
	}

	val versions = listOf("v8", "v7")
	for (fromVersion in versions) {
		for (intoVersion in versions) {
			for (mergedBy in listOf("A", "B")) {
				"mergePatients merges a $fromVersion patient owned by A into a $intoVersion patient owned by B, both shared with the same parent P, merge performed by $mergedBy".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
					// Shared parent P and two sibling hcps A and B (both legacy-keyed, both holding P's
					// key locally too, standing in for a shared workstation), regardless of which of
					// A/B performs the merge.
					val p = createHcpUser()
					val (a, aExchangeKeys) = createLegacyHcpUser(p)
					val (b, bExchangeKeys) = createLegacyHcpUser(p)
					val aApi = a.api(specJob)
					val bApi = b.api(specJob)

					val pA = if (fromVersion == "v8")
						createV8PatientSharedWithParent(aApi, p.dataOwnerId, "John")
					else
						createLegacyPatientSharedWithParent(a, aExchangeKeys, p.dataOwnerId, "John")
					val pB = if (intoVersion == "v8")
						createV8PatientSharedWithParent(bApi, p.dataOwnerId, "Jack")
					else
						createLegacyPatientSharedWithParent(b, bExchangeKeys, p.dataOwnerId, "Jack")

					val aSecretId = aApi.patient.getSecretIdsOf(pA).keys.single()
					val bSecretId = bApi.patient.getSecretIdsOf(pB).keys.single()
					val allSecretIds = setOf(aSecretId, bSecretId)

					val merger = if (mergedBy == "A") aApi else bApi
					val otherId = if (mergedBy == "A") b.dataOwnerId else a.dataOwnerId
					val mergedInto = merger.patient.encrypted.mergePatients(pA, pB)

					// Documented merge metadata: `from` is soft-deleted and points to `into`; `into`
					// records the merge.
					val fromAfterMerge = aApi.patient.encrypted.getPatient(pA.id).shouldNotBeNull()
					fromAfterMerge.deletionDate.shouldNotBeNull()
					fromAfterMerge.mergeToPatientId shouldBe pB.id
					mergedInto.mergedIds shouldContain pA.id

					// Per mergePatients' own documentation, the merge alone does not share the merged
					// content with users that only had access to one of the two original entities: the
					// merger has to explicitly share with the other sibling afterwards for both to end
					// up with full access to both secret ids.
					val reshared = merger.patient.encrypted.shareWithMany(
						mergedInto,
						mapOf(otherId to PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(allSecretIds, true)))
					)

					aApi.patient.getSecretIdsOf(reshared).keys shouldBe allSecretIds
					bApi.patient.getSecretIdsOf(reshared).keys shouldBe allSecretIds
				}
			}
		}
	}

	/*
	 * mergePatients only merges the two entities' existing security metadata (secret id/encryption key
	 * delegations) server-side, without decrypting anything: whatever a data owner could access on one
	 * of the two original patients, it can still access on the merged patient, and nothing more. This
	 * holds regardless of which of A, B, or a completely unrelated third hcp performs the merge, since
	 * the merger's own identity only matters for re-encrypting the `into` patient's content for itself,
	 * not for the secret id metadata merge itself.
	 *
	 * A, B and C are all hierarchical children of the same parent P: mergePatients (like most write
	 * operations) is only authorized between data owners with some existing relationship, so C stands
	 * in for "anyone else in the same care organisation", not a random unrelated hcp - an entirely
	 * unrelated hcp would get a 403. Being hierarchical children, A/B/C each also hold P's key locally
	 * (the same "shared workstation" setup used elsewhere in this suite), so on top of their own secret
	 * id and whatever was explicitly shared with them, they can also independently decrypt anything
	 * shared with P - merging does not change or extend this in any way.
	 */
	for (merger in listOf("A", "B", "C")) {
		"mergePatients preserves secret id visibility independently of the merger, regardless of who performs it (merged by $merger)".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
			val p = createHcpUser()
			val pApi = p.api(specJob)
			val a = createHcpUser(p)
			val b = createHcpUser(p)
			val c = createHcpUser(p)
			val aApi = a.api(specJob)
			val bApi = b.api(specJob)
			val cApi = c.api(specJob)

			// PatientA: s1 is A's own secret id, s2 gets additionally shared with the parent P.
			val createdPA = aApi.patient.createPatient(
				aApi.patient.withEncryptionMetadata(DecryptedPatient(id = uuid(), firstName = "John", lastName = "Doe"))
			)
			val s1 = aApi.patient.getSecretIdsOf(createdPA).keys.single()
			val s2 = uuid()
			val pA = aApi.patient.shareWith(
				p.dataOwnerId,
				createdPA,
				PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(setOf(s2), true))
			)

			// PatientB: s3 is B's own secret id, s4 gets additionally shared with the same parent P.
			val createdPB = bApi.patient.createPatient(
				bApi.patient.withEncryptionMetadata(DecryptedPatient(id = uuid(), firstName = "Jack", lastName = "Doe"))
			)
			val s3 = bApi.patient.getSecretIdsOf(createdPB).keys.single()
			val s4 = uuid()
			val pB = bApi.patient.shareWith(
				p.dataOwnerId,
				createdPB,
				PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(setOf(s4), true))
			)

			val mergerApi = when (merger) {
				"A" -> aApi
				"B" -> bApi
				else -> cApi
			}
			val merged = mergerApi.patient.encrypted.mergePatients(
				aApi.patient.encrypted.getPatient(pA.id).shouldNotBeNull(),
				bApi.patient.encrypted.getPatient(pB.id).shouldNotBeNull()
			)

			// Each of A and B keeps its own secret id, plus whichever of s2/s4 was shared with P (which
			// both can reach independently of the merge, through P's key); P keeps exactly what was
			// shared with it, nothing more (in particular, no access to s1 or s3).
			aApi.patient.getSecretIdsOf(merged).keys shouldBe setOf(s1, s2, s4)
			bApi.patient.getSecretIdsOf(merged).keys shouldBe setOf(s2, s3, s4)
			pApi.patient.getSecretIdsOf(merged).keys shouldBe setOf(s2, s4)
		}
	}

	/*
	 * mergePatients forcefully disables merging the `from` patient's encryption key into the `into`
	 * patient (the `into` patient keeps only its own, pre-existing encryption key). One consequence is
	 * a corner case: if the `into` patient's encryption key was never shared with a party that did have
	 * the `from` patient's encryption key, that party loses the ability to decrypt the merged patient's
	 * content (though not its secret ids, which are unaffected and still merge normally) - a followup
	 * shareWith/shareWithMany restores it. Sharing only the encryption key (shareSecretIds = emptySet())
	 * again with someone who already has it is a harmless no-op, even when the caller isn't the entity's
	 * original creator.
	 */
	"mergePatients does not merge encryption keys, and a follow-up shareWith restores lost access for whoever needs it".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val p = createHcpUser()
		val pApi = p.api(specJob)
		// A and B are children of the same parent P, so that A is authorized to merge B's patient into
		// its own.
		val a = createHcpUser(p)
		val b = createHcpUser(p)
		val aApi = a.api(specJob)
		val bApi = b.api(specJob)

		// PatientA created by A, but for some reason not shared with the parent at all.
		val pA = aApi.patient.createPatient(
			aApi.patient.withEncryptionMetadata(DecryptedPatient(id = uuid(), firstName = "John", lastName = "Doe", note = "note from A"))
		)

		// PatientB created by B and properly shared with the parent (secret id + encryption key).
		val createdPB = bApi.patient.createPatient(
			bApi.patient.withEncryptionMetadata(DecryptedPatient(id = uuid(), firstName = "Jack", lastName = "Doe", note = "note from B"))
		)
		val bSecretId = bApi.patient.getSecretIdsOf(createdPB).keys.single()
		val pB = bApi.patient.shareWith(
			p.dataOwnerId,
			createdPB,
			PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(setOf(bSecretId), true))
		)
		pApi.patient.getSecretIdsOf(pB).keys shouldBe setOf(bSecretId)

		// A merges PatientB into PatientA: PatientB's secret id still gets merged in (unaffected), but
		// PatientA's own encryption key is the only one that survives on the merged patient - so even
		// though the parent could decrypt PatientB's content a moment ago, it now can't decrypt the
		// merged patient's content at all, despite still being able to find the merged-in secret id.
		val merged = aApi.patient.mergePatients(pB, pA)

		pApi.patient.getSecretIdsOf(merged).keys shouldBe setOf(bSecretId)
		shouldThrow<EntityEncryptionException> {
			pApi.patient.decrypt(listOf(pApi.patient.encrypted.getPatient(merged.id).shouldNotBeNull()))
		}

		// A shares just the encryption key with the parent to fix this: shareSecretIds is left empty
		// (no new secret id to share). This is a real change (the parent never had access to this
		// specific entity before), so the rev changes.
		val resharedByA = aApi.patient.shareWith(
			p.dataOwnerId,
			merged,
			PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), true))
		)
		resharedByA.rev shouldBeNextRevOf merged.rev

		// Redundant reshare of an already-shared encryption key, this time performed by another child
		// itself rather than the entity's original creator: a harmless no-op - nothing to write, so the
		// rev stays the same.
		val reshareAgain = bApi.patient.shareWith(
			p.dataOwnerId,
			resharedByA,
			PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), true))
		)
		reshareAgain.rev shouldBe resharedByA.rev

		// shareWithMany to a mix of delegates that already have the key (the parent) and delegates that
		// don't yet (a fresh, unrelated hcp) also works cleanly - D's part is a real change regardless,
		// so the rev changes overall, and D can now decrypt the content.
		val d = createHcpUser()
		val sharedWithBoth = aApi.patient.shareWithMany(
			reshareAgain,
			mapOf(
				p.dataOwnerId to PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), true)),
				d.dataOwnerId to PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), true))
			)
		)
		sharedWithBoth.rev shouldBeNextRevOf reshareAgain.rev
		d.api(specJob).patient.getPatient(sharedWithBoth.id).shouldNotBeNull().note shouldBe "note from A"
	}
})
