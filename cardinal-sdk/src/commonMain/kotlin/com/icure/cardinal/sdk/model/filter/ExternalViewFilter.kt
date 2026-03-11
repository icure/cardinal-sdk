package com.icure.cardinal.sdk.model.filter

import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.model.utils.ExternalFilterKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that queries an external CouchDB view to retrieve matching entities.
 * /
 */
@SerialName("ExternalViewFilter")
@Serializable
public data class ExternalViewFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * The name of the external view to query.
	 */
	public val view: String,
	/**
	 * The partition of the view.
	 */
	public val partition: String,
	/**
	 * The fully qualified name of the entity type to filter.
	 */
	public val entityQualifiedName: String,
	/**
	 * The start key for the view query range.
	 */
	public val startKey: ExternalFilterKey?,
	/**
	 * The end key for the view query range.
	 */
	public val endKey: ExternalFilterKey?,
) : AbstractFilter<Identifiable<String>>
