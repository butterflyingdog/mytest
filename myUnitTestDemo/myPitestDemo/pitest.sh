#!/bin/sh
mvn  clean  -f pom-cucumber-Junit4.xml
#mvn org.jacoco:jacoco-maven-plugin:0.8.8:prepare-agent  
#mvn   test    -f pom-goodTestCases-Junit5.xml
#mvn   test    -f pom-badTestCases-Junit4.xml

#mvn  compiler:compile  compiler:testCompile  org.pitest:pitest-maven:mutationCoverage  -f pom-cucumber-Junit4.xml -e 
mvn  test org.pitest:pitest-maven:mutationCoverage  -f pom-cucumber-Junit4.xml -e 
# mvn  site -f pom-cucumber-Junit4.xml -e 
# mvn   test org.pitest:pitest-maven:mutationCoverage  -f pom-cucumber-Junit5.xml -e