// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'raw_decrypted_exchange_data.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$RawDecryptedExchangeData {
  String get exchangeDataId;
  Uint8List get exchangeKey;
  Uint8List get accessControlSecret;
  Uint8List get sharedSignatureKey;

  /// Create a copy of RawDecryptedExchangeData
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $RawDecryptedExchangeDataCopyWith<RawDecryptedExchangeData> get copyWith =>
      _$RawDecryptedExchangeDataCopyWithImpl<RawDecryptedExchangeData>(
          this as RawDecryptedExchangeData, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is RawDecryptedExchangeData &&
            (identical(other.exchangeDataId, exchangeDataId) ||
                other.exchangeDataId == exchangeDataId) &&
            const DeepCollectionEquality()
                .equals(other.exchangeKey, exchangeKey) &&
            const DeepCollectionEquality()
                .equals(other.accessControlSecret, accessControlSecret) &&
            const DeepCollectionEquality()
                .equals(other.sharedSignatureKey, sharedSignatureKey));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      exchangeDataId,
      const DeepCollectionEquality().hash(exchangeKey),
      const DeepCollectionEquality().hash(accessControlSecret),
      const DeepCollectionEquality().hash(sharedSignatureKey));

  @override
  String toString() {
    return 'RawDecryptedExchangeData(exchangeDataId: $exchangeDataId, exchangeKey: $exchangeKey, accessControlSecret: $accessControlSecret, sharedSignatureKey: $sharedSignatureKey)';
  }
}

/// @nodoc
abstract mixin class $RawDecryptedExchangeDataCopyWith<$Res> {
  factory $RawDecryptedExchangeDataCopyWith(RawDecryptedExchangeData value,
          $Res Function(RawDecryptedExchangeData) _then) =
      _$RawDecryptedExchangeDataCopyWithImpl;
  @useResult
  $Res call(
      {String exchangeDataId,
      Uint8List exchangeKey,
      Uint8List accessControlSecret,
      Uint8List sharedSignatureKey});
}

/// @nodoc
class _$RawDecryptedExchangeDataCopyWithImpl<$Res>
    implements $RawDecryptedExchangeDataCopyWith<$Res> {
  _$RawDecryptedExchangeDataCopyWithImpl(this._self, this._then);

  final RawDecryptedExchangeData _self;
  final $Res Function(RawDecryptedExchangeData) _then;

  /// Create a copy of RawDecryptedExchangeData
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? exchangeDataId = null,
    Object? exchangeKey = null,
    Object? accessControlSecret = null,
    Object? sharedSignatureKey = null,
  }) {
    return _then(_self.copyWith(
      exchangeDataId: null == exchangeDataId
          ? _self.exchangeDataId
          : exchangeDataId // ignore: cast_nullable_to_non_nullable
              as String,
      exchangeKey: null == exchangeKey
          ? _self.exchangeKey
          : exchangeKey // ignore: cast_nullable_to_non_nullable
              as Uint8List,
      accessControlSecret: null == accessControlSecret
          ? _self.accessControlSecret
          : accessControlSecret // ignore: cast_nullable_to_non_nullable
              as Uint8List,
      sharedSignatureKey: null == sharedSignatureKey
          ? _self.sharedSignatureKey
          : sharedSignatureKey // ignore: cast_nullable_to_non_nullable
              as Uint8List,
    ));
  }
}

/// @nodoc

class _RawDecryptedExchangeData implements RawDecryptedExchangeData {
  const _RawDecryptedExchangeData(
      {required this.exchangeDataId,
      required this.exchangeKey,
      required this.accessControlSecret,
      required this.sharedSignatureKey});

  @override
  final String exchangeDataId;
  @override
  final Uint8List exchangeKey;
  @override
  final Uint8List accessControlSecret;
  @override
  final Uint8List sharedSignatureKey;

  /// Create a copy of RawDecryptedExchangeData
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$RawDecryptedExchangeDataCopyWith<_RawDecryptedExchangeData> get copyWith =>
      __$RawDecryptedExchangeDataCopyWithImpl<_RawDecryptedExchangeData>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _RawDecryptedExchangeData &&
            (identical(other.exchangeDataId, exchangeDataId) ||
                other.exchangeDataId == exchangeDataId) &&
            const DeepCollectionEquality()
                .equals(other.exchangeKey, exchangeKey) &&
            const DeepCollectionEquality()
                .equals(other.accessControlSecret, accessControlSecret) &&
            const DeepCollectionEquality()
                .equals(other.sharedSignatureKey, sharedSignatureKey));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      exchangeDataId,
      const DeepCollectionEquality().hash(exchangeKey),
      const DeepCollectionEquality().hash(accessControlSecret),
      const DeepCollectionEquality().hash(sharedSignatureKey));

  @override
  String toString() {
    return 'RawDecryptedExchangeData(exchangeDataId: $exchangeDataId, exchangeKey: $exchangeKey, accessControlSecret: $accessControlSecret, sharedSignatureKey: $sharedSignatureKey)';
  }
}

/// @nodoc
abstract mixin class _$RawDecryptedExchangeDataCopyWith<$Res>
    implements $RawDecryptedExchangeDataCopyWith<$Res> {
  factory _$RawDecryptedExchangeDataCopyWith(_RawDecryptedExchangeData value,
          $Res Function(_RawDecryptedExchangeData) _then) =
      __$RawDecryptedExchangeDataCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String exchangeDataId,
      Uint8List exchangeKey,
      Uint8List accessControlSecret,
      Uint8List sharedSignatureKey});
}

/// @nodoc
class __$RawDecryptedExchangeDataCopyWithImpl<$Res>
    implements _$RawDecryptedExchangeDataCopyWith<$Res> {
  __$RawDecryptedExchangeDataCopyWithImpl(this._self, this._then);

  final _RawDecryptedExchangeData _self;
  final $Res Function(_RawDecryptedExchangeData) _then;

  /// Create a copy of RawDecryptedExchangeData
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? exchangeDataId = null,
    Object? exchangeKey = null,
    Object? accessControlSecret = null,
    Object? sharedSignatureKey = null,
  }) {
    return _then(_RawDecryptedExchangeData(
      exchangeDataId: null == exchangeDataId
          ? _self.exchangeDataId
          : exchangeDataId // ignore: cast_nullable_to_non_nullable
              as String,
      exchangeKey: null == exchangeKey
          ? _self.exchangeKey
          : exchangeKey // ignore: cast_nullable_to_non_nullable
              as Uint8List,
      accessControlSecret: null == accessControlSecret
          ? _self.accessControlSecret
          : accessControlSecret // ignore: cast_nullable_to_non_nullable
              as Uint8List,
      sharedSignatureKey: null == sharedSignatureKey
          ? _self.sharedSignatureKey
          : sharedSignatureKey // ignore: cast_nullable_to_non_nullable
              as Uint8List,
    ));
  }
}

// dart format on
