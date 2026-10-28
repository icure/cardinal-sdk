// auto-generated file
import {EntityWithEncryptionMetadataStub} from '../../crypto/entities/EntityWithEncryptionMetadataStub.mjs';
import {DecryptedAccessLog, EncryptedAccessLog} from '../AccessLog.mjs';
import {DecryptedApplicationSettings, EncryptedApplicationSettings} from '../ApplicationSettings.mjs';
import {DecryptedArticle, EncryptedArticle} from '../Article.mjs';
import {DecryptedCalendarItem, EncryptedCalendarItem} from '../CalendarItem.mjs';
import {DecryptedClassification, EncryptedClassification} from '../Classification.mjs';
import {DecryptedContact, EncryptedContact} from '../Contact.mjs';
import {DecryptedCustomEntityBase, EncryptedCustomEntityBase} from '../CustomEntityBase.mjs';
import {DecryptedDocument, EncryptedDocument} from '../Document.mjs';
import {DecryptedForm, EncryptedForm} from '../Form.mjs';
import {DecryptedHealthElement, EncryptedHealthElement} from '../HealthElement.mjs';
import {IcureStub} from '../IcureStub.mjs';
import {DecryptedInvoice, EncryptedInvoice} from '../Invoice.mjs';
import {DecryptedMaintenanceTask, EncryptedMaintenanceTask} from '../MaintenanceTask.mjs';
import {DecryptedMessage, EncryptedMessage} from '../Message.mjs';
import {DecryptedPatient, EncryptedPatient} from '../Patient.mjs';
import {DecryptedReceipt, EncryptedReceipt} from '../Receipt.mjs';
import {DecryptedRelatedPerson, EncryptedRelatedPerson} from '../RelatedPerson.mjs';
import {DecryptedSecureDelegationKeyMap, EncryptedSecureDelegationKeyMap} from '../SecureDelegationKeyMap.mjs';
import {DecryptedTopic, EncryptedTopic} from '../Topic.mjs';
import {Delegation} from '../embed/Delegation.mjs';
import {SecurityMetadata} from '../embed/SecurityMetadata.mjs';
import {Versionable} from './Versionable.mjs';


/**
 *
 *
 *   Interface for entities that hold encryption metadata used for end-to-end encryption and access control.
 *   This includes delegation keys, encrypted foreign keys, and security metadata.
 */
export interface HasEncryptionMetadata extends Versionable<string> {

	secretForeignKeys: Array<string>;

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> };

	delegations: { [ key: string ]: Array<Delegation> };

	encryptionKeys: { [ key: string ]: Array<Delegation> };

	securityMetadata: SecurityMetadata | undefined;

	readonly $ktClass: string;

}

export namespace HasEncryptionMetadata {

	export function fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['HasEncryptionMetadata']): HasEncryptionMetadata {
		switch ((json as HasEncryptionMetadata).$ktClass) {
			case 'com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataStub': return EntityWithEncryptionMetadataStub.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.EncryptedPatient': return EncryptedPatient.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.DecryptedPatient': return DecryptedPatient.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.EncryptedSecureDelegationKeyMap': return EncryptedSecureDelegationKeyMap.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.DecryptedSecureDelegationKeyMap': return DecryptedSecureDelegationKeyMap.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.DecryptedTopic': return DecryptedTopic.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.EncryptedTopic': return EncryptedTopic.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.DecryptedCustomEntityBase': return DecryptedCustomEntityBase.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.EncryptedCustomEntityBase': return EncryptedCustomEntityBase.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.EncryptedDocument': return EncryptedDocument.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.DecryptedDocument': return DecryptedDocument.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.DecryptedMaintenanceTask': return DecryptedMaintenanceTask.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.EncryptedMaintenanceTask': return EncryptedMaintenanceTask.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.DecryptedApplicationSettings': return DecryptedApplicationSettings.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.EncryptedApplicationSettings': return EncryptedApplicationSettings.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.EncryptedArticle': return EncryptedArticle.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.DecryptedArticle': return DecryptedArticle.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.IcureStub': return IcureStub.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.DecryptedInvoice': return DecryptedInvoice.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.EncryptedInvoice': return EncryptedInvoice.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.DecryptedContact': return DecryptedContact.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.EncryptedContact': return EncryptedContact.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.DecryptedCalendarItem': return DecryptedCalendarItem.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.EncryptedCalendarItem': return EncryptedCalendarItem.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.EncryptedClassification': return EncryptedClassification.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.DecryptedClassification': return DecryptedClassification.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.EncryptedHealthElement': return EncryptedHealthElement.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.DecryptedHealthElement': return DecryptedHealthElement.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.EncryptedRelatedPerson': return EncryptedRelatedPerson.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.DecryptedRelatedPerson': return DecryptedRelatedPerson.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.EncryptedForm': return EncryptedForm.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.DecryptedForm': return DecryptedForm.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.DecryptedAccessLog': return DecryptedAccessLog.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.EncryptedAccessLog': return EncryptedAccessLog.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.DecryptedMessage': return DecryptedMessage.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.EncryptedMessage': return EncryptedMessage.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.DecryptedReceipt': return DecryptedReceipt.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.EncryptedReceipt': return EncryptedReceipt.fromJSON(json, ignoreUnknownKeys)
			default: throw new Error('Unexpected discriminator for HasEncryptionMetadata: ' + json.$ktClass)
		}
	}

}
