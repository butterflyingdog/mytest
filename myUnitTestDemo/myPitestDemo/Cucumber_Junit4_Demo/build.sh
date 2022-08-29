#!/bin/sh
 
mvn clean compiler:compile   compiler:testCompile  org.pitest:pitest-maven:mutationCoverage 