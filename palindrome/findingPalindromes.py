class Stack:
    def __init__(self):
        self.stkList=[]
    def isEmpty(self):
        return self.stkList==[]
    def length(self):
        return len(self.stkList)
    def push(self,items):
        self.stkList.append(items)
    def pop(self):
        if self.isEmpty():
            print "stack is empty you can not pop from empty stack"
        else:
            return self.stkList.pop()
    def peek(self):
        return (len(self.stkList)-1)

def palindrome():
    word=raw_input('Enter-:')
    s=Stack()
    rev_word=''
    for i in word:
        s.push(i)
    while s.isEmpty()==False:
        rev_word=rev_word+s.pop()
    if rev_word==word:
        return True
    else:
        return False

print palindrome()
