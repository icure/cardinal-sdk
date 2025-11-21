package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.api.raw.impl.RawGroupApiImpl
import com.icure.cardinal.sdk.crypto.entities.PatientShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions
import com.icure.cardinal.sdk.model.DatabaseInitialisation
import com.icure.cardinal.sdk.model.DecryptedHealthElement
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.test.DataOwnerDetails
import com.icure.cardinal.sdk.test.DefaultRawApiConfig
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.baseUrl
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.createPatientUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.superadminAuth
import com.icure.cardinal.sdk.test.uuid
import com.icure.utils.InternalIcureApi
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

@OptIn(InternalIcureApi::class)
class InterGroupSharingTest : StringSpec({
	val grandparentGroupId = "grandparent-${uuid()}"
	val parentGroupId = "parent-${uuid()}"
	val childGroupId = "child-${uuid()}"
	val specJob = autoCancelJob()

	beforeSpec {
		initializeTestEnvironment()
		val groupApi = RawGroupApiImpl(baseUrl, superadminAuth(), DefaultRawApiConfig)
		groupApi.createGroup(
			grandparentGroupId,
			name = "grandparent",
			password = uuid(),
			initialisationData = DatabaseInitialisation()
		).successBody().id
		groupApi.createGroup(
			parentGroupId,
			name = "parent",
			password = uuid(),
			initialisationData = DatabaseInitialisation(),
			superGroup = grandparentGroupId
		).successBody().id
		groupApi.createGroup(
			childGroupId,
			name = "child",
			password = uuid(),
			initialisationData = DatabaseInitialisation(),
			superGroup = parentGroupId
		).successBody().id
	}

	suspend fun createDataOwner(
		explicit: Boolean,
		groupId: String,
	): DataOwnerDetails =
		if (explicit) {
			createHcpUser(inGroup = groupId, inheritsPermissions = groupId != childGroupId)
		} else {
			createPatientUser(inGroup = groupId, inheritsPermissions = groupId != childGroupId)
		}

	suspend fun checkCanGet(
		api: CardinalSdk,
		apiGroup: String,
		basePatient: Patient,
		baseHe: HealthElement,
	) {
		api.crypto.forceReload()
		api.patient.inGroup.getPatient(
			groupId = childGroupId,
			entityId = basePatient.id
		).shouldNotBeNull().entity.note shouldBe basePatient.note
		if (apiGroup == childGroupId) {
			api.patient.getPatient(basePatient.id).shouldNotBeNull().note shouldBe basePatient.note
		}
		api.healthElement.inGroup.getHealthElement(
			groupId = childGroupId,
			entityId = baseHe.id
		).shouldNotBeNull().entity.descr shouldBe baseHe.descr
		if (apiGroup == childGroupId) {
			api.healthElement.getHealthElement(baseHe.id).shouldNotBeNull().descr shouldBe baseHe.descr
		}
	}

	suspend fun testCreateSharedData(
		explicitDelegator: Boolean,
		delegatorGroupId: String,
		explicitDelegate: Boolean,
		delegateGroupId: String
	) {
		val delegator = createDataOwner(explicitDelegator, delegatorGroupId)
		val delegate = createDataOwner(explicitDelegate, delegateGroupId)
		val delegatorApi = delegator.api(specJob)
		val delegateApi = delegate.api(specJob)
		suspend fun doTest(useFullReferences: Boolean) {
			val basePatient = DecryptedPatient(
				id = uuid(),
				firstName = "Gino",
				lastName = "Pino",
				note = "super secret note in patient"
			)
			val delegateReference = if (useFullReferences) delegate.fullReference else delegate.normalizedReferenceForGroup(delegator.groupId)
			val createdPatient = delegatorApi.patient.inGroup.createPatient(
				delegatorApi.patient.inGroup.withEncryptionMetadata(
					entityGroupId = childGroupId,
					base = basePatient,
					delegates = mapOf(delegateReference to AccessLevel.Write)
				),
			)
			val baseHe = DecryptedHealthElement(
				id = uuid(),
				descr = "super secret note in he"
			)
			delegatorApi.healthElement.inGroup.createHealthElement(
				delegatorApi.healthElement.inGroup.withEncryptionMetadata(
                    entityGroupId = childGroupId,
                    base = baseHe,
                    patient = createdPatient,
                    delegates = mapOf(delegateReference to AccessLevel.Write)
				)
			)
			checkCanGet(delegatorApi, delegator.groupId, basePatient, baseHe)
			checkCanGet(delegateApi, delegate.groupId, basePatient, baseHe)
		}
		doTest(true)
		doTest(false)
	}

	suspend fun testShareExistingData(
		explicitDelegator: Boolean,
		delegatorGroupId: String,
		explicitDelegate: Boolean,
		delegateGroupId: String
	) {
		val delegator = createDataOwner(explicitDelegator, delegatorGroupId)
		val delegate = createDataOwner(explicitDelegate, delegateGroupId)
		val delegatorApi = delegator.api(specJob)
		val delegateApi = delegate.api(specJob)
		suspend fun doTest(useFullReferences: Boolean) {
			val basePatient = DecryptedPatient(
				id = uuid(),
				firstName = "Gino",
				lastName = "Pino",
				note = "super secret note in patient"
			)
			val delegateReference = if (useFullReferences) delegate.fullReference else delegate.normalizedReferenceForGroup(delegator.groupId)
			val patient = delegatorApi.patient.inGroup.createPatient(
				delegatorApi.patient.inGroup.withEncryptionMetadata(
					childGroupId,
					basePatient
				)
			).shouldNotBeNull()
			val sfk = delegatorApi.patient.inGroup.getSecretIdsOf(patient).keys.also { it shouldHaveSize 1 }
			val baseHe = DecryptedHealthElement(
				id = uuid(),
				descr = "super secret note in he"
			)
			val he = delegatorApi.healthElement.inGroup.createHealthElement(
				delegatorApi.healthElement.inGroup.withEncryptionMetadata(
                    entityGroupId = childGroupId,
                    base = baseHe,
                    patient = patient,
                    user = delegatorApi.user.getCurrentUser()
				)
			).shouldNotBeNull()
			delegatorApi.patient.inGroup.shareWith(
				delegateReference,
				patient,
				PatientShareOptions(shareSecretIds = SecretIdShareOptions.UseExactly(sfk, false))
			).shouldNotBeNull()
			delegatorApi.healthElement.inGroup.shareWith(
				delegateReference,
				he
			).shouldNotBeNull()
			checkCanGet(delegatorApi, delegator.groupId, basePatient, baseHe)
			checkCanGet(delegateApi, delegate.groupId, basePatient, baseHe)
		}
		doTest(true)
		doTest(false)
	}


	listOf(
		Pair(Pair("groupE", childGroupId), Pair("groupE", childGroupId)),
		Pair(Pair("groupE", childGroupId), Pair("groupX", parentGroupId)),
		Pair(Pair("groupX", parentGroupId), Pair("groupE", childGroupId)),
		Pair(Pair("groupX", parentGroupId), Pair("groupX", parentGroupId)),
		Pair(Pair("groupX", parentGroupId), Pair("groupY", grandparentGroupId)),
	).forEach { (delegatorGroupInfo, delegateGroupInfo) ->
		listOf(
			Pair(Pair("explicit", true), Pair("explicit", true)),
			Pair(Pair("explicit", true), Pair("anonymous", false)),
			Pair(Pair("anonymous", false), Pair("explicit", true)),
			Pair(Pair("anonymous", false), Pair("anonymous", false)),
		).forEach { (delegatorType, delegateType) ->
			"Test create shared data ${delegatorGroupInfo.first}/${delegatorType.first} -> ${delegateGroupInfo.first}/${delegateType.first}" {
				testCreateSharedData(
					delegatorType.second,
					delegatorGroupInfo.second,
					delegateType.second,
					delegateGroupInfo.second
				)
			}

			"Test share existing data ${delegatorGroupInfo.first}/${delegatorType.first} -> ${delegateGroupInfo.first}/${delegateType.first}" {
				testShareExistingData(
					delegatorType.second,
					delegatorGroupInfo.second,
					delegateType.second,
					delegateGroupInfo.second
				)
			}
		}
	}
})
