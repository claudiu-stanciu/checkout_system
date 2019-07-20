import Dependencies._

ThisBuild / scalaVersion     := "2.13.0"
ThisBuild / version          := "2.0.0"
ThisBuild / organization     := "com.stejr"
ThisBuild / organizationName := "checkout"

lazy val root = (project in file("."))
  .settings(
    name := "checkout",
    libraryDependencies += scalaTest % Test
  )

