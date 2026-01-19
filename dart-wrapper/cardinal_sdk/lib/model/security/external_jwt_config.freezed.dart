// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'external_jwt_config.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$ExternalJwtConfig {
  ExternalJwtConfigValidationMethod get validationMethod;
  ExternalJwtConfigFieldSelector get fieldSelector;
  AuthenticationClass get authenticationClass;

  /// Create a copy of ExternalJwtConfig
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $ExternalJwtConfigCopyWith<ExternalJwtConfig> get copyWith =>
      _$ExternalJwtConfigCopyWithImpl<ExternalJwtConfig>(
          this as ExternalJwtConfig, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is ExternalJwtConfig &&
            (identical(other.validationMethod, validationMethod) ||
                other.validationMethod == validationMethod) &&
            (identical(other.fieldSelector, fieldSelector) ||
                other.fieldSelector == fieldSelector) &&
            (identical(other.authenticationClass, authenticationClass) ||
                other.authenticationClass == authenticationClass));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, validationMethod, fieldSelector, authenticationClass);

  @override
  String toString() {
    return 'ExternalJwtConfig(validationMethod: $validationMethod, fieldSelector: $fieldSelector, authenticationClass: $authenticationClass)';
  }
}

/// @nodoc
abstract mixin class $ExternalJwtConfigCopyWith<$Res> {
  factory $ExternalJwtConfigCopyWith(
          ExternalJwtConfig value, $Res Function(ExternalJwtConfig) _then) =
      _$ExternalJwtConfigCopyWithImpl;
  @useResult
  $Res call(
      {ExternalJwtConfigValidationMethod validationMethod,
      ExternalJwtConfigFieldSelector fieldSelector,
      AuthenticationClass authenticationClass});
}

/// @nodoc
class _$ExternalJwtConfigCopyWithImpl<$Res>
    implements $ExternalJwtConfigCopyWith<$Res> {
  _$ExternalJwtConfigCopyWithImpl(this._self, this._then);

  final ExternalJwtConfig _self;
  final $Res Function(ExternalJwtConfig) _then;

  /// Create a copy of ExternalJwtConfig
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? validationMethod = null,
    Object? fieldSelector = null,
    Object? authenticationClass = null,
  }) {
    return _then(_self.copyWith(
      validationMethod: null == validationMethod
          ? _self.validationMethod
          : validationMethod // ignore: cast_nullable_to_non_nullable
              as ExternalJwtConfigValidationMethod,
      fieldSelector: null == fieldSelector
          ? _self.fieldSelector
          : fieldSelector // ignore: cast_nullable_to_non_nullable
              as ExternalJwtConfigFieldSelector,
      authenticationClass: null == authenticationClass
          ? _self.authenticationClass
          : authenticationClass // ignore: cast_nullable_to_non_nullable
              as AuthenticationClass,
    ));
  }
}

/// @nodoc

class _ExternalJwtConfig implements ExternalJwtConfig {
  const _ExternalJwtConfig(
      {required this.validationMethod,
      required this.fieldSelector,
      this.authenticationClass = AuthenticationClass.externalAuthentication});

  @override
  final ExternalJwtConfigValidationMethod validationMethod;
  @override
  final ExternalJwtConfigFieldSelector fieldSelector;
  @override
  @JsonKey()
  final AuthenticationClass authenticationClass;

  /// Create a copy of ExternalJwtConfig
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$ExternalJwtConfigCopyWith<_ExternalJwtConfig> get copyWith =>
      __$ExternalJwtConfigCopyWithImpl<_ExternalJwtConfig>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _ExternalJwtConfig &&
            (identical(other.validationMethod, validationMethod) ||
                other.validationMethod == validationMethod) &&
            (identical(other.fieldSelector, fieldSelector) ||
                other.fieldSelector == fieldSelector) &&
            (identical(other.authenticationClass, authenticationClass) ||
                other.authenticationClass == authenticationClass));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, validationMethod, fieldSelector, authenticationClass);

  @override
  String toString() {
    return 'ExternalJwtConfig(validationMethod: $validationMethod, fieldSelector: $fieldSelector, authenticationClass: $authenticationClass)';
  }
}

/// @nodoc
abstract mixin class _$ExternalJwtConfigCopyWith<$Res>
    implements $ExternalJwtConfigCopyWith<$Res> {
  factory _$ExternalJwtConfigCopyWith(
          _ExternalJwtConfig value, $Res Function(_ExternalJwtConfig) _then) =
      __$ExternalJwtConfigCopyWithImpl;
  @override
  @useResult
  $Res call(
      {ExternalJwtConfigValidationMethod validationMethod,
      ExternalJwtConfigFieldSelector fieldSelector,
      AuthenticationClass authenticationClass});
}

