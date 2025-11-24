package com.icure.cardinal.sdk.utils

/**
 * All tests should be enabled using this flag && optionalOtherConditions.
 * On js we don't have a way of running some specific tests, so if we are working on some particular issue it is easier
 * to disable all tests except the one we are working on by changing this flag to `false`.
 */
const val DEFAULT_ENABLED = true