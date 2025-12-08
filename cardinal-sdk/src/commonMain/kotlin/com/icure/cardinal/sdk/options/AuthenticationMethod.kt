package com.icure.cardinal.sdk.options

import com.icure.cardinal.sdk.api.raw.RawAnonymousAuthApi
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawMessageGatewayApi
import com.icure.cardinal.sdk.api.raw.impl.RawAnonymousAuthApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawUserApiImpl
import com.icure.cardinal.sdk.auth.AuthSecretDetails
import com.icure.cardinal.sdk.auth.AuthSecretProvider
import com.icure.cardinal.sdk.auth.AuthenticationProcessApi
import com.icure.cardinal.sdk.auth.Credentials
import com.icure.cardinal.sdk.auth.ExternalAuthenticationToken
import com.icure.cardinal.sdk.auth.JwtCredentials
import com.icure.cardinal.sdk.auth.UsernameLongToken
import com.icure.cardinal.sdk.auth.UsernamePassword
import com.icure.cardinal.sdk.auth.level
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.auth.services.JwtAuthProvider
import com.icure.cardinal.sdk.auth.services.SmartAuthProvider
import com.icure.cardinal.sdk.model.Group
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.embed.AuthenticationClass
import com.icure.cardinal.sdk.utils.ensureNonNull
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.Serializable

sealed interface AuthenticationMethod {
	/**
	 * The sdk will perform requests using jwt obtained from the provided credentials.
	 *
	 * When using this authentication method, the sdk will cache the credentials and will automatically request updated
	 * tokens as needed.
	 * However, if the provided credentials expire, the SDK will become unusable.
	 *
	 * This authentication method can also be used for the execution of requests that require an elevated security context
	 * as long as the credentials provided can be used to create a suitable token.
	 *
	 * Not that when using this authentication method the provided credentials will be cached (in volatile memory)
	 * without expiration.
	 */
	data class UsingCredentials(
		/**
		 * Credentials of the user.
		 */
		val credentials: Credentials
	) : AuthenticationMethod

	/**
	 * The sdk will perform requests using a specific authentication provider.
	 */
	@InternalIcureApi
	data class UsingAuthProvider(
		/**
		 * The authentication provider to use for the requests.
		 */
		val authProvider: AuthProvider
	) : AuthenticationMethod

	/**
	 * Allows the SDK to perform authentication using secrets obtained from an [AuthSecretProvider].
	  *
	 * The iCure SDK can authenticate to the backend using different kinds of secrets, such as passwords, long-lived authentication tokens, and
	 * short-lived authentication tokens generated through the message gateway.
	 * iCure associates to each kind of secret a certain security level, and for some sensitive operations, depending on the configurations of
	 * the user and his group, some operations may require a secret of a certain security level.
	 *
	 * For example, with the default configurations, to change his own email the user can't have logged in with a long-lived token, but he
	 * needs to provide his current password or a short-lived token.
	  *
	 * By using this authentication option, the iCure SDK will automatically request and cache the secret from the [AuthSecretProvider] only when
	 * needed, which should help to minimize the interaction with the user.
	  *
	 * Another advantage of using this authentication option over others is that in case all the cached tokens and secrets were to expire while
	 * performing a request, instead of having the request fail the SDK will ask for a new secret from the [SmartAuthProvider] and the request will
	 * automatically be retried with the new secret.
	 */
	data class UsingSecretProvider(
		/**
		 * A public identifier of the user logging in. This could be:
		 * - [User.id]
		 * - [Group.id]:[User.id]
		 * - [User.login]
		 * - [User.email]
		 * This value is optional because authentication using external methods (e.g. Google or digital ids) does not
		 * require explicitly providing the username. However, if not provided, the authentication will be locked to
		 * only use these external authentication methods.
		 */
		val loginUsername: String?,
		/**
		 * An initial secret for the login.
		 * If not null, the authentication provider will attempt to use it when needed before asking the secret
		 * provider.
		 */
		val initialSecret: InitialSecret? = null,
		/**
		 * If not null the authentication provider will use the jwt while valid.
		 */
		val existingJwt: String? = null,
		/**
		 * If not null the authentication provider will use the refresh jwt while valid.
		 */
		val existingRefreshJwt: String? = null,
		/**
		 * Secret provider to use for authentication. Will handle interaction with the GUI.
		 */
		val secretProvider: AuthSecretProvider,
		/**
		 * If set to true the secrets used by the authentication provider will be cached without expiration
		 * (in volatile memory).
		 * This minimizes the interaction with the end user, but may not be suitable for your security policy.
		 */
		val cacheSecrets: Boolean = false
	) : AuthenticationMethod {
		@Serializable
		sealed interface InitialSecret {
			@Serializable
			data class Password(val password: String) : InitialSecret
			@Serializable
			data class LongLivedToken(val token: String) : InitialSecret
			@Serializable
			data class ExternalAuthenticationToken(val token: String, val configId: String) : InitialSecret
		}
	}
}

