package com.icure.cardinal.sdk

import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.storage.impl.VolatileStorageFacade
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.cardinal.sdk.utils.RequestStatusException
import com.icure.kryptom.crypto.defaultCryptoService
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

class SdkDataOwnerScopeTest : StringSpec({
	val specJob = autoCancelJob()

	beforeSpec {
		initializeTestEnvironment()
	}

	"SDK should allow to switch data owner scope".config(enabled = DEFAULT_ENABLED) {
		val parent = createHcpUser(roles = setOf("ANY_ACTING_SCOPE", "BASIC_DATA_OWNER", "HIERARCHICAL_DATA_OWNER"))
		val child = createHcpUser(parent = parent)
		val initialSdk = parent.api(specJob)
		initialSdk.dataOwner.getCurrentDataOwnerHierarchyIds() shouldBe listOf(parent.dataOwnerId)
		val createdByParent = initialSdk.patient.createPatient(
			initialSdk.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = defaultCryptoService.strongRandom.randomUUID(),
					firstName = "By",
					lastName = "Parent"
				)
			)
		)
		initialSdk.patient.getDataOwnersWithAccessTo(createdByParent).apply {
			hasUnknownAnonymousDataOwners shouldBe false
			permissionsByDataOwnerId shouldBe mapOf(EntityReferenceInGroup(parent.dataOwnerId) to AccessLevel.Write)
		}
		val switchedSdk = initialSdk.changeScope(child.dataOwnerId)
		switchedSdk.dataOwner.getCurrentDataOwnerHierarchyIds() shouldBe listOf(parent.dataOwnerId, child.dataOwnerId)
		val createdByChild = switchedSdk.patient.createPatient(
			switchedSdk.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = defaultCryptoService.strongRandom.randomUUID(),
					firstName = "By",
					lastName = "Child"
				)
			)
		)
		switchedSdk.patient.getDataOwnersWithAccessTo(createdByChild).apply {
			hasUnknownAnonymousDataOwners shouldBe false
			permissionsByDataOwnerId shouldBe mapOf(EntityReferenceInGroup(child.dataOwnerId) to AccessLevel.Write)
		}
		switchedSdk.patient.getPatient(createdByParent.id).shouldNotBeNull().id shouldBe createdByParent.id
		shouldThrow<RequestStatusException> { initialSdk.patient.getPatient(createdByChild.id) }.statusCode shouldBe 403
	}
})