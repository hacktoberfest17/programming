#!/bin/bash
# Based on
# https://github.com/hacktoberfest17/programming/blob/master/babylonian_square_root/babylonian_square_root.js
function squareRoot {
    E="0.00000001"
    INPUT="$1"
    X="${INPUT}"
    Y="1"
    RESULT="false"
    while [ $(echo "(${X} - ${Y}) > ${E}" | bc -l) == "1" ]; do
        X="$(echo "(${X} + ${Y}) / 2" | bc -l)"
        Y="$(echo "${INPUT} / ${X}" | bc -l)"
    done
    RESULT="${X}"
}


squareRoot $1
echo ${RESULT}
