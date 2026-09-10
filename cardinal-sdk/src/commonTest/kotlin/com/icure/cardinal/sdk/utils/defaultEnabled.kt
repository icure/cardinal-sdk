package com.icure.cardinal.sdk.utils

import com.icure.cardinal.sdk.test.isCanaryTestMode
import com.icure.cardinal.sdk.test.isLocalTestMode

/**
 * All tests should be enabled using this flag && optionalOtherConditions.
 * On js we don't have a way of running some specific tests, so if we are working on some particular issue it is easier
 * to disable all tests except the one we are working on by changing this flag to `false`.
 */
const val DEFAULT_ENABLED = true

/**
 * Tests that can only run against the local docker environment, because it is the only disposable one:
 * everywhere else the tests run against a shared, long-lived environment with a fixed set of users (see
 * `preConfiguredHcpUsers`), which they must not modify.
 *
 * Combine it with [DEFAULT_ENABLED] on every test that:
 * - creates a data owner other than the pre-configured healthcare party users, or a group;
 * - modifies one of the pre-configured users, including its keys;
 * - needs more than two distinct data owners;
 * - needs an advanced authentication setup (external authentication, smart authentication, the mock
 *   message gateway).
 */
val LOCAL_ENV_ONLY = isLocalTestMode

/**
 * Tests that should be skipped when running in `canary` mode (`TEST_MODE=canary`). `canary` sets up
 * its environment (docker, groups, hcps, patients, ...) exactly like `local` - so it must never be
 * combined with [LOCAL_ENV_ONLY] on the tests that actually perform that setup - but it is meant to
 * run a reduced subset of the suite. Combine this flag with [DEFAULT_ENABLED] (and [LOCAL_ENV_ONLY]
 * if applicable) on any test that should be excluded from a canary run, for example because it is
 * slow, flaky, or redundant with another test that already covers the important behavior.
 */
val SKIP_IN_CANARY = !isCanaryTestMode