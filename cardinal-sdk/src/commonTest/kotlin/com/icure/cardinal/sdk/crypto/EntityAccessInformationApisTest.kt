package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.CardinalBaseSdk
import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.api.impl.keyAsLocalDataOwnerReferences
import com.icure.cardinal.sdk.auth.UsernamePassword
import com.icure.cardinal.sdk.crypto.entities.EntityAccessInformation
import com.icure.cardinal.sdk.model.AccessLog
import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.DecryptedAccessLog
import com.icure.cardinal.sdk.model.DecryptedCalendarItem
import com.icure.cardinal.sdk.model.DecryptedContact
import com.icure.cardinal.sdk.model.DecryptedDocument
import com.icure.cardinal.sdk.model.DecryptedForm
import com.icure.cardinal.sdk.model.DecryptedHealthElement
import com.icure.cardinal.sdk.model.DecryptedInvoice
import com.icure.cardinal.sdk.model.DecryptedMessage
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.DecryptedReceipt
import com.icure.cardinal.sdk.model.DecryptedTopic
import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.Form
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.Invoice
import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.Receipt
import com.icure.cardinal.sdk.model.Topic
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.DecryptedService
import com.icure.cardinal.sdk.options.AuthenticationMethod
import com.icure.cardinal.sdk.test.DataOwnerDetails
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.baseUrl
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.uuid
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.cardinal.sdk.utils.LOCAL_ENV_ONLY
import com.icure.utils.InternalIcureApi
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

