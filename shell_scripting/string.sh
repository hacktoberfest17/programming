#0 corr. to true
#1 corr. to false
#String Checks

str1="Hey You!"
str2="Whats Up?"
str3=""

[ "$str1" = "$str2" ]
echo $?

[ "$str1" != "$str2" ]
echo $?

#to check if string is not null
[ -n "$str1" ]
echo $?

#to check if string is null
[ -z "$str3" ]
echo $?
