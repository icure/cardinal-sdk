// auto-generated file
package com.icure.cardinal.sdk.py.api.CalendarItemApi.inGroup

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.CalendarItemShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.DecryptedCalendarItem
import com.icure.cardinal.sdk.model.EncryptedCalendarItem
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
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
import com.icure.cardinal.sdk.serialization.MapAsArraySerializer
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Byte
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
	public val entityGroupId: String,
	public val base: DecryptedCalendarItem?,
	public val patient: GroupScoped<Patient>?,
	public val user: User? = null,
	@Serializable(MapAsArraySerializer::class)
	@OptIn(InternalIcureApi::class)
	public val delegates: Map<EntityReferenceInGroup, AccessLevel> = emptyMap(),
	public val secretId: SecretIdUseOption =
			com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent,
	public val alternateRootDelegateReference: EntityReferenceInGroup? = null,
)

@OptIn(InternalIcureApi::class)
public fun withEncryptionMetadataBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<WithEncryptionMetadataParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.withEncryptionMetadata(
			decodedParams.entityGroupId,
			decodedParams.base,
			decodedParams.patient,
			decodedParams.user,
			decodedParams.delegates,
			decodedParams.secretId,
			decodedParams.alternateRootDelegateReference,
		)
	}
}.toPyString(GroupScoped.serializer(DecryptedCalendarItem.serializer()))

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
			sdk.calendarItem.inGroup.withEncryptionMetadata(
				decodedParams.entityGroupId,
				decodedParams.base,
				decodedParams.patient,
				decodedParams.user,
				decodedParams.delegates,
				decodedParams.secretId,
				decodedParams.alternateRootDelegateReference,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(DecryptedCalendarItem.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetEncryptionKeysOfParams(
	public val calendarItem: GroupScoped<CalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun getEncryptionKeysOfBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetEncryptionKeysOfParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.getEncryptionKeysOf(
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
			sdk.calendarItem.inGroup.getEncryptionKeysOf(
				decodedParams.calendarItem,
			)
		}.toPyStringAsyncCallback(SetSerializer(HexString.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class HasWriteAccessParams(
	public val calendarItem: GroupScoped<CalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun hasWriteAccessBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<HasWriteAccessParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.hasWriteAccess(
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
			sdk.calendarItem.inGroup.hasWriteAccess(
				decodedParams.calendarItem,
			)
		}.toPyStringAsyncCallback(Boolean.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptPatientIdOfParams(
	public val calendarItem: GroupScoped<CalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun decryptPatientIdOfBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptPatientIdOfParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.decryptPatientIdOf(
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
			sdk.calendarItem.inGroup.decryptPatientIdOf(
				decodedParams.calendarItem,
			)
		}.toPyStringAsyncCallback(SetSerializer(EntityReferenceInGroup.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateDelegationDeAnonymizationMetadataParams(
	public val entity: GroupScoped<CalendarItem>,
	public val delegates: Set<EntityReferenceInGroup>,
)

@OptIn(InternalIcureApi::class)
public fun createDelegationDeAnonymizationMetadataBlocking(sdk: CardinalApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<CreateDelegationDeAnonymizationMetadataParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.createDelegationDeAnonymizationMetadata(
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
			sdk.calendarItem.inGroup.createDelegationDeAnonymizationMetadata(
				decodedParams.entity,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptParams(
	public val calendarItems: List<GroupScoped<EncryptedCalendarItem>>,
)

@OptIn(InternalIcureApi::class)
public fun decryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.decrypt(
			decodedParams.calendarItems,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(DecryptedCalendarItem.serializer())))

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
			sdk.calendarItem.inGroup.decrypt(
				decodedParams.calendarItems,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(DecryptedCalendarItem.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryDecryptParams(
	public val calendarItems: List<GroupScoped<EncryptedCalendarItem>>,
)

@OptIn(InternalIcureApi::class)
public fun tryDecryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<TryDecryptParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.tryDecrypt(
			decodedParams.calendarItems,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(PolymorphicSerializer(CalendarItem::class))))

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
			sdk.calendarItem.inGroup.tryDecrypt(
				decodedParams.calendarItems,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(PolymorphicSerializer(CalendarItem::class))),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class EncryptOrValidateParams(
	public val calendarItems: List<GroupScoped<CalendarItem>>,
)

@OptIn(InternalIcureApi::class)
public fun encryptOrValidateBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<EncryptOrValidateParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.encryptOrValidate(
			decodedParams.calendarItems,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(EncryptedCalendarItem.serializer())))

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
			sdk.calendarItem.inGroup.encryptOrValidate(
				decodedParams.calendarItems,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(EncryptedCalendarItem.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchCalendarItemsByParams(
	public val groupId: String,
	public val filter: FilterOptions<CalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun matchCalendarItemsByBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchCalendarItemsByParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.matchCalendarItemsBy(
			decodedParams.groupId,
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
			sdk.calendarItem.inGroup.matchCalendarItemsBy(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchCalendarItemsBySortedParams(
	public val groupId: String,
	public val filter: SortableFilterOptions<CalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun matchCalendarItemsBySortedBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<MatchCalendarItemsBySortedParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.matchCalendarItemsBySorted(
			decodedParams.groupId,
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
			sdk.calendarItem.inGroup.matchCalendarItemsBySorted(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteCalendarItemByIdParams(
	public val entityId: GroupScoped<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun deleteCalendarItemByIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteCalendarItemByIdParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.deleteCalendarItemById(
			decodedParams.entityId,
		)
	}
}.toPyString(GroupScoped.serializer(StoredDocumentIdentifier.serializer()))

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
			sdk.calendarItem.inGroup.deleteCalendarItemById(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(StoredDocumentIdentifier.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteCalendarItemsByIdsParams(
	public val entityIds: List<GroupScoped<StoredDocumentIdentifier>>,
)

@OptIn(InternalIcureApi::class)
public fun deleteCalendarItemsByIdsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteCalendarItemsByIdsParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.deleteCalendarItemsByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

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
			sdk.calendarItem.inGroup.deleteCalendarItemsByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteCalendarItemParams(
	public val calendarItem: GroupScoped<CalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun deleteCalendarItemBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteCalendarItemParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.deleteCalendarItem(
			decodedParams.calendarItem,
		)
	}
}.toPyString(GroupScoped.serializer(StoredDocumentIdentifier.serializer()))

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
			sdk.calendarItem.inGroup.deleteCalendarItem(
				decodedParams.calendarItem,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(StoredDocumentIdentifier.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteCalendarItemsParams(
	public val calendarItems: List<GroupScoped<CalendarItem>>,
)

@OptIn(InternalIcureApi::class)
public fun deleteCalendarItemsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteCalendarItemsParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.deleteCalendarItems(
			decodedParams.calendarItems,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

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
			sdk.calendarItem.inGroup.deleteCalendarItems(
				decodedParams.calendarItems,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithParams(
	public val `delegate`: EntityReferenceInGroup,
	public val calendarItem: GroupScoped<DecryptedCalendarItem>,
	public val options: CalendarItemShareOptions? = null,
)

@OptIn(InternalIcureApi::class)
public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.shareWith(
			decodedParams.delegate,
			decodedParams.calendarItem,
			decodedParams.options,
		)
	}
}.toPyString(GroupScoped.serializer(DecryptedCalendarItem.serializer()))

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
			sdk.calendarItem.inGroup.shareWith(
				decodedParams.delegate,
				decodedParams.calendarItem,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(DecryptedCalendarItem.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val calendarItem: GroupScoped<DecryptedCalendarItem>,
	@Serializable(MapAsArraySerializer::class)
	@OptIn(InternalIcureApi::class)
	public val delegates: Map<EntityReferenceInGroup, CalendarItemShareOptions>,
)

@OptIn(InternalIcureApi::class)
public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.shareWithMany(
			decodedParams.calendarItem,
			decodedParams.delegates,
		)
	}
}.toPyString(GroupScoped.serializer(DecryptedCalendarItem.serializer()))

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
			sdk.calendarItem.inGroup.shareWithMany(
				decodedParams.calendarItem,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(DecryptedCalendarItem.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterCalendarItemsByParams(
	public val groupId: String,
	public val filter: FilterOptions<CalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun filterCalendarItemsByBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterCalendarItemsByParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.filterCalendarItemsBy(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it,
			GroupScoped.serializer(DecryptedCalendarItem.serializer()))}

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
			sdk.calendarItem.inGroup.filterCalendarItemsBy(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it,
					GroupScoped.serializer(DecryptedCalendarItem.serializer()))}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterCalendarItemsBySortedParams(
	public val groupId: String,
	public val filter: SortableFilterOptions<CalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun filterCalendarItemsBySortedBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterCalendarItemsBySortedParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.filterCalendarItemsBySorted(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it,
			GroupScoped.serializer(DecryptedCalendarItem.serializer()))}

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
			sdk.calendarItem.inGroup.filterCalendarItemsBySorted(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it,
					GroupScoped.serializer(DecryptedCalendarItem.serializer()))}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class CreateCalendarItemParams(
	public val entity: GroupScoped<DecryptedCalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun createCalendarItemBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateCalendarItemParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.createCalendarItem(
			decodedParams.entity,
		)
	}
}.toPyString(GroupScoped.serializer(DecryptedCalendarItem.serializer()))

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
			sdk.calendarItem.inGroup.createCalendarItem(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(DecryptedCalendarItem.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyCalendarItemParams(
	public val entity: GroupScoped<DecryptedCalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun modifyCalendarItemBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyCalendarItemParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.modifyCalendarItem(
			decodedParams.entity,
		)
	}
}.toPyString(GroupScoped.serializer(DecryptedCalendarItem.serializer()))

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
			sdk.calendarItem.inGroup.modifyCalendarItem(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(DecryptedCalendarItem.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCalendarItemParams(
	public val groupId: String,
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun getCalendarItemBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCalendarItemParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.getCalendarItem(
			decodedParams.groupId,
			decodedParams.entityId,
		)
	}
}.toPyString(GroupScoped.serializer(DecryptedCalendarItem.serializer()))

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
			sdk.calendarItem.inGroup.getCalendarItem(
				decodedParams.groupId,
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(DecryptedCalendarItem.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCalendarItemsParams(
	public val groupId: String,
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getCalendarItemsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCalendarItemsParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.getCalendarItems(
			decodedParams.groupId,
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(DecryptedCalendarItem.serializer())))

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
			sdk.calendarItem.inGroup.getCalendarItems(
				decodedParams.groupId,
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(DecryptedCalendarItem.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
