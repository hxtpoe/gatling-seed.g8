import Dependencies._

ThisBuild / scalaVersion     := "2.12.9"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "$organization$"
ThisBuild / organizationName := "$organizationName$"

lazy val root = (project in file("."))
  .enablePlugins(GatlingPlugin)
  .settings(
    name := "$name$",
    javaOptions in Gatling := overrideDefaultJavaOptions("-Xms1024m", "-Xmx2048m"),
    scalacOptions := Seq(
      "-encoding", "UTF-8", "-target:jvm-1.8", "-deprecation",
      "-feature", "-unchecked", "-language:implicitConversions", "-language:postfixOps"),
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "3.3.1" % "test,it",
    libraryDependencies += "io.gatling"            % "gatling-test-framework"    % "3.3.1" % "test,it")