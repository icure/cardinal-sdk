// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.AnonymousRoleApi
import com.icure.cardinal.sdk.js.api.AnonymousRoleApiJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import kotlin.Array
import kotlin.OptIn
import kotlin.String
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class AnonymousRoleApiImplJs(
	private val anonymousRoleApi: AnonymousRoleApi,
) : AnonymousRoleApiJs {
	override fun getPermissions(): Promise<Array<String>> = GlobalScope.promise {
		val result = anonymousRoleApi.getPermissions(
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}
}
