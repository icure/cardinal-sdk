package com.icure.cardinal.sdk.model.filter

import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.model.utils.ExternalFilterKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("ExternalViewFilter")
@Serializable
public data class ExternalViewFilter(
	override val desc: String? = null,
	public val view: String,
	public val partition: String,
	public val entityQualifiedName: String,
	public val startKey: ExternalFilterKey?,
	public val endKey: ExternalFilterKey?,
) : AbstractFilter<Identifiable<String>>
