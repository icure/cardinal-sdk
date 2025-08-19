// auto-generated file
package com.icure.cardinal.sdk.py.api.ReceiptApi

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.ReceiptShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.model.DecryptedReceipt
import com.icure.cardinal.sdk.model.EncryptedReceipt
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.Receipt
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.serialization.ByteArraySerializer
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Byte
import kotlin.ByteArray
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
	public val base: DecryptedReceipt?,
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
		sdk.receipt.withEncryptionMetadata(
			decodedParams.base,
			decodedParams.patient,
			decodedParams.user,
			decodedParams.delegates,
			decodedParams.secretId,
			decodedParams.alternateRootDelegateId,
		)
	}
}.toPyString(DecryptedReceipt.serializer())

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
			sdk.receipt.withEncryptionMetadata(
				decodedParams.base,
				decodedParams.patient,
				decodedParams.user,
				decodedParams.delegates,
				decodedParams.secretId,
				decodedParams.alternateRootDelegateId,
			)
		}.toPyStringAsyncCallback(DecryptedReceipt.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetAndDecryptReceiptAttachmentParams(
	public val receipt: Receipt,
	public val attachmentId: String,
)

@OptIn(InternalIcureApi::class)
public fun getAndDecryptReceiptAttachmentBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetAndDecryptReceiptAttachmentParams>(params)
	runBlocking {
		sdk.receipt.getAndDecryptReceiptAttachment(
			decodedParams.receipt,
			decodedParams.attachmentId,
		)
	}
}.toPyString(ByteArraySerializer)

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getAndDecryptReceiptAttachmentAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetAndDecryptReceiptAttachmentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.receipt.getAndDecryptReceiptAttachment(
				decodedParams.receipt,
				decodedParams.attachmentId,
			)
		}.toPyStringAsyncCallback(ByteArraySerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class EncryptAndSetReceiptAttachmentParams(
	public val receipt: Receipt,
	public val blobType: String,
	@Serializable(ByteArraySerializer::class)
	@OptIn(InternalIcureApi::class)
	public val attachment: ByteArray,
)

@OptIn(InternalIcureApi::class)
public fun encryptAndSetReceiptAttachmentBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<EncryptAndSetReceiptAttachmentParams>(params)
	runBlocking {
		sdk.receipt.encryptAndSetReceiptAttachment(
			decodedParams.receipt,
			decodedParams.blobType,
			decodedParams.attachment,
		)
	}
}.toPyString(EncryptedReceipt.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun encryptAndSetReceiptAttachmentAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<EncryptAndSetReceiptAttachmentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.receipt.encryptAndSetReceiptAttachment(
				decodedParams.receipt,
				decodedParams.blobType,
				decodedParams.attachment,
			)
		}.toPyStringAsyncCallback(EncryptedReceipt.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetEncryptionKeysOfParams(
	public val receipt: Receipt,
)

@OptIn(InternalIcureApi::class)
public fun getEncryptionKeysOfBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetEncryptionKeysOfParams>(params)
	runBlocking {
		sdk.receipt.getEncryptionKeysOf(
			decodedParams.receipt,
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
			sdk.receipt.getEncryptionKeysOf(
				decodedParams.receipt,
			)
		}.toPyStringAsyncCallback(SetSerializer(HexString.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class HasWriteAccessParams(
	public val receipt: Receipt,
)

@OptIn(InternalIcureApi::class)
public fun hasWriteAccessBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<HasWriteAccessParams>(params)
	runBlocking {
		sdk.receipt.hasWriteAccess(
			decodedParams.receipt,
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
			sdk.receipt.hasWriteAccess(
				decodedParams.receipt,
			)
		}.toPyStringAsyncCallback(Boolean.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptPatientIdOfParams(
	public val receipt: Receipt,
)

@OptIn(InternalIcureApi::class)
public fun decryptPatientIdOfBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptPatientIdOfParams>(params)
	runBlocking {
		sdk.receipt.decryptPatientIdOf(
			decodedParams.receipt,
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
			sdk.receipt.decryptPatientIdOf(
				decodedParams.receipt,
			)
		}.toPyStringAsyncCallback(SetSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateDelegationDeAnonymizationMetadataParams(
	public val entity: Receipt,
	public val delegates: Set<String>,
)

@OptIn(InternalIcureApi::class)
public fun createDelegationDeAnonymizationMetadataBlocking(sdk: CardinalApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<CreateDelegationDeAnonymizationMetadataParams>(params)
	runBlocking {
		sdk.receipt.createDelegationDeAnonymizationMetadata(
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
			sdk.receipt.createDelegationDeAnonymizationMetadata(
				decodedParams.entity,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class LogReceiptParams(
	public val user: User,
	public val docId: String,
	public val refs: List<String>,
	public val blobType: String,
	@Serializable(ByteArraySerializer::class)
	@OptIn(InternalIcureApi::class)
	public val blob: ByteArray,
)

@OptIn(InternalIcureApi::class)
public fun logReceiptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<LogReceiptParams>(params)
	runBlocking {
		sdk.receipt.logReceipt(
			decodedParams.user,
			decodedParams.docId,
			decodedParams.refs,
			decodedParams.blobType,
			decodedParams.blob,
		)
	}
}.toPyString(PolymorphicSerializer(Receipt::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun logReceiptAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<LogReceiptParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.receipt.logReceipt(
				decodedParams.user,
				decodedParams.docId,
				decodedParams.refs,
				decodedParams.blobType,
				decodedParams.blob,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Receipt::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptParams(
	public val receipt: EncryptedReceipt,
)

@OptIn(InternalIcureApi::class)
public fun decryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptParams>(params)
	runBlocking {
		sdk.receipt.decrypt(
			decodedParams.receipt,
		)
	}
}.toPyString(DecryptedReceipt.serializer())

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
			sdk.receipt.decrypt(
				decodedParams.receipt,
			)
		}.toPyStringAsyncCallback(DecryptedReceipt.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryDecryptParams(
	public val receipt: EncryptedReceipt,
)

@OptIn(InternalIcureApi::class)
public fun tryDecryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<TryDecryptParams>(params)
	runBlocking {
		sdk.receipt.tryDecrypt(
			decodedParams.receipt,
		)
	}
}.toPyString(PolymorphicSerializer(Receipt::class))

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
			sdk.receipt.tryDecrypt(
				decodedParams.receipt,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Receipt::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteReceiptParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteReceiptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteReceiptParams>(params)
	runBlocking {
		sdk.receipt.deleteReceipt(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteReceiptAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteReceiptParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.receipt.deleteReceipt(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteReceiptsParams(
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun deleteReceiptsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteReceiptsParams>(params)
	runBlocking {
		sdk.receipt.deleteReceipts(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteReceiptsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteReceiptsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.receipt.deleteReceipts(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetRawReceiptAttachmentParams(
	public val receiptId: String,
	public val attachmentId: String,
)

@OptIn(InternalIcureApi::class)
public fun getRawReceiptAttachmentBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetRawReceiptAttachmentParams>(params)
	runBlocking {
		sdk.receipt.getRawReceiptAttachment(
			decodedParams.receiptId,
			decodedParams.attachmentId,
		)
	}
}.toPyString(ByteArraySerializer)

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getRawReceiptAttachmentAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetRawReceiptAttachmentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.receipt.getRawReceiptAttachment(
				decodedParams.receiptId,
				decodedParams.attachmentId,
			)
		}.toPyStringAsyncCallback(ByteArraySerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SetRawReceiptAttachmentParams(
	public val receiptId: String,
	public val rev: String,
	public val blobType: String,
	@Serializable(ByteArraySerializer::class)
	@OptIn(InternalIcureApi::class)
	public val attachment: ByteArray,
)

@OptIn(InternalIcureApi::class)
public fun setRawReceiptAttachmentBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SetRawReceiptAttachmentParams>(params)
	runBlocking {
		sdk.receipt.setRawReceiptAttachment(
			decodedParams.receiptId,
			decodedParams.rev,
			decodedParams.blobType,
			decodedParams.attachment,
		)
	}
}.toPyString(EncryptedReceipt.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun setRawReceiptAttachmentAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SetRawReceiptAttachmentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.receipt.setRawReceiptAttachment(
				decodedParams.receiptId,
				decodedParams.rev,
				decodedParams.blobType,
				decodedParams.attachment,
			)
		}.toPyStringAsyncCallback(EncryptedReceipt.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithParams(
	public val delegateId: String,
	public val receipt: DecryptedReceipt,
	public val options: ReceiptShareOptions? = null,
)

@OptIn(InternalIcureApi::class)
public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.receipt.shareWith(
			decodedParams.delegateId,
			decodedParams.receipt,
			decodedParams.options,
		)
	}
}.toPyString(DecryptedReceipt.serializer())

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
			sdk.receipt.shareWith(
				decodedParams.delegateId,
				decodedParams.receipt,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(DecryptedReceipt.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val receipt: DecryptedReceipt,
	public val delegates: Map<String, ReceiptShareOptions>,
)

@OptIn(InternalIcureApi::class)
public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.receipt.shareWithMany(
			decodedParams.receipt,
			decodedParams.delegates,
		)
	}
}.toPyString(DecryptedReceipt.serializer())

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
			sdk.receipt.shareWithMany(
				decodedParams.receipt,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(DecryptedReceipt.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateReceiptParams(
	public val entity: DecryptedReceipt,
)

@OptIn(InternalIcureApi::class)
public fun createReceiptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateReceiptParams>(params)
	runBlocking {
		sdk.receipt.createReceipt(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedReceipt.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createReceiptAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateReceiptParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.receipt.createReceipt(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(DecryptedReceipt.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyReceiptParams(
	public val entity: DecryptedReceipt,
)

@OptIn(InternalIcureApi::class)
public fun modifyReceiptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyReceiptParams>(params)
	runBlocking {
		sdk.receipt.modifyReceipt(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedReceipt.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyReceiptAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyReceiptParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.receipt.modifyReceipt(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(DecryptedReceipt.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetReceiptParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun getReceiptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetReceiptParams>(params)
	runBlocking {
		sdk.receipt.getReceipt(
			decodedParams.entityId,
		)
	}
}.toPyString(DecryptedReceipt.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getReceiptAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetReceiptParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.receipt.getReceipt(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DecryptedReceipt.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListByReferenceParams(
	public val reference: String,
)

@OptIn(InternalIcureApi::class)
public fun listByReferenceBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListByReferenceParams>(params)
	runBlocking {
		sdk.receipt.listByReference(
			decodedParams.reference,
		)
	}
}.toPyString(ListSerializer(DecryptedReceipt.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listByReferenceAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListByReferenceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.receipt.listByReference(
				decodedParams.reference,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedReceipt.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
