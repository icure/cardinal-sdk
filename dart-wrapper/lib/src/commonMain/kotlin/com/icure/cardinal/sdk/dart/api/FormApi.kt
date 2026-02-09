// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.FormShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.DecryptedForm
import com.icure.cardinal.sdk.model.EncryptedForm
import com.icure.cardinal.sdk.model.Form
import com.icure.cardinal.sdk.model.FormTemplate
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
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
public object FormApi {
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
      DecryptedForm.serializer().nullable,
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
      DecryptedForm.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).form.withEncryptionMetadata(
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
    formString: String,
  ) {
    val form = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Form::class),
      formString
    )
    ApiScope.execute(
      dartResultCallback,
      SetSerializer(HexString.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).form.getEncryptionKeysOf(
        form,
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
    formString: String,
  ) {
    val form = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Form::class),
      formString
    )
    ApiScope.execute(
      dartResultCallback,
      Boolean.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).form.hasWriteAccess(
        form,
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
    formString: String,
  ) {
    val form = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Form::class),
      formString
    )
    ApiScope.execute(
      dartResultCallback,
      SetSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).form.decryptPatientIdOf(
        form,
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
      PolymorphicSerializer(Form::class),
      entityString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      SetSerializer(String.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).form.createDelegationDeAnonymizationMetadata(
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
    formString: String,
  ) {
    val form = fullLanguageInteropJson.decodeFromString(
      EncryptedForm.serializer(),
      formString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedForm.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).form.decrypt(
        form,
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
    formString: String,
  ) {
    val form = fullLanguageInteropJson.decodeFromString(
      EncryptedForm.serializer(),
      formString
    )
    ApiScope.execute(
      dartResultCallback,
      PolymorphicSerializer(Form::class)) {
      NativeReferences.get<CardinalApis>(sdkId).form.tryDecrypt(
        form,
      )
    }
  }

  public fun matchFormsBy(
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
      FilterOptions.serializer(PolymorphicSerializer(Form::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).form.matchFormsBy(
        filter,
      )
    }
  }

  public fun matchFormsBySorted(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Form::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).form.matchFormsBySorted(
        filter,
      )
    }
  }

  public fun deleteFormById(
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
      NativeReferences.get<CardinalApis>(sdkId).form.deleteFormById(
        entityId,
        rev,
      )
    }
  }

  public fun deleteFormsByIds(
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
      NativeReferences.get<CardinalApis>(sdkId).form.deleteFormsByIds(
        entityIds,
      )
    }
  }

  public fun purgeFormById(
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
      NativeReferences.get<CardinalApis>(sdkId).form.purgeFormById(
        id,
        rev,
      )
    }
  }

  public fun deleteForm(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    formString: String,
  ) {
    val form = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Form::class),
      formString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).form.deleteForm(
        form,
      )
    }
  }

  public fun deleteForms(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    formsString: String,
  ) {
    val forms = fullLanguageInteropJson.decodeFromString(
      ListSerializer(PolymorphicSerializer(Form::class)),
      formsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).form.deleteForms(
        forms,
      )
    }
  }

  public fun purgeForm(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    formString: String,
  ) {
    val form = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Form::class),
      formString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).form.purgeForm(
        form,
      )
    }
  }

  public fun getFormTemplate(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    formTemplateIdString: String,
    rawString: String,
  ) {
    val formTemplateId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      formTemplateIdString
    )
    val raw = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer().nullable,
      rawString
    )
    ApiScope.execute(
      dartResultCallback,
      FormTemplate.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).form.getFormTemplate(
        formTemplateId,
        raw,
      )
    }
  }

  public fun createFormTemplate(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    formTemplateString: String,
  ) {
    val formTemplate = fullLanguageInteropJson.decodeFromString(
      FormTemplate.serializer(),
      formTemplateString
    )
    ApiScope.execute(
      dartResultCallback,
      FormTemplate.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).form.createFormTemplate(
        formTemplate,
      )
    }
  }

  public fun deleteFormTemplate(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    formTemplateIdString: String,
  ) {
    val formTemplateId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      formTemplateIdString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).form.deleteFormTemplate(
        formTemplateId,
      )
    }
  }

  public fun updateFormTemplate(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    formTemplateString: String,
  ) {
    val formTemplate = fullLanguageInteropJson.decodeFromString(
      FormTemplate.serializer(),
      formTemplateString
    )
    ApiScope.execute(
      dartResultCallback,
      FormTemplate.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).form.updateFormTemplate(
        formTemplate,
      )
    }
  }

  public fun setTemplateAttachment(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    formTemplateIdString: String,
    payloadString: String,
  ) {
    val formTemplateId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      formTemplateIdString
    )
    val payload = fullLanguageInteropJson.decodeFromString(
      ByteArraySerializer,
      payloadString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).form.setTemplateAttachment(
        formTemplateId,
        payload,
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
    formString: String,
    optionsString: String,
  ) {
    val delegateId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      delegateIdString
    )
    val form = fullLanguageInteropJson.decodeFromString(
      DecryptedForm.serializer(),
      formString
    )
    val options = fullLanguageInteropJson.decodeFromString(
      FormShareOptions.serializer().nullable,
      optionsString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedForm.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).form.shareWith(
        delegateId,
        form,
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
    formString: String,
    delegatesString: String,
  ) {
    val form = fullLanguageInteropJson.decodeFromString(
      DecryptedForm.serializer(),
      formString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      MapSerializer(String.serializer(), FormShareOptions.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedForm.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).form.shareWithMany(
        form,
        delegates,
      )
    }
  }

  public fun filterFormsBy(
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
      FilterOptions.serializer(PolymorphicSerializer(Form::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalApis>(sdkId).form.filterFormsBy(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        DecryptedForm.serializer()
      ))
    }
  }

  public fun filterFormsBySorted(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Form::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalApis>(sdkId).form.filterFormsBySorted(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        DecryptedForm.serializer()
      ))
    }
  }

  public fun createForm(
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
      DecryptedForm.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedForm.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).form.createForm(
        entity,
      )
    }
  }

  public fun createForms(
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
      ListSerializer(DecryptedForm.serializer()),
      entitiesString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DecryptedForm.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).form.createForms(
        entities,
      )
    }
  }

  public fun modifyForm(
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
      DecryptedForm.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedForm.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).form.modifyForm(
        entity,
      )
    }
  }

  public fun undeleteFormById(
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
      DecryptedForm.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).form.undeleteFormById(
        id,
        rev,
      )
    }
  }

  public fun undeleteForm(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    formString: String,
  ) {
    val form = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Form::class),
      formString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedForm.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).form.undeleteForm(
        form,
      )
    }
  }

  public fun modifyForms(
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
      ListSerializer(DecryptedForm.serializer()),
      entitiesString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DecryptedForm.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).form.modifyForms(
        entities,
      )
    }
  }

  public fun getForm(
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
      DecryptedForm.serializer().nullable) {
      NativeReferences.get<CardinalApis>(sdkId).form.getForm(
        entityId,
      )
    }
  }

  public fun getForms(
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
      ListSerializer(DecryptedForm.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).form.getForms(
        entityIds,
      )
    }
  }

  public fun getLatestFormByLogicalUuid(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    logicalUuidString: String,
  ) {
    val logicalUuid = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      logicalUuidString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedForm.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).form.getLatestFormByLogicalUuid(
        logicalUuid,
      )
    }
  }

  public fun getLatestFormByUniqueId(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    uniqueIdString: String,
  ) {
    val uniqueId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      uniqueIdString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedForm.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).form.getLatestFormByUniqueId(
        uniqueId,
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
      formString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val form = fullLanguageInteropJson.decodeFromString(
        EncryptedForm.serializer(),
        formString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        FormShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedForm.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).form.encrypted.shareWith(
          delegateId,
          form,
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
      formString: String,
      delegatesString: String,
    ) {
      val form = fullLanguageInteropJson.decodeFromString(
        EncryptedForm.serializer(),
        formString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), FormShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedForm.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).form.encrypted.shareWithMany(
          form,
          delegates,
        )
      }
    }

    public fun filterFormsBy(
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
        FilterOptions.serializer(PolymorphicSerializer(Form::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult = NativeReferences.get<CardinalApis>(sdkId).form.encrypted.filterFormsBy(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          EncryptedForm.serializer()
        ))
      }
    }

    public fun filterFormsBySorted(
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
        SortableFilterOptions.serializer(PolymorphicSerializer(Form::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).form.encrypted.filterFormsBySorted(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          EncryptedForm.serializer()
        ))
      }
    }

    public fun createForm(
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
        EncryptedForm.serializer(),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedForm.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).form.encrypted.createForm(
          entity,
        )
      }
    }

    public fun createForms(
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
        ListSerializer(EncryptedForm.serializer()),
        entitiesString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(EncryptedForm.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).form.encrypted.createForms(
          entities,
        )
      }
    }

    public fun modifyForm(
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
        EncryptedForm.serializer(),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedForm.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).form.encrypted.modifyForm(
          entity,
        )
      }
    }

    public fun undeleteFormById(
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
        EncryptedForm.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).form.encrypted.undeleteFormById(
          id,
          rev,
        )
      }
    }

    public fun undeleteForm(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      formString: String,
    ) {
      val form = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Form::class),
        formString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedForm.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).form.encrypted.undeleteForm(
          form,
        )
      }
    }

    public fun modifyForms(
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
        ListSerializer(EncryptedForm.serializer()),
        entitiesString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(EncryptedForm.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).form.encrypted.modifyForms(
          entities,
        )
      }
    }

    public fun getForm(
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
        EncryptedForm.serializer().nullable) {
        NativeReferences.get<CardinalApis>(sdkId).form.encrypted.getForm(
          entityId,
        )
      }
    }

    public fun getForms(
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
        ListSerializer(EncryptedForm.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).form.encrypted.getForms(
          entityIds,
        )
      }
    }

    public fun getLatestFormByLogicalUuid(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      logicalUuidString: String,
    ) {
      val logicalUuid = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        logicalUuidString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedForm.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).form.encrypted.getLatestFormByLogicalUuid(
          logicalUuid,
        )
      }
    }

    public fun getLatestFormByUniqueId(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      uniqueIdString: String,
    ) {
      val uniqueId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        uniqueIdString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedForm.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).form.encrypted.getLatestFormByUniqueId(
          uniqueId,
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
      formString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val form = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Form::class),
        formString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        FormShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Form::class)) {
        NativeReferences.get<CardinalApis>(sdkId).form.tryAndRecover.shareWith(
          delegateId,
          form,
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
      formString: String,
      delegatesString: String,
    ) {
      val form = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Form::class),
        formString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), FormShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Form::class)) {
        NativeReferences.get<CardinalApis>(sdkId).form.tryAndRecover.shareWithMany(
          form,
          delegates,
        )
      }
    }

    public fun filterFormsBy(
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
        FilterOptions.serializer(PolymorphicSerializer(Form::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult = NativeReferences.get<CardinalApis>(sdkId).form.tryAndRecover.filterFormsBy(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          PolymorphicSerializer(Form::class)
        ))
      }
    }

    public fun filterFormsBySorted(
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
        SortableFilterOptions.serializer(PolymorphicSerializer(Form::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).form.tryAndRecover.filterFormsBySorted(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          PolymorphicSerializer(Form::class)
        ))
      }
    }

    public fun createForm(
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
        PolymorphicSerializer(Form::class),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Form::class)) {
        NativeReferences.get<CardinalApis>(sdkId).form.tryAndRecover.createForm(
          entity,
        )
      }
    }

    public fun createForms(
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
        ListSerializer(PolymorphicSerializer(Form::class)),
        entitiesString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(PolymorphicSerializer(Form::class))) {
        NativeReferences.get<CardinalApis>(sdkId).form.tryAndRecover.createForms(
          entities,
        )
      }
    }

    public fun modifyForm(
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
        PolymorphicSerializer(Form::class),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Form::class)) {
        NativeReferences.get<CardinalApis>(sdkId).form.tryAndRecover.modifyForm(
          entity,
        )
      }
    }

    public fun undeleteFormById(
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
        PolymorphicSerializer(Form::class)) {
        NativeReferences.get<CardinalApis>(sdkId).form.tryAndRecover.undeleteFormById(
          id,
          rev,
        )
      }
    }

    public fun undeleteForm(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      formString: String,
    ) {
      val form = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Form::class),
        formString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Form::class)) {
        NativeReferences.get<CardinalApis>(sdkId).form.tryAndRecover.undeleteForm(
          form,
        )
      }
    }

    public fun modifyForms(
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
        ListSerializer(PolymorphicSerializer(Form::class)),
        entitiesString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(PolymorphicSerializer(Form::class))) {
        NativeReferences.get<CardinalApis>(sdkId).form.tryAndRecover.modifyForms(
          entities,
        )
      }
    }

    public fun getForm(
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
        PolymorphicSerializer(Form::class).nullable) {
        NativeReferences.get<CardinalApis>(sdkId).form.tryAndRecover.getForm(
          entityId,
        )
      }
    }

    public fun getForms(
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
        ListSerializer(PolymorphicSerializer(Form::class))) {
        NativeReferences.get<CardinalApis>(sdkId).form.tryAndRecover.getForms(
          entityIds,
        )
      }
    }

    public fun getLatestFormByLogicalUuid(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      logicalUuidString: String,
    ) {
      val logicalUuid = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        logicalUuidString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Form::class)) {
        NativeReferences.get<CardinalApis>(sdkId).form.tryAndRecover.getLatestFormByLogicalUuid(
          logicalUuid,
        )
      }
    }

    public fun getLatestFormByUniqueId(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      uniqueIdString: String,
    ) {
      val uniqueId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        uniqueIdString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Form::class)) {
        NativeReferences.get<CardinalApis>(sdkId).form.tryAndRecover.getLatestFormByUniqueId(
          uniqueId,
        )
      }
    }
  }
}
