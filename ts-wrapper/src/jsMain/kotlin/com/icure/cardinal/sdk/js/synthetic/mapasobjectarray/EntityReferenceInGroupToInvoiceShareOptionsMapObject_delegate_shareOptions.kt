package com.icure.cardinal.sdk.js.synthetic.mapasobjectarray

import com.icure.cardinal.sdk.crypto.entities.InvoiceShareOptions
import com.icure.cardinal.sdk.js.crypto.entities.InvoiceShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.invoiceShareOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.invoiceShareOptions_toJs
import com.icure.cardinal.sdk.js.model.CheckedConverters
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import kotlin.Array
import kotlin.collections.Map

public external interface EntityReferenceInGroupToInvoiceShareOptionsMapObject_delegate_shareOptions
    {
  public val `delegate`: EntityReferenceInGroupJs

  public val shareOptions: InvoiceShareOptionsJs
}

public
    fun EntityReferenceInGroupToInvoiceShareOptionsMapObject_delegate_shareOptions_toJs(ktMap: Map<EntityReferenceInGroup, InvoiceShareOptions>):
    Array<EntityReferenceInGroupToInvoiceShareOptionsMapObject_delegate_shareOptions> =
    ktMap.map { entry ->
  val delegateKt = entry.key
  val delegate: EntityReferenceInGroupJs = entityReferenceInGroup_toJs(delegateKt)
  val shareOptionsKt = entry.value
  val shareOptions: InvoiceShareOptionsJs = invoiceShareOptions_toJs(shareOptionsKt)
  js("{delegate: delegate, shareOptions: shareOptions}")
}.toTypedArray()

public
    fun EntityReferenceInGroupToInvoiceShareOptionsMapObject_delegate_shareOptions_fromJs(jsArray: Array<EntityReferenceInGroupToInvoiceShareOptionsMapObject_delegate_shareOptions>):
    Map<EntityReferenceInGroup, InvoiceShareOptions> = CheckedConverters.objectArrayToMap(
  jsArray,
  { entry ->
    val key = entry.delegate
    entityReferenceInGroup_fromJs(key)
  },
  { entry ->
    val value = entry.shareOptions
    invoiceShareOptions_fromJs(value)
  }
)
