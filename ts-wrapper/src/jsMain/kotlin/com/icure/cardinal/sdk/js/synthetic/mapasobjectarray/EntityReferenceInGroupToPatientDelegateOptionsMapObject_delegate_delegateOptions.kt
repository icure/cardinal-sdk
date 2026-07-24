package com.icure.cardinal.sdk.js.synthetic.mapasobjectarray

import com.icure.cardinal.sdk.crypto.entities.PatientDelegateOptions
import com.icure.cardinal.sdk.js.crypto.entities.PatientDelegateOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.patientDelegateOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.patientDelegateOptions_toJs
import com.icure.cardinal.sdk.js.model.CheckedConverters
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import kotlin.Array
import kotlin.collections.Map

public external interface
    EntityReferenceInGroupToPatientDelegateOptionsMapObject_delegate_delegateOptions {
  public val `delegate`: EntityReferenceInGroupJs

  public val delegateOptions: PatientDelegateOptionsJs
}

public
    fun EntityReferenceInGroupToPatientDelegateOptionsMapObject_delegate_delegateOptions_toJs(ktMap: Map<EntityReferenceInGroup, PatientDelegateOptions>):
    Array<EntityReferenceInGroupToPatientDelegateOptionsMapObject_delegate_delegateOptions> =
    ktMap.map { entry ->
  val delegateKt = entry.key
  val delegate: EntityReferenceInGroupJs = entityReferenceInGroup_toJs(delegateKt)
  val delegateOptionsKt = entry.value
  val delegateOptions: PatientDelegateOptionsJs = patientDelegateOptions_toJs(delegateOptionsKt)
  js("{delegate: delegate, delegateOptions: delegateOptions}")
}.toTypedArray()

public
    fun EntityReferenceInGroupToPatientDelegateOptionsMapObject_delegate_delegateOptions_fromJs(jsArray: Array<EntityReferenceInGroupToPatientDelegateOptionsMapObject_delegate_delegateOptions>):
    Map<EntityReferenceInGroup, PatientDelegateOptions> = CheckedConverters.objectArrayToMap(
  jsArray,
  { entry ->
    val key = entry.delegate
    entityReferenceInGroup_fromJs(key)
  },
  { entry ->
    val value = entry.delegateOptions
    patientDelegateOptions_fromJs(value)
  }
)
