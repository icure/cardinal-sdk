// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.InsuranceApi
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.InsuranceApiJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.InsuranceJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.cardinal.sdk.js.model.insurance_fromJs
import com.icure.cardinal.sdk.js.model.insurance_toJs
import com.icure.cardinal.sdk.js.model.paginatedList_toJs
import com.icure.cardinal.sdk.model.Insurance
import kotlin.Array
import kotlin.Double
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class InsuranceApiImplJs(
	private val insuranceApi: InsuranceApi,
) : InsuranceApiJs {
	override fun getInsurance(insuranceId: String): Promise<InsuranceJs?> = GlobalScope.promise {
		val insuranceIdConverted: String = insuranceId
		val result = insuranceApi.getInsurance(
			insuranceIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				insurance_toJs(nonNull1)
			}
		)
	}

	override fun getInsurances(insuranceIds: Array<String>): Promise<Array<InsuranceJs>> =
			GlobalScope.promise {
		val insuranceIdsConverted: List<String> = arrayToList(
			insuranceIds,
			"insuranceIds",
			{ x1: String ->
				x1
			},
		)
		val result = insuranceApi.getInsurances(
			insuranceIdsConverted,
		)
		listToArray(
			result,
			{ x1: Insurance ->
				insurance_toJs(x1)
			},
		)
	}

	override fun createInsurance(insurance: InsuranceJs): Promise<InsuranceJs> = GlobalScope.promise {
		val insuranceConverted: Insurance = insurance_fromJs(insurance)
		val result = insuranceApi.createInsurance(
			insuranceConverted,
		)
		insurance_toJs(result)
	}

	override fun deleteInsurance(insuranceId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val insuranceIdConverted: String = insuranceId
		val result = insuranceApi.deleteInsurance(
			insuranceIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun getAllInsurances(options: dynamic): Promise<PaginatedListJs<InsuranceJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startDocumentId",
				null
			) { startDocumentId: String? ->
				undefinedToNull(startDocumentId)
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val result = insuranceApi.getAllInsurances(
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: Insurance ->
					insurance_toJs(x1)
				},
			)
		}
	}

	override fun listInsurancesByCode(insuranceCode: String): Promise<Array<InsuranceJs>> =
			GlobalScope.promise {
		val insuranceCodeConverted: String = insuranceCode
		val result = insuranceApi.listInsurancesByCode(
			insuranceCodeConverted,
		)
		listToArray(
			result,
			{ x1: Insurance ->
				insurance_toJs(x1)
			},
		)
	}

	override fun listInsurancesByName(insuranceName: String): Promise<Array<InsuranceJs>> =
			GlobalScope.promise {
		val insuranceNameConverted: String = insuranceName
		val result = insuranceApi.listInsurancesByName(
			insuranceNameConverted,
		)
		listToArray(
			result,
			{ x1: Insurance ->
				insurance_toJs(x1)
			},
		)
	}

	override fun modifyInsurance(insurance: InsuranceJs): Promise<InsuranceJs> = GlobalScope.promise {
		val insuranceConverted: Insurance = insurance_fromJs(insurance)
		val result = insuranceApi.modifyInsurance(
			insuranceConverted,
		)
		insurance_toJs(result)
	}

	override fun createInsurancesInGroup(groupId: String, insuranceBatch: Array<InsuranceJs>):
			Promise<Array<InsuranceJs>> = GlobalScope.promise {
		val groupIdConverted: String = groupId
		val insuranceBatchConverted: List<Insurance> = arrayToList(
			insuranceBatch,
			"insuranceBatch",
			{ x1: InsuranceJs ->
				insurance_fromJs(x1)
			},
		)
		val result = insuranceApi.createInsurancesInGroup(
			groupIdConverted,
			insuranceBatchConverted,
		)
		listToArray(
			result,
			{ x1: Insurance ->
				insurance_toJs(x1)
			},
		)
	}

	override fun getInsurancesInGroup(groupId: String, insuranceIds: Array<String>):
			Promise<Array<InsuranceJs>> = GlobalScope.promise {
		val groupIdConverted: String = groupId
		val insuranceIdsConverted: List<String> = arrayToList(
			insuranceIds,
			"insuranceIds",
			{ x1: String ->
				x1
			},
		)
		val result = insuranceApi.getInsurancesInGroup(
			groupIdConverted,
			insuranceIdsConverted,
		)
		listToArray(
			result,
			{ x1: Insurance ->
				insurance_toJs(x1)
			},
		)
	}

	override fun modifyInsurancesInGroup(groupId: String, insuranceBatch: Array<InsuranceJs>):
			Promise<Array<InsuranceJs>> = GlobalScope.promise {
		val groupIdConverted: String = groupId
		val insuranceBatchConverted: List<Insurance> = arrayToList(
			insuranceBatch,
			"insuranceBatch",
			{ x1: InsuranceJs ->
				insurance_fromJs(x1)
			},
		)
		val result = insuranceApi.modifyInsurancesInGroup(
			groupIdConverted,
			insuranceBatchConverted,
		)
		listToArray(
			result,
			{ x1: Insurance ->
				insurance_toJs(x1)
			},
		)
	}
}
