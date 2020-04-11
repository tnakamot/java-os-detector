# java-os-detector

This is a Java library providing methods to get normalized OS and architecture name
based on `os.name` and `os.arch` system properties. The normalized names provided by
this library is useful for platform-dependent projects.

This is a repackage of [os-maven-plugin](https://github.com/trustin/os-maven-plugin),
which is meant to be used in pom.xml. On the other hands, this library is
very minimal and meant to be used in other Java programs.

Below is a quote from [os-maven-plugin](https://github.com/trustin/os-maven-plugin)
to explain the benefit of this library.

    ${os.name} and ${os.arch} are often subtly different between JVM and operating system
    versions or they sometimes contain machine-unfriendly characters such as whitespaces.
    This plugin tries to remove such fragmentation so that you can determine the current
    operating system and architecture reliably.

## Install

The packages of this library are distributed through 
[JCenter](https://bintray.com/bintray/jcenter). You do not have to add additional
repository to your build system.

### Maven

Add the following lines to your pom.xml.

    <dependency>
      <groupId>com.github.tnakamot</groupId>
      <artifactId>java-os-detector</artifactId>
      <version>0.1.0</version>
      <type>pom</type>
    </dependency>

### sbt

To use this library in your sbt project, add the following sbt setting
 (e.g. in build.sbt). 

    libraryDependencies += "com.github.tnakamot" % "java-os-detector" % "0.1.0",

## Usage

This library provides only one class `Detector`. First import this class in
your Java program.

    import com.github.tnakamot.os.Detector;

This class provides two static public methods.

    Detector.getNormalizedOSName();
    Detector.getNormalizedArchitectureName();

They return a String of the normalized OS and architecture name respectively.
To know what actually the normalized OS and architecture names are, see
the description about `os.detected.name` and `os.detected.arch` properties
of [os-maven-plugin](https://github.com/trustin/os-maven-plugin).
