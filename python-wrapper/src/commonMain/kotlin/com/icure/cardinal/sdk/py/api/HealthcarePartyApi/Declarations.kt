// auto-generated file
package com.icure.cardinal.sdk.py.api.HealthcarePartyApi

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.model.DataOwnerRegistrationSuccess
import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.PublicKey
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.py.utils.PyResult
import com.icure.cardinal.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyResult
import com.icure.cardinal.sdk.py.utils.toPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.serialization.EntitySubscriptionWithSerializer
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Byte
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Set
import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CValues
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer

@Serializable
private class GetHealthcarePartyParams(
	public val healthcarePartyId: String,
)

@OptIn(InternalIcureApi::class)
public fun getHealthcarePartyBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetHealthcarePartyParams>(params)
	runBlocking {
		sdk.healthcareParty.getHealthcareParty(
			decodedParams.healthcarePartyId,
		)
	}
}.toPyString(HealthcareParty.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getHealthcarePartyAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetHealthcarePartyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.getHealthcareParty(
				decodedParams.healthcarePartyId,
			)
		}.toPyStringAsyncCallback(HealthcareParty.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetHealthcarePartiesParams(
	public val healthcarePartyIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getHealthcarePartiesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetHealthcarePartiesParams>(params)
	runBlocking {
		sdk.healthcareParty.getHealthcareParties(
			decodedParams.healthcarePartyIds,
		)
	}
}.toPyString(ListSerializer(HealthcareParty.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getHealthcarePartiesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetHealthcarePartiesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.getHealthcareParties(
				decodedParams.healthcarePartyIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(HealthcareParty.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateHealthcarePartyParams(
	public val healthcareParty: HealthcareParty,
)

@OptIn(InternalIcureApi::class)
public fun createHealthcarePartyBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateHealthcarePartyParams>(params)
	runBlocking {
		sdk.healthcareParty.createHealthcareParty(
			decodedParams.healthcareParty,
		)
	}
}.toPyString(HealthcareParty.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createHealthcarePartyAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateHealthcarePartyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.createHealthcareParty(
				decodedParams.healthcareParty,
			)
		}.toPyStringAsyncCallback(HealthcareParty.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateHealthcarePartiesParams(
	public val healthcareParties: List<HealthcareParty>,
)

@OptIn(InternalIcureApi::class)
public fun createHealthcarePartiesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateHealthcarePartiesParams>(params)
	runBlocking {
		sdk.healthcareParty.createHealthcareParties(
			decodedParams.healthcareParties,
		)
	}
}.toPyString(ListSerializer(HealthcareParty.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createHealthcarePartiesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateHealthcarePartiesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.createHealthcareParties(
				decodedParams.healthcareParties,
			)
		}.toPyStringAsyncCallback(ListSerializer(HealthcareParty.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyHealthcarePartyParams(
	public val healthcareParty: HealthcareParty,
)

@OptIn(InternalIcureApi::class)
public fun modifyHealthcarePartyBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyHealthcarePartyParams>(params)
	runBlocking {
		sdk.healthcareParty.modifyHealthcareParty(
			decodedParams.healthcareParty,
		)
	}
}.toPyString(HealthcareParty.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyHealthcarePartyAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyHealthcarePartyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.modifyHealthcareParty(
				decodedParams.healthcareParty,
			)
		}.toPyStringAsyncCallback(HealthcareParty.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyHealthcarePartiesParams(
	public val healthcareParties: List<HealthcareParty>,
)

@OptIn(InternalIcureApi::class)
public fun modifyHealthcarePartiesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyHealthcarePartiesParams>(params)
	runBlocking {
		sdk.healthcareParty.modifyHealthcareParties(
			decodedParams.healthcareParties,
		)
	}
}.toPyString(ListSerializer(HealthcareParty.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyHealthcarePartiesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyHealthcarePartiesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.modifyHealthcareParties(
				decodedParams.healthcareParties,
			)
		}.toPyStringAsyncCallback(ListSerializer(HealthcareParty.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun getCurrentHealthcarePartyBlocking(sdk: CardinalNonCryptoApis): String =
		kotlin.runCatching {
	runBlocking {
		sdk.healthcareParty.getCurrentHealthcareParty()
	}
}.toPyString(HealthcareParty.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getCurrentHealthcarePartyAsync(sdk: CardinalNonCryptoApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): COpaquePointer? = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.getCurrentHealthcareParty()
		}.toPyStringAsyncCallback(HealthcareParty.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetPublicKeyParams(
	public val healthcarePartyId: String,
)

@OptIn(InternalIcureApi::class)
public fun getPublicKeyBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetPublicKeyParams>(params)
	runBlocking {
		sdk.healthcareParty.getPublicKey(
			decodedParams.healthcarePartyId,
		)
	}
}.toPyString(PublicKey.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getPublicKeyAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetPublicKeyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.getPublicKey(
				decodedParams.healthcarePartyId,
			)
		}.toPyStringAsyncCallback(PublicKey.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchHealthcarePartiesByParams(
	public val filter: BaseFilterOptions<HealthcareParty>,
)

@OptIn(InternalIcureApi::class)
public fun matchHealthcarePartiesByBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<MatchHealthcarePartiesByParams>(params)
	runBlocking {
		sdk.healthcareParty.matchHealthcarePartiesBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchHealthcarePartiesByAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<MatchHealthcarePartiesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.matchHealthcarePartiesBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterHealthPartiesByParams(
	public val filter: BaseFilterOptions<HealthcareParty>,
)

@OptIn(InternalIcureApi::class)
public fun filterHealthPartiesByBlocking(sdk: CardinalNonCryptoApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterHealthPartiesByParams>(params)
	runBlocking {
		sdk.healthcareParty.filterHealthPartiesBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, HealthcareParty.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterHealthPartiesByAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterHealthPartiesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.filterHealthPartiesBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, HealthcareParty.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class MatchHealthcarePartiesBySortedParams(
	public val filter: BaseSortableFilterOptions<HealthcareParty>,
)

@OptIn(InternalIcureApi::class)
public fun matchHealthcarePartiesBySortedBlocking(sdk: CardinalNonCryptoApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<MatchHealthcarePartiesBySortedParams>(params)
	runBlocking {
		sdk.healthcareParty.matchHealthcarePartiesBySorted(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchHealthcarePartiesBySortedAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<MatchHealthcarePartiesBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.matchHealthcarePartiesBySorted(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterHealthPartiesBySortedParams(
	public val filter: BaseSortableFilterOptions<HealthcareParty>,
)

@OptIn(InternalIcureApi::class)
public fun filterHealthPartiesBySortedBlocking(sdk: CardinalNonCryptoApis, params: String): PyResult
		= kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterHealthPartiesBySortedParams>(params)
	runBlocking {
		sdk.healthcareParty.filterHealthPartiesBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, HealthcareParty.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterHealthPartiesBySortedAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterHealthPartiesBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.filterHealthPartiesBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, HealthcareParty.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class RegisterHealthcarePartyParams(
	public val groupId: String,
	public val parentHcPartyId: String? = null,
	public val token: String? = null,
	public val useShortToken: Boolean? = null,
	public val hcp: HealthcareParty,
)

@OptIn(InternalIcureApi::class)
public fun registerHealthcarePartyBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<RegisterHealthcarePartyParams>(params)
	runBlocking {
		sdk.healthcareParty.registerHealthcareParty(
			decodedParams.groupId,
			decodedParams.parentHcPartyId,
			decodedParams.token,
			decodedParams.useShortToken,
			decodedParams.hcp,
		)
	}
}.toPyString(DataOwnerRegistrationSuccess.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun registerHealthcarePartyAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<RegisterHealthcarePartyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.registerHealthcareParty(
				decodedParams.groupId,
				decodedParams.parentHcPartyId,
				decodedParams.token,
				decodedParams.useShortToken,
				decodedParams.hcp,
			)
		}.toPyStringAsyncCallback(DataOwnerRegistrationSuccess.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteHealthcarePartyByIdParams(
	public val entityId: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteHealthcarePartyByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteHealthcarePartyByIdParams>(params)
	runBlocking {
		sdk.healthcareParty.deleteHealthcarePartyById(
			decodedParams.entityId,
			decodedParams.rev,
		)
	}
}.toPyString(StoredDocumentIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteHealthcarePartyByIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteHealthcarePartyByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.deleteHealthcarePartyById(
				decodedParams.entityId,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(StoredDocumentIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteHealthcarePartiesByIdsParams(
	public val entityIds: List<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun deleteHealthcarePartiesByIdsBlocking(sdk: CardinalNonCryptoApis, params: String): String
		= kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteHealthcarePartiesByIdsParams>(params)
	runBlocking {
		sdk.healthcareParty.deleteHealthcarePartiesByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteHealthcarePartiesByIdsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteHealthcarePartiesByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.deleteHealthcarePartiesByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(StoredDocumentIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeHealthcarePartyByIdParams(
	public val id: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun purgeHealthcarePartyByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<PurgeHealthcarePartyByIdParams>(params)
	runBlocking {
		sdk.healthcareParty.purgeHealthcarePartyById(
			decodedParams.id,
			decodedParams.rev,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeHealthcarePartyByIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<PurgeHealthcarePartyByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.purgeHealthcarePartyById(
				decodedParams.id,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeHealthcarePartiesByIdsParams(
	public val entityIds: List<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun purgeHealthcarePartiesByIdsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<PurgeHealthcarePartiesByIdsParams>(params)
	runBlocking {
		sdk.healthcareParty.purgeHealthcarePartiesByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeHealthcarePartiesByIdsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<PurgeHealthcarePartiesByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.purgeHealthcarePartiesByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(StoredDocumentIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteHealthcarePartyByIdParams(
	public val id: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun undeleteHealthcarePartyByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteHealthcarePartyByIdParams>(params)
	runBlocking {
		sdk.healthcareParty.undeleteHealthcarePartyById(
			decodedParams.id,
			decodedParams.rev,
		)
	}
}.toPyString(HealthcareParty.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteHealthcarePartyByIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteHealthcarePartyByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.undeleteHealthcarePartyById(
				decodedParams.id,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(HealthcareParty.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteHealthcarePartiesByIdsParams(
	public val entityIds: List<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteHealthcarePartiesByIdsBlocking(sdk: CardinalNonCryptoApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteHealthcarePartiesByIdsParams>(params)
	runBlocking {
		sdk.healthcareParty.undeleteHealthcarePartiesByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(HealthcareParty.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteHealthcarePartiesByIdsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteHealthcarePartiesByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.undeleteHealthcarePartiesByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(HealthcareParty.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteHealthcarePartyParams(
	public val healthcareParty: HealthcareParty,
)

@OptIn(InternalIcureApi::class)
public fun deleteHealthcarePartyBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteHealthcarePartyParams>(params)
	runBlocking {
		sdk.healthcareParty.deleteHealthcareParty(
			decodedParams.healthcareParty,
		)
	}
}.toPyString(StoredDocumentIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteHealthcarePartyAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteHealthcarePartyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.deleteHealthcareParty(
				decodedParams.healthcareParty,
			)
		}.toPyStringAsyncCallback(StoredDocumentIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteHealthcarePartiesParams(
	public val healthcareParties: List<HealthcareParty>,
)

@OptIn(InternalIcureApi::class)
public fun deleteHealthcarePartiesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteHealthcarePartiesParams>(params)
	runBlocking {
		sdk.healthcareParty.deleteHealthcareParties(
			decodedParams.healthcareParties,
		)
	}
}.toPyString(ListSerializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteHealthcarePartiesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteHealthcarePartiesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.deleteHealthcareParties(
				decodedParams.healthcareParties,
			)
		}.toPyStringAsyncCallback(ListSerializer(StoredDocumentIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeHealthcarePartyParams(
	public val healthcareParty: HealthcareParty,
)

@OptIn(InternalIcureApi::class)
public fun purgeHealthcarePartyBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeHealthcarePartyParams>(params)
	runBlocking {
		sdk.healthcareParty.purgeHealthcareParty(
			decodedParams.healthcareParty,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeHealthcarePartyAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeHealthcarePartyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.purgeHealthcareParty(
				decodedParams.healthcareParty,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeHealthcarePartiesParams(
	public val healthcareParties: List<HealthcareParty>,
)

@OptIn(InternalIcureApi::class)
public fun purgeHealthcarePartiesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeHealthcarePartiesParams>(params)
	runBlocking {
		sdk.healthcareParty.purgeHealthcareParties(
			decodedParams.healthcareParties,
		)
	}
}.toPyString(ListSerializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeHealthcarePartiesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeHealthcarePartiesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.purgeHealthcareParties(
				decodedParams.healthcareParties,
			)
		}.toPyStringAsyncCallback(ListSerializer(StoredDocumentIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteHealthcarePartyParams(
	public val healthcareParty: HealthcareParty,
)

@OptIn(InternalIcureApi::class)
public fun undeleteHealthcarePartyBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteHealthcarePartyParams>(params)
	runBlocking {
		sdk.healthcareParty.undeleteHealthcareParty(
			decodedParams.healthcareParty,
		)
	}
}.toPyString(HealthcareParty.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteHealthcarePartyAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteHealthcarePartyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.undeleteHealthcareParty(
				decodedParams.healthcareParty,
			)
		}.toPyStringAsyncCallback(HealthcareParty.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteHealthcarePartiesParams(
	public val healthcareParties: List<HealthcareParty>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteHealthcarePartiesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteHealthcarePartiesParams>(params)
	runBlocking {
		sdk.healthcareParty.undeleteHealthcareParties(
			decodedParams.healthcareParties,
		)
	}
}.toPyString(ListSerializer(HealthcareParty.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteHealthcarePartiesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteHealthcarePartiesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.undeleteHealthcareParties(
				decodedParams.healthcareParties,
			)
		}.toPyStringAsyncCallback(ListSerializer(HealthcareParty.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SubscribeToEventsParams(
	public val events: Set<SubscriptionEventType>,
	public val filter: FilterOptions<HealthcareParty>,
	public val subscriptionConfig: EntitySubscriptionConfiguration? = null,
)

@OptIn(InternalIcureApi::class)
public fun subscribeToEventsBlocking(sdk: CardinalNonCryptoApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SubscribeToEventsParams>(params)
	runBlocking {
		sdk.healthcareParty.subscribeToEvents(
			decodedParams.events,
			decodedParams.filter,
			decodedParams.subscriptionConfig,
		)
	}
}.toPyResult {
	EntitySubscriptionWithSerializer(it, HealthcareParty.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun subscribeToEventsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SubscribeToEventsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.subscribeToEvents(
				decodedParams.events,
				decodedParams.filter,
				decodedParams.subscriptionConfig,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			EntitySubscriptionWithSerializer(it, HealthcareParty.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)
