// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.HasCodesJs
import com.icure.cardinal.sdk.js.model.base.HasTagsJs
import com.icure.cardinal.sdk.js.model.base.IdentifiableJs
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("CareTeamMember")
public sealed external interface CareTeamMemberJs : EncryptableJs, HasTagsJs, HasCodesJs,
		IdentifiableJs<String> {
	public val careTeamMemberType: String?

	public val healthcarePartyId: String?

	public val quality: CodeStubJs?

	public val isEncrypted: Boolean
}

@JsName("DecryptedCareTeamMember")
public external class DecryptedCareTeamMemberJs(
	partial: dynamic,
) : CareTeamMemberJs {
	override val id: String

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val careTeamMemberType: String?

	override val healthcarePartyId: String?

	override val quality: CodeStubJs?

	override val encryptedSelf: String?

	override val isEncrypted: Boolean
}

@JsName("EncryptedCareTeamMember")
public external class EncryptedCareTeamMemberJs(
	partial: dynamic,
) : CareTeamMemberJs {
	override val id: String

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val careTeamMemberType: String?

	override val healthcarePartyId: String?

	override val quality: CodeStubJs?

	override val encryptedSelf: String?

	override val isEncrypted: Boolean
}
