export function extractEntry(json: any, name: string, required: boolean, path: string[]): any {
  if (name in json) {
    const res = json[name]
    delete json[name]
    return res
  }
  if (required) throw new Error(`Missing required entry '${name}' at ${path.join("")}`)
  return undefined
}

export function expectObject<T>(json: any, nullable: true, ignoreUnknown: boolean, path: string[], decoder: (j: any, i: boolean, p: string[]) => T): T | undefined
export function expectObject<T>(json: any, nullable: false, ignoreUnknown: boolean, path: string[], decoder: (j: any, i: boolean, p: string[]) => T): T
export function expectObject<T>(json: any, nullable: boolean, ignoreUnknown: boolean, path: string[], decoder: (j: any, i: boolean, p: string[]) => T): T | undefined {
  if (json == undefined) {
    if (!nullable) throw new Error(`Expected non-nullable object but got nullish value at ${path.join("")}`)
    return undefined
  }
  return decoder(json, ignoreUnknown, path)
}

export function expectNullish(json: any, path: string[]): undefined {
  if (json == undefined) {
    return undefined
  }
  throw new Error(`Expected undefined but got ${typeof json} at ${path.join("")}`)
}

export function expectString(json: any, nullable: true, path: string[]): string | undefined
export function expectString(json: any, nullable: false, path: string[]): string
export function expectString(json: any, nullable: boolean, path: string[]): string | undefined {
  if (json == undefined) {
    if (!nullable) throw new Error(`Expected non-nullable string but got nullish value at ${path.join("")}`)
    return undefined
  } else if (typeof json === "string") {
    return json
  }
  throw new Error(`Expected string but got ${typeof json} at ${path.join("")}`)
}

export function expectBoolean(json: any, nullable: true, path: string[]): boolean | undefined
export function expectBoolean(json: any, nullable: false, path: string[]): boolean
export function expectBoolean(json: any, nullable: boolean, path: string[]): boolean | undefined {
  if (json == undefined) {
    if (!nullable) throw new Error(`Expected non-nullable boolean but got nullish value at ${path.join("")}`)
    return undefined
  } else if (typeof json === "boolean") {
    return json
  }
  throw new Error(`Expected boolean but got ${typeof json} at ${path.join("")}`)
}

export function expectNumber(json: any, nullable: true, integer: boolean, path: string[]): number | undefined
export function expectNumber(json: any, nullable: false, integer: boolean, path: string[]): number
export function expectNumber(json: any, nullable: boolean, integer: boolean, path: string[]): number | undefined {
  if (json == undefined) {
    if (!nullable) throw new Error(`Expected non-nullable number but got nullish value at ${path.join("")}`)
    return undefined
  } else if (typeof json === "number") {
    if (integer && !Number.isSafeInteger(json)) throw new Error(`Expected safe integer but got non-integer or non-safe-integer at ${path.join("")}`)
    return json
  }
  throw new Error(`Expected number but got ${typeof json} at ${path.join("")}`)
}

export function expectArray<T>(
  json: any,
  nullable: true,
  path: string[],
  transform: (item: any, path: string[]) => T
): T[] | undefined
export function expectArray<T>(
  json: any,
  nullable: false,
  path: string[],
  transform: (item: any, path: string[]) => T
): T[]
export function expectArray<T>(
  json: any,
  nullable: boolean,
  path: string[],
  transform: (item: any, path: string[]) => T
): T[] | undefined {
  if (json == undefined) {
    if (!nullable) throw new Error(`Expected non-nullable array but got nullish value at ${path.join("")}`)
    return undefined
  } else if (Array.isArray(json)) {
    return json.map((item, index) => transform(item, [...path, "[", index.toString(), "]"]))
  }
  throw new Error(`Expected array but got ${typeof json} at ${path.join("")}`)
}

export function expectMap<K extends string | number, V>(
  json: any,
  nullable: true,
  path: string[],
  mapKey: (key: string, path: string[]) => K,
  mapValue: (value: any, path: string[]) => V
): Record<K, V> | undefined
export function expectMap<K extends string | number, V>(
  json: any,
  nullable: false,
  path: string[],
  mapKey: (key: string, path: string[]) => K,
  mapValue: (value: any, path: string[]) => V
): Record<K, V>
export function expectMap<K extends string | number, V>(
  json: any,
  nullable: boolean,
  path: string[],
  mapKey: (key: string, path: string[]) => K,
  mapValue: (value: any, path: string[]) => V
): Record<K, V> | undefined {
  if (json == undefined) {
    if (!nullable) throw new Error(`Expected non-nullable map but got nullish value at ${path.join("")}`)
    return undefined
  } else if (typeof json === "object" && !Array.isArray(json)) {
    const result: Record<K, V> = {} as Record<K, V>
    for (const [key, value] of Object.entries(json)) {
      result[mapKey(key, [...path, "{KEYOF ", key, "}"])] = mapValue(value, [...path, "{", key, "}"])
    }
    return result
  }
  throw new Error(`Expected map (object) but got ${typeof json} at ${path.join("")}`)
}


export function expectStringEnum<T extends { [key: string]: string }>(
  json: any,
  nullable: true,
  path: string[],
  enumType: T,
  enumName: string,
): T[keyof T] | undefined
export function expectStringEnum<T extends { [key: string]: string }>(
  json: any,
  nullable: false,
  path: string[],
  enumType: T,
  enumName: string,
): T[keyof T]
export function expectStringEnum<T extends { [key: string]: string }>(
  json: any,
  nullable: boolean,
  path: string[],
  enumType: T,
  enumName: string,
): T[keyof T] | undefined {
  if (json == undefined) {
    if (!nullable) throw new Error(`Expected non-nullable enum but got nullish value at ${path.join("")}`)
    return undefined
  } else if (typeof json === "string") {
    const values = Object.values(enumType)
    if (values.includes(json)) return json as T[keyof T]
    throw new Error(`Expected value of enum ${enumName} but got "${json}" at ${path.join("")}`)
  }
  throw new Error(`Expected string enum value but got ${typeof json} at ${path.join("")}`)
}