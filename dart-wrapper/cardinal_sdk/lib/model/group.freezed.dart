// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'group.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$Group {
  String get id;
  String? get rev;
  int? get deletionDate;
  Set<CodeStub> get tags;
  Set<CodeStub> get publicTags;
  String? get name;
  String? get password;
  List<String>? get servers;
  bool get superAdmin;
  Set<DecryptedPropertyStub> get properties;
  Map<UserType, Set<String>> get defaultUserRoles;
  Map<String, OperationToken> get operationTokens;
  Map<String, String> get sharedEntities;
  String? get minimumKrakenVersion;
  Map<String, ExternalJwtConfig> get externalJwtConfig;
  AuthenticationClass get minimumAuthenticationClassForElevatedPrivileges;
  String? get superGroup;
  String? get projectId;

  /// Create a copy of Group
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $GroupCopyWith<Group> get copyWith =>
      _$GroupCopyWithImpl<Group>(this as Group, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is Group &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            const DeepCollectionEquality().equals(other.tags, tags) &&
            const DeepCollectionEquality()
                .equals(other.publicTags, publicTags) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.password, password) ||
                other.password == password) &&
            const DeepCollectionEquality().equals(other.servers, servers) &&
            (identical(other.superAdmin, superAdmin) ||
                other.superAdmin == superAdmin) &&
            const DeepCollectionEquality()
                .equals(other.properties, properties) &&
            const DeepCollectionEquality()
                .equals(other.defaultUserRoles, defaultUserRoles) &&
            const DeepCollectionEquality()
                .equals(other.operationTokens, operationTokens) &&
            const DeepCollectionEquality()
                .equals(other.sharedEntities, sharedEntities) &&
            (identical(other.minimumKrakenVersion, minimumKrakenVersion) ||
                other.minimumKrakenVersion == minimumKrakenVersion) &&
            const DeepCollectionEquality()
                .equals(other.externalJwtConfig, externalJwtConfig) &&
            (identical(other.minimumAuthenticationClassForElevatedPrivileges,
                    minimumAuthenticationClassForElevatedPrivileges) ||
                other.minimumAuthenticationClassForElevatedPrivileges ==
                    minimumAuthenticationClassForElevatedPrivileges) &&
            (identical(other.superGroup, superGroup) ||
                other.superGroup == superGroup) &&
            (identical(other.projectId, projectId) ||
                other.projectId == projectId));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      rev,
      deletionDate,
      const DeepCollectionEquality().hash(tags),
      const DeepCollectionEquality().hash(publicTags),
      name,
      password,
      const DeepCollectionEquality().hash(servers),
      superAdmin,
      const DeepCollectionEquality().hash(properties),
      const DeepCollectionEquality().hash(defaultUserRoles),
      const DeepCollectionEquality().hash(operationTokens),
      const DeepCollectionEquality().hash(sharedEntities),
      minimumKrakenVersion,
      const DeepCollectionEquality().hash(externalJwtConfig),
      minimumAuthenticationClassForElevatedPrivileges,
      superGroup,
      projectId);

  @override
  String toString() {
    return 'Group(id: $id, rev: $rev, deletionDate: $deletionDate, tags: $tags, publicTags: $publicTags, name: $name, password: $password, servers: $servers, superAdmin: $superAdmin, properties: $properties, defaultUserRoles: $defaultUserRoles, operationTokens: $operationTokens, sharedEntities: $sharedEntities, minimumKrakenVersion: $minimumKrakenVersion, externalJwtConfig: $externalJwtConfig, minimumAuthenticationClassForElevatedPrivileges: $minimumAuthenticationClassForElevatedPrivileges, superGroup: $superGroup, projectId: $projectId)';
  }
}

/// @nodoc
abstract mixin class $GroupCopyWith<$Res> {
  factory $GroupCopyWith(Group value, $Res Function(Group) _then) =
      _$GroupCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? deletionDate,
      Set<CodeStub> tags,
      Set<CodeStub> publicTags,
      String? name,
      String? password,
      List<String>? servers,
      bool superAdmin,
      Set<DecryptedPropertyStub> properties,
      Map<UserType, Set<String>> defaultUserRoles,
      Map<String, OperationToken> operationTokens,
      Map<String, String> sharedEntities,
      String? minimumKrakenVersion,
      Map<String, ExternalJwtConfig> externalJwtConfig,
      AuthenticationClass minimumAuthenticationClassForElevatedPrivileges,
      String? superGroup,
      String? projectId});
}

