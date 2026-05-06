@echo off
REM
REM Tilda Build Script
REM Compiles the Tilda source code and creates necessary directories
REM

REM Set default environment variables if not already set
if "%JAVA_HOME%"=="" (
  set JAVAC_CMD=javac
) else (
  set JAVAC_CMD=%JAVA_HOME%\bin\javac
)

REM Set directory paths
set PROJECT_ROOT=%~dp0..\
set LIB=%PROJECT_ROOT%lib
set SRC=%PROJECT_ROOT%src
set SRC_ANTLR=%PROJECT_ROOT%src-antlr4
set BIN=%PROJECT_ROOT%bin

REM Create bin directory if it doesn't exist
if not exist "%BIN%" mkdir "%BIN%"

REM Build classpath from lib directory
setlocal EnableDelayedExpansion
set CLASSPATH=
for /R "%LIB%" %%G in (*.jar) do (
  if "!CLASSPATH!"=="" (
    set CLASSPATH=%%G
  ) else (
    set CLASSPATH=!CLASSPATH!;%%G
  )
)

echo ===== Tilda Build Script =====
echo Java compiler: %JAVAC_CMD%
echo Source directory: %SRC%
echo Output directory: %BIN%
echo Library directory: %LIB%

REM Find and compile Java files
echo Finding and compiling Java source files...
dir /s /b "%SRC%\*.java" > "%TEMP%\tilda_sources.txt"
dir /s /b "%SRC_ANTLR%\*.java" >> "%TEMP%\tilda_sources.txt" 2>nul
%JAVAC_CMD% -d "%BIN%" -cp "%CLASSPATH%" -source 1.8 -target 1.8 -Xlint:deprecation @"%TEMP%\tilda_sources.txt"

if %ERRORLEVEL% EQU 0 (
  echo Build successful! Output directory: %BIN%
  echo You can now run Tilda commands using the tilda.cmd script
) else (
  echo Build failed. Please check the error messages above.
  exit /b 1
)
