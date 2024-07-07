#!/usr/bin/env bash
# Use this script to test if a given TCP host/port are available

TIMEOUT=15
QUIET=0
HOST="$1"
PORT="$2"

echoerr() { if [ "$QUIET" -ne 1 ]; then echo "$@" 1>&2; fi }

usage() {
    cat << USAGE >&2
Usage:
    $0 host:port [-t timeout] [-- command args]
    -q | --quiet                        Do not output any status messages
    -t TIMEOUT | --timeout=timeout      Timeout in seconds, zero for no timeout
    -- COMMAND ARGS                     Execute command with args after the test finishes
USAGE
    exit 1
}

wait_for() {
    if [[ $TIMEOUT -gt 0 ]]; then
        echoerr "$0: waiting $TIMEOUT seconds for $HOST:$PORT"
    else
        echoerr "$0: waiting for $HOST:$PORT without a timeout"
    fi
    start_ts=$(date +%s)
    while :
    do
        if [[ $TIMEOUT -gt 0 ]]; then
            now_ts=$(date +%s)
            elapsed=$((now_ts - start_ts))
            if [[ $elapsed -ge $TIMEOUT ]]; then
                echoerr "$0: timeout occurred after waiting $TIMEOUT seconds for $HOST:$PORT"
                exit 1
            fi
        fi
        nc -z "$HOST" "$PORT"
        result=$?
        if [[ $result -eq 0 ]]; then
            break
        fi
        sleep 1
    done
    echoerr "$0: $HOST:$PORT is available after $elapsed seconds"
}

wait_for

exec "$@"
