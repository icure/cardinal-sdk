// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'registration_information.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$RegistrationInformation {
  String? get projectId;
  String? get firstName;
  String? get lastName;
  String? get companyName;
  String get emailAddress;
  String? get userOptions;
  Set<String> get userRoles;
  String? get minimumKrakenVersion;
  String? get cluster;

  /// Create a copy of RegistrationInformation
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $RegistrationInformationCopyWith<RegistrationInformation> get copyWith =>
      _$RegistrationInformationCopyWithImpl<RegistrationInformation>(
          this as RegistrationInformation, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is RegistrationInformation &&
            (identical(other.projectId, projectId) ||
                other.projectId == projectId) &&
            (identical(other.firstName, firstName) ||
                other.firstName == firstName) &&
            (identical(other.lastName, lastName) ||
                other.lastName == lastName) &&
            (identical(other.companyName, companyName) ||
                other.companyName == companyName) &&
            (identical(other.emailAddress, emailAddress) ||
                other.emailAddress == emailAddress) &&
            (identical(other.userOptions, userOptions) ||
                other.userOptions == userOptions) &&
            const DeepCollectionEquality().equals(other.userRoles, userRoles) &&
            (identical(other.minimumKrakenVersion, minimumKrakenVersion) ||
                other.minimumKrakenVersion == minimumKrakenVersion) &&
            (identical(other.cluster, cluster) || other.cluster == cluster));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      projectId,
      firstName,
      lastName,
      companyName,
      emailAddress,
      userOptions,
      const DeepCollectionEquality().hash(userRoles),
      minimumKrakenVersion,
      cluster);

  @override
  String toString() {
    return 'RegistrationInformation(projectId: $projectId, firstName: $firstName, lastName: $lastName, companyName: $companyName, emailAddress: $emailAddress, userOptions: $userOptions, userRoles: $userRoles, minimumKrakenVersion: $minimumKrakenVersion, cluster: $cluster)';
  }
}

/// @nodoc
abstract mixin class $RegistrationInformationCopyWith<$Res> {
  factory $RegistrationInformationCopyWith(RegistrationInformation value,
          $Res Function(RegistrationInformation) _then) =
      _$RegistrationInformationCopyWithImpl;
  @useResult
  $Res call(
      {String? projectId,
      String? firstName,
      String? lastName,
      String? companyName,
      String emailAddress,
      String? userOptions,
      Set<String> userRoles,
      String? minimumKrakenVersion,
      String? cluster});
}

/// @nodoc
class _$RegistrationInformationCopyWithImpl<$Res>
    implements $RegistrationInformationCopyWith<$Res> {
  _$RegistrationInformationCopyWithImpl(this._self, this._then);

  final RegistrationInformation _self;
  final $Res Function(RegistrationInformation) _then;

  /// Create a copy of RegistrationInformation
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? projectId = freezed,
    Object? firstName = freezed,
    Object? lastName = freezed,
    Object? companyName = freezed,
    Object? emailAddress = null,
    Object? userOptions = freezed,
    Object? userRoles = null,
    Object? minimumKrakenVersion = freezed,
    Object? cluster = freezed,
  }) {
    return _then(_self.copyWith(
      projectId: freezed == projectId
          ? _self.projectId
          : projectId // ignore: cast_nullable_to_non_nullable
              as String?,
      firstName: freezed == firstName
          ? _self.firstName
          : firstName // ignore: cast_nullable_to_non_nullable
              as String?,
      lastName: freezed == lastName
          ? _self.lastName
          : lastName // ignore: cast_nullable_to_non_nullable
              as String?,
      companyName: freezed == companyName
          ? _self.companyName
          : companyName // ignore: cast_nullable_to_non_nullable
              as String?,
      emailAddress: null == emailAddress
          ? _self.emailAddress
          : emailAddress // ignore: cast_nullable_to_non_nullable
              as String,
      userOptions: freezed == userOptions
          ? _self.userOptions
          : userOptions // ignore: cast_nullable_to_non_nullable
              as String?,
      userRoles: null == userRoles
          ? _self.userRoles
          : userRoles // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      minimumKrakenVersion: freezed == minimumKrakenVersion
          ? _self.minimumKrakenVersion
          : minimumKrakenVersion // ignore: cast_nullable_to_non_nullable
              as String?,
      cluster: freezed == cluster
          ? _self.cluster
          : cluster // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

/// @nodoc

class _RegistrationInformation implements RegistrationInformation {
  const _RegistrationInformation(
      {this.projectId = null,
      this.firstName = null,
      this.lastName = null,
      this.companyName = null,
      required this.emailAddress,
      this.userOptions = null,
      final Set<String> userRoles = const {},
      this.minimumKrakenVersion = null,
      this.cluster = null})
      : _userRoles = userRoles;

  @override
  @JsonKey()
  final String? projectId;
  @override
  @JsonKey()
  final String? firstName;
  @override
  @JsonKey()
  final String? lastName;
  @override
  @JsonKey()
  final String? companyName;
  @override
  final String emailAddress;
  @override
  @JsonKey()
  final String? userOptions;
  final Set<String> _userRoles;
  @override
  @JsonKey()
  Set<String> get userRoles {
    if (_userRoles is EqualUnmodifiableSetView) return _userRoles;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_userRoles);
  }

  @override
  @JsonKey()
  final String? minimumKrakenVersion;
  @override
  @JsonKey()
  final String? cluster;

  /// Create a copy of RegistrationInformation
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$RegistrationInformationCopyWith<_RegistrationInformation> get copyWith =>
      __$RegistrationInformationCopyWithImpl<_RegistrationInformation>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _RegistrationInformation &&
            (identical(other.projectId, projectId) ||
                other.projectId == projectId) &&
            (identical(other.firstName, firstName) ||
                other.firstName == firstName) &&
            (identical(other.lastName, lastName) ||
                other.lastName == lastName) &&
            (identical(other.companyName, companyName) ||
                other.companyName == companyName) &&
            (identical(other.emailAddress, emailAddress) ||
                other.emailAddress == emailAddress) &&
            (identical(other.userOptions, userOptions) ||
                other.userOptions == userOptions) &&
            const DeepCollectionEquality()
                .equals(other._userRoles, _userRoles) &&
            (identical(other.minimumKrakenVersion, minimumKrakenVersion) ||
                other.minimumKrakenVersion == minimumKrakenVersion) &&
            (identical(other.cluster, cluster) || other.cluster == cluster));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      projectId,
      firstName,
      lastName,
      companyName,
      emailAddress,
      userOptions,
      const DeepCollectionEquality().hash(_userRoles),
      minimumKrakenVersion,
      cluster);

  @override
  String toString() {
    return 'RegistrationInformation(projectId: $projectId, firstName: $firstName, lastName: $lastName, companyName: $companyName, emailAddress: $emailAddress, userOptions: $userOptions, userRoles: $userRoles, minimumKrakenVersion: $minimumKrakenVersion, cluster: $cluster)';
  }
}

