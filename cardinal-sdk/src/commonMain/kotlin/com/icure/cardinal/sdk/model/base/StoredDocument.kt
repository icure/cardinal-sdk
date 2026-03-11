// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.base

import kotlin.Long
import kotlin.String

/**
 *
 *  Interface for entities that are persisted as CouchDB documents and support hard deletion via a
 * deletion timestamp.
 */

interface StoredDocument : Versionable<String> {
	public val deletionDate: Long?
	// region StoredDocument-StoredDocument

	// endregion
}
