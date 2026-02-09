// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.MessageShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.DecryptedMessage
import com.icure.cardinal.sdk.model.EncryptedMessage
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.serialization.EntitySubscriptionWithSerializer
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Long
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
public object MessageApi {
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
      DecryptedMessage.serializer().nullable,
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
      DecryptedMessage.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).message.withEncryptionMetadata(
        base,
        patient,
        user,
        delegates,
        secretId,
        alternateRootDelegateId,
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
    messageString: String,
  ) {
    val message = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Message::class),
      messageString
    )
    ApiScope.execute(
      dartResultCallback,
      SetSerializer(HexString.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).message.getEncryptionKeysOf(
        message,
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
    messageString: String,
  ) {
    val message = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Message::class),
      messageString
    )
    ApiScope.execute(
      dartResultCallback,
      Boolean.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).message.hasWriteAccess(
        message,
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
    messageString: String,
  ) {
    val message = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Message::class),
      messageString
    )
    ApiScope.execute(
      dartResultCallback,
      SetSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).message.decryptPatientIdOf(
        message,
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
      PolymorphicSerializer(Message::class),
      entityString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      SetSerializer(String.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).message.createDelegationDeAnonymizationMetadata(
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
    messageString: String,
  ) {
    val message = fullLanguageInteropJson.decodeFromString(
      EncryptedMessage.serializer(),
      messageString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedMessage.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).message.decrypt(
        message,
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
    messageString: String,
  ) {
    val message = fullLanguageInteropJson.decodeFromString(
      EncryptedMessage.serializer(),
      messageString
    )
    ApiScope.execute(
      dartResultCallback,
      PolymorphicSerializer(Message::class)) {
      NativeReferences.get<CardinalApis>(sdkId).message.tryDecrypt(
        message,
      )
    }
  }

  public fun getSecretIdsOf(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    messageString: String,
  ) {
    val message = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Message::class),
      messageString
    )
    ApiScope.execute(
      dartResultCallback,
      MapSerializer(String.serializer(), SetSerializer(EntityReferenceInGroup.serializer()))) {
      NativeReferences.get<CardinalApis>(sdkId).message.getSecretIdsOf(
        message,
      )
    }
  }

  public fun matchMessagesBy(
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
      FilterOptions.serializer(PolymorphicSerializer(Message::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).message.matchMessagesBy(
        filter,
      )
    }
  }

  public fun matchMessagesBySorted(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Message::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).message.matchMessagesBySorted(
        filter,
      )
    }
  }

  public fun deleteMessageById(
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
      NativeReferences.get<CardinalApis>(sdkId).message.deleteMessageById(
        entityId,
        rev,
      )
    }
  }

  public fun deleteMessagesByIds(
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
      ListSerializer(StoredDocumentIdentifier.serializer()),
      entityIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).message.deleteMessagesByIds(
        entityIds,
      )
    }
  }

  public fun purgeMessageById(
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
      NativeReferences.get<CardinalApis>(sdkId).message.purgeMessageById(
        id,
        rev,
      )
    }
  }

  public fun deleteMessage(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    messageString: String,
  ) {
    val message = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Message::class),
      messageString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).message.deleteMessage(
        message,
      )
    }
  }

  public fun deleteMessages(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    messagesString: String,
  ) {
    val messages = fullLanguageInteropJson.decodeFromString(
      ListSerializer(PolymorphicSerializer(Message::class)),
      messagesString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).message.deleteMessages(
        messages,
      )
    }
  }

  public fun purgeMessage(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    messageString: String,
  ) {
    val message = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Message::class),
      messageString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).message.purgeMessage(
        message,
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
    messageString: String,
    optionsString: String,
  ) {
    val delegateId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      delegateIdString
    )
    val message = fullLanguageInteropJson.decodeFromString(
      DecryptedMessage.serializer(),
      messageString
    )
    val options = fullLanguageInteropJson.decodeFromString(
      MessageShareOptions.serializer().nullable,
      optionsString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedMessage.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).message.shareWith(
        delegateId,
        message,
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
    messageString: String,
    delegatesString: String,
  ) {
    val message = fullLanguageInteropJson.decodeFromString(
      DecryptedMessage.serializer(),
      messageString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      MapSerializer(String.serializer(), MessageShareOptions.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedMessage.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).message.shareWithMany(
        message,
        delegates,
      )
    }
  }

  public fun filterMessagesBy(
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
      FilterOptions.serializer(PolymorphicSerializer(Message::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalApis>(sdkId).message.filterMessagesBy(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        DecryptedMessage.serializer()
      ))
    }
  }

  public fun filterMessagesBySorted(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Message::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalApis>(sdkId).message.filterMessagesBySorted(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        DecryptedMessage.serializer()
      ))
    }
  }

  public fun createMessage(
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
      DecryptedMessage.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedMessage.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).message.createMessage(
        entity,
      )
    }
  }

  public fun createMessageInTopic(
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
      DecryptedMessage.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedMessage.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).message.createMessageInTopic(
        entity,
      )
    }
  }

  public fun undeleteMessage(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    messageString: String,
  ) {
    val message = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Message::class),
      messageString
    )
    ApiScope.execute(
      dartResultCallback,
      PolymorphicSerializer(Message::class)) {
      NativeReferences.get<CardinalApis>(sdkId).message.undeleteMessage(
        message,
      )
    }
  }

  public fun modifyMessage(
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
      DecryptedMessage.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedMessage.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).message.modifyMessage(
        entity,
      )
    }
  }

  public fun undeleteMessageById(
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
      DecryptedMessage.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).message.undeleteMessageById(
        id,
        rev,
      )
    }
  }

  public fun getMessage(
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
      DecryptedMessage.serializer().nullable) {
      NativeReferences.get<CardinalApis>(sdkId).message.getMessage(
        entityId,
      )
    }
  }

  public fun getMessages(
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
      ListSerializer(DecryptedMessage.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).message.getMessages(
        entityIds,
      )
    }
  }

  public fun setMessagesReadStatus(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdsString: String,
    timeString: String,
    readStatusString: String,
    userIdString: String,
  ) {
    val entityIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      entityIdsString
    )
    val time = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      timeString
    )
    val readStatus = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      readStatusString
    )
    val userId = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      userIdString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DecryptedMessage.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).message.setMessagesReadStatus(
        entityIds,
        time,
        readStatus,
        userId,
      )
    }
  }

  public fun subscribeToEvents(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    eventsString: String,
    filterString: String,
    subscriptionConfigString: String,
  ) {
    val events = fullLanguageInteropJson.decodeFromString(
      SetSerializer(SubscriptionEventType.serializer()),
      eventsString
    )
    val filter = fullLanguageInteropJson.decodeFromString(
      FilterOptions.serializer(PolymorphicSerializer(Message::class)),
      filterString
    )
    val subscriptionConfig = fullLanguageInteropJson.decodeFromString(
      EntitySubscriptionConfiguration.serializer().nullable,
      subscriptionConfigString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalApis>(sdkId).message.subscribeToEvents(
        events,
        filter,
        subscriptionConfig,
      )
      NativeReferences.create(EntitySubscriptionWithSerializer(
        richResult,
        EncryptedMessage.serializer()
      ))
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
      messageString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val message = fullLanguageInteropJson.decodeFromString(
        EncryptedMessage.serializer(),
        messageString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        MessageShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedMessage.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).message.encrypted.shareWith(
          delegateId,
          message,
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
      messageString: String,
      delegatesString: String,
    ) {
      val message = fullLanguageInteropJson.decodeFromString(
        EncryptedMessage.serializer(),
        messageString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), MessageShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedMessage.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).message.encrypted.shareWithMany(
          message,
          delegates,
        )
      }
    }

    public fun filterMessagesBy(
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
        FilterOptions.serializer(PolymorphicSerializer(Message::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).message.encrypted.filterMessagesBy(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          EncryptedMessage.serializer()
        ))
      }
    }

    public fun filterMessagesBySorted(
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
        SortableFilterOptions.serializer(PolymorphicSerializer(Message::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).message.encrypted.filterMessagesBySorted(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          EncryptedMessage.serializer()
        ))
      }
    }

    public fun createMessage(
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
        EncryptedMessage.serializer(),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedMessage.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).message.encrypted.createMessage(
          entity,
        )
      }
    }

    public fun createMessageInTopic(
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
        EncryptedMessage.serializer(),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedMessage.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).message.encrypted.createMessageInTopic(
          entity,
        )
      }
    }

    public fun undeleteMessage(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      messageString: String,
    ) {
      val message = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Message::class),
        messageString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Message::class)) {
        NativeReferences.get<CardinalApis>(sdkId).message.encrypted.undeleteMessage(
          message,
        )
      }
    }

    public fun modifyMessage(
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
        EncryptedMessage.serializer(),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedMessage.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).message.encrypted.modifyMessage(
          entity,
        )
      }
    }

    public fun undeleteMessageById(
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
        EncryptedMessage.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).message.encrypted.undeleteMessageById(
          id,
          rev,
        )
      }
    }

    public fun getMessage(
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
        EncryptedMessage.serializer().nullable) {
        NativeReferences.get<CardinalApis>(sdkId).message.encrypted.getMessage(
          entityId,
        )
      }
    }

    public fun getMessages(
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
        ListSerializer(EncryptedMessage.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).message.encrypted.getMessages(
          entityIds,
        )
      }
    }

    public fun setMessagesReadStatus(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      entityIdsString: String,
      timeString: String,
      readStatusString: String,
      userIdString: String,
    ) {
      val entityIds = fullLanguageInteropJson.decodeFromString(
        ListSerializer(String.serializer()),
        entityIdsString
      )
      val time = fullLanguageInteropJson.decodeFromString(
        Long.serializer().nullable,
        timeString
      )
      val readStatus = fullLanguageInteropJson.decodeFromString(
        Boolean.serializer(),
        readStatusString
      )
      val userId = fullLanguageInteropJson.decodeFromString(
        String.serializer().nullable,
        userIdString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(EncryptedMessage.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).message.encrypted.setMessagesReadStatus(
          entityIds,
          time,
          readStatus,
          userId,
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
      messageString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val message = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Message::class),
        messageString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        MessageShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Message::class)) {
        NativeReferences.get<CardinalApis>(sdkId).message.tryAndRecover.shareWith(
          delegateId,
          message,
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
      messageString: String,
      delegatesString: String,
    ) {
      val message = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Message::class),
        messageString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), MessageShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Message::class)) {
        NativeReferences.get<CardinalApis>(sdkId).message.tryAndRecover.shareWithMany(
          message,
          delegates,
        )
      }
    }

    public fun filterMessagesBy(
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
        FilterOptions.serializer(PolymorphicSerializer(Message::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).message.tryAndRecover.filterMessagesBy(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          PolymorphicSerializer(Message::class)
        ))
      }
    }

    public fun filterMessagesBySorted(
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
        SortableFilterOptions.serializer(PolymorphicSerializer(Message::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).message.tryAndRecover.filterMessagesBySorted(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          PolymorphicSerializer(Message::class)
        ))
      }
    }

    public fun createMessage(
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
        PolymorphicSerializer(Message::class),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Message::class)) {
        NativeReferences.get<CardinalApis>(sdkId).message.tryAndRecover.createMessage(
          entity,
        )
      }
    }

    public fun createMessageInTopic(
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
        PolymorphicSerializer(Message::class),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Message::class)) {
        NativeReferences.get<CardinalApis>(sdkId).message.tryAndRecover.createMessageInTopic(
          entity,
        )
      }
    }

    public fun undeleteMessage(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      messageString: String,
    ) {
      val message = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Message::class),
        messageString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Message::class)) {
        NativeReferences.get<CardinalApis>(sdkId).message.tryAndRecover.undeleteMessage(
          message,
        )
      }
    }

    public fun modifyMessage(
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
        PolymorphicSerializer(Message::class),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Message::class)) {
        NativeReferences.get<CardinalApis>(sdkId).message.tryAndRecover.modifyMessage(
          entity,
        )
      }
    }

    public fun undeleteMessageById(
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
        PolymorphicSerializer(Message::class)) {
        NativeReferences.get<CardinalApis>(sdkId).message.tryAndRecover.undeleteMessageById(
          id,
          rev,
        )
      }
    }

    public fun getMessage(
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
        PolymorphicSerializer(Message::class).nullable) {
        NativeReferences.get<CardinalApis>(sdkId).message.tryAndRecover.getMessage(
          entityId,
        )
      }
    }

    public fun getMessages(
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
        ListSerializer(PolymorphicSerializer(Message::class))) {
        NativeReferences.get<CardinalApis>(sdkId).message.tryAndRecover.getMessages(
          entityIds,
        )
      }
    }

    public fun setMessagesReadStatus(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      entityIdsString: String,
      timeString: String,
      readStatusString: String,
      userIdString: String,
    ) {
      val entityIds = fullLanguageInteropJson.decodeFromString(
        ListSerializer(String.serializer()),
        entityIdsString
      )
      val time = fullLanguageInteropJson.decodeFromString(
        Long.serializer().nullable,
        timeString
      )
      val readStatus = fullLanguageInteropJson.decodeFromString(
        Boolean.serializer(),
        readStatusString
      )
      val userId = fullLanguageInteropJson.decodeFromString(
        String.serializer().nullable,
        userIdString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(PolymorphicSerializer(Message::class))) {
        NativeReferences.get<CardinalApis>(sdkId).message.tryAndRecover.setMessagesReadStatus(
          entityIds,
          time,
          readStatus,
          userId,
        )
      }
    }
  }
}
