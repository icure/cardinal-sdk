// TODO auto-generate
package com.icure.cardinal.sdk.js.auth

import com.icure.cardinal.sdk.auth.CaptchaOptions
import com.icure.cardinal.sdk.js.kerberus.Solution_fromJs

public fun captchaOptions_fromJs(obj: CaptchaOptionsJs): CaptchaOptions = when {
	obj is CaptchaOptionsJs_RecaptchaJs || obj.ktClass ==
			"com.icure.cardinal.sdk.auth.CaptchaOptions.Recaptcha" ->captchaOptions_Recaptcha_fromJs(obj as
			com.icure.cardinal.sdk.js.auth.CaptchaOptionsJs_RecaptchaJs)
	obj is CaptchaOptionsJs_FriendlyCaptchaJs || obj.ktClass ==
			"com.icure.cardinal.sdk.auth.CaptchaOptions.FriendlyCaptcha" ->captchaOptions_FriendlyCaptcha_fromJs(obj
			as com.icure.cardinal.sdk.js.auth.CaptchaOptionsJs_FriendlyCaptchaJs)
	obj is CaptchaOptionsJs_KerberusJs_ComputedJs || obj.ktClass ==
			"com.icure.cardinal.sdk.auth.CaptchaOptions.Kerberus.Computed" ->captchaOptions_Kerberus_Computed_fromJs(obj
			as com.icure.cardinal.sdk.js.auth.CaptchaOptionsJs_KerberusJs_ComputedJs)
	obj is CaptchaOptionsJs_KerberusJs_DelegatedJs || obj.ktClass ==
			"com.icure.cardinal.sdk.auth.CaptchaOptions.Kerberus.Delegated" ->captchaOptions_Kerberus_Delegated_fromJs(obj
			as com.icure.cardinal.sdk.js.auth.CaptchaOptionsJs_KerberusJs_DelegatedJs)
	else -> throw
			IllegalArgumentException("""Unknown concrete implementation for com.icure.cardinal.sdk.auth.CaptchaOptions: $obj""")
}

public fun captchaOptions_Recaptcha_fromJs(obj: CaptchaOptionsJs_RecaptchaJs):
		CaptchaOptions.Recaptcha {
	val solution = obj.solution
	return CaptchaOptions.Recaptcha(
		solution = solution,
	)
}

public fun captchaOptions_FriendlyCaptcha_fromJs(obj: CaptchaOptionsJs_FriendlyCaptchaJs):
		CaptchaOptions.FriendlyCaptcha {
	val solution = obj.solution
	return CaptchaOptions.FriendlyCaptcha(
		solution = solution,
	)
}


public fun captchaOptions_Kerberus_Computed_fromJs(obj: CaptchaOptionsJs_KerberusJs_ComputedJs):
		CaptchaOptions.Kerberus.Computed {
	val solution = Solution_fromJs(obj.solution)
	return CaptchaOptions.Kerberus.Computed(
		solution = solution,
	)
}

public fun captchaOptions_Kerberus_Delegated_fromJs(obj: CaptchaOptionsJs_KerberusJs_DelegatedJs):
		CaptchaOptions.Kerberus.Delegated {
	return CaptchaOptions.Kerberus.Delegated(
		secretKey = obj.secretKey,
		onProgress = obj.onProgress,
	)
}
