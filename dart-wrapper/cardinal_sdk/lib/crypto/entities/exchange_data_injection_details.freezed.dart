// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'exchange_data_injection_details.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$ExchangeDataInjectionDetails {
  String get exchangeDataId;
  Uint8List get accessControlSecret;
  Uint8List get exchangeKey;
  Uint8List get sharedSignatureKey;
  bool get verified;

  /// Create a copy of ExchangeDataInjectionDetails
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $ExchangeDataInjectionDetailsCopyWith<ExchangeDataInjectionDetails>
      get copyWith => _$ExchangeDataInjectionDetailsCopyWithImpl<
              ExchangeDataInjectionDetails>(
          this as ExchangeDataInjectionDetails, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is ExchangeDataInjectionDetails &&
            (identical(other.exchangeDataId, exchangeDataId) ||
                other.exchangeDataId == exchangeDataId) &&
            const DeepCollectionEquality()
                .equals(other.accessControlSecret, accessControlSecret) &&
            const DeepCollectionEquality()
                .equals(other.exchangeKey, exchangeKey) &&
            const DeepCollectionEquality()
                .equals(other.sharedSignatureKey, sharedSignatureKey) &&
            (identical(other.verified, verified) ||
                other.verified == verified));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      exchangeDataId,
      const DeepCollectionEquality().hash(accessControlSecret),
      const DeepCollectionEquality().hash(exchangeKey),
      const DeepCollectionEquality().hash(sharedSignatureKey),
      verified);

  @override
  String toString() {
    return 'ExchangeDataInjectionDetails(exchangeDataId: $exchangeDataId, accessControlSecret: $accessControlSecret, exchangeKey: $exchangeKey, sharedSignatureKey: $sharedSignatureKey, verified: $verified)';
  }
}

/// @nodoc
abstract mixin class $ExchangeDataInjectionDetailsCopyWith<$Res> {
  factory $ExchangeDataInjectionDetailsCopyWith(
          ExchangeDataInjectionDetails value,
          $Res Function(ExchangeDataInjectionDetails) _then) =
      _$ExchangeDataInjectionDetailsCopyWithImpl;
  @useResult
  $Res call(
      {String exchangeDataId,
      Uint8List accessControlSecret,
      Uint8List exchangeKey,
      Uint8List sharedSignatureKey,
      bool verified});
}

/// @nodoc
class _$ExchangeDataInjectionDetailsCopyWithImpl<$Res>
    implements $ExchangeDataInjectionDetailsCopyWith<$Res> {
  _$ExchangeDataInjectionDetailsCopyWithImpl(this._self, this._then);

  final ExchangeDataInjectionDetails _self;
  final $Res Function(ExchangeDataInjectionDetails) _then;

  /// Create a copy of ExchangeDataInjectionDetails
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? exchangeDataId = null,
    Object? accessControlSecret = null,
    Object? exchangeKey = null,
    Object? sharedSignatureKey = null,
    Object? verified = null,
  }) {
    return _then(_self.copyWith(
      exchangeDataId: null == exchangeDataId
          ? _self.exchangeDataId
          : exchangeDataId // ignore: cast_nullable_to_non_nullable
              as String,
      accessControlSecret: null == accessControlSecret
          ? _self.accessControlSecret
          : accessControlSecret // ignore: cast_nullable_to_non_nullable
              as Uint8List,
      exchangeKey: null == exchangeKey
          ? _self.exchangeKey
          : exchangeKey // ignore: cast_nullable_to_non_nullable
              as Uint8List,
      sharedSignatureKey: null == sharedSignatureKey
          ? _self.sharedSignatureKey
          : sharedSignatureKey // ignore: cast_nullable_to_non_nullable
              as Uint8List,
      verified: null == verified
          ? _self.verified
          : verified // ignore: cast_nullable_to_non_nullable
              as bool,
    ));
  }
}

/// @nodoc

