// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.embed.typedValue_fromJs
import com.icure.cardinal.sdk.js.model.embed.typedValue_toJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_fromJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_toJs
import com.icure.cardinal.sdk.model.DecryptedPropertyStub
import com.icure.cardinal.sdk.model.EncryptedPropertyStub
import com.icure.cardinal.sdk.model.PropertyStub
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun propertyStub_toJs(obj: DecryptedPropertyStub): DecryptedPropertyStubJs {
	val id = nullToUndefined(
		obj.id
	)
	val type = nullToUndefined(
		obj.type?.let { nonNull1 ->
			propertyTypeStub_toJs(nonNull1)
		}
	)
	val typedValue = nullToUndefined(
		obj.typedValue?.let { nonNull1 ->
			typedValue_toJs(nonNull1)
		}
	)
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	return DecryptedPropertyStubJs(js("{" +
		"id:id," +
		"type:type," +
		"typedValue:typedValue," +
		"deletionDate:deletionDate," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun propertyStub_fromJs(obj: DecryptedPropertyStubJs): DecryptedPropertyStub {
	val id = undefinedToNull(obj.id)
	val type = obj.type?.let { nonNull1 ->
		propertyTypeStub_fromJs(nonNull1)
	}
	val typedValue = obj.typedValue?.let { nonNull1 ->
		typedValue_fromJs(nonNull1)
	}
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return DecryptedPropertyStub(
		id = id,
		type = type,
		typedValue = typedValue,
		deletionDate = deletionDate,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun propertyStub_toJs(obj: EncryptedPropertyStub): EncryptedPropertyStubJs {
	val id = nullToUndefined(
		obj.id
	)
	val type = nullToUndefined(
		obj.type?.let { nonNull1 ->
			propertyTypeStub_toJs(nonNull1)
		}
	)
	val typedValue = nullToUndefined(
		obj.typedValue?.let { nonNull1 ->
			typedValue_toJs(nonNull1)
		}
	)
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	return EncryptedPropertyStubJs(js("{" +
		"id:id," +
		"type:type," +
		"typedValue:typedValue," +
		"deletionDate:deletionDate," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun propertyStub_fromJs(obj: EncryptedPropertyStubJs): EncryptedPropertyStub {
	val id = undefinedToNull(obj.id)
	val type = obj.type?.let { nonNull1 ->
		propertyTypeStub_fromJs(nonNull1)
	}
	val typedValue = obj.typedValue?.let { nonNull1 ->
		typedValue_fromJs(nonNull1)
	}
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return EncryptedPropertyStub(
		id = id,
		type = type,
		typedValue = typedValue,
		deletionDate = deletionDate,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun propertyStub_toJs(obj: PropertyStub): PropertyStubJs = when (obj) {
	is EncryptedPropertyStub -> propertyStub_toJs(obj)
	is DecryptedPropertyStub -> propertyStub_toJs(obj)
}

public fun propertyStub_fromJs(obj: PropertyStubJs): PropertyStub = if (obj.isEncrypted) {
	propertyStub_fromJs(obj as EncryptedPropertyStubJs)
} else {
	propertyStub_fromJs(obj as DecryptedPropertyStubJs)
}
