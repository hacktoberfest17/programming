import datetime

date = datetime.datetime.now()

if date.month == 10 and date.day == 31:
    print("Happy Halloween!")
elif (date.month == 10):
    print("It's October, but today is not Halloween!")
else:
    print("It's not October.")
