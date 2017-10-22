echo "Enter a character:\c"
read var
case $var in
#matching var to from a to z 
[a-z])
echo "You entered a lowercase alphabet"
;;
#for ending case ;;
[A-Z]) 
echo "You entered a uppercase alphabet"
;;
[0-9])
echo "You entered a digit"
;;
?) 
echo "You entered a special character"
;; 
*)  
echo "You entered multiple characters"
;;
esac
