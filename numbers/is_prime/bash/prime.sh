#!/bin/bash
# Bash implementation of 
# https://github.com/hacktoberfest17/programming/blob/master/prime_number/c/prime_number.c


function isPrime {
    INPUT=$1
    COUNTER=3
    RESULT=true
    if (( INPUT < 2 )); then
        RESULT=false
    elif (( INPUT == 2 )); then
        RESULT=true
    elif (( INPUT % 2 == 0 )); then
        RESULT=false
    else
        X=$(echo "sqrt(${INPUT})" | bc)
        while (( COUNTER <= X )); do
            if (( INPUT % COUNTER == 0 )); then
                RESULT=false
            fi
            ((COUNTER++))
        done       
    fi
}

isPrime $1
if [[ "${RESULT}" == "true" ]]; then
    echo "It's a prime!"
else
    echo "It's not a prime!"
fi
