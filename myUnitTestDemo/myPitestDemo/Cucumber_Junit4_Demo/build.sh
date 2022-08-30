#!/bin/sh

mvn clean 
mvn compiler:compile   compiler:testCompile  org.pitest:pitest-maven:mutationCoverage 
mvn test