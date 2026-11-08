// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.AnonymousHealthcarePartyApi
import com.icure.cardinal.sdk.js.api.AnonymousHealthcarePartyApiJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.HealthcarePartyJs
import com.icure.cardinal.sdk.js.model.healthcareParty_toJs
import com.icure.cardinal.sdk.model.HealthcareParty
import kotlin.Array
import kotlin.OptIn
import kotlin.String
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class AnonymousHealthcarePartyApiImplJs(
	private val anonymousHealthcarePartyApi: AnonymousHealthcarePartyApi,
) : AnonymousHealthcarePartyApiJs {
	override fun getPublicHealthcarePartiesInGroup(groupId: String): Promise<Array<HealthcarePartyJs>> = GlobalScope.promise {
		val groupIdConverted: String = groupId
		val result = anonymousHealthcarePartyApi.getPublicHealthcarePartiesInGroup(
			groupIdConverted,
		)
		listToArray(
			result,
			{ x1: HealthcareParty ->
				healthcareParty_toJs(x1)
			},
		)
	}
}
