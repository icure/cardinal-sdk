package com.icure.cardinal.sdk.auth

import com.icure.cardinal.sdk.api.raw.RawAnonymousAuthApi
import com.icure.cardinal.sdk.api.raw.RawMessageGatewayApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull
import com.icure.cardinal.sdk.model.LoginCredentials
import com.icure.cardinal.sdk.model.embed.AuthenticationClass
import com.icure.cardinal.sdk.utils.InternalCardinalException
import com.icure.cardinal.sdk.utils.RequestStatusException
import com.icure.cardinal.sdk.utils.decodeClaims
import com.icure.cardinal.sdk.utils.ensure
import com.icure.cardinal.sdk.utils.ensureNonNull
import com.icure.cardinal.sdk.utils.isJwtExpiredOrInvalid
import com.icure.cardinal.sdk.utils.retryWithDelays
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

@InternalIcureApi
internal sealed interface DoGetTokenResult {

	data class Success(val bearer: JwtBearer, val refresh: JwtRefresh) : DoGetTokenResult

	enum class DoGetTokenResultFailureReason {
		Needs2FA,
		Invalid2FA,
		InvalidPwOrToken
	}

	data object InvalidAuthClass : DoGetTokenResult

	data class Failure(
		val reason: DoGetTokenResultFailureReason,
		val error: Throwable
	) : DoGetTokenResult

}

@OptIn(InternalIcureApi::class)
private class AuthProcessApiImpl(
	private val messageGatewayApi: RawMessageGatewayApi,
	private val krakenUrl: String,
) : AuthenticationProcessApi {
	override suspend fun executeProcess(
		messageGatewayUrl: String,
		externalServicesSpecId: String,
		processId: String,
		userTelecomType: AuthenticationProcessTelecomType,
		userTelecom: String,
		captcha: CaptchaOptions,
		processTemplateParameters: AuthenticationProcessTemplateParameters
	): AuthenticationProcessRequest {
		val requestId = messageGatewayApi.startProcess(
			messageGatewayUrl = messageGatewayUrl,
			externalServicesSpecId = externalServicesSpecId,
			processId = processId,
			userTelecomType = userTelecomType,
			userTelecom = userTelecom,
			captcha = captcha,
			firstName = processTemplateParameters.firstName,
			lastName = processTemplateParameters.lastName,
			krakenUrl = krakenUrl
		)
		return AuthenticationProcessRequest(
			messageGwUrl = messageGatewayUrl,
			specId = externalServicesSpecId,
			requestId = requestId
		)
	}
}

