package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.crypto.entities.AccessLogDelegateOptions
import com.icure.cardinal.sdk.crypto.entities.CalendarItemDelegateOptions
import com.icure.cardinal.sdk.crypto.entities.ContactDelegateOptions
import com.icure.cardinal.sdk.crypto.entities.DelegateOptions
import com.icure.cardinal.sdk.crypto.entities.DocumentDelegateOptions
import com.icure.cardinal.sdk.crypto.entities.FormDelegateOptions
import com.icure.cardinal.sdk.crypto.entities.HealthElementDelegateOptions
import com.icure.cardinal.sdk.crypto.entities.InvoiceDelegateOptions
import com.icure.cardinal.sdk.crypto.entities.MessageDelegateOptions
import com.icure.cardinal.sdk.crypto.entities.PatientDelegateOptions
import com.icure.cardinal.sdk.crypto.entities.ReceiptDelegateOptions
import com.icure.cardinal.sdk.crypto.entities.TopicDelegateOptions
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
import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.Invoice
import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.Receipt
import com.icure.cardinal.sdk.model.Topic
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.uuid
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.utils.InternalIcureApi
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

@OptIn(InternalIcureApi::class)
class CreateWithDelegateOptionsTest : StringSpec({

	val specJob = autoCancelJob()

	lateinit var delegatorHcpApi: CardinalSdk
	lateinit var delegateHcpApi: CardinalSdk
	lateinit var patient: DecryptedPatient

	beforeSpec {
		initializeTestEnvironment()
		delegatorHcpApi = createHcpUser().api(specJob)
		delegateHcpApi = createHcpUser().api(specJob)
		patient = delegatorHcpApi.patient.createPatient(
			delegatorHcpApi.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = defaultCryptoService.strongRandom.randomUUID(),
					firstName = "Esmerelda",
					lastName = "Weatherwax"
				)
			)
		)
	}

	fun <T : HasEncryptionMetadata> doTest(ctx: TestCtx<T>) {

		"Can share a ${ctx.entityName} with fine grained delegate access" {
			val delegateId = delegateHcpApi.dataOwner.getCurrentDataOwnerId()
			val entity = ctx.initEntity()
			val entityWithEncryptionMetadata = ctx.withEncryptionMetadata(
				api = delegatorHcpApi,
				patient = patient,
				entity = entity,
				delegates = mapOf(
					delegateId to object : DelegateOptions {
						override val accessLevel: AccessLevel
							get() = AccessLevel.Read
						override val shareEncryptionKey: Boolean
							get() = false
						override val shareSecretId: Boolean
							get() = false
						override val shareOwningEntityId: Boolean
							get() = false
					}
				)
			)

			val nonSelfDelegation = entityWithEncryptionMetadata.securityMetadata?.secureDelegations?.values?.firstOrNull {
				it.delegate == delegateId
			}.shouldNotBeNull()

			nonSelfDelegation.permissions shouldBe AccessLevel.Read
			nonSelfDelegation.secretIds.shouldBeEmpty()
			nonSelfDelegation.encryptionKeys.shouldBeEmpty()
			nonSelfDelegation.owningEntityIds.shouldBeEmpty()
		}
	}

	listOf(
		initCtx<AccessLog>(),
		initCtx<CalendarItem>(),
		initCtx<Contact>(),
		initCtx<Document>(),
		initCtx<Form>(),
		initCtx<HealthElement>(),
		initCtx<Invoice>(),
		initCtx<Message>(),
		initCtx<Patient>(),
		initCtx<Receipt>(),
		initCtx<Topic>(),
	).forEach { ctx ->
		doTest(ctx)
	}
})

