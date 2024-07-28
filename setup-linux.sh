#!/bin/bash

# Exit immediately if a command exits with a non-zero status
set -e

# Function to extract the project version from pom.xml
get_project_version() {
  grep -m1 "<version>" pom.xml | sed -e 's/.*<version>\(.*\)<\/version>.*/\1/'
}

# Extract the project version
VERSION=$(get_project_version)

# Print the version for verification
echo "Project version: $VERSION"

# Clean and package the application
mvn clean package

# Create a directory for extracted files
mkdir -p extracted-jar
cd extracted-jar

# Extract the JAR file
jar xf ../target/aws-firehose-$VERSION.jar

# Create a new JAR file
jar cf aws-firehose.jar -C ./BOOT-INF/classes .

# Clean up and move the new JAR file to the target directory
cd ..
mv extracted-jar/aws-firehose.jar target/

# Remove the extracted-jar directory
rm -rf extracted-jar

echo "Build and packaging complete. The new JAR file is located in the target directory."
