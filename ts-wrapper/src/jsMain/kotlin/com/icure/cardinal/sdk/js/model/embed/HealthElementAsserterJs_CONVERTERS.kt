// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.base.identifier_fromJs
import com.icure.cardinal.sdk.js.model.base.identifier_toJs
import com.icure.cardinal.sdk.model.embed.AsserterType
import com.icure.cardinal.sdk.model.embed.HealthElementAsserter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun healthElementAsserter_toJs(obj: HealthElementAsserter): HealthElementAsserterJs {
	val localAsserterIdentifier = nullToUndefined(
		obj.localAsserterIdentifier?.let { nonNull1 ->
			healthElementAsserter_LocalAsserterIdentifier_toJs(nonNull1)
		}
	)
	val externalAsserterIdentifier = nullToUndefined(
		obj.externalAsserterIdentifier?.let { nonNull1 ->
			healthElementAsserter_ExternalAsserterIdentifier_toJs(nonNull1)
		}
	)
	return HealthElementAsserterJs(js("{" +
		"localAsserterIdentifier:localAsserterIdentifier," +
		"externalAsserterIdentifier:externalAsserterIdentifier" +
	"}"))
}

public fun healthElementAsserter_fromJs(obj: HealthElementAsserterJs): HealthElementAsserter {
	val localAsserterIdentifier = obj.localAsserterIdentifier?.let { nonNull1 ->
		healthElementAsserter_LocalAsserterIdentifier_fromJs(nonNull1)
	}
	val externalAsserterIdentifier = obj.externalAsserterIdentifier?.let { nonNull1 ->
		healthElementAsserter_ExternalAsserterIdentifier_fromJs(nonNull1)
	}
	return HealthElementAsserter(
		localAsserterIdentifier = localAsserterIdentifier,
		externalAsserterIdentifier = externalAsserterIdentifier,
	)
}

@Suppress("UNUSED_VARIABLE")
public
		fun healthElementAsserter_LocalAsserterIdentifier_toJs(obj: HealthElementAsserter.LocalAsserterIdentifier):
		HealthElementAsserterJs_LocalAsserterIdentifierJs {
	val id = obj.id
	val type = obj.type.name
	return HealthElementAsserterJs_LocalAsserterIdentifierJs(js("{" +
		"id:id," +
		"type:type" +
	"}"))
}

public
		fun healthElementAsserter_LocalAsserterIdentifier_fromJs(obj: HealthElementAsserterJs_LocalAsserterIdentifierJs):
		HealthElementAsserter.LocalAsserterIdentifier {
	val id = obj.id
	val type = AsserterType.valueOf(obj.type)
	return HealthElementAsserter.LocalAsserterIdentifier(
		id = id,
		type = type,
	)
}

@Suppress("UNUSED_VARIABLE")
public
		fun healthElementAsserter_ExternalAsserterIdentifier_toJs(obj: HealthElementAsserter.ExternalAsserterIdentifier):
		HealthElementAsserterJs_ExternalAsserterIdentifierJs {
	val identifier = identifier_toJs(obj.identifier)
	return HealthElementAsserterJs_ExternalAsserterIdentifierJs(js("{" +
		"identifier:identifier" +
	"}"))
}

public
		fun healthElementAsserter_ExternalAsserterIdentifier_fromJs(obj: HealthElementAsserterJs_ExternalAsserterIdentifierJs):
		HealthElementAsserter.ExternalAsserterIdentifier {
	val identifier = identifier_fromJs(obj.identifier)
	return HealthElementAsserter.ExternalAsserterIdentifier(
		identifier = identifier,
	)
}
