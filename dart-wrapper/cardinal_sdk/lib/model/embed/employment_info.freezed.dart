// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'employment_info.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$DecryptedEmploymentInfo {
  int? get startDate;
  int? get endDate;
  CodeStub? get professionType;
  Employer? get employer;
  Base64String? get encryptedSelf;

  /// Create a copy of DecryptedEmploymentInfo
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedEmploymentInfoCopyWith<DecryptedEmploymentInfo> get copyWith =>
      _$DecryptedEmploymentInfoCopyWithImpl<DecryptedEmploymentInfo>(
          this as DecryptedEmploymentInfo, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedEmploymentInfo &&
            (identical(other.startDate, startDate) ||
                other.startDate == startDate) &&
            (identical(other.endDate, endDate) || other.endDate == endDate) &&
            (identical(other.professionType, professionType) ||
                other.professionType == professionType) &&
            (identical(other.employer, employer) ||
                other.employer == employer) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, startDate, endDate, professionType, employer, encryptedSelf);

  @override
  String toString() {
    return 'DecryptedEmploymentInfo(startDate: $startDate, endDate: $endDate, professionType: $professionType, employer: $employer, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $DecryptedEmploymentInfoCopyWith<$Res> {
  factory $DecryptedEmploymentInfoCopyWith(DecryptedEmploymentInfo value,
          $Res Function(DecryptedEmploymentInfo) _then) =
      _$DecryptedEmploymentInfoCopyWithImpl;
  @useResult
  $Res call(
      {int? startDate,
      int? endDate,
      CodeStub? professionType,
      Employer? employer,
      Base64String? encryptedSelf});

  $CodeStubCopyWith<$Res>? get professionType;
  $EmployerCopyWith<$Res>? get employer;
}

/// @nodoc
class _$DecryptedEmploymentInfoCopyWithImpl<$Res>
    implements $DecryptedEmploymentInfoCopyWith<$Res> {
  _$DecryptedEmploymentInfoCopyWithImpl(this._self, this._then);

  final DecryptedEmploymentInfo _self;
  final $Res Function(DecryptedEmploymentInfo) _then;

  /// Create a copy of DecryptedEmploymentInfo
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? startDate = freezed,
    Object? endDate = freezed,
    Object? professionType = freezed,
    Object? employer = freezed,
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
      professionType: freezed == professionType
          ? _self.professionType
          : professionType // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      employer: freezed == employer
          ? _self.employer
          : employer // ignore: cast_nullable_to_non_nullable
              as Employer?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }

  /// Create a copy of DecryptedEmploymentInfo
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get professionType {
    if (_self.professionType == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.professionType!, (value) {
      return _then(_self.copyWith(professionType: value));
    });
  }

  /// Create a copy of DecryptedEmploymentInfo
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $EmployerCopyWith<$Res>? get employer {
    if (_self.employer == null) {
      return null;
    }

    return $EmployerCopyWith<$Res>(_self.employer!, (value) {
      return _then(_self.copyWith(employer: value));
    });
  }
}

/// @nodoc

class _DecryptedEmploymentInfo implements DecryptedEmploymentInfo {
  const _DecryptedEmploymentInfo(
      {this.startDate = null,
      this.endDate = null,
      this.professionType = null,
      this.employer = null,
      this.encryptedSelf = null});

