@echo off
REM Clean and package the application
mvn clean package

REM Create a directory for extracted files
mkdir extracted-jar
cd extracted-jar

REM Extract the JAR file
jar xf ..\target\aws-firehose-0.0.5-SNAPSHOT.jar

REM Create a new JAR file
jar cf aws-firehose.jar -C ./BOOT-INF/classes .

REM Clean up and move the new JAR file to the target directory
cd ..
move extracted-jar\aws-firehose.jar target\

REM Remove the extracted-jar directory
rmdir /s /q extracted-jar

echo Build and packaging complete. The new JAR file is located in the target directory.
pause
