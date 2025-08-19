// auto-generated file
package com.icure.cardinal.sdk.py.api.InvoiceApi

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.InvoiceShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.model.DecryptedInvoice
import com.icure.cardinal.sdk.model.EncryptedInvoice
import com.icure.cardinal.sdk.model.Invoice
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.`data`.LabelledOccurence
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.EncryptedInvoicingCode
import com.icure.cardinal.sdk.model.embed.InvoiceType
import com.icure.cardinal.sdk.model.embed.MediumType
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.py.utils.PyResult
import com.icure.cardinal.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyResult
import com.icure.cardinal.sdk.py.utils.toPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
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
private class CreateInvoiceParams(
	public val entity: DecryptedInvoice,
	public val prefix: String?,
)

@OptIn(InternalIcureApi::class)
public fun createInvoiceBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateInvoiceParams>(params)
	runBlocking {
		sdk.invoice.createInvoice(
			decodedParams.entity,
			decodedParams.prefix,
		)
	}
}.toPyString(DecryptedInvoice.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createInvoiceAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateInvoiceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.createInvoice(
				decodedParams.entity,
				decodedParams.prefix,
			)
		}.toPyStringAsyncCallback(DecryptedInvoice.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateInvoicesParams(
	public val entities: List<DecryptedInvoice>,
)

@OptIn(InternalIcureApi::class)
public fun createInvoicesBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateInvoicesParams>(params)
	runBlocking {
		sdk.invoice.createInvoices(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(DecryptedInvoice.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createInvoicesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateInvoicesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.createInvoices(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class WithEncryptionMetadataParams(
	public val base: DecryptedInvoice?,
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
		sdk.invoice.withEncryptionMetadata(
			decodedParams.base,
			decodedParams.patient,
			decodedParams.user,
			decodedParams.delegates,
			decodedParams.secretId,
			decodedParams.alternateRootDelegateId,
		)
	}
}.toPyString(DecryptedInvoice.serializer())

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
			sdk.invoice.withEncryptionMetadata(
				decodedParams.base,
				decodedParams.patient,
				decodedParams.user,
				decodedParams.delegates,
				decodedParams.secretId,
				decodedParams.alternateRootDelegateId,
			)
		}.toPyStringAsyncCallback(DecryptedInvoice.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetEncryptionKeysOfParams(
	public val invoice: Invoice,
)

@OptIn(InternalIcureApi::class)
public fun getEncryptionKeysOfBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetEncryptionKeysOfParams>(params)
	runBlocking {
		sdk.invoice.getEncryptionKeysOf(
			decodedParams.invoice,
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
			sdk.invoice.getEncryptionKeysOf(
				decodedParams.invoice,
			)
		}.toPyStringAsyncCallback(SetSerializer(HexString.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class HasWriteAccessParams(
	public val invoice: Invoice,
)

@OptIn(InternalIcureApi::class)
public fun hasWriteAccessBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<HasWriteAccessParams>(params)
	runBlocking {
		sdk.invoice.hasWriteAccess(
			decodedParams.invoice,
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
			sdk.invoice.hasWriteAccess(
				decodedParams.invoice,
			)
		}.toPyStringAsyncCallback(Boolean.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptPatientIdOfParams(
	public val invoice: Invoice,
)

@OptIn(InternalIcureApi::class)
public fun decryptPatientIdOfBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptPatientIdOfParams>(params)
	runBlocking {
		sdk.invoice.decryptPatientIdOf(
			decodedParams.invoice,
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
			sdk.invoice.decryptPatientIdOf(
				decodedParams.invoice,
			)
		}.toPyStringAsyncCallback(SetSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateDelegationDeAnonymizationMetadataParams(
	public val entity: Invoice,
	public val delegates: Set<String>,
)

@OptIn(InternalIcureApi::class)
public fun createDelegationDeAnonymizationMetadataBlocking(sdk: CardinalApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<CreateDelegationDeAnonymizationMetadataParams>(params)
	runBlocking {
		sdk.invoice.createDelegationDeAnonymizationMetadata(
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
			sdk.invoice.createDelegationDeAnonymizationMetadata(
				decodedParams.entity,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptParams(
	public val invoice: EncryptedInvoice,
)

@OptIn(InternalIcureApi::class)
public fun decryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptParams>(params)
	runBlocking {
		sdk.invoice.decrypt(
			decodedParams.invoice,
		)
	}
}.toPyString(DecryptedInvoice.serializer())

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
			sdk.invoice.decrypt(
				decodedParams.invoice,
			)
		}.toPyStringAsyncCallback(DecryptedInvoice.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryDecryptParams(
	public val invoice: EncryptedInvoice,
)

@OptIn(InternalIcureApi::class)
public fun tryDecryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<TryDecryptParams>(params)
	runBlocking {
		sdk.invoice.tryDecrypt(
			decodedParams.invoice,
		)
	}
}.toPyString(PolymorphicSerializer(Invoice::class))

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
			sdk.invoice.tryDecrypt(
				decodedParams.invoice,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Invoice::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteInvoiceParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteInvoiceBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteInvoiceParams>(params)
	runBlocking {
		sdk.invoice.deleteInvoice(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteInvoiceAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteInvoiceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.deleteInvoice(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetTarificationsCodesOccurrencesParams(
	public val minOccurrence: Int,
)

@OptIn(InternalIcureApi::class)
public fun getTarificationsCodesOccurrencesBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetTarificationsCodesOccurrencesParams>(params)
	runBlocking {
		sdk.invoice.getTarificationsCodesOccurrences(
			decodedParams.minOccurrence,
		)
	}
}.toPyString(ListSerializer(LabelledOccurence.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getTarificationsCodesOccurrencesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetTarificationsCodesOccurrencesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.getTarificationsCodesOccurrences(
				decodedParams.minOccurrence,
			)
		}.toPyStringAsyncCallback(ListSerializer(LabelledOccurence.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithParams(
	public val delegateId: String,
	public val invoice: DecryptedInvoice,
	public val options: InvoiceShareOptions? = null,
)

@OptIn(InternalIcureApi::class)
public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.invoice.shareWith(
			decodedParams.delegateId,
			decodedParams.invoice,
			decodedParams.options,
		)
	}
}.toPyString(DecryptedInvoice.serializer())

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
			sdk.invoice.shareWith(
				decodedParams.delegateId,
				decodedParams.invoice,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(DecryptedInvoice.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val invoice: DecryptedInvoice,
	public val delegates: Map<String, InvoiceShareOptions>,
)

@OptIn(InternalIcureApi::class)
public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.invoice.shareWithMany(
			decodedParams.invoice,
			decodedParams.delegates,
		)
	}
}.toPyString(DecryptedInvoice.serializer())

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
			sdk.invoice.shareWithMany(
				decodedParams.invoice,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(DecryptedInvoice.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindInvoicesByHcPartyPatientParams(
	public val hcPartyId: String,
	public val patient: Patient,
	public val startDate: Long? = null,
	public val endDate: Long? = null,
	public val descending: Boolean? = null,
)

@OptIn(InternalIcureApi::class)
public fun findInvoicesByHcPartyPatientBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindInvoicesByHcPartyPatientParams>(params)
	runBlocking {
		sdk.invoice.findInvoicesByHcPartyPatient(
			decodedParams.hcPartyId,
			decodedParams.patient,
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.descending,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, DecryptedInvoice.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findInvoicesByHcPartyPatientAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindInvoicesByHcPartyPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.findInvoicesByHcPartyPatient(
				decodedParams.hcPartyId,
				decodedParams.patient,
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.descending,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, DecryptedInvoice.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class ModifyInvoiceParams(
	public val entity: DecryptedInvoice,
)

@OptIn(InternalIcureApi::class)
public fun modifyInvoiceBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyInvoiceParams>(params)
	runBlocking {
		sdk.invoice.modifyInvoice(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedInvoice.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyInvoiceAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyInvoiceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.modifyInvoice(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(DecryptedInvoice.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyInvoicesParams(
	public val entities: List<DecryptedInvoice>,
)

@OptIn(InternalIcureApi::class)
public fun modifyInvoicesBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyInvoicesParams>(params)
	runBlocking {
		sdk.invoice.modifyInvoices(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(DecryptedInvoice.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyInvoicesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyInvoicesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.modifyInvoices(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetInvoiceParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun getInvoiceBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetInvoiceParams>(params)
	runBlocking {
		sdk.invoice.getInvoice(
			decodedParams.entityId,
		)
	}
}.toPyString(DecryptedInvoice.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getInvoiceAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetInvoiceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.getInvoice(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DecryptedInvoice.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetInvoicesParams(
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getInvoicesBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetInvoicesParams>(params)
	runBlocking {
		sdk.invoice.getInvoices(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DecryptedInvoice.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getInvoicesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetInvoicesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.getInvoices(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ReassignInvoiceParams(
	public val invoice: DecryptedInvoice,
)

@OptIn(InternalIcureApi::class)
public fun reassignInvoiceBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ReassignInvoiceParams>(params)
	runBlocking {
		sdk.invoice.reassignInvoice(
			decodedParams.invoice,
		)
	}
}.toPyString(DecryptedInvoice.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun reassignInvoiceAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ReassignInvoiceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.reassignInvoice(
				decodedParams.invoice,
			)
		}.toPyStringAsyncCallback(DecryptedInvoice.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MergeToParams(
	public val invoiceId: String,
	public val ids: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun mergeToBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MergeToParams>(params)
	runBlocking {
		sdk.invoice.mergeTo(
			decodedParams.invoiceId,
			decodedParams.ids,
		)
	}
}.toPyString(DecryptedInvoice.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun mergeToAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MergeToParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.mergeTo(
				decodedParams.invoiceId,
				decodedParams.ids,
			)
		}.toPyStringAsyncCallback(DecryptedInvoice.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ValidateParams(
	public val invoiceId: String,
	public val scheme: String,
	public val forcedValue: String,
)

@OptIn(InternalIcureApi::class)
public fun validateBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ValidateParams>(params)
	runBlocking {
		sdk.invoice.validate(
			decodedParams.invoiceId,
			decodedParams.scheme,
			decodedParams.forcedValue,
		)
	}
}.toPyString(DecryptedInvoice.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun validateAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ValidateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.validate(
				decodedParams.invoiceId,
				decodedParams.scheme,
				decodedParams.forcedValue,
			)
		}.toPyStringAsyncCallback(DecryptedInvoice.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class AppendCodesParams(
	public val userId: String,
	public val type: String,
	public val sentMediumType: String,
	public val secretFKeys: String,
	public val insuranceId: String? = null,
	public val invoiceId: String? = null,
	public val gracePeriod: Int? = null,
	public val invoicingCodes: List<EncryptedInvoicingCode>,
)

@OptIn(InternalIcureApi::class)
public fun appendCodesBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<AppendCodesParams>(params)
	runBlocking {
		sdk.invoice.appendCodes(
			decodedParams.userId,
			decodedParams.type,
			decodedParams.sentMediumType,
			decodedParams.secretFKeys,
			decodedParams.insuranceId,
			decodedParams.invoiceId,
			decodedParams.gracePeriod,
			decodedParams.invoicingCodes,
		)
	}
}.toPyString(ListSerializer(DecryptedInvoice.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun appendCodesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<AppendCodesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.appendCodes(
				decodedParams.userId,
				decodedParams.type,
				decodedParams.sentMediumType,
				decodedParams.secretFKeys,
				decodedParams.insuranceId,
				decodedParams.invoiceId,
				decodedParams.gracePeriod,
				decodedParams.invoicingCodes,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class RemoveCodesParams(
	public val userId: String,
	public val serviceId: String,
	public val secretFKeys: String,
	public val tarificationIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun removeCodesBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<RemoveCodesParams>(params)
	runBlocking {
		sdk.invoice.removeCodes(
			decodedParams.userId,
			decodedParams.serviceId,
			decodedParams.secretFKeys,
			decodedParams.tarificationIds,
		)
	}
}.toPyString(ListSerializer(DecryptedInvoice.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun removeCodesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<RemoveCodesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.removeCodes(
				decodedParams.userId,
				decodedParams.serviceId,
				decodedParams.secretFKeys,
				decodedParams.tarificationIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindInvoicesByAuthorParams(
	public val hcPartyId: String,
	public val fromDate: Long? = null,
	public val toDate: Long? = null,
	public val startKey: JsonElement? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

@OptIn(InternalIcureApi::class)
public fun findInvoicesByAuthorBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindInvoicesByAuthorParams>(params)
	runBlocking {
		sdk.invoice.findInvoicesByAuthor(
			decodedParams.hcPartyId,
			decodedParams.fromDate,
			decodedParams.toDate,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(DecryptedInvoice.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findInvoicesByAuthorAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindInvoicesByAuthorParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.findInvoicesByAuthor(
				decodedParams.hcPartyId,
				decodedParams.fromDate,
				decodedParams.toDate,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(DecryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListInvoicesByHcPartyAndGroupIdParams(
	public val hcPartyId: String,
	public val groupId: String,
)

@OptIn(InternalIcureApi::class)
public fun listInvoicesByHcPartyAndGroupIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListInvoicesByHcPartyAndGroupIdParams>(params)
	runBlocking {
		sdk.invoice.listInvoicesByHcPartyAndGroupId(
			decodedParams.hcPartyId,
			decodedParams.groupId,
		)
	}
}.toPyString(ListSerializer(DecryptedInvoice.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listInvoicesByHcPartyAndGroupIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListInvoicesByHcPartyAndGroupIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.listInvoicesByHcPartyAndGroupId(
				decodedParams.hcPartyId,
				decodedParams.groupId,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateParams(
	public val hcPartyId: String,
	public val sentMediumType: MediumType,
	public val invoiceType: InvoiceType,
	public val sent: Boolean,
	public val from: Long? = null,
	public val to: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateBlocking(sdk: CardinalApis,
		params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateParams>(params)
	runBlocking {
		sdk.invoice.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
			decodedParams.hcPartyId,
			decodedParams.sentMediumType,
			decodedParams.invoiceType,
			decodedParams.sent,
			decodedParams.from,
			decodedParams.to,
		)
	}
}.toPyString(ListSerializer(DecryptedInvoice.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
				decodedParams.hcPartyId,
				decodedParams.sentMediumType,
				decodedParams.invoiceType,
				decodedParams.sent,
				decodedParams.from,
				decodedParams.to,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListInvoicesByContactIdsParams(
	public val contactIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun listInvoicesByContactIdsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListInvoicesByContactIdsParams>(params)
	runBlocking {
		sdk.invoice.listInvoicesByContactIds(
			decodedParams.contactIds,
		)
	}
}.toPyString(ListSerializer(DecryptedInvoice.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listInvoicesByContactIdsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListInvoicesByContactIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.listInvoicesByContactIds(
				decodedParams.contactIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListInvoicesByRecipientsIdsParams(
	public val recipientsIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun listInvoicesByRecipientsIdsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListInvoicesByRecipientsIdsParams>(params)
	runBlocking {
		sdk.invoice.listInvoicesByRecipientsIds(
			decodedParams.recipientsIds,
		)
	}
}.toPyString(ListSerializer(DecryptedInvoice.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listInvoicesByRecipientsIdsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListInvoicesByRecipientsIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.listInvoicesByRecipientsIds(
				decodedParams.recipientsIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListToInsurancesParams(
	public val userIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun listToInsurancesBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListToInsurancesParams>(params)
	runBlocking {
		sdk.invoice.listToInsurances(
			decodedParams.userIds,
		)
	}
}.toPyString(ListSerializer(DecryptedInvoice.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listToInsurancesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListToInsurancesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.listToInsurances(
				decodedParams.userIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListToInsurancesUnsentParams(
	public val userIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun listToInsurancesUnsentBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListToInsurancesUnsentParams>(params)
	runBlocking {
		sdk.invoice.listToInsurancesUnsent(
			decodedParams.userIds,
		)
	}
}.toPyString(ListSerializer(DecryptedInvoice.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listToInsurancesUnsentAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListToInsurancesUnsentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.listToInsurancesUnsent(
				decodedParams.userIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListToPatientsParams(
	public val hcPartyId: String,
)

@OptIn(InternalIcureApi::class)
public fun listToPatientsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListToPatientsParams>(params)
	runBlocking {
		sdk.invoice.listToPatients(
			decodedParams.hcPartyId,
		)
	}
}.toPyString(ListSerializer(DecryptedInvoice.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listToPatientsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListToPatientsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.listToPatients(
				decodedParams.hcPartyId,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListToPatientsUnsentParams(
	public val hcPartyId: String?,
)

@OptIn(InternalIcureApi::class)
public fun listToPatientsUnsentBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListToPatientsUnsentParams>(params)
	runBlocking {
		sdk.invoice.listToPatientsUnsent(
			decodedParams.hcPartyId,
		)
	}
}.toPyString(ListSerializer(DecryptedInvoice.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listToPatientsUnsentAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListToPatientsUnsentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.listToPatientsUnsent(
				decodedParams.hcPartyId,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListInvoicesByIdsParams(
	public val ids: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun listInvoicesByIdsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListInvoicesByIdsParams>(params)
	runBlocking {
		sdk.invoice.listInvoicesByIds(
			decodedParams.ids,
		)
	}
}.toPyString(ListSerializer(DecryptedInvoice.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listInvoicesByIdsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListInvoicesByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.listInvoicesByIds(
				decodedParams.ids,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListInvoicesByHcpartySendingModeStatusDateParams(
	public val hcPartyId: String,
	public val sendingMode: String,
	public val status: String,
	public val from: Long,
	public val to: Long,
)

@OptIn(InternalIcureApi::class)
public fun listInvoicesByHcpartySendingModeStatusDateBlocking(sdk: CardinalApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListInvoicesByHcpartySendingModeStatusDateParams>(params)
	runBlocking {
		sdk.invoice.listInvoicesByHcpartySendingModeStatusDate(
			decodedParams.hcPartyId,
			decodedParams.sendingMode,
			decodedParams.status,
			decodedParams.from,
			decodedParams.to,
		)
	}
}.toPyString(ListSerializer(DecryptedInvoice.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listInvoicesByHcpartySendingModeStatusDateAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListInvoicesByHcpartySendingModeStatusDateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.listInvoicesByHcpartySendingModeStatusDate(
				decodedParams.hcPartyId,
				decodedParams.sendingMode,
				decodedParams.status,
				decodedParams.from,
				decodedParams.to,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListInvoicesByServiceIdsParams(
	public val serviceIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun listInvoicesByServiceIdsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListInvoicesByServiceIdsParams>(params)
	runBlocking {
		sdk.invoice.listInvoicesByServiceIds(
			decodedParams.serviceIds,
		)
	}
}.toPyString(ListSerializer(DecryptedInvoice.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listInvoicesByServiceIdsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListInvoicesByServiceIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.listInvoicesByServiceIds(
				decodedParams.serviceIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListAllHcpsByStatusParams(
	public val status: String,
	public val from: Long? = null,
	public val to: Long? = null,
	public val hcpIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun listAllHcpsByStatusBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListAllHcpsByStatusParams>(params)
	runBlocking {
		sdk.invoice.listAllHcpsByStatus(
			decodedParams.status,
			decodedParams.from,
			decodedParams.to,
			decodedParams.hcpIds,
		)
	}
}.toPyString(ListSerializer(DecryptedInvoice.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listAllHcpsByStatusAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListAllHcpsByStatusParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.listAllHcpsByStatus(
				decodedParams.status,
				decodedParams.from,
				decodedParams.to,
				decodedParams.hcpIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedInvoice.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
