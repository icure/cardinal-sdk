// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'schooling_info.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$EncryptedSchoolingInfo {
  int? get startDate;
  int? get endDate;
  String? get school;
  CodeStub? get typeOfEducation;
  Base64String? get encryptedSelf;

  /// Create a copy of EncryptedSchoolingInfo
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedSchoolingInfoCopyWith<EncryptedSchoolingInfo> get copyWith =>
      _$EncryptedSchoolingInfoCopyWithImpl<EncryptedSchoolingInfo>(
          this as EncryptedSchoolingInfo, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedSchoolingInfo &&
            (identical(other.startDate, startDate) ||
                other.startDate == startDate) &&
            (identical(other.endDate, endDate) || other.endDate == endDate) &&
            (identical(other.school, school) || other.school == school) &&
            (identical(other.typeOfEducation, typeOfEducation) ||
                other.typeOfEducation == typeOfEducation) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, startDate, endDate, school, typeOfEducation, encryptedSelf);

  @override
  String toString() {
    return 'EncryptedSchoolingInfo(startDate: $startDate, endDate: $endDate, school: $school, typeOfEducation: $typeOfEducation, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $EncryptedSchoolingInfoCopyWith<$Res> {
  factory $EncryptedSchoolingInfoCopyWith(EncryptedSchoolingInfo value,
          $Res Function(EncryptedSchoolingInfo) _then) =
      _$EncryptedSchoolingInfoCopyWithImpl;
  @useResult
  $Res call(
      {int? startDate,
      int? endDate,
      String? school,
      CodeStub? typeOfEducation,
      Base64String? encryptedSelf});

  $CodeStubCopyWith<$Res>? get typeOfEducation;
}

/// @nodoc
class _$EncryptedSchoolingInfoCopyWithImpl<$Res>
    implements $EncryptedSchoolingInfoCopyWith<$Res> {
  _$EncryptedSchoolingInfoCopyWithImpl(this._self, this._then);

  final EncryptedSchoolingInfo _self;
  final $Res Function(EncryptedSchoolingInfo) _then;

  /// Create a copy of EncryptedSchoolingInfo
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? startDate = freezed,
    Object? endDate = freezed,
    Object? school = freezed,
    Object? typeOfEducation = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      startDate: freezed == startDate
          ? _self.startDate
          : startDate // ignore: cast_nullable_to_non_nullable
              as int?,
      endDate: freezed == endDate
          ? _self.endDate
          : endDate // ignore: cast_nullable_to_non_nullable
              as int?,
      school: freezed == school
          ? _self.school
          : school // ignore: cast_nullable_to_non_nullable
              as String?,
      typeOfEducation: freezed == typeOfEducation
          ? _self.typeOfEducation
          : typeOfEducation // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }

  /// Create a copy of EncryptedSchoolingInfo
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get typeOfEducation {
    if (_self.typeOfEducation == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.typeOfEducation!, (value) {
      return _then(_self.copyWith(typeOfEducation: value));
    });
  }
}

/// @nodoc

class _EncryptedSchoolingInfo implements EncryptedSchoolingInfo {
  const _EncryptedSchoolingInfo(
      {this.startDate = null,
      this.endDate = null,
      this.school = null,
      this.typeOfEducation = null,
      this.encryptedSelf = null});

