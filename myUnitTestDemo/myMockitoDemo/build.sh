#!/bin/sh
mvn test evosuite:generate
#mvn clean compiler:compile   compiler:testCompile  org.pitest:pitest-maven:mutationCoverage test