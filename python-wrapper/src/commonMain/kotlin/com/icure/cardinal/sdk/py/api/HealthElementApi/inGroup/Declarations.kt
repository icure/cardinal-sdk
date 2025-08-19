// auto-generated file
package com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.HealthElementShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.model.DecryptedHealthElement
import com.icure.cardinal.sdk.model.EncryptedHealthElement
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.serialization.MapAsArraySerializer
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
	public val base: DecryptedHealthElement?,
	public val patient: GroupScoped<Patient>,
	public val user: User? = null,
	@Serializable(MapAsArraySerializer::class)
	@OptIn(InternalIcureApi::class)
	public val delegates: Map<EntityReferenceInGroup, AccessLevel> = emptyMap(),
	public val secretId: SecretIdUseOption =
			com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent,
	public val alternateRootDelegateReference: EntityReferenceInGroup? = null,
)

@OptIn(InternalIcureApi::class)
public fun withEncryptionMetadataBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<WithEncryptionMetadataParams>(params)
	runBlocking {
		sdk.healthElement.inGroup.withEncryptionMetadata(
			decodedParams.entityGroupId,
			decodedParams.base,
			decodedParams.patient,
			decodedParams.user,
			decodedParams.delegates,
			decodedParams.secretId,
			decodedParams.alternateRootDelegateReference,
		)
	}
}.toPyString(GroupScoped.serializer(DecryptedHealthElement.serializer()))

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
			sdk.healthElement.inGroup.withEncryptionMetadata(
				decodedParams.entityGroupId,
				decodedParams.base,
				decodedParams.patient,
				decodedParams.user,
				decodedParams.delegates,
				decodedParams.secretId,
				decodedParams.alternateRootDelegateReference,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(DecryptedHealthElement.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetEncryptionKeysOfParams(
	public val healthElement: GroupScoped<HealthElement>,
)

@OptIn(InternalIcureApi::class)
public fun getEncryptionKeysOfBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetEncryptionKeysOfParams>(params)
	runBlocking {
		sdk.healthElement.inGroup.getEncryptionKeysOf(
			decodedParams.healthElement,
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
			sdk.healthElement.inGroup.getEncryptionKeysOf(
				decodedParams.healthElement,
			)
		}.toPyStringAsyncCallback(SetSerializer(HexString.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class HasWriteAccessParams(
	public val healthElement: GroupScoped<HealthElement>,
)

@OptIn(InternalIcureApi::class)
public fun hasWriteAccessBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<HasWriteAccessParams>(params)
	runBlocking {
		sdk.healthElement.inGroup.hasWriteAccess(
			decodedParams.healthElement,
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
			sdk.healthElement.inGroup.hasWriteAccess(
				decodedParams.healthElement,
			)
		}.toPyStringAsyncCallback(Boolean.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptPatientIdOfParams(
	public val healthElement: GroupScoped<HealthElement>,
)

@OptIn(InternalIcureApi::class)
public fun decryptPatientIdOfBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptPatientIdOfParams>(params)
	runBlocking {
		sdk.healthElement.inGroup.decryptPatientIdOf(
			decodedParams.healthElement,
		)
	}
}.toPyString(SetSerializer(EntityReferenceInGroup.serializer()))

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
			sdk.healthElement.inGroup.decryptPatientIdOf(
				decodedParams.healthElement,
			)
		}.toPyStringAsyncCallback(SetSerializer(EntityReferenceInGroup.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateDelegationDeAnonymizationMetadataParams(
	public val entity: GroupScoped<HealthElement>,
	public val delegates: Set<EntityReferenceInGroup>,
)

@OptIn(InternalIcureApi::class)
public fun createDelegationDeAnonymizationMetadataBlocking(sdk: CardinalApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<CreateDelegationDeAnonymizationMetadataParams>(params)
	runBlocking {
		sdk.healthElement.inGroup.createDelegationDeAnonymizationMetadata(
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
			sdk.healthElement.inGroup.createDelegationDeAnonymizationMetadata(
				decodedParams.entity,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptParams(
	public val healthElements: List<GroupScoped<EncryptedHealthElement>>,
)

@OptIn(InternalIcureApi::class)
public fun decryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptParams>(params)
	runBlocking {
		sdk.healthElement.inGroup.decrypt(
			decodedParams.healthElements,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(DecryptedHealthElement.serializer())))

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
			sdk.healthElement.inGroup.decrypt(
				decodedParams.healthElements,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(DecryptedHealthElement.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryDecryptParams(
	public val healthElements: List<GroupScoped<EncryptedHealthElement>>,
)

@OptIn(InternalIcureApi::class)
public fun tryDecryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<TryDecryptParams>(params)
	runBlocking {
		sdk.healthElement.inGroup.tryDecrypt(
			decodedParams.healthElements,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(PolymorphicSerializer(HealthElement::class))))

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
			sdk.healthElement.inGroup.tryDecrypt(
				decodedParams.healthElements,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(PolymorphicSerializer(HealthElement::class))),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class EncryptOrValidateParams(
	public val healthElements: List<GroupScoped<HealthElement>>,
)

@OptIn(InternalIcureApi::class)
public fun encryptOrValidateBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<EncryptOrValidateParams>(params)
	runBlocking {
		sdk.healthElement.inGroup.encryptOrValidate(
			decodedParams.healthElements,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(EncryptedHealthElement.serializer())))

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
			sdk.healthElement.inGroup.encryptOrValidate(
				decodedParams.healthElements,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(EncryptedHealthElement.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithParams(
	public val `delegate`: EntityReferenceInGroup,
	public val healthElement: GroupScoped<DecryptedHealthElement>,
	public val options: HealthElementShareOptions? = null,
)

@OptIn(InternalIcureApi::class)
public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.healthElement.inGroup.shareWith(
			decodedParams.delegate,
			decodedParams.healthElement,
			decodedParams.options,
		)
	}
}.toPyString(GroupScoped.serializer(DecryptedHealthElement.serializer()))

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
			sdk.healthElement.inGroup.shareWith(
				decodedParams.delegate,
				decodedParams.healthElement,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(DecryptedHealthElement.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val healthElement: GroupScoped<DecryptedHealthElement>,
	@Serializable(MapAsArraySerializer::class)
	@OptIn(InternalIcureApi::class)
	public val delegates: Map<EntityReferenceInGroup, HealthElementShareOptions>,
)

@OptIn(InternalIcureApi::class)
public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.healthElement.inGroup.shareWithMany(
			decodedParams.healthElement,
			decodedParams.delegates,
		)
	}
}.toPyString(GroupScoped.serializer(DecryptedHealthElement.serializer()))

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
			sdk.healthElement.inGroup.shareWithMany(
				decodedParams.healthElement,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(DecryptedHealthElement.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateHealthElementParams(
	public val entity: GroupScoped<DecryptedHealthElement>,
)

@OptIn(InternalIcureApi::class)
public fun createHealthElementBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateHealthElementParams>(params)
	runBlocking {
		sdk.healthElement.inGroup.createHealthElement(
			decodedParams.entity,
		)
	}
}.toPyString(GroupScoped.serializer(DecryptedHealthElement.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createHealthElementAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateHealthElementParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.inGroup.createHealthElement(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(DecryptedHealthElement.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyHealthElementParams(
	public val entity: GroupScoped<DecryptedHealthElement>,
)

@OptIn(InternalIcureApi::class)
public fun modifyHealthElementBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyHealthElementParams>(params)
	runBlocking {
		sdk.healthElement.inGroup.modifyHealthElement(
			decodedParams.entity,
		)
	}
}.toPyString(GroupScoped.serializer(DecryptedHealthElement.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyHealthElementAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyHealthElementParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.inGroup.modifyHealthElement(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(DecryptedHealthElement.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetHealthElementParams(
	public val groupId: String,
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun getHealthElementBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetHealthElementParams>(params)
	runBlocking {
		sdk.healthElement.inGroup.getHealthElement(
			decodedParams.groupId,
			decodedParams.entityId,
		)
	}
}.toPyString(GroupScoped.serializer(DecryptedHealthElement.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getHealthElementAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetHealthElementParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.inGroup.getHealthElement(
				decodedParams.groupId,
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(DecryptedHealthElement.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
