from cardinal_sdk.filters import HealthElementFilters
from cardinal_sdk.model import DecryptedHealthElement

from cardinal_test_case import CardinalTestCase, delete_health_element_quietly
from cardinal_test_env import new_uuid


class HealthElementTest(CardinalTestCase):

	def test_create_health_element_for_patient(self):
		patient = self.create_patient()
		created = self.create_health_element(patient, "Some diagnosis")
		self.assertIsNotNone(created.rev)
		self.assertEqual("Some diagnosis", created.descr)
		self.assertEqual(1, len(created.secret_foreign_keys))

		secret_ids = self.sdk.patient.get_secret_ids_of_blocking(patient)
		self.assertTrue(created.secret_foreign_keys.issubset(secret_ids.keys()))

	def test_encrypted_fields_are_not_stored_in_clear(self):
		created = self.create_health_element(self.create_patient(), "Sensitive diagnosis")
		as_encrypted = self.sdk.health_element.encrypted.get_health_element_blocking(created.id)
		self.assertIsNotNone(as_encrypted)
		self.assertIsNone(as_encrypted.descr, "`descr` is an encrypted field, it must not be stored in clear")
		self.assertIsNotNone(as_encrypted.encrypted_self)

		decrypted = self.sdk.health_element.decrypt_blocking([as_encrypted])
		self.assertEqual("Sensitive diagnosis", decrypted[0].descr)

	def test_modify_health_element(self):
		created = self.create_health_element(self.create_patient())
		created.descr = "Updated diagnosis"
		modified = self.sdk.health_element.modify_health_element_blocking(created)
		self.assertNotEqual(created.rev, modified.rev)
		self.assertEqual("Updated diagnosis", modified.descr)
		self.assertEqual("Updated diagnosis", self.sdk.health_element.get_health_element_blocking(created.id).descr)

	def test_filter_health_elements_by_patient(self):
		patient = self.create_patient()
		created_ids = {self.create_health_element(patient, f"Diagnosis {i}").id for i in range(3)}

		iterator = self.sdk.health_element.filter_health_elements_by_blocking(
			HealthElementFilters.by_patients_for_self([patient]),
		)
		found = []
		while iterator.has_next_blocking():
			found.extend(iterator.next_blocking(10))

		self.assertEqual(created_ids, {health_element.id for health_element in found})
		for health_element in found:
			self.assertIsNotNone(health_element.descr)

	def test_filter_health_elements_by_patient_secret_ids(self):
		patient = self.create_patient()
		created = self.create_health_element(patient)
		secret_ids = list(self.sdk.patient.get_secret_ids_of_blocking(patient).keys())

		matched = self.sdk.health_element.match_health_elements_by_blocking(
			HealthElementFilters.by_patients_secret_ids_for_self(secret_ids),
		)
		self.assertEqual([created.id], matched)

	async def test_create_and_get_health_element_async(self):
		patient = self.create_patient()
		with_metadata = await self.sdk.health_element.with_encryption_metadata_async(
			DecryptedHealthElement(id=new_uuid(), descr="Async diagnosis"),
			patient,
		)
		created = await self.sdk.health_element.create_health_element_async(with_metadata)
		self.addCleanup(delete_health_element_quietly, self.sdk, created.id)
		retrieved = await self.sdk.health_element.get_health_element_async(created.id)
		self.assertEqual(created.id, retrieved.id)
		self.assertEqual("Async diagnosis", retrieved.descr)
