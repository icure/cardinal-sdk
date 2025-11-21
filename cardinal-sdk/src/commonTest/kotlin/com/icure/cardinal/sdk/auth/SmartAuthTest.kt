package com.icure.cardinal.sdk.auth

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.api.raw.RawMessageGatewayApi
import com.icure.cardinal.sdk.api.raw.impl.RawAnonymousAuthApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawUserApiImpl
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.auth.services.SmartAuthProvider
import com.icure.cardinal.sdk.model.embed.AuthenticationClass
import com.icure.cardinal.sdk.model.security.AuthenticationToken
import com.icure.cardinal.sdk.model.security.Enable2faRequest
import com.icure.cardinal.sdk.options.AuthenticationMethod
import com.icure.cardinal.sdk.options.SdkOptions
import com.icure.cardinal.sdk.options.getAuthProvider
import com.icure.cardinal.sdk.test.DefaultRawApiConfig
import com.icure.cardinal.sdk.test.MockMessageGatewayUtils
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.baseUrl
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.createUserInMultipleGroups
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.mockMessageGatewayUrl
import com.icure.cardinal.sdk.test.mockSpecId
import com.icure.cardinal.sdk.test.shouldBeNextRevOf
import com.icure.cardinal.sdk.test.testGroupAdminAuth
import com.icure.cardinal.sdk.test.testGroupId
import com.icure.cardinal.sdk.test.uuid
import com.icure.cardinal.sdk.utils.RequestStatusException
import com.icure.kotp.ShaVersion
import com.icure.kotp.Totp
import com.icure.kryptom.crypto.HmacAlgorithm
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.utils.InternalIcureApi
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldHaveAtLeastSize
import io.kotest.matchers.collections.shouldNotContain
import io.kotest.matchers.maps.shouldNotBeEmpty
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.ktor.http.isSuccess
import kotlin.time.Clock

