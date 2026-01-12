package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.uuid
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.CryptoService
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSingleElement
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.maps.shouldContainKey
import io.kotest.matchers.maps.shouldHaveSize
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

private object ParentDelegatorStrategies : CryptoStrategies {
	override suspend fun generateNewKeyForDataOwner(
		self: DataOwnerWithType,
		cryptoPrimitives: CryptoService
	): CryptoStrategies.KeyGenerationRequestResult =
		CryptoStrategies.KeyGenerationRequestResult.ParentDelegator
}

class ParentDelegatorTest : StringSpec({
	val specJob = autoCancelJob()

	beforeSpec {
		initializeTestEnvironment()
	}

	"Data should be created and shared using the parent hcp as delegator" {
		val parentHcp = createHcpUser()
		val hcp = createHcpUser(parentHcp)
		val api = hcp.apiWithParentKeysOnly(specJob, ParentDelegatorStrategies)
		val created = api.patient.createPatient(
			api.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = uuid(),
					firstName = "Delegated",
					lastName = "Patient",
					note = "Secret note"
				)
			)
		)
		created.note shouldBe "Secret note"
		val createdExchangeDataId = created.securityMetadata.shouldNotBeNull().secureDelegations.also { it.shouldHaveSize(1) }.values.first().let {
			it.delegator shouldBe parentHcp.dataOwnerId
			it.delegate shouldBe parentHcp.dataOwnerId
			it.exchangeDataId.shouldNotBeNull()
		}
		val rootKey = created.securityMetadata.secureDelegations.keys.first()
		val other = createHcpUser()
		val otherApi = other.api(specJob)
		val shared = api.patient.shareWith(
			other.dataOwnerId,
			created
		)
		shared.note shouldBe "Secret note"
		val sharedExchangeDataId = shared.securityMetadata.shouldNotBeNull().secureDelegations.also {
			it.shouldHaveSize(2)
			it.shouldContainKey(rootKey)
		}.entries.first { it.key != rootKey }.value.let {
			it.delegator shouldBe parentHcp.dataOwnerId
			it.delegate shouldBe other.dataOwnerId
			it.exchangeDataId.shouldNotBeNull()
		}
		val retrievedAsOther = otherApi.patient.getPatient(created.id)
		retrievedAsOther.shouldNotBeNull().note shouldBe "Secret note"
		val reinitializedApi = hcp.apiWithParentKeysOnly(specJob, ParentDelegatorStrategies)
		val createdAfterReinit = reinitializedApi.patient.createPatient(
			reinitializedApi.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = uuid(),
					firstName = "Delegated 2",
					lastName = "Patient 2",
					note = "Another secret note"
				),
				delegates = mapOf(other.dataOwnerId to AccessLevel.Write)
			)
		)
		createdAfterReinit.securityMetadata.shouldNotBeNull().secureDelegations.values.also { delegations ->
			delegations.shouldHaveSize(2)
			delegations.shouldHaveSingleElement {
				it.delegator == parentHcp.dataOwnerId && it.delegate == parentHcp.dataOwnerId && it.exchangeDataId == createdExchangeDataId
			}
			delegations.shouldHaveSingleElement {
				it.delegator == parentHcp.dataOwnerId && it.delegate == other.dataOwnerId && it.exchangeDataId == sharedExchangeDataId
			}
		}
		val retrievedAsOtherAfterReinit = otherApi.patient.getPatient(createdAfterReinit.id)
		retrievedAsOtherAfterReinit.shouldNotBeNull().note shouldBe "Another secret note"
	}

	"Data shared to parent should be accessible" {
		val parentHcp = createHcpUser()
		val hcp = createHcpUser(parentHcp)
		val api = hcp.apiWithParentKeysOnly(specJob, ParentDelegatorStrategies)
		val otherApi = createHcpUser().api(specJob)
		val created = otherApi.patient.createPatient(
			otherApi.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = uuid(),
					firstName = "Delegated",
					lastName = "Patient",
					note = "Secret note"
				),
				delegates = mapOf(parentHcp.dataOwnerId to AccessLevel.Write)
			)
		)
		val retrievedAsHcp = api.patient.getPatient(created.id)
		retrievedAsHcp.shouldNotBeNull().note shouldBe "Secret note"
	}

	"Data shared directly to hcp should be accessible but not decryptable" {
		val parentHcp = createHcpUser()
		val hcp = createHcpUser(parentHcp)
		val api = hcp.apiWithParentKeysOnly(specJob, ParentDelegatorStrategies)
		val otherApi = createHcpUser().api(specJob)
		val created = otherApi.patient.createPatient(
			otherApi.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = uuid(),
					firstName = "Delegated",
					lastName = "Patient",
					note = "Secret note"
				),
				delegates = mapOf(hcp.dataOwnerId to AccessLevel.Write)
			)
		)
		val retrievedAsHcp = api.patient.encrypted.getPatient(created.id)
		retrievedAsHcp.shouldNotBeNull().note.shouldBeNull()
		shouldThrow<EntityEncryptionException> {
			api.patient.decrypt(listOf(retrievedAsHcp))
		}
	}
})