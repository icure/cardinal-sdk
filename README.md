## Using the project
## Using the project
## Using the project

You need to create a local properties file in the root of the project with the following properties:

```properties
# Path to the android sdk, by default on mac /Users/you/Library/Android/sdk
sdk.dir=/path/to/android/sdk
# Name of ios simulator to use for testing, e.g. iPhone 13 Pro Max
ios.simulator=iPhone name
```

## Testing

Unit tests can run on all target platforms (jvm, js browser, js node, ios, android) using the various gradle `[platform]Test` tasks, or using the `allTests` task.

E2e tests are currently only available on the jvm platform, as the test setup library is not yet available for the other platforms.

### Browser tests

Currently the project is configured to do browser tests on Chrome and Firefox. You will need to have the browsers installed on your machine.

You may also need to specify the location of their executables through environment variables, such as:

```
FIREFOX_BIN=/Applications/Firefox.app/Contents/MacOS/firefox
```

## Modules

### `icure-sdk`

The actual iCure sdk implementation. Usable as is from other kotlin (multiplatform or java/android) projects.

In addition to this implementation there are wrappers to allow using it from other languages.

### `kryptom` - kotlin crypto multiplatform

Implementation of cryptographic primitives for kotlin multiplatform.

Moved to [icure/kryptom](https://github.com/icure/kryptom).

### `sdk-codegen`

Used to generate (part of) the wrappers for non-kotlin languages.

### `ts-wrapper`

Wrapper for using the multiplatform sdk from pure typescript.

## Notes

With multiple modules the yarn lock may have some issues...
https://youtrack.jetbrains.com/issue/KT-55701/KJS-Gradle-kotlinUpgradeYarnLock-and-kotlinStoreYarnLock-dont-support-configureondemand-if-building-one-module-only
