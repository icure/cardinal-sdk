package com.icure.cardinal.sdk.js.synthetic.mapasobjectarray

import com.icure.cardinal.sdk.crypto.entities.CalendarItemDelegateOptions
import com.icure.cardinal.sdk.js.crypto.entities.CalendarItemDelegateOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.calendarItemDelegateOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.calendarItemDelegateOptions_toJs
import com.icure.cardinal.sdk.js.model.CheckedConverters
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import kotlin.Array
import kotlin.collections.Map

public external interface
    EntityReferenceInGroupToCalendarItemDelegateOptionsMapObject_delegate_delegateOptions {
  public val `delegate`: EntityReferenceInGroupJs

  public val delegateOptions: CalendarItemDelegateOptionsJs
}

public
    fun EntityReferenceInGroupToCalendarItemDelegateOptionsMapObject_delegate_delegateOptions_toJs(ktMap: Map<EntityReferenceInGroup, CalendarItemDelegateOptions>):
    Array<EntityReferenceInGroupToCalendarItemDelegateOptionsMapObject_delegate_delegateOptions> =
    ktMap.map { entry ->
  val delegateKt = entry.key
  val delegate: EntityReferenceInGroupJs = entityReferenceInGroup_toJs(delegateKt)
  val delegateOptionsKt = entry.value
  val delegateOptions: CalendarItemDelegateOptionsJs =
      calendarItemDelegateOptions_toJs(delegateOptionsKt)
  js("{delegate: delegate, delegateOptions: delegateOptions}")
}.toTypedArray()

public
    fun EntityReferenceInGroupToCalendarItemDelegateOptionsMapObject_delegate_delegateOptions_fromJs(jsArray: Array<EntityReferenceInGroupToCalendarItemDelegateOptionsMapObject_delegate_delegateOptions>):
    Map<EntityReferenceInGroup, CalendarItemDelegateOptions> = CheckedConverters.objectArrayToMap(
  jsArray,
  { entry ->
    val key = entry.delegate
    entityReferenceInGroup_fromJs(key)
  },
  { entry ->
    val value = entry.delegateOptions
    calendarItemDelegateOptions_fromJs(value)
  }
)
