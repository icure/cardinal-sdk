# customised-sdk-resources

Non-IR inputs to the `@icure/cardinal-sdk-generator-meta` npm package, which the customised sdk
generator (`icure/sdk-codegen`) reads to target this version of cardinal.

These are tracked by hand; the IR itself is not, it comes from `:cardinal-sdk:kspKotlinJvm`.

| File | Goes to | Purpose |
|------|---------|---------|
| `generator-compatibility.json` | merged into `codegen-meta.json` | Oldest generator that can target this sdk version, and the oldest we recommend. |

Any other file dropped in here is copied to the package root as is, and listed in the package's `files`
automatically.

There is deliberately **no default model configuration here**, even though a sensible default model
exists. A model is a property of a *project*, not of this codebase, and the cockpit has to be its source
of truth: a model registered there can have its changes validated - that migrations are viable, and so
on - before they are adopted. Shipping one for users to copy locally would bypass that, so the generator
requires a model downloaded from the cockpit and fails when there is none.

`cardinalSdkVersion` is **not** tracked here - it is taken from the `:cardinal-sdk` gradle module
version so the two can never drift.

Build the package with:

    ./gradlew :ts-wrapper:prepareCodegenMetaPackage

## Compatibility semantics

- Generator older than `minimumRequiredGeneratorVersion` -> hard error, it cannot target this sdk.
- Generator between required and `minimumRecommendedGeneratorVersion` -> warning, generation proceeds.
- Both are placeholders at `0.0.0` while the generator is pre-release.
