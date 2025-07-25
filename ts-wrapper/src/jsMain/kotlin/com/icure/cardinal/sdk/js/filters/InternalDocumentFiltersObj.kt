// auto-generated file
package com.icure.cardinal.sdk.js.filters

import com.icure.cardinal.sdk.filters.DocumentFilters
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInstant
import com.icure.cardinal.sdk.js.model.DocumentJs
import com.icure.cardinal.sdk.js.model.MessageJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.message_fromJs
import com.icure.cardinal.sdk.js.model.patient_fromJs
import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.embed.DocumentType
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.collections.List
import kotlin.js.JsExport
import kotlin.time.Instant

@JsExport
public object InternalDocumentFiltersObj {
	public fun byPatientsCreatedForDataOwner(
		dataOwnerId: String,
		patients: Array<PatientJs>,
		options: dynamic,
	): SortableFilterOptionsJs<DocumentJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val fromConverted: Instant? = convertingOptionOrDefaultNullable(
			_options,
			"from",
			null
		) { from: Double? ->
			numberToInstant(from, "from")
		}
		val toConverted: Instant? = convertingOptionOrDefaultNullable(
			_options,
			"to",
			null
		) { to: Double? ->
			numberToInstant(to, "to")
		}
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = DocumentFilters.byPatientsCreatedForDataOwner(
			dataOwnerIdConverted,
			patientsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byMessagesCreatedForDataOwner(
		dataOwnerId: String,
		messages: Array<MessageJs>,
		options: dynamic,
	): SortableFilterOptionsJs<DocumentJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val messagesConverted: List<Message> = arrayToList(
			messages,
			"messages",
			{ x1: MessageJs ->
				message_fromJs(x1)
			},
		)
		val fromConverted: Instant? = convertingOptionOrDefaultNullable(
			_options,
			"from",
			null
		) { from: Double? ->
			numberToInstant(from, "from")
		}
		val toConverted: Instant? = convertingOptionOrDefaultNullable(
			_options,
			"to",
			null
		) { to: Double? ->
			numberToInstant(to, "to")
		}
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = DocumentFilters.byMessagesCreatedForDataOwner(
			dataOwnerIdConverted,
			messagesConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsCreatedForSelf(patients: Array<PatientJs>, options: dynamic):
			SortableFilterOptionsJs<DocumentJs> {
		val _options = options ?: js("{}")
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val fromConverted: Instant? = convertingOptionOrDefaultNullable(
			_options,
			"from",
			null
		) { from: Double? ->
			numberToInstant(from, "from")
		}
		val toConverted: Instant? = convertingOptionOrDefaultNullable(
			_options,
			"to",
			null
		) { to: Double? ->
			numberToInstant(to, "to")
		}
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = DocumentFilters.byPatientsCreatedForSelf(
			patientsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byMessagesCreatedForSelf(messages: Array<MessageJs>, options: dynamic):
			SortableFilterOptionsJs<DocumentJs> {
		val _options = options ?: js("{}")
		val messagesConverted: List<Message> = arrayToList(
			messages,
			"messages",
			{ x1: MessageJs ->
				message_fromJs(x1)
			},
		)
		val fromConverted: Instant? = convertingOptionOrDefaultNullable(
			_options,
			"from",
			null
		) { from: Double? ->
			numberToInstant(from, "from")
		}
		val toConverted: Instant? = convertingOptionOrDefaultNullable(
			_options,
			"to",
			null
		) { to: Double? ->
			numberToInstant(to, "to")
		}
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = DocumentFilters.byMessagesCreatedForSelf(
			messagesConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byOwningEntitySecretIdsCreatedForDataOwner(
		dataOwnerId: String,
		secretIds: Array<String>,
		options: dynamic,
	): BaseSortableFilterOptionsJs<DocumentJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val fromConverted: Instant? = convertingOptionOrDefaultNullable(
			_options,
			"from",
			null
		) { from: Double? ->
			numberToInstant(from, "from")
		}
		val toConverted: Instant? = convertingOptionOrDefaultNullable(
			_options,
			"to",
			null
		) { to: Double? ->
			numberToInstant(to, "to")
		}
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = DocumentFilters.byOwningEntitySecretIdsCreatedForDataOwner(
			dataOwnerIdConverted,
			secretIdsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byOwningEntitySecretIdsCreatedForSelf(secretIds: Array<String>, options: dynamic):
			SortableFilterOptionsJs<DocumentJs> {
		val _options = options ?: js("{}")
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val fromConverted: Instant? = convertingOptionOrDefaultNullable(
			_options,
			"from",
			null
		) { from: Double? ->
			numberToInstant(from, "from")
		}
		val toConverted: Instant? = convertingOptionOrDefaultNullable(
			_options,
			"to",
			null
		) { to: Double? ->
			numberToInstant(to, "to")
		}
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = DocumentFilters.byOwningEntitySecretIdsCreatedForSelf(
			secretIdsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsAndTypeForDataOwner(
		dataOwnerId: String,
		documentType: String,
		patients: Array<PatientJs>,
	): FilterOptionsJs<DocumentJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val documentTypeConverted: DocumentType = DocumentType.valueOf(documentType)
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val result = DocumentFilters.byPatientsAndTypeForDataOwner(
			dataOwnerIdConverted,
			documentTypeConverted,
			patientsConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byMessagesAndTypeForDataOwner(
		dataOwnerId: String,
		documentType: String,
		messages: Array<MessageJs>,
	): FilterOptionsJs<DocumentJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val documentTypeConverted: DocumentType = DocumentType.valueOf(documentType)
		val messagesConverted: List<Message> = arrayToList(
			messages,
			"messages",
			{ x1: MessageJs ->
				message_fromJs(x1)
			},
		)
		val result = DocumentFilters.byMessagesAndTypeForDataOwner(
			dataOwnerIdConverted,
			documentTypeConverted,
			messagesConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byPatientsAndTypeForSelf(documentType: String, patients: Array<PatientJs>):
			FilterOptionsJs<DocumentJs> {
		val documentTypeConverted: DocumentType = DocumentType.valueOf(documentType)
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val result = DocumentFilters.byPatientsAndTypeForSelf(
			documentTypeConverted,
			patientsConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byMessagesAndTypeForSelf(documentType: String, messages: Array<MessageJs>):
			FilterOptionsJs<DocumentJs> {
		val documentTypeConverted: DocumentType = DocumentType.valueOf(documentType)
		val messagesConverted: List<Message> = arrayToList(
			messages,
			"messages",
			{ x1: MessageJs ->
				message_fromJs(x1)
			},
		)
		val result = DocumentFilters.byMessagesAndTypeForSelf(
			documentTypeConverted,
			messagesConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byOwningEntitySecretIdsAndTypeForDataOwner(
		dataOwnerId: String,
		documentType: String,
		secretIds: Array<String>,
	): FilterOptionsJs<DocumentJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val documentTypeConverted: DocumentType = DocumentType.valueOf(documentType)
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val result = DocumentFilters.byOwningEntitySecretIdsAndTypeForDataOwner(
			dataOwnerIdConverted,
			documentTypeConverted,
			secretIdsConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byOwningEntitySecretIdsAndTypeForSelf(documentType: String, secretIds: Array<String>):
			FilterOptionsJs<DocumentJs> {
		val documentTypeConverted: DocumentType = DocumentType.valueOf(documentType)
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val result = DocumentFilters.byOwningEntitySecretIdsAndTypeForSelf(
			documentTypeConverted,
			secretIdsConverted,
		)
		return FilterOptionsJsImpl(result)
	}
}
