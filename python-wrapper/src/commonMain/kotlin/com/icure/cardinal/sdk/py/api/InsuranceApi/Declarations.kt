// auto-generated file
package com.icure.cardinal.sdk.py.api.InsuranceApi

import com.icure.cardinal.sdk.CardinalNonCryptoApis
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
	public val insurance: Insurance,
)

@OptIn(InternalIcureApi::class)
public fun createInsuranceBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateInsuranceParams>(params)
	runBlocking {
		sdk.insurance.createInsurance(
			decodedParams.insurance,
		)
	}
}.toPyString(Insurance.serializer())

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
			sdk.insurance.createInsurance(
				decodedParams.insurance,
			)
		}.toPyStringAsyncCallback(Insurance.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateInsurancesParams(
	public val insurances: List<Insurance>,
)

@OptIn(InternalIcureApi::class)
public fun createInsurancesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateInsurancesParams>(params)
	runBlocking {
		sdk.insurance.createInsurances(
			decodedParams.insurances,
		)
	}
}.toPyString(ListSerializer(Insurance.serializer()))

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
			sdk.insurance.createInsurances(
				decodedParams.insurances,
			)
		}.toPyStringAsyncCallback(ListSerializer(Insurance.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetInsuranceParams(
	public val insuranceId: String,
)

@OptIn(InternalIcureApi::class)
public fun getInsuranceBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetInsuranceParams>(params)
	runBlocking {
		sdk.insurance.getInsurance(
			decodedParams.insuranceId,
		)
	}
}.toPyString(Insurance.serializer())

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
			sdk.insurance.getInsurance(
				decodedParams.insuranceId,
			)
		}.toPyStringAsyncCallback(Insurance.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetInsurancesParams(
	public val insurancesIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getInsurancesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetInsurancesParams>(params)
	runBlocking {
		sdk.insurance.getInsurances(
			decodedParams.insurancesIds,
		)
	}
}.toPyString(ListSerializer(Insurance.serializer()))

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
			sdk.insurance.getInsurances(
				decodedParams.insurancesIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(Insurance.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyInsuranceParams(
	public val insurance: Insurance,
)

@OptIn(InternalIcureApi::class)
public fun modifyInsuranceBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyInsuranceParams>(params)
	runBlocking {
		sdk.insurance.modifyInsurance(
			decodedParams.insurance,
		)
	}
}.toPyString(Insurance.serializer())

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
			sdk.insurance.modifyInsurance(
				decodedParams.insurance,
			)
		}.toPyStringAsyncCallback(Insurance.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyInsurancesParams(
	public val insurances: List<Insurance>,
)

@OptIn(InternalIcureApi::class)
public fun modifyInsurancesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyInsurancesParams>(params)
	runBlocking {
		sdk.insurance.modifyInsurances(
			decodedParams.insurances,
		)
	}
}.toPyString(ListSerializer(Insurance.serializer()))

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
			sdk.insurance.modifyInsurances(
				decodedParams.insurances,
			)
		}.toPyStringAsyncCallback(ListSerializer(Insurance.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteInsuranceByIdParams(
	public val entityId: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteInsuranceByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteInsuranceByIdParams>(params)
	runBlocking {
		sdk.insurance.deleteInsuranceById(
			decodedParams.entityId,
			decodedParams.rev,
		)
	}
}.toPyString(StoredDocumentIdentifier.serializer())

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
			sdk.insurance.deleteInsuranceById(
				decodedParams.entityId,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(StoredDocumentIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteInsuranceByIdsParams(
	public val entityIds: List<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun deleteInsuranceByIdsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteInsuranceByIdsParams>(params)
	runBlocking {
		sdk.insurance.deleteInsuranceByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(StoredDocumentIdentifier.serializer()))

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
			sdk.insurance.deleteInsuranceByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(StoredDocumentIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteInsuranceParams(
	public val insurance: Insurance,
)

@OptIn(InternalIcureApi::class)
public fun deleteInsuranceBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteInsuranceParams>(params)
	runBlocking {
		sdk.insurance.deleteInsurance(
			decodedParams.insurance,
		)
	}
}.toPyString(StoredDocumentIdentifier.serializer())

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
			sdk.insurance.deleteInsurance(
				decodedParams.insurance,
			)
		}.toPyStringAsyncCallback(StoredDocumentIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteInsurancesParams(
	public val insurances: List<Insurance>,
)

@OptIn(InternalIcureApi::class)
public fun deleteInsurancesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteInsurancesParams>(params)
	runBlocking {
		sdk.insurance.deleteInsurances(
			decodedParams.insurances,
		)
	}
}.toPyString(ListSerializer(StoredDocumentIdentifier.serializer()))

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
			sdk.insurance.deleteInsurances(
				decodedParams.insurances,
			)
		}.toPyStringAsyncCallback(ListSerializer(StoredDocumentIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteInsuranceByIdParams(
	public val entityId: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun undeleteInsuranceByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteInsuranceByIdParams>(params)
	runBlocking {
		sdk.insurance.undeleteInsuranceById(
			decodedParams.entityId,
			decodedParams.rev,
		)
	}
}.toPyString(Insurance.serializer())

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
			sdk.insurance.undeleteInsuranceById(
				decodedParams.entityId,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(Insurance.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteInsuranceByIdsParams(
	public val entityIds: List<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteInsuranceByIdsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteInsuranceByIdsParams>(params)
	runBlocking {
		sdk.insurance.undeleteInsuranceByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(Insurance.serializer()))

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
			sdk.insurance.undeleteInsuranceByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(Insurance.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteInsuranceParams(
	public val insurance: Insurance,
)

@OptIn(InternalIcureApi::class)
public fun undeleteInsuranceBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteInsuranceParams>(params)
	runBlocking {
		sdk.insurance.undeleteInsurance(
			decodedParams.insurance,
		)
	}
}.toPyString(Insurance.serializer())

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
			sdk.insurance.undeleteInsurance(
				decodedParams.insurance,
			)
		}.toPyStringAsyncCallback(Insurance.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteInsurancesParams(
	public val insurances: List<Insurance>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteInsurancesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteInsurancesParams>(params)
	runBlocking {
		sdk.insurance.undeleteInsurances(
			decodedParams.insurances,
		)
	}
}.toPyString(ListSerializer(Insurance.serializer()))

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
			sdk.insurance.undeleteInsurances(
				decodedParams.insurances,
			)
		}.toPyStringAsyncCallback(ListSerializer(Insurance.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeInsuranceByIdParams(
	public val entityId: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun purgeInsuranceByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeInsuranceByIdParams>(params)
	runBlocking {
		sdk.insurance.purgeInsuranceById(
			decodedParams.entityId,
			decodedParams.rev,
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
			sdk.insurance.purgeInsuranceById(
				decodedParams.entityId,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeInsuranceByIdsParams(
	public val entityIds: List<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun purgeInsuranceByIdsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeInsuranceByIdsParams>(params)
	runBlocking {
		sdk.insurance.purgeInsuranceByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(StoredDocumentIdentifier.serializer()))

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
			sdk.insurance.purgeInsuranceByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(StoredDocumentIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeInsuranceParams(
	public val insurance: Insurance,
)

@OptIn(InternalIcureApi::class)
public fun purgeInsuranceBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeInsuranceParams>(params)
	runBlocking {
		sdk.insurance.purgeInsurance(
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
			sdk.insurance.purgeInsurance(
				decodedParams.insurance,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeInsurancesParams(
	public val insurances: List<Insurance>,
)

@OptIn(InternalIcureApi::class)
public fun purgeInsurancesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeInsurancesParams>(params)
	runBlocking {
		sdk.insurance.purgeInsurances(
			decodedParams.insurances,
		)
	}
}.toPyString(ListSerializer(StoredDocumentIdentifier.serializer()))

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
			sdk.insurance.purgeInsurances(
				decodedParams.insurances,
			)
		}.toPyStringAsyncCallback(ListSerializer(StoredDocumentIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListInsurancesByCodeParams(
	public val insuranceCode: String,
)

@OptIn(InternalIcureApi::class)
public fun listInsurancesByCodeBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListInsurancesByCodeParams>(params)
	runBlocking {
		sdk.insurance.listInsurancesByCode(
			decodedParams.insuranceCode,
		)
	}
}.toPyString(ListSerializer(Insurance.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listInsurancesByCodeAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListInsurancesByCodeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.insurance.listInsurancesByCode(
				decodedParams.insuranceCode,
			)
		}.toPyStringAsyncCallback(ListSerializer(Insurance.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListInsurancesByNameParams(
	public val insuranceName: String,
)

@OptIn(InternalIcureApi::class)
public fun listInsurancesByNameBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListInsurancesByNameParams>(params)
	runBlocking {
		sdk.insurance.listInsurancesByName(
			decodedParams.insuranceName,
		)
	}
}.toPyString(ListSerializer(Insurance.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listInsurancesByNameAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListInsurancesByNameParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.insurance.listInsurancesByName(
				decodedParams.insuranceName,
			)
		}.toPyStringAsyncCallback(ListSerializer(Insurance.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
