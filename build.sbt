name := """zoo"""
organization := "com.shannon"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.4"

libraryDependencies += evolutions
libraryDependencies += jdbc
libraryDependencies += guice
libraryDependencies += "org.postgresql" % "postgresql" % "42.1.4"
libraryDependencies += "org.postgresql" % "postgresql" % "9.4-1201-jdbc41"
libraryDependencies += "org.yaml" % "snakeyaml" % "1.17"
libraryDependencies += "net.aksingh" % "owm-japis" % "2.5.2.1"
libraryDependencies += "org.webjars" % "bootstrap" % "4.0.0"

herokuAppName in Compile := "powerful-fjord-46456"