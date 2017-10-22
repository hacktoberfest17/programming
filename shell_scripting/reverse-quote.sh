#using 2 commands together using reverse quote `
#renames a file to file.name
#where name is the login name of the user
name=$1
set `who`
mv $name $name.$1
