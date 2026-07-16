// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.instantToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInstant
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.specializations.base64String_fromJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_toJs
import com.icure.cardinal.sdk.model.embed.Content
import com.icure.cardinal.sdk.model.embed.DecryptedContent
import com.icure.cardinal.sdk.model.embed.DecryptedService
import com.icure.cardinal.sdk.model.embed.EncryptedContent
import com.icure.cardinal.sdk.model.embed.EncryptedService
import com.icure.cardinal.sdk.model.embed.Measure
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun content_toJs(obj: DecryptedContent): DecryptedContentJs {
	val stringValue = nullToUndefined(
		obj.stringValue
	)
	val numberValue = nullToUndefined(
		obj.numberValue
	)
	val booleanValue = nullToUndefined(
		obj.booleanValue
	)
	val instantValue = nullToUndefined(
		instantToNumber(obj.instantValue)
	)
	val fuzzyDateValue = nullToUndefined(
		longToNumber(obj.fuzzyDateValue)
	)
	val binaryValue = nullToUndefined(
		obj.binaryValue
	)
	val documentId = nullToUndefined(
		obj.documentId
	)
	val measureValue = nullToUndefined(
		obj.measureValue?.let { nonNull1 ->
			measure_toJs(nonNull1)
		}
	)
	val medicationValue = nullToUndefined(
		obj.medicationValue?.let { nonNull1 ->
			medication_toJs(nonNull1)
		}
	)
	val timeSeries = nullToUndefined(
		obj.timeSeries?.let { nonNull1 ->
			timeSeries_toJs(nonNull1)
		}
	)
	val compoundValue = nullToUndefined(
		listToArray(
			obj.compoundValue,
			{ x1: DecryptedService ->
				service_toJs(x1)
			},
		)
	)
	val ratio = nullToUndefined(
		listToArray(
			obj.ratio,
			{ x1: Measure ->
				measure_toJs(x1)
			},
		)
	)
	val range = nullToUndefined(
		listToArray(
			obj.range,
			{ x1: Measure ->
				measure_toJs(x1)
			},
		)
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	return DecryptedContentJs(js("{" +
		"stringValue:stringValue," +
		"numberValue:numberValue," +
		"booleanValue:booleanValue," +
		"instantValue:instantValue," +
		"fuzzyDateValue:fuzzyDateValue," +
		"binaryValue:binaryValue," +
		"documentId:documentId," +
		"measureValue:measureValue," +
		"medicationValue:medicationValue," +
		"timeSeries:timeSeries," +
		"compoundValue:compoundValue," +
		"ratio:ratio," +
		"range:range," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun content_fromJs(obj: DecryptedContentJs): DecryptedContent {
	val stringValue = undefinedToNull(obj.stringValue)
	val numberValue = undefinedToNull(obj.numberValue)
	val booleanValue = undefinedToNull(obj.booleanValue)
	val instantValue = numberToInstant(obj.instantValue, "obj.instantValue")
	val fuzzyDateValue = numberToLong(obj.fuzzyDateValue, "obj.fuzzyDateValue")
	val binaryValue = undefinedToNull(obj.binaryValue)
	val documentId = undefinedToNull(obj.documentId)
	val measureValue = obj.measureValue?.let { nonNull1 ->
		measure_fromJs(nonNull1)
	}
	val medicationValue = obj.medicationValue?.let { nonNull1 ->
		medication_fromJs(nonNull1)
	}
	val timeSeries = obj.timeSeries?.let { nonNull1 ->
		timeSeries_fromJs(nonNull1)
	}
	val compoundValue = arrayToList(
		obj.compoundValue,
		"obj.compoundValue",
		{ x1: DecryptedServiceJs ->
			service_fromJs(x1)
		},
	)
	val ratio = arrayToList(
		obj.ratio,
		"obj.ratio",
		{ x1: MeasureJs ->
			measure_fromJs(x1)
		},
	)
	val range = arrayToList(
		obj.range,
		"obj.range",
		{ x1: MeasureJs ->
			measure_fromJs(x1)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return DecryptedContent(
		stringValue = stringValue,
		numberValue = numberValue,
		booleanValue = booleanValue,
		instantValue = instantValue,
		fuzzyDateValue = fuzzyDateValue,
		binaryValue = binaryValue,
		documentId = documentId,
		measureValue = measureValue,
		medicationValue = medicationValue,
		timeSeries = timeSeries,
		compoundValue = compoundValue,
		ratio = ratio,
		range = range,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun content_toJs(obj: EncryptedContent): EncryptedContentJs {
	val stringValue = nullToUndefined(
		obj.stringValue
	)
	val numberValue = nullToUndefined(
		obj.numberValue
	)
	val booleanValue = nullToUndefined(
		obj.booleanValue
	)
	val instantValue = nullToUndefined(
		instantToNumber(obj.instantValue)
	)
	val fuzzyDateValue = nullToUndefined(
		longToNumber(obj.fuzzyDateValue)
	)
	val binaryValue = nullToUndefined(
		obj.binaryValue
	)
	val documentId = nullToUndefined(
		obj.documentId
	)
	val measureValue = nullToUndefined(
		obj.measureValue?.let { nonNull1 ->
			measure_toJs(nonNull1)
		}
	)
	val medicationValue = nullToUndefined(
		obj.medicationValue?.let { nonNull1 ->
			medication_toJs(nonNull1)
		}
	)
	val timeSeries = nullToUndefined(
		obj.timeSeries?.let { nonNull1 ->
			timeSeries_toJs(nonNull1)
		}
	)
	val compoundValue = nullToUndefined(
		listToArray(
			obj.compoundValue,
			{ x1: EncryptedService ->
				service_toJs(x1)
			},
		)
	)
	val ratio = nullToUndefined(
		listToArray(
			obj.ratio,
			{ x1: Measure ->
				measure_toJs(x1)
			},
		)
	)
	val range = nullToUndefined(
		listToArray(
			obj.range,
			{ x1: Measure ->
				measure_toJs(x1)
			},
		)
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	return EncryptedContentJs(js("{" +
		"stringValue:stringValue," +
		"numberValue:numberValue," +
		"booleanValue:booleanValue," +
		"instantValue:instantValue," +
		"fuzzyDateValue:fuzzyDateValue," +
		"binaryValue:binaryValue," +
		"documentId:documentId," +
		"measureValue:measureValue," +
		"medicationValue:medicationValue," +
		"timeSeries:timeSeries," +
		"compoundValue:compoundValue," +
		"ratio:ratio," +
		"range:range," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun content_fromJs(obj: EncryptedContentJs): EncryptedContent {
	val stringValue = undefinedToNull(obj.stringValue)
	val numberValue = undefinedToNull(obj.numberValue)
	val booleanValue = undefinedToNull(obj.booleanValue)
	val instantValue = numberToInstant(obj.instantValue, "obj.instantValue")
	val fuzzyDateValue = numberToLong(obj.fuzzyDateValue, "obj.fuzzyDateValue")
	val binaryValue = undefinedToNull(obj.binaryValue)
	val documentId = undefinedToNull(obj.documentId)
	val measureValue = obj.measureValue?.let { nonNull1 ->
		measure_fromJs(nonNull1)
	}
	val medicationValue = obj.medicationValue?.let { nonNull1 ->
		medication_fromJs(nonNull1)
	}
	val timeSeries = obj.timeSeries?.let { nonNull1 ->
		timeSeries_fromJs(nonNull1)
	}
	val compoundValue = arrayToList(
		obj.compoundValue,
		"obj.compoundValue",
		{ x1: EncryptedServiceJs ->
			service_fromJs(x1)
		},
	)
	val ratio = arrayToList(
		obj.ratio,
		"obj.ratio",
		{ x1: MeasureJs ->
			measure_fromJs(x1)
		},
	)
	val range = arrayToList(
		obj.range,
		"obj.range",
		{ x1: MeasureJs ->
			measure_fromJs(x1)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return EncryptedContent(
		stringValue = stringValue,
		numberValue = numberValue,
		booleanValue = booleanValue,
		instantValue = instantValue,
		fuzzyDateValue = fuzzyDateValue,
		binaryValue = binaryValue,
		documentId = documentId,
		measureValue = measureValue,
		medicationValue = medicationValue,
		timeSeries = timeSeries,
		compoundValue = compoundValue,
		ratio = ratio,
		range = range,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun content_toJs(obj: Content): ContentJs = when (obj) {
	is EncryptedContent -> content_toJs(obj)
	is DecryptedContent -> content_toJs(obj)
}

public fun content_fromJs(obj: ContentJs): Content = if (obj.isEncrypted) {
	content_fromJs(obj as EncryptedContentJs)
} else {
	content_fromJs(obj as DecryptedContentJs)
}
