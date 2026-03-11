package com.icure.cardinal.sdk.model.base

import kotlin.String

/**
 *
 *  @param <T> The type of the entity identity (a String, a UUID, etc.)
 * </T>
 */
public interface Versionable<T> : Identifiable<T> {
	public val rev: String?
}
