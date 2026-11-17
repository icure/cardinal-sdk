package com.icure.cardinal.sdk.js.options

import com.icure.cardinal.sdk.auth.AuthSecretDetails
import com.icure.cardinal.sdk.auth.AuthSecretProvider
import com.icure.cardinal.sdk.auth.AuthenticationProcessApi
import com.icure.cardinal.sdk.auth.AuthenticationProcessRequest
import com.icure.cardinal.sdk.auth.AuthenticationProcessTelecomType
import com.icure.cardinal.sdk.auth.AuthenticationProcessTemplateParameters
import com.icure.cardinal.sdk.auth.ExternalAuthenticationToken
import com.icure.cardinal.sdk.auth.JwtBearer
import com.icure.cardinal.sdk.auth.JwtCredentials
import com.icure.cardinal.sdk.auth.JwtRefresh
import com.icure.cardinal.sdk.auth.UsernameLongToken
import com.icure.cardinal.sdk.auth.UsernamePassword
import com.icure.cardinal.sdk.js.model.CheckedConverters
import com.icure.cardinal.sdk.js.auth.captchaOptions_fromJs
import com.icure.cardinal.sdk.js.options.external.AuthSecretDetailsJs
import com.icure.cardinal.sdk.js.options.external.AuthSecretProviderJs
import com.icure.cardinal.sdk.js.options.external.AuthenticationMethodJs
import com.icure.cardinal.sdk.js.options.external.AuthenticationMethodUsingCredentialsExternalAuthenticationTokenJs
import com.icure.cardinal.sdk.js.options.external.AuthenticationMethodUsingCredentialsJwtCredentialsJs
import com.icure.cardinal.sdk.js.options.external.AuthenticationMethodUsingCredentialsUsernameLongTokenJs
import com.icure.cardinal.sdk.js.options.external.AuthenticationMethodUsingCredentialsUsernamePasswordJs
import com.icure.cardinal.sdk.js.options.external.AuthenticationMethodUsingSecretProviderJs
import com.icure.cardinal.sdk.js.options.external.AuthenticationProcessApiJs
import com.icure.cardinal.sdk.js.options.external.AuthenticationProcessRequestJs
import com.icure.cardinal.sdk.js.options.external.AuthenticationProcessRequestKhermesJs
import com.icure.cardinal.sdk.js.options.external.AuthenticationProcessRequestMessageGatewayJs
import com.icure.cardinal.sdk.js.options.external.AuthenticationProcessTemplateParametersJs
import com.icure.cardinal.sdk.js.options.external.ConfiguredExternalAuthenticationDetailsJs
import com.icure.cardinal.sdk.js.options.external.ExternalAuthenticationTokenJs
import com.icure.cardinal.sdk.js.options.external.InitialSecretJs
import com.icure.cardinal.sdk.js.options.external.InitialSecretLongLivedTokenJs
import com.icure.cardinal.sdk.js.options.external.InitialSecretPasswordJs
import com.icure.cardinal.sdk.js.options.external.InitialSecretRefreshTokenJs
import com.icure.cardinal.sdk.js.options.external.LongLivedTokenDetailsJs
import com.icure.cardinal.sdk.js.options.external.PasswordDetailsJs
import com.icure.cardinal.sdk.js.options.external.ShortLivedTokenDetailsJs
import com.icure.cardinal.sdk.js.options.external.TwoFactorAuthTokenDetailsJs
import com.icure.cardinal.sdk.model.embed.AuthenticationClass
import com.icure.cardinal.sdk.options.AuthenticationMethod
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.await
import kotlinx.coroutines.promise
import kotlin.js.Promise
import kotlin.js.json


