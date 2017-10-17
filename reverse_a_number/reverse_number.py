number=input("Enter number: ")
length=len(number)+1
new_number=[]
for i in range(1,length):
    new_number.append(number[-i])
new_number="".join(new_number)
print (new_number)
