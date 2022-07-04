#!/bin/sh
mvn clean 
mvn org.jacoco:jacoco-maven-plugin:0.8.8:prepare-agent  site
mvn org.pitest:pitest-maven:mutationCoverage test site