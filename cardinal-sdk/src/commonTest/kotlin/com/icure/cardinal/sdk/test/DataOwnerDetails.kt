package com.icure.cardinal.sdk.test

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.api.raw.RawMessageGatewayApi
import com.icure.cardinal.sdk.api.raw.impl.RawAnonymousAuthApiImpl
import com.icure.cardinal.sdk.auth.UsernamePassword
import com.icure.cardinal.sdk.crypto.CryptoStrategies
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.crypto.impl.BasicCryptoStrategies
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.options.AuthenticationMethod
import com.icure.cardinal.sdk.options.SdkOptions
import com.icure.cardinal.sdk.options.getAuthProvider
import com.icure.cardinal.sdk.storage.CardinalStorageFacade
import com.icure.cardinal.sdk.storage.StorageFacade
import com.icure.cardinal.sdk.storage.impl.DefaultStorageEntryKeysFactory
import com.icure.cardinal.sdk.storage.impl.JsonAndBase64KeyStorage
import com.icure.cardinal.sdk.storage.impl.VolatileStorageFacade
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.kryptom.utils.toHexString
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.Job

@OptIn(InternalIcureApi::class)
@ConsistentCopyVisibility
data class DataOwnerDetails private constructor (
	val dataOwnerId: String,
	val username: String,
	val password: String,
	val keypair: RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>?,
	val parent: DataOwnerDetails?,
	val publicKeySpki: SpkiHexString?,
	val groupId: String
) {
	companion object {
		fun testEmailForLogin(login: String) = "$login@test.com"

		suspend operator fun invoke(
			dataOwnerId: String,
			username: String,
			password: String,
			keypair: RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>?,
			parent: DataOwnerDetails?,
			groupId: String
		) = DataOwnerDetails(
			dataOwnerId = dataOwnerId,
			username = username,
			password = password,
			keypair = keypair,
			parent = parent,
			publicKeySpki = keypair?.let {SpkiHexString( defaultCryptoService.rsa.exportPublicKeySpki(it.public).toHexString())},
			groupId = groupId
		)
	}

	val testEmail: String get() = testEmailForLogin(username)

	fun normalizedReferenceForGroup(groupId: String) = if (groupId == this.groupId) EntityReferenceInGroup(dataOwnerId, null) else fullReference
	val fullReference get() = EntityReferenceInGroup(dataOwnerId, groupId)

	/**
	 * Creates a new api with access to the original key of the user and his parents.
	 */
	suspend fun api(baseJob: Job, cryptoStrategies: CryptoStrategies = BasicCryptoStrategies): CardinalSdk =
		initApi(baseJob, cryptoStrategies) { addInitialKeysToStorage(it) }

	/**
	 * Creates a new api with access to the original key of the user and his parents.
	 */
	suspend fun apiWithStorage(baseJob: Job, cryptoStrategies: CryptoStrategies = BasicCryptoStrategies, storageFacade: StorageFacade): CardinalSdk =
		initApi(baseJob, cryptoStrategies, storageFacade) { addInitialKeysToStorage(it) }

	/**
	 * Creates a new api with access to the provided keys.
	 * All the keys must be keys of the data owner and not of parents.
	 */
	suspend fun apiWithKeys(
		baseJob: Job,
		vararg keys: RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>,
		cryptoStrategies: CryptoStrategies = BasicCryptoStrategies
	): CardinalSdk =
		initApi(baseJob, cryptoStrategies) { storage ->
			keys.forEach { key ->
				storage.saveEncryptionKeypair(
					dataOwnerId,
					key,
					true
				)
			}
		}

	/**
	 * Creates an api simulating the loss of all keys for the user, prompting the creation of a new key.
	 * @return the api and the new key
	 */
	suspend fun apiWithLostKeys(
		baseJob: Job,
		cryptoStrategies: CryptoStrategies = BasicCryptoStrategies): Pair<CardinalSdk, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>> {
		val newKey = defaultCryptoService.rsa.generateKeyPair(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256)
		return Pair(
			initApi(
				baseJob,
				object : CryptoStrategies by cryptoStrategies {
					override suspend fun generateNewKeyForDataOwner(
						self: DataOwnerWithType,
						cryptoPrimitives: CryptoService,
					): CryptoStrategies.KeyGenerationRequestResult {
						val customResult = kotlin.runCatching {
							cryptoStrategies.generateNewKeyForDataOwner(self, cryptoPrimitives)
						}
						require(
							customResult.isSuccess
								&& customResult.getOrThrow() !is CryptoStrategies.KeyGenerationRequestResult.Use
						) {
							"`apiWithLostKeys` overrides the key generation strategy, so it should not provide a custom key or throw an exception."
						}
						return CryptoStrategies.KeyGenerationRequestResult.Use(newKey)
					}

				}
			) { storage ->
				storage.saveEncryptionKeypair(
					dataOwnerId,
					newKey,
					true
				)
			},
			newKey
		)
	}

	fun authService() =
		AuthenticationMethod.UsingCredentials(
			UsernamePassword(username, password),
		).getAuthProvider(
			RawAnonymousAuthApiImpl(baseUrl, DefaultRawApiConfig),
			defaultCryptoService,
			null,
			SdkOptions(saltPasswordWithApplicationId = false),
			messageGatewayApi = RawMessageGatewayApi(CardinalSdk.sharedHttpClient, defaultCryptoService),
			krakenUrl = baseUrl
		)


	@OptIn(InternalIcureApi::class)
	private suspend fun initApi(
		parentJob: Job,
		cryptoStrategies: CryptoStrategies,
		storageFacade: StorageFacade = VolatileStorageFacade(),
		fillStorage: suspend (storage: CardinalStorageFacade) -> Unit
	): CardinalSdk =
		CardinalSdk.initialize(
			null,
			baseUrl,
			AuthenticationMethod.UsingCredentials(UsernamePassword(username, password)),
			storageFacade.also {
				fillStorage(CardinalStorageFacade(
					JsonAndBase64KeyStorage(it),
					it,
					DefaultStorageEntryKeysFactory,
					defaultCryptoService,
					false
				))
			},
			SdkOptions(
				useHierarchicalDataOwners = true,
				cryptoStrategies = cryptoStrategies,
				parentJob = parentJob
			)
		)

	private suspend fun addInitialKeysToStorage(storage: CardinalStorageFacade) {
		keypair?.let {
			storage.saveEncryptionKeypair(
				dataOwnerId,
				it,
				true
			)
		}
		parent?.addInitialKeysToStorage(storage)
	}

	fun hierarchy(): List<String> = parent?.hierarchy().orEmpty() + dataOwnerId
}
