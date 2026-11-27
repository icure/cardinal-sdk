# Khermes test data

`InitializeTestEnvironment` writes the documents of `action-templates/` in Khermes' configuration database
(`khermes-config`) before it starts Khermes: Khermes has no API for action templates, and a process can only use one
that exists.

They are the canonical templates of the Khermes version in `../scratch/docker-compose-cloud.yaml` (1.4.1; the templates are the same as in 1.4.0), as exported
by Khermes' provisioning CLI, from a checkout of that version:

```bash
./gradlew :provisioning:run --args="export <directory>"
```

Only the template the tests use is kept: `905507e3-…` (`ActionTemplateIds.LoginInGroup.Email`). Export them again when
you change the Khermes version.
