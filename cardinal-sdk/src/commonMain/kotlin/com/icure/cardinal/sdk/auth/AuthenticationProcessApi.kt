package com.icure.cardinal.sdk.auth

/**
 * Allows initializing processes for the registration and authentication of users.
 */
interface AuthenticationProcessApi {
	/**
	 * Executes an authentication process on the iCure message gateway.
	 * @param messageGatewayUrl the url of the iCure message gateway you want to use. Usually this should be
	 * @param externalServicesSpecId an identifier that allows the message gateway to connect the request to your
	 * services for email / sms communication of the process tokens.
	 * @param processId the id of the process you want to execute.
	 * @param userTelecomType the type of telecom number used for the user.
	 * @param userTelecom the telecom number of the user for which you want to execute the process. This should be an
	 * email address or phone number depending on the type of process you are executing.
	 * @param captcha Captcha options for authentication. This is used to prevent abuse of the message gateway and
	 * connected external services.
	 * @param processTemplateParameters additional parameters needed by some process templates.
	 */
	@Deprecated(MESSAGE_GATEWAY_DEPRECATION)
	suspend fun executeProcess(
		messageGatewayUrl: String,
		externalServicesSpecId: String,
		processId: String,
		userTelecomType: AuthenticationProcessTelecomType,
		userTelecom: String,
		captcha: CaptchaOptions,
		processTemplateParameters: AuthenticationProcessTemplateParameters = AuthenticationProcessTemplateParameters()
	): AuthenticationProcessRequest

	/**
	 * Executes a Khermes authentication process: Khermes sends a validation code to [userTelecom], through the channel
	 * (email or SMS) of the process.
	 * @param khermesUrl the url of Khermes, `https://khermes.icure.cloud` in production. Its process must create tokens
	 * on the backend the SDK uses.
	 * @param processId the id of the Khermes authentication process to execute.
	 * @param userTelecom the email address (email process) or E.164 phone number such as `+32470123456` (SMS process)
	 * of the user.
	 * @param captcha the captcha. Khermes only supports [CaptchaOptions.Kerberus] for now: any other option throws an
	 * [IllegalArgumentException]. With [CaptchaOptions.Kerberus.Delegated], give the secret key of the Kerberus provider
	 * of the process's Spec.
	 * @param variables the values of the variables that the process's templates declare. Khermes refuses any variable
	 * they don't declare.
	 * @param locale the locale of the email or SMS template, or null for the default locale of the process.
	 */
	suspend fun executeProcess(
		khermesUrl: String,
		processId: String,
		userTelecom: String,
		captcha: CaptchaOptions,
		variables: Map<String, String> = emptyMap(),
		locale: String? = null,
	): AuthenticationProcessRequest
}

internal const val MESSAGE_GATEWAY_DEPRECATION =
	"The iCure message gateway is being retired: use a Khermes authentication process, through the overload that takes a khermesUrl."
