// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.InvoiceApi
import com.icure.cardinal.sdk.crypto.entities.InvoiceShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.InvoiceApiJs
import com.icure.cardinal.sdk.js.api.InvoiceFlavouredApiJs
import com.icure.cardinal.sdk.js.api.InvoiceFlavouredInGroupApiJs
import com.icure.cardinal.sdk.js.api.InvoiceInGroupApiJs
import com.icure.cardinal.sdk.js.crypto.entities.InvoiceShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.SecretIdUseOptionJs
import com.icure.cardinal.sdk.js.crypto.entities.invoiceShareOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.secretIdUseOption_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.DecryptedInvoiceJs
import com.icure.cardinal.sdk.js.model.EncryptedInvoiceJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.InvoiceJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.UserJs
import com.icure.cardinal.sdk.js.model.`data`.LabelledOccurenceJs
import com.icure.cardinal.sdk.js.model.`data`.labelledOccurence_toJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedInvoicingCodeJs
import com.icure.cardinal.sdk.js.model.embed.invoicingCode_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
import com.icure.cardinal.sdk.js.model.invoice_fromJs
import com.icure.cardinal.sdk.js.model.invoice_toJs
import com.icure.cardinal.sdk.js.model.paginatedList_toJs
import com.icure.cardinal.sdk.js.model.patient_fromJs
import com.icure.cardinal.sdk.js.model.specializations.hexString_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_toJs
import com.icure.cardinal.sdk.js.model.user_fromJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToAccessLevelMapObject_delegate_accessLevel
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToAccessLevelMapObject_delegate_accessLevel_fromJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToInvoiceShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToInvoiceShareOptionsMapObject_delegate_shareOptions_fromJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.DecryptedInvoice
import com.icure.cardinal.sdk.model.EncryptedInvoice
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Invoice
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.`data`.LabelledOccurence
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.EncryptedInvoicingCode
import com.icure.cardinal.sdk.model.embed.InvoiceType
import com.icure.cardinal.sdk.model.embed.MediumType
import com.icure.cardinal.sdk.model.specializations.HexString
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
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
import kotlinx.serialization.json.JsonElement

