// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.InvoiceShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.model.DecryptedInvoice
import com.icure.cardinal.sdk.model.EncryptedInvoice
import com.icure.cardinal.sdk.model.Invoice
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.`data`.LabelledOccurence
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.EncryptedInvoicingCode
import com.icure.cardinal.sdk.model.embed.InvoiceType
import com.icure.cardinal.sdk.model.embed.MediumType
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Int
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
public object InvoiceApi {
  public fun createInvoice(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityString: String,
    prefixString: String,
  ) {
    val entity = fullLanguageInteropJson.decodeFromString(
      DecryptedInvoice.serializer(),
      entityString
    )
    val prefix = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      prefixString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedInvoice.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).invoice.createInvoice(
        entity,
        prefix,
      )
    }
  }

  public fun createInvoices(
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
      ListSerializer(DecryptedInvoice.serializer()),
      entitiesString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DecryptedInvoice.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).invoice.createInvoices(
        entities,
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
      DecryptedInvoice.serializer().nullable,
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
      DecryptedInvoice.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).invoice.withEncryptionMetadata(
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
    invoiceString: String,
  ) {
    val invoice = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Invoice::class),
      invoiceString
    )
    ApiScope.execute(
      dartResultCallback,
      SetSerializer(HexString.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).invoice.getEncryptionKeysOf(
        invoice,
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
    invoiceString: String,
  ) {
    val invoice = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Invoice::class),
      invoiceString
    )
    ApiScope.execute(
      dartResultCallback,
      Boolean.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).invoice.hasWriteAccess(
        invoice,
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
    invoiceString: String,
  ) {
    val invoice = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Invoice::class),
      invoiceString
    )
    ApiScope.execute(
      dartResultCallback,
      SetSerializer(String.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).invoice.decryptPatientIdOf(
        invoice,
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
      PolymorphicSerializer(Invoice::class),
      entityString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      SetSerializer(String.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).invoice.createDelegationDeAnonymizationMetadata(
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
    invoiceString: String,
  ) {
    val invoice = fullLanguageInteropJson.decodeFromString(
      EncryptedInvoice.serializer(),
      invoiceString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedInvoice.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).invoice.decrypt(
        invoice,
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
    invoiceString: String,
  ) {
    val invoice = fullLanguageInteropJson.decodeFromString(
      EncryptedInvoice.serializer(),
      invoiceString
    )
    ApiScope.execute(
      dartResultCallback,
      PolymorphicSerializer(Invoice::class)) {
      NativeReferences.get<CardinalApis>(sdkId).invoice.tryDecrypt(
        invoice,
      )
    }
  }

  public fun deleteInvoice(
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
      NativeReferences.get<CardinalApis>(sdkId).invoice.deleteInvoice(
        entityId,
      )
    }
  }

  public fun getTarificationsCodesOccurrences(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    minOccurrenceString: String,
  ) {
    val minOccurrence = fullLanguageInteropJson.decodeFromString(
      Int.serializer(),
      minOccurrenceString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(LabelledOccurence.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).invoice.getTarificationsCodesOccurrences(
        minOccurrence,
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
    invoiceString: String,
    optionsString: String,
  ) {
    val delegateId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      delegateIdString
    )
    val invoice = fullLanguageInteropJson.decodeFromString(
      DecryptedInvoice.serializer(),
      invoiceString
    )
    val options = fullLanguageInteropJson.decodeFromString(
      InvoiceShareOptions.serializer().nullable,
      optionsString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedInvoice.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).invoice.shareWith(
        delegateId,
        invoice,
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
    invoiceString: String,
    delegatesString: String,
  ) {
    val invoice = fullLanguageInteropJson.decodeFromString(
      DecryptedInvoice.serializer(),
      invoiceString
    )
    val delegates = fullLanguageInteropJson.decodeFromString(
      MapSerializer(String.serializer(), InvoiceShareOptions.serializer()),
      delegatesString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedInvoice.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).invoice.shareWithMany(
        invoice,
        delegates,
      )
    }
  }

  public fun modifyInvoice(
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
      DecryptedInvoice.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedInvoice.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).invoice.modifyInvoice(
        entity,
      )
    }
  }

  public fun modifyInvoices(
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
      ListSerializer(DecryptedInvoice.serializer()),
      entitiesString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DecryptedInvoice.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).invoice.modifyInvoices(
        entities,
      )
    }
  }

  public fun getInvoice(
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
      DecryptedInvoice.serializer().nullable) {
      NativeReferences.get<CardinalApis>(sdkId).invoice.getInvoice(
        entityId,
      )
    }
  }

  public fun getInvoices(
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
      ListSerializer(DecryptedInvoice.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).invoice.getInvoices(
        entityIds,
      )
    }
  }

  public fun reassignInvoice(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    invoiceString: String,
  ) {
    val invoice = fullLanguageInteropJson.decodeFromString(
      DecryptedInvoice.serializer(),
      invoiceString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedInvoice.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).invoice.reassignInvoice(
        invoice,
      )
    }
  }

  public fun mergeTo(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    invoiceIdString: String,
    idsString: String,
  ) {
    val invoiceId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      invoiceIdString
    )
    val ids = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      idsString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedInvoice.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).invoice.mergeTo(
        invoiceId,
        ids,
      )
    }
  }

  public fun validate(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    invoiceIdString: String,
    schemeString: String,
    forcedValueString: String,
  ) {
    val invoiceId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      invoiceIdString
    )
    val scheme = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      schemeString
    )
    val forcedValue = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      forcedValueString
    )
    ApiScope.execute(
      dartResultCallback,
      DecryptedInvoice.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).invoice.validate(
        invoiceId,
        scheme,
        forcedValue,
      )
    }
  }

  public fun appendCodes(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userIdString: String,
    typeString: String,
    sentMediumTypeString: String,
    secretFKeysString: String,
    insuranceIdString: String,
    invoiceIdString: String,
    gracePeriodString: String,
    invoicingCodesString: String,
  ) {
    val userId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      userIdString
    )
    val type = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      typeString
    )
    val sentMediumType = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      sentMediumTypeString
    )
    val secretFKeys = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      secretFKeysString
    )
    val insuranceId = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      insuranceIdString
    )
    val invoiceId = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      invoiceIdString
    )
    val gracePeriod = fullLanguageInteropJson.decodeFromString(
      Int.serializer().nullable,
      gracePeriodString
    )
    val invoicingCodes = fullLanguageInteropJson.decodeFromString(
      ListSerializer(EncryptedInvoicingCode.serializer()),
      invoicingCodesString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DecryptedInvoice.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).invoice.appendCodes(
        userId,
        type,
        sentMediumType,
        secretFKeys,
        insuranceId,
        invoiceId,
        gracePeriod,
        invoicingCodes,
      )
    }
  }

  public fun removeCodes(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userIdString: String,
    serviceIdString: String,
    secretFKeysString: String,
    tarificationIdsString: String,
  ) {
    val userId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      userIdString
    )
    val serviceId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      serviceIdString
    )
    val secretFKeys = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      secretFKeysString
    )
    val tarificationIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      tarificationIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DecryptedInvoice.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).invoice.removeCodes(
        userId,
        serviceId,
        secretFKeys,
        tarificationIds,
      )
    }
  }

  public fun listInvoicesByHcPartyAndGroupId(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    hcPartyIdString: String,
    groupIdString: String,
  ) {
    val hcPartyId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      hcPartyIdString
    )
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DecryptedInvoice.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).invoice.listInvoicesByHcPartyAndGroupId(
        hcPartyId,
        groupId,
      )
    }
  }

  public fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    hcPartyIdString: String,
    sentMediumTypeString: String,
    invoiceTypeString: String,
    sentString: String,
    fromString: String,
    toString: String,
  ) {
    val hcPartyId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      hcPartyIdString
    )
    val sentMediumType = fullLanguageInteropJson.decodeFromString(
      MediumType.serializer(),
      sentMediumTypeString
    )
    val invoiceType = fullLanguageInteropJson.decodeFromString(
      InvoiceType.serializer(),
      invoiceTypeString
    )
    val sent = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      sentString
    )
    val from = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      fromString
    )
    val to = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      toString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DecryptedInvoice.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).invoice.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
        hcPartyId,
        sentMediumType,
        invoiceType,
        sent,
        from,
        to,
      )
    }
  }

  public fun listInvoicesByContactIds(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    contactIdsString: String,
  ) {
    val contactIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      contactIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DecryptedInvoice.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).invoice.listInvoicesByContactIds(
        contactIds,
      )
    }
  }

  public fun listInvoicesByRecipientsIds(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    recipientsIdsString: String,
  ) {
    val recipientsIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      recipientsIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DecryptedInvoice.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).invoice.listInvoicesByRecipientsIds(
        recipientsIds,
      )
    }
  }

  public fun listToInsurances(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userIdsString: String,
  ) {
    val userIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      userIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DecryptedInvoice.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).invoice.listToInsurances(
        userIds,
      )
    }
  }

  public fun listToInsurancesUnsent(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userIdsString: String,
  ) {
    val userIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      userIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DecryptedInvoice.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).invoice.listToInsurancesUnsent(
        userIds,
      )
    }
  }

  public fun listToPatients(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    hcPartyIdString: String,
  ) {
    val hcPartyId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      hcPartyIdString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DecryptedInvoice.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).invoice.listToPatients(
        hcPartyId,
      )
    }
  }

  public fun listToPatientsUnsent(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    hcPartyIdString: String,
  ) {
    val hcPartyId = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      hcPartyIdString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DecryptedInvoice.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).invoice.listToPatientsUnsent(
        hcPartyId,
      )
    }
  }

  public fun listInvoicesByIds(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idsString: String,
  ) {
    val ids = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      idsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DecryptedInvoice.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).invoice.listInvoicesByIds(
        ids,
      )
    }
  }

  public fun listInvoicesByHcpartySendingModeStatusDate(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    hcPartyIdString: String,
    sendingModeString: String,
    statusString: String,
    fromString: String,
    toString: String,
  ) {
    val hcPartyId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      hcPartyIdString
    )
    val sendingMode = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      sendingModeString
    )
    val status = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      statusString
    )
    val from = fullLanguageInteropJson.decodeFromString(
      Long.serializer(),
      fromString
    )
    val to = fullLanguageInteropJson.decodeFromString(
      Long.serializer(),
      toString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DecryptedInvoice.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).invoice.listInvoicesByHcpartySendingModeStatusDate(
        hcPartyId,
        sendingMode,
        status,
        from,
        to,
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
      invoiceString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val invoice = fullLanguageInteropJson.decodeFromString(
        EncryptedInvoice.serializer(),
        invoiceString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        InvoiceShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedInvoice.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.encrypted.shareWith(
          delegateId,
          invoice,
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
      invoiceString: String,
      delegatesString: String,
    ) {
      val invoice = fullLanguageInteropJson.decodeFromString(
        EncryptedInvoice.serializer(),
        invoiceString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), InvoiceShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedInvoice.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.encrypted.shareWithMany(
          invoice,
          delegates,
        )
      }
    }

    public fun modifyInvoice(
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
        EncryptedInvoice.serializer(),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedInvoice.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.encrypted.modifyInvoice(
          entity,
        )
      }
    }

    public fun modifyInvoices(
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
        ListSerializer(EncryptedInvoice.serializer()),
        entitiesString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(EncryptedInvoice.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.encrypted.modifyInvoices(
          entities,
        )
      }
    }

    public fun getInvoice(
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
        EncryptedInvoice.serializer().nullable) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.encrypted.getInvoice(
          entityId,
        )
      }
    }

    public fun getInvoices(
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
        ListSerializer(EncryptedInvoice.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.encrypted.getInvoices(
          entityIds,
        )
      }
    }

    public fun reassignInvoice(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      invoiceString: String,
    ) {
      val invoice = fullLanguageInteropJson.decodeFromString(
        EncryptedInvoice.serializer(),
        invoiceString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedInvoice.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.encrypted.reassignInvoice(
          invoice,
        )
      }
    }

    public fun mergeTo(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      invoiceIdString: String,
      idsString: String,
    ) {
      val invoiceId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        invoiceIdString
      )
      val ids = fullLanguageInteropJson.decodeFromString(
        ListSerializer(String.serializer()),
        idsString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedInvoice.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.encrypted.mergeTo(
          invoiceId,
          ids,
        )
      }
    }

    public fun validate(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      invoiceIdString: String,
      schemeString: String,
      forcedValueString: String,
    ) {
      val invoiceId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        invoiceIdString
      )
      val scheme = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        schemeString
      )
      val forcedValue = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        forcedValueString
      )
      ApiScope.execute(
        dartResultCallback,
        EncryptedInvoice.serializer()) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.encrypted.validate(
          invoiceId,
          scheme,
          forcedValue,
        )
      }
    }

    public fun appendCodes(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      userIdString: String,
      typeString: String,
      sentMediumTypeString: String,
      secretFKeysString: String,
      insuranceIdString: String,
      invoiceIdString: String,
      gracePeriodString: String,
      invoicingCodesString: String,
    ) {
      val userId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        userIdString
      )
      val type = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        typeString
      )
      val sentMediumType = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        sentMediumTypeString
      )
      val secretFKeys = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        secretFKeysString
      )
      val insuranceId = fullLanguageInteropJson.decodeFromString(
        String.serializer().nullable,
        insuranceIdString
      )
      val invoiceId = fullLanguageInteropJson.decodeFromString(
        String.serializer().nullable,
        invoiceIdString
      )
      val gracePeriod = fullLanguageInteropJson.decodeFromString(
        Int.serializer().nullable,
        gracePeriodString
      )
      val invoicingCodes = fullLanguageInteropJson.decodeFromString(
        ListSerializer(EncryptedInvoicingCode.serializer()),
        invoicingCodesString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(EncryptedInvoice.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.encrypted.appendCodes(
          userId,
          type,
          sentMediumType,
          secretFKeys,
          insuranceId,
          invoiceId,
          gracePeriod,
          invoicingCodes,
        )
      }
    }

    public fun removeCodes(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      userIdString: String,
      serviceIdString: String,
      secretFKeysString: String,
      tarificationIdsString: String,
    ) {
      val userId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        userIdString
      )
      val serviceId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        serviceIdString
      )
      val secretFKeys = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        secretFKeysString
      )
      val tarificationIds = fullLanguageInteropJson.decodeFromString(
        ListSerializer(String.serializer()),
        tarificationIdsString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(EncryptedInvoice.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.encrypted.removeCodes(
          userId,
          serviceId,
          secretFKeys,
          tarificationIds,
        )
      }
    }

    public fun listInvoicesByHcPartyAndGroupId(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      hcPartyIdString: String,
      groupIdString: String,
    ) {
      val hcPartyId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        hcPartyIdString
      )
      val groupId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        groupIdString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(EncryptedInvoice.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.encrypted.listInvoicesByHcPartyAndGroupId(
          hcPartyId,
          groupId,
        )
      }
    }

    public fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      hcPartyIdString: String,
      sentMediumTypeString: String,
      invoiceTypeString: String,
      sentString: String,
      fromString: String,
      toString: String,
    ) {
      val hcPartyId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        hcPartyIdString
      )
      val sentMediumType = fullLanguageInteropJson.decodeFromString(
        MediumType.serializer(),
        sentMediumTypeString
      )
      val invoiceType = fullLanguageInteropJson.decodeFromString(
        InvoiceType.serializer(),
        invoiceTypeString
      )
      val sent = fullLanguageInteropJson.decodeFromString(
        Boolean.serializer(),
        sentString
      )
      val from = fullLanguageInteropJson.decodeFromString(
        Long.serializer().nullable,
        fromString
      )
      val to = fullLanguageInteropJson.decodeFromString(
        Long.serializer().nullable,
        toString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(EncryptedInvoice.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.encrypted.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
          hcPartyId,
          sentMediumType,
          invoiceType,
          sent,
          from,
          to,
        )
      }
    }

    public fun listInvoicesByContactIds(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      contactIdsString: String,
    ) {
      val contactIds = fullLanguageInteropJson.decodeFromString(
        ListSerializer(String.serializer()),
        contactIdsString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(EncryptedInvoice.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.encrypted.listInvoicesByContactIds(
          contactIds,
        )
      }
    }

    public fun listInvoicesByRecipientsIds(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      recipientsIdsString: String,
    ) {
      val recipientsIds = fullLanguageInteropJson.decodeFromString(
        ListSerializer(String.serializer()),
        recipientsIdsString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(EncryptedInvoice.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.encrypted.listInvoicesByRecipientsIds(
          recipientsIds,
        )
      }
    }

    public fun listToInsurances(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      userIdsString: String,
    ) {
      val userIds = fullLanguageInteropJson.decodeFromString(
        ListSerializer(String.serializer()),
        userIdsString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(EncryptedInvoice.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.encrypted.listToInsurances(
          userIds,
        )
      }
    }

    public fun listToInsurancesUnsent(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      userIdsString: String,
    ) {
      val userIds = fullLanguageInteropJson.decodeFromString(
        ListSerializer(String.serializer()),
        userIdsString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(EncryptedInvoice.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.encrypted.listToInsurancesUnsent(
          userIds,
        )
      }
    }

    public fun listToPatients(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      hcPartyIdString: String,
    ) {
      val hcPartyId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        hcPartyIdString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(EncryptedInvoice.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.encrypted.listToPatients(
          hcPartyId,
        )
      }
    }

    public fun listToPatientsUnsent(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      hcPartyIdString: String,
    ) {
      val hcPartyId = fullLanguageInteropJson.decodeFromString(
        String.serializer().nullable,
        hcPartyIdString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(EncryptedInvoice.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.encrypted.listToPatientsUnsent(
          hcPartyId,
        )
      }
    }

    public fun listInvoicesByIds(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      idsString: String,
    ) {
      val ids = fullLanguageInteropJson.decodeFromString(
        ListSerializer(String.serializer()),
        idsString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(EncryptedInvoice.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.encrypted.listInvoicesByIds(
          ids,
        )
      }
    }

    public fun listInvoicesByHcpartySendingModeStatusDate(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      hcPartyIdString: String,
      sendingModeString: String,
      statusString: String,
      fromString: String,
      toString: String,
    ) {
      val hcPartyId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        hcPartyIdString
      )
      val sendingMode = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        sendingModeString
      )
      val status = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        statusString
      )
      val from = fullLanguageInteropJson.decodeFromString(
        Long.serializer(),
        fromString
      )
      val to = fullLanguageInteropJson.decodeFromString(
        Long.serializer(),
        toString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(EncryptedInvoice.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.encrypted.listInvoicesByHcpartySendingModeStatusDate(
          hcPartyId,
          sendingMode,
          status,
          from,
          to,
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
      invoiceString: String,
      optionsString: String,
    ) {
      val delegateId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        delegateIdString
      )
      val invoice = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Invoice::class),
        invoiceString
      )
      val options = fullLanguageInteropJson.decodeFromString(
        InvoiceShareOptions.serializer().nullable,
        optionsString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Invoice::class)) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.tryAndRecover.shareWith(
          delegateId,
          invoice,
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
      invoiceString: String,
      delegatesString: String,
    ) {
      val invoice = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Invoice::class),
        invoiceString
      )
      val delegates = fullLanguageInteropJson.decodeFromString(
        MapSerializer(String.serializer(), InvoiceShareOptions.serializer()),
        delegatesString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Invoice::class)) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.tryAndRecover.shareWithMany(
          invoice,
          delegates,
        )
      }
    }

    public fun modifyInvoice(
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
        PolymorphicSerializer(Invoice::class),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Invoice::class)) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.tryAndRecover.modifyInvoice(
          entity,
        )
      }
    }

    public fun modifyInvoices(
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
        ListSerializer(PolymorphicSerializer(Invoice::class)),
        entitiesString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(PolymorphicSerializer(Invoice::class))) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.tryAndRecover.modifyInvoices(
          entities,
        )
      }
    }

    public fun getInvoice(
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
        PolymorphicSerializer(Invoice::class).nullable) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.tryAndRecover.getInvoice(
          entityId,
        )
      }
    }

    public fun getInvoices(
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
        ListSerializer(PolymorphicSerializer(Invoice::class))) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.tryAndRecover.getInvoices(
          entityIds,
        )
      }
    }

    public fun reassignInvoice(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      invoiceString: String,
    ) {
      val invoice = fullLanguageInteropJson.decodeFromString(
        PolymorphicSerializer(Invoice::class),
        invoiceString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Invoice::class)) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.tryAndRecover.reassignInvoice(
          invoice,
        )
      }
    }

    public fun mergeTo(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      invoiceIdString: String,
      idsString: String,
    ) {
      val invoiceId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        invoiceIdString
      )
      val ids = fullLanguageInteropJson.decodeFromString(
        ListSerializer(String.serializer()),
        idsString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Invoice::class)) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.tryAndRecover.mergeTo(
          invoiceId,
          ids,
        )
      }
    }

    public fun validate(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      invoiceIdString: String,
      schemeString: String,
      forcedValueString: String,
    ) {
      val invoiceId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        invoiceIdString
      )
      val scheme = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        schemeString
      )
      val forcedValue = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        forcedValueString
      )
      ApiScope.execute(
        dartResultCallback,
        PolymorphicSerializer(Invoice::class)) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.tryAndRecover.validate(
          invoiceId,
          scheme,
          forcedValue,
        )
      }
    }

    public fun appendCodes(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      userIdString: String,
      typeString: String,
      sentMediumTypeString: String,
      secretFKeysString: String,
      insuranceIdString: String,
      invoiceIdString: String,
      gracePeriodString: String,
      invoicingCodesString: String,
    ) {
      val userId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        userIdString
      )
      val type = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        typeString
      )
      val sentMediumType = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        sentMediumTypeString
      )
      val secretFKeys = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        secretFKeysString
      )
      val insuranceId = fullLanguageInteropJson.decodeFromString(
        String.serializer().nullable,
        insuranceIdString
      )
      val invoiceId = fullLanguageInteropJson.decodeFromString(
        String.serializer().nullable,
        invoiceIdString
      )
      val gracePeriod = fullLanguageInteropJson.decodeFromString(
        Int.serializer().nullable,
        gracePeriodString
      )
      val invoicingCodes = fullLanguageInteropJson.decodeFromString(
        ListSerializer(EncryptedInvoicingCode.serializer()),
        invoicingCodesString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(PolymorphicSerializer(Invoice::class))) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.tryAndRecover.appendCodes(
          userId,
          type,
          sentMediumType,
          secretFKeys,
          insuranceId,
          invoiceId,
          gracePeriod,
          invoicingCodes,
        )
      }
    }

    public fun removeCodes(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      userIdString: String,
      serviceIdString: String,
      secretFKeysString: String,
      tarificationIdsString: String,
    ) {
      val userId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        userIdString
      )
      val serviceId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        serviceIdString
      )
      val secretFKeys = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        secretFKeysString
      )
      val tarificationIds = fullLanguageInteropJson.decodeFromString(
        ListSerializer(String.serializer()),
        tarificationIdsString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(PolymorphicSerializer(Invoice::class))) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.tryAndRecover.removeCodes(
          userId,
          serviceId,
          secretFKeys,
          tarificationIds,
        )
      }
    }

    public fun listInvoicesByHcPartyAndGroupId(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      hcPartyIdString: String,
      groupIdString: String,
    ) {
      val hcPartyId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        hcPartyIdString
      )
      val groupId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        groupIdString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(PolymorphicSerializer(Invoice::class))) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.tryAndRecover.listInvoicesByHcPartyAndGroupId(
          hcPartyId,
          groupId,
        )
      }
    }

    public fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      hcPartyIdString: String,
      sentMediumTypeString: String,
      invoiceTypeString: String,
      sentString: String,
      fromString: String,
      toString: String,
    ) {
      val hcPartyId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        hcPartyIdString
      )
      val sentMediumType = fullLanguageInteropJson.decodeFromString(
        MediumType.serializer(),
        sentMediumTypeString
      )
      val invoiceType = fullLanguageInteropJson.decodeFromString(
        InvoiceType.serializer(),
        invoiceTypeString
      )
      val sent = fullLanguageInteropJson.decodeFromString(
        Boolean.serializer(),
        sentString
      )
      val from = fullLanguageInteropJson.decodeFromString(
        Long.serializer().nullable,
        fromString
      )
      val to = fullLanguageInteropJson.decodeFromString(
        Long.serializer().nullable,
        toString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(PolymorphicSerializer(Invoice::class))) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.tryAndRecover.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
          hcPartyId,
          sentMediumType,
          invoiceType,
          sent,
          from,
          to,
        )
      }
    }

    public fun listInvoicesByContactIds(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      contactIdsString: String,
    ) {
      val contactIds = fullLanguageInteropJson.decodeFromString(
        ListSerializer(String.serializer()),
        contactIdsString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(PolymorphicSerializer(Invoice::class))) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.tryAndRecover.listInvoicesByContactIds(
          contactIds,
        )
      }
    }

    public fun listInvoicesByRecipientsIds(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      recipientsIdsString: String,
    ) {
      val recipientsIds = fullLanguageInteropJson.decodeFromString(
        ListSerializer(String.serializer()),
        recipientsIdsString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(PolymorphicSerializer(Invoice::class))) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.tryAndRecover.listInvoicesByRecipientsIds(
          recipientsIds,
        )
      }
    }

    public fun listToInsurances(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      userIdsString: String,
    ) {
      val userIds = fullLanguageInteropJson.decodeFromString(
        ListSerializer(String.serializer()),
        userIdsString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(PolymorphicSerializer(Invoice::class))) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.tryAndRecover.listToInsurances(
          userIds,
        )
      }
    }

    public fun listToInsurancesUnsent(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      userIdsString: String,
    ) {
      val userIds = fullLanguageInteropJson.decodeFromString(
        ListSerializer(String.serializer()),
        userIdsString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(PolymorphicSerializer(Invoice::class))) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.tryAndRecover.listToInsurancesUnsent(
          userIds,
        )
      }
    }

    public fun listToPatients(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      hcPartyIdString: String,
    ) {
      val hcPartyId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        hcPartyIdString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(PolymorphicSerializer(Invoice::class))) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.tryAndRecover.listToPatients(
          hcPartyId,
        )
      }
    }

    public fun listToPatientsUnsent(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      hcPartyIdString: String,
    ) {
      val hcPartyId = fullLanguageInteropJson.decodeFromString(
        String.serializer().nullable,
        hcPartyIdString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(PolymorphicSerializer(Invoice::class))) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.tryAndRecover.listToPatientsUnsent(
          hcPartyId,
        )
      }
    }

    public fun listInvoicesByIds(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      idsString: String,
    ) {
      val ids = fullLanguageInteropJson.decodeFromString(
        ListSerializer(String.serializer()),
        idsString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(PolymorphicSerializer(Invoice::class))) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.tryAndRecover.listInvoicesByIds(
          ids,
        )
      }
    }

    public fun listInvoicesByHcpartySendingModeStatusDate(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      hcPartyIdString: String,
      sendingModeString: String,
      statusString: String,
      fromString: String,
      toString: String,
    ) {
      val hcPartyId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        hcPartyIdString
      )
      val sendingMode = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        sendingModeString
      )
      val status = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        statusString
      )
      val from = fullLanguageInteropJson.decodeFromString(
        Long.serializer(),
        fromString
      )
      val to = fullLanguageInteropJson.decodeFromString(
        Long.serializer(),
        toString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(PolymorphicSerializer(Invoice::class))) {
        NativeReferences.get<CardinalApis>(sdkId).invoice.tryAndRecover.listInvoicesByHcpartySendingModeStatusDate(
          hcPartyId,
          sendingMode,
          status,
          from,
          to,
        )
      }
    }
  }
}
