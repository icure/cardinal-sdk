package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.ApplicationSettings
import com.icure.cardinal.sdk.model.EncryptedApplicationSettings

interface ApplicationSettingsApi {
	suspend fun getApplicationSettings(): List<EncryptedApplicationSettings>
	suspend fun createApplicationSettings(applicationSettings: EncryptedApplicationSettings): EncryptedApplicationSettings
	suspend fun updateApplicationSettings(applicationSettings: EncryptedApplicationSettings): EncryptedApplicationSettings
}
