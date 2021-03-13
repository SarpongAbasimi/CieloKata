name := "resource"

version := "0.1"

scalaVersion := "2.13.4"

libraryDependencies ++= Seq(
//  "org.typelevel" %% "cats-effect" % "2.3.1",
  "org.scalatest" %% "scalatest" % "3.2.2" % "test",
  "com.codecommit" %% "cats-effect-testing-scalatest" % "1.0-26-0b34520" % Test,
  "org.scalatestplus" %% "mockito-3-4" % "3.2.2.0" % "test",
  "org.mockito" % "mockito-core" % "3.7.7" % Test,
  "ch.qos.logback" % "logback-classic" % "1.3.0-alpha5" % Test,
  "org.slf4j" % "slf4j-api" % "2.0.0-alpha1"
)
