import xerial.sbt.Sonatype._

Global / onChangedBuildSource := IgnoreSourceChanges

lazy val root = (project in file("."))
  .enablePlugins(GitVersioning)
  .settings(
    name         := "java-os-detector",
    organization := "com.github.tnakamot",
    description  := "Java library which returns normalized OS and architecture name based on os.name and os.arch system properties.",
    scalaVersion := "2.12.10",
    crossPaths   := false, // Do not use Scala version in artifacts.

    // For sbt-sonatype plugin to publish this package to Maven Central.
    publishTo := sonatypePublishToBundle.value,
    sonatypeProfileName := "com.github.tnakamot",
    publishMavenStyle := true,
    licenses     += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0")),
    sonatypeProjectHosting := Some(GitHubHosting("tnakamot", "java-os-detector", "nyakamoto@gmail.com")),
    developers := List(
      Developer(
        id    = "nyakamoto",
        name  = "Takashi Nakamoto",
        email = "nyakamoto@gmail.com",
        url   = url("https://github.com/tnakamot"),
      )
    ),
    homepage := Some(url("https://github.com/tnakamot/java-os-detector"))
  )