#!/bin/bash

n=$1
a=$(basename $n .txt)
echo $a
b=$(date +'%d-%m-%y')
c="$a"_"$b".txt
cp $n $c