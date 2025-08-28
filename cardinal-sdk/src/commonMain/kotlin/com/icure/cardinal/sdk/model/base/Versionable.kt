package com.icure.cardinal.sdk.model.base

import kotlin.String

public interface Versionable<T> : Identifiable<T> {
	public val rev: String?
}
