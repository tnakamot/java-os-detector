ThisBuild / name         := "java-os-detector"
ThisBuild / version      := "0.1"
ThisBuild / scalaVersion := "2.13.1"

lazy val root = (project in file("."))
  .settings(
    name         := "java-os-detector",
    organization := "com.github.tnakamot",
    description  := "Java library which returns normalized OS and architecture name based on ${os.name} and ${os.arch} properties.",
    licenses     += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0")),
    scalaVersion := "2.12.10",
  )