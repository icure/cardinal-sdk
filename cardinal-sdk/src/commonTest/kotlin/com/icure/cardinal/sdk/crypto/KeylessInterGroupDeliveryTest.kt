package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.api.raw.impl.RawGroupApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawHealthcarePartyApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawUserApiImpl
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataInjectionDetails
import com.icure.cardinal.sdk.crypto.entities.RawDecryptedExchangeData
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.DatabaseInitialisation
import com.icure.cardinal.sdk.model.DecryptedDocument
import com.icure.cardinal.sdk.model.DecryptedMessage
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.base.DataOwnerGroupLinkType
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.test.DataOwnerDetails
import com.icure.cardinal.sdk.test.DefaultRawApiConfig
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.baseUrl
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.superadminAuth
import com.icure.cardinal.sdk.test.uuid
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.cardinal.sdk.utils.LOCAL_ENV_ONLY
import com.icure.cardinal.sdk.utils.RequestStatusException
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

/**
 * A keyless data owner of a parent group (a lab) delivers encrypted Messages and Documents into a child group (a
 * practice), shared with a data owner of that child group (the recipient) through inter-group delegations.
 *
 * The delegator never holds a key pair: the exchange data to the recipient is created in keyless mode, and only the
 * in-memory exchange keys let the delegator use it, until they are injected in a new instance.
 */
