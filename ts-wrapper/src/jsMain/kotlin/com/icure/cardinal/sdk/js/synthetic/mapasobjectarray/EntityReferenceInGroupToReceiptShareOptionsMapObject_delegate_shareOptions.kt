package com.icure.cardinal.sdk.js.synthetic.mapasobjectarray

import com.icure.cardinal.sdk.crypto.entities.ReceiptShareOptions
import com.icure.cardinal.sdk.js.crypto.entities.ReceiptShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.receiptShareOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.receiptShareOptions_toJs
import com.icure.cardinal.sdk.js.model.CheckedConverters
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import kotlin.Array
import kotlin.collections.Map

public external interface EntityReferenceInGroupToReceiptShareOptionsMapObject_delegate_shareOptions
    {
  public val `delegate`: EntityReferenceInGroupJs

  public val shareOptions: ReceiptShareOptionsJs
}

public
    fun EntityReferenceInGroupToReceiptShareOptionsMapObject_delegate_shareOptions_toJs(ktMap: Map<EntityReferenceInGroup, ReceiptShareOptions>):
    Array<EntityReferenceInGroupToReceiptShareOptionsMapObject_delegate_shareOptions> =
    ktMap.map { entry ->
  val delegateKt = entry.key
  val delegate: EntityReferenceInGroupJs = entityReferenceInGroup_toJs(delegateKt)
  val shareOptionsKt = entry.value
  val shareOptions: ReceiptShareOptionsJs = receiptShareOptions_toJs(shareOptionsKt)
  js("{delegate: delegate, shareOptions: shareOptions}")
}.toTypedArray()

public
    fun EntityReferenceInGroupToReceiptShareOptionsMapObject_delegate_shareOptions_fromJs(jsArray: Array<EntityReferenceInGroupToReceiptShareOptionsMapObject_delegate_shareOptions>):
    Map<EntityReferenceInGroup, ReceiptShareOptions> = CheckedConverters.objectArrayToMap(
  jsArray,
  { entry ->
    val key = entry.delegate
    entityReferenceInGroup_fromJs(key)
  },
  { entry ->
    val value = entry.shareOptions
    receiptShareOptions_fromJs(value)
  }
)
