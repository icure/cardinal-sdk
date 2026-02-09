// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.CodeApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.js.api.CodeApiJs
import com.icure.cardinal.sdk.js.api.CodeInGroupApiJs
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.BooleanResponseJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.CodeJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.booleanResponse_toJs
import com.icure.cardinal.sdk.js.model.code_fromJs
import com.icure.cardinal.sdk.js.model.code_toJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_toJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.Code
import com.icure.cardinal.sdk.model.GroupScoped
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
internal class CodeApiImplJs(
	private val codeApi: CodeApi,
) : CodeApiJs {
	override val inGroup: CodeInGroupApiJs = object : CodeInGroupApiJs {
		override fun createCode(code: GroupScopedJs<CodeJs>): Promise<GroupScopedJs<CodeJs>> =
				GlobalScope.promise {
			val codeConverted: GroupScoped<Code> = groupScoped_fromJs(
				code,
				{ x1: CodeJs ->
					code_fromJs(x1)
				},
			)
			val result = codeApi.inGroup.createCode(
				codeConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: Code ->
					code_toJs(x1)
				},
			)
		}

		override fun createCodes(codes: Array<GroupScopedJs<CodeJs>>):
				Promise<Array<GroupScopedJs<CodeJs>>> = GlobalScope.promise {
			val codesConverted: List<GroupScoped<Code>> = arrayToList(
				codes,
				"codes",
				{ x1: GroupScopedJs<CodeJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: CodeJs ->
							code_fromJs(x2)
						},
					)
				},
			)
			val result = codeApi.inGroup.createCodes(
				codesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Code> ->
					groupScoped_toJs(
						x1,
						{ x2: Code ->
							code_toJs(x2)
						},
					)
				},
			)
		}

		override fun getCode(groupId: String, codeId: String): Promise<GroupScopedJs<CodeJs>?> =
				GlobalScope.promise {
			val groupIdConverted: String = groupId
			val codeIdConverted: String = codeId
			val result = codeApi.inGroup.getCode(
				groupIdConverted,
				codeIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: Code ->
							code_toJs(x1)
						},
					)
				}
			)
		}

		override fun getCodes(groupId: String, codesIds: Array<String>):
				Promise<Array<GroupScopedJs<CodeJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val codesIdsConverted: List<String> = arrayToList(
				codesIds,
				"codesIds",
				{ x1: String ->
					x1
				},
			)
			val result = codeApi.inGroup.getCodes(
				groupIdConverted,
				codesIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Code> ->
					groupScoped_toJs(
						x1,
						{ x2: Code ->
							code_toJs(x2)
						},
					)
				},
			)
		}

		override fun modifyCode(code: GroupScopedJs<CodeJs>): Promise<GroupScopedJs<CodeJs>> =
				GlobalScope.promise {
			val codeConverted: GroupScoped<Code> = groupScoped_fromJs(
				code,
				{ x1: CodeJs ->
					code_fromJs(x1)
				},
			)
			val result = codeApi.inGroup.modifyCode(
				codeConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: Code ->
					code_toJs(x1)
				},
			)
		}

		override fun modifyCodes(codes: Array<GroupScopedJs<CodeJs>>):
				Promise<Array<GroupScopedJs<CodeJs>>> = GlobalScope.promise {
			val codesConverted: List<GroupScoped<Code>> = arrayToList(
				codes,
				"codes",
				{ x1: GroupScopedJs<CodeJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: CodeJs ->
							code_fromJs(x2)
						},
					)
				},
			)
			val result = codeApi.inGroup.modifyCodes(
				codesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Code> ->
					groupScoped_toJs(
						x1,
						{ x2: Code ->
							code_toJs(x2)
						},
					)
				},
			)
		}

		override fun deleteCodeById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = codeApi.inGroup.deleteCodeById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteCodeByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
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
			val result = codeApi.inGroup.deleteCodeByIds(
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

		override fun deleteCode(code: GroupScopedJs<CodeJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val codeConverted: GroupScoped<Code> = groupScoped_fromJs(
				code,
				{ x1: CodeJs ->
					code_fromJs(x1)
				},
			)
			val result = codeApi.inGroup.deleteCode(
				codeConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteCodes(codes: Array<GroupScopedJs<CodeJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val codesConverted: List<GroupScoped<Code>> = arrayToList(
				codes,
				"codes",
				{ x1: GroupScopedJs<CodeJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: CodeJs ->
							code_fromJs(x2)
						},
					)
				},
			)
			val result = codeApi.inGroup.deleteCodes(
				codesConverted,
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

		override fun undeleteCodeById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<CodeJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = codeApi.inGroup.undeleteCodeById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: Code ->
					code_toJs(x1)
				},
			)
		}

		override fun undeleteCodeByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<CodeJs>>> = GlobalScope.promise {
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
			val result = codeApi.inGroup.undeleteCodeByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Code> ->
					groupScoped_toJs(
						x1,
						{ x2: Code ->
							code_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteCode(code: GroupScopedJs<CodeJs>): Promise<GroupScopedJs<CodeJs>> =
				GlobalScope.promise {
			val codeConverted: GroupScoped<Code> = groupScoped_fromJs(
				code,
				{ x1: CodeJs ->
					code_fromJs(x1)
				},
			)
			val result = codeApi.inGroup.undeleteCode(
				codeConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: Code ->
					code_toJs(x1)
				},
			)
		}

		override fun undeleteCodes(codes: Array<GroupScopedJs<CodeJs>>):
				Promise<Array<GroupScopedJs<CodeJs>>> = GlobalScope.promise {
			val codesConverted: List<GroupScoped<Code>> = arrayToList(
				codes,
				"codes",
				{ x1: GroupScopedJs<CodeJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: CodeJs ->
							code_fromJs(x2)
						},
					)
				},
			)
			val result = codeApi.inGroup.undeleteCodes(
				codesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Code> ->
					groupScoped_toJs(
						x1,
						{ x2: Code ->
							code_toJs(x2)
						},
					)
				},
			)
		}

		override fun purgeCodeById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit> =
				GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			codeApi.inGroup.purgeCodeById(
				entityIdConverted,
			)

		}

		override fun purgeCodeByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
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
			val result = codeApi.inGroup.purgeCodeByIds(
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

		override fun purgeCode(code: GroupScopedJs<CodeJs>): Promise<Unit> = GlobalScope.promise {
			val codeConverted: GroupScoped<Code> = groupScoped_fromJs(
				code,
				{ x1: CodeJs ->
					code_fromJs(x1)
				},
			)
			codeApi.inGroup.purgeCode(
				codeConverted,
			)

		}

		override fun purgeCodes(codes: Array<GroupScopedJs<CodeJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val codesConverted: List<GroupScoped<Code>> = arrayToList(
				codes,
				"codes",
				{ x1: GroupScopedJs<CodeJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: CodeJs ->
							code_fromJs(x2)
						},
					)
				},
			)
			val result = codeApi.inGroup.purgeCodes(
				codesConverted,
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

		override fun filterCodesBy(groupId: String, filter: BaseFilterOptionsJs<CodeJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<CodeJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseFilterOptions<Code> = baseFilterOptions_fromJs(filter)
			val result = codeApi.inGroup.filterCodesBy(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<Code> ->
					groupScoped_toJs(
						x1,
						{ x2: Code ->
							code_toJs(x2)
						},
					)
				},
			)
		}

		override fun filterCodesBySorted(groupId: String, filter: BaseSortableFilterOptionsJs<CodeJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<CodeJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseSortableFilterOptions<Code> = baseSortableFilterOptions_fromJs(filter)
			val result = codeApi.inGroup.filterCodesBySorted(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<Code> ->
					groupScoped_toJs(
						x1,
						{ x2: Code ->
							code_toJs(x2)
						},
					)
				},
			)
		}

		override fun matchCodesBy(groupId: String, filter: BaseFilterOptionsJs<CodeJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseFilterOptions<Code> = baseFilterOptions_fromJs(filter)
			val result = codeApi.inGroup.matchCodesBy(
				groupIdConverted,
				filterConverted,
			)
			listToArray(
				result,
				{ x1: String ->
					x1
				},
			)
		}

		override fun matchCodesBySorted(groupId: String, filter: BaseSortableFilterOptionsJs<CodeJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseSortableFilterOptions<Code> = baseSortableFilterOptions_fromJs(filter)
			val result = codeApi.inGroup.matchCodesBySorted(
				groupIdConverted,
				filterConverted,
			)
			listToArray(
				result,
				{ x1: String ->
					x1
				},
			)
		}
	}

	override fun createCode(code: CodeJs): Promise<CodeJs> = GlobalScope.promise {
		val codeConverted: Code = code_fromJs(code)
		val result = codeApi.createCode(
			codeConverted,
		)
		code_toJs(result)
	}

	override fun createCodes(codes: Array<CodeJs>): Promise<Array<CodeJs>> = GlobalScope.promise {
		val codesConverted: List<Code> = arrayToList(
			codes,
			"codes",
			{ x1: CodeJs ->
				code_fromJs(x1)
			},
		)
		val result = codeApi.createCodes(
			codesConverted,
		)
		listToArray(
			result,
			{ x1: Code ->
				code_toJs(x1)
			},
		)
	}

	override fun getCode(codeId: String): Promise<CodeJs?> = GlobalScope.promise {
		val codeIdConverted: String = codeId
		val result = codeApi.getCode(
			codeIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				code_toJs(nonNull1)
			}
		)
	}

	override fun getCodes(codeIds: Array<String>): Promise<Array<CodeJs>> = GlobalScope.promise {
		val codeIdsConverted: List<String> = arrayToList(
			codeIds,
			"codeIds",
			{ x1: String ->
				x1
			},
		)
		val result = codeApi.getCodes(
			codeIdsConverted,
		)
		listToArray(
			result,
			{ x1: Code ->
				code_toJs(x1)
			},
		)
	}

	override fun modifyCode(code: CodeJs): Promise<CodeJs> = GlobalScope.promise {
		val codeConverted: Code = code_fromJs(code)
		val result = codeApi.modifyCode(
			codeConverted,
		)
		code_toJs(result)
	}

	override fun modifyCodes(codes: Array<CodeJs>): Promise<Array<CodeJs>> = GlobalScope.promise {
		val codesConverted: List<Code> = arrayToList(
			codes,
			"codes",
			{ x1: CodeJs ->
				code_fromJs(x1)
			},
		)
		val result = codeApi.modifyCodes(
			codesConverted,
		)
		listToArray(
			result,
			{ x1: Code ->
				code_toJs(x1)
			},
		)
	}

	override fun deleteCodeById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = codeApi.deleteCodeById(
			entityIdConverted,
			revConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteCodeByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = codeApi.deleteCodeByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteCode(code: CodeJs): Promise<StoredDocumentIdentifierJs> = GlobalScope.promise {
		val codeConverted: Code = code_fromJs(code)
		val result = codeApi.deleteCode(
			codeConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteCodes(codes: Array<CodeJs>): Promise<Array<StoredDocumentIdentifierJs>> =
			GlobalScope.promise {
		val codesConverted: List<Code> = arrayToList(
			codes,
			"codes",
			{ x1: CodeJs ->
				code_fromJs(x1)
			},
		)
		val result = codeApi.deleteCodes(
			codesConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun undeleteCodeById(entityId: String, rev: String): Promise<CodeJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = codeApi.undeleteCodeById(
			entityIdConverted,
			revConverted,
		)
		code_toJs(result)
	}

	override fun undeleteCodeByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<CodeJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = codeApi.undeleteCodeByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: Code ->
				code_toJs(x1)
			},
		)
	}

	override fun undeleteCode(code: CodeJs): Promise<CodeJs> = GlobalScope.promise {
		val codeConverted: Code = code_fromJs(code)
		val result = codeApi.undeleteCode(
			codeConverted,
		)
		code_toJs(result)
	}

	override fun undeleteCodes(codes: Array<CodeJs>): Promise<Array<CodeJs>> = GlobalScope.promise {
		val codesConverted: List<Code> = arrayToList(
			codes,
			"codes",
			{ x1: CodeJs ->
				code_fromJs(x1)
			},
		)
		val result = codeApi.undeleteCodes(
			codesConverted,
		)
		listToArray(
			result,
			{ x1: Code ->
				code_toJs(x1)
			},
		)
	}

	override fun purgeCodeById(entityId: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		codeApi.purgeCodeById(
			entityIdConverted,
			revConverted,
		)

	}

	override fun purgeCodeByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = codeApi.purgeCodeByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeCode(code: CodeJs): Promise<Unit> = GlobalScope.promise {
		val codeConverted: Code = code_fromJs(code)
		codeApi.purgeCode(
			codeConverted,
		)

	}

	override fun purgeCodes(codes: Array<CodeJs>): Promise<Array<StoredDocumentIdentifierJs>> =
			GlobalScope.promise {
		val codesConverted: List<Code> = arrayToList(
			codes,
			"codes",
			{ x1: CodeJs ->
				code_fromJs(x1)
			},
		)
		val result = codeApi.purgeCodes(
			codesConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun listCodeTypesBy(options: dynamic): Promise<Array<String>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val regionConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"region",
				null
			) { region: String? ->
				undefinedToNull(region)
			}
			val typeConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"type",
				null
			) { type: String? ->
				undefinedToNull(type)
			}
			val result = codeApi.listCodeTypesBy(
				regionConverted,
				typeConverted,
			)
			listToArray(
				result,
				{ x1: String ->
					x1
				},
			)
		}
	}

	override fun listTagTypesBy(options: dynamic): Promise<Array<String>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val regionConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"region",
				null
			) { region: String? ->
				undefinedToNull(region)
			}
			val typeConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"type",
				null
			) { type: String? ->
				undefinedToNull(type)
			}
			val result = codeApi.listTagTypesBy(
				regionConverted,
				typeConverted,
			)
			listToArray(
				result,
				{ x1: String ->
					x1
				},
			)
		}
	}

	override fun isCodeValid(
		type: String,
		code: String,
		version: String?,
	): Promise<BooleanResponseJs> = GlobalScope.promise {
		val typeConverted: String = type
		val codeConverted: String = code
		val versionConverted: String? = undefinedToNull(version)
		val result = codeApi.isCodeValid(
			typeConverted,
			codeConverted,
			versionConverted,
		)
		booleanResponse_toJs(result)
	}

	override fun getCodeByRegionLanguageTypeLabel(
		region: String,
		label: String,
		type: String,
		languages: String?,
	): Promise<CodeJs?> = GlobalScope.promise {
		val regionConverted: String = region
		val labelConverted: String = label
		val typeConverted: String = type
		val languagesConverted: String? = undefinedToNull(languages)
		val result = codeApi.getCodeByRegionLanguageTypeLabel(
			regionConverted,
			labelConverted,
			typeConverted,
			languagesConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				code_toJs(nonNull1)
			}
		)
	}

	override fun getCodeWithParts(
		type: String,
		code: String,
		version: String,
	): Promise<CodeJs?> = GlobalScope.promise {
		val typeConverted: String = type
		val codeConverted: String = code
		val versionConverted: String = version
		val result = codeApi.getCodeWithParts(
			typeConverted,
			codeConverted,
			versionConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				code_toJs(nonNull1)
			}
		)
	}

	override fun filterCodesBy(filter: BaseFilterOptionsJs<CodeJs>):
			Promise<PaginatedListIteratorJs<CodeJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Code> = baseFilterOptions_fromJs(filter)
		val result = codeApi.filterCodesBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: Code ->
				code_toJs(x1)
			},
		)
	}

	override fun filterCodesBySorted(filter: BaseSortableFilterOptionsJs<CodeJs>):
			Promise<PaginatedListIteratorJs<CodeJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Code> = baseSortableFilterOptions_fromJs(filter)
		val result = codeApi.filterCodesBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: Code ->
				code_toJs(x1)
			},
		)
	}

	override fun matchCodesBy(filter: BaseFilterOptionsJs<CodeJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Code> = baseFilterOptions_fromJs(filter)
		val result = codeApi.matchCodesBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchCodesBySorted(filter: BaseSortableFilterOptionsJs<CodeJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Code> = baseSortableFilterOptions_fromJs(filter)
		val result = codeApi.matchCodesBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}
}
