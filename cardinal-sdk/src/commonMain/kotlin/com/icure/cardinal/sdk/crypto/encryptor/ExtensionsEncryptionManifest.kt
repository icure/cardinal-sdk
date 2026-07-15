package com.icure.cardinal.sdk.crypto.encryptor

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ExtensionsEncryptionManifest(
	val fullEncryptionFields: Set<String>,
	val recursiveEncryptionFields: Map<String, Recursive>,
) {
	/**
	 * Specify how to apply recursive encryption to a field.
	 */
	@Serializable
	sealed interface Recursive {
		/**
		 * The field represents a collection of elements that are encrypted using the rules specified by [recursive].
		 * Each element of the collection is encrypted individually.
		 */
		@Serializable
		@SerialName("Collection")
		class Collection(val recursive: Recursive) : Recursive
		/**
		 * The field represents a map where the values are encrypted using the rules specified by [recursive].
		 * Each value of the map is encrypted individually.
		 */
		@Serializable
		@SerialName("Map")
		class Map(val recursive: Recursive) : Recursive
		/**
		 * The field represents an object with fields encrypted using the rules specified in the
		 * [ExtensionsEncryptionManifest] manifest with name [manifestName].
		 */
		@Serializable
		@SerialName("Object")
		class Object(val manifestName: String) : Recursive
	}
}