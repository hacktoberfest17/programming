#Language: python
#Author: Kaywinnet

print(" _____________")
print("|RULE OF THREE|")
print(" ‾‾‾‾‾‾‾‾‾‾‾‾‾")
print("For an equation of the form:")
print("a -------> b")
print("x -------> c")
print("where x is unknown,", end = ' ')
a = float(input("enter a:"))
b = float(input("Now, enter b:"))
c = float(input("Finally, enter c:"))

x = (a*c)/b

print("The value of x is:", x)
