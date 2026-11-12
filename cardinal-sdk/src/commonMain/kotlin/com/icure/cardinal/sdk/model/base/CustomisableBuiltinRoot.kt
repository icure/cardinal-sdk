// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.base

import kotlin.String

interface CustomisableBuiltinRoot : CustomisableRoot {
	/**
	 *
	 *  Id of the customised type of this entity: a key of the extensions configured for this builtin entity type, or
	 *  null for unextended entities. It is null if and only if [customisedModelVersion] is null.
	 */
	public val customisedTypeId: String?

	// region CustomisableBuiltinRoot-CustomisableBuiltinRoot
	// endregion
}
