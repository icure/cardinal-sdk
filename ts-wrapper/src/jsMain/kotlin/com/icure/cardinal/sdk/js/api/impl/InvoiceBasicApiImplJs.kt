// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.InvoiceBasicApi
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.InvoiceBasicApiJs
import com.icure.cardinal.sdk.js.api.InvoiceBasicInGroupApiJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.EncryptedInvoiceJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.InvoiceJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.`data`.LabelledOccurenceJs
import com.icure.cardinal.sdk.js.model.`data`.labelledOccurence_toJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedInvoicingCodeJs
import com.icure.cardinal.sdk.js.model.embed.invoicingCode_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
import com.icure.cardinal.sdk.js.model.invoice_fromJs
import com.icure.cardinal.sdk.js.model.invoice_toJs
import com.icure.cardinal.sdk.js.model.paginatedList_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_toJs
import com.icure.cardinal.sdk.model.EncryptedInvoice
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Invoice
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.`data`.LabelledOccurence
import com.icure.cardinal.sdk.model.embed.EncryptedInvoicingCode
import com.icure.cardinal.sdk.model.embed.InvoiceType
import com.icure.cardinal.sdk.model.embed.MediumType
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import kotlinx.serialization.json.JsonElement

@OptIn(DelicateCoroutinesApi::class)
internal class InvoiceBasicApiImplJs(
	private val invoiceBasicApi: InvoiceBasicApi,
) : InvoiceBasicApiJs {
	override val inGroup: InvoiceBasicInGroupApiJs = object : InvoiceBasicInGroupApiJs {
		override fun deleteInvoiceById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = invoiceBasicApi.inGroup.deleteInvoiceById(
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
			val result = invoiceBasicApi.inGroup.deleteInvoicesByIds(
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
			invoiceBasicApi.inGroup.purgeInvoiceById(
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
			val result = invoiceBasicApi.inGroup.purgeInvoicesByIds(
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
			val result = invoiceBasicApi.inGroup.deleteInvoice(
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
			val result = invoiceBasicApi.inGroup.deleteInvoices(
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
			invoiceBasicApi.inGroup.purgeInvoice(
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
			val result = invoiceBasicApi.inGroup.purgeInvoices(
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

		override fun createInvoice(entity: GroupScopedJs<EncryptedInvoiceJs>):
				Promise<GroupScopedJs<EncryptedInvoiceJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<EncryptedInvoice> = groupScoped_fromJs(
				entity,
				{ x1: EncryptedInvoiceJs ->
					invoice_fromJs(x1)
				},
			)
			val result = invoiceBasicApi.inGroup.createInvoice(
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
			val result = invoiceBasicApi.inGroup.createInvoices(
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
			val result = invoiceBasicApi.inGroup.undeleteInvoiceById(
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
			val result = invoiceBasicApi.inGroup.undeleteInvoicesByIds(
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
			val result = invoiceBasicApi.inGroup.undeleteInvoice(
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
			val result = invoiceBasicApi.inGroup.undeleteInvoices(
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
			val result = invoiceBasicApi.inGroup.modifyInvoice(
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
			val result = invoiceBasicApi.inGroup.modifyInvoices(
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
			val result = invoiceBasicApi.inGroup.getInvoice(
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
			val result = invoiceBasicApi.inGroup.getInvoices(
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

	override fun deleteInvoiceById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs>
			= GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = invoiceBasicApi.deleteInvoiceById(
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
		val result = invoiceBasicApi.deleteInvoicesByIds(
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
		invoiceBasicApi.purgeInvoiceById(
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
		val result = invoiceBasicApi.purgeInvoicesByIds(
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
		val result = invoiceBasicApi.deleteInvoice(
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
		val result = invoiceBasicApi.deleteInvoices(
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
		invoiceBasicApi.purgeInvoice(
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
		val result = invoiceBasicApi.purgeInvoices(
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
		val result = invoiceBasicApi.getTarificationsCodesOccurrences(
			minOccurrenceConverted,
		)
		listToArray(
			result,
			{ x1: LabelledOccurence ->
				labelledOccurence_toJs(x1)
			},
		)
	}

	override fun createInvoice(entity: EncryptedInvoiceJs): Promise<EncryptedInvoiceJs> =
			GlobalScope.promise {
		val entityConverted: EncryptedInvoice = invoice_fromJs(entity)
		val result = invoiceBasicApi.createInvoice(
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
		val result = invoiceBasicApi.createInvoices(
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
		val result = invoiceBasicApi.undeleteInvoiceById(
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
		val result = invoiceBasicApi.undeleteInvoicesByIds(
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
		val result = invoiceBasicApi.undeleteInvoice(
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
		val result = invoiceBasicApi.undeleteInvoices(
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
		val result = invoiceBasicApi.modifyInvoice(
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
		val result = invoiceBasicApi.modifyInvoices(
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
		val result = invoiceBasicApi.getInvoice(
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
		val result = invoiceBasicApi.getInvoices(
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
		val result = invoiceBasicApi.reassignInvoice(
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
		val result = invoiceBasicApi.mergeTo(
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
		val result = invoiceBasicApi.validate(
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
			val result = invoiceBasicApi.appendCodes(
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
		val result = invoiceBasicApi.removeCodes(
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
			val result = invoiceBasicApi.findInvoicesByAuthor(
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
		val result = invoiceBasicApi.listInvoicesByHcPartyAndGroupId(
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
			val result = invoiceBasicApi.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
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
		val result = invoiceBasicApi.listInvoicesByContactIds(
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
		val result = invoiceBasicApi.listInvoicesByRecipientsIds(
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
		val result = invoiceBasicApi.listToInsurances(
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
		val result = invoiceBasicApi.listToInsurancesUnsent(
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
		val result = invoiceBasicApi.listToPatients(
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
		val result = invoiceBasicApi.listToPatientsUnsent(
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
		val result = invoiceBasicApi.listInvoicesByIds(
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
		val result = invoiceBasicApi.listInvoicesByHcpartySendingModeStatusDate(
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
		val result = invoiceBasicApi.listInvoicesByServiceIds(
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
			val result = invoiceBasicApi.listAllHcpsByStatus(
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