  @override
  @JsonKey()
  final int? startDate;
  @override
  @JsonKey()
  final int? endDate;
  @override
  @JsonKey()
  final CodeStub? professionType;
  @override
  @JsonKey()
  final Employer? employer;
  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of DecryptedEmploymentInfo
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedEmploymentInfoCopyWith<_DecryptedEmploymentInfo> get copyWith =>
      __$DecryptedEmploymentInfoCopyWithImpl<_DecryptedEmploymentInfo>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedEmploymentInfo &&
            (identical(other.startDate, startDate) ||
                other.startDate == startDate) &&
            (identical(other.endDate, endDate) || other.endDate == endDate) &&
            (identical(other.professionType, professionType) ||
                other.professionType == professionType) &&
            (identical(other.employer, employer) ||
                other.employer == employer) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, startDate, endDate, professionType, employer, encryptedSelf);

  @override
  String toString() {
    return 'DecryptedEmploymentInfo(startDate: $startDate, endDate: $endDate, professionType: $professionType, employer: $employer, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedEmploymentInfoCopyWith<$Res>
    implements $DecryptedEmploymentInfoCopyWith<$Res> {
  factory _$DecryptedEmploymentInfoCopyWith(_DecryptedEmploymentInfo value,
          $Res Function(_DecryptedEmploymentInfo) _then) =
      __$DecryptedEmploymentInfoCopyWithImpl;
  @override
  @useResult
  $Res call(
      {int? startDate,
      int? endDate,
      CodeStub? professionType,
      Employer? employer,
      Base64String? encryptedSelf});

  @override
  $CodeStubCopyWith<$Res>? get professionType;
  @override
  $EmployerCopyWith<$Res>? get employer;
}

/// @nodoc
class __$DecryptedEmploymentInfoCopyWithImpl<$Res>
    implements _$DecryptedEmploymentInfoCopyWith<$Res> {
  __$DecryptedEmploymentInfoCopyWithImpl(this._self, this._then);

  final _DecryptedEmploymentInfo _self;
  final $Res Function(_DecryptedEmploymentInfo) _then;

  /// Create a copy of DecryptedEmploymentInfo
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? startDate = freezed,
    Object? endDate = freezed,
    Object? professionType = freezed,
    Object? employer = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_DecryptedEmploymentInfo(
      startDate: freezed == startDate
          ? _self.startDate
          : startDate // ignore: cast_nullable_to_non_nullable
              as int?,
      endDate: freezed == endDate
          ? _self.endDate
          : endDate // ignore: cast_nullable_to_non_nullable
              as int?,
      professionType: freezed == professionType
          ? _self.professionType
          : professionType // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      employer: freezed == employer
          ? _self.employer
          : employer // ignore: cast_nullable_to_non_nullable
              as Employer?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }

  /// Create a copy of DecryptedEmploymentInfo
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get professionType {
    if (_self.professionType == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.professionType!, (value) {
      return _then(_self.copyWith(professionType: value));
    });
  }

  /// Create a copy of DecryptedEmploymentInfo
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $EmployerCopyWith<$Res>? get employer {
    if (_self.employer == null) {
      return null;
    }

    return $EmployerCopyWith<$Res>(_self.employer!, (value) {
      return _then(_self.copyWith(employer: value));
    });
  }
}

/// @nodoc
mixin _$EncryptedEmploymentInfo {
  int? get startDate;
  int? get endDate;
  CodeStub? get professionType;
  Employer? get employer;
  Base64String? get encryptedSelf;

  /// Create a copy of EncryptedEmploymentInfo
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedEmploymentInfoCopyWith<EncryptedEmploymentInfo> get copyWith =>
      _$EncryptedEmploymentInfoCopyWithImpl<EncryptedEmploymentInfo>(
          this as EncryptedEmploymentInfo, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedEmploymentInfo &&
            (identical(other.startDate, startDate) ||
                other.startDate == startDate) &&
            (identical(other.endDate, endDate) || other.endDate == endDate) &&
            (identical(other.professionType, professionType) ||
                other.professionType == professionType) &&
            (identical(other.employer, employer) ||
                other.employer == employer) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, startDate, endDate, professionType, employer, encryptedSelf);

  @override
  String toString() {
    return 'EncryptedEmploymentInfo(startDate: $startDate, endDate: $endDate, professionType: $professionType, employer: $employer, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $EncryptedEmploymentInfoCopyWith<$Res> {
  factory $EncryptedEmploymentInfoCopyWith(EncryptedEmploymentInfo value,
          $Res Function(EncryptedEmploymentInfo) _then) =
      _$EncryptedEmploymentInfoCopyWithImpl;
  @useResult
  $Res call(
      {int? startDate,
      int? endDate,
      CodeStub? professionType,
      Employer? employer,
      Base64String? encryptedSelf});

  $CodeStubCopyWith<$Res>? get professionType;
  $EmployerCopyWith<$Res>? get employer;
}

/// @nodoc
class _$EncryptedEmploymentInfoCopyWithImpl<$Res>
    implements $EncryptedEmploymentInfoCopyWith<$Res> {
  _$EncryptedEmploymentInfoCopyWithImpl(this._self, this._then);

  final EncryptedEmploymentInfo _self;
  final $Res Function(EncryptedEmploymentInfo) _then;

  /// Create a copy of EncryptedEmploymentInfo
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? startDate = freezed,
    Object? endDate = freezed,
    Object? professionType = freezed,
    Object? employer = freezed,
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
      professionType: freezed == professionType
          ? _self.professionType
          : professionType // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      employer: freezed == employer
          ? _self.employer
          : employer // ignore: cast_nullable_to_non_nullable
              as Employer?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }

  /// Create a copy of EncryptedEmploymentInfo
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get professionType {
    if (_self.professionType == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.professionType!, (value) {
      return _then(_self.copyWith(professionType: value));
    });
  }

  /// Create a copy of EncryptedEmploymentInfo
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $EmployerCopyWith<$Res>? get employer {
    if (_self.employer == null) {
      return null;
    }

    return $EmployerCopyWith<$Res>(_self.employer!, (value) {
      return _then(_self.copyWith(employer: value));
    });
  }
}

/// @nodoc

class _EncryptedEmploymentInfo implements EncryptedEmploymentInfo {
  const _EncryptedEmploymentInfo(
      {this.startDate = null,
      this.endDate = null,
      this.professionType = null,
      this.employer = null,
      this.encryptedSelf = null});

  @override
  @JsonKey()
  final int? startDate;
  @override
  @JsonKey()
  final int? endDate;
  @override
  @JsonKey()
  final CodeStub? professionType;
  @override
  @JsonKey()
  final Employer? employer;
  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of EncryptedEmploymentInfo
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedEmploymentInfoCopyWith<_EncryptedEmploymentInfo> get copyWith =>
      __$EncryptedEmploymentInfoCopyWithImpl<_EncryptedEmploymentInfo>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedEmploymentInfo &&
            (identical(other.startDate, startDate) ||
                other.startDate == startDate) &&
            (identical(other.endDate, endDate) || other.endDate == endDate) &&
            (identical(other.professionType, professionType) ||
                other.professionType == professionType) &&
            (identical(other.employer, employer) ||
                other.employer == employer) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, startDate, endDate, professionType, employer, encryptedSelf);

  @override
  String toString() {
    return 'EncryptedEmploymentInfo(startDate: $startDate, endDate: $endDate, professionType: $professionType, employer: $employer, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedEmploymentInfoCopyWith<$Res>
    implements $EncryptedEmploymentInfoCopyWith<$Res> {
  factory _$EncryptedEmploymentInfoCopyWith(_EncryptedEmploymentInfo value,
          $Res Function(_EncryptedEmploymentInfo) _then) =
      __$EncryptedEmploymentInfoCopyWithImpl;
  @override
  @useResult
  $Res call(
      {int? startDate,
      int? endDate,
      CodeStub? professionType,
      Employer? employer,
      Base64String? encryptedSelf});

  @override
  $CodeStubCopyWith<$Res>? get professionType;
  @override
  $EmployerCopyWith<$Res>? get employer;
}

/// @nodoc
class __$EncryptedEmploymentInfoCopyWithImpl<$Res>
    implements _$EncryptedEmploymentInfoCopyWith<$Res> {
  __$EncryptedEmploymentInfoCopyWithImpl(this._self, this._then);

  final _EncryptedEmploymentInfo _self;
  final $Res Function(_EncryptedEmploymentInfo) _then;

  /// Create a copy of EncryptedEmploymentInfo
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? startDate = freezed,
    Object? endDate = freezed,
    Object? professionType = freezed,
    Object? employer = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_EncryptedEmploymentInfo(
      startDate: freezed == startDate
          ? _self.startDate
          : startDate // ignore: cast_nullable_to_non_nullable
              as int?,
      endDate: freezed == endDate
          ? _self.endDate
          : endDate // ignore: cast_nullable_to_non_nullable
              as int?,
      professionType: freezed == professionType
          ? _self.professionType
          : professionType // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      employer: freezed == employer
          ? _self.employer
          : employer // ignore: cast_nullable_to_non_nullable
              as Employer?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }

  /// Create a copy of EncryptedEmploymentInfo
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get professionType {
    if (_self.professionType == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.professionType!, (value) {
      return _then(_self.copyWith(professionType: value));
    });
  }

  /// Create a copy of EncryptedEmploymentInfo
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $EmployerCopyWith<$Res>? get employer {
    if (_self.employer == null) {
      return null;
    }

    return $EmployerCopyWith<$Res>(_self.employer!, (value) {
      return _then(_self.copyWith(employer: value));
    });
  }
}

// dart format on
