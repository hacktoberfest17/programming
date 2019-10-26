#Func for addition
def add(a, b):
  return a + b

#Func for subtraction
def sub(a, b):
  return a - b

#Func for multiplication
def multi(a, b):
  return a * b

#Func for division
def div(a, b):
  return a / b

#Ask what the user want to do
print("Waht do you want to do?")
print("1. Addition")
print("2. Subtraction")
print("3. Multiplication")
print("4. Division")

#Get what the user want to do
inp = input("Enter: 1, 2, 3 or 4: ")

#Getting the values for the math
num1 = int(input("Enter the first number: "))
num2 = int(input("Enter the second number: "))

if inp == '1':
  print(add(num1,num2))
elif inp == '2':
   print(sub(num1,num2))
elif inp == '3':
   print(multi(num1,num2))
elif inp == '4':
    if num2 == '0'
   print(div(num1,num2))
