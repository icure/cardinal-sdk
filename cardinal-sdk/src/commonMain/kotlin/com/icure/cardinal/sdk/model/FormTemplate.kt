package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.DocumentGroup
import com.icure.cardinal.sdk.model.embed.form.template.FormTemplateLayout
import com.icure.cardinal.sdk.serialization.ByteArraySerializer
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.ByteArray
import kotlin.Long
import kotlin.String
import kotlin.collections.Set

@Serializable
public data class FormTemplate(
	override val id: String,
	override val rev: String? = null,
	override val deletionDate: Long? = null,
	public val templateLayout: FormTemplateLayout? = null,
	@Serializable(with = ByteArraySerializer::class)
	public val rawTemplateLayout: ByteArray? = null,
	public val name: String? = null,
	public val guid: String? = null,
	public val group: DocumentGroup? = null,
	public val descr: String? = null,
	public val disabled: String? = null,
	public val specialty: CodeStub? = null,
	public val author: String? = null,
	public val formInstancePreferredLocation: String? = null,
	public val keyboardShortcut: String? = null,
	public val shortReport: String? = null,
	public val mediumReport: String? = null,
	public val longReport: String? = null,
	@DefaultValue("emptySet()")
	public val reports: Set<String> = emptySet(),
	@DefaultValue("emptySet()")
	public val tags: Set<CodeStub> = emptySet(),
	public val layoutAttachmentId: String? = null,
	public val templateLayoutAttachmentId: String? = null,
) : StoredDocument
