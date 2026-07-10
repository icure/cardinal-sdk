package com.icure.cardinal.sdk.crypto.encryptor.impl

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EncryptorOptions
import com.icure.cardinal.sdk.crypto.encryptor.EntitiesEncryptionManifests
import com.icure.cardinal.sdk.crypto.encryptor.EntitiesEncryptorInitializer
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptionManifest
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.RootEntitiesEncryptors
import com.icure.cardinal.sdk.crypto.encryptor.impl.generated.LegacyServiceEncryptorFactory
import com.icure.cardinal.sdk.model.DecryptedAccessLog
import com.icure.cardinal.sdk.model.DecryptedCalendarItem
import com.icure.cardinal.sdk.model.DecryptedClassification
import com.icure.cardinal.sdk.model.DecryptedContact
import com.icure.cardinal.sdk.model.DecryptedDocument
import com.icure.cardinal.sdk.model.DecryptedForm
import com.icure.cardinal.sdk.model.DecryptedHealthElement
import com.icure.cardinal.sdk.model.DecryptedInvoice
import com.icure.cardinal.sdk.model.DecryptedMessage
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.DecryptedReceipt
import com.icure.cardinal.sdk.model.DecryptedTopic
import com.icure.cardinal.sdk.model.EncryptedAccessLog
import com.icure.cardinal.sdk.model.EncryptedCalendarItem
import com.icure.cardinal.sdk.model.EncryptedClassification
import com.icure.cardinal.sdk.model.EncryptedContact
import com.icure.cardinal.sdk.model.EncryptedDocument
import com.icure.cardinal.sdk.model.EncryptedForm
import com.icure.cardinal.sdk.model.EncryptedHealthElement
import com.icure.cardinal.sdk.model.EncryptedInvoice
import com.icure.cardinal.sdk.model.EncryptedMessage
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.model.EncryptedReceipt
import com.icure.cardinal.sdk.model.EncryptedTopic
import com.icure.cardinal.sdk.model.embed.DecryptedService
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.model.embed.EncryptedService
import com.icure.cardinal.sdk.utils.ensureNonNull
import com.icure.utils.InternalIcureApi
import kotlin.reflect.KClass

/**
 * Initializes all [EntityEncryptor]s required by a set of [EntitiesEncryptionManifests], using a queue-based
 * algorithm that allows an encryptor's dependencies (recursively-encrypted fields, referenced by manifest name) to be
 * generated in any order, including cyclically, without requiring the dependency graph to be resolved upfront.
 *
 * ### Algorithm
 * - [initializeEncryptorsForManifests] first queues a generation request for each root entity manifest (see
 *   [fillInitialQueue]), then drains the queue one request at a time, calling [EntityEncryptorFactory.create] and
 *   storing the result in `manifestToEncryptor`.
 * - While a factory's [EntityEncryptorFactory.create] is running it can request the encryptor of another manifest
 *   (e.g. for a recursively-encrypted field) via [EncryptorFactoryContext.getEntityEncryptorProvider]. This queues a
 *   generation request for that manifest if one hasn't already been queued, and returns a [Lazy] rather than the
 *   encryptor itself.
 * - Since each manifest name is only ever queued once ([Context.markManifestTypeAndQueueGeneration] is idempotent
 *   per name), and the set of manifest names is finite, the queue is guaranteed to drain.
 *
 * ### The laziness contract
 * A dependency's [Lazy] may still be unresolved by the time it is handed to the requesting factory: this is what
 * makes cyclic dependencies possible (for example the `service` manifest can recursively reference itself for
 * compound services). Implementations of [EntityEncryptorFactory.create] must therefore only capture these lazies
 * for later use (i.e. during actual encryption/decryption calls) and must never force them synchronously while
 * still inside [EntityEncryptorFactory.create] — the value is only guaranteed to be available once
 * [initializeEncryptorsForManifests] as a whole has finished draining the queue.
 *
 * ### Validation
 * Validation that does not require knowledge of dependencies (e.g. that a manifest name exists, and that it is not
 * requested twice for two different type pairs) is done eagerly in [Context.markManifestTypeAndQueueGeneration], as
 * soon as a manifest's generation is requested. Anything else is validated only when [EntityEncryptorFactory.create]
 * for that manifest is actually invoked while consuming the queue, meaning a bad manifest can cause
 * [initializeEncryptorsForManifests] to fail only after other, unrelated encryptors have already been created.
 */
