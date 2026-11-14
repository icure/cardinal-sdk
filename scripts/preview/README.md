# Local preview of the Cardinal SDK on npm.icure.cloud

These scripts build the TypeScript Cardinal SDK from a local `kraken-cloud` checkout and publish it on
`npm.icure.cloud` as a preview. Uncommitted changes in `kraken-cloud` are included. You don't need a release or any
pull request.

In CI, the same result takes several workflows and pull requests:

1. `kraken-cloud` `.github/workflows/generate.yml` generates the models, the raw APIs and the filter serializer, and
   opens a PR in this repository.
2. Once that is merged, `.github/workflows/generate_typescript.yml` regenerates the TypeScript wrapper in another PR.
3. A release PR is merged, and the-forge builds and publishes the packages.

The scripts run the same steps locally, in a temporary git worktree of this repository. Your checkouts are not
modified: `kraken-cloud` is only built, and generated code goes to the worktree.

## Running the script

Run every command from the root of your `cardinal-multiplatform-sdk` checkout. By default the script expects
`kraken-cloud` next to it:

```
icure/
├── cardinal-multiplatform-sdk/   ← run from here
└── kraken-cloud/                 ← generated from, as it is on disk (--kraken-dir to use another checkout)
```

### 1. Get the scripts

Nothing to do if your checkout already contains `scripts/preview/`. Otherwise, for example on a branch created
before the scripts were merged, check them out next to your work without touching it:

```bash
git fetch origin
git worktree add ../cardinal-sdk-preview-tools origin/main   # or the branch that has scripts/preview
alias publish-preview=../cardinal-sdk-preview-tools/scripts/preview/publish-preview.sh
```

The scripts don't depend on the branch you have checked out. They always build the SDK at `--sdk-ref`, in a separate
worktree. In the commands below, `scripts/preview/publish-preview.sh` and `publish-preview` are interchangeable.

### 2. Credentials

```bash
export ICURE_NPM_USERNAME=…  ICURE_NPM_PASSWORD=…   # npm.icure.cloud account
gh auth status                                      # needs access to icure/sdk-codegen
grep -c '^github' local.properties                  # githubUsername / githubPassword: should print 2
```

### 3. Dry run

