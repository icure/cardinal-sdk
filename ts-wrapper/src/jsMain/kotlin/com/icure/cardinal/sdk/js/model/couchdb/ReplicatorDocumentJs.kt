// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.couchdb

import com.icure.cardinal.sdk.js.model.base.VersionableJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("ReplicatorDocument")
public external class ReplicatorDocumentJs(
	partial: dynamic,
) : VersionableJs<String> {
	override val id: String

	override val rev: String?

	public val source: RemoteJs?

	public val target: RemoteJs?

	public val owner: String?

	public val create_target: Boolean?

	public val continuous: Boolean?

	public val doc_ids: Array<String>?

	public val replicationState: String?

	public val replicationStateTime: String?

	public val replicationStats: ReplicationStatsJs?

	public val errorCount: Double?

	public val revsInfo: Array<Record<String, String>>?
}
