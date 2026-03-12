package com.icure.cardinal.sdk.model.filter

import com.icure.cardinal.sdk.model.base.Identifiable
import kotlin.String

public interface AbstractFilter<O : Identifiable<String>> : Filter<O> {
	public val desc: String?
}
