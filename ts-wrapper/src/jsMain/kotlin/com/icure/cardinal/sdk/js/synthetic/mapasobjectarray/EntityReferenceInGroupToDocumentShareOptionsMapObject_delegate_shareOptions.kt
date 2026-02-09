package com.icure.cardinal.sdk.js.synthetic.mapasobjectarray

import com.icure.cardinal.sdk.crypto.entities.DocumentShareOptions
import com.icure.cardinal.sdk.js.crypto.entities.DocumentShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.documentShareOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.documentShareOptions_toJs
import com.icure.cardinal.sdk.js.model.CheckedConverters
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import kotlin.Array
import kotlin.collections.Map

public external interface
    EntityReferenceInGroupToDocumentShareOptionsMapObject_delegate_shareOptions {
  public val `delegate`: EntityReferenceInGroupJs

  public val shareOptions: DocumentShareOptionsJs
}

public
    fun EntityReferenceInGroupToDocumentShareOptionsMapObject_delegate_shareOptions_toJs(ktMap: Map<EntityReferenceInGroup, DocumentShareOptions>):
    Array<EntityReferenceInGroupToDocumentShareOptionsMapObject_delegate_shareOptions> =
    ktMap.map { entry ->
  val delegateKt = entry.key
  val delegate: EntityReferenceInGroupJs = entityReferenceInGroup_toJs(delegateKt)
  val shareOptionsKt = entry.value
  val shareOptions: DocumentShareOptionsJs = documentShareOptions_toJs(shareOptionsKt)
  js("{delegate: delegate, shareOptions: shareOptions}")
}.toTypedArray()

public
    fun EntityReferenceInGroupToDocumentShareOptionsMapObject_delegate_shareOptions_fromJs(jsArray: Array<EntityReferenceInGroupToDocumentShareOptionsMapObject_delegate_shareOptions>):
    Map<EntityReferenceInGroup, DocumentShareOptions> = CheckedConverters.objectArrayToMap(
  jsArray,
  { entry ->
    val key = entry.delegate
    entityReferenceInGroup_fromJs(key)
  },
  { entry ->
    val value = entry.shareOptions
    documentShareOptions_fromJs(value)
  }
)
