// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.HasTagsJs
import com.icure.cardinal.sdk.js.model.base.StoredDocumentJs
import com.icure.cardinal.sdk.js.model.security.ExternalJwtConfigJs
import com.icure.cardinal.sdk.js.model.security.OperationTokenJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Group")
public external class GroupJs(
	partial: dynamic,
) : StoredDocumentJs, HasTagsJs {
	override val id: String

	override val rev: String?

	override val deletionDate: Double?

	override val tags: Array<CodeStubJs>

	public val publicTags: Array<CodeStubJs>

	public val name: String?

	public val password: String?

	public val servers: Array<String>?

	public val superAdmin: Boolean

	public val properties: Array<DecryptedPropertyStubJs>

	public val defaultUserRoles: Record<String, Array<String>>

	public val operationTokens: Record<String, OperationTokenJs>

	public val sharedEntities: Record<String, String>

	public val minimumKrakenVersion: String?

	public val externalJwtConfig: Record<String, ExternalJwtConfigJs>

	public val minimumAuthenticationClassForElevatedPrivileges: String

	public val superGroup: String?

	public val projectId: String?
}
