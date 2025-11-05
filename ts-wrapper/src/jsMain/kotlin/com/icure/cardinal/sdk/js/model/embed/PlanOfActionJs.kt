// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.ICureDocumentJs
import com.icure.cardinal.sdk.js.model.base.NamedJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("PlanOfAction")
public sealed external interface PlanOfActionJs : EncryptableJs, ICureDocumentJs<String>, NamedJs {
	public val prescriberId: String?

	public val valueDate: Double?

	public val openingDate: Double?

	public val closingDate: Double?

	public val deadlineDate: Double?

	public val descr: String?

	public val note: String?

	public val idOpeningContact: String?

	public val idClosingContact: String?

	public val status: Double

	public val documentIds: Array<out String>

	public val numberOfCares: Double?

	public val careTeamMemberships: Array<out CareTeamMembershipJs>

	public val relevant: Boolean

	public val isEncrypted: Boolean
}

@JsName("DecryptedPlanOfAction")
public external class DecryptedPlanOfActionJs(
	partial: dynamic,
) : PlanOfActionJs {
	override val id: String

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val medicalLocationId: String?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val endOfLife: Double?

	override val prescriberId: String?

	override val valueDate: Double?

	override val openingDate: Double?

	override val closingDate: Double?

	override val deadlineDate: Double?

	override val name: String?

	override val descr: String?

	override val note: String?

	override val idOpeningContact: String?

	override val idClosingContact: String?

	override val status: Double

	override val documentIds: Array<String>

	override val numberOfCares: Double?

	override val careTeamMemberships: Array<DecryptedCareTeamMembershipJs>

	override val relevant: Boolean

	override val encryptedSelf: String?

	override val isEncrypted: Boolean
}

@JsName("EncryptedPlanOfAction")
public external class EncryptedPlanOfActionJs(
	partial: dynamic,
) : PlanOfActionJs {
	override val id: String

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val medicalLocationId: String?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val endOfLife: Double?

	override val prescriberId: String?

	override val valueDate: Double?

	override val openingDate: Double?

	override val closingDate: Double?

	override val deadlineDate: Double?

	override val name: String?

	override val descr: String?

	override val note: String?

	override val idOpeningContact: String?

	override val idClosingContact: String?

	override val status: Double

	override val documentIds: Array<String>

	override val numberOfCares: Double?

	override val careTeamMemberships: Array<EncryptedCareTeamMembershipJs>

	override val relevant: Boolean

	override val encryptedSelf: String?

	override val isEncrypted: Boolean
}
