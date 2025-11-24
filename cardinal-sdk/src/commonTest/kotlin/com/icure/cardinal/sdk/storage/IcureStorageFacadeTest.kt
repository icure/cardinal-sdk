package com.icure.cardinal.sdk.storage

import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaService
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.cardinal.sdk.crypto.impl.exportSpkiHex
import com.icure.cardinal.sdk.storage.impl.DefaultStorageEntryKeysFactory
import com.icure.cardinal.sdk.storage.impl.JsonAndBase64KeyStorage
import com.icure.cardinal.sdk.storage.impl.VolatileStorageFacade
import com.icure.utils.InternalIcureApi
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.cardinal.sdk.utils.InternalCardinalException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.maps.shouldBeEmpty
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

@OptIn(InternalIcureApi::class)
class IcureStorageFacadeTest : StringSpec({
	lateinit var dataOwner: String
	lateinit var keyStorage: KeyStorageFacade
	lateinit var storage: CardinalStorageFacade

	beforeEach {
		dataOwner = defaultCryptoService.strongRandom.randomUUID()
		keyStorage = JsonAndBase64KeyStorage(VolatileStorageFacade())
		storage = CardinalStorageFacade(
			keyStorage,
			VolatileStorageFacade(),
			DefaultStorageEntryKeysFactory,
			defaultCryptoService,
			true
		)
	}

	"Should be capable of storing and retrieving encryption keys".config(enabled = DEFAULT_ENABLED) {
		suspend fun testWithIsDevice(isDevice: Boolean) {
			val keypair = defaultCryptoService.rsa.generateKeyPair(
				RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256,
				RsaService.KeySize.Rsa2048
			)
			val pubSpki = defaultCryptoService.rsa.exportSpkiHex(keypair.public)
			storage.loadEncryptionKeypair(
				dataOwner,
				pubSpki.fingerprintV1(),
				null,
				RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256
			).shouldBeNull()
			storage.saveEncryptionKeypair(
				dataOwner,
				keypair,
				isDevice
			)
			val loaded = storage.loadEncryptionKeypair(
				dataOwner,
				pubSpki.fingerprintV1(),
				null,
				RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256
			)
			loaded.shouldNotBeNull().also {
				it.isDevice shouldBe isDevice
				defaultCryptoService.rsa.exportSpkiHex(it.pair.public) shouldBe pubSpki
				val loadedPrivate = defaultCryptoService.rsa.exportPrivateKeyPkcs8(it.pair.private).toList()
				val savedPrivate = defaultCryptoService.rsa.exportPrivateKeyPkcs8(keypair.private).toList()
				loadedPrivate shouldBe savedPrivate
			}
		}
		testWithIsDevice(true)
		testWithIsDevice(false)
	}

	"Should be capable of updating and retrieving verification results".config(enabled = DEFAULT_ENABLED) {
		storage.loadSelfVerifiedKeys(dataOwner).shouldBeEmpty()
		val pub1Spki = defaultCryptoService.rsa.exportSpkiHex(
			defaultCryptoService.rsa.generateKeyPair(
				RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256,
				RsaService.KeySize.Rsa2048
			).public
		)
		val pub2Spki = defaultCryptoService.rsa.exportSpkiHex(
			defaultCryptoService.rsa.generateKeyPair(
				RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256,
				RsaService.KeySize.Rsa2048
			).public
		)
		val value1 = mapOf(pub1Spki.fingerprintV1() to true, pub2Spki.fingerprintV1() to false)
		storage.updateAndSaveSelfVerifiedKeys(dataOwner, value1) shouldBe value1
		val value2 = mapOf(pub1Spki.fingerprintV1() to true, pub2Spki.fingerprintV1() to true)
		storage.updateAndSaveSelfVerifiedKeys(dataOwner, mapOf(pub2Spki.fingerprintV1() to true)) shouldBe value2
		storage.loadSelfVerifiedKeys(dataOwner) shouldBe value2
	}

	"Should be capable of storing and retrieving signature keys".config(enabled = DEFAULT_ENABLED) {
		val keypair = defaultCryptoService.rsa.generateKeyPair(
			RsaAlgorithm.RsaSignatureAlgorithm.PssWithSha256,
			RsaService.KeySize.Rsa2048
		)
		val pubSpki = defaultCryptoService.rsa.exportSpkiHex(keypair.public)
		storage.loadSignatureKey(dataOwner).shouldBeNull()
		storage.loadSignatureVerificationKey(dataOwner, pubSpki.fingerprintV1()).shouldBeNull()
		storage.saveSignatureKeyPair(
			dataOwner,
			keypair
		)
		storage.loadEncryptionKeypair(
			dataOwner,
			pubSpki.fingerprintV1(),
			null,
			RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256
		).shouldBeNull() // We did not save an encryption key pair
		storage.loadSignatureKey(dataOwner).shouldNotBeNull().also {
			val loadedPrivate = defaultCryptoService.rsa.exportPrivateKeyPkcs8(it.private)
			val savedPrivate = defaultCryptoService.rsa.exportPrivateKeyPkcs8(keypair.private)
			loadedPrivate.toList() shouldBe savedPrivate.toList()
		}
		storage.loadSignatureVerificationKey(dataOwner, pubSpki.fingerprintV1()).shouldNotBeNull().also {
			defaultCryptoService.rsa.exportSpkiHex(it) shouldBe pubSpki
		}
	}

	"Should be capable of retrieving keys in legacy locations".config(enabled = DEFAULT_ENABLED) {
		val key1 = defaultCryptoService.rsa.generateKeyPair(
			RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1,
			RsaService.KeySize.Rsa2048
		)
		val key1Spki = defaultCryptoService.rsa.exportSpkiHex(key1.public)
		val key2 = defaultCryptoService.rsa.generateKeyPair(
			RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1,
			RsaService.KeySize.Rsa2048
		)
		val key2Spki = defaultCryptoService.rsa.exportSpkiHex(key2.public)
		storage.loadEncryptionKeypair(
			dataOwner,
			key1Spki.fingerprintV1(),
			null,
			RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1
		).shouldBeNull()
		storage.loadEncryptionKeypair(
			dataOwner,
			key1Spki.fingerprintV1(),
			key1Spki,
			RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1
		).shouldBeNull()
		keyStorage.storePrivateKey(
			"org.taktik.icure.rsa.${dataOwner}",
			defaultCryptoService.rsa.exportPrivateKeyPkcs8(key1.private)
		)
		// Searched key does not match legacy key spki
		storage.loadEncryptionKeypair(
			dataOwner,
			key2Spki.fingerprintV1(),
			key1Spki,
			RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1
		).shouldBeNull()
		storage.loadEncryptionKeypair(
			dataOwner,
			key1Spki.fingerprintV1(),
			null,
			RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1
		).shouldBeNull()
		// Legacy key must have appropriate algorithm
		shouldThrow<InternalCardinalException> {
			storage.loadEncryptionKeypair(
				dataOwner,
				key1Spki.fingerprintV1(),
				key1Spki,
				RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256
			)
		}
		// Valid
		storage.loadEncryptionKeypair(
			dataOwner,
			key1Spki.fingerprintV1(),
			key1Spki,
			RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1
		).shouldNotBeNull().also {
			it.isDevice shouldBe true // Keys found in legacy location must be device keys (if they were recovered they would be saved elsewhere)
			defaultCryptoService.rsa.exportSpkiHex(it.pair.public) shouldBe key1Spki
		}
		// Now test with public keys in aes exchange keys
		keyStorage.storePrivateKey(
			"org.taktik.icure.rsa.${dataOwner}.${key2Spki.fingerprintV1()}",
			defaultCryptoService.rsa.exportPrivateKeyPkcs8(key2.private)
		)
		// Also requires valid algorithm
		shouldThrow<InternalCardinalException> {
			storage.loadEncryptionKeypair(
				dataOwner,
				key2Spki.fingerprintV1(),
				key1Spki,
				RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256
			)
		}
		// Valid
		storage.loadEncryptionKeypair(
			dataOwner,
			key2Spki.fingerprintV1(),
			key1Spki,
			RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1
		).shouldNotBeNull().also {
			it.isDevice shouldBe true // Keys found in legacy location must be device keys (if they were recovered they would be saved elsewhere)
			defaultCryptoService.rsa.exportSpkiHex(it.pair.public) shouldBe key2Spki
		}
		// Legacy key lookup may be disabled
		storage = CardinalStorageFacade(
			keyStorage,
			VolatileStorageFacade(),
			DefaultStorageEntryKeysFactory,
			defaultCryptoService,
			false
		)
		storage.loadEncryptionKeypair(
			dataOwner,
			key1Spki.fingerprintV1(),
			key1Spki,
			RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1
		).shouldBeNull()
		storage.loadEncryptionKeypair(
			dataOwner,
			key2Spki.fingerprintV1(),
			key1Spki,
			RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1
		).shouldBeNull()
	}
})