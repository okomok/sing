

name := "sing"

organization := "com.github.okomok"

version := "0.1.1-SNAPSHOT"

scalaVersion := "2.10.1"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature") ++ Seq("-Yrecursion", "50") ++ Seq("-language", "higherKinds")

libraryDependencies ++= Seq(
    "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test",
    "junit" % "junit" % "4.4" % "test"
)

parallelExecution := false

publishArtifact in packageDoc := false

