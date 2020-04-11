Global / onChangedBuildSource := IgnoreSourceChanges

lazy val root = (project in file("."))
  .enablePlugins(GitVersioning)
  .settings(
    name         := "java-os-detector",
    organization := "com.github.tnakamot",
    description  := "Java library which returns normalized OS and architecture name based on ${os.name} and ${os.arch} properties.",
    licenses     += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0")),
    scalaVersion := "2.12.10",

    publishMavenStyle := true,
    bintrayReleaseOnPublish in ThisBuild := false,
    bintrayRepository := "maven",
  )