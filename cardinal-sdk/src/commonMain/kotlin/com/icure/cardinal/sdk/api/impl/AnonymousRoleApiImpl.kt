package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.AnonymousRoleApi
import com.icure.cardinal.sdk.api.raw.RawAnonymousApi
import com.icure.utils.InternalIcureApi

@OptIn(InternalIcureApi::class)
class AnonymousRoleApiImpl(
	val raw: RawAnonymousApi
) : AnonymousRoleApi {

	override suspend fun getPermissions(): List<String> = raw.getPermissions().successBody()

}