@InternalIcureApi
internal abstract class AbstractEntitiesEncryptorInitializer : EntitiesEncryptorInitializer {
	/**
	 * Gives access to all the encryptor factories by key = (encrypted entity type, decrypted entity type)
	 */
	protected abstract val encryptorFactoriesByType: Map<Pair<KClass<*>, KClass<*>>, EntityEncryptorFactory<*, *>>
	/**
	 * Same as above, but the encryptor factory for Service uses the legacy content encryption solution
	 */
	private val encryptorFactoriesByTypeWithLegacyService: Map<Pair<KClass<*>, KClass<*>>, EntityEncryptorFactory<*, *>> by lazy {
		encryptorFactoriesByType + Pair(
			(EncryptedService::class to DecryptedService::class),
			LegacyServiceEncryptorFactory
		)
	}

	override fun <ENCRYPTED : Encryptable, DECRYPTED : Encryptable> initializeSingleEncryptor(
		mainManifestName: String,
		manifestsByName: Map<String, EntityEncryptionManifest>,
		encryptorOptions: EncryptorOptions,
		mainManifestEncryptedEntity: KClass<ENCRYPTED>,
		mainManifestDecryptedEntity: KClass<DECRYPTED>
	): EntityEncryptor<ENCRYPTED, DECRYPTED> {
		val context = initializeContext(
			manifestsByName,
			encryptorOptions,
		)
		context.markManifestTypeAndQueueGeneration(mainManifestName, mainManifestEncryptedEntity, mainManifestDecryptedEntity)
		generateQueuedAndDependencies(context)
		@Suppress("UNCHECKED_CAST")
		return ensureNonNull(context.manifestToEncryptor[mainManifestName]) {
			"Encryptor for $mainManifestName should have been initialized."
		} as EntityEncryptor<ENCRYPTED, DECRYPTED>
	}

