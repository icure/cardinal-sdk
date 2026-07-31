from cardinal_sdk.model import DataOwnerType, DataOwnerWithTypeHcpDataOwner, DataOwnerWithTypePatientDataOwner

from cardinal_test_case import CardinalTestCase
from cardinal_test_env import primary_user


class SdkInitializationTest(CardinalTestCase):

	def test_logged_in_as_the_configured_user(self):
		user = self.sdk.user.get_current_user_blocking()
		self.assertEqual(primary_user().username, user.id)

	def test_current_user_is_a_data_owner(self):
		user = self.sdk.user.get_current_user_blocking()
		data_owner = self.sdk.data_owner.get_current_data_owner_blocking()
		self.assertEqual(self.data_owner_id, self.sdk.data_owner.get_current_data_owner_id_blocking())
		if isinstance(data_owner, DataOwnerWithTypeHcpDataOwner):
			self.assertEqual(user.healthcare_party_id, data_owner.data_owner.id)
		elif isinstance(data_owner, DataOwnerWithTypePatientDataOwner):
			self.assertEqual(user.patient_id, data_owner.data_owner.id)
		else:
			self.assertEqual(user.device_id, data_owner.data_owner.id)
		self.assertEqual(self.data_owner_id, data_owner.data_owner.id)

	def test_data_owner_has_an_available_key(self):
		"""The SDK either loaded a key from the storage or created a new one during initialization."""
		stub = self.sdk.data_owner.get_current_data_owner_stub_blocking()
		self.assertIn(stub.type, list(DataOwnerType))
		self.assertGreaterEqual(len(stub.stub.public_keys_for_oaep_with_sha256), 1)
		own_keys = self.sdk.crypto.current_data_owner_keys_blocking()
		self.assertGreaterEqual(len(own_keys.get(self.data_owner_id, {})), 1)

	async def test_async_methods_return_the_same_data_as_blocking_methods(self):
		self.assertEqual(
			self.sdk.user.get_current_user_blocking().id,
			(await self.sdk.user.get_current_user_async()).id,
		)
		self.assertEqual(
			self.data_owner_id,
			await self.sdk.data_owner.get_current_data_owner_id_async(),
		)
