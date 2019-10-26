#!/bin/bash

DATE_MONTH=`date +%m`
DATE_DAY=`date +%d`

if [ $DATE_MONTH == "10" ] && [ $DATE_DAY == "31" ] ; then
	echo "Is Halloween!"
elif [ $DATE_MONTH == "10" ] && [ $DATE_DAY != "31" ] ; then
	echo "Is October but not Halloween yet!"
else
	echo "Is not October!"
fi
