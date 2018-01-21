name := """zoo"""
organization := "com.shannon"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.4"

libraryDependencies += jdbc
libraryDependencies += guice