/// @nodoc
class __$ExternalJwtConfigCopyWithImpl<$Res>
    implements _$ExternalJwtConfigCopyWith<$Res> {
  __$ExternalJwtConfigCopyWithImpl(this._self, this._then);

  final _ExternalJwtConfig _self;
  final $Res Function(_ExternalJwtConfig) _then;

  /// Create a copy of ExternalJwtConfig
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? validationMethod = null,
    Object? fieldSelector = null,
    Object? authenticationClass = null,
  }) {
    return _then(_ExternalJwtConfig(
      validationMethod: null == validationMethod
          ? _self.validationMethod
          : validationMethod // ignore: cast_nullable_to_non_nullable
              as ExternalJwtConfigValidationMethod,
      fieldSelector: null == fieldSelector
          ? _self.fieldSelector
          : fieldSelector // ignore: cast_nullable_to_non_nullable
              as ExternalJwtConfigFieldSelector,
      authenticationClass: null == authenticationClass
          ? _self.authenticationClass
          : authenticationClass // ignore: cast_nullable_to_non_nullable
              as AuthenticationClass,
    ));
  }
}

/// @nodoc
mixin _$ExternalJwtConfigValidationMethodPublicKey {
  String get key;
  String? get signatureAlgorithm;

  /// Create a copy of ExternalJwtConfigValidationMethodPublicKey
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $ExternalJwtConfigValidationMethodPublicKeyCopyWith<
          ExternalJwtConfigValidationMethodPublicKey>
      get copyWith => _$ExternalJwtConfigValidationMethodPublicKeyCopyWithImpl<
              ExternalJwtConfigValidationMethodPublicKey>(
          this as ExternalJwtConfigValidationMethodPublicKey, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is ExternalJwtConfigValidationMethodPublicKey &&
            (identical(other.key, key) || other.key == key) &&
            (identical(other.signatureAlgorithm, signatureAlgorithm) ||
                other.signatureAlgorithm == signatureAlgorithm));
  }

  @override
  int get hashCode => Object.hash(runtimeType, key, signatureAlgorithm);

  @override
  String toString() {
    return 'ExternalJwtConfigValidationMethodPublicKey(key: $key, signatureAlgorithm: $signatureAlgorithm)';
  }
}

/// @nodoc
abstract mixin class $ExternalJwtConfigValidationMethodPublicKeyCopyWith<$Res> {
  factory $ExternalJwtConfigValidationMethodPublicKeyCopyWith(
          ExternalJwtConfigValidationMethodPublicKey value,
          $Res Function(ExternalJwtConfigValidationMethodPublicKey) _then) =
      _$ExternalJwtConfigValidationMethodPublicKeyCopyWithImpl;
  @useResult
  $Res call({String key, String? signatureAlgorithm});
}

