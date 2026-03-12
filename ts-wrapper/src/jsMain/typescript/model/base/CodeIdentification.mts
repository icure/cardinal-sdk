// auto-generated file

/**
 *
 *
 *   Interface for entities that can be identified by a code from a codification system.
 *   The id is typically composed as type|code|version.
 */
export interface CodeIdentification<K> {

	id: K;

	code: string | undefined;

	context: string | undefined;

	type: string | undefined;

	version: string | undefined;

}
