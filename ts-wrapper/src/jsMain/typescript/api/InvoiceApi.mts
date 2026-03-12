// auto-generated file
import {PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {InvoiceShareOptions} from '../crypto/entities/InvoiceShareOptions.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {DecryptedInvoice, EncryptedInvoice, Invoice} from '../model/Invoice.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {LabelledOccurence} from '../model/data/LabelledOccurence.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {InvoiceType} from '../model/embed/InvoiceType.mjs';
import {EncryptedInvoicingCode} from '../model/embed/InvoicingCode.mjs';
import {MediumType} from '../model/embed/MediumType.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {InvoiceFlavouredApi} from './InvoiceFlavouredApi.mjs';
import {InvoiceInGroupApi} from './InvoiceInGroupApi.mjs';


export interface InvoiceApi {

	encrypted: InvoiceFlavouredApi<EncryptedInvoice>;

	tryAndRecover: InvoiceFlavouredApi<Invoice>;

	inGroup: InvoiceInGroupApi;

	/**
	 *
	 *  Creates a new invoice with initialized encryption metadata
	 *  @param base an invoice with initialized content and uninitialized encryption metadata. The result of this
	 *  method takes the content from [base] if provided.
	 *  @param patient the patient linked to the invoice.
	 *  @param user the current user, will be used for the auto-delegations if provided.
	 *  @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 *  permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 *  @param secretId specifies which secret id of [patient] to use for the new invoice
	 *  @return an invoice with initialized encryption metadata.
	 *  @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	withEncryptionMetadata(base: DecryptedInvoice | undefined, patient: Patient | undefined,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption, alternateRootDelegateId?: string | undefined }): Promise<DecryptedInvoice>;

	/**
	 *
	 *  Attempts to extract the encryption keys of an invoice. If the user does not have access to any encryption key
	 *  of the access log the method will return an empty set.
	 *  Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 *  versions of iCure where this was not a guarantee.
	 *  @param invoice an invoice
	 *  @return the encryption keys extracted from the provided invoice.
	 */
	getEncryptionKeysOf(invoice: Invoice): Promise<Array<HexString>>;

	/**
	 *
	 *  Specifies if the current user has write access to an invoice through delegations.
	 *  Doesn't consider actual permissions on the server side: for example, if the data owner has access to all entities
	 *  thanks to extended permission but has no delegation on the provided entity this method returns false. Similarly,
	 *  if the SDK was initialized in hierarchical mode but the user is lacking the hierarchical permission on the server
	 *  side this method will still return true if there is a delegation to the parent.
	 *  @param invoice an invoice
	 *  @return if the current user has write access to the provided invoice
	 */
	hasWriteAccess(invoice: Invoice): Promise<boolean>;

	/**
	 *
	 *  Attempts to extract the patient id linked to an invoice.
	 *  Note: invoices usually should be linked with only one patient, but this method returns a set for compatibility
	 *  with older versions of iCure
	 *  @param invoice an invoice
	 *  @return the id of the patient linked to the invoice, or empty if the current user can't access any patient id
	 *  of the invoice.
	 */
	decryptPatientIdOf(invoice: Invoice): Promise<Array<EntityReferenceInGroup>>;

	/**
	 *
	 *  Create metadata to allow other users to identify the anonymous delegates of an invoice.
	 *
	 *  When calling this method the SDK will use all the information available to the current user to try to identify
	 *  any anonymous data-owners in the delegations of the provided invoice. The SDK will be able to identify the
	 *  anonymous data owners of the delegations only under the following conditions:
	 *  - The other participant of the delegation is the current data owner
	 *  - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 *  current data owner
	 *  - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 *  After identifying the anonymous delegates in the invoice the sdk will create the corresponding de-anonymization
	 *  metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 *  Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any Invoice,
	 *  not only in the provided instance.
	 *
	 *  ## Example
	 *
	 *  If you have an invoice E, and you have shared it with patient P and healthcare party H, H will not
	 *  be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 *  H. From now on, for any invoice that you have shared with P, H will be able to know that the invoice was
	 *  shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 *  At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 *  delegator-delegate pair, you will not be able to see if P has access to an invoice that was created by H and
	 *  shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 *  @param entity an invoice
	 *  @param delegates a set of data owner ids
	 */
	createDelegationDeAnonymizationMetadata(entity: Invoice, delegates: Array<string>): Promise<void>;

	/**
	 *
	 *  Decrypts an invoice, throwing an exception if it is not possible.
	 *  @param invoice an invoice
	 *  @return the decrypted invoice
	 *  @throws EntityEncryptionException if the invoice could not be decrypted
	 */
	decrypt(invoice: EncryptedInvoice): Promise<DecryptedInvoice>;

	/**
	 *
	 *  Tries to decrypt an invoice, returns the input if it is not possible.
	 *  @param invoice an encrypted invoice
	 *  @return the decrypted invoice if the decryption was successful or the input if it was not.
	 */
	tryDecrypt(invoice: EncryptedInvoice): Promise<Invoice>;

	/**
	 *
	 *  Deletes an invoice. If you don't have write access to the invoice the method will fail.
	 *  @param entityId id of the invoice.
	 *  @param rev the latest known rev of the invoice to delete
	 *  @return the id and revision of the deleted invoice.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	deleteInvoiceById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many invoices. Ids that do not correspond to an entity, or that correspond to an entity for which
	 *  you don't have write access will be ignored.
	 *  @param entityIds ids and revisions of the invoices to delete.
	 *  @return the id and revision of the deleted invoices. If some entities could not be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	deleteInvoicesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes an invoice.
	 *  @param id id of the invoice to purge
	 *  @param rev latest revision of the invoice
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	purgeInvoiceById(id: string, rev: string): Promise<void>;

	/**
	 *
	 *  Permanently deletes many invoices.
	 *  @param entityIds ids and revisions of the invoices to delete
	 *  @return the id and revision of the deleted invoices. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeInvoicesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Deletes an invoice. If you don't have write access to the invoice the method will fail.
	 *  @param invoice the invoice to delete
	 *  @return the id and revision of the deleted invoice.
	 *  @throws RevisionConflictException if the provided invoice doesn't match the latest known revision
	 */
	deleteInvoice(invoice: Invoice): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many invoices. Ignores invoice for which you don't have write access or that don't match the latest revision.
	 *  @param invoices the invoices to delete
	 *  @return the id and revision of the deleted invoices. If some entities couldn't be deleted they will not be
	 *  included in this list.
	 */
	deleteInvoices(invoices: Array<Invoice>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes an invoice.
	 *  @param invoice the invoice to purge.
	 *  @throws RevisionConflictException if the provided invoice doesn't match the latest known revision
	 */
	purgeInvoice(invoice: Invoice): Promise<void>;

	/**
	 *
	 *  Permanently deletes many invoices.
	 *  @param invoices the invoices to purge.
	 *  @return the id and revision of the deleted invoices. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeInvoices(invoices: Array<Invoice>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Gives an approximation of the amount of times each tarification code ([Invoice.invoicingCodes] ->
	 *  [InvoicingCode.tarificationId]) is used in invoices where the current data owner is a direct delegate (does not
	 *  count situations where the data owner has access to the service through delegations to a parent data owner).
	 *  This number is not exact, and may be cached, so you should not use this method if you need precise values, but
	 *  it can be useful if you want to give suggestions.
	 *  Only codes that occur at least [minOccurrence] times will be used.
	 *  @return the occurrences for each invoicing code that is used at least [minOccurrence] times.
	 */
	getTarificationsCodesOccurrences(minOccurrence: number): Promise<Array<LabelledOccurence>>;

	/**
	 *
	 *  Share an invoice with another data owner. The invoice must already exist in the database for this method to
	 *  succeed. If you want to share the invoice before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  @param delegateId the owner that will gain access to the invoice
	 *  @param invoice the invoice to share with [delegateId]
	 *  @param options specifies how the invoice will be shared. By default, all data available to the current user
	 *  will be shared, and the delegate will have the same permissions as the current user on the invoice. Refer
	 *  to the documentation of [InvoiceShareOptions] for more information.
	 *  @return the updated invoice if the sharing was successful, or details on the errors if the sharing failed.
	 */
	shareWith(delegateId: string, invoice: DecryptedInvoice,
			options?: { options?: InvoiceShareOptions | undefined }): Promise<DecryptedInvoice>;

	/**
	 *
	 *  Share an invoice with multiple data owners. The invoice must already exist in the database for this method to
	 *  succeed. If you want to share the invoice before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  Throws an exception if the operation fails.
	 *  @param invoice the invoice to share
	 *  @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 *  each of them.
	 *  @return the updated invoice.
	 */
	shareWithMany(invoice: DecryptedInvoice,
			delegates: { [ key: string ]: InvoiceShareOptions }): Promise<DecryptedInvoice>;

	findInvoicesByHcPartyPatient(hcPartyId: string, patient: Patient,
			options?: { startDate?: number | undefined, endDate?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedListIterator<DecryptedInvoice>>;

	/**
	 *
	 *  Create a new invoice. The provided invoice must have the encryption metadata initialized.
	 *  @param entity an invoice with initialized encryption metadata
	 *  @return the created invoice with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createInvoice(entity: DecryptedInvoice): Promise<DecryptedInvoice>;

	/**
	 *
	 *  Create multiple invoices. All the provided invoices must have the encryption metadata initialized, otherwise
	 *  this method fails without doing anything.
	 *  @param entities invoices with initialized encryption metadata
	 *  @return the created invoices with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of any invoice in the input was not initialized.
	 */
	createInvoices(entities: Array<DecryptedInvoice>): Promise<Array<DecryptedInvoice>>;

	/**
	 *
	 *  Restores an invoice that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteInvoiceById(id: string, rev: string): Promise<DecryptedInvoice>;

	/**
	 *
	 *  Restores a batch of invoiceIds that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the invoiceIds to restore.
	 *  @return the restored invoiceIds. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteInvoicesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<DecryptedInvoice>>;

	/**
	 *
	 *  Restores an invoice that was marked as deleted.
	 *  @param invoice the invoice to undelete
	 *  @return the restored invoice.
	 *  @throws RevisionConflictException if the provided invoice doesn't match the latest known revision
	 */
	undeleteInvoice(invoice: Invoice): Promise<DecryptedInvoice>;

	/**
	 *
	 *  Restores a batch of invoices that were marked as deleted.
	 *  @param invoices the invoices to restore.
	 *  @return the restored invoices. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteInvoices(invoices: Array<Invoice>): Promise<Array<DecryptedInvoice>>;

	/**
	 *
	 *  Modifies an invoice. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity an invoice with update content
	 *  @return the invoice updated with the provided content and a new revision.
	 */
	modifyInvoice(entity: DecryptedInvoice): Promise<DecryptedInvoice>;

	/**
	 *
	 *  Modifies multiple invoices. Ignores all invoices for which you don't have write access.
	 *  Flavoured method.
	 *  @param entities invoices with update content
	 *  @return the updated invoices with a new revision.
	 */
	modifyInvoices(entities: Array<DecryptedInvoice>): Promise<Array<DecryptedInvoice>>;

	/**
	 *
	 *  Get an invoice by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not an invoice, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId an invoice id.
	 *  @return the invoice with id [entityId].
	 */
	getInvoice(entityId: string): Promise<DecryptedInvoice | undefined>;

	/**
	 *
	 *  Get multiple invoices by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not an invoice, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of invoices ids
	 *  @return all invoices that you can access with one of the provided ids.
	 */
	getInvoices(entityIds: Array<string>): Promise<Array<DecryptedInvoice>>;

	reassignInvoice(invoice: DecryptedInvoice): Promise<DecryptedInvoice>;

	mergeTo(invoiceId: string, ids: Array<string>): Promise<DecryptedInvoice>;

	validate(invoiceId: string, scheme: string, forcedValue: string): Promise<DecryptedInvoice>;

	appendCodes(
			userId: string,
			type: string,
			sentMediumType: string,
			secretFKeys: string,
			invoicingCodes: Array<EncryptedInvoicingCode>,
			options?: { insuranceId?: string | undefined, invoiceId?: string | undefined, gracePeriod?: number | undefined }
	): Promise<Array<DecryptedInvoice>>;

	removeCodes(userId: string, serviceId: string, secretFKeys: string,
			tarificationIds: Array<string>): Promise<Array<DecryptedInvoice>>;

	findInvoicesByAuthor(hcPartyId: string,
			options?: { fromDate?: number | undefined, toDate?: number | undefined, startKey?: any | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<DecryptedInvoice>>;

	listInvoicesByHcPartyAndGroupId(hcPartyId: string,
			groupId: string): Promise<Array<DecryptedInvoice>>;

	listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
			hcPartyId: string,
			sentMediumType: MediumType,
			invoiceType: InvoiceType,
			sent: boolean,
			options?: { from?: number | undefined, to?: number | undefined }
	): Promise<Array<DecryptedInvoice>>;

	listInvoicesByContactIds(contactIds: Array<string>): Promise<Array<DecryptedInvoice>>;

	listInvoicesByRecipientsIds(recipientsIds: Array<string>): Promise<Array<DecryptedInvoice>>;

	listToInsurances(userIds: Array<string>): Promise<Array<DecryptedInvoice>>;

	listToInsurancesUnsent(userIds: Array<string>): Promise<Array<DecryptedInvoice>>;

	listToPatients(hcPartyId: string): Promise<Array<DecryptedInvoice>>;

	listToPatientsUnsent(hcPartyId: string | undefined): Promise<Array<DecryptedInvoice>>;

	listInvoicesByIds(ids: Array<string>): Promise<Array<DecryptedInvoice>>;

	listInvoicesByHcpartySendingModeStatusDate(
			hcPartyId: string,
			sendingMode: string,
			status: string,
			from: number,
			to: number
	): Promise<Array<DecryptedInvoice>>;

	listInvoicesByServiceIds(serviceIds: Array<string>): Promise<Array<DecryptedInvoice>>;

	listAllHcpsByStatus(status: string, hcpIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined }): Promise<Array<DecryptedInvoice>>;

}
