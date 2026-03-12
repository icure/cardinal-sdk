package com.icure.cardinal.sdk.api

interface AnonymousRoleApi {

	/**
	 * @return a list containing all the permissions that can be used in roles.
	 */
	suspend fun getPermissions(): List<String>

}
