package com.icure.cardinal.sdk.test

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.api.raw.RawMessageGatewayApi
import com.icure.cardinal.sdk.api.raw.impl.RawAnonymousAuthApiImpl
import com.icure.cardinal.sdk.auth.UsernamePassword
import com.icure.cardinal.sdk.options.AuthenticationMethod
import com.icure.cardinal.sdk.options.SdkOptions
import com.icure.cardinal.sdk.options.getAuthProvider
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.utils.InternalIcureApi

val baseUrl = "http://localhost:16044"
val mockMessageGatewayUrl = "http://127.0.0.1:8081/msggtw"
val mockSpecId = "ic"
val testGroupName = "testgroup"
val testGroupId = testGroupName + "-" + defaultCryptoService.strongRandom.randomUUID()
val testGroupAdmin = "admin-{${uuid()}}@icure.com"
val testGroupAdminPassword = "admin-${uuid()}"

@OptIn(InternalIcureApi::class)
internal val testGroupAdminAuth =
	AuthenticationMethod.UsingCredentials(
		UsernamePassword(testGroupAdmin, testGroupAdminPassword)
	).getAuthProvider(
		RawAnonymousAuthApiImpl(baseUrl, DefaultRawApiConfig),
		defaultCryptoService,
		null,
		SdkOptions(saltPasswordWithApplicationId = false),
		messageGatewayApi = RawMessageGatewayApi(CardinalSdk.sharedHttpClient, defaultCryptoService),
		krakenUrl = baseUrl
	)

@OptIn(InternalIcureApi::class)
internal val superadminAuth =
	AuthenticationMethod.UsingCredentials(
		UsernamePassword("john", "LetMeIn"),
	).getAuthProvider(
		RawAnonymousAuthApiImpl(baseUrl, DefaultRawApiConfig),
		defaultCryptoService,
		null,
		SdkOptions(saltPasswordWithApplicationId = false),
		messageGatewayApi = RawMessageGatewayApi(CardinalSdk.sharedHttpClient, defaultCryptoService),
		krakenUrl = baseUrl
	)
