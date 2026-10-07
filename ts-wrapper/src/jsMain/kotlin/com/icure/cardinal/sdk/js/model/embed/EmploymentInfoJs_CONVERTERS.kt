// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.base.codeStub_fromJs
import com.icure.cardinal.sdk.js.model.base.codeStub_toJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_fromJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_toJs
import com.icure.cardinal.sdk.model.embed.DecryptedEmploymentInfo
import com.icure.cardinal.sdk.model.embed.EmploymentInfo
import com.icure.cardinal.sdk.model.embed.EncryptedEmploymentInfo
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun employmentInfo_toJs(obj: DecryptedEmploymentInfo): DecryptedEmploymentInfoJs {
	val startDate = nullToUndefined(
		longToNumber(obj.startDate)
	)
	val endDate = nullToUndefined(
		longToNumber(obj.endDate)
	)
	val professionType = nullToUndefined(
		obj.professionType?.let { nonNull1 ->
			codeStub_toJs(nonNull1)
		}
	)
	val employer = nullToUndefined(
		obj.employer?.let { nonNull1 ->
			employer_toJs(nonNull1)
		}
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	return DecryptedEmploymentInfoJs(js("{" +
		"startDate:startDate," +
		"endDate:endDate," +
		"professionType:professionType," +
		"employer:employer," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun employmentInfo_fromJs(obj: DecryptedEmploymentInfoJs): DecryptedEmploymentInfo {
	val startDate = numberToLong(obj.startDate, "obj.startDate")
	val endDate = numberToLong(obj.endDate, "obj.endDate")
	val professionType = obj.professionType?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val employer = obj.employer?.let { nonNull1 ->
		employer_fromJs(nonNull1)
	}
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return DecryptedEmploymentInfo(
		startDate = startDate,
		endDate = endDate,
		professionType = professionType,
		employer = employer,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun employmentInfo_toJs(obj: EncryptedEmploymentInfo): EncryptedEmploymentInfoJs {
	val startDate = nullToUndefined(
		longToNumber(obj.startDate)
	)
	val endDate = nullToUndefined(
		longToNumber(obj.endDate)
	)
	val professionType = nullToUndefined(
		obj.professionType?.let { nonNull1 ->
			codeStub_toJs(nonNull1)
		}
	)
	val employer = nullToUndefined(
		obj.employer?.let { nonNull1 ->
			employer_toJs(nonNull1)
		}
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	return EncryptedEmploymentInfoJs(js("{" +
		"startDate:startDate," +
		"endDate:endDate," +
		"professionType:professionType," +
		"employer:employer," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun employmentInfo_fromJs(obj: EncryptedEmploymentInfoJs): EncryptedEmploymentInfo {
	val startDate = numberToLong(obj.startDate, "obj.startDate")
	val endDate = numberToLong(obj.endDate, "obj.endDate")
	val professionType = obj.professionType?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val employer = obj.employer?.let { nonNull1 ->
		employer_fromJs(nonNull1)
	}
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return EncryptedEmploymentInfo(
		startDate = startDate,
		endDate = endDate,
		professionType = professionType,
		employer = employer,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun employmentInfo_toJs(obj: EmploymentInfo): EmploymentInfoJs = when (obj) {
	is EncryptedEmploymentInfo -> employmentInfo_toJs(obj)
	is DecryptedEmploymentInfo -> employmentInfo_toJs(obj)
}

public fun employmentInfo_fromJs(obj: EmploymentInfoJs): EmploymentInfo = if (obj.isEncrypted) {
	employmentInfo_fromJs(obj as EncryptedEmploymentInfoJs)
} else {
	employmentInfo_fromJs(obj as DecryptedEmploymentInfoJs)
}
