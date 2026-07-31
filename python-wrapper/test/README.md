# Python SDK tests

Tests for the python wrapper, run on the CI by `.github/workflows/test_python.yml`.

They run against an **already existing environment** with **already existing users**: the tests never
create groups or users, and all the connection parameters come from environment variables (secrets on
the CI).

These tests are **not** part of the published package: the wheel is assembled from `src/python` only
(see `prepareDistributionArchive` in `python-wrapper/build.gradle.kts`), so nothing in this directory
ever reaches the distribution.

## Running them

```bash
# from the repository root: build the wheel for the host platform, e.g. on linux
./gradlew :python-wrapper:linkReleaseSharedLinuxX64 :python-wrapper:prepareLinuxX64DistributionArchive

python3 -m pip install python-wrapper/src/commonMain/resources/dist/cardinal_sdk-*.whl
python3 -m pip install -r python-wrapper/test/requirements.txt

cd python-wrapper/test
export CARDINAL_URL=https://nightly.icure.cloud
export CARDINAL_USER_1_USERNAME=...
export CARDINAL_USER_1_PASSWORD=...
python3 tests.py
```

A subset can be run by passing test names:

```bash
python3 tests.py test_patient
python3 tests.py test_patient.PatientTest.test_modify_patient
```

## Configuration

| Variable | Required | Description |
| --- | --- | --- |
| `CARDINAL_URL` | yes | Url of the environment to test against |
| `CARDINAL_USER_1_USERNAME` | yes | Username of the data owner used by all the tests |
| `CARDINAL_USER_1_PASSWORD` | one of the two | Password of that user |
| `CARDINAL_USER_1_TOKEN` | one of the two | Long-lived token of that user, used instead of the password |
| `CARDINAL_USER_2_USERNAME` | no | Username of a second, different data owner. Without it the tests of `test_sharing.py` are skipped |
| `CARDINAL_USER_2_PASSWORD` | no | Password of the second user |
| `CARDINAL_USER_2_TOKEN` | no | Long-lived token of the second user |
| `CARDINAL_KEYS_DIR` | no | Directory where the SDK keys are stored, `keys` by default. One subdirectory per user |
| `CARDINAL_TEST_QUIET` | no | Set to any value to reduce the output verbosity |

On the CI these are provided by the `CARDINAL_TEST_*` repository secrets, see the workflow.

Note that when the keys directory does not already contain a key for a user, the SDK generates a new
one and registers it on the data owner. This is fine for the tests, which only ever read back the
data they created themselves, but it does mean that every run from a clean checkout adds a key to the
users. Point `CARDINAL_KEYS_DIR` at a persistent directory to avoid it.

## Structure

- `tests.py` — entry point: validates the configuration, discovers and runs the test modules,
  exits with a non-zero status on failure.
- `cardinal_test_env.py` — configuration from the environment and SDK instantiation (one SDK per
  user, created once per run).
- `cardinal_test_case.py` — base test case and helpers to create entities. The entities created by
  the helpers are deleted at the end of the test that created them, since the environment is shared
  and long-lived.
- `test_*.py` — the tests themselves.
