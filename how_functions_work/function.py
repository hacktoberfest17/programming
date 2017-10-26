A function is a mini-program within a program. A function makes a program easier to write, read, test and fix.
An example of a simple function is:
def hello_world():
    """Display a simple hello world"""
    print("Hello World!")
    
hello_world()   #Display "Hello World!" on the console

Function with parameters: You can also define a function that accept arguments. A simple example is:
def hello_user(name):
    """Display a customised hello with person's name"""
    print("Hello " + name + "!")
    
hello_user("John")   #Display "Hello John!" on the console

A function can also have multiple parameter. For example:
def user_detail(name, location):
    """Display a person's name and location based on the supplied arguments."""
    print("My name is: " + name + " and, I am from: " + location + ".")
    
user_detail("Doe", "Sydney")

A function can also have a default value for each parameter. Example is:
def hello_user(name='Alice'):
    print("Hello " + name)

hello_user() #Display "Hello Alice" in the console
hello_user("John") #Display "Hello John" in the console
hello_user(name='Doe') #Display "Hello Doe" in the console

A function can also have return value using the 'return' keyword. For example:
def even_or_odd(x):
    """Return even or odd depending on the value of x"""
    if x % 2 == 0:
        return "even"
    else:
        return "odd"
        
even_or_odd(5) #Display odd on the console
even_or_odd(10) #Display even on the console

Python also have a function called Anonymous or Lambda function. Anonymous/Lambda function is a function that is defined
without a name. While a normal function are defined using the 'def' keyword, in Python anonymous function are defined using
the 'lambda' keyword.
It has the syntax: lambda arguments : expression
For example:
double = lambda x : x ** 2
print(double(2))   #Print the value of 4 to the console

The above lambda function is the same as:
def double(x):
    return x ** 2
    
double(2)