// This does not have the internal modifier because we need it in other components like kmehr
@InternalIcureApi
suspend fun AuthenticationMethod.getAuthProvider(
	authApi: RawAnonymousAuthApi,
	cryptoService: CryptoService,
	applicationId: String?,
	options: CommonSdkOptions,
	messageGatewayApi: RawMessageGatewayApi,
	krakenUrl: String
): AuthProvider = when(this) {
	is AuthenticationMethod.UsingCredentials -> when (this.credentials) {
		is ExternalAuthenticationToken -> smartAuthWithConstantSecret(
			authApi = authApi,
			cryptoService = cryptoService,
			authSecretDetails = AuthSecretDetails.ConfiguredExternalAuthenticationDetails(this.credentials.configId, this.credentials.token),
			login = null,
			messageGatewayApi = messageGatewayApi,
			applicationId = applicationId,
			krakenUrl = krakenUrl
		)
		is UsernameLongToken -> smartAuthWithConstantSecret(
			authApi = authApi,
			cryptoService = cryptoService,
			authSecretDetails = AuthSecretDetails.LongLivedTokenDetails(this.credentials.token),
			login = this.credentials.username,
			messageGatewayApi = messageGatewayApi,
			applicationId = applicationId,
			krakenUrl = krakenUrl
		)
		is UsernamePassword -> smartAuthWithConstantSecret(
			authApi = authApi,
			cryptoService = cryptoService,
			authSecretDetails = AuthSecretDetails.PasswordDetails(this.credentials.password),
			login = this.credentials.username,
			messageGatewayApi = messageGatewayApi,
			applicationId = applicationId,
			krakenUrl = krakenUrl
		)
		is JwtCredentials -> JwtAuthProvider(authApi, this.credentials.initialBearer, this.credentials.refresh)
	}
	is AuthenticationMethod.UsingAuthProvider -> this.authProvider
	is AuthenticationMethod.UsingSecretProvider -> SmartAuthProvider.initialize(
		authApi = authApi,
		loginUsername = loginUsername,
		secretProvider = secretProvider,
		initialAuthToken = existingJwt,
		initialRefreshToken = existingRefreshJwt,
		initialSecret = when (initialSecret) {
			is AuthenticationMethod.UsingSecretProvider.InitialSecret.LongLivedToken ->
				AuthSecretDetails.LongLivedTokenDetails(initialSecret.token)
			is AuthenticationMethod.UsingSecretProvider.InitialSecret.ExternalAuthenticationToken ->
				AuthSecretDetails.ConfiguredExternalAuthenticationDetails(initialSecret.configId, initialSecret.token)
			is AuthenticationMethod.UsingSecretProvider.InitialSecret.Password ->
				AuthSecretDetails.PasswordDetails(initialSecret.password)
			null -> null
		},
		groupId = null,
		applicationId = applicationId,
		cryptoService = cryptoService,
		cacheSecrets = this.cacheSecrets,
		allowSecretRetry = true,
		messageGatewayApi = messageGatewayApi,
		krakenUrl = krakenUrl
	)
}

