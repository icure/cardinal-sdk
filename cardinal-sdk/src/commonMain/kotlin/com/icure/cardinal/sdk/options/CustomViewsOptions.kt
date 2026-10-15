package com.icure.cardinal.sdk.options

import com.icure.cardinal.sdk.customsdk.commons.model.ViewManifest

data class CustomViewsOptions(
	val accessLogManifest: Map<String, ViewManifest> = emptyMap(),
	val calendarItemManifest: Map<String, ViewManifest> = emptyMap(),
	val contactManifest: Map<String, ViewManifest> = emptyMap(),
	val healthElementManifest: Map<String, ViewManifest> = emptyMap(),
	val patientManifest: Map<String, ViewManifest> = emptyMap(),
	val messageManifest: Map<String, ViewManifest> = emptyMap(),
	val topicManifest: Map<String, ViewManifest> = emptyMap(),
	val documentManifest: Map<String, ViewManifest> = emptyMap(),
	val formManifest: Map<String, ViewManifest> = emptyMap(),
	val receiptManifest: Map<String, ViewManifest> = emptyMap(),
	val classificationManifest: Map<String, ViewManifest> = emptyMap(),
	val invoiceManifest: Map<String, ViewManifest> = emptyMap(),
	val relatedPersonManifest: Map<String, ViewManifest> = emptyMap(),
)
