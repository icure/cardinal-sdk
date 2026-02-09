package com.icure.cardinal.sdk.js.synthetic.mapasobjectarray

import com.icure.cardinal.sdk.crypto.entities.TopicShareOptions
import com.icure.cardinal.sdk.js.crypto.entities.TopicShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.topicShareOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.topicShareOptions_toJs
import com.icure.cardinal.sdk.js.model.CheckedConverters
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import kotlin.Array
import kotlin.collections.Map

public external interface EntityReferenceInGroupToTopicShareOptionsMapObject_delegate_shareOptions {
  public val `delegate`: EntityReferenceInGroupJs

  public val shareOptions: TopicShareOptionsJs
}

public
    fun EntityReferenceInGroupToTopicShareOptionsMapObject_delegate_shareOptions_toJs(ktMap: Map<EntityReferenceInGroup, TopicShareOptions>):
    Array<EntityReferenceInGroupToTopicShareOptionsMapObject_delegate_shareOptions> =
    ktMap.map { entry ->
  val delegateKt = entry.key
  val delegate: EntityReferenceInGroupJs = entityReferenceInGroup_toJs(delegateKt)
  val shareOptionsKt = entry.value
  val shareOptions: TopicShareOptionsJs = topicShareOptions_toJs(shareOptionsKt)
  js("{delegate: delegate, shareOptions: shareOptions}")
}.toTypedArray()

public
    fun EntityReferenceInGroupToTopicShareOptionsMapObject_delegate_shareOptions_fromJs(jsArray: Array<EntityReferenceInGroupToTopicShareOptionsMapObject_delegate_shareOptions>):
    Map<EntityReferenceInGroup, TopicShareOptions> = CheckedConverters.objectArrayToMap(
  jsArray,
  { entry ->
    val key = entry.delegate
    entityReferenceInGroup_fromJs(key)
  },
  { entry ->
    val value = entry.shareOptions
    topicShareOptions_fromJs(value)
  }
)
