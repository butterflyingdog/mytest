#!/bin/sh
mvn  clean
mvn org.jacoco:jacoco-maven-plugin:0.8.8:prepare-agent  
mvn   test org.pitest:pitest-maven:mutationCoverage    site