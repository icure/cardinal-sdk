package com.icure.cardinal.sdk.js.synthetic.mapasobjectarray

import com.icure.cardinal.sdk.js.model.CheckedConverters
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.embed.AccessLevel
import kotlin.Array
import kotlin.String
import kotlin.collections.Map

public external interface EntityReferenceInGroupToAccessLevelMapObject_delegate_accessLevel {
  public val `delegate`: EntityReferenceInGroupJs

  public val accessLevel: String
}

public fun EntityReferenceInGroupToAccessLevelMapObject_delegate_accessLevel_toJs(ktMap: Map<EntityReferenceInGroup, AccessLevel>): Array<EntityReferenceInGroupToAccessLevelMapObject_delegate_accessLevel> = ktMap.map { entry ->
  val delegateKt = entry.key
  val delegate: EntityReferenceInGroupJs = entityReferenceInGroup_toJs(delegateKt)
  val accessLevelKt = entry.value
  val accessLevel: String = accessLevelKt.name
  js("{delegate: delegate, accessLevel: accessLevel}")
}.toTypedArray()

public fun EntityReferenceInGroupToAccessLevelMapObject_delegate_accessLevel_fromJs(jsArray: Array<EntityReferenceInGroupToAccessLevelMapObject_delegate_accessLevel>): Map<EntityReferenceInGroup, AccessLevel> = CheckedConverters.objectArrayToMap(
  jsArray,
  { entry ->
    val key = entry.delegate
    entityReferenceInGroup_fromJs(key)
  },
  { entry ->
    val value = entry.accessLevel
    AccessLevel.valueOf(value)
  }
)
