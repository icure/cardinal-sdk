package com.icure.cardinal.sdk.utils.generation

/**
 * Supports the customised SDK generator by specifying which features a custom entity definition must have for a
 * member of the custom entity api to be exposed in the wrapper generated for that definition.
 *
 * The member is exposed only if the definition supports all the [requires] categories.
 *
 * Members of a custom entity api without this annotation are implementation details and are never exposed directly.
 */
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.SOURCE)
annotation class CustomEntityApiMethod(
	vararg val requires: CustomEntityApiCategory,
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
	 * metadata initialisation, sharing, encryption and decryption of extensions, links with owning entities, ...
	 * Applicable to definitions using the `DelegationBased` access control.
	 */
	Encryption,
}
