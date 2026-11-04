@file:JsQualifier("crypto.CryptoStrategies.KeyGenerationRequestResult")
package com.icure.cardinal.sdk.js.crypto

import com.icure.kryptom.crypto.external.XRsaKeypair

external interface KeyGenerationRequestResultJs {
	val kind: String
}

@JsName("ParentDelegator")
external class KeyGenerationRequestResultParentDelegatorJs : KeyGenerationRequestResultJs {
	override val kind: String
	val parentId: String
}

@JsName("Use")
external class KeyGenerationRequestResultUseJs : KeyGenerationRequestResultJs {
	override val kind: String
	val keyPair: XRsaKeypair
}
