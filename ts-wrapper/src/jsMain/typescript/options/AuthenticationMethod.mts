import {AuthenticationClass} from "../model/embed/AuthenticationClass.mjs";
import {CaptchaOptions} from "../auth/CaptchaOptions.mjs";

export namespace AuthenticationMethod {
  /**
   * The sdk will perform requests using jwt obtained from the provided credentials.
   *
   * When using this authentication method, the sdk will cache the credentials and will automatically request updated
   * tokens as needed.
   * However, if the provided credentials expire, the SDK will become unusable.
   *
   * This authentication method can also be used for the execution of requests that require an elevated security context
   * as long as the credentials provided can be used to create a suitable token.
   *
   * Not that when using this authentication method the provided credentials will be cached (in volatile memory)
   * without expiration.
   */
  export namespace UsingCredentials {
    export class UsernamePassword {
      constructor(
        /**
         * A public identifier of the user logging in. This could be:
         * - {@link User.id}
         * - {@link Group.id}:{@link User.id}
         * - {@link User.login}
         * - {@link User.email}
         */
        readonly username: string,
        /**
         * The password of the user
         */
        readonly password: string,
      ) {}
    }

    export class UsernameLongToken {
      constructor(
        /**
         * A public identifier of the user logging in. This could be:
         * - {@link User.id}
         * - {@link Group.id}:{@link User.id}
         * - {@link User.login}
         * - {@link User.email}
         */
        readonly username: string,
        /**
         * A long-lived token of the user
         */
        readonly token: string,
      ) {}
    }

    export class ExternalAuthenticationToken {
      constructor(
        /**
         * The id of the configuration that specifies how the token should be validated and how it should be used to find
         * the corresponding user in iCure.
         *
         * Note you can only use external authentication if the sdk instance was initialized with an application id.
         */
        readonly configId: string,
        /**
         * A token used to perform the external authentication
         */
        readonly token: string,
        /**
         * During login consider only configurations that can provide at least this authentication class
         */
        readonly minimumAuthenticationClass?: AuthenticationClass,
      ) {}
    }

    export class JwtCredentials {
      constructor(
        /**
         * A refresh token of the user
         */
        readonly refresh: string,
        /**
         * An initial bearer token of the user, optional.
         */
        readonly bearer?: string
      ) {}
    }
  }

  /**
   * Allows the SDK to perform authentication using secrets obtained from an [AuthSecretProvider].
   *
   * The iCure SDK can authenticate to the backend using different kinds of secrets, such as passwords, long-lived authentication tokens, and
   * short-lived authentication tokens generated through the message gateway.
   * iCure associates to each kind of secret a certain security level, and for some sensitive operations, depending on the configurations of
   * the user and his group, some operations may require a secret of a certain security level.
   *
   * For example, with the default configurations, to change his own email the user can't have logged in with a long-lived token, but he
   * needs to provide his current password or a short-lived token.
   *
   * By using this authentication option, the iCure SDK will automatically request and cache the secret from the [AuthSecretProvider] only when
   * needed, which should help to minimize the interaction with the user.
   *
   * Another advantage of using this authentication option over others is that in case all the cached tokens and secrets were to expire while
   * performing a request, instead of having the request fail the SDK will ask for a new secret from the [SmartAuthProvider] and the request will
   * automatically be retried with the new secret.
   */
  export class UsingSecretProvider {
    constructor(
      readonly secretProvider: AuthSecretProvider,
      readonly options?: SecretProviderAuthenticationOptions
    ) {}
  }
}
export type AuthenticationMethod =
  AuthenticationMethod.UsingCredentials.UsernamePassword |
  AuthenticationMethod.UsingCredentials.UsernameLongToken |
  AuthenticationMethod.UsingCredentials.ExternalAuthenticationToken |
  AuthenticationMethod.UsingCredentials.JwtCredentials |
  AuthenticationMethod.UsingSecretProvider