/// @nodoc
class _$GroupCopyWithImpl<$Res> implements $GroupCopyWith<$Res> {
  _$GroupCopyWithImpl(this._self, this._then);

  final Group _self;
  final $Res Function(Group) _then;

  /// Create a copy of Group
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? deletionDate = freezed,
    Object? tags = null,
    Object? publicTags = null,
    Object? name = freezed,
    Object? password = freezed,
    Object? servers = freezed,
    Object? superAdmin = null,
    Object? properties = null,
    Object? defaultUserRoles = null,
    Object? operationTokens = null,
    Object? sharedEntities = null,
    Object? minimumKrakenVersion = freezed,
    Object? externalJwtConfig = null,
    Object? minimumAuthenticationClassForElevatedPrivileges = null,
    Object? superGroup = freezed,
    Object? projectId = freezed,
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
      tags: null == tags
          ? _self.tags
          : tags // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      publicTags: null == publicTags
          ? _self.publicTags
          : publicTags // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      password: freezed == password
          ? _self.password
          : password // ignore: cast_nullable_to_non_nullable
              as String?,
      servers: freezed == servers
          ? _self.servers
          : servers // ignore: cast_nullable_to_non_nullable
              as List<String>?,
      superAdmin: null == superAdmin
          ? _self.superAdmin
          : superAdmin // ignore: cast_nullable_to_non_nullable
              as bool,
      properties: null == properties
          ? _self.properties
          : properties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>,
      defaultUserRoles: null == defaultUserRoles
          ? _self.defaultUserRoles
          : defaultUserRoles // ignore: cast_nullable_to_non_nullable
              as Map<UserType, Set<String>>,
      operationTokens: null == operationTokens
          ? _self.operationTokens
          : operationTokens // ignore: cast_nullable_to_non_nullable
              as Map<String, OperationToken>,
      sharedEntities: null == sharedEntities
          ? _self.sharedEntities
          : sharedEntities // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      minimumKrakenVersion: freezed == minimumKrakenVersion
          ? _self.minimumKrakenVersion
          : minimumKrakenVersion // ignore: cast_nullable_to_non_nullable
              as String?,
      externalJwtConfig: null == externalJwtConfig
          ? _self.externalJwtConfig
          : externalJwtConfig // ignore: cast_nullable_to_non_nullable
              as Map<String, ExternalJwtConfig>,
      minimumAuthenticationClassForElevatedPrivileges: null ==
              minimumAuthenticationClassForElevatedPrivileges
          ? _self.minimumAuthenticationClassForElevatedPrivileges
          : minimumAuthenticationClassForElevatedPrivileges // ignore: cast_nullable_to_non_nullable
              as AuthenticationClass,
      superGroup: freezed == superGroup
          ? _self.superGroup
          : superGroup // ignore: cast_nullable_to_non_nullable
              as String?,
      projectId: freezed == projectId
          ? _self.projectId
          : projectId // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

/// @nodoc

class _Group implements Group {
  const _Group(
      {required this.id,
      this.rev = null,
      this.deletionDate = null,
      final Set<CodeStub> tags = const {},
      final Set<CodeStub> publicTags = const {},
      this.name = null,
      this.password = null,
      final List<String>? servers = null,
      this.superAdmin = false,
      final Set<DecryptedPropertyStub> properties = const {},
      final Map<UserType, Set<String>> defaultUserRoles = const {},
      final Map<String, OperationToken> operationTokens = const {},
      final Map<String, String> sharedEntities = const {},
      this.minimumKrakenVersion = null,
      final Map<String, ExternalJwtConfig> externalJwtConfig = const {},
      required this.minimumAuthenticationClassForElevatedPrivileges,
      this.superGroup = null,
      this.projectId = null})
      : _tags = tags,
        _publicTags = publicTags,
        _servers = servers,
        _properties = properties,
        _defaultUserRoles = defaultUserRoles,
        _operationTokens = operationTokens,
        _sharedEntities = sharedEntities,
        _externalJwtConfig = externalJwtConfig;

  @override
  final String id;
  @override
  @JsonKey()
  final String? rev;
  @override
  @JsonKey()
  final int? deletionDate;
  final Set<CodeStub> _tags;
  @override
  @JsonKey()
  Set<CodeStub> get tags {
    if (_tags is EqualUnmodifiableSetView) return _tags;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_tags);
  }

