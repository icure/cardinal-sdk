# auto-generated file
import json
from cardinal_sdk.model import DecryptedInvoice, Patient, User, AccessLevel, SecretIdUseOption, SecretIdUseOptionUseAnySharedWithParent, serialize_patient, serialize_secret_id_use_option, Invoice, serialize_invoice, EncryptedInvoice, deserialize_invoice, DocIdentifier, LabelledOccurence, InvoiceShareOptions, EncryptedInvoicingCode, MediumType, InvoiceType
from typing import Optional
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.model.specializations import HexString


class InvoiceApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk
		self.encrypted = InvoiceApiEncrypted(self.cardinal_sdk)
		self.try_and_recover = InvoiceApiTryAndRecover(self.cardinal_sdk)

	async def create_invoice_async(self, entity: DecryptedInvoice, prefix: Optional[str]) -> DecryptedInvoice:
		def do_decode(raw_result):
			return DecryptedInvoice._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
			"prefix": prefix,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.createInvoiceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_invoice_blocking(self, entity: DecryptedInvoice, prefix: Optional[str]) -> DecryptedInvoice:
		payload = {
			"entity": entity.__serialize__(),
			"prefix": prefix,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.createInvoiceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedInvoice._deserialize(result_info.success)
			return return_value

	async def create_invoices_async(self, entities: list[DecryptedInvoice]) -> list[DecryptedInvoice]:
		def do_decode(raw_result):
			return [DecryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.createInvoicesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_invoices_blocking(self, entities: list[DecryptedInvoice]) -> list[DecryptedInvoice]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.createInvoicesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def with_encryption_metadata_async(self, base: Optional[DecryptedInvoice], patient: Optional[Patient], user: Optional[User] = None, delegates: dict[str, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent(), alternate_root_delegate_id: Optional[str] = None) -> DecryptedInvoice:
		def do_decode(raw_result):
			return DecryptedInvoice._deserialize(raw_result)
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient) if patient is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": serialize_secret_id_use_option(secret_id),
			"alternateRootDelegateId": alternate_root_delegate_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.withEncryptionMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def with_encryption_metadata_blocking(self, base: Optional[DecryptedInvoice], patient: Optional[Patient], user: Optional[User] = None, delegates: dict[str, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent(), alternate_root_delegate_id: Optional[str] = None) -> DecryptedInvoice:
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient) if patient is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": serialize_secret_id_use_option(secret_id),
			"alternateRootDelegateId": alternate_root_delegate_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.withEncryptionMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedInvoice._deserialize(result_info.success)
			return return_value

	async def get_encryption_keys_of_async(self, invoice: Invoice) -> set[HexString]:
		def do_decode(raw_result):
			return {x1 for x1 in raw_result}
		payload = {
			"invoice": serialize_invoice(invoice),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.getEncryptionKeysOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_encryption_keys_of_blocking(self, invoice: Invoice) -> set[HexString]:
		payload = {
			"invoice": serialize_invoice(invoice),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.getEncryptionKeysOfBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = {x1 for x1 in result_info.success}
			return return_value

	async def has_write_access_async(self, invoice: Invoice) -> bool:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"invoice": serialize_invoice(invoice),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.hasWriteAccessAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def has_write_access_blocking(self, invoice: Invoice) -> bool:
		payload = {
			"invoice": serialize_invoice(invoice),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.hasWriteAccessBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

	async def decrypt_patient_id_of_async(self, invoice: Invoice) -> set[str]:
		def do_decode(raw_result):
			return {x1 for x1 in raw_result}
		payload = {
			"invoice": serialize_invoice(invoice),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.decryptPatientIdOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_patient_id_of_blocking(self, invoice: Invoice) -> set[str]:
		payload = {
			"invoice": serialize_invoice(invoice),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.decryptPatientIdOfBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = {x1 for x1 in result_info.success}
			return return_value

	async def create_delegation_de_anonymization_metadata_async(self, entity: Invoice, delegates: set[str]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"entity": serialize_invoice(entity),
			"delegates": [x0 for x0 in delegates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.createDelegationDeAnonymizationMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_delegation_de_anonymization_metadata_blocking(self, entity: Invoice, delegates: set[str]) -> None:
		payload = {
			"entity": serialize_invoice(entity),
			"delegates": [x0 for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.createDelegationDeAnonymizationMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def decrypt_async(self, invoice: EncryptedInvoice) -> DecryptedInvoice:
		def do_decode(raw_result):
			return DecryptedInvoice._deserialize(raw_result)
		payload = {
			"invoice": invoice.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.decryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_blocking(self, invoice: EncryptedInvoice) -> DecryptedInvoice:
		payload = {
			"invoice": invoice.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.decryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedInvoice._deserialize(result_info.success)
			return return_value

	async def try_decrypt_async(self, invoice: EncryptedInvoice) -> Invoice:
		def do_decode(raw_result):
			return deserialize_invoice(raw_result)
		payload = {
			"invoice": invoice.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryDecryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def try_decrypt_blocking(self, invoice: EncryptedInvoice) -> Invoice:
		payload = {
			"invoice": invoice.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryDecryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_invoice(result_info.success)
			return return_value

	async def delete_invoice_async(self, entity_id: str) -> DocIdentifier:
		def do_decode(raw_result):
			return DocIdentifier._deserialize(raw_result)
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.deleteInvoiceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_invoice_blocking(self, entity_id: str) -> DocIdentifier:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.deleteInvoiceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DocIdentifier._deserialize(result_info.success)
			return return_value

	async def get_tarifications_codes_occurrences_async(self, min_occurrence: int) -> list[LabelledOccurence]:
		def do_decode(raw_result):
			return [LabelledOccurence._deserialize(x1) for x1 in raw_result]
		payload = {
			"minOccurrence": min_occurrence,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.getTarificationsCodesOccurrencesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_tarifications_codes_occurrences_blocking(self, min_occurrence: int) -> list[LabelledOccurence]:
		payload = {
			"minOccurrence": min_occurrence,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.getTarificationsCodesOccurrencesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [LabelledOccurence._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def share_with_async(self, delegate_id: str, invoice: DecryptedInvoice, options: Optional[InvoiceShareOptions] = None) -> DecryptedInvoice:
		def do_decode(raw_result):
			return DecryptedInvoice._deserialize(raw_result)
		payload = {
			"delegateId": delegate_id,
			"invoice": invoice.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, invoice: DecryptedInvoice, options: Optional[InvoiceShareOptions] = None) -> DecryptedInvoice:
		payload = {
			"delegateId": delegate_id,
			"invoice": invoice.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedInvoice._deserialize(result_info.success)
			return return_value

	async def share_with_many_async(self, invoice: DecryptedInvoice, delegates: dict[str, InvoiceShareOptions]) -> DecryptedInvoice:
		def do_decode(raw_result):
			return DecryptedInvoice._deserialize(raw_result)
		payload = {
			"invoice": invoice.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, invoice: DecryptedInvoice, delegates: dict[str, InvoiceShareOptions]) -> DecryptedInvoice:
		payload = {
			"invoice": invoice.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedInvoice._deserialize(result_info.success)
			return return_value

	async def modify_invoice_async(self, entity: DecryptedInvoice) -> DecryptedInvoice:
		def do_decode(raw_result):
			return DecryptedInvoice._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.modifyInvoiceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_invoice_blocking(self, entity: DecryptedInvoice) -> DecryptedInvoice:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.modifyInvoiceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedInvoice._deserialize(result_info.success)
			return return_value

	async def modify_invoices_async(self, entities: list[DecryptedInvoice]) -> list[DecryptedInvoice]:
		def do_decode(raw_result):
			return [DecryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.modifyInvoicesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_invoices_blocking(self, entities: list[DecryptedInvoice]) -> list[DecryptedInvoice]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.modifyInvoicesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_invoice_async(self, entity_id: str) -> Optional[DecryptedInvoice]:
		def do_decode(raw_result):
			return DecryptedInvoice._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.getInvoiceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_invoice_blocking(self, entity_id: str) -> Optional[DecryptedInvoice]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.getInvoiceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedInvoice._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_invoices_async(self, entity_ids: list[str]) -> list[DecryptedInvoice]:
		def do_decode(raw_result):
			return [DecryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.getInvoicesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_invoices_blocking(self, entity_ids: list[str]) -> list[DecryptedInvoice]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.getInvoicesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def reassign_invoice_async(self, invoice: DecryptedInvoice) -> DecryptedInvoice:
		def do_decode(raw_result):
			return DecryptedInvoice._deserialize(raw_result)
		payload = {
			"invoice": invoice.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.reassignInvoiceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def reassign_invoice_blocking(self, invoice: DecryptedInvoice) -> DecryptedInvoice:
		payload = {
			"invoice": invoice.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.reassignInvoiceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedInvoice._deserialize(result_info.success)
			return return_value

	async def merge_to_async(self, invoice_id: str, ids: list[str]) -> DecryptedInvoice:
		def do_decode(raw_result):
			return DecryptedInvoice._deserialize(raw_result)
		payload = {
			"invoiceId": invoice_id,
			"ids": [x0 for x0 in ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.mergeToAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def merge_to_blocking(self, invoice_id: str, ids: list[str]) -> DecryptedInvoice:
		payload = {
			"invoiceId": invoice_id,
			"ids": [x0 for x0 in ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.mergeToBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedInvoice._deserialize(result_info.success)
			return return_value

	async def validate_async(self, invoice_id: str, scheme: str, forced_value: str) -> DecryptedInvoice:
		def do_decode(raw_result):
			return DecryptedInvoice._deserialize(raw_result)
		payload = {
			"invoiceId": invoice_id,
			"scheme": scheme,
			"forcedValue": forced_value,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.validateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def validate_blocking(self, invoice_id: str, scheme: str, forced_value: str) -> DecryptedInvoice:
		payload = {
			"invoiceId": invoice_id,
			"scheme": scheme,
			"forcedValue": forced_value,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.validateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedInvoice._deserialize(result_info.success)
			return return_value

	async def append_codes_async(self, user_id: str, type: str, sent_medium_type: str, secret_fkeys: str, invoicing_codes: list[EncryptedInvoicingCode], insurance_id: Optional[str] = None, invoice_id: Optional[str] = None, grace_period: Optional[int] = None) -> list[DecryptedInvoice]:
		def do_decode(raw_result):
			return [DecryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"userId": user_id,
			"type": type,
			"sentMediumType": sent_medium_type,
			"secretFKeys": secret_fkeys,
			"insuranceId": insurance_id,
			"invoiceId": invoice_id,
			"gracePeriod": grace_period,
			"invoicingCodes": [x0.__serialize__() for x0 in invoicing_codes],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.appendCodesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def append_codes_blocking(self, user_id: str, type: str, sent_medium_type: str, secret_fkeys: str, invoicing_codes: list[EncryptedInvoicingCode], insurance_id: Optional[str] = None, invoice_id: Optional[str] = None, grace_period: Optional[int] = None) -> list[DecryptedInvoice]:
		payload = {
			"userId": user_id,
			"type": type,
			"sentMediumType": sent_medium_type,
			"secretFKeys": secret_fkeys,
			"insuranceId": insurance_id,
			"invoiceId": invoice_id,
			"gracePeriod": grace_period,
			"invoicingCodes": [x0.__serialize__() for x0 in invoicing_codes],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.appendCodesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def remove_codes_async(self, user_id: str, service_id: str, secret_fkeys: str, tarification_ids: list[str]) -> list[DecryptedInvoice]:
		def do_decode(raw_result):
			return [DecryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"userId": user_id,
			"serviceId": service_id,
			"secretFKeys": secret_fkeys,
			"tarificationIds": [x0 for x0 in tarification_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.removeCodesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def remove_codes_blocking(self, user_id: str, service_id: str, secret_fkeys: str, tarification_ids: list[str]) -> list[DecryptedInvoice]:
		payload = {
			"userId": user_id,
			"serviceId": service_id,
			"secretFKeys": secret_fkeys,
			"tarificationIds": [x0 for x0 in tarification_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.removeCodesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_invoices_by_hc_party_and_group_id_async(self, hc_party_id: str, group_id: str) -> list[DecryptedInvoice]:
		def do_decode(raw_result):
			return [DecryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"hcPartyId": hc_party_id,
			"groupId": group_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listInvoicesByHcPartyAndGroupIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_invoices_by_hc_party_and_group_id_blocking(self, hc_party_id: str, group_id: str) -> list[DecryptedInvoice]:
		payload = {
			"hcPartyId": hc_party_id,
			"groupId": group_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listInvoicesByHcPartyAndGroupIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_invoices_by_hc_party_sent_medium_type_invoice_type_sent_date_async(self, hc_party_id: str, sent_medium_type: MediumType, invoice_type: InvoiceType, sent: bool, from_: Optional[int] = None, to: Optional[int] = None) -> list[DecryptedInvoice]:
		def do_decode(raw_result):
			return [DecryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"hcPartyId": hc_party_id,
			"sentMediumType": sent_medium_type.__serialize__(),
			"invoiceType": invoice_type.__serialize__(),
			"sent": sent,
			"from": from_,
			"to": to,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_invoices_by_hc_party_sent_medium_type_invoice_type_sent_date_blocking(self, hc_party_id: str, sent_medium_type: MediumType, invoice_type: InvoiceType, sent: bool, from_: Optional[int] = None, to: Optional[int] = None) -> list[DecryptedInvoice]:
		payload = {
			"hcPartyId": hc_party_id,
			"sentMediumType": sent_medium_type.__serialize__(),
			"invoiceType": invoice_type.__serialize__(),
			"sent": sent,
			"from": from_,
			"to": to,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_invoices_by_contact_ids_async(self, contact_ids: list[str]) -> list[DecryptedInvoice]:
		def do_decode(raw_result):
			return [DecryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"contactIds": [x0 for x0 in contact_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listInvoicesByContactIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_invoices_by_contact_ids_blocking(self, contact_ids: list[str]) -> list[DecryptedInvoice]:
		payload = {
			"contactIds": [x0 for x0 in contact_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listInvoicesByContactIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_invoices_by_recipients_ids_async(self, recipients_ids: list[str]) -> list[DecryptedInvoice]:
		def do_decode(raw_result):
			return [DecryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"recipientsIds": [x0 for x0 in recipients_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listInvoicesByRecipientsIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_invoices_by_recipients_ids_blocking(self, recipients_ids: list[str]) -> list[DecryptedInvoice]:
		payload = {
			"recipientsIds": [x0 for x0 in recipients_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listInvoicesByRecipientsIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_to_insurances_async(self, user_ids: list[str]) -> list[DecryptedInvoice]:
		def do_decode(raw_result):
			return [DecryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"userIds": [x0 for x0 in user_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listToInsurancesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_to_insurances_blocking(self, user_ids: list[str]) -> list[DecryptedInvoice]:
		payload = {
			"userIds": [x0 for x0 in user_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listToInsurancesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_to_insurances_unsent_async(self, user_ids: list[str]) -> list[DecryptedInvoice]:
		def do_decode(raw_result):
			return [DecryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"userIds": [x0 for x0 in user_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listToInsurancesUnsentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_to_insurances_unsent_blocking(self, user_ids: list[str]) -> list[DecryptedInvoice]:
		payload = {
			"userIds": [x0 for x0 in user_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listToInsurancesUnsentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_to_patients_async(self, hc_party_id: str) -> list[DecryptedInvoice]:
		def do_decode(raw_result):
			return [DecryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"hcPartyId": hc_party_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listToPatientsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_to_patients_blocking(self, hc_party_id: str) -> list[DecryptedInvoice]:
		payload = {
			"hcPartyId": hc_party_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listToPatientsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_to_patients_unsent_async(self, hc_party_id: Optional[str]) -> list[DecryptedInvoice]:
		def do_decode(raw_result):
			return [DecryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"hcPartyId": hc_party_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listToPatientsUnsentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_to_patients_unsent_blocking(self, hc_party_id: Optional[str]) -> list[DecryptedInvoice]:
		payload = {
			"hcPartyId": hc_party_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listToPatientsUnsentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_invoices_by_ids_async(self, ids: list[str]) -> list[DecryptedInvoice]:
		def do_decode(raw_result):
			return [DecryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"ids": [x0 for x0 in ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listInvoicesByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_invoices_by_ids_blocking(self, ids: list[str]) -> list[DecryptedInvoice]:
		payload = {
			"ids": [x0 for x0 in ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listInvoicesByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_invoices_by_hcparty_sending_mode_status_date_async(self, hc_party_id: str, sending_mode: str, status: str, from_: int, to: int) -> list[DecryptedInvoice]:
		def do_decode(raw_result):
			return [DecryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"hcPartyId": hc_party_id,
			"sendingMode": sending_mode,
			"status": status,
			"from": from_,
			"to": to,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listInvoicesByHcpartySendingModeStatusDateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_invoices_by_hcparty_sending_mode_status_date_blocking(self, hc_party_id: str, sending_mode: str, status: str, from_: int, to: int) -> list[DecryptedInvoice]:
		payload = {
			"hcPartyId": hc_party_id,
			"sendingMode": sending_mode,
			"status": status,
			"from": from_,
			"to": to,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listInvoicesByHcpartySendingModeStatusDateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value


class InvoiceApiEncrypted:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate_id: str, invoice: EncryptedInvoice, options: Optional[InvoiceShareOptions] = None) -> EncryptedInvoice:
		def do_decode(raw_result):
			return EncryptedInvoice._deserialize(raw_result)
		payload = {
			"delegateId": delegate_id,
			"invoice": invoice.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, invoice: EncryptedInvoice, options: Optional[InvoiceShareOptions] = None) -> EncryptedInvoice:
		payload = {
			"delegateId": delegate_id,
			"invoice": invoice.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedInvoice._deserialize(result_info.success)
			return return_value

	async def share_with_many_async(self, invoice: EncryptedInvoice, delegates: dict[str, InvoiceShareOptions]) -> EncryptedInvoice:
		def do_decode(raw_result):
			return EncryptedInvoice._deserialize(raw_result)
		payload = {
			"invoice": invoice.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, invoice: EncryptedInvoice, delegates: dict[str, InvoiceShareOptions]) -> EncryptedInvoice:
		payload = {
			"invoice": invoice.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedInvoice._deserialize(result_info.success)
			return return_value

	async def modify_invoice_async(self, entity: EncryptedInvoice) -> EncryptedInvoice:
		def do_decode(raw_result):
			return EncryptedInvoice._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.modifyInvoiceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_invoice_blocking(self, entity: EncryptedInvoice) -> EncryptedInvoice:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.modifyInvoiceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedInvoice._deserialize(result_info.success)
			return return_value

	async def modify_invoices_async(self, entities: list[EncryptedInvoice]) -> list[EncryptedInvoice]:
		def do_decode(raw_result):
			return [EncryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.modifyInvoicesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_invoices_blocking(self, entities: list[EncryptedInvoice]) -> list[EncryptedInvoice]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.modifyInvoicesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_invoice_async(self, entity_id: str) -> Optional[EncryptedInvoice]:
		def do_decode(raw_result):
			return EncryptedInvoice._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.getInvoiceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_invoice_blocking(self, entity_id: str) -> Optional[EncryptedInvoice]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.getInvoiceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedInvoice._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_invoices_async(self, entity_ids: list[str]) -> list[EncryptedInvoice]:
		def do_decode(raw_result):
			return [EncryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.getInvoicesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_invoices_blocking(self, entity_ids: list[str]) -> list[EncryptedInvoice]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.getInvoicesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def reassign_invoice_async(self, invoice: EncryptedInvoice) -> EncryptedInvoice:
		def do_decode(raw_result):
			return EncryptedInvoice._deserialize(raw_result)
		payload = {
			"invoice": invoice.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.reassignInvoiceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def reassign_invoice_blocking(self, invoice: EncryptedInvoice) -> EncryptedInvoice:
		payload = {
			"invoice": invoice.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.reassignInvoiceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedInvoice._deserialize(result_info.success)
			return return_value

	async def merge_to_async(self, invoice_id: str, ids: list[str]) -> EncryptedInvoice:
		def do_decode(raw_result):
			return EncryptedInvoice._deserialize(raw_result)
		payload = {
			"invoiceId": invoice_id,
			"ids": [x0 for x0 in ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.mergeToAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def merge_to_blocking(self, invoice_id: str, ids: list[str]) -> EncryptedInvoice:
		payload = {
			"invoiceId": invoice_id,
			"ids": [x0 for x0 in ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.mergeToBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedInvoice._deserialize(result_info.success)
			return return_value

	async def validate_async(self, invoice_id: str, scheme: str, forced_value: str) -> EncryptedInvoice:
		def do_decode(raw_result):
			return EncryptedInvoice._deserialize(raw_result)
		payload = {
			"invoiceId": invoice_id,
			"scheme": scheme,
			"forcedValue": forced_value,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.validateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def validate_blocking(self, invoice_id: str, scheme: str, forced_value: str) -> EncryptedInvoice:
		payload = {
			"invoiceId": invoice_id,
			"scheme": scheme,
			"forcedValue": forced_value,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.validateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedInvoice._deserialize(result_info.success)
			return return_value

	async def append_codes_async(self, user_id: str, type: str, sent_medium_type: str, secret_fkeys: str, invoicing_codes: list[EncryptedInvoicingCode], insurance_id: Optional[str] = None, invoice_id: Optional[str] = None, grace_period: Optional[int] = None) -> list[EncryptedInvoice]:
		def do_decode(raw_result):
			return [EncryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"userId": user_id,
			"type": type,
			"sentMediumType": sent_medium_type,
			"secretFKeys": secret_fkeys,
			"insuranceId": insurance_id,
			"invoiceId": invoice_id,
			"gracePeriod": grace_period,
			"invoicingCodes": [x0.__serialize__() for x0 in invoicing_codes],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.appendCodesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def append_codes_blocking(self, user_id: str, type: str, sent_medium_type: str, secret_fkeys: str, invoicing_codes: list[EncryptedInvoicingCode], insurance_id: Optional[str] = None, invoice_id: Optional[str] = None, grace_period: Optional[int] = None) -> list[EncryptedInvoice]:
		payload = {
			"userId": user_id,
			"type": type,
			"sentMediumType": sent_medium_type,
			"secretFKeys": secret_fkeys,
			"insuranceId": insurance_id,
			"invoiceId": invoice_id,
			"gracePeriod": grace_period,
			"invoicingCodes": [x0.__serialize__() for x0 in invoicing_codes],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.appendCodesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def remove_codes_async(self, user_id: str, service_id: str, secret_fkeys: str, tarification_ids: list[str]) -> list[EncryptedInvoice]:
		def do_decode(raw_result):
			return [EncryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"userId": user_id,
			"serviceId": service_id,
			"secretFKeys": secret_fkeys,
			"tarificationIds": [x0 for x0 in tarification_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.removeCodesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def remove_codes_blocking(self, user_id: str, service_id: str, secret_fkeys: str, tarification_ids: list[str]) -> list[EncryptedInvoice]:
		payload = {
			"userId": user_id,
			"serviceId": service_id,
			"secretFKeys": secret_fkeys,
			"tarificationIds": [x0 for x0 in tarification_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.removeCodesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_invoices_by_hc_party_and_group_id_async(self, hc_party_id: str, group_id: str) -> list[EncryptedInvoice]:
		def do_decode(raw_result):
			return [EncryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"hcPartyId": hc_party_id,
			"groupId": group_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listInvoicesByHcPartyAndGroupIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_invoices_by_hc_party_and_group_id_blocking(self, hc_party_id: str, group_id: str) -> list[EncryptedInvoice]:
		payload = {
			"hcPartyId": hc_party_id,
			"groupId": group_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listInvoicesByHcPartyAndGroupIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_invoices_by_hc_party_sent_medium_type_invoice_type_sent_date_async(self, hc_party_id: str, sent_medium_type: MediumType, invoice_type: InvoiceType, sent: bool, from_: Optional[int] = None, to: Optional[int] = None) -> list[EncryptedInvoice]:
		def do_decode(raw_result):
			return [EncryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"hcPartyId": hc_party_id,
			"sentMediumType": sent_medium_type.__serialize__(),
			"invoiceType": invoice_type.__serialize__(),
			"sent": sent,
			"from": from_,
			"to": to,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_invoices_by_hc_party_sent_medium_type_invoice_type_sent_date_blocking(self, hc_party_id: str, sent_medium_type: MediumType, invoice_type: InvoiceType, sent: bool, from_: Optional[int] = None, to: Optional[int] = None) -> list[EncryptedInvoice]:
		payload = {
			"hcPartyId": hc_party_id,
			"sentMediumType": sent_medium_type.__serialize__(),
			"invoiceType": invoice_type.__serialize__(),
			"sent": sent,
			"from": from_,
			"to": to,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_invoices_by_contact_ids_async(self, contact_ids: list[str]) -> list[EncryptedInvoice]:
		def do_decode(raw_result):
			return [EncryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"contactIds": [x0 for x0 in contact_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listInvoicesByContactIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_invoices_by_contact_ids_blocking(self, contact_ids: list[str]) -> list[EncryptedInvoice]:
		payload = {
			"contactIds": [x0 for x0 in contact_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listInvoicesByContactIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_invoices_by_recipients_ids_async(self, recipients_ids: list[str]) -> list[EncryptedInvoice]:
		def do_decode(raw_result):
			return [EncryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"recipientsIds": [x0 for x0 in recipients_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listInvoicesByRecipientsIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_invoices_by_recipients_ids_blocking(self, recipients_ids: list[str]) -> list[EncryptedInvoice]:
		payload = {
			"recipientsIds": [x0 for x0 in recipients_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listInvoicesByRecipientsIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_to_insurances_async(self, user_ids: list[str]) -> list[EncryptedInvoice]:
		def do_decode(raw_result):
			return [EncryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"userIds": [x0 for x0 in user_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listToInsurancesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_to_insurances_blocking(self, user_ids: list[str]) -> list[EncryptedInvoice]:
		payload = {
			"userIds": [x0 for x0 in user_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listToInsurancesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_to_insurances_unsent_async(self, user_ids: list[str]) -> list[EncryptedInvoice]:
		def do_decode(raw_result):
			return [EncryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"userIds": [x0 for x0 in user_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listToInsurancesUnsentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_to_insurances_unsent_blocking(self, user_ids: list[str]) -> list[EncryptedInvoice]:
		payload = {
			"userIds": [x0 for x0 in user_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listToInsurancesUnsentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_to_patients_async(self, hc_party_id: str) -> list[EncryptedInvoice]:
		def do_decode(raw_result):
			return [EncryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"hcPartyId": hc_party_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listToPatientsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_to_patients_blocking(self, hc_party_id: str) -> list[EncryptedInvoice]:
		payload = {
			"hcPartyId": hc_party_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listToPatientsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_to_patients_unsent_async(self, hc_party_id: Optional[str]) -> list[EncryptedInvoice]:
		def do_decode(raw_result):
			return [EncryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"hcPartyId": hc_party_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listToPatientsUnsentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_to_patients_unsent_blocking(self, hc_party_id: Optional[str]) -> list[EncryptedInvoice]:
		payload = {
			"hcPartyId": hc_party_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listToPatientsUnsentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_invoices_by_ids_async(self, ids: list[str]) -> list[EncryptedInvoice]:
		def do_decode(raw_result):
			return [EncryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"ids": [x0 for x0 in ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listInvoicesByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_invoices_by_ids_blocking(self, ids: list[str]) -> list[EncryptedInvoice]:
		payload = {
			"ids": [x0 for x0 in ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listInvoicesByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_invoices_by_hcparty_sending_mode_status_date_async(self, hc_party_id: str, sending_mode: str, status: str, from_: int, to: int) -> list[EncryptedInvoice]:
		def do_decode(raw_result):
			return [EncryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"hcPartyId": hc_party_id,
			"sendingMode": sending_mode,
			"status": status,
			"from": from_,
			"to": to,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listInvoicesByHcpartySendingModeStatusDateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_invoices_by_hcparty_sending_mode_status_date_blocking(self, hc_party_id: str, sending_mode: str, status: str, from_: int, to: int) -> list[EncryptedInvoice]:
		payload = {
			"hcPartyId": hc_party_id,
			"sendingMode": sending_mode,
			"status": status,
			"from": from_,
			"to": to,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listInvoicesByHcpartySendingModeStatusDateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value


class InvoiceApiTryAndRecover:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate_id: str, invoice: Invoice, options: Optional[InvoiceShareOptions] = None) -> Invoice:
		def do_decode(raw_result):
			return deserialize_invoice(raw_result)
		payload = {
			"delegateId": delegate_id,
			"invoice": serialize_invoice(invoice),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, invoice: Invoice, options: Optional[InvoiceShareOptions] = None) -> Invoice:
		payload = {
			"delegateId": delegate_id,
			"invoice": serialize_invoice(invoice),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_invoice(result_info.success)
			return return_value

	async def share_with_many_async(self, invoice: Invoice, delegates: dict[str, InvoiceShareOptions]) -> Invoice:
		def do_decode(raw_result):
			return deserialize_invoice(raw_result)
		payload = {
			"invoice": serialize_invoice(invoice),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, invoice: Invoice, delegates: dict[str, InvoiceShareOptions]) -> Invoice:
		payload = {
			"invoice": serialize_invoice(invoice),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_invoice(result_info.success)
			return return_value

	async def modify_invoice_async(self, entity: Invoice) -> Invoice:
		def do_decode(raw_result):
			return deserialize_invoice(raw_result)
		payload = {
			"entity": serialize_invoice(entity),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.modifyInvoiceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_invoice_blocking(self, entity: Invoice) -> Invoice:
		payload = {
			"entity": serialize_invoice(entity),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.modifyInvoiceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_invoice(result_info.success)
			return return_value

	async def modify_invoices_async(self, entities: list[Invoice]) -> list[Invoice]:
		def do_decode(raw_result):
			return [deserialize_invoice(x1) for x1 in raw_result]
		payload = {
			"entities": [serialize_invoice(x0) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.modifyInvoicesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_invoices_blocking(self, entities: list[Invoice]) -> list[Invoice]:
		payload = {
			"entities": [serialize_invoice(x0) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.modifyInvoicesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_invoice(x1) for x1 in result_info.success]
			return return_value

	async def get_invoice_async(self, entity_id: str) -> Optional[Invoice]:
		def do_decode(raw_result):
			return deserialize_invoice(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.getInvoiceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_invoice_blocking(self, entity_id: str) -> Optional[Invoice]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.getInvoiceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_invoice(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_invoices_async(self, entity_ids: list[str]) -> list[Invoice]:
		def do_decode(raw_result):
			return [deserialize_invoice(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.getInvoicesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_invoices_blocking(self, entity_ids: list[str]) -> list[Invoice]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.getInvoicesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_invoice(x1) for x1 in result_info.success]
			return return_value

	async def reassign_invoice_async(self, invoice: Invoice) -> Invoice:
		def do_decode(raw_result):
			return deserialize_invoice(raw_result)
		payload = {
			"invoice": serialize_invoice(invoice),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.reassignInvoiceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def reassign_invoice_blocking(self, invoice: Invoice) -> Invoice:
		payload = {
			"invoice": serialize_invoice(invoice),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.reassignInvoiceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_invoice(result_info.success)
			return return_value

	async def merge_to_async(self, invoice_id: str, ids: list[str]) -> Invoice:
		def do_decode(raw_result):
			return deserialize_invoice(raw_result)
		payload = {
			"invoiceId": invoice_id,
			"ids": [x0 for x0 in ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.mergeToAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def merge_to_blocking(self, invoice_id: str, ids: list[str]) -> Invoice:
		payload = {
			"invoiceId": invoice_id,
			"ids": [x0 for x0 in ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.mergeToBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_invoice(result_info.success)
			return return_value

	async def validate_async(self, invoice_id: str, scheme: str, forced_value: str) -> Invoice:
		def do_decode(raw_result):
			return deserialize_invoice(raw_result)
		payload = {
			"invoiceId": invoice_id,
			"scheme": scheme,
			"forcedValue": forced_value,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.validateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def validate_blocking(self, invoice_id: str, scheme: str, forced_value: str) -> Invoice:
		payload = {
			"invoiceId": invoice_id,
			"scheme": scheme,
			"forcedValue": forced_value,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.validateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_invoice(result_info.success)
			return return_value

	async def append_codes_async(self, user_id: str, type: str, sent_medium_type: str, secret_fkeys: str, invoicing_codes: list[EncryptedInvoicingCode], insurance_id: Optional[str] = None, invoice_id: Optional[str] = None, grace_period: Optional[int] = None) -> list[Invoice]:
		def do_decode(raw_result):
			return [deserialize_invoice(x1) for x1 in raw_result]
		payload = {
			"userId": user_id,
			"type": type,
			"sentMediumType": sent_medium_type,
			"secretFKeys": secret_fkeys,
			"insuranceId": insurance_id,
			"invoiceId": invoice_id,
			"gracePeriod": grace_period,
			"invoicingCodes": [x0.__serialize__() for x0 in invoicing_codes],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.appendCodesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def append_codes_blocking(self, user_id: str, type: str, sent_medium_type: str, secret_fkeys: str, invoicing_codes: list[EncryptedInvoicingCode], insurance_id: Optional[str] = None, invoice_id: Optional[str] = None, grace_period: Optional[int] = None) -> list[Invoice]:
		payload = {
			"userId": user_id,
			"type": type,
			"sentMediumType": sent_medium_type,
			"secretFKeys": secret_fkeys,
			"insuranceId": insurance_id,
			"invoiceId": invoice_id,
			"gracePeriod": grace_period,
			"invoicingCodes": [x0.__serialize__() for x0 in invoicing_codes],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.appendCodesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_invoice(x1) for x1 in result_info.success]
			return return_value

	async def remove_codes_async(self, user_id: str, service_id: str, secret_fkeys: str, tarification_ids: list[str]) -> list[Invoice]:
		def do_decode(raw_result):
			return [deserialize_invoice(x1) for x1 in raw_result]
		payload = {
			"userId": user_id,
			"serviceId": service_id,
			"secretFKeys": secret_fkeys,
			"tarificationIds": [x0 for x0 in tarification_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.removeCodesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def remove_codes_blocking(self, user_id: str, service_id: str, secret_fkeys: str, tarification_ids: list[str]) -> list[Invoice]:
		payload = {
			"userId": user_id,
			"serviceId": service_id,
			"secretFKeys": secret_fkeys,
			"tarificationIds": [x0 for x0 in tarification_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.removeCodesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_invoice(x1) for x1 in result_info.success]
			return return_value

	async def list_invoices_by_hc_party_and_group_id_async(self, hc_party_id: str, group_id: str) -> list[Invoice]:
		def do_decode(raw_result):
			return [deserialize_invoice(x1) for x1 in raw_result]
		payload = {
			"hcPartyId": hc_party_id,
			"groupId": group_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listInvoicesByHcPartyAndGroupIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_invoices_by_hc_party_and_group_id_blocking(self, hc_party_id: str, group_id: str) -> list[Invoice]:
		payload = {
			"hcPartyId": hc_party_id,
			"groupId": group_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listInvoicesByHcPartyAndGroupIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_invoice(x1) for x1 in result_info.success]
			return return_value

	async def list_invoices_by_hc_party_sent_medium_type_invoice_type_sent_date_async(self, hc_party_id: str, sent_medium_type: MediumType, invoice_type: InvoiceType, sent: bool, from_: Optional[int] = None, to: Optional[int] = None) -> list[Invoice]:
		def do_decode(raw_result):
			return [deserialize_invoice(x1) for x1 in raw_result]
		payload = {
			"hcPartyId": hc_party_id,
			"sentMediumType": sent_medium_type.__serialize__(),
			"invoiceType": invoice_type.__serialize__(),
			"sent": sent,
			"from": from_,
			"to": to,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_invoices_by_hc_party_sent_medium_type_invoice_type_sent_date_blocking(self, hc_party_id: str, sent_medium_type: MediumType, invoice_type: InvoiceType, sent: bool, from_: Optional[int] = None, to: Optional[int] = None) -> list[Invoice]:
		payload = {
			"hcPartyId": hc_party_id,
			"sentMediumType": sent_medium_type.__serialize__(),
			"invoiceType": invoice_type.__serialize__(),
			"sent": sent,
			"from": from_,
			"to": to,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_invoice(x1) for x1 in result_info.success]
			return return_value

	async def list_invoices_by_contact_ids_async(self, contact_ids: list[str]) -> list[Invoice]:
		def do_decode(raw_result):
			return [deserialize_invoice(x1) for x1 in raw_result]
		payload = {
			"contactIds": [x0 for x0 in contact_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listInvoicesByContactIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_invoices_by_contact_ids_blocking(self, contact_ids: list[str]) -> list[Invoice]:
		payload = {
			"contactIds": [x0 for x0 in contact_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listInvoicesByContactIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_invoice(x1) for x1 in result_info.success]
			return return_value

	async def list_invoices_by_recipients_ids_async(self, recipients_ids: list[str]) -> list[Invoice]:
		def do_decode(raw_result):
			return [deserialize_invoice(x1) for x1 in raw_result]
		payload = {
			"recipientsIds": [x0 for x0 in recipients_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listInvoicesByRecipientsIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_invoices_by_recipients_ids_blocking(self, recipients_ids: list[str]) -> list[Invoice]:
		payload = {
			"recipientsIds": [x0 for x0 in recipients_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listInvoicesByRecipientsIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_invoice(x1) for x1 in result_info.success]
			return return_value

	async def list_to_insurances_async(self, user_ids: list[str]) -> list[Invoice]:
		def do_decode(raw_result):
			return [deserialize_invoice(x1) for x1 in raw_result]
		payload = {
			"userIds": [x0 for x0 in user_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listToInsurancesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_to_insurances_blocking(self, user_ids: list[str]) -> list[Invoice]:
		payload = {
			"userIds": [x0 for x0 in user_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listToInsurancesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_invoice(x1) for x1 in result_info.success]
			return return_value

	async def list_to_insurances_unsent_async(self, user_ids: list[str]) -> list[Invoice]:
		def do_decode(raw_result):
			return [deserialize_invoice(x1) for x1 in raw_result]
		payload = {
			"userIds": [x0 for x0 in user_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listToInsurancesUnsentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_to_insurances_unsent_blocking(self, user_ids: list[str]) -> list[Invoice]:
		payload = {
			"userIds": [x0 for x0 in user_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listToInsurancesUnsentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_invoice(x1) for x1 in result_info.success]
			return return_value

	async def list_to_patients_async(self, hc_party_id: str) -> list[Invoice]:
		def do_decode(raw_result):
			return [deserialize_invoice(x1) for x1 in raw_result]
		payload = {
			"hcPartyId": hc_party_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listToPatientsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_to_patients_blocking(self, hc_party_id: str) -> list[Invoice]:
		payload = {
			"hcPartyId": hc_party_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listToPatientsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_invoice(x1) for x1 in result_info.success]
			return return_value

	async def list_to_patients_unsent_async(self, hc_party_id: Optional[str]) -> list[Invoice]:
		def do_decode(raw_result):
			return [deserialize_invoice(x1) for x1 in raw_result]
		payload = {
			"hcPartyId": hc_party_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listToPatientsUnsentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_to_patients_unsent_blocking(self, hc_party_id: Optional[str]) -> list[Invoice]:
		payload = {
			"hcPartyId": hc_party_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listToPatientsUnsentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_invoice(x1) for x1 in result_info.success]
			return return_value

	async def list_invoices_by_ids_async(self, ids: list[str]) -> list[Invoice]:
		def do_decode(raw_result):
			return [deserialize_invoice(x1) for x1 in raw_result]
		payload = {
			"ids": [x0 for x0 in ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listInvoicesByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_invoices_by_ids_blocking(self, ids: list[str]) -> list[Invoice]:
		payload = {
			"ids": [x0 for x0 in ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listInvoicesByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_invoice(x1) for x1 in result_info.success]
			return return_value

	async def list_invoices_by_hcparty_sending_mode_status_date_async(self, hc_party_id: str, sending_mode: str, status: str, from_: int, to: int) -> list[Invoice]:
		def do_decode(raw_result):
			return [deserialize_invoice(x1) for x1 in raw_result]
		payload = {
			"hcPartyId": hc_party_id,
			"sendingMode": sending_mode,
			"status": status,
			"from": from_,
			"to": to,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listInvoicesByHcpartySendingModeStatusDateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_invoices_by_hcparty_sending_mode_status_date_blocking(self, hc_party_id: str, sending_mode: str, status: str, from_: int, to: int) -> list[Invoice]:
		payload = {
			"hcPartyId": hc_party_id,
			"sendingMode": sending_mode,
			"status": status,
			"from": from_,
			"to": to,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listInvoicesByHcpartySendingModeStatusDateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_invoice(x1) for x1 in result_info.success]
			return return_value
