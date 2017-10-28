#!/bin/bash
array=(-1 9 5 100 98 57 3 0) #collect arguments
tot=$((${#array[@]}-1)) #zero based
i=0

while [ $i -lt $tot ]
do
        k=0 #reset k's val
        while [ $k -lt $tot ]
        do
                if [ ${array[$k+1]} -lt ${array[$k]} ]
                then
                        temp=${array[$k]}
                        array[$k]=${array[$k+1]}
                        array[$k+1]=$temp
                fi
                #echo ${array[@]}
        ((k++))
        done
        #echo
((i++))
done
echo ${array[@]}
#-1 0 3 5 9 57 98 100
