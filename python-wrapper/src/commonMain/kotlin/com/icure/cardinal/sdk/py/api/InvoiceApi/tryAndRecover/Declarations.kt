// auto-generated file
package com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.InvoiceShareOptions
import com.icure.cardinal.sdk.model.Invoice
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.embed.EncryptedInvoicingCode
import com.icure.cardinal.sdk.model.embed.InvoiceType
import com.icure.cardinal.sdk.model.embed.MediumType
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
import kotlinx.serialization.json.JsonElement

@Serializable
private class ShareWithParams(
	public val delegateId: String,
	public val invoice: Invoice,
	public val options: InvoiceShareOptions? = null,
)

@OptIn(InternalIcureApi::class)
public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.shareWith(
			decodedParams.delegateId,
			decodedParams.invoice,
			decodedParams.options,
		)
	}
}.toPyString(PolymorphicSerializer(Invoice::class))

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
			sdk.invoice.tryAndRecover.shareWith(
				decodedParams.delegateId,
				decodedParams.invoice,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Invoice::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val invoice: Invoice,
	public val delegates: Map<String, InvoiceShareOptions>,
)

@OptIn(InternalIcureApi::class)
public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.shareWithMany(
			decodedParams.invoice,
			decodedParams.delegates,
		)
	}
}.toPyString(PolymorphicSerializer(Invoice::class))

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
			sdk.invoice.tryAndRecover.shareWithMany(
				decodedParams.invoice,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Invoice::class), resultCallback)
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
		sdk.invoice.tryAndRecover.findInvoicesByHcPartyPatient(
			decodedParams.hcPartyId,
			decodedParams.patient,
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.descending,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, PolymorphicSerializer(Invoice::class))}

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
			sdk.invoice.tryAndRecover.findInvoicesByHcPartyPatient(
				decodedParams.hcPartyId,
				decodedParams.patient,
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.descending,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, PolymorphicSerializer(Invoice::class))}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class CreateInvoiceParams(
	public val entity: Invoice,
)

@OptIn(InternalIcureApi::class)
public fun createInvoiceBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateInvoiceParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.createInvoice(
			decodedParams.entity,
		)
	}
}.toPyString(PolymorphicSerializer(Invoice::class))

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
			sdk.invoice.tryAndRecover.createInvoice(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Invoice::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateInvoicesParams(
	public val entities: List<Invoice>,
)

@OptIn(InternalIcureApi::class)
public fun createInvoicesBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateInvoicesParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.createInvoices(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Invoice::class)))

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
			sdk.invoice.tryAndRecover.createInvoices(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Invoice::class)), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteInvoiceByIdParams(
	public val id: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun undeleteInvoiceByIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteInvoiceByIdParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.undeleteInvoiceById(
			decodedParams.id,
			decodedParams.rev,
		)
	}
}.toPyString(PolymorphicSerializer(Invoice::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteInvoiceByIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteInvoiceByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.tryAndRecover.undeleteInvoiceById(
				decodedParams.id,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Invoice::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteInvoicesByIdsParams(
	public val entityIds: List<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteInvoicesByIdsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteInvoicesByIdsParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.undeleteInvoicesByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Invoice::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteInvoicesByIdsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteInvoicesByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.tryAndRecover.undeleteInvoicesByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Invoice::class)), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteInvoiceParams(
	public val invoice: Invoice,
)

@OptIn(InternalIcureApi::class)
public fun undeleteInvoiceBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteInvoiceParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.undeleteInvoice(
			decodedParams.invoice,
		)
	}
}.toPyString(PolymorphicSerializer(Invoice::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteInvoiceAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteInvoiceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.tryAndRecover.undeleteInvoice(
				decodedParams.invoice,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Invoice::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteInvoicesParams(
	public val invoices: List<Invoice>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteInvoicesBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteInvoicesParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.undeleteInvoices(
			decodedParams.invoices,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Invoice::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteInvoicesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteInvoicesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.invoice.tryAndRecover.undeleteInvoices(
				decodedParams.invoices,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Invoice::class)), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyInvoiceParams(
	public val entity: Invoice,
)

@OptIn(InternalIcureApi::class)
public fun modifyInvoiceBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyInvoiceParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.modifyInvoice(
			decodedParams.entity,
		)
	}
}.toPyString(PolymorphicSerializer(Invoice::class))

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
			sdk.invoice.tryAndRecover.modifyInvoice(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Invoice::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyInvoicesParams(
	public val entities: List<Invoice>,
)

@OptIn(InternalIcureApi::class)
public fun modifyInvoicesBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyInvoicesParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.modifyInvoices(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Invoice::class)))

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
			sdk.invoice.tryAndRecover.modifyInvoices(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Invoice::class)), resultCallback)
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
		sdk.invoice.tryAndRecover.getInvoice(
			decodedParams.entityId,
		)
	}
}.toPyString(PolymorphicSerializer(Invoice::class))

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
			sdk.invoice.tryAndRecover.getInvoice(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Invoice::class), resultCallback)
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
		sdk.invoice.tryAndRecover.getInvoices(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Invoice::class)))

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
			sdk.invoice.tryAndRecover.getInvoices(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Invoice::class)), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ReassignInvoiceParams(
	public val invoice: Invoice,
)

