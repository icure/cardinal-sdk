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
import com.icure.cardinal.sdk.js.auth.CaptchaOptionsJs
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
import com.icure.cardinal.sdk.js.options.external.AuthenticationProcessTemplateParametersJs
import com.icure.cardinal.sdk.js.options.external.ConfiguredExternalAuthenticationDetailsJs
import com.icure.cardinal.sdk.js.options.external.ExternalAuthenticationTokenJs
import com.icure.cardinal.sdk.js.options.external.InitialSecretJs
import com.icure.cardinal.sdk.js.options.external.InitialSecretLongLivedTokenJs
import com.icure.cardinal.sdk.js.options.external.InitialSecretPasswordJs
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
			minimumAuthenticationClass = minimumAuthenticationClass?.let { AuthenticationClass.valueOf(it) } ?: AuthenticationClass.ExternalAuthentication
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
			configId = configId
		)
	is InitialSecretLongLivedTokenJs ->
		AuthenticationMethod.UsingSecretProvider.InitialSecret.LongLivedToken(token)
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
	is AuthSecretDetails.ConfiguredExternalAuthenticationDetails ->
		ConfiguredExternalAuthenticationDetailsJs(
			secret = secret,
			configId = configId,
			minimumAuthenticationClass = minimumAuthenticationClass.name
		)
	is AuthSecretDetails.LongLivedTokenDetails ->
		LongLivedTokenDetailsJs(secret = secret)
	is AuthSecretDetails.PasswordDetails ->
		PasswordDetailsJs(secret = secret)
	is AuthSecretDetails.ShortLivedTokenDetails ->
		ShortLivedTokenDetailsJs(secret = secret, authenticationProcessInfo = authenticationProcessInfo.toJs())
	is AuthSecretDetails.TwoFactorAuthTokenDetails ->
		TwoFactorAuthTokenDetailsJs(secret = secret)
}
@OptIn(InternalIcureApi::class)
private fun AuthenticationProcessRequest.toJs(): AuthenticationProcessRequestJs = AuthenticationProcessRequestJs(
	messageGwUrl = messageGwUrl,
	specId = specId,
	requestId = requestId,
)
@OptIn(InternalIcureApi::class)
private fun AuthenticationProcessRequestJs.toKt(): AuthenticationProcessRequest = AuthenticationProcessRequest(
	messageGwUrl = messageGwUrl,
	specId = specId,
	requestId = requestId,
)

private class AuthenticationProcessApiBridge(
	private val ktApi: AuthenticationProcessApi
) : AuthenticationProcessApiJs {
	override fun executeProcess(
		messageGatewayUrl: String,
		externalServicesSpecId: String,
		processId: String,
		userTelecomType: String,
		userTelecom: String,
		captchaOptions: CaptchaOptionsJs,
		processTemplateParameters: AuthenticationProcessTemplateParametersJs?
	): Promise<AuthenticationProcessRequestJs> = GlobalScope.promise {
		ktApi.executeProcess(
			messageGatewayUrl,
			externalServicesSpecId,
			processId,
			AuthenticationProcessTelecomType.valueOf(userTelecomType),
			userTelecom,
			captchaOptions_fromJs(captchaOptions),
			processTemplateParameters?.toKt() ?: AuthenticationProcessTemplateParameters()
		).toJs()
	}
}

internal fun AuthenticationProcessTemplateParametersJs.toKt() =
	AuthenticationProcessTemplateParameters(
		firstName = this.firstName,
		lastName = this.lastName
	)