package com.icure.cardinal.sdk.js.synthetic.mapasobjectarray

import com.icure.cardinal.sdk.crypto.entities.FormShareOptions
import com.icure.cardinal.sdk.js.crypto.entities.FormShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.formShareOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.formShareOptions_toJs
import com.icure.cardinal.sdk.js.model.CheckedConverters
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import kotlin.Array
import kotlin.collections.Map

public external interface EntityReferenceInGroupToFormShareOptionsMapObject_delegate_shareOptions {
  public val `delegate`: EntityReferenceInGroupJs

  public val shareOptions: FormShareOptionsJs
}

public
    fun EntityReferenceInGroupToFormShareOptionsMapObject_delegate_shareOptions_toJs(ktMap: Map<EntityReferenceInGroup, FormShareOptions>):
    Array<EntityReferenceInGroupToFormShareOptionsMapObject_delegate_shareOptions> =
    ktMap.map { entry ->
  val delegateKt = entry.key
  val delegate: EntityReferenceInGroupJs = entityReferenceInGroup_toJs(delegateKt)
  val shareOptionsKt = entry.value
  val shareOptions: FormShareOptionsJs = formShareOptions_toJs(shareOptionsKt)
  js("{delegate: delegate, shareOptions: shareOptions}")
}.toTypedArray()

public
    fun EntityReferenceInGroupToFormShareOptionsMapObject_delegate_shareOptions_fromJs(jsArray: Array<EntityReferenceInGroupToFormShareOptionsMapObject_delegate_shareOptions>):
    Map<EntityReferenceInGroup, FormShareOptions> = CheckedConverters.objectArrayToMap(
  jsArray,
  { entry ->
    val key = entry.delegate
    entityReferenceInGroup_fromJs(key)
  },
  { entry ->
    val value = entry.shareOptions
    formShareOptions_fromJs(value)
  }
)
