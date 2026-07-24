package com.icure.cardinal.sdk.js.synthetic.mapasobjectarray

import com.icure.cardinal.sdk.crypto.entities.ContactDelegateOptions
import com.icure.cardinal.sdk.js.crypto.entities.ContactDelegateOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.contactDelegateOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.contactDelegateOptions_toJs
import com.icure.cardinal.sdk.js.model.CheckedConverters
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import kotlin.Array
import kotlin.collections.Map

public external interface
    EntityReferenceInGroupToContactDelegateOptionsMapObject_delegate_delegateOptions {
  public val `delegate`: EntityReferenceInGroupJs

  public val delegateOptions: ContactDelegateOptionsJs
}

public
    fun EntityReferenceInGroupToContactDelegateOptionsMapObject_delegate_delegateOptions_toJs(ktMap: Map<EntityReferenceInGroup, ContactDelegateOptions>):
    Array<EntityReferenceInGroupToContactDelegateOptionsMapObject_delegate_delegateOptions> =
    ktMap.map { entry ->
  val delegateKt = entry.key
  val delegate: EntityReferenceInGroupJs = entityReferenceInGroup_toJs(delegateKt)
  val delegateOptionsKt = entry.value
  val delegateOptions: ContactDelegateOptionsJs = contactDelegateOptions_toJs(delegateOptionsKt)
  js("{delegate: delegate, delegateOptions: delegateOptions}")
}.toTypedArray()

public
    fun EntityReferenceInGroupToContactDelegateOptionsMapObject_delegate_delegateOptions_fromJs(jsArray: Array<EntityReferenceInGroupToContactDelegateOptionsMapObject_delegate_delegateOptions>):
    Map<EntityReferenceInGroup, ContactDelegateOptions> = CheckedConverters.objectArrayToMap(
  jsArray,
  { entry ->
    val key = entry.delegate
    entityReferenceInGroup_fromJs(key)
  },
  { entry ->
    val value = entry.delegateOptions
    contactDelegateOptions_fromJs(value)
  }
)
