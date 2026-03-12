// auto-generated file

/**
 *
 *
 *   Enumerates the different classes of authentication that can be used to establish a user session,
 *   ordered from strongest to weakest authentication assurance.
 */
export enum AuthenticationClass {
	DigitalId = "DigitalId",
	TwoFactorAuthentication = "TwoFactorAuthentication",
	ShortLivedToken = "ShortLivedToken",
	ExternalAuthentication = "ExternalAuthentication",
	Password = "Password",
	LongLivedToken = "LongLivedToken"
}
