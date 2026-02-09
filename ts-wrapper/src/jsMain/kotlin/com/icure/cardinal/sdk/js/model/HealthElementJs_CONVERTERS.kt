// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.IdentifierJs
import com.icure.cardinal.sdk.js.model.base.codeStub_fromJs
import com.icure.cardinal.sdk.js.model.base.codeStub_toJs
import com.icure.cardinal.sdk.js.model.base.identifier_fromJs
import com.icure.cardinal.sdk.js.model.base.identifier_toJs
import com.icure.cardinal.sdk.js.model.embed.AnnotationJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedCareTeamMemberJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedEpisodeJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedPlanOfActionJs
import com.icure.cardinal.sdk.js.model.embed.DelegationJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedCareTeamMemberJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedEpisodeJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedPlanOfActionJs
import com.icure.cardinal.sdk.js.model.embed.annotation_fromJs
import com.icure.cardinal.sdk.js.model.embed.annotation_toJs
import com.icure.cardinal.sdk.js.model.embed.careTeamMember_fromJs
import com.icure.cardinal.sdk.js.model.embed.careTeamMember_toJs
import com.icure.cardinal.sdk.js.model.embed.delegation_fromJs
import com.icure.cardinal.sdk.js.model.embed.delegation_toJs
import com.icure.cardinal.sdk.js.model.embed.episode_fromJs
import com.icure.cardinal.sdk.js.model.embed.episode_toJs
import com.icure.cardinal.sdk.js.model.embed.planOfAction_fromJs
import com.icure.cardinal.sdk.js.model.embed.planOfAction_toJs
import com.icure.cardinal.sdk.js.model.embed.securityMetadata_fromJs
import com.icure.cardinal.sdk.js.model.embed.securityMetadata_toJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_fromJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_toJs
import com.icure.cardinal.sdk.model.DecryptedHealthElement
import com.icure.cardinal.sdk.model.EncryptedHealthElement
import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.embed.Annotation
import com.icure.cardinal.sdk.model.embed.DecryptedCareTeamMember
import com.icure.cardinal.sdk.model.embed.DecryptedEpisode
import com.icure.cardinal.sdk.model.embed.DecryptedPlanOfAction
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.EncryptedCareTeamMember
import com.icure.cardinal.sdk.model.embed.EncryptedEpisode
import com.icure.cardinal.sdk.model.embed.EncryptedPlanOfAction
import com.icure.cardinal.sdk.model.embed.Laterality
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Set

