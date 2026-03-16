# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build & Test Commands

This is a Gradle-based Kotlin Multiplatform project. Use `./gradlew` from the project root.

**Build:**
- `./gradlew build` - Full build (all modules, all platforms)
- `./gradlew :cardinal-sdk:compileKotlinJvm` - Compile JVM only (fastest iteration)
- `./gradlew :cardinal-sdk:compileKotlinJs` - Compile JS only

**Test:**
- `./gradlew :cardinal-sdk:jvmTest` - JVM tests (most commonly used)
- `./gradlew :cardinal-sdk:jsNodeTest` - JS Node tests
- `./gradlew :cardinal-sdk:jsBrowserTest` - JS browser tests (needs Chrome/Firefox)
- `./gradlew :cardinal-sdk:allTests` - All platform tests
- Single test class: `./gradlew :cardinal-sdk:jvmTest --tests "com.icure.cardinal.sdk.SomeTest"`

**Other modules:**
- `./gradlew :ts-wrapper:build` - TypeScript wrapper
- `./gradlew :python-wrapper:build` - Python wrapper
- `./gradlew :dart-wrapper:lib:build` - Dart wrapper

**Setup:** Requires a `local.properties` file in the project root:
```properties
sdk.dir=/path/to/android/sdk
ios.simulator=iPhone 15
```
Private dependencies require `githubUsername` and `githubPassword` in `local.properties` for the `icure/charix` Maven repository.

## Architecture

### Overview
Cardinal SDK is a Kotlin Multiplatform SDK for the iCure healthcare platform with built-in end-to-end encryption. It targets JVM, JS (browser + Node), Android, iOS, macOS, Linux, and Windows.

### Module Structure
- **`cardinal-sdk/`** - Core multiplatform SDK (the main module)
- **`ts-wrapper/`** - TypeScript/JS wrapper (Kotlin/JS + TypeScript, packaged as npm module)
- **`python-wrapper/`** - Python bindings (uses native binaries)
- **`dart-wrapper/`** - Dart/Flutter plugin (two sub-modules: `lib` and `cardinal_sdk`)
- **`ksp-json-processor/`** - KSP annotation processor for JSON metadata generation (composite build)
- **`buildSrc/`** - Shared Gradle build conventions (`ConfigureMultiplatform.kt`, `Plugins.kt`, etc.)

### Core SDK Structure (`cardinal-sdk/src/commonMain/`)
Package root: `com.icure.cardinal.sdk`

- **`api/`** - Public API interfaces for each entity
  - **`api/raw/`** - Generated 1-to-1 REST API mappings (always use encrypted entities)
  - **`api/impl/`** - API implementations with encryption logic
- **`model/`** - Data models (mostly auto-generated)
- **`crypto/`** - End-to-end encryption, key exchange, delegation management
  - **`crypto/entities/`** - Share options classes (one per encryptable entity)
- **`filters/`** - Query filter builders for each entity type
- **`auth/`** - Authentication services and providers
- **`options/`** - SDK configuration and initialization options
- **`serialization/`** - Custom JSON serialization logic
- **`subscription/`** - WebSocket-based real-time subscriptions

### Entry Points
- `CardinalSdk` - Main authenticated SDK, implements `CardinalApis`
- `CardinalAnonymousSdk` - For unauthenticated operations
- `CardinalBaseSdk` - Base functionality shared between both

The SDK exposes APIs as properties: `sdk.patient`, `sdk.calendarItem`, `sdk.group`, etc. Non-crypto APIs (group, code, healthcareParty) are in `CardinalNonCryptoApis`; encryptable entity APIs are in `CardinalApis`.

### Encryptable Entity Pattern (Critical)
Healthcare entities that contain sensitive data use a sealed interface with two implementations:
- `Patient` (sealed interface) → `DecryptedPatient` + `EncryptedPatient`
- Same for CalendarItem, Contact, Document, HealthElement, Message, etc.

**Non-encryptable entities** (Group, Code, HealthcareParty, etc.) have simple APIs with no sealed interface, no flavours, and no sharing operations.

### API Interface Hierarchy (Encryptable Entities)
Each encryptable entity has a layered interface hierarchy. Using CalendarItem as example:

```
CalendarItemBasicFlavourlessApi        — Delete/purge ops, no encryption involvement
  ↓ combined with
CalendarItemBasicFlavouredApi<E>       — CRUD (create, get, modify), generic over E
  ↓ extended by
CalendarItemFlavouredApi<E>            — Adds sharing, filtering (requires data owner)
  ↓ combined into
CalendarItemApi                        — Full API for data owners, E=DecryptedCalendarItem
CalendarItemBasicApi                   — Restricted API for non-data-owners, E=EncryptedCalendarItem
```

The full `CalendarItemApi` exposes alternative flavours as properties:
- `sdk.calendarItem` — default, returns `DecryptedCalendarItem`
- `sdk.calendarItem.encrypted` — returns `EncryptedCalendarItem`
- `sdk.calendarItem.tryAndRecover` — polymorphic, tries decryption, falls back to encrypted
- `sdk.calendarItem.inGroup` — cross-group operations using `GroupScoped<E>`

### GroupScoped Pattern (Multi-Group)
For multi-tenant deployments, every encryptable entity has `*InGroupApi` variants that wrap entities in `GroupScoped<E>` (pairing entity with groupId). Access via `sdk.calendarItem.inGroup`. Uses `EntityReferenceInGroup` for cross-group entity references.

### Entity Creation Pattern
Creating encryptable entities is a two-step process:
1. `withEncryptionMetadata(base, patient, ...)` — initializes encryption metadata (does NOT persist)
2. `createCalendarItem(entity)` — persists to backend

### Filter Types
- `FilterOptions<E>` / `SortableFilterOptions<E>` — for data-owner APIs (can use crypto-based filters)
- `BaseFilterOptions<E>` / `BaseSortableFilterOptions<E>` — for non-data-owner (basic) APIs

Filter builders are in the `filters` package as companion-like objects (e.g., `CalendarItemFilters.byPatientAndDataOwner(...)`).

### Code Generation
Many files are auto-generated (marked with `// WARNING: This file is auto-generated`). These include:
- Model classes in `model/`
- Raw API interfaces in `api/raw/`
- Filter classes in `filters/`
- Wrapper code in `ts-wrapper/`, `python-wrapper/`, `dart-wrapper/`

The code generation is a two steps process: JSON files that describe the syntax and semantics of the entities and APIs are maintained in `build/generated/ksp/jvm/jvmMain/resources/.../Class.json` and then the `sdk-codegen` tool generates the actual Kotlin/JS/Python/Dart code.

**Do not manually edit auto-generated files.** Generation is done by the external `sdk-codegen` tool.

### Key Annotations
- `@InternalIcureApi` - Internal APIs not meant for end users; used extensively within the SDK
- `@DefaultValue` - Marks parameters with default values (used by code generation for wrappers)

### Platform Source Sets
- `commonMain` / `commonTest` - Shared code
- `jvmMain` / `jvmTest` - JVM (OkHttp, BouncyCastle)
- `jsMain` - JavaScript (browser/Node native engine)
- `androidMain` - Android (OkHttp)
- `iosMain`, `macosMain` - Apple (Darwin engine)
- `linuxMain` - Linux (Curl engine)
- `mingwMain` - Windows (WinHttp engine)
- `jvmAndAndroidMain` - Custom shared JVM/Android source set

### Code Style
- Indentation: tabs
- Max line length: 140
- Trailing commas: enabled
- Wildcard imports: allowed
- Style: ktlint_official
