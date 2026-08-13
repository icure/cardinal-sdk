// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.ClassificationApi
import com.icure.cardinal.sdk.crypto.entities.ClassificationShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.js.api.ClassificationApiJs
import com.icure.cardinal.sdk.js.api.ClassificationFlavouredApiJs
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.crypto.entities.BulkShareByIdsResultJs
import com.icure.cardinal.sdk.js.crypto.entities.ClassificationShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.SecretIdUseOptionJs
import com.icure.cardinal.sdk.js.crypto.entities.bulkShareByIdsResult_toJs
import com.icure.cardinal.sdk.js.crypto.entities.classificationShareOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.secretIdUseOption_fromJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.filterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.sortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.ClassificationJs
import com.icure.cardinal.sdk.js.model.DecryptedClassificationJs
import com.icure.cardinal.sdk.js.model.EncryptedClassificationJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.UserJs
import com.icure.cardinal.sdk.js.model.classification_fromJs
import com.icure.cardinal.sdk.js.model.classification_toJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.cardinal.sdk.js.model.patient_fromJs
import com.icure.cardinal.sdk.js.model.specializations.hexString_toJs
import com.icure.cardinal.sdk.js.model.user_fromJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.Classification
import com.icure.cardinal.sdk.model.DecryptedClassification
import com.icure.cardinal.sdk.model.EncryptedClassification
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class ClassificationApiImplJs(
	private val classificationApi: ClassificationApi,
) : ClassificationApiJs {
	override val encrypted: ClassificationFlavouredApiJs<EncryptedClassificationJs> = object :
			ClassificationFlavouredApiJs<EncryptedClassificationJs> {
		override fun shareWith(
			delegateId: String,
			classification: EncryptedClassificationJs,
			options: dynamic,
		): Promise<EncryptedClassificationJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val classificationConverted: EncryptedClassification = classification_fromJs(classification)
				val optionsConverted: ClassificationShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: ClassificationShareOptionsJs? ->
					options?.let { nonNull1 ->
						classificationShareOptions_fromJs(nonNull1)
					}
				}
				val result = classificationApi.encrypted.shareWith(
					delegateIdConverted,
					classificationConverted,
					optionsConverted,
				)
				classification_toJs(result)
			}
		}

		override fun shareWithMany(classification: EncryptedClassificationJs,
				delegates: Record<String, ClassificationShareOptionsJs>): Promise<EncryptedClassificationJs> =
				GlobalScope.promise {
			val classificationConverted: EncryptedClassification = classification_fromJs(classification)
			val delegatesConverted: Map<String, ClassificationShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: ClassificationShareOptionsJs ->
					classificationShareOptions_fromJs(x1)
				},
			)
			val result = classificationApi.encrypted.shareWithMany(
				classificationConverted,
				delegatesConverted,
			)
			classification_toJs(result)
		}

		override fun findClassificationsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			options: dynamic,
		): Promise<PaginatedListIteratorJs<EncryptedClassificationJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val hcPartyIdConverted: String = hcPartyId
				val patientConverted: Patient = patient_fromJs(patient)
				val startDateConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"startDate",
					null
				) { startDate: Double? ->
					numberToLong(startDate, "startDate")
				}
				val endDateConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"endDate",
					null
				) { endDate: Double? ->
					numberToLong(endDate, "endDate")
				}
				val descendingConverted: Boolean? = convertingOptionOrDefaultNullable(
					_options,
					"descending",
					null
				) { descending: Boolean? ->
					undefinedToNull(descending)
				}
				val result = classificationApi.encrypted.findClassificationsByHcPartyPatient(
					hcPartyIdConverted,
					patientConverted,
					startDateConverted,
					endDateConverted,
					descendingConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: EncryptedClassification ->
						classification_toJs(x1)
					},
				)
			}
		}

		override fun filterClassificationsBy(filter: FilterOptionsJs<ClassificationJs>):
				Promise<PaginatedListIteratorJs<EncryptedClassificationJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<Classification> = filterOptions_fromJs(filter)
			val result = classificationApi.encrypted.filterClassificationsBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedClassification ->
					classification_toJs(x1)
				},
			)
		}

		override fun filterClassificationsBySorted(filter: SortableFilterOptionsJs<ClassificationJs>):
				Promise<PaginatedListIteratorJs<EncryptedClassificationJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<Classification> = sortableFilterOptions_fromJs(filter)
			val result = classificationApi.encrypted.filterClassificationsBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedClassification ->
					classification_toJs(x1)
				},
			)
		}

		override fun createClassification(entity: EncryptedClassificationJs):
				Promise<EncryptedClassificationJs> = GlobalScope.promise {
			val entityConverted: EncryptedClassification = classification_fromJs(entity)
			val result = classificationApi.encrypted.createClassification(
				entityConverted,
			)
			classification_toJs(result)
		}

		override fun modifyClassification(entity: EncryptedClassificationJs):
				Promise<EncryptedClassificationJs> = GlobalScope.promise {
			val entityConverted: EncryptedClassification = classification_fromJs(entity)
			val result = classificationApi.encrypted.modifyClassification(
				entityConverted,
			)
			classification_toJs(result)
		}

		override fun getClassification(entityId: String): Promise<EncryptedClassificationJs?> =
				GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = classificationApi.encrypted.getClassification(
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					classification_toJs(nonNull1)
				}
			)
		}

		override fun getClassifications(entityIds: Array<String>):
				Promise<Array<EncryptedClassificationJs>> = GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = classificationApi.encrypted.getClassifications(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedClassification ->
					classification_toJs(x1)
				},
			)
		}
	}

	override val tryAndRecover: ClassificationFlavouredApiJs<ClassificationJs> = object :
			ClassificationFlavouredApiJs<ClassificationJs> {
		override fun shareWith(
			delegateId: String,
			classification: ClassificationJs,
			options: dynamic,
		): Promise<ClassificationJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val classificationConverted: Classification = classification_fromJs(classification)
				val optionsConverted: ClassificationShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: ClassificationShareOptionsJs? ->
					options?.let { nonNull1 ->
						classificationShareOptions_fromJs(nonNull1)
					}
				}
				val result = classificationApi.tryAndRecover.shareWith(
					delegateIdConverted,
					classificationConverted,
					optionsConverted,
				)
				classification_toJs(result)
			}
		}

		override fun shareWithMany(classification: ClassificationJs,
				delegates: Record<String, ClassificationShareOptionsJs>): Promise<ClassificationJs> =
				GlobalScope.promise {
			val classificationConverted: Classification = classification_fromJs(classification)
			val delegatesConverted: Map<String, ClassificationShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: ClassificationShareOptionsJs ->
					classificationShareOptions_fromJs(x1)
				},
			)
			val result = classificationApi.tryAndRecover.shareWithMany(
				classificationConverted,
				delegatesConverted,
			)
			classification_toJs(result)
		}

		override fun findClassificationsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			options: dynamic,
		): Promise<PaginatedListIteratorJs<ClassificationJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val hcPartyIdConverted: String = hcPartyId
				val patientConverted: Patient = patient_fromJs(patient)
				val startDateConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"startDate",
					null
				) { startDate: Double? ->
					numberToLong(startDate, "startDate")
				}
				val endDateConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"endDate",
					null
				) { endDate: Double? ->
					numberToLong(endDate, "endDate")
				}
				val descendingConverted: Boolean? = convertingOptionOrDefaultNullable(
					_options,
					"descending",
					null
				) { descending: Boolean? ->
					undefinedToNull(descending)
				}
				val result = classificationApi.tryAndRecover.findClassificationsByHcPartyPatient(
					hcPartyIdConverted,
					patientConverted,
					startDateConverted,
					endDateConverted,
					descendingConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: Classification ->
						classification_toJs(x1)
					},
				)
			}
		}

		override fun filterClassificationsBy(filter: FilterOptionsJs<ClassificationJs>):
				Promise<PaginatedListIteratorJs<ClassificationJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<Classification> = filterOptions_fromJs(filter)
			val result = classificationApi.tryAndRecover.filterClassificationsBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: Classification ->
					classification_toJs(x1)
				},
			)
		}

		override fun filterClassificationsBySorted(filter: SortableFilterOptionsJs<ClassificationJs>):
				Promise<PaginatedListIteratorJs<ClassificationJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<Classification> = sortableFilterOptions_fromJs(filter)
			val result = classificationApi.tryAndRecover.filterClassificationsBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: Classification ->
					classification_toJs(x1)
				},
			)
		}

		override fun createClassification(entity: ClassificationJs): Promise<ClassificationJs> =
				GlobalScope.promise {
			val entityConverted: Classification = classification_fromJs(entity)
			val result = classificationApi.tryAndRecover.createClassification(
				entityConverted,
			)
			classification_toJs(result)
		}

		override fun modifyClassification(entity: ClassificationJs): Promise<ClassificationJs> =
				GlobalScope.promise {
			val entityConverted: Classification = classification_fromJs(entity)
			val result = classificationApi.tryAndRecover.modifyClassification(
				entityConverted,
			)
			classification_toJs(result)
		}

		override fun getClassification(entityId: String): Promise<ClassificationJs?> =
				GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = classificationApi.tryAndRecover.getClassification(
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					classification_toJs(nonNull1)
				}
			)
		}

		override fun getClassifications(entityIds: Array<String>): Promise<Array<ClassificationJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = classificationApi.tryAndRecover.getClassifications(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: Classification ->
					classification_toJs(x1)
				},
			)
		}
	}

	override fun withEncryptionMetadata(
		base: DecryptedClassificationJs?,
		patient: PatientJs,
		options: dynamic,
	): Promise<DecryptedClassificationJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedClassification? = base?.let { nonNull1 ->
				classification_fromJs(nonNull1)
			}
			val patientConverted: Patient = patient_fromJs(patient)
			val userConverted: User? = convertingOptionOrDefaultNullable(
				_options,
				"user",
				null
			) { user: UserJs? ->
				user?.let { nonNull1 ->
					user_fromJs(nonNull1)
				}
			}
			val delegatesConverted: Map<String, AccessLevel> = convertingOptionOrDefaultNonNull(
				_options,
				"delegates",
				emptyMap()
			) { delegates: Record<String, String> ->
				objectToMap(
					delegates,
					"delegates",
					{ x1: String ->
						x1
					},
					{ x1: String ->
						AccessLevel.valueOf(x1)
					},
				)
			}
			val secretIdConverted: SecretIdUseOption = convertingOptionOrDefaultNonNull(
				_options,
				"secretId",
				com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithHierarchy
			) { secretId: SecretIdUseOptionJs ->
				secretIdUseOption_fromJs(secretId)
			}
			val alternateRootDelegateIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"alternateRootDelegateId",
				null
			) { alternateRootDelegateId: String? ->
				undefinedToNull(alternateRootDelegateId)
			}
			val result = classificationApi.withEncryptionMetadata(
				baseConverted,
				patientConverted,
				userConverted,
				delegatesConverted,
				secretIdConverted,
				alternateRootDelegateIdConverted,
			)
			classification_toJs(result)
		}
	}

	override fun getEncryptionKeysOf(classification: ClassificationJs): Promise<Array<String>> =
			GlobalScope.promise {
		val classificationConverted: Classification = classification_fromJs(classification)
		val result = classificationApi.getEncryptionKeysOf(
			classificationConverted,
		)
		setToArray(
			result,
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)
	}

	override fun hasWriteAccess(classification: ClassificationJs): Promise<Boolean> =
			GlobalScope.promise {
		val classificationConverted: Classification = classification_fromJs(classification)
		val result = classificationApi.hasWriteAccess(
			classificationConverted,
		)
		result
	}

	override fun decryptPatientIdOf(classification: ClassificationJs): Promise<Array<String>> =
			GlobalScope.promise {
		val classificationConverted: Classification = classification_fromJs(classification)
		val result = classificationApi.decryptPatientIdOf(
			classificationConverted,
		)
		setToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun createDelegationDeAnonymizationMetadata(entity: ClassificationJs,
			delegates: Array<String>): Promise<Unit> = GlobalScope.promise {
		val entityConverted: Classification = classification_fromJs(entity)
		val delegatesConverted: Set<String> = arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		)
		classificationApi.createDelegationDeAnonymizationMetadata(
			entityConverted,
			delegatesConverted,
		)

	}

	override fun decrypt(classification: EncryptedClassificationJs): Promise<DecryptedClassificationJs>
			= GlobalScope.promise {
		val classificationConverted: EncryptedClassification = classification_fromJs(classification)
		val result = classificationApi.decrypt(
			classificationConverted,
		)
		classification_toJs(result)
	}

	override fun tryDecrypt(classification: EncryptedClassificationJs): Promise<ClassificationJs> =
			GlobalScope.promise {
		val classificationConverted: EncryptedClassification = classification_fromJs(classification)
		val result = classificationApi.tryDecrypt(
			classificationConverted,
		)
		classification_toJs(result)
	}

	override fun matchClassificationsBy(filter: FilterOptionsJs<ClassificationJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: FilterOptions<Classification> = filterOptions_fromJs(filter)
		val result = classificationApi.matchClassificationsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchClassificationsBySorted(filter: SortableFilterOptionsJs<ClassificationJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<Classification> = sortableFilterOptions_fromJs(filter)
		val result = classificationApi.matchClassificationsBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun shareClassificationsByIds(classificationIds: Array<String>,
			delegates: Record<String, ClassificationShareOptionsJs>): Promise<BulkShareByIdsResultJs> =
			GlobalScope.promise {
		val classificationIdsConverted: List<String> = arrayToList(
			classificationIds,
			"classificationIds",
			{ x1: String ->
				x1
			},
		)
		val delegatesConverted: Map<String, ClassificationShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: ClassificationShareOptionsJs ->
				classificationShareOptions_fromJs(x1)
			},
		)
		val result = classificationApi.shareClassificationsByIds(
			classificationIdsConverted,
			delegatesConverted,
		)
		bulkShareByIdsResult_toJs(result)
	}

	override fun deleteClassification(entityId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = classificationApi.deleteClassification(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteClassifications(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = classificationApi.deleteClassifications(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun shareWith(
		delegateId: String,
		classification: DecryptedClassificationJs,
		options: dynamic,
	): Promise<DecryptedClassificationJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val classificationConverted: DecryptedClassification = classification_fromJs(classification)
			val optionsConverted: ClassificationShareOptions? = convertingOptionOrDefaultNullable(
				_options,
				"options",
				null
			) { options: ClassificationShareOptionsJs? ->
				options?.let { nonNull1 ->
					classificationShareOptions_fromJs(nonNull1)
				}
			}
			val result = classificationApi.shareWith(
				delegateIdConverted,
				classificationConverted,
				optionsConverted,
			)
			classification_toJs(result)
		}
	}

	override fun shareWithMany(classification: DecryptedClassificationJs,
			delegates: Record<String, ClassificationShareOptionsJs>): Promise<DecryptedClassificationJs> =
			GlobalScope.promise {
		val classificationConverted: DecryptedClassification = classification_fromJs(classification)
		val delegatesConverted: Map<String, ClassificationShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: ClassificationShareOptionsJs ->
				classificationShareOptions_fromJs(x1)
			},
		)
		val result = classificationApi.shareWithMany(
			classificationConverted,
			delegatesConverted,
		)
		classification_toJs(result)
	}

	override fun findClassificationsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: dynamic,
	): Promise<PaginatedListIteratorJs<DecryptedClassificationJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val patientConverted: Patient = patient_fromJs(patient)
			val startDateConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"startDate",
				null
			) { startDate: Double? ->
				numberToLong(startDate, "startDate")
			}
			val endDateConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"endDate",
				null
			) { endDate: Double? ->
				numberToLong(endDate, "endDate")
			}
			val descendingConverted: Boolean? = convertingOptionOrDefaultNullable(
				_options,
				"descending",
				null
			) { descending: Boolean? ->
				undefinedToNull(descending)
			}
			val result = classificationApi.findClassificationsByHcPartyPatient(
				hcPartyIdConverted,
				patientConverted,
				startDateConverted,
				endDateConverted,
				descendingConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: DecryptedClassification ->
					classification_toJs(x1)
				},
			)
		}
	}

	override fun filterClassificationsBy(filter: FilterOptionsJs<ClassificationJs>):
			Promise<PaginatedListIteratorJs<DecryptedClassificationJs>> = GlobalScope.promise {
		val filterConverted: FilterOptions<Classification> = filterOptions_fromJs(filter)
		val result = classificationApi.filterClassificationsBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedClassification ->
				classification_toJs(x1)
			},
		)
	}

	override fun filterClassificationsBySorted(filter: SortableFilterOptionsJs<ClassificationJs>):
			Promise<PaginatedListIteratorJs<DecryptedClassificationJs>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<Classification> = sortableFilterOptions_fromJs(filter)
		val result = classificationApi.filterClassificationsBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedClassification ->
				classification_toJs(x1)
			},
		)
	}

	override fun createClassification(entity: DecryptedClassificationJs):
			Promise<DecryptedClassificationJs> = GlobalScope.promise {
		val entityConverted: DecryptedClassification = classification_fromJs(entity)
		val result = classificationApi.createClassification(
			entityConverted,
		)
		classification_toJs(result)
	}

	override fun modifyClassification(entity: DecryptedClassificationJs):
			Promise<DecryptedClassificationJs> = GlobalScope.promise {
		val entityConverted: DecryptedClassification = classification_fromJs(entity)
		val result = classificationApi.modifyClassification(
			entityConverted,
		)
		classification_toJs(result)
	}

	override fun getClassification(entityId: String): Promise<DecryptedClassificationJs?> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = classificationApi.getClassification(
			entityIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				classification_toJs(nonNull1)
			}
		)
	}

	override fun getClassifications(entityIds: Array<String>):
			Promise<Array<DecryptedClassificationJs>> = GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = classificationApi.getClassifications(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedClassification ->
				classification_toJs(x1)
			},
		)
	}
}
