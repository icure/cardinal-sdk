// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun storedDocumentIdentifier_toJs(obj: StoredDocumentIdentifier): StoredDocumentIdentifierJs {
	val id = obj.id
	val rev = obj.rev
	return StoredDocumentIdentifierJs(js("{" +
		"id:id," +
		"rev:rev" +
	"}"))
}

public fun storedDocumentIdentifier_fromJs(obj: StoredDocumentIdentifierJs): StoredDocumentIdentifier {
	val id = obj.id
	val rev = obj.rev
	return StoredDocumentIdentifier(
		id = id,
		rev = rev,
	)
}
