#check if the given file exist in following dir or not
echo "Enter a name:\c"
read fname
#-f for file -d for dir
#-s for size 
if [ -f $fname ]
then 
echo "Yes its a file"
else
echo "No its not a file"
fi
