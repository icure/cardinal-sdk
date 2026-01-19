// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'role.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$Role {
  String get id;
  String? get rev;
  int? get deletionDate;
  String? get name;
  int? get inheritableUpTo;
  Set<String> get permissions;

  /// Create a copy of Role
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $RoleCopyWith<Role> get copyWith =>
      _$RoleCopyWithImpl<Role>(this as Role, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is Role &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.inheritableUpTo, inheritableUpTo) ||
                other.inheritableUpTo == inheritableUpTo) &&
            const DeepCollectionEquality()
                .equals(other.permissions, permissions));
  }

  @override
  int get hashCode => Object.hash(runtimeType, id, rev, deletionDate, name,
      inheritableUpTo, const DeepCollectionEquality().hash(permissions));

  @override
  String toString() {
    return 'Role(id: $id, rev: $rev, deletionDate: $deletionDate, name: $name, inheritableUpTo: $inheritableUpTo, permissions: $permissions)';
  }
}

/// @nodoc
abstract mixin class $RoleCopyWith<$Res> {
  factory $RoleCopyWith(Role value, $Res Function(Role) _then) =
      _$RoleCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? deletionDate,
      String? name,
      int? inheritableUpTo,
      Set<String> permissions});
}

/// @nodoc
class _$RoleCopyWithImpl<$Res> implements $RoleCopyWith<$Res> {
  _$RoleCopyWithImpl(this._self, this._then);

  final Role _self;
  final $Res Function(Role) _then;

  /// Create a copy of Role
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? deletionDate = freezed,
    Object? name = freezed,
    Object? inheritableUpTo = freezed,
    Object? permissions = null,
  }) {
    return _then(_self.copyWith(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      inheritableUpTo: freezed == inheritableUpTo
          ? _self.inheritableUpTo
          : inheritableUpTo // ignore: cast_nullable_to_non_nullable
              as int?,
      permissions: null == permissions
          ? _self.permissions
          : permissions // ignore: cast_nullable_to_non_nullable
              as Set<String>,
    ));
  }
}

/// @nodoc

class _Role implements Role {
  const _Role(
      {required this.id,
      this.rev = null,
      this.deletionDate = null,
      this.name = null,
      this.inheritableUpTo = null,
      final Set<String> permissions = const {}})
      : _permissions = permissions;

  @override
  final String id;
  @override
  @JsonKey()
  final String? rev;
  @override
  @JsonKey()
  final int? deletionDate;
  @override
  @JsonKey()
  final String? name;
  @override
  @JsonKey()
  final int? inheritableUpTo;
  final Set<String> _permissions;
  @override
  @JsonKey()
  Set<String> get permissions {
    if (_permissions is EqualUnmodifiableSetView) return _permissions;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_permissions);
  }

  /// Create a copy of Role
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$RoleCopyWith<_Role> get copyWith =>
      __$RoleCopyWithImpl<_Role>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Role &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.inheritableUpTo, inheritableUpTo) ||
                other.inheritableUpTo == inheritableUpTo) &&
            const DeepCollectionEquality()
                .equals(other._permissions, _permissions));
  }

  @override
  int get hashCode => Object.hash(runtimeType, id, rev, deletionDate, name,
      inheritableUpTo, const DeepCollectionEquality().hash(_permissions));

  @override
  String toString() {
    return 'Role(id: $id, rev: $rev, deletionDate: $deletionDate, name: $name, inheritableUpTo: $inheritableUpTo, permissions: $permissions)';
  }
}

/// @nodoc
abstract mixin class _$RoleCopyWith<$Res> implements $RoleCopyWith<$Res> {
  factory _$RoleCopyWith(_Role value, $Res Function(_Role) _then) =
      __$RoleCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? deletionDate,
      String? name,
      int? inheritableUpTo,
      Set<String> permissions});
}

/// @nodoc
class __$RoleCopyWithImpl<$Res> implements _$RoleCopyWith<$Res> {
  __$RoleCopyWithImpl(this._self, this._then);

  final _Role _self;
  final $Res Function(_Role) _then;

  /// Create a copy of Role
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? deletionDate = freezed,
    Object? name = freezed,
    Object? inheritableUpTo = freezed,
    Object? permissions = null,
  }) {
    return _then(_Role(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      inheritableUpTo: freezed == inheritableUpTo
          ? _self.inheritableUpTo
          : inheritableUpTo // ignore: cast_nullable_to_non_nullable
              as int?,
      permissions: null == permissions
          ? _self._permissions
          : permissions // ignore: cast_nullable_to_non_nullable
              as Set<String>,
    ));
  }
}

// dart format on
