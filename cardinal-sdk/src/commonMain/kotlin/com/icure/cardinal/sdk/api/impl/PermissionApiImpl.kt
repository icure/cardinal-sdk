package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.PermissionApi
import com.icure.cardinal.sdk.api.raw.RawPermissionApi
import com.icure.cardinal.sdk.model.security.Permission
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal class PermissionApiImpl(
	private val rawApi: RawPermissionApi,
) : PermissionApi {
	override suspend fun modifyUserPermissions(
		userId: String,
		permissions: Permission,
	) = rawApi.modifyUserPermissions(
		userId = userId,
		permissions = permissions,
	).successBody()
}