package com.icure.cardinal.sdk.dart

import com.icure.cardinal.sdk.CardinalBaseSdk
import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.auth.AuthenticationProcessTelecomType
import com.icure.cardinal.sdk.auth.AuthenticationProcessTemplateParameters
import com.icure.cardinal.sdk.dart.auth.CaptchaOptions
import com.icure.cardinal.sdk.dart.options.DartBasicSdkOptions
import com.icure.cardinal.sdk.dart.options.DartCryptoStrategiesOptions
import com.icure.cardinal.sdk.dart.options.DartSdkOptions
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.DisposableNativeReference
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.storage.StorageFacade
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.cancel
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
object Initializers {
	fun initializeSdk(
		dartResultCallback: (
			String?,
			String?,
			String?,
			String?,
		) -> Unit,
		projectIdString: String,
		baseUrlString: String,
		authenticationMethodString: String,
		storageFacade: StorageFacade,
		optionsString: String
	) {
		val projectId = fullLanguageInteropJson.decodeFromString(
			String.serializer().nullable,
			projectIdString,
		)
		val baseUrl = fullLanguageInteropJson.decodeFromString(
			String.serializer(),
			baseUrlString,
		)
		val authenticationMethod = fullLanguageInteropJson.decodeFromString(
			com.icure.cardinal.sdk.dart.auth.AuthenticationMethod.serializer(),
			authenticationMethodString
		)
		val options = fullLanguageInteropJson.decodeFromString(
			DartSdkOptions.serializer(),
			optionsString
		)
		ApiScope.execute(
			dartResultCallback,
			String.serializer()
		) {
			val sdk = kotlin.runCatching {
				CardinalSdk.initialize(
					projectId,
					baseUrl,
					authenticationMethod.toMultiplatform(),
					storageFacade,
					options.toMultiplatform()
				)
			}.onFailure {
				// Release crypto strategies in case of failure.
				options.cryptoStrategies?.release(it)
				options.releaseInitializationResources(it)
			}.onSuccess {
				// We release initialization resources also on success: not needed anymore
				options.releaseInitializationResources(null)
			}.getOrThrow()
			NativeReferences.create(DartCardinalSdkReference(
				sdk,
				options.cryptoStrategies
			))
		}
	}

	fun switchGroup(
		dartResultCallback: (
			String?,
			String?,
			String?,
			String?,
		) -> Unit,
		sdkId: String,
		groupId: String
	) {
		ApiScope.execute(
			dartResultCallback,
			String.serializer()
		) {
			val sdk = NativeReferences.get<DartCardinalSdkReference>(sdkId)
			val switchedSdk = kotlin.runCatching {
				sdk.switchGroup(groupId)
			}.onSuccess {
				// We need to mark crypto strategies as used: crypto strategies should be GCd only when both the
				// original and group switched sdk are GCd
				sdk.cryptoStrategiesOptions?.markUsed()
			}.getOrThrow()
			NativeReferences.create(DartCardinalSdkReference(
				switchedSdk,
				sdk.cryptoStrategiesOptions
			))
		}
	}

	fun baseSwitchGroup(
		dartResultCallback: (
			String?,
			String?,
			String?,
			String?,
		) -> Unit,
		sdkId: String,
		groupId: String
	) {
		ApiScope.execute(
			dartResultCallback,
			String.serializer()
		) {
			NativeReferences.create(NativeReferences.get<CardinalBaseSdk>(sdkId).switchGroup(groupId))
		}
	}

	fun initializeBaseSdk(
		dartResultCallback: (
			String?,
			String?,
			String?,
			String?,
		) -> Unit,
		projectIdString: String,
		baseUrlString: String,
		authenticationMethodString: String,
		optionsString: String
	) {
		val projectId = fullLanguageInteropJson.decodeFromString(
			String.serializer().nullable,
			projectIdString,
		)
		val baseUrl = fullLanguageInteropJson.decodeFromString(
			String.serializer(),
			baseUrlString,
		)
		val authenticationMethod = fullLanguageInteropJson.decodeFromString(
			com.icure.cardinal.sdk.dart.auth.AuthenticationMethod.serializer(),
			authenticationMethodString
		)
		val options = fullLanguageInteropJson.decodeFromString(
			DartBasicSdkOptions.serializer(),
			optionsString
		)
		ApiScope.execute(
			dartResultCallback,
			String.serializer()
		) {
			val sdk = kotlin.runCatching {
				CardinalBaseSdk.initialize(
					projectId,
					baseUrl,
					authenticationMethod.toMultiplatform(),
					options.toMultiplatform()
				)
			}.onFailure {
				options.releaseInitializationResources(it)
			}.onSuccess {
				// We release initialization resources also on success: not needed anymore
				options.releaseInitializationResources(null)
			}.getOrThrow()
			NativeReferences.create(sdk)
		}
	}

