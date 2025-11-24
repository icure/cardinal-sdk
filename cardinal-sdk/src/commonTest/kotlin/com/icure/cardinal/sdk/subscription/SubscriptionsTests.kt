package com.icure.cardinal.sdk.subscription

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.filters.ContactFilters
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.HealthElementFilters
import com.icure.cardinal.sdk.filters.MaintenanceTaskFilters
import com.icure.cardinal.sdk.filters.MessageFilters
import com.icure.cardinal.sdk.filters.PatientFilters
import com.icure.cardinal.sdk.filters.TopicFilters
import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.DecryptedContact
import com.icure.cardinal.sdk.model.DecryptedHealthElement
import com.icure.cardinal.sdk.model.DecryptedMaintenanceTask
import com.icure.cardinal.sdk.model.DecryptedMessage
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.DecryptedTopic
import com.icure.cardinal.sdk.model.EncryptedContact
import com.icure.cardinal.sdk.model.EncryptedHealthElement
import com.icure.cardinal.sdk.model.EncryptedMaintenanceTask
import com.icure.cardinal.sdk.model.EncryptedMessage
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.model.EncryptedTopic
import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.MaintenanceTask
import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.Topic
import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.test.DataOwnerDetails
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.kryptom.crypto.defaultCryptoService
import io.kotest.assertions.fail
import io.kotest.core.spec.style.StringSpec
import io.kotest.core.spec.style.stringSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.time.Duration.Companion.seconds

interface SubscribableTestContext<BaseType : Identifiable<String>, EntityEventType : BaseType> {
	val name: String
	val subscribableApi: Subscribable<BaseType, EntityEventType, FilterOptions<BaseType>>
	suspend fun createEntity(): Identifiable<String>
	val filter: FilterOptions<BaseType>
}

fun <BaseType : Identifiable<String>, MaybeDecryptedType : BaseType> subscribableTests(
	context: SubscribableTestContext<BaseType, MaybeDecryptedType>
) = with(context) {
	stringSpec {
		name should {
			"Should subscribe to $name updates".config(enabled = DEFAULT_ENABLED) {
				val subscription = subscribableApi
					.subscribeToEvents(
						events = setOf(SubscriptionEventType.Create),
						filter = filter
					)

				withTimeoutOrNull(5.seconds) {
					subscription.eventChannel.receive() shouldBe EntitySubscriptionEvent.Connected
				} ?: fail("Didn't received OPEN event within 5 seconds")

				val created = createEntity()

				withTimeoutOrNull(5.seconds) {
					subscription.eventChannel.receive()
						.shouldBeInstanceOf<EntitySubscriptionEvent.EntityNotification<*>>()
						.entity.id shouldBe created.id
				} ?: fail("Didn't received ENTITY event within 5 seconds")
			}
		}
	}
}

