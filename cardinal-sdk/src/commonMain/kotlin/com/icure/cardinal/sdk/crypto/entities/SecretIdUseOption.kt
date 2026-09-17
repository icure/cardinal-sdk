package com.icure.cardinal.sdk.crypto.entities

import kotlinx.serialization.Serializable

/**
 * Configuration for which secret id to use for linking to a owning entity (e.g. which secret id of patient to use
 * when linking a contact to the patient)
 */
@Serializable
sealed interface SecretIdUseOption {
	/**
	 * Similar to [UseAllSharedWithHierarchy] except if there are multiple secret ids that satisfy the requirements; in
	 * that case only one of the found secret ids will be used.
	 *
	 * The selected secret id is arbitrary: no particular ordering, priority, or selection rule is guaranteed.
	 * Callers must not rely on a specific secret id being selected, nor on the selection being stable or reproducible
	 * over time.
	 */
	@Serializable
	data object UseAnySharedWithHierarchy : SecretIdUseOption

	/**
	 * This will use all secret ids that are directly shared with the leaf ancestors in the hierarchy rooted on the
	 * SDK's delegator actor; assumes that each member of the hierarchy has access to the data delegated to its linked
	 * groups, regardless of the data owner group type (parent / simple).
	 *
	 * If the api is initialized in non-hierarchical mode, this means "use all available secret id".
	 *
	 * Guarantees that a secret id is used: if no secret id is found, the initialization method will fail.
	 */
	@Serializable
	data object UseAllSharedWithHierarchy : SecretIdUseOption

	/**
	 * Specify explicitly which secret ids to use. The secretIds can also be empty, in which case the value is
	 * equivalent to [UseNone].
	 * Note that the SDK will not check that the secret id you used is actually a secret id of the owning entity.
	 */
	@Serializable
	data class Use(val secretIds: Set<String>) : SecretIdUseOption

	/**
	 * Instructs the SDK to use no secret id of the owning entity.
	 * The new entity will still have a link to the owning entity, but there will be no link from the owning entity to
	 * the new entity.
	 */
	@Serializable
	data object UseNone : SecretIdUseOption
}