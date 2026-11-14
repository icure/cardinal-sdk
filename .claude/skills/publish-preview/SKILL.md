---
name: publish-preview
description: Build a preview of the TypeScript Cardinal SDK from a local kraken-cloud checkout (including uncommitted changes) and publish it on npm.icure.cloud with the preview dist-tag, without any release or pull request. Use when someone wants to try kraken-cloud backend changes (new endpoints, filters, model fields) from TypeScript before they are released, or asks to "publish a preview / local preview of the cardinal sdk on npm.icure.cloud".
---

# Publish a local preview of the Cardinal SDK

`scripts/preview/publish-preview.sh` runs locally the chain CI spreads over several workflows: kraken-cloud
`generate.yml`, then `generate_typescript.yml`, then the-forge publication. Read `scripts/preview/README.md` for the
details and the troubleshooting. Your job is to choose the inputs, run the script, and stop before anything
irreversible.

## Rules

- **Publishing is irreversible.** A version published on a registry can never be published again, even after an
  unpublish. Always do a `--dry-run` first. Run the real publication (`--from publish --yes`) only after the user
  has confirmed the exact version and registry, in this conversation, for this run.
- **Never** use the `latest` dist-tag, and never reuse an official preview number.
- Do not modify the user's checkouts. The scripts work in a worktree under the work directory. If a kraken-cloud
  build step needs a fix, report it instead of editing kraken-cloud.
- Credentials (`ICURE_NPM_USERNAME`, `ICURE_NPM_PASSWORD`) come from the user's environment. Never write them to a
  file of a repository, and never echo them. If they are missing, ask the user to export them in their shell
  (`! export ICURE_NPM_USERNAME=…`) or to log in to the registry with npm.

## Steps

1. **Inputs.** Settle these with the user, or use the defaults:
   - kraken-cloud checkout (`--kraken-dir`, default `../kraken-cloud`). Report its branch, HEAD and whether it has
     uncommitted changes, because those are included.
   - SDK base (`--sdk-ref`, default `origin/develop`). For kraken-cloud `main`, CI merges into `develop`; for
     another kraken-cloud branch, CI uses the SDK branch with the same name. Pick the SDK branch matching the
     kraken-cloud branch when there is one (`git ls-remote --heads origin <branch>`).
   - Flavour: `standard` (models + raw APIs + filter serializer, needed for new endpoints and filters) or `legacy`
     (models only with deprecated fields, what the-forge publishes on npm.icure.cloud). Default `standard`.
   - Version `X.Y.Z-PREVIEW.N`, with `X.Y.Z` the next full release and `N` a timestamp (`date +%Y%m%d%H%M`).
     Official previews use small `N` on the same registry and package.
2. **Dry run.** `scripts/preview/publish-preview.sh --version <V> [options] --dry-run`. It takes 15 to 30 minutes, so
   run it in the background and wait for the notification. A dry run that is not authenticated on the registry only
   warns, so check the output of the prepare stage.
3. **Review.** Report the generated changes, which are committed locally in the worktree on top of the SDK base
   (`SDK_SHA` in `<work-dir>/state.env`): `git -C <work-dir>/sdk log --stat <SDK_SHA>..HEAD`. Also report the
   package name and version, and the `npm publish --dry-run` summary. Ask the user to confirm the publication of `<V>` on `<registry>`.
4. **Publish**, only after that confirmation:
   `scripts/preview/publish-preview.sh --version <V> [same options] --from publish --yes`.
   Then check `npm view @icure/cardinal-sdk@<V> version --registry <registry>` and give the user the install
   command.
5. **Clean up**: `scripts/preview/cleanup.sh <work-dir>` once the user no longer needs the worktree.

## When a stage fails

- **prepare: "submodules are not at the recorded commits".** Tell the user which submodules drift. Fixing it
  (`git submodule update --init --recursive` in kraken-cloud) changes their checkout, so ask first.
  `--allow-submodule-drift` is only right when they are deliberately working on a submodule branch.
- **kraken.** A kraken-cloud compile error is a kraken-cloud problem: report it.
- **ts.** The hand-written SDK at `--sdk-ref` does not compile against the generated code. Suggest another
  `--sdk-ref`, or SDK changes first. Do not patch the worktree to force a publication.
- Resume with `--from <stage>` and the same `--version` and `--work-dir`, instead of starting over.