class SubscriptionsTests : StringSpec({
	lateinit var hcpUser: DataOwnerDetails
	lateinit var hcpUserApi: CardinalSdk
	val specJob = autoCancelJob()

	beforeSpec {
		initializeTestEnvironment()
		hcpUser = createHcpUser(
			roles = setOf(
				"PATIENT_USER_MANAGER",
				"BASIC_USER",
				"BASIC_DATA_OWNER",
				"HIERARCHICAL_DATA_OWNER",
				"TOPIC_MANAGER",
				"LEGACY_MESSAGE_MANAGER",
			)
		)
		hcpUserApi = hcpUser.api(specJob)
	}

	include(
		subscribableTests(
			object : SubscribableTestContext<HealthElement, EncryptedHealthElement> {
				override val name: String = "HealthElement"

				override val subscribableApi
					get() = hcpUserApi.healthElement

				override suspend fun createEntity(): Identifiable<String> {
					val patient = hcpUserApi
						.patient
						.withEncryptionMetadata(
							DecryptedPatient(id = defaultCryptoService.strongRandom.randomUUID())
						).let {
							hcpUserApi.patient.createPatient(it)
						}

					val currentUser = hcpUserApi.user.getCurrentUser()

					return hcpUserApi
						.healthElement
						.withEncryptionMetadata(
							DecryptedHealthElement(id = defaultCryptoService.strongRandom.randomUUID()),
							patient,
							currentUser
						).let {
							hcpUserApi
								.healthElement
								.createHealthElement(it)
						}
				}

				override val filter: FilterOptions<HealthElement>
					get() = HealthElementFilters.allHealthElementsForDataOwner(hcpUser.dataOwnerId)
			}
		),
	)
	include(
		subscribableTests(
			object : SubscribableTestContext<Patient, EncryptedPatient> {
				override val name: String = "Patient"
				override val subscribableApi
					get() = hcpUserApi.patient

				override suspend fun createEntity(): Identifiable<String> {
					return hcpUserApi
						.patient
						.withEncryptionMetadata(
							DecryptedPatient(id = defaultCryptoService.strongRandom.randomUUID())
						).let {
							hcpUserApi.patient.createPatient(it)
						}
				}

				override val filter: FilterOptions<Patient>
					get() = PatientFilters.allPatientsForDataOwner(hcpUser.dataOwnerId)
			}
		),
	)
	include(
		subscribableTests(
			object : SubscribableTestContext<Contact, EncryptedContact> {
				override val name = "Contact"
				override val subscribableApi
					get() = hcpUserApi.contact

				override suspend fun createEntity(): Identifiable<String> {
					val patient = hcpUserApi
						.patient
						.withEncryptionMetadata(
							DecryptedPatient(id = defaultCryptoService.strongRandom.randomUUID())
						).let {
							hcpUserApi.patient.createPatient(it)
						}

					val currentUser = hcpUserApi.user.getCurrentUser()

					return hcpUserApi
						.contact
						.withEncryptionMetadata(
                            DecryptedContact(id = defaultCryptoService.strongRandom.randomUUID()),
                            patient,
                            currentUser

						).let {
							hcpUserApi.contact.createContact(it)
						}
				}

				override val filter: FilterOptions<Contact>
					get() = ContactFilters.allContactsForDataOwner(hcpUser.dataOwnerId)
			}
		),
	)

	val identifier = Identifier(defaultCryptoService.strongRandom.randomUUID())

	include(
		subscribableTests(
			object : SubscribableTestContext<MaintenanceTask, EncryptedMaintenanceTask> {
				override val name = "MaintenanceTask"
				override val subscribableApi
					get() = hcpUserApi.maintenanceTask

				override suspend fun createEntity(): Identifiable<String> {
					val currentUser = hcpUserApi.user.getCurrentUser()

					return hcpUserApi
						.maintenanceTask
						.withEncryptionMetadata(
							DecryptedMaintenanceTask(id = defaultCryptoService.strongRandom.randomUUID(), identifier = listOf(identifier)),
							currentUser
						).let {
							hcpUserApi.maintenanceTask.createMaintenanceTask(it)
						}
				}

				override val filter: FilterOptions<MaintenanceTask>
					get() = MaintenanceTaskFilters.byIdentifiersForDataOwner(dataOwnerId = hcpUser.dataOwnerId, identifiers = listOf(identifier))
			}
		),
	)

	include(
		subscribableTests(
			object : SubscribableTestContext<Message, EncryptedMessage> {
				override val name: String = "Message"
				override val subscribableApi
					get() = hcpUserApi.message

				override suspend fun createEntity(): Identifiable<String> {
					val patient = hcpUserApi
						.patient
						.withEncryptionMetadata(
							DecryptedPatient(id = defaultCryptoService.strongRandom.randomUUID())
						).let {
							hcpUserApi.patient.createPatient(it)
						}

					val currentUser = hcpUserApi.user.getCurrentUser()

					return hcpUserApi
						.message
						.withEncryptionMetadata(
							DecryptedMessage(id = defaultCryptoService.strongRandom.randomUUID()),
							patient,
							currentUser
						).let {
							hcpUserApi.message.createMessage(it)
						}
				}

				override val filter: FilterOptions<Message>
					get() = MessageFilters.allMessagesForDataOwner(hcpUser.dataOwnerId)
			}
		),
	)

	include(
		subscribableTests(
			object : SubscribableTestContext<Topic, EncryptedTopic> {
				override val name: String = "Topic"

				override val subscribableApi
					get() = hcpUserApi.topic

				override suspend fun createEntity(): Identifiable<String> {
					val patient = hcpUserApi
						.patient
						.withEncryptionMetadata(
							DecryptedPatient(id = defaultCryptoService.strongRandom.randomUUID())
						).let {
							hcpUserApi.patient.createPatient(it)
						}

					val currentUser = hcpUserApi.user.getCurrentUser()

					return hcpUserApi
						.topic
						.withEncryptionMetadata(
							DecryptedTopic(id = defaultCryptoService.strongRandom.randomUUID()),
							patient,
							currentUser
						).let {
							hcpUserApi.topic.createTopic(it)
						}
				}

				override val filter: FilterOptions<Topic>
					get() = TopicFilters.allTopicsForDataOwner(hcpUser.dataOwnerId)
			}
		),
	)
}
)
