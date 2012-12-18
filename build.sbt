name := "scala-uri"

organization  := "com.github.theon"

version       := "0.2-SNAPSHOT"

scalaVersion  := "2.10.0-RC5"

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.10.0-RC5" % "2.0.M5-B1" % "test"
)

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

pomExtra := (
  <url>https://github.com/theon/scala-uri</url>
  <licenses>
    <license>
      <name>Apache 2</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:theon/scala-uri.git</url>
    <connection>scm:git@github.com:theon/scala-uri.git</connection>
  </scm>
  <developers>
    <developer>
      <id>theon</id>
      <name>Ian Forsey</name>
      <url>http://theon.github.com</url>
    </developer>
  </developers>)
