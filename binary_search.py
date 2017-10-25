low = 0
high = 100
answer = 0

print("Please think of a number between 0 and 100!")
answer = (low+high)//2
print("Is your secret number " + str(answer) + "?")
hlc = input("Enter 'h' to indicate the guess is too high. Enter 'l' to indicate the guess is too low. Enter 'c' to indicate I guessed correctly. ")


while True:    
    while hlc != 'h' and hlc != 'l' and hlc != 'c':
        print("Sorry, I did not understand your input.")
        print("Is your secret number " + str(answer) + "?")
        hlc = input("Enter 'h' to indicate the guess is too high. Enter 'l' to indicate the guess is too low. Enter 'c' to indicate I guessed correctly. ")

    if hlc == 'h':
        high = answer
        answer = (low+high)//2
        print("Is your secret number " + str(answer) + "?")
        hlc = input("Enter 'h' to indicate the guess is too high. Enter 'l' to indicate the guess is too low. Enter 'c' to indicate I guessed correctly. ")

    elif hlc == 'l':
        low = answer
        answer = (low+high)//2
        print("Is your secret number " + str(answer) + "?")
        hlc = input("Enter 'h' to indicate the guess is too high. Enter 'l' to indicate the guess is too low. Enter 'c' to indicate I guessed correctly. ")
    else:
        print("Game over. Your secret number was: " + str(answer))
        break
    
 
    

