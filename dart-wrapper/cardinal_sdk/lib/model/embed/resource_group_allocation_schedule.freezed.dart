// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'resource_group_allocation_schedule.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$ResourceGroupAllocationSchedule {
  CodeStub? get resourceGroup;
  Set<CodeStub> get tags;
  Set<CodeStub> get codes;
  String? get name;
  int? get startDateTime;
  int? get endDateTime;
  List<EmbeddedTimeTableItem> get items;

  /// Create a copy of ResourceGroupAllocationSchedule
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $ResourceGroupAllocationScheduleCopyWith<ResourceGroupAllocationSchedule>
      get copyWith => _$ResourceGroupAllocationScheduleCopyWithImpl<
              ResourceGroupAllocationSchedule>(
          this as ResourceGroupAllocationSchedule, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is ResourceGroupAllocationSchedule &&
            (identical(other.resourceGroup, resourceGroup) ||
                other.resourceGroup == resourceGroup) &&
            const DeepCollectionEquality().equals(other.tags, tags) &&
            const DeepCollectionEquality().equals(other.codes, codes) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.startDateTime, startDateTime) ||
                other.startDateTime == startDateTime) &&
            (identical(other.endDateTime, endDateTime) ||
                other.endDateTime == endDateTime) &&
            const DeepCollectionEquality().equals(other.items, items));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      resourceGroup,
      const DeepCollectionEquality().hash(tags),
      const DeepCollectionEquality().hash(codes),
      name,
      startDateTime,
      endDateTime,
      const DeepCollectionEquality().hash(items));

  @override
  String toString() {
    return 'ResourceGroupAllocationSchedule(resourceGroup: $resourceGroup, tags: $tags, codes: $codes, name: $name, startDateTime: $startDateTime, endDateTime: $endDateTime, items: $items)';
  }
}

/// @nodoc
abstract mixin class $ResourceGroupAllocationScheduleCopyWith<$Res> {
  factory $ResourceGroupAllocationScheduleCopyWith(
          ResourceGroupAllocationSchedule value,
          $Res Function(ResourceGroupAllocationSchedule) _then) =
      _$ResourceGroupAllocationScheduleCopyWithImpl;
  @useResult
  $Res call(
      {CodeStub? resourceGroup,
      Set<CodeStub> tags,
      Set<CodeStub> codes,
      String? name,
      int? startDateTime,
      int? endDateTime,
      List<EmbeddedTimeTableItem> items});

  $CodeStubCopyWith<$Res>? get resourceGroup;
}

/// @nodoc
class _$ResourceGroupAllocationScheduleCopyWithImpl<$Res>
    implements $ResourceGroupAllocationScheduleCopyWith<$Res> {
  _$ResourceGroupAllocationScheduleCopyWithImpl(this._self, this._then);

  final ResourceGroupAllocationSchedule _self;
  final $Res Function(ResourceGroupAllocationSchedule) _then;

  /// Create a copy of ResourceGroupAllocationSchedule
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? resourceGroup = freezed,
    Object? tags = null,
    Object? codes = null,
    Object? name = freezed,
    Object? startDateTime = freezed,
    Object? endDateTime = freezed,
    Object? items = null,
  }) {
    return _then(_self.copyWith(
      resourceGroup: freezed == resourceGroup
          ? _self.resourceGroup
          : resourceGroup // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      tags: null == tags
          ? _self.tags
          : tags // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      codes: null == codes
          ? _self.codes
          : codes // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      startDateTime: freezed == startDateTime
          ? _self.startDateTime
          : startDateTime // ignore: cast_nullable_to_non_nullable
              as int?,
      endDateTime: freezed == endDateTime
          ? _self.endDateTime
          : endDateTime // ignore: cast_nullable_to_non_nullable
              as int?,
      items: null == items
          ? _self.items
          : items // ignore: cast_nullable_to_non_nullable
              as List<EmbeddedTimeTableItem>,
    ));
  }

  /// Create a copy of ResourceGroupAllocationSchedule
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get resourceGroup {
    if (_self.resourceGroup == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.resourceGroup!, (value) {
      return _then(_self.copyWith(resourceGroup: value));
    });
  }
}

/// @nodoc

