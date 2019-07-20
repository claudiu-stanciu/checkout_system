import Dependencies._

ThisBuild / scalaVersion     := "2.13.0"
ThisBuild / version          := "0.2.0"
ThisBuild / organization     := "com.stejr"
ThisBuild / organizationName := "hmrc_shopping_cart"

lazy val root = (project in file("."))
  .settings(
    name := "hmrc_shopping_cart",
    libraryDependencies += scalaTest % Test
  )

