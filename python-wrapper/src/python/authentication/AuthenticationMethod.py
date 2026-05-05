from dataclasses import dataclass
from typing import Union

@dataclass
class UsernamePassword:
    username: str
    password: str

@dataclass
class UsernameLongToken:
    username: str
    token: str

AuthenticationMethod = Union[UsernameLongToken, UsernamePassword]

def _serialize_authentication_method(auth_method: AuthenticationMethod) -> dict[str, any]:
    if isinstance(auth_method, UsernamePassword):
        return {
            "type": "com.icure.cardinal.sdk.py.options.PyAuthMethod.UsernamePassword",
            "username": auth_method.username,
            "password": auth_method.password
        }
    elif isinstance(auth_method, UsernameLongToken):
        return {
            "type": "com.icure.cardinal.sdk.py.options.PyAuthMethod.UsernameLongToken",
            "username": auth_method.username,
            "token": auth_method.token
        }
    elif isinstance(auth_method, ThirdPartyAuthentication):
        return {
            "type": "com.icure.cardinal.sdk.py.options.PyAuthMethod.ThirdPartyAuthentication",
            "token": auth_method.token,
            "provider": auth_method.provider.value
        }
    else:
        raise Exception(f"{type(auth_method)} is not a known type of AuthenticationMethod")