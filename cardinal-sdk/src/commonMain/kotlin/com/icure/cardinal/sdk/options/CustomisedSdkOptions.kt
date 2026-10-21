package com.icure.cardinal.sdk.options

import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName

/**
 * Options for the creation of a CardinalSdk that are normally passed automatically by the
 * customized SDK initializer.
 */
data class CustomisedSdkOptions(
	/**
	 * Specifies which fields should be encrypted for each entity, root or embedded.
	 */
	val encryptedFieldsOptions: EncryptedFieldsOptions? = null,
	/**
	 * All custom type names that this customized SDK uses
	 */
	val knownCustomEntityTypes: Set<EntityWithEncryptionMetadataTypeName.Custom> = emptySet(),
	/**
	 * All builtin type names that this SDK does not use
	 */
	val hiddenBuiltinEntityTypes: Set<EntityWithEncryptionMetadataTypeName.Builtin> = emptySet(),
) {
	internal val knownEntityTypes = (
		EntityWithEncryptionMetadataTypeName.Builtin.entries.filter {
			it !in hiddenBuiltinEntityTypes
		} + knownCustomEntityTypes
	).toSet()
}