'''
A Programme to find whether a number
is prime or not
'''
# Function to check prime
def prime_checker(user_input):
  flag = 0
  if user_input > 1:
    if user_input == 2:
      print('Prime')
    elif user_input != 2:
      for i in range(2, user_input):
        if user_input % i == 0:
          print('Not Prime')
          flag = 1
          break
      if flag == 0:
        print('Prime')
  else:
    print('Not Prime nor Composite')

# Take the input from the User
user_input = int(input('Enter the Number\n'))

# Call Prime Checker Function
prime_checker(user_input)

