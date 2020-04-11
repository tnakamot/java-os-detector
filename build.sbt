Global / onChangedBuildSource := IgnoreSourceChanges

lazy val root = (project in file("."))
  .enablePlugins(GitVersioning)
  .settings(
    name         := "java-os-detector",
    organization := "com.github.tnakamot",
    organizationName := "tnakamot",
    organizationHomepage := Some(url("https://github.com/tnakamot")),
    description  := "Java library which returns normalized OS and architecture name based on os.name and os.arch system properties.",
    licenses     += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0")),
    scalaVersion := "2.12.10",
    crossPaths   := false, // Do not use Scala version in artifacts.

    publishMavenStyle := true,
    bintrayReleaseOnPublish in ThisBuild := false,
    bintrayRepository := "maven",

    // Following information is provided to fulfill requirements of Maven Central.
    scmInfo := Some( ScmInfo(
          url("https://github.com/tnakamot/java-os-detector"),
          "scm:git@github.com:tnakamot/java-os-detector.git"
    )),
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