@OptIn(InternalIcureApi::class)
class SmartAuthTest : StringSpec({
	val specJob = autoCancelJob()

	val authApi = RawAnonymousAuthApiImpl(
		apiUrl = baseUrl,
		DefaultRawApiConfig
	)

	fun getUserApiWithProvider(authProvider: AuthProvider) = RawUserApiImpl(
		apiUrl = baseUrl,
		authProvider = authProvider,
		DefaultRawApiConfig
	)

	beforeSpec {
		initializeTestEnvironment()
	}

	"Should automatically ask for secret to get a new token, and asks again the secret if it is not valid" {
		val hcpDetails = createHcpUser()
		var calls = 0
		val authProvider = SmartAuthProvider.initialize(
			authApi = authApi,
			loginUsername = hcpDetails.username,
			secretProvider = object : AuthSecretProvider {
				override suspend fun getSecret(
					acceptedSecrets: Set<AuthenticationClass>,
					previousAttempts: List<AuthSecretDetails>,
					authProcessApi: AuthenticationProcessApi
				): AuthSecretDetails {
					acceptedSecrets shouldContain AuthenticationClass.Password
					acceptedSecrets shouldContain AuthenticationClass.LongLivedToken
					acceptedSecrets shouldContain AuthenticationClass.ShortLivedToken
					acceptedSecrets shouldNotContain AuthenticationClass.TwoFactorAuthentication
					return when(calls) {
						0 -> {
							previousAttempts.shouldBeEmpty()
							calls++
							AuthSecretDetails.LongLivedTokenDetails("wrong")
						}
						1 -> {
							previousAttempts.size shouldBe 1
							previousAttempts.first().secret shouldBe "wrong"
							previousAttempts.first().type shouldBe AuthenticationClass.LongLivedToken
							calls++
							AuthSecretDetails.LongLivedTokenDetails(hcpDetails.password)
						}
						else -> throw IllegalStateException("Invalid number of attempts: $calls")
					}
				}
			},
			initialSecret = null,
			initialAuthToken = null,
			initialRefreshToken = null,
			groupId = null,
			applicationId = null,
			cryptoService = defaultCryptoService,
			cacheSecrets = true,
			allowSecretRetry = true,
			messageGatewayApi = RawMessageGatewayApi(CardinalSdk.sharedHttpClient, defaultCryptoService),
			krakenUrl = baseUrl
		)

		val userApi = getUserApiWithProvider(authProvider)
		val user = userApi.getCurrentUser().successBody()
		user.healthcarePartyId shouldBe hcpDetails.dataOwnerId
		calls shouldBe 2
	}

	"Should automatically ask for a more powerful secret to perform elevated-security operations if the available secret/token is not good enough" {
		val hcpDetails = createHcpUser()
		val api = hcpDetails.api(specJob)
		val initialUser = api.user.getCurrentUser()
		val adminUserApi = RawUserApiImpl(baseUrl, testGroupAdminAuth(), DefaultRawApiConfig)
		val userToken = uuid()
		val userPwd = uuid()
		val userWithLongTokenAndPwd = adminUserApi.modifyUser(
			initialUser.copy(
				passwordHash = userPwd,
				authenticationTokens = mapOf(
					"test-long-lived-token" to AuthenticationToken(
						token = userToken,
						creationTime = Clock.System.now().toEpochMilliseconds(),
						validity = 60 * 60 * 24 * 7
					)
				)
			)
		).successBody()
		var calls = 0
		val authProvider = SmartAuthProvider.initialize(
			authApi = authApi,
			loginUsername = hcpDetails.username,
			secretProvider = object : AuthSecretProvider {
				override suspend fun getSecret(
					acceptedSecrets: Set<AuthenticationClass>,
					previousAttempts: List<AuthSecretDetails>,
					authProcessApi: AuthenticationProcessApi
				): AuthSecretDetails {
					return when(calls) {
						0 -> {
							acceptedSecrets shouldContain AuthenticationClass.Password
							acceptedSecrets shouldContain AuthenticationClass.LongLivedToken
							acceptedSecrets shouldContain AuthenticationClass.ShortLivedToken
							acceptedSecrets shouldNotContain AuthenticationClass.TwoFactorAuthentication
							previousAttempts.shouldBeEmpty()
							calls++
							AuthSecretDetails.LongLivedTokenDetails(userToken)
						}
						1 -> {
							acceptedSecrets shouldContain AuthenticationClass.Password
							acceptedSecrets shouldNotContain AuthenticationClass.LongLivedToken
							acceptedSecrets shouldContain AuthenticationClass.ShortLivedToken
							acceptedSecrets shouldNotContain AuthenticationClass.TwoFactorAuthentication
							previousAttempts.shouldBeEmpty()
							calls++
							AuthSecretDetails.PasswordDetails(userPwd)
						}
						else -> throw IllegalStateException("Invalid number of attempts: $calls")
					}
				}
			},
			initialSecret = null,
			initialAuthToken = null,
			initialRefreshToken = null,
			groupId = null,
			applicationId = null,
			cryptoService = defaultCryptoService,
			cacheSecrets = true,
			allowSecretRetry = true,
			messageGatewayApi = RawMessageGatewayApi(CardinalSdk.sharedHttpClient, defaultCryptoService),
			krakenUrl = baseUrl
		)

		val userApi = getUserApiWithProvider(authProvider)
		userApi.getCurrentUser().successBody().rev shouldBe userWithLongTokenAndPwd.rev
		calls shouldBe 1
		val newPwd = uuid()
		val userWithNewPwd = userApi.modifyUser(
			userWithLongTokenAndPwd.copy(
				passwordHash = newPwd,
			)
		).successBody()
		userWithNewPwd.rev shouldBeNextRevOf userWithLongTokenAndPwd.rev
		calls shouldBe 2
		val retrievedWithNewPwd = getUserApiWithProvider(
			AuthenticationMethod.UsingCredentials(UsernamePassword(hcpDetails.username, newPwd)).getAuthProvider(
				authApi,
				defaultCryptoService,
				null,
				SdkOptions(),
				RawMessageGatewayApi(CardinalSdk.sharedHttpClient, defaultCryptoService),
				krakenUrl = baseUrl
			)
		).getCurrentUser().successBody()
		retrievedWithNewPwd shouldBe userWithNewPwd
		shouldThrow<RequestStatusException> {
			getUserApiWithProvider(
				AuthenticationMethod.UsingCredentials(UsernamePassword(hcpDetails.username, userPwd)).getAuthProvider(
					authApi,
					defaultCryptoService,
					null,
					SdkOptions(),
					RawMessageGatewayApi(CardinalSdk.sharedHttpClient, defaultCryptoService),
					krakenUrl = baseUrl
				)
			).getCurrentUser()
		}.statusCode shouldBe 401
	}

	"Should automatically ask for TOTP after password if user has 2fa enabled" {
		val hcpDetails = createHcpUser()
		val api = hcpDetails.api(specJob)
		val otpLength = 8
		val initialUser = api.user.getCurrentUser()
		val adminUserApi = RawUserApiImpl(baseUrl, testGroupAdminAuth(), DefaultRawApiConfig)
		val totpSecret = Totp.generateTOTPSecret(32, HmacAlgorithm.HmacSha256)
		val totp = Totp(secret = totpSecret, shaVersion = ShaVersion.Sha256)
		val userPwd = uuid()
		adminUserApi.enable2faForUser(initialUser.id, Enable2faRequest(totpSecret, otpLength)).successBody()
		val userWithPwdAnd2fa = adminUserApi.modifyUser(
			initialUser.copy(
				passwordHash = userPwd,
			)
		).successBody()
		var calls = 0
		val authProvider = SmartAuthProvider.initialize(
			authApi = authApi,
			loginUsername = hcpDetails.username,
			secretProvider = object : AuthSecretProvider {
				override suspend fun getSecret(
					acceptedSecrets: Set<AuthenticationClass>,
					previousAttempts: List<AuthSecretDetails>,
					authProcessApi: AuthenticationProcessApi
				): AuthSecretDetails {
					return when(calls) {
						0 -> {
							acceptedSecrets shouldContain AuthenticationClass.Password
							acceptedSecrets shouldContain AuthenticationClass.LongLivedToken
							acceptedSecrets shouldContain AuthenticationClass.ShortLivedToken
							acceptedSecrets shouldNotContain AuthenticationClass.TwoFactorAuthentication
							previousAttempts.shouldBeEmpty()
							calls++
							AuthSecretDetails.PasswordDetails(userPwd)
						}
						1, 2 -> {
							acceptedSecrets shouldContain AuthenticationClass.TwoFactorAuthentication
							if(calls == 1) {
								previousAttempts.shouldBeEmpty()
								calls ++
								AuthSecretDetails.TwoFactorAuthTokenDetails(secret = "${totp.generate(digits = otpLength)}13")
							}
							else {
								previousAttempts.size shouldBe 1
								calls++
								AuthSecretDetails.TwoFactorAuthTokenDetails(secret = totp.generate(digits = otpLength))
							}
						}
						else -> throw IllegalStateException("Invalid number of attempts: $calls")
					}
				}
			},
			initialSecret = null,
			initialAuthToken = null,
			initialRefreshToken = null,
			groupId = null,
			applicationId = null,
			cryptoService = defaultCryptoService,
			cacheSecrets = true,
			allowSecretRetry = true,
			messageGatewayApi = RawMessageGatewayApi(CardinalSdk.sharedHttpClient, defaultCryptoService),
			krakenUrl = baseUrl
		)

		val userApi = getUserApiWithProvider(authProvider)
		userApi.getCurrentUser().successBody().rev shouldBe userWithPwdAnd2fa.rev
		calls shouldBe 3
	}

	"Should ask for TOTP directly if password is cached" {
		val hcpDetails = createHcpUser()
		val api = hcpDetails.api(specJob)
		val otpLength = 8
		val initialUser = api.user.getCurrentUser()
		val adminUserApi = RawUserApiImpl(baseUrl, testGroupAdminAuth(), DefaultRawApiConfig)
		val totpSecret = Totp.generateTOTPSecret(32, HmacAlgorithm.HmacSha256)
		val totp = Totp(secret = totpSecret, shaVersion = ShaVersion.Sha256)
		val userPwd = uuid()
		adminUserApi.enable2faForUser(initialUser.id, Enable2faRequest(totpSecret, otpLength))
		val userWithPwdAnd2fa = adminUserApi.modifyUser(
			initialUser.copy(
				passwordHash = userPwd,
			)
		).successBody()
		var calls = 0
		val authProvider = SmartAuthProvider.initialize(
			authApi = authApi,
			loginUsername = hcpDetails.username,
			secretProvider = object : AuthSecretProvider {
				override suspend fun getSecret(
					acceptedSecrets: Set<AuthenticationClass>,
					previousAttempts: List<AuthSecretDetails>,
					authProcessApi: AuthenticationProcessApi
				): AuthSecretDetails {
					acceptedSecrets shouldContain AuthenticationClass.TwoFactorAuthentication
					previousAttempts.shouldBeEmpty()
					calls++ shouldBe 0
					return AuthSecretDetails.TwoFactorAuthTokenDetails(secret = totp.generate(digits = 8))
				}
			},
			initialSecret = AuthSecretDetails.PasswordDetails(userPwd),
			initialAuthToken = null,
			initialRefreshToken = null,
			groupId = null,
			applicationId = null,
			cryptoService = defaultCryptoService,
			cacheSecrets = true,
			allowSecretRetry = true,
			messageGatewayApi = RawMessageGatewayApi(CardinalSdk.sharedHttpClient, defaultCryptoService),
			krakenUrl = baseUrl
		)

		val userApi = getUserApiWithProvider(authProvider)
		userApi.getCurrentUser().successBody().rev shouldBe userWithPwdAnd2fa.rev
		calls shouldBe 1
	}

	"Auth provider should allow to request and use short lived tokens" {
		val hcpDetails = createHcpUser()
		val processId = MockMessageGatewayUtils.createTestProcess(
			groupId = testGroupId,
			hcpId = hcpDetails.dataOwnerId,
			userType = MockMessageGatewayUtils.UserType.Hcp
		)
		var calls = 0
		val authProvider = SmartAuthProvider.initialize(
			authApi = authApi,
			loginUsername = hcpDetails.username,
			secretProvider = object : AuthSecretProvider {
				override suspend fun getSecret(
					acceptedSecrets: Set<AuthenticationClass>,
					previousAttempts: List<AuthSecretDetails>,
					authProcessApi: AuthenticationProcessApi
				): AuthSecretDetails {
					acceptedSecrets shouldContain AuthenticationClass.ShortLivedToken
					previousAttempts.shouldBeEmpty()
					calls++ shouldBe 0
					val processRequest = authProcessApi.executeProcess(
						mockMessageGatewayUrl,
						mockSpecId,
						processId,
						AuthenticationProcessTelecomType.Email,
						hcpDetails.testEmail,
						CaptchaOptions.Recaptcha("onmock")
					)
					return AuthSecretDetails.ShortLivedTokenDetails(
						secret = MockMessageGatewayUtils.getLatestEmailTo(hcpDetails.testEmail).subject,
						authenticationProcessInfo = processRequest
					)
				}
			},
			initialSecret = null,
			initialAuthToken = null,
			initialRefreshToken = null,
			groupId = null,
			applicationId = null,
			cryptoService = defaultCryptoService,
			cacheSecrets = true,
			allowSecretRetry = true,
			messageGatewayApi = RawMessageGatewayApi(CardinalSdk.sharedHttpClient, defaultCryptoService),
			krakenUrl = baseUrl
		)
		val userApi = getUserApiWithProvider(authProvider)
		userApi.getCurrentUser().response.status.isSuccess() shouldBe true
		calls shouldBe 1
	}

	"If auth secret provider gives invalid result the request should fail with IllegalArgumentException, but future requests should work again" {
		val hcpDetails = createHcpUser()
		val api = hcpDetails.api(specJob)
		val initialUser = api.user.getCurrentUser()
		val adminUserApi = RawUserApiImpl(baseUrl, testGroupAdminAuth(), DefaultRawApiConfig)
		val userToken = uuid()
		val userPwd = uuid()
		val userWithLongTokenAndPwd = adminUserApi.modifyUser(
			initialUser.copy(
				passwordHash = userPwd,
				authenticationTokens = mapOf(
					"test-long-lived-token" to AuthenticationToken(
						token = userToken,
						creationTime = Clock.System.now().toEpochMilliseconds(),
						validity = 60 * 60 * 24 * 7
					)
				)
			)
		).successBody()
		var calls = 0
		val authProvider = SmartAuthProvider.initialize(
			authApi = authApi,
			loginUsername = hcpDetails.username,
			secretProvider = object : AuthSecretProvider {
				override suspend fun getSecret(
					acceptedSecrets: Set<AuthenticationClass>,
					previousAttempts: List<AuthSecretDetails>,
					authProcessApi: AuthenticationProcessApi
				): AuthSecretDetails {
					return when(calls) {
						0 -> {
							acceptedSecrets shouldContain AuthenticationClass.Password
							acceptedSecrets shouldContain AuthenticationClass.LongLivedToken
							acceptedSecrets shouldContain AuthenticationClass.ShortLivedToken
							acceptedSecrets shouldNotContain AuthenticationClass.TwoFactorAuthentication
							previousAttempts.shouldBeEmpty()
							calls++
							AuthSecretDetails.LongLivedTokenDetails(userToken)
						}
						1 -> {
							acceptedSecrets shouldContain AuthenticationClass.Password
							acceptedSecrets shouldNotContain AuthenticationClass.LongLivedToken
							acceptedSecrets shouldContain AuthenticationClass.ShortLivedToken
							acceptedSecrets shouldNotContain AuthenticationClass.TwoFactorAuthentication
							previousAttempts.shouldBeEmpty()
							calls++
							AuthSecretDetails.LongLivedTokenDetails(userToken) // Invalid result
						}
						2 -> {
							acceptedSecrets shouldContain AuthenticationClass.Password
							acceptedSecrets shouldNotContain AuthenticationClass.LongLivedToken
							acceptedSecrets shouldContain AuthenticationClass.ShortLivedToken
							acceptedSecrets shouldNotContain AuthenticationClass.TwoFactorAuthentication
							previousAttempts.shouldBeEmpty()
							calls++
							AuthSecretDetails.PasswordDetails(userPwd)
						}
						else -> throw IllegalStateException("Invalid number of attempts: $calls")
					}
				}
			},
			initialSecret = null,
			initialAuthToken = null,
			initialRefreshToken = null,
			groupId = null,
			applicationId = null,
			cryptoService = defaultCryptoService,
			cacheSecrets = true,
			allowSecretRetry = true,
			messageGatewayApi = RawMessageGatewayApi(CardinalSdk.sharedHttpClient, defaultCryptoService),
			krakenUrl = baseUrl
		)

		val userApi = getUserApiWithProvider(authProvider)
		userApi.getCurrentUser().successBody().rev shouldBe userWithLongTokenAndPwd.rev
		calls shouldBe 1
		val newPwd = uuid()
		val userWithNewPwd = userWithLongTokenAndPwd.copy(
			passwordHash = newPwd,
		)
		shouldThrow<IllegalArgumentException> { userApi.modifyUser(userWithNewPwd) }
		calls shouldBe 2
		userApi.getCurrentUser().successBody().rev shouldBe userWithLongTokenAndPwd.rev
		calls shouldBe 2
		val updatedUser = userApi.modifyUser(userWithNewPwd).successBody()
		calls shouldBe 3
		updatedUser.rev shouldBeNextRevOf userWithLongTokenAndPwd.rev
		val retrievedWithNewPwd = getUserApiWithProvider(
			AuthenticationMethod.UsingCredentials(UsernamePassword(hcpDetails.username, newPwd)).getAuthProvider(
				authApi,
				defaultCryptoService,
				null,
				SdkOptions(),
				RawMessageGatewayApi(CardinalSdk.sharedHttpClient, defaultCryptoService),
				krakenUrl = baseUrl
			)
		).getCurrentUser().successBody()
		retrievedWithNewPwd shouldBe updatedUser
		shouldThrow<RequestStatusException> {
			getUserApiWithProvider(
				AuthenticationMethod.UsingCredentials(UsernamePassword(hcpDetails.username, userPwd)).getAuthProvider(
					authApi,
					defaultCryptoService,
					null,
					SdkOptions(),
					RawMessageGatewayApi(CardinalSdk.sharedHttpClient, defaultCryptoService),
					krakenUrl = baseUrl
				)
			).getCurrentUser()
		}.statusCode shouldBe 401
	}

	"Switched provider should keep cached secrets and should be able to have elevated security context" {
		val details = createUserInMultipleGroups()
		val firstUser = details.groupBy { it.password }.values.first { it.size > 1 }.first()
		val authProvider = SmartAuthProvider.initialize(
			authApi = authApi,
			loginUsername = firstUser.username,
			secretProvider = object : AuthSecretProvider {
				override suspend fun getSecret(
					acceptedSecrets: Set<AuthenticationClass>,
					previousAttempts: List<AuthSecretDetails>,
					authProcessApi: AuthenticationProcessApi
				): AuthSecretDetails {
					acceptedSecrets shouldContain AuthenticationClass.Password
					previousAttempts.shouldBeEmpty()
					return AuthSecretDetails.PasswordDetails(firstUser.password)
				}
			},
			initialSecret = null,
			initialAuthToken = null,
			initialRefreshToken = null,
			groupId = null,
			applicationId = null,
			cryptoService = defaultCryptoService,
			cacheSecrets = true,
			allowSecretRetry = true,
			messageGatewayApi = RawMessageGatewayApi(CardinalSdk.sharedHttpClient, defaultCryptoService),
			krakenUrl = baseUrl
		)
		val defaultGroupUserApi = getUserApiWithProvider(authProvider)
		val defaultGroupUser = defaultGroupUserApi.getCurrentUser().successBody()
		val matches = defaultGroupUserApi.getMatchingUsers().successBody()
		matches.shouldHaveAtLeastSize(2)
		val otherGroupId = matches.first { it.groupId != defaultGroupUser.groupId }.groupId!!
		val switchedUserApi = getUserApiWithProvider(authProvider.switchGroup(otherGroupId))
		val switchedUser = switchedUserApi.getCurrentUser().successBody()
		switchedUser.id shouldNotBe defaultGroupUser.id
		switchedUser.groupId shouldBe otherGroupId
		val updatedDefault = switchedUserApi.modifyUser(switchedUser.copy(
			authenticationTokens = mapOf(
				"test-long-lived-token" to AuthenticationToken(
					token = uuid(),
					creationTime = Clock.System.now().toEpochMilliseconds(),
					validity = 60 * 60 * 24 * 7
				)
			)
		)).successBody()
		updatedDefault.rev shouldBeNextRevOf switchedUser.rev
		updatedDefault.authenticationTokens.shouldNotBeEmpty()
	}
})
