#!/bin/sh

wget -O jacocoagent.jar https://gitlab.com/gitlab-org/security-products/analyzers/fuzzers/javafuzz/-/raw/master/javafuzz-maven-plugin/src/main/resources/jacocoagent-exp.jar
MAVEN_OPTS="-javaagent:jacocoagent.jar" mvn javafuzz:fuzz -DclassName=FuzzExample
