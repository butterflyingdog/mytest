#!/bin/sh
mvn clean  evosuite:clean  compile evosuite:generate  test #  -Dcores=2