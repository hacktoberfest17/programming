echo "Enter username:\c"
read logname
line=`grep $logname /etc/passwd`
IFS=:
set $line
echo "Username: $1"
echo "Userid: $3"
echo "Group id: $4"
echo "Comment: $5"
echo "Home: $6"
echo "Default shell: $7"