	fun initializeWithAuthProcess(
		dartResultCallback: (
			String?,
			String?,
			String?,
			String?,
		) -> Unit,
		projectIdString: String,
		baseUrlString: String,
		messageGatewayUrlString: String,
		externalServicesSpecIdString: String,
		processIdString: String,
		userTelecomTypeString: String,
		userTelecomString: String,
		captchaOptionsString: String,
		baseStorage: StorageFacade,
		authenticationProcessTemplateParametersString: String,
		optionsString: String
	) {
		val projectId = fullLanguageInteropJson.decodeFromString(
			String.serializer().nullable,
			projectIdString,
		)
		val baseUrl = fullLanguageInteropJson.decodeFromString(
			String.serializer(),
			baseUrlString,
		)
		val messageGatewayUrl = fullLanguageInteropJson.decodeFromString(
			String.serializer(),
			messageGatewayUrlString,
		)
		val externalServicesSpecId = fullLanguageInteropJson.decodeFromString(
			String.serializer(),
			externalServicesSpecIdString,
		)
		val processId = fullLanguageInteropJson.decodeFromString(
			String.serializer(),
			processIdString,
		)
		val userTelecomType = fullLanguageInteropJson.decodeFromString(
			AuthenticationProcessTelecomType.serializer(),
			userTelecomTypeString
		)
		val userTelecom = fullLanguageInteropJson.decodeFromString(
			String.serializer(),
			userTelecomString,
		)
		val captchaOptions = fullLanguageInteropJson.decodeFromString(
			CaptchaOptions.serializer(),
			captchaOptionsString
		)
		val authenticationProcessTemplateParameters = fullLanguageInteropJson.decodeFromString(
			AuthenticationProcessTemplateParameters.serializer(),
			authenticationProcessTemplateParametersString
		)
		val options = fullLanguageInteropJson.decodeFromString(
			DartSdkOptions.serializer(),
			optionsString
		)
		ApiScope.execute(
			dartResultCallback,
			String.serializer()
		) {
			val authStep = kotlin.runCatching {
				CardinalSdk.initializeWithProcess(
					projectId,
					baseUrl,
					messageGatewayUrl,
					externalServicesSpecId,
					processId,
					userTelecomType,
					userTelecom,
					captchaOptions.toMultiplatform(),
					baseStorage,
					authenticationProcessTemplateParameters,
					options.toMultiplatform()
				)
			}.onFailure {
				options.cryptoStrategies?.release(it)
				options.releaseInitializationResources(it)
			}.getOrThrow()
			// If not failed don't release initialization resources: they will be used in the complete authentication and
			// will be released by the reference when disposed
			NativeReferences.create(DartAuthenticationWithProcessStepReference(
				authStep,
				options
			))
		}
	}

	fun completeAuthentication(
		dartResultCallback: (
			String?,
			String?,
			String?,
			String?,
		) -> Unit,
		authenticationStepId: String,
		validationCodeString: String,
	) {
		val authStep = NativeReferences.get<DartAuthenticationWithProcessStepReference>(authenticationStepId)
		val validationCode = fullLanguageInteropJson.decodeFromString(
			String.serializer(),
			validationCodeString,
		)
		ApiScope.execute(
			dartResultCallback,
			String.serializer()
		) {
			val sdk = kotlin.runCatching {
				authStep.completeAuthentication(validationCode)
			}.onSuccess {
				// Mark additional use for crypto strategies if successful otherwise the dispose of the authStep reference
				// will make them unusable to the sdk.
				authStep.dartOptions.cryptoStrategies?.markUsed()
			}.getOrThrow()
			// Initialization resources will be disposed by the authStep reference.
			NativeReferences.create(
				DartCardinalSdkReference(
					sdk,
					authStep.dartOptions.cryptoStrategies
				)
			)
		}
	}
}

private class DartCardinalSdkReference(
	private val sdk: CardinalSdk,
	val cryptoStrategiesOptions: DartCryptoStrategiesOptions?,
) : CardinalSdk by sdk, DisposableNativeReference {
	override suspend fun dispose() {
		cryptoStrategiesOptions?.release(null)
		sdk.scope.cancel()
	}
}

private class DartAuthenticationWithProcessStepReference(
	authStep: CardinalSdk.AuthenticationWithProcessStep,
	val dartOptions: DartSdkOptions,
) : CardinalSdk.AuthenticationWithProcessStep by authStep, DisposableNativeReference {
	override suspend fun dispose() {
		dartOptions.releaseInitializationResources(null)
		dartOptions.cryptoStrategies?.release(null)
	}
}