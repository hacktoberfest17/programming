import time #import the time module from python built-in-library

def main():
    start = input("Do you want to start a count down timer? 'Y'/'N' ") #Ask a user if ready to start a count down timer
    while start.lower == 'y':
        how_many_minute = int(input("How many minutes do you want to count down to? ")) #Ask the user for amount of minute to count
        limit = how_many_minute
        while how_many_minute >= 0:
            if how_many_minute == limit:
                print("Timer has started!")
                print(str(how_many_minute) + " minute left!")
                time.sleep(60) #pause the system for 60 seconds
                how_many_minute -= 1
            elif how_many_minute == 0:
                print("Time Up!")
                how_many_minute -= 1
            else:
                print(str(how_many_minute) + " minute left!")
                time.sleep(60) #pause the system for 60 seconds
                how_many_minute -= 1
        start = input("Do you want to start another count down timer? 'Y'/'N' ")
      
      
main() #call the main function
