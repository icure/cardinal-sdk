package com.icure.cardinal.sdk.utils.pagination

import com.icure.cardinal.sdk.model.PaginatedDocumentKeyIdPair
import com.icure.cardinal.sdk.model.PaginatedList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun <T : Any> exhaustPaginatedRequest(
	request: suspend (nextKeyPair: PaginatedDocumentKeyIdPair?) -> PaginatedList<T>
): Flow<T> = flow {
	var next = request(null).also { res -> res.rows.forEach { emit(it) } }.nextKeyPair
	while (next != null) {
		next = request(next).also { res -> res.rows.forEach { emit(it) } }.nextKeyPair
	}
}

fun <T : Any> exhaustPaginatedRequestChunked(
	request: suspend (nextKeyPair: PaginatedDocumentKeyIdPair?) -> PaginatedList<T>
): Flow<List<T>> = flow {
	var next = request(null).also { res -> emit(res.rows) }.nextKeyPair
	while (next != null) {
		next = request(next).also { res -> emit(res.rows) }.nextKeyPair
	}
}
