# auto-generated file
import json
from typing import Optional
from cardinal_sdk.model import DecryptedMessage, Patient, User, AccessLevel, SecretIdUseOption, SecretIdUseOptionUseAnySharedWithParent, serialize_patient, serialize_secret_id_use_option, Message, serialize_message, EncryptedMessage, deserialize_message, EntityReferenceInGroup, DocIdentifier, StoredDocumentIdentifier, MessageShareOptions, SubscriptionEventType, EntitySubscriptionConfiguration
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.model.specializations import HexString
from cardinal_sdk.filters.FilterOptions import FilterOptions, SortableFilterOptions
from cardinal_sdk.pagination.PaginatedListIterator import PaginatedListIterator
from cardinal_sdk.subscription.EntitySubscription import EntitySubscription


class MessageApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk
		self.encrypted = MessageApiEncrypted(self.cardinal_sdk)
		self.try_and_recover = MessageApiTryAndRecover(self.cardinal_sdk)

	async def with_encryption_metadata_async(self, base: Optional[DecryptedMessage], patient: Optional[Patient], user: Optional[User] = None, delegates: dict[str, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent(), alternate_root_delegate_id: Optional[str] = None) -> DecryptedMessage:
		def do_decode(raw_result):
			return DecryptedMessage._deserialize(raw_result)
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.withEncryptionMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def with_encryption_metadata_blocking(self, base: Optional[DecryptedMessage], patient: Optional[Patient], user: Optional[User] = None, delegates: dict[str, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent(), alternate_root_delegate_id: Optional[str] = None) -> DecryptedMessage:
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient) if patient is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": serialize_secret_id_use_option(secret_id),
			"alternateRootDelegateId": alternate_root_delegate_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.withEncryptionMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedMessage._deserialize(result_info.success)
			return return_value

	async def get_encryption_keys_of_async(self, message: Message) -> set[HexString]:
		def do_decode(raw_result):
			return {x1 for x1 in raw_result}
		payload = {
			"message": serialize_message(message),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.getEncryptionKeysOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_encryption_keys_of_blocking(self, message: Message) -> set[HexString]:
		payload = {
			"message": serialize_message(message),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.getEncryptionKeysOfBlocking(
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

	async def has_write_access_async(self, message: Message) -> bool:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"message": serialize_message(message),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.hasWriteAccessAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def has_write_access_blocking(self, message: Message) -> bool:
		payload = {
			"message": serialize_message(message),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.hasWriteAccessBlocking(
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

	async def decrypt_patient_id_of_async(self, message: Message) -> set[str]:
		def do_decode(raw_result):
			return {x1 for x1 in raw_result}
		payload = {
			"message": serialize_message(message),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.decryptPatientIdOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_patient_id_of_blocking(self, message: Message) -> set[str]:
		payload = {
			"message": serialize_message(message),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.decryptPatientIdOfBlocking(
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

	async def create_delegation_de_anonymization_metadata_async(self, entity: Message, delegates: set[str]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"entity": serialize_message(entity),
			"delegates": [x0 for x0 in delegates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.createDelegationDeAnonymizationMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_delegation_de_anonymization_metadata_blocking(self, entity: Message, delegates: set[str]) -> None:
		payload = {
			"entity": serialize_message(entity),
			"delegates": [x0 for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.createDelegationDeAnonymizationMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def decrypt_async(self, message: EncryptedMessage) -> DecryptedMessage:
		def do_decode(raw_result):
			return DecryptedMessage._deserialize(raw_result)
		payload = {
			"message": message.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.decryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_blocking(self, message: EncryptedMessage) -> DecryptedMessage:
		payload = {
			"message": message.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.decryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedMessage._deserialize(result_info.success)
			return return_value

	async def try_decrypt_async(self, message: EncryptedMessage) -> Message:
		def do_decode(raw_result):
			return deserialize_message(raw_result)
		payload = {
			"message": message.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryDecryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def try_decrypt_blocking(self, message: EncryptedMessage) -> Message:
		payload = {
			"message": message.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryDecryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_message(result_info.success)
			return return_value

	async def get_secret_ids_of_async(self, message: Message) -> dict[str, set[EntityReferenceInGroup]]:
		def do_decode(raw_result):
			return dict(map(lambda kv1: (kv1[0], {EntityReferenceInGroup._deserialize(x2) for x2 in kv1[1]}), raw_result.items()))
		payload = {
			"message": serialize_message(message),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.getSecretIdsOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_secret_ids_of_blocking(self, message: Message) -> dict[str, set[EntityReferenceInGroup]]:
		payload = {
			"message": serialize_message(message),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.getSecretIdsOfBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = dict(map(lambda kv1: (kv1[0], {EntityReferenceInGroup._deserialize(x2) for x2 in kv1[1]}), result_info.success.items()))
			return return_value

	async def match_messages_by_async(self, filter: FilterOptions[Message]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.matchMessagesByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_messages_by_blocking(self, filter: FilterOptions[Message]) -> list[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.matchMessagesByBlocking(
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

	async def match_messages_by_sorted_async(self, filter: SortableFilterOptions[Message]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.matchMessagesBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_messages_by_sorted_blocking(self, filter: SortableFilterOptions[Message]) -> list[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.matchMessagesBySortedBlocking(
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

	async def delete_message_by_id_async(self, entity_id: str, rev: str) -> DocIdentifier:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.deleteMessageByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_message_by_id_blocking(self, entity_id: str, rev: str) -> DocIdentifier:
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.deleteMessageByIdBlocking(
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

	async def delete_messages_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[DocIdentifier]:
		def do_decode(raw_result):
			return [DocIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.deleteMessagesByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_messages_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[DocIdentifier]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.deleteMessagesByIdsBlocking(
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

	async def purge_message_by_id_async(self, id: str, rev: str) -> None:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.purgeMessageByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_message_by_id_blocking(self, id: str, rev: str) -> None:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.purgeMessageByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def delete_message_async(self, message: Message) -> DocIdentifier:
		def do_decode(raw_result):
			return DocIdentifier._deserialize(raw_result)
		payload = {
			"message": serialize_message(message),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.deleteMessageAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_message_blocking(self, message: Message) -> DocIdentifier:
		payload = {
			"message": serialize_message(message),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.deleteMessageBlocking(
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

	async def delete_messages_async(self, messages: list[Message]) -> list[DocIdentifier]:
		def do_decode(raw_result):
			return [DocIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"messages": [serialize_message(x0) for x0 in messages],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.deleteMessagesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_messages_blocking(self, messages: list[Message]) -> list[DocIdentifier]:
		payload = {
			"messages": [serialize_message(x0) for x0 in messages],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.deleteMessagesBlocking(
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

	async def purge_message_async(self, message: Message) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"message": serialize_message(message),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.purgeMessageAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_message_blocking(self, message: Message) -> None:
		payload = {
			"message": serialize_message(message),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.purgeMessageBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def share_with_async(self, delegate_id: str, message: DecryptedMessage, options: Optional[MessageShareOptions] = None) -> DecryptedMessage:
		def do_decode(raw_result):
			return DecryptedMessage._deserialize(raw_result)
		payload = {
			"delegateId": delegate_id,
			"message": message.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, message: DecryptedMessage, options: Optional[MessageShareOptions] = None) -> DecryptedMessage:
		payload = {
			"delegateId": delegate_id,
			"message": message.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedMessage._deserialize(result_info.success)
			return return_value

	async def share_with_many_async(self, message: DecryptedMessage, delegates: dict[str, MessageShareOptions]) -> DecryptedMessage:
		def do_decode(raw_result):
			return DecryptedMessage._deserialize(raw_result)
		payload = {
			"message": message.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, message: DecryptedMessage, delegates: dict[str, MessageShareOptions]) -> DecryptedMessage:
		payload = {
			"message": message.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedMessage._deserialize(result_info.success)
			return return_value

	async def filter_messages_by_async(self, filter: FilterOptions[Message]) -> PaginatedListIterator[DecryptedMessage]:
		def do_decode(raw_result):
			return PaginatedListIterator[DecryptedMessage](
				producer = raw_result,
				deserializer = lambda x: DecryptedMessage._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.filterMessagesByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_messages_by_blocking(self, filter: FilterOptions[Message]) -> PaginatedListIterator[DecryptedMessage]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.filterMessagesByBlocking(
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
			return PaginatedListIterator[DecryptedMessage](
				producer = class_pointer,
				deserializer = lambda x: DecryptedMessage._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_messages_by_sorted_async(self, filter: SortableFilterOptions[Message]) -> PaginatedListIterator[DecryptedMessage]:
		def do_decode(raw_result):
			return PaginatedListIterator[DecryptedMessage](
				producer = raw_result,
				deserializer = lambda x: DecryptedMessage._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.filterMessagesBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_messages_by_sorted_blocking(self, filter: SortableFilterOptions[Message]) -> PaginatedListIterator[DecryptedMessage]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.filterMessagesBySortedBlocking(
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
			return PaginatedListIterator[DecryptedMessage](
				producer = class_pointer,
				deserializer = lambda x: DecryptedMessage._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def create_message_async(self, entity: DecryptedMessage) -> DecryptedMessage:
		def do_decode(raw_result):
			return DecryptedMessage._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.createMessageAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_message_blocking(self, entity: DecryptedMessage) -> DecryptedMessage:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.createMessageBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedMessage._deserialize(result_info.success)
			return return_value

	async def create_message_in_topic_async(self, entity: DecryptedMessage) -> DecryptedMessage:
		def do_decode(raw_result):
			return DecryptedMessage._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.createMessageInTopicAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_message_in_topic_blocking(self, entity: DecryptedMessage) -> DecryptedMessage:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.createMessageInTopicBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedMessage._deserialize(result_info.success)
			return return_value

	async def undelete_message_async(self, message: Message) -> Message:
		def do_decode(raw_result):
			return deserialize_message(raw_result)
		payload = {
			"message": serialize_message(message),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.undeleteMessageAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_message_blocking(self, message: Message) -> Message:
		payload = {
			"message": serialize_message(message),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.undeleteMessageBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_message(result_info.success)
			return return_value

	async def modify_message_async(self, entity: DecryptedMessage) -> DecryptedMessage:
		def do_decode(raw_result):
			return DecryptedMessage._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.modifyMessageAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_message_blocking(self, entity: DecryptedMessage) -> DecryptedMessage:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.modifyMessageBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedMessage._deserialize(result_info.success)
			return return_value

	async def undelete_message_by_id_async(self, id: str, rev: str) -> DecryptedMessage:
		def do_decode(raw_result):
			return DecryptedMessage._deserialize(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.undeleteMessageByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_message_by_id_blocking(self, id: str, rev: str) -> DecryptedMessage:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.undeleteMessageByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedMessage._deserialize(result_info.success)
			return return_value

	async def get_message_async(self, entity_id: str) -> Optional[DecryptedMessage]:
		def do_decode(raw_result):
			return DecryptedMessage._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.getMessageAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_message_blocking(self, entity_id: str) -> Optional[DecryptedMessage]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.getMessageBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedMessage._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_messages_async(self, entity_ids: list[str]) -> list[DecryptedMessage]:
		def do_decode(raw_result):
			return [DecryptedMessage._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.getMessagesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_messages_blocking(self, entity_ids: list[str]) -> list[DecryptedMessage]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.getMessagesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedMessage._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def set_messages_read_status_async(self, entity_ids: list[str], time: Optional[int], read_status: bool, user_id: Optional[str]) -> list[DecryptedMessage]:
		def do_decode(raw_result):
			return [DecryptedMessage._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
			"time": time,
			"readStatus": read_status,
			"userId": user_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.setMessagesReadStatusAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def set_messages_read_status_blocking(self, entity_ids: list[str], time: Optional[int], read_status: bool, user_id: Optional[str]) -> list[DecryptedMessage]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
			"time": time,
			"readStatus": read_status,
			"userId": user_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.setMessagesReadStatusBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedMessage._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def subscribe_to_events_async(self, events: set[SubscriptionEventType], filter: FilterOptions[Message], subscription_config: Optional[EntitySubscriptionConfiguration] = None) -> EntitySubscription[EncryptedMessage]:
		def do_decode(raw_result):
			return EntitySubscription[EncryptedMessage](
				producer = raw_result,
				deserializer = lambda x: EncryptedMessage._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"events": [x0.__serialize__() for x0 in events],
			"filter": filter.__serialize__(),
			"subscriptionConfig": subscription_config.__serialize__() if subscription_config is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.subscribeToEventsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def subscribe_to_events_blocking(self, events: set[SubscriptionEventType], filter: FilterOptions[Message], subscription_config: Optional[EntitySubscriptionConfiguration] = None) -> EntitySubscription[EncryptedMessage]:
		payload = {
			"events": [x0.__serialize__() for x0 in events],
			"filter": filter.__serialize__(),
			"subscriptionConfig": subscription_config.__serialize__() if subscription_config is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.subscribeToEventsBlocking(
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
			return EntitySubscription[EncryptedMessage](
				producer = class_pointer,
				deserializer = lambda x: EncryptedMessage._deserialize(x),
				executor = self.cardinal_sdk._executor
			)


class MessageApiEncrypted:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate_id: str, message: EncryptedMessage, options: Optional[MessageShareOptions] = None) -> EncryptedMessage:
		def do_decode(raw_result):
			return EncryptedMessage._deserialize(raw_result)
		payload = {
			"delegateId": delegate_id,
			"message": message.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, message: EncryptedMessage, options: Optional[MessageShareOptions] = None) -> EncryptedMessage:
		payload = {
			"delegateId": delegate_id,
			"message": message.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedMessage._deserialize(result_info.success)
			return return_value

	async def share_with_many_async(self, message: EncryptedMessage, delegates: dict[str, MessageShareOptions]) -> EncryptedMessage:
		def do_decode(raw_result):
			return EncryptedMessage._deserialize(raw_result)
		payload = {
			"message": message.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, message: EncryptedMessage, delegates: dict[str, MessageShareOptions]) -> EncryptedMessage:
		payload = {
			"message": message.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedMessage._deserialize(result_info.success)
			return return_value

	async def filter_messages_by_async(self, filter: FilterOptions[Message]) -> PaginatedListIterator[EncryptedMessage]:
		def do_decode(raw_result):
			return PaginatedListIterator[EncryptedMessage](
				producer = raw_result,
				deserializer = lambda x: EncryptedMessage._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.filterMessagesByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_messages_by_blocking(self, filter: FilterOptions[Message]) -> PaginatedListIterator[EncryptedMessage]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.filterMessagesByBlocking(
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
			return PaginatedListIterator[EncryptedMessage](
				producer = class_pointer,
				deserializer = lambda x: EncryptedMessage._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_messages_by_sorted_async(self, filter: SortableFilterOptions[Message]) -> PaginatedListIterator[EncryptedMessage]:
		def do_decode(raw_result):
			return PaginatedListIterator[EncryptedMessage](
				producer = raw_result,
				deserializer = lambda x: EncryptedMessage._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.filterMessagesBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_messages_by_sorted_blocking(self, filter: SortableFilterOptions[Message]) -> PaginatedListIterator[EncryptedMessage]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.filterMessagesBySortedBlocking(
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
			return PaginatedListIterator[EncryptedMessage](
				producer = class_pointer,
				deserializer = lambda x: EncryptedMessage._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def create_message_async(self, entity: EncryptedMessage) -> EncryptedMessage:
		def do_decode(raw_result):
			return EncryptedMessage._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.createMessageAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_message_blocking(self, entity: EncryptedMessage) -> EncryptedMessage:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.createMessageBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedMessage._deserialize(result_info.success)
			return return_value

	async def create_message_in_topic_async(self, entity: EncryptedMessage) -> EncryptedMessage:
		def do_decode(raw_result):
			return EncryptedMessage._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.createMessageInTopicAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_message_in_topic_blocking(self, entity: EncryptedMessage) -> EncryptedMessage:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.createMessageInTopicBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedMessage._deserialize(result_info.success)
			return return_value

	async def undelete_message_async(self, message: Message) -> Message:
		def do_decode(raw_result):
			return deserialize_message(raw_result)
		payload = {
			"message": serialize_message(message),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.undeleteMessageAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_message_blocking(self, message: Message) -> Message:
		payload = {
			"message": serialize_message(message),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.undeleteMessageBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_message(result_info.success)
			return return_value

	async def modify_message_async(self, entity: EncryptedMessage) -> EncryptedMessage:
		def do_decode(raw_result):
			return EncryptedMessage._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.modifyMessageAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_message_blocking(self, entity: EncryptedMessage) -> EncryptedMessage:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.modifyMessageBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedMessage._deserialize(result_info.success)
			return return_value

	async def undelete_message_by_id_async(self, id: str, rev: str) -> EncryptedMessage:
		def do_decode(raw_result):
			return EncryptedMessage._deserialize(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.undeleteMessageByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_message_by_id_blocking(self, id: str, rev: str) -> EncryptedMessage:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.undeleteMessageByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedMessage._deserialize(result_info.success)
			return return_value

	async def get_message_async(self, entity_id: str) -> Optional[EncryptedMessage]:
		def do_decode(raw_result):
			return EncryptedMessage._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.getMessageAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_message_blocking(self, entity_id: str) -> Optional[EncryptedMessage]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.getMessageBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedMessage._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_messages_async(self, entity_ids: list[str]) -> list[EncryptedMessage]:
		def do_decode(raw_result):
			return [EncryptedMessage._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.getMessagesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_messages_blocking(self, entity_ids: list[str]) -> list[EncryptedMessage]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.getMessagesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedMessage._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def set_messages_read_status_async(self, entity_ids: list[str], time: Optional[int], read_status: bool, user_id: Optional[str]) -> list[EncryptedMessage]:
		def do_decode(raw_result):
			return [EncryptedMessage._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
			"time": time,
			"readStatus": read_status,
			"userId": user_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.setMessagesReadStatusAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def set_messages_read_status_blocking(self, entity_ids: list[str], time: Optional[int], read_status: bool, user_id: Optional[str]) -> list[EncryptedMessage]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
			"time": time,
			"readStatus": read_status,
			"userId": user_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.setMessagesReadStatusBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedMessage._deserialize(x1) for x1 in result_info.success]
			return return_value


class MessageApiTryAndRecover:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate_id: str, message: Message, options: Optional[MessageShareOptions] = None) -> Message:
		def do_decode(raw_result):
			return deserialize_message(raw_result)
		payload = {
			"delegateId": delegate_id,
			"message": serialize_message(message),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, message: Message, options: Optional[MessageShareOptions] = None) -> Message:
		payload = {
			"delegateId": delegate_id,
			"message": serialize_message(message),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_message(result_info.success)
			return return_value

	async def share_with_many_async(self, message: Message, delegates: dict[str, MessageShareOptions]) -> Message:
		def do_decode(raw_result):
			return deserialize_message(raw_result)
		payload = {
			"message": serialize_message(message),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, message: Message, delegates: dict[str, MessageShareOptions]) -> Message:
		payload = {
			"message": serialize_message(message),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_message(result_info.success)
			return return_value

	async def filter_messages_by_async(self, filter: FilterOptions[Message]) -> PaginatedListIterator[Message]:
		def do_decode(raw_result):
			return PaginatedListIterator[Message](
				producer = raw_result,
				deserializer = lambda x: deserialize_message(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.filterMessagesByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_messages_by_blocking(self, filter: FilterOptions[Message]) -> PaginatedListIterator[Message]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.filterMessagesByBlocking(
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
			return PaginatedListIterator[Message](
				producer = class_pointer,
				deserializer = lambda x: deserialize_message(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_messages_by_sorted_async(self, filter: SortableFilterOptions[Message]) -> PaginatedListIterator[Message]:
		def do_decode(raw_result):
			return PaginatedListIterator[Message](
				producer = raw_result,
				deserializer = lambda x: deserialize_message(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.filterMessagesBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_messages_by_sorted_blocking(self, filter: SortableFilterOptions[Message]) -> PaginatedListIterator[Message]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.filterMessagesBySortedBlocking(
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
			return PaginatedListIterator[Message](
				producer = class_pointer,
				deserializer = lambda x: deserialize_message(x),
				executor = self.cardinal_sdk._executor
			)

	async def create_message_async(self, entity: Message) -> Message:
		def do_decode(raw_result):
			return deserialize_message(raw_result)
		payload = {
			"entity": serialize_message(entity),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.createMessageAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_message_blocking(self, entity: Message) -> Message:
		payload = {
			"entity": serialize_message(entity),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.createMessageBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_message(result_info.success)
			return return_value

	async def create_message_in_topic_async(self, entity: Message) -> Message:
		def do_decode(raw_result):
			return deserialize_message(raw_result)
		payload = {
			"entity": serialize_message(entity),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.createMessageInTopicAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_message_in_topic_blocking(self, entity: Message) -> Message:
		payload = {
			"entity": serialize_message(entity),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.createMessageInTopicBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_message(result_info.success)
			return return_value

	async def undelete_message_async(self, message: Message) -> Message:
		def do_decode(raw_result):
			return deserialize_message(raw_result)
		payload = {
			"message": serialize_message(message),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.undeleteMessageAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_message_blocking(self, message: Message) -> Message:
		payload = {
			"message": serialize_message(message),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.undeleteMessageBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_message(result_info.success)
			return return_value

	async def modify_message_async(self, entity: Message) -> Message:
		def do_decode(raw_result):
			return deserialize_message(raw_result)
		payload = {
			"entity": serialize_message(entity),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.modifyMessageAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_message_blocking(self, entity: Message) -> Message:
		payload = {
			"entity": serialize_message(entity),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.modifyMessageBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_message(result_info.success)
			return return_value

	async def undelete_message_by_id_async(self, id: str, rev: str) -> Message:
		def do_decode(raw_result):
			return deserialize_message(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.undeleteMessageByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_message_by_id_blocking(self, id: str, rev: str) -> Message:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.undeleteMessageByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_message(result_info.success)
			return return_value

	async def get_message_async(self, entity_id: str) -> Optional[Message]:
		def do_decode(raw_result):
			return deserialize_message(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.getMessageAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_message_blocking(self, entity_id: str) -> Optional[Message]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.getMessageBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_message(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_messages_async(self, entity_ids: list[str]) -> list[Message]:
		def do_decode(raw_result):
			return [deserialize_message(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.getMessagesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_messages_blocking(self, entity_ids: list[str]) -> list[Message]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.getMessagesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_message(x1) for x1 in result_info.success]
			return return_value

	async def set_messages_read_status_async(self, entity_ids: list[str], time: Optional[int], read_status: bool, user_id: Optional[str]) -> list[Message]:
		def do_decode(raw_result):
			return [deserialize_message(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
			"time": time,
			"readStatus": read_status,
			"userId": user_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.setMessagesReadStatusAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def set_messages_read_status_blocking(self, entity_ids: list[str], time: Optional[int], read_status: bool, user_id: Optional[str]) -> list[Message]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
			"time": time,
			"readStatus": read_status,
			"userId": user_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.setMessagesReadStatusBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_message(x1) for x1 in result_info.success]
			return return_value
