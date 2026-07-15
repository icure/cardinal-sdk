package com.icure.cardinal.sdk.crypto.encryptor.impl

import com.icure.cardinal.sdk.crypto.encryptor.DecryptorOptions
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EncryptorOptions
import com.icure.cardinal.sdk.crypto.encryptor.EntitiesEncryptionManifests
import com.icure.cardinal.sdk.crypto.encryptor.EntitiesEncryptorsInitializer
import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptionManifest
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptors
import com.icure.cardinal.sdk.crypto.encryptor.ExtensionsEncryptionManifest
import com.icure.cardinal.sdk.crypto.encryptor.ExtensionsEncryptors
import com.icure.cardinal.sdk.crypto.encryptor.RootEntitiesEncryptors
import com.icure.cardinal.sdk.crypto.encryptor.SharedEncryptorsOptions
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
import com.icure.cardinal.sdk.options.DecryptedJsonStrictness
import com.icure.cardinal.sdk.utils.ensure
import com.icure.cardinal.sdk.utils.ensureNonNull
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.collections.set
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
 *   (e.g. for a recursively-encrypted field) via [EntityEncryptorsFactoryContext.getEntityEncryptorsProvider]. This queues a
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
internal abstract class AbstractEntitiesEncryptorsInitializer : EntitiesEncryptorsInitializer {
	/**
	 * Gives access to all the encryptor factories by key = (encrypted entity type, decrypted entity type)
	 */
	protected abstract val encryptorFactoriesByType: Map<Pair<KClass<*>, KClass<*>>, Factories<*, *>>
	/**
	 * Same as above, but the encryptor factory for Service uses the legacy content encryption solution
	 */
	private val encryptorFactoriesByTypeWithLegacyService: Map<Pair<KClass<*>, KClass<*>>, Factories<*, *>> by lazy {
		@Suppress("UNCHECKED_CAST")
		val standardContactFactories = encryptorFactoriesByType.getValue(
			EncryptedContact::class to DecryptedContact::class
		) as Factories<EncryptedContact, DecryptedContact>
		@Suppress("UNCHECKED_CAST")
		val standardServiceFactories = encryptorFactoriesByType.getValue(
			EncryptedService::class to DecryptedService::class
		) as Factories<EncryptedService, DecryptedService>
		encryptorFactoriesByType + Pair(
			(EncryptedService::class to DecryptedService::class),
			Factories(LegacyServiceEncryptorFactory, standardServiceFactories.decryptor)
		) + Pair(
			(EncryptedContact::class to DecryptedContact::class),
			Factories(LegacyContactEncryptorFactory, standardContactFactories.decryptor)
		)
	}

	protected data class Factories<ENCRYPTED : Encryptable, DECRYPTED : Encryptable>(
		val encryptor: EntityEncryptorFactory<ENCRYPTED, DECRYPTED>,
		val decryptor: EntityDecryptorFactory<ENCRYPTED, DECRYPTED>,
	)

	override fun <ENCRYPTED : Encryptable, DECRYPTED : Encryptable> initializeSingleEntityEncryptors(
		mainManifestName: String,
		manifestsByName: Map<String, EntityEncryptionManifest>,
		encryptorOptions: EncryptorOptions,
		decryptorOptions: DecryptorOptions,
		sharedOptions: SharedEncryptorsOptions,
		mainManifestEncryptedEntity: KClass<ENCRYPTED>,
		mainManifestDecryptedEntity: KClass<DECRYPTED>,
	): EntityEncryptors<ENCRYPTED, DECRYPTED> {
		val context = initializeContext(
			manifestsByName,
			encryptorOptions,
			decryptorOptions,
			sharedOptions,
			emptyMap() // Only used without custom extensions
		)
		context.markManifestTypeAndQueueGeneration(mainManifestName, mainManifestEncryptedEntity, mainManifestDecryptedEntity)
		generateQueuedAndDependencies(context)
		@Suppress("UNCHECKED_CAST")
		return ensureNonNull(context.manifestToEncryptors[mainManifestName]) {
			"Encryptor for $mainManifestName should have been initialized."
		} as EntityEncryptors<ENCRYPTED, DECRYPTED>
	}

