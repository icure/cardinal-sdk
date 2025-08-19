// auto-generated file
package com.icure.cardinal.sdk.py.api.PatientApi.inGroup

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.EntityAccessInformation
import com.icure.cardinal.sdk.crypto.entities.PatientShareOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.EncryptedPatient
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
import kotlin.Int
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
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.builtins.serializer

@Serializable
private class DecryptParams(
	public val patients: List<GroupScoped<EncryptedPatient>>,
)

@OptIn(InternalIcureApi::class)
public fun decryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptParams>(params)
	runBlocking {
		sdk.patient.inGroup.decrypt(
			decodedParams.patients,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(DecryptedPatient.serializer())))

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
			sdk.patient.inGroup.decrypt(
				decodedParams.patients,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(DecryptedPatient.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryDecryptParams(
	public val patients: List<GroupScoped<EncryptedPatient>>,
)

@OptIn(InternalIcureApi::class)
public fun tryDecryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<TryDecryptParams>(params)
	runBlocking {
		sdk.patient.inGroup.tryDecrypt(
			decodedParams.patients,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(PolymorphicSerializer(Patient::class))))

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
			sdk.patient.inGroup.tryDecrypt(
				decodedParams.patients,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(PolymorphicSerializer(Patient::class))),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class EncryptOrValidateParams(
	public val patients: List<GroupScoped<Patient>>,
)

@OptIn(InternalIcureApi::class)
public fun encryptOrValidateBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<EncryptOrValidateParams>(params)
	runBlocking {
		sdk.patient.inGroup.encryptOrValidate(
			decodedParams.patients,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(EncryptedPatient.serializer())))

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
			sdk.patient.inGroup.encryptOrValidate(
				decodedParams.patients,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(EncryptedPatient.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetSecretIdsOfParams(
	public val patient: GroupScoped<Patient>,
)

@OptIn(InternalIcureApi::class)
public fun getSecretIdsOfBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetSecretIdsOfParams>(params)
	runBlocking {
		sdk.patient.inGroup.getSecretIdsOf(
			decodedParams.patient,
		)
	}
}.toPyString(MapSerializer(String.serializer(), SetSerializer(EntityReferenceInGroup.serializer())))

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
			sdk.patient.inGroup.getSecretIdsOf(
				decodedParams.patient,
			)
		}.toPyStringAsyncCallback(MapSerializer(String.serializer(),
				SetSerializer(EntityReferenceInGroup.serializer())), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetEncryptionKeysOfParams(
	public val patient: GroupScoped<Patient>,
)

@OptIn(InternalIcureApi::class)
public fun getEncryptionKeysOfBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetEncryptionKeysOfParams>(params)
	runBlocking {
		sdk.patient.inGroup.getEncryptionKeysOf(
			decodedParams.patient,
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
			sdk.patient.inGroup.getEncryptionKeysOf(
				decodedParams.patient,
			)
		}.toPyStringAsyncCallback(SetSerializer(HexString.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class WithEncryptionMetadataParams(
	public val entityGroupId: String,
	public val base: DecryptedPatient?,
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
		sdk.patient.inGroup.withEncryptionMetadata(
			decodedParams.entityGroupId,
			decodedParams.base,
			decodedParams.user,
			decodedParams.delegates,
			decodedParams.alternateRootDelegateReference,
		)
	}
}.toPyString(GroupScoped.serializer(DecryptedPatient.serializer()))

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
			sdk.patient.inGroup.withEncryptionMetadata(
				decodedParams.entityGroupId,
				decodedParams.base,
				decodedParams.user,
				decodedParams.delegates,
				decodedParams.alternateRootDelegateReference,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(DecryptedPatient.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class HasWriteAccessParams(
	public val patient: GroupScoped<DecryptedPatient>,
)

@OptIn(InternalIcureApi::class)
public fun hasWriteAccessBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<HasWriteAccessParams>(params)
	runBlocking {
		sdk.patient.inGroup.hasWriteAccess(
			decodedParams.patient,
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
			sdk.patient.inGroup.hasWriteAccess(
				decodedParams.patient,
			)
		}.toPyStringAsyncCallback(Boolean.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateDelegationDeAnonymizationMetadataParams(
	public val entity: GroupScoped<DecryptedPatient>,
	public val delegates: Set<EntityReferenceInGroup>,
)

@OptIn(InternalIcureApi::class)
public fun createDelegationDeAnonymizationMetadataBlocking(sdk: CardinalApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<CreateDelegationDeAnonymizationMetadataParams>(params)
	runBlocking {
		sdk.patient.inGroup.createDelegationDeAnonymizationMetadata(
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
			sdk.patient.inGroup.createDelegationDeAnonymizationMetadata(
				decodedParams.entity,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchPatientsByParams(
	public val groupId: String,
	public val filter: FilterOptions<Patient>,
)

@OptIn(InternalIcureApi::class)
public fun matchPatientsByBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchPatientsByParams>(params)
	runBlocking {
		sdk.patient.inGroup.matchPatientsBy(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchPatientsByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchPatientsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.inGroup.matchPatientsBy(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchPatientsBySortedParams(
	public val groupId: String,
	public val filter: SortableFilterOptions<Patient>,
)

@OptIn(InternalIcureApi::class)
public fun matchPatientsBySortedBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchPatientsBySortedParams>(params)
	runBlocking {
		sdk.patient.inGroup.matchPatientsBySorted(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchPatientsBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchPatientsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.inGroup.matchPatientsBySorted(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetDataOwnersWithAccessToParams(
	public val patient: GroupScoped<Patient>,
)

@OptIn(InternalIcureApi::class)
public fun getDataOwnersWithAccessToBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetDataOwnersWithAccessToParams>(params)
	runBlocking {
		sdk.patient.inGroup.getDataOwnersWithAccessTo(
			decodedParams.patient,
		)
	}
}.toPyString(EntityAccessInformation.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getDataOwnersWithAccessToAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetDataOwnersWithAccessToParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.inGroup.getDataOwnersWithAccessTo(
				decodedParams.patient,
			)
		}.toPyStringAsyncCallback(EntityAccessInformation.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithParams(
	public val `delegate`: EntityReferenceInGroup,
	public val patient: GroupScoped<DecryptedPatient>,
	public val options: PatientShareOptions? = null,
)

@OptIn(InternalIcureApi::class)
public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.patient.inGroup.shareWith(
			decodedParams.delegate,
			decodedParams.patient,
			decodedParams.options,
		)
	}
}.toPyString(GroupScoped.serializer(DecryptedPatient.serializer()))

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
			sdk.patient.inGroup.shareWith(
				decodedParams.delegate,
				decodedParams.patient,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(DecryptedPatient.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val patient: GroupScoped<DecryptedPatient>,
	@Serializable(MapAsArraySerializer::class)
	@OptIn(InternalIcureApi::class)
	public val delegates: Map<EntityReferenceInGroup, PatientShareOptions>,
)

@OptIn(InternalIcureApi::class)
public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.patient.inGroup.shareWithMany(
			decodedParams.patient,
			decodedParams.delegates,
		)
	}
}.toPyString(GroupScoped.serializer(DecryptedPatient.serializer()))

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
			sdk.patient.inGroup.shareWithMany(
				decodedParams.patient,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(DecryptedPatient.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class InitializeConfidentialSecretIdParams(
	public val patient: GroupScoped<DecryptedPatient>,
)

@OptIn(InternalIcureApi::class)
public fun initializeConfidentialSecretIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<InitializeConfidentialSecretIdParams>(params)
	runBlocking {
		sdk.patient.inGroup.initializeConfidentialSecretId(
			decodedParams.patient,
		)
	}
}.toPyString(GroupScoped.serializer(DecryptedPatient.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun initializeConfidentialSecretIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<InitializeConfidentialSecretIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.inGroup.initializeConfidentialSecretId(
				decodedParams.patient,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(DecryptedPatient.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterPatientsByParams(
	public val groupId: String,
	public val filter: FilterOptions<Patient>,
)

@OptIn(InternalIcureApi::class)
public fun filterPatientsByBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterPatientsByParams>(params)
	runBlocking {
		sdk.patient.inGroup.filterPatientsBy(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, GroupScoped.serializer(DecryptedPatient.serializer()))}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterPatientsByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterPatientsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.inGroup.filterPatientsBy(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, GroupScoped.serializer(DecryptedPatient.serializer()))}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterPatientsBySortedParams(
	public val groupId: String,
	public val filter: SortableFilterOptions<Patient>,
)

@OptIn(InternalIcureApi::class)
public fun filterPatientsBySortedBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterPatientsBySortedParams>(params)
	runBlocking {
		sdk.patient.inGroup.filterPatientsBySorted(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, GroupScoped.serializer(DecryptedPatient.serializer()))}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterPatientsBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterPatientsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.inGroup.filterPatientsBySorted(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, GroupScoped.serializer(DecryptedPatient.serializer()))}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class CreatePatientParams(
	public val patient: GroupScoped<DecryptedPatient>,
)

@OptIn(InternalIcureApi::class)
public fun createPatientBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreatePatientParams>(params)
	runBlocking {
		sdk.patient.inGroup.createPatient(
			decodedParams.patient,
		)
	}
}.toPyString(GroupScoped.serializer(DecryptedPatient.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createPatientAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreatePatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.inGroup.createPatient(
				decodedParams.patient,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(DecryptedPatient.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreatePatientsMinimalParams(
	public val patients: List<GroupScoped<DecryptedPatient>>,
)

@OptIn(InternalIcureApi::class)
public fun createPatientsMinimalBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreatePatientsMinimalParams>(params)
	runBlocking {
		sdk.patient.inGroup.createPatientsMinimal(
			decodedParams.patients,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createPatientsMinimalAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreatePatientsMinimalParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.inGroup.createPatientsMinimal(
				decodedParams.patients,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreatePatientsParams(
	public val patients: List<GroupScoped<DecryptedPatient>>,
)

@OptIn(InternalIcureApi::class)
public fun createPatientsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreatePatientsParams>(params)
	runBlocking {
		sdk.patient.inGroup.createPatients(
			decodedParams.patients,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(DecryptedPatient.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createPatientsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreatePatientsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.inGroup.createPatients(
				decodedParams.patients,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(DecryptedPatient.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetPatientParams(
	public val groupId: String,
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun getPatientBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetPatientParams>(params)
	runBlocking {
		sdk.patient.inGroup.getPatient(
			decodedParams.groupId,
			decodedParams.entityId,
		)
	}
}.toPyString(GroupScoped.serializer(DecryptedPatient.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getPatientAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.inGroup.getPatient(
				decodedParams.groupId,
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(DecryptedPatient.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetPatientResolvingMergesParams(
	public val groupId: String,
	public val patientId: String,
	public val maxMergeDepth: Int?,
)

@OptIn(InternalIcureApi::class)
public fun getPatientResolvingMergesBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetPatientResolvingMergesParams>(params)
	runBlocking {
		sdk.patient.inGroup.getPatientResolvingMerges(
			decodedParams.groupId,
			decodedParams.patientId,
			decodedParams.maxMergeDepth,
		)
	}
}.toPyString(GroupScoped.serializer(DecryptedPatient.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getPatientResolvingMergesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetPatientResolvingMergesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.inGroup.getPatientResolvingMerges(
				decodedParams.groupId,
				decodedParams.patientId,
				decodedParams.maxMergeDepth,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(DecryptedPatient.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetPatientsParams(
	public val groupId: String,
	public val patientIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getPatientsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetPatientsParams>(params)
	runBlocking {
		sdk.patient.inGroup.getPatients(
			decodedParams.groupId,
			decodedParams.patientIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(DecryptedPatient.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getPatientsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetPatientsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.inGroup.getPatients(
				decodedParams.groupId,
				decodedParams.patientIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(DecryptedPatient.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyPatientsMinimalParams(
	public val patients: List<GroupScoped<DecryptedPatient>>,
)

@OptIn(InternalIcureApi::class)
public fun modifyPatientsMinimalBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyPatientsMinimalParams>(params)
	runBlocking {
		sdk.patient.inGroup.modifyPatientsMinimal(
			decodedParams.patients,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyPatientsMinimalAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyPatientsMinimalParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.inGroup.modifyPatientsMinimal(
				decodedParams.patients,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyPatientsParams(
	public val patients: List<GroupScoped<DecryptedPatient>>,
)

@OptIn(InternalIcureApi::class)
public fun modifyPatientsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyPatientsParams>(params)
	runBlocking {
		sdk.patient.inGroup.modifyPatients(
			decodedParams.patients,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(DecryptedPatient.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyPatientsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyPatientsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.inGroup.modifyPatients(
				decodedParams.patients,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(DecryptedPatient.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
