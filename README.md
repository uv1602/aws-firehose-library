# AWS Firehose Application

## Description

This project is a Spring Boot application that includes a custom logger for AWS Firehose.

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Apache Maven
- An internet connection for Maven dependencies

## Building the Project

To build and package the application into a JAR file, follow these steps:

1. Open a command prompt or terminal window.
2. Navigate to the root directory of the project where the `pom.xml` file is located.
3. Run the following batch file:

   ```batch
   build-package.bat
   ```

mvn clean package
cd extracted-jar
jar xf ..\target\aws-firehose-0.0.5-SNAPSHOT.jar
jar cf aws-firehose.jar -C ./BOOT-INF/classes .
