// TODO auto-generate (issues with undefined in function)
import {Solution} from '../kerberus/Solution.mjs';

export type CaptchaOptions = CaptchaOptions.Recaptcha | CaptchaOptions.FriendlyCaptcha | CaptchaOptions.Kerberus;

export namespace CaptchaOptions {

	export class Recaptcha {

		solution: string;

		readonly $ktClass: 'com.icure.cardinal.sdk.auth.CaptchaOptions.Recaptcha' = 'com.icure.cardinal.sdk.auth.CaptchaOptions.Recaptcha';

		constructor(partial: Partial<Recaptcha> & Pick<Recaptcha, "solution">) {
			this.solution = partial.solution;
		}

	}

	export class FriendlyCaptcha {

		solution: string;

		readonly $ktClass: 'com.icure.cardinal.sdk.auth.CaptchaOptions.FriendlyCaptcha' = 'com.icure.cardinal.sdk.auth.CaptchaOptions.FriendlyCaptcha';

		constructor(partial: Partial<FriendlyCaptcha> & Pick<FriendlyCaptcha, "solution">) {
			this.solution = partial.solution;
		}

	}

	export namespace Kerberus {

		export class Computed {

			solution: Solution;

			readonly $ktClass: 'com.icure.cardinal.sdk.auth.CaptchaOptions.Kerberus.Computed' = 'com.icure.cardinal.sdk.auth.CaptchaOptions.Kerberus.Computed';

			constructor(partial: Partial<Computed> & Pick<Computed, "solution">) {
				this.solution = partial.solution;
			}

		}

		/**
		 * The SDK gets a Kerberus challenge and solves it when the authentication process starts.
		 */
		export class Delegated {

			/**
			 * The secret key of the Kerberus provider of the process's Spec. Required for a Khermes authentication process,
			 * where it is part of the proof-of-work input; not used by the message gateway.
			 */
			secretKey: string | undefined = undefined;

			/**
			 * A callback notified of the progress of the computation, between 0 and 1.
			 */
			onProgress: ((x1: number) => void) | undefined = undefined;

			readonly $ktClass: 'com.icure.cardinal.sdk.auth.CaptchaOptions.Kerberus.Delegated' = 'com.icure.cardinal.sdk.auth.CaptchaOptions.Kerberus.Delegated';

			constructor(partial: Partial<Delegated>) {
				if ('secretKey' in partial) this.secretKey = partial.secretKey;
				if ('onProgress' in partial) this.onProgress = partial.onProgress;
			}

		}

	}

	export type Kerberus = Kerberus.Computed | Kerberus.Delegated;

}
