@echo off
REM
REM Tilda Command Line Interface
REM A unified interface for running Tilda utilities
REM

REM Set default environment variables if not already set
if "%JAVA_HOME%"=="" (
  set JAVA_CMD=java
) else (
  set JAVA_CMD=%JAVA_HOME%\bin\java
)

if "%JAVA_OPTS%"=="" set JAVA_OPTS=-Xms192M -Xmx512M
if "%LIB%"=="" set LIB=%~dp0..\lib
if "%BIN%"=="" set BIN=%~dp0..\bin
if "%CLASSPATH%"=="" (
  set CLASSPATH=%BIN%;%LIB%\*;.
) else (
  set CLASSPATH=%CLASSPATH%;%BIN%;%LIB%\*;.
)

REM Check if the project is built
call :check_build
if %ERRORLEVEL% NEQ 0 goto :eof

REM Parse command
if "%~1"=="" goto :usage
set COMMAND=%~1
shift

if "%COMMAND%"=="gen" (
  set MAIN_CLASS=tilda.Gen
) else if "%COMMAND%"=="migrate" (
  set MAIN_CLASS=tilda.Migrate
) else if "%COMMAND%"=="docs" (
  set MAIN_CLASS=tilda.Docs
) else if "%COMMAND%"=="reverse" (
  set MAIN_CLASS=tilda.Reverse
) else if "%COMMAND%"=="reorg" (
  set MAIN_CLASS=tilda.Reorg
) else if "%COMMAND%"=="load" (
  set MAIN_CLASS=tilda.Load
) else if "%COMMAND%"=="analyze" (
  set MAIN_CLASS=tilda.DBAnalyzer
) else if "%COMMAND%"=="check-db" (
  set MAIN_CLASS=tilda.CheckDB
) else if "%COMMAND%"=="help" (
  goto :help
) else (
  echo Unknown command: %COMMAND%
  echo.
  goto :usage
)

REM Execute the command
echo Running: %JAVA_CMD% %JAVA_OPTS% -cp %CLASSPATH% %MAIN_CLASS% %*
%JAVA_CMD% %JAVA_OPTS% -cp %CLASSPATH% %MAIN_CLASS% %*
goto :eof

:check_build
if not exist "%BIN%\" (
  echo Error: Tilda project is not built yet.
  echo Please run "build.cmd" first to compile the project.
  exit /b 1
)
dir /b "%BIN%\*" >nul 2>&1
if %ERRORLEVEL% NEQ 0 (
  echo Error: Tilda project is not built yet.
  echo Please run "build.cmd" first to compile the project.
  exit /b 1
)
exit /b 0

:usage
echo Tilda Command Line Interface
echo Usage: tilda ^<command^> [options]
echo.
echo Available commands:
echo   gen       - Generate code from Tilda schema definitions
echo   migrate   - Migrate database to match Tilda schema definitions
echo   docs      - Generate documentation for Tilda schemas
echo   reverse   - Reverse engineer database schema to Tilda JSON
echo   reorg     - Reorganize database tables
echo   load      - Load data into database
echo   analyze   - Analyze database structure
echo   check-db  - Check database connectivity
echo   help      - Show this help message or help for a specific command
echo.
echo Environment variables:
echo   JAVA_HOME - Java installation directory
echo   JAVA_OPTS - JVM options (default: -Xms192M -Xmx512M)
echo   LIB       - Library directory (default: ./lib)
echo   CLASSPATH - Additional classpath entries
echo.
echo For more information on a specific command, use: tilda help ^<command^>
goto :eof

:help
if "%~1"=="" goto :usage

if "%~1"=="gen" (
  echo Tilda code generation utility
  echo Usage: tilda gen ^<schema.json^> [^<schema2.json^> ...]
  echo.
  echo Takes one or more paths to Tilda JSON schema files and generates:
  echo   - Java code
  echo   - Database migration scripts
  echo   - Documentation
) else if "%~1"=="migrate" (
  echo Tilda migration utility
  echo Usage: tilda migrate
  echo.
  echo Migrates the database connected via the 'MAIN' connection in tilda.config.json
  echo using all Tilda schema definitions found in JARs in the classpath.
) else if "%~1"=="docs" (
  echo Tilda documentation utility
  echo Usage: tilda docs ^<output-folder^>
  echo.
  echo Takes one mandatory parameter, a folder where to put the documentation files
  echo from active Tilda schemas in the classpath.
) else if "%~1"=="reverse" (
  echo Tilda reverse utility
  echo Usage: tilda reverse ^<schema^> [^<table^>]
  echo.
  echo Reverse engineers a whole Schema or Table from the database and generates a tilda.json file.
  echo   - ^<schema^>: The name of the schema to reverse engineer
  echo   - ^<table^>: Optional, the name of a specific table to reverse engineer
) else if "%~1"=="reorg" (
  echo Tilda reorg utility
  echo Usage: tilda reorg [options]
  echo.
  echo Options:
  echo   -retry ^<count^>   - Number of retries before moving on
  echo   -minSize ^<size^>  - Minimum size in MB or GB of a table for reorg (e.g., 1024MB)
  echo   -resume          - Resume processing where it left off last
  echo   ^<schema^>         - Optional schema name
  echo   ^<table^>          - Optional table name
) else if "%~1"=="load" (
  echo Tilda load utility
  echo Usage: tilda load [options]
  echo.
  echo Launches the data import utility.
) else if "%~1"=="analyze" (
  echo Tilda database analyzer utility
  echo Usage: tilda analyze ^<analyzer.config.json^>
  echo.
  echo Analyzes database structure using the specified configuration file.
) else if "%~1"=="check-db" (
  echo Tilda database connectivity check utility
  echo Usage: tilda check-db ^<driverClassName^> ^<dbUrl^> ^<user^> ^<retries^> ^<delay^> ^<postWait^>
  echo.
  echo Checks database connectivity by verifying that a user could log on.
  echo Example: tilda check-db "org.postgresql.Driver" "jdbc:postgresql://localhost:5432/MyDB" postgres 10 15 30
) else (
  goto :usage
)
goto :eof
