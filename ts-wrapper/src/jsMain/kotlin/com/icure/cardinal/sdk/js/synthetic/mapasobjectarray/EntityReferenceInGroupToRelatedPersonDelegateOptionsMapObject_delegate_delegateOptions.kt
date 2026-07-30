package com.icure.cardinal.sdk.js.synthetic.mapasobjectarray

import com.icure.cardinal.sdk.crypto.entities.RelatedPersonDelegateOptions
import com.icure.cardinal.sdk.js.crypto.entities.RelatedPersonDelegateOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.relatedPersonDelegateOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.relatedPersonDelegateOptions_toJs
import com.icure.cardinal.sdk.js.model.CheckedConverters
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import kotlin.Array
import kotlin.collections.Map

public external interface
    EntityReferenceInGroupToRelatedPersonDelegateOptionsMapObject_delegate_delegateOptions {
  public val `delegate`: EntityReferenceInGroupJs

  public val delegateOptions: RelatedPersonDelegateOptionsJs
}

public
    fun EntityReferenceInGroupToRelatedPersonDelegateOptionsMapObject_delegate_delegateOptions_toJs(ktMap: Map<EntityReferenceInGroup, RelatedPersonDelegateOptions>):
    Array<EntityReferenceInGroupToRelatedPersonDelegateOptionsMapObject_delegate_delegateOptions> =
    ktMap.map { entry ->
  val delegateKt = entry.key
  val delegate: EntityReferenceInGroupJs = entityReferenceInGroup_toJs(delegateKt)
  val delegateOptionsKt = entry.value
  val delegateOptions: RelatedPersonDelegateOptionsJs =
      relatedPersonDelegateOptions_toJs(delegateOptionsKt)
  js("{delegate: delegate, delegateOptions: delegateOptions}")
}.toTypedArray()

public
    fun EntityReferenceInGroupToRelatedPersonDelegateOptionsMapObject_delegate_delegateOptions_fromJs(jsArray: Array<EntityReferenceInGroupToRelatedPersonDelegateOptionsMapObject_delegate_delegateOptions>):
    Map<EntityReferenceInGroup, RelatedPersonDelegateOptions> = CheckedConverters.objectArrayToMap(
  jsArray,
  { entry ->
    val key = entry.delegate
    entityReferenceInGroup_fromJs(key)
  },
  { entry ->
    val value = entry.delegateOptions
    relatedPersonDelegateOptions_fromJs(value)
  }
)
