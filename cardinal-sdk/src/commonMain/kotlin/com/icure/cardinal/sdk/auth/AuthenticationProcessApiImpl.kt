package com.icure.cardinal.sdk.auth

import com.icure.cardinal.sdk.api.raw.RawKhermesApi
import com.icure.cardinal.sdk.api.raw.RawMessageGatewayApi
import com.icure.cardinal.sdk.options.CommonSdkOptions
import com.icure.cardinal.sdk.options.configuredClientOrDefault
import com.icure.cardinal.sdk.utils.RequestStatusException
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import io.ktor.client.HttpClient

/**
 * Starts and completes authentication processes on the service that runs them: the iCure message gateway or Khermes.
 * The [AuthenticationProcessRequest] returned by [executeProcess] says which one, and [completeProcess] validates the
 * code on that same service.
 *
 * One instance is created when an SDK is initialized, and shared by everything that SDK does with processes.
 *
 * @param client the client the requests to both services are sent with.
 * @param krakenUrl the backend the message gateway creates its tokens on. Khermes has its own.
 */
@InternalIcureApi
class AuthenticationProcessApiImpl(
	client: HttpClient,
	cryptoService: CryptoService,
	private val krakenUrl: String,
) : AuthenticationProcessApi {
	/**
	 * The authentication process api of an SDK initialized with [options] on the backend [krakenUrl].
	 */
	constructor(options: CommonSdkOptions, krakenUrl: String) : this(
		client = options.configuredClientOrDefault(),
		cryptoService = options.cryptoService,
		krakenUrl = krakenUrl,
	)

	private val messageGatewayApi = RawMessageGatewayApi(client, cryptoService)
	private val khermesApi = RawKhermesApi(client, cryptoService)

	@Deprecated(MESSAGE_GATEWAY_DEPRECATION)
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
		return AuthenticationProcessRequest.MessageGateway(
			messageGwUrl = messageGatewayUrl,
			specId = externalServicesSpecId,
			requestId = requestId
		)
	}

	override suspend fun executeProcess(
		khermesUrl: String,
		processId: String,
		userTelecom: String,
		captcha: CaptchaOptions,
		variables: Map<String, String>,
		locale: String?,
	): AuthenticationProcessRequest = khermesApi.startProcess(
		khermesUrl = khermesUrl,
		processId = processId,
		userTelecom = userTelecom,
		captcha = captcha,
		variables = variables,
		locale = locale,
	)

	/**
	 * Validates [validationCode] for [request], on the service that started it.
	 *
	 * @return the token the process created, to log the user in with.
	 * @throws RequestStatusException if the service refuses the code; see [isRefusedCode].
	 */
	suspend fun completeProcess(request: AuthenticationProcessRequest, validationCode: String): String = when (request) {
		is AuthenticationProcessRequest.MessageGateway -> {
			messageGatewayApi.completeProcess(
				messageGatewayUrl = request.messageGwUrl,
				externalServicesSpecId = request.specId,
				requestId = request.requestId,
				validationCode = validationCode
			)
			validationCode
		}
		is AuthenticationProcessRequest.Khermes -> khermesApi.completeProcess(request, validationCode)
	}

	companion object {
		/**
		 * The statuses with which Khermes refuses a validation code itself: wrong (401), already used (409) or expired
		 * (410). Another code can be asked for. The message gateway's refusals are not told apart.
		 */
		private val KHERMES_REFUSED_CODE_STATUSES = setOf(401, 409, 410)

		/** True if [error], thrown by [completeProcess] for [request], means the code itself was refused. */
		fun isRefusedCode(request: AuthenticationProcessRequest, error: RequestStatusException): Boolean =
			request is AuthenticationProcessRequest.Khermes && error.statusCode in KHERMES_REFUSED_CODE_STATUSES
	}
}
