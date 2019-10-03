#! /bin/bash
# check to see if site is up
#   if it is, don't worry
#


# 7 is the return code of `curl` if it cannot load the page
ERRCOD='7'
WHEN=`date +%d%b%y`
REPT="/var/tmp/$1.$WHEN.txt"
STARS='********************'

# $1 is the command-line arg for the domain
# you could hardcode this, too
curl -I $1 > /var/tmp/curlret.txt

# $? is the exit code of the last-run script
if [ "$?" = "$ERRCOD" ]; then
    # return was unable to connect to host: save ps -aux; mail report
    echo $STARS >> $REPT
    echo 'curl return results' >> $REPT
    echo >> $REPT
    cat curlret.txt >> $REPT
    echo >> $REPT
    echo $STARS >> $REPT
    # mail the whole works to myself
    mail -s "failed to connect to $1" your.user@example.com < $REPT
fi

rm -f /var/tmp/curlret.txt
rm -f $REPT
