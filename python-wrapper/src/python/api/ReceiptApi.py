# auto-generated file
import json
import base64
from typing import Optional
from cardinal_sdk.model import DecryptedReceipt, Patient, User, AccessLevel, SecretIdUseOption, SecretIdUseOptionUseAnySharedWithParent, serialize_patient, serialize_secret_id_use_option, Receipt, serialize_receipt, EncryptedReceipt, EntityReferenceInGroup, deserialize_receipt, StoredDocumentIdentifier, ReceiptShareOptions, GroupScoped
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.model.specializations import HexString


class ReceiptApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk
		self.encrypted = ReceiptApiEncrypted(self.cardinal_sdk)
		self.try_and_recover = ReceiptApiTryAndRecover(self.cardinal_sdk)
		self.in_group = ReceiptApiInGroup(self.cardinal_sdk)

	async def with_encryption_metadata_async(self, base: Optional[DecryptedReceipt], patient: Optional[Patient], user: Optional[User] = None, delegates: dict[str, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent(), alternate_root_delegate_id: Optional[str] = None) -> DecryptedReceipt:
		def do_decode(raw_result):
			return DecryptedReceipt._deserialize(raw_result)
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.withEncryptionMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def with_encryption_metadata_blocking(self, base: Optional[DecryptedReceipt], patient: Optional[Patient], user: Optional[User] = None, delegates: dict[str, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent(), alternate_root_delegate_id: Optional[str] = None) -> DecryptedReceipt:
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient) if patient is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": serialize_secret_id_use_option(secret_id),
			"alternateRootDelegateId": alternate_root_delegate_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.withEncryptionMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedReceipt._deserialize(result_info.success)
			return return_value

	async def get_and_decrypt_receipt_attachment_async(self, receipt: Receipt, attachment_id: str) -> bytearray:
		def do_decode(raw_result):
			return bytearray(base64.b64decode(raw_result))
		payload = {
			"receipt": serialize_receipt(receipt),
			"attachmentId": attachment_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.getAndDecryptReceiptAttachmentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_and_decrypt_receipt_attachment_blocking(self, receipt: Receipt, attachment_id: str) -> bytearray:
		payload = {
			"receipt": serialize_receipt(receipt),
			"attachmentId": attachment_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.getAndDecryptReceiptAttachmentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = bytearray(base64.b64decode(result_info.success))
			return return_value

	async def encrypt_and_set_receipt_attachment_async(self, receipt: Receipt, blob_type: str, attachment: bytearray) -> EncryptedReceipt:
		def do_decode(raw_result):
			return EncryptedReceipt._deserialize(raw_result)
		payload = {
			"receipt": serialize_receipt(receipt),
			"blobType": blob_type,
			"attachment": base64.b64encode(attachment).decode('utf-8'),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.encryptAndSetReceiptAttachmentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def encrypt_and_set_receipt_attachment_blocking(self, receipt: Receipt, blob_type: str, attachment: bytearray) -> EncryptedReceipt:
		payload = {
			"receipt": serialize_receipt(receipt),
			"blobType": blob_type,
			"attachment": base64.b64encode(attachment).decode('utf-8'),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.encryptAndSetReceiptAttachmentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedReceipt._deserialize(result_info.success)
			return return_value

	async def get_encryption_keys_of_async(self, receipt: Receipt) -> set[HexString]:
		def do_decode(raw_result):
			return {x1 for x1 in raw_result}
		payload = {
			"receipt": serialize_receipt(receipt),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.getEncryptionKeysOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_encryption_keys_of_blocking(self, receipt: Receipt) -> set[HexString]:
		payload = {
			"receipt": serialize_receipt(receipt),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.getEncryptionKeysOfBlocking(
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

	async def has_write_access_async(self, receipt: Receipt) -> bool:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"receipt": serialize_receipt(receipt),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.hasWriteAccessAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def has_write_access_blocking(self, receipt: Receipt) -> bool:
		payload = {
			"receipt": serialize_receipt(receipt),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.hasWriteAccessBlocking(
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

	async def decrypt_patient_id_of_async(self, receipt: Receipt) -> set[EntityReferenceInGroup]:
		def do_decode(raw_result):
			return {EntityReferenceInGroup._deserialize(x1) for x1 in raw_result}
		payload = {
			"receipt": serialize_receipt(receipt),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.decryptPatientIdOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_patient_id_of_blocking(self, receipt: Receipt) -> set[EntityReferenceInGroup]:
		payload = {
			"receipt": serialize_receipt(receipt),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.decryptPatientIdOfBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = {EntityReferenceInGroup._deserialize(x1) for x1 in result_info.success}
			return return_value

	async def create_delegation_de_anonymization_metadata_async(self, entity: Receipt, delegates: set[str]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"entity": serialize_receipt(entity),
			"delegates": [x0 for x0 in delegates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.createDelegationDeAnonymizationMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_delegation_de_anonymization_metadata_blocking(self, entity: Receipt, delegates: set[str]) -> None:
		payload = {
			"entity": serialize_receipt(entity),
			"delegates": [x0 for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.createDelegationDeAnonymizationMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def log_receipt_async(self, user: User, doc_id: str, refs: list[str], blob_type: str, blob: bytearray) -> Receipt:
		def do_decode(raw_result):
			return deserialize_receipt(raw_result)
		payload = {
			"user": user.__serialize__(),
			"docId": doc_id,
			"refs": [x0 for x0 in refs],
			"blobType": blob_type,
			"blob": base64.b64encode(blob).decode('utf-8'),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.logReceiptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def log_receipt_blocking(self, user: User, doc_id: str, refs: list[str], blob_type: str, blob: bytearray) -> Receipt:
		payload = {
			"user": user.__serialize__(),
			"docId": doc_id,
			"refs": [x0 for x0 in refs],
			"blobType": blob_type,
			"blob": base64.b64encode(blob).decode('utf-8'),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.logReceiptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_receipt(result_info.success)
			return return_value

	async def decrypt_async(self, receipt: EncryptedReceipt) -> DecryptedReceipt:
		def do_decode(raw_result):
			return DecryptedReceipt._deserialize(raw_result)
		payload = {
			"receipt": receipt.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.decryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_blocking(self, receipt: EncryptedReceipt) -> DecryptedReceipt:
		payload = {
			"receipt": receipt.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.decryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedReceipt._deserialize(result_info.success)
			return return_value

	async def try_decrypt_async(self, receipt: EncryptedReceipt) -> Receipt:
		def do_decode(raw_result):
			return deserialize_receipt(raw_result)
		payload = {
			"receipt": receipt.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.tryDecryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def try_decrypt_blocking(self, receipt: EncryptedReceipt) -> Receipt:
		payload = {
			"receipt": receipt.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.tryDecryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_receipt(result_info.success)
			return return_value

	async def delete_receipt_by_id_async(self, entity_id: str, rev: str) -> StoredDocumentIdentifier:
		def do_decode(raw_result):
			return StoredDocumentIdentifier._deserialize(raw_result)
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.deleteReceiptByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_receipt_by_id_blocking(self, entity_id: str, rev: str) -> StoredDocumentIdentifier:
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.deleteReceiptByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = StoredDocumentIdentifier._deserialize(result_info.success)
			return return_value

	async def delete_receipts_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.deleteReceiptsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_receipts_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.deleteReceiptsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [StoredDocumentIdentifier._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def purge_receipt_by_id_async(self, id: str, rev: str) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.purgeReceiptByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_receipt_by_id_blocking(self, id: str, rev: str) -> None:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.purgeReceiptByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_receipts_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.purgeReceiptsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_receipts_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.purgeReceiptsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [StoredDocumentIdentifier._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def delete_receipt_async(self, receipt: Receipt) -> StoredDocumentIdentifier:
		def do_decode(raw_result):
			return StoredDocumentIdentifier._deserialize(raw_result)
		payload = {
			"receipt": serialize_receipt(receipt),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.deleteReceiptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_receipt_blocking(self, receipt: Receipt) -> StoredDocumentIdentifier:
		payload = {
			"receipt": serialize_receipt(receipt),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.deleteReceiptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = StoredDocumentIdentifier._deserialize(result_info.success)
			return return_value

	async def delete_receipts_async(self, receipts: list[Receipt]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"receipts": [serialize_receipt(x0) for x0 in receipts],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.deleteReceiptsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_receipts_blocking(self, receipts: list[Receipt]) -> list[StoredDocumentIdentifier]:
		payload = {
			"receipts": [serialize_receipt(x0) for x0 in receipts],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.deleteReceiptsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [StoredDocumentIdentifier._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def purge_receipt_async(self, receipt: Receipt) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"receipt": serialize_receipt(receipt),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.purgeReceiptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_receipt_blocking(self, receipt: Receipt) -> None:
		payload = {
			"receipt": serialize_receipt(receipt),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.purgeReceiptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_receipts_async(self, receipts: list[Receipt]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"receipts": [serialize_receipt(x0) for x0 in receipts],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.purgeReceiptsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_receipts_blocking(self, receipts: list[Receipt]) -> list[StoredDocumentIdentifier]:
		payload = {
			"receipts": [serialize_receipt(x0) for x0 in receipts],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.purgeReceiptsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [StoredDocumentIdentifier._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_raw_receipt_attachment_async(self, receipt_id: str, attachment_id: str) -> bytearray:
		def do_decode(raw_result):
			return bytearray(base64.b64decode(raw_result))
		payload = {
			"receiptId": receipt_id,
			"attachmentId": attachment_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.getRawReceiptAttachmentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_raw_receipt_attachment_blocking(self, receipt_id: str, attachment_id: str) -> bytearray:
		payload = {
			"receiptId": receipt_id,
			"attachmentId": attachment_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.getRawReceiptAttachmentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = bytearray(base64.b64decode(result_info.success))
			return return_value

	async def set_raw_receipt_attachment_async(self, receipt_id: str, rev: str, blob_type: str, attachment: bytearray) -> EncryptedReceipt:
		def do_decode(raw_result):
			return EncryptedReceipt._deserialize(raw_result)
		payload = {
			"receiptId": receipt_id,
			"rev": rev,
			"blobType": blob_type,
			"attachment": base64.b64encode(attachment).decode('utf-8'),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.setRawReceiptAttachmentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def set_raw_receipt_attachment_blocking(self, receipt_id: str, rev: str, blob_type: str, attachment: bytearray) -> EncryptedReceipt:
		payload = {
			"receiptId": receipt_id,
			"rev": rev,
			"blobType": blob_type,
			"attachment": base64.b64encode(attachment).decode('utf-8'),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.setRawReceiptAttachmentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedReceipt._deserialize(result_info.success)
			return return_value

	async def share_with_async(self, delegate_id: str, receipt: DecryptedReceipt, options: Optional[ReceiptShareOptions] = None) -> DecryptedReceipt:
		def do_decode(raw_result):
			return DecryptedReceipt._deserialize(raw_result)
		payload = {
			"delegateId": delegate_id,
			"receipt": receipt.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, receipt: DecryptedReceipt, options: Optional[ReceiptShareOptions] = None) -> DecryptedReceipt:
		payload = {
			"delegateId": delegate_id,
			"receipt": receipt.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedReceipt._deserialize(result_info.success)
			return return_value

	async def share_with_many_async(self, receipt: DecryptedReceipt, delegates: dict[str, ReceiptShareOptions]) -> DecryptedReceipt:
		def do_decode(raw_result):
			return DecryptedReceipt._deserialize(raw_result)
		payload = {
			"receipt": receipt.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, receipt: DecryptedReceipt, delegates: dict[str, ReceiptShareOptions]) -> DecryptedReceipt:
		payload = {
			"receipt": receipt.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedReceipt._deserialize(result_info.success)
			return return_value

	async def create_receipt_async(self, entity: DecryptedReceipt) -> DecryptedReceipt:
		def do_decode(raw_result):
			return DecryptedReceipt._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.createReceiptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_receipt_blocking(self, entity: DecryptedReceipt) -> DecryptedReceipt:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.createReceiptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedReceipt._deserialize(result_info.success)
			return return_value

	async def create_receipts_async(self, entities: list[DecryptedReceipt]) -> list[DecryptedReceipt]:
		def do_decode(raw_result):
			return [DecryptedReceipt._deserialize(x1) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.createReceiptsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_receipts_blocking(self, entities: list[DecryptedReceipt]) -> list[DecryptedReceipt]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.createReceiptsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedReceipt._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def undelete_receipt_by_id_async(self, id: str, rev: str) -> DecryptedReceipt:
		def do_decode(raw_result):
			return DecryptedReceipt._deserialize(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.undeleteReceiptByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_receipt_by_id_blocking(self, id: str, rev: str) -> DecryptedReceipt:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.undeleteReceiptByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedReceipt._deserialize(result_info.success)
			return return_value

	async def undelete_receipts_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[DecryptedReceipt]:
		def do_decode(raw_result):
			return [DecryptedReceipt._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.undeleteReceiptsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_receipts_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[DecryptedReceipt]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.undeleteReceiptsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedReceipt._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def undelete_receipt_async(self, receipt: Receipt) -> DecryptedReceipt:
		def do_decode(raw_result):
			return DecryptedReceipt._deserialize(raw_result)
		payload = {
			"receipt": serialize_receipt(receipt),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.undeleteReceiptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_receipt_blocking(self, receipt: Receipt) -> DecryptedReceipt:
		payload = {
			"receipt": serialize_receipt(receipt),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.undeleteReceiptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedReceipt._deserialize(result_info.success)
			return return_value

	async def undelete_receipts_async(self, receipts: list[Receipt]) -> list[DecryptedReceipt]:
		def do_decode(raw_result):
			return [DecryptedReceipt._deserialize(x1) for x1 in raw_result]
		payload = {
			"receipts": [serialize_receipt(x0) for x0 in receipts],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.undeleteReceiptsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_receipts_blocking(self, receipts: list[Receipt]) -> list[DecryptedReceipt]:
		payload = {
			"receipts": [serialize_receipt(x0) for x0 in receipts],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.undeleteReceiptsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedReceipt._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def modify_receipt_async(self, entity: DecryptedReceipt) -> DecryptedReceipt:
		def do_decode(raw_result):
			return DecryptedReceipt._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.modifyReceiptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_receipt_blocking(self, entity: DecryptedReceipt) -> DecryptedReceipt:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.modifyReceiptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedReceipt._deserialize(result_info.success)
			return return_value

	async def modify_receipts_async(self, entities: list[DecryptedReceipt]) -> list[DecryptedReceipt]:
		def do_decode(raw_result):
			return [DecryptedReceipt._deserialize(x1) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.modifyReceiptsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_receipts_blocking(self, entities: list[DecryptedReceipt]) -> list[DecryptedReceipt]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.modifyReceiptsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedReceipt._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_receipt_async(self, entity_id: str) -> Optional[DecryptedReceipt]:
		def do_decode(raw_result):
			return DecryptedReceipt._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.getReceiptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_receipt_blocking(self, entity_id: str) -> Optional[DecryptedReceipt]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.getReceiptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedReceipt._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_receipts_async(self, entity_ids: list[str]) -> list[DecryptedReceipt]:
		def do_decode(raw_result):
			return [DecryptedReceipt._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.getReceiptsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_receipts_blocking(self, entity_ids: list[str]) -> list[DecryptedReceipt]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.getReceiptsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedReceipt._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_by_reference_async(self, reference: str) -> list[DecryptedReceipt]:
		def do_decode(raw_result):
			return [DecryptedReceipt._deserialize(x1) for x1 in raw_result]
		payload = {
			"reference": reference,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.listByReferenceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_by_reference_blocking(self, reference: str) -> list[DecryptedReceipt]:
		payload = {
			"reference": reference,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.listByReferenceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedReceipt._deserialize(x1) for x1 in result_info.success]
			return return_value


class ReceiptApiEncrypted:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate_id: str, receipt: EncryptedReceipt, options: Optional[ReceiptShareOptions] = None) -> EncryptedReceipt:
		def do_decode(raw_result):
			return EncryptedReceipt._deserialize(raw_result)
		payload = {
			"delegateId": delegate_id,
			"receipt": receipt.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.encrypted.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, receipt: EncryptedReceipt, options: Optional[ReceiptShareOptions] = None) -> EncryptedReceipt:
		payload = {
			"delegateId": delegate_id,
			"receipt": receipt.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.encrypted.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedReceipt._deserialize(result_info.success)
			return return_value

	async def share_with_many_async(self, receipt: EncryptedReceipt, delegates: dict[str, ReceiptShareOptions]) -> EncryptedReceipt:
		def do_decode(raw_result):
			return EncryptedReceipt._deserialize(raw_result)
		payload = {
			"receipt": receipt.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.encrypted.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, receipt: EncryptedReceipt, delegates: dict[str, ReceiptShareOptions]) -> EncryptedReceipt:
		payload = {
			"receipt": receipt.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.encrypted.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedReceipt._deserialize(result_info.success)
			return return_value

	async def create_receipt_async(self, entity: EncryptedReceipt) -> EncryptedReceipt:
		def do_decode(raw_result):
			return EncryptedReceipt._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.encrypted.createReceiptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_receipt_blocking(self, entity: EncryptedReceipt) -> EncryptedReceipt:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.encrypted.createReceiptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedReceipt._deserialize(result_info.success)
			return return_value

	async def create_receipts_async(self, entities: list[EncryptedReceipt]) -> list[EncryptedReceipt]:
		def do_decode(raw_result):
			return [EncryptedReceipt._deserialize(x1) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.encrypted.createReceiptsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_receipts_blocking(self, entities: list[EncryptedReceipt]) -> list[EncryptedReceipt]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.encrypted.createReceiptsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedReceipt._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def undelete_receipt_by_id_async(self, id: str, rev: str) -> EncryptedReceipt:
		def do_decode(raw_result):
			return EncryptedReceipt._deserialize(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.encrypted.undeleteReceiptByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_receipt_by_id_blocking(self, id: str, rev: str) -> EncryptedReceipt:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.encrypted.undeleteReceiptByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedReceipt._deserialize(result_info.success)
			return return_value

	async def undelete_receipts_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[EncryptedReceipt]:
		def do_decode(raw_result):
			return [EncryptedReceipt._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.encrypted.undeleteReceiptsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_receipts_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[EncryptedReceipt]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.encrypted.undeleteReceiptsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedReceipt._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def undelete_receipt_async(self, receipt: Receipt) -> EncryptedReceipt:
		def do_decode(raw_result):
			return EncryptedReceipt._deserialize(raw_result)
		payload = {
			"receipt": serialize_receipt(receipt),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.encrypted.undeleteReceiptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_receipt_blocking(self, receipt: Receipt) -> EncryptedReceipt:
		payload = {
			"receipt": serialize_receipt(receipt),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.encrypted.undeleteReceiptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedReceipt._deserialize(result_info.success)
			return return_value

	async def undelete_receipts_async(self, receipts: list[Receipt]) -> list[EncryptedReceipt]:
		def do_decode(raw_result):
			return [EncryptedReceipt._deserialize(x1) for x1 in raw_result]
		payload = {
			"receipts": [serialize_receipt(x0) for x0 in receipts],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.encrypted.undeleteReceiptsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_receipts_blocking(self, receipts: list[Receipt]) -> list[EncryptedReceipt]:
		payload = {
			"receipts": [serialize_receipt(x0) for x0 in receipts],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.encrypted.undeleteReceiptsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedReceipt._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def modify_receipt_async(self, entity: EncryptedReceipt) -> EncryptedReceipt:
		def do_decode(raw_result):
			return EncryptedReceipt._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.encrypted.modifyReceiptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_receipt_blocking(self, entity: EncryptedReceipt) -> EncryptedReceipt:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.encrypted.modifyReceiptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedReceipt._deserialize(result_info.success)
			return return_value

	async def modify_receipts_async(self, entities: list[EncryptedReceipt]) -> list[EncryptedReceipt]:
		def do_decode(raw_result):
			return [EncryptedReceipt._deserialize(x1) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.encrypted.modifyReceiptsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_receipts_blocking(self, entities: list[EncryptedReceipt]) -> list[EncryptedReceipt]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.encrypted.modifyReceiptsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedReceipt._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_receipt_async(self, entity_id: str) -> Optional[EncryptedReceipt]:
		def do_decode(raw_result):
			return EncryptedReceipt._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.encrypted.getReceiptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_receipt_blocking(self, entity_id: str) -> Optional[EncryptedReceipt]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.encrypted.getReceiptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedReceipt._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_receipts_async(self, entity_ids: list[str]) -> list[EncryptedReceipt]:
		def do_decode(raw_result):
			return [EncryptedReceipt._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.encrypted.getReceiptsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_receipts_blocking(self, entity_ids: list[str]) -> list[EncryptedReceipt]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.encrypted.getReceiptsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedReceipt._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_by_reference_async(self, reference: str) -> list[EncryptedReceipt]:
		def do_decode(raw_result):
			return [EncryptedReceipt._deserialize(x1) for x1 in raw_result]
		payload = {
			"reference": reference,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.encrypted.listByReferenceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_by_reference_blocking(self, reference: str) -> list[EncryptedReceipt]:
		payload = {
			"reference": reference,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.encrypted.listByReferenceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedReceipt._deserialize(x1) for x1 in result_info.success]
			return return_value


class ReceiptApiTryAndRecover:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate_id: str, receipt: Receipt, options: Optional[ReceiptShareOptions] = None) -> Receipt:
		def do_decode(raw_result):
			return deserialize_receipt(raw_result)
		payload = {
			"delegateId": delegate_id,
			"receipt": serialize_receipt(receipt),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.tryAndRecover.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, receipt: Receipt, options: Optional[ReceiptShareOptions] = None) -> Receipt:
		payload = {
			"delegateId": delegate_id,
			"receipt": serialize_receipt(receipt),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.tryAndRecover.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_receipt(result_info.success)
			return return_value

	async def share_with_many_async(self, receipt: Receipt, delegates: dict[str, ReceiptShareOptions]) -> Receipt:
		def do_decode(raw_result):
			return deserialize_receipt(raw_result)
		payload = {
			"receipt": serialize_receipt(receipt),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.tryAndRecover.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, receipt: Receipt, delegates: dict[str, ReceiptShareOptions]) -> Receipt:
		payload = {
			"receipt": serialize_receipt(receipt),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.tryAndRecover.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_receipt(result_info.success)
			return return_value

	async def create_receipt_async(self, entity: Receipt) -> Receipt:
		def do_decode(raw_result):
			return deserialize_receipt(raw_result)
		payload = {
			"entity": serialize_receipt(entity),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.tryAndRecover.createReceiptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_receipt_blocking(self, entity: Receipt) -> Receipt:
		payload = {
			"entity": serialize_receipt(entity),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.tryAndRecover.createReceiptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_receipt(result_info.success)
			return return_value

	async def create_receipts_async(self, entities: list[Receipt]) -> list[Receipt]:
		def do_decode(raw_result):
			return [deserialize_receipt(x1) for x1 in raw_result]
		payload = {
			"entities": [serialize_receipt(x0) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.tryAndRecover.createReceiptsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_receipts_blocking(self, entities: list[Receipt]) -> list[Receipt]:
		payload = {
			"entities": [serialize_receipt(x0) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.tryAndRecover.createReceiptsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_receipt(x1) for x1 in result_info.success]
			return return_value

	async def undelete_receipt_by_id_async(self, id: str, rev: str) -> Receipt:
		def do_decode(raw_result):
			return deserialize_receipt(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.tryAndRecover.undeleteReceiptByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_receipt_by_id_blocking(self, id: str, rev: str) -> Receipt:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.tryAndRecover.undeleteReceiptByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_receipt(result_info.success)
			return return_value

	async def undelete_receipts_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[Receipt]:
		def do_decode(raw_result):
			return [deserialize_receipt(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.tryAndRecover.undeleteReceiptsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_receipts_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[Receipt]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.tryAndRecover.undeleteReceiptsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_receipt(x1) for x1 in result_info.success]
			return return_value

	async def undelete_receipt_async(self, receipt: Receipt) -> Receipt:
		def do_decode(raw_result):
			return deserialize_receipt(raw_result)
		payload = {
			"receipt": serialize_receipt(receipt),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.tryAndRecover.undeleteReceiptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_receipt_blocking(self, receipt: Receipt) -> Receipt:
		payload = {
			"receipt": serialize_receipt(receipt),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.tryAndRecover.undeleteReceiptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_receipt(result_info.success)
			return return_value

	async def undelete_receipts_async(self, receipts: list[Receipt]) -> list[Receipt]:
		def do_decode(raw_result):
			return [deserialize_receipt(x1) for x1 in raw_result]
		payload = {
			"receipts": [serialize_receipt(x0) for x0 in receipts],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.tryAndRecover.undeleteReceiptsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_receipts_blocking(self, receipts: list[Receipt]) -> list[Receipt]:
		payload = {
			"receipts": [serialize_receipt(x0) for x0 in receipts],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.tryAndRecover.undeleteReceiptsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_receipt(x1) for x1 in result_info.success]
			return return_value

	async def modify_receipt_async(self, entity: Receipt) -> Receipt:
		def do_decode(raw_result):
			return deserialize_receipt(raw_result)
		payload = {
			"entity": serialize_receipt(entity),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.tryAndRecover.modifyReceiptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_receipt_blocking(self, entity: Receipt) -> Receipt:
		payload = {
			"entity": serialize_receipt(entity),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.tryAndRecover.modifyReceiptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_receipt(result_info.success)
			return return_value

	async def modify_receipts_async(self, entities: list[Receipt]) -> list[Receipt]:
		def do_decode(raw_result):
			return [deserialize_receipt(x1) for x1 in raw_result]
		payload = {
			"entities": [serialize_receipt(x0) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.tryAndRecover.modifyReceiptsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_receipts_blocking(self, entities: list[Receipt]) -> list[Receipt]:
		payload = {
			"entities": [serialize_receipt(x0) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.tryAndRecover.modifyReceiptsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_receipt(x1) for x1 in result_info.success]
			return return_value

	async def get_receipt_async(self, entity_id: str) -> Optional[Receipt]:
		def do_decode(raw_result):
			return deserialize_receipt(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.tryAndRecover.getReceiptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_receipt_blocking(self, entity_id: str) -> Optional[Receipt]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.tryAndRecover.getReceiptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_receipt(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_receipts_async(self, entity_ids: list[str]) -> list[Receipt]:
		def do_decode(raw_result):
			return [deserialize_receipt(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.tryAndRecover.getReceiptsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_receipts_blocking(self, entity_ids: list[str]) -> list[Receipt]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.tryAndRecover.getReceiptsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_receipt(x1) for x1 in result_info.success]
			return return_value

	async def list_by_reference_async(self, reference: str) -> list[Receipt]:
		def do_decode(raw_result):
			return [deserialize_receipt(x1) for x1 in raw_result]
		payload = {
			"reference": reference,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.tryAndRecover.listByReferenceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_by_reference_blocking(self, reference: str) -> list[Receipt]:
		payload = {
			"reference": reference,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.tryAndRecover.listByReferenceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_receipt(x1) for x1 in result_info.success]
			return return_value


class ReceiptApiInGroup:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk
		self.encrypted = ReceiptApiInGroupEncrypted(self.cardinal_sdk)
		self.try_and_recover = ReceiptApiInGroupTryAndRecover(self.cardinal_sdk)

	async def with_encryption_metadata_async(self, group_id: str, base: Optional[DecryptedReceipt], patient: Optional[GroupScoped[Patient]], user: Optional[User] = None, delegates: dict[str, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent(), alternate_root_delegate_id: Optional[str] = None) -> GroupScoped[DecryptedReceipt]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedReceipt._deserialize(x1))
		payload = {
			"groupId": group_id,
			"base": base.__serialize__() if base is not None else None,
			"patient": patient.__serialize__(lambda x0: serialize_patient(x0)) if patient is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": serialize_secret_id_use_option(secret_id),
			"alternateRootDelegateId": alternate_root_delegate_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.withEncryptionMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def with_encryption_metadata_blocking(self, group_id: str, base: Optional[DecryptedReceipt], patient: Optional[GroupScoped[Patient]], user: Optional[User] = None, delegates: dict[str, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent(), alternate_root_delegate_id: Optional[str] = None) -> GroupScoped[DecryptedReceipt]:
		payload = {
			"groupId": group_id,
			"base": base.__serialize__() if base is not None else None,
			"patient": patient.__serialize__(lambda x0: serialize_patient(x0)) if patient is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": serialize_secret_id_use_option(secret_id),
			"alternateRootDelegateId": alternate_root_delegate_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.withEncryptionMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedReceipt._deserialize(x1))
			return return_value

	async def get_encryption_keys_of_async(self, receipt: GroupScoped[Receipt]) -> set[HexString]:
		def do_decode(raw_result):
			return {x1 for x1 in raw_result}
		payload = {
			"receipt": receipt.__serialize__(lambda x0: serialize_receipt(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.getEncryptionKeysOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_encryption_keys_of_blocking(self, receipt: GroupScoped[Receipt]) -> set[HexString]:
		payload = {
			"receipt": receipt.__serialize__(lambda x0: serialize_receipt(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.getEncryptionKeysOfBlocking(
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

	async def has_write_access_async(self, receipt: GroupScoped[Receipt]) -> bool:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"receipt": receipt.__serialize__(lambda x0: serialize_receipt(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.hasWriteAccessAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def has_write_access_blocking(self, receipt: GroupScoped[Receipt]) -> bool:
		payload = {
			"receipt": receipt.__serialize__(lambda x0: serialize_receipt(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.hasWriteAccessBlocking(
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

	async def decrypt_patient_id_of_async(self, receipt: GroupScoped[Receipt]) -> set[EntityReferenceInGroup]:
		def do_decode(raw_result):
			return {EntityReferenceInGroup._deserialize(x1) for x1 in raw_result}
		payload = {
			"receipt": receipt.__serialize__(lambda x0: serialize_receipt(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.decryptPatientIdOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_patient_id_of_blocking(self, receipt: GroupScoped[Receipt]) -> set[EntityReferenceInGroup]:
		payload = {
			"receipt": receipt.__serialize__(lambda x0: serialize_receipt(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.decryptPatientIdOfBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = {EntityReferenceInGroup._deserialize(x1) for x1 in result_info.success}
			return return_value

	async def create_delegation_de_anonymization_metadata_async(self, entity: GroupScoped[Receipt], delegates: set[EntityReferenceInGroup]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_receipt(x0)),
			"delegates": [x0.__serialize__() for x0 in delegates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.createDelegationDeAnonymizationMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_delegation_de_anonymization_metadata_blocking(self, entity: GroupScoped[Receipt], delegates: set[EntityReferenceInGroup]) -> None:
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_receipt(x0)),
			"delegates": [x0.__serialize__() for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.createDelegationDeAnonymizationMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def decrypt_async(self, receipts: list[GroupScoped[EncryptedReceipt]]) -> list[GroupScoped[DecryptedReceipt]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: DecryptedReceipt._deserialize(x2)) for x1 in raw_result]
		payload = {
			"receipts": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in receipts],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.decryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_blocking(self, receipts: list[GroupScoped[EncryptedReceipt]]) -> list[GroupScoped[DecryptedReceipt]]:
		payload = {
			"receipts": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in receipts],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.decryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: DecryptedReceipt._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def try_decrypt_async(self, receipts: list[GroupScoped[EncryptedReceipt]]) -> list[GroupScoped[Receipt]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: deserialize_receipt(x2)) for x1 in raw_result]
		payload = {
			"receipts": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in receipts],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.tryDecryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def try_decrypt_blocking(self, receipts: list[GroupScoped[EncryptedReceipt]]) -> list[GroupScoped[Receipt]]:
		payload = {
			"receipts": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in receipts],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.tryDecryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: deserialize_receipt(x2)) for x1 in result_info.success]
			return return_value

	async def delete_receipt_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: StoredDocumentIdentifier._deserialize(x1))
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.deleteReceiptByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_receipt_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[StoredDocumentIdentifier]:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.deleteReceiptByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: StoredDocumentIdentifier._deserialize(x1))
			return return_value

	async def delete_receipts_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.deleteReceiptsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_receipts_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.deleteReceiptsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def purge_receipt_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.purgeReceiptByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_receipt_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> None:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.purgeReceiptByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_receipts_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.purgeReceiptsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_receipts_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.purgeReceiptsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def delete_receipt_async(self, receipt: GroupScoped[Receipt]) -> GroupScoped[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: StoredDocumentIdentifier._deserialize(x1))
		payload = {
			"receipt": receipt.__serialize__(lambda x0: serialize_receipt(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.deleteReceiptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_receipt_blocking(self, receipt: GroupScoped[Receipt]) -> GroupScoped[StoredDocumentIdentifier]:
		payload = {
			"receipt": receipt.__serialize__(lambda x0: serialize_receipt(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.deleteReceiptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: StoredDocumentIdentifier._deserialize(x1))
			return return_value

	async def delete_receipts_async(self, receipts: list[GroupScoped[Receipt]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"receipts": [x0.__serialize__(lambda x1: serialize_receipt(x1)) for x0 in receipts],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.deleteReceiptsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_receipts_blocking(self, receipts: list[GroupScoped[Receipt]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"receipts": [x0.__serialize__(lambda x1: serialize_receipt(x1)) for x0 in receipts],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.deleteReceiptsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def purge_receipt_async(self, receipt: GroupScoped[Receipt]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"receipt": receipt.__serialize__(lambda x0: serialize_receipt(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.purgeReceiptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_receipt_blocking(self, receipt: GroupScoped[Receipt]) -> None:
		payload = {
			"receipt": receipt.__serialize__(lambda x0: serialize_receipt(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.purgeReceiptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_receipts_async(self, receipts: list[GroupScoped[Receipt]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"receipts": [x0.__serialize__(lambda x1: serialize_receipt(x1)) for x0 in receipts],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.purgeReceiptsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_receipts_blocking(self, receipts: list[GroupScoped[Receipt]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"receipts": [x0.__serialize__(lambda x1: serialize_receipt(x1)) for x0 in receipts],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.purgeReceiptsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def share_with_async(self, delegate: EntityReferenceInGroup, receipt: GroupScoped[DecryptedReceipt], options: Optional[ReceiptShareOptions] = None) -> GroupScoped[DecryptedReceipt]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedReceipt._deserialize(x1))
		payload = {
			"delegate": delegate.__serialize__(),
			"receipt": receipt.__serialize__(lambda x0: x0.__serialize__()),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate: EntityReferenceInGroup, receipt: GroupScoped[DecryptedReceipt], options: Optional[ReceiptShareOptions] = None) -> GroupScoped[DecryptedReceipt]:
		payload = {
			"delegate": delegate.__serialize__(),
			"receipt": receipt.__serialize__(lambda x0: x0.__serialize__()),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedReceipt._deserialize(x1))
			return return_value

	async def share_with_many_async(self, receipt: GroupScoped[DecryptedReceipt], delegates: dict[EntityReferenceInGroup, ReceiptShareOptions]) -> GroupScoped[DecryptedReceipt]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedReceipt._deserialize(x1))
		payload = {
			"receipt": receipt.__serialize__(lambda x0: x0.__serialize__()),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, receipt: GroupScoped[DecryptedReceipt], delegates: dict[EntityReferenceInGroup, ReceiptShareOptions]) -> GroupScoped[DecryptedReceipt]:
		payload = {
			"receipt": receipt.__serialize__(lambda x0: x0.__serialize__()),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedReceipt._deserialize(x1))
			return return_value

	async def create_receipt_async(self, entity: GroupScoped[DecryptedReceipt]) -> GroupScoped[DecryptedReceipt]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedReceipt._deserialize(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.createReceiptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_receipt_blocking(self, entity: GroupScoped[DecryptedReceipt]) -> GroupScoped[DecryptedReceipt]:
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.createReceiptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedReceipt._deserialize(x1))
			return return_value

	async def create_receipts_async(self, entities: list[GroupScoped[DecryptedReceipt]]) -> list[GroupScoped[DecryptedReceipt]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: DecryptedReceipt._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.createReceiptsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_receipts_blocking(self, entities: list[GroupScoped[DecryptedReceipt]]) -> list[GroupScoped[DecryptedReceipt]]:
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.createReceiptsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: DecryptedReceipt._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def undelete_receipt_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[DecryptedReceipt]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedReceipt._deserialize(x1))
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.undeleteReceiptByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_receipt_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[DecryptedReceipt]:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.undeleteReceiptByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedReceipt._deserialize(x1))
			return return_value

	async def undelete_receipts_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[DecryptedReceipt]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: DecryptedReceipt._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.undeleteReceiptsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_receipts_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[DecryptedReceipt]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.undeleteReceiptsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: DecryptedReceipt._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def undelete_receipt_async(self, receipt: GroupScoped[Receipt]) -> GroupScoped[DecryptedReceipt]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedReceipt._deserialize(x1))
		payload = {
			"receipt": receipt.__serialize__(lambda x0: serialize_receipt(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.undeleteReceiptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_receipt_blocking(self, receipt: GroupScoped[Receipt]) -> GroupScoped[DecryptedReceipt]:
		payload = {
			"receipt": receipt.__serialize__(lambda x0: serialize_receipt(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.undeleteReceiptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedReceipt._deserialize(x1))
			return return_value

	async def undelete_receipts_async(self, receipts: list[GroupScoped[DecryptedReceipt]]) -> list[GroupScoped[DecryptedReceipt]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: DecryptedReceipt._deserialize(x2)) for x1 in raw_result]
		payload = {
			"receipts": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in receipts],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.undeleteReceiptsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_receipts_blocking(self, receipts: list[GroupScoped[DecryptedReceipt]]) -> list[GroupScoped[DecryptedReceipt]]:
		payload = {
			"receipts": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in receipts],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.undeleteReceiptsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: DecryptedReceipt._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def modify_receipt_async(self, entity: GroupScoped[DecryptedReceipt]) -> GroupScoped[DecryptedReceipt]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedReceipt._deserialize(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.modifyReceiptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_receipt_blocking(self, entity: GroupScoped[DecryptedReceipt]) -> GroupScoped[DecryptedReceipt]:
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.modifyReceiptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedReceipt._deserialize(x1))
			return return_value

	async def modify_receipts_async(self, entities: list[GroupScoped[DecryptedReceipt]]) -> list[GroupScoped[DecryptedReceipt]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: DecryptedReceipt._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.modifyReceiptsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_receipts_blocking(self, entities: list[GroupScoped[DecryptedReceipt]]) -> list[GroupScoped[DecryptedReceipt]]:
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.modifyReceiptsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: DecryptedReceipt._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def get_receipt_async(self, group_id: str, entity_id: str) -> Optional[GroupScoped[DecryptedReceipt]]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedReceipt._deserialize(x1)) if raw_result is not None else None
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.getReceiptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_receipt_blocking(self, group_id: str, entity_id: str) -> Optional[GroupScoped[DecryptedReceipt]]:
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.getReceiptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedReceipt._deserialize(x1)) if result_info.success is not None else None
			return return_value

	async def get_receipts_async(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[DecryptedReceipt]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: DecryptedReceipt._deserialize(x2)) for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.getReceiptsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_receipts_blocking(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[DecryptedReceipt]]:
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.getReceiptsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: DecryptedReceipt._deserialize(x2)) for x1 in result_info.success]
			return return_value


class ReceiptApiInGroupEncrypted:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate: EntityReferenceInGroup, receipt: GroupScoped[EncryptedReceipt], options: Optional[ReceiptShareOptions] = None) -> GroupScoped[EncryptedReceipt]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedReceipt._deserialize(x1))
		payload = {
			"delegate": delegate.__serialize__(),
			"receipt": receipt.__serialize__(lambda x0: x0.__serialize__()),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.encrypted.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate: EntityReferenceInGroup, receipt: GroupScoped[EncryptedReceipt], options: Optional[ReceiptShareOptions] = None) -> GroupScoped[EncryptedReceipt]:
		payload = {
			"delegate": delegate.__serialize__(),
			"receipt": receipt.__serialize__(lambda x0: x0.__serialize__()),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.encrypted.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedReceipt._deserialize(x1))
			return return_value

	async def share_with_many_async(self, receipt: GroupScoped[EncryptedReceipt], delegates: dict[EntityReferenceInGroup, ReceiptShareOptions]) -> GroupScoped[EncryptedReceipt]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedReceipt._deserialize(x1))
		payload = {
			"receipt": receipt.__serialize__(lambda x0: x0.__serialize__()),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.encrypted.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, receipt: GroupScoped[EncryptedReceipt], delegates: dict[EntityReferenceInGroup, ReceiptShareOptions]) -> GroupScoped[EncryptedReceipt]:
		payload = {
			"receipt": receipt.__serialize__(lambda x0: x0.__serialize__()),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.encrypted.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedReceipt._deserialize(x1))
			return return_value

	async def create_receipt_async(self, entity: GroupScoped[EncryptedReceipt]) -> GroupScoped[EncryptedReceipt]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedReceipt._deserialize(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.encrypted.createReceiptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_receipt_blocking(self, entity: GroupScoped[EncryptedReceipt]) -> GroupScoped[EncryptedReceipt]:
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.encrypted.createReceiptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedReceipt._deserialize(x1))
			return return_value

	async def create_receipts_async(self, entities: list[GroupScoped[EncryptedReceipt]]) -> list[GroupScoped[EncryptedReceipt]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: EncryptedReceipt._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.encrypted.createReceiptsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_receipts_blocking(self, entities: list[GroupScoped[EncryptedReceipt]]) -> list[GroupScoped[EncryptedReceipt]]:
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.encrypted.createReceiptsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: EncryptedReceipt._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def undelete_receipt_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[EncryptedReceipt]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedReceipt._deserialize(x1))
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.encrypted.undeleteReceiptByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_receipt_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[EncryptedReceipt]:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.encrypted.undeleteReceiptByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedReceipt._deserialize(x1))
			return return_value

	async def undelete_receipts_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[EncryptedReceipt]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: EncryptedReceipt._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.encrypted.undeleteReceiptsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_receipts_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[EncryptedReceipt]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.encrypted.undeleteReceiptsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: EncryptedReceipt._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def undelete_receipt_async(self, receipt: GroupScoped[Receipt]) -> GroupScoped[EncryptedReceipt]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedReceipt._deserialize(x1))
		payload = {
			"receipt": receipt.__serialize__(lambda x0: serialize_receipt(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.encrypted.undeleteReceiptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_receipt_blocking(self, receipt: GroupScoped[Receipt]) -> GroupScoped[EncryptedReceipt]:
		payload = {
			"receipt": receipt.__serialize__(lambda x0: serialize_receipt(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.encrypted.undeleteReceiptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedReceipt._deserialize(x1))
			return return_value

	async def undelete_receipts_async(self, receipts: list[GroupScoped[EncryptedReceipt]]) -> list[GroupScoped[EncryptedReceipt]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: EncryptedReceipt._deserialize(x2)) for x1 in raw_result]
		payload = {
			"receipts": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in receipts],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.encrypted.undeleteReceiptsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_receipts_blocking(self, receipts: list[GroupScoped[EncryptedReceipt]]) -> list[GroupScoped[EncryptedReceipt]]:
		payload = {
			"receipts": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in receipts],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.encrypted.undeleteReceiptsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: EncryptedReceipt._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def modify_receipt_async(self, entity: GroupScoped[EncryptedReceipt]) -> GroupScoped[EncryptedReceipt]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedReceipt._deserialize(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.encrypted.modifyReceiptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_receipt_blocking(self, entity: GroupScoped[EncryptedReceipt]) -> GroupScoped[EncryptedReceipt]:
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.encrypted.modifyReceiptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedReceipt._deserialize(x1))
			return return_value

	async def modify_receipts_async(self, entities: list[GroupScoped[EncryptedReceipt]]) -> list[GroupScoped[EncryptedReceipt]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: EncryptedReceipt._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.encrypted.modifyReceiptsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_receipts_blocking(self, entities: list[GroupScoped[EncryptedReceipt]]) -> list[GroupScoped[EncryptedReceipt]]:
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.encrypted.modifyReceiptsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: EncryptedReceipt._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def get_receipt_async(self, group_id: str, entity_id: str) -> Optional[GroupScoped[EncryptedReceipt]]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedReceipt._deserialize(x1)) if raw_result is not None else None
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.encrypted.getReceiptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_receipt_blocking(self, group_id: str, entity_id: str) -> Optional[GroupScoped[EncryptedReceipt]]:
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.encrypted.getReceiptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedReceipt._deserialize(x1)) if result_info.success is not None else None
			return return_value

	async def get_receipts_async(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[EncryptedReceipt]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: EncryptedReceipt._deserialize(x2)) for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.encrypted.getReceiptsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_receipts_blocking(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[EncryptedReceipt]]:
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.encrypted.getReceiptsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: EncryptedReceipt._deserialize(x2)) for x1 in result_info.success]
			return return_value


class ReceiptApiInGroupTryAndRecover:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate: EntityReferenceInGroup, receipt: GroupScoped[Receipt], options: Optional[ReceiptShareOptions] = None) -> GroupScoped[Receipt]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_receipt(x1))
		payload = {
			"delegate": delegate.__serialize__(),
			"receipt": receipt.__serialize__(lambda x0: serialize_receipt(x0)),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.tryAndRecover.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate: EntityReferenceInGroup, receipt: GroupScoped[Receipt], options: Optional[ReceiptShareOptions] = None) -> GroupScoped[Receipt]:
		payload = {
			"delegate": delegate.__serialize__(),
			"receipt": receipt.__serialize__(lambda x0: serialize_receipt(x0)),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.tryAndRecover.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_receipt(x1))
			return return_value

	async def share_with_many_async(self, receipt: GroupScoped[Receipt], delegates: dict[EntityReferenceInGroup, ReceiptShareOptions]) -> GroupScoped[Receipt]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_receipt(x1))
		payload = {
			"receipt": receipt.__serialize__(lambda x0: serialize_receipt(x0)),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.tryAndRecover.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, receipt: GroupScoped[Receipt], delegates: dict[EntityReferenceInGroup, ReceiptShareOptions]) -> GroupScoped[Receipt]:
		payload = {
			"receipt": receipt.__serialize__(lambda x0: serialize_receipt(x0)),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.tryAndRecover.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_receipt(x1))
			return return_value

	async def create_receipt_async(self, entity: GroupScoped[Receipt]) -> GroupScoped[Receipt]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_receipt(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_receipt(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.tryAndRecover.createReceiptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_receipt_blocking(self, entity: GroupScoped[Receipt]) -> GroupScoped[Receipt]:
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_receipt(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.tryAndRecover.createReceiptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_receipt(x1))
			return return_value

	async def create_receipts_async(self, entities: list[GroupScoped[Receipt]]) -> list[GroupScoped[Receipt]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: deserialize_receipt(x2)) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__(lambda x1: serialize_receipt(x1)) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.tryAndRecover.createReceiptsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_receipts_blocking(self, entities: list[GroupScoped[Receipt]]) -> list[GroupScoped[Receipt]]:
		payload = {
			"entities": [x0.__serialize__(lambda x1: serialize_receipt(x1)) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.tryAndRecover.createReceiptsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: deserialize_receipt(x2)) for x1 in result_info.success]
			return return_value

	async def undelete_receipt_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[Receipt]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_receipt(x1))
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.tryAndRecover.undeleteReceiptByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_receipt_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[Receipt]:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.tryAndRecover.undeleteReceiptByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_receipt(x1))
			return return_value

	async def undelete_receipts_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[Receipt]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: deserialize_receipt(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.tryAndRecover.undeleteReceiptsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_receipts_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[Receipt]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.tryAndRecover.undeleteReceiptsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: deserialize_receipt(x2)) for x1 in result_info.success]
			return return_value

	async def undelete_receipt_async(self, receipt: GroupScoped[Receipt]) -> GroupScoped[Receipt]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_receipt(x1))
		payload = {
			"receipt": receipt.__serialize__(lambda x0: serialize_receipt(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.tryAndRecover.undeleteReceiptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_receipt_blocking(self, receipt: GroupScoped[Receipt]) -> GroupScoped[Receipt]:
		payload = {
			"receipt": receipt.__serialize__(lambda x0: serialize_receipt(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.tryAndRecover.undeleteReceiptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_receipt(x1))
			return return_value

	async def undelete_receipts_async(self, receipts: list[GroupScoped[Receipt]]) -> list[GroupScoped[Receipt]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: deserialize_receipt(x2)) for x1 in raw_result]
		payload = {
			"receipts": [x0.__serialize__(lambda x1: serialize_receipt(x1)) for x0 in receipts],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.tryAndRecover.undeleteReceiptsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_receipts_blocking(self, receipts: list[GroupScoped[Receipt]]) -> list[GroupScoped[Receipt]]:
		payload = {
			"receipts": [x0.__serialize__(lambda x1: serialize_receipt(x1)) for x0 in receipts],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.tryAndRecover.undeleteReceiptsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: deserialize_receipt(x2)) for x1 in result_info.success]
			return return_value

	async def modify_receipt_async(self, entity: GroupScoped[Receipt]) -> GroupScoped[Receipt]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_receipt(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_receipt(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.tryAndRecover.modifyReceiptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_receipt_blocking(self, entity: GroupScoped[Receipt]) -> GroupScoped[Receipt]:
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_receipt(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.tryAndRecover.modifyReceiptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_receipt(x1))
			return return_value

	async def modify_receipts_async(self, entities: list[GroupScoped[Receipt]]) -> list[GroupScoped[Receipt]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: deserialize_receipt(x2)) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__(lambda x1: serialize_receipt(x1)) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.tryAndRecover.modifyReceiptsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_receipts_blocking(self, entities: list[GroupScoped[Receipt]]) -> list[GroupScoped[Receipt]]:
		payload = {
			"entities": [x0.__serialize__(lambda x1: serialize_receipt(x1)) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.tryAndRecover.modifyReceiptsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: deserialize_receipt(x2)) for x1 in result_info.success]
			return return_value

	async def get_receipt_async(self, group_id: str, entity_id: str) -> Optional[GroupScoped[Receipt]]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_receipt(x1)) if raw_result is not None else None
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.tryAndRecover.getReceiptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_receipt_blocking(self, group_id: str, entity_id: str) -> Optional[GroupScoped[Receipt]]:
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.tryAndRecover.getReceiptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_receipt(x1)) if result_info.success is not None else None
			return return_value

	async def get_receipts_async(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[Receipt]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: deserialize_receipt(x2)) for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.tryAndRecover.getReceiptsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_receipts_blocking(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[Receipt]]:
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.inGroup.tryAndRecover.getReceiptsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: deserialize_receipt(x2)) for x1 in result_info.success]
			return return_value
