// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.ReceiptShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.model.DecryptedReceipt
import com.icure.cardinal.sdk.model.EncryptedReceipt
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.Receipt
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.serialization.ByteArraySerializer
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object ReceiptApi {
  public fun withEncryptionMetadata(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    baseString: String,
    patientString: String,
    userString: String,
    delegatesString: String,
    secretIdString: String,
    alternateRootDelegateIdString: String,
  ) {
    val base = fullLanguageInteropJson.decodeFromString(
      DecryptedReceipt.serializer().nullable,
      baseString
    )
    val patient = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Patient::class).nullable,
      patientString
    )
    val user = fullLanguageInteropJson.decodeFromString(
      User.serializer().nullable,
      userString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      MapSerializer(String.serializer(), AccessLevel.serializer()),
      delegatesString
    )
    val secretId = fullLanguageInteropJson.decodeFromString(
      SecretIdUseOption.serializer(),
      secretIdString
    )
    val alternateRootDelegateId = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      alternateRootDelegateIdString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedReceipt.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).receipt.withEncryptionMetadata(
        base,
        patient,
        user,
        delegates,
        secretId,
        alternateRootDelegateId,
      )
    }
  }

  public fun getAndDecryptReceiptAttachment(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    receiptString: String,
    attachmentIdString: String,
  ) {
    val receipt = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Receipt::class),
      receiptString
    )
    val attachmentId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      attachmentIdString
    )
    ApiScope.execute(
      dartResultCallback,
      ByteArraySerializer) {
      NativeReferences.get<CardinalApis>(sdkId).receipt.getAndDecryptReceiptAttachment(
        receipt,
        attachmentId,
      )
    }
  }

  public fun encryptAndSetReceiptAttachment(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    receiptString: String,
    blobTypeString: String,
    attachmentString: String,
  ) {
    val receipt = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Receipt::class),
      receiptString
    )
    val blobType = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      blobTypeString
    )
    val attachment = fullLanguageInteropJson.decodeFromString(
      ByteArraySerializer,
      attachmentString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedReceipt.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).receipt.encryptAndSetReceiptAttachment(
        receipt,
        blobType,
        attachment,
      )
    }
  }

  public fun getEncryptionKeysOf(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    receiptString: String,
  ) {
    val receipt = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Receipt::class),
      receiptString
    )
    ApiScope.execute(
      dartResultCallback,
      SetSerializer(HexString.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).receipt.getEncryptionKeysOf(
        receipt,
      )
    }
  }

  public fun hasWriteAccess(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    receiptString: String,
  ) {
    val receipt = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Receipt::class),
      receiptString
    )
    ApiScope.execute(
      dartResultCallback,
      Boolean.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).receipt.hasWriteAccess(
        receipt,
      )
    }
  }

  public fun decryptPatientIdOf(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    receiptString: String,
  ) {
    val receipt = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Receipt::class),
      receiptString
    )
    ApiScope.execute(
      dartResultCallback,
      SetSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).receipt.decryptPatientIdOf(
        receipt,
      )
    }
  }

  public fun createDelegationDeAnonymizationMetadata(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityString: String,
    delegatesString: String,
  ) {
    val entity = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Receipt::class),
      entityString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      SetSerializer(String.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).receipt.createDelegationDeAnonymizationMetadata(
        entity,
        delegates,
      )
    }
  }

  public fun logReceipt(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userString: String,
    docIdString: String,
    refsString: String,
    blobTypeString: String,
    blobString: String,
  ) {
    val user = fullLanguageInteropJson.decodeFromString(
      User.serializer(),
      userString
    )
    val docId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      docIdString
    )
    val refs = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      refsString
    )
    val blobType = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      blobTypeString
    )
    val blob = fullLanguageInteropJson.decodeFromString(
      ByteArraySerializer,
      blobString
    )
    ApiScope.execute(
      dartResultCallback,
      PolymorphicSerializer(Receipt::class)) {
      NativeReferences.get<CardinalApis>(sdkId).receipt.logReceipt(
        user,
        docId,
        refs,
        blobType,
        blob,
      )
    }
  }

  public fun decrypt(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    receiptString: String,
  ) {
    val receipt = fullLanguageInteropJson.decodeFromString(
      EncryptedReceipt.serializer(),
      receiptString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedReceipt.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).receipt.decrypt(
        receipt,
      )
    }
  }

  public fun tryDecrypt(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    receiptString: String,
  ) {
    val receipt = fullLanguageInteropJson.decodeFromString(
      EncryptedReceipt.serializer(),
      receiptString
    )
    ApiScope.execute(
      dartResultCallback,
      PolymorphicSerializer(Receipt::class)) {
      NativeReferences.get<CardinalApis>(sdkId).receipt.tryDecrypt(
        receipt,
      )
    }
  }

  public fun deleteReceipt(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdString: String,
  ) {
    val entityId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      entityIdString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).receipt.deleteReceipt(
        entityId,
      )
    }
  }

  public fun deleteReceipts(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdsString: String,
  ) {
    val entityIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      entityIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).receipt.deleteReceipts(
        entityIds,
      )
    }
  }

  public fun getRawReceiptAttachment(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    receiptIdString: String,
    attachmentIdString: String,
  ) {
    val receiptId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      receiptIdString
    )
    val attachmentId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      attachmentIdString
    )
    ApiScope.execute(
      dartResultCallback,
      ByteArraySerializer) {
      NativeReferences.get<CardinalApis>(sdkId).receipt.getRawReceiptAttachment(
        receiptId,
        attachmentId,
      )
    }
  }

  public fun setRawReceiptAttachment(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    receiptIdString: String,
    revString: String,
    blobTypeString: String,
    attachmentString: String,
  ) {
    val receiptId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      receiptIdString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    val blobType = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      blobTypeString
    )
    val attachment = fullLanguageInteropJson.decodeFromString(
      ByteArraySerializer,
      attachmentString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedReceipt.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).receipt.setRawReceiptAttachment(
        receiptId,
        rev,
        blobType,
        attachment,
      )
    }
  }

  public fun shareWith(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    delegateIdString: String,
    receiptString: String,
    optionsString: String,
  ) {
    val delegateId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      delegateIdString
    )
    val receipt = fullLanguageInteropJson.decodeFromString(
      DecryptedReceipt.serializer(),
      receiptString
    )
    val options = fullLanguageInteropJson.decodeFromString(
      ReceiptShareOptions.serializer().nullable,
      optionsString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedReceipt.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).receipt.shareWith(
        delegateId,
        receipt,
        options,
      )
    }
  }

  public fun shareWithMany(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    receiptString: String,
    delegatesString: String,
  ) {
    val receipt = fullLanguageInteropJson.decodeFromString(
      DecryptedReceipt.serializer(),
      receiptString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      MapSerializer(String.serializer(), ReceiptShareOptions.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedReceipt.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).receipt.shareWithMany(
        receipt,
        delegates,
      )
    }
  }

  public fun createReceipt(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityString: String,
  ) {
    val entity = fullLanguageInteropJson.decodeFromString(
      DecryptedReceipt.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedReceipt.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).receipt.createReceipt(
        entity,
      )
    }
  }

  public fun modifyReceipt(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityString: String,
  ) {
    val entity = fullLanguageInteropJson.decodeFromString(
      DecryptedReceipt.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedReceipt.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).receipt.modifyReceipt(
        entity,
      )
    }
  }

  public fun getReceipt(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdString: String,
  ) {
    val entityId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      entityIdString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedReceipt.serializer().nullable) {
      NativeReferences.get<CardinalApis>(sdkId).receipt.getReceipt(
        entityId,
      )
    }
  }

  public fun listByReference(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    referenceString: String,
  ) {
    val reference = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      referenceString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DecryptedReceipt.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).receipt.listByReference(
        reference,
      )
    }
  }

  @OptIn(InternalIcureApi::class)
  public object encrypted {
    public fun shareWith(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      delegateIdString: String,
      receiptString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val receipt = fullLanguageInteropJson.decodeFromString(
        EncryptedReceipt.serializer(),
        receiptString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        ReceiptShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedReceipt.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).receipt.encrypted.shareWith(
          delegateId,
          receipt,
          options,
        )
      }
    }

    public fun shareWithMany(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      receiptString: String,
      delegatesString: String,
    ) {
      val receipt = fullLanguageInteropJson.decodeFromString(
        EncryptedReceipt.serializer(),
        receiptString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), ReceiptShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedReceipt.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).receipt.encrypted.shareWithMany(
          receipt,
          delegates,
        )
      }
    }

    public fun createReceipt(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      entityString: String,
    ) {
      val entity = fullLanguageInteropJson.decodeFromString(
        EncryptedReceipt.serializer(),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedReceipt.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).receipt.encrypted.createReceipt(
          entity,
        )
      }
    }

    public fun modifyReceipt(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      entityString: String,
    ) {
      val entity = fullLanguageInteropJson.decodeFromString(
        EncryptedReceipt.serializer(),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedReceipt.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).receipt.encrypted.modifyReceipt(
          entity,
        )
      }
    }

    public fun getReceipt(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      entityIdString: String,
    ) {
      val entityId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        entityIdString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedReceipt.serializer().nullable) {
        NativeReferences.get<CardinalApis>(sdkId).receipt.encrypted.getReceipt(
          entityId,
        )
      }
    }

    public fun listByReference(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      referenceString: String,
    ) {
      val reference = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        referenceString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(EncryptedReceipt.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).receipt.encrypted.listByReference(
          reference,
        )
      }
    }
  }

  @OptIn(InternalIcureApi::class)
  public object tryAndRecover {
    public fun shareWith(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      delegateIdString: String,
      receiptString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val receipt = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Receipt::class),
        receiptString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        ReceiptShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Receipt::class)) {
        NativeReferences.get<CardinalApis>(sdkId).receipt.tryAndRecover.shareWith(
          delegateId,
          receipt,
          options,
        )
      }
    }

    public fun shareWithMany(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      receiptString: String,
      delegatesString: String,
    ) {
      val receipt = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Receipt::class),
        receiptString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), ReceiptShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Receipt::class)) {
        NativeReferences.get<CardinalApis>(sdkId).receipt.tryAndRecover.shareWithMany(
          receipt,
          delegates,
        )
      }
    }

    public fun createReceipt(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      entityString: String,
    ) {
      val entity = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Receipt::class),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Receipt::class)) {
        NativeReferences.get<CardinalApis>(sdkId).receipt.tryAndRecover.createReceipt(
          entity,
        )
      }
    }

    public fun modifyReceipt(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      entityString: String,
    ) {
      val entity = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Receipt::class),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Receipt::class)) {
        NativeReferences.get<CardinalApis>(sdkId).receipt.tryAndRecover.modifyReceipt(
          entity,
        )
      }
    }

    public fun getReceipt(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      entityIdString: String,
    ) {
      val entityId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        entityIdString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Receipt::class).nullable) {
        NativeReferences.get<CardinalApis>(sdkId).receipt.tryAndRecover.getReceipt(
          entityId,
        )
      }
    }

    public fun listByReference(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      referenceString: String,
    ) {
      val reference = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        referenceString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(PolymorphicSerializer(Receipt::class))) {
        NativeReferences.get<CardinalApis>(sdkId).receipt.tryAndRecover.listByReference(
          reference,
        )
      }
    }
  }
}