class _ResourceGroupAllocationSchedule
    implements ResourceGroupAllocationSchedule {
  const _ResourceGroupAllocationSchedule(
      {this.resourceGroup = null,
      final Set<CodeStub> tags = const {},
      final Set<CodeStub> codes = const {},
      this.name = null,
      this.startDateTime = null,
      this.endDateTime = null,
      final List<EmbeddedTimeTableItem> items = const []})
      : _tags = tags,
        _codes = codes,
        _items = items;

  @override
  @JsonKey()
  final CodeStub? resourceGroup;
  final Set<CodeStub> _tags;
  @override
  @JsonKey()
  Set<CodeStub> get tags {
    if (_tags is EqualUnmodifiableSetView) return _tags;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_tags);
  }

  final Set<CodeStub> _codes;
  @override
  @JsonKey()
  Set<CodeStub> get codes {
    if (_codes is EqualUnmodifiableSetView) return _codes;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_codes);
  }

  @override
  @JsonKey()
  final String? name;
  @override
  @JsonKey()
  final int? startDateTime;
  @override
  @JsonKey()
  final int? endDateTime;
  final List<EmbeddedTimeTableItem> _items;
  @override
  @JsonKey()
  List<EmbeddedTimeTableItem> get items {
    if (_items is EqualUnmodifiableListView) return _items;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_items);
  }

  /// Create a copy of ResourceGroupAllocationSchedule
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$ResourceGroupAllocationScheduleCopyWith<_ResourceGroupAllocationSchedule>
      get copyWith => __$ResourceGroupAllocationScheduleCopyWithImpl<
          _ResourceGroupAllocationSchedule>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _ResourceGroupAllocationSchedule &&
            (identical(other.resourceGroup, resourceGroup) ||
                other.resourceGroup == resourceGroup) &&
            const DeepCollectionEquality().equals(other._tags, _tags) &&
            const DeepCollectionEquality().equals(other._codes, _codes) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.startDateTime, startDateTime) ||
                other.startDateTime == startDateTime) &&
            (identical(other.endDateTime, endDateTime) ||
                other.endDateTime == endDateTime) &&
            const DeepCollectionEquality().equals(other._items, _items));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      resourceGroup,
      const DeepCollectionEquality().hash(_tags),
      const DeepCollectionEquality().hash(_codes),
      name,
      startDateTime,
      endDateTime,
      const DeepCollectionEquality().hash(_items));

  @override
  String toString() {
    return 'ResourceGroupAllocationSchedule(resourceGroup: $resourceGroup, tags: $tags, codes: $codes, name: $name, startDateTime: $startDateTime, endDateTime: $endDateTime, items: $items)';
  }
}

/// @nodoc
abstract mixin class _$ResourceGroupAllocationScheduleCopyWith<$Res>
    implements $ResourceGroupAllocationScheduleCopyWith<$Res> {
  factory _$ResourceGroupAllocationScheduleCopyWith(
          _ResourceGroupAllocationSchedule value,
          $Res Function(_ResourceGroupAllocationSchedule) _then) =
      __$ResourceGroupAllocationScheduleCopyWithImpl;
  @override
  @useResult
  $Res call(
      {CodeStub? resourceGroup,
      Set<CodeStub> tags,
      Set<CodeStub> codes,
      String? name,
      int? startDateTime,
      int? endDateTime,
      List<EmbeddedTimeTableItem> items});

  @override
  $CodeStubCopyWith<$Res>? get resourceGroup;
}

/// @nodoc
class __$ResourceGroupAllocationScheduleCopyWithImpl<$Res>
    implements _$ResourceGroupAllocationScheduleCopyWith<$Res> {
  __$ResourceGroupAllocationScheduleCopyWithImpl(this._self, this._then);

  final _ResourceGroupAllocationSchedule _self;
  final $Res Function(_ResourceGroupAllocationSchedule) _then;

  /// Create a copy of ResourceGroupAllocationSchedule
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? resourceGroup = freezed,
    Object? tags = null,
    Object? codes = null,
    Object? name = freezed,
    Object? startDateTime = freezed,
    Object? endDateTime = freezed,
    Object? items = null,
  }) {
    return _then(_ResourceGroupAllocationSchedule(
      resourceGroup: freezed == resourceGroup
          ? _self.resourceGroup
          : resourceGroup // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      tags: null == tags
          ? _self._tags
          : tags // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      codes: null == codes
          ? _self._codes
          : codes // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      startDateTime: freezed == startDateTime
          ? _self.startDateTime
          : startDateTime // ignore: cast_nullable_to_non_nullable
              as int?,
      endDateTime: freezed == endDateTime
          ? _self.endDateTime
          : endDateTime // ignore: cast_nullable_to_non_nullable
              as int?,
      items: null == items
          ? _self._items
          : items // ignore: cast_nullable_to_non_nullable
              as List<EmbeddedTimeTableItem>,
    ));
  }

  /// Create a copy of ResourceGroupAllocationSchedule
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get resourceGroup {
    if (_self.resourceGroup == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.resourceGroup!, (value) {
      return _then(_self.copyWith(resourceGroup: value));
    });
  }
}

// dart format on
