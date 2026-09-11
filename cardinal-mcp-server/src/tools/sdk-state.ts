import type { CardinalSdk } from "@icure/cardinal-sdk";

let sdkInstance: CardinalSdk | null = null;

export function getSdk(): CardinalSdk {
	if (!sdkInstance) {
		throw new Error("SDK not initialized. Call cardinal_init first.");
	}
	return sdkInstance;
}

export function setSdk(sdk: CardinalSdk): void {
	sdkInstance = sdk;
}

export function isSdkInitialized(): boolean {
	return sdkInstance !== null;
}

/** Forgets the current instance, so that the next operational call fails until cardinal_init runs again. */
export function resetSdk(): void {
	sdkInstance = null;
}