	override fun initializeEncryptorsForManifests(
		manifests: EntitiesEncryptionManifests,
		encryptorOptions: EncryptorOptions,
	): RootEntitiesEncryptors {
		val context = initializeContext(
			manifests.manifestsByName,
			encryptorOptions,
		)
		fillInitialQueue(context, manifests)
		generateQueuedAndDependencies(context)
		@Suppress("UNCHECKED_CAST")
		return RootEntitiesEncryptors(
			accessLog = ensureNonNull(context.manifestToEncryptor[manifests.accessLog]) {
				"Encryptor ${manifests.accessLog} for AccessLog should have been initialized."
			} as EntityEncryptor<EncryptedAccessLog, DecryptedAccessLog>,
			calendarItem = ensureNonNull(context.manifestToEncryptor[manifests.calendarItem]) {
				"Encryptor ${manifests.calendarItem} for CalendarItem should have been initialized."
			} as EntityEncryptor<EncryptedCalendarItem, DecryptedCalendarItem>,
			contact = ensureNonNull(context.manifestToEncryptor[manifests.contact]) {
				"Encryptor ${manifests.contact} for Contact should have been initialized."
			} as EntityEncryptor<EncryptedContact, DecryptedContact>,
			healthElement = ensureNonNull(context.manifestToEncryptor[manifests.healthElement]) {
				"Encryptor ${manifests.healthElement} for HealthElement should have been initialized."
			} as EntityEncryptor<EncryptedHealthElement, DecryptedHealthElement>,
			patient = ensureNonNull(context.manifestToEncryptor[manifests.patient]) {
				"Encryptor ${manifests.patient} for Patient should have been initialized."
			} as EntityEncryptor<EncryptedPatient, DecryptedPatient>,
			message = ensureNonNull(context.manifestToEncryptor[manifests.message]) {
				"Encryptor ${manifests.message} for Message should have been initialized."
			} as EntityEncryptor<EncryptedMessage, DecryptedMessage>,
			topic = ensureNonNull(context.manifestToEncryptor[manifests.topic]) {
				"Encryptor ${manifests.topic} for Topic should have been initialized."
			} as EntityEncryptor<EncryptedTopic, DecryptedTopic>,
			document = ensureNonNull(context.manifestToEncryptor[manifests.document]) {
				"Encryptor ${manifests.document} for Document should have been initialized."
			} as EntityEncryptor<EncryptedDocument, DecryptedDocument>,
			form = ensureNonNull(context.manifestToEncryptor[manifests.form]) {
				"Encryptor ${manifests.form} for Form should have been initialized."
			} as EntityEncryptor<EncryptedForm, DecryptedForm>,
			receipt = ensureNonNull(context.manifestToEncryptor[manifests.receipt]) {
				"Encryptor ${manifests.receipt} for Receipt should have been initialized."
			} as EntityEncryptor<EncryptedReceipt, DecryptedReceipt>,
			classification = ensureNonNull(context.manifestToEncryptor[manifests.classification]) {
				"Encryptor ${manifests.classification} for Classification should have been initialized."
			} as EntityEncryptor<EncryptedClassification, DecryptedClassification>,
			invoice = ensureNonNull(context.manifestToEncryptor[manifests.invoice]) {
				"Encryptor ${manifests.invoice} for Invoice should have been initialized."
			} as EntityEncryptor<EncryptedInvoice, DecryptedInvoice>,
		)
	}

	private fun generateQueuedAndDependencies(context: Context) {
		while (context.toGenerateQueue.isNotEmpty()) {
			val currRequest = context.toGenerateQueue.removeFirst()
			context.manifestToEncryptor[currRequest.manifestName] = currRequest.factory.create(
				entityManifestName = currRequest.manifestName,
				encryptorFactoryContext = context
			)
		}
	}

	private fun fillInitialQueue(context: Context, manifests: EntitiesEncryptionManifests) {
		context.markManifestTypeAndQueueGeneration<EncryptedAccessLog, DecryptedAccessLog>(manifests.accessLog)
		context.markManifestTypeAndQueueGeneration<EncryptedCalendarItem, DecryptedCalendarItem>(manifests.calendarItem)
		context.markManifestTypeAndQueueGeneration<EncryptedContact, DecryptedContact>(manifests.contact)
		context.markManifestTypeAndQueueGeneration<EncryptedHealthElement, DecryptedHealthElement>(manifests.healthElement)
		context.markManifestTypeAndQueueGeneration<EncryptedPatient, DecryptedPatient>(manifests.patient)
		context.markManifestTypeAndQueueGeneration<EncryptedMessage, DecryptedMessage>(manifests.message)
		context.markManifestTypeAndQueueGeneration<EncryptedTopic, DecryptedTopic>(manifests.topic)
		context.markManifestTypeAndQueueGeneration<EncryptedDocument, DecryptedDocument>(manifests.document)
		context.markManifestTypeAndQueueGeneration<EncryptedForm, DecryptedForm>(manifests.form)
		context.markManifestTypeAndQueueGeneration<EncryptedReceipt, DecryptedReceipt>(manifests.receipt)
		context.markManifestTypeAndQueueGeneration<EncryptedClassification, DecryptedClassification>(manifests.classification)
		context.markManifestTypeAndQueueGeneration<EncryptedInvoice, DecryptedInvoice>(manifests.invoice)
	}

	private inline fun <reified ENCRYPTED : Encryptable, reified DECRYPTED : Encryptable> Context.markManifestTypeAndQueueGeneration(manifestName: String) =
		markManifestTypeAndQueueGeneration(
			manifestName = manifestName,
			encryptedClass = ENCRYPTED::class,
			decryptedClass = DECRYPTED::class
		)

