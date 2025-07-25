#!/bin/bash
#
# Tilda Command Line Interface Auto-completion
#

_tilda_completions()
{
  local cur prev opts commands
  COMPREPLY=()
  cur="${COMP_WORDS[COMP_CWORD]}"
  prev="${COMP_WORDS[COMP_CWORD-1]}"
  
  # List of all available commands
  commands="gen migrate docs reverse reorg load analyze check-db help"
  
  # If we're completing the command name
  if [ $COMP_CWORD -eq 1 ]; then
    COMPREPLY=( $(compgen -W "${commands}" -- ${cur}) )
    return 0
  fi
  
  # Command-specific completions
  case "${prev}" in
    "gen")
      # Complete with .json files
      COMPREPLY=( $(compgen -f -X '!*.json' -- ${cur}) )
      return 0
      ;;
    "docs"|"analyze")
      # Complete with directories
      COMPREPLY=( $(compgen -d -- ${cur}) )
      return 0
      ;;
    "help")
      # Complete with command names
      COMPREPLY=( $(compgen -W "${commands}" -- ${cur}) )
      return 0
      ;;
    "reorg")
      if [[ ${cur} == -* ]]; then
        # Complete with options
        COMPREPLY=( $(compgen -W "-retry -minSize -resume" -- ${cur}) )
      fi
      return 0
      ;;
    *)
      # Default to file completion
      COMPREPLY=( $(compgen -f -- ${cur}) )
      return 0
      ;;
  esac
}

# Register the completion function
complete -F _tilda_completions tilda.sh
