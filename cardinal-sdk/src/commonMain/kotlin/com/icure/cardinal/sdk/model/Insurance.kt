// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasCodes
import com.icure.cardinal.sdk.model.base.HasIdentifier
import com.icure.cardinal.sdk.model.base.HasTags
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.DecryptedAddress
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlin.Boolean

/**
 *
 *  Represents an insurance entity. An insurance can be a mutual fund, a private insurance company,
 *  or any other type of insurance organization that covers healthcare costs.
 */
@Serializable
data class Insurance(
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
	 * The identifiers of the insurance.
	 */
	@param:DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
	/**
	 * Tags that qualify the insurance as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular insurance.
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
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
) : StoredDocument, HasTags, HasCodes, HasIdentifier {
	// region Insurance-Insurance

	// endregion
}
