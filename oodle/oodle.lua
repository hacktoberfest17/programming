
local oodle = ""

for c in arg[1]:gmatch"." do
  if (c == "a") or (c == "e") or (c == "i") or (c == "o") or (c == "u") then
    oodle = oodle .. "oodle"
  else
    oodle = oodle .. c
  end
end

print(oodle)

