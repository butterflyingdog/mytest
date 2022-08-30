#!/bin/sh
mvn clean
 #mvn test
mvn clean compiler:compile   compiler:testCompile  #org.pitest:pitest-maven:mutationCoverage test