@InternalIcureApi
internal class SmartTokenProvider private constructor (
	private val messageGatewayApi: RawMessageGatewayApi,
	private val loginUsername: String?,
	private val groupId: String?,
	private val scopeDataOwnerId: String?,
	private val applicationId: String?,
	private var currentLongLivedSecret: AuthSecretDetails.Cacheable?,
	private var cachedToken: String?,
	private var cachedRefreshToken: String?,
	private val authApi: RawAnonymousAuthApi,
	private val authSecretProvider: AuthSecretProvider,
	private val cryptoService: CryptoService,
	private val cacheSecrets: Boolean,
	private val allowSecretRetry: Boolean,
	private val krakenUrl: String,
	private val refreshPadding: Duration = 30.seconds,
) {
	companion object {
		suspend operator fun invoke(
			messageGatewayApi: RawMessageGatewayApi,
			loginUsername: String?,
			groupId: String?,
			scopeDataOwnerId: String?,
			applicationId: String?,
			initializationSecret: AuthSecretDetails?,
			initialBearerToken: String?,
			initialRefreshToken: String?,
			authApi: RawAnonymousAuthApi,
			authSecretProvider: AuthSecretProvider,
			cryptoService: CryptoService,
			cacheSecrets: Boolean,
			allowSecretRetry: Boolean,
			krakenUrl: String,
			refreshPadding: Duration = 30.seconds,
		): SmartTokenProvider {
			val initialSecretCacheable = if (cacheSecrets) initializationSecret?.let { it as? AuthSecretDetails.Cacheable } else null
			val provider = SmartTokenProvider(
				messageGatewayApi = messageGatewayApi,
				loginUsername = loginUsername,
				groupId = groupId,
				scopeDataOwnerId = scopeDataOwnerId,
				applicationId = applicationId,
				currentLongLivedSecret = initialSecretCacheable,
				cachedToken = initialBearerToken,
				cachedRefreshToken = initialRefreshToken,
				authApi = authApi,
				authSecretProvider = authSecretProvider,
				cryptoService = cryptoService,
				cacheSecrets = cacheSecrets,
				allowSecretRetry = allowSecretRetry,
				krakenUrl = krakenUrl,
				refreshPadding = refreshPadding
			)
			if (initializationSecret != null && (initialRefreshToken == null || isJwtExpiredOrInvalid(initialRefreshToken))) {
				val token = provider.doGetTokenWithSecret(initializationSecret, null)
				if (token is DoGetTokenResult.Success) {
					provider.cachedToken = token.bearer.token
					provider.cachedRefreshToken = token.refresh.token
				} else {
					throw IllegalArgumentException("Could not get a token with the provided initial secret of type ${initializationSecret::class.simpleName}.")
				}
			}
			return provider
		}
	}

	enum class RetrievedTokenType { New, Cached, Refreshed }
	data class RetrievedJwt(val jwt: String, val type: RetrievedTokenType)

	private val tokenCacheMutex = Mutex()
	private val authProcessApi = AuthProcessApiImpl(messageGatewayApi, krakenUrl)

	suspend fun getCachedOrRefreshedOrNewToken(): RetrievedJwt = tokenCacheMutex.withLock {
		cachedToken?.takeIf { !isJwtExpiredOrInvalid(it, refreshPadding) }?.let { RetrievedJwt(it, RetrievedTokenType.Cached) }
			?: cachedRefreshToken?.takeIf { !isJwtExpiredOrInvalid(it, refreshPadding) }?.let { refreshAndCacheToken(it) }
			?: RetrievedJwt(getAndCacheNewTokens(null).bearer.token, RetrievedTokenType.New)
	}


	suspend fun getTokenForClass(minimumAuthenticationClass: AuthenticationClass): String = tokenCacheMutex.withLock {
		// By the time the lock is taken another coroutine may have refreshed the cached token and it could now be valid
		this.cachedToken?.takeIf { cachedToken ->
			kotlin.runCatching {
				decodeClaims(cachedToken).isValidForAuthClass(minimumAuthenticationClass, refreshPadding)
			}.getOrNull() == true
		} ?: getAndCacheNewTokens(minimumAuthenticationClass).bearer.token
	}

	suspend fun getCachedTokensOrLoad(): JwtBearerAndRefresh = tokenCacheMutex.withLock {
		val bearer = this.cachedToken
		val refresh = this.cachedRefreshToken
		return if (bearer != null && refresh != null) {
			JwtBearerAndRefresh(JwtBearer(bearer), JwtRefresh(refresh))
		} else getAndCacheNewTokens(null)
	}

	suspend fun switchedGroup(newGroupId: String): SmartTokenProvider {
		// Take the mutable cached data while holding the lock
		val (cachedRefreshToken, currentLongLivedSecret) = tokenCacheMutex.withLock {
			this.cachedRefreshToken to this.currentLongLivedSecret
		}
		val (switchedJwt, switchedRefresh) = cachedRefreshToken?.let { refreshJwt ->
			authApi.switchGroup(refreshJwt, newGroupId).successBodyOrNull()?.let { response ->
				ensure (response.token != null && response.refreshToken != null) {
					"Internal error: group switch succeeded but no token was returned. Unsupported backend version?"
				}
				response.token to response.refreshToken
			}
		} ?: (null to null)
		return SmartTokenProvider(
			messageGatewayApi = messageGatewayApi,
			loginUsername = loginUsername,
			groupId = newGroupId,
			applicationId = applicationId,
			currentLongLivedSecret = currentLongLivedSecret,
			cachedToken = switchedJwt,
			cachedRefreshToken = switchedRefresh,
			authApi = authApi,
			authSecretProvider = authSecretProvider,
			cryptoService = cryptoService,
			cacheSecrets = cacheSecrets,
			refreshPadding = refreshPadding,
			allowSecretRetry = allowSecretRetry,
			krakenUrl = krakenUrl,
			scopeDataOwnerId = null, // Reset scope on group switch
		)
	}

	suspend fun changeScope(dataOwnerId: String): SmartTokenProvider {
		// Take the mutable cached data while holding the lock
		val (cachedRefreshToken, currentLongLivedSecret) = tokenCacheMutex.withLock {
			this.cachedRefreshToken to this.currentLongLivedSecret
		}
		val (switchedJwt, switchedRefresh) = cachedRefreshToken?.let { refreshJwt ->
			authApi.scoped(refreshJwt, dataOwnerId).successBodyOrNull()?.let { response ->
				ensure (response.token != null && response.refreshToken != null) {
					"Internal error: scope change succeeded but no token was returned."
				}
				response.token to response.refreshToken
			}
		} ?: (null to null)
		return SmartTokenProvider(
			messageGatewayApi = messageGatewayApi,
			loginUsername = loginUsername,
			groupId = groupId,
			applicationId = applicationId,
			currentLongLivedSecret = currentLongLivedSecret,
			cachedToken = switchedJwt,
			cachedRefreshToken = switchedRefresh,
			authApi = authApi,
			authSecretProvider = authSecretProvider,
			cryptoService = cryptoService,
			cacheSecrets = cacheSecrets,
			refreshPadding = refreshPadding,
			allowSecretRetry = allowSecretRetry,
			krakenUrl = krakenUrl,
			scopeDataOwnerId = dataOwnerId,
		)
	}

	private suspend fun getAndCacheNewTokens(minimumAuthenticationClass: AuthenticationClass?): JwtBearerAndRefresh =
		getNewToken(minimumAuthenticationClass).also {
			cachedToken = it.bearer.token
			cachedRefreshToken = it.refresh.token
		}

	private suspend fun refreshAndCacheToken(refreshToken: String): RetrievedJwt =
		authApi.refresh(refreshToken).successBodyOrNull()?.let {
			if(it.token == null) {
				throw IllegalStateException("Internal error: refresh succeeded but no token was returned. Unsupported backend version?")
			}
			cachedToken = it.token
			RetrievedJwt(it.token, RetrievedTokenType.Refreshed)
		} ?: RetrievedJwt(getAndCacheNewTokens(null).bearer.token, RetrievedTokenType.New)

	private suspend fun getNewToken(
		minimumAuthenticationClass: AuthenticationClass?
	): JwtBearerAndRefresh = currentLongLivedSecret?.takeIf {
		minimumAuthenticationClass == null || it.type.level >= minimumAuthenticationClass.level
	}?.let { secret ->
		val result = doGetTokenWithSecret(secret, secret.type)
		if (!cacheSecrets) currentLongLivedSecret = null
		when {
			result is DoGetTokenResult.Success -> JwtBearerAndRefresh(result.bearer, result.refresh)
			result is DoGetTokenResult.Failure
				&& result.reason == DoGetTokenResult.DoGetTokenResultFailureReason.Needs2FA
				&& (minimumAuthenticationClass?.level ?: 0) <= AuthenticationClass.TwoFactorAuthentication.level -> askTotpAndGetToken(secret.secret, minimumAuthenticationClass)
			else -> askSecretAndGetToken(minimumAuthenticationClass, true)
		}
	} ?: askSecretAndGetToken(minimumAuthenticationClass, true)

	private tailrec suspend fun askSecretAndGetToken(
		minimumAuthenticationClass: AuthenticationClass?,
		passwordIsValidAs2fa: Boolean,
		previousAttempts: List<AuthSecretDetails> = emptyList()
	): JwtBearerAndRefresh {
		val minAuthClassLevel = minimumAuthenticationClass?.level ?: 0
		val acceptedSecrets = AuthenticationClass.entries.filter {
			when (it) {
				AuthenticationClass.TwoFactorAuthentication -> false
				AuthenticationClass.Password -> AuthenticationClass.TwoFactorAuthentication.level >= minAuthClassLevel && (passwordIsValidAs2fa || AuthenticationClass.Password.level >= minAuthClassLevel)
				else -> it.level >= minAuthClassLevel
			}
		}.also {
			ensure (it.isNotEmpty()) {
				"Internal error: no secret type is accepted for this request. Group may be misconfigured, or client may be outdated."
			}
		}.let { allAcceptedSecrets ->
			if (loginUsername != null) allAcceptedSecrets else allAcceptedSecrets.filterNot { it.requiresLoginUsername }
		}
		val secretDetails = authSecretProvider.getSecret(acceptedSecrets.toSet(), previousAttempts, authProcessApi)
		if(secretDetails.type !in acceptedSecrets) {
			throw IllegalArgumentException("Accepted secret types are ${acceptedSecrets.joinToString(", ")}, but got a secret of type ${secretDetails.type}.")
		}
		val result = doGetTokenWithSecret(secretDetails, minimumAuthenticationClass)
		return when {
			result is DoGetTokenResult.Success -> {
				if (cacheSecrets && secretDetails is AuthSecretDetails.Cacheable) {
					this.currentLongLivedSecret = secretDetails
				}
				JwtBearerAndRefresh(result.bearer, result.refresh)
			}
			result is DoGetTokenResult.Failure && result.reason == DoGetTokenResult.DoGetTokenResultFailureReason.Needs2FA -> askTotpAndGetToken(secretDetails.secret, minimumAuthenticationClass)
			secretDetails is AuthSecretDetails.PasswordDetails && passwordIsValidAs2fa && result == DoGetTokenResult.InvalidAuthClass -> askSecretAndGetToken(minimumAuthenticationClass, false)
			result is DoGetTokenResult.Failure -> if (allowSecretRetry) askSecretAndGetToken(minimumAuthenticationClass, passwordIsValidAs2fa, previousAttempts + secretDetails) else throw result.error
			else -> throw InternalCardinalException("Provided secret auth class did not match expected")
		}
	}

	private tailrec suspend fun askTotpAndGetToken(password: String, minimumAuthenticationClass: AuthenticationClass?, previousAttempts: List<AuthSecretDetails> = emptyList()): JwtBearerAndRefresh {
		ensure ((minimumAuthenticationClass?.level ?: 0) <= AuthenticationClass.TwoFactorAuthentication.level) {
			"Internal error: asking for totp to login but minimumAuthenticationClassLevel is higher than TWO_FACTOR_AUTHENTICATION's level."
		}
		val details = authSecretProvider.getSecret(setOf(AuthenticationClass.TwoFactorAuthentication), previousAttempts, authProcessApi)
		if (details !is AuthSecretDetails.TwoFactorAuthTokenDetails) {
			throw IllegalStateException("Was expecting a 2fa token but got a secret of type ${details::class.simpleName}.")
		}
		val result = doGetTokenWithSecret(AuthSecretDetails.TwoFactorAuthTokenDetails(secret = "${password}|${details.secret}"), minimumAuthenticationClass)
		return when {
			result is DoGetTokenResult.Success -> {
				if (cacheSecrets) {
					this.currentLongLivedSecret = AuthSecretDetails.PasswordDetails(password)
				}
				JwtBearerAndRefresh(result.bearer, result.refresh)
			}
			result is DoGetTokenResult.Failure && result.reason != DoGetTokenResult.DoGetTokenResultFailureReason.Invalid2FA -> {
				throw IllegalStateException("Unexpected error while trying to login with (previously) valid password and 2fa token ${result.reason}.")
			}
			else -> {
				askTotpAndGetToken(password, minimumAuthenticationClass, previousAttempts + details)
			}
		}
	}

	private val requireLoginUsername get() =
		ensureNonNull(loginUsername) {
			"Internal error: loginUsername is null but accepted authentication secret requires username to login."
		}

	private suspend fun doGetTokenWithSecret(
		secret: AuthSecretDetails,
		minimumAuthenticationClass: AuthenticationClass?,
	): DoGetTokenResult {
		val authResponse = when {
			secret is AuthSecretDetails.ConfiguredExternalAuthenticationDetails -> {
				authApi.loginWithExternalJwt(
					configId = secret.configId,
					token = secret.secret,
					groupId = groupId,
					applicationId = requireNotNull(applicationId) {
						"Authentication using ConfiguredExternalAuthenticationDetails requires an applicationId to be set in the SDK initialization."
					},
					minimumAuthenticationClass = secret.minimumAuthenticationClass.dtoSerialName,
					scopeDataOwner = scopeDataOwnerId,
				)
			}
			secret is AuthSecretDetails.ShortLivedTokenDetails -> {
				messageGatewayApi.completeProcess(
					messageGatewayUrl = secret.authenticationProcessInfo.messageGwUrl,
					externalServicesSpecId = secret.authenticationProcessInfo.specId,
					requestId = secret.authenticationProcessInfo.requestId,
					validationCode = secret.secret
				)
				retryWithDelays(
					listOf(100.milliseconds, 500.milliseconds, 1.seconds)
				) {
					authApi.login(
						loginCredentials = LoginCredentials(
							username = requireLoginUsername,
							password = secret.secret
						),
						groupId = groupId,
						applicationId = applicationId,
						scopeDataOwner = scopeDataOwnerId,
					)
				}
			}

			else ->
				authApi.login(
					loginCredentials = LoginCredentials(username = requireLoginUsername, password = secret.secret),
					groupId = groupId,
					applicationId = applicationId,
					scopeDataOwner = scopeDataOwnerId,
				)
		}
		return try {
			val authPayload = authResponse.successBody()
			ensure (authPayload.token != null && authPayload.refreshToken != null) {
				"Internal error: login succeeded but no token was returned. Unsupported backend version?"
			}
			val tokenAuthClass = ensureNonNull(
				kotlin.runCatching {
					decodeClaims(authPayload.token)
				}.getOrNull()?.tokenAuthenticationClass
			) { "Could not decode token authentication class from a newly created (not refreshed) token. Unsupported backend version?"}
			if (tokenAuthClass >= (minimumAuthenticationClass?.level ?: 0)) {
				DoGetTokenResult.Success(JwtBearer(authPayload.token), JwtRefresh(authPayload.refreshToken))
			} else {
				DoGetTokenResult.InvalidAuthClass
			}
		} catch (e: RequestStatusException) {
			when (e.statusCode) {
				// Password is wrong (401) or unacceptable (e.g. too short, 412)
				401, 412 -> DoGetTokenResult.Failure(DoGetTokenResult.DoGetTokenResultFailureReason.InvalidPwOrToken, e)

				// Password is correct, but 2fa token is not
				406 -> DoGetTokenResult.Failure(DoGetTokenResult.DoGetTokenResultFailureReason.Invalid2FA, e)

				// Password is correct, but the user has 2fa enabled and no 2fa token was provided
				417 -> DoGetTokenResult.Failure(DoGetTokenResult.DoGetTokenResultFailureReason.Needs2FA, e)

				else -> throw e
			}
		}
	}
}

