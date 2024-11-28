// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.crypto.entities.DocumentShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.DecryptedDocument
import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.EncryptedDocument
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.serialization.ByteArraySerializer
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
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
public object DocumentApi {
  public fun createDocument(
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
      DecryptedDocument.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedDocument.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).document.createDocument(
        entity,
      )
    }
  }

  public fun withEncryptionMetadata(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    baseString: String,
    messageString: String,
    userString: String,
    delegatesString: String,
    secretIdString: String,
  ) {
    val base = fullLanguageInteropJson.decodeFromString(
      DecryptedDocument.serializer().nullable,
      baseString
    )
    val message = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Message::class).nullable,
      messageString
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
    ApiScope.execute(
      dartResultCallback,
      DecryptedDocument.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).document.withEncryptionMetadata(
        base,
        message,
        user,
        delegates,
        secretId,
      )
    }
  }

  public fun getAndTryDecryptMainAttachment(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentString: String,
  ) {
    val document = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Document::class),
      documentString
    )
    ApiScope.execute(
      dartResultCallback,
      ByteArraySerializer.nullable) {
      NativeReferences.get<CardinalSdk>(sdkId).document.getAndTryDecryptMainAttachment(
        document,
      )
    }
  }

  public fun getAndDecryptMainAttachment(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentString: String,
  ) {
    val document = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Document::class),
      documentString
    )
    ApiScope.execute(
      dartResultCallback,
      ByteArraySerializer) {
      NativeReferences.get<CardinalSdk>(sdkId).document.getAndDecryptMainAttachment(
        document,
      )
    }
  }

  public fun encryptAndSetMainAttachment(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentString: String,
    utisString: String,
    attachmentString: String,
  ) {
    val document = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Document::class),
      documentString
    )
    val utis = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()).nullable,
      utisString
    )
    val attachment = fullLanguageInteropJson.decodeFromString(
      ByteArraySerializer,
      attachmentString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedDocument.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).document.encryptAndSetMainAttachment(
        document,
        utis,
        attachment,
      )
    }
  }

  public fun getAndDecryptSecondaryAttachment(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentString: String,
    keyString: String,
  ) {
    val document = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Document::class),
      documentString
    )
    val key = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      keyString
    )
    ApiScope.execute(
      dartResultCallback,
      ByteArraySerializer) {
      NativeReferences.get<CardinalSdk>(sdkId).document.getAndDecryptSecondaryAttachment(
        document,
        key,
      )
    }
  }

  public fun encryptAndSetSecondaryAttachment(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentString: String,
    keyString: String,
    utisString: String,
    attachmentString: String,
  ) {
    val document = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Document::class),
      documentString
    )
    val key = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      keyString
    )
    val utis = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()).nullable,
      utisString
    )
    val attachment = fullLanguageInteropJson.decodeFromString(
      ByteArraySerializer,
      attachmentString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedDocument.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).document.encryptAndSetSecondaryAttachment(
        document,
        key,
        utis,
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
    documentString: String,
  ) {
    val document = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Document::class),
      documentString
    )
    ApiScope.execute(
      dartResultCallback,
      SetSerializer(HexString.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).document.getEncryptionKeysOf(
        document,
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
    documentString: String,
  ) {
    val document = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Document::class),
      documentString
    )
    ApiScope.execute(
      dartResultCallback,
      Boolean.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).document.hasWriteAccess(
        document,
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
    documentString: String,
  ) {
    val document = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Document::class),
      documentString
    )
    ApiScope.execute(
      dartResultCallback,
      SetSerializer(String.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).document.decryptPatientIdOf(
        document,
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
      PolymorphicSerializer(Document::class),
      entityString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      SetSerializer(String.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).document.createDelegationDeAnonymizationMetadata(
        entity,
        delegates,
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
    documentString: String,
  ) {
    val document = fullLanguageInteropJson.decodeFromString(
      EncryptedDocument.serializer(),
      documentString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedDocument.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).document.decrypt(
        document,
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
    documentString: String,
  ) {
    val document = fullLanguageInteropJson.decodeFromString(
      EncryptedDocument.serializer(),
      documentString
    )
    ApiScope.execute(
      dartResultCallback,
      PolymorphicSerializer(Document::class)) {
      NativeReferences.get<CardinalSdk>(sdkId).document.tryDecrypt(
        document,
      )
    }
  }

  public fun tryDecryptAttachment(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentString: String,
    encryptedAttachmentString: String,
  ) {
    val document = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Document::class),
      documentString
    )
    val encryptedAttachment = fullLanguageInteropJson.decodeFromString(
      ByteArraySerializer,
      encryptedAttachmentString
    )
    ApiScope.execute(
      dartResultCallback,
      ByteArraySerializer.nullable) {
      NativeReferences.get<CardinalSdk>(sdkId).document.tryDecryptAttachment(
        document,
        encryptedAttachment,
      )
    }
  }

  public fun matchDocumentsBy(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      FilterOptions.serializer(PolymorphicSerializer(Document::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).document.matchDocumentsBy(
        filter,
      )
    }
  }

  public fun matchDocumentsBySorted(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      SortableFilterOptions.serializer(PolymorphicSerializer(Document::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).document.matchDocumentsBySorted(
        filter,
      )
    }
  }

  public fun deleteDocumentById(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdString: String,
    revString: String,
  ) {
    val entityId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      entityIdString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).document.deleteDocumentById(
        entityId,
        rev,
      )
    }
  }

  public fun deleteDocumentsByIds(
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
      ListSerializer(IdWithMandatoryRev.serializer()),
      entityIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).document.deleteDocumentsByIds(
        entityIds,
      )
    }
  }

  public fun purgeDocumentById(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
    revString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).document.purgeDocumentById(
        id,
        rev,
      )
    }
  }

  public fun deleteDocument(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentString: String,
  ) {
    val document = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Document::class),
      documentString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).document.deleteDocument(
        document,
      )
    }
  }

  public fun deleteDocuments(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentsString: String,
  ) {
    val documents = fullLanguageInteropJson.decodeFromString(
      ListSerializer(PolymorphicSerializer(Document::class)),
      documentsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).document.deleteDocuments(
        documents,
      )
    }
  }

  public fun purgeDocument(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentString: String,
  ) {
    val document = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Document::class),
      documentString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).document.purgeDocument(
        document,
      )
    }
  }

  public fun getRawMainAttachment(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentIdString: String,
  ) {
    val documentId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      documentIdString
    )
    ApiScope.execute(
      dartResultCallback,
      ByteArraySerializer) {
      NativeReferences.get<CardinalSdk>(sdkId).document.getRawMainAttachment(
        documentId,
      )
    }
  }

  public fun getRawSecondaryAttachment(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentIdString: String,
    keyString: String,
  ) {
    val documentId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      documentIdString
    )
    val key = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      keyString
    )
    ApiScope.execute(
      dartResultCallback,
      ByteArraySerializer) {
      NativeReferences.get<CardinalSdk>(sdkId).document.getRawSecondaryAttachment(
        documentId,
        key,
      )
    }
  }

  public fun setRawMainAttachment(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentIdString: String,
    revString: String,
    utisString: String,
    attachmentString: String,
    encryptedString: String,
  ) {
    val documentId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      documentIdString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    val utis = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()).nullable,
      utisString
    )
    val attachment = fullLanguageInteropJson.decodeFromString(
      ByteArraySerializer,
      attachmentString
    )
    val encrypted = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      encryptedString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedDocument.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).document.setRawMainAttachment(
        documentId,
        rev,
        utis,
        attachment,
        encrypted,
      )
    }
  }

  public fun setRawSecondaryAttachment(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentIdString: String,
    keyString: String,
    revString: String,
    utisString: String,
    attachmentString: String,
    encryptedString: String,
  ) {
    val documentId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      documentIdString
    )
    val key = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      keyString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    val utis = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()).nullable,
      utisString
    )
    val attachment = fullLanguageInteropJson.decodeFromString(
      ByteArraySerializer,
      attachmentString
    )
    val encrypted = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      encryptedString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedDocument.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).document.setRawSecondaryAttachment(
        documentId,
        key,
        rev,
        utis,
        attachment,
        encrypted,
      )
    }
  }

  public fun deleteMainAttachment(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdString: String,
    revString: String,
  ) {
    val entityId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      entityIdString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedDocument.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).document.deleteMainAttachment(
        entityId,
        rev,
      )
    }
  }

  public fun deleteSecondaryAttachment(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentIdString: String,
    keyString: String,
    revString: String,
  ) {
    val documentId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      documentIdString
    )
    val key = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      keyString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedDocument.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).document.deleteSecondaryAttachment(
        documentId,
        key,
        rev,
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
    documentString: String,
    optionsString: String,
  ) {
    val delegateId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      delegateIdString
    )
    val document = fullLanguageInteropJson.decodeFromString(
      DecryptedDocument.serializer(),
      documentString
    )
    val options = fullLanguageInteropJson.decodeFromString(
      DocumentShareOptions.serializer().nullable,
      optionsString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedDocument.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).document.shareWith(
        delegateId,
        document,
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
    documentString: String,
    delegatesString: String,
  ) {
    val document = fullLanguageInteropJson.decodeFromString(
      DecryptedDocument.serializer(),
      documentString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      MapSerializer(String.serializer(), DocumentShareOptions.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedDocument.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).document.shareWithMany(
        document,
        delegates,
      )
    }
  }

  public fun filterDocumentsBy(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      FilterOptions.serializer(PolymorphicSerializer(Document::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalSdk>(sdkId).document.filterDocumentsBy(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        DecryptedDocument.serializer()
      ))
    }
  }

  public fun filterDocumentsBySorted(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      SortableFilterOptions.serializer(PolymorphicSerializer(Document::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalSdk>(sdkId).document.filterDocumentsBySorted(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        DecryptedDocument.serializer()
      ))
    }
  }

  public fun undeleteDocumentById(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
    revString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedDocument.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).document.undeleteDocumentById(
        id,
        rev,
      )
    }
  }

  public fun undeleteDocument(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentString: String,
  ) {
    val document = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Document::class),
      documentString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedDocument.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).document.undeleteDocument(
        document,
      )
    }
  }

  public fun modifyDocument(
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
      DecryptedDocument.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedDocument.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).document.modifyDocument(
        entity,
      )
    }
  }

  public fun getDocument(
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
      DecryptedDocument.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).document.getDocument(
        entityId,
      )
    }
  }

  public fun getDocuments(
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
      ListSerializer(DecryptedDocument.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).document.getDocuments(
        entityIds,
      )
    }
  }

  public fun modifyDocuments(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entitiesString: String,
  ) {
    val entities = fullLanguageInteropJson.decodeFromString(
      ListSerializer(DecryptedDocument.serializer()),
      entitiesString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DecryptedDocument.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).document.modifyDocuments(
        entities,
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
      documentString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val document = fullLanguageInteropJson.decodeFromString(
        EncryptedDocument.serializer(),
        documentString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        DocumentShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedDocument.serializer()) {
        NativeReferences.get<CardinalSdk>(sdkId).document.encrypted.shareWith(
          delegateId,
          document,
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
      documentString: String,
      delegatesString: String,
    ) {
      val document = fullLanguageInteropJson.decodeFromString(
        EncryptedDocument.serializer(),
        documentString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), DocumentShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedDocument.serializer()) {
        NativeReferences.get<CardinalSdk>(sdkId).document.encrypted.shareWithMany(
          document,
          delegates,
        )
      }
    }

    public fun filterDocumentsBy(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      filterString: String,
    ) {
      val filter = fullLanguageInteropJson.decodeFromString(
        FilterOptions.serializer(PolymorphicSerializer(Document::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalSdk>(sdkId).document.encrypted.filterDocumentsBy(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          EncryptedDocument.serializer()
        ))
      }
    }

    public fun filterDocumentsBySorted(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      filterString: String,
    ) {
      val filter = fullLanguageInteropJson.decodeFromString(
        SortableFilterOptions.serializer(PolymorphicSerializer(Document::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalSdk>(sdkId).document.encrypted.filterDocumentsBySorted(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          EncryptedDocument.serializer()
        ))
      }
    }

    public fun undeleteDocumentById(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      idString: String,
      revString: String,
    ) {
      val id = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        idString
      )
      val rev = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        revString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedDocument.serializer()) {
        NativeReferences.get<CardinalSdk>(sdkId).document.encrypted.undeleteDocumentById(
          id,
          rev,
        )
      }
    }

    public fun undeleteDocument(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      documentString: String,
    ) {
      val document = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Document::class),
        documentString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedDocument.serializer()) {
        NativeReferences.get<CardinalSdk>(sdkId).document.encrypted.undeleteDocument(
          document,
        )
      }
    }

    public fun modifyDocument(
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
        EncryptedDocument.serializer(),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedDocument.serializer()) {
        NativeReferences.get<CardinalSdk>(sdkId).document.encrypted.modifyDocument(
          entity,
        )
      }
    }

    public fun getDocument(
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
        EncryptedDocument.serializer()) {
        NativeReferences.get<CardinalSdk>(sdkId).document.encrypted.getDocument(
          entityId,
        )
      }
    }

    public fun getDocuments(
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
        ListSerializer(EncryptedDocument.serializer())) {
        NativeReferences.get<CardinalSdk>(sdkId).document.encrypted.getDocuments(
          entityIds,
        )
      }
    }

    public fun modifyDocuments(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      entitiesString: String,
    ) {
      val entities = fullLanguageInteropJson.decodeFromString(
        ListSerializer(EncryptedDocument.serializer()),
        entitiesString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(EncryptedDocument.serializer())) {
        NativeReferences.get<CardinalSdk>(sdkId).document.encrypted.modifyDocuments(
          entities,
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
      documentString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val document = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Document::class),
        documentString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        DocumentShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Document::class)) {
        NativeReferences.get<CardinalSdk>(sdkId).document.tryAndRecover.shareWith(
          delegateId,
          document,
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
      documentString: String,
      delegatesString: String,
    ) {
      val document = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Document::class),
        documentString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), DocumentShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Document::class)) {
        NativeReferences.get<CardinalSdk>(sdkId).document.tryAndRecover.shareWithMany(
          document,
          delegates,
        )
      }
    }

    public fun filterDocumentsBy(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      filterString: String,
    ) {
      val filter = fullLanguageInteropJson.decodeFromString(
        FilterOptions.serializer(PolymorphicSerializer(Document::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalSdk>(sdkId).document.tryAndRecover.filterDocumentsBy(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          PolymorphicSerializer(Document::class)
        ))
      }
    }

    public fun filterDocumentsBySorted(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      filterString: String,
    ) {
      val filter = fullLanguageInteropJson.decodeFromString(
        SortableFilterOptions.serializer(PolymorphicSerializer(Document::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalSdk>(sdkId).document.tryAndRecover.filterDocumentsBySorted(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          PolymorphicSerializer(Document::class)
        ))
      }
    }

    public fun undeleteDocumentById(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      idString: String,
      revString: String,
    ) {
      val id = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        idString
      )
      val rev = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        revString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Document::class)) {
        NativeReferences.get<CardinalSdk>(sdkId).document.tryAndRecover.undeleteDocumentById(
          id,
          rev,
        )
      }
    }

    public fun undeleteDocument(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      documentString: String,
    ) {
      val document = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Document::class),
        documentString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Document::class)) {
        NativeReferences.get<CardinalSdk>(sdkId).document.tryAndRecover.undeleteDocument(
          document,
        )
      }
    }

    public fun modifyDocument(
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
        PolymorphicSerializer(Document::class),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Document::class)) {
        NativeReferences.get<CardinalSdk>(sdkId).document.tryAndRecover.modifyDocument(
          entity,
        )
      }
    }

    public fun getDocument(
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
        PolymorphicSerializer(Document::class)) {
        NativeReferences.get<CardinalSdk>(sdkId).document.tryAndRecover.getDocument(
          entityId,
        )
      }
    }

    public fun getDocuments(
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
        ListSerializer(PolymorphicSerializer(Document::class))) {
        NativeReferences.get<CardinalSdk>(sdkId).document.tryAndRecover.getDocuments(
          entityIds,
        )
      }
    }

    public fun modifyDocuments(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      entitiesString: String,
    ) {
      val entities = fullLanguageInteropJson.decodeFromString(
        ListSerializer(PolymorphicSerializer(Document::class)),
        entitiesString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(PolymorphicSerializer(Document::class))) {
        NativeReferences.get<CardinalSdk>(sdkId).document.tryAndRecover.modifyDocuments(
          entities,
        )
      }
    }
  }
}
