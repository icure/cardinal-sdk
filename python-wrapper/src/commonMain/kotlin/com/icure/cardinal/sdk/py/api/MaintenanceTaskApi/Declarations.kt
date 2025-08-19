// auto-generated file
package com.icure.cardinal.sdk.py.api.MaintenanceTaskApi

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.MaintenanceTaskShareOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.DecryptedMaintenanceTask
import com.icure.cardinal.sdk.model.EncryptedMaintenanceTask
import com.icure.cardinal.sdk.model.MaintenanceTask
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
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
	public val maintenanceTask: DecryptedMaintenanceTask?,
	public val user: User? = null,
	public val delegates: Map<String, AccessLevel> = emptyMap(),
	public val alternateRootDelegateId: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun withEncryptionMetadataBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<WithEncryptionMetadataParams>(params)
	runBlocking {
		sdk.maintenanceTask.withEncryptionMetadata(
			decodedParams.maintenanceTask,
			decodedParams.user,
			decodedParams.delegates,
			decodedParams.alternateRootDelegateId,
		)
	}
}.toPyString(DecryptedMaintenanceTask.serializer())

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
			sdk.maintenanceTask.withEncryptionMetadata(
				decodedParams.maintenanceTask,
				decodedParams.user,
				decodedParams.delegates,
				decodedParams.alternateRootDelegateId,
			)
		}.toPyStringAsyncCallback(DecryptedMaintenanceTask.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetEncryptionKeysOfParams(
	public val maintenanceTask: MaintenanceTask,
)

@OptIn(InternalIcureApi::class)
public fun getEncryptionKeysOfBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetEncryptionKeysOfParams>(params)
	runBlocking {
		sdk.maintenanceTask.getEncryptionKeysOf(
			decodedParams.maintenanceTask,
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
			sdk.maintenanceTask.getEncryptionKeysOf(
				decodedParams.maintenanceTask,
			)
		}.toPyStringAsyncCallback(SetSerializer(HexString.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class HasWriteAccessParams(
	public val maintenanceTask: MaintenanceTask,
)

@OptIn(InternalIcureApi::class)
public fun hasWriteAccessBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<HasWriteAccessParams>(params)
	runBlocking {
		sdk.maintenanceTask.hasWriteAccess(
			decodedParams.maintenanceTask,
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
			sdk.maintenanceTask.hasWriteAccess(
				decodedParams.maintenanceTask,
			)
		}.toPyStringAsyncCallback(Boolean.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptPatientIdOfParams(
	public val maintenanceTask: MaintenanceTask,
)

@OptIn(InternalIcureApi::class)
public fun decryptPatientIdOfBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptPatientIdOfParams>(params)
	runBlocking {
		sdk.maintenanceTask.decryptPatientIdOf(
			decodedParams.maintenanceTask,
		)
	}
}.toPyString(SetSerializer(String.serializer()))

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
			sdk.maintenanceTask.decryptPatientIdOf(
				decodedParams.maintenanceTask,
			)
		}.toPyStringAsyncCallback(SetSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateDelegationDeAnonymizationMetadataParams(
	public val entity: MaintenanceTask,
	public val delegates: Set<String>,
)

@OptIn(InternalIcureApi::class)
public fun createDelegationDeAnonymizationMetadataBlocking(sdk: CardinalApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<CreateDelegationDeAnonymizationMetadataParams>(params)
	runBlocking {
		sdk.maintenanceTask.createDelegationDeAnonymizationMetadata(
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
			sdk.maintenanceTask.createDelegationDeAnonymizationMetadata(
				decodedParams.entity,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptParams(
	public val maintenanceTask: EncryptedMaintenanceTask,
)

@OptIn(InternalIcureApi::class)
public fun decryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptParams>(params)
	runBlocking {
		sdk.maintenanceTask.decrypt(
			decodedParams.maintenanceTask,
		)
	}
}.toPyString(DecryptedMaintenanceTask.serializer())

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
			sdk.maintenanceTask.decrypt(
				decodedParams.maintenanceTask,
			)
		}.toPyStringAsyncCallback(DecryptedMaintenanceTask.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryDecryptParams(
	public val maintenanceTask: EncryptedMaintenanceTask,
)

@OptIn(InternalIcureApi::class)
public fun tryDecryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<TryDecryptParams>(params)
	runBlocking {
		sdk.maintenanceTask.tryDecrypt(
			decodedParams.maintenanceTask,
		)
	}
}.toPyString(PolymorphicSerializer(MaintenanceTask::class))

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
			sdk.maintenanceTask.tryDecrypt(
				decodedParams.maintenanceTask,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(MaintenanceTask::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchMaintenanceTasksByParams(
	public val filter: FilterOptions<MaintenanceTask>,
)

@OptIn(InternalIcureApi::class)
public fun matchMaintenanceTasksByBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchMaintenanceTasksByParams>(params)
	runBlocking {
		sdk.maintenanceTask.matchMaintenanceTasksBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchMaintenanceTasksByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchMaintenanceTasksByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.matchMaintenanceTasksBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchMaintenanceTasksBySortedParams(
	public val filter: SortableFilterOptions<MaintenanceTask>,
)

@OptIn(InternalIcureApi::class)
public fun matchMaintenanceTasksBySortedBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<MatchMaintenanceTasksBySortedParams>(params)
	runBlocking {
		sdk.maintenanceTask.matchMaintenanceTasksBySorted(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchMaintenanceTasksBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<MatchMaintenanceTasksBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.matchMaintenanceTasksBySorted(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteMaintenanceTaskUnsafeParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteMaintenanceTaskUnsafeBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteMaintenanceTaskUnsafeParams>(params)
	runBlocking {
		sdk.maintenanceTask.deleteMaintenanceTaskUnsafe(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteMaintenanceTaskUnsafeAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteMaintenanceTaskUnsafeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.deleteMaintenanceTaskUnsafe(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteMaintenanceTasksUnsafeParams(
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun deleteMaintenanceTasksUnsafeBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteMaintenanceTasksUnsafeParams>(params)
	runBlocking {
		sdk.maintenanceTask.deleteMaintenanceTasksUnsafe(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteMaintenanceTasksUnsafeAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteMaintenanceTasksUnsafeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.deleteMaintenanceTasksUnsafe(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteMaintenanceTaskByIdParams(
	public val entityId: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteMaintenanceTaskByIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteMaintenanceTaskByIdParams>(params)
	runBlocking {
		sdk.maintenanceTask.deleteMaintenanceTaskById(
			decodedParams.entityId,
			decodedParams.rev,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteMaintenanceTaskByIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteMaintenanceTaskByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.deleteMaintenanceTaskById(
				decodedParams.entityId,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteMaintenanceTasksByIdsParams(
	public val entityIds: List<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun deleteMaintenanceTasksByIdsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteMaintenanceTasksByIdsParams>(params)
	runBlocking {
		sdk.maintenanceTask.deleteMaintenanceTasksByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteMaintenanceTasksByIdsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteMaintenanceTasksByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.deleteMaintenanceTasksByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeMaintenanceTaskByIdParams(
	public val id: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun purgeMaintenanceTaskByIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<PurgeMaintenanceTaskByIdParams>(params)
	runBlocking {
		sdk.maintenanceTask.purgeMaintenanceTaskById(
			decodedParams.id,
			decodedParams.rev,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeMaintenanceTaskByIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<PurgeMaintenanceTaskByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.purgeMaintenanceTaskById(
				decodedParams.id,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteMaintenanceTaskParams(
	public val maintenanceTask: MaintenanceTask,
)

@OptIn(InternalIcureApi::class)
public fun deleteMaintenanceTaskBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteMaintenanceTaskParams>(params)
	runBlocking {
		sdk.maintenanceTask.deleteMaintenanceTask(
			decodedParams.maintenanceTask,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteMaintenanceTaskAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteMaintenanceTaskParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.deleteMaintenanceTask(
				decodedParams.maintenanceTask,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteMaintenanceTasksParams(
	public val maintenanceTasks: List<MaintenanceTask>,
)

@OptIn(InternalIcureApi::class)
public fun deleteMaintenanceTasksBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteMaintenanceTasksParams>(params)
	runBlocking {
		sdk.maintenanceTask.deleteMaintenanceTasks(
			decodedParams.maintenanceTasks,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteMaintenanceTasksAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteMaintenanceTasksParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.deleteMaintenanceTasks(
				decodedParams.maintenanceTasks,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeMaintenanceTaskParams(
	public val maintenanceTask: MaintenanceTask,
)

@OptIn(InternalIcureApi::class)
public fun purgeMaintenanceTaskBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeMaintenanceTaskParams>(params)
	runBlocking {
		sdk.maintenanceTask.purgeMaintenanceTask(
			decodedParams.maintenanceTask,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeMaintenanceTaskAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeMaintenanceTaskParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.purgeMaintenanceTask(
				decodedParams.maintenanceTask,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithParams(
	public val delegateId: String,
	public val maintenanceTask: DecryptedMaintenanceTask,
	public val options: MaintenanceTaskShareOptions? = null,
)

@OptIn(InternalIcureApi::class)
public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.maintenanceTask.shareWith(
			decodedParams.delegateId,
			decodedParams.maintenanceTask,
			decodedParams.options,
		)
	}
}.toPyString(DecryptedMaintenanceTask.serializer())

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
			sdk.maintenanceTask.shareWith(
				decodedParams.delegateId,
				decodedParams.maintenanceTask,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(DecryptedMaintenanceTask.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val maintenanceTask: DecryptedMaintenanceTask,
	public val delegates: Map<String, MaintenanceTaskShareOptions>,
)

@OptIn(InternalIcureApi::class)
public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.maintenanceTask.shareWithMany(
			decodedParams.maintenanceTask,
			decodedParams.delegates,
		)
	}
}.toPyString(DecryptedMaintenanceTask.serializer())

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
			sdk.maintenanceTask.shareWithMany(
				decodedParams.maintenanceTask,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(DecryptedMaintenanceTask.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterMaintenanceTasksByParams(
	public val filter: FilterOptions<MaintenanceTask>,
)

@OptIn(InternalIcureApi::class)
public fun filterMaintenanceTasksByBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterMaintenanceTasksByParams>(params)
	runBlocking {
		sdk.maintenanceTask.filterMaintenanceTasksBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, DecryptedMaintenanceTask.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterMaintenanceTasksByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterMaintenanceTasksByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.filterMaintenanceTasksBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, DecryptedMaintenanceTask.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterMaintenanceTasksBySortedParams(
	public val filter: SortableFilterOptions<MaintenanceTask>,
)

@OptIn(InternalIcureApi::class)
public fun filterMaintenanceTasksBySortedBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterMaintenanceTasksBySortedParams>(params)
	runBlocking {
		sdk.maintenanceTask.filterMaintenanceTasksBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, DecryptedMaintenanceTask.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterMaintenanceTasksBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterMaintenanceTasksBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.filterMaintenanceTasksBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, DecryptedMaintenanceTask.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class CreateMaintenanceTaskParams(
	public val entity: DecryptedMaintenanceTask,
)

@OptIn(InternalIcureApi::class)
public fun createMaintenanceTaskBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateMaintenanceTaskParams>(params)
	runBlocking {
		sdk.maintenanceTask.createMaintenanceTask(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedMaintenanceTask.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createMaintenanceTaskAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateMaintenanceTaskParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.createMaintenanceTask(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(DecryptedMaintenanceTask.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteMaintenanceTaskParams(
	public val maintenanceTask: MaintenanceTask,
)

@OptIn(InternalIcureApi::class)
public fun undeleteMaintenanceTaskBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteMaintenanceTaskParams>(params)
	runBlocking {
		sdk.maintenanceTask.undeleteMaintenanceTask(
			decodedParams.maintenanceTask,
		)
	}
}.toPyString(PolymorphicSerializer(MaintenanceTask::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteMaintenanceTaskAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteMaintenanceTaskParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.undeleteMaintenanceTask(
				decodedParams.maintenanceTask,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(MaintenanceTask::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteMaintenanceTaskByIdParams(
	public val id: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun undeleteMaintenanceTaskByIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteMaintenanceTaskByIdParams>(params)
	runBlocking {
		sdk.maintenanceTask.undeleteMaintenanceTaskById(
			decodedParams.id,
			decodedParams.rev,
		)
	}
}.toPyString(DecryptedMaintenanceTask.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteMaintenanceTaskByIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteMaintenanceTaskByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.undeleteMaintenanceTaskById(
				decodedParams.id,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(DecryptedMaintenanceTask.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyMaintenanceTaskParams(
	public val entity: DecryptedMaintenanceTask,
)

@OptIn(InternalIcureApi::class)
public fun modifyMaintenanceTaskBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyMaintenanceTaskParams>(params)
	runBlocking {
		sdk.maintenanceTask.modifyMaintenanceTask(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedMaintenanceTask.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyMaintenanceTaskAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyMaintenanceTaskParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.modifyMaintenanceTask(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(DecryptedMaintenanceTask.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetMaintenanceTaskParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun getMaintenanceTaskBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetMaintenanceTaskParams>(params)
	runBlocking {
		sdk.maintenanceTask.getMaintenanceTask(
			decodedParams.entityId,
		)
	}
}.toPyString(DecryptedMaintenanceTask.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getMaintenanceTaskAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetMaintenanceTaskParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.getMaintenanceTask(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DecryptedMaintenanceTask.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetMaintenanceTasksParams(
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getMaintenanceTasksBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetMaintenanceTasksParams>(params)
	runBlocking {
		sdk.maintenanceTask.getMaintenanceTasks(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DecryptedMaintenanceTask.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getMaintenanceTasksAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetMaintenanceTasksParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.getMaintenanceTasks(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedMaintenanceTask.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SubscribeToEventsParams(
	public val events: Set<SubscriptionEventType>,
	public val filter: FilterOptions<MaintenanceTask>,
	public val subscriptionConfig: EntitySubscriptionConfiguration? = null,
)

@OptIn(InternalIcureApi::class)
public fun subscribeToEventsBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SubscribeToEventsParams>(params)
	runBlocking {
		sdk.maintenanceTask.subscribeToEvents(
			decodedParams.events,
			decodedParams.filter,
			decodedParams.subscriptionConfig,
		)
	}
}.toPyResult {
	EntitySubscriptionWithSerializer(it, EncryptedMaintenanceTask.serializer())}

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
			sdk.maintenanceTask.subscribeToEvents(
				decodedParams.events,
				decodedParams.filter,
				decodedParams.subscriptionConfig,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			EntitySubscriptionWithSerializer(it, EncryptedMaintenanceTask.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)
