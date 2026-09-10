# Typescript SDK tests

Tests for the typescript wrapper, run on the CI by `.github/workflows/test_typescript.yml`. They are
the typescript counterpart of `python-wrapper/test`, and cover the same scenarios.

They run against an **already existing environment** with **already existing users**: the tests never
create groups or users, and all the connection parameters come from environment variables (secrets on
the CI).

These tests are **not** part of the published package: the package is assembled from
`src/jsMain/typescript` and the compiled kotlin sources only (see `prepareDistributionPackage` in
`ts-wrapper/build.gradle.kts`), so nothing in this directory ever reaches the distribution.

## Running them

```bash
# from the repository root: build the distribution package (requires `tsc` in the path)
./gradlew :ts-wrapper:prepareDistributionPackage
npm pack --pack-destination "$PWD/ts-wrapper/build/tsDistribution" ./ts-wrapper/build/tsPackage

cd ts-wrapper/test
npm install                                            # the test dev dependencies
npm install --no-save ../build/tsDistribution/icure-cardinal-sdk-*.tgz
npm run build                                          # compiles the tests with tsc

export CARDINAL_URL=https://nightly.icure.cloud
export CARDINAL_USER_1_USERNAME=...
export CARDINAL_USER_1_PASSWORD=...
npm test
```

The SDK is installed from the packed tarball rather than referenced as a `file:` dependency on
purpose: a `file:` dependency is symlinked, and node resolves the real path of a symlink, so the
transitive dependencies of the package (`ws`, `@js-joda/core`) would not be resolvable from it.

A subset can be run by passing module names:

```bash
npm test -- patient
npm test -- patient sharing
CARDINAL_TEST_NAME_PATTERN='modify a patient' npm test -- patient
```

## Configuration

| Variable | Required | Description |
| --- | --- | --- |
| `CARDINAL_URL` | yes | Url of the environment to test against |
| `CARDINAL_USER_1_USERNAME` | yes | Username of the data owner used by all the tests |
| `CARDINAL_USER_1_PASSWORD` | one of the two | Password of that user |
| `CARDINAL_USER_1_TOKEN` | one of the two | Long-lived token of that user, used instead of the password |
| `CARDINAL_USER_2_USERNAME` | no | Username of a second, different data owner. Without it the tests of `sharing.test.mts` are skipped |
| `CARDINAL_USER_2_PASSWORD` | no | Password of the second user |
| `CARDINAL_USER_2_TOKEN` | no | Long-lived token of the second user |
| `CARDINAL_KEYS_DIR` | no | Directory where the SDK keys are stored, `keys` by default. One subdirectory per user |
| `CARDINAL_TEST_NAME_PATTERN` | no | Only run the tests whose name matches this pattern |
| `CARDINAL_TEST_REPORTER` | no | Reporter passed to `node --test`, `spec` by default |

On the CI these are provided by the `CARDINAL_TEST_*` repository secrets, see the workflow. They are
the same variables and the same secrets used by the python tests, and the keys directory uses the
same layout (one subdirectory per user, named after the sanitized username), so the two suites can
share the seeded keys.

Note that when the keys directory does not already contain a key for a user, the SDK generates a new
one and registers it on the data owner. This is fine for the tests, which only ever read back the
data they created themselves, but it does mean that every run from a clean checkout adds a key to the
users. Point `CARDINAL_KEYS_DIR` at a persistent directory to avoid it.

## Structure

- `run.mjs` — entry point: validates the configuration, discovers the compiled test modules, runs
  them through `node --test`, exits with a non-zero status on failure.
- `src/cardinalTestEnv.mts` — configuration from the environment and SDK instantiation (one SDK per
  user, created once per run, closed at the end of the run).
- `src/cardinalTestCase.mts` — `cardinalTest`, the wrapper around `node:test`'s `it` that provides
  the SDK and the helpers to create entities, plus the shared assertions. The entities created by
  the helpers are deleted at the end of the test that created them, since the environment is shared
  and long-lived.
- `src/*.test.mts` — the tests themselves.

Unlike the python SDK, the typescript SDK holds an open http client and must be closed explicitly,
otherwise the node process never exits. `cardinalTestCase.mts` registers a root-level `after` hook
that closes every SDK created by the file; since `node --test` runs each file in its own process,
that is enough.
