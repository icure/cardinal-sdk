import {Solution} from '../kerberus/Solution.mjs';
import {BasicSdkOptions} from '../options/SdkOptions.mjs';
import {InternalSdkInitializers} from '../cardinal-sdk-ts.mjs';

/**
 * Kerberus captcha helpers for Khermes authentication processes.
 */
export namespace KhermesCaptcha {
  /**
   * Gets a Kerberus challenge from Khermes and solves it, for a later authentication of {@link userTelecom} through the
   * process {@link processId} with {@link CaptchaOptions.Kerberus.Computed}. Solving can take a few seconds: start it
   * while the user is still filling in their information.
   *
   * Khermes binds the challenge to {@link userTelecom} when it issues it, and checks its rate limits for that user
   * telecom then. So the solving can start only once the user telecom is known: when the user has finished entering it,
   * for example when its field loses focus, debounced. Not when the page loads.
   *
   * The solution is valid only for this process and this user telecom, only once, and for 10 minutes. Khermes refuses a
   * new challenge for the same user telecom from the same IP within 60 seconds (429): if the user changes the user
   * telecom and then goes back to the previous one, reuse the solution already computed for it instead of asking again.
   *
   * @param khermesUrl the url of Khermes, `https://khermes.icure.cloud` in production.
   * @param processId the id of the Khermes authentication process.
   * @param userTelecom the email address or phone number the authentication will be started for.
   * @param secretKey the secret key of the Kerberus provider of the process's Spec.
   * @param onProgress a callback notified of the progress of the computation, between 0 and 1.
   * @param options the crypto service and http options to use.
   */
  export async function solveKerberusChallenge(
    khermesUrl: string,
    processId: string,
    userTelecom: string,
    secretKey: string,
    onProgress?: (progress: number) => void,
    options?: BasicSdkOptions
  ): Promise<Solution> {
    return await InternalSdkInitializers.getInstance().solveKerberusChallenge(
      khermesUrl,
      processId,
      userTelecom,
      secretKey,
      onProgress,
      options,
    )
  }
}
