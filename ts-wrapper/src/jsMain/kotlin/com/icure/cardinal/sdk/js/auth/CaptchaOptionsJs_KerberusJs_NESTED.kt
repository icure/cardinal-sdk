// TODO auto-generate
@file:JsQualifier("auth.CaptchaOptions.Kerberus")

package com.icure.cardinal.sdk.js.auth

import com.icure.cardinal.sdk.js.kerberus.SolutionJs

@JsName("Computed")
public external class CaptchaOptionsJs_KerberusJs_ComputedJs(
	partial: dynamic,
) : CaptchaOptionsJs_KerberusJs {
	public val solution: SolutionJs

	override val ktClass: String
}

@JsName("Delegated")
public external class CaptchaOptionsJs_KerberusJs_DelegatedJs(
	partial: dynamic,
) : CaptchaOptionsJs_KerberusJs {
	public val secretKey: String?

	public val onProgress: ((Double) -> Unit)?

	override val ktClass: String
}
