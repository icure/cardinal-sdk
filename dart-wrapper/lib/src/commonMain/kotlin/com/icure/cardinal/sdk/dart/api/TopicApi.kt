// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.crypto.entities.TopicShareOptions
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.DecryptedTopic
import com.icure.cardinal.sdk.model.EncryptedTopic
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.Topic
import com.icure.cardinal.sdk.model.TopicRole
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
public object TopicApi {
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
      DecryptedTopic.serializer().nullable,
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
      DecryptedTopic.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).topic.withEncryptionMetadata(
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
    topicString: String,
  ) {
    val topic = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Topic::class),
      topicString
    )
    ApiScope.execute(
      dartResultCallback,
      SetSerializer(HexString.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).topic.getEncryptionKeysOf(
        topic,
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
    topicString: String,
  ) {
    val topic = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Topic::class),
      topicString
    )
    ApiScope.execute(
      dartResultCallback,
      Boolean.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).topic.hasWriteAccess(
        topic,
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
    topicString: String,
  ) {
    val topic = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Topic::class),
      topicString
    )
    ApiScope.execute(
      dartResultCallback,
      SetSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).topic.decryptPatientIdOf(
        topic,
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
      PolymorphicSerializer(Topic::class),
      entityString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      SetSerializer(String.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).topic.createDelegationDeAnonymizationMetadata(
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
    topicString: String,
  ) {
    val topic = fullLanguageInteropJson.decodeFromString(
      EncryptedTopic.serializer(),
      topicString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedTopic.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).topic.decrypt(
        topic,
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
    topicString: String,
  ) {
    val topic = fullLanguageInteropJson.decodeFromString(
      EncryptedTopic.serializer(),
      topicString
    )
    ApiScope.execute(
      dartResultCallback,
      PolymorphicSerializer(Topic::class)) {
      NativeReferences.get<CardinalApis>(sdkId).topic.tryDecrypt(
        topic,
      )
    }
  }

  public fun matchTopicsBy(
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
      FilterOptions.serializer(PolymorphicSerializer(Topic::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).topic.matchTopicsBy(
        filter,
      )
    }
  }

  public fun matchTopicsBySorted(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Topic::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).topic.matchTopicsBySorted(
        filter,
      )
    }
  }

  public fun deleteTopicById(
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
      NativeReferences.get<CardinalApis>(sdkId).topic.deleteTopicById(
        entityId,
        rev,
      )
    }
  }

  public fun deleteTopicsByIds(
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
      NativeReferences.get<CardinalApis>(sdkId).topic.deleteTopicsByIds(
        entityIds,
      )
    }
  }

  public fun purgeTopicById(
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
      NativeReferences.get<CardinalApis>(sdkId).topic.purgeTopicById(
        id,
        rev,
      )
    }
  }

  public fun deleteTopic(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    topicString: String,
  ) {
    val topic = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Topic::class),
      topicString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).topic.deleteTopic(
        topic,
      )
    }
  }

  public fun deleteTopics(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    topicsString: String,
  ) {
    val topics = fullLanguageInteropJson.decodeFromString(
      ListSerializer(PolymorphicSerializer(Topic::class)),
      topicsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).topic.deleteTopics(
        topics,
      )
    }
  }

  public fun purgeTopic(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    topicString: String,
  ) {
    val topic = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Topic::class),
      topicString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).topic.purgeTopic(
        topic,
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
    topicString: String,
    optionsString: String,
  ) {
    val delegateId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      delegateIdString
    )
    val topic = fullLanguageInteropJson.decodeFromString(
      DecryptedTopic.serializer(),
      topicString
    )
    val options = fullLanguageInteropJson.decodeFromString(
      TopicShareOptions.serializer().nullable,
      optionsString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedTopic.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).topic.shareWith(
        delegateId,
        topic,
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
    topicString: String,
    delegatesString: String,
  ) {
    val topic = fullLanguageInteropJson.decodeFromString(
      DecryptedTopic.serializer(),
      topicString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      MapSerializer(String.serializer(), TopicShareOptions.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedTopic.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).topic.shareWithMany(
        topic,
        delegates,
      )
    }
  }

  public fun filterTopicsBy(
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
      FilterOptions.serializer(PolymorphicSerializer(Topic::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalApis>(sdkId).topic.filterTopicsBy(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        DecryptedTopic.serializer()
      ))
    }
  }

  public fun filterTopicsBySorted(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Topic::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalApis>(sdkId).topic.filterTopicsBySorted(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        DecryptedTopic.serializer()
      ))
    }
  }

  public fun createTopic(
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
      DecryptedTopic.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedTopic.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).topic.createTopic(
        entity,
      )
    }
  }

  public fun undeleteTopic(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    topicString: String,
  ) {
    val topic = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Topic::class),
      topicString
    )
    ApiScope.execute(
      dartResultCallback,
      PolymorphicSerializer(Topic::class)) {
      NativeReferences.get<CardinalApis>(sdkId).topic.undeleteTopic(
        topic,
      )
    }
  }

  public fun modifyTopic(
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
      DecryptedTopic.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedTopic.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).topic.modifyTopic(
        entity,
      )
    }
  }

  public fun undeleteTopicById(
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
      DecryptedTopic.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).topic.undeleteTopicById(
        id,
        rev,
      )
    }
  }

  public fun getTopic(
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
      DecryptedTopic.serializer().nullable) {
      NativeReferences.get<CardinalApis>(sdkId).topic.getTopic(
        entityId,
      )
    }
  }

  public fun getTopics(
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
      ListSerializer(DecryptedTopic.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).topic.getTopics(
        entityIds,
      )
    }
  }

  public fun addParticipant(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdString: String,
    dataOwnerIdString: String,
    topicRoleString: String,
  ) {
    val entityId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      entityIdString
    )
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val topicRole = fullLanguageInteropJson.decodeFromString(
      TopicRole.serializer(),
      topicRoleString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedTopic.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).topic.addParticipant(
        entityId,
        dataOwnerId,
        topicRole,
      )
    }
  }

  public fun removeParticipant(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdString: String,
    dataOwnerIdString: String,
  ) {
    val entityId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      entityIdString
    )
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedTopic.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).topic.removeParticipant(
        entityId,
        dataOwnerId,
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
      FilterOptions.serializer(PolymorphicSerializer(Topic::class)),
      filterString
    )
    val subscriptionConfig = fullLanguageInteropJson.decodeFromString(
      EntitySubscriptionConfiguration.serializer().nullable,
      subscriptionConfigString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalApis>(sdkId).topic.subscribeToEvents(
        events,
        filter,
        subscriptionConfig,
      )
      NativeReferences.create(EntitySubscriptionWithSerializer(
        richResult,
        EncryptedTopic.serializer()
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
      topicString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val topic = fullLanguageInteropJson.decodeFromString(
        EncryptedTopic.serializer(),
        topicString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        TopicShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedTopic.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).topic.encrypted.shareWith(
          delegateId,
          topic,
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
      topicString: String,
      delegatesString: String,
    ) {
      val topic = fullLanguageInteropJson.decodeFromString(
        EncryptedTopic.serializer(),
        topicString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), TopicShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedTopic.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).topic.encrypted.shareWithMany(
          topic,
          delegates,
        )
      }
    }

    public fun filterTopicsBy(
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
        FilterOptions.serializer(PolymorphicSerializer(Topic::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult = NativeReferences.get<CardinalApis>(sdkId).topic.encrypted.filterTopicsBy(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          EncryptedTopic.serializer()
        ))
      }
    }

    public fun filterTopicsBySorted(
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
        SortableFilterOptions.serializer(PolymorphicSerializer(Topic::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).topic.encrypted.filterTopicsBySorted(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          EncryptedTopic.serializer()
        ))
      }
    }

    public fun createTopic(
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
        EncryptedTopic.serializer(),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedTopic.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).topic.encrypted.createTopic(
          entity,
        )
      }
    }

    public fun undeleteTopic(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      topicString: String,
    ) {
      val topic = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Topic::class),
        topicString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Topic::class)) {
        NativeReferences.get<CardinalApis>(sdkId).topic.encrypted.undeleteTopic(
          topic,
        )
      }
    }

    public fun modifyTopic(
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
        EncryptedTopic.serializer(),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedTopic.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).topic.encrypted.modifyTopic(
          entity,
        )
      }
    }

    public fun undeleteTopicById(
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
        EncryptedTopic.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).topic.encrypted.undeleteTopicById(
          id,
          rev,
        )
      }
    }

    public fun getTopic(
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
        EncryptedTopic.serializer().nullable) {
        NativeReferences.get<CardinalApis>(sdkId).topic.encrypted.getTopic(
          entityId,
        )
      }
    }

    public fun getTopics(
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
        ListSerializer(EncryptedTopic.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).topic.encrypted.getTopics(
          entityIds,
        )
      }
    }

    public fun addParticipant(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      entityIdString: String,
      dataOwnerIdString: String,
      topicRoleString: String,
    ) {
      val entityId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        entityIdString
      )
      val dataOwnerId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        dataOwnerIdString
      )
      val topicRole = fullLanguageInteropJson.decodeFromString(
        TopicRole.serializer(),
        topicRoleString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedTopic.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).topic.encrypted.addParticipant(
          entityId,
          dataOwnerId,
          topicRole,
        )
      }
    }

    public fun removeParticipant(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      entityIdString: String,
      dataOwnerIdString: String,
    ) {
      val entityId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        entityIdString
      )
      val dataOwnerId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        dataOwnerIdString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedTopic.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).topic.encrypted.removeParticipant(
          entityId,
          dataOwnerId,
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
      topicString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val topic = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Topic::class),
        topicString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        TopicShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Topic::class)) {
        NativeReferences.get<CardinalApis>(sdkId).topic.tryAndRecover.shareWith(
          delegateId,
          topic,
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
      topicString: String,
      delegatesString: String,
    ) {
      val topic = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Topic::class),
        topicString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), TopicShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Topic::class)) {
        NativeReferences.get<CardinalApis>(sdkId).topic.tryAndRecover.shareWithMany(
          topic,
          delegates,
        )
      }
    }

    public fun filterTopicsBy(
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
        FilterOptions.serializer(PolymorphicSerializer(Topic::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).topic.tryAndRecover.filterTopicsBy(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          PolymorphicSerializer(Topic::class)
        ))
      }
    }

    public fun filterTopicsBySorted(
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
        SortableFilterOptions.serializer(PolymorphicSerializer(Topic::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).topic.tryAndRecover.filterTopicsBySorted(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          PolymorphicSerializer(Topic::class)
        ))
      }
    }

    public fun createTopic(
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
        PolymorphicSerializer(Topic::class),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Topic::class)) {
        NativeReferences.get<CardinalApis>(sdkId).topic.tryAndRecover.createTopic(
          entity,
        )
      }
    }

    public fun undeleteTopic(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      topicString: String,
    ) {
      val topic = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Topic::class),
        topicString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Topic::class)) {
        NativeReferences.get<CardinalApis>(sdkId).topic.tryAndRecover.undeleteTopic(
          topic,
        )
      }
    }

    public fun modifyTopic(
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
        PolymorphicSerializer(Topic::class),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Topic::class)) {
        NativeReferences.get<CardinalApis>(sdkId).topic.tryAndRecover.modifyTopic(
          entity,
        )
      }
    }

    public fun undeleteTopicById(
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
        PolymorphicSerializer(Topic::class)) {
        NativeReferences.get<CardinalApis>(sdkId).topic.tryAndRecover.undeleteTopicById(
          id,
          rev,
        )
      }
    }

    public fun getTopic(
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
        PolymorphicSerializer(Topic::class).nullable) {
        NativeReferences.get<CardinalApis>(sdkId).topic.tryAndRecover.getTopic(
          entityId,
        )
      }
    }

    public fun getTopics(
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
        ListSerializer(PolymorphicSerializer(Topic::class))) {
        NativeReferences.get<CardinalApis>(sdkId).topic.tryAndRecover.getTopics(
          entityIds,
        )
      }
    }

    public fun addParticipant(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      entityIdString: String,
      dataOwnerIdString: String,
      topicRoleString: String,
    ) {
      val entityId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        entityIdString
      )
      val dataOwnerId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        dataOwnerIdString
      )
      val topicRole = fullLanguageInteropJson.decodeFromString(
        TopicRole.serializer(),
        topicRoleString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Topic::class)) {
        NativeReferences.get<CardinalApis>(sdkId).topic.tryAndRecover.addParticipant(
          entityId,
          dataOwnerId,
          topicRole,
        )
      }
    }

    public fun removeParticipant(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      entityIdString: String,
      dataOwnerIdString: String,
    ) {
      val entityId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        entityIdString
      )
      val dataOwnerId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        dataOwnerIdString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Topic::class)) {
        NativeReferences.get<CardinalApis>(sdkId).topic.tryAndRecover.removeParticipant(
          entityId,
          dataOwnerId,
        )
      }
    }
  }
}