@Suppress("UNUSED_VARIABLE")
public fun healthElement_toJs(obj: DecryptedHealthElement): DecryptedHealthElementJs {
	val id = obj.id
	val identifiers = listToArray(
		obj.identifiers,
		{ x1: Identifier ->
			identifier_toJs(x1)
		},
	)
	val rev = nullToUndefined(
		obj.rev
	)
	val created = nullToUndefined(
		longToNumber(obj.created)
	)
	val modified = nullToUndefined(
		longToNumber(obj.modified)
	)
	val author = nullToUndefined(
		obj.author
	)
	val responsible = nullToUndefined(
		obj.responsible
	)
	val tags = setToArray(
		obj.tags,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val codes = setToArray(
		obj.codes,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val endOfLife = nullToUndefined(
		longToNumber(obj.endOfLife)
	)
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
	)
	val valueDate = nullToUndefined(
		longToNumber(obj.valueDate)
	)
	val openingDate = nullToUndefined(
		longToNumber(obj.openingDate)
	)
	val closingDate = nullToUndefined(
		longToNumber(obj.closingDate)
	)
	val descr = nullToUndefined(
		obj.descr
	)
	val note = nullToUndefined(
		obj.note
	)
	val notes = listToArray(
		obj.notes,
		{ x1: Annotation ->
			annotation_toJs(x1)
		},
	)
	val relevant = obj.relevant
	val idOpeningContact = nullToUndefined(
		obj.idOpeningContact
	)
	val idClosingContact = nullToUndefined(
		obj.idClosingContact
	)
	val idService = nullToUndefined(
		obj.idService
	)
	val laterality = nullToUndefined(
		obj.laterality?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val plansOfAction = listToArray(
		obj.plansOfAction,
		{ x1: DecryptedPlanOfAction ->
			planOfAction_toJs(x1)
		},
	)
	val episodes = listToArray(
		obj.episodes,
		{ x1: DecryptedEpisode ->
			episode_toJs(x1)
		},
	)
	val careTeam = listToArray(
		obj.careTeam,
		{ x1: DecryptedCareTeamMember ->
			careTeamMember_toJs(x1)
		},
	)
	val secretForeignKeys = setToArray(
		obj.secretForeignKeys,
		{ x1: String ->
			x1
		},
	)
	val cryptedForeignKeys = mapToObject(
		obj.cryptedForeignKeys,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val delegations = mapToObject(
		obj.delegations,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val encryptionKeys = mapToObject(
		obj.encryptionKeys,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	val securityMetadata = nullToUndefined(
		obj.securityMetadata?.let { nonNull1 ->
			securityMetadata_toJs(nonNull1)
		}
	)
	return DecryptedHealthElementJs(js("{" +
		"id:id," +
		"identifiers:identifiers," +
		"rev:rev," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"tags:tags," +
		"codes:codes," +
		"endOfLife:endOfLife," +
		"deletionDate:deletionDate," +
		"valueDate:valueDate," +
		"openingDate:openingDate," +
		"closingDate:closingDate," +
		"descr:descr," +
		"note:note," +
		"notes:notes," +
		"relevant:relevant," +
		"idOpeningContact:idOpeningContact," +
		"idClosingContact:idClosingContact," +
		"idService:idService," +
		"laterality:laterality," +
		"plansOfAction:plansOfAction," +
		"episodes:episodes," +
		"careTeam:careTeam," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata" +
	"}"))
}

public fun healthElement_fromJs(obj: DecryptedHealthElementJs): DecryptedHealthElement {
	val id = obj.id
	val identifiers = arrayToList(
		obj.identifiers,
		"obj.identifiers",
		{ x1: IdentifierJs ->
			identifier_fromJs(x1)
		},
	)
	val rev = undefinedToNull(obj.rev)
	val created = numberToLong(obj.created, "obj.created")
	val modified = numberToLong(obj.modified, "obj.modified")
	val author = undefinedToNull(obj.author)
	val responsible = undefinedToNull(obj.responsible)
	val tags = arrayToSet(
		obj.tags,
		"obj.tags",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val codes = arrayToSet(
		obj.codes,
		"obj.codes",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val endOfLife = numberToLong(obj.endOfLife, "obj.endOfLife")
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val valueDate = numberToLong(obj.valueDate, "obj.valueDate")
	val openingDate = numberToLong(obj.openingDate, "obj.openingDate")
	val closingDate = numberToLong(obj.closingDate, "obj.closingDate")
	val descr = undefinedToNull(obj.descr)
	val note = undefinedToNull(obj.note)
	val notes = arrayToList(
		obj.notes,
		"obj.notes",
		{ x1: AnnotationJs ->
			annotation_fromJs(x1)
		},
	)
	val relevant = obj.relevant
	val idOpeningContact = undefinedToNull(obj.idOpeningContact)
	val idClosingContact = undefinedToNull(obj.idClosingContact)
	val idService = undefinedToNull(obj.idService)
	val laterality = obj.laterality?.let { nonNull1 ->
		Laterality.valueOf(nonNull1)
	}
	val plansOfAction = arrayToList(
		obj.plansOfAction,
		"obj.plansOfAction",
		{ x1: DecryptedPlanOfActionJs ->
			planOfAction_fromJs(x1)
		},
	)
	val episodes = arrayToList(
		obj.episodes,
		"obj.episodes",
		{ x1: DecryptedEpisodeJs ->
			episode_fromJs(x1)
		},
	)
	val careTeam = arrayToList(
		obj.careTeam,
		"obj.careTeam",
		{ x1: DecryptedCareTeamMemberJs ->
			careTeamMember_fromJs(x1)
		},
	)
	val secretForeignKeys = arrayToSet(
		obj.secretForeignKeys,
		"obj.secretForeignKeys",
		{ x1: String ->
			x1
		},
	)
	val cryptedForeignKeys = objectToMap(
		obj.cryptedForeignKeys,
		"obj.cryptedForeignKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val delegations = objectToMap(
		obj.delegations,
		"obj.delegations",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val encryptionKeys = objectToMap(
		obj.encryptionKeys,
		"obj.encryptionKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_fromJs(nonNull1)
	}
	return DecryptedHealthElement(
		id = id,
		identifiers = identifiers,
		rev = rev,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		tags = tags,
		codes = codes,
		endOfLife = endOfLife,
		deletionDate = deletionDate,
		valueDate = valueDate,
		openingDate = openingDate,
		closingDate = closingDate,
		descr = descr,
		note = note,
		notes = notes,
		relevant = relevant,
		idOpeningContact = idOpeningContact,
		idClosingContact = idClosingContact,
		idService = idService,
		laterality = laterality,
		plansOfAction = plansOfAction,
		episodes = episodes,
		careTeam = careTeam,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun healthElement_toJs(obj: EncryptedHealthElement): EncryptedHealthElementJs {
	val id = obj.id
	val identifiers = listToArray(
		obj.identifiers,
		{ x1: Identifier ->
			identifier_toJs(x1)
		},
	)
	val rev = nullToUndefined(
		obj.rev
	)
	val created = nullToUndefined(
		longToNumber(obj.created)
	)
	val modified = nullToUndefined(
		longToNumber(obj.modified)
	)
	val author = nullToUndefined(
		obj.author
	)
	val responsible = nullToUndefined(
		obj.responsible
	)
	val tags = setToArray(
		obj.tags,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val codes = setToArray(
		obj.codes,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val endOfLife = nullToUndefined(
		longToNumber(obj.endOfLife)
	)
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
	)
	val valueDate = nullToUndefined(
		longToNumber(obj.valueDate)
	)
	val openingDate = nullToUndefined(
		longToNumber(obj.openingDate)
	)
	val closingDate = nullToUndefined(
		longToNumber(obj.closingDate)
	)
	val descr = nullToUndefined(
		obj.descr
	)
	val note = nullToUndefined(
		obj.note
	)
	val notes = listToArray(
		obj.notes,
		{ x1: Annotation ->
			annotation_toJs(x1)
		},
	)
	val relevant = obj.relevant
	val idOpeningContact = nullToUndefined(
		obj.idOpeningContact
	)
	val idClosingContact = nullToUndefined(
		obj.idClosingContact
	)
	val idService = nullToUndefined(
		obj.idService
	)
	val laterality = nullToUndefined(
		obj.laterality?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val plansOfAction = listToArray(
		obj.plansOfAction,
		{ x1: EncryptedPlanOfAction ->
			planOfAction_toJs(x1)
		},
	)
	val episodes = listToArray(
		obj.episodes,
		{ x1: EncryptedEpisode ->
			episode_toJs(x1)
		},
	)
	val careTeam = listToArray(
		obj.careTeam,
		{ x1: EncryptedCareTeamMember ->
			careTeamMember_toJs(x1)
		},
	)
	val secretForeignKeys = setToArray(
		obj.secretForeignKeys,
		{ x1: String ->
			x1
		},
	)
	val cryptedForeignKeys = mapToObject(
		obj.cryptedForeignKeys,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val delegations = mapToObject(
		obj.delegations,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val encryptionKeys = mapToObject(
		obj.encryptionKeys,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	val securityMetadata = nullToUndefined(
		obj.securityMetadata?.let { nonNull1 ->
			securityMetadata_toJs(nonNull1)
		}
	)
	return EncryptedHealthElementJs(js("{" +
		"id:id," +
		"identifiers:identifiers," +
		"rev:rev," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"tags:tags," +
		"codes:codes," +
		"endOfLife:endOfLife," +
		"deletionDate:deletionDate," +
		"valueDate:valueDate," +
		"openingDate:openingDate," +
		"closingDate:closingDate," +
		"descr:descr," +
		"note:note," +
		"notes:notes," +
		"relevant:relevant," +
		"idOpeningContact:idOpeningContact," +
		"idClosingContact:idClosingContact," +
		"idService:idService," +
		"laterality:laterality," +
		"plansOfAction:plansOfAction," +
		"episodes:episodes," +
		"careTeam:careTeam," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata" +
	"}"))
}

public fun healthElement_fromJs(obj: EncryptedHealthElementJs): EncryptedHealthElement {
	val id = obj.id
	val identifiers = arrayToList(
		obj.identifiers,
		"obj.identifiers",
		{ x1: IdentifierJs ->
			identifier_fromJs(x1)
		},
	)
	val rev = undefinedToNull(obj.rev)
	val created = numberToLong(obj.created, "obj.created")
	val modified = numberToLong(obj.modified, "obj.modified")
	val author = undefinedToNull(obj.author)
	val responsible = undefinedToNull(obj.responsible)
	val tags = arrayToSet(
		obj.tags,
		"obj.tags",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val codes = arrayToSet(
		obj.codes,
		"obj.codes",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val endOfLife = numberToLong(obj.endOfLife, "obj.endOfLife")
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val valueDate = numberToLong(obj.valueDate, "obj.valueDate")
	val openingDate = numberToLong(obj.openingDate, "obj.openingDate")
	val closingDate = numberToLong(obj.closingDate, "obj.closingDate")
	val descr = undefinedToNull(obj.descr)
	val note = undefinedToNull(obj.note)
	val notes = arrayToList(
		obj.notes,
		"obj.notes",
		{ x1: AnnotationJs ->
			annotation_fromJs(x1)
		},
	)
	val relevant = obj.relevant
	val idOpeningContact = undefinedToNull(obj.idOpeningContact)
	val idClosingContact = undefinedToNull(obj.idClosingContact)
	val idService = undefinedToNull(obj.idService)
	val laterality = obj.laterality?.let { nonNull1 ->
		Laterality.valueOf(nonNull1)
	}
	val plansOfAction = arrayToList(
		obj.plansOfAction,
		"obj.plansOfAction",
		{ x1: EncryptedPlanOfActionJs ->
			planOfAction_fromJs(x1)
		},
	)
	val episodes = arrayToList(
		obj.episodes,
		"obj.episodes",
		{ x1: EncryptedEpisodeJs ->
			episode_fromJs(x1)
		},
	)
	val careTeam = arrayToList(
		obj.careTeam,
		"obj.careTeam",
		{ x1: EncryptedCareTeamMemberJs ->
			careTeamMember_fromJs(x1)
		},
	)
	val secretForeignKeys = arrayToSet(
		obj.secretForeignKeys,
		"obj.secretForeignKeys",
		{ x1: String ->
			x1
		},
	)
	val cryptedForeignKeys = objectToMap(
		obj.cryptedForeignKeys,
		"obj.cryptedForeignKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val delegations = objectToMap(
		obj.delegations,
		"obj.delegations",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val encryptionKeys = objectToMap(
		obj.encryptionKeys,
		"obj.encryptionKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_fromJs(nonNull1)
	}
	return EncryptedHealthElement(
		id = id,
		identifiers = identifiers,
		rev = rev,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		tags = tags,
		codes = codes,
		endOfLife = endOfLife,
		deletionDate = deletionDate,
		valueDate = valueDate,
		openingDate = openingDate,
		closingDate = closingDate,
		descr = descr,
		note = note,
		notes = notes,
		relevant = relevant,
		idOpeningContact = idOpeningContact,
		idClosingContact = idClosingContact,
		idService = idService,
		laterality = laterality,
		plansOfAction = plansOfAction,
		episodes = episodes,
		careTeam = careTeam,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun healthElement_toJs(obj: HealthElement): HealthElementJs = when (obj) {
	is EncryptedHealthElement -> healthElement_toJs(obj)
	is DecryptedHealthElement -> healthElement_toJs(obj)
}

public fun healthElement_fromJs(obj: HealthElementJs): HealthElement = if (obj.isEncrypted) {
	healthElement_fromJs(obj as EncryptedHealthElementJs)
} else {
	healthElement_fromJs(obj as DecryptedHealthElementJs)
}
