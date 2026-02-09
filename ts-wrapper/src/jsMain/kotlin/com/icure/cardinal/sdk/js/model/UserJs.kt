// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.base.IdentifierJs
import com.icure.cardinal.sdk.js.model.base.StoredDocumentJs
import com.icure.cardinal.sdk.js.model.security.AuthenticationTokenJs
import com.icure.cardinal.sdk.js.model.security.PermissionJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("User")
public external class UserJs(
	partial: dynamic,
) : StoredDocumentJs {
	override val id: String

	override val rev: String?

	override val deletionDate: Double?

	public val created: Double?

	public val identifier: Array<IdentifierJs>

	public val name: String?

	public val properties: Array<DecryptedPropertyStubJs>

	public val permissions: Array<PermissionJs>

	public val roles: Array<String>

	public val status: String?

	public val login: String?

	public val passwordHash: String?

	public val groupId: String?

	public val healthcarePartyId: String?

	public val patientId: String?

	public val deviceId: String?

	public val autoDelegations: Record<String, Array<String>>

	public val termsOfUseDate: Double?

	public val email: String?

	public val mobilePhone: String?

	public val authenticationTokens: Record<String, AuthenticationTokenJs>

	public val systemMetadata: UserJs_SystemMetadataJs?
}
