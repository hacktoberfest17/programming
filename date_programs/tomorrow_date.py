import datetime #import the python built-in-library of 'datetime'

def main(): #define main function
    return str(datetime.date.today() + datetime.timedelta(days=1))  #return tomorrow's date
    
   
main()  #call the main function
