#if - else - then in action
echo "Enter source and target file name"
read source target
if mv $source $target
#starting if
then
echo "Your file has been succesfully renamed"
else 
echo "Cant rename"
fi #closing if