The dry run builds everything and runs `npm publish --dry-run`. Pick a version (see
[Choosing the version](#choosing-the-version)) and an SDK base matching the `kraken-cloud` branch:

```bash
V=2.15.0-PREVIEW.$(date +%Y%m%d%H%M); echo "$V"     # note it: the publication must use the same version

# kraken-cloud on main: the SDK base is develop (the default)
scripts/preview/publish-preview.sh --version "$V" --dry-run

# kraken-cloud on another branch: the matching SDK branch, and the codegen it needs, for example
scripts/preview/publish-preview.sh --version 3.0.0-PREVIEW.$(date +%Y%m%d%H%M) \
	--sdk-ref origin/release/v3 --codegen-version 2.1.0 --wrapper-codegen-version 2.1.0 --dry-run
```

A full run takes 15 to 30 minutes. Most of the time is spent building `kraken-cloud` (KSP) and the Kotlin/JS SDK. The
run directory is `~/.cache/cardinal-preview/runs/<version>`. The generated changes are committed in its `sdk/`
worktree:

```bash
git -C ~/.cache/cardinal-preview/runs/$V/sdk log --stat -3
```

### 4. Publish

Resume the same run at the `publish` stage, with the same version and options, without `--dry-run`. The script
asks you to type the version to confirm:

```bash
scripts/preview/publish-preview.sh --version "$V" --from publish        # plus the --sdk-ref/codegen options used above
```

### 5. Resume or clean up

- After a failure, fix the cause and resume at the failed stage (`--from kraken`, `--from ts` or `--from publish`) with
  the same version. You can change options such as the codegen versions when you resume.
- When you no longer need the run: `scripts/preview/cleanup.sh ~/.cache/cardinal-preview/runs/$V`.
- `scripts/preview/publish-preview.sh --help` lists every option.

Consumers install the preview with:

```bash
npm install @icure/cardinal-sdk@2.15.0-PREVIEW.202611141030 --registry https://npm.icure.cloud
```

## Choosing the version

- The version must be `X.Y.Z-PREVIEW.N`, the format accepted by `buildSrc/src/main/kotlin/ReleaseVersion.kt`.
- the-forge publishes the official previews of each release (`2.15.0-PREVIEW.1`, `.2`, …) **on the same registry and
  package name**. A version you publish here can never be published again, so taking an official number would make
  the official release fail. Use a timestamp for `N`, e.g. `2.15.0-PREVIEW.202611141030`, and for `X.Y.Z` the next
  full release.
- The scripts refuse a version that already exists on the registry.
- The package gets the `preview` dist-tag (`--dist-tag` to change it; `latest` is refused). A timestamped preview
  sorts above the official previews of the same `X.Y.Z`, so `npm install @icure/cardinal-sdk@preview` resolves to it
  until the next publication.

## Stages

| Stage | Script | What it does |
|---|---|---|
| `prepare` | `01-prepare.sh` | Checks the inputs and tools. Refuses `kraken-cloud` submodules that are not at their recorded commits. Reads the codegen versions pinned by the workflows. Downloads the codegen jars and ktlint into `~/.cache/cardinal-preview`. Checks the registry credentials and that the version is free. Creates the SDK worktree at `--sdk-ref` (default `origin/develop`), with `local.properties` copied from the main checkout. |
| `kraken` | `02-generate-from-kraken.sh` | Runs the KSP tasks of `kraken-cloud`, copies the JSON to the work directory, runs the codegen, ktlint and the merge, then rsyncs into `cardinal-sdk/src/commonMain` and commits locally in the worktree. |
| `ts` | `03-build-ts-package.sh` | `kspKotlinJvm`, `clearAutoGenerated`, `wrapper-codegen generate --ts`, `updateAutoGenerated`, `prepareDistributionPackage` with `-PsdkVersion`. |
| `publish` | `04-publish-npm.sh` | `npm install`, `npm ci`, build, then `npm publish --tag preview` after a confirmation (`--yes` to skip it). |

`publish-preview.sh` runs them in order. `--from kraken|ts|publish` resumes a run with the same `--version` and
`--work-dir`. Prepare always runs again first, so options such as `--codegen-version` can be changed when resuming.
Each stage can also be run on its own with the work directory as argument. The state of a run is in
`<work-dir>/state.env`.

`scripts/preview/cleanup.sh <work-dir>` removes the work directory and its worktree.

## Flavours

- `standard` (default): the steps of `kraken-cloud` `generate.yml`. Models, raw APIs and `AbstractFilterSerializer`
  are all generated, so new endpoints and filters of `kraken-cloud` are in the preview. The hand-written SDK layers
  must compile against them. If they don't, stage `ts` fails and the change needs SDK work first.
- `legacy`: the steps of the-forge `legacy-codegen`. Only the models are generated, with their deprecated fields.
  This is what the-forge publishes on `npm.icure.cloud` for a release.

## Requirements

- `gh` logged in with access to `icure/sdk-codegen`, JDK 21, Node with `npm` and a global `tsc`
  (`npm install -g typescript`), `rsync`, `curl`.
- `local.properties` in the main checkout of this repository with `githubUsername` and `githubPassword` (private
  Gradle dependencies), and what `kraken-cloud` needs to build.
- npm credentials for the registry: `ICURE_NPM_USERNAME`/`ICURE_NPM_PASSWORD`. They are written to a private
  `<work-dir>/npmrc` used for the registry calls only, never to the repository. Without them, your own npm
  configuration must be logged in to the registry.

## Troubleshooting

- **"submodules are not at the recorded commits"**: the `kraken-cloud` submodules (`kraken-common`,
  `cardinal-support-libraries`) are checked out at other commits than the ones `kraken-cloud` records. The models
  would mix two versions of the code, or not compile. Run `git submodule update --init --recursive` in
  `kraken-cloud`, or pass `--allow-submodule-drift` if you are deliberately working on a submodule branch.
- **`MissingFieldException: Field '…' is required for type … IRProperty`** during stage `kraken`: the codegen
  release pinned in `kraken-cloud` `generate.yml` cannot read the JSON format of that branch's KSP processor. For
  example, `experimental/3.0.0` pins `1.11.1` but needs `2.x`. Pass a newer `--codegen-version`
  (`gh release list -R icure/sdk-codegen`).
- **`Unsupported JS type …`** during stage `ts`: the wrapper codegen pinned by `generate_typescript.yml` at
  `--sdk-ref` is older than the SDK code. Pass a newer `--wrapper-codegen-version`.
- **Clone of `ksp-json-processor` fails**: its URL is ssh. The scripts rewrite GitHub ssh URLs to https, so the git
  credential helper (or `gh auth setup-git`) must provide GitHub credentials.
- **Stage `ts` fails to compile**: the generated raw APIs or models do not match the hand-written SDK at `--sdk-ref`.
  Try an `--sdk-ref` that already has the matching SDK changes. The generated diff is in the local commits of
  `<work-dir>/sdk`.
- **Stale generated code in `kraken-cloud`**: stage `kraken` reruns the KSP tasks with `--rerun`. If the build of
  `kraken-cloud` itself fails after a branch switch, run `./gradlew clean` in `kraken-cloud`.