	private fun initializeContext(
		manifestsByName: Map<String, EntityEncryptionManifest>,
		encryptorOptions: EncryptorOptions,
	): Context = Context(
		manifestsByName = manifestsByName,
		factories =
			if (encryptorOptions.useLegacyServiceContentEncryption)
				encryptorFactoriesByTypeWithLegacyService
			else
				encryptorFactoriesByType,
		serializeEncryptedSelfUsingLegacyNames = encryptorOptions.serializeEncryptedSelfUsingLegacyNames,
	)

	private class Context(
		private val manifestsByName: Map<String, EntityEncryptionManifest>,
		private val factories: Map<Pair<KClass<*>, KClass<*>>, EntityEncryptorFactory<*, *>>,
		override val serializeEncryptedSelfUsingLegacyNames: Boolean,
	) : EncryptorFactoryContext {
		private val manifestTypeRegistry = mutableMapOf<String, Pair<KClass<*>, KClass<*>>>() // manifest name -> (encrypted class, decrypted class)
		val manifestToEncryptor = mutableMapOf<String, EntityEncryptor<*, *>>()
		val toGenerateQueue: ArrayDeque<GenerationRequest> = ArrayDeque()

		override fun <ENCRYPTED : Encryptable, DECRYPTED : Encryptable> getEntityEncryptorProvider(
			entityManifestName: String,
			encryptedClass: KClass<ENCRYPTED>,
			decryptedClass: KClass<DECRYPTED>
		): Lazy<EntityEncryptor<ENCRYPTED, DECRYPTED>> {
			markManifestTypeAndQueueGeneration(
				manifestName = entityManifestName,
				encryptedClass = encryptedClass,
				decryptedClass = decryptedClass
			)
			return lazy {
				@Suppress("UNCHECKED_CAST")
				ensureNonNull(
					manifestToEncryptor[entityManifestName]
				) {
					"Encryptor for $entityManifestName is not yet initialized."
				} as EntityEncryptor<ENCRYPTED, DECRYPTED>
			}
		}

		override fun getManifest(manifestName: String): EntityEncryptionManifest =
			requireNotNull(manifestsByName[manifestName]) {
				"Manifest $manifestName is not defined." // Validation with better error messages is done at init of EntitiesEncryptionManifests
			}

		fun markManifestTypeAndQueueGeneration(manifestName: String, encryptedClass: KClass<out Encryptable>, decryptedClass: KClass<out Encryptable>) {
			val registered = manifestTypeRegistry[manifestName]
			if (registered != null) {
				require(registered.first == encryptedClass && registered.second == decryptedClass) {
					"Manifest $manifestName is already registered for ${registered.first.simpleName} <-> ${registered.second.simpleName}, but ${encryptedClass.simpleName} <-> ${decryptedClass.simpleName} was requested."
				}
			} else {
				manifestTypeRegistry[manifestName] = encryptedClass to decryptedClass
				val factory = getEncryptorFactoryFor(encrypted = encryptedClass, decrypted = decryptedClass)
				getManifest(manifestName) // just check exists
				toGenerateQueue.addLast(GenerationRequest(manifestName, factory))
			}
		}

		@Suppress("UNCHECKED_CAST")
		private fun <ENCRYPTED : Encryptable, DECRYPTED : Encryptable> getEncryptorFactoryFor(encrypted: KClass<ENCRYPTED>, decrypted: KClass<DECRYPTED>) =
			ensureNonNull(
				factories[encrypted to decrypted]
			) {
				"Missing encryptor factory for ${encrypted.simpleName} <-> ${decrypted.simpleName}"
			} as EntityEncryptorFactory<ENCRYPTED, DECRYPTED>
	}

	private data class GenerationRequest(
		val manifestName: String,
		val factory: EntityEncryptorFactory<*, *>
	)
}