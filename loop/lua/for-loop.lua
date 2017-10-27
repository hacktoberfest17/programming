-- Numeric for
-- for i=lower, upper, step do action end
for i = 10, 1, -1 do
  print("count: " .. i)
end

local size = {10, 6, 8, 12, 7} -- index starts with 1, not 0
local total = 0
for i = 1, #size, 1 do -- #size returns table length
  total = total + size[i]
end

print("\ntotal size is " .. total)

-- Generic for
-- for i, v in iterator do action end
-- there are two iterators: ipairs() and pairs()
print("\nipairs() iterates in numeric order")
for i,v in ipairs(size) do
  print(i , v)
end

local dictionary = {
  helloWorld  = "greetings",
  LOVE        = "2D games framework in Lua",
  z           = nil,
  git         = "version control system"
}

print("\npairs() iterates every key that has non-nil value in no order")
for key,val in pairs(dictionary) do
  print(key , val)
end