package com.icure.cardinal.sdk.test

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.options.RequestRetryConfiguration
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.utils.InternalIcureApi

@OptIn(InternalIcureApi::class)
val DefaultRawApiConfig = RawApiConfig(
	httpClient = CardinalSdk.sharedHttpClient,
	json = Serialization.json,
	additionalHeaders = emptyMap(),
	requestTimeout = null,
	retryConfiguration = RequestRetryConfiguration()
)
