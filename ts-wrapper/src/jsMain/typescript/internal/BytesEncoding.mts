function bytesAsString(bytes: Int8Array): string {
  let str = ''
  const ab = new Uint8Array(bytes.buffer)
  const abLen = ab.length
  const CHUNK_SIZE = Math.pow(2, 8)
  let offset, len, subab
  for (offset = 0; offset < abLen; offset += CHUNK_SIZE) {
    len = Math.min(CHUNK_SIZE, abLen - offset)
    subab = ab.subarray(offset, offset + len)
    str += String.fromCharCode.apply(null, subab as any)
  }
  return str
}

function stringAsBytes(s: string): Int8Array {
  const res = new Int8Array(s.length)
  const asUa = new Uint8Array(res.buffer)
  for (let i = 0; i < s.length; i++) {
    asUa[i] = s.charCodeAt(i) & 0xff
  }
  return res
}

function b2a(a: string): string {
  if (typeof window !== 'undefined') {
    //Favour btoa in browser
    if (typeof btoa !== 'undefined') {
      return btoa(a)
    }
    // @ts-ignore
    if (typeof Buffer !== 'undefined') {
      // @ts-ignore
      const buf = Buffer.from(a, 'latin1')
      return buf.toString('base64')
    }
  } else {
    // @ts-ignore
    if (typeof Buffer !== 'undefined') {
      // @ts-ignore
      const buf = Buffer.from(a, 'latin1')
      return buf.toString('base64')
    }
    if (typeof btoa !== 'undefined') {
      return btoa(a)
    }
  }
  throw new Error('Unsupported operation b2a')
}

// Check if the input is a valid base64 string, returning null if invalid, or the properly padded string otherwise.
// If the input is already padded but the amount of padding is wrong the method returns null else it is retuned as is
function validateAndPadBase64(str: string): string | null {
  if (str.length % 4 === 1) return null;
  if (!/^[A-Za-z0-9+/]*={0,2}$/.test(str)) return null;
  const padding = (str.match(/=*$/) || [''])[0].length;
  if (padding > 2) return null;
  if (padding > 0 && str.length % 4 !== 0) return null;
  return (padding > 0) ? str : str + '==='.slice((str.length + 3) % 4);
}

function a2b(s: string): string {
  if (typeof window !== 'undefined') {
    //Favour atob in browser
    if (typeof atob !== 'undefined') {
      return atob(s)
    }
    // @ts-ignore
    if (typeof Buffer !== 'undefined') {
      // @ts-ignore
      const buf = new Buffer(s, 'base64')
      return buf.toString('latin1')
    }
  } else {
    // @ts-ignore
    if (typeof Buffer !== 'undefined') {
      // @ts-ignore
      const buf = new Buffer(s, 'base64')
      return buf.toString('latin1')
    }
    if (typeof atob !== 'undefined') {
      return atob(s)
    }
  }
  throw new Error('Unsupported operation a2b')
}

// Decode a base64 string using the url-unsafe alphabet to an Int8Array
export function decodeBase64(s: string, path: string[]): Int8Array
export function decodeBase64(s: string | undefined, path: string[]): Int8Array | undefined {
  if (s == undefined) return undefined
  const padded = validateAndPadBase64(s)
  if (padded == null) throw new Error(`Invalid base64 string '${s}' at ${path.join()}`)
  return stringAsBytes(a2b(s))
}

// Encode an Int8Array to a base64 string using the url-unsafe alphabet
export function encodeBase64(bytes: Int8Array): string {
  return b2a(bytesAsString(bytes))
}