@OptIn(InternalIcureApi::class)
class EntityAccessInformationApisTest : StringSpec({

	val specJob = autoCancelJob()

	lateinit var delegatorDetails: DataOwnerDetails
	lateinit var delegateDetails: DataOwnerDetails
	lateinit var delegatorApi: CardinalSdk
	lateinit var delegatorBaseApi: CardinalBaseSdk
	lateinit var patient: DecryptedPatient

	beforeSpec {
		initializeTestEnvironment()
		// Creating topics requires the TOPIC_MANAGER role, which can only be given to users created locally.
		delegatorDetails = createHcpUser(
			roles = if (LOCAL_ENV_ONLY) {
				setOf(
					"BASIC_USER",
					"BASIC_DATA_OWNER",
					"PATIENT_USER_MANAGER",
					"LEGACY_MESSAGE_MANAGER",
					"HIERARCHICAL_DATA_OWNER",
					"TOPIC_MANAGER",
				)
			} else {
				null
			}
		)
		delegateDetails = createHcpUser()
		delegatorApi = delegatorDetails.api(specJob)
		delegatorBaseApi = CardinalBaseSdk.initialize(
			null,
			baseUrl,
			AuthenticationMethod.UsingCredentials(UsernamePassword(delegatorDetails.username, delegatorDetails.password)),
		)
		patient = delegatorApi.patient.createPatient(
			delegatorApi.patient.withEncryptionMetadata(
				DecryptedPatient(id = uuid(), firstName = "Esmerelda", lastName = "Weatherwax")
			)
		)
	}

	/**
	 * Permissions by data owner id, checking that all references are local to the group of the test users.
	 */
	fun EntityAccessInformation.localPermissions(): Map<String, AccessLevel> =
		permissionsByDataOwnerId.entries.associate { (ref, level) ->
			ref.groupId shouldBeIn listOf(null, delegatorDetails.groupId)
			ref.entityId to level
		}

	fun expectedPermissions() = mapOf(
		delegatorDetails.dataOwnerId to AccessLevel.Write,
		delegateDetails.dataOwnerId to AccessLevel.Read,
	)

	fun <T : HasEncryptionMetadata> doTest(case: EntityCase<T>) {
		val enabled = DEFAULT_ENABLED && (!case.localOnly || LOCAL_ENV_ONLY)

		"Can get the data owners with access to a ${case.entityName}".config(enabled = enabled) {
			val created = case.create(delegatorApi, patient, mapOf(delegateDetails.dataOwnerId to AccessLevel.Read))
			case.getDataOwnersWithAccessTo(delegatorApi, created).apply {
				permissionsByDataOwnerId shouldBe expectedPermissions().keyAsLocalDataOwnerReferences()
				hasUnknownAnonymousDataOwners shouldBe false
			}
		}

		"Can get the data owners with access to an encrypted ${case.entityName}".config(enabled = enabled) {
			val created = case.create(delegatorApi, patient, mapOf(delegateDetails.dataOwnerId to AccessLevel.Read))
			val encrypted = case.getEncrypted(delegatorApi, created.id).shouldNotBeNull()
			case.getDataOwnersWithAccessTo(delegatorApi, encrypted).apply {
				permissionsByDataOwnerId shouldBe expectedPermissions().keyAsLocalDataOwnerReferences()
				hasUnknownAnonymousDataOwners shouldBe false
			}
		}

		"Can get the data owners with access to a ${case.entityName} in group".config(enabled = enabled) {
			val created = case.create(delegatorApi, patient, mapOf(delegateDetails.dataOwnerId to AccessLevel.Read))
			case.getDataOwnersWithAccessToInGroup(delegatorApi, GroupScoped(created, delegatorDetails.groupId)).apply {
				localPermissions() shouldBe expectedPermissions()
				hasUnknownAnonymousDataOwners shouldBe false
			}
		}

		"Can get the data owners with access to a ${case.entityName} from the base sdk".config(enabled = enabled) {
			val created = case.create(delegatorApi, patient, mapOf(delegateDetails.dataOwnerId to AccessLevel.Read))
			val encrypted = case.getEncrypted(delegatorApi, created.id).shouldNotBeNull()
			case.getDataOwnersWithAccessToFromBase(delegatorBaseApi, encrypted).apply {
				localPermissions() shouldBe expectedPermissions()
				hasUnknownAnonymousDataOwners shouldBe false
			}
		}
	}

	listOf(
		accessLogCase,
		calendarItemCase,
		contactCase,
		documentCase,
		formCase,
		healthElementCase,
		invoiceCase,
		messageCase,
		patientCase,
		receiptCase,
		topicCase,
	).forEach { doTest(it) }

	"A service has the same data owners with access as its contact" {
		val serviceId = uuid()
		val contact = delegatorApi.contact.createContact(
			delegatorApi.contact.withEncryptionMetadata(
				DecryptedContact(id = uuid(), services = setOf(DecryptedService(id = serviceId))),
				patient,
				delegates = mapOf(delegateDetails.dataOwnerId to AccessLevel.Read),
			)
		)
		val service = delegatorApi.contact.getService(serviceId).shouldNotBeNull()
		val contactAccess = delegatorApi.contact.getDataOwnersWithAccessTo(contact)
		contactAccess.permissionsByDataOwnerId shouldBe expectedPermissions().keyAsLocalDataOwnerReferences()
		delegatorApi.contact.getDataOwnersWithAccessToService(service) shouldBe contactAccess
		delegatorApi.contact.inGroup.getDataOwnersWithAccessToService(
			GroupScoped(service, delegatorDetails.groupId)
		).localPermissions() shouldBe expectedPermissions()
	}
})

private class EntityCase<T : HasEncryptionMetadata>(
	val entityName: String,
	val create: suspend (api: CardinalSdk, patient: DecryptedPatient, delegates: Map<String, AccessLevel>) -> T,
	val getEncrypted: suspend (api: CardinalSdk, id: String) -> T?,
	val getDataOwnersWithAccessTo: suspend (api: CardinalSdk, entity: T) -> EntityAccessInformation,
	val getDataOwnersWithAccessToInGroup: suspend (api: CardinalSdk, entity: GroupScoped<T>) -> EntityAccessInformation,
	val getDataOwnersWithAccessToFromBase: suspend (api: CardinalBaseSdk, entity: T) -> EntityAccessInformation,
	/**
	 * The entity can only be created by users with roles that can only be assigned in the local test environment.
	 */
	val localOnly: Boolean = false,
)

