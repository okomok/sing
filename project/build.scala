import sbt._
import Keys._

object build extends Build {
    lazy val singSettings = Project.defaultSettings ++ Seq(
        organization := "com.github.okomok",
        version := "0.1.1-SNAPSHOT",
        scalaVersion := "2.9.1",
        crossScalaVersions := Seq("2.9.1", "2.10.0-SNAPSHOT"),
        scalacOptions ++= Seq("-deprecation", "-unchecked") ++ Seq("-Yrecursion", "50"),
        libraryDependencies ++= Seq(
            "org.scalatest" % "scalatest_2.9.0" % "1.6.1" % "test",
            "junit" % "junit" % "4.4" % "test"
        ),
        resolvers += ScalaToolsSnapshots,
        parallelExecution := false,
        publishArtifact in packageDoc := false
    )

    lazy val sing = Project(
        id = "sing",
        base = file("."),
        settings = singSettings
    )
}
