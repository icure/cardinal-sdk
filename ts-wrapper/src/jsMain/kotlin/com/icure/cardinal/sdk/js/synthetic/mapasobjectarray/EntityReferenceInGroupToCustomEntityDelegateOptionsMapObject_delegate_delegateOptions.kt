package com.icure.cardinal.sdk.js.synthetic.mapasobjectarray

import com.icure.cardinal.sdk.crypto.entities.CustomEntityDelegateOptions
import com.icure.cardinal.sdk.js.crypto.entities.CustomEntityDelegateOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.customEntityDelegateOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.customEntityDelegateOptions_toJs
import com.icure.cardinal.sdk.js.model.CheckedConverters
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import kotlin.Array
import kotlin.collections.Map

public external interface EntityReferenceInGroupToCustomEntityDelegateOptionsMapObject_delegate_delegateOptions {
  public val `delegate`: EntityReferenceInGroupJs

  public val delegateOptions: CustomEntityDelegateOptionsJs
}

public fun EntityReferenceInGroupToCustomEntityDelegateOptionsMapObject_delegate_delegateOptions_toJs(ktMap: Map<EntityReferenceInGroup, CustomEntityDelegateOptions>): Array<EntityReferenceInGroupToCustomEntityDelegateOptionsMapObject_delegate_delegateOptions> = ktMap.map { entry ->
  val delegateKt = entry.key
  val delegate: EntityReferenceInGroupJs = entityReferenceInGroup_toJs(delegateKt)
  val delegateOptionsKt = entry.value
  val delegateOptions: CustomEntityDelegateOptionsJs = customEntityDelegateOptions_toJs(delegateOptionsKt)
  js("{delegate: delegate, delegateOptions: delegateOptions}")
}.toTypedArray()

public fun EntityReferenceInGroupToCustomEntityDelegateOptionsMapObject_delegate_delegateOptions_fromJs(jsArray: Array<EntityReferenceInGroupToCustomEntityDelegateOptionsMapObject_delegate_delegateOptions>): Map<EntityReferenceInGroup, CustomEntityDelegateOptions> = CheckedConverters.objectArrayToMap(
  jsArray,
  { entry ->
    val key = entry.delegate
    entityReferenceInGroup_fromJs(key)
  },
  { entry ->
    val value = entry.delegateOptions
    customEntityDelegateOptions_fromJs(value)
  }
)
