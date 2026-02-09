// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'calendar_item_tag.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$EncryptedCalendarItemTag {
  String? get code;
  int? get date;
  String? get userId;
  String? get userName;
  Base64String? get encryptedSelf;

  /// Create a copy of EncryptedCalendarItemTag
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedCalendarItemTagCopyWith<EncryptedCalendarItemTag> get copyWith =>
      _$EncryptedCalendarItemTagCopyWithImpl<EncryptedCalendarItemTag>(
          this as EncryptedCalendarItemTag, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedCalendarItemTag &&
            (identical(other.code, code) || other.code == code) &&
            (identical(other.date, date) || other.date == date) &&
            (identical(other.userId, userId) || other.userId == userId) &&
            (identical(other.userName, userName) ||
                other.userName == userName) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, code, date, userId, userName, encryptedSelf);

  @override
  String toString() {
    return 'EncryptedCalendarItemTag(code: $code, date: $date, userId: $userId, userName: $userName, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $EncryptedCalendarItemTagCopyWith<$Res> {
  factory $EncryptedCalendarItemTagCopyWith(EncryptedCalendarItemTag value,
          $Res Function(EncryptedCalendarItemTag) _then) =
      _$EncryptedCalendarItemTagCopyWithImpl;
  @useResult
  $Res call(
      {String? code,
      int? date,
      String? userId,
      String? userName,
      Base64String? encryptedSelf});
}

/// @nodoc
class _$EncryptedCalendarItemTagCopyWithImpl<$Res>
    implements $EncryptedCalendarItemTagCopyWith<$Res> {
  _$EncryptedCalendarItemTagCopyWithImpl(this._self, this._then);

  final EncryptedCalendarItemTag _self;
  final $Res Function(EncryptedCalendarItemTag) _then;

  /// Create a copy of EncryptedCalendarItemTag
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? code = freezed,
    Object? date = freezed,
    Object? userId = freezed,
    Object? userName = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      code: freezed == code
          ? _self.code
          : code // ignore: cast_nullable_to_non_nullable
              as String?,
      date: freezed == date
          ? _self.date
          : date // ignore: cast_nullable_to_non_nullable
              as int?,
      userId: freezed == userId
          ? _self.userId
          : userId // ignore: cast_nullable_to_non_nullable
              as String?,
      userName: freezed == userName
          ? _self.userName
          : userName // ignore: cast_nullable_to_non_nullable
              as String?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc

class _EncryptedCalendarItemTag implements EncryptedCalendarItemTag {
  const _EncryptedCalendarItemTag(
      {this.code = null,
      this.date = null,
      this.userId = null,
      this.userName = null,
      this.encryptedSelf = null});

  @override
  @JsonKey()
  final String? code;
  @override
  @JsonKey()
  final int? date;
  @override
  @JsonKey()
  final String? userId;
  @override
  @JsonKey()
  final String? userName;
  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of EncryptedCalendarItemTag
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedCalendarItemTagCopyWith<_EncryptedCalendarItemTag> get copyWith =>
      __$EncryptedCalendarItemTagCopyWithImpl<_EncryptedCalendarItemTag>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedCalendarItemTag &&
            (identical(other.code, code) || other.code == code) &&
            (identical(other.date, date) || other.date == date) &&
            (identical(other.userId, userId) || other.userId == userId) &&
            (identical(other.userName, userName) ||
                other.userName == userName) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, code, date, userId, userName, encryptedSelf);

  @override
  String toString() {
    return 'EncryptedCalendarItemTag(code: $code, date: $date, userId: $userId, userName: $userName, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedCalendarItemTagCopyWith<$Res>
    implements $EncryptedCalendarItemTagCopyWith<$Res> {
  factory _$EncryptedCalendarItemTagCopyWith(_EncryptedCalendarItemTag value,
          $Res Function(_EncryptedCalendarItemTag) _then) =
      __$EncryptedCalendarItemTagCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String? code,
      int? date,
      String? userId,
      String? userName,
      Base64String? encryptedSelf});
}

