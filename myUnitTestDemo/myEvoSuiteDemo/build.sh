#!/bin/sh
mvn clean compile evosuite:generate evosuite:export  -DtargetFolder=target/generated-test-sources
