package com.icure.cardinal.sdk.utils.generation

/**
 * Supports the customised SDK generator by specifying which features a custom entity definition must have for a
 * member of the custom entity api to be exposed in the wrapper generated for that definition, and how the member
 * should be named in the wrapper.
 *
 * The member is exposed only if the definition supports all the [requires] categories and none of the [excludes]
 * categories. Excluded categories allow providing alternative versions of a member for definitions that don't support
 * a category: for example a member requiring [CustomEntityApiCategory.Attachments] and excluding
 * [CustomEntityApiCategory.Encryption] manages the attachments of entities that are never encrypted.
 *
 * Members of a custom entity api without this annotation are implementation details and are never exposed directly.
 *
 * @param name template for the name of the member in the wrapper generated for a definition. If empty the member keeps
 * its name. The template may contain the following placeholders:
 * - `{{Entity}}`: the name of the custom entity (e.g. `create{{Entity}}` -> `createNote`)
 * - `{{Entities}}`: the plural of the name of the custom entity (e.g. `get{{Entities}}` -> `getNotes`)
 * - `{{LinkedEntity}}`: the name of the type of entity targeted by the encrypted link of the custom entity (e.g.
 * `decrypt{{LinkedEntity}}IdOf` -> `decryptPatientIdOf`). Can only be used by members that require
 * [CustomEntityApiCategory.EncryptedLink].
 * @param excludes categories that the definition must not support for the member to be exposed.
 */
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.SOURCE)
annotation class CustomEntityApiMethod(
	vararg val requires: CustomEntityApiCategory,
	val name: String = "",
	val excludes: Array<CustomEntityApiCategory> = [],
)

enum class CustomEntityApiCategory {
	/**
	 * Create, read, update, delete, undelete and purge.
	 * Applicable to all custom entity definitions.
	 */
	Crud,

	/**
	 * Methods for managing the data attachments of a custom entity.
	 * Applicable to definitions that have a non-null `attachmentsConfiguration`.
	 */
	Attachments,

	/**
	 * Methods related to the delegations-based access control and to the encryption of the custom entity: encryption
	 * metadata initialisation, sharing, encryption and decryption of extensions, ...
	 * Applicable to definitions using the `DelegationBased` security model.
	 */
	Encryption,

	/**
	 * Methods specific to the encrypted link from the custom entity to another entity (its owning entity).
	 * Applicable to definitions using the `DelegationBased` security model that have an enabled encrypted link.
	 *
	 * Parameters of type [com.icure.cardinal.sdk.crypto.entities.CustomEntityOwningEntity] don't need this category:
	 * the generator hides them for definitions without an enabled encrypted link, and replaces them with parameters
	 * typed after the linked entity otherwise.
	 */
	EncryptedLink,
}
