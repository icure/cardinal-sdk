# auto-generated file
import json
import base64
from typing import Optional
from cardinal_sdk.model import DecryptedReceipt, Patient, User, AccessLevel, SecretIdUseOption, SecretIdUseOptionUseAnySharedWithParent, serialize_patient, serialize_secret_id_use_option, Receipt, serialize_receipt, EncryptedReceipt, deserialize_receipt, DocIdentifier, ReceiptShareOptions
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

	async def decrypt_patient_id_of_async(self, receipt: Receipt) -> set[str]:
		def do_decode(raw_result):
			return {x1 for x1 in raw_result}
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

	def decrypt_patient_id_of_blocking(self, receipt: Receipt) -> set[str]:
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
			return_value = {x1 for x1 in result_info.success}
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

	async def delete_receipt_async(self, entity_id: str) -> DocIdentifier:
		def do_decode(raw_result):
			return DocIdentifier._deserialize(raw_result)
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.deleteReceiptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_receipt_blocking(self, entity_id: str) -> DocIdentifier:
		payload = {
			"entityId": entity_id,
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
			return_value = DocIdentifier._deserialize(result_info.success)
			return return_value

	async def delete_receipts_async(self, entity_ids: list[str]) -> list[DocIdentifier]:
		def do_decode(raw_result):
			return [DocIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ReceiptApi.deleteReceiptsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_receipts_blocking(self, entity_ids: list[str]) -> list[DocIdentifier]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
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
			return_value = [DocIdentifier._deserialize(x1) for x1 in result_info.success]
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
