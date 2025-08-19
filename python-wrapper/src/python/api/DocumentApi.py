# auto-generated file
import json
import base64
import traceback
from typing import Optional
from cardinal_sdk.model import DecryptedDocument, Message, User, AccessLevel, SecretIdUseOption, SecretIdUseOptionUseAnySharedWithParent, serialize_message, serialize_secret_id_use_option, Patient, serialize_patient, Document, serialize_document, EncryptedDocument, deserialize_document, DocIdentifier, StoredDocumentIdentifier, DocumentShareOptions
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols, CALLBACK_PARAM_DATA_INPUT
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from collections.abc import Callable
from cardinal_sdk.model.specializations import HexString
from cardinal_sdk.filters.FilterOptions import FilterOptions, SortableFilterOptions
from cardinal_sdk.pagination.PaginatedListIterator import PaginatedListIterator


class DocumentApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk
		self.encrypted = DocumentApiEncrypted(self.cardinal_sdk)
		self.try_and_recover = DocumentApiTryAndRecover(self.cardinal_sdk)

	async def with_encryption_metadata_linked_to_message_async(self, base: Optional[DecryptedDocument], message: Message, user: Optional[User] = None, delegates: dict[str, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent(), alternate_root_delegate_id: Optional[str] = None) -> DecryptedDocument:
		def do_decode(raw_result):
			return DecryptedDocument._deserialize(raw_result)
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"message": serialize_message(message),
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": serialize_secret_id_use_option(secret_id),
			"alternateRootDelegateId": alternate_root_delegate_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.withEncryptionMetadataLinkedToMessageAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def with_encryption_metadata_linked_to_message_blocking(self, base: Optional[DecryptedDocument], message: Message, user: Optional[User] = None, delegates: dict[str, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent(), alternate_root_delegate_id: Optional[str] = None) -> DecryptedDocument:
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"message": serialize_message(message),
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": serialize_secret_id_use_option(secret_id),
			"alternateRootDelegateId": alternate_root_delegate_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.withEncryptionMetadataLinkedToMessageBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedDocument._deserialize(result_info.success)
			return return_value

	async def with_encryption_metadata_linked_to_patient_async(self, base: Optional[DecryptedDocument], patient: Patient, user: Optional[User] = None, delegates: dict[str, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent(), alternate_root_delegate_id: Optional[str] = None) -> DecryptedDocument:
		def do_decode(raw_result):
			return DecryptedDocument._deserialize(raw_result)
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient),
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": serialize_secret_id_use_option(secret_id),
			"alternateRootDelegateId": alternate_root_delegate_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.withEncryptionMetadataLinkedToPatientAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def with_encryption_metadata_linked_to_patient_blocking(self, base: Optional[DecryptedDocument], patient: Patient, user: Optional[User] = None, delegates: dict[str, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent(), alternate_root_delegate_id: Optional[str] = None) -> DecryptedDocument:
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient),
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": serialize_secret_id_use_option(secret_id),
			"alternateRootDelegateId": alternate_root_delegate_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.withEncryptionMetadataLinkedToPatientBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedDocument._deserialize(result_info.success)
			return return_value

	async def with_encryption_metadata_unlinked_async(self, base: Optional[DecryptedDocument], user: Optional[User] = None, delegates: dict[str, AccessLevel] = {}, alternate_root_delegate_id: Optional[str] = None) -> DecryptedDocument:
		def do_decode(raw_result):
			return DecryptedDocument._deserialize(raw_result)
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"alternateRootDelegateId": alternate_root_delegate_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.withEncryptionMetadataUnlinkedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def with_encryption_metadata_unlinked_blocking(self, base: Optional[DecryptedDocument], user: Optional[User] = None, delegates: dict[str, AccessLevel] = {}, alternate_root_delegate_id: Optional[str] = None) -> DecryptedDocument:
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"alternateRootDelegateId": alternate_root_delegate_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.withEncryptionMetadataUnlinkedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedDocument._deserialize(result_info.success)
			return return_value

	async def get_and_try_decrypt_main_attachment_async(self, document: Document, decrypted_attachment_validator: Optional[Callable[[bytearray], bool]] = None) -> Optional[bytearray]:
		def do_decode(raw_result):
			return bytearray(base64.b64decode(raw_result)) if raw_result is not None else None
		payload = {
			"document": serialize_document(document),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.getAndTryDecryptMainAttachmentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			decryptedAttachmentValidator_callback,
		)

	def get_and_try_decrypt_main_attachment_blocking(self, document: Document, decrypted_attachment_validator: Optional[Callable[[bytearray], bool]] = None) -> Optional[bytearray]:
		payload = {
			"document": serialize_document(document),
		}
		def decryptedAttachmentValidator_fun(resultHolder, encodedInput):
			try:
				jsonInput = json.loads(encodedInput)
				result = decrypted_attachment_validator(
					bytearray(base64.b64decode(jsonInput[0])),
				)
				symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackResult(resultHolder, json.dumps(result).encode('utf-8'))
			except Exception:
				symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackFailure(resultHolder, traceback.format_exc())
		decryptedAttachmentValidator_callback = CALLBACK_PARAM_DATA_INPUT(decryptedAttachmentValidator_fun) if decrypted_attachment_validator is not None else None
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.getAndTryDecryptMainAttachmentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			decryptedAttachmentValidator_callback,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = bytearray(base64.b64decode(result_info.success)) if result_info.success is not None else None
			return return_value

	async def get_and_decrypt_main_attachment_async(self, document: Document, decrypted_attachment_validator: Optional[Callable[[bytearray], bool]] = None) -> bytearray:
		def do_decode(raw_result):
			return bytearray(base64.b64decode(raw_result))
		payload = {
			"document": serialize_document(document),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.getAndDecryptMainAttachmentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			decryptedAttachmentValidator_callback,
		)

	def get_and_decrypt_main_attachment_blocking(self, document: Document, decrypted_attachment_validator: Optional[Callable[[bytearray], bool]] = None) -> bytearray:
		payload = {
			"document": serialize_document(document),
		}
		def decryptedAttachmentValidator_fun(resultHolder, encodedInput):
			try:
				jsonInput = json.loads(encodedInput)
				result = decrypted_attachment_validator(
					bytearray(base64.b64decode(jsonInput[0])),
				)
				symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackResult(resultHolder, json.dumps(result).encode('utf-8'))
			except Exception:
				symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackFailure(resultHolder, traceback.format_exc())
		decryptedAttachmentValidator_callback = CALLBACK_PARAM_DATA_INPUT(decryptedAttachmentValidator_fun) if decrypted_attachment_validator is not None else None
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.getAndDecryptMainAttachmentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			decryptedAttachmentValidator_callback,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = bytearray(base64.b64decode(result_info.success))
			return return_value

	async def encrypt_and_set_main_attachment_async(self, document: Document, utis: Optional[list[str]], attachment: bytearray) -> EncryptedDocument:
		def do_decode(raw_result):
			return EncryptedDocument._deserialize(raw_result)
		payload = {
			"document": serialize_document(document),
			"utis": [x0 for x0 in utis] if utis is not None else None,
			"attachment": base64.b64encode(attachment).decode('utf-8'),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.encryptAndSetMainAttachmentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def encrypt_and_set_main_attachment_blocking(self, document: Document, utis: Optional[list[str]], attachment: bytearray) -> EncryptedDocument:
		payload = {
			"document": serialize_document(document),
			"utis": [x0 for x0 in utis] if utis is not None else None,
			"attachment": base64.b64encode(attachment).decode('utf-8'),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.encryptAndSetMainAttachmentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedDocument._deserialize(result_info.success)
			return return_value

	async def get_and_decrypt_secondary_attachment_async(self, document: Document, key: str, decrypted_attachment_validator: Optional[Callable[[bytearray], bool]] = None) -> bytearray:
		def do_decode(raw_result):
			return bytearray(base64.b64decode(raw_result))
		payload = {
			"document": serialize_document(document),
			"key": key,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.getAndDecryptSecondaryAttachmentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			decryptedAttachmentValidator_callback,
		)

	def get_and_decrypt_secondary_attachment_blocking(self, document: Document, key: str, decrypted_attachment_validator: Optional[Callable[[bytearray], bool]] = None) -> bytearray:
		payload = {
			"document": serialize_document(document),
			"key": key,
		}
		def decryptedAttachmentValidator_fun(resultHolder, encodedInput):
			try:
				jsonInput = json.loads(encodedInput)
				result = decrypted_attachment_validator(
					bytearray(base64.b64decode(jsonInput[0])),
				)
				symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackResult(resultHolder, json.dumps(result).encode('utf-8'))
			except Exception:
				symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackFailure(resultHolder, traceback.format_exc())
		decryptedAttachmentValidator_callback = CALLBACK_PARAM_DATA_INPUT(decryptedAttachmentValidator_fun) if decrypted_attachment_validator is not None else None
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.getAndDecryptSecondaryAttachmentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			decryptedAttachmentValidator_callback,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = bytearray(base64.b64decode(result_info.success))
			return return_value

	async def encrypt_and_set_secondary_attachment_async(self, document: Document, key: str, utis: Optional[list[str]], attachment: bytearray) -> EncryptedDocument:
		def do_decode(raw_result):
			return EncryptedDocument._deserialize(raw_result)
		payload = {
			"document": serialize_document(document),
			"key": key,
			"utis": [x0 for x0 in utis] if utis is not None else None,
			"attachment": base64.b64encode(attachment).decode('utf-8'),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.encryptAndSetSecondaryAttachmentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def encrypt_and_set_secondary_attachment_blocking(self, document: Document, key: str, utis: Optional[list[str]], attachment: bytearray) -> EncryptedDocument:
		payload = {
			"document": serialize_document(document),
			"key": key,
			"utis": [x0 for x0 in utis] if utis is not None else None,
			"attachment": base64.b64encode(attachment).decode('utf-8'),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.encryptAndSetSecondaryAttachmentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedDocument._deserialize(result_info.success)
			return return_value

	async def get_encryption_keys_of_async(self, document: Document) -> set[HexString]:
		def do_decode(raw_result):
			return {x1 for x1 in raw_result}
		payload = {
			"document": serialize_document(document),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.getEncryptionKeysOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_encryption_keys_of_blocking(self, document: Document) -> set[HexString]:
		payload = {
			"document": serialize_document(document),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.getEncryptionKeysOfBlocking(
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

	async def has_write_access_async(self, document: Document) -> bool:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"document": serialize_document(document),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.hasWriteAccessAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def has_write_access_blocking(self, document: Document) -> bool:
		payload = {
			"document": serialize_document(document),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.hasWriteAccessBlocking(
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

	async def decrypt_owning_entity_ids_of_async(self, document: Document) -> set[str]:
		def do_decode(raw_result):
			return {x1 for x1 in raw_result}
		payload = {
			"document": serialize_document(document),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.decryptOwningEntityIdsOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_owning_entity_ids_of_blocking(self, document: Document) -> set[str]:
		payload = {
			"document": serialize_document(document),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.decryptOwningEntityIdsOfBlocking(
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

	async def create_delegation_de_anonymization_metadata_async(self, entity: Document, delegates: set[str]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"entity": serialize_document(entity),
			"delegates": [x0 for x0 in delegates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.createDelegationDeAnonymizationMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_delegation_de_anonymization_metadata_blocking(self, entity: Document, delegates: set[str]) -> None:
		payload = {
			"entity": serialize_document(entity),
			"delegates": [x0 for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.createDelegationDeAnonymizationMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def decrypt_async(self, document: EncryptedDocument) -> DecryptedDocument:
		def do_decode(raw_result):
			return DecryptedDocument._deserialize(raw_result)
		payload = {
			"document": document.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.decryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_blocking(self, document: EncryptedDocument) -> DecryptedDocument:
		payload = {
			"document": document.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.decryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedDocument._deserialize(result_info.success)
			return return_value

	async def try_decrypt_async(self, document: EncryptedDocument) -> Document:
		def do_decode(raw_result):
			return deserialize_document(raw_result)
		payload = {
			"document": document.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.tryDecryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def try_decrypt_blocking(self, document: EncryptedDocument) -> Document:
		payload = {
			"document": document.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.tryDecryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_document(result_info.success)
			return return_value

	async def try_decrypt_attachment_async(self, document: Document, encrypted_attachment: bytearray, decrypted_attachment_validator: Optional[Callable[[bytearray], bool]] = None) -> Optional[bytearray]:
		def do_decode(raw_result):
			return bytearray(base64.b64decode(raw_result)) if raw_result is not None else None
		payload = {
			"document": serialize_document(document),
			"encryptedAttachment": base64.b64encode(encrypted_attachment).decode('utf-8'),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.tryDecryptAttachmentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			decryptedAttachmentValidator_callback,
		)

	def try_decrypt_attachment_blocking(self, document: Document, encrypted_attachment: bytearray, decrypted_attachment_validator: Optional[Callable[[bytearray], bool]] = None) -> Optional[bytearray]:
		payload = {
			"document": serialize_document(document),
			"encryptedAttachment": base64.b64encode(encrypted_attachment).decode('utf-8'),
		}
		def decryptedAttachmentValidator_fun(resultHolder, encodedInput):
			try:
				jsonInput = json.loads(encodedInput)
				result = decrypted_attachment_validator(
					bytearray(base64.b64decode(jsonInput[0])),
				)
				symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackResult(resultHolder, json.dumps(result).encode('utf-8'))
			except Exception:
				symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackFailure(resultHolder, traceback.format_exc())
		decryptedAttachmentValidator_callback = CALLBACK_PARAM_DATA_INPUT(decryptedAttachmentValidator_fun) if decrypted_attachment_validator is not None else None
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.tryDecryptAttachmentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			decryptedAttachmentValidator_callback,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = bytearray(base64.b64decode(result_info.success)) if result_info.success is not None else None
			return return_value

	async def match_documents_by_async(self, filter: FilterOptions[Document]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.matchDocumentsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_documents_by_blocking(self, filter: FilterOptions[Document]) -> list[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.matchDocumentsByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def match_documents_by_sorted_async(self, filter: SortableFilterOptions[Document]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.matchDocumentsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_documents_by_sorted_blocking(self, filter: SortableFilterOptions[Document]) -> list[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.matchDocumentsBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def delete_document_by_id_async(self, entity_id: str, rev: str) -> DocIdentifier:
		def do_decode(raw_result):
			return DocIdentifier._deserialize(raw_result)
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.deleteDocumentByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_document_by_id_blocking(self, entity_id: str, rev: str) -> DocIdentifier:
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.deleteDocumentByIdBlocking(
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

	async def delete_documents_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[DocIdentifier]:
		def do_decode(raw_result):
			return [DocIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.deleteDocumentsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_documents_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[DocIdentifier]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.deleteDocumentsByIdsBlocking(
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

	async def purge_document_by_id_async(self, id: str, rev: str) -> None:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.purgeDocumentByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_document_by_id_blocking(self, id: str, rev: str) -> None:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.purgeDocumentByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def delete_document_async(self, document: Document) -> DocIdentifier:
		def do_decode(raw_result):
			return DocIdentifier._deserialize(raw_result)
		payload = {
			"document": serialize_document(document),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.deleteDocumentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_document_blocking(self, document: Document) -> DocIdentifier:
		payload = {
			"document": serialize_document(document),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.deleteDocumentBlocking(
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

	async def delete_documents_async(self, documents: list[Document]) -> list[DocIdentifier]:
		def do_decode(raw_result):
			return [DocIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"documents": [serialize_document(x0) for x0 in documents],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.deleteDocumentsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_documents_blocking(self, documents: list[Document]) -> list[DocIdentifier]:
		payload = {
			"documents": [serialize_document(x0) for x0 in documents],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.deleteDocumentsBlocking(
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

	async def purge_document_async(self, document: Document) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"document": serialize_document(document),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.purgeDocumentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_document_blocking(self, document: Document) -> None:
		payload = {
			"document": serialize_document(document),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.purgeDocumentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def get_raw_main_attachment_async(self, document_id: str) -> bytearray:
		def do_decode(raw_result):
			return bytearray(base64.b64decode(raw_result))
		payload = {
			"documentId": document_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.getRawMainAttachmentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_raw_main_attachment_blocking(self, document_id: str) -> bytearray:
		payload = {
			"documentId": document_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.getRawMainAttachmentBlocking(
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

	async def get_raw_secondary_attachment_async(self, document_id: str, key: str) -> bytearray:
		def do_decode(raw_result):
			return bytearray(base64.b64decode(raw_result))
		payload = {
			"documentId": document_id,
			"key": key,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.getRawSecondaryAttachmentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_raw_secondary_attachment_blocking(self, document_id: str, key: str) -> bytearray:
		payload = {
			"documentId": document_id,
			"key": key,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.getRawSecondaryAttachmentBlocking(
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

	async def set_raw_main_attachment_async(self, document_id: str, rev: str, utis: Optional[list[str]], attachment: bytearray, encrypted: bool) -> EncryptedDocument:
		def do_decode(raw_result):
			return EncryptedDocument._deserialize(raw_result)
		payload = {
			"documentId": document_id,
			"rev": rev,
			"utis": [x0 for x0 in utis] if utis is not None else None,
			"attachment": base64.b64encode(attachment).decode('utf-8'),
			"encrypted": encrypted,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.setRawMainAttachmentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def set_raw_main_attachment_blocking(self, document_id: str, rev: str, utis: Optional[list[str]], attachment: bytearray, encrypted: bool) -> EncryptedDocument:
		payload = {
			"documentId": document_id,
			"rev": rev,
			"utis": [x0 for x0 in utis] if utis is not None else None,
			"attachment": base64.b64encode(attachment).decode('utf-8'),
			"encrypted": encrypted,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.setRawMainAttachmentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedDocument._deserialize(result_info.success)
			return return_value

	async def set_raw_secondary_attachment_async(self, document_id: str, key: str, rev: str, utis: Optional[list[str]], attachment: bytearray, encrypted: bool) -> EncryptedDocument:
		def do_decode(raw_result):
			return EncryptedDocument._deserialize(raw_result)
		payload = {
			"documentId": document_id,
			"key": key,
			"rev": rev,
			"utis": [x0 for x0 in utis] if utis is not None else None,
			"attachment": base64.b64encode(attachment).decode('utf-8'),
			"encrypted": encrypted,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.setRawSecondaryAttachmentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def set_raw_secondary_attachment_blocking(self, document_id: str, key: str, rev: str, utis: Optional[list[str]], attachment: bytearray, encrypted: bool) -> EncryptedDocument:
		payload = {
			"documentId": document_id,
			"key": key,
			"rev": rev,
			"utis": [x0 for x0 in utis] if utis is not None else None,
			"attachment": base64.b64encode(attachment).decode('utf-8'),
			"encrypted": encrypted,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.setRawSecondaryAttachmentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedDocument._deserialize(result_info.success)
			return return_value

	async def delete_main_attachment_async(self, entity_id: str, rev: str) -> EncryptedDocument:
		def do_decode(raw_result):
			return EncryptedDocument._deserialize(raw_result)
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.deleteMainAttachmentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_main_attachment_blocking(self, entity_id: str, rev: str) -> EncryptedDocument:
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.deleteMainAttachmentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedDocument._deserialize(result_info.success)
			return return_value

	async def delete_secondary_attachment_async(self, document_id: str, key: str, rev: str) -> EncryptedDocument:
		def do_decode(raw_result):
			return EncryptedDocument._deserialize(raw_result)
		payload = {
			"documentId": document_id,
			"key": key,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.deleteSecondaryAttachmentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_secondary_attachment_blocking(self, document_id: str, key: str, rev: str) -> EncryptedDocument:
		payload = {
			"documentId": document_id,
			"key": key,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.deleteSecondaryAttachmentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedDocument._deserialize(result_info.success)
			return return_value

	async def share_with_async(self, delegate_id: str, document: DecryptedDocument, options: Optional[DocumentShareOptions] = None) -> DecryptedDocument:
		def do_decode(raw_result):
			return DecryptedDocument._deserialize(raw_result)
		payload = {
			"delegateId": delegate_id,
			"document": document.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, document: DecryptedDocument, options: Optional[DocumentShareOptions] = None) -> DecryptedDocument:
		payload = {
			"delegateId": delegate_id,
			"document": document.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedDocument._deserialize(result_info.success)
			return return_value

	async def share_with_many_async(self, document: DecryptedDocument, delegates: dict[str, DocumentShareOptions]) -> DecryptedDocument:
		def do_decode(raw_result):
			return DecryptedDocument._deserialize(raw_result)
		payload = {
			"document": document.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, document: DecryptedDocument, delegates: dict[str, DocumentShareOptions]) -> DecryptedDocument:
		payload = {
			"document": document.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedDocument._deserialize(result_info.success)
			return return_value

	async def filter_documents_by_async(self, filter: FilterOptions[Document]) -> PaginatedListIterator[DecryptedDocument]:
		def do_decode(raw_result):
			return PaginatedListIterator[DecryptedDocument](
				producer = raw_result,
				deserializer = lambda x: DecryptedDocument._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.filterDocumentsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_documents_by_blocking(self, filter: FilterOptions[Document]) -> PaginatedListIterator[DecryptedDocument]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.filterDocumentsByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[DecryptedDocument](
				producer = class_pointer,
				deserializer = lambda x: DecryptedDocument._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_documents_by_sorted_async(self, filter: SortableFilterOptions[Document]) -> PaginatedListIterator[DecryptedDocument]:
		def do_decode(raw_result):
			return PaginatedListIterator[DecryptedDocument](
				producer = raw_result,
				deserializer = lambda x: DecryptedDocument._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.filterDocumentsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_documents_by_sorted_blocking(self, filter: SortableFilterOptions[Document]) -> PaginatedListIterator[DecryptedDocument]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.filterDocumentsBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[DecryptedDocument](
				producer = class_pointer,
				deserializer = lambda x: DecryptedDocument._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def create_document_async(self, entity: DecryptedDocument) -> DecryptedDocument:
		def do_decode(raw_result):
			return DecryptedDocument._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.createDocumentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_document_blocking(self, entity: DecryptedDocument) -> DecryptedDocument:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.createDocumentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedDocument._deserialize(result_info.success)
			return return_value

	async def undelete_document_by_id_async(self, id: str, rev: str) -> DecryptedDocument:
		def do_decode(raw_result):
			return DecryptedDocument._deserialize(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.undeleteDocumentByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_document_by_id_blocking(self, id: str, rev: str) -> DecryptedDocument:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.undeleteDocumentByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedDocument._deserialize(result_info.success)
			return return_value

	async def undelete_document_async(self, document: Document) -> DecryptedDocument:
		def do_decode(raw_result):
			return DecryptedDocument._deserialize(raw_result)
		payload = {
			"document": serialize_document(document),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.undeleteDocumentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_document_blocking(self, document: Document) -> DecryptedDocument:
		payload = {
			"document": serialize_document(document),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.undeleteDocumentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedDocument._deserialize(result_info.success)
			return return_value

	async def modify_document_async(self, entity: DecryptedDocument) -> DecryptedDocument:
		def do_decode(raw_result):
			return DecryptedDocument._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.modifyDocumentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_document_blocking(self, entity: DecryptedDocument) -> DecryptedDocument:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.modifyDocumentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedDocument._deserialize(result_info.success)
			return return_value

	async def get_document_async(self, entity_id: str) -> Optional[DecryptedDocument]:
		def do_decode(raw_result):
			return DecryptedDocument._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.getDocumentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_document_blocking(self, entity_id: str) -> Optional[DecryptedDocument]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.getDocumentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedDocument._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_documents_async(self, entity_ids: list[str]) -> list[DecryptedDocument]:
		def do_decode(raw_result):
			return [DecryptedDocument._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.getDocumentsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_documents_blocking(self, entity_ids: list[str]) -> list[DecryptedDocument]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.getDocumentsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedDocument._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def modify_documents_async(self, entities: list[DecryptedDocument]) -> list[DecryptedDocument]:
		def do_decode(raw_result):
			return [DecryptedDocument._deserialize(x1) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.modifyDocumentsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_documents_blocking(self, entities: list[DecryptedDocument]) -> list[DecryptedDocument]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.modifyDocumentsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedDocument._deserialize(x1) for x1 in result_info.success]
			return return_value


class DocumentApiEncrypted:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate_id: str, document: EncryptedDocument, options: Optional[DocumentShareOptions] = None) -> EncryptedDocument:
		def do_decode(raw_result):
			return EncryptedDocument._deserialize(raw_result)
		payload = {
			"delegateId": delegate_id,
			"document": document.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.encrypted.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, document: EncryptedDocument, options: Optional[DocumentShareOptions] = None) -> EncryptedDocument:
		payload = {
			"delegateId": delegate_id,
			"document": document.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.encrypted.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedDocument._deserialize(result_info.success)
			return return_value

	async def share_with_many_async(self, document: EncryptedDocument, delegates: dict[str, DocumentShareOptions]) -> EncryptedDocument:
		def do_decode(raw_result):
			return EncryptedDocument._deserialize(raw_result)
		payload = {
			"document": document.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.encrypted.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, document: EncryptedDocument, delegates: dict[str, DocumentShareOptions]) -> EncryptedDocument:
		payload = {
			"document": document.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.encrypted.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedDocument._deserialize(result_info.success)
			return return_value

	async def filter_documents_by_async(self, filter: FilterOptions[Document]) -> PaginatedListIterator[EncryptedDocument]:
		def do_decode(raw_result):
			return PaginatedListIterator[EncryptedDocument](
				producer = raw_result,
				deserializer = lambda x: EncryptedDocument._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.encrypted.filterDocumentsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_documents_by_blocking(self, filter: FilterOptions[Document]) -> PaginatedListIterator[EncryptedDocument]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.encrypted.filterDocumentsByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[EncryptedDocument](
				producer = class_pointer,
				deserializer = lambda x: EncryptedDocument._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_documents_by_sorted_async(self, filter: SortableFilterOptions[Document]) -> PaginatedListIterator[EncryptedDocument]:
		def do_decode(raw_result):
			return PaginatedListIterator[EncryptedDocument](
				producer = raw_result,
				deserializer = lambda x: EncryptedDocument._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.encrypted.filterDocumentsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_documents_by_sorted_blocking(self, filter: SortableFilterOptions[Document]) -> PaginatedListIterator[EncryptedDocument]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.encrypted.filterDocumentsBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[EncryptedDocument](
				producer = class_pointer,
				deserializer = lambda x: EncryptedDocument._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def create_document_async(self, entity: EncryptedDocument) -> EncryptedDocument:
		def do_decode(raw_result):
			return EncryptedDocument._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.encrypted.createDocumentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_document_blocking(self, entity: EncryptedDocument) -> EncryptedDocument:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.encrypted.createDocumentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedDocument._deserialize(result_info.success)
			return return_value

	async def undelete_document_by_id_async(self, id: str, rev: str) -> EncryptedDocument:
		def do_decode(raw_result):
			return EncryptedDocument._deserialize(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.encrypted.undeleteDocumentByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_document_by_id_blocking(self, id: str, rev: str) -> EncryptedDocument:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.encrypted.undeleteDocumentByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedDocument._deserialize(result_info.success)
			return return_value

	async def undelete_document_async(self, document: Document) -> EncryptedDocument:
		def do_decode(raw_result):
			return EncryptedDocument._deserialize(raw_result)
		payload = {
			"document": serialize_document(document),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.encrypted.undeleteDocumentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_document_blocking(self, document: Document) -> EncryptedDocument:
		payload = {
			"document": serialize_document(document),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.encrypted.undeleteDocumentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedDocument._deserialize(result_info.success)
			return return_value

	async def modify_document_async(self, entity: EncryptedDocument) -> EncryptedDocument:
		def do_decode(raw_result):
			return EncryptedDocument._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.encrypted.modifyDocumentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_document_blocking(self, entity: EncryptedDocument) -> EncryptedDocument:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.encrypted.modifyDocumentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedDocument._deserialize(result_info.success)
			return return_value

	async def get_document_async(self, entity_id: str) -> Optional[EncryptedDocument]:
		def do_decode(raw_result):
			return EncryptedDocument._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.encrypted.getDocumentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_document_blocking(self, entity_id: str) -> Optional[EncryptedDocument]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.encrypted.getDocumentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedDocument._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_documents_async(self, entity_ids: list[str]) -> list[EncryptedDocument]:
		def do_decode(raw_result):
			return [EncryptedDocument._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.encrypted.getDocumentsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_documents_blocking(self, entity_ids: list[str]) -> list[EncryptedDocument]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.encrypted.getDocumentsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedDocument._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def modify_documents_async(self, entities: list[EncryptedDocument]) -> list[EncryptedDocument]:
		def do_decode(raw_result):
			return [EncryptedDocument._deserialize(x1) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.encrypted.modifyDocumentsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_documents_blocking(self, entities: list[EncryptedDocument]) -> list[EncryptedDocument]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.encrypted.modifyDocumentsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedDocument._deserialize(x1) for x1 in result_info.success]
			return return_value


class DocumentApiTryAndRecover:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate_id: str, document: Document, options: Optional[DocumentShareOptions] = None) -> Document:
		def do_decode(raw_result):
			return deserialize_document(raw_result)
		payload = {
			"delegateId": delegate_id,
			"document": serialize_document(document),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.tryAndRecover.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, document: Document, options: Optional[DocumentShareOptions] = None) -> Document:
		payload = {
			"delegateId": delegate_id,
			"document": serialize_document(document),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.tryAndRecover.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_document(result_info.success)
			return return_value

	async def share_with_many_async(self, document: Document, delegates: dict[str, DocumentShareOptions]) -> Document:
		def do_decode(raw_result):
			return deserialize_document(raw_result)
		payload = {
			"document": serialize_document(document),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.tryAndRecover.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, document: Document, delegates: dict[str, DocumentShareOptions]) -> Document:
		payload = {
			"document": serialize_document(document),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.tryAndRecover.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_document(result_info.success)
			return return_value

	async def filter_documents_by_async(self, filter: FilterOptions[Document]) -> PaginatedListIterator[Document]:
		def do_decode(raw_result):
			return PaginatedListIterator[Document](
				producer = raw_result,
				deserializer = lambda x: deserialize_document(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.tryAndRecover.filterDocumentsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_documents_by_blocking(self, filter: FilterOptions[Document]) -> PaginatedListIterator[Document]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.tryAndRecover.filterDocumentsByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[Document](
				producer = class_pointer,
				deserializer = lambda x: deserialize_document(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_documents_by_sorted_async(self, filter: SortableFilterOptions[Document]) -> PaginatedListIterator[Document]:
		def do_decode(raw_result):
			return PaginatedListIterator[Document](
				producer = raw_result,
				deserializer = lambda x: deserialize_document(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.tryAndRecover.filterDocumentsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_documents_by_sorted_blocking(self, filter: SortableFilterOptions[Document]) -> PaginatedListIterator[Document]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.tryAndRecover.filterDocumentsBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[Document](
				producer = class_pointer,
				deserializer = lambda x: deserialize_document(x),
				executor = self.cardinal_sdk._executor
			)

	async def create_document_async(self, entity: Document) -> Document:
		def do_decode(raw_result):
			return deserialize_document(raw_result)
		payload = {
			"entity": serialize_document(entity),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.tryAndRecover.createDocumentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_document_blocking(self, entity: Document) -> Document:
		payload = {
			"entity": serialize_document(entity),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.tryAndRecover.createDocumentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_document(result_info.success)
			return return_value

	async def undelete_document_by_id_async(self, id: str, rev: str) -> Document:
		def do_decode(raw_result):
			return deserialize_document(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.tryAndRecover.undeleteDocumentByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_document_by_id_blocking(self, id: str, rev: str) -> Document:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.tryAndRecover.undeleteDocumentByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_document(result_info.success)
			return return_value

	async def undelete_document_async(self, document: Document) -> Document:
		def do_decode(raw_result):
			return deserialize_document(raw_result)
		payload = {
			"document": serialize_document(document),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.tryAndRecover.undeleteDocumentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_document_blocking(self, document: Document) -> Document:
		payload = {
			"document": serialize_document(document),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.tryAndRecover.undeleteDocumentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_document(result_info.success)
			return return_value

	async def modify_document_async(self, entity: Document) -> Document:
		def do_decode(raw_result):
			return deserialize_document(raw_result)
		payload = {
			"entity": serialize_document(entity),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.tryAndRecover.modifyDocumentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_document_blocking(self, entity: Document) -> Document:
		payload = {
			"entity": serialize_document(entity),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.tryAndRecover.modifyDocumentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_document(result_info.success)
			return return_value

	async def get_document_async(self, entity_id: str) -> Optional[Document]:
		def do_decode(raw_result):
			return deserialize_document(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.tryAndRecover.getDocumentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_document_blocking(self, entity_id: str) -> Optional[Document]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.tryAndRecover.getDocumentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_document(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_documents_async(self, entity_ids: list[str]) -> list[Document]:
		def do_decode(raw_result):
			return [deserialize_document(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.tryAndRecover.getDocumentsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_documents_blocking(self, entity_ids: list[str]) -> list[Document]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.tryAndRecover.getDocumentsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_document(x1) for x1 in result_info.success]
			return return_value

	async def modify_documents_async(self, entities: list[Document]) -> list[Document]:
		def do_decode(raw_result):
			return [deserialize_document(x1) for x1 in raw_result]
		payload = {
			"entities": [serialize_document(x0) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.tryAndRecover.modifyDocumentsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_documents_blocking(self, entities: list[Document]) -> list[Document]:
		payload = {
			"entities": [serialize_document(x0) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentApi.tryAndRecover.modifyDocumentsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_document(x1) for x1 in result_info.success]
			return return_value