/// @nodoc
class _$ExternalJwtConfigValidationMethodPublicKeyCopyWithImpl<$Res>
    implements $ExternalJwtConfigValidationMethodPublicKeyCopyWith<$Res> {
  _$ExternalJwtConfigValidationMethodPublicKeyCopyWithImpl(
      this._self, this._then);

  final ExternalJwtConfigValidationMethodPublicKey _self;
  final $Res Function(ExternalJwtConfigValidationMethodPublicKey) _then;

  /// Create a copy of ExternalJwtConfigValidationMethodPublicKey
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? key = null,
    Object? signatureAlgorithm = freezed,
  }) {
    return _then(_self.copyWith(
      key: null == key
          ? _self.key
          : key // ignore: cast_nullable_to_non_nullable
              as String,
      signatureAlgorithm: freezed == signatureAlgorithm
          ? _self.signatureAlgorithm
          : signatureAlgorithm // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

/// @nodoc

class _ExternalJwtConfigValidationMethodPublicKey
    implements ExternalJwtConfigValidationMethodPublicKey {
  const _ExternalJwtConfigValidationMethodPublicKey(
      {required this.key, this.signatureAlgorithm = null});

  @override
  final String key;
  @override
  @JsonKey()
  final String? signatureAlgorithm;

  /// Create a copy of ExternalJwtConfigValidationMethodPublicKey
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$ExternalJwtConfigValidationMethodPublicKeyCopyWith<
          _ExternalJwtConfigValidationMethodPublicKey>
      get copyWith => __$ExternalJwtConfigValidationMethodPublicKeyCopyWithImpl<
          _ExternalJwtConfigValidationMethodPublicKey>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _ExternalJwtConfigValidationMethodPublicKey &&
            (identical(other.key, key) || other.key == key) &&
            (identical(other.signatureAlgorithm, signatureAlgorithm) ||
                other.signatureAlgorithm == signatureAlgorithm));
  }

  @override
  int get hashCode => Object.hash(runtimeType, key, signatureAlgorithm);

  @override
  String toString() {
    return 'ExternalJwtConfigValidationMethodPublicKey(key: $key, signatureAlgorithm: $signatureAlgorithm)';
  }
}

/// @nodoc
abstract mixin class _$ExternalJwtConfigValidationMethodPublicKeyCopyWith<$Res>
    implements $ExternalJwtConfigValidationMethodPublicKeyCopyWith<$Res> {
  factory _$ExternalJwtConfigValidationMethodPublicKeyCopyWith(
          _ExternalJwtConfigValidationMethodPublicKey value,
          $Res Function(_ExternalJwtConfigValidationMethodPublicKey) _then) =
      __$ExternalJwtConfigValidationMethodPublicKeyCopyWithImpl;
  @override
  @useResult
  $Res call({String key, String? signatureAlgorithm});
}

/// @nodoc
class __$ExternalJwtConfigValidationMethodPublicKeyCopyWithImpl<$Res>
    implements _$ExternalJwtConfigValidationMethodPublicKeyCopyWith<$Res> {
  __$ExternalJwtConfigValidationMethodPublicKeyCopyWithImpl(
      this._self, this._then);

  final _ExternalJwtConfigValidationMethodPublicKey _self;
  final $Res Function(_ExternalJwtConfigValidationMethodPublicKey) _then;

  /// Create a copy of ExternalJwtConfigValidationMethodPublicKey
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? key = null,
    Object? signatureAlgorithm = freezed,
  }) {
    return _then(_ExternalJwtConfigValidationMethodPublicKey(
      key: null == key
          ? _self.key
          : key // ignore: cast_nullable_to_non_nullable
              as String,
      signatureAlgorithm: freezed == signatureAlgorithm
          ? _self.signatureAlgorithm
          : signatureAlgorithm // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

/// @nodoc
mixin _$ExternalJwtConfigValidationMethodOidc {
  String get issureLocation;

  /// Create a copy of ExternalJwtConfigValidationMethodOidc
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $ExternalJwtConfigValidationMethodOidcCopyWith<
          ExternalJwtConfigValidationMethodOidc>
      get copyWith => _$ExternalJwtConfigValidationMethodOidcCopyWithImpl<
              ExternalJwtConfigValidationMethodOidc>(
          this as ExternalJwtConfigValidationMethodOidc, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is ExternalJwtConfigValidationMethodOidc &&
            (identical(other.issureLocation, issureLocation) ||
                other.issureLocation == issureLocation));
  }

  @override
  int get hashCode => Object.hash(runtimeType, issureLocation);

  @override
  String toString() {
    return 'ExternalJwtConfigValidationMethodOidc(issureLocation: $issureLocation)';
  }
}

/// @nodoc
abstract mixin class $ExternalJwtConfigValidationMethodOidcCopyWith<$Res> {
  factory $ExternalJwtConfigValidationMethodOidcCopyWith(
          ExternalJwtConfigValidationMethodOidc value,
          $Res Function(ExternalJwtConfigValidationMethodOidc) _then) =
      _$ExternalJwtConfigValidationMethodOidcCopyWithImpl;
  @useResult
  $Res call({String issureLocation});
}

/// @nodoc
class _$ExternalJwtConfigValidationMethodOidcCopyWithImpl<$Res>
    implements $ExternalJwtConfigValidationMethodOidcCopyWith<$Res> {
  _$ExternalJwtConfigValidationMethodOidcCopyWithImpl(this._self, this._then);

  final ExternalJwtConfigValidationMethodOidc _self;
  final $Res Function(ExternalJwtConfigValidationMethodOidc) _then;

  /// Create a copy of ExternalJwtConfigValidationMethodOidc
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? issureLocation = null,
  }) {
    return _then(_self.copyWith(
      issureLocation: null == issureLocation
          ? _self.issureLocation
          : issureLocation // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

/// @nodoc

class _ExternalJwtConfigValidationMethodOidc
    implements ExternalJwtConfigValidationMethodOidc {
  const _ExternalJwtConfigValidationMethodOidc({required this.issureLocation});

  @override
  final String issureLocation;

  /// Create a copy of ExternalJwtConfigValidationMethodOidc
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$ExternalJwtConfigValidationMethodOidcCopyWith<
          _ExternalJwtConfigValidationMethodOidc>
      get copyWith => __$ExternalJwtConfigValidationMethodOidcCopyWithImpl<
          _ExternalJwtConfigValidationMethodOidc>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _ExternalJwtConfigValidationMethodOidc &&
            (identical(other.issureLocation, issureLocation) ||
                other.issureLocation == issureLocation));
  }

  @override
  int get hashCode => Object.hash(runtimeType, issureLocation);

  @override
  String toString() {
    return 'ExternalJwtConfigValidationMethodOidc(issureLocation: $issureLocation)';
  }
}

/// @nodoc
abstract mixin class _$ExternalJwtConfigValidationMethodOidcCopyWith<$Res>
    implements $ExternalJwtConfigValidationMethodOidcCopyWith<$Res> {
  factory _$ExternalJwtConfigValidationMethodOidcCopyWith(
          _ExternalJwtConfigValidationMethodOidc value,
          $Res Function(_ExternalJwtConfigValidationMethodOidc) _then) =
      __$ExternalJwtConfigValidationMethodOidcCopyWithImpl;
  @override
  @useResult
  $Res call({String issureLocation});
}

/// @nodoc
class __$ExternalJwtConfigValidationMethodOidcCopyWithImpl<$Res>
    implements _$ExternalJwtConfigValidationMethodOidcCopyWith<$Res> {
  __$ExternalJwtConfigValidationMethodOidcCopyWithImpl(this._self, this._then);

  final _ExternalJwtConfigValidationMethodOidc _self;
  final $Res Function(_ExternalJwtConfigValidationMethodOidc) _then;

  /// Create a copy of ExternalJwtConfigValidationMethodOidc
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? issureLocation = null,
  }) {
    return _then(_ExternalJwtConfigValidationMethodOidc(
      issureLocation: null == issureLocation
          ? _self.issureLocation
          : issureLocation // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

/// @nodoc
mixin _$ExternalJwtConfigFieldSelectorLocalId {
  String get fieldName;

  /// Create a copy of ExternalJwtConfigFieldSelectorLocalId
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $ExternalJwtConfigFieldSelectorLocalIdCopyWith<
          ExternalJwtConfigFieldSelectorLocalId>
      get copyWith => _$ExternalJwtConfigFieldSelectorLocalIdCopyWithImpl<
              ExternalJwtConfigFieldSelectorLocalId>(
          this as ExternalJwtConfigFieldSelectorLocalId, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is ExternalJwtConfigFieldSelectorLocalId &&
            (identical(other.fieldName, fieldName) ||
                other.fieldName == fieldName));
  }

  @override
  int get hashCode => Object.hash(runtimeType, fieldName);

  @override
  String toString() {
    return 'ExternalJwtConfigFieldSelectorLocalId(fieldName: $fieldName)';
  }
}

/// @nodoc
abstract mixin class $ExternalJwtConfigFieldSelectorLocalIdCopyWith<$Res> {
  factory $ExternalJwtConfigFieldSelectorLocalIdCopyWith(
          ExternalJwtConfigFieldSelectorLocalId value,
          $Res Function(ExternalJwtConfigFieldSelectorLocalId) _then) =
      _$ExternalJwtConfigFieldSelectorLocalIdCopyWithImpl;
  @useResult
  $Res call({String fieldName});
}

/// @nodoc
class _$ExternalJwtConfigFieldSelectorLocalIdCopyWithImpl<$Res>
    implements $ExternalJwtConfigFieldSelectorLocalIdCopyWith<$Res> {
  _$ExternalJwtConfigFieldSelectorLocalIdCopyWithImpl(this._self, this._then);

  final ExternalJwtConfigFieldSelectorLocalId _self;
  final $Res Function(ExternalJwtConfigFieldSelectorLocalId) _then;

  /// Create a copy of ExternalJwtConfigFieldSelectorLocalId
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? fieldName = null,
  }) {
    return _then(_self.copyWith(
      fieldName: null == fieldName
          ? _self.fieldName
          : fieldName // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

/// @nodoc

class _ExternalJwtConfigFieldSelectorLocalId
    implements ExternalJwtConfigFieldSelectorLocalId {
  const _ExternalJwtConfigFieldSelectorLocalId({required this.fieldName});

  @override
  final String fieldName;

  /// Create a copy of ExternalJwtConfigFieldSelectorLocalId
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$ExternalJwtConfigFieldSelectorLocalIdCopyWith<
          _ExternalJwtConfigFieldSelectorLocalId>
      get copyWith => __$ExternalJwtConfigFieldSelectorLocalIdCopyWithImpl<
          _ExternalJwtConfigFieldSelectorLocalId>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _ExternalJwtConfigFieldSelectorLocalId &&
            (identical(other.fieldName, fieldName) ||
                other.fieldName == fieldName));
  }

  @override
  int get hashCode => Object.hash(runtimeType, fieldName);

  @override
  String toString() {
    return 'ExternalJwtConfigFieldSelectorLocalId(fieldName: $fieldName)';
  }
}

/// @nodoc
abstract mixin class _$ExternalJwtConfigFieldSelectorLocalIdCopyWith<$Res>
    implements $ExternalJwtConfigFieldSelectorLocalIdCopyWith<$Res> {
  factory _$ExternalJwtConfigFieldSelectorLocalIdCopyWith(
          _ExternalJwtConfigFieldSelectorLocalId value,
          $Res Function(_ExternalJwtConfigFieldSelectorLocalId) _then) =
      __$ExternalJwtConfigFieldSelectorLocalIdCopyWithImpl;
  @override
  @useResult
  $Res call({String fieldName});
}

/// @nodoc
class __$ExternalJwtConfigFieldSelectorLocalIdCopyWithImpl<$Res>
    implements _$ExternalJwtConfigFieldSelectorLocalIdCopyWith<$Res> {
  __$ExternalJwtConfigFieldSelectorLocalIdCopyWithImpl(this._self, this._then);

  final _ExternalJwtConfigFieldSelectorLocalId _self;
  final $Res Function(_ExternalJwtConfigFieldSelectorLocalId) _then;

  /// Create a copy of ExternalJwtConfigFieldSelectorLocalId
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? fieldName = null,
  }) {
    return _then(_ExternalJwtConfigFieldSelectorLocalId(
      fieldName: null == fieldName
          ? _self.fieldName
          : fieldName // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

/// @nodoc
mixin _$ExternalJwtConfigFieldSelectorEmail {
  String get fieldName;

  /// Create a copy of ExternalJwtConfigFieldSelectorEmail
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $ExternalJwtConfigFieldSelectorEmailCopyWith<
          ExternalJwtConfigFieldSelectorEmail>
      get copyWith => _$ExternalJwtConfigFieldSelectorEmailCopyWithImpl<
              ExternalJwtConfigFieldSelectorEmail>(
          this as ExternalJwtConfigFieldSelectorEmail, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is ExternalJwtConfigFieldSelectorEmail &&
            (identical(other.fieldName, fieldName) ||
                other.fieldName == fieldName));
  }

  @override
  int get hashCode => Object.hash(runtimeType, fieldName);

  @override
  String toString() {
    return 'ExternalJwtConfigFieldSelectorEmail(fieldName: $fieldName)';
  }
}

/// @nodoc
abstract mixin class $ExternalJwtConfigFieldSelectorEmailCopyWith<$Res> {
  factory $ExternalJwtConfigFieldSelectorEmailCopyWith(
          ExternalJwtConfigFieldSelectorEmail value,
          $Res Function(ExternalJwtConfigFieldSelectorEmail) _then) =
      _$ExternalJwtConfigFieldSelectorEmailCopyWithImpl;
  @useResult
  $Res call({String fieldName});
}

/// @nodoc
class _$ExternalJwtConfigFieldSelectorEmailCopyWithImpl<$Res>
    implements $ExternalJwtConfigFieldSelectorEmailCopyWith<$Res> {
  _$ExternalJwtConfigFieldSelectorEmailCopyWithImpl(this._self, this._then);

  final ExternalJwtConfigFieldSelectorEmail _self;
  final $Res Function(ExternalJwtConfigFieldSelectorEmail) _then;

  /// Create a copy of ExternalJwtConfigFieldSelectorEmail
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? fieldName = null,
  }) {
    return _then(_self.copyWith(
      fieldName: null == fieldName
          ? _self.fieldName
          : fieldName // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

/// @nodoc

class _ExternalJwtConfigFieldSelectorEmail
    implements ExternalJwtConfigFieldSelectorEmail {
  const _ExternalJwtConfigFieldSelectorEmail({required this.fieldName});

  @override
  final String fieldName;

  /// Create a copy of ExternalJwtConfigFieldSelectorEmail
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$ExternalJwtConfigFieldSelectorEmailCopyWith<
          _ExternalJwtConfigFieldSelectorEmail>
      get copyWith => __$ExternalJwtConfigFieldSelectorEmailCopyWithImpl<
          _ExternalJwtConfigFieldSelectorEmail>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _ExternalJwtConfigFieldSelectorEmail &&
            (identical(other.fieldName, fieldName) ||
                other.fieldName == fieldName));
  }

  @override
  int get hashCode => Object.hash(runtimeType, fieldName);

  @override
  String toString() {
    return 'ExternalJwtConfigFieldSelectorEmail(fieldName: $fieldName)';
  }
}

/// @nodoc
abstract mixin class _$ExternalJwtConfigFieldSelectorEmailCopyWith<$Res>
    implements $ExternalJwtConfigFieldSelectorEmailCopyWith<$Res> {
  factory _$ExternalJwtConfigFieldSelectorEmailCopyWith(
          _ExternalJwtConfigFieldSelectorEmail value,
          $Res Function(_ExternalJwtConfigFieldSelectorEmail) _then) =
      __$ExternalJwtConfigFieldSelectorEmailCopyWithImpl;
  @override
  @useResult
  $Res call({String fieldName});
}

/// @nodoc
class __$ExternalJwtConfigFieldSelectorEmailCopyWithImpl<$Res>
    implements _$ExternalJwtConfigFieldSelectorEmailCopyWith<$Res> {
  __$ExternalJwtConfigFieldSelectorEmailCopyWithImpl(this._self, this._then);

  final _ExternalJwtConfigFieldSelectorEmail _self;
  final $Res Function(_ExternalJwtConfigFieldSelectorEmail) _then;

  /// Create a copy of ExternalJwtConfigFieldSelectorEmail
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? fieldName = null,
  }) {
    return _then(_ExternalJwtConfigFieldSelectorEmail(
      fieldName: null == fieldName
          ? _self.fieldName
          : fieldName // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

/// @nodoc
mixin _$ExternalJwtConfigFieldSelectorMobilePhone {
  String get fieldName;

  /// Create a copy of ExternalJwtConfigFieldSelectorMobilePhone
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $ExternalJwtConfigFieldSelectorMobilePhoneCopyWith<
          ExternalJwtConfigFieldSelectorMobilePhone>
      get copyWith => _$ExternalJwtConfigFieldSelectorMobilePhoneCopyWithImpl<
              ExternalJwtConfigFieldSelectorMobilePhone>(
          this as ExternalJwtConfigFieldSelectorMobilePhone, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is ExternalJwtConfigFieldSelectorMobilePhone &&
            (identical(other.fieldName, fieldName) ||
                other.fieldName == fieldName));
  }

  @override
  int get hashCode => Object.hash(runtimeType, fieldName);

  @override
  String toString() {
    return 'ExternalJwtConfigFieldSelectorMobilePhone(fieldName: $fieldName)';
  }
}

/// @nodoc
abstract mixin class $ExternalJwtConfigFieldSelectorMobilePhoneCopyWith<$Res> {
  factory $ExternalJwtConfigFieldSelectorMobilePhoneCopyWith(
          ExternalJwtConfigFieldSelectorMobilePhone value,
          $Res Function(ExternalJwtConfigFieldSelectorMobilePhone) _then) =
      _$ExternalJwtConfigFieldSelectorMobilePhoneCopyWithImpl;
  @useResult
  $Res call({String fieldName});
}

/// @nodoc
class _$ExternalJwtConfigFieldSelectorMobilePhoneCopyWithImpl<$Res>
    implements $ExternalJwtConfigFieldSelectorMobilePhoneCopyWith<$Res> {
  _$ExternalJwtConfigFieldSelectorMobilePhoneCopyWithImpl(
      this._self, this._then);

  final ExternalJwtConfigFieldSelectorMobilePhone _self;
  final $Res Function(ExternalJwtConfigFieldSelectorMobilePhone) _then;

  /// Create a copy of ExternalJwtConfigFieldSelectorMobilePhone
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? fieldName = null,
  }) {
    return _then(_self.copyWith(
      fieldName: null == fieldName
          ? _self.fieldName
          : fieldName // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

/// @nodoc

class _ExternalJwtConfigFieldSelectorMobilePhone
    implements ExternalJwtConfigFieldSelectorMobilePhone {
  const _ExternalJwtConfigFieldSelectorMobilePhone({required this.fieldName});

  @override
  final String fieldName;

  /// Create a copy of ExternalJwtConfigFieldSelectorMobilePhone
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$ExternalJwtConfigFieldSelectorMobilePhoneCopyWith<
          _ExternalJwtConfigFieldSelectorMobilePhone>
      get copyWith => __$ExternalJwtConfigFieldSelectorMobilePhoneCopyWithImpl<
          _ExternalJwtConfigFieldSelectorMobilePhone>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _ExternalJwtConfigFieldSelectorMobilePhone &&
            (identical(other.fieldName, fieldName) ||
                other.fieldName == fieldName));
  }

  @override
  int get hashCode => Object.hash(runtimeType, fieldName);

  @override
  String toString() {
    return 'ExternalJwtConfigFieldSelectorMobilePhone(fieldName: $fieldName)';
  }
}

/// @nodoc
abstract mixin class _$ExternalJwtConfigFieldSelectorMobilePhoneCopyWith<$Res>
    implements $ExternalJwtConfigFieldSelectorMobilePhoneCopyWith<$Res> {
  factory _$ExternalJwtConfigFieldSelectorMobilePhoneCopyWith(
          _ExternalJwtConfigFieldSelectorMobilePhone value,
          $Res Function(_ExternalJwtConfigFieldSelectorMobilePhone) _then) =
      __$ExternalJwtConfigFieldSelectorMobilePhoneCopyWithImpl;
  @override
  @useResult
  $Res call({String fieldName});
}

/// @nodoc
class __$ExternalJwtConfigFieldSelectorMobilePhoneCopyWithImpl<$Res>
    implements _$ExternalJwtConfigFieldSelectorMobilePhoneCopyWith<$Res> {
  __$ExternalJwtConfigFieldSelectorMobilePhoneCopyWithImpl(
      this._self, this._then);

  final _ExternalJwtConfigFieldSelectorMobilePhone _self;
  final $Res Function(_ExternalJwtConfigFieldSelectorMobilePhone) _then;

  /// Create a copy of ExternalJwtConfigFieldSelectorMobilePhone
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? fieldName = null,
  }) {
    return _then(_ExternalJwtConfigFieldSelectorMobilePhone(
      fieldName: null == fieldName
          ? _self.fieldName
          : fieldName // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

/// @nodoc
mixin _$ExternalJwtConfigFieldSelectorUsername {
  String get fieldName;

  /// Create a copy of ExternalJwtConfigFieldSelectorUsername
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $ExternalJwtConfigFieldSelectorUsernameCopyWith<
          ExternalJwtConfigFieldSelectorUsername>
      get copyWith => _$ExternalJwtConfigFieldSelectorUsernameCopyWithImpl<
              ExternalJwtConfigFieldSelectorUsername>(
          this as ExternalJwtConfigFieldSelectorUsername, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is ExternalJwtConfigFieldSelectorUsername &&
            (identical(other.fieldName, fieldName) ||
                other.fieldName == fieldName));
  }

  @override
  int get hashCode => Object.hash(runtimeType, fieldName);

  @override
  String toString() {
    return 'ExternalJwtConfigFieldSelectorUsername(fieldName: $fieldName)';
  }
}

/// @nodoc
abstract mixin class $ExternalJwtConfigFieldSelectorUsernameCopyWith<$Res> {
  factory $ExternalJwtConfigFieldSelectorUsernameCopyWith(
          ExternalJwtConfigFieldSelectorUsername value,
          $Res Function(ExternalJwtConfigFieldSelectorUsername) _then) =
      _$ExternalJwtConfigFieldSelectorUsernameCopyWithImpl;
  @useResult
  $Res call({String fieldName});
}

/// @nodoc
class _$ExternalJwtConfigFieldSelectorUsernameCopyWithImpl<$Res>
    implements $ExternalJwtConfigFieldSelectorUsernameCopyWith<$Res> {
  _$ExternalJwtConfigFieldSelectorUsernameCopyWithImpl(this._self, this._then);

  final ExternalJwtConfigFieldSelectorUsername _self;
  final $Res Function(ExternalJwtConfigFieldSelectorUsername) _then;

  /// Create a copy of ExternalJwtConfigFieldSelectorUsername
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? fieldName = null,
  }) {
    return _then(_self.copyWith(
      fieldName: null == fieldName
          ? _self.fieldName
          : fieldName // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

/// @nodoc

class _ExternalJwtConfigFieldSelectorUsername
    implements ExternalJwtConfigFieldSelectorUsername {
  const _ExternalJwtConfigFieldSelectorUsername({required this.fieldName});

  @override
  final String fieldName;

  /// Create a copy of ExternalJwtConfigFieldSelectorUsername
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$ExternalJwtConfigFieldSelectorUsernameCopyWith<
          _ExternalJwtConfigFieldSelectorUsername>
      get copyWith => __$ExternalJwtConfigFieldSelectorUsernameCopyWithImpl<
          _ExternalJwtConfigFieldSelectorUsername>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _ExternalJwtConfigFieldSelectorUsername &&
            (identical(other.fieldName, fieldName) ||
                other.fieldName == fieldName));
  }

  @override
  int get hashCode => Object.hash(runtimeType, fieldName);

  @override
  String toString() {
    return 'ExternalJwtConfigFieldSelectorUsername(fieldName: $fieldName)';
  }
}

/// @nodoc
abstract mixin class _$ExternalJwtConfigFieldSelectorUsernameCopyWith<$Res>
    implements $ExternalJwtConfigFieldSelectorUsernameCopyWith<$Res> {
  factory _$ExternalJwtConfigFieldSelectorUsernameCopyWith(
          _ExternalJwtConfigFieldSelectorUsername value,
          $Res Function(_ExternalJwtConfigFieldSelectorUsername) _then) =
      __$ExternalJwtConfigFieldSelectorUsernameCopyWithImpl;
  @override
  @useResult
  $Res call({String fieldName});
}

/// @nodoc
class __$ExternalJwtConfigFieldSelectorUsernameCopyWithImpl<$Res>
    implements _$ExternalJwtConfigFieldSelectorUsernameCopyWith<$Res> {
  __$ExternalJwtConfigFieldSelectorUsernameCopyWithImpl(this._self, this._then);

  final _ExternalJwtConfigFieldSelectorUsername _self;
  final $Res Function(_ExternalJwtConfigFieldSelectorUsername) _then;

  /// Create a copy of ExternalJwtConfigFieldSelectorUsername
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? fieldName = null,
  }) {
    return _then(_ExternalJwtConfigFieldSelectorUsername(
      fieldName: null == fieldName
          ? _self.fieldName
          : fieldName // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

/// @nodoc
mixin _$ExternalJwtConfigFieldSelectorIdentifier {
  String get identifierAssigner;
  String get fieldName;

  /// Create a copy of ExternalJwtConfigFieldSelectorIdentifier
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $ExternalJwtConfigFieldSelectorIdentifierCopyWith<
          ExternalJwtConfigFieldSelectorIdentifier>
      get copyWith => _$ExternalJwtConfigFieldSelectorIdentifierCopyWithImpl<
              ExternalJwtConfigFieldSelectorIdentifier>(
          this as ExternalJwtConfigFieldSelectorIdentifier, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is ExternalJwtConfigFieldSelectorIdentifier &&
            (identical(other.identifierAssigner, identifierAssigner) ||
                other.identifierAssigner == identifierAssigner) &&
            (identical(other.fieldName, fieldName) ||
                other.fieldName == fieldName));
  }

  @override
  int get hashCode => Object.hash(runtimeType, identifierAssigner, fieldName);

  @override
  String toString() {
    return 'ExternalJwtConfigFieldSelectorIdentifier(identifierAssigner: $identifierAssigner, fieldName: $fieldName)';
  }
}

/// @nodoc
abstract mixin class $ExternalJwtConfigFieldSelectorIdentifierCopyWith<$Res> {
  factory $ExternalJwtConfigFieldSelectorIdentifierCopyWith(
          ExternalJwtConfigFieldSelectorIdentifier value,
          $Res Function(ExternalJwtConfigFieldSelectorIdentifier) _then) =
      _$ExternalJwtConfigFieldSelectorIdentifierCopyWithImpl;
  @useResult
  $Res call({String identifierAssigner, String fieldName});
}

/// @nodoc
class _$ExternalJwtConfigFieldSelectorIdentifierCopyWithImpl<$Res>
    implements $ExternalJwtConfigFieldSelectorIdentifierCopyWith<$Res> {
  _$ExternalJwtConfigFieldSelectorIdentifierCopyWithImpl(
      this._self, this._then);

  final ExternalJwtConfigFieldSelectorIdentifier _self;
  final $Res Function(ExternalJwtConfigFieldSelectorIdentifier) _then;

  /// Create a copy of ExternalJwtConfigFieldSelectorIdentifier
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? identifierAssigner = null,
    Object? fieldName = null,
  }) {
    return _then(_self.copyWith(
      identifierAssigner: null == identifierAssigner
          ? _self.identifierAssigner
          : identifierAssigner // ignore: cast_nullable_to_non_nullable
              as String,
      fieldName: null == fieldName
          ? _self.fieldName
          : fieldName // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

/// @nodoc

class _ExternalJwtConfigFieldSelectorIdentifier
    implements ExternalJwtConfigFieldSelectorIdentifier {
  const _ExternalJwtConfigFieldSelectorIdentifier(
      {required this.identifierAssigner, required this.fieldName});

  @override
  final String identifierAssigner;
  @override
  final String fieldName;

  /// Create a copy of ExternalJwtConfigFieldSelectorIdentifier
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$ExternalJwtConfigFieldSelectorIdentifierCopyWith<
          _ExternalJwtConfigFieldSelectorIdentifier>
      get copyWith => __$ExternalJwtConfigFieldSelectorIdentifierCopyWithImpl<
          _ExternalJwtConfigFieldSelectorIdentifier>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _ExternalJwtConfigFieldSelectorIdentifier &&
            (identical(other.identifierAssigner, identifierAssigner) ||
                other.identifierAssigner == identifierAssigner) &&
            (identical(other.fieldName, fieldName) ||
                other.fieldName == fieldName));
  }

  @override
  int get hashCode => Object.hash(runtimeType, identifierAssigner, fieldName);

  @override
  String toString() {
    return 'ExternalJwtConfigFieldSelectorIdentifier(identifierAssigner: $identifierAssigner, fieldName: $fieldName)';
  }
}

/// @nodoc
abstract mixin class _$ExternalJwtConfigFieldSelectorIdentifierCopyWith<$Res>
    implements $ExternalJwtConfigFieldSelectorIdentifierCopyWith<$Res> {
  factory _$ExternalJwtConfigFieldSelectorIdentifierCopyWith(
          _ExternalJwtConfigFieldSelectorIdentifier value,
          $Res Function(_ExternalJwtConfigFieldSelectorIdentifier) _then) =
      __$ExternalJwtConfigFieldSelectorIdentifierCopyWithImpl;
  @override
  @useResult
  $Res call({String identifierAssigner, String fieldName});
}

/// @nodoc
class __$ExternalJwtConfigFieldSelectorIdentifierCopyWithImpl<$Res>
    implements _$ExternalJwtConfigFieldSelectorIdentifierCopyWith<$Res> {
  __$ExternalJwtConfigFieldSelectorIdentifierCopyWithImpl(
      this._self, this._then);

  final _ExternalJwtConfigFieldSelectorIdentifier _self;
  final $Res Function(_ExternalJwtConfigFieldSelectorIdentifier) _then;

  /// Create a copy of ExternalJwtConfigFieldSelectorIdentifier
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? identifierAssigner = null,
    Object? fieldName = null,
  }) {
    return _then(_ExternalJwtConfigFieldSelectorIdentifier(
      identifierAssigner: null == identifierAssigner
          ? _self.identifierAssigner
          : identifierAssigner // ignore: cast_nullable_to_non_nullable
              as String,
      fieldName: null == fieldName
          ? _self.fieldName
          : fieldName // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

// dart format on
