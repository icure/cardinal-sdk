// auto-generated file
package com.icure.cardinal.sdk.py.api.InsuranceApi

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.model.Insurance
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Byte
import kotlin.Int
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
	public val insuranceIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getInsurancesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetInsurancesParams>(params)
	runBlocking {
		sdk.insurance.getInsurances(
			decodedParams.insuranceIds,
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
				decodedParams.insuranceIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(Insurance.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

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
private class DeleteInsuranceParams(
	public val insuranceId: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteInsuranceBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteInsuranceParams>(params)
	runBlocking {
		sdk.insurance.deleteInsurance(
			decodedParams.insuranceId,
		)
	}
}.toPyString(DocIdentifier.serializer())

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
				decodedParams.insuranceId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetAllInsurancesParams(
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

@OptIn(InternalIcureApi::class)
public fun getAllInsurancesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetAllInsurancesParams>(params)
	runBlocking {
		sdk.insurance.getAllInsurances(
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(Insurance.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getAllInsurancesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetAllInsurancesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.insurance.getAllInsurances(
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(Insurance.serializer()), resultCallback)
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
private class CreateInsurancesInGroupParams(
	public val groupId: String,
	public val insuranceBatch: List<Insurance>,
)

@OptIn(InternalIcureApi::class)
public fun createInsurancesInGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateInsurancesInGroupParams>(params)
	runBlocking {
		sdk.insurance.createInsurancesInGroup(
			decodedParams.groupId,
			decodedParams.insuranceBatch,
		)
	}
}.toPyString(ListSerializer(Insurance.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createInsurancesInGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateInsurancesInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.insurance.createInsurancesInGroup(
				decodedParams.groupId,
				decodedParams.insuranceBatch,
			)
		}.toPyStringAsyncCallback(ListSerializer(Insurance.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetInsurancesInGroupParams(
	public val groupId: String,
	public val insuranceIds: String,
)

@OptIn(InternalIcureApi::class)
public fun getInsurancesInGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetInsurancesInGroupParams>(params)
	runBlocking {
		sdk.insurance.getInsurancesInGroup(
			decodedParams.groupId,
			decodedParams.insuranceIds,
		)
	}
}.toPyString(ListSerializer(Insurance.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getInsurancesInGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetInsurancesInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.insurance.getInsurancesInGroup(
				decodedParams.groupId,
				decodedParams.insuranceIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(Insurance.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyInsurancesInGroupParams(
	public val groupId: String,
	public val insuranceBatch: List<Insurance>,
)

@OptIn(InternalIcureApi::class)
public fun modifyInsurancesInGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyInsurancesInGroupParams>(params)
	runBlocking {
		sdk.insurance.modifyInsurancesInGroup(
			decodedParams.groupId,
			decodedParams.insuranceBatch,
		)
	}
}.toPyString(ListSerializer(Insurance.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyInsurancesInGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyInsurancesInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.insurance.modifyInsurancesInGroup(
				decodedParams.groupId,
				decodedParams.insuranceBatch,
			)
		}.toPyStringAsyncCallback(ListSerializer(Insurance.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
