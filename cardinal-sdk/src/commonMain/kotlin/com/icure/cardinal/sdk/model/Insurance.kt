package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.DecryptedAddress
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Map

/**
 * Represents an insurance entity. An insurance can be a mutual fund, a private insurance company,
 * or any other type of insurance organization that covers healthcare costs.
 * /
 */
@Serializable
public data class Insurance(
	/**
	 * The unique identifier of the insurance.
	 */
	override val id: String,
	/**
	 * The revision of the insurance in the database, used for conflict management / optimistic
	 * locking.
	 */
	override val rev: String? = null,
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The name of the insurance in different languages.
	 */
	@param:DefaultValue("emptyMap()")
	public val name: Map<String, String> = emptyMap(),
	/**
	 * Whether this is a private insurance.
	 */
	@param:DefaultValue("false")
	public val privateInsurance: Boolean = false,
	/**
	 * Whether this insurance covers hospitalisation.
	 */
	@param:DefaultValue("false")
	public val hospitalisationInsurance: Boolean = false,
	/**
	 * Whether this insurance covers ambulatory care.
	 */
	@param:DefaultValue("false")
	public val ambulatoryInsurance: Boolean = false,
	/**
	 * The insurance code.
	 */
	public val code: String? = null,
	/**
	 * The agreement number for the insurance.
	 */
	public val agreementNumber: String? = null,
	/**
	 * The id of the parent insurance entity.
	 */
	public val parent: String? = null,
	/**
	 * The address of the insurance company.
	 */
	public val address: DecryptedAddress,
) : StoredDocument
