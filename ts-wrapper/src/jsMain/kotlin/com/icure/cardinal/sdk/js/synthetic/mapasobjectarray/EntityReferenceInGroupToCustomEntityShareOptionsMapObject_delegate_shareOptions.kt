package com.icure.cardinal.sdk.js.synthetic.mapasobjectarray

import com.icure.cardinal.sdk.crypto.entities.CustomEntityShareOptions
import com.icure.cardinal.sdk.js.crypto.entities.CustomEntityShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.customEntityShareOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.customEntityShareOptions_toJs
import com.icure.cardinal.sdk.js.model.CheckedConverters
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import kotlin.Array
import kotlin.collections.Map

public external interface EntityReferenceInGroupToCustomEntityShareOptionsMapObject_delegate_shareOptions {
  public val `delegate`: EntityReferenceInGroupJs

  public val shareOptions: CustomEntityShareOptionsJs
}

public fun EntityReferenceInGroupToCustomEntityShareOptionsMapObject_delegate_shareOptions_toJs(ktMap: Map<EntityReferenceInGroup, CustomEntityShareOptions>): Array<EntityReferenceInGroupToCustomEntityShareOptionsMapObject_delegate_shareOptions> = ktMap.map { entry ->
  val delegateKt = entry.key
  val delegate: EntityReferenceInGroupJs = entityReferenceInGroup_toJs(delegateKt)
  val shareOptionsKt = entry.value
  val shareOptions: CustomEntityShareOptionsJs = customEntityShareOptions_toJs(shareOptionsKt)
  js("{delegate: delegate, shareOptions: shareOptions}")
}.toTypedArray()

public fun EntityReferenceInGroupToCustomEntityShareOptionsMapObject_delegate_shareOptions_fromJs(jsArray: Array<EntityReferenceInGroupToCustomEntityShareOptionsMapObject_delegate_shareOptions>): Map<EntityReferenceInGroup, CustomEntityShareOptions> = CheckedConverters.objectArrayToMap(
  jsArray,
  { entry ->
    val key = entry.delegate
    entityReferenceInGroup_fromJs(key)
  },
  { entry ->
    val value = entry.shareOptions
    customEntityShareOptions_fromJs(value)
  }
)
