@file:OptIn(ExperimentalJsExport::class)

package com.icure.cardinal.sdk.exceptions

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport
class SecureStorageException(message: String, cause: Throwable? = null) : Exception(message, cause)
