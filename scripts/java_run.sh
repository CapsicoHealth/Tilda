#!/bin/bash
# Cross-platform shell script for running Java applications in the Tilda project
# Usage: ./java_run.sh [Java class name] [arguments...]

# Default library path - can be overridden by setting LIB environment variable before calling this script
LIB=${LIB:-"./lib"}

# Default Java memory settings - can be overridden by setting JAVA_OPTS environment variable
JAVA_OPTS=${JAVA_OPTS:-"-Xms192M -Xmx256M"}

# Find Java executable
if [ -z "$JAVA_HOME" ]; then
  JAVA_CMD="java"
else
  JAVA_CMD="$JAVA_HOME/bin/java"
fi

# Build classpath
if [ -z "$CLASSPATH" ]; then
  CLASSPATH="$LIB/*:."
else
  CLASSPATH="$CLASSPATH:$LIB/*:."
fi

# Execute Java with all arguments passed through
echo "Running: $JAVA_CMD $JAVA_OPTS -cp $CLASSPATH $@"
$JAVA_CMD $JAVA_OPTS -cp "$CLASSPATH" "$@"
