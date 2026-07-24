package com.icure.cardinal.sdk.js.synthetic.mapasobjectarray

import com.icure.cardinal.sdk.crypto.entities.HealthElementDelegateOptions
import com.icure.cardinal.sdk.js.crypto.entities.HealthElementDelegateOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.healthElementDelegateOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.healthElementDelegateOptions_toJs
import com.icure.cardinal.sdk.js.model.CheckedConverters
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import kotlin.Array
import kotlin.collections.Map

public external interface
    EntityReferenceInGroupToHealthElementDelegateOptionsMapObject_delegate_delegateOptions {
  public val `delegate`: EntityReferenceInGroupJs

  public val delegateOptions: HealthElementDelegateOptionsJs
}

public
    fun EntityReferenceInGroupToHealthElementDelegateOptionsMapObject_delegate_delegateOptions_toJs(ktMap: Map<EntityReferenceInGroup, HealthElementDelegateOptions>):
    Array<EntityReferenceInGroupToHealthElementDelegateOptionsMapObject_delegate_delegateOptions> =
    ktMap.map { entry ->
  val delegateKt = entry.key
  val delegate: EntityReferenceInGroupJs = entityReferenceInGroup_toJs(delegateKt)
  val delegateOptionsKt = entry.value
  val delegateOptions: HealthElementDelegateOptionsJs =
      healthElementDelegateOptions_toJs(delegateOptionsKt)
  js("{delegate: delegate, delegateOptions: delegateOptions}")
}.toTypedArray()

public
    fun EntityReferenceInGroupToHealthElementDelegateOptionsMapObject_delegate_delegateOptions_fromJs(jsArray: Array<EntityReferenceInGroupToHealthElementDelegateOptionsMapObject_delegate_delegateOptions>):
    Map<EntityReferenceInGroup, HealthElementDelegateOptions> = CheckedConverters.objectArrayToMap(
  jsArray,
  { entry ->
    val key = entry.delegate
    entityReferenceInGroup_fromJs(key)
  },
  { entry ->
    val value = entry.delegateOptions
    healthElementDelegateOptions_fromJs(value)
  }
)
