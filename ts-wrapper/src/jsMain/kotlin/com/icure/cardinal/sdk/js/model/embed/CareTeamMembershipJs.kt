// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.base.ExtendableJs
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("CareTeamMembership")
public sealed external interface CareTeamMembershipJs : EncryptableJs, ExtendableJs {
	public val startDate: Double?

	public val endDate: Double?

	public val careTeamMemberId: String?

	public val membershipType: String?

	public val isEncrypted: Boolean
}

@JsName("DecryptedCareTeamMembership")
public external class DecryptedCareTeamMembershipJs(
	partial: dynamic,
) : CareTeamMembershipJs {
	override val startDate: Double?

	override val endDate: Double?

	override val careTeamMemberId: String?

	override val membershipType: String?

	override val encryptedSelf: String?

	override val extensions: dynamic

	override val isEncrypted: Boolean
}

@JsName("EncryptedCareTeamMembership")
public external class EncryptedCareTeamMembershipJs(
	partial: dynamic,
) : CareTeamMembershipJs {
	override val startDate: Double?

	override val endDate: Double?

	override val careTeamMemberId: String?

	override val membershipType: String?

	override val encryptedSelf: String?

	override val extensions: dynamic

	override val isEncrypted: Boolean
}
