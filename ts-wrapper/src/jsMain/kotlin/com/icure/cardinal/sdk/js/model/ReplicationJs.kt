// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.base.IdentifiableJs
import com.icure.cardinal.sdk.js.model.base.NamedJs
import com.icure.cardinal.sdk.js.model.base.StoredDocumentJs
import com.icure.cardinal.sdk.js.model.embed.DatabaseSynchronizationJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Replication")
public external class ReplicationJs(
	partial: dynamic,
) : StoredDocumentJs,
    IdentifiableJs<String>,
    NamedJs {
	override val id: String

	override val rev: String?

	override val deletionDate: Double?

	override val name: String?

	public val context: String?

	public val databaseSynchronizations: Array<DatabaseSynchronizationJs>
}
