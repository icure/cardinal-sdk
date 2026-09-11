import { defineConfig } from "vitest/config";

export default defineConfig({
	test: {
		include: ["test/**/*.test.ts"],
		environment: "node",
		// Share module state across files so the heavy @icure/cardinal-sdk bundle
		// (loaded transitively when the server is created) is parsed only once.
		// Safe here: only test/dispatch-object-params.test.ts sets the sdk-state singleton (to a stub) and it
		// resets it when done; the other tests never touch it.
		isolate: false,
		testTimeout: 30_000,
		hookTimeout: 30_000,
	},
});
