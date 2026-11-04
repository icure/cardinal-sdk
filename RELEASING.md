# Releasing the Cardinal SDK

A release is a merged **release PR**. Its title declares the release, `release-check` validates it, and merging
it tags the commit, creates the GitHub release and publishes through
[the-forge](https://github.com/icure/the-forge). There is no version to bump anywhere: the version comes from the tag.

## Versions

| Tag | Publishes |
|---|---|
| `2.14.10` (bare, patch ends in 0) | a **full release**: Kotlin (Maven Central + legacy), TypeScript (npm SDK + MCP server + legacy npm), Python (PyPI) |
| `ts-2.14.11` | **TypeScript only**: npm SDK, MCP server, legacy npm |
| `kotlin-2.14.11` | **Kotlin only**: Maven Central, legacy Maven |
| `python-2.14.11` | **Python only**: PyPI wheels |
| `…-PREVIEW.<n>` | a preview of any of the above (npm dist-tag `preview`, PyPI `rc<n>`, GitHub pre-release) |

- A change that affects every language is a full release, which increases the patch number by 10:
  `2.14.0`, `2.14.10`, `2.14.20`.
- The numbers in between belong to each unit separately. After `2.14.10`, TypeScript can ship `ts-2.14.11` and
  `ts-2.14.12`, and Python can ship its own `python-2.14.11` later.
- Versions below `2.14.0` follow the old scheme.
- npm dist-tags: a final release gets `latest` when it is above the current `latest`, and `support` when it
  belongs to an older line (for example `ts-2.14.13` published after `2.15.0`). A preview gets `preview`.

## Full release (or full preview)

1. Open a PR from `develop` to `main` titled `Release 2.14.20` (or `Release 2.15.0-PREVIEW.1`). The
   [release template](https://github.com/icure/cardinal-sdk/compare/main...develop?expand=1&template=release.md) has
   the checklist.
2. Wait for `release-check`, the test workflows and a review, then merge. Use a merge commit.
3. `release.yml` then tags `2.14.20`, creates the GitHub release (marked Latest for a final release), creates
   `support/2.14.20`, and hands over to the-forge.

## Unit patch (or unit preview)

1. Branch from the support branch of the decade: for `ts-2.14.11`, that is `support/2.14.10`.
2. Commit the fix there, or cherry-pick it from `develop`. The fix should also land in `develop` so the next
   full release contains it. Nothing checks this for you.
3. Open a PR into `support/2.14.10` titled `Release ts-2.14.11`. Several units can ship from one PR:
   `Release ts-2.14.12 python-2.14.11`. For the release template, open
   `https://github.com/icure/cardinal-sdk/compare/support/2.14.10...<branch>?expand=1&template=release.md`.
4. `release-check` rejects changes outside the declared units. A change that affects every unit, for example in
   `cardinal-sdk/src/commonMain`, requires a full release, even when the title declares all three units. Merge
   with a merge commit or a squash (not a rebase).
5. For a TypeScript patch, sync the MCP server by hand before merging: run `update_mcp_server.yml` (Actions →
   Update MCP server → Run workflow) with `ref` set to the head branch of the release PR and `version` set to the
   patch version, for example `2.14.11`. It opens its PR into that branch. Full releases are synced automatically.

Every PR into a `support/*` branch is a release PR.

## When something fails

- **`release-check` is red:** its summary lists every broken rule (R1–R10) with the offending tag or file. Fix
  the title or the changes. Editing the title re-runs the check.
- **`release.yml` failed:** re-run it. Each step skips what already exists (tags, releases, the support branch,
  forge tags). Release PRs merged close together queue: each `Release` run waits for the previous one. A
  cancelled `Release` run (for example by a manual cancel) must still be re-run the same way.
- **A re-run of `release.yml` fails R7:** a newer release of the same peer (for example `ts-2.14.12` after
  `ts-2.14.11`) was accepted in the meantime. That release number is then skipped (gaps are allowed). A newer
  release merged after it into the same support branch already ships its changes.
- **Publishing failed in the-forge:** re-run the failed jobs of the `Release cardinal-sdk` run for that tag.

## Dry run

Run the `Release` workflow by hand (Actions → Release → Run workflow), with the title, base and head branch of
the PR you intend to open. It validates the would-be PR, shows the plan, and runs the forge orchestrator with
`dry_run=true`: everything is built and nothing is published.
