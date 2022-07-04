#!/bin/sh
mvn clean org.jacoco:jacoco-maven-plugin:0.8.8:prepare-agent  site
mvn org.pitest:pitest-maven:mutationCoverage site