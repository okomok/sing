import sbt._
import Keys._

object build extends Build {
    lazy val theSettings = Project.defaultSettings ++ Seq(
        organization := "com.github.okomok"
        , version := "0.2.0-SNAPSHOT"
        , scalaVersion := "2.11.0"

        , scalacOptions ++=
            Seq("-unchecked", "-deprecation", "-feature")
            ++ Seq("-Yrecursion", "50") ++ Seq("-language", "higherKinds")

        ,libraryDependencies ++= Seq(
            "org.scalatest" % "scalatest_2.11" % "2.1.5" % "test"
            , "junit" % "junit" % "4.4" % "test"
        )

        , parallelExecution := false
        , publishArtifact in packageDoc := false
//        , offline := true

//        , resolvers += Resolver.sonatypeRepo("releases")
//        , addCompilerPlugin("org.scalamacros" % "paradise" % "2.0.0" cross CrossVersion.full)
    )

    lazy val root = Project(
        "sing-root"
        , file(".")
        , settings = theSettings ++ Seq(
            publish := ()
            , publishLocal := ()
        )
    ) aggregate(macros, core)

    lazy val macros = Project(
        "sing-macros"
        , file("macros")
        , settings = theSettings ++ Seq(
            libraryDependencies <+= (scalaVersion)("org.scala-lang" % "scala-reflect" % _)
        )
    )

    lazy val core = Project(
        "sing-core"
        , file("core")
        , settings = theSettings
    ) dependsOn(macros)
}
