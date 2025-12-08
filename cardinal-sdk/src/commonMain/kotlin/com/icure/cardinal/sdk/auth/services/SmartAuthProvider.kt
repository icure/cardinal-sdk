package com.icure.cardinal.sdk.auth.services

import com.icure.cardinal.sdk.api.raw.RawAnonymousAuthApi
import com.icure.cardinal.sdk.api.raw.RawMessageGatewayApi
import com.icure.cardinal.sdk.auth.AuthSecretDetails
import com.icure.cardinal.sdk.auth.AuthSecretProvider
import com.icure.cardinal.sdk.auth.JwtBearerAndRefresh
import com.icure.cardinal.sdk.auth.SmartTokenProvider
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal class SmartAuthProvider private constructor(
	private val smartTokenProvider: SmartTokenProvider,
	private val groupId: String? = null
) : JwtBasedAuthProvider {
	companion object {

		suspend fun initialize(
			authApi: RawAnonymousAuthApi,
			loginUsername: String?,
			secretProvider: AuthSecretProvider,
			initialSecret: AuthSecretDetails?,
			initialAuthToken: String?,
			initialRefreshToken: String?,
			groupId: String?,
			projectId: String?,
			cryptoService: CryptoService,
			cacheSecrets: Boolean,
			allowSecretRetry: Boolean,
			messageGatewayApi: RawMessageGatewayApi,
			krakenUrl: String,
		) = SmartAuthProvider(
			SmartTokenProvider(
				loginUsername = loginUsername,
				groupId = groupId,
				projectId = projectId,
				initializationSecret = initialSecret,
				initialBearerToken = initialAuthToken,
				initialRefreshToken = initialRefreshToken,
				authApi = authApi,
				authSecretProvider = secretProvider,
				cacheSecrets = cacheSecrets,
				cryptoService = cryptoService,
				allowSecretRetry = allowSecretRetry,
				messageGatewayApi = messageGatewayApi,
				krakenUrl = krakenUrl,
				scopeDataOwnerId = null,
			),
			groupId
		)

	}

	override fun getAuthService() = SmartAuthService(smartTokenProvider)

	override suspend fun switchGroup(newGroupId: String): AuthProvider = when {
		newGroupId == groupId -> this
		else -> SmartAuthProvider(
			smartTokenProvider = smartTokenProvider.switchedGroup(newGroupId),
			groupId = newGroupId,
		)
	}

	override suspend fun changeScope(dataOwnerId: String): AuthProvider = SmartAuthProvider(
		smartTokenProvider = smartTokenProvider.changeScope(dataOwnerId),
		groupId = groupId,
	)

	override suspend fun getBearerAndRefreshToken(): JwtBearerAndRefresh =
		smartTokenProvider.getCachedTokensOrLoad()
}
