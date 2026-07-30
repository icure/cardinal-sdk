// auto-generated file
package com.icure.cardinal.sdk.py.api.RelatedPersonApi

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.RelatedPersonDelegateOptions
import com.icure.cardinal.sdk.crypto.entities.RelatedPersonShareOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.DecryptedRelatedPerson
import com.icure.cardinal.sdk.model.EncryptedRelatedPerson
import com.icure.cardinal.sdk.model.RelatedPerson
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
	public val base: DecryptedRelatedPerson?,
	public val user: User? = null,
	public val delegates: Map<String, AccessLevel> = emptyMap(),
	public val alternateRootDelegateId: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun withEncryptionMetadataBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<WithEncryptionMetadataParams>(params)
	runBlocking {
		sdk.relatedPerson.withEncryptionMetadata(
			decodedParams.base,
			decodedParams.user,
			decodedParams.delegates,
			decodedParams.alternateRootDelegateId,
		)
	}
}.toPyString(DecryptedRelatedPerson.serializer())

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
			sdk.relatedPerson.withEncryptionMetadata(
				decodedParams.base,
				decodedParams.user,
				decodedParams.delegates,
				decodedParams.alternateRootDelegateId,
			)
		}.toPyStringAsyncCallback(DecryptedRelatedPerson.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class WithEncryptionMetadataAndDelegatesParams(
	public val base: DecryptedRelatedPerson?,
	public val delegates: Map<String, RelatedPersonDelegateOptions>,
	public val user: User? = null,
	public val alternateRootDelegateId: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun withEncryptionMetadataAndDelegatesBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<WithEncryptionMetadataAndDelegatesParams>(params)
	runBlocking {
		sdk.relatedPerson.withEncryptionMetadataAndDelegates(
			decodedParams.base,
			decodedParams.delegates,
			decodedParams.user,
			decodedParams.alternateRootDelegateId,
		)
	}
}.toPyString(DecryptedRelatedPerson.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun withEncryptionMetadataAndDelegatesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<WithEncryptionMetadataAndDelegatesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.withEncryptionMetadataAndDelegates(
				decodedParams.base,
				decodedParams.delegates,
				decodedParams.user,
				decodedParams.alternateRootDelegateId,
			)
		}.toPyStringAsyncCallback(DecryptedRelatedPerson.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetEncryptionKeysOfParams(
	public val relatedPerson: RelatedPerson,
)

@OptIn(InternalIcureApi::class)
public fun getEncryptionKeysOfBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetEncryptionKeysOfParams>(params)
	runBlocking {
		sdk.relatedPerson.getEncryptionKeysOf(
			decodedParams.relatedPerson,
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
			sdk.relatedPerson.getEncryptionKeysOf(
				decodedParams.relatedPerson,
			)
		}.toPyStringAsyncCallback(SetSerializer(HexString.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class HasWriteAccessParams(
	public val relatedPerson: RelatedPerson,
)

@OptIn(InternalIcureApi::class)
public fun hasWriteAccessBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<HasWriteAccessParams>(params)
	runBlocking {
		sdk.relatedPerson.hasWriteAccess(
			decodedParams.relatedPerson,
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
			sdk.relatedPerson.hasWriteAccess(
				decodedParams.relatedPerson,
			)
		}.toPyStringAsyncCallback(Boolean.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetSecretIdsOfParams(
	public val relatedPerson: RelatedPerson,
)

@OptIn(InternalIcureApi::class)
public fun getSecretIdsOfBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetSecretIdsOfParams>(params)
	runBlocking {
		sdk.relatedPerson.getSecretIdsOf(
			decodedParams.relatedPerson,
		)
	}
}.toPyString(SetSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getSecretIdsOfAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetSecretIdsOfParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.getSecretIdsOf(
				decodedParams.relatedPerson,
			)
		}.toPyStringAsyncCallback(SetSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateDelegationDeAnonymizationMetadataParams(
	public val entity: RelatedPerson,
	public val delegates: Set<String>,
)

@OptIn(InternalIcureApi::class)
public fun createDelegationDeAnonymizationMetadataBlocking(sdk: CardinalApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<CreateDelegationDeAnonymizationMetadataParams>(params)
	runBlocking {
		sdk.relatedPerson.createDelegationDeAnonymizationMetadata(
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
			sdk.relatedPerson.createDelegationDeAnonymizationMetadata(
				decodedParams.entity,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptParams(
	public val relatedPersons: List<EncryptedRelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun decryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptParams>(params)
	runBlocking {
		sdk.relatedPerson.decrypt(
			decodedParams.relatedPersons,
		)
	}
}.toPyString(ListSerializer(DecryptedRelatedPerson.serializer()))

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
			sdk.relatedPerson.decrypt(
				decodedParams.relatedPersons,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedRelatedPerson.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryDecryptParams(
	public val relatedPersons: List<EncryptedRelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun tryDecryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<TryDecryptParams>(params)
	runBlocking {
		sdk.relatedPerson.tryDecrypt(
			decodedParams.relatedPersons,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(RelatedPerson::class)))

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
			sdk.relatedPerson.tryDecrypt(
				decodedParams.relatedPersons,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(RelatedPerson::class)),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class EncryptOrValidateParams(
	public val relatedPersons: List<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun encryptOrValidateBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<EncryptOrValidateParams>(params)
	runBlocking {
		sdk.relatedPerson.encryptOrValidate(
			decodedParams.relatedPersons,
		)
	}
}.toPyString(ListSerializer(EncryptedRelatedPerson.serializer()))

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
			sdk.relatedPerson.encryptOrValidate(
				decodedParams.relatedPersons,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedRelatedPerson.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchRelatedPersonsByParams(
	public val filter: FilterOptions<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun matchRelatedPersonsByBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchRelatedPersonsByParams>(params)
	runBlocking {
		sdk.relatedPerson.matchRelatedPersonsBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchRelatedPersonsByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchRelatedPersonsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.matchRelatedPersonsBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchRelatedPersonsBySortedParams(
	public val filter: SortableFilterOptions<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun matchRelatedPersonsBySortedBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<MatchRelatedPersonsBySortedParams>(params)
	runBlocking {
		sdk.relatedPerson.matchRelatedPersonsBySorted(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchRelatedPersonsBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<MatchRelatedPersonsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.matchRelatedPersonsBySorted(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteRelatedPersonByIdParams(
	public val entityId: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteRelatedPersonByIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteRelatedPersonByIdParams>(params)
	runBlocking {
		sdk.relatedPerson.deleteRelatedPersonById(
			decodedParams.entityId,
			decodedParams.rev,
		)
	}
}.toPyString(StoredDocumentIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteRelatedPersonByIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteRelatedPersonByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.deleteRelatedPersonById(
				decodedParams.entityId,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(StoredDocumentIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteRelatedPersonsByIdsParams(
	public val entityIds: List<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun deleteRelatedPersonsByIdsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteRelatedPersonsByIdsParams>(params)
	runBlocking {
		sdk.relatedPerson.deleteRelatedPersonsByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteRelatedPersonsByIdsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteRelatedPersonsByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.deleteRelatedPersonsByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(StoredDocumentIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeRelatedPersonByIdParams(
	public val id: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun purgeRelatedPersonByIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeRelatedPersonByIdParams>(params)
	runBlocking {
		sdk.relatedPerson.purgeRelatedPersonById(
			decodedParams.id,
			decodedParams.rev,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeRelatedPersonByIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeRelatedPersonByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.purgeRelatedPersonById(
				decodedParams.id,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeRelatedPersonsByIdsParams(
	public val entityIds: List<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun purgeRelatedPersonsByIdsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<PurgeRelatedPersonsByIdsParams>(params)
	runBlocking {
		sdk.relatedPerson.purgeRelatedPersonsByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeRelatedPersonsByIdsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<PurgeRelatedPersonsByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.purgeRelatedPersonsByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(StoredDocumentIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteRelatedPersonParams(
	public val relatedPerson: RelatedPerson,
)

@OptIn(InternalIcureApi::class)
public fun deleteRelatedPersonBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteRelatedPersonParams>(params)
	runBlocking {
		sdk.relatedPerson.deleteRelatedPerson(
			decodedParams.relatedPerson,
		)
	}
}.toPyString(StoredDocumentIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteRelatedPersonAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteRelatedPersonParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.deleteRelatedPerson(
				decodedParams.relatedPerson,
			)
		}.toPyStringAsyncCallback(StoredDocumentIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteRelatedPersonsParams(
	public val relatedPersons: List<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun deleteRelatedPersonsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteRelatedPersonsParams>(params)
	runBlocking {
		sdk.relatedPerson.deleteRelatedPersons(
			decodedParams.relatedPersons,
		)
	}
}.toPyString(ListSerializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteRelatedPersonsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteRelatedPersonsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.deleteRelatedPersons(
				decodedParams.relatedPersons,
			)
		}.toPyStringAsyncCallback(ListSerializer(StoredDocumentIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeRelatedPersonParams(
	public val relatedPerson: RelatedPerson,
)

@OptIn(InternalIcureApi::class)
public fun purgeRelatedPersonBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeRelatedPersonParams>(params)
	runBlocking {
		sdk.relatedPerson.purgeRelatedPerson(
			decodedParams.relatedPerson,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeRelatedPersonAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeRelatedPersonParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.purgeRelatedPerson(
				decodedParams.relatedPerson,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeRelatedPersonsParams(
	public val relatedPersons: List<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun purgeRelatedPersonsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeRelatedPersonsParams>(params)
	runBlocking {
		sdk.relatedPerson.purgeRelatedPersons(
			decodedParams.relatedPersons,
		)
	}
}.toPyString(ListSerializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeRelatedPersonsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeRelatedPersonsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.purgeRelatedPersons(
				decodedParams.relatedPersons,
			)
		}.toPyStringAsyncCallback(ListSerializer(StoredDocumentIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithParams(
	public val delegateId: String,
	public val relatedPerson: DecryptedRelatedPerson,
	public val options: RelatedPersonShareOptions? = null,
)

@OptIn(InternalIcureApi::class)
public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.relatedPerson.shareWith(
			decodedParams.delegateId,
			decodedParams.relatedPerson,
			decodedParams.options,
		)
	}
}.toPyString(DecryptedRelatedPerson.serializer())

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
			sdk.relatedPerson.shareWith(
				decodedParams.delegateId,
				decodedParams.relatedPerson,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(DecryptedRelatedPerson.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val relatedPerson: DecryptedRelatedPerson,
	public val delegates: Map<String, RelatedPersonShareOptions>,
)

@OptIn(InternalIcureApi::class)
public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.relatedPerson.shareWithMany(
			decodedParams.relatedPerson,
			decodedParams.delegates,
		)
	}
}.toPyString(DecryptedRelatedPerson.serializer())

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
			sdk.relatedPerson.shareWithMany(
				decodedParams.relatedPerson,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(DecryptedRelatedPerson.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterRelatedPersonsByParams(
	public val filter: FilterOptions<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun filterRelatedPersonsByBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterRelatedPersonsByParams>(params)
	runBlocking {
		sdk.relatedPerson.filterRelatedPersonsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, DecryptedRelatedPerson.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterRelatedPersonsByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterRelatedPersonsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.filterRelatedPersonsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, DecryptedRelatedPerson.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterRelatedPersonsBySortedParams(
	public val filter: SortableFilterOptions<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun filterRelatedPersonsBySortedBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterRelatedPersonsBySortedParams>(params)
	runBlocking {
		sdk.relatedPerson.filterRelatedPersonsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, DecryptedRelatedPerson.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterRelatedPersonsBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterRelatedPersonsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.filterRelatedPersonsBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, DecryptedRelatedPerson.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class CreateRelatedPersonParams(
	public val entity: DecryptedRelatedPerson,
)

@OptIn(InternalIcureApi::class)
public fun createRelatedPersonBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateRelatedPersonParams>(params)
	runBlocking {
		sdk.relatedPerson.createRelatedPerson(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedRelatedPerson.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createRelatedPersonAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateRelatedPersonParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.createRelatedPerson(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(DecryptedRelatedPerson.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateRelatedPersonsParams(
	public val entities: List<DecryptedRelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun createRelatedPersonsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateRelatedPersonsParams>(params)
	runBlocking {
		sdk.relatedPerson.createRelatedPersons(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(DecryptedRelatedPerson.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createRelatedPersonsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateRelatedPersonsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.createRelatedPersons(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedRelatedPerson.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteRelatedPersonByIdParams(
	public val id: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun undeleteRelatedPersonByIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonByIdParams>(params)
	runBlocking {
		sdk.relatedPerson.undeleteRelatedPersonById(
			decodedParams.id,
			decodedParams.rev,
		)
	}
}.toPyString(DecryptedRelatedPerson.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteRelatedPersonByIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.undeleteRelatedPersonById(
				decodedParams.id,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(DecryptedRelatedPerson.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteRelatedPersonsByIdsParams(
	public val entityIds: List<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteRelatedPersonsByIdsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonsByIdsParams>(params)
	runBlocking {
		sdk.relatedPerson.undeleteRelatedPersonsByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DecryptedRelatedPerson.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteRelatedPersonsByIdsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonsByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.undeleteRelatedPersonsByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedRelatedPerson.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteRelatedPersonParams(
	public val relatedPerson: RelatedPerson,
)

@OptIn(InternalIcureApi::class)
public fun undeleteRelatedPersonBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonParams>(params)
	runBlocking {
		sdk.relatedPerson.undeleteRelatedPerson(
			decodedParams.relatedPerson,
		)
	}
}.toPyString(DecryptedRelatedPerson.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteRelatedPersonAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.undeleteRelatedPerson(
				decodedParams.relatedPerson,
			)
		}.toPyStringAsyncCallback(DecryptedRelatedPerson.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteRelatedPersonsParams(
	public val relatedPersons: List<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteRelatedPersonsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonsParams>(params)
	runBlocking {
		sdk.relatedPerson.undeleteRelatedPersons(
			decodedParams.relatedPersons,
		)
	}
}.toPyString(ListSerializer(DecryptedRelatedPerson.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteRelatedPersonsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.undeleteRelatedPersons(
				decodedParams.relatedPersons,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedRelatedPerson.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyRelatedPersonParams(
	public val entity: DecryptedRelatedPerson,
)

@OptIn(InternalIcureApi::class)
public fun modifyRelatedPersonBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyRelatedPersonParams>(params)
	runBlocking {
		sdk.relatedPerson.modifyRelatedPerson(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedRelatedPerson.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyRelatedPersonAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyRelatedPersonParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.modifyRelatedPerson(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(DecryptedRelatedPerson.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyRelatedPersonsParams(
	public val entities: List<DecryptedRelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun modifyRelatedPersonsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyRelatedPersonsParams>(params)
	runBlocking {
		sdk.relatedPerson.modifyRelatedPersons(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(DecryptedRelatedPerson.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyRelatedPersonsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyRelatedPersonsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.modifyRelatedPersons(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedRelatedPerson.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetRelatedPersonParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun getRelatedPersonBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetRelatedPersonParams>(params)
	runBlocking {
		sdk.relatedPerson.getRelatedPerson(
			decodedParams.entityId,
		)
	}
}.toPyString(DecryptedRelatedPerson.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getRelatedPersonAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetRelatedPersonParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.getRelatedPerson(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DecryptedRelatedPerson.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetRelatedPersonsParams(
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getRelatedPersonsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetRelatedPersonsParams>(params)
	runBlocking {
		sdk.relatedPerson.getRelatedPersons(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DecryptedRelatedPerson.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getRelatedPersonsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetRelatedPersonsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.relatedPerson.getRelatedPersons(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedRelatedPerson.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SubscribeToEventsParams(
	public val events: Set<SubscriptionEventType>,
	public val filter: FilterOptions<RelatedPerson>,
	public val subscriptionConfig: EntitySubscriptionConfiguration? = null,
)

@OptIn(InternalIcureApi::class)
public fun subscribeToEventsBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SubscribeToEventsParams>(params)
	runBlocking {
		sdk.relatedPerson.subscribeToEvents(
			decodedParams.events,
			decodedParams.filter,
			decodedParams.subscriptionConfig,
		)
	}
}.toPyResult {
	EntitySubscriptionWithSerializer(it, EncryptedRelatedPerson.serializer())}

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
			sdk.relatedPerson.subscribeToEvents(
				decodedParams.events,
				decodedParams.filter,
				decodedParams.subscriptionConfig,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			EntitySubscriptionWithSerializer(it, EncryptedRelatedPerson.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)
