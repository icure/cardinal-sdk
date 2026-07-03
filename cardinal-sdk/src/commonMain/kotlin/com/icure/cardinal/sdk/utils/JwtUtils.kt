package com.icure.cardinal.sdk.utils

import com.icure.kryptom.utils.base64Decode
import com.icure.cardinal.sdk.auth.level
import com.icure.cardinal.sdk.model.embed.AuthenticationClass
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Clock
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

@Serializable
internal data class JwtPayload(
	val exp: Long,
	@SerialName("tac") val tokenAuthenticationClass: Int? = null,
	@SerialName("jwtD") val duration: Long? = null
) {
	companion object {
		/**
		 * Default duration of a token, same as the server
		 */
		private const val DEFAULT_DURATION_SECONDS = 60 * 60L

		/**
		 * Maximum lifetime of a token for it to be considered valid for elevated security
		 */
		private const val MAXIMUM_ELEVATED_SECURITY_LIFETIME_MILLIS = 5 * 60 * 1000
	}

	/**
	 * Specifies if the token is valid for the execution of a method requiring the provided authentication class.
	 * This considers both the authentication class of the token and its age.
	 * When calculating the age of the token, this method considers the token as if it was older by the amount specified
	 * by [padding].
	 * This allows reducing the chances of the token becoming invalid in transit.
	 */
	fun isValidForAuthClass(authenticationClass: AuthenticationClass, padding: Duration): Boolean {
		if (tokenAuthenticationClass == null || tokenAuthenticationClass < authenticationClass.level) return false
		val issuedTime = exp - (duration ?: DEFAULT_DURATION_SECONDS) * 1000
		val tokenAgeMs = Clock.System.now().toEpochMilliseconds() - issuedTime
		return tokenAgeMs < (MAXIMUM_ELEVATED_SECURITY_LIFETIME_MILLIS + padding.inWholeMilliseconds)
	}
}

internal fun decodeClaims(jwt: String): JwtPayload {
	val parts = jwt.split(".").also {
		check(it.size == 3) { "Invalid JWT token" }
	}
	return Serialization.lenientJson.decodeFromString<JwtPayload>(base64Decode(parts[1]).decodeToString())
}

/**
 * Checks if a base-64 encoded JWT has an invalid format or is expired.
 */
fun isJwtExpiredOrInvalid(jwt: String, refreshPadding: Duration = 0L.seconds): Boolean = runCatching {
		val payload = decodeClaims(jwt)
		(payload.exp * 1000) < (Clock.System.now().toEpochMilliseconds() + refreshPadding.inWholeMilliseconds)
	}.getOrDefault(false)

