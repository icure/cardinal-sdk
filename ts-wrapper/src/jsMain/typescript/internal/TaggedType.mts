declare const tags: unique symbol;
/**
 * Cardinal uses tagged types to help prevent mixing up values that have the same underlying type but represent
 * different concepts.
 * For example, a `SpkiHexString` should always be the hex-encoded spki representation of a public key.
 *
 * When a method expects a tagged type, you must provide a value that has already been tagged by cardinal, or you must
 * explicitly tag it yourself, if you know that the value matches what the tagged type represent.
 *
 * Note that tagging a value yourself does not perform any runtime validation, but will cause methods to fail down the
 * line, which could result in possibly hard to debug errors.
 * Therefore, only tag values yourself if you are certain that the value matches what the tagged type represents.
 *
 * # Example
 *
 * ```typescript
 * function doSomethingWithSpki(spki: SpkiHexString) { }
 * function getSpkiFromSomewhere(): SpkiHexString { }
 *
 * doSomethingWithSpki(getSpkiFromSomewhere()) // OK, type is already tagged
 * doSomethingWithSpki('3059...3d3f') // Compile error, must tag explicitly
 * doSomethingWithSpki('3059...3d3f' as SpkiHexString) // OK, tagged explicitly
 * doSomethingWithSpki('probablyNotSpki' as SpkiHexString) // Bad tagging: no compile error, but will likely fail at runtime
 * ```
 *
 * # Further reading
 * https://medium.com/@ethanresnick/advanced-typescript-tagged-types-for-fewer-bugs-and-better-security-24db681d5721
 */
export type Tagged<BaseType, Tag extends PropertyKey> = BaseType & { [tags]: { [K in Tag]: void } };