  final Set<CodeStub> _publicTags;
  @override
  @JsonKey()
  Set<CodeStub> get publicTags {
    if (_publicTags is EqualUnmodifiableSetView) return _publicTags;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_publicTags);
  }

  @override
  @JsonKey()
  final String? name;
  @override
  @JsonKey()
  final String? password;
  final List<String>? _servers;
  @override
  @JsonKey()
  List<String>? get servers {
    final value = _servers;
    if (value == null) return null;
    if (_servers is EqualUnmodifiableListView) return _servers;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(value);
  }

  @override
  @JsonKey()
  final bool superAdmin;
  final Set<DecryptedPropertyStub> _properties;
  @override
  @JsonKey()
  Set<DecryptedPropertyStub> get properties {
    if (_properties is EqualUnmodifiableSetView) return _properties;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_properties);
  }

  final Map<UserType, Set<String>> _defaultUserRoles;
  @override
  @JsonKey()
  Map<UserType, Set<String>> get defaultUserRoles {
    if (_defaultUserRoles is EqualUnmodifiableMapView) return _defaultUserRoles;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_defaultUserRoles);
  }

  final Map<String, OperationToken> _operationTokens;
  @override
  @JsonKey()
  Map<String, OperationToken> get operationTokens {
    if (_operationTokens is EqualUnmodifiableMapView) return _operationTokens;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_operationTokens);
  }

  final Map<String, String> _sharedEntities;
  @override
  @JsonKey()
  Map<String, String> get sharedEntities {
    if (_sharedEntities is EqualUnmodifiableMapView) return _sharedEntities;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_sharedEntities);
  }

  @override
  @JsonKey()
  final String? minimumKrakenVersion;
  final Map<String, ExternalJwtConfig> _externalJwtConfig;
  @override
  @JsonKey()
  Map<String, ExternalJwtConfig> get externalJwtConfig {
    if (_externalJwtConfig is EqualUnmodifiableMapView)
      return _externalJwtConfig;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_externalJwtConfig);
  }

  @override
  final AuthenticationClass minimumAuthenticationClassForElevatedPrivileges;
  @override
  @JsonKey()
  final String? superGroup;
  @override
  @JsonKey()
  final String? projectId;

  /// Create a copy of Group
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$GroupCopyWith<_Group> get copyWith =>
      __$GroupCopyWithImpl<_Group>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Group &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            const DeepCollectionEquality().equals(other._tags, _tags) &&
            const DeepCollectionEquality()
                .equals(other._publicTags, _publicTags) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.password, password) ||
                other.password == password) &&
            const DeepCollectionEquality().equals(other._servers, _servers) &&
            (identical(other.superAdmin, superAdmin) ||
                other.superAdmin == superAdmin) &&
            const DeepCollectionEquality()
                .equals(other._properties, _properties) &&
            const DeepCollectionEquality()
                .equals(other._defaultUserRoles, _defaultUserRoles) &&
            const DeepCollectionEquality()
                .equals(other._operationTokens, _operationTokens) &&
            const DeepCollectionEquality()
                .equals(other._sharedEntities, _sharedEntities) &&
            (identical(other.minimumKrakenVersion, minimumKrakenVersion) ||
                other.minimumKrakenVersion == minimumKrakenVersion) &&
            const DeepCollectionEquality()
                .equals(other._externalJwtConfig, _externalJwtConfig) &&
            (identical(other.minimumAuthenticationClassForElevatedPrivileges,
                    minimumAuthenticationClassForElevatedPrivileges) ||
                other.minimumAuthenticationClassForElevatedPrivileges ==
                    minimumAuthenticationClassForElevatedPrivileges) &&
            (identical(other.superGroup, superGroup) ||
                other.superGroup == superGroup) &&
            (identical(other.projectId, projectId) ||
                other.projectId == projectId));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      rev,
      deletionDate,
      const DeepCollectionEquality().hash(_tags),
      const DeepCollectionEquality().hash(_publicTags),
      name,
      password,
      const DeepCollectionEquality().hash(_servers),
      superAdmin,
      const DeepCollectionEquality().hash(_properties),
      const DeepCollectionEquality().hash(_defaultUserRoles),
      const DeepCollectionEquality().hash(_operationTokens),
      const DeepCollectionEquality().hash(_sharedEntities),
      minimumKrakenVersion,
      const DeepCollectionEquality().hash(_externalJwtConfig),
      minimumAuthenticationClassForElevatedPrivileges,
      superGroup,
      projectId);

  @override
  String toString() {
    return 'Group(id: $id, rev: $rev, deletionDate: $deletionDate, tags: $tags, publicTags: $publicTags, name: $name, password: $password, servers: $servers, superAdmin: $superAdmin, properties: $properties, defaultUserRoles: $defaultUserRoles, operationTokens: $operationTokens, sharedEntities: $sharedEntities, minimumKrakenVersion: $minimumKrakenVersion, externalJwtConfig: $externalJwtConfig, minimumAuthenticationClassForElevatedPrivileges: $minimumAuthenticationClassForElevatedPrivileges, superGroup: $superGroup, projectId: $projectId)';
  }
}