	override fun initializeEncryptorsForManifests(
		manifests: EntitiesEncryptionManifests,
		encryptorOptions: EncryptorOptions,
		decryptorOptions: DecryptorOptions,
		sharedOptions: SharedEncryptorsOptions,
	): RootEntitiesEncryptors {
		val context = initializeContext(
			manifests.manifestsByName,
			encryptorOptions,
			decryptorOptions,
			sharedOptions,
			manifests.extensionsManifestsByName,
		)
		fillInitialQueue(context, manifests)
		generateQueuedAndDependencies(context)
		@Suppress("UNCHECKED_CAST")
		return RootEntitiesEncryptors(
			accessLog = ensureNonNull(context.manifestToEncryptors[manifests.accessLog]) {
				"Encryptor ${manifests.accessLog} for AccessLog should have been initialized."
			} as EntityEncryptors<EncryptedAccessLog, DecryptedAccessLog>,
			calendarItem = ensureNonNull(context.manifestToEncryptors[manifests.calendarItem]) {
				"Encryptor ${manifests.calendarItem} for CalendarItem should have been initialized."
			} as EntityEncryptors<EncryptedCalendarItem, DecryptedCalendarItem>,
			contact = ensureNonNull(context.manifestToEncryptors[manifests.contact]) {
				"Encryptor ${manifests.contact} for Contact should have been initialized."
			} as EntityEncryptors<EncryptedContact, DecryptedContact>,
			healthElement = ensureNonNull(context.manifestToEncryptors[manifests.healthElement]) {
				"Encryptor ${manifests.healthElement} for HealthElement should have been initialized."
			} as EntityEncryptors<EncryptedHealthElement, DecryptedHealthElement>,
			patient = ensureNonNull(context.manifestToEncryptors[manifests.patient]) {
				"Encryptor ${manifests.patient} for Patient should have been initialized."
			} as EntityEncryptors<EncryptedPatient, DecryptedPatient>,
			message = ensureNonNull(context.manifestToEncryptors[manifests.message]) {
				"Encryptor ${manifests.message} for Message should have been initialized."
			} as EntityEncryptors<EncryptedMessage, DecryptedMessage>,
			topic = ensureNonNull(context.manifestToEncryptors[manifests.topic]) {
				"Encryptor ${manifests.topic} for Topic should have been initialized."
			} as EntityEncryptors<EncryptedTopic, DecryptedTopic>,
			document = ensureNonNull(context.manifestToEncryptors[manifests.document]) {
				"Encryptor ${manifests.document} for Document should have been initialized."
			} as EntityEncryptors<EncryptedDocument, DecryptedDocument>,
			form = ensureNonNull(context.manifestToEncryptors[manifests.form]) {
				"Encryptor ${manifests.form} for Form should have been initialized."
			} as EntityEncryptors<EncryptedForm, DecryptedForm>,
			receipt = ensureNonNull(context.manifestToEncryptors[manifests.receipt]) {
				"Encryptor ${manifests.receipt} for Receipt should have been initialized."
			} as EntityEncryptors<EncryptedReceipt, DecryptedReceipt>,
			classification = ensureNonNull(context.manifestToEncryptors[manifests.classification]) {
				"Encryptor ${manifests.classification} for Classification should have been initialized."
			} as EntityEncryptors<EncryptedClassification, DecryptedClassification>,
			invoice = ensureNonNull(context.manifestToEncryptors[manifests.invoice]) {
				"Encryptor ${manifests.invoice} for Invoice should have been initialized."
			} as EntityEncryptors<EncryptedInvoice, DecryptedInvoice>,
		)
	}

	private fun generateQueuedAndDependencies(context: Context) {
		while (context.toGenerateQueue.isNotEmpty()) {
			when (val currRequest = context.toGenerateQueue.removeFirst()) {
				is GenerationRequest.EmptyDecryptor -> {
					context.emptyDecryptorsByType[currRequest.entryKey] = currRequest.factory.create(
						entityManifestName = null,
						encryptorsFactoryContext = context,
						cryptoService = context.cryptoService,
						encryptedContentDecoder = context.encryptedContentJson,
						unversionedEntitiesDecryptedJsonStrictness = context.unversionedEntitiesDecryptedJsonStrictness
					)
				}
				is GenerationRequest.Encryptors -> {
					currRequest.factories.createEncryptors(
						context,
						currRequest.manifestName,
					)
				}
				is GenerationRequest.ExtensionEncryptors -> {
					context.manifestToExtensionsEncryptors[currRequest.manifestName] = ExtensionsEncryptorsFactory.create(
						currRequest.manifestName,
						context,
						context.cryptoService
					)
				}
			}
		}
	}

