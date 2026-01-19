// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.ContactShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.DecryptedContact
import com.icure.cardinal.sdk.model.EncryptedContact
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.`data`.LabelledOccurence
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.DecryptedService
import com.icure.cardinal.sdk.model.embed.EncryptedService
import com.icure.cardinal.sdk.model.embed.Service
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
public object ContactApi {
  public fun matchContactsBy(
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
      FilterOptions.serializer(PolymorphicSerializer(Contact::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).contact.matchContactsBy(
        filter,
      )
    }
  }

  public fun matchServicesBy(
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
      FilterOptions.serializer(PolymorphicSerializer(Service::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).contact.matchServicesBy(
        filter,
      )
    }
  }

  public fun matchContactsBySorted(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Contact::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).contact.matchContactsBySorted(
        filter,
      )
    }
  }

  public fun matchServicesBySorted(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Service::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).contact.matchServicesBySorted(
        filter,
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
    patientString: String,
    userString: String,
    delegatesString: String,
    secretIdString: String,
    alternateRootDelegateIdString: String,
  ) {
    val base = fullLanguageInteropJson.decodeFromString(
      DecryptedContact.serializer().nullable,
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
      DecryptedContact.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).contact.withEncryptionMetadata(
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
    contactString: String,
  ) {
    val contact = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Contact::class),
      contactString
    )
    ApiScope.execute(
      dartResultCallback,
      SetSerializer(HexString.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).contact.getEncryptionKeysOf(
        contact,
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
    contactString: String,
  ) {
    val contact = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Contact::class),
      contactString
    )
    ApiScope.execute(
      dartResultCallback,
      Boolean.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).contact.hasWriteAccess(
        contact,
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
    contactString: String,
  ) {
    val contact = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Contact::class),
      contactString
    )
    ApiScope.execute(
      dartResultCallback,
      SetSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).contact.decryptPatientIdOf(
        contact,
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
      PolymorphicSerializer(Contact::class),
      entityString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      SetSerializer(String.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).contact.createDelegationDeAnonymizationMetadata(
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
    contactString: String,
  ) {
    val contact = fullLanguageInteropJson.decodeFromString(
      EncryptedContact.serializer(),
      contactString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedContact.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).contact.decrypt(
        contact,
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
    contactString: String,
  ) {
    val contact = fullLanguageInteropJson.decodeFromString(
      EncryptedContact.serializer(),
      contactString
    )
    ApiScope.execute(
      dartResultCallback,
      PolymorphicSerializer(Contact::class)) {
      NativeReferences.get<CardinalApis>(sdkId).contact.tryDecrypt(
        contact,
      )
    }
  }

  public fun decryptService(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    serviceString: String,
  ) {
    val service = fullLanguageInteropJson.decodeFromString(
      EncryptedService.serializer(),
      serviceString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedService.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).contact.decryptService(
        service,
      )
    }
  }

  public fun tryDecryptService(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    serviceString: String,
  ) {
    val service = fullLanguageInteropJson.decodeFromString(
      EncryptedService.serializer(),
      serviceString
    )
    ApiScope.execute(
      dartResultCallback,
      PolymorphicSerializer(Service::class)) {
      NativeReferences.get<CardinalApis>(sdkId).contact.tryDecryptService(
        service,
      )
    }
  }

  public fun subscribeToServiceCreateOrUpdateEvents(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
    subscriptionConfigString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      FilterOptions.serializer(PolymorphicSerializer(Service::class)),
      filterString
    )
    val subscriptionConfig = fullLanguageInteropJson.decodeFromString(
      EntitySubscriptionConfiguration.serializer().nullable,
      subscriptionConfigString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult =
          NativeReferences.get<CardinalApis>(sdkId).contact.subscribeToServiceCreateOrUpdateEvents(
        filter,
        subscriptionConfig,
      )
      NativeReferences.create(EntitySubscriptionWithSerializer(
        richResult,
        EncryptedService.serializer()
      ))
    }
  }

  public fun deleteContactById(
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
      NativeReferences.get<CardinalApis>(sdkId).contact.deleteContactById(
        entityId,
        rev,
      )
    }
  }

  public fun deleteContactsByIds(
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
      NativeReferences.get<CardinalApis>(sdkId).contact.deleteContactsByIds(
        entityIds,
      )
    }
  }

  public fun purgeContactById(
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
      NativeReferences.get<CardinalApis>(sdkId).contact.purgeContactById(
        id,
        rev,
      )
    }
  }

  public fun deleteContact(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    contactString: String,
  ) {
    val contact = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Contact::class),
      contactString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).contact.deleteContact(
        contact,
      )
    }
  }

  public fun deleteContacts(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    contactsString: String,
  ) {
    val contacts = fullLanguageInteropJson.decodeFromString(
      ListSerializer(PolymorphicSerializer(Contact::class)),
      contactsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).contact.deleteContacts(
        contacts,
      )
    }
  }

  public fun purgeContact(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    contactString: String,
  ) {
    val contact = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Contact::class),
      contactString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).contact.purgeContact(
        contact,
      )
    }
  }

  public fun getServiceCodesOccurrences(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    codeTypeString: String,
    minOccurrencesString: String,
  ) {
    val codeType = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      codeTypeString
    )
    val minOccurrences = fullLanguageInteropJson.decodeFromString(
      Long.serializer(),
      minOccurrencesString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(LabelledOccurence.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).contact.getServiceCodesOccurrences(
        codeType,
        minOccurrences,
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
    contactString: String,
    optionsString: String,
  ) {
    val delegateId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      delegateIdString
    )
    val contact = fullLanguageInteropJson.decodeFromString(
      DecryptedContact.serializer(),
      contactString
    )
    val options = fullLanguageInteropJson.decodeFromString(
      ContactShareOptions.serializer().nullable,
      optionsString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedContact.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).contact.shareWith(
        delegateId,
        contact,
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
    contactString: String,
    delegatesString: String,
  ) {
    val contact = fullLanguageInteropJson.decodeFromString(
      DecryptedContact.serializer(),
      contactString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      MapSerializer(String.serializer(), ContactShareOptions.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedContact.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).contact.shareWithMany(
        contact,
        delegates,
      )
    }
  }

  public fun filterContactsBy(
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
      FilterOptions.serializer(PolymorphicSerializer(Contact::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalApis>(sdkId).contact.filterContactsBy(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        DecryptedContact.serializer()
      ))
    }
  }

  public fun filterServicesBy(
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
      FilterOptions.serializer(PolymorphicSerializer(Service::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalApis>(sdkId).contact.filterServicesBy(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        DecryptedService.serializer()
      ))
    }
  }

  public fun filterContactsBySorted(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Contact::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalApis>(sdkId).contact.filterContactsBySorted(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        DecryptedContact.serializer()
      ))
    }
  }

  public fun filterServicesBySorted(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Service::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalApis>(sdkId).contact.filterServicesBySorted(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        DecryptedService.serializer()
      ))
    }
  }

  public fun createContact(
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
      DecryptedContact.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedContact.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).contact.createContact(
        entity,
      )
    }
  }

  public fun createContacts(
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
      ListSerializer(DecryptedContact.serializer()),
      entitiesString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DecryptedContact.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).contact.createContacts(
        entities,
      )
    }
  }

  public fun undeleteContactById(
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
      DecryptedContact.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).contact.undeleteContactById(
        id,
        rev,
      )
    }
  }

  public fun undeleteContact(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    contactString: String,
  ) {
    val contact = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Contact::class),
      contactString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedContact.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).contact.undeleteContact(
        contact,
      )
    }
  }

  public fun modifyContact(
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
      DecryptedContact.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedContact.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).contact.modifyContact(
        entity,
      )
    }
  }

  public fun modifyContacts(
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
      ListSerializer(DecryptedContact.serializer()),
      entitiesString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DecryptedContact.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).contact.modifyContacts(
        entities,
      )
    }
  }

  public fun getContact(
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
      DecryptedContact.serializer().nullable) {
      NativeReferences.get<CardinalApis>(sdkId).contact.getContact(
        entityId,
      )
    }
  }

  public fun getContacts(
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
      ListSerializer(DecryptedContact.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).contact.getContacts(
        entityIds,
      )
    }
  }

  public fun getService(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    serviceIdString: String,
  ) {
    val serviceId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      serviceIdString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedService.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).contact.getService(
        serviceId,
      )
    }
  }

  public fun getServices(
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
      ListSerializer(DecryptedService.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).contact.getServices(
        entityIds,
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
      FilterOptions.serializer(PolymorphicSerializer(Contact::class)),
      filterString
    )
    val subscriptionConfig = fullLanguageInteropJson.decodeFromString(
      EntitySubscriptionConfiguration.serializer().nullable,
      subscriptionConfigString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalApis>(sdkId).contact.subscribeToEvents(
        events,
        filter,
        subscriptionConfig,
      )
      NativeReferences.create(EntitySubscriptionWithSerializer(
        richResult,
        EncryptedContact.serializer()
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
      contactString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val contact = fullLanguageInteropJson.decodeFromString(
        EncryptedContact.serializer(),
        contactString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        ContactShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedContact.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).contact.encrypted.shareWith(
          delegateId,
          contact,
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
      contactString: String,
      delegatesString: String,
    ) {
      val contact = fullLanguageInteropJson.decodeFromString(
        EncryptedContact.serializer(),
        contactString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), ContactShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedContact.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).contact.encrypted.shareWithMany(
          contact,
          delegates,
        )
      }
    }

    public fun filterContactsBy(
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
        FilterOptions.serializer(PolymorphicSerializer(Contact::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).contact.encrypted.filterContactsBy(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          EncryptedContact.serializer()
        ))
      }
    }

    public fun filterServicesBy(
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
        FilterOptions.serializer(PolymorphicSerializer(Service::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).contact.encrypted.filterServicesBy(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          EncryptedService.serializer()
        ))
      }
    }

    public fun filterContactsBySorted(
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
        SortableFilterOptions.serializer(PolymorphicSerializer(Contact::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).contact.encrypted.filterContactsBySorted(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          EncryptedContact.serializer()
        ))
      }
    }

    public fun filterServicesBySorted(
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
        SortableFilterOptions.serializer(PolymorphicSerializer(Service::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).contact.encrypted.filterServicesBySorted(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          EncryptedService.serializer()
        ))
      }
    }

    public fun createContact(
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
        EncryptedContact.serializer(),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedContact.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).contact.encrypted.createContact(
          entity,
        )
      }
    }

    public fun createContacts(
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
        ListSerializer(EncryptedContact.serializer()),
        entitiesString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(EncryptedContact.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).contact.encrypted.createContacts(
          entities,
        )
      }
    }

    public fun undeleteContactById(
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
        EncryptedContact.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).contact.encrypted.undeleteContactById(
          id,
          rev,
        )
      }
    }

    public fun undeleteContact(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      contactString: String,
    ) {
      val contact = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Contact::class),
        contactString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedContact.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).contact.encrypted.undeleteContact(
          contact,
        )
      }
    }

    public fun modifyContact(
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
        EncryptedContact.serializer(),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedContact.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).contact.encrypted.modifyContact(
          entity,
        )
      }
    }

    public fun modifyContacts(
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
        ListSerializer(EncryptedContact.serializer()),
        entitiesString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(EncryptedContact.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).contact.encrypted.modifyContacts(
          entities,
        )
      }
    }

    public fun getContact(
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
        EncryptedContact.serializer().nullable) {
        NativeReferences.get<CardinalApis>(sdkId).contact.encrypted.getContact(
          entityId,
        )
      }
    }

    public fun getContacts(
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
        ListSerializer(EncryptedContact.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).contact.encrypted.getContacts(
          entityIds,
        )
      }
    }

    public fun getService(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      serviceIdString: String,
    ) {
      val serviceId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        serviceIdString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedService.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).contact.encrypted.getService(
          serviceId,
        )
      }
    }

    public fun getServices(
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
        ListSerializer(EncryptedService.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).contact.encrypted.getServices(
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
      contactString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val contact = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Contact::class),
        contactString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        ContactShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Contact::class)) {
        NativeReferences.get<CardinalApis>(sdkId).contact.tryAndRecover.shareWith(
          delegateId,
          contact,
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
      contactString: String,
      delegatesString: String,
    ) {
      val contact = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Contact::class),
        contactString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), ContactShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Contact::class)) {
        NativeReferences.get<CardinalApis>(sdkId).contact.tryAndRecover.shareWithMany(
          contact,
          delegates,
        )
      }
    }

    public fun filterContactsBy(
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
        FilterOptions.serializer(PolymorphicSerializer(Contact::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).contact.tryAndRecover.filterContactsBy(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          PolymorphicSerializer(Contact::class)
        ))
      }
    }

    public fun filterServicesBy(
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
        FilterOptions.serializer(PolymorphicSerializer(Service::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).contact.tryAndRecover.filterServicesBy(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          PolymorphicSerializer(Service::class)
        ))
      }
    }

    public fun filterContactsBySorted(
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
        SortableFilterOptions.serializer(PolymorphicSerializer(Contact::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).contact.tryAndRecover.filterContactsBySorted(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          PolymorphicSerializer(Contact::class)
        ))
      }
    }

    public fun filterServicesBySorted(
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
        SortableFilterOptions.serializer(PolymorphicSerializer(Service::class)),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).contact.tryAndRecover.filterServicesBySorted(
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          PolymorphicSerializer(Service::class)
        ))
      }
    }

    public fun createContact(
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
        PolymorphicSerializer(Contact::class),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Contact::class)) {
        NativeReferences.get<CardinalApis>(sdkId).contact.tryAndRecover.createContact(
          entity,
        )
      }
    }

    public fun createContacts(
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
        ListSerializer(PolymorphicSerializer(Contact::class)),
        entitiesString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(PolymorphicSerializer(Contact::class))) {
        NativeReferences.get<CardinalApis>(sdkId).contact.tryAndRecover.createContacts(
          entities,
        )
      }
    }

    public fun undeleteContactById(
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
        PolymorphicSerializer(Contact::class)) {
        NativeReferences.get<CardinalApis>(sdkId).contact.tryAndRecover.undeleteContactById(
          id,
          rev,
        )
      }
    }

    public fun undeleteContact(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      contactString: String,
    ) {
      val contact = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Contact::class),
        contactString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Contact::class)) {
        NativeReferences.get<CardinalApis>(sdkId).contact.tryAndRecover.undeleteContact(
          contact,
        )
      }
    }

    public fun modifyContact(
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
        PolymorphicSerializer(Contact::class),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Contact::class)) {
        NativeReferences.get<CardinalApis>(sdkId).contact.tryAndRecover.modifyContact(
          entity,
        )
      }
    }

    public fun modifyContacts(
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
        ListSerializer(PolymorphicSerializer(Contact::class)),
        entitiesString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(PolymorphicSerializer(Contact::class))) {
        NativeReferences.get<CardinalApis>(sdkId).contact.tryAndRecover.modifyContacts(
          entities,
        )
      }
    }

    public fun getContact(
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
        PolymorphicSerializer(Contact::class).nullable) {
        NativeReferences.get<CardinalApis>(sdkId).contact.tryAndRecover.getContact(
          entityId,
        )
      }
    }

    public fun getContacts(
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
        ListSerializer(PolymorphicSerializer(Contact::class))) {
        NativeReferences.get<CardinalApis>(sdkId).contact.tryAndRecover.getContacts(
          entityIds,
        )
      }
    }

    public fun getService(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      serviceIdString: String,
    ) {
      val serviceId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        serviceIdString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Service::class)) {
        NativeReferences.get<CardinalApis>(sdkId).contact.tryAndRecover.getService(
          serviceId,
        )
      }
    }

    public fun getServices(
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
        ListSerializer(PolymorphicSerializer(Service::class))) {
        NativeReferences.get<CardinalApis>(sdkId).contact.tryAndRecover.getServices(
          entityIds,
        )
      }
    }
  }
}