export interface SecretProviderAuthenticationOptions {
  /**
   * A public identifier of the user logging in. This could be:
   * - {@link User.id}
   * - {@link Group.id}:{@link User.id}
   * - {@link User.login}
   * - {@link User.email}
   * This value is optional because authentication using external methods (e.g. Google or digital ids) does not
   * require explicitly providing the username. However, if not provided, the authentication will be locked to
   * only use these external authentication methods.
   */
  readonly loginUsername?: string
  /**
   * An initial secret for the login.
   * If not null, the authentication provider will attempt to use it when needed before asking the secret
   * provider.
   */
  readonly initialSecret?: SecretProviderAuthenticationOptions.InitialSecret
  /**
   * If not null the authentication provider will use the jwt while valid.
   */
  readonly existingJwt?: string
  /**
   * If not null the authentication provider will use the refresh jwt while valid.
   */
  readonly existingRefreshJwt?: string
  /**
   * If set to true the secrets used by the authentication provider will be cached without expiration
   * (in volatile memory).
   * This minimizes the interaction with the end user, but may not be suitable for your security policy.
   */
  readonly cacheSecrets?: boolean
}

export namespace SecretProviderAuthenticationOptions {
  export namespace InitialSecret {
    export class Password { constructor(readonly password: string) {} }
    export class LongLivedToken { constructor(readonly token: string) {} }
    export class ExternalAuthenticationToken { constructor(readonly token: string, readonly configId: string) {} }
  }

  export type InitialSecret = InitialSecret.Password | InitialSecret.LongLivedToken | InitialSecret.ExternalAuthenticationToken
}

export interface AuthSecretProvider {
  /**
   * Provides a secret for authentication to the iCure SDK.
   *
   * ## Accepted secrets
   *
   * The method will be provided with an array of the secrets types that are acceptable {@link acceptedSecrets}. Usually this array will contain multiple
   * elements, but this depends on the group configuration, the user (if he has 2fa setup or not), or the operation being performed. For groups using
   * default configurations and for patients without 2fa enabled for example the array will always contain the {@link AuthenticationClass.Password} element.
   * Usually the array contain also the {@link AuthenticationClass.LongLivedToken} element, but if the user is attempting to perform a sensitive operations
   * such as changing his password the default group configuration does not allow for the user to authenticate using a JWT obtained from a long-lived
   * token for this operation, meaning the array will not contain the {@link AuthenticationClass.LongLivedToken} element.
   *
   * Regardless of the number of elements in the array only one secret of the accepted types is sufficient for the operation to succeed.
   *
   * ## {@link AuthenticationClass.TwoFactorAuthentication} secret type
   *
   * The {@link AuthenticationClass.TwoFactorAuthentication} secret type is only used when the user has 2fa enabled. In this case the SDK will call
   * this method twice, once containing the {@link AuthenticationClass.Password} element in the {@link acceptedSecrets} array, and if the provided secret is a
   * valid password the SDK will immediately call this method again, this time containing the {@link AuthenticationClass.TwoFactorAuthentication}
   * instead of the {@link AuthenticationClass.Password} element.
   *
   * Any future call to this method from the same provider instance will not contain the {@link AuthenticationClass.Password} element anymore, as it is
   * cached, but it may contain the {@link AuthenticationClass.TwoFactorAuthentication} element instead.
   *
   * Note that the 2fa token is not needed for logging in through a long-lived or short-lived token, it is only used in combination with a password.
   * If the user is using 2fa, and you get in input as {@link acceptedSecrets} an array `[PASSWORD, LONG_LIVED_TOKEN, SHORT_LIVED_TOKEN]`, and you pass to
   * authenticate a long-lived token, the SDK will not call this method again to ask for the 2fa token.
   *
   * @param acceptedSecrets the types of secrets that are acceptable for the operation being performed.
   * @param previousAttempts the secrets that were previously attempted by the SDK for this operation. This array will be empty the first time this
   * method is called for a given operation, but it may contain multiple elements if the SDK has already called this method multiple times because the
   * previously returned secrets were not valid. The first element is the first secret that was attempted, and the last element is the most recently
   * attempted.
   * @param authProcessApi an api which can be used to request sms or email short-lived tokens for the user.
   * @return a promise that resolves with the secret and the secret type to use for authentication. If the promise rejects then the ongoing SDK
   * operation will fail without being re-attempted.
   */
  getSecret(
    acceptedSecrets: Array<AuthenticationClass>,
    previousAttempts: Array<AuthSecretDetails>,
    authProcessApi: AuthenticationProcessApi
  ): Promise<AuthSecretDetails>
}

