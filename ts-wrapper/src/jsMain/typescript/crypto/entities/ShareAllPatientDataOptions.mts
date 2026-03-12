// auto-generated file
import {EncryptedPatient} from '../../model/Patient.mjs';
import {FailedRequestDetails} from './FailedRequestDetails.mjs';
import {ShareAllPatientDataOptions as ShareAllPatientDataOptions_} from './ShareAllPatientDataOptions.mjs';


export namespace ShareAllPatientDataOptions {

	/**
	 *
	 *  Specifies which entities related to a Patient will be shared by [PatientApi.shareAllDataOfPatient].
	 */
	export enum Tag {
		All = "All",
		MedicalInformation = "MedicalInformation",
		FinancialInformation = "FinancialInformation"
	}

	export enum ShareableEntity {
		CalendarItem = "CalendarItem",
		Contact = "Contact",
		Classification = "Classification",
		Document = "Document",
		Form = "Form",
		HealthElement = "HealthElement",
		Invoice = "Invoice",
		Patient = "Patient"
	}

	export class EntityResult {

		success: boolean | undefined = undefined;

		error: ShareAllPatientDataOptions_.SharePatientDataError | undefined = undefined;

		modified: number;

		constructor(partial: Partial<EntityResult> & Pick<EntityResult, "modified">) {
			if ('success' in partial) this.success = partial.success;
			if ('error' in partial) this.error = partial.error;
			this.modified = partial.modified;
		}

	}

	export class Result {

		patient: EncryptedPatient;

		statuses: { [ key in ShareAllPatientDataOptions_.ShareableEntity ]?: ShareAllPatientDataOptions_.EntityResult };

		constructor(partial: Partial<Result> & Pick<Result, "patient" | "statuses">) {
			this.patient = partial.patient;
			this.statuses = partial.statuses;
		}

	}

	export type SharePatientDataError = BulkShareFailure | FailedRequest;

	export class BulkShareFailure {

		errors: Array<FailedRequestDetails>;

		message: string;

		readonly $ktClass: 'com.icure.cardinal.sdk.crypto.entities.ShareAllPatientDataOptions.BulkShareFailure' = 'com.icure.cardinal.sdk.crypto.entities.ShareAllPatientDataOptions.BulkShareFailure';

		constructor(partial: Partial<BulkShareFailure> & Pick<BulkShareFailure, "errors" | "message">) {
			this.errors = partial.errors;
			this.message = partial.message;
		}

	}

	export class FailedRequest {

		description: string;

		readonly $ktClass: 'com.icure.cardinal.sdk.crypto.entities.ShareAllPatientDataOptions.FailedRequest' = 'com.icure.cardinal.sdk.crypto.entities.ShareAllPatientDataOptions.FailedRequest';

		constructor(partial: Partial<FailedRequest> & Pick<FailedRequest, "description">) {
			this.description = partial.description;
		}

	}

}
