#!/bin/bash
#
# Tilda Command Line Interface
# A unified interface for running Tilda utilities
#

# Set default environment variables if not already set
: ${JAVA_HOME:="$(which java 2>/dev/null | xargs readlink -f 2>/dev/null | xargs dirname 2>/dev/null | xargs dirname 2>/dev/null)"}
: ${JAVA_OPTS:="-Xms192M -Xmx512M"}
: ${LIB:="$(dirname $(dirname $0))/lib"}
: ${BIN:="$(dirname $(dirname $0))/bin"}
: ${CLASSPATH:=""}

# Build classpath
if [ -z "$CLASSPATH" ]; then
  CLASSPATH="$BIN:$LIB/*:."
else
  CLASSPATH="$CLASSPATH:$BIN:$LIB/*:."
fi

# Check if the project is built
check_build() {
  if [ ! -d "$BIN" ] || [ -z "$(ls -A "$BIN" 2>/dev/null)" ]; then
    echo "Error: Tilda project is not built yet."
    echo "Please run './build.sh' first to compile the project."
    return 1
  fi
  return 0
}

# Find Java executable
if [ -z "$JAVA_HOME" ]; then
  JAVA_CMD="java"
else
  JAVA_CMD="$JAVA_HOME/bin/java"
fi

# Get main class for a command
get_main_class() {
  case "$1" in
    "gen")
      echo "tilda.Gen"
      ;;
    "migrate")
      echo "tilda.Migrate"
      ;;
    "docs")
      echo "tilda.Docs"
      ;;
    "reverse")
      echo "tilda.Reverse"
      ;;
    "reorg")
      echo "tilda.Reorg"
      ;;
    "load")
      echo "tilda.Load"
      ;;
    "analyze")
      echo "tilda.DBAnalyzer"
      ;;
    "check-db")
      echo "tilda.CheckDB"
      ;;
    "help")
      echo ""
      ;;
    *)
      echo ""
      ;;
  esac
}

# Display usage information
function show_usage {
  echo "Tilda Command Line Interface"
  echo "Usage: tilda <command> [options]"
  echo ""
  echo "Available commands:"
  echo "  gen       - Generate code from Tilda schema definitions"
  echo "  migrate   - Migrate database to match Tilda schema definitions"
  echo "  docs      - Generate documentation for Tilda schemas"
  echo "  reverse   - Reverse engineer database schema to Tilda JSON"
  echo "  reorg     - Reorganize database tables"
  echo "  load      - Load data into database"
  echo "  analyze   - Analyze database structure"
  echo "  check-db  - Check database connectivity"
  echo "  help      - Show this help message or help for a specific command"
  echo ""
  echo "Environment variables:"
  echo "  JAVA_HOME - Java installation directory"
  echo "  JAVA_OPTS - JVM options (default: -Xms192M -Xmx512M)"
  echo "  LIB       - Library directory (default: ./lib)"
  echo "  CLASSPATH - Additional classpath entries"
  echo ""
  echo "For more information on a specific command, use: tilda help <command>"
}

# Display command-specific help
function show_command_help {
  case "$1" in
    "gen")
      echo "Tilda code generation utility"
      echo "Usage: tilda gen <schema.json> [<schema2.json> ...]"
      echo ""
      echo "Takes one or more paths to Tilda JSON schema files and generates:"
      echo "  - Java code"
      echo "  - Database migration scripts"
      echo "  - Documentation"
      ;;
    "migrate")
      echo "Tilda migration utility"
      echo "Usage: tilda migrate"
      echo ""
      echo "Migrates the database connected via the 'MAIN' connection in tilda.config.json"
      echo "using all Tilda schema definitions found in JARs in the classpath."
      ;;
    "docs")
      echo "Tilda documentation utility"
      echo "Usage: tilda docs <output-folder>"
      echo ""
      echo "Takes one mandatory parameter, a folder where to put the documentation files"
      echo "from active Tilda schemas in the classpath."
      ;;
    "reverse")
      echo "Tilda reverse utility"
      echo "Usage: tilda reverse <schema> [<table>]"
      echo ""
      echo "Reverse engineers a whole Schema or Table from the database and generates a tilda.json file."
      echo "  - <schema>: The name of the schema to reverse engineer"
      echo "  - <table>: Optional, the name of a specific table to reverse engineer"
      ;;
    "reorg")
      echo "Tilda reorg utility"
      echo "Usage: tilda reorg [options]"
      echo ""
      echo "Options:"
      echo "  -retry <count>   - Number of retries before moving on"
      echo "  -minSize <size>  - Minimum size in MB or GB of a table for reorg (e.g., 1024MB)"
      echo "  -resume          - Resume processing where it left off last"
      echo "  <schema>         - Optional schema name"
      echo "  <table>          - Optional table name"
      ;;
    "load")
      echo "Tilda load utility"
      echo "Usage: tilda load [options]"
      echo ""
      echo "Launches the data import utility."
      ;;
    "analyze")
      echo "Tilda database analyzer utility"
      echo "Usage: tilda analyze <analyzer.config.json>"
      echo ""
      echo "Analyzes database structure using the specified configuration file."
      ;;
    "check-db")
      echo "Tilda database connectivity check utility"
      echo "Usage: tilda check-db <driverClassName> <dbUrl> <user> <retries> <delay> <postWait>"
      echo ""
      echo "Checks database connectivity by verifying that a user could log on."
      echo "Example: tilda check-db \"org.postgresql.Driver\" \"jdbc:postgresql://localhost:5432/MyDB\" postgres 10 15 30"
      ;;
    *)
      show_usage
      ;;
  esac
}

# Main script logic
if [ $# -eq 0 ]; then
  show_usage
  exit 1
fi

COMMAND="$1"
shift

# Handle help command
if [ "$COMMAND" == "help" ]; then
  if [ $# -eq 0 ]; then
    show_usage
  else
    show_command_help "$1"
  fi
  exit 0
fi

# Check if command exists
MAIN_CLASS=$(get_main_class "$COMMAND")
if [ -z "$MAIN_CLASS" ] && [ "$COMMAND" != "help" ]; then
  echo "Unknown command: $COMMAND"
  echo ""
  show_usage
  exit 1
fi

# Execute the command
if [ "$COMMAND" != "help" ]; then
  # Check if the project is built
  if ! check_build; then
    exit 1
  fi
  
  echo "Running: $JAVA_CMD $JAVA_OPTS -cp $CLASSPATH $MAIN_CLASS $@"
  $JAVA_CMD $JAVA_OPTS -cp "$CLASSPATH" "$MAIN_CLASS" "$@"
fi
