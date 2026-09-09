// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.model.PaginatedList
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun <T, T_JS> paginatedList_toJs(obj: PaginatedList<T>, convertT: (T) -> T_JS):
		PaginatedListJs<T_JS> {
	val rows = listToArray(
		obj.rows,
		{ x1: T ->
			convertT(x1)
		},
	)
	val nextKeyPair = nullToUndefined(
		obj.nextKeyPair?.let { nonNull1 ->
			paginatedDocumentKeyIdPair_toJs(nonNull1)
		}
	)
	val error = nullToUndefined(
		obj.error?.let { nonNull1 ->
			paginationError_toJs(nonNull1)
		}
	)
	return PaginatedListJs<T_JS>(js("{" +
		"rows:rows," +
		"nextKeyPair:nextKeyPair," +
		"error:error" +
	"}"))
}

public fun <T, T_KT> paginatedList_fromJs(obj: PaginatedListJs<T>, convertT: (T) -> T_KT):
		PaginatedList<T_KT> {
	val rows = arrayToList(
		obj.rows,
		"obj.rows",
		{ x1: T ->
			convertT(x1)
		},
	)
	val nextKeyPair = obj.nextKeyPair?.let { nonNull1 ->
		paginatedDocumentKeyIdPair_fromJs(nonNull1)
	}
	val error = obj.error?.let { nonNull1 ->
		paginationError_fromJs(nonNull1)
	}
	return PaginatedList<T_KT>(
		rows = rows,
		nextKeyPair = nextKeyPair,
		error = error,
	)
}
