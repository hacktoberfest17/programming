
class stack():

    def __init__(self):
        self.items = []

    def isEmpty(self):
        return self.items == []

    def push (self,item):
        return self.items.append(item)

    def pop(self):
        return self.items.pop()

    def peek (self):
        return [(len(self.items)-1)]

    def size (self):
        return len(self.items)
    
stack = stack()

def bp():
    open_bracket='([{'
    close_bracket=')]}'
    operation = raw_input('Enter the parenthese-:')
        
    for i in operation:
        if i in open_bracket:
            stack.push(i)
        elif i in close_bracket:
            if stack.isEmpty()==True:
                return False
            else:
                if open_bracket.index(stack.pop())!= close_bracket.index(i):
                    return False
    if stack.isEmpty()==True:
        return True
    else:
        return False
                    
print bp()