@OptIn(InternalIcureApi::class)
public fun reassignInvoiceBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ReassignInvoiceParams>(params)
	runBlocking {
		sdk.invoice.tryAndRecover.reassignInvoice(
			decodedParams.invoice,
		)
	}
}.toPyString(PolymorphicSerializer(Invoice::class))

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
			sdk.invoice.tryAndRecover.reassignInvoice(
				decodedParams.invoice,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Invoice::class), resultCallback)
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
		sdk.invoice.tryAndRecover.mergeTo(
			decodedParams.invoiceId,
			decodedParams.ids,
		)
	}
}.toPyString(PolymorphicSerializer(Invoice::class))

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
			sdk.invoice.tryAndRecover.mergeTo(
				decodedParams.invoiceId,
				decodedParams.ids,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Invoice::class), resultCallback)
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
		sdk.invoice.tryAndRecover.validate(
			decodedParams.invoiceId,
			decodedParams.scheme,
			decodedParams.forcedValue,
		)
	}
}.toPyString(PolymorphicSerializer(Invoice::class))

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
			sdk.invoice.tryAndRecover.validate(
				decodedParams.invoiceId,
				decodedParams.scheme,
				decodedParams.forcedValue,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Invoice::class), resultCallback)
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
		sdk.invoice.tryAndRecover.appendCodes(
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
}.toPyString(ListSerializer(PolymorphicSerializer(Invoice::class)))

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
			sdk.invoice.tryAndRecover.appendCodes(
				decodedParams.userId,
				decodedParams.type,
				decodedParams.sentMediumType,
				decodedParams.secretFKeys,
				decodedParams.insuranceId,
				decodedParams.invoiceId,
				decodedParams.gracePeriod,
				decodedParams.invoicingCodes,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Invoice::class)), resultCallback)
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
		sdk.invoice.tryAndRecover.removeCodes(
			decodedParams.userId,
			decodedParams.serviceId,
			decodedParams.secretFKeys,
			decodedParams.tarificationIds,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Invoice::class)))

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
			sdk.invoice.tryAndRecover.removeCodes(
				decodedParams.userId,
				decodedParams.serviceId,
				decodedParams.secretFKeys,
				decodedParams.tarificationIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Invoice::class)), resultCallback)
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
		sdk.invoice.tryAndRecover.findInvoicesByAuthor(
			decodedParams.hcPartyId,
			decodedParams.fromDate,
			decodedParams.toDate,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(PolymorphicSerializer(Invoice::class)))

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
			sdk.invoice.tryAndRecover.findInvoicesByAuthor(
				decodedParams.hcPartyId,
				decodedParams.fromDate,
				decodedParams.toDate,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(PolymorphicSerializer(Invoice::class)),
				resultCallback)
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
		sdk.invoice.tryAndRecover.listInvoicesByHcPartyAndGroupId(
			decodedParams.hcPartyId,
			decodedParams.groupId,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Invoice::class)))

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
			sdk.invoice.tryAndRecover.listInvoicesByHcPartyAndGroupId(
				decodedParams.hcPartyId,
				decodedParams.groupId,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Invoice::class)), resultCallback)
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
		sdk.invoice.tryAndRecover.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
			decodedParams.hcPartyId,
			decodedParams.sentMediumType,
			decodedParams.invoiceType,
			decodedParams.sent,
			decodedParams.from,
			decodedParams.to,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Invoice::class)))

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
			sdk.invoice.tryAndRecover.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
				decodedParams.hcPartyId,
				decodedParams.sentMediumType,
				decodedParams.invoiceType,
				decodedParams.sent,
				decodedParams.from,
				decodedParams.to,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Invoice::class)), resultCallback)
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
		sdk.invoice.tryAndRecover.listInvoicesByContactIds(
			decodedParams.contactIds,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Invoice::class)))

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
			sdk.invoice.tryAndRecover.listInvoicesByContactIds(
				decodedParams.contactIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Invoice::class)), resultCallback)
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
		sdk.invoice.tryAndRecover.listInvoicesByRecipientsIds(
			decodedParams.recipientsIds,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Invoice::class)))

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
			sdk.invoice.tryAndRecover.listInvoicesByRecipientsIds(
				decodedParams.recipientsIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Invoice::class)), resultCallback)
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
		sdk.invoice.tryAndRecover.listToInsurances(
			decodedParams.userIds,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Invoice::class)))

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
			sdk.invoice.tryAndRecover.listToInsurances(
				decodedParams.userIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Invoice::class)), resultCallback)
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
		sdk.invoice.tryAndRecover.listToInsurancesUnsent(
			decodedParams.userIds,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Invoice::class)))

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
			sdk.invoice.tryAndRecover.listToInsurancesUnsent(
				decodedParams.userIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Invoice::class)), resultCallback)
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
		sdk.invoice.tryAndRecover.listToPatients(
			decodedParams.hcPartyId,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Invoice::class)))

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
			sdk.invoice.tryAndRecover.listToPatients(
				decodedParams.hcPartyId,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Invoice::class)), resultCallback)
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
		sdk.invoice.tryAndRecover.listToPatientsUnsent(
			decodedParams.hcPartyId,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Invoice::class)))

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
			sdk.invoice.tryAndRecover.listToPatientsUnsent(
				decodedParams.hcPartyId,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Invoice::class)), resultCallback)
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
		sdk.invoice.tryAndRecover.listInvoicesByIds(
			decodedParams.ids,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Invoice::class)))

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
			sdk.invoice.tryAndRecover.listInvoicesByIds(
				decodedParams.ids,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Invoice::class)), resultCallback)
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
		sdk.invoice.tryAndRecover.listInvoicesByHcpartySendingModeStatusDate(
			decodedParams.hcPartyId,
			decodedParams.sendingMode,
			decodedParams.status,
			decodedParams.from,
			decodedParams.to,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Invoice::class)))

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
			sdk.invoice.tryAndRecover.listInvoicesByHcpartySendingModeStatusDate(
				decodedParams.hcPartyId,
				decodedParams.sendingMode,
				decodedParams.status,
				decodedParams.from,
				decodedParams.to,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Invoice::class)), resultCallback)
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
		sdk.invoice.tryAndRecover.listInvoicesByServiceIds(
			decodedParams.serviceIds,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Invoice::class)))

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
			sdk.invoice.tryAndRecover.listInvoicesByServiceIds(
				decodedParams.serviceIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Invoice::class)), resultCallback)
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
		sdk.invoice.tryAndRecover.listAllHcpsByStatus(
			decodedParams.status,
			decodedParams.from,
			decodedParams.to,
			decodedParams.hcpIds,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Invoice::class)))

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
			sdk.invoice.tryAndRecover.listAllHcpsByStatus(
				decodedParams.status,
				decodedParams.from,
				decodedParams.to,
				decodedParams.hcpIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Invoice::class)), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