  @override
  @JsonKey()
  final int? startDate;
  @override
  @JsonKey()
  final int? endDate;
  @override
  @JsonKey()
  final String? school;
  @override
  @JsonKey()
  final CodeStub? typeOfEducation;
  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of EncryptedSchoolingInfo
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedSchoolingInfoCopyWith<_EncryptedSchoolingInfo> get copyWith =>
      __$EncryptedSchoolingInfoCopyWithImpl<_EncryptedSchoolingInfo>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedSchoolingInfo &&
            (identical(other.startDate, startDate) ||
                other.startDate == startDate) &&
            (identical(other.endDate, endDate) || other.endDate == endDate) &&
            (identical(other.school, school) || other.school == school) &&
            (identical(other.typeOfEducation, typeOfEducation) ||
                other.typeOfEducation == typeOfEducation) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, startDate, endDate, school, typeOfEducation, encryptedSelf);

  @override
  String toString() {
    return 'EncryptedSchoolingInfo(startDate: $startDate, endDate: $endDate, school: $school, typeOfEducation: $typeOfEducation, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedSchoolingInfoCopyWith<$Res>
    implements $EncryptedSchoolingInfoCopyWith<$Res> {
  factory _$EncryptedSchoolingInfoCopyWith(_EncryptedSchoolingInfo value,
          $Res Function(_EncryptedSchoolingInfo) _then) =
      __$EncryptedSchoolingInfoCopyWithImpl;
  @override
  @useResult
  $Res call(
      {int? startDate,
      int? endDate,
      String? school,
      CodeStub? typeOfEducation,
      Base64String? encryptedSelf});

  @override
  $CodeStubCopyWith<$Res>? get typeOfEducation;
}

/// @nodoc
class __$EncryptedSchoolingInfoCopyWithImpl<$Res>
    implements _$EncryptedSchoolingInfoCopyWith<$Res> {
  __$EncryptedSchoolingInfoCopyWithImpl(this._self, this._then);

  final _EncryptedSchoolingInfo _self;
  final $Res Function(_EncryptedSchoolingInfo) _then;

  /// Create a copy of EncryptedSchoolingInfo
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? startDate = freezed,
    Object? endDate = freezed,
    Object? school = freezed,
    Object? typeOfEducation = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_EncryptedSchoolingInfo(
      startDate: freezed == startDate
          ? _self.startDate
          : startDate // ignore: cast_nullable_to_non_nullable
              as int?,
      endDate: freezed == endDate
          ? _self.endDate
          : endDate // ignore: cast_nullable_to_non_nullable
              as int?,
      school: freezed == school
          ? _self.school
          : school // ignore: cast_nullable_to_non_nullable
              as String?,
      typeOfEducation: freezed == typeOfEducation
          ? _self.typeOfEducation
          : typeOfEducation // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }

  /// Create a copy of EncryptedSchoolingInfo
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get typeOfEducation {
    if (_self.typeOfEducation == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.typeOfEducation!, (value) {
      return _then(_self.copyWith(typeOfEducation: value));
    });
  }
}

/// @nodoc
mixin _$DecryptedSchoolingInfo {
  int? get startDate;
  int? get endDate;
  String? get school;
  CodeStub? get typeOfEducation;
  Base64String? get encryptedSelf;

  /// Create a copy of DecryptedSchoolingInfo
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedSchoolingInfoCopyWith<DecryptedSchoolingInfo> get copyWith =>
      _$DecryptedSchoolingInfoCopyWithImpl<DecryptedSchoolingInfo>(
          this as DecryptedSchoolingInfo, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedSchoolingInfo &&
            (identical(other.startDate, startDate) ||
                other.startDate == startDate) &&
            (identical(other.endDate, endDate) || other.endDate == endDate) &&
            (identical(other.school, school) || other.school == school) &&
            (identical(other.typeOfEducation, typeOfEducation) ||
                other.typeOfEducation == typeOfEducation) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, startDate, endDate, school, typeOfEducation, encryptedSelf);

  @override
  String toString() {
    return 'DecryptedSchoolingInfo(startDate: $startDate, endDate: $endDate, school: $school, typeOfEducation: $typeOfEducation, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $DecryptedSchoolingInfoCopyWith<$Res> {
  factory $DecryptedSchoolingInfoCopyWith(DecryptedSchoolingInfo value,
          $Res Function(DecryptedSchoolingInfo) _then) =
      _$DecryptedSchoolingInfoCopyWithImpl;
  @useResult
  $Res call(
      {int? startDate,
      int? endDate,
      String? school,
      CodeStub? typeOfEducation,
      Base64String? encryptedSelf});

  $CodeStubCopyWith<$Res>? get typeOfEducation;
}

/// @nodoc
class _$DecryptedSchoolingInfoCopyWithImpl<$Res>
    implements $DecryptedSchoolingInfoCopyWith<$Res> {
  _$DecryptedSchoolingInfoCopyWithImpl(this._self, this._then);

  final DecryptedSchoolingInfo _self;
  final $Res Function(DecryptedSchoolingInfo) _then;

  /// Create a copy of DecryptedSchoolingInfo
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? startDate = freezed,
    Object? endDate = freezed,
    Object? school = freezed,
    Object? typeOfEducation = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      startDate: freezed == startDate
          ? _self.startDate
          : startDate // ignore: cast_nullable_to_non_nullable
              as int?,
      endDate: freezed == endDate
          ? _self.endDate
          : endDate // ignore: cast_nullable_to_non_nullable
              as int?,
      school: freezed == school
          ? _self.school
          : school // ignore: cast_nullable_to_non_nullable
              as String?,
      typeOfEducation: freezed == typeOfEducation
          ? _self.typeOfEducation
          : typeOfEducation // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }

  /// Create a copy of DecryptedSchoolingInfo
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get typeOfEducation {
    if (_self.typeOfEducation == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.typeOfEducation!, (value) {
      return _then(_self.copyWith(typeOfEducation: value));
    });
  }
}

/// @nodoc

class _DecryptedSchoolingInfo implements DecryptedSchoolingInfo {
  const _DecryptedSchoolingInfo(
      {this.startDate = null,
      this.endDate = null,
      this.school = null,
      this.typeOfEducation = null,
      this.encryptedSelf = null});

  @override
  @JsonKey()
  final int? startDate;
  @override
  @JsonKey()
  final int? endDate;
  @override
  @JsonKey()
  final String? school;
  @override
  @JsonKey()
  final CodeStub? typeOfEducation;
  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of DecryptedSchoolingInfo
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedSchoolingInfoCopyWith<_DecryptedSchoolingInfo> get copyWith =>
      __$DecryptedSchoolingInfoCopyWithImpl<_DecryptedSchoolingInfo>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedSchoolingInfo &&
            (identical(other.startDate, startDate) ||
                other.startDate == startDate) &&
            (identical(other.endDate, endDate) || other.endDate == endDate) &&
            (identical(other.school, school) || other.school == school) &&
            (identical(other.typeOfEducation, typeOfEducation) ||
                other.typeOfEducation == typeOfEducation) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, startDate, endDate, school, typeOfEducation, encryptedSelf);

  @override
  String toString() {
    return 'DecryptedSchoolingInfo(startDate: $startDate, endDate: $endDate, school: $school, typeOfEducation: $typeOfEducation, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedSchoolingInfoCopyWith<$Res>
    implements $DecryptedSchoolingInfoCopyWith<$Res> {
  factory _$DecryptedSchoolingInfoCopyWith(_DecryptedSchoolingInfo value,
          $Res Function(_DecryptedSchoolingInfo) _then) =
      __$DecryptedSchoolingInfoCopyWithImpl;
  @override
  @useResult
  $Res call(
      {int? startDate,
      int? endDate,
      String? school,
      CodeStub? typeOfEducation,
      Base64String? encryptedSelf});

  @override
  $CodeStubCopyWith<$Res>? get typeOfEducation;
}

/// @nodoc
class __$DecryptedSchoolingInfoCopyWithImpl<$Res>
    implements _$DecryptedSchoolingInfoCopyWith<$Res> {
  __$DecryptedSchoolingInfoCopyWithImpl(this._self, this._then);

  final _DecryptedSchoolingInfo _self;
  final $Res Function(_DecryptedSchoolingInfo) _then;

  /// Create a copy of DecryptedSchoolingInfo
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? startDate = freezed,
    Object? endDate = freezed,
    Object? school = freezed,
    Object? typeOfEducation = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_DecryptedSchoolingInfo(
      startDate: freezed == startDate
          ? _self.startDate
          : startDate // ignore: cast_nullable_to_non_nullable
              as int?,
      endDate: freezed == endDate
          ? _self.endDate
          : endDate // ignore: cast_nullable_to_non_nullable
              as int?,
      school: freezed == school
          ? _self.school
          : school // ignore: cast_nullable_to_non_nullable
              as String?,
      typeOfEducation: freezed == typeOfEducation
          ? _self.typeOfEducation
          : typeOfEducation // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }

  /// Create a copy of DecryptedSchoolingInfo
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get typeOfEducation {
    if (_self.typeOfEducation == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.typeOfEducation!, (value) {
      return _then(_self.copyWith(typeOfEducation: value));
    });
  }
}

// dart format on