/**
 * Get an authentication provider, let the user pick a group if needed, then return the chosen group id and auth
 * provider bound to that group.
 */
@InternalIcureApi
internal suspend fun AuthenticationMethod.getGroupAndAuthProvider(
	baseUrl: String,
	apiUrl: String,
	cryptoService: CryptoService,
	applicationId: String?,
	options: BoundSdkOptions,
	rawApiConfig: RawApiConfig,
): Pair<String?, AuthProvider> {
	val rawAuthApi = RawAnonymousAuthApiImpl(apiUrl, rawApiConfig)
	val messageGatewayApi = RawMessageGatewayApi(rawApiConfig.httpClient, cryptoService)
	val authProvider = getAuthProvider(rawAuthApi, cryptoService, applicationId, options, messageGatewayApi, krakenUrl = baseUrl)
	val userApi = RawUserApiImpl(apiUrl, authProvider, rawApiConfig)
	// On local there is no groups, need to handle that possibility
	val matches = userApi.getMatchingUsers().takeIf { it.status.value != 404 }?.successBody()
	return if (matches != null) {
		val chosenGroupId = if (matches.size > 1) {
			requireNotNull(options.groupSelector) {
				"The provided credentials allow the user to login to multiple groups, but no group selector is provided"
			}.invoke(matches)
		} else {
			ensureNonNull(matches.first().groupId) { "Group id of single match is null" }
		}
		Pair(
			chosenGroupId,
			authProvider.switchGroup(chosenGroupId).changeScope(options.dataOwnerScope)
		)
	} else {
		Pair(null, authProvider.changeScope(options.dataOwnerScope))
	}
}

@InternalIcureApi
private suspend fun AuthProvider.changeScope(scope: String?) =
	if (scope != null) {
		this.changeScope(scope)
	} else {
		this
	}

@InternalIcureApi
private suspend fun smartAuthWithConstantSecret(
	authApi: RawAnonymousAuthApi,
	cryptoService: CryptoService,
	authSecretDetails: AuthSecretDetails,
	login: String?,
	messageGatewayApi: RawMessageGatewayApi,
	applicationId: String?,
	krakenUrl: String,
) = SmartAuthProvider.initialize(
	authApi = authApi,
	loginUsername = login,
	secretProvider = ConstantSecretProvider(authSecretDetails),
	initialAuthToken = null,
	initialRefreshToken = null,
	initialSecret = authSecretDetails,
	groupId = null,
	applicationId = applicationId,
	cryptoService = cryptoService,
	cacheSecrets = false,
	allowSecretRetry = false,
	messageGatewayApi = messageGatewayApi,
	krakenUrl = krakenUrl,
)

private class ConstantSecretProvider(
	private val authSecretDetails: AuthSecretDetails
) : AuthSecretProvider {
	override suspend fun getSecret(
		acceptedSecrets: Set<AuthenticationClass>,
		previousAttempts: List<AuthSecretDetails>,
		authProcessApi: AuthenticationProcessApi
	): AuthSecretDetails {
		if (authSecretDetails.type in acceptedSecrets) {
			if (previousAttempts.isEmpty())
				return authSecretDetails
			else
				throw IllegalStateException(
					if (acceptedSecrets.allowsMinClass)
						"The secret used to login is not valid anymore, and the current refresh tokens have expired. If you want to be able to use an instance of SDK for a period of time longer than the period of validity of a refresh token (24 hours), please initialize the SDK using AuthenticationMethod.UsingSecretProvider."
					else
						"Provided credentials can't be used to request new tokens. This method can't be used."
				)
		} else throw IllegalStateException("This method can't be used when logged in with a secret of type ${authSecretDetails.type}")
	}

	private val Set<AuthenticationClass>.allowsMinClass get() =
		contains(AuthenticationClass.entries.minBy { it.level })
}
