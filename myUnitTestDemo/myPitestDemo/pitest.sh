#!/bin/sh
mvn  clean   
#mvn org.jacoco:jacoco-maven-plugin:0.8.8:prepare-agent  
mvn   test    -f pom-goodTestCases-Junit5.xml
mvn   test    -f pom-badTestCases-Junit4.xml