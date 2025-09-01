package com.icure.cardinal.sdk.js.crypto

import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.kryptom.crypto.external.XCryptoService
import com.icure.kryptom.crypto.external.adaptCryptoServiceForExternal

@JsExport
val internalDefaultCryptoService: XCryptoService = adaptCryptoServiceForExternal(defaultCryptoService)
