import Dependencies._

ThisBuild / scalaVersion     := "2.13.0"
ThisBuild / version          := "2.0.0"
ThisBuild / organization     := "com.stejr"
ThisBuild / organizationName := "shopping_cart"

lazy val root = (project in file("."))
  .settings(
    name := "shopping_cart",
    libraryDependencies += scalaTest % Test
  )

