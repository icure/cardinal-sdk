// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.HealthcarePartyApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object HealthcarePartyApiDispatcher {
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
    "getHealthcareParty" -> getHealthcareParty(parameters, resultCallback)
    "createHealthcareParty" -> createHealthcareParty(parameters, resultCallback)
    "modifyHealthcarePartyInGroup" -> modifyHealthcarePartyInGroup(parameters, resultCallback)
    "createHealthcarePartyInGroup" -> createHealthcarePartyInGroup(parameters, resultCallback)
    "getCurrentHealthcareParty" -> getCurrentHealthcareParty(parameters, resultCallback)
    "listHealthcarePartiesByName" -> listHealthcarePartiesByName(parameters, resultCallback)
    "getHealthcareParties" -> getHealthcareParties(parameters, resultCallback)
    "listHealthcarePartiesByParentId" -> listHealthcarePartiesByParentId(parameters, resultCallback)
    "getPublicKey" -> getPublicKey(parameters, resultCallback)
    "modifyHealthcareParty" -> modifyHealthcareParty(parameters, resultCallback)
    "matchHealthcarePartiesBy" -> matchHealthcarePartiesBy(parameters, resultCallback)
    "filterHealthPartiesBy" -> filterHealthPartiesBy(parameters, resultCallback)
    "matchHealthcarePartiesBySorted" -> matchHealthcarePartiesBySorted(parameters, resultCallback)
    "filterHealthPartiesBySorted" -> filterHealthPartiesBySorted(parameters, resultCallback)
    "getHealthcarePartiesInGroup" -> getHealthcarePartiesInGroup(parameters, resultCallback)
    "registerPatient" -> registerPatient(parameters, resultCallback)
    "deleteHealthcarePartyById" -> deleteHealthcarePartyById(parameters, resultCallback)
    "deleteHealthcarePartiesByIds" -> deleteHealthcarePartiesByIds(parameters, resultCallback)
    "deleteHealthcarePartyInGroupById" -> deleteHealthcarePartyInGroupById(parameters, resultCallback)
    "deleteHealthcarePartiesInGroupByIds" -> deleteHealthcarePartiesInGroupByIds(parameters, resultCallback)
    "purgeHealthcarePartyById" -> purgeHealthcarePartyById(parameters, resultCallback)
    "undeleteHealthcarePartyById" -> undeleteHealthcarePartyById(parameters, resultCallback)
    "deleteHealthcareParty" -> deleteHealthcareParty(parameters, resultCallback)
    "deleteHealthcareParties" -> deleteHealthcareParties(parameters, resultCallback)
    "purgeHealthcareParty" -> purgeHealthcareParty(parameters, resultCallback)
    "undeleteHealthcareParty" -> undeleteHealthcareParty(parameters, resultCallback)
    "deleteHealthcarePartyInGroup" -> deleteHealthcarePartyInGroup(parameters, resultCallback)
    "deleteHealthcarePartiesInGroup" -> deleteHealthcarePartiesInGroup(parameters, resultCallback)
    "subscribeToEvents" -> subscribeToEvents(parameters, resultCallback)
    "inGroup.matchHealthcarePartiesBy" -> inGroup_matchHealthcarePartiesBy(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun getHealthcareParty(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyApi.getHealthcareParty(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("healthcarePartyId"),
    )
  }

  private fun createHealthcareParty(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyApi.createHealthcareParty(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("p"),
    )
  }

  private fun modifyHealthcarePartyInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyApi.modifyHealthcarePartyInGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("healthcareParty"),
    )
  }

  private fun createHealthcarePartyInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyApi.createHealthcarePartyInGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("healthcareParty"),
    )
  }

  private fun getCurrentHealthcareParty(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyApi.getCurrentHealthcareParty(
      resultCallback,
      parameters.getValue("sdkId"),
    )
  }

  private fun listHealthcarePartiesByName(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyApi.listHealthcarePartiesByName(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("name"),
    )
  }

  private fun getHealthcareParties(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyApi.getHealthcareParties(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("healthcarePartyIds"),
    )
  }

  private fun listHealthcarePartiesByParentId(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyApi.listHealthcarePartiesByParentId(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("parentId"),
    )
  }

  private fun getPublicKey(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyApi.getPublicKey(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("healthcarePartyId"),
    )
  }

  private fun modifyHealthcareParty(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyApi.modifyHealthcareParty(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("healthcareParty"),
    )
  }

  private fun matchHealthcarePartiesBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyApi.matchHealthcarePartiesBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterHealthPartiesBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyApi.filterHealthPartiesBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchHealthcarePartiesBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyApi.matchHealthcarePartiesBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterHealthPartiesBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyApi.filterHealthPartiesBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun getHealthcarePartiesInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyApi.getHealthcarePartiesInGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("healthcarePartyIds"),
    )
  }

  private fun registerPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyApi.registerPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("parentHcPartyId"),
      parameters.getValue("token"),
      parameters.getValue("useShortToken"),
      parameters.getValue("hcp"),
    )
  }

  private fun deleteHealthcarePartyById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyApi.deleteHealthcarePartyById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteHealthcarePartiesByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyApi.deleteHealthcarePartiesByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun deleteHealthcarePartyInGroupById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyApi.deleteHealthcarePartyInGroupById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("entityId"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteHealthcarePartiesInGroupByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyApi.deleteHealthcarePartiesInGroupByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun purgeHealthcarePartyById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyApi.purgeHealthcarePartyById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun undeleteHealthcarePartyById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyApi.undeleteHealthcarePartyById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteHealthcareParty(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyApi.deleteHealthcareParty(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("healthcareParty"),
    )
  }

  private fun deleteHealthcareParties(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyApi.deleteHealthcareParties(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("healthcareParties"),
    )
  }

  private fun purgeHealthcareParty(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyApi.purgeHealthcareParty(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("healthcareParty"),
    )
  }

  private fun undeleteHealthcareParty(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyApi.undeleteHealthcareParty(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("healthcareParty"),
    )
  }

  private fun deleteHealthcarePartyInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyApi.deleteHealthcarePartyInGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("hcp"),
    )
  }

  private fun deleteHealthcarePartiesInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyApi.deleteHealthcarePartiesInGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("healthcareParties"),
    )
  }

  private fun subscribeToEvents(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyApi.subscribeToEvents(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("events"),
      parameters.getValue("filter"),
      parameters.getValue("subscriptionConfig"),
    )
  }

  private fun inGroup_matchHealthcarePartiesBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyApi.inGroup.matchHealthcarePartiesBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("filter"),
    )
  }
}
