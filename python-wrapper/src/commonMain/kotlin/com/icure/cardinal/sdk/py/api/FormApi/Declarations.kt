// auto-generated file
package com.icure.cardinal.sdk.py.api.FormApi

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.FormShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.DecryptedForm
import com.icure.cardinal.sdk.model.EncryptedForm
import com.icure.cardinal.sdk.model.Form
import com.icure.cardinal.sdk.model.FormTemplate
import com.icure.cardinal.sdk.model.Patient
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
import com.icure.cardinal.sdk.serialization.ByteArraySerializer
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Byte
import kotlin.ByteArray
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
	public val base: DecryptedForm?,
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
		sdk.form.withEncryptionMetadata(
			decodedParams.base,
			decodedParams.patient,
			decodedParams.user,
			decodedParams.delegates,
			decodedParams.secretId,
			decodedParams.alternateRootDelegateId,
		)
	}
}.toPyString(DecryptedForm.serializer())

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
			sdk.form.withEncryptionMetadata(
				decodedParams.base,
				decodedParams.patient,
				decodedParams.user,
				decodedParams.delegates,
				decodedParams.secretId,
				decodedParams.alternateRootDelegateId,
			)
		}.toPyStringAsyncCallback(DecryptedForm.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetEncryptionKeysOfParams(
	public val form: Form,
)

@OptIn(InternalIcureApi::class)
public fun getEncryptionKeysOfBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetEncryptionKeysOfParams>(params)
	runBlocking {
		sdk.form.getEncryptionKeysOf(
			decodedParams.form,
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
			sdk.form.getEncryptionKeysOf(
				decodedParams.form,
			)
		}.toPyStringAsyncCallback(SetSerializer(HexString.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class HasWriteAccessParams(
	public val form: Form,
)

@OptIn(InternalIcureApi::class)
public fun hasWriteAccessBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<HasWriteAccessParams>(params)
	runBlocking {
		sdk.form.hasWriteAccess(
			decodedParams.form,
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
			sdk.form.hasWriteAccess(
				decodedParams.form,
			)
		}.toPyStringAsyncCallback(Boolean.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptPatientIdOfParams(
	public val form: Form,
)

@OptIn(InternalIcureApi::class)
public fun decryptPatientIdOfBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptPatientIdOfParams>(params)
	runBlocking {
		sdk.form.decryptPatientIdOf(
			decodedParams.form,
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
			sdk.form.decryptPatientIdOf(
				decodedParams.form,
			)
		}.toPyStringAsyncCallback(SetSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateDelegationDeAnonymizationMetadataParams(
	public val entity: Form,
	public val delegates: Set<String>,
)

@OptIn(InternalIcureApi::class)
public fun createDelegationDeAnonymizationMetadataBlocking(sdk: CardinalApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<CreateDelegationDeAnonymizationMetadataParams>(params)
	runBlocking {
		sdk.form.createDelegationDeAnonymizationMetadata(
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
			sdk.form.createDelegationDeAnonymizationMetadata(
				decodedParams.entity,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptParams(
	public val form: EncryptedForm,
)

@OptIn(InternalIcureApi::class)
public fun decryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptParams>(params)
	runBlocking {
		sdk.form.decrypt(
			decodedParams.form,
		)
	}
}.toPyString(DecryptedForm.serializer())

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
			sdk.form.decrypt(
				decodedParams.form,
			)
		}.toPyStringAsyncCallback(DecryptedForm.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryDecryptParams(
	public val form: EncryptedForm,
)

@OptIn(InternalIcureApi::class)
public fun tryDecryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<TryDecryptParams>(params)
	runBlocking {
		sdk.form.tryDecrypt(
			decodedParams.form,
		)
	}
}.toPyString(PolymorphicSerializer(Form::class))

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
			sdk.form.tryDecrypt(
				decodedParams.form,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Form::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchFormsByParams(
	public val filter: FilterOptions<Form>,
)

@OptIn(InternalIcureApi::class)
public fun matchFormsByBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchFormsByParams>(params)
	runBlocking {
		sdk.form.matchFormsBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchFormsByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchFormsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.matchFormsBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchFormsBySortedParams(
	public val filter: SortableFilterOptions<Form>,
)

@OptIn(InternalIcureApi::class)
public fun matchFormsBySortedBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchFormsBySortedParams>(params)
	runBlocking {
		sdk.form.matchFormsBySorted(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchFormsBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchFormsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.matchFormsBySorted(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteFormUnsafeParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteFormUnsafeBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteFormUnsafeParams>(params)
	runBlocking {
		sdk.form.deleteFormUnsafe(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteFormUnsafeAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteFormUnsafeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.deleteFormUnsafe(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteFormsUnsafeParams(
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun deleteFormsUnsafeBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteFormsUnsafeParams>(params)
	runBlocking {
		sdk.form.deleteFormsUnsafe(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteFormsUnsafeAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteFormsUnsafeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.deleteFormsUnsafe(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteFormByIdParams(
	public val entityId: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteFormByIdBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteFormByIdParams>(params)
	runBlocking {
		sdk.form.deleteFormById(
			decodedParams.entityId,
			decodedParams.rev,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteFormByIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteFormByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.deleteFormById(
				decodedParams.entityId,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteFormsByIdsParams(
	public val entityIds: List<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun deleteFormsByIdsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteFormsByIdsParams>(params)
	runBlocking {
		sdk.form.deleteFormsByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteFormsByIdsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteFormsByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.deleteFormsByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeFormByIdParams(
	public val id: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun purgeFormByIdBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeFormByIdParams>(params)
	runBlocking {
		sdk.form.purgeFormById(
			decodedParams.id,
			decodedParams.rev,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeFormByIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeFormByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.purgeFormById(
				decodedParams.id,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteFormParams(
	public val form: Form,
)

@OptIn(InternalIcureApi::class)
public fun deleteFormBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteFormParams>(params)
	runBlocking {
		sdk.form.deleteForm(
			decodedParams.form,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteFormAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteFormParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.deleteForm(
				decodedParams.form,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteFormsParams(
	public val forms: List<Form>,
)

@OptIn(InternalIcureApi::class)
public fun deleteFormsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteFormsParams>(params)
	runBlocking {
		sdk.form.deleteForms(
			decodedParams.forms,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteFormsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteFormsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.deleteForms(
				decodedParams.forms,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeFormParams(
	public val form: Form,
)

@OptIn(InternalIcureApi::class)
public fun purgeFormBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeFormParams>(params)
	runBlocking {
		sdk.form.purgeForm(
			decodedParams.form,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeFormAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeFormParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.purgeForm(
				decodedParams.form,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetFormTemplateParams(
	public val formTemplateId: String,
	public val raw: Boolean? = null,
)

@OptIn(InternalIcureApi::class)
public fun getFormTemplateBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormTemplateParams>(params)
	runBlocking {
		sdk.form.getFormTemplate(
			decodedParams.formTemplateId,
			decodedParams.raw,
		)
	}
}.toPyString(FormTemplate.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getFormTemplateAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormTemplateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.getFormTemplate(
				decodedParams.formTemplateId,
				decodedParams.raw,
			)
		}.toPyStringAsyncCallback(FormTemplate.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListFormTemplatesBySpecialityParams(
	public val specialityCode: String,
	public val raw: Boolean? = null,
)

@OptIn(InternalIcureApi::class)
public fun listFormTemplatesBySpecialityBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListFormTemplatesBySpecialityParams>(params)
	runBlocking {
		sdk.form.listFormTemplatesBySpeciality(
			decodedParams.specialityCode,
			decodedParams.raw,
		)
	}
}.toPyString(ListSerializer(FormTemplate.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listFormTemplatesBySpecialityAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListFormTemplatesBySpecialityParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.listFormTemplatesBySpeciality(
				decodedParams.specialityCode,
				decodedParams.raw,
			)
		}.toPyStringAsyncCallback(ListSerializer(FormTemplate.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetFormTemplatesParams(
	public val loadLayout: Boolean? = null,
	public val raw: Boolean? = null,
)

@OptIn(InternalIcureApi::class)
public fun getFormTemplatesBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormTemplatesParams>(params)
	runBlocking {
		sdk.form.getFormTemplates(
			decodedParams.loadLayout,
			decodedParams.raw,
		)
	}
}.toPyString(ListSerializer(FormTemplate.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getFormTemplatesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormTemplatesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.getFormTemplates(
				decodedParams.loadLayout,
				decodedParams.raw,
			)
		}.toPyStringAsyncCallback(ListSerializer(FormTemplate.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateFormTemplateParams(
	public val formTemplate: FormTemplate,
)

@OptIn(InternalIcureApi::class)
public fun createFormTemplateBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateFormTemplateParams>(params)
	runBlocking {
		sdk.form.createFormTemplate(
			decodedParams.formTemplate,
		)
	}
}.toPyString(FormTemplate.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createFormTemplateAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateFormTemplateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.createFormTemplate(
				decodedParams.formTemplate,
			)
		}.toPyStringAsyncCallback(FormTemplate.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteFormTemplateParams(
	public val formTemplateId: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteFormTemplateBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteFormTemplateParams>(params)
	runBlocking {
		sdk.form.deleteFormTemplate(
			decodedParams.formTemplateId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteFormTemplateAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteFormTemplateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.deleteFormTemplate(
				decodedParams.formTemplateId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UpdateFormTemplateParams(
	public val formTemplate: FormTemplate,
)

@OptIn(InternalIcureApi::class)
public fun updateFormTemplateBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UpdateFormTemplateParams>(params)
	runBlocking {
		sdk.form.updateFormTemplate(
			decodedParams.formTemplate,
		)
	}
}.toPyString(FormTemplate.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun updateFormTemplateAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UpdateFormTemplateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.updateFormTemplate(
				decodedParams.formTemplate,
			)
		}.toPyStringAsyncCallback(FormTemplate.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SetTemplateAttachmentParams(
	public val formTemplateId: String,
	@Serializable(ByteArraySerializer::class)
	@OptIn(InternalIcureApi::class)
	public val payload: ByteArray,
)

@OptIn(InternalIcureApi::class)
public fun setTemplateAttachmentBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SetTemplateAttachmentParams>(params)
	runBlocking {
		sdk.form.setTemplateAttachment(
			decodedParams.formTemplateId,
			decodedParams.payload,
		)
	}
}.toPyString(String.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun setTemplateAttachmentAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SetTemplateAttachmentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.setTemplateAttachment(
				decodedParams.formTemplateId,
				decodedParams.payload,
			)
		}.toPyStringAsyncCallback(String.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithParams(
	public val delegateId: String,
	public val form: DecryptedForm,
	public val options: FormShareOptions? = null,
)

@OptIn(InternalIcureApi::class)
public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.form.shareWith(
			decodedParams.delegateId,
			decodedParams.form,
			decodedParams.options,
		)
	}
}.toPyString(DecryptedForm.serializer())

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
			sdk.form.shareWith(
				decodedParams.delegateId,
				decodedParams.form,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(DecryptedForm.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val form: DecryptedForm,
	public val delegates: Map<String, FormShareOptions>,
)

@OptIn(InternalIcureApi::class)
public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.form.shareWithMany(
			decodedParams.form,
			decodedParams.delegates,
		)
	}
}.toPyString(DecryptedForm.serializer())

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
			sdk.form.shareWithMany(
				decodedParams.form,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(DecryptedForm.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindFormsByHcPartyPatientParams(
	public val hcPartyId: String,
	public val patient: Patient,
	public val startDate: Long? = null,
	public val endDate: Long? = null,
	public val descending: Boolean? = null,
)

@OptIn(InternalIcureApi::class)
public fun findFormsByHcPartyPatientBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindFormsByHcPartyPatientParams>(params)
	runBlocking {
		sdk.form.findFormsByHcPartyPatient(
			decodedParams.hcPartyId,
			decodedParams.patient,
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.descending,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, DecryptedForm.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findFormsByHcPartyPatientAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindFormsByHcPartyPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.findFormsByHcPartyPatient(
				decodedParams.hcPartyId,
				decodedParams.patient,
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.descending,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, DecryptedForm.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterFormsByParams(
	public val filter: FilterOptions<Form>,
)

@OptIn(InternalIcureApi::class)
public fun filterFormsByBlocking(sdk: CardinalApis, params: String): PyResult = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterFormsByParams>(params)
	runBlocking {
		sdk.form.filterFormsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, DecryptedForm.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterFormsByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterFormsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.filterFormsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, DecryptedForm.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterFormsBySortedParams(
	public val filter: SortableFilterOptions<Form>,
)

@OptIn(InternalIcureApi::class)
public fun filterFormsBySortedBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterFormsBySortedParams>(params)
	runBlocking {
		sdk.form.filterFormsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, DecryptedForm.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterFormsBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterFormsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.filterFormsBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, DecryptedForm.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class CreateFormParams(
	public val entity: DecryptedForm,
)

@OptIn(InternalIcureApi::class)
public fun createFormBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateFormParams>(params)
	runBlocking {
		sdk.form.createForm(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedForm.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createFormAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateFormParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.createForm(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(DecryptedForm.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateFormsParams(
	public val entities: List<DecryptedForm>,
)

@OptIn(InternalIcureApi::class)
public fun createFormsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateFormsParams>(params)
	runBlocking {
		sdk.form.createForms(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(DecryptedForm.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createFormsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateFormsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.createForms(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedForm.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyFormParams(
	public val entity: DecryptedForm,
)

@OptIn(InternalIcureApi::class)
public fun modifyFormBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyFormParams>(params)
	runBlocking {
		sdk.form.modifyForm(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedForm.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyFormAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyFormParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.modifyForm(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(DecryptedForm.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteFormByIdParams(
	public val id: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun undeleteFormByIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteFormByIdParams>(params)
	runBlocking {
		sdk.form.undeleteFormById(
			decodedParams.id,
			decodedParams.rev,
		)
	}
}.toPyString(DecryptedForm.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteFormByIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteFormByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.undeleteFormById(
				decodedParams.id,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(DecryptedForm.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteFormParams(
	public val form: Form,
)

@OptIn(InternalIcureApi::class)
public fun undeleteFormBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteFormParams>(params)
	runBlocking {
		sdk.form.undeleteForm(
			decodedParams.form,
		)
	}
}.toPyString(DecryptedForm.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteFormAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteFormParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.undeleteForm(
				decodedParams.form,
			)
		}.toPyStringAsyncCallback(DecryptedForm.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyFormsParams(
	public val entities: List<DecryptedForm>,
)

@OptIn(InternalIcureApi::class)
public fun modifyFormsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyFormsParams>(params)
	runBlocking {
		sdk.form.modifyForms(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(DecryptedForm.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyFormsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyFormsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.modifyForms(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedForm.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetFormParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun getFormBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormParams>(params)
	runBlocking {
		sdk.form.getForm(
			decodedParams.entityId,
		)
	}
}.toPyString(DecryptedForm.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getFormAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.getForm(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DecryptedForm.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetFormsParams(
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getFormsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormsParams>(params)
	runBlocking {
		sdk.form.getForms(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DecryptedForm.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getFormsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.getForms(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedForm.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetLatestFormByLogicalUuidParams(
	public val logicalUuid: String,
)

@OptIn(InternalIcureApi::class)
public fun getLatestFormByLogicalUuidBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetLatestFormByLogicalUuidParams>(params)
	runBlocking {
		sdk.form.getLatestFormByLogicalUuid(
			decodedParams.logicalUuid,
		)
	}
}.toPyString(DecryptedForm.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getLatestFormByLogicalUuidAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetLatestFormByLogicalUuidParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.getLatestFormByLogicalUuid(
				decodedParams.logicalUuid,
			)
		}.toPyStringAsyncCallback(DecryptedForm.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetLatestFormByUniqueIdParams(
	public val uniqueId: String,
)

@OptIn(InternalIcureApi::class)
public fun getLatestFormByUniqueIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetLatestFormByUniqueIdParams>(params)
	runBlocking {
		sdk.form.getLatestFormByUniqueId(
			decodedParams.uniqueId,
		)
	}
}.toPyString(DecryptedForm.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getLatestFormByUniqueIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetLatestFormByUniqueIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.getLatestFormByUniqueId(
				decodedParams.uniqueId,
			)
		}.toPyStringAsyncCallback(DecryptedForm.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetFormsByLogicalUuidParams(
	public val logicalUuid: String,
)

@OptIn(InternalIcureApi::class)
public fun getFormsByLogicalUuidBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormsByLogicalUuidParams>(params)
	runBlocking {
		sdk.form.getFormsByLogicalUuid(
			decodedParams.logicalUuid,
		)
	}
}.toPyString(ListSerializer(DecryptedForm.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getFormsByLogicalUuidAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormsByLogicalUuidParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.getFormsByLogicalUuid(
				decodedParams.logicalUuid,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedForm.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetFormsByUniqueIdParams(
	public val uniqueId: String,
)

@OptIn(InternalIcureApi::class)
public fun getFormsByUniqueIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormsByUniqueIdParams>(params)
	runBlocking {
		sdk.form.getFormsByUniqueId(
			decodedParams.uniqueId,
		)
	}
}.toPyString(ListSerializer(DecryptedForm.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getFormsByUniqueIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormsByUniqueIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.getFormsByUniqueId(
				decodedParams.uniqueId,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedForm.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetChildrenFormsParams(
	public val hcPartyId: String,
	public val parentId: String,
)

@OptIn(InternalIcureApi::class)
public fun getChildrenFormsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetChildrenFormsParams>(params)
	runBlocking {
		sdk.form.getChildrenForms(
			decodedParams.hcPartyId,
			decodedParams.parentId,
		)
	}
}.toPyString(ListSerializer(DecryptedForm.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getChildrenFormsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetChildrenFormsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.getChildrenForms(
				decodedParams.hcPartyId,
				decodedParams.parentId,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedForm.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
