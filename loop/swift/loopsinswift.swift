let list = ["imperative", "functional", "declarative", "object oriented", "procedural", "logic", "symbolic"]

////
list.forEach { (programmingType) in
    print(programmingType)
}

////
for type in list {
    print(type)
}

for i in 0..<list.count {
    print(list[i])
}

///
var i = 0
repeat {
    print(list[i])
    i = i + 1
    
}
    while i < list.count


var j=0
while j < list.count {
    print(list[j])
    j = j + 1
}
