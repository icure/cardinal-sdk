// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.InsuranceApi
import com.icure.cardinal.sdk.js.api.InsuranceApiJs
import com.icure.cardinal.sdk.js.api.InsuranceInGroupApiJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.InsuranceJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
import com.icure.cardinal.sdk.js.model.insurance_fromJs
import com.icure.cardinal.sdk.js.model.insurance_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_toJs
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Insurance
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import kotlin.Array
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class InsuranceApiImplJs(
	private val insuranceApi: InsuranceApi,
) : InsuranceApiJs {
	override val inGroup: InsuranceInGroupApiJs = object : InsuranceInGroupApiJs {
		override fun createInsurance(insurance: GroupScopedJs<InsuranceJs>):
				Promise<GroupScopedJs<InsuranceJs>> = GlobalScope.promise {
			val insuranceConverted: GroupScoped<Insurance> = groupScoped_fromJs(
				insurance,
				{ x1: InsuranceJs ->
					insurance_fromJs(x1)
				},
			)
			val result = insuranceApi.inGroup.createInsurance(
				insuranceConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: Insurance ->
					insurance_toJs(x1)
				},
			)
		}

		override fun createInsurances(insurances: Array<GroupScopedJs<InsuranceJs>>):
				Promise<Array<GroupScopedJs<InsuranceJs>>> = GlobalScope.promise {
			val insurancesConverted: List<GroupScoped<Insurance>> = arrayToList(
				insurances,
				"insurances",
				{ x1: GroupScopedJs<InsuranceJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: InsuranceJs ->
							insurance_fromJs(x2)
						},
					)
				},
			)
			val result = insuranceApi.inGroup.createInsurances(
				insurancesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Insurance> ->
					groupScoped_toJs(
						x1,
						{ x2: Insurance ->
							insurance_toJs(x2)
						},
					)
				},
			)
		}

		override fun getInsurance(groupId: String, insuranceId: String):
				Promise<GroupScopedJs<InsuranceJs>?> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val insuranceIdConverted: String = insuranceId
			val result = insuranceApi.inGroup.getInsurance(
				groupIdConverted,
				insuranceIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: Insurance ->
							insurance_toJs(x1)
						},
					)
				}
			)
		}

		override fun getInsurances(groupId: String, insurancesIds: Array<String>):
				Promise<Array<GroupScopedJs<InsuranceJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val insurancesIdsConverted: List<String> = arrayToList(
				insurancesIds,
				"insurancesIds",
				{ x1: String ->
					x1
				},
			)
			val result = insuranceApi.inGroup.getInsurances(
				groupIdConverted,
				insurancesIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Insurance> ->
					groupScoped_toJs(
						x1,
						{ x2: Insurance ->
							insurance_toJs(x2)
						},
					)
				},
			)
		}

		override fun modifyInsurance(insurance: GroupScopedJs<InsuranceJs>):
				Promise<GroupScopedJs<InsuranceJs>> = GlobalScope.promise {
			val insuranceConverted: GroupScoped<Insurance> = groupScoped_fromJs(
				insurance,
				{ x1: InsuranceJs ->
					insurance_fromJs(x1)
				},
			)
			val result = insuranceApi.inGroup.modifyInsurance(
				insuranceConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: Insurance ->
					insurance_toJs(x1)
				},
			)
		}

		override fun modifyInsurances(insurances: Array<GroupScopedJs<InsuranceJs>>):
				Promise<Array<GroupScopedJs<InsuranceJs>>> = GlobalScope.promise {
			val insurancesConverted: List<GroupScoped<Insurance>> = arrayToList(
				insurances,
				"insurances",
				{ x1: GroupScopedJs<InsuranceJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: InsuranceJs ->
							insurance_fromJs(x2)
						},
					)
				},
			)
			val result = insuranceApi.inGroup.modifyInsurances(
				insurancesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Insurance> ->
					groupScoped_toJs(
						x1,
						{ x2: Insurance ->
							insurance_toJs(x2)
						},
					)
				},
			)
		}

		override fun deleteInsuranceById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = insuranceApi.inGroup.deleteInsuranceById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteInsuranceByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val entityIdsConverted: List<GroupScoped<StoredDocumentIdentifier>> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: GroupScopedJs<StoredDocumentIdentifierJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: StoredDocumentIdentifierJs ->
							storedDocumentIdentifier_fromJs(x2)
						},
					)
				},
			)
			val result = insuranceApi.inGroup.deleteInsuranceByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}

		override fun deleteInsurance(insurance: GroupScopedJs<InsuranceJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val insuranceConverted: GroupScoped<Insurance> = groupScoped_fromJs(
				insurance,
				{ x1: InsuranceJs ->
					insurance_fromJs(x1)
				},
			)
			val result = insuranceApi.inGroup.deleteInsurance(
				insuranceConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteInsurances(insurances: Array<GroupScopedJs<InsuranceJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val insurancesConverted: List<GroupScoped<Insurance>> = arrayToList(
				insurances,
				"insurances",
				{ x1: GroupScopedJs<InsuranceJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: InsuranceJs ->
							insurance_fromJs(x2)
						},
					)
				},
			)
			val result = insuranceApi.inGroup.deleteInsurances(
				insurancesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteInsuranceById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<InsuranceJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = insuranceApi.inGroup.undeleteInsuranceById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: Insurance ->
					insurance_toJs(x1)
				},
			)
		}

		override fun undeleteInsuranceByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<InsuranceJs>>> = GlobalScope.promise {
			val entityIdsConverted: List<GroupScoped<StoredDocumentIdentifier>> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: GroupScopedJs<StoredDocumentIdentifierJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: StoredDocumentIdentifierJs ->
							storedDocumentIdentifier_fromJs(x2)
						},
					)
				},
			)
			val result = insuranceApi.inGroup.undeleteInsuranceByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Insurance> ->
					groupScoped_toJs(
						x1,
						{ x2: Insurance ->
							insurance_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteInsurance(insurance: GroupScopedJs<InsuranceJs>):
				Promise<GroupScopedJs<InsuranceJs>> = GlobalScope.promise {
			val insuranceConverted: GroupScoped<Insurance> = groupScoped_fromJs(
				insurance,
				{ x1: InsuranceJs ->
					insurance_fromJs(x1)
				},
			)
			val result = insuranceApi.inGroup.undeleteInsurance(
				insuranceConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: Insurance ->
					insurance_toJs(x1)
				},
			)
		}

		override fun undeleteInsurances(insurances: Array<GroupScopedJs<InsuranceJs>>):
				Promise<Array<GroupScopedJs<InsuranceJs>>> = GlobalScope.promise {
			val insurancesConverted: List<GroupScoped<Insurance>> = arrayToList(
				insurances,
				"insurances",
				{ x1: GroupScopedJs<InsuranceJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: InsuranceJs ->
							insurance_fromJs(x2)
						},
					)
				},
			)
			val result = insuranceApi.inGroup.undeleteInsurances(
				insurancesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Insurance> ->
					groupScoped_toJs(
						x1,
						{ x2: Insurance ->
							insurance_toJs(x2)
						},
					)
				},
			)
		}

		override fun purgeInsuranceById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<Unit> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			insuranceApi.inGroup.purgeInsuranceById(
				entityIdConverted,
			)

		}

		override fun purgeInsuranceByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val entityIdsConverted: List<GroupScoped<StoredDocumentIdentifier>> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: GroupScopedJs<StoredDocumentIdentifierJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: StoredDocumentIdentifierJs ->
							storedDocumentIdentifier_fromJs(x2)
						},
					)
				},
			)
			val result = insuranceApi.inGroup.purgeInsuranceByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}

		override fun purgeInsurance(insurance: GroupScopedJs<InsuranceJs>): Promise<Unit> =
				GlobalScope.promise {
			val insuranceConverted: GroupScoped<Insurance> = groupScoped_fromJs(
				insurance,
				{ x1: InsuranceJs ->
					insurance_fromJs(x1)
				},
			)
			insuranceApi.inGroup.purgeInsurance(
				insuranceConverted,
			)

		}

		override fun purgeInsurances(insurances: Array<GroupScopedJs<InsuranceJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val insurancesConverted: List<GroupScoped<Insurance>> = arrayToList(
				insurances,
				"insurances",
				{ x1: GroupScopedJs<InsuranceJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: InsuranceJs ->
							insurance_fromJs(x2)
						},
					)
				},
			)
			val result = insuranceApi.inGroup.purgeInsurances(
				insurancesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}
	}

	override fun createInsurance(insurance: InsuranceJs): Promise<InsuranceJs> = GlobalScope.promise {
		val insuranceConverted: Insurance = insurance_fromJs(insurance)
		val result = insuranceApi.createInsurance(
			insuranceConverted,
		)
		insurance_toJs(result)
	}

	override fun createInsurances(insurances: Array<InsuranceJs>): Promise<Array<InsuranceJs>> =
			GlobalScope.promise {
		val insurancesConverted: List<Insurance> = arrayToList(
			insurances,
			"insurances",
			{ x1: InsuranceJs ->
				insurance_fromJs(x1)
			},
		)
		val result = insuranceApi.createInsurances(
			insurancesConverted,
		)
		listToArray(
			result,
			{ x1: Insurance ->
				insurance_toJs(x1)
			},
		)
	}

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

	override fun getInsurances(insurancesIds: Array<String>): Promise<Array<InsuranceJs>> =
			GlobalScope.promise {
		val insurancesIdsConverted: List<String> = arrayToList(
			insurancesIds,
			"insurancesIds",
			{ x1: String ->
				x1
			},
		)
		val result = insuranceApi.getInsurances(
			insurancesIdsConverted,
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

	override fun modifyInsurances(insurances: Array<InsuranceJs>): Promise<Array<InsuranceJs>> =
			GlobalScope.promise {
		val insurancesConverted: List<Insurance> = arrayToList(
			insurances,
			"insurances",
			{ x1: InsuranceJs ->
				insurance_fromJs(x1)
			},
		)
		val result = insuranceApi.modifyInsurances(
			insurancesConverted,
		)
		listToArray(
			result,
			{ x1: Insurance ->
				insurance_toJs(x1)
			},
		)
	}

	override fun deleteInsuranceById(entityId: String, rev: String):
			Promise<StoredDocumentIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = insuranceApi.deleteInsuranceById(
			entityIdConverted,
			revConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteInsuranceByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = insuranceApi.deleteInsuranceByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteInsurance(insurance: InsuranceJs): Promise<StoredDocumentIdentifierJs> =
			GlobalScope.promise {
		val insuranceConverted: Insurance = insurance_fromJs(insurance)
		val result = insuranceApi.deleteInsurance(
			insuranceConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteInsurances(insurances: Array<InsuranceJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val insurancesConverted: List<Insurance> = arrayToList(
			insurances,
			"insurances",
			{ x1: InsuranceJs ->
				insurance_fromJs(x1)
			},
		)
		val result = insuranceApi.deleteInsurances(
			insurancesConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun undeleteInsuranceById(entityId: String, rev: String): Promise<InsuranceJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = insuranceApi.undeleteInsuranceById(
			entityIdConverted,
			revConverted,
		)
		insurance_toJs(result)
	}

	override fun undeleteInsuranceByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<InsuranceJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = insuranceApi.undeleteInsuranceByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: Insurance ->
				insurance_toJs(x1)
			},
		)
	}

	override fun undeleteInsurance(insurance: InsuranceJs): Promise<InsuranceJs> =
			GlobalScope.promise {
		val insuranceConverted: Insurance = insurance_fromJs(insurance)
		val result = insuranceApi.undeleteInsurance(
			insuranceConverted,
		)
		insurance_toJs(result)
	}

	override fun undeleteInsurances(insurances: Array<InsuranceJs>): Promise<Array<InsuranceJs>> =
			GlobalScope.promise {
		val insurancesConverted: List<Insurance> = arrayToList(
			insurances,
			"insurances",
			{ x1: InsuranceJs ->
				insurance_fromJs(x1)
			},
		)
		val result = insuranceApi.undeleteInsurances(
			insurancesConverted,
		)
		listToArray(
			result,
			{ x1: Insurance ->
				insurance_toJs(x1)
			},
		)
	}

	override fun purgeInsuranceById(entityId: String, rev: String): Promise<Unit> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		insuranceApi.purgeInsuranceById(
			entityIdConverted,
			revConverted,
		)

	}

	override fun purgeInsuranceByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = insuranceApi.purgeInsuranceByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeInsurance(insurance: InsuranceJs): Promise<Unit> = GlobalScope.promise {
		val insuranceConverted: Insurance = insurance_fromJs(insurance)
		insuranceApi.purgeInsurance(
			insuranceConverted,
		)

	}

	override fun purgeInsurances(insurances: Array<InsuranceJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val insurancesConverted: List<Insurance> = arrayToList(
			insurances,
			"insurances",
			{ x1: InsuranceJs ->
				insurance_fromJs(x1)
			},
		)
		val result = insuranceApi.purgeInsurances(
			insurancesConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
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
}