private val accessLogCase = EntityCase<AccessLog>(
	entityName = "AccessLog",
	create = { api, patient, delegates ->
		api.accessLog.createAccessLog(api.accessLog.withEncryptionMetadata(DecryptedAccessLog(id = uuid()), patient, delegates = delegates))
	},
	getEncrypted = { api, id -> api.accessLog.encrypted.getAccessLog(id) },
	getDataOwnersWithAccessTo = { api, entity -> api.accessLog.getDataOwnersWithAccessTo(entity) },
	getDataOwnersWithAccessToInGroup = { api, entity -> api.accessLog.inGroup.getDataOwnersWithAccessTo(entity) },
	getDataOwnersWithAccessToFromBase = { api, entity -> api.accessLog.getDataOwnersWithAccessTo(entity) },
)

private val calendarItemCase = EntityCase<CalendarItem>(
	entityName = "CalendarItem",
	create = { api, patient, delegates ->
		api.calendarItem.createCalendarItem(
			api.calendarItem.withEncryptionMetadata(DecryptedCalendarItem(id = uuid()), patient, delegates = delegates)
		)
	},
	getEncrypted = { api, id -> api.calendarItem.encrypted.getCalendarItem(id) },
	getDataOwnersWithAccessTo = { api, entity -> api.calendarItem.getDataOwnersWithAccessTo(entity) },
	getDataOwnersWithAccessToInGroup = { api, entity -> api.calendarItem.inGroup.getDataOwnersWithAccessTo(entity) },
	getDataOwnersWithAccessToFromBase = { api, entity -> api.calendarItem.getDataOwnersWithAccessTo(entity) },
)

private val contactCase = EntityCase<Contact>(
	entityName = "Contact",
	create = { api, patient, delegates ->
		api.contact.createContact(api.contact.withEncryptionMetadata(DecryptedContact(id = uuid()), patient, delegates = delegates))
	},
	getEncrypted = { api, id -> api.contact.encrypted.getContact(id) },
	getDataOwnersWithAccessTo = { api, entity -> api.contact.getDataOwnersWithAccessTo(entity) },
	getDataOwnersWithAccessToInGroup = { api, entity -> api.contact.inGroup.getDataOwnersWithAccessTo(entity) },
	getDataOwnersWithAccessToFromBase = { api, entity -> api.contact.getDataOwnersWithAccessTo(entity) },
)

private val documentCase = EntityCase<Document>(
	entityName = "Document",
	create = { api, patient, delegates ->
		api.document.createDocument(
			api.document.withEncryptionMetadataLinkedToPatient(DecryptedDocument(id = uuid()), patient, delegates = delegates)
		)
	},
	getEncrypted = { api, id -> api.document.encrypted.getDocument(id) },
	getDataOwnersWithAccessTo = { api, entity -> api.document.getDataOwnersWithAccessTo(entity) },
	getDataOwnersWithAccessToInGroup = { api, entity -> api.document.inGroup.getDataOwnersWithAccessTo(entity) },
	getDataOwnersWithAccessToFromBase = { api, entity -> api.document.getDataOwnersWithAccessTo(entity) },
)

private val formCase = EntityCase<Form>(
	entityName = "Form",
	create = { api, patient, delegates ->
		api.form.createForm(api.form.withEncryptionMetadata(DecryptedForm(id = uuid()), patient, delegates = delegates))
	},
	getEncrypted = { api, id -> api.form.encrypted.getForm(id) },
	getDataOwnersWithAccessTo = { api, entity -> api.form.getDataOwnersWithAccessTo(entity) },
	getDataOwnersWithAccessToInGroup = { api, entity -> api.form.inGroup.getDataOwnersWithAccessTo(entity) },
	getDataOwnersWithAccessToFromBase = { api, entity -> api.form.getDataOwnersWithAccessTo(entity) },
)

private val healthElementCase = EntityCase<HealthElement>(
	entityName = "HealthElement",
	create = { api, patient, delegates ->
		api.healthElement.createHealthElement(
			api.healthElement.withEncryptionMetadata(DecryptedHealthElement(id = uuid()), patient, delegates = delegates)
		)
	},
	getEncrypted = { api, id -> api.healthElement.encrypted.getHealthElement(id) },
	getDataOwnersWithAccessTo = { api, entity -> api.healthElement.getDataOwnersWithAccessTo(entity) },
	getDataOwnersWithAccessToInGroup = { api, entity -> api.healthElement.inGroup.getDataOwnersWithAccessTo(entity) },
	getDataOwnersWithAccessToFromBase = { api, entity -> api.healthElement.getDataOwnersWithAccessTo(entity) },
)

