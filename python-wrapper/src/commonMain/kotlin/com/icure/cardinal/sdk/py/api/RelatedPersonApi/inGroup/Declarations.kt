// auto-generated file
package com.icure.cardinal.sdk.py.api.RelatedPersonApi.inGroup

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.RelatedPersonDelegateOptions
import com.icure.cardinal.sdk.crypto.entities.RelatedPersonShareOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.DecryptedRelatedPerson
import com.icure.cardinal.sdk.model.EncryptedRelatedPerson
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
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
	public val base: DecryptedRelatedPerson?,
	public val user: User? = null,
	@Serializable(MapAsArraySerializer::class)
	@OptIn(InternalIcureApi::class)
	public val delegates: Map<EntityReferenceInGroup, AccessLevel> = emptyMap(),
	public val alternateRootDelegateReference: EntityReferenceInGroup? = null,
)

@OptIn(InternalIcureApi::class)
public fun withEncryptionMetadataBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<WithEncryptionMetadataParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.withEncryptionMetadata(
			decodedParams.entityGroupId,
			decodedParams.base,
			decodedParams.user,
			decodedParams.delegates,
			decodedParams.alternateRootDelegateReference,
		)
	}
}.toPyString(GroupScoped.serializer(DecryptedRelatedPerson.serializer()))

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
			sdk.relatedPerson.inGroup.withEncryptionMetadata(
				decodedParams.entityGroupId,
				decodedParams.base,
				decodedParams.user,
				decodedParams.delegates,
				decodedParams.alternateRootDelegateReference,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(DecryptedRelatedPerson.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class WithEncryptionMetadataAndDelegatesParams(
	public val entityGroupId: String,
	public val base: DecryptedRelatedPerson?,
	@Serializable(MapAsArraySerializer::class)
	@OptIn(InternalIcureApi::class)
	public val delegates: Map<EntityReferenceInGroup, RelatedPersonDelegateOptions>,
	public val user: User? = null,
	public val alternateRootDelegateReference: EntityReferenceInGroup? = null,
)

@OptIn(InternalIcureApi::class)
public fun withEncryptionMetadataAndDelegatesBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<WithEncryptionMetadataAndDelegatesParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.withEncryptionMetadataAndDelegates(
			decodedParams.entityGroupId,
			decodedParams.base,
			decodedParams.delegates,
			decodedParams.user,
			decodedParams.alternateRootDelegateReference,
		)
	}
}.toPyString(GroupScoped.serializer(DecryptedRelatedPerson.serializer()))

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
			sdk.relatedPerson.inGroup.withEncryptionMetadataAndDelegates(
				decodedParams.entityGroupId,
				decodedParams.base,
				decodedParams.delegates,
				decodedParams.user,
				decodedParams.alternateRootDelegateReference,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(DecryptedRelatedPerson.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetEncryptionKeysOfParams(
	public val relatedPerson: GroupScoped<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun getEncryptionKeysOfBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetEncryptionKeysOfParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.getEncryptionKeysOf(
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
			sdk.relatedPerson.inGroup.getEncryptionKeysOf(
				decodedParams.relatedPerson,
			)
		}.toPyStringAsyncCallback(SetSerializer(HexString.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class HasWriteAccessParams(
	public val relatedPerson: GroupScoped<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun hasWriteAccessBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<HasWriteAccessParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.hasWriteAccess(
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
			sdk.relatedPerson.inGroup.hasWriteAccess(
				decodedParams.relatedPerson,
			)
		}.toPyStringAsyncCallback(Boolean.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetSecretIdsOfParams(
	public val relatedPerson: GroupScoped<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun getSecretIdsOfBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetSecretIdsOfParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.getSecretIdsOf(
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
			sdk.relatedPerson.inGroup.getSecretIdsOf(
				decodedParams.relatedPerson,
			)
		}.toPyStringAsyncCallback(SetSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateDelegationDeAnonymizationMetadataParams(
	public val entity: GroupScoped<RelatedPerson>,
	public val delegates: Set<EntityReferenceInGroup>,
)

@OptIn(InternalIcureApi::class)
public fun createDelegationDeAnonymizationMetadataBlocking(sdk: CardinalApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<CreateDelegationDeAnonymizationMetadataParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.createDelegationDeAnonymizationMetadata(
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
			sdk.relatedPerson.inGroup.createDelegationDeAnonymizationMetadata(
				decodedParams.entity,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptParams(
	public val relatedPersons: List<GroupScoped<EncryptedRelatedPerson>>,
)

@OptIn(InternalIcureApi::class)
public fun decryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.decrypt(
			decodedParams.relatedPersons,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(DecryptedRelatedPerson.serializer())))

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
			sdk.relatedPerson.inGroup.decrypt(
				decodedParams.relatedPersons,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(DecryptedRelatedPerson.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryDecryptParams(
	public val relatedPersons: List<GroupScoped<EncryptedRelatedPerson>>,
)

@OptIn(InternalIcureApi::class)
public fun tryDecryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<TryDecryptParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.tryDecrypt(
			decodedParams.relatedPersons,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(PolymorphicSerializer(RelatedPerson::class))))

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
			sdk.relatedPerson.inGroup.tryDecrypt(
				decodedParams.relatedPersons,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(PolymorphicSerializer(RelatedPerson::class))),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class EncryptOrValidateParams(
	public val relatedPersons: List<GroupScoped<RelatedPerson>>,
)

@OptIn(InternalIcureApi::class)
public fun encryptOrValidateBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<EncryptOrValidateParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.encryptOrValidate(
			decodedParams.relatedPersons,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(EncryptedRelatedPerson.serializer())))

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
			sdk.relatedPerson.inGroup.encryptOrValidate(
				decodedParams.relatedPersons,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(EncryptedRelatedPerson.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchRelatedPersonsByParams(
	public val groupId: String,
	public val filter: FilterOptions<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun matchRelatedPersonsByBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchRelatedPersonsByParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.matchRelatedPersonsBy(
			decodedParams.groupId,
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
			sdk.relatedPerson.inGroup.matchRelatedPersonsBy(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchRelatedPersonsBySortedParams(
	public val groupId: String,
	public val filter: SortableFilterOptions<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun matchRelatedPersonsBySortedBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<MatchRelatedPersonsBySortedParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.matchRelatedPersonsBySorted(
			decodedParams.groupId,
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
			sdk.relatedPerson.inGroup.matchRelatedPersonsBySorted(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteRelatedPersonByIdParams(
	public val entityId: GroupScoped<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun deleteRelatedPersonByIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteRelatedPersonByIdParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.deleteRelatedPersonById(
			decodedParams.entityId,
		)
	}
}.toPyString(GroupScoped.serializer(StoredDocumentIdentifier.serializer()))

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
			sdk.relatedPerson.inGroup.deleteRelatedPersonById(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(StoredDocumentIdentifier.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteRelatedPersonsByIdsParams(
	public val entityIds: List<GroupScoped<StoredDocumentIdentifier>>,
)

@OptIn(InternalIcureApi::class)
public fun deleteRelatedPersonsByIdsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteRelatedPersonsByIdsParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.deleteRelatedPersonsByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

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
			sdk.relatedPerson.inGroup.deleteRelatedPersonsByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeRelatedPersonByIdParams(
	public val entityId: GroupScoped<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun purgeRelatedPersonByIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeRelatedPersonByIdParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.purgeRelatedPersonById(
			decodedParams.entityId,
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
			sdk.relatedPerson.inGroup.purgeRelatedPersonById(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeRelatedPersonsByIdsParams(
	public val entityIds: List<GroupScoped<StoredDocumentIdentifier>>,
)

@OptIn(InternalIcureApi::class)
public fun purgeRelatedPersonsByIdsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<PurgeRelatedPersonsByIdsParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.purgeRelatedPersonsByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

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
			sdk.relatedPerson.inGroup.purgeRelatedPersonsByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteRelatedPersonParams(
	public val relatedPerson: GroupScoped<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun deleteRelatedPersonBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteRelatedPersonParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.deleteRelatedPerson(
			decodedParams.relatedPerson,
		)
	}
}.toPyString(GroupScoped.serializer(StoredDocumentIdentifier.serializer()))

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
			sdk.relatedPerson.inGroup.deleteRelatedPerson(
				decodedParams.relatedPerson,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(StoredDocumentIdentifier.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteRelatedPersonsParams(
	public val relatedPersons: List<GroupScoped<RelatedPerson>>,
)

@OptIn(InternalIcureApi::class)
public fun deleteRelatedPersonsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteRelatedPersonsParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.deleteRelatedPersons(
			decodedParams.relatedPersons,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

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
			sdk.relatedPerson.inGroup.deleteRelatedPersons(
				decodedParams.relatedPersons,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeRelatedPersonParams(
	public val relatedPerson: GroupScoped<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun purgeRelatedPersonBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeRelatedPersonParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.purgeRelatedPerson(
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
			sdk.relatedPerson.inGroup.purgeRelatedPerson(
				decodedParams.relatedPerson,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeRelatedPersonsParams(
	public val relatedPersons: List<GroupScoped<RelatedPerson>>,
)

@OptIn(InternalIcureApi::class)
public fun purgeRelatedPersonsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeRelatedPersonsParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.purgeRelatedPersons(
			decodedParams.relatedPersons,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

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
			sdk.relatedPerson.inGroup.purgeRelatedPersons(
				decodedParams.relatedPersons,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithParams(
	public val `delegate`: EntityReferenceInGroup,
	public val relatedPerson: GroupScoped<DecryptedRelatedPerson>,
	public val options: RelatedPersonShareOptions? = null,
)

@OptIn(InternalIcureApi::class)
public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.shareWith(
			decodedParams.delegate,
			decodedParams.relatedPerson,
			decodedParams.options,
		)
	}
}.toPyString(GroupScoped.serializer(DecryptedRelatedPerson.serializer()))

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
			sdk.relatedPerson.inGroup.shareWith(
				decodedParams.delegate,
				decodedParams.relatedPerson,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(DecryptedRelatedPerson.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val relatedPerson: GroupScoped<DecryptedRelatedPerson>,
	@Serializable(MapAsArraySerializer::class)
	@OptIn(InternalIcureApi::class)
	public val delegates: Map<EntityReferenceInGroup, RelatedPersonShareOptions>,
)

@OptIn(InternalIcureApi::class)
public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.shareWithMany(
			decodedParams.relatedPerson,
			decodedParams.delegates,
		)
	}
}.toPyString(GroupScoped.serializer(DecryptedRelatedPerson.serializer()))

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
			sdk.relatedPerson.inGroup.shareWithMany(
				decodedParams.relatedPerson,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(DecryptedRelatedPerson.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterRelatedPersonsByParams(
	public val groupId: String,
	public val filter: FilterOptions<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun filterRelatedPersonsByBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterRelatedPersonsByParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.filterRelatedPersonsBy(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it,
			GroupScoped.serializer(DecryptedRelatedPerson.serializer()))}

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
			sdk.relatedPerson.inGroup.filterRelatedPersonsBy(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it,
					GroupScoped.serializer(DecryptedRelatedPerson.serializer()))}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterRelatedPersonsBySortedParams(
	public val groupId: String,
	public val filter: SortableFilterOptions<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun filterRelatedPersonsBySortedBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterRelatedPersonsBySortedParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.filterRelatedPersonsBySorted(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it,
			GroupScoped.serializer(DecryptedRelatedPerson.serializer()))}

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
			sdk.relatedPerson.inGroup.filterRelatedPersonsBySorted(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it,
					GroupScoped.serializer(DecryptedRelatedPerson.serializer()))}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class CreateRelatedPersonParams(
	public val entity: GroupScoped<DecryptedRelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun createRelatedPersonBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateRelatedPersonParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.createRelatedPerson(
			decodedParams.entity,
		)
	}
}.toPyString(GroupScoped.serializer(DecryptedRelatedPerson.serializer()))

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
			sdk.relatedPerson.inGroup.createRelatedPerson(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(DecryptedRelatedPerson.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateRelatedPersonsParams(
	public val entities: List<GroupScoped<DecryptedRelatedPerson>>,
)

@OptIn(InternalIcureApi::class)
public fun createRelatedPersonsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateRelatedPersonsParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.createRelatedPersons(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(DecryptedRelatedPerson.serializer())))

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
			sdk.relatedPerson.inGroup.createRelatedPersons(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(DecryptedRelatedPerson.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteRelatedPersonByIdParams(
	public val entityId: GroupScoped<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteRelatedPersonByIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonByIdParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.undeleteRelatedPersonById(
			decodedParams.entityId,
		)
	}
}.toPyString(GroupScoped.serializer(DecryptedRelatedPerson.serializer()))

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
			sdk.relatedPerson.inGroup.undeleteRelatedPersonById(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(DecryptedRelatedPerson.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteRelatedPersonsByIdsParams(
	public val entityIds: List<GroupScoped<StoredDocumentIdentifier>>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteRelatedPersonsByIdsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonsByIdsParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.undeleteRelatedPersonsByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(DecryptedRelatedPerson.serializer())))

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
			sdk.relatedPerson.inGroup.undeleteRelatedPersonsByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(DecryptedRelatedPerson.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteRelatedPersonParams(
	public val relatedPerson: GroupScoped<RelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteRelatedPersonBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.undeleteRelatedPerson(
			decodedParams.relatedPerson,
		)
	}
}.toPyString(GroupScoped.serializer(DecryptedRelatedPerson.serializer()))

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
			sdk.relatedPerson.inGroup.undeleteRelatedPerson(
				decodedParams.relatedPerson,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(DecryptedRelatedPerson.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteRelatedPersonsParams(
	public val relatedPersons: List<GroupScoped<DecryptedRelatedPerson>>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteRelatedPersonsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteRelatedPersonsParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.undeleteRelatedPersons(
			decodedParams.relatedPersons,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(DecryptedRelatedPerson.serializer())))

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
			sdk.relatedPerson.inGroup.undeleteRelatedPersons(
				decodedParams.relatedPersons,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(DecryptedRelatedPerson.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyRelatedPersonParams(
	public val entity: GroupScoped<DecryptedRelatedPerson>,
)

@OptIn(InternalIcureApi::class)
public fun modifyRelatedPersonBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyRelatedPersonParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.modifyRelatedPerson(
			decodedParams.entity,
		)
	}
}.toPyString(GroupScoped.serializer(DecryptedRelatedPerson.serializer()))

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
			sdk.relatedPerson.inGroup.modifyRelatedPerson(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(DecryptedRelatedPerson.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyRelatedPersonsParams(
	public val entities: List<GroupScoped<DecryptedRelatedPerson>>,
)

@OptIn(InternalIcureApi::class)
public fun modifyRelatedPersonsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyRelatedPersonsParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.modifyRelatedPersons(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(DecryptedRelatedPerson.serializer())))

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
			sdk.relatedPerson.inGroup.modifyRelatedPersons(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(DecryptedRelatedPerson.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetRelatedPersonParams(
	public val groupId: String,
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun getRelatedPersonBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetRelatedPersonParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.getRelatedPerson(
			decodedParams.groupId,
			decodedParams.entityId,
		)
	}
}.toPyString(GroupScoped.serializer(DecryptedRelatedPerson.serializer()))

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
			sdk.relatedPerson.inGroup.getRelatedPerson(
				decodedParams.groupId,
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(DecryptedRelatedPerson.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetRelatedPersonsParams(
	public val groupId: String,
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getRelatedPersonsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetRelatedPersonsParams>(params)
	runBlocking {
		sdk.relatedPerson.inGroup.getRelatedPersons(
			decodedParams.groupId,
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(DecryptedRelatedPerson.serializer())))

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
			sdk.relatedPerson.inGroup.getRelatedPersons(
				decodedParams.groupId,
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(DecryptedRelatedPerson.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
