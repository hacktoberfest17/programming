#!/bin/bash

read -p "Enter your birth year (Ex. 1900): " BIRTHYEAR
read -p "Enter your birth month (Ex. 1): " BIRTHMONTH
read -p "Enter the current year (Ex. 2017): " CURRENTYEAR
read -p "Enter the current month (Ex. 1): " CURRENTMONTH

if (( BIRTHMONTH > CURRENTMONTH )); then
    CURRENTYEAR=$((CURRENTYEAR-1))
fi

echo "Your age is "$((CURRENTYEAR-BIRTHYEAR))" years old"

