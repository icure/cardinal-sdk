"""
Configuration of the test environment.

Everything the tests need to log in comes from environment variables (secrets on the CI): the tests
run against an already existing environment, with already existing users, and never create groups
or users themselves.
"""
import os
import re
import uuid
from dataclasses import dataclass
from typing import Optional

from cardinal_sdk import CardinalSdk
from cardinal_sdk.authentication.AuthenticationMethod import AuthenticationMethod, UsernameLongToken, UsernamePassword
from cardinal_sdk.storage.StorageFacadeOptions import FileSystemStorage

ENV_URL = "CARDINAL_URL"
ENV_KEYS_DIR = "CARDINAL_KEYS_DIR"

DEFAULT_KEYS_DIR = "keys"


@dataclass
class UserCredentials:
	"""Credentials of a data owner user of the test environment."""
	username: str
	password: Optional[str] = None
	token: Optional[str] = None

	def authentication_method(self) -> AuthenticationMethod:
		if self.token is not None:
			return UsernameLongToken(self.username, self.token)
		if self.password is not None:
			return UsernamePassword(self.username, self.password)
		raise ValueError(f"No password nor long token configured for {self.username}")


def new_uuid() -> str:
	return str(uuid.uuid4())


def cardinal_url() -> str:
	url = os.environ.get(ENV_URL)
	if not url:
		raise EnvironmentError(f"{ENV_URL} is not set")
	return url


def credentials(prefix: str) -> Optional[UserCredentials]:
	"""
	Reads the credentials of a user from `<PREFIX>_USERNAME` and `<PREFIX>_PASSWORD` or
	`<PREFIX>_TOKEN`, returning None if no username is configured.
	"""
	username = os.environ.get(f"{prefix}_USERNAME")
	if not username:
		return None
	password = os.environ.get(f"{prefix}_PASSWORD") or None
	token = os.environ.get(f"{prefix}_TOKEN") or None
	if password is None and token is None:
		raise EnvironmentError(f"Neither {prefix}_PASSWORD nor {prefix}_TOKEN is set")
	return UserCredentials(username=username, password=password, token=token)


def keys_directory(username: str) -> str:
	"""
	Directory where the SDK stores the keys of a user. Each user gets its own subdirectory, so that
	the storage of the users used by the tests never mixes up.
	"""
	base_dir = os.environ.get(ENV_KEYS_DIR) or DEFAULT_KEYS_DIR
	directory = os.path.join(base_dir, re.sub(r"[^A-Za-z0-9_.-]", "_", username))
	os.makedirs(directory, exist_ok=True)
	return directory


def create_sdk(user: UserCredentials) -> CardinalSdk:
	try:
		return CardinalSdk(
			project_id=None,
			baseurl=cardinal_url(),
			authentication_method=user.authentication_method(),
			storage_facade=FileSystemStorage(keys_directory(user.username)),
		)
	except Exception as e:
		raise RuntimeError(f"Could not initialize the SDK for {user.username} on {cardinal_url()}: {e}") from e


_sdk_cache: dict[str, CardinalSdk] = {}


def sdk_for(user: UserCredentials) -> CardinalSdk:
	"""Returns the SDK of a user, initializing it on the first call only."""
	sdk = _sdk_cache.get(user.username)
	if sdk is None:
		sdk = create_sdk(user)
		_sdk_cache[user.username] = sdk
	return sdk


# The primary user: it is used by all the tests, so it must always be configured.
PRIMARY_USER_PREFIX = "CARDINAL_USER_1"
# The secondary user: it is used by the tests that need two distinct data owners (sharing). If it is
# not configured those tests are skipped.
SECONDARY_USER_PREFIX = "CARDINAL_USER_2"


def primary_user() -> UserCredentials:
	user = credentials(PRIMARY_USER_PREFIX)
	if user is None:
		raise EnvironmentError(f"{PRIMARY_USER_PREFIX}_USERNAME is not set")
	return user


def secondary_user() -> Optional[UserCredentials]:
	return credentials(SECONDARY_USER_PREFIX)


def check_configuration() -> None:
	"""Fails with an explicit message if the mandatory configuration is missing."""
	cardinal_url()
	primary_user()
