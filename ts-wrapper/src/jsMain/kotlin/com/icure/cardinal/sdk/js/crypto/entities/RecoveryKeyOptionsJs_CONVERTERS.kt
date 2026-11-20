// auto-generated file
package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.crypto.entities.RecoveryKeyOptions
import com.icure.cardinal.sdk.crypto.entities.RecoveryKeySize
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun recoveryKeyOptions_toJs(obj: RecoveryKeyOptions): RecoveryKeyOptionsJs = when (obj) {
	is RecoveryKeyOptions.Generate -> recoveryKeyOptions_Generate_toJs(obj)
	is RecoveryKeyOptions.Use -> recoveryKeyOptions_Use_toJs(obj)
}

public fun recoveryKeyOptions_fromJs(obj: RecoveryKeyOptionsJs): RecoveryKeyOptions = when {
	obj is RecoveryKeyOptionsJs_GenerateJs || obj.ktClass == "com.icure.cardinal.sdk.crypto.entities.RecoveryKeyOptions.Generate" ->recoveryKeyOptions_Generate_fromJs(obj as com.icure.cardinal.sdk.js.crypto.entities.RecoveryKeyOptionsJs_GenerateJs)
	obj is RecoveryKeyOptionsJs_UseJs || obj.ktClass == "com.icure.cardinal.sdk.crypto.entities.RecoveryKeyOptions.Use" ->recoveryKeyOptions_Use_fromJs(obj as com.icure.cardinal.sdk.js.crypto.entities.RecoveryKeyOptionsJs_UseJs)
	else -> throw IllegalArgumentException("""Unknown concrete implementation for com.icure.cardinal.sdk.crypto.entities.RecoveryKeyOptions: $obj""")
}

@Suppress("UNUSED_VARIABLE")
public fun recoveryKeyOptions_Generate_toJs(obj: RecoveryKeyOptions.Generate): RecoveryKeyOptionsJs_GenerateJs {
	val recoveryKeySize = obj.recoveryKeySize.name
	return RecoveryKeyOptionsJs_GenerateJs(js("{" +
		"recoveryKeySize:recoveryKeySize" +
	"}"))
}

public fun recoveryKeyOptions_Generate_fromJs(obj: RecoveryKeyOptionsJs_GenerateJs): RecoveryKeyOptions.Generate {
	val recoveryKeySize = RecoveryKeySize.valueOf(obj.recoveryKeySize)
	return RecoveryKeyOptions.Generate(
		recoveryKeySize = recoveryKeySize,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun recoveryKeyOptions_Use_toJs(obj: RecoveryKeyOptions.Use): RecoveryKeyOptionsJs_UseJs {
	val key = recoveryDataKey_toJs(obj.key)
	return RecoveryKeyOptionsJs_UseJs(js("{" +
		"key:key" +
	"}"))
}

public fun recoveryKeyOptions_Use_fromJs(obj: RecoveryKeyOptionsJs_UseJs): RecoveryKeyOptions.Use {
	val key = recoveryDataKey_fromJs(obj.key)
	return RecoveryKeyOptions.Use(
		key = key,
	)
}
