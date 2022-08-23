#!/bin/sh
mvn  clean  -f pom-goodTestCases.xml
#mvn org.jacoco:jacoco-maven-plugin:0.8.8:prepare-agent  
mvn   test      -f pom-goodTestCases.xml
mvn   test    -f pom-badTestCases.xml