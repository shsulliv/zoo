name := """zoo"""
organization := "com.shannon"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.4"

libraryDependencies += evolutions
libraryDependencies += jdbc
libraryDependencies += guice
libraryDependencies += "org.postgresql" % "postgresql" % "42.1.4"
libraryDependencies += "org.yaml" % "snakeyaml" % "1.17"