@OptIn(InternalIcureApi::class)
class KeylessInterGroupDeliveryTest : StringSpec({
	val specJob = autoCancelJob()
	val platformGroupId = "platform-${uuid()}"
	val practiceGroupId = "practice-${uuid()}"

	lateinit var lab: DataOwnerDetails
	lateinit var recipient: DataOwnerDetails
	lateinit var otherHcp: DataOwnerDetails
	lateinit var recipientApi: CardinalSdk
	lateinit var otherHcpApi: CardinalSdk

	val keylessStrategies = object : CryptoStrategies {
		override suspend fun generateNewKeyForDataOwner(
			self: DataOwnerWithType,
			cryptoPrimitives: CryptoService,
		): CryptoStrategies.KeyGenerationRequestResult = CryptoStrategies.KeyGenerationRequestResult.Keyless
	}

	/**
	 * A healthcare party without any public key, whose user inherits its permissions in the subgroups of its group.
	 */
	suspend fun createKeylessHcpUser(inGroup: String): DataOwnerDetails {
		val hcpRawApi = RawHealthcarePartyApiImpl(baseUrl, superadminAuth(), DefaultRawApiConfig)
		val userRawApi = RawUserApiImpl(baseUrl, superadminAuth(), DefaultRawApiConfig)
		val hcpId = uuid()
		val login = "lab-${uuid()}"
		val password = uuid()
		hcpRawApi.createHealthcarePartyInGroup(
			inGroup,
			HealthcareParty(hcpId, firstName = "Lab", lastName = "Lab-$hcpId")
		).successBody()
		val user = userRawApi.createUserInGroup(
			groupId = inGroup,
			User(
				uuid(),
				login = login,
				email = DataOwnerDetails.testEmailForLogin(login),
				passwordHash = password,
				healthcarePartyId = hcpId,
			)
		).successBody()
		userRawApi.setUserInheritsPermissions(userId = user.id, groupId = inGroup, value = true)
		return DataOwnerDetails(
			dataOwnerId = hcpId,
			username = login,
			password = password,
			keypair = null,
			parents = emptyList(),
			groupId = inGroup,
			effectiveGroupLinkType = DataOwnerGroupLinkType.Parent,
		)
	}

	suspend fun labApi(): CardinalSdk = lab.api(specJob, keylessStrategies)

	// References are relative to the group of the SDK (the lab's): the recipient needs an explicit group
	fun recipientReference() = EntityReferenceInGroup(recipient.dataOwnerId, practiceGroupId)

	suspend fun CardinalSdk.createExchangeDataToRecipient(): RawDecryptedExchangeData =
		crypto.inGroup.keylessCreateExchangeDataTo(
			groupId = practiceGroupId,
			delegate = recipientReference(),
		)

	suspend fun CardinalSdk.deliverMessage(
		transportGuid: String,
		subject: String,
		id: String = uuid(),
	): GroupScoped<DecryptedMessage> =
		message.inGroup.createMessage(
			message.inGroup.withEncryptionMetadata(
				entityGroupId = practiceGroupId,
				base = DecryptedMessage(
					id = id,
					transportGuid = transportGuid,
					subject = subject,
					fromHealthcarePartyId = lab.dataOwnerId,
					recipients = setOf(recipient.dataOwnerId),
				),
				patient = null,
				delegates = mapOf(recipientReference() to AccessLevel.Write),
				secretId = SecretIdUseOption.UseNone,
				alternateRootDelegateReference = recipientReference(),
			)
		)

	suspend fun CardinalSdk.deliverDocument(message: GroupScoped<Message>, name: String): GroupScoped<DecryptedDocument> =
		document.inGroup.createDocument(
			document.inGroup.withEncryptionMetadataLinkedToMessage(
				entityGroupId = practiceGroupId,
				base = DecryptedDocument(id = uuid(), name = name),
				message = message,
				delegates = mapOf(recipientReference() to AccessLevel.Write),
				secretId = SecretIdUseOption.UseNone,
				alternateRootDelegateReference = recipientReference(),
			)
		)

	beforeSpec {
		initializeTestEnvironment()
		val groupApi = RawGroupApiImpl(baseUrl, superadminAuth(), DefaultRawApiConfig)
		groupApi.createGroup(
			platformGroupId,
			name = "platform",
			password = uuid(),
			initialisationData = DatabaseInitialisation()
		).successBody()
		groupApi.createGroup(
			practiceGroupId,
			name = "practice",
			password = uuid(),
			initialisationData = DatabaseInitialisation(),
			superGroup = platformGroupId
		).successBody()
		lab = createKeylessHcpUser(platformGroupId)
		recipient = createHcpUser(inGroup = practiceGroupId)
		otherHcp = createHcpUser(inGroup = practiceGroupId)
		recipientApi = recipient.api(specJob)
		otherHcpApi = otherHcp.api(specJob)
	}

	"A keyless lab can deliver a Message and a linked Document in a practice that only the recipient can decrypt".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val labApi = labApi()
		labApi.createExchangeDataToRecipient()
		val message = labApi.deliverMessage(transportGuid = "lab|sub|${uuid()}", subject = "Results for order 42")
		val created = labApi.deliverDocument(message, name = "report.pdf")
		val report = "%PDF-1.4 lab report for order 42".encodeToByteArray()
		val document = labApi.document.inGroup.encryptAndSetMainAttachment(created, listOf("com.adobe.pdf"), report)

		// The delegator can read back what it created while it holds the exchange keys in memory
		labApi.message.inGroup.getMessage(practiceGroupId, message.entity.id).shouldNotBeNull().entity.subject shouldBe "Results for order 42"
		labApi.document.inGroup.getDocument(practiceGroupId, document.entity.id).shouldNotBeNull().entity.name shouldBe "report.pdf"

		// The delegate decrypts both from its own group
		val messageForRecipient = recipientApi.message.getMessage(message.entity.id).shouldNotBeNull()
		messageForRecipient.subject shouldBe "Results for order 42"
		messageForRecipient.transportGuid shouldBe message.entity.transportGuid
		val documentForRecipient = recipientApi.document.getDocument(document.entity.id).shouldNotBeNull()
		documentForRecipient.name shouldBe "report.pdf"
		recipientApi.document.decryptOwningEntityIdsOf(documentForRecipient).map { it.entityId } shouldBe listOf(message.entity.id)
		recipientApi.document.getAndDecryptMainAttachment(documentForRecipient).decodeToString() shouldBe report.decodeToString()

		// Another hcp of the same practice can neither get nor decrypt them
		shouldThrow<RequestStatusException> { otherHcpApi.message.getMessage(message.entity.id) }.statusCode shouldBe 403
		shouldThrow<RequestStatusException> { otherHcpApi.document.getDocument(document.entity.id) }.statusCode shouldBe 403
	}

	"A keyless lab can create and attach the Documents of a Message before the Message itself".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val labApi = labApi()
		labApi.createExchangeDataToRecipient()
		val messageId = uuid()
		// The Message is not persisted yet: the Documents are linked to a placeholder without encryption metadata
		val placeholder = GroupScoped<Message>(DecryptedMessage(id = messageId), practiceGroupId)
		val reports = listOf("report.pdf", "annex.pdf").associateWith { "%PDF-1.4 $it for order 43".encodeToByteArray() }
		val documents = reports.map { (name, content) ->
			val created = labApi.deliverDocument(placeholder, name = name)
			labApi.document.inGroup.encryptAndSetMainAttachment(created, listOf("com.adobe.pdf"), content)
		}
		val message = labApi.deliverMessage(transportGuid = "lab|sub|${uuid()}", subject = "Results for order 43", id = messageId)
		message.entity.id shouldBe messageId

		recipientApi.message.getMessage(messageId).shouldNotBeNull().subject shouldBe "Results for order 43"
		documents.forEach { document ->
			val documentForRecipient = recipientApi.document.getDocument(document.entity.id).shouldNotBeNull()
			val name = documentForRecipient.name.shouldNotBeNull()
			recipientApi.document.decryptOwningEntityIdsOf(documentForRecipient).map { it.entityId } shouldBe listOf(messageId)
			recipientApi.document.getAndDecryptMainAttachment(documentForRecipient).decodeToString() shouldBe reports.getValue(name).decodeToString()
			shouldThrow<RequestStatusException> { otherHcpApi.document.getDocument(document.entity.id) }.statusCode shouldBe 403
		}
		shouldThrow<RequestStatusException> { otherHcpApi.message.getMessage(messageId) }.statusCode shouldBe 403
	}

	"A keyless lab detects a duplicate delivery through its deterministic id, even from a new instance".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val firstInstance = labApi()
		firstInstance.createExchangeDataToRecipient()
		val transportGuid = "lab|sub|${uuid()}"
		// labs-ring derives the id from the transport guid: the same lab report always gets the same id
		val id = uuid()
		firstInstance.deliverMessage(transportGuid = transportGuid, subject = "Dedup me", id = id)

		// After a restart, with new exchange data and no memory of the first delivery
		val secondInstance = labApi()
		secondInstance.createExchangeDataToRecipient()
		shouldThrow<RequestStatusException> {
			secondInstance.deliverMessage(transportGuid = transportGuid, subject = "Dedup me", id = id)
		}.statusCode shouldBe 409
		recipientApi.message.getMessage(id).shouldNotBeNull().subject shouldBe "Dedup me"
	}

	"A new keyless lab instance reuses injected exchange data and the recipient still decrypts".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val firstInstance = labApi()
		val exchangeData = firstInstance.createExchangeDataToRecipient()
		val first = firstInstance.deliverMessage(transportGuid = "lab|sub|${uuid()}", subject = "Before restart")

		val secondInstance = labApi()
		secondInstance.crypto.injectExchangeData(
			practiceGroupId,
			listOf(
				ExchangeDataInjectionDetails(
					exchangeDataId = exchangeData.exchangeDataId,
					exchangeKey = exchangeData.exchangeKey,
					accessControlSecret = exchangeData.accessControlSecret,
					sharedSignatureKey = exchangeData.sharedSignatureKey,
					verified = true,
				)
			),
			false,
		)
		secondInstance.message.inGroup.getMessage(practiceGroupId, first.entity.id).shouldNotBeNull().entity.subject shouldBe "Before restart"
		val second = secondInstance.deliverMessage(transportGuid = "lab|sub|${uuid()}", subject = "After restart")

		recipientApi.message.getMessage(first.entity.id).shouldNotBeNull().subject shouldBe "Before restart"
		recipientApi.message.getMessage(second.entity.id).shouldNotBeNull().subject shouldBe "After restart"
	}

	"After a restart, a keyless lab cannot attach a file to a document left by an earlier attempt".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val firstInstance = labApi()
		firstInstance.createExchangeDataToRecipient()
		val message = firstInstance.deliverMessage(transportGuid = "lab|sub|${uuid()}", subject = "Interrupted")
		val leftover = firstInstance.deliverDocument(message, name = "report.pdf")

		// The exchange keys of the first instance are lost: the new instance has its own exchange data only
		val secondInstance = labApi()
		secondInstance.createExchangeDataToRecipient()
		shouldThrow<EntityEncryptionException> {
			secondInstance.document.inGroup.encryptAndSetMainAttachment(leftover, listOf("com.adobe.pdf"), "late".encodeToByteArray())
		}
	}

	"A keyless lab without exchange data cannot deliver".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		shouldThrow<IllegalStateException> {
			labApi().deliverMessage(transportGuid = "lab|sub|${uuid()}", subject = "No exchange data")
		}
	}

	"A keyless lab cannot create exchange data to itself, with or without the group of its own reference".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val api = labApi()
		shouldThrow<IllegalArgumentException> { api.crypto.keylessCreateExchangeDataTo(lab.dataOwnerId) }
		shouldThrow<IllegalArgumentException> {
			api.crypto.inGroup.keylessCreateExchangeDataTo(groupId = platformGroupId, delegate = EntityReferenceInGroup(lab.dataOwnerId, null))
		}
		shouldThrow<IllegalArgumentException> {
			api.crypto.inGroup.keylessCreateExchangeDataTo(groupId = platformGroupId, delegate = EntityReferenceInGroup(lab.dataOwnerId, platformGroupId))
		}
	}
})
