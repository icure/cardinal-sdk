// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.dynamicToJsonObjectNullsafe
import com.icure.cardinal.sdk.js.model.CheckedConverters.jsonToDynamic
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.specializations.base64String_fromJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_toJs
import com.icure.cardinal.sdk.model.embed.CareTeamMembership
import com.icure.cardinal.sdk.model.embed.DecryptedCareTeamMembership
import com.icure.cardinal.sdk.model.embed.EncryptedCareTeamMembership
import com.icure.cardinal.sdk.model.embed.MembershipType
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun careTeamMembership_toJs(obj: DecryptedCareTeamMembership):
		DecryptedCareTeamMembershipJs {
	val startDate = nullToUndefined(
		longToNumber(obj.startDate)
	)
	val endDate = nullToUndefined(
		longToNumber(obj.endDate)
	)
	val careTeamMemberId = nullToUndefined(
		obj.careTeamMemberId
	)
	val membershipType = nullToUndefined(
		obj.membershipType?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	val extensions = nullToUndefined(
		jsonToDynamic(obj.extensions)
	)
	return DecryptedCareTeamMembershipJs(js("{" +
		"startDate:startDate," +
		"endDate:endDate," +
		"careTeamMemberId:careTeamMemberId," +
		"membershipType:membershipType," +
		"encryptedSelf:encryptedSelf," +
		"extensions:extensions" +
	"}"))
}

public fun careTeamMembership_fromJs(obj: DecryptedCareTeamMembershipJs):
		DecryptedCareTeamMembership {
	val startDate = numberToLong(obj.startDate, "obj.startDate")
	val endDate = numberToLong(obj.endDate, "obj.endDate")
	val careTeamMemberId = undefinedToNull(obj.careTeamMemberId)
	val membershipType = obj.membershipType?.let { nonNull1 ->
		MembershipType.valueOf(nonNull1)
	}
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	val extensions = dynamicToJsonObjectNullsafe(obj.extensions, "obj.extensions")
	return DecryptedCareTeamMembership(
		startDate = startDate,
		endDate = endDate,
		careTeamMemberId = careTeamMemberId,
		membershipType = membershipType,
		encryptedSelf = encryptedSelf,
		extensions = extensions,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun careTeamMembership_toJs(obj: EncryptedCareTeamMembership):
		EncryptedCareTeamMembershipJs {
	val startDate = nullToUndefined(
		longToNumber(obj.startDate)
	)
	val endDate = nullToUndefined(
		longToNumber(obj.endDate)
	)
	val careTeamMemberId = nullToUndefined(
		obj.careTeamMemberId
	)
	val membershipType = nullToUndefined(
		obj.membershipType?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	val extensions = nullToUndefined(
		jsonToDynamic(obj.extensions)
	)
	return EncryptedCareTeamMembershipJs(js("{" +
		"startDate:startDate," +
		"endDate:endDate," +
		"careTeamMemberId:careTeamMemberId," +
		"membershipType:membershipType," +
		"encryptedSelf:encryptedSelf," +
		"extensions:extensions" +
	"}"))
}

public fun careTeamMembership_fromJs(obj: EncryptedCareTeamMembershipJs):
		EncryptedCareTeamMembership {
	val startDate = numberToLong(obj.startDate, "obj.startDate")
	val endDate = numberToLong(obj.endDate, "obj.endDate")
	val careTeamMemberId = undefinedToNull(obj.careTeamMemberId)
	val membershipType = obj.membershipType?.let { nonNull1 ->
		MembershipType.valueOf(nonNull1)
	}
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	val extensions = dynamicToJsonObjectNullsafe(obj.extensions, "obj.extensions")
	return EncryptedCareTeamMembership(
		startDate = startDate,
		endDate = endDate,
		careTeamMemberId = careTeamMemberId,
		membershipType = membershipType,
		encryptedSelf = encryptedSelf,
		extensions = extensions,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun careTeamMembership_toJs(obj: CareTeamMembership): CareTeamMembershipJs = when (obj) {
	is EncryptedCareTeamMembership -> careTeamMembership_toJs(obj)
	is DecryptedCareTeamMembership -> careTeamMembership_toJs(obj)
}

public fun careTeamMembership_fromJs(obj: CareTeamMembershipJs): CareTeamMembership = if
		(obj.isEncrypted) {
	careTeamMembership_fromJs(obj as EncryptedCareTeamMembershipJs)
} else {
	careTeamMembership_fromJs(obj as DecryptedCareTeamMembershipJs)
}
