package com.icure.cardinal.sdk.crypto.encryptor.impl

import com.icure.cardinal.sdk.crypto.encryptor.DecryptorOptions
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EncryptorOptions
import com.icure.cardinal.sdk.crypto.encryptor.EntitiesEncryptionManifests
import com.icure.cardinal.sdk.crypto.encryptor.EntitiesEncryptorsInitializer
import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.BuiltinEmbeddedEntityEncryptionManifest
import com.icure.cardinal.sdk.crypto.encryptor.BuiltinRootEntityEncryptionManifest
import com.icure.cardinal.sdk.crypto.encryptor.CustomEntityEncryptionManifest
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.RootEntityDecryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.RootEntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptionManifest
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptors
import com.icure.cardinal.sdk.crypto.encryptor.ExtensionsEncryptionManifest
import com.icure.cardinal.sdk.crypto.encryptor.ExtensionsEncryptors
import com.icure.cardinal.sdk.crypto.encryptor.RootEntitiesEncryptors
import com.icure.cardinal.sdk.crypto.encryptor.SharedEncryptorsOptions
import com.icure.cardinal.sdk.crypto.encryptor.impl.generated.CustomEntityBaseEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.impl.generated.LegacyServiceEncryptorFactory
import com.icure.cardinal.sdk.customsdk.commons.model.CustomisedModelVersion
import com.icure.cardinal.sdk.model.DecryptedAccessLog
import com.icure.cardinal.sdk.model.DecryptedCalendarItem
import com.icure.cardinal.sdk.model.DecryptedContact
import com.icure.cardinal.sdk.model.DecryptedCustomEntityBase
import com.icure.cardinal.sdk.model.DecryptedDocument
import com.icure.cardinal.sdk.model.DecryptedForm
import com.icure.cardinal.sdk.model.DecryptedHealthElement
import com.icure.cardinal.sdk.model.DecryptedInvoice
import com.icure.cardinal.sdk.model.DecryptedMessage
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.DecryptedRelatedPerson
import com.icure.cardinal.sdk.model.DecryptedTopic
import com.icure.cardinal.sdk.model.EncryptedAccessLog
import com.icure.cardinal.sdk.model.EncryptedCalendarItem
import com.icure.cardinal.sdk.model.EncryptedContact
import com.icure.cardinal.sdk.model.EncryptedCustomEntityBase
import com.icure.cardinal.sdk.model.EncryptedDocument
import com.icure.cardinal.sdk.model.EncryptedForm
import com.icure.cardinal.sdk.model.EncryptedHealthElement
import com.icure.cardinal.sdk.model.EncryptedInvoice
import com.icure.cardinal.sdk.model.EncryptedMessage
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.model.EncryptedRelatedPerson
import com.icure.cardinal.sdk.model.EncryptedTopic
import com.icure.cardinal.sdk.model.embed.DecryptedService
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.model.embed.EncryptedService
import com.icure.cardinal.sdk.options.DecryptedJsonStrictness
import com.icure.cardinal.sdk.utils.ensureNonNull
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
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
 * - [initializeEncryptorsForManifests] first creates the encryptors of each root entity from its manifest
 *   ([RootEntityEncryptorFactory.create], also for custom entities), then drains the queue of the encryptors of embedded
 *   entities requested by them one request at a time, calling [EntityEncryptorFactory.create] and storing the result in
 *   `manifestToEncryptor`.
 * - While a factory's `create` is running it can request the encryptor of another (embedded entity) manifest
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
	 * Gives access to all the encryptor factories for root entities by key = (encrypted entity type, decrypted entity type)
	 */
	protected abstract val rootEncryptorFactoriesByType: Map<Pair<KClass<*>, KClass<*>>, RootFactories<*, *>>
	/**
	 * Same as [encryptorFactoriesByType], but the encryptor factory for Service uses the legacy content encryption solution
	 */
	private val encryptorFactoriesByTypeWithLegacyService: Map<Pair<KClass<*>, KClass<*>>, Factories<*, *>> by lazy {
		@Suppress("UNCHECKED_CAST")
		val standardServiceFactories = encryptorFactoriesByType.getValue(
			EncryptedService::class to DecryptedService::class
		) as Factories<EncryptedService, DecryptedService>
		encryptorFactoriesByType + Pair(
			(EncryptedService::class to DecryptedService::class),
			Factories(LegacyServiceEncryptorFactory, standardServiceFactories.decryptor)
		)
	}
	/**
	 * Same as [rootEncryptorFactoriesByType], but the encryptor factory for Contact uses the legacy service content
	 * encryption solution
	 */
	private val rootEncryptorFactoriesByTypeWithLegacyService: Map<Pair<KClass<*>, KClass<*>>, RootFactories<*, *>> by lazy {
		@Suppress("UNCHECKED_CAST")
		val standardContactFactories = rootEncryptorFactoriesByType.getValue(
			EncryptedContact::class to DecryptedContact::class
		) as RootFactories<EncryptedContact, DecryptedContact>
		rootEncryptorFactoriesByType + Pair(
			(EncryptedContact::class to DecryptedContact::class),
			RootFactories(LegacyContactEncryptorFactory, standardContactFactories.decryptor)
		)
	}

	protected data class Factories<ENCRYPTED : Encryptable, DECRYPTED : Encryptable>(
		val encryptor: EntityEncryptorFactory<ENCRYPTED, DECRYPTED>,
		val decryptor: EntityDecryptorFactory<ENCRYPTED, DECRYPTED>,
	)

	protected data class RootFactories<ENCRYPTED : Encryptable, DECRYPTED : Encryptable>(
		val encryptor: RootEntityEncryptorFactory<ENCRYPTED, DECRYPTED>,
		val decryptor: RootEntityDecryptorFactory<ENCRYPTED, DECRYPTED>,
	)

	override fun <ENCRYPTED : Encryptable, DECRYPTED : Encryptable> initializeSingleEntityEncryptors(
		rootManifest: BuiltinRootEntityEncryptionManifest,
		embeddedManifestsByName: Map<String, BuiltinEmbeddedEntityEncryptionManifest>,
		encryptorOptions: EncryptorOptions,
		decryptorOptions: DecryptorOptions,
		sharedOptions: SharedEncryptorsOptions,
		rootEncryptedEntity: KClass<ENCRYPTED>,
		rootDecryptedEntity: KClass<DECRYPTED>,
	): EntityEncryptors<ENCRYPTED, DECRYPTED> {
		val context = initializeContext(
			embeddedManifestsByName = embeddedManifestsByName,
			customEntityManifestsByName = emptyMap(),
			encryptorOptions = encryptorOptions,
			decryptorOptions = decryptorOptions,
			sharedOptions = sharedOptions,
			extensionsManifestsByName = emptyMap() // Only used without custom extensions
		)
		val encryptors = context.createRootEncryptors(rootManifest, rootEncryptedEntity, rootDecryptedEntity)
		generateQueuedAndDependencies(context)
		return encryptors
	}

	override fun initializeEncryptorsForManifests(
		manifests: EntitiesEncryptionManifests,
		encryptorOptions: EncryptorOptions,
		decryptorOptions: DecryptorOptions,
		sharedOptions: SharedEncryptorsOptions,
	): RootEntitiesEncryptors {
		val context = initializeContext(
			embeddedManifestsByName = manifests.embeddedManifestsByName,
			customEntityManifestsByName = manifests.customEntitiesManifestByEntityTypeId,
			encryptorOptions = encryptorOptions,
			decryptorOptions = decryptorOptions,
			sharedOptions = sharedOptions,
			extensionsManifestsByName = manifests.extensionsManifestsByName,
		)
		val customEntitiesEncryptors = manifests.customEntitiesManifestByEntityTypeId.keys.associateWith { typeId ->
			EntityEncryptors(
				CustomEntityBaseEncryptorFactory.create(
					customEntityTypeId = typeId,
					encryptorsFactoryContext = context,
					encodingJson = context.encryptedContentJson,
					cryptoService = context.cryptoService,
				),
				CustomEntityBaseDecryptorFactory.create(
					customEntityTypeId = typeId,
					encryptorsFactoryContext = context,
					cryptoService = context.cryptoService,
					encryptedContentDecoder = context.encryptedContentJson,
					unversionedEntitiesDecryptedJsonStrictness = context.unversionedEntitiesDecryptedJsonStrictness
				)
			)
		}
		// Must be created before generating the queued encryptors of embedded entities, which they may request
		val accessLog = context.createRootEncryptorsOrUnsupported<EncryptedAccessLog, DecryptedAccessLog>(manifests.accessLog, "AccessLog")
		val calendarItem = context.createRootEncryptorsOrUnsupported<EncryptedCalendarItem, DecryptedCalendarItem>(manifests.calendarItem, "CalendarItem")
		val contact = context.createRootEncryptorsOrUnsupported<EncryptedContact, DecryptedContact>(manifests.contact, "Contact")
		val healthElement = context.createRootEncryptorsOrUnsupported<EncryptedHealthElement, DecryptedHealthElement>(manifests.healthElement, "HealthElement")
		val patient = context.createRootEncryptorsOrUnsupported<EncryptedPatient, DecryptedPatient>(manifests.patient, "Patient")
		val message = context.createRootEncryptorsOrUnsupported<EncryptedMessage, DecryptedMessage>(manifests.message, "Message")
		val topic = context.createRootEncryptorsOrUnsupported<EncryptedTopic, DecryptedTopic>(manifests.topic, "Topic")
		val document = context.createRootEncryptorsOrUnsupported<EncryptedDocument, DecryptedDocument>(manifests.document, "Document")
		val form = context.createRootEncryptorsOrUnsupported<EncryptedForm, DecryptedForm>(manifests.form, "Form")
		val invoice = context.createRootEncryptorsOrUnsupported<EncryptedInvoice, DecryptedInvoice>(manifests.invoice, "Invoice")
		val relatedPerson = context.createRootEncryptorsOrUnsupported<EncryptedRelatedPerson, DecryptedRelatedPerson>(manifests.relatedPerson, "RelatedPerson")
		generateQueuedAndDependencies(context)
		return RootEntitiesEncryptors(
			accessLog = accessLog,
			calendarItem = calendarItem,
			contact = contact,
			healthElement = healthElement,
			patient = patient,
			message = message,
			topic = topic,
			document = document,
			form = form,
			invoice = invoice,
			relatedPerson = relatedPerson,
			customEntities = customEntitiesEncryptors,
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

	private fun <ENCRYPTED : Encryptable, DECRYPTED : Encryptable> Context.createRootEncryptors(
		manifest: BuiltinRootEntityEncryptionManifest,
		encryptedClass: KClass<ENCRYPTED>,
		decryptedClass: KClass<DECRYPTED>,
	): EntityEncryptors<ENCRYPTED, DECRYPTED> {
		val factories = getRootFactoriesFor(encrypted = encryptedClass, decrypted = decryptedClass)
		return EntityEncryptors(
			encryptor = factories.encryptor.create(
				manifest = manifest,
				encryptorsFactoryContext = this,
				encodingJson = encryptedContentJson,
				cryptoService = cryptoService,
			),
			decryptor = factories.decryptor.create(
				manifest = manifest,
				encryptorsFactoryContext = this,
				cryptoService = cryptoService,
				encryptedContentDecoder = encryptedContentJson,
				unversionedEntitiesDecryptedJsonStrictness = unversionedEntitiesDecryptedJsonStrictness,
			),
		)
	}

	private inline fun <reified ENCRYPTED : Encryptable, reified DECRYPTED : Encryptable> Context.createRootEncryptors(
		manifest: BuiltinRootEntityEncryptionManifest,
	): EntityEncryptors<ENCRYPTED, DECRYPTED> =
		createRootEncryptors(manifest, ENCRYPTED::class, DECRYPTED::class)

	/**
	 * If [manifest] is null (root entity not supported) the encryptors fail on use.
	 */
	private inline fun <reified ENCRYPTED : Encryptable, reified DECRYPTED : Encryptable> Context.createRootEncryptorsOrUnsupported(
		manifest: BuiltinRootEntityEncryptionManifest?,
		entityName: String,
	): EntityEncryptors<ENCRYPTED, DECRYPTED> =
		if (manifest != null) createRootEncryptors(manifest) else unsupportedRootEntityEncryptors(entityName)

	/**
	 * Encryptors for a root entity type that is not supported by the SDK (not included in the configuration of the
	 * customised SDK): any use fails.
	 */
	private fun <ENCRYPTED : Encryptable, DECRYPTED : Encryptable> unsupportedRootEntityEncryptors(
		entityName: String
	): EntityEncryptors<ENCRYPTED, DECRYPTED> {
		fun fail(): Nothing = throw UnsupportedOperationException(
			"$entityName entities are not supported by this SDK: the configuration of the customised SDK should include $entityName to use them."
		)
		return EntityEncryptors(
			encryptor = object : EntityEncryptor<ENCRYPTED, DECRYPTED> {
				override suspend fun encrypt(
					encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
					clearEntity: DECRYPTED,
				): ENCRYPTED = fail()
			},
			decryptor = object : EntityDecryptor<ENCRYPTED, DECRYPTED> {
				override suspend fun decrypt(
					decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
					encryptedEntity: ENCRYPTED,
					customisedModelVersion: CustomisedModelVersion?,
				): DECRYPTED = fail()
			},
		)
	}

	private fun initializeContext(
		embeddedManifestsByName: Map<String, BuiltinEmbeddedEntityEncryptionManifest>,
		customEntityManifestsByName: Map<String, CustomEntityEncryptionManifest>,
		encryptorOptions: EncryptorOptions,
		decryptorOptions: DecryptorOptions,
		sharedOptions: SharedEncryptorsOptions,
		extensionsManifestsByName: Map<String, ExtensionsEncryptionManifest>,
	): Context = Context(
		embeddedManifestsByName = embeddedManifestsByName,
		factories =
			if (encryptorOptions.useLegacyServiceContentEncryption)
				encryptorFactoriesByTypeWithLegacyService
			else
				encryptorFactoriesByType,
		rootFactories =
			if (encryptorOptions.useLegacyServiceContentEncryption)
				rootEncryptorFactoriesByTypeWithLegacyService
			else
				rootEncryptorFactoriesByType,
		serializeEncryptedSelfUsingLegacyNames = encryptorOptions.serializeEncryptedSelfUsingLegacyNames,
		cryptoService = sharedOptions.cryptoService,
		encryptedContentJson = sharedOptions.json,
		unversionedEntitiesDecryptedJsonStrictness = decryptorOptions.unversionedEntitiesDecryptedJsonStrictness,
		extensionsManifestsByName = extensionsManifestsByName,
		customEntityManifestsByName = customEntityManifestsByName,
	)

	private class Context(
		private val embeddedManifestsByName: Map<String, BuiltinEmbeddedEntityEncryptionManifest>,
		private val customEntityManifestsByName: Map<String, CustomEntityEncryptionManifest>,
		private val factories: Map<Pair<KClass<*>, KClass<*>>, Factories<*, *>>,
		private val rootFactories: Map<Pair<KClass<*>, KClass<*>>, RootFactories<*, *>>,
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

		override fun getEmbeddedManifest(manifestName: String): BuiltinEmbeddedEntityEncryptionManifest =
			ensureNonNull(embeddedManifestsByName[manifestName]) {
				"Manifest $manifestName is not defined." // Validation with better error messages is done at init of EntitiesEncryptionManifests
			}

		override fun getCustomEntityManifest(entityTypeId: String): CustomEntityEncryptionManifest =
			ensureNonNull(customEntityManifestsByName[entityTypeId]) {
				"Custom entity manifest $entityTypeId is not defined."
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
				getEmbeddedManifest(manifestName) // just check exists
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

		@Suppress("UNCHECKED_CAST")
		fun <ENCRYPTED : Encryptable, DECRYPTED : Encryptable> getRootFactoriesFor(encrypted: KClass<ENCRYPTED>, decrypted: KClass<DECRYPTED>) =
			ensureNonNull(
				rootFactories[encrypted to decrypted]
			) {
				"Missing root encryptor factory for ${encrypted.simpleName} <-> ${decrypted.simpleName}"
			} as RootFactories<ENCRYPTED, DECRYPTED>

		// TODO currently unsupported
		override fun getManifestDecryptedJsonPatcher(manifest: EntityEncryptionManifest): ((JsonObject) -> JsonObject)? =
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