// TODO update for switch from ThirdPartyAuthentication to external jwt

class Credentials {

  final Map<String, dynamic> _json;

  Credentials._internal(this._json);

  /// Instantiates the credentials to log in using a username and a password.
  /// The [username] can be:
  /// - [User.id]
  /// - [Group.id]:[User.id]
  /// - [User.login]
  /// - [User.email]
  /// The [password] is the user password.
  factory Credentials.UsernamePassword(String username, String password) {
    return Credentials._internal({
      "username": username,
      "password": password,
      "kotlinType": "com.icure.cardinal.sdk.dart.auth.Credentials.UsernamePassword"
    });
  }

  /// Instantiates the credentials to log in using a username and a long-lived token.
  /// The [username] can be:
  /// - [User.id]
  /// - [Group.id]:[User.id]
  /// - [User.login]
  /// - [User.email]
  /// The [token] is a long-lived authentication token generated through the SDK
  /// or through the Cockpit.
  factory Credentials.UsernameLongToken(String username, String token) {
    return Credentials._internal({
      "username": username,
      "token": token,
      "kotlinType": "com.icure.cardinal.sdk.dart.auth.Credentials.UsernameLongToken"
    });
  }

  /// Instantiates the credentials to log in using a third-party authentication provider.
  /// The [provider] is the provider using to log in and [token] is the token
  /// received upon completing the third-party authentication flow.
  factory Credentials.ThirdPartyAuthentication(String token, ThirdPartyProvider provider) {
    return Credentials._internal({
      "provider": ThirdPartyProvider.encode(provider),
      "token": token,
      "kotlinType": "com.icure.cardinal.sdk.dart.auth.Credentials.UsernamePassword"
    });
  }

  static Map<String, dynamic> encode(Credentials value) {
    return Map.unmodifiable(value._json);
  }
}

enum ThirdPartyProvider {
  google;

  static String encode(ThirdPartyProvider value) {
    switch(value) {
      case ThirdPartyProvider.google:
        return "GOOGLE";
    }
  }
}