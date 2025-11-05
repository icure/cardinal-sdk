package com.icure.cardinal.sdk.js.utils

val cardinalInternalGlobals: CardinalInternalsGlobals by lazy {
	val globalThis = js("globalThis")
	if (globalThis.cardinalInternalGlobals == null) {
		globalThis.cardinalInternalGlobals = js("{}")
	}
	globalThis.cardinalInternalGlobals
}

external interface CardinalInternalsGlobals {
	var randomUuid: (() -> String)?
}