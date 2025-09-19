package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.enums.UsersStatus
import com.icure.cardinal.sdk.model.enums.UsersType
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

@Serializable
public data class UserStub(
	override val id: String,
	override val rev: String? = null,
	override val deletionDate: Long? = null,
	public val name: String? = null,
	public val type: UsersType? = null,
	public val status: UsersStatus? = null,
	public val login: String? = null,
	public val groupId: String? = null,
	public val healthcarePartyId: String? = null,
	public val patientId: String? = null,
	public val email: String? = null,
) : StoredDocument
