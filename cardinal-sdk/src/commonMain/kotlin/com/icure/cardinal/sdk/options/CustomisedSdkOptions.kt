package com.icure.cardinal.sdk.options

/**
 * Options for the creation of a CardinalSdk that are normally passed automatically by the
 * customized SDK initializer.
 */
data class CustomisedSdkOptions(
	/**
	 * Specifies which fields should be encrypted for each entity, root or embedded.
	 */
	val encryptedFieldsOptions: EncryptedFieldsOptions? = null
)