#!/bin/bash
#
# Tilda Build Script
# Compiles the Tilda source code and creates necessary directories
#

# Set default environment variables if not already set
: ${JAVA_HOME:="$(which java 2>/dev/null | xargs readlink -f 2>/dev/null | xargs dirname 2>/dev/null | xargs dirname 2>/dev/null)"}

# Get absolute paths
SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
PROJECT_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"

: ${LIB:="$PROJECT_ROOT/lib"}
: ${SRC:="$PROJECT_ROOT/src"}
: ${SRC_ANTLR:="$PROJECT_ROOT/src-antlr4"}
: ${BIN:="$PROJECT_ROOT/bin"}

# Find Java executable
if [ -z "$JAVA_HOME" ]; then
  JAVAC_CMD="javac"
else
  JAVAC_CMD="$JAVA_HOME/bin/javac"
fi

# Create bin directory if it doesn't exist
mkdir -p "$BIN"

# Build classpath from lib directory
CLASSPATH=""
for jar in "$LIB"/*.jar "$LIB"/**/*.jar; do
  if [ -f "$jar" ]; then
    if [ -z "$CLASSPATH" ]; then
      CLASSPATH="$jar"
    else
      CLASSPATH="$CLASSPATH:$jar"
    fi
  fi
done

echo "===== Tilda Build Script ====="
echo "Java compiler: $JAVAC_CMD"
echo "Source directory: $SRC"
echo "Output directory: $BIN"
echo "Library directory: $LIB"
echo "Classpath length: $(echo $CLASSPATH | wc -c) characters"

# Find all Java files
echo "Finding Java source files..."
JAVA_FILES=$(find "$SRC" "$SRC_ANTLR" -name "*.java" 2>/dev/null)
JAVA_FILE_COUNT=$(echo "$JAVA_FILES" | wc -l)
echo "Found $JAVA_FILE_COUNT Java source files"

# Compile Java files
echo "Compiling Java source files..."
echo "$JAVA_FILES" | xargs $JAVAC_CMD -d "$BIN" -cp "$CLASSPATH" -source 1.8 -target 1.8 -Xlint:deprecation

if [ $? -eq 0 ]; then
  echo "Build successful! Output directory: $BIN"
  echo "You can now run Tilda commands using the tilda.sh script"
else
  echo "Build failed. Please check the error messages above."
  exit 1
fi
