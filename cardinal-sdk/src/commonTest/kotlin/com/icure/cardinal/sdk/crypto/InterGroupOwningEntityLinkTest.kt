package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.api.raw.impl.RawGroupApiImpl
import com.icure.cardinal.sdk.model.DatabaseInitialisation
import com.icure.cardinal.sdk.model.DecryptedAccessLog
import com.icure.cardinal.sdk.model.DecryptedCalendarItem
import com.icure.cardinal.sdk.model.DecryptedContact
import com.icure.cardinal.sdk.model.DecryptedDocument
import com.icure.cardinal.sdk.model.DecryptedForm
import com.icure.cardinal.sdk.model.DecryptedHealthElement
import com.icure.cardinal.sdk.model.DecryptedInvoice
import com.icure.cardinal.sdk.model.DecryptedMessage
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.test.DefaultRawApiConfig
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.baseUrl
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.superadminAuth
import com.icure.cardinal.sdk.test.uuid
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.cardinal.sdk.utils.LOCAL_ENV_ONLY
import com.icure.utils.InternalIcureApi
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

/**
 * Verifies that entities created in a group and linked to an owning entity from a different group reference the
 * owning entity with its actual group, and use the secret ids of the owning entity.
 */
@OptIn(InternalIcureApi::class)
class InterGroupOwningEntityLinkTest : StringSpec({
	val parentGroupId = "parent-${uuid()}"
	val childGroupId = "child-${uuid()}"
	val specJob = autoCancelJob()
	lateinit var api: CardinalSdk
	lateinit var patient: GroupScoped<DecryptedPatient>
	lateinit var patientSecretIds: Set<String>

	beforeSpec {
		if (!LOCAL_ENV_ONLY) return@beforeSpec
		initializeTestEnvironment()
		val groupApi = RawGroupApiImpl(baseUrl, superadminAuth(), DefaultRawApiConfig)
		groupApi.createGroup(
			parentGroupId,
			name = "parent",
			password = uuid(),
			initialisationData = DatabaseInitialisation()
		).successBody()
		groupApi.createGroup(
			childGroupId,
			name = "child",
			password = uuid(),
			initialisationData = DatabaseInitialisation(),
			superGroup = parentGroupId
		).successBody()
		api = createHcpUser(inGroup = parentGroupId, inheritsPermissions = true).api(specJob)
		patient = api.patient.inGroup.createPatient(
			api.patient.inGroup.withEncryptionMetadata(
				entityGroupId = parentGroupId,
				base = DecryptedPatient(id = uuid(), firstName = "Gino", lastName = "Pino"),
			)
		)
		patientSecretIds = api.patient.inGroup.getSecretIdsOf(patient).keys
	}

	/**
	 * Owning entity of a test entity, with the secret ids that the test entity is expected to use.
	 */
	class Owner(val reference: EntityReferenceInGroup, val secretIds: Set<String>)

	/**
	 * @param createLinked creates in [childGroupId] an entity linked to an owning entity in [parentGroupId], returning
	 * also the details of the owning entity.
	 * @param getDecrypted retrieves and decrypts the created entity, to verify that the encryption metadata was
	 * initialised for the group of the entity.
	 * @param decryptOwningEntityIds decrypts the owning entity ids of the created entity.
	 */
	class LinkedEntityCase<T : HasEncryptionMetadata>(
		val name: String,
		val createLinked: suspend (api: CardinalSdk, patientOwner: Owner) -> Pair<GroupScoped<T>, Owner>,
		val getDecrypted: suspend (api: CardinalSdk, groupId: String, entityId: String) -> T?,
		val decryptOwningEntityIds: suspend (api: CardinalSdk, entity: GroupScoped<T>) -> Set<EntityReferenceInGroup>,
	)

	fun <T : HasEncryptionMetadata> LinkedEntityCase<T>.test() {
		"$name created in a different group than its owning entity should reference the owning entity in its group".config(
			enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY
		) {
			val (created, owner) = createLinked(api, Owner(EntityReferenceInGroup(patient.entity.id, parentGroupId), patientSecretIds))
			created.groupId shouldBe childGroupId
			owner.secretIds.shouldNotBeEmpty()
			created.entity.secretForeignKeys shouldBe owner.secretIds
			val retrieved = getDecrypted(api, childGroupId, created.entity.id).shouldNotBeNull()
			retrieved.secretForeignKeys shouldBe owner.secretIds
			decryptOwningEntityIds(api, GroupScoped(retrieved, childGroupId)) shouldBe setOf(owner.reference)
		}
	}

	listOf(
		LinkedEntityCase(
			"Access log",
			createLinked = { api, patientOwner ->
				api.accessLog.inGroup.createAccessLog(
					api.accessLog.inGroup.withEncryptionMetadata(childGroupId, DecryptedAccessLog(id = uuid()), patient)
				) to patientOwner
			},
			getDecrypted = { api, groupId, id -> api.accessLog.inGroup.getAccessLog(groupId, id)?.entity },
			decryptOwningEntityIds = { api, entity -> api.accessLog.inGroup.decryptPatientIdOf(entity) },
		),
		LinkedEntityCase(
			"Calendar item",
			createLinked = { api, patientOwner ->
				api.calendarItem.inGroup.createCalendarItem(
					api.calendarItem.inGroup.withEncryptionMetadata(childGroupId, DecryptedCalendarItem(id = uuid()), patient)
				) to patientOwner
			},
			getDecrypted = { api, groupId, id -> api.calendarItem.inGroup.getCalendarItem(groupId, id)?.entity },
			decryptOwningEntityIds = { api, entity -> api.calendarItem.inGroup.decryptPatientIdOf(entity) },
		),
		LinkedEntityCase(
			"Contact",
			createLinked = { api, patientOwner ->
				api.contact.inGroup.createContact(
					api.contact.inGroup.withEncryptionMetadata(childGroupId, DecryptedContact(id = uuid()), patient)
				) to patientOwner
			},
			getDecrypted = { api, groupId, id -> api.contact.inGroup.getContact(groupId, id)?.entity },
			decryptOwningEntityIds = { api, entity -> api.contact.inGroup.decryptPatientIdOf(entity) },
		),
		LinkedEntityCase(
			"Form",
			createLinked = { api, patientOwner ->
				api.form.inGroup.createForm(
					api.form.inGroup.withEncryptionMetadata(childGroupId, DecryptedForm(id = uuid()), patient)
				) to patientOwner
			},
			getDecrypted = { api, groupId, id -> api.form.inGroup.getForm(groupId, id)?.entity },
			decryptOwningEntityIds = { api, entity -> api.form.inGroup.decryptPatientIdOf(entity) },
		),
		LinkedEntityCase(
			"Health element",
			createLinked = { api, patientOwner ->
				api.healthElement.inGroup.createHealthElement(
					api.healthElement.inGroup.withEncryptionMetadata(childGroupId, DecryptedHealthElement(id = uuid()), patient)
				) to patientOwner
			},
			getDecrypted = { api, groupId, id -> api.healthElement.inGroup.getHealthElement(groupId, id)?.entity },
			decryptOwningEntityIds = { api, entity -> api.healthElement.inGroup.decryptPatientIdOf(entity) },
		),
		LinkedEntityCase(
			"Invoice",
			createLinked = { api, patientOwner ->
				api.invoice.inGroup.createInvoice(
					api.invoice.inGroup.withEncryptionMetadata(childGroupId, DecryptedInvoice(id = uuid()), patient)
				) to patientOwner
			},
			getDecrypted = { api, groupId, id -> api.invoice.inGroup.getInvoice(groupId, id)?.entity },
			decryptOwningEntityIds = { api, entity -> api.invoice.inGroup.decryptPatientIdOf(entity) },
		),
		LinkedEntityCase(
			"Message",
			createLinked = { api, patientOwner ->
				api.message.inGroup.createMessage(
					api.message.inGroup.withEncryptionMetadata(childGroupId, DecryptedMessage(id = uuid()), patient)
				) to patientOwner
			},
			getDecrypted = { api, groupId, id -> api.message.inGroup.getMessage(groupId, id)?.entity },
			decryptOwningEntityIds = { api, entity -> api.message.inGroup.decryptPatientIdOf(entity) },
		),
		LinkedEntityCase(
			"Document linked to patient",
			createLinked = { api, patientOwner ->
				api.document.inGroup.createDocument(
					api.document.inGroup.withEncryptionMetadataLinkedToPatient(childGroupId, DecryptedDocument(id = uuid()), patient)
				) to patientOwner
			},
			getDecrypted = { api, groupId, id -> api.document.inGroup.getDocument(groupId, id)?.entity },
			decryptOwningEntityIds = { api, entity -> api.document.inGroup.decryptOwningEntityIdsOf(entity) },
		),
		LinkedEntityCase(
			"Document linked to message",
			createLinked = { api, patientOwner ->
				// The parent group is the group of the user, so the message can be created with the non in-group api
				val message = api.message.createMessage(
					api.message.withEncryptionMetadata(DecryptedMessage(id = uuid()), patient.entity)
				)
				api.document.inGroup.createDocument(
					api.document.inGroup.withEncryptionMetadataLinkedToMessage(
						childGroupId,
						DecryptedDocument(id = uuid()),
						GroupScoped(message, parentGroupId),
					)
				) to Owner(EntityReferenceInGroup(message.id, parentGroupId), api.message.getSecretIdsOf(message).keys)
			},
			getDecrypted = { api, groupId, id -> api.document.inGroup.getDocument(groupId, id)?.entity },
			decryptOwningEntityIds = { api, entity -> api.document.inGroup.decryptOwningEntityIdsOf(entity) },
		),
	).forEach { it.test() }
})
