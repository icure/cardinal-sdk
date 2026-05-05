// auto-generated file
package com.icure.cardinal.sdk.py.api.InsuranceApi.inGroup

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Insurance
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Byte
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CValues
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer

@Serializable
private class CreateInsuranceParams(
	public val insurance: GroupScoped<Insurance>,
)

@OptIn(InternalIcureApi::class)
public fun createInsuranceBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateInsuranceParams>(params)
	runBlocking {
		sdk.insurance.inGroup.createInsurance(
			decodedParams.insurance,
		)
	}
}.toPyString(GroupScoped.serializer(Insurance.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createInsuranceAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateInsuranceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.insurance.inGroup.createInsurance(
				decodedParams.insurance,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(Insurance.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateInsurancesParams(
	public val insurances: List<GroupScoped<Insurance>>,
)

@OptIn(InternalIcureApi::class)
public fun createInsurancesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateInsurancesParams>(params)
	runBlocking {
		sdk.insurance.inGroup.createInsurances(
			decodedParams.insurances,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(Insurance.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createInsurancesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateInsurancesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.insurance.inGroup.createInsurances(
				decodedParams.insurances,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(Insurance.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetInsuranceParams(
	public val groupId: String,
	public val insuranceId: String,
)

@OptIn(InternalIcureApi::class)
public fun getInsuranceBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetInsuranceParams>(params)
	runBlocking {
		sdk.insurance.inGroup.getInsurance(
			decodedParams.groupId,
			decodedParams.insuranceId,
		)
	}
}.toPyString(GroupScoped.serializer(Insurance.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getInsuranceAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetInsuranceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.insurance.inGroup.getInsurance(
				decodedParams.groupId,
				decodedParams.insuranceId,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(Insurance.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetInsurancesParams(
	public val groupId: String,
	public val insurancesIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getInsurancesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetInsurancesParams>(params)
	runBlocking {
		sdk.insurance.inGroup.getInsurances(
			decodedParams.groupId,
			decodedParams.insurancesIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(Insurance.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getInsurancesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetInsurancesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.insurance.inGroup.getInsurances(
				decodedParams.groupId,
				decodedParams.insurancesIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(Insurance.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyInsuranceParams(
	public val insurance: GroupScoped<Insurance>,
)

@OptIn(InternalIcureApi::class)
public fun modifyInsuranceBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyInsuranceParams>(params)
	runBlocking {
		sdk.insurance.inGroup.modifyInsurance(
			decodedParams.insurance,
		)
	}
}.toPyString(GroupScoped.serializer(Insurance.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyInsuranceAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyInsuranceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.insurance.inGroup.modifyInsurance(
				decodedParams.insurance,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(Insurance.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyInsurancesParams(
	public val insurances: List<GroupScoped<Insurance>>,
)

@OptIn(InternalIcureApi::class)
public fun modifyInsurancesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyInsurancesParams>(params)
	runBlocking {
		sdk.insurance.inGroup.modifyInsurances(
			decodedParams.insurances,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(Insurance.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyInsurancesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyInsurancesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.insurance.inGroup.modifyInsurances(
				decodedParams.insurances,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(Insurance.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteInsuranceByIdParams(
	public val entityId: GroupScoped<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun deleteInsuranceByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteInsuranceByIdParams>(params)
	runBlocking {
		sdk.insurance.inGroup.deleteInsuranceById(
			decodedParams.entityId,
		)
	}
}.toPyString(GroupScoped.serializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteInsuranceByIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteInsuranceByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.insurance.inGroup.deleteInsuranceById(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(StoredDocumentIdentifier.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteInsuranceByIdsParams(
	public val entityIds: List<GroupScoped<StoredDocumentIdentifier>>,
)

@OptIn(InternalIcureApi::class)
public fun deleteInsuranceByIdsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteInsuranceByIdsParams>(params)
	runBlocking {
		sdk.insurance.inGroup.deleteInsuranceByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteInsuranceByIdsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteInsuranceByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.insurance.inGroup.deleteInsuranceByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteInsuranceParams(
	public val insurance: GroupScoped<Insurance>,
)

@OptIn(InternalIcureApi::class)
public fun deleteInsuranceBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteInsuranceParams>(params)
	runBlocking {
		sdk.insurance.inGroup.deleteInsurance(
			decodedParams.insurance,
		)
	}
}.toPyString(GroupScoped.serializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteInsuranceAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteInsuranceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.insurance.inGroup.deleteInsurance(
				decodedParams.insurance,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(StoredDocumentIdentifier.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteInsurancesParams(
	public val insurances: List<GroupScoped<Insurance>>,
)

@OptIn(InternalIcureApi::class)
public fun deleteInsurancesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteInsurancesParams>(params)
	runBlocking {
		sdk.insurance.inGroup.deleteInsurances(
			decodedParams.insurances,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteInsurancesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteInsurancesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.insurance.inGroup.deleteInsurances(
				decodedParams.insurances,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteInsuranceByIdParams(
	public val entityId: GroupScoped<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteInsuranceByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteInsuranceByIdParams>(params)
	runBlocking {
		sdk.insurance.inGroup.undeleteInsuranceById(
			decodedParams.entityId,
		)
	}
}.toPyString(GroupScoped.serializer(Insurance.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteInsuranceByIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteInsuranceByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.insurance.inGroup.undeleteInsuranceById(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(Insurance.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteInsuranceByIdsParams(
	public val entityIds: List<GroupScoped<StoredDocumentIdentifier>>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteInsuranceByIdsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteInsuranceByIdsParams>(params)
	runBlocking {
		sdk.insurance.inGroup.undeleteInsuranceByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(Insurance.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteInsuranceByIdsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteInsuranceByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.insurance.inGroup.undeleteInsuranceByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(Insurance.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteInsuranceParams(
	public val insurance: GroupScoped<Insurance>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteInsuranceBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteInsuranceParams>(params)
	runBlocking {
		sdk.insurance.inGroup.undeleteInsurance(
			decodedParams.insurance,
		)
	}
}.toPyString(GroupScoped.serializer(Insurance.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteInsuranceAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteInsuranceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.insurance.inGroup.undeleteInsurance(
				decodedParams.insurance,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(Insurance.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteInsurancesParams(
	public val insurances: List<GroupScoped<Insurance>>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteInsurancesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteInsurancesParams>(params)
	runBlocking {
		sdk.insurance.inGroup.undeleteInsurances(
			decodedParams.insurances,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(Insurance.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteInsurancesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteInsurancesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.insurance.inGroup.undeleteInsurances(
				decodedParams.insurances,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(Insurance.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeInsuranceByIdParams(
	public val entityId: GroupScoped<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun purgeInsuranceByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeInsuranceByIdParams>(params)
	runBlocking {
		sdk.insurance.inGroup.purgeInsuranceById(
			decodedParams.entityId,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeInsuranceByIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeInsuranceByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.insurance.inGroup.purgeInsuranceById(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeInsuranceByIdsParams(
	public val entityIds: List<GroupScoped<StoredDocumentIdentifier>>,
)

@OptIn(InternalIcureApi::class)
public fun purgeInsuranceByIdsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeInsuranceByIdsParams>(params)
	runBlocking {
		sdk.insurance.inGroup.purgeInsuranceByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeInsuranceByIdsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeInsuranceByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.insurance.inGroup.purgeInsuranceByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeInsuranceParams(
	public val insurance: GroupScoped<Insurance>,
)

@OptIn(InternalIcureApi::class)
public fun purgeInsuranceBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeInsuranceParams>(params)
	runBlocking {
		sdk.insurance.inGroup.purgeInsurance(
			decodedParams.insurance,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeInsuranceAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeInsuranceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.insurance.inGroup.purgeInsurance(
				decodedParams.insurance,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeInsurancesParams(
	public val insurances: List<GroupScoped<Insurance>>,
)

@OptIn(InternalIcureApi::class)
public fun purgeInsurancesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeInsurancesParams>(params)
	runBlocking {
		sdk.insurance.inGroup.purgeInsurances(
			decodedParams.insurances,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeInsurancesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeInsurancesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.insurance.inGroup.purgeInsurances(
				decodedParams.insurances,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