@OptIn(InternalIcureApi::class)
internal fun AuthenticationMethodJs.toKt() = when (this) {
	is AuthenticationMethodUsingCredentialsUsernamePasswordJs ->
		AuthenticationMethod.UsingCredentials(UsernamePassword(
			username = username,
			password = password
		))
	is AuthenticationMethodUsingCredentialsUsernameLongTokenJs ->
		AuthenticationMethod.UsingCredentials(UsernameLongToken(
			username = username,
			token = token
		))
	is AuthenticationMethodUsingCredentialsExternalAuthenticationTokenJs ->
		AuthenticationMethod.UsingCredentials(ExternalAuthenticationToken(
			token = token,
			configId = configId,
			minimumAuthenticationClass = minimumAuthenticationClass?.let { AuthenticationClass.valueOf(it) } ?: AuthenticationClass.ExternalAuthentication,
			doNotUseProjectIdForGroupSelection = doNotUseProjectIdForGroupSelection ?: false,
		))
	is AuthenticationMethodUsingCredentialsJwtCredentialsJs ->
		AuthenticationMethod.UsingCredentials(JwtCredentials(
			refresh = JwtRefresh(refresh),
			initialBearer = bearer?.let { JwtBearer(it) }
		))
	is AuthenticationMethodUsingSecretProviderJs ->
		AuthenticationMethod.UsingSecretProvider(
			loginUsername = options?.loginUsername,
			initialSecret = options?.initialSecret?.toKt(),
			existingJwt = options?.existingJwt,
			existingRefreshJwt = options?.existingRefreshJwt,
			secretProvider = AuthSecretProviderBridge(secretProvider),
			cacheSecrets = options?.cacheSecrets ?: false,
		)
	else -> throw IllegalArgumentException("Unrecognised authentication method: ${this::class.simpleName}")
}

private fun InitialSecretJs.toKt(): AuthenticationMethod.UsingSecretProvider.InitialSecret = when (this) {
	is InitialSecretPasswordJs ->
		AuthenticationMethod.UsingSecretProvider.InitialSecret.Password(password)
	is ExternalAuthenticationTokenJs ->
		AuthenticationMethod.UsingSecretProvider.InitialSecret.ExternalAuthenticationToken(
			token = token,
			configId = configId,
			doNotUseProjectIdForGroupSelection = doNotUseProjectIdForGroupSelection
		)
	is InitialSecretLongLivedTokenJs ->
		AuthenticationMethod.UsingSecretProvider.InitialSecret.LongLivedToken(token)
	is InitialSecretRefreshTokenJs ->
		AuthenticationMethod.UsingSecretProvider.InitialSecret.RefreshToken(token)
	else -> throw IllegalArgumentException("Unrecognised initial secret: ${this::class.simpleName}")
}

private class AuthSecretProviderBridge(
	private val jsProvider: AuthSecretProviderJs
) : AuthSecretProvider {
	override suspend fun getSecret(
		acceptedSecrets: Set<AuthenticationClass>,
		previousAttempts: List<AuthSecretDetails>,
		authProcessApi: AuthenticationProcessApi
	): AuthSecretDetails =
		jsProvider.getSecret(
			acceptedSecrets.map { it.name }.toTypedArray(),
			previousAttempts.map { it.toJs() }.toTypedArray(),
			AuthenticationProcessApiBridge(authProcessApi)
		).await().toKt()
}

private fun AuthSecretDetailsJs.toKt(): AuthSecretDetails = when (this) {
	is ConfiguredExternalAuthenticationDetailsJs ->
		AuthSecretDetails.ConfiguredExternalAuthenticationDetails(
			configId = configId,
			secret = secret,
			minimumAuthenticationClass = minimumAuthenticationClass?.let { AuthenticationClass.valueOf(it) } ?: AuthenticationClass.ExternalAuthentication
		)
	is LongLivedTokenDetailsJs ->
		AuthSecretDetails.LongLivedTokenDetails(secret = secret)
	is PasswordDetailsJs ->
		AuthSecretDetails.PasswordDetails(secret = secret)
	is ShortLivedTokenDetailsJs ->
		AuthSecretDetails.ShortLivedTokenDetails(secret = secret, authenticationProcessInfo = authenticationProcessInfo.toKt())
	is TwoFactorAuthTokenDetailsJs ->
		AuthSecretDetails.TwoFactorAuthTokenDetails(secret = secret)
	else -> throw IllegalArgumentException("Unrecognised auth secret details: ${this::class.simpleName}")
}
private fun AuthSecretDetails.toJs(): AuthSecretDetailsJs = when (this) {
	is AuthSecretDetails.ConfiguredExternalAuthenticationDetails -> {
		ConfiguredExternalAuthenticationDetailsJs(
			secret = secret,
			configId = configId,
			props = json(
				"minimumAuthenticationClass" to minimumAuthenticationClass.name,
				"doNotUseProjectIdForGroupSelection" to doNotUseProjectIdForGroupSelection
			)
		)
	}
	is AuthSecretDetails.LongLivedTokenDetails -> {
		LongLivedTokenDetailsJs(secret = secret)
	}
	is AuthSecretDetails.PasswordDetails -> {
		PasswordDetailsJs(secret = secret)
	}
	is AuthSecretDetails.ShortLivedTokenDetails -> {
		ShortLivedTokenDetailsJs(secret = secret, authenticationProcessInfo = authenticationProcessInfo.toJs())
	}
	is AuthSecretDetails.TwoFactorAuthTokenDetails -> {
		TwoFactorAuthTokenDetailsJs(secret = secret)
	}
}
@OptIn(InternalIcureApi::class)
private fun AuthenticationProcessRequest.toJs(): AuthenticationProcessRequestJs = when (this) {
	is AuthenticationProcessRequest.MessageGateway -> AuthenticationProcessRequestMessageGatewayJs(
		messageGwUrl = messageGwUrl,
		specId = specId,
		requestId = requestId,
	)
	is AuthenticationProcessRequest.Khermes -> AuthenticationProcessRequestKhermesJs(
		khermesUrl = khermesUrl,
		processId = processId,
		requestId = requestId,
	)
}