/// @nodoc
abstract mixin class _$RegistrationInformationCopyWith<$Res>
    implements $RegistrationInformationCopyWith<$Res> {
  factory _$RegistrationInformationCopyWith(_RegistrationInformation value,
          $Res Function(_RegistrationInformation) _then) =
      __$RegistrationInformationCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String? projectId,
      String? firstName,
      String? lastName,
      String? companyName,
      String emailAddress,
      String? userOptions,
      Set<String> userRoles,
      String? minimumKrakenVersion,
      String? cluster});
}

/// @nodoc
class __$RegistrationInformationCopyWithImpl<$Res>
    implements _$RegistrationInformationCopyWith<$Res> {
  __$RegistrationInformationCopyWithImpl(this._self, this._then);

  final _RegistrationInformation _self;
  final $Res Function(_RegistrationInformation) _then;

  /// Create a copy of RegistrationInformation
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? projectId = freezed,
    Object? firstName = freezed,
    Object? lastName = freezed,
    Object? companyName = freezed,
    Object? emailAddress = null,
    Object? userOptions = freezed,
    Object? userRoles = null,
    Object? minimumKrakenVersion = freezed,
    Object? cluster = freezed,
  }) {
    return _then(_RegistrationInformation(
      projectId: freezed == projectId
          ? _self.projectId
          : projectId // ignore: cast_nullable_to_non_nullable
              as String?,
      firstName: freezed == firstName
          ? _self.firstName
          : firstName // ignore: cast_nullable_to_non_nullable
              as String?,
      lastName: freezed == lastName
          ? _self.lastName
          : lastName // ignore: cast_nullable_to_non_nullable
              as String?,
      companyName: freezed == companyName
          ? _self.companyName
          : companyName // ignore: cast_nullable_to_non_nullable
              as String?,
      emailAddress: null == emailAddress
          ? _self.emailAddress
          : emailAddress // ignore: cast_nullable_to_non_nullable
              as String,
      userOptions: freezed == userOptions
          ? _self.userOptions
          : userOptions // ignore: cast_nullable_to_non_nullable
              as String?,
      userRoles: null == userRoles
          ? _self._userRoles
          : userRoles // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      minimumKrakenVersion: freezed == minimumKrakenVersion
          ? _self.minimumKrakenVersion
          : minimumKrakenVersion // ignore: cast_nullable_to_non_nullable
              as String?,
      cluster: freezed == cluster
          ? _self.cluster
          : cluster // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

// dart format on
