// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.base.codeStub_fromJs
import com.icure.cardinal.sdk.js.model.base.codeStub_toJs
import com.icure.cardinal.sdk.model.embed.Periodicity
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun periodicity_toJs(obj: Periodicity): PeriodicityJs {
	val relatedCode = nullToUndefined(
		obj.relatedCode?.let { nonNull1 ->
			codeStub_toJs(nonNull1)
		}
	)
	val relatedPeriodicity = nullToUndefined(
		obj.relatedPeriodicity?.let { nonNull1 ->
			codeStub_toJs(nonNull1)
		}
	)
	return PeriodicityJs(js("{" +
		"relatedCode:relatedCode," +
		"relatedPeriodicity:relatedPeriodicity" +
	"}"))
}

public fun periodicity_fromJs(obj: PeriodicityJs): Periodicity {
	val relatedCode = obj.relatedCode?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val relatedPeriodicity = obj.relatedPeriodicity?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	return Periodicity(
		relatedCode = relatedCode,
		relatedPeriodicity = relatedPeriodicity,
	)
}
