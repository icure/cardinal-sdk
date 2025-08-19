# auto-generated file
import json
from typing import Optional
from cardinal_sdk.model import DecryptedHealthElement, Patient, User, AccessLevel, SecretIdUseOption, SecretIdUseOptionUseAnySharedWithParent, serialize_patient, serialize_secret_id_use_option, HealthElement, serialize_health_element, EntityReferenceInGroup, EncryptedHealthElement, deserialize_health_element, StoredDocumentIdentifier, HealthElementShareOptions, SubscriptionEventType, EntitySubscriptionConfiguration, GroupScoped
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.model.specializations import HexString
from cardinal_sdk.filters.FilterOptions import FilterOptions, SortableFilterOptions
from cardinal_sdk.pagination.PaginatedListIterator import PaginatedListIterator
from cardinal_sdk.subscription.EntitySubscription import EntitySubscription


class HealthElementApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk
		self.encrypted = HealthElementApiEncrypted(self.cardinal_sdk)
		self.try_and_recover = HealthElementApiTryAndRecover(self.cardinal_sdk)
		self.in_group = HealthElementApiInGroup(self.cardinal_sdk)

	async def with_encryption_metadata_async(self, base: Optional[DecryptedHealthElement], patient: Patient, user: Optional[User] = None, delegates: dict[str, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent(), alternate_root_delegate_id: Optional[str] = None) -> DecryptedHealthElement:
		def do_decode(raw_result):
			return DecryptedHealthElement._deserialize(raw_result)
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.withEncryptionMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def with_encryption_metadata_blocking(self, base: Optional[DecryptedHealthElement], patient: Patient, user: Optional[User] = None, delegates: dict[str, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent(), alternate_root_delegate_id: Optional[str] = None) -> DecryptedHealthElement:
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient),
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": serialize_secret_id_use_option(secret_id),
			"alternateRootDelegateId": alternate_root_delegate_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.withEncryptionMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedHealthElement._deserialize(result_info.success)
			return return_value

	async def get_encryption_keys_of_async(self, health_element: HealthElement) -> set[HexString]:
		def do_decode(raw_result):
			return {x1 for x1 in raw_result}
		payload = {
			"healthElement": serialize_health_element(health_element),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.getEncryptionKeysOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_encryption_keys_of_blocking(self, health_element: HealthElement) -> set[HexString]:
		payload = {
			"healthElement": serialize_health_element(health_element),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.getEncryptionKeysOfBlocking(
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

	async def has_write_access_async(self, health_element: HealthElement) -> bool:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"healthElement": serialize_health_element(health_element),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.hasWriteAccessAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def has_write_access_blocking(self, health_element: HealthElement) -> bool:
		payload = {
			"healthElement": serialize_health_element(health_element),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.hasWriteAccessBlocking(
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

	async def decrypt_patient_id_of_async(self, health_element: HealthElement) -> set[EntityReferenceInGroup]:
		def do_decode(raw_result):
			return {EntityReferenceInGroup._deserialize(x1) for x1 in raw_result}
		payload = {
			"healthElement": serialize_health_element(health_element),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.decryptPatientIdOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_patient_id_of_blocking(self, health_element: HealthElement) -> set[EntityReferenceInGroup]:
		payload = {
			"healthElement": serialize_health_element(health_element),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.decryptPatientIdOfBlocking(
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

	async def create_delegation_de_anonymization_metadata_async(self, entity: HealthElement, delegates: set[str]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"entity": serialize_health_element(entity),
			"delegates": [x0 for x0 in delegates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.createDelegationDeAnonymizationMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_delegation_de_anonymization_metadata_blocking(self, entity: HealthElement, delegates: set[str]) -> None:
		payload = {
			"entity": serialize_health_element(entity),
			"delegates": [x0 for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.createDelegationDeAnonymizationMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def decrypt_async(self, health_elements: list[EncryptedHealthElement]) -> list[DecryptedHealthElement]:
		def do_decode(raw_result):
			return [DecryptedHealthElement._deserialize(x1) for x1 in raw_result]
		payload = {
			"healthElements": [x0.__serialize__() for x0 in health_elements],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.decryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_blocking(self, health_elements: list[EncryptedHealthElement]) -> list[DecryptedHealthElement]:
		payload = {
			"healthElements": [x0.__serialize__() for x0 in health_elements],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.decryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedHealthElement._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def try_decrypt_async(self, health_elements: list[EncryptedHealthElement]) -> list[HealthElement]:
		def do_decode(raw_result):
			return [deserialize_health_element(x1) for x1 in raw_result]
		payload = {
			"healthElements": [x0.__serialize__() for x0 in health_elements],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.tryDecryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def try_decrypt_blocking(self, health_elements: list[EncryptedHealthElement]) -> list[HealthElement]:
		payload = {
			"healthElements": [x0.__serialize__() for x0 in health_elements],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.tryDecryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_health_element(x1) for x1 in result_info.success]
			return return_value

	async def encrypt_or_validate_async(self, health_elements: list[HealthElement]) -> list[EncryptedHealthElement]:
		def do_decode(raw_result):
			return [EncryptedHealthElement._deserialize(x1) for x1 in raw_result]
		payload = {
			"healthElements": [serialize_health_element(x0) for x0 in health_elements],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.encryptOrValidateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def encrypt_or_validate_blocking(self, health_elements: list[HealthElement]) -> list[EncryptedHealthElement]:
		payload = {
			"healthElements": [serialize_health_element(x0) for x0 in health_elements],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.encryptOrValidateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedHealthElement._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def match_health_elements_by_async(self, filter: FilterOptions[HealthElement]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.matchHealthElementsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_health_elements_by_blocking(self, filter: FilterOptions[HealthElement]) -> list[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.matchHealthElementsByBlocking(
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

	async def match_health_elements_by_sorted_async(self, filter: SortableFilterOptions[HealthElement]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.matchHealthElementsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_health_elements_by_sorted_blocking(self, filter: SortableFilterOptions[HealthElement]) -> list[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.matchHealthElementsBySortedBlocking(
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

	async def delete_health_element_by_id_async(self, entity_id: str, rev: str) -> StoredDocumentIdentifier:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.deleteHealthElementByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_health_element_by_id_blocking(self, entity_id: str, rev: str) -> StoredDocumentIdentifier:
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.deleteHealthElementByIdBlocking(
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

	async def delete_health_elements_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.deleteHealthElementsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_health_elements_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.deleteHealthElementsByIdsBlocking(
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

	async def purge_health_element_by_id_async(self, id: str, rev: str) -> None:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.purgeHealthElementByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_health_element_by_id_blocking(self, id: str, rev: str) -> None:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.purgeHealthElementByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def delete_health_element_async(self, health_element: HealthElement) -> StoredDocumentIdentifier:
		def do_decode(raw_result):
			return StoredDocumentIdentifier._deserialize(raw_result)
		payload = {
			"healthElement": serialize_health_element(health_element),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.deleteHealthElementAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_health_element_blocking(self, health_element: HealthElement) -> StoredDocumentIdentifier:
		payload = {
			"healthElement": serialize_health_element(health_element),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.deleteHealthElementBlocking(
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

	async def delete_health_elements_async(self, health_elements: list[HealthElement]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"healthElements": [serialize_health_element(x0) for x0 in health_elements],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.deleteHealthElementsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_health_elements_blocking(self, health_elements: list[HealthElement]) -> list[StoredDocumentIdentifier]:
		payload = {
			"healthElements": [serialize_health_element(x0) for x0 in health_elements],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.deleteHealthElementsBlocking(
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

	async def purge_health_element_async(self, health_element: HealthElement) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"healthElement": serialize_health_element(health_element),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.purgeHealthElementAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_health_element_blocking(self, health_element: HealthElement) -> None:
		payload = {
			"healthElement": serialize_health_element(health_element),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.purgeHealthElementBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def share_with_async(self, delegate_id: str, health_element: DecryptedHealthElement, options: Optional[HealthElementShareOptions] = None) -> DecryptedHealthElement:
		def do_decode(raw_result):
			return DecryptedHealthElement._deserialize(raw_result)
		payload = {
			"delegateId": delegate_id,
			"healthElement": health_element.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, health_element: DecryptedHealthElement, options: Optional[HealthElementShareOptions] = None) -> DecryptedHealthElement:
		payload = {
			"delegateId": delegate_id,
			"healthElement": health_element.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedHealthElement._deserialize(result_info.success)
			return return_value

	async def share_with_many_async(self, health_element: DecryptedHealthElement, delegates: dict[str, HealthElementShareOptions]) -> DecryptedHealthElement:
		def do_decode(raw_result):
			return DecryptedHealthElement._deserialize(raw_result)
		payload = {
			"healthElement": health_element.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, health_element: DecryptedHealthElement, delegates: dict[str, HealthElementShareOptions]) -> DecryptedHealthElement:
		payload = {
			"healthElement": health_element.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedHealthElement._deserialize(result_info.success)
			return return_value

	async def filter_health_elements_by_async(self, filter: FilterOptions[HealthElement]) -> PaginatedListIterator[DecryptedHealthElement]:
		def do_decode(raw_result):
			return PaginatedListIterator[DecryptedHealthElement](
				producer = raw_result,
				deserializer = lambda x: DecryptedHealthElement._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.filterHealthElementsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_health_elements_by_blocking(self, filter: FilterOptions[HealthElement]) -> PaginatedListIterator[DecryptedHealthElement]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.filterHealthElementsByBlocking(
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
			return PaginatedListIterator[DecryptedHealthElement](
				producer = class_pointer,
				deserializer = lambda x: DecryptedHealthElement._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_health_elements_by_sorted_async(self, filter: SortableFilterOptions[HealthElement]) -> PaginatedListIterator[DecryptedHealthElement]:
		def do_decode(raw_result):
			return PaginatedListIterator[DecryptedHealthElement](
				producer = raw_result,
				deserializer = lambda x: DecryptedHealthElement._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.filterHealthElementsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_health_elements_by_sorted_blocking(self, filter: SortableFilterOptions[HealthElement]) -> PaginatedListIterator[DecryptedHealthElement]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.filterHealthElementsBySortedBlocking(
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
			return PaginatedListIterator[DecryptedHealthElement](
				producer = class_pointer,
				deserializer = lambda x: DecryptedHealthElement._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def create_health_element_async(self, entity: DecryptedHealthElement) -> DecryptedHealthElement:
		def do_decode(raw_result):
			return DecryptedHealthElement._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.createHealthElementAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_health_element_blocking(self, entity: DecryptedHealthElement) -> DecryptedHealthElement:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.createHealthElementBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedHealthElement._deserialize(result_info.success)
			return return_value

	async def create_health_elements_async(self, entities: list[DecryptedHealthElement]) -> list[DecryptedHealthElement]:
		def do_decode(raw_result):
			return [DecryptedHealthElement._deserialize(x1) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.createHealthElementsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_health_elements_blocking(self, entities: list[DecryptedHealthElement]) -> list[DecryptedHealthElement]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.createHealthElementsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedHealthElement._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def undelete_health_element_by_id_async(self, id: str, rev: str) -> DecryptedHealthElement:
		def do_decode(raw_result):
			return DecryptedHealthElement._deserialize(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.undeleteHealthElementByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_health_element_by_id_blocking(self, id: str, rev: str) -> DecryptedHealthElement:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.undeleteHealthElementByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedHealthElement._deserialize(result_info.success)
			return return_value

	async def undelete_health_element_async(self, health_element: HealthElement) -> DecryptedHealthElement:
		def do_decode(raw_result):
			return DecryptedHealthElement._deserialize(raw_result)
		payload = {
			"healthElement": serialize_health_element(health_element),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.undeleteHealthElementAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_health_element_blocking(self, health_element: HealthElement) -> DecryptedHealthElement:
		payload = {
			"healthElement": serialize_health_element(health_element),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.undeleteHealthElementBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedHealthElement._deserialize(result_info.success)
			return return_value

	async def modify_health_element_async(self, entity: DecryptedHealthElement) -> DecryptedHealthElement:
		def do_decode(raw_result):
			return DecryptedHealthElement._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.modifyHealthElementAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_health_element_blocking(self, entity: DecryptedHealthElement) -> DecryptedHealthElement:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.modifyHealthElementBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedHealthElement._deserialize(result_info.success)
			return return_value

	async def modify_health_elements_async(self, entities: list[DecryptedHealthElement]) -> list[DecryptedHealthElement]:
		def do_decode(raw_result):
			return [DecryptedHealthElement._deserialize(x1) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.modifyHealthElementsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_health_elements_blocking(self, entities: list[DecryptedHealthElement]) -> list[DecryptedHealthElement]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.modifyHealthElementsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedHealthElement._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_health_element_async(self, entity_id: str) -> Optional[DecryptedHealthElement]:
		def do_decode(raw_result):
			return DecryptedHealthElement._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.getHealthElementAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_health_element_blocking(self, entity_id: str) -> Optional[DecryptedHealthElement]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.getHealthElementBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedHealthElement._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_health_elements_async(self, entity_ids: list[str]) -> list[DecryptedHealthElement]:
		def do_decode(raw_result):
			return [DecryptedHealthElement._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.getHealthElementsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_health_elements_blocking(self, entity_ids: list[str]) -> list[DecryptedHealthElement]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.getHealthElementsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedHealthElement._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def subscribe_to_events_async(self, events: set[SubscriptionEventType], filter: FilterOptions[HealthElement], subscription_config: Optional[EntitySubscriptionConfiguration] = None) -> EntitySubscription[EncryptedHealthElement]:
		def do_decode(raw_result):
			return EntitySubscription[EncryptedHealthElement](
				producer = raw_result,
				deserializer = lambda x: EncryptedHealthElement._deserialize(x),
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.subscribeToEventsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def subscribe_to_events_blocking(self, events: set[SubscriptionEventType], filter: FilterOptions[HealthElement], subscription_config: Optional[EntitySubscriptionConfiguration] = None) -> EntitySubscription[EncryptedHealthElement]:
		payload = {
			"events": [x0.__serialize__() for x0 in events],
			"filter": filter.__serialize__(),
			"subscriptionConfig": subscription_config.__serialize__() if subscription_config is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.subscribeToEventsBlocking(
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
			return EntitySubscription[EncryptedHealthElement](
				producer = class_pointer,
				deserializer = lambda x: EncryptedHealthElement._deserialize(x),
				executor = self.cardinal_sdk._executor
			)


class HealthElementApiEncrypted:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate_id: str, health_element: EncryptedHealthElement, options: Optional[HealthElementShareOptions] = None) -> EncryptedHealthElement:
		def do_decode(raw_result):
			return EncryptedHealthElement._deserialize(raw_result)
		payload = {
			"delegateId": delegate_id,
			"healthElement": health_element.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.encrypted.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, health_element: EncryptedHealthElement, options: Optional[HealthElementShareOptions] = None) -> EncryptedHealthElement:
		payload = {
			"delegateId": delegate_id,
			"healthElement": health_element.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.encrypted.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedHealthElement._deserialize(result_info.success)
			return return_value

	async def share_with_many_async(self, health_element: EncryptedHealthElement, delegates: dict[str, HealthElementShareOptions]) -> EncryptedHealthElement:
		def do_decode(raw_result):
			return EncryptedHealthElement._deserialize(raw_result)
		payload = {
			"healthElement": health_element.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.encrypted.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, health_element: EncryptedHealthElement, delegates: dict[str, HealthElementShareOptions]) -> EncryptedHealthElement:
		payload = {
			"healthElement": health_element.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.encrypted.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedHealthElement._deserialize(result_info.success)
			return return_value

	async def filter_health_elements_by_async(self, filter: FilterOptions[HealthElement]) -> PaginatedListIterator[EncryptedHealthElement]:
		def do_decode(raw_result):
			return PaginatedListIterator[EncryptedHealthElement](
				producer = raw_result,
				deserializer = lambda x: EncryptedHealthElement._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.encrypted.filterHealthElementsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_health_elements_by_blocking(self, filter: FilterOptions[HealthElement]) -> PaginatedListIterator[EncryptedHealthElement]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.encrypted.filterHealthElementsByBlocking(
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
			return PaginatedListIterator[EncryptedHealthElement](
				producer = class_pointer,
				deserializer = lambda x: EncryptedHealthElement._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_health_elements_by_sorted_async(self, filter: SortableFilterOptions[HealthElement]) -> PaginatedListIterator[EncryptedHealthElement]:
		def do_decode(raw_result):
			return PaginatedListIterator[EncryptedHealthElement](
				producer = raw_result,
				deserializer = lambda x: EncryptedHealthElement._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.encrypted.filterHealthElementsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_health_elements_by_sorted_blocking(self, filter: SortableFilterOptions[HealthElement]) -> PaginatedListIterator[EncryptedHealthElement]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.encrypted.filterHealthElementsBySortedBlocking(
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
			return PaginatedListIterator[EncryptedHealthElement](
				producer = class_pointer,
				deserializer = lambda x: EncryptedHealthElement._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def create_health_element_async(self, entity: EncryptedHealthElement) -> EncryptedHealthElement:
		def do_decode(raw_result):
			return EncryptedHealthElement._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.encrypted.createHealthElementAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_health_element_blocking(self, entity: EncryptedHealthElement) -> EncryptedHealthElement:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.encrypted.createHealthElementBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedHealthElement._deserialize(result_info.success)
			return return_value

	async def create_health_elements_async(self, entities: list[EncryptedHealthElement]) -> list[EncryptedHealthElement]:
		def do_decode(raw_result):
			return [EncryptedHealthElement._deserialize(x1) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.encrypted.createHealthElementsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_health_elements_blocking(self, entities: list[EncryptedHealthElement]) -> list[EncryptedHealthElement]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.encrypted.createHealthElementsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedHealthElement._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def undelete_health_element_by_id_async(self, id: str, rev: str) -> EncryptedHealthElement:
		def do_decode(raw_result):
			return EncryptedHealthElement._deserialize(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.encrypted.undeleteHealthElementByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_health_element_by_id_blocking(self, id: str, rev: str) -> EncryptedHealthElement:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.encrypted.undeleteHealthElementByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedHealthElement._deserialize(result_info.success)
			return return_value

	async def undelete_health_element_async(self, health_element: HealthElement) -> EncryptedHealthElement:
		def do_decode(raw_result):
			return EncryptedHealthElement._deserialize(raw_result)
		payload = {
			"healthElement": serialize_health_element(health_element),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.encrypted.undeleteHealthElementAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_health_element_blocking(self, health_element: HealthElement) -> EncryptedHealthElement:
		payload = {
			"healthElement": serialize_health_element(health_element),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.encrypted.undeleteHealthElementBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedHealthElement._deserialize(result_info.success)
			return return_value

	async def modify_health_element_async(self, entity: EncryptedHealthElement) -> EncryptedHealthElement:
		def do_decode(raw_result):
			return EncryptedHealthElement._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.encrypted.modifyHealthElementAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_health_element_blocking(self, entity: EncryptedHealthElement) -> EncryptedHealthElement:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.encrypted.modifyHealthElementBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedHealthElement._deserialize(result_info.success)
			return return_value

	async def modify_health_elements_async(self, entities: list[EncryptedHealthElement]) -> list[EncryptedHealthElement]:
		def do_decode(raw_result):
			return [EncryptedHealthElement._deserialize(x1) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.encrypted.modifyHealthElementsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_health_elements_blocking(self, entities: list[EncryptedHealthElement]) -> list[EncryptedHealthElement]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.encrypted.modifyHealthElementsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedHealthElement._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_health_element_async(self, entity_id: str) -> Optional[EncryptedHealthElement]:
		def do_decode(raw_result):
			return EncryptedHealthElement._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.encrypted.getHealthElementAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_health_element_blocking(self, entity_id: str) -> Optional[EncryptedHealthElement]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.encrypted.getHealthElementBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedHealthElement._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_health_elements_async(self, entity_ids: list[str]) -> list[EncryptedHealthElement]:
		def do_decode(raw_result):
			return [EncryptedHealthElement._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.encrypted.getHealthElementsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_health_elements_blocking(self, entity_ids: list[str]) -> list[EncryptedHealthElement]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.encrypted.getHealthElementsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedHealthElement._deserialize(x1) for x1 in result_info.success]
			return return_value


class HealthElementApiTryAndRecover:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate_id: str, health_element: HealthElement, options: Optional[HealthElementShareOptions] = None) -> HealthElement:
		def do_decode(raw_result):
			return deserialize_health_element(raw_result)
		payload = {
			"delegateId": delegate_id,
			"healthElement": serialize_health_element(health_element),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.tryAndRecover.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, health_element: HealthElement, options: Optional[HealthElementShareOptions] = None) -> HealthElement:
		payload = {
			"delegateId": delegate_id,
			"healthElement": serialize_health_element(health_element),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.tryAndRecover.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_health_element(result_info.success)
			return return_value

	async def share_with_many_async(self, health_element: HealthElement, delegates: dict[str, HealthElementShareOptions]) -> HealthElement:
		def do_decode(raw_result):
			return deserialize_health_element(raw_result)
		payload = {
			"healthElement": serialize_health_element(health_element),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.tryAndRecover.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, health_element: HealthElement, delegates: dict[str, HealthElementShareOptions]) -> HealthElement:
		payload = {
			"healthElement": serialize_health_element(health_element),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.tryAndRecover.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_health_element(result_info.success)
			return return_value

	async def filter_health_elements_by_async(self, filter: FilterOptions[HealthElement]) -> PaginatedListIterator[HealthElement]:
		def do_decode(raw_result):
			return PaginatedListIterator[HealthElement](
				producer = raw_result,
				deserializer = lambda x: deserialize_health_element(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.tryAndRecover.filterHealthElementsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_health_elements_by_blocking(self, filter: FilterOptions[HealthElement]) -> PaginatedListIterator[HealthElement]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.tryAndRecover.filterHealthElementsByBlocking(
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
			return PaginatedListIterator[HealthElement](
				producer = class_pointer,
				deserializer = lambda x: deserialize_health_element(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_health_elements_by_sorted_async(self, filter: SortableFilterOptions[HealthElement]) -> PaginatedListIterator[HealthElement]:
		def do_decode(raw_result):
			return PaginatedListIterator[HealthElement](
				producer = raw_result,
				deserializer = lambda x: deserialize_health_element(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.tryAndRecover.filterHealthElementsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_health_elements_by_sorted_blocking(self, filter: SortableFilterOptions[HealthElement]) -> PaginatedListIterator[HealthElement]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.tryAndRecover.filterHealthElementsBySortedBlocking(
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
			return PaginatedListIterator[HealthElement](
				producer = class_pointer,
				deserializer = lambda x: deserialize_health_element(x),
				executor = self.cardinal_sdk._executor
			)

	async def create_health_element_async(self, entity: HealthElement) -> HealthElement:
		def do_decode(raw_result):
			return deserialize_health_element(raw_result)
		payload = {
			"entity": serialize_health_element(entity),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.tryAndRecover.createHealthElementAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_health_element_blocking(self, entity: HealthElement) -> HealthElement:
		payload = {
			"entity": serialize_health_element(entity),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.tryAndRecover.createHealthElementBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_health_element(result_info.success)
			return return_value

	async def create_health_elements_async(self, entities: list[HealthElement]) -> list[HealthElement]:
		def do_decode(raw_result):
			return [deserialize_health_element(x1) for x1 in raw_result]
		payload = {
			"entities": [serialize_health_element(x0) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.tryAndRecover.createHealthElementsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_health_elements_blocking(self, entities: list[HealthElement]) -> list[HealthElement]:
		payload = {
			"entities": [serialize_health_element(x0) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.tryAndRecover.createHealthElementsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_health_element(x1) for x1 in result_info.success]
			return return_value

	async def undelete_health_element_by_id_async(self, id: str, rev: str) -> HealthElement:
		def do_decode(raw_result):
			return deserialize_health_element(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.tryAndRecover.undeleteHealthElementByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_health_element_by_id_blocking(self, id: str, rev: str) -> HealthElement:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.tryAndRecover.undeleteHealthElementByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_health_element(result_info.success)
			return return_value

	async def undelete_health_element_async(self, health_element: HealthElement) -> HealthElement:
		def do_decode(raw_result):
			return deserialize_health_element(raw_result)
		payload = {
			"healthElement": serialize_health_element(health_element),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.tryAndRecover.undeleteHealthElementAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_health_element_blocking(self, health_element: HealthElement) -> HealthElement:
		payload = {
			"healthElement": serialize_health_element(health_element),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.tryAndRecover.undeleteHealthElementBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_health_element(result_info.success)
			return return_value

	async def modify_health_element_async(self, entity: HealthElement) -> HealthElement:
		def do_decode(raw_result):
			return deserialize_health_element(raw_result)
		payload = {
			"entity": serialize_health_element(entity),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.tryAndRecover.modifyHealthElementAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_health_element_blocking(self, entity: HealthElement) -> HealthElement:
		payload = {
			"entity": serialize_health_element(entity),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.tryAndRecover.modifyHealthElementBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_health_element(result_info.success)
			return return_value

	async def modify_health_elements_async(self, entities: list[HealthElement]) -> list[HealthElement]:
		def do_decode(raw_result):
			return [deserialize_health_element(x1) for x1 in raw_result]
		payload = {
			"entities": [serialize_health_element(x0) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.tryAndRecover.modifyHealthElementsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_health_elements_blocking(self, entities: list[HealthElement]) -> list[HealthElement]:
		payload = {
			"entities": [serialize_health_element(x0) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.tryAndRecover.modifyHealthElementsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_health_element(x1) for x1 in result_info.success]
			return return_value

	async def get_health_element_async(self, entity_id: str) -> Optional[HealthElement]:
		def do_decode(raw_result):
			return deserialize_health_element(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.tryAndRecover.getHealthElementAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_health_element_blocking(self, entity_id: str) -> Optional[HealthElement]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.tryAndRecover.getHealthElementBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_health_element(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_health_elements_async(self, entity_ids: list[str]) -> list[HealthElement]:
		def do_decode(raw_result):
			return [deserialize_health_element(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.tryAndRecover.getHealthElementsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_health_elements_blocking(self, entity_ids: list[str]) -> list[HealthElement]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.tryAndRecover.getHealthElementsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_health_element(x1) for x1 in result_info.success]
			return return_value


class HealthElementApiInGroup:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk
		self.encrypted = HealthElementApiInGroupEncrypted(self.cardinal_sdk)
		self.try_and_recover = HealthElementApiInGroupTryAndRecover(self.cardinal_sdk)

	async def with_encryption_metadata_async(self, entity_group_id: str, base: Optional[DecryptedHealthElement], patient: GroupScoped[Patient], user: Optional[User] = None, delegates: dict[EntityReferenceInGroup, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent(), alternate_root_delegate_reference: Optional[EntityReferenceInGroup] = None) -> GroupScoped[DecryptedHealthElement]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedHealthElement._deserialize(x1))
		payload = {
			"entityGroupId": entity_group_id,
			"base": base.__serialize__() if base is not None else None,
			"patient": patient.__serialize__(lambda x0: serialize_patient(x0)),
			"user": user.__serialize__() if user is not None else None,
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
			"secretId": serialize_secret_id_use_option(secret_id),
			"alternateRootDelegateReference": alternate_root_delegate_reference.__serialize__() if alternate_root_delegate_reference is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.withEncryptionMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def with_encryption_metadata_blocking(self, entity_group_id: str, base: Optional[DecryptedHealthElement], patient: GroupScoped[Patient], user: Optional[User] = None, delegates: dict[EntityReferenceInGroup, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent(), alternate_root_delegate_reference: Optional[EntityReferenceInGroup] = None) -> GroupScoped[DecryptedHealthElement]:
		payload = {
			"entityGroupId": entity_group_id,
			"base": base.__serialize__() if base is not None else None,
			"patient": patient.__serialize__(lambda x0: serialize_patient(x0)),
			"user": user.__serialize__() if user is not None else None,
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
			"secretId": serialize_secret_id_use_option(secret_id),
			"alternateRootDelegateReference": alternate_root_delegate_reference.__serialize__() if alternate_root_delegate_reference is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.withEncryptionMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedHealthElement._deserialize(x1))
			return return_value

	async def get_encryption_keys_of_async(self, health_element: GroupScoped[HealthElement]) -> set[HexString]:
		def do_decode(raw_result):
			return {x1 for x1 in raw_result}
		payload = {
			"healthElement": health_element.__serialize__(lambda x0: serialize_health_element(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.getEncryptionKeysOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_encryption_keys_of_blocking(self, health_element: GroupScoped[HealthElement]) -> set[HexString]:
		payload = {
			"healthElement": health_element.__serialize__(lambda x0: serialize_health_element(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.getEncryptionKeysOfBlocking(
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

	async def has_write_access_async(self, health_element: GroupScoped[HealthElement]) -> bool:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"healthElement": health_element.__serialize__(lambda x0: serialize_health_element(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.hasWriteAccessAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def has_write_access_blocking(self, health_element: GroupScoped[HealthElement]) -> bool:
		payload = {
			"healthElement": health_element.__serialize__(lambda x0: serialize_health_element(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.hasWriteAccessBlocking(
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

	async def decrypt_patient_id_of_async(self, health_element: GroupScoped[HealthElement]) -> set[EntityReferenceInGroup]:
		def do_decode(raw_result):
			return {EntityReferenceInGroup._deserialize(x1) for x1 in raw_result}
		payload = {
			"healthElement": health_element.__serialize__(lambda x0: serialize_health_element(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.decryptPatientIdOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_patient_id_of_blocking(self, health_element: GroupScoped[HealthElement]) -> set[EntityReferenceInGroup]:
		payload = {
			"healthElement": health_element.__serialize__(lambda x0: serialize_health_element(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.decryptPatientIdOfBlocking(
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

	async def create_delegation_de_anonymization_metadata_async(self, entity: GroupScoped[HealthElement], delegates: set[EntityReferenceInGroup]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_health_element(x0)),
			"delegates": [x0.__serialize__() for x0 in delegates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.createDelegationDeAnonymizationMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_delegation_de_anonymization_metadata_blocking(self, entity: GroupScoped[HealthElement], delegates: set[EntityReferenceInGroup]) -> None:
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_health_element(x0)),
			"delegates": [x0.__serialize__() for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.createDelegationDeAnonymizationMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def decrypt_async(self, health_elements: list[GroupScoped[EncryptedHealthElement]]) -> list[GroupScoped[DecryptedHealthElement]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: DecryptedHealthElement._deserialize(x2)) for x1 in raw_result]
		payload = {
			"healthElements": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in health_elements],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.decryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_blocking(self, health_elements: list[GroupScoped[EncryptedHealthElement]]) -> list[GroupScoped[DecryptedHealthElement]]:
		payload = {
			"healthElements": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in health_elements],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.decryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: DecryptedHealthElement._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def try_decrypt_async(self, health_elements: list[GroupScoped[EncryptedHealthElement]]) -> list[GroupScoped[HealthElement]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: deserialize_health_element(x2)) for x1 in raw_result]
		payload = {
			"healthElements": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in health_elements],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.tryDecryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def try_decrypt_blocking(self, health_elements: list[GroupScoped[EncryptedHealthElement]]) -> list[GroupScoped[HealthElement]]:
		payload = {
			"healthElements": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in health_elements],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.tryDecryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: deserialize_health_element(x2)) for x1 in result_info.success]
			return return_value

	async def encrypt_or_validate_async(self, health_elements: list[GroupScoped[HealthElement]]) -> list[GroupScoped[EncryptedHealthElement]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: EncryptedHealthElement._deserialize(x2)) for x1 in raw_result]
		payload = {
			"healthElements": [x0.__serialize__(lambda x1: serialize_health_element(x1)) for x0 in health_elements],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.encryptOrValidateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def encrypt_or_validate_blocking(self, health_elements: list[GroupScoped[HealthElement]]) -> list[GroupScoped[EncryptedHealthElement]]:
		payload = {
			"healthElements": [x0.__serialize__(lambda x1: serialize_health_element(x1)) for x0 in health_elements],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.encryptOrValidateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: EncryptedHealthElement._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def share_with_async(self, delegate: EntityReferenceInGroup, health_element: GroupScoped[DecryptedHealthElement], options: Optional[HealthElementShareOptions] = None) -> GroupScoped[DecryptedHealthElement]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedHealthElement._deserialize(x1))
		payload = {
			"delegate": delegate.__serialize__(),
			"healthElement": health_element.__serialize__(lambda x0: x0.__serialize__()),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate: EntityReferenceInGroup, health_element: GroupScoped[DecryptedHealthElement], options: Optional[HealthElementShareOptions] = None) -> GroupScoped[DecryptedHealthElement]:
		payload = {
			"delegate": delegate.__serialize__(),
			"healthElement": health_element.__serialize__(lambda x0: x0.__serialize__()),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedHealthElement._deserialize(x1))
			return return_value

	async def share_with_many_async(self, health_element: GroupScoped[DecryptedHealthElement], delegates: dict[EntityReferenceInGroup, HealthElementShareOptions]) -> GroupScoped[DecryptedHealthElement]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedHealthElement._deserialize(x1))
		payload = {
			"healthElement": health_element.__serialize__(lambda x0: x0.__serialize__()),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, health_element: GroupScoped[DecryptedHealthElement], delegates: dict[EntityReferenceInGroup, HealthElementShareOptions]) -> GroupScoped[DecryptedHealthElement]:
		payload = {
			"healthElement": health_element.__serialize__(lambda x0: x0.__serialize__()),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedHealthElement._deserialize(x1))
			return return_value

	async def create_health_element_async(self, entity: GroupScoped[DecryptedHealthElement]) -> GroupScoped[DecryptedHealthElement]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedHealthElement._deserialize(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.createHealthElementAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_health_element_blocking(self, entity: GroupScoped[DecryptedHealthElement]) -> GroupScoped[DecryptedHealthElement]:
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.createHealthElementBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedHealthElement._deserialize(x1))
			return return_value

	async def modify_health_element_async(self, entity: GroupScoped[DecryptedHealthElement]) -> GroupScoped[DecryptedHealthElement]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedHealthElement._deserialize(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.modifyHealthElementAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_health_element_blocking(self, entity: GroupScoped[DecryptedHealthElement]) -> GroupScoped[DecryptedHealthElement]:
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.modifyHealthElementBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedHealthElement._deserialize(x1))
			return return_value

	async def get_health_element_async(self, group_id: str, entity_id: str) -> Optional[GroupScoped[DecryptedHealthElement]]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedHealthElement._deserialize(x1)) if raw_result is not None else None
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.getHealthElementAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_health_element_blocking(self, group_id: str, entity_id: str) -> Optional[GroupScoped[DecryptedHealthElement]]:
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.getHealthElementBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedHealthElement._deserialize(x1)) if result_info.success is not None else None
			return return_value


class HealthElementApiInGroupEncrypted:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate: EntityReferenceInGroup, health_element: GroupScoped[EncryptedHealthElement], options: Optional[HealthElementShareOptions] = None) -> GroupScoped[EncryptedHealthElement]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedHealthElement._deserialize(x1))
		payload = {
			"delegate": delegate.__serialize__(),
			"healthElement": health_element.__serialize__(lambda x0: x0.__serialize__()),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.encrypted.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate: EntityReferenceInGroup, health_element: GroupScoped[EncryptedHealthElement], options: Optional[HealthElementShareOptions] = None) -> GroupScoped[EncryptedHealthElement]:
		payload = {
			"delegate": delegate.__serialize__(),
			"healthElement": health_element.__serialize__(lambda x0: x0.__serialize__()),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.encrypted.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedHealthElement._deserialize(x1))
			return return_value

	async def share_with_many_async(self, health_element: GroupScoped[EncryptedHealthElement], delegates: dict[EntityReferenceInGroup, HealthElementShareOptions]) -> GroupScoped[EncryptedHealthElement]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedHealthElement._deserialize(x1))
		payload = {
			"healthElement": health_element.__serialize__(lambda x0: x0.__serialize__()),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.encrypted.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, health_element: GroupScoped[EncryptedHealthElement], delegates: dict[EntityReferenceInGroup, HealthElementShareOptions]) -> GroupScoped[EncryptedHealthElement]:
		payload = {
			"healthElement": health_element.__serialize__(lambda x0: x0.__serialize__()),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.encrypted.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedHealthElement._deserialize(x1))
			return return_value

	async def create_health_element_async(self, entity: GroupScoped[EncryptedHealthElement]) -> GroupScoped[EncryptedHealthElement]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedHealthElement._deserialize(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.encrypted.createHealthElementAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_health_element_blocking(self, entity: GroupScoped[EncryptedHealthElement]) -> GroupScoped[EncryptedHealthElement]:
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.encrypted.createHealthElementBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedHealthElement._deserialize(x1))
			return return_value

	async def modify_health_element_async(self, entity: GroupScoped[EncryptedHealthElement]) -> GroupScoped[EncryptedHealthElement]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedHealthElement._deserialize(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.encrypted.modifyHealthElementAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_health_element_blocking(self, entity: GroupScoped[EncryptedHealthElement]) -> GroupScoped[EncryptedHealthElement]:
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.encrypted.modifyHealthElementBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedHealthElement._deserialize(x1))
			return return_value

	async def get_health_element_async(self, group_id: str, entity_id: str) -> Optional[GroupScoped[EncryptedHealthElement]]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedHealthElement._deserialize(x1)) if raw_result is not None else None
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.encrypted.getHealthElementAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_health_element_blocking(self, group_id: str, entity_id: str) -> Optional[GroupScoped[EncryptedHealthElement]]:
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.encrypted.getHealthElementBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedHealthElement._deserialize(x1)) if result_info.success is not None else None
			return return_value


class HealthElementApiInGroupTryAndRecover:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate: EntityReferenceInGroup, health_element: GroupScoped[HealthElement], options: Optional[HealthElementShareOptions] = None) -> GroupScoped[HealthElement]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_health_element(x1))
		payload = {
			"delegate": delegate.__serialize__(),
			"healthElement": health_element.__serialize__(lambda x0: serialize_health_element(x0)),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.tryAndRecover.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate: EntityReferenceInGroup, health_element: GroupScoped[HealthElement], options: Optional[HealthElementShareOptions] = None) -> GroupScoped[HealthElement]:
		payload = {
			"delegate": delegate.__serialize__(),
			"healthElement": health_element.__serialize__(lambda x0: serialize_health_element(x0)),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.tryAndRecover.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_health_element(x1))
			return return_value

	async def share_with_many_async(self, health_element: GroupScoped[HealthElement], delegates: dict[EntityReferenceInGroup, HealthElementShareOptions]) -> GroupScoped[HealthElement]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_health_element(x1))
		payload = {
			"healthElement": health_element.__serialize__(lambda x0: serialize_health_element(x0)),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.tryAndRecover.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, health_element: GroupScoped[HealthElement], delegates: dict[EntityReferenceInGroup, HealthElementShareOptions]) -> GroupScoped[HealthElement]:
		payload = {
			"healthElement": health_element.__serialize__(lambda x0: serialize_health_element(x0)),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.tryAndRecover.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_health_element(x1))
			return return_value

	async def create_health_element_async(self, entity: GroupScoped[HealthElement]) -> GroupScoped[HealthElement]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_health_element(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_health_element(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.tryAndRecover.createHealthElementAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_health_element_blocking(self, entity: GroupScoped[HealthElement]) -> GroupScoped[HealthElement]:
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_health_element(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.tryAndRecover.createHealthElementBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_health_element(x1))
			return return_value

	async def modify_health_element_async(self, entity: GroupScoped[HealthElement]) -> GroupScoped[HealthElement]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_health_element(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_health_element(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.tryAndRecover.modifyHealthElementAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_health_element_blocking(self, entity: GroupScoped[HealthElement]) -> GroupScoped[HealthElement]:
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_health_element(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.tryAndRecover.modifyHealthElementBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_health_element(x1))
			return return_value

	async def get_health_element_async(self, group_id: str, entity_id: str) -> Optional[GroupScoped[HealthElement]]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_health_element(x1)) if raw_result is not None else None
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.tryAndRecover.getHealthElementAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_health_element_blocking(self, group_id: str, entity_id: str) -> Optional[GroupScoped[HealthElement]]:
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.HealthElementApi.inGroup.tryAndRecover.getHealthElementBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_health_element(x1)) if result_info.success is not None else None
			return return_value
