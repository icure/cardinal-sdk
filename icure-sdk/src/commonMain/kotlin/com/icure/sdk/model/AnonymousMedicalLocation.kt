package com.icure.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Map

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class AnonymousMedicalLocation(
    public val id: String,
    public val publicInformations: Map<String, String> = emptyMap(),
)
