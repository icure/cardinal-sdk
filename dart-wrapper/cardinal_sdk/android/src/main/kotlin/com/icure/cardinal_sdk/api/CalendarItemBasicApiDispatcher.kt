// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.CalendarItemBasicApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object CalendarItemBasicApiDispatcher {
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
    "matchCalendarItemsBy" -> matchCalendarItemsBy(parameters, resultCallback)
    "matchCalendarItemsBySorted" -> matchCalendarItemsBySorted(parameters, resultCallback)
    "filterCalendarItemsBy" -> filterCalendarItemsBy(parameters, resultCallback)
    "filterCalendarItemsBySorted" -> filterCalendarItemsBySorted(parameters, resultCallback)
    "deleteCalendarItemById" -> deleteCalendarItemById(parameters, resultCallback)
    "deleteCalendarItemsByIds" -> deleteCalendarItemsByIds(parameters, resultCallback)
    "purgeCalendarItemById" -> purgeCalendarItemById(parameters, resultCallback)
    "deleteCalendarItem" -> deleteCalendarItem(parameters, resultCallback)
    "deleteCalendarItems" -> deleteCalendarItems(parameters, resultCallback)
    "purgeCalendarItem" -> purgeCalendarItem(parameters, resultCallback)
    "createCalendarItem" -> createCalendarItem(parameters, resultCallback)
    "bookCalendarItemCheckingAvailability" -> bookCalendarItemCheckingAvailability(parameters, resultCallback)
    "undeleteCalendarItemById" -> undeleteCalendarItemById(parameters, resultCallback)
    "undeleteCalendarItem" -> undeleteCalendarItem(parameters, resultCallback)
    "modifyCalendarItem" -> modifyCalendarItem(parameters, resultCallback)
    "getCalendarItem" -> getCalendarItem(parameters, resultCallback)
    "getCalendarItems" -> getCalendarItems(parameters, resultCallback)
    "subscribeToEvents" -> subscribeToEvents(parameters, resultCallback)
    "inGroup.matchCalendarItemsBy" -> inGroup_matchCalendarItemsBy(parameters, resultCallback)
    "inGroup.matchCalendarItemsBySorted" -> inGroup_matchCalendarItemsBySorted(parameters, resultCallback)
    "inGroup.filterCalendarItemsBy" -> inGroup_filterCalendarItemsBy(parameters, resultCallback)
    "inGroup.filterCalendarItemsBySorted" -> inGroup_filterCalendarItemsBySorted(parameters, resultCallback)
    "inGroup.deleteCalendarItemById" -> inGroup_deleteCalendarItemById(parameters, resultCallback)
    "inGroup.deleteCalendarItemsByIds" -> inGroup_deleteCalendarItemsByIds(parameters, resultCallback)
    "inGroup.deleteCalendarItem" -> inGroup_deleteCalendarItem(parameters, resultCallback)
    "inGroup.deleteCalendarItems" -> inGroup_deleteCalendarItems(parameters, resultCallback)
    "inGroup.createCalendarItem" -> inGroup_createCalendarItem(parameters, resultCallback)
    "inGroup.modifyCalendarItem" -> inGroup_modifyCalendarItem(parameters, resultCallback)
    "inGroup.getCalendarItem" -> inGroup_getCalendarItem(parameters, resultCallback)
    "inGroup.getCalendarItems" -> inGroup_getCalendarItems(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun matchCalendarItemsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemBasicApi.matchCalendarItemsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchCalendarItemsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemBasicApi.matchCalendarItemsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterCalendarItemsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemBasicApi.filterCalendarItemsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterCalendarItemsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemBasicApi.filterCalendarItemsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun deleteCalendarItemById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemBasicApi.deleteCalendarItemById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteCalendarItemsByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemBasicApi.deleteCalendarItemsByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun purgeCalendarItemById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemBasicApi.purgeCalendarItemById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteCalendarItem(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemBasicApi.deleteCalendarItem(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("calendarItem"),
    )
  }

  private fun deleteCalendarItems(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemBasicApi.deleteCalendarItems(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("calendarItems"),
    )
  }

  private fun purgeCalendarItem(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemBasicApi.purgeCalendarItem(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("calendarItem"),
    )
  }

  private fun createCalendarItem(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemBasicApi.createCalendarItem(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun bookCalendarItemCheckingAvailability(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemBasicApi.bookCalendarItemCheckingAvailability(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun undeleteCalendarItemById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemBasicApi.undeleteCalendarItemById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun undeleteCalendarItem(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemBasicApi.undeleteCalendarItem(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("calendarItem"),
    )
  }

  private fun modifyCalendarItem(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemBasicApi.modifyCalendarItem(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun getCalendarItem(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemBasicApi.getCalendarItem(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun getCalendarItems(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemBasicApi.getCalendarItems(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun subscribeToEvents(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemBasicApi.subscribeToEvents(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("events"),
      parameters.getValue("filter"),
      parameters.getValue("subscriptionConfig"),
    )
  }

  private fun inGroup_matchCalendarItemsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemBasicApi.inGroup.matchCalendarItemsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("filter"),
    )
  }

  private fun inGroup_matchCalendarItemsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemBasicApi.inGroup.matchCalendarItemsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("filter"),
    )
  }

  private fun inGroup_filterCalendarItemsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemBasicApi.inGroup.filterCalendarItemsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("filter"),
    )
  }

  private fun inGroup_filterCalendarItemsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemBasicApi.inGroup.filterCalendarItemsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("filter"),
    )
  }

  private fun inGroup_deleteCalendarItemById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemBasicApi.inGroup.deleteCalendarItemById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun inGroup_deleteCalendarItemsByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemBasicApi.inGroup.deleteCalendarItemsByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun inGroup_deleteCalendarItem(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemBasicApi.inGroup.deleteCalendarItem(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("calendarItem"),
    )
  }

  private fun inGroup_deleteCalendarItems(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemBasicApi.inGroup.deleteCalendarItems(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("calendarItems"),
    )
  }

  private fun inGroup_createCalendarItem(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemBasicApi.inGroup.createCalendarItem(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun inGroup_modifyCalendarItem(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemBasicApi.inGroup.modifyCalendarItem(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun inGroup_getCalendarItem(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemBasicApi.inGroup.getCalendarItem(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("entityId"),
    )
  }

  private fun inGroup_getCalendarItems(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemBasicApi.inGroup.getCalendarItems(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("entityIds"),
    )
  }
}
