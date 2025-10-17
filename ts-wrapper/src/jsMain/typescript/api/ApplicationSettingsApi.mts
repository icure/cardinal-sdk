// auto-generated file
import {EncryptedApplicationSettings} from '../model/ApplicationSettings.mjs';


export interface ApplicationSettingsApi {

	getApplicationSettings(): Promise<Array<EncryptedApplicationSettings>>;

	createApplicationSettings(applicationSettings: EncryptedApplicationSettings): Promise<EncryptedApplicationSettings>;

	updateApplicationSettings(applicationSettings: EncryptedApplicationSettings): Promise<EncryptedApplicationSettings>;

}
