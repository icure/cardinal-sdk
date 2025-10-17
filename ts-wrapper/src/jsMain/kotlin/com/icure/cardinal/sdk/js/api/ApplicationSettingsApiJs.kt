// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.EncryptedApplicationSettingsJs
import kotlin.Array
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("ApplicationSettingsApi")
public external interface ApplicationSettingsApiJs {
	public fun getApplicationSettings(): Promise<Array<EncryptedApplicationSettingsJs>>

	public fun createApplicationSettings(applicationSettings: EncryptedApplicationSettingsJs):
			Promise<EncryptedApplicationSettingsJs>

	public fun updateApplicationSettings(applicationSettings: EncryptedApplicationSettingsJs):
			Promise<EncryptedApplicationSettingsJs>
}
