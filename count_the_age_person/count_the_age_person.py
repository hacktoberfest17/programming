print ("\t\t*******Count the age person********\n\n")
birthYear = int(input("Enter Your Birth Year(Eg:1989): "))
birthMonth = int(input("\nEnter Your Birth Month(Eg:7): "))
currentYear = int(input("\nEnter The Current Year(Eg:2016): "))
currentMonth = int(input("\nEnter The Current Month(Eg:7): "))

ageYear = currentYear - birthYear
ageMonth = currentMonth - birthMonth

if ageMonth == 0:
    print ("\n\n\t\tYour age is", ageYear, "Years")

elif ageMonth == 1:
    print ("\n\n\t\tYour age is", ageYear, "Years And",ageMonth,"Month")
    
else:
    print ("\n\n\t\tYour age is", ageYear, "Years And",ageMonth,"Months")
