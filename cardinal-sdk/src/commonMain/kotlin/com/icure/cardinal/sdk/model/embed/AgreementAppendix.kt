package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String

@Serializable
public data class AgreementAppendix(
	public val docSeq: Int? = null,
	public val verseSeq: Int? = null,
	public val documentId: String? = null,
	public val path: String? = null,
)
