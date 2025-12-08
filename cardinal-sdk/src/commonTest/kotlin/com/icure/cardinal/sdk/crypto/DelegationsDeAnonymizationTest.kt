package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.api.impl.keyAsLocalDataOwnerReferences
import com.icure.cardinal.sdk.api.raw.impl.RawSecureDelegationKeyMapApiImpl
import com.icure.cardinal.sdk.crypto.entities.EntityAccessInformation
import com.icure.cardinal.sdk.crypto.entities.PatientShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.requests.RequestedPermission
import com.icure.cardinal.sdk.test.DefaultRawApiConfig
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.baseUrl
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.createPatientUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.utils.InternalIcureApi
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.maps.shouldHaveSize
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

@OptIn(InternalIcureApi::class)
class DelegationsDeAnonymizationTest : StringSpec({
	val specJob = autoCancelJob()
	beforeSpec { initializeTestEnvironment() }

	suspend fun CardinalSdk.createSamplePatient() =
		patient.createPatient(
			patient.withEncryptionMetadata(
				DecryptedPatient(
					id = defaultCryptoService.strongRandom.randomUUID(),
					firstName = "John",
					lastName = "Doe",
				),
				user = user.getCurrentUser()
			)
		).shouldNotBeNull()

	"without de-anonymisation metadata the data owners should be able to identify anonymous delegates only if they are part of the delegation with that delegate.".config(enabled = DEFAULT_ENABLED) {
		val (userInfoA, apiA) = createHcpUser().let { it to it.api(specJob) }
		val (userInfoB, apiB) = createHcpUser().let { it to it.api(specJob) }
		val (userInfoP1, apiP1) = createPatientUser().let { it to it.api(specJob) }
		val (userInfoP2, apiP2) = createPatientUser().let { it to it.api(specJob) }
		println("""
			A: ${userInfoA.dataOwnerId}
			B: ${userInfoB.dataOwnerId}
			P1: ${userInfoP1.dataOwnerId}
			P2: ${userInfoP2.dataOwnerId}
		""".trimIndent())
		var entity = apiA.createSamplePatient()
		/*
		 * A->A
		 */
		apiA.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write
			).keyAsLocalDataOwnerReferences()
			hasUnknownAnonymousDataOwners shouldBe false
		}
		/*
		 * A->A  A->B
		 */
		entity = apiA.patient.shareWith(userInfoB.dataOwnerId, entity, PatientShareOptions(
			shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), false),
			requestedPermissions = RequestedPermission.FullWrite
		)
		)
		apiA.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write
			).keyAsLocalDataOwnerReferences()
			hasUnknownAnonymousDataOwners shouldBe false
		}
		apiB.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write
			).keyAsLocalDataOwnerReferences()
			hasUnknownAnonymousDataOwners shouldBe false
		}
		/*
		 * A->A  A->B
		 *       A->P1
		 */
		entity = apiA.patient.shareWith(userInfoP1.dataOwnerId, entity, PatientShareOptions(
			shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), false),
			requestedPermissions = RequestedPermission.FullWrite
		)
		)
		apiP1.crypto.forceReload()
		apiA.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoP1.dataOwnerId to AccessLevel.Write
			).keyAsLocalDataOwnerReferences()
			hasUnknownAnonymousDataOwners shouldBe false
		}
		apiB.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write
			).keyAsLocalDataOwnerReferences()
			hasUnknownAnonymousDataOwners shouldBe true
		}
		apiP1.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoP1.dataOwnerId to AccessLevel.Write
			).keyAsLocalDataOwnerReferences()
			hasUnknownAnonymousDataOwners shouldBe false
		}
		/*
		 * A->A  A->B  B->P1
		 *       A->P1
		 */
		entity = apiB.patient.shareWith(userInfoP1.dataOwnerId, entity, PatientShareOptions(
			shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), false),
			requestedPermissions = RequestedPermission.FullRead
		)
		)
		apiP1.crypto.forceReload()
		apiA.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoP1.dataOwnerId to AccessLevel.Write
			).keyAsLocalDataOwnerReferences()
			hasUnknownAnonymousDataOwners shouldBe true
		}
		apiB.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoP1.dataOwnerId to AccessLevel.Read
			).keyAsLocalDataOwnerReferences()
			hasUnknownAnonymousDataOwners shouldBe true
		}
		apiP1.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoP1.dataOwnerId to AccessLevel.Write
			).keyAsLocalDataOwnerReferences()
			hasUnknownAnonymousDataOwners shouldBe false
		}
		/*
		 * A->A  A->B   B->P1
		 *       A->P1  P1->P2
		 */
		entity = apiP1.patient.shareWith(userInfoP2.dataOwnerId, entity, PatientShareOptions(
			shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), false),
			requestedPermissions = RequestedPermission.FullRead
		)
		)
		apiP2.crypto.forceReload()
		apiA.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoP1.dataOwnerId to AccessLevel.Write,
			).keyAsLocalDataOwnerReferences()
			hasUnknownAnonymousDataOwners shouldBe true
		}
		apiB.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoP1.dataOwnerId to AccessLevel.Read
			).keyAsLocalDataOwnerReferences()
			hasUnknownAnonymousDataOwners shouldBe true
		}
		apiP1.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoP1.dataOwnerId to AccessLevel.Write,
				userInfoP2.dataOwnerId to AccessLevel.Read
			).keyAsLocalDataOwnerReferences()
			hasUnknownAnonymousDataOwners shouldBe false
		}
		apiP2.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoP1.dataOwnerId to AccessLevel.Read, // P2 is only aware of the P1->P2 delegation
				userInfoP2.dataOwnerId to AccessLevel.Read
			).keyAsLocalDataOwnerReferences()
			hasUnknownAnonymousDataOwners shouldBe true
		}
		/*
		 * A->A  A->B   B->P1
		 *       A->P1  P1->P2
		 *       A->P2
		 */
		entity = apiA.patient.shareWith(userInfoP2.dataOwnerId, entity, PatientShareOptions(
			shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), false),
			requestedPermissions = RequestedPermission.FullWrite
		)
		)
		apiP2.crypto.forceReload()
		apiA.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoP1.dataOwnerId to AccessLevel.Write,
				userInfoP2.dataOwnerId to AccessLevel.Write
			).keyAsLocalDataOwnerReferences()
			hasUnknownAnonymousDataOwners shouldBe true
		}
		apiB.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoP1.dataOwnerId to AccessLevel.Read
			).keyAsLocalDataOwnerReferences()
			hasUnknownAnonymousDataOwners shouldBe true
		}
		apiP1.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoP1.dataOwnerId to AccessLevel.Write,
				userInfoP2.dataOwnerId to AccessLevel.Read
			).keyAsLocalDataOwnerReferences()
			hasUnknownAnonymousDataOwners shouldBe true
		}
		apiP2.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoP1.dataOwnerId to AccessLevel.Read, // P2 is only aware of the P1->P2 delegation
				userInfoP2.dataOwnerId to AccessLevel.Write
			).keyAsLocalDataOwnerReferences()
			hasUnknownAnonymousDataOwners shouldBe true
		}
	}

	"Even without de-anonymization metadata the data owners should be able to identify anonymous delegates if their parent is part of the delegation with that delegate.".config(enabled = DEFAULT_ENABLED) {
		val (parentUserInfo, parentApi) = createHcpUser().let { it to it.api(specJob) }
		val (childUserInfo, childApi) = createHcpUser(parentUserInfo).let { it to it.api(specJob) }
		println("${childUserInfo.username} ${childUserInfo.password}")
		val (patientInfo, patientApi) = createPatientUser().let { it to it.api(specJob) }
		var entity = parentApi.createSamplePatient()
		entity = parentApi.patient.shareWith(patientInfo.dataOwnerId, entity, PatientShareOptions(
			shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), false),
			requestedPermissions = RequestedPermission.FullWrite
		)
		)
		patientApi.crypto.forceReload()
		val expectedAccessInfo = EntityAccessInformation(
			permissionsByDataOwnerId = mapOf(
				// No child user: has no direct access, only access through parent delegation
				parentUserInfo.dataOwnerId to AccessLevel.Write,
				patientInfo.dataOwnerId to AccessLevel.Write
			).keyAsLocalDataOwnerReferences(),
			hasUnknownAnonymousDataOwners = false
		)
		childApi.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedAccessInfo
		parentApi.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedAccessInfo
		patientApi.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedAccessInfo
	}

	"De-anonymization metadata should allow data owners that are not part of a delegation to figure out the members of that delegation.".config(enabled = DEFAULT_ENABLED) {
		val (userInfoA, apiA) = createHcpUser().let { it to it.api(specJob) }
		val (userInfoB, apiB) = createHcpUser().let { it to it.api(specJob) }
		val (userInfoP1, apiP1) = createPatientUser().let { it to it.api(specJob) }
		val (userInfoP2, apiP2) = createPatientUser().let { it to it.api(specJob) }
		var entity = apiA.createSamplePatient()
		entity = apiA.patient.shareWith(userInfoB.dataOwnerId, entity, PatientShareOptions(
			shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), false),
			requestedPermissions = RequestedPermission.FullWrite
		)
		)
		entity = apiA.patient.shareWith(userInfoP1.dataOwnerId, entity, PatientShareOptions(
			shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), false),
			requestedPermissions = RequestedPermission.FullWrite
		)
		)
		entity = apiB.patient.shareWith(userInfoP1.dataOwnerId, entity, PatientShareOptions(
			shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), false),
			requestedPermissions = RequestedPermission.FullRead
		)
		)
		apiP1.crypto.forceReload()
		entity = apiP1.patient.shareWith(userInfoP2.dataOwnerId, entity, PatientShareOptions(
			shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), false),
			requestedPermissions = RequestedPermission.FullRead
		)
		)
		entity = apiA.patient.shareWith(userInfoP2.dataOwnerId, entity, PatientShareOptions(
			shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), false),
			requestedPermissions = RequestedPermission.FullWrite
		)
		)
		/*
		 * A->A  A->B    B->?P1
		 *       A->?P1  P1->?P2
		 *       A->?P2
		 */
		apiA.patient.createDelegationDeAnonymizationMetadata(
			entity,
			setOf(userInfoB.dataOwnerId, userInfoP1.dataOwnerId, userInfoP2.dataOwnerId)
		)
		/*
		 * A can create de-anonymization metadata for his delegations.
		 * A->A  A->B    B->?P1
		 *       A->P1  P1->?P2
		 *       A->P2
		 */
		val expectedAccessByDataOwnerId = mapOf(
			userInfoA.dataOwnerId to AccessLevel.Write,
			userInfoB.dataOwnerId to AccessLevel.Write,
			userInfoP1.dataOwnerId to AccessLevel.Write,
			userInfoP2.dataOwnerId to AccessLevel.Write
		).keyAsLocalDataOwnerReferences()
		apiP1.crypto.forceReload()
		apiP2.crypto.forceReload()
		apiA.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe expectedAccessByDataOwnerId
			hasUnknownAnonymousDataOwners shouldBe true
		}
		apiB.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe expectedAccessByDataOwnerId
			hasUnknownAnonymousDataOwners shouldBe true
		}
		apiP1.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe expectedAccessByDataOwnerId
			hasUnknownAnonymousDataOwners shouldBe false
		}
		apiP2.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe expectedAccessByDataOwnerId
			hasUnknownAnonymousDataOwners shouldBe true
		}
		apiP1.patient.createDelegationDeAnonymizationMetadata(
			entity,
			setOf(userInfoA.dataOwnerId, userInfoB.dataOwnerId, userInfoP2.dataOwnerId)
		)
		/* Both delegator and delegate can create de-anonymization metadata for a delegation.
		 * A->A  A->B   B->P1
		 *       A->P1  P1->P2
		 *       A->P2
		 */
		apiP2.crypto.forceReload()
		apiA.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe expectedAccessByDataOwnerId
			hasUnknownAnonymousDataOwners shouldBe false
		}
		apiB.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe expectedAccessByDataOwnerId
			hasUnknownAnonymousDataOwners shouldBe false
		}
		apiP1.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe expectedAccessByDataOwnerId
			hasUnknownAnonymousDataOwners shouldBe false
		}
		apiP2.patient.getDataOwnersWithAccessTo(entity).apply {
			permissionsByDataOwnerId shouldBe expectedAccessByDataOwnerId
			hasUnknownAnonymousDataOwners shouldBe false
		}
	}

	"Hcp should be able to use de-anonymization metadata for parent".config(enabled = DEFAULT_ENABLED) {
		val (grandUserInfo, grandApi) = createHcpUser().let { it to it.api(specJob) }
		val (parentUserInfo, parentApi) = createHcpUser(grandUserInfo).let { it to it.api(specJob) }
		val (child1UserInfo, child1Api) = createHcpUser(parentUserInfo).let { it to it.api(specJob) }
		val (child2UserInfo, child2Api) = createHcpUser(grandUserInfo).let { it to it.api(specJob) }
		val (patientInfo, patientApi) = createPatientUser().let { it to it.api(specJob) }
		println(parentApi.user.getCurrentUser().systemMetadata?.roles)
		var entity = parentApi.createSamplePatient() // Auto-shared with grandApi, but no de-anonymization metadata
		entity = parentApi.patient.shareWith(patientInfo.dataOwnerId, entity, PatientShareOptions(
			shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), false),
			requestedPermissions = RequestedPermission.FullWrite
		)
		)
		parentApi.patient.createDelegationDeAnonymizationMetadata(entity, setOf(grandUserInfo.dataOwnerId))
		patientApi.crypto.forceReload()
		val expectedAccess = EntityAccessInformation(
			mapOf(
				parentUserInfo.dataOwnerId to AccessLevel.Write,
				grandUserInfo.dataOwnerId to AccessLevel.Write,
				patientInfo.dataOwnerId to AccessLevel.Write
			).keyAsLocalDataOwnerReferences(),
			false
		)
		child1Api.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedAccess
		grandApi.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedAccess
		child2Api.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedAccess
		patientApi.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedAccess
		parentApi.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedAccess
	}

	"De-anonymization metadata should encrypt delegator and delegate, and its creation should be optimised".config(enabled = DEFAULT_ENABLED) {
		val (userInfoA, apiA) = createHcpUser().let { it to it.api(specJob) }
		val (userInfoB, apiB) = createHcpUser().let { it to it.api(specJob) }
		val (userInfoP, apiP) = createPatientUser().let { it to it.api(specJob) }
		var entity = apiA.createSamplePatient()
		entity = apiA.patient.shareWith(userInfoB.dataOwnerId, entity, PatientShareOptions(
			shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), false),
			requestedPermissions = RequestedPermission.FullWrite
		)
		)
		entity = apiA.patient.shareWith(userInfoP.dataOwnerId, entity, PatientShareOptions(
			shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), false),
			requestedPermissions = RequestedPermission.FullWrite
		)
		)
		apiA.patient.createDelegationDeAnonymizationMetadata(entity, setOf(userInfoB.dataOwnerId, userInfoP.dataOwnerId))
		val secureDelegationKeyMapApi = RawSecureDelegationKeyMapApiImpl(
			baseUrl,
			userInfoA.authService(),
			DefaultRawApiConfig
		)
		val secureDelegationKeyMaps = secureDelegationKeyMapApi.findByDelegationKeys(
			ListOfIds(
				entity.securityMetadata?.secureDelegations?.keys?.map { it.s }.shouldNotBeNull()
					.also { it.shouldNotBeEmpty() }),
			emptyList()
		).successBody()
		secureDelegationKeyMaps.shouldHaveSize(1)
		secureDelegationKeyMaps.single().also {
			it.delegator shouldBe null
			it.delegate shouldBe null
		}
		val delegationKeysToAnonymous = entity.securityMetadata?.secureDelegations?.filter { it.value.delegate == null }.shouldNotBeNull() // would be patient
		delegationKeysToAnonymous.shouldHaveSize(1)
		secureDelegationKeyMaps.single().delegationKey shouldBe delegationKeysToAnonymous.keys.single().s
	}

	"De-anonymization metadata should be usable for different entities of the same type".config(enabled = DEFAULT_ENABLED) {
		val (userInfoA, apiA) = createHcpUser().let { it to it.api(specJob) }
		val (userInfoB, apiB) = createHcpUser().let { it to it.api(specJob) }
		val (userInfoP1, apiP1) = createPatientUser().let { it to it.api(specJob) }
		var entity1 = apiA.createSamplePatient()
		entity1 = apiA.patient.shareWith(userInfoB.dataOwnerId, entity1, PatientShareOptions(
			shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), false),
			requestedPermissions = RequestedPermission.FullWrite
		)
		)
		entity1 = apiA.patient.shareWith(userInfoP1.dataOwnerId, entity1, PatientShareOptions(
			shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), false),
			requestedPermissions = RequestedPermission.FullWrite
		)
		)
		var entity2 = apiA.createSamplePatient()
		entity2 = apiA.patient.shareWith(userInfoB.dataOwnerId, entity2, PatientShareOptions(
			shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), false),
			requestedPermissions = RequestedPermission.FullWrite
		)
		)
		entity2 = apiA.patient.shareWith(userInfoP1.dataOwnerId, entity2, PatientShareOptions(
			shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), false),
			requestedPermissions = RequestedPermission.FullWrite
		)
		)
		apiA.patient.createDelegationDeAnonymizationMetadata(entity1, setOf(userInfoB.dataOwnerId, userInfoP1.dataOwnerId))
		val expectedAccess = EntityAccessInformation(
			mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoP1.dataOwnerId to AccessLevel.Write
			).keyAsLocalDataOwnerReferences(),
			false
		)
		apiP1.crypto.forceReload()
		apiA.patient.getDataOwnersWithAccessTo(entity1) shouldBe expectedAccess
		apiB.patient.getDataOwnersWithAccessTo(entity1) shouldBe expectedAccess
		apiP1.patient.getDataOwnersWithAccessTo(entity1) shouldBe expectedAccess
		apiA.patient.getDataOwnersWithAccessTo(entity2) shouldBe expectedAccess
		apiB.patient.getDataOwnersWithAccessTo(entity2) shouldBe expectedAccess
		apiP1.patient.getDataOwnersWithAccessTo(entity2) shouldBe expectedAccess
	}

	"De-anonymization metadata optimization: the metadata should not be re-shared with the anonymous delegator/delegate by third parties".config(enabled = DEFAULT_ENABLED) {
		val (userInfoA, apiA) = createHcpUser().let { it to it.api(specJob) }
		val (userInfoP1, apiP1) = createPatientUser().let { it to it.api(specJob) }
		val (userInfoP2, apiP2) = createPatientUser().let { it to it.api(specJob) }
		val delegationMapApi = RawSecureDelegationKeyMapApiImpl(
			baseUrl,
			userInfoA.authService(),
			DefaultRawApiConfig
		) // Use raw api from A as it does not require access control keys
		var entity = apiP1.createSamplePatient()
		entity = apiP1.patient.shareWith(userInfoA.dataOwnerId, entity, PatientShareOptions(
			shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), false),
			requestedPermissions = RequestedPermission.FullWrite
		)
		)
		entity = apiP1.patient.shareWith(userInfoP2.dataOwnerId, entity, PatientShareOptions(
			shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), false),
			requestedPermissions = RequestedPermission.FullWrite
		)
		)
		apiP1.patient.createDelegationDeAnonymizationMetadata(entity, setOf(userInfoA.dataOwnerId, userInfoP2.dataOwnerId))
		val p1ToP2DelegationKey = entity.securityMetadata?.secureDelegations?.filter { (_ ,v) ->
			v.delegate == null && v.delegator == null && v.parentDelegations.isNotEmpty()
		}.shouldNotBeNull().keys.single().s
		val delegationMapBeforeAttemptedResharingByA = delegationMapApi.findByDelegationKeys(
			ListOfIds(
				listOf(
					p1ToP2DelegationKey
				)
			), emptyList()).successBody().single()
		delegationMapBeforeAttemptedResharingByA.securityMetadata?.secureDelegations.shouldNotBeNull().shouldHaveSize(3)
		apiA.patient.createDelegationDeAnonymizationMetadata(entity, setOf(userInfoP2.dataOwnerId, userInfoP1.dataOwnerId))
		val delegationMapAfterAttemptedResharingByA = delegationMapApi.findByDelegationKeys(
			ListOfIds(
				listOf(
					p1ToP2DelegationKey
				)
			),
			emptyList()
		).successBody().single()
		delegationMapAfterAttemptedResharingByA.securityMetadata shouldBe delegationMapBeforeAttemptedResharingByA.securityMetadata
		delegationMapAfterAttemptedResharingByA.rev shouldBe delegationMapBeforeAttemptedResharingByA.rev
	}

	"De-anonymization metadata should be shared only with selected data owners".config(enabled = DEFAULT_ENABLED) {
		val (userInfoA, apiA) = createHcpUser().let { it to it.api(specJob) }
		val (userInfoB, apiB) = createHcpUser().let { it to it.api(specJob) }
		val (userInfoC, apiC) = createHcpUser().let { it to it.api(specJob) }
		val (userInfoP, apiP) = createPatientUser().let { it to it.api(specJob) }
		var entity = apiA.createSamplePatient()
		entity = apiA.patient.shareWith(userInfoB.dataOwnerId, entity, PatientShareOptions(
			shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), false),
			requestedPermissions = RequestedPermission.FullWrite
		)
		)
		entity = apiA.patient.shareWith(userInfoC.dataOwnerId, entity, PatientShareOptions(
			shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), false),
			requestedPermissions = RequestedPermission.FullWrite
		)
		)
		entity = apiA.patient.shareWith(userInfoP.dataOwnerId, entity, PatientShareOptions(
			shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), false),
			requestedPermissions = RequestedPermission.FullWrite
		)
		)
		apiA.patient.createDelegationDeAnonymizationMetadata(entity, setOf(userInfoB.dataOwnerId))
		val expectedFullAccess = EntityAccessInformation(
			mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoC.dataOwnerId to AccessLevel.Write,
				userInfoP.dataOwnerId to AccessLevel.Write
			).keyAsLocalDataOwnerReferences(),
			false
		)
		apiP.crypto.forceReload()
		apiA.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedFullAccess
		apiB.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedFullAccess
		apiP.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedFullAccess
		// Except C does not know about P, because he was not given access to the relevant metadata.
		apiC.patient.getDataOwnersWithAccessTo(entity) shouldBe EntityAccessInformation(
			mapOf(
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoC.dataOwnerId to AccessLevel.Write
			).keyAsLocalDataOwnerReferences(),
			true
		)
	}

	"A member of a delegation should be able to update the corresponding de-anonymization metadata even if he was not the original creator".config(enabled = DEFAULT_ENABLED) {
		val (userInfoA, apiA) = createHcpUser().let{ it to it.api(specJob) }
		val (userInfoB, apiB) = createHcpUser().let{ it to it.api(specJob) }
		val (userInfoC, apiC) = createHcpUser().let{ it to it.api(specJob) }
		val (userInfoP, apiP) = createPatientUser().let{ it to it.api(specJob) }
		val (grandUserInfo, parentApi) = createHcpUser().let{ it to it.api(specJob) }
		val (parentUserInfo, childApi) = createHcpUser(grandUserInfo).let{ it to it.api(specJob) }
		var entity = parentApi.createSamplePatient()
		entity = parentApi.patient.shareWith(userInfoA.dataOwnerId, entity, PatientShareOptions(
			shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), false),
			requestedPermissions = RequestedPermission.FullWrite
		)
		)
		entity = parentApi.patient.shareWith(userInfoB.dataOwnerId, entity, PatientShareOptions(
			shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), false),
			requestedPermissions = RequestedPermission.FullWrite
		)
		)
		entity = parentApi.patient.shareWith(userInfoC.dataOwnerId, entity, PatientShareOptions(
			shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), false),
			requestedPermissions = RequestedPermission.FullWrite
		)
		)
		entity = parentApi.patient.shareWith(userInfoP.dataOwnerId, entity, PatientShareOptions(
			shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), false),
			requestedPermissions = RequestedPermission.FullWrite
		)
		)
		// Child shares de-anonymization info with A
		childApi.patient.createDelegationDeAnonymizationMetadata(
			entity,
			setOf(userInfoA.dataOwnerId)
		)
		// P shares with B
		apiP.crypto.forceReload()
		apiP.patient.createDelegationDeAnonymizationMetadata(
			entity,
			setOf(userInfoB.dataOwnerId)
		)
		// Parent shares with C
		parentApi.patient.createDelegationDeAnonymizationMetadata(
			entity,
			setOf(userInfoC.dataOwnerId)
		)
		val expectedAccess = EntityAccessInformation(
			mapOf(
				grandUserInfo.dataOwnerId to AccessLevel.Write,
				userInfoA.dataOwnerId to AccessLevel.Write,
				userInfoB.dataOwnerId to AccessLevel.Write,
				userInfoC.dataOwnerId to AccessLevel.Write,
				userInfoP.dataOwnerId to AccessLevel.Write
			).keyAsLocalDataOwnerReferences(),
			false
		)
		parentApi.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedAccess
		childApi.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedAccess
		apiA.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedAccess
		apiB.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedAccess
		apiC.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedAccess
		apiP.patient.getDataOwnersWithAccessTo(entity) shouldBe expectedAccess
		val delegationKeyMapApi = RawSecureDelegationKeyMapApiImpl(
			baseUrl,
			userInfoA.authService(),
			DefaultRawApiConfig
		)
		val delegationKeyToP = entity.securityMetadata?.secureDelegations?.filter { it.value.delegate == null }?.keys?.map { it.s }.shouldNotBeNull().single()
		delegationKeyMapApi.findByDelegationKeys(
			ListOfIds(listOf(delegationKeyToP)),
			emptyList()
		).successBody().shouldHaveSize(1)
	}
})
