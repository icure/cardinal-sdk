package com.icure.cardinal.sdk.js.synthetic.mapasobjectarray

import com.icure.cardinal.sdk.crypto.entities.AccessLogDelegateOptions
import com.icure.cardinal.sdk.js.crypto.entities.AccessLogDelegateOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.accessLogDelegateOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.accessLogDelegateOptions_toJs
import com.icure.cardinal.sdk.js.model.CheckedConverters
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import kotlin.Array
import kotlin.collections.Map

public external interface
    EntityReferenceInGroupToAccessLogDelegateOptionsMapObject_delegate_delegateOptions {
  public val `delegate`: EntityReferenceInGroupJs

  public val delegateOptions: AccessLogDelegateOptionsJs
}

public
    fun EntityReferenceInGroupToAccessLogDelegateOptionsMapObject_delegate_delegateOptions_toJs(ktMap: Map<EntityReferenceInGroup, AccessLogDelegateOptions>):
    Array<EntityReferenceInGroupToAccessLogDelegateOptionsMapObject_delegate_delegateOptions> =
    ktMap.map { entry ->
  val delegateKt = entry.key
  val delegate: EntityReferenceInGroupJs = entityReferenceInGroup_toJs(delegateKt)
  val delegateOptionsKt = entry.value
  val delegateOptions: AccessLogDelegateOptionsJs = accessLogDelegateOptions_toJs(delegateOptionsKt)
  js("{delegate: delegate, delegateOptions: delegateOptions}")
}.toTypedArray()

public
    fun EntityReferenceInGroupToAccessLogDelegateOptionsMapObject_delegate_delegateOptions_fromJs(jsArray: Array<EntityReferenceInGroupToAccessLogDelegateOptionsMapObject_delegate_delegateOptions>):
    Map<EntityReferenceInGroup, AccessLogDelegateOptions> = CheckedConverters.objectArrayToMap(
  jsArray,
  { entry ->
    val key = entry.delegate
    entityReferenceInGroup_fromJs(key)
  },
  { entry ->
    val value = entry.delegateOptions
    accessLogDelegateOptions_fromJs(value)
  }
)
