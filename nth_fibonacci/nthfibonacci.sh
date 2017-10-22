#!/bin/bash

function fibonacci {
    DATA=" "${DATA}
    X=0
    Y=1
    Z=0
    COUNTER=1
    while [ ${COUNTER} -le $1 ]; do

       DATA=${DATA}" "${X}

       Z=$((X+Y))
       X=${Y}
       Y=${Z}

       ((COUNTER++))
    done

    echo ${X}
}

if [[ $1 =~ ^[0-9]+$ ]]; then

    fibonacci $1

else
    echo "Usage: bash nthfibonacci.sh <count>"
fi
