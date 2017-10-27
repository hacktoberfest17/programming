-- while boolean do action end
sf=string.format
local n = 10
local i

while (n > 0)
do
  print("count: " .. n)
  n = n - 1
end

list = {"one", "two", "three", sth="wrong", hello="world"}
list[5] = "five"

print("\nall defined integer keys")
i = 1
while list[i] do
  print(sf("key=%s, value=%s", tostring(i), tostring(list[i])))
  i = i + 1
end


print("\nall integer keys from 1 to #list")
i = 1
while i <= #list do
  print(sf("key=%s, value=%s", tostring(i), tostring(list[i])))
  i = i + 1
end

print("\nall integer keys despite nil values")
i = 1
while i <= table.maxn(list) do
  print(sf("key=%s, value=%s", tostring(i), tostring(list[i])))
  i = i + 1
end

print("\nall integer and non-integer keys with no order")
local k, v
k, v = next(list, nil)
while k do
  print(sf("key=%s, value=%s", tostring(k), tostring(v)))
  k, v = next(list, k)
end

