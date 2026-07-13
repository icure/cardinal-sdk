package com.icure.cardinal.sdk.crypto.encryptor

class ExtensionsEncryptionManifest(
	val fullEncryptionFields: Set<String>,
	val recursiveEncryptionFields: Map<String, Recursive>,
) {
	/**
	 * Specify how to apply recursive encryption to a field.
	 */
	sealed interface Recursive {
		/**
		 * The field represents a collection of elements that are encrypted using the rules specified by [recursive].
		 * Each element of the collection is encrypted individually.
		 */
		class Collection(val recursive: Recursive) : Recursive
		/**
		 * The field represents a map where the values are encrypted using the rules specified by [recursive].
		 * Each value of the map is encrypted individually.
		 */
		class Map(val recursive: Recursive) : Recursive
		/**
		 * The field represents an object with fields encrypted using the rules specified in the
		 * [ExtensionsEncryptionManifest] manifest with name [manifestName].
		 */
		class Object(val manifestName: String) : Recursive
	}
}