package com.icure.cardinal.sdk.model.base

import kotlin.Long
import kotlin.String

/**
 *
 *  Interface for entities that are persisted as CouchDB documents and support hard deletion via a
 * deletion timestamp.
 */
public interface StoredDocument : Versionable<String> {
	public val deletionDate: Long?
}
