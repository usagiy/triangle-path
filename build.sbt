ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "min-triangle-path",
    idePackagePrefix := Some("com.zlatko"),
    version := "1.0",
    libraryDependencies ++= Seq(
      "org.slf4j" % "slf4j-api" % "1.7.32",
      "ch.qos.logback" % "logback-classic" % "1.2.3",
      "org.scalatest" %% "scalatest" % "3.2.10" % Test
    )


  )