export namespace AuthSecretDetails {
  export class PasswordDetails {
    /**
     * @param secret the password of the user
     */
    constructor (readonly secret: String) {}
  }
  
  export class TwoFactorAuthTokenDetails {
    /**
     * @param secret the current two-factor authentication token of the user.
     */
    constructor (readonly secret: String) {}
  }

  export class ShortLivedTokenDetails {
    /**
     * @param secret a short-lived token obtained through an authentication process
     * @param authenticationProcessInfo the authentication process that was used to create the secret
     */
    constructor(readonly secret: String, readonly authenticationProcessInfo: AuthenticationProcessRequest) {}
  }
  
  export class LongLivedTokenDetails {
    /**
     * @param secret a long-lived token of the user.
     */
    constructor (readonly secret: String) {}
  }
  
  export class ConfiguredExternalAuthenticationDetails {
    /**
     * Login using a token or other secret provided by another authentication service configured for your project.
     *
     * This AuthSecretDetails type can only be used if the sdk initialization provided an application id: using
     * this AuthSecretDetails with an instance of SDK that doesn't have a configured application id will result in a
     * runtime exception.
     *
     * @param configId id of the configuration to use for authentication.
     * @param secret the token or another secret that will be used for authentication.
     * @param minimumAuthenticationClass only consider configurations that can provide at least this authentication class. The actual
     * authentication class obtained for the token may be higher.
     */
    constructor (readonly configId: string, readonly secret: string, readonly minimumAuthenticationClass?: AuthenticationClass) {}
  }
}
export type AuthSecretDetails =
  AuthSecretDetails.PasswordDetails |
  AuthSecretDetails.TwoFactorAuthTokenDetails |
  AuthSecretDetails.ShortLivedTokenDetails |
  AuthSecretDetails.LongLivedTokenDetails |
  AuthSecretDetails.ConfiguredExternalAuthenticationDetails

/**
 * Allows initializing processes for the registration and authentication of users.
 */
export interface AuthenticationProcessApi {
  /**
   * Executes an authentication process.
   * @param messageGatewayUrl the url of the iCure message gateway you want to use. Usually this should be
   * @param externalServicesSpecId an identifier that allows the message gateway to connect the request to your
   * services for email / sms communication of the process tokens.
   * @param processId the id of the process you want to execute.
   * @param userTelecomType the type of telecom number used for the user.
   * @param userTelecom the telecom number of the user for which you want to execute the process. This should be an
   * email address or phone number depending on the type of process you are executing.
   * @param captchaOptions the captcha solution
   * @param processTemplateParameters additional parameters needed by some process templates.
   */
  executeProcess(
    messageGatewayUrl: string,
    externalServicesSpecId: string,
    processId: string,
    userTelecomType: AuthenticationProcessTelecomType,
    userTelecom: string,
    captchaOptions: CaptchaOptions,
    processTemplateParameters?: AuthenticationProcessTemplateParameters
  ): Promise<AuthenticationProcessRequest>
}

export interface AuthenticationProcessTemplateParameters {
  /**
   * First name of the user executing the authentication process.
   */
  readonly firstName?: string
  /**
   * Last name of the user executing the authentication process.
   */
  readonly lastName?: string
}

export enum AuthenticationProcessTelecomType {
  Email = "Email", MobilePhone = "MobilePhone"
}

/**
 * Holds information on an authentication process request done through the {@link AuthenticationProcessApi}.
 *
 * You should not instantiate this class directly or use its properties, as they are for internal use and may be changed
 * without notice.
 */
export class AuthenticationProcessRequest {
  constructor(
    readonly messageGwUrl: String,
    readonly specId: String,
    readonly requestId: String
  ) {}
}