@file:JsQualifier("options")
package com.icure.cardinal.sdk.js.options.external

import com.icure.cardinal.sdk.js.auth.CaptchaOptionsJs
import com.icure.cardinal.sdk.js.crypto.CryptoStrategiesJs
import com.icure.cardinal.sdk.js.model.UserGroupJs
import com.icure.cardinal.sdk.js.storage.KeyStorageFacadeJs
import com.icure.cardinal.sdk.options.EncryptedFieldsOptions
import com.icure.kryptom.crypto.external.XCryptoService
import kotlin.js.Promise

/*TODO
 * - New encrypted fields settings
 * - unversionedEntitiesDecryptedJsonStrictness
 */

@JsName("AuthenticationMethod")
external interface AuthenticationMethodJs

@JsName("SecretProviderAuthenticationOptions")
external interface SecretProviderAuthenticationOptionsJs {
	val loginUsername: String?
	val initialSecret: InitialSecretJs?
	val existingJwt: String?
	val existingRefreshJwt: String?
	val cacheSecrets: Boolean?
}

@JsName("AuthSecretProvider")
external interface AuthSecretProviderJs {
	fun getSecret(
		acceptedSecrets: Array<String>,
		previousAttempts: Array<AuthSecretDetailsJs>,
		authProcessApi: AuthenticationProcessApiJs
	): Promise<AuthSecretDetailsJs>
}

@JsName("AuthenticationProcessRequest")
external class AuthenticationProcessRequestJs(
	messageGwUrl: String,
	specId: String,
	requestId: String
) {
	val messageGwUrl: String
	val specId: String
	val requestId: String
}

@JsName("AuthSecretDetails")
external interface AuthSecretDetailsJs

@JsName("AuthenticationProcessApi")
external interface AuthenticationProcessApiJs {
	fun executeProcess(
		messageGatewayUrl: String,
		externalServicesSpecId: String,
		processId: String,
		userTelecomType: String,
		userTelecom: String,
		captchaOptions: CaptchaOptionsJs,
		processTemplateParameters: AuthenticationProcessTemplateParametersJs?
	): Promise<AuthenticationProcessRequestJs>
}

@JsName("AuthenticationProcessTemplateParameters")
external interface AuthenticationProcessTemplateParametersJs {
	val firstName: String?
	val lastName: String?
}

@JsName("SdkOptions")
external interface SdkOptionsJs {
	val useHierarchicalDataOwners: Boolean?
	val createTransferKeys: Boolean?
	val cryptoService: XCryptoService?
	val groupSelector: ((availableGroups: Array<UserGroupJs>) -> Promise<String>)?
	val autoCreateEncryptionKeyForExistingLegacyData: Boolean?
	val keyStorage: KeyStorageFacadeJs?
	val cryptoStrategies: CryptoStrategiesJs?
	val ignoreUnknownFields: Boolean?
	val dataOwnerScope: String?
	val unversionedEntitiesDecryptedJsonStrictness: String?
}

@JsName("BasicToFullSdkOptions")
external interface BasicToFullSdkOptionsJs {
	val useHierarchicalDataOwners: Boolean?
	val createTransferKeys: Boolean?
	val autoCreateEncryptionKeyForExistingLegacyData: Boolean?
	val keyStorage: KeyStorageFacadeJs?
	val cryptoStrategies: CryptoStrategiesJs?
	val unversionedEntitiesDecryptedJsonStrictness: String?
}

@JsName("BasicSdkOptions")
external interface BasicSdkOptionsJs {
	val cryptoService: XCryptoService?
	val groupSelector: ((availableGroups: Array<UserGroupJs>) -> Promise<String>)?
	val ignoreUnknownFields: Boolean?
	val dataOwnerScope: String?
}

@JsName("AnonymousSdkOptions")
external interface AnonymousSdkOptionsJs {
	val ignoreUnknownFields: Boolean?
}

@JsName("CustomisedSdkOptions")
external interface CustomisedSdkOptionsJs {
	val encryptedFieldsOptions: dynamic
}