	private fun <ENCRYPTED : Encryptable, DECRYPTED : Encryptable> Factories<ENCRYPTED, DECRYPTED>.createEncryptors(
		context: Context,
		manifestName: String,
	) {
		val encryptor = this.encryptor.create(
			entityManifestName = manifestName,
			encryptorsFactoryContext = context,
			encodingJson = context.encryptedContentJson,
			cryptoService = context.cryptoService,
		)
		val decryptor = this.decryptor.create(
			entityManifestName = manifestName,
			encryptedContentDecoder = context.encryptedContentJson,
			encryptorsFactoryContext = context,
			cryptoService = context.cryptoService,
			unversionedEntitiesDecryptedJsonStrictness = context.unversionedEntitiesDecryptedJsonStrictness,
		)
		context.manifestToEncryptors[manifestName] = EntityEncryptors(encryptor, decryptor)
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
		decryptorOptions: DecryptorOptions,
		sharedOptions: SharedEncryptorsOptions,
		extensionsManifestsByName: Map<String, ExtensionsEncryptionManifest>,
	): Context = Context(
		manifestsByName = manifestsByName,
		factories =
			if (encryptorOptions.useLegacyServiceContentEncryption)
				encryptorFactoriesByTypeWithLegacyService
			else
				encryptorFactoriesByType,
		serializeEncryptedSelfUsingLegacyNames = encryptorOptions.serializeEncryptedSelfUsingLegacyNames,
		cryptoService = sharedOptions.cryptoService,
		encryptedContentJson = sharedOptions.json,
		unversionedEntitiesDecryptedJsonStrictness = decryptorOptions.unversionedEntitiesDecryptedJsonStrictness,
		extensionsManifestsByName = extensionsManifestsByName,
	)