@OptIn(DelicateCoroutinesApi::class)
internal class InvoiceApiImplJs(
	private val invoiceApi: InvoiceApi,
) : InvoiceApiJs {
	override val encrypted: InvoiceFlavouredApiJs<EncryptedInvoiceJs> = object :
			InvoiceFlavouredApiJs<EncryptedInvoiceJs> {
		override fun shareWith(
			delegateId: String,
			invoice: EncryptedInvoiceJs,
			options: dynamic,
		): Promise<EncryptedInvoiceJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val invoiceConverted: EncryptedInvoice = invoice_fromJs(invoice)
				val optionsConverted: InvoiceShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: InvoiceShareOptionsJs? ->
					options?.let { nonNull1 ->
						invoiceShareOptions_fromJs(nonNull1)
					}
				}
				val result = invoiceApi.encrypted.shareWith(
					delegateIdConverted,
					invoiceConverted,
					optionsConverted,
				)
				invoice_toJs(result)
			}
		}

		override fun shareWithMany(invoice: EncryptedInvoiceJs,
				delegates: Record<String, InvoiceShareOptionsJs>): Promise<EncryptedInvoiceJs> =
				GlobalScope.promise {
			val invoiceConverted: EncryptedInvoice = invoice_fromJs(invoice)
			val delegatesConverted: Map<String, InvoiceShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: InvoiceShareOptionsJs ->
					invoiceShareOptions_fromJs(x1)
				},
			)
			val result = invoiceApi.encrypted.shareWithMany(
				invoiceConverted,
				delegatesConverted,
			)
			invoice_toJs(result)
		}

		override fun findInvoicesByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			options: dynamic,
		): Promise<PaginatedListIteratorJs<EncryptedInvoiceJs>> {
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
				val result = invoiceApi.encrypted.findInvoicesByHcPartyPatient(
					hcPartyIdConverted,
					patientConverted,
					startDateConverted,
					endDateConverted,
					descendingConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: EncryptedInvoice ->
						invoice_toJs(x1)
					},
				)
			}
		}

		override fun createInvoice(entity: EncryptedInvoiceJs): Promise<EncryptedInvoiceJs> =
				GlobalScope.promise {
			val entityConverted: EncryptedInvoice = invoice_fromJs(entity)
			val result = invoiceApi.encrypted.createInvoice(
				entityConverted,
			)
			invoice_toJs(result)
		}

		override fun createInvoices(entities: Array<EncryptedInvoiceJs>):
				Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
			val entitiesConverted: List<EncryptedInvoice> = arrayToList(
				entities,
				"entities",
				{ x1: EncryptedInvoiceJs ->
					invoice_fromJs(x1)
				},
			)
			val result = invoiceApi.encrypted.createInvoices(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun undeleteInvoiceById(id: String, rev: String): Promise<EncryptedInvoiceJs> =
				GlobalScope.promise {
			val idConverted: String = id
			val revConverted: String = rev
			val result = invoiceApi.encrypted.undeleteInvoiceById(
				idConverted,
				revConverted,
			)
			invoice_toJs(result)
		}

		override fun undeleteInvoicesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
				Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
			val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = invoiceApi.encrypted.undeleteInvoicesByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun undeleteInvoice(invoice: InvoiceJs): Promise<EncryptedInvoiceJs> =
				GlobalScope.promise {
			val invoiceConverted: Invoice = invoice_fromJs(invoice)
			val result = invoiceApi.encrypted.undeleteInvoice(
				invoiceConverted,
			)
			invoice_toJs(result)
		}

		override fun undeleteInvoices(invoices: Array<InvoiceJs>): Promise<Array<EncryptedInvoiceJs>> =
				GlobalScope.promise {
			val invoicesConverted: List<Invoice> = arrayToList(
				invoices,
				"invoices",
				{ x1: InvoiceJs ->
					invoice_fromJs(x1)
				},
			)
			val result = invoiceApi.encrypted.undeleteInvoices(
				invoicesConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun modifyInvoice(entity: EncryptedInvoiceJs): Promise<EncryptedInvoiceJs> =
				GlobalScope.promise {
			val entityConverted: EncryptedInvoice = invoice_fromJs(entity)
			val result = invoiceApi.encrypted.modifyInvoice(
				entityConverted,
			)
			invoice_toJs(result)
		}

		override fun modifyInvoices(entities: Array<EncryptedInvoiceJs>):
				Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
			val entitiesConverted: List<EncryptedInvoice> = arrayToList(
				entities,
				"entities",
				{ x1: EncryptedInvoiceJs ->
					invoice_fromJs(x1)
				},
			)
			val result = invoiceApi.encrypted.modifyInvoices(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun getInvoice(entityId: String): Promise<EncryptedInvoiceJs?> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = invoiceApi.encrypted.getInvoice(
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					invoice_toJs(nonNull1)
				}
			)
		}

		override fun getInvoices(entityIds: Array<String>): Promise<Array<EncryptedInvoiceJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = invoiceApi.encrypted.getInvoices(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun reassignInvoice(invoice: EncryptedInvoiceJs): Promise<EncryptedInvoiceJs> =
				GlobalScope.promise {
			val invoiceConverted: EncryptedInvoice = invoice_fromJs(invoice)
			val result = invoiceApi.encrypted.reassignInvoice(
				invoiceConverted,
			)
			invoice_toJs(result)
		}

		override fun mergeTo(invoiceId: String, ids: Array<String>): Promise<EncryptedInvoiceJs> =
				GlobalScope.promise {
			val invoiceIdConverted: String = invoiceId
			val idsConverted: List<String> = arrayToList(
				ids,
				"ids",
				{ x1: String ->
					x1
				},
			)
			val result = invoiceApi.encrypted.mergeTo(
				invoiceIdConverted,
				idsConverted,
			)
			invoice_toJs(result)
		}

		override fun validate(
			invoiceId: String,
			scheme: String,
			forcedValue: String,
		): Promise<EncryptedInvoiceJs> = GlobalScope.promise {
			val invoiceIdConverted: String = invoiceId
			val schemeConverted: String = scheme
			val forcedValueConverted: String = forcedValue
			val result = invoiceApi.encrypted.validate(
				invoiceIdConverted,
				schemeConverted,
				forcedValueConverted,
			)
			invoice_toJs(result)
		}

		override fun appendCodes(
			userId: String,
			type: String,
			sentMediumType: String,
			secretFKeys: String,
			invoicingCodes: Array<EncryptedInvoicingCodeJs>,
			options: dynamic,
		): Promise<Array<EncryptedInvoiceJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val userIdConverted: String = userId
				val typeConverted: String = type
				val sentMediumTypeConverted: String = sentMediumType
				val secretFKeysConverted: String = secretFKeys
				val insuranceIdConverted: String? = convertingOptionOrDefaultNullable(
					_options,
					"insuranceId",
					null
				) { insuranceId: String? ->
					undefinedToNull(insuranceId)
				}
				val invoiceIdConverted: String? = convertingOptionOrDefaultNullable(
					_options,
					"invoiceId",
					null
				) { invoiceId: String? ->
					undefinedToNull(invoiceId)
				}
				val gracePeriodConverted: Int? = convertingOptionOrDefaultNullable(
					_options,
					"gracePeriod",
					null
				) { gracePeriod: Double? ->
					numberToInt(gracePeriod, "gracePeriod")
				}
				val invoicingCodesConverted: List<EncryptedInvoicingCode> = arrayToList(
					invoicingCodes,
					"invoicingCodes",
					{ x1: EncryptedInvoicingCodeJs ->
						invoicingCode_fromJs(x1)
					},
				)
				val result = invoiceApi.encrypted.appendCodes(
					userIdConverted,
					typeConverted,
					sentMediumTypeConverted,
					secretFKeysConverted,
					insuranceIdConverted,
					invoiceIdConverted,
					gracePeriodConverted,
					invoicingCodesConverted,
				)
				listToArray(
					result,
					{ x1: EncryptedInvoice ->
						invoice_toJs(x1)
					},
				)
			}
		}

		override fun removeCodes(
			userId: String,
			serviceId: String,
			secretFKeys: String,
			tarificationIds: Array<String>,
		): Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
			val userIdConverted: String = userId
			val serviceIdConverted: String = serviceId
			val secretFKeysConverted: String = secretFKeys
			val tarificationIdsConverted: List<String> = arrayToList(
				tarificationIds,
				"tarificationIds",
				{ x1: String ->
					x1
				},
			)
			val result = invoiceApi.encrypted.removeCodes(
				userIdConverted,
				serviceIdConverted,
				secretFKeysConverted,
				tarificationIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun findInvoicesByAuthor(hcPartyId: String, options: dynamic):
				Promise<PaginatedListJs<EncryptedInvoiceJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val hcPartyIdConverted: String = hcPartyId
				val fromDateConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"fromDate",
					null
				) { fromDate: Double? ->
					numberToLong(fromDate, "fromDate")
				}
				val toDateConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"toDate",
					null
				) { toDate: Double? ->
					numberToLong(toDate, "toDate")
				}
				val startKeyConverted: JsonElement? = convertingOptionOrDefaultNullable(
					_options,
					"startKey",
					null
				) { startKey: dynamic ->
					dynamicToJsonNullsafe(startKey, "startKey")
				}
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
				val result = invoiceApi.encrypted.findInvoicesByAuthor(
					hcPartyIdConverted,
					fromDateConverted,
					toDateConverted,
					startKeyConverted,
					startDocumentIdConverted,
					limitConverted,
				)
				paginatedList_toJs(
					result,
					{ x1: EncryptedInvoice ->
						invoice_toJs(x1)
					},
				)
			}
		}

		override fun listInvoicesByHcPartyAndGroupId(hcPartyId: String, groupId: String):
				Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val groupIdConverted: String = groupId
			val result = invoiceApi.encrypted.listInvoicesByHcPartyAndGroupId(
				hcPartyIdConverted,
				groupIdConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
			hcPartyId: String,
			sentMediumType: String,
			invoiceType: String,
			sent: Boolean,
			options: dynamic,
		): Promise<Array<EncryptedInvoiceJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val hcPartyIdConverted: String = hcPartyId
				val sentMediumTypeConverted: MediumType = MediumType.valueOf(sentMediumType)
				val invoiceTypeConverted: InvoiceType = InvoiceType.valueOf(invoiceType)
				val sentConverted: Boolean = sent
				val fromConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"from",
					null
				) { from: Double? ->
					numberToLong(from, "from")
				}
				val toConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"to",
					null
				) { to: Double? ->
					numberToLong(to, "to")
				}
				val result = invoiceApi.encrypted.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
					hcPartyIdConverted,
					sentMediumTypeConverted,
					invoiceTypeConverted,
					sentConverted,
					fromConverted,
					toConverted,
				)
				listToArray(
					result,
					{ x1: EncryptedInvoice ->
						invoice_toJs(x1)
					},
				)
			}
		}

		override fun listInvoicesByContactIds(contactIds: Array<String>):
				Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
			val contactIdsConverted: List<String> = arrayToList(
				contactIds,
				"contactIds",
				{ x1: String ->
					x1
				},
			)
			val result = invoiceApi.encrypted.listInvoicesByContactIds(
				contactIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun listInvoicesByRecipientsIds(recipientsIds: Array<String>):
				Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
			val recipientsIdsConverted: List<String> = arrayToList(
				recipientsIds,
				"recipientsIds",
				{ x1: String ->
					x1
				},
			)
			val result = invoiceApi.encrypted.listInvoicesByRecipientsIds(
				recipientsIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun listToInsurances(userIds: Array<String>): Promise<Array<EncryptedInvoiceJs>> =
				GlobalScope.promise {
			val userIdsConverted: List<String> = arrayToList(
				userIds,
				"userIds",
				{ x1: String ->
					x1
				},
			)
			val result = invoiceApi.encrypted.listToInsurances(
				userIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun listToInsurancesUnsent(userIds: Array<String>): Promise<Array<EncryptedInvoiceJs>> =
				GlobalScope.promise {
			val userIdsConverted: List<String> = arrayToList(
				userIds,
				"userIds",
				{ x1: String ->
					x1
				},
			)
			val result = invoiceApi.encrypted.listToInsurancesUnsent(
				userIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun listToPatients(hcPartyId: String): Promise<Array<EncryptedInvoiceJs>> =
				GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val result = invoiceApi.encrypted.listToPatients(
				hcPartyIdConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun listToPatientsUnsent(hcPartyId: String?): Promise<Array<EncryptedInvoiceJs>> =
				GlobalScope.promise {
			val hcPartyIdConverted: String? = undefinedToNull(hcPartyId)
			val result = invoiceApi.encrypted.listToPatientsUnsent(
				hcPartyIdConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun listInvoicesByIds(ids: Array<String>): Promise<Array<EncryptedInvoiceJs>> =
				GlobalScope.promise {
			val idsConverted: List<String> = arrayToList(
				ids,
				"ids",
				{ x1: String ->
					x1
				},
			)
			val result = invoiceApi.encrypted.listInvoicesByIds(
				idsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun listInvoicesByHcpartySendingModeStatusDate(
			hcPartyId: String,
			sendingMode: String,
			status: String,
			from: Double,
			to: Double,
		): Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val sendingModeConverted: String = sendingMode
			val statusConverted: String = status
			val fromConverted: Long = numberToLong(from, "from")
			val toConverted: Long = numberToLong(to, "to")
			val result = invoiceApi.encrypted.listInvoicesByHcpartySendingModeStatusDate(
				hcPartyIdConverted,
				sendingModeConverted,
				statusConverted,
				fromConverted,
				toConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun listInvoicesByServiceIds(serviceIds: Array<String>):
				Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
			val serviceIdsConverted: List<String> = arrayToList(
				serviceIds,
				"serviceIds",
				{ x1: String ->
					x1
				},
			)
			val result = invoiceApi.encrypted.listInvoicesByServiceIds(
				serviceIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun listAllHcpsByStatus(
			status: String,
			hcpIds: Array<String>,
			options: dynamic,
		): Promise<Array<EncryptedInvoiceJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val statusConverted: String = status
				val fromConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"from",
					null
				) { from: Double? ->
					numberToLong(from, "from")
				}
				val toConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"to",
					null
				) { to: Double? ->
					numberToLong(to, "to")
				}
				val hcpIdsConverted: List<String> = arrayToList(
					hcpIds,
					"hcpIds",
					{ x1: String ->
						x1
					},
				)
				val result = invoiceApi.encrypted.listAllHcpsByStatus(
					statusConverted,
					fromConverted,
					toConverted,
					hcpIdsConverted,
				)
				listToArray(
					result,
					{ x1: EncryptedInvoice ->
						invoice_toJs(x1)
					},
				)
			}
		}
	}

	override val tryAndRecover: InvoiceFlavouredApiJs<InvoiceJs> = object :
			InvoiceFlavouredApiJs<InvoiceJs> {
		override fun shareWith(
			delegateId: String,
			invoice: InvoiceJs,
			options: dynamic,
		): Promise<InvoiceJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val invoiceConverted: Invoice = invoice_fromJs(invoice)
				val optionsConverted: InvoiceShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: InvoiceShareOptionsJs? ->
					options?.let { nonNull1 ->
						invoiceShareOptions_fromJs(nonNull1)
					}
				}
				val result = invoiceApi.tryAndRecover.shareWith(
					delegateIdConverted,
					invoiceConverted,
					optionsConverted,
				)
				invoice_toJs(result)
			}
		}

		override fun shareWithMany(invoice: InvoiceJs, delegates: Record<String, InvoiceShareOptionsJs>):
				Promise<InvoiceJs> = GlobalScope.promise {
			val invoiceConverted: Invoice = invoice_fromJs(invoice)
			val delegatesConverted: Map<String, InvoiceShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: InvoiceShareOptionsJs ->
					invoiceShareOptions_fromJs(x1)
				},
			)
			val result = invoiceApi.tryAndRecover.shareWithMany(
				invoiceConverted,
				delegatesConverted,
			)
			invoice_toJs(result)
		}

		override fun findInvoicesByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			options: dynamic,
		): Promise<PaginatedListIteratorJs<InvoiceJs>> {
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
				val result = invoiceApi.tryAndRecover.findInvoicesByHcPartyPatient(
					hcPartyIdConverted,
					patientConverted,
					startDateConverted,
					endDateConverted,
					descendingConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: Invoice ->
						invoice_toJs(x1)
					},
				)
			}
		}

		override fun createInvoice(entity: InvoiceJs): Promise<InvoiceJs> = GlobalScope.promise {
			val entityConverted: Invoice = invoice_fromJs(entity)
			val result = invoiceApi.tryAndRecover.createInvoice(
				entityConverted,
			)
			invoice_toJs(result)
		}

		override fun createInvoices(entities: Array<InvoiceJs>): Promise<Array<InvoiceJs>> =
				GlobalScope.promise {
			val entitiesConverted: List<Invoice> = arrayToList(
				entities,
				"entities",
				{ x1: InvoiceJs ->
					invoice_fromJs(x1)
				},
			)
			val result = invoiceApi.tryAndRecover.createInvoices(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun undeleteInvoiceById(id: String, rev: String): Promise<InvoiceJs> =
				GlobalScope.promise {
			val idConverted: String = id
			val revConverted: String = rev
			val result = invoiceApi.tryAndRecover.undeleteInvoiceById(
				idConverted,
				revConverted,
			)
			invoice_toJs(result)
		}

		override fun undeleteInvoicesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
				Promise<Array<InvoiceJs>> = GlobalScope.promise {
			val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = invoiceApi.tryAndRecover.undeleteInvoicesByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun undeleteInvoice(invoice: InvoiceJs): Promise<InvoiceJs> = GlobalScope.promise {
			val invoiceConverted: Invoice = invoice_fromJs(invoice)
			val result = invoiceApi.tryAndRecover.undeleteInvoice(
				invoiceConverted,
			)
			invoice_toJs(result)
		}

		override fun undeleteInvoices(invoices: Array<InvoiceJs>): Promise<Array<InvoiceJs>> =
				GlobalScope.promise {
			val invoicesConverted: List<Invoice> = arrayToList(
				invoices,
				"invoices",
				{ x1: InvoiceJs ->
					invoice_fromJs(x1)
				},
			)
			val result = invoiceApi.tryAndRecover.undeleteInvoices(
				invoicesConverted,
			)
			listToArray(
				result,
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun modifyInvoice(entity: InvoiceJs): Promise<InvoiceJs> = GlobalScope.promise {
			val entityConverted: Invoice = invoice_fromJs(entity)
			val result = invoiceApi.tryAndRecover.modifyInvoice(
				entityConverted,
			)
			invoice_toJs(result)
		}

		override fun modifyInvoices(entities: Array<InvoiceJs>): Promise<Array<InvoiceJs>> =
				GlobalScope.promise {
			val entitiesConverted: List<Invoice> = arrayToList(
				entities,
				"entities",
				{ x1: InvoiceJs ->
					invoice_fromJs(x1)
				},
			)
			val result = invoiceApi.tryAndRecover.modifyInvoices(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun getInvoice(entityId: String): Promise<InvoiceJs?> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = invoiceApi.tryAndRecover.getInvoice(
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					invoice_toJs(nonNull1)
				}
			)
		}

		override fun getInvoices(entityIds: Array<String>): Promise<Array<InvoiceJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = invoiceApi.tryAndRecover.getInvoices(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun reassignInvoice(invoice: InvoiceJs): Promise<InvoiceJs> = GlobalScope.promise {
			val invoiceConverted: Invoice = invoice_fromJs(invoice)
			val result = invoiceApi.tryAndRecover.reassignInvoice(
				invoiceConverted,
			)
			invoice_toJs(result)
		}

		override fun mergeTo(invoiceId: String, ids: Array<String>): Promise<InvoiceJs> =
				GlobalScope.promise {
			val invoiceIdConverted: String = invoiceId
			val idsConverted: List<String> = arrayToList(
				ids,
				"ids",
				{ x1: String ->
					x1
				},
			)
			val result = invoiceApi.tryAndRecover.mergeTo(
				invoiceIdConverted,
				idsConverted,
			)
			invoice_toJs(result)
		}

		override fun validate(
			invoiceId: String,
			scheme: String,
			forcedValue: String,
		): Promise<InvoiceJs> = GlobalScope.promise {
			val invoiceIdConverted: String = invoiceId
			val schemeConverted: String = scheme
			val forcedValueConverted: String = forcedValue
			val result = invoiceApi.tryAndRecover.validate(
				invoiceIdConverted,
				schemeConverted,
				forcedValueConverted,
			)
			invoice_toJs(result)
		}

		override fun appendCodes(
			userId: String,
			type: String,
			sentMediumType: String,
			secretFKeys: String,
			invoicingCodes: Array<EncryptedInvoicingCodeJs>,
			options: dynamic,
		): Promise<Array<InvoiceJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val userIdConverted: String = userId
				val typeConverted: String = type
				val sentMediumTypeConverted: String = sentMediumType
				val secretFKeysConverted: String = secretFKeys
				val insuranceIdConverted: String? = convertingOptionOrDefaultNullable(
					_options,
					"insuranceId",
					null
				) { insuranceId: String? ->
					undefinedToNull(insuranceId)
				}
				val invoiceIdConverted: String? = convertingOptionOrDefaultNullable(
					_options,
					"invoiceId",
					null
				) { invoiceId: String? ->
					undefinedToNull(invoiceId)
				}
				val gracePeriodConverted: Int? = convertingOptionOrDefaultNullable(
					_options,
					"gracePeriod",
					null
				) { gracePeriod: Double? ->
					numberToInt(gracePeriod, "gracePeriod")
				}
				val invoicingCodesConverted: List<EncryptedInvoicingCode> = arrayToList(
					invoicingCodes,
					"invoicingCodes",
					{ x1: EncryptedInvoicingCodeJs ->
						invoicingCode_fromJs(x1)
					},
				)
				val result = invoiceApi.tryAndRecover.appendCodes(
					userIdConverted,
					typeConverted,
					sentMediumTypeConverted,
					secretFKeysConverted,
					insuranceIdConverted,
					invoiceIdConverted,
					gracePeriodConverted,
					invoicingCodesConverted,
				)
				listToArray(
					result,
					{ x1: Invoice ->
						invoice_toJs(x1)
					},
				)
			}
		}

		override fun removeCodes(
			userId: String,
			serviceId: String,
			secretFKeys: String,
			tarificationIds: Array<String>,
		): Promise<Array<InvoiceJs>> = GlobalScope.promise {
			val userIdConverted: String = userId
			val serviceIdConverted: String = serviceId
			val secretFKeysConverted: String = secretFKeys
			val tarificationIdsConverted: List<String> = arrayToList(
				tarificationIds,
				"tarificationIds",
				{ x1: String ->
					x1
				},
			)
			val result = invoiceApi.tryAndRecover.removeCodes(
				userIdConverted,
				serviceIdConverted,
				secretFKeysConverted,
				tarificationIdsConverted,
			)
			listToArray(
				result,
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun findInvoicesByAuthor(hcPartyId: String, options: dynamic):
				Promise<PaginatedListJs<InvoiceJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val hcPartyIdConverted: String = hcPartyId
				val fromDateConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"fromDate",
					null
				) { fromDate: Double? ->
					numberToLong(fromDate, "fromDate")
				}
				val toDateConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"toDate",
					null
				) { toDate: Double? ->
					numberToLong(toDate, "toDate")
				}
				val startKeyConverted: JsonElement? = convertingOptionOrDefaultNullable(
					_options,
					"startKey",
					null
				) { startKey: dynamic ->
					dynamicToJsonNullsafe(startKey, "startKey")
				}
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
				val result = invoiceApi.tryAndRecover.findInvoicesByAuthor(
					hcPartyIdConverted,
					fromDateConverted,
					toDateConverted,
					startKeyConverted,
					startDocumentIdConverted,
					limitConverted,
				)
				paginatedList_toJs(
					result,
					{ x1: Invoice ->
						invoice_toJs(x1)
					},
				)
			}
		}

		override fun listInvoicesByHcPartyAndGroupId(hcPartyId: String, groupId: String):
				Promise<Array<InvoiceJs>> = GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val groupIdConverted: String = groupId
			val result = invoiceApi.tryAndRecover.listInvoicesByHcPartyAndGroupId(
				hcPartyIdConverted,
				groupIdConverted,
			)
			listToArray(
				result,
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
			hcPartyId: String,
			sentMediumType: String,
			invoiceType: String,
			sent: Boolean,
			options: dynamic,
		): Promise<Array<InvoiceJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val hcPartyIdConverted: String = hcPartyId
				val sentMediumTypeConverted: MediumType = MediumType.valueOf(sentMediumType)
				val invoiceTypeConverted: InvoiceType = InvoiceType.valueOf(invoiceType)
				val sentConverted: Boolean = sent
				val fromConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"from",
					null
				) { from: Double? ->
					numberToLong(from, "from")
				}
				val toConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"to",
					null
				) { to: Double? ->
					numberToLong(to, "to")
				}
				val result = invoiceApi.tryAndRecover.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
					hcPartyIdConverted,
					sentMediumTypeConverted,
					invoiceTypeConverted,
					sentConverted,
					fromConverted,
					toConverted,
				)
				listToArray(
					result,
					{ x1: Invoice ->
						invoice_toJs(x1)
					},
				)
			}
		}

		override fun listInvoicesByContactIds(contactIds: Array<String>): Promise<Array<InvoiceJs>> =
				GlobalScope.promise {
			val contactIdsConverted: List<String> = arrayToList(
				contactIds,
				"contactIds",
				{ x1: String ->
					x1
				},
			)
			val result = invoiceApi.tryAndRecover.listInvoicesByContactIds(
				contactIdsConverted,
			)
			listToArray(
				result,
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun listInvoicesByRecipientsIds(recipientsIds: Array<String>): Promise<Array<InvoiceJs>>
				= GlobalScope.promise {
			val recipientsIdsConverted: List<String> = arrayToList(
				recipientsIds,
				"recipientsIds",
				{ x1: String ->
					x1
				},
			)
			val result = invoiceApi.tryAndRecover.listInvoicesByRecipientsIds(
				recipientsIdsConverted,
			)
			listToArray(
				result,
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun listToInsurances(userIds: Array<String>): Promise<Array<InvoiceJs>> =
				GlobalScope.promise {
			val userIdsConverted: List<String> = arrayToList(
				userIds,
				"userIds",
				{ x1: String ->
					x1
				},
			)
			val result = invoiceApi.tryAndRecover.listToInsurances(
				userIdsConverted,
			)
			listToArray(
				result,
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun listToInsurancesUnsent(userIds: Array<String>): Promise<Array<InvoiceJs>> =
				GlobalScope.promise {
			val userIdsConverted: List<String> = arrayToList(
				userIds,
				"userIds",
				{ x1: String ->
					x1
				},
			)
			val result = invoiceApi.tryAndRecover.listToInsurancesUnsent(
				userIdsConverted,
			)
			listToArray(
				result,
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun listToPatients(hcPartyId: String): Promise<Array<InvoiceJs>> = GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val result = invoiceApi.tryAndRecover.listToPatients(
				hcPartyIdConverted,
			)
			listToArray(
				result,
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun listToPatientsUnsent(hcPartyId: String?): Promise<Array<InvoiceJs>> =
				GlobalScope.promise {
			val hcPartyIdConverted: String? = undefinedToNull(hcPartyId)
			val result = invoiceApi.tryAndRecover.listToPatientsUnsent(
				hcPartyIdConverted,
			)
			listToArray(
				result,
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun listInvoicesByIds(ids: Array<String>): Promise<Array<InvoiceJs>> =
				GlobalScope.promise {
			val idsConverted: List<String> = arrayToList(
				ids,
				"ids",
				{ x1: String ->
					x1
				},
			)
			val result = invoiceApi.tryAndRecover.listInvoicesByIds(
				idsConverted,
			)
			listToArray(
				result,
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun listInvoicesByHcpartySendingModeStatusDate(
			hcPartyId: String,
			sendingMode: String,
			status: String,
			from: Double,
			to: Double,
		): Promise<Array<InvoiceJs>> = GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val sendingModeConverted: String = sendingMode
			val statusConverted: String = status
			val fromConverted: Long = numberToLong(from, "from")
			val toConverted: Long = numberToLong(to, "to")
			val result = invoiceApi.tryAndRecover.listInvoicesByHcpartySendingModeStatusDate(
				hcPartyIdConverted,
				sendingModeConverted,
				statusConverted,
				fromConverted,
				toConverted,
			)
			listToArray(
				result,
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun listInvoicesByServiceIds(serviceIds: Array<String>): Promise<Array<InvoiceJs>> =
				GlobalScope.promise {
			val serviceIdsConverted: List<String> = arrayToList(
				serviceIds,
				"serviceIds",
				{ x1: String ->
					x1
				},
			)
			val result = invoiceApi.tryAndRecover.listInvoicesByServiceIds(
				serviceIdsConverted,
			)
			listToArray(
				result,
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun listAllHcpsByStatus(
			status: String,
			hcpIds: Array<String>,
			options: dynamic,
		): Promise<Array<InvoiceJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val statusConverted: String = status
				val fromConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"from",
					null
				) { from: Double? ->
					numberToLong(from, "from")
				}
				val toConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"to",
					null
				) { to: Double? ->
					numberToLong(to, "to")
				}
				val hcpIdsConverted: List<String> = arrayToList(
					hcpIds,
					"hcpIds",
					{ x1: String ->
						x1
					},
				)
				val result = invoiceApi.tryAndRecover.listAllHcpsByStatus(
					statusConverted,
					fromConverted,
					toConverted,
					hcpIdsConverted,
				)
				listToArray(
					result,
					{ x1: Invoice ->
						invoice_toJs(x1)
					},
				)
			}
		}
	}

	override val inGroup: InvoiceInGroupApiJs = object : InvoiceInGroupApiJs {
		override val encrypted: InvoiceFlavouredInGroupApiJs<EncryptedInvoiceJs> = object :
				InvoiceFlavouredInGroupApiJs<EncryptedInvoiceJs> {
			override fun shareWith(
				`delegate`: EntityReferenceInGroupJs,
				invoice: GroupScopedJs<EncryptedInvoiceJs>,
				options: dynamic,
			): Promise<GroupScopedJs<EncryptedInvoiceJs>> {
				val _options = options ?: js("{}")
				return GlobalScope.promise {
					val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
					val invoiceConverted: GroupScoped<EncryptedInvoice> = groupScoped_fromJs(
						invoice,
						{ x1: EncryptedInvoiceJs ->
							invoice_fromJs(x1)
						},
					)
					val optionsConverted: InvoiceShareOptions? = convertingOptionOrDefaultNullable(
						_options,
						"options",
						null
					) { options: InvoiceShareOptionsJs? ->
						options?.let { nonNull1 ->
							invoiceShareOptions_fromJs(nonNull1)
						}
					}
					val result = invoiceApi.inGroup.encrypted.shareWith(
						delegateConverted,
						invoiceConverted,
						optionsConverted,
					)
					groupScoped_toJs(
						result,
						{ x1: EncryptedInvoice ->
							invoice_toJs(x1)
						},
					)
				}
			}

			override fun shareWithMany(invoice: GroupScopedJs<EncryptedInvoiceJs>,
					delegates: Array<EntityReferenceInGroupToInvoiceShareOptionsMapObject_delegate_shareOptions>):
					Promise<GroupScopedJs<EncryptedInvoiceJs>> = GlobalScope.promise {
				val invoiceConverted: GroupScoped<EncryptedInvoice> = groupScoped_fromJs(
					invoice,
					{ x1: EncryptedInvoiceJs ->
						invoice_fromJs(x1)
					},
				)
				val delegatesConverted: Map<EntityReferenceInGroup, InvoiceShareOptions> =
						EntityReferenceInGroupToInvoiceShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
				val result = invoiceApi.inGroup.encrypted.shareWithMany(
					invoiceConverted,
					delegatesConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedInvoice ->
						invoice_toJs(x1)
					},
				)
			}

			override fun createInvoice(entity: GroupScopedJs<EncryptedInvoiceJs>):
					Promise<GroupScopedJs<EncryptedInvoiceJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<EncryptedInvoice> = groupScoped_fromJs(
					entity,
					{ x1: EncryptedInvoiceJs ->
						invoice_fromJs(x1)
					},
				)
				val result = invoiceApi.inGroup.encrypted.createInvoice(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedInvoice ->
						invoice_toJs(x1)
					},
				)
			}

			override fun createInvoices(entities: Array<GroupScopedJs<EncryptedInvoiceJs>>):
					Promise<Array<GroupScopedJs<EncryptedInvoiceJs>>> = GlobalScope.promise {
				val entitiesConverted: List<GroupScoped<EncryptedInvoice>> = arrayToList(
					entities,
					"entities",
					{ x1: GroupScopedJs<EncryptedInvoiceJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: EncryptedInvoiceJs ->
								invoice_fromJs(x2)
							},
						)
					},
				)
				val result = invoiceApi.inGroup.encrypted.createInvoices(
					entitiesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<EncryptedInvoice> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedInvoice ->
								invoice_toJs(x2)
							},
						)
					},
				)
			}

			override fun undeleteInvoiceById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
					Promise<GroupScopedJs<EncryptedInvoiceJs>> = GlobalScope.promise {
				val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
					entityId,
					{ x1: StoredDocumentIdentifierJs ->
						storedDocumentIdentifier_fromJs(x1)
					},
				)
				val result = invoiceApi.inGroup.encrypted.undeleteInvoiceById(
					entityIdConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedInvoice ->
						invoice_toJs(x1)
					},
				)
			}

			override fun undeleteInvoicesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
					Promise<Array<GroupScopedJs<EncryptedInvoiceJs>>> = GlobalScope.promise {
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
				val result = invoiceApi.inGroup.encrypted.undeleteInvoicesByIds(
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<EncryptedInvoice> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedInvoice ->
								invoice_toJs(x2)
							},
						)
					},
				)
			}

			override fun undeleteInvoice(invoice: GroupScopedJs<InvoiceJs>):
					Promise<GroupScopedJs<EncryptedInvoiceJs>> = GlobalScope.promise {
				val invoiceConverted: GroupScoped<Invoice> = groupScoped_fromJs(
					invoice,
					{ x1: InvoiceJs ->
						invoice_fromJs(x1)
					},
				)
				val result = invoiceApi.inGroup.encrypted.undeleteInvoice(
					invoiceConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedInvoice ->
						invoice_toJs(x1)
					},
				)
			}

			override fun undeleteInvoices(invoices: Array<GroupScopedJs<EncryptedInvoiceJs>>):
					Promise<Array<GroupScopedJs<EncryptedInvoiceJs>>> = GlobalScope.promise {
				val invoicesConverted: List<GroupScoped<EncryptedInvoice>> = arrayToList(
					invoices,
					"invoices",
					{ x1: GroupScopedJs<EncryptedInvoiceJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: EncryptedInvoiceJs ->
								invoice_fromJs(x2)
							},
						)
					},
				)
				val result = invoiceApi.inGroup.encrypted.undeleteInvoices(
					invoicesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<EncryptedInvoice> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedInvoice ->
								invoice_toJs(x2)
							},
						)
					},
				)
			}

			override fun modifyInvoice(entity: GroupScopedJs<EncryptedInvoiceJs>):
					Promise<GroupScopedJs<EncryptedInvoiceJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<EncryptedInvoice> = groupScoped_fromJs(
					entity,
					{ x1: EncryptedInvoiceJs ->
						invoice_fromJs(x1)
					},
				)
				val result = invoiceApi.inGroup.encrypted.modifyInvoice(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedInvoice ->
						invoice_toJs(x1)
					},
				)
			}

			override fun modifyInvoices(entities: Array<GroupScopedJs<EncryptedInvoiceJs>>):
					Promise<Array<GroupScopedJs<EncryptedInvoiceJs>>> = GlobalScope.promise {
				val entitiesConverted: List<GroupScoped<EncryptedInvoice>> = arrayToList(
					entities,
					"entities",
					{ x1: GroupScopedJs<EncryptedInvoiceJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: EncryptedInvoiceJs ->
								invoice_fromJs(x2)
							},
						)
					},
				)
				val result = invoiceApi.inGroup.encrypted.modifyInvoices(
					entitiesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<EncryptedInvoice> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedInvoice ->
								invoice_toJs(x2)
							},
						)
					},
				)
			}

			override fun getInvoice(groupId: String, entityId: String):
					Promise<GroupScopedJs<EncryptedInvoiceJs>?> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdConverted: String = entityId
				val result = invoiceApi.inGroup.encrypted.getInvoice(
					groupIdConverted,
					entityIdConverted,
				)
				nullToUndefined(
					result?.let { nonNull1 ->
						groupScoped_toJs(
							nonNull1,
							{ x1: EncryptedInvoice ->
								invoice_toJs(x1)
							},
						)
					}
				)
			}

			override fun getInvoices(groupId: String, entityIds: Array<String>):
					Promise<Array<GroupScopedJs<EncryptedInvoiceJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdsConverted: List<String> = arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)
				val result = invoiceApi.inGroup.encrypted.getInvoices(
					groupIdConverted,
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<EncryptedInvoice> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedInvoice ->
								invoice_toJs(x2)
							},
						)
					},
				)
			}
		}

		override val tryAndRecover: InvoiceFlavouredInGroupApiJs<InvoiceJs> = object :
				InvoiceFlavouredInGroupApiJs<InvoiceJs> {
			override fun shareWith(
				`delegate`: EntityReferenceInGroupJs,
				invoice: GroupScopedJs<InvoiceJs>,
				options: dynamic,
			): Promise<GroupScopedJs<InvoiceJs>> {
				val _options = options ?: js("{}")
				return GlobalScope.promise {
					val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
					val invoiceConverted: GroupScoped<Invoice> = groupScoped_fromJs(
						invoice,
						{ x1: InvoiceJs ->
							invoice_fromJs(x1)
						},
					)
					val optionsConverted: InvoiceShareOptions? = convertingOptionOrDefaultNullable(
						_options,
						"options",
						null
					) { options: InvoiceShareOptionsJs? ->
						options?.let { nonNull1 ->
							invoiceShareOptions_fromJs(nonNull1)
						}
					}
					val result = invoiceApi.inGroup.tryAndRecover.shareWith(
						delegateConverted,
						invoiceConverted,
						optionsConverted,
					)
					groupScoped_toJs(
						result,
						{ x1: Invoice ->
							invoice_toJs(x1)
						},
					)
				}
			}

			override fun shareWithMany(invoice: GroupScopedJs<InvoiceJs>,
					delegates: Array<EntityReferenceInGroupToInvoiceShareOptionsMapObject_delegate_shareOptions>):
					Promise<GroupScopedJs<InvoiceJs>> = GlobalScope.promise {
				val invoiceConverted: GroupScoped<Invoice> = groupScoped_fromJs(
					invoice,
					{ x1: InvoiceJs ->
						invoice_fromJs(x1)
					},
				)
				val delegatesConverted: Map<EntityReferenceInGroup, InvoiceShareOptions> =
						EntityReferenceInGroupToInvoiceShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
				val result = invoiceApi.inGroup.tryAndRecover.shareWithMany(
					invoiceConverted,
					delegatesConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Invoice ->
						invoice_toJs(x1)
					},
				)
			}

			override fun createInvoice(entity: GroupScopedJs<InvoiceJs>): Promise<GroupScopedJs<InvoiceJs>> =
					GlobalScope.promise {
				val entityConverted: GroupScoped<Invoice> = groupScoped_fromJs(
					entity,
					{ x1: InvoiceJs ->
						invoice_fromJs(x1)
					},
				)
				val result = invoiceApi.inGroup.tryAndRecover.createInvoice(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Invoice ->
						invoice_toJs(x1)
					},
				)
			}

			override fun createInvoices(entities: Array<GroupScopedJs<InvoiceJs>>):
					Promise<Array<GroupScopedJs<InvoiceJs>>> = GlobalScope.promise {
				val entitiesConverted: List<GroupScoped<Invoice>> = arrayToList(
					entities,
					"entities",
					{ x1: GroupScopedJs<InvoiceJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: InvoiceJs ->
								invoice_fromJs(x2)
							},
						)
					},
				)
				val result = invoiceApi.inGroup.tryAndRecover.createInvoices(
					entitiesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Invoice> ->
						groupScoped_toJs(
							x1,
							{ x2: Invoice ->
								invoice_toJs(x2)
							},
						)
					},
				)
			}

			override fun undeleteInvoiceById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
					Promise<GroupScopedJs<InvoiceJs>> = GlobalScope.promise {
				val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
					entityId,
					{ x1: StoredDocumentIdentifierJs ->
						storedDocumentIdentifier_fromJs(x1)
					},
				)
				val result = invoiceApi.inGroup.tryAndRecover.undeleteInvoiceById(
					entityIdConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Invoice ->
						invoice_toJs(x1)
					},
				)
			}

			override fun undeleteInvoicesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
					Promise<Array<GroupScopedJs<InvoiceJs>>> = GlobalScope.promise {
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
				val result = invoiceApi.inGroup.tryAndRecover.undeleteInvoicesByIds(
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Invoice> ->
						groupScoped_toJs(
							x1,
							{ x2: Invoice ->
								invoice_toJs(x2)
							},
						)
					},
				)
			}

			override fun undeleteInvoice(invoice: GroupScopedJs<InvoiceJs>):
					Promise<GroupScopedJs<InvoiceJs>> = GlobalScope.promise {
				val invoiceConverted: GroupScoped<Invoice> = groupScoped_fromJs(
					invoice,
					{ x1: InvoiceJs ->
						invoice_fromJs(x1)
					},
				)
				val result = invoiceApi.inGroup.tryAndRecover.undeleteInvoice(
					invoiceConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Invoice ->
						invoice_toJs(x1)
					},
				)
			}

			override fun undeleteInvoices(invoices: Array<GroupScopedJs<InvoiceJs>>):
					Promise<Array<GroupScopedJs<InvoiceJs>>> = GlobalScope.promise {
				val invoicesConverted: List<GroupScoped<Invoice>> = arrayToList(
					invoices,
					"invoices",
					{ x1: GroupScopedJs<InvoiceJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: InvoiceJs ->
								invoice_fromJs(x2)
							},
						)
					},
				)
				val result = invoiceApi.inGroup.tryAndRecover.undeleteInvoices(
					invoicesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Invoice> ->
						groupScoped_toJs(
							x1,
							{ x2: Invoice ->
								invoice_toJs(x2)
							},
						)
					},
				)
			}

			override fun modifyInvoice(entity: GroupScopedJs<InvoiceJs>): Promise<GroupScopedJs<InvoiceJs>> =
					GlobalScope.promise {
				val entityConverted: GroupScoped<Invoice> = groupScoped_fromJs(
					entity,
					{ x1: InvoiceJs ->
						invoice_fromJs(x1)
					},
				)
				val result = invoiceApi.inGroup.tryAndRecover.modifyInvoice(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Invoice ->
						invoice_toJs(x1)
					},
				)
			}

			override fun modifyInvoices(entities: Array<GroupScopedJs<InvoiceJs>>):
					Promise<Array<GroupScopedJs<InvoiceJs>>> = GlobalScope.promise {
				val entitiesConverted: List<GroupScoped<Invoice>> = arrayToList(
					entities,
					"entities",
					{ x1: GroupScopedJs<InvoiceJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: InvoiceJs ->
								invoice_fromJs(x2)
							},
						)
					},
				)
				val result = invoiceApi.inGroup.tryAndRecover.modifyInvoices(
					entitiesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Invoice> ->
						groupScoped_toJs(
							x1,
							{ x2: Invoice ->
								invoice_toJs(x2)
							},
						)
					},
				)
			}

			override fun getInvoice(groupId: String, entityId: String): Promise<GroupScopedJs<InvoiceJs>?> =
					GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdConverted: String = entityId
				val result = invoiceApi.inGroup.tryAndRecover.getInvoice(
					groupIdConverted,
					entityIdConverted,
				)
				nullToUndefined(
					result?.let { nonNull1 ->
						groupScoped_toJs(
							nonNull1,
							{ x1: Invoice ->
								invoice_toJs(x1)
							},
						)
					}
				)
			}

			override fun getInvoices(groupId: String, entityIds: Array<String>):
					Promise<Array<GroupScopedJs<InvoiceJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdsConverted: List<String> = arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)
				val result = invoiceApi.inGroup.tryAndRecover.getInvoices(
					groupIdConverted,
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Invoice> ->
						groupScoped_toJs(
							x1,
							{ x2: Invoice ->
								invoice_toJs(x2)
							},
						)
					},
				)
			}
		}

		override fun withEncryptionMetadata(
			entityGroupId: String,
			base: DecryptedInvoiceJs?,
			patient: GroupScopedJs<PatientJs>?,
			options: dynamic,
		): Promise<GroupScopedJs<DecryptedInvoiceJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val entityGroupIdConverted: String = entityGroupId
				val baseConverted: DecryptedInvoice? = base?.let { nonNull1 ->
					invoice_fromJs(nonNull1)
				}
				val patientConverted: GroupScoped<Patient>? = patient?.let { nonNull1 ->
					groupScoped_fromJs(
						nonNull1,
						{ x1: PatientJs ->
							patient_fromJs(x1)
						},
					)
				}
				val userConverted: User? = convertingOptionOrDefaultNullable(
					_options,
					"user",
					null
				) { user: UserJs? ->
					user?.let { nonNull1 ->
						user_fromJs(nonNull1)
					}
				}
				val delegatesConverted: Map<EntityReferenceInGroup, AccessLevel> =
						convertingOptionOrDefaultNonNull(
					_options,
					"delegates",
					emptyMap()
				) { delegates: Array<EntityReferenceInGroupToAccessLevelMapObject_delegate_accessLevel> ->
					EntityReferenceInGroupToAccessLevelMapObject_delegate_accessLevel_fromJs(delegates)
				}
				val secretIdConverted: SecretIdUseOption = convertingOptionOrDefaultNonNull(
					_options,
					"secretId",
					com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent
				) { secretId: SecretIdUseOptionJs ->
					secretIdUseOption_fromJs(secretId)
				}
				val alternateRootDelegateReferenceConverted: EntityReferenceInGroup? =
						convertingOptionOrDefaultNullable(
					_options,
					"alternateRootDelegateReference",
					null
				) { alternateRootDelegateReference: EntityReferenceInGroupJs? ->
					alternateRootDelegateReference?.let { nonNull1 ->
						entityReferenceInGroup_fromJs(nonNull1)
					}
				}
				val result = invoiceApi.inGroup.withEncryptionMetadata(
					entityGroupIdConverted,
					baseConverted,
					patientConverted,
					userConverted,
					delegatesConverted,
					secretIdConverted,
					alternateRootDelegateReferenceConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: DecryptedInvoice ->
						invoice_toJs(x1)
					},
				)
			}
		}

		override fun getEncryptionKeysOf(invoice: GroupScopedJs<InvoiceJs>): Promise<Array<String>> =
				GlobalScope.promise {
			val invoiceConverted: GroupScoped<Invoice> = groupScoped_fromJs(
				invoice,
				{ x1: InvoiceJs ->
					invoice_fromJs(x1)
				},
			)
			val result = invoiceApi.inGroup.getEncryptionKeysOf(
				invoiceConverted,
			)
			setToArray(
				result,
				{ x1: HexString ->
					hexString_toJs(x1)
				},
			)
		}

		override fun hasWriteAccess(invoice: GroupScopedJs<InvoiceJs>): Promise<Boolean> =
				GlobalScope.promise {
			val invoiceConverted: GroupScoped<Invoice> = groupScoped_fromJs(
				invoice,
				{ x1: InvoiceJs ->
					invoice_fromJs(x1)
				},
			)
			val result = invoiceApi.inGroup.hasWriteAccess(
				invoiceConverted,
			)
			result
		}

		override fun decryptPatientIdOf(invoice: GroupScopedJs<InvoiceJs>):
				Promise<Array<EntityReferenceInGroupJs>> = GlobalScope.promise {
			val invoiceConverted: GroupScoped<Invoice> = groupScoped_fromJs(
				invoice,
				{ x1: InvoiceJs ->
					invoice_fromJs(x1)
				},
			)
			val result = invoiceApi.inGroup.decryptPatientIdOf(
				invoiceConverted,
			)
			setToArray(
				result,
				{ x1: EntityReferenceInGroup ->
					entityReferenceInGroup_toJs(x1)
				},
			)
		}

		override fun createDelegationDeAnonymizationMetadata(entity: GroupScopedJs<InvoiceJs>,
				delegates: Array<EntityReferenceInGroupJs>): Promise<Unit> = GlobalScope.promise {
			val entityConverted: GroupScoped<Invoice> = groupScoped_fromJs(
				entity,
				{ x1: InvoiceJs ->
					invoice_fromJs(x1)
				},
			)
			val delegatesConverted: Set<EntityReferenceInGroup> = arrayToSet(
				delegates,
				"delegates",
				{ x1: EntityReferenceInGroupJs ->
					entityReferenceInGroup_fromJs(x1)
				},
			)
			invoiceApi.inGroup.createDelegationDeAnonymizationMetadata(
				entityConverted,
				delegatesConverted,
			)

		}

		override fun decrypt(invoices: Array<GroupScopedJs<EncryptedInvoiceJs>>):
				Promise<Array<GroupScopedJs<DecryptedInvoiceJs>>> = GlobalScope.promise {
			val invoicesConverted: List<GroupScoped<EncryptedInvoice>> = arrayToList(
				invoices,
				"invoices",
				{ x1: GroupScopedJs<EncryptedInvoiceJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedInvoiceJs ->
							invoice_fromJs(x2)
						},
					)
				},
			)
			val result = invoiceApi.inGroup.decrypt(
				invoicesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedInvoice> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedInvoice ->
							invoice_toJs(x2)
						},
					)
				},
			)
		}

		override fun tryDecrypt(invoices: Array<GroupScopedJs<EncryptedInvoiceJs>>):
				Promise<Array<GroupScopedJs<InvoiceJs>>> = GlobalScope.promise {
			val invoicesConverted: List<GroupScoped<EncryptedInvoice>> = arrayToList(
				invoices,
				"invoices",
				{ x1: GroupScopedJs<EncryptedInvoiceJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedInvoiceJs ->
							invoice_fromJs(x2)
						},
					)
				},
			)
			val result = invoiceApi.inGroup.tryDecrypt(
				invoicesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Invoice> ->
					groupScoped_toJs(
						x1,
						{ x2: Invoice ->
							invoice_toJs(x2)
						},
					)
				},
			)
		}

		override fun deleteInvoiceById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = invoiceApi.inGroup.deleteInvoiceById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteInvoicesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
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
			val result = invoiceApi.inGroup.deleteInvoicesByIds(
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

		override fun purgeInvoiceById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit>
				= GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			invoiceApi.inGroup.purgeInvoiceById(
				entityIdConverted,
			)

		}

		override fun purgeInvoicesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
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
			val result = invoiceApi.inGroup.purgeInvoicesByIds(
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

		override fun deleteInvoice(invoice: GroupScopedJs<InvoiceJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val invoiceConverted: GroupScoped<Invoice> = groupScoped_fromJs(
				invoice,
				{ x1: InvoiceJs ->
					invoice_fromJs(x1)
				},
			)
			val result = invoiceApi.inGroup.deleteInvoice(
				invoiceConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteInvoices(invoices: Array<GroupScopedJs<InvoiceJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val invoicesConverted: List<GroupScoped<Invoice>> = arrayToList(
				invoices,
				"invoices",
				{ x1: GroupScopedJs<InvoiceJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: InvoiceJs ->
							invoice_fromJs(x2)
						},
					)
				},
			)
			val result = invoiceApi.inGroup.deleteInvoices(
				invoicesConverted,
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

		override fun purgeInvoice(invoice: GroupScopedJs<InvoiceJs>): Promise<Unit> =
				GlobalScope.promise {
			val invoiceConverted: GroupScoped<Invoice> = groupScoped_fromJs(
				invoice,
				{ x1: InvoiceJs ->
					invoice_fromJs(x1)
				},
			)
			invoiceApi.inGroup.purgeInvoice(
				invoiceConverted,
			)

		}

		override fun purgeInvoices(invoices: Array<GroupScopedJs<InvoiceJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val invoicesConverted: List<GroupScoped<Invoice>> = arrayToList(
				invoices,
				"invoices",
				{ x1: GroupScopedJs<InvoiceJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: InvoiceJs ->
							invoice_fromJs(x2)
						},
					)
				},
			)
			val result = invoiceApi.inGroup.purgeInvoices(
				invoicesConverted,
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

		override fun shareWith(
			`delegate`: EntityReferenceInGroupJs,
			invoice: GroupScopedJs<DecryptedInvoiceJs>,
			options: dynamic,
		): Promise<GroupScopedJs<DecryptedInvoiceJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
				val invoiceConverted: GroupScoped<DecryptedInvoice> = groupScoped_fromJs(
					invoice,
					{ x1: DecryptedInvoiceJs ->
						invoice_fromJs(x1)
					},
				)
				val optionsConverted: InvoiceShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: InvoiceShareOptionsJs? ->
					options?.let { nonNull1 ->
						invoiceShareOptions_fromJs(nonNull1)
					}
				}
				val result = invoiceApi.inGroup.shareWith(
					delegateConverted,
					invoiceConverted,
					optionsConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: DecryptedInvoice ->
						invoice_toJs(x1)
					},
				)
			}
		}

		override fun shareWithMany(invoice: GroupScopedJs<DecryptedInvoiceJs>,
				delegates: Array<EntityReferenceInGroupToInvoiceShareOptionsMapObject_delegate_shareOptions>):
				Promise<GroupScopedJs<DecryptedInvoiceJs>> = GlobalScope.promise {
			val invoiceConverted: GroupScoped<DecryptedInvoice> = groupScoped_fromJs(
				invoice,
				{ x1: DecryptedInvoiceJs ->
					invoice_fromJs(x1)
				},
			)
			val delegatesConverted: Map<EntityReferenceInGroup, InvoiceShareOptions> =
					EntityReferenceInGroupToInvoiceShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
			val result = invoiceApi.inGroup.shareWithMany(
				invoiceConverted,
				delegatesConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun createInvoice(entity: GroupScopedJs<DecryptedInvoiceJs>):
				Promise<GroupScopedJs<DecryptedInvoiceJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<DecryptedInvoice> = groupScoped_fromJs(
				entity,
				{ x1: DecryptedInvoiceJs ->
					invoice_fromJs(x1)
				},
			)
			val result = invoiceApi.inGroup.createInvoice(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun createInvoices(entities: Array<GroupScopedJs<DecryptedInvoiceJs>>):
				Promise<Array<GroupScopedJs<DecryptedInvoiceJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<DecryptedInvoice>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<DecryptedInvoiceJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DecryptedInvoiceJs ->
							invoice_fromJs(x2)
						},
					)
				},
			)
			val result = invoiceApi.inGroup.createInvoices(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedInvoice> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedInvoice ->
							invoice_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteInvoiceById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<DecryptedInvoiceJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = invoiceApi.inGroup.undeleteInvoiceById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun undeleteInvoicesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<DecryptedInvoiceJs>>> = GlobalScope.promise {
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
			val result = invoiceApi.inGroup.undeleteInvoicesByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedInvoice> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedInvoice ->
							invoice_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteInvoice(invoice: GroupScopedJs<InvoiceJs>):
				Promise<GroupScopedJs<DecryptedInvoiceJs>> = GlobalScope.promise {
			val invoiceConverted: GroupScoped<Invoice> = groupScoped_fromJs(
				invoice,
				{ x1: InvoiceJs ->
					invoice_fromJs(x1)
				},
			)
			val result = invoiceApi.inGroup.undeleteInvoice(
				invoiceConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun undeleteInvoices(invoices: Array<GroupScopedJs<DecryptedInvoiceJs>>):
				Promise<Array<GroupScopedJs<DecryptedInvoiceJs>>> = GlobalScope.promise {
			val invoicesConverted: List<GroupScoped<DecryptedInvoice>> = arrayToList(
				invoices,
				"invoices",
				{ x1: GroupScopedJs<DecryptedInvoiceJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DecryptedInvoiceJs ->
							invoice_fromJs(x2)
						},
					)
				},
			)
			val result = invoiceApi.inGroup.undeleteInvoices(
				invoicesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedInvoice> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedInvoice ->
							invoice_toJs(x2)
						},
					)
				},
			)
		}

		override fun modifyInvoice(entity: GroupScopedJs<DecryptedInvoiceJs>):
				Promise<GroupScopedJs<DecryptedInvoiceJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<DecryptedInvoice> = groupScoped_fromJs(
				entity,
				{ x1: DecryptedInvoiceJs ->
					invoice_fromJs(x1)
				},
			)
			val result = invoiceApi.inGroup.modifyInvoice(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun modifyInvoices(entities: Array<GroupScopedJs<DecryptedInvoiceJs>>):
				Promise<Array<GroupScopedJs<DecryptedInvoiceJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<DecryptedInvoice>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<DecryptedInvoiceJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DecryptedInvoiceJs ->
							invoice_fromJs(x2)
						},
					)
				},
			)
			val result = invoiceApi.inGroup.modifyInvoices(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedInvoice> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedInvoice ->
							invoice_toJs(x2)
						},
					)
				},
			)
		}

		override fun getInvoice(groupId: String, entityId: String):
				Promise<GroupScopedJs<DecryptedInvoiceJs>?> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdConverted: String = entityId
			val result = invoiceApi.inGroup.getInvoice(
				groupIdConverted,
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: DecryptedInvoice ->
							invoice_toJs(x1)
						},
					)
				}
			)
		}

		override fun getInvoices(groupId: String, entityIds: Array<String>):
				Promise<Array<GroupScopedJs<DecryptedInvoiceJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = invoiceApi.inGroup.getInvoices(
				groupIdConverted,
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedInvoice> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedInvoice ->
							invoice_toJs(x2)
						},
					)
				},
			)
		}
	}

	override fun withEncryptionMetadata(
		base: DecryptedInvoiceJs?,
		patient: PatientJs?,
		options: dynamic,
	): Promise<DecryptedInvoiceJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedInvoice? = base?.let { nonNull1 ->
				invoice_fromJs(nonNull1)
			}
			val patientConverted: Patient? = patient?.let { nonNull1 ->
				patient_fromJs(nonNull1)
			}
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
				com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent
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
			val result = invoiceApi.withEncryptionMetadata(
				baseConverted,
				patientConverted,
				userConverted,
				delegatesConverted,
				secretIdConverted,
				alternateRootDelegateIdConverted,
			)
			invoice_toJs(result)
		}
	}

	override fun getEncryptionKeysOf(invoice: InvoiceJs): Promise<Array<String>> =
			GlobalScope.promise {
		val invoiceConverted: Invoice = invoice_fromJs(invoice)
		val result = invoiceApi.getEncryptionKeysOf(
			invoiceConverted,
		)
		setToArray(
			result,
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)
	}

	override fun hasWriteAccess(invoice: InvoiceJs): Promise<Boolean> = GlobalScope.promise {
		val invoiceConverted: Invoice = invoice_fromJs(invoice)
		val result = invoiceApi.hasWriteAccess(
			invoiceConverted,
		)
		result
	}

	override fun decryptPatientIdOf(invoice: InvoiceJs): Promise<Array<EntityReferenceInGroupJs>> =
			GlobalScope.promise {
		val invoiceConverted: Invoice = invoice_fromJs(invoice)
		val result = invoiceApi.decryptPatientIdOf(
			invoiceConverted,
		)
		setToArray(
			result,
			{ x1: EntityReferenceInGroup ->
				entityReferenceInGroup_toJs(x1)
			},
		)
	}

	override fun createDelegationDeAnonymizationMetadata(entity: InvoiceJs, delegates: Array<String>):
			Promise<Unit> = GlobalScope.promise {
		val entityConverted: Invoice = invoice_fromJs(entity)
		val delegatesConverted: Set<String> = arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		)
		invoiceApi.createDelegationDeAnonymizationMetadata(
			entityConverted,
			delegatesConverted,
		)

	}

	override fun decrypt(invoice: EncryptedInvoiceJs): Promise<DecryptedInvoiceJs> =
			GlobalScope.promise {
		val invoiceConverted: EncryptedInvoice = invoice_fromJs(invoice)
		val result = invoiceApi.decrypt(
			invoiceConverted,
		)
		invoice_toJs(result)
	}

	override fun tryDecrypt(invoice: EncryptedInvoiceJs): Promise<InvoiceJs> = GlobalScope.promise {
		val invoiceConverted: EncryptedInvoice = invoice_fromJs(invoice)
		val result = invoiceApi.tryDecrypt(
			invoiceConverted,
		)
		invoice_toJs(result)
	}

	override fun deleteInvoiceById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs>
			= GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = invoiceApi.deleteInvoiceById(
			entityIdConverted,
			revConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteInvoicesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = invoiceApi.deleteInvoicesByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeInvoiceById(id: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		invoiceApi.purgeInvoiceById(
			idConverted,
			revConverted,
		)

	}

	override fun purgeInvoicesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = invoiceApi.purgeInvoicesByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteInvoice(invoice: InvoiceJs): Promise<StoredDocumentIdentifierJs> =
			GlobalScope.promise {
		val invoiceConverted: Invoice = invoice_fromJs(invoice)
		val result = invoiceApi.deleteInvoice(
			invoiceConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteInvoices(invoices: Array<InvoiceJs>): Promise<Array<StoredDocumentIdentifierJs>>
			= GlobalScope.promise {
		val invoicesConverted: List<Invoice> = arrayToList(
			invoices,
			"invoices",
			{ x1: InvoiceJs ->
				invoice_fromJs(x1)
			},
		)
		val result = invoiceApi.deleteInvoices(
			invoicesConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeInvoice(invoice: InvoiceJs): Promise<Unit> = GlobalScope.promise {
		val invoiceConverted: Invoice = invoice_fromJs(invoice)
		invoiceApi.purgeInvoice(
			invoiceConverted,
		)

	}

	override fun purgeInvoices(invoices: Array<InvoiceJs>): Promise<Array<StoredDocumentIdentifierJs>>
			= GlobalScope.promise {
		val invoicesConverted: List<Invoice> = arrayToList(
			invoices,
			"invoices",
			{ x1: InvoiceJs ->
				invoice_fromJs(x1)
			},
		)
		val result = invoiceApi.purgeInvoices(
			invoicesConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun getTarificationsCodesOccurrences(minOccurrence: Double):
			Promise<Array<LabelledOccurenceJs>> = GlobalScope.promise {
		val minOccurrenceConverted: Int = numberToInt(minOccurrence, "minOccurrence")
		val result = invoiceApi.getTarificationsCodesOccurrences(
			minOccurrenceConverted,
		)
		listToArray(
			result,
			{ x1: LabelledOccurence ->
				labelledOccurence_toJs(x1)
			},
		)
	}

	override fun shareWith(
		delegateId: String,
		invoice: DecryptedInvoiceJs,
		options: dynamic,
	): Promise<DecryptedInvoiceJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val invoiceConverted: DecryptedInvoice = invoice_fromJs(invoice)
			val optionsConverted: InvoiceShareOptions? = convertingOptionOrDefaultNullable(
				_options,
				"options",
				null
			) { options: InvoiceShareOptionsJs? ->
				options?.let { nonNull1 ->
					invoiceShareOptions_fromJs(nonNull1)
				}
			}
			val result = invoiceApi.shareWith(
				delegateIdConverted,
				invoiceConverted,
				optionsConverted,
			)
			invoice_toJs(result)
		}
	}

	override fun shareWithMany(invoice: DecryptedInvoiceJs,
			delegates: Record<String, InvoiceShareOptionsJs>): Promise<DecryptedInvoiceJs> =
			GlobalScope.promise {
		val invoiceConverted: DecryptedInvoice = invoice_fromJs(invoice)
		val delegatesConverted: Map<String, InvoiceShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: InvoiceShareOptionsJs ->
				invoiceShareOptions_fromJs(x1)
			},
		)
		val result = invoiceApi.shareWithMany(
			invoiceConverted,
			delegatesConverted,
		)
		invoice_toJs(result)
	}

	override fun findInvoicesByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: dynamic,
	): Promise<PaginatedListIteratorJs<DecryptedInvoiceJs>> {
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
			val result = invoiceApi.findInvoicesByHcPartyPatient(
				hcPartyIdConverted,
				patientConverted,
				startDateConverted,
				endDateConverted,
				descendingConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: DecryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}
	}

	override fun createInvoice(entity: DecryptedInvoiceJs): Promise<DecryptedInvoiceJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedInvoice = invoice_fromJs(entity)
		val result = invoiceApi.createInvoice(
			entityConverted,
		)
		invoice_toJs(result)
	}

	override fun createInvoices(entities: Array<DecryptedInvoiceJs>):
			Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		val entitiesConverted: List<DecryptedInvoice> = arrayToList(
			entities,
			"entities",
			{ x1: DecryptedInvoiceJs ->
				invoice_fromJs(x1)
			},
		)
		val result = invoiceApi.createInvoices(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun undeleteInvoiceById(id: String, rev: String): Promise<DecryptedInvoiceJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = invoiceApi.undeleteInvoiceById(
			idConverted,
			revConverted,
		)
		invoice_toJs(result)
	}

	override fun undeleteInvoicesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = invoiceApi.undeleteInvoicesByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun undeleteInvoice(invoice: InvoiceJs): Promise<DecryptedInvoiceJs> =
			GlobalScope.promise {
		val invoiceConverted: Invoice = invoice_fromJs(invoice)
		val result = invoiceApi.undeleteInvoice(
			invoiceConverted,
		)
		invoice_toJs(result)
	}

	override fun undeleteInvoices(invoices: Array<InvoiceJs>): Promise<Array<DecryptedInvoiceJs>> =
			GlobalScope.promise {
		val invoicesConverted: List<Invoice> = arrayToList(
			invoices,
			"invoices",
			{ x1: InvoiceJs ->
				invoice_fromJs(x1)
			},
		)
		val result = invoiceApi.undeleteInvoices(
			invoicesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun modifyInvoice(entity: DecryptedInvoiceJs): Promise<DecryptedInvoiceJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedInvoice = invoice_fromJs(entity)
		val result = invoiceApi.modifyInvoice(
			entityConverted,
		)
		invoice_toJs(result)
	}

	override fun modifyInvoices(entities: Array<DecryptedInvoiceJs>):
			Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		val entitiesConverted: List<DecryptedInvoice> = arrayToList(
			entities,
			"entities",
			{ x1: DecryptedInvoiceJs ->
				invoice_fromJs(x1)
			},
		)
		val result = invoiceApi.modifyInvoices(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun getInvoice(entityId: String): Promise<DecryptedInvoiceJs?> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = invoiceApi.getInvoice(
			entityIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				invoice_toJs(nonNull1)
			}
		)
	}

	override fun getInvoices(entityIds: Array<String>): Promise<Array<DecryptedInvoiceJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = invoiceApi.getInvoices(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun reassignInvoice(invoice: DecryptedInvoiceJs): Promise<DecryptedInvoiceJs> =
			GlobalScope.promise {
		val invoiceConverted: DecryptedInvoice = invoice_fromJs(invoice)
		val result = invoiceApi.reassignInvoice(
			invoiceConverted,
		)
		invoice_toJs(result)
	}

	override fun mergeTo(invoiceId: String, ids: Array<String>): Promise<DecryptedInvoiceJs> =
			GlobalScope.promise {
		val invoiceIdConverted: String = invoiceId
		val idsConverted: List<String> = arrayToList(
			ids,
			"ids",
			{ x1: String ->
				x1
			},
		)
		val result = invoiceApi.mergeTo(
			invoiceIdConverted,
			idsConverted,
		)
		invoice_toJs(result)
	}

	override fun validate(
		invoiceId: String,
		scheme: String,
		forcedValue: String,
	): Promise<DecryptedInvoiceJs> = GlobalScope.promise {
		val invoiceIdConverted: String = invoiceId
		val schemeConverted: String = scheme
		val forcedValueConverted: String = forcedValue
		val result = invoiceApi.validate(
			invoiceIdConverted,
			schemeConverted,
			forcedValueConverted,
		)
		invoice_toJs(result)
	}

	override fun appendCodes(
		userId: String,
		type: String,
		sentMediumType: String,
		secretFKeys: String,
		invoicingCodes: Array<EncryptedInvoicingCodeJs>,
		options: dynamic,
	): Promise<Array<DecryptedInvoiceJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val userIdConverted: String = userId
			val typeConverted: String = type
			val sentMediumTypeConverted: String = sentMediumType
			val secretFKeysConverted: String = secretFKeys
			val insuranceIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"insuranceId",
				null
			) { insuranceId: String? ->
				undefinedToNull(insuranceId)
			}
			val invoiceIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"invoiceId",
				null
			) { invoiceId: String? ->
				undefinedToNull(invoiceId)
			}
			val gracePeriodConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"gracePeriod",
				null
			) { gracePeriod: Double? ->
				numberToInt(gracePeriod, "gracePeriod")
			}
			val invoicingCodesConverted: List<EncryptedInvoicingCode> = arrayToList(
				invoicingCodes,
				"invoicingCodes",
				{ x1: EncryptedInvoicingCodeJs ->
					invoicingCode_fromJs(x1)
				},
			)
			val result = invoiceApi.appendCodes(
				userIdConverted,
				typeConverted,
				sentMediumTypeConverted,
				secretFKeysConverted,
				insuranceIdConverted,
				invoiceIdConverted,
				gracePeriodConverted,
				invoicingCodesConverted,
			)
			listToArray(
				result,
				{ x1: DecryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}
	}

	override fun removeCodes(
		userId: String,
		serviceId: String,
		secretFKeys: String,
		tarificationIds: Array<String>,
	): Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		val userIdConverted: String = userId
		val serviceIdConverted: String = serviceId
		val secretFKeysConverted: String = secretFKeys
		val tarificationIdsConverted: List<String> = arrayToList(
			tarificationIds,
			"tarificationIds",
			{ x1: String ->
				x1
			},
		)
		val result = invoiceApi.removeCodes(
			userIdConverted,
			serviceIdConverted,
			secretFKeysConverted,
			tarificationIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun findInvoicesByAuthor(hcPartyId: String, options: dynamic):
			Promise<PaginatedListJs<DecryptedInvoiceJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val fromDateConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"fromDate",
				null
			) { fromDate: Double? ->
				numberToLong(fromDate, "fromDate")
			}
			val toDateConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"toDate",
				null
			) { toDate: Double? ->
				numberToLong(toDate, "toDate")
			}
			val startKeyConverted: JsonElement? = convertingOptionOrDefaultNullable(
				_options,
				"startKey",
				null
			) { startKey: dynamic ->
				dynamicToJsonNullsafe(startKey, "startKey")
			}
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
			val result = invoiceApi.findInvoicesByAuthor(
				hcPartyIdConverted,
				fromDateConverted,
				toDateConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: DecryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}
	}

	override fun listInvoicesByHcPartyAndGroupId(hcPartyId: String, groupId: String):
			Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val groupIdConverted: String = groupId
		val result = invoiceApi.listInvoicesByHcPartyAndGroupId(
			hcPartyIdConverted,
			groupIdConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
		hcPartyId: String,
		sentMediumType: String,
		invoiceType: String,
		sent: Boolean,
		options: dynamic,
	): Promise<Array<DecryptedInvoiceJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val sentMediumTypeConverted: MediumType = MediumType.valueOf(sentMediumType)
			val invoiceTypeConverted: InvoiceType = InvoiceType.valueOf(invoiceType)
			val sentConverted: Boolean = sent
			val fromConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"from",
				null
			) { from: Double? ->
				numberToLong(from, "from")
			}
			val toConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"to",
				null
			) { to: Double? ->
				numberToLong(to, "to")
			}
			val result = invoiceApi.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
				hcPartyIdConverted,
				sentMediumTypeConverted,
				invoiceTypeConverted,
				sentConverted,
				fromConverted,
				toConverted,
			)
			listToArray(
				result,
				{ x1: DecryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}
	}

	override fun listInvoicesByContactIds(contactIds: Array<String>):
			Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		val contactIdsConverted: List<String> = arrayToList(
			contactIds,
			"contactIds",
			{ x1: String ->
				x1
			},
		)
		val result = invoiceApi.listInvoicesByContactIds(
			contactIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun listInvoicesByRecipientsIds(recipientsIds: Array<String>):
			Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		val recipientsIdsConverted: List<String> = arrayToList(
			recipientsIds,
			"recipientsIds",
			{ x1: String ->
				x1
			},
		)
		val result = invoiceApi.listInvoicesByRecipientsIds(
			recipientsIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun listToInsurances(userIds: Array<String>): Promise<Array<DecryptedInvoiceJs>> =
			GlobalScope.promise {
		val userIdsConverted: List<String> = arrayToList(
			userIds,
			"userIds",
			{ x1: String ->
				x1
			},
		)
		val result = invoiceApi.listToInsurances(
			userIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun listToInsurancesUnsent(userIds: Array<String>): Promise<Array<DecryptedInvoiceJs>> =
			GlobalScope.promise {
		val userIdsConverted: List<String> = arrayToList(
			userIds,
			"userIds",
			{ x1: String ->
				x1
			},
		)
		val result = invoiceApi.listToInsurancesUnsent(
			userIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun listToPatients(hcPartyId: String): Promise<Array<DecryptedInvoiceJs>> =
			GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val result = invoiceApi.listToPatients(
			hcPartyIdConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun listToPatientsUnsent(hcPartyId: String?): Promise<Array<DecryptedInvoiceJs>> =
			GlobalScope.promise {
		val hcPartyIdConverted: String? = undefinedToNull(hcPartyId)
		val result = invoiceApi.listToPatientsUnsent(
			hcPartyIdConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun listInvoicesByIds(ids: Array<String>): Promise<Array<DecryptedInvoiceJs>> =
			GlobalScope.promise {
		val idsConverted: List<String> = arrayToList(
			ids,
			"ids",
			{ x1: String ->
				x1
			},
		)
		val result = invoiceApi.listInvoicesByIds(
			idsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun listInvoicesByHcpartySendingModeStatusDate(
		hcPartyId: String,
		sendingMode: String,
		status: String,
		from: Double,
		to: Double,
	): Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val sendingModeConverted: String = sendingMode
		val statusConverted: String = status
		val fromConverted: Long = numberToLong(from, "from")
		val toConverted: Long = numberToLong(to, "to")
		val result = invoiceApi.listInvoicesByHcpartySendingModeStatusDate(
			hcPartyIdConverted,
			sendingModeConverted,
			statusConverted,
			fromConverted,
			toConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun listInvoicesByServiceIds(serviceIds: Array<String>):
			Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		val serviceIdsConverted: List<String> = arrayToList(
			serviceIds,
			"serviceIds",
			{ x1: String ->
				x1
			},
		)
		val result = invoiceApi.listInvoicesByServiceIds(
			serviceIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun listAllHcpsByStatus(
		status: String,
		hcpIds: Array<String>,
		options: dynamic,
	): Promise<Array<DecryptedInvoiceJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val statusConverted: String = status
			val fromConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"from",
				null
			) { from: Double? ->
				numberToLong(from, "from")
			}
			val toConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"to",
				null
			) { to: Double? ->
				numberToLong(to, "to")
			}
			val hcpIdsConverted: List<String> = arrayToList(
				hcpIds,
				"hcpIds",
				{ x1: String ->
					x1
				},
			)
			val result = invoiceApi.listAllHcpsByStatus(
				statusConverted,
				fromConverted,
				toConverted,
				hcpIdsConverted,
			)
			listToArray(
				result,
				{ x1: DecryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}
	}
}
