package com.icure.cardinal.sdk.storage.impl

import com.icure.cardinal.sdk.storage.StorageFacade
import kotlinx.browser.localStorage

class LocalStorageStorageFacade : StorageFacade {
	init {
		check(js("typeof(localStorage) === 'object'") as Boolean) {
			"No global local storage is available"
		}
	}

	override suspend fun getItem(key: String): String? =
		localStorage.getItem(key)

	override suspend fun setItem(key: String, value: String) =
		localStorage.setItem(key, value)

	override suspend fun removeItem(key: String) =
		localStorage.removeItem(key)
}