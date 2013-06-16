import sbt._
import Keys._

object build extends Build {
    lazy val theSettings = Project.defaultSettings ++ Seq(
        organization := "com.github.okomok",
        version := "0.2.0-SNAPSHOT",
        scalaVersion := "2.11.0-SNAPSHOT",

        scalacOptions ++=
            Seq("-unchecked", "-deprecation", "-feature") ++
            Seq("-Yrecursion", "50") ++ Seq("-language", "higherKinds"),

        scalaOrganization := "org.scala-lang.macro-paradise",

        libraryDependencies ++= Seq(
            "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test",
            "junit" % "junit" % "4.4" % "test"
        ),

        resolvers += Resolver.sonatypeRepo("snapshots"),

        parallelExecution := false,
        publishArtifact in packageDoc := false,
        offline := true
    )

    lazy val root = Project(
        "root",
        file("core"),
        settings = theSettings
    ) aggregate(macros, core)

    lazy val macros = Project(
        "macros",
        file("macros"),
        settings = theSettings ++ Seq(
            libraryDependencies <+= (scalaVersion)("org.scala-lang.macro-paradise" % "scala-reflect" % _))
    )

    lazy val core = Project(
        "core",
        file("core"),
        settings = theSettings
    ) dependsOn(macros)
}
