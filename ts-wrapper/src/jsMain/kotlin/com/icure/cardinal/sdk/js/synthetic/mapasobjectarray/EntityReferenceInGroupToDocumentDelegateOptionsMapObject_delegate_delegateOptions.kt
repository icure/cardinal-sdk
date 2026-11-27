package com.icure.cardinal.sdk.js.synthetic.mapasobjectarray

import com.icure.cardinal.sdk.crypto.entities.DocumentDelegateOptions
import com.icure.cardinal.sdk.js.crypto.entities.DocumentDelegateOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.documentDelegateOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.documentDelegateOptions_toJs
import com.icure.cardinal.sdk.js.model.CheckedConverters
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import kotlin.Array
import kotlin.collections.Map

public external interface EntityReferenceInGroupToDocumentDelegateOptionsMapObject_delegate_delegateOptions {
  public val `delegate`: EntityReferenceInGroupJs

  public val delegateOptions: DocumentDelegateOptionsJs
}

public fun EntityReferenceInGroupToDocumentDelegateOptionsMapObject_delegate_delegateOptions_toJs(ktMap: Map<EntityReferenceInGroup, DocumentDelegateOptions>): Array<EntityReferenceInGroupToDocumentDelegateOptionsMapObject_delegate_delegateOptions> = ktMap.map { entry ->
  val delegateKt = entry.key
  val delegate: EntityReferenceInGroupJs = entityReferenceInGroup_toJs(delegateKt)
  val delegateOptionsKt = entry.value
  val delegateOptions: DocumentDelegateOptionsJs = documentDelegateOptions_toJs(delegateOptionsKt)
  js("{delegate: delegate, delegateOptions: delegateOptions}")
}.toTypedArray()

public fun EntityReferenceInGroupToDocumentDelegateOptionsMapObject_delegate_delegateOptions_fromJs(jsArray: Array<EntityReferenceInGroupToDocumentDelegateOptionsMapObject_delegate_delegateOptions>): Map<EntityReferenceInGroup, DocumentDelegateOptions> = CheckedConverters.objectArrayToMap(
  jsArray,
  { entry ->
    val key = entry.delegate
    entityReferenceInGroup_fromJs(key)
  },
  { entry ->
    val value = entry.delegateOptions
    documentDelegateOptions_fromJs(value)
  }
)
