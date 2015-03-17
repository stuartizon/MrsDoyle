import com.typesafe.sbt.SbtNativePackager._

packageArchetype.java_application

Revolver.settings: Seq[sbt.Def.Setting[_]]

name := "mrs-doyle"

version := "1.0"

val sprayVersion = "1.3.2"
val akkaVersion = "2.3.6"

libraryDependencies ++= Seq(
  "io.spray" %% "spray-can" % sprayVersion,
  "io.spray" %% "spray-routing" % sprayVersion,
  "io.spray" %% "spray-client" % sprayVersion,
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-kernel" % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "ch.qos.logback" % "logback-classic" % "1.1.2",
  "org.slf4j" % "slf4j-nop" % "1.6.4"
)