/// @nodoc
abstract mixin class _$GroupCopyWith<$Res> implements $GroupCopyWith<$Res> {
  factory _$GroupCopyWith(_Group value, $Res Function(_Group) _then) =
      __$GroupCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? deletionDate,
      Set<CodeStub> tags,
      Set<CodeStub> publicTags,
      String? name,
      String? password,
      List<String>? servers,
      bool superAdmin,
      Set<DecryptedPropertyStub> properties,
      Map<UserType, Set<String>> defaultUserRoles,
      Map<String, OperationToken> operationTokens,
      Map<String, String> sharedEntities,
      String? minimumKrakenVersion,
      Map<String, ExternalJwtConfig> externalJwtConfig,
      AuthenticationClass minimumAuthenticationClassForElevatedPrivileges,
      String? superGroup,
      String? projectId});
}

/// @nodoc
class __$GroupCopyWithImpl<$Res> implements _$GroupCopyWith<$Res> {
  __$GroupCopyWithImpl(this._self, this._then);

  final _Group _self;
  final $Res Function(_Group) _then;

  /// Create a copy of Group
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? deletionDate = freezed,
    Object? tags = null,
    Object? publicTags = null,
    Object? name = freezed,
    Object? password = freezed,
    Object? servers = freezed,
    Object? superAdmin = null,
    Object? properties = null,
    Object? defaultUserRoles = null,
    Object? operationTokens = null,
    Object? sharedEntities = null,
    Object? minimumKrakenVersion = freezed,
    Object? externalJwtConfig = null,
    Object? minimumAuthenticationClassForElevatedPrivileges = null,
    Object? superGroup = freezed,
    Object? projectId = freezed,
  }) {
    return _then(_Group(
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
      tags: null == tags
          ? _self._tags
          : tags // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      publicTags: null == publicTags
          ? _self._publicTags
          : publicTags // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      password: freezed == password
          ? _self.password
          : password // ignore: cast_nullable_to_non_nullable
              as String?,
      servers: freezed == servers
          ? _self._servers
          : servers // ignore: cast_nullable_to_non_nullable
              as List<String>?,
      superAdmin: null == superAdmin
          ? _self.superAdmin
          : superAdmin // ignore: cast_nullable_to_non_nullable
              as bool,
      properties: null == properties
          ? _self._properties
          : properties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>,
      defaultUserRoles: null == defaultUserRoles
          ? _self._defaultUserRoles
          : defaultUserRoles // ignore: cast_nullable_to_non_nullable
              as Map<UserType, Set<String>>,
      operationTokens: null == operationTokens
          ? _self._operationTokens
          : operationTokens // ignore: cast_nullable_to_non_nullable
              as Map<String, OperationToken>,
      sharedEntities: null == sharedEntities
          ? _self._sharedEntities
          : sharedEntities // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      minimumKrakenVersion: freezed == minimumKrakenVersion
          ? _self.minimumKrakenVersion
          : minimumKrakenVersion // ignore: cast_nullable_to_non_nullable
              as String?,
      externalJwtConfig: null == externalJwtConfig
          ? _self._externalJwtConfig
          : externalJwtConfig // ignore: cast_nullable_to_non_nullable
              as Map<String, ExternalJwtConfig>,
      minimumAuthenticationClassForElevatedPrivileges: null ==
              minimumAuthenticationClassForElevatedPrivileges
          ? _self.minimumAuthenticationClassForElevatedPrivileges
          : minimumAuthenticationClassForElevatedPrivileges // ignore: cast_nullable_to_non_nullable
              as AuthenticationClass,
      superGroup: freezed == superGroup
          ? _self.superGroup
          : superGroup // ignore: cast_nullable_to_non_nullable
              as String?,
      projectId: freezed == projectId
          ? _self.projectId
          : projectId // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

// dart format on
