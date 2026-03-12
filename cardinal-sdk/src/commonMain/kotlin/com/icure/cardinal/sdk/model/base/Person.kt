package com.icure.cardinal.sdk.model.base

import com.icure.cardinal.sdk.model.embed.Address
import com.icure.cardinal.sdk.model.embed.Gender
import com.icure.cardinal.sdk.model.embed.PersonName
import kotlin.String
import kotlin.collections.List

/**
 *
 *  Interface for entities that represent a person with personal details and contact information.
 */
public interface Person : Identifiable<String> {
	public val civility: String?

	public val gender: Gender?

	public val firstName: String?

	public val lastName: String?

	public val companyName: String?

	public val names: List<PersonName>

	public val addresses: List<Address>

	public val languages: List<String>
}
