#internal field separators
line="Shell scripting is fun."
#making : the ifs instead of space
IFS=:
set $line
echo $1
echo $2
echo $3
echo $4
