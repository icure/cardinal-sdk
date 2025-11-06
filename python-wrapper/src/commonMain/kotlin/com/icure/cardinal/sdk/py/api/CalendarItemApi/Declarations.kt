// auto-generated file
package com.icure.cardinal.sdk.py.api.CalendarItemApi

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.CalendarItemShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.DecryptedCalendarItem
import com.icure.cardinal.sdk.model.EncryptedCalendarItem
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
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
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
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
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.builtins.serializer

@Serializable
private class WithEncryptionMetadataParams(
	public val base: DecryptedCalendarItem?,
	public val patient: Patient?,
	public val user: User? = null,
	public val delegates: Map<String, AccessLevel> = emptyMap(),
	public val secretId: SecretIdUseOption =
			com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent,
	public val alternateRootDelegateId: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun withEncryptionMetadataBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<WithEncryptionMetadataParams>(params)
	runBlocking {
		sdk.calendarItem.withEncryptionMetadata(
			decodedParams.base,
			decodedParams.patient,
			decodedParams.user,
			decodedParams.delegates,
			decodedParams.secretId,
			decodedParams.alternateRootDelegateId,
		)
	}
}.toPyString(DecryptedCalendarItem.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun withEncryptionMetadataAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<WithEncryptionMetadataParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.withEncryptionMetadata(
				decodedParams.base,
				decodedParams.patient,
				decodedParams.user,
				decodedParams.delegates,
				decodedParams.secretId,
				decodedParams.alternateRootDelegateId,
			)
		}.toPyStringAsyncCallback(DecryptedCalendarItem.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetEncryptionKeysOfParams(
	public val calendarItem: CalendarItem,
)

@OptIn(InternalIcureApi::class)
public fun getEncryptionKeysOfBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetEncryptionKeysOfParams>(params)
	runBlocking {
		sdk.calendarItem.getEncryptionKeysOf(
			decodedParams.calendarItem,
		)
	}
}.toPyString(SetSerializer(HexString.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getEncryptionKeysOfAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetEncryptionKeysOfParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.getEncryptionKeysOf(
				decodedParams.calendarItem,
			)
		}.toPyStringAsyncCallback(SetSerializer(HexString.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class HasWriteAccessParams(
	public val calendarItem: CalendarItem,
)

@OptIn(InternalIcureApi::class)
public fun hasWriteAccessBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<HasWriteAccessParams>(params)
	runBlocking {
		sdk.calendarItem.hasWriteAccess(
			decodedParams.calendarItem,
		)
	}
}.toPyString(Boolean.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun hasWriteAccessAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<HasWriteAccessParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.hasWriteAccess(
				decodedParams.calendarItem,
			)
		}.toPyStringAsyncCallback(Boolean.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptPatientIdOfParams(
	public val calendarItem: CalendarItem,
)

@OptIn(InternalIcureApi::class)
public fun decryptPatientIdOfBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptPatientIdOfParams>(params)
	runBlocking {
		sdk.calendarItem.decryptPatientIdOf(
			decodedParams.calendarItem,
		)
	}
}.toPyString(SetSerializer(EntityReferenceInGroup.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun decryptPatientIdOfAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptPatientIdOfParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.decryptPatientIdOf(
				decodedParams.calendarItem,
			)
		}.toPyStringAsyncCallback(SetSerializer(EntityReferenceInGroup.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateDelegationDeAnonymizationMetadataParams(
	public val entity: CalendarItem,
	public val delegates: Set<String>,
)

@OptIn(InternalIcureApi::class)
public fun createDelegationDeAnonymizationMetadataBlocking(sdk: CardinalApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<CreateDelegationDeAnonymizationMetadataParams>(params)
	runBlocking {
		sdk.calendarItem.createDelegationDeAnonymizationMetadata(
			decodedParams.entity,
			decodedParams.delegates,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createDelegationDeAnonymizationMetadataAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<CreateDelegationDeAnonymizationMetadataParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.createDelegationDeAnonymizationMetadata(
				decodedParams.entity,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptParams(
	public val calendarItems: List<EncryptedCalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun decryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptParams>(params)
	runBlocking {
		sdk.calendarItem.decrypt(
			decodedParams.calendarItems,
		)
	}
}.toPyString(ListSerializer(DecryptedCalendarItem.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun decryptAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.decrypt(
				decodedParams.calendarItems,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedCalendarItem.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryDecryptParams(
	public val calendarItems: List<EncryptedCalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun tryDecryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<TryDecryptParams>(params)
	runBlocking {
		sdk.calendarItem.tryDecrypt(
			decodedParams.calendarItems,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(CalendarItem::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun tryDecryptAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<TryDecryptParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.tryDecrypt(
				decodedParams.calendarItems,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(CalendarItem::class)),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class EncryptOrValidateParams(
	public val calendarItems: List<CalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun encryptOrValidateBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<EncryptOrValidateParams>(params)
	runBlocking {
		sdk.calendarItem.encryptOrValidate(
			decodedParams.calendarItems,
		)
	}
}.toPyString(ListSerializer(EncryptedCalendarItem.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun encryptOrValidateAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<EncryptOrValidateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.encryptOrValidate(
				decodedParams.calendarItems,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedCalendarItem.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchCalendarItemsByParams(
	public val filter: FilterOptions<CalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun matchCalendarItemsByBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchCalendarItemsByParams>(params)
	runBlocking {
		sdk.calendarItem.matchCalendarItemsBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchCalendarItemsByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchCalendarItemsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.matchCalendarItemsBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchCalendarItemsBySortedParams(
	public val filter: SortableFilterOptions<CalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun matchCalendarItemsBySortedBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<MatchCalendarItemsBySortedParams>(params)
	runBlocking {
		sdk.calendarItem.matchCalendarItemsBySorted(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchCalendarItemsBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<MatchCalendarItemsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.matchCalendarItemsBySorted(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteCalendarItemUnsafeParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteCalendarItemUnsafeBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteCalendarItemUnsafeParams>(params)
	runBlocking {
		sdk.calendarItem.deleteCalendarItemUnsafe(
			decodedParams.entityId,
		)
	}
}.toPyString(StoredDocumentIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteCalendarItemUnsafeAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteCalendarItemUnsafeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.deleteCalendarItemUnsafe(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(StoredDocumentIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteCalendarItemsUnsafeParams(
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun deleteCalendarItemsUnsafeBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteCalendarItemsUnsafeParams>(params)
	runBlocking {
		sdk.calendarItem.deleteCalendarItemsUnsafe(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteCalendarItemsUnsafeAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteCalendarItemsUnsafeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.deleteCalendarItemsUnsafe(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(StoredDocumentIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteCalendarItemByIdParams(
	public val entityId: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteCalendarItemByIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteCalendarItemByIdParams>(params)
	runBlocking {
		sdk.calendarItem.deleteCalendarItemById(
			decodedParams.entityId,
			decodedParams.rev,
		)
	}
}.toPyString(StoredDocumentIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteCalendarItemByIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteCalendarItemByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.deleteCalendarItemById(
				decodedParams.entityId,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(StoredDocumentIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteCalendarItemsByIdsParams(
	public val entityIds: List<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun deleteCalendarItemsByIdsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteCalendarItemsByIdsParams>(params)
	runBlocking {
		sdk.calendarItem.deleteCalendarItemsByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteCalendarItemsByIdsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteCalendarItemsByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.deleteCalendarItemsByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(StoredDocumentIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeCalendarItemByIdParams(
	public val id: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun purgeCalendarItemByIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeCalendarItemByIdParams>(params)
	runBlocking {
		sdk.calendarItem.purgeCalendarItemById(
			decodedParams.id,
			decodedParams.rev,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeCalendarItemByIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeCalendarItemByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.purgeCalendarItemById(
				decodedParams.id,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteCalendarItemParams(
	public val calendarItem: CalendarItem,
)

@OptIn(InternalIcureApi::class)
public fun deleteCalendarItemBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteCalendarItemParams>(params)
	runBlocking {
		sdk.calendarItem.deleteCalendarItem(
			decodedParams.calendarItem,
		)
	}
}.toPyString(StoredDocumentIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteCalendarItemAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteCalendarItemParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.deleteCalendarItem(
				decodedParams.calendarItem,
			)
		}.toPyStringAsyncCallback(StoredDocumentIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteCalendarItemsParams(
	public val calendarItems: List<CalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun deleteCalendarItemsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteCalendarItemsParams>(params)
	runBlocking {
		sdk.calendarItem.deleteCalendarItems(
			decodedParams.calendarItems,
		)
	}
}.toPyString(ListSerializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteCalendarItemsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteCalendarItemsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.deleteCalendarItems(
				decodedParams.calendarItems,
			)
		}.toPyStringAsyncCallback(ListSerializer(StoredDocumentIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeCalendarItemParams(
	public val calendarItem: CalendarItem,
)

@OptIn(InternalIcureApi::class)
public fun purgeCalendarItemBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeCalendarItemParams>(params)
	runBlocking {
		sdk.calendarItem.purgeCalendarItem(
			decodedParams.calendarItem,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeCalendarItemAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeCalendarItemParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.purgeCalendarItem(
				decodedParams.calendarItem,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithParams(
	public val delegateId: String,
	public val calendarItem: DecryptedCalendarItem,
	public val options: CalendarItemShareOptions? = null,
)

@OptIn(InternalIcureApi::class)
public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.calendarItem.shareWith(
			decodedParams.delegateId,
			decodedParams.calendarItem,
			decodedParams.options,
		)
	}
}.toPyString(DecryptedCalendarItem.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun shareWithAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.shareWith(
				decodedParams.delegateId,
				decodedParams.calendarItem,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(DecryptedCalendarItem.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val calendarItem: DecryptedCalendarItem,
	public val delegates: Map<String, CalendarItemShareOptions>,
)

@OptIn(InternalIcureApi::class)
public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.calendarItem.shareWithMany(
			decodedParams.calendarItem,
			decodedParams.delegates,
		)
	}
}.toPyString(DecryptedCalendarItem.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun shareWithManyAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.shareWithMany(
				decodedParams.calendarItem,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(DecryptedCalendarItem.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindCalendarItemsByHcPartyPatientParams(
	public val hcPartyId: String,
	public val patient: Patient,
	public val startDate: Long? = null,
	public val endDate: Long? = null,
	public val descending: Boolean? = null,
)

@OptIn(InternalIcureApi::class)
public fun findCalendarItemsByHcPartyPatientBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindCalendarItemsByHcPartyPatientParams>(params)
	runBlocking {
		sdk.calendarItem.findCalendarItemsByHcPartyPatient(
			decodedParams.hcPartyId,
			decodedParams.patient,
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.descending,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, DecryptedCalendarItem.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findCalendarItemsByHcPartyPatientAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindCalendarItemsByHcPartyPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.findCalendarItemsByHcPartyPatient(
				decodedParams.hcPartyId,
				decodedParams.patient,
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.descending,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, DecryptedCalendarItem.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class LinkToPatientParams(
	public val calendarItem: CalendarItem,
	public val patient: Patient,
	public val shareLinkWithDelegates: Set<String>,
)

@OptIn(InternalIcureApi::class)
public fun linkToPatientBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<LinkToPatientParams>(params)
	runBlocking {
		sdk.calendarItem.linkToPatient(
			decodedParams.calendarItem,
			decodedParams.patient,
			decodedParams.shareLinkWithDelegates,
		)
	}
}.toPyString(DecryptedCalendarItem.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun linkToPatientAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<LinkToPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.linkToPatient(
				decodedParams.calendarItem,
				decodedParams.patient,
				decodedParams.shareLinkWithDelegates,
			)
		}.toPyStringAsyncCallback(DecryptedCalendarItem.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterCalendarItemsByParams(
	public val filter: FilterOptions<CalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun filterCalendarItemsByBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterCalendarItemsByParams>(params)
	runBlocking {
		sdk.calendarItem.filterCalendarItemsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, DecryptedCalendarItem.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterCalendarItemsByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterCalendarItemsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.filterCalendarItemsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, DecryptedCalendarItem.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterCalendarItemsBySortedParams(
	public val filter: SortableFilterOptions<CalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun filterCalendarItemsBySortedBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterCalendarItemsBySortedParams>(params)
	runBlocking {
		sdk.calendarItem.filterCalendarItemsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, DecryptedCalendarItem.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterCalendarItemsBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterCalendarItemsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.filterCalendarItemsBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, DecryptedCalendarItem.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class CreateCalendarItemParams(
	public val entity: DecryptedCalendarItem,
)

@OptIn(InternalIcureApi::class)
public fun createCalendarItemBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateCalendarItemParams>(params)
	runBlocking {
		sdk.calendarItem.createCalendarItem(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedCalendarItem.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createCalendarItemAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateCalendarItemParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.createCalendarItem(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(DecryptedCalendarItem.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class BookCalendarItemCheckingAvailabilityParams(
	public val entity: DecryptedCalendarItem,
)

@OptIn(InternalIcureApi::class)
public fun bookCalendarItemCheckingAvailabilityBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<BookCalendarItemCheckingAvailabilityParams>(params)
	runBlocking {
		sdk.calendarItem.bookCalendarItemCheckingAvailability(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedCalendarItem.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun bookCalendarItemCheckingAvailabilityAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<BookCalendarItemCheckingAvailabilityParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.bookCalendarItemCheckingAvailability(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(DecryptedCalendarItem.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteCalendarItemByIdParams(
	public val id: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun undeleteCalendarItemByIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteCalendarItemByIdParams>(params)
	runBlocking {
		sdk.calendarItem.undeleteCalendarItemById(
			decodedParams.id,
			decodedParams.rev,
		)
	}
}.toPyString(DecryptedCalendarItem.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteCalendarItemByIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteCalendarItemByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.undeleteCalendarItemById(
				decodedParams.id,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(DecryptedCalendarItem.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteCalendarItemParams(
	public val calendarItem: CalendarItem,
)

@OptIn(InternalIcureApi::class)
public fun undeleteCalendarItemBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteCalendarItemParams>(params)
	runBlocking {
		sdk.calendarItem.undeleteCalendarItem(
			decodedParams.calendarItem,
		)
	}
}.toPyString(DecryptedCalendarItem.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteCalendarItemAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteCalendarItemParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.undeleteCalendarItem(
				decodedParams.calendarItem,
			)
		}.toPyStringAsyncCallback(DecryptedCalendarItem.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyCalendarItemParams(
	public val entity: DecryptedCalendarItem,
)

@OptIn(InternalIcureApi::class)
public fun modifyCalendarItemBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyCalendarItemParams>(params)
	runBlocking {
		sdk.calendarItem.modifyCalendarItem(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedCalendarItem.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyCalendarItemAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyCalendarItemParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.modifyCalendarItem(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(DecryptedCalendarItem.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCalendarItemParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun getCalendarItemBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCalendarItemParams>(params)
	runBlocking {
		sdk.calendarItem.getCalendarItem(
			decodedParams.entityId,
		)
	}
}.toPyString(DecryptedCalendarItem.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getCalendarItemAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCalendarItemParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.getCalendarItem(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DecryptedCalendarItem.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCalendarItemsParams(
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getCalendarItemsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCalendarItemsParams>(params)
	runBlocking {
		sdk.calendarItem.getCalendarItems(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DecryptedCalendarItem.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getCalendarItemsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCalendarItemsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.getCalendarItems(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedCalendarItem.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCalendarItemsByPeriodAndHcPartyIdParams(
	public val startDate: Long,
	public val endDate: Long,
	public val hcPartyId: String,
)

@OptIn(InternalIcureApi::class)
public fun getCalendarItemsByPeriodAndHcPartyIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetCalendarItemsByPeriodAndHcPartyIdParams>(params)
	runBlocking {
		sdk.calendarItem.getCalendarItemsByPeriodAndHcPartyId(
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.hcPartyId,
		)
	}
}.toPyString(ListSerializer(DecryptedCalendarItem.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getCalendarItemsByPeriodAndHcPartyIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetCalendarItemsByPeriodAndHcPartyIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.getCalendarItemsByPeriodAndHcPartyId(
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.hcPartyId,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedCalendarItem.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCalendarsByPeriodAndAgendaIdParams(
	public val startDate: Long,
	public val endDate: Long,
	public val agendaId: String,
)

@OptIn(InternalIcureApi::class)
public fun getCalendarsByPeriodAndAgendaIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetCalendarsByPeriodAndAgendaIdParams>(params)
	runBlocking {
		sdk.calendarItem.getCalendarsByPeriodAndAgendaId(
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.agendaId,
		)
	}
}.toPyString(ListSerializer(DecryptedCalendarItem.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getCalendarsByPeriodAndAgendaIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetCalendarsByPeriodAndAgendaIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.getCalendarsByPeriodAndAgendaId(
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.agendaId,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedCalendarItem.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindCalendarItemsByRecurrenceIdParams(
	public val recurrenceId: String,
	public val startKey: String?,
	public val startDocumentId: String?,
	public val limit: Int,
)

@OptIn(InternalIcureApi::class)
public fun findCalendarItemsByRecurrenceIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindCalendarItemsByRecurrenceIdParams>(params)
	runBlocking {
		sdk.calendarItem.findCalendarItemsByRecurrenceId(
			decodedParams.recurrenceId,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(DecryptedCalendarItem.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findCalendarItemsByRecurrenceIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindCalendarItemsByRecurrenceIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.findCalendarItemsByRecurrenceId(
				decodedParams.recurrenceId,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(DecryptedCalendarItem.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SubscribeToEventsParams(
	public val events: Set<SubscriptionEventType>,
	public val filter: FilterOptions<CalendarItem>,
	public val subscriptionConfig: EntitySubscriptionConfiguration? = null,
)

@OptIn(InternalIcureApi::class)
public fun subscribeToEventsBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SubscribeToEventsParams>(params)
	runBlocking {
		sdk.calendarItem.subscribeToEvents(
			decodedParams.events,
			decodedParams.filter,
			decodedParams.subscriptionConfig,
		)
	}
}.toPyResult {
	EntitySubscriptionWithSerializer(it, EncryptedCalendarItem.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun subscribeToEventsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SubscribeToEventsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.subscribeToEvents(
				decodedParams.events,
				decodedParams.filter,
				decodedParams.subscriptionConfig,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			EntitySubscriptionWithSerializer(it, EncryptedCalendarItem.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)
