print("Year of birth, eg. 1990: ")
birth_year = parse(UInt16, readline())

print("Current year, eg. 2017: ")
current_year = parse(UInt16, readline())

print("Month of birth, eg. 03: ")
birth_month = parse(Int8, readline())

print("Current month, eg. 10: ")
current_month = parse(Int8, readline())

year_diff = current_year - birth_year
month_diff = current_month - birth_month

if month_diff < 0
	year_diff = year_diff - 1
	month_diff = (current_month + 12) - birth_month
end

@printf "\nYou are %d year(s) and %d month(s) old.\n" year_diff month_diff
