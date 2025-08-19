// auto-generated file
package com.icure.cardinal.sdk.py.api.ContactApi

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.ContactShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.DecryptedContact
import com.icure.cardinal.sdk.model.EncryptedContact
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.`data`.LabelledOccurence
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.DecryptedService
import com.icure.cardinal.sdk.model.embed.EncryptedService
import com.icure.cardinal.sdk.model.embed.Service
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
import kotlinx.serialization.json.JsonElement

@Serializable
private class MatchContactsByParams(
	public val filter: FilterOptions<Contact>,
)

@OptIn(InternalIcureApi::class)
public fun matchContactsByBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchContactsByParams>(params)
	runBlocking {
		sdk.contact.matchContactsBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchContactsByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchContactsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.matchContactsBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchServicesByParams(
	public val filter: FilterOptions<Service>,
)

@OptIn(InternalIcureApi::class)
public fun matchServicesByBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchServicesByParams>(params)
	runBlocking {
		sdk.contact.matchServicesBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchServicesByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchServicesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.matchServicesBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchContactsBySortedParams(
	public val filter: SortableFilterOptions<Contact>,
)

@OptIn(InternalIcureApi::class)
public fun matchContactsBySortedBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchContactsBySortedParams>(params)
	runBlocking {
		sdk.contact.matchContactsBySorted(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchContactsBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchContactsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.matchContactsBySorted(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchServicesBySortedParams(
	public val filter: SortableFilterOptions<Service>,
)

@OptIn(InternalIcureApi::class)
public fun matchServicesBySortedBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchServicesBySortedParams>(params)
	runBlocking {
		sdk.contact.matchServicesBySorted(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchServicesBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchServicesBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.matchServicesBySorted(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class WithEncryptionMetadataParams(
	public val base: DecryptedContact?,
	public val patient: Patient,
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
		sdk.contact.withEncryptionMetadata(
			decodedParams.base,
			decodedParams.patient,
			decodedParams.user,
			decodedParams.delegates,
			decodedParams.secretId,
			decodedParams.alternateRootDelegateId,
		)
	}
}.toPyString(DecryptedContact.serializer())

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
			sdk.contact.withEncryptionMetadata(
				decodedParams.base,
				decodedParams.patient,
				decodedParams.user,
				decodedParams.delegates,
				decodedParams.secretId,
				decodedParams.alternateRootDelegateId,
			)
		}.toPyStringAsyncCallback(DecryptedContact.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetEncryptionKeysOfParams(
	public val contact: Contact,
)

@OptIn(InternalIcureApi::class)
public fun getEncryptionKeysOfBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetEncryptionKeysOfParams>(params)
	runBlocking {
		sdk.contact.getEncryptionKeysOf(
			decodedParams.contact,
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
			sdk.contact.getEncryptionKeysOf(
				decodedParams.contact,
			)
		}.toPyStringAsyncCallback(SetSerializer(HexString.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class HasWriteAccessParams(
	public val contact: Contact,
)

@OptIn(InternalIcureApi::class)
public fun hasWriteAccessBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<HasWriteAccessParams>(params)
	runBlocking {
		sdk.contact.hasWriteAccess(
			decodedParams.contact,
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
			sdk.contact.hasWriteAccess(
				decodedParams.contact,
			)
		}.toPyStringAsyncCallback(Boolean.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptPatientIdOfParams(
	public val contact: Contact,
)

@OptIn(InternalIcureApi::class)
public fun decryptPatientIdOfBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptPatientIdOfParams>(params)
	runBlocking {
		sdk.contact.decryptPatientIdOf(
			decodedParams.contact,
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
			sdk.contact.decryptPatientIdOf(
				decodedParams.contact,
			)
		}.toPyStringAsyncCallback(SetSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateDelegationDeAnonymizationMetadataParams(
	public val entity: Contact,
	public val delegates: Set<String>,
)

@OptIn(InternalIcureApi::class)
public fun createDelegationDeAnonymizationMetadataBlocking(sdk: CardinalApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<CreateDelegationDeAnonymizationMetadataParams>(params)
	runBlocking {
		sdk.contact.createDelegationDeAnonymizationMetadata(
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
			sdk.contact.createDelegationDeAnonymizationMetadata(
				decodedParams.entity,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptParams(
	public val contact: EncryptedContact,
)

@OptIn(InternalIcureApi::class)
public fun decryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptParams>(params)
	runBlocking {
		sdk.contact.decrypt(
			decodedParams.contact,
		)
	}
}.toPyString(DecryptedContact.serializer())

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
			sdk.contact.decrypt(
				decodedParams.contact,
			)
		}.toPyStringAsyncCallback(DecryptedContact.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryDecryptParams(
	public val contact: EncryptedContact,
)

@OptIn(InternalIcureApi::class)
public fun tryDecryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<TryDecryptParams>(params)
	runBlocking {
		sdk.contact.tryDecrypt(
			decodedParams.contact,
		)
	}
}.toPyString(PolymorphicSerializer(Contact::class))

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
			sdk.contact.tryDecrypt(
				decodedParams.contact,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Contact::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptServiceParams(
	public val service: EncryptedService,
)

@OptIn(InternalIcureApi::class)
public fun decryptServiceBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptServiceParams>(params)
	runBlocking {
		sdk.contact.decryptService(
			decodedParams.service,
		)
	}
}.toPyString(DecryptedService.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun decryptServiceAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptServiceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.decryptService(
				decodedParams.service,
			)
		}.toPyStringAsyncCallback(DecryptedService.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryDecryptServiceParams(
	public val service: EncryptedService,
)

@OptIn(InternalIcureApi::class)
public fun tryDecryptServiceBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<TryDecryptServiceParams>(params)
	runBlocking {
		sdk.contact.tryDecryptService(
			decodedParams.service,
		)
	}
}.toPyString(PolymorphicSerializer(Service::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun tryDecryptServiceAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<TryDecryptServiceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.tryDecryptService(
				decodedParams.service,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Service::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SubscribeToServiceCreateOrUpdateEventsParams(
	public val filter: FilterOptions<Service>,
	public val subscriptionConfig: EntitySubscriptionConfiguration? = null,
)

@OptIn(InternalIcureApi::class)
public fun subscribeToServiceCreateOrUpdateEventsBlocking(sdk: CardinalApis, params: String):
		PyResult = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<SubscribeToServiceCreateOrUpdateEventsParams>(params)
	runBlocking {
		sdk.contact.subscribeToServiceCreateOrUpdateEvents(
			decodedParams.filter,
			decodedParams.subscriptionConfig,
		)
	}
}.toPyResult {
	EntitySubscriptionWithSerializer(it, EncryptedService.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun subscribeToServiceCreateOrUpdateEventsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<SubscribeToServiceCreateOrUpdateEventsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.subscribeToServiceCreateOrUpdateEvents(
				decodedParams.filter,
				decodedParams.subscriptionConfig,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			EntitySubscriptionWithSerializer(it, EncryptedService.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class DeleteContactUnsafeParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteContactUnsafeBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteContactUnsafeParams>(params)
	runBlocking {
		sdk.contact.deleteContactUnsafe(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteContactUnsafeAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteContactUnsafeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.deleteContactUnsafe(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteContactsUnsafeParams(
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun deleteContactsUnsafeBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteContactsUnsafeParams>(params)
	runBlocking {
		sdk.contact.deleteContactsUnsafe(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteContactsUnsafeAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteContactsUnsafeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.deleteContactsUnsafe(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteContactByIdParams(
	public val entityId: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteContactByIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteContactByIdParams>(params)
	runBlocking {
		sdk.contact.deleteContactById(
			decodedParams.entityId,
			decodedParams.rev,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteContactByIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteContactByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.deleteContactById(
				decodedParams.entityId,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteContactsByIdsParams(
	public val entityIds: List<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun deleteContactsByIdsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteContactsByIdsParams>(params)
	runBlocking {
		sdk.contact.deleteContactsByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteContactsByIdsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteContactsByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.deleteContactsByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeContactByIdParams(
	public val id: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun purgeContactByIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeContactByIdParams>(params)
	runBlocking {
		sdk.contact.purgeContactById(
			decodedParams.id,
			decodedParams.rev,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeContactByIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeContactByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.purgeContactById(
				decodedParams.id,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteContactParams(
	public val contact: Contact,
)

@OptIn(InternalIcureApi::class)
public fun deleteContactBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteContactParams>(params)
	runBlocking {
		sdk.contact.deleteContact(
			decodedParams.contact,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteContactAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteContactParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.deleteContact(
				decodedParams.contact,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteContactsParams(
	public val contacts: List<Contact>,
)

@OptIn(InternalIcureApi::class)
public fun deleteContactsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteContactsParams>(params)
	runBlocking {
		sdk.contact.deleteContacts(
			decodedParams.contacts,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteContactsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteContactsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.deleteContacts(
				decodedParams.contacts,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeContactParams(
	public val contact: Contact,
)

@OptIn(InternalIcureApi::class)
public fun purgeContactBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeContactParams>(params)
	runBlocking {
		sdk.contact.purgeContact(
			decodedParams.contact,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeContactAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeContactParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.purgeContact(
				decodedParams.contact,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetServiceCodesOccurrencesParams(
	public val codeType: String,
	public val minOccurrences: Long,
)

@OptIn(InternalIcureApi::class)
public fun getServiceCodesOccurrencesBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetServiceCodesOccurrencesParams>(params)
	runBlocking {
		sdk.contact.getServiceCodesOccurrences(
			decodedParams.codeType,
			decodedParams.minOccurrences,
		)
	}
}.toPyString(ListSerializer(LabelledOccurence.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getServiceCodesOccurrencesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetServiceCodesOccurrencesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.getServiceCodesOccurrences(
				decodedParams.codeType,
				decodedParams.minOccurrences,
			)
		}.toPyStringAsyncCallback(ListSerializer(LabelledOccurence.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithParams(
	public val delegateId: String,
	public val contact: DecryptedContact,
	public val options: ContactShareOptions? = null,
)

@OptIn(InternalIcureApi::class)
public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.contact.shareWith(
			decodedParams.delegateId,
			decodedParams.contact,
			decodedParams.options,
		)
	}
}.toPyString(DecryptedContact.serializer())

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
			sdk.contact.shareWith(
				decodedParams.delegateId,
				decodedParams.contact,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(DecryptedContact.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val contact: DecryptedContact,
	public val delegates: Map<String, ContactShareOptions>,
)

@OptIn(InternalIcureApi::class)
public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.contact.shareWithMany(
			decodedParams.contact,
			decodedParams.delegates,
		)
	}
}.toPyString(DecryptedContact.serializer())

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
			sdk.contact.shareWithMany(
				decodedParams.contact,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(DecryptedContact.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindContactsByHcPartyPatientParams(
	public val hcPartyId: String,
	public val patient: Patient,
	public val startDate: Long? = null,
	public val endDate: Long? = null,
	public val descending: Boolean? = null,
)

@OptIn(InternalIcureApi::class)
public fun findContactsByHcPartyPatientBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindContactsByHcPartyPatientParams>(params)
	runBlocking {
		sdk.contact.findContactsByHcPartyPatient(
			decodedParams.hcPartyId,
			decodedParams.patient,
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.descending,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, DecryptedContact.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findContactsByHcPartyPatientAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindContactsByHcPartyPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.findContactsByHcPartyPatient(
				decodedParams.hcPartyId,
				decodedParams.patient,
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.descending,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, DecryptedContact.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterContactsByParams(
	public val filter: FilterOptions<Contact>,
)

@OptIn(InternalIcureApi::class)
public fun filterContactsByBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterContactsByParams>(params)
	runBlocking {
		sdk.contact.filterContactsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, DecryptedContact.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterContactsByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterContactsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.filterContactsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, DecryptedContact.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterServicesByParams(
	public val filter: FilterOptions<Service>,
)

@OptIn(InternalIcureApi::class)
public fun filterServicesByBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterServicesByParams>(params)
	runBlocking {
		sdk.contact.filterServicesBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, DecryptedService.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterServicesByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterServicesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.filterServicesBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, DecryptedService.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterContactsBySortedParams(
	public val filter: SortableFilterOptions<Contact>,
)

@OptIn(InternalIcureApi::class)
public fun filterContactsBySortedBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterContactsBySortedParams>(params)
	runBlocking {
		sdk.contact.filterContactsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, DecryptedContact.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterContactsBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterContactsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.filterContactsBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, DecryptedContact.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterServicesBySortedParams(
	public val filter: SortableFilterOptions<Service>,
)

@OptIn(InternalIcureApi::class)
public fun filterServicesBySortedBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterServicesBySortedParams>(params)
	runBlocking {
		sdk.contact.filterServicesBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, DecryptedService.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterServicesBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterServicesBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.filterServicesBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, DecryptedService.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class CreateContactParams(
	public val entity: DecryptedContact,
)

@OptIn(InternalIcureApi::class)
public fun createContactBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateContactParams>(params)
	runBlocking {
		sdk.contact.createContact(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedContact.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createContactAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateContactParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.createContact(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(DecryptedContact.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateContactsParams(
	public val entities: List<DecryptedContact>,
)

@OptIn(InternalIcureApi::class)
public fun createContactsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateContactsParams>(params)
	runBlocking {
		sdk.contact.createContacts(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(DecryptedContact.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createContactsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateContactsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.createContacts(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedContact.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteContactByIdParams(
	public val id: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun undeleteContactByIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteContactByIdParams>(params)
	runBlocking {
		sdk.contact.undeleteContactById(
			decodedParams.id,
			decodedParams.rev,
		)
	}
}.toPyString(DecryptedContact.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteContactByIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteContactByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.undeleteContactById(
				decodedParams.id,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(DecryptedContact.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteContactParams(
	public val contact: Contact,
)

@OptIn(InternalIcureApi::class)
public fun undeleteContactBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteContactParams>(params)
	runBlocking {
		sdk.contact.undeleteContact(
			decodedParams.contact,
		)
	}
}.toPyString(DecryptedContact.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteContactAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteContactParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.undeleteContact(
				decodedParams.contact,
			)
		}.toPyStringAsyncCallback(DecryptedContact.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyContactParams(
	public val entity: DecryptedContact,
)

@OptIn(InternalIcureApi::class)
public fun modifyContactBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyContactParams>(params)
	runBlocking {
		sdk.contact.modifyContact(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedContact.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyContactAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyContactParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.modifyContact(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(DecryptedContact.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyContactsParams(
	public val entities: List<DecryptedContact>,
)

@OptIn(InternalIcureApi::class)
public fun modifyContactsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyContactsParams>(params)
	runBlocking {
		sdk.contact.modifyContacts(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(DecryptedContact.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyContactsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyContactsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.modifyContacts(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedContact.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetContactParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun getContactBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetContactParams>(params)
	runBlocking {
		sdk.contact.getContact(
			decodedParams.entityId,
		)
	}
}.toPyString(DecryptedContact.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getContactAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetContactParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.getContact(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DecryptedContact.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetContactsParams(
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getContactsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetContactsParams>(params)
	runBlocking {
		sdk.contact.getContacts(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DecryptedContact.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getContactsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetContactsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.getContacts(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedContact.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListContactByHCPartyServiceIdParams(
	public val hcPartyId: String,
	public val serviceId: String,
)

@OptIn(InternalIcureApi::class)
public fun listContactByHCPartyServiceIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListContactByHCPartyServiceIdParams>(params)
	runBlocking {
		sdk.contact.listContactByHCPartyServiceId(
			decodedParams.hcPartyId,
			decodedParams.serviceId,
		)
	}
}.toPyString(ListSerializer(DecryptedContact.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listContactByHCPartyServiceIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListContactByHCPartyServiceIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.listContactByHCPartyServiceId(
				decodedParams.hcPartyId,
				decodedParams.serviceId,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedContact.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListContactsByExternalIdParams(
	public val externalId: String,
)

@OptIn(InternalIcureApi::class)
public fun listContactsByExternalIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListContactsByExternalIdParams>(params)
	runBlocking {
		sdk.contact.listContactsByExternalId(
			decodedParams.externalId,
		)
	}
}.toPyString(ListSerializer(DecryptedContact.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listContactsByExternalIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListContactsByExternalIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.listContactsByExternalId(
				decodedParams.externalId,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedContact.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListContactsByHCPartyAndFormIdParams(
	public val hcPartyId: String,
	public val formId: String,
)

@OptIn(InternalIcureApi::class)
public fun listContactsByHCPartyAndFormIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListContactsByHCPartyAndFormIdParams>(params)
	runBlocking {
		sdk.contact.listContactsByHCPartyAndFormId(
			decodedParams.hcPartyId,
			decodedParams.formId,
		)
	}
}.toPyString(ListSerializer(DecryptedContact.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listContactsByHCPartyAndFormIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListContactsByHCPartyAndFormIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.listContactsByHCPartyAndFormId(
				decodedParams.hcPartyId,
				decodedParams.formId,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedContact.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListContactsByHCPartyAndFormIdsParams(
	public val hcPartyId: String,
	public val formIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun listContactsByHCPartyAndFormIdsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListContactsByHCPartyAndFormIdsParams>(params)
	runBlocking {
		sdk.contact.listContactsByHCPartyAndFormIds(
			decodedParams.hcPartyId,
			decodedParams.formIds,
		)
	}
}.toPyString(ListSerializer(DecryptedContact.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listContactsByHCPartyAndFormIdsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListContactsByHCPartyAndFormIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.listContactsByHCPartyAndFormIds(
				decodedParams.hcPartyId,
				decodedParams.formIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedContact.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetServiceParams(
	public val serviceId: String,
)

@OptIn(InternalIcureApi::class)
public fun getServiceBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetServiceParams>(params)
	runBlocking {
		sdk.contact.getService(
			decodedParams.serviceId,
		)
	}
}.toPyString(DecryptedService.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getServiceAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetServiceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.getService(
				decodedParams.serviceId,
			)
		}.toPyStringAsyncCallback(DecryptedService.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetServicesParams(
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getServicesBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetServicesParams>(params)
	runBlocking {
		sdk.contact.getServices(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DecryptedService.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getServicesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetServicesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.getServices(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedService.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetServicesLinkedToParams(
	public val linkType: String,
	public val ids: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getServicesLinkedToBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetServicesLinkedToParams>(params)
	runBlocking {
		sdk.contact.getServicesLinkedTo(
			decodedParams.linkType,
			decodedParams.ids,
		)
	}
}.toPyString(ListSerializer(DecryptedService.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getServicesLinkedToAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetServicesLinkedToParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.getServicesLinkedTo(
				decodedParams.linkType,
				decodedParams.ids,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedService.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListServicesByAssociationIdParams(
	public val associationId: String,
)

@OptIn(InternalIcureApi::class)
public fun listServicesByAssociationIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListServicesByAssociationIdParams>(params)
	runBlocking {
		sdk.contact.listServicesByAssociationId(
			decodedParams.associationId,
		)
	}
}.toPyString(ListSerializer(DecryptedService.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listServicesByAssociationIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListServicesByAssociationIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.listServicesByAssociationId(
				decodedParams.associationId,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedService.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListServicesByHealthElementIdParams(
	public val hcPartyId: String,
	public val healthElementId: String,
)

@OptIn(InternalIcureApi::class)
public fun listServicesByHealthElementIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListServicesByHealthElementIdParams>(params)
	runBlocking {
		sdk.contact.listServicesByHealthElementId(
			decodedParams.hcPartyId,
			decodedParams.healthElementId,
		)
	}
}.toPyString(ListSerializer(DecryptedService.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listServicesByHealthElementIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListServicesByHealthElementIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.listServicesByHealthElementId(
				decodedParams.hcPartyId,
				decodedParams.healthElementId,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedService.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindContactsByOpeningDateParams(
	public val startDate: Long,
	public val endDate: Long,
	public val hcPartyId: String,
	public val startKey: JsonElement? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

@OptIn(InternalIcureApi::class)
public fun findContactsByOpeningDateBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindContactsByOpeningDateParams>(params)
	runBlocking {
		sdk.contact.findContactsByOpeningDate(
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.hcPartyId,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(DecryptedContact.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findContactsByOpeningDateAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindContactsByOpeningDateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.contact.findContactsByOpeningDate(
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.hcPartyId,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(DecryptedContact.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SubscribeToEventsParams(
	public val events: Set<SubscriptionEventType>,
	public val filter: FilterOptions<Contact>,
	public val subscriptionConfig: EntitySubscriptionConfiguration? = null,
)

@OptIn(InternalIcureApi::class)
public fun subscribeToEventsBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SubscribeToEventsParams>(params)
	runBlocking {
		sdk.contact.subscribeToEvents(
			decodedParams.events,
			decodedParams.filter,
			decodedParams.subscriptionConfig,
		)
	}
}.toPyResult {
	EntitySubscriptionWithSerializer(it, EncryptedContact.serializer())}

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
			sdk.contact.subscribeToEvents(
				decodedParams.events,
				decodedParams.filter,
				decodedParams.subscriptionConfig,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			EntitySubscriptionWithSerializer(it, EncryptedContact.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)
