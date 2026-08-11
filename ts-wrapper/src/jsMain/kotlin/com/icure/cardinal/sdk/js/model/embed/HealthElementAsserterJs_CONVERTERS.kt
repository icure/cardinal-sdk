// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.model.embed.AsserterType
import com.icure.cardinal.sdk.model.embed.HealthElementAsserter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun healthElementAsserter_toJs(obj: HealthElementAsserter): HealthElementAsserterJs {
	val asserterId = obj.asserterId
	val asserterType = obj.asserterType.name
	return HealthElementAsserterJs(js("{" +
		"asserterId:asserterId," +
		"asserterType:asserterType" +
	"}"))
}

public fun healthElementAsserter_fromJs(obj: HealthElementAsserterJs): HealthElementAsserter {
	val asserterId = obj.asserterId
	val asserterType = AsserterType.valueOf(obj.asserterType)
	return HealthElementAsserter(
		asserterId = asserterId,
		asserterType = asserterType,
	)
}
