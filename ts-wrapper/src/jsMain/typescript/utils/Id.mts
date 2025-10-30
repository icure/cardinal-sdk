let doRandomUuid: () => string

declare global {
  var cardinalInternalGlobals: {
    randomUuid?: () => string
  } | undefined
}

export function randomUuid(): string {
  if (doRandomUuid == undefined) {
    if (typeof crypto !== 'undefined' && crypto.randomUUID != undefined) {
      doRandomUuid = crypto.randomUUID
    } else if (typeof window !== 'undefined' && window.crypto?.randomUUID != undefined) {
      doRandomUuid = window.crypto.randomUUID
    } else if (typeof self !== 'undefined' && self.crypto?.randomUUID != undefined) {
      doRandomUuid = self.crypto.randomUUID
    } else if (typeof globalThis !== 'undefined' && globalThis.cardinalInternalGlobals?.randomUuid != undefined) {
      doRandomUuid = globalThis.cardinalInternalGlobals?.randomUuid
    } else throw new Error(
      "Can't generate uuid as js crypto is not available.\n"
      + "This error may happen if you're creating an instance of a CardinalSdk model class on js environments that are not supported out-of-the-box, such as node<19, or react-native\n"
      + "Potential solutions:\n" +
      + "- Initialize an instance of CardinalSdk with a `cryptoService` option appropriate for the environment (see @icure/nitro-kryptom for react native); this will add a polyfill this method can use, or\n"
      + "- If you're creating an instance of a CardinalSdk model class specify its `id` property explicitly, or\n"
      + "- Add a polyfill for crypto.randomUuid"
    )
  }
  return doRandomUuid()
}