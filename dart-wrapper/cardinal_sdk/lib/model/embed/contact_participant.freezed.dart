// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'contact_participant.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$ContactParticipant {
  ParticipantType get type;
  String get hcpId;

  /// Create a copy of ContactParticipant
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $ContactParticipantCopyWith<ContactParticipant> get copyWith =>
      _$ContactParticipantCopyWithImpl<ContactParticipant>(
          this as ContactParticipant, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is ContactParticipant &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.hcpId, hcpId) || other.hcpId == hcpId));
  }

  @override
  int get hashCode => Object.hash(runtimeType, type, hcpId);

  @override
  String toString() {
    return 'ContactParticipant(type: $type, hcpId: $hcpId)';
  }
}

/// @nodoc
abstract mixin class $ContactParticipantCopyWith<$Res> {
  factory $ContactParticipantCopyWith(
          ContactParticipant value, $Res Function(ContactParticipant) _then) =
      _$ContactParticipantCopyWithImpl;
  @useResult
  $Res call({ParticipantType type, String hcpId});
}

/// @nodoc
class _$ContactParticipantCopyWithImpl<$Res>
    implements $ContactParticipantCopyWith<$Res> {
  _$ContactParticipantCopyWithImpl(this._self, this._then);

  final ContactParticipant _self;
  final $Res Function(ContactParticipant) _then;

  /// Create a copy of ContactParticipant
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? type = null,
    Object? hcpId = null,
  }) {
    return _then(_self.copyWith(
      type: null == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as ParticipantType,
      hcpId: null == hcpId
          ? _self.hcpId
          : hcpId // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

/// @nodoc

class _ContactParticipant implements ContactParticipant {
  const _ContactParticipant({required this.type, required this.hcpId});

  @override
  final ParticipantType type;
  @override
  final String hcpId;

  /// Create a copy of ContactParticipant
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$ContactParticipantCopyWith<_ContactParticipant> get copyWith =>
      __$ContactParticipantCopyWithImpl<_ContactParticipant>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _ContactParticipant &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.hcpId, hcpId) || other.hcpId == hcpId));
  }

  @override
  int get hashCode => Object.hash(runtimeType, type, hcpId);

  @override
  String toString() {
    return 'ContactParticipant(type: $type, hcpId: $hcpId)';
  }
}

/// @nodoc
abstract mixin class _$ContactParticipantCopyWith<$Res>
    implements $ContactParticipantCopyWith<$Res> {
  factory _$ContactParticipantCopyWith(
          _ContactParticipant value, $Res Function(_ContactParticipant) _then) =
      __$ContactParticipantCopyWithImpl;
  @override
  @useResult
  $Res call({ParticipantType type, String hcpId});
}

/// @nodoc
class __$ContactParticipantCopyWithImpl<$Res>
    implements _$ContactParticipantCopyWith<$Res> {
  __$ContactParticipantCopyWithImpl(this._self, this._then);

  final _ContactParticipant _self;
  final $Res Function(_ContactParticipant) _then;

  /// Create a copy of ContactParticipant
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? type = null,
    Object? hcpId = null,
  }) {
    return _then(_ContactParticipant(
      type: null == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as ParticipantType,
      hcpId: null == hcpId
          ? _self.hcpId
          : hcpId // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

// dart format on