/// @nodoc
class __$EncryptedCalendarItemTagCopyWithImpl<$Res>
    implements _$EncryptedCalendarItemTagCopyWith<$Res> {
  __$EncryptedCalendarItemTagCopyWithImpl(this._self, this._then);

  final _EncryptedCalendarItemTag _self;
  final $Res Function(_EncryptedCalendarItemTag) _then;

  /// Create a copy of EncryptedCalendarItemTag
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? code = freezed,
    Object? date = freezed,
    Object? userId = freezed,
    Object? userName = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_EncryptedCalendarItemTag(
      code: freezed == code
          ? _self.code
          : code // ignore: cast_nullable_to_non_nullable
              as String?,
      date: freezed == date
          ? _self.date
          : date // ignore: cast_nullable_to_non_nullable
              as int?,
      userId: freezed == userId
          ? _self.userId
          : userId // ignore: cast_nullable_to_non_nullable
              as String?,
      userName: freezed == userName
          ? _self.userName
          : userName // ignore: cast_nullable_to_non_nullable
              as String?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc
mixin _$DecryptedCalendarItemTag {
  String? get code;
  int? get date;
  String? get userId;
  String? get userName;
  Base64String? get encryptedSelf;

  /// Create a copy of DecryptedCalendarItemTag
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedCalendarItemTagCopyWith<DecryptedCalendarItemTag> get copyWith =>
      _$DecryptedCalendarItemTagCopyWithImpl<DecryptedCalendarItemTag>(
          this as DecryptedCalendarItemTag, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedCalendarItemTag &&
            (identical(other.code, code) || other.code == code) &&
            (identical(other.date, date) || other.date == date) &&
            (identical(other.userId, userId) || other.userId == userId) &&
            (identical(other.userName, userName) ||
                other.userName == userName) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, code, date, userId, userName, encryptedSelf);

  @override
  String toString() {
    return 'DecryptedCalendarItemTag(code: $code, date: $date, userId: $userId, userName: $userName, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $DecryptedCalendarItemTagCopyWith<$Res> {
  factory $DecryptedCalendarItemTagCopyWith(DecryptedCalendarItemTag value,
          $Res Function(DecryptedCalendarItemTag) _then) =
      _$DecryptedCalendarItemTagCopyWithImpl;
  @useResult
  $Res call(
      {String? code,
      int? date,
      String? userId,
      String? userName,
      Base64String? encryptedSelf});
}

/// @nodoc
class _$DecryptedCalendarItemTagCopyWithImpl<$Res>
    implements $DecryptedCalendarItemTagCopyWith<$Res> {
  _$DecryptedCalendarItemTagCopyWithImpl(this._self, this._then);

  final DecryptedCalendarItemTag _self;
  final $Res Function(DecryptedCalendarItemTag) _then;

  /// Create a copy of DecryptedCalendarItemTag
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? code = freezed,
    Object? date = freezed,
    Object? userId = freezed,
    Object? userName = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      code: freezed == code
          ? _self.code
          : code // ignore: cast_nullable_to_non_nullable
              as String?,
      date: freezed == date
          ? _self.date
          : date // ignore: cast_nullable_to_non_nullable
              as int?,
      userId: freezed == userId
          ? _self.userId
          : userId // ignore: cast_nullable_to_non_nullable
              as String?,
      userName: freezed == userName
          ? _self.userName
          : userName // ignore: cast_nullable_to_non_nullable
              as String?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc

class _DecryptedCalendarItemTag implements DecryptedCalendarItemTag {
  const _DecryptedCalendarItemTag(
      {this.code = null,
      this.date = null,
      this.userId = null,
      this.userName = null,
      this.encryptedSelf = null});

  @override
  @JsonKey()
  final String? code;
  @override
  @JsonKey()
  final int? date;
  @override
  @JsonKey()
  final String? userId;
  @override
  @JsonKey()
  final String? userName;
  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of DecryptedCalendarItemTag
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedCalendarItemTagCopyWith<_DecryptedCalendarItemTag> get copyWith =>
      __$DecryptedCalendarItemTagCopyWithImpl<_DecryptedCalendarItemTag>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedCalendarItemTag &&
            (identical(other.code, code) || other.code == code) &&
            (identical(other.date, date) || other.date == date) &&
            (identical(other.userId, userId) || other.userId == userId) &&
            (identical(other.userName, userName) ||
                other.userName == userName) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, code, date, userId, userName, encryptedSelf);

  @override
  String toString() {
    return 'DecryptedCalendarItemTag(code: $code, date: $date, userId: $userId, userName: $userName, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedCalendarItemTagCopyWith<$Res>
    implements $DecryptedCalendarItemTagCopyWith<$Res> {
  factory _$DecryptedCalendarItemTagCopyWith(_DecryptedCalendarItemTag value,
          $Res Function(_DecryptedCalendarItemTag) _then) =
      __$DecryptedCalendarItemTagCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String? code,
      int? date,
      String? userId,
      String? userName,
      Base64String? encryptedSelf});
}

/// @nodoc
class __$DecryptedCalendarItemTagCopyWithImpl<$Res>
    implements _$DecryptedCalendarItemTagCopyWith<$Res> {
  __$DecryptedCalendarItemTagCopyWithImpl(this._self, this._then);

  final _DecryptedCalendarItemTag _self;
  final $Res Function(_DecryptedCalendarItemTag) _then;

  /// Create a copy of DecryptedCalendarItemTag
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? code = freezed,
    Object? date = freezed,
    Object? userId = freezed,
    Object? userName = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_DecryptedCalendarItemTag(
      code: freezed == code
          ? _self.code
          : code // ignore: cast_nullable_to_non_nullable
              as String?,
      date: freezed == date
          ? _self.date
          : date // ignore: cast_nullable_to_non_nullable
              as int?,
      userId: freezed == userId
          ? _self.userId
          : userId // ignore: cast_nullable_to_non_nullable
              as String?,
      userName: freezed == userName
          ? _self.userName
          : userName // ignore: cast_nullable_to_non_nullable
              as String?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

// dart format on
