package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

/**
 * Represents a medicinal product with its intended and actually delivered codes and names.
 * /
 */
@Serializable
public data class Medicinalproduct(
	/**
	 * The list of coded identifiers for the intended medicinal product.
	 */
	@param:DefaultValue("emptyList()")
	public val intendedcds: List<CodeStub> = emptyList(),
	/**
	 * The list of coded identifiers for the actually delivered medicinal product.
	 */
	@param:DefaultValue("emptyList()")
	public val deliveredcds: List<CodeStub> = emptyList(),
	/**
	 * The name of the intended medicinal product.
	 */
	public val intendedname: String? = null,
	/**
	 * The name of the actually delivered medicinal product.
	 */
	public val deliveredname: String? = null,
	/**
	 * The product identifier.
	 */
	public val productId: String? = null,
)
