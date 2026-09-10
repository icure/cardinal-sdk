// auto-generated file
package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun secretIdUseOption_toJs(obj: SecretIdUseOption): SecretIdUseOptionJs = when (obj) {
	is SecretIdUseOption.UseAnySharedWithHierarchy ->
			secretIdUseOption_UseAnySharedWithHierarchy_toJs(obj)
	is SecretIdUseOption.UseAllSharedWithHierarchy ->
			secretIdUseOption_UseAllSharedWithHierarchy_toJs(obj)
	is SecretIdUseOption.Use -> secretIdUseOption_Use_toJs(obj)
	is SecretIdUseOption.UseNone -> secretIdUseOption_UseNone_toJs(obj)
}

public fun secretIdUseOption_fromJs(obj: SecretIdUseOptionJs): SecretIdUseOption = when {
	obj is SecretIdUseOptionJs_UseAnySharedWithHierarchyJs || obj.ktClass ==
			"com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithHierarchy" ->secretIdUseOption_UseAnySharedWithHierarchy_fromJs(obj
			as com.icure.cardinal.sdk.js.crypto.entities.SecretIdUseOptionJs_UseAnySharedWithHierarchyJs)
	obj is SecretIdUseOptionJs_UseAllSharedWithHierarchyJs || obj.ktClass ==
			"com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAllSharedWithHierarchy" ->secretIdUseOption_UseAllSharedWithHierarchy_fromJs(obj
			as com.icure.cardinal.sdk.js.crypto.entities.SecretIdUseOptionJs_UseAllSharedWithHierarchyJs)
	obj is SecretIdUseOptionJs_UseJs || obj.ktClass ==
			"com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.Use" ->secretIdUseOption_Use_fromJs(obj
			as com.icure.cardinal.sdk.js.crypto.entities.SecretIdUseOptionJs_UseJs)
	obj is SecretIdUseOptionJs_UseNoneJs || obj.ktClass ==
			"com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseNone" ->secretIdUseOption_UseNone_fromJs(obj
			as com.icure.cardinal.sdk.js.crypto.entities.SecretIdUseOptionJs_UseNoneJs)
	else -> throw
			IllegalArgumentException("""Unknown concrete implementation for com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption: $obj""")
}

@Suppress("UNUSED_VARIABLE")
public
		fun secretIdUseOption_UseAnySharedWithHierarchy_toJs(obj: SecretIdUseOption.UseAnySharedWithHierarchy):
		SecretIdUseOptionJs_UseAnySharedWithHierarchyJs = SecretIdUseOptionJs_UseAnySharedWithHierarchyJs

public
		fun secretIdUseOption_UseAnySharedWithHierarchy_fromJs(obj: SecretIdUseOptionJs_UseAnySharedWithHierarchyJs):
		SecretIdUseOption.UseAnySharedWithHierarchy = SecretIdUseOption.UseAnySharedWithHierarchy

@Suppress("UNUSED_VARIABLE")
public
		fun secretIdUseOption_UseAllSharedWithHierarchy_toJs(obj: SecretIdUseOption.UseAllSharedWithHierarchy):
		SecretIdUseOptionJs_UseAllSharedWithHierarchyJs = SecretIdUseOptionJs_UseAllSharedWithHierarchyJs

public
		fun secretIdUseOption_UseAllSharedWithHierarchy_fromJs(obj: SecretIdUseOptionJs_UseAllSharedWithHierarchyJs):
		SecretIdUseOption.UseAllSharedWithHierarchy = SecretIdUseOption.UseAllSharedWithHierarchy

@Suppress("UNUSED_VARIABLE")
public fun secretIdUseOption_Use_toJs(obj: SecretIdUseOption.Use): SecretIdUseOptionJs_UseJs {
	val secretIds = setToArray(
		obj.secretIds,
		{ x1: String ->
			x1
		},
	)
	return SecretIdUseOptionJs_UseJs(js("{" +
		"secretIds:secretIds" +
	"}"))
}

public fun secretIdUseOption_Use_fromJs(obj: SecretIdUseOptionJs_UseJs): SecretIdUseOption.Use {
	val secretIds = arrayToSet(
		obj.secretIds,
		"obj.secretIds",
		{ x1: String ->
			x1
		},
	)
	return SecretIdUseOption.Use(
		secretIds = secretIds,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun secretIdUseOption_UseNone_toJs(obj: SecretIdUseOption.UseNone):
		SecretIdUseOptionJs_UseNoneJs = SecretIdUseOptionJs_UseNoneJs

public fun secretIdUseOption_UseNone_fromJs(obj: SecretIdUseOptionJs_UseNoneJs):
		SecretIdUseOption.UseNone = SecretIdUseOption.UseNone
