// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.IdentifierJs
import com.icure.cardinal.sdk.js.model.base.codeStub_fromJs
import com.icure.cardinal.sdk.js.model.base.codeStub_toJs
import com.icure.cardinal.sdk.js.model.base.identifier_fromJs
import com.icure.cardinal.sdk.js.model.base.identifier_toJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_fromJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_toJs
import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.embed.Address
import com.icure.cardinal.sdk.model.embed.AddressType
import com.icure.cardinal.sdk.model.embed.DecryptedAddress
import com.icure.cardinal.sdk.model.embed.DecryptedAnnotation
import com.icure.cardinal.sdk.model.embed.DecryptedTelecom
import com.icure.cardinal.sdk.model.embed.EncryptedAddress
import com.icure.cardinal.sdk.model.embed.EncryptedAnnotation
import com.icure.cardinal.sdk.model.embed.EncryptedTelecom
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun address_toJs(obj: DecryptedAddress): DecryptedAddressJs {
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
	val identifier = listToArray(
		obj.identifier,
		{ x1: Identifier ->
			identifier_toJs(x1)
		},
	)
	val addressType = nullToUndefined(
		obj.addressType?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val descr = nullToUndefined(
		obj.descr
	)
	val street = nullToUndefined(
		obj.street
	)
	val houseNumber = nullToUndefined(
		obj.houseNumber
	)
	val postboxNumber = nullToUndefined(
		obj.postboxNumber
	)
	val postalCode = nullToUndefined(
		obj.postalCode
	)
	val city = nullToUndefined(
		obj.city
	)
	val state = nullToUndefined(
		obj.state
	)
	val country = nullToUndefined(
		obj.country
	)
	val note = nullToUndefined(
		obj.note
	)
	val notes = listToArray(
		obj.notes,
		{ x1: DecryptedAnnotation ->
			annotation_toJs(x1)
		},
	)
	val telecoms = listToArray(
		obj.telecoms,
		{ x1: DecryptedTelecom ->
			telecom_toJs(x1)
		},
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	return DecryptedAddressJs(js("{" +
		"tags:tags," +
		"codes:codes," +
		"identifier:identifier," +
		"addressType:addressType," +
		"descr:descr," +
		"street:street," +
		"houseNumber:houseNumber," +
		"postboxNumber:postboxNumber," +
		"postalCode:postalCode," +
		"city:city," +
		"state:state," +
		"country:country," +
		"note:note," +
		"notes:notes," +
		"telecoms:telecoms," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun address_fromJs(obj: DecryptedAddressJs): DecryptedAddress {
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
	val identifier = arrayToList(
		obj.identifier,
		"obj.identifier",
		{ x1: IdentifierJs ->
			identifier_fromJs(x1)
		},
	)
	val addressType = obj.addressType?.let { nonNull1 ->
		AddressType.valueOf(nonNull1)
	}
	val descr = undefinedToNull(obj.descr)
	val street = undefinedToNull(obj.street)
	val houseNumber = undefinedToNull(obj.houseNumber)
	val postboxNumber = undefinedToNull(obj.postboxNumber)
	val postalCode = undefinedToNull(obj.postalCode)
	val city = undefinedToNull(obj.city)
	val state = undefinedToNull(obj.state)
	val country = undefinedToNull(obj.country)
	val note = undefinedToNull(obj.note)
	val notes = arrayToList(
		obj.notes,
		"obj.notes",
		{ x1: DecryptedAnnotationJs ->
			annotation_fromJs(x1)
		},
	)
	val telecoms = arrayToList(
		obj.telecoms,
		"obj.telecoms",
		{ x1: DecryptedTelecomJs ->
			telecom_fromJs(x1)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return DecryptedAddress(
		tags = tags,
		codes = codes,
		identifier = identifier,
		addressType = addressType,
		descr = descr,
		street = street,
		houseNumber = houseNumber,
		postboxNumber = postboxNumber,
		postalCode = postalCode,
		city = city,
		state = state,
		country = country,
		note = note,
		notes = notes,
		telecoms = telecoms,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun address_toJs(obj: EncryptedAddress): EncryptedAddressJs {
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
	val identifier = listToArray(
		obj.identifier,
		{ x1: Identifier ->
			identifier_toJs(x1)
		},
	)
	val addressType = nullToUndefined(
		obj.addressType?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val descr = nullToUndefined(
		obj.descr
	)
	val street = nullToUndefined(
		obj.street
	)
	val houseNumber = nullToUndefined(
		obj.houseNumber
	)
	val postboxNumber = nullToUndefined(
		obj.postboxNumber
	)
	val postalCode = nullToUndefined(
		obj.postalCode
	)
	val city = nullToUndefined(
		obj.city
	)
	val state = nullToUndefined(
		obj.state
	)
	val country = nullToUndefined(
		obj.country
	)
	val note = nullToUndefined(
		obj.note
	)
	val notes = listToArray(
		obj.notes,
		{ x1: EncryptedAnnotation ->
			annotation_toJs(x1)
		},
	)
	val telecoms = listToArray(
		obj.telecoms,
		{ x1: EncryptedTelecom ->
			telecom_toJs(x1)
		},
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	return EncryptedAddressJs(js("{" +
		"tags:tags," +
		"codes:codes," +
		"identifier:identifier," +
		"addressType:addressType," +
		"descr:descr," +
		"street:street," +
		"houseNumber:houseNumber," +
		"postboxNumber:postboxNumber," +
		"postalCode:postalCode," +
		"city:city," +
		"state:state," +
		"country:country," +
		"note:note," +
		"notes:notes," +
		"telecoms:telecoms," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun address_fromJs(obj: EncryptedAddressJs): EncryptedAddress {
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
	val identifier = arrayToList(
		obj.identifier,
		"obj.identifier",
		{ x1: IdentifierJs ->
			identifier_fromJs(x1)
		},
	)
	val addressType = obj.addressType?.let { nonNull1 ->
		AddressType.valueOf(nonNull1)
	}
	val descr = undefinedToNull(obj.descr)
	val street = undefinedToNull(obj.street)
	val houseNumber = undefinedToNull(obj.houseNumber)
	val postboxNumber = undefinedToNull(obj.postboxNumber)
	val postalCode = undefinedToNull(obj.postalCode)
	val city = undefinedToNull(obj.city)
	val state = undefinedToNull(obj.state)
	val country = undefinedToNull(obj.country)
	val note = undefinedToNull(obj.note)
	val notes = arrayToList(
		obj.notes,
		"obj.notes",
		{ x1: EncryptedAnnotationJs ->
			annotation_fromJs(x1)
		},
	)
	val telecoms = arrayToList(
		obj.telecoms,
		"obj.telecoms",
		{ x1: EncryptedTelecomJs ->
			telecom_fromJs(x1)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return EncryptedAddress(
		tags = tags,
		codes = codes,
		identifier = identifier,
		addressType = addressType,
		descr = descr,
		street = street,
		houseNumber = houseNumber,
		postboxNumber = postboxNumber,
		postalCode = postalCode,
		city = city,
		state = state,
		country = country,
		note = note,
		notes = notes,
		telecoms = telecoms,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun address_toJs(obj: Address): AddressJs = when (obj) {
	is EncryptedAddress -> address_toJs(obj)
	is DecryptedAddress -> address_toJs(obj)
}

public fun address_fromJs(obj: AddressJs): Address = if (obj.isEncrypted) {
	address_fromJs(obj as EncryptedAddressJs)
} else {
	address_fromJs(obj as DecryptedAddressJs)
}
