package com.icure.cardinal.sdk.model.filter

import com.icure.cardinal.sdk.model.base.Identifiable
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that returns all elements matching the superSet filter but not matching the subSet filter.
 * /
 */
@Serializable
public data class ComplementFilter<O : Identifiable<String>>(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * The base filter whose results form the initial set.
	 */
	override val superSet: AbstractFilter<O>,
	/**
	 * The filter whose results are removed from the superSet results.
	 */
	override val subSet: AbstractFilter<O>,
) : AbstractFilter<O>, Filter.ComplementFilter<O>
