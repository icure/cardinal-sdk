
package com.icure.cardinal.sdk.auth

import com.icure.kerberus.Solution
import io.ktor.utils.io.InternalAPI

/**
 * Captcha options for authentication.
 */
sealed interface CaptchaOptions {
	@InternalAPI
	val msgGwIdentifier: String

	/**
	 * Google reCAPTCHA.
	 *
	 * @param solution the token obtained by solving the reCAPTCHA. (https://developers.google.com/recaptcha/docs/v3)
	 */
	@OptIn(InternalAPI::class)
	data class Recaptcha(val solution: String): CaptchaOptions {
		override val msgGwIdentifier: String
			get() = "g-recaptcha-response"
	}

	/**
	 * FriendlyCaptcha.
	 *
	 * @param solution the token obtained by solving the FriendlyCaptcha. (https://developer.friendlycaptcha.com/docs/v2/getting-started/install)
	 */
	@OptIn(InternalAPI::class)
	data class FriendlyCaptcha(val solution: String) : CaptchaOptions {
		override val msgGwIdentifier: String
			get() = "friendly-captcha-response"
	}

	/**
	 * Kerberus is a proof of work captcha multiplatform library.
	 *
	 * [Documentation](https://github.com/icure/kerberus)
	 */
	@OptIn(InternalAPI::class)
	sealed interface Kerberus : CaptchaOptions {
		override val msgGwIdentifier: String
			get() = "kerberus-response"
		/**
		 * It means that the solution is already computed and ready to be used. Made for cases where the solution is computed alongside
		 * the user inputs to smooth the user experience.
		 *
		 * For a Khermes process, the solution must be computed for the same process and user telecom as the authentication, for
		 * example with [KhermesCaptcha.solveKerberusChallenge]. Khermes binds each challenge to the user telecom it is issued for, so
		 * the solving can start only once the user has entered their email address or phone number, not when the page loads. In a form
		 * with other fields, such as a registration form, start it when that field is complete; in a form with only that field,
		 * [Delegated] is as fast.
		 *
		 * @param solution the solution to the Kerberus challenge.
		 */
		data class Computed(
			val solution: Solution
		) : Kerberus

		/**
		 * It means the solution will be computed automatically by the client. Before doing the call to the API, the client will ask the
		 * server for a challenge, solve it and then send the solution to the server alongside the other data.
		 * You can also provide a progress callback to be notified of the progress of the computation.
		 *
		 * @param secretKey the secret key of the Kerberus provider of the Khermes process's Spec. Required for a Khermes process, ignored
		 * by the message gateway.
		 * @param onProgress a callback to be notified of the progress of the computation.
		 */
		data class Delegated(
			val secretKey: String? = null,
			val onProgress: ((Double) -> Unit)? = null,
		) : Kerberus
	}
}
