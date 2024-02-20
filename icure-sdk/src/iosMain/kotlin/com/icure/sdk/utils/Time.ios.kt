package com.icure.sdk.utils

import platform.Foundation.NSDate
import platform.Foundation.timeIntervalSince1970

actual fun currentEpochMs(): Long = (NSDate().timeIntervalSince1970 * 1000).toLong()