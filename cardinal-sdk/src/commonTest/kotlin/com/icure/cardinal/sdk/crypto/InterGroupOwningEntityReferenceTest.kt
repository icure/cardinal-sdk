package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.api.raw.impl.RawGroupApiImpl
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.DatabaseInitialisation
import com.icure.cardinal.sdk.model.DecryptedContact
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.test.DataOwnerDetails
import com.icure.cardinal.sdk.test.DefaultRawApiConfig
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.baseUrl
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.internal
import com.icure.cardinal.sdk.test.superadminAuth
import com.icure.cardinal.sdk.test.uuid
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.cardinal.sdk.utils.LOCAL_ENV_ONLY
import com.icure.utils.InternalIcureApi
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

/**
 * Verifies how the reference to the owning patient of a contact is stored and how it is decrypted by users of
 * different groups, depending on the groups of the patient, of the contact, and of the user.
 *
 * - userA is in group1, the group of the patient
 * - userB is in group2, a parent of group1 (so that userB can create entities in group1). userA can't access entities
 * of group2.
 *
 * The stored owning entity reference is relative to the group of the entity, while the references returned by the
 * apis are relative to the group of the user (null group if the referenced entity is in the group of the user), except
 * for in-group apis that always return the group explicitly.
 */
@OptIn(InternalIcureApi::class)
class InterGroupOwningEntityReferenceTest : StringSpec({
	val group2 = "group2-${uuid()}"
	val group1 = "group1-${uuid()}"
	val specJob = autoCancelJob()
	lateinit var userA: DataOwnerDetails
	lateinit var userB: DataOwnerDetails
	lateinit var apiA: CardinalSdk
	lateinit var apiB: CardinalSdk
	lateinit var patientA: DecryptedPatient

	beforeSpec {
		if (!LOCAL_ENV_ONLY) return@beforeSpec
		initializeTestEnvironment()
		val groupApi = RawGroupApiImpl(baseUrl, superadminAuth(), DefaultRawApiConfig)
		groupApi.createGroup(
			group2,
			name = "group2",
			password = uuid(),
			initialisationData = DatabaseInitialisation()
		).successBody()
		groupApi.createGroup(
			group1,
			name = "group1",
			password = uuid(),
			initialisationData = DatabaseInitialisation(),
			superGroup = group2
		).successBody()
		userA = createHcpUser(inGroup = group1)
		userB = createHcpUser(inGroup = group2, inheritsPermissions = true)
		apiA = userA.api(specJob)
		apiB = userB.api(specJob)
		patientA = apiA.patient.inGroup.createPatient(
			apiA.patient.inGroup.withEncryptionMetadata(
				entityGroupId = group1,
				base = DecryptedPatient(id = uuid(), firstName = "Gino", lastName = "Pino"),
				delegates = mapOf(userB.fullReference to AccessLevel.Write),
			)
		).entity
	}

	/**
	 * The owning entity ids as stored (decrypted) in the entity, before being parsed to references.
	 */
	suspend fun CardinalSdk.rawOwningEntityIdsOf(groupId: String, contact: Contact): Set<String> =
		crypto.internal.entity.owningEntityIdsOf(
			groupId,
			contact,
			EntityWithEncryptionMetadataTypeName.Builtin.Contact,
			null
		)

	suspend fun createContactOfPatientA(inGroup: String): GroupScoped<DecryptedContact> {
		val patientForB = apiB.patient.inGroup.getPatient(group1, patientA.id).shouldNotBeNull()
		return apiB.contact.inGroup.createContact(
			apiB.contact.inGroup.withEncryptionMetadata(
				entityGroupId = inGroup,
				base = DecryptedContact(id = uuid(), descr = "contact in $inGroup"),
				patient = patientForB,
				delegates = mapOf(userA.fullReference to AccessLevel.Read),
			)
		)
	}

	"Contact created by a user of another group in the same group as the patient".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val contact = createContactOfPatientA(inGroup = group1)
		contact.groupId shouldBe group1
		// The contact is in the same group as the patient
		apiB.rawOwningEntityIdsOf(group1, contact.entity) shouldBe setOf(patientA.id)
		// For userB the patient is in a different group
		apiB.contact.inGroup.decryptPatientIdOf(contact) shouldBe setOf(EntityReferenceInGroup(patientA.id, group1))
		// For userA the patient is in the same group (in-group apis always fill the group)
		val contactForA = apiA.contact.getContact(contact.entity.id).shouldNotBeNull()
		apiA.contact.decryptPatientIdOf(contactForA) shouldBe setOf(EntityReferenceInGroup(patientA.id, null))
		apiA.contact.inGroup.decryptPatientIdOf(GroupScoped(contactForA, group1)) shouldBe setOf(EntityReferenceInGroup(patientA.id, group1))
	}

	"Contact created by a user of another group in the group of the user".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val contact = createContactOfPatientA(inGroup = group2)
		contact.groupId shouldBe group2
		// The contact is in a different group than the patient
		apiB.rawOwningEntityIdsOf(group2, contact.entity) shouldBe setOf("$group1/${patientA.id}")
		// For userB the patient is in a different group
		apiB.contact.inGroup.decryptPatientIdOf(contact) shouldBe setOf(EntityReferenceInGroup(patientA.id, group1))
		val contactForB = apiB.contact.getContact(contact.entity.id).shouldNotBeNull()
		apiB.contact.decryptPatientIdOf(contactForB) shouldBe setOf(EntityReferenceInGroup(patientA.id, group1))
		// userA can't decrypt the patient id: it would need the exchange data in group2, where userA has no permissions.
		// The parsing of the stored reference by an sdk of group1 is covered by EntityReferenceInGroupTest.
	}
})