class _ExchangeDataInjectionDetails implements ExchangeDataInjectionDetails {
  const _ExchangeDataInjectionDetails(
      {required this.exchangeDataId,
      required this.accessControlSecret,
      required this.exchangeKey,
      required this.sharedSignatureKey,
      required this.verified});

  @override
  final String exchangeDataId;
  @override
  final Uint8List accessControlSecret;
  @override
  final Uint8List exchangeKey;
  @override
  final Uint8List sharedSignatureKey;
  @override
  final bool verified;

  /// Create a copy of ExchangeDataInjectionDetails
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$ExchangeDataInjectionDetailsCopyWith<_ExchangeDataInjectionDetails>
      get copyWith => __$ExchangeDataInjectionDetailsCopyWithImpl<
          _ExchangeDataInjectionDetails>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _ExchangeDataInjectionDetails &&
            (identical(other.exchangeDataId, exchangeDataId) ||
                other.exchangeDataId == exchangeDataId) &&
            const DeepCollectionEquality()
                .equals(other.accessControlSecret, accessControlSecret) &&
            const DeepCollectionEquality()
                .equals(other.exchangeKey, exchangeKey) &&
            const DeepCollectionEquality()
                .equals(other.sharedSignatureKey, sharedSignatureKey) &&
            (identical(other.verified, verified) ||
                other.verified == verified));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      exchangeDataId,
      const DeepCollectionEquality().hash(accessControlSecret),
      const DeepCollectionEquality().hash(exchangeKey),
      const DeepCollectionEquality().hash(sharedSignatureKey),
      verified);

  @override
  String toString() {
    return 'ExchangeDataInjectionDetails(exchangeDataId: $exchangeDataId, accessControlSecret: $accessControlSecret, exchangeKey: $exchangeKey, sharedSignatureKey: $sharedSignatureKey, verified: $verified)';
  }
}

/// @nodoc
abstract mixin class _$ExchangeDataInjectionDetailsCopyWith<$Res>
    implements $ExchangeDataInjectionDetailsCopyWith<$Res> {
  factory _$ExchangeDataInjectionDetailsCopyWith(
          _ExchangeDataInjectionDetails value,
          $Res Function(_ExchangeDataInjectionDetails) _then) =
      __$ExchangeDataInjectionDetailsCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String exchangeDataId,
      Uint8List accessControlSecret,
      Uint8List exchangeKey,
      Uint8List sharedSignatureKey,
      bool verified});
}

/// @nodoc
class __$ExchangeDataInjectionDetailsCopyWithImpl<$Res>
    implements _$ExchangeDataInjectionDetailsCopyWith<$Res> {
  __$ExchangeDataInjectionDetailsCopyWithImpl(this._self, this._then);

  final _ExchangeDataInjectionDetails _self;
  final $Res Function(_ExchangeDataInjectionDetails) _then;

  /// Create a copy of ExchangeDataInjectionDetails
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? exchangeDataId = null,
    Object? accessControlSecret = null,
    Object? exchangeKey = null,
    Object? sharedSignatureKey = null,
    Object? verified = null,
  }) {
    return _then(_ExchangeDataInjectionDetails(
      exchangeDataId: null == exchangeDataId
          ? _self.exchangeDataId
          : exchangeDataId // ignore: cast_nullable_to_non_nullable
              as String,
      accessControlSecret: null == accessControlSecret
          ? _self.accessControlSecret
          : accessControlSecret // ignore: cast_nullable_to_non_nullable
              as Uint8List,
      exchangeKey: null == exchangeKey
          ? _self.exchangeKey
          : exchangeKey // ignore: cast_nullable_to_non_nullable
              as Uint8List,
      sharedSignatureKey: null == sharedSignatureKey
          ? _self.sharedSignatureKey
          : sharedSignatureKey // ignore: cast_nullable_to_non_nullable
              as Uint8List,
      verified: null == verified
          ? _self.verified
          : verified // ignore: cast_nullable_to_non_nullable
              as bool,
    ));
  }
}

// dart format on
