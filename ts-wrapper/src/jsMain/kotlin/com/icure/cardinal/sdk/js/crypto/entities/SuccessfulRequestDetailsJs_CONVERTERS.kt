// auto-generated file
package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.crypto.entities.ShareRequestPurpose
import com.icure.cardinal.sdk.crypto.entities.SuccessfulRequestDetails
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun successfulRequestDetails_toJs(obj: SuccessfulRequestDetails): SuccessfulRequestDetailsJs {
	val delegateReference = entityReferenceInGroup_toJs(obj.delegateReference)
	val purpose = obj.purpose.name
	return SuccessfulRequestDetailsJs(js("{" +
		"delegateReference:delegateReference," +
		"purpose:purpose" +
	"}"))
}

public fun successfulRequestDetails_fromJs(obj: SuccessfulRequestDetailsJs): SuccessfulRequestDetails {
	val delegateReference = entityReferenceInGroup_fromJs(obj.delegateReference)
	val purpose = ShareRequestPurpose.valueOf(obj.purpose)
	return SuccessfulRequestDetails(
		delegateReference = delegateReference,
		purpose = purpose,
	)
}
