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
import com.icure.cardinal.sdk.js.model.embed.address_fromJs
import com.icure.cardinal.sdk.js.model.embed.address_toJs
import com.icure.cardinal.sdk.model.Insurance
import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.Identifier
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun insurance_toJs(obj: Insurance): InsuranceJs {
	val id = obj.id
	val rev = nullToUndefined(
		obj.rev
	)
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
	)
	val name = mapToObject(
		obj.name,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val identifier = listToArray(
		obj.identifier,
		{ x1: Identifier ->
			identifier_toJs(x1)
		},
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
	val code = nullToUndefined(
		obj.code
	)
	val agreementNumber = nullToUndefined(
		obj.agreementNumber
	)
	val parent = nullToUndefined(
		obj.parent
	)
	val address = address_toJs(obj.address)
	return InsuranceJs(js("{" +
		"id:id," +
		"rev:rev," +
		"deletionDate:deletionDate," +
		"name:name," +
		"identifier:identifier," +
		"tags:tags," +
		"codes:codes," +
		"code:code," +
		"agreementNumber:agreementNumber," +
		"parent:parent," +
		"address:address" +
	"}"))
}

public fun insurance_fromJs(obj: InsuranceJs): Insurance {
	val id = obj.id
	val rev = undefinedToNull(obj.rev)
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val name = objectToMap(
		obj.name,
		"obj.name",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val identifier = arrayToList(
		obj.identifier,
		"obj.identifier",
		{ x1: IdentifierJs ->
			identifier_fromJs(x1)
		},
	)
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
	val code = undefinedToNull(obj.code)
	val agreementNumber = undefinedToNull(obj.agreementNumber)
	val parent = undefinedToNull(obj.parent)
	val address = address_fromJs(obj.address)
	return Insurance(
		id = id,
		rev = rev,
		deletionDate = deletionDate,
		name = name,
		identifier = identifier,
		tags = tags,
		codes = codes,
		code = code,
		agreementNumber = agreementNumber,
		parent = parent,
		address = address,
	)
}
