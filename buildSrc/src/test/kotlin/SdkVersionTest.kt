import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SdkVersionTest {
	@Test
	fun acceptsOnlyReleaseVersions() {
		listOf("2.14.0", "2.14.11", "2.15.0-PREVIEW.1", "10.0.123").forEach { assertTrue(SdkVersion.isReleaseVersion(it), it) }
		listOf("ts-2.14.11", "2.14.11-PREVIEW-1", "2.14", "2.14.10-SNAPSHOT", "02.14.0", "2.15.0-PREVIEW.0", "")
			.forEach { assertFalse(SdkVersion.isReleaseVersion(it), it) }
	}

	@Test
	fun devVersionUsesTheHighestBareFinalTag() {
		val tags = listOf("2.13.5", "2.14.9", "2.14.10", "ts-2.14.11", "2.15.0-PREVIEW.1", "1.0.0-RC.4", "2.0.0-PREVIEW-16")
		assertEquals("2.14.10-SNAPSHOT", SdkVersion.devVersion(tags))
	}

	@Test
	fun devVersionFallsBackWithoutTags() {
		assertEquals("0.0.0-SNAPSHOT", SdkVersion.devVersion(emptyList()))
		assertEquals("0.0.0-SNAPSHOT", SdkVersion.devVersion(listOf("", "ts-2.14.11", "kraken-lite-26.09.1")))
	}

	@Test
	fun convertsToPep440() {
		assertEquals("2.14.11", SdkVersion.toPep440("2.14.11"))
		assertEquals("2.15.0rc3", SdkVersion.toPep440("2.15.0-PREVIEW.3"))
		assertEquals("2.14.10.dev0", SdkVersion.toPep440("2.14.10-SNAPSHOT"))
		assertEquals("0.0.0.dev0", SdkVersion.toPep440(SdkVersion.FALLBACK))
	}
}