private val invoiceCase = EntityCase<Invoice>(
	entityName = "Invoice",
	create = { api, patient, delegates ->
		api.invoice.createInvoice(api.invoice.withEncryptionMetadata(DecryptedInvoice(id = uuid()), patient, delegates = delegates))
	},
	getEncrypted = { api, id -> api.invoice.encrypted.getInvoice(id) },
	getDataOwnersWithAccessTo = { api, entity -> api.invoice.getDataOwnersWithAccessTo(entity) },
	getDataOwnersWithAccessToInGroup = { api, entity -> api.invoice.inGroup.getDataOwnersWithAccessTo(entity) },
	getDataOwnersWithAccessToFromBase = { api, entity -> api.invoice.getDataOwnersWithAccessTo(entity) },
)

private val messageCase = EntityCase<Message>(
	entityName = "Message",
	create = { api, patient, delegates ->
		api.message.createMessage(api.message.withEncryptionMetadata(DecryptedMessage(id = uuid()), patient, delegates = delegates))
	},
	getEncrypted = { api, id -> api.message.encrypted.getMessage(id) },
	getDataOwnersWithAccessTo = { api, entity -> api.message.getDataOwnersWithAccessTo(entity) },
	getDataOwnersWithAccessToInGroup = { api, entity -> api.message.inGroup.getDataOwnersWithAccessTo(entity) },
	getDataOwnersWithAccessToFromBase = { api, entity -> api.message.getDataOwnersWithAccessTo(entity) },
)

private val patientCase = EntityCase<Patient>(
	entityName = "Patient",
	create = { api, _, delegates ->
		api.patient.createPatient(
			api.patient.withEncryptionMetadata(
				DecryptedPatient(id = uuid(), firstName = "John", lastName = "Doe"),
				delegates = delegates
			)
		)
	},
	getEncrypted = { api, id -> api.patient.encrypted.getPatient(id) },
	getDataOwnersWithAccessTo = { api, entity -> api.patient.getDataOwnersWithAccessTo(entity) },
	getDataOwnersWithAccessToInGroup = { api, entity -> api.patient.inGroup.getDataOwnersWithAccessTo(entity) },
	getDataOwnersWithAccessToFromBase = { api, entity -> api.patient.getDataOwnersWithAccessTo(entity) },
)

private val receiptCase = EntityCase<Receipt>(
	entityName = "Receipt",
	create = { api, patient, delegates ->
		api.receipt.createReceipt(api.receipt.withEncryptionMetadata(DecryptedReceipt(id = uuid()), patient, delegates = delegates))
	},
	getEncrypted = { api, id -> api.receipt.encrypted.getReceipt(id) },
	getDataOwnersWithAccessTo = { api, entity -> api.receipt.getDataOwnersWithAccessTo(entity) },
	getDataOwnersWithAccessToInGroup = { api, entity -> api.receipt.inGroup.getDataOwnersWithAccessTo(entity) },
	getDataOwnersWithAccessToFromBase = { api, entity -> api.receipt.getDataOwnersWithAccessTo(entity) },
)

private val topicCase = EntityCase<Topic>(
	entityName = "Topic",
	create = { api, patient, delegates ->
		api.topic.createTopic(api.topic.withEncryptionMetadata(DecryptedTopic(id = uuid()), patient, delegates = delegates))
	},
	getEncrypted = { api, id -> api.topic.encrypted.getTopic(id) },
	getDataOwnersWithAccessTo = { api, entity -> api.topic.getDataOwnersWithAccessTo(entity) },
	getDataOwnersWithAccessToInGroup = { api, entity -> api.topic.inGroup.getDataOwnersWithAccessTo(entity) },
	getDataOwnersWithAccessToFromBase = { api, entity -> api.topic.getDataOwnersWithAccessTo(entity) },
	localOnly = true,
)
