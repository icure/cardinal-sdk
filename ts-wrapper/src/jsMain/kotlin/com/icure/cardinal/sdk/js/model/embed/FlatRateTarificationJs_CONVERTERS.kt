// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMapNullsafe
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.specializations.base64String_fromJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_toJs
import com.icure.cardinal.sdk.model.embed.DecryptedFlatRateTarification
import com.icure.cardinal.sdk.model.embed.DecryptedValorisation
import com.icure.cardinal.sdk.model.embed.EncryptedFlatRateTarification
import com.icure.cardinal.sdk.model.embed.EncryptedValorisation
import com.icure.cardinal.sdk.model.embed.FlatRateTarification
import com.icure.cardinal.sdk.model.embed.FlatRateType
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun flatRateTarification_toJs(obj: DecryptedFlatRateTarification): DecryptedFlatRateTarificationJs {
	val code = nullToUndefined(
		obj.code
	)
	val flatRateType = nullToUndefined(
		obj.flatRateType?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val label = nullToUndefined(
		mapToObject(
			obj.label,
			{ x1: String ->
				x1
			},
			{ x1: String ->
				x1
			},
		)
	)
	val valorisations = listToArray(
		obj.valorisations,
		{ x1: DecryptedValorisation ->
			valorisation_toJs(x1)
		},
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	return DecryptedFlatRateTarificationJs(js("{" +
		"code:code," +
		"flatRateType:flatRateType," +
		"label:label," +
		"valorisations:valorisations," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun flatRateTarification_fromJs(obj: DecryptedFlatRateTarificationJs): DecryptedFlatRateTarification {
	val code = undefinedToNull(obj.code)
	val flatRateType = obj.flatRateType?.let { nonNull1 ->
		FlatRateType.valueOf(nonNull1)
	}
	val label = objectToMapNullsafe(
		obj.label,
		"obj.label",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val valorisations = arrayToList(
		obj.valorisations,
		"obj.valorisations",
		{ x1: DecryptedValorisationJs ->
			valorisation_fromJs(x1)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return DecryptedFlatRateTarification(
		code = code,
		flatRateType = flatRateType,
		label = label,
		valorisations = valorisations,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun flatRateTarification_toJs(obj: EncryptedFlatRateTarification): EncryptedFlatRateTarificationJs {
	val code = nullToUndefined(
		obj.code
	)
	val flatRateType = nullToUndefined(
		obj.flatRateType?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val label = nullToUndefined(
		mapToObject(
			obj.label,
			{ x1: String ->
				x1
			},
			{ x1: String ->
				x1
			},
		)
	)
	val valorisations = listToArray(
		obj.valorisations,
		{ x1: EncryptedValorisation ->
			valorisation_toJs(x1)
		},
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	return EncryptedFlatRateTarificationJs(js("{" +
		"code:code," +
		"flatRateType:flatRateType," +
		"label:label," +
		"valorisations:valorisations," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun flatRateTarification_fromJs(obj: EncryptedFlatRateTarificationJs): EncryptedFlatRateTarification {
	val code = undefinedToNull(obj.code)
	val flatRateType = obj.flatRateType?.let { nonNull1 ->
		FlatRateType.valueOf(nonNull1)
	}
	val label = objectToMapNullsafe(
		obj.label,
		"obj.label",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val valorisations = arrayToList(
		obj.valorisations,
		"obj.valorisations",
		{ x1: EncryptedValorisationJs ->
			valorisation_fromJs(x1)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return EncryptedFlatRateTarification(
		code = code,
		flatRateType = flatRateType,
		label = label,
		valorisations = valorisations,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun flatRateTarification_toJs(obj: FlatRateTarification): FlatRateTarificationJs = when (obj) {
	is EncryptedFlatRateTarification -> flatRateTarification_toJs(obj)
	is DecryptedFlatRateTarification -> flatRateTarification_toJs(obj)
}

public fun flatRateTarification_fromJs(obj: FlatRateTarificationJs): FlatRateTarification = if (obj.isEncrypted) {
	flatRateTarification_fromJs(obj as EncryptedFlatRateTarificationJs)
} else {
	flatRateTarification_fromJs(obj as DecryptedFlatRateTarificationJs)
}