/**
 * The request can be a plain object rather than an instance of one of the classes, for example if it was saved and
 * restored by the application: the variant is recognised by its properties.
 */
@OptIn(InternalIcureApi::class)
private fun AuthenticationProcessRequestJs.toKt(): AuthenticationProcessRequest {
	val request = this.asDynamic()
	return if (request.khermesUrl != null) {
		AuthenticationProcessRequest.Khermes(
			khermesUrl = request.khermesUrl as String,
			processId = request.processId as String,
			requestId = requestId,
		)
	} else {
		AuthenticationProcessRequest.MessageGateway(
			messageGwUrl = request.messageGwUrl as String,
			specId = request.specId as String,
			requestId = requestId,
		)
	}
}

/**
 * The TypeScript `executeProcess` has two signatures. Where the message gateway one has the telecom type (a string),
 * the Khermes one has the captcha (an object): the fourth argument tells them apart.
 */
private class AuthenticationProcessApiBridge(
	private val ktApi: AuthenticationProcessApi
) : AuthenticationProcessApiJs {
	override fun executeProcess(
		arg0: String,
		arg1: String,
		arg2: String,
		arg3: dynamic,
		arg4: dynamic,
		arg5: dynamic,
		arg6: dynamic,
	): Promise<AuthenticationProcessRequestJs> = GlobalScope.promise {
		if (jsTypeOf(arg3) == "string") {
			@Suppress("DEPRECATION")
			ktApi.executeProcess(
				messageGatewayUrl = arg0,
				externalServicesSpecId = arg1,
				processId = arg2,
				userTelecomType = AuthenticationProcessTelecomType.valueOf(arg3 as String),
				userTelecom = arg4 as String,
				captcha = captchaOptions_fromJs(arg5),
				processTemplateParameters = arg6.unsafeCast<AuthenticationProcessTemplateParametersJs?>()?.toKt()
					?: AuthenticationProcessTemplateParameters(),
			)
		} else {
			ktApi.executeProcess(
				khermesUrl = arg0,
				processId = arg1,
				userTelecom = arg2,
				captcha = captchaOptions_fromJs(arg3),
				variables = khermesVariablesFromJs(arg4),
				locale = arg5 as String?,
			)
		}.toJs()
	}
}

/**
 * The variables of a Khermes authentication process, from a JavaScript object whose values are strings.
 */
internal fun khermesVariablesFromJs(variables: dynamic): Map<String, String> =
	CheckedConverters.objectToMapNullsafe(
		variables,
		"variables",
		{ it },
		{ value ->
			require(jsTypeOf(value) == "string") { "The values of the variables must be strings" }
			value as String
		},
	) ?: emptyMap()

internal fun AuthenticationProcessTemplateParametersJs.toKt() =
	AuthenticationProcessTemplateParameters(
		firstName = this.firstName,
		lastName = this.lastName
	)
