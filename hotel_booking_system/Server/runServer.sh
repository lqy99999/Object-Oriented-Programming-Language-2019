#!/bin/bash

set -e

javac -cp .:json-simple-1.1.1.jar Server.java
java -cp .:json-simple-1.1.1.jar Server
