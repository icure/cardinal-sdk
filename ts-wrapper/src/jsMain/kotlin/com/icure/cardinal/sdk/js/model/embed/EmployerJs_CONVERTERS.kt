// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.embed.Employer
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun employer_toJs(obj: Employer): EmployerJs {
	val name = nullToUndefined(
		obj.name
	)
	val addresse = nullToUndefined(
		obj.addresse?.let { nonNull1 ->
			address_toJs(nonNull1)
		}
	)
	return EmployerJs(js("{" +
		"name:name," +
		"addresse:addresse" +
	"}"))
}

public fun employer_fromJs(obj: EmployerJs): Employer {
	val name = undefinedToNull(obj.name)
	val addresse = obj.addresse?.let { nonNull1 ->
		address_fromJs(nonNull1)
	}
	return Employer(
		name = name,
		addresse = addresse,
	)
}
