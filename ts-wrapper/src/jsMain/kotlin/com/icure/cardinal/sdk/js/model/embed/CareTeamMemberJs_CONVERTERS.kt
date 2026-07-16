// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.dynamicToJsonObjectNullsafe
import com.icure.cardinal.sdk.js.model.CheckedConverters.jsonToDynamic
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.base.codeStub_fromJs
import com.icure.cardinal.sdk.js.model.base.codeStub_toJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_fromJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_toJs
import com.icure.cardinal.sdk.model.embed.CareTeamMember
import com.icure.cardinal.sdk.model.embed.CareTeamMemberType
import com.icure.cardinal.sdk.model.embed.DecryptedCareTeamMember
import com.icure.cardinal.sdk.model.embed.EncryptedCareTeamMember
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun careTeamMember_toJs(obj: DecryptedCareTeamMember): DecryptedCareTeamMemberJs {
	val id = obj.id
	val careTeamMemberType = nullToUndefined(
		obj.careTeamMemberType?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val healthcarePartyId = nullToUndefined(
		obj.healthcarePartyId
	)
	val quality = nullToUndefined(
		obj.quality?.let { nonNull1 ->
			codeStub_toJs(nonNull1)
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
	return DecryptedCareTeamMemberJs(js("{" +
		"id:id," +
		"careTeamMemberType:careTeamMemberType," +
		"healthcarePartyId:healthcarePartyId," +
		"quality:quality," +
		"encryptedSelf:encryptedSelf," +
		"extensions:extensions" +
	"}"))
}

public fun careTeamMember_fromJs(obj: DecryptedCareTeamMemberJs): DecryptedCareTeamMember {
	val id = obj.id
	val careTeamMemberType = obj.careTeamMemberType?.let { nonNull1 ->
		CareTeamMemberType.valueOf(nonNull1)
	}
	val healthcarePartyId = undefinedToNull(obj.healthcarePartyId)
	val quality = obj.quality?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	val extensions = dynamicToJsonObjectNullsafe(obj.extensions, "obj.extensions")
	return DecryptedCareTeamMember(
		id = id,
		careTeamMemberType = careTeamMemberType,
		healthcarePartyId = healthcarePartyId,
		quality = quality,
		encryptedSelf = encryptedSelf,
		extensions = extensions,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun careTeamMember_toJs(obj: EncryptedCareTeamMember): EncryptedCareTeamMemberJs {
	val id = obj.id
	val careTeamMemberType = nullToUndefined(
		obj.careTeamMemberType?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val healthcarePartyId = nullToUndefined(
		obj.healthcarePartyId
	)
	val quality = nullToUndefined(
		obj.quality?.let { nonNull1 ->
			codeStub_toJs(nonNull1)
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
	return EncryptedCareTeamMemberJs(js("{" +
		"id:id," +
		"careTeamMemberType:careTeamMemberType," +
		"healthcarePartyId:healthcarePartyId," +
		"quality:quality," +
		"encryptedSelf:encryptedSelf," +
		"extensions:extensions" +
	"}"))
}

public fun careTeamMember_fromJs(obj: EncryptedCareTeamMemberJs): EncryptedCareTeamMember {
	val id = obj.id
	val careTeamMemberType = obj.careTeamMemberType?.let { nonNull1 ->
		CareTeamMemberType.valueOf(nonNull1)
	}
	val healthcarePartyId = undefinedToNull(obj.healthcarePartyId)
	val quality = obj.quality?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	val extensions = dynamicToJsonObjectNullsafe(obj.extensions, "obj.extensions")
	return EncryptedCareTeamMember(
		id = id,
		careTeamMemberType = careTeamMemberType,
		healthcarePartyId = healthcarePartyId,
		quality = quality,
		encryptedSelf = encryptedSelf,
		extensions = extensions,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun careTeamMember_toJs(obj: CareTeamMember): CareTeamMemberJs = when (obj) {
	is EncryptedCareTeamMember -> careTeamMember_toJs(obj)
	is DecryptedCareTeamMember -> careTeamMember_toJs(obj)
}

public fun careTeamMember_fromJs(obj: CareTeamMemberJs): CareTeamMember = if (obj.isEncrypted) {
	careTeamMember_fromJs(obj as EncryptedCareTeamMemberJs)
} else {
	careTeamMember_fromJs(obj as DecryptedCareTeamMemberJs)
}
