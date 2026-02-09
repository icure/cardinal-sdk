package com.icure.cardinal.sdk.js.synthetic.mapasobjectarray

import com.icure.cardinal.sdk.crypto.entities.MessageShareOptions
import com.icure.cardinal.sdk.js.crypto.entities.MessageShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.messageShareOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.messageShareOptions_toJs
import com.icure.cardinal.sdk.js.model.CheckedConverters
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import kotlin.Array
import kotlin.collections.Map

public external interface EntityReferenceInGroupToMessageShareOptionsMapObject_delegate_shareOptions
    {
  public val `delegate`: EntityReferenceInGroupJs

  public val shareOptions: MessageShareOptionsJs
}

public
    fun EntityReferenceInGroupToMessageShareOptionsMapObject_delegate_shareOptions_toJs(ktMap: Map<EntityReferenceInGroup, MessageShareOptions>):
    Array<EntityReferenceInGroupToMessageShareOptionsMapObject_delegate_shareOptions> =
    ktMap.map { entry ->
  val delegateKt = entry.key
  val delegate: EntityReferenceInGroupJs = entityReferenceInGroup_toJs(delegateKt)
  val shareOptionsKt = entry.value
  val shareOptions: MessageShareOptionsJs = messageShareOptions_toJs(shareOptionsKt)
  js("{delegate: delegate, shareOptions: shareOptions}")
}.toTypedArray()

public
    fun EntityReferenceInGroupToMessageShareOptionsMapObject_delegate_shareOptions_fromJs(jsArray: Array<EntityReferenceInGroupToMessageShareOptionsMapObject_delegate_shareOptions>):
    Map<EntityReferenceInGroup, MessageShareOptions> = CheckedConverters.objectArrayToMap(
  jsArray,
  { entry ->
    val key = entry.delegate
    entityReferenceInGroup_fromJs(key)
  },
  { entry ->
    val value = entry.shareOptions
    messageShareOptions_fromJs(value)
  }
)
