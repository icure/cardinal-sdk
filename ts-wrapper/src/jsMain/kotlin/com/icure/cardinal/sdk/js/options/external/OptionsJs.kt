@file:JsQualifier("options")
package com.icure.cardinal.sdk.js.options.external

import com.icure.cardinal.sdk.js.auth.CaptchaOptionsJs
import com.icure.cardinal.sdk.js.crypto.CryptoStrategiesJs
import com.icure.cardinal.sdk.js.model.UserGroupJs
import com.icure.cardinal.sdk.js.storage.KeyStorageFacadeJs
import com.icure.kryptom.crypto.external.XCryptoService
import kotlin.js.Promise

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
	val encryptedFields: EncryptedFieldsConfigurationJs?
	val useHierarchicalDataOwners: Boolean?
	val createTransferKeys: Boolean?
	val cryptoService: XCryptoService?
	val groupSelector: ((availableGroups: Array<UserGroupJs>) -> Promise<String>)?
	val autoCreateEncryptionKeyForExistingLegacyData: Boolean?
	val keyStorage: KeyStorageFacadeJs?
	val cryptoStrategies: CryptoStrategiesJs?
	val jsonPatcher: JsonPatcherJs?
	val lenientJson: Boolean?
}

@JsName("BasicSdkOptions")
external interface BasicSdkOptionsJs {
	val encryptedFields: EncryptedFieldsConfigurationJs?
	val cryptoService: XCryptoService?
	val groupSelector: ((availableGroups: Array<UserGroupJs>) -> Promise<String>)?
	val lenientJson: Boolean?
}

@JsName("AnonymousSdkOptions")
external interface AnonymousSdkOptionsJs {
	val lenientJson: Boolean?
}

@JsName("EncryptedFieldsConfiguration")
external interface EncryptedFieldsConfigurationJs {
	val accessLog: Array<String>?
	val calendarItem: Array<String>?
	val contact: Array<String>?
	val service: Array<String>?
	val healthElement: Array<String>?
	val maintenanceTask: Array<String>?
	val patient: Array<String>?
	val message: Array<String>?
	val topic: Array<String>?
	val document: Array<String>?
	val form: Array<String>?
	val receipt: Array<String>?
	val classification: Array<String>?
	val timeTable: Array<String>?
	val invoice: Array<String>?
}

@JsName("JsonPatcher")
external interface JsonPatcherJs {
	val patchAccessLog: ((json: dynamic) -> dynamic)?
	val patchCalendarItem: ((json: dynamic) -> dynamic)?
	val patchContact: ((json: dynamic) -> dynamic)?
	val patchIndividualService: ((json: dynamic) -> dynamic)?
	val patchHealthElement: ((json: dynamic) -> dynamic)?
	val patchMaintenanceTask: ((json: dynamic) -> dynamic)?
	val patchPatient: ((json: dynamic) -> dynamic)?
	val patchMessage: ((json: dynamic) -> dynamic)?
	val patchTopic: ((json: dynamic) -> dynamic)?
	val patchDocument: ((json: dynamic) -> dynamic)?
	val patchForm: ((json: dynamic) -> dynamic)?
	val patchReceipt: ((json: dynamic) -> dynamic)?
	val patchClassification: ((json: dynamic) -> dynamic)?
	val patchTimeTable: ((json: dynamic) -> dynamic)?
	val patchInvoice: ((json: dynamic) -> dynamic)?
}
