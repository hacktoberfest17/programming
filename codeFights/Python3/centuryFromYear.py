#Return the century of the given year
def centuryFromYear(year):
	if year % 100 is 0:
		yearCount = year/100
	else:
		yearCount = year/100 + 1

	return int(yearCount)


print(centuryFromYear(2001))


# yearCount = 0
#     year = str(year)
#     splitYear = [int(d) for d in year]

#     twoDigits = str(splitYear[0]) + str(splitYear[1])
#     twoDigits = int(twoDigits)
#     while twoDigits is not 0:
#     	twoDigits-=1
#     	yearCount+=1

#     if splitYear[3] >= 1 or splitYear[2] >= 1:
#     	yearCount+=1

#     print(yearCount)