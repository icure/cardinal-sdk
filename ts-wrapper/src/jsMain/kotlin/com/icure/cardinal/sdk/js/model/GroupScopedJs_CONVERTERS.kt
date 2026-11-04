// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.model.GroupScoped
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun <E, E_JS> groupScoped_toJs(obj: GroupScoped<E>, convertE: (E) -> E_JS): GroupScopedJs<E_JS> {
	val entity = convertE(obj.entity)
	val groupId = obj.groupId
	return GroupScopedJs<E_JS>(js("{" +
		"entity:entity," +
		"groupId:groupId" +
	"}"))
}

public fun <E, E_KT> groupScoped_fromJs(obj: GroupScopedJs<E>, convertE: (E) -> E_KT): GroupScoped<E_KT> {
	val entity = convertE(obj.entity)
	val groupId = obj.groupId
	return GroupScoped<E_KT>(
		entity = entity,
		groupId = groupId,
	)
}
