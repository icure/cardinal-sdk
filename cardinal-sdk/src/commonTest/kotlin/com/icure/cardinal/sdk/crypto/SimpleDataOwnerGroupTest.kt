package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.api.raw.impl.RawDataOwnerApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawExchangeDataApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawHealthcarePartyApiImpl
import com.icure.cardinal.sdk.crypto.impl.exportSpkiHex
import com.icure.cardinal.sdk.model.DataOwnerType
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.base.DataOwnerGroupLink
import com.icure.cardinal.sdk.model.base.DataOwnerGroupLinkType
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.test.DefaultRawApiConfig
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.baseUrl
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.createPatientUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.superadminAuth
import com.icure.cardinal.sdk.test.testGroupId
import com.icure.cardinal.sdk.test.uuid
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.utils.InternalIcureApi
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.shouldBeInstanceOf
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonPrimitive
import kotlin.random.Random
import kotlin.time.Clock

@OptIn(InternalIcureApi::class)
class SimpleDataOwnerGroupTest : FreeSpec({
	isolationMode = IsolationMode.InstancePerLeaf
	val specJob = autoCancelJob()

	beforeSpec {
		initializeTestEnvironment()
	}

	"Anonymous data owner -> simple data owner group data sharing is currently unsupported" {
		val patient = createPatientUser()
		val group = createHcpUser(groupLinkType = DataOwnerGroupLinkType.Simple)
		val memberA = createHcpUser(parent = group, groupLinkType = DataOwnerGroupLinkType.NotAllowed)
		val memberB = createHcpUser(parent = group)
		val patientApi = patient.api(specJob)
		shouldThrow<UnsupportedOperationException> {
			patientApi.patient.createPatient(
				patientApi.patient.withEncryptionMetadata(
					DecryptedPatient(
						uuid(),
						firstName = "John",
						lastName = "Doe",
						note = "Secret"
					),
					delegates = mapOf(group.dataOwnerId to AccessLevel.Write)
				)
			)
		}
	}

	"A data owner should be able to share data with a simple data owner group" - {
		val hcp = createHcpUser()
		val group = createHcpUser(groupLinkType = DataOwnerGroupLinkType.Simple)
		val memberA = createHcpUser(
			parent = group,
			groupLinkType = DataOwnerGroupLinkType.NotAllowed,
			roles = setOf("BASIC_DATA_OWNER", "HIERARCHICAL_DATA_OWNER", "OWN_GROUP_MANAGER")
		)
		val memberB = createHcpUser(parent = group, groupLinkType = DataOwnerGroupLinkType.NotAllowed)
		val hcpApi = hcp.api(specJob)
		val memberAApi = memberA.api(specJob)
		val memberBApi = memberB.api(specJob)
		val patient = hcpApi.patient.createPatient(
			hcpApi.patient.withEncryptionMetadata(
				DecryptedPatient(
					uuid(),
					firstName = "John",
					lastName = "Doe",
					note = "Secret"
				),
				delegates = mapOf(group.dataOwnerId to AccessLevel.Write)
			)
		)
		patient.note shouldBe "Secret"
		hcpApi.patient.getPatient(patient.id).shouldNotBeNull().note shouldBe "Secret"

		"and direct members of that group should be able to read it" {
			memberAApi.patient.getPatient(patient.id).shouldNotBeNull().note shouldBe "Secret"
			memberBApi.patient.getPatient(patient.id).shouldNotBeNull().note shouldBe "Secret"
		}

		"and members added in a second moment should be able to read it after they have been giving access to existing exchange data" {
			val memberC = createHcpUser(parent = group, groupLinkType = DataOwnerGroupLinkType.NotAllowed)
			memberAApi.dataOwner.addDataOwnersToGroup(DataOwnerType.Hcp, group.dataOwnerId, setOf(memberC.dataOwnerId))
			val memberCApi = memberC.api(specJob)
			// Can get but not yet decrypt
			memberCApi.patient.tryAndRecover.getPatient(patient.id).shouldNotBeNull().shouldBeInstanceOf<EncryptedPatient>()
			memberAApi.crypto.ensureHasAccessToSharedSimpleDataOwnerGroupExchangeData(
				memberC.dataOwnerId,
				group.dataOwnerId,
			) shouldBe true
			// Can now get and decrypt
			memberCApi.crypto.forceReload()
			memberCApi.patient.getPatient(patient.id).shouldNotBeNull().note shouldBe "Secret"
		}

		"and if a group member lost their key other members should be able to reshare with them" {
			val (lostKeyApi, newKey) = memberB.apiWithLostKeys(specJob)
			lostKeyApi.patient.tryAndRecover.getPatient(patient.id).shouldNotBeNull().shouldBeInstanceOf<EncryptedPatient>()
			memberAApi.crypto.ensureHasAccessToSharedSimpleDataOwnerGroupExchangeData(
				memberB.dataOwnerId,
				group.dataOwnerId,
				defaultCryptoService.rsa.exportSpkiHex(newKey.public)
			) shouldBe true
			lostKeyApi.crypto.forceReload()
			lostKeyApi.patient.getPatient(patient.id).shouldNotBeNull().note shouldBe "Secret"
		}
	}

	"A data owner member of a simple group should be able to share data with their group" {
		val group = createHcpUser(groupLinkType = DataOwnerGroupLinkType.Simple)
		val memberA = createHcpUser(parent = group, groupLinkType = DataOwnerGroupLinkType.NotAllowed)
		val memberB = createHcpUser(parent = group)
		val memberAApi = memberA.api(specJob)
		val memberBApi = memberB.api(specJob)
		val patient = memberAApi.patient.createPatient(
			memberAApi.patient.withEncryptionMetadata(
				DecryptedPatient(
					uuid(),
					firstName = "John",
					lastName = "Doe",
					note = "Secret"
				),
				delegates = mapOf(group.dataOwnerId to AccessLevel.Write)
			)
		)
		patient.note shouldBe "Secret"
		memberAApi.patient.getPatient(patient.id).shouldNotBeNull().note shouldBe "Secret"
		memberBApi.patient.getPatient(patient.id).shouldNotBeNull().note shouldBe "Secret"
	}

	"When a data owner is removed from a group existing exchange data should be invalidated if already shared with the data owner" - {
		val hcp = createHcpUser()
		val group = createHcpUser(groupLinkType = DataOwnerGroupLinkType.Simple)
		val memberA = createHcpUser(
			parent = group,
			groupLinkType = DataOwnerGroupLinkType.NotAllowed,
			roles = setOf("BASIC_DATA_OWNER", "HIERARCHICAL_DATA_OWNER", "OWN_GROUP_MANAGER")
		)
		val memberB = createHcpUser(parent = group, groupLinkType = DataOwnerGroupLinkType.NotAllowed)
		val hcpApi = hcp.api(specJob)
		val memberAApi = memberA.api(specJob)
		val patient1 = hcpApi.patient.createPatient(
			hcpApi.patient.withEncryptionMetadata(
				DecryptedPatient(
					uuid(),
					firstName = "John",
					lastName = "Doe",
					note = "Secret"
				),
				delegates = mapOf(group.dataOwnerId to AccessLevel.Write)
			)
		)
		fun Patient.exchangeDataToGroupId() =
			securityMetadata.shouldNotBeNull().secureDelegations.values.filter {
				it.delegate == group.dataOwnerId
			}.shouldHaveSize(1).single().exchangeDataId.shouldNotBeNull()
		memberAApi.dataOwner.removeDataOwnersFromGroup(DataOwnerType.Hcp, group.dataOwnerId, setOf(memberB.dataOwnerId))
		hcpApi.crypto.forceReload()
		val patient2 = hcpApi.patient.createPatient(
			hcpApi.patient.withEncryptionMetadata(
				DecryptedPatient(
					uuid(),
					firstName = "John",
					lastName = "Doe",
					note = "Secret"
				),
				delegates = mapOf(group.dataOwnerId to AccessLevel.Write)
			)
		)
		patient1.exchangeDataToGroupId() shouldNotBe patient2.exchangeDataToGroupId()

		"Re-removing the data owner should not re-invalidate the new exchange data" {
			memberAApi.dataOwner.removeDataOwnersFromGroup(DataOwnerType.Hcp, group.dataOwnerId, setOf(memberB.dataOwnerId))
			hcpApi.crypto.forceReload()
			val patient3 = hcpApi.patient.createPatient(
				hcpApi.patient.withEncryptionMetadata(
					DecryptedPatient(
						uuid(),
						firstName = "John",
						lastName = "Doe",
						note = "Secret"
					),
					delegates = mapOf(group.dataOwnerId to AccessLevel.Write)
				)
			)
			patient3.exchangeDataToGroupId() shouldBe patient2.exchangeDataToGroupId()
		}

		"Adding then removing a member for which no exchange data was ever shared should not invalidate the existing exchange data" {
			val memberC = createHcpUser(parent = group, groupLinkType = DataOwnerGroupLinkType.NotAllowed)
			memberAApi.dataOwner.addDataOwnersToGroup(DataOwnerType.Hcp, group.dataOwnerId, setOf(memberC.dataOwnerId))
			memberAApi.dataOwner.removeDataOwnersFromGroup(DataOwnerType.Hcp, group.dataOwnerId, setOf(memberC.dataOwnerId))
			hcpApi.crypto.forceReload()
			val patient3 = hcpApi.patient.createPatient(
				hcpApi.patient.withEncryptionMetadata(
					DecryptedPatient(
						uuid(),
						firstName = "John",
						lastName = "Doe",
						note = "Secret"
					),
					delegates = mapOf(group.dataOwnerId to AccessLevel.Write)
				)
			)
			patient3.exchangeDataToGroupId() shouldBe patient2.exchangeDataToGroupId()
		}
	}

	"Data should be shared transitively with members at all layers of the group" {
		val topSimple = createHcpUser(groupLinkType = DataOwnerGroupLinkType.Simple)
		val memberA = createHcpUser(parent = topSimple, groupLinkType = DataOwnerGroupLinkType.NotAllowed)
		val middleSimple = createHcpUser(parent = topSimple, groupLinkType = DataOwnerGroupLinkType.Simple)
		val memberB = createHcpUser(parent = middleSimple, groupLinkType = DataOwnerGroupLinkType.NotAllowed)
		val parent = createHcpUser(parent = middleSimple, groupLinkType = DataOwnerGroupLinkType.Parent)
		val lowSimple = createHcpUser(parent = middleSimple, groupLinkType = DataOwnerGroupLinkType.Simple)
		val memberC = createHcpUser(parent = lowSimple, groupLinkType = DataOwnerGroupLinkType.NotAllowed)
		val memberD = createHcpUser(parent = lowSimple, groupLinkType = DataOwnerGroupLinkType.NotAllowed)
		val childA = createHcpUser(parent = parent, groupLinkType = DataOwnerGroupLinkType.NotAllowed)
		val childB = createHcpUser(parent = parent, groupLinkType = DataOwnerGroupLinkType.NotAllowed)
		val memberAApi = memberA.api(specJob)
		val memberBApi = memberB.api(specJob)
		val memberCApi = memberC.api(specJob)
		val memberDApi = memberD.api(specJob)
		val childAApi = childA.api(specJob)
		val childBApi = childB.api(specJob)
		val patient = childAApi.patient.createPatient(
			childAApi.patient.withEncryptionMetadata(
				DecryptedPatient(
					uuid(),
					firstName = "John",
					lastName = "Doe",
					note = "Secret"
				),
				delegates = mapOf(topSimple.dataOwnerId to AccessLevel.Write)
			)
		)
		memberAApi.patient.getPatient(patient.id).shouldNotBeNull().note shouldBe "Secret"
		memberBApi.patient.getPatient(patient.id).shouldNotBeNull().note shouldBe "Secret"
		memberCApi.patient.getPatient(patient.id).shouldNotBeNull().note shouldBe "Secret"
		memberDApi.patient.getPatient(patient.id).shouldNotBeNull().note shouldBe "Secret"
		childAApi.patient.getPatient(patient.id).shouldNotBeNull().note shouldBe "Secret"
		childBApi.patient.getPatient(patient.id).shouldNotBeNull().note shouldBe "Secret"
		val rawExchangeDataApi = RawExchangeDataApiImpl(
			baseUrl,
			childA.authService(),
			DefaultRawApiConfig
		)
		val groupId = rawExchangeDataApi.getExchangeDataByDelegatorDelegateForRecipients(
			childA.dataOwnerId,
			topSimple.dataOwnerId,
			JsonArray(listOf(JsonPrimitive(childA.dataOwnerId))).toString()
		).successBody().rows.shouldHaveSize(1).single().let {
			it.recipient shouldBe childA.dataOwnerId
			it.exchangeDataGroupId.shouldNotBeNull()
		}
		val allPiecesOfGroup = rawExchangeDataApi.getExchangeDataGroupById(
			groupId
		).successBody().rows
		allPiecesOfGroup.shouldHaveSize(6).map { it.recipient }.toSet() shouldBe setOf(
			memberA.dataOwnerId,
			memberB.dataOwnerId,
			memberC.dataOwnerId,
			memberD.dataOwnerId,
			parent.dataOwnerId,
			childA.dataOwnerId, // child A has an explicit recipient piece as he is the delegator
			// childB has no explicit recipient piece, it access the group exchange data through parent
		)
	}

	"In a group where the same recipient can be reached through multiple paths there is only one piece created per recipient" {
		val hcp = createHcpUser()
		val hcpApi = hcp .api(specJob)
		val topGroup = createHcpUser(groupLinkType = DataOwnerGroupLinkType.Simple)
		val middleA = createHcpUser(parent = topGroup, groupLinkType = DataOwnerGroupLinkType.Simple)
		val middleB = createHcpUser(parent = topGroup, groupLinkType = DataOwnerGroupLinkType.Simple)
		val memberA = createHcpUser(parent = middleA, groupLinkType = DataOwnerGroupLinkType.NotAllowed)
		val memberB = createHcpUser(parents = listOf(middleA, middleB), groupLinkType = DataOwnerGroupLinkType.NotAllowed)
		val memberC = createHcpUser(parent = middleB, groupLinkType = DataOwnerGroupLinkType.NotAllowed)
		val memberAApi = memberA.api(specJob)
		val memberBApi = memberB.api(specJob)
		val memberCApi = memberC.api(specJob)
		val patient = hcpApi.patient.createPatient(
			hcpApi.patient.withEncryptionMetadata(
				DecryptedPatient(
					uuid(),
					firstName = "John",
					lastName = "Doe",
					note = "Secret"
				),
				delegates = mapOf(topGroup.dataOwnerId to AccessLevel.Write)
			)
		)
		patient.note shouldBe "Secret"
		hcpApi.patient.getPatient(patient.id).shouldNotBeNull().note shouldBe "Secret"
		memberAApi.patient.getPatient(patient.id).shouldNotBeNull().note shouldBe "Secret"
		memberBApi.patient.getPatient(patient.id).shouldNotBeNull().note shouldBe "Secret"
		memberCApi.patient.getPatient(patient.id).shouldNotBeNull().note shouldBe "Secret"
		val rawExchangeDataApi = RawExchangeDataApiImpl(
			baseUrl,
			hcp.authService(),
			DefaultRawApiConfig
		)
		val groupId = rawExchangeDataApi.getExchangeDataByDelegatorDelegateForRecipients(
			hcp.dataOwnerId,
			topGroup.dataOwnerId,
			JsonArray(listOf(JsonPrimitive(hcp.dataOwnerId))).toString()
		).successBody().rows.shouldHaveSize(1).single().let {
			it.recipient shouldBe hcp.dataOwnerId
			it.exchangeDataGroupId.shouldNotBeNull()
		}
		val allPiecesOfGroup = rawExchangeDataApi.getExchangeDataGroupById(
			groupId
		).successBody().rows
		allPiecesOfGroup.shouldHaveSize(4).map { it.recipient }.toSet() shouldBe setOf(
			memberA.dataOwnerId,
			memberB.dataOwnerId,
			memberC.dataOwnerId,
			hcp.dataOwnerId,
		)
	}

	"Should work for very large groups" {
		val hcp = createHcpUser()
		val topGroup = createHcpUser(groupLinkType = DataOwnerGroupLinkType.Simple)
		val hcpRawApi = RawHealthcarePartyApiImpl(baseUrl, superadminAuth(), DefaultRawApiConfig)
		val dataOwnerRawApi = RawDataOwnerApiImpl(baseUrl, superadminAuth(), DefaultRawApiConfig)
		// Use shared key for this test, otherwise takes too long
		val keySpki = defaultCryptoService.rsa.exportSpkiHex(
			defaultCryptoService.rsa.generateKeyPair(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256).public
		)
		repeat(100) { i ->
			val intermediateGroup = Random.nextBytes(16).toHexString(HexFormat.UpperCase).let {
				HealthcareParty(
					it,
					firstName = "Intermediate-$i-$it",
					lastName = "Intermediate-$i-$it",
					dataOwnerGroups = listOf(DataOwnerGroupLink(topGroup.dataOwnerId)),
					groupLinkType = DataOwnerGroupLinkType.Simple,
				)
			}
			hcpRawApi.createHealthcarePartyInGroup(testGroupId, intermediateGroup).successBody()
			val extraMembers = List(100) { j ->
				val hcpId = Random.nextBytes(16).toHexString(HexFormat.UpperCase)
				HealthcareParty(
					hcpId,
					firstName = "LeafHcp-$i-$j-$hcpId",
					lastName = "LeafHcp-$i-$j-$hcpId",
					publicKeysForOaepWithSha256 = setOf(keySpki),
					dataOwnerGroups = listOf(DataOwnerGroupLink(intermediateGroup.id)),
					groupLinkType = DataOwnerGroupLinkType.NotAllowed,
				)
			}
			hcpRawApi.createHealthcarePartiesInGroup(testGroupId, extraMembers).successBody()
			// Ensure view is up-to-date before creating more
			dataOwnerRawApi.findDataOwnersLinkedToGroups(
				dataOwnerType = DataOwnerType.Hcp.dtoSerialName,
				dataOwnerGroupIds = JsonArray(listOf(JsonPrimitive(intermediateGroup.id))).toString(),
				groupId = testGroupId,
			).successBody()
			println("Created subgroup $i")
		}
		val testMemberApi = kotlin.run {
			val otherIntermediate = createHcpUser(parent = topGroup, groupLinkType = DataOwnerGroupLinkType.Simple)
			val otherMember = createHcpUser(parent = otherIntermediate, groupLinkType = DataOwnerGroupLinkType.NotAllowed)
			otherMember.api(specJob)
		}
		println("Done creating test users - ${Clock.System.now()}")
		val hcpApi = hcp.api(specJob)
		val patient = hcpApi.patient.createPatient(
			hcpApi.patient.withEncryptionMetadata(
				DecryptedPatient(
					uuid(),
					firstName = "John",
					lastName = "Doe",
					note = "Secret"
				),
				delegates = mapOf(topGroup.dataOwnerId to AccessLevel.Write)
			)
		)
		println("Done creating test patient - ${Clock.System.now()}")
		patient.note shouldBe "Secret"
		hcpApi.patient.getPatient(patient.id).shouldNotBeNull().note shouldBe "Secret"
		testMemberApi.patient.getPatient(patient.id).shouldNotBeNull().note shouldBe "Secret"
	}
})