@OptIn(InternalIcureApi::class)
private inline fun <reified T : HasEncryptionMetadata> initCtx() = object : TestCtx<T> {
	override val entityName: String = T::class.simpleName!!

	override fun initEntity(): T = when(T::class.simpleName) {
		"AccessLog" -> DecryptedAccessLog(id = uuid())
		"CalendarItem" -> DecryptedCalendarItem(id = uuid())
		"Contact" -> DecryptedContact(id = uuid())
		"Document" -> DecryptedDocument(id = uuid())
		"Form" -> DecryptedForm(id = uuid())
		"HealthElement" -> DecryptedHealthElement(id = uuid())
		"Invoice" -> DecryptedInvoice(id = uuid())
		"Message" -> DecryptedMessage(id = uuid())
		"Patient" -> DecryptedPatient(id = uuid(), firstName = "John", lastName = "Doe")
		"Receipt" -> DecryptedReceipt(id = uuid())
		"Topic" -> DecryptedTopic(id = uuid())
		else -> throw IllegalArgumentException("Invalid class ${T::class.simpleName}")
	} as T

	override suspend fun withEncryptionMetadata(
		api: CardinalSdk,
		patient: DecryptedPatient,
		entity: T,
		delegates: Map<String, DelegateOptions>
	): T  = when(T::class.simpleName) {
		"AccessLog" -> api.accessLog.withEncryptionMetadataAndDelegates(
			base = entity as DecryptedAccessLog,
			patient = patient,
			delegates = delegates.mapValues {
				AccessLogDelegateOptions(
					accessLevel = it.value.accessLevel,
					shareEncryptionKey = it.value.shareEncryptionKey,
					shareSecretId = it.value.shareSecretId,
					sharePatientId = it.value.shareOwningEntityId
				)
			}
		)
		"CalendarItem" -> api.calendarItem.withEncryptionMetadataAndDelegates(
			base = entity as DecryptedCalendarItem,
			patient = patient,
			delegates = delegates.mapValues {
				CalendarItemDelegateOptions(
					accessLevel = it.value.accessLevel,
					shareEncryptionKey = it.value.shareEncryptionKey,
					shareSecretId = it.value.shareSecretId,
					sharePatientId = it.value.shareOwningEntityId
				)
			}
		)
		"Contact" -> api.contact.withEncryptionMetadataAndDelegates(
			base = entity as DecryptedContact,
			patient = patient,
			delegates = delegates.mapValues {
				ContactDelegateOptions(
					accessLevel = it.value.accessLevel,
					shareEncryptionKey = it.value.shareEncryptionKey,
					shareSecretId = it.value.shareSecretId,
					sharePatientId = it.value.shareOwningEntityId
				)
			}
		)
		"Document" -> api.document.withEncryptionMetadataAndDelegatesLinkedToPatient(
			base = entity as DecryptedDocument,
			patient = patient,
			delegates = delegates.mapValues {
				DocumentDelegateOptions(
					accessLevel = it.value.accessLevel,
					shareEncryptionKey = it.value.shareEncryptionKey,
					shareSecretId = it.value.shareSecretId,
					shareMessageId = it.value.shareOwningEntityId
				)
			}
		)
		"Form" -> api.form.withEncryptionMetadataAndDelegates(
			base = entity as DecryptedForm,
			patient = patient,
			delegates = delegates.mapValues {
				FormDelegateOptions(
					accessLevel = it.value.accessLevel,
					shareEncryptionKey = it.value.shareEncryptionKey,
					shareSecretId = it.value.shareSecretId,
					sharePatientId = it.value.shareOwningEntityId
				)
			}
		)
		"HealthElement" -> api.healthElement.withEncryptionMetadataAndDelegates(
			base = entity as DecryptedHealthElement,
			patient = patient,
			delegates = delegates.mapValues {
				HealthElementDelegateOptions(
					accessLevel = it.value.accessLevel,
					shareEncryptionKey = it.value.shareEncryptionKey,
					shareSecretId = it.value.shareSecretId,
					sharePatientId = it.value.shareOwningEntityId
				)
			}
		)
		"Invoice" -> api.invoice.withEncryptionMetadataAndDelegates(
			base = entity as DecryptedInvoice,
			patient = patient,
			delegates = delegates.mapValues {
				InvoiceDelegateOptions(
					accessLevel = it.value.accessLevel,
					shareEncryptionKey = it.value.shareEncryptionKey,
					shareSecretId = it.value.shareSecretId,
					sharePatientId = it.value.shareOwningEntityId
				)
			}
		)
		"Message" -> api.message.withEncryptionMetadataAndDelegates(
			base = entity as DecryptedMessage,
			patient = patient,
			delegates = delegates.mapValues {
				MessageDelegateOptions(
					accessLevel = it.value.accessLevel,
					shareEncryptionKey = it.value.shareEncryptionKey,
					shareSecretId = it.value.shareSecretId,
					sharePatientId = it.value.shareOwningEntityId
				)
			}
		)
		"Patient" -> api.patient.withEncryptionMetadataAndDelegates(
			base = entity as DecryptedPatient,
			delegates = delegates.mapValues {
				PatientDelegateOptions(
					accessLevel = it.value.accessLevel,
					shareEncryptionKey = it.value.shareEncryptionKey,
					shareSecretId = it.value.shareSecretId,
				)
			}
		)
		"Receipt" -> api.receipt.withEncryptionMetadataAndDelegates(
			base = entity as DecryptedReceipt,
			patient = patient,
			delegates = delegates.mapValues {
				ReceiptDelegateOptions(
					accessLevel = it.value.accessLevel,
					shareEncryptionKey = it.value.shareEncryptionKey,
					shareSecretId = it.value.shareSecretId,
				)
			}
		)
		"Topic" -> api.topic.withEncryptionMetadataAndDelegates(
			base = entity as DecryptedTopic,
			patient = patient,
			delegates = delegates.mapValues {
				TopicDelegateOptions(
					accessLevel = it.value.accessLevel,
					shareEncryptionKey = it.value.shareEncryptionKey,
					shareSecretId = it.value.shareSecretId,
					sharePatientId = it.value.shareOwningEntityId
				)
			}
		)
		else -> throw IllegalArgumentException("Invalid class ${T::class.simpleName}")
	} as T
}

private interface TestCtx<T : HasEncryptionMetadata> {
	val entityName: String

	fun initEntity(): T
	@OptIn(InternalIcureApi::class)
	suspend fun withEncryptionMetadata(
		api: CardinalSdk,
		patient: DecryptedPatient,
		entity: T,
		delegates: Map<String, DelegateOptions>): T
}
