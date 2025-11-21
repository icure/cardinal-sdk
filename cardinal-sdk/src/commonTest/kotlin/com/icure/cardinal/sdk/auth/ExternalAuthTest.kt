package com.icure.cardinal.sdk.auth

import com.icure.cardinal.sdk.CardinalBaseSdk
import com.icure.cardinal.sdk.api.raw.impl.RawGroupApiImpl
import com.icure.cardinal.sdk.model.DatabaseInitialisation
import com.icure.cardinal.sdk.model.security.ExternalJwtConfig
import com.icure.cardinal.sdk.options.AuthenticationMethod
import com.icure.cardinal.sdk.test.DefaultRawApiConfig
import com.icure.cardinal.sdk.test.baseUrl
import com.icure.cardinal.sdk.test.createPlainUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.superadminAuth
import com.icure.cardinal.sdk.test.uuid
import com.icure.kryptom.crypto.PrivateRsaKey
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.kryptom.utils.base64Encode
import com.icure.kryptom.utils.base64UrlEncode
import com.icure.utils.InternalIcureApi
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlin.time.Clock

@OptIn(InternalIcureApi::class)
class ExternalAuthTest : StringSpec({
	val appId = "external-auth-test-${uuid()}"
	val group1Id = uuid()
	val group2Id = uuid()
	val configId = uuid()
	lateinit var jwtSignatureKey: PrivateRsaKey<RsaAlgorithm.RsaSignatureAlgorithm.PssWithSha256>
	val jwtEmailField = "email"

	beforeSpec {
		initializeTestEnvironment()
		val groupApi = RawGroupApiImpl(baseUrl, superadminAuth(), DefaultRawApiConfig)
		val parent = groupApi.createGroup(
			uuid(),
			name = "external-auth-test-parent",
			password = uuid(),
			initialisationData = DatabaseInitialisation(),
			applicationId = appId
		).successBody()
		groupApi.createGroup(
			group1Id,
			name = "external-auth-test-1",
			password = uuid(),
			superGroup = parent.id,
			initialisationData = DatabaseInitialisation(),
			applicationId = appId
		).successBody()
		groupApi.createGroup(
			group2Id,
			name = "external-auth-test-2",
			password = uuid(),
			superGroup = parent.id,
			initialisationData = DatabaseInitialisation(),
			applicationId = appId
		).successBody()
		val keypair = defaultCryptoService.rsa.generateKeyPair(RsaAlgorithm.RsaSignatureAlgorithm.PssWithSha256)
		jwtSignatureKey = keypair.private
		groupApi.createOrUpdateExternalJwtConfig(
			parent.id,
			configId,
			ExternalJwtConfig(
				validationMethod = ExternalJwtConfig.ValidationMethod.PublicKey(
					base64Encode(defaultCryptoService.rsa.exportPublicKeySpki(keypair.public)),
					signatureAlgorithm = "PS256"
				),
				fieldSelector = ExternalJwtConfig.FieldSelector.Email(jwtEmailField)
			)
		)
		defaultCryptoService.rsa.exportPublicKeyJwk(keypair.public).also {
			println(it)
		}
	}

	suspend fun createJwtForEmail(email: String): String {
		val header = base64UrlEncode("""{"alg":"PS256","typ":"JWT"}""".encodeToByteArray()).removeSuffix("=").removeSuffix("=")
		val iat = Clock.System.now().epochSeconds
		val exp = iat + 3600
		val payload = base64UrlEncode("""{"iss":"test-issuer","aud":"icure","iat":$iat,"exp":$exp,"$jwtEmailField":"$email"}""".encodeToByteArray()).removeSuffix("=").removeSuffix("=")
		val unsignedToken = "$header.$payload"
		val signature = base64UrlEncode(defaultCryptoService.rsa.sign(
			unsignedToken.encodeToByteArray(),
			jwtSignatureKey,
		)).removeSuffix("=").removeSuffix("=")
		return "$unsignedToken.$signature"
	}

	"Should be able to login using external JWT" {
		val userDetails = createPlainUser(inGroup = group1Id)
		val sdk = CardinalBaseSdk.initialize(
			appId,
			baseUrl,
			AuthenticationMethod.UsingCredentials(
				ExternalAuthenticationToken(
					configId,
					createJwtForEmail(userDetails.email).also { println(it) }
				)
			),
		)
		sdk.user.getCurrentUser().email shouldBe userDetails.email
	}
})
