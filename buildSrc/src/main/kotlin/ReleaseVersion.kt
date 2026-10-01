/**
 * Version of the published SDK, see RELEASING.md.
 *
 * Releases pass it as the `sdkVersion` Gradle property (the-forge sets `ORG_GRADLE_PROJECT_sdkVersion` from the
 * release tag, without its unit prefix). Other builds derive a snapshot version from the git tags.
 */
object ReleaseVersion {
	private val releaseVersion = Regex("""^(0|[1-9]\d*)\.(0|[1-9]\d*)\.(0|[1-9]\d*)(-PREVIEW\.[1-9]\d*)?$""")
	private val bareFinalTag = Regex("""^(0|[1-9]\d*)\.(0|[1-9]\d*)\.(0|[1-9]\d*)$""")

	const val FALLBACK = "0.0.0-SNAPSHOT"

	fun isReleaseVersion(version: String): Boolean = releaseVersion.matches(version)

	/** `<highest bare final tag>-SNAPSHOT`, or [FALLBACK] when there is none. */
	fun devVersion(tags: List<String>): String =
		tags.mapNotNull { tag ->
			bareFinalTag.matchEntire(tag.trim())?.destructured?.let { (major, minor, patch) ->
				Triple(major.toInt(), minor.toInt(), patch.toInt()) to tag.trim()
			}
		}
			.maxWithOrNull(compareBy({ it.first.first }, { it.first.second }, { it.first.third }))
			?.let { "${it.second}-SNAPSHOT" }
			?: FALLBACK

	/** The PEP 440 form of [version], for the Python wheel. */
	fun toPep440(version: String): String =
		if (version.endsWith("-SNAPSHOT")) {
			"${version.removeSuffix("-SNAPSHOT")}.dev0"
		} else {
			version.replace("-PREVIEW.", "rc")
		}
}
