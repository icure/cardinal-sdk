package com.icure.cardinal.sdk.test

import com.icure.cardinal.sdk.api.raw.RawHealthcarePartyApi
import com.icure.cardinal.sdk.api.raw.impl.RawHealthcarePartyApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawUserApiImpl
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.storage.StorageFacade
import com.icure.cardinal.sdk.storage.impl.FileStorageFacade
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.kryptom.utils.hexToByteArray
import com.icure.kryptom.utils.toHexString
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

/**
 * Handling of the healthcare party users of a non-local test environment.
 *
 * There the tests are not allowed to create data owners, so they work with the users configured through
 * `TEST_USER_<n>_ID` / `TEST_USER_<n>_PWD` instead. Their keys are kept in [testKeyDirectory], so that
 * a run reuses the keys of the previous ones instead of registering a new one every time.
 */

private val mutex = Mutex()
private val resolvedUsers = mutableMapOf<String, DataOwnerDetails>()
private var nextUserIndex = 0

/**
 * The details of the next pre-configured healthcare party user, cycling through the configured users:
 * two consecutive calls always return two distinct data owners.
 *
 * A test that needs more than [preConfiguredHcpUsers] distinct data owners can't run against a
 * non-local environment and must be disabled with `LOCAL_ENV_ONLY`.
 */
suspend fun nextPreConfiguredHcpUser(): DataOwnerDetails = mutex.withLock {
	check(preConfiguredHcpUsers.isNotEmpty()) {
		"No test user is configured: TEST_USER_1_ID and TEST_USER_1_PWD are needed to run the tests " +
			"against a non-local environment"
	}
	val credentials = preConfiguredHcpUsers[nextUserIndex % preConfiguredHcpUsers.size]
	nextUserIndex += 1
	resolvedUsers.getOrPut(credentials.username) { resolveHcpUser(credentials) }
}

/**
 * Loads the details of a pre-configured user: the tests need its data owner id and its key, but only
 * its credentials are configured, so both are retrieved from the environment.
 */
@OptIn(InternalIcureApi::class)
private suspend fun resolveHcpUser(credentials: UserCredentials): DataOwnerDetails {
	val auth = userAuth(credentials.username, credentials.password)
	val user = RawUserApiImpl(baseUrl, auth, DefaultRawApiConfig).getCurrentUser().successBody()
	val hcpId = requireNotNull(user.healthcarePartyId) {
		"The test user ${credentials.username} is not a healthcare party"
	}
	println("Using the pre-configured test user ${credentials.username} (hcp $hcpId)")
	return DataOwnerDetails(
		dataOwnerId = hcpId,
		username = credentials.username,
		password = credentials.password,
		keypair = loadOrRegisterKeypair(RawHealthcarePartyApiImpl(baseUrl, auth, DefaultRawApiConfig), hcpId),
		parents = emptyList(),
		groupId = user.groupId ?: testGroupId,
	)
}

/**
 * The key of the user, from [testKeyDirectory]. If the directory holds no key for the user, or if the
 * environment doesn't know the stored key anymore, a new key is generated and registered on the
 * healthcare party: this is the only modification the tests ever do to a pre-configured user, and it
 * only happens the first time they run with a certain key directory.
 */
@OptIn(InternalIcureApi::class)
private suspend fun loadOrRegisterKeypair(
	hcpApi: RawHealthcarePartyApi,
	hcpId: String,
): RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm> {
	val storage = keyStorage()
	val storageKey = "cardinal-test-key.$hcpId"
	val hcp = hcpApi.getHealthcareParty(hcpId).successBody()
	val storedKeypair = storage.getItem(storageKey)?.let {
		defaultCryptoService.rsa.loadKeyPairPkcs8(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256, hexToByteArray(it))
	}
	if (storedKeypair != null && storedKeypair.publicKeySpki() in hcp.publicKeysForOaepWithSha256) {
		return storedKeypair
	}
	val keypair = storedKeypair
		?: defaultCryptoService.rsa.generateKeyPair(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256)
	println("Registering a new public key for the test hcp $hcpId")
	hcpApi.modifyHealthcareParty(
		hcp.copy(publicKeysForOaepWithSha256 = hcp.publicKeysForOaepWithSha256 + keypair.publicKeySpki())
	).successBody()
	storage.setItem(storageKey, defaultCryptoService.rsa.exportPrivateKeyPkcs8(keypair.private).toHexString())
	return keypair
}

private suspend fun keyStorage(): StorageFacade =
	FileStorageFacade(
		checkNotNull(testKeyDirectory) {
			"KEY_DIRECTORY is needed to store the keys of the pre-configured test users"
		}
	)

private suspend fun RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>.publicKeySpki(): SpkiHexString =
	SpkiHexString(defaultCryptoService.rsa.exportPublicKeySpki(public).toHexString())
