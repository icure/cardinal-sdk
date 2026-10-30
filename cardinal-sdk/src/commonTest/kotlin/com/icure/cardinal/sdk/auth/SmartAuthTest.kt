package com.icure.cardinal.sdk.auth

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.api.impl.AuthApiImpl
import com.icure.cardinal.sdk.api.raw.RawMessageGatewayApi
import com.icure.cardinal.sdk.api.raw.impl.RawAnonymousAuthApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawUserApiImpl
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.auth.services.JwtBasedAuthProvider
import com.icure.cardinal.sdk.auth.services.SmartAuthProvider
import com.icure.cardinal.sdk.model.embed.AuthenticationClass
import com.icure.cardinal.sdk.model.security.AuthenticationToken
import com.icure.cardinal.sdk.model.LoginCredentials
import com.icure.cardinal.sdk.model.security.Enable2faRequest
import com.icure.cardinal.sdk.options.AuthenticationMethod
import com.icure.cardinal.sdk.options.SdkOptions
import com.icure.cardinal.sdk.options.getAuthProvider
import com.icure.cardinal.sdk.options.getGroupAndAuthProvider
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
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.cardinal.sdk.utils.LOCAL_ENV_ONLY
import com.icure.kotp.ShaVersion
import com.icure.kotp.Totp
import com.icure.kryptom.crypto.HmacAlgorithm
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.utils.InternalIcureApi
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldHaveAtLeastSize
import io.kotest.matchers.collections.shouldNotContain
import io.kotest.matchers.maps.shouldNotBeEmpty
import io.kotest.matchers.nulls.shouldNotBeNull
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

	fun secretProviderCountingCalls(onCall: () -> Unit) = object : AuthSecretProvider {
		override suspend fun getSecret(
			acceptedSecrets: Set<AuthenticationClass>,
			previousAttempts: List<AuthSecretDetails>,
			authProcessApi: AuthenticationProcessApi
		): AuthSecretDetails {
			onCall()
			throw IllegalStateException("Secret provider should not be invoked")
		}
	}

	beforeSpec {
		initializeTestEnvironment()
	}

	"Should automatically ask for secret to get a new token, and asks again the secret if it is not valid".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
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
			projectId = null,
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

	"Should automatically ask for a more powerful secret to perform elevated-security operations if the available secret/token is not good enough".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
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
			projectId = null,
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
		shouldThrow<IllegalArgumentException> {
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
		}.message shouldBe "Could not get a token with the provided initial secret of type ${AuthSecretDetails.PasswordDetails::class.simpleName}."
	}

	"Should automatically ask for TOTP after password if user has 2fa enabled".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val hcpDetails = createHcpUser()
		val api = hcpDetails.api(specJob)
		val otpLength = 8
		val initialUser = api.user.getCurrentUser()
		val adminUserApi = RawUserApiImpl(baseUrl, testGroupAdminAuth(), DefaultRawApiConfig)
		val totpSecret = Totp.generateTOTPSecret(32, HmacAlgorithm.HmacSha256)
		val totp = Totp(secret = totpSecret, shaVersion = ShaVersion.Sha256)
		val userPwd = uuid()
		val userWithPwd = adminUserApi.modifyUser(
			initialUser.copy(
				passwordHash = userPwd,
			)
		).successBody()
		adminUserApi.enable2faForUser(
			userId = initialUser.id,
			request = Enable2faRequest(
				secret = totpSecret,
				otpLength = otpLength,
				otp = totp.generate(digits = otpLength),
				algorithm = Enable2faRequest.Algorithm.Sha256
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
			projectId = null,
			cryptoService = defaultCryptoService,
			cacheSecrets = true,
			allowSecretRetry = true,
			messageGatewayApi = RawMessageGatewayApi(CardinalSdk.sharedHttpClient, defaultCryptoService),
			krakenUrl = baseUrl
		)

		val userApi = getUserApiWithProvider(authProvider)
		userApi.getCurrentUser().successBody().rev shouldBe userWithPwd.rev
		calls shouldBe 3
	}

	"Should ask for TOTP directly if password is cached".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val hcpDetails = createHcpUser()
		val api = hcpDetails.api(specJob)
		val otpLength = 8
		val initialUser = api.user.getCurrentUser()
		val adminUserApi = RawUserApiImpl(baseUrl, testGroupAdminAuth(), DefaultRawApiConfig)
		val totpSecret = Totp.generateTOTPSecret(32, HmacAlgorithm.HmacSha256)
		val totp = Totp(secret = totpSecret, shaVersion = ShaVersion.Sha256)
		val userPwd = uuid()
		val userWithPwd = adminUserApi.modifyUser(
			initialUser.copy(
				passwordHash = userPwd,
			)
		).successBody()
		adminUserApi.enable2faForUser(
			userId = initialUser.id,
			request = Enable2faRequest(
				secret = totpSecret,
				otpLength = otpLength,
				otp = totp.generate(digits = otpLength),
				algorithm = Enable2faRequest.Algorithm.Sha256
			)
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
			projectId = null,
			cryptoService = defaultCryptoService,
			cacheSecrets = true,
			allowSecretRetry = true,
			messageGatewayApi = RawMessageGatewayApi(CardinalSdk.sharedHttpClient, defaultCryptoService),
			krakenUrl = baseUrl
		)

		val userApi = getUserApiWithProvider(authProvider)
		userApi.getCurrentUser().successBody().rev shouldBe userWithPwd.rev
		calls shouldBe 1
	}

	"Auth provider should allow to request and use short lived tokens".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
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
			projectId = null,
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

	"If auth secret provider gives invalid result the request should fail with IllegalArgumentException, but future requests should work again".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
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
			projectId = null,
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
		shouldThrow<IllegalArgumentException> {
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
		}.message shouldBe "Could not get a token with the provided initial secret of type ${AuthSecretDetails.PasswordDetails::class.simpleName}."
	}

	"Switched provider should keep cached secrets and should be able to have elevated security context".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
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
			projectId = null,
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

	"Initializing with a valid refresh token should not invoke the secret provider".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val hcpDetails = createHcpUser()
		val refreshToken = authApi.login(
			loginCredentials = LoginCredentials(username = hcpDetails.username, password = hcpDetails.password)
		).successBody().refreshToken.shouldNotBeNull()
		var calls = 0
		val authProvider = AuthenticationMethod.UsingSecretProvider(
			loginUsername = hcpDetails.username,
			existingRefreshJwt = refreshToken,
			secretProvider = secretProviderCountingCalls { calls++ },
		).getAuthProvider(
			authApi,
			defaultCryptoService,
			null,
			SdkOptions(),
			RawMessageGatewayApi(CardinalSdk.sharedHttpClient, defaultCryptoService),
			krakenUrl = baseUrl
		)
		getUserApiWithProvider(authProvider).getCurrentUser().successBody().healthcarePartyId shouldBe hcpDetails.dataOwnerId
		calls shouldBe 0
	}

	"Sdk initialized with only a valid refresh token should not invoke the secret provider".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val hcpDetails = createHcpUser()
		val refreshToken = authApi.login(
			loginCredentials = LoginCredentials(username = hcpDetails.username, password = hcpDetails.password)
		).successBody().refreshToken.shouldNotBeNull()
		var calls = 0
		val sdk = hcpDetails.apiWithAuthenticationMethod(
			specJob,
			AuthenticationMethod.UsingSecretProvider(
				loginUsername = hcpDetails.username,
				existingRefreshJwt = refreshToken,
				secretProvider = secretProviderCountingCalls { calls++ },
			)
		)
		sdk.user.getCurrentUser().healthcarePartyId shouldBe hcpDetails.dataOwnerId
		sdk.healthcareParty.getCurrentHealthcareParty().id shouldBe hcpDetails.dataOwnerId
		calls shouldBe 0
	}

	"Refresh token obtained from an sdk can be used to initialize a new sdk without invoking the secret provider".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val hcpDetails = createHcpUser()
		val sdk = hcpDetails.api(specJob)
		val refreshToken = sdk.auth.getRefreshToken()
		var calls = 0
		val newSdk = hcpDetails.apiWithAuthenticationMethod(
			specJob,
			AuthenticationMethod.UsingSecretProvider(
				loginUsername = hcpDetails.username,
				existingRefreshJwt = refreshToken,
				secretProvider = secretProviderCountingCalls { calls++ },
			)
		)
		newSdk.user.getCurrentUser().healthcarePartyId shouldBe hcpDetails.dataOwnerId
		calls shouldBe 0
	}

	"Refresh token obtained after switching group should stay bound to the switched group, but sdk initialization still requires a group selector".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val details = createUserInMultipleGroups()
		val (firstGroupUser, secondGroupUser) = details.groupBy { it.password }.values.first { it.size > 1 }
		val (initialGroupId, initialProvider) = AuthenticationMethod.UsingSecretProvider(
			loginUsername = firstGroupUser.username,
			initialSecret = AuthenticationMethod.UsingSecretProvider.InitialSecret.Password(firstGroupUser.password),
			secretProvider = secretProviderCountingCalls { },
		).getGroupAndAuthProvider(
			baseUrl = baseUrl,
			apiUrl = baseUrl,
			cryptoService = defaultCryptoService,
			projectId = null,
			options = SdkOptions(groupSelector = { firstGroupUser.groupId }),
			rawApiConfig = DefaultRawApiConfig,
		)
		initialGroupId shouldBe firstGroupUser.groupId
		val switchedProvider = initialProvider.switchGroup(secondGroupUser.groupId) as JwtBasedAuthProvider
		getUserApiWithProvider(switchedProvider).getCurrentUser().successBody().groupId shouldBe secondGroupUser.groupId
		val switchedRefreshToken = AuthApiImpl(switchedProvider).getRefreshToken()
		var calls = 0
		fun authMethodWithSwitchedRefresh() = AuthenticationMethod.UsingSecretProvider(
			loginUsername = firstGroupUser.username,
			existingRefreshJwt = switchedRefreshToken,
			secretProvider = secretProviderCountingCalls { calls++ },
		)
		// The token obtained by refreshing is bound to the group of the refresh token
		getUserApiWithProvider(
			authMethodWithSwitchedRefresh().getAuthProvider(
				authApi,
				defaultCryptoService,
				null,
				SdkOptions(),
				RawMessageGatewayApi(CardinalSdk.sharedHttpClient, defaultCryptoService),
				krakenUrl = baseUrl
			)
		).getCurrentUser().successBody().groupId shouldBe secondGroupUser.groupId
		// But on initialization the sdk does not use the group of the refresh token: the user can still access multiple groups,
		// so a group selector is needed, and the group of the sdk is the one chosen by the selector.
		shouldThrow<IllegalArgumentException> {
			authMethodWithSwitchedRefresh().getGroupAndAuthProvider(
				baseUrl = baseUrl,
				apiUrl = baseUrl,
				cryptoService = defaultCryptoService,
				projectId = null,
				options = SdkOptions(),
				rawApiConfig = DefaultRawApiConfig,
			)
		}
		val (chosenGroupId, chosenProvider) = authMethodWithSwitchedRefresh().getGroupAndAuthProvider(
			baseUrl = baseUrl,
			apiUrl = baseUrl,
			cryptoService = defaultCryptoService,
			projectId = null,
			options = SdkOptions(groupSelector = { groups ->
				groups.map { it.groupId } shouldContainAll listOf(firstGroupUser.groupId, secondGroupUser.groupId)
				secondGroupUser.groupId
			}),
			rawApiConfig = DefaultRawApiConfig,
		)
		chosenGroupId shouldBe secondGroupUser.groupId
		getUserApiWithProvider(chosenProvider).getCurrentUser().successBody().groupId shouldBe secondGroupUser.groupId
		calls shouldBe 0
	}
})
