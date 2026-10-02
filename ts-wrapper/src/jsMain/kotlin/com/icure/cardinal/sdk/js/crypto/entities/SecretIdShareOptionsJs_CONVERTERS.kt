// auto-generated file
package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun secretIdShareOptions_toJs(obj: SecretIdShareOptions): SecretIdShareOptionsJs = when (obj) {
	is SecretIdShareOptions.AllAvailable -> secretIdShareOptions_AllAvailable_toJs(obj)
	is SecretIdShareOptions.UseExactly -> secretIdShareOptions_UseExactly_toJs(obj)
}

public fun secretIdShareOptions_fromJs(obj: SecretIdShareOptionsJs): SecretIdShareOptions = when {
	obj is SecretIdShareOptionsJs_AllAvailableJs || obj.ktClass == "com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.AllAvailable" ->secretIdShareOptions_AllAvailable_fromJs(obj as com.icure.cardinal.sdk.js.crypto.entities.SecretIdShareOptionsJs_AllAvailableJs)
	obj is SecretIdShareOptionsJs_UseExactlyJs || obj.ktClass == "com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.UseExactly" ->secretIdShareOptions_UseExactly_fromJs(obj as com.icure.cardinal.sdk.js.crypto.entities.SecretIdShareOptionsJs_UseExactlyJs)
	else -> throw IllegalArgumentException("""Unknown concrete implementation for com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions: $obj""")
}

@Suppress("UNUSED_VARIABLE")
public fun secretIdShareOptions_AllAvailable_toJs(obj: SecretIdShareOptions.AllAvailable): SecretIdShareOptionsJs_AllAvailableJs {
	val requireAtLeastOne = obj.requireAtLeastOne
	return SecretIdShareOptionsJs_AllAvailableJs(js("{" +
		"requireAtLeastOne:requireAtLeastOne" +
	"}"))
}

public fun secretIdShareOptions_AllAvailable_fromJs(obj: SecretIdShareOptionsJs_AllAvailableJs): SecretIdShareOptions.AllAvailable {
	val requireAtLeastOne = obj.requireAtLeastOne
	return SecretIdShareOptions.AllAvailable(
		requireAtLeastOne = requireAtLeastOne,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun secretIdShareOptions_UseExactly_toJs(obj: SecretIdShareOptions.UseExactly): SecretIdShareOptionsJs_UseExactlyJs {
	val secretIds = setToArray(
		obj.secretIds,
		{ x1: String ->
			x1
		},
	)
	val createUnknownSecretIds = obj.createUnknownSecretIds
	return SecretIdShareOptionsJs_UseExactlyJs(js("{" +
		"secretIds:secretIds," +
		"createUnknownSecretIds:createUnknownSecretIds" +
	"}"))
}

public fun secretIdShareOptions_UseExactly_fromJs(obj: SecretIdShareOptionsJs_UseExactlyJs): SecretIdShareOptions.UseExactly {
	val secretIds = arrayToSet(
		obj.secretIds,
		"obj.secretIds",
		{ x1: String ->
			x1
		},
	)
	val createUnknownSecretIds = obj.createUnknownSecretIds
	return SecretIdShareOptions.UseExactly(
		secretIds = secretIds,
		createUnknownSecretIds = createUnknownSecretIds,
	)
}
