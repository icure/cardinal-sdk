"""
Tests involving two distinct data owners: they need `CARDINAL_USER_2_*` to be configured, and are
skipped otherwise.
"""
import unittest

from cardinal_sdk import CardinalSdk
from cardinal_sdk.model import ShareAllPatientDataOptionsTag

from cardinal_test_case import CardinalTestCase
from cardinal_test_env import SECONDARY_USER_PREFIX, sdk_for, secondary_user

_secondary_user = secondary_user()


@unittest.skipIf(
	_secondary_user is None,
	f"{SECONDARY_USER_PREFIX}_USERNAME is not set, skipping the tests that need a second data owner",
)
class SharingTest(CardinalTestCase):

	delegate_sdk: CardinalSdk
	delegate_id: str

	@classmethod
	def setUpClass(cls) -> None:
		super().setUpClass()
		cls.delegate_sdk = sdk_for(_secondary_user)
		cls.delegate_id = cls.delegate_sdk.data_owner.get_current_data_owner_id_blocking()
		if cls.delegate_id == cls.data_owner_id:
			raise unittest.SkipTest(
				f"{SECONDARY_USER_PREFIX} is the same data owner as the primary user"
			)

	def test_data_of_the_primary_user_is_not_readable_by_the_delegate(self):
		created = self.create_health_element(self.create_patient(), "Not shared diagnosis")
		try:
			as_encrypted = self.delegate_sdk.health_element.encrypted.get_health_element_blocking(created.id)
		except Exception:
			return  # The delegate has no access at all to the entity, which is enough.
		self.assertIsNotNone(as_encrypted)
		with self.assertRaises(Exception):
			self.delegate_sdk.health_element.decrypt_blocking([as_encrypted])

	def test_share_health_element_with_the_delegate(self):
		created = self.create_health_element(self.create_patient(), "Shared diagnosis")

		shared = self.sdk.health_element.share_with_blocking(self.delegate_id, created)
		self.assertDelegate(self.delegate_id, shared.security_metadata)

		retrieved_by_delegate = self.delegate_sdk.health_element.get_health_element_blocking(created.id)
		self.assertIsNotNone(retrieved_by_delegate)
		self.assertEqual("Shared diagnosis", retrieved_by_delegate.descr)

	def test_share_patient_with_the_delegate(self):
		created = self.create_patient(note="Shared note")

		shared = self.sdk.patient.share_with_blocking(self.delegate_id, created)
		self.assertDelegate(self.delegate_id, shared.security_metadata)

		retrieved_by_delegate = self.delegate_sdk.patient.get_patient_blocking(created.id)
		self.assertIsNotNone(retrieved_by_delegate)
		self.assertEqual("Shared note", retrieved_by_delegate.note)

	def test_share_all_data_of_patient(self):
		patient = self.create_patient()
		health_element = self.create_health_element(patient, "Bulk shared diagnosis")

		result = self.sdk.patient.share_all_data_of_patient_blocking(
			patient.id,
			{self.delegate_id: {ShareAllPatientDataOptionsTag.All}},
		)
		self.assertEqual(patient.id, result.patient.id)

		retrieved_by_delegate = self.delegate_sdk.health_element.get_health_element_blocking(health_element.id)
		self.assertIsNotNone(retrieved_by_delegate)
		self.assertEqual("Bulk shared diagnosis", retrieved_by_delegate.descr)

	async def test_share_health_element_async(self):
		created = self.create_health_element(self.create_patient(), "Async shared diagnosis")
		await self.sdk.health_element.share_with_async(self.delegate_id, created)
		retrieved = await self.delegate_sdk.health_element.get_health_element_async(created.id)
		self.assertIsNotNone(retrieved)
		self.assertEqual("Async shared diagnosis", retrieved.descr)
