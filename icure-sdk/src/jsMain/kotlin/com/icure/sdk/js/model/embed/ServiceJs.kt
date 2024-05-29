// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.base.CodeStubJs
import com.icure.sdk.js.model.base.ICureDocumentJs
import com.icure.sdk.js.model.base.IdentifierJs
import com.icure.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Service")
public sealed external interface ServiceJs : EncryptableJs, ICureDocumentJs<String> {
	public val transactionId: String?

	public val identifier: Array<out IdentifierJs>

	public val contactId: String?

	public val subContactIds: Array<out String>?

	public val plansOfActionIds: Array<out String>?

	public val healthElementsIds: Array<out String>?

	public val formIds: Array<out String>?

	public val secretForeignKeys: Array<out String>?

	public val cryptedForeignKeys: Record<String, out Array<out DelegationJs>>

	public val delegations: Record<String, out Array<out DelegationJs>>

	public val encryptionKeys: Record<String, out Array<out DelegationJs>>

	public val label: String?

	public val index: Double?

	public val content: Record<String, out ContentJs>

	public val encryptedContent: String?

	public val textIndexes: Record<String, out String>

	public val valueDate: Double?

	public val openingDate: Double?

	public val closingDate: Double?

	public val formId: String?

	public val comment: String?

	public val status: Double?

	public val invoicingCodes: Array<out String>

	public val notes: Array<out AnnotationJs>

	public val qualifiedLinks: Record<String, out Record<String, out String>>

	public val securityMetadata: SecurityMetadataJs?

	public val isEncrypted: Boolean

	@JsName("${'$'}ktClass")
	public val ktClass: String
}

@JsName("DecryptedService")
public external class DecryptedServiceJs(
	partial: dynamic,
) : ServiceJs {
	override val id: String

	override val transactionId: String?

	override val identifier: Array<IdentifierJs>

	override val contactId: String?

	override val subContactIds: Array<String>?

	override val plansOfActionIds: Array<String>?

	override val healthElementsIds: Array<String>?

	override val formIds: Array<String>?

	override val secretForeignKeys: Array<String>?

	override val cryptedForeignKeys: Record<String, Array<DelegationJs>>

	override val delegations: Record<String, Array<DelegationJs>>

	override val encryptionKeys: Record<String, Array<DelegationJs>>

	override val label: String?

	override val index: Double?

	override val content: Record<String, DecryptedContentJs>

	override val encryptedContent: String?

	override val textIndexes: Record<String, String>

	override val valueDate: Double?

	override val openingDate: Double?

	override val closingDate: Double?

	override val formId: String?

	override val created: Double?

	override val modified: Double?

	override val endOfLife: Double?

	override val author: String?

	override val responsible: String?

	override val medicalLocationId: String?

	override val comment: String?

	override val status: Double?

	override val invoicingCodes: Array<String>

	override val notes: Array<AnnotationJs>

	override val qualifiedLinks: Record<String, Record<String, String>>

	override val codes: Array<CodeStubJs>

	override val tags: Array<CodeStubJs>

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val isEncrypted: Boolean

	override val ktClass: String
}

@JsName("EncryptedService")
public external class EncryptedServiceJs(
	partial: dynamic,
) : ServiceJs {
	override val id: String

	override val transactionId: String?

	override val identifier: Array<IdentifierJs>

	override val contactId: String?

	override val subContactIds: Array<String>?

	override val plansOfActionIds: Array<String>?

	override val healthElementsIds: Array<String>?

	override val formIds: Array<String>?

	override val secretForeignKeys: Array<String>?

	override val cryptedForeignKeys: Record<String, Array<DelegationJs>>

	override val delegations: Record<String, Array<DelegationJs>>

	override val encryptionKeys: Record<String, Array<DelegationJs>>

	override val label: String?

	override val index: Double?

	override val content: Record<String, EncryptedContentJs>

	override val encryptedContent: String?

	override val textIndexes: Record<String, String>

	override val valueDate: Double?

	override val openingDate: Double?

	override val closingDate: Double?

	override val formId: String?

	override val created: Double?

	override val modified: Double?

	override val endOfLife: Double?

	override val author: String?

	override val responsible: String?

	override val medicalLocationId: String?

	override val comment: String?

	override val status: Double?

	override val invoicingCodes: Array<String>

	override val notes: Array<AnnotationJs>

	override val qualifiedLinks: Record<String, Record<String, String>>

	override val codes: Array<CodeStubJs>

	override val tags: Array<CodeStubJs>

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val isEncrypted: Boolean

	override val ktClass: String
}
