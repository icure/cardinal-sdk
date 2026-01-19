// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.PatientApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object PatientApiDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "decrypt" -> decrypt(parameters, resultCallback)
    "tryDecrypt" -> tryDecrypt(parameters, resultCallback)
    "encryptOrValidate" -> encryptOrValidate(parameters, resultCallback)
    "getSecretIdsOf" -> getSecretIdsOf(parameters, resultCallback)
    "getEncryptionKeysOf" -> getEncryptionKeysOf(parameters, resultCallback)
    "withEncryptionMetadata" -> withEncryptionMetadata(parameters, resultCallback)
    "hasWriteAccess" -> hasWriteAccess(parameters, resultCallback)
    "createDelegationDeAnonymizationMetadata" -> createDelegationDeAnonymizationMetadata(parameters, resultCallback)
    "shareAllDataOfPatient" -> shareAllDataOfPatient(parameters, resultCallback)
    "getConfidentialSecretIdsOf" -> getConfidentialSecretIdsOf(parameters, resultCallback)
    "forceInitializeExchangeDataToNewlyInvitedPatient" -> forceInitializeExchangeDataToNewlyInvitedPatient(parameters, resultCallback)
    "matchPatientsBy" -> matchPatientsBy(parameters, resultCallback)
    "matchPatientsBySorted" -> matchPatientsBySorted(parameters, resultCallback)
    "ensureEncryptionMetadataForSelfIsInitialized" -> ensureEncryptionMetadataForSelfIsInitialized(parameters, resultCallback)
    "deletePatientById" -> deletePatientById(parameters, resultCallback)
    "deletePatientsByIds" -> deletePatientsByIds(parameters, resultCallback)
    "purgePatientById" -> purgePatientById(parameters, resultCallback)
    "deletePatient" -> deletePatient(parameters, resultCallback)
    "deletePatients" -> deletePatients(parameters, resultCallback)
    "purgePatient" -> purgePatient(parameters, resultCallback)
    "getDataOwnersWithAccessTo" -> getDataOwnersWithAccessTo(parameters, resultCallback)
    "shareWith" -> shareWith(parameters, resultCallback)
    "shareWithMany" -> shareWithMany(parameters, resultCallback)
    "initializeConfidentialSecretId" -> initializeConfidentialSecretId(parameters, resultCallback)
    "filterPatientsBy" -> filterPatientsBy(parameters, resultCallback)
    "filterPatientsBySorted" -> filterPatientsBySorted(parameters, resultCallback)
    "createPatient" -> createPatient(parameters, resultCallback)
    "createPatientsMinimal" -> createPatientsMinimal(parameters, resultCallback)
    "createPatients" -> createPatients(parameters, resultCallback)
    "undeletePatient" -> undeletePatient(parameters, resultCallback)
    "modifyPatient" -> modifyPatient(parameters, resultCallback)
    "undeletePatientById" -> undeletePatientById(parameters, resultCallback)
    "undeletePatients" -> undeletePatients(parameters, resultCallback)
    "getPatient" -> getPatient(parameters, resultCallback)
    "getPatientResolvingMerges" -> getPatientResolvingMerges(parameters, resultCallback)
    "getPatients" -> getPatients(parameters, resultCallback)
    "modifyPatientsMinimal" -> modifyPatientsMinimal(parameters, resultCallback)
    "modifyPatients" -> modifyPatients(parameters, resultCallback)
    "mergePatients" -> mergePatients(parameters, resultCallback)
    "subscribeToEvents" -> subscribeToEvents(parameters, resultCallback)
    "encrypted.shareWith" -> encrypted_shareWith(parameters, resultCallback)
    "encrypted.shareWithMany" -> encrypted_shareWithMany(parameters, resultCallback)
    "encrypted.initializeConfidentialSecretId" -> encrypted_initializeConfidentialSecretId(parameters, resultCallback)
    "encrypted.filterPatientsBy" -> encrypted_filterPatientsBy(parameters, resultCallback)
    "encrypted.filterPatientsBySorted" -> encrypted_filterPatientsBySorted(parameters, resultCallback)
    "encrypted.createPatient" -> encrypted_createPatient(parameters, resultCallback)
    "encrypted.createPatientsMinimal" -> encrypted_createPatientsMinimal(parameters, resultCallback)
    "encrypted.createPatients" -> encrypted_createPatients(parameters, resultCallback)
    "encrypted.undeletePatient" -> encrypted_undeletePatient(parameters, resultCallback)
    "encrypted.modifyPatient" -> encrypted_modifyPatient(parameters, resultCallback)
    "encrypted.undeletePatientById" -> encrypted_undeletePatientById(parameters, resultCallback)
    "encrypted.undeletePatients" -> encrypted_undeletePatients(parameters, resultCallback)
    "encrypted.getPatient" -> encrypted_getPatient(parameters, resultCallback)
    "encrypted.getPatientResolvingMerges" -> encrypted_getPatientResolvingMerges(parameters, resultCallback)
    "encrypted.getPatients" -> encrypted_getPatients(parameters, resultCallback)
    "encrypted.modifyPatientsMinimal" -> encrypted_modifyPatientsMinimal(parameters, resultCallback)
    "encrypted.modifyPatients" -> encrypted_modifyPatients(parameters, resultCallback)
    "encrypted.mergePatients" -> encrypted_mergePatients(parameters, resultCallback)
    "tryAndRecover.shareWith" -> tryAndRecover_shareWith(parameters, resultCallback)
    "tryAndRecover.shareWithMany" -> tryAndRecover_shareWithMany(parameters, resultCallback)
    "tryAndRecover.initializeConfidentialSecretId" -> tryAndRecover_initializeConfidentialSecretId(parameters, resultCallback)
    "tryAndRecover.filterPatientsBy" -> tryAndRecover_filterPatientsBy(parameters, resultCallback)
    "tryAndRecover.filterPatientsBySorted" -> tryAndRecover_filterPatientsBySorted(parameters, resultCallback)
    "tryAndRecover.createPatient" -> tryAndRecover_createPatient(parameters, resultCallback)
    "tryAndRecover.createPatientsMinimal" -> tryAndRecover_createPatientsMinimal(parameters, resultCallback)
    "tryAndRecover.createPatients" -> tryAndRecover_createPatients(parameters, resultCallback)
    "tryAndRecover.undeletePatient" -> tryAndRecover_undeletePatient(parameters, resultCallback)
    "tryAndRecover.modifyPatient" -> tryAndRecover_modifyPatient(parameters, resultCallback)
    "tryAndRecover.undeletePatientById" -> tryAndRecover_undeletePatientById(parameters, resultCallback)
    "tryAndRecover.undeletePatients" -> tryAndRecover_undeletePatients(parameters, resultCallback)
    "tryAndRecover.getPatient" -> tryAndRecover_getPatient(parameters, resultCallback)
    "tryAndRecover.getPatientResolvingMerges" -> tryAndRecover_getPatientResolvingMerges(parameters, resultCallback)
    "tryAndRecover.getPatients" -> tryAndRecover_getPatients(parameters, resultCallback)
    "tryAndRecover.modifyPatientsMinimal" -> tryAndRecover_modifyPatientsMinimal(parameters, resultCallback)
    "tryAndRecover.modifyPatients" -> tryAndRecover_modifyPatients(parameters, resultCallback)
    "tryAndRecover.mergePatients" -> tryAndRecover_mergePatients(parameters, resultCallback)
    "inGroup.decrypt" -> inGroup_decrypt(parameters, resultCallback)
    "inGroup.tryDecrypt" -> inGroup_tryDecrypt(parameters, resultCallback)
    "inGroup.encryptOrValidate" -> inGroup_encryptOrValidate(parameters, resultCallback)
    "inGroup.getSecretIdsOf" -> inGroup_getSecretIdsOf(parameters, resultCallback)
    "inGroup.getEncryptionKeysOf" -> inGroup_getEncryptionKeysOf(parameters, resultCallback)
    "inGroup.withEncryptionMetadata" -> inGroup_withEncryptionMetadata(parameters, resultCallback)
    "inGroup.hasWriteAccess" -> inGroup_hasWriteAccess(parameters, resultCallback)
    "inGroup.createDelegationDeAnonymizationMetadata" -> inGroup_createDelegationDeAnonymizationMetadata(parameters, resultCallback)
    "inGroup.matchPatientsBy" -> inGroup_matchPatientsBy(parameters, resultCallback)
    "inGroup.matchPatientsBySorted" -> inGroup_matchPatientsBySorted(parameters, resultCallback)
    "inGroup.getDataOwnersWithAccessTo" -> inGroup_getDataOwnersWithAccessTo(parameters, resultCallback)
    "inGroup.shareWith" -> inGroup_shareWith(parameters, resultCallback)
    "inGroup.shareWithMany" -> inGroup_shareWithMany(parameters, resultCallback)
    "inGroup.initializeConfidentialSecretId" -> inGroup_initializeConfidentialSecretId(parameters, resultCallback)
    "inGroup.filterPatientsBy" -> inGroup_filterPatientsBy(parameters, resultCallback)
    "inGroup.filterPatientsBySorted" -> inGroup_filterPatientsBySorted(parameters, resultCallback)
    "inGroup.createPatient" -> inGroup_createPatient(parameters, resultCallback)
    "inGroup.createPatientsMinimal" -> inGroup_createPatientsMinimal(parameters, resultCallback)
    "inGroup.createPatients" -> inGroup_createPatients(parameters, resultCallback)
    "inGroup.getPatient" -> inGroup_getPatient(parameters, resultCallback)
    "inGroup.getPatientResolvingMerges" -> inGroup_getPatientResolvingMerges(parameters, resultCallback)
    "inGroup.getPatients" -> inGroup_getPatients(parameters, resultCallback)
    "inGroup.modifyPatientsMinimal" -> inGroup_modifyPatientsMinimal(parameters, resultCallback)
    "inGroup.modifyPatients" -> inGroup_modifyPatients(parameters, resultCallback)
    "inGroup.encrypted.shareWith" -> inGroup_encrypted_shareWith(parameters, resultCallback)
    "inGroup.encrypted.shareWithMany" -> inGroup_encrypted_shareWithMany(parameters, resultCallback)
    "inGroup.encrypted.initializeConfidentialSecretId" -> inGroup_encrypted_initializeConfidentialSecretId(parameters, resultCallback)
    "inGroup.encrypted.filterPatientsBy" -> inGroup_encrypted_filterPatientsBy(parameters, resultCallback)
    "inGroup.encrypted.filterPatientsBySorted" -> inGroup_encrypted_filterPatientsBySorted(parameters, resultCallback)
    "inGroup.encrypted.createPatient" -> inGroup_encrypted_createPatient(parameters, resultCallback)
    "inGroup.encrypted.createPatientsMinimal" -> inGroup_encrypted_createPatientsMinimal(parameters, resultCallback)
    "inGroup.encrypted.createPatients" -> inGroup_encrypted_createPatients(parameters, resultCallback)
    "inGroup.encrypted.getPatient" -> inGroup_encrypted_getPatient(parameters, resultCallback)
    "inGroup.encrypted.getPatientResolvingMerges" -> inGroup_encrypted_getPatientResolvingMerges(parameters, resultCallback)
    "inGroup.encrypted.getPatients" -> inGroup_encrypted_getPatients(parameters, resultCallback)
    "inGroup.encrypted.modifyPatientsMinimal" -> inGroup_encrypted_modifyPatientsMinimal(parameters, resultCallback)
    "inGroup.encrypted.modifyPatients" -> inGroup_encrypted_modifyPatients(parameters, resultCallback)
    "inGroup.tryAndRecover.shareWith" -> inGroup_tryAndRecover_shareWith(parameters, resultCallback)
    "inGroup.tryAndRecover.shareWithMany" -> inGroup_tryAndRecover_shareWithMany(parameters, resultCallback)
    "inGroup.tryAndRecover.initializeConfidentialSecretId" -> inGroup_tryAndRecover_initializeConfidentialSecretId(parameters, resultCallback)
    "inGroup.tryAndRecover.filterPatientsBy" -> inGroup_tryAndRecover_filterPatientsBy(parameters, resultCallback)
    "inGroup.tryAndRecover.filterPatientsBySorted" -> inGroup_tryAndRecover_filterPatientsBySorted(parameters, resultCallback)
    "inGroup.tryAndRecover.createPatient" -> inGroup_tryAndRecover_createPatient(parameters, resultCallback)
    "inGroup.tryAndRecover.createPatientsMinimal" -> inGroup_tryAndRecover_createPatientsMinimal(parameters, resultCallback)
    "inGroup.tryAndRecover.createPatients" -> inGroup_tryAndRecover_createPatients(parameters, resultCallback)
    "inGroup.tryAndRecover.getPatient" -> inGroup_tryAndRecover_getPatient(parameters, resultCallback)
    "inGroup.tryAndRecover.getPatientResolvingMerges" -> inGroup_tryAndRecover_getPatientResolvingMerges(parameters, resultCallback)
    "inGroup.tryAndRecover.getPatients" -> inGroup_tryAndRecover_getPatients(parameters, resultCallback)
    "inGroup.tryAndRecover.modifyPatientsMinimal" -> inGroup_tryAndRecover_modifyPatientsMinimal(parameters, resultCallback)
    "inGroup.tryAndRecover.modifyPatients" -> inGroup_tryAndRecover_modifyPatients(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun decrypt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.decrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun tryDecrypt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryDecrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun encryptOrValidate(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encryptOrValidate(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun getSecretIdsOf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.getSecretIdsOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun getEncryptionKeysOf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.getEncryptionKeysOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun withEncryptionMetadata(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.withEncryptionMetadata(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("base"),
      parameters.getValue("user"),
      parameters.getValue("delegates"),
      parameters.getValue("alternateRootDelegateId"),
    )
  }

  private fun hasWriteAccess(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.hasWriteAccess(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun createDelegationDeAnonymizationMetadata(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.createDelegationDeAnonymizationMetadata(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
      parameters.getValue("delegates"),
    )
  }

  private fun shareAllDataOfPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.shareAllDataOfPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patientId"),
      parameters.getValue("delegatesWithShareType"),
    )
  }

  private fun getConfidentialSecretIdsOf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.getConfidentialSecretIdsOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun forceInitializeExchangeDataToNewlyInvitedPatient(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.forceInitializeExchangeDataToNewlyInvitedPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patientId"),
    )
  }

  private fun matchPatientsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.matchPatientsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchPatientsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.matchPatientsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun ensureEncryptionMetadataForSelfIsInitialized(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.ensureEncryptionMetadataForSelfIsInitialized(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("sharingWith"),
      parameters.getValue("ignoreIfEncryptionMetadataExists"),
      parameters.getValue("alternateRootDelegateId"),
    )
  }

  private fun deletePatientById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.deletePatientById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("rev"),
    )
  }

  private fun deletePatientsByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.deletePatientsByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun purgePatientById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.purgePatientById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun deletePatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.deletePatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun deletePatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.deletePatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun purgePatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.purgePatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun getDataOwnersWithAccessTo(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.getDataOwnersWithAccessTo(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("patient"),
      parameters.getValue("options"),
    )
  }

  private fun shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
      parameters.getValue("delegates"),
    )
  }

  private fun initializeConfidentialSecretId(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.initializeConfidentialSecretId(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun filterPatientsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.filterPatientsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterPatientsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.filterPatientsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun createPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.createPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun createPatientsMinimal(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.createPatientsMinimal(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun createPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.createPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun undeletePatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.undeletePatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun modifyPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.modifyPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun undeletePatientById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.undeletePatientById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun undeletePatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.undeletePatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("ids"),
    )
  }

  private fun getPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.getPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun getPatientResolvingMerges(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.getPatientResolvingMerges(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patientId"),
      parameters.getValue("maxMergeDepth"),
    )
  }

  private fun getPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.getPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patientIds"),
    )
  }

  private fun modifyPatientsMinimal(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.modifyPatientsMinimal(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun modifyPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.modifyPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun mergePatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.mergePatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("from"),
      parameters.getValue("mergedInto"),
    )
  }

  private fun subscribeToEvents(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.subscribeToEvents(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("events"),
      parameters.getValue("filter"),
      parameters.getValue("subscriptionConfig"),
    )
  }

  private fun encrypted_shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encrypted.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("patient"),
      parameters.getValue("options"),
    )
  }

  private fun encrypted_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encrypted.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
      parameters.getValue("delegates"),
    )
  }

  private fun encrypted_initializeConfidentialSecretId(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encrypted.initializeConfidentialSecretId(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun encrypted_filterPatientsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encrypted.filterPatientsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun encrypted_filterPatientsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encrypted.filterPatientsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun encrypted_createPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encrypted.createPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun encrypted_createPatientsMinimal(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encrypted.createPatientsMinimal(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun encrypted_createPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encrypted.createPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun encrypted_undeletePatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encrypted.undeletePatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun encrypted_modifyPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encrypted.modifyPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun encrypted_undeletePatientById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encrypted.undeletePatientById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun encrypted_undeletePatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encrypted.undeletePatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("ids"),
    )
  }

  private fun encrypted_getPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encrypted.getPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun encrypted_getPatientResolvingMerges(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encrypted.getPatientResolvingMerges(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patientId"),
      parameters.getValue("maxMergeDepth"),
    )
  }

  private fun encrypted_getPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encrypted.getPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patientIds"),
    )
  }

  private fun encrypted_modifyPatientsMinimal(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encrypted.modifyPatientsMinimal(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun encrypted_modifyPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encrypted.modifyPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun encrypted_mergePatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encrypted.mergePatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("from"),
      parameters.getValue("mergedInto"),
    )
  }

  private fun tryAndRecover_shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("patient"),
      parameters.getValue("options"),
    )
  }

  private fun tryAndRecover_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
      parameters.getValue("delegates"),
    )
  }

  private fun tryAndRecover_initializeConfidentialSecretId(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.initializeConfidentialSecretId(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun tryAndRecover_filterPatientsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.filterPatientsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun tryAndRecover_filterPatientsBySorted(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.filterPatientsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun tryAndRecover_createPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.createPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun tryAndRecover_createPatientsMinimal(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.createPatientsMinimal(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun tryAndRecover_createPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.createPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun tryAndRecover_undeletePatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.undeletePatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun tryAndRecover_modifyPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.modifyPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun tryAndRecover_undeletePatientById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.undeletePatientById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun tryAndRecover_undeletePatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.undeletePatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("ids"),
    )
  }

  private fun tryAndRecover_getPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.getPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun tryAndRecover_getPatientResolvingMerges(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.getPatientResolvingMerges(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patientId"),
      parameters.getValue("maxMergeDepth"),
    )
  }

  private fun tryAndRecover_getPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.getPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patientIds"),
    )
  }

  private fun tryAndRecover_modifyPatientsMinimal(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.modifyPatientsMinimal(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun tryAndRecover_modifyPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.modifyPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun tryAndRecover_mergePatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.mergePatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("from"),
      parameters.getValue("mergedInto"),
    )
  }

  private fun inGroup_decrypt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.decrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun inGroup_tryDecrypt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.tryDecrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun inGroup_encryptOrValidate(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.encryptOrValidate(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun inGroup_getSecretIdsOf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.getSecretIdsOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun inGroup_getEncryptionKeysOf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.getEncryptionKeysOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun inGroup_withEncryptionMetadata(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.withEncryptionMetadata(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityGroupId"),
      parameters.getValue("base"),
      parameters.getValue("user"),
      parameters.getValue("delegates"),
      parameters.getValue("alternateRootDelegateReference"),
    )
  }

  private fun inGroup_hasWriteAccess(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.hasWriteAccess(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun inGroup_createDelegationDeAnonymizationMetadata(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.createDelegationDeAnonymizationMetadata(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
      parameters.getValue("delegates"),
    )
  }

  private fun inGroup_matchPatientsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.matchPatientsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("filter"),
    )
  }

  private fun inGroup_matchPatientsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.matchPatientsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("filter"),
    )
  }

  private fun inGroup_getDataOwnersWithAccessTo(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.getDataOwnersWithAccessTo(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun inGroup_shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegate"),
      parameters.getValue("patient"),
      parameters.getValue("options"),
    )
  }

  private fun inGroup_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
      parameters.getValue("delegates"),
    )
  }

  private fun inGroup_initializeConfidentialSecretId(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.initializeConfidentialSecretId(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun inGroup_filterPatientsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.filterPatientsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("filter"),
    )
  }

  private fun inGroup_filterPatientsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.filterPatientsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("filter"),
    )
  }

  private fun inGroup_createPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.createPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun inGroup_createPatientsMinimal(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.createPatientsMinimal(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun inGroup_createPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.createPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun inGroup_getPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.getPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("entityId"),
    )
  }

  private fun inGroup_getPatientResolvingMerges(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.getPatientResolvingMerges(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("patientId"),
      parameters.getValue("maxMergeDepth"),
    )
  }

  private fun inGroup_getPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.getPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("patientIds"),
    )
  }

  private fun inGroup_modifyPatientsMinimal(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.modifyPatientsMinimal(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun inGroup_modifyPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.modifyPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun inGroup_encrypted_shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.encrypted.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegate"),
      parameters.getValue("patient"),
      parameters.getValue("options"),
    )
  }

  private fun inGroup_encrypted_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.encrypted.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
      parameters.getValue("delegates"),
    )
  }

  private fun inGroup_encrypted_initializeConfidentialSecretId(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.encrypted.initializeConfidentialSecretId(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun inGroup_encrypted_filterPatientsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.encrypted.filterPatientsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("filter"),
    )
  }

  private fun inGroup_encrypted_filterPatientsBySorted(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.encrypted.filterPatientsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("filter"),
    )
  }

  private fun inGroup_encrypted_createPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.encrypted.createPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun inGroup_encrypted_createPatientsMinimal(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.encrypted.createPatientsMinimal(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun inGroup_encrypted_createPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.encrypted.createPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun inGroup_encrypted_getPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.encrypted.getPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("entityId"),
    )
  }

  private fun inGroup_encrypted_getPatientResolvingMerges(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.encrypted.getPatientResolvingMerges(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("patientId"),
      parameters.getValue("maxMergeDepth"),
    )
  }

  private fun inGroup_encrypted_getPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.encrypted.getPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("patientIds"),
    )
  }

  private fun inGroup_encrypted_modifyPatientsMinimal(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.encrypted.modifyPatientsMinimal(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun inGroup_encrypted_modifyPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.encrypted.modifyPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun inGroup_tryAndRecover_shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.tryAndRecover.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegate"),
      parameters.getValue("patient"),
      parameters.getValue("options"),
    )
  }

  private fun inGroup_tryAndRecover_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.tryAndRecover.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
      parameters.getValue("delegates"),
    )
  }

  private fun inGroup_tryAndRecover_initializeConfidentialSecretId(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.tryAndRecover.initializeConfidentialSecretId(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun inGroup_tryAndRecover_filterPatientsBy(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.tryAndRecover.filterPatientsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("filter"),
    )
  }

  private fun inGroup_tryAndRecover_filterPatientsBySorted(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.tryAndRecover.filterPatientsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("filter"),
    )
  }

  private fun inGroup_tryAndRecover_createPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.tryAndRecover.createPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun inGroup_tryAndRecover_createPatientsMinimal(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.tryAndRecover.createPatientsMinimal(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun inGroup_tryAndRecover_createPatients(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.tryAndRecover.createPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun inGroup_tryAndRecover_getPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.tryAndRecover.getPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("entityId"),
    )
  }

  private fun inGroup_tryAndRecover_getPatientResolvingMerges(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.tryAndRecover.getPatientResolvingMerges(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("patientId"),
      parameters.getValue("maxMergeDepth"),
    )
  }

  private fun inGroup_tryAndRecover_getPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.tryAndRecover.getPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("patientIds"),
    )
  }

  private fun inGroup_tryAndRecover_modifyPatientsMinimal(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.tryAndRecover.modifyPatientsMinimal(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun inGroup_tryAndRecover_modifyPatients(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.inGroup.tryAndRecover.modifyPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }
}
