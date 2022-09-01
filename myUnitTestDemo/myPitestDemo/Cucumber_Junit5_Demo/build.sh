#!/bin/sh
mvn clean

mvn test-compile  org.pitest:pitest-maven:mutationCoverage  test
# mvn test