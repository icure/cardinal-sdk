// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.base.codeStub_fromJs
import com.icure.cardinal.sdk.js.model.base.codeStub_toJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_fromJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_toJs
import com.icure.cardinal.sdk.model.embed.DecryptedSchoolingInfo
import com.icure.cardinal.sdk.model.embed.EncryptedSchoolingInfo
import com.icure.cardinal.sdk.model.embed.SchoolingInfo
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun schoolingInfo_toJs(obj: DecryptedSchoolingInfo): DecryptedSchoolingInfoJs {
	val startDate = nullToUndefined(
		longToNumber(obj.startDate)
	)
	val endDate = nullToUndefined(
		longToNumber(obj.endDate)
	)
	val school = nullToUndefined(
		obj.school
	)
	val typeOfEducation = nullToUndefined(
		obj.typeOfEducation?.let { nonNull1 ->
			codeStub_toJs(nonNull1)
		}
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	return DecryptedSchoolingInfoJs(js("{" +
		"startDate:startDate," +
		"endDate:endDate," +
		"school:school," +
		"typeOfEducation:typeOfEducation," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun schoolingInfo_fromJs(obj: DecryptedSchoolingInfoJs): DecryptedSchoolingInfo {
	val startDate = numberToLong(obj.startDate, "obj.startDate")
	val endDate = numberToLong(obj.endDate, "obj.endDate")
	val school = undefinedToNull(obj.school)
	val typeOfEducation = obj.typeOfEducation?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return DecryptedSchoolingInfo(
		startDate = startDate,
		endDate = endDate,
		school = school,
		typeOfEducation = typeOfEducation,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun schoolingInfo_toJs(obj: EncryptedSchoolingInfo): EncryptedSchoolingInfoJs {
	val startDate = nullToUndefined(
		longToNumber(obj.startDate)
	)
	val endDate = nullToUndefined(
		longToNumber(obj.endDate)
	)
	val school = nullToUndefined(
		obj.school
	)
	val typeOfEducation = nullToUndefined(
		obj.typeOfEducation?.let { nonNull1 ->
			codeStub_toJs(nonNull1)
		}
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	return EncryptedSchoolingInfoJs(js("{" +
		"startDate:startDate," +
		"endDate:endDate," +
		"school:school," +
		"typeOfEducation:typeOfEducation," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun schoolingInfo_fromJs(obj: EncryptedSchoolingInfoJs): EncryptedSchoolingInfo {
	val startDate = numberToLong(obj.startDate, "obj.startDate")
	val endDate = numberToLong(obj.endDate, "obj.endDate")
	val school = undefinedToNull(obj.school)
	val typeOfEducation = obj.typeOfEducation?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return EncryptedSchoolingInfo(
		startDate = startDate,
		endDate = endDate,
		school = school,
		typeOfEducation = typeOfEducation,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun schoolingInfo_toJs(obj: SchoolingInfo): SchoolingInfoJs = when (obj) {
	is EncryptedSchoolingInfo -> schoolingInfo_toJs(obj)
	is DecryptedSchoolingInfo -> schoolingInfo_toJs(obj)
}

public fun schoolingInfo_fromJs(obj: SchoolingInfoJs): SchoolingInfo = if (obj.isEncrypted) {
	schoolingInfo_fromJs(obj as EncryptedSchoolingInfoJs)
} else {
	schoolingInfo_fromJs(obj as DecryptedSchoolingInfoJs)
}
