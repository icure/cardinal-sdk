package com.icure.cardinal.sdk.js.synthetic.mapasobjectarray

import com.icure.cardinal.sdk.crypto.entities.AccessLogShareOptions
import com.icure.cardinal.sdk.js.crypto.entities.AccessLogShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.accessLogShareOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.accessLogShareOptions_toJs
import com.icure.cardinal.sdk.js.model.CheckedConverters
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import kotlin.Array
import kotlin.collections.Map

public external interface
    EntityReferenceInGroupToAccessLogShareOptionsMapObject_delegate_shareOptions {
  public val `delegate`: EntityReferenceInGroupJs

  public val shareOptions: AccessLogShareOptionsJs
}

public
    fun EntityReferenceInGroupToAccessLogShareOptionsMapObject_delegate_shareOptions_toJs(ktMap: Map<EntityReferenceInGroup, AccessLogShareOptions>):
    Array<EntityReferenceInGroupToAccessLogShareOptionsMapObject_delegate_shareOptions> =
    ktMap.map { entry ->
  val delegateKt = entry.key
  val delegate: EntityReferenceInGroupJs = entityReferenceInGroup_toJs(delegateKt)
  val shareOptionsKt = entry.value
  val shareOptions: AccessLogShareOptionsJs = accessLogShareOptions_toJs(shareOptionsKt)
  js("{delegate: delegate, shareOptions: shareOptions}")
}.toTypedArray()

public
    fun EntityReferenceInGroupToAccessLogShareOptionsMapObject_delegate_shareOptions_fromJs(jsArray: Array<EntityReferenceInGroupToAccessLogShareOptionsMapObject_delegate_shareOptions>):
    Map<EntityReferenceInGroup, AccessLogShareOptions> = CheckedConverters.objectArrayToMap(
  jsArray,
  { entry ->
    val key = entry.delegate
    entityReferenceInGroup_fromJs(key)
  },
  { entry ->
    val value = entry.shareOptions
    accessLogShareOptions_fromJs(value)
  }
)
