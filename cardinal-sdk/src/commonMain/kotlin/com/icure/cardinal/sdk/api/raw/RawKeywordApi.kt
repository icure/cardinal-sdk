package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.Keyword
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.utils.InternalIcureApi
import kotlin.Int
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawKeywordApi {
	// region common endpoints

	suspend fun createKeyword(c: Keyword): HttpResponse<Keyword>

	suspend fun getKeyword(keywordId: String): HttpResponse<Keyword>

	suspend fun getKeywordsByUser(userId: String): HttpResponse<List<Keyword>>

	suspend fun getKeywords(
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<Keyword>>

	suspend fun deleteKeywords(keywordIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun modifyKeyword(keywordDto: Keyword): HttpResponse<Keyword>
	// endregion
}
