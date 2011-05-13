

// Copyright Shunsuke Sogame 2008-2010.
// Distributed under the terms of an MIT-style license.


import sbt._


class Sing(info: ProjectInfo) extends DefaultProject(info) {
    val junit = "junit" % "junit" % "4.4" % "test"
    val scalatest = "org.scalatest" % "scalatest_2.9.0" % "1.4.1" % "test"

    override def compileOptions = super.compileOptions ++
        Seq(Deprecation, Unchecked/*, ExplainTypes*/) ++
        compileOptions("-Yrecursion", "50")

    override def managedStyle = ManagedStyle.Maven
    override def pomExtra =
        <distributionManagement>
            <repository>
                <id>repo</id>
                <url>http://okomok.github.com/maven-repo/releases</url>
            </repository>
            <repository>
                <id>snapshot-repo</id>
                <url>http://okomok.github.com/maven-repo/snapshots</url>
            </repository>
        </distributionManagement>
    lazy val publishTo = Resolver.file("Publish", new java.io.File("../maven-repo/releases/"))
}