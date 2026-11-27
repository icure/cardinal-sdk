package com.icure.cardinal.sdk.auth

import com.icure.cardinal.sdk.api.raw.RawKhermesApi
import com.icure.cardinal.sdk.options.BasicSdkOptions
import com.icure.cardinal.sdk.options.CommonSdkOptions
import com.icure.cardinal.sdk.options.configuredClientOrDefault
import com.icure.kerberus.Solution
import com.icure.utils.InternalIcureApi

/**
 * Kerberus captcha helpers for Khermes authentication processes.
 */
object KhermesCaptcha {
	/**
	 * Gets a Kerberus challenge from Khermes and solves it, for a later authentication of [userTelecom] through the
	 * process [processId] with [CaptchaOptions.Kerberus.Computed]. Solving can take a few seconds: start it while the
	 * user is still filling in their information.
	 *
	 * Khermes binds the challenge to [userTelecom] when it issues it, and checks its rate limits for that user telecom
	 * then. So the solving can start only once the user telecom is known: when the user has finished entering it, for
	 * example when its field loses focus, debounced. Not when the page loads.
	 *
	 * The solution is valid only for this process and this user telecom, only once, and for 10 minutes. Khermes refuses
	 * a new challenge for the same user telecom from the same IP within 60 seconds (429): if the user changes the user
	 * telecom and then goes back to the previous one, reuse the solution already computed for it instead of asking
	 * again.
	 *
	 * @param khermesUrl the url of Khermes, `https://khermes.icure.cloud` in production.
	 * @param processId the id of the Khermes authentication process.
	 * @param userTelecom the email address or phone number the authentication will be started for.
	 * @param secretKey the secret key of the Kerberus provider of the process's Spec.
	 * @param onProgress a callback notified of the progress of the computation, between 0 and 1.
	 * @param options the http client and crypto service to use.
	 */
	@OptIn(InternalIcureApi::class)
	suspend fun solveKerberusChallenge(
		khermesUrl: String,
		processId: String,
		userTelecom: String,
		secretKey: String,
		onProgress: ((Double) -> Unit)? = null,
		options: CommonSdkOptions = BasicSdkOptions(),
	): Solution = RawKhermesApi(options.configuredClientOrDefault(), options.cryptoService).solveKerberusChallenge(
		khermesUrl = khermesUrl,
		processId = processId,
		userTelecom = userTelecom,
		secretKey = secretKey,
		onProgress = onProgress ?: {},
	)
}
