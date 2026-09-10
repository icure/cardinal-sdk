#!/usr/bin/env python3
"""
Entry point of the python SDK tests.

Run with `python3 tests.py` after installing the SDK (`pip install cardinal_sdk-*.whl`). All the
configuration is passed through environment variables, see README.md.

Usage:
    python3 tests.py                       # runs everything
    python3 tests.py test_patient          # runs a single module
    python3 tests.py test_patient.PatientTest.test_modify_patient
"""
import os
import sys
import unittest

import cardinal_test_env

TEST_DIR = os.path.dirname(os.path.abspath(__file__))


def build_suite(names: list[str]) -> unittest.TestSuite:
	loader = unittest.TestLoader()
	if names:
		return loader.loadTestsFromNames(names)
	return loader.discover(start_dir=TEST_DIR, pattern="test_*.py", top_level_dir=TEST_DIR)


def main(argv: list[str]) -> int:
	sys.path.insert(0, TEST_DIR)
	try:
		cardinal_test_env.check_configuration()
	except EnvironmentError as e:
		print(f"Invalid test configuration: {e}\nSee {os.path.join(TEST_DIR, 'README.md')}", file=sys.stderr)
		return 2
	print(f"Running the python SDK tests against {cardinal_test_env.cardinal_url()}")
	verbosity = 1 if os.environ.get("CARDINAL_TEST_QUIET") else 2
	result = unittest.TextTestRunner(verbosity=verbosity).run(build_suite(argv))
	return 0 if result.wasSuccessful() else 1


if __name__ == "__main__":
	sys.exit(main(sys.argv[1:]))