	private class Context(
		private val manifestsByName: Map<String, EntityEncryptionManifest>,
		private val factories: Map<Pair<KClass<*>, KClass<*>>, Factories<*, *>>,
		override val serializeEncryptedSelfUsingLegacyNames: Boolean,
		val cryptoService: CryptoService,
		val encryptedContentJson: Json,
		override val unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
		private val extensionsManifestsByName: Map<String, ExtensionsEncryptionManifest>,
	) : EntityEncryptorsFactoryContext, ExtensionsEncryptorFactoryContext {
		private val manifestTypeRegistry = mutableMapOf<String, Pair<KClass<*>, KClass<*>>>() // manifest name -> (encrypted class, decrypted class)
		private val extensionsManifestTypeRegistry = mutableMapOf<String, Pair<KClass<*>, KClass<*>>?>() // manifest name -> (encrypted class, decrypted class) if based on existing entity else null
		private val initializedLazies = mutableMapOf<String, Lazy<EntityEncryptors<*, *>>>()
		private val initializedExtensionsLazies = mutableMapOf<String, Lazy<ExtensionsEncryptors>>()
		private val emptyDecryptorsLazies = mutableMapOf< Pair<KClass<*>, KClass<*>>, Lazy<EntityDecryptor<*, *>>>() // (encrypted class, decrypted class) -> lazy for the empty decryptor
		val manifestToEncryptors = mutableMapOf<String, EntityEncryptors<*, *>>()
		val manifestToExtensionsEncryptors = mutableMapOf<String, ExtensionsEncryptors>()
		val emptyDecryptorsByType = mutableMapOf<Pair<KClass<*>, KClass<*>>, EntityDecryptor<*, *>>() // (encrypted class, decrypted class) -> empty decryptor
		val toGenerateQueue: ArrayDeque<GenerationRequest> = ArrayDeque()

		override fun <ENCRYPTED : Encryptable, DECRYPTED : Encryptable> getEntityEncryptorsProvider(
			entityManifestName: String,
			encryptedClass: KClass<ENCRYPTED>,
			decryptedClass: KClass<DECRYPTED>
		): Lazy<EntityEncryptors<ENCRYPTED, DECRYPTED>> {
			markManifestTypeAndQueueGeneration(
				manifestName = entityManifestName,
				encryptedClass = encryptedClass,
				decryptedClass = decryptedClass
			)
			val alreadyInitialized = initializedLazies[entityManifestName]
			@Suppress("UNCHECKED_CAST")
			if (alreadyInitialized != null) return alreadyInitialized as Lazy<EntityEncryptors<ENCRYPTED, DECRYPTED>>
			return lazy {
				@Suppress("UNCHECKED_CAST")
				ensureNonNull(
					manifestToEncryptors[entityManifestName]
				) {
					"Encryptors for $entityManifestName is not yet initialized."
				} as EntityEncryptors<ENCRYPTED, DECRYPTED>
			}.also { initializedLazies[entityManifestName] = it }
		}

		override fun <ENCRYPTED : Encryptable, DECRYPTED : Encryptable> getEmptyEntityDecryptorProvider(
			encryptedClass: KClass<ENCRYPTED>,
			decryptedClass: KClass<DECRYPTED>
		): Lazy<EntityDecryptor<ENCRYPTED, DECRYPTED>> {
			val key = Pair(encryptedClass, decryptedClass)
			val existing = emptyDecryptorsLazies[key]
			@Suppress("UNCHECKED_CAST")
			if (existing != null) return existing as Lazy<EntityDecryptor<ENCRYPTED, DECRYPTED>>
			toGenerateQueue.add(
				GenerationRequest.EmptyDecryptor(getFactoriesFor(encrypted = encryptedClass, decrypted = decryptedClass).decryptor, key)
			)
			return lazy {
				@Suppress("UNCHECKED_CAST")
				ensureNonNull(
					emptyDecryptorsByType[key]
				) {
					"Empty decryptor for ${encryptedClass.simpleName} -> ${decryptedClass.simpleName} is not yet initialized."
				} as EntityDecryptor<ENCRYPTED, DECRYPTED>
			}.also { emptyDecryptorsLazies[key] = it }
		}

		override fun getExtensionEncryptorsProvider(
			extensionsManifestName: String,
			encryptedClass: KClass<out Encryptable>,
			decryptedClass: KClass<out Encryptable>
		): Lazy<ExtensionsEncryptors> =
			getExtensionEncryptorsProvider(extensionsManifestName, encryptedClass to decryptedClass)

		override fun getExtensionEncryptorsProvider(extensionsManifestName: String): Lazy<ExtensionsEncryptors> =
			getExtensionEncryptorsProvider(extensionsManifestName, null)

		private fun getExtensionEncryptorsProvider(
			extensionsManifestName: String,
			marker: Pair<KClass<out Encryptable>, KClass<out Encryptable>>?
		): Lazy<ExtensionsEncryptors> {
			if (extensionsManifestTypeRegistry.containsKey(extensionsManifestName)) {
				val currValue = extensionsManifestTypeRegistry[extensionsManifestName]
				require(marker == currValue) {
					fun printMarker(it: Pair<KClass<*>, KClass<*>>?) =
						if (it != null) "${it.first.simpleName} <-> ${it.second.simpleName}" else "custom entities"
					"Manifest $extensionsManifestName is already registered for ${printMarker(currValue)}, but ${printMarker(marker)} was requested."
				}
			} else {
				extensionsManifestTypeRegistry[extensionsManifestName] = marker
				getExtensionsManifest(extensionsManifestName) // just check exists
				toGenerateQueue.addLast(GenerationRequest.ExtensionEncryptors(extensionsManifestName))
			}
			return initializedExtensionsLazies[extensionsManifestName] ?: lazy {
				ensureNonNull(
					manifestToExtensionsEncryptors[extensionsManifestName]
				) {
					"Extensions encryptors for $extensionsManifestName is not yet initialized."
				}
			}.also { initializedExtensionsLazies[extensionsManifestName] = it }
		}

		override fun getManifest(manifestName: String): EntityEncryptionManifest =
			ensureNonNull(manifestsByName[manifestName]) {
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
				val factories = getFactoriesFor(encrypted = encryptedClass, decrypted = decryptedClass)
				getManifest(manifestName) // just check exists
				toGenerateQueue.addLast(GenerationRequest.Encryptors(manifestName, factories))
			}
		}

		@Suppress("UNCHECKED_CAST")
		private fun <ENCRYPTED : Encryptable, DECRYPTED : Encryptable> getFactoriesFor(encrypted: KClass<ENCRYPTED>, decrypted: KClass<DECRYPTED>) =
			ensureNonNull(
				factories[encrypted to decrypted]
			) {
				"Missing encryptor factory for ${encrypted.simpleName} <-> ${decrypted.simpleName}"
			} as Factories<ENCRYPTED, DECRYPTED>

		// TODO currently unsupported
		override fun getManifestDecryptedJsonPatcher(manifestName: String): ((JsonObject) -> JsonObject)? =
			null

		override fun getExtensionsManifest(name: String): ExtensionsEncryptionManifest =
			ensureNonNull(extensionsManifestsByName[name]) { "Extensions manifest $name is not defined." }
	}

	private sealed interface GenerationRequest {
		data class Encryptors(
			val manifestName: String,
			val factories: Factories<*, *>
		) : GenerationRequest
		data class ExtensionEncryptors(
			val manifestName: String,
		) : GenerationRequest
		data class EmptyDecryptor(
			val factory: EntityDecryptorFactory<*, *>,
			val entryKey: Pair<KClass<*>, KClass<*>>
		) : GenerationRequest
	}
}