// auto-generated file
@file:JsQualifier("model.Group")

package com.icure.cardinal.sdk.js.model

import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("CustomEntityConfiguration")
public external class GroupJs_CustomEntityConfigurationJs(
	partial: dynamic,
) {
	public val sourceGroup: String

	public val version: Double
}

@JsName("TemplatesConfiguration")
public external class GroupJs_TemplatesConfigurationJs(
	partial: dynamic,
) {
	public val specId: String

	public val emailSender: String?

	public val smsSender: String?

	public val emailVerificationTemplateId: String?

	public val mobilePhoneVerificationTemplateId: String?

	public val existingEmailNotificationTemplateId: String?

	public val existingMobilePhoneNotificationTemplateId: String?
}
