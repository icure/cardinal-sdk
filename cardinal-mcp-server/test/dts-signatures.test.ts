import { describe, it, expect } from "vitest";
import { parseMethodSignatures } from "../scripts/dts-signatures.js";

/**
 * Unit tests for the `.d.mts` signature parser behind generated/method-registry.ts. The fixtures copy the shapes
 * `@icure/cardinal-sdk` really emits (see node_modules/@icure/cardinal-sdk/api/*.d.mts): properties before the
 * methods, KDoc blocks between members, and object-literal parameter and return types spread over several lines.
 */

const PATIENT_API = `
import { User } from '../model/User.mjs';
export interface PatientApi {
    encrypted: PatientFlavouredApi<EncryptedPatient>;
    tryAndRecover: PatientFlavouredApi<Patient>;
    inGroup: PatientInGroupApi;
    /**
     *
     *  Decrypts patients, throwing an exception if it is not possible.
     *  @param patients encrypted patients
     *  @return the decrypted patients
     */
    decrypt(patients: Array<EncryptedPatient>): Promise<Array<DecryptedPatient>>;
    getSecretIdsOf(patient: Patient): Promise<{
        [key: string]: Array<EntityReferenceInGroup>;
    }>;
    /**
     *
     *  Creates a new patient with initialized encryption metadata
     *  @param base a patient with initialized content and uninitialized encryption metadata. The result of this
     *  method takes the content from [base] if provided.
     *  @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
     */
    withEncryptionMetadata(base: DecryptedPatient | undefined, options?: {
        user?: User | undefined;
        delegates?: {
            [key: string]: AccessLevel;
        };
        alternateRootDelegateId?: string | undefined;
    }): Promise<DecryptedPatient>;
    hasWriteAccess(patient: Patient): Promise<boolean>;
}
`;

const DOCUMENT_API = `
export interface DocumentApi {
    getAndDecryptMainAttachment(document: Document, options?: {
        decryptedAttachmentValidator?: (x1: Int8Array) => Promise<boolean>;
    }): Promise<Int8Array>;
}
`;

const GROUP_API = `
export interface GroupApi {
    /**
     *  Lists the apps. Call \`getGroup(id: string): Promise<Group>;\` for a single one, or
     *  \`findGroups(id: string, options?: { limit?: number; }): Promise<PaginatedList<Group>>;\` to page.
     */
    listApps(): Promise<Array<Group>>;
}
`;

function method(dts: string, name: string) {
	return parseMethodSignatures(dts).find(m => m.name === name);
}

describe("parseMethodSignatures", () => {
	it("parses a single-line method with its parameter and return type", () => {
		expect(method(PATIENT_API, "decrypt")).toEqual({
			name: "decrypt",
			params: [{ name: "patients", type: "Array<EncryptedPatient>", optional: false }],
			returnType: "Promise<Array<DecryptedPatient>>",
		});
	});

	it("keeps a signature whole when a parameter type is an object literal spread over several lines", () => {
		const m = method(PATIENT_API, "withEncryptionMetadata");
		expect(m).toBeDefined();
		expect(m!.params.map(p => p.name)).toEqual(["base", "options"]);
		expect(m!.params[0]).toEqual({ name: "base", type: "DecryptedPatient | undefined", optional: false });
		expect(m!.params[1].optional).toBe(true);
		expect(m!.params[1].type).toContain("user?: User | undefined");
		expect(m!.params[1].type).toContain("delegates?: { [key: string]: AccessLevel; }");
		expect(m!.returnType).toBe("Promise<DecryptedPatient>");
	});

	it("keeps a return type whole when it is an object literal spread over several lines", () => {
		expect(method(PATIENT_API, "getSecretIdsOf")!.returnType).toBe(
			"Promise<{ [key: string]: Array<EntityReferenceInGroup>; }>",
		);
	});

	it("lists every method of the interface, in order, and no property", () => {
		expect(parseMethodSignatures(PATIENT_API).map(m => m.name)).toEqual([
			"decrypt",
			"getSecretIdsOf",
			"withEncryptionMetadata",
			"hasWriteAccess",
		]);
	});

	it("accepts a function type inside an options object", () => {
		const m = method(DOCUMENT_API, "getAndDecryptMainAttachment");
		expect(m).toBeDefined();
		expect(m!.params.map(p => p.name)).toEqual(["document", "options"]);
		expect(m!.params[1].type).toContain("(x1: Int8Array) => Promise<boolean>");
		expect(m!.returnType).toBe("Promise<Int8Array>");
	});

	it("ignores signatures quoted inside KDoc and parses a parameterless method", () => {
		expect(parseMethodSignatures(GROUP_API)).toEqual([
			{ name: "listApps", params: [], returnType: "Promise<Array<Group>>" },
		]);
	});
});
