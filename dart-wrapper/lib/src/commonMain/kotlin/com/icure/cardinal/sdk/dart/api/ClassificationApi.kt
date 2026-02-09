// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.ClassificationShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.Classification
import com.icure.cardinal.sdk.model.DecryptedClassification
import com.icure.cardinal.sdk.model.EncryptedClassification
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
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
public object ClassificationApi {
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
      DecryptedClassification.serializer().nullable,
      baseString
    )
    val patient = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Patient::class),
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
      DecryptedClassification.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).classification.withEncryptionMetadata(
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
    classificationString: String,
  ) {
    val classification = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Classification::class),
      classificationString
    )
    ApiScope.execute(
      dartResultCallback,
      SetSerializer(HexString.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).classification.getEncryptionKeysOf(
        classification,
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
    classificationString: String,
  ) {
    val classification = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Classification::class),
      classificationString
    )
    ApiScope.execute(
      dartResultCallback,
      Boolean.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).classification.hasWriteAccess(
        classification,
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
    classificationString: String,
  ) {
    val classification = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Classification::class),
      classificationString
    )
    ApiScope.execute(
      dartResultCallback,
      SetSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).classification.decryptPatientIdOf(
        classification,
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
      PolymorphicSerializer(Classification::class),
      entityString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      SetSerializer(String.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).classification.createDelegationDeAnonymizationMetadata(
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
    classificationString: String,
  ) {
    val classification = fullLanguageInteropJson.decodeFromString(
      EncryptedClassification.serializer(),
      classificationString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedClassification.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).classification.decrypt(
        classification,
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
    classificationString: String,
  ) {
    val classification = fullLanguageInteropJson.decodeFromString(
      EncryptedClassification.serializer(),
      classificationString
    )
    ApiScope.execute(
      dartResultCallback,
      PolymorphicSerializer(Classification::class)) {
      NativeReferences.get<CardinalApis>(sdkId).classification.tryDecrypt(
        classification,
      )
    }
  }

  public fun matchClassificationsBy(
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
      FilterOptions.serializer(PolymorphicSerializer(Classification::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).classification.matchClassificationsBy(
        filter,
      )
    }
  }

  public fun matchClassificationsBySorted(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Classification::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).classification.matchClassificationsBySorted(
        filter,
      )
    }
  }

  public fun deleteClassification(
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
      NativeReferences.get<CardinalApis>(sdkId).classification.deleteClassification(
        entityId,
      )
    }
  }

  public fun deleteClassifications(
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
      NativeReferences.get<CardinalApis>(sdkId).classification.deleteClassifications(
        entityIds,
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
    classificationString: String,
    optionsString: String,
  ) {
    val delegateId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      delegateIdString
    )
    val classification = fullLanguageInteropJson.decodeFromString(
      DecryptedClassification.serializer(),
      classificationString
    )
    val options = fullLanguageInteropJson.decodeFromString(
      ClassificationShareOptions.serializer().nullable,
      optionsString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedClassification.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).classification.shareWith(
        delegateId,
        classification,
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
    classificationString: String,
    delegatesString: String,
  ) {
    val classification = fullLanguageInteropJson.decodeFromString(
      DecryptedClassification.serializer(),
      classificationString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      MapSerializer(String.serializer(), ClassificationShareOptions.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedClassification.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).classification.shareWithMany(
        classification,
        delegates,
      )
    }
  }

  public fun filterClassificationsBy(
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
      FilterOptions.serializer(PolymorphicSerializer(Classification::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult =
          NativeReferences.get<CardinalApis>(sdkId).classification.filterClassificationsBy(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        DecryptedClassification.serializer()
      ))
    }
  }

  public fun filterClassificationsBySorted(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Classification::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult =
          NativeReferences.get<CardinalApis>(sdkId).classification.filterClassificationsBySorted(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        DecryptedClassification.serializer()
      ))
    }
  }

  public fun createClassification(
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
      DecryptedClassification.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedClassification.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).classification.createClassification(
        entity,
      )
    }
  }

  public fun modifyClassification(
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
      DecryptedClassification.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedClassification.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).classification.modifyClassification(
        entity,
      )
    }
  }

  public fun getClassification(
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
      DecryptedClassification.serializer().nullable) {
      NativeReferences.get<CardinalApis>(sdkId).classification.getClassification(
        entityId,
      )
    }
  }

  public fun getClassifications(
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
      ListSerializer(DecryptedClassification.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).classification.getClassifications(
        entityIds,
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
      classificationString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val classification = fullLanguageInteropJson.decodeFromString(
        EncryptedClassification.serializer(),
        classificationString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        ClassificationShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedClassification.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).classification.encrypted.shareWith(
          delegateId,
          classification,
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
      classificationString: String,
      delegatesString: String,
    ) {
      val classification = fullLanguageInteropJson.decodeFromString(
        EncryptedClassification.serializer(),
        classificationString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), ClassificationShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedClassification.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).classification.encrypted.shareWithMany(
          classification,
          delegates,
        )
      }
    }

    public fun filterClassificationsBy(
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
        FilterOptions.serializer(PolymorphicSerializer(Classification::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).classification.encrypted.filterClassificationsBy(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          EncryptedClassification.serializer()
        ))
      }
    }

    public fun filterClassificationsBySorted(
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
        SortableFilterOptions.serializer(PolymorphicSerializer(Classification::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).classification.encrypted.filterClassificationsBySorted(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          EncryptedClassification.serializer()
        ))
      }
    }

    public fun createClassification(
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
        EncryptedClassification.serializer(),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedClassification.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).classification.encrypted.createClassification(
          entity,
        )
      }
    }

    public fun modifyClassification(
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
        EncryptedClassification.serializer(),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedClassification.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).classification.encrypted.modifyClassification(
          entity,
        )
      }
    }

    public fun getClassification(
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
        EncryptedClassification.serializer().nullable) {
        NativeReferences.get<CardinalApis>(sdkId).classification.encrypted.getClassification(
          entityId,
        )
      }
    }

    public fun getClassifications(
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
        ListSerializer(EncryptedClassification.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).classification.encrypted.getClassifications(
          entityIds,
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
      classificationString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val classification = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Classification::class),
        classificationString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        ClassificationShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Classification::class)) {
        NativeReferences.get<CardinalApis>(sdkId).classification.tryAndRecover.shareWith(
          delegateId,
          classification,
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
      classificationString: String,
      delegatesString: String,
    ) {
      val classification = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Classification::class),
        classificationString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), ClassificationShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Classification::class)) {
        NativeReferences.get<CardinalApis>(sdkId).classification.tryAndRecover.shareWithMany(
          classification,
          delegates,
        )
      }
    }

    public fun filterClassificationsBy(
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
        FilterOptions.serializer(PolymorphicSerializer(Classification::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).classification.tryAndRecover.filterClassificationsBy(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          PolymorphicSerializer(Classification::class)
        ))
      }
    }

    public fun filterClassificationsBySorted(
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
        SortableFilterOptions.serializer(PolymorphicSerializer(Classification::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).classification.tryAndRecover.filterClassificationsBySorted(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          PolymorphicSerializer(Classification::class)
        ))
      }
    }

    public fun createClassification(
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
        PolymorphicSerializer(Classification::class),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Classification::class)) {
        NativeReferences.get<CardinalApis>(sdkId).classification.tryAndRecover.createClassification(
          entity,
        )
      }
    }

    public fun modifyClassification(
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
        PolymorphicSerializer(Classification::class),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Classification::class)) {
        NativeReferences.get<CardinalApis>(sdkId).classification.tryAndRecover.modifyClassification(
          entity,
        )
      }
    }

    public fun getClassification(
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
        PolymorphicSerializer(Classification::class).nullable) {
        NativeReferences.get<CardinalApis>(sdkId).classification.tryAndRecover.getClassification(
          entityId,
        )
      }
    }

    public fun getClassifications(
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
        ListSerializer(PolymorphicSerializer(Classification::class))) {
        NativeReferences.get<CardinalApis>(sdkId).classification.tryAndRecover.getClassifications(
          entityIds,
        )
      }
    }
  }
}
