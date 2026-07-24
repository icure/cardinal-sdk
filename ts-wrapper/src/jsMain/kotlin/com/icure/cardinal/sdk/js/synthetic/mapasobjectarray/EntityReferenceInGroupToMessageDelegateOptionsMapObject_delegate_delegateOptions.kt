package com.icure.cardinal.sdk.js.synthetic.mapasobjectarray

import com.icure.cardinal.sdk.crypto.entities.MessageDelegateOptions
import com.icure.cardinal.sdk.js.crypto.entities.MessageDelegateOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.messageDelegateOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.messageDelegateOptions_toJs
import com.icure.cardinal.sdk.js.model.CheckedConverters
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import kotlin.Array
import kotlin.collections.Map

public external interface
    EntityReferenceInGroupToMessageDelegateOptionsMapObject_delegate_delegateOptions {
  public val `delegate`: EntityReferenceInGroupJs

  public val delegateOptions: MessageDelegateOptionsJs
}

public
    fun EntityReferenceInGroupToMessageDelegateOptionsMapObject_delegate_delegateOptions_toJs(ktMap: Map<EntityReferenceInGroup, MessageDelegateOptions>):
    Array<EntityReferenceInGroupToMessageDelegateOptionsMapObject_delegate_delegateOptions> =
    ktMap.map { entry ->
  val delegateKt = entry.key
  val delegate: EntityReferenceInGroupJs = entityReferenceInGroup_toJs(delegateKt)
  val delegateOptionsKt = entry.value
  val delegateOptions: MessageDelegateOptionsJs = messageDelegateOptions_toJs(delegateOptionsKt)
  js("{delegate: delegate, delegateOptions: delegateOptions}")
}.toTypedArray()

public
    fun EntityReferenceInGroupToMessageDelegateOptionsMapObject_delegate_delegateOptions_fromJs(jsArray: Array<EntityReferenceInGroupToMessageDelegateOptionsMapObject_delegate_delegateOptions>):
    Map<EntityReferenceInGroup, MessageDelegateOptions> = CheckedConverters.objectArrayToMap(
  jsArray,
  { entry ->
    val key = entry.delegate
    entityReferenceInGroup_fromJs(key)
  },
  { entry ->
    val value = entry.delegateOptions
    messageDelegateOptions_fromJs(value)
  }
)
