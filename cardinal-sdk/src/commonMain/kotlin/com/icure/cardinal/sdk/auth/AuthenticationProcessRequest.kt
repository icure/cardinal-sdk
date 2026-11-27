package com.icure.cardinal.sdk.auth

import com.icure.utils.InternalIcureApi

/**
 * Contains information about an authentication process request, result of the [AuthenticationProcessApi.executeProcess] method.
 * You are not supposed to initialize this class yourself or use its content directly.
 */
sealed class AuthenticationProcessRequest {
	/**
	 * A request started on the iCure message gateway, which is being retired.
	 */
	class MessageGateway @InternalIcureApi constructor(
		@InternalIcureApi
		val messageGwUrl: String,
		@InternalIcureApi
		val specId: String,
		@InternalIcureApi
		val requestId: String,
	) : AuthenticationProcessRequest()

	/**
	 * A request started on Khermes.
	 */
	class Khermes @InternalIcureApi constructor(
		@InternalIcureApi
		val khermesUrl: String,
		@InternalIcureApi
		val processId: String,
		@InternalIcureApi
		val requestId: String,
	) : AuthenticationProcessRequest()
}
